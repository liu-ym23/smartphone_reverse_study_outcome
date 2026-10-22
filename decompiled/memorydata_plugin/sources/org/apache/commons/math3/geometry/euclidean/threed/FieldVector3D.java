package org.apache.commons.math3.geometry.euclidean.threed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.text.NumberFormat;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldVector3D<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20130224;
    private final T x;
    private final T y;
    private final T z;

    public FieldVector3D(double r4, FieldVector3D<T> r6) {
        this.x = (T) ZeusTransformUtils.preCheckCast(r6.x.multiply(r4), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r6.y.multiply(r4), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r6.z.multiply(r4), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(double r10, FieldVector3D<T> r12, double r13, FieldVector3D<T> r15) {
        RealFieldElement r7 = r12.getX();
        this.x = (T) ZeusTransformUtils.preCheckCast(r7.linearCombination(r10, r12.getX(), r13, r15.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r7.linearCombination(r10, r12.getY(), r13, r15.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r7.linearCombination(r10, r12.getZ(), r13, r15.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(double r14, FieldVector3D<T> r16, double r17, FieldVector3D<T> r19, double r20, FieldVector3D<T> r22) {
        RealFieldElement r11 = r16.getX();
        this.x = (T) ZeusTransformUtils.preCheckCast(r11.linearCombination(r14, r16.getX(), r17, r19.getX(), r20, r22.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r11.linearCombination(r14, r16.getY(), r17, r19.getY(), r20, r22.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r11.linearCombination(r14, r16.getZ(), r17, r19.getZ(), r20, r22.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(double r17, FieldVector3D<T> r19, double r20, FieldVector3D<T> r22, double r23, FieldVector3D<T> r25, double r26, FieldVector3D<T> r28) {
        RealFieldElement r14 = r19.getX();
        this.x = (T) ZeusTransformUtils.preCheckCast(r14.linearCombination(r17, r19.getX(), r20, r22.getX(), r23, r25.getX(), r26, r28.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r14.linearCombination(r17, r19.getY(), r20, r22.getY(), r23, r25.getY(), r26, r28.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r14.linearCombination(r17, r19.getZ(), r20, r22.getZ(), r23, r25.getZ(), r26, r28.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r5, T r6) {
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r5, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r8 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r6, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r8.cos(), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r7.cos(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r7.sin(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r8.sin(), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r3, T r4, T r5) {
        T r6 = (T) ZeusTransformUtils.wrapperContextForParams(r3, RealFieldElement.class, "com.obric.memorydata.plugin");
        T r7 = (T) ZeusTransformUtils.wrapperContextForParams(r4, RealFieldElement.class, "com.obric.memorydata.plugin");
        T r8 = (T) ZeusTransformUtils.wrapperContextForParams(r5, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = r6;
        this.y = r7;
        this.z = r8;
    }

    public FieldVector3D(T r4, FieldVector3D<T> r5) {
        RealFieldElement r6 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r4, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(r6.multiply(r5.x), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r6.multiply(r5.y), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r6.multiply(r5.z), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r4, FieldVector3D<T> r5, T r6, FieldVector3D<T> r7) {
        RealFieldElement r8 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r4, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r9 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r6, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(r8.linearCombination(r8, r5.getX(), r9, r7.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r8.linearCombination(r8, r5.getY(), r9, r7.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r8.linearCombination(r8, r5.getZ(), r9, r7.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r10, FieldVector3D<T> r11, T r12, FieldVector3D<T> r13, T r14, FieldVector3D<T> r15) {
        RealFieldElement r16 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r10, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r17 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r12, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r18 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r14, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(r16.linearCombination(r16, r11.getX(), r17, r13.getX(), r18, r15.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r16.linearCombination(r16, r11.getY(), r17, r13.getY(), r18, r15.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r16.linearCombination(r16, r11.getZ(), r17, r13.getZ(), r18, r15.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r16, FieldVector3D<T> r17, T r18, FieldVector3D<T> r19, T r20, FieldVector3D<T> r21, T r22, FieldVector3D<T> r23) {
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r16, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r12 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r18, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r13 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r20, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r14 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r22, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r1, r17.getX(), r12, r19.getX(), r13, r21.getX(), r14, r23.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r1, r17.getY(), r12, r19.getY(), r13, r21.getY(), r14, r23.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r1, r17.getZ(), r12, r19.getZ(), r13, r21.getZ(), r14, r23.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r5, Vector3D r6) {
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r5, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(r7.multiply(r6.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r7.multiply(r6.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r7.multiply(r6.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r10, Vector3D r11, T r12, Vector3D r13) {
        RealFieldElement r14 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r10, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r15 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r12, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(r14.linearCombination(r11.getX(), r14, r13.getX(), r15), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r14.linearCombination(r11.getY(), r14, r13.getY(), r15), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r14.linearCombination(r11.getZ(), r14, r13.getZ(), r15), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r16, Vector3D r17, T r18, Vector3D r19, T r20, Vector3D r21) {
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r16, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r13 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r18, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r14 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r20, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r17.getX(), r1, r19.getX(), r13, r21.getX(), r14), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r17.getY(), r1, r19.getY(), r13, r21.getY(), r14), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r17.getZ(), r1, r19.getZ(), r13, r21.getZ(), r14), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T r20, Vector3D r21, T r22, Vector3D r23, T r24, Vector3D r25, T r26, Vector3D r27) {
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r20, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r16 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r22, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r17 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r24, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r18 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r26, RealFieldElement.class, "com.obric.memorydata.plugin");
        this.x = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r21.getX(), r1, r23.getX(), r16, r25.getX(), r17, r27.getX(), r18), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.y = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r21.getY(), r1, r23.getY(), r16, r25.getY(), r17, r27.getY(), r18), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.z = (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r21.getZ(), r1, r23.getZ(), r16, r25.getZ(), r17, r27.getZ(), r18), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldVector3D(T[] r3) {
        if (r3.length != 3) goto L7;
        this.x = r3[0];
        this.y = r3[1];
        this.z = r3[2];
        return;
    L7:
        throw new DimensionMismatchException(r3.length, 3);
    }

    public static <T extends RealFieldElement<T>> T angle(FieldVector3D<T> r11, FieldVector3D<T> r12) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r11.getNorm().multiply(r12.getNorm()), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r0.getReal() == 0.0d) goto L17;
        RealFieldElement r1 = dotProduct(r11, r12);
        double r3 = r0.getReal() * 0.9999d;
        if (r1.getReal() >= (-r3)) goto L7;
    L12:
        FieldVector3D r13 = crossProduct(r11, r12);
        double r4 = r1.getReal();
        T r14 = r13.getNorm().divide(r0);
        if (r4 < 0.0d) goto L15;
        Object r15 = ((RealFieldElement) ZeusTransformUtils.preCheckCast(r14, RealFieldElement.class, "com.obric.memorydata.plugin")).asin();
    L11:
        return (T) ZeusTransformUtils.preCheckCast(r15, RealFieldElement.class, "com.obric.memorydata.plugin");
    L15:
        r15 = ((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r14, RealFieldElement.class, "com.obric.memorydata.plugin")).asin(), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(3.141592653589793d), RealFieldElement.class, "com.obric.memorydata.plugin")).negate();
        goto L11
    L7:
        if (r1.getReal() > r3) goto L12;
        r15 = ((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.divide(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).acos();
        goto L11
    L17:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static <T extends RealFieldElement<T>> T angle(FieldVector3D<T> r11, Vector3D r12) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r11.getNorm().multiply(r12.getNorm()), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r0.getReal() == 0.0d) goto L17;
        RealFieldElement r1 = dotProduct(r11, r12);
        double r3 = r0.getReal() * 0.9999d;
        if (r1.getReal() >= (-r3)) goto L7;
    L12:
        FieldVector3D r13 = crossProduct(r11, r12);
        double r4 = r1.getReal();
        T r14 = r13.getNorm().divide(r0);
        if (r4 < 0.0d) goto L15;
        Object r15 = ((RealFieldElement) ZeusTransformUtils.preCheckCast(r14, RealFieldElement.class, "com.obric.memorydata.plugin")).asin();
    L11:
        return (T) ZeusTransformUtils.preCheckCast(r15, RealFieldElement.class, "com.obric.memorydata.plugin");
    L15:
        r15 = ((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r14, RealFieldElement.class, "com.obric.memorydata.plugin")).asin(), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(3.141592653589793d), RealFieldElement.class, "com.obric.memorydata.plugin")).negate();
        goto L11
    L7:
        if (r1.getReal() > r3) goto L12;
        r15 = ((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.divide(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).acos();
        goto L11
    L17:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public static <T extends RealFieldElement<T>> T angle(Vector3D r0, FieldVector3D<T> r1) {
        return (T) angle(r1, r0);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return r0.crossProduct(r1);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(FieldVector3D<T> r0, Vector3D r1) {
        return r0.crossProduct(r1);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> crossProduct(Vector3D r11, FieldVector3D<T> r12) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldVector3D) r12).x.linearCombination(r11.getY(), ((FieldVector3D) r12).z, -r11.getZ(), ((FieldVector3D) r12).y), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldVector3D) r12).y.linearCombination(r11.getZ(), ((FieldVector3D) r12).x, -r11.getX(), ((FieldVector3D) r12).z), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldVector3D) r12).z.linearCombination(r11.getX(), ((FieldVector3D) r12).y, -r11.getY(), ((FieldVector3D) r12).x), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public static <T extends RealFieldElement<T>> T distance(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.distance(r1);
    }

    public static <T extends RealFieldElement<T>> T distance(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.distance(r1);
    }

    public static <T extends RealFieldElement<T>> T distance(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.distance(r0);
    }

    public static <T extends RealFieldElement<T>> T distance1(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.distance1(r1);
    }

    public static <T extends RealFieldElement<T>> T distance1(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.distance1(r1);
    }

    public static <T extends RealFieldElement<T>> T distance1(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.distance1(r0);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.distanceInf(r1);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.distanceInf(r1);
    }

    public static <T extends RealFieldElement<T>> T distanceInf(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.distanceInf(r0);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.distanceSq(r1);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.distanceSq(r1);
    }

    public static <T extends RealFieldElement<T>> T distanceSq(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.distanceSq(r0);
    }

    public static <T extends RealFieldElement<T>> T dotProduct(FieldVector3D<T> r0, FieldVector3D<T> r1) {
        return (T) r0.dotProduct(r1);
    }

    public static <T extends RealFieldElement<T>> T dotProduct(FieldVector3D<T> r0, Vector3D r1) {
        return (T) r0.dotProduct(r1);
    }

    public static <T extends RealFieldElement<T>> T dotProduct(Vector3D r0, FieldVector3D<T> r1) {
        return (T) r1.dotProduct(r0);
    }

    public FieldVector3D<T> add(double r9, FieldVector3D<T> r11) {
        return new FieldVector3D(1.0d, this, r9, r11);
    }

    public FieldVector3D<T> add(double r7, Vector3D r9) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.add(r9.getX() * r7), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.add(r9.getY() * r7), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.add(r7 * r9.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> add(T r5, FieldVector3D<T> r6) {
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r5, RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.getField().getOne(), RealFieldElement.class, "com.obric.memorydata.plugin"), this, r7, r6);
    }

    public FieldVector3D<T> add(T r7, Vector3D r8) {
        RealFieldElement r9 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r7, RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.add(r9.multiply(r8.getX())), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.add(r9.multiply(r8.getY())), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.add(r9.multiply(r8.getZ())), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> add(FieldVector3D<T> r6) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.add(r6.x), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.add(r6.y), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.add(r6.z), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> add(Vector3D r7) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.add(r7.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.add(r7.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.add(r7.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> crossProduct(FieldVector3D<T> r9) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.linearCombination(this.y, r9.z, this.z.negate(), r9.y), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.linearCombination(this.z, r9.x, this.x.negate(), r9.z), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.linearCombination(this.x, r9.y, this.y.negate(), r9.x), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> crossProduct(Vector3D r12) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.linearCombination(r12.getZ(), this.y, -r12.getY(), this.z), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.linearCombination(r12.getX(), this.z, -r12.getZ(), this.x), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.linearCombination(r12.getY(), this.x, -r12.getX(), this.y), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public T distance(FieldVector3D<T> r5) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.x.subtract(this.x), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.y.subtract(this.y), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r4 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.z.subtract(this.z), RealFieldElement.class, "com.obric.memorydata.plugin");
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.multiply(r1)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r4.multiply(r4)), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T distance(Vector3D r6) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.subtract(r6.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.subtract(r6.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.subtract(r6.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.multiply(r1)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5.multiply(r5)), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T distance1(FieldVector3D<T> r5) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.x.subtract(this.x), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.y.subtract(this.y), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r4 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.z.subtract(this.z), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.add(r1), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r4), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T distance1(Vector3D r6) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.subtract(r6.getX()), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.subtract(r6.getY()), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.subtract(r6.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.add(r1), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T distanceInf(FieldVector3D<T> r7) {
        T r0 = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r7.x.subtract(this.x), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r1 = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r7.y.subtract(this.y), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r6 = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r7.z.subtract(this.z), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r0.getReal() > r1.getReal()) goto L9;
        if (r1.getReal() > r6.getReal()) goto L7;
        return r6;
    L7:
        return r1;
    L9:
        if (r0.getReal() > r6.getReal()) goto L11;
        return r6;
    L11:
        return r0;
    }

    public T distanceInf(Vector3D r7) {
        T r0 = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.subtract(r7.getX()), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r1 = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.subtract(r7.getY()), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r6 = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.subtract(r7.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin")).abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r0.getReal() > r1.getReal()) goto L9;
        if (r1.getReal() > r6.getReal()) goto L7;
        return r6;
    L7:
        return r1;
    L9:
        if (r0.getReal() > r6.getReal()) goto L11;
        return r6;
    L11:
        return r0;
    }

    public T distanceSq(FieldVector3D<T> r5) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.x.subtract(this.x), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.y.subtract(this.y), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r4 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.z.subtract(this.z), RealFieldElement.class, "com.obric.memorydata.plugin");
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.multiply(r1)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r4.multiply(r4)), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T distanceSq(Vector3D r6) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.subtract(r6.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.subtract(r6.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.subtract(r6.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.multiply(r1)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5.multiply(r5)), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T dotProduct(FieldVector3D<T> r8) {
        T r1 = this.x;
        return (T) ZeusTransformUtils.preCheckCast(r1.linearCombination(r1, r8.x, this.y, r8.y, this.z, r8.z), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T dotProduct(Vector3D r11) {
        return (T) ZeusTransformUtils.preCheckCast(this.x.linearCombination(r11.getX(), this.x, r11.getY(), this.y, r11.getZ(), this.z), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FieldVector3D.class) == false) goto L20;
        FieldVector3D r6 = (FieldVector3D) ZeusTransformUtils.preCheckCast(r5, FieldVector3D.class, "com.obric.memorydata.plugin");
        if (r6.isNaN() == false) goto L12;
        return isNaN();
    L12:
        if (this.x.equals(r6.x) == false) goto L19;
        if (this.y.equals(r6.y) == false) goto L19;
        if (this.z.equals(r6.z) == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return false;
    }

    public T getAlpha() {
        return (T) ZeusTransformUtils.preCheckCast(this.y.atan2(this.x), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T getDelta() {
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.divide(getNorm()), RealFieldElement.class, "com.obric.memorydata.plugin")).asin(), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T getNorm() {
        T r0 = this.x;
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r2 = this.y;
        RealFieldElement r3 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r1.add(r2.multiply(r2)), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r4 = this.z;
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.add(r4.multiply(r4)), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T getNorm1() {
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.abs(), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.y.abs()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.z.abs()), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T getNormInf() {
        T r0 = (T) ZeusTransformUtils.preCheckCast(this.x.abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r1 = (T) ZeusTransformUtils.preCheckCast(this.y.abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r6 = (T) ZeusTransformUtils.preCheckCast(this.z.abs(), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r0.getReal() > r1.getReal()) goto L9;
        if (r1.getReal() > r6.getReal()) goto L7;
        return r6;
    L7:
        return r1;
    L9:
        if (r0.getReal() > r6.getReal()) goto L11;
        return r6;
    L11:
        return r0;
    }

    public T getNormSq() {
        T r0 = this.x;
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r2 = this.y;
        RealFieldElement r3 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r1.add(r2.multiply(r2)), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r4 = this.z;
        return (T) ZeusTransformUtils.preCheckCast(r3.add(r4.multiply(r4)), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }

    public T getZ() {
        return this.z;
    }

    public int hashCode() {
        if (isNaN() == false) goto L7;
        return 409;
    L7:
        return (((this.x.hashCode() * 107) + (this.y.hashCode() * 83)) + this.z.hashCode()) * 311;
    }

    public boolean isInfinite() {
        if (isNaN() == false) goto L5;
    L11:
        return false;
    L5:
        if (Double.isInfinite(this.x.getReal()) == false) goto L7;
    L10:
        return true;
    L7:
        if (Double.isInfinite(this.y.getReal()) == true) goto L10;
        if (Double.isInfinite(this.z.getReal()) == false) goto L11;
        goto L10
    }

    public boolean isNaN() {
        if (Double.isNaN(this.x.getReal()) == false) goto L5;
    L10:
        return true;
    L5:
        if (Double.isNaN(this.y.getReal()) == true) goto L10;
        if (Double.isNaN(this.z.getReal()) == true) goto L10;
        return false;
    }

    public FieldVector3D<T> negate() {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.negate(), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> normalize() {
        RealFieldElement r0 = getNorm();
        if (r0.getReal() == 0.0d) goto L7;
        return scalarMultiply((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L7:
        throw new MathArithmeticException(LocalizedFormats.CANNOT_NORMALIZE_A_ZERO_NORM_VECTOR, new Object[0]);
    }

    public FieldVector3D<T> orthogonal() {
        double r0 = getNorm().getReal() * 0.6d;
        if (r0 == 0.0d) goto L15;
        if (FastMath.abs(this.x.getReal()) > r0) goto L9;
        T r1 = this.y;
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r1), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r3 = this.z;
        RealFieldElement r4 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(r3.multiply(r3)), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(r4.getField().getZero(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r4.multiply(this.z), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r4.multiply(this.y), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L9:
        if (FastMath.abs(this.y.getReal()) > r0) goto L12;
        T r5 = this.x;
        RealFieldElement r6 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r7 = this.z;
        RealFieldElement r8 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.add(r7.multiply(r7)), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r8.multiply(this.z), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r8.getField().getZero(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r8.multiply(this.x), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L12:
        T r9 = this.x;
        RealFieldElement r10 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r9.multiply(r9), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r11 = this.y;
        RealFieldElement r12 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.add(r11.multiply(r11)), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(r12.multiply(this.y), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12.multiply(this.x), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r12.getField().getZero(), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L15:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM, new Object[0]);
    }

    public FieldVector3D<T> scalarMultiply(double r6) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> scalarMultiply(T r6) {
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r6, RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.multiply(r7), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.multiply(r7), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.multiply(r7), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> subtract(double r9, FieldVector3D<T> r11) {
        return new FieldVector3D(1.0d, this, -r9, r11);
    }

    public FieldVector3D<T> subtract(double r7, Vector3D r9) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.subtract(r9.getX() * r7), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.subtract(r9.getY() * r7), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.subtract(r7 * r9.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> subtract(T r5, FieldVector3D<T> r6) {
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r5, RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.getField().getOne(), RealFieldElement.class, "com.obric.memorydata.plugin"), this, (RealFieldElement) ZeusTransformUtils.preCheckCast(r7.negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), r6);
    }

    public FieldVector3D<T> subtract(T r7, Vector3D r8) {
        RealFieldElement r9 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r7, RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.subtract(r9.multiply(r8.getX())), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.subtract(r9.multiply(r8.getY())), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.subtract(r9.multiply(r8.getZ())), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> subtract(FieldVector3D<T> r6) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.subtract(r6.x), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.subtract(r6.y), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.subtract(r6.z), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> subtract(Vector3D r7) {
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.x.subtract(r7.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.y.subtract(r7.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.z.subtract(r7.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public T[] toArray() {
        T[] r0 = (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.x.getField(), 3), RealFieldElement[].class, "com.obric.memorydata.plugin"));
        r0[0] = this.x;
        r0[1] = this.y;
        r0[2] = this.z;
        return r0;
    }

    public String toString() {
        return Vector3DFormat.getInstance().format(toVector3D());
    }

    public String toString(NumberFormat r2) {
        return new Vector3DFormat(r2).format(toVector3D());
    }

    public Vector3D toVector3D() {
        return new Vector3D(this.x.getReal(), this.y.getReal(), this.z.getReal());
    }
}
