package androidx.appcompat.app;

import android.view.View;
import j0.h0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class l extends t2.b {
    public final /* synthetic */ AppCompatDelegateImpl H;

    public l(AppCompatDelegateImpl r8) {
        this.H = r8;
    }

    @Override // t2.b, j0.i0
    public final void c() {
        AppCompatDelegateImpl r8 = this.H;
        r8.F.setVisibility(0);
        if ((r8.F.getParent() instanceof View) == false) goto L6;
        View r10 = (View) r8.F.getParent();
        WeakHashMap<View, h0> r11 = j0.w.f8437a;
        j0.w.h.c(r10);
        return;
    }

    @Override // j0.i0
    public final void d() {
        AppCompatDelegateImpl r8 = this.H;
        r8.F.setAlpha(1.0f);
        r8.I.d(null);
        r8.I = null;
    }
}
