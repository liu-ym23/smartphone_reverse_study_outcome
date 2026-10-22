package org.apache.commons.math3.geometry.spherical.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class S1Point implements Point<Sphere1D> {
    public static final S1Point NaN = null;
    private static final long serialVersionUID = 20131218;
    private final double alpha;
    private final Vector2D vector;

    static {
        NaN = new S1Point(Double.NaN, Vector2D.NaN);
    }

    public S1Point(double r6) {
        this(MathUtils.normalizeAngle(r6, 3.141592653589793d), new Vector2D(FastMath.cos(r6), FastMath.sin(r6)));
    }

    private S1Point(double r1, Vector2D r3) {
        this.alpha = r1;
        this.vector = r3;
    }

    public static double distance(S1Point r0, S1Point r1) {
        return Vector2D.angle(r0.vector, r1.vector);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Sphere1D> r3) {
        return distance(this, (S1Point) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r3, Point.class, "com.obric.memorydata.plugin"), S1Point.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, S1Point.class) == false) goto L16;
        S1Point r8 = (S1Point) ZeusTransformUtils.preCheckCast(r7, S1Point.class, "com.obric.memorydata.plugin");
        if (r8.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.alpha != r8.alpha) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public double getAlpha() {
        return this.alpha;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Sphere1D.getInstance();
    }

    public Vector2D getVector() {
        return this.vector;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 542;
    L7:
        return MathUtils.hash(this.alpha) * 1759;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        return Double.isNaN(this.alpha);
    }
}
