package com.obric.memorydata.personalcontext.state;

import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.state.AssistantStateSettings$registerStateListener$1", f = "AssistantStateSettings.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AssistantStateSettings$registerStateListener$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ a $listener;
    int label;

    AssistantStateSettings$registerStateListener$1(a r3, Continuation<? super AssistantStateSettings$registerStateListener$1> r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$listener = r5;
        super(2, r6);
    }

    private static final void invokeSuspend$lambda$0(a r8, String r9, SharedValue r10) {
        a r11 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.memorydata.plugin");
        SharedValue r12 = (SharedValue) ZeusTransformUtils.wrapperContextForParams(r10, SharedValue.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(r9, "doubao_start_as_default_assistant") == false) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantStateSettings", "start as default assistant, value:" + r12.getValue(), false, 4, null);
        Object r13 = r12.getValue();
        if (ZeusTransformUtils.instanceOf(r13, Integer.class) == false) goto L7;
        Integer r14 = (Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.memorydata.plugin");
    L8:
        if (r14 == null) goto L16;
        boolean r15 = true;
        if (r14.intValue() == 1) goto L13;
        r15 = false;
    L13:
        r11.a(r15);
        return;
    L16:
        return;
    L7:
        r14 = null;
        goto L8
    }

    public static /* synthetic */ void lambda$KC0tKoqZGyqPhRSPf4Cj_a5QjYg(a r0, String r1, SharedValue r2) {
        invokeSuspend$lambda$0(r0, r1, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AssistantStateSettings$registerStateListener$1(this.$listener, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AssistantStateSettings$registerStateListener$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AssistantStateSettings$registerStateListener$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r7);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "AssistantStateSettings", "registerStateListener start", false, 4, null);
        SharedState r8 = SharedState.INSTANCE;
        List r0 = CollectionsKt.listOf("doubao_start_as_default_assistant");
        final a r6 = this.$listener;
        r8.registerObserver(r0, new $$Lambda$AssistantStateSettings$registerStateListener$1$KC0tKoqZGyqPhRSPf4Cj_a5QjYg(r6));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
