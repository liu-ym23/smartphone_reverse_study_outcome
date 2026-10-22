package com.bytedance.ai.debugscene;

import com.bytedance.ai.debug.IAISDKDebugService$d;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q2 implements IAISDKDebugService$d {
    public static final AtomicLong b = null;
    public final long a;

    public static final class a {
    }

    public q2() {
        this(0);
    }

    static {
        b = new AtomicLong();
    }

    public q2(int r10) {
        this.a = b.incrementAndGet();
    }
}
