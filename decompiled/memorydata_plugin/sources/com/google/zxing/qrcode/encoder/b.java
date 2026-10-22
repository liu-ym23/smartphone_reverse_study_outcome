package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f5110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5111b;
    private final int c;

    public b(int r3, int r4) {
        this.f5110a = (byte[][]) Array.newInstance(byte.class, new int[]{r4, r3});
        this.f5111b = r3;
        this.c = r4;
    }

    public byte a(int r1, int r2) {
        return this.f5110a[r2][r1];
    }

    public int a() {
        return this.c;
    }

    public void a(byte r4) {
        byte[][] r3 = this.f5110a;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Arrays.fill(r3[r1], r4);
        r1 = r1 + 1;
        goto L3
    }

    public void a(int r1, int r2, int r3) {
        this.f5110a[r2][r1] = (byte) r3;
    }

    public void a(int r1, int r2, boolean r3) {
        this.f5110a[r2][r1] = r3 ? 1 : 0;
    }

    public int b() {
        return this.f5111b;
    }

    public byte[][] c() {
        return this.f5110a;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(((this.f5111b * 2) * this.c) + 2);
        int r2 = 0;
    L4:
        if (r2 >= this.c) goto L18;
        byte[] r3 = this.f5110a[r2];
        int r4 = 0;
    L7:
        if (r4 >= this.f5111b) goto L16;
        byte r5 = r3[r4];
        if (r5 != 0) goto L11;
        String r6 = " 0";
    L15:
        r0.append(r6);
        r4 = r4 + 1;
        goto L7
    L11:
        if (r5 == 1) goto L13;
        r6 = "  ";
        goto L15
    L13:
        r6 = " 1";
        goto L15
    L16:
        r0.append('\n');
        r2 = r2 + 1;
        goto L4
    L18:
        return r0.toString();
    }
}
