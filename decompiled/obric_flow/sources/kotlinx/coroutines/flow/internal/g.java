package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends f {
    public g(kotlinx.coroutines.flow.g r5, int r10, BufferOverflow r11, int r12) {
        EmptyCoroutineContext r13 = EmptyCoroutineContext.INSTANCE;
        if ((r12 & 4) == 0) goto L6;
        r10 = -3;
    L6:
        if ((r12 & 8) == 0) goto L8;
        r11 = BufferOverflow.SUSPEND;
    L8:
        super(r5, r13, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.d
    public final d e(CoroutineContext r5, int r10, BufferOverflow r11) {
        return new g(this.d, r5, r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.f
    public final Object g(kotlinx.coroutines.flow.h r5, Continuation r10) {
        Object r11 = this.d.collect(r5, r10);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Unit.INSTANCE;
    }
}
