package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f1928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0.d f1929b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k f1930m;

    public b(k r8, ArrayList r10, i0.d r11) {
        this.f1930m = r8;
        this.f1928a = r10;
        this.f1929b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List r8 = this.f1928a;
        i0.d r10 = this.f1929b;
        if (r8.contains(r10) == false) goto L6;
        r8.remove(r10);
        this.f1930m.getClass();
        View r11 = r10.f1985c.mView;
        r10.f1983a.a(r11);
        return;
    }
}
