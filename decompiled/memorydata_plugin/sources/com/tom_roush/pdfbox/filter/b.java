package com.tom_roush.pdfbox.filter;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.msgpack.core.MessagePack;

/* JADX INFO: loaded from: classes6.dex */
final class b extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16098b;
    private boolean c;
    private byte[] d;
    private byte[] e;

    b(InputStream r1) {
        super(r1);
        this.f16097a = 0;
        this.f16098b = 0;
        this.c = false;
        this.d = new byte[5];
        this.e = new byte[4];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return 0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d = null;
        this.c = true;
        this.e = null;
        super.close();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (this.f16097a >= this.f16098b) goto L5;
    L60:
        byte[] r0 = this.e;
        int r1 = this.f16097a;
        this.f16097a = r1 + 1;
        return r0[r1] & 255;
    L5:
        if (this.c == false) goto L7;
        return -1;
    L7:
        this.f16097a = 0;
    L8:
        byte r2 = (byte) this.in.read();
        if (r2 == (-1)) goto L10;
        byte r3 = r2;
        if (r3 == 10) goto L8;
        if (r3 == 13) goto L8;
        if (r3 == 32) goto L8;
        if (r3 != 126) goto L22;
        this.c = true;
        this.e = null;
        this.d = null;
        this.f16098b = 0;
        return -1;
    L22:
        int r10 = 3;
        if (r3 != 122) goto L25;
        byte[] r4 = this.e;
        r4[3] = 0;
        r4[2] = 0;
        r4[1] = 0;
        r4[0] = 0;
        this.f16098b = 4;
        goto L60
    L25:
        this.d[0] = r3;
        int r5 = 1;
    L27:
        if (r5 >= 5) goto L40;
    L28:
        byte r12 = (byte) this.in.read();
        if (r12 == (-1)) goto L30;
        byte r13 = r12;
        if (r13 == 10) goto L28;
        if (r13 == 13) goto L28;
        if (r13 == 32) goto L28;
        byte[] r14 = this.d;
        r14[r5] = r13;
        if (r13 == 126) goto L38;
        r5 = r5 + 1;
        goto L27
    L38:
        r14[r5] = 117;
        goto L40
    L30:
        this.c = true;
        return -1;
    L40:
        int r6 = r5 - 1;
        this.f16098b = r6;
        if (r6 != 0) goto L44;
        this.c = true;
        this.d = null;
        this.e = null;
        return -1;
    L44:
        if (r5 >= 5) goto L49;
        int r7 = r5 + 1;
    L46:
        if (r7 >= 5) goto L48;
        this.d[r7] = 117;
        r7 = r7 + 1;
        goto L46
    L48:
        this.c = true;
    L49:
        long r8 = 0;
        int r9 = 0;
    L50:
        if (r9 >= 5) goto L58;
        byte r11 = (byte) (this.d[r9] + MessagePack.Code.MAP32);
        if (r11 < 0) goto L56;
        if (r11 > 93) goto L56;
        r8 = (r8 * 85) + ((long) r11);
        r9 = r9 + 1;
    L56:
        this.f16098b = 0;
        this.c = true;
        this.d = null;
        this.e = null;
        throw new IOException("Invalid data in Ascii85 stream");
    L58:
        if (r10 < 0) goto L60;
        this.e[r10] = (byte) (255 & r8);
        r8 = r8 >>> 8;
        r10 = r10 - 1;
        goto L58
    L10:
        this.c = true;
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] r7, int r8, int r9) {
        if (this.c == true) goto L5;
    L7:
        int r0 = 0;
    L8:
        if (r0 >= r9) goto L17;
        int r2 = this.f16097a;
        if (r2 >= this.f16098b) goto L12;
        byte[] r4 = this.e;
        this.f16097a = r2 + 1;
        r7[r0 + r8] = r4[r2];
    L16:
        r0 = r0 + 1;
        goto L8
    L12:
        int r3 = read();
        if (r3 == (-1)) goto L14;
        r7[r0 + r8] = (byte) r3;
        goto L16
    L14:
        return r0;
    L17:
        return r9;
    L5:
        if (this.f16097a < this.f16098b) goto L7;
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        monitor-enter(this);
    L5:
        th = move-exception;
        throw th;
    L4:
        throw new IOException("Reset is not supported");     // Catch: Throwable -> L5
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long r1) {
        return 0;
    }
}
