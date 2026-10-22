package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFieldMatrix<T extends FieldElement<T>> implements FieldMatrix<T> {
    private final Field<T> field;

    public AbstractFieldMatrix() {
        this.field = null;
    }

    public AbstractFieldMatrix(Field<T> r3) {
        this.field = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
    }

    public AbstractFieldMatrix(Field<T> r3, int r4, int r5) {
        Field<T> r6 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        if (r4 <= 0) goto L10;
        if (r5 <= 0) goto L8;
        this.field = r6;
        return;
    L8:
        throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, Integer.valueOf(r5));
    L10:
        throw new NotStrictlyPositiveException(LocalizedFormats.DIMENSION, Integer.valueOf(r4));
    }

    @Deprecated
    public static <T extends FieldElement<T>> T[] buildArray(Field<T> r2, int r3) {
        return (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray((Field) ZeusTransformUtils.wrapperContextForParams(r2, Field.class, "com.obric.memorydata.plugin"), r3), FieldElement[].class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public static <T extends FieldElement<T>> T[][] buildArray(Field<T> r2, int r3, int r4) {
        return (T[][]) ((FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray((Field) ZeusTransformUtils.wrapperContextForParams(r2, Field.class, "com.obric.memorydata.plugin"), r3, r4), FieldElement[][].class, "com.obric.memorydata.plugin"));
    }

    public static <T extends FieldElement<T>> Field<T> extractField(T[] r1) {
        if (r1.length == 0) goto L7;
        return r1[0].getField();
    L7:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    }

    public static <T extends FieldElement<T>> Field<T> extractField(T[][] r2) {
        if (r2 == null) goto L14;
        if (r2.length == 0) goto L12;
        if (r2[0].length == 0) goto L10;
        return r2[0][0].getField();
    L10:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L12:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    L14:
        throw new NullArgumentException();
    }

    public FieldMatrix<T> add(FieldMatrix<T> r10) {
        FieldMatrix<T> r11 = (FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r10, FieldMatrix.class, "com.obric.memorydata.plugin");
        checkAdditionCompatible(r11);
        int r0 = getRowDimension();
        int r2 = getColumnDimension();
        FieldMatrix<T> r3 = createMatrix(r0, r2);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        int r6 = 0;
    L5:
        if (r6 >= r2) goto L7;
        r3.setEntry(r5, r6, (FieldElement) ZeusTransformUtils.preCheckCast(getEntry(r5, r6).add(r11.getEntry(r5, r6)), FieldElement.class, "com.obric.memorydata.plugin"));
        r6 = r6 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        return r3;
    }

    public abstract void addToEntry(int r1, int r2, T r3);

    public void checkAdditionCompatible(FieldMatrix<T> r4) {
        FieldMatrix r5 = (FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r4, FieldMatrix.class, "com.obric.memorydata.plugin");
        if (getRowDimension() != r5.getRowDimension()) goto L8;
        if (getColumnDimension() != r5.getColumnDimension()) goto L8;
        return;
    L8:
        throw new MatrixDimensionMismatchException(r5.getRowDimension(), r5.getColumnDimension(), getRowDimension(), getColumnDimension());
    }

    public void checkColumnIndex(int r4) {
        if (r4 < 0) goto L7;
        if (r4 >= getColumnDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.COLUMN_INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getColumnDimension() - 1));
    }

    public void checkMultiplicationCompatible(FieldMatrix<T> r3) {
        FieldMatrix r4 = (FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r3, FieldMatrix.class, "com.obric.memorydata.plugin");
        if (getColumnDimension() != r4.getRowDimension()) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(r4.getRowDimension(), getColumnDimension());
    }

    public void checkRowIndex(int r4) {
        if (r4 < 0) goto L7;
        if (r4 >= getRowDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.ROW_INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getRowDimension() - 1));
    }

    public void checkSubMatrixIndex(int r2, int r3, int r4, int r5) {
        checkRowIndex(r2);
        checkRowIndex(r3);
        if (r3 < r2) goto L10;
        checkColumnIndex(r4);
        checkColumnIndex(r5);
        if (r5 < r4) goto L8;
        return;
    L8:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_COLUMN_AFTER_FINAL_COLUMN, Integer.valueOf(r5), Integer.valueOf(r4), true);
    L10:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(r3), Integer.valueOf(r2), true);
    }

    public void checkSubMatrixIndex(int[] r5, int[] r6) {
        if (r5 == null) goto L18;
        if (r6 == null) goto L18;
        if (r5.length == 0) goto L16;
        if (r6.length == 0) goto L16;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L11;
        checkRowIndex(r5[r2]);
        r2 = r2 + 1;
        goto L9
    L11:
        int r7 = r6.length;
    L12:
        if (r1 >= r7) goto L14;
        checkColumnIndex(r6[r1]);
        r1 = r1 + 1;
        goto L12
    L14:
        return;
    L16:
        throw new NoDataException();
    L18:
        throw new NullArgumentException();
    }

    public void checkSubtractionCompatible(FieldMatrix<T> r4) {
        FieldMatrix r5 = (FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r4, FieldMatrix.class, "com.obric.memorydata.plugin");
        if (getRowDimension() != r5.getRowDimension()) goto L8;
        if (getColumnDimension() != r5.getColumnDimension()) goto L8;
        return;
    L8:
        throw new MatrixDimensionMismatchException(r5.getRowDimension(), r5.getColumnDimension(), getRowDimension(), getColumnDimension());
    }

    public abstract FieldMatrix<T> copy();

    public void copySubMatrix(int r11, int r12, int r13, int r14, final T[][] r15) {
        checkSubMatrixIndex(r11, r12, r13, r14);
        int r0 = (r12 + 1) - r11;
        int r1 = (r14 + 1) - r13;
        if (r15.length < r0) goto L9;
        if (r15[0].length < r1) goto L9;
        final FieldElement r2 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        walkInOptimizedOrder(new AnonymousClass2(this, r2, r15), r11, r12, r13, r14);
        return;
    L9:
        throw new MatrixDimensionMismatchException(r15.length, r15[0].length, r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void copySubMatrix(int[] r7, int[] r8, T[][] r9) {
        checkSubMatrixIndex(r7, r8);
        if (r9.length < r7.length) goto L16;
        if (r9[0].length < r8.length) goto L16;
        int r0 = 0;
    L8:
        if (r0 >= r7.length) goto L14;
        FieldElement[] r1 = r9[r0];
        int r3 = 0;
    L11:
        if (r3 >= r8.length) goto L13;
        r1[r3] = getEntry(r7[r0], r8[r3]);
        r3 = r3 + 1;
        goto L11
    L13:
        r0 = r0 + 1;
        goto L8
    L14:
        return;
    L16:
        throw new MatrixDimensionMismatchException(r9.length, r9[0].length, r7.length, r8.length);
    }

    public abstract FieldMatrix<T> createMatrix(int r1, int r2);

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, FieldMatrix.class) == true) goto L8;
        return false;
    L8:
        FieldMatrix r10 = (FieldMatrix) ZeusTransformUtils.preCheckCast(r9, FieldMatrix.class, "com.obric.memorydata.plugin");
        int r1 = getRowDimension();
        int r3 = getColumnDimension();
        if (r10.getColumnDimension() == r3) goto L11;
    L23:
        return false;
    L11:
        if (r10.getRowDimension() != r1) goto L23;
        int r4 = 0;
    L14:
        if (r4 >= r1) goto L22;
        int r5 = 0;
    L16:
        if (r5 >= r3) goto L21;
        if (getEntry(r4, r5).equals(r10.getEntry(r4, r5)) == false) goto L19;
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

    /* JADX WARN: Multi-variable type inference failed */
    public T[] getColumn(int r5) {
        checkColumnIndex(r5);
        int r0 = getRowDimension();
        T[] r1 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, r0), FieldElement[].class, "com.obric.memorydata.plugin"));
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = getEntry(r2, r5);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public abstract int getColumnDimension();

    public FieldMatrix<T> getColumnMatrix(int r6) {
        checkColumnIndex(r6);
        int r0 = getRowDimension();
        FieldMatrix<T> r1 = createMatrix(r0, 1);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.setEntry(r3, 0, getEntry(r3, r6));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public FieldVector<T> getColumnVector(int r3) {
        return new ArrayFieldVector(this.field, getColumn(r3), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[][] getData() {
        T[][] r0 = (T[][]) ((FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, getRowDimension(), getColumnDimension()), FieldElement[][].class, "com.obric.memorydata.plugin"));
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L10;
        FieldElement[] r3 = r0[r2];
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

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract T getEntry(int r1, int r2);

    public Field<T> getField() {
        return this.field;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] getRow(int r5) {
        checkRowIndex(r5);
        int r0 = getColumnDimension();
        T[] r1 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, r0), FieldElement[].class, "com.obric.memorydata.plugin"));
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = getEntry(r5, r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.AnyMatrix
    public abstract int getRowDimension();

    public FieldMatrix<T> getRowMatrix(int r6) {
        checkRowIndex(r6);
        int r0 = getColumnDimension();
        FieldMatrix<T> r1 = createMatrix(1, r0);
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.setEntry(0, r3, getEntry(r6, r3));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public FieldVector<T> getRowVector(int r3) {
        return new ArrayFieldVector(this.field, getRow(r3), false);
    }

    public FieldMatrix<T> getSubMatrix(int r7, int r8, int r9, int r10) {
        checkSubMatrixIndex(r7, r8, r9, r10);
        FieldMatrix<T> r0 = createMatrix((r8 - r7) + 1, (r10 - r9) + 1);
        int r1 = r7;
    L3:
        if (r1 > r8) goto L8;
        int r2 = r9;
    L5:
        if (r2 > r10) goto L7;
        r0.setEntry(r1 - r7, r2 - r9, getEntry(r1, r2));
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r0;
    }

    public FieldMatrix<T> getSubMatrix(final int[] r6, final int[] r7) {
        checkSubMatrixIndex(r6, r7);
        FieldMatrix<T> r0 = createMatrix(r6.length, r7.length);
        final FieldElement r2 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        r0.walkInOptimizedOrder(new AnonymousClass1(this, r2, r6, r7));
        return r0;
    }

    public T getTrace() {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r0 != r1) goto L9;
        T r2 = (T) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L7;
        r2 = (T) ZeusTransformUtils.preCheckCast(r2.add(getEntry(r3, r3)), FieldElement.class, "com.obric.memorydata.plugin");
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
        int r2 = ((9999422 + r0) * 31) + r1;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        int r7 = r5 + 1;
        r2 = (r2 * 31) + ((((r4 + 1) * 11) + (r7 * 17)) * getEntry(r4, r5).hashCode());
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

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> multiply(FieldMatrix<T> r13) {
        FieldMatrix<T> r14 = (FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r13, FieldMatrix.class, "com.obric.memorydata.plugin");
        checkMultiplicationCompatible(r14);
        int r0 = getRowDimension();
        int r2 = r14.getColumnDimension();
        int r3 = getColumnDimension();
        FieldMatrix<T> r4 = createMatrix(r0, r2);
        int r6 = 0;
    L3:
        if (r6 >= r0) goto L11;
        int r7 = 0;
    L5:
        if (r7 >= r2) goto L10;
        FieldElement r8 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r9 = 0;
    L7:
        if (r9 >= r3) goto L9;
        r8 = (FieldElement) ZeusTransformUtils.preCheckCast(r8.add(getEntry(r6, r9).multiply(r14.getEntry(r9, r7))), FieldElement.class, "com.obric.memorydata.plugin");
        r9 = r9 + 1;
        goto L7
    L9:
        r4.setEntry(r6, r7, r8);
        r7 = r7 + 1;
        goto L5
    L10:
        r6 = r6 + 1;
        goto L3
    L11:
        return r4;
    }

    public abstract void multiplyEntry(int r1, int r2, T r3);

    public FieldVector<T> operate(FieldVector<T> r11) {
        FieldVector r12 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r11, FieldVector.class, "com.obric.memorydata.plugin");
        return new ArrayFieldVector(this.field, operate(((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r12, ArrayFieldVector.class, "com.obric.memorydata.plugin")).getDataRef()), false);
    L5:
        int r2 = getRowDimension();
        int r3 = getColumnDimension();
        if (r12.getDimension() != r3) goto L16;
        FieldElement[] r4 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, r2), FieldElement[].class, "com.obric.memorydata.plugin");
        int r5 = 0;
    L8:
        if (r5 >= r2) goto L14;
        FieldElement r6 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r7 = 0;
    L10:
        if (r7 >= r3) goto L12;
        r6 = (FieldElement) ZeusTransformUtils.preCheckCast(r6.add(getEntry(r5, r7).multiply(r12.getEntry(r7))), FieldElement.class, "com.obric.memorydata.plugin");
        r7 = r7 + 1;
        goto L10
    L12:
        r4[r5] = r6;
        r5 = r5 + 1;
        goto L8
    L14:
        return new ArrayFieldVector(this.field, r4, false);
    L16:
        throw new DimensionMismatchException(r12.getDimension(), r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] operate(T[] r11) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r11.length != r1) goto L12;
        T[] r2 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, r0), FieldElement[].class, "com.obric.memorydata.plugin"));
        int r5 = 0;
    L5:
        if (r5 >= r0) goto L10;
        FieldElement r6 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r7 = 0;
    L7:
        if (r7 >= r1) goto L9;
        r6 = (FieldElement) ZeusTransformUtils.preCheckCast(r6.add(getEntry(r5, r7).multiply(r11[r7])), FieldElement.class, "com.obric.memorydata.plugin");
        r7 = r7 + 1;
        goto L7
    L9:
        r2[r5] = r6;
        r5 = r5 + 1;
        goto L5
    L10:
        return r2;
    L12:
        throw new DimensionMismatchException(r11.length, r1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public FieldMatrix<T> power(int r7) {
        if (r7 < 0) goto L31;
        if (isSquare() == false) goto L29;
        if (r7 == 0) goto L7;
        int r0 = 1;
        if (r7 == 1) goto L11;
        char[] r8 = Integer.toBinaryString(r7 - 1).toCharArray();
        ArrayList r1 = new ArrayList();
        int r3 = 0;
    L14:
        if (r3 >= r8.length) goto L19;
        if (r8[r3] != '1') goto L18;
        r1.add(Integer.valueOf((r8.length - r3) - 1));
    L18:
        r3 = r3 + 1;
        goto L14
    L19:
        ArrayList r4 = new ArrayList(r8.length);
        r4.add(0, copy());
    L21:
        if (r0 >= r8.length) goto L23;
        FieldMatrix<T> r2 = (FieldMatrix) ZeusTransformUtils.preCheckCast(r4.get(r0 - 1), FieldMatrix.class, "com.obric.memorydata.plugin");
        r4.add(r0, r2.multiply(r2));
        r0 = r0 + 1;
        goto L21
    L23:
        FieldMatrix<T> r6 = copy();
        Iterator r9 = r1.iterator();
    L25:
        if (r9.hasNext() == false) goto L27;
        r6 = r6.multiply((FieldMatrix) ZeusTransformUtils.preCheckCast(r4.get(((Integer) ZeusTransformUtils.preCheckCast(r9.next(), Integer.class, "com.obric.memorydata.plugin")).intValue()), FieldMatrix.class, "com.obric.memorydata.plugin"));
        goto L25
    L27:
        return r6;
    L11:
        return copy();
    L7:
        return MatrixUtils.createFieldIdentityMatrix(getField(), getRowDimension());
    L29:
        throw new NonSquareMatrixException(getRowDimension(), getColumnDimension());
    L31:
        throw new NotPositiveException(Integer.valueOf(r7));
    }

    public FieldMatrix<T> preMultiply(FieldMatrix<T> r3) {
        return ((FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r3, FieldMatrix.class, "com.obric.memorydata.plugin")).multiply(this);
    }

    public FieldVector<T> preMultiply(FieldVector<T> r11) {
        FieldVector r12 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r11, FieldVector.class, "com.obric.memorydata.plugin");
        return new ArrayFieldVector(this.field, preMultiply(((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r12, ArrayFieldVector.class, "com.obric.memorydata.plugin")).getDataRef()), false);
    L5:
        int r2 = getRowDimension();
        int r3 = getColumnDimension();
        if (r12.getDimension() != r2) goto L16;
        FieldElement[] r4 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, r3), FieldElement[].class, "com.obric.memorydata.plugin");
        int r5 = 0;
    L8:
        if (r5 >= r3) goto L14;
        FieldElement r6 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r7 = 0;
    L10:
        if (r7 >= r2) goto L12;
        r6 = (FieldElement) ZeusTransformUtils.preCheckCast(r6.add(getEntry(r7, r5).multiply(r12.getEntry(r7))), FieldElement.class, "com.obric.memorydata.plugin");
        r7 = r7 + 1;
        goto L10
    L12:
        r4[r5] = r6;
        r5 = r5 + 1;
        goto L8
    L14:
        return new ArrayFieldVector(this.field, r4, false);
    L16:
        throw new DimensionMismatchException(r12.getDimension(), r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] preMultiply(T[] r11) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r11.length != r0) goto L12;
        T[] r2 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, r1), FieldElement[].class, "com.obric.memorydata.plugin"));
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L10;
        FieldElement r6 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r7 = 0;
    L7:
        if (r7 >= r0) goto L9;
        r6 = (FieldElement) ZeusTransformUtils.preCheckCast(r6.add(getEntry(r7, r5).multiply(r11[r7])), FieldElement.class, "com.obric.memorydata.plugin");
        r7 = r7 + 1;
        goto L7
    L9:
        r2[r5] = r6;
        r5 = r5 + 1;
        goto L5
    L10:
        return r2;
    L12:
        throw new DimensionMismatchException(r11.length, r0);
    }

    public FieldMatrix<T> scalarAdd(T r10) {
        FieldElement r11 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r10, FieldElement.class, "com.obric.memorydata.plugin");
        int r0 = getRowDimension();
        int r2 = getColumnDimension();
        FieldMatrix<T> r3 = createMatrix(r0, r2);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        int r6 = 0;
    L5:
        if (r6 >= r2) goto L7;
        r3.setEntry(r5, r6, (FieldElement) ZeusTransformUtils.preCheckCast(getEntry(r5, r6).add(r11), FieldElement.class, "com.obric.memorydata.plugin"));
        r6 = r6 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        return r3;
    }

    public FieldMatrix<T> scalarMultiply(T r10) {
        FieldElement r11 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r10, FieldElement.class, "com.obric.memorydata.plugin");
        int r0 = getRowDimension();
        int r2 = getColumnDimension();
        FieldMatrix<T> r3 = createMatrix(r0, r2);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        int r6 = 0;
    L5:
        if (r6 >= r2) goto L7;
        r3.setEntry(r5, r6, (FieldElement) ZeusTransformUtils.preCheckCast(getEntry(r5, r6).multiply(r11), FieldElement.class, "com.obric.memorydata.plugin"));
        r6 = r6 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        return r3;
    }

    public void setColumn(int r4, T[] r5) {
        checkColumnIndex(r4);
        int r0 = getRowDimension();
        if (r5.length != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r1, r4, r5[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(r5.length, 1, r0, 1);
    }

    public void setColumnMatrix(int r5, FieldMatrix<T> r6) {
        FieldMatrix r7 = (FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r6, FieldMatrix.class, "com.obric.memorydata.plugin");
        checkColumnIndex(r5);
        int r0 = getRowDimension();
        if (r7.getRowDimension() != r0) goto L11;
        if (r7.getColumnDimension() != 1) goto L11;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        setEntry(r2, r5, r7.getEntry(r2, 0));
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new MatrixDimensionMismatchException(r7.getRowDimension(), r7.getColumnDimension(), r0, 1);
    }

    public void setColumnVector(int r4, FieldVector<T> r5) {
        FieldVector r6 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r5, FieldVector.class, "com.obric.memorydata.plugin");
        checkColumnIndex(r4);
        int r0 = getRowDimension();
        if (r6.getDimension() != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r1, r4, r6.getEntry(r1));
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(r6.getDimension(), 1, r0, 1);
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public abstract void setEntry(int r1, int r2, T r3);

    public void setRow(int r4, T[] r5) {
        checkRowIndex(r4);
        int r0 = getColumnDimension();
        if (r5.length != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r4, r1, r5[r1]);
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(1, r5.length, 1, r0);
    }

    public void setRowMatrix(int r5, FieldMatrix<T> r6) {
        FieldMatrix r7 = (FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r6, FieldMatrix.class, "com.obric.memorydata.plugin");
        checkRowIndex(r5);
        int r0 = getColumnDimension();
        if (r7.getRowDimension() != 1) goto L11;
        if (r7.getColumnDimension() != r0) goto L11;
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        setEntry(r5, r2, r7.getEntry(0, r2));
        r2 = r2 + 1;
        goto L7
    L9:
        return;
    L11:
        throw new MatrixDimensionMismatchException(r7.getRowDimension(), r7.getColumnDimension(), 1, r0);
    }

    public void setRowVector(int r4, FieldVector<T> r5) {
        FieldVector r6 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r5, FieldVector.class, "com.obric.memorydata.plugin");
        checkRowIndex(r4);
        int r0 = getColumnDimension();
        if (r6.getDimension() != r0) goto L9;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        setEntry(r4, r1, r6.getEntry(r1));
        r1 = r1 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new MatrixDimensionMismatchException(1, r6.getDimension(), 1, r0);
    }

    public void setSubMatrix(T[][] r9, int r10, int r11) {
        if (r9 == null) goto L26;
        int r0 = r9.length;
        if (r0 == 0) goto L24;
        int r2 = r9[0].length;
        if (r2 == 0) goto L22;
        int r4 = 1;
    L8:
        if (r4 >= r0) goto L14;
        if (r9[r4].length != r2) goto L13;
        r4 = r4 + 1;
        goto L8
    L13:
        throw new DimensionMismatchException(r2, r9[r4].length);
    L14:
        checkRowIndex(r10);
        checkColumnIndex(r11);
        checkRowIndex((r0 + r10) - 1);
        checkColumnIndex((r2 + r11) - 1);
        int r3 = 0;
    L15:
        if (r3 >= r0) goto L20;
        int r5 = 0;
    L17:
        if (r5 >= r2) goto L19;
        setEntry(r10 + r3, r11 + r5, r9[r3][r5]);
        r5 = r5 + 1;
        goto L17
    L19:
        r3 = r3 + 1;
        goto L15
    L20:
        return;
    L22:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L24:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    L26:
        throw new NullArgumentException();
    }

    public FieldMatrix<T> subtract(FieldMatrix<T> r10) {
        FieldMatrix<T> r11 = (FieldMatrix) ZeusTransformUtils.wrapperContextForParams(r10, FieldMatrix.class, "com.obric.memorydata.plugin");
        checkSubtractionCompatible(r11);
        int r0 = getRowDimension();
        int r2 = getColumnDimension();
        FieldMatrix<T> r3 = createMatrix(r0, r2);
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L8;
        int r6 = 0;
    L5:
        if (r6 >= r2) goto L7;
        r3.setEntry(r5, r6, (FieldElement) ZeusTransformUtils.preCheckCast(getEntry(r5, r6).subtract(r11.getEntry(r5, r6)), FieldElement.class, "com.obric.memorydata.plugin"));
        r6 = r6 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L8:
        return r3;
    }

    public String toString() {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        StringBuffer r2 = new StringBuffer();
        String r3 = getClass().getName();
        r2.append(r3.substring(r3.lastIndexOf(46) + 1)).append("{");
        int r5 = 0;
    L4:
        if (r5 >= r0) goto L14;
        if (r5 <= 0) goto L8;
        r2.append(",");
    L8:
        r2.append("{");
        int r8 = 0;
    L9:
        if (r8 >= r1) goto L13;
        if (r8 <= 0) goto L12;
        r2.append(",");
    L12:
        r2.append(getEntry(r5, r8));
        r8 = r8 + 1;
        goto L9
    L13:
        r2.append("}");
        r5 = r5 + 1;
        goto L4
    L14:
        r2.append("}");
        return r2.toString();
    }

    public FieldMatrix<T> transpose() {
        int r0 = getRowDimension();
        final FieldMatrix<T> r1 = createMatrix(getColumnDimension(), r0);
        final FieldElement r2 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        walkInOptimizedOrder(new AnonymousClass3(this, r2, r1));
        return r1;
    }

    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> r10) {
        FieldMatrixChangingVisitor r11 = (FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
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
        return (T) r11.end();
    }

    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) {
        FieldMatrixChangingVisitor r13 = (FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        checkSubMatrixIndex(r9, r10, r11, r12);
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
        return (T) r13.end();
    }

    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r10) {
        FieldMatrixPreservingVisitor r11 = (FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
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
        return (T) r11.end();
    }

    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) {
        FieldMatrixPreservingVisitor r13 = (FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        checkSubMatrixIndex(r9, r10, r11, r12);
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
        return (T) r13.end();
    }

    @Override // org.apache.commons.math3.linear.FieldMatrix
    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r3) {
        return (T) walkInRowOrder((FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin"));
    }

    public T walkInOptimizedOrder(FieldMatrixChangingVisitor<T> r7, int r8, int r9, int r10, int r11) {
        return (T) walkInRowOrder((FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r7, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
    }

    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r3) {
        return (T) walkInRowOrder((FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin"));
    }

    public T walkInOptimizedOrder(FieldMatrixPreservingVisitor<T> r7, int r8, int r9, int r10, int r11) {
        return (T) walkInRowOrder((FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r7, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
    }

    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r10) {
        FieldMatrixChangingVisitor r11 = (FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
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
        return (T) r11.end();
    }

    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) {
        FieldMatrixChangingVisitor r13 = (FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        checkSubMatrixIndex(r9, r10, r11, r12);
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
        return (T) r13.end();
    }

    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r10) {
        FieldMatrixPreservingVisitor r11 = (FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
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
        return (T) r11.end();
    }

    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) {
        FieldMatrixPreservingVisitor r13 = (FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        checkSubMatrixIndex(r9, r10, r11, r12);
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
        return (T) r13.end();
    }
}
