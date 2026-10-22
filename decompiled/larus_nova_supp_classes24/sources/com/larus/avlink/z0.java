package com.larus.avlink;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class z0 implements Function0 {
    public final /* synthetic */ String a;

    public /* synthetic */ z0(String r1) {
        this.a = r1;
    }

    public final Object invoke() {
        String r0 = this.a;
        if (DoraWakeupResponseManager.f <= 0) goto L7;
        FLogger.a.i("DoraWakeupResponse", "onWakeupStop: cancel timer, reason=" + r0);
        DoraWakeupResponseManager r1 = DoraWakeupResponseManager.a;
        DoraWakeupResponseManager.c("onWakeupStop");
        DoraWakeupResponseManager.d();
        DoraWakeupResponseManager.h = false;
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    }
}
