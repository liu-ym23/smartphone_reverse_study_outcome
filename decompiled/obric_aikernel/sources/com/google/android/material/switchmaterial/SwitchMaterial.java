package com.google.android.material.switchmaterial;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.internal.ViewUtils;
import q5.b;
import q5.d;
import q5.k;
import q5.l;
import w5.a;

/* JADX INFO: loaded from: classes.dex */
public class SwitchMaterial extends SwitchCompat {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;

    @NonNull
    private final a elevationOverlayProvider;

    @Nullable
    private ColorStateList materialThemeColorsThumbTintList;

    @Nullable
    private ColorStateList materialThemeColorsTrackTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = k.Widget_MaterialComponents_CompoundButton_Switch;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public SwitchMaterial(@NonNull Context r10) {
        this(r10, null);
    }

    public SwitchMaterial(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, b.switchStyle);
    }

    public SwitchMaterial(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(b6.a.c(r10, r11, r12, r13), r11, r12);
        Context r14 = getContext();
        this.elevationOverlayProvider = new a(r14);
        TypedArray r15 = com.google.android.material.internal.k.h(r14, r11, l.SwitchMaterial, r12, r13, new int[0]);
        this.useMaterialThemeColors = r15.getBoolean(l.SwitchMaterial_useMaterialThemeColors, false);
        r15.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.materialThemeColorsThumbTintList != null) goto L9;
        int r10 = t5.a.d(this, b.colorSurface);
        int r11 = t5.a.d(this, b.colorControlActivated);
        float r12 = getResources().getDimension(d.mtrl_switch_thumb_elevation);
        if (this.elevationOverlayProvider.e() == false) goto L7;
        r12 = r12 + ViewUtils.h(this);
    L7:
        int r13 = this.elevationOverlayProvider.c(r10, r12);
        int[][] r14 = ENABLED_CHECKED_STATES;
        int[] r15 = new int[r14.length];
        r15[0] = t5.a.h(r10, r11, 1.0f);
        r15[1] = r13;
        r15[2] = t5.a.h(r10, r11, 0.38f);
        r15[3] = r13;
        this.materialThemeColorsThumbTintList = new ColorStateList(r14, r15);
    L9:
        return this.materialThemeColorsThumbTintList;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.materialThemeColorsTrackTintList != null) goto L6;
        int[][] r10 = ENABLED_CHECKED_STATES;
        int[] r11 = new int[r10.length];
        int r12 = t5.a.d(this, b.colorSurface);
        int r13 = t5.a.d(this, b.colorControlActivated);
        int r14 = t5.a.d(this, b.colorOnSurface);
        r11[0] = t5.a.h(r12, r13, 0.54f);
        r11[1] = t5.a.h(r12, r14, 0.32f);
        r11[2] = t5.a.h(r12, r13, 0.12f);
        r11[3] = t5.a.h(r12, r14, 0.12f);
        this.materialThemeColorsTrackTintList = new ColorStateList(r10, r11);
    L6:
        return this.materialThemeColorsTrackTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
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

    public void setUseMaterialThemeColors(boolean r10) {
        this.useMaterialThemeColors = r10;
        if (r10 == false) goto L5;
        setThumbTintList(getMaterialThemeColorsThumbTintList());
        ColorStateList r11 = getMaterialThemeColorsTrackTintList();
    L6:
        setTrackTintList(r11);
        return;
    L5:
        r11 = null;
        setThumbTintList(null);
        goto L6
    }
}
