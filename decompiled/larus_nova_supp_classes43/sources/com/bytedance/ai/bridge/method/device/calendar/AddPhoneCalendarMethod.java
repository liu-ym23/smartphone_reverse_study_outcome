package com.bytedance.ai.bridge.method.device.calendar;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.calendar.AbsAddPhoneCalendarMethodIDL;
import f3.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/calendar/AddPhoneCalendarMethod;", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneCalendarMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneCalendarMethodIDL$AddPhoneCalendarParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/calendar/AbsAddPhoneCalendarMethodIDL$EmptyMessageModel;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AddPhoneCalendarMethod extends AbsAddPhoneCalendarMethodIDL {
    public AddPhoneCalendarMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r22, ParamModel r23, h r24) {
        AbsAddPhoneCalendarMethodIDL.a r0 = (AbsAddPhoneCalendarMethodIDL.a) r23;
        Intrinsics.checkNotNullParameter(r22, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r24, "callback");
        f.l.getClass();
        Intrinsics.checkNotNullParameter(r0, "params");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L23
        String r10 = r0.getTitle();     // Catch: Throwable -> L23
        String[] r11 = d.a;     // Catch: Throwable -> L23
        String r12 = StringsKt.trim(r10).toString();     // Catch: Throwable -> L23
        if (r12.length() != 0) goto L6;
        boolean r13 = true;
    L7:
        if (r13 == true) goto L22;
        long r14 = d.c(r0.getStartTime(), r0.getEndTime(), r0.getAlarmOffset());     // Catch: Throwable -> L23
        long r15 = r0.getStartTime();     // Catch: Throwable -> L23
        Boolean r16 = r0.getAllDay();     // Catch: Throwable -> L23
        if (r16 == null) goto L11;
        boolean r17 = r16.booleanValue();     // Catch: Throwable -> L23
    L12:
        String r18 = r0.getDescription();     // Catch: Throwable -> L23
        String r19 = r0.getLocation();     // Catch: Throwable -> L23
        Boolean r20 = r0.getAlarm();     // Catch: Throwable -> L23
        if (r20 == null) goto L15;
        boolean r110 = r20.booleanValue();     // Catch: Throwable -> L23
    L16:
        Long r21 = r0.getAlarmOffset();     // Catch: Throwable -> L23
        if (r21 == null) goto L19;
        long r25 = r21.longValue();     // Catch: Throwable -> L23
    L20:
        Object r26 = Result.constructor-impl(new f(r12, r15, r17, r18, r19, r14, r110, r25, r0.getPath(), null, null));     // Catch: Throwable -> L23
    L25:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 != null) goto L28;
        d.a(r22, (f) r26, false, "addPhoneCalendar", r24, new a());
        return;
    L28:
        String r28 = r27.getMessage();
        if (r28 != null) goto L31;
        r28 = "The calendar event parameter is invalid.";
    L31:
        h.a.a(r24, r28, null, null, 14);
        return;
    L19:
        r25 = 0;
        goto L20
    L15:
        r110 = true;
        goto L16
    L11:
        r17 = false;
        goto L12
    L22:
        throw new IllegalArgumentException("The title parameter should not be empty.");     // Catch: Throwable -> L23
    L6:
        r13 = false;
    L23:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    }
}
