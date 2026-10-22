package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.internal.view.SupportSubMenu;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class SubMenuWrapperICS extends MenuWrapperICS implements SubMenu {
    private final SupportSubMenu mSubMenu;

    SubMenuWrapperICS(Context r3, SupportSubMenu r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        SupportSubMenu r6 = (SupportSubMenu) ZeusTransformUtils.wrapperContextForParams(r4, SupportSubMenu.class, "com.obric.memorydata.plugin");
        super(r5, r6);
        this.mSubMenu = r6;
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
    public SubMenu setHeaderIcon(int r2) {
        this.mSubMenu.setHeaderIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable r2) {
        this.mSubMenu.setHeaderIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int r2) {
        this.mSubMenu.setHeaderTitle(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence r3) {
        CharSequence r4 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        this.mSubMenu.setHeaderTitle(r4);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View r2) {
        this.mSubMenu.setHeaderView(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int r2) {
        this.mSubMenu.setIcon(r2);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable r2) {
        this.mSubMenu.setIcon(r2);
        return this;
    }
}
