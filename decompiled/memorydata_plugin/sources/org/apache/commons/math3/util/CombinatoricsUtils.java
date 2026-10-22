package org.apache.commons.math3.util;

import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public final class CombinatoricsUtils {
    static final long[] FACTORIALS = null;
    static final AtomicReference<long[][]> STIRLING_S2 = null;

    static {
        FACTORIALS = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
        STIRLING_S2 = new AtomicReference(null);
    }

    public static long binomialCoefficient(int r8, int r9) {
        checkBinomial(r8, r9);
        long r0 = 1;
        if (r8 == r9) goto L31;
        if (r9 == 0) goto L31;
        if (r9 == 1) goto L30;
        if (r9 == (r8 - 1)) goto L30;
        if (r9 <= (r8 / 2)) goto L16;
        return binomialCoefficient(r8, r8 - r9);
    L16:
        if (r8 > 61) goto L21;
        int r10 = (r8 - r9) + 1;
        int r3 = 1;
    L18:
        if (r3 > r9) goto L28;
        r0 = (r0 * ((long) r10)) / ((long) r3);
        r10 = r10 + 1;
        r3 = r3 + 1;
    L28:
        return r0;
    L21:
        if (r8 > 66) goto L25;
        int r11 = (r8 - r9) + 1;
        int r4 = 1;
    L23:
        if (r4 > r9) goto L28;
        long r5 = ArithmeticUtils.gcd(r11, r4);
        r0 = (r0 / (((long) r4) / r5)) * (((long) r11) / r5);
        r11 = r11 + 1;
        r4 = r4 + 1;
        goto L23
    L25:
        int r12 = (r8 - r9) + 1;
        int r6 = 1;
    L26:
        if (r6 > r9) goto L28;
        long r7 = ArithmeticUtils.gcd(r12, r6);
        r0 = ArithmeticUtils.mulAndCheck(r0 / (((long) r6) / r7), ((long) r12) / r7);
        r12 = r12 + 1;
        r6 = r6 + 1;
    L30:
        return r8;
    L31:
        return 1;
    }

    public static double binomialCoefficientDouble(int r7, int r8) {
        checkBinomial(r7, r8);
        double r0 = 1.0d;
        if (r7 == r8) goto L25;
        if (r8 == 0) goto L25;
        int r2 = 1;
        if (r8 == 1) goto L24;
        if (r8 == (r7 - 1)) goto L24;
        if (r8 <= (r7 / 2)) goto L16;
        return binomialCoefficientDouble(r7, r7 - r8);
    L16:
        if (r7 < 67) goto L18;
    L19:
        if (r2 > r8) goto L22;
        r0 = r0 * (((double) ((r7 - r8) + r2)) / ((double) r2));
        r2 = r2 + 1;
        goto L19
    L22:
        return FastMath.floor(r0 + 0.5d);
    L18:
        return binomialCoefficient(r7, r8);
    L24:
        return r7;
    L25:
        return 1.0d;
    }

    public static double binomialCoefficientLog(int r6, int r7) {
        checkBinomial(r6, r7);
        double r0 = 0.0d;
        if (r6 == r7) goto L32;
        if (r7 == 0) goto L32;
        if (r7 == 1) goto L31;
        if (r7 == (r6 - 1)) goto L31;
        if (r6 >= 67) goto L16;
        return FastMath.log(binomialCoefficient(r6, r7));
    L16:
        if (r6 >= 1030) goto L20;
        return FastMath.log(binomialCoefficientDouble(r6, r7));
    L20:
        if (r7 > (r6 / 2)) goto L22;
        int r3 = (r6 - r7) + 1;
    L24:
        if (r3 > r6) goto L26;
        r0 = r0 + FastMath.log(r3);
        r3 = r3 + 1;
        goto L24
    L26:
        int r8 = 2;
    L27:
        if (r8 > r7) goto L29;
        r0 = r0 - FastMath.log(r8);
        r8 = r8 + 1;
        goto L27
    L29:
        return r0;
    L22:
        return binomialCoefficientLog(r6, r6 - r7);
    L31:
        return FastMath.log(r6);
    L32:
        return 0.0d;
    }

    public static void checkBinomial(int r3, int r4) {
        if (r3 < r4) goto L8;
        if (r3 < 0) goto L6;
        return;
    L6:
        throw new NotPositiveException(LocalizedFormats.BINOMIAL_NEGATIVE_PARAMETER, Integer.valueOf(r3));
    L8:
        throw new NumberIsTooLargeException(LocalizedFormats.BINOMIAL_INVALID_PARAMETERS_ORDER, Integer.valueOf(r4), Integer.valueOf(r3), true);
    }

    public static long factorial(int r2) {
        if (r2 < 0) goto L10;
        if (r2 > 20) goto L8;
        return FACTORIALS[r2];
    L8:
        throw new MathArithmeticException();
    L10:
        throw new NotPositiveException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, Integer.valueOf(r2));
    }

    public static double factorialLog(int r5) {
        if (r5 < 0) goto L12;
        if (r5 < 21) goto L6;
        double r0 = 0.0d;
        int r2 = 2;
    L8:
        if (r2 > r5) goto L10;
        r0 = r0 + FastMath.log(r2);
        r2 = r2 + 1;
        goto L8
    L10:
        return r0;
    L6:
        return FastMath.log(FACTORIALS[r5]);
    L12:
        throw new NotPositiveException(LocalizedFormats.FACTORIAL_NEGATIVE_PARAMETER, Integer.valueOf(r5));
    }
}
