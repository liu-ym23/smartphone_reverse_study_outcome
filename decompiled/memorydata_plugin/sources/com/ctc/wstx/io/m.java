package com.ctc.wstx.io;

import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.ctc.wstx.a.b f3535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Reader f3536b;
    char[] c;
    int d;
    final int e;

    public m(com.ctc.wstx.a.b r1, Reader r2, char[] r3, int r4, int r5) {
        this.f3535a = r1;
        this.f3536b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        if (r3 == null) goto L8;
        if (r4 >= r5) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Trying to construct MergedReader with empty contents (start " + r4 + ", end " + r5 + ")");
    }

    private void a() {
        char[] r0 = this.c;
        if (r0 == null) goto L8;
        this.c = null;
        com.ctc.wstx.a.b r2 = this.f3535a;
        if (r2 == null) goto L9;
        r2.a(r0);
        return;
    L9:
        return;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
        this.f3536b.close();
    }

    @Override // java.io.Reader
    public void mark(int r2) {
        if (this.c != null) goto L6;
        this.f3536b.mark(r2);
        return;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        if (this.c == null) goto L5;
    L7:
        return false;
    L5:
        if (this.f3536b.markSupported() == false) goto L7;
        return true;
    }

    @Override // java.io.Reader
    public int read() {
        char[] r0 = this.c;
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
        return this.f3536b.read();
    }

    @Override // java.io.Reader
    public int read(char[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.Reader
    public int read(char[] r4, int r5, int r6) {
        char[] r0 = this.c;
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
        return this.f3536b.read(r4, r5, r6);
    }

    @Override // java.io.Reader
    public boolean ready() {
        if (this.c == null) goto L5;
    L8:
        return true;
    L5:
        if (this.f3536b.ready() == true) goto L8;
        return false;
    }

    @Override // java.io.Reader
    public void reset() {
        if (this.c != null) goto L6;
        this.f3536b.reset();
        return;
    }

    @Override // java.io.Reader
    public long skip(long r9) {
        if (this.c == null) goto L9;
        int r0 = this.e;
        int r3 = this.d;
        long r4 = r0 - r3;
        if (r4 <= r9) goto L8;
        this.d = r3 + ((int) r9);
        return r4;
    L8:
        a();
        long r6 = r4 + 0;
        r9 = r9 - r4;
    L11:
        if (r9 > 0) goto L13;
        return r6;
    L13:
        return r6 + this.f3536b.skip(r9);
    L9:
        r6 = 0;
        goto L11
    }
}
