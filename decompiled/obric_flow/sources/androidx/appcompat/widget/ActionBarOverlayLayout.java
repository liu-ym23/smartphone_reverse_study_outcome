package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent, NestedScrollingParent2, NestedScrollingParent3 {
    private static final int ACTION_BAR_ANIMATE_DELAY = 600;
    static final int[] ATTRS = null;
    private static final String TAG = "ActionBarOverlayLayout";
    private int mActionBarHeight;
    ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    boolean mAnimatingForFling;
    private final Rect mBaseContentInsets;

    @NonNull
    private WindowInsetsCompat mBaseInnerInsets;
    private final Rect mBaseInnerInsetsRect;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    ViewPropertyAnimator mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private OverScroller mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;

    @NonNull
    private WindowInsetsCompat mInnerInsets;
    private final Rect mInnerInsetsRect;
    private final Rect mLastBaseContentInsets;

    @NonNull
    private WindowInsetsCompat mLastBaseInnerInsets;
    private final Rect mLastBaseInnerInsetsRect;

    @NonNull
    private WindowInsetsCompat mLastInnerInsets;
    private final Rect mLastInnerInsetsRect;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    final AnimatorListenerAdapter mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility;

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean r5);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int r5);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context r5, AttributeSet r10) {
            super(r5, r10);
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
        }
    }

    static {
        ATTRS = new int[]{R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    }

    public ActionBarOverlayLayout(@NonNull Context r5) {
        this(r5, null);
    }

    private void addActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(@NonNull View r5, @NonNull Rect r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        LayoutParams r15 = (LayoutParams) r5.getLayoutParams();
        if (r11 == false) goto L7;
        int r16 = ((ViewGroup.MarginLayoutParams) r15).leftMargin;
        int r17 = r10.left;
        if (r16 == r17) goto L7;
        ((ViewGroup.MarginLayoutParams) r15).leftMargin = r17;
        boolean r18 = true;
    L8:
        if (r12 == false) goto L12;
        int r19 = ((ViewGroup.MarginLayoutParams) r15).topMargin;
        int r20 = r10.top;
        if (r19 == r20) goto L12;
        ((ViewGroup.MarginLayoutParams) r15).topMargin = r20;
        r18 = true;
    L12:
        if (r14 == false) goto L16;
        int r21 = ((ViewGroup.MarginLayoutParams) r15).rightMargin;
        int r22 = r10.right;
        if (r21 == r22) goto L16;
        ((ViewGroup.MarginLayoutParams) r15).rightMargin = r22;
        r18 = true;
    L16:
        if (r13 == false) goto L21;
        int r23 = ((ViewGroup.MarginLayoutParams) r15).bottomMargin;
        int r24 = r10.bottom;
        if (r23 == r24) goto L21;
        ((ViewGroup.MarginLayoutParams) r15).bottomMargin = r24;
        return true;
    L21:
        return r18;
    L7:
        r18 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar getDecorToolbar(View r5) {
        if ((r5 instanceof DecorToolbar) == false) goto L7;
        return (DecorToolbar) r5;
    L7:
        if ((r5 instanceof Toolbar) == false) goto L11;
        return ((Toolbar) r5).getWrapper();
    L11:
        throw new IllegalStateException("Can't make a decor toolbar out of ".concat(r5.getClass().getSimpleName()));
    }

    private void init(Context r5) {
        TypedArray r10 = getContext().getTheme().obtainStyledAttributes(ATTRS);
        boolean r11 = false;
        this.mActionBarHeight = r10.getDimensionPixelSize(0, 0);
        Drawable r12 = r10.getDrawable(1);
        this.mWindowContentOverlay = r12;
        if (r12 != null) goto L5;
        boolean r13 = true;
    L6:
        setWillNotDraw(r13);
        r10.recycle();
        if (r5.getApplicationInfo().targetSdkVersion >= 19) goto L9;
        r11 = true;
    L9:
        this.mIgnoreWindowContentOverlay = r11;
        this.mFlingEstimator = new OverScroller(r5);
        return;
    L5:
        r13 = false;
        goto L6
    }

    private void postAddActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mAddActionBarHideOffset, 600);
    }

    private void postRemoveActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        postDelayed(this.mRemoveActionBarHideOffset, 600);
    }

    private void removeActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }

    private boolean shouldHideActionBarOnFling(float r10) {
        this.mFlingEstimator.fling(0, 0, 0, (int) r10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.mFlingEstimator.getFinalY() <= this.mActionBarTop.getHeight()) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        return r5 instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        if (this.mWindowContentOverlay != null) goto L5;
        return;
    L5:
        if (this.mIgnoreWindowContentOverlay == false) goto L7;
        return;
    L7:
        if (this.mActionBarTop.getVisibility() != 0) goto L9;
        int r5 = (int) ((this.mActionBarTop.getTranslationY() + this.mActionBarTop.getBottom()) + 0.5f);
    L10:
        this.mWindowContentOverlay.setBounds(0, r5, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + r5);
        this.mWindowContentOverlay.draw(r10);
        return;
    L9:
        r5 = 0;
        goto L10
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r5) {
        return super.fitSystemWindows(r5);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer r5 = this.mActionBarTop;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return -((int) r5.getTranslationY());
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public CharSequence getTitle() {
        pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    public void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator r5 = this.mCurrentActionBarTopAnimator;
        if (r5 == null) goto L6;
        r5.cancel();
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasIcon() {
        pullChildren();
        return this.mDecorToolbar.hasIcon();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hasLogo() {
        pullChildren();
        return this.mDecorToolbar.hasLogo();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void initFeature(int r5) {
        pullChildren();
        if (r5 != 2) goto L5;
        this.mDecorToolbar.initProgress();
        return;
    L5:
        if (r5 != 5) goto L7;
        this.mDecorToolbar.initIndeterminateProgress();
        return;
    L7:
        if (r5 != 109) goto L15;
        setOverlayMode(true);
        return;
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets r10) {
        pullChildren();
        WindowInsetsCompat r11 = WindowInsetsCompat.toWindowInsetsCompat(r10, this);
        boolean r5 = applyInsets(this.mActionBarTop, new Rect(r11.getSystemWindowInsetLeft(), r11.getSystemWindowInsetTop(), r11.getSystemWindowInsetRight(), r11.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, r11, this.mBaseContentInsets);
        Rect r12 = this.mBaseContentInsets;
        WindowInsetsCompat r13 = r11.inset(r12.left, r12.top, r12.right, r12.bottom);
        this.mBaseInnerInsets = r13;
        boolean r14 = true;
        if (this.mLastBaseInnerInsets.equals(r13) == true) goto L6;
        this.mLastBaseInnerInsets = this.mBaseInnerInsets;
        r5 = true;
    L6:
        if (this.mLastBaseContentInsets.equals(this.mBaseContentInsets) == true) goto L8;
        this.mLastBaseContentInsets.set(this.mBaseContentInsets);
    L9:
        if (r14 == false) goto L12;
        requestLayout();
    L12:
        return r11.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    L8:
        r14 = r5;
        goto L9
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        int r14 = getChildCount();
        int r15 = getPaddingLeft();
        int r16 = getPaddingTop();
        int r17 = 0;
    L3:
        if (r17 >= r14) goto L8;
        View r18 = getChildAt(r17);
        if (r18.getVisibility() == 8) goto L7;
        LayoutParams r19 = (LayoutParams) r18.getLayoutParams();
        int r20 = r18.getMeasuredWidth();
        int r21 = r18.getMeasuredHeight();
        int r22 = ((ViewGroup.MarginLayoutParams) r19).leftMargin + r15;
        int r23 = ((ViewGroup.MarginLayoutParams) r19).topMargin + r16;
        r18.layout(r22, r23, r20 + r22, r21 + r23);
    L7:
        r17 = r17 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r12, int r13) {
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, r12, 0, r13, 0);
        LayoutParams r5 = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int r10 = Math.max(0, (this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r5).leftMargin) + ((ViewGroup.MarginLayoutParams) r5).rightMargin);
        int r11 = Math.max(0, (this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r5).topMargin) + ((ViewGroup.MarginLayoutParams) r5).bottomMargin);
        int r14 = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) == 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L13;
        int r16 = this.mActionBarHeight;
        if (this.mHasNonEmbeddedTabs == true) goto L10;
    L16:
        this.mContentInsets.set(this.mBaseContentInsets);
        WindowInsetsCompat r17 = this.mBaseInnerInsets;
        this.mInnerInsets = r17;
        if (this.mOverlayMode == true) goto L20;
        if (r15 == true) goto L20;
        Rect r18 = this.mContentInsets;
        r18.top += r16;
        r18.bottom = r18.bottom;
        this.mInnerInsets = r17.inset(0, r16, 0, 0);
    L21:
        applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (this.mLastInnerInsets.equals(this.mInnerInsets) == true) goto L24;
        WindowInsetsCompat r19 = this.mInnerInsets;
        this.mLastInnerInsets = r19;
        ViewCompat.dispatchApplyWindowInsets(this.mContent, r19);
    L24:
        measureChildWithMargins(this.mContent, r12, 0, r13, 0);
        LayoutParams r20 = (LayoutParams) this.mContent.getLayoutParams();
        int r21 = Math.max(r10, (this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r20).leftMargin) + ((ViewGroup.MarginLayoutParams) r20).rightMargin);
        int r22 = Math.max(r11, (this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r20).topMargin) + ((ViewGroup.MarginLayoutParams) r20).bottomMargin);
        int r23 = View.combineMeasuredStates(r14, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max((getPaddingRight() + getPaddingLeft()) + r21, getSuggestedMinimumWidth()), r12, r23), View.resolveSizeAndState(Math.max((getPaddingBottom() + getPaddingTop()) + r22, getSuggestedMinimumHeight()), r13, r23 << 16));
        return;
    L20:
        this.mInnerInsets = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets(Insets.of(r17.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + r16, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom())).build();
        goto L21
    L10:
        if (this.mActionBarTop.getTabContainer() == null) goto L16;
        r16 = r16 + this.mActionBarHeight;
        goto L16
    L13:
        if (this.mActionBarTop.getVisibility() == 8) goto L15;
        r16 = this.mActionBarTop.getMeasuredHeight();
        goto L16
    L15:
        r16 = 0;
        goto L16
    L5:
        r15 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r5, float r10, float r11, boolean r12) {
        if (this.mHideOnContentScroll == false) goto L12;
        if (r12 == true) goto L7;
        return false;
    L7:
        if (shouldHideActionBarOnFling(r11) == false) goto L9;
        addActionBarHideOffset();
    L10:
        this.mAnimatingForFling = true;
        return true;
    L9:
        removeActionBarHideOffset();
        goto L10
    L12:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r5, float r10, float r11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r5, int r10, int r11, int[] r12) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14, int[] r15) {
        onNestedScroll(r5, r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r5, View r10, int r11, int r12) {
        if (r12 != 0) goto L5;
        onNestedScrollAccepted(r5, r10, r11);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r5, View r10, int r11, int r12) {
        if (r12 == 0) goto L4;
    L6:
        return false;
    L4:
        if (onStartNestedScroll(r5, r10, r11) == false) goto L6;
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r5, int r10) {
        if (r10 != 0) goto L5;
        onStopNestedScroll(r5);
        return;
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int r5) {
        super.onWindowSystemUiVisibilityChanged(r5);
        pullChildren();
        int r10 = this.mLastSystemUiVisibility ^ r5;
        this.mLastSystemUiVisibility = r5;
        boolean r11 = false;
        if ((r5 & 4) != 0) goto L5;
        boolean r12 = true;
    L7:
        if ((r5 & 256) == 0) goto L9;
        r11 = true;
    L9:
        ActionBarVisibilityCallback r13 = this.mActionBarVisibilityCallback;
        if (r13 == null) goto L18;
        r13.enableContentAnimations(!r11);
        if (r12 == true) goto L16;
        if (r11 == false) goto L16;
        this.mActionBarVisibilityCallback.hideForSystem();
    L16:
        this.mActionBarVisibilityCallback.showForSystem();
    L18:
        if ((r10 & 256) != 0) goto L20;
        return;
    L20:
        if (this.mActionBarVisibilityCallback == null) goto L24;
        ViewCompat.requestApplyInsets(this);
        return;
    L24:
        return;
    L5:
        r12 = false;
        goto L7
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r5) {
        super.onWindowVisibilityChanged(r5);
        this.mWindowVisibility = r5;
        ActionBarVisibilityCallback r10 = this.mActionBarVisibilityCallback;
        if (r10 == null) goto L6;
        r10.onWindowVisibilityChanged(r5);
        return;
    }

    public void pullChildren() {
        if (this.mContent != null) goto L6;
        this.mContent = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
        this.mActionBarTop = (ActionBarContainer) findViewById(R.id.action_bar_container);
        this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> r5) {
        pullChildren();
        this.mDecorToolbar.restoreHierarchyState(r5);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> r5) {
        pullChildren();
        this.mDecorToolbar.saveHierarchyState(r5);
    }

    public void setActionBarHideOffset(int r5) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(r5, this.mActionBarTop.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback r5) {
        this.mActionBarVisibilityCallback = r5;
        if (getWindowToken() == null) goto L8;
        this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
        int r10 = this.mLastSystemUiVisibility;
        if (r10 == 0) goto L9;
        onWindowSystemUiVisibilityChanged(r10);
        ViewCompat.requestApplyInsets(this);
        return;
    L9:
        return;
    }

    public void setHasNonEmbeddedTabs(boolean r5) {
        this.mHasNonEmbeddedTabs = r5;
    }

    public void setHideOnContentScrollEnabled(boolean r5) {
        if (r5 == this.mHideOnContentScroll) goto L8;
        this.mHideOnContentScroll = r5;
        if (r5 == true) goto L9;
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(int r5) {
        pullChildren();
        this.mDecorToolbar.setIcon(r5);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setLogo(int r5) {
        pullChildren();
        this.mDecorToolbar.setLogo(r5);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu r5, MenuPresenter.Callback r10) {
        pullChildren();
        this.mDecorToolbar.setMenu(r5, r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean r5) {
        this.mOverlayMode = r5;
        if (r5 == true) goto L5;
    L7:
        boolean r10 = false;
    L8:
        this.mIgnoreWindowContentOverlay = r10;
        return;
    L5:
        if (getContext().getApplicationInfo().targetSdkVersion >= 19) goto L7;
        r10 = true;
        goto L8
    }

    public void setShowingForActionMode(boolean r5) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setUiOptions(int r5) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback r5) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(r5);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence r5) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(r5);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean showOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }

    public ActionBarOverlayLayout(@NonNull Context r5, @Nullable AttributeSet r10) {
        super(r5, r10);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        WindowInsetsCompat r11 = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = r11;
        this.mLastBaseInnerInsets = r11;
        this.mInnerInsets = r11;
        this.mLastInnerInsets = r11;
        this.mTopAnimatorListener = new AnonymousClass1(this);
        this.mRemoveActionBarHideOffset = new AnonymousClass2(this);
        this.mAddActionBarHideOffset = new AnonymousClass3(this);
        init(r5);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r5, int r10, int r11, int[] r12, int r13) {
        if (r13 != 0) goto L5;
        onNestedPreScroll(r5, r10, r11, r12);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r5, int r10, int r11, int r12, int r13, int r14) {
        if (r14 != 0) goto L5;
        onNestedScroll(r5, r10, r11, r12, r13);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r5, View r10, int r11) {
        this.mParentHelper.onNestedScrollAccepted(r5, r10, r11);
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback r12 = this.mActionBarVisibilityCallback;
        if (r12 == null) goto L6;
        r12.onContentScrollStarted();
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r5, View r10, int r11) {
        if ((r11 & 2) != 0) goto L5;
        return false;
    L5:
        if (this.mActionBarTop.getVisibility() == 0) goto L8;
        return false;
    L8:
        return this.mHideOnContentScroll;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r5) {
        if (this.mHideOnContentScroll == true) goto L5;
    L10:
        ActionBarVisibilityCallback r10 = this.mActionBarVisibilityCallback;
        if (r10 == null) goto L14;
        r10.onContentScrollStopped();
        return;
    L14:
        return;
    L5:
        if (this.mAnimatingForFling == true) goto L10;
        if (this.mHideOnContentScrollReference > this.mActionBarTop.getHeight()) goto L9;
        postRemoveActionBarHideOffset();
        goto L10
    L9:
        postAddActionBarHideOffset();
        goto L10
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return new LayoutParams(r5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r5, int r10, int r11, int r12, int r13) {
        int r14 = this.mHideOnContentScrollReference + r11;
        this.mHideOnContentScrollReference = r14;
        setActionBarHideOffset(r14);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(Drawable r5) {
        pullChildren();
        this.mDecorToolbar.setIcon(r5);
    }
}
