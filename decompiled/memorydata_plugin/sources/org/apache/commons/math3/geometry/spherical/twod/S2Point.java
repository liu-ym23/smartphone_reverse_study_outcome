package org.apache.commons.math3.geometry.spherical.twod;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class S2Point implements Point<Sphere2D> {
    public static final S2Point MINUS_I = null;
    public static final S2Point MINUS_J = null;
    public static final S2Point MINUS_K = null;
    public static final S2Point NaN = null;
    public static final S2Point PLUS_I = null;
    public static final S2Point PLUS_J = null;
    public static final S2Point PLUS_K = null;
    private static final long serialVersionUID = 20131218;
    private final double phi;
    private final double theta;
    private final Vector3D vector;

    static {
        PLUS_I = new S2Point(0.0d, 1.5707963267948966d, Vector3D.PLUS_I);
        PLUS_J = new S2Point(1.5707963267948966d, 1.5707963267948966d, Vector3D.PLUS_J);
        PLUS_K = new S2Point(0.0d, 0.0d, Vector3D.PLUS_K);
        MINUS_I = new S2Point(3.141592653589793d, 1.5707963267948966d, Vector3D.MINUS_I);
        MINUS_J = new S2Point(4.71238898038469d, 1.5707963267948966d, Vector3D.MINUS_J);
        MINUS_K = new S2Point(0.0d, 3.141592653589793d, Vector3D.MINUS_K);
        NaN = new S2Point(Double.NaN, Double.NaN, Vector3D.NaN);
    }

    public S2Point(double r7, double r9) {
        this(r7, r9, vector(r7, r9));
    }

    private S2Point(double r1, double r3, Vector3D r5) {
        this.theta = r1;
        this.phi = r3;
        this.vector = r5;
    }

    public S2Point(Vector3D r11) {
        this(FastMath.atan2(r11.getY(), r11.getX()), Vector3D.angle(Vector3D.PLUS_K, r11), r11.normalize());
    }

    public static double distance(S2Point r0, S2Point r1) {
        return Vector3D.angle(r0.vector, r1.vector);
    }

    private static Vector3D vector(double r10, double r12) {
        if (r12 < 0.0d) goto L9;
        if (r12 > 3.141592653589793d) goto L9;
        double r0 = FastMath.cos(r10);
        double r11 = FastMath.sin(r10);
        double r7 = FastMath.cos(r12);
        double r13 = FastMath.sin(r12);
        return new Vector3D(r0 * r13, r11 * r13, r7);
    L9:
        throw new OutOfRangeException(Double.valueOf(r12), 0, Double.valueOf(3.141592653589793d));
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Sphere2D> r3) {
        return distance(this, (S2Point) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r3, Point.class, "com.obric.memorydata.plugin"), S2Point.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, S2Point.class) == false) goto L18;
        S2Point r10 = (S2Point) ZeusTransformUtils.preCheckCast(r9, S2Point.class, "com.obric.memorydata.plugin");
        if (r10.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.theta != r10.theta) goto L17;
        if (this.phi != r10.phi) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public double getPhi() {
        return this.phi;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Sphere2D.getInstance();
    }

    public double getTheta() {
        return this.theta;
    }

    public Vector3D getVector() {
        return this.vector;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 542;
    L7:
        return ((MathUtils.hash(this.theta) * 37) + MathUtils.hash(this.phi)) * 134;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        if (Double.isNaN(this.theta) == false) goto L5;
    L8:
        return true;
    L5:
        if (Double.isNaN(this.phi) == true) goto L8;
        return false;
    }

    public S2Point negate() {
        return new S2Point(-this.theta, 3.141592653589793d - this.phi, this.vector.negate());
    }
}
