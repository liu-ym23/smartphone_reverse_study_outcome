package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    public SubMenuBuilder(Context r3, MenuBuilder r4, MenuItemImpl r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.mParentMenu = r4;
        this.mItem = r5;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl r1) {
        return this.mParentMenu.collapseItemActionView(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    boolean dispatchMenuItemSelected(MenuBuilder r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.memorydata.plugin");
        if (super.dispatchMenuItemSelected(r3, r5) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mParentMenu.dispatchMenuItemSelected(r3, r5) == true) goto L8;
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl r1) {
        return this.mParentMenu.expandItemActionView(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        MenuItemImpl r0 = this.mItem;
        if (r0 == null) goto L5;
        int r1 = r0.getItemId();
    L6:
        if (r1 != 0) goto L10;
        return null;
    L10:
        return super.getActionViewStatesKey() + ParameterizedMessage.ERROR_MSG_SEPARATOR + r1;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public MenuBuilder getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setCallback(MenuBuilder.Callback r3) {
        MenuBuilder.Callback r4 = (MenuBuilder.Callback) ZeusTransformUtils.wrapperContextForParams(r3, MenuBuilder.Callback.class, "com.obric.memorydata.plugin");
        this.mParentMenu.setCallback(r4);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean r1) {
        this.mParentMenu.setGroupDividerEnabled(r1);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r2) {
        return (SubMenu) ZeusTransformUtils.preCheckCast(super.setHeaderIconInt(r2), SubMenu.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r2) {
        return (SubMenu) ZeusTransformUtils.preCheckCast(super.setHeaderIconInt(r2), SubMenu.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r2) {
        return (SubMenu) ZeusTransformUtils.preCheckCast(super.setHeaderTitleInt(r2), SubMenu.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r3) {
        return (SubMenu) ZeusTransformUtils.preCheckCast(super.setHeaderTitleInt((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin")), SubMenu.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r2) {
        return (SubMenu) ZeusTransformUtils.preCheckCast(super.setHeaderViewInt(r2), SubMenu.class, "com.obric.memorydata.plugin");
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r2) {
        this.mItem.setIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r2) {
        this.mItem.setIcon(r2);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean r1) {
        this.mParentMenu.setQwertyMode(r1);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean r1) {
        this.mParentMenu.setShortcutsVisible(r1);
    }
}
