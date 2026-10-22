package com.larus.reach.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachInappPushPuller", f = "ReachInappPushPuller.kt", i = {0}, l = {56, 57}, m = "executePull", n = {"task"}, s = {"L$0"})
final class ReachInappPushPuller$executePull$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReachInappPushPuller this$0;

    public ReachInappPushPuller$executePull$1(ReachInappPushPuller r1, Continuation<? super ReachInappPushPuller$executePull$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ReachInappPushPuller.a(this.this$0, null, this);
    }
}
