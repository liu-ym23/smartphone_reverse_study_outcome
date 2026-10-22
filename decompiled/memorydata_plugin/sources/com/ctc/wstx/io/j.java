package com.ctc.wstx.io;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f3531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3532b;

    public j(com.ctc.wstx.a.b r1, InputStream r2, byte[] r3, int r4, int r5, boolean r6) {
        super(r1, r2, r3, r4, r5, r6);
        this.f3531a = false;
        this.f3532b = 0;
    }

    @Override // com.ctc.wstx.io.c
    public void a(int r2) {
        if (r2 != 272) goto L5;
        boolean r3 = true;
    L6:
        this.f3531a = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.ctc.wstx.io.c, java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.ctc.wstx.io.c, java.io.Reader
    public /* bridge */ /* synthetic */ int read() {
        return super.read();
    }

    @Override // java.io.Reader
    public int read(char[] r6, int r7, int r8) {
        if (r7 >= 0) goto L4;
    L5:
        a(r6, r7, r8);
    L7:
        if (this.d != null) goto L10;
        return -1;
    L10:
        if (r8 >= 1) goto L13;
        return 0;
    L13:
        int r0 = this.f - this.e;
        if (r0 > 0) goto L21;
        this.f3532b += this.f;
        r0 = b();
        if (r0 > 0) goto L21;
        if (r0 != 0) goto L19;
        d();
    L19:
        c();
        return -1;
    L21:
        if (r8 <= r0) goto L23;
        r8 = r0;
    L23:
        int r1 = this.e;
        int r2 = r1 + r8;
        if (this.f3531a == false) goto L35;
    L25:
        if (r1 >= r2) goto L37;
        int r3 = r1 + 1;
        char r4 = (char) (this.d[r1] & 255);
        if (r4 < 127) goto L34;
        if (r4 > 159) goto L34;
        if (r4 != 133) goto L33;
        r4 = '\n';
        goto L34
    L33:
        int r5 = this.f3532b + r3;
        a(r4, r5, r5);
    L34:
        r6[r7] = r4;
        r7 = r7 + 1;
        r1 = r3;
    L37:
        this.e = r2;
        return r8;
    L35:
        if (r1 >= r2) goto L37;
        r6[r7] = (char) (this.d[r1] & 255);
        r7 = r7 + 1;
        r1 = r1 + 1;
        goto L35
    L4:
        if ((r7 + r8) <= r6.length) goto L7;
        goto L5
    }
}
