package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class e {
    public static void a(@NonNull Window r10, boolean r11, @Nullable @ColorInt Integer r12, @Nullable @ColorInt Integer r13) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        boolean r14 = false;
        if (r12 != null) goto L8;
    L11:
        boolean r15 = true;
    L12:
        if (r13 != null) goto L14;
    L15:
        r14 = true;
    L16:
        if (r15 == true) goto L18;
        if (r14 == true) goto L18;
    L23:
        WindowCompat.setDecorFitsSystemWindows(r10, !r11);
        int r16 = c(r10.getContext(), r11);
        int r17 = b(r10.getContext(), r11);
        r10.setStatusBarColor(r16);
        r10.setNavigationBarColor(r17);
        boolean r18 = d(r16, t5.a.f(r12.intValue()));
        boolean r19 = d(r17, t5.a.f(r13.intValue()));
        WindowInsetsControllerCompat r20 = WindowCompat.getInsetsController(r10, r10.getDecorView());
        if (r20 == null) goto L27;
        r20.setAppearanceLightStatusBars(r18);
        r20.setAppearanceLightNavigationBars(r19);
        return;
    L27:
        return;
    L18:
        int r21 = t5.a.b(r10.getContext(), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
        if (r15 == false) goto L21;
        r12 = Integer.valueOf(r21);
    L21:
        if (r14 == false) goto L23;
        r13 = Integer.valueOf(r21);
        goto L23
    L14:
        if (r13.intValue() != 0) goto L16;
    L8:
        if (r12.intValue() == 0) goto L11;
        r15 = false;
        goto L12
    }

    @TargetApi(21)
    private static int b(Context r10, boolean r11) {
        if (r11 == true) goto L5;
    L8:
        if (r11 == false) goto L12;
        return 0;
    L12:
        return t5.a.b(r10, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    L5:
        if (Build.VERSION.SDK_INT >= 27) goto L8;
        return ColorUtils.setAlphaComponent(t5.a.b(r10, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
    }

    @TargetApi(21)
    private static int c(Context r10, boolean r11) {
        if (r11 == true) goto L5;
    L8:
        if (r11 == false) goto L12;
        return 0;
    L12:
        return t5.a.b(r10, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        return ColorUtils.setAlphaComponent(t5.a.b(r10, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK), 128);
    }

    private static boolean d(int r10, boolean r11) {
        if (t5.a.f(r10) == true) goto L8;
        if (r10 != 0) goto L7;
        if (r11 == true) goto L8;
    L7:
        return false;
    L8:
        return true;
    }
}
