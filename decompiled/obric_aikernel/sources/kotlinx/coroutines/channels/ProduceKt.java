package kotlinx.coroutines.channels;

import kotlin.BuilderInference;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nProduce.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,151:1\n1#2:152\n314#3,11:153\n*S KotlinDebug\n*F\n+ 1 Produce.kt\nkotlinx/coroutines/channels/ProduceKt\n*L\n48#1:153,11\n*E\n"})
public final class ProduceKt {
    public static final Object a(l<?> r10, Function0<Unit> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof ProduceKt$awaitClose$1) == false) goto L7;
        ProduceKt$awaitClose$1 r13 = (ProduceKt$awaitClose$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        r11 = (Function0) r13.L$1;
        l r18 = (l) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L28:
        r11.invoke();
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        if (r13.getContext().get(v1.f10723e) != r10) goto L21;
        boolean r19 = true;
    L22:
        if (r19 == false) goto L33;
        r13.L$0 = r10;     // Catch: Throwable -> L14
        r13.L$1 = r11;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        final kotlinx.coroutines.o r20 = new kotlinx.coroutines.o(IntrinsicsKt.intercepted(r13), 1);     // Catch: Throwable -> L14
        r20.F();     // Catch: Throwable -> L14
        r10.B(new ProduceKt$awaitClose$4$1(r20));     // Catch: Throwable -> L14
        Object r21 = r20.B();     // Catch: Throwable -> L14
        if (r21 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended(r13);     // Catch: Throwable -> L14
    L26:
        if (r21 != r16) goto L28;
        return r16;
    L33:
        throw new IllegalStateException("awaitClose() can only be invoked from the producer context".toString());
    L21:
        r19 = false;
    L14:
        th = move-exception;
        r11.invoke();
        throw th;
    L7:
        r13 = new ProduceKt$awaitClose$1(r12);
        goto L8
    }

    public static final <E> ReceiveChannel<E> b(l0 r10, CoroutineContext r11, int r12, @BuilderInference Function2<? super l<? super E>, ? super Continuation<? super Unit>, ? extends Object> r13) {
        return c(r10, r11, r12, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, r13);
    }

    public static final <E> ReceiveChannel<E> c(l0 r10, CoroutineContext r11, int r12, BufferOverflow r13, CoroutineStart r14, Function1<? super Throwable, Unit> r15, @BuilderInference Function2<? super l<? super E>, ? super Continuation<? super Unit>, ? extends Object> r16) {
        d r17 = f.b(r12, r13, null, 4, null);
        k r18 = new k(CoroutineContextKt.e(r10, r11), r17);
        if (r15 == null) goto L5;
        r18.A(r15);
    L5:
        r18.i1(r14, r18, r16);
        return r18;
    }

    public static /* synthetic */ ReceiveChannel d(l0 r10, CoroutineContext r11, int r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r12 = 0;
    L9:
        return b(r10, r11, r12, r13);
    }

    public static /* synthetic */ ReceiveChannel e(l0 r10, CoroutineContext r11, int r12, BufferOverflow r13, CoroutineStart r14, Function1 r15, Function2 r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L5;
        r11 = EmptyCoroutineContext.INSTANCE;
    L5:
        CoroutineContext r19 = r11;
        if ((r17 & 2) == 0) goto L8;
        r12 = 0;
    L8:
        int r20 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = BufferOverflow.SUSPEND;
    L11:
        BufferOverflow r21 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = CoroutineStart.DEFAULT;
    L14:
        CoroutineStart r22 = r14;
        if ((r17 & 16) == 0) goto L18;
        r15 = null;
    L18:
        return c(r10, r19, r20, r21, r22, r15, r16);
    }
}
