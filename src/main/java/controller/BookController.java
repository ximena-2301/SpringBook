package com.example.taller.controller;

import com.example.taller.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @GetMapping("/book")
    public String showBookInfo(
            @RequestParam(name = "title", required = false, defaultValue = "Unknown Title") String title,
            @RequestParam(name = "author", required = false, defaultValue = "Unknown Author") String author,
            @RequestParam(name = "year", required = false, defaultValue = "2000") int year,
            Model model) {

        // Crear objeto Book con los parámetros proporcionados
        Book book = new Book(title, author, year);

        // Agregar el objeto Book al modelo
        model.addAttribute("book", book);

        // Devolver el nombre de la vista HTML (book.html)
        return "book";
    }
}