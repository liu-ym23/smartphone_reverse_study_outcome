package com.google.android.material.progressindicator;

import ai.j0;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes2.dex */
public final class IndeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private IndeterminateAnimatorDelegate<ObjectAnimator> animatorDelegate;
    private DrawingDelegate<S> drawingDelegate;
    private Drawable staticDummyDrawable;

    public IndeterminateDrawable(@NonNull Context r5, @NonNull BaseProgressIndicatorSpec r10, @NonNull DrawingDelegate<S> r11, @NonNull IndeterminateAnimatorDelegate<ObjectAnimator> r12) {
        super(r5, r10);
        setDrawingDelegate(r11);
        setAnimatorDelegate(r12);
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context r5, @NonNull CircularProgressIndicatorSpec r10) {
        return createCircularDrawable(r5, r10, new CircularDrawingDelegate(r10));
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context r5, @NonNull LinearProgressIndicatorSpec r10) {
        return createLinearDrawable(r5, r10, new LinearDrawingDelegate(r10));
    }

    private boolean isSystemAnimatorDisabled() {
        AnimatorDurationScaleProvider r5 = this.animatorDurationScaleProvider;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.getSystemAnimatorDurationScale(this.context.getContentResolver()) != 0.0f) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r13) {
        Rect r5 = new Rect();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r13.getClipBounds(r5) == false) goto L38;
        int r10 = 0;
        if (isSystemAnimatorDisabled() == false) goto L15;
        Drawable r11 = this.staticDummyDrawable;
        if (r11 == null) goto L15;
        r11.setBounds(getBounds());
        DrawableCompat.setTint(this.staticDummyDrawable, this.baseSpec.indicatorColors[0]);
        this.staticDummyDrawable.draw(r13);
        return;
    L15:
        r13.save();
        this.drawingDelegate.validateSpecAndAdjustCanvas(r13, getBounds(), getGrowFraction(), isShowing(), isHiding());
        int r12 = this.baseSpec.indicatorTrackGapSize;
        int r14 = getAlpha();
        if (r12 != 0) goto L18;
        this.drawingDelegate.fillTrack(r13, this.paint, 0.0f, 1.0f, this.baseSpec.trackColor, r14, 0);
    L23:
        if (r10 >= this.animatorDelegate.activeIndicators.size()) goto L29;
        DrawingDelegate.ActiveIndicator r15 = this.animatorDelegate.activeIndicators.get(r10);
        this.drawingDelegate.fillIndicator(r13, this.paint, r15, getAlpha());
        if (r10 <= 0) goto L28;
        if (r12 <= 0) goto L28;
        this.drawingDelegate.fillTrack(r13, this.paint, this.animatorDelegate.activeIndicators.get(r10 - 1).endFraction, r15.startFraction, this.baseSpec.trackColor, r14, r12);
    L28:
        r10 = r10 + 1;
        goto L23
    L29:
        r13.restore();
        return;
    L18:
        DrawingDelegate.ActiveIndicator r16 = this.animatorDelegate.activeIndicators.get(0);
        DrawingDelegate.ActiveIndicator r17 = (DrawingDelegate.ActiveIndicator) j0.e(this.animatorDelegate.activeIndicators, 1);
        DrawingDelegate<S> r18 = this.drawingDelegate;
        if ((r18 instanceof LinearDrawingDelegate) == false) goto L21;
        r18.fillTrack(r13, this.paint, 0.0f, r16.startFraction, this.baseSpec.trackColor, r14, r12);
        this.drawingDelegate.fillTrack(r13, this.paint, r17.endFraction, 1.0f, this.baseSpec.trackColor, r14, r12);
        goto L23
    L21:
        r14 = 0;
        r18.fillTrack(r13, this.paint, r17.endFraction, 1.0f + r16.startFraction, this.baseSpec.trackColor, 0, r12);
        goto L23
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @NonNull
    public IndeterminateAnimatorDelegate<ObjectAnimator> getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    @NonNull
    public DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Drawable getStaticDummyDrawable() {
        return this.staticDummyDrawable;
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
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        super.registerAnimationCallback(r5);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(@IntRange(from = 0, to = 255) int r5) {
        super.setAlpha(r5);
    }

    public void setAnimatorDelegate(@NonNull IndeterminateAnimatorDelegate<ObjectAnimator> r5) {
        this.animatorDelegate = r5;
        r5.registerDrawable(this);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter r5) {
        super.setColorFilter(r5);
    }

    public void setDrawingDelegate(@NonNull DrawingDelegate<S> r5) {
        this.drawingDelegate = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setStaticDummyDrawable(@Nullable Drawable r5) {
        this.staticDummyDrawable = r5;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r5, boolean r10) {
        return super.setVisible(r5, r10);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public boolean setVisibleInternal(boolean r5, boolean r10, boolean r11) {
        boolean r12 = super.setVisibleInternal(r5, r10, r11);
        if (isSystemAnimatorDisabled() == false) goto L9;
        Drawable r13 = this.staticDummyDrawable;
        if (r13 == null) goto L9;
        return r13.setVisible(r5, r10);
    L9:
        if (isRunning() == true) goto L11;
        this.animatorDelegate.cancelAnimatorImmediately();
    L11:
        if (r5 == false) goto L15;
        if (r11 == false) goto L15;
        this.animatorDelegate.startAnimator();
    L15:
        return r12;
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
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        return super.unregisterAnimationCallback(r5);
    }

    @NonNull
    public static IndeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context r5, @NonNull CircularProgressIndicatorSpec r10, @NonNull CircularDrawingDelegate r11) {
        IndeterminateDrawable<CircularProgressIndicatorSpec> r12 = new IndeterminateDrawable(r5, r10, r11, new CircularIndeterminateAnimatorDelegate(r10));
        r12.setStaticDummyDrawable(VectorDrawableCompat.create(r5.getResources(), R.drawable.indeterminate_static, null));
        return r12;
    }

    @NonNull
    public static IndeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context r5, @NonNull LinearProgressIndicatorSpec r10, @NonNull LinearDrawingDelegate r11) {
        if (r10.indeterminateAnimationType != 0) goto L5;
        IndeterminateAnimatorDelegate r12 = new LinearIndeterminateContiguousAnimatorDelegate(r10);
    L7:
        return new IndeterminateDrawable(r5, r10, r11, r12);
    L5:
        r12 = new LinearIndeterminateDisjointAnimatorDelegate(r5, r10);
        goto L7
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r5, boolean r10, boolean r11) {
        return super.setVisible(r5, r10, r11);
    }
}
