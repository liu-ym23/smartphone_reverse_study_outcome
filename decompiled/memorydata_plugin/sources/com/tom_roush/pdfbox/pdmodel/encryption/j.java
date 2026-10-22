package com.tom_roush.pdfbox.pdmodel.encryption;

import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f16205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16206b;
    private int c;

    j() {
        this.f16205a = new int[256];
    }

    private static int a(byte r0) {
        if (r0 < 0) goto L4;
        return r0;
    L4:
        return r0 + 256;
    }

    private static void a(int[] r2, int r3, int r4) {
        int r0 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r0;
    }

    public void a(byte r5, OutputStream r6) {
        int r0 = (this.f16206b + 1) % 256;
        this.f16206b = r0;
        int[] r1 = this.f16205a;
        int r2 = (r1[r0] + this.c) % 256;
        this.c = r2;
        a(r1, r0, r2);
        int[] r3 = this.f16205a;
        r6.write(((byte) r3[(r3[this.f16206b] + r3[this.c]) % 256]) ^ r5);
    }

    public void a(InputStream r4, OutputStream r5) {
        byte[] r0 = new byte[1024];
    L3:
        int r1 = r4.read(r0);
        if (r1 == (-1)) goto L6;
        a(r0, 0, r1, r5);
        goto L3
    }

    public void a(byte[] r8) {
        int r0 = 0;
        this.f16206b = 0;
        this.c = 0;
        if (r8.length < 1) goto L16;
        if (r8.length > 32) goto L16;
        int r1 = 0;
    L7:
        int[] r3 = this.f16205a;
        if (r1 >= r3.length) goto L10;
        r3[r1] = r1;
        r1 = r1 + 1;
        goto L7
    L10:
        int r2 = 0;
        int r4 = 0;
    L12:
        if (r0 >= this.f16205a.length) goto L14;
        int r5 = a(r8[r2]);
        int[] r6 = this.f16205a;
        r4 = ((r5 + r6[r0]) + r4) % 256;
        a(r6, r0, r4);
        r2 = (r2 + 1) % r8.length;
        r0 = r0 + 1;
        goto L12
    L14:
        return;
    L16:
        throw new IllegalArgumentException("number of bytes must be between 1 and 32");
    }

    public void a(byte[] r3, int r4, int r5, OutputStream r6) {
        int r0 = r4;
    L4:
        if (r0 >= (r4 + r5)) goto L6;
        a(r3[r0], r6);
        r0 = r0 + 1;
        goto L4
    }

    public void a(byte[] r4, OutputStream r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(r4[r1], r5);
        r1 = r1 + 1;
        goto L3
    }
}
