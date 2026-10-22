package io.noties.a.a;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static io.noties.a.h.a a(io.noties.a.h r5) {
        return io.noties.a.h.a("brainfuck", new io.noties.a.h.f[]{io.noties.a.h.a("pointer", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("<|>"), false, false, "keyword")}), io.noties.a.h.a("increment", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\+"), false, false, "inserted")}), io.noties.a.h.a("decrement", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("-"), false, false, "deleted")}), io.noties.a.h.a("branching", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\[|\\]"), false, false, "important")}), io.noties.a.h.a("operator", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("[.,]"))}), io.noties.a.h.a("comment", new io.noties.a.h.c[]{io.noties.a.h.a(Pattern.compile("\\S+"))})});
    }
}
