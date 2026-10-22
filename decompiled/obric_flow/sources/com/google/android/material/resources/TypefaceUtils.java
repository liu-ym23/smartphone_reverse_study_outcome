package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceUtils {
    private TypefaceUtils() {
    }

    @Nullable
    public static Typeface maybeCopyWithFontWeightAdjustment(@NonNull Context r5, @NonNull Typeface r10) {
        return maybeCopyWithFontWeightAdjustment(r5.getResources().getConfiguration(), r10);
    }

    @Nullable
    public static Typeface maybeCopyWithFontWeightAdjustment(@NonNull Configuration r5, @NonNull Typeface r10) {
        int r11 = r5.fontWeightAdjustment;
        if (r11 == Integer.MAX_VALUE) goto L8;
        if (r11 == 0) goto L10;
        if (r10 != null) goto L7;
        return null;
    L7:
        return Typeface.create(r10, MathUtils.clamp(r10.getWeight() + r5.fontWeightAdjustment, 1, 1000), r10.isItalic());
    L10:
        return null;
    L8:
        return null;
    }
}
