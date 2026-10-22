package com.google.android.material.divider;

import ai.j0;
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
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

/* JADX INFO: loaded from: classes2.dex */
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
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    }

    public MaterialDividerItemDecoration(@NonNull Context r5, int r10) {
        this(r5, null, r10);
    }

    private void drawForHorizontalOrientation(@NonNull Canvas r10, @NonNull RecyclerView r11) {
        r10.save();
        int r5 = 0;
        if (r11.getClipToPadding() == false) goto L5;
        int r12 = r11.getPaddingTop();
        int r13 = r11.getHeight() - r11.getPaddingBottom();
        r10.clipRect(r11.getPaddingLeft(), r12, r11.getWidth() - r11.getPaddingRight(), r13);
    L6:
        int r14 = r12 + this.insetStart;
        int r15 = r13 - this.insetEnd;
        boolean r16 = ViewUtils.isLayoutRtl(r11);
        int r17 = r11.getChildCount();
    L7:
        if (r5 >= r17) goto L16;
        View r18 = r11.getChildAt(r5);
        if (shouldDrawDivider(r11, r18) == false) goto L15;
        r11.getLayoutManager().getDecoratedBoundsWithMargins(r18, this.tempRect);
        int r19 = Math.round(r18.getTranslationX());
        if (r16 == false) goto L13;
        int r20 = this.tempRect.left + r19;
        int r21 = this.thickness + r20;
    L14:
        this.dividerDrawable.setBounds(r20, r14, r21, r15);
        this.dividerDrawable.setAlpha(Math.round(r18.getAlpha() * 255.0f));
        this.dividerDrawable.draw(r10);
        goto L15
    L13:
        r21 = r19 + this.tempRect.right;
        r20 = r21 - this.thickness;
    L15:
        r5 = r5 + 1;
        goto L7
    L16:
        r10.restore();
        return;
    L5:
        r13 = r11.getHeight();
        r12 = 0;
        goto L6
    }

    private void drawForVerticalOrientation(@NonNull Canvas r10, @NonNull RecyclerView r11) {
        r10.save();
        int r5 = 0;
        if (r11.getClipToPadding() == false) goto L5;
        int r12 = r11.getPaddingLeft();
        int r13 = r11.getWidth() - r11.getPaddingRight();
        r10.clipRect(r12, r11.getPaddingTop(), r13, r11.getHeight() - r11.getPaddingBottom());
    L6:
        boolean r14 = ViewUtils.isLayoutRtl(r11);
        if (r14 == false) goto L9;
        int r15 = this.insetEnd;
    L10:
        int r16 = r12 + r15;
        if (r14 == false) goto L13;
        int r17 = this.insetStart;
    L14:
        int r18 = r13 - r17;
        int r19 = r11.getChildCount();
    L15:
        if (r5 >= r19) goto L20;
        View r20 = r11.getChildAt(r5);
        if (shouldDrawDivider(r11, r20) == false) goto L19;
        r11.getLayoutManager().getDecoratedBoundsWithMargins(r20, this.tempRect);
        int r21 = Math.round(r20.getTranslationY()) + this.tempRect.bottom;
        this.dividerDrawable.setBounds(r16, r21 - this.thickness, r18, r21);
        this.dividerDrawable.setAlpha(Math.round(r20.getAlpha() * 255.0f));
        this.dividerDrawable.draw(r10);
    L19:
        r5 = r5 + 1;
        goto L15
    L20:
        r10.restore();
        return;
    L13:
        r17 = this.insetEnd;
        goto L14
    L9:
        r15 = this.insetStart;
        goto L10
    L5:
        r13 = r11.getWidth();
        r12 = 0;
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
    public void getItemOffsets(@NonNull Rect r5, @NonNull View r10, @NonNull RecyclerView r11, @NonNull RecyclerView.State r12) {
        r5.set(0, 0, 0, 0);
        if (shouldDrawDivider(r11, r10) == true) goto L5;
        return;
    L5:
        if (this.orientation != 1) goto L8;
        r5.bottom = this.thickness;
        return;
    L8:
        if (ViewUtils.isLayoutRtl(r11) == false) goto L10;
        r5.left = this.thickness;
        return;
    L10:
        r5.right = this.thickness;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isLastItemDecorated() {
        return this.lastItemDecorated;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NonNull Canvas r5, @NonNull RecyclerView r10, @NonNull RecyclerView.State r11) {
        if (r10.getLayoutManager() != null) goto L6;
        return;
    L6:
        if (this.orientation != 1) goto L8;
        drawForVerticalOrientation(r5, r10);
        return;
    L8:
        drawForHorizontalOrientation(r5, r10);
    }

    public void setDividerColor(@ColorInt int r5) {
        this.color = r5;
        Drawable r10 = DrawableCompat.wrap(this.dividerDrawable);
        this.dividerDrawable = r10;
        DrawableCompat.setTint(r10, r5);
    }

    public void setDividerColorResource(@NonNull Context r5, @ColorRes int r10) {
        setDividerColor(ContextCompat.getColor(r5, r10));
    }

    public void setDividerInsetEnd(@Px int r5) {
        this.insetEnd = r5;
    }

    public void setDividerInsetEndResource(@NonNull Context r5, @DimenRes int r10) {
        setDividerInsetEnd(r5.getResources().getDimensionPixelOffset(r10));
    }

    public void setDividerInsetStart(@Px int r5) {
        this.insetStart = r5;
    }

    public void setDividerInsetStartResource(@NonNull Context r5, @DimenRes int r10) {
        setDividerInsetStart(r5.getResources().getDimensionPixelOffset(r10));
    }

    public void setDividerThickness(@Px int r5) {
        this.thickness = r5;
    }

    public void setDividerThicknessResource(@NonNull Context r5, @DimenRes int r10) {
        setDividerThickness(r5.getResources().getDimensionPixelSize(r10));
    }

    public void setLastItemDecorated(boolean r5) {
        this.lastItemDecorated = r5;
    }

    public void setOrientation(int r5) {
        if (r5 != 0) goto L4;
    L8:
        this.orientation = r5;
        return;
    L4:
        if (r5 == 1) goto L8;
        throw new IllegalArgumentException(j0.h(r5, "Invalid orientation: ", ". It should be either HORIZONTAL or VERTICAL"));
    }

    public boolean shouldDrawDivider(int r5, @Nullable RecyclerView.Adapter<?> r10) {
        return true;
    }

    public MaterialDividerItemDecoration(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        this(r5, r10, R.attr.materialDividerStyle, r11);
    }

    private boolean shouldDrawDivider(@NonNull RecyclerView r5, @NonNull View r10) {
        int r11 = r5.getChildAdapterPosition(r10);
        RecyclerView.Adapter r12 = r5.getAdapter();
        if (r12 != null) goto L5;
    L7:
        boolean r13 = false;
    L9:
        if (r11 == (-1)) goto L17;
        if (r13 == false) goto L14;
        if (this.lastItemDecorated == true) goto L14;
        return false;
    L14:
        if (shouldDrawDivider(r11, r12) == true) goto L16;
        return false;
    L16:
        return true;
    L17:
        return false;
    L5:
        if (r11 != (r12.getItemCount() - 1)) goto L7;
        r13 = true;
        goto L9
    }

    public MaterialDividerItemDecoration(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
        this.tempRect = new Rect();
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.MaterialDivider, r12, DEF_STYLE_RES, new int[0]);
        this.color = MaterialResources.getColorStateList(r10, r14, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.thickness = r14.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, r10.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.insetStart = r14.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = r14.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        this.lastItemDecorated = r14.getBoolean(R.styleable.MaterialDivider_lastItemDecorated, true);
        r14.recycle();
        this.dividerDrawable = new ShapeDrawable();
        setDividerColor(this.color);
        setOrientation(r13);
    }
}
