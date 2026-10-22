package org.apache.commons.math3.analysis.polynomials;

import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialFunctionNewtonForm implements UnivariateDifferentiableFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final double[] f17875a;
    private final double[] c;
    private boolean coefficientsComputed;

    public PolynomialFunctionNewtonForm(double[] r5, double[] r6) {
        verifyInputArray(r5, r6);
        double[] r0 = new double[r5.length];
        this.f17875a = r0;
        double[] r1 = new double[r6.length];
        this.c = r1;
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r6, 0, r1, 0, r6.length);
        this.coefficientsComputed = false;
    }

    public static double evaluate(double[] r7, double[] r8, double r9) {
        verifyInputArray(r7, r8);
        int r0 = r8.length;
        double r1 = r7[r0];
        int r2 = r0 - 1;
    L3:
        if (r2 < 0) goto L5;
        r1 = r7[r2] + ((r9 - r8[r2]) * r1);
        r2 = r2 - 1;
        goto L3
    L5:
        return r1;
    }

    public static void verifyInputArray(double[] r2, double[] r3) {
        MathUtils.checkNotNull(r2);
        MathUtils.checkNotNull(r3);
        if (r2.length == 0) goto L12;
        if (r3.length == 0) goto L12;
        if (r2.length != (r3.length + 1)) goto L10;
        return;
    L10:
        throw new DimensionMismatchException(LocalizedFormats.ARRAY_SIZES_SHOULD_HAVE_DIFFERENCE_1, r2.length, r3.length);
    L12:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r2) {
        return evaluate(this.f17875a, this.c, r2);
    }
}
