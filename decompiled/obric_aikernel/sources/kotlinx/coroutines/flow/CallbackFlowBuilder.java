package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes3.dex */
final class CallbackFlowBuilder<T> extends b<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Function2<kotlinx.coroutines.channels.l<? super T>, Continuation<? super Unit>, Object> f10391j;

    /* JADX WARN: Multi-variable type inference failed */
    public CallbackFlowBuilder(Function2<? super kotlinx.coroutines.channels.l<? super T>, ? super Continuation<? super Unit>, ? extends Object> r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r10, r11, r12, r13);
        this.f10391j = r10;
    }

    public /* synthetic */ CallbackFlowBuilder(Function2 r10, CoroutineContext r11, int r12, BufferOverflow r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = -2;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = BufferOverflow.SUSPEND;
    L11:
        this(r10, r11, r12, r13);
    }

    @Override // kotlinx.coroutines.flow.b, kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(kotlinx.coroutines.channels.l<? super T> r10, Continuation<? super Unit> r11) {
        if ((r11 instanceof CallbackFlowBuilder$collectTo$1) == false) goto L7;
        CallbackFlowBuilder$collectTo$1 r12 = (CallbackFlowBuilder$collectTo$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (kotlinx.coroutines.channels.l) r12.L$0;
        ResultKt.throwOnFailure(r14);
    L18:
        if (r10.L() == false) goto L22;
        return Unit.INSTANCE;
    L22:
        throw new IllegalStateException("'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details.");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        r12.L$0 = r10;
        r12.label = 1;
        if (super.h(r10, r12) != r15) goto L18;
        return r15;
    L7:
        r12 = new CallbackFlowBuilder$collectTo$1(this, r11);
        goto L8
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> i(CoroutineContext r10, int r11, BufferOverflow r12) {
        return new CallbackFlowBuilder(this.f10391j, r10, r11, r12);
    }
}
