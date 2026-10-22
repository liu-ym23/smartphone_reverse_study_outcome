package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.BroadcastChannelImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class o implements Flow<Object> {
    public final /* synthetic */ BroadcastChannel a;

    public o(BroadcastChannelImpl r1) {
        this.a = r1;
    }

    public final Object collect(FlowCollector<Object> r2, Continuation<? super Unit> r3) {
        Object r4 = e.q(r2, this.a.openSubscription(), r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }
}
