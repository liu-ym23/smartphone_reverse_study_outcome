package dc;

import android.content.Context;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f7052a;

    public f(e r8) {
        this.f7052a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e r8 = this.f7052a;
        View r10 = r8.f();
        Window r11 = r8.getWindow();
        Context r12 = r8.getContext();
        he.i.e(r12, "context");
        ec.a.f(r10, r11, true, fc.a.g(r12)).b();
    }
}
