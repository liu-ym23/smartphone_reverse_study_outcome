package com.obric.aiproactive.impl.livecard;

import com.obric.livecard.api.entity.IslandSession;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiproactive.impl.livecard.ProactiveLiveCardManager$markAsProcessed$1", f = "ProactiveLiveCardManager.kt", i = {0}, l = {1478}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class ProactiveLiveCardManager$markAsProcessed$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $feedbackAction;
    final /* synthetic */ String $recommendId;
    Object L$0;
    Object L$1;
    int label;

    ProactiveLiveCardManager$markAsProcessed$1(String r3, String r4, Continuation<? super ProactiveLiveCardManager$markAsProcessed$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$recommendId = r3;
        this.$feedbackAction = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ProactiveLiveCardManager$markAsProcessed$1(this.$recommendId, this.$feedbackAction, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ProactiveLiveCardManager$markAsProcessed$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ProactiveLiveCardManager$markAsProcessed$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.sync.a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r8);
    L31:
        IslandSession r9 = (IslandSession) ZeusTransformUtils.preCheckCast(n.b().get(r2), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r9 != null) goto L15;
    L21:
        r9 = null;
    L22:
        r3.b(null);
        if (r9 == null) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveLiveCardManager", "Destroying processed recommendation on lock screen: " + this.$recommendId + " action=" + this.$feedbackAction, false, 4, null);
        ProactiveLiveCardDisplayTool.INSTANCE.destroySession(r9);
        return Unit.INSTANCE;
    L25:
        return Unit.INSTANCE;
    L15:
        if (n.c().contains(r2) == true) goto L21;
        n.c().add(r2);     // Catch: Throwable -> L28
        n.a(n.f6478a, r2);     // Catch: Throwable -> L28
        l.f6475a.a(r2);     // Catch: Throwable -> L28
        IslandSession r4 = (IslandSession) ZeusTransformUtils.preCheckCast(n.b().remove(r2), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r4 == null) goto L22;
        r9 = r4;
    L28:
        th = move-exception;
        r3.b(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        r3 = n.a();
        String r10 = this.$recommendId;
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r3;
        this.L$1 = r10;
        this.label = 1;
        if (r3.a(null, r5) != r0) goto L11;
        return r0;
    L11:
        r2 = r10;
        goto L31
    }
}
