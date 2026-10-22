package org.apache.commons.math3.complex;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class Complex implements Serializable, FieldElement<Complex> {
    public static final Complex I = null;
    public static final Complex INF = null;
    public static final Complex NaN = null;
    public static final Complex ONE = null;
    public static final Complex ZERO = null;
    private static final long serialVersionUID = -6195664516687396620L;
    private final double imaginary;
    private final transient boolean isInfinite;
    private final transient boolean isNaN;
    private final double real;

    static {
        I = new Complex(0.0d, 1.0d);
        NaN = new Complex(Double.NaN, Double.NaN);
        INF = new Complex(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        ONE = new Complex(1.0d, 0.0d);
        ZERO = new Complex(0.0d, 0.0d);
    }

    public Complex(double r3) {
        this(r3, 0.0d);
    }

    public Complex(double r4, double r6) {
        this.real = r4;
        this.imaginary = r6;
        boolean r1 = false;
        if (Double.isNaN(r4) == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        this.isNaN = r0;
        if (r0 == false) goto L12;
    L16:
        this.isInfinite = r1;
        return;
    L12:
        if (Double.isInfinite(r4) == false) goto L14;
    L15:
        r1 = true;
        goto L16
    L14:
        if (Double.isInfinite(r6) == false) goto L16;
    L5:
        if (Double.isNaN(r6) == true) goto L8;
        r0 = false;
        goto L9
    }

    public static boolean equals(Complex r1, Complex r2) {
        return equals(r1, r2, 1);
    }

    public static boolean equals(Complex r7, Complex r8, double r9) {
        if (Precision.equals(r7.real, r8.real, r9) == true) goto L5;
    L7:
        return false;
    L5:
        if (Precision.equals(r7.imaginary, r8.imaginary, r9) == false) goto L7;
        return true;
    }

    public static boolean equals(Complex r4, Complex r5, int r6) {
        if (Precision.equals(r4.real, r5.real, r6) == true) goto L5;
    L7:
        return false;
    L5:
        if (Precision.equals(r4.imaginary, r5.imaginary, r6) == false) goto L7;
        return true;
    }

    public static boolean equalsWithRelativeTolerance(Complex r7, Complex r8, double r9) {
        if (Precision.equalsWithRelativeTolerance(r7.real, r8.real, r9) == true) goto L5;
    L7:
        return false;
    L5:
        if (Precision.equalsWithRelativeTolerance(r7.imaginary, r8.imaginary, r9) == false) goto L7;
        return true;
    }

    public static Complex valueOf(double r1) {
        if (Double.isNaN(r1) == false) goto L7;
        return NaN;
    L7:
        return new Complex(r1);
    }

    public static Complex valueOf(double r1, double r3) {
        if (Double.isNaN(r1) == true) goto L10;
        if (Double.isNaN(r3) == true) goto L10;
        return new Complex(r1, r3);
    L10:
        return NaN;
    }

    public double abs() {
        if (this.isNaN == false) goto L7;
        return Double.NaN;
    L7:
        if (isInfinite() == false) goto L11;
        return Double.POSITIVE_INFINITY;
    L11:
        if (FastMath.abs(this.real) >= FastMath.abs(this.imaginary)) goto L20;
        double r5 = this.imaginary;
        if (r5 != 0.0d) goto L17;
        double r0 = this.real;
    L16:
        return FastMath.abs(r0);
    L17:
        double r3 = this.real;
    L18:
        double r4 = r3 / r5;
        return FastMath.abs(r5) * FastMath.sqrt((r4 * r4) + 1.0d);
    L20:
        r5 = this.real;
        if (r5 != 0.0d) goto L23;
        r0 = this.imaginary;
        goto L16
    L23:
        r3 = this.imaginary;
        goto L18
    }

    public Complex acos() {
        if (this.isNaN == true) goto L5;
        Complex r0 = sqrt1z();
        Complex r1 = I;
        return add2(r0.multiply2(r1)).log().multiply2(r1.negate2());
    L5:
        return NaN;
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Complex add(Complex r3) {
        return add2((Complex) ZeusTransformUtils.preCheckCast(r3, Complex.class, "com.obric.memorydata.plugin"));
    }

    public Complex add(double r3) {
        if (this.isNaN == true) goto L10;
        if (Double.isNaN(r3) == true) goto L10;
        return createComplex(this.real + r3, this.imaginary);
    L10:
        return NaN;
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public Complex add2(Complex r7) {
        MathUtils.checkNotNull(r7);
        if (this.isNaN == true) goto L10;
        if (r7.isNaN == true) goto L10;
        return createComplex(this.real + r7.getReal(), this.imaginary + r7.getImaginary());
    L10:
        return NaN;
    }

    public Complex asin() {
        if (this.isNaN == true) goto L5;
        Complex r0 = sqrt1z();
        Complex r1 = I;
        return r0.add2(multiply2(r1)).log().multiply2(r1.negate2());
    L5:
        return NaN;
    }

    public Complex atan() {
        if (this.isNaN == true) goto L5;
        Complex r0 = I;
        return add2(r0).divide2(r0.subtract2(this)).log().multiply2(r0.divide2(createComplex(2.0d, 0.0d)));
    L5:
        return NaN;
    }

    public Complex conjugate() {
        if (this.isNaN == false) goto L7;
        return NaN;
    L7:
        return createComplex(this.real, -this.imaginary);
    }

    public Complex cos() {
        if (this.isNaN == false) goto L7;
        return NaN;
    L7:
        return createComplex(FastMath.cos(this.real) * FastMath.cosh(this.imaginary), (-FastMath.sin(this.real)) * FastMath.sinh(this.imaginary));
    }

    public Complex cosh() {
        if (this.isNaN == false) goto L7;
        return NaN;
    L7:
        return createComplex(FastMath.cosh(this.real) * FastMath.cos(this.imaginary), FastMath.sinh(this.real) * FastMath.sin(this.imaginary));
    }

    public Complex createComplex(double r1, double r3) {
        return new Complex(r1, r3);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Complex divide(Complex r3) {
        return divide2((Complex) ZeusTransformUtils.preCheckCast(r3, Complex.class, "com.obric.memorydata.plugin"));
    }

    public Complex divide(double r5) {
        if (this.isNaN == true) goto L21;
        if (Double.isNaN(r5) == true) goto L21;
        if (r5 != 0.0d) goto L12;
        return NaN;
    L12:
        if (Double.isInfinite(r5) == false) goto L19;
        if (isInfinite() == true) goto L17;
        return ZERO;
    L17:
        return NaN;
    L19:
        return createComplex(this.real / r5, this.imaginary / r5);
    L21:
        return NaN;
    }

    /* JADX INFO: renamed from: divide, reason: avoid collision after fix types in other method */
    public Complex divide2(Complex r11) {
        MathUtils.checkNotNull(r11);
        if (this.isNaN == true) goto L26;
        if (r11.isNaN == true) goto L26;
        double r0 = r11.getReal();
        double r2 = r11.getImaginary();
        if (r0 != 0.0d) goto L14;
        if (r2 != 0.0d) goto L14;
        return NaN;
    L14:
        if (r11.isInfinite() == false) goto L20;
        if (isInfinite() == true) goto L20;
        return ZERO;
    L20:
        if (FastMath.abs(r0) >= FastMath.abs(r2)) goto L23;
        double r4 = r0 / r2;
        double r1 = (r0 * r4) + r2;
        double r3 = this.real;
        double r8 = this.imaginary;
        return createComplex(((r3 * r4) + r8) / r1, ((r8 * r4) - r3) / r1);
    L23:
        double r5 = r2 / r0;
        double r6 = (r2 * r5) + r0;
        double r7 = this.imaginary;
        double r9 = this.real;
        return createComplex(((r7 * r5) + r9) / r6, (r7 - (r9 * r5)) / r6);
    L26:
        return NaN;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Complex.class) == false) goto L18;
        Complex r10 = (Complex) ZeusTransformUtils.preCheckCast(r9, Complex.class, "com.obric.memorydata.plugin");
        if (r10.isNaN == false) goto L12;
        return this.isNaN;
    L12:
        if (MathUtils.equals(this.real, r10.real) == false) goto L17;
        if (MathUtils.equals(this.imaginary, r10.imaginary) == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public Complex exp() {
        if (this.isNaN == true) goto L5;
        double r0 = FastMath.exp(this.real);
        return createComplex(FastMath.cos(this.imaginary) * r0, r0 * FastMath.sin(this.imaginary));
    L5:
        return NaN;
    }

    public double getArgument() {
        return FastMath.atan2(getImaginary(), getReal());
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Field<Complex> getField() {
        return getField2();
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: getField, reason: avoid collision after fix types in other method */
    public Field<Complex> getField2() {
        return ComplexField.getInstance();
    }

    public double getImaginary() {
        return this.imaginary;
    }

    public double getReal() {
        return this.real;
    }

    public int hashCode() {
        if (this.isNaN == false) goto L7;
        return 7;
    L7:
        return ((MathUtils.hash(this.imaginary) * 17) + MathUtils.hash(this.real)) * 37;
    }

    public boolean isInfinite() {
        return this.isInfinite;
    }

    public boolean isNaN() {
        return this.isNaN;
    }

    public Complex log() {
        if (this.isNaN == false) goto L7;
        return NaN;
    L7:
        return createComplex(FastMath.log(abs()), FastMath.atan2(this.imaginary, this.real));
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Complex multiply(int r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Complex multiply(Complex r3) {
        return multiply2((Complex) ZeusTransformUtils.preCheckCast(r3, Complex.class, "com.obric.memorydata.plugin"));
    }

    public Complex multiply(double r5) {
        if (this.isNaN == true) goto L19;
        if (Double.isNaN(r5) == true) goto L19;
        if (Double.isInfinite(this.real) == true) goto L17;
        if (Double.isInfinite(this.imaginary) == true) goto L17;
        if (Double.isInfinite(r5) == true) goto L17;
        return createComplex(this.real * r5, this.imaginary * r5);
    L17:
        return INF;
    L19:
        return NaN;
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Complex multiply2(int r7) {
        if (this.isNaN == false) goto L7;
        return NaN;
    L7:
        if (Double.isInfinite(this.real) == true) goto L14;
        if (Double.isInfinite(this.imaginary) == true) goto L14;
        double r2 = r7;
        return createComplex(this.real * r2, this.imaginary * r2);
    L14:
        return INF;
    }

    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Complex multiply2(Complex r13) {
        MathUtils.checkNotNull(r13);
        if (this.isNaN == true) goto L21;
        if (r13.isNaN == true) goto L21;
        if (Double.isInfinite(this.real) == true) goto L19;
        if (Double.isInfinite(this.imaginary) == true) goto L19;
        if (Double.isInfinite(r13.real) == true) goto L19;
        if (Double.isInfinite(r13.imaginary) == true) goto L19;
        double r0 = this.real;
        double r2 = r13.real;
        double r6 = this.imaginary;
        double r8 = r13.imaginary;
        return createComplex((r0 * r2) - (r6 * r8), (r0 * r8) + (r6 * r2));
    L19:
        return INF;
    L21:
        return NaN;
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Complex negate() {
        return negate2();
    }

    @Override // org.apache.commons.math3.FieldElement
    /* JADX INFO: renamed from: negate, reason: avoid collision after fix types in other method */
    public Complex negate2() {
        if (this.isNaN == false) goto L7;
        return NaN;
    L7:
        return createComplex(-this.real, -this.imaginary);
    }

    public List<Complex> nthRoot(int r14) {
        if (r14 <= 0) goto L16;
        ArrayList r0 = new ArrayList();
        if (this.isNaN == false) goto L9;
        Complex r13 = NaN;
    L6:
        r0.add(r13);
        return r0;
    L9:
        if (isInfinite() == false) goto L11;
        r13 = INF;
        goto L6
    L11:
        double r5 = r14;
        double r1 = FastMath.pow(abs(), 1.0d / r5);
        double r3 = getArgument() / r5;
        double r7 = 6.283185307179586d / r5;
        int r6 = 0;
    L12:
        if (r6 >= r14) goto L14;
        r0.add(createComplex(FastMath.cos(r3) * r1, FastMath.sin(r3) * r1));
        r3 = r3 + r7;
        r6 = r6 + 1;
        goto L12
    L14:
        return r0;
    L16:
        throw new NotPositiveException(LocalizedFormats.CANNOT_COMPUTE_NTH_ROOT_FOR_NEGATIVE_N, Integer.valueOf(r14));
    }

    public Complex pow(double r1) {
        return log().multiply(r1).exp();
    }

    public Complex pow(Complex r1) {
        MathUtils.checkNotNull(r1);
        return log().multiply2(r1).exp();
    }

    public final Object readResolve() {
        return createComplex(this.real, this.imaginary);
    }

    public /* bridge */ /* synthetic */ Object reciprocal() {
        return m3121reciprocal();
    }

    /* JADX INFO: renamed from: reciprocal, reason: collision with other method in class */
    public Complex m3121reciprocal() {
        if (this.isNaN == true) goto L5;
        double r0 = this.real;
        if (r0 != 0.0d) goto L13;
        if (this.imaginary != 0.0d) goto L13;
        return INF;
    L13:
        if (this.isInfinite == false) goto L17;
        return ZERO;
    L17:
        if (FastMath.abs(r0) >= FastMath.abs(this.imaginary)) goto L20;
        double r3 = this.real;
        double r5 = this.imaginary;
        double r7 = r3 / r5;
        double r1 = 1.0d / ((r3 * r7) + r5);
        return createComplex(r7 * r1, -r1);
    L20:
        double r4 = this.imaginary;
        double r6 = this.real;
        double r8 = r4 / r6;
        double r2 = 1.0d / ((r4 * r8) + r6);
        return createComplex(r2, (-r2) * r8);
    L5:
        return NaN;
    }

    public Complex sin() {
        if (this.isNaN == false) goto L7;
        return NaN;
    L7:
        return createComplex(FastMath.sin(this.real) * FastMath.cosh(this.imaginary), FastMath.cos(this.real) * FastMath.sinh(this.imaginary));
    }

    public Complex sinh() {
        if (this.isNaN == false) goto L7;
        return NaN;
    L7:
        return createComplex(FastMath.sinh(this.real) * FastMath.cos(this.imaginary), FastMath.cosh(this.real) * FastMath.sin(this.imaginary));
    }

    public Complex sqrt() {
        if (this.isNaN == true) goto L5;
        double r0 = this.real;
        if (r0 == 0.0d) goto L9;
    L12:
        double r1 = FastMath.sqrt((FastMath.abs(r0) + abs()) / 2.0d);
        if (this.real < 0.0d) goto L17;
        return createComplex(r1, this.imaginary / (2.0d * r1));
    L17:
        return createComplex(FastMath.abs(this.imaginary) / (2.0d * r1), FastMath.copySign(1.0d, this.imaginary) * r1);
    L9:
        if (this.imaginary != 0.0d) goto L12;
        return createComplex(0.0d, 0.0d);
    L5:
        return NaN;
    }

    public Complex sqrt1z() {
        return createComplex(1.0d, 0.0d).subtract2(multiply2(this)).sqrt();
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Complex subtract(Complex r3) {
        return subtract2((Complex) ZeusTransformUtils.preCheckCast(r3, Complex.class, "com.obric.memorydata.plugin"));
    }

    public Complex subtract(double r3) {
        if (this.isNaN == true) goto L10;
        if (Double.isNaN(r3) == true) goto L10;
        return createComplex(this.real - r3, this.imaginary);
    L10:
        return NaN;
    }

    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public Complex subtract2(Complex r7) {
        MathUtils.checkNotNull(r7);
        if (this.isNaN == true) goto L10;
        if (r7.isNaN == true) goto L10;
        return createComplex(this.real - r7.getReal(), this.imaginary - r7.getImaginary());
    L10:
        return NaN;
    }

    public Complex tan() {
        if (this.isNaN == true) goto L18;
        if (Double.isInfinite(this.real) == true) goto L18;
        double r0 = this.imaginary;
        if (r0 <= 20.0d) goto L12;
        return createComplex(0.0d, 1.0d);
    L12:
        if (r0 < (-20.0d)) goto L14;
        double r2 = this.real * 2.0d;
        double r1 = r0 * 2.0d;
        double r4 = FastMath.cos(r2) + FastMath.cosh(r1);
        return createComplex(FastMath.sin(r2) / r4, FastMath.sinh(r1) / r4);
    L14:
        return createComplex(0.0d, -1.0d);
    L18:
        return NaN;
    }

    public Complex tanh() {
        if (this.isNaN == true) goto L18;
        if (Double.isInfinite(this.imaginary) == true) goto L18;
        double r0 = this.real;
        if (r0 <= 20.0d) goto L12;
        return createComplex(1.0d, 0.0d);
    L12:
        if (r0 < (-20.0d)) goto L14;
        double r1 = r0 * 2.0d;
        double r4 = this.imaginary * 2.0d;
        double r2 = FastMath.cosh(r1) + FastMath.cos(r4);
        return createComplex(FastMath.sinh(r1) / r2, FastMath.sin(r4) / r2);
    L14:
        return createComplex(-1.0d, 0.0d);
    L18:
        return NaN;
    }

    public String toString() {
        return "(" + this.real + ", " + this.imaginary + ")";
    }
}
