package com.obric.aiproactive.impl;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.w;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1", f = "ProactiveService.kt", i = {}, l = {493}, m = "invokeSuspend", n = {}, s = {})
final class ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ w<Boolean> $deferred;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProactiveService this$0;

    ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1(ProactiveService r3, w<Boolean> r4, Continuation<? super ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1> r5) {
        w<Boolean> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$deferred = r6;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1 r0 = new ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1(this.this$0, this.$deferred, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveService$ensureAiProactiveDbReadyInternal$1$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L15
    L13:
        Object r12 = Result.m1421constructorimpl((TaskResult) ZeusTransformUtils.preCheckCast(r11, TaskResult.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L15
    L18:
        if (Result.m1428isSuccessimpl(r12) == false) goto L26;
        Result.Companion r2 = Result.Companion;
        TaskResult r13 = (TaskResult) ZeusTransformUtils.preCheckCast(r12, TaskResult.class, "com.obric.memorydata.plugin");
        if (r13.getCode() != 0) goto L22;
        boolean r3 = true;
    L23:
        if (r3 == true) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveService", "[Runtime] ensureAiProactiveDbReady failed code=" + r13.getCode() + " msg=" + r13.getMsg(), null, 4, null);
    L25:
        r12 = Boxing.boxBoolean(r3);
        goto L26
    L22:
        r3 = false;
    L26:
        Object r14 = Result.m1421constructorimpl(r12);
        Throwable r4 = Result.m1424exceptionOrNullimpl(r14);
        if (r4 == null) goto L30;
        RunLog.INSTANCE.warn("ProactiveService", "[Runtime] ensureAiProactiveDbReady exception", r4);
        r14 = Boxing.boxBoolean(false);
    L30:
        boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        if (r15 == false) goto L33;
        ProactiveService.access$setAiProactiveDbReady$p(this.this$0, true);
    L33:
        Object r5 = ProactiveService.access$getAiProactiveDbReadyLock$p(this.this$0);
        ProactiveService r6 = this.this$0;
        w<Boolean> r7 = this.$deferred;
        monitor-enter(r5);
    L42:
        th = move-exception;
        throw th;
    L36:
        if (ProactiveService.access$getAiProactiveDbReadyDeferred$p(r6) != r7) goto L38;
        ProactiveService.access$setAiProactiveDbReadyDeferred$p(r6, null);     // Catch: Throwable -> L42
    L38:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L42
        monitor-exit(r5);
        this.$deferred.a(Boxing.boxBoolean(r15));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        al r16 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L15
        com.obric.aiproactive.impl.recording.b r18 = com.obric.aiproactive.impl.recording.b.f6506a;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r11 = r18.a(this);     // Catch: Throwable -> L15
        if (r11 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
