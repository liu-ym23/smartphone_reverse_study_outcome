package com.google.android.material.checkbox;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import b6.a;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.c;
import q5.b;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;
    private boolean centerIfNoTextEnabled;

    @Nullable
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = k.Widget_MaterialComponents_CompoundButton_CheckBox;
        ENABLED_CHECKED_STATES = new int[][]{new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public MaterialCheckBox(Context r10) {
        this(r10, null);
    }

    public MaterialCheckBox(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, b.checkboxStyle);
    }

    public MaterialCheckBox(Context r10, @Nullable AttributeSet r11, int r12) {
        int r13 = DEF_STYLE_RES;
        super(a.c(r10, r11, r12, r13), r11, r12);
        Context r14 = getContext();
        TypedArray r15 = com.google.android.material.internal.k.h(r14, r11, l.MaterialCheckBox, r12, r13, new int[0]);
        int r16 = l.MaterialCheckBox_buttonTint;
        if (r15.hasValue(r16) == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, c.a(r14, r15, r16));
    L5:
        this.useMaterialThemeColors = r15.getBoolean(l.MaterialCheckBox_useMaterialThemeColors, false);
        this.centerIfNoTextEnabled = r15.getBoolean(l.MaterialCheckBox_centerIfNoTextEnabled, true);
        r15.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int[][] r10 = ENABLED_CHECKED_STATES;
        int[] r11 = new int[r10.length];
        int r12 = t5.a.d(this, b.colorControlActivated);
        int r13 = t5.a.d(this, b.colorSurface);
        int r14 = t5.a.d(this, b.colorOnSurface);
        r11[0] = t5.a.h(r13, r12, 1.0f);
        r11[1] = t5.a.h(r13, r14, 0.54f);
        r11[2] = t5.a.h(r13, r14, 0.38f);
        r11[3] = t5.a.h(r13, r14, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r10, r11);
    L6:
        return this.materialThemeColorsTintList;
    }

    public boolean isCenterIfNoTextEnabled() {
        return this.centerIfNoTextEnabled;
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

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas r10) {
        if (this.centerIfNoTextEnabled == true) goto L5;
    L16:
        super.onDraw(r10);
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == false) goto L16;
        Drawable r11 = CompoundButtonCompat.getButtonDrawable(this);
        if (r11 == null) goto L16;
        if (ViewUtils.i(this) == false) goto L11;
        int r12 = -1;
    L12:
        int r13 = ((getWidth() - r11.getIntrinsicWidth()) / 2) * r12;
        int r14 = r10.save();
        r10.translate(r13, 0.0f);
        super.onDraw(r10);
        r10.restoreToCount(r14);
        if (getBackground() == null) goto L18;
        Rect r15 = r11.getBounds();
        DrawableCompat.setHotspotBounds(getBackground(), r15.left + r13, r15.top, r15.right + r13, r15.bottom);
        return;
    L18:
        return;
    L11:
        r12 = 1;
        goto L12
    }

    public void setCenterIfNoTextEnabled(boolean r10) {
        this.centerIfNoTextEnabled = r10;
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
