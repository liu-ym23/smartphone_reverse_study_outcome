package org.apache.commons.math3.analysis.differentiation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class DerivativeStructure implements Serializable, RealFieldElement<DerivativeStructure> {
    private static final long serialVersionUID = 20120730;
    private transient DSCompiler compiler;
    private final double[] data;

    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120730;
        private final double[] data;
        private final int order;
        private final int variables;

        DataTransferObject(int r1, int r2, double[] r3) {
            this.variables = r1;
            this.order = r2;
            this.data = r3;
        }

        private Object readResolve() {
            return new DerivativeStructure(this.variables, this.order, this.data);
        }
    }

    public DerivativeStructure(double r17, DerivativeStructure r19, double r20, DerivativeStructure r22) {
        this(r19.compiler);
        this.compiler.checkCompatibility(r22.compiler);
        this.compiler.linearCombination(r17, r19.data, 0, r20, r22.data, 0, this.data, 0);
    }

    public DerivativeStructure(double r22, DerivativeStructure r24, double r25, DerivativeStructure r27, double r28, DerivativeStructure r30) {
        this(r24.compiler);
        this.compiler.checkCompatibility(r27.compiler);
        this.compiler.checkCompatibility(r30.compiler);
        this.compiler.linearCombination(r22, r24.data, 0, r25, r27.data, 0, r28, r30.data, 0, this.data, 0);
    }

    public DerivativeStructure(double r25, DerivativeStructure r27, double r28, DerivativeStructure r30, double r31, DerivativeStructure r33, double r34, DerivativeStructure r36) {
        this(r27.compiler);
        this.compiler.checkCompatibility(r30.compiler);
        this.compiler.checkCompatibility(r33.compiler);
        this.compiler.checkCompatibility(r36.compiler);
        this.compiler.linearCombination(r25, r27.data, 0, r28, r30.data, 0, r31, r33.data, 0, r34, r36.data, 0, this.data, 0);
    }

    public DerivativeStructure(int r1, int r2) {
        this(DSCompiler.getCompiler(r1, r2));
    }

    public DerivativeStructure(int r1, int r2, double r3) {
        this(r1, r2);
        this.data[0] = r3;
    }

    public DerivativeStructure(int r1, int r2, int r3, double r4) {
        this(r1, r2, r4);
        if (r3 >= r1) goto L8;
        if (r2 <= 0) goto L9;
        this.data[DSCompiler.getCompiler(r3, r2).getSize()] = 1.0d;
        return;
    L9:
        return;
    L8:
        throw new NumberIsTooLargeException(Integer.valueOf(r3), Integer.valueOf(r1), false);
    }

    public DerivativeStructure(int r2, int r3, double... r4) {
        this(r2, r3);
        int r5 = r4.length;
        double[] r6 = this.data;
        if (r5 != r6.length) goto L7;
        System.arraycopy(r4, 0, r6, 0, r6.length);
        return;
    L7:
        throw new DimensionMismatchException(r4.length, this.data.length);
    }

    private DerivativeStructure(DSCompiler r1) {
        this.compiler = r1;
        this.data = new double[r1.getSize()];
    }

    private DerivativeStructure(DerivativeStructure r3) {
        this.compiler = r3.compiler;
        this.data = (double[]) ZeusTransformUtils.preCheckCast(r3.data.clone(), double[].class, "com.obric.memorydata.plugin");
    }

    static /* synthetic */ DSCompiler access$000(DerivativeStructure r0) {
        return r0.compiler;
    }

    public static DerivativeStructure atan2(DerivativeStructure r0, DerivativeStructure r1) {
        return r0.atan22(r1);
    }

    public static DerivativeStructure hypot(DerivativeStructure r0, DerivativeStructure r1) {
        return r0.hypot(r1);
    }

    public static DerivativeStructure pow(double r9, DerivativeStructure r11) {
        DerivativeStructure r0 = new DerivativeStructure(r11.compiler);
        r11.compiler.pow(r9, r11.data, 0, r0.data, 0);
        return r0;
    }

    private Object writeReplace() {
        return new DataTransferObject(this.compiler.getFreeParameters(), this.compiler.getOrder(), this.data);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure abs() {
        return abs2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: abs, reason: avoid collision after fix types in other method */
    public DerivativeStructure abs2() {
        if (Double.doubleToLongBits(this.data[0]) < 0) goto L5;
        return this;
    L5:
        return negate();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure acos() {
        return acos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acos, reason: avoid collision after fix types in other method */
    public DerivativeStructure acos2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.acos(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object acosh() {
        return m3073acosh();
    }

    /* JADX INFO: renamed from: acosh, reason: collision with other method in class */
    public DerivativeStructure m3073acosh() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.acosh(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure add(double r1) {
        return add2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object add(Object r3) {
        return add((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public DerivativeStructure add2(double r5) {
        DerivativeStructure r0 = new DerivativeStructure(this);
        double[] r4 = r0.data;
        r4[0] = r4[0] + r5;
        return r0;
    }

    public DerivativeStructure add(DerivativeStructure r9) {
        this.compiler.checkCompatibility(r9.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this);
        this.compiler.add(this.data, 0, r9.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure asin() {
        return asin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asin, reason: avoid collision after fix types in other method */
    public DerivativeStructure asin2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.asin(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object asinh() {
        return m3074asinh();
    }

    /* JADX INFO: renamed from: asinh, reason: collision with other method in class */
    public DerivativeStructure m3074asinh() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.asinh(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object atan() {
        return m3075atan();
    }

    /* JADX INFO: renamed from: atan, reason: collision with other method in class */
    public DerivativeStructure m3075atan() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.atan(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ DerivativeStructure atan2(DerivativeStructure r3) {
        return atan22((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: atan2, reason: avoid collision after fix types in other method */
    public DerivativeStructure atan22(DerivativeStructure r10) {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.atan2(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object atanh() {
        return m3076atanh();
    }

    /* JADX INFO: renamed from: atanh, reason: collision with other method in class */
    public DerivativeStructure m3076atanh() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.atanh(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object cbrt() {
        return m3077cbrt();
    }

    /* JADX INFO: renamed from: cbrt, reason: collision with other method in class */
    public DerivativeStructure m3077cbrt() {
        return m3091rootN(3);
    }

    public /* bridge */ /* synthetic */ Object ceil() {
        return m3078ceil();
    }

    /* JADX INFO: renamed from: ceil, reason: collision with other method in class */
    public DerivativeStructure m3078ceil() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.ceil(this.data[0]));
    }

    public DerivativeStructure compose(double... r9) {
        if (r9.length != (getOrder() + 1)) goto L7;
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.compose(this.data, 0, r9, r0.data, 0);
        return r0;
    L7:
        throw new DimensionMismatchException(r9.length, getOrder() + 1);
    }

    public /* bridge */ /* synthetic */ Object copySign(double r1) {
        return m3079copySign(r1);
    }

    public /* synthetic */ Object copySign(Object r3) {
        return copySign((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: copySign, reason: collision with other method in class */
    public DerivativeStructure m3079copySign(double r5) {
        long r0 = Double.doubleToLongBits(this.data[0]);
        long r6 = Double.doubleToLongBits(r5);
        if (r0 >= 0) goto L5;
    L6:
        if (r0 >= 0) goto L11;
        if (r6 >= 0) goto L11;
    L9:
        return this;
    L11:
        return negate();
    L5:
        if (r6 >= 0) goto L9;
        goto L6
    }

    public DerivativeStructure copySign(DerivativeStructure r7) {
        long r2 = Double.doubleToLongBits(this.data[0]);
        long r0 = Double.doubleToLongBits(r7.data[0]);
        if (r2 >= 0) goto L5;
    L6:
        if (r2 >= 0) goto L11;
        if (r0 >= 0) goto L11;
    L9:
        return this;
    L11:
        return negate();
    L5:
        if (r0 >= 0) goto L9;
        goto L6
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure cos() {
        return cos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cos, reason: avoid collision after fix types in other method */
    public DerivativeStructure cos2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.cos(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object cosh() {
        return m3080cosh();
    }

    /* JADX INFO: renamed from: cosh, reason: collision with other method in class */
    public DerivativeStructure m3080cosh() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.cosh(this.data, 0, r0.data, 0);
        return r0;
    }

    public DerivativeStructure createConstant(double r3) {
        return new DerivativeStructure(getFreeParameters(), getOrder(), r3);
    }

    public /* bridge */ /* synthetic */ Object divide(double r1) {
        return m3081divide(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object divide(Object r3) {
        return divide((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: divide, reason: collision with other method in class */
    public DerivativeStructure m3081divide(double r5) {
        DerivativeStructure r0 = new DerivativeStructure(this);
        int r4 = 0;
    L3:
        double[] r1 = r0.data;
        if (r4 >= r1.length) goto L6;
        r1[r4] = r1[r4] / r5;
        r4 = r4 + 1;
        goto L3
    L6:
        return r0;
    }

    public DerivativeStructure divide(DerivativeStructure r10) {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.divide(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DerivativeStructure.class) == false) goto L16;
        DerivativeStructure r6 = (DerivativeStructure) ZeusTransformUtils.preCheckCast(r5, DerivativeStructure.class, "com.obric.memorydata.plugin");
        if (getFreeParameters() != r6.getFreeParameters()) goto L15;
        if (getOrder() != r6.getOrder()) goto L15;
        if (MathArrays.equals(this.data, r6.data) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public /* bridge */ /* synthetic */ Object exp() {
        return m3082exp();
    }

    /* JADX INFO: renamed from: exp, reason: collision with other method in class */
    public DerivativeStructure m3082exp() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.exp(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object expm1() {
        return m3083expm1();
    }

    /* JADX INFO: renamed from: expm1, reason: collision with other method in class */
    public DerivativeStructure m3083expm1() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.expm1(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object floor() {
        return m3084floor();
    }

    /* JADX INFO: renamed from: floor, reason: collision with other method in class */
    public DerivativeStructure m3084floor() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.floor(this.data[0]));
    }

    public double[] getAllDerivatives() {
        return (double[]) ZeusTransformUtils.preCheckCast(this.data.clone(), double[].class, "com.obric.memorydata.plugin");
    }

    public int getExponent() {
        return FastMath.getExponent(this.data[0]);
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<DerivativeStructure> getField() {
        return new AnonymousClass1(this);
    }

    public int getFreeParameters() {
        return this.compiler.getFreeParameters();
    }

    public int getOrder() {
        return this.compiler.getOrder();
    }

    public double getPartialDerivative(int... r2) {
        return this.data[this.compiler.getPartialDerivativeIndex(r2)];
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return this.data[0];
    }

    public double getValue() {
        return this.data[0];
    }

    public int hashCode() {
        return (((getFreeParameters() * 229) + 227) + (getOrder() * 233)) + (MathUtils.hash(this.data) * 239);
    }

    public /* synthetic */ Object hypot(Object r3) {
        return hypot((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    public DerivativeStructure hypot(DerivativeStructure r5) {
        this.compiler.checkCompatibility(r5.compiler);
        if (Double.isInfinite(this.data[0]) == true) goto L25;
        if (Double.isInfinite(r5.data[0]) == true) goto L25;
        if (Double.isNaN(this.data[0]) == true) goto L23;
        if (Double.isNaN(r5.data[0]) == true) goto L23;
        int r0 = getExponent();
        int r1 = r5.getExponent();
        if (r0 <= (r1 + 27)) goto L17;
        return abs2();
    L17:
        if (r1 > (r0 + 27)) goto L19;
        int r2 = (r0 + r1) / 2;
        int r3 = -r2;
        DerivativeStructure r4 = m3092scalb(r3);
        DerivativeStructure r6 = r5.m3092scalb(r3);
        return r4.multiply(r4).add(r6.multiply(r6)).sqrt2().m3092scalb(r2);
    L19:
        return r5.abs2();
    L23:
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getFreeParameters(), Double.NaN);
    L25:
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getFreeParameters(), Double.POSITIVE_INFINITY);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ DerivativeStructure linearCombination(double r10, DerivativeStructure r12, double r13, DerivativeStructure r15) {
        return linearCombination2(r10, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r12, DerivativeStructure.class, "com.obric.memorydata.plugin"), r13, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r15, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ DerivativeStructure linearCombination(double r14, DerivativeStructure r16, double r17, DerivativeStructure r19, double r20, DerivativeStructure r22) {
        return linearCombination2(r14, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r16, DerivativeStructure.class, "com.obric.memorydata.plugin"), r17, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r19, DerivativeStructure.class, "com.obric.memorydata.plugin"), r20, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r22, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ DerivativeStructure linearCombination(double r17, DerivativeStructure r19, double r20, DerivativeStructure r22, double r23, DerivativeStructure r25, double r26, DerivativeStructure r28) {
        return linearCombination2(r17, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r19, DerivativeStructure.class, "com.obric.memorydata.plugin"), r20, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r22, DerivativeStructure.class, "com.obric.memorydata.plugin"), r23, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r25, DerivativeStructure.class, "com.obric.memorydata.plugin"), r26, (DerivativeStructure) ZeusTransformUtils.preCheckCast(r28, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ DerivativeStructure linearCombination(DerivativeStructure r3, DerivativeStructure r4, DerivativeStructure r5, DerivativeStructure r6) {
        return linearCombination2((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r4, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r5, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r6, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ DerivativeStructure linearCombination(DerivativeStructure r10, DerivativeStructure r11, DerivativeStructure r12, DerivativeStructure r13, DerivativeStructure r14, DerivativeStructure r15) {
        return linearCombination2((DerivativeStructure) ZeusTransformUtils.preCheckCast(r10, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r11, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r12, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r13, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r14, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r15, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ DerivativeStructure linearCombination(DerivativeStructure r11, DerivativeStructure r12, DerivativeStructure r13, DerivativeStructure r14, DerivativeStructure r15, DerivativeStructure r16, DerivativeStructure r17, DerivativeStructure r18) {
        return linearCombination2((DerivativeStructure) ZeusTransformUtils.preCheckCast(r11, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r12, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r13, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r14, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r15, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r16, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r17, DerivativeStructure.class, "com.obric.memorydata.plugin"), (DerivativeStructure) ZeusTransformUtils.preCheckCast(r18, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ Object linearCombination(double[] r3, Object[] r4) {
        return linearCombination(r3, (DerivativeStructure[]) ZeusTransformUtils.preCheckCast(r4, DerivativeStructure[].class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ Object linearCombination(Object[] r3, Object[] r4) {
        return linearCombination((DerivativeStructure[]) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure[].class, "com.obric.memorydata.plugin"), (DerivativeStructure[]) ZeusTransformUtils.preCheckCast(r4, DerivativeStructure[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(double r9, DerivativeStructure r11, double r12, DerivativeStructure r14) {
        double r0 = MathArrays.linearCombination(r9, r11.getValue(), r12, r14.getValue());
        double[] r10 = r11.multiply2(r9).add(r14.multiply2(r12)).getAllDerivatives();
        r10[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r10);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(double r13, DerivativeStructure r15, double r16, DerivativeStructure r18, double r19, DerivativeStructure r21) {
        double r0 = MathArrays.linearCombination(r13, r15.getValue(), r16, r18.getValue(), r19, r21.getValue());
        double[] r2 = r15.multiply2(r13).add(r18.multiply2(r16)).add(r21.multiply2(r19)).getAllDerivatives();
        r2[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r2);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(double r17, DerivativeStructure r19, double r20, DerivativeStructure r22, double r23, DerivativeStructure r25, double r26, DerivativeStructure r28) {
        double r0 = MathArrays.linearCombination(r17, r19.getValue(), r20, r22.getValue(), r23, r25.getValue(), r26, r28.getValue());
        double[] r2 = r19.multiply2(r17).add(r22.multiply2(r20)).add(r25.multiply2(r23)).add(r28.multiply2(r26)).getAllDerivatives();
        r2[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r2);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(DerivativeStructure r9, DerivativeStructure r10, DerivativeStructure r11, DerivativeStructure r12) {
        double r0 = MathArrays.linearCombination(r9.getValue(), r10.getValue(), r11.getValue(), r12.getValue());
        double[] r13 = r9.multiply(r10).add(r11.multiply(r12)).getAllDerivatives();
        r13[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r13);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(DerivativeStructure r13, DerivativeStructure r14, DerivativeStructure r15, DerivativeStructure r16, DerivativeStructure r17, DerivativeStructure r18) {
        double r0 = MathArrays.linearCombination(r13.getValue(), r14.getValue(), r15.getValue(), r16.getValue(), r17.getValue(), r18.getValue());
        double[] r2 = r13.multiply(r14).add(r15.multiply(r16)).add(r17.multiply(r18)).getAllDerivatives();
        r2[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r2);
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public DerivativeStructure linearCombination2(DerivativeStructure r17, DerivativeStructure r18, DerivativeStructure r19, DerivativeStructure r20, DerivativeStructure r21, DerivativeStructure r22, DerivativeStructure r23, DerivativeStructure r24) {
        double r0 = MathArrays.linearCombination(r17.getValue(), r18.getValue(), r19.getValue(), r20.getValue(), r21.getValue(), r22.getValue(), r23.getValue(), r24.getValue());
        double[] r2 = r17.multiply(r18).add(r19.multiply(r20)).add(r21.multiply(r22)).add(r23.multiply(r24)).getAllDerivatives();
        r2[0] = r0;
        return new DerivativeStructure(getFreeParameters(), getOrder(), r2);
    }

    public DerivativeStructure linearCombination(double[] r8, DerivativeStructure[] r9) {
        double[] r7 = new double[r9.length];
        int r1 = 0;
    L4:
        if (r1 >= r9.length) goto L6;
        r7[r1] = r9[r1].getValue();
        r1 = r1 + 1;
        goto L4
    L6:
        double r2 = MathArrays.linearCombination(r8, r7);
        DerivativeStructure r10 = (DerivativeStructure) ZeusTransformUtils.preCheckCast(r9[0].getField().getZero(), DerivativeStructure.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L8:
        if (r3 >= r8.length) goto L10;
        r10 = r10.add(r9[r3].multiply2(r8[r3]));
        r3 = r3 + 1;
        goto L8
    L10:
        double[] r11 = r10.getAllDerivatives();
        r11[0] = r2;
        return new DerivativeStructure(r10.getFreeParameters(), r10.getOrder(), r11);
    }

    public DerivativeStructure linearCombination(DerivativeStructure[] r7, DerivativeStructure[] r8) {
        double[] r6 = new double[r7.length];
        int r1 = 0;
    L4:
        if (r1 >= r7.length) goto L6;
        r6[r1] = r7[r1].getValue();
        r1 = r1 + 1;
        goto L4
    L6:
        double[] r2 = new double[r8.length];
        int r3 = 0;
    L8:
        if (r3 >= r8.length) goto L10;
        r2[r3] = r8[r3].getValue();
        r3 = r3 + 1;
        goto L8
    L10:
        double r4 = MathArrays.linearCombination(r6, r2);
        DerivativeStructure r9 = (DerivativeStructure) ZeusTransformUtils.preCheckCast(r7[0].getField().getZero(), DerivativeStructure.class, "com.obric.memorydata.plugin");
        int r5 = 0;
    L12:
        if (r5 >= r7.length) goto L14;
        r9 = r9.add(r7[r5].multiply(r8[r5]));
        r5 = r5 + 1;
        goto L12
    L14:
        double[] r10 = r9.getAllDerivatives();
        r10[0] = r4;
        return new DerivativeStructure(r9.getFreeParameters(), r9.getOrder(), r10);
    }

    public /* bridge */ /* synthetic */ Object log() {
        return m3085log();
    }

    /* JADX INFO: renamed from: log, reason: collision with other method in class */
    public DerivativeStructure m3085log() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.log(this.data, 0, r0.data, 0);
        return r0;
    }

    public DerivativeStructure log10() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.log10(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object log1p() {
        return m3086log1p();
    }

    /* JADX INFO: renamed from: log1p, reason: collision with other method in class */
    public DerivativeStructure m3086log1p() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.log1p(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure multiply(double r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(int r1) {
        return multiply(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object multiply(Object r3) {
        return multiply((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public DerivativeStructure multiply2(double r5) {
        DerivativeStructure r0 = new DerivativeStructure(this);
        int r4 = 0;
    L3:
        double[] r1 = r0.data;
        if (r4 >= r1.length) goto L6;
        r1[r4] = r1[r4] * r5;
        r4 = r4 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure multiply(int r3) {
        return multiply2(r3);
    }

    public DerivativeStructure multiply(DerivativeStructure r10) {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.multiply(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.FieldElement
    public DerivativeStructure negate() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        int r1 = 0;
    L3:
        double[] r2 = r0.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = -this.data[r1];
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object pow(double r1) {
        return m3087pow(r1);
    }

    public /* bridge */ /* synthetic */ Object pow(int r1) {
        return m3088pow(r1);
    }

    public /* synthetic */ Object pow(Object r3) {
        return pow((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: pow, reason: collision with other method in class */
    public DerivativeStructure m3087pow(double r10) {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, r10, r0.data, 0);
        return r0;
    }

    /* JADX INFO: renamed from: pow, reason: collision with other method in class */
    public DerivativeStructure m3088pow(int r9) {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, r9, r0.data, 0);
        return r0;
    }

    public DerivativeStructure pow(DerivativeStructure r10) {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure reciprocal() {
        return reciprocal2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: reciprocal, reason: avoid collision after fix types in other method */
    public DerivativeStructure reciprocal2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.pow(this.data, 0, -1, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object remainder(double r1) {
        return m3089remainder(r1);
    }

    public /* synthetic */ Object remainder(Object r3) {
        return remainder((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: remainder, reason: collision with other method in class */
    public DerivativeStructure m3089remainder(double r5) {
        DerivativeStructure r0 = new DerivativeStructure(this);
        double[] r4 = r0.data;
        r4[0] = FastMath.IEEEremainder(r4[0], r5);
        return r0;
    }

    public DerivativeStructure remainder(DerivativeStructure r10) {
        this.compiler.checkCompatibility(r10.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.remainder(this.data, 0, r10.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object rint() {
        return m3090rint();
    }

    /* JADX INFO: renamed from: rint, reason: collision with other method in class */
    public DerivativeStructure m3090rint() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.rint(this.data[0]));
    }

    public /* bridge */ /* synthetic */ Object rootN(int r1) {
        return m3091rootN(r1);
    }

    /* JADX INFO: renamed from: rootN, reason: collision with other method in class */
    public DerivativeStructure m3091rootN(int r9) {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.rootN(this.data, 0, r9, r0.data, 0);
        return r0;
    }

    public long round() {
        return FastMath.round(this.data[0]);
    }

    public /* bridge */ /* synthetic */ Object scalb(int r1) {
        return m3092scalb(r1);
    }

    /* JADX INFO: renamed from: scalb, reason: collision with other method in class */
    public DerivativeStructure m3092scalb(int r6) {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        int r1 = 0;
    L3:
        double[] r2 = r0.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = FastMath.scalb(this.data[r1], r6);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object signum() {
        return m3093signum();
    }

    /* JADX INFO: renamed from: signum, reason: collision with other method in class */
    public DerivativeStructure m3093signum() {
        return new DerivativeStructure(this.compiler.getFreeParameters(), this.compiler.getOrder(), FastMath.signum(this.data[0]));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure sin() {
        return sin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sin, reason: avoid collision after fix types in other method */
    public DerivativeStructure sin2() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.sin(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object sinh() {
        return m3094sinh();
    }

    /* JADX INFO: renamed from: sinh, reason: collision with other method in class */
    public DerivativeStructure m3094sinh() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.sinh(this.data, 0, r0.data, 0);
        return r0;
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure sqrt() {
        return sqrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sqrt, reason: avoid collision after fix types in other method */
    public DerivativeStructure sqrt2() {
        return m3091rootN(2);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ DerivativeStructure subtract(double r1) {
        return subtract2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object subtract(Object r3) {
        return subtract((DerivativeStructure) ZeusTransformUtils.preCheckCast(r3, DerivativeStructure.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public DerivativeStructure subtract2(double r1) {
        return add2(-r1);
    }

    public DerivativeStructure subtract(DerivativeStructure r9) {
        this.compiler.checkCompatibility(r9.compiler);
        DerivativeStructure r0 = new DerivativeStructure(this);
        this.compiler.subtract(this.data, 0, r9.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object tan() {
        return m3095tan();
    }

    /* JADX INFO: renamed from: tan, reason: collision with other method in class */
    public DerivativeStructure m3095tan() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.tan(this.data, 0, r0.data, 0);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object tanh() {
        return m3096tanh();
    }

    /* JADX INFO: renamed from: tanh, reason: collision with other method in class */
    public DerivativeStructure m3096tanh() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        this.compiler.tanh(this.data, 0, r0.data, 0);
        return r0;
    }

    public double taylor(double... r3) {
        return this.compiler.taylor(this.data, 0, r3);
    }

    public DerivativeStructure toDegrees() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        int r1 = 0;
    L3:
        double[] r2 = r0.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = FastMath.toDegrees(this.data[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    public DerivativeStructure toRadians() {
        DerivativeStructure r0 = new DerivativeStructure(this.compiler);
        int r1 = 0;
    L3:
        double[] r2 = r0.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = FastMath.toRadians(this.data[r1]);
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }
}
