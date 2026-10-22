package tka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c {
    public static volatile b a;

    static {
        a = new b(false);
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter("ContextAwareness", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        a.a(r2);
    }

    public static void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        a.c(r1, r2);
    }

    public static void d(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        a.d(r1, r2);
    }

    public static void b(String r0, String r1, Throwable r2) {
        Intrinsics.checkNotNullParameter(r0, "tag");
        Intrinsics.checkNotNullParameter(r1, "msg");
        a.b(r0, r1);
    }
}
