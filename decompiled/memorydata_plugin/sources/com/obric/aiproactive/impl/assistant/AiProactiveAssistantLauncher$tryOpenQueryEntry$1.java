package com.obric.aiproactive.impl.assistant;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.assistant.AiProactiveAssistantLauncher", f = "AiProactiveAssistantLauncher.kt", i = {0, 0, 0, 0, 1, 1, 1, 2}, l = {125, 127, 140}, m = "tryOpenQueryEntry", n = {"this", "normalizedQuery", "event", "timeoutMs", "normalizedQuery", "event", "$this$tryOpenQueryEntry_u24lambda_u247", "timedResult"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "L$0"})
final class AiProactiveAssistantLauncher$tryOpenQueryEntry$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    AiProactiveAssistantLauncher$tryOpenQueryEntry$1(a r3, Continuation<? super AiProactiveAssistantLauncher$tryOpenQueryEntry$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
