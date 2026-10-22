package org.apache.commons.math3.geometry.spherical.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Region;

/* JADX INFO: loaded from: classes6.dex */
public class ArcsSet extends AbstractRegion<Sphere1D, Sphere1D> implements Iterable<double[]> {

    public static class InconsistentStateAt2PiWrapping extends MathIllegalArgumentException {
        private static final long serialVersionUID = 20140107;

        public InconsistentStateAt2PiWrapping() {
            super(LocalizedFormats.INCONSISTENT_STATE_AT_2_PI_WRAPPING, new Object[0]);
        }
    }

    private class SubArcsIterator implements Iterator<double[]> {
        private BSPTree<Sphere1D> current;
        private final BSPTree<Sphere1D> firstStart;
        private double[] pending;
        final /* synthetic */ ArcsSet this$0;

        SubArcsIterator(ArcsSet r3) {
            this.this$0 = r3;
            BSPTree<Sphere1D> r0 = ArcsSet.access$000(r3);
            this.firstStart = r0;
            this.current = r0;
            if (r0 == null) goto L5;
            selectPending();
            return;
        L5:
            if (((Boolean) ZeusTransformUtils.preCheckCast(ArcsSet.access$100(r3, r3.getTree(false)).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
            this.pending = new double[]{0.0d, 6.283185307179586d};
            return;
        L7:
            this.pending = null;
        }

        private void selectPending() {
            BSPTree<Sphere1D> r0 = this.current;
        L3:
            if (r0 == null) goto L8;
            if (ArcsSet.access$200(this.this$0, r0) == true) goto L8;
            r0 = ArcsSet.access$300(this.this$0, r0);
        L8:
            if (r0 != null) goto L11;
            this.current = null;
            this.pending = null;
            return;
        L11:
            BSPTree<Sphere1D> r2 = r0;
        L12:
            if (r2 == null) goto L17;
            if (ArcsSet.access$400(this.this$0, r2) == true) goto L17;
            r2 = ArcsSet.access$300(this.this$0, r2);
        L17:
            if (r2 == null) goto L19;
            this.pending = new double[]{ArcsSet.access$500(this.this$0, r0), ArcsSet.access$500(this.this$0, r2)};
            this.current = r2;
            return;
        L19:
            BSPTree<Sphere1D> r3 = this.firstStart;
        L20:
            if (r3 == null) goto L24;
            if (ArcsSet.access$400(this.this$0, r3) == true) goto L24;
            r3 = ArcsSet.access$600(this.this$0, r3);
        L24:
            if (r3 == null) goto L28;
            this.pending = new double[]{ArcsSet.access$500(this.this$0, r0), ArcsSet.access$500(this.this$0, r3) + 6.283185307179586d};
            this.current = null;
            return;
        L28:
            throw new MathInternalError();
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

    public ArcsSet(double r1) {
        super(r1);
    }

    public ArcsSet(BSPTree<Sphere1D> r1, double r2) {
        super(r1, r2);
        check2PiConsistency();
    }

    static /* synthetic */ BSPTree access$000(ArcsSet r0) {
        return r0.getFirstArcStart();
    }

    static /* synthetic */ BSPTree access$100(ArcsSet r0, BSPTree r1) {
        return r0.getFirstLeaf(r1);
    }

    static /* synthetic */ boolean access$200(ArcsSet r0, BSPTree r1) {
        return r0.isArcStart(r1);
    }

    static /* synthetic */ BSPTree access$300(ArcsSet r0, BSPTree r1) {
        return r0.nextInternalNode(r1);
    }

    static /* synthetic */ boolean access$400(ArcsSet r0, BSPTree r1) {
        return r0.isArcEnd(r1);
    }

    static /* synthetic */ double access$500(ArcsSet r0, BSPTree r1) {
        return r0.getAngle(r1);
    }

    static /* synthetic */ BSPTree access$600(ArcsSet r0, BSPTree r1) {
        return r0.previousInternalNode(r1);
    }

    private void check2PiConsistency() {
        BSPTree<Sphere1D> r0 = getTree(false);
        if (r0.getCut() != null) goto L5;
        return;
    L5:
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(getFirstLeaf(r0).getAttribute(), Boolean.class, "com.obric.memorydata.plugin");
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(getLastLeaf(r0).getAttribute(), Boolean.class, "com.obric.memorydata.plugin");
        boolean r2 = r1.booleanValue();
        if ((r4.booleanValue() ^ r2) == true) goto L9;
        return;
    L9:
        throw new InconsistentStateAt2PiWrapping();
    }

    private BSPTree<Sphere1D> childAfter(BSPTree<Sphere1D> r1) {
        if (isDirect(r1) == false) goto L7;
        return r1.getPlus();
    L7:
        return r1.getMinus();
    }

    private BSPTree<Sphere1D> childBefore(BSPTree<Sphere1D> r1) {
        if (isDirect(r1) == false) goto L7;
        return r1.getMinus();
    L7:
        return r1.getPlus();
    }

    private double getAngle(BSPTree<Sphere1D> r2) {
        return ((LimitAngle) ZeusTransformUtils.preCheckCast(r2.getCut().getHyperplane(), LimitAngle.class, "com.obric.memorydata.plugin")).getLocation().getAlpha();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [org.apache.commons.math3.geometry.spherical.oned.ArcsSet] */
    private BSPTree<Sphere1D> getFirstArcStart() {
        BSPTree r0 = getTree(false);
        if (r0.getCut() != null) goto L6;
        return null;
    L6:
        BSPTree r1 = getFirstLeaf(r0).getParent();
    L7:
        if (r1 == null) goto L11;
        if (isArcStart(r1) == true) goto L11;
        r1 = nextInternalNode(r1);
    L11:
        return r1;
    }

    private BSPTree<Sphere1D> getFirstLeaf(BSPTree<Sphere1D> r3) {
        if (r3.getCut() != null) goto L5;
        return r3;
    L5:
        BSPTree<Sphere1D> r0 = null;
    L6:
        if (r3 == null) goto L9;
        r0 = r3;
        r3 = previousInternalNode(r3);
        goto L6
    L9:
        return leafBefore(r0);
    }

    private BSPTree<Sphere1D> getLastLeaf(BSPTree<Sphere1D> r3) {
        if (r3.getCut() != null) goto L5;
        return r3;
    L5:
        BSPTree<Sphere1D> r0 = null;
    L6:
        if (r3 == null) goto L9;
        r0 = r3;
        r3 = nextInternalNode(r3);
        goto L6
    L9:
        return leafAfter(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isAfterParent(BSPTree<Sphere1D> r3) {
        BSPTree<S> r0 = r3.getParent();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r3 != childAfter(r0)) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isArcEnd(BSPTree<Sphere1D> r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(leafBefore(r4).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L6;
        return false;
    L6:
        if (((Boolean) ZeusTransformUtils.preCheckCast(leafAfter(r4).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L8;
        return false;
    L8:
        return true;
    }

    private boolean isArcStart(BSPTree<Sphere1D> r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(leafBefore(r4).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L6;
        return false;
    L6:
        if (((Boolean) ZeusTransformUtils.preCheckCast(leafAfter(r4).getAttribute(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isBeforeParent(BSPTree<Sphere1D> r3) {
        BSPTree<S> r0 = r3.getParent();
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r3 != childBefore(r0)) goto L9;
        return true;
    L9:
        return false;
    }

    private boolean isDirect(BSPTree<Sphere1D> r2) {
        return ((LimitAngle) ZeusTransformUtils.preCheckCast(r2.getCut().getHyperplane(), LimitAngle.class, "com.obric.memorydata.plugin")).isDirect();
    }

    private BSPTree<Sphere1D> leafAfter(BSPTree<Sphere1D> r2) {
        BSPTree<Sphere1D> r3 = childAfter(r2);
    L4:
        if (r3.getCut() == null) goto L6;
        r3 = childBefore(r3);
        goto L4
    L6:
        return r3;
    }

    private BSPTree<Sphere1D> leafBefore(BSPTree<Sphere1D> r2) {
        BSPTree<Sphere1D> r3 = childBefore(r2);
    L4:
        if (r3.getCut() == null) goto L6;
        r3 = childAfter(r3);
        goto L4
    L6:
        return r3;
    }

    private BSPTree<Sphere1D> nextInternalNode(BSPTree<Sphere1D> r2) {
        if (childAfter(r2).getCut() == null) goto L7;
        return leafAfter(r2).getParent();
    L7:
        if (isAfterParent(r2) == false) goto L10;
        r2 = r2.getParent();
        goto L7
    L10:
        return r2.getParent();
    }

    private BSPTree<Sphere1D> previousInternalNode(BSPTree<Sphere1D> r2) {
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
    public /* bridge */ /* synthetic */ AbstractRegion buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public /* bridge */ /* synthetic */ Region buildNew(BSPTree r1) {
        return buildNew(r1);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractRegion, org.apache.commons.math3.geometry.partitioning.Region
    public ArcsSet buildNew(BSPTree<Sphere1D> r4) {
        return new ArcsSet(r4, getTolerance());
    }

    @Override // java.lang.Iterable
    public Iterator<double[]> iterator() {
        return new SubArcsIterator(this);
    }
}
