package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ExpandCollapseAnimationHelper {

    @Nullable
    private ValueAnimator.AnimatorUpdateListener additionalUpdateListener;
    private final View collapsedView;
    private int collapsedViewOffsetY;
    private long duration;
    private final List<View> endAnchoredViews;
    private final View expandedView;
    private int expandedViewOffsetY;
    private final List<AnimatorListenerAdapter> listeners;

    public ExpandCollapseAnimationHelper(@NonNull View r5, @NonNull View r10) {
        this.collapsedView = r5;
        this.expandedView = r10;
        this.listeners = new ArrayList();
        this.endAnchoredViews = new ArrayList();
    }

    public static /* synthetic */ void a(ExpandCollapseAnimationHelper r5, Rect r10, ValueAnimator r11) {
        r5.lambda$getExpandCollapseAnimator$0(r10, r11);
    }

    public static /* synthetic */ View access$000(ExpandCollapseAnimationHelper r5) {
        return r5.expandedView;
    }

    private void addListeners(Animator r5, List<AnimatorListenerAdapter> r10) {
        Iterator<AnimatorListenerAdapter> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r5.addListener(r11.next());
        goto L4
    }

    private AnimatorSet getAnimatorSet(boolean r5) {
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(new Animator[]{getExpandCollapseAnimator(r5), getExpandedViewChildrenAlphaAnimator(r5), getEndAnchoredViewsTranslateAnimator(r5)});
        return r10;
    }

    private Animator getEndAnchoredViewsTranslateAnimator(boolean r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{(this.collapsedView.getRight() - this.expandedView.getRight()) + (this.expandedView.getLeft() - this.collapsedView.getLeft()), 0.0f});
        r10.addUpdateListener(MultiViewUpdateListener.translationXListener(this.endAnchoredViews));
        r10.setDuration(this.duration);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r10;
    }

    private Animator getExpandCollapseAnimator(boolean r5) {
        Rect r10 = ViewUtils.calculateRectFromBounds(this.collapsedView, this.collapsedViewOffsetY);
        Rect r11 = ViewUtils.calculateRectFromBounds(this.expandedView, this.expandedViewOffsetY);
        Rect r12 = new Rect(r10);
        ValueAnimator r13 = ValueAnimator.ofObject(new RectEvaluator(r12), new Object[]{r10, r11});
        r13.addUpdateListener(new com.google.android.material.appbar.b(1, this, r12));
        ValueAnimator.AnimatorUpdateListener r14 = this.additionalUpdateListener;
        if (r14 == null) goto L5;
        r13.addUpdateListener(r14);
    L5:
        r13.setDuration(this.duration);
        r13.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r13;
    }

    private Animator getExpandedViewChildrenAlphaAnimator(boolean r5) {
        List<View> r10 = ViewUtils.getChildren(this.expandedView);
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r11.addUpdateListener(MultiViewUpdateListener.alphaListener(r10));
        r11.setDuration(this.duration);
        r11.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.LINEAR_INTERPOLATOR));
        return r11;
    }

    private /* synthetic */ void lambda$getExpandCollapseAnimator$0(Rect r5, ValueAnimator r10) {
        ViewUtils.setBoundsFromRect(this.expandedView, r5);
    }

    @NonNull
    public ExpandCollapseAnimationHelper addEndAnchoredViews(@NonNull View... r5) {
        Collections.addAll(this.endAnchoredViews, r5);
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper addListener(@NonNull AnimatorListenerAdapter r5) {
        this.listeners.add(r5);
        return this;
    }

    @NonNull
    public Animator getCollapseAnimator() {
        AnimatorSet r5 = getAnimatorSet(false);
        r5.addListener(new AnonymousClass2(this));
        addListeners(r5, this.listeners);
        return r5;
    }

    @NonNull
    public Animator getExpandAnimator() {
        AnimatorSet r5 = getAnimatorSet(true);
        r5.addListener(new AnonymousClass1(this));
        addListeners(r5, this.listeners);
        return r5;
    }

    @NonNull
    public ExpandCollapseAnimationHelper setAdditionalUpdateListener(@Nullable ValueAnimator.AnimatorUpdateListener r5) {
        this.additionalUpdateListener = r5;
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper setCollapsedViewOffsetY(int r5) {
        this.collapsedViewOffsetY = r5;
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper setDuration(long r5) {
        this.duration = r5;
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper setExpandedViewOffsetY(int r5) {
        this.expandedViewOffsetY = r5;
        return this;
    }

    @NonNull
    public ExpandCollapseAnimationHelper addEndAnchoredViews(@NonNull Collection<View> r5) {
        this.endAnchoredViews.addAll(r5);
        return this;
    }
}
