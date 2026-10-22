package com.ss.android.lark.monitor;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k {
    public a a;
    public ScheduledFuture<?> b;
    public final ScheduledExecutorService c;

    public interface a {
    }

    public k(ScheduledExecutorService r1) {
        this.c = r1;
    }
}
