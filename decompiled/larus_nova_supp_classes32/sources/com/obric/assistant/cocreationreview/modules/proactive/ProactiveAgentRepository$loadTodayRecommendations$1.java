package com.obric.assistant.cocreationreview.modules.proactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.proactive.ProactiveAgentRepository", f = "ProactiveAgentProvider.kt", i = {0, 0, 0, 0}, l = {536}, m = "loadTodayRecommendations", n = {"snapshot", "header", "items", "offset"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class ProactiveAgentRepository$loadTodayRecommendations$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveAgentRepository this$0;

    public ProactiveAgentRepository$loadTodayRecommendations$1(ProactiveAgentRepository r1, Continuation<? super ProactiveAgentRepository$loadTodayRecommendations$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ProactiveAgentRepository r3 = this.this$0;
        int r0 = ProactiveAgentRepository.b;
        return r3.e(null, null, this);
    }
}
