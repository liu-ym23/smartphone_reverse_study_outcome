package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class w implements Flow<Object> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ Function2 b;

    public w(Flow r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object collect(FlowCollector<Object> r5, Continuation<? super Unit> r6) {
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        Object r7 = this.a.collect(new FlowKt__LimitKt.dropWhile.1.1(r0, r5, this.b), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }
}
