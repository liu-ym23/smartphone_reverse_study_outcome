package com.larus.security.api;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class k implements Function1<Throwable, Unit> {
    public final /* synthetic */ kotlinx.coroutines.i<Unit> a;

    public k(kotlinx.coroutines.j r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        Throwable r4 = (Throwable) r3;
        TTCNPAHelper r5 = TTCNPAHelper.a;
        kotlinx.coroutines.i<Unit> r0 = this.a;
        monitor-enter(r5);
        ((ArrayList) TTCNPAHelper.d).remove(r0);     // Catch: Throwable -> L8
        monitor-exit(r5);
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        throw th;
    }
}
