package com.obric.oui.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import lr.g;

/* JADX INFO: loaded from: classes3.dex */
public class Constraints extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f13036a;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public final float A0;
        public final float B0;
        public final float C0;
        public final float D0;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public final float f13037r0;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public final boolean f13038s0;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public final float f13039t0;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public final float f13040u0;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public final float f13041v0;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public final float f13042w0;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public final float f13043x0;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public final float f13044y0;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public final float f13045z0;

        public LayoutParams() {
            super(-2, -2);
            this.f13037r0 = 1.0f;
            this.f13038s0 = false;
            this.f13039t0 = 0.0f;
            this.f13040u0 = 0.0f;
            this.f13041v0 = 0.0f;
            this.f13042w0 = 0.0f;
            this.f13043x0 = 1.0f;
            this.f13044y0 = 1.0f;
            this.f13045z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
        }

        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
            this.f13037r0 = 1.0f;
            int r11 = 0;
            this.f13038s0 = false;
            this.f13039t0 = 0.0f;
            this.f13040u0 = 0.0f;
            this.f13041v0 = 0.0f;
            this.f13042w0 = 0.0f;
            this.f13043x0 = 1.0f;
            this.f13044y0 = 1.0f;
            this.f13045z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            TypedArray r12 = r5.obtainStyledAttributes(r10, R$styleable.ConstraintSet);
            int r13 = r12.getIndexCount();
        L3:
            if (r11 >= r13) goto L41;
            int r14 = r12.getIndex(r11);
            if (r14 != R$styleable.ConstraintSet_android_alpha) goto L8;
            this.f13037r0 = r12.getFloat(r14, this.f13037r0);
        L40:
            r11 = r11 + 1;
            goto L3
        L8:
            if (r14 != R$styleable.ConstraintSet_android_elevation) goto L11;
            this.f13039t0 = r12.getFloat(r14, this.f13039t0);
            this.f13038s0 = true;
            goto L40
        L11:
            if (r14 != R$styleable.ConstraintSet_android_rotationX) goto L14;
            this.f13041v0 = r12.getFloat(r14, this.f13041v0);
            goto L40
        L14:
            if (r14 != R$styleable.ConstraintSet_android_rotationY) goto L17;
            this.f13042w0 = r12.getFloat(r14, this.f13042w0);
            goto L40
        L17:
            if (r14 != R$styleable.ConstraintSet_android_rotation) goto L20;
            this.f13040u0 = r12.getFloat(r14, this.f13040u0);
            goto L40
        L20:
            if (r14 != R$styleable.ConstraintSet_android_scaleX) goto L23;
            this.f13043x0 = r12.getFloat(r14, this.f13043x0);
            goto L40
        L23:
            if (r14 != R$styleable.ConstraintSet_android_scaleY) goto L26;
            this.f13044y0 = r12.getFloat(r14, this.f13044y0);
            goto L40
        L26:
            if (r14 != R$styleable.ConstraintSet_android_transformPivotX) goto L29;
            this.f13045z0 = r12.getFloat(r14, this.f13045z0);
            goto L40
        L29:
            if (r14 != R$styleable.ConstraintSet_android_transformPivotY) goto L32;
            this.A0 = r12.getFloat(r14, this.A0);
            goto L40
        L32:
            if (r14 != R$styleable.ConstraintSet_android_translationX) goto L35;
            this.B0 = r12.getFloat(r14, this.B0);
            goto L40
        L35:
            if (r14 != R$styleable.ConstraintSet_android_translationY) goto L38;
            this.C0 = r12.getFloat(r14, this.C0);
            goto L40
        L38:
            if (r14 != R$styleable.ConstraintSet_android_translationZ) goto L40;
            this.D0 = r12.getFloat(r14, this.D0);
            goto L40
        L41:
            r12.recycle();
        }
    }

    public Constraints(Context r5) {
        super(r5);
        super.setVisibility(8);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    public d getConstraintSet() {
        if (this.f13036a != null) goto L5;
        this.f13036a = new d();
    L5:
        d r5 = this.f13036a;
        r5.getClass();
        int r10 = getChildCount();
        HashMap r11 = r5.g;
        r11.clear();
        int r12 = 0;
    L6:
        if (r12 >= r10) goto L28;
        View r13 = getChildAt(r12);
        LayoutParams r14 = (LayoutParams) r13.getLayoutParams();
        int r15 = r13.getId();
        if (r5.f == false) goto L15;
        if (r15 != (-1)) goto L15;
        throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    L15:
        if (r11.containsKey(Integer.valueOf(r15)) == true) goto L17;
        r11.put(Integer.valueOf(r15), new c());
    L17:
        c r16 = (c) r11.get(Integer.valueOf(r15));
        if (r16 == null) goto L26;
        if ((r13 instanceof ConstraintHelper) == false) goto L25;
        ConstraintHelper r17 = (ConstraintHelper) r13;
        r16.d(r15, r14);
        if ((r17 instanceof Barrier) == false) goto L25;
        g r18 = r16.e;
        r18.i0 = 1;
        Barrier r19 = (Barrier) r17;
        r18.g0 = r19.getType();
        r18.f19728j0 = r19.getReferencedIds();
        r18.f19725h0 = r19.getMargin();
    L25:
        r16.d(r15, r14);
    L26:
        r12 = r12 + 1;
        goto L6
    L28:
        return this.f13036a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new ConstraintLayout.LayoutParams(r5);
    }

    public Constraints(Context r5, AttributeSet r10) {
        super(r5, r10);
        Log.v(androidx.constraintlayout.widget.Constraints.TAG, " ################# init");
        super.setVisibility(8);
    }

    public Constraints(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        Log.v(androidx.constraintlayout.widget.Constraints.TAG, " ################# init");
        super.setVisibility(8);
    }
}
