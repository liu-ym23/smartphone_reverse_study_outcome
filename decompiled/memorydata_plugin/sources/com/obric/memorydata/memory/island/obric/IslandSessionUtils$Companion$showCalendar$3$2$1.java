package com.obric.memorydata.memory.island.obric;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.Icon;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.utils.ResourceUtils;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.calendar.a;
import com.obric.memorydata.memory.calendar.b;
import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion$showCalendar$3$2$1", f = "IslandSessionUtils.kt", i = {0, 0, 0, 1, 1}, l = {1883, 1223, 1887, 1887}, m = "invokeSuspend", n = {"confirmSession", "$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1"})
final class IslandSessionUtils$Companion$showCalendar$3$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ IslandSession $calendarSession;
    final /* synthetic */ PendingMemoryCalendar $currentCalendarItem;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    IslandSessionUtils$Companion$showCalendar$3$2$1(PendingMemoryCalendar r3, IslandSession r4, Continuation<? super IslandSessionUtils$Companion$showCalendar$3$2$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$currentCalendarItem = r3;
        this.$calendarSession = r4;
        super(2, r6);
    }

    private static final Unit invokeSuspend$lambda$0(IslandSession r10, a r11) {
        RunLog.INSTANCE.debug("IslandSessionUtils", "点击了添加到日程后的卡片");
        i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showCalendar$3$2$1$1$1(r10, r11, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Exception -> L5
    L8:
        return Unit.INSTANCE;
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtils", "Error handling confirm click: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L8
    }

    public static /* synthetic */ Unit lambda$7QtV5wykDKDJBLCVdiR0zZHUix4(IslandSession r0, a r1) {
        return invokeSuspend$lambda$0(r0, r1);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showCalendar$3$2$1(this.$currentCalendarItem, this.$calendarSession, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtils$Companion$showCalendar$3$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtils$Companion$showCalendar$3$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r42) {
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L24;
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L16;
        if (r0 == 3) goto L13;
        if (r0 != 4) goto L9;
        th = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r42);     // Catch: Exception -> L60
    L59:
        throw th;     // Catch: Exception -> L60
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Unit r1 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r42);     // Catch: Exception -> L60
    L63:
        return Unit.INSTANCE;
    L16:
        CoroutineContext.Element r2 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        o r3 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r42);     // Catch: Throwable -> L19
    L50:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L19
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L60
        this.L$0 = r4;     // Catch: Exception -> L60
        this.L$1 = null;     // Catch: Exception -> L60
        this.label = 3;     // Catch: Exception -> L60
        if (r3.b(r2, r5) != r8) goto L63;
        return r8;
    L19:
        th = th;
    L56:
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L60
        this.L$0 = th;     // Catch: Exception -> L60
        this.L$1 = null;     // Catch: Exception -> L60
        this.L$2 = null;     // Catch: Exception -> L60
        this.L$3 = null;     // Catch: Exception -> L60
        this.label = 4;     // Catch: Exception -> L60
        if (r3.b(r2, r6) != r8) goto L59;
        return r8;
    L21:
        CoroutineContext.Element r7 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        IslandSession r9 = (IslandSession) ZeusTransformUtils.preCheckCast(this.L$2, IslandSession.class, "com.obric.memorydata.plugin");
        o r10 = (o) ZeusTransformUtils.preCheckCast(this.L$1, o.class, "com.obric.memorydata.plugin");
        final IslandSession r11 = (IslandSession) ZeusTransformUtils.preCheckCast(this.L$0, IslandSession.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r42);     // Catch: Exception -> L60
        CoroutineContext.Element r12 = r7;
        o r13 = r10;
    L64:
        IslandSessionUtils.h().add(r11);     // Catch: Throwable -> L54
        IslandApi r14 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L54
        if (r14 == null) goto L43;
        Boxing.boxBoolean(r14.createSession(r11, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L54
    L43:
        IslandSessionUtils.h().remove(r9);     // Catch: Throwable -> L54
        IslandApi r15 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L54
        if (r15 == null) goto L46;
        r15.destroySession(r9);     // Catch: Throwable -> L54
    L46:
        IslandSessionUtils.Companion r16 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L54
        this.L$0 = r13;     // Catch: Throwable -> L54
        this.L$1 = r12;     // Catch: Throwable -> L54
        this.L$2 = null;     // Catch: Throwable -> L54
        this.L$3 = null;     // Catch: Throwable -> L54
        this.label = 2;     // Catch: Throwable -> L54
        if (IslandSessionUtils.Companion.a(r16, 0, this, 1, null) != r8) goto L49;
        return r8;
    L49:
        r2 = r12;
        r3 = r13;
    L54:
        th = th;
        r2 = r12;
        r3 = r13;
        goto L56
    L24:
        ResultKt.throwOnFailure(r42);
        final a r17 = b.f10085a.a(this.$currentCalendarItem, true);     // Catch: Exception -> L60
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtils", "writeToCalendarApp result: " + r17, false, 4, null);     // Catch: Exception -> L60
        if (r17.a() == false) goto L63;
        List r18 = CollectionsKt.listOf(IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, 40, 40, ResourceUtils.INSTANCE.getAssetsFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "ic_memory_success.svg", "svg"), null, IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a), "svg:correct_cycle_light", 8, null));     // Catch: Exception -> L60
        LiveCardType r26 = LiveCardType.MEMORY_DATA;     // Catch: Exception -> L60
        IslandSessionUtils.Companion r19 = IslandSessionUtils.f10217a;     // Catch: Exception -> L60
        Icon r110 = new Icon(40, 40, ResourceUtils.INSTANCE.getApplicationIcon("com.larus.nova/calendar") + "&timestamp=" + System.currentTimeMillis(), null, null, null, null, false, null, null, null, 2040, null);     // Catch: Exception -> L60
        IslandSessionUtils.Companion r20 = IslandSessionUtils.f10217a;     // Catch: Exception -> L60
        Context r21 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L60
        if (Intrinsics.areEqual(this.$currentCalendarItem.getEventType(), PendingMemoryCalendar.TYPE_EVENT) == false) goto L32;
        int r22 = R.string.memory_island_event_added_to_calendar;     // Catch: Exception -> L60
        String r111 = "memory_island_event_added_to_calendar";
    L33:
        String r23 = r21.getString(ZeusTransformUtils.mapRes(r22, TypedValues.Custom.S_STRING, r111));     // Catch: Exception -> L60
        Intrinsics.checkNotNullExpressionValue(r23, "getString(...)");     // Catch: Exception -> L60
        r11 = new IslandSession(null, IslandSessionUtils.Companion.a(r19, IslandSessionUtils.Companion.a(r20, r23, 14, ZeusTransformUtils.mapRes(R.color.oui_on_accent_text_1, TypedValues.Custom.S_COLOR, "oui_on_accent_text_1"), IslandSessionUtils.Companion.MemoryIslandTextColor.PRIMARY), r18, r110, null, null, 24, null).create(Boxing.boxBoolean(true)), null, null, null, null, null, 0, r26, null, Boxing.boxBoolean(true), null, 1025, null, null, null, 0, 125693, null);     // Catch: Exception -> L60
        IslandWidget r24 = r11.getExpandWidget();     // Catch: Exception -> L60
        if (r24 == null) goto L36;
        r24.setOnCardClickCallback(new $$Lambda$IslandSessionUtils$Companion$showCalendar$3$2$1$7QtV5wykDKDJBLCVdiR0zZHUix4(r11, r17));     // Catch: Exception -> L60
    L36:
        o r25 = IslandSessionUtils.c();     // Catch: Exception -> L60
        IslandSession r27 = this.$calendarSession;     // Catch: Exception -> L60
        CoroutineContext.Element r28 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L60
        Continuation<? super Unit> r29 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L60
        this.L$0 = r11;     // Catch: Exception -> L60
        this.L$1 = r25;     // Catch: Exception -> L60
        this.L$2 = r27;     // Catch: Exception -> L60
        this.L$3 = r28;     // Catch: Exception -> L60
        this.label = 1;     // Catch: Exception -> L60
        if (r25.a(r28, r29) != r8) goto L39;
        return r8;
    L39:
        r13 = r25;
        r9 = r27;
        r12 = r28;
        goto L64
    L32:
        r22 = R.string.memory_island_todo_added_to_calendar;     // Catch: Exception -> L60
        r111 = "memory_island_todo_added_to_calendar";
    L60:
        e = move-exception;
        RunLog.INSTANCE.error("IslandSessionUtils", "Error adding to calendar: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L63
    }
}
