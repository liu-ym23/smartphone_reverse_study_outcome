package androidx.appcompat.view.menu;

import ai.j0;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    static final int HORIZ_POSITION_LEFT = 0;
    static final int HORIZ_POSITION_RIGHT = 1;
    private static final int ITEM_LAYOUT = 0;
    static final int SUBMENU_TIMEOUT_MS = 200;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private final Context mContext;
    private int mDropDownGravity;
    private boolean mForceShowIcon;
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasXOffset;
    private boolean mHasYOffset;
    private int mLastPosition;
    private final MenuItemHoverListener mMenuItemHoverListener;
    private final int mMenuMaxWidth;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    private final List<MenuBuilder> mPendingMenus;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private int mRawDropDownGravity;
    boolean mShouldCloseImmediately;
    private boolean mShowTitle;
    final List<CascadingMenuInfo> mShowingMenus;
    View mShownAnchorView;
    final Handler mSubMenuHoverHandler;
    ViewTreeObserver mTreeObserver;
    private int mXOffset;
    private int mYOffset;

    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(@NonNull MenuPopupWindow r5, @NonNull MenuBuilder r10, int r11) {
            this.window = r5;
            this.menu = r10;
            this.position = r11;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    static {
        ITEM_LAYOUT = R.layout.abc_cascading_menu_item_layout;
    }

    public CascadingMenuPopup(@NonNull Context r5, @NonNull View r10, @AttrRes int r11, @StyleRes int r12, boolean r13) {
        this.mPendingMenus = new ArrayList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mMenuItemHoverListener = new AnonymousClass3(this);
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = r5;
        this.mAnchorView = r10;
        this.mPopupStyleAttr = r11;
        this.mPopupStyleRes = r12;
        this.mOverflowOnly = r13;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources r14 = r5.getResources();
        this.mMenuMaxWidth = Math.max(r14.getDisplayMetrics().widthPixels / 2, r14.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow r5 = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        r5.setHoverListener(this.mMenuItemHoverListener);
        r5.setOnItemClickListener(this);
        r5.setOnDismissListener(this);
        r5.setAnchorView(this.mAnchorView);
        r5.setDropDownGravity(this.mDropDownGravity);
        r5.setModal(true);
        r5.setInputMethodMode(2);
        return r5;
    }

    private int findIndexOfAddedMenu(@NonNull MenuBuilder r5) {
        int r10 = this.mShowingMenus.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (r5 == this.mShowingMenus.get(r11).menu) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return r11;
    L8:
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(@NonNull MenuBuilder r5, @NonNull MenuBuilder r10) {
        int r11 = r5.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L10;
        MenuItem r13 = r5.getItem(r12);
        if (r13.hasSubMenu() == false) goto L9;
        if (r10 != r13.getSubMenu()) goto L9;
        return r13;
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        return null;
    }

    @Nullable
    private View findParentViewForSubmenu(@NonNull CascadingMenuInfo r10, @NonNull MenuBuilder r11) {
        MenuItem r12 = findMenuItemForSubmenu(r10.menu, r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        ListView r13 = r10.getListView();
        ListAdapter r5 = r13.getAdapter();
        int r14 = 0;
        if ((r5 instanceof HeaderViewListAdapter) == false) goto L8;
        HeaderViewListAdapter r15 = (HeaderViewListAdapter) r5;
        int r16 = r15.getHeadersCount();
        MenuAdapter r17 = (MenuAdapter) r15.getWrappedAdapter();
    L9:
        int r18 = r17.getCount();
    L11:
        if (r14 >= r18) goto L16;
        if (r12 == r17.getItem(r14)) goto L17;
        r14 = r14 + 1;
    L17:
        if (r14 != (-1)) goto L19;
        return null;
    L19:
        int r19 = (r14 + r16) - r13.getFirstVisiblePosition();
        if (r19 >= 0) goto L22;
    L26:
        return null;
    L22:
        if (r19 >= r13.getChildCount()) goto L26;
        return r13.getChildAt(r19);
    L16:
        r14 = -1;
        goto L17
    L8:
        r17 = (MenuAdapter) r5;
        r16 = 0;
        goto L9
    }

    private int getInitialMenuPosition() {
        if (ViewCompat.getLayoutDirection(this.mAnchorView) != 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    private int getNextMenuPosition(int r10) {
        ListView r5 = ((CascadingMenuInfo) j0.e(this.mShowingMenus, 1)).getListView();
        int[] r11 = new int[2];
        r5.getLocationOnScreen(r11);
        Rect r12 = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(r12);
        if (this.mLastPosition != 1) goto L9;
        int r13 = r11[0];
        if (((r5.getWidth() + r13) + r10) <= r12.right) goto L7;
        return 0;
    L7:
        return 1;
    L9:
        if ((r11[0] - r10) >= 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    private void showMenu(@NonNull MenuBuilder r12) {
        LayoutInflater r5 = LayoutInflater.from(this.mContext);
        MenuAdapter r10 = new MenuAdapter(r12, r5, this.mOverflowOnly, ITEM_LAYOUT);
        if (isShowing() == true) goto L8;
        if (this.mForceShowIcon == false) goto L8;
        r10.setForceShowIcon(true);
    L10:
        int r11 = MenuPopup.measureIndividualMenuWidth(r10, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow r13 = createPopupWindow();
        r13.setAdapter(r10);
        r13.setContentWidth(r11);
        r13.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() <= 0) goto L13;
        CascadingMenuInfo r14 = (CascadingMenuInfo) j0.e(this.mShowingMenus, 1);
        View r15 = findParentViewForSubmenu(r14, r12);
    L15:
        if (r15 == null) goto L30;
        r13.setTouchModal(false);
        r13.setEnterTransition(null);
        int r16 = getNextMenuPosition(r11);
        if (r16 != 1) goto L19;
        boolean r17 = true;
    L20:
        this.mLastPosition = r16;
        r13.setAnchorView(r15);
        if ((this.mDropDownGravity & 5) != 5) goto L25;
        if (r17 == true) goto L28;
        r11 = 0 - r15.getWidth();
    L28:
        r13.setHorizontalOffset(r11);
        r13.setOverlapAnchor(true);
        r13.setVerticalOffset(0);
    L36:
        this.mShowingMenus.add(new CascadingMenuInfo(r13, r12, this.mLastPosition));
        r13.show();
        ListView r18 = r13.getListView();
        r18.setOnKeyListener(this);
        if (r14 == null) goto L39;
        return;
    L39:
        if (this.mShowTitle == true) goto L41;
        return;
    L41:
        if (r12.getHeaderTitle() == null) goto L46;
        FrameLayout r19 = (FrameLayout) r5.inflate(R.layout.abc_popup_menu_header_item_layout, r18, false);
        TextView r20 = (TextView) r19.findViewById(android.R.id.title);
        r19.setEnabled(false);
        r20.setText(r12.getHeaderTitle());
        r18.addHeaderView(r19, null, false);
        r13.show();
        return;
    L46:
        return;
    L25:
        if (r17 == false) goto L27;
        r11 = r15.getWidth();
        goto L28
    L27:
        r11 = 0 - r11;
        goto L28
    L19:
        r17 = false;
        goto L20
    L30:
        if (this.mHasXOffset == false) goto L33;
        r13.setHorizontalOffset(this.mXOffset);
    L33:
        if (this.mHasYOffset == false) goto L35;
        r13.setVerticalOffset(this.mYOffset);
    L35:
        r13.setEpicenterBounds(getEpicenterBounds());
        goto L36
    L13:
        r14 = null;
        r15 = null;
    L8:
        if (isShowing() == false) goto L10;
        r10.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r12));
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r5) {
        r5.addMenuPresenter(this, this.mContext);
        if (isShowing() == false) goto L5;
        showMenu(r5);
        return;
    L5:
        this.mPendingMenus.add(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int r5 = this.mShowingMenus.size();
        if (r5 <= 0) goto L10;
        CascadingMenuInfo[] r10 = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[r5]);
        int r11 = r5 - 1;
    L5:
        if (r11 < 0) goto L14;
        CascadingMenuInfo r12 = r10[r11];
        if (r12.window.isShowing() == false) goto L9;
        r12.window.dismiss();
    L9:
        r11 = r11 - 1;
        goto L5
    L14:
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.mShowingMenus.isEmpty() == false) goto L6;
        return null;
    L6:
        return ((CascadingMenuInfo) j0.e(this.mShowingMenus, 1)).getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.mShowingMenus.size() > 0) goto L5;
        return false;
    L5:
        if (this.mShowingMenus.get(0).window.isShowing() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        int r5 = findIndexOfAddedMenu(r10);
        if (r5 >= 0) goto L5;
        return;
    L5:
        int r12 = r5 + 1;
        if (r12 >= this.mShowingMenus.size()) goto L8;
        this.mShowingMenus.get(r12).menu.close(false);
    L8:
        CascadingMenuInfo r13 = this.mShowingMenus.remove(r5);
        r13.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately == false) goto L11;
        r13.window.setExitTransition(null);
        r13.window.setAnimationStyle(0);
    L11:
        r13.window.dismiss();
        int r14 = this.mShowingMenus.size();
        if (r14 <= 0) goto L14;
        this.mLastPosition = this.mShowingMenus.get(r14 - 1).position;
    L15:
        if (r14 != 0) goto L26;
        dismiss();
        MenuPresenter.Callback r15 = this.mPresenterCallback;
        if (r15 == null) goto L19;
        r15.onCloseMenu(r10, true);
    L19:
        ViewTreeObserver r16 = this.mTreeObserver;
        if (r16 != null) goto L22;
    L25:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
        return;
    L22:
        if (r16.isAlive() == false) goto L24;
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
    L24:
        this.mTreeObserver = null;
        goto L25
    L26:
        if (r11 == false) goto L30;
        this.mShowingMenus.get(0).menu.close(false);
        return;
    L30:
        return;
    L14:
        this.mLastPosition = getInitialMenuPosition();
        goto L15
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int r5 = this.mShowingMenus.size();
        int r10 = 0;
    L3:
        if (r10 >= r5) goto L8;
        CascadingMenuInfo r11 = this.mShowingMenus.get(r10);
        if (r11.window.isShowing() == false) goto L9;
        r10 = r10 + 1;
    L9:
        if (r11 == null) goto L14;
        r11.menu.close(false);
        return;
    L14:
        return;
    L8:
        r11 = null;
        goto L9
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r5, int r10, KeyEvent r11) {
        if (r11.getAction() == 1) goto L5;
        return false;
    L5:
        if (r10 != 82) goto L10;
        dismiss();
        return true;
    L10:
        return false;
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
        Iterator<CascadingMenuInfo> r10 = this.mShowingMenus.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        CascadingMenuInfo r11 = r10.next();
        if (r5 != r11.menu) goto L4;
        r11.getListView().requestFocus();
        return true;
    L10:
        if (r5.hasVisibleItems() == false) goto L15;
        addMenu(r5);
        MenuPresenter.Callback r12 = this.mPresenterCallback;
        if (r12 == null) goto L14;
        r12.onOpenSubMenu(r5);
    L14:
        return true;
    L15:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(@NonNull View r5) {
        if (this.mAnchorView == r5) goto L6;
        this.mAnchorView = r5;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(r5));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r5) {
        this.mPresenterCallback = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r5) {
        this.mForceShowIcon = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r5) {
        if (this.mRawDropDownGravity == r5) goto L6;
        this.mRawDropDownGravity = r5;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(r5, ViewCompat.getLayoutDirection(this.mAnchorView));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r5) {
        this.mHasXOffset = true;
        this.mXOffset = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener r5) {
        this.mOnDismissListener = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean r5) {
        this.mShowTitle = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int r5) {
        this.mHasYOffset = true;
        this.mYOffset = r5;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        Iterator<MenuBuilder> r5 = this.mPendingMenus.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        showMenu(r5.next());
        goto L7
    L9:
        this.mPendingMenus.clear();
        View r10 = this.mAnchorView;
        this.mShownAnchorView = r10;
        if (r10 != null) goto L12;
        return;
    L12:
        if (this.mTreeObserver != null) goto L14;
        boolean r11 = true;
    L15:
        ViewTreeObserver r12 = r10.getViewTreeObserver();
        this.mTreeObserver = r12;
        if (r11 == false) goto L18;
        r12.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L18:
        this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        return;
    L14:
        r11 = false;
        goto L15
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r5) {
        Iterator<CascadingMenuInfo> r10 = this.mShowingMenus.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        MenuPopup.toMenuAdapter(r10.next().getListView().getAdapter()).notifyDataSetChanged();
        goto L4
    }
}
