package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior, MaterialBackHandler {
    private static final int DEF_STYLE_RES = 0;
    private static final long TALKBACK_FOCUS_CHANGE_DELAY_MS = 100;
    private boolean animatedMenuItems;
    private boolean animatedNavigationIcon;
    private boolean autoShowKeyboard;
    private final boolean backHandlingEnabled;

    @NonNull
    private final MaterialBackOrchestrator backOrchestrator;

    @ColorInt
    private final int backgroundColor;
    final View backgroundView;
    private Map<View, Integer> childImportantForAccessibilityMap;
    final ImageButton clearButton;
    final TouchObserverFrameLayout contentContainer;

    @NonNull
    private TransitionState currentTransitionState;
    final View divider;
    final Toolbar dummyToolbar;
    final EditText editText;
    private final ElevationOverlayProvider elevationOverlayProvider;
    final FrameLayout headerContainer;
    private final boolean layoutInflated;
    final ClippableRoundedCornerLayout rootView;
    final View scrim;

    @Nullable
    private SearchBar searchBar;
    final TextView searchPrefix;
    private final SearchViewAnimationHelper searchViewAnimationHelper;
    private int softInputMode;
    final View statusBarSpacer;
    private boolean statusBarSpacerEnabledOverride;
    final MaterialToolbar toolbar;
    final FrameLayout toolbarContainer;
    private final Set<TransitionListener> transitionListeners;
    private boolean useWindowInsetsController;

    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(@NonNull CoordinatorLayout r5, @NonNull View r10, @NonNull View r11) {
            return onDependentViewChanged(r5, (SearchView) r10, r11);
        }

        public Behavior(@NonNull Context r5, @Nullable AttributeSet r10) {
            super(r5, r10);
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r5, @NonNull SearchView r10, @NonNull View r11) {
            if (r10.isSetupWithSearchBar() == false) goto L5;
            return false;
        L5:
            if ((r11 instanceof SearchBar) == false) goto L10;
            r10.setupWithSearchBar((SearchBar) r11);
            return false;
        L10:
            return false;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        String text;
        int visibility;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r5) {
            this(r5, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeString(this.text);
            r5.writeInt(this.visibility);
        }

        public SavedState(Parcel r5, @Nullable ClassLoader r10) {
            super(r5, r10);
            this.text = r5.readString();
            this.visibility = r5.readInt();
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }
    }

    public interface TransitionListener {
        void onStateChanged(@NonNull SearchView r5, @NonNull TransitionState r10, @NonNull TransitionState r11);
    }

    public static final enum TransitionState extends Enum<TransitionState> {
        private static final /* synthetic */ TransitionState[] $VALUES = null;
        public static final TransitionState HIDDEN = null;
        public static final TransitionState HIDING = null;
        public static final TransitionState SHOWING = null;
        public static final TransitionState SHOWN = null;

        static {
            TransitionState r5 = new TransitionState("HIDING", 0);
            HIDING = r5;
            TransitionState r10 = new TransitionState("HIDDEN", 1);
            HIDDEN = r10;
            TransitionState r11 = new TransitionState("SHOWING", 2);
            SHOWING = r11;
            TransitionState r12 = new TransitionState("SHOWN", 3);
            SHOWN = r12;
            $VALUES = new TransitionState[]{r5, r10, r11, r12};
        }

        private TransitionState(String r5, int r10) {
            super(r5, r10);
        }

        public static TransitionState valueOf(String r5) {
            return (TransitionState) Enum.valueOf(TransitionState.class, r5);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) $VALUES.clone();
        }
    }

    static {
        DEF_STYLE_RES = R.style.Widget_Material3_SearchView;
    }

    public SearchView(@NonNull Context r5) {
        this(r5, null);
    }

    public static /* synthetic */ void a(SearchView r5, View r10) {
        r5.lambda$setupWithSearchBar$7(r10);
    }

    public static /* synthetic */ WindowInsetsCompat b(ViewGroup.MarginLayoutParams r5, int r10, int r11, View r12, WindowInsetsCompat r13) {
        return lambda$setUpDividerInsetListener$6(r5, r10, r11, r12, r13);
    }

    public static /* synthetic */ boolean c(SearchView r5, View r10, MotionEvent r11) {
        return r5.lambda$setUpContentOnTouchListener$3(r10, r11);
    }

    public static /* synthetic */ void d(SearchView r5) {
        r5.lambda$clearFocusAndHideKeyboard$9();
    }

    public static /* synthetic */ void e(SearchView r5) {
        r5.lambda$requestFocusAndShowKeyboard$8();
    }

    public static /* synthetic */ void f(SearchView r5, View r10) {
        r5.lambda$setUpClearButton$2(r10);
    }

    public static /* synthetic */ WindowInsetsCompat g(SearchView r5, View r10, WindowInsetsCompat r11, ViewUtils.RelativePadding r12) {
        return r5.lambda$setUpToolbarInsetListener$4(r10, r11, r12);
    }

    @Nullable
    private Window getActivityWindow() {
        Activity r5 = ContextUtils.getActivity(getContext());
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar r5 = this.searchBar;
        if (r5 == null) goto L7;
        return r5.getCompatElevation();
    L7:
        return getResources().getDimension(R.dimen.m3_searchview_elevation);
    }

    @Px
    private int getStatusBarHeight() {
        int r5 = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r5 > 0) goto L5;
        return 0;
    L5:
        return getResources().getDimensionPixelSize(r5);
    }

    public static /* synthetic */ WindowInsetsCompat h(SearchView r5, View r10, WindowInsetsCompat r11) {
        return r5.lambda$setUpStatusBarSpacerInsetListener$5(r10, r11);
    }

    public static /* synthetic */ boolean i(View r5, MotionEvent r10) {
        return lambda$setUpRootView$0(r5, r10);
    }

    private boolean isHiddenOrHiding() {
        if (this.currentTransitionState.equals(TransitionState.HIDDEN) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.currentTransitionState.equals(TransitionState.HIDING) == true) goto L8;
        return false;
    }

    private boolean isNavigationIconDrawerArrowDrawable(@NonNull Toolbar r5) {
        return DrawableCompat.unwrap(r5.getNavigationIcon()) instanceof DrawerArrowDrawable;
    }

    public static /* synthetic */ void j(SearchView r5, View r10) {
        r5.lambda$setUpBackButton$1(r10);
    }

    private /* synthetic */ void lambda$clearFocusAndHideKeyboard$9() {
        this.editText.clearFocus();
        SearchBar r5 = this.searchBar;
        if (r5 == null) goto L5;
        r5.requestFocus();
    L5:
        ViewUtils.hideKeyboard(this.editText, this.useWindowInsetsController);
    }

    private /* synthetic */ void lambda$requestFocusAndShowKeyboard$8() {
        if (this.editText.requestFocus() == false) goto L5;
        this.editText.sendAccessibilityEvent(8);
    L5:
        ViewUtils.showKeyboard(this.editText, this.useWindowInsetsController);
    }

    private /* synthetic */ void lambda$setUpBackButton$1(View r5) {
        hide();
    }

    private /* synthetic */ void lambda$setUpClearButton$2(View r5) {
        clearText();
        requestFocusAndShowKeyboardIfNeeded();
    }

    private /* synthetic */ boolean lambda$setUpContentOnTouchListener$3(View r5, MotionEvent r10) {
        if (isAdjustNothingSoftInputMode() == false) goto L7;
        clearFocusAndHideKeyboard();
        return false;
    L7:
        return false;
    }

    private static /* synthetic */ WindowInsetsCompat lambda$setUpDividerInsetListener$6(ViewGroup.MarginLayoutParams r5, int r10, int r11, View r12, WindowInsetsCompat r13) {
        r5.leftMargin = r13.getSystemWindowInsetLeft() + r10;
        r5.rightMargin = r13.getSystemWindowInsetRight() + r11;
        return r13;
    }

    private static /* synthetic */ boolean lambda$setUpRootView$0(View r5, MotionEvent r10) {
        return true;
    }

    private /* synthetic */ WindowInsetsCompat lambda$setUpStatusBarSpacerInsetListener$5(View r5, WindowInsetsCompat r10) {
        int r11 = r10.getSystemWindowInsetTop();
        setUpStatusBarSpacer(r11);
        if (this.statusBarSpacerEnabledOverride == true) goto L8;
        if (r11 <= 0) goto L6;
        boolean r12 = true;
    L7:
        setStatusBarSpacerEnabledInternal(r12);
        goto L8
    L6:
        r12 = false;
    L8:
        return r10;
    }

    private /* synthetic */ WindowInsetsCompat lambda$setUpToolbarInsetListener$4(View r5, WindowInsetsCompat r10, ViewUtils.RelativePadding r11) {
        boolean r12 = ViewUtils.isLayoutRtl(this.toolbar);
        if (r12 == false) goto L5;
        int r13 = r11.end;
    L6:
        if (r12 == false) goto L8;
        int r14 = r11.start;
    L9:
        this.toolbar.setPadding(r10.getSystemWindowInsetLeft() + r13, r11.top, r10.getSystemWindowInsetRight() + r14, r11.bottom);
        return r10;
    L8:
        r14 = r11.end;
        goto L9
    L5:
        r13 = r11.start;
        goto L6
    }

    private /* synthetic */ void lambda$setupWithSearchBar$7(View r5) {
        show();
    }

    private void setStatusBarSpacerEnabledInternal(boolean r5) {
        View r10 = this.statusBarSpacer;
        if (r5 == false) goto L5;
        int r11 = 0;
    L6:
        r10.setVisibility(r11);
        return;
    L5:
        r11 = 8;
        goto L6
    }

    private void setUpBackButton(boolean r5, boolean r10) {
        if (r10 == false) goto L5;
        this.toolbar.setNavigationIcon(null);
        return;
    L5:
        this.toolbar.setNavigationOnClickListener(new f(this, 0));
        if (r5 == false) goto L9;
        DrawerArrowDrawable r11 = new DrawerArrowDrawable(getContext());
        r11.setColor(MaterialColors.getColor(this, R.attr.colorOnSurface));
        this.toolbar.setNavigationIcon(r11);
        return;
    }

    private void setUpBackgroundViewElevationOverlay() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    private void setUpClearButton() {
        this.clearButton.setOnClickListener(new f(this, 1));
        this.editText.addTextChangedListener(new AnonymousClass1(this));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setUpContentOnTouchListener() {
        this.contentContainer.setOnTouchListener(new k(this));
    }

    private void setUpDividerInsetListener() {
        final ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) this.divider.getLayoutParams();
        final int r10 = r5.leftMargin;
        final int r11 = r5.rightMargin;
        ViewCompat.setOnApplyWindowInsetsListener(this.divider, new h(r5, r10, r11));
    }

    private void setUpEditText(@StyleRes int r5, String r10, String r11) {
        if (r5 == (-1)) goto L5;
        TextViewCompat.setTextAppearance(this.editText, r5);
    L5:
        this.editText.setText(r10);
        this.editText.setHint(r11);
    }

    private void setUpHeaderLayout(int r5) {
        if (r5 == (-1)) goto L6;
        addHeaderView(LayoutInflater.from(getContext()).inflate(r5, this.headerContainer, false));
        return;
    }

    private void setUpInsetListeners() {
        setUpToolbarInsetListener();
        setUpDividerInsetListener();
        setUpStatusBarSpacerInsetListener();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setUpRootView() {
        this.rootView.setOnTouchListener(new j());
    }

    private void setUpStatusBarSpacer(@Px int r5) {
        if (this.statusBarSpacer.getLayoutParams().height == r5) goto L6;
        this.statusBarSpacer.getLayoutParams().height = r5;
        this.statusBarSpacer.requestLayout();
        return;
    }

    private void setUpStatusBarSpacerInsetListener() {
        setUpStatusBarSpacer(getStatusBarHeight());
        ViewCompat.setOnApplyWindowInsetsListener(this.statusBarSpacer, new i(this));
    }

    private void setUpToolbarInsetListener() {
        ViewUtils.doOnApplyWindowInsets(this.toolbar, new a(this));
    }

    @SuppressLint({"InlinedApi"})
    private void updateChildImportantForAccessibility(ViewGroup r5, boolean r10) {
        int r11 = 0;
    L4:
        if (r11 >= r5.getChildCount()) goto L19;
        View r12 = r5.getChildAt(r11);
        if (r12 == this) goto L18;
        if (r12.findViewById(this.rootView.getId()) == null) goto L11;
        updateChildImportantForAccessibility((ViewGroup) r12, r10);
        goto L18
    L11:
        if (r10 == true) goto L17;
        Map<View, Integer> r13 = this.childImportantForAccessibilityMap;
        if (r13 == null) goto L18;
        if (r13.containsKey(r12) == false) goto L18;
        ViewCompat.setImportantForAccessibility(r12, this.childImportantForAccessibilityMap.get(r12).intValue());
        goto L18
    L17:
        this.childImportantForAccessibilityMap.put(r12, Integer.valueOf(r12.getImportantForAccessibility()));
        ViewCompat.setImportantForAccessibility(r12, 4);
    L18:
        r11 = r11 + 1;
        goto L4
    }

    private void updateListeningForBackCallbacks(@NonNull TransitionState r5) {
        if (this.searchBar != null) goto L5;
        return;
    L5:
        if (this.backHandlingEnabled == true) goto L7;
        return;
    L7:
        if (r5.equals(TransitionState.SHOWN) == false) goto L10;
        this.backOrchestrator.startListeningForBackCallbacks();
        return;
    L10:
        if (r5.equals(TransitionState.HIDDEN) == false) goto L16;
        this.backOrchestrator.stopListeningForBackCallbacks();
        return;
    }

    private void updateNavigationIconIfNeeded() {
        MaterialToolbar r5 = this.toolbar;
        if (r5 != null) goto L6;
        return;
    L6:
        if (isNavigationIconDrawerArrowDrawable(r5) == false) goto L8;
        return;
    L8:
        int r10 = getDefaultNavigationIconResource();
        if (this.searchBar != null) goto L11;
        this.toolbar.setNavigationIcon(r10);
        return;
    L11:
        Drawable r11 = DrawableCompat.wrap(AppCompatResources.getDrawable(getContext(), r10).mutate());
        if (this.toolbar.getNavigationIconTint() == null) goto L14;
        DrawableCompat.setTint(r11, this.toolbar.getNavigationIconTint().intValue());
    L14:
        this.toolbar.setNavigationIcon(new FadeThroughDrawable(this.searchBar.getNavigationIcon(), r11));
        updateNavigationIconProgressIfNeeded();
    }

    private void updateNavigationIconProgressIfNeeded() {
        ImageButton r5 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.rootView.getVisibility() != 0) goto L8;
        int r10 = 1;
    L9:
        Drawable r11 = DrawableCompat.unwrap(r5.getDrawable());
        if ((r11 instanceof DrawerArrowDrawable) == false) goto L13;
        ((DrawerArrowDrawable) r11).setProgress(r10);
    L13:
        if ((r11 instanceof FadeThroughDrawable) == false) goto L16;
        ((FadeThroughDrawable) r11).setProgress(r10);
        return;
    L16:
        return;
    L8:
        r10 = 0;
        goto L9
    }

    public void addHeaderView(@NonNull View r5) {
        this.headerContainer.addView(r5);
        this.headerContainer.setVisibility(0);
    }

    public void addTransitionListener(@NonNull TransitionListener r5) {
        this.transitionListeners.add(r5);
    }

    @Override // android.view.ViewGroup
    public void addView(View r5, int r10, ViewGroup.LayoutParams r11) {
        if (this.layoutInflated == false) goto L5;
        this.contentContainer.addView(r5, r10, r11);
        return;
    L5:
        super.addView(r5, r10, r11);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void cancelBackProgress() {
        if (isHiddenOrHiding() == false) goto L5;
        return;
    L5:
        if (this.searchBar != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 34) goto L13;
        this.searchViewAnimationHelper.cancelBackProgress();
        return;
    }

    public void clearFocusAndHideKeyboard() {
        this.editText.post(new g(this, 0));
    }

    public void clearText() {
        this.editText.setText("");
    }

    @VisibleForTesting
    public MaterialMainContainerBackHelper getBackHelper() {
        return this.searchViewAnimationHelper.getBackHelper();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.currentTransitionState;
    }

    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_arrow_back_black_24;
    }

    @NonNull
    public EditText getEditText() {
        return this.editText;
    }

    @Nullable
    public CharSequence getHint() {
        return this.editText.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.searchPrefix;
    }

    @Nullable
    public CharSequence getSearchPrefixText() {
        return this.searchPrefix.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.softInputMode;
    }

    @NonNull
    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.editText.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.toolbar;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void handleBackInvoked() {
        if (isHiddenOrHiding() == false) goto L5;
        return;
    L5:
        BackEventCompat r5 = this.searchViewAnimationHelper.onHandleBackInvoked();
        if (Build.VERSION.SDK_INT >= 34) goto L8;
    L11:
        hide();
        return;
    L8:
        if (this.searchBar == null) goto L11;
        if (r5 == null) goto L11;
        this.searchViewAnimationHelper.finishBackProgress();
    }

    public void hide() {
        if (this.currentTransitionState.equals(TransitionState.HIDDEN) == false) goto L5;
        return;
    L5:
        if (this.currentTransitionState.equals(TransitionState.HIDING) == true) goto L10;
        this.searchViewAnimationHelper.hide();
        return;
    }

    public void inflateMenu(@MenuRes int r5) {
        this.toolbar.inflateMenu(r5);
    }

    public boolean isAdjustNothingSoftInputMode() {
        if (this.softInputMode != 48) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAnimatedNavigationIcon() {
        return this.animatedNavigationIcon;
    }

    public boolean isAutoShowKeyboard() {
        return this.autoShowKeyboard;
    }

    public boolean isMenuItemsAnimated() {
        return this.animatedMenuItems;
    }

    public boolean isSetupWithSearchBar() {
        if (this.searchBar == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isShowing() {
        if (this.currentTransitionState.equals(TransitionState.SHOWN) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.currentTransitionState.equals(TransitionState.SHOWING) == true) goto L8;
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isUseWindowInsetsController() {
        return this.useWindowInsetsController;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        updateSoftInputMode();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        setText(r10.text);
        if (r10.visibility != 0) goto L9;
        boolean r11 = true;
    L10:
        setVisible(r11);
        return;
    L9:
        r11 = false;
        goto L10
    }

    @Override // android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        Editable r10 = getText();
        if (r10 != null) goto L5;
        String r11 = null;
    L6:
        r5.text = r11;
        r5.visibility = this.rootView.getVisibility();
        return r5;
    L5:
        r11 = r10.toString();
        goto L6
    }

    public void removeAllHeaderViews() {
        this.headerContainer.removeAllViews();
        this.headerContainer.setVisibility(8);
    }

    public void removeHeaderView(@NonNull View r5) {
        this.headerContainer.removeView(r5);
        if (this.headerContainer.getChildCount() != 0) goto L6;
        this.headerContainer.setVisibility(8);
        return;
    }

    public void removeTransitionListener(@NonNull TransitionListener r5) {
        this.transitionListeners.remove(r5);
    }

    public void requestFocusAndShowKeyboard() {
        this.editText.postDelayed(new g(this, 1), TALKBACK_FOCUS_CHANGE_DELAY_MS);
    }

    public void requestFocusAndShowKeyboardIfNeeded() {
        if (this.autoShowKeyboard == false) goto L6;
        requestFocusAndShowKeyboard();
        return;
    }

    public void setAnimatedNavigationIcon(boolean r5) {
        this.animatedNavigationIcon = r5;
    }

    public void setAutoShowKeyboard(boolean r5) {
        this.autoShowKeyboard = r5;
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float r5) {
        super.setElevation(r5);
        setUpBackgroundViewElevationOverlay(r5);
    }

    public void setHint(@Nullable CharSequence r5) {
        this.editText.setHint(r5);
    }

    public void setMenuItemsAnimated(boolean r5) {
        this.animatedMenuItems = r5;
    }

    public void setModalForAccessibility(boolean r5) {
        ViewGroup r10 = (ViewGroup) getRootView();
        if (r5 == false) goto L5;
        this.childImportantForAccessibilityMap = new HashMap(r10.getChildCount());
    L5:
        updateChildImportantForAccessibility(r10, r5);
        if (r5 == true) goto L9;
        this.childImportantForAccessibilityMap = null;
        return;
    }

    public void setOnMenuItemClickListener(@Nullable Toolbar.OnMenuItemClickListener r5) {
        this.toolbar.setOnMenuItemClickListener(r5);
    }

    public void setSearchPrefixText(@Nullable CharSequence r5) {
        this.searchPrefix.setText(r5);
        TextView r10 = this.searchPrefix;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        int r11 = 8;
    L6:
        r10.setVisibility(r11);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStatusBarSpacerEnabled(boolean r5) {
        this.statusBarSpacerEnabledOverride = true;
        setStatusBarSpacerEnabledInternal(r5);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(@Nullable CharSequence r5) {
        this.editText.setText(r5);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean r5) {
        this.toolbar.setTouchscreenBlocksFocus(r5);
    }

    public void setTransitionState(@NonNull TransitionState r5) {
        setTransitionState(r5, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setUseWindowInsetsController(boolean r5) {
        this.useWindowInsetsController = r5;
    }

    public void setVisible(boolean r10) {
        boolean r5 = true;
        if (this.rootView.getVisibility() != 0) goto L5;
        boolean r11 = true;
    L6:
        ClippableRoundedCornerLayout r12 = this.rootView;
        if (r10 == false) goto L9;
        int r13 = 0;
    L10:
        r12.setVisibility(r13);
        updateNavigationIconProgressIfNeeded();
        if (r10 == false) goto L13;
        TransitionState r14 = TransitionState.SHOWN;
    L14:
        if (r11 != r10) goto L17;
        r5 = false;
    L17:
        setTransitionState(r14, r5);
        return;
    L13:
        r14 = TransitionState.HIDDEN;
        goto L14
    L9:
        r13 = 8;
        goto L10
    L5:
        r11 = false;
        goto L6
    }

    public void setupWithSearchBar(@Nullable SearchBar r5) {
        this.searchBar = r5;
        this.searchViewAnimationHelper.setSearchBar(r5);
        if (r5 == null) goto L7;
        r5.setOnClickListener(new f(this, 2));
        if (Build.VERSION.SDK_INT < 34) goto L7;
        androidx.room.b.k(r5, new g(this, 2));     // Catch: LinkageError -> L9
        androidx.room.b.i(this.editText);     // Catch: LinkageError -> L9
    L7:
        updateNavigationIconIfNeeded();
        setUpBackgroundViewElevationOverlay();
        updateListeningForBackCallbacks(getCurrentTransitionState());
    }

    public void show() {
        if (this.currentTransitionState.equals(TransitionState.SHOWN) == false) goto L5;
        return;
    L5:
        if (this.currentTransitionState.equals(TransitionState.SHOWING) == true) goto L10;
        this.searchViewAnimationHelper.show();
        return;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void startBackProgress(@NonNull BackEventCompat r5) {
        if (isHiddenOrHiding() == false) goto L5;
        return;
    L5:
        if (this.searchBar == null) goto L10;
        this.searchViewAnimationHelper.startBackProgress(r5);
        return;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void updateBackProgress(@NonNull BackEventCompat r5) {
        if (isHiddenOrHiding() == false) goto L5;
        return;
    L5:
        if (this.searchBar != null) goto L7;
        return;
    L7:
        if (Build.VERSION.SDK_INT < 34) goto L13;
        this.searchViewAnimationHelper.updateBackProgress(r5);
        return;
    }

    public void updateSoftInputMode() {
        Window r5 = getActivityWindow();
        if (r5 == null) goto L6;
        this.softInputMode = r5.getAttributes().softInputMode;
        return;
    }

    public SearchView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.materialSearchViewStyle);
    }

    private void setTransitionState(@NonNull TransitionState r5, boolean r10) {
        if (this.currentTransitionState.equals(r5) == false) goto L5;
        return;
    L5:
        if (r10 == true) goto L7;
    L12:
        TransitionState r11 = this.currentTransitionState;
        this.currentTransitionState = r5;
        Iterator r12 = new LinkedHashSet(this.transitionListeners).iterator();
    L14:
        if (r12.hasNext() == false) goto L16;
        ((TransitionListener) r12.next()).onStateChanged(this, r11, r5);
        goto L14
    L16:
        updateListeningForBackCallbacks(r5);
        return;
    L7:
        if (r5 != TransitionState.SHOWN) goto L10;
        setModalForAccessibility(true);
        goto L12
    L10:
        if (r5 != TransitionState.HIDDEN) goto L12;
        setModalForAccessibility(false);
        goto L12
    }

    private void setUpBackgroundViewElevationOverlay(float r5) {
        ElevationOverlayProvider r10 = this.elevationOverlayProvider;
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.backgroundView == null) goto L10;
        int r11 = r10.compositeOverlayIfNeeded(this.backgroundColor, r5);
        this.backgroundView.setBackgroundColor(r11);
        return;
    }

    public void setHint(@StringRes int r5) {
        this.editText.setHint(r5);
    }

    public void setText(@StringRes int r5) {
        this.editText.setText(r5);
    }

    public SearchView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        int r5 = DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(r10, r11, r12, r5), r11, r12);
        this.backOrchestrator = new MaterialBackOrchestrator(this);
        this.transitionListeners = new LinkedHashSet();
        this.softInputMode = 16;
        this.currentTransitionState = TransitionState.HIDDEN;
        Context r13 = getContext();
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r13, r11, R.styleable.SearchView, r12, r5, new int[0]);
        this.backgroundColor = r14.getColor(R.styleable.SearchView_backgroundTint, 0);
        int r15 = r14.getResourceId(R.styleable.SearchView_headerLayout, -1);
        int r16 = r14.getResourceId(R.styleable.SearchView_android_textAppearance, -1);
        String r17 = r14.getString(R.styleable.SearchView_android_text);
        String r18 = r14.getString(R.styleable.SearchView_android_hint);
        String r19 = r14.getString(R.styleable.SearchView_searchPrefixText);
        boolean r20 = r14.getBoolean(R.styleable.SearchView_useDrawerArrowDrawable, false);
        this.animatedNavigationIcon = r14.getBoolean(R.styleable.SearchView_animateNavigationIcon, true);
        this.animatedMenuItems = r14.getBoolean(R.styleable.SearchView_animateMenuItems, true);
        boolean r21 = r14.getBoolean(R.styleable.SearchView_hideNavigationIcon, false);
        this.autoShowKeyboard = r14.getBoolean(R.styleable.SearchView_autoShowKeyboard, true);
        this.backHandlingEnabled = r14.getBoolean(R.styleable.SearchView_backHandlingEnabled, true);
        r14.recycle();
        LayoutInflater.from(r13).inflate(R.layout.mtrl_search_view, this);
        this.layoutInflated = true;
        this.scrim = findViewById(R.id.open_search_view_scrim);
        this.rootView = (ClippableRoundedCornerLayout) findViewById(R.id.open_search_view_root);
        this.backgroundView = findViewById(R.id.open_search_view_background);
        this.statusBarSpacer = findViewById(R.id.open_search_view_status_bar_spacer);
        this.headerContainer = (FrameLayout) findViewById(R.id.open_search_view_header_container);
        this.toolbarContainer = (FrameLayout) findViewById(R.id.open_search_view_toolbar_container);
        this.toolbar = (MaterialToolbar) findViewById(R.id.open_search_view_toolbar);
        this.dummyToolbar = (Toolbar) findViewById(R.id.open_search_view_dummy_toolbar);
        this.searchPrefix = (TextView) findViewById(R.id.open_search_view_search_prefix);
        this.editText = (EditText) findViewById(R.id.open_search_view_edit_text);
        this.clearButton = (ImageButton) findViewById(R.id.open_search_view_clear_button);
        this.divider = findViewById(R.id.open_search_view_divider);
        this.contentContainer = (TouchObserverFrameLayout) findViewById(R.id.open_search_view_content_container);
        this.searchViewAnimationHelper = new SearchViewAnimationHelper(this);
        this.elevationOverlayProvider = new ElevationOverlayProvider(r13);
        setUpRootView();
        setUpBackgroundViewElevationOverlay();
        setUpHeaderLayout(r15);
        setSearchPrefixText(r19);
        setUpEditText(r16, r17, r18);
        setUpBackButton(r20, r21);
        setUpClearButton();
        setUpContentOnTouchListener();
        setUpInsetListeners();
    }
}
