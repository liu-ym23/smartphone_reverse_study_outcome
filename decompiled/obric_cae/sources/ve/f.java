package ve;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import pe.w0;

/* JADX INFO: loaded from: classes2.dex */
public class f extends w0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f12877m;

    public f(long r8, int r10, int r11, String r12) {
        this.f12877m = new a(r8, r10, r11, r12);
    }

    @Override // pe.w
    public final void r0(ae.f r8, Runnable r10) {
        AtomicLongFieldUpdater r11 = a.f12847r;
        i r12 = k.f12888g;
        this.f12877m.i(r10, r12, false);
    }
}
