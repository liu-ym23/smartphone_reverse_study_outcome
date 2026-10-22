package com.obric.aiproactive.impl;

import com.obric.aiproactive.api.t;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/aiproactive/api/AiProactiveRecommendationDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$loadRecommendationsSnapshot$1$recommendations$1", f = "ProactiveService.kt", i = {}, l = {1031}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveService$loadRecommendationsSnapshot$1$recommendations$1 extends SuspendLambda implements Function2<al, Continuation<? super List<? extends t>>, Object> {
    final /* synthetic */ long $earliestTimeMillis;
    final /* synthetic */ long $latestTimeMillis;
    final /* synthetic */ ProactiveService $this_runCatching;
    int label;

    ProactiveService$loadRecommendationsSnapshot$1$recommendations$1(ProactiveService r3, long r4, long r6, Continuation<? super ProactiveService$loadRecommendationsSnapshot$1$recommendations$1> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_runCatching = r3;
        this.$earliestTimeMillis = r4;
        this.$latestTimeMillis = r6;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveService$loadRecommendationsSnapshot$1$recommendations$1(this.$this_runCatching, this.$earliestTimeMillis, this.$latestTimeMillis, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super List<? extends t>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super List<t>> r4) {
        return ((ProactiveService$loadRecommendationsSnapshot$1$recommendations$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveService$loadRecommendationsSnapshot$1$recommendations$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.obric.aiproactive.impl.aidb.d r3 = ProactiveService.access$getAiDbRepository(this.$this_runCatching);
        long r4 = this.$earliestTimeMillis;
        long r6 = this.$latestTimeMillis;
        Continuation<? super List<t>> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r10 = r3.a(r4, r6, r8);
        if (r10 != r0) goto L11;
        return r0;
    }
}
