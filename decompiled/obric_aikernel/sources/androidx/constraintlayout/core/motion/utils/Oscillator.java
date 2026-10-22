package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class Oscillator {
    public static final int BOUNCE = 6;
    public static final int COS_WAVE = 5;
    public static final int CUSTOM = 7;
    public static final int REVERSE_SAW_WAVE = 4;
    public static final int SAW_WAVE = 3;
    public static final int SIN_WAVE = 0;
    public static final int SQUARE_WAVE = 1;
    public static String TAG = "Oscillator";
    public static final int TRIANGLE_WAVE = 2;
    double PI2;
    double[] mArea;
    MonotonicCurveFit mCustomCurve;
    String mCustomType;
    private boolean mNormalized;
    float[] mPeriod;
    double[] mPosition;
    int mType;

    static {
    }

    public Oscillator() {
        this.mPeriod = new float[0];
        this.mPosition = new double[0];
        this.PI2 = 6.283185307179586d;
        this.mNormalized = false;
    }

    public void addPoint(double r10, float r11) {
        int r12 = this.mPeriod.length + 1;
        int r13 = Arrays.binarySearch(this.mPosition, r10);
        if (r13 >= 0) goto L5;
        r13 = (-r13) - 1;
    L5:
        this.mPosition = Arrays.copyOf(this.mPosition, r12);
        this.mPeriod = Arrays.copyOf(this.mPeriod, r12);
        this.mArea = new double[r12];
        double[] r14 = this.mPosition;
        System.arraycopy(r14, r13, r14, r13 + 1, (r12 - r13) - 1);
        this.mPosition[r13] = r10;
        this.mPeriod[r13] = r11;
        this.mNormalized = false;
    }

    double getDP(double r11) {
        if (r11 > 0.0d) goto L6;
        r11 = 1.0E-5d;
    L8:
        int r10 = Arrays.binarySearch(this.mPosition, r11);
        if (r10 <= 0) goto L11;
        return 0.0d;
    L11:
        if (r10 == 0) goto L14;
        int r12 = (-r10) - 1;
        float[] r13 = this.mPeriod;
        int r14 = r12 - 1;
        double r15 = r13[r12] - r13[r14];
        double[] r16 = this.mPosition;
        double r17 = r15 / (r16[r12] - r16[r14]);
        return (((double) r13[r14]) - (r17 * r16[r14])) + (r11 * r17);
    L14:
        return 0.0d;
    L6:
        if (r11 < 1.0d) goto L8;
        r11 = 0.999999d;
        goto L8
    }

    double getP(double r11) {
        if (r11 >= 0.0d) goto L6;
        r11 = 0.0d;
    L8:
        int r10 = Arrays.binarySearch(this.mPosition, r11);
        if (r10 > 0) goto L14;
        if (r10 == 0) goto L15;
        int r12 = (-r10) - 1;
        float[] r13 = this.mPeriod;
        int r14 = r12 - 1;
        double r15 = r13[r12] - r13[r14];
        double[] r16 = this.mPosition;
        double r17 = r15 / (r16[r12] - r16[r14]);
        return (this.mArea[r14] + ((((double) r13[r14]) - (r16[r14] * r17)) * (r11 - r16[r14]))) + ((r17 * ((r11 * r11) - (r16[r14] * r16[r14]))) / 2.0d);
    L15:
        return 0.0d;
    L14:
        return 1.0d;
    L6:
        if (r11 <= 1.0d) goto L8;
        r11 = 1.0d;
        goto L8
    }

    public double getSlope(double r10, double r11, double r12) {
        double r13 = r11 + getP(r10);
        double r14 = getDP(r10) + r12;
        switch(this.mType) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L4;
        };
    L4:
        double r15 = this.PI2;
        double r16 = r14 * r15;
        double r17 = Math.cos(r15 * r13);
    L6:
        return r16 * r17;
    L9:
        r16 = r14 * 4.0d;
        r17 = (((r13 * 4.0d) + 2.0d) % 4.0d) - 2.0d;
        goto L6
    L10:
        double r18 = this.PI2;
        return ((-r18) * r14) * Math.sin(r18 * r13);
    L16:
        r16 = r14 * 4.0d;
        r17 = Math.signum((((r13 * 4.0d) + 3.0d) % 4.0d) - 2.0d);
        goto L6
    L17:
        return 0.0d;
    L8:
        return this.mCustomCurve.getSlope(r13 % 1.0d, 0);
    L13:
        return (-r14) * 2.0d;
    L15:
        return r14 * 2.0d;
    }

    public double getValue(double r10, double r11) {
        double r12 = getP(r10) + r11;
        switch(this.mType) {
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L5;
        };
    L8:
        double r13 = 1.0d - Math.abs(((r12 * 4.0d) % 4.0d) - 2.0d);
        return 1.0d - (r13 * r13);
    L5:
        return Math.sin(this.PI2 * r12);
    L7:
        return this.mCustomCurve.getPos(r12 % 1.0d, 0);
    L11:
        return Math.cos(this.PI2 * (r11 + r12));
    L13:
        return 1.0d - (((r12 * 2.0d) + 1.0d) % 2.0d);
    L15:
        return (((r12 * 2.0d) + 1.0d) % 2.0d) - 1.0d;
    L17:
        return 1.0d - Math.abs((((r12 * 4.0d) + 1.0d) % 4.0d) - 2.0d);
    L19:
        return Math.signum(0.5d - (r12 % 1.0d));
    }

    public void normalize() {
        int r10 = 0;
        double r11 = 0.0d;
    L3:
        float[] r12 = this.mPeriod;
        if (r10 >= r12.length) goto L6;
        r11 = r11 + ((double) r12[r10]);
        r10 = r10 + 1;
        goto L3
    L6:
        double r13 = 0.0d;
        int r14 = 1;
    L7:
        float[] r15 = this.mPeriod;
        if (r14 >= r15.length) goto L10;
        int r16 = r14 - 1;
        float r17 = (r15[r16] + r15[r14]) / 2.0f;
        double[] r18 = this.mPosition;
        r13 = r13 + ((r18[r14] - r18[r16]) * ((double) r17));
        r14 = r14 + 1;
        goto L7
    L10:
        int r19 = 0;
    L11:
        float[] r110 = this.mPeriod;
        if (r19 >= r110.length) goto L14;
        r110[r19] = (float) (((double) r110[r19]) * (r11 / r13));
        r19 = r19 + 1;
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
        r26[r20] = r26[r22] + (r25 * ((double) r23));
        r20 = r20 + 1;
        goto L15
    L18:
        this.mNormalized = true;
    }

    public void setType(int r10, String r11) {
        this.mType = r10;
        this.mCustomType = r11;
        if (r11 == null) goto L6;
        this.mCustomCurve = MonotonicCurveFit.buildWave(r11);
        return;
    }

    public String toString() {
        return "pos =" + Arrays.toString(this.mPosition) + " period=" + Arrays.toString(this.mPeriod);
    }
}
