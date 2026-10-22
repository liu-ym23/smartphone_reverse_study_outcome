package org.apache.commons.math3.analysis.polynomials;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialFunctionLagrangeForm implements UnivariateFunction {
    private boolean coefficientsComputed;
    private final double[] x;
    private final double[] y;

    public PolynomialFunctionLagrangeForm(double[] r5, double[] r6) {
        double[] r0 = new double[r5.length];
        this.x = r0;
        double[] r1 = new double[r6.length];
        this.y = r1;
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r6, 0, r1, 0, r6.length);
        this.coefficientsComputed = false;
        if (verifyInterpolationArray(r5, r6, false) == true) goto L6;
        MathArrays.sortInPlace(r0, new double[][]{r1});
        verifyInterpolationArray(r0, r1, true);
        return;
    }

    private static double evaluateInternal(double[] r21, double[] r22, double r23) {
        int r1 = r21.length;
        double[] r2 = new double[r1];
        double[] r3 = new double[r1];
        double r5 = Double.POSITIVE_INFINITY;
        int r7 = 0;
        int r8 = 0;
    L3:
        if (r7 >= r1) goto L8;
        r2[r7] = r22[r7];
        r3[r7] = r22[r7];
        double r9 = FastMath.abs(r23 - r21[r7]);
        if (r9 >= r5) goto L7;
        r8 = r7;
        r5 = r9;
    L7:
        r7 = r7 + 1;
        goto L3
    L8:
        double r6 = r22[r8];
        int r10 = 1;
    L9:
        if (r10 >= r1) goto L19;
        int r11 = 0;
    L11:
        int r12 = r1 - r10;
        if (r11 >= r12) goto L15;
        double r13 = r21[r11] - r23;
        int r14 = r10 + r11;
        double r15 = r21[r14] - r23;
        double r16 = r21[r11] - r21[r14];
        int r17 = r11 + 1;
        double r18 = (r2[r17] - r3[r11]) / r16;
        r2[r11] = r13 * r18;
        r3[r11] = r15 * r18;
        r11 = r17;
        goto L11
    L15:
        if (r8 >= (((double) (r12 + 1)) * 0.5d)) goto L17;
        double r19 = r2[r8];
    L18:
        r6 = r6 + r19;
        r10 = r10 + 1;
        goto L9
    L17:
        r8 = r8 - 1;
        r19 = r3[r8];
        goto L18
    L19:
        return r6;
    }

    public static boolean verifyInterpolationArray(double[] r2, double[] r3, boolean r4) {
        if (r2.length != r3.length) goto L11;
        if (r2.length < 2) goto L9;
        return MathArrays.checkOrder(r2, MathArrays.OrderDirection.INCREASING, true, r4);
    L9:
        throw new NumberIsTooSmallException(LocalizedFormats.WRONG_NUMBER_OF_POINTS, 2, Integer.valueOf(r2.length), true);
    L11:
        throw new DimensionMismatchException(r2.length, r3.length);
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r2) {
        return evaluateInternal(this.x, this.y, r2);
    }
}
