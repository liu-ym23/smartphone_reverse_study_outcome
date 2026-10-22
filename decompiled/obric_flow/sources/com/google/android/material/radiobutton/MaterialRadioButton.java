package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;

    @Nullable
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_CompoundButton_RadioButton;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public MaterialRadioButton(@NonNull Context r5) {
        this(r5, null);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int r5 = MaterialColors.getColor(this, R.attr.colorControlActivated);
        int r10 = MaterialColors.getColor(this, R.attr.colorOnSurface);
        int r11 = MaterialColors.getColor(this, R.attr.colorSurface);
        int[][] r12 = ENABLED_CHECKED_STATES;
        int[] r13 = new int[r12.length];
        r13[0] = MaterialColors.layer(r11, r5, 1.0f);
        r13[1] = MaterialColors.layer(r11, r10, 0.54f);
        r13[2] = MaterialColors.layer(r11, r10, 0.38f);
        r13[3] = MaterialColors.layer(r11, r10, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r12, r13);
    L6:
        return this.materialThemeColorsTintList;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors == true) goto L5;
        return;
    L5:
        if (CompoundButtonCompat.getButtonTintList(this) != null) goto L9;
        setUseMaterialThemeColors(true);
        return;
    }

    public void setUseMaterialThemeColors(boolean r5) {
        this.useMaterialThemeColors = r5;
        if (r5 == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, getMaterialThemeColorsTintList());
        return;
    L5:
        CompoundButtonCompat.setButtonTintList(this, null);
    }

    public MaterialRadioButton(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.radioButtonStyle);
    }

    public MaterialRadioButton(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        Context r13 = getContext();
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.MaterialRadioButton, r12, r5, new int[0]);
        if (r14.hasValue(R.styleable.MaterialRadioButton_buttonTint) == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, MaterialResources.getColorStateList(r13, r14, R.styleable.MaterialRadioButton_buttonTint));
    L5:
        this.useMaterialThemeColors = r14.getBoolean(R.styleable.MaterialRadioButton_useMaterialThemeColors, false);
        r14.recycle();
    }
}
