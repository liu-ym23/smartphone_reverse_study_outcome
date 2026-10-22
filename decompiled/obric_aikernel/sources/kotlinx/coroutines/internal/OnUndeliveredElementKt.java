package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nOnUndeliveredElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n+ 2 Exceptions.kt\nkotlinx/coroutines/ExceptionsKt\n*L\n1#1,44:1\n75#2:45\n*S KotlinDebug\n*F\n+ 1 OnUndeliveredElement.kt\nkotlinx/coroutines/internal/OnUndeliveredElementKt\n*L\n22#1:45\n*E\n"})
public final class OnUndeliveredElementKt {
    public static final <E> Function1<Throwable, Unit> a(final Function1<? super E, Unit> r10, final E r11, final CoroutineContext r12) {
        return new OnUndeliveredElementKt$bindCancellationFun$1(r10, r11, r12);
    }

    public static final <E> void b(Function1<? super E, Unit> r10, E r11, CoroutineContext r12) {
        UndeliveredElementException r13 = c(r10, r11, null);
        if (r13 == null) goto L6;
        kotlinx.coroutines.i0.a(r12, r13);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException c(Function1<? super E, Unit> r10, E r11, UndeliveredElementException r12) {
        r10.invoke(r11);     // Catch: Throwable -> L4
    L9:
        return r12;
    L4:
        th = move-exception;
        if (r12 == null) goto L11;
        if (r12.getCause() == th) goto L11;
        ExceptionsKt.addSuppressed(r12, th);
    L11:
        return new UndeliveredElementException("Exception in undelivered element handler for " + r11, th);
    }

    public static /* synthetic */ UndeliveredElementException d(Function1 r10, Object r11, UndeliveredElementException r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        return c(r10, r11, r12);
    }
}
