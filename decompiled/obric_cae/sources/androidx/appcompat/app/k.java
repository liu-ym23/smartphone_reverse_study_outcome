package androidx.appcompat.app;

import android.view.View;
import android.view.ViewGroup;
import j0.h0;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f659a;

    public class a extends t2.b {
        public final /* synthetic */ k H;

        public a(k r8) {
            this.H = r8;
        }

        @Override // t2.b, j0.i0
        public final void c() {
            this.H.f659a.F.setVisibility(0);
        }

        @Override // j0.i0
        public final void d() {
            k r8 = this.H;
            r8.f659a.F.setAlpha(1.0f);
            AppCompatDelegateImpl r10 = r8.f659a;
            r10.I.d(null);
            r10.I = null;
        }
    }

    public k(AppCompatDelegateImpl r8) {
        this.f659a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AppCompatDelegateImpl r8 = this.f659a;
        r8.G.showAtLocation(r8.F, 55, 0, 0);
        h0 r10 = r8.I;
        if (r10 == null) goto L6;
        r10.b();
    L6:
        if (r8.K == false) goto L12;
        ViewGroup r11 = r8.L;
        if (r11 == null) goto L12;
        WeakHashMap<View, h0> r12 = j0.w.f8437a;
        if (j0.w.g.c(r11) == false) goto L12;
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        r8.F.setAlpha(0.0f);
        h0 r14 = j0.w.a(r8.F);
        r14.a(1.0f);
        r8.I = r14;
        r14.d(new a(this));
        return;
    L16:
        r8.F.setAlpha(1.0f);
        r8.F.setVisibility(0);
        return;
    L12:
        r13 = false;
        goto L14
    }
}
