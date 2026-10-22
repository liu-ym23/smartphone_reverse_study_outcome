package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f809b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f811n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LayoutInflater f812o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f813p;

    public e(f r8, LayoutInflater r10, boolean r11, int r12) {
        this.f809b = -1;
        this.f811n = r11;
        this.f812o = r10;
        this.f808a = r8;
        this.f813p = r12;
        b();
    }

    public final void b() {
        f r8 = this.f808a;
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
        this.f809b = r13;
        return;
    L11:
        this.f809b = -1;
    }

    public final h c(int r8) {
        boolean r10 = this.f811n;
        f r11 = this.f808a;
        if (r10 == false) goto L5;
        r11.j();
        ArrayList<h> r12 = r11.f824j;
    L6:
        int r13 = this.f809b;
        if (r13 < 0) goto L11;
        if (r8 < r13) goto L11;
        r8 = r8 + 1;
    L11:
        return r12.get(r8);
    L5:
        r12 = r11.m();
        goto L6
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        boolean r8 = this.f811n;
        f r10 = this.f808a;
        if (r8 == false) goto L5;
        r10.j();
        ArrayList<h> r11 = r10.f824j;
    L7:
        if (this.f809b >= 0) goto L11;
        return r11.size();
    L11:
        return r11.size() - 1;
    L5:
        r11 = r10.m();
        goto L7
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
        boolean r12 = false;
        if (r10 != null) goto L5;
        r10 = this.f812o.inflate(this.f813p, r11, false);
    L5:
        int r13 = c(r8).f844b;
        int r14 = r8 - 1;
        if (r14 < 0) goto L8;
        int r15 = c(r14).f844b;
    L9:
        ListMenuItemView r16 = (ListMenuItemView) r10;
        if (this.f808a.n() == false) goto L13;
        if (r13 == r15) goto L13;
        r12 = true;
    L13:
        r16.setGroupDividerEnabled(r12);
        k.a r17 = (k.a) r10;
        if (this.f810m == false) goto L16;
        r16.setForceShowIcon(true);
    L16:
        r17.c(c(r8));
        return r10;
    L8:
        r15 = r13;
        goto L9
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        b();
        super.notifyDataSetChanged();
    }
}
