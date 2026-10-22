package com.ctc.wstx.io;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ctc.wstx.a.b f3537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputStream f3538b;
    private byte[] c;
    private int d;
    private final int e;

    public n(com.ctc.wstx.a.b r1, InputStream r2, byte[] r3, int r4, int r5) {
        if (r2 == null) goto L7;
        this.f3537a = r1;
        this.f3538b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        return;
    L7:
        throw new IllegalArgumentException("InputStream `in` should not be `null`");
    }

    private void a() {
        byte[] r0 = this.c;
        if (r0 == null) goto L8;
        this.c = null;
        com.ctc.wstx.a.b r2 = this.f3537a;
        if (r2 == null) goto L9;
        r2.a(r0);
        return;
    L9:
        return;
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.c == null) goto L7;
        return this.e - this.d;
    L7:
        return this.f3538b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
        this.f3538b.close();
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.c != null) goto L6;
        this.f3538b.mark(r2);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        if (this.c == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f3538b.markSupported() == false) goto L7;
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] r0 = this.c;
        if (r0 == null) goto L9;
        int r1 = this.d;
        int r2 = r1 + 1;
        this.d = r2;
        int r3 = r0[r1] & 255;
        if (r2 < this.e) goto L7;
        a();
    L7:
        return r3;
    L9:
        return this.f3538b.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] r4, int r5, int r6) {
        byte[] r0 = this.c;
        if (r0 == null) goto L12;
        int r1 = this.e;
        int r2 = this.d;
        int r3 = r1 - r2;
        if (r6 <= r3) goto L7;
        r6 = r3;
    L7:
        System.arraycopy(r0, r2, r4, r5, r6);
        int r7 = this.d + r6;
        this.d = r7;
        if (r7 < this.e) goto L10;
        a();
    L10:
        return r6;
    L12:
        return this.f3538b.read(r4, r5, r6);
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.c != null) goto L6;
        this.f3538b.reset();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    @Override // java.io.InputStream
    public long skip(long r9) {
        if (this.c == null) goto L9;
        int r0 = this.e;
        int r3 = this.d;
        long r4 = r0 - r3;
        if (r4 <= r9) goto L8;
        this.d = r3 + ((int) r9);
        return r9;
    L8:
        a();
        long r6 = r4 + 0;
        r9 = r9 - r4;
    L11:
        if (r9 > 0) goto L13;
        return r6;
    L13:
        return r6 + this.f3538b.skip(r9);
    L9:
        r6 = 0;
        goto L11
    }
}
