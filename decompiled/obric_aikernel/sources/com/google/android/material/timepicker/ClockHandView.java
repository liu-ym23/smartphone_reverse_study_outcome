package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes2.dex */
class ClockHandView extends View {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ValueAnimator f4027c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f4029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f4030i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f4031j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f4032k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<d> f4033l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f4034m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final float f4035n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Paint f4036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final RectF f4037p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Px
    private final int f4038q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f4039r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f4040s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private c f4041t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private double f4042u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f4043v;

    class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ClockHandView f4044c;

        a(ClockHandView r10) {
            this.f4044c = r10;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            ClockHandView.a(this.f4044c, r11, true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b(ClockHandView r10) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            r10.end();
        }
    }

    public interface c {
        void a(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11);
    }

    public interface d {
        void onRotate(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11);
    }

    public ClockHandView(Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, q5.b.materialClockStyle);
    }

    public ClockHandView(Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f4033l = new ArrayList();
        Paint r13 = new Paint();
        this.f4036o = r13;
        this.f4037p = new RectF();
        TypedArray r14 = r10.obtainStyledAttributes(r11, l.ClockHandView, r12, k.Widget_MaterialComponents_TimePicker_Clock);
        this.f4043v = r14.getDimensionPixelSize(l.ClockHandView_materialCircleRadius, 0);
        this.f4034m = r14.getDimensionPixelSize(l.ClockHandView_selectorSize, 0);
        Resources r15 = getResources();
        this.f4038q = r15.getDimensionPixelSize(q5.d.material_clock_hand_stroke_width);
        this.f4035n = r15.getDimensionPixelSize(q5.d.material_clock_hand_center_dot_radius);
        int r16 = r14.getColor(l.ClockHandView_clockHandColor, 0);
        r13.setAntiAlias(true);
        r13.setColor(r16);
        l(0.0f);
        this.f4032k = ViewConfiguration.get(r10).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        r14.recycle();
    }

    static /* synthetic */ void a(ClockHandView r10, float r11, boolean r12) {
        r10.n(r11, r12);
    }

    private void c(Canvas r11) {
        int r10 = getHeight() / 2;
        int r12 = getWidth() / 2;
        float r13 = r12;
        float r14 = (this.f4043v * ((float) Math.cos(this.f4042u))) + r13;
        float r15 = r10;
        float r16 = (this.f4043v * ((float) Math.sin(this.f4042u))) + r15;
        this.f4036o.setStrokeWidth(0.0f);
        r11.drawCircle(r14, r16, this.f4034m, this.f4036o);
        double r17 = Math.sin(this.f4042u);
        double r18 = Math.cos(this.f4042u);
        double r19 = this.f4043v - this.f4034m;
        this.f4036o.setStrokeWidth(this.f4038q);
        r11.drawLine(r13, r15, r12 + ((int) (r18 * r19)), r10 + ((int) (r19 * r17)), this.f4036o);
        r11.drawCircle(r13, r15, this.f4035n, this.f4036o);
    }

    private int e(float r10, float r11) {
        int r12 = getWidth() / 2;
        int r13 = ((int) Math.toDegrees(Math.atan2(r11 - (getHeight() / 2), r10 - r12))) + 90;
        if (r13 < 0) goto L5;
        return r13;
    L5:
        return r13 + 360;
    }

    private Pair<Float, Float> h(float r10) {
        float r11 = f();
        if (Math.abs(r11 - r10) <= 180.0f) goto L15;
        if (r11 <= 180.0f) goto L10;
        if (r10 >= 180.0f) goto L10;
        r10 = r10 + 360.0f;
    L10:
        if (r11 >= 180.0f) goto L15;
        if (r10 <= 180.0f) goto L15;
        r11 = r11 + 360.0f;
    L15:
        return new Pair(Float.valueOf(r11), Float.valueOf(r10));
    }

    private boolean i(float r10, float r11, boolean r12, boolean r13, boolean r14) {
        float r15 = e(r10, r11);
        boolean r16 = false;
        if (f() == r15) goto L5;
        boolean r17 = true;
    L6:
        if (r13 == false) goto L9;
        if (r17 == false) goto L9;
        return true;
    L9:
        if (r17 == true) goto L13;
        if (r12 == true) goto L13;
        return false;
    L13:
        if (r14 == true) goto L15;
    L17:
        m(r15, r16);
        return true;
    L15:
        if (this.f4028g == false) goto L17;
        r16 = true;
        goto L17
    L5:
        r17 = false;
        goto L6
    }

    private void n(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11) {
        float r12 = r10 % 360.0f;
        this.f4039r = r12;
        this.f4042u = Math.toRadians(r12 - 90.0f);
        int r13 = getHeight() / 2;
        float r14 = (getWidth() / 2) + (this.f4043v * ((float) Math.cos(this.f4042u)));
        float r15 = r13 + (this.f4043v * ((float) Math.sin(this.f4042u)));
        RectF r16 = this.f4037p;
        int r17 = this.f4034m;
        r16.set(r14 - r17, r15 - r17, r14 + r17, r15 + r17);
        Iterator<d> r18 = this.f4033l.iterator();
    L4:
        if (r18.hasNext() == false) goto L6;
        r18.next().onRotate(r12, r11);
        goto L4
    L6:
        invalidate();
    }

    public void b(d r10) {
        this.f4033l.add(r10);
    }

    public RectF d() {
        return this.f4037p;
    }

    @FloatRange(from = 0.0d, to = 360.0d)
    public float f() {
        return this.f4039r;
    }

    public int g() {
        return this.f4034m;
    }

    public void j(boolean r10) {
        this.f4028g = r10;
    }

    public void k(@Dimension int r10) {
        this.f4043v = r10;
        invalidate();
    }

    public void l(@FloatRange(from = 0.0d, to = 360.0d) float r10) {
        m(r10, false);
    }

    public void m(@FloatRange(from = 0.0d, to = 360.0d) float r10, boolean r11) {
        ValueAnimator r12 = this.f4027c;
        if (r12 == null) goto L6;
        r12.cancel();
    L6:
        if (r11 == true) goto L9;
        n(r10, false);
        return;
    L9:
        Pair<Float, Float> r13 = h(r10);
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{((Float) r13.first).floatValue(), ((Float) r13.second).floatValue()});
        this.f4027c = r14;
        r14.setDuration(200);
        this.f4027c.addUpdateListener(new a(this));
        this.f4027c.addListener(new b(this));
        this.f4027c.start();
    }

    public void o(c r10) {
        this.f4041t = r10;
    }

    @Override // android.view.View
    protected void onDraw(Canvas r10) {
        super.onDraw(r10);
        c(r10);
    }

    @Override // android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        l(f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent r11) {
        int r10 = r11.getActionMasked();
        float r12 = r11.getX();
        float r13 = r11.getY();
        if (r10 == 0) goto L17;
        if (r10 != 1) goto L6;
    L8:
        int r14 = (int) (r12 - this.f4029h);
        int r15 = (int) (r13 - this.f4030i);
        if (((r14 * r14) + (r15 * r15)) <= this.f4032k) goto L11;
        boolean r16 = true;
    L12:
        this.f4031j = r16;
        boolean r17 = this.f4040s;
        if (r10 != 1) goto L15;
        boolean r18 = true;
    L16:
        boolean r19 = false;
        boolean r20 = r17;
    L18:
        boolean r21 = i(r12, r13, r20, r19, r18) | this.f4040s;
        this.f4040s = r21;
        if (r21 == false) goto L24;
        if (r18 == false) goto L24;
        c r22 = this.f4041t;
        if (r22 == null) goto L24;
        r22.a(e(r12, r13), this.f4031j);
    L24:
        return true;
    L15:
        r18 = false;
        goto L16
    L11:
        r16 = false;
        goto L12
    L6:
        if (r10 == 2) goto L8;
        r18 = false;
        r20 = false;
        r19 = false;
        goto L18
    L17:
        this.f4029h = r12;
        this.f4030i = r13;
        this.f4031j = true;
        this.f4040s = false;
        r18 = false;
        r20 = false;
        r19 = true;
        goto L18
    }
}
