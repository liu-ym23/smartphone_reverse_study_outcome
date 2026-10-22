package ub;

import android.view.View;
import ge.l;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements b.a<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f12582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f12583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f12584c;

    public h(l r8, l r10, l r11) {
        this.f12582a = r8;
        this.f12583b = r10;
        this.f12584c = r11;
    }

    @Override // ub.b.a
    public final void a(b<View> r8) {
        i.f(r8, "animator");
        this.f12584c.invoke(r8);
    }

    @Override // ub.b.a
    public final void b(b<View> r8) {
        i.f(r8, "animator");
        this.f12582a.invoke(r8);
    }
}
