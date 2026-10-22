package org.apache.commons.math3.analysis.differentiation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class SparseGradient implements Serializable, RealFieldElement<SparseGradient> {
    private static final long serialVersionUID = 20131025;
    private final Map<Integer, Double> derivatives;
    private double value;

    private SparseGradient(double r5, double r7, Map<Integer, Double> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        this.value = r5;
        this.derivatives = new HashMap();
        if (r10 == null) goto L8;
        Iterator r6 = r10.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Map<Integer, Double> r11 = this.derivatives;
        Object r0 = r8.getKey();
        Integer r1 = (Integer) r0;
        r11.put(r1, Double.valueOf(((Double) ZeusTransformUtils.preCheckCast(r8.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() * r7));
        goto L6
    L10:
        return;
    }

    private SparseGradient(double r3, Map<Integer, Double> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        this.value = r3;
        HashMap r4 = new HashMap();
        this.derivatives = r4;
        if (r6 == null) goto L6;
        r4.putAll(r6);
        return;
    }

    public static SparseGradient atan2(SparseGradient r0, SparseGradient r1) {
        return r0.atan22(r1);
    }

    public static SparseGradient createConstant(double r2) {
        return new SparseGradient(r2, Collections.emptyMap());
    }

    public static SparseGradient createVariable(int r3, double r4) {
        return new SparseGradient(r4, Collections.singletonMap(Integer.valueOf(r3), Double.valueOf(1.0d)));
    }

    public static SparseGradient hypot(SparseGradient r0, SparseGradient r1) {
        return r0.hypot(r1);
    }

    public static SparseGradient pow(double r8, SparseGradient r10) {
        if (r8 != 0.0d) goto L14;
        double r9 = r10.value;
        if (r9 != 0.0d) goto L9;
        return r10.compose(1.0d, Double.NEGATIVE_INFINITY);
    L9:
        if (r9 >= 0.0d) goto L13;
        return r10.compose(Double.NaN, Double.NaN);
    L13:
        return (SparseGradient) ZeusTransformUtils.preCheckCast(r10.getField().getZero(), SparseGradient.class, "com.obric.memorydata.plugin");
    L14:
        double r3 = FastMath.pow(r8, r10.value);
        return new SparseGradient(r3, r3 * FastMath.log(r8), r10.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient abs() {
        return abs2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: abs, reason: avoid collision after fix types in other method */
    public SparseGradient abs2() {
        if (Double.doubleToLongBits(this.value) < 0) goto L5;
        return this;
    L5:
        return negate();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient acos() {
        return acos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: acos, reason: avoid collision after fix types in other method */
    public SparseGradient acos2() {
        double r1 = FastMath.acos(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, (-1.0d) / FastMath.sqrt(1.0d - (r3 * r3)), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object acosh() {
        return m3097acosh();
    }

    /* JADX INFO: renamed from: acosh, reason: collision with other method in class */
    public SparseGradient m3097acosh() {
        double r1 = FastMath.acosh(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / FastMath.sqrt((r3 * r3) - 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient add(double r1) {
        return add2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object add(Object r3) {
        return add((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public SparseGradient add2(double r4) {
        return new SparseGradient(this.value + r4, this.derivatives);
    }

    public SparseGradient add(SparseGradient r8) {
        SparseGradient r0 = new SparseGradient(this.value + r8.value, this.derivatives);
        Iterator<Map.Entry<Integer, Double>> r7 = r8.derivatives.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r9.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        Double r3 = (Double) ZeusTransformUtils.preCheckCast(r0.derivatives.get(Integer.valueOf(r1)), Double.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        r0.derivatives.put(Integer.valueOf(r1), Double.valueOf(r3.doubleValue() + ((Double) ZeusTransformUtils.preCheckCast(r9.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L4
    L7:
        r0.derivatives.put(Integer.valueOf(r1), (Double) r9.getValue());
        goto L4
    L9:
        return r0;
    }

    public void addInPlace(SparseGradient r8) {
        this.value += r8.value;
        Iterator<Map.Entry<Integer, Double>> r9 = r8.derivatives.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L9;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r0.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        Double r3 = (Double) ZeusTransformUtils.preCheckCast(this.derivatives.get(Integer.valueOf(r1)), Double.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        this.derivatives.put(Integer.valueOf(r1), Double.valueOf(r3.doubleValue() + ((Double) ZeusTransformUtils.preCheckCast(r0.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L4
    L7:
        this.derivatives.put(Integer.valueOf(r1), (Double) r0.getValue());
        goto L4
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient asin() {
        return asin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: asin, reason: avoid collision after fix types in other method */
    public SparseGradient asin2() {
        double r1 = FastMath.asin(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / FastMath.sqrt(1.0d - (r3 * r3)), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object asinh() {
        return m3098asinh();
    }

    /* JADX INFO: renamed from: asinh, reason: collision with other method in class */
    public SparseGradient m3098asinh() {
        double r1 = FastMath.asinh(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / FastMath.sqrt((r3 * r3) + 1.0d), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object atan() {
        return m3099atan();
    }

    /* JADX INFO: renamed from: atan, reason: collision with other method in class */
    public SparseGradient m3099atan() {
        double r1 = FastMath.atan(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / ((r3 * r3) + 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ SparseGradient atan2(SparseGradient r3) {
        return atan22((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: atan2, reason: avoid collision after fix types in other method */
    public SparseGradient atan22(SparseGradient r6) {
        SparseGradient r0 = multiply(this).add(r6.multiply(r6)).sqrt2();
        if (r6.value < 0.0d) goto L5;
        SparseGradient r1 = divide(r0.add(r6)).m3099atan().multiply(2);
    L10:
        r1.value = FastMath.atan2(this.value, r6.value);
        return r1;
    L5:
        SparseGradient r2 = divide(r0.subtract(r6)).m3099atan().multiply(-2);
        if (r2.value > 0.0d) goto L8;
        double r3 = -3.141592653589793d;
    L9:
        r1 = r2.add2(r3);
        goto L10
    L8:
        r3 = 3.141592653589793d;
        goto L9
    }

    public /* bridge */ /* synthetic */ Object atanh() {
        return m3100atanh();
    }

    /* JADX INFO: renamed from: atanh, reason: collision with other method in class */
    public SparseGradient m3100atanh() {
        double r1 = FastMath.atanh(this.value);
        double r3 = this.value;
        return new SparseGradient(r1, 1.0d / (1.0d - (r3 * r3)), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object cbrt() {
        return m3101cbrt();
    }

    /* JADX INFO: renamed from: cbrt, reason: collision with other method in class */
    public SparseGradient m3101cbrt() {
        double r3 = FastMath.cbrt(this.value);
        return new SparseGradient(r3, 1.0d / ((3.0d * r3) * r3), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object ceil() {
        return m3102ceil();
    }

    /* JADX INFO: renamed from: ceil, reason: collision with other method in class */
    public SparseGradient m3102ceil() {
        return createConstant(FastMath.ceil(this.value));
    }

    public SparseGradient compose(double r8, double r10) {
        return new SparseGradient(r8, r10, this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object copySign(double r1) {
        return m3103copySign(r1);
    }

    public /* synthetic */ Object copySign(Object r3) {
        return copySign((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: copySign, reason: collision with other method in class */
    public SparseGradient m3103copySign(double r5) {
        long r0 = Double.doubleToLongBits(this.value);
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

    public SparseGradient copySign(SparseGradient r7) {
        long r0 = Double.doubleToLongBits(this.value);
        long r2 = Double.doubleToLongBits(r7.value);
        if (r0 >= 0) goto L5;
    L6:
        if (r0 >= 0) goto L11;
        if (r2 >= 0) goto L11;
    L9:
        return this;
    L11:
        return negate();
    L5:
        if (r2 >= 0) goto L9;
        goto L6
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient cos() {
        return cos2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: cos, reason: avoid collision after fix types in other method */
    public SparseGradient cos2() {
        return new SparseGradient(FastMath.cos(this.value), -FastMath.sin(this.value), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object cosh() {
        return m3104cosh();
    }

    /* JADX INFO: renamed from: cosh, reason: collision with other method in class */
    public SparseGradient m3104cosh() {
        return new SparseGradient(FastMath.cosh(this.value), FastMath.sinh(this.value), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object divide(double r1) {
        return m3105divide(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object divide(Object r3) {
        return divide((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: divide, reason: collision with other method in class */
    public SparseGradient m3105divide(double r8) {
        return new SparseGradient(this.value / r8, 1.0d / r8, this.derivatives);
    }

    public SparseGradient divide(SparseGradient r13) {
        SparseGradient r0 = new SparseGradient(this.value / r13.value, Collections.emptyMap());
        Iterator<Map.Entry<Integer, Double>> r12 = this.derivatives.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Map<Integer, Double> r3 = r0.derivatives;
        Object r4 = r1.getKey();
        Integer r5 = (Integer) r4;
        r3.put(r5, Double.valueOf(((Double) ZeusTransformUtils.preCheckCast(r1.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue() / r13.value));
        goto L4
    L6:
        Iterator<Map.Entry<Integer, Double>> r14 = r13.derivatives.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L13;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        Double r7 = (Double) ZeusTransformUtils.preCheckCast(r0.derivatives.get(Integer.valueOf(r6)), Double.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L11;
        r0.derivatives.put(Integer.valueOf(r6), Double.valueOf(r7.doubleValue() - ((r0.value / r13.value) * ((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue())));
        goto L8
    L11:
        r0.derivatives.put(Integer.valueOf(r6), Double.valueOf(((-r0.value) / r13.value) * ((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L8
    L13:
        return r0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SparseGradient.class) == false) goto L23;
        SparseGradient r10 = (SparseGradient) ZeusTransformUtils.preCheckCast(r9, SparseGradient.class, "com.obric.memorydata.plugin");
        if (Precision.equals(this.value, r10.value, 1) == true) goto L11;
        return false;
    L11:
        if (this.derivatives.size() == r10.derivatives.size()) goto L13;
        return false;
    L13:
        Iterator<Map.Entry<Integer, Double>> r8 = this.derivatives.entrySet().iterator();
    L15:
        if (r8.hasNext() == false) goto L22;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r10.derivatives.containsKey(r0.getKey()) == false) goto L18;
        if (Precision.equals(((Double) ZeusTransformUtils.preCheckCast(r0.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue(), ((Double) ZeusTransformUtils.preCheckCast(r10.derivatives.get(r0.getKey()), Double.class, "com.obric.memorydata.plugin")).doubleValue(), 1) == true) goto L15;
        return false;
    L18:
        return false;
    L22:
        return true;
    L23:
        return false;
    }

    public /* bridge */ /* synthetic */ Object exp() {
        return m3106exp();
    }

    /* JADX INFO: renamed from: exp, reason: collision with other method in class */
    public SparseGradient m3106exp() {
        double r5 = FastMath.exp(this.value);
        return new SparseGradient(r5, r5, this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object expm1() {
        return m3107expm1();
    }

    /* JADX INFO: renamed from: expm1, reason: collision with other method in class */
    public SparseGradient m3107expm1() {
        return new SparseGradient(FastMath.expm1(this.value), FastMath.exp(this.value), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object floor() {
        return m3108floor();
    }

    /* JADX INFO: renamed from: floor, reason: collision with other method in class */
    public SparseGradient m3108floor() {
        return createConstant(FastMath.floor(this.value));
    }

    public double getDerivative(int r2) {
        Double r1 = (Double) ZeusTransformUtils.preCheckCast(this.derivatives.get(Integer.valueOf(r2)), Double.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return 0.0d;
    L6:
        return r1.doubleValue();
    }

    @Override // org.apache.commons.math3.FieldElement
    public Field<SparseGradient> getField() {
        return new AnonymousClass1(this);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public double getReal() {
        return this.value;
    }

    public double getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((MathUtils.hash(this.value) * 809) + 743) + (this.derivatives.hashCode() * 167);
    }

    public /* synthetic */ Object hypot(Object r3) {
        return hypot((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    public SparseGradient hypot(SparseGradient r4) {
        if (Double.isInfinite(this.value) == true) goto L25;
        if (Double.isInfinite(r4.value) == true) goto L25;
        if (Double.isNaN(this.value) == true) goto L23;
        if (Double.isNaN(r4.value) == true) goto L23;
        int r0 = FastMath.getExponent(this.value);
        int r1 = FastMath.getExponent(r4.value);
        if (r0 <= (r1 + 27)) goto L17;
        return abs2();
    L17:
        if (r1 > (r0 + 27)) goto L19;
        int r2 = (r0 + r1) / 2;
        int r3 = -r2;
        SparseGradient r5 = m3116scalb(r3);
        SparseGradient r6 = r4.m3116scalb(r3);
        return r5.multiply(r5).add(r6.multiply(r6)).sqrt2().m3116scalb(r2);
    L19:
        return r4.abs2();
    L23:
        return createConstant(Double.NaN);
    L25:
        return createConstant(Double.POSITIVE_INFINITY);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ SparseGradient linearCombination(double r10, SparseGradient r12, double r13, SparseGradient r15) {
        return linearCombination2(r10, (SparseGradient) ZeusTransformUtils.preCheckCast(r12, SparseGradient.class, "com.obric.memorydata.plugin"), r13, (SparseGradient) ZeusTransformUtils.preCheckCast(r15, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ SparseGradient linearCombination(double r14, SparseGradient r16, double r17, SparseGradient r19, double r20, SparseGradient r22) {
        return linearCombination2(r14, (SparseGradient) ZeusTransformUtils.preCheckCast(r16, SparseGradient.class, "com.obric.memorydata.plugin"), r17, (SparseGradient) ZeusTransformUtils.preCheckCast(r19, SparseGradient.class, "com.obric.memorydata.plugin"), r20, (SparseGradient) ZeusTransformUtils.preCheckCast(r22, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ SparseGradient linearCombination(double r17, SparseGradient r19, double r20, SparseGradient r22, double r23, SparseGradient r25, double r26, SparseGradient r28) {
        return linearCombination2(r17, (SparseGradient) ZeusTransformUtils.preCheckCast(r19, SparseGradient.class, "com.obric.memorydata.plugin"), r20, (SparseGradient) ZeusTransformUtils.preCheckCast(r22, SparseGradient.class, "com.obric.memorydata.plugin"), r23, (SparseGradient) ZeusTransformUtils.preCheckCast(r25, SparseGradient.class, "com.obric.memorydata.plugin"), r26, (SparseGradient) ZeusTransformUtils.preCheckCast(r28, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ SparseGradient linearCombination(SparseGradient r3, SparseGradient r4, SparseGradient r5, SparseGradient r6) {
        return linearCombination2((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r4, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r5, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r6, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ SparseGradient linearCombination(SparseGradient r10, SparseGradient r11, SparseGradient r12, SparseGradient r13, SparseGradient r14, SparseGradient r15) {
        return linearCombination2((SparseGradient) ZeusTransformUtils.preCheckCast(r10, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r11, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r12, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r13, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r14, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r15, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* synthetic */ SparseGradient linearCombination(SparseGradient r11, SparseGradient r12, SparseGradient r13, SparseGradient r14, SparseGradient r15, SparseGradient r16, SparseGradient r17, SparseGradient r18) {
        return linearCombination2((SparseGradient) ZeusTransformUtils.preCheckCast(r11, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r12, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r13, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r14, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r15, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r16, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r17, SparseGradient.class, "com.obric.memorydata.plugin"), (SparseGradient) ZeusTransformUtils.preCheckCast(r18, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ Object linearCombination(double[] r3, Object[] r4) {
        return linearCombination(r3, (SparseGradient[]) ZeusTransformUtils.preCheckCast(r4, SparseGradient[].class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ Object linearCombination(Object[] r3, Object[] r4) {
        return linearCombination((SparseGradient[]) ZeusTransformUtils.preCheckCast(r3, SparseGradient[].class, "com.obric.memorydata.plugin"), (SparseGradient[]) ZeusTransformUtils.preCheckCast(r4, SparseGradient[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(double r9, SparseGradient r11, double r12, SparseGradient r14) {
        SparseGradient r8 = r11.multiply2(r9).add(r14.multiply2(r12));
        r8.value = MathArrays.linearCombination(r9, r11.value, r12, r14.value);
        return r8;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(double r16, SparseGradient r18, double r19, SparseGradient r21, double r22, SparseGradient r24) {
        SparseGradient r12 = r18.multiply2(r16).add(r21.multiply2(r19)).add(r24.multiply2(r22));
        r12.value = MathArrays.linearCombination(r16, r18.value, r19, r21.value, r22, r24.value);
        return r12;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(double r21, SparseGradient r23, double r24, SparseGradient r26, double r27, SparseGradient r29, double r30, SparseGradient r32) {
        SparseGradient r14 = r23.multiply2(r21).add(r26.multiply2(r24)).add(r29.multiply2(r27)).add(r32.multiply2(r30));
        r14.value = MathArrays.linearCombination(r21, r23.value, r24, r26.value, r27, r29.value, r30, r32.value);
        return r14;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(SparseGradient r9, SparseGradient r10, SparseGradient r11, SparseGradient r12) {
        SparseGradient r8 = r9.multiply(r10).add(r11.multiply(r12));
        r8.value = MathArrays.linearCombination(r9.value, r10.value, r11.value, r12.value);
        return r8;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(SparseGradient r14, SparseGradient r15, SparseGradient r16, SparseGradient r17, SparseGradient r18, SparseGradient r19) {
        SparseGradient r0 = r14.multiply(r15).add(r16.multiply(r17)).add(r18.multiply(r19));
        r0.value = MathArrays.linearCombination(r14.value, r15.value, r16.value, r17.value, r18.value, r19.value);
        return r0;
    }

    /* JADX INFO: renamed from: linearCombination, reason: avoid collision after fix types in other method */
    public SparseGradient linearCombination2(SparseGradient r18, SparseGradient r19, SparseGradient r20, SparseGradient r21, SparseGradient r22, SparseGradient r23, SparseGradient r24, SparseGradient r25) {
        SparseGradient r0 = r18.multiply(r19).add(r20.multiply(r21)).add(r22.multiply(r23)).add(r24.multiply(r25));
        r0.value = MathArrays.linearCombination(r18.value, r19.value, r20.value, r21.value, r22.value, r23.value, r24.value, r25.value);
        return r0;
    }

    public SparseGradient linearCombination(double[] r6, SparseGradient[] r7) {
        int r5 = 0;
        SparseGradient r0 = (SparseGradient) ZeusTransformUtils.preCheckCast(r7[0].getField().getZero(), SparseGradient.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0 = r0.add(r7[r1].multiply2(r6[r1]));
        r1 = r1 + 1;
        goto L4
    L6:
        double[] r2 = new double[r7.length];
    L8:
        if (r5 >= r7.length) goto L10;
        r2[r5] = r7[r5].getValue();
        r5 = r5 + 1;
        goto L8
    L10:
        r0.value = MathArrays.linearCombination(r6, r2);
        return r0;
    }

    public SparseGradient linearCombination(SparseGradient[] r6, SparseGradient[] r7) {
        int r5 = 0;
        SparseGradient r0 = (SparseGradient) ZeusTransformUtils.preCheckCast(r6[0].getField().getZero(), SparseGradient.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L6;
        r0 = r0.add(r6[r1].multiply(r7[r1]));
        r1 = r1 + 1;
        goto L4
    L6:
        double[] r2 = new double[r6.length];
        int r3 = 0;
    L8:
        if (r3 >= r6.length) goto L10;
        r2[r3] = r6[r3].getValue();
        r3 = r3 + 1;
        goto L8
    L10:
        double[] r8 = new double[r7.length];
    L12:
        if (r5 >= r7.length) goto L14;
        r8[r5] = r7[r5].getValue();
        r5 = r5 + 1;
        goto L12
    L14:
        r0.value = MathArrays.linearCombination(r2, r8);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object log() {
        return m3109log();
    }

    /* JADX INFO: renamed from: log, reason: collision with other method in class */
    public SparseGradient m3109log() {
        return new SparseGradient(FastMath.log(this.value), 1.0d / this.value, this.derivatives);
    }

    public SparseGradient log10() {
        return new SparseGradient(FastMath.log10(this.value), 1.0d / (FastMath.log(10.0d) * this.value), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object log1p() {
        return m3110log1p();
    }

    /* JADX INFO: renamed from: log1p, reason: collision with other method in class */
    public SparseGradient m3110log1p() {
        return new SparseGradient(FastMath.log1p(this.value), 1.0d / (this.value + 1.0d), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient multiply(double r1) {
        return multiply2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object multiply(int r1) {
        return multiply(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object multiply(Object r3) {
        return multiply((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: multiply, reason: avoid collision after fix types in other method */
    public SparseGradient multiply2(double r8) {
        return new SparseGradient(this.value * r8, r8, this.derivatives);
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient multiply(int r8) {
        double r3 = r8;
        return new SparseGradient(this.value * r3, r3, this.derivatives);
    }

    public SparseGradient multiply(SparseGradient r13) {
        SparseGradient r0 = new SparseGradient(this.value * r13.value, Collections.emptyMap());
        Iterator<Map.Entry<Integer, Double>> r1 = this.derivatives.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Map<Integer, Double> r4 = r0.derivatives;
        Object r5 = r2.getKey();
        Integer r6 = (Integer) r5;
        r4.put(r6, Double.valueOf(r13.value * ((Double) ZeusTransformUtils.preCheckCast(r2.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L4
    L6:
        Iterator<Map.Entry<Integer, Double>> r14 = r13.derivatives.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r7 = ((Integer) ZeusTransformUtils.preCheckCast(r3.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        Double r8 = (Double) ZeusTransformUtils.preCheckCast(r0.derivatives.get(Integer.valueOf(r7)), Double.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L11;
        r0.derivatives.put(Integer.valueOf(r7), Double.valueOf(r8.doubleValue() + (this.value * ((Double) ZeusTransformUtils.preCheckCast(r3.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue())));
        goto L8
    L11:
        r0.derivatives.put(Integer.valueOf(r7), Double.valueOf(this.value * ((Double) ZeusTransformUtils.preCheckCast(r3.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L8
    L13:
        return r0;
    }

    public void multiplyInPlace(SparseGradient r13) {
        Iterator<Map.Entry<Integer, Double>> r0 = this.derivatives.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        this.derivatives.put((Integer) r1.getKey(), Double.valueOf(r13.value * ((Double) ZeusTransformUtils.preCheckCast(r1.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L4
    L6:
        Iterator<Map.Entry<Integer, Double>> r2 = r13.derivatives.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r4 = ((Integer) ZeusTransformUtils.preCheckCast(r3.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        Double r5 = (Double) ZeusTransformUtils.preCheckCast(this.derivatives.get(Integer.valueOf(r4)), Double.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L11;
        this.derivatives.put(Integer.valueOf(r4), Double.valueOf(r5.doubleValue() + (this.value * ((Double) ZeusTransformUtils.preCheckCast(r3.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue())));
        goto L8
    L11:
        this.derivatives.put(Integer.valueOf(r4), Double.valueOf(this.value * ((Double) ZeusTransformUtils.preCheckCast(r3.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L8
    L13:
        this.value *= r13.value;
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* bridge */ /* synthetic */ Object negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.FieldElement
    public SparseGradient negate() {
        return new SparseGradient(-this.value, -1.0d, this.derivatives);
    }

    public int numVars() {
        return this.derivatives.size();
    }

    public /* bridge */ /* synthetic */ Object pow(double r1) {
        return m3111pow(r1);
    }

    public /* bridge */ /* synthetic */ Object pow(int r1) {
        return m3112pow(r1);
    }

    public /* synthetic */ Object pow(Object r3) {
        return pow((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: pow, reason: collision with other method in class */
    public SparseGradient m3111pow(double r10) {
        return new SparseGradient(FastMath.pow(this.value, r10), FastMath.pow(this.value, r10 - 1.0d) * r10, this.derivatives);
    }

    /* JADX INFO: renamed from: pow, reason: collision with other method in class */
    public SparseGradient m3112pow(int r10) {
        if (r10 == 0) goto L4;
        double r0 = FastMath.pow(this.value, r10 - 1);
        return new SparseGradient(this.value * r0, ((double) r10) * r0, this.derivatives);
    L4:
        return (SparseGradient) ZeusTransformUtils.preCheckCast(getField().getOne(), SparseGradient.class, "com.obric.memorydata.plugin");
    }

    public SparseGradient pow(SparseGradient r1) {
        return m3109log().multiply(r1).m3106exp();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient reciprocal() {
        return reciprocal2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: reciprocal, reason: avoid collision after fix types in other method */
    public SparseGradient reciprocal2() {
        double r0 = this.value;
        return new SparseGradient(1.0d / r0, (-1.0d) / (r0 * r0), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object remainder(double r1) {
        return m3113remainder(r1);
    }

    public /* synthetic */ Object remainder(Object r3) {
        return remainder((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: remainder, reason: collision with other method in class */
    public SparseGradient m3113remainder(double r4) {
        return new SparseGradient(FastMath.IEEEremainder(this.value, r4), this.derivatives);
    }

    public SparseGradient remainder(SparseGradient r5) {
        double r0 = FastMath.IEEEremainder(this.value, r5.value);
        return subtract(r5.multiply2(FastMath.rint((this.value - r0) / r5.value)));
    }

    public /* bridge */ /* synthetic */ Object rint() {
        return m3114rint();
    }

    /* JADX INFO: renamed from: rint, reason: collision with other method in class */
    public SparseGradient m3114rint() {
        return createConstant(FastMath.rint(this.value));
    }

    public /* bridge */ /* synthetic */ Object rootN(int r1) {
        return m3115rootN(r1);
    }

    /* JADX INFO: renamed from: rootN, reason: collision with other method in class */
    public SparseGradient m3115rootN(int r15) {
        if (r15 != 2) goto L7;
        return sqrt2();
    L7:
        if (r15 == 3) goto L9;
        double r2 = r15;
        double r9 = FastMath.pow(this.value, 1.0d / r2);
        return new SparseGradient(r9, 1.0d / (r2 * FastMath.pow(r9, r15 - 1)), this.derivatives);
    L9:
        return m3101cbrt();
    }

    public long round() {
        return FastMath.round(this.value);
    }

    public /* bridge */ /* synthetic */ Object scalb(int r1) {
        return m3116scalb(r1);
    }

    /* JADX INFO: renamed from: scalb, reason: collision with other method in class */
    public SparseGradient m3116scalb(int r8) {
        SparseGradient r0 = new SparseGradient(FastMath.scalb(this.value, r8), Collections.emptyMap());
        Iterator<Map.Entry<Integer, Double>> r7 = this.derivatives.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Map<Integer, Double> r2 = r0.derivatives;
        Object r4 = r1.getKey();
        Integer r5 = (Integer) r4;
        r2.put(r5, Double.valueOf(FastMath.scalb(((Double) ZeusTransformUtils.preCheckCast(r1.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue(), r8)));
        goto L4
    L6:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object signum() {
        return m3117signum();
    }

    /* JADX INFO: renamed from: signum, reason: collision with other method in class */
    public SparseGradient m3117signum() {
        return createConstant(FastMath.signum(this.value));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient sin() {
        return sin2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sin, reason: avoid collision after fix types in other method */
    public SparseGradient sin2() {
        return new SparseGradient(FastMath.sin(this.value), FastMath.cos(this.value), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object sinh() {
        return m3118sinh();
    }

    /* JADX INFO: renamed from: sinh, reason: collision with other method in class */
    public SparseGradient m3118sinh() {
        return new SparseGradient(FastMath.sinh(this.value), FastMath.cosh(this.value), this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient sqrt() {
        return sqrt2();
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: sqrt, reason: avoid collision after fix types in other method */
    public SparseGradient sqrt2() {
        double r3 = FastMath.sqrt(this.value);
        return new SparseGradient(r3, 0.5d / r3, this.derivatives);
    }

    @Override // org.apache.commons.math3.RealFieldElement
    public /* bridge */ /* synthetic */ SparseGradient subtract(double r1) {
        return subtract2(r1);
    }

    @Override // org.apache.commons.math3.FieldElement
    public /* synthetic */ Object subtract(Object r3) {
        return subtract((SparseGradient) ZeusTransformUtils.preCheckCast(r3, SparseGradient.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.RealFieldElement
    /* JADX INFO: renamed from: subtract, reason: avoid collision after fix types in other method */
    public SparseGradient subtract2(double r4) {
        return new SparseGradient(this.value - r4, this.derivatives);
    }

    public SparseGradient subtract(SparseGradient r8) {
        SparseGradient r0 = new SparseGradient(this.value - r8.value, this.derivatives);
        Iterator<Map.Entry<Integer, Double>> r7 = r8.derivatives.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r9 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r9.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        Double r3 = (Double) ZeusTransformUtils.preCheckCast(r0.derivatives.get(Integer.valueOf(r1)), Double.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L7;
        r0.derivatives.put(Integer.valueOf(r1), Double.valueOf(r3.doubleValue() - ((Double) ZeusTransformUtils.preCheckCast(r9.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L4
    L7:
        r0.derivatives.put(Integer.valueOf(r1), Double.valueOf(-((Double) ZeusTransformUtils.preCheckCast(r9.getValue(), Double.class, "com.obric.memorydata.plugin")).doubleValue()));
        goto L4
    L9:
        return r0;
    }

    public /* bridge */ /* synthetic */ Object tan() {
        return m3119tan();
    }

    /* JADX INFO: renamed from: tan, reason: collision with other method in class */
    public SparseGradient m3119tan() {
        double r3 = FastMath.tan(this.value);
        return new SparseGradient(r3, 1.0d + (r3 * r3), this.derivatives);
    }

    public /* bridge */ /* synthetic */ Object tanh() {
        return m3120tanh();
    }

    /* JADX INFO: renamed from: tanh, reason: collision with other method in class */
    public SparseGradient m3120tanh() {
        double r3 = FastMath.tanh(this.value);
        return new SparseGradient(r3, 1.0d - (r3 * r3), this.derivatives);
    }

    public double taylor(double... r8) {
        double r0 = this.value;
        int r2 = 0;
    L4:
        if (r2 >= r8.length) goto L6;
        r0 = r0 + (r8[r2] * getDerivative(r2));
        r2 = r2 + 1;
        goto L4
    L6:
        return r0;
    }

    public SparseGradient toDegrees() {
        return new SparseGradient(FastMath.toDegrees(this.value), FastMath.toDegrees(1.0d), this.derivatives);
    }

    public SparseGradient toRadians() {
        return new SparseGradient(FastMath.toRadians(this.value), FastMath.toRadians(1.0d), this.derivatives);
    }
}
