package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DislikeAnalyzer {
    private DislikeAnalyzer() {
        throw new UnsupportedOperationException();
    }

    public static Hct fixIfDisliked(Hct r10) {
        if (isDisliked(r10) == true) goto L5;
        return r10;
    L5:
        return Hct.from(r10.getHue(), r10.getChroma(), 70.0d);
    }

    public static boolean isDisliked(Hct r10) {
        if (Math.round(r10.getHue()) >= 90.0d) goto L5;
    L7:
        boolean r5 = false;
    L9:
        if (Math.round(r10.getChroma()) <= 16.0d) goto L11;
        boolean r11 = true;
    L13:
        if (Math.round(r10.getTone()) >= 65.0d) goto L15;
        boolean r12 = true;
    L16:
        if (r5 == false) goto L21;
        if (r11 == false) goto L22;
        if (r12 == true) goto L20;
        return false;
    L20:
        return true;
    L22:
        return false;
    L21:
        return false;
    L15:
        r12 = false;
        goto L16
    L11:
        r11 = false;
        goto L13
    L5:
        if (Math.round(r10.getHue()) > 111.0d) goto L7;
        r5 = true;
        goto L9
    }
}
