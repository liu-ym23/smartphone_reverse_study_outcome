package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {
    private Rect mEpicenterBounds;

    MenuPopup() {
    }

    protected static int measureIndividualMenuWidth(ListAdapter r10, ViewGroup r11, Context r12, int r13) {
        int r14 = 0;
        int r15 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r16 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r17 = r10.getCount();
        int r18 = 0;
        int r19 = 0;
        View r20 = null;
    L3:
        if (r14 >= r17) goto L15;
        int r21 = r10.getItemViewType(r14);
        if (r21 == r19) goto L7;
        r20 = null;
        r19 = r21;
    L7:
        if (r11 != null) goto L9;
        r11 = new FrameLayout(r12);
    L9:
        r20 = r10.getView(r14, r20, r11);
        r20.measure(r15, r16);
        int r22 = r20.getMeasuredWidth();
        if (r22 >= r13) goto L11;
        if (r22 <= r18) goto L14;
        r18 = r22;
    L14:
        r14 = r14 + 1;
        goto L3
    L11:
        return r13;
    L15:
        return r18;
    }

    protected static boolean shouldPreserveIconSpacing(MenuBuilder r10) {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L15;
        MenuItem r13 = r10.getItem(r12);
        if (r13.isVisible() == false) goto L9;
        if (r13.getIcon() == null) goto L9;
        return true;
    L9:
        r12 = r12 + 1;
        goto L3
    L15:
        return false;
    }

    protected static MenuAdapter toMenuAdapter(ListAdapter r10) {
        if ((r10 instanceof HeaderViewListAdapter) == false) goto L7;
        return (MenuAdapter) ((HeaderViewListAdapter) r10).getWrappedAdapter();
    L7:
        return (MenuAdapter) r10;
    }

    public abstract void addMenu(MenuBuilder r10);

    protected boolean closeMenuOnSubMenuOpened() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r10, MenuItemImpl r11) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r10, MenuItemImpl r11) {
        return false;
    }

    public Rect getEpicenterBounds() {
        return this.mEpicenterBounds;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup r10) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r10, @Nullable MenuBuilder r11) {
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r10, View r11, int r12, long r13) {
        ListAdapter r14 = (ListAdapter) r10.getAdapter();
        MenuBuilder r15 = toMenuAdapter(r14).mAdapterMenu;
        MenuItem r16 = (MenuItem) r14.getItem(r12);
        if (closeMenuOnSubMenuOpened() == false) goto L5;
        int r17 = 0;
    L6:
        r15.performItemAction(r16, this, r17);
        return;
    L5:
        r17 = 4;
        goto L6
    }

    public abstract void setAnchorView(View r10);

    public void setEpicenterBounds(Rect r10) {
        this.mEpicenterBounds = r10;
    }

    public abstract void setForceShowIcon(boolean r10);

    public abstract void setGravity(int r10);

    public abstract void setHorizontalOffset(int r10);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener r10);

    public abstract void setShowTitle(boolean r10);

    public abstract void setVerticalOffset(int r10);
}
