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
import androidx.core.view.ViewCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
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

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static void invalidateOutline(ActionBarContainer r0) {
            r0.invalidateOutline();
        }
    }

    public ActionBarContainer(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ActionBarContainer(Context r5, AttributeSet r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r7, r8);
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray r9 = r7.obtainStyledAttributes(r8, R.styleable.ActionBar);
        this.mBackground = r9.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ActionBar_background, "styleable", "ActionBar_background"));
        this.mStackedBackground = r9.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ActionBar_backgroundStacked, "styleable", "ActionBar_backgroundStacked"));
        this.mHeight = r9.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.styleable.ActionBar_height, "styleable", "ActionBar_height"), -1);
        boolean r2 = true;
        if (getId() != ZeusTransformUtils.mapRes(R.id.split_action_bar, OaidModel.KEY_ID, "split_action_bar")) goto L5;
        this.mIsSplit = true;
        this.mSplitBackground = r9.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ActionBar_backgroundSplit, "styleable", "ActionBar_backgroundSplit"));
    L5:
        r9.recycle();
        if (this.mIsSplit == false) goto L11;
        if (this.mSplitBackground == null) goto L16;
    L15:
        r2 = false;
    L16:
        setWillNotDraw(r2);
        return;
    L11:
        if (this.mBackground != null) goto L15;
        if (this.mStackedBackground != null) goto L15;
        goto L15
    }

    private int getMeasuredHeightWithMargins(View r3) {
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        return (r3.getMeasuredHeight() + r2.topMargin) + r2.bottomMargin;
    }

    private boolean isCollapsed(View r2) {
        if (r2 != null) goto L4;
    L9:
        return true;
    L4:
        if (r2.getVisibility() == 8) goto L9;
        if (r2.getMeasuredHeight() == 0) goto L9;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r0 = this.mBackground;
        if (r0 != null) goto L5;
    L7:
        Drawable r1 = this.mStackedBackground;
        if (r1 != null) goto L10;
    L12:
        Drawable r2 = this.mSplitBackground;
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.isStateful() == false) goto L19;
        this.mSplitBackground.setState(getDrawableState());
        return;
    L19:
        return;
    L10:
        if (r1.isStateful() == false) goto L12;
        this.mStackedBackground.setState(getDrawableState());
        goto L12
    L5:
        if (r0.isStateful() == false) goto L7;
        this.mBackground.setState(getDrawableState());
        goto L7
    }

    public View getTabContainer() {
        return this.mTabContainer;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable r0 = this.mBackground;
        if (r0 == null) goto L5;
        r0.jumpToCurrentState();
    L5:
        Drawable r1 = this.mStackedBackground;
        if (r1 == null) goto L8;
        r1.jumpToCurrentState();
    L8:
        Drawable r2 = this.mSplitBackground;
        if (r2 == null) goto L12;
        r2.jumpToCurrentState();
        return;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mActionBarView = findViewById(ZeusTransformUtils.mapRes(R.id.action_bar, OaidModel.KEY_ID, "action_bar"));
        this.mContextView = findViewById(ZeusTransformUtils.mapRes(R.id.action_context_bar, OaidModel.KEY_ID, "action_context_bar"));
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r1) {
        super.onHoverEvent(r1);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.mIsTransitioning == false) goto L5;
    L8:
        return true;
    L5:
        if (super.onInterceptTouchEvent(r2) == true) goto L8;
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r6, int r7, int r8, int r9, int r10) {
        super.onLayout(r6, r7, r8, r9, r10);
        View r11 = this.mTabContainer;
        boolean r12 = true;
        boolean r0 = false;
        if (r11 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r11 == null) goto L13;
        if (r11.getVisibility() == 8) goto L13;
        int r13 = getMeasuredHeight();
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) ZeusTransformUtils.preCheckCast(r11.getLayoutParams(), FrameLayout.LayoutParams.class, "com.obric.memorydata.plugin");
        r11.layout(r7, (r13 - r11.getMeasuredHeight()) - r2.bottomMargin, r9, r13 - r2.bottomMargin);
    L13:
        if (this.mIsSplit == false) goto L19;
        Drawable r14 = this.mSplitBackground;
        if (r14 == null) goto L17;
        r14.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L36:
        if (r12 == false) goto L39;
        invalidate();
        return;
    L39:
        return;
    L17:
        r12 = r0;
        goto L36
    L19:
        if (this.mBackground != null) goto L21;
    L31:
        this.mIsStacked = r1;
        if (r1 == false) goto L17;
        Drawable r15 = this.mStackedBackground;
        if (r15 == null) goto L17;
        r15.setBounds(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom());
        goto L36
    L21:
        if (this.mActionBarView.getVisibility() != 0) goto L24;
        Drawable r16 = this.mBackground;
        int r17 = this.mActionBarView.getLeft();
        int r18 = this.mActionBarView.getTop();
        int r3 = this.mActionBarView.getRight();
        View r4 = this.mActionBarView;
    L23:
        r16.setBounds(r17, r18, r3, r4.getBottom());
    L30:
        r0 = true;
        goto L31
    L24:
        View r19 = this.mContextView;
        if (r19 != null) goto L27;
    L29:
        this.mBackground.setBounds(0, 0, 0, 0);
        goto L30
    L27:
        if (r19.getVisibility() != 0) goto L29;
        r16 = this.mBackground;
        r17 = this.mContextView.getLeft();
        r18 = this.mContextView.getTop();
        r3 = this.mContextView.getRight();
        r4 = this.mContextView;
        goto L23
    L5:
        if (r11.getVisibility() == 8) goto L7;
        r1 = true;
        goto L8
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r4, int r5) {
        if (this.mActionBarView == null) goto L5;
    L9:
        super.onMeasure(r4, r5);
        if (this.mActionBarView != null) goto L12;
        return;
    L12:
        int r6 = View.MeasureSpec.getMode(r5);
        View r0 = this.mTabContainer;
        if (r0 != null) goto L15;
        return;
    L15:
        if (r0.getVisibility() != 8) goto L17;
        return;
    L17:
        if (r6 != 1073741824) goto L19;
        return;
    L19:
        if (isCollapsed(this.mActionBarView) == true) goto L23;
        View r1 = this.mActionBarView;
    L21:
        int r2 = getMeasuredHeightWithMargins(r1);
    L26:
        if (r6 != Integer.MIN_VALUE) goto L28;
        int r7 = View.MeasureSpec.getSize(r5);
    L29:
        setMeasuredDimension(getMeasuredWidth(), Math.min(r2 + getMeasuredHeightWithMargins(this.mTabContainer), r7));
        return;
    L28:
        r7 = Integer.MAX_VALUE;
        goto L29
    L23:
        if (isCollapsed(this.mContextView) == true) goto L25;
        r1 = this.mContextView;
        goto L21
    L25:
        r2 = 0;
        goto L26
    L5:
        if (View.MeasureSpec.getMode(r5) != Integer.MIN_VALUE) goto L9;
        int r3 = this.mHeight;
        if (r3 < 0) goto L9;
        r5 = View.MeasureSpec.makeMeasureSpec(Math.min(r3, View.MeasureSpec.getSize(r5)), Integer.MIN_VALUE);
        goto L9
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        super.onTouchEvent(r1);
        return true;
    }

    public void setPrimaryBackground(Drawable r5) {
        Drawable r0 = this.mBackground;
        if (r0 == null) goto L5;
        r0.setCallback(null);
        unscheduleDrawable(this.mBackground);
    L5:
        this.mBackground = r5;
        if (r5 == null) goto L10;
        r5.setCallback(this);
        View r6 = this.mActionBarView;
        if (r6 == null) goto L10;
        this.mBackground.setBounds(r6.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
    L10:
        boolean r1 = true;
        if (this.mIsSplit == false) goto L16;
        if (this.mSplitBackground == null) goto L21;
    L20:
        r1 = false;
    L21:
        setWillNotDraw(r1);
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

    public void setSplitBackground(Drawable r4) {
        Drawable r0 = this.mSplitBackground;
        if (r0 == null) goto L5;
        r0.setCallback(null);
        unscheduleDrawable(this.mSplitBackground);
    L5:
        this.mSplitBackground = r4;
        boolean r1 = false;
        if (r4 == null) goto L13;
        r4.setCallback(this);
        if (this.mIsSplit == false) goto L13;
        Drawable r5 = this.mSplitBackground;
        if (r5 == null) goto L13;
        r5.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
    L13:
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground != null) goto L22;
    L16:
        r1 = true;
    L22:
        setWillNotDraw(r1);
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

    public void setStackedBackground(Drawable r5) {
        Drawable r0 = this.mStackedBackground;
        if (r0 == null) goto L5;
        r0.setCallback(null);
        unscheduleDrawable(this.mStackedBackground);
    L5:
        this.mStackedBackground = r5;
        if (r5 == null) goto L12;
        r5.setCallback(this);
        if (this.mIsStacked == false) goto L12;
        Drawable r6 = this.mStackedBackground;
        if (r6 == null) goto L12;
        r6.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
    L12:
        boolean r1 = true;
        if (this.mIsSplit == false) goto L18;
        if (this.mSplitBackground == null) goto L23;
    L22:
        r1 = false;
    L23:
        setWillNotDraw(r1);
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

    public void setTabContainer(ScrollingTabContainerView r2) {
        View r0 = this.mTabContainer;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        this.mTabContainer = r2;
        if (r2 == null) goto L9;
        addView(r2);
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        r1.width = -1;
        r1.height = -2;
        r2.setAllowCollapse(false);
        return;
    }

    public void setTransitioning(boolean r1) {
        this.mIsTransitioning = r1;
        if (r1 == false) goto L5;
        int r2 = 393216;
    L6:
        setDescendantFocusability(r2);
        return;
    L5:
        r2 = 262144;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r3) {
        super.setVisibility(r3);
        if (r3 != 0) goto L5;
        boolean r4 = true;
    L6:
        Drawable r1 = this.mBackground;
        if (r1 == null) goto L9;
        r1.setVisible(r4, false);
    L9:
        Drawable r2 = this.mStackedBackground;
        if (r2 == null) goto L12;
        r2.setVisible(r4, false);
    L12:
        Drawable r5 = this.mSplitBackground;
        if (r5 == null) goto L16;
        r5.setVisible(r4, false);
        return;
    L16:
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r1, ActionMode.Callback r2) {
        ActionMode.Callback r0 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r2, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View r3, ActionMode.Callback r4, int r5) {
        ActionMode.Callback r6 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r4, ActionMode.Callback.class, "com.obric.memorydata.plugin");
        if (r5 != 0) goto L5;
        return null;
    L5:
        return super.startActionModeForChild(r3, r6, r5);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r2) {
        if (r2 != this.mBackground) goto L7;
        if (this.mIsSplit == true) goto L7;
    L16:
        return true;
    L7:
        if (r2 != this.mStackedBackground) goto L11;
        if (this.mIsStacked == true) goto L16;
    L11:
        if (r2 != this.mSplitBackground) goto L15;
        if (this.mIsSplit == true) goto L16;
    L15:
        if (super.verifyDrawable(r2) == true) goto L16;
        return false;
    }
}
