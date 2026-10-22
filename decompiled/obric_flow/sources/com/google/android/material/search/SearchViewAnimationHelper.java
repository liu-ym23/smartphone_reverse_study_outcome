package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class SearchViewAnimationHelper {
    private static final float CONTENT_FROM_SCALE = 0.95f;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS = 42;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_ALPHA_DURATION_MS = 83;
    private static final long HIDE_CONTENT_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_SCALE_DURATION_MS = 250;
    private static final long HIDE_DURATION_MS = 250;
    private static final long HIDE_TRANSLATE_DURATION_MS = 300;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS = 50;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 250;
    private static final long SHOW_CONTENT_ALPHA_DURATION_MS = 150;
    private static final long SHOW_CONTENT_ALPHA_START_DELAY_MS = 75;
    private static final long SHOW_CONTENT_SCALE_DURATION_MS = 300;
    private static final long SHOW_DURATION_MS = 300;
    private static final long SHOW_TRANSLATE_DURATION_MS = 350;
    private static final long SHOW_TRANSLATE_KEYBOARD_START_DELAY_MS = 150;
    private final MaterialMainContainerBackHelper backHelper;

    @Nullable
    private AnimatorSet backProgressAnimatorSet;
    private final ImageButton clearButton;
    private final TouchObserverFrameLayout contentContainer;
    private final View divider;
    private final Toolbar dummyToolbar;
    private final EditText editText;
    private final FrameLayout headerContainer;
    private final ClippableRoundedCornerLayout rootView;
    private final View scrim;
    private SearchBar searchBar;
    private final TextView searchPrefix;
    private final SearchView searchView;
    private final Toolbar toolbar;
    private final FrameLayout toolbarContainer;

    public SearchViewAnimationHelper(SearchView r5) {
        this.searchView = r5;
        this.scrim = r5.scrim;
        ClippableRoundedCornerLayout r10 = r5.rootView;
        this.rootView = r10;
        this.headerContainer = r5.headerContainer;
        this.toolbarContainer = r5.toolbarContainer;
        this.toolbar = r5.toolbar;
        this.dummyToolbar = r5.dummyToolbar;
        this.searchPrefix = r5.searchPrefix;
        this.editText = r5.editText;
        this.clearButton = r5.clearButton;
        this.divider = r5.divider;
        this.contentContainer = r5.contentContainer;
        this.backHelper = new MaterialMainContainerBackHelper(r10);
    }

    public static /* synthetic */ void a(SearchViewAnimationHelper r5) {
        r5.lambda$startShowAnimationTranslate$1();
    }

    public static /* synthetic */ SearchView access$000(SearchViewAnimationHelper r5) {
        return r5.searchView;
    }

    public static /* synthetic */ ClippableRoundedCornerLayout access$100(SearchViewAnimationHelper r5) {
        return r5.rootView;
    }

    public static /* synthetic */ void access$200(SearchViewAnimationHelper r5, float r10) {
        r5.setContentViewsAlpha(r10);
    }

    public static /* synthetic */ SearchBar access$300(SearchViewAnimationHelper r5) {
        return r5.searchBar;
    }

    private void addActionMenuViewAnimatorIfNeeded(AnimatorSet r10) {
        ActionMenuView r5 = ToolbarUtils.getActionMenuView(this.toolbar);
        if (r5 != null) goto L5;
        return;
    L5:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{getFromTranslationXEnd(r5), 0.0f});
        r11.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{r5}));
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{getFromTranslationY(), 0.0f});
        r12.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{r5}));
        r10.playTogether(new Animator[]{r11, r12});
    }

    private void addBackButtonProgressAnimatorIfNeeded(AnimatorSet r5) {
        ImageButton r10 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (r10 != null) goto L5;
        return;
    L5:
        Drawable r11 = DrawableCompat.unwrap(r10.getDrawable());
        if (this.searchView.isAnimatedNavigationIcon() == false) goto L8;
        addDrawerArrowDrawableAnimatorIfNeeded(r5, r11);
        addFadeThroughDrawableAnimatorIfNeeded(r5, r11);
        return;
    L8:
        setFullDrawableProgressIfNeeded(r11);
    }

    private void addBackButtonTranslationAnimatorIfNeeded(AnimatorSet r10) {
        ImageButton r5 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (r5 != null) goto L5;
        return;
    L5:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{getFromTranslationXStart(r5), 0.0f});
        r11.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{r5}));
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{getFromTranslationY(), 0.0f});
        r12.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{r5}));
        r10.playTogether(new Animator[]{r11, r12});
    }

    private void addDrawerArrowDrawableAnimatorIfNeeded(AnimatorSet r5, Drawable r10) {
        int r11 = 1;
        if ((r10 instanceof DrawerArrowDrawable) == false) goto L6;
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.addUpdateListener(new b((DrawerArrowDrawable) r10, r11));
        r5.playTogether(new Animator[]{r12});
        return;
    }

    private void addFadeThroughDrawableAnimatorIfNeeded(AnimatorSet r5, Drawable r10) {
        int r11 = 2;
        if ((r10 instanceof FadeThroughDrawable) == false) goto L6;
        ValueAnimator r12 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r12.addUpdateListener(new b((FadeThroughDrawable) r10, r11));
        r5.playTogether(new Animator[]{r12});
        return;
    }

    public static /* synthetic */ void b(SearchViewAnimationHelper r5, float r10, float r11, Rect r12, ValueAnimator r13) {
        r5.lambda$getRootViewAnimator$2(r10, r11, r12, r13);
    }

    public static /* synthetic */ void c(DrawerArrowDrawable r5, ValueAnimator r10) {
        lambda$addDrawerArrowDrawableAnimatorIfNeeded$3(r5, r10);
    }

    public static /* synthetic */ void d(SearchViewAnimationHelper r5) {
        r5.lambda$startShowAnimationExpand$0();
    }

    public static /* synthetic */ void e(FadeThroughDrawable r5, ValueAnimator r10) {
        lambda$addFadeThroughDrawableAnimatorIfNeeded$4(r5, r10);
    }

    private Animator getActionMenuViewsAlphaAnimator(boolean r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r5 == false) goto L5;
        long r11 = 300;
    L6:
        r10.setDuration(r11);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (this.searchView.isMenuItemsAnimated() == false) goto L9;
        r10.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.getActionMenuView(this.dummyToolbar), ToolbarUtils.getActionMenuView(this.toolbar)));
    L9:
        return r10;
    L5:
        r11 = 250;
        goto L6
    }

    private AnimatorSet getButtonsProgressAnimator(boolean r5) {
        AnimatorSet r10 = new AnimatorSet();
        addBackButtonProgressAnimatorIfNeeded(r10);
        if (r5 == false) goto L5;
        long r11 = 300;
    L6:
        r10.setDuration(r11);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r10;
    L5:
        r11 = 250;
        goto L6
    }

    private AnimatorSet getButtonsTranslationAnimator(boolean r5) {
        AnimatorSet r10 = new AnimatorSet();
        addBackButtonTranslationAnimatorIfNeeded(r10);
        addActionMenuViewAnimatorIfNeeded(r10);
        if (r5 == false) goto L5;
        long r11 = 300;
    L6:
        r10.setDuration(r11);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r10;
    L5:
        r11 = 250;
        goto L6
    }

    private Animator getClearButtonAnimator(boolean r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r5 == false) goto L5;
        long r11 = SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS;
    L6:
        r10.setDuration(r11);
        if (r5 == false) goto L9;
        long r12 = 250;
    L10:
        r10.setStartDelay(r12);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.LINEAR_INTERPOLATOR));
        r10.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{this.clearButton}));
        return r10;
    L9:
        r12 = 0;
        goto L10
    L5:
        r11 = HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS;
        goto L6
    }

    private Animator getContentAlphaAnimator(boolean r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r5 == false) goto L5;
        long r11 = 150;
    L6:
        r10.setDuration(r11);
        if (r5 == false) goto L9;
        long r12 = 75;
    L10:
        r10.setStartDelay(r12);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.LINEAR_INTERPOLATOR));
        r10.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{this.divider, this.contentContainer}));
        return r10;
    L9:
        r12 = 0;
        goto L10
    L5:
        r11 = HIDE_CONTENT_ALPHA_DURATION_MS;
        goto L6
    }

    private Animator getContentAnimator(boolean r5) {
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(new Animator[]{getContentAlphaAnimator(r5), getDividerAnimator(r5), getContentScaleAnimator(r5)});
        return r10;
    }

    private Animator getContentScaleAnimator(boolean r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{CONTENT_FROM_SCALE, 1.0f});
        if (r5 == false) goto L5;
        long r11 = 300;
    L6:
        r10.setDuration(r11);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        r10.addUpdateListener(MultiViewUpdateListener.scaleListener(new View[]{this.contentContainer}));
        return r10;
    L5:
        r11 = 250;
        goto L6
    }

    private Animator getDividerAnimator(boolean r5) {
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{(this.contentContainer.getHeight() * 0.050000012f) / 2.0f, 0.0f});
        if (r5 == false) goto L5;
        long r11 = 300;
    L6:
        r10.setDuration(r11);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        r10.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{this.divider}));
        return r10;
    L5:
        r11 = 250;
        goto L6
    }

    private Animator getDummyToolbarAnimator(boolean r5) {
        return getTranslationAnimator(r5, false, this.dummyToolbar);
    }

    private Animator getEditTextAnimator(boolean r5) {
        return getTranslationAnimator(r5, true, this.editText);
    }

    private AnimatorSet getExpandCollapseAnimatorSet(final boolean r14) {
        AnimatorSet r5 = new AnimatorSet();
        if (this.backProgressAnimatorSet != null) goto L6;
        r5.playTogether(new Animator[]{getButtonsProgressAnimator(r14), getButtonsTranslationAnimator(r14)});
    L6:
        r5.playTogether(new Animator[]{getScrimAlphaAnimator(r14), getRootViewAnimator(r14), getClearButtonAnimator(r14), getContentAnimator(r14), getHeaderContainerAnimator(r14), getDummyToolbarAnimator(r14), getActionMenuViewsAlphaAnimator(r14), getEditTextAnimator(r14), getSearchPrefixAnimator(r14)});
        r5.addListener(new AnonymousClass5(this, r14));
        return r5;
    }

    private int getFromTranslationXEnd(View r5) {
        int r10 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams) r5.getLayoutParams());
        if (ViewUtils.isLayoutRtl(this.searchBar) == false) goto L6;
        return this.searchBar.getLeft() - r10;
    L6:
        return (this.searchBar.getRight() - this.searchView.getWidth()) + r10;
    }

    private int getFromTranslationXStart(View r5) {
        int r10 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams) r5.getLayoutParams());
        int r11 = ViewCompat.getPaddingStart(this.searchBar);
        if (ViewUtils.isLayoutRtl(this.searchBar) == false) goto L6;
        return ((this.searchBar.getWidth() - this.searchBar.getRight()) + r10) - r11;
    L6:
        return (this.searchBar.getLeft() - r10) + r11;
    }

    private int getFromTranslationY() {
        int r5 = this.toolbarContainer.getTop();
        int r10 = (this.toolbarContainer.getBottom() + r5) / 2;
        int r11 = this.searchBar.getTop();
        return ((this.searchBar.getBottom() + r11) / 2) - r10;
    }

    private Animator getHeaderContainerAnimator(boolean r5) {
        return getTranslationAnimator(r5, false, this.headerContainer);
    }

    private Animator getRootViewAnimator(boolean r10) {
        Rect r5 = this.backHelper.getInitialHideToClipBounds();
        Rect r11 = this.backHelper.getInitialHideFromClipBounds();
        if (r5 != null) goto L6;
        r5 = ViewUtils.calculateRectFromBounds(this.searchView);
    L6:
        if (r11 != null) goto L9;
        r11 = ViewUtils.calculateOffsetRectFromBounds(this.rootView, this.searchBar);
    L9:
        final Rect r12 = new Rect(r11);
        final float r13 = this.searchBar.getCornerSize();
        final float r14 = Math.max(this.rootView.getCornerRadius(), this.backHelper.getExpandedCornerSize());
        ValueAnimator r15 = ValueAnimator.ofObject(new RectEvaluator(r12), new Object[]{r11, r5});
        r15.addUpdateListener(new l(this, r13, r14, r12));
        if (r10 == false) goto L12;
        long r16 = 300;
    L13:
        r15.setDuration(r16);
        r15.setInterpolator(ReversableAnimatedValueInterpolator.of(r10, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r15;
    L12:
        r16 = 250;
        goto L13
    }

    private Animator getScrimAlphaAnimator(boolean r5) {
        if (r5 == false) goto L4;
        TimeInterpolator r10 = AnimationUtils.LINEAR_INTERPOLATOR;
    L5:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (r5 == false) goto L8;
        long r12 = 300;
    L9:
        r11.setDuration(r12);
        r11.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, r10));
        r11.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{this.scrim}));
        return r11;
    L8:
        r12 = 250;
        goto L9
    L4:
        r10 = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        goto L5
    }

    private Animator getSearchPrefixAnimator(boolean r5) {
        return getTranslationAnimator(r5, true, this.searchPrefix);
    }

    private AnimatorSet getTranslateAnimatorSet(boolean r5) {
        AnimatorSet r10 = new AnimatorSet();
        r10.playTogether(new Animator[]{getTranslationYAnimator()});
        addBackButtonProgressAnimatorIfNeeded(r10);
        r10.setInterpolator(ReversableAnimatedValueInterpolator.of(r5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if (r5 == false) goto L5;
        long r11 = SHOW_TRANSLATE_DURATION_MS;
    L6:
        r10.setDuration(r11);
        return r10;
    L5:
        r11 = 300;
        goto L6
    }

    private Animator getTranslationAnimator(boolean r10, boolean r11, View r12) {
        if (r11 == false) goto L5;
        int r13 = getFromTranslationXStart(r12);
    L6:
        ValueAnimator r14 = ValueAnimator.ofFloat(new float[]{r13, 0.0f});
        r14.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{r12}));
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{getFromTranslationY(), 0.0f});
        r5.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{r12}));
        AnimatorSet r15 = new AnimatorSet();
        r15.playTogether(new Animator[]{r14, r5});
        if (r10 == false) goto L9;
        long r16 = 300;
    L10:
        r15.setDuration(r16);
        r15.setInterpolator(ReversableAnimatedValueInterpolator.of(r10, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return r15;
    L9:
        r16 = 250;
        goto L10
    L5:
        r13 = getFromTranslationXEnd(r12);
        goto L6
    }

    private Animator getTranslationYAnimator() {
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{this.rootView.getHeight(), 0.0f});
        r5.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{this.rootView}));
        return r5;
    }

    private static /* synthetic */ void lambda$addDrawerArrowDrawableAnimatorIfNeeded$3(DrawerArrowDrawable r5, ValueAnimator r10) {
        r5.setProgress(((Float) r10.getAnimatedValue()).floatValue());
    }

    private static /* synthetic */ void lambda$addFadeThroughDrawableAnimatorIfNeeded$4(FadeThroughDrawable r5, ValueAnimator r10) {
        r5.setProgress(((Float) r10.getAnimatedValue()).floatValue());
    }

    private /* synthetic */ void lambda$getRootViewAnimator$2(float r5, float r10, Rect r11, ValueAnimator r12) {
        float r13 = AnimationUtils.lerp(r5, r10, r12.getAnimatedFraction());
        this.rootView.updateClipBoundsAndCornerRadius(r11, r13);
    }

    private /* synthetic */ void lambda$startShowAnimationExpand$0() {
        AnimatorSet r5 = getExpandCollapseAnimatorSet(true);
        r5.addListener(new AnonymousClass1(this));
        r5.start();
    }

    private /* synthetic */ void lambda$startShowAnimationTranslate$1() {
        ClippableRoundedCornerLayout r5 = this.rootView;
        r5.setTranslationY(r5.getHeight());
        AnimatorSet r10 = getTranslateAnimatorSet(true);
        r10.addListener(new AnonymousClass3(this));
        r10.start();
    }

    private void setActionMenuViewAlphaIfNeeded(float r5) {
        if (this.searchView.isMenuItemsAnimated() == false) goto L8;
        ActionMenuView r10 = ToolbarUtils.getActionMenuView(this.toolbar);
        if (r10 == null) goto L9;
        r10.setAlpha(r5);
        return;
    L9:
        return;
    }

    private void setContentViewsAlpha(float r5) {
        this.clearButton.setAlpha(r5);
        this.divider.setAlpha(r5);
        this.contentContainer.setAlpha(r5);
        setActionMenuViewAlphaIfNeeded(r5);
    }

    private void setFullDrawableProgressIfNeeded(Drawable r5) {
        if ((r5 instanceof DrawerArrowDrawable) == false) goto L6;
        ((DrawerArrowDrawable) r5).setProgress(1.0f);
    L6:
        if ((r5 instanceof FadeThroughDrawable) == false) goto L9;
        ((FadeThroughDrawable) r5).setProgress(1.0f);
        return;
    }

    private void setMenuItemsNotClickable(Toolbar r5) {
        ActionMenuView r10 = ToolbarUtils.getActionMenuView(r5);
        if (r10 == null) goto L8;
        int r11 = 0;
    L6:
        if (r11 >= r10.getChildCount()) goto L10;
        View r12 = r10.getChildAt(r11);
        r12.setClickable(false);
        r12.setFocusable(false);
        r12.setFocusableInTouchMode(false);
        r11 = r11 + 1;
        goto L6
    L10:
        return;
    }

    private void setUpDummyToolbarIfNeeded() {
        Menu r5 = this.dummyToolbar.getMenu();
        if (r5 == null) goto L6;
        r5.clear();
    L6:
        if (this.searchBar.getMenuResId() != (-1)) goto L8;
    L10:
        this.dummyToolbar.setVisibility(8);
        return;
    L8:
        if (this.searchView.isMenuItemsAnimated() == false) goto L10;
        this.dummyToolbar.inflateMenu(this.searchBar.getMenuResId());
        setMenuItemsNotClickable(this.dummyToolbar);
        this.dummyToolbar.setVisibility(0);
    }

    private AnimatorSet startHideAnimationCollapse() {
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L5;
        this.searchView.clearFocusAndHideKeyboard();
    L5:
        AnimatorSet r5 = getExpandCollapseAnimatorSet(false);
        r5.addListener(new AnonymousClass2(this));
        r5.start();
        return r5;
    }

    private AnimatorSet startHideAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L5;
        this.searchView.clearFocusAndHideKeyboard();
    L5:
        AnimatorSet r5 = getTranslateAnimatorSet(false);
        r5.addListener(new AnonymousClass4(this));
        r5.start();
        return r5;
    }

    private void startShowAnimationExpand() {
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L5;
        this.searchView.requestFocusAndShowKeyboardIfNeeded();
    L5:
        this.searchView.setTransitionState(SearchView.TransitionState.SHOWING);
        setUpDummyToolbarIfNeeded();
        this.editText.setText(this.searchBar.getText());
        EditText r5 = this.editText;
        r5.setSelection(r5.getText().length());
        this.rootView.setVisibility(4);
        this.rootView.post(new m(this, 0));
    }

    private void startShowAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L5;
        SearchView r5 = this.searchView;
        Objects.requireNonNull(r5);
        r5.postDelayed(new g(r5, 3), 150);
    L5:
        this.rootView.setVisibility(4);
        this.rootView.post(new m(this, 1));
    }

    @RequiresApi(34)
    public void cancelBackProgress() {
        this.backHelper.cancelBackProgress(this.searchBar);
        AnimatorSet r5 = this.backProgressAnimatorSet;
        if (r5 == null) goto L5;
        r5.reverse();
    L5:
        this.backProgressAnimatorSet = null;
    }

    @RequiresApi(34)
    public void finishBackProgress() {
        long r5 = hide().getTotalDuration();
        this.backHelper.finishBackProgress(r5, this.searchBar);
        if (this.backProgressAnimatorSet == null) goto L5;
        getButtonsTranslationAnimator(false).start();
        this.backProgressAnimatorSet.resume();
    L5:
        this.backProgressAnimatorSet = null;
    }

    public MaterialMainContainerBackHelper getBackHelper() {
        return this.backHelper;
    }

    public AnimatorSet hide() {
        if (this.searchBar == null) goto L7;
        return startHideAnimationCollapse();
    L7:
        return startHideAnimationTranslate();
    }

    @Nullable
    public BackEventCompat onHandleBackInvoked() {
        return this.backHelper.onHandleBackInvoked();
    }

    public void setSearchBar(SearchBar r5) {
        this.searchBar = r5;
    }

    public void show() {
        if (this.searchBar == null) goto L5;
        startShowAnimationExpand();
        return;
    L5:
        startShowAnimationTranslate();
    }

    public void startBackProgress(@NonNull BackEventCompat r5) {
        this.backHelper.startBackProgress(r5, this.searchBar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @RequiresApi(34)
    public void updateBackProgress(@NonNull BackEventCompat r5) {
        if (r5.getProgress() > 0.0f) goto L5;
        return;
    L5:
        MaterialMainContainerBackHelper r10 = this.backHelper;
        SearchBar r11 = this.searchBar;
        r10.updateBackProgress(r5, r11, r11.getCornerSize());
        AnimatorSet r12 = this.backProgressAnimatorSet;
        if (r12 == null) goto L8;
        r12.setCurrentPlayTime((long) (r5.getProgress() * this.backProgressAnimatorSet.getDuration()));
        return;
    L8:
        if (this.searchView.isAdjustNothingSoftInputMode() == false) goto L11;
        this.searchView.clearFocusAndHideKeyboard();
    L11:
        if (this.searchView.isAnimatedNavigationIcon() == true) goto L13;
        return;
    L13:
        AnimatorSet r13 = getButtonsProgressAnimator(false);
        this.backProgressAnimatorSet = r13;
        r13.start();
        this.backProgressAnimatorSet.pause();
    }
}
