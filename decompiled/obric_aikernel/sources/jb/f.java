package jb;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class f extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile f f9844f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f9845g = false;

    static {
    }

    private f() {
    }

    f(g r10) {
        ((qb.l) qb.k.a(qb.l.class)).d(r10);
    }

    public static /* bridge */ /* synthetic */ com.ss.android.socialbase.downloader.model.d s(Context r10) {
        return b.s(r10);
    }

    private static void t(Context r10) {
        if (f9845g == false) goto L6;
        return;
    L6:
        monitor-enter(f.class);
    L21:
        th = move-exception;
        throw th;
    L8:
        if (f9845g == false) goto L26;
        monitor-exit(f.class);     // Catch: Throwable -> L21
        return;
    L26:
        if (r10 == null) goto L14;
        ((qb.l) qb.k.a(qb.l.class)).f(r10.getApplicationContext());     // Catch: Throwable -> L17
        f9845g = true;     // Catch: Throwable -> L17
    L25:
    L19:
        monitor-exit(f.class);     // Catch: Throwable -> L21
        return;
    L14:
        if (lb.a.a() == false) goto L25;
        lb.a.b("Downloader", "checkContext", "Context is null " + Log.getStackTraceString(new Throwable("context_empty")));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        lb.a.c("Downloader", "checkContext", "Error:" + th);     // Catch: Throwable -> L21
        goto L19
    }

    public static f u(Context r10) {
        if (f9844f == null) goto L5;
    L14:
        t(r10);
        return f9844f;
    L5:
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9844f != null) goto L9;
        ((qb.l) qb.k.a(qb.l.class)).f(r10);     // Catch: Throwable -> L11
        f9844f = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void v(g r10) {
        w(r10, false);
    }

    public static synchronized void w(g r10, boolean r11) {
        monitor-enter(f.class);
        if (r10 != null) goto L22;
        monitor-exit(f.class);
        return;
    L22:
    L19:
        th = move-exception;
        throw th;
    L8:
        if (f9844f != null) goto L12;
        f9844f = r10.a();     // Catch: Throwable -> L19
        monitor-exit(f.class);
        return;
    L12:
        qb.l r12 = (qb.l) qb.k.a(qb.l.class);     // Catch: Throwable -> L19
        if (r12.isInit() == true) goto L15;
        r12.d(r10);     // Catch: Throwable -> L19
    L17:
        monitor-exit(f.class);
        return;
    L15:
        if (r11 == false) goto L17;
        r12.c(r10);     // Catch: Throwable -> L19
        goto L17
    }

    public static void x(p r10) {
        qb.k.c(r10);
    }
}
