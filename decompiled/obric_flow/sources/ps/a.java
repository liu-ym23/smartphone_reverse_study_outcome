package ps;

import kotlin.jvm.internal.Intrinsics;
import ym.g;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f21388a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21389b = 0;

    static {
        Intrinsics.checkNotNullParameter("OUI_SDK", "baseTag");
        g r5 = new g();
        r5.f23298a = false;
        f21388a = r5;
        f21389b = 31;
    }

    public static final void a(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        e(r5, 2, r10, null, 24);
    }

    public static final void b(Exception r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        e(r10, 16, r11, r5, 16);
    }

    public static final void c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        e(r5, 16, r10, null, 24);
    }

    public static boolean d(int r5) {
        if ((r5 & f21389b) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void e(String r5, int r10, String r11, Exception r12, int r13) {
        if ((r13 & 8) == 0) goto L6;
        r12 = null;
    L6:
        if (d(r10) == true) goto L10;
        f21388a.i(r10, r5, r11, r12);
        return;
    }

    public static final void f(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        e(r5, 1, r10, null, 24);
    }

    public static final void g(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        e(r5, 8, r10, null, 24);
    }
}
