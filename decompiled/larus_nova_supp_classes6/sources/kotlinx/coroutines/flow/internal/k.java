package kotlinx.coroutines.flow.internal;

import cuc.b;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class k implements Flow<Object> {
    public final /* synthetic */ Function3 a;

    public k(Function3 r1) {
        this.a = r1;
    }

    public final Object collect(FlowCollector<Object> r4, Continuation<? super Unit> r5) {
        FlowCoroutineKt$scopedFlow$1$1 r0 = new FlowCoroutineKt$scopedFlow$1$1(this.a, r4, null);
        j r6 = new j(r5.getContext(), r5);
        Object r7 = b.a(r6, r6, r0);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r5);
    L6:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r7;
    L9:
        return Unit.INSTANCE;
    }
}
