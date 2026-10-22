package com.tom_roush.fontbox.c;

/* JADX INFO: loaded from: classes6.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f15959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f15960b;
    private int c;

    public d() {
        this.c = 0;
    }

    public d(byte[] r4, byte[] r5) {
        int r0 = 0;
        this.c = 0;
        if (r4.length == r5.length) goto L10;
        if (r4.length != 1) goto L10;
        if (r4[0] != 0) goto L10;
        r4 = new byte[r5.length];
    L11:
        this.f15959a = new int[r4.length];
        this.f15960b = new int[r5.length];
    L13:
        if (r0 >= r4.length) goto L15;
        this.f15959a[r0] = r4[r0] & 255;
        this.f15960b[r0] = r5[r0] & 255;
        r0 = r0 + 1;
        goto L13
    L15:
        this.c = r5.length;
        return;
    L10:
        if (r4.length == r5.length) goto L11;
        throw new IllegalArgumentException("The start and the end values must not have different lengths.");
    }

    public int a() {
        return this.c;
    }

    public boolean a(byte[] r4, int r5) {
        if (this.c == r5) goto L5;
        return false;
    L5:
        int r6 = 0;
    L7:
        if (r6 >= this.c) goto L15;
        int r0 = r4[r6] & 255;
        if (r0 < this.f15959a[r6]) goto L14;
        if (r0 > this.f15960b[r6]) goto L14;
        r6 = r6 + 1;
    L14:
        return false;
    L15:
        return true;
    }
}
