package com.bytedance.ies.bullet.service.monitor;

import android.os.MessageQueue;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f6041a;

    public f(h r5) {
        this.f6041a = r5;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        ConcurrentHashMap r5 = dd.c.f16640b;
        dd.c.b(this.f6041a.q());
        return false;
    }
}
