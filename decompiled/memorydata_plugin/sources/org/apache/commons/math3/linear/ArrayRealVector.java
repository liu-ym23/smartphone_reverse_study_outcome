package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ArrayRealVector extends RealVector implements Serializable {
    private static final RealVectorFormat DEFAULT_FORMAT = null;
    private static final long serialVersionUID = -1097961340710804027L;
    private double[] data;

    static {
        DEFAULT_FORMAT = RealVectorFormat.getInstance();
    }

    public ArrayRealVector() {
        this.data = new double[0];
    }

    public ArrayRealVector(int r1) {
        this.data = new double[r1];
    }

    public ArrayRealVector(int r1, double r2) {
        double[] r3 = new double[r1];
        this.data = r3;
        Arrays.fill(r3, r2);
    }

    public ArrayRealVector(ArrayRealVector r2) {
        this(r2, true);
    }

    public ArrayRealVector(ArrayRealVector r5, ArrayRealVector r6) {
        double[] r0 = new double[r5.data.length + r6.data.length];
        this.data = r0;
        double[] r1 = r5.data;
        System.arraycopy(r1, 0, r0, 0, r1.length);
        double[] r7 = r6.data;
        System.arraycopy(r7, 0, this.data, r5.data.length, r7.length);
    }

    public ArrayRealVector(ArrayRealVector r7, RealVector r8) {
        int r0 = r7.data.length;
        int r1 = r8.getDimension();
        double[] r2 = new double[r0 + r1];
        this.data = r2;
        int r3 = 0;
        System.arraycopy(r7.data, 0, r2, 0, r0);
    L3:
        if (r3 >= r1) goto L5;
        this.data[r0 + r3] = r8.getEntry(r3);
        r3 = r3 + 1;
        goto L3
    }

    public ArrayRealVector(ArrayRealVector r2, boolean r3) {
        double[] r4 = r2.data;
        if (r3 == false) goto L5;
        r4 = (double[]) ZeusTransformUtils.preCheckCast(r4.clone(), double[].class, "com.obric.memorydata.plugin");
    L5:
        this.data = r4;
    }

    public ArrayRealVector(ArrayRealVector r5, double[] r6) {
        int r0 = r5.getDimension();
        int r1 = r6.length;
        double[] r2 = new double[r0 + r1];
        this.data = r2;
        System.arraycopy(r5.data, 0, r2, 0, r0);
        System.arraycopy(r6, 0, this.data, r0, r1);
    }

    public ArrayRealVector(RealVector r5) {
        if (r5 == null) goto L10;
        this.data = new double[r5.getDimension()];
        int r0 = 0;
    L5:
        double[] r1 = this.data;
        if (r0 >= r1.length) goto L8;
        r1[r0] = r5.getEntry(r0);
        r0 = r0 + 1;
        goto L5
    L8:
        return;
    L10:
        throw new NullArgumentException();
    }

    public ArrayRealVector(RealVector r8, ArrayRealVector r9) {
        int r0 = r8.getDimension();
        int r1 = r9.data.length;
        this.data = new double[r0 + r1];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        this.data[r3] = r8.getEntry(r3);
        r3 = r3 + 1;
        goto L3
    L5:
        System.arraycopy(r9.data, 0, this.data, r0, r1);
    }

    public ArrayRealVector(double[] r3) {
        this.data = (double[]) ZeusTransformUtils.preCheckCast(r3.clone(), double[].class, "com.obric.memorydata.plugin");
    }

    public ArrayRealVector(double[] r3, int r4, int r5) {
        if (r3 == null) goto L11;
        int r1 = r4 + r5;
        if (r3.length < r1) goto L9;
        double[] r0 = new double[r5];
        this.data = r0;
        System.arraycopy(r3, r4, r0, 0, r5);
        return;
    L9:
        throw new NumberIsTooLargeException(Integer.valueOf(r1), Integer.valueOf(r3.length), true);
    L11:
        throw new NullArgumentException();
    }

    public ArrayRealVector(double[] r5, ArrayRealVector r6) {
        int r0 = r5.length;
        int r1 = r6.getDimension();
        double[] r2 = new double[r0 + r1];
        this.data = r2;
        System.arraycopy(r5, 0, r2, 0, r0);
        System.arraycopy(r6.data, 0, this.data, r0, r1);
    }

    public ArrayRealVector(double[] r2, boolean r3) {
        if (r2 == null) goto L9;
        if (r3 == false) goto L6;
        r2 = (double[]) ZeusTransformUtils.preCheckCast(r2.clone(), double[].class, "com.obric.memorydata.plugin");
    L6:
        this.data = r2;
        return;
    L9:
        throw new NullArgumentException();
    }

    public ArrayRealVector(double[] r5, double[] r6) {
        int r0 = r5.length;
        int r1 = r6.length;
        double[] r2 = new double[r0 + r1];
        this.data = r2;
        System.arraycopy(r5, 0, r2, 0, r0);
        System.arraycopy(r6, 0, this.data, r0, r1);
    }

    public ArrayRealVector(Double[] r5) {
        this.data = new double[r5.length];
        int r0 = 0;
    L4:
        if (r0 >= r5.length) goto L6;
        this.data[r0] = r5[r0].doubleValue();
        r0 = r0 + 1;
        goto L4
    }

    public ArrayRealVector(Double[] r6, int r7, int r8) {
        if (r6 == null) goto L13;
        int r1 = r7 + r8;
        if (r6.length < r1) goto L11;
        this.data = new double[r8];
        int r9 = r7;
    L7:
        if (r9 >= r1) goto L9;
        this.data[r9 - r7] = r6[r9].doubleValue();
        r9 = r9 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new NumberIsTooLargeException(Integer.valueOf(r1), Integer.valueOf(r6.length), true);
    L13:
        throw new NullArgumentException();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector add(RealVector r9) {
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r9, ArrayRealVector.class) == false) goto L8;
        double[] r10 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r9, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        int r0 = r10.length;
        checkVectorDimensions(r0);
        ArrayRealVector r1 = new ArrayRealVector(r0);
        double[] r3 = r1.data;
    L5:
        if (r2 >= r0) goto L7;
        r3[r2] = this.data[r2] + r10[r2];
        r2 = r2 + 1;
        goto L5
    L7:
        return r1;
    L8:
        checkVectorDimensions(r9);
        double[] r8 = (double[]) ZeusTransformUtils.preCheckCast(this.data.clone(), double[].class, "com.obric.memorydata.plugin");
        Iterator<RealVector.Entry> r11 = r9.iterator();
    L10:
        if (r11.hasNext() == false) goto L13;
        RealVector.Entry r4 = (RealVector.Entry) ZeusTransformUtils.preCheckCast(r11.next(), RealVector.Entry.class, "com.obric.memorydata.plugin");
        int r5 = r4.getIndex();
        r8[r5] = r8[r5] + r4.getValue();
        goto L10
    L13:
        return new ArrayRealVector(r8, false);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector add(RealVector r1) {
        return add(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void addToEntry(int r4, double r5) {
        double[] r0 = this.data;     // Catch: IndexOutOfBoundsException -> L4
        r0[r4] = r0[r4] + r5;     // Catch: IndexOutOfBoundsException -> L4
        return;
    L5:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r4), 0, Integer.valueOf(this.data.length - 1));
    }

    public ArrayRealVector append(ArrayRealVector r2) {
        return new ArrayRealVector(this, r2);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector append(double r5) {
        double[] r0 = this.data;
        double[] r1 = new double[r0.length + 1];
        System.arraycopy(r0, 0, r1, 0, r0.length);
        r1[this.data.length] = r5;
        return new ArrayRealVector(r1, false);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector append(RealVector r4) {
        return new ArrayRealVector(this, (ArrayRealVector) ZeusTransformUtils.preCheckCast(r4, ArrayRealVector.class, "com.obric.memorydata.plugin"));
    L5:
        return new ArrayRealVector(this, r4);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void checkVectorDimensions(int r2) {
        if (this.data.length != r2) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(this.data.length, r2);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void checkVectorDimensions(RealVector r1) {
        checkVectorDimensions(r1.getDimension());
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector combine(double r7, double r9, RealVector r11) {
        return copy().combineToSelf(r7, r9, r11);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector combine(double r1, double r3, RealVector r5) {
        return combine(r1, r3, r5);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector combineToSelf(double r8, double r10, RealVector r12) {
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r12, ArrayRealVector.class) == false) goto L8;
        double[] r13 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r12, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        checkVectorDimensions(r13.length);
    L5:
        double[] r0 = this.data;
        if (r2 >= r0.length) goto L12;
        r0[r2] = (r0[r2] * r8) + (r13[r2] * r10);
        r2 = r2 + 1;
    L12:
        return this;
    L8:
        checkVectorDimensions(r12);
    L9:
        double[] r1 = this.data;
        if (r2 >= r1.length) goto L12;
        r1[r2] = (r1[r2] * r8) + (r12.getEntry(r2) * r10);
        r2 = r2 + 1;
        goto L9
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector combineToSelf(double r1, double r3, RealVector r5) {
        return combineToSelf(r1, r3, r5);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector copy() {
        return new ArrayRealVector(this, true);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double dotProduct(RealVector r8) {
        if (ZeusTransformUtils.instanceOf(r8, ArrayRealVector.class) == false) goto L10;
        double[] r9 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r8, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        checkVectorDimensions(r9.length);
        double r0 = 0.0d;
        int r2 = 0;
    L5:
        double[] r3 = this.data;
        if (r2 >= r3.length) goto L8;
        r0 = r0 + (r3[r2] * r9[r2]);
        r2 = r2 + 1;
        goto L5
    L8:
        return r0;
    L10:
        return super.dotProduct(r8);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector ebeDivide(RealVector r9) {
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r9, ArrayRealVector.class) == false) goto L8;
        double[] r10 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r9, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        int r0 = r10.length;
        checkVectorDimensions(r0);
        ArrayRealVector r1 = new ArrayRealVector(r0);
        double[] r2 = r1.data;
    L5:
        if (r3 >= r0) goto L7;
        r2[r3] = this.data[r3] / r10[r3];
        r3 = r3 + 1;
        goto L5
    L7:
        return r1;
    L8:
        checkVectorDimensions(r9);
        double[] r4 = (double[]) ZeusTransformUtils.preCheckCast(this.data.clone(), double[].class, "com.obric.memorydata.plugin");
        int r5 = 0;
    L10:
        if (r5 >= this.data.length) goto L13;
        r4[r5] = r4[r5] / r9.getEntry(r5);
        r5 = r5 + 1;
        goto L10
    L13:
        return new ArrayRealVector(r4, false);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector ebeDivide(RealVector r1) {
        return ebeDivide(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector ebeMultiply(RealVector r9) {
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r9, ArrayRealVector.class) == false) goto L8;
        double[] r10 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r9, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        int r0 = r10.length;
        checkVectorDimensions(r0);
        ArrayRealVector r1 = new ArrayRealVector(r0);
        double[] r2 = r1.data;
    L5:
        if (r3 >= r0) goto L7;
        r2[r3] = this.data[r3] * r10[r3];
        r3 = r3 + 1;
        goto L5
    L7:
        return r1;
    L8:
        checkVectorDimensions(r9);
        double[] r4 = (double[]) ZeusTransformUtils.preCheckCast(this.data.clone(), double[].class, "com.obric.memorydata.plugin");
        int r5 = 0;
    L10:
        if (r5 >= this.data.length) goto L13;
        r4[r5] = r4[r5] * r9.getEntry(r5);
        r5 = r5 + 1;
        goto L10
    L13:
        return new ArrayRealVector(r4, false);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector ebeMultiply(RealVector r1) {
        return ebeMultiply(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r8, RealVector.class) == true) goto L8;
        return false;
    L8:
        RealVector r9 = (RealVector) ZeusTransformUtils.preCheckCast(r8, RealVector.class, "com.obric.memorydata.plugin");
        if (this.data.length == r9.getDimension()) goto L12;
        return false;
    L12:
        if (r9.isNaN() == true) goto L14;
        int r1 = 0;
    L16:
        double[] r3 = this.data;
        if (r1 >= r3.length) goto L22;
        if (r3[r1] != r9.getEntry(r1)) goto L20;
        r1 = r1 + 1;
        goto L16
    L20:
        return false;
    L22:
        return true;
    L14:
        return isNaN();
    }

    public double[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int getDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getDistance(RealVector r8) {
        int r2 = 0;
        double r3 = 0.0d;
        if (ZeusTransformUtils.instanceOf(r8, ArrayRealVector.class) == false) goto L10;
        double[] r9 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r8, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        checkVectorDimensions(r9.length);
    L5:
        double[] r0 = this.data;
        if (r2 >= r0.length) goto L9;
        double r1 = r0[r2] - r9[r2];
        r3 = r3 + (r1 * r1);
        r2 = r2 + 1;
        goto L5
    L9:
        return FastMath.sqrt(r3);
    L10:
        checkVectorDimensions(r8);
    L11:
        double[] r4 = this.data;
        if (r2 >= r4.length) goto L15;
        double r5 = r4[r2] - r8.getEntry(r2);
        r3 = r3 + (r5 * r5);
        r2 = r2 + 1;
        goto L11
    L15:
        return FastMath.sqrt(r3);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getEntry(int r4) {
        return this.data[r4];
    L5:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getDimension() - 1));
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getL1Distance(RealVector r8) {
        int r2 = 0;
        double r3 = 0.0d;
        if (ZeusTransformUtils.instanceOf(r8, ArrayRealVector.class) == false) goto L9;
        double[] r9 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r8, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        checkVectorDimensions(r9.length);
    L5:
        double[] r0 = this.data;
        if (r2 >= r0.length) goto L8;
        r3 = r3 + FastMath.abs(r0[r2] - r9[r2]);
        r2 = r2 + 1;
        goto L5
    L8:
        return r3;
    L9:
        checkVectorDimensions(r8);
    L10:
        double[] r1 = this.data;
        if (r2 >= r1.length) goto L13;
        r3 = r3 + FastMath.abs(r1[r2] - r8.getEntry(r2));
        r2 = r2 + 1;
        goto L10
    L13:
        return r3;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getL1Norm() {
        double[] r6 = this.data;
        int r0 = r6.length;
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + FastMath.abs(r6[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getLInfDistance(RealVector r8) {
        int r2 = 0;
        double r3 = 0.0d;
        if (ZeusTransformUtils.instanceOf(r8, ArrayRealVector.class) == false) goto L9;
        double[] r9 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r8, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        checkVectorDimensions(r9.length);
    L5:
        double[] r0 = this.data;
        if (r2 >= r0.length) goto L8;
        r3 = FastMath.max(r3, FastMath.abs(r0[r2] - r9[r2]));
        r2 = r2 + 1;
        goto L5
    L8:
        return r3;
    L9:
        checkVectorDimensions(r8);
    L10:
        double[] r1 = this.data;
        if (r2 >= r1.length) goto L13;
        r3 = FastMath.max(r3, FastMath.abs(r1[r2] - r8.getEntry(r2)));
        r2 = r2 + 1;
        goto L10
    L13:
        return r3;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getLInfNorm() {
        double[] r6 = this.data;
        int r0 = r6.length;
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = FastMath.max(r1, FastMath.abs(r6[r3]));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double getNorm() {
        double[] r6 = this.data;
        int r0 = r6.length;
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        double r4 = r6[r3];
        r1 = r1 + (r4 * r4);
        r3 = r3 + 1;
        goto L3
    L6:
        return FastMath.sqrt(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector getSubVector(int r5, int r6) {
        if (r6 < 0) goto L9;
        ArrayRealVector r0 = new ArrayRealVector(r6);
        System.arraycopy(this.data, r5, r0.data, 0, r6);     // Catch: IndexOutOfBoundsException -> L6
    L7:
        return r0;
    L6:
        checkIndex(r5);
        checkIndex((r5 + r6) - 1);
        goto L7
    L9:
        throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, Integer.valueOf(r6));
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 9;
    L7:
        return MathUtils.hash(this.data);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isInfinite() {
        if (isNaN() == false) goto L5;
        return false;
    L5:
        double[] r5 = this.data;
        int r0 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L12;
        if (Double.isInfinite(r5[r2]) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public boolean isNaN() {
        double[] r5 = this.data;
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (Double.isNaN(r5[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector map(UnivariateFunction r3) {
        UnivariateFunction r4 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateFunction.class, "com.obric.memorydata.plugin");
        return copy().mapToSelf(r4);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* synthetic */ RealVector map(UnivariateFunction r3) {
        return map((UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateFunction.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector mapAddToSelf(double r5) {
        int r0 = 0;
    L3:
        double[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r1[r0] + r5;
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector mapDivideToSelf(double r5) {
        int r0 = 0;
    L3:
        double[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r1[r0] / r5;
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector mapMultiplyToSelf(double r5) {
        int r0 = 0;
    L3:
        double[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r1[r0] * r5;
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealVector mapSubtractToSelf(double r5) {
        int r0 = 0;
    L3:
        double[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r1[r0] - r5;
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector mapToSelf(UnivariateFunction r5) {
        UnivariateFunction r6 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r5, UnivariateFunction.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        double[] r1 = this.data;
        if (r0 >= r1.length) goto L6;
        r1[r0] = r6.value(r1[r0]);
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* synthetic */ RealVector mapToSelf(UnivariateFunction r3) {
        return mapToSelf((UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateFunction.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public RealMatrix outerProduct(RealVector r11) {
        if (ZeusTransformUtils.instanceOf(r11, ArrayRealVector.class) == false) goto L11;
        double[] r12 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r11, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        int r0 = this.data.length;
        int r1 = r12.length;
        RealMatrix r3 = MatrixUtils.createRealMatrix(r0, r1);
        int r4 = 0;
    L5:
        if (r4 >= r0) goto L10;
        int r5 = 0;
    L7:
        if (r5 >= r1) goto L9;
        r3.setEntry(r4, r5, this.data[r4] * r12[r5]);
        r5 = r5 + 1;
        goto L7
    L9:
        r4 = r4 + 1;
        goto L5
    L10:
        return r3;
    L11:
        int r2 = this.data.length;
        int r6 = r11.getDimension();
        RealMatrix r7 = MatrixUtils.createRealMatrix(r2, r6);
        int r8 = 0;
    L12:
        if (r8 >= r2) goto L17;
        int r9 = 0;
    L14:
        if (r9 >= r6) goto L16;
        r7.setEntry(r8, r9, this.data[r8] * r11.getEntry(r9));
        r9 = r9 + 1;
        goto L14
    L16:
        r8 = r8 + 1;
        goto L12
    L17:
        return r7;
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void set(double r1) {
        Arrays.fill(this.data, r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void setEntry(int r2, double r3) {
        this.data[r2] = r3;     // Catch: IndexOutOfBoundsException -> L4
        return;
    L4:
        checkIndex(r2);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public void setSubVector(int r5, RealVector r6) {
        if (ZeusTransformUtils.instanceOf(r6, ArrayRealVector.class) == false) goto L5;
        setSubVector(r5, ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r6, ArrayRealVector.class, "com.obric.memorydata.plugin")).data);
        return;
    L5:
        int r0 = r5;
    L12:
    L10:
        checkIndex(r5);
        checkIndex((r5 + r6.getDimension()) - 1);
        return;
    L7:
        if (r0 >= (r6.getDimension() + r5)) goto L16;
        this.data[r0] = r6.getEntry(r0 - r5);     // Catch: IndexOutOfBoundsException -> L10
        r0 = r0 + 1;
        goto L12
    }

    public void setSubVector(int r4, double[] r5) {
        System.arraycopy(r5, 0, this.data, r4, r5.length);     // Catch: IndexOutOfBoundsException -> L5
        return;
    L5:
        checkIndex(r4);
        checkIndex((r4 + r5.length) - 1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public ArrayRealVector subtract(RealVector r9) {
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r9, ArrayRealVector.class) == false) goto L8;
        double[] r10 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r9, ArrayRealVector.class, "com.obric.memorydata.plugin")).data;
        int r0 = r10.length;
        checkVectorDimensions(r0);
        ArrayRealVector r1 = new ArrayRealVector(r0);
        double[] r3 = r1.data;
    L5:
        if (r2 >= r0) goto L7;
        r3[r2] = this.data[r2] - r10[r2];
        r2 = r2 + 1;
        goto L5
    L7:
        return r1;
    L8:
        checkVectorDimensions(r9);
        double[] r8 = (double[]) ZeusTransformUtils.preCheckCast(this.data.clone(), double[].class, "com.obric.memorydata.plugin");
        Iterator<RealVector.Entry> r11 = r9.iterator();
    L10:
        if (r11.hasNext() == false) goto L13;
        RealVector.Entry r4 = (RealVector.Entry) ZeusTransformUtils.preCheckCast(r11.next(), RealVector.Entry.class, "com.obric.memorydata.plugin");
        int r5 = r4.getIndex();
        r8[r5] = r8[r5] - r4.getValue();
        goto L10
    L13:
        return new ArrayRealVector(r8, false);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public /* bridge */ /* synthetic */ RealVector subtract(RealVector r1) {
        return subtract(r1);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double[] toArray() {
        return (double[]) ZeusTransformUtils.preCheckCast(this.data.clone(), double[].class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        return DEFAULT_FORMAT.format(this);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInDefaultOrder(RealVectorChangingVisitor r6) {
        RealVectorChangingVisitor r7 = (RealVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r6, RealVectorChangingVisitor.class, "com.obric.memorydata.plugin");
        double[] r0 = this.data;
        int r2 = 0;
        r7.start(r0.length, 0, r0.length - 1);
    L3:
        double[] r1 = this.data;
        if (r2 >= r1.length) goto L7;
        r1[r2] = r7.visit(r2, r1[r2]);
        r2 = r2 + 1;
        goto L3
    L7:
        return r7.end();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInDefaultOrder(RealVectorChangingVisitor r4, int r5, int r6) {
        RealVectorChangingVisitor r7 = (RealVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r4, RealVectorChangingVisitor.class, "com.obric.memorydata.plugin");
        checkIndices(r5, r6);
        r7.start(this.data.length, r5, r6);
    L3:
        if (r5 > r6) goto L6;
        double[] r0 = this.data;
        r0[r5] = r7.visit(r5, r0[r5]);
        r5 = r5 + 1;
        goto L3
    L6:
        return r7.end();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInDefaultOrder(RealVectorPreservingVisitor r4) {
        RealVectorPreservingVisitor r5 = (RealVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r4, RealVectorPreservingVisitor.class, "com.obric.memorydata.plugin");
        double[] r0 = this.data;
        int r2 = 0;
        r5.start(r0.length, 0, r0.length - 1);
    L3:
        double[] r1 = this.data;
        if (r2 >= r1.length) goto L7;
        r5.visit(r2, r1[r2]);
        r2 = r2 + 1;
        goto L3
    L7:
        return r5.end();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInDefaultOrder(RealVectorPreservingVisitor r3, int r4, int r5) {
        RealVectorPreservingVisitor r6 = (RealVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorPreservingVisitor.class, "com.obric.memorydata.plugin");
        checkIndices(r4, r5);
        r6.start(this.data.length, r4, r5);
    L3:
        if (r4 > r5) goto L6;
        r6.visit(r4, this.data[r4]);
        r4 = r4 + 1;
        goto L3
    L6:
        return r6.end();
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInOptimizedOrder(RealVectorChangingVisitor r3) {
        return walkInDefaultOrder((RealVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorChangingVisitor.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInOptimizedOrder(RealVectorChangingVisitor r3, int r4, int r5) {
        return walkInDefaultOrder((RealVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorChangingVisitor.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInOptimizedOrder(RealVectorPreservingVisitor r3) {
        return walkInDefaultOrder((RealVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorPreservingVisitor.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.linear.RealVector
    public double walkInOptimizedOrder(RealVectorPreservingVisitor r3, int r4, int r5) {
        return walkInDefaultOrder((RealVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorPreservingVisitor.class, "com.obric.memorydata.plugin"), r4, r5);
    }
}
