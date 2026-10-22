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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.j;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class RadialViewGroup extends ConstraintLayout {
    private static final String SKIP_TAG = "skip";
    private MaterialShapeDrawable background;
    private int radius;
    private final Runnable updateLayoutParametersRunnable;

    public RadialViewGroup(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public RadialViewGroup(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), 0);
    }

    public RadialViewGroup(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r9, r10, r8);
        ZeusTransformUtils.inflate(LayoutInflater.from(r9), ZeusTransformUtils.mapRes(R.layout.material_radial_view_group, "layout", "material_radial_view_group"), this, "com.obric.memorydata.plugin");
        ViewCompat.setBackground(this, createBackground());
        TypedArray r11 = r9.obtainStyledAttributes(r10, R.styleable.RadialViewGroup, r8, 0);
        this.radius = r11.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.RadialViewGroup_materialCircleRadius, "styleable", "RadialViewGroup_materialCircleRadius"), 0);
        this.updateLayoutParametersRunnable = new AnonymousClass1(this);
        r11.recycle();
    }

    private Drawable createBackground() {
        MaterialShapeDrawable r0 = new MaterialShapeDrawable();
        this.background = r0;
        r0.setCornerSize(new j(0.5f));
        this.background.setFillColor(ColorStateList.valueOf(-1));
        return this.background;
    }

    private static boolean shouldSkipView(View r1) {
        return SKIP_TAG.equals(r1.getTag());
    }

    private void updateLayoutParamsAsync() {
        Handler r0 = getHandler();
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.updateLayoutParametersRunnable);
        r0.post(this.updateLayoutParametersRunnable);
        return;
    }

    @Override // android.view.ViewGroup
    public void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        super.addView(r1, r2, r3);
        if (r1.getId() != (-1)) goto L5;
        r1.setId(ViewCompat.generateViewId());
    L5:
        updateLayoutParamsAsync();
    }

    public int getRadius() {
        return this.radius;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        updateLayoutParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View r1) {
        super.onViewRemoved(r1);
        updateLayoutParamsAsync();
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        this.background.setFillColor(ColorStateList.valueOf(r1));
    }

    public void setRadius(int r1) {
        this.radius = r1;
        updateLayoutParams();
    }

    public void updateLayoutParams() {
        int r0 = getChildCount();
        int r1 = 0;
        int r2 = 1;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L8;
        if (shouldSkipView(getChildAt(r3)) == false) goto L7;
        r2 = r2 + 1;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        ConstraintSet r4 = new ConstraintSet();
        r4.clone(this);
        float r5 = 0.0f;
    L9:
        if (r1 >= r0) goto L17;
        View r6 = getChildAt(r1);
        if (r6.getId() == ZeusTransformUtils.mapRes(R.id.circle_center, OaidModel.KEY_ID, "circle_center")) goto L16;
        if (shouldSkipView(r6) == true) goto L16;
        r4.constrainCircle(r6.getId(), ZeusTransformUtils.mapRes(R.id.circle_center, OaidModel.KEY_ID, "circle_center"), this.radius, r5);
        r5 = r5 + (360.0f / (r0 - r2));
    L16:
        r1 = r1 + 1;
        goto L9
    L17:
        r4.applyTo(this);
    }
}
