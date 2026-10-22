package org.apache.commons.math3.geometry.spherical.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

/* JADX INFO: loaded from: classes6.dex */
public class SubLimitAngle extends AbstractSubHyperplane<Sphere1D, Sphere1D> {
    public SubLimitAngle(Hyperplane<Sphere1D> r3, Region<Sphere1D> r4) {
        super((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin"), (Region) ZeusTransformUtils.wrapperContextForParams(r4, Region.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane
    public AbstractSubHyperplane<Sphere1D, Sphere1D> buildNew(Hyperplane<Sphere1D> r2, Region<Sphere1D> r3) {
        return new SubLimitAngle((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r2, Hyperplane.class, "com.obric.memorydata.plugin"), (Region) ZeusTransformUtils.wrapperContextForParams(r3, Region.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane, org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public boolean isEmpty() {
        return false;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.SubHyperplane
    public SubHyperplane.SplitSubHyperplane<Sphere1D> split(Hyperplane<Sphere1D> r5) {
        if (((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r5, Hyperplane.class, "com.obric.memorydata.plugin")).getOffset(((LimitAngle) ZeusTransformUtils.preCheckCast(getHyperplane(), LimitAngle.class, "com.obric.memorydata.plugin")).getLocation()) >= (-1.0E-10d)) goto L6;
        return new SubHyperplane.SplitSubHyperplane(null, this);
    L6:
        return new SubHyperplane.SplitSubHyperplane(this, null);
    }
}
