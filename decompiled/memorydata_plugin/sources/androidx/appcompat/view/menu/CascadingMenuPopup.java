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
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CascadingMenuPopup extends MenuPopup implements View.OnKeyListener, PopupWindow.OnDismissListener, MenuPresenter {
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

        public CascadingMenuInfo(MenuPopupWindow r1, MenuBuilder r2, int r3) {
            this.window = r1;
            this.menu = r2;
            this.position = r3;
        }

        public ListView getListView() {
            return this.window.getListView();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    static {
        ITEM_LAYOUT = ZeusTransformUtils.mapRes(R.layout.abc_cascading_menu_item_layout, "layout", "abc_cascading_menu_item_layout");
    }

    public CascadingMenuPopup(Context r4, View r5, int r6, int r7, boolean r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mPendingMenus = new ArrayList();
        this.mShowingMenus = new ArrayList();
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mMenuItemHoverListener = new AnonymousClass3(this);
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.mAnchorView = r5;
        this.mPopupStyleAttr = r6;
        this.mPopupStyleRes = r7;
        this.mOverflowOnly = r8;
        this.mForceShowIcon = false;
        this.mLastPosition = getInitialMenuPosition();
        Resources r10 = ZeusTransformUtils.getResources(r9, "com.obric.memorydata.plugin");
        this.mMenuMaxWidth = Math.max(r10.getDisplayMetrics().widthPixels / 2, r10.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_config_prefDialogWidth, "dimen", "abc_config_prefDialogWidth")));
        this.mSubMenuHoverHandler = new Handler();
    }

    private MenuPopupWindow createPopupWindow() {
        MenuPopupWindow r0 = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        r0.setHoverListener(this.mMenuItemHoverListener);
        r0.setOnItemClickListener(this);
        r0.setOnDismissListener(this);
        r0.setAnchorView(this.mAnchorView);
        r0.setDropDownGravity(this.mDropDownGravity);
        r0.setModal(true);
        r0.setInputMethodMode(2);
        return r0;
    }

    private int findIndexOfAddedMenu(MenuBuilder r6) {
        int r0 = this.mShowingMenus.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r6 == ((CascadingMenuInfo) ZeusTransformUtils.preCheckCast(this.mShowingMenus.get(r1), CascadingMenuInfo.class, "com.obric.memorydata.plugin")).menu) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L8:
        return -1;
    }

    private MenuItem findMenuItemForSubmenu(MenuBuilder r4, MenuBuilder r5) {
        int r3 = r4.size();
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L10;
        MenuItem r1 = r4.getItem(r0);
        if (r1.hasSubMenu() == false) goto L9;
        if (r5 != r1.getSubMenu()) goto L9;
        return r1;
    L9:
        r0 = r0 + 1;
        goto L3
    L10:
        return null;
    }

    private View findParentViewForSubmenu(CascadingMenuInfo r7, MenuBuilder r8) {
        MenuItem r6 = findMenuItemForSubmenu(r7.menu, r8);
        if (r6 != null) goto L5;
        return null;
    L5:
        ListView r9 = r7.getListView();
        ListAdapter r0 = r9.getAdapter();
        int r2 = 0;
        if (ZeusTransformUtils.instanceOf(r0, HeaderViewListAdapter.class) == false) goto L8;
        HeaderViewListAdapter r1 = (HeaderViewListAdapter) ZeusTransformUtils.preCheckCast(r0, HeaderViewListAdapter.class, "com.obric.memorydata.plugin");
        int r3 = r1.getHeadersCount();
        MenuAdapter r4 = (MenuAdapter) ZeusTransformUtils.preCheckCast(r1.getWrappedAdapter(), MenuAdapter.class, "com.obric.memorydata.plugin");
    L9:
        int r5 = r4.getCount();
    L11:
        if (r2 >= r5) goto L16;
        if (r6 == r4.getItem(r2)) goto L17;
        r2 = r2 + 1;
    L17:
        if (r2 != (-1)) goto L19;
        return null;
    L19:
        int r10 = (r2 + r3) - r9.getFirstVisiblePosition();
        if (r10 >= 0) goto L22;
    L26:
        return null;
    L22:
        if (r10 >= r9.getChildCount()) goto L26;
        return r9.getChildAt(r10);
    L16:
        r2 = -1;
        goto L17
    L8:
        r4 = (MenuAdapter) ZeusTransformUtils.preCheckCast(r0, MenuAdapter.class, "com.obric.memorydata.plugin");
        r3 = 0;
        goto L9
    }

    private int getInitialMenuPosition() {
        if (ViewCompat.getLayoutDirection(this.mAnchorView) != 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    private int getNextMenuPosition(int r6) {
        List<CascadingMenuInfo> r0 = this.mShowingMenus;
        ListView r1 = ((CascadingMenuInfo) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), CascadingMenuInfo.class, "com.obric.memorydata.plugin")).getListView();
        int[] r2 = new int[2];
        r1.getLocationOnScreen(r2);
        Rect r3 = new Rect();
        this.mShownAnchorView.getWindowVisibleDisplayFrame(r3);
        if (this.mLastPosition != 1) goto L9;
        if (((r2[0] + r1.getWidth()) + r6) <= r3.right) goto L7;
        return 0;
    L7:
        return 1;
    L9:
        if ((r2[0] - r6) >= 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    private void showMenu(MenuBuilder r17) {
        LayoutInflater r2 = LayoutInflater.from(this.mContext);
        MenuAdapter r3 = new MenuAdapter(r17, r2, this.mOverflowOnly, ITEM_LAYOUT);
        if (isShowing() == true) goto L8;
        if (this.mForceShowIcon == false) goto L8;
        r3.setForceShowIcon(true);
    L10:
        int r4 = measureIndividualMenuWidth(r3, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow r6 = createPopupWindow();
        r6.setAdapter(r3);
        r6.setContentWidth(r4);
        r6.setDropDownGravity(this.mDropDownGravity);
        if (this.mShowingMenus.size() <= 0) goto L13;
        List<CascadingMenuInfo> r5 = this.mShowingMenus;
        CascadingMenuInfo r7 = (CascadingMenuInfo) ZeusTransformUtils.preCheckCast(r5.get(r5.size() - 1), CascadingMenuInfo.class, "com.obric.memorydata.plugin");
        View r9 = findParentViewForSubmenu(r7, r17);
    L15:
        if (r9 == null) goto L38;
        r6.setTouchModal(false);
        r6.setEnterTransition(null);
        int r11 = getNextMenuPosition(r4);
        if (r11 != 1) goto L19;
        boolean r12 = true;
    L20:
        this.mLastPosition = r11;
        if (Build.VERSION.SDK_INT < 26) goto L23;
        r6.setAnchorView(r9);
        int r8 = 0;
        int r13 = 0;
    L28:
        if ((this.mDropDownGravity & 5) != 5) goto L32;
        if (r12 == true) goto L34;
        r4 = r9.getWidth();
    L35:
        int r10 = r8 - r4;
    L36:
        r6.setHorizontalOffset(r10);
        r6.setOverlapAnchor(true);
        r6.setVerticalOffset(r13);
    L44:
        this.mShowingMenus.add(new CascadingMenuInfo(r6, r17, this.mLastPosition));
        r6.show();
        ListView r14 = r6.getListView();
        r14.setOnKeyListener(this);
        if (r7 == null) goto L47;
        return;
    L47:
        if (this.mShowTitle == true) goto L49;
        return;
    L49:
        if (r17.getHeaderTitle() == null) goto L54;
        FrameLayout r0 = (FrameLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(r2, ZeusTransformUtils.mapRes(R.layout.abc_popup_menu_header_item_layout, "layout", "abc_popup_menu_header_item_layout"), r14, false, "com.obric.memorydata.plugin"), FrameLayout.class, "com.obric.memorydata.plugin");
        TextView r15 = (TextView) ZeusTransformUtils.preCheckCast(r0.findViewById(android.R.id.title), TextView.class, "com.obric.memorydata.plugin");
        r0.setEnabled(false);
        r15.setText(r17.getHeaderTitle());
        r14.addHeaderView(r0, null, false);
        r6.show();
        return;
    L54:
        return;
    L34:
        r10 = r8 + r4;
        goto L36
    L32:
        if (r12 == false) goto L35;
        r4 = r9.getWidth();
        goto L34
    L23:
        int[] r16 = new int[2];
        this.mAnchorView.getLocationOnScreen(r16);
        int[] r18 = new int[2];
        r9.getLocationOnScreen(r18);
        if ((this.mDropDownGravity & 7) != 5) goto L26;
        r16[0] = r16[0] + this.mAnchorView.getWidth();
        r18[0] = r18[0] + r9.getWidth();
    L26:
        r8 = r18[0] - r16[0];
        r13 = r18[1] - r16[1];
        goto L28
    L19:
        r12 = false;
        goto L20
    L38:
        if (this.mHasXOffset == false) goto L41;
        r6.setHorizontalOffset(this.mXOffset);
    L41:
        if (this.mHasYOffset == false) goto L43;
        r6.setVerticalOffset(this.mYOffset);
    L43:
        r6.setEpicenterBounds(getEpicenterBounds());
        goto L44
    L13:
        r7 = null;
        r9 = null;
    L8:
        if (isShowing() == false) goto L10;
        r3.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r17));
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r2) {
        r2.addMenuPresenter(this, this.mContext);
        if (isShowing() == false) goto L5;
        showMenu(r2);
        return;
    L5:
        this.mPendingMenus.add(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int r0 = this.mShowingMenus.size();
        if (r0 <= 0) goto L10;
        CascadingMenuInfo[] r3 = (CascadingMenuInfo[]) ZeusTransformUtils.preCheckCast(this.mShowingMenus.toArray(new CascadingMenuInfo[r0]), CascadingMenuInfo[].class, "com.obric.memorydata.plugin");
        int r1 = r0 - 1;
    L5:
        if (r1 < 0) goto L14;
        CascadingMenuInfo r2 = r3[r1];
        if (r2.window.isShowing() == false) goto L9;
        r2.window.dismiss();
    L9:
        r1 = r1 - 1;
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
        List<CascadingMenuInfo> r2 = this.mShowingMenus;
        return ((CascadingMenuInfo) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), CascadingMenuInfo.class, "com.obric.memorydata.plugin")).getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.mShowingMenus.size() > 0) goto L5;
        return false;
    L5:
        if (((CascadingMenuInfo) ZeusTransformUtils.preCheckCast(this.mShowingMenus.get(0), CascadingMenuInfo.class, "com.obric.memorydata.plugin")).window.isShowing() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r7, boolean r8) {
        int r0 = findIndexOfAddedMenu(r7);
        if (r0 >= 0) goto L5;
        return;
    L5:
        int r1 = r0 + 1;
        if (r1 >= this.mShowingMenus.size()) goto L8;
        ((CascadingMenuInfo) ZeusTransformUtils.preCheckCast(this.mShowingMenus.get(r1), CascadingMenuInfo.class, "com.obric.memorydata.plugin")).menu.close(false);
    L8:
        CascadingMenuInfo r2 = (CascadingMenuInfo) ZeusTransformUtils.preCheckCast(this.mShowingMenus.remove(r0), CascadingMenuInfo.class, "com.obric.memorydata.plugin");
        r2.menu.removeMenuPresenter(this);
        if (this.mShouldCloseImmediately == false) goto L11;
        r2.window.setExitTransition(null);
        r2.window.setAnimationStyle(0);
    L11:
        r2.window.dismiss();
        int r3 = this.mShowingMenus.size();
        if (r3 <= 0) goto L14;
        int r4 = ((CascadingMenuInfo) ZeusTransformUtils.preCheckCast(this.mShowingMenus.get(r3 - 1), CascadingMenuInfo.class, "com.obric.memorydata.plugin")).position;
    L15:
        this.mLastPosition = r4;
        if (r3 != 0) goto L27;
        dismiss();
        MenuPresenter.Callback r9 = this.mPresenterCallback;
        if (r9 == null) goto L20;
        r9.onCloseMenu(r7, true);
    L20:
        ViewTreeObserver r10 = this.mTreeObserver;
        if (r10 != null) goto L23;
    L26:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mOnDismissListener.onDismiss();
        return;
    L23:
        if (r10.isAlive() == false) goto L25;
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
    L25:
        this.mTreeObserver = null;
        goto L26
    L27:
        if (r8 == false) goto L31;
        ((CascadingMenuInfo) ZeusTransformUtils.preCheckCast(this.mShowingMenus.get(0), CascadingMenuInfo.class, "com.obric.memorydata.plugin")).menu.close(false);
        return;
    L31:
        return;
    L14:
        r4 = getInitialMenuPosition();
        goto L15
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int r0 = this.mShowingMenus.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        CascadingMenuInfo r3 = (CascadingMenuInfo) ZeusTransformUtils.preCheckCast(this.mShowingMenus.get(r2), CascadingMenuInfo.class, "com.obric.memorydata.plugin");
        if (r3.window.isShowing() == false) goto L9;
        r2 = r2 + 1;
    L9:
        if (r3 == null) goto L14;
        r3.menu.close(false);
        return;
    L14:
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r1, int r2, KeyEvent r3) {
        if (r3.getAction() == 1) goto L5;
        return false;
    L5:
        if (r2 != 82) goto L10;
        dismiss();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r2) {
        Parcelable r1 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r2, Parcelable.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder r6) {
        Iterator<CascadingMenuInfo> r0 = this.mShowingMenus.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        CascadingMenuInfo r1 = (CascadingMenuInfo) ZeusTransformUtils.preCheckCast(r0.next(), CascadingMenuInfo.class, "com.obric.memorydata.plugin");
        if (r6 != r1.menu) goto L4;
        r1.getListView().requestFocus();
        return true;
    L10:
        if (r6.hasVisibleItems() == false) goto L15;
        addMenu(r6);
        MenuPresenter.Callback r5 = this.mPresenterCallback;
        if (r5 == null) goto L14;
        r5.onOpenSubMenu(r6);
    L14:
        return true;
    L15:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View r2) {
        if (this.mAnchorView == r2) goto L6;
        this.mAnchorView = r2;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(r2));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r3) {
        this.mPresenterCallback = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r3, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r1) {
        this.mForceShowIcon = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r2) {
        if (this.mRawDropDownGravity == r2) goto L6;
        this.mRawDropDownGravity = r2;
        this.mDropDownGravity = GravityCompat.getAbsoluteGravity(r2, ViewCompat.getLayoutDirection(this.mAnchorView));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r2) {
        this.mHasXOffset = true;
        this.mXOffset = r2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener r3) {
        this.mOnDismissListener = (PopupWindow.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, PopupWindow.OnDismissListener.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean r1) {
        this.mShowTitle = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int r2) {
        this.mHasYOffset = true;
        this.mYOffset = r2;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        Iterator<MenuBuilder> r0 = this.mPendingMenus.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        showMenu((MenuBuilder) ZeusTransformUtils.preCheckCast(r0.next(), MenuBuilder.class, "com.obric.memorydata.plugin"));
        goto L7
    L9:
        this.mPendingMenus.clear();
        View r1 = this.mAnchorView;
        this.mShownAnchorView = r1;
        if (r1 != null) goto L12;
        return;
    L12:
        if (this.mTreeObserver != null) goto L14;
        boolean r2 = true;
    L15:
        ViewTreeObserver r3 = r1.getViewTreeObserver();
        this.mTreeObserver = r3;
        if (r2 == false) goto L18;
        r3.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L18:
        this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        return;
    L14:
        r2 = false;
        goto L15
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r3) {
        Iterator<CascadingMenuInfo> r2 = this.mShowingMenus.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        toMenuAdapter(((CascadingMenuInfo) ZeusTransformUtils.preCheckCast(r2.next(), CascadingMenuInfo.class, "com.obric.memorydata.plugin")).getListView().getAdapter()).notifyDataSetChanged();
        goto L4
    }
}
