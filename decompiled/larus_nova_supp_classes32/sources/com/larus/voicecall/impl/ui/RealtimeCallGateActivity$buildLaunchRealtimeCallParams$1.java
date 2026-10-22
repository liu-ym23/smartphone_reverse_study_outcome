package com.larus.voicecall.impl.ui;

import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallGateActivity", f = "RealtimeCallGateActivity.kt", i = {0, 0, 2, 2, 2}, l = {223, 225, 227, 235}, m = "buildLaunchRealtimeCallParams", n = {LynxResourceModule.PARAMS_KEY, "cvsId", LynxResourceModule.PARAMS_KEY, "cvsId", "conversation"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class RealtimeCallGateActivity$buildLaunchRealtimeCallParams$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallGateActivity this$0;

    public RealtimeCallGateActivity$buildLaunchRealtimeCallParams$1(RealtimeCallGateActivity r1, Continuation<? super RealtimeCallGateActivity$buildLaunchRealtimeCallParams$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        RealtimeCallGateActivity r3 = this.this$0;
        int r0 = RealtimeCallGateActivity.a;
        return r3.z1(null, this);
    }
}
