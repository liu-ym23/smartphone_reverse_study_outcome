package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes.dex */
public class c implements n2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f1571a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile d f1572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f1573c;

    static {
    }

    public c() {
        this(8, 8);
    }

    @Deprecated
    public c(int r10, int r11) {
        if (f1572b != null) goto L6;
        f1572b = d.q().s(8, 8).u(8, 8).r(30).w(10).t(10).v(true).q();
        return;
    }

    @Deprecated
    public static c c() {
        if (f1573c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1573c != null) goto L9;
        f1573c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f1573c;
    }

    public static synchronized d d() {
        monitor-enter(c.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f1572b != null) goto L7;
        f1572b = d.q().s(8, 8).u(8, 8).r(30).w(10).t(10).v(true).q();     // Catch: Throwable -> L10
    L7:
        d r10 = f1572b;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r10;
    }

    public static synchronized void e(boolean r10) {
        monitor-enter(c.class);
        f1571a = r10;     // Catch: Throwable -> L9
        if (f1572b == null) goto L7;
        f1572b.r(f1571a);     // Catch: Throwable -> L9
    L7:
        monitor-exit(c.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // n2.b
    public synchronized void a(n2.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        b.f1559m.c(r10);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // n2.b
    public synchronized void b(n2.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        b.f1559m.d(r10);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
