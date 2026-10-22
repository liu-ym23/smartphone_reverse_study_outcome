package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.internal.view.SupportSubMenu;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    private final SupportSubMenu mSubMenu;

    public SubMenuWrapperICS(Context r5, SupportSubMenu r10) {
        super(r5, r10);
        this.mSubMenu = r10;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.mSubMenu.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return getMenuItemWrapper(this.mSubMenu.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int r5) {
        this.mSubMenu.setHeaderIcon(r5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r5) {
        this.mSubMenu.setHeaderTitle(r5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r5) {
        this.mSubMenu.setHeaderView(r5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r5) {
        this.mSubMenu.setIcon(r5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r5) {
        this.mSubMenu.setHeaderIcon(r5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r5) {
        this.mSubMenu.setHeaderTitle(r5);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r5) {
        this.mSubMenu.setIcon(r5);
        return this;
    }
}
