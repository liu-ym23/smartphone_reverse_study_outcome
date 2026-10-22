package dka;

import cka.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements b {
    public static final a a = null;
    public static b b;

    /* JADX INFO: renamed from: dka.a$a, reason: collision with other inner class name */
    public static final class C0014a implements b {
        public C0014a() {
        }

        public final void d(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            gka.b.a(r2, r3);
        }

        public final void i(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
            gka.b.c(r2, r3);
        }

        public final void w(String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "tag");
            Intrinsics.checkNotNullParameter(r5, "msg");
            int r2 = gka.b.a;
            Intrinsics.checkNotNullParameter(r4, "tag");
            Intrinsics.checkNotNullParameter(r5, "msg");
            bka.a r6 = bka.a.a;
        }

        public final void e(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, "tag");
            Intrinsics.checkNotNullParameter(r2, "msg");
            gka.b.b(r1, r2);
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new C0014a();
    }

    @JvmStatic
    public static final void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        a.d(r1, r2);
    }

    @JvmStatic
    public static final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        a.e(r2, r3, null);
    }

    @JvmStatic
    public static final void c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        a.i(r1, r2);
    }

    @JvmStatic
    public static final void f(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        a.w(r1, r2);
    }

    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        b.d(r2, r3);
    }

    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        b.i(r2, r3);
    }

    public final void w(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        b.w(r2, r3);
    }

    public final void e(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        b.e(r2, r3, r4);
    }
}
