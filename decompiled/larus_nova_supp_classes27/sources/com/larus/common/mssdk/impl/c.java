package com.larus.common.mssdk.impl;

import com.bytedance.ttcnpa.TTCNPA;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ SecurityServiceImpl a;

    public /* synthetic */ c(SecurityServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke() {
        SecurityServiceImpl r0 = this.a;
        int r1 = SecurityServiceImpl.l;
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("TTCNPA SDK initialized, initialized=");
        TTCNPA.a.getClass();
        r3.append(TTCNPA.b);
        r2.i("SecurityService", r3.toString());
        monitor-enter(r0);
        r0.a = true;     // Catch: Throwable -> L13
        r0.b = false;     // Catch: Throwable -> L13
        Iterator r4 = ((ArrayList) r0.c).iterator();     // Catch: Throwable -> L13
    L7:
        if (r4.hasNext() == false) goto L9;
        ((Function0) r4.next()).invoke();     // Catch: Throwable -> L13
        goto L7
    L9:
        ((ArrayList) r0.c).clear();     // Catch: Throwable -> L13
        monitor-exit(r0);
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        throw th;
    }
}
