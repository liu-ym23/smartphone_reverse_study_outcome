package com.bumptech.glide.load.resource.bitmap;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class s extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile byte[] f1631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1633c;
    public int d;
    public int e;
    public final com.bumptech.glide.load.engine.bitmap_recycle.f f;

    public s(InputStream r5, com.bumptech.glide.load.engine.bitmap_recycle.f r10) {
        super(r5);
        this.d = -1;
        this.f = r10;
        this.f1631a = (byte[]) r10.c(65536, byte[].class);
    }

    public static void e() {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int available() {
        monitor-enter(this);
        InputStream r5 = ((FilterInputStream) this).in;     // Catch: Throwable -> L10
        if (this.f1631a == null) goto L12;
        if (r5 == null) goto L12;
        int r10 = (this.f1632b - this.e) + r5.available();
        monitor-exit(this);
        return r10;
    L12:
        e();     // Catch: Throwable -> L10
        throw null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final int b(InputStream r10, byte[] r11) {
        int r5 = this.d;
        if (r5 == (-1)) goto L25;
        int r12 = this.e - r5;
        int r13 = this.f1633c;
        if (r12 >= r13) goto L25;
        if (r5 == 0) goto L9;
    L17:
        if (r5 <= 0) goto L19;
        System.arraycopy(r11, r5, r11, 0, r11.length - r5);
    L19:
        int r14 = this.e - this.d;
        this.e = r14;
        this.d = 0;
        this.f1632b = 0;
        int r15 = r10.read(r11, r14, r11.length - r14);
        int r16 = this.e;
        if (r15 <= 0) goto L23;
        r16 = r16 + r15;
    L23:
        this.f1632b = r16;
        return r15;
    L9:
        if (r13 <= r11.length) goto L17;
        if (this.f1632b != r11.length) goto L17;
        int r17 = r11.length * 2;
        if (r17 > r13) goto L16;
        r13 = r17;
    L16:
        byte[] r18 = (byte[]) this.f.c(r13, byte[].class);
        System.arraycopy(r11, 0, r18, 0, r11.length);
        this.f1631a = r18;
        this.f.h(r11);
        r11 = r18;
    L25:
        int r19 = r10.read(r11);
        if (r19 <= 0) goto L28;
        this.d = -1;
        this.e = 0;
        this.f1632b = r19;
    L28:
        return r19;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f1631a == null) goto L5;
        this.f.h(this.f1631a);
        this.f1631a = null;
    L5:
        InputStream r5 = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (r5 == null) goto L9;
        r5.close();
        return;
    }

    public final synchronized void d() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f1631a == null) goto L9;
        this.f.h(this.f1631a);     // Catch: Throwable -> L7
        this.f1631a = null;     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int r5) {
        monitor-enter(this);
        this.f1633c = Math.max(this.f1633c, r5);     // Catch: Throwable -> L6
        this.d = this.e;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read() {
        monitor-enter(this);
        byte[] r5 = this.f1631a;     // Catch: Throwable -> L12
        InputStream r10 = ((FilterInputStream) this).in;     // Catch: Throwable -> L12
        if (r5 == null) goto L29;
        if (r10 == null) goto L29;
        if (this.e < this.f1632b) goto L15;
        if (b(r10, r5) != (-1)) goto L15;
        monitor-exit(this);
        return -1;
    L15:
        if (r5 == this.f1631a) goto L21;
        r5 = this.f1631a;     // Catch: Throwable -> L12
        if (r5 != null) goto L21;
        e();     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L21:
        int r11 = this.f1632b;     // Catch: Throwable -> L12
        int r12 = this.e;     // Catch: Throwable -> L12
        if ((r11 - r12) <= 0) goto L27;
        this.e = r12 + 1;     // Catch: Throwable -> L12
        int r13 = r5[r12] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r13;
    L27:
        monitor-exit(this);
        return -1;
    L29:
        e();     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.f1631a == null) goto L16;
        int r5 = this.d;     // Catch: Throwable -> L11
        if ((-1) == r5) goto L13;
        this.e = r5;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L13:
        final String r10 = "Mark has been invalidated, pos: " + this.e + " markLimit: " + this.f1633c;     // Catch: Throwable -> L11
        throw new RecyclableBufferedInputStream$InvalidMarkException(r10);     // Catch: Throwable -> L11
    L16:
        throw new IOException("Stream is closed");     // Catch: Throwable -> L11
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long r10) {
        monitor-enter(this);
        if (r10 >= 1) goto L48;
        monitor-exit(this);
        return 0;
    L48:
        byte[] r5 = this.f1631a;     // Catch: Throwable -> L17
        if (r5 == null) goto L44;
        InputStream r11 = ((FilterInputStream) this).in;     // Catch: Throwable -> L17
        if (r11 == null) goto L42;
        int r12 = this.f1632b;     // Catch: Throwable -> L17
        int r13 = this.e;     // Catch: Throwable -> L17
        if ((r12 - r13) < r10) goto L19;
        this.e = (int) (((long) r13) + r10);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r10;
    L19:
        long r14 = ((long) r12) - ((long) r13);
        this.e = r12;     // Catch: Throwable -> L17
        if (this.d == (-1)) goto L39;
        if (r10 > this.f1633c) goto L39;
        if (b(r11, r5) != (-1)) goto L28;
        monitor-exit(this);
        return r14;
    L28:
        int r15 = this.f1632b;     // Catch: Throwable -> L17
        int r16 = this.e;     // Catch: Throwable -> L17
        if ((r15 - r16) < (r10 - r14)) goto L33;
        this.e = (int) ((((long) r16) + r10) - r14);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r10;
    L33:
        long r17 = (r14 + ((long) r15)) - ((long) r16);
        this.e = r15;     // Catch: Throwable -> L17
        monitor-exit(this);
        return r17;
    L39:
        long r18 = r14 + r11.skip(r10 - r14);
        monitor-exit(this);
        return r18;
    L42:
        e();     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L44:
        e();     // Catch: Throwable -> L17
        throw null;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized int read(byte[] r10, int r11, int r12) {
        monitor-enter(this);
        byte[] r5 = this.f1631a;     // Catch: Throwable -> L23
        if (r5 == null) goto L69;
        if (r12 != 0) goto L10;
        monitor-exit(this);
        return 0;
    L10:
        InputStream r13 = ((FilterInputStream) this).in;     // Catch: Throwable -> L23
        if (r13 == null) goto L67;
        int r14 = this.e;     // Catch: Throwable -> L23
        int r15 = this.f1632b;     // Catch: Throwable -> L23
        if (r14 >= r15) goto L27;
        int r16 = r15 - r14;     // Catch: Throwable -> L23
        if (r16 < r12) goto L17;
        r16 = r12;
    L17:
        System.arraycopy(r5, r14, r10, r11, r16);     // Catch: Throwable -> L23
        this.e += r16;     // Catch: Throwable -> L23
        if (r16 != r12) goto L20;
    L25:
        monitor-exit(this);
        return r16;
    L20:
        if (r13.available() == 0) goto L25;
        r11 = r11 + r16;
        int r17 = r12 - r16;
    L28:
        int r18 = -1;
        if (this.d != (-1)) goto L40;
        if (r17 < r5.length) goto L40;
        int r19 = r13.read(r10, r11, r17);     // Catch: Throwable -> L23
        if (r19 == (-1)) goto L34;
    L57:
        r17 = r17 - r19;
        if (r17 == 0) goto L59;
        if (r13.available() == 0) goto L63;
        r11 = r11 + r19;
        goto L28
    L63:
        int r20 = r12 - r17;
        monitor-exit(this);
        return r20;
    L59:
        monitor-exit(this);
        return r12;
    L34:
        if (r17 == r12) goto L37;
        r18 = r12 - r17;
    L37:
        monitor-exit(this);
        return r18;
    L40:
        if (b(r13, r5) == (-1)) goto L41;
        if (r5 == this.f1631a) goto L53;
        r5 = this.f1631a;     // Catch: Throwable -> L23
        if (r5 != null) goto L53;
        e();     // Catch: Throwable -> L23
        throw null;     // Catch: Throwable -> L23
    L53:
        int r21 = this.f1632b;     // Catch: Throwable -> L23
        int r22 = this.e;     // Catch: Throwable -> L23
        r19 = r21 - r22;     // Catch: Throwable -> L23
        if (r19 < r17) goto L56;
        r19 = r17;
    L56:
        System.arraycopy(r5, r22, r10, r11, r19);     // Catch: Throwable -> L23
        this.e += r19;     // Catch: Throwable -> L23
        goto L57
    L41:
        if (r17 == r12) goto L44;
        r18 = r12 - r17;
    L44:
        monitor-exit(this);
        return r18;
    L27:
        r17 = r12;
        goto L28
    L67:
        e();     // Catch: Throwable -> L23
        throw null;     // Catch: Throwable -> L23
    L69:
        e();     // Catch: Throwable -> L23
        throw null;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }
}
