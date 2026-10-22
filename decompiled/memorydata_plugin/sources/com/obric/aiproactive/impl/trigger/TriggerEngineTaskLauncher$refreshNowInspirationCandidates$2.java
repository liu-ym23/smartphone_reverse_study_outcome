package com.obric.aiproactive.impl.trigger;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskResult;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/task/impl/TaskResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.trigger.TriggerEngineTaskLauncher$refreshNowInspirationCandidates$2", f = "TriggerEngineTaskLauncher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TriggerEngineTaskLauncher$refreshNowInspirationCandidates$2 extends SuspendLambda implements Function2<al, Continuation<? super TaskResult>, Object> {
    int label;

    TriggerEngineTaskLauncher$refreshNowInspirationCandidates$2(Continuation<? super TriggerEngineTaskLauncher$refreshNowInspirationCandidates$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new TriggerEngineTaskLauncher$refreshNowInspirationCandidates$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super TaskResult> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super TaskResult> r4) {
        return ((TriggerEngineTaskLauncher$refreshNowInspirationCandidates$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), TriggerEngineTaskLauncher$refreshNowInspirationCandidates$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        RunLog.INSTANCE.debug("TriggerEngineTaskLauncher", "refreshNowInspirationCandidates: execute trigger_engine with foreground max-priority request");
        TaskResult r3 = e.f6532a.a(d.f6531a.b()).execute();
        RunLog.INSTANCE.debug("TriggerEngineTaskLauncher", "refreshNowInspirationCandidates: trigger_engine finished, code=" + r3.getCode() + ", msg=" + r3.getMsg());
        return r3;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
