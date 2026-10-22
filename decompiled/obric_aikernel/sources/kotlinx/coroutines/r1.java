package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class r1 {
    public static final /* synthetic */ Object a(CoroutineContext r10, Function0 r11) {
        return b(r10, r11);
    }

    private static final <T> T b(CoroutineContext r10, Function0<? extends T> r11) {
        x2 r12 = new x2(y1.i(r10));     // Catch: InterruptedException -> L9
        r12.d();     // Catch: InterruptedException -> L9
        T r13 = r11.invoke();     // Catch: Throwable -> L6
        r12.a();     // Catch: InterruptedException -> L9
        return r13;
    L6:
        th = move-exception;
        r12.a();     // Catch: InterruptedException -> L9
        throw th;     // Catch: InterruptedException -> L9
    L9:
        e = move-exception;
        throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e);
    }
}
