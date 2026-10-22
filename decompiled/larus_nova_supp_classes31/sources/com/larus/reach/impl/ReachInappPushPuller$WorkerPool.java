package com.larus.reach.impl;

import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ReachInappPushPuller$WorkerPool {
    public final CoroutineScope a;
    public final Channel<ReachInappPushPuller$b> b;

    public ReachInappPushPuller$WorkerPool(ReachInappPushPuller r10) {
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.b = ChannelKt.Channel$default(5, null, null, 6, null);
        int r1 = 0;
    L4:
        if (r1 >= 2) goto L6;
        BuildersKt.launch$default(this.a, null, null, new ReachInappPushPuller$WorkerPool$1$1(this, r10, null), 3, null);
        r1 = r1 + 1;
        goto L4
    }
}
