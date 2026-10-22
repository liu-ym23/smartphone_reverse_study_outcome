package com.bytedance.ai.bridge.method.device.calendar;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.calendar.AbsAddPhoneRepeatCalendarMethodIDL;
import f3.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/calendar/AddPhoneRepeatCalendarMethod;", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneRepeatCalendarMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneRepeatCalendarMethodIDL$AddPhoneRepeatCalendarParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneRepeatCalendarMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddPhoneRepeatCalendarMethod extends AbsAddPhoneRepeatCalendarMethodIDL {
    public AddPhoneRepeatCalendarMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r22, ParamModel r23, h r24) {
        AbsAddPhoneRepeatCalendarMethodIDL.a r0 = (AbsAddPhoneRepeatCalendarMethodIDL.a) r23;
        Intrinsics.checkNotNullParameter(r22, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r24, "callback");
        f.l.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L37
        String r10 = r0.getTitle();     // Catch: Throwable -> L37
        String[] r11 = d.a;     // Catch: Throwable -> L37
        String r12 = StringsKt.trim(r10).toString();     // Catch: Throwable -> L37
        if (r12.length() != 0) goto L6;
        boolean r13 = true;
    L7:
        if (r13 == true) goto L36;
        long r14 = d.c(r0.getStartTime(), r0.getEndTime(), r0.getAlarmOffset());     // Catch: Throwable -> L37
        String r15 = r0.getRepeatInterval();     // Catch: Throwable -> L37
        if (r15 != null) goto L11;
        r15 = "month";
    L11:
        RepeatInterval r19 = d.b(r15);     // Catch: Throwable -> L37
        if (r19 == null) goto L34;
        Long r20 = r0.getRepeatEndTime();     // Catch: Throwable -> L37
        if (r20 != null) goto L16;
    L20:
        long r16 = r0.getStartTime();     // Catch: Throwable -> L37
        Boolean r17 = r0.getAllDay();     // Catch: Throwable -> L37
        if (r17 == null) goto L23;
        boolean r18 = r17.booleanValue();     // Catch: Throwable -> L37
    L24:
        String r110 = r0.getDescription();     // Catch: Throwable -> L37
        String r111 = r0.getLocation();     // Catch: Throwable -> L37
        Boolean r21 = r0.getAlarm();     // Catch: Throwable -> L37
        if (r21 == null) goto L27;
        boolean r112 = r21.booleanValue();     // Catch: Throwable -> L37
    L28:
        Long r25 = r0.getAlarmOffset();     // Catch: Throwable -> L37
        if (r25 == null) goto L31;
        long r26 = r25.longValue();     // Catch: Throwable -> L37
    L32:
        Object r27 = Result.constructor-impl(new f(r12, r16, r18, r110, r111, r14, r112, r26, r0.getPath(), r19, r20));     // Catch: Throwable -> L37
    L39:
        Throwable r28 = Result.exceptionOrNull-impl(r27);
        if (r28 != null) goto L42;
        d.a(r22, (f) r27, true, "addPhoneRepeatCalendar", r24, new e());
        return;
    L42:
        String r29 = r28.getMessage();
        if (r29 != null) goto L45;
        r29 = "The calendar event parameter is invalid.";
    L45:
        h.a.a(r24, r29, null, null, 14);
        return;
    L31:
        r26 = 0;
        goto L32
    L27:
        r112 = true;
        goto L28
    L23:
        r18 = false;
        goto L24
    L16:
        if (r20.longValue() >= r0.getStartTime()) goto L20;
        throw new IllegalArgumentException("The repeatEndTime parameter should not be earlier than startTime.");     // Catch: Throwable -> L37
    L34:
        throw new IllegalArgumentException("The repeatInterval parameter should be one of day, week, month, year.");     // Catch: Throwable -> L37
    L36:
        throw new IllegalArgumentException("The title parameter should not be empty.");     // Catch: Throwable -> L37
    L6:
        r13 = false;
    L37:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }
}
