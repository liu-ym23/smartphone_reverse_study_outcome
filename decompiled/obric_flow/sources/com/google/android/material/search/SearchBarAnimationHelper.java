package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class SearchBarAnimationHelper {
    private static final long COLLAPSE_DURATION_MS = 250;
    private static final long COLLAPSE_FADE_IN_CHILDREN_DURATION_MS = 100;
    private static final long EXPAND_DURATION_MS = 300;
    private static final long EXPAND_FADE_OUT_CHILDREN_DURATION_MS = 75;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_DURATION_MS = 250;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_IN_START_DELAY_MS = 500;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_OUT_START_DELAY_MS = 750;
    private static final long ON_LOAD_ANIM_SECONDARY_DURATION_MS = 250;
    private static final long ON_LOAD_ANIM_SECONDARY_START_DELAY_MS = 250;
    private final Set<AnimatorListenerAdapter> collapseAnimationListeners;
    private boolean collapsing;

    @Nullable
    private Animator defaultCenterViewAnimator;
    private final Set<AnimatorListenerAdapter> expandAnimationListeners;
    private boolean expanding;
    private final Set<SearchBar.OnLoadAnimationCallback> onLoadAnimationCallbacks;
    private boolean onLoadAnimationFadeInEnabled;
    private Animator runningExpandOrCollapseAnimator;

    @Nullable
    private Animator secondaryViewAnimator;

    public interface OnLoadAnimationInvocation {
        void invoke(SearchBar.OnLoadAnimationCallback r5);
    }

    public SearchBarAnimationHelper() {
        this.onLoadAnimationCallbacks = new LinkedHashSet();
        this.expandAnimationListeners = new LinkedHashSet();
        this.collapseAnimationListeners = new LinkedHashSet();
        this.onLoadAnimationFadeInEnabled = true;
        this.runningExpandOrCollapseAnimator = null;
    }

    public static /* synthetic */ void a(ValueAnimator r5, View r10) {
        lambda$getFadeOutChildrenAnimator$2(r10, r5);
    }

    public static /* synthetic */ void access$000(SearchBarAnimationHelper r5, OnLoadAnimationInvocation r10) {
        r5.dispatchOnLoadAnimation(r10);
    }

    public static /* synthetic */ boolean access$102(SearchBarAnimationHelper r5, boolean r10) {
        r5.expanding = r10;
        return r10;
    }

    public static /* synthetic */ Animator access$202(SearchBarAnimationHelper r5, Animator r10) {
        r5.runningExpandOrCollapseAnimator = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$302(SearchBarAnimationHelper r5, boolean r10) {
        r5.collapsing = r10;
        return r10;
    }

    public static /* synthetic */ void b(SearchBarAnimationHelper r5, SearchBar r10, View r11, AppBarLayout r12, boolean r13) {
        r5.lambda$startExpandAnimation$0(r10, r11, r12, r13);
    }

    public static /* synthetic */ void c(MaterialShapeDrawable r5, View r10, ValueAnimator r11) {
        lambda$getExpandedViewBackgroundUpdateListener$1(r5, r10, r11);
    }

    private void dispatchOnLoadAnimation(OnLoadAnimationInvocation r5) {
        Iterator<SearchBar.OnLoadAnimationCallback> r10 = this.onLoadAnimationCallbacks.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r5.invoke(r10.next());
        goto L4
    }

    private Animator getCollapseAnimator(final SearchBar r5, View r10, AppBarLayout r11) {
        return getExpandCollapseAnimationHelper(r5, r10, r11).setDuration(250).addListener(new AnonymousClass6(this, r5)).getCollapseAnimator();
    }

    private Animator getDefaultCenterViewAnimator(@Nullable View r11) {
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r5.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{r11}));
        TimeInterpolator r10 = AnimationUtils.LINEAR_INTERPOLATOR;
        r5.setInterpolator(r10);
        long r12 = 0;
        if (this.onLoadAnimationFadeInEnabled == false) goto L5;
        long r13 = 250;
    L6:
        r5.setDuration(r13);
        if (this.onLoadAnimationFadeInEnabled == false) goto L9;
        r12 = ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_IN_START_DELAY_MS;
    L9:
        r5.setStartDelay(r12);
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r14.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{r11}));
        r14.setInterpolator(r10);
        r14.setDuration(250);
        r14.setStartDelay(ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_OUT_START_DELAY_MS);
        AnimatorSet r15 = new AnimatorSet();
        r15.playSequentially(new Animator[]{r5, r14});
        return r15;
    L5:
        r13 = 0;
        goto L6
    }

    private List<View> getEndAnchoredViews(View r5) {
        boolean r10 = ViewUtils.isLayoutRtl(r5);
        ArrayList r11 = new ArrayList();
        if ((r5 instanceof ViewGroup) == false) goto L16;
        ViewGroup r12 = (ViewGroup) r5;
        int r13 = 0;
    L6:
        if (r13 >= r12.getChildCount()) goto L16;
        View r14 = r12.getChildAt(r13);
        if (r10 == false) goto L10;
    L11:
        if (r10 == false) goto L15;
        if ((r14 instanceof ActionMenuView) == true) goto L15;
    L14:
        r11.add(r14);
    L15:
        r13 = r13 + 1;
        goto L6
    L10:
        if ((r14 instanceof ActionMenuView) == true) goto L14;
    L16:
        return r11;
    }

    private Animator getExpandAnimator(final SearchBar r5, View r10, @Nullable AppBarLayout r11) {
        return getExpandCollapseAnimationHelper(r5, r10, r11).setDuration(EXPAND_DURATION_MS).addListener(new AnonymousClass4(this, r5)).getExpandAnimator();
    }

    private ExpandCollapseAnimationHelper getExpandCollapseAnimationHelper(SearchBar r5, View r10, @Nullable AppBarLayout r11) {
        ExpandCollapseAnimationHelper r12 = new ExpandCollapseAnimationHelper(r5, r10).setAdditionalUpdateListener(getExpandedViewBackgroundUpdateListener(r5, r10));
        if (r11 == null) goto L5;
        int r13 = r11.getTop();
    L7:
        return r12.setCollapsedViewOffsetY(r13).addEndAnchoredViews(getEndAnchoredViews(r10));
    L5:
        r13 = 0;
        goto L7
    }

    private ValueAnimator.AnimatorUpdateListener getExpandedViewBackgroundUpdateListener(SearchBar r5, final View r10) {
        final MaterialShapeDrawable r11 = MaterialShapeDrawable.createWithElevationOverlay(r10.getContext());
        r11.setCornerSize(r5.getCornerSize());
        r11.setElevation(ViewCompat.getElevation(r5));
        return new e(r10, r11);
    }

    private List<View> getFadeChildren(SearchBar r5) {
        List<View> r10 = ViewUtils.getChildren(r5);
        if (r5.getCenterView() == null) goto L5;
        r10.remove(r5.getCenterView());
    L5:
        return r10;
    }

    private Animator getFadeInChildrenAnimator(SearchBar r5) {
        List<View> r10 = getFadeChildren(r5);
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r11.addUpdateListener(MultiViewUpdateListener.alphaListener(r10));
        r11.setDuration(COLLAPSE_FADE_IN_CHILDREN_DURATION_MS);
        r11.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r11;
    }

    private Animator getFadeOutChildrenAnimator(SearchBar r5, View r10) {
        List<View> r11 = getFadeChildren(r5);
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r12.addUpdateListener(MultiViewUpdateListener.alphaListener(r11));
        r12.addUpdateListener(new b(r10, 0));
        r12.setDuration(75);
        r12.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return r12;
    }

    private Animator getSecondaryActionMenuItemAnimator(@Nullable View r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{r5}));
        r10.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r10.setDuration(250);
        return r10;
    }

    private Animator getSecondaryViewAnimator(TextView r5, @Nullable View r10) {
        AnimatorSet r11 = new AnimatorSet();
        r11.setStartDelay(250);
        r11.play(getTextViewAnimator(r5));
        if (r10 == null) goto L5;
        r11.play(getSecondaryActionMenuItemAnimator(r10));
    L5:
        return r11;
    }

    private Animator getTextViewAnimator(TextView r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r10.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{r5}));
        r10.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        r10.setDuration(250);
        return r10;
    }

    private static /* synthetic */ void lambda$getExpandedViewBackgroundUpdateListener$1(MaterialShapeDrawable r5, View r10, ValueAnimator r11) {
        r5.setInterpolation(1.0f - r11.getAnimatedFraction());
        ViewCompat.setBackground(r10, r5);
        r10.setAlpha(1.0f);
    }

    private static /* synthetic */ void lambda$getFadeOutChildrenAnimator$2(View r5, ValueAnimator r10) {
        r5.setAlpha(0.0f);
    }

    private /* synthetic */ void lambda$startExpandAnimation$0(SearchBar r5, View r10, AppBarLayout r11, boolean r12) {
        AnimatorSet r13 = new AnimatorSet();
        r13.playSequentially(new Animator[]{getFadeOutChildrenAnimator(r5, r10), getExpandAnimator(r5, r10, r11)});
        r13.addListener(new AnonymousClass3(this));
        Iterator<AnimatorListenerAdapter> r14 = this.expandAnimationListeners.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.addListener(r14.next());
        goto L4
    L6:
        if (r12 == false) goto L8;
        r13.setDuration(0);
    L8:
        r13.start();
        this.runningExpandOrCollapseAnimator = r13;
    }

    public void addCollapseAnimationListener(@NonNull AnimatorListenerAdapter r5) {
        this.collapseAnimationListeners.add(r5);
    }

    public void addExpandAnimationListener(@NonNull AnimatorListenerAdapter r5) {
        this.expandAnimationListeners.add(r5);
    }

    public void addOnLoadAnimationCallback(SearchBar.OnLoadAnimationCallback r5) {
        this.onLoadAnimationCallbacks.add(r5);
    }

    public boolean isCollapsing() {
        return this.collapsing;
    }

    public boolean isExpanding() {
        return this.expanding;
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.onLoadAnimationFadeInEnabled;
    }

    public boolean removeCollapseAnimationListener(@NonNull AnimatorListenerAdapter r5) {
        return this.collapseAnimationListeners.remove(r5);
    }

    public boolean removeExpandAnimationListener(@NonNull AnimatorListenerAdapter r5) {
        return this.expandAnimationListeners.remove(r5);
    }

    public boolean removeOnLoadAnimationCallback(SearchBar.OnLoadAnimationCallback r5) {
        return this.onLoadAnimationCallbacks.remove(r5);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean r5) {
        this.onLoadAnimationFadeInEnabled = r5;
    }

    public void startCollapseAnimation(SearchBar r5, View r10, @Nullable AppBarLayout r11, boolean r12) {
        if (isExpanding() == false) goto L7;
        Animator r13 = this.runningExpandOrCollapseAnimator;
        if (r13 == null) goto L7;
        r13.cancel();
    L7:
        this.collapsing = true;
        AnimatorSet r14 = new AnimatorSet();
        r14.playSequentially(new Animator[]{getCollapseAnimator(r5, r10, r11), getFadeInChildrenAnimator(r5)});
        r14.addListener(new AnonymousClass5(this));
        Iterator<AnimatorListenerAdapter> r15 = this.collapseAnimationListeners.iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        r14.addListener(r15.next());
        goto L9
    L11:
        if (r12 == false) goto L13;
        r14.setDuration(0);
    L13:
        r14.start();
        this.runningExpandOrCollapseAnimator = r14;
    }

    public void startExpandAnimation(final SearchBar r10, final View r11, @Nullable final AppBarLayout r12, final boolean r13) {
        if (isCollapsing() == false) goto L7;
        Animator r5 = this.runningExpandOrCollapseAnimator;
        if (r5 == null) goto L7;
        r5.cancel();
    L7:
        this.expanding = true;
        r11.setVisibility(4);
        r11.post(new d(this, r10, r11, r12, r13));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startOnLoadAnimation(SearchBar r5) {
        dispatchOnLoadAnimation(new c(0));
        TextView r10 = r5.getTextView();
        final View r11 = r5.getCenterView();
        View r12 = ToolbarUtils.getSecondaryActionMenuItemView(r5);
        final Animator r13 = getSecondaryViewAnimator(r10, r12);
        r13.addListener(new AnonymousClass1(this));
        this.secondaryViewAnimator = r13;
        r10.setAlpha(0.0f);
        if (r12 == null) goto L6;
        r12.setAlpha(0.0f);
    L6:
        if ((r11 instanceof AnimatableView) == false) goto L8;
        ((AnimatableView) r11).startAnimation(new a(r13));
        return;
    L8:
        if (r11 == 0) goto L10;
        r11.setAlpha(0.0f);
        r11.setVisibility(0);
        Animator r14 = getDefaultCenterViewAnimator(r11);
        this.defaultCenterViewAnimator = r14;
        r14.addListener(new AnonymousClass2(this, r11, r13));
        r14.start();
        return;
    L10:
        r13.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void stopOnLoadAnimation(SearchBar r5) {
        Animator r10 = this.secondaryViewAnimator;
        if (r10 == null) goto L5;
        r10.end();
    L5:
        Animator r11 = this.defaultCenterViewAnimator;
        if (r11 == null) goto L8;
        r11.end();
    L8:
        View r12 = r5.getCenterView();
        if ((r12 instanceof AnimatableView) == false) goto L11;
        ((AnimatableView) r12).stopAnimation();
    L11:
        if (r12 == 0) goto L14;
        r12.setAlpha(0.0f);
        return;
    }
}
