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

    public MenuPopup() {
    }

    public static int measureIndividualMenuWidth(ListAdapter r10, ViewGroup r11, Context r12, int r13) {
        int r5 = 0;
        int r14 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r15 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r16 = r10.getCount();
        int r17 = 0;
        int r18 = 0;
        View r19 = null;
    L3:
        if (r5 >= r16) goto L15;
        int r20 = r10.getItemViewType(r5);
        if (r20 == r18) goto L7;
        r19 = null;
        r18 = r20;
    L7:
        if (r11 != null) goto L9;
        r11 = new FrameLayout(r12);
    L9:
        r19 = r10.getView(r5, r19, r11);
        r19.measure(r14, r15);
        int r21 = r19.getMeasuredWidth();
        if (r21 >= r13) goto L11;
        if (r21 <= r17) goto L14;
        r17 = r21;
    L14:
        r5 = r5 + 1;
        goto L3
    L11:
        return r13;
    L15:
        return r17;
    }

    public static boolean shouldPreserveIconSpacing(MenuBuilder r5) {
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L15;
        MenuItem r12 = r5.getItem(r11);
        if (r12.isVisible() == false) goto L9;
        if (r12.getIcon() == null) goto L9;
        return true;
    L9:
        r11 = r11 + 1;
        goto L3
    L15:
        return false;
    }

    public static MenuAdapter toMenuAdapter(ListAdapter r5) {
        if ((r5 instanceof HeaderViewListAdapter) == false) goto L7;
        return (MenuAdapter) ((HeaderViewListAdapter) r5).getWrappedAdapter();
    L7:
        return (MenuAdapter) r5;
    }

    public abstract void addMenu(MenuBuilder r5);

    public boolean closeMenuOnSubMenuOpened() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder r5, MenuItemImpl r10) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder r5, MenuItemImpl r10) {
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
    public MenuView getMenuView(ViewGroup r5) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context r5, @Nullable MenuBuilder r10) {
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r5, View r10, int r11, long r12) {
        ListAdapter r13 = (ListAdapter) r5.getAdapter();
        MenuBuilder r14 = toMenuAdapter(r13).mAdapterMenu;
        MenuItem r15 = (MenuItem) r13.getItem(r11);
        if (closeMenuOnSubMenuOpened() == false) goto L5;
        int r16 = 0;
    L6:
        r14.performItemAction(r15, this, r16);
        return;
    L5:
        r16 = 4;
        goto L6
    }

    public abstract void setAnchorView(View r5);

    public void setEpicenterBounds(Rect r5) {
        this.mEpicenterBounds = r5;
    }

    public abstract void setForceShowIcon(boolean r5);

    public abstract void setGravity(int r5);

    public abstract void setHorizontalOffset(int r5);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener r5);

    public abstract void setShowTitle(boolean r5);

    public abstract void setVerticalOffset(int r5);
}
