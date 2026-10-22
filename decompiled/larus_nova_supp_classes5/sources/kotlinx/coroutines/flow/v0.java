package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class v0 implements Flow<Object> {
    public final /* synthetic */ Flow a;
    public final /* synthetic */ Flow b;
    public final /* synthetic */ Function3 c;

    public final Object collect(FlowCollector<Object> r6, Continuation<? super Unit> r7) {
        Object r8 = CombineKt.a(r6, new Flow[]{this.a, this.b}, FlowKt__ZipKt$nullArrayFactory$1.INSTANCE, new FlowKt__ZipKt$combine$1$1(this.c, null), r7);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Unit.INSTANCE;
    }

    public v0(Flow r1, Flow r2, Function3 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
