package com.obric.memorydata.memory.island.gr;

import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandMockTestGr$testBeginThenSuccess$1", f = "IslandMockTestGr.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
final class IslandMockTestGr$testBeginThenSuccess$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommonTextMemoryEntity $mockEntity;
    final /* synthetic */ String $mockId;
    int label;

    IslandMockTestGr$testBeginThenSuccess$1(CommonTextMemoryEntity r3, String r4, Continuation<? super IslandMockTestGr$testBeginThenSuccess$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$mockEntity = r3;
        this.$mockId = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandMockTestGr$testBeginThenSuccess$1(this.$mockEntity, this.$mockId, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandMockTestGr$testBeginThenSuccess$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandMockTestGr$testBeginThenSuccess$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r36) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r36);
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandMockTestGr", "testBeginThenSuccess: Phase 2 → SUCCESS (记忆成功, 无日历)", false, 4, null);
        f.a.C0502a r3 = new f.a.C0502a((MemoryEntity) ZeusTransformUtils.preCheckCast(this.$mockEntity, MemoryEntity.class, "com.obric.memorydata.plugin"), "收藏", "周五下午3点开项目评审会", CollectionsKt.emptyList());
        f.f10213a.a(this.$mockId, new MemoryCollapseTemplate(new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_memory_result", ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, 4, null), new BigIslandTextInfo(null, "已记住", null, null, null, 29, null)), new MemoryExpandedTemplate(new ExpandedBaseInfo(1, "收藏", "周五下午3点开项目评审会", null, null, 24, null), new ExpandedIdentifyPicInfo(2, "miui.focus.pic_memory_result", Boxing.boxInt(ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, null, null, 56, null), null, null, 12, null), "已记住", false, true, 8000, r3);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandMockTestGr", "testBeginThenSuccess: SUCCESS shown, will dismiss in 8000ms", false, 4, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r36);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandMockTestGr", "testBeginThenSuccess: waiting 5000ms before SUCCESS...", false, 4, null);
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(5000, r4) != r1) goto L11;
        return r1;
    }
}
