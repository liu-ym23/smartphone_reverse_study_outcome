package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

/* JADX INFO: loaded from: classes6.dex */
public class DiagonalMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = 20121229;
    private final double[] data;

    public DiagonalMatrix(int r1) {
        super(r1, r1);
        this.data = new double[r1];
    }

    public DiagonalMatrix(double[] r2) {
        this(r2, true);
    }

    public DiagonalMatrix(double[] r2, boolean r3) {
        MathUtils.checkNotNull(r2);
        if (r3 == false) goto L5;
        r2 = (double[]) ZeusTransformUtils.preCheckCast(r2.clone(), double[].class, "com.obric.memorydata.plugin");
    L5:
        this.data = r2;
    }

    private void ensureZero(double r3) {
        if (Precision.equals(0.0d, r3, 1) == false) goto L6;
        return;
    L6:
        throw new NumberIsTooLargeException(Double.valueOf(FastMath.abs(r3)), 0, true);
    }

    public DiagonalMatrix add(DiagonalMatrix r9) {
        MatrixUtils.checkAdditionCompatible(this, r9);
        int r0 = getRowDimension();
        double[] r1 = new double[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1[r3] = this.data[r3] + r9.data[r3];
        r3 = r3 + 1;
        goto L3
    L6:
        return new DiagonalMatrix(r1, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public void addToEntry(int r3, int r4, double r5) {
        if (r3 != r4) goto L4;
        MatrixUtils.checkRowIndex(this, r3);
        double[] r2 = this.data;
        r2[r3] = r2[r3] + r5;
        return;
    L4:
        ensureZero(r5);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public RealMatrix copy() {
        return new DiagonalMatrix(this.data);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public RealMatrix createMatrix(int r1, int r2) {
        if (r1 != r2) goto L6;
        return new DiagonalMatrix(r1);
    L6:
        throw new DimensionMismatchException(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        int r0 = getRowDimension();
        int r2 = 0;
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{r0, r0});
    L3:
        if (r2 >= r0) goto L5;
        r1[r2][r2] = this.data[r2];
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public double[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int r1, int r2) {
        MatrixUtils.checkMatrixIndex(this, r1, r2);
        if (r1 == r2) goto L7;
        return 0.0d;
    L7:
        return this.data[r1];
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.data.length;
    }

    public DiagonalMatrix inverse() {
        return inverse(0.0d);
    }

    public DiagonalMatrix inverse(double r7) {
        if (isSingular(r7) == true) goto L11;
        double[] r8 = new double[this.data.length];
        int r0 = 0;
    L5:
        double[] r1 = this.data;
        if (r0 >= r1.length) goto L9;
        r8[r0] = 1.0d / r1[r0];
        r0 = r0 + 1;
        goto L5
    L9:
        return new DiagonalMatrix(r8, false);
    L11:
        throw new SingularMatrixException();
    }

    public boolean isSingular(double r11) {
        int r1 = 0;
    L3:
        double[] r2 = this.data;
        if (r1 >= r2.length) goto L10;
        if (Precision.equals(r2[r1], 0.0d, r11) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    public DiagonalMatrix multiply(DiagonalMatrix r9) {
        MatrixUtils.checkMultiplicationCompatible(this, r9);
        int r0 = getRowDimension();
        double[] r1 = new double[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1[r3] = this.data[r3] * r9.data[r3];
        r3 = r3 + 1;
        goto L3
    L6:
        return new DiagonalMatrix(r1, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix r12) {
        RealMatrix r13 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r12, RealMatrix.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r13, DiagonalMatrix.class) == true) goto L5;
        MatrixUtils.checkMultiplicationCompatible(this, r13);
        int r0 = r13.getRowDimension();
        int r1 = r13.getColumnDimension();
        double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r0, r1});
        int r4 = 0;
    L7:
        if (r4 >= r0) goto L13;
        int r5 = 0;
    L9:
        if (r5 >= r1) goto L11;
        r2[r4][r5] = this.data[r4] * r13.getEntry(r4, r5);
        r5 = r5 + 1;
        goto L9
    L11:
        r4 = r4 + 1;
        goto L7
    L13:
        return new Array2DRowRealMatrix(r2, false);
    L5:
        return multiply((DiagonalMatrix) ZeusTransformUtils.preCheckCast(r13, DiagonalMatrix.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public void multiplyEntry(int r3, int r4, double r5) {
        if (r3 != r4) goto L5;
        MatrixUtils.checkRowIndex(this, r3);
        double[] r2 = this.data;
        r2[r3] = r2[r3] * r5;
        return;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double[] operate(double[] r3) {
        return multiply(new DiagonalMatrix(r3, false)).getDataRef();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public RealVector preMultiply(RealVector r3) {
        if (ZeusTransformUtils.instanceOf(r3, ArrayRealVector.class) == false) goto L5;
        double[] r4 = ((ArrayRealVector) ZeusTransformUtils.preCheckCast(r3, ArrayRealVector.class, "com.obric.memorydata.plugin")).getDataRef();
    L7:
        return MatrixUtils.createRealVector(preMultiply(r4));
    L5:
        r4 = r3.toArray();
        goto L7
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double[] preMultiply(double[] r1) {
        return operate(r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int r1, int r2, double r3) {
        if (r1 != r2) goto L4;
        MatrixUtils.checkRowIndex(this, r1);
        this.data[r1] = r3;
        return;
    L4:
        ensureZero(r3);
    }

    public DiagonalMatrix subtract(DiagonalMatrix r9) {
        MatrixUtils.checkSubtractionCompatible(this, r9);
        int r0 = getRowDimension();
        double[] r1 = new double[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1[r3] = this.data[r3] - r9.data[r3];
        r3 = r3 + 1;
        goto L3
    L6:
        return new DiagonalMatrix(r1, false);
    }
}
