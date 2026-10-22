package androidx.core.content.res;

import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.DoubleCompanionObject;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CamColor {
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

    public CamColor(float r5, float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17) {
        this.mHue = r5;
        this.mChroma = r10;
        this.mJ = r11;
        this.mQ = r12;
        this.mM = r13;
        this.mS = r14;
        this.mJstar = r15;
        this.mAstar = r16;
        this.mBstar = r17;
    }

    @Nullable
    private static CamColor findCamByJ(@FloatRange(from = 0.0d, to = 360.0d) float r12, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r13, @FloatRange(from = 0.0d, to = 100.0d) float r14) {
        float r5 = 100.0f;
        float r10 = 1000.0f;
        float r11 = 0.0f;
        CamColor r15 = null;
        float r16 = 1000.0f;
    L4:
        if (Math.abs(r11 - r5) <= LIGHTNESS_SEARCH_ENDPOINT) goto L19;
        float r17 = androidx.constraintlayout.motion.widget.a.a(r5, r11, 2.0f, r11);
        int r18 = fromJch(r17, r13, r12).viewedInSrgb();
        float r19 = CamUtils.lStarFromInt(r18);
        float r20 = Math.abs(r14 - r19);
        if (r20 >= 0.2f) goto L11;
        CamColor r21 = fromColor(r18);
        float r110 = r21.distance(fromJch(r21.getJ(), r21.getChroma(), r12));
        if (r110 > 1.0f) goto L11;
        r15 = r21;
        r10 = r20;
        r16 = r110;
    L11:
        if (r10 != 0.0f) goto L16;
        if (r16 == 0.0f) goto L19;
    L16:
        if (r19 < r14) goto L17;
        r5 = r17;
        goto L4
    L17:
        r11 = r17;
    L19:
        return r15;
    }

    @NonNull
    public static CamColor fromColor(@ColorInt int r14) {
        float[] r5 = new float[7];
        float[] r10 = new float[3];
        fromColorInViewingConditions(r14, ViewingConditions.DEFAULT, r5, r10);
        return new CamColor(r10[0], r10[1], r5[0], r5[1], r5[2], r5[3], r5[4], r5[5], r5[6]);
    }

    public static void fromColorInViewingConditions(@ColorInt int r18, @NonNull ViewingConditions r19, @Nullable @Size(7) float[] r20, @NonNull @Size(3) float[] r21) {
        CamUtils.xyzFromInt(r18, r21);
        float[][] r5 = CamUtils.XYZ_TO_CAM16RGB;
        float r10 = r21[0];
        float[] r11 = r5[0];
        float r12 = r11[0] * r10;
        float r13 = r21[1];
        float r14 = (r11[1] * r13) + r12;
        float r15 = r21[2];
        float r16 = (r11[2] * r15) + r14;
        float[] r17 = r5[1];
        float r22 = (r17[2] * r15) + ((r17[1] * r13) + (r17[0] * r10));
        float[] r23 = r5[2];
        float r24 = (r15 * r23[2]) + ((r13 * r23[1]) + (r10 * r23[0]));
        float r25 = r19.getRgbD()[0] * r16;
        float r26 = r19.getRgbD()[1] * r22;
        float r27 = r19.getRgbD()[2] * r24;
        float r28 = (float) Math.pow(((double) (Math.abs(r25) * r19.getFl())) / 100.0d, 0.42d);
        float r29 = (float) Math.pow(((double) (Math.abs(r26) * r19.getFl())) / 100.0d, 0.42d);
        float r110 = (float) Math.pow(((double) (Math.abs(r27) * r19.getFl())) / 100.0d, 0.42d);
        float r30 = ((Math.signum(r25) * 400.0f) * r28) / (r28 + 27.13f);
        float r31 = ((Math.signum(r26) * 400.0f) * r29) / (r29 + 27.13f);
        float r32 = ((Math.signum(r27) * 400.0f) * r110) / (r110 + 27.13f);
        double r33 = r32;
        float r111 = ((float) (((((double) r31) * (-12.0d)) + (((double) r30) * 11.0d)) + r33)) / 11.0f;
        float r34 = ((float) (((double) (r30 + r31)) - (r33 * 2.0d))) / 9.0f;
        float r35 = r31 * 20.0f;
        float r112 = ((21.0f * r32) + ((r30 * 20.0f) + r35)) / 20.0f;
        float r36 = (((r30 * 40.0f) + r35) + r32) / 20.0f;
        float r37 = (((float) Math.atan2(r34, r111)) * 180.0f) / 3.1415927f;
        if (r37 >= 0.0f) goto L6;
        r37 = r37 + 360.0f;
    L8:
        float r38 = (3.1415927f * r37) / 180.0f;
        float r39 = ((float) Math.pow((r36 * r19.getNbb()) / r19.getAw(), r19.getC() * r19.getZ())) * 100.0f;
        float r40 = ((r19.getAw() + 4.0f) * ((4.0f / r19.getC()) * ((float) Math.sqrt(r39 / 100.0f)))) * r19.getFlRoot();
        if (r37 >= 20.14d) goto L11;
        float r113 = 360.0f + r37;
    L12:
        float r41 = ((float) Math.pow(1.64d - Math.pow(0.29d, r19.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) r113) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * r19.getNc()) * r19.getNcb()) * ((float) Math.sqrt((r34 * r34) + (r111 * r111)))) / (r112 + 0.305f), 0.9d));
        float r42 = ((float) Math.sqrt(((double) r39) / 100.0d)) * r41;
        float r43 = r19.getFlRoot() * r42;
        float r44 = ((float) Math.sqrt((r41 * r19.getC()) / (r19.getAw() + 4.0f))) * 50.0f;
        float r45 = (1.7f * r39) / ((0.007f * r39) + 1.0f);
        float r114 = ((float) Math.log((0.0228f * r43) + 1.0f)) * 43.85965f;
        double r115 = r38;
        float r46 = ((float) Math.cos(r115)) * r114;
        float r116 = r114 * ((float) Math.sin(r115));
        r21[0] = r37;
        r21[1] = r42;
        if (r20 == null) goto L16;
        r20[0] = r39;
        r20[1] = r40;
        r20[2] = r43;
        r20[3] = r44;
        r20[4] = r45;
        r20[5] = r46;
        r20[6] = r116;
        return;
    L16:
        return;
    L11:
        r113 = r37;
        goto L12
    L6:
        if (r37 < 360.0f) goto L8;
        r37 = r37 - 360.0f;
        goto L8
    }

    @NonNull
    private static CamColor fromJch(@FloatRange(from = 0.0d, to = 100.0d) float r5, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r10, @FloatRange(from = 0.0d, to = 360.0d) float r11) {
        return fromJchInFrame(r5, r10, r11, ViewingConditions.DEFAULT);
    }

    @NonNull
    private static CamColor fromJchInFrame(@FloatRange(from = 0.0d, to = 100.0d) float r13, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r14, @FloatRange(from = 0.0d, to = 360.0d) float r15, ViewingConditions r16) {
        double r5 = ((double) r13) / 100.0d;
        float r10 = ((r16.getAw() + 4.0f) * ((4.0f / r16.getC()) * ((float) Math.sqrt(r5)))) * r16.getFlRoot();
        float r11 = r14 * r16.getFlRoot();
        float r12 = ((float) Math.sqrt(((r14 / ((float) Math.sqrt(r5))) * r16.getC()) / (r16.getAw() + 4.0f))) * 50.0f;
        float r17 = (1.7f * r13) / ((0.007f * r13) + 1.0f);
        float r18 = ((float) Math.log((((double) r11) * 0.0228d) + 1.0d)) * 43.85965f;
        double r19 = (3.1415927f * r15) / 180.0f;
        return new CamColor(r15, r14, r13, r10, r11, r12, r17, r18 * ((float) Math.cos(r19)), r18 * ((float) Math.sin(r19)));
    }

    public static void getM3HCTfromColor(@ColorInt int r5, @NonNull @Size(3) float[] r10) {
        fromColorInViewingConditions(r5, ViewingConditions.DEFAULT, null, r10);
        r10[2] = CamUtils.lStarFromInt(r5);
    }

    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float r5, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r10, @FloatRange(from = 0.0d, to = 100.0d) float r11) {
        return toColor(r5, r10, r11, ViewingConditions.DEFAULT);
    }

    public float distance(@NonNull CamColor r5) {
        float r10 = getJStar() - r5.getJStar();
        float r11 = getAStar() - r5.getAStar();
        float r12 = getBStar() - r5.getBStar();
        return (float) (Math.pow(Math.sqrt((r12 * r12) + ((r11 * r11) + (r10 * r10))), 0.63d) * 1.41d);
    }

    @FloatRange(from = DoubleCompanionObject.NEGATIVE_INFINITY, fromInclusive = false, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getAStar() {
        return this.mAstar;
    }

    @FloatRange(from = DoubleCompanionObject.NEGATIVE_INFINITY, fromInclusive = false, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getBStar() {
        return this.mBstar;
    }

    @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getChroma() {
        return this.mChroma;
    }

    @FloatRange(from = 0.0d, to = 360.0d, toInclusive = false)
    public float getHue() {
        return this.mHue;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJ() {
        return this.mJ;
    }

    @FloatRange(from = 0.0d, to = 100.0d)
    public float getJStar() {
        return this.mJstar;
    }

    @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getM() {
        return this.mM;
    }

    @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getQ() {
        return this.mQ;
    }

    @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false)
    public float getS() {
        return this.mS;
    }

    @ColorInt
    public int viewed(@NonNull ViewingConditions r16) {
        if (getChroma() != 0.0d) goto L5;
    L8:
        float r5 = 0.0f;
    L9:
        float r10 = (float) Math.pow(((double) r5) / Math.pow(1.64d - Math.pow(0.29d, r16.getN()), 0.73d), 1.1111111111111112d);
        double r11 = (getHue() * 3.1415927f) / 180.0f;
        float r12 = ((float) (Math.cos(2.0d + r11) + 3.8d)) * 0.25f;
        float r13 = r16.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) r16.getC())) / ((double) r16.getZ())));
        float r14 = ((r12 * 3846.1538f) * r16.getNc()) * r16.getNcb();
        float r15 = r13 / r16.getNbb();
        float r17 = (float) Math.sin(r11);
        float r18 = (float) Math.cos(r11);
        float r19 = (11.0f * r10) * r18;
        float r20 = (((0.305f + r15) * 23.0f) * r10) / (((r10 * 108.0f) * r17) + (r19 + (r14 * 23.0f)));
        float r21 = r18 * r20;
        float r22 = r20 * r17;
        float r23 = r15 * 460.0f;
        float r24 = ((288.0f * r22) + ((451.0f * r21) + r23)) / 1403.0f;
        float r25 = ((r23 - (891.0f * r21)) - (261.0f * r22)) / 1403.0f;
        float r26 = ((r23 - (r21 * 220.0f)) - (r22 * 6300.0f)) / 1403.0f;
        float r27 = (float) Math.max(0.0d, (((double) Math.abs(r24)) * 27.13d) / (400.0d - ((double) Math.abs(r24))));
        float r28 = ((100.0f / r16.getFl()) * Math.signum(r24)) * ((float) Math.pow(r27, 2.380952380952381d));
        float r29 = (float) Math.max(0.0d, (((double) Math.abs(r25)) * 27.13d) / (400.0d - ((double) Math.abs(r25))));
        float r30 = ((100.0f / r16.getFl()) * Math.signum(r25)) * ((float) Math.pow(r29, 2.380952380952381d));
        float r31 = (float) Math.max(0.0d, (((double) Math.abs(r26)) * 27.13d) / (400.0d - ((double) Math.abs(r26))));
        float r32 = ((100.0f / r16.getFl()) * Math.signum(r26)) * ((float) Math.pow(r31, 2.380952380952381d));
        float r33 = r28 / r16.getRgbD()[0];
        float r34 = r30 / r16.getRgbD()[1];
        float r35 = r32 / r16.getRgbD()[2];
        float[][] r36 = CamUtils.CAM16RGB_TO_XYZ;
        float[] r37 = r36[0];
        float r38 = (r37[2] * r35) + ((r37[1] * r34) + (r37[0] * r33));
        float[] r39 = r36[1];
        float r40 = (r39[2] * r35) + ((r39[1] * r34) + (r39[0] * r33));
        float[] r41 = r36[2];
        return ColorUtils.XYZToColor(r38, r40, (r35 * r41[2]) + ((r34 * r41[1]) + (r33 * r41[0])));
    L5:
        if (getJ() == 0.0d) goto L8;
        r5 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        goto L9
    }

    @ColorInt
    public int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    @ColorInt
    public static int toColor(@FloatRange(from = 0.0d, to = 360.0d) float r10, @FloatRange(from = 0.0d, to = DoubleCompanionObject.POSITIVE_INFINITY, toInclusive = false) float r11, @FloatRange(from = 0.0d, to = 100.0d) float r12, @NonNull ViewingConditions r13) {
        if (r11 < 1.0d) goto L32;
        if (Math.round(r12) <= 0.0d) goto L32;
        if (Math.round(r12) >= 100.0d) goto L32;
        if (r10 >= 0.0f) goto L12;
        float r14 = 0.0f;
    L13:
        CamColor r5 = null;
        boolean r15 = true;
        float r16 = 0.0f;
        float r17 = r11;
    L15:
        if (Math.abs(r16 - r11) < CHROMA_SEARCH_ENDPOINT) goto L26;
        CamColor r18 = findCamByJ(r14, r17, r12);
        if (r15 == true) goto L18;
        if (r18 != null) goto L24;
        r11 = r17;
    L25:
        r17 = androidx.constraintlayout.motion.widget.a.a(r11, r16, 2.0f, r16);
        goto L15
    L24:
        r16 = r17;
        r5 = r18;
        goto L25
    L18:
        if (r18 != null) goto L20;
        r17 = androidx.constraintlayout.motion.widget.a.a(r11, r16, 2.0f, r16);
        r15 = false;
        goto L15
    L20:
        return r18.viewed(r13);
    L26:
        if (r5 != null) goto L30;
        return CamUtils.intFromLStar(r12);
    L30:
        return r5.viewed(r13);
    L12:
        r14 = Math.min(360.0f, r10);
    L32:
        return CamUtils.intFromLStar(r12);
    }
}
