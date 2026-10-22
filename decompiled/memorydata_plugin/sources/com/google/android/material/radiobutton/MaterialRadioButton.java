package com.google.android.material.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.internal.k;
import com.google.android.material.resources.c;
import com.google.android.material.theme.a.a;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialRadioButton extends AppCompatRadioButton {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_CompoundButton_RadioButton, "style", "Widget_MaterialComponents_CompoundButton_RadioButton");
        ENABLED_CHECKED_STATES = new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public MaterialRadioButton(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public MaterialRadioButton(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.radioButtonStyle, "attr", "radioButtonStyle"));
    }

    public MaterialRadioButton(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r12, r3, r11, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r11);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        TypedArray r14 = k.a(r13, r3, R.styleable.MaterialRadioButton, r11, r6, new int[0]);
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialRadioButton_buttonTint, "styleable", "MaterialRadioButton_buttonTint")) == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.MaterialRadioButton_buttonTint, "styleable", "MaterialRadioButton_buttonTint")));
    L5:
        this.useMaterialThemeColors = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialRadioButton_useMaterialThemeColors, "styleable", "MaterialRadioButton_useMaterialThemeColors"), false);
        r14.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int r0 = com.google.android.material.c.a.a(this, ZeusTransformUtils.mapRes(R.attr.colorControlActivated, "attr", "colorControlActivated"));
        int r2 = com.google.android.material.c.a.a(this, ZeusTransformUtils.mapRes(R.attr.colorOnSurface, "attr", "colorOnSurface"));
        int r1 = com.google.android.material.c.a.a(this, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
        int[][] r3 = ENABLED_CHECKED_STATES;
        int[] r4 = new int[r3.length];
        r4[0] = com.google.android.material.c.a.a(r1, r0, 1.0f);
        r4[1] = com.google.android.material.c.a.a(r1, r2, 0.54f);
        r4[2] = com.google.android.material.c.a.a(r1, r2, 0.38f);
        r4[3] = com.google.android.material.c.a.a(r1, r2, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r3, r4);
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

    public void setUseMaterialThemeColors(boolean r1) {
        this.useMaterialThemeColors = r1;
        if (r1 == false) goto L5;
        ColorStateList r2 = getMaterialThemeColorsTintList();
    L6:
        CompoundButtonCompat.setButtonTintList(this, r2);
        return;
    L5:
        r2 = null;
        goto L6
    }
}
