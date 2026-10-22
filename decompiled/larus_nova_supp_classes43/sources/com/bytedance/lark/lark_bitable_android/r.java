package com.bytedance.lark.lark_bitable_android;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class r {
    public static final r a = null;
    public static final AtomicLong b = null;
    public static final Map<Long, q0> c = null;

    public r() {
    }

    static {
        a = new r();
        b = new AtomicLong(100);
        c = new LinkedHashMap();
    }

    public final long a(q0 r10) {
        Intrinsics.checkNotNullParameter(r10, "cb");
        monitor-enter(this);
        long r0 = b.incrementAndGet();     // Catch: Throwable -> L7
        Long r11 = Long.valueOf(r0);     // Catch: Throwable -> L7
        c.put(r11, r10);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(long r10) {
        monitor-enter(this);
        Map<Long, q0> r0 = c;     // Catch: Throwable -> L10
        LinkedHashMap r11 = (LinkedHashMap) r0;     // Catch: Throwable -> L10
        if (((q0) r11.get(Long.valueOf(r10))) != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        q0 r12 = r0.remove(Long.valueOf(r10));     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
