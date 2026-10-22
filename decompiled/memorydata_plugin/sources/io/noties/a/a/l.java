package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class l {
    public static io.noties.a.h.a a(io.noties.a.h r8) {
        io.noties.a.h.a r9 = io.noties.a.f.b(io.noties.a.f.a(r8, "clike"), "groovy", new io.noties.a.h.f[]{io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:as|def|in|abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|trait|transient|try|void|volatile|while)\\b"))}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\"\"\"|''')[\\s\\S]*?\\1|(?:\\$\\/)(?:\\$\\/\\$|[\\s\\S])*?\\/\\$"), false, true), io.noties.a.h.a(Pattern.compile("([\"'\\/])(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:0b[01_]+|0x[\\da-f_]+(?:\\.[\\da-f_p\\-]+)?|[\\d_]+(?:\\.[\\d_]+)?(?:e[+-]?[\\d]+)?)[glidf]?\\b", 2))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^.])(?:~|==?~?|\\?[.:]?|\\*(?:[.=]|\\*=?)?|\\.[@&]|\\.\\.<|\\.{1,2}(?!\\.)|-[-=>]?|\\+[+=]?|!=?|<(?:<=?|=>?)?|>(?:>>?=?|=)?|&[&=]?|\\|[|=]?|\\/=?|\\^=?|%=?)"), true)}), io.noties.a.h.a("punctuation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\.+|[{}\\[\\];(),:$]"))})});
        io.noties.a.f.a(r9, TypedValues.Custom.S_STRING, new io.noties.a.h.f[]{io.noties.a.h.a("shebang", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("#!.+"), false, false, "comment")})});
        io.noties.a.f.a(r9, "punctuation", new io.noties.a.h.f[]{io.noties.a.h.a("spock-block", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:setup|given|when|then|and|cleanup|expect|where):"))})});
        io.noties.a.f.a(r9, "function", new io.noties.a.h.f[]{io.noties.a.h.a("annotation", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(^|[^.])@\\w+"), true, false, "punctuation")})});
        return r9;
    }
}
