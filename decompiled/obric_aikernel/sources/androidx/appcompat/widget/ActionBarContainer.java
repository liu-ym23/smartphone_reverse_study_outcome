package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
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
    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void invalidateOutline(ActionBarContainer r10) {
            r10.invalidateOutline();
        }
    }

    public ActionBarContainer(Context r10) {
        this(r10, null);
    }

    public ActionBarContainer(Context r10, AttributeSet r11) {
        super(r10, r11);
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray r12 = r10.obtainStyledAttributes(r11, R.styleable.ActionBar);
        this.mBackground = r12.getDrawable(R.styleable.ActionBar_background);
        this.mStackedBackground = r12.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.mHeight = r12.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean r13 = true;
        if (getId() != R.id.split_action_bar) goto L5;
        this.mIsSplit = true;
        this.mSplitBackground = r12.getDrawable(R.styleable.ActionBar_backgroundSplit);
    L5:
        r12.recycle();
        if (this.mIsSplit == false) goto L11;
        if (this.mSplitBackground == null) goto L16;
    L15:
        r13 = false;
    L16:
        setWillNotDraw(r13);
        return;
    L11:
        if (this.mBackground != null) goto L15;
        if (this.mStackedBackground != null) goto L15;
        goto L15
    }

    private int getMeasuredHeightWithMargins(View r10) {
        FrameLayout.LayoutParams r11 = (FrameLayout.LayoutParams) r10.getLayoutParams();
        return (r10.getMeasuredHeight() + r11.topMargin) + r11.bottomMargin;
    }

    private boolean isCollapsed(View r10) {
        if (r10 != null) goto L4;
    L9:
        return true;
    L4:
        if (r10.getVisibility() == 8) goto L9;
        if (r10.getMeasuredHeight() == 0) goto L9;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r10 = this.mBackground;
        if (r10 != null) goto L5;
    L7:
        Drawable r11 = this.mStackedBackground;
        if (r11 != null) goto L10;
    L12:
        Drawable r12 = this.mSplitBackground;
        if (r12 != null) goto L15;
        return;
    L15:
        if (r12.isStateful() == false) goto L19;
        this.mSplitBackground.setState(getDrawableState());
        return;
    L19:
        return;
    L10:
        if (r11.isStateful() == false) goto L12;
        this.mStackedBackground.setState(getDrawableState());
        goto L12
    L5:
        if (r10.isStateful() == false) goto L7;
        this.mBackground.setState(getDrawableState());
        goto L7
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r10 = this.mBackground;
        if (r10 == null) goto L5;
        r10.jumpToCurrentState();
    L5:
        Drawable r11 = this.mStackedBackground;
        if (r11 == null) goto L8;
        r11.jumpToCurrentState();
    L8:
        Drawable r12 = this.mSplitBackground;
        if (r12 == null) goto L12;
        r12.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(R.id.action_bar);
        this.mContextView = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        super.onHoverEvent(r10);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.mIsTransitioning == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r10) == true) goto L8;
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
        View r15 = this.mTabContainer;
        boolean r16 = true;
        boolean r17 = false;
        if (r15 != null) goto L5;
    L7:
        boolean r18 = false;
    L8:
        if (r15 == null) goto L13;
        if (r15.getVisibility() == 8) goto L13;
        int r19 = getMeasuredHeight();
        FrameLayout.LayoutParams r20 = (FrameLayout.LayoutParams) r15.getLayoutParams();
        int r21 = r19 - r15.getMeasuredHeight();
        int r22 = r20.bottomMargin;
        r15.layout(r11, r21 - r22, r13, r19 - r22);
    L13:
        if (this.mIsSplit == false) goto L19;
        Drawable r23 = this.mSplitBackground;
        if (r23 == null) goto L17;
        r23.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L36:
        if (r16 == false) goto L39;
        invalidate();
        return;
    L39:
        return;
    L17:
        r16 = r17;
        goto L36
    L19:
        if (this.mBackground != null) goto L21;
    L31:
        this.mIsStacked = r18;
        if (r18 == false) goto L17;
        Drawable r24 = this.mStackedBackground;
        if (r24 == null) goto L17;
        r24.setBounds(r15.getLeft(), r15.getTop(), r15.getRight(), r15.getBottom());
        goto L36
    L21:
        if (this.mActionBarView.getVisibility() != 0) goto L24;
        Drawable r25 = this.mBackground;
        int r26 = this.mActionBarView.getLeft();
        int r27 = this.mActionBarView.getTop();
        int r28 = this.mActionBarView.getRight();
        View r29 = this.mActionBarView;
    L23:
        r25.setBounds(r26, r27, r28, r29.getBottom());
    L30:
        r17 = true;
        goto L31
    L24:
        View r30 = this.mContextView;
        if (r30 != null) goto L27;
    L29:
        this.mBackground.setBounds(0, 0, 0, 0);
        goto L30
    L27:
        if (r30.getVisibility() != 0) goto L29;
        r25 = this.mBackground;
        r26 = this.mContextView.getLeft();
        r27 = this.mContextView.getTop();
        r28 = this.mContextView.getRight();
        r29 = this.mContextView;
        goto L23
    L5:
        if (r15.getVisibility() == 8) goto L7;
        r18 = true;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        if (this.mActionBarView == null) goto L5;
    L9:
        super.onMeasure(r10, r11);
        if (this.mActionBarView != null) goto L12;
        return;
    L12:
        int r12 = View.MeasureSpec.getMode(r11);
        View r13 = this.mTabContainer;
        if (r13 != null) goto L15;
        return;
    L15:
        if (r13.getVisibility() != 8) goto L17;
        return;
    L17:
        if (r12 != 1073741824) goto L19;
        return;
    L19:
        if (isCollapsed(this.mActionBarView) == true) goto L23;
        View r14 = this.mActionBarView;
    L21:
        int r15 = getMeasuredHeightWithMargins(r14);
    L26:
        if (r12 != Integer.MIN_VALUE) goto L28;
        int r16 = View.MeasureSpec.getSize(r11);
    L29:
        setMeasuredDimension(getMeasuredWidth(), Math.min(r15 + getMeasuredHeightWithMargins(this.mTabContainer), r16));
        return;
    L28:
        r16 = Integer.MAX_VALUE;
        goto L29
    L23:
        if (isCollapsed(this.mContextView) == true) goto L25;
        r14 = this.mContextView;
        goto L21
    L25:
        r15 = 0;
        goto L26
    L5:
        if (View.MeasureSpec.getMode(r11) != Integer.MIN_VALUE) goto L9;
        int r17 = this.mHeight;
        if (r17 < 0) goto L9;
        r11 = View.MeasureSpec.makeMeasureSpec(Math.min(r17, View.MeasureSpec.getSize(r11)), Integer.MIN_VALUE);
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        super.onTouchEvent(r10);
        return true;
    }

    public void setPrimaryBackground(Drawable r10) {
        Drawable r11 = this.mBackground;
        if (r11 == null) goto L5;
        r11.setCallback(null);
        unscheduleDrawable(this.mBackground);
    L5:
        this.mBackground = r10;
        if (r10 == null) goto L10;
        r10.setCallback(this);
        View r12 = this.mActionBarView;
        if (r12 == null) goto L10;
        this.mBackground.setBounds(r12.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
    L10:
        boolean r13 = true;
        if (this.mIsSplit == false) goto L16;
        if (this.mSplitBackground == null) goto L21;
    L20:
        r13 = false;
    L21:
        setWillNotDraw(r13);
        invalidate();
        if (Build.VERSION.SDK_INT < 21) goto L25;
        Api21Impl.invalidateOutline(this);
        return;
    L25:
        return;
    L16:
        if (this.mBackground != null) goto L20;
        if (this.mStackedBackground != null) goto L20;
        goto L20
    }

    public void setSplitBackground(Drawable r10) {
        Drawable r11 = this.mSplitBackground;
        if (r11 == null) goto L5;
        r11.setCallback(null);
        unscheduleDrawable(this.mSplitBackground);
    L5:
        this.mSplitBackground = r10;
        boolean r12 = false;
        if (r10 == null) goto L13;
        r10.setCallback(this);
        if (this.mIsSplit == false) goto L13;
        Drawable r13 = this.mSplitBackground;
        if (r13 == null) goto L13;
        r13.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L13:
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground != null) goto L22;
    L16:
        r12 = true;
    L22:
        setWillNotDraw(r12);
        invalidate();
        if (Build.VERSION.SDK_INT < 21) goto L26;
        Api21Impl.invalidateOutline(this);
        return;
    L26:
        return;
    L18:
        if (this.mBackground != null) goto L22;
        if (this.mStackedBackground != null) goto L22;
        goto L22
    }

    public void setStackedBackground(Drawable r10) {
        Drawable r11 = this.mStackedBackground;
        if (r11 == null) goto L5;
        r11.setCallback(null);
        unscheduleDrawable(this.mStackedBackground);
    L5:
        this.mStackedBackground = r10;
        if (r10 == null) goto L12;
        r10.setCallback(this);
        if (this.mIsStacked == false) goto L12;
        Drawable r12 = this.mStackedBackground;
        if (r12 == null) goto L12;
        r12.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
    L12:
        boolean r13 = true;
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground == null) goto L23;
    L22:
        r13 = false;
    L23:
        setWillNotDraw(r13);
        invalidate();
        if (Build.VERSION.SDK_INT < 21) goto L27;
        Api21Impl.invalidateOutline(this);
        return;
    L27:
        return;
    L18:
        if (this.mBackground != null) goto L22;
        if (this.mStackedBackground != null) goto L22;
        goto L22
    }

    public void setTabContainer(ScrollingTabContainerView r10) {
        View r11 = this.mTabContainer;
        if (r11 == null) goto L5;
        removeView(r11);
    L5:
        this.mTabContainer = r10;
        if (r10 == null) goto L9;
        addView(r10);
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        r12.width = -1;
        r12.height = -2;
        r10.setAllowCollapse(false);
        return;
    }

    public void setTransitioning(boolean r10) {
        this.mIsTransitioning = r10;
        if (r10 == false) goto L5;
        int r11 = 393216;
    L6:
        setDescendantFocusability(r11);
        return;
    L5:
        r11 = 262144;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Drawable r12 = this.mBackground;
        if (r12 == null) goto L9;
        r12.setVisible(r11, false);
    L9:
        Drawable r13 = this.mStackedBackground;
        if (r13 == null) goto L12;
        r13.setVisible(r11, false);
    L12:
        Drawable r14 = this.mSplitBackground;
        if (r14 == null) goto L16;
        r14.setVisible(r11, false);
        return;
    L16:
        return;
    L5:
        r11 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r10, ActionMode.Callback r11) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r10, ActionMode.Callback r11, int r12) {
        if (r12 != 0) goto L4;
        return null;
    L4:
        return super.startActionModeForChild(r10, r11, r12);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable r10) {
        if (r10 != this.mBackground) goto L7;
        if (this.mIsSplit == true) goto L7;
    L16:
        return true;
    L7:
        if (r10 != this.mStackedBackground) goto L11;
        if (this.mIsStacked == true) goto L16;
    L11:
        if (r10 != this.mSplitBackground) goto L15;
        if (this.mIsSplit == true) goto L16;
    L15:
        if (super.verifyDrawable(r10) == true) goto L16;
        return false;
    }
}
