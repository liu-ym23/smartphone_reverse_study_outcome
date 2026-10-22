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

    private ViewingConditions(float r5, float r10, float r11, float r12, float r13, float r14, float[] r15, float r16, float r17, float r18) {
        this.mN = r5;
        this.mAw = r10;
        this.mNbb = r11;
        this.mNcb = r12;
        this.mC = r13;
        this.mNc = r14;
        this.mRgbD = r15;
        this.mFl = r16;
        this.mFlRoot = r17;
        this.mZ = r18;
    }

    @NonNull
    public static ViewingConditions make(@NonNull float[] r22, float r23, float r24, float r25, boolean r26) {
        float[][] r5 = CamUtils.XYZ_TO_CAM16RGB;
        float r10 = r22[0];
        float[] r11 = r5[0];
        float r12 = r11[0] * r10;
        float r13 = r22[1];
        float r14 = (r11[1] * r13) + r12;
        float r15 = r22[2];
        float r16 = (r11[2] * r15) + r14;
        float[] r17 = r5[1];
        float r18 = (r17[2] * r15) + ((r17[1] * r13) + (r17[0] * r10));
        float[] r19 = r5[2];
        float r110 = (r15 * r19[2]) + ((r13 * r19[1]) + (r10 * r19[0]));
        float r20 = (r25 / 10.0f) + 0.8f;
        if (r20 < 0.9d) goto L6;
        float r21 = CamUtils.lerp(0.59f, 0.69f, (r20 - 0.9f) * 10.0f);
    L5:
        float r111 = r21;
        if (r26 == false) goto L10;
        float r27 = 1.0f;
    L11:
        double r112 = r27;
        if (r112 <= 1.0d) goto L15;
        r27 = 1.0f;
    L17:
        float[] r28 = {(((100.0f / r16) * r27) + 1.0f) - r27, (((100.0f / r18) * r27) + 1.0f) - r27, (((100.0f / r110) * r27) + 1.0f) - r27};
        float r113 = 1.0f / ((5.0f * r23) + 1.0f);
        float r114 = ((r113 * r113) * r113) * r113;
        float r29 = 1.0f - r114;
        float r30 = (((0.1f * r29) * r29) * ((float) Math.cbrt(((double) r23) * 5.0d))) + (r114 * r23);
        float r115 = CamUtils.yFromLStar(r24) / r22[1];
        double r31 = r115;
        float r210 = ((float) Math.sqrt(r31)) + 1.48f;
        float r32 = 0.725f / ((float) Math.pow(r31, 0.2d));
        float[] r116 = {(float) Math.pow(((double) ((r28[0] * r30) * r16)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r28[1] * r30) * r18)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r28[2] * r30) * r110)) / 100.0d, 0.42d)};
        float r33 = r116[0];
        float r34 = (r33 * 400.0f) / (r33 + 27.13f);
        float r35 = r116[1];
        float r117 = (r35 * 400.0f) / (r35 + 27.13f);
        float r36 = r116[2];
        float[] r37 = {r34, r117, (400.0f * r36) / (r36 + 27.13f)};
        return new ViewingConditions(r115, ((r37[2] * 0.05f) + ((r37[0] * 2.0f) + r37[1])) * r32, r32, r32, r111, r20, r28, r30, (float) Math.pow(r30, 0.25d), r210);
    L15:
        if (r112 >= 0.0d) goto L17;
        r27 = 0.0f;
        goto L17
    L10:
        r27 = (1.0f - (((float) Math.exp(((-r23) - 42.0f) / 92.0f)) * 0.2777778f)) * r20;
        goto L11
    L6:
        r21 = CamUtils.lerp(0.525f, 0.59f, (r20 - 0.8f) * 10.0f);
        goto L5
    }

    public float getAw() {
        return this.mAw;
    }

    public float getC() {
        return this.mC;
    }

    public float getFl() {
        return this.mFl;
    }

    public float getFlRoot() {
        return this.mFlRoot;
    }

    public float getN() {
        return this.mN;
    }

    public float getNbb() {
        return this.mNbb;
    }

    public float getNc() {
        return this.mNc;
    }

    public float getNcb() {
        return this.mNcb;
    }

    @NonNull
    public float[] getRgbD() {
        return this.mRgbD;
    }

    public float getZ() {
        return this.mZ;
    }
}
