package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: loaded from: classes2.dex */
public class ElevationOverlayProvider {
    private static final float FORMULA_MULTIPLIER = 4.5f;
    private static final float FORMULA_OFFSET = 2.0f;
    private static final int OVERLAY_ACCENT_COLOR_ALPHA = 0;
    private final int colorSurface;
    private final float displayDensity;
    private final int elevationOverlayAccentColor;
    private final int elevationOverlayColor;
    private final boolean elevationOverlayEnabled;

    static {
        OVERLAY_ACCENT_COLOR_ALPHA = (int) Math.round(5.1000000000000005d);
    }

    public ElevationOverlayProvider(@NonNull Context r10) {
        this(MaterialAttributes.resolveBoolean(r10, R.attr.elevationOverlayEnabled, false), MaterialColors.getColor(r10, R.attr.elevationOverlayColor, 0), MaterialColors.getColor(r10, R.attr.elevationOverlayAccentColor, 0), MaterialColors.getColor(r10, R.attr.colorSurface, 0), r10.getResources().getDisplayMetrics().density);
    }

    private boolean isThemeSurfaceColor(@ColorInt int r5) {
        if (ColorUtils.setAlphaComponent(r5, 255) != this.colorSurface) goto L5;
        return true;
    L5:
        return false;
    }

    public int calculateOverlayAlpha(float r5) {
        return Math.round(calculateOverlayAlphaFraction(r5) * 255.0f);
    }

    public float calculateOverlayAlphaFraction(float r5) {
        float r10 = this.displayDensity;
        if (r10 > 0.0f) goto L5;
    L9:
        return 0.0f;
    L5:
        if (r5 <= 0.0f) goto L9;
        return Math.min(((((float) Math.log1p(r5 / r10)) * FORMULA_MULTIPLIER) + FORMULA_OFFSET) / 100.0f, 1.0f);
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int r5, float r10, @NonNull View r11) {
        return compositeOverlay(r5, getParentAbsoluteElevation(r11) + r10);
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int r5, float r10, @NonNull View r11) {
        return compositeOverlayIfNeeded(r5, getParentAbsoluteElevation(r11) + r10);
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float r5, @NonNull View r10) {
        return compositeOverlayWithThemeSurfaceColorIfNeeded(getParentAbsoluteElevation(r10) + r5);
    }

    public float getParentAbsoluteElevation(@NonNull View r5) {
        return ViewUtils.getParentAbsoluteElevation(r5);
    }

    @ColorInt
    public int getThemeElevationOverlayColor() {
        return this.elevationOverlayColor;
    }

    @ColorInt
    public int getThemeSurfaceColor() {
        return this.colorSurface;
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.elevationOverlayEnabled;
    }

    @ColorInt
    public int compositeOverlay(@ColorInt int r5, float r10) {
        float r11 = calculateOverlayAlphaFraction(r10);
        int r12 = Color.alpha(r5);
        int r13 = MaterialColors.layer(ColorUtils.setAlphaComponent(r5, 255), this.elevationOverlayColor, r11);
        if (r11 <= 0.0f) goto L8;
        int r14 = this.elevationOverlayAccentColor;
        if (r14 == 0) goto L8;
        r13 = MaterialColors.layer(r13, ColorUtils.setAlphaComponent(r14, OVERLAY_ACCENT_COLOR_ALPHA));
    L8:
        return ColorUtils.setAlphaComponent(r13, r12);
    }

    @ColorInt
    public int compositeOverlayIfNeeded(@ColorInt int r5, float r10) {
        if (this.elevationOverlayEnabled == true) goto L5;
    L8:
        return r5;
    L5:
        if (isThemeSurfaceColor(r5) == false) goto L8;
        return compositeOverlay(r5, r10);
    }

    @ColorInt
    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float r5) {
        return compositeOverlayIfNeeded(this.colorSurface, r5);
    }

    public ElevationOverlayProvider(boolean r5, @ColorInt int r10, @ColorInt int r11, @ColorInt int r12, float r13) {
        this.elevationOverlayEnabled = r5;
        this.elevationOverlayColor = r10;
        this.elevationOverlayAccentColor = r11;
        this.colorSurface = r12;
        this.displayDensity = r13;
    }
}
