package com.lynx.tasm.utils;

import ai.j0;
import com.lynx.base.log.LynxLog;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double[][] f11168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final double[] f11169b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final double[][] f11170c = null;

    static {
        Class r5 = Double.TYPE;
        f11168a = (double[][]) Array.newInstance(r5, new int[]{4, 4});
        f11169b = new double[16];
        f11170c = (double[][]) Array.newInstance(r5, new int[]{3, 3});
    }

    public static double a(double[] r53) {
        double r5 = r53[0];
        double r10 = r53[1];
        double r11 = r53[2];
        double r12 = r53[3];
        double r13 = r53[4];
        double r14 = r53[5];
        double r15 = r53[6];
        double r16 = r53[7];
        double r25 = r53[8];
        double r27 = r53[9];
        double r29 = r53[10];
        double r31 = r53[11];
        double r33 = r53[12];
        double r35 = r53[13];
        double r37 = r53[14];
        double r39 = r53[15];
        double r41 = r12 * r15;
        double r43 = r11 * r16;
        double r45 = r12 * r14;
        double r47 = r10 * r16;
        double r49 = r11 * r14;
        double r51 = r10 * r15;
        double r17 = r12 * r13;
        double r18 = r16 * r5;
        double r19 = r11 * r13;
        double r110 = r15 * r5;
        double r20 = r10 * r13;
        double r21 = r5 * r14;
        return j0.B(r21, r29, r39, (j0.B(r19, r27, r39, j0.B(r51, r25, r39, (j0.B(r20, r31, r37, j0.B(r18, r27, r37, (j0.B(r45, r25, r37, j0.B(r110, r31, r35, (j0.B(r17, r29, r35, j0.B(r43, r25, r35, (j0.B(r49, r31, r33, j0.B(r47, r29, r33, (((r41 * r27) * r33) - ((r43 * r27) * r33)) - ((r45 * r29) * r33))) - ((r51 * r31) * r33)) - ((r41 * r25) * r35))) - ((r18 * r29) * r35)) - ((r19 * r31) * r35))) - ((r47 * r25) * r37)) - ((r17 * r27) * r37))) - ((r31 * r21) * r37)) - ((r49 * r25) * r39))) - ((r110 * r27) * r39)) - ((r20 * r29) * r39));
    }

    public static double b(double[] r10, double[] r11) {
        double r5 = r10[0] * r11[0];
        double r12 = (r10[1] * r11[1]) + r5;
        return (r10[2] * r11[2]) + r12;
    }

    public static void c(double[] r118, jk.a r119) {
        if (r118.length >= 16) goto L6;
        LynxLog.b(4, "lynx", "Decompose transform matrix error! transformMatrix's length less than 16!");
        return;
    L6:
        double[] r11 = (double[]) r119.f18349a;
        if (d(r118[15]) == true) goto L56;
        int r10 = 0;
    L10:
        double[][] r23 = f11168a;
        double[] r24 = f11169b;
        if (r10 >= 4) goto L19;
        int r12 = 0;
    L13:
        if (r12 >= 4) goto L18;
        int r26 = (r10 * 4) + r12;
        double r27 = r118[r26] / r118[15];
        r23[r10][r12] = r27;
        if (r12 != 3) goto L17;
        r27 = 0.0d;
    L17:
        r24[r26] = r27;
        r12 = r12 + 1;
        goto L13
    L18:
        r10 = r10 + 1;
        goto L10
    L19:
        r24[15] = 1.0d;
        if (d(a(r24)) == false) goto L23;
        return;
    L23:
        if (d(r23[0][3]) == true) goto L25;
    L30:
        double[] r5 = {r23[0][3], r23[1][3], r23[2][3], r23[3][3]};
        double r13 = a(r24);
        if (d(r13) == false) goto L33;
        char r14 = '\f';
        char r18 = '\r';
    L34:
        double[] r15 = {r24[0], r24[4], r24[8], r24[r14], r24[1], r24[5], r24[9], r24[r18], r24[2], r24[6], r24[10], r24[14], r24[3], r24[7], r24[11], r24[15]};
        double r16 = r5[0];
        double r28 = r5[1];
        double r29 = r5[2];
        double r30 = r5[3];
        r11[0] = (r15[12] * r30) + ((r15[8] * r29) + ((r15[4] * r28) + (r15[0] * r16)));
        r11[1] = (r15[13] * r30) + ((r15[9] * r29) + ((r15[5] * r28) + (r15[1] * r16)));
        r11[2] = (r15[14] * r30) + ((r15[10] * r29) + ((r15[6] * r28) + (r15[2] * r16)));
        r11[3] = (r30 * r15[15]) + ((r29 * r15[11]) + ((r28 * r15[7]) + (r16 * r15[3])));
    L35:
        int r17 = 0;
    L36:
        if (r17 >= 3) goto L38;
        ((double[]) r119.d)[r17] = r23[3][r17];
        r17 = r17 + 1;
        goto L36
    L38:
        int r19 = 0;
    L39:
        double[][] r20 = f11170c;
        if (r19 >= 3) goto L42;
        double[] r21 = r20[r19];
        double[] r22 = r23[r19];
        r21[0] = r22[0];
        r21[1] = r22[1];
        r21[2] = r22[2];
        r19 = r19 + 1;
        goto L39
    L42:
        double r25 = g(r20[0]);
        double[] r31 = (double[]) r119.f18350b;
        r31[0] = r25;
        double[] r32 = e(r25, r20[0]);
        r20[0] = r32;
        double r33 = b(r32, r20[1]);
        double[] r34 = (double[]) r119.f18351c;
        r34[0] = r33;
        double[] r35 = f(r20[1], -r33, r20[0]);
        r20[1] = r35;
        double r36 = g(r35);
        r31[1] = r36;
        r20[1] = e(r36, r20[1]);
        r34[0] = r34[0] / r31[1];
        double r37 = b(r20[0], r20[2]);
        r34[1] = r37;
        double[] r38 = f(r20[2], -r37, r20[0]);
        r20[2] = r38;
        double r39 = b(r20[1], r38);
        r34[2] = r39;
        double[] r40 = f(r20[2], -r39, r20[1]);
        r20[2] = r40;
        double r41 = g(r40);
        r31[2] = r41;
        double[] r42 = e(r41, r20[2]);
        r20[2] = r42;
        double r43 = r34[1];
        double r44 = r31[2];
        r34[1] = r43 / r44;
        r34[2] = r34[2] / r44;
        double[] r45 = r20[1];
        double r46 = r45[1];
        double r47 = r42[2];
        double r110 = r45[2];
        double r111 = r42[1];
        double r112 = r42[0];
        double r48 = r45[0];
        if (b(r20[0], new double[]{(r46 * r47) - (r110 * r111), (r110 * r112) - (r47 * r48), (r48 * r111) - (r46 * r112)}) >= 0.0d) goto L47;
        int r49 = 0;
    L45:
        if (r49 >= 3) goto L47;
        r31[r49] = r31[r49] * (-1.0d);
        double[] r50 = r20[r49];
        r50[0] = r50[0] * (-1.0d);
        r50[1] = r50[1] * (-1.0d);
        r50[2] = r50[2] * (-1.0d);
        r49 = r49 + 1;
    L47:
        double[] r51 = r20[2];
        double r52 = Math.round(((-Math.atan2(r51[1], r51[2])) * 57.29577951308232d) * 1000.0d) * 0.001d;
        double[] r53 = (double[]) r119.e;
        r53[0] = r52;
        double[] r54 = r20[2];
        double r55 = -r54[0];
        double r113 = r54[1];
        double r114 = r54[2];
        r53[1] = Math.round(((-Math.atan2(r55, Math.sqrt((r114 * r114) + (r113 * r113)))) * 57.29577951308232d) * 1000.0d) * 0.001d;
        r53[2] = Math.round(((-Math.atan2(r20[1][0], r20[0][0])) * 57.29577951308232d) * 1000.0d) * 0.001d;
        return;
    L33:
        double r210 = r24[0];
        double r211 = r24[1];
        double r310 = r24[2];
        double r311 = r24[3];
        double r312 = r24[4];
        double r313 = r24[5];
        double r314 = r24[6];
        double r410 = r24[7];
        double r411 = r24[8];
        double r412 = r24[9];
        double r413 = r24[10];
        double r414 = r24[11];
        double r56 = r24[12];
        double r57 = r24[13];
        double r58 = r24[14];
        double r59 = r24[15];
        double r510 = r314 * r414;
        double r62 = r410 * r413;
        double r64 = r410 * r412;
        double r60 = r313 * r414;
        double r68 = r314 * r412;
        double r70 = r313 * r413;
        double r72 = ((r70 * r59) + ((((r64 * r58) + ((r510 * r57) - (r62 * r57))) - (r60 * r58)) - (r68 * r59))) / r13;
        double r66 = r311 * r413;
        double r76 = r310 * r414;
        double r78 = r311 * r412;
        double r80 = r211 * r414;
        double r74 = r310 * r412;
        double r84 = (r74 * r59) + ((r80 * r58) + (((r66 * r57) - (r76 * r57)) - (r78 * r58)));
        double r82 = r211 * r413;
        double r85 = (r84 - (r82 * r59)) / r13;
        double r86 = r310 * r410;
        double r90 = r311 * r314;
        double r92 = r311 * r313;
        double r88 = r211 * r410;
        double r96 = r310 * r313;
        double r98 = r211 * r314;
        double r100 = ((r98 * r59) + ((((r92 * r58) + ((r86 * r57) - (r90 * r57))) - (r88 * r58)) - (r96 * r59))) / r13;
        double r94 = (((r96 * r414) + ((r88 * r413) + (((r90 * r412) - (r86 * r412)) - (r92 * r413)))) - (r98 * r414)) / r13;
        double r63 = (r62 * r56) - (r510 * r56);
        double r511 = r410 * r411;
        double r102 = r312 * r414;
        double r104 = (r102 * r58) + (r63 - (r511 * r58));
        double r65 = r314 * r411;
        double r106 = (r65 * r59) + r104;
        double r105 = r312 * r413;
        double r107 = (r106 - (r105 * r59)) / r13;
        double r77 = (r76 * r56) - (r66 * r56);
        double r67 = r311 * r411;
        double r108 = (r67 * r58) + r77;
        double r79 = r210 * r414;
        double r115 = r310 * r411;
        double r116 = r210 * r413;
        double r117 = ((r116 * r59) + ((r108 - (r79 * r58)) - (r115 * r59))) / r13;
        double r315 = r311 * r312;
        double r415 = r410 * r210;
        double r316 = r310 * r312;
        double r317 = r314 * r210;
        double r109 = (((r316 * r59) + ((r415 * r58) + (((r90 * r56) - (r86 * r56)) - (r315 * r58)))) - (r317 * r59)) / r13;
        double r87 = ((r317 * r414) + ((((r315 * r413) + ((r86 * r411) - (r90 * r411))) - (r415 * r413)) - (r316 * r414))) / r13;
        double r512 = ((r511 * r57) + ((r60 * r56) - (r64 * r56))) - (r102 * r57);
        double r61 = r313 * r411;
        double r69 = r312 * r412;
        double r91 = ((r69 * r59) + (r512 - (r61 * r59))) / r13;
        double r513 = r211 * r411;
        double r610 = (r513 * r59) + ((r79 * r57) + (((r78 * r56) - (r80 * r56)) - (r67 * r57)));
        double r710 = r210 * r412;
        double r611 = (r610 - (r710 * r59)) / r13;
        double r212 = r211 * r312;
        double r213 = r210 * r313;
        double r514 = ((r59 * r213) + ((((r315 * r57) + ((r88 * r56) - (r92 * r56))) - (r415 * r57)) - (r212 * r59))) / r13;
        double r318 = (((r212 * r414) + ((r415 * r412) + (((r92 * r411) - (r88 * r411)) - (r315 * r412)))) - (r414 * r213)) / r13;
        double r612 = (((r61 * r58) + ((r105 * r57) + (((r68 * r56) - (r70 * r56)) - (r65 * r57)))) - (r69 * r58)) / r13;
        double r711 = ((r710 * r58) + ((((r115 * r57) + ((r82 * r56) - (r74 * r56))) - (r116 * r57)) - (r513 * r58))) / r13;
        double r319 = (((r212 * r58) + ((r57 * r317) + (((r96 * r56) - (r56 * r98)) - (r316 * r57)))) - (r58 * r213)) / r13;
        double r214 = ((r213 * r413) + ((((r316 * r412) + ((r98 * r411) - (r96 * r411))) - (r317 * r412)) - (r212 * r413))) / r13;
        r14 = '\f';
        r18 = '\r';
        r24 = new double[]{r72, r85, r100, r94, r107, r117, r109, r87, r91, r611, r514, r318, r612, r711, r319, r214};
        goto L34
    L25:
        if (d(r23[1][3]) == false) goto L30;
        if (d(r23[2][3]) == false) goto L30;
        r11[2] = 0.0d;
        r11[1] = 0.0d;
        r11[0] = 0.0d;
        r11[3] = 1.0d;
        goto L35
    }

    public static boolean d(double r5) {
        if (Double.isNaN(r5) == false) goto L6;
        return false;
    L6:
        if (Math.abs(r5) >= 1.0E-5d) goto L9;
        return true;
    L9:
        return false;
    }

    public static double[] e(double r10, double[] r11) {
        if (d(r10) == false) goto L5;
        r10 = g(r11);
    L5:
        double r5 = 1.0d / r10;
        return new double[]{r11[0] * r5, r11[1] * r5, r11[2] * r5};
    }

    public static double[] f(double[] r11, double r12, double[] r14) {
        return new double[]{(r14[0] * r12) + (r11[0] * 1.0d), (r14[1] * r12) + (r11[1] * 1.0d), (r12 * r14[2]) + (r11[2] * 1.0d)};
    }

    public static double g(double[] r5) {
        double r10 = r5[0];
        double r11 = r5[1];
        double r12 = r11 * r11;
        double r13 = r12 + (r10 * r10);
        double r14 = r5[2];
        return Math.sqrt((r14 * r14) + r13);
    }
}
