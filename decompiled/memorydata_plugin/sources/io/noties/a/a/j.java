package io.noties.a.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class j {
    public static io.noties.a.h.a a(io.noties.a.h r8) {
        return io.noties.a.h.a("git", new io.noties.a.h.f[]{io.noties.a.h.a("comment", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^#.*", 8))}), io.noties.a.h.a("deleted", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^[-–].*", 8))}), io.noties.a.h.a("inserted", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^\\+.*", 8))}), io.noties.a.h.a(TypedValues.Custom.S_STRING, new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1", 8))}), io.noties.a.h.a("command", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^.*\\$ git .*$", 8), false, false, null, io.noties.a.h.a("inside", new io.noties.a.h.f[]{io.noties.a.h.a("parameter", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\s--?\\w+", 8))})}))}), io.noties.a.h.a("coord", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^@@.*@@$", 8))}), io.noties.a.h.a("commit_sha1", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("^commit \\w{40}$", 8))})});
    }
}
