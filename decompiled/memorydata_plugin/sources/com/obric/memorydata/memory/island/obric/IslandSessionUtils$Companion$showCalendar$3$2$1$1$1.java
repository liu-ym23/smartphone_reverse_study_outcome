package com.obric.memorydata.memory.island.obric;

import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.island.IslandApi;
import com.obric.memorydata.memory.calendar.a;
import com.obric.memorydata.memory.provider.b;
import com.obric.memorydata.memory.utils.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion$showCalendar$3$2$1$1$1", f = "IslandSessionUtils.kt", i = {0, 0}, l = {1883, 1887, 1887}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "actualOwner$iv"}, s = {"L$0", "L$3"})
final class IslandSessionUtils$Companion$showCalendar$3$2$1$1$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ IslandSession $confirmSession;
    final /* synthetic */ a $result;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    IslandSessionUtils$Companion$showCalendar$3$2$1$1$1(IslandSession r3, a r4, Continuation<? super IslandSessionUtils$Companion$showCalendar$3$2$1$1$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$confirmSession = r3;
        this.$result = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showCalendar$3$2$1$1$1(this.$confirmSession, this.$result, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtils$Companion$showCalendar$3$2$1$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtils$Companion$showCalendar$3$2$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L8;
        Throwable r10 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
        throw r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Unit r12 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L28:
        return Unit.INSTANCE;
    L11:
        CoroutineContext.Element r2 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.L$2, a.class, "com.obric.memorydata.plugin");
        IslandSession r6 = (IslandSession) ZeusTransformUtils.preCheckCast(this.L$1, IslandSession.class, "com.obric.memorydata.plugin");
        o r7 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L35:
        IslandSessionUtils.h().remove(r6);     // Catch: Throwable -> L29
        IslandApi r8 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L29
        if (r8 == null) goto L20;
        r8.destroySession(r6);     // Catch: Throwable -> L29
    L20:
        String r5 = r4.b();     // Catch: Throwable -> L29
        if (r5 == null) goto L23;
        b.f10359a.a(r5);     // Catch: Throwable -> L29
    L23:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L29
        Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r3;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 2;
        if (r7.b(r2, r9) != r0) goto L28;
        return r0;
    L29:
        th = move-exception;
        Continuation<? super Unit> r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = th;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 3;
        if (r7.b(r2, r13) != r0) goto L34;
        return r0;
    L34:
        throw th;
    L12:
        ResultKt.throwOnFailure(r11);
        r7 = IslandSessionUtils.c();
        r6 = this.$confirmSession;
        a r14 = this.$result;
        r2 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r7;
        this.L$1 = r6;
        this.L$2 = r14;
        this.L$3 = r2;
        this.label = 1;
        if (r7.a(r2, r15) != r0) goto L15;
        return r0;
    L15:
        r4 = r14;
        goto L35
    }
}
