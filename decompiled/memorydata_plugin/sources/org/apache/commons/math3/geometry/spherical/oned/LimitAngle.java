package org.apache.commons.math3.geometry.spherical.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

/* JADX INFO: loaded from: classes6.dex */
public class LimitAngle implements Hyperplane<Sphere1D> {
    private boolean direct;
    private S1Point location;
    private final double tolerance;

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Hyperplane copySelf() {
        return copySelf();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public LimitAngle copySelf() {
        return this;
    }

    public S1Point getLocation() {
        return this.location;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Sphere1D> r5) {
        double r0 = ((S1Point) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r5, Point.class, "com.obric.memorydata.plugin"), S1Point.class, "com.obric.memorydata.plugin")).getAlpha() - this.location.getAlpha();
        if (this.direct == false) goto L6;
        return r0;
    L6:
        return -r0;
    }

    public boolean isDirect() {
        return this.direct;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Sphere1D> r3) {
        return !(this.direct ^ ((LimitAngle) ZeusTransformUtils.preCheckCast((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin"), LimitAngle.class, "com.obric.memorydata.plugin")).direct);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ SubHyperplane wholeHyperplane() {
        return wholeHyperplane();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubLimitAngle wholeHyperplane() {
        return new SubLimitAngle(this, null);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Region wholeSpace() {
        return wholeSpace();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public ArcsSet wholeSpace() {
        return new ArcsSet(this.tolerance);
    }
}
