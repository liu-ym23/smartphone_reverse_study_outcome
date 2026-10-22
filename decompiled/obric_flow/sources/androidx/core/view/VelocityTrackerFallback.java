package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private int mDataPointsBufferLastUsedIndex;
    private int mDataPointsBufferSize;
    private final long[] mEventTimes;
    private float mLastComputedVelocity;
    private final float[] mMovements;

    public VelocityTrackerFallback() {
        this.mMovements = new float[20];
        this.mEventTimes = new long[20];
        this.mLastComputedVelocity = 0.0f;
        this.mDataPointsBufferSize = 0;
        this.mDataPointsBufferLastUsedIndex = 0;
    }

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        int r5 = this.mDataPointsBufferSize;
        if (r5 >= 2) goto L5;
        return 0.0f;
    L5:
        int r10 = this.mDataPointsBufferLastUsedIndex;
        int r11 = ((r10 + 20) - (r5 - 1)) % 20;
        long r12 = this.mEventTimes[r10];
    L6:
        long[] r13 = this.mEventTimes;
        long r14 = r13[r11];
        if ((r12 - r14) <= RANGE_MS) goto L9;
        this.mDataPointsBufferSize--;
        r11 = (r11 + 1) % 20;
        goto L6
    L9:
        int r15 = this.mDataPointsBufferSize;
        if (r15 >= 2) goto L12;
        return 0.0f;
    L12:
        if (r15 != 2) goto L18;
        int r16 = (r11 + 1) % 20;
        long r17 = r13[r16];
        if (r14 != r17) goto L17;
        return 0.0f;
    L17:
        return this.mMovements[r16] / (r17 - r14);
    L18:
        int r18 = 0;
        float r19 = 0.0f;
        int r20 = 0;
    L20:
        if (r18 >= (this.mDataPointsBufferSize - 1)) goto L30;
        int r21 = r18 + r11;
        long[] r22 = this.mEventTimes;
        long r23 = r22[r21 % 20];
        int r24 = (r21 + 1) % 20;
        if (r22[r24] == r23) goto L28;
        r20 = r20 + 1;
        float r25 = kineticEnergyToVelocity(r19);
        float r26 = this.mMovements[r24] / (this.mEventTimes[r24] - r23);
        float r27 = (Math.abs(r26) * (r26 - r25)) + r19;
        if (r20 != 1) goto L27;
        r27 = r27 * 0.5f;
    L27:
        r19 = r27;
    L28:
        r18 = r18 + 1;
        goto L20
    L30:
        return kineticEnergyToVelocity(r19);
    }

    private static float kineticEnergyToVelocity(float r5) {
        if (r5 >= 0.0f) goto L5;
        float r10 = -1.0f;
    L7:
        return r10 * ((float) Math.sqrt(Math.abs(r5) * 2.0f));
    L5:
        r10 = 1.0f;
        goto L7
    }

    public void addMovement(@NonNull MotionEvent r10) {
        long r5 = r10.getEventTime();
        if (this.mDataPointsBufferSize != 0) goto L5;
    L7:
        int r11 = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = r11;
        int r12 = this.mDataPointsBufferSize;
        if (r12 == 20) goto L10;
        this.mDataPointsBufferSize = r12 + 1;
    L10:
        this.mMovements[r11] = r10.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = r5;
        return;
    L5:
        if ((r5 - this.mEventTimes[this.mDataPointsBufferLastUsedIndex]) <= ASSUME_POINTER_STOPPED_MS) goto L7;
        clear();
        goto L7
    }

    public void computeCurrentVelocity(int r5) {
        computeCurrentVelocity(r5, Float.MAX_VALUE);
    }

    public float getAxisVelocity(int r5) {
        if (r5 == 26) goto L7;
        return 0.0f;
    L7:
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int r5, float r10) {
        float r11 = getCurrentVelocity() * r5;
        this.mLastComputedVelocity = r11;
        if (r11 >= (-Math.abs(r10))) goto L6;
        this.mLastComputedVelocity = -Math.abs(r10);
        return;
    L6:
        if (this.mLastComputedVelocity <= Math.abs(r10)) goto L10;
        this.mLastComputedVelocity = Math.abs(r10);
        return;
    }
}
