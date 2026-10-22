package io.noties.a.a;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class m {
    public static io.noties.a.h.a a(io.noties.a.h r10) {
        io.noties.a.h.f r1 = io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:abstract|continue|for|new|switch|assert|default|goto|package|synchronized|boolean|do|if|private|this|break|double|implements|protected|throw|byte|else|import|public|throws|case|enum|instanceof|return|transient|catch|extends|int|short|try|char|final|interface|static|void|class|finally|long|strictfp|volatile|const|float|native|super|while)\\b"))});
        io.noties.a.h.a r11 = io.noties.a.f.b(io.noties.a.f.a(r10, "clike"), "java", new io.noties.a.h.f[]{r1, io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b0b[01]+\\b|\\b0x[\\da-f]*\\.?[\\da-fp-]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?[df]?", 2))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^.])(?:\\+[+=]?|-[-=]?|!=?|<<?=?|>>?>?=?|==?|&[&=]?|\\|[|=]?|\\*=?|\\/=?|%=?|\\^=?|[?:~])", 8), true)})});
        io.noties.a.f.a(r11, "function", new io.noties.a.h.f[]{io.noties.a.h.a("annotation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^.])@\\w+"), true, false, "punctuation")})});
        io.noties.a.f.a(r11, "class-name", new io.noties.a.h.f[]{io.noties.a.h.a("generics", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("<\\s*\\w+(?:\\.\\w+)?(?:\\s*,\\s*\\w+(?:\\.\\w+)?)*>", 2), false, false, "function", io.noties.a.h.a("inside", new io.noties.a.h.f[]{r1, io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[<>(),.:]"))})}))})});
        return r11;
    }
}
