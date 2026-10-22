package com.obric.memorydata.memory.island.gr;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandSessionUtilsGr$Companion$autoDismiss$2$1$2", f = "IslandSessionUtilsGr.kt", i = {1}, l = {320, 331}, m = "invokeSuspend", n = {"session"}, s = {"L$0"})
final class IslandSessionUtilsGr$Companion$autoDismiss$2$1$2 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    Object L$0;
    int label;

    IslandSessionUtilsGr$Companion$autoDismiss$2$1$2(long r3, Continuation<? super IslandSessionUtilsGr$Companion$autoDismiss$2$1$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$delayMs = r3;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtilsGr$Companion$autoDismiss$2$1$2(this.$delayMs, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtilsGr$Companion$autoDismiss$2$1$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtilsGr$Companion$autoDismiss$2$1$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        IslandSession r12 = (IslandSession) ZeusTransformUtils.preCheckCast(this.L$0, IslandSession.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L13
    L31:
        IslandSession r14 = r12;
    L33:
        RunLog.INSTANCE.debug("IslandSessionUtilsGr", "autoDismiss: destroying session");     // Catch: Exception -> L13
        e.f10211a.a(r14);     // Catch: Exception -> L13
    L38:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L13
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "autoDismiss: delay completed, proceeding to dismiss", false, 4, null);     // Catch: Exception -> L13
        f.a r15 = f.f10213a;     // Catch: Exception -> L13
        f.a("");     // Catch: Exception -> L13
        r14 = (IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.removeLastOrNull(f.e()), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        if (r14 == null) goto L34;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "autoDismiss: removed session: " + r14, false, 4, null);     // Catch: Exception -> L13
        IslandWidget r2 = r14.getExpandWidget();     // Catch: Exception -> L13
        if (r2 == null) goto L24;
        b r3 = r2.getTemplateData();     // Catch: Exception -> L13
    L26:
        if (ZeusTransformUtils.instanceOf(r3, MemoryExpandedTemplate.class) == false) goto L32;
        RunLog.INSTANCE.debug("IslandSessionUtilsGr", "autoDismiss: memory session, calling onDismissCallback");     // Catch: Exception -> L13
        f.a r4 = f.f10213a;     // Catch: Exception -> L13
        this.L$0 = r14;     // Catch: Exception -> L13
        this.label = 2;     // Catch: Exception -> L13
        if (f.a.a(r4, this) != r0) goto L30;
        return r0;
    L30:
        r12 = r14;
        goto L31
    L32:
        RunLog.INSTANCE.debug("IslandSessionUtilsGr", "autoDismiss: calendar/confirm session, skip callback, clearing currentContent");     // Catch: Exception -> L13
        f.a r16 = f.f10213a;     // Catch: Exception -> L13
        f.a(null);     // Catch: Exception -> L13
        goto L33
    L24:
        r3 = null;
        goto L26
    L34:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "autoDismiss: no session to remove!", null, 4, null);     // Catch: Exception -> L13
        goto L38
    L15:
        ResultKt.throwOnFailure(r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "autoDismiss: job started, waiting " + this.$delayMs + "ms", false, 4, null);
        long r6 = this.$delayMs;     // Catch: Exception -> L13
        Continuation r17 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        this.label = 1;     // Catch: Exception -> L13
        if (au.a(r6, r17) != r0) goto L19;
        return r0;
    L13:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtilsGr", "autoDismiss: job error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L38
    }
}
