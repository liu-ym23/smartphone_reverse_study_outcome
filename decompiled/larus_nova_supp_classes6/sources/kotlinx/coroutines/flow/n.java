package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class n implements Flow<Object> {
    public final /* synthetic */ Object a;

    public n(Object r1) {
        this.a = r1;
    }

    public final Object collect(FlowCollector<Object> r2, Continuation<? super Unit> r3) {
        Object r4 = r2.emit(this.a, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }
}
