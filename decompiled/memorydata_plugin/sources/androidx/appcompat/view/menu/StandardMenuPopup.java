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
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class StandardMenuPopup extends MenuPopup implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener, MenuPresenter {
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
        ITEM_LAYOUT = ZeusTransformUtils.mapRes(R.layout.abc_popup_menu_item_layout, "layout", "abc_popup_menu_item_layout");
    }

    public StandardMenuPopup(Context r6, MenuBuilder r7, View r8, int r9, int r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.mGlobalLayoutListener = new AnonymousClass1(this);
        this.mAttachStateChangeListener = new AnonymousClass2(this);
        this.mDropDownGravity = 0;
        Context r0 = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");
        this.mContext = r0;
        this.mMenu = r7;
        this.mOverflowOnly = r11;
        this.mAdapter = new MenuAdapter(r7, LayoutInflater.from(r12), r11, ITEM_LAYOUT);
        this.mPopupStyleAttr = r9;
        this.mPopupStyleRes = r10;
        Resources r13 = ZeusTransformUtils.getResources(r12, "com.obric.memorydata.plugin");
        this.mPopupMaxWidth = Math.max(r13.getDisplayMetrics().widthPixels / 2, r13.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.abc_config_prefDialogWidth, "dimen", "abc_config_prefDialogWidth")));
        this.mAnchorView = r8;
        this.mPopup = new MenuPopupWindow(r0, null, r9, r10);
        r7.addMenuPresenter(this, r12);
    }

    private boolean tryShow() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.mWasDismissed == true) goto L30;
        View r0 = this.mAnchorView;
        if (r0 == null) goto L30;
        this.mShownAnchorView = r0;
        this.mPopup.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mPopup.setModal(true);
        View r1 = this.mShownAnchorView;
        if (this.mTreeObserver != null) goto L13;
        boolean r3 = true;
    L14:
        ViewTreeObserver r4 = r1.getViewTreeObserver();
        this.mTreeObserver = r4;
        if (r3 == false) goto L17;
        r4.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
    L17:
        r1.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
        this.mPopup.setAnchorView(r1);
        this.mPopup.setDropDownGravity(this.mDropDownGravity);
        if (this.mHasContentWidth == true) goto L20;
        this.mContentWidth = measureIndividualMenuWidth(this.mAdapter, null, this.mContext, this.mPopupMaxWidth);
        this.mHasContentWidth = true;
    L20:
        this.mPopup.setContentWidth(this.mContentWidth);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.setEpicenterBounds(getEpicenterBounds());
        this.mPopup.show();
        ListView r2 = this.mPopup.getListView();
        r2.setOnKeyListener(this);
        if (this.mShowTitle == true) goto L23;
    L28:
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.show();
        return true;
    L23:
        if (this.mMenu.getHeaderTitle() == null) goto L28;
        FrameLayout r5 = (FrameLayout) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.inflate(LayoutInflater.from(this.mContext), ZeusTransformUtils.mapRes(R.layout.abc_popup_menu_header_item_layout, "layout", "abc_popup_menu_header_item_layout"), r2, false, "com.obric.memorydata.plugin"), FrameLayout.class, "com.obric.memorydata.plugin");
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r5.findViewById(android.R.id.title), TextView.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L27;
        r6.setText(this.mMenu.getHeaderTitle());
    L27:
        r5.setEnabled(false);
        r2.addHeaderView(r5, null, false);
        goto L28
    L13:
        r3 = false;
    L30:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder r1) {
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
    public void onCloseMenu(MenuBuilder r2, boolean r3) {
        if (r2 == this.mMenu) goto L5;
        return;
    L5:
        dismiss();
        MenuPresenter.Callback r1 = this.mPresenterCallback;
        if (r1 == null) goto L9;
        r1.onCloseMenu(r2, r3);
        return;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close();
        ViewTreeObserver r0 = this.mTreeObserver;
        if (r0 != null) goto L5;
    L8:
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        PopupWindow.OnDismissListener r2 = this.mOnDismissListener;
        if (r2 == null) goto L12;
        r2.onDismiss();
        return;
    L12:
        return;
    L5:
        if (r0.isAlive() == true) goto L7;
        this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
    L7:
        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
        this.mTreeObserver = null;
        goto L8
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
    public boolean onSubMenuSelected(SubMenuBuilder r10) {
        if (r10.hasVisibleItems() == false) goto L14;
        MenuPopupHelper r0 = new MenuPopupHelper(this.mContext, r10, this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
        r0.setPresenterCallback(this.mPresenterCallback);
        r0.setForceShowIcon(MenuPopup.shouldPreserveIconSpacing(r10));
        r0.setOnDismissListener(this.mOnDismissListener);
        this.mOnDismissListener = null;
        this.mMenu.close(false);
        int r2 = this.mPopup.getHorizontalOffset();
        int r3 = this.mPopup.getVerticalOffset();
        if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) != 5) goto L8;
        r2 = r2 + this.mAnchorView.getWidth();
    L8:
        if (r0.tryShow(r2, r3) == false) goto L14;
        MenuPresenter.Callback r9 = this.mPresenterCallback;
        if (r9 == null) goto L15;
        r9.onOpenSubMenu(r10);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View r1) {
        this.mAnchorView = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r3) {
        this.mPresenterCallback = (MenuPresenter.Callback) ZeusTransformUtils.wrapperContextForParams(r3, MenuPresenter.Callback.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean r1) {
        this.mAdapter.setForceShowIcon(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int r1) {
        this.mDropDownGravity = r1;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int r1) {
        this.mPopup.setHorizontalOffset(r1);
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
    public void setVerticalOffset(int r1) {
        this.mPopup.setVerticalOffset(r1);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (tryShow() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r1) {
        this.mHasContentWidth = false;
        MenuAdapter r0 = this.mAdapter;
        if (r0 == null) goto L6;
        r0.notifyDataSetChanged();
        return;
    }
}
