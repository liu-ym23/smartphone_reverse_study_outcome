package com.tom_roush.fontbox.b;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f15940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15941b;

    public r(byte[] r2) {
        this.f15941b = 0;
        this.f15940a = r2;
    }

    private int a() {
        byte[] r0 = this.f15940a;     // Catch: RuntimeException -> L4
        int r1 = this.f15941b;     // Catch: RuntimeException -> L4
        int r2 = r0[r1] & 255;     // Catch: RuntimeException -> L4
        this.f15941b = r1 + 1;     // Catch: RuntimeException -> L4
        return r2;
    L4:
        return -1;
    }

    private int a(int r2) {
        return this.f15940a[this.f15941b + r2] & 255;
    L5:
        return -1;
    }

    public void b(int r1) {
        this.f15941b = r1;
    }

    public int c(int r1) {
        int r0 = a(r1);
        if (r0 < 0) goto L6;
        return r0;
    L6:
        throw new EOFException();
    }

    public byte[] d(int r5) {
        if (r5 < 0) goto L10;
        byte[] r0 = this.f15940a;
        int r1 = r0.length;
        int r2 = this.f15941b;
        if ((r1 - r2) < r5) goto L8;
        byte[] r3 = new byte[r5];
        System.arraycopy(r0, r2, r3, 0, r5);
        this.f15941b += r5;
        return r3;
    L8:
        throw new EOFException();
    L10:
        throw new IOException("length is negative");
    }

    public boolean e() {
        if (this.f15941b >= this.f15940a.length) goto L5;
        return true;
    L5:
        return false;
    }

    public int f() {
        return this.f15941b;
    }

    public byte g() {
        byte[] r0 = this.f15940a;     // Catch: RuntimeException -> L4
        int r1 = this.f15941b;     // Catch: RuntimeException -> L4
        byte r2 = r0[r1];     // Catch: RuntimeException -> L4
        this.f15941b = r1 + 1;     // Catch: RuntimeException -> L4
        return r2;
    L4:
        return -1;
    }

    public int h() {
        int r0 = a();
        if (r0 < 0) goto L6;
        return r0;
    L6:
        throw new EOFException();
    }

    public short i() {
        return (short) j();
    }

    public int j() {
        int r0 = a();
        int r2 = a();
        if ((r0 | r2) < 0) goto L7;
        return r2 | (r0 << 8);
    L7:
        throw new EOFException();
    }

    public int k() {
        int r0 = a();
        int r1 = a();
        int r2 = a();
        int r4 = a();
        if ((((r0 | r1) | r2) | r4) < 0) goto L7;
        return r4 | (((r0 << 24) | (r1 << 16)) | (r2 << 8));
    L7:
        throw new EOFException();
    }

    public int l() {
        return this.f15940a.length;
    }
}
