package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.g;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    private static final String TAG = "Toolbar";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private OnBackInvokedCallback mBackInvokedCallback;
    private boolean mBackInvokedCallbackEnabled;
    private OnBackInvokedDispatcher mBackInvokedDispatcher;
    int mButtonGravity;
    ImageButton mCollapseButtonView;
    private CharSequence mCollapseDescription;
    private Drawable mCollapseIcon;
    private boolean mCollapsible;
    private int mContentInsetEndWithActions;
    private int mContentInsetStartWithNavigation;
    private RtlSpacingHelper mContentInsets;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    View mExpandedActionView;
    private ExpandedActionViewMenuPresenter mExpandedMenuPresenter;
    private int mGravity;
    private final ArrayList<View> mHiddenViews;
    private ImageView mLogoView;
    private int mMaxButtonHeight;
    MenuBuilder.Callback mMenuBuilderCallback;
    final MenuHostHelper mMenuHostHelper;
    ActionMenuView mMenuView;
    private final ActionMenuView.OnMenuItemClickListener mMenuViewItemClickListener;
    private ImageButton mNavButtonView;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private ActionMenuPresenter mOuterActionMenuPresenter;
    private Context mPopupContext;
    private int mPopupTheme;
    private ArrayList<MenuItem> mProvidedMenuItems;
    private final Runnable mShowOverflowMenuRunnable;
    private CharSequence mSubtitleText;
    private int mSubtitleTextAppearance;
    private ColorStateList mSubtitleTextColor;
    private TextView mSubtitleTextView;
    private final int[] mTempMargins;
    private final ArrayList<View> mTempViews;
    private int mTitleMarginBottom;
    private int mTitleMarginEnd;
    private int mTitleMarginStart;
    private int mTitleMarginTop;
    private CharSequence mTitleText;
    private int mTitleTextAppearance;
    private ColorStateList mTitleTextColor;
    private TextView mTitleTextView;
    private ToolbarWidgetWrapper mWrapper;

    @RequiresApi(33)
    static class Api33Impl {
        private Api33Impl() {
        }

        @Nullable
        @DoNotInline
        static OnBackInvokedDispatcher findOnBackInvokedDispatcher(@NonNull View r10) {
            return r10.findOnBackInvokedDispatcher();
        }

        @NonNull
        @DoNotInline
        static OnBackInvokedCallback newOnBackInvokedCallback(@NonNull Runnable r10) {
            Objects.requireNonNull(r10);
            return new g(r10);
        }

        @DoNotInline
        static void tryRegisterOnBackInvokedCallback(@NonNull Object r10, @NonNull Object r11) {
            ((OnBackInvokedDispatcher) r10).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) r11);
        }

        @DoNotInline
        static void tryUnregisterOnBackInvokedCallback(@NonNull Object r10, @NonNull Object r11) {
            ((OnBackInvokedDispatcher) r10).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r11);
        }
    }

    private class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;
        final /* synthetic */ Toolbar this$0;

        ExpandedActionViewMenuPresenter(Toolbar r10) {
            this.this$0 = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder r10, MenuItemImpl r11) {
            KeyEvent.Callback r12 = this.this$0.mExpandedActionView;
            if ((r12 instanceof CollapsibleActionView) == false) goto L5;
            ((CollapsibleActionView) r12).onActionViewCollapsed();
        L5:
            Toolbar r13 = this.this$0;
            r13.removeView(r13.mExpandedActionView);
            Toolbar r14 = this.this$0;
            r14.removeView(r14.mCollapseButtonView);
            Toolbar r15 = this.this$0;
            r15.mExpandedActionView = null;
            r15.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            this.this$0.requestLayout();
            r11.setActionViewExpanded(false);
            this.this$0.updateBackInvokedCallbackState();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder r10, MenuItemImpl r11) {
            this.this$0.ensureCollapseButtonView();
            ViewParent r12 = this.this$0.mCollapseButtonView.getParent();
            Toolbar r13 = this.this$0;
            if (r12 != r13) goto L5;
        L8:
            Toolbar r14 = this.this$0;
            r14.mExpandedActionView = r11.getActionView();
            this.mCurrentExpandedItem = r11;
            ViewParent r15 = this.this$0.mExpandedActionView.getParent();
            Toolbar r16 = this.this$0;
            if (r15 != r16) goto L11;
        L14:
            this.this$0.removeChildrenForExpandedActionView();
            this.this$0.requestLayout();
            r11.setActionViewExpanded(true);
            KeyEvent.Callback r17 = this.this$0.mExpandedActionView;
            if ((r17 instanceof CollapsibleActionView) == false) goto L17;
            ((CollapsibleActionView) r17).onActionViewExpanded();
        L17:
            this.this$0.updateBackInvokedCallbackState();
            return true;
        L11:
            if ((r15 instanceof ViewGroup) == false) goto L13;
            ((ViewGroup) r15).removeView(r16.mExpandedActionView);
        L13:
            LayoutParams r18 = this.this$0.generateDefaultLayoutParams();
            Toolbar r19 = this.this$0;
            r18.gravity = 8388611 | (r19.mButtonGravity & 112);
            r18.mViewType = 2;
            r19.mExpandedActionView.setLayoutParams(r18);
            Toolbar r20 = this.this$0;
            r20.addView(r20.mExpandedActionView);
            goto L14
        L5:
            if ((r12 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r12).removeView(r13.mCollapseButtonView);
        L7:
            Toolbar r21 = this.this$0;
            r21.addView(r21.mCollapseButtonView);
            goto L8
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean flagActionItems() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public MenuView getMenuView(ViewGroup r10) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context r10, MenuBuilder r11) {
            MenuBuilder r12 = this.mMenu;
            if (r12 == null) goto L7;
            MenuItemImpl r13 = this.mCurrentExpandedItem;
            if (r13 == null) goto L7;
            r12.collapseItemActionView(r13);
        L7:
            this.mMenu = r11;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder r10, boolean r11) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable r10) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder r10) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback r10) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean r10) {
            if (this.mCurrentExpandedItem == null) goto L17;
            MenuBuilder r11 = this.mMenu;
            boolean r12 = false;
            if (r11 == null) goto L12;
            int r13 = r11.size();
            int r14 = 0;
        L7:
            if (r14 >= r13) goto L12;
            if (this.mMenu.getItem(r14) == this.mCurrentExpandedItem) goto L10;
            r14 = r14 + 1;
            goto L7
        L10:
            r12 = true;
        L12:
            if (r12 == true) goto L18;
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            return;
        L18:
            return;
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(int r10) {
            this(-2, -1, r10);
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int r10, int r11, int r12) {
            super(r10, r11);
            this.mViewType = 0;
            this.gravity = r12;
        }

        public LayoutParams(@NonNull Context r10, AttributeSet r11) {
            super(r10, r11);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.mViewType = 0;
            copyMarginsFromCompat(r10);
        }

        public LayoutParams(ActionBar.LayoutParams r10) {
            super(r10);
            this.mViewType = 0;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.mViewType = 0;
            this.mViewType = r10.mViewType;
        }

        void copyMarginsFromCompat(ViewGroup.MarginLayoutParams r10) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r10.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r10.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r10.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r10.bottomMargin;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r10);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r10) {
            this(r10, null);
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            this.expandedMenuItemId = r10.readInt();
            if (r10.readInt() == 0) goto L5;
            boolean r12 = true;
        L6:
            this.isOverflowOpen = r12;
            return;
        L5:
            r12 = false;
            goto L6
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeInt(this.expandedMenuItemId);
            r10.writeInt(this.isOverflowOpen ? 1 : 0);
        }
    }

    public Toolbar(@NonNull Context r10) {
        this(r10, null);
    }

    public Toolbar(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R.attr.toolbarStyle);
    }

    public Toolbar(@NonNull Context r10, @Nullable AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new b(this));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new AnonymousClass1(this);
        this.mShowOverflowMenuRunnable = new AnonymousClass2(this);
        Context r13 = getContext();
        int[] r14 = R.styleable.Toolbar;
        TintTypedArray r15 = TintTypedArray.obtainStyledAttributes(r13, r11, r14, r12, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r10, r14, r11, r15.getWrappedTypeArray(), r12, 0);
        this.mTitleTextAppearance = r15.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = r15.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = r15.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = r15.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int r16 = r15.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        int r17 = R.styleable.Toolbar_titleMargins;
        if (r15.hasValue(r17) == false) goto L5;
        r16 = r15.getDimensionPixelOffset(r17, r16);
    L5:
        this.mTitleMarginBottom = r16;
        this.mTitleMarginTop = r16;
        this.mTitleMarginEnd = r16;
        this.mTitleMarginStart = r16;
        int r18 = r15.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (r18 < 0) goto L8;
        this.mTitleMarginStart = r18;
    L8:
        int r19 = r15.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (r19 < 0) goto L11;
        this.mTitleMarginEnd = r19;
    L11:
        int r110 = r15.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (r110 < 0) goto L14;
        this.mTitleMarginTop = r110;
    L14:
        int r111 = r15.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (r111 < 0) goto L17;
        this.mTitleMarginBottom = r111;
    L17:
        this.mMaxButtonHeight = r15.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int r112 = r15.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int r113 = r15.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int r20 = r15.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int r21 = r15.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r20, r21);
        if (r112 != Integer.MIN_VALUE) goto L20;
        if (r113 != Integer.MIN_VALUE) goto L20;
    L21:
        this.mContentInsetStartWithNavigation = r15.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = r15.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = r15.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = r15.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence r114 = r15.getText(R.styleable.Toolbar_title);
        if (TextUtils.isEmpty(r114) == true) goto L24;
        setTitle(r114);
    L24:
        CharSequence r115 = r15.getText(R.styleable.Toolbar_subtitle);
        if (TextUtils.isEmpty(r115) == true) goto L27;
        setSubtitle(r115);
    L27:
        this.mPopupContext = getContext();
        setPopupTheme(r15.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable r116 = r15.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (r116 == null) goto L30;
        setNavigationIcon(r116);
    L30:
        CharSequence r117 = r15.getText(R.styleable.Toolbar_navigationContentDescription);
        if (TextUtils.isEmpty(r117) == true) goto L33;
        setNavigationContentDescription(r117);
    L33:
        Drawable r118 = r15.getDrawable(R.styleable.Toolbar_logo);
        if (r118 == null) goto L36;
        setLogo(r118);
    L36:
        CharSequence r119 = r15.getText(R.styleable.Toolbar_logoDescription);
        if (TextUtils.isEmpty(r119) == true) goto L39;
        setLogoDescription(r119);
    L39:
        int r120 = R.styleable.Toolbar_titleTextColor;
        if (r15.hasValue(r120) == false) goto L42;
        setTitleTextColor(r15.getColorStateList(r120));
    L42:
        int r121 = R.styleable.Toolbar_subtitleTextColor;
        if (r15.hasValue(r121) == false) goto L45;
        setSubtitleTextColor(r15.getColorStateList(r121));
    L45:
        int r122 = R.styleable.Toolbar_menu;
        if (r15.hasValue(r122) == false) goto L48;
        inflateMenu(r15.getResourceId(r122, 0));
    L48:
        r15.recycle();
        return;
    L20:
        this.mContentInsets.setRelative(r112, r113);
        goto L21
    }

    private void addCustomViewsWithGravity(List<View> r10, int r11) {
        int r12 = 0;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r13 = true;
    L6:
        int r14 = getChildCount();
        int r15 = GravityCompat.getAbsoluteGravity(r11, ViewCompat.getLayoutDirection(this));
        r10.clear();
        if (r13 == false) goto L18;
        int r16 = r14 - 1;
    L9:
        if (r16 < 0) goto L27;
        View r17 = getChildAt(r16);
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        if (r18.mViewType != 0) goto L17;
        if (shouldLayout(r17) == false) goto L17;
        if (getChildHorizontalGravity(r18.gravity) != r15) goto L17;
        r10.add(r17);
    L17:
        r16 = r16 - 1;
        goto L9
    L27:
        return;
    L18:
        if (r12 >= r14) goto L38;
        View r19 = getChildAt(r12);
        LayoutParams r20 = (LayoutParams) r19.getLayoutParams();
        if (r20.mViewType != 0) goto L26;
        if (shouldLayout(r19) == false) goto L26;
        if (getChildHorizontalGravity(r20.gravity) != r15) goto L26;
        r10.add(r19);
    L26:
        r12 = r12 + 1;
        goto L18
    L38:
        return;
    L5:
        r13 = false;
        goto L6
    }

    private void addSystemView(View r10, boolean r11) {
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 != null) goto L6;
        LayoutParams r13 = generateDefaultLayoutParams();
    L9:
        r13.mViewType = 1;
        if (r11 == true) goto L12;
    L14:
        addView(r10, r13);
        return;
    L12:
        if (this.mExpandedActionView == null) goto L14;
        r10.setLayoutParams(r13);
        this.mHiddenViews.add(r10);
        return;
    L6:
        if (checkLayoutParams(r12) == true) goto L8;
        r13 = generateLayoutParams(r12);
        goto L9
    L8:
        r13 = (LayoutParams) r12;
        goto L9
    }

    private void ensureContentInsets() {
        if (this.mContentInsets != null) goto L6;
        this.mContentInsets = new RtlSpacingHelper();
        return;
    }

    private void ensureLogoView() {
        if (this.mLogoView != null) goto L6;
        this.mLogoView = new AppCompatImageView(getContext());
        return;
    }

    private void ensureMenu() {
        ensureMenuView();
        if (this.mMenuView.peekMenu() != null) goto L9;
        MenuBuilder r10 = (MenuBuilder) this.mMenuView.getMenu();
        if (this.mExpandedMenuPresenter != null) goto L7;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L7:
        this.mMenuView.setExpandedActionViewsExclusive(true);
        r10.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        updateBackInvokedCallbackState();
        return;
    }

    private void ensureMenuView() {
        if (this.mMenuView != null) goto L6;
        ActionMenuView r10 = new ActionMenuView(getContext());
        this.mMenuView = r10;
        r10.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, new AnonymousClass3(this));
        LayoutParams r11 = generateDefaultLayoutParams();
        r11.gravity = 8388613 | (this.mButtonGravity & 112);
        this.mMenuView.setLayoutParams(r11);
        addSystemView(this.mMenuView, false);
        return;
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView != null) goto L6;
        this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        LayoutParams r10 = generateDefaultLayoutParams();
        r10.gravity = 8388611 | (this.mButtonGravity & 112);
        this.mNavButtonView.setLayoutParams(r10);
        return;
    }

    private int getChildHorizontalGravity(int r10) {
        int r11 = ViewCompat.getLayoutDirection(this);
        int r12 = GravityCompat.getAbsoluteGravity(r10, r11) & 7;
        if (r12 != 1) goto L5;
    L11:
        return r12;
    L5:
        if (r12 == 3) goto L11;
        if (r12 == 5) goto L11;
        if (r11 == 1) goto L10;
        return 3;
    L10:
        return 5;
    }

    private int getChildTop(View r10, int r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        int r13 = r10.getMeasuredHeight();
        if (r11 <= 0) goto L5;
        int r14 = (r13 - r11) / 2;
    L6:
        int r15 = getChildVerticalGravity(r12.gravity);
        if (r15 == 48) goto L21;
        if (r15 == 80) goto L19;
        int r16 = getPaddingTop();
        int r17 = getPaddingBottom();
        int r18 = getHeight();
        int r19 = (((r18 - r16) - r17) - r13) / 2;
        int r20 = ((ViewGroup.MarginLayoutParams) r12).topMargin;
        if (r19 >= r20) goto L13;
        r19 = r20;
    L17:
        return r16 + r19;
    L13:
        int r21 = (((r18 - r17) - r13) - r19) - r16;
        int r22 = ((ViewGroup.MarginLayoutParams) r12).bottomMargin;
        if (r21 >= r22) goto L17;
        r19 = Math.max(0, r19 - (r22 - r21));
        goto L17
    L19:
        return (((getHeight() - getPaddingBottom()) - r13) - ((ViewGroup.MarginLayoutParams) r12).bottomMargin) - r14;
    L21:
        return getPaddingTop() - r14;
    L5:
        r14 = 0;
        goto L6
    }

    private int getChildVerticalGravity(int r10) {
        int r11 = r10 & 112;
        if (r11 != 16) goto L5;
    L10:
        return r11;
    L5:
        if (r11 == 48) goto L10;
        if (r11 == 80) goto L10;
        return this.mGravity & 112;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> r10 = new ArrayList();
        Menu r11 = getMenu();
        int r12 = 0;
    L4:
        if (r12 >= r11.size()) goto L6;
        r10.add(r11.getItem(r12));
        r12 = r12 + 1;
        goto L4
    L6:
        return r10;
    }

    private int getHorizontalMargins(View r10) {
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        return MarginLayoutParamsCompat.getMarginStart(r11) + MarginLayoutParamsCompat.getMarginEnd(r11);
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private int getVerticalMargins(View r10) {
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        return r11.topMargin + r11.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> r10, int[] r11) {
        int r12 = r11[0];
        int r13 = r11[1];
        int r14 = r10.size();
        int r15 = 0;
        int r16 = 0;
    L3:
        if (r15 >= r14) goto L5;
        View r17 = r10.get(r15);
        LayoutParams r18 = (LayoutParams) r17.getLayoutParams();
        int r19 = ((ViewGroup.MarginLayoutParams) r18).leftMargin - r12;
        int r20 = ((ViewGroup.MarginLayoutParams) r18).rightMargin - r13;
        int r21 = Math.max(0, r19);
        int r22 = Math.max(0, r20);
        int r23 = Math.max(0, -r19);
        int r24 = Math.max(0, -r20);
        r16 = r16 + ((r21 + r17.getMeasuredWidth()) + r22);
        r15 = r15 + 1;
        r13 = r24;
        r12 = r23;
        goto L3
    L5:
        return r16;
    }

    private boolean isChildOrHidden(View r10) {
        if (r10.getParent() != this) goto L5;
    L8:
        return true;
    L5:
        if (this.mHiddenViews.contains(r10) == true) goto L8;
        return false;
    }

    private int layoutChildLeft(View r10, int r11, int[] r12, int r13) {
        LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
        int r15 = ((ViewGroup.MarginLayoutParams) r14).leftMargin - r12[0];
        int r16 = r11 + Math.max(0, r15);
        r12[0] = Math.max(0, -r15);
        int r17 = getChildTop(r10, r13);
        int r18 = r10.getMeasuredWidth();
        r10.layout(r16, r17, r16 + r18, r10.getMeasuredHeight() + r17);
        return r16 + (r18 + ((ViewGroup.MarginLayoutParams) r14).rightMargin);
    }

    private int layoutChildRight(View r10, int r11, int[] r12, int r13) {
        LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
        int r15 = ((ViewGroup.MarginLayoutParams) r14).rightMargin - r12[1];
        int r16 = r11 - Math.max(0, r15);
        r12[1] = Math.max(0, -r15);
        int r17 = getChildTop(r10, r13);
        int r18 = r10.getMeasuredWidth();
        r10.layout(r16 - r18, r17, r16, r10.getMeasuredHeight() + r17);
        return r16 - (r18 + ((ViewGroup.MarginLayoutParams) r14).leftMargin);
    }

    private int measureChildCollapseMargins(View r10, int r11, int r12, int r13, int r14, int[] r15) {
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r17 = r16.leftMargin - r15[0];
        int r18 = r16.rightMargin - r15[1];
        int r19 = Math.max(0, r17) + Math.max(0, r18);
        r15[0] = Math.max(0, -r17);
        r15[1] = Math.max(0, -r18);
        r10.measure(ViewGroup.getChildMeasureSpec(r11, ((getPaddingLeft() + getPaddingRight()) + r19) + r12, r16.width), ViewGroup.getChildMeasureSpec(r13, (((getPaddingTop() + getPaddingBottom()) + r16.topMargin) + r16.bottomMargin) + r14, r16.height));
        return r10.getMeasuredWidth() + r19;
    }

    private void measureChildConstrained(View r10, int r11, int r12, int r13, int r14, int r15) {
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r17 = ViewGroup.getChildMeasureSpec(r11, (((getPaddingLeft() + getPaddingRight()) + r16.leftMargin) + r16.rightMargin) + r12, r16.width);
        int r18 = ViewGroup.getChildMeasureSpec(r13, (((getPaddingTop() + getPaddingBottom()) + r16.topMargin) + r16.bottomMargin) + r14, r16.height);
        int r19 = View.MeasureSpec.getMode(r18);
        if (r19 == 1073741824) goto L8;
        if (r15 < 0) goto L8;
        if (r19 == 0) goto L7;
        r15 = Math.min(View.MeasureSpec.getSize(r18), r15);
    L7:
        r18 = View.MeasureSpec.makeMeasureSpec(r15, 1073741824);
    L8:
        r10.measure(r17, r18);
    }

    private void onCreateMenu() {
        Menu r10 = getMenu();
        ArrayList<MenuItem> r11 = getCurrentMenuItems();
        this.mMenuHostHelper.onCreateMenu(r10, getMenuInflater());
        ArrayList<MenuItem> r12 = getCurrentMenuItems();
        r12.removeAll(r11);
        this.mProvidedMenuItems = r12;
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (this.mCollapsible == true) goto L5;
        return false;
    L5:
        int r10 = getChildCount();
        int r11 = 0;
    L6:
        if (r11 >= r10) goto L15;
        View r12 = getChildAt(r11);
        if (shouldLayout(r12) == false) goto L14;
        if (r12.getMeasuredWidth() <= 0) goto L14;
        if (r12.getMeasuredHeight() <= 0) goto L14;
        return false;
    L14:
        r11 = r11 + 1;
        goto L6
    L15:
        return true;
    }

    private boolean shouldLayout(View r10) {
        if (r10 != null) goto L4;
    L8:
        return false;
    L4:
        if (r10.getParent() != this) goto L8;
        if (r10.getVisibility() == 8) goto L8;
        return true;
    }

    void addChildrenForExpandedActionView() {
        int r10 = this.mHiddenViews.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        addView(this.mHiddenViews.get(r10));
        r10 = r10 - 1;
        goto L3
    L5:
        this.mHiddenViews.clear();
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuHostHelper.addMenuProvider(r10);
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11) {
        this.mMenuHostHelper.addMenuProvider(r10, r11);
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r10, @NonNull LifecycleOwner r11, @NonNull Lifecycle.State r12) {
        this.mMenuHostHelper.addMenuProvider(r10, r11, r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean canShowOverflowMenu() {
        if (getVisibility() != 0) goto L9;
        ActionMenuView r10 = this.mMenuView;
        if (r10 == null) goto L9;
        if (r10.isOverflowReserved() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if (super.checkLayoutParams(r10) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r10 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    public void collapseActionView() {
        ExpandedActionViewMenuPresenter r10 = this.mExpandedMenuPresenter;
        if (r10 != null) goto L5;
        MenuItemImpl r11 = null;
    L6:
        if (r11 == null) goto L9;
        r11.collapseActionView();
        return;
    L9:
        return;
    L5:
        r11 = r10.mCurrentExpandedItem;
        goto L6
    }

    public void dismissPopupMenus() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 == null) goto L6;
        r10.dismissPopupMenus();
        return;
    }

    void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) goto L6;
        AppCompatImageButton r10 = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        this.mCollapseButtonView = r10;
        r10.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        LayoutParams r11 = generateDefaultLayoutParams();
        r11.gravity = 8388611 | (this.mButtonGravity & 112);
        r11.mViewType = 2;
        this.mCollapseButtonView.setLayoutParams(r11);
        this.mCollapseButtonView.setOnClickListener(new AnonymousClass4(this));
        return;
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r10) {
        return new LayoutParams(getContext(), r10);
    }

    @Override // android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r10);
    L7:
        if ((r10 instanceof ActionBar.LayoutParams) == false) goto L11;
        return new LayoutParams((ActionBar.LayoutParams) r10);
    L11:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L15:
        return new LayoutParams(r10);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton r10 = this.mCollapseButtonView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getContentDescription();
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton r10 = this.mCollapseButtonView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getDrawable();
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper r10 = this.mContentInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getEnd();
    }

    public int getContentInsetEndWithActions() {
        int r10 = this.mContentInsetEndWithActions;
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper r10 = this.mContentInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getLeft();
    }

    public int getContentInsetRight() {
        RtlSpacingHelper r10 = this.mContentInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getRight();
    }

    public int getContentInsetStart() {
        RtlSpacingHelper r10 = this.mContentInsets;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getStart();
    }

    public int getContentInsetStartWithNavigation() {
        int r10 = this.mContentInsetStartWithNavigation;
        if (r10 == Integer.MIN_VALUE) goto L6;
        return r10;
    L6:
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 == null) goto L9;
        MenuBuilder r11 = r10.peekMenu();
        if (r11 == null) goto L9;
        if (r11.hasVisibleItems() == false) goto L9;
        boolean r12 = true;
    L10:
        if (r12 == false) goto L13;
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    L13:
        return getContentInsetEnd();
    L9:
        r12 = false;
        goto L10
    }

    public int getCurrentContentInsetLeft() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L6;
        return getCurrentContentInsetEnd();
    L6:
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L6;
        return getCurrentContentInsetStart();
    L6:
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() == null) goto L6;
        return Math.max(getContentInsetStart(), Math.max(this.mContentInsetStartWithNavigation, 0));
    L6:
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView r10 = this.mLogoView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getDrawable();
    }

    public CharSequence getLogoDescription() {
        ImageView r10 = this.mLogoView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getContentDescription();
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    View getNavButtonView() {
        return this.mNavButtonView;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton r10 = this.mNavButtonView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getContentDescription();
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton r10 = this.mNavButtonView;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.getDrawable();
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.mPopupContext;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitleText;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    final TextView getSubtitleTextView() {
        return this.mSubtitleTextView;
    }

    public CharSequence getTitle() {
        return this.mTitleText;
    }

    public int getTitleMarginBottom() {
        return this.mTitleMarginBottom;
    }

    public int getTitleMarginEnd() {
        return this.mTitleMarginEnd;
    }

    public int getTitleMarginStart() {
        return this.mTitleMarginStart;
    }

    public int getTitleMarginTop() {
        return this.mTitleMarginTop;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    final TextView getTitleTextView() {
        return this.mTitleTextView;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DecorToolbar getWrapper() {
        if (this.mWrapper != null) goto L6;
        this.mWrapper = new ToolbarWidgetWrapper(this, true);
    L6:
        return this.mWrapper;
    }

    public boolean hasExpandedActionView() {
        ExpandedActionViewMenuPresenter r10 = this.mExpandedMenuPresenter;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.mCurrentExpandedItem == null) goto L7;
        return true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.hideOverflowMenu() == false) goto L7;
        return true;
    }

    public void inflateMenu(@MenuRes int r10) {
        getMenuInflater().inflate(r10, getMenu());
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void invalidateMenu() {
        Iterator<MenuItem> r10 = this.mProvidedMenuItems.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        MenuItem r11 = r10.next();
        getMenu().removeItem(r11.getItemId());
        goto L4
    L6:
        onCreateMenu();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        TextView r10 = this.mTitleTextView;
        if (r10 != null) goto L5;
        return false;
    L5:
        Layout r11 = r10.getLayout();
        if (r11 != null) goto L8;
        return false;
    L8:
        int r12 = r11.getLineCount();
        int r13 = 0;
    L9:
        if (r13 >= r12) goto L15;
        if (r11.getEllipsisCount(r13) > 0) goto L12;
        r13 = r13 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r12 = super.onHoverEvent(r10);
        if (r11 != 9) goto L12;
        if (r12 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r11 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r11 != 3) goto L16;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r10 = true;
    L6:
        int r11 = getWidth();
        int r12 = getHeight();
        int r13 = getPaddingLeft();
        int r14 = getPaddingRight();
        int r15 = getPaddingTop();
        int r16 = getPaddingBottom();
        int r17 = r11 - r14;
        int[] r18 = this.mTempMargins;
        r18[1] = 0;
        r18[0] = 0;
        int r19 = ViewCompat.getMinimumHeight(this);
        if (r19 < 0) goto L9;
        int r110 = Math.min(r19, r24 - r22);
    L11:
        if (shouldLayout(this.mNavButtonView) == false) goto L16;
        ImageButton r111 = this.mNavButtonView;
        if (r10 == false) goto L15;
        int r112 = layoutChildRight(r111, r17, r18, r110);
        int r113 = r13;
    L19:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L25;
        ImageButton r114 = this.mCollapseButtonView;
        if (r10 == false) goto L23;
        r112 = layoutChildRight(r114, r112, r18, r110);
        goto L25
    L23:
        r113 = layoutChildLeft(r114, r113, r18, r110);
    L25:
        if (shouldLayout(this.mMenuView) == false) goto L30;
        ActionMenuView r115 = this.mMenuView;
        if (r10 == false) goto L29;
        r113 = layoutChildLeft(r115, r113, r18, r110);
        goto L30
    L29:
        r112 = layoutChildRight(r115, r112, r18, r110);
    L30:
        int r116 = getCurrentContentInsetLeft();
        int r117 = getCurrentContentInsetRight();
        r18[0] = Math.max(0, r116 - r113);
        r18[1] = Math.max(0, r117 - (r17 - r112));
        int r25 = Math.max(r113, r116);
        int r118 = Math.min(r112, r17 - r117);
        if (shouldLayout(this.mExpandedActionView) == false) goto L37;
        View r119 = this.mExpandedActionView;
        if (r10 == false) goto L35;
        r118 = layoutChildRight(r119, r118, r18, r110);
        goto L37
    L35:
        r25 = layoutChildLeft(r119, r25, r18, r110);
    L37:
        if (shouldLayout(this.mLogoView) == false) goto L42;
        ImageView r120 = this.mLogoView;
        if (r10 == false) goto L41;
        r118 = layoutChildRight(r120, r118, r18, r110);
        goto L42
    L41:
        r25 = layoutChildLeft(r120, r25, r18, r110);
    L42:
        boolean r121 = shouldLayout(this.mTitleTextView);
        boolean r122 = shouldLayout(this.mSubtitleTextView);
        if (r121 == false) goto L45;
        LayoutParams r123 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r26 = ((((ViewGroup.MarginLayoutParams) r123).topMargin + this.mTitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r123).bottomMargin) + 0;
    L46:
        if (r122 == false) goto L49;
        LayoutParams r27 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        r26 = r26 + ((((ViewGroup.MarginLayoutParams) r27).topMargin + this.mSubtitleTextView.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r27).bottomMargin);
    L49:
        if (r121 == true) goto L54;
        if (r122 == true) goto L54;
        int r124 = r13;
        r110 = r110;
    L53:
        int r28 = 0;
    L108:
        addCustomViewsWithGravity(this.mTempViews, 3);
        int r29 = this.mTempViews.size();
        int r30 = r28;
    L109:
        if (r30 >= r29) goto L111;
        r25 = layoutChildLeft(this.mTempViews.get(r30), r25, r18, r110);
        r30 = r30 + 1;
        goto L109
    L111:
        int r125 = r110;
        addCustomViewsWithGravity(this.mTempViews, 5);
        int r31 = this.mTempViews.size();
        int r32 = r28;
    L112:
        if (r32 >= r31) goto L114;
        r118 = layoutChildRight(this.mTempViews.get(r32), r118, r18, r125);
        r32 = r32 + 1;
        goto L112
    L114:
        addCustomViewsWithGravity(this.mTempViews, 1);
        int r33 = getViewListMeasuredWidth(this.mTempViews, r18);
        int r34 = (r124 + (((r11 - r124) - r14) / 2)) - (r33 / 2);
        int r35 = r33 + r34;
        if (r34 < r25) goto L120;
        if (r35 <= r118) goto L119;
        r25 = r34 - (r35 - r118);
        goto L120
    L119:
        r25 = r34;
    L120:
        int r36 = this.mTempViews.size();
    L121:
        if (r28 >= r36) goto L123;
        r25 = layoutChildLeft(this.mTempViews.get(r28), r25, r18, r125);
        r28 = r28 + 1;
        goto L121
    L123:
        this.mTempViews.clear();
        return;
    L54:
        if (r121 == false) goto L56;
        TextView r37 = this.mTitleTextView;
    L57:
        if (r122 == false) goto L59;
        TextView r38 = this.mSubtitleTextView;
    L60:
        LayoutParams r39 = (LayoutParams) r37.getLayoutParams();
        LayoutParams r40 = (LayoutParams) r38.getLayoutParams();
        if (r121 == true) goto L63;
    L64:
        if (r122 == true) goto L66;
    L68:
        boolean r126 = false;
    L69:
        int r127 = this.mGravity & 112;
        r124 = r13;
        if (r127 != 48) goto L72;
        int r41 = (getPaddingTop() + ((ViewGroup.MarginLayoutParams) r39).topMargin) + this.mTitleMarginTop;
    L82:
        if (r10 == false) goto L96;
        if (r126 == false) goto L85;
        int r42 = this.mTitleMarginStart;
    L86:
        int r43 = r42 - r18[1];
        r118 = r118 - Math.max(0, r43);
        r18[1] = Math.max(0, -r43);
        if (r121 == false) goto L89;
        LayoutParams r44 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r45 = r118 - this.mTitleTextView.getMeasuredWidth();
        int r46 = this.mTitleTextView.getMeasuredHeight() + r41;
        this.mTitleTextView.layout(r45, r41, r118, r46);
        int r47 = r45 - this.mTitleMarginEnd;
        r41 = r46 + ((ViewGroup.MarginLayoutParams) r44).bottomMargin;
    L90:
        if (r122 == false) goto L92;
        int r48 = r41 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        this.mSubtitleTextView.layout(r118 - this.mSubtitleTextView.getMeasuredWidth(), r48, r118, this.mSubtitleTextView.getMeasuredHeight() + r48);
        int r49 = r118 - this.mTitleMarginEnd;
    L93:
        if (r126 == false) goto L95;
        r118 = Math.min(r47, r49);
    L95:
        r25 = r25;
        goto L53
    L92:
        r49 = r118;
        goto L93
    L89:
        r47 = r118;
        goto L90
    L85:
        r42 = 0;
        goto L86
    L96:
        if (r126 == false) goto L98;
        int r50 = this.mTitleMarginStart;
        r28 = 0;
    L99:
        int r51 = r50 - r18[r28];
        r25 = r25 + Math.max(r28, r51);
        r18[r28] = Math.max(r28, -r51);
        if (r121 == false) goto L102;
        LayoutParams r52 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r53 = this.mTitleTextView.getMeasuredWidth() + r25;
        int r54 = this.mTitleTextView.getMeasuredHeight() + r41;
        this.mTitleTextView.layout(r25, r41, r53, r54);
        int r55 = r53 + this.mTitleMarginEnd;
        r41 = r54 + ((ViewGroup.MarginLayoutParams) r52).bottomMargin;
    L103:
        if (r122 == false) goto L105;
        int r56 = r41 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        int r57 = this.mSubtitleTextView.getMeasuredWidth() + r25;
        this.mSubtitleTextView.layout(r25, r56, r57, this.mSubtitleTextView.getMeasuredHeight() + r56);
        int r58 = r57 + this.mTitleMarginEnd;
    L106:
        if (r126 == false) goto L108;
        r25 = Math.max(r55, r58);
        goto L108
    L105:
        r58 = r25;
        goto L106
    L102:
        r55 = r25;
        goto L103
    L98:
        r28 = 0;
        r50 = 0;
        goto L99
    L72:
        if (r127 == 80) goto L80;
        int r59 = (((r12 - r15) - r16) - r26) / 2;
        int r128 = ((ViewGroup.MarginLayoutParams) r39).topMargin;
        int r129 = this.mTitleMarginTop;
        if (r59 >= (r128 + r129)) goto L76;
        r59 = r128 + r129;
    L79:
        r41 = r15 + r59;
        goto L82
    L76:
        int r60 = (((r12 - r16) - r26) - r59) - r15;
        int r61 = ((ViewGroup.MarginLayoutParams) r39).bottomMargin;
        int r62 = this.mTitleMarginBottom;
        if (r60 >= (r61 + r62)) goto L79;
        r59 = Math.max(0, r59 - ((((ViewGroup.MarginLayoutParams) r40).bottomMargin + r62) - r60));
        goto L79
    L80:
        r41 = (((r12 - r16) - ((ViewGroup.MarginLayoutParams) r40).bottomMargin) - this.mTitleMarginBottom) - r26;
        goto L82
    L66:
        if (this.mSubtitleTextView.getMeasuredWidth() <= 0) goto L68;
    L67:
        r126 = true;
        goto L69
    L63:
        if (this.mTitleTextView.getMeasuredWidth() > 0) goto L67;
    L59:
        r38 = this.mTitleTextView;
        goto L60
    L56:
        r37 = this.mSubtitleTextView;
        goto L57
    L45:
        r26 = 0;
        goto L46
    L15:
        r113 = layoutChildLeft(r111, r13, r18, r110);
    L17:
        r112 = r17;
        goto L19
    L16:
        r113 = r13;
        goto L17
    L9:
        r110 = 0;
        goto L11
    L5:
        r10 = false;
        goto L6
    }

    @Override // android.view.View
    protected void onMeasure(int r17, int r18) {
        int[] r10 = this.mTempMargins;
        boolean r11 = ViewUtils.isLayoutRtl(this);
        int r12 = 0;
        int r13 = !r11 ? 1 : 0;
        if (shouldLayout(this.mNavButtonView) == false) goto L5;
        measureChildConstrained(this.mNavButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        int r14 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int r15 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        int r16 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    L7:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L9;
        measureChildConstrained(this.mCollapseButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        r14 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        r15 = Math.max(r15, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        r16 = View.combineMeasuredStates(r16, this.mCollapseButtonView.getMeasuredState());
    L9:
        int r19 = getCurrentContentInsetStart();
        int r110 = 0 + Math.max(r19, r14);
        r10[r11 ? 1 : 0] = Math.max(0, r19 - r14);
        if (shouldLayout(this.mMenuView) == false) goto L12;
        measureChildConstrained(this.mMenuView, r17, r110, r18, 0, this.mMaxButtonHeight);
        int r20 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        r15 = Math.max(r15, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        r16 = View.combineMeasuredStates(r16, this.mMenuView.getMeasuredState());
    L13:
        int r21 = getCurrentContentInsetEnd();
        int r111 = r110 + Math.max(r21, r20);
        r10[r13] = Math.max(0, r21 - r20);
        if (shouldLayout(this.mExpandedActionView) == false) goto L17;
        r111 = r111 + measureChildCollapseMargins(this.mExpandedActionView, r17, r111, r18, 0, r10);
        r15 = Math.max(r15, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        r16 = View.combineMeasuredStates(r16, this.mExpandedActionView.getMeasuredState());
    L17:
        if (shouldLayout(this.mLogoView) == false) goto L19;
        r111 = r111 + measureChildCollapseMargins(this.mLogoView, r17, r111, r18, 0, r10);
        r15 = Math.max(r15, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        r16 = View.combineMeasuredStates(r16, this.mLogoView.getMeasuredState());
    L19:
        int r22 = getChildCount();
        int r112 = 0;
    L20:
        if (r112 >= r22) goto L28;
        View r113 = getChildAt(r112);
        if (((LayoutParams) r113.getLayoutParams()).mViewType != 0) goto L27;
        if (shouldLayout(r113) == false) goto L27;
        r111 = r111 + measureChildCollapseMargins(r113, r17, r111, r18, 0, r10);
        r15 = Math.max(r15, r113.getMeasuredHeight() + getVerticalMargins(r113));
        r16 = View.combineMeasuredStates(r16, r113.getMeasuredState());
    L27:
        r112 = r112 + 1;
        goto L20
    L28:
        int r23 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int r114 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView) == false) goto L31;
        measureChildCollapseMargins(this.mTitleTextView, r17, r111 + r114, r18, r23, r10);
        int r24 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        int r115 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        int r25 = View.combineMeasuredStates(r16, this.mTitleTextView.getMeasuredState());
        int r116 = r24;
    L33:
        if (shouldLayout(this.mSubtitleTextView) == false) goto L36;
        r116 = Math.max(r116, measureChildCollapseMargins(this.mSubtitleTextView, r17, r111 + r114, r18, r115 + r23, r10));
        r115 = r115 + (this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView));
        r25 = View.combineMeasuredStates(r25, this.mSubtitleTextView.getMeasuredState());
    L36:
        int r26 = Math.max(r15, r115);
        int r117 = (r111 + r116) + (getPaddingLeft() + getPaddingRight());
        int r27 = r26 + (getPaddingTop() + getPaddingBottom());
        int r28 = View.resolveSizeAndState(Math.max(r117, getSuggestedMinimumWidth()), r17, (-16777216) & r25);
        int r29 = View.resolveSizeAndState(Math.max(r27, getSuggestedMinimumHeight()), r18, r25 << 16);
        if (shouldCollapse() == true) goto L40;
        r12 = r29;
    L40:
        setMeasuredDimension(r28, r12);
        return;
    L31:
        r115 = 0;
        r25 = r16;
        r116 = 0;
        goto L33
    L12:
        r20 = 0;
        goto L13
    L5:
        r14 = 0;
        r15 = 0;
        r16 = 0;
        goto L7
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        ActionMenuView r12 = this.mMenuView;
        if (r12 == null) goto L9;
        MenuBuilder r13 = r12.peekMenu();
    L10:
        int r14 = r11.expandedMenuItemId;
        if (r14 == 0) goto L19;
        if (this.mExpandedMenuPresenter == null) goto L19;
        if (r13 == null) goto L19;
        MenuItem r15 = r13.findItem(r14);
        if (r15 == null) goto L19;
        r15.expandActionView();
    L19:
        if (r11.isOverflowOpen == false) goto L22;
        postShowOverflowMenu();
        return;
    L22:
        return;
    L9:
        r13 = null;
        goto L10
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r10) {
        if (Build.VERSION.SDK_INT < 17) goto L5;
        super.onRtlPropertiesChanged(r10);
    L5:
        ensureContentInsets();
        RtlSpacingHelper r11 = this.mContentInsets;
        boolean r12 = true;
        if (r10 == 1) goto L9;
        r12 = false;
    L9:
        r11.setDirection(r12);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter r11 = this.mExpandedMenuPresenter;
        if (r11 == null) goto L7;
        MenuItemImpl r12 = r11.mCurrentExpandedItem;
        if (r12 == null) goto L7;
        r10.expandedMenuItemId = r12.getItemId();
    L7:
        r10.isOverflowOpen = isOverflowMenuShowing();
        return r10;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r12 = super.onTouchEvent(r10);
        if (r11 != 0) goto L11;
        if (r12 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r11 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r11 != 3) goto L15;
        goto L14
    }

    void removeChildrenForExpandedActionView() {
        int r10 = getChildCount() - 1;
    L3:
        if (r10 < 0) goto L10;
        View r11 = getChildAt(r10);
        if (((LayoutParams) r11.getLayoutParams()).mViewType == 2) goto L9;
        if (r11 == this.mMenuView) goto L9;
        removeViewAt(r10);
        this.mHiddenViews.add(r11);
    L9:
        r10 = r10 - 1;
        goto L3
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void removeMenuProvider(@NonNull MenuProvider r10) {
        this.mMenuHostHelper.removeMenuProvider(r10);
    }

    public void setBackInvokedCallbackEnabled(boolean r10) {
        if (this.mBackInvokedCallbackEnabled == r10) goto L6;
        this.mBackInvokedCallbackEnabled = r10;
        updateBackInvokedCallbackState();
        return;
    }

    public void setCollapseContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getContext().getText(r10);
    L5:
        setCollapseContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setCollapseContentDescription(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        ensureCollapseButtonView();
    L5:
        ImageButton r11 = this.mCollapseButtonView;
        if (r11 == null) goto L9;
        r11.setContentDescription(r10);
        return;
    }

    public void setCollapseIcon(@DrawableRes int r10) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), r10));
    }

    public void setCollapseIcon(@Nullable Drawable r10) {
        if (r10 == null) goto L4;
        ensureCollapseButtonView();
        this.mCollapseButtonView.setImageDrawable(r10);
        return;
    L4:
        ImageButton r11 = this.mCollapseButtonView;
        if (r11 == null) goto L9;
        r11.setImageDrawable(this.mCollapseIcon);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean r10) {
        this.mCollapsible = r10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int r10) {
        if (r10 >= 0) goto L5;
        r10 = Integer.MIN_VALUE;
    L5:
        if (r10 == this.mContentInsetEndWithActions) goto L10;
        this.mContentInsetEndWithActions = r10;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetStartWithNavigation(int r10) {
        if (r10 >= 0) goto L5;
        r10 = Integer.MIN_VALUE;
    L5:
        if (r10 == this.mContentInsetStartWithNavigation) goto L10;
        this.mContentInsetStartWithNavigation = r10;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetsAbsolute(int r10, int r11) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r10, r11);
    }

    public void setContentInsetsRelative(int r10, int r11) {
        ensureContentInsets();
        this.mContentInsets.setRelative(r10, r11);
    }

    public void setLogo(@DrawableRes int r10) {
        setLogo(AppCompatResources.getDrawable(getContext(), r10));
    }

    public void setLogo(Drawable r10) {
        if (r10 == null) goto L6;
        ensureLogoView();
        if (isChildOrHidden(this.mLogoView) == true) goto L11;
        addSystemView(this.mLogoView, true);
    L11:
        ImageView r11 = this.mLogoView;
        if (r11 == null) goto L15;
        r11.setImageDrawable(r10);
        return;
    L15:
        return;
    L6:
        ImageView r12 = this.mLogoView;
        if (r12 == null) goto L11;
        if (isChildOrHidden(r12) == false) goto L11;
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
        goto L11
    }

    public void setLogoDescription(@StringRes int r10) {
        setLogoDescription(getContext().getText(r10));
    }

    public void setLogoDescription(CharSequence r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        ensureLogoView();
    L5:
        ImageView r11 = this.mLogoView;
        if (r11 == null) goto L9;
        r11.setContentDescription(r10);
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMenu(MenuBuilder r10, ActionMenuPresenter r11) {
        if (r10 == null) goto L4;
    L6:
        ensureMenuView();
        MenuBuilder r12 = this.mMenuView.peekMenu();
        if (r12 != r10) goto L9;
        return;
    L9:
        if (r12 == null) goto L12;
        r12.removeMenuPresenter(this.mOuterActionMenuPresenter);
        r12.removeMenuPresenter(this.mExpandedMenuPresenter);
    L12:
        if (this.mExpandedMenuPresenter != null) goto L14;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L14:
        r11.setExpandedActionViewsExclusive(true);
        if (r10 == null) goto L17;
        r10.addMenuPresenter(r11, this.mPopupContext);
        r10.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    L18:
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(r11);
        this.mOuterActionMenuPresenter = r11;
        updateBackInvokedCallbackState();
        return;
    L17:
        r11.initForMenu(this.mPopupContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
        r11.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
        goto L18
    L4:
        if (this.mMenuView != null) goto L6;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback r10, MenuBuilder.Callback r11) {
        this.mActionMenuPresenterCallback = r10;
        this.mMenuBuilderCallback = r11;
        ActionMenuView r12 = this.mMenuView;
        if (r12 == null) goto L6;
        r12.setMenuCallbacks(r10, r11);
        return;
    }

    public void setNavigationContentDescription(@StringRes int r10) {
        if (r10 == 0) goto L4;
        CharSequence r11 = getContext().getText(r10);
    L5:
        setNavigationContentDescription(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    public void setNavigationContentDescription(@Nullable CharSequence r10) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        ensureNavButtonView();
    L5:
        ImageButton r11 = this.mNavButtonView;
        if (r11 == null) goto L9;
        r11.setContentDescription(r10);
        TooltipCompat.setTooltipText(this.mNavButtonView, r10);
        return;
    }

    public void setNavigationIcon(@DrawableRes int r10) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), r10));
    }

    public void setNavigationIcon(@Nullable Drawable r10) {
        if (r10 == null) goto L6;
        ensureNavButtonView();
        if (isChildOrHidden(this.mNavButtonView) == true) goto L11;
        addSystemView(this.mNavButtonView, true);
    L11:
        ImageButton r11 = this.mNavButtonView;
        if (r11 == null) goto L15;
        r11.setImageDrawable(r10);
        return;
    L15:
        return;
    L6:
        ImageButton r12 = this.mNavButtonView;
        if (r12 == null) goto L11;
        if (isChildOrHidden(r12) == false) goto L11;
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
        goto L11
    }

    public void setNavigationOnClickListener(View.OnClickListener r10) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(r10);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r10) {
        this.mOnMenuItemClickListener = r10;
    }

    public void setOverflowIcon(@Nullable Drawable r10) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(r10);
    }

    public void setPopupTheme(@StyleRes int r10) {
        if (this.mPopupTheme == r10) goto L9;
        this.mPopupTheme = r10;
        if (r10 != 0) goto L7;
        this.mPopupContext = getContext();
        return;
    L7:
        this.mPopupContext = new ContextThemeWrapper(getContext(), r10);
        return;
    }

    public void setSubtitle(@StringRes int r10) {
        setSubtitle(getContext().getText(r10));
    }

    public void setSubtitle(CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        TextView r11 = this.mSubtitleTextView;
        if (r11 != null) goto L18;
    L20:
        TextView r12 = this.mSubtitleTextView;
        if (r12 == null) goto L23;
        r12.setText(r10);
    L23:
        this.mSubtitleText = r10;
        return;
    L18:
        if (isChildOrHidden(r11) == false) goto L20;
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
        goto L20
    L5:
        if (this.mSubtitleTextView != null) goto L13;
        Context r13 = getContext();
        AppCompatTextView r14 = new AppCompatTextView(r13);
        this.mSubtitleTextView = r14;
        r14.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r15 = this.mSubtitleTextAppearance;
        if (r15 == 0) goto L9;
        this.mSubtitleTextView.setTextAppearance(r13, r15);
    L9:
        ColorStateList r16 = this.mSubtitleTextColor;
        if (r16 == null) goto L13;
        this.mSubtitleTextView.setTextColor(r16);
    L13:
        if (isChildOrHidden(this.mSubtitleTextView) == true) goto L20;
        addSystemView(this.mSubtitleTextView, true);
        goto L20
    }

    public void setSubtitleTextAppearance(Context r10, @StyleRes int r11) {
        this.mSubtitleTextAppearance = r11;
        TextView r12 = this.mSubtitleTextView;
        if (r12 == null) goto L6;
        r12.setTextAppearance(r10, r11);
        return;
    }

    public void setSubtitleTextColor(@ColorInt int r10) {
        setSubtitleTextColor(ColorStateList.valueOf(r10));
    }

    public void setSubtitleTextColor(@NonNull ColorStateList r10) {
        this.mSubtitleTextColor = r10;
        TextView r11 = this.mSubtitleTextView;
        if (r11 == null) goto L6;
        r11.setTextColor(r10);
        return;
    }

    public void setTitle(@StringRes int r10) {
        setTitle(getContext().getText(r10));
    }

    public void setTitle(CharSequence r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        TextView r11 = this.mTitleTextView;
        if (r11 != null) goto L18;
    L20:
        TextView r12 = this.mTitleTextView;
        if (r12 == null) goto L23;
        r12.setText(r10);
    L23:
        this.mTitleText = r10;
        return;
    L18:
        if (isChildOrHidden(r11) == false) goto L20;
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
        goto L20
    L5:
        if (this.mTitleTextView != null) goto L13;
        Context r13 = getContext();
        AppCompatTextView r14 = new AppCompatTextView(r13);
        this.mTitleTextView = r14;
        r14.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r15 = this.mTitleTextAppearance;
        if (r15 == 0) goto L9;
        this.mTitleTextView.setTextAppearance(r13, r15);
    L9:
        ColorStateList r16 = this.mTitleTextColor;
        if (r16 == null) goto L13;
        this.mTitleTextView.setTextColor(r16);
    L13:
        if (isChildOrHidden(this.mTitleTextView) == true) goto L20;
        addSystemView(this.mTitleTextView, true);
        goto L20
    }

    public void setTitleMargin(int r10, int r11, int r12, int r13) {
        this.mTitleMarginStart = r10;
        this.mTitleMarginTop = r11;
        this.mTitleMarginEnd = r12;
        this.mTitleMarginBottom = r13;
        requestLayout();
    }

    public void setTitleMarginBottom(int r10) {
        this.mTitleMarginBottom = r10;
        requestLayout();
    }

    public void setTitleMarginEnd(int r10) {
        this.mTitleMarginEnd = r10;
        requestLayout();
    }

    public void setTitleMarginStart(int r10) {
        this.mTitleMarginStart = r10;
        requestLayout();
    }

    public void setTitleMarginTop(int r10) {
        this.mTitleMarginTop = r10;
        requestLayout();
    }

    public void setTitleTextAppearance(Context r10, @StyleRes int r11) {
        this.mTitleTextAppearance = r11;
        TextView r12 = this.mTitleTextView;
        if (r12 == null) goto L6;
        r12.setTextAppearance(r10, r11);
        return;
    }

    public void setTitleTextColor(@ColorInt int r10) {
        setTitleTextColor(ColorStateList.valueOf(r10));
    }

    public void setTitleTextColor(@NonNull ColorStateList r10) {
        this.mTitleTextColor = r10;
        TextView r11 = this.mTitleTextView;
        if (r11 == null) goto L6;
        r11.setTextColor(r10);
        return;
    }

    public boolean showOverflowMenu() {
        ActionMenuView r10 = this.mMenuView;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.showOverflowMenu() == false) goto L7;
        return true;
    }

    void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L26;
        OnBackInvokedDispatcher r10 = Api33Impl.findOnBackInvokedDispatcher(this);
        if (hasExpandedActionView() == false) goto L12;
        if (r10 == null) goto L12;
        if (ViewCompat.isAttachedToWindow(this) == false) goto L12;
        if (this.mBackInvokedCallbackEnabled == false) goto L12;
        boolean r11 = true;
    L13:
        if (r11 == true) goto L15;
    L20:
        if (r11 == true) goto L27;
        OnBackInvokedDispatcher r12 = this.mBackInvokedDispatcher;
        if (r12 == null) goto L28;
        Api33Impl.tryUnregisterOnBackInvokedCallback(r12, this.mBackInvokedCallback);
        r10 = null;
    L24:
        this.mBackInvokedDispatcher = r10;
        return;
    L28:
        return;
    L27:
        return;
    L15:
        if (this.mBackInvokedDispatcher != null) goto L20;
        if (this.mBackInvokedCallback != null) goto L19;
        this.mBackInvokedCallback = Api33Impl.newOnBackInvokedCallback(new a(this));
    L19:
        Api33Impl.tryRegisterOnBackInvokedCallback(r10, this.mBackInvokedCallback);
    L12:
        r11 = false;
        goto L13
    }
}
