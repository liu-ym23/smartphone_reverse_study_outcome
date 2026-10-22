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
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.material.card.MaterialCardView;

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

    public ToolbarWidgetWrapper(Toolbar r10, boolean r11) {
        this(r10, r11, R.string.abc_action_bar_up_description, R.drawable.abc_ic_ab_back_material);
    }

    public ToolbarWidgetWrapper(Toolbar r10, boolean r11, int r12, int r13) {
        this.mNavigationMode = 0;
        this.mDefaultNavigationContentDescription = 0;
        this.mToolbar = r10;
        this.mTitle = r10.getTitle();
        this.mSubtitle = r10.getSubtitle();
        if (this.mTitle == null) goto L5;
        boolean r14 = true;
    L6:
        this.mTitleSet = r14;
        this.mNavIcon = r10.getNavigationIcon();
        TintTypedArray r15 = TintTypedArray.obtainStyledAttributes(r10.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = r15.getDrawable(R.styleable.ActionBar_homeAsUpIndicator);
        if (r11 == false) goto L44;
        CharSequence r16 = r15.getText(R.styleable.ActionBar_title);
        if (TextUtils.isEmpty(r16) == true) goto L11;
        setTitle(r16);
    L11:
        CharSequence r17 = r15.getText(R.styleable.ActionBar_subtitle);
        if (TextUtils.isEmpty(r17) == true) goto L14;
        setSubtitle(r17);
    L14:
        Drawable r18 = r15.getDrawable(R.styleable.ActionBar_logo);
        if (r18 == null) goto L17;
        setLogo(r18);
    L17:
        Drawable r19 = r15.getDrawable(R.styleable.ActionBar_icon);
        if (r19 == null) goto L21;
        setIcon(r19);
    L21:
        if (this.mNavIcon != null) goto L25;
        Drawable r20 = this.mDefaultNavigationIcon;
        if (r20 == null) goto L25;
        setNavigationIcon(r20);
    L25:
        setDisplayOptions(r15.getInt(R.styleable.ActionBar_displayOptions, 0));
        int r21 = r15.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
        if (r21 == 0) goto L28;
        setCustomView(LayoutInflater.from(this.mToolbar.getContext()).inflate(r21, this.mToolbar, false));
        setDisplayOptions(this.mDisplayOpts | 16);
    L28:
        int r22 = r15.getLayoutDimension(R.styleable.ActionBar_height, 0);
        if (r22 <= 0) goto L31;
        ViewGroup.LayoutParams r23 = this.mToolbar.getLayoutParams();
        r23.height = r22;
        this.mToolbar.setLayoutParams(r23);
    L31:
        int r24 = r15.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
        int r25 = r15.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
        if (r24 >= 0) goto L34;
        if (r25 >= 0) goto L34;
    L35:
        int r26 = r15.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
        if (r26 == 0) goto L38;
        Toolbar r27 = this.mToolbar;
        r27.setTitleTextAppearance(r27.getContext(), r26);
    L38:
        int r28 = r15.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
        if (r28 == 0) goto L41;
        Toolbar r29 = this.mToolbar;
        r29.setSubtitleTextAppearance(r29.getContext(), r28);
    L41:
        int r30 = r15.getResourceId(R.styleable.ActionBar_popupTheme, 0);
        if (r30 == 0) goto L45;
        this.mToolbar.setPopupTheme(r30);
    L45:
        r15.recycle();
        setDefaultNavigationContentDescription(r12);
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new AnonymousClass1(this));
        return;
    L34:
        this.mToolbar.setContentInsetsRelative(Math.max(r24, 0), Math.max(r25, 0));
        goto L35
    L44:
        this.mDisplayOpts = detectDisplayOptions();
        goto L45
    L5:
        r14 = false;
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
        this.mSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        Toolbar.LayoutParams r10 = new Toolbar.LayoutParams(-2, -2, 8388627);
        this.mSpinner.setLayoutParams(r10);
        return;
    }

    private void setTitleInt(CharSequence r10) {
        this.mTitle = r10;
        if ((this.mDisplayOpts & 8) == 0) goto L8;
        this.mToolbar.setTitle(r10);
        if (this.mTitleSet == false) goto L9;
        ViewCompat.setAccessibilityPaneTitle(this.mToolbar.getRootView(), r10);
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
        Toolbar r10 = this.mToolbar;
        Drawable r11 = this.mNavIcon;
        if (r11 != null) goto L8;
        r11 = this.mDefaultNavigationIcon;
    L8:
        r10.setNavigationIcon(r11);
        return;
    L9:
        this.mToolbar.setNavigationIcon(null);
    }

    private void updateToolbarLogo() {
        int r10 = this.mDisplayOpts;
        if ((r10 & 2) != 0) goto L5;
        Drawable r11 = null;
    L11:
        this.mToolbar.setLogo(r11);
        return;
    L5:
        if ((r10 & 1) == 0) goto L9;
        r11 = this.mLogo;
        if (r11 != null) goto L11;
    L9:
        r11 = this.mIcon;
        goto L11
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void animateToVisibility(int r10) {
        ViewPropertyAnimatorCompat r11 = setupAnimatorToVisibility(r10, DEFAULT_FADE_DURATION_MS);
        if (r11 == null) goto L6;
        r11.start();
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
        Spinner r10 = this.mSpinner;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getCount();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDropdownSelectedPosition() {
        Spinner r10 = this.mSpinner;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getSelectedItemPosition();
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
    public void restoreHierarchyState(SparseArray<Parcelable> r10) {
        this.mToolbar.restoreHierarchyState(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void saveHierarchyState(SparseArray<Parcelable> r10) {
        this.mToolbar.saveHierarchyState(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setBackgroundDrawable(Drawable r10) {
        ViewCompat.setBackground(this.mToolbar, r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean r10) {
        this.mToolbar.setCollapsible(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCustomView(View r10) {
        View r11 = this.mCustomView;
        if (r11 != null) goto L5;
    L7:
        this.mCustomView = r10;
        if (r10 != null) goto L10;
        return;
    L10:
        if ((this.mDisplayOpts & 16) == 0) goto L14;
        this.mToolbar.addView(r10);
        return;
    L14:
        return;
    L5:
        if ((this.mDisplayOpts & 16) == 0) goto L7;
        this.mToolbar.removeView(r11);
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationContentDescription(int r10) {
        if (r10 != this.mDefaultNavigationContentDescription) goto L5;
        return;
    L5:
        this.mDefaultNavigationContentDescription = r10;
        if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription()) == false) goto L9;
        setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDefaultNavigationIcon(Drawable r10) {
        if (this.mDefaultNavigationIcon == r10) goto L6;
        this.mDefaultNavigationIcon = r10;
        updateNavigationIcon();
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int r10) {
        int r11 = this.mDisplayOpts ^ r10;
        this.mDisplayOpts = r10;
        if (r11 != 0) goto L5;
        return;
    L5:
        if ((r11 & 4) == 0) goto L11;
        if ((r10 & 4) == 0) goto L9;
        updateHomeAccessibility();
    L9:
        updateNavigationIcon();
    L11:
        if ((r11 & 3) == 0) goto L14;
        updateToolbarLogo();
    L14:
        if ((r11 & 8) == 0) goto L21;
        if ((r10 & 8) == 0) goto L18;
        this.mToolbar.setTitle(this.mTitle);
        Toolbar r12 = this.mToolbar;
        CharSequence r13 = this.mSubtitle;
    L19:
        r12.setSubtitle(r13);
        goto L21
    L18:
        r13 = null;
        this.mToolbar.setTitle(null);
        r12 = this.mToolbar;
    L21:
        if ((r11 & 16) == 0) goto L30;
        View r14 = this.mCustomView;
        if (r14 == null) goto L31;
        int r15 = r10 & 16;
        Toolbar r16 = this.mToolbar;
        if (r15 == 0) goto L27;
        r16.addView(r14);
        return;
    L27:
        r16.removeView(r14);
        return;
    L31:
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownParams(SpinnerAdapter r10, AdapterView.OnItemSelectedListener r11) {
        ensureSpinner();
        this.mSpinner.setAdapter(r10);
        this.mSpinner.setOnItemSelectedListener(r11);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDropdownSelectedPosition(int r10) {
        Spinner r11 = this.mSpinner;
        if (r11 == null) goto L7;
        r11.setSelection(r10);
        return;
    L7:
        throw new IllegalStateException("Can't set dropdown selected position without an adapter");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView r10) {
        View r11 = this.mTabView;
        if (r11 == null) goto L7;
        ViewParent r12 = r11.getParent();
        Toolbar r13 = this.mToolbar;
        if (r12 != r13) goto L7;
        r13.removeView(this.mTabView);
    L7:
        this.mTabView = r10;
        if (r10 != null) goto L10;
        return;
    L10:
        if (this.mNavigationMode != 2) goto L14;
        this.mToolbar.addView(r10, 0);
        Toolbar.LayoutParams r14 = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r14).width = -2;
        ((ViewGroup.MarginLayoutParams) r14).height = -2;
        r14.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        r10.setAllowCollapse(true);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean r10) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setIcon(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable r10) {
        this.mIcon = r10;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setLogo(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(Drawable r10) {
        this.mLogo = r10;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu r10, MenuPresenter.Callback r11) {
        if (this.mActionMenuPresenter != null) goto L5;
        ActionMenuPresenter r12 = new ActionMenuPresenter(this.mToolbar.getContext());
        this.mActionMenuPresenter = r12;
        r12.setId(R.id.action_menu_presenter);
    L5:
        this.mActionMenuPresenter.setCallback(r11);
        this.mToolbar.setMenu((MenuBuilder) r10, this.mActionMenuPresenter);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback r10, MenuBuilder.Callback r11) {
        this.mToolbar.setMenuCallbacks(r10, r11);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(int r10) {
        if (r10 != 0) goto L4;
        String r11 = null;
    L5:
        setNavigationContentDescription(r11);
        return;
    L4:
        r11 = getContext().getString(r10);
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationContentDescription(CharSequence r10) {
        this.mHomeDescription = r10;
        updateHomeAccessibility();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = AppCompatResources.getDrawable(getContext(), r10);
    L5:
        setNavigationIcon(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable r10) {
        this.mNavIcon = r10;
        updateNavigationIcon();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationMode(int r10) {
        int r11 = this.mNavigationMode;
        if (r10 != r11) goto L5;
        return;
    L5:
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L19;
        View r12 = this.mTabView;
        if (r12 == null) goto L19;
        ViewParent r13 = r12.getParent();
        Toolbar r14 = this.mToolbar;
        if (r13 != r14) goto L19;
        View r15 = this.mTabView;
    L18:
        r14.removeView(r15);
    L19:
        this.mNavigationMode = r10;
        if (r10 != 0) goto L22;
        return;
    L22:
        if (r10 == 1) goto L29;
        if (r10 != 2) goto L28;
        View r16 = this.mTabView;
        if (r16 == null) goto L33;
        this.mToolbar.addView(r16, 0);
        Toolbar.LayoutParams r17 = (Toolbar.LayoutParams) this.mTabView.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) r17).width = -2;
        ((ViewGroup.MarginLayoutParams) r17).height = -2;
        r17.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
        return;
    L33:
        return;
    L28:
        throw new IllegalArgumentException("Invalid navigation mode " + r10);
    L29:
        ensureSpinner();
        this.mToolbar.addView(this.mSpinner, 0);
        return;
    L13:
        Spinner r18 = this.mSpinner;
        if (r18 == null) goto L19;
        ViewParent r19 = r18.getParent();
        r14 = this.mToolbar;
        if (r19 != r14) goto L19;
        r15 = this.mSpinner;
        goto L18
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setSubtitle(CharSequence r10) {
        this.mSubtitle = r10;
        if ((this.mDisplayOpts & 8) == 0) goto L6;
        this.mToolbar.setSubtitle(r10);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence r10) {
        this.mTitleSet = true;
        setTitleInt(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int r10) {
        this.mToolbar.setVisibility(r10);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback r10) {
        this.mWindowCallback = r10;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence r10) {
        if (this.mTitleSet == true) goto L6;
        setTitleInt(r10);
        return;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int r10, long r11) {
        ViewPropertyAnimatorCompat r12 = ViewCompat.animate(this.mToolbar);
        if (r10 != 0) goto L5;
        float r13 = 1.0f;
    L7:
        return r12.alpha(r13).setDuration(r11).setListener(new AnonymousClass2(this, r10));
    L5:
        r13 = 0.0f;
        goto L7
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }
}
