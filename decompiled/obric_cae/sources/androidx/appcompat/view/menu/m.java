package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class m extends f implements SubMenu {
    public final f A;
    public final h B;

    public m(Context r8, f r10, h r11) {
        super(r8);
        this.A = r10;
        this.B = r11;
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean e(h r8) {
        return this.A.e(r8);
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean f(f r8, MenuItem r10) {
        if (super.f(r8, r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.A.f(r8, r10) == true) goto L8;
        return false;
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean g(h r8) {
        return this.A.g(r8);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.B;
    }

    @Override // androidx.appcompat.view.menu.f
    public final String k() {
        h r8 = this.B;
        if (r8 == null) goto L5;
        int r10 = r8.f843a;
    L6:
        if (r10 != 0) goto L10;
        return null;
    L10:
        return defpackage.a.d("android:menu:actionviewstates:", r10);
    L5:
        r10 = 0;
        goto L6
    }

    @Override // androidx.appcompat.view.menu.f
    public final f l() {
        return this.A.l();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean n() {
        return this.A.n();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean o() {
        return this.A.o();
    }

    @Override // androidx.appcompat.view.menu.f
    public final boolean p() {
        return this.A.p();
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setGroupDividerEnabled(boolean r8) {
        this.A.setGroupDividerEnabled(r8);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int r8) {
        w(0, null, r8, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int r8) {
        w(r8, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View r8) {
        w(0, null, 0, null, r8);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int r8) {
        this.B.setIcon(r8);
        return this;
    }

    @Override // androidx.appcompat.view.menu.f, android.view.Menu
    public final void setQwertyMode(boolean r8) {
        this.A.setQwertyMode(r8);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable r8) {
        w(0, null, 0, r8, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence r8) {
        w(0, r8, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable r8) {
        this.B.setIcon(r8);
        return this;
    }
}
