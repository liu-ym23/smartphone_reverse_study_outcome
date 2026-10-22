package com.google.android.material.theme.overlay;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialThemeOverlay {
    private static final int[] ANDROID_THEME_OVERLAY_ATTRS = null;
    private static final int[] MATERIAL_THEME_OVERLAY_ATTR = null;

    static {
        ANDROID_THEME_OVERLAY_ATTRS = new int[]{R.attr.theme, com.google.android.material.R.attr.theme};
        MATERIAL_THEME_OVERLAY_ATTR = new int[]{com.google.android.material.R.attr.materialThemeOverlay};
    }

    private MaterialThemeOverlay() {
    }

    @StyleRes
    private static int obtainAndroidThemeOverlayId(@NonNull Context r5, AttributeSet r10) {
        TypedArray r11 = r5.obtainStyledAttributes(r10, ANDROID_THEME_OVERLAY_ATTRS);
        int r12 = r11.getResourceId(0, 0);
        int r13 = r11.getResourceId(1, 0);
        r11.recycle();
        if (r12 == 0) goto L6;
        return r12;
    L6:
        return r13;
    }

    @StyleRes
    private static int obtainMaterialThemeOverlayId(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        TypedArray r13 = r5.obtainStyledAttributes(r10, MATERIAL_THEME_OVERLAY_ATTR, r11, r12);
        int r14 = r13.getResourceId(0, 0);
        r13.recycle();
        return r14;
    }

    @NonNull
    public static Context wrap(@NonNull Context r5, @Nullable AttributeSet r10, @AttrRes int r11, @StyleRes int r12) {
        int r13 = obtainMaterialThemeOverlayId(r5, r10, r11, r12);
        if ((r5 instanceof ContextThemeWrapper) == true) goto L5;
    L7:
        boolean r14 = false;
    L8:
        if (r13 == 0) goto L15;
        if (r14 == true) goto L15;
        ContextThemeWrapper r15 = new ContextThemeWrapper(r5, r13);
        int r16 = obtainAndroidThemeOverlayId(r5, r10);
        if (r16 == 0) goto L14;
        r15.getTheme().applyStyle(r16, true);
    L14:
        return r15;
    L15:
        return r5;
    L5:
        if (((ContextThemeWrapper) r5).getThemeResId() != r13) goto L7;
        r14 = true;
        goto L8
    }
}
