package com.lynx.tasm.utils;

import com.lynx.tasm.base.LLog;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h {
    public static final double[][] a = null;
    public static final double[] b = null;
    public static final double[][] c = null;

    public static class a {
        public final double[] a;
        public final double[] b;
        public final double[] c;
        public final double[] d;
        public final double[] e;

        public final void a() {
            b(this.a);
            b(this.b);
            b(this.c);
            b(this.d);
            b(this.e);
        }

        public a() {
            this.a = new double[4];
            this.b = new double[3];
            this.c = new double[3];
            this.d = new double[3];
            this.e = new double[3];
        }

        public static void b(double[] r3) {
            int r0 = 0;
        L4:
            if (r0 >= r3.length) goto L6;
            r3[r0] = 0.0d;
            r0 = r0 + 1;
            goto L4
        }
    }

    static {
        Class r2 = Double.TYPE;
        a = (double[][]) Array.newInstance(r2, new int[]{4, 4});
        b = new double[16];
        Class r1 = Double.TYPE;
        c = (double[][]) Array.newInstance(r1, new int[]{3, 3});
    }

    public h() {
    }

    public static double b(double r2) {
        return (r2 * 3.141592653589793d) / 180.0d;
    }

    public static double c(double[] r48) {
        double r0 = r48[0];
        double r2 = r48[1];
        double r4 = r48[2];
        double r6 = r48[3];
        double r8 = r48[4];
        double r10 = r48[5];
        double r12 = r48[6];
        double r14 = r48[7];
        double r16 = r48[8];
        double r18 = r48[9];
        double r20 = r48[10];
        double r22 = r48[11];
        double r24 = r48[12];
        double r26 = r48[13];
        double r28 = r48[14];
        double r30 = r48[15];
        double r32 = r6 * r12;
        double r36 = r4 * r14;
        double r34 = ((r32 * r18) * r24) - ((r36 * r18) * r24);
        double r38 = r6 * r10;
        double r35 = r34 - ((r38 * r20) * r24);
        double r40 = r2 * r14;
        double r37 = r35 + ((r40 * r20) * r24);
        double r42 = r4 * r10;
        double r39 = r37 + ((r42 * r22) * r24);
        double r44 = r2 * r12;
        double r7 = r6 * r8;
        double r15 = r14 * r0;
        double r5 = r4 * r8;
        double r13 = r12 * r0;
        double r3 = r2 * r8;
        double r1 = r0 * r10;
        return ((((((((((((((((((r39 - ((r44 * r22) * r24)) - ((r32 * r16) * r26)) + ((r36 * r16) * r26)) + ((r7 * r20) * r26)) - ((r15 * r20) * r26)) - ((r5 * r22) * r26)) + ((r13 * r22) * r26)) + ((r38 * r16) * r28)) - ((r40 * r16) * r28)) - ((r7 * r18) * r28)) + ((r15 * r18) * r28)) + ((r3 * r22) * r28)) - ((r22 * r1) * r28)) - ((r42 * r16) * r30)) + ((r44 * r16) * r30)) + ((r5 * r18) * r30)) - ((r13 * r18) * r30)) - ((r3 * r20) * r30)) + ((r1 * r20) * r30);
    }

    public static boolean d(double r4) {
        if (Double.isNaN(r4) == false) goto L6;
        return false;
    L6:
        if (Math.abs(r4) >= 1.0E-5d) goto L9;
        return true;
    L9:
        return false;
    }

    public static double e(double r2) {
        return Math.round(r2 * 1000.0d) * 0.001d;
    }

    public static double h(double[] r4) {
        double r0 = r4[0];
        double r2 = r4[1];
        double r1 = (r0 * r0) + (r2 * r2);
        double r3 = r4[2];
        return Math.sqrt(r1 + (r3 * r3));
    }

    public static void a(double[] r110, a r111) {
        if (r110.length >= 16) goto L5;
        boolean r2 = false;
    L6:
        if (r2 == true) goto L9;
        LLog.e("lynx", "Decompose transform matrix error! transformMatrix's length less than 16!");
        return;
    L9:
        double[] r3 = r111.a;
        double[] r6 = r111.b;
        double[] r7 = r111.c;
        double[] r8 = r111.d;
        double[] r1 = r111.e;
        if (d(r110[15]) == false) goto L12;
        return;
    L12:
        double[][] r10 = a;
        double[] r11 = b;
        int r12 = 0;
    L14:
        if (r12 >= 4) goto L22;
        int r14 = 0;
    L16:
        if (r14 >= 4) goto L21;
        int r15 = (r12 * 4) + r14;
        double r19 = r110[r15] / r110[15];
        r10[r12][r14] = r19;
        if (r14 != 3) goto L20;
        r19 = 0.0d;
    L20:
        r11[r15] = r19;
        r14 = r14 + 1;
        goto L16
    L21:
        r12 = r12 + 1;
        goto L14
    L22:
        r11[15] = 1.0d;
        if (d(c(r11)) == false) goto L26;
        return;
    L26:
        if (d(r10[0][3]) == true) goto L28;
    L33:
        double[] r0 = {r10[0][3], r10[1][3], r10[2][3], r10[3][3]};
        double r16 = c(r11);
        if (d(r16) == true) goto L37;
        double r30 = r11[0];
        double r32 = r11[1];
        double r34 = r11[2];
        double r36 = r11[3];
        double r38 = r11[4];
        double r40 = r11[5];
        double r42 = r11[6];
        double r44 = r11[7];
        double r46 = r11[8];
        double r48 = r11[9];
        double r50 = r11[10];
        double r52 = r11[11];
        double r54 = r11[12];
        double r56 = r11[13];
        double r58 = r11[14];
        double r60 = r11[15];
        double r62 = r42 * r52;
        double r66 = r44 * r50;
        double r68 = r44 * r48;
        double r70 = r40 * r52;
        double r72 = r42 * r48;
        double r64 = ((((r62 * r56) - (r66 * r56)) + (r68 * r58)) - (r70 * r58)) - (r72 * r60);
        double r74 = r40 * r50;
        double r65 = r36 * r50;
        double r78 = r34 * r52;
        double r80 = r36 * r48;
        double r82 = r32 * r52;
        double r84 = r34 * r48;
        double r76 = ((((r65 * r56) - (r78 * r56)) - (r80 * r58)) + (r82 * r58)) + (r84 * r60);
        double r86 = r32 * r50;
        double r77 = r34 * r44;
        double r90 = r36 * r42;
        double r92 = r36 * r40;
        double r94 = r32 * r44;
        double r96 = r34 * r40;
        double r88 = ((((r77 * r56) - (r90 * r56)) + (r92 * r58)) - (r94 * r58)) - (r96 * r60);
        double r98 = r32 * r42;
        double r67 = (r66 * r54) - (r62 * r54);
        double r63 = r44 * r46;
        double r89 = r38 * r52;
        double r100 = r42 * r46;
        double r69 = ((r67 - (r63 * r58)) + (r89 * r58)) + (r100 * r60);
        double r102 = r38 * r50;
        double r79 = (r78 * r54) - (r65 * r54);
        double r610 = r36 * r46;
        double r611 = r30 * r52;
        double r104 = r34 * r46;
        double r106 = r30 * r50;
        double r37 = r36 * r38;
        double r45 = r44 * r30;
        double r35 = r34 * r38;
        double r43 = r42 * r30;
        double r71 = (((r70 * r54) - (r68 * r54)) + (r63 * r56)) - (r89 * r56);
        double r612 = r40 * r46;
        double r613 = r38 * r48;
        double r81 = (((r80 * r54) - (r82 * r54)) - (r610 * r56)) + (r611 * r56);
        double r614 = r32 * r46;
        double r615 = r30 * r48;
        double r33 = r32 * r38;
        double r31 = r30 * r40;
        r11 = new double[]{(r64 + (r74 * r60)) / r16, (r76 - (r86 * r60)) / r16, (r88 + (r98 * r60)) / r16, ((((((r90 * r48) - (r77 * r48)) - (r92 * r50)) + (r94 * r50)) + (r96 * r52)) - (r98 * r52)) / r16, (r69 - (r102 * r60)) / r16, ((((r79 + (r610 * r58)) - (r611 * r58)) - (r104 * r60)) + (r106 * r60)) / r16, ((((((r90 * r54) - (r77 * r54)) - (r37 * r58)) + (r45 * r58)) + (r35 * r60)) - (r43 * r60)) / r16, ((((((r77 * r46) - (r90 * r46)) + (r37 * r50)) - (r45 * r50)) - (r35 * r52)) + (r43 * r52)) / r16, ((r71 - (r612 * r60)) + (r613 * r60)) / r16, ((r81 + (r614 * r60)) - (r615 * r60)) / r16, ((((((r94 * r54) - (r92 * r54)) + (r37 * r56)) - (r45 * r56)) - (r33 * r60)) + (r60 * r31)) / r16, ((((((r92 * r46) - (r94 * r46)) - (r37 * r48)) + (r45 * r48)) + (r33 * r52)) - (r52 * r31)) / r16, ((((((r72 * r54) - (r74 * r54)) - (r100 * r56)) + (r102 * r56)) + (r612 * r58)) - (r613 * r58)) / r16, ((((((r86 * r54) - (r84 * r54)) + (r104 * r56)) - (r106 * r56)) - (r614 * r58)) + (r615 * r58)) / r16, ((((((r96 * r54) - (r54 * r98)) - (r35 * r56)) + (r56 * r43)) + (r33 * r58)) - (r58 * r31)) / r16, ((((((r98 * r46) - (r96 * r46)) + (r35 * r48)) - (r43 * r48)) - (r33 * r50)) + (r31 * r50)) / r16};
    L37:
        double r17 = r11[0];
        double r39 = r11[4];
        double r310 = r11[8];
        double r311 = r11[12];
        double r312 = r11[1];
        double r313 = r11[5];
        double r25 = r11[9];
        double r21 = r11[13];
        double r41 = r11[2];
        double r28 = r11[6];
        double r47 = r11[10];
        double r112 = r11[14];
        double r49 = r11[3];
        double r410 = r11[7];
        double r23 = r11[11];
        double r411 = r11[15];
        double r51 = r0[0];
        double r53 = r0[1];
        double r55 = r0[2];
        double r57 = r0[3];
        r3[0] = (((r17 * r51) + (r312 * r53)) + (r41 * r55)) + (r49 * r57);
        r3[1] = (((r39 * r51) + (r313 * r53)) + (r28 * r55)) + (r410 * r57);
        r3[2] = (((r310 * r51) + (r25 * r53)) + (r47 * r55)) + (r23 * r57);
        r3[3] = (((r51 * r311) + (r53 * r21)) + (r55 * r112)) + (r57 * r411);
    L38:
        int r4 = 0;
    L39:
        if (r4 >= 3) goto L41;
        r8[r4] = r10[3][r4];
        r4 = r4 + 1;
        goto L39
    L41:
        double[][] r5 = c;
        int r9 = 0;
    L42:
        if (r9 >= 3) goto L44;
        double[] r13 = r5[r9];
        double[] r18 = r10[r9];
        r13[0] = r18[0];
        r13[1] = r18[1];
        r13[2] = r18[2];
        r9 = r9 + 1;
        goto L42
    L44:
        double r20 = h(r5[0]);
        r6[0] = r20;
        double[] r22 = i(r5[0], r20);
        r5[0] = r22;
        double r24 = g(r22, r5[1]);
        r7[0] = r24;
        double[] r26 = f(r5[1], r5[0], -r24);
        r5[1] = r26;
        double r27 = h(r26);
        r6[1] = r27;
        r5[1] = i(r5[1], r27);
        r7[0] = r7[0] / r6[1];
        double r29 = g(r5[0], r5[2]);
        r7[1] = r29;
        double[] r59 = f(r5[2], r5[0], -r29);
        r5[2] = r59;
        double r61 = g(r5[1], r59);
        r7[2] = r61;
        double[] r73 = f(r5[2], r5[1], -r61);
        r5[2] = r73;
        double r75 = h(r73);
        r6[2] = r75;
        double[] r83 = i(r5[2], r75);
        r5[2] = r83;
        double r85 = r7[1];
        double r113 = r6[2];
        r7[1] = r85 / r113;
        r7[2] = r7[2] / r113;
        double[] r87 = r5[1];
        double r91 = r87[1];
        double r114 = r83[2];
        double r115 = r87[2];
        double r93 = r83[0];
        double r116 = r87[0];
        if (g(r5[0], new double[]{(r91 * r114) - (r83[1] * r115), (r115 * r93) - (r114 * r116), (r116 * r83[1]) - (r87[1] * r93)}) >= 0.0d) goto L49;
        int r95 = 0;
    L47:
        if (r95 >= 3) goto L49;
        r6[r95] = r6[r95] * (-1.0d);
        double[] r97 = r5[r95];
        r97[0] = r97[0] * (-1.0d);
        r97[1] = r97[1] * (-1.0d);
        r97[2] = r97[2] * (-1.0d);
        r95 = r95 + 1;
    L49:
        double[] r99 = r5[2];
        r1[0] = e((-Math.atan2(r99[1], r99[2])) * 57.29577951308232d);
        double[] r101 = r5[2];
        double r103 = -r101[0];
        double r117 = r101[1];
        double r118 = r101[2];
        r1[1] = e((-Math.atan2(r103, Math.sqrt((r117 * r117) + (r118 * r118)))) * 57.29577951308232d);
        r1[2] = e((-Math.atan2(r5[1][0], r5[0][0])) * 57.29577951308232d);
        return;
    L28:
        if (d(r10[1][3]) == false) goto L33;
        if (d(r10[2][3]) == false) goto L33;
        r3[2] = 0.0d;
        r3[1] = 0.0d;
        r3[0] = 0.0d;
        r3[3] = 1.0d;
        goto L38
    L5:
        r2 = true;
        goto L6
    }

    public static double g(double[] r7, double[] r8) {
        return ((r7[0] * r8[0]) + (r7[1] * r8[1])) + (r7[2] * r8[2]);
    }

    public static double[] i(double[] r4, double r5) {
        if (d(r5) == false) goto L5;
        r5 = h(r4);
    L5:
        double r0 = 1.0d / r5;
        return new double[]{r4[0] * r0, r4[1] * r0, r4[2] * r0};
    }

    public static double[] f(double[] r8, double[] r9, double r10) {
        return new double[]{(r8[0] * 1.0d) + (r9[0] * r10), (r8[1] * 1.0d) + (r9[1] * r10), (1.0d * r8[2]) + (r10 * r9[2])};
    }
}
