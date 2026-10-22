package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.internal.k;
import com.google.android.material.progressindicator.c;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b<S extends c> extends ProgressBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f4007a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    S f4008b;
    a c;
    private int d;
    private boolean e;
    private boolean f;
    private final int g;
    private final int h;
    private long i;
    private boolean j;
    private int k;
    private final Runnable l;
    private final Runnable m;
    private final Animatable2Compat.AnimationCallback n;
    private final Animatable2Compat.AnimationCallback o;

    static {
        f4007a = ZeusTransformUtils.mapRes(R.style.Widget_MaterialComponents_ProgressIndicator, "style", "Widget_MaterialComponents_ProgressIndicator");
    }

    public b(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r3 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.google.android.material.theme.a.a.a(r13, r3, r11, f4007a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r11);
        this.i = -1;
        this.j = false;
        this.k = 4;
        this.l = new AnonymousClass1(this);
        this.m = new AnonymousClass2(this);
        this.n = new BaseProgressIndicator$3(this);
        this.o = new BaseProgressIndicator$4(this);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.f4008b = (S) a(r2, r3);
        TypedArray r14 = k.a(r2, r3, R.styleable.BaseProgressIndicator, r11, r12, new int[0]);
        this.g = r14.getInt(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_showDelay, "styleable", "BaseProgressIndicator_showDelay"), -1);
        this.h = Math.min(r14.getInt(ZeusTransformUtils.mapRes(R.styleable.BaseProgressIndicator_minHideDelay, "styleable", "BaseProgressIndicator_minHideDelay"), -1), 1000);
        r14.recycle();
        this.c = new a();
        this.f = true;
    }

    static /* synthetic */ long a(b r0, long r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ void a(b r0) {
        r0.e();
    }

    static /* synthetic */ void b(b r0) {
        r0.f();
    }

    static /* synthetic */ int c(b r0) {
        return r0.d;
    }

    private void c() {
        if (getProgressDrawable() == null) goto L8;
        if (getIndeterminateDrawable() == null) goto L8;
        getIndeterminateDrawable().getAnimatorDelegate().a(this.n);
    L8:
        if (getProgressDrawable() == null) goto L11;
        getProgressDrawable().registerAnimationCallback(this.o);
    L11:
        if (getIndeterminateDrawable() == null) goto L14;
        getIndeterminateDrawable().registerAnimationCallback(this.o);
        return;
    }

    private void d() {
        if (getIndeterminateDrawable() == null) goto L6;
        getIndeterminateDrawable().unregisterAnimationCallback(this.o);
        getIndeterminateDrawable().getAnimatorDelegate().e();
    L6:
        if (getProgressDrawable() == null) goto L9;
        getProgressDrawable().unregisterAnimationCallback(this.o);
        return;
    }

    static /* synthetic */ boolean d(b r0) {
        return r0.e;
    }

    private void e() {
        if (this.h <= 0) goto L5;
        this.i = SystemClock.uptimeMillis();
    L5:
        setVisibility(0);
    }

    static /* synthetic */ boolean e(b r0) {
        return r0.j;
    }

    static /* synthetic */ int f(b r0) {
        return r0.k;
    }

    private void f() {
        ((DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.memorydata.plugin")).setVisible(false, false, true);
        if (g() == false) goto L6;
        setVisibility(4);
        return;
    }

    private boolean g() {
        if (getProgressDrawable() == null) goto L7;
        if (getProgressDrawable().isVisible() == false) goto L7;
    L11:
        return false;
    L7:
        if (getIndeterminateDrawable() != null) goto L9;
    L12:
        return true;
    L9:
        if (getIndeterminateDrawable().isVisible() == true) goto L11;
        goto L11
    }

    private f<S> getCurrentDrawingDelegate() {
        if (isIndeterminate() == false) goto L10;
        if (getIndeterminateDrawable() != null) goto L8;
        return null;
    L8:
        return getIndeterminateDrawable().getDrawingDelegate();
    L10:
        if (getProgressDrawable() != null) goto L13;
        return null;
    L13:
        return getProgressDrawable().getDrawingDelegate();
    }

    abstract S a(Context r1, AttributeSet r2);

    public void a(int r3, boolean r4) {
        if (isIndeterminate() == true) goto L5;
        super.setProgress(r3);
        if (getProgressDrawable() == null) goto L21;
        if (r4 == true) goto L22;
        getProgressDrawable().jumpToCurrentState();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (getProgressDrawable() == null) goto L18;
        this.d = r3;
        this.e = r4;
        this.j = true;
        if (getIndeterminateDrawable().isVisible() == true) goto L9;
    L12:
        this.n.onAnimationEnd(getIndeterminateDrawable());
        return;
    L9:
        if (this.c.a(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver()) == 0.0f) goto L12;
        getIndeterminateDrawable().getAnimatorDelegate().c();
        return;
    }

    public void a(boolean r4) {
        if (this.f == true) goto L5;
        return;
    L5:
        ((DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.memorydata.plugin")).setVisible(a(), false, r4);
    }

    boolean a() {
        if (ViewCompat.isAttachedToWindow(this) == true) goto L5;
    L9:
        return false;
    L5:
        if (getWindowVisibility() != 0) goto L9;
        if (b() == false) goto L9;
        return true;
    }

    boolean b() {
        View r0 = this;
    L4:
        if (r0.getVisibility() != 0) goto L5;
        ViewParent r1 = r0.getParent();
        if (r1 == null) goto L9;
        if (ZeusTransformUtils.instanceOf(r1, View.class) == false) goto L14;
        r0 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.memorydata.plugin");
        goto L4
    L14:
        return true;
    L9:
        if (getWindowVisibility() == 0) goto L11;
        return false;
    L11:
        return true;
    L5:
        return false;
    }

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        if (isIndeterminate() == false) goto L6;
        return getIndeterminateDrawable();
    L6:
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f4008b.f;
    }

    @Override // android.widget.ProgressBar
    public /* bridge */ /* synthetic */ Drawable getIndeterminateDrawable() {
        return getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) ZeusTransformUtils.preCheckCast(super.getIndeterminateDrawable(), IndeterminateDrawable.class, "com.obric.memorydata.plugin");
    }

    public int[] getIndicatorColor() {
        return this.f4008b.c;
    }

    @Override // android.widget.ProgressBar
    public /* bridge */ /* synthetic */ Drawable getProgressDrawable() {
        return getProgressDrawable();
    }

    @Override // android.widget.ProgressBar
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) ZeusTransformUtils.preCheckCast(super.getProgressDrawable(), DeterminateDrawable.class, "com.obric.memorydata.plugin");
    }

    public int getShowAnimationBehavior() {
        return this.f4008b.e;
    }

    public int getTrackColor() {
        return this.f4008b.d;
    }

    public int getTrackCornerRadius() {
        return this.f4008b.f4012b;
    }

    public int getTrackThickness() {
        return this.f4008b.f4011a;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() == null) goto L6;
        getCurrentDrawable().invalidateSelf();
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
        if (a() == false) goto L6;
        e();
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.m);
        removeCallbacks(this.l);
        ((DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.memorydata.plugin")).hideNow();
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas r6) {
        monitor-enter(this);
        int r0 = r6.save();     // Catch: Throwable -> L16
        if (getPaddingLeft() == 0) goto L6;
    L7:
        r6.translate(getPaddingLeft(), getPaddingTop());     // Catch: Throwable -> L16
    L9:
        if (getPaddingRight() == 0) goto L11;
    L12:
        r6.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));     // Catch: Throwable -> L16
    L13:
        getCurrentDrawable().draw(r6);     // Catch: Throwable -> L16
        r6.restoreToCount(r0);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        if (getPaddingBottom() == 0) goto L13;
    L6:
        if (getPaddingTop() == 0) goto L9;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r2, int r3) {
        monitor-enter(this);
        super.onMeasure(r2, r3);     // Catch: Throwable -> L17
        f<S> r4 = getCurrentDrawingDelegate();     // Catch: Throwable -> L17
        if (r4 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r5 = r4.a();     // Catch: Throwable -> L17
        int r6 = r4.b();     // Catch: Throwable -> L17
        if (r5 >= 0) goto L10;
        int r7 = getMeasuredWidth();     // Catch: Throwable -> L17
    L11:
        if (r6 >= 0) goto L13;
        int r8 = getMeasuredHeight();     // Catch: Throwable -> L17
    L14:
        setMeasuredDimension(r7, r8);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        r8 = (r6 + getPaddingTop()) + getPaddingBottom();     // Catch: Throwable -> L17
        goto L14
    L10:
        r7 = (r5 + getPaddingLeft()) + getPaddingRight();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r1, int r2) {
        super.onVisibilityChanged(r1, r2);
        if (r2 != 0) goto L5;
        boolean r3 = true;
    L6:
        a(r3);
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        a(false);
    }

    public void setAnimatorDurationScaleProvider(a r2) {
        this.c = r2;
        if (getProgressDrawable() == null) goto L6;
        getProgressDrawable().animatorDurationScaleProvider = r2;
    L6:
        if (getIndeterminateDrawable() == null) goto L9;
        getIndeterminateDrawable().animatorDurationScaleProvider = r2;
        return;
    }

    public void setHideAnimationBehavior(int r2) {
        this.f4008b.f = r2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean r4) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (r4 != isIndeterminate()) goto L7;
        monitor-exit(this);
        return;
    L7:
        DrawableWithAnimatedVisibilityChange r0 = (DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r0 == null) goto L10;
        r0.hideNow();     // Catch: Throwable -> L21
    L10:
        super.setIndeterminate(r4);     // Catch: Throwable -> L21
        DrawableWithAnimatedVisibilityChange r5 = (DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(getCurrentDrawable(), DrawableWithAnimatedVisibilityChange.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r5 == null) goto L14;
        r5.setVisible(a(), false, false);     // Catch: Throwable -> L21
    L14:
        if (ZeusTransformUtils.instanceOf(r5, IndeterminateDrawable.class) == true) goto L16;
    L18:
        this.j = false;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L16:
        if (a() == false) goto L18;
        ((IndeterminateDrawable) ZeusTransformUtils.preCheckCast(r5, IndeterminateDrawable.class, "com.obric.memorydata.plugin")).getAnimatorDelegate().a();     // Catch: Throwable -> L21
        goto L18
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable r3) {
        if (r3 != null) goto L6;
        super.setIndeterminateDrawable(null);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, IndeterminateDrawable.class) == false) goto L10;
        ((DrawableWithAnimatedVisibilityChange) ZeusTransformUtils.preCheckCast(r3, DrawableWithAnimatedVisibilityChange.class, "com.obric.memorydata.plugin")).hideNow();
        super.setIndeterminateDrawable(r3);
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
    }

    public void setIndicatorColor(int... r6) {
        if (r6.length != 0) goto L6;
        r6 = new int[]{com.google.android.material.c.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.colorPrimary, "attr", "colorPrimary"), -1)};
    L6:
        if (Arrays.equals(getIndicatorColor(), r6) == true) goto L9;
        this.f4008b.c = r6;
        getIndeterminateDrawable().getAnimatorDelegate().d();
        invalidate();
        return;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isIndeterminate() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        a(r2, false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(Drawable r3) {
        if (r3 != null) goto L6;
        super.setProgressDrawable(null);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, DeterminateDrawable.class) == false) goto L10;
        DeterminateDrawable r4 = (DeterminateDrawable) ZeusTransformUtils.preCheckCast(r3, DeterminateDrawable.class, "com.obric.memorydata.plugin");
        r4.hideNow();
        super.setProgressDrawable(r4);
        r4.setLevelByFraction(getProgress() / getMax());
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    public void setShowAnimationBehavior(int r2) {
        this.f4008b.e = r2;
        invalidate();
    }

    public void setTrackColor(int r2) {
        if (this.f4008b.d == r2) goto L6;
        this.f4008b.d = r2;
        invalidate();
        return;
    }

    public void setTrackCornerRadius(int r2) {
        if (this.f4008b.f4012b == r2) goto L6;
        S r1 = this.f4008b;
        r1.f4012b = Math.min(r2, r1.f4011a / 2);
        return;
    }

    public void setTrackThickness(int r2) {
        if (this.f4008b.f4011a == r2) goto L6;
        this.f4008b.f4011a = r2;
        requestLayout();
        return;
    }

    public void setVisibilityAfterHide(int r2) {
        if (r2 != 0) goto L4;
    L10:
        this.k = r2;
        return;
    L4:
        if (r2 == 4) goto L10;
        if (r2 == 8) goto L10;
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
}
