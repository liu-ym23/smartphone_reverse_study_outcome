package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    private MenuItemImpl mItem;
    private MenuBuilder mParentMenu;

    public SubMenuBuilder(Context r5, MenuBuilder r10, MenuItemImpl r11) {
        super(r5);
        this.mParentMenu = r10;
        this.mItem = r11;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl r5) {
        return this.mParentMenu.collapseItemActionView(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean dispatchMenuItemSelected(@NonNull MenuBuilder r5, @NonNull MenuItem r10) {
        if (super.dispatchMenuItemSelected(r5, r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mParentMenu.dispatchMenuItemSelected(r5, r10) == true) goto L8;
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl r5) {
        return this.mParentMenu.expandItemActionView(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        MenuItemImpl r5 = this.mItem;
        if (r5 == null) goto L5;
        int r10 = r5.getItemId();
    L6:
        if (r10 != 0) goto L10;
        return null;
    L10:
        return super.getActionViewStatesKey() + ":" + r10;
    L5:
        r10 = 0;
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
    public void setCallback(MenuBuilder.Callback r5) {
        this.mParentMenu.setCallback(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean r5) {
        this.mParentMenu.setGroupDividerEnabled(r5);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r5) {
        return (SubMenu) super.setHeaderIconInt(r5);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r5) {
        return (SubMenu) super.setHeaderTitleInt(r5);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r5) {
        return (SubMenu) super.setHeaderViewInt(r5);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r5) {
        this.mItem.setIcon(r5);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean r5) {
        this.mParentMenu.setQwertyMode(r5);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean r5) {
        this.mParentMenu.setShortcutsVisible(r5);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r5) {
        return (SubMenu) super.setHeaderIconInt(r5);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r5) {
        return (SubMenu) super.setHeaderTitleInt(r5);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r5) {
        this.mItem.setIcon(r5);
        return this;
    }
}
