package org.apache.commons.math3.geometry.euclidean.twod;

import com.volcengine.zeus.transform.ZeusTransformUtils;
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
public class Vector2D implements Vector<Euclidean2D> {
    public static final Vector2D NEGATIVE_INFINITY = null;
    public static final Vector2D NaN = null;
    public static final Vector2D POSITIVE_INFINITY = null;
    public static final Vector2D ZERO = null;
    private static final long serialVersionUID = 266938651998679754L;
    private final double x;
    private final double y;

    static {
        ZERO = new Vector2D(0.0d, 0.0d);
        NaN = new Vector2D(Double.NaN, Double.NaN);
        POSITIVE_INFINITY = new Vector2D(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);
        NEGATIVE_INFINITY = new Vector2D(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
    }

    public Vector2D(double r1, double r3) {
        this.x = r1;
        this.y = r3;
    }

    public Vector2D(double r3, Vector2D r5) {
        this.x = r5.x * r3;
        this.y = r3 * r5.y;
    }

    public Vector2D(double r5, Vector2D r7, double r8, Vector2D r10) {
        this.x = (r7.x * r5) + (r10.x * r8);
        this.y = (r5 * r7.y) + (r8 * r10.y);
    }

    public Vector2D(double r5, Vector2D r7, double r8, Vector2D r10, double r11, Vector2D r13) {
        this.x = ((r7.x * r5) + (r10.x * r8)) + (r13.x * r11);
        this.y = ((r5 * r7.y) + (r8 * r10.y)) + (r11 * r13.y);
    }

    public Vector2D(double r10, Vector2D r12, double r13, Vector2D r15, double r16, Vector2D r18, double r19, Vector2D r21) {
        this.x = (((r12.x * r10) + (r15.x * r13)) + (r18.x * r16)) + (r21.x * r19);
        this.y = (((r12.y * r10) + (r15.y * r13)) + (r18.y * r16)) + (r21.y * r19);
    }

    public Vector2D(double[] r3) {
        if (r3.length != 2) goto L7;
        this.x = r3[0];
        this.y = r3[1];
        return;
    L7:
        throw new DimensionMismatchException(r3.length, 2);
    }

    public static double angle(Vector2D r14, Vector2D r15) {
        double r0 = r14.getNorm() * r15.getNorm();
        if (r0 == 0.0d) goto L18;
        double r4 = r14.dotProduct(r15);
        double r6 = 0.9999d * r0;
        if (r4 >= (-r6)) goto L7;
    L11:
        double r16 = FastMath.abs(MathArrays.linearCombination(r14.x, r15.y, -r14.y, r15.x));
        if (r4 < 0.0d) goto L16;
        return FastMath.asin(r16 / r0);
    L16:
        return 3.141592653589793d - FastMath.asin(r16 / r0);
    L7:
        if (r4 > r6) goto L11;
        return FastMath.acos(r4 / r0);
    L18:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static double distance(Vector2D r0, Vector2D r1) {
        return r0.distance(r1);
    }

    public static double distanceInf(Vector2D r0, Vector2D r1) {
        return r0.distanceInf(r1);
    }

    public static double distanceSq(Vector2D r0, Vector2D r1) {
        return r0.distanceSq(r1);
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
    public Vector2D add(double r8, Vector<Euclidean2D> r10) {
        Vector2D r11 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r10, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return new Vector2D(this.x + (r11.getX() * r8), this.y + (r8 * r11.getY()));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D add(Vector<Euclidean2D> r6) {
        Vector2D r7 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r6, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return new Vector2D(this.x + r7.getX(), this.y + r7.getY());
    }

    public double crossProduct(Vector2D r13, Vector2D r14) {
        double r4 = r14.getX() - r13.getX();
        double r6 = getY() - r13.getY();
        double r0 = getX() - r13.getX();
        double r8 = -r0;
        return MathArrays.linearCombination(r4, r6, r8, r14.getY() - r13.getY());
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Euclidean2D> r5) {
        Vector2D r6 = (Vector2D) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r5, Point.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        double r0 = r6.x - this.x;
        double r2 = r6.y - this.y;
        return FastMath.sqrt((r0 * r0) + (r2 * r2));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance(Vector<Euclidean2D> r3) {
        return distance((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance1(Vector<Euclidean2D> r5) {
        Vector2D r6 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r5, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return FastMath.abs(r6.x - this.x) + FastMath.abs(r6.y - this.y);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceInf(Vector<Euclidean2D> r5) {
        Vector2D r6 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r5, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return FastMath.max(FastMath.abs(r6.x - this.x), FastMath.abs(r6.y - this.y));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceSq(Vector<Euclidean2D> r5) {
        Vector2D r6 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r5, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        double r0 = r6.x - this.x;
        double r2 = r6.y - this.y;
        return (r0 * r0) + (r2 * r2);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double dotProduct(Vector<Euclidean2D> r9) {
        Vector2D r10 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r9, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return MathArrays.linearCombination(this.x, r10.x, this.y, r10.y);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, Vector2D.class) == false) goto L18;
        Vector2D r10 = (Vector2D) ZeusTransformUtils.preCheckCast(r9, Vector2D.class, "com.obric.memorydata.plugin");
        if (r10.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.x != r10.x) goto L17;
        if (this.y != r10.y) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm() {
        double r0 = this.x;
        double r2 = this.y;
        return FastMath.sqrt((r0 * r0) + (r2 * r2));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm1() {
        return FastMath.abs(this.x) + FastMath.abs(this.y);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormInf() {
        return FastMath.max(FastMath.abs(this.x), FastMath.abs(this.y));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormSq() {
        double r0 = this.x;
        double r2 = this.y;
        return (r0 * r0) + (r2 * r2);
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Euclidean2D.getInstance();
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector getZero() {
        return getZero();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D getZero() {
        return ZERO;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 542;
    L7:
        return ((MathUtils.hash(this.x) * 76) + MathUtils.hash(this.y)) * 122;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public boolean isInfinite() {
        if (isNaN() == false) goto L5;
    L9:
        return false;
    L5:
        if (Double.isInfinite(this.x) == false) goto L7;
    L8:
        return true;
    L7:
        if (Double.isInfinite(this.y) == false) goto L9;
        goto L8
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        if (Double.isNaN(this.x) == false) goto L5;
    L8:
        return true;
    L5:
        if (Double.isNaN(this.y) == true) goto L8;
        return false;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D negate() {
        return new Vector2D(-this.x, -this.y);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector normalize() {
        return normalize();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D normalize() {
        double r0 = getNorm();
        if (r0 == 0.0d) goto L7;
        return scalarMultiply(1.0d / r0);
    L7:
        throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector scalarMultiply(double r1) {
        return scalarMultiply(r1);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D scalarMultiply(double r6) {
        return new Vector2D(this.x * r6, r6 * this.y);
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
    public Vector2D subtract(double r8, Vector<Euclidean2D> r10) {
        Vector2D r11 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r10, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return new Vector2D(this.x - (r11.getX() * r8), this.y - (r8 * r11.getY()));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector2D subtract(Vector<Euclidean2D> r6) {
        Vector2D r7 = (Vector2D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r6, Vector.class, "com.obric.memorydata.plugin"), Vector2D.class, "com.obric.memorydata.plugin");
        return new Vector2D(this.x - r7.x, this.y - r7.y);
    }

    public double[] toArray() {
        return new double[]{this.x, this.y};
    }

    public String toString() {
        return Vector2DFormat.getInstance().format(this);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public String toString(NumberFormat r2) {
        return new Vector2DFormat(r2).format(this);
    }
}
