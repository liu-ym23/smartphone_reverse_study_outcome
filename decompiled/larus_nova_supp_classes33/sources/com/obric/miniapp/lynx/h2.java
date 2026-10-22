package com.obric.miniapp.lynx;

import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.oui.calendar.ODatePickerView;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class h2 implements Function1 {
    public final /* synthetic */ LynxOUIDatePickerViewUI a;
    public final /* synthetic */ ODatePickerView b;

    public /* synthetic */ h2(LynxOUIDatePickerViewUI r1, ODatePickerView r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke(Object r7) {
        LynxOUIDatePickerViewUI r0 = this.a;
        ODatePickerView r1 = this.b;
        long r2 = ((Long) r7).longValue();
        if (r0.c == true) goto L19;
        long r4 = r0.P(r2);
        if (r4 == r2) goto L8;
        r0.c = true;
        r1.setCurrentTimeMillis(r4);
        r0.c = false;
    L8:
        LocalDate r8 = Instant.ofEpochMilli(r4).atZone(ZoneId.systemDefault()).toLocalDate();
        if (Intrinsics.areEqual(r0.g, r8) == true) goto L20;
        r0.g = r8;
        r0.h = Long.valueOf(r4);
        Intrinsics.checkNotNull(r8);
        LynxContext r3 = r0.getLynxContext();
        if (r3 == null) goto L18;
        EventEmitter r5 = r3.getEventEmitter();
        if (r5 == null) goto L18;
        m7a.a r6 = new m7a.a(r0.getSign(), "change");
        String r9 = r8.toString();
        long r10 = r8.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        r6.a("date", r9);
        r6.a("value", r9);
        r6.a("timestamp", Long.valueOf(r10));
        r6.a("year", Integer.valueOf(r8.getYear()));
        r6.a("month", Integer.valueOf(r8.getMonthValue()));
        r6.a("day", Integer.valueOf(r8.getDayOfMonth()));
        r5.sendCustomEvent(r6);
    L18:
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L19:
        return Unit.INSTANCE;
    }
}
