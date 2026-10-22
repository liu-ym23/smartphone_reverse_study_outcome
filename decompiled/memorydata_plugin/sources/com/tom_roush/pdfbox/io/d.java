package com.tom_roush.pdfbox.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.EOFException;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class d extends InputStream implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16116b;
    private int c;
    private File d;
    private byte[] e;
    private final Map<Long, byte[]> f;
    private long g;
    private byte[] h;
    private int i;
    private final RandomAccessFile j;
    private final long k;
    private long l;
    private boolean m;

    static /* synthetic */ int a(d r0) {
        return r0.c;
    }

    static /* synthetic */ byte[] a(d r0, byte[] r1) {
        r0.e = r1;
        return r1;
    }

    private void f() {
        File r0 = this.d;
        if (r0 == null) goto L6;
        r0.delete();
        return;
    }

    private byte[] g() {
        byte[] r0 = this.e;
        if (r0 == null) goto L5;
        this.e = null;
    L6:
        int r1 = 0;
    L7:
        int r2 = this.f16115a;
        if (r1 >= r2) goto L13;
        int r3 = this.j.read(r0, r1, r2 - r1);
        if (r3 < 0) goto L13;
        r1 = r1 + r3;
    L13:
        return r0;
    L5:
        r0 = new byte[this.f16115a];
        goto L6
    }

    @Override // com.tom_roush.pdfbox.io.g
    public long a() {
        return this.l;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public void a(int r5) {
        a(a() - ((long) r5));
    }

    @Override // com.tom_roush.pdfbox.io.g
    public void a(long r6) {
        long r0 = this.f16116b & r6;
        if (r0 == this.g) goto L8;
        byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast(this.f.get(Long.valueOf(r0)), byte[].class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        this.j.seek(r0);
        r2 = g();
        this.f.put(Long.valueOf(r0), r2);
    L7:
        this.g = r0;
        this.h = r2;
    L8:
        this.i = (int) (r6 - this.g);
        this.l = r6;
    }

    @Override // java.io.InputStream
    public int available() {
        return (int) Math.min(this.k - this.l, 2147483647L);
    }

    @Override // com.tom_roush.pdfbox.io.g
    public long b() {
        return this.k;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public byte[] b(int r4) {
        byte[] r0 = new byte[r4];
        int r1 = 0;
    L3:
        int r2 = read(r0, r1, r4 - r1);
        if (r2 < 0) goto L9;
        r1 = r1 + r2;
        if (r1 < r4) goto L3;
        return r0;
    L9:
        throw new EOFException();
    }

    @Override // com.tom_roush.pdfbox.io.g
    public boolean c() {
        return this.m;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.j.close();
        f();
        this.f.clear();
        this.m = true;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public int d() {
        int r0 = read();
        if (r0 == (-1)) goto L5;
        a(1);
    L5:
        return r0;
    }

    @Override // com.tom_roush.pdfbox.io.g
    public boolean e() {
        if (d() != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.io.InputStream, com.tom_roush.pdfbox.io.g
    public int read() {
        long r0 = this.l;
        if (r0 < this.k) goto L7;
        return -1;
    L7:
        if (this.i != this.f16115a) goto L9;
        a(r0);
    L9:
        this.l++;
        byte[] r1 = this.h;
        int r2 = this.i;
        this.i = r2 + 1;
        return r1[r2] & 255;
    }

    @Override // java.io.InputStream, com.tom_roush.pdfbox.io.g
    public int read(byte[] r3) {
        return read(r3, 0, r3.length);
    }

    @Override // java.io.InputStream, com.tom_roush.pdfbox.io.g
    public int read(byte[] r9, int r10, int r11) {
        long r0 = this.l;
        if (r0 < this.k) goto L7;
        return -1;
    L7:
        if (this.i != this.f16115a) goto L9;
        a(r0);
    L9:
        int r12 = Math.min(this.f16115a - this.i, r11);
        long r1 = this.k;
        long r2 = this.l;
        if ((r1 - r2) >= this.f16115a) goto L12;
        r12 = Math.min(r12, (int) (r1 - r2));
    L12:
        System.arraycopy(this.h, this.i, r9, r10, r12);
        this.i += r12;
        this.l += (long) r12;
        return r12;
    }

    @Override // java.io.InputStream
    public long skip(long r9) {
        long r0 = this.k;
        long r2 = this.l;
        if ((r0 - r2) >= r9) goto L5;
        r9 = r0 - r2;
    L5:
        int r1 = this.f16115a;
        if (r9 >= r1) goto L10;
        int r3 = this.i;
        if ((((long) r3) + r9) > r1) goto L10;
        this.i = (int) (((long) r3) + r9);
        this.l = r2 + r9;
    L11:
        return r9;
    L10:
        a(r2 + r9);
        goto L11
    }
}
