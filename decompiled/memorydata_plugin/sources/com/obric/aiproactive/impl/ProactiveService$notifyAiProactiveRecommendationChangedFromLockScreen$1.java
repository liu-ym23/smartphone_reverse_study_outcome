package com.obric.aiproactive.impl;

import com.obric.aiproactive.api.t;
import com.obric.aiproactive.api.v;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$notifyAiProactiveRecommendationChangedFromLockScreen$1", f = "ProactiveService.kt", i = {}, l = {849}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveService$notifyAiProactiveRecommendationChangedFromLockScreen$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    final /* synthetic */ long $recommendationId;
    int label;
    final /* synthetic */ ProactiveService this$0;

    ProactiveService$notifyAiProactiveRecommendationChangedFromLockScreen$1(ProactiveService r3, long r4, String r6, Continuation<? super ProactiveService$notifyAiProactiveRecommendationChangedFromLockScreen$1> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$recommendationId = r4;
        this.$reason = r6;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveService$notifyAiProactiveRecommendationChangedFromLockScreen$1(this.this$0, this.$recommendationId, this.$reason, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveService$notifyAiProactiveRecommendationChangedFromLockScreen$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveService$notifyAiProactiveRecommendationChangedFromLockScreen$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        List<t> r12 = c.b((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"));
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r2 = new StringBuilder().append("[Runtime] notifyAiProactiveRecommendationChangedFromLockScreen id=").append(this.$recommendationId).append(" reason=").append(this.$reason).append(" listeners=").append(ProactiveService.access$getAiRecommendationJobs$p(this.this$0).size()).append(" latestSize=").append(r12.size()).append(" statuses=");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r3.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        t r7 = (t) ZeusTransformUtils.preCheckCast(r6.next(), t.class, "com.obric.memorydata.plugin");
        r5.add(TuplesKt.to(Boxing.boxLong(r7.a()), r7.l()));
        goto L13
    L15:
        IRunLog.a.a(r4, "ProactiveService", r2.append((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")).toString(), false, 4, null);
        Set r8 = ProactiveService.access$getAiRecommendationJobs$p(this.this$0).keySet();
        Intrinsics.checkNotNullExpressionValue(r8, "<get-keys>(...)");
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        long r10 = this.$recommendationId;
        Iterator r13 = r9.iterator();
    L17:
        if (r13.hasNext() == false) goto L24;
        ((v) ZeusTransformUtils.preCheckCast(r13.next(), v.class, "com.obric.memorydata.plugin")).a(r12);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        RunLog.INSTANCE.error("ProactiveService", "[Runtime] failed to notify aiProactive listener from lock screen id=" + r10, th);
        goto L17
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        com.obric.aiproactive.impl.aidb.d r14 = ProactiveService.access$getAiDbRepository(this.this$0);
        Continuation<? super List<t>> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r11 = r14.b(r15);
        if (r11 != r0) goto L11;
        return r0;
    }
}
