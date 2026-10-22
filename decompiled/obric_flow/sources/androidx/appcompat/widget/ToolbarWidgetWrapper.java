package androidx.appcompat.widget;

import ai.j0;
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
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    public ToolbarWidgetWrapper(Toolbar r5, boolean r10) {
        this(r5, r10, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
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
        this.mSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        Toolbar.LayoutParams r5 = new Toolbar.LayoutParams(-2, -2, 8388627);
        this.mSpinner.setLayoutParams(r5);
        return;
    }

    private void setTitleInt(CharSequence r5) {
        this.mTitle = r5;
        if ((this.mDisplayOpts & 8) == 0) goto L8;
        this.mToolbar.setTitle(r5);
        if (this.mTitleSet == false) goto L9;
        ViewCompat.setAccessibilityPaneTitle(this.mToolbar.getRootView(), r5);
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
        Toolbar r5 = this.mToolbar;
        Drawable r10 = this.mNavIcon;
        if (r10 != null) goto L8;
        r10 = this.mDefaultNavigationIcon;
    L8:
        r5.setNavigationIcon(r10);
        return;
    L9:
        this.mToolbar.setNavigationIcon(null);
    }

    private void updateToolbarLogo() {
        int r5 = this.mDisplayOpts;
        if ((r5 & 2) != 0) goto L5;
        Drawable r10 = null;
    L12:
        this.mToolbar.setLogo(r10);
        return;
    L5:
        if ((r5 & 1) == 0) goto L10;
        r10 = this.mLogo;
        if (r10 != null) goto L12;
        r10 = this.mIcon;
        goto L12
    L10:
        r10 = this.mIcon;
        goto L12
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int r5) {
        ViewPropertyAnimatorCompat r10 = setupAnimatorToVisibility(r5, DEFAULT_FADE_DURATION_MS);
        if (r10 == null) goto L6;
        r10.start();
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
        return this.mToolbar.getContext();
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
        Spinner r5 = this.mSpinner;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getCount();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner r5 = this.mSpinner;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getSelectedItemPosition();
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
    public void restoreHierarchyState(SparseArray<Parcelable> r5) {
        this.mToolbar.restoreHierarchyState(r5);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> r5) {
        this.mToolbar.saveHierarchyState(r5);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable r5) {
        ViewCompat.setBackground(this.mToolbar, r5);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean r5) {
        this.mToolbar.setCollapsible(r5);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View r5) {
        View r10 = this.mCustomView;
        if (r10 != null) goto L5;
    L7:
        this.mCustomView = r5;
        if (r5 != null) goto L10;
        return;
    L10:
        if ((this.mDisplayOpts & 16) == 0) goto L14;
        this.mToolbar.addView(r5);
        return;
    L14:
        return;
    L5:
        if ((this.mDisplayOpts & 16) == 0) goto L7;
        this.mToolbar.removeView(r10);
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int r5) {
        if (r5 != this.mDefaultNavigationContentDescription) goto L5;
        return;
    L5:
        this.mDefaultNavigationContentDescription = r5;
        if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription()) == false) goto L9;
        setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable r5) {
        if (this.mDefaultNavigationIcon == r5) goto L6;
        this.mDefaultNavigationIcon = r5;
        updateNavigationIcon();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int r5) {
        int r10 = this.mDisplayOpts ^ r5;
        this.mDisplayOpts = r5;
        if (r10 != 0) goto L5;
        return;
    L5:
        if ((r10 & 4) == 0) goto L11;
        if ((r5 & 4) == 0) goto L9;
        updateHomeAccessibility();
    L9:
        updateNavigationIcon();
    L11:
        if ((r10 & 3) == 0) goto L14;
        updateToolbarLogo();
    L14:
        if ((r10 & 8) == 0) goto L20;
        if ((r5 & 8) == 0) goto L18;
        this.mToolbar.setTitle(this.mTitle);
        this.mToolbar.setSubtitle(this.mSubtitle);
        goto L20
    L18:
        this.mToolbar.setTitle(null);
        this.mToolbar.setSubtitle(null);
    L20:
        if ((r10 & 16) == 0) goto L29;
        View r11 = this.mCustomView;
        if (r11 != null) goto L24;
        return;
    L24:
        if ((r5 & 16) == 0) goto L26;
        this.mToolbar.addView(r11);
        return;
    L26:
        this.mToolbar.removeView(r11);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter r5, AdapterView.OnItemSelectedListener r10) {
        ensureSpinner();
        this.mSpinner.setAdapter(r5);
        this.mSpinner.setOnItemSelectedListener(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int r5) {
        Spinner r10 = this.mSpinner;
        if (r10 == null) goto L7;
        r10.setSelection(r5);
        return;
    L7:
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView r5) {
        View r10 = this.mTabView;
        if (r10 == null) goto L7;
        ViewParent r11 = r10.getParent();
        Toolbar r12 = this.mToolbar;
        if (r11 != r12) goto L7;
        r12.removeView(this.mTabView);
    L7:
        this.mTabView = r5;
        if (r5 != null) goto L10;
        return;
    L10:
        if (this.mNavigationMode != 2) goto L14;
        this.mToolbar.addView(r5, 0);
        Toolbar.LayoutParams r13 = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r13).width = -2;
        ((ViewGroup.MarginLayoutParams) r13).height = -2;
        r13.gravity = 8388691;
        r5.setAllowCollapse(true);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean r5) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setIcon(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setLogo(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu r5, MenuPresenter.Callback r10) {
        if (this.mActionMenuPresenter != null) goto L5;
        ActionMenuPresenter r11 = new ActionMenuPresenter(this.mToolbar.getContext());
        this.mActionMenuPresenter = r11;
        r11.setId(R.id.action_menu_presenter);
    L5:
        this.mActionMenuPresenter.setCallback(r10);
        this.mToolbar.setMenu((MenuBuilder) r5, this.mActionMenuPresenter);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback r5, MenuBuilder.Callback r10) {
        this.mToolbar.setMenuCallbacks(r5, r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence r5) {
        this.mHomeDescription = r5;
        updateHomeAccessibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable r5) {
        this.mNavIcon = r5;
        updateNavigationIcon();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int r5) {
        int r10 = this.mNavigationMode;
        if (r5 != r10) goto L5;
        return;
    L5:
        if (r10 == 1) goto L13;
        if (r10 != 2) goto L18;
        View r11 = this.mTabView;
        if (r11 == null) goto L18;
        ViewParent r12 = r11.getParent();
        Toolbar r13 = this.mToolbar;
        if (r12 != r13) goto L18;
        r13.removeView(this.mTabView);
    L18:
        this.mNavigationMode = r5;
        if (r5 != 0) goto L21;
        return;
    L21:
        if (r5 == 1) goto L28;
        if (r5 != 2) goto L27;
        View r14 = this.mTabView;
        if (r14 == null) goto L32;
        this.mToolbar.addView(r14, 0);
        Toolbar.LayoutParams r15 = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r15).width = -2;
        ((ViewGroup.MarginLayoutParams) r15).height = -2;
        r15.gravity = 8388691;
        return;
    L32:
        return;
    L27:
        throw new IllegalArgumentException(j0.g(r5, "Invalid navigation mode "));
    L28:
        ensureSpinner();
        this.mToolbar.addView(this.mSpinner, 0);
        return;
    L13:
        Spinner r16 = this.mSpinner;
        if (r16 == null) goto L18;
        ViewParent r17 = r16.getParent();
        Toolbar r18 = this.mToolbar;
        if (r17 != r18) goto L18;
        r18.removeView(this.mSpinner);
        goto L18
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence r5) {
        this.mSubtitle = r5;
        if ((this.mDisplayOpts & 8) == 0) goto L6;
        this.mToolbar.setSubtitle(r5);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence r5) {
        this.mTitleSet = true;
        setTitleInt(r5);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int r5) {
        this.mToolbar.setVisibility(r5);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback r5) {
        this.mWindowCallback = r5;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence r5) {
        if (this.mTitleSet == true) goto L6;
        setTitleInt(r5);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int r5, long r10) {
        ViewPropertyAnimatorCompat r11 = ViewCompat.animate(this.mToolbar);
        if (r5 != 0) goto L5;
        float r12 = 1.0f;
    L7:
        return r11.alpha(r12).setDuration(r10).setListener(new AnonymousClass2(this, r5));
    L5:
        r12 = 0.0f;
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    public ToolbarWidgetWrapper(Toolbar r5, boolean r10, int r11, int r12) {
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = r5;
        this.mTitle = r5.getTitle();
        this.mSubtitle = r5.getSubtitle();
        if (this.mTitle == null) goto L5;
        boolean r13 = true;
    L6:
        this.mTitleSet = r13;
        this.mNavIcon = r5.getNavigationIcon();
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r5.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = r14.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (r10 == false) goto L44;
        CharSequence r15 = r14.getText(R.styleable.ActionBar_title);
        if (TextUtils.isEmpty(r15) == true) goto L11;
        setTitle(r15);
    L11:
        CharSequence r16 = r14.getText(R.styleable.ActionBar_subtitle);
        if (TextUtils.isEmpty(r16) == true) goto L14;
        setSubtitle(r16);
    L14:
        Drawable r17 = r14.getDrawable(R.styleable.ActionBar_logo);
        if (r17 == null) goto L17;
        setLogo(r17);
    L17:
        Drawable r18 = r14.getDrawable(R.styleable.ActionBar_icon);
        if (r18 == null) goto L21;
        setIcon(r18);
    L21:
        if (this.mNavIcon != null) goto L25;
        Drawable r19 = this.mDefaultNavigationIcon;
        if (r19 == null) goto L25;
        setNavigationIcon(r19);
    L25:
        setDisplayOptions(r14.getInt(R.styleable.ActionBar_displayOptions, 0));
        int r20 = r14.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
        if (r20 == 0) goto L28;
        setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(r20, this.mToolbar, false));
        setDisplayOptions(this.mDisplayOpts | 16);
    L28:
        int r21 = r14.getLayoutDimension(R.styleable.ActionBar_height, 0);
        if (r21 <= 0) goto L31;
        ViewGroup.LayoutParams r22 = this.mToolbar.getLayoutParams();
        r22.height = r21;
        this.mToolbar.setLayoutParams(r22);
    L31:
        int r23 = r14.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
        int r24 = r14.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
        if (r23 >= 0) goto L34;
        if (r24 >= 0) goto L34;
    L35:
        int r25 = r14.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
        if (r25 == 0) goto L38;
        Toolbar r26 = this.mToolbar;
        r26.setTitleTextAppearance(r26.getContext(), r25);
    L38:
        int r27 = r14.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
        if (r27 == 0) goto L41;
        Toolbar r28 = this.mToolbar;
        r28.setSubtitleTextAppearance(r28.getContext(), r27);
    L41:
        int r29 = r14.getResourceId(R.styleable.ActionBar_popupTheme, 0);
        if (r29 == 0) goto L45;
        this.mToolbar.setPopupTheme(r29);
    L45:
        r14.recycle();
        setDefaultNavigationContentDescription(r11);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new AnonymousClass1(this));
        return;
    L34:
        this.mToolbar.setContentInsetsRelative(Math.max(r23, 0), Math.max(r24, 0));
        goto L35
    L44:
        this.mDisplayOpts = detectDisplayOptions();
        goto L45
    L5:
        r13 = false;
        goto L6
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable r5) {
        this.mIcon = r5;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable r5) {
        this.mLogo = r5;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int r5) {
        if (r5 != 0) goto L4;
        String r10 = null;
    L5:
        setNavigationContentDescription(r10);
        return;
    L4:
        r10 = getContext().getString(r5);
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int r5) {
        if (r5 == 0) goto L4;
        Drawable r10 = AppCompatResources.getDrawable(getContext(), r5);
    L5:
        setNavigationIcon(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }
}
