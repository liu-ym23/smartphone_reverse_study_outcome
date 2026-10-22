package com.larus.suggest.impl.wcb.request;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbResponseConsumer", f = "WcbResponseConsumer.kt", i = {0, 0}, l = {177}, m = "submitRenderPlan", n = {"traceData", "canApply"}, s = {"L$0", "L$1"})
public final class WcbResponseConsumer$submitRenderPlan$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcbResponseConsumer this$0;

    public WcbResponseConsumer$submitRenderPlan$1(WcbResponseConsumer r1, Continuation<? super WcbResponseConsumer$submitRenderPlan$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, null, null, this);
    }
}
