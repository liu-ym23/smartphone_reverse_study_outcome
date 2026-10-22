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
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardTracker$reportCardShow$1", f = "ProactiveLiveCardTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveLiveCardTracker$reportCardShow$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProactiveRecommendationDto $recommendation;
    int label;

    ProactiveLiveCardTracker$reportCardShow$1(ProactiveRecommendationDto r3, Continuation<? super ProactiveLiveCardTracker$reportCardShow$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$recommendation = r3;
        super(2, r5);
    }

    private static final Unit invokeSuspend$lambda$0(Exception r0) {
        r0.printStackTrace();
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$1(ProactiveRecommendationDto r3) {
        JSONObject r4 = s.a(s.a(r3.getRecommendId()));
        RunLog.INSTANCE.debug("ProactiveLiveCardTracker", "[Tracker] event=card_show params=" + r4);
        Tracker.INSTANCE.reportEvent("card_show", r4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$E5P3e-F0ocPZi_2uCY_bddB7spY, reason: not valid java name */
    public static /* synthetic */ Unit m232lambda$E5P3eF0ocPZi_2uCY_bddB7spY(Exception r0) {
        return invokeSuspend$lambda$0(r0);
    }

    public static /* synthetic */ Unit lambda$OAHyoWPvmDlVGsgBi16KjFT5lL4(ProactiveRecommendationDto r0) {
        return invokeSuspend$lambda$1(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardTracker$reportCardShow$1(this.$recommendation, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardTracker$reportCardShow$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardTracker$reportCardShow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        $$Lambda$ProactiveLiveCardTracker$reportCardShow$1$E5P3eF0ocPZi_2uCY_bddB7spY r3 = $$Lambda$ProactiveLiveCardTracker$reportCardShow$1$E5P3eF0ocPZi_2uCY_bddB7spY.INSTANCE;
        final ProactiveRecommendationDto r1 = this.$recommendation;
        y.a(r3, new $$Lambda$ProactiveLiveCardTracker$reportCardShow$1$OAHyoWPvmDlVGsgBi16KjFT5lL4(r1));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
