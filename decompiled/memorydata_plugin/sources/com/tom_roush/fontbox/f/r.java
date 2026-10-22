package com.tom_roush.fontbox.f;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
class r extends ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f16015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16016b;

    r(InputStream r6) {
        this.f16015a = null;
        this.f16016b = 0;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(r6.available());     // Catch: Throwable -> L10
        byte[] r2 = new byte[1024];     // Catch: Throwable -> L10
    L4:
        int r3 = r6.read(r2);     // Catch: Throwable -> L10
        if (r3 == (-1)) goto L7;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L10
        goto L4
    L7:
        this.f16015a = r1.toByteArray();     // Catch: Throwable -> L10
        r6.close();
        return;
    L10:
        th = move-exception;
        r6.close();
        throw th;
    }

    @Override // com.tom_roush.fontbox.f.ad
    public int a(byte[] r4, int r5, int r6) {
        int r0 = this.f16016b;
        byte[] r1 = this.f16015a;
        if (r0 >= r1.length) goto L6;
        int r7 = Math.min(r6, r1.length - r0);
        System.arraycopy(this.f16015a, this.f16016b, r4, r5, r7);
        this.f16016b += r7;
        return r7;
    L6:
        return -1;
    }

    @Override // com.tom_roush.fontbox.f.ad
    public long a() {
        return (((long) b()) << 32) + (((long) b()) & 4294967295L);
    }

    @Override // com.tom_roush.fontbox.f.ad
    public void a(long r3) {
        if (r3 < 0) goto L9;
        if (r3 > 2147483647L) goto L9;
        this.f16016b = (int) r3;
        return;
    L9:
        throw new IOException("Illegal seek position: " + r3);
    }

    public int b() {
        int r0 = c();
        int r1 = c();
        int r2 = c();
        int r4 = c();
        if ((((r0 | r1) | r2) | r4) < 0) goto L7;
        return (((r0 << 24) + (r1 << 16)) + (r2 << 8)) + r4;
    L7:
        throw new EOFException();
    }

    @Override // com.tom_roush.fontbox.f.ad
    public int c() {
        int r0 = this.f16016b;
        byte[] r1 = this.f16015a;
        if (r0 < r1.length) goto L6;
        return -1;
    L6:
        byte r2 = r1[r0];
        this.f16016b = r0 + 1;
        return (r2 + 256) % 256;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // com.tom_roush.fontbox.f.ad
    public int d() {
        int r0 = c();
        int r2 = c();
        if ((r0 | r2) < 0) goto L7;
        return (r0 << 8) + r2;
    L7:
        throw new EOFException();
    }

    @Override // com.tom_roush.fontbox.f.ad
    public short e() {
        int r0 = c();
        int r2 = c();
        if ((r0 | r2) < 0) goto L7;
        return (short) ((r0 << 8) + r2);
    L7:
        throw new EOFException();
    }

    @Override // com.tom_roush.fontbox.f.ad
    public long f() {
        return this.f16016b;
    }

    @Override // com.tom_roush.fontbox.f.ad
    public long g() {
        return this.f16015a.length;
    }
}
