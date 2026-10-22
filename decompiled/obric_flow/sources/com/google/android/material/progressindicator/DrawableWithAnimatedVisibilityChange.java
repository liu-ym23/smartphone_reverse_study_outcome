package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.utilities.Contrast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final int GROW_DURATION = 500;
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> GROW_FRACTION = null;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    final BaseProgressIndicatorSpec baseSpec;
    final Context context;
    private float growFraction;
    private ValueAnimator hideAnimator;
    private boolean ignoreCallbacks;
    private Animatable2Compat.AnimationCallback internalAnimationCallback;
    private float mockGrowFraction;
    private boolean mockHideAnimationRunning;
    private boolean mockShowAnimationRunning;
    final Paint paint;
    private ValueAnimator showAnimator;

    @IntRange(from = 0, to = 255)
    private int totalAlpha;

    static {
        final Class<Float> r5 = Float.class;
        final String r10 = "growFraction";
        GROW_FRACTION = new AnonymousClass3(r5, r10);
    }

    public DrawableWithAnimatedVisibilityChange(@NonNull Context r5, @NonNull BaseProgressIndicatorSpec r10) {
        this.paint = new Paint();
        this.context = r5;
        this.baseSpec = r10;
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        setAlpha(255);
    }

    public static /* synthetic */ void access$000(DrawableWithAnimatedVisibilityChange r5) {
        r5.dispatchAnimationStart();
    }

    public static /* synthetic */ boolean access$101(DrawableWithAnimatedVisibilityChange r5, boolean r10, boolean r11) {
        return super.setVisible(r10, r11);
    }

    public static /* synthetic */ void access$200(DrawableWithAnimatedVisibilityChange r5) {
        r5.dispatchAnimationEnd();
    }

    private void cancelAnimatorsWithoutCallbacks(@NonNull ValueAnimator... r5) {
        boolean r10 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5[r12].cancel();
        r12 = r12 + 1;
        goto L3
    L5:
        this.ignoreCallbacks = r10;
    }

    private void dispatchAnimationEnd() {
        Animatable2Compat.AnimationCallback r5 = this.internalAnimationCallback;
        if (r5 == null) goto L5;
        r5.onAnimationEnd(this);
    L5:
        List<Animatable2Compat.AnimationCallback> r10 = this.animationCallbacks;
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.ignoreCallbacks == true) goto L15;
        Iterator<Animatable2Compat.AnimationCallback> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L16;
        r11.next().onAnimationEnd(this);
        goto L11
    L16:
        return;
    }

    private void dispatchAnimationStart() {
        Animatable2Compat.AnimationCallback r5 = this.internalAnimationCallback;
        if (r5 == null) goto L5;
        r5.onAnimationStart(this);
    L5:
        List<Animatable2Compat.AnimationCallback> r10 = this.animationCallbacks;
        if (r10 != null) goto L8;
        return;
    L8:
        if (this.ignoreCallbacks == true) goto L15;
        Iterator<Animatable2Compat.AnimationCallback> r11 = r10.iterator();
    L11:
        if (r11.hasNext() == false) goto L16;
        r11.next().onAnimationStart(this);
        goto L11
    L16:
        return;
    }

    private void endAnimatorsWithoutCallbacks(@NonNull ValueAnimator... r5) {
        boolean r10 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        int r11 = r5.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r5[r12].end();
        r12 = r12 + 1;
        goto L3
    L5:
        this.ignoreCallbacks = r10;
    }

    private void maybeInitializeAnimators() {
        if (this.showAnimator != null) goto L6;
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{0.0f, 1.0f});
        this.showAnimator = r5;
        r5.setDuration(500);
        this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        setShowAnimator(this.showAnimator);
    L6:
        if (this.hideAnimator != null) goto L9;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{1.0f, 0.0f});
        this.hideAnimator = r10;
        r10.setDuration(500);
        this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        setHideAnimator(this.hideAnimator);
        return;
    }

    private void setHideAnimator(@NonNull ValueAnimator r5) {
        ValueAnimator r10 = this.hideAnimator;
        if (r10 != null) goto L5;
    L9:
        this.hideAnimator = r5;
        r5.addListener(new AnonymousClass2(this));
        return;
    L5:
        if (r10.isRunning() == false) goto L9;
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    private void setShowAnimator(@NonNull ValueAnimator r5) {
        ValueAnimator r10 = this.showAnimator;
        if (r10 != null) goto L5;
    L9:
        this.showAnimator = r5;
        r5.addListener(new AnonymousClass1(this));
        return;
    L5:
        if (r10.isRunning() == false) goto L9;
        throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.totalAlpha;
    }

    public float getGrowFraction() {
        if (this.baseSpec.isShowAnimationEnabled() == true) goto L9;
        if (this.baseSpec.isHideAnimationEnabled() == true) goto L9;
        return 1.0f;
    L9:
        if (this.mockHideAnimationRunning == true) goto L16;
        if (this.mockShowAnimationRunning == true) goto L16;
        return this.growFraction;
    L16:
        return this.mockGrowFraction;
    }

    @NonNull
    public ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    public boolean isHiding() {
        ValueAnimator r5 = this.hideAnimator;
        if (r5 == null) goto L7;
        if (r5.isRunning() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mockHideAnimationRunning == true) goto L8;
        return false;
    }

    public boolean isRunning() {
        if (isShowing() == false) goto L5;
    L8:
        return true;
    L5:
        if (isHiding() == true) goto L8;
        return false;
    }

    public boolean isShowing() {
        ValueAnimator r5 = this.showAnimator;
        if (r5 == null) goto L7;
        if (r5.isRunning() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mockShowAnimationRunning == true) goto L8;
        return false;
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        if (this.animationCallbacks != null) goto L6;
        this.animationCallbacks = new ArrayList();
    L6:
        if (this.animationCallbacks.contains(r5) == true) goto L9;
        this.animationCallbacks.add(r5);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int r5) {
        this.totalAlpha = r5;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r5) {
        this.paint.setColorFilter(r5);
        invalidateSelf();
    }

    public void setGrowFraction(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r5) {
        if (this.growFraction == r5) goto L6;
        this.growFraction = r5;
        invalidateSelf();
        return;
    }

    public void setInternalAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        this.internalAnimationCallback = r5;
    }

    @VisibleForTesting
    public void setMockHideAnimationRunning(boolean r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10) {
        this.mockHideAnimationRunning = r5;
        this.mockGrowFraction = r10;
    }

    @VisibleForTesting
    public void setMockShowAnimationRunning(boolean r5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float r10) {
        this.mockShowAnimationRunning = r5;
        this.mockGrowFraction = r10;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r5, boolean r10) {
        return setVisible(r5, r10, true);
    }

    public boolean setVisibleInternal(boolean r5, boolean r10, boolean r11) {
        maybeInitializeAnimators();
        boolean r12 = false;
        if (isVisible() == true) goto L6;
        if (r5 == true) goto L6;
        return false;
    L6:
        if (r5 == false) goto L8;
        ValueAnimator r13 = this.showAnimator;
    L9:
        if (r5 == false) goto L11;
        ValueAnimator r14 = this.hideAnimator;
    L12:
        if (r11 == true) goto L23;
        if (r14.isRunning() == false) goto L17;
        cancelAnimatorsWithoutCallbacks(new ValueAnimator[]{r14});
    L17:
        if (r13.isRunning() == false) goto L19;
        r13.end();
    L21:
        return super.setVisible(r5, false);
    L19:
        endAnimatorsWithoutCallbacks(new ValueAnimator[]{r13});
        goto L21
    L23:
        if (r13.isRunning() == false) goto L25;
        return false;
    L25:
        if (r5 == true) goto L27;
    L28:
        r12 = true;
    L29:
        if (r5 == false) goto L31;
        boolean r15 = this.baseSpec.isShowAnimationEnabled();
    L32:
        if (r15 == true) goto L35;
        endAnimatorsWithoutCallbacks(new ValueAnimator[]{r13});
        return r12;
    L35:
        if (r10 == false) goto L37;
    L40:
        r13.start();
    L41:
        return r12;
    L37:
        if (r13.isPaused() == false) goto L40;
        r13.resume();
        goto L41
    L31:
        r15 = this.baseSpec.isHideAnimationEnabled();
        goto L32
    L27:
        if (super.setVisible(r5, false) == false) goto L29;
    L11:
        r14 = this.showAnimator;
        goto L12
    L8:
        r13 = this.hideAnimator;
        goto L9
    }

    public void start() {
        setVisibleInternal(true, true, false);
    }

    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r5) {
        List<Animatable2Compat.AnimationCallback> r10 = this.animationCallbacks;
        if (r10 != null) goto L5;
        return false;
    L5:
        if (r10.contains(r5) == false) goto L14;
        this.animationCallbacks.remove(r5);
        if (this.animationCallbacks.isEmpty() == false) goto L13;
        this.animationCallbacks = null;
        return true;
    L13:
        return true;
    L14:
        return false;
    }

    public boolean setVisible(boolean r5, boolean r10, boolean r11) {
        float r12 = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (r11 == true) goto L5;
    L7:
        boolean r13 = false;
    L9:
        return setVisibleInternal(r5, r10, r13);
    L5:
        if (r12 <= 0.0f) goto L7;
        r13 = true;
        goto L9
    }
}
