package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public final class f<T> extends ChannelFlowOperator<T, T> {
    public f(kotlinx.coroutines.flow.c<? extends T> r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        super(r10, r11, r12, r13);
    }

    public /* synthetic */ f(kotlinx.coroutines.flow.c r10, CoroutineContext r11, int r12, BufferOverflow r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = EmptyCoroutineContext.INSTANCE;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = -3;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = BufferOverflow.SUSPEND;
    L11:
        this(r10, r11, r12, r13);
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    protected ChannelFlow<T> i(CoroutineContext r10, int r11, BufferOverflow r12) {
        return new f(this.f10467i, r10, r11, r12);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlowOperator
    protected Object p(kotlinx.coroutines.flow.d<? super T> r10, Continuation<? super Unit> r11) {
        Object r12 = this.f10467i.a((kotlinx.coroutines.flow.d<? super S>) r10, r11);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Unit.INSTANCE;
    }
}
