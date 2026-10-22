package com.obric.cae.wifi;

/* JADX INFO: loaded from: classes2.dex */
public class EmaCalculator {
    public EmaCalculator() {
    }

    public static int calculateEmaIntWithAlpha(int r8, int r10, float r11) {
        if (r11 >= 0.0f) goto L6;
        r11 = 0.0f;
    L6:
        if (r11 <= 1.0f) goto L9;
        r11 = 1.0f;
    L9:
        return Math.round(((1.0f - r11) * r10) + (r8 * r11));
    }

    public static int groupRssiBy3dB(int r8) {
        return Math.floorDiv(r8, 3) * 3;
    }
}
