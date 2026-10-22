package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes2.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ENTER_ANIMATION_DURATION_MS = 225;
    private static final int DEFAULT_EXIT_ANIMATION_DURATION_MS = 175;
    private static final int ENTER_ANIM_DURATION_ATTR = 0;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = 0;
    private static final int EXIT_ANIM_DURATION_ATTR = 0;
    public static final int STATE_SCROLLED_DOWN = 1;
    public static final int STATE_SCROLLED_UP = 2;
    private int additionalHiddenOffsetY;

    @Nullable
    private ViewPropertyAnimator currentAnimator;

    @ScrollState
    private int currentState;
    private int enterAnimDuration;
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    private TimeInterpolator exitAnimInterpolator;
    private int height;

    @NonNull
    private final LinkedHashSet<OnScrollStateChangedListener> onScrollStateChangedListeners;

    public interface OnScrollStateChangedListener {
        void onStateChanged(@NonNull View r5, @ScrollState int r10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ScrollState {
    }

    static {
        ENTER_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
        EXIT_ANIM_DURATION_ATTR = R.attr.motionDurationMedium4;
        ENTER_EXIT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    }

    public HideBottomViewOnScrollBehavior() {
        this.onScrollStateChangedListeners = new LinkedHashSet();
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }

    public static /* synthetic */ ViewPropertyAnimator access$002(HideBottomViewOnScrollBehavior r5, ViewPropertyAnimator r10) {
        r5.currentAnimator = r10;
        return r10;
    }

    private void animateChildTo(@NonNull V r5, int r10, long r11, TimeInterpolator r12) {
        this.currentAnimator = r5.animate().translationY(r10).setInterpolator(r12).setDuration(r11).setListener(new AnonymousClass1(this));
    }

    private void updateCurrentState(@NonNull V r5, @ScrollState int r10) {
        this.currentState = r10;
        Iterator<OnScrollStateChangedListener> r11 = this.onScrollStateChangedListeners.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onStateChanged(r5, this.currentState);
        goto L4
    }

    public void addOnScrollStateChangedListener(@NonNull OnScrollStateChangedListener r5) {
        this.onScrollStateChangedListeners.add(r5);
    }

    public void clearOnScrollStateChangedListeners() {
        this.onScrollStateChangedListeners.clear();
    }

    public boolean isScrolledDown() {
        if (this.currentState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isScrolledUp() {
        if (this.currentState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout r5, @NonNull V r10, int r11) {
        ViewGroup.MarginLayoutParams r12 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        this.height = r10.getMeasuredHeight() + r12.bottomMargin;
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(r10.getContext(), ENTER_ANIM_DURATION_ATTR, DEFAULT_ENTER_ANIMATION_DURATION_MS);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(r10.getContext(), EXIT_ANIM_DURATION_ATTR, DEFAULT_EXIT_ANIMATION_DURATION_MS);
        Context r13 = r10.getContext();
        int r14 = ENTER_EXIT_ANIM_EASING_ATTR;
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(r13, r14, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(r10.getContext(), r14, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        return super.onLayoutChild(r5, r10, r11);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, int r12, int r13, int r14, int r15, int r16, @NonNull int[] r17) {
        if (r13 <= 0) goto L4;
        slideDown(r10);
        return;
    L4:
        if (r13 >= 0) goto L8;
        slideUp(r10);
        return;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout r5, @NonNull V r10, @NonNull View r11, @NonNull View r12, int r13, int r14) {
        if (r13 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void removeOnScrollStateChangedListener(@NonNull OnScrollStateChangedListener r5) {
        this.onScrollStateChangedListeners.remove(r5);
    }

    public void setAdditionalHiddenOffsetY(@NonNull V r5, @Dimension int r10) {
        this.additionalHiddenOffsetY = r10;
        if (this.currentState != 1) goto L6;
        r5.setTranslationY(this.height + r10);
        return;
    }

    public void slideDown(@NonNull V r5) {
        slideDown(r5, true);
    }

    public void slideUp(@NonNull V r5) {
        slideUp(r5, true);
    }

    public void slideDown(@NonNull V r10, boolean r11) {
        if (isScrolledDown() == false) goto L5;
        return;
    L5:
        ViewPropertyAnimator r5 = this.currentAnimator;
        if (r5 == null) goto L8;
        r5.cancel();
        r10.clearAnimation();
    L8:
        updateCurrentState(r10, 1);
        int r12 = this.height + this.additionalHiddenOffsetY;
        if (r11 == false) goto L11;
        animateChildTo(r10, r12, this.exitAnimDuration, this.exitAnimInterpolator);
        return;
    L11:
        r10.setTranslationY(r12);
    }

    public void slideUp(@NonNull V r10, boolean r11) {
        if (isScrolledUp() == false) goto L5;
        return;
    L5:
        ViewPropertyAnimator r5 = this.currentAnimator;
        if (r5 == null) goto L8;
        r5.cancel();
        r10.clearAnimation();
    L8:
        updateCurrentState(r10, 2);
        if (r11 == false) goto L11;
        animateChildTo(r10, 0, this.enterAnimDuration, this.enterAnimInterpolator);
        return;
    L11:
        r10.setTranslationY(0);
    }

    public HideBottomViewOnScrollBehavior(Context r5, AttributeSet r10) {
        super(r5, r10);
        this.onScrollStateChangedListeners = new LinkedHashSet();
        this.height = 0;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
    }
}
