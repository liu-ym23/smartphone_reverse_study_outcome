package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.obric.cae.R;
import j0.w;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class ClockFaceView extends c implements ClockHandView.a {
    public final ClockHandView D;
    public final Rect E;
    public final RectF F;
    public final Rect G;
    public final SparseArray<TextView> H;
    public final b I;
    public final int[] J;
    public final float[] K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public String[] P;
    public float Q;
    public final ColorStateList R;

    public ClockFaceView(Context r11, AttributeSet r12) {
        super(r11, r12, R.attr.materialClockStyle);
        this.E = new Rect();
        this.F = new RectF();
        this.G = new Rect();
        SparseArray<TextView> r8 = new SparseArray();
        this.H = r8;
        this.K = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray r13 = r11.obtainStyledAttributes(r12, g9.a.f7764e, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources r10 = getResources();
        ColorStateList r14 = x9.c.a(r11, r13, 1);
        this.R = r14;
        LayoutInflater.from(r11).inflate(R.layout.material_clockface_view, this, true);
        ClockHandView r15 = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.D = r15;
        this.L = r10.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int r16 = r14.getColorForState(new int[]{android.R.attr.state_selected}, r14.getDefaultColor());
        this.J = new int[]{r16, r16, r14.getDefaultColor()};
        r15.f5138m.add(this);
        int r17 = androidx.core.content.a.b(r11, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList r18 = x9.c.a(r11, r13, 0);
        if (r18 == null) goto L6;
        r17 = r18.getDefaultColor();
    L6:
        setBackgroundColor(r17);
        getViewTreeObserver().addOnPreDrawListener(new a(this));
        setFocusable(true);
        r13.recycle();
        this.I = new b(this);
        String[] r19 = new String[12];
        Arrays.fill(r19, "");
        this.P = r19;
        LayoutInflater r110 = LayoutInflater.from(getContext());
        int r111 = r8.size();
        int r20 = 0;
        boolean r21 = false;
    L8:
        if (r20 >= Math.max(this.P.length, r111)) goto L19;
        TextView r22 = r8.get(r20);
        if (r20 < this.P.length) goto L12;
        removeView(r22);
        r8.remove(r20);
    L18:
        r20 = r20 + 1;
        goto L8
    L12:
        if (r22 != null) goto L14;
        r22 = (TextView) r110.inflate(R.layout.material_clockface_textview, this, false);
        r8.put(r20, r22);
        addView(r22);
    L14:
        r22.setText(this.P[r20]);
        r22.setTag(R.id.material_value_index, Integer.valueOf(r20));
        int r23 = (r20 / 12) + 1;
        r22.setTag(R.id.material_clock_level, Integer.valueOf(r23));
        if (r23 <= 1) goto L17;
        r21 = true;
    L17:
        w.m(r22, this.I);
        r22.setTextColor(this.R);
        goto L18
    L19:
        ClockHandView r112 = this.D;
        if (r112.f5137b == false) goto L23;
        if (r21 == true) goto L23;
        r112.f5148w = 1;
    L23:
        r112.f5137b = r21;
        r112.invalidate();
        this.M = r10.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.N = r10.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.O = r10.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.a
    public final void a(float r8) {
        if (Math.abs(this.Q - r8) <= 0.001f) goto L6;
        this.Q = r8;
        t();
        return;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo r8) {
        super.onInitializeAccessibilityNodeInfo(r8);
        new k0.f(r8).g(new k0.f.b(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.P.length, false, 1)));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r8, int r10) {
        DisplayMetrics r11 = getResources().getDisplayMetrics();
        int r12 = (int) (this.O / Math.max(Math.max(this.M / r11.heightPixels, this.N / r11.widthPixels), 1.0f));
        int r13 = View.MeasureSpec.makeMeasureSpec(r12, 1073741824);
        setMeasuredDimension(r12, r12);
        super.onMeasure(r13, r13);
    }

    @Override // com.google.android.material.timepicker.c
    public final void s() {
        super.s();
        int r8 = 0;
    L3:
        SparseArray<TextView> r10 = this.H;
        if (r8 >= r10.size()) goto L6;
        r10.get(r8).setVisibility(0);
        r8 = r8 + 1;
        goto L3
    }

    public final void t() {
        RectF r8 = this.D.f5142q;
        float r10 = Float.MAX_VALUE;
        TextView r11 = null;
        int r12 = 0;
    L3:
        SparseArray<TextView> r13 = this.H;
        int r14 = r13.size();
        RectF r15 = this.F;
        Rect r16 = this.E;
        if (r12 >= r14) goto L12;
        TextView r17 = r13.get(r12);
        if (r17 == null) goto L11;
        r17.getHitRect(r16);
        r15.set(r16);
        r15.union(r8);
        float r18 = r15.height() * r15.width();
        if (r18 >= r10) goto L11;
        r11 = r17;
        r10 = r18;
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        int r19 = 0;
    L14:
        if (r19 >= r13.size()) goto L27;
        TextView r20 = r13.get(r19);
        if (r20 == null) goto L26;
        if (r20 != r11) goto L20;
        boolean r21 = true;
    L21:
        r20.setSelected(r21);
        r20.getHitRect(r16);
        r15.set(r16);
        Rect r22 = this.G;
        r20.getLineBounds(0, r22);
        r15.inset(r22.left, r22.top);
        if (RectF.intersects(r8, r15) == true) goto L24;
        RadialGradient r23 = null;
    L25:
        r20.getPaint().setShader(r23);
        r20.invalidate();
        goto L26
    L24:
        r23 = new RadialGradient(r8.centerX() - r15.left, r8.centerY() - r15.top, 0.5f * r8.width(), this.J, this.K, Shader.TileMode.CLAMP);
        goto L25
    L20:
        r21 = false;
    L26:
        r19 = r19 + 1;
        goto L14
    }
}
