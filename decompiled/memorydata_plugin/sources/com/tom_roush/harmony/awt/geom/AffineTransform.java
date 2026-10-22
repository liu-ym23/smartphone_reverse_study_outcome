package com.tom_roush.harmony.awt.geom;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public class AffineTransform implements Serializable, Cloneable {
    public static final int TYPE_FLIP = 64;
    public static final int TYPE_GENERAL_ROTATION = 16;
    public static final int TYPE_GENERAL_SCALE = 4;
    public static final int TYPE_GENERAL_TRANSFORM = 32;
    public static final int TYPE_IDENTITY = 0;
    public static final int TYPE_MASK_ROTATION = 24;
    public static final int TYPE_MASK_SCALE = 6;
    public static final int TYPE_QUADRANT_ROTATION = 8;
    public static final int TYPE_TRANSLATION = 1;
    public static final int TYPE_UNIFORM_SCALE = 2;
    static final int TYPE_UNKNOWN = -1;
    static final double ZERO = 1.0E-10d;
    private static final long serialVersionUID = 1330973210523860834L;
    double m00;
    double m01;
    double m02;
    double m10;
    double m11;
    double m12;
    transient int type;

    public class NoninvertibleTransformException extends Exception {
        private static final long serialVersionUID = 6137225240503990466L;
        final /* synthetic */ AffineTransform this$0;

        public NoninvertibleTransformException(AffineTransform r1, String r2) {
            this.this$0 = r1;
            super(r2);
        }
    }

    public AffineTransform() {
        this.type = 0;
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
    }

    public AffineTransform(double r2, double r4, double r6, double r8, double r10, double r12) {
        this.type = -1;
        this.m00 = r2;
        this.m10 = r4;
        this.m01 = r6;
        this.m11 = r8;
        this.m02 = r10;
        this.m12 = r12;
    }

    public AffineTransform(float r3, float r4, float r5, float r6, float r7, float r8) {
        this.type = -1;
        this.m00 = r3;
        this.m10 = r4;
        this.m01 = r5;
        this.m11 = r6;
        this.m02 = r7;
        this.m12 = r8;
    }

    public AffineTransform(Matrix r4) {
        float[] r0 = new float[9];
        r4.getValues(r0);
        this.m00 = r0[0];
        this.m01 = r0[1];
        this.m02 = r0[2];
        this.m10 = r0[3];
        this.m11 = r0[4];
        this.m12 = r0[5];
    }

    public AffineTransform(AffineTransform r3) {
        this.type = r3.type;
        this.m00 = r3.m00;
        this.m10 = r3.m10;
        this.m01 = r3.m01;
        this.m11 = r3.m11;
        this.m02 = r3.m02;
        this.m12 = r3.m12;
    }

    public AffineTransform(double[] r3) {
        this.type = -1;
        this.m00 = r3[0];
        this.m10 = r3[1];
        this.m01 = r3[2];
        this.m11 = r3[3];
        if (r3.length <= 4) goto L6;
        this.m02 = r3[4];
        this.m12 = r3[5];
        return;
    }

    public AffineTransform(float[] r3) {
        this.type = -1;
        this.m00 = r3[0];
        this.m10 = r3[1];
        this.m01 = r3[2];
        this.m11 = r3[3];
        if (r3.length <= 4) goto L6;
        this.m02 = r3[4];
        this.m12 = r3[5];
        return;
    }

    public static AffineTransform getRotateInstance(double r1) {
        AffineTransform r0 = new AffineTransform();
        r0.setToRotation(r1);
        return r0;
    }

    public static AffineTransform getRotateInstance(double r8, double r10, double r12) {
        AffineTransform r7 = new AffineTransform();
        r7.setToRotation(r8, r10, r12);
        return r7;
    }

    public static AffineTransform getScaleInstance(double r1, double r3) {
        AffineTransform r0 = new AffineTransform();
        r0.setToScale(r1, r3);
        return r0;
    }

    public static AffineTransform getShearInstance(double r1, double r3) {
        AffineTransform r0 = new AffineTransform();
        r0.setToShear(r1, r3);
        return r0;
    }

    public static AffineTransform getTranslateInstance(double r1, double r3) {
        AffineTransform r0 = new AffineTransform();
        r0.setToTranslation(r1, r3);
        return r0;
    }

    private void readObject(ObjectInputStream r1) {
        r1.defaultReadObject();
        this.type = -1;
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
    }

    public Object clone() {
        return super.clone();
    L5:
        throw new InternalError();
    }

    public void concatenate(AffineTransform r1) {
        setTransform(multiply(r1, this));
    }

    public AffineTransform createInverse() {
        double r1 = getDeterminant();
        if (Math.abs(r1) < ZERO) goto L7;
        double r4 = this.m11;
        double r8 = this.m10;
        double r12 = this.m01;
        double r14 = (-r12) / r1;
        double r15 = this.m00;
        double r10 = this.m12;
        double r6 = this.m02;
        return new AffineTransform(r4 / r1, (-r8) / r1, r14, r15 / r1, ((r12 * r10) - (r4 * r6)) / r1, ((r8 * r6) - (r15 * r10)) / r1);
    L7:
        throw new NoninvertibleTransformException(this, "Determinant is zero");
    }

    public PointF deltaTransform(PointF r7, PointF r8) {
        if (r8 != null) goto L4;
        r8 = new PointF();
    L4:
        r8.set((float) ((((double) r7.x) * this.m00) + (((double) r7.y) * this.m01)), (float) ((((double) r7.x) * this.m10) + (((double) r7.y) * this.m11)));
        return r8;
    }

    public void deltaTransform(double[] r10, int r11, double[] r12, int r13, int r14) {
    L2:
        r14 = r14 - 1;
        if (r14 < 0) goto L5;
        int r0 = r11 + 1;
        double r1 = r10[r11];
        r11 = r0 + 1;
        double r3 = r10[r0];
        int r2 = r13 + 1;
        r12[r13] = (this.m00 * r1) + (this.m01 * r3);
        r13 = r2 + 1;
        r12[r2] = (r1 * this.m10) + (r3 * this.m11);
        goto L2
    }

    public boolean equals(Object r9) {
        if (r9 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AffineTransform.class) == false) goto L22;
        AffineTransform r10 = (AffineTransform) ZeusTransformUtils.preCheckCast(r9, AffineTransform.class, "com.obric.memorydata.plugin");
        if (this.m00 != r10.m00) goto L21;
        if (this.m01 != r10.m01) goto L21;
        if (this.m02 != r10.m02) goto L21;
        if (this.m10 != r10.m10) goto L21;
        if (this.m11 != r10.m11) goto L21;
        if (this.m12 != r10.m12) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public double getDeterminant() {
        return (this.m00 * this.m11) - (this.m01 * this.m10);
    }

    public void getMatrix(double[] r5) {
        r5[0] = this.m00;
        r5[1] = this.m10;
        r5[2] = this.m01;
        r5[3] = this.m11;
        if (r5.length <= 4) goto L6;
        r5[4] = this.m02;
        r5[5] = this.m12;
        return;
    }

    public double getScaleX() {
        return this.m00;
    }

    public double getScaleY() {
        return this.m11;
    }

    public double getShearX() {
        return this.m01;
    }

    public double getShearY() {
        return this.m10;
    }

    public double getTranslateX() {
        return this.m02;
    }

    public double getTranslateY() {
        return this.m12;
    }

    public int getType() {
        int r1 = this.type;
        if (r1 == (-1)) goto L5;
        return r1;
    L5:
        double r2 = this.m00;
        double r3 = this.m01;
        double r7 = this.m10;
        double r9 = this.m11;
        if (((r2 * r3) + (r7 * r9)) == 0.0d) goto L10;
        return 32;
    L10:
        if (this.m02 == 0.0d) goto L12;
    L25:
        int r6 = 1;
    L27:
        if (((r2 * r9) - (r3 * r7)) >= 0.0d) goto L29;
        r6 = r6 | 64;
    L29:
        double r8 = (r2 * r2) + (r7 * r7);
        if (r8 == ((r3 * r3) + (r9 * r9))) goto L33;
        r6 = r6 | 4;
    L36:
        if (r2 != 0.0d) goto L40;
        if (r9 != 0.0d) goto L40;
    L54:
        return r6 | 8;
    L40:
        if (r7 != 0.0d) goto L49;
        if (r3 != 0.0d) goto L49;
        if (r2 < 0.0d) goto L54;
        if (r9 < 0.0d) goto L54;
    L49:
        if (r3 != 0.0d) goto L53;
        if (r7 != 0.0d) goto L53;
        return r6;
    L53:
        return r6 | 16;
    L33:
        if (r8 == 1.0d) goto L36;
        r6 = r6 | 2;
        goto L36
    L12:
        if (this.m12 != 0.0d) goto L25;
        if (r2 == 1.0d) goto L17;
    L24:
        r6 = 0;
        goto L27
    L17:
        if (r9 != 1.0d) goto L24;
        if (r3 != 0.0d) goto L24;
        if (r7 != 0.0d) goto L24;
        return 0;
    }

    public PointF inverseTransform(PointF r11, PointF r12) {
        double r0 = getDeterminant();
        if (Math.abs(r0) < ZERO) goto L9;
        if (r12 != null) goto L6;
        r12 = new PointF();
    L6:
        float r2 = (float) (((double) r11.x) - this.m02);
        double r3 = r2;
        double r6 = (float) (((double) r11.y) - this.m12);
        r12.set((float) (((this.m11 * r3) - (this.m01 * r6)) / r0), (float) (((r6 * this.m00) - (r3 * this.m10)) / r0));
        return r12;
    L9:
        throw new NoninvertibleTransformException(this, "Determinant is zero");
    }

    public void inverseTransform(double[] r16, int r17, double[] r18, int r19, int r20) {
        double r1 = getDeterminant();
        if (Math.abs(r1) < ZERO) goto L10;
        int r3 = r17;
        int r4 = r19;
        int r5 = r20;
    L5:
        r5 = r5 - 1;
        if (r5 < 0) goto L8;
        int r6 = r3 + 1;
        double r7 = r16[r3] - this.m02;
        r3 = r6 + 1;
        double r9 = r16[r6] - this.m12;
        int r8 = r4 + 1;
        r18[r4] = ((this.m11 * r7) - (this.m01 * r9)) / r1;
        r4 = r8 + 1;
        r18[r8] = ((r9 * this.m00) - (r7 * this.m10)) / r1;
        goto L5
    L8:
        return;
    L10:
        throw new NoninvertibleTransformException(this, "Determinant is zero");
    }

    public boolean isIdentity() {
        if (getType() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    AffineTransform multiply(AffineTransform r25, AffineTransform r26) {
        double r2 = r25.m00;
        double r4 = r26.m00;
        double r8 = r25.m10;
        double r10 = r26.m01;
        double r6 = (r2 * r4) + (r8 * r10);
        double r14 = r26.m10;
        double r7 = r26.m11;
        double r9 = r8 * r7;
        double r11 = r9 + (r2 * r14);
        double r3 = r25.m01;
        double r12 = r25.m11;
        double r18 = (r3 * r4) + (r12 * r10);
        double r13 = r12 * r7;
        double r15 = r13 + (r3 * r14);
        double r5 = r25.m02;
        double r16 = r25.m12;
        double r17 = (r4 * r5) + (r10 * r16);
        return new AffineTransform(r6, r11, r18, r15, r26.m02 + r17, ((r5 * r14) + (r16 * r7)) + r26.m12);
    }

    public void preConcatenate(AffineTransform r1) {
        setTransform(multiply(this, r1));
    }

    public void rotate(double r1) {
        concatenate(getRotateInstance(r1));
    }

    public void rotate(double r1, double r3, double r5) {
        concatenate(getRotateInstance(r1, r3, r5));
    }

    public void scale(double r1, double r3) {
        concatenate(getScaleInstance(r1, r3));
    }

    public void setToIdentity() {
        this.type = 0;
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
    }

    public void setToRotation(double r13) {
        double r0 = Math.sin(r13);
        double r14 = Math.cos(r13);
        if (Math.abs(r14) >= ZERO) goto L10;
        if (r0 <= 0.0d) goto L7;
        r0 = 1.0d;
    L8:
        r14 = 0.0d;
    L16:
        this.m11 = r14;
        this.m00 = r14;
        this.m01 = -r0;
        this.m10 = r0;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.type = -1;
        return;
    L7:
        r0 = -1.0d;
        goto L8
    L10:
        if (Math.abs(r0) >= ZERO) goto L16;
        if (r14 <= 0.0d) goto L14;
        r14 = 1.0d;
    L15:
        r0 = 0.0d;
        goto L16
    L14:
        r14 = -1.0d;
        goto L15
    }

    public void setToRotation(double r9, double r11, double r13) {
        setToRotation(r9);
        double r10 = this.m00;
        double r4 = this.m10;
        this.m02 = ((1.0d - r10) * r11) + (r13 * r4);
        this.m12 = (r13 * (1.0d - r10)) - (r11 * r4);
        this.type = -1;
    }

    public void setToScale(double r3, double r5) {
        this.m00 = r3;
        this.m11 = r5;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = 0.0d;
        this.m10 = 0.0d;
        if (r3 == 1.0d) goto L5;
    L8:
        int r4 = -1;
    L9:
        this.type = r4;
        return;
    L5:
        if (r5 != 1.0d) goto L8;
        r4 = 0;
        goto L9
    }

    public void setToShear(double r3, double r5) {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m12 = 0.0d;
        this.m02 = 0.0d;
        this.m01 = r3;
        this.m10 = r5;
        if (r3 == 0.0d) goto L5;
    L8:
        int r4 = -1;
    L9:
        this.type = r4;
        return;
    L5:
        if (r5 != 0.0d) goto L8;
        r4 = 0;
        goto L9
    }

    public void setToTranslation(double r3, double r5) {
        this.m11 = 1.0d;
        this.m00 = 1.0d;
        this.m10 = 0.0d;
        this.m01 = 0.0d;
        this.m02 = r3;
        this.m12 = r5;
        if (r3 == 0.0d) goto L5;
    L7:
        int r4 = 1;
    L8:
        this.type = r4;
        return;
    L5:
        if (r5 != 0.0d) goto L7;
        r4 = 0;
        goto L8
    }

    public void setTransform(double r2, double r4, double r6, double r8, double r10, double r12) {
        this.type = -1;
        this.m00 = r2;
        this.m10 = r4;
        this.m01 = r6;
        this.m11 = r8;
        this.m02 = r10;
        this.m12 = r12;
    }

    public void setTransform(AffineTransform r15) {
        this.type = r15.type;
        setTransform(r15.m00, r15.m10, r15.m01, r15.m11, r15.m02, r15.m12);
    }

    public void shear(double r1, double r3) {
        concatenate(getShearInstance(r1, r3));
    }

    public Matrix toMatrix() {
        Matrix r0 = new Matrix();
        r0.setValues(new float[]{(float) this.m00, (float) this.m01, (float) this.m02, (float) this.m10, (float) this.m11, (float) this.m12, 0.0f, 0.0f, 1.0f});
        return r0;
    }

    public String toString() {
        return getClass().getName() + "[[" + this.m00 + ", " + this.m01 + ", " + this.m02 + "], [" + this.m10 + ", " + this.m11 + ", " + this.m12 + "]]";
    }

    public PointF transform(PointF r8, PointF r9) {
        r9.set((float) (((((double) r8.x) * this.m00) + (((double) r8.y) * this.m01)) + this.m02), (float) (((((double) r8.x) * this.m10) + (((double) r8.y) * this.m11)) + this.m12));
        return r9;
    }

    public void transform(double[] r11, int r12, double[] r13, int r14, int r15) {
        int r0 = 2;
        if (r11 != r13) goto L8;
        if (r12 >= r14) goto L8;
        int r1 = r15 * 2;
        int r2 = r12 + r1;
        if (r14 >= r2) goto L8;
        r12 = r2 - 2;
        r14 = (r14 + r1) - 2;
        r0 = -2;
    L8:
        r15 = r15 - 1;
        if (r15 < 0) goto L11;
        double r3 = r11[r12 + 0];
        double r4 = r11[r12 + 1];
        r13[r14 + 0] = ((this.m00 * r3) + (this.m01 * r4)) + this.m02;
        r13[r14 + 1] = ((r3 * this.m10) + (r4 * this.m11)) + this.m12;
        r12 = r12 + r0;
        r14 = r14 + r0;
        goto L8
    }

    public void transform(double[] r10, int r11, float[] r12, int r13, int r14) {
    L2:
        r14 = r14 - 1;
        if (r14 < 0) goto L5;
        int r0 = r11 + 1;
        double r1 = r10[r11];
        r11 = r0 + 1;
        double r3 = r10[r0];
        int r2 = r13 + 1;
        r12[r13] = (float) (((this.m00 * r1) + (this.m01 * r3)) + this.m02);
        r13 = r2 + 1;
        r12[r2] = (float) (((r1 * this.m10) + (r3 * this.m11)) + this.m12);
        goto L2
    }

    public void transform(float[] r16, int r17, double[] r18, int r19, int r20) {
        int r1 = r17;
        int r2 = r19;
        int r3 = r20;
    L3:
        r3 = r3 - 1;
        if (r3 < 0) goto L6;
        int r4 = r1 + 1;
        float r5 = r16[r1];
        int r6 = r4 + 1;
        int r7 = r2 + 1;
        double r8 = r5;
        double r11 = r16[r4];
        r18[r2] = ((this.m00 * r8) + (this.m01 * r11)) + this.m02;
        r2 = r7 + 1;
        r18[r7] = ((r8 * this.m10) + (r11 * this.m11)) + this.m12;
        r1 = r6;
        goto L3
    }

    public void transform(float[] r11, int r12, float[] r13, int r14, int r15) {
        int r0 = 2;
        if (r11 != r13) goto L8;
        if (r12 >= r14) goto L8;
        int r1 = r15 * 2;
        int r2 = r12 + r1;
        if (r14 >= r2) goto L8;
        r12 = r2 - 2;
        r14 = (r14 + r1) - 2;
        r0 = -2;
    L8:
        r15 = r15 - 1;
        if (r15 < 0) goto L11;
        float r3 = r11[r12 + 0];
        double r4 = r3;
        double r5 = r11[r12 + 1];
        r13[r14 + 0] = (float) (((this.m00 * r4) + (this.m01 * r5)) + this.m02);
        r13[r14 + 1] = (float) (((r4 * this.m10) + (r5 * this.m11)) + this.m12);
        r12 = r12 + r0;
        r14 = r14 + r0;
        goto L8
    }

    public void transform(PointF[] r10, int r11, PointF[] r12, int r13, int r14) {
    L2:
        r14 = r14 - 1;
        if (r14 < 0) goto L8;
        int r0 = r11 + 1;
        PointF r15 = r10[r11];
        PointF r1 = r12[r13];
        if (r1 != null) goto L7;
        r1 = new PointF();
    L7:
        r1.set((float) (((((double) r15.x) * this.m00) + (((double) r15.y) * this.m01)) + this.m02), (float) (((((double) r15.x) * this.m10) + (((double) r15.y) * this.m11)) + this.m12));
        r12[r13] = r1;
        r13 = r13 + 1;
        r11 = r0;
        goto L2
    }

    public void translate(double r1, double r3) {
        concatenate(getTranslateInstance(r1, r3));
    }
}
