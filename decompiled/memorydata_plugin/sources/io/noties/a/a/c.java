package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public abstract class c {
    public static io.noties.a.h.a a(io.noties.a.h r8) {
        return io.noties.a.h.a("clike", new io.noties.a.h.f[]{io.noties.a.h.a("comment", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^\\\\])\\/\\*[\\s\\S]*?(?:\\*\\/|$)"), true), io.noties.a.h.a(Pattern.compile("(^|[^\\\\:])\\/\\/.*"), true, true)}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)}), io.noties.a.h.a("class-name", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("((?:\\b(?:class|interface|extends|implements|trait|instanceof|new)\\s+)|(?:catch\\s+\\())[\\w.\\\\]+"), true, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[.\\\\]"))})}))}), io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:if|else|while|do|for|return|in|instanceof|function|new|try|throw|catch|finally|null|break|continue)\\b"))}), io.noties.a.h.a(TypedValues.Custom.S_BOOLEAN, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:true|false)\\b"))}), io.noties.a.h.a("function", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[a-z0-9_]+(?=\\()", 2))}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b0x[\\da-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?", 2))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("--?|\\+\\+?|!=?=?|<=?|>=?|==?=?|&&?|\\|\\|?|\\?|\\*|\\/|~|\\^|%"))}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[{}\\[\\];(),.:]"))})});
    }
}
