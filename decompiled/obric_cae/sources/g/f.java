package g;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f extends ActionMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f7450b;

    public static class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f7451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f7452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList<f> f7453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final n.h<Menu, Menu> f7454d;

        public a(Context r8, ActionMode.Callback r10) {
            this.f7452b = r8;
            this.f7451a = r10;
            this.f7453c = new ArrayList();
            this.f7454d = new n.h();
        }

        @Override // g.b.a
        public final boolean a(b r8, MenuItem r10) {
            f r11 = e(r8);
            h.c r12 = new h.c(this.f7452b, (c0.b) r10);
            return this.f7451a.onActionItemClicked(r11, r12);
        }

        @Override // g.b.a
        public final void b(b r8) {
            f r10 = e(r8);
            this.f7451a.onDestroyActionMode(r10);
        }

        @Override // g.b.a
        public final boolean c(b r8, androidx.appcompat.view.menu.f r10) {
            f r11 = e(r8);
            n.h<Menu, Menu> r12 = this.f7454d;
            Menu r13 = r12.getOrDefault(r10, null);
            if (r13 != null) goto L6;
            r13 = new h.e(this.f7452b, r10);
            r12.put(r10, r13);
        L6:
            return this.f7451a.onCreateActionMode(r11, r13);
        }

        @Override // g.b.a
        public final boolean d(b r8, androidx.appcompat.view.menu.f r10) {
            f r11 = e(r8);
            n.h<Menu, Menu> r12 = this.f7454d;
            Menu r13 = r12.getOrDefault(r10, null);
            if (r13 != null) goto L6;
            r13 = new h.e(this.f7452b, r10);
            r12.put(r10, r13);
        L6:
            return this.f7451a.onPrepareActionMode(r11, r13);
        }

        public final f e(b r8) {
            ArrayList<f> r10 = this.f7453c;
            int r11 = r10.size();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L10;
            f r13 = r10.get(r12);
            if (r13 == null) goto L9;
            if (r13.f7450b != r8) goto L9;
            return r13;
        L9:
            r12 = r12 + 1;
            goto L3
        L10:
            f r14 = new f(this.f7452b, r8);
            r10.add(r14);
            return r14;
        }
    }

    public f(Context r8, b r10) {
        this.f7449a = r8;
        this.f7450b = r10;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f7450b.c();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f7450b.d();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        androidx.appcompat.view.menu.f r8 = this.f7450b.e();
        return new h.e(this.f7449a, r8);
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f7450b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f7450b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f7450b.f7435a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f7450b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f7450b.f7436b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f7450b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f7450b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View r8) {
        this.f7450b.k(r8);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int r8) {
        this.f7450b.l(r8);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object r8) {
        this.f7450b.f7435a = r8;
    }

    @Override // android.view.ActionMode
    public final void setTitle(int r8) {
        this.f7450b.n(r8);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean r8) {
        this.f7450b.p(r8);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence r8) {
        this.f7450b.m(r8);
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence r8) {
        this.f7450b.o(r8);
    }
}
