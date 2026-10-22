package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AlertController;
import com.obric.cae.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d implements j, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LayoutInflater f801b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f802m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ExpandedMenuView f803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j.a f804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public a f805p;

    public class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f807b;

        public a(d r8) {
            this.f807b = r8;
            this.f806a = -1;
            b();
        }

        public final void b() {
            f r8 = this.f807b.f802m;
            h r10 = r8.f837w;
            if (r10 == null) goto L11;
            r8.j();
            ArrayList<h> r11 = r8.f824j;
            int r12 = r11.size();
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L11;
            if (r11.get(r13) == r10) goto L8;
            r13 = r13 + 1;
            goto L5
        L8:
            this.f806a = r13;
            return;
        L11:
            this.f806a = -1;
        }

        public final h c(int r8) {
            d r10 = this.f807b;
            f r11 = r10.f802m;
            r11.j();
            ArrayList<h> r12 = r11.f824j;
            r10.getClass();
            int r13 = r8 + 0;
            int r14 = this.f806a;
            if (r14 < 0) goto L7;
            if (r13 < r14) goto L7;
            r13 = r13 + 1;
        L7:
            return r12.get(r13);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            d r8 = this.f807b;
            f r10 = r8.f802m;
            r10.j();
            int r11 = r10.f824j.size();
            r8.getClass();
            int r12 = r11 + 0;
            if (this.f806a >= 0) goto L6;
            return r12;
        L6:
            return r12 - 1;
        }

        @Override // android.widget.Adapter
        public final /* bridge */ /* synthetic */ Object getItem(int r8) {
            return c(r8);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int r8) {
            return r8;
        }

        @Override // android.widget.Adapter
        public final View getView(int r8, View r10, ViewGroup r11) {
            if (r10 != null) goto L4;
            r10 = this.f807b.f801b.inflate(R.layout.abc_list_menu_item_layout, r11, false);
        L4:
            ((k.a) r10).c(c(r8));
            return r10;
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            b();
            super.notifyDataSetChanged();
        }
    }

    public d(Context r8) {
        this.f800a = r8;
        this.f801b = LayoutInflater.from(r8);
    }

    @Override // androidx.appcompat.view.menu.j
    public final void a(f r8, boolean r10) {
        j.a r11 = this.f804o;
        if (r11 == null) goto L6;
        r11.a(r8, r10);
        return;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void b(j.a r8) {
        this.f804o = r8;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c(h r8) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void d() {
        a r8 = this.f805p;
        if (r8 == null) goto L6;
        r8.notifyDataSetChanged();
        return;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean e(m r8) {
        if (r8.hasVisibleItems() == true) goto L6;
        return false;
    L6:
        g r10 = new g(r8);
        androidx.appcompat.app.d.a r11 = new androidx.appcompat.app.d.a(r8.f815a);
        AlertController.b r12 = r11.f642a;
        d r13 = new d(r12.f562a);
        r10.f842m = r13;
        r13.f804o = r10;
        r8.b(r13);
        r12.f568g = r10.f842m.i();
        r12.f569h = r10;
        View r14 = r8.f829o;
        if (r14 == null) goto L9;
        r12.f566e = r14;
    L10:
        r12.f567f = r10;
        androidx.appcompat.app.d r15 = r11.a();
        r10.f841b = r15;
        r15.setOnDismissListener(r10);
        WindowManager.LayoutParams r16 = r10.f841b.getWindow().getAttributes();
        r16.type = 1003;
        r16.flags |= 131072;
        r10.f841b.show();
        j.a r17 = this.f804o;
        if (r17 == null) goto L15;
        r17.b(r8);
        return true;
    L15:
        return true;
    L9:
        r12.f564c = r8.f828n;
        r12.f565d = r8.f827m;
        goto L10
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean f(h r8) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean g() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void h(Context r8, f r10) {
        if (this.f800a == null) goto L7;
        this.f800a = r8;
        if (this.f801b != null) goto L7;
        this.f801b = LayoutInflater.from(r8);
    L7:
        this.f802m = r10;
        a r11 = this.f805p;
        if (r11 == null) goto L11;
        r11.notifyDataSetChanged();
        return;
    }

    public final a i() {
        if (this.f805p != null) goto L6;
        this.f805p = new a(this);
    L6:
        return this.f805p;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> r8, View r10, int r11, long r12) {
        this.f802m.s(this.f805p.c(r11), this, 0);
    }
}
