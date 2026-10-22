package com.bytedance.ai.bridge.method.device.calendar;

import android.content.Context;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.timon.calendar.EventRecord;
import com.bytedance.timon.calendar.ResultCode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/bridge/method/device/calendar/CalendarWriteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.device.calendar.AddPhoneCalendarMethodKt$insertOrUpdateCalendarEvent$2", f = "AddPhoneCalendarMethod.kt", i = {0}, l = {447}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
final class AddPhoneCalendarMethodKt$insertOrUpdateCalendarEvent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ EventRecord $event;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public static final class a implements com.bytedance.timon.calendar.a {
        public final /* synthetic */ i<g> a;

        public a(j r1) {
            this.a = r1;
        }

        public final void a(boolean r10, ResultCode r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "errorCode");
            Intrinsics.checkNotNullParameter(r12, MessageIndication.MESSAGE_TYPE_MSG);
            if (this.a.isActive() == false) goto L6;
            i<g> r0 = this.a;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(new g(r10, r11, r12)));
            return;
        }
    }

    public AddPhoneCalendarMethodKt$insertOrUpdateCalendarEvent$2(Context r1, EventRecord r10, Continuation<? super AddPhoneCalendarMethodKt$insertOrUpdateCalendarEvent$2> r11) {
        this.$context = r1;
        this.$event = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AddPhoneCalendarMethodKt$insertOrUpdateCalendarEvent$2 r0 = new AddPhoneCalendarMethodKt$insertOrUpdateCalendarEvent$2(this.$context, this.$event, r11);
        r0.L$0 = r10;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super g> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        EventRecord r11 = (EventRecord) this.L$2;
        Context r12 = (Context) this.L$1;
        CoroutineScope r13 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L26:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        Context r15 = this.$context;
        EventRecord r16 = this.$event;
        this.L$0 = r14;
        this.L$1 = r15;
        this.L$2 = r16;
        this.label = 1;
        j r17 = new j(IntrinsicsKt.intercepted(this), 1);
        r17.C();
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L11
        com.bytedance.timon.calendar.c.c(r15, r16, new a(r17));     // Catch: Throwable -> L11
        Object r19 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 != null) goto L16;
    L21:
        r10 = r17.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(this);
    L24:
        if (r10 != r0) goto L26;
        return r0;
    L16:
        if (r17.isActive() == false) goto L21;
        ResultCode r21 = ResultCode.Unknown;
        String r22 = r20.getMessage();
        if (r22 != null) goto L20;
        r22 = "unknown error";
    L20:
        r17.resumeWith(Result.constructor-impl(new g(false, r21, r22)));
    L11:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
