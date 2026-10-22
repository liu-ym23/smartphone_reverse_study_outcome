package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.resources.c;
import q5.b;
import q5.d;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int DEF_STYLE_RES = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    @ColorInt
    private int color;

    @NonNull
    private Drawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private boolean lastItemDecorated;
    private int orientation;
    private final Rect tempRect;
    private int thickness;

    static {
        DEF_STYLE_RES = k.Widget_MaterialComponents_MaterialDivider;
    }

    public MaterialDividerItemDecoration(@NonNull Context r10, int r11) {
        this(r10, null, r11);
    }

    public MaterialDividerItemDecoration(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        this(r10, r11, b.materialDividerStyle, r12);
    }

    public MaterialDividerItemDecoration(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        this.tempRect = new Rect();
        TypedArray r14 = com.google.android.material.internal.k.h(r10, r11, l.MaterialDivider, r12, DEF_STYLE_RES, new int[0]);
        this.color = c.a(r10, r14, l.MaterialDivider_dividerColor).getDefaultColor();
        this.thickness = r14.getDimensionPixelSize(l.MaterialDivider_dividerThickness, r10.getResources().getDimensionPixelSize(d.material_divider_thickness));
        this.insetStart = r14.getDimensionPixelOffset(l.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = r14.getDimensionPixelOffset(l.MaterialDivider_dividerInsetEnd, 0);
        this.lastItemDecorated = r14.getBoolean(l.MaterialDivider_lastItemDecorated, true);
        r14.recycle();
        this.dividerDrawable = new ShapeDrawable();
        setDividerColor(this.color);
        setOrientation(r13);
    }

    private void drawForHorizontalOrientation(@NonNull Canvas r10, @NonNull RecyclerView r11) {
        r10.save();
        int r12 = 0;
        if (r11.getClipToPadding() == false) goto L5;
        int r13 = r11.getPaddingTop();
        int r14 = r11.getHeight() - r11.getPaddingBottom();
        r10.clipRect(r11.getPaddingLeft(), r13, r11.getWidth() - r11.getPaddingRight(), r14);
    L6:
        int r15 = r13 + this.insetStart;
        int r16 = r14 - this.insetEnd;
        int r17 = r11.getChildCount();
    L7:
        if (r12 >= r17) goto L9;
        View r18 = r11.getChildAt(r12);
        r11.getLayoutManager().getDecoratedBoundsWithMargins(r18, this.tempRect);
        int r19 = this.tempRect.right + Math.round(r18.getTranslationX());
        this.dividerDrawable.setBounds((r19 - this.dividerDrawable.getIntrinsicWidth()) - this.thickness, r15, r19, r16);
        this.dividerDrawable.draw(r10);
        r12 = r12 + 1;
        goto L7
    L9:
        r10.restore();
        return;
    L5:
        r14 = r11.getHeight();
        r13 = 0;
        goto L6
    }

    private void drawForVerticalOrientation(@NonNull Canvas r10, @NonNull RecyclerView r11) {
        r10.save();
        int r12 = 0;
        if (r11.getClipToPadding() == false) goto L5;
        int r13 = r11.getPaddingLeft();
        int r14 = r11.getWidth() - r11.getPaddingRight();
        r10.clipRect(r13, r11.getPaddingTop(), r14, r11.getHeight() - r11.getPaddingBottom());
    L6:
        boolean r15 = true;
        if (ViewCompat.getLayoutDirection(r11) == 1) goto L10;
        r15 = false;
    L10:
        if (r15 == false) goto L12;
        int r16 = this.insetEnd;
    L13:
        int r17 = r13 + r16;
        if (r15 == false) goto L16;
        int r18 = this.insetStart;
    L17:
        int r19 = r14 - r18;
        int r20 = r11.getChildCount();
        if (this.lastItemDecorated == true) goto L21;
        r20 = r20 - 1;
    L21:
        if (r12 >= r20) goto L23;
        View r21 = r11.getChildAt(r12);
        r11.getDecoratedBoundsWithMargins(r21, this.tempRect);
        int r22 = this.tempRect.bottom + Math.round(r21.getTranslationY());
        this.dividerDrawable.setBounds(r17, (r22 - this.dividerDrawable.getIntrinsicHeight()) - this.thickness, r19, r22);
        this.dividerDrawable.draw(r10);
        r12 = r12 + 1;
        goto L21
    L23:
        r10.restore();
        return;
    L16:
        r18 = this.insetEnd;
        goto L17
    L12:
        r16 = this.insetStart;
        goto L13
    L5:
        r14 = r11.getWidth();
        r13 = 0;
        goto L6
    }

    @ColorInt
    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    @Px
    public int getDividerThickness() {
        return this.thickness;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect r10, @NonNull View r11, @NonNull RecyclerView r12, @NonNull RecyclerView.State r13) {
        r10.set(0, 0, 0, 0);
        if (this.orientation != 1) goto L5;
        r10.bottom = this.dividerDrawable.getIntrinsicHeight() + this.thickness;
        return;
    L5:
        r10.right = this.dividerDrawable.getIntrinsicWidth() + this.thickness;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isLastItemDecorated() {
        return this.lastItemDecorated;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull RecyclerView.State r12) {
        if (r11.getLayoutManager() != null) goto L6;
        return;
    L6:
        if (this.orientation != 1) goto L8;
        drawForVerticalOrientation(r10, r11);
        return;
    L8:
        drawForHorizontalOrientation(r10, r11);
    }

    public void setDividerColor(@ColorInt int r10) {
        this.color = r10;
        Drawable r11 = DrawableCompat.wrap(this.dividerDrawable);
        this.dividerDrawable = r11;
        DrawableCompat.setTint(r11, r10);
    }

    public void setDividerColorResource(@NonNull Context r10, @ColorRes int r11) {
        setDividerColor(ContextCompat.getColor(r10, r11));
    }

    public void setDividerInsetEnd(@Px int r10) {
        this.insetEnd = r10;
    }

    public void setDividerInsetEndResource(@NonNull Context r10, @DimenRes int r11) {
        setDividerInsetEnd(r10.getResources().getDimensionPixelOffset(r11));
    }

    public void setDividerInsetStart(@Px int r10) {
        this.insetStart = r10;
    }

    public void setDividerInsetStartResource(@NonNull Context r10, @DimenRes int r11) {
        setDividerInsetStart(r10.getResources().getDimensionPixelOffset(r11));
    }

    public void setDividerThickness(@Px int r10) {
        this.thickness = r10;
    }

    public void setDividerThicknessResource(@NonNull Context r10, @DimenRes int r11) {
        setDividerThickness(r10.getResources().getDimensionPixelSize(r11));
    }

    public void setLastItemDecorated(boolean r10) {
        this.lastItemDecorated = r10;
    }

    public void setOrientation(int r10) {
        if (r10 != 0) goto L4;
    L8:
        this.orientation = r10;
        return;
    L4:
        if (r10 == 1) goto L8;
        throw new IllegalArgumentException("Invalid orientation: " + r10 + ". It should be either HORIZONTAL or VERTICAL");
    }
}
