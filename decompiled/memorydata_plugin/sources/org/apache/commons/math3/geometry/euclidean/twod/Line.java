package org.apache.commons.math3.geometry.euclidean.twod;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Line implements Hyperplane<Euclidean2D> {
    private double angle;
    private double cos;
    private double originOffset;
    private Line reverse;
    private double sin;
    private final double tolerance;

    public Line(Line r5) {
        this.angle = MathUtils.normalizeAngle(r5.angle, 3.141592653589793d);
        this.cos = r5.cos;
        this.sin = r5.sin;
        this.originOffset = r5.originOffset;
        this.tolerance = r5.tolerance;
        this.reverse = null;
    }

    public Line(Vector2D r1, Vector2D r2, double r3) {
        reset(r1, r2);
        this.tolerance = r3;
    }

    private void unlinkReverse() {
        Line r0 = this.reverse;
        if (r0 == null) goto L5;
        r0.reverse = null;
    L5:
        this.reverse = null;
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public Line copySelf() {
        return new Line(this);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Hyperplane copySelf() {
        return copySelf();
    }

    public double getAngle() {
        return MathUtils.normalizeAngle(this.angle, 3.141592653589793d);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public double getOffset(Point<Euclidean2D> r13) {
        Vector2D r14 = (Vector2D) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r13, Point.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return MathArrays.linearCombination(this.sin, r14.getX(), -this.cos, r14.getY(), 1.0d, this.originOffset);
    }

    public double getOffset(Line r11) {
        double r0 = this.originOffset;
        if (MathArrays.linearCombination(this.cos, r11.cos, this.sin, r11.sin) <= 0.0d) goto L5;
        double r10 = -r11.originOffset;
    L7:
        return r0 + r10;
    L5:
        r10 = r11.originOffset;
        goto L7
    }

    public double getTolerance() {
        return this.tolerance;
    }

    public Vector2D intersection(Line r14) {
        double r0 = MathArrays.linearCombination(this.sin, r14.cos, -r14.sin, this.cos);
        if (FastMath.abs(r0) >= this.tolerance) goto L7;
        return null;
    L7:
        return new Vector2D(MathArrays.linearCombination(this.cos, r14.originOffset, -r14.cos, this.originOffset) / r0, MathArrays.linearCombination(this.sin, r14.originOffset, -r14.sin, this.originOffset) / r0);
    }

    public void reset(Vector2D r16, Vector2D r17) {
        unlinkReverse();
        double r1 = r17.getX() - r16.getX();
        double r3 = r17.getY() - r16.getY();
        double r5 = FastMath.hypot(r1, r3);
        if (r5 != 0.0d) goto L5;
        this.angle = 0.0d;
        this.cos = 1.0d;
        this.sin = 0.0d;
        double r2 = r16.getY();
    L6:
        this.originOffset = r2;
        return;
    L5:
        this.angle = FastMath.atan2(-r3, -r1) + 3.141592653589793d;
        this.cos = r1 / r5;
        this.sin = r3 / r5;
        r2 = MathArrays.linearCombination(r17.getX(), r16.getY(), -r16.getX(), r17.getY()) / r5;
        goto L6
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public boolean sameOrientationAs(Hyperplane<Euclidean2D> r9) {
        Line r10 = (Line) ZeusTransformUtils.preCheckCast((Hyperplane) ZeusTransformUtils.wrapperContextForParams(r9, Hyperplane.class, "com.obric.memorydata.plugin"), Line.class, "com.obric.memorydata.plugin");
        if (MathArrays.linearCombination(this.sin, r10.sin, this.cos, r10.cos) < 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    public Vector1D toSubSpace(Point<Euclidean2D> r10) {
        Vector2D r11 = (Vector2D) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r10, Point.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return new Vector1D(MathArrays.linearCombination(this.cos, r11.getX(), this.sin, r11.getY()));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public SubLine wholeHyperplane() {
        return new SubLine(this, new IntervalsSet(this.tolerance));
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ SubHyperplane wholeHyperplane() {
        return wholeHyperplane();
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public PolygonsSet wholeSpace() {
        return new PolygonsSet(this.tolerance);
    }

    @Override // org.apache.commons.math3.geometry.partitioning.Hyperplane
    public /* bridge */ /* synthetic */ Region wholeSpace() {
        return wholeSpace();
    }
}
