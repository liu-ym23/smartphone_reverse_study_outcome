package g;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionMenuPresenter;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class e extends b implements androidx.appcompat.view.menu.f.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f7443m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ActionBarContextView f7444n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b.a f7445o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public WeakReference<View> f7446p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f7447q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.appcompat.view.menu.f f7448r;

    public e(Context r8, ActionBarContextView r10, b.a r11) {
        this.f7443m = r8;
        this.f7444n = r10;
        this.f7445o = r11;
        androidx.appcompat.view.menu.f r12 = new androidx.appcompat.view.menu.f(r10.getContext());
        r12.f826l = 1;
        this.f7448r = r12;
        r12.f819e = this;
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final boolean a(androidx.appcompat.view.menu.f r8, MenuItem r10) {
        return this.f7445o.a(this, r10);
    }

    @Override // androidx.appcompat.view.menu.f.a
    public final void b(androidx.appcompat.view.menu.f r8) {
        i();
        ActionMenuPresenter r10 = this.f7444n.f1091n;
        if (r10 == null) goto L6;
        r10.l();
        return;
    }

    @Override // g.b
    public final void c() {
        if (this.f7447q == false) goto L5;
        return;
    L5:
        this.f7447q = true;
        this.f7445o.b(this);
    }

    @Override // g.b
    public final View d() {
        WeakReference<View> r8 = this.f7446p;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.get();
    }

    @Override // g.b
    public final androidx.appcompat.view.menu.f e() {
        return this.f7448r;
    }

    @Override // g.b
    public final MenuInflater f() {
        return new g(this.f7444n.getContext());
    }

    @Override // g.b
    public final CharSequence g() {
        return this.f7444n.getSubtitle();
    }

    @Override // g.b
    public final CharSequence h() {
        return this.f7444n.getTitle();
    }

    @Override // g.b
    public final void i() {
        androidx.appcompat.view.menu.f r8 = this.f7448r;
        this.f7445o.d(this, r8);
    }

    @Override // g.b
    public final boolean j() {
        return this.f7444n.C;
    }

    @Override // g.b
    public final void k(View r8) {
        this.f7444n.setCustomView(r8);
        if (r8 == null) goto L5;
        WeakReference<View> r10 = new WeakReference(r8);
    L6:
        this.f7446p = r10;
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Override // g.b
    public final void l(int r8) {
        m(this.f7443m.getString(r8));
    }

    @Override // g.b
    public final void m(CharSequence r8) {
        this.f7444n.setSubtitle(r8);
    }

    @Override // g.b
    public final void n(int r8) {
        o(this.f7443m.getString(r8));
    }

    @Override // g.b
    public final void o(CharSequence r8) {
        this.f7444n.setTitle(r8);
    }

    @Override // g.b
    public final void p(boolean r8) {
        this.f7436b = r8;
        this.f7444n.setTitleOptional(r8);
    }
}
