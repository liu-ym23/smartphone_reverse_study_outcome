package com.obric.assistant.cocreationreview.modules.proactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.proactive.ProactiveAgentRepository", f = "ProactiveAgentProvider.kt", i = {0, 0, 0, 0}, l = {560}, m = "loadPagedDayRecommendations", n = {"dayKey", "items", "batchId", "offset"}, s = {"L$0", "L$1", "J$0", "I$0"})
public final class ProactiveAgentRepository$loadPagedDayRecommendations$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveAgentRepository this$0;

    public ProactiveAgentRepository$loadPagedDayRecommendations$1(ProactiveAgentRepository r1, Continuation<? super ProactiveAgentRepository$loadPagedDayRecommendations$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        ProactiveAgentRepository r5 = this.this$0;
        int r0 = ProactiveAgentRepository.b;
        return r5.c(0, null, this);
    }
}
