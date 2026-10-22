package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.g;
import com.obric.aiproactive.api.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.channels.w;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/obric/aiproactive/api/AiProactiveAgentRunDto;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.ProactiveRepositoryKt$observeAgentRunFlow$1", f = "ProactiveRepository.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveRepositoryKt$observeAgentRunFlow$1 extends SuspendLambda implements Function2<w<? super g>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $executionId;
    final /* synthetic */ IProactiveService $service;
    private /* synthetic */ Object L$0;
    int label;

    ProactiveRepositoryKt$observeAgentRunFlow$1(IProactiveService r3, String r4, Continuation<? super ProactiveRepositoryKt$observeAgentRunFlow$1> r5) {
        IProactiveService r6 = (IProactiveService) ZeusTransformUtils.wrapperContextForParams(r3, IProactiveService.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$service = r6;
        this.$executionId = r4;
        super(2, r7);
    }

    private static final void invokeSuspend$lambda$0(String r2, w r3, g r4) {
        w r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L5;
        String r0 = r4.a();
    L7:
        if (Intrinsics.areEqual(r0, r2) == false) goto L10;
        r5.mo54trySendJP2dKIU(r4);
        return;
    L10:
        return;
    L5:
        r0 = null;
        goto L7
    }

    private static final Unit invokeSuspend$lambda$1(IProactiveService r2, h r3) {
        IProactiveService r4 = (IProactiveService) ZeusTransformUtils.wrapperContextForParams(r2, IProactiveService.class, "com.obric.memorydata.plugin");
        h r5 = (h) ZeusTransformUtils.wrapperContextForParams(r3, h.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        r4.unregisterAgentRunListener(r5);
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void lambda$K55tlbPlVzwtmRcFQLs6nXYJBMY(String r0, w r1, g r2) {
        invokeSuspend$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$VFuzLaght00UdRRDIJUIMcO7Hvk(IProactiveService r0, h r1) {
        return invokeSuspend$lambda$1(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ProactiveRepositoryKt$observeAgentRunFlow$1 r0 = new ProactiveRepositoryKt$observeAgentRunFlow$1(this.$service, this.$executionId, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(w<? super g> r3, Continuation<? super Unit> r4) {
        return invoke2((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(w<? super g> r3, Continuation<? super Unit> r4) {
        return ((ProactiveRepositoryKt$observeAgentRunFlow$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveRepositoryKt$observeAgentRunFlow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        final w r8 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        final String r2 = this.$executionId;
        final h r4 = new $$Lambda$ProactiveRepositoryKt$observeAgentRunFlow$1$K55tlbPlVzwtmRcFQLs6nXYJBMY(r2, r8);
        IProactiveService r3 = this.$service;
        if (r3 == null) goto L11;
        r3.registerAgentRunListener(r4);
    L11:
        IProactiveService r5 = this.$service;
        if (r5 == null) goto L14;
        g r6 = r5.getAgentRun(this.$executionId);
    L15:
        r8.mo54trySendJP2dKIU(r6);
        final IProactiveService r9 = this.$service;
        Function0 r10 = new $$Lambda$ProactiveRepositoryKt$observeAgentRunFlow$1$VFuzLaght00UdRRDIJUIMcO7Hvk(r9, r4);
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (u.a(r8, r10, r11) != r0) goto L19;
        return r0;
    L14:
        r6 = null;
        goto L15
    }
}
