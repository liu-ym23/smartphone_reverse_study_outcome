package com.obric.memorydata.memory.island.gr;

import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandMockTestGr$testBeginThenSuccessWithCalendar$1", f = "IslandMockTestGr.kt", i = {}, l = {255, WifiScanSceneType.ELEVATOR_END, 301}, m = "invokeSuspend", n = {}, s = {})
final class IslandMockTestGr$testBeginThenSuccessWithCalendar$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<PendingMemoryCalendar> $mockCalendars;
    final /* synthetic */ CommonTextMemoryEntity $mockEntity;
    final /* synthetic */ String $mockId;
    int label;

    IslandMockTestGr$testBeginThenSuccessWithCalendar$1(CommonTextMemoryEntity r3, List<PendingMemoryCalendar> r4, String r5, Continuation<? super IslandMockTestGr$testBeginThenSuccessWithCalendar$1> r6) {
        List<PendingMemoryCalendar> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$mockEntity = r3;
        this.$mockCalendars = r7;
        this.$mockId = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandMockTestGr$testBeginThenSuccessWithCalendar$1(this.$mockEntity, this.$mockCalendars, this.$mockId, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandMockTestGr$testBeginThenSuccessWithCalendar$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandMockTestGr$testBeginThenSuccessWithCalendar$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r35) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        ResultKt.throwOnFailure(r35);
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r35);
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandMockTestGr", "testBeginThenSuccessWithCalendar: Phase 3 → overriding calendar autoDismiss to 15000ms", false, 4, null);
        f.a r3 = f.f10213a;
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 3;
        if (r3.a(SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME, r5) != r1) goto L22;
        return r1;
    L11:
        ResultKt.throwOnFailure(r35);
    L15:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandMockTestGr", "testBeginThenSuccessWithCalendar: Phase 2 → SUCCESS (带日历)", false, 4, null);
        f.a.C0502a r4 = new f.a.C0502a((MemoryEntity) ZeusTransformUtils.preCheckCast(this.$mockEntity, MemoryEntity.class, "com.obric.memorydata.plugin"), "收藏", "后天下午2点团建聚餐", this.$mockCalendars);
        f.f10213a.a(this.$mockId, new MemoryCollapseTemplate(new BigIslandImageTextInfoLeft(1, BigIslandPicInfo.Companion.a("miui.focus.pic_memory_result", ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, 4, null), new BigIslandTextInfo(null, "已记住", null, null, null, 29, null)), new MemoryExpandedTemplate(new ExpandedBaseInfo(1, "收藏", "后天下午2点团建聚餐", null, null, 24, null), new ExpandedIdentifyPicInfo(2, "miui.focus.pic_memory_result", Boxing.boxInt(ZeusTransformUtils.mapRes(R.drawable.ic_memory_result, "drawable", "ic_memory_result")), null, null, null, 56, null), null, null, 12, null), "已记住", false, true, 3000, r4);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandMockTestGr", "testBeginThenSuccessWithCalendar: SUCCESS shown with calendar, will dismiss in 3000ms then show calendar recommend", false, 4, null);
        Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (au.a(5000, r6) != r1) goto L18;
        return r1;
    L12:
        ResultKt.throwOnFailure(r35);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandMockTestGr", "testBeginThenSuccessWithCalendar: waiting 5000ms...", false, 4, null);
        Continuation r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(5000, r7) != r1) goto L15;
        return r1;
    }
}
