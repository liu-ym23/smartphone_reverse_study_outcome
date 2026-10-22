package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {
    private View mClose;
    private View mCloseButton;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), null);
    }

    public ActionBarContextView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.attr.actionModeStyle, "attr", "actionModeStyle"));
    }

    public ActionBarContextView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        super(r6, r7, r5);
        TintTypedArray r8 = TintTypedArray.obtainStyledAttributes(r6, r7, R.styleable.ActionMode, r5, 0);
        ViewCompat.setBackground(this, r8.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ActionMode_background, "styleable", "ActionMode_background")));
        this.mTitleStyleRes = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ActionMode_titleTextStyle, "styleable", "ActionMode_titleTextStyle"), 0);
        this.mSubtitleStyleRes = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ActionMode_subtitleTextStyle, "styleable", "ActionMode_subtitleTextStyle"), 0);
        this.mContentHeight = r8.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.ActionMode_height, "styleable", "ActionMode_height"), 0);
        this.mCloseItemLayout = r8.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ActionMode_closeItemLayout, "styleable", "ActionMode_closeItemLayout"), ZeusTransformUtils.mapRes(R.layout.abc_action_mode_close_item_material, "layout", "abc_action_mode_close_item_material"));
        r8.recycle();
    }

    private void initTitle() {
        if (this.mTitleLayout != null) goto L10;
        ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), ZeusTransformUtils.mapRes(R.layout.abc_action_bar_title_item, "layout", "abc_action_bar_title_item"), this, "com.obric.memorydata.plugin");
        LinearLayout r0 = (LinearLayout) ZeusTransformUtils.preCheckCast(getChildAt(getChildCount() - 1), LinearLayout.class, "com.obric.memorydata.plugin");
        this.mTitleLayout = r0;
        this.mTitleView = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_title, OaidModel.KEY_ID, "action_bar_title")), TextView.class, "com.obric.memorydata.plugin");
        this.mSubtitleView = (TextView) ZeusTransformUtils.preCheckCast(this.mTitleLayout.findViewById(ZeusTransformUtils.mapRes(R.id.action_bar_subtitle, OaidModel.KEY_ID, "action_bar_subtitle")), TextView.class, "com.obric.memorydata.plugin");
        if (this.mTitleStyleRes == 0) goto L8;
        this.mTitleView.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mTitleStyleRes);
    L8:
        if (this.mSubtitleStyleRes == 0) goto L10;
        this.mSubtitleView.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), this.mSubtitleStyleRes);
    L10:
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean r1 = !TextUtils.isEmpty(this.mTitle);
        boolean r2 = !TextUtils.isEmpty(this.mSubtitle);
        TextView r3 = this.mSubtitleView;
        int r4 = 0;
        if (r2 == false) goto L13;
        int r5 = 0;
    L14:
        r3.setVisibility(r5);
        LinearLayout r6 = this.mTitleLayout;
        if (r1 == true) goto L19;
        if (r2 == true) goto L19;
        r4 = 8;
    L19:
        r6.setVisibility(r4);
        if (this.mTitleLayout.getParent() != null) goto L23;
        addView(this.mTitleLayout);
        return;
    L23:
        return;
    L13:
        r5 = 8;
        goto L14
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int r1) {
        super.animateToVisibility(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        if (this.mClose != null) goto L6;
        killMode();
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
        return new ViewGroup.MarginLayoutParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) goto L5;
        return false;
    L5:
        return this.mActionMenuPresenter.hideOverflowMenu();
    }

    public void initForMode(final ActionMode r6) {
        View r0 = this.mClose;
        if (r0 != null) goto L7;
        View r1 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), this.mCloseItemLayout, this, false, "com.obric.memorydata.plugin");
        this.mClose = r1;
    L5:
        addView(r1);
    L9:
        View r2 = this.mClose.findViewById(ZeusTransformUtils.mapRes(R.id.action_mode_close_button, OaidModel.KEY_ID, "action_mode_close_button"));
        this.mCloseButton = r2;
        r2.setOnClickListener(new AnonymousClass1(this, r6));
        MenuBuilder r7 = (MenuBuilder) ZeusTransformUtils.preCheckCast(r6.getMenu(), MenuBuilder.class, "com.obric.memorydata.plugin");
        if (this.mActionMenuPresenter == null) goto L12;
        this.mActionMenuPresenter.dismissPopupMenus();
    L12:
        this.mActionMenuPresenter = new ActionMenuPresenter((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.mActionMenuPresenter.setReserveOverflow(true);
        ViewGroup.LayoutParams r3 = new ViewGroup.LayoutParams(-2, -1);
        r7.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        this.mMenuView = (ActionMenuView) ZeusTransformUtils.preCheckCast(this.mActionMenuPresenter.getMenuView(this), ActionMenuView.class, "com.obric.memorydata.plugin");
        ViewCompat.setBackground(this.mMenuView, null);
        addView(this.mMenuView, r3);
        return;
    L7:
        if (r0.getParent() != null) goto L9;
        r1 = this.mClose;
        goto L5
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) goto L5;
        return false;
    L5:
        return this.mActionMenuPresenter.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View r1 = this.mCloseButton;
        if (r1 == null) goto L6;
        r1.setOnClickListener(null);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter == null) goto L6;
        this.mActionMenuPresenter.hideOverflowMenu();
        this.mActionMenuPresenter.hideSubMenus();
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent r1) {
        return super.onHoverEvent(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        boolean r15 = ViewUtils.isLayoutRtl(this);
        if (r15 == false) goto L5;
        int r0 = (r13 - r11) - getPaddingRight();
    L6:
        int r6 = getPaddingTop();
        int r16 = ((r14 - r12) - getPaddingTop()) - getPaddingBottom();
        View r17 = this.mClose;
        if (r17 != null) goto L9;
    L18:
        int r18 = r0;
        LinearLayout r1 = this.mTitleLayout;
        if (r1 != null) goto L21;
    L25:
        int r2 = r18;
        View r3 = this.mCustomView;
        if (r3 == null) goto L28;
        positionChild(r3, r2, r6, r16, r15);
    L28:
        if (r15 == false) goto L30;
        int r4 = getPaddingLeft();
    L32:
        if (this.mMenuView == null) goto L35;
        positionChild(this.mMenuView, r4, r6, r16, !r15);
        return;
    L35:
        return;
    L30:
        r4 = (r13 - r11) - getPaddingRight();
        goto L32
    L21:
        if (this.mCustomView != null) goto L25;
        if (r1.getVisibility() == 8) goto L25;
        r18 = r18 + positionChild(this.mTitleLayout, r18, r6, r16, r15);
        goto L25
    L9:
        if (r17.getVisibility() == 8) goto L18;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.mClose.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        if (r15 == false) goto L13;
        int r5 = r19.rightMargin;
    L14:
        if (r15 == false) goto L16;
        int r110 = r19.leftMargin;
    L17:
        int r8 = next(r0, r5, r15);
        r0 = next(r8 + positionChild(this.mClose, r8, r6, r16, r15), r110, r15);
        goto L18
    L16:
        r110 = r19.rightMargin;
        goto L17
    L13:
        r5 = r19.leftMargin;
        goto L14
    L5:
        r0 = getPaddingLeft();
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r11, int r12) {
        int r1 = 1073741824;
        if (View.MeasureSpec.getMode(r11) != 1073741824) goto L67;
        if (View.MeasureSpec.getMode(r12) == 0) goto L65;
        int r13 = View.MeasureSpec.getSize(r11);
        if (this.mContentHeight <= 0) goto L9;
        int r14 = this.mContentHeight;
    L10:
        int r0 = getPaddingTop() + getPaddingBottom();
        int r2 = (r13 - getPaddingLeft()) - getPaddingRight();
        int r3 = r14 - r0;
        int r5 = View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
        View r6 = this.mClose;
        int r7 = 0;
        if (r6 == null) goto L14;
        int r4 = measureChildView(r6, r2, r5, 0);
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(this.mClose.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r2 = r4 - (r8.leftMargin + r8.rightMargin);
    L14:
        if (this.mMenuView != null) goto L16;
    L18:
        LinearLayout r9 = this.mTitleLayout;
        if (r9 != null) goto L21;
    L36:
        View r10 = this.mCustomView;
        if (r10 == null) goto L54;
        ViewGroup.LayoutParams r15 = r10.getLayoutParams();
        if (r15.width == (-2)) goto L41;
        int r16 = 1073741824;
    L43:
        if (r15.width < 0) goto L46;
        r2 = Math.min(r15.width, r2);
    L46:
        if (r15.height != (-2)) goto L50;
        r1 = Integer.MIN_VALUE;
    L50:
        if (r15.height < 0) goto L52;
        r3 = Math.min(r15.height, r3);
    L52:
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(r2, r16), View.MeasureSpec.makeMeasureSpec(r3, r1));
        goto L54
    L41:
        r16 = Integer.MIN_VALUE;
    L54:
        if (this.mContentHeight > 0) goto L62;
        int r17 = getChildCount();
        int r18 = 0;
    L56:
        if (r7 >= r17) goto L61;
        int r19 = getChildAt(r7).getMeasuredHeight() + r0;
        if (r19 <= r18) goto L60;
        r18 = r19;
    L60:
        r7 = r7 + 1;
        goto L56
    L61:
        setMeasuredDimension(r13, r18);
        return;
    L62:
        setMeasuredDimension(r13, r14);
        return;
    L21:
        if (this.mCustomView != null) goto L36;
        if (this.mTitleOptional == false) goto L35;
        this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r5);
        int r20 = this.mTitleLayout.getMeasuredWidth();
        if (r20 > r2) goto L27;
        boolean r21 = true;
    L28:
        if (r21 == false) goto L30;
        r2 = r2 - r20;
    L30:
        LinearLayout r22 = this.mTitleLayout;
        if (r21 == false) goto L33;
        int r23 = 0;
    L34:
        r22.setVisibility(r23);
        goto L36
    L33:
        r23 = 8;
        goto L34
    L27:
        r21 = false;
        goto L28
    L35:
        r2 = measureChildView(r9, r2, r5, 0);
        goto L36
    L16:
        if (this.mMenuView.getParent() != this) goto L18;
        r2 = measureChildView(this.mMenuView, r2, r5, 0);
        goto L18
    L9:
        r14 = View.MeasureSpec.getSize(r12);
        goto L10
    L65:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    L67:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int r1) {
        this.mContentHeight = r1;
    }

    public void setCustomView(View r2) {
        View r0 = this.mCustomView;
        if (r0 == null) goto L5;
        removeView(r0);
    L5:
        this.mCustomView = r2;
        if (r2 == null) goto L10;
        LinearLayout r1 = this.mTitleLayout;
        if (r1 == null) goto L10;
        removeView(r1);
        this.mTitleLayout = null;
    L10:
        if (r2 == null) goto L12;
        addView(r2);
    L12:
        requestLayout();
    }

    public void setSubtitle(CharSequence r3) {
        this.mSubtitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        initTitle();
    }

    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mTitle = r4;
        initTitle();
        ViewCompat.setAccessibilityPaneTitle(this, r4);
    }

    public void setTitleOptional(boolean r2) {
        if (r2 == this.mTitleOptional) goto L5;
        requestLayout();
    L5:
        this.mTitleOptional = r2;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r1) {
        super.setVisibility(r1);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r1, long r2) {
        return super.setupAnimatorToVisibility(r1, r2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) goto L5;
        return false;
    L5:
        return this.mActionMenuPresenter.showOverflowMenu();
    }
}
