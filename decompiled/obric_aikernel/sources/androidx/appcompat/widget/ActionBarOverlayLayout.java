package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
        void enableContentAnimations(boolean r10);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int r10);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int r10, int r11) {
            super(r10, r11);
        }

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
        }
    }

    static {
        ATTRS = new int[]{R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    }

    public ActionBarOverlayLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public ActionBarOverlayLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        WindowInsetsCompat r12 = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = r12;
        this.mLastBaseInnerInsets = r12;
        this.mInnerInsets = r12;
        this.mLastInnerInsets = r12;
        this.mTopAnimatorListener = new AnonymousClass1(this);
        this.mRemoveActionBarHideOffset = new AnonymousClass2(this);
        this.mAddActionBarHideOffset = new AnonymousClass3(this);
        init(r10);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    private void addActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(@NonNull View r10, @NonNull Rect r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        LayoutParams r16 = (LayoutParams) r10.getLayoutParams();
        if (r12 == false) goto L7;
        int r17 = ((ViewGroup.MarginLayoutParams) r16).leftMargin;
        int r18 = r11.left;
        if (r17 == r18) goto L7;
        ((ViewGroup.MarginLayoutParams) r16).leftMargin = r18;
        boolean r19 = true;
    L8:
        if (r13 == false) goto L12;
        int r20 = ((ViewGroup.MarginLayoutParams) r16).topMargin;
        int r21 = r11.top;
        if (r20 == r21) goto L12;
        ((ViewGroup.MarginLayoutParams) r16).topMargin = r21;
        r19 = true;
    L12:
        if (r15 == false) goto L16;
        int r22 = ((ViewGroup.MarginLayoutParams) r16).rightMargin;
        int r23 = r11.right;
        if (r22 == r23) goto L16;
        ((ViewGroup.MarginLayoutParams) r16).rightMargin = r23;
        r19 = true;
    L16:
        if (r14 == false) goto L21;
        int r24 = ((ViewGroup.MarginLayoutParams) r16).bottomMargin;
        int r25 = r11.bottom;
        if (r24 == r25) goto L21;
        ((ViewGroup.MarginLayoutParams) r16).bottomMargin = r25;
        return true;
    L21:
        return r19;
    L7:
        r19 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DecorToolbar getDecorToolbar(View r10) {
        if ((r10 instanceof DecorToolbar) == false) goto L7;
        return (DecorToolbar) r10;
    L7:
        if ((r10 instanceof Toolbar) == false) goto L11;
        return ((Toolbar) r10).getWrapper();
    L11:
        throw new IllegalStateException("Can't make a decor toolbar out of " + r10.getClass().getSimpleName());
    }

    private void init(Context r10) {
        TypedArray r11 = getContext().getTheme().obtainStyledAttributes(ATTRS);
        boolean r12 = false;
        this.mActionBarHeight = r11.getDimensionPixelSize(0, 0);
        Drawable r13 = r11.getDrawable(1);
        this.mWindowContentOverlay = r13;
        if (r13 != null) goto L5;
        boolean r14 = true;
    L6:
        setWillNotDraw(r14);
        r11.recycle();
        if (r10.getApplicationInfo().targetSdkVersion >= 19) goto L9;
        r12 = true;
    L9:
        this.mIgnoreWindowContentOverlay = r12;
        this.mFlingEstimator = new OverScroller(r10);
        return;
    L5:
        r14 = false;
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
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        return r10 instanceof LayoutParams;
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
        int r11 = (int) ((this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY()) + 0.5f);
    L10:
        this.mWindowContentOverlay.setBounds(0, r11, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + r11);
        this.mWindowContentOverlay.draw(r10);
        return;
    L9:
        r11 = 0;
        goto L10
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect r10) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        pullChildren();
        boolean r11 = applyInsets(this.mActionBarTop, r10, true, true, false, true);
        this.mBaseInnerInsetsRect.set(r10);
        ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsetsRect, this.mBaseContentInsets);
        if (this.mLastBaseInnerInsetsRect.equals(this.mBaseInnerInsetsRect) == true) goto L10;
        this.mLastBaseInnerInsetsRect.set(this.mBaseInnerInsetsRect);
        r11 = true;
    L10:
        if (this.mLastBaseContentInsets.equals(this.mBaseContentInsets) == true) goto L12;
        this.mLastBaseContentInsets.set(this.mBaseContentInsets);
        r11 = true;
    L12:
        if (r11 == false) goto L14;
        requestLayout();
    L14:
        return true;
    L5:
        return super.fitSystemWindows(r10);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return new LayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer r10 = this.mActionBarTop;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return -((int) r10.getTranslationY());
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

    void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator r10 = this.mCurrentActionBarTopAnimator;
        if (r10 == null) goto L6;
        r10.cancel();
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
    public void initFeature(int r10) {
        pullChildren();
        if (r10 != 2) goto L5;
        this.mDecorToolbar.initProgress();
        return;
    L5:
        if (r10 != 5) goto L7;
        this.mDecorToolbar.initIndeterminateProgress();
        return;
    L7:
        if (r10 != 109) goto L15;
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
        boolean r12 = applyInsets(this.mActionBarTop, new Rect(r11.getSystemWindowInsetLeft(), r11.getSystemWindowInsetTop(), r11.getSystemWindowInsetRight(), r11.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, r11, this.mBaseContentInsets);
        Rect r13 = this.mBaseContentInsets;
        WindowInsetsCompat r14 = r11.inset(r13.left, r13.top, r13.right, r13.bottom);
        this.mBaseInnerInsets = r14;
        boolean r15 = true;
        if (this.mLastBaseInnerInsets.equals(r14) == true) goto L6;
        this.mLastBaseInnerInsets = this.mBaseInnerInsets;
        r12 = true;
    L6:
        if (this.mLastBaseContentInsets.equals(this.mBaseContentInsets) == true) goto L8;
        this.mLastBaseContentInsets.set(this.mBaseContentInsets);
    L9:
        if (r15 == false) goto L12;
        requestLayout();
    L12:
        return r11.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    L8:
        r15 = r12;
        goto L9
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = getChildCount();
        int r16 = getPaddingLeft();
        int r17 = getPaddingTop();
        int r18 = 0;
    L3:
        if (r18 >= r15) goto L8;
        View r19 = getChildAt(r18);
        if (r19.getVisibility() == 8) goto L7;
        LayoutParams r20 = (LayoutParams) r19.getLayoutParams();
        int r21 = r19.getMeasuredWidth();
        int r22 = r19.getMeasuredHeight();
        int r23 = ((ViewGroup.MarginLayoutParams) r20).leftMargin + r16;
        int r24 = ((ViewGroup.MarginLayoutParams) r20).topMargin + r17;
        r19.layout(r23, r24, r21 + r23, r22 + r24);
    L7:
        r18 = r18 + 1;
        goto L3
    }

    @Override // android.view.View
    protected void onMeasure(int r13, int r14) {
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, r13, 0, r14, 0);
        LayoutParams r10 = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int r11 = Math.max(0, (this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r10).leftMargin) + ((ViewGroup.MarginLayoutParams) r10).rightMargin);
        int r12 = Math.max(0, (this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r10).topMargin) + ((ViewGroup.MarginLayoutParams) r10).bottomMargin);
        int r15 = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) == 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L13;
        int r17 = this.mActionBarHeight;
        if (this.mHasNonEmbeddedTabs == true) goto L10;
    L16:
        this.mContentInsets.set(this.mBaseContentInsets);
        int r18 = Build.VERSION.SDK_INT;
        if (r18 < 21) goto L19;
        this.mInnerInsets = this.mBaseInnerInsets;
    L21:
        if (this.mOverlayMode == true) goto L26;
        if (r16 == true) goto L26;
        Rect r19 = this.mContentInsets;
        r19.top += r17;
        r19.bottom += 0;
        if (r18 < 21) goto L30;
        WindowInsetsCompat r20 = this.mInnerInsets.inset(0, r17, 0, 0);
    L28:
        this.mInnerInsets = r20;
    L30:
        applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (r18 >= 21) goto L33;
    L35:
        if (r18 < 21) goto L37;
    L39:
        measureChildWithMargins(this.mContent, r13, 0, r14, 0);
        LayoutParams r21 = (LayoutParams) this.mContent.getLayoutParams();
        int r22 = Math.max(r11, (this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r21).leftMargin) + ((ViewGroup.MarginLayoutParams) r21).rightMargin);
        int r23 = Math.max(r12, (this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r21).topMargin) + ((ViewGroup.MarginLayoutParams) r21).bottomMargin);
        int r24 = View.combineMeasuredStates(r15, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r22 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r13, r24), View.resolveSizeAndState(Math.max(r23 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r14, r24 << 16));
        return;
    L37:
        if (this.mLastInnerInsetsRect.equals(this.mInnerInsetsRect) == true) goto L39;
        this.mLastInnerInsetsRect.set(this.mInnerInsetsRect);
        this.mContent.dispatchFitSystemWindows(this.mInnerInsetsRect);
        goto L39
    L33:
        if (this.mLastInnerInsets.equals(this.mInnerInsets) == true) goto L35;
        WindowInsetsCompat r25 = this.mInnerInsets;
        this.mLastInnerInsets = r25;
        ViewCompat.dispatchApplyWindowInsets(this.mContent, r25);
    L26:
        if (r18 < 21) goto L29;
        r20 = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets(Insets.of(this.mInnerInsets.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + r17, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom() + 0)).build();
        goto L28
    L29:
        Rect r26 = this.mInnerInsetsRect;
        r26.top += r17;
        r26.bottom += 0;
        goto L30
    L19:
        this.mInnerInsetsRect.set(this.mBaseInnerInsetsRect);
        goto L21
    L10:
        if (this.mActionBarTop.getTabContainer() == null) goto L16;
        r17 = r17 + this.mActionBarHeight;
        goto L16
    L13:
        if (this.mActionBarTop.getVisibility() == 8) goto L15;
        r17 = this.mActionBarTop.getMeasuredHeight();
        goto L16
    L15:
        r17 = 0;
        goto L16
    L5:
        r16 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r10, float r11, float r12, boolean r13) {
        if (this.mHideOnContentScroll == false) goto L12;
        if (r13 == true) goto L7;
        return false;
    L7:
        if (shouldHideActionBarOnFling(r12) == false) goto L9;
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
    public boolean onNestedPreFling(View r10, float r11, float r12) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13, int r14) {
        if (r14 != 0) goto L5;
        onNestedPreScroll(r10, r11, r12, r13);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        int r15 = this.mHideOnContentScrollReference + r12;
        this.mHideOnContentScrollReference = r15;
        setActionBarHideOffset(r15);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        if (r15 != 0) goto L5;
        onNestedScroll(r10, r11, r12, r13, r14);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15, int[] r16) {
        onNestedScroll(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r10, View r11, int r12) {
        this.mParentHelper.onNestedScrollAccepted(r10, r11, r12);
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback r13 = this.mActionBarVisibilityCallback;
        if (r13 == null) goto L6;
        r13.onContentScrollStarted();
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        if (r13 != 0) goto L5;
        onNestedScrollAccepted(r10, r11, r12);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r10, View r11, int r12) {
        if ((r12 & 2) != 0) goto L5;
        return false;
    L5:
        if (this.mActionBarTop.getVisibility() == 0) goto L8;
        return false;
    L8:
        return this.mHideOnContentScroll;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r10, View r11, int r12, int r13) {
        if (r13 == 0) goto L4;
    L6:
        return false;
    L4:
        if (onStartNestedScroll(r10, r11, r12) == false) goto L6;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r10) {
        if (this.mHideOnContentScroll == true) goto L5;
    L10:
        ActionBarVisibilityCallback r11 = this.mActionBarVisibilityCallback;
        if (r11 == null) goto L14;
        r11.onContentScrollStopped();
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

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r10, int r11) {
        if (r11 != 0) goto L5;
        onStopNestedScroll(r10);
        return;
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int r10) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        super.onWindowSystemUiVisibilityChanged(r10);
    L5:
        pullChildren();
        int r11 = this.mLastSystemUiVisibility ^ r10;
        this.mLastSystemUiVisibility = r10;
        boolean r12 = false;
        if ((r10 & 4) != 0) goto L8;
        boolean r13 = true;
    L10:
        if ((r10 & 256) == 0) goto L12;
        r12 = true;
    L12:
        ActionBarVisibilityCallback r14 = this.mActionBarVisibilityCallback;
        if (r14 == null) goto L21;
        r14.enableContentAnimations(!r12);
        if (r13 == true) goto L19;
        if (r12 == false) goto L19;
        this.mActionBarVisibilityCallback.hideForSystem();
    L19:
        this.mActionBarVisibilityCallback.showForSystem();
    L21:
        if ((r11 & 256) != 0) goto L23;
        return;
    L23:
        if (this.mActionBarVisibilityCallback == null) goto L27;
        ViewCompat.requestApplyInsets(this);
        return;
    L27:
        return;
    L8:
        r13 = false;
        goto L10
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int r10) {
        super.onWindowVisibilityChanged(r10);
        this.mWindowVisibility = r10;
        ActionBarVisibilityCallback r11 = this.mActionBarVisibilityCallback;
        if (r11 == null) goto L6;
        r11.onWindowVisibilityChanged(r10);
        return;
    }

    void pullChildren() {
        if (this.mContent != null) goto L6;
        this.mContent = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
        this.mActionBarTop = (ActionBarContainer) findViewById(R.id.action_bar_container);
        this.mDecorToolbar = getDecorToolbar(findViewById(R.id.action_bar));
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> r10) {
        pullChildren();
        this.mDecorToolbar.restoreHierarchyState(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> r10) {
        pullChildren();
        this.mDecorToolbar.saveHierarchyState(r10);
    }

    public void setActionBarHideOffset(int r10) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(r10, this.mActionBarTop.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback r10) {
        this.mActionBarVisibilityCallback = r10;
        if (getWindowToken() == null) goto L8;
        this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
        int r11 = this.mLastSystemUiVisibility;
        if (r11 == 0) goto L9;
        onWindowSystemUiVisibilityChanged(r11);
        ViewCompat.requestApplyInsets(this);
        return;
    L9:
        return;
    }

    public void setHasNonEmbeddedTabs(boolean r10) {
        this.mHasNonEmbeddedTabs = r10;
    }

    public void setHideOnContentScrollEnabled(boolean r10) {
        if (r10 == this.mHideOnContentScroll) goto L8;
        this.mHideOnContentScroll = r10;
        if (r10 == true) goto L9;
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(int r10) {
        pullChildren();
        this.mDecorToolbar.setIcon(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(Drawable r10) {
        pullChildren();
        this.mDecorToolbar.setIcon(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setLogo(int r10) {
        pullChildren();
        this.mDecorToolbar.setLogo(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu r10, MenuPresenter.Callback r11) {
        pullChildren();
        this.mDecorToolbar.setMenu(r10, r11);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean r10) {
        this.mOverlayMode = r10;
        if (r10 == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.mIgnoreWindowContentOverlay = r11;
        return;
    L5:
        if (getContext().getApplicationInfo().targetSdkVersion >= 19) goto L7;
        r11 = true;
        goto L8
    }

    public void setShowingForActionMode(boolean r10) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setUiOptions(int r10) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback r10) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(r10);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence r10) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(r10);
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
}
