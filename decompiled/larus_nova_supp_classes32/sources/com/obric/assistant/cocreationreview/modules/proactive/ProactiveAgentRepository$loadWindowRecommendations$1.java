package com.obric.assistant.cocreationreview.modules.proactive;

import com.miui.easygo.sdk.constant.EasyGoCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.proactive.ProactiveAgentRepository", f = "ProactiveAgentProvider.kt", i = {0, 0, 0, 0, 0}, l = {EasyGoCode.InitializedErrCode.UNKNOWN_ERR}, m = "loadWindowRecommendations", n = {"snapshot", "request", "window", "items", "offset"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
public final class ProactiveAgentRepository$loadWindowRecommendations$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveAgentRepository this$0;

    public ProactiveAgentRepository$loadWindowRecommendations$1(ProactiveAgentRepository r1, Continuation<? super ProactiveAgentRepository$loadWindowRecommendations$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ProactiveAgentRepository r3 = this.this$0;
        int r0 = ProactiveAgentRepository.b;
        return r3.f(null, null, null, this);
    }
}
