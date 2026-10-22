package com.obric.aiproactive.ui.data;

import com.obric.aiproactive.api.IProactiveService;
import com.obric.aiproactive.api.PageType;
import com.obric.aiproactive.api.ProactiveDayPageResult;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiproactive/api/ProactiveDayPageResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.ui.data.DefaultProactiveRepository$loadDayRecommendationsPage$2", f = "ProactiveRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DefaultProactiveRepository$loadDayRecommendationsPage$2 extends SuspendLambda implements Function2<al, Continuation<? super ProactiveDayPageResult>, Object> {
    final /* synthetic */ long $batchId;
    final /* synthetic */ String $dayKey;
    final /* synthetic */ int $limit;
    final /* synthetic */ int $offset;
    int label;
    final /* synthetic */ a this$0;

    DefaultProactiveRepository$loadDayRecommendationsPage$2(long r3, String r5, int r6, int r7, a r8, Continuation<? super DefaultProactiveRepository$loadDayRecommendationsPage$2> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$batchId = r3;
        this.$dayKey = r5;
        this.$offset = r6;
        this.$limit = r7;
        this.this$0 = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new DefaultProactiveRepository$loadDayRecommendationsPage$2(this.$batchId, this.$dayKey, this.$offset, this.$limit, this.this$0, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super ProactiveDayPageResult> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super ProactiveDayPageResult> r4) {
        return ((DefaultProactiveRepository$loadDayRecommendationsPage$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), DefaultProactiveRepository$loadDayRecommendationsPage$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r20);
        PageType r1 = PageType.ALL;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] loadDayRecommendationsPage request listenerType=" + r1.getListenerType() + " batchId=" + this.$batchId + " dayKey=" + this.$dayKey + " offset=" + this.$offset + " limit=" + this.$limit, false, 4, null);
        IProactiveService r5 = a.a(this.this$0);
        if (r5 == null) goto L8;
        ProactiveDayPageResult r2 = r5.loadDayRecommendationsPage(this.$batchId, this.$dayKey, this.$offset, this.$limit);
        if (r2 == null) goto L8;
    L9:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] loadDayRecommendationsPage result listenerType=" + r1.getListenerType() + " requestBatchId=" + this.$batchId + " responseBatchId=" + r2.getBatchId() + " dayKey=" + r2.getDayKey() + " offset=" + this.$offset + " limit=" + this.$limit + " pageSize=" + r2.getList().size() + " hasNext=" + r2.getHasNext(), false, 4, null);
        if (r2.getBatchId() != 0) goto L12;
    L14:
        return r2;
    L12:
        if (r2.getBatchId() == this.$batchId) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveUI", "[Repo] loadDayRecommendationsPage batchChanged listenerType=" + r1.getListenerType() + " requestBatchId=" + this.$batchId + " responseBatchId=" + r2.getBatchId() + " dayKey=" + r2.getDayKey() + " offset=" + this.$offset + " limit=" + this.$limit + " pageSize=" + r2.getList().size() + " hasNext=" + r2.getHasNext(), null, 4, null);
    L8:
        r2 = new ProactiveDayPageResult(this.$batchId, this.$dayKey, false, CollectionsKt.emptyList());
        goto L9
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
