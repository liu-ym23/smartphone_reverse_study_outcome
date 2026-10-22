package kotlinx.coroutines.internal;

import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public static final void a(CoroutineContext r10, Throwable r11) {
        Iterator<kotlinx.coroutines.h0> r12 = i.a().iterator();
    L4:
        if (r12.hasNext() == true) goto L17;
        ExceptionsKt.addSuppressed(r11, new DiagnosticCoroutineContextException(r10));     // Catch: Throwable -> L14
    L12:
        i.b(r11);
        return;
    L17:
        r12.next().V(r10, r11);     // Catch: Throwable -> L8 ExceptionSuccessfullyProcessed -> L10
    L10:
        return;
    L8:
        th = move-exception;
        i.b(kotlinx.coroutines.i0.b(r11, th));
        goto L4
    }
}
