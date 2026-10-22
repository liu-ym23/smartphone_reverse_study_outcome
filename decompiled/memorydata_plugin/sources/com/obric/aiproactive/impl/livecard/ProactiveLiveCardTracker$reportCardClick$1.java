package com.obric.aiproactive.impl.livecard;

import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.y;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardTracker$reportCardClick$1", f = "ProactiveLiveCardTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveLiveCardTracker$reportCardClick$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $buttonType;
    final /* synthetic */ ProactiveRecommendationDto $recommendation;
    int label;

    ProactiveLiveCardTracker$reportCardClick$1(ProactiveRecommendationDto r3, String r4, Continuation<? super ProactiveLiveCardTracker$reportCardClick$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$recommendation = r3;
        this.$buttonType = r4;
        super(2, r6);
    }

    private static final Unit invokeSuspend$lambda$0(Exception r0) {
        r0.printStackTrace();
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$1(ProactiveRecommendationDto r2, String r3) {
        JSONObject r4 = s.a(s.a(r2.getRecommendId(), r.a(r.f6485a, r3)));
        RunLog.INSTANCE.debug("ProactiveLiveCardTracker", "[Tracker] event=card_click params=" + r4);
        Tracker.INSTANCE.reportEvent("card_click", r4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$BN2EFu2Jo5n_-PS0rZUR0sEzwgY, reason: not valid java name */
    public static /* synthetic */ Unit m231lambda$BN2EFu2Jo5n_PS0rZUR0sEzwgY(ProactiveRecommendationDto r0, String r1) {
        return invokeSuspend$lambda$1(r0, r1);
    }

    public static /* synthetic */ Unit lambda$LzmbJln7LVBySmNtfnsec9uAGt0(Exception r0) {
        return invokeSuspend$lambda$0(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardTracker$reportCardClick$1(this.$recommendation, this.$buttonType, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardTracker$reportCardClick$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardTracker$reportCardClick$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        $$Lambda$ProactiveLiveCardTracker$reportCardClick$1$LzmbJln7LVBySmNtfnsec9uAGt0 r4 = $$Lambda$ProactiveLiveCardTracker$reportCardClick$1$LzmbJln7LVBySmNtfnsec9uAGt0.INSTANCE;
        final ProactiveRecommendationDto r0 = this.$recommendation;
        final String r2 = this.$buttonType;
        y.a(r4, new $$Lambda$ProactiveLiveCardTracker$reportCardClick$1$BN2EFu2Jo5n_PS0rZUR0sEzwgY(r0, r2));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
