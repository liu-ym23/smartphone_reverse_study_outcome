package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1954b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1955m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1956n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ArrayList f1957o;

    public e0(int r8, ArrayList r10, ArrayList r11, ArrayList r12, ArrayList r13) {
        this.f1953a = r8;
        this.f1954b = r10;
        this.f1955m = r11;
        this.f1956n = r12;
        this.f1957o = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = 0;
    L4:
        if (r8 >= this.f1953a) goto L6;
        View r10 = (View) this.f1954b.get(r8);
        String r11 = (String) this.f1955m.get(r8);
        WeakHashMap<View, j0.h0> r12 = j0.w.f8437a;
        j0.w.i.v(r10, r11);
        j0.w.i.v((View) this.f1956n.get(r8), (String) this.f1957o.get(r8));
        r8 = r8 + 1;
        goto L4
    }
}
