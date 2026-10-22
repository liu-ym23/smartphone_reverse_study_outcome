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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    public ActionBarContextView(@NonNull Context r5) {
        this(r5, null);
    }

    private void initTitle() {
        if (this.mTitleLayout != null) goto L10;
        LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
        LinearLayout r5 = (LinearLayout) getChildAt(getChildCount() - 1);
        this.mTitleLayout = r5;
        this.mTitleView = (TextView) r5.findViewById(R.id.action_bar_title);
        this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
        if (this.mTitleStyleRes == 0) goto L8;
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
    L8:
        if (this.mSubtitleStyleRes == 0) goto L10;
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
    L10:
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean r10 = TextUtils.isEmpty(this.mTitle);
        boolean r11 = TextUtils.isEmpty(this.mSubtitle);
        TextView r12 = this.mSubtitleView;
        int r13 = 8;
        if (r11 == true) goto L13;
        int r14 = 0;
    L14:
        r12.setVisibility(r14);
        LinearLayout r15 = this.mTitleLayout;
        if (r10 == false) goto L17;
        if (r11 == false) goto L17;
    L18:
        r15.setVisibility(r13);
        if (this.mTitleLayout.getParent() != null) goto L22;
        addView(this.mTitleLayout);
        return;
    L22:
        return;
    L17:
        r13 = 0;
        goto L18
    L13:
        r14 = 8;
        goto L14
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int r5) {
        super.animateToVisibility(r5);
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
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return new ViewGroup.MarginLayoutParams(getContext(), r5);
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
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.hideOverflowMenu();
    }

    public void initForMode(final ActionMode r5) {
        View r10 = this.mClose;
        if (r10 != null) goto L6;
        View r11 = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
        this.mClose = r11;
        addView(r11);
    L8:
        View r12 = this.mClose.findViewById(R.id.action_mode_close_button);
        this.mCloseButton = r12;
        r12.setOnClickListener(new AnonymousClass1(this, r5));
        MenuBuilder r13 = (MenuBuilder) r5.getMenu();
        ActionMenuPresenter r14 = this.mActionMenuPresenter;
        if (r14 == null) goto L11;
        r14.dismissPopupMenus();
    L11:
        ActionMenuPresenter r15 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = r15;
        r15.setReserveOverflow(true);
        ViewGroup.LayoutParams r16 = new ViewGroup.LayoutParams(-2, -1);
        r13.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView r17 = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = r17;
        ViewCompat.setBackground(r17, null);
        addView(this.mMenuView, r16);
        return;
    L6:
        if (r10.getParent() != null) goto L8;
        addView(this.mClose);
        goto L8
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.isOverflowMenuShowing();
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
        View r5 = this.mCloseButton;
        if (r5 == null) goto L6;
        r5.setOnClickListener(null);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 == null) goto L6;
        r5.hideOverflowMenu();
        this.mActionMenuPresenter.hideSubMenus();
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent r5) {
        return super.onHoverEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        boolean r15 = ViewUtils.isLayoutRtl(this);
        if (r15 == false) goto L5;
        int r5 = (r13 - r11) - getPaddingRight();
    L6:
        int r16 = getPaddingTop();
        int r17 = ((r14 - r12) - getPaddingTop()) - getPaddingBottom();
        View r18 = this.mClose;
        if (r18 != null) goto L9;
    L18:
        int r19 = r5;
        LinearLayout r20 = this.mTitleLayout;
        if (r20 != null) goto L21;
    L25:
        int r21 = r19;
        View r22 = this.mCustomView;
        if (r22 == null) goto L28;
        positionChild(r22, r21, r16, r17, r15);
    L28:
        if (r15 == false) goto L30;
        int r23 = getPaddingLeft();
    L31:
        ActionMenuView r24 = this.mMenuView;
        if (r24 == null) goto L35;
        positionChild(r24, r23, r16, r17, !r15);
        return;
    L35:
        return;
    L30:
        r23 = (r13 - r11) - getPaddingRight();
        goto L31
    L21:
        if (this.mCustomView != null) goto L25;
        if (r20.getVisibility() == 8) goto L25;
        r19 = r19 + positionChild(this.mTitleLayout, r19, r16, r17, r15);
        goto L25
    L9:
        if (r18.getVisibility() == 8) goto L18;
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        if (r15 == false) goto L13;
        int r25 = r110.rightMargin;
    L14:
        if (r15 == false) goto L16;
        int r111 = r110.leftMargin;
    L17:
        int r26 = AbsActionBarView.next(r5, r25, r15);
        r5 = AbsActionBarView.next(r26 + positionChild(this.mClose, r26, r16, r17, r15), r111, r15);
        goto L18
    L16:
        r111 = r110.rightMargin;
        goto L17
    L13:
        r25 = r110.leftMargin;
        goto L14
    L5:
        r5 = getPaddingLeft();
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r11, int r12) {
        int r5 = View.MeasureSpec.getMode(r11);
        int r10 = BasicMeasure.EXACTLY;
        if (r5 != 1073741824) goto L65;
        if (View.MeasureSpec.getMode(r12) == 0) goto L63;
        int r13 = View.MeasureSpec.getSize(r11);
        int r14 = this.mContentHeight;
        if (r14 > 0) goto L10;
        r14 = View.MeasureSpec.getSize(r12);
    L10:
        int r15 = getPaddingBottom() + getPaddingTop();
        int r16 = (r13 - getPaddingLeft()) - getPaddingRight();
        int r17 = r14 - r15;
        int r18 = View.MeasureSpec.makeMeasureSpec(r17, Integer.MIN_VALUE);
        View r19 = this.mClose;
        int r20 = 0;
        if (r19 == null) goto L13;
        int r110 = measureChildView(r19, r16, r18, 0);
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        r16 = r110 - (r21.leftMargin + r21.rightMargin);
    L13:
        ActionMenuView r22 = this.mMenuView;
        if (r22 != null) goto L16;
    L18:
        LinearLayout r23 = this.mTitleLayout;
        if (r23 != null) goto L21;
    L36:
        View r24 = this.mCustomView;
        if (r24 == null) goto L52;
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        int r26 = r25.width;
        if (r26 == (-2)) goto L41;
        int r27 = 1073741824;
    L42:
        if (r26 < 0) goto L44;
        r16 = Math.min(r26, r16);
    L44:
        int r28 = r25.height;
        if (r28 != (-2)) goto L48;
        r10 = Integer.MIN_VALUE;
    L48:
        if (r28 < 0) goto L50;
        r17 = Math.min(r28, r17);
    L50:
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(r16, r27), View.MeasureSpec.makeMeasureSpec(r17, r10));
        goto L52
    L41:
        r27 = Integer.MIN_VALUE;
    L52:
        if (this.mContentHeight > 0) goto L60;
        int r111 = getChildCount();
        int r29 = 0;
    L54:
        if (r20 >= r111) goto L59;
        int r30 = getChildAt(r20).getMeasuredHeight() + r15;
        if (r30 <= r29) goto L58;
        r29 = r30;
    L58:
        r20 = r20 + 1;
        goto L54
    L59:
        setMeasuredDimension(r13, r29);
        return;
    L60:
        setMeasuredDimension(r13, r14);
        return;
    L21:
        if (this.mCustomView != null) goto L36;
        if (this.mTitleOptional == false) goto L35;
        this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r18);
        int r31 = this.mTitleLayout.getMeasuredWidth();
        if (r31 > r16) goto L27;
        boolean r32 = true;
    L28:
        if (r32 == false) goto L30;
        r16 = r16 - r31;
    L30:
        LinearLayout r33 = this.mTitleLayout;
        if (r32 == false) goto L33;
        int r34 = 0;
    L34:
        r33.setVisibility(r34);
        goto L36
    L33:
        r34 = 8;
        goto L34
    L27:
        r32 = false;
        goto L28
    L35:
        r16 = measureChildView(r23, r16, r18, 0);
        goto L36
    L16:
        if (r22.getParent() != this) goto L18;
        r16 = measureChildView(this.mMenuView, r16, r18, 0);
        goto L18
    L63:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
    L65:
        throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r5) {
        return super.onTouchEvent(r5);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int r5) {
        this.mContentHeight = r5;
    }

    public void setCustomView(View r5) {
        View r10 = this.mCustomView;
        if (r10 == null) goto L5;
        removeView(r10);
    L5:
        this.mCustomView = r5;
        if (r5 == null) goto L10;
        LinearLayout r11 = this.mTitleLayout;
        if (r11 == null) goto L10;
        removeView(r11);
        this.mTitleLayout = null;
    L10:
        if (r5 == null) goto L12;
        addView(r5);
    L12:
        requestLayout();
    }

    public void setSubtitle(CharSequence r5) {
        this.mSubtitle = r5;
        initTitle();
    }

    public void setTitle(CharSequence r5) {
        this.mTitle = r5;
        initTitle();
        ViewCompat.setAccessibilityPaneTitle(this, r5);
    }

    public void setTitleOptional(boolean r5) {
        if (r5 == this.mTitleOptional) goto L5;
        requestLayout();
    L5:
        this.mTitleOptional = r5;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r5) {
        super.setVisibility(r5);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r5, long r10) {
        return super.setupAnimatorToVisibility(r5, r10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        ActionMenuPresenter r5 = this.mActionMenuPresenter;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.showOverflowMenu();
    }

    public ActionBarContextView(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        TintTypedArray r12 = TintTypedArray.obtainStyledAttributes(r5, r10, R.styleable.ActionMode, r11, 0);
        ViewCompat.setBackground(this, r12.getDrawable(R.styleable.ActionMode_background));
        this.mTitleStyleRes = r12.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = r12.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = r12.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = r12.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        r12.recycle();
    }
}
