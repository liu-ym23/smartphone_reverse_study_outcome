package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"yield", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class dg {
    public static final Object a(Continuation<? super Unit> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        CoroutineContext r0 = r6.getContext();
        ca.a(r0);
        Continuation r2 = IntrinsicsKt.intercepted(r6);
        if (ZeusTransformUtils.instanceOf(r2, kotlinx.coroutines.internal.l.class) == false) goto L5;
        kotlinx.coroutines.internal.l r3 = (kotlinx.coroutines.internal.l) ZeusTransformUtils.preCheckCast(r2, kotlinx.coroutines.internal.l.class, "com.obric.memorydata.plugin");
    L6:
        if (r3 != null) goto L9;
    L7:
        Object r1 = Unit.INSTANCE;
    L17:
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L20:
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        return r1;
    L23:
        return Unit.INSTANCE;
    L9:
        if (r3.f17584b.isDispatchNeeded(r0) == false) goto L11;
        r3.a(r0, Unit.INSTANCE);
    L15:
        r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        goto L17
    L11:
        df r4 = new df();
        r3.a(r0.plus((CoroutineContext) ZeusTransformUtils.preCheckCast(r4, CoroutineContext.class, "com.obric.memorydata.plugin")), Unit.INSTANCE);
        if (r4.f17338b == false) goto L15;
        if (kotlinx.coroutines.internal.m.a(r3) == false) goto L7;
    L5:
        r3 = null;
        goto L6
    }
}
