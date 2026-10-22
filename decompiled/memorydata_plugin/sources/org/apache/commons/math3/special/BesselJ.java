package org.apache.commons.math3.special;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class BesselJ implements UnivariateFunction {
    private static final double[] FACT = null;
    private final double order;

    public static class BesselJResult {
        private final int nVals;
        private final double[] vals;

        public BesselJResult(double[] r2, int r3) {
            this.vals = MathArrays.copyOf(r2, r2.length);
            this.nVals = r3;
        }

        static /* synthetic */ int access$000(BesselJResult r0) {
            return r0.nVals;
        }

        static /* synthetic */ double[] access$100(BesselJResult r0) {
            return r0.vals;
        }
    }

    static {
        FACT = new double[]{1.0d, 1.0d, 2.0d, 6.0d, 24.0d, 120.0d, 720.0d, 5040.0d, 40320.0d, 362880.0d, 3628800.0d, 3.99168E7d, 4.790016E8d, 6.2270208E9d, 8.71782912E10d, 1.307674368E12d, 2.0922789888E13d, 3.55687428096E14d, 6.402373705728E15d, 1.21645100408832E17d, 2.43290200817664E18d, 5.109094217170944E19d, 1.1240007277776077E21d, 2.585201673888498E22d, 6.204484017332394E23d};
    }

    public static BesselJResult rjBesl(double r52, double r54, int r56) {
        double[] r5 = new double[r56];
        int r6 = (int) r52;
        int r7 = 0;
        double r8 = 0.0d;
        int r10 = 1;
        if (r56 > 0) goto L5;
    L182:
        int r0 = r56;
        if (r0 <= 0) goto L185;
        r5[0] = 0.0d;
    L185:
        r7 = FastMath.min(r0, 0) - 1;
    L187:
        return new BesselJResult(MathArrays.copyOf(r5, r0), r7);
    L5:
        if (r52 < 0.0d) goto L182;
        if (r52 > 10000.0d) goto L182;
        if (r54 < 0.0d) goto L182;
        if (r54 >= 1.0d) goto L182;
        int r15 = 0;
    L13:
        if (r15 >= r56) goto L15;
        r5[r15] = 0.0d;
        r15 = r15 + 1;
        goto L13
    L15:
        double r16 = 8.9E-308d;
        if (r52 >= 1.0E-4d) goto L55;
        double r20 = r54 + 1.0d;
        if (r52 <= 8.9E-308d) goto L20;
        r8 = 0.5d * r52;
    L20:
        if (r54 == 0.0d) goto L22;
        double r18 = FastMath.pow(r8, r54) / (r54 * Gamma.gamma(r54));
    L24:
        if ((r52 + 1.0d) <= 1.0d) goto L26;
        double r2 = (-r8) * r8;
    L27:
        r5[0] = r18 + ((r18 * r2) / r20);
        if (r52 == 0.0d) goto L32;
        double r22 = 0.0d;
        if (r5[0] == 0.0d) goto L34;
    L33:
        r7 = r56;
    L34:
        if (r56 != 1) goto L36;
    L53:
        r0 = r56;
        goto L187
    L36:
        if (r52 > r22) goto L40;
    L37:
        if (r10 >= r56) goto L53;
        r5[r10] = r22;
        r10 = r10 + 1;
        goto L37
    L40:
        if (r2 == r22) goto L42;
        double r17 = 8.9E-308d / r2;
    L43:
        if (r10 >= r56) goto L53;
        double r19 = r18 / r20;
        r20 = r20 + 1.0d;
        double r1 = r19 * r8;
        if (r1 > (r17 * r20)) goto L47;
        r18 = 0.0d;
    L48:
        r5[r10] = r18 + ((r18 * r2) / r20);
        if (r5[r10] != 0.0d) goto L52;
        if (r7 <= r10) goto L52;
        r7 = r10;
    L52:
        r10 = r10 + 1;
        goto L43
    L47:
        r18 = r1;
        goto L48
    L42:
        r17 = 1.78E-307d / r52;
        goto L43
    L32:
        r22 = 0.0d;
        goto L33
    L26:
        r2 = 0.0d;
        goto L27
    L22:
        r18 = 1.0d;
        goto L24
    L55:
        if (r52 > 25.0d) goto L57;
    L81:
        int r9 = r6 + 1;
        double r11 = (((double) r9) + r54) * 2.0d;
        double r12 = r11 / r52;
        if ((r56 - r6) < 3) goto L105;
        int r13 = r6 + 2;
        int r14 = r56 - 1;
        double r26 = 2.0d;
        double r110 = (((double) (r13 - 1)) + r54) * 2.0d;
        double r31 = r12;
        double r111 = 1.0d;
    L84:
        int r50 = r9;
        r9 = r13;
        int r21 = r50;
        if (r9 > r14) goto L100;
        r110 = r110 + r26;
        double r27 = ((r110 * r31) / r52) - r111;
        if (r27 > 1.0E292d) goto L88;
        r13 = r9 + 1;
        r111 = r31;
        r31 = r27;
        r26 = 2.0d;
        goto L84
    L88:
        double r35 = r27 / 1.0E308d;
        double r37 = r31 / 1.0E308d;
        int r23 = r9 + 1;
        double r24 = r35;
        double r112 = r37;
    L89:
        r9 = r9 + 1;
        r110 = r110 + 2.0d;
        double r28 = ((r110 * r24) / r52) - r112;
        if (r28 > 1.0d) goto L91;
        r112 = r24;
        r24 = r28;
        goto L89
    L91:
        double r29 = r110 / r52;
        double r113 = ((r112 * r24) * (0.5d - (0.5d / (r29 * r29)))) / 1.0E16d;
        r12 = 1.0E308d * r24;
        int r25 = r9 - 1;
        double r114 = r110 - 2.0d;
        int r30 = FastMath.min(r56, r25);
    L92:
        if (r23 > r30) goto L97;
        double r210 = ((r114 * r35) / r52) - r37;
        if ((r210 * r35) > r113) goto L97;
        r23 = r23 + 1;
        r37 = r35;
        r35 = r210;
    L97:
        r21 = r25;
        boolean r211 = true;
        r9 = r30;
        r11 = r114;
        double r115 = r113;
    L101:
        if (r211 == true) goto L103;
        double r212 = 2.0d;
        r11 = (((double) r9) + r54) * 2.0d;
        r115 = FastMath.max(r115, FastMath.sqrt(1.0E16d * r24) * FastMath.sqrt(r12 * 2.0d));
    L104:
        int r32 = r30;
    L107:
        if (r211 == true) goto L112;
    L108:
        r9 = r9 + 1;
        r11 = r11 + r212;
        double r213 = ((r11 * r12) / r52) - r24;
        if (r213 >= r115) goto L110;
        double r51 = r12;
        r12 = r213;
        r24 = r51;
        goto L108
    L110:
        r12 = r213;
    L112:
        int r33 = r9 + 1;
        double r116 = r11 + r212;
        double r117 = 1.0d / r12;
        int r34 = r33 / 2;
        int r36 = (r33 * 2) - (r34 * 4);
        int r214 = r32;
        double r38 = r34;
        double r215 = (r38 - 1.0d) + r54;
        double r39 = (r38 * 2.0d) + r54;
        if (r36 == 0) goto L115;
        double r118 = ((r215 * r117) * r39) / r38;
    L116:
        int r40 = r33 - r56;
        double r216 = r117;
        int r4 = 1;
        double r119 = 0.0d;
    L117:
        if (r4 > r40) goto L128;
        r33 = r33 - 1;
        r116 = r116 - 2.0d;
        double r310 = ((r116 * r216) / r52) - r119;
        r36 = 2 - r36;
        if (r36 == 0) goto L127;
        r38 = r38 - 1.0d;
        double r311 = (r38 * 2.0d) + r54;
        if (r33 == 1) goto L122;
        double r120 = (r38 - 1.0d) + r54;
        if (r120 != 0.0d) goto L126;
        r120 = 1.0d;
    L126:
        r118 = ((r118 + (r311 * r310)) * r120) / r38;
        goto L127
    L122:
        r119 = r216;
        r216 = r310;
    L127:
        r4 = r4 + 1;
        r119 = r216;
        r216 = r310;
    L128:
        r5[r33 - 1] = r216;
        if (r40 >= 0) goto L131;
    L146:
        boolean r41 = false;
    L147:
        boolean r121 = false;
    L148:
        if (r41 == true) goto L161;
        if (r121 == true) goto L161;
        int r122 = r33 - 2;
        if (r122 == 0) goto L161;
        int r42 = 1;
    L153:
        if (r42 > r122) goto L161;
        r33 = r33 - 1;
        r116 = r116 - 2.0d;
        int r217 = r33 - 1;
        r5[r217] = ((r5[r33] * r116) / r52) - r5[r33 + 1];
        r36 = 2 - r36;
        if (r36 == 0) goto L160;
        r38 = r38 - 1.0d;
        double r312 = (r38 * 2.0d) + r54;
        double r313 = (r38 - 1.0d) + r54;
        if (r313 != 0.0d) goto L159;
        r313 = 1.0d;
    L159:
        r118 = ((r118 + (r5[r217] * r312)) * r313) / r38;
    L160:
        r42 = r42 + 1;
    L161:
        if (r41 == true) goto L170;
        if (r121 == true) goto L164;
        double r43 = 1.0d;
        double r218 = 2.0d;
        char r44 = 0;
        r5[0] = ((((r54 + 1.0d) * 2.0d) * r5[1]) / r52) - r5[2];
    L165:
        double r45 = ((r38 - r43) * r218) + r54;
        if (r45 != 0.0d) goto L168;
        r45 = 1.0d;
    L168:
        r118 = r118 + (r5[r44] * r45);
        goto L170
    L164:
        r44 = 0;
        r43 = 1.0d;
        r218 = 2.0d;
    L170:
        if (FastMath.abs(r54) <= 1.0E-16d) goto L173;
        r118 = r118 * (Gamma.gamma(r54) * FastMath.pow(r52 * 0.5d, -r54));
    L173:
        if (r118 <= 1.0d) goto L175;
        r16 = 8.9E-308d * r118;
    L175:
        r0 = r56;
        int r46 = 0;
    L176:
        if (r46 >= r0) goto L181;
        if (FastMath.abs(r5[r46]) >= r16) goto L180;
        r5[r46] = 0.0d;
    L180:
        r5[r46] = r5[r46] / r118;
        r46 = r46 + 1;
        goto L176
    L181:
        r7 = r214;
        goto L187
    L131:
        if (r56 <= 1) goto L133;
        r33 = r33 - 1;
        r116 = r116 - 2.0d;
        int r47 = r33 - 1;
        r5[r47] = ((r216 * r116) / r52) - r119;
        if (r33 != 1) goto L140;
        r41 = false;
        r121 = true;
        goto L148
    L140:
        r36 = 2 - r36;
        if (r36 == 0) goto L146;
        r38 = r38 - 1.0d;
        double r219 = (r38 * 2.0d) + r54;
        double r123 = (r38 - 1.0d) + r54;
        if (r123 != 0.0d) goto L145;
        r123 = 1.0d;
    L145:
        r118 = ((r118 + (r5[r47] * r219)) * r123) / r38;
        goto L146
    L133:
        if ((r54 + 1.0d) != 1.0d) goto L135;
        char r48 = 0;
        double r124 = 1.0d;
    L136:
        r118 = r118 + (r5[r48] * r124);
        r41 = true;
        goto L147
    L135:
        r124 = r54;
        r48 = 0;
        goto L136
    L115:
        r118 = 0.0d;
        goto L116
    L103:
        r212 = 2.0d;
        r9 = r21;
        goto L104
    L100:
        r211 = false;
        r9 = r14;
        r24 = r111;
        r11 = r110;
        r12 = r31;
        r115 = 2.0E16d;
        r30 = r56;
        goto L101
    L105:
        r212 = 2.0d;
        r32 = r56;
        r115 = 2.0E16d;
        r24 = 1.0d;
        r211 = false;
        goto L107
    L57:
        if (r56 > (r6 + 1)) goto L81;
        double r125 = FastMath.sqrt(0.6366197723675814d / r52);
        double r220 = 0.125d / r52;
        double r221 = r220 * r220;
        if (r52 < 130.0d) goto L62;
        int r49 = 4;
    L65:
        double r126 = ((double) r49) * 4.0d;
        double r53 = (int) ((r52 / 6.283185307179586d) + 0.5d);
        double r222 = ((r52 - (6.28125d * r53)) - (r53 * 0.001935307179586477d)) - ((r54 + 0.5d) / 0.6366197723675814d);
        double r55 = FastMath.sin(r222);
        double r57 = FastMath.cos(r222);
        double r3 = r54 * 2.0d;
        double r314 = r3;
        int r127 = 1;
        int r128 = 2;
    L66:
        if (r127 > r128) goto L76;
        double r315 = r126 - 1.0d;
        double r316 = (((r315 - r314) * (r315 + r314)) * r221) * 0.5d;
        double r317 = r126 - 3.0d;
        double r318 = (r314 - r317) * (r314 + r317);
        double[] r129 = FACT;
        int r130 = r49 * 2;
        double r319 = (r316 * r318) / r129[r130];
        double r410 = r126 + 1.0d;
        double r320 = (r316 * ((r314 - r410) * (r314 + r410))) / r129[r130 + 1];
        double r411 = r126;
        int r131 = 2;
    L68:
        if (r131 > r49) goto L70;
        r411 = r411 - 4.0d;
        double r412 = r411 - 1.0d;
        double r413 = (r412 - r314) * (r412 + r314);
        double r414 = r411 - 3.0d;
        double r415 = (r314 + r414) * (r314 - r414);
        double[] r416 = FACT;
        r319 = (((r319 + (1.0d / r416[r130 - 2])) * r413) * r415) * r221;
        r320 = (((r320 + (1.0d / r416[r130 - 1])) * r413) * r318) * r221;
        r130 = r130 - 2;
        r131 = r131 + 1;
        r318 = r415;
        goto L68
    L70:
        r5[r127 - 1] = (((r319 + 1.0d) * r57) - ((((r320 + 1.0d) * ((r314 * r314) - 1.0d)) * r220) * r55)) * r125;
        if (r56 == 1) goto L73;
        r314 = r314 + 2.0d;
        r127 = r127 + 1;
        r128 = 2;
        double r58 = r55;
        r55 = -r57;
        r57 = r58;
        goto L66
    L73:
        return new BesselJResult(MathArrays.copyOf(r5, r56), r56);
    L76:
        if (r56 <= r128) goto L80;
        double r59 = r3 + 2.0d;
        int r60 = 2;
    L78:
        if (r60 >= r56) goto L80;
        r5[r60] = ((r5[r60 - 1] * r59) / r52) - r5[r60 - 2];
        r59 = r59 + 2.0d;
        r60 = r60 + 1;
    L80:
        r0 = r56;
        r7 = r0;
        goto L187
    L62:
        if (r52 < 35.0d) goto L64;
        r49 = 8;
        goto L65
    L64:
        r49 = 11;
        goto L65
    }

    public static double value(double r10, double r12) {
        int r0 = (int) r10;
        int r3 = r0 + 1;
        BesselJResult r1 = rjBesl(r12, r10 - ((double) r0), r3);
        if (BesselJResult.access$000(r1) < r3) goto L7;
        return BesselJResult.access$100(r1)[r0];
    L7:
        if (BesselJResult.access$000(r1) < 0) goto L15;
        if (FastMath.abs(BesselJResult.access$100(r1)[BesselJResult.access$000(r1) - 1]) >= 1.0E-100d) goto L13;
        return BesselJResult.access$100(r1)[r0];
    L13:
        throw new ConvergenceException(LocalizedFormats.BESSEL_FUNCTION_FAILED_CONVERGENCE, new Object[]{Double.valueOf(r10), Double.valueOf(r12)});
    L15:
        throw new MathIllegalArgumentException(LocalizedFormats.BESSEL_FUNCTION_BAD_ARGUMENT, new Object[]{Double.valueOf(r10), Double.valueOf(r12)});
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r3) {
        return value(this.order, r3);
    }
}
