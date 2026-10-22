package com.ss.android.socialbase.downloader.segment;

/* JADX INFO: loaded from: classes6.dex */
class b implements c, d, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15614b;
    private final Object c;
    private final Object d;
    private a e;
    private a f;
    private a g;
    private a h;
    private a i;
    private volatile boolean j;
    private int k;

    b(int r2, int r3) {
        this.c = new Object();
        this.d = new Object();
        if (r2 >= 64) goto L6;
        r2 = 64;
    L6:
        if (r3 >= 8192) goto L8;
        r3 = 8192;
    L8:
        this.f15613a = r2;
        this.f15614b = r3;
    }

    @Override // com.ss.android.socialbase.downloader.segment.d
    public a a() {
        a r0 = this.i;
        if (r0 == null) goto L6;
        this.i = r0.d;
        r0.d = null;
        return r0;
    L6:
        Object r1 = this.d;
        monitor-enter(r1);
    L21:
        a r2 = this.g;     // Catch: Throwable -> L18
        if (r2 != null) goto L15;
        if (this.j == true) goto L14;
        this.d.wait();     // Catch: Throwable -> L18
        goto L21
    L14:
        throw new StreamClosedException("read");     // Catch: Throwable -> L18
    L15:
        this.i = r2.d;     // Catch: Throwable -> L18
        this.h = null;     // Catch: Throwable -> L18
        this.g = null;     // Catch: Throwable -> L18
        r2.d = null;     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r2;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.c
    public void a(a r3) {
        Object r0 = this.c;
        monitor-enter(r0);
        a r1 = this.f;     // Catch: Throwable -> L11
        if (r1 != null) goto L7;
        this.f = r3;     // Catch: Throwable -> L11
        this.e = r3;     // Catch: Throwable -> L11
    L8:
        this.c.notify();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r1.d = r3;     // Catch: Throwable -> L11
        this.f = r3;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.c
    public a b() {
        Object r0 = this.c;
        monitor-enter(r0);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.j == true) goto L27;
        a r1 = this.e;     // Catch: Throwable -> L28
        if (r1 != null) goto L20;
        int r2 = this.k;     // Catch: Throwable -> L28
        if (r2 >= this.f15613a) goto L13;
        this.k = r2 + 1;     // Catch: Throwable -> L28
        a r3 = new a(this.f15614b);     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r3;
    L13:
        this.c.wait();     // Catch: Throwable -> L28
        if (this.j == true) goto L19;
        r1 = this.e;     // Catch: Throwable -> L28
        if (r1 == null) goto L13;
    L19:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L28
    L20:
        this.e = r1.d;     // Catch: Throwable -> L28
        if (r1 != this.f) goto L23;
        this.f = null;     // Catch: Throwable -> L28
    L23:
        r1.d = null;     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        return r1;
    L27:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L28
    }

    @Override // com.ss.android.socialbase.downloader.segment.e
    public void b(a r3) {
        Object r0 = this.d;
        monitor-enter(r0);
        a r1 = this.h;     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        this.h = r3;     // Catch: Throwable -> L10
        this.g = r3;     // Catch: Throwable -> L10
        this.d.notify();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L7:
        r1.d = r3;     // Catch: Throwable -> L10
        this.h = r3;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void c() {
        this.j = true;
        Object r0 = this.c;
        monitor-enter(r0);
        this.c.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Object r1 = this.d;
        monitor-enter(r1);
        this.d.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }
}
