package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements kotlinx.coroutines.flow.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f18880a;

    public q(Function3 r5) {
        this.f18880a = r5;
    }

    @Override // kotlinx.coroutines.flow.g
    public final Object collect(kotlinx.coroutines.flow.h r5, Continuation r10) {
        FlowCoroutineKt$scopedFlow$1$1 r11 = new FlowCoroutineKt$scopedFlow$1$1(this.f18880a, r5, null);
        p r12 = new p(r10, r10.getContext());
        Object r13 = com.lynx.tasm.utils.a.z(r12, r12, r11);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L6:
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r13;
    L9:
        return Unit.INSTANCE;
    }
}
