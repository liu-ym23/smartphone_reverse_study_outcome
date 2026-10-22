package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f1967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f1968b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Rect f1969m;

    public h(f0 r8, View r10, Rect r11) {
        this.f1967a = r8;
        this.f1968b = r10;
        this.f1969m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1967a.getClass();
        f0.g(this.f1968b, this.f1969m);
    }
}
