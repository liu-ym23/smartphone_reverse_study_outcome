package com.obric.memorydata.init.tasks;

import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.init.tasks.MemoryInitTask$dailyReportCallback$1$onDailyReport$7", f = "MemoryInitTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryInitTask$dailyReportCallback$1$onDailyReport$7 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;

    MemoryInitTask$dailyReportCallback$1$onDailyReport$7(Continuation<? super MemoryInitTask$dailyReportCallback$1$onDailyReport$7> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryInitTask$dailyReportCallback$1$onDailyReport$7((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryInitTask$dailyReportCallback$1$onDailyReport$7) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryInitTask$dailyReportCallback$1$onDailyReport$7.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r13);
        List<MemoryRuleEntity> r12 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().queryAll();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInitTask", "rule daily report start, count=" + r12.size(), false, 4, null);
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r14.hasNext() == false) goto L8;
        MemoryRuleEntity r15 = (MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r14.next(), MemoryRuleEntity.class, "com.obric.memorydata.plugin");
        MemoryEventTracker.f10515a.a(r15.isFromPreset(), r15.getTitle(), r15.getMemoryInfoJson(), r15.getActiveStartMinute(), r15.getActiveEndMinute(), r15.getAutoCaptureEnabled(), r15.isPaused(), r15.getAppPackages(), r15.getSource());
        goto L6
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryInitTask", "rule daily report end", false, 4, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
