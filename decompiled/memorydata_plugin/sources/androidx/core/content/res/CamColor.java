package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: classes.dex */
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

    CamColor(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9) {
        this.mHue = r1;
        this.mChroma = r2;
        this.mJ = r3;
        this.mQ = r4;
        this.mM = r5;
        this.mS = r6;
        this.mJstar = r7;
        this.mAstar = r8;
        this.mBstar = r9;
    }

    private static CamColor findCamByJ(float r12, float r13, float r14) {
        float r0 = 1000.0f;
        float r5 = 0.0f;
        CamColor r4 = null;
        float r3 = 100.0f;
        float r2 = 1000.0f;
    L4:
        if (Math.abs(r5 - r3) <= LIGHTNESS_SEARCH_ENDPOINT) goto L19;
        float r6 = ((r3 - r5) / 2.0f) + r5;
        int r7 = fromJch(r6, r13, r12).viewedInSrgb();
        float r8 = CamUtils.lStarFromInt(r7);
        float r9 = Math.abs(r14 - r8);
        if (r9 >= 0.2f) goto L11;
        CamColor r10 = fromColor(r7);
        float r11 = r10.distance(fromJch(r10.getJ(), r10.getChroma(), r12));
        if (r11 > 1.0f) goto L11;
        r4 = r10;
        r0 = r9;
        r2 = r11;
    L11:
        if (r0 != 0.0f) goto L16;
        if (r2 == 0.0f) goto L19;
    L16:
        if (r8 < r14) goto L17;
        r3 = r6;
        goto L4
    L17:
        r5 = r6;
    L19:
        return r4;
    }

    static CamColor fromColor(int r14) {
        float[] r0 = new float[7];
        float[] r2 = new float[3];
        fromColorInViewingConditions(r14, ViewingConditions.DEFAULT, r0, r2);
        return new CamColor(r2[0], r2[1], r0[0], r0[1], r0[2], r0[3], r0[4], r0[5], r0[6]);
    }

    static void fromColorInViewingConditions(int r19, ViewingConditions r20, float[] r21, float[] r22) {
        CamUtils.xyzFromInt(r19, r22);
        float[][] r0 = CamUtils.XYZ_TO_CAM16RGB;
        float r3 = ((r22[0] * r0[0][0]) + (r22[1] * r0[0][1])) + (r22[2] * r0[0][2]);
        float r6 = ((r22[0] * r0[1][0]) + (r22[1] * r0[1][1])) + (r22[2] * r0[1][2]);
        float r7 = ((r22[0] * r0[2][0]) + (r22[1] * r0[2][1])) + (r22[2] * r0[2][2]);
        float r1 = r20.getRgbD()[0] * r3;
        float r4 = r20.getRgbD()[1] * r6;
        float r8 = r20.getRgbD()[2] * r7;
        float r9 = (float) Math.pow(((double) (r20.getFl() * Math.abs(r1))) / 100.0d, 0.42d);
        float r10 = (float) Math.pow(((double) (r20.getFl() * Math.abs(r4))) / 100.0d, 0.42d);
        float r11 = (float) Math.pow(((double) (r20.getFl() * Math.abs(r8))) / 100.0d, 0.42d);
        float r2 = ((Math.signum(r1) * 400.0f) * r9) / (r9 + 27.13f);
        float r5 = ((Math.signum(r4) * 400.0f) * r10) / (r10 + 27.13f);
        float r12 = ((Math.signum(r8) * 400.0f) * r11) / (r11 + 27.13f);
        double r13 = r12;
        float r14 = ((float) (((((double) r2) * 11.0d) + (((double) r5) * (-12.0d))) + r13)) / 11.0f;
        float r15 = ((float) (((double) (r2 + r5)) - (r13 * 2.0d))) / 9.0f;
        float r16 = r5 * 20.0f;
        float r17 = (((r2 * 20.0f) + r16) + (21.0f * r12)) / 20.0f;
        float r18 = (((r2 * 40.0f) + r16) + r12) / 20.0f;
        float r23 = (((float) Math.atan2(r15, r14)) * 180.0f) / 3.1415927f;
        if (r23 >= 0.0f) goto L6;
        r23 = r23 + 360.0f;
    L8:
        float r24 = (3.1415927f * r23) / 180.0f;
        float r25 = ((float) Math.pow((r18 * r20.getNbb()) / r20.getAw(), r20.getC() * r20.getZ())) * 100.0f;
        float r26 = (((4.0f / r20.getC()) * ((float) Math.sqrt(r25 / 100.0f))) * (r20.getAw() + 4.0f)) * r20.getFlRoot();
        if (r23 >= 20.14d) goto L11;
        float r110 = 360.0f + r23;
    L12:
        float r27 = ((float) Math.pow(1.64d - Math.pow(0.29d, r20.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) r110) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * r20.getNc()) * r20.getNcb()) * ((float) Math.sqrt((r14 * r14) + (r15 * r15)))) / (r17 + 0.305f), 0.9d));
        float r28 = ((float) Math.sqrt(((double) r25) / 100.0d)) * r27;
        float r29 = r20.getFlRoot() * r28;
        float r30 = ((float) Math.sqrt((r27 * r20.getC()) / (r20.getAw() + 4.0f))) * 50.0f;
        float r31 = (1.7f * r25) / ((0.007f * r25) + 1.0f);
        float r111 = ((float) Math.log((0.0228f * r29) + 1.0f)) * 43.85965f;
        double r112 = r24;
        float r113 = ((float) Math.cos(r112)) * r111;
        float r114 = r111 * ((float) Math.sin(r112));
        r22[0] = r23;
        r22[1] = r28;
        if (r21 == null) goto L16;
        r21[0] = r25;
        r21[1] = r26;
        r21[2] = r29;
        r21[3] = r30;
        r21[4] = r31;
        r21[5] = r113;
        r21[6] = r114;
        return;
    L16:
        return;
    L11:
        r110 = r23;
        goto L12
    L6:
        if (r23 < 360.0f) goto L8;
        r23 = r23 - 360.0f;
        goto L8
    }

    private static CamColor fromJch(float r1, float r2, float r3) {
        return fromJchInFrame(r1, r2, r3, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float r13, float r14, float r15, ViewingConditions r16) {
        double r4 = ((double) r13) / 100.0d;
        float r6 = (((4.0f / r16.getC()) * ((float) Math.sqrt(r4))) * (r16.getAw() + 4.0f)) * r16.getFlRoot();
        float r7 = r14 * r16.getFlRoot();
        float r8 = ((float) Math.sqrt(((r14 / ((float) Math.sqrt(r4))) * r16.getC()) / (r16.getAw() + 4.0f))) * 50.0f;
        float r9 = (1.7f * r13) / ((0.007f * r13) + 1.0f);
        float r1 = ((float) Math.log((((double) r7) * 0.0228d) + 1.0d)) * 43.85965f;
        double r5 = (3.1415927f * r15) / 180.0f;
        return new CamColor(r15, r14, r13, r6, r7, r8, r9, r1 * ((float) Math.cos(r5)), r1 * ((float) Math.sin(r5)));
    }

    public static void getM3HCTfromColor(int r2, float[] r3) {
        fromColorInViewingConditions(r2, ViewingConditions.DEFAULT, null, r3);
        r3[2] = CamUtils.lStarFromInt(r2);
    }

    public static int toColor(float r1, float r2, float r3) {
        return toColor(r1, r2, r3, ViewingConditions.DEFAULT);
    }

    static int toColor(float r6, float r7, float r8, ViewingConditions r9) {
        if (r7 < 1.0d) goto L32;
        if (Math.round(r8) <= 0.0d) goto L32;
        if (Math.round(r8) >= 100.0d) goto L32;
        if (r6 >= 0.0f) goto L12;
        float r10 = 0.0f;
    L13:
        CamColor r3 = null;
        boolean r2 = true;
        float r1 = 0.0f;
        float r0 = r7;
    L15:
        if (Math.abs(r1 - r7) < 0.4f) goto L26;
        CamColor r4 = findCamByJ(r10, r0, r8);
        if (r2 == false) goto L23;
        if (r4 != null) goto L20;
        r2 = false;
    L22:
        r0 = ((r7 - r1) / 2.0f) + r1;
        goto L15
    L20:
        return r4.viewed(r9);
    L23:
        if (r4 != null) goto L25;
        r7 = r0;
        goto L22
    L25:
        r1 = r0;
        r3 = r4;
        goto L22
    L26:
        if (r3 != null) goto L30;
        return CamUtils.intFromLStar(r8);
    L30:
        return r3.viewed(r9);
    L12:
        r10 = Math.min(360.0f, r6);
    L32:
        return CamUtils.intFromLStar(r8);
    }

    float distance(CamColor r4) {
        float r0 = getJStar() - r4.getJStar();
        float r1 = getAStar() - r4.getAStar();
        float r3 = getBStar() - r4.getBStar();
        return (float) (Math.pow(Math.sqrt(((r0 * r0) + (r1 * r1)) + (r3 * r3)), 0.63d) * 1.41d);
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    float getChroma() {
        return this.mChroma;
    }

    float getHue() {
        return this.mHue;
    }

    float getJ() {
        return this.mJ;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getM() {
        return this.mM;
    }

    float getQ() {
        return this.mQ;
    }

    float getS() {
        return this.mS;
    }

    int viewed(ViewingConditions r16) {
        if (getChroma() != 0.0d) goto L5;
    L8:
        float r0 = 0.0f;
    L9:
        float r1 = (float) Math.pow(((double) r0) / Math.pow(1.64d - Math.pow(0.29d, r16.getN()), 0.73d), 1.1111111111111112d);
        double r7 = (getHue() * 3.1415927f) / 180.0f;
        float r2 = ((float) (Math.cos(2.0d + r7) + 3.8d)) * 0.25f;
        float r6 = r16.getAw() * ((float) Math.pow(((double) getJ()) / 100.0d, (1.0d / ((double) r16.getC())) / ((double) r16.getZ())));
        float r3 = ((r2 * 3846.1538f) * r16.getNc()) * r16.getNcb();
        float r8 = r6 / r16.getNbb();
        float r4 = (float) Math.sin(r7);
        float r5 = (float) Math.cos(r7);
        float r9 = (((0.305f + r8) * 23.0f) * r1) / (((r3 * 23.0f) + ((11.0f * r1) * r5)) + ((r1 * 108.0f) * r4));
        float r10 = r5 * r9;
        float r11 = r9 * r4;
        float r12 = r8 * 460.0f;
        float r13 = (((451.0f * r10) + r12) + (288.0f * r11)) / 1403.0f;
        float r14 = ((r12 - (891.0f * r10)) - (261.0f * r11)) / 1403.0f;
        float r15 = ((r12 - (r10 * 220.0f)) - (r11 * 6300.0f)) / 1403.0f;
        float r17 = (Math.signum(r13) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r13)) * 27.13d) / (400.0d - ((double) Math.abs(r13)))), 2.380952380952381d));
        float r18 = (Math.signum(r14) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r14)) * 27.13d) / (400.0d - ((double) Math.abs(r14)))), 2.380952380952381d));
        float r19 = (Math.signum(r15) * (100.0f / r16.getFl())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r15)) * 27.13d) / (400.0d - ((double) Math.abs(r15)))), 2.380952380952381d));
        float r20 = r17 / r16.getRgbD()[0];
        float r21 = r18 / r16.getRgbD()[1];
        float r22 = r19 / r16.getRgbD()[2];
        float[][] r23 = CamUtils.CAM16RGB_TO_XYZ;
        return ColorUtils.XYZToColor(((r23[0][0] * r20) + (r23[0][1] * r21)) + (r23[0][2] * r22), ((r23[1][0] * r20) + (r23[1][1] * r21)) + (r23[1][2] * r22), ((r20 * r23[2][0]) + (r21 * r23[2][1])) + (r22 * r23[2][2]));
    L5:
        if (getJ() == 0.0d) goto L8;
        r0 = getChroma() / ((float) Math.sqrt(((double) getJ()) / 100.0d));
        goto L9
    }

    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }
}
