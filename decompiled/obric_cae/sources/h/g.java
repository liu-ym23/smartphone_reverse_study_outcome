package h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class g extends e implements SubMenu {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0.c f7863e;

    public g(Context r8, c0.c r10) {
        super(r8, r10);
        this.f7863e = r10;
    }

    @Override // android.view.SubMenu
    public final void clearHeader() {
        this.f7863e.clearHeader();
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return c(this.f7863e.getItem());
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int r8) {
        this.f7863e.setHeaderIcon(r8);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int r8) {
        this.f7863e.setHeaderTitle(r8);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View r8) {
        this.f7863e.setHeaderView(r8);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int r8) {
        this.f7863e.setIcon(r8);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable r8) {
        this.f7863e.setHeaderIcon(r8);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence r8) {
        this.f7863e.setHeaderTitle(r8);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable r8) {
        this.f7863e.setIcon(r8);
        return this;
    }
}
