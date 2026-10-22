package org.apache.commons.math3.analysis.interpolation;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class LinearInterpolator implements UnivariateInterpolator {
    public LinearInterpolator() {
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public /* bridge */ /* synthetic */ UnivariateFunction interpolate(double[] r1, double[] r2) {
        return interpolate(r1, r2);
    }

    @Override // org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator
    public PolynomialSplineFunction interpolate(double[] r13, double[] r14) {
        if (r13.length != r14.length) goto L17;
        if (r13.length < 2) goto L15;
        int r12 = r13.length - 1;
        MathArrays.checkOrder(r13);
        double[] r2 = new double[r12];
        int r4 = 0;
    L7:
        if (r4 >= r12) goto L9;
        int r5 = r4 + 1;
        r2[r4] = (r14[r5] - r14[r4]) / (r13[r5] - r13[r4]);
        r4 = r5;
        goto L7
    L9:
        PolynomialFunction[] r6 = new PolynomialFunction[r12];
        double[] r0 = new double[2];
        int r7 = 0;
    L10:
        if (r7 >= r12) goto L13;
        r0[0] = r14[r7];
        r0[1] = r2[r7];
        r6[r7] = new PolynomialFunction(r0);
        r7 = r7 + 1;
        goto L10
    L13:
        return new PolynomialSplineFunction(r13, r6);
    L15:
        throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_OF_POINTS, Integer.valueOf(r13.length), 2, true);
    L17:
        throw new DimensionMismatchException(r13.length, r14.length);
    }
}
