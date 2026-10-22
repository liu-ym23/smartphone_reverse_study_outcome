package com.obric.aiproactive.impl.bridge;

import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiproactive.api.IProactiveService;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.bridge.AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1", f = "AiProactiveAgentBridgeImpl.kt", i = {0}, l = {223}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1(Continuation<? super AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1 r4 = new AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AiProactiveAgentBridgeImpl$scheduleSpellStartAfterDbReady$1$job$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        al r11 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L8
    L17:
        Object r13 = Result.m1421constructorimpl((TaskResult) ZeusTransformUtils.preCheckCast(r12, TaskResult.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
    L22:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r13);     // Catch: Throwable -> L95
        if (r3 != null) goto L86;
        TaskResult r14 = (TaskResult) ZeusTransformUtils.preCheckCast(r13, TaskResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        if (r14.getCode() == 0) goto L38;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AiProactiveAgentBridgeImpl.TAG, "ensure ai proactive db for Spell failed code=" + r14.getCode() + " msg=" + r14.getMsg(), null, 4, null);     // Catch: Throwable -> L95
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L95
        Object r4 = AiProactiveAgentBridgeImpl.access$getLock$p();
        monitor-enter(r4);
    L35:
        th = move-exception;
        throw th;
    L30:
        if (AiProactiveAgentBridgeImpl.access$getPendingSpellListeningJob$p() != r11.getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"))) goto L32;
        AiProactiveAgentBridgeImpl r16 = AiProactiveAgentBridgeImpl.INSTANCE;     // Catch: Throwable -> L35
        AiProactiveAgentBridgeImpl.access$setPendingSpellListeningJob$p(null);     // Catch: Throwable -> L35
    L32:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L35
        monitor-exit(r4);
        return r15;
    L38:
        IProactiveService r18 = (IProactiveService) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveService.class)), IProactiveService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        if (r18 != null) goto L53;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AiProactiveAgentBridgeImpl.TAG, "pending startSpellProactiveEcaListening aborted: service not ready", null, 4, null);     // Catch: Throwable -> L95
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L95
        Object r5 = AiProactiveAgentBridgeImpl.access$getLock$p();
        monitor-enter(r5);
    L49:
        th = move-exception;
        throw th;
    L44:
        if (AiProactiveAgentBridgeImpl.access$getPendingSpellListeningJob$p() != r11.getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"))) goto L46;
        AiProactiveAgentBridgeImpl r110 = AiProactiveAgentBridgeImpl.INSTANCE;     // Catch: Throwable -> L49
        AiProactiveAgentBridgeImpl.access$setPendingSpellListeningJob$p(null);     // Catch: Throwable -> L49
    L46:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L49
        monitor-exit(r5);
        return r19;
    L53:
        if (r18.ensureAgreePrivacyAndLogin() == true) goto L55;
    L74:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), AiProactiveAgentBridgeImpl.TAG, "pending startSpellProactiveEcaListening blocked", null, 4, null);     // Catch: Throwable -> L95
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L95
        Object r6 = AiProactiveAgentBridgeImpl.access$getLock$p();
        monitor-enter(r6);
    L83:
        th = move-exception;
        throw th;
    L78:
        if (AiProactiveAgentBridgeImpl.access$getPendingSpellListeningJob$p() != r11.getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"))) goto L80;
        AiProactiveAgentBridgeImpl r113 = AiProactiveAgentBridgeImpl.INSTANCE;     // Catch: Throwable -> L83
        AiProactiveAgentBridgeImpl.access$setPendingSpellListeningJob$p(null);     // Catch: Throwable -> L83
    L80:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L83
        monitor-exit(r6);
        return r112;
    L55:
        if (r18.isAiProactiveWakeUpEnabled() == false) goto L74;
        boolean r115 = com.obric.aiproactive.impl.trigger.c.f6527a.a();     // Catch: Throwable -> L95
        IRunLog r7 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L95
        StringBuilder r8 = new StringBuilder().append("pending startSpellProactiveEcaListening started=");     // Catch: Throwable -> L95
        if (r115 == true) goto L61;
        r2 = false;
    L61:
        IRunLog.a.a(r7, AiProactiveAgentBridgeImpl.TAG, r8.append(r2).toString(), false, 4, null);     // Catch: Throwable -> L95
        Object r116 = AiProactiveAgentBridgeImpl.access$getLock$p();
        monitor-enter(r116);
    L71:
        th = move-exception;
        throw th;
    L65:
        if (AiProactiveAgentBridgeImpl.access$getPendingSpellListeningJob$p() != r11.getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"))) goto L67;
        AiProactiveAgentBridgeImpl r117 = AiProactiveAgentBridgeImpl.INSTANCE;     // Catch: Throwable -> L71
        AiProactiveAgentBridgeImpl.access$setPendingSpellListeningJob$p(null);     // Catch: Throwable -> L71
    L67:
        Unit r118 = Unit.INSTANCE;     // Catch: Throwable -> L71
        monitor-exit(r116);
        return Unit.INSTANCE;
    L86:
        RunLog.INSTANCE.warn(AiProactiveAgentBridgeImpl.TAG, "ensure ai proactive db for Spell exception", r3);     // Catch: Throwable -> L95
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L95
        Object r9 = AiProactiveAgentBridgeImpl.access$getLock$p();
        monitor-enter(r9);
        if (AiProactiveAgentBridgeImpl.access$getPendingSpellListeningJob$p() != r11.getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"))) goto L92;
        AiProactiveAgentBridgeImpl r120 = AiProactiveAgentBridgeImpl.INSTANCE;
        AiProactiveAgentBridgeImpl.access$setPendingSpellListeningJob$p(null);
    L92:
        Unit r121 = Unit.INSTANCE;
        monitor-exit(r9);
        return r119;
    L8:
        Throwable th = th;
    L121:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L95
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        monitor-enter(AiProactiveAgentBridgeImpl.access$getLock$p());
    L104:
        th = move-exception;
        throw th;
    L99:
        if (AiProactiveAgentBridgeImpl.access$getPendingSpellListeningJob$p() != r11.getCoroutineContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"))) goto L101;
        AiProactiveAgentBridgeImpl r122 = AiProactiveAgentBridgeImpl.INSTANCE;     // Catch: Throwable -> L104
        AiProactiveAgentBridgeImpl.access$setPendingSpellListeningJob$p(null);     // Catch: Throwable -> L104
    L101:
        Unit r123 = Unit.INSTANCE;     // Catch: Throwable -> L104
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r12);
        al r124 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L19
        com.obric.aiproactive.impl.recording.b r21 = com.obric.aiproactive.impl.recording.b.f6506a;     // Catch: Throwable -> L19
        this.L$0 = r124;     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        Object r125 = r21.a(this);     // Catch: Throwable -> L19
        if (r125 != r0) goto L16;
        return r0;
    L16:
        r12 = r125;
        r11 = r124;
    L19:
        th = move-exception;
        th = th;
        r11 = r124;
        goto L121
    }
}
