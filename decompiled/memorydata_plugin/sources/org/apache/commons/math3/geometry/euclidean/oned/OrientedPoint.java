package org.apache.commons.math3.geometry.euclidean.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

/* JADX INFO: loaded from: classes6.dex */
public class OrientedPoint implements Hyperplane<Euclidean1D> {
    private boolean direct;
    private Vector1D location;
    private final double tolerance;

    public OrientedPoint(Vector1D r1, boolean r2, double r3) {
        this.location = r1;
        this.direct = r2;
        this.tolerance = r3;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public OrientedPoint copySelf() {
        return this;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Hyperplane copySelf() {
        return copySelf();
    }

    public Vector1D getLocation() {
        return this.location;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Euclidean1D> r5) {
        double r0 = ((Vector1D) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r5, Point.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin")).getX() - this.location.getX();
        if (this.direct == false) goto L6;
        return r0;
    L6:
        return -r0;
    }

    public boolean isDirect() {
        return this.direct;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Euclidean1D> r3) {
        return !(this.direct ^ ((OrientedPoint) ZeusTransformUtils.preCheckCast((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r3, Hyperplane.class, "com.obric.memorydata.plugin"), OrientedPoint.class, "com.obric.memorydata.plugin")).direct);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubOrientedPoint wholeHyperplane() {
        return new SubOrientedPoint(this, null);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ SubHyperplane wholeHyperplane() {
        return wholeHyperplane();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public IntervalsSet wholeSpace() {
        return new IntervalsSet(this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Region wholeSpace() {
        return wholeSpace();
    }
}
