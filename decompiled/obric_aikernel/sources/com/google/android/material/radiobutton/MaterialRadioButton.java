package com.google.android.material.radiobutton;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import b6.a;
import com.google.android.material.resources.c;
import q5.b;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;

    @Nullable
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = k.Widget_MaterialComponents_CompoundButton_RadioButton;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public MaterialRadioButton(@NonNull Context r10) {
        this(r10, null);
    }

    public MaterialRadioButton(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, b.radioButtonStyle);
    }

    public MaterialRadioButton(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(a.c(r10, r11, r12, r13), r11, r12);
        Context r14 = getContext();
        TypedArray r15 = com.google.android.material.internal.k.h(r14, r11, l.MaterialRadioButton, r12, r13, new int[0]);
        int r16 = l.MaterialRadioButton_buttonTint;
        if (r15.hasValue(r16) == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, c.a(r14, r15, r16));
    L5:
        this.useMaterialThemeColors = r15.getBoolean(l.MaterialRadioButton_useMaterialThemeColors, false);
        r15.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int r10 = t5.a.d(this, b.colorControlActivated);
        int r11 = t5.a.d(this, b.colorOnSurface);
        int r12 = t5.a.d(this, b.colorSurface);
        int[][] r13 = ENABLED_CHECKED_STATES;
        int[] r14 = new int[r13.length];
        r14[0] = t5.a.h(r12, r10, 1.0f);
        r14[1] = t5.a.h(r12, r11, 0.54f);
        r14[2] = t5.a.h(r12, r11, 0.38f);
        r14[3] = t5.a.h(r12, r11, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r13, r14);
    L6:
        return this.materialThemeColorsTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors == true) goto L5;
        return;
    L5:
        if (CompoundButtonCompat.getButtonTintList(this) != null) goto L9;
        setUseMaterialThemeColors(true);
        return;
    }

    public void setUseMaterialThemeColors(boolean r10) {
        this.useMaterialThemeColors = r10;
        if (r10 == false) goto L5;
        ColorStateList r11 = getMaterialThemeColorsTintList();
    L6:
        CompoundButtonCompat.setButtonTintList(this, r11);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
