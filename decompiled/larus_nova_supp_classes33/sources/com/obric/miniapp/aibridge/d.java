package com.obric.miniapp.aibridge;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ f3.h a;

    public /* synthetic */ d(f3.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        f3.h r0 = this.a;
        String r6 = (String) r5;
        FLogger.a.d("GetAlarmInfoMethod", "getAlarmJsonById result: " + r6);
        if (r6 == null) goto L5;
        Intrinsics.checkNotNullParameter(AbsGetAlarmInfoMethodIDL.b.class, "<this>");
        AbsGetAlarmInfoMethodIDL.b r1 = k3.c.a(AbsGetAlarmInfoMethodIDL.b.class);
        r1.setResult(r6);
        f3.h.a.b(r0, r1);
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(r0, "Empty", null, null, 14);
        goto L7
    }
}
