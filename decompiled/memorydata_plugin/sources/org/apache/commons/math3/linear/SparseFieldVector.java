package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class SparseFieldVector<T extends FieldElement<T>> implements Serializable, FieldVector<T> {
    private static final long serialVersionUID = 7841233292190413362L;
    private final OpenIntToFieldHashMap<T> entries;
    private final Field<T> field;
    private final int virtualSize;

    public SparseFieldVector(Field<T> r3) {
        this((Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin"), 0);
    }

    public SparseFieldVector(Field<T> r3, int r4) {
        Field<T> r5 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        this.field = r5;
        this.virtualSize = r4;
        this.entries = new OpenIntToFieldHashMap(r5);
    }

    public SparseFieldVector(Field<T> r3, int r4, int r5) {
        Field<T> r6 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        this.field = r6;
        this.virtualSize = r4;
        this.entries = new OpenIntToFieldHashMap(r6, r5);
    }

    public SparseFieldVector(Field<T> r3, T[] r4) {
        Field<T> r5 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r4);
        this.field = r5;
        this.virtualSize = r4.length;
        this.entries = new OpenIntToFieldHashMap(r5);
        int r6 = 0;
    L4:
        if (r6 >= r4.length) goto L6;
        T r0 = r4[r6];
        this.entries.put(r6, r0);
        r6 = r6 + 1;
        goto L4
    }

    public SparseFieldVector(SparseFieldVector<T> r2) {
        this.field = r2.field;
        this.virtualSize = r2.getDimension();
        this.entries = new OpenIntToFieldHashMap(r2.getEntries());
    }

    public SparseFieldVector(SparseFieldVector<T> r2, int r3) {
        this.field = r2.field;
        this.virtualSize = r2.getDimension() + r3;
        this.entries = new OpenIntToFieldHashMap(r2.entries);
    }

    private void checkIndex(int r3) {
        if (r3 < 0) goto L7;
        if (r3 >= getDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(Integer.valueOf(r3), 0, Integer.valueOf(getDimension() - 1));
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

    private OpenIntToFieldHashMap<T> getEntries() {
        return this.entries;
    }

    public FieldVector<T> add(FieldVector<T> r7) {
        FieldVector r8 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r7, FieldVector.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, SparseFieldVector.class) == true) goto L5;
        int r0 = r8.getDimension();
        checkVectorDimensions(r0);
        SparseFieldVector r1 = new SparseFieldVector(this.field, getDimension());
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L9;
        r1.setEntry(r3, (FieldElement) ZeusTransformUtils.preCheckCast(r8.getEntry(r3).add(getEntry(r3)), FieldElement.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return add((SparseFieldVector) ZeusTransformUtils.preCheckCast(r8, SparseFieldVector.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector<T> add(SparseFieldVector<T> r6) {
        checkVectorDimensions(r6.getDimension());
        SparseFieldVector r0 = (SparseFieldVector) ZeusTransformUtils.preCheckCast(copy(), SparseFieldVector.class, "com.obric.memorydata.plugin");
        OpenIntToFieldHashMap<T>.Iterator r7 = r6.getEntries().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        r7.advance();
        int r1 = r7.key();
        FieldElement r3 = r7.value();
        if (this.entries.containsKey(r1) == false) goto L8;
        r3 = (FieldElement) ZeusTransformUtils.preCheckCast(this.entries.get(r1).add(r3), FieldElement.class, "com.obric.memorydata.plugin");
    L8:
        r0.setEntry(r1, r3);
        goto L4
    L9:
        return r0;
    }

    public FieldVector<T> append(T r3) {
        FieldElement r4 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r4);
        SparseFieldVector r0 = new SparseFieldVector(this, 1);
        r0.setEntry(this.virtualSize, r4);
        return r0;
    }

    public FieldVector<T> append(FieldVector<T> r6) {
        FieldVector r7 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r6, FieldVector.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, SparseFieldVector.class) == true) goto L5;
        int r0 = r7.getDimension();
        SparseFieldVector r1 = new SparseFieldVector(this, r0);
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1.setEntry(this.virtualSize + r2, r7.getEntry(r2));
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return append((SparseFieldVector) ZeusTransformUtils.preCheckCast(r7, SparseFieldVector.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector<T> append(SparseFieldVector<T> r4) {
        SparseFieldVector r0 = new SparseFieldVector(this, r4.getDimension());
        OpenIntToFieldHashMap<T>.Iterator r5 = r4.entries.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.advance();
        r0.setEntry(r5.key() + this.virtualSize, r5.value());
        goto L4
    L6:
        return r0;
    }

    public void checkVectorDimensions(int r2) {
        if (getDimension() != r2) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(getDimension(), r2);
    }

    public FieldVector<T> copy() {
        return new SparseFieldVector(this);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T dotProduct(FieldVector<T> r5) {
        FieldVector r6 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r5, FieldVector.class, "com.obric.memorydata.plugin");
        checkVectorDimensions(r6.getDimension());
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        OpenIntToFieldHashMap<T>.Iterator r4 = this.entries.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r4.advance();
        r0 = (T) ZeusTransformUtils.preCheckCast(r0.add(r6.getEntry(r4.key()).multiply(r4.value())), FieldElement.class, "com.obric.memorydata.plugin");
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FieldVector<T> ebeDivide(FieldVector<T> r6) {
        FieldVector r7 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r6, FieldVector.class, "com.obric.memorydata.plugin");
        checkVectorDimensions(r7.getDimension());
        SparseFieldVector r0 = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator r5 = r0.entries.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.advance();
        r0.setEntry(r5.key(), (FieldElement) ZeusTransformUtils.preCheckCast(r5.value().divide(r7.getEntry(r5.key())), FieldElement.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FieldVector<T> ebeMultiply(FieldVector<T> r6) {
        FieldVector r7 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r6, FieldVector.class, "com.obric.memorydata.plugin");
        checkVectorDimensions(r7.getDimension());
        SparseFieldVector r0 = new SparseFieldVector(this);
        OpenIntToFieldHashMap<T>.Iterator r5 = r0.entries.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.advance();
        r0.setEntry(r5.key(), (FieldElement) ZeusTransformUtils.preCheckCast(r5.value().multiply(r7.getEntry(r5.key())), FieldElement.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, SparseFieldVector.class) == true) goto L8;
        return false;
    L8:
        SparseFieldVector r7 = (SparseFieldVector) ZeusTransformUtils.preCheckCast(r6, SparseFieldVector.class, "com.obric.memorydata.plugin");
        Field<T> r0 = this.field;
        if (r0 != null) goto L14;
        if (r7.field == null) goto L17;
        return false;
    L17:
        if (this.virtualSize == r7.virtualSize) goto L19;
        return false;
    L19:
        OpenIntToFieldHashMap<T>.Iterator r1 = this.entries.iterator();
    L21:
        if (r1.hasNext() == false) goto L25;
        r1.advance();
        if (r7.getEntry(r1.key()).equals(r1.value()) == true) goto L21;
        return false;
    L25:
        OpenIntToFieldHashMap<T>.Iterator r8 = r7.getEntries().iterator();
    L27:
        if (r8.hasNext() == false) goto L31;
        r8.advance();
        if (r8.value().equals(getEntry(r8.key())) == true) goto L27;
        return false;
    L31:
        return true;
    L14:
        if (r0.equals(r7.field) == true) goto L17;
        return false;
    }

    @Deprecated
    public T[] getData() {
        return (T[]) toArray();
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public int getDimension() {
        return this.virtualSize;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public T getEntry(int r1) {
        checkIndex(r1);
        return (T) this.entries.get(r1);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public Field<T> getField() {
        return this.field;
    }

    public FieldVector<T> getSubVector(int r4, int r5) {
        if (r5 < 0) goto L12;
        checkIndex(r4);
        int r0 = r4 + r5;
        checkIndex(r0 - 1);
        SparseFieldVector r1 = new SparseFieldVector(this.field, r5);
        OpenIntToFieldHashMap<T>.Iterator r3 = this.entries.iterator();
    L5:
        if (r3.hasNext() == false) goto L10;
        r3.advance();
        int r6 = r3.key();
        if (r6 < r4) goto L5;
        if (r6 >= r0) goto L5;
        r1.setEntry(r6 - r4, r3.value());
        goto L5
    L10:
        return r1;
    L12:
        throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, Integer.valueOf(r5));
    }

    public int hashCode() {
        Field<T> r0 = this.field;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((r1 + 31) * 31) + this.virtualSize;
        OpenIntToFieldHashMap<T>.Iterator r3 = this.entries.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r3.advance();
        int r4 = r2 * 31;
        r2 = r4 + r3.value().hashCode();
        goto L8
    L10:
        return r2;
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public FieldVector<T> mapAdd(T r3) {
        FieldElement r4 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
        return copy().mapAddToSelf(r4);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapAddToSelf(T r5) {
        FieldElement r6 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r5, FieldElement.class, "com.obric.memorydata.plugin");
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L6;
        setEntry(r0, (FieldElement) ZeusTransformUtils.preCheckCast(getEntry(r0).add(r6), FieldElement.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L4
    L6:
        return this;
    }

    public FieldVector<T> mapDivide(T r3) {
        FieldElement r4 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
        return copy().mapDivideToSelf(r4);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapDivideToSelf(T r7) {
        FieldElement r8 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r7, FieldElement.class, "com.obric.memorydata.plugin");
        OpenIntToFieldHashMap<T>.Iterator r0 = this.entries.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.advance();
        this.entries.put(r0.key(), (FieldElement) ZeusTransformUtils.preCheckCast(r0.value().divide(r8), FieldElement.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return this;
    }

    public FieldVector<T> mapInv() {
        return copy().mapInvToSelf();
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapInvToSelf() {
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L6;
        setEntry(r0, (FieldElement) ZeusTransformUtils.preCheckCast(((FieldElement) ZeusTransformUtils.preCheckCast(this.field.getOne(), FieldElement.class, "com.obric.memorydata.plugin")).divide(getEntry(r0)), FieldElement.class, "com.obric.memorydata.plugin"));
        r0 = r0 + 1;
        goto L4
    L6:
        return this;
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiply(T r3) {
        FieldElement r4 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
        return copy().mapMultiplyToSelf(r4);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapMultiplyToSelf(T r7) {
        FieldElement r8 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r7, FieldElement.class, "com.obric.memorydata.plugin");
        OpenIntToFieldHashMap<T>.Iterator r0 = this.entries.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.advance();
        this.entries.put(r0.key(), (FieldElement) ZeusTransformUtils.preCheckCast(r0.value().multiply(r8), FieldElement.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return this;
    }

    public FieldVector<T> mapSubtract(T r3) {
        FieldElement r4 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
        return copy().mapSubtractToSelf(r4);
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public FieldVector<T> mapSubtractToSelf(T r4) {
        FieldElement r5 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r4, FieldElement.class, "com.obric.memorydata.plugin");
        return mapAddToSelf((FieldElement) ZeusTransformUtils.preCheckCast(((FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin")).subtract(r5), FieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldMatrix<T> outerProduct(FieldVector<T> r9) {
        FieldVector r10 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r9, FieldVector.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r10, SparseFieldVector.class) == true) goto L5;
        int r0 = r10.getDimension();
        SparseFieldMatrix r1 = new SparseFieldMatrix(this.field, this.virtualSize, r0);
        OpenIntToFieldHashMap<T>.Iterator r8 = this.entries.iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        r8.advance();
        int r3 = r8.key();
        FieldElement r4 = r8.value();
        int r5 = 0;
    L10:
        if (r5 >= r0) goto L8;
        r1.setEntry(r3, r5, (FieldElement) ZeusTransformUtils.preCheckCast(r4.multiply(r10.getEntry(r5)), FieldElement.class, "com.obric.memorydata.plugin"));
        r5 = r5 + 1;
        goto L10
    L12:
        return r1;
    L5:
        return outerProduct((SparseFieldVector) ZeusTransformUtils.preCheckCast(r10, SparseFieldVector.class, "com.obric.memorydata.plugin"));
    }

    public FieldMatrix<T> outerProduct(SparseFieldVector<T> r8) {
        int r0 = r8.getDimension();
        SparseFieldMatrix r1 = new SparseFieldMatrix(this.field, this.virtualSize, r0);
        OpenIntToFieldHashMap<T>.Iterator r7 = this.entries.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        r7.advance();
        OpenIntToFieldHashMap<T>.Iterator r2 = r8.entries.iterator();
    L7:
        if (r2.hasNext() == false) goto L4;
        r2.advance();
        r1.setEntry(r7.key(), r2.key(), (FieldElement) ZeusTransformUtils.preCheckCast(r7.value().multiply(r2.value()), FieldElement.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        return r1;
    }

    public FieldVector<T> projection(FieldVector<T> r3) {
        FieldVector<T> r4 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r3, FieldVector.class, "com.obric.memorydata.plugin");
        checkVectorDimensions(r4.getDimension());
        return r4.mapMultiply((FieldElement) ZeusTransformUtils.preCheckCast(dotProduct(r4).divide(r4.dotProduct(r4)), FieldElement.class, "com.obric.memorydata.plugin"));
    }

    public void set(T r3) {
        FieldElement r4 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r3, FieldElement.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r4);
        int r0 = 0;
    L4:
        if (r0 >= this.virtualSize) goto L6;
        setEntry(r0, r4);
        r0 = r0 + 1;
        goto L4
    }

    @Override // org.apache.commons.math3.linear.FieldVector
    public void setEntry(int r3, T r4) {
        FieldElement r5 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r4, FieldElement.class, "com.obric.memorydata.plugin");
        MathUtils.checkNotNull(r5);
        checkIndex(r3);
        this.entries.put(r3, r5);
    }

    public void setSubVector(int r5, FieldVector<T> r6) {
        FieldVector r7 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r6, FieldVector.class, "com.obric.memorydata.plugin");
        checkIndex(r5);
        checkIndex((r7.getDimension() + r5) - 1);
        int r0 = r7.getDimension();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        setEntry(r1 + r5, r7.getEntry(r1));
        r1 = r1 + 1;
        goto L3
    }

    public FieldVector<T> subtract(FieldVector<T> r7) {
        FieldVector r8 = (FieldVector) ZeusTransformUtils.wrapperContextForParams(r7, FieldVector.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, SparseFieldVector.class) == true) goto L5;
        int r0 = r8.getDimension();
        checkVectorDimensions(r0);
        SparseFieldVector r1 = new SparseFieldVector(this);
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L13;
        if (this.entries.containsKey(r3) == false) goto L11;
        FieldElement r4 = this.entries.get(r3);
    L12:
        r1.setEntry(r3, (FieldElement) ZeusTransformUtils.preCheckCast(r4.subtract(r8.getEntry(r3)), FieldElement.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L7
    L11:
        r4 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        goto L12
    L13:
        return r1;
    L5:
        return subtract((SparseFieldVector) ZeusTransformUtils.preCheckCast(r8, SparseFieldVector.class, "com.obric.memorydata.plugin"));
    }

    public SparseFieldVector<T> subtract(SparseFieldVector<T> r6) {
        checkVectorDimensions(r6.getDimension());
        SparseFieldVector<T> r0 = (SparseFieldVector) ZeusTransformUtils.preCheckCast(copy(), SparseFieldVector.class, "com.obric.memorydata.plugin");
        OpenIntToFieldHashMap<T>.Iterator r7 = r6.getEntries().iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        r7.advance();
        int r1 = r7.key();
        if (this.entries.containsKey(r1) == false) goto L8;
        FieldElement r3 = this.entries.get(r1);
    L9:
        r0.setEntry(r1, (FieldElement) ZeusTransformUtils.preCheckCast(r3.subtract(r7.value()), FieldElement.class, "com.obric.memorydata.plugin"));
        goto L4
    L8:
        r3 = (FieldElement) ZeusTransformUtils.preCheckCast(this.field.getZero(), FieldElement.class, "com.obric.memorydata.plugin");
        goto L9
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.math3.linear.FieldVector
    public T[] toArray() {
        T[] r0 = (T[]) ((FieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.field, this.virtualSize), FieldElement[].class, "com.obric.memorydata.plugin"));
        OpenIntToFieldHashMap<T>.Iterator r3 = this.entries.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.advance();
        r0[r3.key()] = r3.value();
        goto L4
    L6:
        return r0;
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
