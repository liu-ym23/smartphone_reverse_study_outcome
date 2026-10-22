package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {
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

    public StandardMenuPopup(Context r5, MenuBuilder r10, View r11, int r12, int r13, boolean r14) {
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mDropDownGravity = 0;
        this.mContext = r5;
        this.mMenu = r10;
        this.mOverflowOnly = r14;
        this.mAdapter = new MenuAdapter(r10, LayoutInflater.from(r5), r14, ITEM_LAYOUT);
        this.mPopupStyleAttr = r12;
        this.mPopupStyleRes = r13;
        Resources r15 = r5.getResources();
        this.mPopupMaxWidth = Math.max(r15.getDisplayMetrics().widthPixels / 2, r15.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.mAnchorView = r11;
        this.mPopup = new MenuPopupWindow(r5, null, r12, r13);
        r10.addMenuPresenter(this, r5);
    }

    private boolean tryShow() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mWasDismissed == true) goto L30;
        View r5 = this.mAnchorView;
        if (r5 == null) goto L30;
        this.mShownAnchorView = r5;
        this.mPopup.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mPopup.setModal(true);
        View r10 = this.mShownAnchorView;
        if (this.mTreeObserver != null) goto L13;
        boolean r11 = true;
    L14:
        ViewTreeObserver r12 = r10.getViewTreeObserver();
        this.mTreeObserver = r12;
        if (r11 == false) goto L17;
        r12.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L17:
        r10.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mPopup.setAnchorView(r10);
        this.mPopup.setDropDownGravity(this.mDropDownGravity);
        if (this.mHasContentWidth == true) goto L20;
        this.mContentWidth = MenuPopup.measureIndividualMenuWidth(this.mAdapter, null, this.mContext, this.mPopupMaxWidth);
        this.mHasContentWidth = true;
    L20:
        this.mPopup.setContentWidth(this.mContentWidth);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.setEpicenterBounds(getEpicenterBounds());
        this.mPopup.show();
        ListView r13 = this.mPopup.getListView();
        r13.setOnKeyListener(this);
        if (this.mShowTitle == true) goto L23;
    L28:
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.show();
        return true;
    L23:
        if (this.mMenu.getHeaderTitle() == null) goto L28;
        FrameLayout r14 = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R.layout.abc_popup_menu_header_item_layout, r13, false);
        TextView r15 = (TextView) r14.findViewById(android.R.id.title);
        if (r15 == null) goto L27;
        r15.setText(this.mMenu.getHeaderTitle());
    L27:
        r14.setEnabled(false);
        r13.addHeaderView(r14, null, false);
        goto L28
    L13:
        r11 = false;
    L30:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r5) {
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
    public void onCloseMenu(MenuBuilder r5, boolean r10) {
        if (r5 == this.mMenu) goto L5;
        return;
    L5:
        dismiss();
        MenuPresenter.Callback r11 = this.mPresenterCallback;
        if (r11 == null) goto L9;
        r11.onCloseMenu(r5, r10);
        return;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close();
        ViewTreeObserver r5 = this.mTreeObserver;
        if (r5 != null) goto L5;
    L8:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        PopupWindow.OnDismissListener r10 = this.mOnDismissListener;
        if (r10 == null) goto L12;
        r10.onDismiss();
        return;
    L12:
        return;
    L5:
        if (r5.isAlive() == true) goto L7;
        this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
    L7:
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
        this.mTreeObserver = null;
        goto L8
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
    public boolean onSubMenuSelected(SubMenuBuilder r10) {
        if (r10.hasVisibleItems() == false) goto L14;
        MenuPopupHelper r5 = new MenuPopupHelper(this.mContext, r10, this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
        r5.setPresenterCallback(this.mPresenterCallback);
        r5.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r10));
        r5.setOnDismissListener(this.mOnDismissListener);
        this.mOnDismissListener = null;
        this.mMenu.close(false);
        int r11 = this.mPopup.getHorizontalOffset();
        int r12 = this.mPopup.getVerticalOffset();
        if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L8;
        r11 = r11 + this.mAnchorView.getWidth();
    L8:
        if (r5.tryShow(r11, r12) == false) goto L14;
        MenuPresenter.Callback r13 = this.mPresenterCallback;
        if (r13 == null) goto L15;
        r13.onOpenSubMenu(r10);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View r5) {
        this.mAnchorView = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r5) {
        this.mPresenterCallback = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r5) {
        this.mAdapter.setForceShowIcon(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r5) {
        this.mDropDownGravity = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r5) {
        this.mPopup.setHorizontalOffset(r5);
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
        this.mPopup.setVerticalOffset(r5);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r5) {
        this.mHasContentWidth = false;
        MenuAdapter r10 = this.mAdapter;
        if (r10 == null) goto L6;
        r10.notifyDataSetChanged();
        return;
    }
}
