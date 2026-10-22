package com.bytedance.lark.lark_biz_feed_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e {
    public static final e a = null;
    public static final AtomicLong b = null;
    public static final Map<Long, u0> c = null;

    public e() {
    }

    static {
        a = new e();
        b = new AtomicLong(100);
        c = new LinkedHashMap();
    }

    public final u0 a(long r2) {
        monitor-enter(this);
        Map<Long, u0> r0 = c;     // Catch: Throwable -> L6
        LinkedHashMap r1 = (LinkedHashMap) r0;     // Catch: Throwable -> L6
        u0 r3 = (u0) r1.get(Long.valueOf(r2));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r3;
    L6:
        th = move-exception;
        throw th;
    }

    public final long b(u0 r5) {
        Intrinsics.checkNotNullParameter(r5, "cb");
        monitor-enter(this);
        long r0 = b.incrementAndGet();     // Catch: Throwable -> L7
        Long r2 = Long.valueOf(r0);     // Catch: Throwable -> L7
        c.put(r2, r5);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
