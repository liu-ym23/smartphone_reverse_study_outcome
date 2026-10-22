package com.larus.suggest.impl.wcb.request;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbResponseConsumer", f = "WcbResponseConsumer.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {40, TraceLevel.ABOVE_WARN, 49, 52}, m = "consume", n = {"snapshot", "traceData", "transaction", "targetOverride", "canApply", "snapshot", "traceData", "transaction", "targetOverride", "canApply", "response", "snapshot", "traceData", "transaction", "targetOverride", "canApply", "response"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
final class WcbResponseConsumer$consume$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcbResponseConsumer this$0;

    public WcbResponseConsumer$consume$1(WcbResponseConsumer r1, Continuation<? super WcbResponseConsumer$consume$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, null, null, null, this);
    }
}
