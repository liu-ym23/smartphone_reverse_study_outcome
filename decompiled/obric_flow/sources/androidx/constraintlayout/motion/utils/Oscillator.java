package androidx.constraintlayout.motion.utils;

import ai.j0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double PI2;
    double[] mArea;
    private boolean mNormalized;
    float[] mPeriod;
    double[] mPosition;
    int mType;

    public Oscillator() {
        this.mPeriod = new float[0];
        this.mPosition = new double[0];
        this.PI2 = 6.283185307179586d;
        this.mNormalized = false;
    }

    public void addPoint(double r5, float r10) {
        int r11 = this.mPeriod.length + 1;
        int r12 = Arrays.binarySearch(this.mPosition, r5);
        if (r12 >= 0) goto L5;
        r12 = (-r12) - 1;
    L5:
        this.mPosition = Arrays.copyOf(this.mPosition, r11);
        this.mPeriod = Arrays.copyOf(this.mPeriod, r11);
        this.mArea = new double[r11];
        double[] r13 = this.mPosition;
        System.arraycopy(r13, r12, r13, r12 + 1, (r11 - r12) - 1);
        this.mPosition[r12] = r5;
        this.mPeriod[r12] = r10;
        this.mNormalized = false;
    }

    public double getDP(double r10) {
        if (r10 > 0.0d) goto L6;
        r10 = 1.0E-5d;
    L8:
        int r5 = Arrays.binarySearch(this.mPosition, r10);
        if (r5 <= 0) goto L11;
        return 0.0d;
    L11:
        if (r5 == 0) goto L14;
        int r11 = -r5;
        int r12 = r11 - 1;
        float[] r13 = this.mPeriod;
        float r14 = r13[r12];
        int r15 = r11 - 2;
        float r16 = r13[r15];
        double[] r17 = this.mPosition;
        double r18 = r17[r12];
        double r19 = r17[r15];
        double r20 = ((double) (r14 - r16)) / (r18 - r19);
        return (((double) r16) - (r20 * r19)) + (r10 * r20);
    L14:
        return 0.0d;
    L6:
        if (r10 < 1.0d) goto L8;
        r10 = 0.999999d;
        goto L8
    }

    public double getP(double r19) {
        if (r19 >= 0.0d) goto L6;
        double r14 = 0.0d;
    L9:
        int r5 = Arrays.binarySearch(this.mPosition, r14);
        if (r5 > 0) goto L15;
        if (r5 == 0) goto L16;
        int r10 = -r5;
        int r11 = r10 - 1;
        float[] r12 = this.mPeriod;
        float r13 = r12[r11];
        int r15 = r10 - 2;
        float r16 = r12[r15];
        double[] r17 = this.mPosition;
        double r18 = r17[r11];
        double r110 = r17[r15];
        double r20 = ((double) (r13 - r16)) / (r18 - r110);
        double r21 = r14;
        return ((((r14 * r14) - (r110 * r110)) * r20) / 2.0d) + j0.a(r21, r110, ((double) r16) - (r20 * r110), this.mArea[r15]);
    L16:
        return 0.0d;
    L15:
        return 1.0d;
    L6:
        if (r19 <= 1.0d) goto L8;
        r14 = 1.0d;
        goto L9
    L8:
        r14 = r19;
        goto L9
    }

    public double getSlope(double r10) {
        switch(this.mType) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        double r5 = this.PI2;
        double r11 = getDP(r10) * r5;
        double r12 = this.PI2;
        return Math.cos(getP(r10) * r12) * r11;
    L6:
        double r13 = getDP(r10) * 4.0d;
        return ((((getP(r10) * 4.0d) + 2.0d) % 4.0d) - 2.0d) * r13;
    L8:
        double r14 = -this.PI2;
        double r15 = getDP(r10) * r14;
        double r16 = this.PI2;
        return Math.sin(getP(r10) * r16) * r15;
    L14:
        double r17 = getDP(r10) * 4.0d;
        return Math.signum((((getP(r10) * 4.0d) + 3.0d) % 4.0d) - 2.0d) * r17;
    L16:
        return 0.0d;
    L11:
        return (-getDP(r10)) * 2.0d;
    L13:
        return getDP(r10) * 2.0d;
    }

    public double getValue(double r10) {
        switch(this.mType) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L4;
        };
    L4:
        double r5 = this.PI2;
        return Math.sin(getP(r10) * r5);
    L6:
        double r11 = 1.0d - Math.abs(((getP(r10) * 4.0d) % 4.0d) - 2.0d);
        double r12 = r11 * r11;
    L8:
        return 1.0d - r12;
    L9:
        double r13 = this.PI2;
        return Math.cos(getP(r10) * r13);
    L11:
        r12 = ((getP(r10) * 2.0d) + 1.0d) % 2.0d;
        goto L8
    L14:
        r12 = Math.abs((((getP(r10) * 4.0d) + 1.0d) % 4.0d) - 2.0d);
        goto L8
    L13:
        return (((getP(r10) * 2.0d) + 1.0d) % 2.0d) - 1.0d;
    L16:
        return Math.signum(0.5d - (getP(r10) % 1.0d));
    }

    public void normalize() {
        double r5 = 0.0d;
        int r10 = 0;
    L3:
        float[] r11 = this.mPeriod;
        if (r10 >= r11.length) goto L6;
        r5 = r5 + ((double) r11[r10]);
        r10 = r10 + 1;
        goto L3
    L6:
        double r12 = 0.0d;
        int r13 = 1;
    L7:
        float[] r14 = this.mPeriod;
        if (r13 >= r14.length) goto L10;
        int r15 = r13 - 1;
        float r16 = (r14[r15] + r14[r13]) / 2.0f;
        double[] r17 = this.mPosition;
        r12 = r12 + ((r17[r13] - r17[r15]) * ((double) r16));
        r13 = r13 + 1;
        goto L7
    L10:
        int r18 = 0;
    L11:
        float[] r19 = this.mPeriod;
        if (r18 >= r19.length) goto L14;
        r19[r18] = (float) (((double) r19[r18]) * (r5 / r12));
        r18 = r18 + 1;
        goto L11
    L14:
        this.mArea[0] = 0.0d;
        int r20 = 1;
    L15:
        float[] r21 = this.mPeriod;
        if (r20 >= r21.length) goto L18;
        int r22 = r20 - 1;
        float r23 = (r21[r22] + r21[r20]) / 2.0f;
        double[] r24 = this.mPosition;
        double r25 = r24[r20] - r24[r22];
        double[] r26 = this.mArea;
        r26[r20] = (r25 * ((double) r23)) + r26[r22];
        r20 = r20 + 1;
        goto L15
    L18:
        this.mNormalized = true;
    }

    public void setType(int r5) {
        this.mType = r5;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
