package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.b;
import java.util.Arrays;
import q5.k;
import q5.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProgressIndicator<S extends com.google.android.material.progressindicator.b> extends ProgressBar {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final int f3494s = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    S f3495c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3496g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f3497h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f3498i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f3499j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f3500k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    com.google.android.material.progressindicator.a f3501l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f3502m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f3503n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Runnable f3504o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Runnable f3505p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f3506q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Animatable2Compat.AnimationCallback f3507r;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseProgressIndicator f3508c;

        a(BaseProgressIndicator r10) {
            this.f3508c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.a(this.f3508c);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ BaseProgressIndicator f3509c;

        b(BaseProgressIndicator r10) {
            this.f3509c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseProgressIndicator.b(this.f3509c);
            BaseProgressIndicator.c(this.f3509c, -1);
        }
    }

    static {
        f3494s = k.Widget_MaterialComponents_ProgressIndicator;
    }

    protected BaseProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(b6.a.c(r10, r11, r12, f3494s), r11, r12);
        this.f3502m = false;
        this.f3503n = 4;
        this.f3504o = new a(this);
        this.f3505p = new b(this);
        this.f3506q = new AnonymousClass3(this);
        this.f3507r = new AnonymousClass4(this);
        Context r14 = getContext();
        this.f3495c = (S) i(r14, r11);
        TypedArray r15 = com.google.android.material.internal.k.h(r14, r11, l.BaseProgressIndicator, r12, r13, new int[0]);
        r15.getInt(l.BaseProgressIndicator_showDelay, -1);
        this.f3499j = Math.min(r15.getInt(l.BaseProgressIndicator_minHideDelay, -1), 1000);
        r15.recycle();
        this.f3501l = new com.google.android.material.progressindicator.a();
        this.f3498i = true;
    }

    static /* synthetic */ void a(BaseProgressIndicator r10) {
        r10.k();
    }

    static /* synthetic */ void b(BaseProgressIndicator r10) {
        r10.j();
    }

    static /* synthetic */ long c(BaseProgressIndicator r10, long r11) {
        r10.f3500k = r11;
        return r11;
    }

    static /* synthetic */ int d(BaseProgressIndicator r10) {
        return r10.f3496g;
    }

    static /* synthetic */ boolean e(BaseProgressIndicator r10) {
        return r10.f3497h;
    }

    static /* synthetic */ boolean f(BaseProgressIndicator r10) {
        return r10.f3502m;
    }

    static /* synthetic */ int g(BaseProgressIndicator r10) {
        return r10.f3503n;
    }

    @Nullable
    private e<S> getCurrentDrawingDelegate() {
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

    private void j() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (m() == false) goto L6;
        setVisibility(4);
        return;
    }

    private void k() {
        if (this.f3499j <= 0) goto L5;
        SystemClock.uptimeMillis();
    L5:
        setVisibility(0);
    }

    private boolean m() {
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

    private void n() {
        if (getProgressDrawable() == null) goto L8;
        if (getIndeterminateDrawable() == null) goto L8;
        getIndeterminateDrawable().getAnimatorDelegate().d(this.f3506q);
    L8:
        if (getProgressDrawable() == null) goto L11;
        getProgressDrawable().registerAnimationCallback(this.f3507r);
    L11:
        if (getIndeterminateDrawable() == null) goto L14;
        getIndeterminateDrawable().registerAnimationCallback(this.f3507r);
        return;
    }

    private void p() {
        if (getIndeterminateDrawable() == null) goto L6;
        getIndeterminateDrawable().unregisterAnimationCallback(this.f3507r);
        getIndeterminateDrawable().getAnimatorDelegate().h();
    L6:
        if (getProgressDrawable() == null) goto L9;
        getProgressDrawable().unregisterAnimationCallback(this.f3507r);
        return;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate() == false) goto L6;
        return getIndeterminateDrawable();
    L6:
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.f3495c.f3526f;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public /* bridge */ /* synthetic */ Drawable getIndeterminateDrawable() {
        return getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.f3495c.f3523c;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public /* bridge */ /* synthetic */ Drawable getProgressDrawable() {
        return getProgressDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.f3495c.f3525e;
    }

    @ColorInt
    public int getTrackColor() {
        return this.f3495c.f3524d;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.f3495c.f3522b;
    }

    @Px
    public int getTrackThickness() {
        return this.f3495c.f3521a;
    }

    protected void h(boolean r10) {
        if (this.f3498i == true) goto L5;
        return;
    L5:
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(q(), false, r10);
    }

    abstract S i(@NonNull Context r10, @NonNull AttributeSet r11);

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() == null) goto L6;
        getCurrentDrawable().invalidateSelf();
        return;
    }

    boolean l() {
        View r10 = this;
    L4:
        if (r10.getVisibility() != 0) goto L5;
        Object r11 = r10.getParent();
        if (r11 == null) goto L9;
        if ((r11 instanceof View) == false) goto L14;
        r10 = (View) r11;
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

    public void o(int r10, boolean r11) {
        if (isIndeterminate() == true) goto L5;
        super.setProgress(r10);
        if (getProgressDrawable() == null) goto L21;
        if (r11 == true) goto L22;
        getProgressDrawable().jumpToCurrentState();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (getProgressDrawable() == null) goto L18;
        this.f3496g = r10;
        this.f3497h = r11;
        this.f3502m = true;
        if (getIndeterminateDrawable().isVisible() == true) goto L9;
    L12:
        this.f3506q.onAnimationEnd(getIndeterminateDrawable());
        return;
    L9:
        if (this.f3501l.a(getContext().getContentResolver()) == 0.0f) goto L12;
        getIndeterminateDrawable().getAnimatorDelegate().f();
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        n();
        if (q() == false) goto L6;
        k();
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f3505p);
        removeCallbacks(this.f3504o);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        p();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(@NonNull Canvas r10) {
        monitor-enter(this);
        int r11 = r10.save();     // Catch: Throwable -> L16
        if (getPaddingLeft() == 0) goto L6;
    L7:
        r10.translate(getPaddingLeft(), getPaddingTop());     // Catch: Throwable -> L16
    L9:
        if (getPaddingRight() == 0) goto L11;
    L12:
        r10.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));     // Catch: Throwable -> L16
    L13:
        getCurrentDrawable().draw(r10);     // Catch: Throwable -> L16
        r10.restoreToCount(r11);     // Catch: Throwable -> L16
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
    protected synchronized void onMeasure(int r10, int r11) {
        monitor-enter(this);
        super.onMeasure(r10, r11);     // Catch: Throwable -> L17
        e<S> r12 = getCurrentDrawingDelegate();     // Catch: Throwable -> L17
        if (r12 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r13 = r12.e();     // Catch: Throwable -> L17
        int r14 = r12.d();     // Catch: Throwable -> L17
        if (r13 >= 0) goto L10;
        int r15 = getMeasuredWidth();     // Catch: Throwable -> L17
    L11:
        if (r14 >= 0) goto L13;
        int r16 = getMeasuredHeight();     // Catch: Throwable -> L17
    L14:
        setMeasuredDimension(r15, r16);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L13:
        r16 = (r14 + getPaddingTop()) + getPaddingBottom();     // Catch: Throwable -> L17
        goto L14
    L10:
        r15 = (r13 + getPaddingLeft()) + getPaddingRight();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View r10, int r11) {
        super.onVisibilityChanged(r10, r11);
        if (r11 != 0) goto L5;
        boolean r12 = true;
    L6:
        h(r12);
        return;
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        h(false);
    }

    boolean q() {
        if (ViewCompat.isAttachedToWindow(this) == true) goto L5;
    L9:
        return false;
    L5:
        if (getWindowVisibility() != 0) goto L9;
        if (l() == false) goto L9;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull com.google.android.material.progressindicator.a r10) {
        this.f3501l = r10;
        if (getProgressDrawable() == null) goto L6;
        getProgressDrawable().animatorDurationScaleProvider = r10;
    L6:
        if (getIndeterminateDrawable() == null) goto L9;
        getIndeterminateDrawable().animatorDurationScaleProvider = r10;
        return;
    }

    public void setHideAnimationBehavior(int r10) {
        this.f3495c.f3526f = r10;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean r10) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (r10 != isIndeterminate()) goto L7;
        monitor-exit(this);
        return;
    L7:
        DrawableWithAnimatedVisibilityChange r11 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();     // Catch: Throwable -> L21
        if (r11 == null) goto L10;
        r11.hideNow();     // Catch: Throwable -> L21
    L10:
        super.setIndeterminate(r10);     // Catch: Throwable -> L21
        DrawableWithAnimatedVisibilityChange r12 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();     // Catch: Throwable -> L21
        if (r12 == null) goto L14;
        r12.setVisible(q(), false, false);     // Catch: Throwable -> L21
    L14:
        if ((r12 instanceof IndeterminateDrawable) == true) goto L16;
    L18:
        this.f3502m = false;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L16:
        if (q() == false) goto L18;
        ((IndeterminateDrawable) r12).getAnimatorDelegate().g();     // Catch: Throwable -> L21
        goto L18
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable r10) {
        if (r10 != null) goto L6;
        super.setIndeterminateDrawable(null);
        return;
    L6:
        if ((r10 instanceof IndeterminateDrawable) == false) goto L10;
        ((DrawableWithAnimatedVisibilityChange) r10).hideNow();
        super.setIndeterminateDrawable(r10);
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
    }

    public void setIndicatorColor(@ColorInt int... r10) {
        if (r10.length != 0) goto L6;
        r10 = new int[]{t5.a.b(getContext(), q5.b.colorPrimary, -1)};
    L6:
        if (Arrays.equals(getIndicatorColor(), r10) == true) goto L9;
        this.f3495c.f3523c = r10;
        getIndeterminateDrawable().getAnimatorDelegate().c();
        invalidate();
        return;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int r10) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isIndeterminate() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        o(r10, false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable r10) {
        if (r10 != null) goto L6;
        super.setProgressDrawable(null);
        return;
    L6:
        if ((r10 instanceof DeterminateDrawable) == false) goto L10;
        DeterminateDrawable r11 = (DeterminateDrawable) r10;
        r11.hideNow();
        super.setProgressDrawable(r11);
        r11.setLevelByFraction(getProgress() / getMax());
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    public void setShowAnimationBehavior(int r10) {
        this.f3495c.f3525e = r10;
        invalidate();
    }

    public void setTrackColor(@ColorInt int r10) {
        S r11 = this.f3495c;
        if (r11.f3524d == r10) goto L6;
        r11.f3524d = r10;
        invalidate();
        return;
    }

    public void setTrackCornerRadius(@Px int r10) {
        S r11 = this.f3495c;
        if (r11.f3522b == r10) goto L6;
        r11.f3522b = Math.min(r10, r11.f3521a / 2);
        return;
    }

    public void setTrackThickness(@Px int r10) {
        S r11 = this.f3495c;
        if (r11.f3521a == r10) goto L6;
        r11.f3521a = r10;
        requestLayout();
        return;
    }

    public void setVisibilityAfterHide(int r10) {
        if (r10 != 0) goto L4;
    L10:
        this.f3503n = r10;
        return;
    L4:
        if (r10 == 4) goto L10;
        if (r10 == 8) goto L10;
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
}
