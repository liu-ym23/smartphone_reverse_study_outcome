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

    public MenuAdapter(MenuBuilder r5, LayoutInflater r10, boolean r11, int r12) {
        this.mExpandedIndex = -1;
        this.mOverflowOnly = r11;
        this.mInflater = r10;
        this.mAdapterMenu = r5;
        this.mItemLayoutRes = r12;
        findExpandedIndex();
    }

    public void findExpandedIndex() {
        MenuItemImpl r5 = this.mAdapterMenu.getExpandedItem();
        if (r5 == null) goto L11;
        ArrayList<MenuItemImpl> r10 = this.mAdapterMenu.getNonActionItems();
        int r11 = r10.size();
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L11;
        if (r10.get(r12) == r5) goto L8;
        r12 = r12 + 1;
        goto L5
    L8:
        this.mExpandedIndex = r12;
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
        ArrayList<MenuItemImpl> r5 = this.mAdapterMenu.getNonActionItems();
    L7:
        if (this.mExpandedIndex >= 0) goto L11;
        return r5.size();
    L11:
        return r5.size() - 1;
    L5:
        r5 = this.mAdapterMenu.getVisibleItems();
        goto L7
    }

    public boolean getForceShowIcon() {
        return this.mForceShowIcon;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r5) {
        return getItem(r5);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r5) {
        return r5;
    }

    @Override // android.widget.Adapter
    public View getView(int r10, View r11, ViewGroup r12) {
        if (r11 != null) goto L5;
        r11 = this.mInflater.inflate(this.mItemLayoutRes, r12, false);
    L5:
        int r13 = getItem(r10).getGroupId();
        int r5 = r10 - 1;
        if (r5 < 0) goto L8;
        int r14 = getItem(r5).getGroupId();
    L9:
        ListMenuItemView r15 = (ListMenuItemView) r11;
        if (this.mAdapterMenu.isGroupDividerEnabled() == false) goto L13;
        if (r13 == r14) goto L13;
        boolean r16 = true;
    L14:
        r15.setGroupDividerEnabled(r16);
        MenuView.ItemView r17 = (MenuView.ItemView) r11;
        if (this.mForceShowIcon == false) goto L17;
        r15.setForceShowIcon(true);
    L17:
        r17.initialize(getItem(r10), 0);
        return r11;
    L13:
        r16 = false;
        goto L14
    L8:
        r14 = r13;
        goto L9
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        findExpandedIndex();
        super.notifyDataSetChanged();
    }

    public void setForceShowIcon(boolean r5) {
        this.mForceShowIcon = r5;
    }

    @Override // android.widget.Adapter
    public MenuItemImpl getItem(int r5) {
        if (this.mOverflowOnly == false) goto L5;
        ArrayList<MenuItemImpl> r10 = this.mAdapterMenu.getNonActionItems();
    L6:
        int r11 = this.mExpandedIndex;
        if (r11 < 0) goto L11;
        if (r5 < r11) goto L11;
        r5 = r5 + 1;
    L11:
        return r10.get(r5);
    L5:
        r10 = this.mAdapterMenu.getVisibleItems();
        goto L6
    }
}
