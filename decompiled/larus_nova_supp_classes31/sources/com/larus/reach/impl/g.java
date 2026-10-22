package com.larus.reach.impl;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ ReachInappPushPuller a;

    public /* synthetic */ g(ReachInappPushPuller r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ReachInappPushPuller r0 = this.a;
        r0.getClass();
        ReachInappPushPuller$WorkerPool r1 = new ReachInappPushPuller$WorkerPool(r0);
        monitor-enter(r0);
    L13:
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((!r0.b.isEmpty()) == false) goto L7;
        ReachInappPushPuller$b r2 = (ReachInappPushPuller$b) r0.b.removeFirst();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r2, "task");     // Catch: Throwable -> L10
        r1.b.trySend-JP2dKIU(r2);     // Catch: Throwable -> L10
        goto L13
    L7:
        r0.a = r1;     // Catch: Throwable -> L10
        r0.c = false;     // Catch: Throwable -> L10
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r0);
    }
}
