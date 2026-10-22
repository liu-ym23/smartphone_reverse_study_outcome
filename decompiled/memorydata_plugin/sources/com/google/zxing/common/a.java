package com.google.zxing.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f5064a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f5065b;
    private int c;

    static {
        f5064a = new int[0];
    }

    public a() {
        this.c = 0;
        this.f5065b = f5064a;
    }

    a(int[] r1, int r2) {
        this.f5065b = r1;
        this.c = r2;
    }

    private void b(int r4) {
        if (r4 <= (this.f5065b.length * 32)) goto L6;
        int[] r5 = c((int) Math.ceil(r4 / 0.75f));
        int[] r0 = this.f5065b;
        System.arraycopy(r0, 0, r5, 0, r0.length);
        this.f5065b = r5;
        return;
    }

    private static int[] c(int r0) {
        return new int[(r0 + 31) / 32];
    }

    public int a() {
        return this.c;
    }

    public void a(int r7, int r8) {
        if (r8 < 0) goto L14;
        if (r8 > 32) goto L14;
        int r0 = this.c;
        b(r0 + r8);
        int r9 = r8 - 1;
    L6:
        if (r9 < 0) goto L11;
        if (((1 << r9) & r7) == 0) goto L10;
        int[] r2 = this.f5065b;
        int r3 = r0 / 32;
        r2[r3] = r2[r3] | (1 << (r0 & 31));
    L10:
        r0 = r0 + 1;
        r9 = r9 - 1;
        goto L6
    L11:
        this.c = r0;
        return;
    L14:
        throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }

    public void a(int r7, byte[] r8, int r9, int r10) {
        int r1 = 0;
    L3:
        if (r1 >= r10) goto L12;
        int r2 = 0;
        int r3 = 0;
    L6:
        if (r2 >= 8) goto L11;
        if (a(r7) == false) goto L10;
        r3 = r3 | (1 << (7 - r2));
    L10:
        r7 = r7 + 1;
        r2 = r2 + 1;
        goto L6
    L11:
        r8[r9 + r1] = (byte) r3;
        r1 = r1 + 1;
        goto L3
    }

    public void a(a r4) {
        int r0 = r4.c;
        b(this.c + r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(r4.a(r1));
        r1 = r1 + 1;
        goto L3
    }

    public void a(boolean r5) {
        b(this.c + 1);
        if (r5 == false) goto L5;
        int[] r6 = this.f5065b;
        int r0 = this.c;
        int r2 = r0 / 32;
        r6[r2] = (1 << (r0 & 31)) | r6[r2];
    L5:
        this.c++;
    }

    public boolean a(int r2) {
        if ((this.f5065b[r2 / 32] & (1 << (r2 & 31))) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    public int b() {
        return (this.c + 7) / 8;
    }

    public void b(a r5) {
        if (this.c != r5.c) goto L10;
        int r0 = 0;
    L5:
        int[] r1 = this.f5065b;
        if (r0 >= r1.length) goto L8;
        r1[r0] = r1[r0] ^ r5.f5065b[r0];
        r0 = r0 + 1;
        goto L5
    L8:
        return;
    L10:
        throw new IllegalArgumentException("Sizes don't match");
    }

    public a c() {
        return new a((int[]) ZeusTransformUtils.preCheckCast(this.f5065b.clone(), int[].class, "com.obric.memorydata.plugin"), this.c);
    }

    public /* synthetic */ Object clone() {
        return c();
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, a.class) == true) goto L5;
        return false;
    L5:
        a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
        if (this.c == r5.c) goto L8;
        return false;
    L8:
        if (Arrays.equals(this.f5065b, r5.f5065b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return (this.c * 31) + Arrays.hashCode(this.f5065b);
    }

    public String toString() {
        int r1 = this.c;
        StringBuilder r0 = new StringBuilder((r1 + (r1 / 8)) + 1);
        int r2 = 0;
    L4:
        if (r2 >= this.c) goto L14;
        if ((r2 & 7) != 0) goto L9;
        r0.append(' ');
    L9:
        if (a(r2) == false) goto L11;
        char r3 = 'X';
    L12:
        r0.append(r3);
        r2 = r2 + 1;
        goto L4
    L11:
        r3 = '.';
        goto L12
    L14:
        return r0.toString();
    }
}
