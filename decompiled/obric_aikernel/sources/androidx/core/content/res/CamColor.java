package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.DoubleCompanionObject;

/* JADX INFO: loaded from: classes.dex */
class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    CamColor(float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18) {
        this.mHue = r10;
        this.mChroma = r11;
        this.mJ = r12;
        this.mQ = r13;
        this.mM = r14;
        this.mS = r15;
        this.mJstar = r16;
        this.mAstar = r17;
        this.mBstar = r18;
    }

    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, to = 360.0d) float r12, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r13, @FloatRange(from = 0.0d, to = 100.0d) float r14) {
        float r10 = 1000.0f;
        float r11 = 0.0f;
        CamColor r15 = null;
        float r16 = 100.0f;
        float r17 = 1000.0f;
    L4:
        if (Math.abs(r11 - r16) <= LIGHTNESS_SEARCH_ENDPOINT) goto L19;
        float r18 = ((r16 - r11) / 2.0f) + r11;
        int r19 = fromJch(r18, r13, r12).viewedInSrgb();
        float r20 = CamUtils.lStarFromInt(r19);
        float r21 = Math.abs(r14 - r20);
        if (r21 >= 0.2f) goto L11;
        CamColor r22 = fromColor(r19);
        float r110 = r22.distance(fromJch(r22.getJ(), r22.getChroma(), r12));
        if (r110 > 1.0f) goto L11;
        r15 = r22;
        r10 = r21;
        r17 = r110;
    L11:
        if (r10 != 0.0f) goto L16;
        if (r17 == 0.0f) goto L19;
    L16:
        if (r20 < r14) goto L17;
        r16 = r18;
        goto L4
    L17:
        r11 = r18;
    L19:
        return r15;
    }

    @NonNull
    static CamColor fromColor(@ColorInt int r10) {
        return fromColorInViewingConditions(r10, ViewingConditions.DEFAULT);
    }

    @NonNull
    static CamColor fromColorInViewingConditions(@ColorInt int r23, @NonNull ViewingConditions r24) {
        float[] r10 = CamUtils.xyzFromInt(r23);
        float[][] r11 = CamUtils.XYZ_TO_CAM16RGB;
        float r12 = ((r10[0] * r11[0][0]) + (r10[1] * r11[0][1])) + (r10[2] * r11[0][2]);
        float r13 = ((r10[0] * r11[1][0]) + (r10[1] * r11[1][1])) + (r10[2] * r11[1][2]);
        float r14 = ((r10[0] * r11[2][0]) + (r10[1] * r11[2][1])) + (r10[2] * r11[2][2]);
        float r15 = r24.getRgbD()[0] * r12;
        float r16 = r24.getRgbD()[1] * r13;
        float r17 = r24.getRgbD()[2] * r14;
        float r18 = (float) Math.pow(((double) (r24.getFl() * Math.abs(r15))) / 100.0d, 0.42d);
        float r19 = (float) Math.pow(((double) (r24.getFl() * Math.abs(r16))) / 100.0d, 0.42d);
        float r20 = (float) Math.pow(((double) (r24.getFl() * Math.abs(r17))) / 100.0d, 0.42d);
        float r21 = ((Math.signum(r15) * 400.0f) * r18) / (r18 + 27.13f);
        float r22 = ((Math.signum(r16) * 400.0f) * r19) / (r19 + 27.13f);
        float r25 = ((Math.signum(r17) * 400.0f) * r20) / (r20 + 27.13f);
        double r26 = r25;
        float r27 = ((float) (((((double) r21) * 11.0d) + (((double) r22) * (-12.0d))) + r26)) / 11.0f;
        float r28 = ((float) (((double) (r21 + r22)) - (r26 * 2.0d))) / 9.0f;
        float r29 = r22 * 20.0f;
        float r30 = (((r21 * 20.0f) + r29) + (21.0f * r25)) / 20.0f;
        float r31 = (((r21 * 40.0f) + r29) + r25) / 20.0f;
        float r32 = (((float) Math.atan2(r28, r27)) * 180.0f) / 3.1415927f;
        if (r32 >= 0.0f) goto L7;
        r32 = r32 + 360.0f;
    L5:
        float r110 = r32;
        float r33 = (3.1415927f * r110) / 180.0f;
        float r34 = ((float) Math.pow((r31 * r24.getNbb()) / r24.getAw(), r24.getC() * r24.getZ())) * 100.0f;
        float r35 = r24.getFlRoot() * (((4.0f / r24.getC()) * ((float) Math.sqrt(r34 / 100.0f))) * (r24.getAw() + 4.0f));
        if (r110 >= 20.14d) goto L12;
        float r111 = 360.0f + r110;
    L13:
        float r36 = ((float) Math.pow(1.64d - Math.pow(0.29d, r24.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) r111) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * r24.getNc()) * r24.getNcb()) * ((float) Math.sqrt((r27 * r27) + (r28 * r28)))) / (r30 + 0.305f), 0.9d));
        float r112 = r36 * ((float) Math.sqrt(((double) r34) / 100.0d));
        float r113 = r112 * r24.getFlRoot();
        float r114 = ((float) Math.sqrt((r36 * r24.getC()) / (r24.getAw() + 4.0f))) * 50.0f;
        float r210 = (1.7f * r34) / ((0.007f * r34) + 1.0f);
        float r37 = ((float) Math.log((0.0228f * r113) + 1.0f)) * 43.85965f;
        double r38 = r33;
        return new CamColor(r110, r112, r34, r35, r113, r114, r210, r37 * ((float) Math.cos(r38)), r37 * ((float) Math.sin(r38)));
    L12:
        r111 = r110;
        goto L13
    L7:
        if (r32 < 360.0f) goto L5;
        r32 = r32 - 360.0f;
        goto L5
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, to = 100.0d) float r10, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r11, @FloatRange(from = 0.0d, to = 360.0d) float r12) {
        return fromJchInFrame(r10, r11, r12, ViewingConditions.DEFAULT);
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, to = 100.0d) float r13, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r14, @FloatRange(from = 0.0d, to = 360.0d) float r15, ViewingConditions r16) {
        double r10 = ((double) r13) / 100.0d;
        float r11 = (((4.0f / r16.getC()) * ((float) Math.sqrt(r10))) * (r16.getAw() + 4.0f)) * r16.getFlRoot();
        float r12 = r14 * r16.getFlRoot();
        float r17 = ((float) Math.sqrt(((r14 / ((float) Math.sqrt(r10))) * r16.getC()) / (r16.getAw() + 4.0f))) * 50.0f;
        float r18 = (1.7f * r13) / ((0.007f * r13) + 1.0f);
        float r19 = ((float) Math.log((((double) r12) * 0.0228d) + 1.0d)) * 43.85965f;
        double r20 = (3.1415927f * r15) / 180.0f;
        return new CamColor(r15, r14, r13, r11, r12, r17, r18, r19 * ((float) Math.cos(r20)), r19 * ((float) Math.sin(r20)));
    }

    static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float r10, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r11, @FloatRange(from = 0.0d, to = 100.0d) float r12) {
        return toColor(r10, r11, r12, ViewingConditions.DEFAULT);
    }

    @ColorInt
    static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float r10, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r11, @FloatRange(from = 0.0d, to = 100.0d) float r12, @NonNull ViewingConditions r13) {
        if (r11 < 1.0d) goto L32;
        if (Math.round(r12) <= 0.0d) goto L32;
        if (Math.round(r12) >= 100.0d) goto L32;
        if (r10 >= 0.0f) goto L12;
        float r14 = 0.0f;
    L13:
        CamColor r15 = null;
        boolean r16 = true;
        float r17 = 0.0f;
        float r18 = r11;
    L15:
        if (Math.abs(r17 - r11) < CHROMA_SEARCH_ENDPOINT) goto L26;
        CamColor r19 = findCamByJ(r14, r18, r12);
        if (r16 == false) goto L23;
        if (r19 != null) goto L20;
        r16 = false;
    L22:
        r18 = ((r11 - r17) / 2.0f) + r17;
        goto L15
    L20:
        return r19.viewed(r13);
    L23:
        if (r19 != null) goto L25;
        r11 = r18;
        goto L22
    L25:
        r17 = r18;
        r15 = r19;
        goto L22
    L26:
        if (r15 != null) goto L30;
        return CamUtils.intFromLStar(r12);
    L30:
        return r15.viewed(r13);
    L12:
        r14 = Math.min(360.0f, r10);
    L32:
        return CamUtils.intFromLStar(r12);
    }

    float distance(@NonNull CamColor r10) {
        float r11 = getJStar() - r10.getJStar();
        float r12 = getAStar() - r10.getAStar();
        float r13 = getBStar() - r10.getBStar();
        return (float) (Math.pow(Math.sqrt(((r11 * r11) + (r12 * r12)) + (r13 * r13)), 0.63d) * 1.41d);
    }

    @FloatRange(from = DoubleCompanionObject.NEGATIVE_INFINITY, fromInclusive = false, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    float getAStar() {
        return this.mAstar;
    }

    @FloatRange(from = DoubleCompanionObject.NEGATIVE_INFINITY, fromInclusive = false, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    float getBStar() {
        return this.mBstar;
    }

    @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    float getChroma() {
        return this.mChroma;
    }

    @FloatRange(from = 0.0d, to = 360.0d, toInclusive = false)
    float getHue() {
        return this.mHue;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    float getJ() {
        return this.mJ;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    float getJStar() {
        return this.mJstar;
    }

    @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    float getM() {
        return this.mM;
    }

    @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    float getQ() {
        return this.mQ;
    }

    @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    float getS() {
        return this.mS;
    }

    @ColorInt
    int viewed(@NonNull ViewingConditions r16) {
        if (getChroma() != 0.0d) goto L5;
    L8:
        float r10 = 0.0f;
    L9:
        float r11 = (float) Math.pow(((double) r10) / Math.pow(1.64d - Math.pow(0.29d, r16.getN()), 0.73d), 1.1111111111111112d);
        double r12 = (getHue() * 3.1415927f) / 180.0f;
        float r13 = ((float) (Math.cos(2.0d + r12) + 3.8d)) * 0.25f;
        float r14 = r16.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) r16.getC())) / ((double) r16.getZ())));
        float r15 = ((r13 * 3846.1538f) * r16.getNc()) * r16.getNcb();
        float r17 = r14 / r16.getNbb();
        float r18 = (float) Math.sin(r12);
        float r19 = (float) Math.cos(r12);
        float r20 = (((0.305f + r17) * 23.0f) * r11) / (((r15 * 23.0f) + ((11.0f * r11) * r19)) + ((r11 * 108.0f) * r18));
        float r21 = r19 * r20;
        float r22 = r20 * r18;
        float r23 = r17 * 460.0f;
        float r24 = (((451.0f * r21) + r23) + (288.0f * r22)) / 1403.0f;
        float r25 = ((r23 - (891.0f * r21)) - (261.0f * r22)) / 1403.0f;
        float r26 = ((r23 - (r21 * 220.0f)) - (r22 * 6300.0f)) / 1403.0f;
        float r27 = (Math.signum(r24) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r24)) * 27.13d) / (400.0d - ((double) Math.abs(r24)))), 2.380952380952381d));
        float r28 = (Math.signum(r25) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r25)) * 27.13d) / (400.0d - ((double) Math.abs(r25)))), 2.380952380952381d));
        float r29 = (Math.signum(r26) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r26)) * 27.13d) / (400.0d - ((double) Math.abs(r26)))), 2.380952380952381d));
        float r30 = r27 / r16.getRgbD()[0];
        float r31 = r28 / r16.getRgbD()[1];
        float r32 = r29 / r16.getRgbD()[2];
        float[][] r33 = CamUtils.CAM16RGB_TO_XYZ;
        return ColorUtils.XYZToColor(((r33[0][0] * r30) + (r33[0][1] * r31)) + (r33[0][2] * r32), ((r33[1][0] * r30) + (r33[1][1] * r31)) + (r33[1][2] * r32), ((r30 * r33[2][0]) + (r31 * r33[2][1])) + (r32 * r33[2][2]));
    L5:
        if (getJ() == 0.0d) goto L8;
        r10 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        goto L9
    }

    @ColorInt
    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }
}
