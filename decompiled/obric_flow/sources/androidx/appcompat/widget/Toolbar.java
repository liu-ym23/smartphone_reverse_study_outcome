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
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
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
import kotlin.time.DurationKt;

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
    public static class Api33Impl {
        private Api33Impl() {
        }

        @Nullable
        @DoNotInline
        public static OnBackInvokedDispatcher findOnBackInvokedDispatcher(@NonNull View r5) {
            return r5.findOnBackInvokedDispatcher();
        }

        @NonNull
        @DoNotInline
        public static OnBackInvokedCallback newOnBackInvokedCallback(@NonNull final Runnable r5) {
            Objects.requireNonNull(r5);
            return new b(r5);
        }

        @DoNotInline
        public static void tryRegisterOnBackInvokedCallback(@NonNull Object r5, @NonNull Object r10) {
            ((OnBackInvokedDispatcher) r5).registerOnBackInvokedCallback(DurationKt.NANOS_IN_MILLIS, (OnBackInvokedCallback) r10);
        }

        @DoNotInline
        public static void tryUnregisterOnBackInvokedCallback(@NonNull Object r5, @NonNull Object r10) {
            ((OnBackInvokedDispatcher) r5).unregisterOnBackInvokedCallback((OnBackInvokedCallback) r10);
        }
    }

    public class ExpandedActionViewMenuPresenter implements MenuPresenter {
        MenuItemImpl mCurrentExpandedItem;
        MenuBuilder mMenu;
        final /* synthetic */ Toolbar this$0;

        public ExpandedActionViewMenuPresenter(Toolbar r5) {
            this.this$0 = r5;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean collapseItemActionView(MenuBuilder r5, MenuItemImpl r10) {
            KeyEvent.Callback r11 = this.this$0.mExpandedActionView;
            if ((r11 instanceof CollapsibleActionView) == false) goto L5;
            ((CollapsibleActionView) r11).onActionViewCollapsed();
        L5:
            Toolbar r12 = this.this$0;
            r12.removeView(r12.mExpandedActionView);
            Toolbar r13 = this.this$0;
            r13.removeView(r13.mCollapseButtonView);
            Toolbar r14 = this.this$0;
            r14.mExpandedActionView = null;
            r14.addChildrenForExpandedActionView();
            this.mCurrentExpandedItem = null;
            this.this$0.requestLayout();
            r10.setActionViewExpanded(false);
            this.this$0.updateBackInvokedCallbackState();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean expandItemActionView(MenuBuilder r5, MenuItemImpl r10) {
            this.this$0.ensureCollapseButtonView();
            ViewParent r11 = this.this$0.mCollapseButtonView.getParent();
            Toolbar r12 = this.this$0;
            if (r11 != r12) goto L5;
        L8:
            Toolbar r13 = this.this$0;
            r13.mExpandedActionView = r10.getActionView();
            this.mCurrentExpandedItem = r10;
            ViewParent r14 = this.this$0.mExpandedActionView.getParent();
            Toolbar r15 = this.this$0;
            if (r14 != r15) goto L11;
        L14:
            this.this$0.removeChildrenForExpandedActionView();
            this.this$0.requestLayout();
            r10.setActionViewExpanded(true);
            KeyEvent.Callback r16 = this.this$0.mExpandedActionView;
            if ((r16 instanceof CollapsibleActionView) == false) goto L17;
            ((CollapsibleActionView) r16).onActionViewExpanded();
        L17:
            this.this$0.updateBackInvokedCallbackState();
            return true;
        L11:
            if ((r14 instanceof ViewGroup) == false) goto L13;
            ((ViewGroup) r14).removeView(r15.mExpandedActionView);
        L13:
            LayoutParams r17 = this.this$0.generateDefaultLayoutParams();
            Toolbar r18 = this.this$0;
            r17.gravity = (r18.mButtonGravity & 112) | GravityCompat.START;
            r17.mViewType = 2;
            r18.mExpandedActionView.setLayoutParams(r17);
            Toolbar r19 = this.this$0;
            r19.addView(r19.mExpandedActionView);
            goto L14
        L5:
            if ((r11 instanceof ViewGroup) == false) goto L7;
            ((ViewGroup) r11).removeView(r12.mCollapseButtonView);
        L7:
            Toolbar r20 = this.this$0;
            r20.addView(r20.mCollapseButtonView);
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
        public MenuView getMenuView(ViewGroup r5) {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void initForMenu(Context r5, MenuBuilder r10) {
            MenuBuilder r11 = this.mMenu;
            if (r11 == null) goto L7;
            MenuItemImpl r12 = this.mCurrentExpandedItem;
            if (r12 == null) goto L7;
            r11.collapseItemActionView(r12);
        L7:
            this.mMenu = r10;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onCloseMenu(MenuBuilder r5, boolean r10) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void onRestoreInstanceState(Parcelable r5) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public Parcelable onSaveInstanceState() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public boolean onSubMenuSelected(SubMenuBuilder r5) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void setCallback(MenuPresenter.Callback r5) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public void updateMenuView(boolean r5) {
            if (this.mCurrentExpandedItem == null) goto L16;
            MenuBuilder r10 = this.mMenu;
            if (r10 == null) goto L12;
            int r11 = r10.size();
            int r12 = 0;
        L7:
            if (r12 >= r11) goto L12;
            if (this.mMenu.getItem(r12) == this.mCurrentExpandedItem) goto L17;
            r12 = r12 + 1;
            goto L7
        L17:
            return;
        L12:
            collapseItemActionView(this.mMenu, this.mCurrentExpandedItem);
            return;
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {
        static final int CUSTOM = 0;
        static final int EXPANDED = 2;
        static final int SYSTEM = 1;
        int mViewType;

        public LayoutParams(@NonNull Context r5, AttributeSet r10) {
            super(r5, r10);
            this.mViewType = 0;
        }

        public void copyMarginsFromCompat(ViewGroup.MarginLayoutParams r5) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = r5.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = r5.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = r5.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = r5.bottomMargin;
        }

        public LayoutParams(int r5, int r10) {
            super(r5, r10);
            this.mViewType = 0;
            this.gravity = 8388627;
        }

        public LayoutParams(int r5, int r10, int r11) {
            super(r5, r10);
            this.mViewType = 0;
            this.gravity = r11;
        }

        public LayoutParams(int r5) {
            this(-2, -1, r5);
        }

        public LayoutParams(LayoutParams r5) {
            super(r5);
            this.mViewType = 0;
            this.mViewType = r5.mViewType;
        }

        public LayoutParams(ActionBar.LayoutParams r5) {
            super(r5);
            this.mViewType = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r5) {
            super(r5);
            this.mViewType = 0;
            copyMarginsFromCompat(r5);
        }

        public LayoutParams(ViewGroup.LayoutParams r5) {
            super(r5);
            this.mViewType = 0;
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem r5);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int expandedMenuItemId;
        boolean isOverflowOpen;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcel r5) {
            this(r5, null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r5, int r10) {
            super.writeToParcel(r5, r10);
            r5.writeInt(this.expandedMenuItemId);
            r5.writeInt(this.isOverflowOpen ? 1 : 0);
        }

        public SavedState(Parcel r5, ClassLoader r10) {
            super(r5, r10);
            this.expandedMenuItemId = r5.readInt();
            if (r5.readInt() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.isOverflowOpen = r11;
            return;
        L5:
            r11 = false;
            goto L6
        }

        public SavedState(Parcelable r5) {
            super(r5);
        }
    }

    public Toolbar(@NonNull Context r5) {
        this(r5, null);
    }

    private void addCustomViewsWithGravity(List<View> r10, int r11) {
        int r5 = 0;
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r12 = true;
    L6:
        int r13 = getChildCount();
        int r14 = GravityCompat.getAbsoluteGravity(r11, ViewCompat.getLayoutDirection(this));
        r10.clear();
        if (r12 == false) goto L18;
        int r15 = r13 - 1;
    L9:
        if (r15 < 0) goto L27;
        View r16 = getChildAt(r15);
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        if (r17.mViewType != 0) goto L17;
        if (shouldLayout(r16) == false) goto L17;
        if (getChildHorizontalGravity(r17.gravity) != r14) goto L17;
        r10.add(r16);
    L17:
        r15 = r15 - 1;
        goto L9
    L27:
        return;
    L18:
        if (r5 >= r13) goto L38;
        View r18 = getChildAt(r5);
        LayoutParams r19 = (LayoutParams) r18.getLayoutParams();
        if (r19.mViewType != 0) goto L26;
        if (shouldLayout(r18) == false) goto L26;
        if (getChildHorizontalGravity(r19.gravity) != r14) goto L26;
        r10.add(r18);
    L26:
        r5 = r5 + 1;
        goto L18
    L38:
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void addSystemView(View r5, boolean r10) {
        ViewGroup.LayoutParams r11 = r5.getLayoutParams();
        if (r11 != null) goto L6;
        LayoutParams r12 = generateDefaultLayoutParams();
    L9:
        r12.mViewType = 1;
        if (r10 == true) goto L12;
    L14:
        addView(r5, r12);
        return;
    L12:
        if (this.mExpandedActionView == null) goto L14;
        r5.setLayoutParams(r12);
        this.mHiddenViews.add(r5);
        return;
    L6:
        if (checkLayoutParams(r11) == true) goto L8;
        r12 = generateLayoutParams(r11);
        goto L9
    L8:
        r12 = (LayoutParams) r11;
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
        MenuBuilder r5 = (MenuBuilder) this.mMenuView.getMenu();
        if (this.mExpandedMenuPresenter != null) goto L7;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L7:
        this.mMenuView.setExpandedActionViewsExclusive(true);
        r5.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
        updateBackInvokedCallbackState();
        return;
    }

    private void ensureMenuView() {
        if (this.mMenuView != null) goto L6;
        ActionMenuView r5 = new ActionMenuView(getContext());
        this.mMenuView = r5;
        r5.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setOnMenuItemClickListener(this.mMenuViewItemClickListener);
        this.mMenuView.setMenuCallbacks(this.mActionMenuPresenterCallback, new AnonymousClass3(this));
        LayoutParams r10 = generateDefaultLayoutParams();
        r10.gravity = (this.mButtonGravity & 112) | GravityCompat.END;
        this.mMenuView.setLayoutParams(r10);
        addSystemView(this.mMenuView, false);
        return;
    }

    private void ensureNavButtonView() {
        if (this.mNavButtonView != null) goto L6;
        this.mNavButtonView = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        LayoutParams r5 = generateDefaultLayoutParams();
        r5.gravity = (this.mButtonGravity & 112) | GravityCompat.START;
        this.mNavButtonView.setLayoutParams(r5);
        return;
    }

    private int getChildHorizontalGravity(int r5) {
        int r10 = ViewCompat.getLayoutDirection(this);
        int r11 = GravityCompat.getAbsoluteGravity(r5, r10) & 7;
        if (r11 != 1) goto L5;
    L11:
        return r11;
    L5:
        if (r11 == 3) goto L11;
        if (r11 == 5) goto L11;
        if (r10 == 1) goto L10;
        return 3;
    L10:
        return 5;
    }

    private int getChildTop(View r10, int r11) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        int r12 = r10.getMeasuredHeight();
        if (r11 <= 0) goto L5;
        int r13 = (r12 - r11) / 2;
    L6:
        int r14 = getChildVerticalGravity(r5.gravity);
        if (r14 == 48) goto L21;
        if (r14 == 80) goto L19;
        int r15 = getPaddingTop();
        int r16 = getPaddingBottom();
        int r17 = getHeight();
        int r18 = (((r17 - r15) - r16) - r12) / 2;
        int r19 = ((ViewGroup.MarginLayoutParams) r5).topMargin;
        if (r18 >= r19) goto L13;
        r18 = r19;
    L17:
        return r15 + r18;
    L13:
        int r20 = (((r17 - r16) - r12) - r18) - r15;
        int r21 = ((ViewGroup.MarginLayoutParams) r5).bottomMargin;
        if (r20 >= r21) goto L17;
        r18 = Math.max(0, r18 - (r21 - r20));
        goto L17
    L19:
        return (((getHeight() - getPaddingBottom()) - r12) - ((ViewGroup.MarginLayoutParams) r5).bottomMargin) - r13;
    L21:
        return getPaddingTop() - r13;
    L5:
        r13 = 0;
        goto L6
    }

    private int getChildVerticalGravity(int r5) {
        int r10 = r5 & 112;
        if (r10 != 16) goto L5;
    L10:
        return r10;
    L5:
        if (r10 == 48) goto L10;
        if (r10 == 80) goto L10;
        return this.mGravity & 112;
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> r5 = new ArrayList();
        Menu r10 = getMenu();
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L6;
        r5.add(r10.getItem(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        return r5;
    }

    private int getHorizontalMargins(View r5) {
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        int r11 = MarginLayoutParamsCompat.getMarginStart(r10);
        return MarginLayoutParamsCompat.getMarginEnd(r10) + r11;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    private int getVerticalMargins(View r5) {
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        return r10.topMargin + r10.bottomMargin;
    }

    private int getViewListMeasuredWidth(List<View> r10, int[] r11) {
        int r5 = r11[0];
        int r12 = r11[1];
        int r13 = r10.size();
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L5;
        View r16 = r10.get(r14);
        LayoutParams r17 = (LayoutParams) r16.getLayoutParams();
        int r18 = ((ViewGroup.MarginLayoutParams) r17).leftMargin - r5;
        int r19 = ((ViewGroup.MarginLayoutParams) r17).rightMargin - r12;
        int r20 = Math.max(0, r18);
        int r21 = Math.max(0, r19);
        int r22 = Math.max(0, -r18);
        int r23 = Math.max(0, -r19);
        r15 = r15 + ((r16.getMeasuredWidth() + r20) + r21);
        r14 = r14 + 1;
        r12 = r23;
        r5 = r22;
        goto L3
    L5:
        return r15;
    }

    private boolean isChildOrHidden(View r5) {
        if (r5.getParent() != this) goto L5;
    L8:
        return true;
    L5:
        if (this.mHiddenViews.contains(r5) == true) goto L8;
        return false;
    }

    private int layoutChildLeft(View r5, int r10, int[] r11, int r12) {
        LayoutParams r13 = (LayoutParams) r5.getLayoutParams();
        int r14 = ((ViewGroup.MarginLayoutParams) r13).leftMargin - r11[0];
        int r15 = Math.max(0, r14) + r10;
        r11[0] = Math.max(0, -r14);
        int r16 = getChildTop(r5, r12);
        int r17 = r5.getMeasuredWidth();
        r5.layout(r15, r16, r15 + r17, r5.getMeasuredHeight() + r16);
        return (r17 + ((ViewGroup.MarginLayoutParams) r13).rightMargin) + r15;
    }

    private int layoutChildRight(View r10, int r11, int[] r12, int r13) {
        LayoutParams r5 = (LayoutParams) r10.getLayoutParams();
        int r14 = ((ViewGroup.MarginLayoutParams) r5).rightMargin - r12[1];
        int r15 = r11 - Math.max(0, r14);
        r12[1] = Math.max(0, -r14);
        int r16 = getChildTop(r10, r13);
        int r17 = r10.getMeasuredWidth();
        r10.layout(r15 - r17, r16, r15, r10.getMeasuredHeight() + r16);
        return r15 - (r17 + ((ViewGroup.MarginLayoutParams) r5).leftMargin);
    }

    private int measureChildCollapseMargins(View r10, int r11, int r12, int r13, int r14, int[] r15) {
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        int r16 = r5.leftMargin - r15[0];
        int r17 = r5.rightMargin - r15[1];
        int r18 = Math.max(0, r16);
        int r19 = Math.max(0, r17) + r18;
        r15[0] = Math.max(0, -r16);
        r15[1] = Math.max(0, -r17);
        int r110 = getPaddingLeft();
        int r20 = ViewGroup.getChildMeasureSpec(r11, ((getPaddingRight() + r110) + r19) + r12, r5.width);
        int r111 = getPaddingTop();
        r10.measure(r20, ViewGroup.getChildMeasureSpec(r13, (((getPaddingBottom() + r111) + r5.topMargin) + r5.bottomMargin) + r14, r5.height));
        return r10.getMeasuredWidth() + r19;
    }

    private void measureChildConstrained(View r5, int r10, int r11, int r12, int r13, int r14) {
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r5.getLayoutParams();
        int r16 = getPaddingLeft();
        int r17 = ViewGroup.getChildMeasureSpec(r10, (((getPaddingRight() + r16) + r15.leftMargin) + r15.rightMargin) + r11, r15.width);
        int r18 = getPaddingTop();
        int r19 = ViewGroup.getChildMeasureSpec(r12, (((getPaddingBottom() + r18) + r15.topMargin) + r15.bottomMargin) + r13, r15.height);
        int r20 = View.MeasureSpec.getMode(r19);
        if (r20 == 1073741824) goto L8;
        if (r14 < 0) goto L8;
        if (r20 == 0) goto L7;
        r14 = Math.min(View.MeasureSpec.getSize(r19), r14);
    L7:
        r19 = View.MeasureSpec.makeMeasureSpec(r14, BasicMeasure.EXACTLY);
    L8:
        r5.measure(r17, r19);
    }

    private void onCreateMenu() {
        Menu r5 = getMenu();
        ArrayList<MenuItem> r10 = getCurrentMenuItems();
        this.mMenuHostHelper.onCreateMenu(r5, getMenuInflater());
        ArrayList<MenuItem> r11 = getCurrentMenuItems();
        r11.removeAll(r10);
        this.mProvidedMenuItems = r11;
    }

    private void postShowOverflowMenu() {
        removeCallbacks(this.mShowOverflowMenuRunnable);
        post(this.mShowOverflowMenuRunnable);
    }

    private boolean shouldCollapse() {
        if (this.mCollapsible == true) goto L5;
        return false;
    L5:
        int r5 = getChildCount();
        int r10 = 0;
    L6:
        if (r10 >= r5) goto L15;
        View r11 = getChildAt(r10);
        if (shouldLayout(r11) == false) goto L14;
        if (r11.getMeasuredWidth() <= 0) goto L14;
        if (r11.getMeasuredHeight() <= 0) goto L14;
        return false;
    L14:
        r10 = r10 + 1;
        goto L6
    L15:
        return true;
    }

    private boolean shouldLayout(View r5) {
        if (r5 != null) goto L4;
    L8:
        return false;
    L4:
        if (r5.getParent() != this) goto L8;
        if (r5.getVisibility() == 8) goto L8;
        return true;
    }

    public void addChildrenForExpandedActionView() {
        int r5 = this.mHiddenViews.size() - 1;
    L3:
        if (r5 < 0) goto L5;
        addView(this.mHiddenViews.get(r5));
        r5 = r5 - 1;
        goto L3
    L5:
        this.mHiddenViews.clear();
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r5) {
        this.mMenuHostHelper.addMenuProvider(r5);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean canShowOverflowMenu() {
        if (getVisibility() != 0) goto L9;
        ActionMenuView r5 = this.mMenuView;
        if (r5 == null) goto L9;
        if (r5.isOverflowReserved() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r5) {
        if (super.checkLayoutParams(r5) == true) goto L5;
    L7:
        return false;
    L5:
        if ((r5 instanceof LayoutParams) == false) goto L7;
        return true;
    }

    public void collapseActionView() {
        ExpandedActionViewMenuPresenter r5 = this.mExpandedMenuPresenter;
        if (r5 != null) goto L5;
        MenuItemImpl r10 = null;
    L6:
        if (r10 == null) goto L9;
        r10.collapseActionView();
        return;
    L9:
        return;
    L5:
        r10 = r5.mCurrentExpandedItem;
        goto L6
    }

    public void dismissPopupMenus() {
        ActionMenuView r5 = this.mMenuView;
        if (r5 == null) goto L6;
        r5.dismissPopupMenus();
        return;
    }

    public void ensureCollapseButtonView() {
        if (this.mCollapseButtonView != null) goto L6;
        AppCompatImageButton r5 = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
        this.mCollapseButtonView = r5;
        r5.setImageDrawable(this.mCollapseIcon);
        this.mCollapseButtonView.setContentDescription(this.mCollapseDescription);
        LayoutParams r10 = generateDefaultLayoutParams();
        r10.gravity = (this.mButtonGravity & 112) | GravityCompat.START;
        r10.mViewType = 2;
        this.mCollapseButtonView.setLayoutParams(r10);
        this.mCollapseButtonView.setOnClickListener(new AnonymousClass4(this));
        return;
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r5) {
        return generateLayoutParams(r5);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        ImageButton r5 = this.mCollapseButtonView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getContentDescription();
    }

    @Nullable
    public Drawable getCollapseIcon() {
        ImageButton r5 = this.mCollapseButtonView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getDrawable();
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper r5 = this.mContentInsets;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getEnd();
    }

    public int getContentInsetEndWithActions() {
        int r5 = this.mContentInsetEndWithActions;
        if (r5 == Integer.MIN_VALUE) goto L6;
        return r5;
    L6:
        return getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper r5 = this.mContentInsets;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getLeft();
    }

    public int getContentInsetRight() {
        RtlSpacingHelper r5 = this.mContentInsets;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getRight();
    }

    public int getContentInsetStart() {
        RtlSpacingHelper r5 = this.mContentInsets;
        if (r5 != null) goto L7;
        return 0;
    L7:
        return r5.getStart();
    }

    public int getContentInsetStartWithNavigation() {
        int r5 = this.mContentInsetStartWithNavigation;
        if (r5 == Integer.MIN_VALUE) goto L6;
        return r5;
    L6:
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        ActionMenuView r5 = this.mMenuView;
        if (r5 == null) goto L10;
        MenuBuilder r10 = r5.peekMenu();
        if (r10 == null) goto L10;
        if (r10.hasVisibleItems() == false) goto L10;
        return Math.max(getContentInsetEnd(), Math.max(this.mContentInsetEndWithActions, 0));
    L10:
        return getContentInsetEnd();
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
        ImageView r5 = this.mLogoView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getDrawable();
    }

    public CharSequence getLogoDescription() {
        ImageView r5 = this.mLogoView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getContentDescription();
    }

    public Menu getMenu() {
        ensureMenu();
        return this.mMenuView.getMenu();
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public View getNavButtonView() {
        return this.mNavButtonView;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        ImageButton r5 = this.mNavButtonView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getContentDescription();
    }

    @Nullable
    public Drawable getNavigationIcon() {
        ImageButton r5 = this.mNavButtonView;
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.getDrawable();
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.mOuterActionMenuPresenter;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        ensureMenu();
        return this.mMenuView.getOverflowIcon();
    }

    public Context getPopupContext() {
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
    public final TextView getSubtitleTextView() {
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
    public final TextView getTitleTextView() {
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
        ExpandedActionViewMenuPresenter r5 = this.mExpandedMenuPresenter;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.mCurrentExpandedItem == null) goto L7;
        return true;
    }

    public boolean hideOverflowMenu() {
        ActionMenuView r5 = this.mMenuView;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.hideOverflowMenu() == false) goto L7;
        return true;
    }

    public void inflateMenu(@MenuRes int r5) {
        getMenuInflater().inflate(r5, getMenu());
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void invalidateMenu() {
        Iterator<MenuItem> r5 = this.mProvidedMenuItems.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        MenuItem r10 = r5.next();
        getMenu().removeItem(r10.getItemId());
        goto L4
    L6:
        onCreateMenu();
    }

    public boolean isBackInvokedCallbackEnabled() {
        return this.mBackInvokedCallbackEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isOverflowMenuShowPending() {
        ActionMenuView r5 = this.mMenuView;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isOverflowMenuShowPending() == false) goto L7;
        return true;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuView r5 = this.mMenuView;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isOverflowMenuShowing() == false) goto L7;
        return true;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        TextView r5 = this.mTitleTextView;
        if (r5 != null) goto L5;
        return false;
    L5:
        Layout r10 = r5.getLayout();
        if (r10 != null) goto L8;
        return false;
    L8:
        int r11 = r10.getLineCount();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L15;
        if (r10.getEllipsisCount(r12) > 0) goto L12;
        r12 = r12 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateBackInvokedCallbackState();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mShowOverflowMenuRunnable);
        updateBackInvokedCallbackState();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent r10) {
        int r5 = r10.getActionMasked();
        if (r5 != 9) goto L6;
        this.mEatingHover = false;
    L6:
        if (this.mEatingHover == true) goto L12;
        boolean r11 = super.onHoverEvent(r10);
        if (r5 != 9) goto L12;
        if (r11 == true) goto L12;
        this.mEatingHover = true;
    L12:
        if (r5 != 10) goto L14;
    L15:
        this.mEatingHover = false;
    L16:
        return true;
    L14:
        if (r5 != 3) goto L16;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r20, int r21, int r22, int r23, int r24) {
        if (ViewCompat.getLayoutDirection(this) != 1) goto L5;
        boolean r5 = true;
    L6:
        int r10 = getWidth();
        int r11 = getHeight();
        int r12 = getPaddingLeft();
        int r13 = getPaddingRight();
        int r14 = getPaddingTop();
        int r15 = getPaddingBottom();
        int r16 = r10 - r13;
        int[] r17 = this.mTempMargins;
        r17[1] = 0;
        r17[0] = 0;
        int r18 = ViewCompat.getMinimumHeight(this);
        if (r18 < 0) goto L9;
        int r19 = Math.min(r18, r24 - r22);
    L11:
        if (shouldLayout(this.mNavButtonView) == false) goto L16;
        if (r5 == false) goto L14;
        int r110 = layoutChildRight(this.mNavButtonView, r16, r17, r19);
        int r111 = r12;
    L18:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L23;
        if (r5 == false) goto L21;
        r110 = layoutChildRight(this.mCollapseButtonView, r110, r17, r19);
        goto L23
    L21:
        r111 = layoutChildLeft(this.mCollapseButtonView, r111, r17, r19);
    L23:
        if (shouldLayout(this.mMenuView) == false) goto L27;
        if (r5 == false) goto L26;
        r111 = layoutChildLeft(this.mMenuView, r111, r17, r19);
        goto L27
    L26:
        r110 = layoutChildRight(this.mMenuView, r110, r17, r19);
    L27:
        int r112 = getCurrentContentInsetLeft();
        int r113 = getCurrentContentInsetRight();
        r17[0] = Math.max(0, r112 - r111);
        r17[1] = Math.max(0, r113 - (r16 - r110));
        int r25 = Math.max(r111, r112);
        int r114 = Math.min(r110, r16 - r113);
        if (shouldLayout(this.mExpandedActionView) == false) goto L33;
        if (r5 == false) goto L31;
        r114 = layoutChildRight(this.mExpandedActionView, r114, r17, r19);
        goto L33
    L31:
        r25 = layoutChildLeft(this.mExpandedActionView, r25, r17, r19);
    L33:
        if (shouldLayout(this.mLogoView) == false) goto L37;
        if (r5 == false) goto L36;
        r114 = layoutChildRight(this.mLogoView, r114, r17, r19);
        goto L37
    L36:
        r25 = layoutChildLeft(this.mLogoView, r25, r17, r19);
    L37:
        boolean r115 = shouldLayout(this.mTitleTextView);
        boolean r116 = shouldLayout(this.mSubtitleTextView);
        if (r115 == false) goto L40;
        LayoutParams r117 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r26 = ((ViewGroup.MarginLayoutParams) r117).bottomMargin + (this.mTitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r117).topMargin);
    L41:
        if (r116 == false) goto L44;
        LayoutParams r27 = (LayoutParams) this.mSubtitleTextView.getLayoutParams();
        r26 = r26 + ((this.mSubtitleTextView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r27).topMargin) + ((ViewGroup.MarginLayoutParams) r27).bottomMargin);
    L44:
        if (r115 == true) goto L49;
        if (r116 == true) goto L49;
        int r118 = r12;
        r19 = r19;
    L48:
        int r28 = 0;
    L105:
        addCustomViewsWithGravity(this.mTempViews, 3);
        int r29 = this.mTempViews.size();
        int r30 = r25;
        int r31 = r28;
    L106:
        if (r31 >= r29) goto L108;
        r30 = layoutChildLeft(this.mTempViews.get(r31), r30, r17, r19);
        r31 = r31 + 1;
        goto L106
    L108:
        int r119 = r19;
        addCustomViewsWithGravity(this.mTempViews, 5);
        int r32 = this.mTempViews.size();
        int r33 = r28;
    L109:
        if (r33 >= r32) goto L111;
        r114 = layoutChildRight(this.mTempViews.get(r33), r114, r17, r119);
        r33 = r33 + 1;
        goto L109
    L111:
        addCustomViewsWithGravity(this.mTempViews, 1);
        int r34 = getViewListMeasuredWidth(this.mTempViews, r17);
        int r35 = ((((r10 - r118) - r13) / 2) + r118) - (r34 / 2);
        int r36 = r34 + r35;
        if (r35 < r30) goto L117;
        if (r36 <= r114) goto L116;
        r30 = r35 - (r36 - r114);
        goto L117
    L116:
        r30 = r35;
    L117:
        int r37 = this.mTempViews.size();
    L118:
        if (r28 >= r37) goto L120;
        r30 = layoutChildLeft(this.mTempViews.get(r28), r30, r17, r119);
        r28 = r28 + 1;
        goto L118
    L120:
        this.mTempViews.clear();
        return;
    L49:
        if (r115 == false) goto L51;
        TextView r38 = this.mTitleTextView;
    L52:
        if (r116 == false) goto L54;
        TextView r39 = this.mSubtitleTextView;
    L55:
        LayoutParams r40 = (LayoutParams) r38.getLayoutParams();
        LayoutParams r41 = (LayoutParams) r39.getLayoutParams();
        if (r115 == true) goto L58;
    L59:
        if (r116 == true) goto L61;
    L63:
        boolean r120 = false;
    L64:
        int r121 = this.mGravity & 112;
        r118 = r12;
        if (r121 != 48) goto L67;
        int r42 = (getPaddingTop() + ((ViewGroup.MarginLayoutParams) r40).topMargin) + this.mTitleMarginTop;
    L77:
        if (r5 == false) goto L92;
        if (r120 == false) goto L81;
        int r43 = this.mTitleMarginStart;
    L82:
        int r44 = r43 - r17[1];
        r114 = r114 - Math.max(0, r44);
        r17[1] = Math.max(0, -r44);
        if (r115 == false) goto L85;
        LayoutParams r45 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r46 = r114 - this.mTitleTextView.getMeasuredWidth();
        int r47 = this.mTitleTextView.getMeasuredHeight() + r42;
        this.mTitleTextView.layout(r46, r42, r114, r47);
        int r48 = r46 - this.mTitleMarginEnd;
        r42 = r47 + ((ViewGroup.MarginLayoutParams) r45).bottomMargin;
    L86:
        if (r116 == false) goto L88;
        int r49 = r42 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        this.mSubtitleTextView.layout(r114 - this.mSubtitleTextView.getMeasuredWidth(), r49, r114, this.mSubtitleTextView.getMeasuredHeight() + r49);
        int r50 = r114 - this.mTitleMarginEnd;
    L89:
        if (r120 == false) goto L91;
        r114 = Math.min(r48, r50);
    L91:
        r25 = r25;
        goto L48
    L88:
        r50 = r114;
        goto L89
    L85:
        r48 = r114;
        goto L86
    L81:
        r43 = 0;
        goto L82
    L92:
        if (r120 == false) goto L95;
        int r51 = this.mTitleMarginStart;
    L94:
        r28 = 0;
        int r52 = r51 - r17[0];
        r25 = Math.max(0, r52) + r25;
        r17[0] = Math.max(0, -r52);
        if (r115 == false) goto L99;
        LayoutParams r53 = (LayoutParams) this.mTitleTextView.getLayoutParams();
        int r54 = this.mTitleTextView.getMeasuredWidth() + r25;
        int r55 = this.mTitleTextView.getMeasuredHeight() + r42;
        this.mTitleTextView.layout(r25, r42, r54, r55);
        int r56 = r54 + this.mTitleMarginEnd;
        r42 = r55 + ((ViewGroup.MarginLayoutParams) r53).bottomMargin;
    L100:
        if (r116 == false) goto L102;
        int r57 = r42 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) this.mSubtitleTextView.getLayoutParams())).topMargin;
        int r58 = this.mSubtitleTextView.getMeasuredWidth() + r25;
        this.mSubtitleTextView.layout(r25, r57, r58, this.mSubtitleTextView.getMeasuredHeight() + r57);
        int r59 = r58 + this.mTitleMarginEnd;
    L103:
        if (r120 == false) goto L105;
        r25 = Math.max(r56, r59);
        goto L105
    L102:
        r59 = r25;
        goto L103
    L99:
        r56 = r25;
        goto L100
    L95:
        r51 = 0;
        goto L94
    L67:
        if (r121 == 80) goto L75;
        int r60 = (((r11 - r14) - r15) - r26) / 2;
        int r122 = ((ViewGroup.MarginLayoutParams) r40).topMargin;
        int r123 = this.mTitleMarginTop;
        if (r60 >= (r122 + r123)) goto L71;
        r60 = r122 + r123;
    L74:
        r42 = r14 + r60;
        goto L77
    L71:
        int r61 = (((r11 - r15) - r26) - r60) - r14;
        int r62 = ((ViewGroup.MarginLayoutParams) r40).bottomMargin;
        int r63 = this.mTitleMarginBottom;
        if (r61 >= (r62 + r63)) goto L74;
        r60 = Math.max(0, r60 - ((((ViewGroup.MarginLayoutParams) r41).bottomMargin + r63) - r61));
        goto L74
    L75:
        r42 = (((r11 - r15) - ((ViewGroup.MarginLayoutParams) r41).bottomMargin) - this.mTitleMarginBottom) - r26;
        goto L77
    L61:
        if (this.mSubtitleTextView.getMeasuredWidth() <= 0) goto L63;
    L62:
        r120 = true;
        goto L64
    L58:
        if (this.mTitleTextView.getMeasuredWidth() > 0) goto L62;
    L54:
        r39 = this.mTitleTextView;
        goto L55
    L51:
        r38 = this.mSubtitleTextView;
        goto L52
    L40:
        r26 = 0;
        goto L41
    L14:
        r111 = layoutChildLeft(this.mNavButtonView, r12, r17, r19);
    L15:
        r110 = r16;
        goto L18
    L16:
        r111 = r12;
        goto L15
    L9:
        r19 = 0;
        goto L11
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r17, int r18) {
        int[] r10 = this.mTempMargins;
        boolean r11 = ViewUtils.isLayoutRtl(this);
        int r12 = 0;
        int r13 = !r11 ? 1 : 0;
        if (shouldLayout(this.mNavButtonView) == false) goto L5;
        measureChildConstrained(this.mNavButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        int r5 = this.mNavButtonView.getMeasuredWidth() + getHorizontalMargins(this.mNavButtonView);
        int r14 = Math.max(0, this.mNavButtonView.getMeasuredHeight() + getVerticalMargins(this.mNavButtonView));
        int r15 = View.combineMeasuredStates(0, this.mNavButtonView.getMeasuredState());
    L7:
        if (shouldLayout(this.mCollapseButtonView) == false) goto L9;
        measureChildConstrained(this.mCollapseButtonView, r17, 0, r18, 0, this.mMaxButtonHeight);
        r5 = this.mCollapseButtonView.getMeasuredWidth() + getHorizontalMargins(this.mCollapseButtonView);
        r14 = Math.max(r14, this.mCollapseButtonView.getMeasuredHeight() + getVerticalMargins(this.mCollapseButtonView));
        r15 = View.combineMeasuredStates(r15, this.mCollapseButtonView.getMeasuredState());
    L9:
        int r16 = getCurrentContentInsetStart();
        int r19 = Math.max(r16, r5);
        r10[r11 ? 1 : 0] = Math.max(0, r16 - r5);
        if (shouldLayout(this.mMenuView) == false) goto L12;
        measureChildConstrained(this.mMenuView, r17, r19, r18, 0, this.mMaxButtonHeight);
        int r20 = this.mMenuView.getMeasuredWidth() + getHorizontalMargins(this.mMenuView);
        r14 = Math.max(r14, this.mMenuView.getMeasuredHeight() + getVerticalMargins(this.mMenuView));
        r15 = View.combineMeasuredStates(r15, this.mMenuView.getMeasuredState());
    L13:
        int r21 = getCurrentContentInsetEnd();
        int r22 = Math.max(r21, r20) + r19;
        r10[r13] = Math.max(0, r21 - r20);
        if (shouldLayout(this.mExpandedActionView) == false) goto L17;
        r22 = r22 + measureChildCollapseMargins(this.mExpandedActionView, r17, r22, r18, 0, r10);
        r14 = Math.max(r14, this.mExpandedActionView.getMeasuredHeight() + getVerticalMargins(this.mExpandedActionView));
        r15 = View.combineMeasuredStates(r15, this.mExpandedActionView.getMeasuredState());
    L17:
        if (shouldLayout(this.mLogoView) == false) goto L19;
        r22 = r22 + measureChildCollapseMargins(this.mLogoView, r17, r22, r18, 0, r10);
        r14 = Math.max(r14, this.mLogoView.getMeasuredHeight() + getVerticalMargins(this.mLogoView));
        r15 = View.combineMeasuredStates(r15, this.mLogoView.getMeasuredState());
    L19:
        int r110 = getChildCount();
        int r111 = 0;
    L20:
        if (r111 >= r110) goto L28;
        View r112 = getChildAt(r111);
        if (((LayoutParams) r112.getLayoutParams()).mViewType != 0) goto L27;
        if (shouldLayout(r112) == false) goto L27;
        r22 = r22 + measureChildCollapseMargins(r112, r17, r22, r18, 0, r10);
        r14 = Math.max(r14, r112.getMeasuredHeight() + getVerticalMargins(r112));
        r15 = View.combineMeasuredStates(r15, r112.getMeasuredState());
    L27:
        r111 = r111 + 1;
        goto L20
    L28:
        int r113 = this.mTitleMarginTop + this.mTitleMarginBottom;
        int r114 = this.mTitleMarginStart + this.mTitleMarginEnd;
        if (shouldLayout(this.mTitleTextView) == false) goto L31;
        measureChildCollapseMargins(this.mTitleTextView, r17, r22 + r114, r18, r113, r10);
        int r23 = this.mTitleTextView.getMeasuredWidth() + getHorizontalMargins(this.mTitleTextView);
        int r115 = this.mTitleTextView.getMeasuredHeight() + getVerticalMargins(this.mTitleTextView);
        int r24 = View.combineMeasuredStates(r15, this.mTitleTextView.getMeasuredState());
        int r116 = r23;
    L33:
        if (shouldLayout(this.mSubtitleTextView) == false) goto L36;
        r116 = Math.max(r116, measureChildCollapseMargins(this.mSubtitleTextView, r17, r22 + r114, r18, r115 + r113, r10));
        r115 = r115 + (this.mSubtitleTextView.getMeasuredHeight() + getVerticalMargins(this.mSubtitleTextView));
        r24 = View.combineMeasuredStates(r24, this.mSubtitleTextView.getMeasuredState());
    L36:
        int r25 = Math.max(r14, r115);
        int r26 = getPaddingRight() + getPaddingLeft();
        int r27 = (getPaddingBottom() + getPaddingTop()) + r25;
        int r28 = View.resolveSizeAndState(Math.max(r26 + (r22 + r116), getSuggestedMinimumWidth()), r17, (-16777216) & r24);
        int r29 = View.resolveSizeAndState(Math.max(r27, getSuggestedMinimumHeight()), r18, r24 << 16);
        if (shouldCollapse() == true) goto L40;
        r12 = r29;
    L40:
        setMeasuredDimension(r28, r12);
        return;
    L31:
        r115 = 0;
        r24 = r15;
        r116 = 0;
        goto L33
    L12:
        r20 = 0;
        goto L13
    L5:
        r5 = 0;
        r14 = 0;
        r15 = 0;
        goto L7
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r5) {
        if ((r5 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r5);
        return;
    L6:
        SavedState r10 = (SavedState) r5;
        super.onRestoreInstanceState(r10.getSuperState());
        ActionMenuView r11 = this.mMenuView;
        if (r11 == null) goto L9;
        MenuBuilder r12 = r11.peekMenu();
    L10:
        int r13 = r10.expandedMenuItemId;
        if (r13 == 0) goto L19;
        if (this.mExpandedMenuPresenter == null) goto L19;
        if (r12 == null) goto L19;
        MenuItem r14 = r12.findItem(r13);
        if (r14 == null) goto L19;
        r14.expandActionView();
    L19:
        if (r10.isOverflowOpen == false) goto L22;
        postShowOverflowMenu();
        return;
    L22:
        return;
    L9:
        r12 = null;
        goto L10
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int r5) {
        super.onRtlPropertiesChanged(r5);
        ensureContentInsets();
        RtlSpacingHelper r10 = this.mContentInsets;
        boolean r11 = true;
        if (r5 == 1) goto L6;
        r11 = false;
    L6:
        r10.setDirection(r11);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r5 = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter r10 = this.mExpandedMenuPresenter;
        if (r10 == null) goto L7;
        MenuItemImpl r11 = r10.mCurrentExpandedItem;
        if (r11 == null) goto L7;
        r5.expandedMenuItemId = r11.getItemId();
    L7:
        r5.isOverflowOpen = isOverflowMenuShowing();
        return r5;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        int r10 = r5.getActionMasked();
        if (r10 != 0) goto L6;
        this.mEatingTouch = false;
    L6:
        if (this.mEatingTouch == true) goto L11;
        boolean r11 = super.onTouchEvent(r5);
        if (r10 != 0) goto L11;
        if (r11 == true) goto L11;
        this.mEatingTouch = true;
    L11:
        if (r10 != 1) goto L13;
    L14:
        this.mEatingTouch = false;
    L15:
        return true;
    L13:
        if (r10 != 3) goto L15;
        goto L14
    }

    public void removeChildrenForExpandedActionView() {
        int r5 = getChildCount() - 1;
    L3:
        if (r5 < 0) goto L10;
        View r10 = getChildAt(r5);
        if (((LayoutParams) r10.getLayoutParams()).mViewType == 2) goto L9;
        if (r10 == this.mMenuView) goto L9;
        removeViewAt(r5);
        this.mHiddenViews.add(r10);
    L9:
        r5 = r5 - 1;
        goto L3
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void removeMenuProvider(@NonNull MenuProvider r5) {
        this.mMenuHostHelper.removeMenuProvider(r5);
    }

    public void setBackInvokedCallbackEnabled(boolean r5) {
        if (this.mBackInvokedCallbackEnabled == r5) goto L6;
        this.mBackInvokedCallbackEnabled = r5;
        updateBackInvokedCallbackState();
        return;
    }

    public void setCollapseContentDescription(@StringRes int r5) {
        if (r5 == 0) goto L4;
        CharSequence r10 = getContext().getText(r5);
    L5:
        setCollapseContentDescription(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setCollapseIcon(@DrawableRes int r5) {
        setCollapseIcon(AppCompatResources.getDrawable(getContext(), r5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setCollapsible(boolean r5) {
        this.mCollapsible = r5;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int r5) {
        if (r5 >= 0) goto L5;
        r5 = Integer.MIN_VALUE;
    L5:
        if (r5 == this.mContentInsetEndWithActions) goto L10;
        this.mContentInsetEndWithActions = r5;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetStartWithNavigation(int r5) {
        if (r5 >= 0) goto L5;
        r5 = Integer.MIN_VALUE;
    L5:
        if (r5 == this.mContentInsetStartWithNavigation) goto L10;
        this.mContentInsetStartWithNavigation = r5;
        if (getNavigationIcon() == null) goto L11;
        requestLayout();
        return;
    L11:
        return;
    }

    public void setContentInsetsAbsolute(int r5, int r10) {
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r5, r10);
    }

    public void setContentInsetsRelative(int r5, int r10) {
        ensureContentInsets();
        this.mContentInsets.setRelative(r5, r10);
    }

    public void setLogo(@DrawableRes int r5) {
        setLogo(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setLogoDescription(@StringRes int r5) {
        setLogoDescription(getContext().getText(r5));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setMenu(MenuBuilder r5, ActionMenuPresenter r10) {
        if (r5 == null) goto L4;
    L6:
        ensureMenuView();
        MenuBuilder r11 = this.mMenuView.peekMenu();
        if (r11 != r5) goto L9;
        return;
    L9:
        if (r11 == null) goto L12;
        r11.removeMenuPresenter(this.mOuterActionMenuPresenter);
        r11.removeMenuPresenter(this.mExpandedMenuPresenter);
    L12:
        if (this.mExpandedMenuPresenter != null) goto L14;
        this.mExpandedMenuPresenter = new ExpandedActionViewMenuPresenter(this);
    L14:
        r10.setExpandedActionViewsExclusive(true);
        if (r5 == null) goto L17;
        r5.addMenuPresenter(r10, this.mPopupContext);
        r5.addMenuPresenter(this.mExpandedMenuPresenter, this.mPopupContext);
    L18:
        this.mMenuView.setPopupTheme(this.mPopupTheme);
        this.mMenuView.setPresenter(r10);
        this.mOuterActionMenuPresenter = r10;
        updateBackInvokedCallbackState();
        return;
    L17:
        r10.initForMenu(this.mPopupContext, null);
        this.mExpandedMenuPresenter.initForMenu(this.mPopupContext, null);
        r10.updateMenuView(true);
        this.mExpandedMenuPresenter.updateMenuView(true);
        goto L18
    L4:
        if (this.mMenuView != null) goto L6;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setMenuCallbacks(MenuPresenter.Callback r5, MenuBuilder.Callback r10) {
        this.mActionMenuPresenterCallback = r5;
        this.mMenuBuilderCallback = r10;
        ActionMenuView r11 = this.mMenuView;
        if (r11 == null) goto L6;
        r11.setMenuCallbacks(r5, r10);
        return;
    }

    public void setNavigationContentDescription(@StringRes int r5) {
        if (r5 == 0) goto L4;
        CharSequence r10 = getContext().getText(r5);
    L5:
        setNavigationContentDescription(r10);
        return;
    L4:
        r10 = null;
        goto L5
    }

    public void setNavigationIcon(@DrawableRes int r5) {
        setNavigationIcon(AppCompatResources.getDrawable(getContext(), r5));
    }

    public void setNavigationOnClickListener(View.OnClickListener r5) {
        ensureNavButtonView();
        this.mNavButtonView.setOnClickListener(r5);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener r5) {
        this.mOnMenuItemClickListener = r5;
    }

    public void setOverflowIcon(@Nullable Drawable r5) {
        ensureMenu();
        this.mMenuView.setOverflowIcon(r5);
    }

    public void setPopupTheme(@StyleRes int r5) {
        if (this.mPopupTheme == r5) goto L9;
        this.mPopupTheme = r5;
        if (r5 != 0) goto L7;
        this.mPopupContext = getContext();
        return;
    L7:
        this.mPopupContext = new ContextThemeWrapper(getContext(), r5);
        return;
    }

    public void setSubtitle(@StringRes int r5) {
        setSubtitle(getContext().getText(r5));
    }

    public void setSubtitleTextAppearance(Context r5, @StyleRes int r10) {
        this.mSubtitleTextAppearance = r10;
        TextView r11 = this.mSubtitleTextView;
        if (r11 == null) goto L6;
        r11.setTextAppearance(r5, r10);
        return;
    }

    public void setSubtitleTextColor(@ColorInt int r5) {
        setSubtitleTextColor(ColorStateList.valueOf(r5));
    }

    public void setTitle(@StringRes int r5) {
        setTitle(getContext().getText(r5));
    }

    public void setTitleMargin(int r5, int r10, int r11, int r12) {
        this.mTitleMarginStart = r5;
        this.mTitleMarginTop = r10;
        this.mTitleMarginEnd = r11;
        this.mTitleMarginBottom = r12;
        requestLayout();
    }

    public void setTitleMarginBottom(int r5) {
        this.mTitleMarginBottom = r5;
        requestLayout();
    }

    public void setTitleMarginEnd(int r5) {
        this.mTitleMarginEnd = r5;
        requestLayout();
    }

    public void setTitleMarginStart(int r5) {
        this.mTitleMarginStart = r5;
        requestLayout();
    }

    public void setTitleMarginTop(int r5) {
        this.mTitleMarginTop = r5;
        requestLayout();
    }

    public void setTitleTextAppearance(Context r5, @StyleRes int r10) {
        this.mTitleTextAppearance = r10;
        TextView r11 = this.mTitleTextView;
        if (r11 == null) goto L6;
        r11.setTextAppearance(r5, r10);
        return;
    }

    public void setTitleTextColor(@ColorInt int r5) {
        setTitleTextColor(ColorStateList.valueOf(r5));
    }

    public boolean showOverflowMenu() {
        ActionMenuView r5 = this.mMenuView;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.showOverflowMenu() == false) goto L7;
        return true;
    }

    public void updateBackInvokedCallbackState() {
        if (Build.VERSION.SDK_INT < 33) goto L25;
        OnBackInvokedDispatcher r5 = Api33Impl.findOnBackInvokedDispatcher(this);
        if (hasExpandedActionView() == false) goto L12;
        if (r5 == null) goto L12;
        if (ViewCompat.isAttachedToWindow(this) == false) goto L12;
        if (this.mBackInvokedCallbackEnabled == false) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == true) goto L15;
    L20:
        if (r10 == true) goto L27;
        OnBackInvokedDispatcher r11 = this.mBackInvokedDispatcher;
        if (r11 == null) goto L28;
        Api33Impl.tryUnregisterOnBackInvokedCallback(r11, this.mBackInvokedCallback);
        this.mBackInvokedDispatcher = null;
        return;
    L28:
        return;
    L27:
        return;
    L15:
        if (this.mBackInvokedDispatcher != null) goto L20;
        if (this.mBackInvokedCallback != null) goto L19;
        this.mBackInvokedCallback = Api33Impl.newOnBackInvokedCallback(new a(this, 0));
    L19:
        Api33Impl.tryRegisterOnBackInvokedCallback(r5, this.mBackInvokedCallback);
        this.mBackInvokedDispatcher = r5;
        return;
    L12:
        r10 = false;
        goto L13
    }

    public Toolbar(@NonNull Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, R.attr.toolbarStyle);
    }

    @Override // androidx.core.view.MenuHost
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r5, @NonNull LifecycleOwner r10) {
        this.mMenuHostHelper.addMenuProvider(r5, r10);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return generateLayoutParams(r5);
    }

    public void setCollapseContentDescription(@Nullable CharSequence r5) {
        if (TextUtils.isEmpty(r5) == true) goto L5;
        ensureCollapseButtonView();
    L5:
        ImageButton r10 = this.mCollapseButtonView;
        if (r10 == null) goto L9;
        r10.setContentDescription(r5);
        return;
    }

    public void setCollapseIcon(@Nullable Drawable r5) {
        if (r5 == null) goto L4;
        ensureCollapseButtonView();
        this.mCollapseButtonView.setImageDrawable(r5);
        return;
    L4:
        ImageButton r10 = this.mCollapseButtonView;
        if (r10 == null) goto L9;
        r10.setImageDrawable(this.mCollapseIcon);
        return;
    }

    public void setLogo(Drawable r5) {
        if (r5 == null) goto L6;
        ensureLogoView();
        if (isChildOrHidden(this.mLogoView) == true) goto L11;
        addSystemView(this.mLogoView, true);
    L11:
        ImageView r10 = this.mLogoView;
        if (r10 == null) goto L15;
        r10.setImageDrawable(r5);
        return;
    L15:
        return;
    L6:
        ImageView r11 = this.mLogoView;
        if (r11 == null) goto L11;
        if (isChildOrHidden(r11) == false) goto L11;
        removeView(this.mLogoView);
        this.mHiddenViews.remove(this.mLogoView);
        goto L11
    }

    public void setLogoDescription(CharSequence r5) {
        if (TextUtils.isEmpty(r5) == true) goto L5;
        ensureLogoView();
    L5:
        ImageView r10 = this.mLogoView;
        if (r10 == null) goto L9;
        r10.setContentDescription(r5);
        return;
    }

    public void setNavigationContentDescription(@Nullable CharSequence r5) {
        if (TextUtils.isEmpty(r5) == true) goto L5;
        ensureNavButtonView();
    L5:
        ImageButton r10 = this.mNavButtonView;
        if (r10 == null) goto L9;
        r10.setContentDescription(r5);
        TooltipCompat.setTooltipText(this.mNavButtonView, r5);
        return;
    }

    public void setNavigationIcon(@Nullable Drawable r5) {
        if (r5 == null) goto L6;
        ensureNavButtonView();
        if (isChildOrHidden(this.mNavButtonView) == true) goto L11;
        addSystemView(this.mNavButtonView, true);
    L11:
        ImageButton r10 = this.mNavButtonView;
        if (r10 == null) goto L15;
        r10.setImageDrawable(r5);
        return;
    L15:
        return;
    L6:
        ImageButton r11 = this.mNavButtonView;
        if (r11 == null) goto L11;
        if (isChildOrHidden(r11) == false) goto L11;
        removeView(this.mNavButtonView);
        this.mHiddenViews.remove(this.mNavButtonView);
        goto L11
    }

    public void setSubtitle(CharSequence r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        TextView r10 = this.mSubtitleTextView;
        if (r10 != null) goto L18;
    L20:
        TextView r11 = this.mSubtitleTextView;
        if (r11 == null) goto L23;
        r11.setText(r5);
    L23:
        this.mSubtitleText = r5;
        return;
    L18:
        if (isChildOrHidden(r10) == false) goto L20;
        removeView(this.mSubtitleTextView);
        this.mHiddenViews.remove(this.mSubtitleTextView);
        goto L20
    L5:
        if (this.mSubtitleTextView != null) goto L13;
        Context r12 = getContext();
        AppCompatTextView r13 = new AppCompatTextView(r12);
        this.mSubtitleTextView = r13;
        r13.setSingleLine();
        this.mSubtitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r14 = this.mSubtitleTextAppearance;
        if (r14 == 0) goto L9;
        this.mSubtitleTextView.setTextAppearance(r12, r14);
    L9:
        ColorStateList r15 = this.mSubtitleTextColor;
        if (r15 == null) goto L13;
        this.mSubtitleTextView.setTextColor(r15);
    L13:
        if (isChildOrHidden(this.mSubtitleTextView) == true) goto L20;
        addSystemView(this.mSubtitleTextView, true);
        goto L20
    }

    public void setSubtitleTextColor(@NonNull ColorStateList r5) {
        this.mSubtitleTextColor = r5;
        TextView r10 = this.mSubtitleTextView;
        if (r10 == null) goto L6;
        r10.setTextColor(r5);
        return;
    }

    public void setTitle(CharSequence r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        TextView r10 = this.mTitleTextView;
        if (r10 != null) goto L18;
    L20:
        TextView r11 = this.mTitleTextView;
        if (r11 == null) goto L23;
        r11.setText(r5);
    L23:
        this.mTitleText = r5;
        return;
    L18:
        if (isChildOrHidden(r10) == false) goto L20;
        removeView(this.mTitleTextView);
        this.mHiddenViews.remove(this.mTitleTextView);
        goto L20
    L5:
        if (this.mTitleTextView != null) goto L13;
        Context r12 = getContext();
        AppCompatTextView r13 = new AppCompatTextView(r12);
        this.mTitleTextView = r13;
        r13.setSingleLine();
        this.mTitleTextView.setEllipsize(TextUtils.TruncateAt.END);
        int r14 = this.mTitleTextAppearance;
        if (r14 == 0) goto L9;
        this.mTitleTextView.setTextAppearance(r12, r14);
    L9:
        ColorStateList r15 = this.mTitleTextColor;
        if (r15 == null) goto L13;
        this.mTitleTextView.setTextColor(r15);
    L13:
        if (isChildOrHidden(this.mTitleTextView) == true) goto L20;
        addSystemView(this.mTitleTextView, true);
        goto L20
    }

    public void setTitleTextColor(@NonNull ColorStateList r5) {
        this.mTitleTextColor = r5;
        TextView r10 = this.mTitleTextView;
        if (r10 == null) goto L6;
        r10.setTextColor(r5);
        return;
    }

    public Toolbar(@NonNull Context r11, @Nullable AttributeSet r12, int r13) {
        super(r11, r12, r13);
        this.mGravity = 8388627;
        this.mTempViews = new ArrayList();
        this.mHiddenViews = new ArrayList();
        this.mTempMargins = new int[2];
        this.mMenuHostHelper = new MenuHostHelper(new a(this, 1));
        this.mProvidedMenuItems = new ArrayList();
        this.mMenuViewItemClickListener = new AnonymousClass1(this);
        this.mShowOverflowMenuRunnable = new AnonymousClass2(this);
        TintTypedArray r5 = TintTypedArray.obtainStyledAttributes(getContext(), r12, R.styleable.Toolbar, r13, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r11, R.styleable.Toolbar, r12, r5.getWrappedTypeArray(), r13, 0);
        this.mTitleTextAppearance = r5.getResourceId(R.styleable.Toolbar_titleTextAppearance, 0);
        this.mSubtitleTextAppearance = r5.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.mGravity = r5.getInteger(R.styleable.Toolbar_android_gravity, this.mGravity);
        this.mButtonGravity = r5.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int r14 = r5.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        if (r5.hasValue(R.styleable.Toolbar_titleMargins) == false) goto L5;
        r14 = r5.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, r14);
    L5:
        this.mTitleMarginBottom = r14;
        this.mTitleMarginTop = r14;
        this.mTitleMarginEnd = r14;
        this.mTitleMarginStart = r14;
        int r15 = r5.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (r15 < 0) goto L8;
        this.mTitleMarginStart = r15;
    L8:
        int r16 = r5.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (r16 < 0) goto L11;
        this.mTitleMarginEnd = r16;
    L11:
        int r17 = r5.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (r17 < 0) goto L14;
        this.mTitleMarginTop = r17;
    L14:
        int r18 = r5.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (r18 < 0) goto L17;
        this.mTitleMarginBottom = r18;
    L17:
        this.mMaxButtonHeight = r5.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int r19 = r5.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int r110 = r5.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int r10 = r5.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int r20 = r5.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        ensureContentInsets();
        this.mContentInsets.setAbsolute(r10, r20);
        if (r19 != Integer.MIN_VALUE) goto L20;
        if (r110 != Integer.MIN_VALUE) goto L20;
    L21:
        this.mContentInsetStartWithNavigation = r5.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.mContentInsetEndWithActions = r5.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.mCollapseIcon = r5.getDrawable(R.styleable.Toolbar_collapseIcon);
        this.mCollapseDescription = r5.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence r111 = r5.getText(R.styleable.Toolbar_title);
        if (TextUtils.isEmpty(r111) == true) goto L24;
        setTitle(r111);
    L24:
        CharSequence r112 = r5.getText(R.styleable.Toolbar_subtitle);
        if (TextUtils.isEmpty(r112) == true) goto L27;
        setSubtitle(r112);
    L27:
        this.mPopupContext = getContext();
        setPopupTheme(r5.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable r113 = r5.getDrawable(R.styleable.Toolbar_navigationIcon);
        if (r113 == null) goto L30;
        setNavigationIcon(r113);
    L30:
        CharSequence r114 = r5.getText(R.styleable.Toolbar_navigationContentDescription);
        if (TextUtils.isEmpty(r114) == true) goto L33;
        setNavigationContentDescription(r114);
    L33:
        Drawable r115 = r5.getDrawable(R.styleable.Toolbar_logo);
        if (r115 == null) goto L36;
        setLogo(r115);
    L36:
        CharSequence r116 = r5.getText(R.styleable.Toolbar_logoDescription);
        if (TextUtils.isEmpty(r116) == true) goto L40;
        setLogoDescription(r116);
    L40:
        if (r5.hasValue(R.styleable.Toolbar_titleTextColor) == false) goto L43;
        setTitleTextColor(r5.getColorStateList(R.styleable.Toolbar_titleTextColor));
    L43:
        if (r5.hasValue(R.styleable.Toolbar_subtitleTextColor) == false) goto L46;
        setSubtitleTextColor(r5.getColorStateList(R.styleable.Toolbar_subtitleTextColor));
    L46:
        if (r5.hasValue(R.styleable.Toolbar_menu) == false) goto L48;
        inflateMenu(r5.getResourceId(R.styleable.Toolbar_menu, 0));
    L48:
        r5.recycle();
        return;
    L20:
        this.mContentInsets.setRelative(r19, r110);
        goto L21
    }

    @Override // androidx.core.view.MenuHost
    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addMenuProvider(@NonNull MenuProvider r5, @NonNull LifecycleOwner r10, @NonNull Lifecycle.State r11) {
        this.mMenuHostHelper.addMenuProvider(r5, r10, r11);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet r5) {
        return new LayoutParams(getContext(), r5);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        if ((r5 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r5);
    L7:
        if ((r5 instanceof ActionBar.LayoutParams) == false) goto L11;
        return new LayoutParams((ActionBar.LayoutParams) r5);
    L11:
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r5);
    L15:
        return new LayoutParams(r5);
    }
}
