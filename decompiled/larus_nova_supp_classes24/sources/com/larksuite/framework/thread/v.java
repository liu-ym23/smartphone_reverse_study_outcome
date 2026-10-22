package com.larksuite.framework.thread;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class v {
    public final ScheduledExecutorService a;
    public final u b;
    public ScheduledFuture c;
    public a d;
    public final AtomicInteger e;

    public interface a {
        void a(AtomicInteger r1);
    }

    public v() {
        this.e = new AtomicInteger(0);
        this.a = CoreThreadPool.getDefault().getScheduleThreadPool();
        this.b = new u(this);
    }
}
