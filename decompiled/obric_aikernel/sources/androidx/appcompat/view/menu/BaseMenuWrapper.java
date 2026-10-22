package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseMenuWrapper {
    final Context mContext;
    private SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    private SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(Context r10) {
        this.mContext = r10;
    }

    final MenuItem getMenuItemWrapper(MenuItem r10) {
        if ((r10 instanceof SupportMenuItem) == false) goto L11;
        SupportMenuItem r11 = (SupportMenuItem) r10;
        if (this.mMenuItems != null) goto L7;
        this.mMenuItems = new SimpleArrayMap();
    L7:
        MenuItem r12 = this.mMenuItems.get(r11);
        if (r12 != null) goto L12;
        MenuItemWrapperICS r13 = new MenuItemWrapperICS(this.mContext, r11);
        this.mMenuItems.put(r11, r13);
        return r13;
    L12:
        return r12;
    L11:
        return r10;
    }

    final SubMenu getSubMenuWrapper(SubMenu r10) {
        if ((r10 instanceof SupportSubMenu) == false) goto L11;
        SupportSubMenu r11 = (SupportSubMenu) r10;
        if (this.mSubMenus != null) goto L7;
        this.mSubMenus = new SimpleArrayMap();
    L7:
        SubMenu r12 = this.mSubMenus.get(r11);
        if (r12 != null) goto L12;
        SubMenuWrapperICS r13 = new SubMenuWrapperICS(this.mContext, r11);
        this.mSubMenus.put(r11, r13);
        return r13;
    L12:
        return r12;
    L11:
        return r10;
    }

    final void internalClear() {
        SimpleArrayMap<SupportMenuItem, MenuItem> r10 = this.mMenuItems;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        SimpleArrayMap<SupportSubMenu, SubMenu> r11 = this.mSubMenus;
        if (r11 == null) goto L9;
        r11.clear();
        return;
    }

    final void internalRemoveGroup(int r10) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.mMenuItems.size()) goto L12;
        if (this.mMenuItems.keyAt(r11).getGroupId() != r10) goto L11;
        this.mMenuItems.removeAt(r11);
        r11 = r11 - 1;
    L11:
        r11 = r11 + 1;
        goto L7
    }

    final void internalRemoveItem(int r10) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= this.mMenuItems.size()) goto L15;
        if (this.mMenuItems.keyAt(r11).getItemId() == r10) goto L10;
        r11 = r11 + 1;
        goto L7
    L10:
        this.mMenuItems.removeAt(r11);
        return;
    }
}
