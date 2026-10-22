package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.internal.k;
import com.google.android.material.resources.c;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int DEF_STYLE_RES = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int color;
    private Drawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private boolean lastItemDecorated;
    private int orientation;
    private final Rect tempRect;
    private int thickness;

    static {
        DEF_STYLE_RES = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_MaterialDivider, "style", "Widget_MaterialComponents_MaterialDivider");
    }

    public MaterialDividerItemDecoration(Context r3, int r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null, r4);
    }

    public MaterialDividerItemDecoration(Context r4, AttributeSet r5, int r6) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.materialDividerStyle, "attr", "materialDividerStyle"), r6);
    }

    public MaterialDividerItemDecoration(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        this.tempRect = new Rect();
        TypedArray r14 = k.a(r13, r3, R.styleable.MaterialDivider, r11, DEF_STYLE_RES, new int[0]);
        this.color = c.a(r13, r14, ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerColor, "styleable", "MaterialDivider_dividerColor")).getDefaultColor();
        this.thickness = r14.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerThickness, "styleable", "MaterialDivider_dividerThickness"), ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.material_divider_thickness, "dimen", "material_divider_thickness")));
        this.insetStart = r14.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerInsetStart, "styleable", "MaterialDivider_dividerInsetStart"), 0);
        this.insetEnd = r14.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_dividerInsetEnd, "styleable", "MaterialDivider_dividerInsetEnd"), 0);
        this.lastItemDecorated = r14.getBoolean(ZeusTransformUtils.mapRes(R.styleable.MaterialDivider_lastItemDecorated, "styleable", "MaterialDivider_lastItemDecorated"), true);
        r14.recycle();
        this.dividerDrawable = new ShapeDrawable();
        setDividerColor(this.color);
        setOrientation(r12);
    }

    private void drawForHorizontalOrientation(Canvas r8, RecyclerView r9) {
        r8.save();
        int r1 = 0;
        if (r9.getClipToPadding() == false) goto L5;
        int r0 = r9.getPaddingTop();
        int r2 = r9.getHeight() - r9.getPaddingBottom();
        r8.clipRect(r9.getPaddingLeft(), r0, r9.getWidth() - r9.getPaddingRight(), r2);
    L6:
        int r3 = r0 + this.insetStart;
        int r4 = r2 - this.insetEnd;
        int r5 = r9.getChildCount();
    L7:
        if (r1 >= r5) goto L9;
        View r6 = r9.getChildAt(r1);
        r9.getLayoutManager().getDecoratedBoundsWithMargins(r6, this.tempRect);
        int r7 = this.tempRect.right + Math.round(r6.getTranslationX());
        this.dividerDrawable.setBounds((r7 - this.dividerDrawable.getIntrinsicWidth()) - this.thickness, r3, r7, r4);
        this.dividerDrawable.draw(r8);
        r1 = r1 + 1;
        goto L7
    L9:
        r8.restore();
        return;
    L5:
        r2 = r9.getHeight();
        r0 = 0;
        goto L6
    }

    private void drawForVerticalOrientation(Canvas r8, RecyclerView r9) {
        r8.save();
        int r1 = 0;
        if (r9.getClipToPadding() == false) goto L5;
        int r0 = r9.getPaddingLeft();
        int r2 = r9.getWidth() - r9.getPaddingRight();
        r8.clipRect(r0, r9.getPaddingTop(), r2, r9.getHeight() - r9.getPaddingBottom());
    L6:
        boolean r4 = true;
        if (ViewCompat.getLayoutDirection(r9) == 1) goto L10;
        r4 = false;
    L10:
        if (r4 == false) goto L12;
        int r3 = this.insetEnd;
    L13:
        int r5 = r0 + r3;
        if (r4 == false) goto L16;
        int r6 = this.insetStart;
    L17:
        int r7 = r2 - r6;
        int r10 = r9.getChildCount();
        if (this.lastItemDecorated == true) goto L21;
        r10 = r10 - 1;
    L21:
        if (r1 >= r10) goto L23;
        View r11 = r9.getChildAt(r1);
        r9.getDecoratedBoundsWithMargins(r11, this.tempRect);
        int r12 = this.tempRect.bottom + Math.round(r11.getTranslationY());
        this.dividerDrawable.setBounds(r5, (r12 - this.dividerDrawable.getIntrinsicHeight()) - this.thickness, r7, r12);
        this.dividerDrawable.draw(r8);
        r1 = r1 + 1;
        goto L21
    L23:
        r8.restore();
        return;
    L16:
        r6 = this.insetEnd;
        goto L17
    L12:
        r3 = this.insetStart;
        goto L13
    L5:
        r2 = r9.getWidth();
        r0 = 0;
        goto L6
    }

    public int getDividerColor() {
        return this.color;
    }

    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    public int getDividerInsetStart() {
        return this.insetStart;
    }

    public int getDividerThickness() {
        return this.thickness;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect r1, View r2, RecyclerView r3, RecyclerView.State r4) {
        r1.set(0, 0, 0, 0);
        if (this.orientation != 1) goto L5;
        r1.bottom = this.dividerDrawable.getIntrinsicHeight() + this.thickness;
        return;
    L5:
        r1.right = this.dividerDrawable.getIntrinsicWidth() + this.thickness;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isLastItemDecorated() {
        return this.lastItemDecorated;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas r2, RecyclerView r3, RecyclerView.State r4) {
        if (r3.getLayoutManager() != null) goto L6;
        return;
    L6:
        if (this.orientation != 1) goto L8;
        drawForVerticalOrientation(r2, r3);
        return;
    L8:
        drawForHorizontalOrientation(r2, r3);
    }

    public void setDividerColor(int r2) {
        this.color = r2;
        Drawable r0 = DrawableCompat.wrap(this.dividerDrawable);
        this.dividerDrawable = r0;
        DrawableCompat.setTint(r0, r2);
    }

    public void setDividerColorResource(Context r3, int r4) {
        setDividerColor(ContextCompat.getColor((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4));
    }

    public void setDividerInsetEnd(int r1) {
        this.insetEnd = r1;
    }

    public void setDividerInsetEndResource(Context r3, int r4) {
        setDividerInsetEnd(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelOffset(r4));
    }

    public void setDividerInsetStart(int r1) {
        this.insetStart = r1;
    }

    public void setDividerInsetStartResource(Context r3, int r4) {
        setDividerInsetStart(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelOffset(r4));
    }

    public void setDividerThickness(int r1) {
        this.thickness = r1;
    }

    public void setDividerThicknessResource(Context r3, int r4) {
        setDividerThickness(ZeusTransformUtils.getResources((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin").getDimensionPixelSize(r4));
    }

    public void setLastItemDecorated(boolean r1) {
        this.lastItemDecorated = r1;
    }

    public void setOrientation(int r3) {
        if (r3 != 0) goto L4;
    L8:
        this.orientation = r3;
        return;
    L4:
        if (r3 == 1) goto L8;
        throw new IllegalArgumentException("Invalid orientation: " + r3 + ". It should be either HORIZONTAL or VERTICAL");
    }
}
