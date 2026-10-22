package org.apache.commons.math3.geometry.euclidean.twod;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.OrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.SubOrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SubLine extends AbstractSubHyperplane<Euclidean2D, Euclidean1D> {
    public SubLine(Hyperplane<Euclidean2D> r3, Region<Euclidean1D> r4) {
        super((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin"), (Region) ZeusTransformUtils.wrapperContextForParams(r4, Region.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    public AbstractSubHyperplane<Euclidean2D, Euclidean1D> buildNew(Hyperplane<Euclidean2D> r2, Region<Euclidean1D> r3) {
        return new SubLine((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r2, Hyperplane.class, "com.obric.memorydata.plugin"), (Region) ZeusTransformUtils.wrapperContextForParams(r3, Region.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Euclidean2D> split(Hyperplane<Euclidean2D> r10) {
        Hyperplane r11 = (Hyperplane) ZeusTransformUtils.wrapperContextForParams(r10, Hyperplane.class, "com.obric.memorydata.plugin");
        Line r0 = (Line) ZeusTransformUtils.preCheckCast(getHyperplane(), Line.class, "com.obric.memorydata.plugin");
        Line r12 = (Line) ZeusTransformUtils.preCheckCast(r11, Line.class, "com.obric.memorydata.plugin");
        Vector2D r1 = r0.intersection(r12);
        double r2 = r0.getTolerance();
        if (r1 != null) goto L15;
        double r3 = r12.getOffset(r0);
        if (r3 >= (-r2)) goto L9;
        return new SubHyperplane.SplitSubHyperplane(null, this);
    L9:
        if (r3 <= r2) goto L13;
        return new SubHyperplane.SplitSubHyperplane(this, null);
    L13:
        return new SubHyperplane.SplitSubHyperplane(null, null);
    L15:
        if (FastMath.sin(r0.getAngle() - r12.getAngle()) >= 0.0d) goto L17;
        boolean r13 = true;
    L18:
        Vector1D r4 = r0.toSubSpace(r1);
        SubOrientedPoint r6 = new OrientedPoint(r4, !r13, r2).wholeHyperplane();
        SubOrientedPoint r14 = new OrientedPoint(r4, r13, r2).wholeHyperplane();
        BSPTree r5 = getRemainingRegion().getTree(false).split(r14);
        if (getRemainingRegion().isEmpty(r5.getPlus()) == false) goto L21;
        BSPTree r7 = new BSPTree(Boolean.FALSE);
    L23:
        if (getRemainingRegion().isEmpty(r5.getMinus()) == false) goto L25;
        BSPTree r9 = new BSPTree(Boolean.FALSE);
    L27:
        return new SubHyperplane.SplitSubHyperplane(new SubLine(r0.copySelf(), new IntervalsSet(r7, r2)), new SubLine(r0.copySelf(), new IntervalsSet(r9, r2)));
    L25:
        r9 = new BSPTree(r14, new BSPTree(Boolean.FALSE), r5.getMinus(), null);
        goto L27
    L21:
        r7 = new BSPTree(r6, new BSPTree(Boolean.FALSE), r5.getPlus(), null);
        goto L23
    L17:
        r13 = false;
        goto L18
    }
}
