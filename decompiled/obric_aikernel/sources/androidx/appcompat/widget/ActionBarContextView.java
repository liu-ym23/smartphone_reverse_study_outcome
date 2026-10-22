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

    public ActionBarContextView(@NonNull Context r10) {
        this(r10, null);
    }

    public ActionBarContextView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, r11, R.styleable.ActionMode, r12, 0);
        ViewCompat.setBackground(this, r13.getDrawable(R.styleable.ActionMode_background));
        this.mTitleStyleRes = r13.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = r13.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = r13.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.mCloseItemLayout = r13.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        r13.recycle();
    }

    private void initTitle() {
        if (this.mTitleLayout != null) goto L10;
        LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
        LinearLayout r10 = (LinearLayout) getChildAt(getChildCount() - 1);
        this.mTitleLayout = r10;
        this.mTitleView = (TextView) r10.findViewById(R.id.action_bar_title);
        this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R.id.action_bar_subtitle);
        if (this.mTitleStyleRes == 0) goto L8;
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
    L8:
        if (this.mSubtitleStyleRes == 0) goto L10;
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
    L10:
        this.mTitleView.setText(this.mTitle);
        this.mSubtitleView.setText(this.mSubtitle);
        boolean r11 = !TextUtils.isEmpty(this.mTitle);
        boolean r12 = !TextUtils.isEmpty(this.mSubtitle);
        TextView r13 = this.mSubtitleView;
        int r14 = 0;
        if (r12 == false) goto L13;
        int r15 = 0;
    L14:
        r13.setVisibility(r15);
        LinearLayout r16 = this.mTitleLayout;
        if (r11 == true) goto L19;
        if (r12 == true) goto L19;
        r14 = 8;
    L19:
        r16.setVisibility(r14);
        if (this.mTitleLayout.getParent() != null) goto L23;
        addView(this.mTitleLayout);
        return;
    L23:
        return;
    L13:
        r15 = 8;
        goto L14
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int r10) {
        super.animateToVisibility(r10);
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
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return new ViewGroup.MarginLayoutParams(getContext(), r10);
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
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.hideOverflowMenu();
    }

    public void initForMode(final ActionMode r10) {
        View r11 = this.mClose;
        if (r11 != null) goto L7;
        View r12 = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
        this.mClose = r12;
    L5:
        addView(r12);
    L9:
        View r13 = this.mClose.findViewById(R.id.action_mode_close_button);
        this.mCloseButton = r13;
        r13.setOnClickListener(new AnonymousClass1(this, r10));
        MenuBuilder r14 = (MenuBuilder) r10.getMenu();
        ActionMenuPresenter r15 = this.mActionMenuPresenter;
        if (r15 == null) goto L12;
        r15.dismissPopupMenus();
    L12:
        ActionMenuPresenter r16 = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter = r16;
        r16.setReserveOverflow(true);
        ViewGroup.LayoutParams r17 = new ViewGroup.LayoutParams(-2, -1);
        r14.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        ActionMenuView r18 = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        this.mMenuView = r18;
        ViewCompat.setBackground(r18, null);
        addView(this.mMenuView, r17);
        return;
    L7:
        if (r11.getParent() != null) goto L9;
        r12 = this.mClose;
        goto L5
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.isOverflowMenuShowing();
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
        View r10 = this.mCloseButton;
        if (r10 == null) goto L6;
        r10.setOnClickListener(null);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 == null) goto L6;
        r10.hideOverflowMenu();
        this.mActionMenuPresenter.hideSubMenus();
        return;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent r10) {
        return super.onHoverEvent(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        boolean r15 = ViewUtils.isLayoutRtl(this);
        if (r15 == false) goto L5;
        int r16 = (r13 - r11) - getPaddingRight();
    L6:
        int r17 = getPaddingTop();
        int r18 = ((r14 - r12) - getPaddingTop()) - getPaddingBottom();
        View r19 = this.mClose;
        if (r19 != null) goto L9;
    L18:
        int r110 = r16;
        LinearLayout r20 = this.mTitleLayout;
        if (r20 != null) goto L21;
    L25:
        int r21 = r110;
        View r22 = this.mCustomView;
        if (r22 == null) goto L28;
        positionChild(r22, r21, r17, r18, r15);
    L28:
        if (r15 == false) goto L30;
        int r23 = getPaddingLeft();
    L31:
        ActionMenuView r24 = this.mMenuView;
        if (r24 == null) goto L35;
        positionChild(r24, r23, r17, r18, !r15);
        return;
    L35:
        return;
    L30:
        r23 = (r13 - r11) - getPaddingRight();
        goto L31
    L21:
        if (this.mCustomView != null) goto L25;
        if (r20.getVisibility() == 8) goto L25;
        r110 = r110 + positionChild(this.mTitleLayout, r110, r17, r18, r15);
        goto L25
    L9:
        if (r19.getVisibility() == 8) goto L18;
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        if (r15 == false) goto L13;
        int r25 = r111.rightMargin;
    L14:
        if (r15 == false) goto L16;
        int r112 = r111.leftMargin;
    L17:
        int r26 = AbsActionBarView.next(r16, r25, r15);
        r16 = AbsActionBarView.next(r26 + positionChild(this.mClose, r26, r17, r18, r15), r112, r15);
        goto L18
    L16:
        r112 = r111.rightMargin;
        goto L17
    L13:
        r25 = r111.leftMargin;
        goto L14
    L5:
        r16 = getPaddingLeft();
        goto L6
    }

    @Override // android.view.View
    protected void onMeasure(int r11, int r12) {
        int r10 = 1073741824;
        if (View.MeasureSpec.getMode(r11) != 1073741824) goto L65;
        if (View.MeasureSpec.getMode(r12) == 0) goto L63;
        int r13 = View.MeasureSpec.getSize(r11);
        int r14 = this.mContentHeight;
        if (r14 > 0) goto L10;
        r14 = View.MeasureSpec.getSize(r12);
    L10:
        int r15 = getPaddingTop() + getPaddingBottom();
        int r16 = (r13 - getPaddingLeft()) - getPaddingRight();
        int r17 = r14 - r15;
        int r18 = View.MeasureSpec.makeMeasureSpec(r17, Integer.MIN_VALUE);
        View r19 = this.mClose;
        int r20 = 0;
        if (r19 == null) goto L13;
        int r21 = measureChildView(r19, r16, r18, 0);
        ViewGroup.MarginLayoutParams r22 = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
        r16 = r21 - (r22.leftMargin + r22.rightMargin);
    L13:
        ActionMenuView r23 = this.mMenuView;
        if (r23 != null) goto L16;
    L18:
        LinearLayout r24 = this.mTitleLayout;
        if (r24 != null) goto L21;
    L36:
        View r25 = this.mCustomView;
        if (r25 == null) goto L52;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        int r27 = r26.width;
        if (r27 == (-2)) goto L41;
        int r28 = 1073741824;
    L42:
        if (r27 < 0) goto L44;
        r16 = Math.min(r27, r16);
    L44:
        int r29 = r26.height;
        if (r29 != (-2)) goto L48;
        r10 = Integer.MIN_VALUE;
    L48:
        if (r29 < 0) goto L50;
        r17 = Math.min(r29, r17);
    L50:
        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(r16, r28), View.MeasureSpec.makeMeasureSpec(r17, r10));
        goto L52
    L41:
        r28 = Integer.MIN_VALUE;
    L52:
        if (this.mContentHeight > 0) goto L60;
        int r30 = getChildCount();
        int r31 = 0;
    L54:
        if (r20 >= r30) goto L59;
        int r32 = getChildAt(r20).getMeasuredHeight() + r15;
        if (r32 <= r31) goto L58;
        r31 = r32;
    L58:
        r20 = r20 + 1;
        goto L54
    L59:
        setMeasuredDimension(r13, r31);
        return;
    L60:
        setMeasuredDimension(r13, r14);
        return;
    L21:
        if (this.mCustomView != null) goto L36;
        if (this.mTitleOptional == false) goto L35;
        this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), r18);
        int r33 = this.mTitleLayout.getMeasuredWidth();
        if (r33 > r16) goto L27;
        boolean r34 = true;
    L28:
        if (r34 == false) goto L30;
        r16 = r16 - r33;
    L30:
        LinearLayout r35 = this.mTitleLayout;
        if (r34 == false) goto L33;
        int r36 = 0;
    L34:
        r35.setVisibility(r36);
        goto L36
    L33:
        r36 = 8;
        goto L34
    L27:
        r34 = false;
        goto L28
    L35:
        r16 = measureChildView(r24, r16, r18, 0);
        goto L36
    L16:
        if (r23.getParent() != this) goto L18;
        r16 = measureChildView(this.mMenuView, r16, r18, 0);
        goto L18
    L63:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
    L65:
        throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r10) {
        return super.onTouchEvent(r10);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int r10) {
        this.mContentHeight = r10;
    }

    public void setCustomView(View r10) {
        View r11 = this.mCustomView;
        if (r11 == null) goto L5;
        removeView(r11);
    L5:
        this.mCustomView = r10;
        if (r10 == null) goto L10;
        LinearLayout r12 = this.mTitleLayout;
        if (r12 == null) goto L10;
        removeView(r12);
        this.mTitleLayout = null;
    L10:
        if (r10 == null) goto L12;
        addView(r10);
    L12:
        requestLayout();
    }

    public void setSubtitle(CharSequence r10) {
        this.mSubtitle = r10;
        initTitle();
    }

    public void setTitle(CharSequence r10) {
        this.mTitle = r10;
        initTitle();
        ViewCompat.setAccessibilityPaneTitle(this, r10);
    }

    public void setTitleOptional(boolean r10) {
        if (r10 == this.mTitleOptional) goto L5;
        requestLayout();
    L5:
        this.mTitleOptional = r10;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int r10) {
        super.setVisibility(r10);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r10, long r11) {
        return super.setupAnimatorToVisibility(r10, r11);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        ActionMenuPresenter r10 = this.mActionMenuPresenter;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.showOverflowMenu();
    }
}
