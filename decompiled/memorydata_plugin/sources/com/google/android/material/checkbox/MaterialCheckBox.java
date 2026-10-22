package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.material.internal.k;
import com.google.android.material.internal.r;
import com.google.android.material.resources.c;
import com.google.android.material.theme.a.a;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialCheckBox extends AppCompatCheckBox {
    private static final int DEF_STYLE_RES = 0;
    private static final int[][] ENABLED_CHECKED_STATES = null;
    private boolean centerIfNoTextEnabled;
    private ColorStateList materialThemeColorsTintList;
    private boolean useMaterialThemeColors;

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_CompoundButton_CheckBox, "style", "Widget_MaterialComponents_CompoundButton_CheckBox");
        ENABLED_CHECKED_STATES = new int[][]{new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, new int[]{android.R.attr.state_enabled, -16842912}, new int[]{-16842910, android.R.attr.state_checked}, new int[]{-16842910, -16842912}};
    }

    public MaterialCheckBox(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public MaterialCheckBox(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.checkboxStyle, "attr", "checkboxStyle"));
    }

    public MaterialCheckBox(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = DEF_STYLE_RES;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r12, r3, r11, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r11);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        TypedArray r14 = k.a(r13, r3, R.styleable.MaterialCheckBox, r11, r6, new int[0]);
        if (r14.hasValue(ZeusTransformUtils.mapRes(R.styleable.MaterialCheckBox_buttonTint, "styleable", "MaterialCheckBox_buttonTint")) == false) goto L5;
        CompoundButtonCompat.setButtonTintList(this, c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.MaterialCheckBox_buttonTint, "styleable", "MaterialCheckBox_buttonTint")));
    L5:
        this.useMaterialThemeColors = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialCheckBox_useMaterialThemeColors, "styleable", "MaterialCheckBox_useMaterialThemeColors"), false);
        this.centerIfNoTextEnabled = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialCheckBox_centerIfNoTextEnabled, "styleable", "MaterialCheckBox_centerIfNoTextEnabled"), true);
        r14.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.materialThemeColorsTintList != null) goto L6;
        int[][] r0 = ENABLED_CHECKED_STATES;
        int[] r1 = new int[r0.length];
        int r2 = com.google.android.material.c.a.a(this, ZeusTransformUtils.mapRes(R.attr.colorControlActivated, "attr", "colorControlActivated"));
        int r4 = com.google.android.material.c.a.a(this, ZeusTransformUtils.mapRes(R.attr.colorSurface, "attr", "colorSurface"));
        int r3 = com.google.android.material.c.a.a(this, ZeusTransformUtils.mapRes(R.attr.colorOnSurface, "attr", "colorOnSurface"));
        r1[0] = com.google.android.material.c.a.a(r4, r2, 1.0f);
        r1[1] = com.google.android.material.c.a.a(r4, r3, 0.54f);
        r1[2] = com.google.android.material.c.a.a(r4, r3, 0.38f);
        r1[3] = com.google.android.material.c.a.a(r4, r3, 0.38f);
        this.materialThemeColorsTintList = new ColorStateList(r0, r1);
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
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useMaterialThemeColors == true) goto L5;
        return;
    L5:
        if (CompoundButtonCompat.getButtonTintList(this) != null) goto L9;
        setUseMaterialThemeColors(true);
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onDraw(Canvas r6) {
        if (this.centerIfNoTextEnabled == true) goto L5;
    L16:
        super.onDraw(r6);
        return;
    L5:
        if (TextUtils.isEmpty(getText()) == false) goto L16;
        Drawable r0 = CompoundButtonCompat.getButtonDrawable(this);
        if (r0 == null) goto L16;
        if (r.a(this) == false) goto L11;
        int r1 = -1;
    L12:
        int r2 = ((getWidth() - r0.getIntrinsicWidth()) / 2) * r1;
        int r3 = r6.save();
        r6.translate(r2, 0.0f);
        super.onDraw(r6);
        r6.restoreToCount(r3);
        if (getBackground() == null) goto L18;
        Rect r7 = r0.getBounds();
        DrawableCompat.setHotspotBounds(getBackground(), r7.left + r2, r7.top, r7.right + r2, r7.bottom);
        return;
    L18:
        return;
    L11:
        r1 = 1;
        goto L12
    }

    public void setCenterIfNoTextEnabled(boolean r1) {
        this.centerIfNoTextEnabled = r1;
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
