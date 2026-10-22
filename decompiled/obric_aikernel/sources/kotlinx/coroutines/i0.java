package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nCoroutineExceptionHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,110:1\n75#2:111\n*S KotlinDebug\n*F\n+ 1 CoroutineExceptionHandler.kt\nkotlinx/coroutines/CoroutineExceptionHandlerKt\n*L\n38#1:111\n*E\n"})
public final class i0 {
    public static final void a(CoroutineContext r10, Throwable r11) {
        h0 r12 = (h0) r10.get(h0.f10523d);     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        r12.V(r10, r11);     // Catch: Throwable -> L8
        return;
    L6:
        kotlinx.coroutines.internal.j.a(r10, r11);
        return;
    L8:
        th = move-exception;
        kotlinx.coroutines.internal.j.a(r10, b(r11, th));
    }

    public static final Throwable b(Throwable r10, Throwable r11) {
        if (r10 != r11) goto L4;
        return r10;
    L4:
        RuntimeException r12 = new RuntimeException("Exception while trying to handle coroutine exception", r11);
        ExceptionsKt.addSuppressed(r12, r10);
        return r12;
    }
}
