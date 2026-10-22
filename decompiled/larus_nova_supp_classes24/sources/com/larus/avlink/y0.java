package com.larus.avlink;

import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class y0 implements Function0 {
    public final /* synthetic */ boolean a;

    public /* synthetic */ y0(boolean r1) {
        this.a = r1;
    }

    public final Object invoke() {
        boolean r0 = this.a;
        boolean r1 = false;
        DoraWakeupResponseManager.h = false;
        DoraWakeupResponseManager r2 = DoraWakeupResponseManager.a;
        if (DoraWakeupResponseManager.f > 0) goto L5;
        long r3 = -1;
    L6:
        FLogger r6 = FLogger.a;
        r6.i("DoraWakeupResponse", "onVadChanged: isStart=" + r0 + ", elapsed=" + r3);
        if (r0 == true) goto L9;
        e10 r4 = e10.a;
        Long r5 = e10.w0().getWakeupNoneOneshotVadendDelay();
        if (r5 == null) goto L22;
        long r7 = r5.longValue();
    L24:
        if (r3 >= r7) goto L27;
        DoraWakeupResponseManager.h = true;
        r6.i("DoraWakeupResponse", "onVadChanged: set hasReceivedVadEnd=true");
    L27:
        return Unit.INSTANCE;
    L22:
        r7 = 400;
        goto L24
    L9:
        if (DoraWakeupResponseManager.f <= 0) goto L28;
        long r8 = DoraWakeupResponseManager.e();
        if (0 <= r3) goto L14;
    L16:
        if (r1 == false) goto L18;
        DoraWakeupResponseManager.c("onVadChanged start before " + r8 + " ms");
    L18:
        DoraWakeupResponseManager.d();
        goto L27
    L14:
        if (r3 >= r8) goto L16;
        r1 = true;
        goto L16
    L28:
        return Unit.INSTANCE;
    L5:
        r3 = System.currentTimeMillis() - DoraWakeupResponseManager.f;
        goto L6
    }
}
