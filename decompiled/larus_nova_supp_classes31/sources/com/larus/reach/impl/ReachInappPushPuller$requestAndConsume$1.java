package com.larus.reach.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachInappPushPuller", f = "ReachInappPushPuller.kt", i = {0, 0}, l = {86}, m = "requestAndConsume", n = {"scene", "launchSchema"}, s = {"L$0", "L$1"})
public final class ReachInappPushPuller$requestAndConsume$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReachInappPushPuller this$0;

    public ReachInappPushPuller$requestAndConsume$1(ReachInappPushPuller r1, Continuation<? super ReachInappPushPuller$requestAndConsume$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ReachInappPushPuller r3 = this.this$0;
        int r0 = ReachInappPushPuller.d;
        return r3.d(null, null, this);
    }
}
