package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class y1 {
    public static final z a(v1 r10) {
        return a2.a(r10);
    }

    public static /* synthetic */ z b(v1 r10, int r11, Object r12) {
        return a2.b(r10, r11, r12);
    }

    public static final void c(CoroutineContext r10, CancellationException r11) {
        a2.c(r10, r11);
    }

    public static /* synthetic */ void d(CoroutineContext r10, CancellationException r11, int r12, Object r13) {
        a2.d(r10, r11, r12, r13);
    }

    public static final void e(n<?> r10, Future<?> r11) {
        z1.a(r10, r11);
    }

    public static final b1 f(v1 r10, b1 r11) {
        return a2.e(r10, r11);
    }

    public static final void g(CoroutineContext r10) {
        a2.f(r10);
    }

    public static final void h(v1 r10) {
        a2.g(r10);
    }

    public static final v1 i(CoroutineContext r10) {
        return a2.h(r10);
    }
}
