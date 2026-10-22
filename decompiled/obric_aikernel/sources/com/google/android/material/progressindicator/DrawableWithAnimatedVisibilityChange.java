package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final int GROW_DURATION = 500;
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> GROW_FRACTION = null;
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    com.google.android.material.progressindicator.a animatorDurationScaleProvider;
    final com.google.android.material.progressindicator.b baseSpec;
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
    private int totalAlpha;

    class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DrawableWithAnimatedVisibilityChange f3514c;

        a(DrawableWithAnimatedVisibilityChange r10) {
            this.f3514c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            super.onAnimationStart(r10);
            DrawableWithAnimatedVisibilityChange.access$000(this.f3514c);
        }
    }

    class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DrawableWithAnimatedVisibilityChange f3515c;

        b(DrawableWithAnimatedVisibilityChange r10) {
            this.f3515c = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            super.onAnimationEnd(r10);
            DrawableWithAnimatedVisibilityChange.access$101(this.f3515c, false, false);
            DrawableWithAnimatedVisibilityChange.access$200(this.f3515c);
        }
    }

    class c extends Property<DrawableWithAnimatedVisibilityChange, Float> {
        c(Class r10, String r11) {
            super(r10, r11);
        }

        public Float a(DrawableWithAnimatedVisibilityChange r10) {
            return Float.valueOf(r10.getGrowFraction());
        }

        public void b(DrawableWithAnimatedVisibilityChange r10, Float r11) {
            r10.setGrowFraction(r11.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(DrawableWithAnimatedVisibilityChange r10) {
            return a(r10);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(DrawableWithAnimatedVisibilityChange r10, Float r11) {
            b(r10, r11);
        }
    }

    static {
        GROW_FRACTION = new c(Float.class, "growFraction");
    }

    DrawableWithAnimatedVisibilityChange(@NonNull Context r10, @NonNull com.google.android.material.progressindicator.b r11) {
        this.paint = new Paint();
        this.context = r10;
        this.baseSpec = r11;
        this.animatorDurationScaleProvider = new com.google.android.material.progressindicator.a();
        setAlpha(255);
    }

    static /* synthetic */ void access$000(DrawableWithAnimatedVisibilityChange r10) {
        r10.dispatchAnimationStart();
    }

    static /* synthetic */ boolean access$101(DrawableWithAnimatedVisibilityChange r10, boolean r11, boolean r12) {
        return super.setVisible(r11, r12);
    }

    static /* synthetic */ void access$200(DrawableWithAnimatedVisibilityChange r10) {
        r10.dispatchAnimationEnd();
    }

    private void dispatchAnimationEnd() {
        Animatable2Compat.AnimationCallback r10 = this.internalAnimationCallback;
        if (r10 == null) goto L5;
        r10.onAnimationEnd(this);
    L5:
        List<Animatable2Compat.AnimationCallback> r11 = this.animationCallbacks;
        if (r11 != null) goto L8;
        return;
    L8:
        if (this.ignoreCallbacks == true) goto L15;
        Iterator<Animatable2Compat.AnimationCallback> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L16;
        r12.next().onAnimationEnd(this);
        goto L11
    L16:
        return;
    }

    private void dispatchAnimationStart() {
        Animatable2Compat.AnimationCallback r10 = this.internalAnimationCallback;
        if (r10 == null) goto L5;
        r10.onAnimationStart(this);
    L5:
        List<Animatable2Compat.AnimationCallback> r11 = this.animationCallbacks;
        if (r11 != null) goto L8;
        return;
    L8:
        if (this.ignoreCallbacks == true) goto L15;
        Iterator<Animatable2Compat.AnimationCallback> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L16;
        r12.next().onAnimationStart(this);
        goto L11
    L16:
        return;
    }

    private void endAnimatorWithoutCallbacks(@NonNull ValueAnimator... r10) {
        boolean r11 = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r10[r13].end();
        r13 = r13 + 1;
        goto L3
    L5:
        this.ignoreCallbacks = r11;
    }

    private void maybeInitializeAnimators() {
        if (this.showAnimator != null) goto L6;
        ObjectAnimator r10 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{0.0f, 1.0f});
        this.showAnimator = r10;
        r10.setDuration(500);
        this.showAnimator.setInterpolator(r5.a.f12674b);
        setShowAnimator(this.showAnimator);
    L6:
        if (this.hideAnimator != null) goto L9;
        ObjectAnimator r11 = ObjectAnimator.ofFloat(this, GROW_FRACTION, new float[]{1.0f, 0.0f});
        this.hideAnimator = r11;
        r11.setDuration(500);
        this.hideAnimator.setInterpolator(r5.a.f12674b);
        setHideAnimator(this.hideAnimator);
        return;
    }

    private void setHideAnimator(@NonNull ValueAnimator r10) {
        ValueAnimator r11 = this.hideAnimator;
        if (r11 != null) goto L5;
    L9:
        this.hideAnimator = r10;
        r10.addListener(new b(this));
        return;
    L5:
        if (r11.isRunning() == false) goto L9;
        throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
    }

    private void setShowAnimator(@NonNull ValueAnimator r10) {
        ValueAnimator r11 = this.showAnimator;
        if (r11 != null) goto L5;
    L9:
        this.showAnimator = r10;
        r10.addListener(new a(this));
        return;
    L5:
        if (r11.isRunning() == false) goto L9;
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

    float getGrowFraction() {
        if (this.baseSpec.b() == true) goto L9;
        if (this.baseSpec.a() == true) goto L9;
        return 1.0f;
    L9:
        if (this.mockHideAnimationRunning == true) goto L16;
        if (this.mockShowAnimationRunning == true) goto L16;
        return this.growFraction;
    L16:
        return this.mockGrowFraction;
    }

    @NonNull
    ValueAnimator getHideAnimator() {
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
        ValueAnimator r10 = this.hideAnimator;
        if (r10 == null) goto L7;
        if (r10.isRunning() == false) goto L7;
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
        ValueAnimator r10 = this.showAnimator;
        if (r10 == null) goto L7;
        if (r10.isRunning() == false) goto L7;
    L8:
        return true;
    L7:
        if (this.mockShowAnimationRunning == true) goto L8;
        return false;
    }

    public void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        if (this.animationCallbacks != null) goto L6;
        this.animationCallbacks = new ArrayList();
    L6:
        if (this.animationCallbacks.contains(r10) == true) goto L9;
        this.animationCallbacks.add(r10);
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.totalAlpha = r10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter r10) {
        this.paint.setColorFilter(r10);
        invalidateSelf();
    }

    void setGrowFraction(@FloatRange(from = 0.0d, to = 1.0d) float r10) {
        if (this.growFraction == r10) goto L6;
        this.growFraction = r10;
        invalidateSelf();
        return;
    }

    void setInternalAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        this.internalAnimationCallback = r10;
    }

    @VisibleForTesting
    void setMockHideAnimationRunning(boolean r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        this.mockHideAnimationRunning = r10;
        this.mockGrowFraction = r11;
    }

    @VisibleForTesting
    void setMockShowAnimationRunning(boolean r10, @FloatRange(from = 0.0d, to = 1.0d) float r11) {
        this.mockShowAnimationRunning = r10;
        this.mockGrowFraction = r11;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean r10, boolean r11) {
        return setVisible(r10, r11, true);
    }

    public boolean setVisible(boolean r10, boolean r11, boolean r12) {
        float r13 = this.animatorDurationScaleProvider.a(this.context.getContentResolver());
        if (r12 == true) goto L5;
    L7:
        boolean r14 = false;
    L9:
        return setVisibleInternal(r10, r11, r14);
    L5:
        if (r13 <= 0.0f) goto L7;
        r14 = true;
        goto L9
    }

    boolean setVisibleInternal(boolean r10, boolean r11, boolean r12) {
        maybeInitializeAnimators();
        if (isVisible() == true) goto L6;
        if (r10 == true) goto L6;
        return false;
    L6:
        if (r10 == false) goto L8;
        ValueAnimator r13 = this.showAnimator;
    L10:
        if (r12 == false) goto L12;
        if (r12 == true) goto L19;
    L21:
        if (r10 == true) goto L23;
    L26:
        boolean r14 = true;
    L27:
        if (r10 == false) goto L29;
        boolean r15 = this.baseSpec.b();
    L30:
        if (r15 == true) goto L33;
        endAnimatorWithoutCallbacks(new ValueAnimator[]{r13});
        return r14;
    L33:
        if (r11 == false) goto L35;
    L40:
        r13.start();
    L41:
        return r14;
    L35:
        if (Build.VERSION.SDK_INT < 19) goto L40;
        if (r13.isPaused() == false) goto L40;
        r13.resume();
        goto L41
    L29:
        r15 = this.baseSpec.a();
        goto L30
    L23:
        if (super.setVisible(r10, false) == true) goto L26;
        r14 = false;
        goto L27
    L19:
        if (r13.isRunning() == false) goto L21;
        return false;
    L12:
        if (r13.isRunning() == false) goto L14;
        r13.end();
    L16:
        return super.setVisible(r10, false);
    L14:
        endAnimatorWithoutCallbacks(new ValueAnimator[]{r13});
        goto L16
    L8:
        r13 = this.hideAnimator;
        goto L10
    }

    public void start() {
        setVisibleInternal(true, true, false);
    }

    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback r10) {
        List<Animatable2Compat.AnimationCallback> r11 = this.animationCallbacks;
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.contains(r10) == false) goto L14;
        this.animationCallbacks.remove(r10);
        if (this.animationCallbacks.isEmpty() == false) goto L13;
        this.animationCallbacks = null;
        return true;
    L13:
        return true;
    L14:
        return false;
    }
}
