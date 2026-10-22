package com.ss.android.socialbase.downloader.network.throttle;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ThrottleInputStream extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f15989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f15990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f15991c;
    public volatile long d;
    public volatile long e;
    public long f;
    public long g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f15992h;

    public ThrottleInputStream(InputStream r5) {
        this.f15991c = 40;
        this.f15989a = r5;
    }

    public final int a(byte[] r5, int r10, int r11) {
        return super.read(r5, r10, r11);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f15989a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f15989a.close();
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int r5) {
        monitor-enter(this);
        this.f15989a.mark(r5);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f15989a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read() {
        return this.f15989a.read();
    }

    @Override // java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
        this.f15989a.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final long skip(long r5) {
        return this.f15989a.skip(r5);
    }

    @Override // java.io.InputStream
    public int read(byte[] r10, int r11, int r12) {
        if (this.e <= 0) goto L37;
        if (this.g != 0) goto L7;
        this.g = System.currentTimeMillis();
    L7:
        long r5 = this.e - this.f;
        if (r5 > 0) goto L10;
    L12:
        int r13 = this.f15989a.read(r10, r11, r12);
        if (r13 == (-1)) goto L16;
        this.f += (long) r13;
    L16:
        if (this.f < this.e) goto L35;
        long r14 = System.currentTimeMillis();
        long r15 = r14 - this.g;
        this.g = r14;
        long r16 = this.d - r15;
        if (r16 <= 0) goto L30;
        long r17 = this.f15992h;
        if (r16 <= r17) goto L29;
        long r18 = r16 - r17;
        this.f15992h = 0;
        if (r18 <= 0) goto L34;
        this.g += r18;
        Thread.sleep(r18);     // Catch: InterruptedException -> L26
    L26:
        e = move-exception;
        throw new IOException(e);
    L34:
        this.f = 0;
        goto L35
    L29:
        this.f15992h = r17 - r16;
        goto L34
    L30:
        if (r16 >= 0) goto L34;
        long r19 = this.f15992h + (-r16);
        this.f15992h = r19;
        if (r19 <= 100) goto L34;
        this.f15992h = 100;
    L35:
        return r13;
    L10:
        if (r12 <= r5) goto L12;
        r12 = (int) r5;
        goto L12
    L37:
        return this.f15989a.read(r10, r11, r12);
    }
}
