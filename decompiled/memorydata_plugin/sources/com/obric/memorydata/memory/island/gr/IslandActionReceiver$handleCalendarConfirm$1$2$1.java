package com.obric.memorydata.memory.island.gr;

import com.obric.memorydata.database.entity.PendingMemoryCalendar;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandActionReceiver$handleCalendarConfirm$1$2$1", f = "IslandActionReceiver.kt", i = {}, l = {183, 185}, m = "invokeSuspend", n = {}, s = {})
final class IslandActionReceiver$handleCalendarConfirm$1$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ PendingMemoryCalendar $calendarItem;
    final /* synthetic */ a.C0501a $result;
    int label;

    IslandActionReceiver$handleCalendarConfirm$1$2$1(a.C0501a r3, PendingMemoryCalendar r4, Continuation<? super IslandActionReceiver$handleCalendarConfirm$1$2$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$result = r3;
        this.$calendarItem = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleCalendarConfirm$1$2$1(this.$result, this.$calendarItem, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandActionReceiver$handleCalendarConfirm$1$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandActionReceiver$handleCalendarConfirm$1$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L12
    L27:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L12
    L22:
        RunLog.INSTANCE.debug("IslandActionReceiver", "handleCalendarConfirm: showCalendarConfirm done, calling autoDismiss");     // Catch: Exception -> L12
        f.a r6 = f.f10213a;     // Catch: Exception -> L12
        Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        this.label = 2;     // Catch: Exception -> L12
        if (f.a.a(r6, 0, r9, 1, null) != r0) goto L27;
        return r0;
    L14:
        ResultKt.throwOnFailure(r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCalendarConfirm: write success, showing confirm card, eventId=" + this.$result.c(), false, 4, null);     // Catch: Exception -> L12
        f.a r14 = f.f10213a;     // Catch: Exception -> L12
        PendingMemoryCalendar r2 = this.$calendarItem;     // Catch: Exception -> L12
        Long r7 = this.$result.c();     // Catch: Exception -> L12
        if (r7 == null) goto L18;
        String r8 = r7.toString();     // Catch: Exception -> L12
    L19:
        Continuation<? super Unit> r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L12
        this.label = 1;     // Catch: Exception -> L12
        if (r14.a(r2, r8, r10) != r0) goto L22;
        return r0;
    L18:
        r8 = null;
    L12:
        e = move-exception;
        RunLog.INSTANCE.error("IslandActionReceiver", "handleCalendarConfirm: error showing confirm card: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L27
    }
}
