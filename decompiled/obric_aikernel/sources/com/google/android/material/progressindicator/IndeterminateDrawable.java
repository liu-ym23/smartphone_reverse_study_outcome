package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.b;

/* JADX INFO: loaded from: classes.dex */
public final class IndeterminateDrawable<S extends b> extends DrawableWithAnimatedVisibilityChange {
    private f<ObjectAnimator> animatorDelegate;
    private e<S> drawingDelegate;

    IndeterminateDrawable(@NonNull Context r10, @NonNull b r11, @NonNull e<S> r12, @NonNull f<ObjectAnimator> r13) {
        super(r10, r11);
        setDrawingDelegate(r12);
        setAnimatorDelegate(r13);
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context r10, @NonNull CircularProgressIndicatorSpec r11) {
        return new IndeterminateDrawable(r10, r11, new c(r11), new d(r11));
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context r10, @NonNull LinearProgressIndicatorSpec r11) {
        g r12 = new g(r11);
        if (r11.f3517g != 0) goto L5;
        f r13 = new h(r11);
    L7:
        return new IndeterminateDrawable(r10, r11, r12, r13);
    L5:
        r13 = new i(r10, r11);
        goto L7
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r11) {
        Rect r10 = new Rect();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r11.getClipBounds(r10) == false) goto L18;
        r11.save();
        this.drawingDelegate.g(r11, getGrowFraction());
        this.drawingDelegate.c(r11, this.paint);
        int r12 = 0;
    L10:
        f<ObjectAnimator> r13 = this.animatorDelegate;
        int[] r14 = r13.f3550c;
        if (r12 >= r14.length) goto L13;
        e<S> r15 = this.drawingDelegate;
        Paint r16 = this.paint;
        float[] r17 = r13.f3549b;
        int r18 = r12 * 2;
        r15.b(r11, r16, r17[r18], r17[r18 + 1], r14[r12]);
        r12 = r12 + 1;
        goto L10
    L13:
        r11.restore();
        return;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @NonNull
    f<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    @NonNull
    e<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.e();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        super.registerAnimationCallback(r10);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int r10) {
        super.setAlpha(r10);
    }

    void setAnimatorDelegate(@NonNull f<ObjectAnimator> r10) {
        this.animatorDelegate = r10;
        r10.e(this);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter r10) {
        super.setColorFilter(r10);
    }

    void setDrawingDelegate(@NonNull e<S> r10) {
        this.drawingDelegate = r10;
        r10.f(this);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r10, boolean r11) {
        return super.setVisible(r10, r11);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r10, boolean r11, boolean r12) {
        return super.setVisible(r10, r11, r12);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    boolean setVisibleInternal(boolean r10, boolean r11, boolean r12) {
        boolean r13 = super.setVisibleInternal(r10, r11, r12);
        if (isRunning() == true) goto L5;
        this.animatorDelegate.a();
    L5:
        float r14 = this.animatorDurationScaleProvider.a(this.context.getContentResolver());
        if (r10 == false) goto L13;
        if (r12 == false) goto L9;
    L12:
        this.animatorDelegate.g();
        goto L13
    L9:
        if (Build.VERSION.SDK_INT > 21) goto L13;
        if (r14 > 0.0f) goto L12;
    L13:
        return r13;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        return super.unregisterAnimationCallback(r10);
    }
}
