package com.obric.memorydata.recommend.ui.list;

import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.bridge.VectorDbBridgeAPI;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.RecommendMemoryListActivity$showClearDialog$2$1", f = "RecommendMemoryListActivity.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
final class RecommendMemoryListActivity$showClearDialog$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RecommendMemoryListActivity this$0;

    RecommendMemoryListActivity$showClearDialog$2$1(RecommendMemoryListActivity r3, Continuation<? super RecommendMemoryListActivity$showClearDialog$2$1> r4) {
        RecommendMemoryListActivity r5 = (RecommendMemoryListActivity) ZeusTransformUtils.wrapperContextForParams(r3, RecommendMemoryListActivity.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r5;
        super(2, r6);
    }

    private static final void invokeSuspend$lambda$0() {
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao().deleteAll();
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryTextVectorCopilotDao().deleteAll();
        MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryContentTimeDao().deleteAll();
        VectorDbBridgeAPI.INSTANCE.cleanTable(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryTextVectorCopilotDao().getTableName());
    }

    /* JADX INFO: renamed from: lambda$LyMwEOnXLh3D-h3HB42GjHOpj7g, reason: not valid java name */
    public static /* synthetic */ void m1147lambda$LyMwEOnXLh3Dh3HB42GjHOpj7g() {
        invokeSuspend$lambda$0();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new RecommendMemoryListActivity$showClearDialog$2$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((RecommendMemoryListActivity$showClearDialog$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), RecommendMemoryListActivity$showClearDialog$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L15;
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$RecommendMemoryListActivity$showClearDialog$2$1$LyMwEOnXLh3Dh3HB42GjHOpj7g.INSTANCE);
        RecommendMemoryListActivity.access$getShareViewModel(this.this$0).setMemoryCleared(true);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MemoryListShareViewModel r6 = RecommendMemoryListActivity.access$getShareViewModel(this.this$0);
        Continuation<? super Boolean> r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r5 = r6.clearMemory(r2);
        if (r5 != r0) goto L12;
        return r0;
    }
}
