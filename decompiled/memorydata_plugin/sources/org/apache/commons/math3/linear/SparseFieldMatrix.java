package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class SparseFieldMatrix<T extends FieldElement<T>> extends AbstractFieldMatrix<T> {
    private final int columns;
    private final OpenIntToFieldHashMap<T> entries;
    private final int rows;

    public SparseFieldMatrix(Field<T> r3, int r4, int r5) {
        Field r6 = (Field) ZeusTransformUtils.wrapperContextForParams(r3, Field.class, "com.obric.memorydata.plugin");
        super(r6, r4, r5);
        this.rows = r4;
        this.columns = r5;
        this.entries = new OpenIntToFieldHashMap(r6);
    }

    public SparseFieldMatrix(SparseFieldMatrix<T> r4) {
        super(r4.getField(), r4.getRowDimension(), r4.getColumnDimension());
        this.rows = r4.getRowDimension();
        this.columns = r4.getColumnDimension();
        this.entries = new OpenIntToFieldHashMap(r4.entries);
    }

    private int computeKey(int r1, int r2) {
        return (r1 * this.columns) + r2;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public void addToEntry(int r3, int r4, T r5) {
        FieldElement r6 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r5, FieldElement.class, "com.obric.memorydata.plugin");
        checkRowIndex(r3);
        checkColumnIndex(r4);
        int r7 = computeKey(r3, r4);
        FieldElement r8 = (FieldElement) ZeusTransformUtils.preCheckCast(this.entries.get(r7).add(r6), FieldElement.class, "com.obric.memorydata.plugin");
        boolean r9 = ((FieldElement) ZeusTransformUtils.preCheckCast(getField().getZero(), FieldElement.class, "com.obric.memorydata.plugin")).equals(r8);
        OpenIntToFieldHashMap<T> r2 = this.entries;
        if (r9 == false) goto L5;
        r2.remove(r7);
        return;
    L5:
        r2.put(r7, r8);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public FieldMatrix<T> copy() {
        return new SparseFieldMatrix(this);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public FieldMatrix<T> createMatrix(int r2, int r3) {
        return new SparseFieldMatrix(getField(), r2, r3);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public T getEntry(int r2, int r3) {
        checkRowIndex(r2);
        checkColumnIndex(r3);
        return (T) this.entries.get(computeKey(r2, r3));
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix
    public void multiplyEntry(int r3, int r4, T r5) {
        FieldElement r6 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r5, FieldElement.class, "com.obric.memorydata.plugin");
        checkRowIndex(r3);
        checkColumnIndex(r4);
        int r7 = computeKey(r3, r4);
        FieldElement r8 = (FieldElement) ZeusTransformUtils.preCheckCast(this.entries.get(r7).multiply(r6), FieldElement.class, "com.obric.memorydata.plugin");
        boolean r9 = ((FieldElement) ZeusTransformUtils.preCheckCast(getField().getZero(), FieldElement.class, "com.obric.memorydata.plugin")).equals(r8);
        OpenIntToFieldHashMap<T> r2 = this.entries;
        if (r9 == false) goto L5;
        r2.remove(r7);
        return;
    L5:
        r2.put(r7, r8);
    }

    @Override // org.apache.commons.math3.linear.AbstractFieldMatrix, org.apache.commons.math3.linear.FieldMatrix
    public void setEntry(int r4, int r5, T r6) {
        FieldElement r7 = (FieldElement) ZeusTransformUtils.wrapperContextForParams(r6, FieldElement.class, "com.obric.memorydata.plugin");
        checkRowIndex(r4);
        checkColumnIndex(r5);
        if (((FieldElement) ZeusTransformUtils.preCheckCast(getField().getZero(), FieldElement.class, "com.obric.memorydata.plugin")).equals(r7) == false) goto L5;
        this.entries.remove(computeKey(r4, r5));
        return;
    L5:
        this.entries.put(computeKey(r4, r5), r7);
    }
}
