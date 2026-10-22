package com.lynx.tasm.behavior.ui.utils;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final int[] e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f10755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10757c;
    public boolean d;

    static {
        e = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256};
    }

    public l(float r5) {
        this.f10755a = new float[]{1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f, 1.0E21f};
        this.f10756b = 0;
        this.f10757c = r5;
    }

    public final float a(int r10) {
        if (r10 != 4) goto L5;
    L8:
        float r5 = 1.0E21f;
    L9:
        int r11 = this.f10756b;
        if (r11 == 0) goto L33;
        int[] r12 = e;
        int r13 = r12[r10] & r11;
        float[] r14 = this.f10755a;
        if (r13 == 0) goto L17;
        return r14[r10];
    L17:
        if (this.d == false) goto L33;
        if (r10 != 1) goto L21;
    L24:
        char r15 = 7;
    L26:
        if ((r12[r15] & r11) == 0) goto L30;
        return r14[r15];
    L30:
        if ((r12[8] & r11) == 0) goto L33;
        return r14[8];
    L21:
        if (r10 == 3) goto L24;
        r15 = 6;
    L33:
        return r5;
    L5:
        if (r10 == 5) goto L8;
        r5 = this.f10757c;
        goto L9
    }

    public final boolean b(float r5, int r10) {
        float[] r11 = this.f10755a;
        boolean r12 = false;
        if (com.lynx.tasm.utils.a.k(r11[r10], r5) == true) goto L17;
        r11[r10] = r5;
        boolean r13 = ym.k.b(r5);
        int[] r14 = e;
        if (r13 == false) goto L7;
        this.f10756b &= ~r14[r10];
    L8:
        int r15 = this.f10756b;
        if ((r14[8] & r15) == 0) goto L11;
    L14:
        r12 = true;
    L15:
        this.d = r12;
        return true;
    L11:
        if ((r14[7] & r15) != 0) goto L14;
        if ((r15 & r14[6]) == 0) goto L15;
    L7:
        this.f10756b |= r14[r10];
        goto L8
    L17:
        return false;
    }
}
