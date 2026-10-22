package com.larus.common.mssdk.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class m implements Function2 {
    public /* synthetic */ m() {
    }

    public final Object invoke(Object r4, Object r5) {
        String r6 = (String) r4;
        String r7 = (String) r5;
        int r0 = SecurityServiceImpl.l;
        Intrinsics.checkNotNullParameter(r6, "logType");
        Intrinsics.checkNotNullParameter(r7, "content");
        FLogger.a.i("SecurityService", "TTCNPA monitorLogSend logType: " + r6 + ", json: " + r7);
        return Unit.INSTANCE;
    }
}
