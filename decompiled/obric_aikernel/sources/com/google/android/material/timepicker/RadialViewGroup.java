package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.j;
import q5.f;
import q5.h;
import q5.l;

/* JADX INFO: loaded from: classes2.dex */
class RadialViewGroup extends ConstraintLayout {
    private static final String SKIP_TAG = "skip";
    private MaterialShapeDrawable background;
    private int radius;
    private final Runnable updateLayoutParametersRunnable;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RadialViewGroup f4048c;

        a(RadialViewGroup r10) {
            this.f4048c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4048c.updateLayoutParams();
        }
    }

    public RadialViewGroup(@NonNull Context r10) {
        this(r10, null);
    }

    public RadialViewGroup(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, 0);
    }

    public RadialViewGroup(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        LayoutInflater.from(r10).inflate(h.material_radial_view_group, this);
        ViewCompat.setBackground(this, createBackground());
        TypedArray r13 = r10.obtainStyledAttributes(r11, l.RadialViewGroup, r12, 0);
        this.radius = r13.getDimensionPixelSize(l.RadialViewGroup_materialCircleRadius, 0);
        this.updateLayoutParametersRunnable = new a(this);
        r13.recycle();
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r10 = new MaterialShapeDrawable();
        this.background = r10;
        r10.setCornerSize(new j(0.5f));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        return this.background;
    }

    private static boolean shouldSkipView(View r10) {
        return SKIP_TAG.equals(r10.getTag());
    }

    private void updateLayoutParamsAsync() {
        Handler r10 = getHandler();
        if (r10 == null) goto L6;
        r10.removeCallbacks(this.updateLayoutParametersRunnable);
        r10.post(this.updateLayoutParametersRunnable);
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r10, int r11, ViewGroup.LayoutParams r12) {
        super.addView(r10, r11, r12);
        if (r10.getId() != (-1)) goto L5;
        r10.setId(ViewCompat.generateViewId());
    L5:
        updateLayoutParamsAsync();
    }

    @Dimension
    public int getRadius() {
        return this.radius;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r10) {
        super.onViewRemoved(r10);
        updateLayoutParamsAsync();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r10) {
        this.background.setFillColor(ColorStateList.valueOf(r10));
    }

    public void setRadius(@Dimension int r10) {
        this.radius = r10;
        updateLayoutParams();
    }

    protected void updateLayoutParams() {
        int r10 = getChildCount();
        int r11 = 0;
        int r12 = 1;
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L8;
        if (shouldSkipView(getChildAt(r13)) == false) goto L7;
        r12 = r12 + 1;
    L7:
        r13 = r13 + 1;
        goto L3
    L8:
        ConstraintSet r14 = new ConstraintSet();
        r14.clone(this);
        float r15 = 0.0f;
    L9:
        if (r11 >= r10) goto L17;
        View r16 = getChildAt(r11);
        int r17 = r16.getId();
        int r18 = f.circle_center;
        if (r17 == r18) goto L16;
        if (shouldSkipView(r16) == true) goto L16;
        r14.constrainCircle(r16.getId(), r18, this.radius, r15);
        r15 = r15 + (360.0f / (r10 - r12));
    L16:
        r11 = r11 + 1;
        goto L9
    L17:
        r14.applyTo(this);
    }
}
