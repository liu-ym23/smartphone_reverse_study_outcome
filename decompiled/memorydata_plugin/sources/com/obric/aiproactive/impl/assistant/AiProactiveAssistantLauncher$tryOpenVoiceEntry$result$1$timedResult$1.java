package com.obric.aiproactive.impl.assistant;

import com.obric.eventkit.EventsTaskSdk;
import com.obric.eventkit.eventstaskmanager.ActiveAgentEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiproactive/impl/assistant/AiProactiveAssistantLauncher$ActiveAgentResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.assistant.AiProactiveAssistantLauncher$tryOpenVoiceEntry$result$1$timedResult$1", f = "AiProactiveAssistantLauncher.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
final class AiProactiveAssistantLauncher$tryOpenVoiceEntry$result$1$timedResult$1 extends SuspendLambda implements Function2<al, Continuation<? super a.C0283a>, Object> {
    final /* synthetic */ ActiveAgentEvent $event;
    int label;

    AiProactiveAssistantLauncher$tryOpenVoiceEntry$result$1$timedResult$1(ActiveAgentEvent r3, Continuation<? super AiProactiveAssistantLauncher$tryOpenVoiceEntry$result$1$timedResult$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$event = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AiProactiveAssistantLauncher$tryOpenVoiceEntry$result$1$timedResult$1(this.$event, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super a.C0283a> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super a.C0283a> r4) {
        return ((AiProactiveAssistantLauncher$tryOpenVoiceEntry$result$1$timedResult$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiProactiveAssistantLauncher$tryOpenVoiceEntry$result$1$timedResult$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return new a.C0283a((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.memorydata.plugin"), false);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        EventsTaskSdk r7 = EventsTaskSdk.INSTANCE;
        ActiveAgentEvent r2 = this.$event;
        Continuation<? super Boolean> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r6 = r7.tryActiveAgent(r2, r4);
        if (r6 != r0) goto L12;
        return r0;
    }
}
