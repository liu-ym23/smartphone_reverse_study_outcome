package org.apache.commons.math3.analysis.polynomials;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class PolynomialFunction implements Serializable, DifferentiableUnivariateFunction, UnivariateDifferentiableFunction {
    private static final long serialVersionUID = -7726511984200295583L;
    private final double[] coefficients;

    public PolynomialFunction(double[] r6) {
        MathUtils.checkNotNull(r6);
        int r0 = r6.length;
        if (r0 == 0) goto L12;
    L5:
        if (r0 <= 1) goto L9;
        if (r6[r0 - 1] != 0.0d) goto L9;
        r0 = r0 - 1;
    L9:
        double[] r1 = new double[r0];
        this.coefficients = r1;
        System.arraycopy(r6, 0, r1, 0, r0);
        return;
    L12:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }

    public static double[] differentiate(double[] r7) {
        MathUtils.checkNotNull(r7);
        int r0 = r7.length;
        if (r0 == 0) goto L13;
        if (r0 == 1) goto L7;
        int r1 = r0 - 1;
        double[] r2 = new double[r1];
    L9:
        if (r1 <= 0) goto L11;
        r2[r1 - 1] = ((double) r1) * r7[r1];
        r1 = r1 - 1;
        goto L9
    L11:
        return r2;
    L7:
        return new double[]{0.0d};
    L13:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }

    public static double evaluate(double[] r5, double r6) {
        MathUtils.checkNotNull(r5);
        int r0 = r5.length;
        if (r0 == 0) goto L9;
        double r1 = r5[r0 - 1];
        int r2 = r0 - 2;
    L5:
        if (r2 < 0) goto L7;
        r1 = (r1 * r6) + r5[r2];
        r2 = r2 - 1;
        goto L5
    L7:
        return r1;
    L9:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }

    private static String toString(double r1) {
        String r2 = Double.toString(r1);
        if (r2.endsWith(".0") == true) goto L5;
        return r2;
    L5:
        return r2.substring(0, r2.length() - 2);
    }

    public PolynomialFunction add(PolynomialFunction r9) {
        int r0 = FastMath.min(this.coefficients.length, r9.coefficients.length);
        int r1 = FastMath.max(this.coefficients.length, r9.coefficients.length);
        double[] r2 = new double[r1];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r2[r3] = this.coefficients[r3] + r9.coefficients[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        double[] r8 = this.coefficients;
        int r4 = r8.length;
        double[] r10 = r9.coefficients;
        if (r4 >= r10.length) goto L8;
        r8 = r10;
    L8:
        System.arraycopy(r8, r0, r2, r0, r1 - r0);
        return new PolynomialFunction(r2);
    }

    public int degree() {
        return this.coefficients.length - 1;
    }

    public UnivariateFunction derivative() {
        return polynomialDerivative();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PolynomialFunction.class) == true) goto L8;
        return false;
    L8:
        PolynomialFunction r6 = (PolynomialFunction) ZeusTransformUtils.preCheckCast(r5, PolynomialFunction.class, "com.obric.memorydata.plugin");
        if (Arrays.equals(this.coefficients, r6.coefficients) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public double[] getCoefficients() {
        return (double[]) ZeusTransformUtils.preCheckCast(this.coefficients.clone(), double[].class, "com.obric.memorydata.plugin");
    }

    public int hashCode() {
        return 31 + Arrays.hashCode(this.coefficients);
    }

    public PolynomialFunction multiply(PolynomialFunction r13) {
        int r0 = (this.coefficients.length + r13.coefficients.length) - 1;
        double[] r1 = new double[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L10;
        r1[r3] = 0.0d;
        int r4 = r3 + 1;
        int r5 = FastMath.max(0, r4 - r13.coefficients.length);
    L6:
        if (r5 >= FastMath.min(this.coefficients.length, r4)) goto L8;
        r1[r3] = r1[r3] + (this.coefficients[r5] * r13.coefficients[r3 - r5]);
        r5 = r5 + 1;
        goto L6
    L8:
        r3 = r4;
        goto L3
    L10:
        return new PolynomialFunction(r1);
    }

    public PolynomialFunction negate() {
        double[] r0 = new double[this.coefficients.length];
        int r1 = 0;
    L3:
        double[] r2 = this.coefficients;
        if (r1 >= r2.length) goto L7;
        r0[r1] = -r2[r1];
        r1 = r1 + 1;
        goto L3
    L7:
        return new PolynomialFunction(r0);
    }

    public PolynomialFunction polynomialDerivative() {
        return new PolynomialFunction(differentiate(this.coefficients));
    }

    public PolynomialFunction subtract(PolynomialFunction r9) {
        int r0 = FastMath.min(this.coefficients.length, r9.coefficients.length);
        int r1 = FastMath.max(this.coefficients.length, r9.coefficients.length);
        double[] r2 = new double[r1];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r2[r3] = this.coefficients[r3] - r9.coefficients[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        double[] r8 = this.coefficients;
        if (r8.length >= r9.coefficients.length) goto L9;
    L7:
        if (r0 >= r1) goto L11;
        r2[r0] = -r9.coefficients[r0];
        r0 = r0 + 1;
    L11:
        return new PolynomialFunction(r2);
    L9:
        System.arraycopy(r8, r0, r2, r0, r1 - r0);
        goto L11
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        double[] r1 = this.coefficients;
        if (r1[0] == 0.0d) goto L5;
        r0.append(toString(r1[0]));
    L9:
        int r2 = 1;
    L10:
        double[] r3 = this.coefficients;
        if (r2 >= r3.length) goto L32;
        if (r3[r2] == 0.0d) goto L30;
        if (r0.length() <= 0) goto L21;
        if (this.coefficients[r2] >= 0.0d) goto L19;
        String r4 = " - ";
    L23:
        r0.append(r4);
    L24:
        double r5 = FastMath.abs(this.coefficients[r2]);
        if ((r5 - 1.0d) == 0.0d) goto L27;
        r0.append(toString(r5));
        r0.append(' ');
    L27:
        r0.append("x");
        if (r2 <= 1) goto L30;
        r0.append('^');
        r0.append(Integer.toString(r2));
        goto L30
    L19:
        r4 = " + ";
        goto L23
    L21:
        if (this.coefficients[r2] >= 0.0d) goto L24;
        r4 = "-";
    L30:
        r2 = r2 + 1;
        goto L10
    L32:
        return r0.toString();
    L5:
        if (r1.length != 1) goto L9;
        return "0";
    }

    @Override // org.apache.commons.math3.analysis.UnivariateFunction
    public double value(double r1) {
        return evaluate(this.coefficients, r1);
    }

    public DerivativeStructure value(DerivativeStructure r7) {
        MathUtils.checkNotNull(this.coefficients);
        int r0 = this.coefficients.length;
        if (r0 == 0) goto L9;
        DerivativeStructure r1 = new DerivativeStructure(r7.getFreeParameters(), r7.getOrder(), this.coefficients[r0 - 1]);
        int r2 = r0 - 2;
    L5:
        if (r2 < 0) goto L7;
        r1 = r1.multiply(r7).add2(this.coefficients[r2]);
        r2 = r2 - 1;
        goto L5
    L7:
        return r1;
    L9:
        throw new NoDataException(LocalizedFormats.EMPTY_POLYNOMIALS_COEFFICIENTS_ARRAY);
    }
}
