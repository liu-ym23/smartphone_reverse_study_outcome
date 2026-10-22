package com.larus.suggest.impl.wcb.policy;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.policy.MainConversationDisplayFrequencyPolicy", f = "WcbDisplayFrequencyPolicy.kt", i = {0, 0, 1, 1, 1}, l = {54, 142}, m = "evaluate", n = {"snapshot", "context", "context", "request", "controlInterval"}, s = {"L$0", "L$1", "L$0", "L$1", "J$0"})
public final class MainConversationDisplayFrequencyPolicy$evaluate$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainConversationDisplayFrequencyPolicy this$0;

    public MainConversationDisplayFrequencyPolicy$evaluate$1(MainConversationDisplayFrequencyPolicy r1, Continuation<? super MainConversationDisplayFrequencyPolicy$evaluate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
