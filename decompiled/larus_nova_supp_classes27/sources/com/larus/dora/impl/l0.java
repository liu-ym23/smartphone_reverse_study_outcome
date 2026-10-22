package com.larus.dora.impl;

import android.os.MessageQueue;
import g49.d;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class l0 implements MessageQueue.IdleHandler {
    public /* synthetic */ l0() {
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        AtomicBoolean r0 = DoraServiceImpl.V0;
        d.d("DoraServiceImpl", "IdleHandler exec");
        com.larus.dora.impl.core.i0 r1 = com.larus.dora.impl.core.i0.a.a;
        return false;
    }
}
