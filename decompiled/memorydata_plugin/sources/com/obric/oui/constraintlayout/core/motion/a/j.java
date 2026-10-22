package com.obric.oui.constraintlayout.core.motion.a;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b f13581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int[] f13582b;
    protected float[] c;
    private int d;
    private String e;

    private static class a {
        static void a(int[] r6, float[] r7, int r8, int r9) {
            int[] r0 = new int[r6.length + 10];
            r0[0] = r9;
            r0[1] = r8;
            int r10 = 2;
        L3:
            if (r10 <= 0) goto L7;
            int r11 = r10 - 1;
            int r1 = r0[r11];
            r10 = r11 - 1;
            int r2 = r0[r10];
            if (r1 >= r2) goto L3;
            int r3 = b(r6, r7, r1, r2);
            int r4 = r10 + 1;
            r0[r10] = r3 - 1;
            int r12 = r4 + 1;
            r0[r4] = r1;
            int r5 = r12 + 1;
            r0[r12] = r2;
            r10 = r5 + 1;
            r0[r5] = r3 + 1;
            goto L3
        }

        private static int b(int[] r3, float[] r4, int r5, int r6) {
            int r0 = r3[r6];
            int r1 = r5;
        L3:
            if (r5 >= r6) goto L8;
            if (r3[r5] > r0) goto L7;
            c(r3, r4, r1, r5);
            r1 = r1 + 1;
        L7:
            r5 = r5 + 1;
            goto L3
        L8:
            c(r3, r4, r1, r6);
            return r1;
        }

        private static void c(int[] r2, float[] r3, int r4, int r5) {
            int r0 = r2[r4];
            r2[r4] = r2[r5];
            r2[r5] = r0;
            float r6 = r3[r4];
            r3[r4] = r3[r5];
            r3[r5] = r6;
        }
    }

    public j() {
        this.f13582b = new int[10];
        this.c = new float[10];
    }

    public float a(float r3) {
        return (float) this.f13581a.a(r3, 0);
    }

    public void a(int r10) {
        int r0 = this.d;
        if (r0 != 0) goto L5;
        return;
    L5:
        a.a(this.f13582b, this.c, 0, r0 - 1);
        int r1 = 1;
        int r2 = 1;
    L7:
        if (r1 >= this.d) goto L12;
        int[] r3 = this.f13582b;
        if (r3[r1 - 1] == r3[r1]) goto L11;
        r2 = r2 + 1;
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        double[] r4 = new double[r2];
        double[][] r5 = (double[][]) Array.newInstance(double.class, new int[]{r2, 1});
        int r6 = 0;
        int r7 = 0;
    L14:
        if (r6 >= this.d) goto L21;
        if (r6 <= 0) goto L19;
        int[] r8 = this.f13582b;
        if (r8[r6] != r8[r6 - 1]) goto L19;
    L20:
        r6 = r6 + 1;
    L19:
        r4[r7] = ((double) this.f13582b[r6]) * 0.01d;
        r5[r7][0] = this.c[r6];
        r7 = r7 + 1;
        goto L20
    L21:
        this.f13581a = b.a(r10, r4, r5);
    }

    public void a(int r4, float r5) {
        int[] r0 = this.f13582b;
        if (r0.length >= (this.d + 1)) goto L5;
        this.f13582b = Arrays.copyOf(r0, r0.length * 2);
        float[] r1 = this.c;
        this.c = Arrays.copyOf(r1, r1.length * 2);
    L5:
        int[] r2 = this.f13582b;
        int r3 = this.d;
        r2[r3] = r4;
        this.c[r3] = r5;
        this.d = r3 + 1;
    }

    public void a(String r1) {
        this.e = r1;
    }

    public float b(float r3) {
        return (float) this.f13581a.b(r3, 0);
    }

    public String toString() {
        String r0 = this.e;
        DecimalFormat r1 = new DecimalFormat("##.##");
        int r2 = 0;
    L4:
        if (r2 >= this.d) goto L6;
        r0 = r0 + "[" + this.f13582b[r2] + " , " + r1.format(this.c[r2]) + "] ";
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }
}
