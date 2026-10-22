package i;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public final class c extends android.support.v4.media.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile c f8072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f8073e = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f8074c;

    static {
        f8073e = new b(0);
    }

    public c() {
        this.f8074c = new d();
    }

    public static c A() {
        if (f8072d == null) goto L7;
        return f8072d;
    L7:
        monitor-enter(c.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (f8072d != null) goto L11;
        f8072d = new c();     // Catch: Throwable -> L14
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L14
        return f8072d;
    }

    public final boolean B() {
        this.f8074c.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public final void C(Runnable r8) {
        d r10 = this.f8074c;
        if (r10.f8077e != null) goto L14;
        Object r11 = r10.f8075c;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (r10.f8077e != null) goto L9;
        r10.f8077e = Handler.createAsync(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L11
    L14:
        r10.f8077e.post(r8);
    }

    public final void z(Runnable r8) {
        this.f8074c.z(r8);
    }
}
