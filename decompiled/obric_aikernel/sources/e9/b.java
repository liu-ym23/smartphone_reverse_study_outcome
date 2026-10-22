package e9;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import z8.c;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8755a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f8756b;

    static {
        f8755a = new b();
    }

    private b() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        if (f8756b == false) goto L5;
        Log.d(r10, r11, r12);
    L5:
        f8755a.g(r10, r11, r12);
    }

    public static /* synthetic */ void b(String r10, String r11, Throwable r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        a(r10, r11, r12);
    }

    @JvmStatic
    @JvmOverloads
    public static final void c(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        if (f8756b == false) goto L5;
        Log.e(r10, r11, r12);
    L5:
        f8755a.h(r10, r11, r12);
    }

    public static /* synthetic */ void d(String r10, String r11, Throwable r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        c(r10, r11, r12);
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        if (f8756b == false) goto L5;
        Log.i(r10, r11, r12);
    L5:
        f8755a.h(r10, r11, r12);
    }

    public static /* synthetic */ void f(String r10, String r11, Throwable r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        e(r10, r11, r12);
    }

    private final void g(String r10, String r11, Throwable r12) {
        z8.a r13 = c.f13804a.d();
        if (r13 == null) goto L6;
        r13.c(r10, "MatrixOnesSdk: " + r11, r12);
        return;
    }

    private final void h(String r10, String r11, Throwable r12) {
        z8.a r13 = c.f13804a.d();
        if (r13 == null) goto L6;
        r13.d(r10, "MatrixOnesSdk: " + r11, r12);
        return;
    }

    @JvmStatic
    @JvmOverloads
    public static final void j(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        if (f8756b == false) goto L5;
        Log.w(r10, r11, r12);
    L5:
        f8755a.h(r10, r11, r12);
    }

    public static /* synthetic */ void k(String r10, String r11, Throwable r12, int r13, Object r14) {
        if ((r13 & 4) == 0) goto L5;
        r12 = null;
    L5:
        j(r10, r11, r12);
    }

    public final void i(boolean r10) {
        f8756b = r10;
    }
}
