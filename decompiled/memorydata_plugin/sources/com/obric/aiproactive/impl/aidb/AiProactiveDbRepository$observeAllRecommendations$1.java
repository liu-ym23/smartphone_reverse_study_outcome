package com.obric.aiproactive.impl.aidb;

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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/obric/aiproactive/impl/aidb/entity/AiProactiveRecommendationEntity;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.aidb.AiProactiveDbRepository$observeAllRecommendations$1", f = "AiProactiveDbRepository.kt", i = {0, 0}, l = {223, 225}, m = "invokeSuspend", n = {"$this$flow", "dao"}, s = {"L$0", "L$1"})
final class AiProactiveDbRepository$observeAllRecommendations$1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.j<? super List<? extends com.obric.aiproactive.impl.aidb.a.g>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ AiProactiveDb $db;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    AiProactiveDbRepository$observeAllRecommendations$1(AiProactiveDb r3, Continuation<? super AiProactiveDbRepository$observeAllRecommendations$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$db = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        AiProactiveDbRepository$observeAllRecommendations$1 r0 = new AiProactiveDbRepository$observeAllRecommendations$1(this.$db, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super List<? extends com.obric.aiproactive.impl.aidb.a.g>> r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.flow.j<? super List<com.obric.aiproactive.impl.aidb.a.g>> r3, Continuation<? super Unit> r4) {
        return ((AiProactiveDbRepository$observeAllRecommendations$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiProactiveDbRepository$observeAllRecommendations$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        com.obric.aiproactive.impl.aidb.dao.g r2 = (com.obric.aiproactive.impl.aidb.dao.g) ZeusTransformUtils.preCheckCast(this.L$1, com.obric.aiproactive.impl.aidb.dao.g.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.j r3 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L14:
        kotlinx.coroutines.flow.i<List<com.obric.aiproactive.impl.aidb.a.g>> r9 = r2.observeRecommendations(l.b(((Boolean) ZeusTransformUtils.preCheckCast(r8, Boolean.class, "com.obric.memorydata.plugin")).booleanValue()).a());
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (kotlinx.coroutines.flow.k.a(r3, r9, r4) != r0) goto L18;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        kotlinx.coroutines.flow.j r10 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r2 = this.$db.recommendationDao();
        Continuation r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.L$1 = r2;
        this.label = 1;
        Object r6 = l.a(r2, r5);
        if (r6 != r0) goto L13;
        return r0;
    L13:
        r3 = r10;
        r8 = r6;
        goto L14
    }
}
