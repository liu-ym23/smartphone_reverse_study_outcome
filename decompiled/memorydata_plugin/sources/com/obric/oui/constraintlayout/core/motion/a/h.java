package com.obric.oui.constraintlayout.core.motion.a;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f13579a = "Oscillator";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    float[] f13580b;
    double[] c;
    double[] d;
    String e;
    g f;
    int g;
    double h;
    private boolean i;

    static {
    }

    public h() {
        this.f13580b = new float[0];
        this.c = new double[0];
        this.h = 6.283185307179586d;
        this.i = false;
    }

    double a(double r11) {
        if (r11 > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (r11 < 1.0d) goto L8;
        return 1.0d;
    L8:
        int r0 = Arrays.binarySearch(this.c, r11);
        if (r0 >= 0) goto L11;
        r0 = (-r0) - 1;
    L11:
        float[] r1 = this.f13580b;
        int r3 = r0 - 1;
        double r4 = r1[r0] - r1[r3];
        double[] r2 = this.c;
        double r5 = r4 / (r2[r0] - r2[r3]);
        return (this.d[r3] + ((((double) r1[r3]) - (r2[r3] * r5)) * (r11 - r2[r3]))) + ((r5 * ((r11 * r11) - (r2[r3] * r2[r3]))) / 2.0d);
    }

    public double a(double r8, double r10) {
        double r9 = a(r8) + r10;
        switch(this.g) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L5;
        };
    L8:
        double r7 = 1.0d - Math.abs(((r9 * 4.0d) % 4.0d) - 2.0d);
        return 1.0d - (r7 * r7);
    L5:
        return Math.sin(this.h * r9);
    L7:
        return this.f.a(r9 % 1.0d, 0);
    L11:
        return Math.cos(this.h * (r10 + r9));
    L13:
        return 1.0d - (((r9 * 2.0d) + 1.0d) % 2.0d);
    L15:
        return (((r9 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
    L17:
        return 1.0d - Math.abs((((r9 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
    L19:
        return Math.signum(0.5d - (r9 % 1.0d));
    }

    public double a(double r5, double r7, double r9) {
        double r8 = r7 + a(r5);
        double r6 = b(r5) + r9;
        switch(this.g) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L4:
        double r10 = this.h;
        double r11 = r6 * r10;
        double r12 = Math.cos(r10 * r8);
    L6:
        return r11 * r12;
    L9:
        r11 = r6 * 4.0d;
        r12 = (((r8 * 4.0d) + 2.0d) % 4.0d) - 2.0d;
        goto L6
    L10:
        double r13 = this.h;
        return ((-r13) * r6) * Math.sin(r13 * r8);
    L16:
        r11 = r6 * 4.0d;
        r12 = Math.signum((((r8 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
        goto L6
    L17:
        return 0.0d;
    L8:
        return this.f.b(r8 % 1.0d, 0);
    L13:
        return (-r6) * 2.0d;
    L15:
        return r6 * 2.0d;
    }

    public void a() {
        int r3 = 0;
        double r4 = 0.0d;
    L3:
        float[] r6 = this.f13580b;
        if (r3 >= r6.length) goto L6;
        r4 = r4 + ((double) r6[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        double r7 = 0.0d;
        int r8 = 1;
    L7:
        float[] r9 = this.f13580b;
        if (r8 >= r9.length) goto L10;
        int r10 = r8 - 1;
        float r12 = (r9[r10] + r9[r8]) / 2.0f;
        double[] r11 = this.c;
        r7 = r7 + ((r11[r8] - r11[r10]) * ((double) r12));
        r8 = r8 + 1;
        goto L7
    L10:
        int r13 = 0;
    L11:
        float[] r14 = this.f13580b;
        if (r13 >= r14.length) goto L14;
        r14[r13] = r14[r13] * ((float) (r4 / r7));
        r13 = r13 + 1;
        goto L11
    L14:
        this.d[0] = 0.0d;
        int r0 = 1;
    L15:
        float[] r1 = this.f13580b;
        if (r0 >= r1.length) goto L18;
        int r2 = r0 - 1;
        float r5 = (r1[r2] + r1[r0]) / 2.0f;
        double[] r15 = this.c;
        double r16 = r15[r0] - r15[r2];
        double[] r17 = this.d;
        r17[r0] = r17[r2] + (r16 * ((double) r5));
        r0 = r0 + 1;
        goto L15
    L18:
        this.i = true;
    }

    public void a(double r5, float r7) {
        int r0 = this.f13580b.length + 1;
        int r1 = Arrays.binarySearch(this.c, r5);
        if (r1 >= 0) goto L5;
        r1 = (-r1) - 1;
    L5:
        this.c = Arrays.copyOf(this.c, r0);
        this.f13580b = Arrays.copyOf(this.f13580b, r0);
        this.d = new double[r0];
        double[] r2 = this.c;
        System.arraycopy(r2, r1, r2, r1 + 1, (r0 - r1) - 1);
        this.c[r1] = r5;
        this.f13580b[r1] = r7;
        this.i = false;
    }

    public void a(int r1, String r2) {
        this.g = r1;
        this.e = r2;
        if (r2 == null) goto L6;
        this.f = g.a(r2);
        return;
    }

    double b(double r11) {
        if (r11 > 0.0d) goto L6;
        return 0.0d;
    L6:
        if (r11 < 1.0d) goto L8;
        return 1.0d;
    L8:
        int r0 = Arrays.binarySearch(this.c, r11);
        if (r0 >= 0) goto L11;
        r0 = (-r0) - 1;
    L11:
        float[] r1 = this.f13580b;
        int r3 = r0 - 1;
        double r4 = r1[r0] - r1[r3];
        double[] r10 = this.c;
        double r5 = r4 / (r10[r0] - r10[r3]);
        return (r11 * r5) + (((double) r1[r3]) - (r5 * r10[r3]));
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.c) + " period=" + Arrays.toString(this.f13580b);
    }
}
