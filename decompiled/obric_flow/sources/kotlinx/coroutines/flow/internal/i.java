package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends f {
    public final SuspendLambda e;

    /* JADX WARN: Multi-variable type inference failed */
    public i(Function3 r5, kotlinx.coroutines.flow.g r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r10, r11, r12, r13);
        this.e = (SuspendLambda) r5;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function3] */
    @Override // kotlinx.coroutines.flow.internal.d
    public final d e(CoroutineContext r10, int r11, BufferOverflow r12) {
        return new i(this.e, this.d, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.internal.f
    public final Object g(kotlinx.coroutines.flow.h r5, Continuation r10) {
        Object r11 = h0.d(new ChannelFlowTransformLatest$flowCollect$3(this, r5, null), r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
