package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends kotlinx.coroutines.flow.internal.d {
    public final Function2 d;
    public final Function2 e;

    public b(Function2 r5, CoroutineContext r10, int r11, BufferOverflow r12) {
        super(r10, r11, r12);
        this.d = r5;
        this.e = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, kotlinx.coroutines.channels.u] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlinx.coroutines.channels.u] */
    @Override // kotlinx.coroutines.flow.internal.d
    public final Object c(kotlinx.coroutines.channels.u r5, Continuation r10) {
        if ((r10 instanceof CallbackFlowBuilder$collectTo$1) == false) goto L7;
        CallbackFlowBuilder$collectTo$1 r11 = (CallbackFlowBuilder$collectTo$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        r5 = (kotlinx.coroutines.channels.u) r11.L$0;
        ResultKt.throwOnFailure(r13);
    L21:
        if (((kotlinx.coroutines.channels.j) r5).d.B() == false) goto L25;
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        r11.L$0 = r5;
        r11.label = 1;
        Object r16 = this.d.mo2invoke(r5, r11);
        if (r16 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        r16 = Unit.INSTANCE;
    L18:
        if (r16 != r14) goto L21;
        return r14;
    L7:
        r11 = new CallbackFlowBuilder$collectTo$1(this, r10);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final kotlinx.coroutines.flow.internal.d e(CoroutineContext r5, int r10, BufferOverflow r11) {
        return new b(this.e, r5, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final String toString() {
        return "block[" + this.d + "] -> " + super.toString();
    }
}
