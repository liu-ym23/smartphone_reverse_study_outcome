package com.larus.voicecall.impl.autostop;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class p implements Function1 {
    public final /* synthetic */ AutoStopAsrServiceImpl a;

    public /* synthetic */ p(AutoStopAsrServiceImpl r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        AutoStopAsrServiceImpl r0 = this.a;
        Throwable r4 = (Throwable) r3;
        Object r5 = r0.b;
        monitor-enter(r5);
        r0.c = AutoStopAsrServiceImpl.LifecycleState.RELEASED;     // Catch: Throwable -> L8
        monitor-exit(r5);
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        throw th;
    }
}
