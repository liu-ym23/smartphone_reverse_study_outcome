package com.obric.cae.smartBluetooth.a2dpJitterML;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class A2dpJitterMlPredictor {
    public static final String DEFAULT_MODEL_NAME = "tf_lstm_seq5_retime_endlabel_tailmaj3of2_extra.tflite";
    private static final String TAG = "A2dpJitterMlPredictor";
    private static volatile PredictionResult sLastResultForDebug;
    private final int mFeatureDim;
    private final Object mLock;
    private final A2dpJitterMlModel mModel;
    private final float[][][] mSeqBuf;
    private int mSeqFilled;
    private final int mSeqLen;

    public static final class PredictionResult {
        public final float mProbability;
        public final boolean mReady;
        public final long mTimestampMs;

        public PredictionResult(long r8, boolean r10, float r11) {
            this.mTimestampMs = r8;
            this.mReady = r10;
            this.mProbability = r11;
        }

        public String toString() {
            return "PredictionResult{mTimestampMs=" + this.mTimestampMs + ", mReady=" + this.mReady + ", mProbability=" + this.mProbability + '}';
        }
    }

    public A2dpJitterMlPredictor(Context r8, String r10) {
        this.mLock = new Object();
        this.mSeqFilled = 0;
        A2dpJitterMlModel r11 = A2dpJitterMlModel.getInstance(r8, r10);
        this.mModel = r11;
        int r12 = r11.getSeqLen();
        this.mSeqLen = r12;
        int r13 = r11.getFeatureDim();
        this.mFeatureDim = r13;
        int[] r14 = {1, r12, r13};
        this.mSeqBuf = (float[][][]) Array.newInstance(Float.TYPE, r14);
    }

    public static PredictionResult getLastResultForDebug() {
        return sLastResultForDebug;
    }

    private void shiftLeftByOne(float[][] r8) {
        int r10 = 0;
    L4:
        if (r10 >= (this.mSeqLen - 1)) goto L6;
        int r11 = r10 + 1;
        System.arraycopy(r8[r11], 0, r8[r10], 0, this.mFeatureDim);
        r10 = r11;
        goto L4
    }

    private float sigmoid(float r8) {
        return 1.0f / (((float) Math.exp(-r8)) + 1.0f);
    }

    private float softmaxPositive(float r8, float r10) {
        float r11 = Math.max(r8, r10);
        float r12 = (float) Math.exp(r8 - r11);
        float r13 = (float) Math.exp(r10 - r11);
        float r14 = r12 + r13;
        if (r14 > 0.0f) goto L5;
        return 0.0f;
    L5:
        return r13 / r14;
    }

    private float toProbability(float[] r8) {
        if (r8 != null) goto L4;
        return 0.0f;
    L4:
        if (r8.length != 0) goto L7;
        return 0.0f;
    L7:
        if (r8.length != 1) goto L11;
        return sigmoid(r8[0]);
    L11:
        if (r8.length != 2) goto L15;
        return softmaxPositive(r8[0], r8[1]);
    L15:
        return r8[0];
    }

    public PredictionResult addSample(long r8, float[] r10) {
        if (r10 == null) goto L23;
        if (r10.length != this.mFeatureDim) goto L23;
        Object r11 = this.mLock;
        monitor-enter(r11);
        shiftLeftByOne(this.mSeqBuf[0]);     // Catch: Throwable -> L19
        System.arraycopy(r10, 0, this.mSeqBuf[0][this.mSeqLen - 1], 0, this.mFeatureDim);     // Catch: Throwable -> L19
        int r12 = this.mSeqFilled;     // Catch: Throwable -> L19
        int r13 = this.mSeqLen;     // Catch: Throwable -> L19
        if (r12 >= r13) goto L12;
        this.mSeqFilled = r12 + 1;     // Catch: Throwable -> L19
    L12:
        if (this.mSeqFilled >= r13) goto L16;
        PredictionResult r14 = new PredictionResult(r8, false, Float.NaN);     // Catch: Throwable -> L19
        sLastResultForDebug = r14;     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        return r14;
    L16:
        float r15 = toProbability(this.mModel.infer(this.mSeqBuf));     // Catch: Throwable -> L19
        CaeLog.d(TAG, "prob: " + r15);     // Catch: Throwable -> L19
        PredictionResult r16 = new PredictionResult(r8, true, r15);     // Catch: Throwable -> L19
        sLastResultForDebug = r16;     // Catch: Throwable -> L19
        monitor-exit(r11);     // Catch: Throwable -> L19
        return r16;
    L19:
        th = move-exception;
        throw th;
    L23:
        throw new IllegalArgumentException("featureVector length must be " + this.mFeatureDim);
    }

    public int getFeatureDim() {
        return this.mFeatureDim;
    }

    public int getSeqLen() {
        return this.mSeqLen;
    }

    public void reset() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        int r10 = 0;
    L14:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r10 >= this.mSeqLen) goto L8;
        Arrays.fill(this.mSeqBuf[0][r10], 0.0f);     // Catch: Throwable -> L11
        r10 = r10 + 1;     // Catch: Throwable -> L11
        goto L14
    L8:
        this.mSeqFilled = 0;     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
    }
}
