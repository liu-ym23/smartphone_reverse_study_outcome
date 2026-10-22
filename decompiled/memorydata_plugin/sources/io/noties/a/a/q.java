package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class q {
    public static io.noties.a.h.a a(io.noties.a.h r8) {
        Pattern r9 = Pattern.compile("\\\\(?:[^a-z()\\[\\]]|[a-z*]+)", 2);
        io.noties.a.h.a r2 = io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("equation-command", new io.noties.a.h.c[]{io.noties.a.h.a(r9, false, false, "regex")})});
        return io.noties.a.h.a("latex", new io.noties.a.h.f[]{io.noties.a.h.a("comment", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("%.*", 8))}), io.noties.a.h.a("cdata", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\\\\begin\\{((?:verbatim|lstlisting)\\*?)\\})[\\s\\S]*?(?=\\\\end\\{\\2\\})"), true)}), io.noties.a.h.a("equation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\$(?:\\\\[\\s\\S]|[^\\\\$])*\\$|\\\\\\([\\s\\S]*?\\\\\\)|\\\\\\[[\\s\\S]*?\\\\\\]"), false, false, TypedValues.Custom.S_STRING, r2), io.noties.a.h.a(Pattern.compile("(\\\\begin\\{((?:equation|math|eqnarray|align|multline|gather)\\*?)\\})[\\s\\S]*?(?=\\\\end\\{\\2\\})"), true, false, TypedValues.Custom.S_STRING, r2)}), io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\\\\(?:begin|end|ref|cite|label|usepackage|documentclass)(?:\\[[^\\]]+\\])?\\{)[^}]+(?=\\})"), true)}), io.noties.a.h.a("url", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\\\\url\\{)[^}]+(?=\\})"), true)}), io.noties.a.h.a("headline", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\\\\(?:part|chapter|section|subsection|frametitle|subsubsection|paragraph|subparagraph|subsubparagraph|subsubsubparagraph)\\*?(?:\\[[^\\]]+\\])?\\{)[^}]+(?=\\}(?:\\[[^\\]]+\\])?)"), true, false, "class-name")}), io.noties.a.h.a("function", new io.noties.a.h.c[]{io.noties.a.h.a(r9, false, false, "selector")}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[\\[\\]{}&]"))})});
    }
}
