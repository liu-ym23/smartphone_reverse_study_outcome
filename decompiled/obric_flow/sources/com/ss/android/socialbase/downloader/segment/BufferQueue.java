package com.ss.android.socialbase.downloader.segment;

/* JADX INFO: loaded from: classes3.dex */
class BufferQueue implements IInput, IOutput, IBufferPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f16010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f16011c;
    public final Object d;
    public Buffer e;
    public Buffer f;
    public Buffer g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Buffer f16012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Buffer f16013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f16014j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16015k;

    public BufferQueue(int r5, int r10) {
        this.f16011c = new Object();
        this.d = new Object();
        if (r5 >= 64) goto L6;
        r5 = 64;
    L6:
        if (r10 >= 8192) goto L8;
        r10 = 8192;
    L8:
        this.f16009a = r5;
        this.f16010b = r10;
    }

    public final void a(Buffer r5) {
        Object r10 = this.f16011c;
        monitor-enter(r10);
        Buffer r11 = this.f;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        this.f = r5;     // Catch: Throwable -> L7
        this.e = r5;     // Catch: Throwable -> L7
    L10:
        this.f16011c.notify();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L9:
        r11.d = r5;     // Catch: Throwable -> L7
        this.f = r5;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public final Buffer b() {
        Object r5 = this.f16011c;
        monitor-enter(r5);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f16014j == true) goto L29;
        Buffer r10 = this.e;     // Catch: Throwable -> L13
        if (r10 != null) goto L22;
        int r11 = this.f16015k;     // Catch: Throwable -> L13
        if (r11 >= this.f16009a) goto L15;
        this.f16015k = r11 + 1;     // Catch: Throwable -> L13
        Buffer r12 = new Buffer(this.f16010b);     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        return r12;
    L15:
        this.f16011c.wait();     // Catch: Throwable -> L13
        if (this.f16014j == true) goto L21;
        r10 = this.e;     // Catch: Throwable -> L13
        if (r10 == null) goto L15;
    L21:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L13
    L22:
        this.e = r10.d;     // Catch: Throwable -> L13
        if (r10 != this.f) goto L25;
        this.f = null;     // Catch: Throwable -> L13
    L25:
        r10.d = null;     // Catch: Throwable -> L13
        monitor-exit(r5);     // Catch: Throwable -> L13
        return r10;
    L29:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L13
    }

    public final Buffer c() {
        Buffer r5 = this.f16013i;
        if (r5 == null) goto L6;
        this.f16013i = r5.d;
        r5.d = null;
        return r5;
    L6:
        Object r10 = this.d;
        monitor-enter(r10);
        Buffer r11 = this.g;     // Catch: Throwable -> L13
    L9:
        if (r11 != null) goto L17;
        if (this.f16014j == true) goto L16;
        this.d.wait();     // Catch: Throwable -> L13
        r11 = this.g;     // Catch: Throwable -> L13
        goto L9
    L16:
        throw new StreamClosedException("read");     // Catch: Throwable -> L13
    L17:
        this.f16013i = r11.d;     // Catch: Throwable -> L13
        this.f16012h = null;     // Catch: Throwable -> L13
        this.g = null;     // Catch: Throwable -> L13
        r11.d = null;     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r11;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a() {
        this.f16014j = true;
        Object r5 = this.f16011c;
        monitor-enter(r5);
        this.f16011c.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r5);     // Catch: Throwable -> L14
        Object r10 = this.d;
        monitor-enter(r10);
        this.d.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    public final void b(Buffer r5) {
        Object r10 = this.d;
        monitor-enter(r10);
        Buffer r11 = this.f16012h;     // Catch: Throwable -> L7
        if (r11 != null) goto L9;
        this.f16012h = r5;     // Catch: Throwable -> L7
        this.g = r5;     // Catch: Throwable -> L7
        this.d.notify();     // Catch: Throwable -> L7
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L9:
        r11.d = r5;     // Catch: Throwable -> L7
        this.f16012h = r5;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }
}
