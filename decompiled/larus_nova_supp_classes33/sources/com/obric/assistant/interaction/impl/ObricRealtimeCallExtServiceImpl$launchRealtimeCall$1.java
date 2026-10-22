package com.obric.assistant.interaction.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricRealtimeCallExtServiceImpl", f = "ObricRealtimeCallServiceImpl.kt", i = {0, 0, 0, 0, 0}, l = {500}, m = "launchRealtimeCall", n = {"callType", "from", "onPreJump", "startupAttemptId", "delayJumpMS"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0"})
public final class ObricRealtimeCallExtServiceImpl$launchRealtimeCall$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricRealtimeCallExtServiceImpl this$0;

    public ObricRealtimeCallExtServiceImpl$launchRealtimeCall$1(ObricRealtimeCallExtServiceImpl r1, Continuation<? super ObricRealtimeCallExtServiceImpl$launchRealtimeCall$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.launchRealtimeCall(null, null, 0, null, this);
    }
}
