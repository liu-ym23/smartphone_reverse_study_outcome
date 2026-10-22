package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ProduceKt {
    public static final Object a(k<?> r4, Function0<Unit> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof awaitClose.1) == false) goto L7;
        awaitClose.1 r0 = (awaitClose.1) r6;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L17;
        r5 = (Function0) r0.L$1;
        k r8 = (k) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L14
    L28:
        r5.invoke();
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r7);
        if (r0.getContext().get(Job.Key) != r4) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L33;
        r0.L$0 = r4;     // Catch: Throwable -> L14
        r0.L$1 = r5;     // Catch: Throwable -> L14
        r0.label = 1;     // Catch: Throwable -> L14
        kotlinx.coroutines.j r10 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L14
        r10.C();     // Catch: Throwable -> L14
        r4.invokeOnClose(new awaitClose.4.1(r10));     // Catch: Throwable -> L14
        Object r11 = r10.B();     // Catch: Throwable -> L14
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L14
    L26:
        if (r11 != r2) goto L28;
        return r2;
    L33:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L21:
        r9 = false;
    L14:
        th = move-exception;
        r5.invoke();
        throw th;
    L7:
        r0 = new awaitClose.1(r6);
        goto L8
    }

    public static j c(CoroutineScope r8, int r9, Function2 r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        EmptyCoroutineContext r0 = EmptyCoroutineContext.INSTANCE;
    L6:
        EmptyCoroutineContext r2 = r0;
        if ((r11 & 2) == 0) goto L9;
        int r3 = 0;
    L11:
        return b(r8, r2, r3, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, r10);
    L9:
        r3 = r9;
        goto L11
    L5:
        r0 = null;
        goto L6
    }

    public static j d(GlobalScope r7, CoroutineContext r8, Function1 r9, Function2 r10) {
        CoroutineStart r4 = CoroutineStart.DEFAULT;
        return b(r7, r8, 0, BufferOverflow.SUSPEND, r4, r9, r10);
    }

    public static final j b(CoroutineScope r2, CoroutineContext r3, int r4, BufferOverflow r5, CoroutineStart r6, Function1 r7, Function2 r8) {
        Channel r9 = ChannelKt.Channel$default(r4, r5, null, 4, null);
        j r10 = new j(CoroutineContextKt.c(r2, r3), r9);
        if (r7 == null) goto L5;
        r10.invokeOnCompletion(r7);
    L5:
        r6.invoke(r8, r10, r10);
        return r10;
    }
}
