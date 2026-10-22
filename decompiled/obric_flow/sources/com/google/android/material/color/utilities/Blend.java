package com.google.android.material.color.utilities;

import ai.j0;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Blend {
    private Blend() {
    }

    public static int cam16Ucs(int r32, int r33, double r34) {
        Cam16 r5 = Cam16.fromInt(r32);
        Cam16 r10 = Cam16.fromInt(r33);
        double r11 = r5.getJstar();
        double r16 = r5.getAstar();
        double r24 = r5.getBstar();
        double r12 = r10.getJstar();
        double r13 = r10.getAstar();
        double r18 = r10.getBstar();
        return Cam16.fromUcs(j0.a(r12, r11, r34, r11), j0.a(r13, r16, r34, r16), j0.a(r18, r24, r34, r24)).toInt();
    }

    public static int harmonize(int r12, int r13) {
        Hct r14 = Hct.fromInt(r12);
        Hct r15 = Hct.fromInt(r13);
        double r5 = Math.min(MathUtils.differenceDegrees(r14.getHue(), r15.getHue()) * 0.5d, 15.0d);
        double r10 = r14.getHue();
        return Hct.from(MathUtils.sanitizeDegreesDouble((MathUtils.rotationDirection(r14.getHue(), r15.getHue()) * r5) + r10), r14.getChroma(), r14.getTone()).toInt();
    }

    public static int hctHue(int r10, int r11, double r12) {
        Cam16 r13 = Cam16.fromInt(cam16Ucs(r10, r11, r12));
        Cam16 r14 = Cam16.fromInt(r10);
        return Hct.from(r13.getHue(), r14.getChroma(), ColorUtils.lstarFromArgb(r10)).toInt();
    }
}
