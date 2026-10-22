package org.apache.commons.math3.geometry.euclidean.threed;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class SphericalCoordinates implements Serializable {
    private static final long serialVersionUID = 20130206;
    private double[][] jacobian;
    private final double phi;
    private double[][] phiHessian;
    private final double r;
    private double[][] rHessian;
    private final double theta;
    private double[][] thetaHessian;
    private final Vector3D v;

    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20130206;
        private final double x;
        private final double y;
        private final double z;

        DataTransferObject(double r1, double r3, double r5) {
            this.x = r1;
            this.y = r3;
            this.z = r5;
        }

        private Object readResolve() {
            return new SphericalCoordinates(new Vector3D(this.x, this.y, this.z));
        }
    }

    public SphericalCoordinates(double r19, double r21, double r23) {
        double r3 = FastMath.cos(r21);
        double r5 = FastMath.sin(r21);
        double r7 = FastMath.cos(r23);
        double r9 = FastMath.sin(r23);
        this.r = r19;
        this.theta = r21;
        this.phi = r23;
        this.v = new Vector3D((r3 * r19) * r9, (r19 * r5) * r9, r19 * r7);
    }

    public SphericalCoordinates(Vector3D r5) {
        this.v = r5;
        double r0 = r5.getNorm();
        this.r = r0;
        this.theta = r5.getAlpha();
        this.phi = FastMath.acos(r5.getZ() / r0);
    }

    private void computeHessians() {
        if (this.rHessian != null) goto L6;
        double r2 = this.v.getX();
        double r4 = this.v.getY();
        double r6 = this.v.getZ();
        double r8 = r2 * r2;
        double r10 = r4 * r4;
        double r12 = r6 * r6;
        double r14 = r8 + r10;
        double r16 = FastMath.sqrt(r14);
        double r18 = r14 + r12;
        double r11 = this.r;
        double r22 = r2 / r11;
        double r24 = r4 / r11;
        double r26 = r2 / r14;
        double r28 = r4 / r14;
        double r23 = r22 / r18;
        double r25 = r24 / r18;
        double r13 = (r6 / r11) / r18;
        double[][] r9 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        this.rHessian = r9;
        double r34 = r4 * r25;
        double r36 = r6 * r13;
        r9[0][0] = r34 + r36;
        double r15 = -r2;
        r9[1][0] = r25 * r15;
        r9[2][0] = (-r6) * r23;
        double r27 = r23 * r2;
        r9[1][1] = r27 + r36;
        r9[2][1] = (-r4) * r13;
        r9[2][2] = r27 + r34;
        r9[0][1] = r9[1][0];
        r9[0][2] = r9[2][0];
        r9[1][2] = r9[2][1];
        double[][] r17 = (double[][]) Array.newInstance(double.class, new int[]{2, 2});
        this.thetaHessian = r17;
        r17[0][0] = (r26 * 2.0d) * r28;
        r17[1][0] = (r28 * r28) - (r26 * r26);
        r17[1][1] = (r26 * (-2.0d)) * r28;
        r17[0][1] = r17[1][0];
        double r19 = r16 * r18;
        double r29 = r16 * r19;
        double r20 = r19 * r18;
        double r110 = r20 * r14;
        double r210 = (3.0d * r14) + r12;
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        this.phiHessian = r1;
        r1[0][0] = ((r29 - (r8 * r210)) * r6) / r110;
        r1[1][0] = (((r15 * r4) * r6) * r210) / r110;
        double r111 = r14 - r12;
        r1[2][0] = (r2 * r111) / r20;
        r1[1][1] = (r6 * (r29 - (r10 * r210))) / r110;
        r1[2][1] = (r4 * r111) / r20;
        r1[2][2] = ((r16 * 2.0d) * r13) / this.r;
        r1[0][1] = r1[1][0];
        r1[0][2] = r1[2][0];
        r1[1][2] = r1[2][1];
        return;
    }

    private void computeJacobian() {
        if (this.jacobian != null) goto L6;
        double r1 = this.v.getX();
        double r3 = this.v.getY();
        double r5 = this.v.getZ();
        double r7 = (r1 * r1) + (r3 * r3);
        double r9 = FastMath.sqrt(r7);
        double r11 = (r5 * r5) + r7;
        double[][] r14 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        this.jacobian = r14;
        double[] r16 = r14[0];
        double r13 = this.r;
        r16[0] = r1 / r13;
        r14[0][1] = r3 / r13;
        r14[0][2] = r5 / r13;
        r14[1][0] = (-r3) / r7;
        r14[1][1] = r1 / r7;
        double r8 = r9 * r11;
        r14[2][0] = (r1 * r5) / r8;
        r14[2][1] = (r3 * r5) / r8;
        r14[2][2] = (-r9) / r11;
        return;
    }

    private Object writeReplace() {
        return new DataTransferObject(this.v.getX(), this.v.getY(), this.v.getZ());
    }

    public Vector3D getCartesian() {
        return this.v;
    }

    public double getPhi() {
        return this.phi;
    }

    public double getR() {
        return this.r;
    }

    public double getTheta() {
        return this.theta;
    }

    public double[] toCartesianGradient(double[] r11) {
        computeJacobian();
        double r2 = r11[0];
        double[][] r10 = this.jacobian;
        return new double[]{((r2 * r10[0][0]) + (r11[1] * r10[1][0])) + (r11[2] * r10[2][0]), ((r11[0] * r10[0][1]) + (r11[1] * r10[1][1])) + (r11[2] * r10[2][1]), (r11[0] * r10[0][2]) + (r11[2] * r10[2][2])};
    }

    public double[][] toCartesianHessian(double[][] r17, double[] r18) {
        computeJacobian();
        computeHessians();
        double[][] r3 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        double[][] r1 = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        double[] r5 = r3[0];
        double r6 = r17[0][0];
        double[][] r8 = this.jacobian;
        r5[0] = ((r6 * r8[0][0]) + (r17[1][0] * r8[1][0])) + (r17[2][0] * r8[2][0]);
        r3[0][1] = ((r17[0][0] * r8[0][1]) + (r17[1][0] * r8[1][1])) + (r17[2][0] * r8[2][1]);
        r3[0][2] = (r17[0][0] * r8[0][2]) + (r17[2][0] * r8[2][2]);
        r3[1][0] = ((r17[1][0] * r8[0][0]) + (r17[1][1] * r8[1][0])) + (r17[2][1] * r8[2][0]);
        r3[1][1] = ((r17[1][0] * r8[0][1]) + (r17[1][1] * r8[1][1])) + (r17[2][1] * r8[2][1]);
        r3[2][0] = ((r17[2][0] * r8[0][0]) + (r17[2][1] * r8[1][0])) + (r17[2][2] * r8[2][0]);
        r3[2][1] = ((r17[2][0] * r8[0][1]) + (r17[2][1] * r8[1][1])) + (r17[2][2] * r8[2][1]);
        r3[2][2] = (r17[2][0] * r8[0][2]) + (r17[2][2] * r8[2][2]);
        r1[0][0] = ((r8[0][0] * r3[0][0]) + (r8[1][0] * r3[1][0])) + (r8[2][0] * r3[2][0]);
        r1[1][0] = ((r8[0][1] * r3[0][0]) + (r8[1][1] * r3[1][0])) + (r8[2][1] * r3[2][0]);
        r1[2][0] = (r8[0][2] * r3[0][0]) + (r8[2][2] * r3[2][0]);
        r1[1][1] = ((r8[0][1] * r3[0][1]) + (r8[1][1] * r3[1][1])) + (r8[2][1] * r3[2][1]);
        r1[2][1] = (r8[0][2] * r3[0][1]) + (r8[2][2] * r3[2][1]);
        r1[2][2] = (r8[0][2] * r3[0][2]) + (r8[2][2] * r3[2][2]);
        double[] r4 = r1[0];
        double r7 = r4[0];
        double r9 = r18[0];
        double[][] r10 = this.rHessian;
        double r11 = r9 * r10[0][0];
        double r12 = r18[1];
        double[][] r13 = this.thetaHessian;
        double r14 = r11 + (r12 * r13[0][0]);
        double r15 = r18[2];
        double[][] r0 = this.phiHessian;
        r4[0] = r7 + (r14 + (r15 * r0[0][0]));
        double[] r16 = r1[1];
        r16[0] = r16[0] + (((r18[0] * r10[1][0]) + (r18[1] * r13[1][0])) + (r18[2] * r0[1][0]));
        double[] r19 = r1[2];
        r19[0] = r19[0] + ((r18[0] * r10[2][0]) + (r18[2] * r0[2][0]));
        double[] r20 = r1[1];
        r20[1] = r20[1] + (((r18[0] * r10[1][1]) + (r18[1] * r13[1][1])) + (r18[2] * r0[1][1]));
        double[] r21 = r1[2];
        r21[1] = r21[1] + ((r18[0] * r10[2][1]) + (r18[2] * r0[2][1]));
        double[] r22 = r1[2];
        r22[2] = r22[2] + ((r18[0] * r10[2][2]) + (r18[2] * r0[2][2]));
        r1[0][1] = r1[1][0];
        r1[0][2] = r1[2][0];
        r1[1][2] = r1[2][1];
        return r1;
    }
}
