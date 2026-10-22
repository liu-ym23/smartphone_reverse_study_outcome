package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class i {
    public static io.noties.a.h.a a(io.noties.a.h r6) {
        io.noties.a.h.a r7 = io.noties.a.f.b(io.noties.a.f.a(r6, "clike"), "dart", new io.noties.a.h.f[]{io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("r?(\"\"\"|''')[\\s\\S]*?\\1"), false, true), io.noties.a.h.a(Pattern.compile("r?(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)}), io.noties.a.h.a("keyword", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\b(?:async|sync|yield)\\*")), io.noties.a.h.a(Pattern.compile("\\b(?:abstract|assert|async|await|break|case|catch|class|const|continue|default|deferred|do|dynamic|else|enum|export|external|extends|factory|final|finally|for|get|if|implements|import|in|library|new|null|operator|part|rethrow|return|set|static|super|switch|this|throw|try|typedef|var|void|while|with|yield)\\b"))}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\bis!|\\b(?:as|is)\\b|\\+\\+|--|&&|\\|\\||<<=?|>>=?|~(?:\\/=?)?|[+\\-*\\/%&^|=!<>]=?|\\?"))})});
        io.noties.a.f.a(r7, "function", new io.noties.a.h.f[]{io.noties.a.h.a("metadata", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("@\\w+"), false, false, "symbol")})});
        return r7;
    }
}
