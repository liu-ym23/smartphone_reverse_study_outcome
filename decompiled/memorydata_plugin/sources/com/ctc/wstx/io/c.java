package com.ctc.wstx.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* JADX INFO: loaded from: classes2.dex */
abstract class c extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f3526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f3527b;
    protected final com.ctc.wstx.a.b c;
    protected byte[] d;
    protected int e;
    protected int f;
    protected char[] g;

    public c(com.ctc.wstx.a.b r2, InputStream r3, byte[] r4, int r5, int r6, boolean r7) {
        this.g = null;
        this.c = r2;
        this.f3526a = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.f3527b = r7;
    }

    public abstract void a(int r1);

    public void a(int r3, int r4, int r5) {
        throw new CharConversionException("Invalid character 0x" + Integer.toHexString(r3) + ", can only be included in xml 1.1 using character entities (at char #" + r5 + ", byte #" + r4 + ")");
    }

    public void a(char[] r3, int r4, int r5) {
        throw new ArrayIndexOutOfBoundsException("read(buf," + r4 + "," + r5 + "), cbuf[" + r3.length + "]");
    }

    public final boolean a() {
        return this.f3527b;
    }

    public final int b() {
        this.e = 0;
        this.f = 0;
        InputStream r1 = this.f3526a;
        if (r1 == null) goto L8;
        byte[] r2 = this.d;
        int r0 = r1.read(r2, 0, r2.length);
        if (r0 <= 0) goto L7;
        this.f = r0;
    L7:
        return r0;
    L8:
        return -1;
    }

    public final int b(int r4) {
        InputStream r0 = this.f3526a;
        if (r0 == null) goto L8;
        byte[] r1 = this.d;
        int r5 = r0.read(r1, r4, r1.length - r4);
        if (r5 <= 0) goto L7;
        this.f += r5;
    L7:
        return r5;
    L8:
        return -1;
    }

    public final void c() {
        if (this.f3527b == false) goto L10;
        byte[] r0 = this.d;
        if (r0 == null) goto L11;
        this.d = null;
        com.ctc.wstx.a.b r2 = this.c;
        if (r2 == null) goto L12;
        r2.a(r0);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream r0 = this.f3526a;
        if (r0 == null) goto L6;
        this.f3526a = null;
        c();
        r0.close();
        return;
    }

    public void d() {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    @Override // java.io.Reader
    public int read() {
        if (this.g != null) goto L6;
        this.g = new char[1];
    L6:
        if (read(this.g, 0, 1) >= 1) goto L10;
        return -1;
    L10:
        return this.g[0];
    }
}
