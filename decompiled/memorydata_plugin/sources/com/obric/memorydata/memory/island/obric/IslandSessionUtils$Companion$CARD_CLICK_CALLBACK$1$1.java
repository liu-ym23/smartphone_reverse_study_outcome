package com.obric.memorydata.memory.island.obric;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.entity.TransitionAnimation;
import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion$CARD_CLICK_CALLBACK$1$1", f = "IslandSessionUtils.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {1883, 132, 135, 140, 1887, 1887}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class IslandSessionUtils$Companion$CARD_CLICK_CALLBACK$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;

    IslandSessionUtils$Companion$CARD_CLICK_CALLBACK$1$1(Continuation<? super IslandSessionUtils$Companion$CARD_CLICK_CALLBACK$1$1> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$CARD_CLICK_CALLBACK$1$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtils$Companion$CARD_CLICK_CALLBACK$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtils$Companion$CARD_CLICK_CALLBACK$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r22) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L24;
            case 1: goto L21;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L12;
            case 5: goto L9;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        th = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r22);     // Catch: Exception -> L74
    L73:
        throw th;     // Catch: Exception -> L74
    L9:
        Unit r0 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r22);     // Catch: Exception -> L74
    L81:
        return Unit.INSTANCE;
    L12:
        CoroutineContext.Element r1 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        o r2 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
    L13:
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L19
    L66:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L19
        Continuation<? super Unit> r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L74
        this.L$0 = r3;     // Catch: Exception -> L74
        this.L$1 = null;     // Catch: Exception -> L74
        this.label = 5;     // Catch: Exception -> L74
        if (r2.b(r1, r4) != r8) goto L81;
        return r8;
    L15:
        r1 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        r2 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        goto L13
    L16:
        r1 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        r2 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r22);     // Catch: Throwable -> L19
    L56:
        CoroutineContext.Element r12 = r1;
        o r13 = r2;
        IslandSessionUtils.Companion r5 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L61
        this.L$0 = r13;     // Catch: Throwable -> L61
        this.L$1 = r12;     // Catch: Throwable -> L61
        this.label = 3;     // Catch: Throwable -> L61
        if (IslandSessionUtils.Companion.a(r5, 0, this, 1, null) != r8) goto L60;
        return r8;
    L60:
        r1 = r12;
        r2 = r13;
    L61:
        th = th;
        r1 = r12;
        r2 = r13;
    L70:
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L74
        this.L$0 = th;     // Catch: Exception -> L74
        this.L$1 = null;     // Catch: Exception -> L74
        this.label = 6;     // Catch: Exception -> L74
        if (r2.b(r1, r6) != r8) goto L73;
        return r8;
    L21:
        CoroutineContext.Element r7 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        o r9 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r22);     // Catch: Exception -> L74
        r2 = r9;
        r1 = r7;
    L29:
        IslandSessionUtils.Companion.b r14 = IslandSessionUtils.i();     // Catch: Throwable -> L19
        if (r14 == null) goto L32;
        IslandSessionUtils.Companion.b r10 = IslandSessionUtils.Companion.b.a(r14, null, null, null, null, null, false, 63, null);     // Catch: Throwable -> L19
    L33:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "card click callback ...", false, 4, null);     // Catch: Throwable -> L19
        RunLog r11 = RunLog.INSTANCE;     // Catch: Throwable -> L19
        StringBuilder r15 = new StringBuilder().append("click content is title: ");     // Catch: Throwable -> L19
        if (r10 == null) goto L36;
        String r16 = r10.b();     // Catch: Throwable -> L19
    L37:
        StringBuilder r17 = r15.append(r16).append(", content: ");     // Catch: Throwable -> L19
        if (r10 == null) goto L40;
        String r18 = r10.c();     // Catch: Throwable -> L19
    L41:
        StringBuilder r19 = r17.append(r18).append(", logId: ");     // Catch: Throwable -> L19
        if (r10 == null) goto L46;
        MemoryEntity r20 = r10.a();     // Catch: Throwable -> L19
        if (r20 == null) goto L46;
        String r21 = r20.getLogId();     // Catch: Throwable -> L19
    L47:
        r11.debug("IslandSessionUtils", r19.append(r21).append(" ...").toString());     // Catch: Throwable -> L19
        if (r10 != null) goto L63;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "currentContentSnapshot is null ...", false, 4, null);     // Catch: Throwable -> L19
        IslandSession r23 = (IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(IslandSessionUtils.h()), IslandSession.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r23 == null) goto L56;
        IslandWidget r24 = r23.getCollapseWidget();     // Catch: Throwable -> L19
        if (r24 == null) goto L56;
        r24.setInAnimation(CollectionsKt.listOf(TransitionAnimation.VIBRATE));     // Catch: Throwable -> L19
        this.L$0 = r2;     // Catch: Throwable -> L19
        this.L$1 = r1;     // Catch: Throwable -> L19
        this.label = 2;     // Catch: Throwable -> L19
        if (r23.updateAnimation(r24, this) != r8) goto L56;
        return r8;
    L63:
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r10);     // Catch: Throwable -> L19
        IslandSessionUtils.Companion r25 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L19
        IslandSessionUtils.a(null);     // Catch: Throwable -> L19
        IslandSessionUtils.Companion r26 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L19
        this.L$0 = r2;     // Catch: Throwable -> L19
        this.L$1 = r1;     // Catch: Throwable -> L19
        this.label = 4;     // Catch: Throwable -> L19
        if (r26.a(0, this) != r8) goto L66;
        return r8;
    L46:
        r21 = null;
        goto L47
    L40:
        r18 = null;
        goto L41
    L36:
        r16 = null;
        goto L37
    L32:
        r10 = null;
        goto L33
    L24:
        ResultKt.throwOnFailure(r22);
        o r27 = IslandSessionUtils.c();     // Catch: Exception -> L74
        r1 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L74
        Continuation<? super Unit> r28 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L74
        this.L$0 = r27;     // Catch: Exception -> L74
        this.L$1 = r1;     // Catch: Exception -> L74
        this.label = 1;     // Catch: Exception -> L74
        if (r27.a(r1, r28) != r8) goto L28;
        return r8;
    L28:
        r2 = r27;
        goto L29
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        th = th;
    L74:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtils", "Error in card click callback: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        IslandSessionUtils.Companion r29 = IslandSessionUtils.f10217a;     // Catch: Exception -> L78
        IslandSessionUtils.a(null);     // Catch: Exception -> L78
        IslandSessionUtils.Companion r30 = IslandSessionUtils.f10217a;     // Catch: Exception -> L78
        IslandSessionUtils.a("");     // Catch: Exception -> L78
        IslandSessionUtils.Companion r31 = IslandSessionUtils.f10217a;     // Catch: Exception -> L78
        IslandSessionUtils.a(null);     // Catch: Exception -> L78
    L78:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtils", "Error during cleanup: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L81
    }
}
