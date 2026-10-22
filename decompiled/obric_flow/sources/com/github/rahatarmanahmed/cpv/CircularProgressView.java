package com.github.rahatarmanahmed.cpv;

import ai.j0;
import android.R;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.obric.launcher.widget.R$bool;
import com.obric.launcher.widget.R$color;
import com.obric.launcher.widget.R$dimen;
import com.obric.launcher.widget.R$integer;
import com.obric.launcher.widget.R$styleable;
import com.obric.oui.orecyclerview.widget.j;
import el.a;
import el.b;
import java.util.ArrayList;
import java.util.Iterator;
import mn.h;

/* JADX INFO: loaded from: classes2.dex */
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f8493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f8495c;
    public boolean d;
    public boolean e;
    public float f;
    public float g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f8496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f8497i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8498j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f8499k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f8500l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8501m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8502n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8503o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f8504p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f8505q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f8506r;
    public ValueAnimator s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ValueAnimator f8507t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public AnimatorSet f8508u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f8509v;

    public CircularProgressView(Context r5) {
        super(r5);
        this.f8494b = 0;
        b(null, 0);
    }

    public final void a() {
        int r5 = 1;
        ValueAnimator r10 = this.s;
        if (r10 != null) goto L5;
    L7:
        ValueAnimator r11 = this.f8507t;
        if (r11 != null) goto L10;
    L12:
        AnimatorSet r12 = this.f8508u;
        if (r12 != null) goto L15;
    L17:
        float r13 = 360.0f;
        if (this.d == true) goto L21;
        float r14 = this.f8509v;
        this.f8505q = r14;
        ValueAnimator r15 = ValueAnimator.ofFloat(new float[]{r14, 360.0f + r14});
        this.s = r15;
        r15.setDuration(this.f8501m);
        this.s.setInterpolator(new DecelerateInterpolator(2.0f));
        this.s.addUpdateListener(new a(this, 1));
        this.s.start();
        this.f8506r = 0.0f;
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, this.f});
        this.f8507t = r16;
        r16.setDuration(this.f8502n);
        this.f8507t.setInterpolator(new LinearInterpolator());
        this.f8507t.addUpdateListener(new a(this, 2));
        this.f8507t.start();
        return;
    L21:
        float r17 = 15.0f;
        this.f8496h = 15.0f;
        this.f8508u = new AnimatorSet();
        AnimatorSet r18 = null;
        int r19 = 0;
    L22:
        int r20 = this.f8503o;
        if (r19 >= r20) goto L28;
        float r21 = r19;
        float r110 = (((r20 - 1) * r13) / r20) + r17;
        float r22 = j0.b(r110, r17, r21, -90.0f);
        float[] r111 = new float[2];
        r111[0] = r17;
        r111[r5] = r110;
        ValueAnimator r112 = ValueAnimator.ofFloat(r111);
        r112.setDuration((this.f8500l / this.f8503o) / 2);
        r112.setInterpolator(new DecelerateInterpolator(1.0f));
        r112.addUpdateListener(new a(this, 3));
        float r113 = this.f8503o;
        float r114 = (r21 + 0.5f) * 720.0f;
        float[] r23 = new float[2];
        r23[0] = (r21 * 720.0f) / r113;
        r23[r5] = r114 / r113;
        ValueAnimator r24 = ValueAnimator.ofFloat(r23);
        r24.setDuration((this.f8500l / this.f8503o) / 2);
        r24.setInterpolator(new LinearInterpolator());
        r24.addUpdateListener(new a(this, 4));
        float[] r115 = new float[2];
        r115[0] = r22;
        r115[r5] = (r22 + r110) - r17;
        ValueAnimator r116 = ValueAnimator.ofFloat(r115);
        r116.setDuration((this.f8500l / this.f8503o) / 2);
        r116.setInterpolator(new DecelerateInterpolator(1.0f));
        r116.addUpdateListener(new b(this, r110, r22));
        float r25 = this.f8503o;
        ValueAnimator r26 = ValueAnimator.ofFloat(new float[]{r114 / r25, ((r21 + 1.0f) * 720.0f) / r25});
        r26.setDuration((this.f8500l / this.f8503o) / 2);
        r26.setInterpolator(new LinearInterpolator());
        r26.addUpdateListener(new a(this, 5));
        AnimatorSet r27 = new AnimatorSet();
        r27.play(r112).with(r24);
        r27.play(r116).with(r26).after(r24);
        AnimatorSet.Builder r28 = this.f8508u.play(r27);
        if (r18 == null) goto L27;
        r28.after(r18);
    L27:
        r5 = 1;
        r19 = r19 + 1;
        r18 = r27;
        r17 = 15.0f;
        r13 = 360.0f;
        goto L22
    L28:
        this.f8508u.addListener(new j(this, r5));
        this.f8508u.start();
        Iterator r29 = this.f8504p.iterator();
        if (r29.hasNext() == true) goto L32;
        return;
    L32:
        throw h.c(r29);
    L15:
        if (r12.isRunning() == false) goto L17;
        this.f8508u.cancel();
        goto L17
    L10:
        if (r11.isRunning() == false) goto L12;
        this.f8507t.cancel();
        goto L12
    L5:
        if (r10.isRunning() == false) goto L7;
        this.s.cancel();
        goto L7
    }

    public final void b(AttributeSet r10, int r11) {
        this.f8504p = new ArrayList();
        TypedArray r12 = getContext().obtainStyledAttributes(r10, R$styleable.CircularProgressView, r11, 0);
        Resources r13 = getResources();
        this.f = r12.getFloat(R$styleable.CircularProgressView_cpv_progress, r13.getInteger(R$integer.cpv_default_progress));
        this.g = r12.getFloat(R$styleable.CircularProgressView_cpv_maxProgress, r13.getInteger(R$integer.cpv_default_max_progress));
        this.f8498j = r12.getDimensionPixelSize(R$styleable.CircularProgressView_cpv_thickness, r13.getDimensionPixelSize(R$dimen.cpv_default_thickness));
        this.d = r12.getBoolean(R$styleable.CircularProgressView_cpv_indeterminate, r13.getBoolean(R$bool.cpv_default_is_indeterminate));
        this.e = r12.getBoolean(R$styleable.CircularProgressView_cpv_animAutostart, r13.getBoolean(R$bool.cpv_default_anim_autostart));
        float r5 = r12.getFloat(R$styleable.CircularProgressView_cpv_startAngle, r13.getInteger(R$integer.cpv_default_start_angle));
        this.f8509v = r5;
        this.f8505q = r5;
        int r14 = getContext().getResources().getIdentifier("colorAccent", "attr", getContext().getPackageName());
        if (r12.hasValue(R$styleable.CircularProgressView_cpv_color) == false) goto L5;
        this.f8499k = r12.getColor(R$styleable.CircularProgressView_cpv_color, r13.getColor(R$color.cpv_default_color));
    L8:
        this.f8500l = r12.getInteger(R$styleable.CircularProgressView_cpv_animDuration, r13.getInteger(R$integer.cpv_default_anim_duration));
        this.f8501m = r12.getInteger(R$styleable.CircularProgressView_cpv_animSwoopDuration, r13.getInteger(R$integer.cpv_default_anim_swoop_duration));
        this.f8502n = r12.getInteger(R$styleable.CircularProgressView_cpv_animSyncDuration, r13.getInteger(R$integer.cpv_default_anim_sync_duration));
        this.f8503o = r12.getInteger(R$styleable.CircularProgressView_cpv_animSteps, r13.getInteger(R$integer.cpv_default_anim_steps));
        r12.recycle();
        Paint r15 = new Paint(1);
        this.f8493a = r15;
        r15.setColor(this.f8499k);
        this.f8493a.setStyle(Paint.Style.STROKE);
        this.f8493a.setStrokeWidth(this.f8498j);
        this.f8493a.setStrokeCap(Paint.Cap.BUTT);
        this.f8495c = new RectF();
        return;
    L5:
        if (r14 == 0) goto L7;
        TypedValue r16 = new TypedValue();
        getContext().getTheme().resolveAttribute(r14, r16, true);
        this.f8499k = r16.data;
        goto L8
    L7:
        this.f8499k = getContext().obtainStyledAttributes(new int[]{R.attr.colorAccent}).getColor(0, r13.getColor(R$color.cpv_default_color));
        goto L8
    }

    public int getColor() {
        return this.f8499k;
    }

    public float getMaxProgress() {
        return this.g;
    }

    public float getProgress() {
        return this.f;
    }

    public int getThickness() {
        return this.f8498j;
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.e == false) goto L6;
        a();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r5 = this.s;
        if (r5 == null) goto L5;
        r5.cancel();
        this.s = null;
    L5:
        ValueAnimator r10 = this.f8507t;
        if (r10 == null) goto L8;
        r10.cancel();
        this.f8507t = null;
    L8:
        AnimatorSet r11 = this.f8508u;
        if (r11 == null) goto L12;
        r11.cancel();
        this.f8508u = null;
        return;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r14) {
        super.onDraw(r14);
        if (isInEditMode() == false) goto L6;
        float r5 = this.f;
    L5:
        float r10 = (r5 / this.g) * 360.0f;
        if (this.d == true) goto L11;
        r14.drawArc(this.f8495c, this.f8505q, r10, false, this.f8493a);
        return;
    L11:
        r14.drawArc(this.f8495c, this.f8505q + this.f8497i, this.f8496h, false, this.f8493a);
        return;
    L6:
        r5 = this.f8506r;
        goto L5
    }

    @Override // android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        int r11 = getPaddingLeft();
        int r12 = getPaddingRight() + r11;
        int r13 = getPaddingTop();
        int r14 = getPaddingBottom() + r13;
        int r15 = getMeasuredWidth() - r12;
        int r16 = getMeasuredHeight() - r14;
        if (r15 < r16) goto L6;
        r15 = r16;
    L6:
        this.f8494b = r15;
        setMeasuredDimension(r12 + r15, r15 + r14);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        if (r5 < r10) goto L6;
        r5 = r10;
    L6:
        this.f8494b = r5;
        int r13 = getPaddingLeft();
        int r14 = getPaddingTop();
        RectF r15 = this.f8495c;
        int r16 = this.f8498j;
        int r17 = this.f8494b;
        r15.set(r13 + r16, r14 + r16, (r17 - r13) - r16, (r17 - r14) - r16);
    }

    public void setColor(int r5) {
        this.f8499k = r5;
        this.f8493a.setColor(r5);
        this.f8493a.setStyle(Paint.Style.STROKE);
        this.f8493a.setStrokeWidth(this.f8498j);
        this.f8493a.setStrokeCap(Paint.Cap.BUTT);
        invalidate();
    }

    public void setIndeterminate(boolean r5) {
        boolean r10 = this.d;
        if (r10 != r5) goto L5;
        boolean r11 = true;
    L6:
        this.d = r5;
        if (r11 == false) goto L9;
        a();
    L9:
        if (r10 == r5) goto L15;
        Iterator r12 = this.f8504p.iterator();
        if (r12.hasNext() == true) goto L14;
        return;
    L14:
        throw h.c(r12);
    L15:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public void setMaxProgress(float r5) {
        this.g = r5;
        invalidate();
    }

    public void setProgress(float r5) {
        int r10 = 2;
        this.f = r5;
        if (this.d == true) goto L10;
        ValueAnimator r11 = this.f8507t;
        if (r11 != null) goto L7;
    L9:
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{this.f8506r, r5});
        this.f8507t = r12;
        r12.setDuration(this.f8502n);
        this.f8507t.setInterpolator(new LinearInterpolator());
        this.f8507t.addUpdateListener(new a(this, 0));
        this.f8507t.addListener(new bq.a(this, r10));
        this.f8507t.start();
        goto L10
    L7:
        if (r11.isRunning() == false) goto L9;
        this.f8507t.cancel();
    L10:
        invalidate();
        Iterator r13 = this.f8504p.iterator();
        if (r13.hasNext() == true) goto L14;
        return;
    L14:
        throw h.c(r13);
    }

    public void setThickness(int r10) {
        this.f8498j = r10;
        this.f8493a.setColor(this.f8499k);
        this.f8493a.setStyle(Paint.Style.STROKE);
        this.f8493a.setStrokeWidth(this.f8498j);
        this.f8493a.setStrokeCap(Paint.Cap.BUTT);
        int r11 = getPaddingLeft();
        int r5 = getPaddingTop();
        RectF r12 = this.f8495c;
        int r13 = this.f8498j;
        int r14 = this.f8494b;
        r12.set(r11 + r13, r5 + r13, (r14 - r11) - r13, (r14 - r5) - r13);
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        int r10 = getVisibility();
        super.setVisibility(r5);
        if (r5 == r10) goto L21;
        if (r5 != 0) goto L8;
        a();
        return;
    L8:
        if (r5 != 8) goto L10;
    L11:
        ValueAnimator r11 = this.s;
        if (r11 == null) goto L14;
        r11.cancel();
        this.s = null;
    L14:
        ValueAnimator r12 = this.f8507t;
        if (r12 == null) goto L17;
        r12.cancel();
        this.f8507t = null;
    L17:
        AnimatorSet r13 = this.f8508u;
        if (r13 == null) goto L23;
        r13.cancel();
        this.f8508u = null;
        return;
    L23:
        return;
    L10:
        if (r5 == 4) goto L11;
        return;
    }

    public CircularProgressView(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.f8494b = 0;
        b(r10, 0);
    }

    public CircularProgressView(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f8494b = 0;
        b(r10, r11);
    }
}
