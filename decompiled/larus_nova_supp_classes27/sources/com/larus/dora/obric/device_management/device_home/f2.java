package com.larus.dora.obric.device_management.device_home;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f2 {
    public final Object a;
    public final Map<String, Long> b;

    public static final class a {
    }

    static {
    }

    public f2() {
        this.a = new Object();
        this.b = new LinkedHashMap();
    }

    public final boolean a(String r5, long r6) {
        Intrinsics.checkNotNullParameter(r5, "deviceMac");
        Object r0 = this.a;
        monitor-enter(r0);
        Long r1 = (Long) ((LinkedHashMap) this.b).get(r5);     // Catch: Throwable -> L14
        if (r1 != null) goto L8;
    L9:
        boolean r7 = false;
    L12:
        monitor-exit(r0);
        return r7;
    L8:
        if (r1.longValue() != r6) goto L9;
        this.b.remove(r5);     // Catch: Throwable -> L14
        r7 = true;
    L14:
        th = move-exception;
        throw th;
    }
}
