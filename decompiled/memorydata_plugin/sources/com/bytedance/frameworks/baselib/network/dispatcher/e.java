package com.bytedance.frameworks.baselib.network.dispatcher;

/* JADX INFO: loaded from: classes2.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f2335a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile f f2336b;
    private static volatile e c;

    static {
    }

    public e() {
        this(8, 8);
    }

    @Deprecated
    public e(int r1, int r2) {
        if (f2336b != null) goto L6;
        f2336b = f.q().a(8, 8).b(8, 8).a(30).c(10).b(10).a(true).a();
        return;
    }

    public static synchronized f a() {
        monitor-enter(e.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f2336b != null) goto L7;
        f2336b = f.q().a(8, 8).b(8, 8).a(30).c(10).b(10).a(true).a();     // Catch: Throwable -> L10
    L7:
        f r1 = f2336b;     // Catch: Throwable -> L10
        monitor-exit(e.class);
        return r1;
    }

    public static synchronized void a(boolean r2) {
        monitor-enter(e.class);
        f2335a = r2;     // Catch: Throwable -> L9
        if (f2336b == null) goto L7;
        f2336b.a(f2335a);     // Catch: Throwable -> L9
    L7:
        monitor-exit(e.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static e b() {
        if (c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.c
    public synchronized void a(b r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        d.f2327a.a(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.c
    public synchronized void b(b r2) {
        monitor-enter(this);
        if (r2 != null) goto L11;
    L9:
        monitor-exit(this);
        return;
    L11:
        d.f2327a.b(r2);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
