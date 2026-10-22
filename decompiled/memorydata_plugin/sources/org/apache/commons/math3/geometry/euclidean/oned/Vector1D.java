package org.apache.commons.math3.geometry.euclidean.oned;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.NumberFormat;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Vector1D implements Vector<Euclidean1D> {
    public static final Vector1D NEGATIVE_INFINITY = null;
    public static final Vector1D NaN = null;
    public static final Vector1D ONE = null;
    public static final Vector1D POSITIVE_INFINITY = null;
    public static final Vector1D ZERO = null;
    private static final long serialVersionUID = 7556674948671647925L;
    private final double x;

    static {
        ZERO = new Vector1D(0.0d);
        ONE = new Vector1D(1.0d);
        NaN = new Vector1D(Double.NaN);
        POSITIVE_INFINITY = new Vector1D(Double.POSITIVE_INFINITY);
        NEGATIVE_INFINITY = new Vector1D(Double.NEGATIVE_INFINITY);
    }

    public Vector1D(double r1) {
        this.x = r1;
    }

    public Vector1D(double r3, Vector1D r5) {
        this.x = r3 * r5.x;
    }

    public Vector1D(double r3, Vector1D r5, double r6, Vector1D r8) {
        this.x = (r3 * r5.x) + (r6 * r8.x);
    }

    public Vector1D(double r3, Vector1D r5, double r6, Vector1D r8, double r9, Vector1D r11) {
        this.x = ((r3 * r5.x) + (r6 * r8.x)) + (r9 * r11.x);
    }

    public Vector1D(double r3, Vector1D r5, double r6, Vector1D r8, double r9, Vector1D r11, double r12, Vector1D r14) {
        this.x = (((r3 * r5.x) + (r6 * r8.x)) + (r9 * r11.x)) + (r12 * r14.x);
    }

    public static double distance(Vector1D r0, Vector1D r1) {
        return r0.distance(r1);
    }

    public static double distanceInf(Vector1D r0, Vector1D r1) {
        return r0.distanceInf(r1);
    }

    public static double distanceSq(Vector1D r0, Vector1D r1) {
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
    public Vector1D add(double r6, Vector<Euclidean1D> r8) {
        Vector1D r9 = (Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r8, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin");
        return new Vector1D(this.x + (r6 * r9.getX()));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector1D add(Vector<Euclidean1D> r4) {
        Vector1D r5 = (Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r4, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin");
        return new Vector1D(this.x + r5.getX());
    }

    @Override // org.apache.commons.math3.geometry.Point
    public double distance(Point<Euclidean1D> r3) {
        return FastMath.abs(((Vector1D) ZeusTransformUtils.preCheckCast((Point) ZeusTransformUtils.wrapperContextForParams(r3, Point.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin")).x - this.x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    @Deprecated
    public double distance(Vector<Euclidean1D> r3) {
        return distance((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distance1(Vector<Euclidean1D> r3) {
        return FastMath.abs(((Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin")).x - this.x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceInf(Vector<Euclidean1D> r3) {
        return FastMath.abs(((Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin")).x - this.x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double distanceSq(Vector<Euclidean1D> r3) {
        double r0 = ((Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin")).x - this.x;
        return r0 * r0;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double dotProduct(Vector<Euclidean1D> r3) {
        Vector1D r4 = (Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r3, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin");
        return this.x * r4.x;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, Vector1D.class) == false) goto L16;
        Vector1D r8 = (Vector1D) ZeusTransformUtils.preCheckCast(r7, Vector1D.class, "com.obric.memorydata.plugin");
        if (r8.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.x != r8.x) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm() {
        return FastMath.abs(this.x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNorm1() {
        return FastMath.abs(this.x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormInf() {
        return FastMath.abs(this.x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public double getNormSq() {
        double r0 = this.x;
        return r0 * r0;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public Space getSpace() {
        return Euclidean1D.getInstance();
    }

    public double getX() {
        return this.x;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector getZero() {
        return getZero();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector1D getZero() {
        return ZERO;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 7785;
    L7:
        return MathUtils.hash(this.x) * 997;
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public boolean isInfinite() {
        if (isNaN() == false) goto L5;
    L7:
        return false;
    L5:
        if (Double.isInfinite(this.x) == false) goto L7;
        return true;
    }

    @Override // org.apache.commons.math3.geometry.Point
    public boolean isNaN() {
        return Double.isNaN(this.x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector negate() {
        return negate();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector1D negate() {
        return new Vector1D(-this.x);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public /* bridge */ /* synthetic */ Vector normalize() {
        return normalize();
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector1D normalize() {
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
    public Vector1D scalarMultiply(double r4) {
        return new Vector1D(r4 * this.x);
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
    public Vector1D subtract(double r6, Vector<Euclidean1D> r8) {
        Vector1D r9 = (Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r8, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin");
        return new Vector1D(this.x - (r6 * r9.getX()));
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public Vector1D subtract(Vector<Euclidean1D> r4) {
        Vector1D r5 = (Vector1D) ZeusTransformUtils.preCheckCast((Vector) ZeusTransformUtils.wrapperContextForParams(r4, Vector.class, "com.obric.memorydata.plugin"), Vector1D.class, "com.obric.memorydata.plugin");
        return new Vector1D(this.x - r5.x);
    }

    public String toString() {
        return Vector1DFormat.getInstance().format(this);
    }

    @Override // org.apache.commons.math3.geometry.Vector
    public String toString(NumberFormat r2) {
        return new Vector1DFormat(r2).format(this);
    }
}
