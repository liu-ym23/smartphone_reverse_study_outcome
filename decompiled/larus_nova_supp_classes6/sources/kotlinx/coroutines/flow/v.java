package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class v implements Flow<Object> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ int b;

    public v(Flow r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object collect(FlowCollector<Object> r5, Continuation<? super Unit> r6) {
        Ref.IntRef r0 = new Ref.IntRef();
        Object r7 = this.a.collect(new FlowKt__LimitKt.drop.2.1(r0, this.b, r5), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }
}
