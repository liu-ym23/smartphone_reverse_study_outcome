package h;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import n.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h<c0.b, MenuItem> f7849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h<c0.c, SubMenu> f7850c;

    public b(Context r8) {
        this.f7848a = r8;
    }

    public final MenuItem c(MenuItem r8) {
        if ((r8 instanceof c0.b) == false) goto L11;
        c0.b r10 = (c0.b) r8;
        if (this.f7849b != null) goto L7;
        this.f7849b = new h();
    L7:
        MenuItem r11 = this.f7849b.getOrDefault(r10, null);
        if (r11 != null) goto L12;
        c r12 = new c(this.f7848a, r10);
        this.f7849b.put(r10, r12);
        return r12;
    L12:
        return r11;
    L11:
        return r8;
    }

    public final SubMenu d(SubMenu r8) {
        if ((r8 instanceof c0.c) == false) goto L11;
        c0.c r10 = (c0.c) r8;
        if (this.f7850c != null) goto L7;
        this.f7850c = new h();
    L7:
        SubMenu r11 = this.f7850c.getOrDefault(r10, null);
        if (r11 != null) goto L12;
        g r12 = new g(this.f7848a, r10);
        this.f7850c.put(r10, r12);
        return r12;
    L12:
        return r11;
    L11:
        return r8;
    }

    public final void e() {
        h<c0.b, MenuItem> r8 = this.f7849b;
        if (r8 == null) goto L5;
        r8.clear();
    L5:
        h<c0.c, SubMenu> r10 = this.f7850c;
        if (r10 == null) goto L9;
        r10.clear();
        return;
    }

    public final void f(int r8) {
        if (this.f7849b != null) goto L5;
        return;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.f7849b.size()) goto L12;
        if (this.f7849b.i(r10).getGroupId() != r8) goto L11;
        this.f7849b.j(r10);
        r10 = r10 - 1;
    L11:
        r10 = r10 + 1;
        goto L7
    }

    public final void g(int r8) {
        if (this.f7849b != null) goto L5;
        return;
    L5:
        int r10 = 0;
    L7:
        if (r10 >= this.f7849b.size()) goto L15;
        if (this.f7849b.i(r10).getItemId() == r8) goto L10;
        r10 = r10 + 1;
        goto L7
    L10:
        this.f7849b.j(r10);
        return;
    }
}
