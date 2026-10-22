package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class h extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f986a;

    public h(InputStream r1) {
        super(r1);
        this.f986a = Integer.MIN_VALUE;
    }

    private long a(long r3) {
        int r2 = this.f986a;
        if (r2 != 0) goto L7;
        return -1;
    L7:
        if (r2 != Integer.MIN_VALUE) goto L9;
    L12:
        return r3;
    L9:
        if (r3 <= r2) goto L12;
        return r2;
    }

    private void b(long r4) {
        int r0 = this.f986a;
        if (r0 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (r4 == (-1)) goto L9;
        this.f986a = (int) (((long) r0) - r4);
        return;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int r0 = this.f986a;
        int r2 = super.available();
        if (r0 != Integer.MIN_VALUE) goto L6;
        return r2;
    L6:
        return Math.min(r0, r2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r1) {
        monitor-enter(this);
        super.mark(r1);     // Catch: Throwable -> L6
        this.f986a = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (a(1) != (-1)) goto L6;
        return -1;
    L6:
        int r2 = super.read();
        b(1);
        return r2;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        int r6 = (int) a(r5);
        if (r6 != (-1)) goto L5;
        return -1;
    L5:
        int r7 = super.read(r3, r4, r6);
        b(r7);
        return r7;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
        super.reset();     // Catch: Throwable -> L6
        this.f986a = Integer.MIN_VALUE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r3) {
        long r4 = a(r3);
        if (r4 != (-1)) goto L6;
        return 0;
    L6:
        long r5 = super.skip(r4);
        b(r5);
        return r5;
    }
}
