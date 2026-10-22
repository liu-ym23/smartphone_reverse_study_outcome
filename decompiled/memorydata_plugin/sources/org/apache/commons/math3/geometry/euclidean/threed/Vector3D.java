package org.apache.commons.math3.geometry.euclidean.threed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Vector3D implements Serializable, Vector<Euclidean3D> {
    public static final Vector3D MINUS_I = null;
    public static final Vector3D MINUS_J = null;
    public static final Vector3D MINUS_K = null;
    public static final Vector3D NEGATIVE_INFINITY = null;
    public static final Vector3D NaN = null;
    public static final Vector3D PLUS_I = null;
    public static final Vector3D PLUS_J = null;
    public static final Vector3D PLUS_K = null;
    public static final Vector3D POSITIVE_INFINITY = null;
    public static final Vector3D ZERO = null;
    private static final long serialVersionUID = 1313493323784566947L;
    private final double x;
    private final double y;
    private final double z;

    static {
        ZERO = new Vector3D(0.0d, 0.0d, 0.0d);
        PLUS_I = new Vector3D(1.0d, 0.0d, 0.0d);
        MINUS_I = new Vector3D(-1.0d, 0.0d, 0.0d);
        PLUS_J = new Vector3D(0.0d, 1.0d, 0.0d);
        MINUS_J = new Vector3D(0.0d, -1.0d, 0.0d);
        PLUS_K = new Vector3D(0.0d, 0.0d, 1.0d);
        MINUS_K = new Vector3D(0.0d, 0.0d, -1.0d);
        NaN = new Vector3D(Double.NaN, Double.NaN, Double.NaN);
        POSITIVE_INFINITY = new Vector3D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        NEGATIVE_INFINITY = new Vector3D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    public Vector3D(double r5, double r7) {
        double r0 = FastMath.cos(r7);
        this.x = FastMath.cos(r5) * r0;
        this.y = FastMath.sin(r5) * r0;
        this.z = FastMath.sin(r7);
    }

    public Vector3D(double r1, double r3, double r5) {
        this.x = r1;
        this.y = r3;
        this.z = r5;
    }

    public Vector3D(double r3, Vector3D r5) {
        this.x = r5.x * r3;
        this.y = r5.y * r3;
        this.z = r3 * r5.z;
    }

    public Vector3D(double r14, Vector3D r16, double r17, Vector3D r19) {
        this.x = MathArrays.linearCombination(r14, r16.x, r17, r19.x);
        this.y = MathArrays.linearCombination(r14, r16.y, r17, r19.y);
        this.z = MathArrays.linearCombination(r14, r16.z, r17, r19.z);
    }

    public Vector3D(double r19, Vector3D r21, double r22, Vector3D r24, double r25, Vector3D r27) {
        this.x = MathArrays.linearCombination(r19, r21.x, r22, r24.x, r25, r27.x);
        this.y = MathArrays.linearCombination(r19, r21.y, r22, r24.y, r25, r27.y);
        this.z = MathArrays.linearCombination(r19, r21.z, r22, r24.z, r25, r27.z);
    }

    public Vector3D(double r24, Vector3D r26, double r27, Vector3D r29, double r30, Vector3D r32, double r33, Vector3D r35) {
        this.x = MathArrays.linearCombination(r24, r26.x, r27, r29.x, r30, r32.x, r33, r35.x);
        this.y = MathArrays.linearCombination(r24, r26.y, r27, r29.y, r30, r32.y, r33, r35.y);
        this.z = MathArrays.linearCombination(r24, r26.z, r27, r29.z, r30, r32.z, r33, r35.z);
    }

    public Vector3D(double[] r3) {
        if (r3.length != 3) goto L7;
        this.x = r3[0];
        this.y = r3[1];
        this.z = r3[2];
        return;
    L7:
        throw new DimensionMismatchException(r3.length, 3);
    }

    public static double angle(Vector3D r10, Vector3D r11) {
        double r0 = r10.getNorm() * r11.getNorm();
        if (r0 == 0.0d) goto L18;
        double r4 = r10.dotProduct(r11);
        double r6 = 0.9999d * r0;
        if (r4 >= (-r6)) goto L7;
    L11:
        Vector3D r12 = crossProduct(r10, r11);
        if (r4 < 0.0d) goto L16;
        return FastMath.asin(r12.getNorm() / r0);
    L16:
        return 3.141592653589793d - FastMath.asin(r12.getNorm() / r0);
    L7:
        if (r4 > r6) goto L11;
        return FastMath.acos(r4 / r0);
    L18:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static Vector3D crossProduct(Vector3D r0, Vector3D r1) {
        return r0.crossProduct(r1);
    }

    public static double distance(Vector3D r0, Vector3D r1) {
        return r0.distance(r1);
    }

    public static double distance1(Vector3D r0, Vector3D r1) {
        return r0.distance1(r1);
    }

    public static double distanceInf(Vector3D r0, Vector3D r1) {
        return r0.distanceInf(r1);
    }

    public static double distanceSq(Vector3D r0, Vector3D r1) {
        return r0.distanceSq(r1);
    }

    public static double dotProduct(Vector3D r0, Vector3D r1) {
        return r0.dotProduct(r1);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* synthetic */ Vector add(double r3, Vector r5) {
        return add(r3, (Vector) ZeusTransformUtils.wrapperContextForParams(r5, Vector.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* synthetic */ Vector add(Vector r3) {
        return add((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D add(double r10, Vector<Euclidean3D> r12) {
        return new Vector3D(1.0d, this, r10, (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r12, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D add(Vector<Euclidean3D> r9) {
        Vector3D r10 = (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r9, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        return new Vector3D(this.x + r10.x, this.y + r10.y, this.z + r10.z);
    }

    public Vector3D crossProduct(Vector<Euclidean3D> r19) {
        Vector3D r1 = (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r19, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        return new Vector3D(MathArrays.linearCombination(this.y, r1.z, -this.z, r1.y), MathArrays.linearCombination(this.z, r1.x, -this.x, r1.z), MathArrays.linearCombination(this.x, r1.y, -this.y, r1.x));
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Euclidean3D> r7) {
        Vector3D r8 = (Vector3D) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r7, Point.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        double r0 = r8.x - this.x;
        double r2 = r8.y - this.y;
        double r4 = r8.z - this.z;
        return FastMath.sqrt(((r0 * r0) + (r2 * r2)) + (r4 * r4));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance(Vector<Euclidean3D> r3) {
        return distance((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance1(Vector<Euclidean3D> r7) {
        Vector3D r8 = (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r7, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        double r0 = FastMath.abs(r8.x - this.x);
        double r2 = FastMath.abs(r8.y - this.y);
        double r1 = r0 + r2;
        return r1 + FastMath.abs(r8.z - this.z);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceInf(Vector<Euclidean3D> r7) {
        Vector3D r8 = (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r7, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        double r0 = FastMath.abs(r8.x - this.x);
        double r2 = FastMath.abs(r8.y - this.y);
        double r6 = FastMath.abs(r8.z - this.z);
        return FastMath.max(FastMath.max(r0, r2), r6);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceSq(Vector<Euclidean3D> r7) {
        Vector3D r8 = (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r7, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        double r0 = r8.x - this.x;
        double r2 = r8.y - this.y;
        double r4 = r8.z - this.z;
        return ((r0 * r0) + (r2 * r2)) + (r4 * r4);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double dotProduct(Vector<Euclidean3D> r13) {
        Vector3D r14 = (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r13, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        return MathArrays.linearCombination(this.x, r14.x, this.y, r14.y, this.z, r14.z);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Vector3D.class) == false) goto L20;
        Vector3D r10 = (Vector3D) ZeusTransformUtils.preCheckCast(r9, Vector3D.class, "com.obric.memorydata.plugin");
        if (r10.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.x != r10.x) goto L19;
        if (this.y != r10.y) goto L19;
        if (this.z != r10.z) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public double getAlpha() {
        return FastMath.atan2(this.y, this.x);
    }

    public double getDelta() {
        return FastMath.asin(this.z / getNorm());
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm() {
        double r0 = this.x;
        double r2 = this.y;
        double r1 = (r0 * r0) + (r2 * r2);
        double r3 = this.z;
        return FastMath.sqrt(r1 + (r3 * r3));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm1() {
        return (FastMath.abs(this.x) + FastMath.abs(this.y)) + FastMath.abs(this.z);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormInf() {
        return FastMath.max(FastMath.max(FastMath.abs(this.x), FastMath.abs(this.y)), FastMath.abs(this.z));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormSq() {
        double r0 = this.x;
        double r2 = this.y;
        double r1 = (r0 * r0) + (r2 * r2);
        double r3 = this.z;
        return r1 + (r3 * r3);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Euclidean3D.getInstance();
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector getZero() {
        return getZero();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D getZero() {
        return ZERO;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 642;
    L7:
        return (((MathUtils.hash(this.x) * 164) + (MathUtils.hash(this.y) * 3)) + MathUtils.hash(this.z)) * 643;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public boolean isInfinite() {
        if (isNaN() == false) goto L5;
    L11:
        return false;
    L5:
        if (Double.isInfinite(this.x) == false) goto L7;
    L10:
        return true;
    L7:
        if (Double.isInfinite(this.y) == true) goto L10;
        if (Double.isInfinite(this.z) == false) goto L11;
        goto L10
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        if (Double.isNaN(this.x) == false) goto L5;
    L10:
        return true;
    L5:
        if (Double.isNaN(this.y) == true) goto L10;
        if (Double.isNaN(this.z) == true) goto L10;
        return false;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D negate() {
        return new Vector3D(-this.x, -this.y, -this.z);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector normalize() {
        return normalize();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D normalize() {
        double r0 = getNorm();
        if (r0 == 0.0d) goto L7;
        return scalarMultiply(1.0d / r0);
    L7:
        throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    public Vector3D orthogonal() {
        double r0 = getNorm() * 0.6d;
        if (r0 == 0.0d) goto L15;
        if (FastMath.abs(this.x) > r0) goto L9;
        double r1 = this.y;
        double r5 = this.z;
        double r3 = 1.0d / FastMath.sqrt((r1 * r1) + (r5 * r5));
        return new Vector3D(0.0d, r3 * this.z, (-r3) * this.y);
    L9:
        if (FastMath.abs(this.y) > r0) goto L12;
        double r2 = this.x;
        double r6 = this.z;
        double r4 = 1.0d / FastMath.sqrt((r2 * r2) + (r6 * r6));
        return new Vector3D((-r4) * this.z, 0.0d, r4 * this.x);
    L12:
        double r7 = this.x;
        double r8 = this.y;
        double r9 = 1.0d / FastMath.sqrt((r7 * r7) + (r8 * r8));
        return new Vector3D(r9 * this.y, (-r9) * this.x, 0.0d);
    L15:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector scalarMultiply(double r1) {
        return scalarMultiply(r1);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D scalarMultiply(double r9) {
        return new Vector3D(r9 * this.x, this.y * r9, this.z * r9);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* synthetic */ Vector subtract(double r3, Vector r5) {
        return subtract(r3, (Vector) ZeusTransformUtils.wrapperContextForParams(r5, Vector.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* synthetic */ Vector subtract(Vector r3) {
        return subtract((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D subtract(double r10, Vector<Euclidean3D> r12) {
        return new Vector3D(1.0d, this, -r10, (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r12, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector3D subtract(Vector<Euclidean3D> r9) {
        Vector3D r10 = (Vector3D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r9, Vector.class, "com.obric.memorydata.plugin"), Vector3D.class, "com.obric.memorydata.plugin");
        return new Vector3D(this.x - r10.x, this.y - r10.y, this.z - r10.z);
    }

    public double[] toArray() {
        return new double[]{this.x, this.y, this.z};
    }

    public String toString() {
        return Vector3DFormat.getInstance().format(this);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public String toString(NumberFormat r2) {
        return new Vector3DFormat(r2).format(this);
    }
}
