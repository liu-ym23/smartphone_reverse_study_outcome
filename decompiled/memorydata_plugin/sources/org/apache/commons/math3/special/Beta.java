package org.apache.commons.math3.special;

import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.ContinuedFraction;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Beta {
    private static final double[] DELTA = null;

    static {
        DELTA = new double[]{0.08333333333333333d, -2.777777777777778E-5d, 7.936507936507937E-8d, -5.952380952380953E-10d, 8.417508417508329E-12d, -1.917526917518546E-13d, 6.410256405103255E-15d, -2.955065141253382E-16d, 1.7964371635940225E-17d, -1.3922896466162779E-18d, 1.338028550140209E-19d, -1.542460098679661E-20d, 1.9770199298095743E-21d, -2.3406566479399704E-22d, 1.713480149663986E-23d};
    }

    private static double deltaMinusDeltaSum(double r16, double r18) {
        if (r16 < 0.0d) goto L19;
        if (r16 > r18) goto L19;
        if (r18 < 10.0d) goto L17;
        double r5 = r16 / r18;
        double r9 = r5 + 1.0d;
        double r6 = r5 / r9;
        double r10 = 1.0d / r9;
        double r11 = r10 * r10;
        int r0 = DELTA.length;
        double[] r13 = new double[r0];
        r13[0] = 1.0d;
        int r1 = 1;
    L9:
        if (r1 >= r0) goto L11;
        r13[r1] = ((r13[r1 - 1] * r11) + r10) + 1.0d;
        r1 = r1 + 1;
        goto L9
    L11:
        double r2 = 10.0d / r18;
        double r3 = r2 * r2;
        double[] r4 = DELTA;
        double r7 = r4[r4.length - 1] * r13[r0 - 1];
        int r8 = r4.length - 2;
    L12:
        if (r8 < 0) goto L15;
        r7 = (r7 * r3) + (DELTA[r8] * r13[r8]);
        r8 = r8 - 1;
        goto L12
    L15:
        return (r7 * r6) / r18;
    L17:
        throw new NumberIsTooSmallException(Double.valueOf(r18), 10, true);
    L19:
        throw new OutOfRangeException(Double.valueOf(r16), 0, Double.valueOf(r18));
    }

    public static double logBeta(double r17, double r19) {
        if (Double.isNaN(r17) == false) goto L5;
        return Double.NaN;
    L5:
        if (Double.isNaN(r19) == false) goto L7;
        return Double.NaN;
    L7:
        if (r17 > 0.0d) goto L9;
        return Double.NaN;
    L9:
        if (r19 <= 0.0d) goto L72;
        double r0 = FastMath.min(r17, r19);
        double r2 = FastMath.max(r17, r19);
        if (r0 < 10.0d) goto L20;
        double r4 = sumDeltaMinusDeltaSum(r0, r2);
        double r9 = r0 / r2;
        double r1 = (-(r0 - 0.5d)) * FastMath.log(r9 / (1.0d + r9));
        double r6 = FastMath.log1p(r9) * r2;
        double r3 = ((FastMath.log(r2) * (-0.5d)) + 0.9189385332046727d) + r4;
        if (r1 > r6) goto L18;
        return (r3 - r1) - r6;
    L18:
        return (r3 - r6) - r1;
    L20:
        if (r0 <= 2.0d) goto L43;
        if (r2 <= 1000.0d) goto L28;
        int r5 = (int) FastMath.floor(r0 - 1.0d);
        int r7 = 0;
        double r10 = 1.0d;
    L24:
        if (r7 >= r5) goto L27;
        r0 = r0 - 1.0d;
        r10 = r10 * (r0 / ((r0 / r2) + 1.0d));
        r7 = r7 + 1;
        goto L24
    L27:
        return (FastMath.log(r10) - (((double) r5) * FastMath.log(r2))) + (Gamma.logGamma(r0) + logGammaMinusLogGammaSum(r0, r2));
    L28:
        double r11 = 1.0d;
    L30:
        if (r0 <= 2.0d) goto L33;
        r0 = r0 - 1.0d;
        double r13 = r0 / r2;
        r11 = r11 * (r13 / (r13 + 1.0d));
        goto L30
    L33:
        if (r2 >= 10.0d) goto L41;
        double r8 = 1.0d;
    L36:
        if (r2 <= 2.0d) goto L39;
        r2 = r2 - 1.0d;
        r8 = r8 * (r2 / (r0 + r2));
        goto L36
    L39:
        return (FastMath.log(r11) + FastMath.log(r8)) + (Gamma.logGamma(r0) + (Gamma.logGamma(r2) - logGammaSum(r0, r2)));
    L41:
        return (FastMath.log(r11) + Gamma.logGamma(r0)) + logGammaMinusLogGammaSum(r0, r2);
    L43:
        if (r0 < 1.0d) goto L59;
        if (r2 <= 2.0d) goto L57;
        if (r2 >= 10.0d) goto L55;
        double r12 = 1.0d;
    L50:
        if (r2 <= 2.0d) goto L53;
        r2 = r2 - 1.0d;
        r12 = r12 * (r2 / (r0 + r2));
        goto L50
    L53:
        return FastMath.log(r12) + (Gamma.logGamma(r0) + (Gamma.logGamma(r2) - logGammaSum(r0, r2)));
    L55:
        return Gamma.logGamma(r0) + logGammaMinusLogGammaSum(r0, r2);
    L57:
        return (Gamma.logGamma(r0) + Gamma.logGamma(r2)) - logGammaSum(r0, r2);
    L59:
        if (r2 < 10.0d) goto L63;
        return Gamma.logGamma(r0) + logGammaMinusLogGammaSum(r0, r2);
    L63:
        return FastMath.log((Gamma.gamma(r0) * Gamma.gamma(r2)) / Gamma.gamma(r0 + r2));
    L72:
        return Double.NaN;
    }

    private static double logGammaMinusLogGammaSum(double r6, double r8) {
        if (r6 < 0.0d) goto L18;
        if (r8 < 10.0d) goto L16;
        if (r6 > r8) goto L9;
        double r0 = (r6 - 0.5d) + r8;
        double r2 = deltaMinusDeltaSum(r6, r8);
    L10:
        double r1 = r0 * FastMath.log1p(r6 / r8);
        double r7 = r6 * (FastMath.log(r8) - 1.0d);
        if (r1 > r7) goto L14;
        return (r2 - r1) - r7;
    L14:
        return (r2 - r7) - r1;
    L9:
        r0 = (r8 - 0.5d) + r6;
        r2 = deltaMinusDeltaSum(r8, r6);
        goto L10
    L16:
        throw new NumberIsTooSmallException(Double.valueOf(r8), Double.valueOf(10.0d), true);
    L18:
        throw new NumberIsTooSmallException(Double.valueOf(r6), Double.valueOf(0.0d), true);
    }

    private static double logGammaSum(double r7, double r9) {
        Double r2 = Double.valueOf(1.0d);
        Double r6 = Double.valueOf(2.0d);
        if (r7 < 1.0d) goto L23;
        if (r7 > 2.0d) goto L23;
        if (r9 < 1.0d) goto L21;
        if (r9 > 2.0d) goto L21;
        double r8 = (r7 - 1.0d) + (r9 - 1.0d);
        if (r8 > 0.5d) goto L15;
        return Gamma.logGamma1p(r8 + 1.0d);
    L15:
        if (r8 > 1.5d) goto L19;
        double r10 = Gamma.logGamma1p(r8);
        double r11 = FastMath.log1p(r8);
    L18:
        return r10 + r11;
    L19:
        r10 = Gamma.logGamma1p(r8 - 1.0d);
        r11 = FastMath.log(r8 * (1.0d + r8));
    L21:
        throw new OutOfRangeException(Double.valueOf(r9), r2, r6);
    L23:
        throw new OutOfRangeException(Double.valueOf(r7), r2, r6);
    }

    public static double regularizedBeta(double r9, double r11, double r13) {
        return regularizedBeta(r9, r11, r13, 1.0E-14d, Integer.MAX_VALUE);
    }

    public static double regularizedBeta(double r16, final double r18, final double r20, double r22, int r24) {
        if (Double.isNaN(r16) == false) goto L5;
    L23:
        return Double.NaN;
    L5:
        if (Double.isNaN(r18) == true) goto L23;
        if (Double.isNaN(r20) == true) goto L23;
        if (r16 < 0.0d) goto L23;
        if (r16 > 1.0d) goto L23;
        if (r18 <= 0.0d) goto L23;
        if (r20 <= 0.0d) goto L23;
        double r12 = (2.0d + r20) + r18;
        if (r16 <= ((r18 + 1.0d) / r12)) goto L22;
        double r8 = 1.0d - r16;
        if (r8 > ((r20 + 1.0d) / r12)) goto L22;
        return 1.0d - regularizedBeta(r8, r20, r18, r22, r24);
    L22:
        ContinuedFraction r0 = new AnonymousClass1(r20, r18);
        return (FastMath.exp((((FastMath.log(r16) * r18) + (FastMath.log1p(-r16) * r20)) - FastMath.log(r18)) - logBeta(r18, r20)) * 1.0d) / r0.evaluate(r16, r22, r24);
    }

    private static double sumDeltaMinusDeltaSum(double r8, double r10) {
        Double r2 = Double.valueOf(10.0d);
        if (r8 < 10.0d) goto L14;
        if (r10 < 10.0d) goto L12;
        double r3 = FastMath.min(r8, r10);
        double r9 = FastMath.max(r8, r10);
        double r0 = 10.0d / r3;
        double r1 = r0 * r0;
        double[] r11 = DELTA;
        double r4 = r11[r11.length - 1];
        int r12 = r11.length - 2;
    L7:
        if (r12 < 0) goto L10;
        r4 = (r4 * r1) + DELTA[r12];
        r12 = r12 - 1;
        goto L7
    L10:
        return (r4 / r3) + deltaMinusDeltaSum(r3, r9);
    L12:
        throw new NumberIsTooSmallException(Double.valueOf(r10), r2, true);
    L14:
        throw new NumberIsTooSmallException(Double.valueOf(r8), r2, true);
    }
}
