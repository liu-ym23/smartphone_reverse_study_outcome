package com.larus.avlink;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class a1 implements Function0 {
    public /* synthetic */ a1() {
    }

    public final Object invoke() {
        if (DoraWakeupResponseManager.f <= 0) goto L19;
        DoraWakeupResponseManager r0 = DoraWakeupResponseManager.a;
        if (DoraWakeupResponseManager.f > 0) goto L8;
        long r1 = -1;
    L9:
        FLogger.a.i("DoraWakeupResponse", "onQueryBegin, elapsed=" + r1);
        long r4 = DoraWakeupResponseManager.e();
        if (0 <= r1) goto L12;
    L14:
        boolean r2 = false;
    L15:
        if (r2 == false) goto L17;
        DoraWakeupResponseManager.c("onQueryBegin, cutoffMs = " + r4 + " ms");
    L17:
        DoraWakeupResponseManager.d();
        DoraWakeupResponseManager.h = false;
        return Unit.INSTANCE;
    L12:
        if (r1 >= r4) goto L14;
        r2 = true;
        goto L15
    L8:
        r1 = System.currentTimeMillis() - DoraWakeupResponseManager.f;
        goto L9
    L19:
        return Unit.INSTANCE;
    }
}
