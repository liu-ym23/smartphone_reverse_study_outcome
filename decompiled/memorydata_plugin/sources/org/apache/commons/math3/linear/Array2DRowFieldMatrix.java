package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Array2DRowFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> implements Serializable {
    private static final long serialVersionUID = 7260756672015356458L;
    private T[][] data;

    public Array2DRowFieldMatrix(Field<T> r3) {
        super((Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin"));
    }

    public Array2DRowFieldMatrix(Field<T> r3, int r4, int r5) {
        Field r6 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        super(r6, r4, r5);
        this.data = (T[][]) ((FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r6, r4, r5), FieldElement[][].class, "com.obric.memorydata.plugin"));
    }

    public Array2DRowFieldMatrix(Field<T> r5, T[] r6) {
        super((Field) ZeusTransformUtils.wrapperContextForParams(r5, Field.class, "com.obric.memorydata.plugin"));
        int r7 = r6.length;
        this.data = (T[][]) ((FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(getField(), r7, 1), FieldElement[][].class, "com.obric.memorydata.plugin"));
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L5;
        this.data[r1][0] = r6[r1];
        r1 = r1 + 1;
        goto L3
    }

    public Array2DRowFieldMatrix(Field<T> r3, T[][] r4) {
        super((Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin"));
        copyIn(r4);
    }

    public Array2DRowFieldMatrix(Field<T> r3, T[][] r4, boolean r5) {
        super((Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin"));
        if (r5 == false) goto L5;
        copyIn(r4);
        return;
    L5:
        MathUtils.checkNotNull(r4);
        int r6 = r4.length;
        if (r6 == 0) goto L21;
        int r7 = r4[0].length;
        if (r7 == 0) goto L19;
        int r0 = 1;
    L10:
        if (r0 >= r6) goto L16;
        if (r4[r0].length != r7) goto L15;
        r0 = r0 + 1;
        goto L10
    L15:
        throw new DimensionMismatchException(r7, r4[r0].length);
    L16:
        this.data = r4;
        return;
    L19:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_COLUMN);
    L21:
        throw new NoDataException(LocalizedFormats.AT_LEAST_ONE_ROW);
    }

    public Array2DRowFieldMatrix(T[] r2) {
        this(extractField(r2), r2);
    }

    public Array2DRowFieldMatrix(T[][] r2) {
        this(extractField(r2), r2);
    }

    public Array2DRowFieldMatrix(T[][] r2, boolean r3) {
        this(extractField(r2), r2, r3);
    }

    private void copyIn(T[][] r2) {
        setSubMatrix(r2, 0, 0);
    }

    private T[][] copyOut() {
        int r0 = getRowDimension();
        T[][] r1 = (T[][]) ((FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(getField(), r0, getColumnDimension()), FieldElement[][].class, "com.obric.memorydata.plugin"));
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        T[][] r4 = this.data;
        System.arraycopy(r4[r3], 0, r1[r3], 0, r4[r3].length);
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public Array2DRowFieldMatrix<T> add(Array2DRowFieldMatrix<T> r13) {
        checkAdditionCompatible(r13);
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        FieldElement[][] r2 = (FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(getField(), r0, r1), FieldElement[][].class, "com.obric.memorydata.plugin");
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L9;
        T[] r6 = this.data[r5];
        T[] r7 = r13.data[r5];
        FieldElement[] r8 = r2[r5];
        int r9 = 0;
    L5:
        if (r9 >= r1) goto L7;
        r8[r9] = (FieldElement) ZeusTransformUtils.preCheckCast(r6[r9].add(r7[r9]), FieldElement.class, "com.obric.memorydata.plugin");
        r9 = r9 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L9:
        return new Array2DRowFieldMatrix(getField(), r2, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public void addToEntry(int r3, int r4, T r5) {
        FieldElement r6 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r5, FieldElement.class, "com.obric.memorydata.plugin");
        checkRowIndex(r3);
        checkColumnIndex(r4);
        FieldElement[][] r2 = this.data;
        r2[r3][r4] = (FieldElement) ZeusTransformUtils.preCheckCast(r2[r3][r4].add(r6), FieldElement.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public FieldMatrix<T> copy() {
        return new Array2DRowFieldMatrix(getField(), copyOut(), false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public FieldMatrix<T> createMatrix(int r2, int r3) {
        return new Array2DRowFieldMatrix(getField(), r2, r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        T[][] r2 = this.data;
        if (r2 != null) goto L5;
        return 0;
    L5:
        if (r2[0] != null) goto L8;
        return 0;
    L8:
        return r2[0].length;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T[][] getData() {
        return (T[][]) copyOut();
    }

    public T[][] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T getEntry(int r1, int r2) {
        checkRowIndex(r1);
        checkColumnIndex(r2);
        return this.data[r1][r2];
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        T[][] r0 = this.data;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public Array2DRowFieldMatrix<T> multiply(Array2DRowFieldMatrix<T> r15) {
        checkMultiplicationCompatible(r15);
        int r0 = getRowDimension();
        int r1 = r15.getColumnDimension();
        int r2 = getColumnDimension();
        FieldElement[][] r3 = (FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(getField(), r0, r1), FieldElement[][].class, "com.obric.memorydata.plugin");
        int r6 = 0;
    L3:
        if (r6 >= r0) goto L12;
        T[] r7 = this.data[r6];
        FieldElement[] r8 = r3[r6];
        int r9 = 0;
    L5:
        if (r9 >= r1) goto L10;
        FieldElement r10 = (FieldElement) ZeusTransformUtils.preCheckCast(getField().getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r11 = 0;
    L7:
        if (r11 >= r2) goto L9;
        r10 = (FieldElement) ZeusTransformUtils.preCheckCast(r10.add(r7[r11].multiply(r15.data[r11][r9])), FieldElement.class, "com.obric.memorydata.plugin");
        r11 = r11 + 1;
        goto L7
    L9:
        r8[r9] = r10;
        r9 = r9 + 1;
        goto L5
    L10:
        r6 = r6 + 1;
        goto L3
    L12:
        return new Array2DRowFieldMatrix(getField(), r3, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public void multiplyEntry(int r3, int r4, T r5) {
        FieldElement r6 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r5, FieldElement.class, "com.obric.memorydata.plugin");
        checkRowIndex(r3);
        checkColumnIndex(r4);
        FieldElement[][] r2 = this.data;
        r2[r3][r4] = (FieldElement) ZeusTransformUtils.preCheckCast(r2[r3][r4].multiply(r6), FieldElement.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T[] operate(T[] r12) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r12.length != r1) goto L12;
        T[] r2 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(getField(), r0), FieldElement[].class, "com.obric.memorydata.plugin"));
        int r5 = 0;
    L5:
        if (r5 >= r0) goto L10;
        T[] r6 = this.data[r5];
        FieldElement r7 = (FieldElement) ZeusTransformUtils.preCheckCast(getField().getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r8 = 0;
    L7:
        if (r8 >= r1) goto L9;
        r7 = (FieldElement) ZeusTransformUtils.preCheckCast(r7.add(r6[r8].multiply(r12[r8])), FieldElement.class, "com.obric.memorydata.plugin");
        r8 = r8 + 1;
        goto L7
    L9:
        r2[r5] = r7;
        r5 = r5 + 1;
        goto L5
    L10:
        return r2;
    L12:
        throw new DimensionMismatchException(r12.length, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T[] preMultiply(T[] r11) {
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        if (r11.length != r0) goto L12;
        T[] r2 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(getField(), r1), FieldElement[].class, "com.obric.memorydata.plugin"));
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L10;
        FieldElement r6 = (FieldElement) ZeusTransformUtils.preCheckCast(getField().getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r7 = 0;
    L7:
        if (r7 >= r0) goto L9;
        r6 = (FieldElement) ZeusTransformUtils.preCheckCast(r6.add(this.data[r7][r5].multiply(r11[r7])), FieldElement.class, "com.obric.memorydata.plugin");
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setEntry(int r3, int r4, T r5) {
        FieldElement r6 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r5, FieldElement.class, "com.obric.memorydata.plugin");
        checkRowIndex(r3);
        checkColumnIndex(r4);
        ((T[][]) this.data)[r3][r4] = r6;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public void setSubMatrix(T[][] r7, int r8, int r9) {
        if (this.data == null) goto L5;
        super.setSubMatrix(r7, r8, r9);
        return;
    L5:
        if (r8 > 0) goto L26;
        if (r9 > 0) goto L24;
        if (r7.length == 0) goto L22;
        int r0 = r7[0].length;
        if (r0 == 0) goto L20;
        this.data = (T[][]) ((FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(getField(), r7.length, r0), FieldElement[][].class, "com.obric.memorydata.plugin"));
        int r2 = 0;
    L12:
        T[][] r3 = this.data;
        if (r2 >= r3.length) goto L31;
        if (r7[r2].length != r0) goto L18;
        System.arraycopy(r7[r2], 0, r3[r2 + r8], r9, r0);
        r2 = r2 + 1;
        goto L12
    L18:
        throw new DimensionMismatchException(r0, r7[r2].length);
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

    public Array2DRowFieldMatrix<T> subtract(Array2DRowFieldMatrix<T> r13) {
        checkSubtractionCompatible(r13);
        int r0 = getRowDimension();
        int r1 = getColumnDimension();
        FieldElement[][] r2 = (FieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(getField(), r0, r1), FieldElement[][].class, "com.obric.memorydata.plugin");
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L9;
        T[] r6 = this.data[r5];
        T[] r7 = r13.data[r5];
        FieldElement[] r8 = r2[r5];
        int r9 = 0;
    L5:
        if (r9 >= r1) goto L7;
        r8[r9] = (FieldElement) ZeusTransformUtils.preCheckCast(r6[r9].subtract(r7[r9]), FieldElement.class, "com.obric.memorydata.plugin");
        r9 = r9 + 1;
        goto L5
    L7:
        r5 = r5 + 1;
        goto L3
    L9:
        return new Array2DRowFieldMatrix(getField(), r2, false);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
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
        Object[] r3 = this.data[r2];
        r3[r1] = r11.visit(r2, r1, r3[r1]);
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return (T) r11.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T walkInColumnOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) {
        FieldMatrixChangingVisitor r13 = (FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        checkSubMatrixIndex(r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r11 > r12) goto L9;
        int r0 = r9;
    L5:
        if (r0 > r10) goto L7;
        Object[] r1 = this.data[r0];
        r1[r11] = r13.visit(r0, r11, r1[r11]);
        r0 = r0 + 1;
        goto L5
    L7:
        r11 = r11 + 1;
        goto L3
    L9:
        return (T) r13.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
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
        r11.visit(r2, r1, this.data[r2][r1]);
        r2 = r2 + 1;
        goto L5
    L7:
        r1 = r1 + 1;
        goto L3
    L9:
        return (T) r11.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T walkInColumnOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) {
        FieldMatrixPreservingVisitor r13 = (FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        checkSubMatrixIndex(r9, r10, r11, r12);
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
        return (T) r13.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r10) {
        FieldMatrixChangingVisitor r11 = (FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r11.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        Object[] r2 = this.data[r1];
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
        return (T) r11.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T walkInRowOrder(FieldMatrixChangingVisitor<T> r8, int r9, int r10, int r11, int r12) {
        FieldMatrixChangingVisitor r13 = (FieldMatrixChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, FieldMatrixChangingVisitor.class, "com.obric.memorydata.plugin");
        checkSubMatrixIndex(r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r9 > r10) goto L9;
        Object[] r0 = this.data[r9];
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
        return (T) r13.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r10) {
        FieldMatrixPreservingVisitor r11 = (FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r10, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        int r7 = getRowDimension();
        int r8 = getColumnDimension();
        r11.start(r7, r8, 0, r7 - 1, 0, r8 - 1);
        int r1 = 0;
    L3:
        if (r1 >= r7) goto L9;
        T[] r2 = this.data[r1];
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
        return (T) r11.end();
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public T walkInRowOrder(FieldMatrixPreservingVisitor<T> r8, int r9, int r10, int r11, int r12) {
        FieldMatrixPreservingVisitor r13 = (FieldMatrixPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r8, FieldMatrixPreservingVisitor.class, "com.obric.memorydata.plugin");
        checkSubMatrixIndex(r9, r10, r11, r12);
        r13.start(getRowDimension(), getColumnDimension(), r9, r10, r11, r12);
    L3:
        if (r9 > r10) goto L9;
        T[] r0 = this.data[r9];
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
        return (T) r13.end();
    }
}
