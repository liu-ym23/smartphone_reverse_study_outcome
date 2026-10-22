package com.obric.oui.constraintlayout.core.motion.a;

/* JADX INFO: loaded from: classes5.dex */
public class f extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    double[] f13575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double[] f13576b;
    private double[][] c;
    private double d;
    private boolean e;

    public f(double[] r13, double[][] r14) {
        this.d = Double.NaN;
        this.e = true;
        int r1 = r14[0].length;
        this.f13575a = new double[r1];
        this.f13576b = r13;
        this.c = r14;
        if (r1 <= 2) goto L16;
        int r3 = 0;
        double r4 = 0.0d;
        double r6 = 0.0d;
    L6:
        if (r3 >= r13.length) goto L11;
        double r8 = r14[r3][0];
        double r10 = r14[r3][0];
        if (r3 <= 0) goto L10;
        Math.hypot(r8 - r4, r10 - r6);
    L10:
        r3 = r3 + 1;
        r4 = r8;
        r6 = r10;
        goto L6
    L11:
        this.d = 0.0d;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.b
    public double a(double r9, int r11) {
        double[] r0 = this.f13576b;
        int r1 = r0.length;
        int r3 = 0;
        if (this.e == false) goto L13;
        if (r9 <= r0[0]) goto L7;
        int r2 = r1 - 1;
        if (r9 < r0[r2]) goto L21;
        return this.c[r2][r11] + ((r9 - r0[r2]) * b(r0[r2], r11));
    L21:
        if (r3 >= (r1 - 1)) goto L31;
        double[] r4 = this.f13576b;
        if (r9 == r4[r3]) goto L25;
        int r5 = r3 + 1;
        if (r9 < r4[r5]) goto L28;
        r3 = r5;
        goto L21
    L28:
        double r10 = (r9 - r4[r3]) / (r4[r5] - r4[r3]);
        double[][] r8 = this.c;
        return (r8[r3][r11] * (1.0d - r10)) + (r8[r5][r11] * r10);
    L25:
        return this.c[r3][r11];
    L31:
        return 0.0d;
    L7:
        return this.c[0][r11] + ((r9 - r0[0]) * b(r0[0], r11));
    L13:
        if (r9 <= r0[0]) goto L15;
        int r6 = r1 - 1;
        if (r9 < r0[r6]) goto L21;
        return this.c[r6][r11];
    L15:
        return this.c[0][r11];
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.b
    public void a(double r13, double[] r15) {
        double[] r0 = this.f13576b;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.c[0].length;
        if (this.e == false) goto L17;
        if (r13 > r0[0]) goto L10;
        b(r0[0], this.f13575a);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r15[r4] = this.c[0][r4] + ((r13 - this.f13576b[0]) * this.f13575a[r4]);
        r4 = r4 + 1;
        goto L7
    L9:
        return;
    L10:
        int r5 = r1 - 1;
        if (r13 < r0[r5]) goto L27;
        b(r0[r5], this.f13575a);
    L13:
        if (r3 >= r2) goto L15;
        r15[r3] = this.c[r5][r3] + ((r13 - this.f13576b[r5]) * this.f13575a[r3]);
        r3 = r3 + 1;
        goto L13
    L15:
        return;
    L27:
        int r6 = 0;
    L29:
        if (r6 >= (r1 - 1)) goto L42;
        if (r13 != this.f13576b[r6]) goto L35;
        int r7 = 0;
    L33:
        if (r7 >= r2) goto L35;
        r15[r7] = this.c[r6][r7];
        r7 = r7 + 1;
    L35:
        double[] r8 = this.f13576b;
        int r9 = r6 + 1;
        if (r13 < r8[r9]) goto L37;
        r6 = r9;
        goto L29
    L37:
        double r14 = (r13 - r8[r6]) / (r8[r9] - r8[r6]);
    L38:
        if (r3 >= r2) goto L40;
        double[][] r10 = this.c;
        r15[r3] = (r10[r6][r3] * (1.0d - r14)) + (r10[r9][r3] * r14);
        r3 = r3 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r0[0]) goto L22;
        int r16 = 0;
    L19:
        if (r16 >= r2) goto L21;
        r15[r16] = this.c[0][r16];
        r16 = r16 + 1;
        goto L19
    L21:
        return;
    L22:
        int r11 = r1 - 1;
        if (r13 < r0[r11]) goto L27;
    L24:
        if (r3 >= r2) goto L26;
        r15[r3] = this.c[r11][r3];
        r3 = r3 + 1;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.b
    public void a(double r13, float[] r15) {
        double[] r0 = this.f13576b;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.c[0].length;
        if (this.e == false) goto L17;
        if (r13 > r0[0]) goto L10;
        b(r0[0], this.f13575a);
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r15[r4] = (float) (this.c[0][r4] + ((r13 - this.f13576b[0]) * this.f13575a[r4]));
        r4 = r4 + 1;
        goto L7
    L9:
        return;
    L10:
        int r5 = r1 - 1;
        if (r13 < r0[r5]) goto L27;
        b(r0[r5], this.f13575a);
    L13:
        if (r3 >= r2) goto L15;
        r15[r3] = (float) (this.c[r5][r3] + ((r13 - this.f13576b[r5]) * this.f13575a[r3]));
        r3 = r3 + 1;
        goto L13
    L15:
        return;
    L27:
        int r6 = 0;
    L29:
        if (r6 >= (r1 - 1)) goto L42;
        if (r13 != this.f13576b[r6]) goto L35;
        int r7 = 0;
    L33:
        if (r7 >= r2) goto L35;
        r15[r7] = (float) this.c[r6][r7];
        r7 = r7 + 1;
    L35:
        double[] r8 = this.f13576b;
        int r9 = r6 + 1;
        if (r13 < r8[r9]) goto L37;
        r6 = r9;
        goto L29
    L37:
        double r14 = (r13 - r8[r6]) / (r8[r9] - r8[r6]);
    L38:
        if (r3 >= r2) goto L40;
        double[][] r10 = this.c;
        r15[r3] = (float) ((r10[r6][r3] * (1.0d - r14)) + (r10[r9][r3] * r14));
        r3 = r3 + 1;
        goto L38
    L40:
        return;
    L42:
        return;
    L17:
        if (r13 > r0[0]) goto L22;
        int r16 = 0;
    L19:
        if (r16 >= r2) goto L21;
        r15[r16] = (float) this.c[0][r16];
        r16 = r16 + 1;
        goto L19
    L21:
        return;
    L22:
        int r11 = r1 - 1;
        if (r13 < r0[r11]) goto L27;
    L24:
        if (r3 >= r2) goto L26;
        r15[r3] = (float) this.c[r11][r3];
        r3 = r3 + 1;
        goto L24
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.b
    public double[] a() {
        return this.f13576b;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.b
    public double b(double r7, int r9) {
        double[] r0 = this.f13576b;
        int r1 = r0.length;
        int r2 = 0;
        if (r7 >= r0[0]) goto L5;
        r7 = r0[0];
    L9:
        if (r2 >= (r1 - 1)) goto L15;
        double[] r3 = this.f13576b;
        int r4 = r2 + 1;
        if (r7 <= r3[r4]) goto L12;
        r2 = r4;
        goto L9
    L12:
        double r8 = r3[r4] - r3[r2];
        double[][] r6 = this.c;
        return (r6[r4][r9] - r6[r2][r9]) / r8;
    L15:
        return 0.0d;
    L5:
        int r5 = r1 - 1;
        if (r7 < r0[r5]) goto L9;
        r7 = r0[r5];
        goto L9
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.b
    public void b(double r11, double[] r13) {
        double[] r0 = this.f13576b;
        int r1 = r0.length;
        int r3 = 0;
        int r2 = this.c[0].length;
        if (r11 > r0[0]) goto L5;
        r11 = r0[0];
    L8:
        int r4 = 0;
    L10:
        if (r4 >= (r1 - 1)) goto L17;
        double[] r5 = this.f13576b;
        int r6 = r4 + 1;
        if (r11 <= r5[r6]) goto L13;
        r4 = r6;
        goto L10
    L13:
        double r12 = r5[r6] - r5[r4];
    L14:
        if (r3 >= r2) goto L21;
        double[][] r7 = this.c;
        r13[r3] = (r7[r6][r3] - r7[r4][r3]) / r12;
        r3 = r3 + 1;
        goto L14
    L21:
        return;
    L17:
        return;
    L5:
        int r8 = r1 - 1;
        if (r11 < r0[r8]) goto L8;
        r11 = r0[r8];
        goto L8
    }
}
