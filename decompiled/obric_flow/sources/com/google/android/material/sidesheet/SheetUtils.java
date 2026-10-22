package com.google.android.material.sidesheet;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class SheetUtils {
    private SheetUtils() {
    }

    public static boolean isSwipeMostlyHorizontal(float r5, float r10) {
        if (Math.abs(r5) <= Math.abs(r10)) goto L5;
        return true;
    L5:
        return false;
    }
}
