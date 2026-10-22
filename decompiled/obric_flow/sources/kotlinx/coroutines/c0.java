package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {
    public static final void a(Throwable r5, CoroutineContext r10) {
        b0 r11 = (b0) r10.get(a0.f18768a);     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        ((wt.b) r11).g(r5, r10);     // Catch: Throwable -> L8
        return;
    L6:
        kotlinx.coroutines.internal.f.e(r5, r10);
        return;
    L8:
        th = move-exception;
        if (r5 == th) goto L12;
        RuntimeException r12 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        ExceptionsKt.addSuppressed(r12, r5);
        r5 = r12;
    L12:
        kotlinx.coroutines.internal.f.e(r5, r10);
    }
}
