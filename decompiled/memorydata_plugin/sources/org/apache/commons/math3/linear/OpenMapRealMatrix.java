package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.OpenIntToDoubleHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class OpenMapRealMatrix extends AbstractRealMatrix implements Serializable, SparseRealMatrix {
    private static final long serialVersionUID = -5962461716457143437L;
    private final int columns;
    private final OpenIntToDoubleHashMap entries;
    private final int rows;

    public OpenMapRealMatrix(int r5, int r6) {
        super(r5, r6);
        long r0 = ((long) r5) * ((long) r6);
        if (r0 >= 2147483647L) goto L7;
        this.rows = r5;
        this.columns = r6;
        this.entries = new OpenIntToDoubleHashMap(0.0d);
        return;
    L7:
        throw new NumberIsTooLargeException(Long.valueOf(r0), Integer.MAX_VALUE, false);
    }

    public OpenMapRealMatrix(OpenMapRealMatrix r2) {
        this.rows = r2.rows;
        this.columns = r2.columns;
        this.entries = new OpenIntToDoubleHashMap(r2.entries);
    }

    private int computeKey(int r1, int r2) {
        return (r1 * this.columns) + r2;
    }

    public OpenMapRealMatrix add(OpenMapRealMatrix r8) {
        MatrixUtils.checkAdditionCompatible(this, r8);
        OpenMapRealMatrix r0 = new OpenMapRealMatrix(this);
        OpenIntToDoubleHashMap.Iterator r9 = r8.entries.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r9.advance();
        int r1 = r9.key() / this.columns;
        int r2 = r9.key() - (this.columns * r1);
        r0.setEntry(r1, r2, getEntry(r1, r2) + r9.value());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public void addToEntry(int r3, int r4, double r5) {
        MatrixUtils.checkRowIndex(this, r3);
        MatrixUtils.checkColumnIndex(this, r4);
        int r6 = computeKey(r3, r4);
        double r0 = this.entries.get(r6) + r5;
        OpenIntToDoubleHashMap r2 = this.entries;
        if (r0 != 0.0d) goto L5;
        r2.remove(r6);
        return;
    L5:
        r2.put(r6, r0);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public OpenMapRealMatrix copy() {
        return new OpenMapRealMatrix(this);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public /* bridge */ /* synthetic */ RealMatrix copy() {
        return copy();
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public OpenMapRealMatrix createMatrix(int r1, int r2) {
        return new OpenMapRealMatrix(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public /* bridge */ /* synthetic */ RealMatrix createMatrix(int r1, int r2) {
        return createMatrix(r1, r2);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getColumnDimension() {
        return this.columns;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public double getEntry(int r2, int r3) {
        MatrixUtils.checkRowIndex(this, r2);
        MatrixUtils.checkColumnIndex(this, r3);
        return this.entries.get(computeKey(r2, r3));
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealLinearOperator, org.apache.commons.math3.linear.AnyMatrix
    public int getRowDimension() {
        return this.rows;
    }

    public OpenMapRealMatrix multiply(OpenMapRealMatrix r15) {
        MatrixUtils.checkMultiplicationCompatible(this, r15);
        int r0 = r15.getColumnDimension();
        OpenMapRealMatrix r1 = new OpenMapRealMatrix(this.rows, r0);
        OpenIntToDoubleHashMap.Iterator r2 = this.entries.iterator();
    L4:
        if (r2.hasNext() == false) goto L14;
        r2.advance();
        double r3 = r2.value();
        int r5 = r2.key();
        int r6 = this.columns;
        int r7 = r5 / r6;
        int r8 = r5 % r6;
        int r9 = 0;
    L6:
        if (r9 >= r0) goto L4;
        int r10 = r15.computeKey(r8, r9);
        if (r15.entries.containsKey(r10) == false) goto L13;
        int r11 = r1.computeKey(r7, r9);
        double r12 = r1.entries.get(r11) + (r15.entries.get(r10) * r3);
        if (r12 != 0.0d) goto L12;
        r1.entries.remove(r11);
        goto L13
    L12:
        r1.entries.put(r11, r12);
    L13:
        r9 = r9 + 1;
        goto L6
    L14:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public RealMatrix multiply(RealMatrix r11) {
        RealMatrix r12 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r11, RealMatrix.class, "com.obric.memorydata.plugin");
        return multiply((OpenMapRealMatrix) ZeusTransformUtils.preCheckCast(r12, OpenMapRealMatrix.class, "com.obric.memorydata.plugin"));
    L5:
        MatrixUtils.checkMultiplicationCompatible(this, r12);
        int r0 = r12.getColumnDimension();
        BlockRealMatrix r1 = new BlockRealMatrix(this.rows, r0);
        OpenIntToDoubleHashMap.Iterator r2 = this.entries.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        r2.advance();
        double r3 = r2.value();
        int r5 = r2.key();
        int r6 = this.columns;
        int r7 = r5 / r6;
        int r8 = r5 % r6;
        int r9 = 0;
    L9:
        if (r9 >= r0) goto L7;
        r1.addToEntry(r7, r9, r12.getEntry(r8, r9) * r3);
        r9 = r9 + 1;
        goto L9
    L11:
        return r1;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public void multiplyEntry(int r3, int r4, double r5) {
        MatrixUtils.checkRowIndex(this, r3);
        MatrixUtils.checkColumnIndex(this, r4);
        int r6 = computeKey(r3, r4);
        double r0 = this.entries.get(r6) * r5;
        OpenIntToDoubleHashMap r2 = this.entries;
        if (r0 != 0.0d) goto L5;
        r2.remove(r6);
        return;
    L5:
        r2.put(r6, r0);
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix, org.apache.commons.math3.linear.RealMatrix
    public void setEntry(int r3, int r4, double r5) {
        MatrixUtils.checkRowIndex(this, r3);
        MatrixUtils.checkColumnIndex(this, r4);
        if (r5 != 0.0d) goto L5;
        this.entries.remove(computeKey(r3, r4));
        return;
    L5:
        this.entries.put(computeKey(r3, r4), r5);
    }

    public OpenMapRealMatrix subtract(OpenMapRealMatrix r8) {
        MatrixUtils.checkAdditionCompatible(this, r8);
        OpenMapRealMatrix r0 = new OpenMapRealMatrix(this);
        OpenIntToDoubleHashMap.Iterator r9 = r8.entries.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r9.advance();
        int r1 = r9.key() / this.columns;
        int r2 = r9.key() - (this.columns * r1);
        r0.setEntry(r1, r2, getEntry(r1, r2) - r9.value());
        goto L4
    L6:
        return r0;
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public OpenMapRealMatrix subtract(RealMatrix r4) {
        RealMatrix r5 = (RealMatrix) ZeusTransformUtils.wrapperContextForParams(r4, RealMatrix.class, "com.obric.memorydata.plugin");
        return subtract((OpenMapRealMatrix) ZeusTransformUtils.preCheckCast(r5, OpenMapRealMatrix.class, "com.obric.memorydata.plugin"));
    L6:
        return (OpenMapRealMatrix) ZeusTransformUtils.preCheckCast(super.subtract(r5), OpenMapRealMatrix.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.commons.math3.linear.AbstractRealMatrix
    public /* synthetic */ RealMatrix subtract(RealMatrix r3) {
        return subtract((RealMatrix) ZeusTransformUtils.wrapperContextForParams(r3, RealMatrix.class, "com.obric.memorydata.plugin"));
    }
}
