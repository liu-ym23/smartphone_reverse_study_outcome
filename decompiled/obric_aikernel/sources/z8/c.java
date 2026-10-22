package z8;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"StaticFieldLeak"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f13804a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f13805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f13806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f13807d;

    static {
        f13804a = new c();
    }

    private c() {
    }

    public static /* synthetic */ void a(Throwable r10) {
        g(r10);
    }

    private static final void g(Throwable r10) {
        e9.b.d("MatrixOnesSdk", "Rxjava error " + Log.getStackTraceString(r10), null, 4, null);
    }

    public final synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (f13805b == null) goto L10;
        if (f13806c == null) goto L10;
        monitor-exit(this);
        return;
    L10:
        throw new RuntimeException("please call init first ");     // Catch: Throwable -> L11
    }

    public final void c(boolean r10) {
        e9.b.f8755a.i(r10);
    }

    public final a d() {
        return f13806c;
    }

    public final Context e() {
        return f13805b;
    }

    public final synchronized void f(Context r10, a r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "ctx");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r11, "iBridge");     // Catch: Throwable -> L16
        if (f13807d == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        f13807d = true;     // Catch: Throwable -> L16
        f13805b = r10.getApplicationContext();     // Catch: Throwable -> L16
        f13806c = r11;     // Catch: Throwable -> L16
        e9.b.b("MatrixOnesSdk", "ones sdk init start, sdk version: [1.6.29-alpha.25]", null, 4, null);     // Catch: Throwable -> L16
        d9.c r12 = d9.c.f8516a;     // Catch: Throwable -> L16
        r12.i(r10);     // Catch: Throwable -> L16
        r12.k();     // Catch: Throwable -> L16
        com.obric.matrix.platform.sdk.ones.internal.tunnel.b.f5893a.e();     // Catch: Throwable -> L16
        dc.a.v(b.f13803c);     // Catch: Exception -> L11 Throwable -> L16
    L13:
        e9.b.b("MatrixOnesSdk", "ones sdk init end", null, 4, null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        e9.b.d("MatrixOnesSdk", "Rxjava set error handler " + Log.getStackTraceString(e), null, 4, null);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }
}
