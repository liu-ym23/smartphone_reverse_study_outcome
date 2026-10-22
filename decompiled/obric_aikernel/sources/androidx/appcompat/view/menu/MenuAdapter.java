package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class MenuAdapter extends BaseAdapter {
    MenuBuilder mAdapterMenu;
    private int mExpandedIndex;
    private boolean mForceShowIcon;
    private final LayoutInflater mInflater;
    private final int mItemLayoutRes;
    private final boolean mOverflowOnly;

    public MenuAdapter(MenuBuilder r10, LayoutInflater r11, boolean r12, int r13) {
        this.mExpandedIndex = -1;
        this.mOverflowOnly = r12;
        this.mInflater = r11;
        this.mAdapterMenu = r10;
        this.mItemLayoutRes = r13;
        findExpandedIndex();
    }

    void findExpandedIndex() {
        MenuItemImpl r10 = this.mAdapterMenu.getExpandedItem();
        if (r10 == null) goto L11;
        ArrayList<MenuItemImpl> r11 = this.mAdapterMenu.getNonActionItems();
        int r12 = r11.size();
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        if (r11.get(r13) == r10) goto L8;
        r13 = r13 + 1;
        goto L5
    L8:
        this.mExpandedIndex = r13;
        return;
    L11:
        this.mExpandedIndex = -1;
    }

    public MenuBuilder getAdapterMenu() {
        return this.mAdapterMenu;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r10 = this.mAdapterMenu.getNonActionItems();
    L7:
        if (this.mExpandedIndex >= 0) goto L11;
        return r10.size();
    L11:
        return r10.size() - 1;
    L5:
        r10 = this.mAdapterMenu.getVisibleItems();
        goto L7
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int r10) {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r11 = this.mAdapterMenu.getNonActionItems();
    L6:
        int r12 = this.mExpandedIndex;
        if (r12 < 0) goto L11;
        if (r10 < r12) goto L11;
        r10 = r10 + 1;
    L11:
        return r11.get(r10);
    L5:
        r11 = this.mAdapterMenu.getVisibleItems();
        goto L6
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r10) {
        return getItem(r10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (r11 != null) goto L5;
        r11 = this.mInflater.inflate(this.mItemLayoutRes, r12, false);
    L5:
        int r13 = getItem(r10).getGroupId();
        int r14 = r10 - 1;
        if (r14 < 0) goto L8;
        int r15 = getItem(r14).getGroupId();
    L9:
        ListMenuItemView r16 = (ListMenuItemView) r11;
        if (this.mAdapterMenu.isGroupDividerEnabled() == false) goto L13;
        if (r13 == r15) goto L13;
        boolean r17 = true;
    L14:
        r16.setGroupDividerEnabled(r17);
        MenuView.ItemView r18 = (MenuView.ItemView) r11;
        if (this.mForceShowIcon == false) goto L17;
        r16.setForceShowIcon(true);
    L17:
        r18.initialize(getItem(r10), 0);
        return r11;
    L13:
        r17 = false;
        goto L14
    L8:
        r15 = r13;
        goto L9
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean r10) {
        this.mForceShowIcon = r10;
    }
}
