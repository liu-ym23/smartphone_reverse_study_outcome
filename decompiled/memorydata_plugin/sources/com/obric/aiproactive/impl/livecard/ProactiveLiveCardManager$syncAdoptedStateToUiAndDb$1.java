package com.obric.aiproactive.impl.livecard;

import android.content.Context;
import android.content.Intent;
import com.obric.aiproactive.api.ProactiveRecommendationDto;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
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
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1", f = "ProactiveLiveCardManager.kt", i = {}, l = {303}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $actionLabel;
    final /* synthetic */ ProactiveRecommendationDto $recommendation;
    int label;

    ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1(String r3, ProactiveRecommendationDto r4, Continuation<? super ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$actionLabel = r3;
        this.$recommendation = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1(this.$actionLabel, this.$recommendation, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L10;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L7
        ProactiveLiveCardManager$syncAdoptedStateToUiAndDb$1 this = this;
    L22:
    L21:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r12);
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        Intent r3 = new Intent("com.obric.proactive.action.RECOMMENDATION_ADOPTED");     // Catch: Exception -> L14
        ProactiveRecommendationDto r5 = this.$recommendation;     // Catch: Exception -> L14
        String r6 = this.$actionLabel;     // Catch: Exception -> L14
        r3.setClassName(r13.getPackageName(), "com.obric.aiproactive.ui.ipc.ProactiveUiSyncReceiver");     // Catch: Exception -> L14
        r3.putExtra("recommendId", r5.getRecommendId());     // Catch: Exception -> L14
        r3.putExtra("feedbackAction", r6);     // Catch: Exception -> L14
        r13.sendBroadcast(r3);     // Catch: Exception -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Broadcast sent for action=" + this.$actionLabel + " recommendId=" + this.$recommendation.getRecommendId() + " target=" + r13.getPackageName() + "/com.obric.aiproactive.ui.ipc.ProactiveUiSyncReceiver", false, 4, null);     // Catch: Exception -> L14
    L16:
        n r14 = n.f6478a;     // Catch: Throwable -> L7
        String r4 = this.$recommendation.getRecommendId();     // Catch: Throwable -> L7
        String r7 = this.$actionLabel;     // Catch: Throwable -> L7
        Continuation r0 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        Object r11 = n.a(r14, r4, r7, r0);     // Catch: Throwable -> L7
        this = r11;
        if (r11 != r1) goto L22;
        return r1;
    L14:
        e = move-exception;
        RunLog.INSTANCE.error("ProactiveLiveCardManager", "Failed to send broadcast for action=" + this.$actionLabel, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L7:
        th = move-exception;
        RunLog.INSTANCE.error("ProactiveLiveCardManager", "Failed to sync ai_proactive DB status on lock screen action=" + this.$actionLabel, th);
        goto L21
    }
}
