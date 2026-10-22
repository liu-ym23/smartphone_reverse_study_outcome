package com.obric.memorydata.realtimecontext;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.realtimecontext.RealTimeContextService$RealTimeContextServiceBinder", f = "RealTimeContextService.kt", i = {0, 0, 0, 0, 0}, l = {1041}, m = "commitVideoActionContext", n = {"this", "componentName", "realTimeData", "timing", "captureAwaitStartMs"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
final class RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealTimeContextService.b this$0;

    RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1(RealTimeContextService.b r3, Continuation<? super RealTimeContextService$RealTimeContextServiceBinder$commitVideoActionContext$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return RealTimeContextService.b.a(this.this$0, null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
