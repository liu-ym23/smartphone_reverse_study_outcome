package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class b extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f974b;

    private b(InputStream r1, long r2) {
        super(r1);
        this.f973a = r2;
    }

    private int a(int r5) {
        if (r5 < 0) goto L5;
        this.f974b += r5;
    L6:
        return r5;
    L5:
        if ((this.f973a - ((long) this.f974b)) <= 0) goto L6;
        throw new IOException("Failed to read all expected data, expected: " + this.f973a + ", but read: " + this.f974b);
    }

    public static InputStream a(InputStream r1, long r2) {
        return new b(r1, r2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        monitor-enter(this);
        int r0 = (int) Math.max(this.f973a - ((long) this.f974b), this.in.available());
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        monitor-enter(this);
        int r0 = super.read();     // Catch: Throwable -> L10
        if (r0 < 0) goto L6;
        int r1 = 1;
    L7:
        a(r1);     // Catch: Throwable -> L10
        monitor-exit(this);
        return r0;
    L6:
        r1 = -1;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] r1, int r2, int r3) {
        monitor-enter(this);
        int r4 = a(super.read(r1, r2, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }
}
