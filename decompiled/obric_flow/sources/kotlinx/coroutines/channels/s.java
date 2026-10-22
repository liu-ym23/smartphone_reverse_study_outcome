package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(u r5, Function0 r10, ContinuationImpl r11) {
        if ((r11 instanceof ProduceKt$awaitClose$1) == false) goto L7;
        ProduceKt$awaitClose$1 r12 = (ProduceKt$awaitClose$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        r10 = (Function0) r12.L$1;
        u r17 = (u) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L25:
        r10.invoke();
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        if (r12.getContext().get(Job.Key) != r5) goto L30;
        r12.L$0 = r5;     // Catch: Throwable -> L14
        r12.L$1 = r10;     // Catch: Throwable -> L14
        r12.label = 1;     // Catch: Throwable -> L14
        kotlinx.coroutines.l r18 = new kotlinx.coroutines.l(1, IntrinsicsKt.intercepted(r12));     // Catch: Throwable -> L14
        r18.w();     // Catch: Throwable -> L14
        j r19 = (j) r5;     // Catch: Throwable -> L14
        r19.f(new com.obric.oui.progress.a(r18, 1));     // Catch: Throwable -> L14
        Object r20 = r18.v();     // Catch: Throwable -> L14
        if (r20 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r12);     // Catch: Throwable -> L14
    L23:
        if (r20 != r15) goto L25;
        return r15;
    L30:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
    L14:
        th = move-exception;
        r10.invoke();
        throw th;
    L7:
        r12 = new ProduceKt$awaitClose$1(r11);
        goto L8
    }

    public static t b(CoroutineScope r5, int r10, Function2 r11, int r12) {
        EmptyCoroutineContext r13 = EmptyCoroutineContext.INSTANCE;
        if ((r12 & 2) == 0) goto L5;
        r10 = 0;
    L5:
        BufferOverflow r14 = BufferOverflow.SUSPEND;
        CoroutineStart r15 = CoroutineStart.DEFAULT;
        f r16 = p.a(r10, 4, r14);
        t r17 = new t(kotlinx.coroutines.x.b(r5, r13), r16);
        r15.invoke(r11, r17, r17);
        return r17;
    }
}
