package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class g<S, T> extends d<T> {
    public final Flow<S> d;

    public abstract Object g(FlowCollector<? super T> r1, Continuation<? super Unit> r2);

    @Override // kotlinx.coroutines.flow.internal.d
    public final String toString() {
        return this.d + " -> " + super.toString();
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Object c(k<? super T> r2, Continuation<? super Unit> r3) {
        Object r4 = g(new p(r2), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final Object collect(FlowCollector<? super T> r5, Continuation<? super Unit> r6) {
        if (this.b != (-3)) goto L23;
        CoroutineContext r0 = r6.getContext();
        CoroutineContext r1 = CoroutineContextKt.b(r0, this.a);
        if (Intrinsics.areEqual(r1, r0) == false) goto L10;
        Object r7 = g(r5, r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        return r7;
    L28:
        return Unit.INSTANCE;
    L10:
        ContinuationInterceptor.Key r2 = ContinuationInterceptor.Key;
        if (Intrinsics.areEqual(r1.get(r2), r0.get(r2)) == false) goto L23;
        CoroutineContext r3 = r6.getContext();
        if ((r5 instanceof p) == false) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L19;
        r5 = new UndispatchedContextCollector(r5, r3);
    L19:
        ChannelFlowOperator.collectWithContextUndispatched.2 r8 = new ChannelFlowOperator.collectWithContextUndispatched.2(this, null);
        Object r9 = e.a(r1, r5, ThreadContextKt.b(r1), r8, r6);
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L29;
        return r9;
    L29:
        return Unit.INSTANCE;
    L15:
        r4 = r5 instanceof n;
    L23:
        Object r10 = super.collect(r5, r6);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r10;
    L27:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(Flow<? extends S> r1, CoroutineContext r2, int r3, BufferOverflow r4) {
        super(r2, r3, r4);
        this.d = r1;
    }
}
