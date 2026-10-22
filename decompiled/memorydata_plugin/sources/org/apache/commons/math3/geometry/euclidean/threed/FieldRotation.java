package org.apache.commons.math3.geometry.euclidean.threed;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

/* JADX INFO: loaded from: classes6.dex */
public class FieldRotation<T extends RealFieldElement<T>> implements Serializable {
    private static final long serialVersionUID = 20130224;
    private final T q0;
    private final T q1;
    private final T q2;
    private final T q3;

    public FieldRotation(T r3, T r4, T r5, T r6, boolean r7) {
        T r8 = (T) ZeusTransformUtils.wrapperContextForParams(r3, RealFieldElement.class, "com.obric.memorydata.plugin");
        T r9 = (T) ZeusTransformUtils.wrapperContextForParams(r4, RealFieldElement.class, "com.obric.memorydata.plugin");
        T r10 = (T) ZeusTransformUtils.wrapperContextForParams(r5, RealFieldElement.class, "com.obric.memorydata.plugin");
        T r11 = (T) ZeusTransformUtils.wrapperContextForParams(r6, RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r7 == false) goto L5;
        RealFieldElement r12 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r8.multiply(r8), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r9.multiply(r9)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.multiply(r10)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r11.multiply(r11)), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q0 = (T) ZeusTransformUtils.preCheckCast(r12.multiply(r8), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q1 = (T) ZeusTransformUtils.preCheckCast(r12.multiply(r9), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q2 = (T) ZeusTransformUtils.preCheckCast(r12.multiply(r10), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q3 = (T) ZeusTransformUtils.preCheckCast(r12.multiply(r11), RealFieldElement.class, "com.obric.memorydata.plugin");
        return;
    L5:
        this.q0 = r8;
        this.q1 = r9;
        this.q2 = r10;
        this.q3 = r11;
    }

    @Deprecated
    public FieldRotation(FieldVector3D<T> r3, T r4) {
        this(r3, (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r4, RealFieldElement.class, "com.obric.memorydata.plugin"), RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation(FieldVector3D<T> r7, T r8, RotationConvention r9) {
        RealFieldElement r10 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r8, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r0 = r7.getNorm();
        if (r0.getReal() == 0.0d) goto L11;
        if (r9 != RotationConvention.VECTOR_OPERATOR) goto L7;
        double r2 = -0.5d;
    L8:
        RealFieldElement r11 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r10.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r12 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.sin(), RealFieldElement.class, "com.obric.memorydata.plugin")).divide(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q0 = (T) ZeusTransformUtils.preCheckCast(r11.cos(), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q1 = (T) ZeusTransformUtils.preCheckCast(r12.multiply(r7.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q2 = (T) ZeusTransformUtils.preCheckCast(r12.multiply(r7.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q3 = (T) ZeusTransformUtils.preCheckCast(r12.multiply(r7.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin");
        return;
    L7:
        r2 = 0.5d;
        goto L8
    L11:
        throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_AXIS, new Object[0]);
    }

    public FieldRotation(FieldVector3D<T> r10, FieldVector3D<T> r11) {
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r10.getNorm().multiply(r11.getNorm()), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r0.getReal() == 0.0d) goto L11;
        RealFieldElement r1 = FieldVector3D.dotProduct(r10, r11);
        if (r1.getReal() >= (r0.getReal() * (-0.999999999999998d))) goto L7;
        FieldVector3D<T> r12 = r10.orthogonal();
        this.q0 = (T) ZeusTransformUtils.preCheckCast(r0.getField().getZero(), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q1 = (T) ZeusTransformUtils.preCheckCast(r12.getX().negate(), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q2 = (T) ZeusTransformUtils.preCheckCast(r12.getY().negate(), RealFieldElement.class, "com.obric.memorydata.plugin");
        Object r13 = r12.getZ().negate();
    L8:
        this.q3 = (T) ZeusTransformUtils.preCheckCast(r13, RealFieldElement.class, "com.obric.memorydata.plugin");
        return;
    L7:
        T r2 = (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.divide(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(1.0d), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.5d), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q0 = r2;
        RealFieldElement r3 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2.0d), RealFieldElement.class, "com.obric.memorydata.plugin")).reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin");
        FieldVector3D r14 = FieldVector3D.crossProduct(r11, r10);
        this.q1 = (T) ZeusTransformUtils.preCheckCast(r3.multiply(r14.getX()), RealFieldElement.class, "com.obric.memorydata.plugin");
        this.q2 = (T) ZeusTransformUtils.preCheckCast(r3.multiply(r14.getY()), RealFieldElement.class, "com.obric.memorydata.plugin");
        r13 = r3.multiply(r14.getZ());
        goto L8
    L11:
        throw new MathArithmeticException(LocalizedFormats.ZERO_NORM_FOR_ROTATION_DEFINING_VECTOR, new Object[0]);
    }

    public FieldRotation(FieldVector3D<T> r17, FieldVector3D<T> r18, FieldVector3D<T> r19, FieldVector3D<T> r20) {
        FieldVector3D<T> r1 = FieldVector3D.crossProduct(r17, r18).normalize();
        FieldVector3D<T> r3 = FieldVector3D.crossProduct(r1, r17).normalize();
        FieldVector3D<T> r2 = r17.normalize();
        FieldVector3D<T> r4 = FieldVector3D.crossProduct(r19, r20).normalize();
        FieldVector3D<T> r6 = FieldVector3D.crossProduct(r4, r19).normalize();
        FieldVector3D<T> r5 = r19.normalize();
        RealFieldElement[][] r7 = (RealFieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r2.getX().getField(), 3, 3), RealFieldElement[][].class, "com.obric.memorydata.plugin");
        r7[0][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getX().multiply(r5.getX()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getX().multiply(r6.getX())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getX().multiply(r4.getX())), RealFieldElement.class, "com.obric.memorydata.plugin");
        r7[0][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getY().multiply(r5.getX()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getY().multiply(r6.getX())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getY().multiply(r4.getX())), RealFieldElement.class, "com.obric.memorydata.plugin");
        r7[0][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getZ().multiply(r5.getX()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getZ().multiply(r6.getX())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getZ().multiply(r4.getX())), RealFieldElement.class, "com.obric.memorydata.plugin");
        r7[1][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getX().multiply(r5.getY()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getX().multiply(r6.getY())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getX().multiply(r4.getY())), RealFieldElement.class, "com.obric.memorydata.plugin");
        r7[1][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getY().multiply(r5.getY()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getY().multiply(r6.getY())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getY().multiply(r4.getY())), RealFieldElement.class, "com.obric.memorydata.plugin");
        r7[1][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getZ().multiply(r5.getY()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getZ().multiply(r6.getY())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getZ().multiply(r4.getY())), RealFieldElement.class, "com.obric.memorydata.plugin");
        r7[2][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getX().multiply(r5.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getX().multiply(r6.getZ())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getX().multiply(r4.getZ())), RealFieldElement.class, "com.obric.memorydata.plugin");
        r7[2][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getY().multiply(r5.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getY().multiply(r6.getZ())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getY().multiply(r4.getZ())), RealFieldElement.class, "com.obric.memorydata.plugin");
        r7[2][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getZ().multiply(r5.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r3.getZ().multiply(r6.getZ())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.getZ().multiply(r4.getZ())), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement[] r8 = mat2quat(r7);
        this.q0 = (T) r8[0];
        this.q1 = (T) r8[1];
        this.q2 = (T) r8[2];
        this.q3 = (T) r8[3];
    }

    @Deprecated
    public FieldRotation(RotationOrder r9, T r10, T r11, T r12) {
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r10, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r6 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r11, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r12, RealFieldElement.class, "com.obric.memorydata.plugin");
        this(r9, RotationConvention.VECTOR_OPERATOR, r5, r6, r7);
    }

    public FieldRotation(RotationOrder r5, RotationConvention r6, T r7, T r8, T r9) {
        RealFieldElement r10 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r7, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r11 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r8, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r12 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r9, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r0 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r10.getField().getOne(), RealFieldElement.class, "com.obric.memorydata.plugin");
        FieldRotation<T> r13 = new FieldRotation(new FieldVector3D(r0, r5.getA1()), r10, r6).compose(new FieldRotation(new FieldVector3D(r0, r5.getA2()), r11, r6).compose(new FieldRotation(new FieldVector3D(r0, r5.getA3()), r12, r6), r6), r6);
        this.q0 = r13.q0;
        this.q1 = r13.q1;
        this.q2 = r13.q2;
        this.q3 = r13.q3;
    }

    public FieldRotation(T[][] r10, double r11) {
        if (r10.length != 3) goto L17;
        if (r10[0].length != 3) goto L17;
        if (r10[1].length != 3) goto L17;
        if (r10[2].length != 3) goto L17;
        RealFieldElement[][] r12 = orthogonalizeMatrix(r10, r11);
        RealFieldElement r13 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12[0][0].multiply((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12[1][1].multiply(r12[2][2]), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r12[2][1].multiply(r12[1][2])), RealFieldElement.class, "com.obric.memorydata.plugin")), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r12[1][0].multiply((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12[0][1].multiply(r12[2][2]), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r12[2][1].multiply(r12[0][2])), RealFieldElement.class, "com.obric.memorydata.plugin"))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r12[2][0].multiply((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12[0][1].multiply(r12[1][2]), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r12[1][1].multiply(r12[0][2])), RealFieldElement.class, "com.obric.memorydata.plugin"))), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r13.getReal() < 0.0d) goto L15;
        RealFieldElement[] r14 = mat2quat(r12);
        this.q0 = (T) r14[0];
        this.q1 = (T) r14[1];
        this.q2 = (T) r14[2];
        this.q3 = (T) r14[3];
        return;
    L15:
        throw new NotARotationMatrixException(LocalizedFormats.CLOSEST_ORTHOGONAL_MATRIX_HAS_NEGATIVE_DETERMINANT, new Object[]{r13});
    L17:
        throw new NotARotationMatrixException(LocalizedFormats.ROTATION_MATRIX_DIMENSIONS, new Object[]{Integer.valueOf(r10.length), Integer.valueOf(r10[0].length)});
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyInverseTo(Rotation r10, FieldRotation<T> r11) {
        return new FieldRotation((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r11).q0.multiply(r10.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r11).q1.multiply(r10.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((FieldRotation) r11).q2.multiply(r10.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((FieldRotation) r11).q3.multiply(r10.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r11).q0.multiply(r10.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r11).q2.multiply(r10.getQ3()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r11).q3.multiply(r10.getQ2()))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r11).q1.multiply(r10.getQ0())), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r11).q0.multiply(r10.getQ2()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r11).q3.multiply(r10.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r11).q1.multiply(r10.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r11).q2.multiply(r10.getQ0())), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r11).q0.multiply(r10.getQ3()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r11).q1.multiply(r10.getQ2()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r11).q2.multiply(r10.getQ1()))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r11).q3.multiply(r10.getQ0())), RealFieldElement.class, "com.obric.memorydata.plugin"), false);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyInverseTo(Rotation r13, FieldVector3D<T> r14) {
        RealFieldElement r0 = r14.getX();
        RealFieldElement r1 = r14.getY();
        RealFieldElement r15 = r14.getZ();
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r13.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.multiply(r13.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r15.multiply(r13.getQ3())), RealFieldElement.class, "com.obric.memorydata.plugin");
        double r5 = -r13.getQ0();
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(r15.multiply(r13.getQ2()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r1.multiply(r13.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(r13.getQ1())), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r0), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r13.getQ3()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r15.multiply(r13.getQ1()))), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(r13.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r1), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r15.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r13.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r0.multiply(r13.getQ2()))), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(r13.getQ3())), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r15), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public static <T extends RealFieldElement<T>> FieldRotation<T> applyTo(Rotation r9, FieldRotation<T> r10) {
        return new FieldRotation((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r10).q0.multiply(r9.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r10).q1.multiply(r9.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((FieldRotation) r10).q2.multiply(r9.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((FieldRotation) r10).q3.multiply(r9.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r10).q1.multiply(r9.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((FieldRotation) r10).q0.multiply(r9.getQ1())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r10).q2.multiply(r9.getQ3()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r10).q3.multiply(r9.getQ2()))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r10).q2.multiply(r9.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((FieldRotation) r10).q0.multiply(r9.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r10).q3.multiply(r9.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r10).q1.multiply(r9.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r10).q3.multiply(r9.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((FieldRotation) r10).q0.multiply(r9.getQ3())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((FieldRotation) r10).q1.multiply(r9.getQ2()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((FieldRotation) r10).q2.multiply(r9.getQ1()))), RealFieldElement.class, "com.obric.memorydata.plugin"), false);
    }

    public static <T extends RealFieldElement<T>> FieldVector3D<T> applyTo(Rotation r11, FieldVector3D<T> r12) {
        RealFieldElement r0 = r12.getX();
        RealFieldElement r1 = r12.getY();
        RealFieldElement r13 = r12.getZ();
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r11.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r1.multiply(r11.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r13.multiply(r11.getQ3())), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(r13.multiply(r11.getQ2()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r1.multiply(r11.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(r11.getQ1())), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r0), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r11.getQ3()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r13.multiply(r11.getQ1()))), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(r11.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r1), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r13.multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r11.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r0.multiply(r11.getQ2()))), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(r11.getQ3())), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r13), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T[] buildArray(T r3, T r4, T r5) {
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r3, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r6 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r4, RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.wrapperContextForParams(r5, RealFieldElement.class, "com.obric.memorydata.plugin");
        T[] r8 = (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r2.getField(), 3), RealFieldElement[].class, "com.obric.memorydata.plugin"));
        r8[0] = r2;
        r8[1] = r6;
        r8[2] = r7;
        return r8;
    }

    private FieldRotation<T> composeInternal(FieldRotation<T> r9) {
        return new FieldRotation((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.q0.multiply(this.q0), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.q1.multiply(this.q1), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r9.q2.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r9.q3.multiply(this.q3))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.q1.multiply(this.q0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r9.q0.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.q2.multiply(this.q3), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r9.q3.multiply(this.q2))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.q2.multiply(this.q0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r9.q0.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.q3.multiply(this.q1), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r9.q1.multiply(this.q3))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.q3.multiply(this.q0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r9.q0.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.q1.multiply(this.q2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r9.q2.multiply(this.q1))), RealFieldElement.class, "com.obric.memorydata.plugin"), false);
    }

    private FieldRotation<T> composeInternal(Rotation r10) {
        return new FieldRotation((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.multiply(r10.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r10.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r10.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r10.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.multiply(r10.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q1.multiply(r10.getQ0())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r10.getQ2()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r10.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.multiply(r10.getQ2()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r10.getQ0())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r10.getQ3()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r10.getQ1()))), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.multiply(r10.getQ3()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r10.getQ0())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r10.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r10.getQ2()))), RealFieldElement.class, "com.obric.memorydata.plugin"), false);
    }

    private FieldRotation<T> composeInverseInternal(FieldRotation<T> r10) {
        return new FieldRotation((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.q0.multiply(this.q0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.q1.multiply(this.q1), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.q2.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.q3.multiply(this.q3))), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.q0.multiply(this.q1), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.q2.multiply(this.q3), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r10.q3.multiply(this.q2))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r10.q1.multiply(this.q0)), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.q0.multiply(this.q2), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.q3.multiply(this.q1), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r10.q1.multiply(this.q3))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r10.q2.multiply(this.q0)), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.q0.multiply(this.q3), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.q1.multiply(this.q2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r10.q2.multiply(this.q1))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r10.q3.multiply(this.q0)), RealFieldElement.class, "com.obric.memorydata.plugin"), false);
    }

    private FieldRotation<T> composeInverseInternal(Rotation r11) {
        return new FieldRotation((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r11.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r11.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r11.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r11.getQ2()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r11.getQ3()))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q0.multiply(r11.getQ1())), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r11.getQ3()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r11.getQ1()))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q0.multiply(r11.getQ2())), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r11.getQ0()), RealFieldElement.class, "com.obric.memorydata.plugin")).add(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r11.getQ1()), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r11.getQ2()))), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q0.multiply(r11.getQ3())), RealFieldElement.class, "com.obric.memorydata.plugin"), false);
    }

    public static <T extends RealFieldElement<T>> T distance(FieldRotation<T> r0, FieldRotation<T> r1) {
        return (T) r0.composeInverseInternal(r1).getAngle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T[] mat2quat(T[][] r19) {
        T[] r1 = (T[]) ((RealFieldElement[]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r19[0][0].getField(), 4), RealFieldElement[].class, "com.obric.memorydata.plugin"));
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r19[0][0].add(r19[1][1]), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r19[2][2]), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r2.getReal() <= (-0.19d)) goto L5;
        r1[0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(1.0d), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.5d), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r3 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1[0].reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.25d), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(r19[1][2].subtract(r19[2][1])), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(r19[2][0].subtract(r19[0][2])), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[3] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(r19[0][1].subtract(r19[1][0])), RealFieldElement.class, "com.obric.memorydata.plugin");
    L12:
        return r1;
    L5:
        RealFieldElement r4 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r19[0][0].subtract(r19[1][1]), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r19[2][2]), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r4.getReal() <= (-0.19d)) goto L8;
        r1[1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r4.add(1.0d), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.5d), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1[1].reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.25d), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.multiply(r19[1][2].subtract(r19[2][1])), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.multiply(r19[0][1].add(r19[1][0])), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[3] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.multiply(r19[0][2].add(r19[2][0])), RealFieldElement.class, "com.obric.memorydata.plugin");
        goto L12
    L8:
        RealFieldElement r6 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r19[1][1].subtract(r19[0][0]), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r19[2][2]), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r6.getReal() <= (-0.19d)) goto L11;
        r1[2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.add(1.0d), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.5d), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1[2].reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.25d), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r7.multiply(r19[2][0].subtract(r19[0][2])), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r7.multiply(r19[0][1].add(r19[1][0])), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[3] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r7.multiply(r19[2][1].add(r19[1][2])), RealFieldElement.class, "com.obric.memorydata.plugin");
        goto L12
    L11:
        r1[3] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r19[2][2].subtract(r19[0][0]), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r19[1][1]), RealFieldElement.class, "com.obric.memorydata.plugin")).add(1.0d), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.5d), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r8 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1[3].reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(0.25d), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r8.multiply(r19[0][1].subtract(r19[1][0])), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r8.multiply(r19[0][2].add(r19[2][0])), RealFieldElement.class, "com.obric.memorydata.plugin");
        r1[2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r8.multiply(r19[2][1].add(r19[1][2])), RealFieldElement.class, "com.obric.memorydata.plugin");
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v66 */
    /* JADX WARN: Type inference failed for: r0v67, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v70 */
    /* JADX WARN: Type inference failed for: r0v71, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v74 */
    /* JADX WARN: Type inference failed for: r0v75, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r0v78 */
    /* JADX WARN: Type inference failed for: r0v79, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v5, types: [T extends org.apache.commons.math3.RealFieldElement<T>[][], org.apache.commons.math3.RealFieldElement[][]] */
    /* JADX WARN: Type inference failed for: r13v110 */
    /* JADX WARN: Type inference failed for: r13v111 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r16v10, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r20v1, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r23v0, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r25v0, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v24, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r6v49 */
    /* JADX WARN: Type inference failed for: r6v50 */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, org.apache.commons.math3.RealFieldElement] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.lang.Object] */
    private T[][] orthogonalizeMatrix(T[][] r33, double r34) {
        char r0 = 0;
        T r1 = r33[0][0];
        int r3 = 1;
        T r2 = r33[0][1];
        T r4 = r33[0][2];
        T r6 = r33[1][0];
        T r7 = r33[1][1];
        T r8 = r33[1][2];
        T r9 = r33[2][0];
        T r10 = r33[2][1];
        T r11 = r33[2][2];
        String r14 = "com.obric.memorydata.plugin";
        ?? r12 = (T[][]) ((RealFieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(r33[0][0].getField(), 3, 3), RealFieldElement[][].class, "com.obric.memorydata.plugin"));
        double r15 = 0.0d;
        int r13 = 0;
        ?? r5 = r1;
        ?? r16 = r2;
        ?? r17 = r4;
        ?? r18 = r6;
        ?? r19 = r7;
        ?? r20 = r8;
        ?? r21 = r9;
        ?? r110 = r10;
        ?? r111 = r11;
    L3:
        int r112 = r13 + r3;
        if (r112 >= 11) goto L9;
        RealFieldElement r22 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[r0][r0].multiply(r5), RealFieldElement.class, r14)).add(r33[r3][0].multiply(r18)), RealFieldElement.class, r14)).add(r33[2][0].multiply(r21)), RealFieldElement.class, r14);
        RealFieldElement r23 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[0][r3].multiply(r5), RealFieldElement.class, r14)).add(r33[1][1].multiply(r18)), RealFieldElement.class, r14)).add(r33[2][1].multiply(r21)), RealFieldElement.class, r14);
        double r24 = r15;
        RealFieldElement r25 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[0][2].multiply(r5), RealFieldElement.class, r14)).add(r33[1][2].multiply(r18)), RealFieldElement.class, r14)).add(r33[2][2].multiply(r21)), RealFieldElement.class, r14);
        ?? r26 = r21;
        RealFieldElement r27 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[0][0].multiply(r16), RealFieldElement.class, r14)).add(r33[1][0].multiply(r19)), RealFieldElement.class, r14)).add(r33[2][0].multiply(r110)), RealFieldElement.class, r14);
        ?? r28 = r18;
        RealFieldElement r29 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[0][1].multiply(r16), RealFieldElement.class, r14)).add(r33[1][1].multiply(r19)), RealFieldElement.class, r14)).add(r33[2][1].multiply(r110)), RealFieldElement.class, r14);
        RealFieldElement r30 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[0][2].multiply(r16), RealFieldElement.class, r14)).add(r33[1][2].multiply(r19)), RealFieldElement.class, r14)).add(r33[2][2].multiply(r110)), RealFieldElement.class, r14);
        ?? r210 = r110;
        RealFieldElement r113 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[0][0].multiply(r17), RealFieldElement.class, r14)).add(r33[1][0].multiply(r20)), RealFieldElement.class, r14)).add(r33[2][0].multiply(r111)), RealFieldElement.class, r14);
        ?? r211 = r19;
        RealFieldElement r31 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[0][1].multiply(r17), RealFieldElement.class, r14)).add(r33[1][1].multiply(r20)), RealFieldElement.class, r14)).add(r33[2][1].multiply(r111)), RealFieldElement.class, r14);
        RealFieldElement r32 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33[0][2].multiply(r17), RealFieldElement.class, r14)).add(r33[1][2].multiply(r20)), RealFieldElement.class, r14)).add(r33[2][2].multiply(r111)), RealFieldElement.class, r14);
        ?? r114 = r111;
        String r115 = r14;
        r12[0][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.multiply(r22), RealFieldElement.class, r14)).add(r16.multiply(r23)), RealFieldElement.class, r14)).add(r17.multiply(r25)), RealFieldElement.class, r14)).subtract(r33[0][0]), RealFieldElement.class, r14)).multiply(0.5d)), RealFieldElement.class, r115);
        r12[0][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r16.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.multiply(r27), RealFieldElement.class, r115)).add(r16.multiply(r29)), RealFieldElement.class, r115)).add(r17.multiply(r30)), RealFieldElement.class, r115)).subtract(r33[0][1]), RealFieldElement.class, r115)).multiply(0.5d)), RealFieldElement.class, r115);
        r12[0][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r17.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.multiply(r113), RealFieldElement.class, r115)).add(r16.multiply(r31)), RealFieldElement.class, r115)).add(r17.multiply(r32)), RealFieldElement.class, r115)).subtract(r33[0][2]), RealFieldElement.class, r115)).multiply(0.5d)), RealFieldElement.class, r115);
        r12[1][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r28.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r28.multiply(r22), RealFieldElement.class, r115)).add(r211.multiply(r23)), RealFieldElement.class, r115)).add(r20.multiply(r25)), RealFieldElement.class, r115)).subtract(r33[1][0]), RealFieldElement.class, r115)).multiply(0.5d)), RealFieldElement.class, r115);
        r12[1][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r211.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r28.multiply(r27), RealFieldElement.class, r115)).add(r211.multiply(r29)), RealFieldElement.class, r115)).add(r20.multiply(r30)), RealFieldElement.class, r115)).subtract(r33[1][1]), RealFieldElement.class, r115)).multiply(0.5d)), RealFieldElement.class, r115);
        r12[1][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r20.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r28.multiply(r113), RealFieldElement.class, r115)).add(r211.multiply(r31)), RealFieldElement.class, r115)).add(r20.multiply(r32)), RealFieldElement.class, r115)).subtract(r33[1][2]), RealFieldElement.class, r115)).multiply(0.5d)), RealFieldElement.class, r115);
        r12[2][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r26.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r26.multiply(r22), RealFieldElement.class, r115)).add(r210.multiply(r23)), RealFieldElement.class, r115)).add(r114.multiply(r25)), RealFieldElement.class, r115)).subtract(r33[2][0]), RealFieldElement.class, r115)).multiply(0.5d)), RealFieldElement.class, r115);
        r12[2][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r210.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r26.multiply(r27), RealFieldElement.class, r115)).add(r210.multiply(r29)), RealFieldElement.class, r115)).add(r114.multiply(r30)), RealFieldElement.class, r115)).subtract(r33[2][1]), RealFieldElement.class, r115)).multiply(0.5d)), RealFieldElement.class, r115);
        r12[2][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(r114.subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r26.multiply(r113), RealFieldElement.class, r115)).add(r210.multiply(r31)), RealFieldElement.class, r115)).add(r114.multiply(r32)), RealFieldElement.class, r115)).subtract(r33[2][2]), RealFieldElement.class, r115)).multiply(0.5d)), RealFieldElement.class, r115);
        double r35 = r12[0][0].getReal() - r33[0][0].getReal();
        double r36 = r12[0][1].getReal() - r33[0][1].getReal();
        double r37 = r12[0][2].getReal() - r33[0][2].getReal();
        double r116 = r12[1][0].getReal() - r33[1][0].getReal();
        double r117 = r12[1][1].getReal() - r33[1][1].getReal();
        double r212 = r12[1][2].getReal() - r33[1][2].getReal();
        double r213 = r12[2][0].getReal() - r33[2][0].getReal();
        double r214 = r12[2][1].getReal() - r33[2][1].getReal();
        double r215 = r12[2][2].getReal() - r33[2][2].getReal();
        r15 = ((((((((r35 * r35) + (r36 * r36)) + (r37 * r37)) + (r116 * r116)) + (r117 * r117)) + (r212 * r212)) + (r213 * r213)) + (r214 * r214)) + (r215 * r215);
        if (FastMath.abs(r15 - r24) <= r34) goto L7;
        r0 = 0;
        ?? r38 = r12[0][0];
        r3 = 1;
        ?? r39 = r12[0][1];
        ?? r40 = r12[0][2];
        ?? r41 = r12[1][0];
        ?? r42 = r12[1][1];
        ?? r43 = r12[1][2];
        ?? r44 = r12[2][0];
        ?? r118 = r12[2][1];
        r14 = r115;
        r111 = r12[2][2];
        r13 = r112;
        r5 = r38;
        r16 = r39;
        r17 = r40;
        r18 = r41;
        r19 = r42;
        r20 = r43;
        r21 = r44;
        r110 = r118;
        goto L3
    L7:
        return r12;
    L9:
        LocalizedFormats r45 = LocalizedFormats.UNABLE_TO_ORTHOGONOLIZE_MATRIX;
        Object[] r46 = new Object[r3];
        r46[r0] = Integer.valueOf(r112 - 1);
        throw new NotARotationMatrixException(r45, r46);
    }

    private FieldVector3D<T> vector(double r3, double r5, double r7) {
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.getField().getZero(), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(r3), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(r5), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(r7), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldRotation<T> applyInverseTo(FieldRotation<T> r2) {
        return composeInverse(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation<T> applyInverseTo(Rotation r2) {
        return composeInverse(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldVector3D<T> applyInverseTo(FieldVector3D<T> r12) {
        RealFieldElement r0 = r12.getX();
        RealFieldElement r1 = r12.getY();
        RealFieldElement r13 = r12.getZ();
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r1)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r13)), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r3 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.negate(), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r3), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r13), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r1)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r0), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r3), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r13)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r1), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r13.multiply(r3), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r1), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r0)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r13), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> applyInverseTo(Vector3D r15) {
        double r0 = r15.getX();
        double r2 = r15.getY();
        double r4 = r15.getZ();
        RealFieldElement r16 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r2)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r4)), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r6 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.negate(), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r4), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r2)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r16.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r0), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r4)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r16.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r2), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(r4), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r0)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r16.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r4), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public void applyInverseTo(double[] r17, T[] r18) {
        double r2 = r17[0];
        double r5 = r17[1];
        double r8 = r17[2];
        RealFieldElement r10 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r5)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r8)), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r11 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.negate(), RealFieldElement.class, "com.obric.memorydata.plugin");
        r18[0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r8), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r5)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r2), RealFieldElement.class, "com.obric.memorydata.plugin");
        r18[1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r8)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r5), RealFieldElement.class, "com.obric.memorydata.plugin");
        r18[2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.multiply(r8), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r2)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r8), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public void applyInverseTo(T[] r12, T[] r13) {
        T r1 = r12[0];
        T r3 = r12[1];
        T r14 = r12[2];
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r1), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r3)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r14)), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r6 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.negate(), RealFieldElement.class, "com.obric.memorydata.plugin");
        r13[0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r14), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r3)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r1), RealFieldElement.class, "com.obric.memorydata.plugin");
        r13[1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r1), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r14)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r3), RealFieldElement.class, "com.obric.memorydata.plugin");
        r13[2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r14.multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r3), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r1)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r14), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldRotation<T> applyTo(FieldRotation<T> r2) {
        return compose(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldRotation<T> applyTo(Rotation r2) {
        return compose(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public FieldVector3D<T> applyTo(FieldVector3D<T> r12) {
        RealFieldElement r0 = r12.getX();
        RealFieldElement r1 = r12.getY();
        RealFieldElement r13 = r12.getZ();
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r1)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r13)), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r5 = this.q0;
        RealFieldElement r6 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r13), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r1)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r7 = this.q0;
        RealFieldElement r8 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r7.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r7), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r13)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r1), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r9 = this.q0;
        return new FieldVector3D(r6, r8, (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r13.multiply(r9), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r1), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r0)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r2.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r13), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public FieldVector3D<T> applyTo(Vector3D r15) {
        double r0 = r15.getX();
        double r2 = r15.getY();
        double r4 = r15.getZ();
        RealFieldElement r16 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r2)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r4)), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r8 = this.q0;
        RealFieldElement r9 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r8.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r8.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r4), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r2)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r16.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r10 = this.q0;
        RealFieldElement r11 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r4)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r16.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r2), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r12 = this.q0;
        return new FieldVector3D(r9, r11, (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12.multiply(r4), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r0)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r16.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r4), RealFieldElement.class, "com.obric.memorydata.plugin"));
    }

    public void applyTo(double[] r17, T[] r18) {
        double r2 = r17[0];
        double r5 = r17[1];
        double r8 = r17[2];
        RealFieldElement r10 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r5)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r8)), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r11 = this.q0;
        r18[0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r8), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r5)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r2), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r1 = this.q0;
        r18[1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r8)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r5), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r3 = this.q0;
        r18[2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(r8), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r2)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r10.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r8), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public void applyTo(T[] r12, T[] r13) {
        T r1 = r12[0];
        T r3 = r12[1];
        T r14 = r12[2];
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r1), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q2.multiply(r3)), RealFieldElement.class, "com.obric.memorydata.plugin")).add(this.q3.multiply(r14)), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r6 = this.q0;
        r13[0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r14), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q3.multiply(r3)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5.multiply(this.q1)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r1), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r0 = this.q0;
        r13[1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r1), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q1.multiply(r14)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5.multiply(this.q2)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r3), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r2 = this.q0;
        r13[2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.multiply(((RealFieldElement) ZeusTransformUtils.preCheckCast(r14.multiply(r2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r3), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(this.q2.multiply(r1)))), RealFieldElement.class, "com.obric.memorydata.plugin")).add(r5.multiply(this.q3)), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(r14), RealFieldElement.class, "com.obric.memorydata.plugin");
    }

    public FieldRotation<T> compose(FieldRotation<T> r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInternal(r2);
    L6:
        return r2.composeInternal(this);
    }

    public FieldRotation<T> compose(Rotation r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInternal(r2);
    L6:
        return applyTo(r2, this);
    }

    public FieldRotation<T> composeInverse(FieldRotation<T> r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInverseInternal(r2);
    L6:
        return r2.composeInternal(revert());
    }

    public FieldRotation<T> composeInverse(Rotation r2, RotationConvention r3) {
        if (r3 != RotationConvention.VECTOR_OPERATOR) goto L6;
        return composeInverseInternal(r2);
    L6:
        return applyTo(r2, revert());
    }

    public T getAngle() {
        if (this.q0.getReal() >= (-0.1d)) goto L5;
    L13:
        T r0 = this.q1;
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r3 = this.q2;
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r1.add(r3.multiply(r3)), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r7 = this.q3;
        Object r8 = ((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(r7.multiply(r7)), RealFieldElement.class, "com.obric.memorydata.plugin")).sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).asin();
    L12:
        return (T) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r8, RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin");
    L5:
        if (this.q0.getReal() > 0.1d) goto L13;
        double r4 = this.q0.getReal();
        T r9 = this.q0;
        if (r4 >= 0.0d) goto L10;
        r9 = (T) ZeusTransformUtils.preCheckCast(r9.negate(), RealFieldElement.class, "com.obric.memorydata.plugin");
    L10:
        r8 = r9.acos();
        goto L12
    }

    @Deprecated
    public T[] getAngles(RotationOrder r2) {
        return (T[]) getAngles(r2, RotationConvention.VECTOR_OPERATOR);
    }

    public T[] getAngles(RotationOrder r16, RotationConvention r17) {
        if (r17 != RotationConvention.VECTOR_OPERATOR) goto L123;
        if (r16 != RotationOrder.XYZ) goto L15;
        FieldVector3D<T> r8 = applyTo(vector(0.0d, 0.0d, 1.0d));
        FieldVector3D<T> r0 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
        if (r0.getZ().getReal() < (-0.9999999999d)) goto L13;
        if (r0.getZ().getReal() > 0.9999999999d) goto L13;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r8.getY().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r8.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r0.getZ().asin(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r0.getY().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r0.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L13:
        throw new CardanEulerSingularityException(true);
    L15:
        if (r16 != RotationOrder.XZY) goto L25;
        FieldVector3D<T> r9 = applyTo(vector(0.0d, 1.0d, 0.0d));
        FieldVector3D<T> r1 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
        if (r1.getY().getReal() < (-0.9999999999d)) goto L23;
        if (r1.getY().getReal() > 0.9999999999d) goto L23;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.getZ().atan2(r9.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r1.getY().asin(), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r1.getZ().atan2(r1.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L23:
        throw new CardanEulerSingularityException(true);
    L25:
        if (r16 != RotationOrder.YXZ) goto L35;
        FieldVector3D<T> r10 = applyTo(vector(0.0d, 0.0d, 1.0d));
        FieldVector3D<T> r2 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
        if (r2.getZ().getReal() < (-0.9999999999d)) goto L33;
        if (r2.getZ().getReal() > 0.9999999999d) goto L33;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r10.getX().atan2(r10.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getZ().asin(), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r2.getX().atan2(r2.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L33:
        throw new CardanEulerSingularityException(true);
    L35:
        if (r16 != RotationOrder.YZX) goto L45;
        FieldVector3D<T> r11 = applyTo(vector(1.0d, 0.0d, 0.0d));
        FieldVector3D<T> r3 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
        if (r3.getX().getReal() < (-0.9999999999d)) goto L43;
        if (r3.getX().getReal() > 0.9999999999d) goto L43;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r11.getZ().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r11.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r3.getX().asin(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r3.getZ().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r3.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L43:
        throw new CardanEulerSingularityException(true);
    L45:
        if (r16 != RotationOrder.ZXY) goto L55;
        FieldVector3D<T> r12 = applyTo(vector(0.0d, 1.0d, 0.0d));
        FieldVector3D<T> r4 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
        if (r4.getY().getReal() < (-0.9999999999d)) goto L53;
        if (r4.getY().getReal() > 0.9999999999d) goto L53;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12.getX().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r12.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r4.getY().asin(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r4.getX().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r4.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L53:
        throw new CardanEulerSingularityException(true);
    L55:
        if (r16 != RotationOrder.ZYX) goto L65;
        FieldVector3D<T> r13 = applyTo(vector(1.0d, 0.0d, 0.0d));
        FieldVector3D<T> r5 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
        if (r5.getX().getReal() < (-0.9999999999d)) goto L63;
        if (r5.getX().getReal() > 0.9999999999d) goto L63;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r13.getY().atan2(r13.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.getX().asin(), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r5.getY().atan2(r5.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L63:
        throw new CardanEulerSingularityException(true);
    L65:
        if (r16 != RotationOrder.XYX) goto L75;
        FieldVector3D<T> r14 = applyTo(vector(1.0d, 0.0d, 0.0d));
        FieldVector3D<T> r6 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
        if (r6.getX().getReal() < (-0.9999999999d)) goto L73;
        if (r6.getX().getReal() > 0.9999999999d) goto L73;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r14.getY().atan2(r14.getZ().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r6.getX().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r6.getY().atan2(r6.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L73:
        throw new CardanEulerSingularityException(false);
    L75:
        if (r16 != RotationOrder.XZX) goto L85;
        FieldVector3D<T> r15 = applyTo(vector(1.0d, 0.0d, 0.0d));
        FieldVector3D<T> r7 = applyInverseTo(vector(1.0d, 0.0d, 0.0d));
        if (r7.getX().getReal() < (-0.9999999999d)) goto L83;
        if (r7.getX().getReal() > 0.9999999999d) goto L83;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r15.getZ().atan2(r15.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r7.getX().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r7.getZ().atan2(r7.getY().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L83:
        throw new CardanEulerSingularityException(false);
    L85:
        if (r16 != RotationOrder.YXY) goto L95;
        FieldVector3D<T> r18 = applyTo(vector(0.0d, 1.0d, 0.0d));
        FieldVector3D<T> r19 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
        if (r19.getY().getReal() < (-0.9999999999d)) goto L93;
        if (r19.getY().getReal() > 0.9999999999d) goto L93;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r18.getX().atan2(r18.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r19.getY().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r19.getX().atan2(r19.getZ().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L93:
        throw new CardanEulerSingularityException(false);
    L95:
        if (r16 != RotationOrder.YZY) goto L105;
        FieldVector3D<T> r20 = applyTo(vector(0.0d, 1.0d, 0.0d));
        FieldVector3D<T> r21 = applyInverseTo(vector(0.0d, 1.0d, 0.0d));
        if (r21.getY().getReal() < (-0.9999999999d)) goto L103;
        if (r21.getY().getReal() > 0.9999999999d) goto L103;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r20.getZ().atan2(r20.getX().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r21.getY().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r21.getZ().atan2(r21.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L103:
        throw new CardanEulerSingularityException(false);
    L105:
        if (r16 != RotationOrder.ZXZ) goto L114;
        FieldVector3D<T> r22 = applyTo(vector(0.0d, 0.0d, 1.0d));
        FieldVector3D<T> r23 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
        if (r23.getZ().getReal() < (-0.9999999999d)) goto L113;
        if (r23.getZ().getReal() > 0.9999999999d) goto L113;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r22.getX().atan2(r22.getY().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r23.getZ().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r23.getX().atan2(r23.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L113:
        throw new CardanEulerSingularityException(false);
    L114:
        FieldVector3D<T> r24 = applyTo(vector(0.0d, 0.0d, 1.0d));
        FieldVector3D<T> r25 = applyInverseTo(vector(0.0d, 0.0d, 1.0d));
        if (r25.getZ().getReal() < (-0.9999999999d)) goto L121;
        if (r25.getZ().getReal() > 0.9999999999d) goto L121;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r24.getY().atan2(r24.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r25.getZ().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r25.getY().atan2(r25.getX().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L121:
        throw new CardanEulerSingularityException(false);
    L123:
        if (r16 != RotationOrder.XYZ) goto L133;
        FieldVector3D<T> r26 = applyTo(Vector3D.PLUS_I);
        FieldVector3D<T> r27 = applyInverseTo(Vector3D.PLUS_K);
        if (r27.getX().getReal() < (-0.9999999999d)) goto L131;
        if (r27.getX().getReal() > 0.9999999999d) goto L131;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r27.getY().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r27.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r27.getX().asin(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r26.getY().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r26.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L131:
        throw new CardanEulerSingularityException(true);
    L133:
        if (r16 != RotationOrder.XZY) goto L143;
        FieldVector3D<T> r28 = applyTo(Vector3D.PLUS_I);
        FieldVector3D<T> r29 = applyInverseTo(Vector3D.PLUS_J);
        if (r29.getX().getReal() < (-0.9999999999d)) goto L141;
        if (r29.getX().getReal() > 0.9999999999d) goto L141;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r29.getZ().atan2(r29.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r29.getX().asin(), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r28.getZ().atan2(r28.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L141:
        throw new CardanEulerSingularityException(true);
    L143:
        if (r16 != RotationOrder.YXZ) goto L153;
        FieldVector3D<T> r30 = applyTo(Vector3D.PLUS_J);
        FieldVector3D<T> r31 = applyInverseTo(Vector3D.PLUS_K);
        if (r31.getY().getReal() < (-0.9999999999d)) goto L151;
        if (r31.getY().getReal() > 0.9999999999d) goto L151;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r31.getX().atan2(r31.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r31.getY().asin(), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r30.getX().atan2(r30.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L151:
        throw new CardanEulerSingularityException(true);
    L153:
        if (r16 != RotationOrder.YZX) goto L163;
        FieldVector3D<T> r32 = applyTo(Vector3D.PLUS_J);
        FieldVector3D<T> r33 = applyInverseTo(Vector3D.PLUS_I);
        if (r33.getY().getReal() < (-0.9999999999d)) goto L161;
        if (r33.getY().getReal() > 0.9999999999d) goto L161;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r33.getZ().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r33.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r33.getY().asin(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r32.getZ().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r32.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L161:
        throw new CardanEulerSingularityException(true);
    L163:
        if (r16 != RotationOrder.ZXY) goto L173;
        FieldVector3D<T> r34 = applyTo(Vector3D.PLUS_K);
        FieldVector3D<T> r35 = applyInverseTo(Vector3D.PLUS_J);
        if (r35.getZ().getReal() < (-0.9999999999d)) goto L171;
        if (r35.getZ().getReal() > 0.9999999999d) goto L171;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r35.getX().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r35.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r35.getZ().asin(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r34.getX().negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).atan2(r34.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L171:
        throw new CardanEulerSingularityException(true);
    L173:
        if (r16 != RotationOrder.ZYX) goto L183;
        FieldVector3D<T> r36 = applyTo(Vector3D.PLUS_K);
        FieldVector3D<T> r37 = applyInverseTo(Vector3D.PLUS_I);
        if (r37.getZ().getReal() < (-0.9999999999d)) goto L181;
        if (r37.getZ().getReal() > 0.9999999999d) goto L181;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r37.getY().atan2(r37.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r37.getZ().asin(), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r36.getY().atan2(r36.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L181:
        throw new CardanEulerSingularityException(true);
    L183:
        if (r16 != RotationOrder.XYX) goto L193;
        FieldVector3D<T> r38 = applyTo(Vector3D.PLUS_I);
        FieldVector3D<T> r39 = applyInverseTo(Vector3D.PLUS_I);
        if (r39.getX().getReal() < (-0.9999999999d)) goto L191;
        if (r39.getX().getReal() > 0.9999999999d) goto L191;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r39.getY().atan2(r39.getZ().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r39.getX().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r38.getY().atan2(r38.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L191:
        throw new CardanEulerSingularityException(false);
    L193:
        if (r16 != RotationOrder.XZX) goto L203;
        FieldVector3D<T> r40 = applyTo(Vector3D.PLUS_I);
        FieldVector3D<T> r41 = applyInverseTo(Vector3D.PLUS_I);
        if (r41.getX().getReal() < (-0.9999999999d)) goto L201;
        if (r41.getX().getReal() > 0.9999999999d) goto L201;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r41.getZ().atan2(r41.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r41.getX().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r40.getZ().atan2(r40.getY().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L201:
        throw new CardanEulerSingularityException(false);
    L203:
        if (r16 != RotationOrder.YXY) goto L213;
        FieldVector3D<T> r42 = applyTo(Vector3D.PLUS_J);
        FieldVector3D<T> r43 = applyInverseTo(Vector3D.PLUS_J);
        if (r43.getY().getReal() < (-0.9999999999d)) goto L211;
        if (r43.getY().getReal() > 0.9999999999d) goto L211;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r43.getX().atan2(r43.getZ()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r43.getY().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r42.getX().atan2(r42.getZ().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L211:
        throw new CardanEulerSingularityException(false);
    L213:
        if (r16 != RotationOrder.YZY) goto L223;
        FieldVector3D<T> r44 = applyTo(Vector3D.PLUS_J);
        FieldVector3D<T> r45 = applyInverseTo(Vector3D.PLUS_J);
        if (r45.getY().getReal() < (-0.9999999999d)) goto L221;
        if (r45.getY().getReal() > 0.9999999999d) goto L221;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r45.getZ().atan2(r45.getX().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r45.getY().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r44.getZ().atan2(r44.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L221:
        throw new CardanEulerSingularityException(false);
    L223:
        if (r16 != RotationOrder.ZXZ) goto L232;
        FieldVector3D<T> r46 = applyTo(Vector3D.PLUS_K);
        FieldVector3D<T> r47 = applyInverseTo(Vector3D.PLUS_K);
        if (r47.getZ().getReal() < (-0.9999999999d)) goto L231;
        if (r47.getZ().getReal() > 0.9999999999d) goto L231;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r47.getX().atan2(r47.getY().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r47.getZ().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r46.getX().atan2(r46.getY()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L231:
        throw new CardanEulerSingularityException(false);
    L232:
        FieldVector3D<T> r48 = applyTo(Vector3D.PLUS_K);
        FieldVector3D<T> r49 = applyInverseTo(Vector3D.PLUS_K);
        if (r49.getZ().getReal() < (-0.9999999999d)) goto L239;
        if (r49.getZ().getReal() > 0.9999999999d) goto L239;
        return (T[]) buildArray((RealFieldElement) ZeusTransformUtils.preCheckCast(r49.getY().atan2(r49.getX()), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r49.getZ().acos(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r48.getY().atan2(r48.getX().negate()), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L239:
        throw new CardanEulerSingularityException(false);
    }

    @Deprecated
    public FieldVector3D<T> getAxis() {
        return getAxis(RotationConvention.VECTOR_OPERATOR);
    }

    public FieldVector3D<T> getAxis(RotationConvention r10) {
        T r0 = this.q1;
        RealFieldElement r1 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r0.multiply(r0), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r2 = this.q2;
        RealFieldElement r3 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r1.add(r2.multiply(r2)), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r4 = this.q3;
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r3.add(r4.multiply(r4)), RealFieldElement.class, "com.obric.memorydata.plugin");
        if (r5.getReal() != 0.0d) goto L11;
        Field<T> r9 = r5.getField();
        if (r10 != RotationConvention.VECTOR_OPERATOR) goto L7;
        Object r11 = r9.getOne();
    L9:
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(r11, RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r9.getZero(), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(r9.getZero(), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L7:
        r11 = ((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.getOne(), RealFieldElement.class, "com.obric.memorydata.plugin")).negate();
        goto L9
    L11:
        if (r10 != RotationConvention.VECTOR_OPERATOR) goto L13;
        double r6 = 1.0d;
    L15:
        if (this.q0.getReal() >= 0.0d) goto L18;
        RealFieldElement r12 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r12), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r12), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r12), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L18:
        RealFieldElement r13 = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r5.sqrt(), RealFieldElement.class, "com.obric.memorydata.plugin")).reciprocal(), RealFieldElement.class, "com.obric.memorydata.plugin")).negate(), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin");
        return new FieldVector3D((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(r13), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(r13), RealFieldElement.class, "com.obric.memorydata.plugin"), (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q3.multiply(r13), RealFieldElement.class, "com.obric.memorydata.plugin"));
    L13:
        r6 = -1.0d;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[][] getMatrix() {
        T r1 = this.q0;
        RealFieldElement r2 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r1.multiply(r1), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r3 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.multiply(this.q1), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r4 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.multiply(this.q2), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r5 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.multiply(this.q3), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r6 = this.q1;
        RealFieldElement r7 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r6.multiply(r6), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r8 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(this.q2), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r9 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q1.multiply(this.q3), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r10 = this.q2;
        RealFieldElement r11 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r10.multiply(r10), RealFieldElement.class, "com.obric.memorydata.plugin");
        RealFieldElement r12 = (RealFieldElement) ZeusTransformUtils.preCheckCast(this.q2.multiply(this.q3), RealFieldElement.class, "com.obric.memorydata.plugin");
        T r13 = this.q3;
        RealFieldElement r14 = (RealFieldElement) ZeusTransformUtils.preCheckCast(r13.multiply(r13), RealFieldElement.class, "com.obric.memorydata.plugin");
        T[][] r0 = (T[][]) ((RealFieldElement[][]) ZeusTransformUtils.preCheckCast(MathArrays.buildArray(this.q0.getField(), 3, 3), RealFieldElement[][].class, "com.obric.memorydata.plugin"));
        r0[0][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(r7), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(1.0d), RealFieldElement.class, "com.obric.memorydata.plugin");
        r0[1][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r8.subtract(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin");
        r0[2][0] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.add(r4), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin");
        r0[0][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r8.add(r5), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin");
        r0[1][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(r11), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(1.0d), RealFieldElement.class, "com.obric.memorydata.plugin");
        r0[2][1] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12.subtract(r3), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin");
        r0[0][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r9.subtract(r4), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin");
        r0[1][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r12.add(r3), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin");
        r0[2][2] = (RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(((RealFieldElement) ZeusTransformUtils.preCheckCast(r2.add(r14), RealFieldElement.class, "com.obric.memorydata.plugin")).multiply(2), RealFieldElement.class, "com.obric.memorydata.plugin")).subtract(1.0d), RealFieldElement.class, "com.obric.memorydata.plugin");
        return r0;
    }

    public T getQ0() {
        return this.q0;
    }

    public T getQ1() {
        return this.q1;
    }

    public T getQ2() {
        return this.q2;
    }

    public T getQ3() {
        return this.q3;
    }

    public FieldRotation<T> revert() {
        return new FieldRotation((RealFieldElement) ZeusTransformUtils.preCheckCast(this.q0.negate(), RealFieldElement.class, "com.obric.memorydata.plugin"), this.q1, this.q2, this.q3, false);
    }

    public Rotation toRotation() {
        return new Rotation(this.q0.getReal(), this.q1.getReal(), this.q2.getReal(), this.q3.getReal(), false);
    }
}
