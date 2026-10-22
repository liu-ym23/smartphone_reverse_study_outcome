package com.obric.memorydata.memory.island.obric;

import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.island.IslandApi;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion$autoDismiss$2$1$1", f = "IslandSessionUtils.kt", i = {}, l = {1047, 1055}, m = "invokeSuspend", n = {}, s = {})
final class IslandSessionUtils$Companion$autoDismiss$2$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMs;
    final /* synthetic */ IslandSession $it;
    final /* synthetic */ long $remainingDelay;
    Object L$0;
    int label;

    IslandSessionUtils$Companion$autoDismiss$2$1$1(long r3, long r5, IslandSession r7, Continuation<? super IslandSessionUtils$Companion$autoDismiss$2$1$1> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$delayMs = r3;
        this.$remainingDelay = r5;
        this.$it = r7;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$autoDismiss$2$1$1(this.$delayMs, this.$remainingDelay, this.$it, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtils$Companion$autoDismiss$2$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtils$Companion$autoDismiss$2$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
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
    L27:
        IslandSession r2 = r12;
    L28:
        IslandApi r14 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Exception -> L13
        if (r14 == null) goto L34;
        r14.destroySession(r2);     // Catch: Exception -> L13
    L34:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L13
    L19:
        IslandSessionUtils.Companion r15 = IslandSessionUtils.f10217a;     // Catch: Exception -> L13
        IslandSessionUtils.a("");     // Catch: Exception -> L13
        IslandSessionUtils.Companion r16 = IslandSessionUtils.f10217a;     // Catch: Exception -> L13
        IslandSessionUtils.a(null);     // Catch: Exception -> L13
        IslandSession r17 = (IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.removeLastOrNull(IslandSessionUtils.h()), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        if (r17 == null) goto L34;
        r2 = this.$it;     // Catch: Exception -> L13
        RunLog.INSTANCE.debug("IslandSessionUtils", "session: " + r17);     // Catch: Exception -> L13
        if (r17.getCollapseWidget() == null) goto L28;
        Function1 r18 = IslandSessionUtils.k();     // Catch: Exception -> L13
        this.L$0 = r2;     // Catch: Exception -> L13
        this.label = 2;     // Catch: Exception -> L13
        if (r18.invoke(this) != r0) goto L26;
        return r0;
    L26:
        r12 = r2;
        goto L27
    L15:
        ResultKt.throwOnFailure(r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "autoDismiss delayMs: " + this.$delayMs, false, 4, null);
        long r6 = this.$remainingDelay;     // Catch: Exception -> L13
        Continuation r19 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L13
        this.label = 1;     // Catch: Exception -> L13
        if (au.a(r6, r19) != r0) goto L19;
        return r0;
    L13:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtils", "Error in autoDismiss delay: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L34
    }
}
