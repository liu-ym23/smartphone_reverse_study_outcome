package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes.dex */
public class VelocityMatrix {
    private static String TAG = "VelocityMatrix";
    float mDRotate;
    float mDScaleX;
    float mDScaleY;
    float mDTranslateX;
    float mDTranslateY;
    float mRotate;

    static {
    }

    public VelocityMatrix() {
    }

    public void applyTransform(float r18, float r19, int r20, int r21, float[] r22) {
        float r10 = r22[0];
        float r11 = r22[1];
        float r12 = (r18 - 0.5f) * 2.0f;
        float r13 = (r19 - 0.5f) * 2.0f;
        float r14 = r10 + this.mDTranslateX;
        float r15 = r11 + this.mDTranslateY;
        float r16 = r14 + (this.mDScaleX * r12);
        float r17 = r15 + (this.mDScaleY * r13);
        float r23 = (float) Math.toRadians(this.mRotate);
        float r24 = (float) Math.toRadians(this.mDRotate);
        double r110 = r23;
        double r111 = r21 * r13;
        float r25 = r16 + (((float) ((((double) ((-r20) * r12)) * Math.sin(r110)) - (Math.cos(r110) * r111))) * r24);
        float r26 = r17 + (r24 * ((float) ((((double) (r20 * r12)) * Math.cos(r110)) - (r111 * Math.sin(r110)))));
        r22[0] = r25;
        r22[1] = r26;
    }

    public void clear() {
        this.mDRotate = 0.0f;
        this.mDTranslateY = 0.0f;
        this.mDTranslateX = 0.0f;
        this.mDScaleY = 0.0f;
        this.mDScaleX = 0.0f;
    }

    public void setRotationVelocity(KeyCycleOscillator r10, float r11) {
        if (r10 == null) goto L5;
        this.mDRotate = r10.getSlope(r11);
        return;
    }

    public void setRotationVelocity(SplineSet r10, float r11) {
        if (r10 == null) goto L5;
        this.mDRotate = r10.getSlope(r11);
        this.mRotate = r10.get(r11);
        return;
    }

    public void setScaleVelocity(KeyCycleOscillator r10, KeyCycleOscillator r11, float r12) {
        if (r10 == null) goto L4;
        this.mDScaleX = r10.getSlope(r12);
    L4:
        if (r11 == null) goto L7;
        this.mDScaleY = r11.getSlope(r12);
        return;
    }

    public void setScaleVelocity(SplineSet r10, SplineSet r11, float r12) {
        if (r10 == null) goto L4;
        this.mDScaleX = r10.getSlope(r12);
    L4:
        if (r11 == null) goto L7;
        this.mDScaleY = r11.getSlope(r12);
        return;
    }

    public void setTranslationVelocity(KeyCycleOscillator r10, KeyCycleOscillator r11, float r12) {
        if (r10 == null) goto L4;
        this.mDTranslateX = r10.getSlope(r12);
    L4:
        if (r11 == null) goto L7;
        this.mDTranslateY = r11.getSlope(r12);
        return;
    }

    public void setTranslationVelocity(SplineSet r10, SplineSet r11, float r12) {
        if (r10 == null) goto L4;
        this.mDTranslateX = r10.getSlope(r12);
    L4:
        if (r11 == null) goto L7;
        this.mDTranslateY = r11.getSlope(r12);
        return;
    }
}
