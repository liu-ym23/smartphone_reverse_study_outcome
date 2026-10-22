package com.google.zxing.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f5067b;
    private int c;
    private int[] d;

    public b(int r2, int r3) {
        if (r2 < 1) goto L8;
        if (r3 < 1) goto L8;
        this.f5066a = r2;
        this.f5067b = r3;
        int r4 = (r2 + 31) / 32;
        this.c = r4;
        this.d = new int[r4 * r3];
        return;
    L8:
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    private b(int r1, int r2, int r3, int[] r4) {
        this.f5066a = r1;
        this.f5067b = r2;
        this.c = r3;
        this.d = r4;
    }

    private String a(String r6, String r7, String r8) {
        StringBuilder r0 = new StringBuilder(this.f5067b * (this.f5066a + 1));
        int r2 = 0;
    L4:
        if (r2 >= this.f5067b) goto L15;
        int r3 = 0;
    L7:
        if (r3 >= this.f5066a) goto L13;
        if (a(r3, r2) == false) goto L11;
        String r4 = r6;
    L12:
        r0.append(r4);
        r3 = r3 + 1;
        goto L7
    L11:
        r4 = r7;
        goto L12
    L13:
        r0.append(r8);
        r2 = r2 + 1;
        goto L4
    L15:
        return r0.toString();
    }

    public b a() {
        return new b(this.f5066a, this.f5067b, this.c, (int[]) ZeusTransformUtils.preCheckCast(this.d.clone(), int[].class, "com.obric.memorydata.plugin"));
    }

    public String a(String r2, String r3) {
        return a(r2, r3, "\n");
    }

    public void a(int r8, int r9, int r10, int r11) {
        if (r9 < 0) goto L22;
        if (r8 < 0) goto L22;
        if (r11 < 1) goto L20;
        if (r10 < 1) goto L20;
        int r12 = r10 + r8;
        int r13 = r11 + r9;
        if (r13 > this.f5067b) goto L18;
        if (r12 > this.f5066a) goto L18;
    L11:
        if (r9 >= r13) goto L16;
        int r1 = this.c * r9;
        int r2 = r8;
    L13:
        if (r2 >= r12) goto L15;
        int[] r3 = this.d;
        int r4 = (r2 / 32) + r1;
        r3[r4] = r3[r4] | (1 << (r2 & 31));
        r2 = r2 + 1;
        goto L13
    L15:
        r9 = r9 + 1;
        goto L11
    L16:
        return;
    L18:
        throw new IllegalArgumentException("The region must fit inside the matrix");
    L20:
        throw new IllegalArgumentException("Height and width must be at least 1");
    L22:
        throw new IllegalArgumentException("Left and top must be nonnegative");
    }

    public boolean a(int r2, int r3) {
        int r4 = (r3 * this.c) + (r2 / 32);
        if (((this.d[r4] >>> (r2 & 31)) & 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public void b(int r3, int r4) {
        int r5 = (r4 * this.c) + (r3 / 32);
        int[] r2 = this.d;
        int r6 = 1 << (r3 & 31);
        r2[r5] = r6 ^ r2[r5];
    }

    public /* synthetic */ Object clone() {
        return a();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, b.class) == true) goto L5;
        return false;
    L5:
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");
        if (this.f5066a == r5.f5066a) goto L8;
        return false;
    L8:
        if (this.f5067b == r5.f5067b) goto L10;
        return false;
    L10:
        if (this.c == r5.c) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.d, r5.d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = this.f5066a;
        return (((((((r0 * 31) + r0) * 31) + this.f5067b) * 31) + this.c) * 31) + Arrays.hashCode(this.d);
    }

    public String toString() {
        return a("X ", "  ");
    }
}
