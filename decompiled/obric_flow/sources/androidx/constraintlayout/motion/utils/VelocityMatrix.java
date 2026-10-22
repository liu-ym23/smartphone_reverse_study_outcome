package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;

/* JADX INFO: loaded from: classes.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    public VelocityMatrix() {
    }

    public void applyTransform(float r16, float r17, int r18, int r19, float[] r20) {
        float r5 = r20[0];
        float r10 = r20[1];
        float r11 = (r16 - 0.5f) * 2.0f;
        float r12 = (r17 - 0.5f) * 2.0f;
        float r13 = r5 + this.mDTranslateX;
        float r14 = r10 + this.mDTranslateY;
        float r15 = (this.mDScaleX * r11) + r13;
        float r21 = (this.mDScaleY * r12) + r14;
        float r22 = (float) Math.toRadians(this.mRotate);
        float r23 = (float) Math.toRadians(this.mDRotate);
        double r110 = r22;
        double r24 = r19 * r12;
        float r25 = (((float) ((Math.sin(r110) * ((double) ((-r18) * r11))) - (Math.cos(r110) * r24))) * r23) + r15;
        float r26 = (r23 * ((float) ((Math.cos(r110) * ((double) (r18 * r11))) - (Math.sin(r110) * r24)))) + r21;
        r20[0] = r25;
        r20[1] = r26;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(SplineSet r5, float r10) {
        if (r5 == null) goto L5;
        this.mDRotate = r5.getSlope(r10);
        this.mRotate = r5.get(r10);
        return;
    }

    public void setScaleVelocity(SplineSet r5, SplineSet r10, float r11) {
        if (r5 == null) goto L4;
        this.mDScaleX = r5.getSlope(r11);
    L4:
        if (r10 == null) goto L7;
        this.mDScaleY = r10.getSlope(r11);
        return;
    }

    public void setTranslationVelocity(SplineSet r5, SplineSet r10, float r11) {
        if (r5 == null) goto L4;
        this.mDTranslateX = r5.getSlope(r11);
    L4:
        if (r10 == null) goto L7;
        this.mDTranslateY = r10.getSlope(r11);
        return;
    }

    public void setRotationVelocity(KeyCycleOscillator r5, float r10) {
        if (r5 == null) goto L5;
        this.mDRotate = r5.getSlope(r10);
        return;
    }

    public void setScaleVelocity(KeyCycleOscillator r5, KeyCycleOscillator r10, float r11) {
        if (r5 != null) goto L5;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r5 != null) goto L7;
        this.mDScaleX = r5.getSlope(r11);
    L7:
        if (r10 != null) goto L10;
        this.mDScaleY = r10.getSlope(r11);
        return;
    }

    public void setTranslationVelocity(KeyCycleOscillator r5, KeyCycleOscillator r10, float r11) {
        if (r5 == null) goto L4;
        this.mDTranslateX = r5.getSlope(r11);
    L4:
        if (r10 == null) goto L7;
        this.mDTranslateY = r10.getSlope(r11);
        return;
    }
}
