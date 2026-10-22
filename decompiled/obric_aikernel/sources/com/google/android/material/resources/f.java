package com.google.android.material.resources;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class f {
    @Nullable
    public static Typeface a(@NonNull Context r10, @NonNull Typeface r11) {
        return b(r10.getResources().getConfiguration(), r11);
    }

    @Nullable
    public static Typeface b(@NonNull Configuration r10, @NonNull Typeface r11) {
        if (Build.VERSION.SDK_INT < 31) goto L9;
        int r12 = r10.fontWeightAdjustment;
        if (r12 == Integer.MAX_VALUE) goto L11;
        if (r12 != 0) goto L8;
        return null;
    L8:
        return Typeface.create(r11, MathUtils.clamp(r11.getWeight() + r10.fontWeightAdjustment, 1, 1000), r11.isItalic());
    L11:
        return null;
    L9:
        return null;
    }
}
