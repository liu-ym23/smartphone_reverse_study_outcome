package org.apache.commons.math3.geometry.euclidean.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Region;

/* JADX INFO: loaded from: classes6.dex */
public class IntervalsSet extends AbstractRegion<Euclidean1D, Euclidean1D> implements Iterable<double[]> {

    private class SubIntervalsIterator implements Iterator<double[]> {
        private BSPTree<Euclidean1D> current;
        private double[] pending;
        final /* synthetic */ IntervalsSet this$0;

        SubIntervalsIterator(IntervalsSet r6) {
            this.this$0 = r6;
            BSPTree<Euclidean1D> r0 = IntervalsSet.access$000(r6);
            this.current = r0;
            if (r0 != null) goto L9;
            if (((Boolean) ZeusTransformUtils.preCheckCast(IntervalsSet.access$100(r6, r6.getTree(false)).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
            this.pending = new double[]{Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY};
            return;
        L7:
            this.pending = null;
            return;
        L9:
            if (IntervalsSet.access$200(r6, r0) == false) goto L11;
            this.pending = new double[]{Double.NEGATIVE_INFINITY, IntervalsSet.access$300(r6, this.current)};
            return;
        L11:
            selectPending();
        }

        private void selectPending() {
            BSPTree<Euclidean1D> r0 = this.current;
        L3:
            if (r0 == null) goto L8;
            if (IntervalsSet.access$400(this.this$0, r0) == true) goto L8;
            r0 = IntervalsSet.access$500(this.this$0, r0);
        L8:
            if (r0 != null) goto L11;
            this.current = null;
            this.pending = null;
            return;
        L11:
            BSPTree<Euclidean1D> r2 = r0;
        L12:
            if (r2 == null) goto L17;
            if (IntervalsSet.access$200(this.this$0, r2) == true) goto L17;
            r2 = IntervalsSet.access$500(this.this$0, r2);
        L17:
            if (r2 == null) goto L19;
            this.pending = new double[]{IntervalsSet.access$300(this.this$0, r0), IntervalsSet.access$300(this.this$0, r2)};
            this.current = r2;
            return;
        L19:
            this.pending = new double[]{IntervalsSet.access$300(this.this$0, r0), Double.POSITIVE_INFINITY};
            this.current = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pending == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ double[] next() {
            return next2();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
        public double[] next2() {
            double[] r0 = this.pending;
            if (r0 == null) goto L7;
            selectPending();
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    public IntervalsSet() {
        this(1.0E-10d);
    }

    public IntervalsSet(double r1) {
        super(r1);
    }

    public IntervalsSet(BSPTree<Euclidean1D> r1, double r2) {
        super(r1, r2);
    }

    static /* synthetic */ BSPTree access$000(IntervalsSet r0) {
        return r0.getFirstIntervalBoundary();
    }

    static /* synthetic */ BSPTree access$100(IntervalsSet r0, BSPTree r1) {
        return r0.getFirstLeaf(r1);
    }

    static /* synthetic */ boolean access$200(IntervalsSet r0, BSPTree r1) {
        return r0.isIntervalEnd(r1);
    }

    static /* synthetic */ double access$300(IntervalsSet r0, BSPTree r1) {
        return r0.getAngle(r1);
    }

    static /* synthetic */ boolean access$400(IntervalsSet r0, BSPTree r1) {
        return r0.isIntervalStart(r1);
    }

    static /* synthetic */ BSPTree access$500(IntervalsSet r0, BSPTree r1) {
        return r0.nextInternalNode(r1);
    }

    private BSPTree<Euclidean1D> childAfter(BSPTree<Euclidean1D> r1) {
        if (isDirect(r1) == false) goto L7;
        return r1.getPlus();
    L7:
        return r1.getMinus();
    }

    private BSPTree<Euclidean1D> childBefore(BSPTree<Euclidean1D> r1) {
        if (isDirect(r1) == false) goto L7;
        return r1.getMinus();
    L7:
        return r1.getPlus();
    }

    private double getAngle(BSPTree<Euclidean1D> r2) {
        return ((OrientedPoint) ZeusTransformUtils.preCheckCast(r2.getCut().getHyperplane(), OrientedPoint.class, "com.obric.memorydata.plugin")).getLocation().getX();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet] */
    private BSPTree<Euclidean1D> getFirstIntervalBoundary() {
        BSPTree r0 = getTree(false);
        if (r0.getCut() != null) goto L6;
        return null;
    L6:
        BSPTree r1 = getFirstLeaf(r0).getParent();
    L7:
        if (r1 == null) goto L13;
        if (isIntervalStart(r1) == true) goto L13;
        if (isIntervalEnd(r1) == true) goto L13;
        r1 = nextInternalNode(r1);
    L13:
        return r1;
    }

    private BSPTree<Euclidean1D> getFirstLeaf(BSPTree<Euclidean1D> r3) {
        if (r3.getCut() != null) goto L5;
        return r3;
    L5:
        BSPTree<Euclidean1D> r0 = null;
    L6:
        if (r3 == null) goto L9;
        r0 = r3;
        r3 = previousInternalNode(r3);
        goto L6
    L9:
        return leafBefore(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isAfterParent(BSPTree<Euclidean1D> r3) {
        BSPTree<S> r0 = r3.getParent();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r3 != childAfter(r0)) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isBeforeParent(BSPTree<Euclidean1D> r3) {
        BSPTree<S> r0 = r3.getParent();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r3 != childBefore(r0)) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isDirect(BSPTree<Euclidean1D> r2) {
        return ((OrientedPoint) ZeusTransformUtils.preCheckCast(r2.getCut().getHyperplane(), OrientedPoint.class, "com.obric.memorydata.plugin")).isDirect();
    }

    private boolean isIntervalEnd(BSPTree<Euclidean1D> r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(leafBefore(r4).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        return false;
    L6:
        if (((Boolean) ZeusTransformUtils.preCheckCast(leafAfter(r4).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        return false;
    L8:
        return true;
    }

    private boolean isIntervalStart(BSPTree<Euclidean1D> r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(leafBefore(r4).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        return false;
    L6:
        if (((Boolean) ZeusTransformUtils.preCheckCast(leafAfter(r4).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    }

    private BSPTree<Euclidean1D> leafAfter(BSPTree<Euclidean1D> r2) {
        BSPTree<Euclidean1D> r3 = childAfter(r2);
    L4:
        if (r3.getCut() == null) goto L6;
        r3 = childBefore(r3);
        goto L4
    L6:
        return r3;
    }

    private BSPTree<Euclidean1D> leafBefore(BSPTree<Euclidean1D> r2) {
        BSPTree<Euclidean1D> r3 = childBefore(r2);
    L4:
        if (r3.getCut() == null) goto L6;
        r3 = childAfter(r3);
        goto L4
    L6:
        return r3;
    }

    private BSPTree<Euclidean1D> nextInternalNode(BSPTree<Euclidean1D> r2) {
        if (childAfter(r2).getCut() == null) goto L7;
        return leafAfter(r2).getParent();
    L7:
        if (isAfterParent(r2) == false) goto L10;
        r2 = r2.getParent();
        goto L7
    L10:
        return r2.getParent();
    }

    private BSPTree<Euclidean1D> previousInternalNode(BSPTree<Euclidean1D> r2) {
        if (childBefore(r2).getCut() == null) goto L7;
        return leafBefore(r2).getParent();
    L7:
        if (isBeforeParent(r2) == false) goto L10;
        r2 = r2.getParent();
        goto L7
    L10:
        return r2.getParent();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public IntervalsSet buildNew(BSPTree<Euclidean1D> r4) {
        return new IntervalsSet(r4, getTolerance());
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // java.lang.Iterable
    public Iterator<double[]> iterator() {
        return new SubIntervalsIterator(this);
    }
}
