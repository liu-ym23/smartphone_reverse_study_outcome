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
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    static final float DEFAULT_OPACITY = 0.2f;
    static final int DEF_STYLE_RES = 0;
    public static final int HIDE_ESCAPE = 3;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    static final int MAX_ALPHA = 255;
    static final int MAX_HIDE_DELAY = 1000;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final Runnable delayedHide;
    private final Runnable delayedShow;
    private final Animatable2Compat.AnimationCallback hideAnimationCallback;
    private boolean isIndeterminateModeChangeRequested;
    private boolean isParentDoneInitializing;
    private long lastShowStartTime;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    private int storedProgress;
    private boolean storedProgressAnimated;
    private final Animatable2Compat.AnimationCallback switchIndeterminateModeCallback;
    private int visibilityAfterHide;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface HideAnimationBehavior {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ShowAnimationBehavior {
    }

    static {
        DEF_STYLE_RES = R.style.Widget_MaterialComponents_ProgressIndicator;
    }

    public BaseProgressIndicator(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        super(MaterialThemeOverlay.wrap(r10, r11, r12, DEF_STYLE_RES), r11, r12);
        this.lastShowStartTime = -1;
        this.isIndeterminateModeChangeRequested = false;
        this.visibilityAfterHide = 4;
        this.delayedShow = new AnonymousClass1(this);
        this.delayedHide = new AnonymousClass2(this);
        this.switchIndeterminateModeCallback = new AnonymousClass3(this);
        this.hideAnimationCallback = new AnonymousClass4(this);
        Context r5 = getContext();
        this.spec = (S) createSpec(r5, r11);
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r5, r11, R.styleable.BaseProgressIndicator, r12, r13, new int[0]);
        this.showDelay = r14.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.minHideDelay = Math.min(r14.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        r14.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    public static /* synthetic */ void access$000(BaseProgressIndicator r5) {
        r5.internalShow();
    }

    public static /* synthetic */ void access$100(BaseProgressIndicator r5) {
        r5.internalHide();
    }

    public static /* synthetic */ long access$202(BaseProgressIndicator r5, long r10) {
        r5.lastShowStartTime = r10;
        return r10;
    }

    public static /* synthetic */ int access$300(BaseProgressIndicator r5) {
        return r5.storedProgress;
    }

    public static /* synthetic */ boolean access$400(BaseProgressIndicator r5) {
        return r5.storedProgressAnimated;
    }

    public static /* synthetic */ boolean access$500(BaseProgressIndicator r5) {
        return r5.isIndeterminateModeChangeRequested;
    }

    public static /* synthetic */ int access$600(BaseProgressIndicator r5) {
        return r5.visibilityAfterHide;
    }

    @Nullable
    private DrawingDelegate<S> getCurrentDrawingDelegate() {
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

    private void internalHide() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible() == false) goto L6;
        setVisibility(4);
        return;
    }

    private void internalShow() {
        if (this.minHideDelay <= 0) goto L5;
        this.lastShowStartTime = SystemClock.uptimeMillis();
    L5:
        setVisibility(0);
    }

    private boolean isNoLongerNeedToBeVisible() {
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

    private void registerAnimationCallbacks() {
        if (getProgressDrawable() == null) goto L8;
        if (getIndeterminateDrawable() == null) goto L8;
        getIndeterminateDrawable().getAnimatorDelegate().registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
    L8:
        if (getProgressDrawable() == null) goto L11;
        getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
    L11:
        if (getIndeterminateDrawable() == null) goto L14;
        getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        return;
    }

    private void unregisterAnimationCallbacks() {
        if (getIndeterminateDrawable() == null) goto L6;
        getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        getIndeterminateDrawable().getAnimatorDelegate().unregisterAnimatorsCompleteCallback();
    L6:
        if (getProgressDrawable() == null) goto L9;
        getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        return;
    }

    public void applyNewVisibility(boolean r5) {
        if (this.isParentDoneInitializing == true) goto L5;
        return;
    L5:
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, r5);
    }

    public abstract S createSpec(@NonNull Context r5, @NonNull AttributeSet r10);

    @Override // android.widget.ProgressBar
    @Nullable
    public Drawable getCurrentDrawable() {
        if (isIndeterminate() == false) goto L6;
        return getIndeterminateDrawable();
    L6:
        return getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public /* bridge */ /* synthetic */ Drawable getIndeterminateDrawable() {
        return getIndeterminateDrawable();
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    @Px
    public int getIndicatorTrackGapSize() {
        return this.spec.indicatorTrackGapSize;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public /* bridge */ /* synthetic */ Drawable getProgressDrawable() {
        return getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    @ColorInt
    public int getTrackColor() {
        return this.spec.trackColor;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    @Px
    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    public void hide() {
        if (getVisibility() == 0) goto L6;
        removeCallbacks(this.delayedShow);
        return;
    L6:
        removeCallbacks(this.delayedHide);
        long r5 = SystemClock.uptimeMillis() - this.lastShowStartTime;
        int r10 = this.minHideDelay;
        if (r5 < r10) goto L10;
        this.delayedHide.run();
        return;
    L10:
        postDelayed(this.delayedHide, ((long) r10) - r5);
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() == null) goto L6;
        getCurrentDrawable().invalidateSelf();
        return;
    }

    public boolean isEffectivelyVisible() {
        View r5 = this;
    L4:
        if (r5.getVisibility() != 0) goto L5;
        Object r10 = r5.getParent();
        if (r10 == null) goto L9;
        if ((r10 instanceof View) == false) goto L14;
        r5 = (View) r10;
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

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerAnimationCallbacks();
        if (visibleToUser() == false) goto L6;
        internalShow();
        return;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NonNull Canvas r10) {
        monitor-enter(this);
        int r5 = r10.save();     // Catch: Throwable -> L8
        if (getPaddingLeft() == 0) goto L6;
    L10:
        r10.translate(getPaddingLeft(), getPaddingTop());     // Catch: Throwable -> L8
    L12:
        if (getPaddingRight() == 0) goto L14;
    L15:
        r10.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));     // Catch: Throwable -> L8
    L16:
        getCurrentDrawable().draw(r10);     // Catch: Throwable -> L8
        r10.restoreToCount(r5);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L14:
        if (getPaddingBottom() == 0) goto L16;
    L6:
        if (getPaddingTop() == 0) goto L12;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r5, int r10) {
        monitor-enter(this);
        DrawingDelegate<S> r11 = getCurrentDrawingDelegate();     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (r11.getPreferredWidth() >= 0) goto L12;
        int r12 = View.getDefaultSize(getSuggestedMinimumWidth(), r5);     // Catch: Throwable -> L10
    L14:
        if (r11.getPreferredHeight() >= 0) goto L16;
        int r13 = View.getDefaultSize(getSuggestedMinimumHeight(), r10);     // Catch: Throwable -> L10
    L17:
        setMeasuredDimension(r12, r13);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L16:
        r13 = (r11.getPreferredHeight() + getPaddingTop()) + getPaddingBottom();     // Catch: Throwable -> L10
        goto L17
    L12:
        r12 = (r11.getPreferredWidth() + getPaddingLeft()) + getPaddingRight();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View r5, int r10) {
        super.onVisibilityChanged(r5, r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        applyNewVisibility(r11);
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r5) {
        super.onWindowVisibilityChanged(r5);
        applyNewVisibility(false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider r5) {
        this.animatorDurationScaleProvider = r5;
        if (getProgressDrawable() == null) goto L6;
        getProgressDrawable().animatorDurationScaleProvider = r5;
    L6:
        if (getIndeterminateDrawable() == null) goto L9;
        getIndeterminateDrawable().animatorDurationScaleProvider = r5;
        return;
    }

    public void setHideAnimationBehavior(int r5) {
        this.spec.hideAnimationBehavior = r5;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean r5) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (r5 != isIndeterminate()) goto L7;
        monitor-exit(this);
        return;
    L7:
        DrawableWithAnimatedVisibilityChange r10 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();     // Catch: Throwable -> L10
        if (r10 == null) goto L12;
        r10.hideNow();     // Catch: Throwable -> L10
    L12:
        super.setIndeterminate(r5);     // Catch: Throwable -> L10
        DrawableWithAnimatedVisibilityChange r11 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();     // Catch: Throwable -> L10
        if (r11 == null) goto L16;
        r11.setVisible(visibleToUser(), false, false);     // Catch: Throwable -> L10
    L16:
        if ((r11 instanceof IndeterminateDrawable) == true) goto L18;
    L20:
        this.isIndeterminateModeChangeRequested = false;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L18:
        if (visibleToUser() == false) goto L20;
        ((IndeterminateDrawable) r11).getAnimatorDelegate().startAnimator();     // Catch: Throwable -> L10
        goto L20
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(@Nullable Drawable r5) {
        if (r5 != null) goto L6;
        super.setIndeterminateDrawable(null);
        return;
    L6:
        if ((r5 instanceof IndeterminateDrawable) == false) goto L10;
        ((DrawableWithAnimatedVisibilityChange) r5).hideNow();
        super.setIndeterminateDrawable(r5);
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
    }

    public void setIndicatorColor(@ColorInt int... r5) {
        if (r5.length != 0) goto L6;
        r5 = new int[]{MaterialColors.getColor(getContext(), R.attr.colorPrimary, -1)};
    L6:
        if (Arrays.equals(getIndicatorColor(), r5) == true) goto L9;
        this.spec.indicatorColors = r5;
        getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
        invalidate();
        return;
    }

    public void setIndicatorTrackGapSize(@Px int r5) {
        S r10 = this.spec;
        if (r10.indicatorTrackGapSize == r5) goto L6;
        r10.indicatorTrackGapSize = r5;
        r10.validateSpec();
        invalidate();
        return;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int r5) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (isIndeterminate() == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        setProgressCompat(r5, false);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void setProgressCompat(int r5, boolean r10) {
        if (isIndeterminate() == true) goto L5;
        super.setProgress(r5);
        if (getProgressDrawable() == null) goto L21;
        if (r10 == true) goto L22;
        getProgressDrawable().jumpToCurrentState();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (getProgressDrawable() == null) goto L18;
        this.storedProgress = r5;
        this.storedProgressAnimated = r10;
        this.isIndeterminateModeChangeRequested = true;
        if (getIndeterminateDrawable().isVisible() == true) goto L9;
    L12:
        this.switchIndeterminateModeCallback.onAnimationEnd(getIndeterminateDrawable());
        return;
    L9:
        if (this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) goto L12;
        getIndeterminateDrawable().getAnimatorDelegate().requestCancelAnimatorAfterCurrentCycle();
        return;
    }

    @Override // android.widget.ProgressBar
    public void setProgressDrawable(@Nullable Drawable r5) {
        if (r5 != null) goto L6;
        super.setProgressDrawable(null);
        return;
    L6:
        if ((r5 instanceof DeterminateDrawable) == false) goto L10;
        DeterminateDrawable r10 = (DeterminateDrawable) r5;
        r10.hideNow();
        super.setProgressDrawable(r10);
        r10.setLevelByFraction(getProgress() / getMax());
        return;
    L10:
        throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
    }

    public void setShowAnimationBehavior(int r5) {
        this.spec.showAnimationBehavior = r5;
        invalidate();
    }

    public void setTrackColor(@ColorInt int r5) {
        S r10 = this.spec;
        if (r10.trackColor == r5) goto L6;
        r10.trackColor = r5;
        invalidate();
        return;
    }

    public void setTrackCornerRadius(@Px int r5) {
        S r10 = this.spec;
        if (r10.trackCornerRadius == r5) goto L6;
        r10.trackCornerRadius = Math.min(r5, r10.trackThickness / 2);
        invalidate();
        return;
    }

    public void setTrackThickness(@Px int r5) {
        S r10 = this.spec;
        if (r10.trackThickness == r5) goto L6;
        r10.trackThickness = r5;
        requestLayout();
        return;
    }

    public void setVisibilityAfterHide(int r5) {
        if (r5 != 0) goto L4;
    L10:
        this.visibilityAfterHide = r5;
        return;
    L4:
        if (r5 == 4) goto L10;
        if (r5 == 8) goto L10;
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void show() {
        if (this.showDelay <= 0) goto L5;
        removeCallbacks(this.delayedShow);
        postDelayed(this.delayedShow, this.showDelay);
        return;
    L5:
        this.delayedShow.run();
    }

    public boolean visibleToUser() {
        if (ViewCompat.isAttachedToWindow(this) == true) goto L5;
    L9:
        return false;
    L5:
        if (getWindowVisibility() != 0) goto L9;
        if (isEffectivelyVisible() == false) goto L9;
        return true;
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Override // android.widget.ProgressBar
    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
