package com.obric.aiproactive.impl.assistant;

import com.ss.bduploader.BDObjectUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.assistant.AiProactiveAssistantLauncher", f = "AiProactiveAssistantLauncher.kt", i = {0, 0, 0, 1, 1, 2}, l = {85, BDObjectUploader.KeyIsEnableGatewayForObject, 100}, m = "tryOpenVoiceEntry", n = {"this", "event", "timeoutMs", "event", "$this$tryOpenVoiceEntry_u24lambda_u244", "timedResult"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$0"})
final class AiProactiveAssistantLauncher$tryOpenVoiceEntry$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    AiProactiveAssistantLauncher$tryOpenVoiceEntry$1(a r3, Continuation<? super AiProactiveAssistantLauncher$tryOpenVoiceEntry$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
