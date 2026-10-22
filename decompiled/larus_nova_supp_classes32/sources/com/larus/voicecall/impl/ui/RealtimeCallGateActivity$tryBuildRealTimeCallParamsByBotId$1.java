package com.larus.voicecall.impl.ui;

import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallGateActivity", f = "RealtimeCallGateActivity.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4}, l = {249, 251, 255, 257, 261}, m = "tryBuildRealTimeCallParamsByBotId", n = {LynxResourceModule.PARAMS_KEY, "botId", "$this$tryBuildRealTimeCallParamsByBotId_u24lambda_u2417", "conversation", LynxResourceModule.PARAMS_KEY, "botId", "$this$tryBuildRealTimeCallParamsByBotId_u24lambda_u2417", "conversation", LynxResourceModule.PARAMS_KEY, "botId", "$this$tryBuildRealTimeCallParamsByBotId_u24lambda_u2417", "conversation", LynxResourceModule.PARAMS_KEY, "botId", "$this$tryBuildRealTimeCallParamsByBotId_u24lambda_u2417", "conversation", "it", LynxResourceModule.PARAMS_KEY, "botId", "$this$tryBuildRealTimeCallParamsByBotId_u24lambda_u2417", "conversation", "it"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
public final class RealtimeCallGateActivity$tryBuildRealTimeCallParamsByBotId$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallGateActivity this$0;

    public RealtimeCallGateActivity$tryBuildRealTimeCallParamsByBotId$1(RealtimeCallGateActivity r1, Continuation<? super RealtimeCallGateActivity$tryBuildRealTimeCallParamsByBotId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        RealtimeCallGateActivity r3 = this.this$0;
        int r0 = RealtimeCallGateActivity.a;
        return r3.F1(null, this);
    }
}
