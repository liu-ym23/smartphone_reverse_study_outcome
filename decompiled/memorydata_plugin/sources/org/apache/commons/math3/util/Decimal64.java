package org.apache.commons.math3.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;

/* JADX INFO: loaded from: classes6.dex */
public class Decimal64 extends Number implements Comparable<Decimal64>, RealFieldElement<Decimal64> {
    public static final Decimal64 NAN = null;
    public static final Decimal64 NEGATIVE_INFINITY = null;
    public static final Decimal64 ONE = null;
    public static final Decimal64 POSITIVE_INFINITY = null;
    public static final Decimal64 ZERO = null;
    private static final long serialVersionUID = 20120227;
    private final double value;

    static {
        ZERO = new Decimal64(0.0d);
        ONE = new Decimal64(1.0d);
        NEGATIVE_INFINITY = new Decimal64(Double.NEGATIVE_INFINITY);
        POSITIVE_INFINITY = new Decimal64(Double.POSITIVE_INFINITY);
        NAN = new Decimal64(Double.NaN);
    }

    public Decimal64(double r1) {
        this.value = r1;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 abs() {
        return abs2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: abs, reason: avoid collision after fix types in other method */
    public Decimal64 abs2() {
        return new Decimal64(FastMath.abs(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 acos() {
        return acos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acos, reason: avoid collision after fix types in other method */
    public Decimal64 acos2() {
        return new Decimal64(FastMath.acos(this.value));
    }

    public /* bridge */ /* synthetic */ Object acosh() {
        return m3127acosh();
    }

    /* JADX INFO: renamed from: acosh, reason: collision with other method in class */
    public Decimal64 m3127acosh() {
        return new Decimal64(FastMath.acosh(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 add(double r1) {
        return add2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object add(Object r3) {
        return add((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public Decimal64 add2(double r4) {
        return new Decimal64(this.value + r4);
    }

    public Decimal64 add(Decimal64 r4) {
        return new Decimal64(this.value + r4.value);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 asin() {
        return asin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asin, reason: avoid collision after fix types in other method */
    public Decimal64 asin2() {
        return new Decimal64(FastMath.asin(this.value));
    }

    public /* bridge */ /* synthetic */ Object asinh() {
        return m3128asinh();
    }

    /* JADX INFO: renamed from: asinh, reason: collision with other method in class */
    public Decimal64 m3128asinh() {
        return new Decimal64(FastMath.asinh(this.value));
    }

    public /* bridge */ /* synthetic */ Object atan() {
        return m3129atan();
    }

    /* JADX INFO: renamed from: atan, reason: collision with other method in class */
    public Decimal64 m3129atan() {
        return new Decimal64(FastMath.atan(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ Decimal64 atan2(Decimal64 r3) {
        return atan22((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: atan2, reason: avoid collision after fix types in other method */
    public Decimal64 atan22(Decimal64 r4) {
        return new Decimal64(FastMath.atan2(this.value, r4.value));
    }

    public /* bridge */ /* synthetic */ Object atanh() {
        return m3130atanh();
    }

    /* JADX INFO: renamed from: atanh, reason: collision with other method in class */
    public Decimal64 m3130atanh() {
        return new Decimal64(FastMath.atanh(this.value));
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return (byte) this.value;
    }

    public /* bridge */ /* synthetic */ Object cbrt() {
        return m3131cbrt();
    }

    /* JADX INFO: renamed from: cbrt, reason: collision with other method in class */
    public Decimal64 m3131cbrt() {
        return new Decimal64(FastMath.cbrt(this.value));
    }

    public /* bridge */ /* synthetic */ Object ceil() {
        return m3132ceil();
    }

    /* JADX INFO: renamed from: ceil, reason: collision with other method in class */
    public Decimal64 m3132ceil() {
        return new Decimal64(FastMath.ceil(this.value));
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Decimal64 r3) {
        return compareTo2((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Decimal64 r3) {
        return Double.compare(this.value, r3.value);
    }

    public /* bridge */ /* synthetic */ Object copySign(double r1) {
        return m3133copySign(r1);
    }

    public /* synthetic */ Object copySign(Object r3) {
        return copySign((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: copySign, reason: collision with other method in class */
    public Decimal64 m3133copySign(double r4) {
        return new Decimal64(FastMath.copySign(this.value, r4));
    }

    public Decimal64 copySign(Decimal64 r4) {
        return new Decimal64(FastMath.copySign(this.value, r4.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 cos() {
        return cos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cos, reason: avoid collision after fix types in other method */
    public Decimal64 cos2() {
        return new Decimal64(FastMath.cos(this.value));
    }

    public /* bridge */ /* synthetic */ Object cosh() {
        return m3134cosh();
    }

    /* JADX INFO: renamed from: cosh, reason: collision with other method in class */
    public Decimal64 m3134cosh() {
        return new Decimal64(FastMath.cosh(this.value));
    }

    public /* bridge */ /* synthetic */ Object divide(double r1) {
        return m3135divide(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object divide(Object r3) {
        return divide((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: divide, reason: collision with other method in class */
    public Decimal64 m3135divide(double r4) {
        return new Decimal64(this.value / r4);
    }

    public Decimal64 divide(Decimal64 r4) {
        return new Decimal64(this.value / r4.value);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Decimal64.class) == false) goto L8;
        Decimal64 r5 = (Decimal64) ZeusTransformUtils.preCheckCast(r4, Decimal64.class, "com.obric.memorydata.plugin");
        if (Double.doubleToLongBits(this.value) != Double.doubleToLongBits(r5.value)) goto L9;
        return true;
    L9:
        return false;
    L8:
        return false;
    }

    public /* bridge */ /* synthetic */ Object exp() {
        return m3136exp();
    }

    /* JADX INFO: renamed from: exp, reason: collision with other method in class */
    public Decimal64 m3136exp() {
        return new Decimal64(FastMath.exp(this.value));
    }

    public /* bridge */ /* synthetic */ Object expm1() {
        return m3137expm1();
    }

    /* JADX INFO: renamed from: expm1, reason: collision with other method in class */
    public Decimal64 m3137expm1() {
        return new Decimal64(FastMath.expm1(this.value));
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    public /* bridge */ /* synthetic */ Object floor() {
        return m3138floor();
    }

    /* JADX INFO: renamed from: floor, reason: collision with other method in class */
    public Decimal64 m3138floor() {
        return new Decimal64(FastMath.floor(this.value));
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<Decimal64> getField() {
        return Decimal64Field.getInstance();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return this.value;
    }

    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.value);
        return (int) (r0 ^ (r0 >>> 32));
    }

    public /* synthetic */ Object hypot(Object r3) {
        return hypot((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    public Decimal64 hypot(Decimal64 r4) {
        return new Decimal64(FastMath.hypot(this.value, r4.value));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ Decimal64 linearCombination(double r10, Decimal64 r12, double r13, Decimal64 r15) {
        return linearCombination2(r10, (Decimal64) ZeusTransformUtils.preCheckCast(r12, Decimal64.class, "com.obric.memorydata.plugin"), r13, (Decimal64) ZeusTransformUtils.preCheckCast(r15, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ Decimal64 linearCombination(double r14, Decimal64 r16, double r17, Decimal64 r19, double r20, Decimal64 r22) {
        return linearCombination2(r14, (Decimal64) ZeusTransformUtils.preCheckCast(r16, Decimal64.class, "com.obric.memorydata.plugin"), r17, (Decimal64) ZeusTransformUtils.preCheckCast(r19, Decimal64.class, "com.obric.memorydata.plugin"), r20, (Decimal64) ZeusTransformUtils.preCheckCast(r22, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ Decimal64 linearCombination(double r17, Decimal64 r19, double r20, Decimal64 r22, double r23, Decimal64 r25, double r26, Decimal64 r28) {
        return linearCombination2(r17, (Decimal64) ZeusTransformUtils.preCheckCast(r19, Decimal64.class, "com.obric.memorydata.plugin"), r20, (Decimal64) ZeusTransformUtils.preCheckCast(r22, Decimal64.class, "com.obric.memorydata.plugin"), r23, (Decimal64) ZeusTransformUtils.preCheckCast(r25, Decimal64.class, "com.obric.memorydata.plugin"), r26, (Decimal64) ZeusTransformUtils.preCheckCast(r28, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ Decimal64 linearCombination(Decimal64 r3, Decimal64 r4, Decimal64 r5, Decimal64 r6) {
        return linearCombination2((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r4, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r5, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r6, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ Decimal64 linearCombination(Decimal64 r10, Decimal64 r11, Decimal64 r12, Decimal64 r13, Decimal64 r14, Decimal64 r15) {
        return linearCombination2((Decimal64) ZeusTransformUtils.preCheckCast(r10, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r11, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r12, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r13, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r14, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r15, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ Decimal64 linearCombination(Decimal64 r11, Decimal64 r12, Decimal64 r13, Decimal64 r14, Decimal64 r15, Decimal64 r16, Decimal64 r17, Decimal64 r18) {
        return linearCombination2((Decimal64) ZeusTransformUtils.preCheckCast(r11, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r12, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r13, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r14, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r15, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r16, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r17, Decimal64.class, "com.obric.memorydata.plugin"), (Decimal64) ZeusTransformUtils.preCheckCast(r18, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ Object linearCombination(double[] r3, Object[] r4) {
        return linearCombination(r3, (Decimal64[]) ZeusTransformUtils.preCheckCast(r4, Decimal64[].class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ Object linearCombination(Object[] r3, Object[] r4) {
        return linearCombination((Decimal64[]) ZeusTransformUtils.preCheckCast(r3, Decimal64[].class, "com.obric.memorydata.plugin"), (Decimal64[]) ZeusTransformUtils.preCheckCast(r4, Decimal64[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(double r9, Decimal64 r11, double r12, Decimal64 r14) {
        return new Decimal64(MathArrays.linearCombination(r9, r11.value, r12, r14.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(double r14, Decimal64 r16, double r17, Decimal64 r19, double r20, Decimal64 r22) {
        return new Decimal64(MathArrays.linearCombination(r14, r16.value, r17, r19.value, r20, r22.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(double r18, Decimal64 r20, double r21, Decimal64 r23, double r24, Decimal64 r26, double r27, Decimal64 r29) {
        return new Decimal64(MathArrays.linearCombination(r18, r20.value, r21, r23.value, r24, r26.value, r27, r29.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(Decimal64 r9, Decimal64 r10, Decimal64 r11, Decimal64 r12) {
        return new Decimal64(MathArrays.linearCombination(r9.value, r10.value, r11.value, r12.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(Decimal64 r14, Decimal64 r15, Decimal64 r16, Decimal64 r17, Decimal64 r18, Decimal64 r19) {
        return new Decimal64(MathArrays.linearCombination(r14.value, r15.value, r16.value, r17.value, r18.value, r19.value));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public Decimal64 linearCombination2(Decimal64 r18, Decimal64 r19, Decimal64 r20, Decimal64 r21, Decimal64 r22, Decimal64 r23, Decimal64 r24, Decimal64 r25) {
        return new Decimal64(MathArrays.linearCombination(r18.value, r19.value, r20.value, r21.value, r22.value, r23.value, r24.value, r25.value));
    }

    public Decimal64 linearCombination(double[] r4, Decimal64[] r5) {
        if (r4.length != r5.length) goto L11;
        double[] r3 = new double[r5.length];
        int r0 = 0;
    L6:
        if (r0 >= r4.length) goto L9;
        r3[r0] = r5[r0].value;
        r0 = r0 + 1;
        goto L6
    L9:
        return new Decimal64(MathArrays.linearCombination(r4, r3));
    L11:
        throw new DimensionMismatchException(r4.length, r5.length);
    }

    public Decimal64 linearCombination(Decimal64[] r5, Decimal64[] r6) {
        if (r5.length != r6.length) goto L11;
        double[] r4 = new double[r5.length];
        double[] r0 = new double[r6.length];
        int r1 = 0;
    L6:
        if (r1 >= r5.length) goto L9;
        r4[r1] = r5[r1].value;
        r0[r1] = r6[r1].value;
        r1 = r1 + 1;
        goto L6
    L9:
        return new Decimal64(MathArrays.linearCombination(r4, r0));
    L11:
        throw new DimensionMismatchException(r5.length, r6.length);
    }

    public /* bridge */ /* synthetic */ Object log() {
        return m3139log();
    }

    /* JADX INFO: renamed from: log, reason: collision with other method in class */
    public Decimal64 m3139log() {
        return new Decimal64(FastMath.log(this.value));
    }

    public Decimal64 log10() {
        return new Decimal64(FastMath.log10(this.value));
    }

    public /* bridge */ /* synthetic */ Object log1p() {
        return m3140log1p();
    }

    /* JADX INFO: renamed from: log1p, reason: collision with other method in class */
    public Decimal64 m3140log1p() {
        return new Decimal64(FastMath.log1p(this.value));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 multiply(double r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(int r1) {
        return multiply(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object multiply(Object r3) {
        return multiply((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public Decimal64 multiply2(double r4) {
        return new Decimal64(this.value * r4);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Decimal64 multiply(int r4) {
        return new Decimal64(((double) r4) * this.value);
    }

    public Decimal64 multiply(Decimal64 r4) {
        return new Decimal64(this.value * r4.value);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.FieldElement
    public Decimal64 negate() {
        return new Decimal64(-this.value);
    }

    public /* bridge */ /* synthetic */ Object pow(double r1) {
        return m3141pow(r1);
    }

    public /* bridge */ /* synthetic */ Object pow(int r1) {
        return m3142pow(r1);
    }

    public /* synthetic */ Object pow(Object r3) {
        return pow((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: pow, reason: collision with other method in class */
    public Decimal64 m3141pow(double r4) {
        return new Decimal64(FastMath.pow(this.value, r4));
    }

    /* JADX INFO: renamed from: pow, reason: collision with other method in class */
    public Decimal64 m3142pow(int r4) {
        return new Decimal64(FastMath.pow(this.value, r4));
    }

    public Decimal64 pow(Decimal64 r4) {
        return new Decimal64(FastMath.pow(this.value, r4.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 reciprocal() {
        return reciprocal2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: reciprocal, reason: avoid collision after fix types in other method */
    public Decimal64 reciprocal2() {
        return new Decimal64(1.0d / this.value);
    }

    public /* bridge */ /* synthetic */ Object remainder(double r1) {
        return m3143remainder(r1);
    }

    public /* synthetic */ Object remainder(Object r3) {
        return remainder((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: remainder, reason: collision with other method in class */
    public Decimal64 m3143remainder(double r4) {
        return new Decimal64(FastMath.IEEEremainder(this.value, r4));
    }

    public Decimal64 remainder(Decimal64 r4) {
        return new Decimal64(FastMath.IEEEremainder(this.value, r4.value));
    }

    public /* bridge */ /* synthetic */ Object rint() {
        return m3144rint();
    }

    /* JADX INFO: renamed from: rint, reason: collision with other method in class */
    public Decimal64 m3144rint() {
        return new Decimal64(FastMath.rint(this.value));
    }

    public /* bridge */ /* synthetic */ Object rootN(int r1) {
        return m3145rootN(r1);
    }

    /* JADX INFO: renamed from: rootN, reason: collision with other method in class */
    public Decimal64 m3145rootN(int r6) {
        if (this.value >= 0.0d) goto L7;
        return new Decimal64(-FastMath.pow(-this.value, 1.0d / ((double) r6)));
    L7:
        return new Decimal64(FastMath.pow(this.value, 1.0d / ((double) r6)));
    }

    public long round() {
        return FastMath.round(this.value);
    }

    public /* bridge */ /* synthetic */ Object scalb(int r1) {
        return m3146scalb(r1);
    }

    /* JADX INFO: renamed from: scalb, reason: collision with other method in class */
    public Decimal64 m3146scalb(int r4) {
        return new Decimal64(FastMath.scalb(this.value, r4));
    }

    @Override // java.lang.Number
    public short shortValue() {
        return (short) this.value;
    }

    public /* bridge */ /* synthetic */ Object signum() {
        return m3147signum();
    }

    /* JADX INFO: renamed from: signum, reason: collision with other method in class */
    public Decimal64 m3147signum() {
        return new Decimal64(FastMath.signum(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 sin() {
        return sin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sin, reason: avoid collision after fix types in other method */
    public Decimal64 sin2() {
        return new Decimal64(FastMath.sin(this.value));
    }

    public /* bridge */ /* synthetic */ Object sinh() {
        return m3148sinh();
    }

    /* JADX INFO: renamed from: sinh, reason: collision with other method in class */
    public Decimal64 m3148sinh() {
        return new Decimal64(FastMath.sinh(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 sqrt() {
        return sqrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sqrt, reason: avoid collision after fix types in other method */
    public Decimal64 sqrt2() {
        return new Decimal64(FastMath.sqrt(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ Decimal64 subtract(double r1) {
        return subtract2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object subtract(Object r3) {
        return subtract((Decimal64) ZeusTransformUtils.preCheckCast(r3, Decimal64.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public Decimal64 subtract2(double r4) {
        return new Decimal64(this.value - r4);
    }

    public Decimal64 subtract(Decimal64 r4) {
        return new Decimal64(this.value - r4.value);
    }

    public /* bridge */ /* synthetic */ Object tan() {
        return m3149tan();
    }

    /* JADX INFO: renamed from: tan, reason: collision with other method in class */
    public Decimal64 m3149tan() {
        return new Decimal64(FastMath.tan(this.value));
    }

    public /* bridge */ /* synthetic */ Object tanh() {
        return m3150tanh();
    }

    /* JADX INFO: renamed from: tanh, reason: collision with other method in class */
    public Decimal64 m3150tanh() {
        return new Decimal64(FastMath.tanh(this.value));
    }

    public String toString() {
        return Double.toString(this.value);
    }
}
