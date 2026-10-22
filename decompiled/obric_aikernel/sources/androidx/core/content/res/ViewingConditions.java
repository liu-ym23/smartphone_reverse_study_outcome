package androidx.core.content.res;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
final class ViewingConditions {
    static final ViewingConditions DEFAULT = null;
    private final float mAw;
    private final float mC;
    private final float mFl;
    private final float mFlRoot;
    private final float mN;
    private final float mNbb;
    private final float mNc;
    private final float mNcb;
    private final float[] mRgbD;
    private final float mZ;

    static {
        DEFAULT = make(CamUtils.WHITE_POINT_D65, (float) ((((double) CamUtils.yFromLStar(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    private ViewingConditions(float r10, float r11, float r12, float r13, float r14, float r15, float[] r16, float r17, float r18, float r19) {
        this.mN = r10;
        this.mAw = r11;
        this.mNbb = r12;
        this.mNcb = r13;
        this.mC = r14;
        this.mNc = r15;
        this.mRgbD = r16;
        this.mFl = r17;
        this.mFlRoot = r18;
        this.mZ = r19;
    }

    @NonNull
    static ViewingConditions make(@NonNull float[] r21, float r22, float r23, float r24, boolean r25) {
        float[][] r10 = CamUtils.XYZ_TO_CAM16RGB;
        float r11 = ((r21[0] * r10[0][0]) + (r21[1] * r10[0][1])) + (r21[2] * r10[0][2]);
        float r12 = ((r21[0] * r10[1][0]) + (r21[1] * r10[1][1])) + (r21[2] * r10[1][2]);
        float r13 = ((r21[0] * r10[2][0]) + (r21[1] * r10[2][1])) + (r21[2] * r10[2][2]);
        float r14 = (r24 / 10.0f) + 0.8f;
        if (r14 < 0.9d) goto L5;
        float r15 = CamUtils.lerp(0.59f, 0.69f, (r14 - 0.9f) * 10.0f);
    L6:
        float r16 = r15;
        if (r25 == false) goto L9;
        float r17 = 1.0f;
    L10:
        double r18 = r17;
        if (r18 <= 1.0d) goto L14;
        r17 = 1.0f;
    L16:
        float[] r19 = {(((100.0f / r11) * r17) + 1.0f) - r17, (((100.0f / r12) * r17) + 1.0f) - r17, (((100.0f / r13) * r17) + 1.0f) - r17};
        float r20 = 1.0f / ((5.0f * r22) + 1.0f);
        float r110 = ((r20 * r20) * r20) * r20;
        float r26 = 1.0f - r110;
        float r27 = (r110 * r22) + (((0.1f * r26) * r26) * ((float) Math.cbrt(((double) r22) * 5.0d)));
        float r111 = CamUtils.yFromLStar(r23) / r21[1];
        double r112 = r111;
        float r28 = ((float) Math.sqrt(r112)) + 1.48f;
        float r29 = 0.725f / ((float) Math.pow(r112, 0.2d));
        float[] r30 = {(float) Math.pow(((double) ((r19[0] * r27) * r11)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r19[1] * r27) * r12)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r19[2] * r27) * r13)) / 100.0d, 0.42d)};
        float[] r31 = {(r30[0] * 400.0f) / (r30[0] + 27.13f), (r30[1] * 400.0f) / (r30[1] + 27.13f), (r30[2] * 400.0f) / (r30[2] + 27.13f)};
        return new ViewingConditions(r111, (((r31[0] * 2.0f) + r31[1]) + (r31[2] * 0.05f)) * r29, r29, r29, r16, r14, r19, r27, (float) Math.pow(r27, 0.25d), r28);
    L14:
        if (r18 >= 0.0d) goto L16;
        r17 = 0.0f;
        goto L16
    L9:
        r17 = (1.0f - (((float) Math.exp(((-r22) - 42.0f) / 92.0f)) * 0.2777778f)) * r14;
        goto L10
    L5:
        r15 = CamUtils.lerp(0.525f, 0.59f, (r14 - 0.8f) * 10.0f);
        goto L6
    }

    float getAw() {
        return this.mAw;
    }

    float getC() {
        return this.mC;
    }

    float getFl() {
        return this.mFl;
    }

    float getFlRoot() {
        return this.mFlRoot;
    }

    float getN() {
        return this.mN;
    }

    float getNbb() {
        return this.mNbb;
    }

    float getNc() {
        return this.mNc;
    }

    float getNcb() {
        return this.mNcb;
    }

    @NonNull
    float[] getRgbD() {
        return this.mRgbD;
    }

    float getZ() {
        return this.mZ;
    }
}
