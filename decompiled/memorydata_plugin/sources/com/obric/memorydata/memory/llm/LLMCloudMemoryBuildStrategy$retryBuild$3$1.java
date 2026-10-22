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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\"\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0001*\u00020\u0007H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/obric/memorydata/memory/llm/MemoryLLMBuildHelperV2$ResultEntity;", "", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.LLMCloudMemoryBuildStrategy$retryBuild$3$1", f = "LLMCloudMemoryBuildStrategy.kt", i = {}, l = {266}, m = "invokeSuspend", n = {}, s = {})
final class LLMCloudMemoryBuildStrategy$retryBuild$3$1 extends SuspendLambda implements Function2<al, Continuation<? super Pair<? extends List<? extends MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>>, Object> {
    final /* synthetic */ boolean $eval;
    final /* synthetic */ com.obric.memorydata.middleware.api.logging.e $logContext;
    final /* synthetic */ MemoryEntity $memoryEntity;
    final /* synthetic */ com.obric.memorydata.memory.tracker.g.b $mobileMemBuildEvent;
    final /* synthetic */ String $screenshotPath;
    final /* synthetic */ MemoryEntity $this_apply;
    int label;

    LLMCloudMemoryBuildStrategy$retryBuild$3$1(com.obric.memorydata.memory.tracker.g.b r3, MemoryEntity r4, String r5, com.obric.memorydata.middleware.api.logging.e r6, MemoryEntity r7, boolean r8, Continuation<? super LLMCloudMemoryBuildStrategy$retryBuild$3$1> r9) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$mobileMemBuildEvent = r3;
        this.$this_apply = r4;
        this.$screenshotPath = r5;
        this.$logContext = r6;
        this.$memoryEntity = r7;
        this.$eval = r8;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new LLMCloudMemoryBuildStrategy$retryBuild$3$1(this.$mobileMemBuildEvent, this.$this_apply, this.$screenshotPath, this.$logContext, this.$memoryEntity, this.$eval, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Pair<? extends List<? extends MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r4) {
        return ((LLMCloudMemoryBuildStrategy$retryBuild$3$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), LLMCloudMemoryBuildStrategy$retryBuild$3$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r31) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r31);
        Object r0 = r31;
    L37:
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r0, Pair.class, "com.obric.memorydata.plugin");
        return new Pair((List) ZeusTransformUtils.preCheckCast(r3.component1(), List.class, "com.obric.memorydata.plugin"), (Map) ZeusTransformUtils.preCheckCast(r3.component2(), Map.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r31);
        com.obric.memorydata.memory.tracker.g.b r4 = this.$mobileMemBuildEvent;
        Integer r5 = null;
        if (r4 == null) goto L11;
        com.obric.memorydata.memory.tracker.g.b.a(r4, 0, 1, null);
    L11:
        MemoryLLMBuildHelperV2 r8 = MemoryLLMBuildHelperV2.f10255a;
        com.obric.memorydata.memory.tracker.g.b r9 = this.$mobileMemBuildEvent;
        String r11 = this.$this_apply.getSourceQuery();
        String r12 = this.$screenshotPath;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(this.$this_apply.getSourceQuery(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L14;
    L17:
        boolean r7 = true;
    L18:
        if (r7 == false) goto L20;
        String r13 = this.$this_apply.getSourceText();
    L21:
        String r14 = this.$this_apply.getSourceAppName();
        String r15 = this.$this_apply.getSourcePackageName();
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(this.$this_apply.getSourceQuery(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L24;
    L27:
        boolean r16 = true;
    L28:
        if (r16 == false) goto L30;
        String r17 = null;
    L32:
        if (this.$screenshotPath == null) goto L34;
        r5 = Boxing.boxInt(0);
    L34:
        e r18 = new e(r11, r12, r13, r14, r15, null, r17, null, null, null, r5, Boxing.boxInt(this.$this_apply.getProductType()), null, this.$logContext, true, 0, 37760, null);
        MemoryEntity r19 = this.$memoryEntity;
        boolean r110 = this.$eval;
        Continuation<? super Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r0 = r8.a(r9, r18, null, null, r19, r110, r111);
        if (r0 != r1) goto L37;
        return r1;
    L30:
        r17 = this.$this_apply.getSourceText();
        goto L32
    L24:
        if (r10.length() == 0) goto L27;
        r16 = false;
        goto L28
    L20:
        r13 = null;
        goto L21
    L14:
        if (r6.length() == 0) goto L17;
        r7 = false;
        goto L18
    }
}
