package com.ctc.wstx.io;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile char[] f3528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile char[] f3529b;
    private volatile char[] c;
    private volatile byte[] d;

    public e() {
        this.f3528a = null;
        this.f3529b = null;
        this.c = null;
        this.d = null;
    }

    public synchronized void a(byte[] r1) {
        monitor-enter(this);
        this.d = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void a(char[] r1) {
        monitor-enter(this);
        this.f3528a = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized char[] a(int r4) {
        monitor-enter(this);
        char[] r0 = this.f3528a;     // Catch: Throwable -> L12
        if (r0 != null) goto L6;
    L10:
        monitor-exit(this);
        return null;
    L6:
        if (r0.length < r4) goto L10;
        this.f3528a = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void b(char[] r1) {
        monitor-enter(this);
        this.f3529b = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized char[] b(int r4) {
        monitor-enter(this);
        char[] r0 = this.f3529b;     // Catch: Throwable -> L12
        if (r0 != null) goto L6;
    L10:
        monitor-exit(this);
        return null;
    L6:
        if (r0.length < r4) goto L10;
        this.f3529b = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void c(char[] r1) {
        monitor-enter(this);
        this.c = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized char[] c(int r4) {
        monitor-enter(this);
        char[] r0 = this.c;     // Catch: Throwable -> L12
        if (r0 != null) goto L6;
    L10:
        monitor-exit(this);
        return null;
    L6:
        if (r0.length < r4) goto L10;
        this.c = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized byte[] d(int r4) {
        monitor-enter(this);
        byte[] r0 = this.d;     // Catch: Throwable -> L12
        if (r0 != null) goto L6;
    L10:
        monitor-exit(this);
        return null;
    L6:
        if (r0.length < r4) goto L10;
        this.d = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }
}
