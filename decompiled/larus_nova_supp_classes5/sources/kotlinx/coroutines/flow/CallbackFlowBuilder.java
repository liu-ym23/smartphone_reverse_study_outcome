package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CallbackFlowBuilder<T> extends c<T> {
    public final Function2<k<? super T>, Continuation<? super Unit>, Object> e;

    @Override // kotlinx.coroutines.flow.c, kotlinx.coroutines.flow.internal.d
    public final Object c(k<? super T> r5, Continuation<? super Unit> r6) {
        if ((r6 instanceof CallbackFlowBuilder$collectTo$1) == false) goto L7;
        CallbackFlowBuilder$collectTo$1 r0 = (CallbackFlowBuilder$collectTo$1) r6;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r5 = (k) r0.L$0;
        ResultKt.throwOnFailure(r7);
    L18:
        if (r5.isClosedForSend() == false) goto L22;
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r0.L$0 = r5;
        r0.label = 1;
        if (super.c(r5, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new CallbackFlowBuilder$collectTo$1(this, r6);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.c, kotlinx.coroutines.flow.internal.d
    public final kotlinx.coroutines.flow.internal.d<T> d(CoroutineContext r3, int r4, BufferOverflow r5) {
        return new CallbackFlowBuilder(this.e, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackFlowBuilder(Function2<? super k<? super T>, ? super Continuation<? super Unit>, ? extends Object> r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        super(r1, r2, r3, r4);
        this.e = r1;
    }
}
