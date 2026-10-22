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

    public BaseMenuWrapper(Context r5) {
        this.mContext = r5;
    }

    public final MenuItem getMenuItemWrapper(MenuItem r5) {
        if ((r5 instanceof SupportMenuItem) == false) goto L11;
        SupportMenuItem r10 = (SupportMenuItem) r5;
        if (this.mMenuItems != null) goto L7;
        this.mMenuItems = new SimpleArrayMap();
    L7:
        MenuItem r11 = this.mMenuItems.get(r10);
        if (r11 != null) goto L12;
        MenuItemWrapperICS r12 = new MenuItemWrapperICS(this.mContext, r10);
        this.mMenuItems.put(r10, r12);
        return r12;
    L12:
        return r11;
    L11:
        return r5;
    }

    public final SubMenu getSubMenuWrapper(SubMenu r5) {
        if ((r5 instanceof SupportSubMenu) == false) goto L11;
        SupportSubMenu r10 = (SupportSubMenu) r5;
        if (this.mSubMenus != null) goto L7;
        this.mSubMenus = new SimpleArrayMap();
    L7:
        SubMenu r11 = this.mSubMenus.get(r10);
        if (r11 != null) goto L12;
        SubMenuWrapperICS r12 = new SubMenuWrapperICS(this.mContext, r10);
        this.mSubMenus.put(r10, r12);
        return r12;
    L12:
        return r11;
    L11:
        return r5;
    }

    public final void internalClear() {
        SimpleArrayMap<SupportMenuItem, MenuItem> r5 = this.mMenuItems;
        if (r5 == null) goto L5;
        r5.clear();
    L5:
        SimpleArrayMap<SupportSubMenu, SubMenu> r10 = this.mSubMenus;
        if (r10 == null) goto L9;
        r10.clear();
        return;
    }

    public final void internalRemoveGroup(int r5) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.mMenuItems.size()) goto L12;
        if (this.mMenuItems.keyAt(r10).getGroupId() != r5) goto L11;
        this.mMenuItems.removeAt(r10);
        r10 = r10 - 1;
    L11:
        r10 = r10 + 1;
        goto L7
    }

    public final void internalRemoveItem(int r5) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.mMenuItems.size()) goto L15;
        if (this.mMenuItems.keyAt(r10).getItemId() == r5) goto L10;
        r10 = r10 + 1;
        goto L7
    L10:
        this.mMenuItems.removeAt(r10);
        return;
    }
}
