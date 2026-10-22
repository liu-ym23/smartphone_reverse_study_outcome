package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Constraints extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    b f13752a;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float aA;
        public float aB;
        public float aC;
        public float aD;
        public float aE;
        public float aF;
        public float aG;
        public float aH;
        public float aI;
        public float aJ;
        public float ax;
        public boolean ay;
        public float az;

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.ax = 1.0f;
            this.ay = false;
            this.az = 0.0f;
            this.aA = 0.0f;
            this.aB = 0.0f;
            this.aC = 0.0f;
            this.aD = 1.0f;
            this.aE = 1.0f;
            this.aF = 0.0f;
            this.aG = 0.0f;
            this.aH = 0.0f;
            this.aI = 0.0f;
            this.aJ = 0.0f;
        }

        public LayoutParams(Context r6, AttributeSet r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
            AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
            super(r8, r9);
            this.ax = 1.0f;
            int r1 = 0;
            this.ay = false;
            this.az = 0.0f;
            this.aA = 0.0f;
            this.aB = 0.0f;
            this.aC = 0.0f;
            this.aD = 1.0f;
            this.aE = 1.0f;
            this.aF = 0.0f;
            this.aG = 0.0f;
            this.aH = 0.0f;
            this.aI = 0.0f;
            this.aJ = 0.0f;
            TypedArray r10 = r8.obtainStyledAttributes(r9, R.styleable.ConstraintSet);
            int r11 = r10.getIndexCount();
        L3:
            if (r1 >= r11) goto L41;
            int r0 = r10.getIndex(r1);
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_alpha, "styleable", "ConstraintSet_android_alpha")) goto L8;
            this.ax = r10.getFloat(r0, this.ax);
        L40:
            r1 = r1 + 1;
            goto L3
        L8:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_elevation, "styleable", "ConstraintSet_android_elevation")) goto L11;
            this.az = r10.getFloat(r0, this.az);
            this.ay = true;
            goto L40
        L11:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotationX, "styleable", "ConstraintSet_android_rotationX")) goto L14;
            this.aB = r10.getFloat(r0, this.aB);
            goto L40
        L14:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotationY, "styleable", "ConstraintSet_android_rotationY")) goto L17;
            this.aC = r10.getFloat(r0, this.aC);
            goto L40
        L17:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_rotation, "styleable", "ConstraintSet_android_rotation")) goto L20;
            this.aA = r10.getFloat(r0, this.aA);
            goto L40
        L20:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_scaleX, "styleable", "ConstraintSet_android_scaleX")) goto L23;
            this.aD = r10.getFloat(r0, this.aD);
            goto L40
        L23:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_scaleY, "styleable", "ConstraintSet_android_scaleY")) goto L26;
            this.aE = r10.getFloat(r0, this.aE);
            goto L40
        L26:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_transformPivotX, "styleable", "ConstraintSet_android_transformPivotX")) goto L29;
            this.aF = r10.getFloat(r0, this.aF);
            goto L40
        L29:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_transformPivotY, "styleable", "ConstraintSet_android_transformPivotY")) goto L32;
            this.aG = r10.getFloat(r0, this.aG);
            goto L40
        L32:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationX, "styleable", "ConstraintSet_android_translationX")) goto L35;
            this.aH = r10.getFloat(r0, this.aH);
            goto L40
        L35:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationY, "styleable", "ConstraintSet_android_translationY")) goto L38;
            this.aI = r10.getFloat(r0, this.aI);
            goto L40
        L38:
            if (r0 != ZeusTransformUtils.mapRes(R.styleable.ConstraintSet_android_translationZ, "styleable", "ConstraintSet_android_translationZ")) goto L40;
            this.aJ = r10.getFloat(r0, this.aJ);
            goto L40
        L41:
            r10.recycle();
        }
    }

    public Constraints(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        super.setVisibility(8);
    }

    public Constraints(Context r3, AttributeSet r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        b();
        super.setVisibility(8);
    }

    public Constraints(Context r3, AttributeSet r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"), r5);
        b();
        super.setVisibility(8);
    }

    private void b() {
        Log.v(androidx.constraintlayout.widget.Constraints.TAG, " ################# init");
    }

    public LayoutParams a() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams a(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return a((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new ConstraintLayout.LayoutParams(r1);
    }

    public b getConstraintSet() {
        if (this.f13752a != null) goto L5;
        this.f13752a = new b();
    L5:
        this.f13752a.a(this);
        return this.f13752a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
    }
}
