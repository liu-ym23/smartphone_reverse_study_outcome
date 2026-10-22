package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.card.MaterialCardView;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {
    private static final int AFFECTS_LOGO_MASK = 3;
    private static final long DEFAULT_FADE_DURATION_MS = 200;
    private static final String TAG = "ToolbarWidgetWrapper";
    private ActionMenuPresenter mActionMenuPresenter;
    private View mCustomView;
    private int mDefaultNavigationContentDescription;
    private Drawable mDefaultNavigationIcon;
    private int mDisplayOpts;
    private CharSequence mHomeDescription;
    private Drawable mIcon;
    private Drawable mLogo;
    boolean mMenuPrepared;
    private Drawable mNavIcon;
    private int mNavigationMode;
    private Spinner mSpinner;
    private CharSequence mSubtitle;
    private View mTabView;
    CharSequence mTitle;
    private boolean mTitleSet;
    Toolbar mToolbar;
    Window.Callback mWindowCallback;

    public ToolbarWidgetWrapper(Toolbar r5, boolean r6) {
        this(r5, r6, ZeusTransformUtils.mapRes(R.string.abc_action_bar_up_description, TypedValues.Custom.S_STRING, "abc_action_bar_up_description"), ZeusTransformUtils.mapRes(R.drawable.abc_ic_ab_back_material, "drawable", "abc_ic_ab_back_material"));
    }

    public ToolbarWidgetWrapper(Toolbar r7, boolean r8, int r9, int r10) {
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = r7;
        this.mTitle = r7.getTitle();
        this.mSubtitle = r7.getSubtitle();
        if (this.mTitle == null) goto L5;
        boolean r0 = true;
    L6:
        this.mTitleSet = r0;
        this.mNavIcon = r7.getNavigationIcon();
        TintTypedArray r11 = TintTypedArray.obtainStyledAttributes((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, R.styleable.ActionBar, ZeusTransformUtils.mapRes(R.attr.actionBarStyle, "attr", "actionBarStyle"), 0);
        this.mDefaultNavigationIcon = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ActionBar_homeAsUpIndicator, "styleable", "ActionBar_homeAsUpIndicator"));
        if (r8 == false) goto L44;
        CharSequence r12 = r11.getText(ZeusTransformUtils.mapRes(R.styleable.ActionBar_title, "styleable", "ActionBar_title"));
        if (TextUtils.isEmpty(r12) == true) goto L11;
        setTitle(r12);
    L11:
        CharSequence r13 = r11.getText(ZeusTransformUtils.mapRes(R.styleable.ActionBar_subtitle, "styleable", "ActionBar_subtitle"));
        if (TextUtils.isEmpty(r13) == true) goto L14;
        setSubtitle(r13);
    L14:
        Drawable r14 = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ActionBar_logo, "styleable", "ActionBar_logo"));
        if (r14 == null) goto L17;
        setLogo(r14);
    L17:
        Drawable r15 = r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.ActionBar_icon, "styleable", "ActionBar_icon"));
        if (r15 == null) goto L21;
        setIcon(r15);
    L21:
        if (this.mNavIcon != null) goto L25;
        Drawable r16 = this.mDefaultNavigationIcon;
        if (r16 == null) goto L25;
        setNavigationIcon(r16);
    L25:
        setDisplayOptions(r11.getInt(ZeusTransformUtils.mapRes(R.styleable.ActionBar_displayOptions, "styleable", "ActionBar_displayOptions"), 0));
        int r17 = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ActionBar_customNavigationLayout, "styleable", "ActionBar_customNavigationLayout"), 0);
        if (r17 == 0) goto L28;
        setCustomView(ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mToolbar.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")), r17, this.mToolbar, false, "com.obric.memorydata.plugin"));
        setDisplayOptions(this.mDisplayOpts | 16);
    L28:
        int r18 = r11.getLayoutDimension(ZeusTransformUtils.mapRes(R.styleable.ActionBar_height, "styleable", "ActionBar_height"), 0);
        if (r18 <= 0) goto L31;
        ViewGroup.LayoutParams r1 = this.mToolbar.getLayoutParams();
        r1.height = r18;
        this.mToolbar.setLayoutParams(r1);
    L31:
        int r19 = r11.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ActionBar_contentInsetStart, "styleable", "ActionBar_contentInsetStart"), -1);
        int r2 = r11.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.styleable.ActionBar_contentInsetEnd, "styleable", "ActionBar_contentInsetEnd"), -1);
        if (r19 >= 0) goto L34;
        if (r2 >= 0) goto L34;
    L35:
        int r20 = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ActionBar_titleTextStyle, "styleable", "ActionBar_titleTextStyle"), 0);
        if (r20 == 0) goto L38;
        Toolbar r3 = this.mToolbar;
        r3.setTitleTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r20);
    L38:
        int r21 = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ActionBar_subtitleTextStyle, "styleable", "ActionBar_subtitleTextStyle"), 0);
        if (r21 == 0) goto L41;
        Toolbar r4 = this.mToolbar;
        r4.setSubtitleTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r21);
    L41:
        int r22 = r11.getResourceId(ZeusTransformUtils.mapRes(R.styleable.ActionBar_popupTheme, "styleable", "ActionBar_popupTheme"), 0);
        if (r22 == 0) goto L45;
        this.mToolbar.setPopupTheme(r22);
    L45:
        r11.recycle();
        setDefaultNavigationContentDescription(r9);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new AnonymousClass1(this));
        return;
    L34:
        this.mToolbar.setContentInsetsRelative(Math.max(r19, 0), Math.max(r2, 0));
        goto L35
    L44:
        this.mDisplayOpts = detectDisplayOptions();
        goto L45
    L5:
        r0 = false;
        goto L6
    }

    private int detectDisplayOptions() {
        if (this.mToolbar.getNavigationIcon() == null) goto L5;
        this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
        return 15;
    L5:
        return 11;
    }

    private void ensureSpinner() {
        if (this.mSpinner != null) goto L6;
        this.mSpinner = new AppCompatSpinner((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), null, ZeusTransformUtils.mapRes(R.attr.actionDropDownStyle, "attr", "actionDropDownStyle"));
        Toolbar.LayoutParams r0 = new Toolbar.LayoutParams(-2, -2, 8388627);
        this.mSpinner.setLayoutParams(r0);
        return;
    }

    private void setTitleInt(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mTitle = r4;
        if ((this.mDisplayOpts & 8) == 0) goto L8;
        this.mToolbar.setTitle(r4);
        if (this.mTitleSet == false) goto L9;
        ViewCompat.setAccessibilityPaneTitle(this.mToolbar.getRootView(), r4);
        return;
    L9:
        return;
    }

    private void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) != 0) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.mHomeDescription) == false) goto L7;
        this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
    L7:
        this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
    }

    private void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) == 0) goto L9;
        Toolbar r0 = this.mToolbar;
        Drawable r1 = this.mNavIcon;
        if (r1 != null) goto L8;
        r1 = this.mDefaultNavigationIcon;
    L8:
        r0.setNavigationIcon(r1);
        return;
    L9:
        this.mToolbar.setNavigationIcon(null);
    }

    private void updateToolbarLogo() {
        int r0 = this.mDisplayOpts;
        if ((r0 & 2) != 0) goto L5;
        Drawable r1 = null;
    L11:
        this.mToolbar.setLogo(r1);
        return;
    L5:
        if ((r0 & 1) == 0) goto L9;
        r1 = this.mLogo;
        if (r1 != null) goto L11;
    L9:
        r1 = this.mIcon;
        goto L11
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int r3) {
        ViewPropertyAnimatorCompat r2 = setupAnimatorToVisibility(r3, 200);
        if (r2 == null) goto L6;
        r2.start();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        return this.mToolbar.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        this.mToolbar.collapseActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        this.mToolbar.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mToolbar.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public View getCustomView() {
        return this.mCustomView;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownItemCount() {
        Spinner r0 = this.mSpinner;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getCount();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner r0 = this.mSpinner;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getSelectedItemPosition();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getHeight() {
        return this.mToolbar.getHeight();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getSubtitle() {
        return this.mToolbar.getSubtitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getVisibility() {
        return this.mToolbar.getVisibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasEmbeddedTabs() {
        if (this.mTabView == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        return this.mToolbar.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasIcon() {
        if (this.mIcon == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasLogo() {
        if (this.mLogo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        return this.mToolbar.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Log.i(TAG, "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
        Log.i(TAG, "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        return this.mToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isTitleTruncated() {
        return this.mToolbar.isTitleTruncated();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void restoreHierarchyState(SparseArray<Parcelable> r1) {
        this.mToolbar.restoreHierarchyState(r1);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> r1) {
        this.mToolbar.saveHierarchyState(r1);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable r1) {
        ViewCompat.setBackground(this.mToolbar, r1);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean r1) {
        this.mToolbar.setCollapsible(r1);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View r3) {
        View r0 = this.mCustomView;
        if (r0 != null) goto L5;
    L7:
        this.mCustomView = r3;
        if (r3 != null) goto L10;
        return;
    L10:
        if ((this.mDisplayOpts & 16) == 0) goto L14;
        this.mToolbar.addView(r3);
        return;
    L14:
        return;
    L5:
        if ((this.mDisplayOpts & 16) == 0) goto L7;
        this.mToolbar.removeView(r0);
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int r2) {
        if (r2 != this.mDefaultNavigationContentDescription) goto L5;
        return;
    L5:
        this.mDefaultNavigationContentDescription = r2;
        if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription()) == false) goto L9;
        setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable r2) {
        if (this.mDefaultNavigationIcon == r2) goto L6;
        this.mDefaultNavigationIcon = r2;
        updateNavigationIcon();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int r4) {
        int r0 = this.mDisplayOpts ^ r4;
        this.mDisplayOpts = r4;
        if (r0 != 0) goto L5;
        return;
    L5:
        if ((r0 & 4) == 0) goto L11;
        if ((r4 & 4) == 0) goto L9;
        updateHomeAccessibility();
    L9:
        updateNavigationIcon();
    L11:
        if ((r0 & 3) == 0) goto L14;
        updateToolbarLogo();
    L14:
        if ((r0 & 8) == 0) goto L21;
        if ((r4 & 8) == 0) goto L18;
        this.mToolbar.setTitle(this.mTitle);
        Toolbar r1 = this.mToolbar;
        CharSequence r2 = this.mSubtitle;
    L19:
        r1.setSubtitle(r2);
        goto L21
    L18:
        r2 = null;
        this.mToolbar.setTitle(null);
        r1 = this.mToolbar;
    L21:
        if ((r0 & 16) == 0) goto L30;
        View r3 = this.mCustomView;
        if (r3 == null) goto L31;
        int r5 = r4 & 16;
        Toolbar r6 = this.mToolbar;
        if (r5 == 0) goto L27;
        r6.addView(r3);
        return;
    L27:
        r6.removeView(r3);
        return;
    L31:
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter r3, AdapterView.OnItemSelectedListener r4) {
        SpinnerAdapter r5 = (SpinnerAdapter) ZeusTransformUtils.wrapperContextForParams(r3, SpinnerAdapter.class, "com.obric.memorydata.plugin");
        AdapterView.OnItemSelectedListener r6 = (AdapterView.OnItemSelectedListener) ZeusTransformUtils.wrapperContextForParams(r4, AdapterView.OnItemSelectedListener.class, "com.obric.memorydata.plugin");
        ensureSpinner();
        this.mSpinner.setAdapter(r5);
        this.mSpinner.setOnItemSelectedListener(r6);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int r1) {
        Spinner r0 = this.mSpinner;
        if (r0 == null) goto L7;
        r0.setSelection(r1);
        return;
    L7:
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView r3) {
        View r0 = this.mTabView;
        if (r0 == null) goto L7;
        ViewParent r1 = r0.getParent();
        Toolbar r2 = this.mToolbar;
        if (r1 != r2) goto L7;
        r2.removeView(this.mTabView);
    L7:
        this.mTabView = r3;
        if (r3 != null) goto L10;
        return;
    L10:
        if (this.mNavigationMode != 2) goto L14;
        this.mToolbar.addView(r3, 0);
        Toolbar.LayoutParams r4 = (Toolbar.LayoutParams) ZeusTransformUtils.preCheckCast(this.mTabView.getLayoutParams(), Toolbar.LayoutParams.class, "com.obric.memorydata.plugin");
        r4.width = -2;
        r4.height = -2;
        r4.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        r3.setAllowCollapse(true);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean r1) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setIcon(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable r1) {
        this.mIcon = r1;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setLogo(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable r1) {
        this.mLogo = r1;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu r6, MenuPresenter.Callback r7) {
        Menu r8 = (Menu) ZeusTransformUtils.wrapperContextForParams(r6, Menu.class, "com.obric.memorydata.plugin");
        MenuPresenter.Callback r9 = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r7, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
        if (this.mActionMenuPresenter != null) goto L5;
        ActionMenuPresenter r0 = new ActionMenuPresenter((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mToolbar.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        this.mActionMenuPresenter = r0;
        r0.setId(ZeusTransformUtils.mapRes(R.id.action_menu_presenter, OaidModel.KEY_ID, "action_menu_presenter"));
    L5:
        this.mActionMenuPresenter.setCallback(r9);
        this.mToolbar.setMenu((MenuBuilder) ZeusTransformUtils.preCheckCast(r8, MenuBuilder.class, "com.obric.memorydata.plugin"), this.mActionMenuPresenter);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback r3, MenuBuilder.Callback r4) {
        MenuPresenter.Callback r5 = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r3, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
        MenuBuilder.Callback r6 = (MenuBuilder.Callback) ZeusTransformUtils.wrapperContextForParams(r4, MenuBuilder.Callback.class, "com.obric.memorydata.plugin");
        this.mToolbar.setMenuCallbacks(r5, r6);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int r4) {
        if (r4 != 0) goto L4;
        String r5 = null;
    L5:
        setNavigationContentDescription(r5);
        return;
    L4:
        r5 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getString(r4);
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence r3) {
        this.mHomeDescription = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        updateHomeAccessibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int r4) {
        if (r4 == 0) goto L4;
        Drawable r5 = AppCompatResources.getDrawable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    L5:
        setNavigationIcon(r5);
        return;
    L4:
        r5 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable r1) {
        this.mNavIcon = r1;
        updateNavigationIcon();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int r5) {
        int r0 = this.mNavigationMode;
        if (r5 != r0) goto L5;
        return;
    L5:
        if (r0 == 1) goto L13;
        if (r0 != 2) goto L19;
        View r1 = this.mTabView;
        if (r1 == null) goto L19;
        ViewParent r2 = r1.getParent();
        Toolbar r3 = this.mToolbar;
        if (r2 != r3) goto L19;
        View r4 = this.mTabView;
    L18:
        r3.removeView(r4);
    L19:
        this.mNavigationMode = r5;
        if (r5 != 0) goto L22;
        return;
    L22:
        if (r5 == 1) goto L29;
        if (r5 != 2) goto L28;
        View r6 = this.mTabView;
        if (r6 == null) goto L33;
        this.mToolbar.addView(r6, 0);
        Toolbar.LayoutParams r7 = (Toolbar.LayoutParams) ZeusTransformUtils.preCheckCast(this.mTabView.getLayoutParams(), Toolbar.LayoutParams.class, "com.obric.memorydata.plugin");
        r7.width = -2;
        r7.height = -2;
        r7.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        return;
    L33:
        return;
    L28:
        throw new IllegalArgumentException("Invalid navigation mode " + r5);
    L29:
        ensureSpinner();
        this.mToolbar.addView(this.mSpinner, 0);
        return;
    L13:
        Spinner r8 = this.mSpinner;
        if (r8 == null) goto L19;
        ViewParent r9 = r8.getParent();
        r3 = this.mToolbar;
        if (r9 != r3) goto L19;
        r4 = this.mSpinner;
        goto L18
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mSubtitle = r4;
        if ((this.mDisplayOpts & 8) == 0) goto L6;
        this.mToolbar.setSubtitle(r4);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mTitleSet = true;
        setTitleInt(r4);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int r1) {
        this.mToolbar.setVisibility(r1);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback r3) {
        this.mWindowCallback = (Window.Callback) ZeusTransformUtils.wrapperContextForParams(r3, Window.Callback.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (this.mTitleSet == true) goto L6;
        setTitleInt(r4);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int r3, long r4) {
        ViewPropertyAnimatorCompat r0 = ViewCompat.animate(this.mToolbar);
        if (r3 != 0) goto L5;
        float r1 = 1.0f;
    L7:
        return r0.alpha(r1).setDuration(r4).setListener(new AnonymousClass2(this, r3));
    L5:
        r1 = 0.0f;
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }
}
