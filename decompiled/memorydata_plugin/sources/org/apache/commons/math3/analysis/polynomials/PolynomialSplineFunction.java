package org.apache.commons.math3.analysis.polynomials;

import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialSplineFunction implements DifferentiableUnivariateFunction, UnivariateDifferentiableFunction {
    private final double[] knots;
    private final int n;
    private final PolynomialFunction[] polynomials;

    public PolynomialSplineFunction(double[] r5, PolynomialFunction[] r6) {
        if (r5 == null) goto L16;
        if (r6 == null) goto L16;
        if (r5.length < 2) goto L14;
        if ((r5.length - 1) != r6.length) goto L12;
        MathArrays.checkOrder(r5);
        int r0 = r5.length - 1;
        this.n = r0;
        double[] r1 = new double[r0 + 1];
        this.knots = r1;
        System.arraycopy(r5, 0, r1, 0, r0 + 1);
        PolynomialFunction[] r7 = new PolynomialFunction[r0];
        this.polynomials = r7;
        System.arraycopy(r6, 0, r7, 0, r0);
        return;
    L12:
        throw new DimensionMismatchException(r6.length, r5.length);
    L14:
        throw new NumberIsTooSmallException(LocalizedFormats.NOT_ENOUGH_POINTS_IN_SPLINE_PARTITION, 2, Integer.valueOf(r5.length), false);
    L16:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r5) {
        double[] r0 = this.knots;
        if (r5 < r0[0]) goto L15;
        if (r5 > r0[this.n]) goto L15;
        int r1 = Arrays.binarySearch(r0, r5);
        if (r1 >= 0) goto L9;
        r1 = (-r1) - 2;
    L9:
        PolynomialFunction[] r2 = this.polynomials;
        if (r1 < r2.length) goto L13;
        r1 = r1 - 1;
    L13:
        return r2[r1].value(r5 - this.knots[r1]);
    L15:
        throw new OutOfRangeException(Double.valueOf(r5), Double.valueOf(this.knots[0]), Double.valueOf(this.knots[this.n]));
    }
}
