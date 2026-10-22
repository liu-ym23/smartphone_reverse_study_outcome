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
import com.google.android.material.R;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RelativeCornerSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
class RadialViewGroup extends ConstraintLayout {
    static final int LEVEL_1 = 1;
    static final int LEVEL_2 = 2;
    static final float LEVEL_RADIUS_RATIO = 0.66f;
    private static final String SKIP_TAG = "skip";
    private MaterialShapeDrawable background;
    private int radius;
    private final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(@NonNull Context r5) {
        this(r5, null);
    }

    private void addConstraints(List<View> r5, ConstraintSet r10, int r11) {
        Iterator<View> r12 = r5.iterator();
        float r13 = 0.0f;
    L4:
        if (r12.hasNext() == false) goto L6;
        r10.constrainCircle(r12.next().getId(), R.id.circle_center, r11, r13);
        r13 = r13 + (360.0f / r5.size());
        goto L4
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r5 = new MaterialShapeDrawable();
        this.background = r5;
        r5.setCornerSize(new RelativeCornerSize(0.5f));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        return this.background;
    }

    private static boolean shouldSkipView(View r5) {
        return SKIP_TAG.equals(r5.getTag());
    }

    private void updateLayoutParamsAsync() {
        Handler r5 = getHandler();
        if (r5 == null) goto L6;
        r5.removeCallbacks(this.updateLayoutParametersRunnable);
        r5.post(this.updateLayoutParametersRunnable);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        super.addView(r5, r10, r11);
        if (r5.getId() != (-1)) goto L5;
        r5.setId(ViewCompat.generateViewId());
    L5:
        updateLayoutParamsAsync();
    }

    @Dimension
    public int getLeveledRadius(int r5) {
        int r10 = this.radius;
        if (r5 == 2) goto L5;
        return r10;
    L5:
        return Math.round(r10 * LEVEL_RADIUS_RATIO);
    }

    @Dimension
    public int getRadius() {
        return this.radius;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r5) {
        super.onViewRemoved(r5);
        updateLayoutParamsAsync();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int r5) {
        this.background.setFillColor(ColorStateList.valueOf(r5));
    }

    public void setRadius(@Dimension int r5) {
        this.radius = r5;
        updateLayoutParams();
    }

    public void updateLayoutParams() {
        ConstraintSet r5 = new ConstraintSet();
        r5.clone(this);
        HashMap r10 = new HashMap();
        int r11 = 0;
    L4:
        if (r11 >= getChildCount()) goto L18;
        View r12 = getChildAt(r11);
        if (r12.getId() == R.id.circle_center) goto L17;
        if (shouldSkipView(r12) == true) goto L17;
        int r13 = (Integer) r12.getTag(R.id.material_clock_level);
        if (r13 != null) goto L14;
        r13 = 1;
    L14:
        if (r10.containsKey(r13) == true) goto L16;
        r10.put(r13, new ArrayList());
    L16:
        ((List) r10.get(r13)).add(r12);
    L17:
        r11 = r11 + 1;
        goto L4
    L18:
        Iterator r14 = r10.entrySet().iterator();
    L20:
        if (r14.hasNext() == false) goto L22;
        Map.Entry r15 = (Map.Entry) r14.next();
        addConstraints((List) r15.getValue(), r5, getLeveledRadius(((Integer) r15.getKey()).intValue()));
        goto L20
    L22:
        r5.applyTo(this);
    }

    public RadialViewGroup(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public RadialViewGroup(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        LayoutInflater.from(r5).inflate(R.layout.material_radial_view_group, this);
        ViewCompat.setBackground(this, createBackground());
        TypedArray r12 = r5.obtainStyledAttributes(r10, R.styleable.RadialViewGroup, r11, 0);
        this.radius = r12.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.updateLayoutParametersRunnable = new b(this, 0);
        r12.recycle();
    }
}
