package com.ss.android.socialbase.downloader.network.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f15580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f15581b;
    protected volatile long c;
    protected long d;
    private final InputStream e;
    private volatile long f;
    private long g;
    private long h;

    public b(InputStream r2) {
        this.f15581b = 40;
        this.e = r2;
    }

    public int a(byte[] r1, int r2, int r3) {
        return super.read(r1, r2, r3);
    }

    public void a(long r3, int r5) {
        this.f15580a = r3;
        if (r5 >= 1) goto L5;
    L7:
        this.c = 1000 / this.f15581b;
        this.f = r3 / ((long) this.f15581b);
        return;
    L5:
        if (r5 > 100) goto L7;
        this.f15581b = r5;
        goto L7
    }

    @Override // java.io.InputStream
    public int available() {
        return this.e.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
        this.e.mark(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.e.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        return this.e.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r7, int r8, int r9) {
        if (this.f <= 0) goto L37;
        if (this.d != 0) goto L7;
        this.d = System.currentTimeMillis();
    L7:
        long r0 = this.f - this.g;
        if (r0 > 0) goto L10;
    L12:
        int r10 = this.e.read(r7, r8, r9);
        if (r10 == (-1)) goto L16;
        this.g += (long) r10;
    L16:
        if (this.g < this.f) goto L35;
        long r11 = System.currentTimeMillis();
        long r1 = r11 - this.d;
        this.d = r11;
        long r12 = this.c - r1;
        if (r12 <= 0) goto L30;
        long r2 = this.h;
        if (r12 <= r2) goto L29;
        long r13 = r12 - r2;
        this.h = 0;
        if (r13 <= 0) goto L34;
        this.d += r13;
        Thread.sleep(r13);     // Catch: InterruptedException -> L26
    L26:
        e = move-exception;
        throw new IOException(e);
    L34:
        this.g = 0;
        goto L35
    L29:
        this.h = r2 - r12;
        goto L34
    L30:
        if (r12 >= 0) goto L34;
        long r3 = this.h + (-r12);
        this.h = r3;
        if (r3 <= 100) goto L34;
        this.h = 100;
    L35:
        return r10;
    L10:
        if (r9 <= r0) goto L12;
        r9 = (int) r0;
        goto L12
    L37:
        return this.e.read(r7, r8, r9);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        this.e.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public long skip(long r1) {
        return this.e.skip(r1);
    }
}
