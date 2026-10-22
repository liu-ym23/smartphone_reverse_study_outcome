package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialColors {
    public static final float ALPHA_DISABLED = 0.38f;
    public static final float ALPHA_DISABLED_LOW = 0.12f;
    public static final float ALPHA_FULL = 1.0f;
    public static final float ALPHA_LOW = 0.32f;
    public static final float ALPHA_MEDIUM = 0.54f;
    private static final int CHROMA_NEUTRAL = 6;
    private static final int TONE_ACCENT_CONTAINER_DARK = 30;
    private static final int TONE_ACCENT_CONTAINER_LIGHT = 90;
    private static final int TONE_ACCENT_DARK = 80;
    private static final int TONE_ACCENT_LIGHT = 40;
    private static final int TONE_ON_ACCENT_CONTAINER_DARK = 90;
    private static final int TONE_ON_ACCENT_CONTAINER_LIGHT = 10;
    private static final int TONE_ON_ACCENT_DARK = 20;
    private static final int TONE_ON_ACCENT_LIGHT = 100;
    private static final int TONE_SURFACE_CONTAINER_DARK = 12;
    private static final int TONE_SURFACE_CONTAINER_HIGH_DARK = 17;
    private static final int TONE_SURFACE_CONTAINER_HIGH_LIGHT = 92;
    private static final int TONE_SURFACE_CONTAINER_LIGHT = 94;

    private MaterialColors() {
    }

    @ColorInt
    public static int compositeARGBWithAlpha(@ColorInt int r5, @IntRange(from = 0, to = 255) int r10) {
        return ColorUtils.setAlphaComponent(r5, (Color.alpha(r5) * r10) / 255);
    }

    @ColorInt
    public static int getColor(@NonNull View r5, @AttrRes int r10) {
        return resolveColor(r5.getContext(), MaterialAttributes.resolveTypedValueOrThrow(r5, r10));
    }

    @Nullable
    @ColorInt
    public static Integer getColorOrNull(@NonNull Context r5, @AttrRes int r10) {
        TypedValue r11 = MaterialAttributes.resolve(r5, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(resolveColor(r5, r11));
    }

    @ColorInt
    private static int getColorRole(@ColorInt int r5, @IntRange(from = 0, to = 100) int r10) {
        Hct r11 = Hct.fromInt(r5);
        r11.setTone(r10);
        return r11.toInt();
    }

    @NonNull
    public static ColorRoles getColorRoles(@NonNull Context r5, @ColorInt int r10) {
        return getColorRoles(r10, isLightTheme(r5));
    }

    @NonNull
    public static ColorStateList getColorStateList(@NonNull Context r5, @AttrRes int r10, @NonNull ColorStateList r11) {
        TypedValue r12 = MaterialAttributes.resolve(r5, r10);
        if (r12 == null) goto L5;
        ColorStateList r13 = resolveColorStateList(r5, r12);
    L6:
        if (r13 != null) goto L9;
        return r11;
    L9:
        return r13;
    L5:
        r13 = null;
        goto L6
    }

    @Nullable
    public static ColorStateList getColorStateListOrNull(@NonNull Context r5, @AttrRes int r10) {
        TypedValue r11 = MaterialAttributes.resolve(r5, r10);
        if (r11 != null) goto L5;
        return null;
    L5:
        int r12 = r11.resourceId;
        if (r12 != 0) goto L8;
        int r13 = r11.data;
        if (r13 != 0) goto L12;
        return null;
    L12:
        return ColorStateList.valueOf(r13);
    L8:
        return ContextCompat.getColorStateList(r5, r12);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerFromSeed(@NonNull Context r5, @ColorInt int r10) {
        if (isLightTheme(r5) == false) goto L5;
        int r11 = 94;
    L7:
        return getColorRole(r10, r11, 6);
    L5:
        r11 = 12;
        goto L7
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int getSurfaceContainerHighFromSeed(@NonNull Context r5, @ColorInt int r10) {
        if (isLightTheme(r5) == false) goto L5;
        int r11 = 92;
    L7:
        return getColorRole(r10, r11, 6);
    L5:
        r11 = 17;
        goto L7
    }

    @ColorInt
    public static int harmonize(@ColorInt int r5, @ColorInt int r10) {
        return Blend.harmonize(r5, r10);
    }

    @ColorInt
    public static int harmonizeWithPrimary(@NonNull Context r5, @ColorInt int r10) {
        return harmonize(r10, getColor(r5, R.attr.colorPrimary, MaterialColors.class.getCanonicalName()));
    }

    public static boolean isColorLight(@ColorInt int r5) {
        if (r5 != 0) goto L4;
    L6:
        return false;
    L4:
        if (ColorUtils.calculateLuminance(r5) <= 0.5d) goto L6;
        return true;
    }

    public static boolean isLightTheme(@NonNull Context r5) {
        return MaterialAttributes.resolveBoolean(r5, R.attr.isLightTheme, true);
    }

    @ColorInt
    public static int layer(@NonNull View r5, @AttrRes int r10, @AttrRes int r11) {
        return layer(r5, r10, r11, 1.0f);
    }

    private static int resolveColor(@NonNull Context r5, @NonNull TypedValue r10) {
        int r11 = r10.resourceId;
        if (r11 == 0) goto L7;
        return ContextCompat.getColor(r5, r11);
    L7:
        return r10.data;
    }

    private static ColorStateList resolveColorStateList(@NonNull Context r5, @NonNull TypedValue r10) {
        int r11 = r10.resourceId;
        if (r11 == 0) goto L7;
        return ContextCompat.getColorStateList(r5, r11);
    L7:
        return ColorStateList.valueOf(r10.data);
    }

    @NonNull
    public static ColorRoles getColorRoles(@ColorInt int r5, boolean r10) {
        if (r10 == false) goto L6;
        return new ColorRoles(getColorRole(r5, 40), getColorRole(r5, 100), getColorRole(r5, 90), getColorRole(r5, 10));
    L6:
        return new ColorRoles(getColorRole(r5, 80), getColorRole(r5, 20), getColorRole(r5, 30), getColorRole(r5, 90));
    }

    @ColorInt
    public static int layer(@NonNull View r5, @AttrRes int r10, @AttrRes int r11, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r12) {
        return layer(getColor(r5, r10), getColor(r5, r11), r12);
    }

    @ColorInt
    public static int getColor(Context r5, @AttrRes int r10, String r11) {
        return resolveColor(r5, MaterialAttributes.resolveTypedValueOrThrow(r5, r10, r11));
    }

    @ColorInt
    private static int getColorRole(@ColorInt int r5, @IntRange(from = 0, to = 100) int r10, int r11) {
        Hct r12 = Hct.fromInt(getColorRole(r5, r10));
        r12.setChroma(r11);
        return r12.toInt();
    }

    @ColorInt
    public static int layer(@ColorInt int r5, @ColorInt int r10, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r11) {
        return layer(r5, ColorUtils.setAlphaComponent(r10, Math.round(Color.alpha(r10) * r11)));
    }

    @ColorInt
    public static int getColor(@NonNull View r5, @AttrRes int r10, @ColorInt int r11) {
        return getColor(r5.getContext(), r10, r11);
    }

    @ColorInt
    public static int getColor(@NonNull Context r5, @AttrRes int r10, @ColorInt int r11) {
        Integer r12 = getColorOrNull(r5, r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        return r12.intValue();
    }

    @ColorInt
    public static int layer(@ColorInt int r5, @ColorInt int r10) {
        return ColorUtils.compositeColors(r10, r5);
    }
}
