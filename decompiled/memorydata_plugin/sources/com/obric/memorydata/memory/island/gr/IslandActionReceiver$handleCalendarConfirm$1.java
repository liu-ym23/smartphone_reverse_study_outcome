package com.obric.memorydata.memory.island.gr;

import android.content.Context;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandActionReceiver$handleCalendarConfirm$1", f = "IslandActionReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IslandActionReceiver$handleCalendarConfirm$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ IslandActionReceiver this$0;

    IslandActionReceiver$handleCalendarConfirm$1(Context r3, IslandActionReceiver r4, Continuation<? super IslandActionReceiver$handleCalendarConfirm$1> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.this$0 = r4;
        super(2, r7);
    }

    private static final Unit invokeSuspend$lambda$2(IslandActionReceiver r9, PendingMemoryCalendar r10, a.C0501a r11) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCalendarConfirm: writeSingleEventWithPermission callback: isSuccess=" + r11.b() + ", eventId=" + r11.c() + ", error=" + r11.d(), false, 4, null);
        if (r11.b() == false) goto L5;
        i.a(IslandActionReceiver.a(r9), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleCalendarConfirm$1$2$1(r11, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L7:
        return Unit.INSTANCE;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCalendarConfirm: write event failed: " + r11.d(), null, 4, null);
        goto L7
    }

    /* JADX INFO: renamed from: lambda$JqMP1Q-LYN-ZMhVnYIa6B2Lp0ac, reason: not valid java name */
    public static /* synthetic */ Unit m715lambda$JqMP1QLYNZMhVnYIa6B2Lp0ac(IslandActionReceiver r0, PendingMemoryCalendar r1, a.C0501a r2) {
        return invokeSuspend$lambda$2(r0, r1, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandActionReceiver$handleCalendarConfirm$1(this.$context, this.this$0, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandActionReceiver$handleCalendarConfirm$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandActionReceiver$handleCalendarConfirm$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L58;
        ResultKt.throwOnFailure(r18);
        f.a.C0502a r3 = f.f10213a.c();     // Catch: Exception -> L53
        RunLog r4 = RunLog.INSTANCE;     // Catch: Exception -> L53
        StringBuilder r5 = new StringBuilder().append("handleCalendarConfirm: currentContent=");     // Catch: Exception -> L53
        if (r3 == null) goto L8;
        String r6 = "exists";
    L9:
        StringBuilder r7 = r5.append(r6).append(", calendars count=");     // Catch: Exception -> L53
        if (r3 == null) goto L14;
        List<PendingMemoryCalendar> r8 = r3.d();     // Catch: Exception -> L53
        if (r8 == null) goto L14;
        int r9 = r8.size();     // Catch: Exception -> L53
    L15:
        r4.debug("IslandActionReceiver", r7.append(r9).toString());     // Catch: Exception -> L53
        PendingMemoryCalendar r10 = null;
        if (r3 == null) goto L18;
        List<PendingMemoryCalendar> r11 = r3.d();     // Catch: Exception -> L53
    L19:
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(r11, Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
        if (r12 != null) goto L22;
    L25:
        boolean r13 = true;
    L26:
        if (r13 == false) goto L29;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCalendarConfirm: no calendars in currentContent", null, 4, null);     // Catch: Exception -> L53
        return Unit.INSTANCE;
    L29:
        Intrinsics.checkNotNull(r3);     // Catch: Exception -> L53
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r3.d(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Exception -> L53
        int r15 = 0;
    L32:
        if (r14.hasNext() == false) goto L41;
        Object r16 = r14.next();     // Catch: Exception -> L53
        int r17 = r15 + 1;     // Catch: Exception -> L53
        if (r15 >= 0) goto L36;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L53
    L36:
        PendingMemoryCalendar r19 = (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r16, PendingMemoryCalendar.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
        boolean r110 = a.f10204a.a(r19);     // Catch: Exception -> L53
        RunLog r111 = RunLog.INSTANCE;     // Catch: Exception -> L53
        StringBuilder r20 = new StringBuilder().append("handleCalendarConfirm: calendar[").append(r15).append("] title=").append(r19.getTitle()).append(", type=").append(r19.getEventType()).append(", shouldInclude=");     // Catch: Exception -> L53
        if (r110 == false) goto L39;
        boolean r21 = true;
    L40:
        r111.debug("IslandActionReceiver", r20.append(r21).toString());     // Catch: Exception -> L53
        r15 = r17;
        goto L32
    L39:
        r21 = false;
        goto L40
    L41:
        List<PendingMemoryCalendar> r22 = r3.d();     // Catch: Exception -> L53
        ListIterator<PendingMemoryCalendar> r23 = r22.listIterator(r22.size());     // Catch: Exception -> L53
    L43:
        if (r23.hasPrevious() == false) goto L47;
        PendingMemoryCalendar r24 = r23.previous();     // Catch: Exception -> L53
        if (a.f10204a.a((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r24, PendingMemoryCalendar.class, "com.obric.memorydata.plugin")) == false) goto L43;
        r10 = r24;
    L47:
        final PendingMemoryCalendar r25 = (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r10, PendingMemoryCalendar.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L53
        if (r25 != null) goto L51;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCalendarConfirm: no includable calendarItem found after filtering (total=" + r3.d().size() + ", filterTodo=" + a.f10204a.a() + ')', null, 4, null);     // Catch: Exception -> L53
        return Unit.INSTANCE;
    L51:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandActionReceiver", "handleCalendarConfirm: writing calendarItem: title=" + r25.getTitle() + ", type=" + r25.getEventType() + ", dtstart=" + r25.getDtstart() + ", dtend=" + r25.getDtend(), false, 4, null);     // Catch: Exception -> L53
        a r26 = a.f10204a;     // Catch: Exception -> L53
        Context r27 = this.$context;     // Catch: Exception -> L53
        final IslandActionReceiver r0 = this.this$0;     // Catch: Exception -> L53
        r26.a(r27, r25, new $$Lambda$IslandActionReceiver$handleCalendarConfirm$1$JqMP1QLYNZMhVnYIa6B2Lp0ac(r0, r25));     // Catch: Exception -> L53
    L56:
        return Unit.INSTANCE;
    L22:
        if (r12.isEmpty() == true) goto L25;
        r13 = false;
        goto L26
    L18:
        r11 = null;
    L14:
        r9 = 0;
        goto L15
    L8:
        r6 = "null";
    L53:
        e = move-exception;
        RunLog.INSTANCE.error("IslandActionReceiver", "handleCalendarConfirm: unexpected error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L56
    L58:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
