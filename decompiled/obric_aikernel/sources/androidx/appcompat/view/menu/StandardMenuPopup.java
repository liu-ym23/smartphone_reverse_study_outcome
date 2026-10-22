package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, View.OnKeyListener {
    private static final int ITEM_LAYOUT = 0;
    private final MenuAdapter mAdapter;
    private View mAnchorView;
    private final View.OnAttachStateChangeListener mAttachStateChangeListener;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener;
    private boolean mHasContentWidth;
    private final MenuBuilder mMenu;
    private PopupWindow.OnDismissListener mOnDismissListener;
    private final boolean mOverflowOnly;
    final MenuPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private MenuPresenter.Callback mPresenterCallback;
    private boolean mShowTitle;
    View mShownAnchorView;
    ViewTreeObserver mTreeObserver;
    private boolean mWasDismissed;

    static {
        ITEM_LAYOUT = R.layout.abc_popup_menu_item_layout;
    }

    public StandardMenuPopup(Context r10, MenuBuilder r11, View r12, int r13, int r14, boolean r15) {
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mDropDownGravity = 0;
        this.mContext = r10;
        this.mMenu = r11;
        this.mOverflowOnly = r15;
        this.mAdapter = new MenuAdapter(r11, LayoutInflater.from(r10), r15, ITEM_LAYOUT);
        this.mPopupStyleAttr = r13;
        this.mPopupStyleRes = r14;
        Resources r16 = r10.getResources();
        this.mPopupMaxWidth = Math.max(r16.getDisplayMetrics().widthPixels / 2, r16.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = r12;
        this.mPopup = new MenuPopupWindow(r10, null, r13, r14);
        r11.addMenuPresenter(this, r10);
    }

    private boolean tryShow() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mWasDismissed == true) goto L30;
        View r10 = this.mAnchorView;
        if (r10 == null) goto L30;
        this.mShownAnchorView = r10;
        this.mPopup.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mPopup.setModal(true);
        View r11 = this.mShownAnchorView;
        if (this.mTreeObserver != null) goto L13;
        boolean r12 = true;
    L14:
        ViewTreeObserver r13 = r11.getViewTreeObserver();
        this.mTreeObserver = r13;
        if (r12 == false) goto L17;
        r13.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L17:
        r11.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mPopup.setAnchorView(r11);
        this.mPopup.setDropDownGravity(this.mDropDownGravity);
        if (this.mHasContentWidth == true) goto L20;
        this.mContentWidth = MenuPopup.measureIndividualMenuWidth(this.mAdapter, null, this.mContext, this.mPopupMaxWidth);
        this.mHasContentWidth = true;
    L20:
        this.mPopup.setContentWidth(this.mContentWidth);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.setEpicenterBounds(getEpicenterBounds());
        this.mPopup.show();
        ListView r14 = this.mPopup.getListView();
        r14.setOnKeyListener(this);
        if (this.mShowTitle == true) goto L23;
    L28:
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.show();
        return true;
    L23:
        if (this.mMenu.getHeaderTitle() == null) goto L28;
        FrameLayout r15 = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, r14, false);
        TextView r16 = (TextView) r15.findViewById(android.R.id.title);
        if (r16 == null) goto L27;
        r16.setText(this.mMenu.getHeaderTitle());
    L27:
        r15.setEnabled(false);
        r14.addHeaderView(r15, null, false);
        goto L28
    L13:
        r12 = false;
    L30:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r10) {
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        if (isShowing() == false) goto L6;
        this.mPopup.dismiss();
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.mPopup.getListView();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.mWasDismissed == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mPopup.isShowing() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        if (r10 == this.mMenu) goto L5;
        return;
    L5:
        dismiss();
        MenuPresenter.Callback r12 = this.mPresenterCallback;
        if (r12 == null) goto L9;
        r12.onCloseMenu(r10, r11);
        return;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close();
        ViewTreeObserver r10 = this.mTreeObserver;
        if (r10 != null) goto L5;
    L8:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        PopupWindow.OnDismissListener r11 = this.mOnDismissListener;
        if (r11 == null) goto L12;
        r11.onDismiss();
        return;
    L12:
        return;
    L5:
        if (r10.isAlive() == true) goto L7;
        this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
    L7:
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
        this.mTreeObserver = null;
        goto L8
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
        if (r10.hasVisibleItems() == false) goto L14;
        MenuPopupHelper r11 = new MenuPopupHelper(this.mContext, r10, this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
        r11.setPresenterCallback(this.mPresenterCallback);
        r11.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r10));
        r11.setOnDismissListener(this.mOnDismissListener);
        this.mOnDismissListener = null;
        this.mMenu.close(false);
        int r12 = this.mPopup.getHorizontalOffset();
        int r13 = this.mPopup.getVerticalOffset();
        if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L8;
        r12 = r12 + this.mAnchorView.getWidth();
    L8:
        if (r11.tryShow(r12, r13) == false) goto L14;
        MenuPresenter.Callback r14 = this.mPresenterCallback;
        if (r14 == null) goto L15;
        r14.onOpenSubMenu(r10);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View r10) {
        this.mAnchorView = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.mPresenterCallback = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r10) {
        this.mAdapter.setForceShowIcon(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r10) {
        this.mDropDownGravity = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r10) {
        this.mPopup.setHorizontalOffset(r10);
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
        this.mPopup.setVerticalOffset(r10);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        this.mHasContentWidth = false;
        MenuAdapter r11 = this.mAdapter;
        if (r11 == null) goto L6;
        r11.notifyDataSetChanged();
        return;
    }
}
