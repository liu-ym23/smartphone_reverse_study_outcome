package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.k;
import com.google.android.material.resources.c;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.a.a;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialDivider extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3898a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaterialShapeDrawable f3899b;
    private int c;
    private int d;
    private int e;
    private int f;

    static {
        f3898a = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_MaterialDivider, "style", "Widget_MaterialComponents_MaterialDivider");
    }

    public MaterialDivider(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public MaterialDivider(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.materialDividerStyle, "attr", "materialDividerStyle"));
    }

    public MaterialDivider(Context r9, AttributeSet r10, int r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        int r6 = f3898a;
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(r12, r3, r11, r6), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r11);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.f3899b = new MaterialShapeDrawable();
        TypedArray r14 = k.a(r13, r3, R.styleable.MaterialDivider, r11, r6, new int[0]);
        this.c = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerThickness, "styleable", "MaterialDivider_dividerThickness"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_divider_thickness, "dimen", "material_divider_thickness")));
        this.e = r14.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerInsetStart, "styleable", "MaterialDivider_dividerInsetStart"), 0);
        this.f = r14.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerInsetEnd, "styleable", "MaterialDivider_dividerInsetEnd"), 0);
        setDividerColor(c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerColor, "styleable", "MaterialDivider_dividerColor")).getDefaultColor());
        r14.recycle();
    }

    public int getDividerColor() {
        return this.d;
    }

    public int getDividerInsetEnd() {
        return this.f;
    }

    public int getDividerInsetStart() {
        return this.e;
    }

    public int getDividerThickness() {
        return this.c;
    }

    @Override // android.view.View
    public void onDraw(Canvas r7) {
        super.onDraw(r7);
        boolean r2 = true;
        if (ViewCompat.getLayoutDirection(this) == 1) goto L6;
        r2 = false;
    L6:
        if (r2 == false) goto L8;
        int r0 = this.f;
    L9:
        if (r2 == false) goto L11;
        int r3 = getWidth();
        int r4 = this.e;
    L12:
        this.f3899b.setBounds(r0, 0, r3 - r4, getBottom() - getTop());
        this.f3899b.draw(r7);
        return;
    L11:
        r3 = getWidth();
        r4 = this.f;
        goto L12
    L8:
        r0 = this.e;
        goto L9
    }

    @Override // android.view.View
    public void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        int r4 = View.MeasureSpec.getMode(r3);
        int r5 = getMeasuredHeight();
        if (r4 == Integer.MIN_VALUE) goto L5;
        if (r4 == 0) goto L5;
        return;
    L5:
        int r6 = this.c;
        if (r6 <= 0) goto L9;
        if (r5 == r6) goto L9;
        r5 = r6;
    L9:
        setMeasuredDimension(getMeasuredWidth(), r5);
    }

    public void setDividerColor(int r2) {
        if (this.d == r2) goto L6;
        this.d = r2;
        this.f3899b.setFillColor(ColorStateList.valueOf(r2));
        invalidate();
        return;
    }

    public void setDividerColorResource(int r4) {
        setDividerColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setDividerInsetEnd(int r1) {
        this.f = r1;
    }

    public void setDividerInsetEndResource(int r4) {
        setDividerInsetEnd(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelOffset(r4));
    }

    public void setDividerInsetStart(int r1) {
        this.e = r1;
    }

    public void setDividerInsetStartResource(int r4) {
        setDividerInsetStart(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelOffset(r4));
    }

    public void setDividerThickness(int r2) {
        if (this.c == r2) goto L6;
        this.c = r2;
        requestLayout();
        return;
    }

    public void setDividerThicknessResource(int r4) {
        setDividerThickness(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(r4));
    }
}
