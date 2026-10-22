package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.obric.cae.R;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator f5136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5137b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList f5138m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f5139n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f5140o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Paint f5141p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RectF f5142q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f5143r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f5144s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f5145t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public double f5146u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f5147v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5148w;

    public interface a {
        void a(float r8);
    }

    public ClockHandView(Context r8, AttributeSet r10) {
        super(r8, r10, R.attr.materialClockStyle);
        this.f5136a = new ValueAnimator();
        this.f5138m = new ArrayList();
        Paint r11 = new Paint();
        this.f5141p = r11;
        this.f5142q = new RectF();
        this.f5148w = 1;
        TypedArray r12 = r8.obtainStyledAttributes(r10, g9.a.f7765f, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        v9.d.c(r8, R.attr.motionDurationLong2, 200);
        v9.d.d(r8, R.attr.motionEasingEmphasizedInterpolator, h9.a.f7944b);
        this.f5147v = r12.getDimensionPixelSize(1, 0);
        this.f5139n = r12.getDimensionPixelSize(2, 0);
        Resources r13 = getResources();
        this.f5143r = r13.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f5140o = r13.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int r14 = r12.getColor(0, 0);
        r11.setAntiAlias(true);
        r11.setColor(r14);
        a(0.0f);
        ViewConfiguration.get(r8).getScaledTouchSlop();
        WeakHashMap<View, h0> r15 = w.f8437a;
        w.d.s(this, 2);
        r12.recycle();
    }

    public final void a(float r8) {
        ValueAnimator r10 = this.f5136a;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        b(r8, false);
    }

    public final void b(float r8, boolean r10) {
        float r11 = r8 % 360.0f;
        this.f5144s = r11;
        this.f5146u = Math.toRadians(r11 - 90.0f);
        int r12 = getHeight() / 2;
        int r13 = getWidth() / 2;
        int r14 = this.f5148w;
        int r15 = this.f5147v;
        if (r14 != 2) goto L5;
        r15 = Math.round(r15 * 0.66f);
    L5:
        float r16 = r13;
        float r17 = r15;
        float r18 = (((float) Math.cos(this.f5146u)) * r17) + r16;
        float r19 = (r17 * ((float) Math.sin(this.f5146u))) + r12;
        float r20 = this.f5139n;
        this.f5142q.set(r18 - r20, r19 - r20, r18 + r20, r19 + r20);
        Iterator r21 = this.f5138m.iterator();
    L7:
        if (r21.hasNext() == false) goto L9;
        ((a) r21.next()).a(r11);
        goto L7
    L9:
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        super.onDraw(r14);
        int r8 = getHeight() / 2;
        int r10 = getWidth() / 2;
        int r11 = this.f5148w;
        int r12 = this.f5147v;
        if (r11 != 2) goto L5;
        r12 = Math.round(r12 * 0.66f);
    L5:
        float r13 = r10;
        float r15 = r12;
        float r16 = (((float) Math.cos(this.f5146u)) * r15) + r13;
        float r17 = r8;
        float r18 = (r15 * ((float) Math.sin(this.f5146u))) + r17;
        Paint r19 = this.f5141p;
        r19.setStrokeWidth(0.0f);
        int r20 = this.f5139n;
        r14.drawCircle(r16, r18, r20, r19);
        double r21 = Math.sin(this.f5146u);
        double r22 = r12 - r20;
        r19.setStrokeWidth(this.f5143r);
        r14.drawLine(r13, r17, r10 + ((int) (Math.cos(this.f5146u) * r22)), r8 + ((int) (r22 * r21)), r19);
        r14.drawCircle(r13, r17, this.f5140o, r19);
    }

    @Override // android.view.View
    public final void onLayout(boolean r8, int r10, int r11, int r12, int r13) {
        super.onLayout(r8, r10, r11, r12, r13);
        if (this.f5136a.isRunning() == true) goto L6;
        a(this.f5144s);
        return;
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent r10) {
        int r8 = r10.getActionMasked();
        float r11 = r10.getX();
        float r12 = r10.getY();
        boolean r13 = false;
        if (r8 == 0) goto L15;
        if (r8 == 1) goto L7;
        if (r8 == 2) goto L7;
        boolean r14 = false;
        boolean r15 = false;
    L16:
        boolean r16 = this.f5145t;
        int r17 = ((int) Math.toDegrees(Math.atan2(r12 - (getHeight() / 2), r11 - (getWidth() / 2)))) + 90;
        if (r17 >= 0) goto L19;
        r17 = r17 + 360;
    L19:
        float r18 = r17;
        if (this.f5144s == r18) goto L22;
        boolean r19 = true;
    L23:
        if (r15 == false) goto L26;
        if (r19 == false) goto L26;
    L29:
        r13 = true;
    L30:
        this.f5145t = r16 | r13;
        return true;
    L26:
        if (r19 == true) goto L28;
        if (r14 == false) goto L30;
    L28:
        a(r18);
        goto L29
    L22:
        r19 = false;
    L7:
        r14 = this.f5145t;
        if (this.f5137b == true) goto L10;
    L14:
        r15 = false;
        goto L16
    L10:
        if (((float) Math.hypot(r11 - (getWidth() / 2), r12 - (getHeight() / 2))) > (Math.round(this.f5147v * 0.66f) + TypedValue.applyDimension(1, 12, getContext().getResources().getDisplayMetrics()))) goto L12;
        int r20 = 2;
    L13:
        this.f5148w = r20;
        goto L14
    L12:
        r20 = 1;
        goto L13
    L15:
        this.f5145t = false;
        r15 = true;
        r14 = false;
        goto L16
    }
}
