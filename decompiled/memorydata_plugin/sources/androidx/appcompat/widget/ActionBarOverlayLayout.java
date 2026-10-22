package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
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
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
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
    private WindowInsetsCompat mInnerInsets;
    private final Rect mInnerInsetsRect;
    private final Rect mLastBaseContentInsets;
    private WindowInsetsCompat mLastBaseInnerInsets;
    private final Rect mLastBaseInnerInsetsRect;
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
        void enableContentAnimations(boolean r1);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int r1);

        void showForSystem();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
        }
    }

    static {
        ATTRS = new int[]{ZeusTransformUtils.mapRes(R.attr.actionBarSize, "attr", "actionBarSize"), android.R.attr.windowContentOverlay};
    }

    public ActionBarOverlayLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ActionBarOverlayLayout(Context r3, AttributeSet r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        super(r5, (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin"));
        this.mWindowVisibility = 0;
        this.mBaseContentInsets = new Rect();
        this.mLastBaseContentInsets = new Rect();
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        this.mBaseInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mLastBaseInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mLastInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mTopAnimatorListener = new AnonymousClass1(this);
        this.mRemoveActionBarHideOffset = new AnonymousClass2(this);
        this.mAddActionBarHideOffset = new AnonymousClass3(this);
        init(r5);
        this.mParentHelper = new NestedScrollingParentHelper(this);
    }

    private void addActionBarHideOffset() {
        haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(View r2, Rect r3, boolean r4, boolean r5, boolean r6, boolean r7) {
        LayoutParams r1 = (LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        if (r4 == true) goto L5;
    L7:
        boolean r8 = false;
    L8:
        if (r5 == true) goto L10;
    L12:
        if (r7 == true) goto L14;
    L16:
        if (r6 == false) goto L21;
        if (r1.bottomMargin == r3.bottom) goto L21;
        r1.bottomMargin = r3.bottom;
        return true;
    L21:
        return r8;
    L14:
        if (r1.rightMargin == r3.right) goto L16;
        r1.rightMargin = r3.right;
        r8 = true;
        goto L16
    L10:
        if (r1.topMargin == r3.top) goto L12;
        r1.topMargin = r3.top;
        r8 = true;
        goto L12
    L5:
        if (r1.leftMargin == r3.left) goto L7;
        r1.leftMargin = r3.left;
        r8 = true;
        goto L8
    }

    private DecorToolbar getDecorToolbar(View r3) {
        if (ZeusTransformUtils.instanceOf(r3, DecorToolbar.class) == false) goto L7;
        return (DecorToolbar) ZeusTransformUtils.preCheckCast(r3, DecorToolbar.class, "com.obric.memorydata.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Toolbar.class) == false) goto L11;
        return ((Toolbar) ZeusTransformUtils.preCheckCast(r3, Toolbar.class, "com.obric.memorydata.plugin")).getWrapper();
    L11:
        throw new IllegalStateException("Can't make a decor toolbar out of " + r3.getClass().getSimpleName());
    }

    private void init(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        TypedArray r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getTheme().obtainStyledAttributes(ATTRS);
        boolean r1 = false;
        this.mActionBarHeight = r0.getDimensionPixelSize(0, 0);
        Drawable r3 = r0.getDrawable(1);
        this.mWindowContentOverlay = r3;
        if (r3 != null) goto L5;
        boolean r4 = true;
    L6:
        setWillNotDraw(r4);
        r0.recycle();
        if (r6.getApplicationInfo().targetSdkVersion >= 19) goto L9;
        r1 = true;
    L9:
        this.mIgnoreWindowContentOverlay = r1;
        this.mFlingEstimator = new OverScroller(r6);
        return;
    L5:
        r4 = false;
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
    public boolean checkLayoutParams(ViewGroup.LayoutParams r1) {
        return ZeusTransformUtils.instanceOf(r1, LayoutParams.class);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    @Override // android.view.View
    public void draw(Canvas r6) {
        super.draw(r6);
        if (this.mWindowContentOverlay != null) goto L5;
        return;
    L5:
        if (this.mIgnoreWindowContentOverlay == false) goto L7;
        return;
    L7:
        if (this.mActionBarTop.getVisibility() != 0) goto L9;
        int r0 = (int) ((this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY()) + 0.5f);
    L10:
        this.mWindowContentOverlay.setBounds(0, r0, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + r0);
        this.mWindowContentOverlay.draw(r6);
        return;
    L9:
        r0 = 0;
        goto L10
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect r8) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        pullChildren();
        boolean r0 = applyInsets(this.mActionBarTop, r8, true, true, false, true);
        this.mBaseInnerInsetsRect.set(r8);
        ViewUtils.computeFitSystemWindows(this, this.mBaseInnerInsetsRect, this.mBaseContentInsets);
        if (this.mLastBaseInnerInsetsRect.equals(this.mBaseInnerInsetsRect) == true) goto L10;
        this.mLastBaseInnerInsetsRect.set(this.mBaseInnerInsetsRect);
        r0 = true;
    L10:
        if (this.mLastBaseContentInsets.equals(this.mBaseContentInsets) == true) goto L12;
        this.mLastBaseContentInsets.set(this.mBaseContentInsets);
        r0 = true;
    L12:
        if (r0 == false) goto L14;
        requestLayout();
    L14:
        return true;
    L5:
        return super.fitSystemWindows(r8);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return generateLayoutParams((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return new LayoutParams(r1);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new LayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer r0 = this.mActionBarTop;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return -((int) r0.getTranslationY());
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
        ViewPropertyAnimator r1 = this.mCurrentActionBarTopAnimator;
        if (r1 == null) goto L6;
        r1.cancel();
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
    public void initFeature(int r2) {
        pullChildren();
        if (r2 != 2) goto L5;
        this.mDecorToolbar.initProgress();
        return;
    L5:
        if (r2 != 5) goto L7;
        this.mDecorToolbar.initIndeterminateProgress();
        return;
    L7:
        if (r2 != 109) goto L15;
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
    public WindowInsets onApplyWindowInsets(WindowInsets r8) {
        pullChildren();
        WindowInsetsCompat r9 = WindowInsetsCompat.toWindowInsetsCompat(r8, this);
        boolean r0 = applyInsets(this.mActionBarTop, new Rect(r9.getSystemWindowInsetLeft(), r9.getSystemWindowInsetTop(), r9.getSystemWindowInsetRight(), r9.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, r9, this.mBaseContentInsets);
        WindowInsetsCompat r1 = r9.inset(this.mBaseContentInsets.left, this.mBaseContentInsets.top, this.mBaseContentInsets.right, this.mBaseContentInsets.bottom);
        this.mBaseInnerInsets = r1;
        boolean r2 = true;
        if (this.mLastBaseInnerInsets.equals(r1) == true) goto L6;
        this.mLastBaseInnerInsets = this.mBaseInnerInsets;
        r0 = true;
    L6:
        if (this.mLastBaseContentInsets.equals(this.mBaseContentInsets) == true) goto L8;
        this.mLastBaseContentInsets.set(this.mBaseContentInsets);
    L9:
        if (r2 == false) goto L12;
        requestLayout();
    L12:
        return r9.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    L8:
        r2 = r0;
        goto L9
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration r3) {
        super.onConfigurationChanged(r3);
        init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        ViewCompat.requestApplyInsets(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r6, int r7, int r8, int r9) {
        int r10 = getChildCount();
        int r11 = getPaddingLeft();
        int r12 = getPaddingTop();
        int r13 = 0;
    L3:
        if (r13 >= r10) goto L8;
        View r14 = getChildAt(r13);
        if (r14.getVisibility() == 8) goto L7;
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r14.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r1 = r14.getMeasuredWidth();
        int r2 = r14.getMeasuredHeight();
        int r3 = r0.leftMargin + r11;
        int r4 = r0.topMargin + r12;
        r14.layout(r3, r4, r1 + r3, r2 + r4);
    L7:
        r13 = r13 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onMeasure(int r13, int r14) {
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, r13, 0, r14, 0);
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mActionBarTop.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r8 = Math.max(0, (this.mActionBarTop.getMeasuredWidth() + r0.leftMargin) + r0.rightMargin);
        int r9 = Math.max(0, (this.mActionBarTop.getMeasuredHeight() + r0.topMargin) + r0.bottomMargin);
        int r10 = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        if ((ViewCompat.getWindowSystemUiVisibility(this) & 256) == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L13;
        int r2 = this.mActionBarHeight;
        if (this.mHasNonEmbeddedTabs == true) goto L10;
    L16:
        this.mContentInsets.set(this.mBaseContentInsets);
        if (Build.VERSION.SDK_INT < 21) goto L19;
        this.mInnerInsets = this.mBaseInnerInsets;
    L21:
        if (this.mOverlayMode == true) goto L27;
        if (r1 == true) goto L27;
        this.mContentInsets.top += r2;
        this.mContentInsets.bottom += 0;
        if (Build.VERSION.SDK_INT < 21) goto L31;
        WindowInsetsCompat r3 = this.mInnerInsets.inset(0, r2, 0, 0);
    L29:
        this.mInnerInsets = r3;
    L31:
        applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (Build.VERSION.SDK_INT < 21) goto L37;
        if (this.mLastInnerInsets.equals(this.mInnerInsets) == true) goto L37;
        WindowInsetsCompat r4 = this.mInnerInsets;
        this.mLastInnerInsets = r4;
        ViewCompat.dispatchApplyWindowInsets(this.mContent, r4);
    L41:
        measureChildWithMargins(this.mContent, r13, 0, r14, 0);
        LayoutParams r5 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.mContent.getLayoutParams(), LayoutParams.class, "com.obric.memorydata.plugin");
        int r6 = Math.max(r8, (this.mContent.getMeasuredWidth() + r5.leftMargin) + r5.rightMargin);
        int r7 = Math.max(r9, (this.mContent.getMeasuredHeight() + r5.topMargin) + r5.bottomMargin);
        int r11 = View.combineMeasuredStates(r10, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(r6 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), r13, r11), View.resolveSizeAndState(Math.max(r7 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r14, r11 << 16));
        return;
    L37:
        if (Build.VERSION.SDK_INT >= 21) goto L41;
        if (this.mLastInnerInsetsRect.equals(this.mInnerInsetsRect) == true) goto L41;
        this.mLastInnerInsetsRect.set(this.mInnerInsetsRect);
        this.mContent.dispatchFitSystemWindows(this.mInnerInsetsRect);
    L27:
        if (Build.VERSION.SDK_INT < 21) goto L30;
        r3 = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets(Insets.of(this.mInnerInsets.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + r2, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom() + 0)).build();
        goto L29
    L30:
        this.mInnerInsetsRect.top += r2;
        this.mInnerInsetsRect.bottom += 0;
        goto L31
    L19:
        this.mInnerInsetsRect.set(this.mBaseInnerInsetsRect);
        goto L21
    L10:
        if (this.mActionBarTop.getTabContainer() == null) goto L16;
        r2 = r2 + this.mActionBarHeight;
        goto L16
    L13:
        if (this.mActionBarTop.getVisibility() == 8) goto L15;
        r2 = this.mActionBarTop.getMeasuredHeight();
        goto L16
    L15:
        r2 = 0;
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r1, float r2, float r3, boolean r4) {
        if (this.mHideOnContentScroll == false) goto L12;
        if (r4 == true) goto L7;
        return false;
    L7:
        if (shouldHideActionBarOnFling(r3) == false) goto L9;
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
    public boolean onNestedPreFling(View r1, float r2, float r3) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r1, int r2, int r3, int[] r4) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        if (r5 != 0) goto L5;
        onNestedPreScroll(r1, r2, r3, r4);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5) {
        int r6 = this.mHideOnContentScrollReference + r3;
        this.mHideOnContentScrollReference = r6;
        setActionBarHideOffset(r6);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        if (r6 != 0) goto L5;
        onNestedScroll(r1, r2, r3, r4, r5);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        onNestedScroll(r1, r2, r3, r4, r5, r6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r2, View r3, int r4) {
        this.mParentHelper.onNestedScrollAccepted(r2, r3, r4);
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback r1 = this.mActionBarVisibilityCallback;
        if (r1 == null) goto L6;
        r1.onContentScrollStarted();
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r1, View r2, int r3, int r4) {
        if (r4 != 0) goto L5;
        onNestedScrollAccepted(r1, r2, r3);
        return;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r1, View r2, int r3) {
        if ((r3 & 2) != 0) goto L5;
        return false;
    L5:
        if (this.mActionBarTop.getVisibility() == 0) goto L8;
        return false;
    L8:
        return this.mHideOnContentScroll;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        if (r4 == 0) goto L4;
    L6:
        return false;
    L4:
        if (onStartNestedScroll(r1, r2, r3) == false) goto L6;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r2) {
        if (this.mHideOnContentScroll == true) goto L5;
    L10:
        ActionBarVisibilityCallback r1 = this.mActionBarVisibilityCallback;
        if (r1 == null) goto L14;
        r1.onContentScrollStopped();
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
    public void onStopNestedScroll(View r1, int r2) {
        if (r2 != 0) goto L5;
        onStopNestedScroll(r1);
        return;
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int r5) {
        if (Build.VERSION.SDK_INT < 16) goto L5;
        super.onWindowSystemUiVisibilityChanged(r5);
    L5:
        pullChildren();
        int r0 = this.mLastSystemUiVisibility ^ r5;
        this.mLastSystemUiVisibility = r5;
        boolean r2 = false;
        if ((r5 & 4) != 0) goto L8;
        boolean r1 = true;
    L10:
        if ((r5 & 256) == 0) goto L12;
        r2 = true;
    L12:
        ActionBarVisibilityCallback r6 = this.mActionBarVisibilityCallback;
        if (r6 == null) goto L21;
        r6.enableContentAnimations(!r2);
        if (r1 == true) goto L19;
        if (r2 == false) goto L19;
        this.mActionBarVisibilityCallback.hideForSystem();
    L19:
        this.mActionBarVisibilityCallback.showForSystem();
    L21:
        if ((r0 & 256) != 0) goto L23;
        return;
    L23:
        if (this.mActionBarVisibilityCallback == null) goto L27;
        ViewCompat.requestApplyInsets(this);
        return;
    L27:
        return;
    L8:
        r1 = false;
        goto L10
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        this.mWindowVisibility = r1;
        ActionBarVisibilityCallback r0 = this.mActionBarVisibilityCallback;
        if (r0 == null) goto L6;
        r0.onWindowVisibilityChanged(r1);
        return;
    }

    void pullChildren() {
        if (this.mContent != null) goto L6;
        this.mContent = (ContentFrameLayout) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_activity_content, OaidModel.KEY_ID, "action_bar_activity_content")), ContentFrameLayout.class, "com.obric.memorydata.plugin");
        this.mActionBarTop = (ActionBarContainer) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_container, OaidModel.KEY_ID, "action_bar_container")), ActionBarContainer.class, "com.obric.memorydata.plugin");
        this.mDecorToolbar = getDecorToolbar(findViewById(ZeusTransformUtils.mapRes(R.id.action_bar, OaidModel.KEY_ID, "action_bar")));
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void restoreToolbarHierarchyState(SparseArray<Parcelable> r1) {
        pullChildren();
        this.mDecorToolbar.restoreHierarchyState(r1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void saveToolbarHierarchyState(SparseArray<Parcelable> r1) {
        pullChildren();
        this.mDecorToolbar.saveHierarchyState(r1);
    }

    public void setActionBarHideOffset(int r2) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY(-Math.max(0, Math.min(r2, this.mActionBarTop.getHeight())));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback r3) {
        this.mActionBarVisibilityCallback = (ActionBarVisibilityCallback) ZeusTransformUtils.wrapperContextForParams(r3, ActionBarVisibilityCallback.class, "com.obric.memorydata.plugin");
        if (getWindowToken() == null) goto L8;
        this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
        int r4 = this.mLastSystemUiVisibility;
        if (r4 == 0) goto L9;
        onWindowSystemUiVisibilityChanged(r4);
        ViewCompat.requestApplyInsets(this);
        return;
    L9:
        return;
    }

    public void setHasNonEmbeddedTabs(boolean r1) {
        this.mHasNonEmbeddedTabs = r1;
    }

    public void setHideOnContentScrollEnabled(boolean r2) {
        if (r2 == this.mHideOnContentScroll) goto L8;
        this.mHideOnContentScroll = r2;
        if (r2 == true) goto L9;
        haltActionBarHideOffsetAnimations();
        setActionBarHideOffset(0);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(int r1) {
        pullChildren();
        this.mDecorToolbar.setIcon(r1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setIcon(Drawable r1) {
        pullChildren();
        this.mDecorToolbar.setIcon(r1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setLogo(int r1) {
        pullChildren();
        this.mDecorToolbar.setLogo(r1);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu r3, MenuPresenter.Callback r4) {
        Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r3, Menu.class, "com.obric.memorydata.plugin");
        MenuPresenter.Callback r6 = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r4, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
        pullChildren();
        this.mDecorToolbar.setMenu(r5, r6);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean r3) {
        this.mOverlayMode = r3;
        if (r3 == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.mIgnoreWindowContentOverlay = r4;
        return;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion >= 19) goto L7;
        r4 = true;
        goto L8
    }

    public void setShowingForActionMode(boolean r1) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setUiOptions(int r1) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback r3) {
        Window.Callback r4 = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.memorydata.plugin");
        pullChildren();
        this.mDecorToolbar.setWindowCallback(r4);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        pullChildren();
        this.mDecorToolbar.setWindowTitle(r4);
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
