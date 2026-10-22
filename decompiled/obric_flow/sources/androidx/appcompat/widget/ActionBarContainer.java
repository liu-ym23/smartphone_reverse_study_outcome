package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContainer extends FrameLayout {
    private View mActionBarView;
    Drawable mBackground;
    private View mContextView;
    private int mHeight;
    boolean mIsSplit;
    boolean mIsStacked;
    private boolean mIsTransitioning;
    Drawable mSplitBackground;
    Drawable mStackedBackground;
    private View mTabContainer;

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void invalidateOutline(ActionBarContainer r5) {
            r5.invalidateOutline();
        }
    }

    public ActionBarContainer(Context r5) {
        this(r5, null);
    }

    private int getMeasuredHeightWithMargins(View r5) {
        FrameLayout.LayoutParams r10 = (FrameLayout.LayoutParams) r5.getLayoutParams();
        return (r5.getMeasuredHeight() + r10.topMargin) + r10.bottomMargin;
    }

    private boolean isCollapsed(View r5) {
        if (r5 != null) goto L4;
    L9:
        return true;
    L4:
        if (r5.getVisibility() == 8) goto L9;
        if (r5.getMeasuredHeight() == 0) goto L9;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r5 = this.mBackground;
        if (r5 != null) goto L5;
    L7:
        Drawable r10 = this.mStackedBackground;
        if (r10 != null) goto L10;
    L12:
        Drawable r11 = this.mSplitBackground;
        if (r11 != null) goto L15;
        return;
    L15:
        if (r11.isStateful() == false) goto L19;
        this.mSplitBackground.setState(getDrawableState());
        return;
    L19:
        return;
    L10:
        if (r10.isStateful() == false) goto L12;
        this.mStackedBackground.setState(getDrawableState());
        goto L12
    L5:
        if (r5.isStateful() == false) goto L7;
        this.mBackground.setState(getDrawableState());
        goto L7
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r5 = this.mBackground;
        if (r5 == null) goto L5;
        r5.jumpToCurrentState();
    L5:
        Drawable r10 = this.mStackedBackground;
        if (r10 == null) goto L8;
        r10.jumpToCurrentState();
    L8:
        Drawable r11 = this.mSplitBackground;
        if (r11 == null) goto L12;
        r11.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(R.id.action_bar);
        this.mContextView = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r5) {
        super.onHoverEvent(r5);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r5) {
        if (this.mIsTransitioning == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r5) == true) goto L8;
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        View r14 = this.mTabContainer;
        boolean r15 = true;
        boolean r16 = false;
        if (r14 != null) goto L5;
    L7:
        boolean r17 = false;
    L8:
        if (r14 == null) goto L13;
        if (r14.getVisibility() == 8) goto L13;
        int r18 = getMeasuredHeight();
        FrameLayout.LayoutParams r19 = (FrameLayout.LayoutParams) r14.getLayoutParams();
        int r20 = r18 - r14.getMeasuredHeight();
        int r21 = r19.bottomMargin;
        r14.layout(r10, r20 - r21, r12, r18 - r21);
    L13:
        if (this.mIsSplit == false) goto L19;
        Drawable r22 = this.mSplitBackground;
        if (r22 == null) goto L17;
        r22.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L35:
        if (r15 == false) goto L38;
        invalidate();
        return;
    L38:
        return;
    L17:
        r15 = r16;
        goto L35
    L19:
        if (this.mBackground != null) goto L21;
    L30:
        this.mIsStacked = r17;
        if (r17 == false) goto L17;
        Drawable r23 = this.mStackedBackground;
        if (r23 == null) goto L17;
        r23.setBounds(r14.getLeft(), r14.getTop(), r14.getRight(), r14.getBottom());
        goto L35
    L21:
        if (this.mActionBarView.getVisibility() != 0) goto L23;
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
    L29:
        r16 = true;
        goto L30
    L23:
        View r24 = this.mContextView;
        if (r24 != null) goto L26;
    L28:
        this.mBackground.setBounds(0, 0, 0, 0);
        goto L29
    L26:
        if (r24.getVisibility() != 0) goto L28;
        this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
        goto L29
    L5:
        if (r14.getVisibility() == 8) goto L7;
        r17 = true;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r5, int r10) {
        if (this.mActionBarView == null) goto L5;
    L9:
        super.onMeasure(r5, r10);
        if (this.mActionBarView != null) goto L12;
        return;
    L12:
        int r11 = View.MeasureSpec.getMode(r10);
        View r12 = this.mTabContainer;
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.getVisibility() != 8) goto L17;
        return;
    L17:
        if (r11 != 1073741824) goto L19;
        return;
    L19:
        if (isCollapsed(this.mActionBarView) == true) goto L22;
        int r13 = getMeasuredHeightWithMargins(this.mActionBarView);
    L25:
        if (r11 != Integer.MIN_VALUE) goto L27;
        int r14 = View.MeasureSpec.getSize(r10);
    L28:
        setMeasuredDimension(getMeasuredWidth(), Math.min(r13 + getMeasuredHeightWithMargins(this.mTabContainer), r14));
        return;
    L27:
        r14 = Integer.MAX_VALUE;
        goto L28
    L22:
        if (isCollapsed(this.mContextView) == true) goto L24;
        r13 = getMeasuredHeightWithMargins(this.mContextView);
        goto L25
    L24:
        r13 = 0;
        goto L25
    L5:
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L9;
        int r15 = this.mHeight;
        if (r15 < 0) goto L9;
        r10 = View.MeasureSpec.makeMeasureSpec(Math.min(r15, View.MeasureSpec.getSize(r10)), Integer.MIN_VALUE);
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        super.onTouchEvent(r5);
        return true;
    }

    public void setPrimaryBackground(Drawable r5) {
        Drawable r10 = this.mBackground;
        if (r10 == null) goto L5;
        r10.setCallback(null);
        unscheduleDrawable(this.mBackground);
    L5:
        this.mBackground = r5;
        if (r5 == null) goto L10;
        r5.setCallback(this);
        View r11 = this.mActionBarView;
        if (r11 == null) goto L10;
        this.mBackground.setBounds(r11.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
    L10:
        boolean r12 = false;
        if (this.mIsSplit == false) goto L16;
        if (this.mSplitBackground != null) goto L20;
    L14:
        r12 = true;
    L20:
        setWillNotDraw(r12);
        invalidate();
        Api21Impl.invalidateOutline(this);
        return;
    L16:
        if (this.mBackground != null) goto L20;
        if (this.mStackedBackground != null) goto L20;
        goto L20
    }

    public void setSplitBackground(Drawable r5) {
        Drawable r10 = this.mSplitBackground;
        if (r10 == null) goto L5;
        r10.setCallback(null);
        unscheduleDrawable(this.mSplitBackground);
    L5:
        this.mSplitBackground = r5;
        boolean r11 = false;
        if (r5 == null) goto L13;
        r5.setCallback(this);
        if (this.mIsSplit == false) goto L13;
        Drawable r12 = this.mSplitBackground;
        if (r12 == null) goto L13;
        r12.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L13:
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground != null) goto L22;
    L16:
        r11 = true;
    L22:
        setWillNotDraw(r11);
        invalidate();
        Api21Impl.invalidateOutline(this);
        return;
    L18:
        if (this.mBackground != null) goto L22;
        if (this.mStackedBackground != null) goto L22;
        goto L22
    }

    public void setStackedBackground(Drawable r5) {
        Drawable r10 = this.mStackedBackground;
        if (r10 == null) goto L5;
        r10.setCallback(null);
        unscheduleDrawable(this.mStackedBackground);
    L5:
        this.mStackedBackground = r5;
        if (r5 == null) goto L12;
        r5.setCallback(this);
        if (this.mIsStacked == false) goto L12;
        Drawable r11 = this.mStackedBackground;
        if (r11 == null) goto L12;
        r11.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
    L12:
        boolean r12 = false;
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground != null) goto L22;
    L16:
        r12 = true;
    L22:
        setWillNotDraw(r12);
        invalidate();
        Api21Impl.invalidateOutline(this);
        return;
    L18:
        if (this.mBackground != null) goto L22;
        if (this.mStackedBackground != null) goto L22;
        goto L22
    }

    public void setTabContainer(ScrollingTabContainerView r5) {
        View r10 = this.mTabContainer;
        if (r10 == null) goto L5;
        removeView(r10);
    L5:
        this.mTabContainer = r5;
        if (r5 == null) goto L9;
        addView(r5);
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        r11.width = -1;
        r11.height = -2;
        r5.setAllowCollapse(false);
        return;
    }

    public void setTransitioning(boolean r5) {
        this.mIsTransitioning = r5;
        if (r5 == false) goto L5;
        int r10 = 393216;
    L6:
        setDescendantFocusability(r10);
        return;
    L5:
        r10 = 262144;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(r5);
        if (r5 != 0) goto L5;
        boolean r10 = true;
    L6:
        Drawable r11 = this.mBackground;
        if (r11 == null) goto L9;
        r11.setVisible(r10, false);
    L9:
        Drawable r12 = this.mStackedBackground;
        if (r12 == null) goto L12;
        r12.setVisible(r10, false);
    L12:
        Drawable r13 = this.mSplitBackground;
        if (r13 == null) goto L16;
        r13.setVisible(r10, false);
        return;
    L16:
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r5, ActionMode.Callback r10) {
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r5) {
        if (r5 != this.mBackground) goto L7;
        if (this.mIsSplit == true) goto L7;
    L16:
        return true;
    L7:
        if (r5 != this.mStackedBackground) goto L11;
        if (this.mIsStacked == true) goto L16;
    L11:
        if (r5 != this.mSplitBackground) goto L15;
        if (this.mIsSplit == true) goto L16;
    L15:
        if (super.verifyDrawable(r5) == true) goto L16;
        return false;
    }

    public ActionBarContainer(Context r5, AttributeSet r10) {
        super(r5, r10);
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray r11 = r5.obtainStyledAttributes(r10, R.styleable.ActionBar);
        this.mBackground = r11.getDrawable(R.styleable.ActionBar_background);
        this.mStackedBackground = r11.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.mHeight = r11.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean r12 = true;
        if (getId() != R.id.split_action_bar) goto L5;
        this.mIsSplit = true;
        this.mSplitBackground = r11.getDrawable(R.styleable.ActionBar_backgroundSplit);
    L5:
        r11.recycle();
        if (this.mIsSplit == false) goto L12;
        if (this.mSplitBackground == null) goto L15;
    L10:
        r12 = false;
    L15:
        setWillNotDraw(r12);
        return;
    L12:
        if (this.mBackground != null) goto L10;
        if (this.mStackedBackground != null) goto L10;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r5, ActionMode.Callback r10, int r11) {
        if (r11 != 0) goto L4;
        return null;
    L4:
        return super.startActionModeForChild(r5, r10, r11);
    }
}
