package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* JADX INFO: loaded from: classes2.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    static final float GAP_RAMP_DOWN_THRESHOLD = 0.01f;
    private static final FloatPropertyCompat<DeterminateDrawable<?>> INDICATOR_LENGTH_IN_LEVEL = null;
    private static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private final DrawingDelegate.ActiveIndicator activeIndicator;
    private DrawingDelegate<S> drawingDelegate;
    private boolean skipAnimationOnLevelChange;
    private final SpringAnimation springAnimation;
    private final SpringForce springForce;

    static {
        final String r5 = "indicatorLevel";
        INDICATOR_LENGTH_IN_LEVEL = new AnonymousClass1(r5);
    }

    public DeterminateDrawable(@NonNull Context r5, @NonNull BaseProgressIndicatorSpec r10, @NonNull DrawingDelegate<S> r11) {
        super(r5, r10);
        this.skipAnimationOnLevelChange = false;
        setDrawingDelegate(r11);
        this.activeIndicator = new DrawingDelegate.ActiveIndicator();
        SpringForce r12 = new SpringForce();
        this.springForce = r12;
        r12.setDampingRatio(1.0f);
        r12.setStiffness(50.0f);
        SpringAnimation r13 = new SpringAnimation(this, INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimation = r13;
        r13.setSpring(r12);
        setGrowFraction(1.0f);
    }

    public static /* synthetic */ float access$000(DeterminateDrawable r5) {
        return r5.getIndicatorFraction();
    }

    public static /* synthetic */ void access$100(DeterminateDrawable r5, float r10) {
        r5.setIndicatorFraction(r10);
    }

    @NonNull
    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context r5, @NonNull CircularProgressIndicatorSpec r10) {
        return createCircularDrawable(r5, r10, new CircularDrawingDelegate(r10));
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context r5, @NonNull LinearProgressIndicatorSpec r10) {
        return createLinearDrawable(r5, r10, new LinearDrawingDelegate(r10));
    }

    private float getIndicatorFraction() {
        return this.activeIndicator.endFraction;
    }

    private void setIndicatorFraction(float r5) {
        this.activeIndicator.endFraction = r5;
        invalidateSelf();
    }

    public void addSpringAnimationEndListener(@NonNull DynamicAnimation.OnAnimationEndListener r5) {
        this.springAnimation.addEndListener(r5);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r11) {
        Rect r5 = new Rect();
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (isVisible() == true) goto L7;
        return;
    L7:
        if (r11.getClipBounds(r5) == false) goto L21;
        r11.save();
        this.drawingDelegate.validateSpecAndAdjustCanvas(r11, getBounds(), getGrowFraction(), isShowing(), isHiding());
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
        DrawingDelegate.ActiveIndicator r10 = this.activeIndicator;
        BaseProgressIndicatorSpec r12 = this.baseSpec;
        r10.color = r12.indicatorColors[0];
        int r13 = r12.indicatorTrackGapSize;
        if (r13 > 0) goto L12;
        this.drawingDelegate.fillTrack(r11, this.paint, 0.0f, 1.0f, r12.trackColor, getAlpha(), 0);
    L17:
        this.drawingDelegate.fillIndicator(r11, this.paint, this.activeIndicator, getAlpha());
        this.drawingDelegate.drawStopIndicator(r11, this.paint, this.baseSpec.indicatorColors[0], getAlpha());
        r11.restore();
        return;
    L12:
        if ((this.drawingDelegate instanceof LinearDrawingDelegate) == true) goto L15;
        r13 = (int) ((MathUtils.clamp(getIndicatorFraction(), 0.0f, GAP_RAMP_DOWN_THRESHOLD) * r13) / GAP_RAMP_DOWN_THRESHOLD);
    L15:
        this.drawingDelegate.fillTrack(r11, this.paint, getIndicatorFraction(), 1.0f, this.baseSpec.trackColor, getAlpha(), r13);
        goto L17
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
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

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.springAnimation.skipToEnd();
        setIndicatorFraction(getLevel() / 10000.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int r5) {
        if (this.skipAnimationOnLevelChange == false) goto L5;
        this.springAnimation.skipToEnd();
        setIndicatorFraction(r5 / 10000.0f);
        return true;
    L5:
        this.springAnimation.setStartValue(getIndicatorFraction() * 10000.0f);
        this.springAnimation.animateToFinalPosition(r5);
        return true;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        super.registerAnimationCallback(r5);
    }

    public void removeSpringAnimationEndListener(@NonNull DynamicAnimation.OnAnimationEndListener r5) {
        this.springAnimation.removeEndListener(r5);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(@IntRange(from = 0, to = 255) int r5) {
        super.setAlpha(r5);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter r5) {
        super.setColorFilter(r5);
    }

    public void setDrawingDelegate(@NonNull DrawingDelegate<S> r5) {
        this.drawingDelegate = r5;
    }

    public void setLevelByFraction(float r5) {
        setLevel((int) (r5 * 10000.0f));
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r5, boolean r10) {
        return super.setVisible(r5, r10);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public boolean setVisibleInternal(boolean r5, boolean r10, boolean r11) {
        boolean r12 = super.setVisibleInternal(r5, r10, r11);
        float r13 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r13 != 0.0f) goto L5;
        this.skipAnimationOnLevelChange = true;
    L6:
        return r12;
    L5:
        this.skipAnimationOnLevelChange = false;
        this.springForce.setStiffness(50.0f / r13);
        goto L6
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
    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(@NonNull Context r5, @NonNull CircularProgressIndicatorSpec r10, @NonNull CircularDrawingDelegate r11) {
        return new DeterminateDrawable(r5, r10, r11);
    }

    @NonNull
    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(@NonNull Context r5, @NonNull LinearProgressIndicatorSpec r10, @NonNull LinearDrawingDelegate r11) {
        return new DeterminateDrawable(r5, r10, r11);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean r5, boolean r10, boolean r11) {
        return super.setVisible(r5, r10, r11);
    }
}
