package com.larus.suggest.impl.wcb.request;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbRequestExecutionRunner", f = "WcbRequestExecutionRunner.kt", i = {1, 3, 3}, l = {30, 33, 34, 39, 40, 40}, m = "run", n = {"emit", "emit", "networkRequest"}, s = {"L$0", "L$0", "L$1"})
public final class WcbRequestExecutionRunner$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcbRequestExecutionRunner this$0;

    public WcbRequestExecutionRunner$run$1(WcbRequestExecutionRunner r1, Continuation<? super WcbRequestExecutionRunner$run$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, 0, null, this);
    }
}
