package dc;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements m, hc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge.l f7072a;

    public /* synthetic */ l(ge.l r8) {
        this.f7072a = r8;
    }

    @Override // dc.m
    public void a(Context r8, FrameLayout r10) {
        this.f7072a.invoke(r10);
    }

    @Override // hc.f
    public void b(fc.a r8) {
        he.i.f(r8, "dialog");
    }

    @Override // hc.f
    public void c(Context r8, hc.d r10) {
        he.i.f(r10, "dialogContainer");
        this.f7072a.invoke(r10);
    }

    @Override // dc.m
    public void d(e r8) {
        he.i.f(r8, "dialog");
    }
}
