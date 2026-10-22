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

    SubMenuWrapperICS(Context r10, SupportSubMenu r11) {
        super(r10, r11);
        this.mSubMenu = r11;
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
    public SubMenu setHeaderIcon(int r10) {
        this.mSubMenu.setHeaderIcon(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r10) {
        this.mSubMenu.setHeaderIcon(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r10) {
        this.mSubMenu.setHeaderTitle(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r10) {
        this.mSubMenu.setHeaderTitle(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r10) {
        this.mSubMenu.setHeaderView(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r10) {
        this.mSubMenu.setIcon(r10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r10) {
        this.mSubMenu.setIcon(r10);
        return this;
    }
}
