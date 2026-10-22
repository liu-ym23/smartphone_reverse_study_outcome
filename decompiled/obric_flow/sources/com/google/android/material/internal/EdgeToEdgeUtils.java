package com.google.android.material.internal;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EdgeToEdgeUtils {
    private static final int EDGE_TO_EDGE_BAR_ALPHA = 128;

    private EdgeToEdgeUtils() {
    }

    public static void applyEdgeToEdge(@NonNull Window r5, boolean r10) {
        applyEdgeToEdge(r5, r10, null, null);
    }

    @TargetApi(21)
    private static int getNavigationBarColor(Context r5, boolean r10) {
        if (r10 == false) goto L6;
        return 0;
    L6:
        return MaterialColors.getColor(r5, R.attr.navigationBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    @TargetApi(21)
    private static int getStatusBarColor(Context r5, boolean r10) {
        if (r10 == false) goto L6;
        return 0;
    L6:
        return MaterialColors.getColor(r5, R.attr.statusBarColor, ViewCompat.MEASURED_STATE_MASK);
    }

    private static boolean isUsingLightSystemBar(int r5, boolean r10) {
        if (MaterialColors.isColorLight(r5) == true) goto L8;
        if (r5 != 0) goto L7;
        if (r10 == true) goto L8;
    L7:
        return false;
    L8:
        return true;
    }

    public static void setLightNavigationBar(@NonNull Window r5, boolean r10) {
        WindowCompat.getInsetsController(r5, r5.getDecorView()).setAppearanceLightNavigationBars(r10);
    }

    public static void setLightStatusBar(@NonNull Window r5, boolean r10) {
        WindowCompat.getInsetsController(r5, r5.getDecorView()).setAppearanceLightStatusBars(r10);
    }

    public static void applyEdgeToEdge(@NonNull Window r5, boolean r10, @Nullable @ColorInt Integer r11, @Nullable @ColorInt Integer r12) {
        boolean r13 = false;
        if (r11 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r12 != null) goto L11;
    L12:
        r13 = true;
    L13:
        if (r14 == true) goto L15;
        if (r13 == true) goto L15;
    L20:
        WindowCompat.setDecorFitsSystemWindows(r5, !r10);
        int r15 = getStatusBarColor(r5.getContext(), r10);
        int r16 = getNavigationBarColor(r5.getContext(), r10);
        r5.setStatusBarColor(r15);
        r5.setNavigationBarColor(r16);
        setLightStatusBar(r5, isUsingLightSystemBar(r15, MaterialColors.isColorLight(r11.intValue())));
        setLightNavigationBar(r5, isUsingLightSystemBar(r16, MaterialColors.isColorLight(r12.intValue())));
        return;
    L15:
        int r17 = MaterialColors.getColor(r5.getContext(), R.attr.colorBackground, ViewCompat.MEASURED_STATE_MASK);
        if (r14 == false) goto L18;
        r11 = Integer.valueOf(r17);
    L18:
        if (r13 == false) goto L20;
        r12 = Integer.valueOf(r17);
        goto L20
    L11:
        if (r12.intValue() != 0) goto L13;
    L5:
        if (r11.intValue() == 0) goto L8;
        r14 = false;
        goto L9
    }
}
