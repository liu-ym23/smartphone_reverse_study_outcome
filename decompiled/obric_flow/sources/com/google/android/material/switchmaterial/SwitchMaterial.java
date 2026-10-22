package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class SwitchMaterial extends SwitchCompat {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;

    @NonNull
    private final ElevationOverlayProvider elevationOverlayProvider;

    @Nullable
    private ColorStateList materialThemeColorsThumbTintList;

    @Nullable
    private ColorStateList materialThemeColorsTrackTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_Switch;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public SwitchMaterial(@NonNull Context r5) {
        this(r5, null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.materialThemeColorsThumbTintList != null) goto L9;
        int r5 = MaterialColors.getColor(this, R.attr.colorSurface);
        int r10 = MaterialColors.getColor(this, R.attr.colorControlActivated);
        float r11 = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
        if (this.elevationOverlayProvider.isThemeElevationOverlayEnabled() == false) goto L7;
        r11 = r11 + ViewUtils.getParentAbsoluteElevation(this);
    L7:
        int r12 = this.elevationOverlayProvider.compositeOverlayIfNeeded(r5, r11);
        int[][] r13 = ENABLED_CHECKED_STATES;
        int[] r14 = new int[r13.length];
        r14[0] = MaterialColors.layer(r5, r10, 1.0f);
        r14[1] = r12;
        r14[2] = MaterialColors.layer(r5, r10, 0.38f);
        r14[3] = r12;
        this.materialThemeColorsThumbTintList = new ColorStateList(r13, r14);
    L9:
        return this.materialThemeColorsThumbTintList;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.materialThemeColorsTrackTintList != null) goto L6;
        int[][] r5 = ENABLED_CHECKED_STATES;
        int[] r10 = new int[r5.length];
        int r11 = MaterialColors.getColor(this, R.attr.colorSurface);
        int r12 = MaterialColors.getColor(this, R.attr.colorControlActivated);
        int r13 = MaterialColors.getColor(this, R.attr.colorOnSurface);
        r10[0] = MaterialColors.layer(r11, r12, 0.54f);
        r10[1] = MaterialColors.layer(r11, r13, 0.32f);
        r10[2] = MaterialColors.layer(r11, r12, 0.12f);
        r10[3] = MaterialColors.layer(r11, r13, 0.12f);
        this.materialThemeColorsTrackTintList = new ColorStateList(r5, r10);
    L6:
        return this.materialThemeColorsTrackTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors == false) goto L8;
        if (getThumbTintList() != null) goto L8;
        setThumbTintList(getMaterialThemeColorsThumbTintList());
    L8:
        if (this.useMaterialThemeColors == true) goto L10;
        return;
    L10:
        if (getTrackTintList() != null) goto L14;
        setTrackTintList(getMaterialThemeColorsTrackTintList());
        return;
    }

    public void setUseMaterialThemeColors(boolean r5) {
        this.useMaterialThemeColors = r5;
        if (r5 == false) goto L5;
        setThumbTintList(getMaterialThemeColorsThumbTintList());
        setTrackTintList(getMaterialThemeColorsTrackTintList());
        return;
    L5:
        setThumbTintList(null);
        setTrackTintList(null);
    }

    public SwitchMaterial(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.switchStyle);
    }

    public SwitchMaterial(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        Context r13 = getContext();
        this.elevationOverlayProvider = new ElevationOverlayProvider(r13);
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.SwitchMaterial, r12, r5, new int[0]);
        this.useMaterialThemeColors = r14.getBoolean(R.styleable.SwitchMaterial_useMaterialThemeColors, false);
        r14.recycle();
    }
}
