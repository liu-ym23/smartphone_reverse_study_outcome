package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class SplineInterpolator implements UnivariateInterpolator {
    public SplineInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public /* bridge */ /* synthetic */ UnivariateFunction interpolate(double[] r1, double[] r2) {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialSplineFunction interpolate(double[] r28, double[] r29) {
        if (r28.length != r29.length) goto L24;
        if (r28.length < 3) goto L22;
        int r2 = r28.length - 1;
        MathArrays.checkOrder(r28);
        double[] r5 = new double[r2];
        int r7 = 0;
    L7:
        if (r7 >= r2) goto L9;
        int r8 = r7 + 1;
        r5[r7] = r28[r8] - r28[r7];
        r7 = r8;
        goto L7
    L9:
        double[] r9 = new double[r2];
        int r10 = r2 + 1;
        double[] r11 = new double[r10];
        r9[0] = 0.0d;
        r11[0] = 0.0d;
        int r12 = 1;
    L11:
        if (r12 >= r2) goto L13;
        int r17 = r12 + 1;
        int r20 = r12 - 1;
        double r18 = ((r28[r17] - r28[r20]) * 2.0d) - (r5[r20] * r9[r20]);
        r9[r12] = r5[r12] / r18;
        r11[r12] = ((((((r29[r17] * r5[r20]) - (r29[r12] * (r28[r17] - r28[r20]))) + (r29[r20] * r5[r12])) * 3.0d) / (r5[r20] * r5[r12])) - (r5[r20] * r11[r20])) / r18;
        r12 = r17;
        goto L11
    L13:
        double[] r13 = new double[r2];
        double[] r14 = new double[r10];
        double[] r3 = new double[r2];
        r11[r2] = 0.0d;
        r14[r2] = 0.0d;
        int r15 = r2 - 1;
    L14:
        if (r15 < 0) goto L16;
        int r16 = r15 + 1;
        r14[r15] = r11[r15] - (r9[r15] * r14[r16]);
        r13[r15] = ((r29[r16] - r29[r15]) / r5[r15]) - ((r5[r15] * (r14[r16] + (r14[r15] * 2.0d))) / 3.0d);
        r3[r15] = (r14[r16] - r14[r15]) / (r5[r15] * 3.0d);
        r15 = r15 - 1;
        goto L14
    L16:
        PolynomialFunction[] r6 = new PolynomialFunction[r2];
        double[] r19 = new double[4];
        int r21 = 0;
    L17:
        if (r21 >= r2) goto L20;
        r19[0] = r29[r21];
        r19[1] = r13[r21];
        r19[2] = r14[r21];
        r19[3] = r3[r21];
        r6[r21] = new PolynomialFunction(r19);
        r21 = r21 + 1;
        goto L17
    L20:
        return new PolynomialSplineFunction(r28, r6);
    L22:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(r28.length), 3, true);
    L24:
        throw new DimensionMismatchException(r28.length, r29.length);
    }
}
