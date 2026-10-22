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

    public SubMenuBuilder(Context r10, MenuBuilder r11, MenuItemImpl r12) {
        super(r10);
        this.mParentMenu = r11;
        this.mItem = r12;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean collapseItemActionView(MenuItemImpl r10) {
        return this.mParentMenu.collapseItemActionView(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    boolean dispatchMenuItemSelected(@NonNull MenuBuilder r10, @NonNull MenuItem r11) {
        if (super.dispatchMenuItemSelected(r10, r11) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mParentMenu.dispatchMenuItemSelected(r10, r11) == true) goto L8;
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public boolean expandItemActionView(MenuItemImpl r10) {
        return this.mParentMenu.expandItemActionView(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public String getActionViewStatesKey() {
        MenuItemImpl r10 = this.mItem;
        if (r10 == null) goto L5;
        int r11 = r10.getItemId();
    L6:
        if (r11 != 0) goto L10;
        return null;
    L10:
        return super.getActionViewStatesKey() + ":" + r11;
    L5:
        r11 = 0;
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
    public void setCallback(MenuBuilder.Callback r10) {
        this.mParentMenu.setCallback(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, androidx.core.internal.view.SupportMenu, android.view.Menu
    public void setGroupDividerEnabled(boolean r10) {
        this.mParentMenu.setGroupDividerEnabled(r10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r10) {
        return (SubMenu) super.setHeaderIconInt(r10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r10) {
        return (SubMenu) super.setHeaderIconInt(r10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r10) {
        return (SubMenu) super.setHeaderTitleInt(r10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r10) {
        return (SubMenu) super.setHeaderTitleInt(r10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r10) {
        return (SubMenu) super.setHeaderViewInt(r10);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r10) {
        this.mItem.setIcon(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r10) {
        this.mItem.setIcon(r10);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public void setQwertyMode(boolean r10) {
        this.mParentMenu.setQwertyMode(r10);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public void setShortcutsVisible(boolean r10) {
        this.mParentMenu.setShortcutsVisible(r10);
    }
}
