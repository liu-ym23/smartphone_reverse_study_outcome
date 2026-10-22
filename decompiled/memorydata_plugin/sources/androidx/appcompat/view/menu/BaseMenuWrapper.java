package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class BaseMenuWrapper {
    final Context mContext;
    private SimpleArrayMap<SupportMenuItem, MenuItem> mMenuItems;
    private SimpleArrayMap<SupportSubMenu, SubMenu> mSubMenus;

    BaseMenuWrapper(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    final MenuItem getMenuItemWrapper(MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SupportMenuItem.class) == false) goto L11;
        SupportMenuItem r6 = (SupportMenuItem) ZeusTransformUtils.preCheckCast(r5, SupportMenuItem.class, "com.obric.memorydata.plugin");
        if (this.mMenuItems != null) goto L7;
        this.mMenuItems = new SimpleArrayMap();
    L7:
        MenuItem r0 = (MenuItem) ZeusTransformUtils.preCheckCast(this.mMenuItems.get(r6), MenuItem.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
        MenuItemWrapperICS r1 = new MenuItemWrapperICS(this.mContext, r6);
        this.mMenuItems.put(r6, r1);
        return r1;
    L12:
        return r0;
    L11:
        return r5;
    }

    final SubMenu getSubMenuWrapper(SubMenu r4) {
        SubMenu r5 = (SubMenu) ZeusTransformUtils.wrapperContextForParams(r4, SubMenu.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SupportSubMenu.class) == false) goto L11;
        SupportSubMenu r6 = (SupportSubMenu) ZeusTransformUtils.preCheckCast(r5, SupportSubMenu.class, "com.obric.memorydata.plugin");
        if (this.mSubMenus != null) goto L7;
        this.mSubMenus = new SimpleArrayMap();
    L7:
        SubMenu r0 = (SubMenu) ZeusTransformUtils.preCheckCast(this.mSubMenus.get(r6), SubMenu.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L12;
        SubMenuWrapperICS r1 = new SubMenuWrapperICS(this.mContext, r6);
        this.mSubMenus.put(r6, r1);
        return r1;
    L12:
        return r0;
    L11:
        return r5;
    }

    final void internalClear() {
        SimpleArrayMap<SupportMenuItem, MenuItem> r0 = this.mMenuItems;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        SimpleArrayMap<SupportSubMenu, SubMenu> r1 = this.mSubMenus;
        if (r1 == null) goto L9;
        r1.clear();
        return;
    }

    final void internalRemoveGroup(int r5) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mMenuItems.size()) goto L12;
        if (((SupportMenuItem) ZeusTransformUtils.preCheckCast(this.mMenuItems.keyAt(r0), SupportMenuItem.class, "com.obric.memorydata.plugin")).getGroupId() != r5) goto L11;
        this.mMenuItems.removeAt(r0);
        r0 = r0 - 1;
    L11:
        r0 = r0 + 1;
        goto L7
    }

    final void internalRemoveItem(int r5) {
        if (this.mMenuItems != null) goto L5;
        return;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= this.mMenuItems.size()) goto L15;
        if (((SupportMenuItem) ZeusTransformUtils.preCheckCast(this.mMenuItems.keyAt(r0), SupportMenuItem.class, "com.obric.memorydata.plugin")).getItemId() == r5) goto L10;
        r0 = r0 + 1;
        goto L7
    L10:
        this.mMenuItems.removeAt(r0);
        return;
    }
}
