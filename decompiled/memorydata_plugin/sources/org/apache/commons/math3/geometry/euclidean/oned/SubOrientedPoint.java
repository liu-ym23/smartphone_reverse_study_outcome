package org.apache.commons.math3.geometry.euclidean.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

/* JADX INFO: loaded from: classes6.dex */
public class SubOrientedPoint extends AbstractSubHyperplane<Euclidean1D, Euclidean1D> {
    public SubOrientedPoint(Hyperplane<Euclidean1D> r3, Region<Euclidean1D> r4) {
        super((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin"), (Region) ZeusTransformUtils.wrapperContextForParams(r4, Region.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    public AbstractSubHyperplane<Euclidean1D, Euclidean1D> buildNew(Hyperplane<Euclidean1D> r2, Region<Euclidean1D> r3) {
        return new SubOrientedPoint((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r2, Hyperplane.class, "com.obric.memorydata.plugin"), (Region) ZeusTransformUtils.wrapperContextForParams(r3, Region.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public boolean isEmpty() {
        return false;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Euclidean1D> split(Hyperplane<Euclidean1D> r6) {
        double r0 = ((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r6, Hyperplane.class, "com.obric.memorydata.plugin")).getOffset(((OrientedPoint) ZeusTransformUtils.preCheckCast(getHyperplane(), OrientedPoint.class, "com.obric.memorydata.plugin")).getLocation());
        if (r0 >= (-1.0E-10d)) goto L7;
        return new SubHyperplane.SplitSubHyperplane(null, this);
    L7:
        if (r0 <= 1.0E-10d) goto L11;
        return new SubHyperplane.SplitSubHyperplane(this, null);
    L11:
        return new SubHyperplane.SplitSubHyperplane(null, null);
    }
}
