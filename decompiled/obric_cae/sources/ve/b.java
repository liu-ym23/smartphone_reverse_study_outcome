package ve;

import java.util.concurrent.Executor;
import pe.w;
import pe.w0;
import ue.v;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends w0 implements Executor {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f12873m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final w f12874n = null;

    static {
        f12873m = new b();
        l r8 = l.f12890m;
        int r10 = v.f12626a;
        if (64 < r10) goto L6;
        r10 = 64;
    L6:
        int r11 = l6.a.S0("kotlinx.coroutines.io.parallelism", r10, 0, 0, 12);
        r8.getClass();
        l6.a.u(r11);
        w r12 = r8;
        if (r11 >= k.f12885d) goto L10;
        l6.a.u(r11);
        r12 = new ue.i(r8, r11);
    L10:
        f12874n = r12;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r8) {
        r0(ae.g.f354a, r8);
    }

    @Override // pe.w
    public final void r0(ae.f r8, Runnable r10) {
        f12874n.r0(r8, r10);
    }

    @Override // pe.w
    public final String toString() {
        return "Dispatchers.IO";
    }
}
