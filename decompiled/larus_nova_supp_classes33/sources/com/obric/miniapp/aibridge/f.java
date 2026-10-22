package com.obric.miniapp.aibridge;

import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class f implements Function1 {
    public final /* synthetic */ f3.h a;

    public /* synthetic */ f(f3.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r5) {
        f3.h r0 = this.a;
        List<String> r6 = (List) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        FLogger.a.d("GetAllAlarmMethod", "getAllAlarmIds result: " + r6);
        Intrinsics.checkNotNullParameter(AbsGetAllAlarmMethodIDL.b.class, "<this>");
        AbsGetAllAlarmMethodIDL.b r1 = k3.c.a(AbsGetAllAlarmMethodIDL.b.class);
        r1.setResult(r6);
        f3.h.a.b(r0, r1);
        return Unit.INSTANCE;
    }
}
