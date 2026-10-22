package com.obric.aiproactive.impl.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.assistant.AiProactiveAssistantLauncher", f = "AiProactiveAssistantLauncher.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {161, 162}, m = "logActiveAgentDebugState", n = {"this", "stage", "event", "rawResult", "timedOut", "stage", "event", "rawResult", "timedOut", "sessionState"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class AiProactiveAssistantLauncher$logActiveAgentDebugState$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    AiProactiveAssistantLauncher$logActiveAgentDebugState$1(a r3, Continuation<? super AiProactiveAssistantLauncher$logActiveAgentDebugState$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
