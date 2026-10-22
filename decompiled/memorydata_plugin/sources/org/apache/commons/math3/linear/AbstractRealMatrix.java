package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractRealMatrix extends RealLinearOperator implements RealMatrix {
    private static final RealMatrixFormat DEFAULT_FORMAT = null;

    static {
        RealMatrixFormat r0 = RealMatrixFormat.getInstance(Locale.US);
        DEFAULT_FORMAT = r0;
        r0.getFormat().setMinimumFractionDigits(1);
    }

    public AbstractRealMatrix() {
    }

    public AbstractRealMatrix(int r1, int r2) {
        if (r1 < 1) goto L9;
        if (r2 < 1) goto L7;
        return;
    L7:
        throw new NotStrictlyPositiveException(Integer.valueOf(r2));
    L9:
        throw new NotStrictlyPositiveException(Integer.valueOf(r1));
    }

    public RealMatrix add(RealMatrix r11) {
        RealMatrix r12 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r11, RealMatrix.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkAdditionCompatible(this, r12);
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        RealMatrix r2 = createMatrix(r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, getEntry(r4, r5) + r12.getEntry(r4, r5));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    public void addToEntry(int r3, int r4, double r5) {
        MatrixUtils.checkMatrixIndex(this, r3, r4);
        setEntry(r3, r4, getEntry(r3, r4) + r5);
    }

    public abstract RealMatrix copy();

    @Override // org.apache.commons.math3.linear.RealMatrix
    public void copySubMatrix(int r9, int r10, int r11, int r12, final double[][] r13) {
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        int r0 = (r10 + 1) - r9;
        int r1 = (r12 + 1) - r11;
        if (r13.length < r0) goto L16;
        if (r13[0].length < r1) goto L16;
        int r2 = 1;
    L7:
        if (r2 >= r0) goto L13;
        if (r13[r2].length < r1) goto L12;
        r2 = r2 + 1;
        goto L7
    L12:
        throw new MatrixDimensionMismatchException(r13.length, r13[r2].length, r0, r1);
    L13:
        walkInOptimizedOrder(new AnonymousClass4(this, r13), r9, r10, r11, r12);
        return;
    L16:
        throw new MatrixDimensionMismatchException(r13.length, r13[0].length, r0, r1);
    }

    public void copySubMatrix(int[] r8, int[] r9, double[][] r10) {
        MatrixUtils.checkSubMatrixIndex(this, r8, r9);
        int r0 = r9.length;
        if (r10.length < r8.length) goto L20;
        if (r10[0].length < r0) goto L20;
        int r1 = 0;
    L8:
        if (r1 >= r8.length) goto L18;
        double[] r2 = r10[r1];
        if (r2.length < r0) goto L17;
        int r4 = 0;
    L13:
        if (r4 >= r9.length) goto L15;
        r2[r4] = getEntry(r8[r1], r9[r4]);
        r4 = r4 + 1;
        goto L13
    L15:
        r1 = r1 + 1;
        goto L8
    L17:
        throw new MatrixDimensionMismatchException(r10.length, r2.length, r8.length, r9.length);
    L18:
        return;
    L20:
        throw new MatrixDimensionMismatchException(r10.length, r10[0].length, r8.length, r9.length);
    }

    public abstract RealMatrix createMatrix(int r1, int r2);

    public boolean equals(Object r11) {
        if (r11 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r11, RealMatrix.class) == true) goto L8;
        return false;
    L8:
        RealMatrix r12 = (RealMatrix) ZeusTransformUtils.preCheckCast(r11, RealMatrix.class, "com.obric.memorydata.plugin");
        int r1 = getRowDimension();
        int r3 = getColumnDimension();
        if (r12.getColumnDimension() == r3) goto L11;
    L23:
        return false;
    L11:
        if (r12.getRowDimension() != r1) goto L23;
        int r4 = 0;
    L14:
        if (r4 >= r1) goto L22;
        int r5 = 0;
    L16:
        if (r5 >= r3) goto L21;
        if (getEntry(r4, r5) != r12.getEntry(r4, r5)) goto L19;
        r5 = r5 + 1;
        goto L16
    L19:
        return false;
    L21:
        r4 = r4 + 1;
        goto L14
    L22:
        return true;
    }

    public double[] getColumn(int r6) {
        MatrixUtils.checkColumnIndex(this, r6);
        int r0 = getRowDimension();
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = getEntry(r2, r6);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public abstract int getColumnDimension();

    public RealMatrix getColumnMatrix(int r7) {
        MatrixUtils.checkColumnIndex(this, r7);
        int r0 = getRowDimension();
        RealMatrix r1 = createMatrix(r0, 1);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.setEntry(r3, 0, getEntry(r3, r7));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public RealVector getColumnVector(int r2) {
        return new ArrayRealVector(getColumn(r2), false);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double[][] getData() {
        double[][] r0 = (double[][]) Array.newInstance(double.class, new int[]{getRowDimension(), getColumnDimension()});
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L10;
        double[] r3 = r0[r2];
        int r4 = 0;
    L7:
        if (r4 >= r3.length) goto L9;
        r3[r4] = getEntry(r2, r4);
        r4 = r4 + 1;
        goto L7
    L9:
        r2 = r2 + 1;
        goto L4
    L10:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract double getEntry(int r1, int r2);

    public double getFrobeniusNorm() {
        return walkInOptimizedOrder(new AnonymousClass2(this));
    }

    public double getNorm() {
        return walkInColumnOrder(new AnonymousClass1(this));
    }

    public double[] getRow(int r6) {
        MatrixUtils.checkRowIndex(this, r6);
        int r0 = getColumnDimension();
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = getEntry(r6, r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public abstract int getRowDimension();

    public RealMatrix getRowMatrix(int r7) {
        MatrixUtils.checkRowIndex(this, r7);
        int r0 = getColumnDimension();
        RealMatrix r1 = createMatrix(1, r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.setEntry(0, r3, getEntry(r7, r3));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public RealVector getRowVector(int r2) {
        return new ArrayRealVector(getRow(r2), false);
    }

    public RealMatrix getSubMatrix(int r8, int r9, int r10, int r11) {
        MatrixUtils.checkSubMatrixIndex(this, r8, r9, r10, r11);
        RealMatrix r0 = createMatrix((r9 - r8) + 1, (r11 - r10) + 1);
        int r1 = r8;
    L3:
        if (r1 > r9) goto L8;
        int r2 = r10;
    L5:
        if (r2 > r11) goto L7;
        r0.setEntry(r1 - r8, r2 - r10, getEntry(r1, r2));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r0;
    }

    public RealMatrix getSubMatrix(final int[] r3, final int[] r4) {
        MatrixUtils.checkSubMatrixIndex(this, r3, r4);
        RealMatrix r0 = createMatrix(r3.length, r4.length);
        r0.walkInOptimizedOrder(new AnonymousClass3(this, r3, r4));
        return r0;
    }

    public double getTrace() {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r0 != r1) goto L9;
        double r2 = 0.0d;
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L7;
        r2 = r2 + getEntry(r3, r3);
        r3 = r3 + 1;
        goto L5
    L7:
        return r2;
    L9:
        throw new NonSquareMatrixException(r0, r1);
    }

    public int hashCode() {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        int r2 = ((217 + r0) * 31) + r1;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        int r7 = r5 + 1;
        r2 = (r2 * 31) + ((((r4 + 1) * 11) + (r7 * 17)) * MathUtils.hash(getEntry(r4, r5)));
        r5 = r7;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public boolean isSquare() {
        if (getColumnDimension() != getRowDimension()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix r15) {
        RealMatrix r16 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r15, RealMatrix.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkMultiplicationCompatible(this, r16);
        int r0 = getRowDimension();
        int r1 = r16.getColumnDimension();
        int r2 = getColumnDimension();
        RealMatrix r3 = createMatrix(r0, r1);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L11;
        int r6 = 0;
    L5:
        if (r6 >= r1) goto L10;
        double r7 = 0.0d;
        int r9 = 0;
    L7:
        if (r9 >= r2) goto L9;
        r7 = r7 + (getEntry(r5, r9) * r16.getEntry(r9, r6));
        r9 = r9 + 1;
        goto L7
    L9:
        r3.setEntry(r5, r6, r7);
        r6 = r6 + 1;
        goto L5
    L10:
        r5 = r5 + 1;
        goto L3
    L11:
        return r3;
    }

    public void multiplyEntry(int r3, int r4, double r5) {
        MatrixUtils.checkMatrixIndex(this, r3, r4);
        setEntry(r3, r4, getEntry(r3, r4) * r5);
    }

    @Override // org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.RealMatrix
    public RealVector operate(RealVector r13) {
        return new ArrayRealVector(operate(((ArrayRealVector) ZeusTransformUtils.preCheckCast(r13, ArrayRealVector.class, "com.obric.memorydata.plugin")).getDataRef()), false);
    L5:
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        if (r13.getDimension() != r2) goto L16;
        double[] r3 = new double[r1];
        int r4 = 0;
    L8:
        if (r4 >= r1) goto L14;
        double r5 = 0.0d;
        int r7 = 0;
    L10:
        if (r7 >= r2) goto L12;
        r5 = r5 + (getEntry(r4, r7) * r13.getEntry(r7));
        r7 = r7 + 1;
        goto L10
    L12:
        r3[r4] = r5;
        r4 = r4 + 1;
        goto L8
    L14:
        return new ArrayRealVector(r3, false);
    L16:
        throw new DimensionMismatchException(r13.getDimension(), r2);
    }

    public double[] operate(double[] r13) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r13.length != r1) goto L12;
        double[] r2 = new double[r0];
        int r4 = 0;
    L5:
        if (r4 >= r0) goto L10;
        double r5 = 0.0d;
        int r7 = 0;
    L7:
        if (r7 >= r1) goto L9;
        r5 = r5 + (getEntry(r4, r7) * r13[r7]);
        r7 = r7 + 1;
        goto L7
    L9:
        r2[r4] = r5;
        r4 = r4 + 1;
        goto L5
    L10:
        return r2;
    L12:
        throw new DimensionMismatchException(r13.length, r1);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix power(int r9) {
        if (r9 < 0) goto L32;
        if (isSquare() == false) goto L30;
        if (r9 == 0) goto L7;
        int r0 = 1;
        if (r9 == 1) goto L11;
        char[] r10 = Integer.toBinaryString(r9 - 1).toCharArray();
        ArrayList r1 = new ArrayList();
        int r4 = 0;
        int r5 = -1;
    L14:
        if (r4 >= r10.length) goto L21;
        if (r10[r4] != '1') goto L20;
        int r6 = (r10.length - r4) - 1;
        r1.add(Integer.valueOf(r6));
        if (r5 != (-1)) goto L20;
        r5 = r6;
    L20:
        r4 = r4 + 1;
        goto L14
    L21:
        RealMatrix[] r11 = new RealMatrix[r5 + 1];
        r11[0] = copy();
    L22:
        if (r0 > r5) goto L24;
        int r2 = r0 - 1;
        r11[r0] = r11[r2].multiply(r11[r2]);
        r0 = r0 + 1;
        goto L22
    L24:
        RealMatrix r8 = copy();
        Iterator r3 = r1.iterator();
    L26:
        if (r3.hasNext() == false) goto L28;
        r8 = r8.multiply(r11[((Integer) ZeusTransformUtils.preCheckCast(r3.next(), Integer.class, "com.obric.memorydata.plugin")).intValue()]);
        goto L26
    L28:
        return r8;
    L11:
        return copy();
    L7:
        return MatrixUtils.createRealIdentityMatrix(getRowDimension());
    L30:
        throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
    L32:
        throw new NotPositiveException(LocalizedFormats.NOT_POSITIVE_EXPONENT, Integer.valueOf(r9));
    }

    public RealMatrix preMultiply(RealMatrix r3) {
        return ((RealMatrix) ZeusTransformUtils.wrapperContextForParams(r3, RealMatrix.class, "com.obric.memorydata.plugin")).multiply(this);
    }

    public RealVector preMultiply(RealVector r13) {
        return new ArrayRealVector(preMultiply(((ArrayRealVector) ZeusTransformUtils.preCheckCast(r13, ArrayRealVector.class, "com.obric.memorydata.plugin")).getDataRef()), false);
    L5:
        int r1 = getRowDimension();
        int r2 = getColumnDimension();
        if (r13.getDimension() != r1) goto L16;
        double[] r3 = new double[r2];
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L14;
        double r5 = 0.0d;
        int r7 = 0;
    L10:
        if (r7 >= r1) goto L12;
        r5 = r5 + (getEntry(r7, r4) * r13.getEntry(r7));
        r7 = r7 + 1;
        goto L10
    L12:
        r3[r4] = r5;
        r4 = r4 + 1;
        goto L8
    L14:
        return new ArrayRealVector(r3, false);
    L16:
        throw new DimensionMismatchException(r13.getDimension(), r1);
    }

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
        r5 = r5 + (getEntry(r7, r4) * r13[r7]);
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

    public RealMatrix scalarAdd(double r9) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        RealMatrix r2 = createMatrix(r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, getEntry(r4, r5) + r9);
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    public RealMatrix scalarMultiply(double r9) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        RealMatrix r2 = createMatrix(r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, getEntry(r4, r5) * r9);
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    public void setColumn(int r5, double[] r6) {
        MatrixUtils.checkColumnIndex(this, r5);
        int r0 = getRowDimension();
        if (r6.length != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r1, r5, r6[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(r6.length, 1, r0, 1);
    }

    public void setColumnMatrix(int r6, RealMatrix r7) {
        RealMatrix r8 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r7, RealMatrix.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkColumnIndex(this, r6);
        int r0 = getRowDimension();
        if (r8.getRowDimension() != r0) goto L11;
        if (r8.getColumnDimension() != 1) goto L11;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        setEntry(r2, r6, r8.getEntry(r2, 0));
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new MatrixDimensionMismatchException(r8.getRowDimension(), r8.getColumnDimension(), r0, 1);
    }

    public void setColumnVector(int r5, RealVector r6) {
        MatrixUtils.checkColumnIndex(this, r5);
        int r0 = getRowDimension();
        if (r6.getDimension() != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r1, r5, r6.getEntry(r1));
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(r6.getDimension(), 1, r0, 1);
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public abstract void setEntry(int r1, int r2, double r3);

    public void setRow(int r5, double[] r6) {
        MatrixUtils.checkRowIndex(this, r5);
        int r0 = getColumnDimension();
        if (r6.length != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r5, r1, r6[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(1, r6.length, 1, r0);
    }

    public void setRowMatrix(int r6, RealMatrix r7) {
        RealMatrix r8 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r7, RealMatrix.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkRowIndex(this, r6);
        int r0 = getColumnDimension();
        if (r8.getRowDimension() != 1) goto L11;
        if (r8.getColumnDimension() != r0) goto L11;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        setEntry(r6, r2, r8.getEntry(0, r2));
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new MatrixDimensionMismatchException(r8.getRowDimension(), r8.getColumnDimension(), 1, r0);
    }

    public void setRowVector(int r5, RealVector r6) {
        MatrixUtils.checkRowIndex(this, r5);
        int r0 = getColumnDimension();
        if (r6.getDimension() != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r5, r1, r6.getEntry(r1));
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(1, r6.getDimension(), 1, r0);
    }

    public void setSubMatrix(double[][] r10, int r11, int r12) {
        MathUtils.checkNotNull(r10);
        int r0 = r10.length;
        if (r0 == 0) goto L23;
        int r2 = r10[0].length;
        if (r2 == 0) goto L21;
        int r4 = 1;
    L7:
        if (r4 >= r0) goto L13;
        if (r10[r4].length != r2) goto L12;
        r4 = r4 + 1;
        goto L7
    L12:
        throw new DimensionMismatchException(r2, r10[r4].length);
    L13:
        MatrixUtils.checkRowIndex(this, r11);
        MatrixUtils.checkColumnIndex(this, r12);
        MatrixUtils.checkRowIndex(this, (r0 + r11) - 1);
        MatrixUtils.checkColumnIndex(this, (r2 + r12) - 1);
        int r3 = 0;
    L14:
        if (r3 >= r0) goto L19;
        int r5 = 0;
    L16:
        if (r5 >= r2) goto L18;
        setEntry(r11 + r3, r12 + r5, r10[r3][r5]);
        r5 = r5 + 1;
        goto L16
    L18:
        r3 = r3 + 1;
        goto L14
    L19:
        return;
    L21:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L23:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    }

    public RealMatrix subtract(RealMatrix r11) {
        RealMatrix r12 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r11, RealMatrix.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubtractionCompatible(this, r12);
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        RealMatrix r2 = createMatrix(r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, getEntry(r4, r5) - r12.getEntry(r4, r5));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r1 = getClass().getName();
        r0.append(r1.substring(r1.lastIndexOf(46) + 1));
        r0.append(DEFAULT_FORMAT.format(this));
        return r0.toString();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public RealMatrix transpose() {
        int r0 = getRowDimension();
        final RealMatrix r1 = createMatrix(getColumnDimension(), r0);
        walkInOptimizedOrder(new AnonymousClass5(this, r1));
        return r1;
    }

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
        setEntry(r2, r1, r11.visit(r2, r1, getEntry(r2, r1)));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r11.end();
    }

    public double walkInColumnOrder(RealMatrixChangingVisitor r8, int r9, int r10, int r11, int r12) {
        RealMatrixChangingVisitor r13 = (RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r11 > r12) goto L9;
        int r0 = r9;
    L5:
        if (r0 > r10) goto L7;
        setEntry(r0, r11, r13.visit(r0, r11, getEntry(r0, r11)));
        r0 = r0 + 1;
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L9:
        return r13.end();
    }

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
        r11.visit(r2, r1, getEntry(r2, r1));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r11.end();
    }

    public double walkInColumnOrder(RealMatrixPreservingVisitor r8, int r9, int r10, int r11, int r12) {
        RealMatrixPreservingVisitor r13 = (RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r11 > r12) goto L9;
        int r0 = r9;
    L5:
        if (r0 > r10) goto L7;
        r13.visit(r0, r11, getEntry(r0, r11));
        r0 = r0 + 1;
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L9:
        return r13.end();
    }

    @Override // org.apache.commons.math3.linear.RealMatrix
    public double walkInOptimizedOrder(RealMatrixChangingVisitor r3) {
        return walkInRowOrder((RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin"));
    }

    public double walkInOptimizedOrder(RealMatrixChangingVisitor r7, int r8, int r9, int r10, int r11) {
        return walkInRowOrder((RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r7, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
    }

    public double walkInOptimizedOrder(RealMatrixPreservingVisitor r3) {
        return walkInRowOrder((RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin"));
    }

    public double walkInOptimizedOrder(RealMatrixPreservingVisitor r7, int r8, int r9, int r10, int r11) {
        return walkInRowOrder((RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r7, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
    }

    public double walkInRowOrder(RealMatrixChangingVisitor r10) {
        RealMatrixChangingVisitor r11 = (RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r11.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        setEntry(r1, r2, r11.visit(r1, r2, getEntry(r1, r2)));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r11.end();
    }

    public double walkInRowOrder(RealMatrixChangingVisitor r8, int r9, int r10, int r11, int r12) {
        RealMatrixChangingVisitor r13 = (RealMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r9 > r10) goto L9;
        int r0 = r11;
    L5:
        if (r0 > r12) goto L7;
        setEntry(r9, r0, r13.visit(r9, r0, getEntry(r9, r0)));
        r0 = r0 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return r13.end();
    }

    public double walkInRowOrder(RealMatrixPreservingVisitor r10) {
        RealMatrixPreservingVisitor r11 = (RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r11.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        int r2 = 0;
    L5:
        if (r2 >= r8) goto L7;
        r11.visit(r1, r2, getEntry(r1, r2));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return r11.end();
    }

    public double walkInRowOrder(RealMatrixPreservingVisitor r8, int r9, int r10, int r11, int r12) {
        RealMatrixPreservingVisitor r13 = (RealMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, RealMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        MatrixUtils.checkSubMatrixIndex(this, r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r9 > r10) goto L9;
        int r0 = r11;
    L5:
        if (r0 > r12) goto L7;
        r13.visit(r9, r0, getEntry(r9, r0));
        r0 = r0 + 1;
        goto L5
    L7:
        r9 = r9 + 1;
        goto L3
    L9:
        return r13.end();
    }
}
