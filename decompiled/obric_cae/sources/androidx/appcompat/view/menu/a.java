package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import com.obric.cae.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f768b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public f f769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LayoutInflater f770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public j.a f771o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f772p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f773q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public k f774r;

    public a(Context r8) {
        this.f767a = r8;
        this.f770n = LayoutInflater.from(r8);
        this.f772p = R.layout.abc_action_menu_layout;
        this.f773q = R.layout.abc_action_menu_item_layout;
    }

    @Override // androidx.appcompat.view.menu.j
    public final void b(j.a r8) {
        this.f771o = r8;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean c(h r8) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public final boolean f(h r8) {
        return false;
    }
}
