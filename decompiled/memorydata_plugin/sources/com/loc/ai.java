package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class ai implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f5287a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputStream f5288b;
    private final Charset c;
    private byte[] d;
    private int e;
    private int f;

    static {
        f5287a = Charset.forName("US-ASCII");
    }

    public ai(InputStream r2, Charset r3) {
        this(r2, r3, (byte) 0);
    }

    private ai(InputStream r1, Charset r2, byte r3) {
        if (r1 == null) goto L12;
        if (r2 == null) goto L12;
        if (r2.equals(f5287a) == false) goto L10;
        this.f5288b = r1;
        this.c = r2;
        this.d = new byte[8192];
        return;
    L10:
        throw new IllegalArgumentException("Unsupported encoding");
    L12:
        throw null;
    }

    static /* synthetic */ Charset a(ai r0) {
        return r0.c;
    }

    private void b() {
        InputStream r0 = this.f5288b;
        byte[] r1 = this.d;
        int r2 = r0.read(r1, 0, r1.length);
        if (r2 == (-1)) goto L7;
        this.e = 0;
        this.f = r2;
        return;
    L7:
        throw new EOFException();
    }

    public final String a() {
        InputStream r0 = this.f5288b;
        monitor-enter(r0);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (this.d == null) goto L38;
        if (this.e < this.f) goto L9;
        b();     // Catch: Throwable -> L39
    L9:
        int r1 = this.e;     // Catch: Throwable -> L39
    L11:
        if (r1 == this.f) goto L24;
        byte[] r2 = this.d;     // Catch: Throwable -> L39
        if (r2[r1] == 10) goto L15;
        r1 = r1 + 1;     // Catch: Throwable -> L39
        goto L11
    L15:
        if (r1 == this.e) goto L19;
        int r3 = r1 - 1;     // Catch: Throwable -> L39
        if (r2[r3] != 13) goto L19;
    L20:
        byte[] r4 = this.d;     // Catch: Throwable -> L39
        int r5 = this.e;     // Catch: Throwable -> L39
        String r6 = new String(r4, r5, r3 - r5, this.c.name());     // Catch: Throwable -> L39
        this.e = r1 + 1;     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r6;
    L19:
        r3 = r1;
        goto L20
    L24:
        final int r7 = (this.f - this.e) + 80;     // Catch: Throwable -> L39
        ByteArrayOutputStream r8 = new AnonymousClass1(this, r7);     // Catch: Throwable -> L39
    L25:
        byte[] r9 = this.d;     // Catch: Throwable -> L39
        int r10 = this.e;     // Catch: Throwable -> L39
        r8.write(r9, r10, this.f - r10);     // Catch: Throwable -> L39
        this.f = -1;     // Catch: Throwable -> L39
        b();     // Catch: Throwable -> L39
        int r11 = this.e;     // Catch: Throwable -> L39
    L27:
        if (r11 == this.f) goto L25;
        byte[] r12 = this.d;     // Catch: Throwable -> L39
        if (r12[r11] == 10) goto L30;
        r11 = r11 + 1;     // Catch: Throwable -> L39
        goto L27
    L30:
        int r13 = this.e;     // Catch: Throwable -> L39
        if (r11 == r13) goto L33;
        r8.write(r12, r13, r11 - r13);     // Catch: Throwable -> L39
    L33:
        this.e = r11 + 1;     // Catch: Throwable -> L39
        String r14 = r8.toString();     // Catch: Throwable -> L39
        monitor-exit(r0);     // Catch: Throwable -> L39
        return r14;
    L38:
        throw new IOException("LineReader is closed");     // Catch: Throwable -> L39
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream r0 = this.f5288b;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.d == null) goto L7;
        this.d = null;     // Catch: Throwable -> L9
        this.f5288b.close();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }
}
