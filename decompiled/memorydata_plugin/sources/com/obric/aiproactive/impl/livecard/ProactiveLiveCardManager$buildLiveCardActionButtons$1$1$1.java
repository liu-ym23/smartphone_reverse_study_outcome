package com.obric.aiproactive.impl.livecard;

import android.content.Context;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardManager$buildLiveCardActionButtons$1$1$1", f = "ProactiveLiveCardManager.kt", i = {}, l = {874, 881}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveLiveCardManager$buildLiveCardActionButtons$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $action;
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ IslandSession $capturedSession;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $hasLegacyExecuteInstruction;
    final /* synthetic */ ProactiveRecommendationDto $recommendation;
    int label;

    ProactiveLiveCardManager$buildLiveCardActionButtons$1$1$1(h r3, ProactiveRecommendationDto r4, IslandSession r5, String r6, Context r7, boolean r8, Continuation<? super ProactiveLiveCardManager$buildLiveCardActionButtons$1$1$1> r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$action = r3;
        this.$recommendation = r4;
        this.$capturedSession = r5;
        this.$actionLabel = r6;
        this.$context = ZeusTransformUtils.wrapperContext(r10, "com.obric.memorydata.plugin");
        this.$hasLegacyExecuteInstruction = r8;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$buildLiveCardActionButtons$1$1$1(this.$action, this.$recommendation, this.$capturedSession, this.$actionLabel, this.$context, this.$hasLegacyExecuteInstruction, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardManager$buildLiveCardActionButtons$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardManager$buildLiveCardActionButtons$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L24:
        IslandSession r15 = (IslandSession) ZeusTransformUtils.preCheckCast(r14, IslandSession.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L27;
        ProactiveLiveCardDisplayTool.INSTANCE.destroySession(r15);
    L27:
        n.a(n.f6478a, this.$recommendation, this.$action.a(), this.$actionLabel, null, 8, null);
        if (this.$action.d() == false) goto L31;
        n.a(n.f6478a, this.$context, this.$recommendation, this.$action.c());
    L34:
        return Unit.INSTANCE;
    L31:
        if (this.$hasLegacyExecuteInstruction == true) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Handled reply action on lock screen without launching assistant recommendId=" + this.$recommendation.getRecommendId() + " actionIndex=" + this.$action.a(), false, 4, null);
        goto L34
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L20:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r14);
        if (this.$action.e() == false) goto L21;
        n r5 = n.f6478a;
        ProactiveRecommendationDto r6 = this.$recommendation;
        h r7 = this.$action;
        IslandSession r8 = this.$capturedSession;
        if (r8 == null) goto L15;
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (n.a(r5, r6, r7, r8, null, r10, 8, null) != r0) goto L20;
        return r0;
    L15:
        return Unit.INSTANCE;
    L21:
        n r16 = n.f6478a;
        String r2 = this.$recommendation.getRecommendId();
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        r14 = n.a(r16, r2, r3);
        if (r14 != r0) goto L24;
        return r0;
    }
}
