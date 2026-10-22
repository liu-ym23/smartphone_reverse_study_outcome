package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
class b implements d, e, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f8211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f8212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f8213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f8214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f8215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f8216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f8217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f8218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8219k;

    b(int r10, int r11) {
        this.f8211c = new Object();
        this.f8212d = new Object();
        if (r10 >= 64) goto L6;
        r10 = 64;
    L6:
        if (r11 >= 8192) goto L8;
        r11 = 8192;
    L8:
        this.f8209a = r10;
        this.f8210b = r11;
    }

    @Override // com.ss.android.socialbase.downloader.segment.c
    public void a(@NonNull a r10) {
        Object r11 = this.f8211c;
        monitor-enter(r11);
        a r12 = this.f8214f;     // Catch: Throwable -> L11
        if (r12 != null) goto L7;
        this.f8214f = r10;     // Catch: Throwable -> L11
        this.f8213e = r10;     // Catch: Throwable -> L11
    L8:
        this.f8211c.notify();     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L7:
        r12.f8208d = r10;     // Catch: Throwable -> L11
        this.f8214f = r10;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.e
    public void b(@NonNull a r10) {
        Object r11 = this.f8212d;
        monitor-enter(r11);
        a r12 = this.f8216h;     // Catch: Throwable -> L10
        if (r12 != null) goto L7;
        this.f8216h = r10;     // Catch: Throwable -> L10
        this.f8215g = r10;     // Catch: Throwable -> L10
        this.f8212d.notify();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L7:
        r12.f8208d = r10;     // Catch: Throwable -> L10
        this.f8216h = r10;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.c
    @NonNull
    public a c() {
        Object r10 = this.f8211c;
        monitor-enter(r10);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (this.f8218j == true) goto L27;
        a r11 = this.f8213e;     // Catch: Throwable -> L28
        if (r11 != null) goto L20;
        int r12 = this.f8219k;     // Catch: Throwable -> L28
        if (r12 >= this.f8209a) goto L13;
        this.f8219k = r12 + 1;     // Catch: Throwable -> L28
        a r13 = new a(this.f8210b);     // Catch: Throwable -> L28
        monitor-exit(r10);     // Catch: Throwable -> L28
        return r13;
    L13:
        this.f8211c.wait();     // Catch: Throwable -> L28
        if (this.f8218j == true) goto L19;
        r11 = this.f8213e;     // Catch: Throwable -> L28
        if (r11 == null) goto L13;
    L19:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L28
    L20:
        this.f8213e = r11.f8208d;     // Catch: Throwable -> L28
        if (r11 != this.f8214f) goto L23;
        this.f8214f = null;     // Catch: Throwable -> L28
    L23:
        r11.f8208d = null;     // Catch: Throwable -> L28
        monitor-exit(r10);     // Catch: Throwable -> L28
        return r11;
    L27:
        throw new StreamClosedException("obtain");     // Catch: Throwable -> L28
    }

    public void d() {
        this.f8218j = true;
        Object r10 = this.f8211c;
        monitor-enter(r10);
        this.f8211c.notifyAll();     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        Object r11 = this.f8212d;
        monitor-enter(r11);
        this.f8212d.notifyAll();     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.downloader.segment.d
    @NonNull
    public a read() {
        a r10 = this.f8217i;
        if (r10 == null) goto L6;
        this.f8217i = r10.f8208d;
        r10.f8208d = null;
        return r10;
    L6:
        Object r11 = this.f8212d;
        monitor-enter(r11);
    L21:
        a r12 = this.f8215g;     // Catch: Throwable -> L18
        if (r12 != null) goto L15;
        if (this.f8218j == true) goto L14;
        this.f8212d.wait();     // Catch: Throwable -> L18
        goto L21
    L14:
        throw new StreamClosedException("read");     // Catch: Throwable -> L18
    L15:
        this.f8217i = r12.f8208d;     // Catch: Throwable -> L18
        this.f8216h = null;     // Catch: Throwable -> L18
        this.f8215g = null;     // Catch: Throwable -> L18
        r12.f8208d = null;     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Throwable -> L18
        return r12;
    L18:
        th = move-exception;
        throw th;
    }
}
