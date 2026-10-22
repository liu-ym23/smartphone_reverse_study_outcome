package com.obric.memorydata.memory.llm;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0001*\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$2", f = "MemoryLLMBuildHelperV2.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
final class MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$2 extends SuspendLambda implements Function2<al, Continuation<? super Pair<? extends List<? extends MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>>, Object> {
    final /* synthetic */ boolean $eval;
    final /* synthetic */ e $inputData;
    final /* synthetic */ com.obric.memorydata.memory.memoryentity.f $memorySourceInfo;
    final /* synthetic */ com.obric.memorydata.dc.a $pageContextHandle;
    final /* synthetic */ MemoryEntity $retryEntity;
    final /* synthetic */ com.obric.memorydata.memory.tracker.g.b $trackingEvent;
    int label;

    MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$2(com.obric.memorydata.memory.tracker.g.b r3, e r4, com.obric.memorydata.memory.memoryentity.f r5, com.obric.memorydata.dc.a r6, MemoryEntity r7, boolean r8, Continuation<? super MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$2> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$trackingEvent = r3;
        this.$inputData = r4;
        this.$memorySourceInfo = r5;
        this.$pageContextHandle = r6;
        this.$retryEntity = r7;
        this.$eval = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$2(this.$trackingEvent, this.$inputData, this.$memorySourceInfo, this.$pageContextHandle, this.$retryEntity, this.$eval, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Pair<? extends List<? extends MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r4) {
        return ((MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryLLMBuildHelperV2$executeMemoryBuildByLLM$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        MemoryLLMBuildHelperV2 r2 = MemoryLLMBuildHelperV2.f10255a;
        com.obric.memorydata.memory.tracker.g.b r12 = this.$trackingEvent;
        e r3 = this.$inputData;
        com.obric.memorydata.memory.memoryentity.f r4 = this.$memorySourceInfo;
        com.obric.memorydata.dc.a r5 = this.$pageContextHandle;
        MemoryEntity r6 = this.$retryEntity;
        boolean r7 = this.$eval;
        Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r11 = MemoryLLMBuildHelperV2.a(r2, r12, r3, r4, r5, r6, r7, r8);
        if (r11 != r0) goto L11;
        return r0;
    }
}
