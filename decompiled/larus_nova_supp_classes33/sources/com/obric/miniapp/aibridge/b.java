package com.obric.miniapp.aibridge;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ f3.h a;

    public /* synthetic */ b(f3.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        f3.h r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        FLogger.a.d("DeleteAlarmMethod", "deleteAlarm result: " + r6);
        if (r6 == false) goto L5;
        Intrinsics.checkNotNullParameter(AbsDeleteAlarmMethodIDL.b.class, "<this>");
        f3.h.a.b(r0, k3.c.a(AbsDeleteAlarmMethodIDL.b.class));
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(r0, "Set AlarmMethod Failed", null, null, 14);
        goto L7
    }
}
