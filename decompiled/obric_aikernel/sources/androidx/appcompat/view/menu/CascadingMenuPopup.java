package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
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
final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener {
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

    private static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(@NonNull MenuPopupWindow r10, @NonNull MenuBuilder r11, int r12) {
            this.window = r10;
            this.menu = r11;
            this.position = r12;
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

    public CascadingMenuPopup(@NonNull Context r10, @NonNull View r11, @AttrRes int r12, @StyleRes int r13, boolean r14) {
        this.mPendingMenus = new ArrayList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mMenuItemHoverListener = new AnonymousClass3(this);
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = r10;
        this.mAnchorView = r11;
        this.mPopupStyleAttr = r12;
        this.mPopupStyleRes = r13;
        this.mOverflowOnly = r14;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources r15 = r10.getResources();
        this.mMenuMaxWidth = Math.max(r15.getDisplayMetrics().widthPixels / 2, r15.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow r10 = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        r10.setHoverListener(this.mMenuItemHoverListener);
        r10.setOnItemClickListener(this);
        r10.setOnDismissListener(this);
        r10.setAnchorView(this.mAnchorView);
        r10.setDropDownGravity(this.mDropDownGravity);
        r10.setModal(true);
        r10.setInputMethodMode(2);
        return r10;
    }

    private int findIndexOfAddedMenu(@NonNull MenuBuilder r10) {
        int r11 = this.mShowingMenus.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r10 == this.mShowingMenus.get(r12).menu) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(@NonNull MenuBuilder r10, @NonNull MenuBuilder r11) {
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        MenuItem r14 = r10.getItem(r13);
        if (r14.hasSubMenu() == false) goto L9;
        if (r11 != r14.getSubMenu()) goto L9;
        return r14;
    L9:
        r13 = r13 + 1;
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
        ListAdapter r14 = r13.getAdapter();
        int r15 = 0;
        if ((r14 instanceof HeaderViewListAdapter) == false) goto L8;
        HeaderViewListAdapter r16 = (HeaderViewListAdapter) r14;
        int r17 = r16.getHeadersCount();
        MenuAdapter r18 = (MenuAdapter) r16.getWrappedAdapter();
    L9:
        int r19 = r18.getCount();
    L11:
        if (r15 >= r19) goto L16;
        if (r12 == r18.getItem(r15)) goto L17;
        r15 = r15 + 1;
    L17:
        if (r15 != (-1)) goto L19;
        return null;
    L19:
        int r20 = (r15 + r17) - r13.getFirstVisiblePosition();
        if (r20 >= 0) goto L22;
    L26:
        return null;
    L22:
        if (r20 >= r13.getChildCount()) goto L26;
        return r13.getChildAt(r20);
    L16:
        r15 = -1;
        goto L17
    L8:
        r18 = (MenuAdapter) r14;
        r17 = 0;
        goto L9
    }

    private int getInitialMenuPosition() {
        if (ViewCompat.getLayoutDirection(this.mAnchorView) != 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    private int getNextMenuPosition(int r10) {
        List<CascadingMenuInfo> r11 = this.mShowingMenus;
        ListView r12 = r11.get(r11.size() - 1).getListView();
        int[] r13 = new int[2];
        r12.getLocationOnScreen(r13);
        Rect r14 = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(r14);
        if (this.mLastPosition != 1) goto L9;
        if (((r13[0] + r12.getWidth()) + r10) <= r14.right) goto L7;
        return 0;
    L7:
        return 1;
    L9:
        if ((r13[0] - r10) >= 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    private void showMenu(@NonNull MenuBuilder r15) {
        LayoutInflater r10 = LayoutInflater.from(this.mContext);
        MenuAdapter r11 = new MenuAdapter(r15, r10, this.mOverflowOnly, ITEM_LAYOUT);
        if (isShowing() == true) goto L8;
        if (this.mForceShowIcon == false) goto L8;
        r11.setForceShowIcon(true);
    L10:
        int r12 = MenuPopup.measureIndividualMenuWidth(r11, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow r13 = createPopupWindow();
        r13.setAdapter(r11);
        r13.setContentWidth(r12);
        r13.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() <= 0) goto L13;
        List<CascadingMenuInfo> r14 = this.mShowingMenus;
        CascadingMenuInfo r16 = r14.get(r14.size() - 1);
        View r17 = findParentViewForSubmenu(r16, r15);
    L15:
        if (r17 == null) goto L38;
        r13.setTouchModal(false);
        r13.setEnterTransition(null);
        int r18 = getNextMenuPosition(r12);
        if (r18 != 1) goto L19;
        boolean r19 = true;
    L20:
        this.mLastPosition = r18;
        if (Build.VERSION.SDK_INT < 26) goto L23;
        r13.setAnchorView(r17);
        int r20 = 0;
        int r110 = 0;
    L28:
        if ((this.mDropDownGravity & 5) != 5) goto L32;
        if (r19 == true) goto L34;
        r12 = r17.getWidth();
    L35:
        int r111 = r110 - r12;
    L36:
        r13.setHorizontalOffset(r111);
        r13.setOverlapAnchor(true);
        r13.setVerticalOffset(r20);
    L44:
        this.mShowingMenus.add(new CascadingMenuInfo(r13, r15, this.mLastPosition));
        r13.show();
        ListView r21 = r13.getListView();
        r21.setOnKeyListener(this);
        if (r16 == null) goto L47;
        return;
    L47:
        if (this.mShowTitle == true) goto L49;
        return;
    L49:
        if (r15.getHeaderTitle() == null) goto L54;
        FrameLayout r112 = (FrameLayout) r10.inflate(R.layout.abc_popup_menu_header_item_layout, r21, false);
        TextView r22 = (TextView) r112.findViewById(android.R.id.title);
        r112.setEnabled(false);
        r22.setText(r15.getHeaderTitle());
        r21.addHeaderView(r112, null, false);
        r13.show();
        return;
    L54:
        return;
    L34:
        r111 = r110 + r12;
        goto L36
    L32:
        if (r19 == false) goto L35;
        r12 = r17.getWidth();
        goto L34
    L23:
        int[] r113 = new int[2];
        this.mAnchorView.getLocationOnScreen(r113);
        int[] r23 = new int[2];
        r17.getLocationOnScreen(r23);
        if ((this.mDropDownGravity & 7) != 5) goto L26;
        r113[0] = r113[0] + this.mAnchorView.getWidth();
        r23[0] = r23[0] + r17.getWidth();
    L26:
        r110 = r23[0] - r113[0];
        r20 = r23[1] - r113[1];
        goto L28
    L19:
        r19 = false;
        goto L20
    L38:
        if (this.mHasXOffset == false) goto L41;
        r13.setHorizontalOffset(this.mXOffset);
    L41:
        if (this.mHasYOffset == false) goto L43;
        r13.setVerticalOffset(this.mYOffset);
    L43:
        r13.setEpicenterBounds(getEpicenterBounds());
        goto L44
    L13:
        r16 = null;
        r17 = null;
    L8:
        if (isShowing() == false) goto L10;
        r11.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r15));
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r10) {
        r10.addMenuPresenter(this, this.mContext);
        if (isShowing() == false) goto L5;
        showMenu(r10);
        return;
    L5:
        this.mPendingMenus.add(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    protected boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int r10 = this.mShowingMenus.size();
        if (r10 <= 0) goto L10;
        CascadingMenuInfo[] r11 = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[r10]);
        int r12 = r10 - 1;
    L5:
        if (r12 < 0) goto L14;
        CascadingMenuInfo r13 = r11[r12];
        if (r13.window.isShowing() == false) goto L9;
        r13.window.dismiss();
    L9:
        r12 = r12 - 1;
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
        if (this.mShowingMenus.isEmpty() == false) goto L5;
        return null;
    L5:
        List<CascadingMenuInfo> r10 = this.mShowingMenus;
        return r10.get(r10.size() - 1).getListView();
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
        int r12 = findIndexOfAddedMenu(r10);
        if (r12 >= 0) goto L5;
        return;
    L5:
        int r13 = r12 + 1;
        if (r13 >= this.mShowingMenus.size()) goto L8;
        this.mShowingMenus.get(r13).menu.close(false);
    L8:
        CascadingMenuInfo r14 = this.mShowingMenus.remove(r12);
        r14.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately == false) goto L11;
        r14.window.setExitTransition(null);
        r14.window.setAnimationStyle(0);
    L11:
        r14.window.dismiss();
        int r15 = this.mShowingMenus.size();
        if (r15 <= 0) goto L14;
        int r16 = this.mShowingMenus.get(r15 - 1).position;
    L15:
        this.mLastPosition = r16;
        if (r15 != 0) goto L27;
        dismiss();
        MenuPresenter.Callback r17 = this.mPresenterCallback;
        if (r17 == null) goto L20;
        r17.onCloseMenu(r10, true);
    L20:
        ViewTreeObserver r18 = this.mTreeObserver;
        if (r18 != null) goto L23;
    L26:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
        return;
    L23:
        if (r18.isAlive() == false) goto L25;
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
    L25:
        this.mTreeObserver = null;
        goto L26
    L27:
        if (r11 == false) goto L31;
        this.mShowingMenus.get(0).menu.close(false);
        return;
    L31:
        return;
    L14:
        r16 = getInitialMenuPosition();
        goto L15
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int r10 = this.mShowingMenus.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        CascadingMenuInfo r12 = this.mShowingMenus.get(r11);
        if (r12.window.isShowing() == false) goto L9;
        r11 = r11 + 1;
    L9:
        if (r12 == null) goto L14;
        r12.menu.close(false);
        return;
    L14:
        return;
    L8:
        r12 = null;
        goto L9
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r10, int r11, KeyEvent r12) {
        if (r12.getAction() == 1) goto L5;
        return false;
    L5:
        if (r11 != 82) goto L10;
        dismiss();
        return true;
    L10:
        return false;
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
        Iterator<CascadingMenuInfo> r11 = this.mShowingMenus.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        CascadingMenuInfo r12 = r11.next();
        if (r10 != r12.menu) goto L4;
        r12.getListView().requestFocus();
        return true;
    L10:
        if (r10.hasVisibleItems() == false) goto L15;
        addMenu(r10);
        MenuPresenter.Callback r13 = this.mPresenterCallback;
        if (r13 == null) goto L14;
        r13.onOpenSubMenu(r10);
    L14:
        return true;
    L15:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(@NonNull View r10) {
        if (this.mAnchorView == r10) goto L6;
        this.mAnchorView = r10;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(r10));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.mPresenterCallback = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r10) {
        this.mForceShowIcon = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r10) {
        if (this.mRawDropDownGravity == r10) goto L6;
        this.mRawDropDownGravity = r10;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(r10, ViewCompat.getLayoutDirection(this.mAnchorView));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r10) {
        this.mHasXOffset = true;
        this.mXOffset = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener r10) {
        this.mOnDismissListener = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean r10) {
        this.mShowTitle = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int r10) {
        this.mHasYOffset = true;
        this.mYOffset = r10;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        Iterator<MenuBuilder> r10 = this.mPendingMenus.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        showMenu(r10.next());
        goto L7
    L9:
        this.mPendingMenus.clear();
        View r11 = this.mAnchorView;
        this.mShownAnchorView = r11;
        if (r11 != null) goto L12;
        return;
    L12:
        if (this.mTreeObserver != null) goto L14;
        boolean r12 = true;
    L15:
        ViewTreeObserver r13 = r11.getViewTreeObserver();
        this.mTreeObserver = r13;
        if (r12 == false) goto L18;
        r13.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L18:
        this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        return;
    L14:
        r12 = false;
        goto L15
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        Iterator<CascadingMenuInfo> r11 = this.mShowingMenus.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        MenuPopup.toMenuAdapter(r11.next().getListView().getAdapter()).notifyDataSetChanged();
        goto L4
    }
}
