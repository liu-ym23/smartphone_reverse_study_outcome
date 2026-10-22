package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Array2DRowRealMatrix extends AbstractRealMatrix implements Serializable {
    private static final long serialVersionUID = -1067294169172445528L;
    private double[][] data;

    public Array2DRowRealMatrix() {
    }

    public Array2DRowRealMatrix(int r3, int r4) {
        super(r3, r4);
        this.data = (double[][]) Array.newInstance(double.class, new int[]{r3, r4});
    }

    public Array2DRowRealMatrix(double[] r7) {
        int r0 = r7.length;
        this.data = (double[][]) Array.newInstance(double.class, new int[]{r0, 1});
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.data[r1][0] = r7[r1];
        r1 = r1 + 1;
        goto L3
    }

    public Array2DRowRealMatrix(double[][] r1) {
        copyIn(r1);
    }

    public Array2DRowRealMatrix(double[][] r4, boolean r5) {
        if (r5 == false) goto L5;
        copyIn(r4);
        return;
    L5:
        if (r4 == null) goto L24;
        int r6 = r4.length;
        if (r6 == 0) goto L22;
        int r0 = r4[0].length;
        if (r0 == 0) goto L20;
        int r1 = 1;
    L11:
        if (r1 >= r6) goto L17;
        if (r4[r1].length != r0) goto L16;
        r1 = r1 + 1;
        goto L11
    L16:
        throw new DimensionMismatchException(r4[r1].length, r0);
    L17:
        this.data = r4;
        return;
    L20:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L22:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    L24:
        throw new NullArgumentException();
    }

    private void copyIn(double[][] r2) {
        setSubMatrix(r2, 0, 0);
    }

    private double[][] copyOut() {
        int r0 = getRowDimension();
        double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r0, getColumnDimension()});
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        double[][] r4 = this.data;
        System.arraycopy(r4[r3], 0, r2[r3], 0, r4[r3].length);
        r3 = r3 + 1;
        goto L3
    L5:
        return r2;
    }

    public Array2DRowRealMatrix add(Array2DRowRealMatrix r14) {
        MatrixUtils.checkAdditionCompatible(this, r14);
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r0, r1});
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L9;
        double[] r5 = this.data[r4];
        double[] r6 = r14.data[r4];
        double[] r7 = r2[r4];
        int r8 = 0;
    L5:
        if (r8 >= r1) goto L7;
        r7[r8] = r5[r8] + r6[r8];
        r8 = r8 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        return new Array2DRowRealMatrix(r2, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public void addToEntry(int r3, int r4, double r5) {
        MatrixUtils.checkMatrixIndex(this, r3, r4);
        double[] r2 = this.data[r3];
        r2[r4] = r2[r4] + r5;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public RealMatrix copy() {
        return new Array2DRowRealMatrix(copyOut(), false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public RealMatrix createMatrix(int r1, int r2) {
        return new Array2DRowRealMatrix(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        double[][] r2 = this.data;
        if (r2 != null) goto L5;
        return 0;
    L5:
        if (r2[0] != null) goto L8;
        return 0;
    L8:
        return r2[0].length;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        return copyOut();
    }

    public double[][] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int r1, int r2) {
        MatrixUtils.checkMatrixIndex(this, r1, r2);
        return this.data[r1][r2];
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        double[][] r0 = this.data;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public Array2DRowRealMatrix multiply(Array2DRowRealMatrix r19) {
        MatrixUtils.checkMultiplicationCompatible(this, r19);
        int r0 = getRowDimension();
        int r1 = r19.getColumnDimension();
        int r2 = getColumnDimension();
        double[][] r3 = (double[][]) Array.newInstance(double.class, new int[]{r0, r1});
        double[] r5 = new double[r2];
        double[][] r6 = r19.data;
        int r7 = 0;
    L3:
        if (r7 >= r1) goto L16;
        int r8 = 0;
    L5:
        if (r8 >= r2) goto L7;
        r5[r8] = r6[r8][r7];
        r8 = r8 + 1;
        goto L5
    L7:
        int r9 = 0;
    L9:
        if (r9 >= r0) goto L14;
        double[] r10 = this.data[r9];
        double r11 = 0.0d;
        int r13 = 0;
    L11:
        if (r13 >= r2) goto L13;
        r11 = r11 + (r10[r13] * r5[r13]);
        r13 = r13 + 1;
        goto L11
    L13:
        r3[r9][r7] = r11;
        r9 = r9 + 1;
        goto L9
    L14:
        r7 = r7 + 1;
        goto L3
    L16:
        return new Array2DRowRealMatrix(r3, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public void multiplyEntry(int r3, int r4, double r5) {
        MatrixUtils.checkMatrixIndex(this, r3, r4);
        double[] r2 = this.data[r3];
        r2[r4] = r2[r4] * r5;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double[] operate(double[] r14) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r14.length != r1) goto L12;
        double[] r2 = new double[r0];
        int r4 = 0;
    L5:
        if (r4 >= r0) goto L10;
        double[] r5 = this.data[r4];
        double r6 = 0.0d;
        int r8 = 0;
    L7:
        if (r8 >= r1) goto L9;
        r6 = r6 + (r5[r8] * r14[r8]);
        r8 = r8 + 1;
        goto L7
    L9:
        r2[r4] = r6;
        r4 = r4 + 1;
        goto L5
    L10:
        return r2;
    L12:
        throw new DimensionMismatchException(r14.length, r1);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double[] preMultiply(double[] r13) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r13.length != r0) goto L12;
        double[] r2 = new double[r1];
        int r4 = 0;
    L5:
        if (r4 >= r1) goto L10;
        double r5 = 0.0d;
        int r7 = 0;
    L7:
        if (r7 >= r0) goto L9;
        r5 = r5 + (this.data[r7][r4] * r13[r7]);
        r7 = r7 + 1;
        goto L7
    L9:
        r2[r4] = r5;
        r4 = r4 + 1;
        goto L5
    L10:
        return r2;
    L12:
        throw new DimensionMismatchException(r13.length, r0);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int r1, int r2, double r3) {
        MatrixUtils.checkMatrixIndex(this, r1, r2);
        this.data[r1][r2] = r3;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public void setSubMatrix(double[][] r7, int r8, int r9) {
        if (this.data == null) goto L5;
        super.setSubMatrix(r7, r8, r9);
        return;
    L5:
        if (r8 > 0) goto L26;
        if (r9 > 0) goto L24;
        MathUtils.checkNotNull(r7);
        if (r7.length == 0) goto L22;
        int r2 = r7[0].length;
        if (r2 == 0) goto L20;
        this.data = (double[][]) Array.newInstance(double.class, new int[]{r7.length, r2});
        int r0 = 0;
    L12:
        double[][] r3 = this.data;
        if (r0 >= r3.length) goto L31;
        if (r7[r0].length != r2) goto L18;
        System.arraycopy(r7[r0], 0, r3[r0 + r8], r9, r2);
        r0 = r0 + 1;
        goto L12
    L18:
        throw new DimensionMismatchException(r7[r0].length, r2);
    L31:
        return;
    L20:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L22:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    L24:
        throw new MathIllegalStateException(LocalizedFormats.FIRST_COLUMNS_NOT_INITIALIZED_YET, new Object[]{Integer.valueOf(r9)});
    L26:
        throw new MathIllegalStateException(LocalizedFormats.FIRST_ROWS_NOT_INITIALIZED_YET, new Object[]{Integer.valueOf(r8)});
    }

    public Array2DRowRealMatrix subtract(Array2DRowRealMatrix r14) {
        MatrixUtils.checkSubtractionCompatible(this, r14);
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        double[][] r2 = (double[][]) Array.newInstance(double.class, new int[]{r0, r1});
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L9;
        double[] r5 = this.data[r4];
        double[] r6 = r14.data[r4];
        double[] r7 = r2[r4];
        int r8 = 0;
    L5:
        if (r8 >= r1) goto L7;
        r7[r8] = r5[r8] - r6[r8];
        r8 = r8 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L9:
        return new Array2DRowRealMatrix(r2, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor r10) {
        RealMatrixChangingVisitor r11 = (RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r11.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L9;
        int r2 = 0;
    L5:
        if (r2 >= r7) goto L7;
        double[] r3 = this.data[r2];
        r3[r1] = r11.visit(r2, r1, r3[r1]);
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r11.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInColumnOrder(RealMatrixChangingVisitor r8, int r9, int r10, int r11, int r12) {
        RealMatrixChangingVisitor r13 = (RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r11 > r12) goto L9;
        int r0 = r9;
    L5:
        if (r0 > r10) goto L7;
        double[] r1 = this.data[r0];
        r1[r11] = r13.visit(r0, r11, r1[r11]);
        r0 = r0 + 1;
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L9:
        return r13.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor r10) {
        RealMatrixPreservingVisitor r11 = (RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r11.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L9;
        int r2 = 0;
    L5:
        if (r2 >= r7) goto L7;
        r11.visit(r2, r1, this.data[r2][r1]);
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r11.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInColumnOrder(RealMatrixPreservingVisitor r8, int r9, int r10, int r11, int r12) {
        RealMatrixPreservingVisitor r13 = (RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r11 > r12) goto L9;
        int r0 = r9;
    L5:
        if (r0 > r10) goto L7;
        r13.visit(r0, r11, this.data[r0][r11]);
        r0 = r0 + 1;
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L9:
        return r13.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor r10) {
        RealMatrixChangingVisitor r11 = (RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r11.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        double[] r2 = this.data[r1];
        int r3 = 0;
    L5:
        if (r3 >= r8) goto L7;
        r2[r3] = r11.visit(r1, r3, r2[r3]);
        r3 = r3 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r11.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInRowOrder(RealMatrixChangingVisitor r8, int r9, int r10, int r11, int r12) {
        RealMatrixChangingVisitor r13 = (RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r9 > r10) goto L9;
        double[] r0 = this.data[r9];
        int r1 = r11;
    L5:
        if (r1 > r12) goto L7;
        r0[r1] = r13.visit(r9, r1, r0[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return r13.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor r10) {
        RealMatrixPreservingVisitor r11 = (RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r11.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        double[] r2 = this.data[r1];
        int r3 = 0;
    L5:
        if (r3 >= r8) goto L7;
        r11.visit(r1, r3, r2[r3]);
        r3 = r3 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r11.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public double walkInRowOrder(RealMatrixPreservingVisitor r8, int r9, int r10, int r11, int r12) {
        RealMatrixPreservingVisitor r13 = (RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r9 > r10) goto L9;
        double[] r0 = this.data[r9];
        int r1 = r11;
    L5:
        if (r1 > r12) goto L7;
        r13.visit(r9, r1, r0[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return r13.end();
    }
}
