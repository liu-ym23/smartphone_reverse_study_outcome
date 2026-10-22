package kotlinx.coroutines.internal;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h {
    public static final void a(CoroutineContext r4, Throwable r5) {
        Iterator<CoroutineExceptionHandler> r0 = g.a.iterator();
    L4:
        if (r0.hasNext() == true) goto L20;
        ExceptionsKt.addSuppressed(r5, new DiagnosticCoroutineContextException(r4));     // Catch: Throwable -> L17
    L15:
        Thread r6 = ThreadMethodProxy.currentThread();
        r6.getUncaughtExceptionHandler().uncaughtException(r6, r5);
        return;
    L20:
        r0.next().handleException(r4, r5);     // Catch: Throwable -> L8 ExceptionSuccessfullyProcessed -> L13
    L13:
        return;
    L8:
        th = move-exception;
        if (r5 != th) goto L11;
        Throwable r2 = r5;
    L12:
        Thread r1 = ThreadMethodProxy.currentThread();
        r1.getUncaughtExceptionHandler().uncaughtException(r1, r2);
        goto L4
    L11:
        r2 = new RuntimeException("Exception while trying to handle coroutine exception", th);
        ExceptionsKt.addSuppressed(r2, r5);
        goto L12
    }
}
