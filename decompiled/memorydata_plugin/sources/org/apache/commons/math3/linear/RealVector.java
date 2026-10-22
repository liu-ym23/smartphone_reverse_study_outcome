package org.apache.commons.math3.linear;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.commons.math3.analysis.function.Divide;
import org.apache.commons.math3.analysis.function.Multiply;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public abstract class RealVector {

    protected class Entry {
        private int index;
        final /* synthetic */ RealVector this$0;

        public Entry(RealVector r1) {
            this.this$0 = r1;
            setIndex(0);
        }

        public int getIndex() {
            return this.index;
        }

        public double getValue() {
            return this.this$0.getEntry(getIndex());
        }

        public void setIndex(int r1) {
            this.index = r1;
        }

        public void setValue(double r2) {
            this.this$0.setEntry(getIndex(), r2);
        }
    }

    protected class SparseEntryIterator implements Iterator<Entry> {
        private Entry current;
        private final int dim;
        private Entry next;
        final /* synthetic */ RealVector this$0;

        public SparseEntryIterator(RealVector r5) {
            this.this$0 = r5;
            this.dim = r5.getDimension();
            this.current = new Entry(r5);
            Entry r0 = new Entry(r5);
            this.next = r0;
            if (r0.getValue() != 0.0d) goto L6;
            advance(this.next);
            return;
        }

        public void advance(Entry r5) {
            if (r5 != null) goto L4;
            return;
        L4:
            r5.setIndex(r5.getIndex() + 1);
            if (r5.getIndex() >= this.dim) goto L9;
            if (r5.getValue() == 0.0d) goto L4;
        L9:
            if (r5.getIndex() < this.dim) goto L15;
            r5.setIndex(-1);
            return;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.next.getIndex() < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Entry next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public Entry next2() {
            int r0 = this.next.getIndex();
            if (r0 < 0) goto L7;
            this.current.setIndex(r0);
            advance(this.next);
            return this.current;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new MathUnsupportedOperationException();
        }
    }

    public RealVector() {
    }

    public static RealVector unmodifiableRealVector(final RealVector r1) {
        return new AnonymousClass2(r1);
    }

    public RealVector add(RealVector r7) {
        checkVectorDimensions(r7);
        RealVector r8 = r7.copy();
        Iterator<Entry> r6 = iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Entry r0 = (Entry) ZeusTransformUtils.preCheckCast(r6.next(), Entry.class, "com.obric.memorydata.plugin");
        int r1 = r0.getIndex();
        r8.setEntry(r1, r0.getValue() + r8.getEntry(r1));
        goto L4
    L6:
        return r8;
    }

    public void addToEntry(int r3, double r4) {
        setEntry(r3, getEntry(r3) + r4);
    }

    public abstract RealVector append(double r1);

    public abstract RealVector append(RealVector r1);

    public void checkIndex(int r4) {
        if (r4 < 0) goto L7;
        if (r4 >= getDimension()) goto L7;
        return;
    L7:
        throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(r4), 0, Integer.valueOf(getDimension() - 1));
    }

    public void checkIndices(int r3, int r4) {
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

    public void checkVectorDimensions(int r2) {
        int r1 = getDimension();
        if (r1 != r2) goto L6;
        return;
    L6:
        throw new DimensionMismatchException(r1, r2);
    }

    public void checkVectorDimensions(RealVector r1) {
        checkVectorDimensions(r1.getDimension());
    }

    public RealVector combine(double r7, double r9, RealVector r11) {
        return copy().combineToSelf(r7, r9, r11);
    }

    public RealVector combineToSelf(double r6, double r8, RealVector r10) {
        checkVectorDimensions(r10);
        int r0 = 0;
    L4:
        if (r0 >= getDimension()) goto L6;
        double r1 = getEntry(r0);
        setEntry(r0, (r1 * r6) + (r10.getEntry(r0) * r8));
        r0 = r0 + 1;
        goto L4
    L6:
        return this;
    }

    public abstract RealVector copy();

    public double cosine(RealVector r8) {
        double r0 = getNorm();
        double r2 = r8.getNorm();
        if (r0 == 0.0d) goto L9;
        if (r2 == 0.0d) goto L9;
        return dotProduct(r8) / (r0 * r2);
    L9:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public double dotProduct(RealVector r9) {
        checkVectorDimensions(r9);
        int r0 = getDimension();
        double r1 = 0.0d;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1 = r1 + (getEntry(r3) * r9.getEntry(r3));
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public abstract RealVector ebeDivide(RealVector r1);

    public abstract RealVector ebeMultiply(RealVector r1);

    public boolean equals(Object r1) {
        throw new MathUnsupportedOperationException();
    }

    public abstract int getDimension();

    public double getDistance(RealVector r8) {
        checkVectorDimensions(r8);
        Iterator<Entry> r7 = iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L7;
        Entry r2 = (Entry) ZeusTransformUtils.preCheckCast(r7.next(), Entry.class, "com.obric.memorydata.plugin");
        double r3 = r2.getValue() - r8.getEntry(r2.getIndex());
        r0 = r0 + (r3 * r3);
        goto L4
    L7:
        return FastMath.sqrt(r0);
    }

    public abstract double getEntry(int r1);

    public double getL1Distance(RealVector r8) {
        checkVectorDimensions(r8);
        Iterator<Entry> r7 = iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L6;
        Entry r2 = (Entry) ZeusTransformUtils.preCheckCast(r7.next(), Entry.class, "com.obric.memorydata.plugin");
        r0 = r0 + FastMath.abs(r2.getValue() - r8.getEntry(r2.getIndex()));
        goto L4
    L6:
        return r0;
    }

    public double getL1Norm() {
        Iterator<Entry> r5 = iterator();
        double r0 = 0.0d;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = r0 + FastMath.abs(((Entry) ZeusTransformUtils.preCheckCast(r5.next(), Entry.class, "com.obric.memorydata.plugin")).getValue());
        goto L4
    L6:
        return r0;
    }

    public double getLInfDistance(RealVector r8) {
        checkVectorDimensions(r8);
        Iterator<Entry> r7 = iterator();
        double r0 = 0.0d;
    L4:
        if (r7.hasNext() == false) goto L6;
        Entry r2 = (Entry) ZeusTransformUtils.preCheckCast(r7.next(), Entry.class, "com.obric.memorydata.plugin");
        r0 = FastMath.max(FastMath.abs(r2.getValue() - r8.getEntry(r2.getIndex())), r0);
        goto L4
    L6:
        return r0;
    }

    public double getLInfNorm() {
        Iterator<Entry> r5 = iterator();
        double r0 = 0.0d;
    L4:
        if (r5.hasNext() == false) goto L6;
        r0 = FastMath.max(r0, FastMath.abs(((Entry) ZeusTransformUtils.preCheckCast(r5.next(), Entry.class, "com.obric.memorydata.plugin")).getValue()));
        goto L4
    L6:
        return r0;
    }

    public int getMaxIndex() {
        Iterator<Entry> r6 = iterator();
        int r0 = -1;
        double r1 = Double.NEGATIVE_INFINITY;
    L4:
        if (r6.hasNext() == false) goto L8;
        Entry r3 = (Entry) ZeusTransformUtils.preCheckCast(r6.next(), Entry.class, "com.obric.memorydata.plugin");
        if (r3.getValue() < r1) goto L4;
        r0 = r3.getIndex();
        r1 = r3.getValue();
        goto L4
    L8:
        return r0;
    }

    public double getMaxValue() {
        int r0 = getMaxIndex();
        if (r0 >= 0) goto L6;
        return Double.NaN;
    L6:
        return getEntry(r0);
    }

    public int getMinIndex() {
        Iterator<Entry> r6 = iterator();
        int r0 = -1;
        double r1 = Double.POSITIVE_INFINITY;
    L4:
        if (r6.hasNext() == false) goto L8;
        Entry r3 = (Entry) ZeusTransformUtils.preCheckCast(r6.next(), Entry.class, "com.obric.memorydata.plugin");
        if (r3.getValue() > r1) goto L4;
        r0 = r3.getIndex();
        r1 = r3.getValue();
        goto L4
    L8:
        return r0;
    }

    public double getMinValue() {
        int r0 = getMinIndex();
        if (r0 >= 0) goto L6;
        return Double.NaN;
    L6:
        return getEntry(r0);
    }

    public double getNorm() {
        Iterator<Entry> r5 = iterator();
        double r0 = 0.0d;
    L4:
        if (r5.hasNext() == false) goto L7;
        double r2 = ((Entry) ZeusTransformUtils.preCheckCast(r5.next(), Entry.class, "com.obric.memorydata.plugin")).getValue();
        r0 = r0 + (r2 * r2);
        goto L4
    L7:
        return FastMath.sqrt(r0);
    }

    public abstract RealVector getSubVector(int r1, int r2);

    public int hashCode() {
        throw new MathUnsupportedOperationException();
    }

    public abstract boolean isInfinite();

    public abstract boolean isNaN();

    public Iterator<Entry> iterator() {
        final int r0 = getDimension();
        return new AnonymousClass1(this, r0);
    }

    public RealVector map(UnivariateFunction r3) {
        UnivariateFunction r4 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r3, UnivariateFunction.class, "com.obric.memorydata.plugin");
        return copy().mapToSelf(r4);
    }

    public RealVector mapAdd(double r1) {
        return copy().mapAddToSelf(r1);
    }

    public RealVector mapAddToSelf(double r3) {
        if (r3 != 0.0d) goto L5;
        return this;
    L5:
        return mapToSelf(FunctionUtils.fix2ndArgument(new Add(), r3));
    }

    public RealVector mapDivide(double r1) {
        return copy().mapDivideToSelf(r1);
    }

    public RealVector mapDivideToSelf(double r2) {
        return mapToSelf(FunctionUtils.fix2ndArgument(new Divide(), r2));
    }

    public RealVector mapMultiply(double r1) {
        return copy().mapMultiplyToSelf(r1);
    }

    public RealVector mapMultiplyToSelf(double r2) {
        return mapToSelf(FunctionUtils.fix2ndArgument(new Multiply(), r2));
    }

    public RealVector mapSubtract(double r1) {
        return copy().mapSubtractToSelf(r1);
    }

    public RealVector mapSubtractToSelf(double r1) {
        return mapAddToSelf(-r1);
    }

    public RealVector mapToSelf(UnivariateFunction r6) {
        UnivariateFunction r7 = (UnivariateFunction) ZeusTransformUtils.wrapperContextForParams(r6, UnivariateFunction.class, "com.obric.memorydata.plugin");
        Iterator<Entry> r0 = iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Entry r2 = (Entry) ZeusTransformUtils.preCheckCast(r0.next(), Entry.class, "com.obric.memorydata.plugin");
        r2.setValue(r7.value(r2.getValue()));
        goto L4
    L6:
        return this;
    }

    public RealMatrix outerProduct(RealVector r11) {
        int r0 = getDimension();
        int r1 = r11.getDimension();
        if (ZeusTransformUtils.instanceOf(r11, SparseRealVector.class) == false) goto L5;
    L8:
        RealMatrix r2 = new OpenMapRealMatrix(r0, r1);
    L9:
        int r4 = 0;
    L10:
        if (r4 >= r0) goto L15;
        int r5 = 0;
    L12:
        if (r5 >= r1) goto L14;
        r2.setEntry(r4, r5, getEntry(r4) * r11.getEntry(r5));
        r5 = r5 + 1;
        goto L12
    L14:
        r4 = r4 + 1;
        goto L10
    L15:
        return r2;
    L5:
        if (ZeusTransformUtils.instanceOf(this, SparseRealVector.class) == true) goto L8;
        r2 = new Array2DRowRealMatrix(r0, r1);
        goto L9
    }

    public RealVector projection(RealVector r5) {
        if (r5.dotProduct(r5) == 0.0d) goto L7;
        return r5.mapMultiply(dotProduct(r5) / r5.dotProduct(r5));
    L7:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public void set(double r4) {
        Iterator<Entry> r3 = iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((Entry) ZeusTransformUtils.preCheckCast(r3.next(), Entry.class, "com.obric.memorydata.plugin")).setValue(r4);
        goto L4
    }

    public abstract void setEntry(int r1, double r2);

    public abstract void setSubVector(int r1, RealVector r2);

    public Iterator<Entry> sparseIterator() {
        return new SparseEntryIterator(this);
    }

    public RealVector subtract(RealVector r7) {
        checkVectorDimensions(r7);
        RealVector r8 = r7.mapMultiply(-1.0d);
        Iterator<Entry> r6 = iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Entry r0 = (Entry) ZeusTransformUtils.preCheckCast(r6.next(), Entry.class, "com.obric.memorydata.plugin");
        int r1 = r0.getIndex();
        r8.setEntry(r1, r0.getValue() + r8.getEntry(r1));
        goto L4
    L6:
        return r8;
    }

    public double[] toArray() {
        int r0 = getDimension();
        double[] r1 = new double[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r1[r2] = getEntry(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r1;
    }

    public RealVector unitVector() {
        double r0 = getNorm();
        if (r0 == 0.0d) goto L7;
        return mapDivide(r0);
    L7:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public void unitize() {
        if (getNorm() == 0.0d) goto L7;
        mapDivideToSelf(getNorm());
        return;
    L7:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public double walkInDefaultOrder(RealVectorChangingVisitor r6) {
        RealVectorChangingVisitor r7 = (RealVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r6, RealVectorChangingVisitor.class, "com.obric.memorydata.plugin");
        int r0 = getDimension();
        int r2 = 0;
        r7.start(r0, 0, r0 - 1);
    L3:
        if (r2 >= r0) goto L6;
        setEntry(r2, r7.visit(r2, getEntry(r2)));
        r2 = r2 + 1;
        goto L3
    L6:
        return r7.end();
    }

    public double walkInDefaultOrder(RealVectorChangingVisitor r3, int r4, int r5) {
        RealVectorChangingVisitor r6 = (RealVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorChangingVisitor.class, "com.obric.memorydata.plugin");
        checkIndices(r4, r5);
        r6.start(getDimension(), r4, r5);
    L3:
        if (r4 > r5) goto L6;
        setEntry(r4, r6.visit(r4, getEntry(r4)));
        r4 = r4 + 1;
        goto L3
    L6:
        return r6.end();
    }

    public double walkInDefaultOrder(RealVectorPreservingVisitor r6) {
        RealVectorPreservingVisitor r7 = (RealVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r6, RealVectorPreservingVisitor.class, "com.obric.memorydata.plugin");
        int r0 = getDimension();
        int r2 = 0;
        r7.start(r0, 0, r0 - 1);
    L3:
        if (r2 >= r0) goto L6;
        r7.visit(r2, getEntry(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return r7.end();
    }

    public double walkInDefaultOrder(RealVectorPreservingVisitor r3, int r4, int r5) {
        RealVectorPreservingVisitor r6 = (RealVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorPreservingVisitor.class, "com.obric.memorydata.plugin");
        checkIndices(r4, r5);
        r6.start(getDimension(), r4, r5);
    L3:
        if (r4 > r5) goto L6;
        r6.visit(r4, getEntry(r4));
        r4 = r4 + 1;
        goto L3
    L6:
        return r6.end();
    }

    public double walkInOptimizedOrder(RealVectorChangingVisitor r3) {
        return walkInDefaultOrder((RealVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorChangingVisitor.class, "com.obric.memorydata.plugin"));
    }

    public double walkInOptimizedOrder(RealVectorChangingVisitor r3, int r4, int r5) {
        return walkInDefaultOrder((RealVectorChangingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorChangingVisitor.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    public double walkInOptimizedOrder(RealVectorPreservingVisitor r3) {
        return walkInDefaultOrder((RealVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorPreservingVisitor.class, "com.obric.memorydata.plugin"));
    }

    public double walkInOptimizedOrder(RealVectorPreservingVisitor r3, int r4, int r5) {
        return walkInDefaultOrder((RealVectorPreservingVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RealVectorPreservingVisitor.class, "com.obric.memorydata.plugin"), r4, r5);
    }
}
