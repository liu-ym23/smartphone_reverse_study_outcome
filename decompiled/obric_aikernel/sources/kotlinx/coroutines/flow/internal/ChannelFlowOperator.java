package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ChannelFlowOperator<S, T> extends ChannelFlow<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @JvmField
    protected final kotlinx.coroutines.flow.c<S> f10467i;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowOperator(kotlinx.coroutines.flow.c<? extends S> r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r11, r12, r13);
        this.f10467i = r10;
    }

    static /* synthetic */ <S, T> Object m(ChannelFlowOperator<S, T> r10, kotlinx.coroutines.flow.d<? super T> r11, Continuation<? super Unit> r12) {
        if (r10.f10465g != (-3)) goto L18;
        CoroutineContext r13 = r12.getContext();
        CoroutineContext r14 = CoroutineContextKt.d(r13, r10.f10464c);
        if (Intrinsics.areEqual(r14, r13) == false) goto L11;
        Object r15 = r10.p(r11, r12);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r15;
    L10:
        return Unit.INSTANCE;
    L11:
        ContinuationInterceptor.Key r16 = ContinuationInterceptor.Key;
        if (Intrinsics.areEqual(r14.get(r16), r13.get(r16)) == false) goto L18;
        Object r17 = r10.o(r11, r14, r12);
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r17;
    L17:
        return Unit.INSTANCE;
    L18:
        Object r18 = super.a(r11, r12);
        if (r18 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        return r18;
    L22:
        return Unit.INSTANCE;
    }

    static /* synthetic */ <S, T> Object n(ChannelFlowOperator<S, T> r10, kotlinx.coroutines.channels.l<? super T> r11, Continuation<? super Unit> r12) {
        Object r13 = r10.p(new p(r11), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    private final Object o(kotlinx.coroutines.flow.d<? super T> r10, CoroutineContext r11, Continuation<? super Unit> r12) {
        Object r13 = d.d(r11, d.a(r10, r12.getContext()), null, new ChannelFlowOperator$collectWithContextUndispatched$2(this, null), r12, 4, null);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.c
    public Object a(kotlinx.coroutines.flow.d<? super T> r10, Continuation<? super Unit> r11) {
        return m(this, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected Object h(kotlinx.coroutines.channels.l<? super T> r10, Continuation<? super Unit> r11) {
        return n(this, r10, r11);
    }

    protected abstract Object p(kotlinx.coroutines.flow.d<? super T> r10, Continuation<? super Unit> r11);

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    public String toString() {
        return this.f10467i + " -> " + super.toString();
    }
}
