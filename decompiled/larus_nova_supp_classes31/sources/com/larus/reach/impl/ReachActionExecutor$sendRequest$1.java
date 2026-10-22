package com.larus.reach.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.reach.impl.ReachActionExecutor", f = "ReachActionExecutor.kt", i = {0, 0, 0}, l = {84, 98}, m = "sendRequest", n = {"context", "request", "click"}, s = {"L$0", "L$1", "L$2"})
final class ReachActionExecutor$sendRequest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public ReachActionExecutor$sendRequest$1(a r1, Continuation<? super ReachActionExecutor$sendRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, null, null, null, null, this);
    }
}
