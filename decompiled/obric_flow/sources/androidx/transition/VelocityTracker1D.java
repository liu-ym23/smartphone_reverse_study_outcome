package androidx.transition;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples;
    private int mIndex;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] r5 = new long[20];
        this.mTimeSamples = r5;
        this.mDataSamples = new float[20];
        this.mIndex = 0;
        Arrays.fill(r5, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float r5) {
        return (float) (Math.sqrt(Math.abs(r5) * 2.0f) * Math.signum(r5));
    }

    public void addDataPoint(long r5, float r10) {
        int r11 = (this.mIndex + 1) % 20;
        this.mIndex = r11;
        this.mTimeSamples[r11] = r5;
        this.mDataSamples[r11] = r10;
    }

    public float calculateVelocity() {
        int r5 = this.mIndex;
        if (r5 == 0) goto L5;
    L7:
        long r10 = this.mTimeSamples[r5];
        int r11 = 0;
        long r12 = r10;
    L8:
        long r13 = this.mTimeSamples[r5];
        if (r13 == Long.MIN_VALUE) goto L23;
        float r14 = r10 - r13;
        float r15 = Math.abs(r13 - r12);
        if (r14 > 100.0f) goto L23;
        if (r15 > 40.0f) goto L23;
        if (r5 != 0) goto L18;
        r5 = 20;
    L18:
        r5 = r5 - 1;
        r11 = r11 + 1;
        if (r11 >= 20) goto L23;
        r12 = r13;
    L23:
        if (r11 >= 2) goto L26;
        return 0.0f;
    L26:
        if (r11 != 2) goto L36;
        int r16 = this.mIndex;
        if (r16 != 0) goto L30;
        int r17 = 19;
    L31:
        long[] r18 = this.mTimeSamples;
        float r19 = r18[r16] - r18[r17];
        if (r19 != 0.0f) goto L34;
        return 0.0f;
    L34:
        float[] r110 = this.mDataSamples;
        return ((r110[r16] - r110[r17]) / r19) * 1000.0f;
    L30:
        r17 = r16 - 1;
        goto L31
    L36:
        int r20 = this.mIndex;
        int r21 = ((r20 - r11) + 21) % 20;
        int r22 = (r20 + 21) % 20;
        long r23 = this.mTimeSamples[r21];
        float r24 = this.mDataSamples[r21];
        int r25 = r21 + 1;
        int r26 = r25 % 20;
        float r27 = 0.0f;
    L37:
        if (r26 == r22) goto L47;
        long r28 = this.mTimeSamples[r26];
        float r111 = r28 - r23;
        if (r111 == 0.0f) goto L45;
        float r29 = this.mDataSamples[r26];
        float r30 = (r29 - r24) / r111;
        float r31 = (Math.abs(r30) * (r30 - kineticEnergyToVelocity(r27))) + r27;
        if (r26 != r25) goto L44;
        r31 = r31 * 0.5f;
    L44:
        r27 = r31;
        r24 = r29;
        r23 = r28;
    L45:
        r26 = (r26 + 1) % 20;
        goto L37
    L47:
        return kineticEnergyToVelocity(r27) * 1000.0f;
    L5:
        if (this.mTimeSamples[r5] != Long.MIN_VALUE) goto L7;
        return 0.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
