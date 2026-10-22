package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class e {
    public static final <T, V> Object a(CoroutineContext r2, V r3, Object r4, Function2<? super V, ? super Continuation<? super T>, ? extends Object> r5, Continuation<? super T> r6) {
        Object r7 = ThreadContextKt.c(r2, r4);
        q r0 = new q(r6, r2);     // Catch: Throwable -> L11
        if ((r5 instanceof BaseContinuationImpl) == true) goto L6;
        Object r8 = IntrinsicsKt.wrapWithContinuationImpl(r5, r3, r0);     // Catch: Throwable -> L11
    L7:
        ThreadContextKt.a(r2, r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L10:
        return r8;
    L6:
        r8 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r5, 2)).invoke(r3, r0);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        ThreadContextKt.a(r2, r7);
        throw th;
    }
}
