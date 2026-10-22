package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class y {
    public static final void a(CoroutineContext r3, Throwable r4) {
        CoroutineExceptionHandler r0 = r3.get(CoroutineExceptionHandler.Key);     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.handleException(r3, r4);     // Catch: Throwable -> L8
        return;
    L6:
        h.a(r3, r4);
        return;
    L8:
        th = move-exception;
        if (r4 == th) goto L12;
        RuntimeException r1 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        ExceptionsKt.addSuppressed(r1, r4);
        r4 = r1;
    L12:
        h.a(r3, r4);
    }
}
