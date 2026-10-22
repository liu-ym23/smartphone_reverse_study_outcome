package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class ChannelFlowTransformLatest<T, R> extends g<T, R> {
    public final Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> e;

    @Override // kotlinx.coroutines.flow.internal.g
    public final Object g(FlowCollector<? super R> r3, Continuation<? super Unit> r4) {
        Object r5 = CoroutineScopeKt.coroutineScope(new ChannelFlowTransformLatest$flowCollect$3(this, r3, null), r4);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final d<R> d(CoroutineContext r8, int r9, BufferOverflow r10) {
        return new ChannelFlowTransformLatest(this.e, this.d, r8, r9, r10);
    }

    public ChannelFlowTransformLatest(Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r1, Flow<? extends T> r2, CoroutineContext r3, int r4, BufferOverflow r5) {
        super(r2, r3, r4, r5);
        this.e = r1;
    }
}
