package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class v {
    public static io.noties.a.h.a a(io.noties.a.h r7) {
        io.noties.a.h.a r8 = io.noties.a.f.a(io.noties.a.f.a(r7, "java"), "scala", new AnonymousClass1(), new io.noties.a.h.f[]{io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("<-|=>|\\b(?:abstract|case|catch|class|def|do|else|extends|final|finally|for|forSome|if|implicit|import|lazy|match|new|null|object|override|package|private|protected|return|sealed|self|super|this|throw|trait|try|type|val|var|while|with|yield)\\b"))}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\"\"\"[\\s\\S]*?\"\"\""), false, true), io.noties.a.h.a(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)}), io.noties.a.h.a("number", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b0x[\\da-f]*\\.?[\\da-f]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e\\d+)?[dfl]?", 2))})});
        r8.b().add(io.noties.a.h.a("symbol", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("'[^\\d\\s\\\\]\\w*"))}));
        io.noties.a.f.a(r8, "number", new io.noties.a.h.f[]{io.noties.a.h.a("builtin", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:String|Int|Long|Short|Byte|Boolean|Double|Float|Char|Any|AnyRef|AnyVal|Unit|Nothing)\\b"))})});
        return r8;
    }
}
