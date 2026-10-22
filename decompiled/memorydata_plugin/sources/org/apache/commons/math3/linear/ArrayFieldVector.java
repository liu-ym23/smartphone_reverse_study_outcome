package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class ArrayFieldVector<T extends FieldElement<T>> implements Serializable, FieldVector<T> {
    private static final long serialVersionUID = 7648186910365927050L;
    private T[] data;
    private final Field<T> field;

    public ArrayFieldVector(int r3, T r4) {
        FieldElement r5 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r4, FieldElement.class, "com.obric.memorydata.plugin");
        this(r5.getField(), r3);
        Arrays.fill(this.data, r5);
    }

    public ArrayFieldVector(Field<T> r3) {
        this((Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin"), 0);
    }

    public ArrayFieldVector(Field<T> r3, int r4) {
        Field<T> r5 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        this.field = r5;
        this.data = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r5, r4), FieldElement[].class, "com.obric.memorydata.plugin"));
    }

    public ArrayFieldVector(Field<T> r3, T[] r4) {
        Field<T> r5 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r4);
        this.field = r5;
        this.data = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(r4.clone(), FieldElement[].class, "com.obric.memorydata.plugin"));
    }

    public ArrayFieldVector(Field<T> r4, T[] r5, int r6, int r7) {
        Field<T> r8 = (Field) ZeusTransformUtils.wrapperContextForParams(r4, Field.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r5);
        int r2 = r6 + r7;
        if (r5.length < r2) goto L7;
        this.field = r8;
        T[] r9 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r8, r7), FieldElement[].class, "com.obric.memorydata.plugin"));
        this.data = r9;
        System.arraycopy(r5, r6, r9, 0, r7);
        return;
    L7:
        throw new NumberIsTooLargeException(Integer.valueOf(r2), Integer.valueOf(r5.length), true);
    }

    public ArrayFieldVector(Field<T> r3, T[] r4, boolean r5) {
        Field<T> r6 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r4);
        this.field = r6;
        if (r5 == false) goto L5;
        r4 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(r4.clone(), FieldElement[].class, "com.obric.memorydata.plugin"));
    L5:
        this.data = r4;
    }

    public ArrayFieldVector(Field<T> r5, T[] r6, T[] r7) {
        Field<T> r8 = (Field) ZeusTransformUtils.wrapperContextForParams(r5, Field.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r6);
        MathUtils.checkNotNull(r7);
        if ((r6.length + r7.length) == 0) goto L7;
        T[] r0 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r8, r6.length + r7.length), FieldElement[].class, "com.obric.memorydata.plugin"));
        this.data = r0;
        System.arraycopy(r6, 0, r0, 0, r6.length);
        System.arraycopy(r7, 0, this.data, r6.length, r7.length);
        this.field = r8;
        return;
    L7:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(ArrayFieldVector<T> r3) {
        MathUtils.checkNotNull(r3);
        this.field = r3.getField();
        this.data = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(r3.data.clone(), FieldElement[].class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public ArrayFieldVector(ArrayFieldVector<T> r1, ArrayFieldVector<T> r2) {
        this(r1, r2);
    }

    public ArrayFieldVector(ArrayFieldVector<T> r2, boolean r3) {
        MathUtils.checkNotNull(r2);
        this.field = r2.getField();
        T[] r4 = r2.data;
        if (r3 == false) goto L5;
        r4 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(r4.clone(), FieldElement[].class, "com.obric.memorydata.plugin"));
    L5:
        this.data = r4;
    }

    @Deprecated
    public ArrayFieldVector(ArrayFieldVector<T> r1, T[] r2) {
        this(r1, r2);
    }

    public ArrayFieldVector(FieldVector<T> r4) {
        FieldVector r5 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r4, FieldVector.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r5);
        Field<T> r0 = r5.getField();
        this.field = r0;
        this.data = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r0, r5.getDimension()), FieldElement[].class, "com.obric.memorydata.plugin"));
        int r1 = 0;
    L3:
        FieldElement[] r2 = (T[]) this.data;
        if (r1 >= r2.length) goto L6;
        r2[r1] = r5.getEntry(r1);
        r1 = r1 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(FieldVector<T> r5, FieldVector<T> r6) {
        FieldVector r7 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r5, FieldVector.class, "com.obric.memorydata.plugin");
        FieldVector r8 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r6, FieldVector.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r7);
        MathUtils.checkNotNull(r8);
        Field<T> r1 = r7.getField();
        this.field = r1;
        if (ZeusTransformUtils.instanceOf(r7, ArrayFieldVector.class) == false) goto L5;
        Object[] r9 = ((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r7, ArrayFieldVector.class, "com.obric.memorydata.plugin")).data;
    L7:
        if (ZeusTransformUtils.instanceOf(r8, ArrayFieldVector.class) == false) goto L9;
        Object[] r10 = ((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r8, ArrayFieldVector.class, "com.obric.memorydata.plugin")).data;
    L10:
        T[] r0 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r1, r9.length + r10.length), FieldElement[].class, "com.obric.memorydata.plugin"));
        this.data = r0;
        System.arraycopy(r9, 0, r0, 0, r9.length);
        System.arraycopy(r10, 0, this.data, r9.length, r10.length);
        return;
    L9:
        r10 = (T[]) r8.toArray();
        goto L10
    L5:
        r9 = (T[]) r7.toArray();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(FieldVector<T> r5, T[] r6) {
        FieldVector r7 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r5, FieldVector.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r7);
        MathUtils.checkNotNull(r6);
        Field<T> r1 = r7.getField();
        this.field = r1;
        if (ZeusTransformUtils.instanceOf(r7, ArrayFieldVector.class) == false) goto L5;
        Object[] r8 = ((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r7, ArrayFieldVector.class, "com.obric.memorydata.plugin")).data;
    L6:
        T[] r0 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r1, r8.length + r6.length), FieldElement[].class, "com.obric.memorydata.plugin"));
        this.data = r0;
        System.arraycopy(r8, 0, r0, 0, r8.length);
        System.arraycopy(r6, 0, this.data, r8.length, r6.length);
        return;
    L5:
        r8 = (T[]) r7.toArray();
        goto L6
    }

    public ArrayFieldVector(T[] r4) {
        MathUtils.checkNotNull(r4);
        this.field = r4[0].getField();     // Catch: ArrayIndexOutOfBoundsException -> L5
        this.data = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(r4.clone(), FieldElement[].class, "com.obric.memorydata.plugin"));     // Catch: ArrayIndexOutOfBoundsException -> L5
        return;
    L6:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(T[] r5, int r6, int r7) {
        MathUtils.checkNotNull(r5);
        int r1 = r6 + r7;
        if (r5.length < r1) goto L7;
        Field<T> r2 = r5[0].getField();
        this.field = r2;
        T[] r3 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r2, r7), FieldElement[].class, "com.obric.memorydata.plugin"));
        this.data = r3;
        System.arraycopy(r5, r6, r3, 0, r7);
        return;
    L7:
        throw new NumberIsTooLargeException(Integer.valueOf(r1), Integer.valueOf(r5.length), true);
    }

    @Deprecated
    public ArrayFieldVector(T[] r1, ArrayFieldVector<T> r2) {
        this(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArrayFieldVector(T[] r5, FieldVector<T> r6) {
        FieldVector r7 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r6, FieldVector.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r5);
        MathUtils.checkNotNull(r7);
        Field<T> r1 = r7.getField();
        this.field = r1;
        if (ZeusTransformUtils.instanceOf(r7, ArrayFieldVector.class) == false) goto L5;
        Object[] r8 = ((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r7, ArrayFieldVector.class, "com.obric.memorydata.plugin")).data;
    L6:
        T[] r0 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r1, r5.length + r8.length), FieldElement[].class, "com.obric.memorydata.plugin"));
        this.data = r0;
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r8, 0, this.data, r5.length, r8.length);
        return;
    L5:
        r8 = (T[]) r7.toArray();
        goto L6
    }

    public ArrayFieldVector(T[] r3, boolean r4) {
        MathUtils.checkNotNull(r3);
        if (r3.length == 0) goto L10;
        this.field = r3[0].getField();
        if (r4 == false) goto L7;
        r3 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(r3.clone(), FieldElement[].class, "com.obric.memorydata.plugin"));
    L7:
        this.data = r3;
        return;
    L10:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    public ArrayFieldVector(T[] r5, T[] r6) {
        MathUtils.checkNotNull(r5);
        MathUtils.checkNotNull(r6);
        if ((r5.length + r6.length) == 0) goto L7;
        T[] r0 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r5[0].getField(), r5.length + r6.length), FieldElement[].class, "com.obric.memorydata.plugin"));
        this.data = r0;
        System.arraycopy(r5, 0, r0, 0, r5.length);
        System.arraycopy(r6, 0, this.data, r5.length, r6.length);
        this.field = this.data[0].getField();
        return;
    L7:
        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT, new Object[0]);
    }

    private void checkIndex(int r4) {
        if (r4 < 0) goto L7;
        if (r4 >= getDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getDimension() - 1));
    }

    private void checkIndices(int r3, int r4) {
        int r2 = getDimension();
        if (r3 < 0) goto L14;
        if (r3 >= r2) goto L14;
        if (r4 < 0) goto L12;
        if (r4 >= r2) goto L12;
        if (r4 < r3) goto L10;
        return;
    L10:
        throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, Integer.valueOf(r4), Integer.valueOf(r3), false);
    L12:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r4), 0, Integer.valueOf(r2 - 1));
    L14:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r3), 0, Integer.valueOf(r2 - 1));
    }

    public ArrayFieldVector<T> add(ArrayFieldVector<T> r7) {
        checkVectorDimensions(r7.data.length);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L7;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].add(r7.data[r3]), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public FieldVector<T> add(FieldVector<T> r7) {
        FieldVector<T> r8 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r7, FieldVector.class, "com.obric.memorydata.plugin");
        return add((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r8, ArrayFieldVector.class, "com.obric.memorydata.plugin"));
    L5:
        checkVectorDimensions(r8);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L6:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L10;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].add(r8.getEntry(r3)), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L6
    L10:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public ArrayFieldVector<T> append(ArrayFieldVector<T> r2) {
        return new ArrayFieldVector(this, r2);
    }

    public FieldVector<T> append(T r5) {
        FieldElement r6 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r5, FieldElement.class, "com.obric.memorydata.plugin");
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length + 1), FieldElement[].class, "com.obric.memorydata.plugin");
        T[] r1 = this.data;
        System.arraycopy(r1, 0, r0, 0, r1.length);
        r0[this.data.length] = r6;
        return new ArrayFieldVector(this.field, r0, false);
    }

    public FieldVector<T> append(FieldVector<T> r3) {
        FieldVector r4 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r3, FieldVector.class, "com.obric.memorydata.plugin");
        return append((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r4, ArrayFieldVector.class, "com.obric.memorydata.plugin"));
    L6:
        return new ArrayFieldVector(this, new ArrayFieldVector(r4));
    }

    public void checkVectorDimensions(int r2) {
        if (this.data.length != r2) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(this.data.length, r2);
    }

    public void checkVectorDimensions(FieldVector<T> r3) {
        checkVectorDimensions(((FieldVector) ZeusTransformUtils.wrapperContextForParams(r3, FieldVector.class, "com.obric.memorydata.plugin")).getDimension());
    }

    public FieldVector<T> copy() {
        return new ArrayFieldVector(this, true);
    }

    public T dotProduct(ArrayFieldVector<T> r6) {
        checkVectorDimensions(r6.data.length);
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L3:
        T[] r3 = this.data;
        if (r1 >= r3.length) goto L6;
        r0 = (T) ZeusTransformUtils.preCheckCast(r0.add(r3[r1].multiply(r6.data[r1])), FieldElement.class, "com.obric.memorydata.plugin");
        r1 = r1 + 1;
        goto L3
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T dotProduct(FieldVector<T> r6) {
        FieldVector<T> r7 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r6, FieldVector.class, "com.obric.memorydata.plugin");
        return (T) dotProduct((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r7, ArrayFieldVector.class, "com.obric.memorydata.plugin"));
    L5:
        checkVectorDimensions(r7);
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        int r2 = 0;
    L6:
        T[] r3 = this.data;
        if (r2 >= r3.length) goto L9;
        r0 = (T) ZeusTransformUtils.preCheckCast(r0.add(r3[r2].multiply(r7.getEntry(r2))), FieldElement.class, "com.obric.memorydata.plugin");
        r2 = r2 + 1;
        goto L6
    L9:
        return r0;
    }

    public ArrayFieldVector<T> ebeDivide(ArrayFieldVector<T> r7) {
        checkVectorDimensions(r7.data.length);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L10;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].divide(r7.data[r3]), FieldElement.class, "com.obric.memorydata.plugin");     // Catch: MathArithmeticException -> L7
        r3 = r3 + 1;
    L8:
        throw new MathArithmeticException(LocalizedFormats.INDEX, new Object[]{Integer.valueOf(r3)});
    L10:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public FieldVector<T> ebeDivide(FieldVector<T> r7) {
        FieldVector<T> r8 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r7, FieldVector.class, "com.obric.memorydata.plugin");
        return ebeDivide((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r8, ArrayFieldVector.class, "com.obric.memorydata.plugin"));
    L5:
        checkVectorDimensions(r8);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L6:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L13;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].divide(r8.getEntry(r3)), FieldElement.class, "com.obric.memorydata.plugin");     // Catch: MathArithmeticException -> L10
        r3 = r3 + 1;
    L11:
        throw new MathArithmeticException(LocalizedFormats.INDEX, new Object[]{Integer.valueOf(r3)});
    L13:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public ArrayFieldVector<T> ebeMultiply(ArrayFieldVector<T> r7) {
        checkVectorDimensions(r7.data.length);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L7;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].multiply(r7.data[r3]), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public FieldVector<T> ebeMultiply(FieldVector<T> r7) {
        FieldVector<T> r8 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r7, FieldVector.class, "com.obric.memorydata.plugin");
        return ebeMultiply((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r8, ArrayFieldVector.class, "com.obric.memorydata.plugin"));
    L5:
        checkVectorDimensions(r8);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L6:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L10;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].multiply(r8.getEntry(r3)), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L6
    L10:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L20;
        return false;
    L20:
        FieldVector r7 = (FieldVector) ZeusTransformUtils.preCheckCast(r6, FieldVector.class, "com.obric.memorydata.plugin");     // Catch: ClassCastException -> L19
        if (this.data.length == r7.getDimension()) goto L11;
        return false;
    L11:
        int r2 = 0;
    L12:
        T[] r3 = this.data;     // Catch: ClassCastException -> L19
        if (r2 >= r3.length) goto L18;
        if (r3[r2].equals(r7.getEntry(r2)) == false) goto L16;
        r2 = r2 + 1;
        goto L12
    L16:
        return false;
    L18:
        return true;
    L19:
        return false;
    }

    public T[] getData() {
        return (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(this.data.clone(), FieldElement[].class, "com.obric.memorydata.plugin"));
    }

    public T[] getDataRef() {
        return this.data;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public int getDimension() {
        return this.data.length;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T getEntry(int r1) {
        return this.data[r1];
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public Field<T> getField() {
        return this.field;
    }

    public FieldVector<T> getSubVector(int r5, int r6) {
        if (r6 < 0) goto L9;
        ArrayFieldVector r0 = new ArrayFieldVector(this.field, r6);
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

    public int hashCode() {
        T[] r4 = this.data;
        int r0 = r4.length;
        int r1 = 3542;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1 = r1 ^ r4[r2].hashCode();
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public FieldVector<T> mapAdd(T r7) {
        FieldElement r8 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r7, FieldElement.class, "com.obric.memorydata.plugin");
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L7;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].add(r8), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAddToSelf(T r6) {
        FieldElement r7 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r6, FieldElement.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        FieldElement[] r2 = this.data;
        if (r0 >= r2.length) goto L6;
        r2[r0] = (FieldElement) ZeusTransformUtils.preCheckCast(r2[r0].add(r7), FieldElement.class, "com.obric.memorydata.plugin");
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    public FieldVector<T> mapDivide(T r7) {
        FieldElement r8 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r7, FieldElement.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r8);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L7;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].divide(r8), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivideToSelf(T r6) {
        FieldElement r7 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r6, FieldElement.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r7);
        int r0 = 0;
    L3:
        FieldElement[] r2 = this.data;
        if (r0 >= r2.length) goto L6;
        r2[r0] = (FieldElement) ZeusTransformUtils.preCheckCast(r2[r0].divide(r7), FieldElement.class, "com.obric.memorydata.plugin");
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    public FieldVector<T> mapInv() {
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        FieldElement r1 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getOne(), FieldElement.class, "com.obric.memorydata.plugin");
        int r4 = 0;
    L3:
        T[] r5 = this.data;
        if (r4 >= r5.length) goto L10;
        r0[r4] = (FieldElement) ZeusTransformUtils.preCheckCast(r1.divide(r5[r4]), FieldElement.class, "com.obric.memorydata.plugin");     // Catch: MathArithmeticException -> L7
        r4 = r4 + 1;
    L8:
        throw new MathArithmeticException(LocalizedFormats.INDEX, new Object[]{Integer.valueOf(r4)});
    L10:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInvToSelf() {
        FieldElement r0 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getOne(), FieldElement.class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L9;
        r4[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r0.divide(r4[r3]), FieldElement.class, "com.obric.memorydata.plugin");     // Catch: MathArithmeticException -> L7
        r3 = r3 + 1;
    L8:
        throw new MathArithmeticException(LocalizedFormats.INDEX, new Object[]{Integer.valueOf(r3)});
    L9:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiply(T r7) {
        FieldElement r8 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r7, FieldElement.class, "com.obric.memorydata.plugin");
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L7;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].multiply(r8), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiplyToSelf(T r6) {
        FieldElement r7 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r6, FieldElement.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        FieldElement[] r2 = this.data;
        if (r0 >= r2.length) goto L6;
        r2[r0] = (FieldElement) ZeusTransformUtils.preCheckCast(r2[r0].multiply(r7), FieldElement.class, "com.obric.memorydata.plugin");
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    public FieldVector<T> mapSubtract(T r7) {
        FieldElement r8 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r7, FieldElement.class, "com.obric.memorydata.plugin");
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L7;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].subtract(r8), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtractToSelf(T r6) {
        FieldElement r7 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r6, FieldElement.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L3:
        FieldElement[] r2 = this.data;
        if (r0 >= r2.length) goto L6;
        r2[r0] = (FieldElement) ZeusTransformUtils.preCheckCast(r2[r0].subtract(r7), FieldElement.class, "com.obric.memorydata.plugin");
        r0 = r0 + 1;
        goto L3
    L6:
        return this;
    }

    public FieldMatrix<T> outerProduct(ArrayFieldVector<T> r10) {
        int r0 = this.data.length;
        int r1 = r10.data.length;
        Array2DRowFieldMatrix r2 = new Array2DRowFieldMatrix(this.field, r0, r1);
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L8;
        int r5 = 0;
    L5:
        if (r5 >= r1) goto L7;
        r2.setEntry(r4, r5, (FieldElement) ZeusTransformUtils.preCheckCast(this.data[r4].multiply(r10.data[r5]), FieldElement.class, "com.obric.memorydata.plugin"));
        r5 = r5 + 1;
        goto L5
    L7:
        r4 = r4 + 1;
        goto L3
    L8:
        return r2;
    }

    public FieldMatrix<T> outerProduct(FieldVector<T> r10) {
        FieldVector r11 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r10, FieldVector.class, "com.obric.memorydata.plugin");
        return outerProduct((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r11, ArrayFieldVector.class, "com.obric.memorydata.plugin"));
    L5:
        int r0 = this.data.length;
        int r2 = r11.getDimension();
        Array2DRowFieldMatrix r3 = new Array2DRowFieldMatrix(this.field, r0, r2);
        int r5 = 0;
    L6:
        if (r5 >= r0) goto L11;
        int r6 = 0;
    L8:
        if (r6 >= r2) goto L10;
        r3.setEntry(r5, r6, (FieldElement) ZeusTransformUtils.preCheckCast(this.data[r5].multiply(r11.getEntry(r6)), FieldElement.class, "com.obric.memorydata.plugin"));
        r6 = r6 + 1;
        goto L8
    L10:
        r5 = r5 + 1;
        goto L6
    L11:
        return r3;
    }

    public ArrayFieldVector<T> projection(ArrayFieldVector<T> r3) {
        return (ArrayFieldVector) ZeusTransformUtils.preCheckCast(r3.mapMultiply((FieldElement) ZeusTransformUtils.preCheckCast(dotProduct(r3).divide(r3.dotProduct(r3)), FieldElement.class, "com.obric.memorydata.plugin")), ArrayFieldVector.class, "com.obric.memorydata.plugin");
    }

    public FieldVector<T> projection(FieldVector<T> r3) {
        FieldVector<T> r4 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r3, FieldVector.class, "com.obric.memorydata.plugin");
        return r4.mapMultiply((FieldElement) ZeusTransformUtils.preCheckCast(dotProduct(r4).divide(r4.dotProduct(r4)), FieldElement.class, "com.obric.memorydata.plugin"));
    }

    public void set(int r5, ArrayFieldVector<T> r6) {
        T[] r0 = r6.data;     // Catch: IndexOutOfBoundsException -> L4
        System.arraycopy(r0, 0, this.data, r5, r0.length);     // Catch: IndexOutOfBoundsException -> L4
        return;
    L4:
        checkIndex(r5);
        checkIndex((r5 + r6.data.length) - 1);
    }

    public void set(T r3) {
        FieldElement r4 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
        Arrays.fill(this.data, r4);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setEntry(int r3, T r4) {
        FieldElement r5 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r4, FieldElement.class, "com.obric.memorydata.plugin");
        ((T[]) this.data)[r3] = r5;     // Catch: IndexOutOfBoundsException -> L5
        return;
    L5:
        checkIndex(r3);
    }

    public void setSubVector(int r4, FieldVector<T> r5) {
        FieldVector r6 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r5, FieldVector.class, "com.obric.memorydata.plugin");
        set(r4, (ArrayFieldVector) ZeusTransformUtils.preCheckCast(r6, ArrayFieldVector.class, "com.obric.memorydata.plugin"));     // Catch: ClassCastException -> L5 IndexOutOfBoundsException -> L10
    L15:
        return;
    L10:
        checkIndex(r4);
        checkIndex((r4 + r6.getDimension()) - 1);
        return;
    L5:
        int r0 = r4;
    L7:
        if (r0 >= (r6.getDimension() + r4)) goto L16;
        ((T[]) this.data)[r0] = r6.getEntry(r0 - r4);     // Catch: IndexOutOfBoundsException -> L10
        r0 = r0 + 1;
        goto L7
    }

    public ArrayFieldVector<T> subtract(ArrayFieldVector<T> r7) {
        checkVectorDimensions(r7.data.length);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L3:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L7;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].subtract(r7.data[r3]), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L3
    L7:
        return new ArrayFieldVector(this.field, r0, false);
    }

    public FieldVector<T> subtract(FieldVector<T> r7) {
        FieldVector<T> r8 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r7, FieldVector.class, "com.obric.memorydata.plugin");
        return subtract((ArrayFieldVector) ZeusTransformUtils.preCheckCast(r8, ArrayFieldVector.class, "com.obric.memorydata.plugin"));
    L5:
        checkVectorDimensions(r8);
        FieldElement[] r0 = (FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.data.length), FieldElement[].class, "com.obric.memorydata.plugin");
        int r3 = 0;
    L6:
        T[] r4 = this.data;
        if (r3 >= r4.length) goto L10;
        r0[r3] = (FieldElement) ZeusTransformUtils.preCheckCast(r4[r3].subtract(r8.getEntry(r3)), FieldElement.class, "com.obric.memorydata.plugin");
        r3 = r3 + 1;
        goto L6
    L10:
        return new ArrayFieldVector(this.field, r0, false);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T[] toArray() {
        return (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(this.data.clone(), FieldElement[].class, "com.obric.memorydata.plugin"));
    }

    public T walkInDefaultOrder(FieldVectorChangingVisitor<T> r4) {
        FieldVectorChangingVisitor r5 = (FieldVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r4, FieldVectorChangingVisitor.class, "com.obric.memorydata.plugin");
        int r0 = getDimension();
        int r2 = 0;
        r5.start(r0, 0, r0 - 1);
    L3:
        if (r2 >= r0) goto L6;
        setEntry(r2, r5.visit(r2, getEntry(r2)));
        r2 = r2 + 1;
        goto L3
    L6:
        return (T) r5.end();
    }

    public T walkInDefaultOrder(FieldVectorChangingVisitor<T> r3, int r4, int r5) {
        FieldVectorChangingVisitor r6 = (FieldVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FieldVectorChangingVisitor.class, "com.obric.memorydata.plugin");
        checkIndices(r4, r5);
        r6.start(getDimension(), r4, r5);
    L3:
        if (r4 > r5) goto L6;
        setEntry(r4, r6.visit(r4, getEntry(r4)));
        r4 = r4 + 1;
        goto L3
    L6:
        return (T) r6.end();
    }

    public T walkInDefaultOrder(FieldVectorPreservingVisitor<T> r4) {
        FieldVectorPreservingVisitor r5 = (FieldVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r4, FieldVectorPreservingVisitor.class, "com.obric.memorydata.plugin");
        int r0 = getDimension();
        int r2 = 0;
        r5.start(r0, 0, r0 - 1);
    L3:
        if (r2 >= r0) goto L6;
        r5.visit(r2, getEntry(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return (T) r5.end();
    }

    public T walkInDefaultOrder(FieldVectorPreservingVisitor<T> r3, int r4, int r5) {
        FieldVectorPreservingVisitor r6 = (FieldVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FieldVectorPreservingVisitor.class, "com.obric.memorydata.plugin");
        checkIndices(r4, r5);
        r6.start(getDimension(), r4, r5);
    L3:
        if (r4 > r5) goto L6;
        r6.visit(r4, getEntry(r4));
        r4 = r4 + 1;
        goto L3
    L6:
        return (T) r6.end();
    }

    public T walkInOptimizedOrder(FieldVectorChangingVisitor<T> r3) {
        return (T) walkInDefaultOrder((FieldVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FieldVectorChangingVisitor.class, "com.obric.memorydata.plugin"));
    }

    public T walkInOptimizedOrder(FieldVectorChangingVisitor<T> r3, int r4, int r5) {
        return (T) walkInDefaultOrder((FieldVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FieldVectorChangingVisitor.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public T walkInOptimizedOrder(FieldVectorPreservingVisitor<T> r3) {
        return (T) walkInDefaultOrder((FieldVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FieldVectorPreservingVisitor.class, "com.obric.memorydata.plugin"));
    }

    public T walkInOptimizedOrder(FieldVectorPreservingVisitor<T> r3, int r4, int r5) {
        return (T) walkInDefaultOrder((FieldVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, FieldVectorPreservingVisitor.class, "com.obric.memorydata.plugin"), r4, r5);
    }
}
