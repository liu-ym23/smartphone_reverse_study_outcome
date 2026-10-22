package com.bytedance.ug.cloud;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f3355a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, q> f3356b = null;

    static {
        f3355a = new Object();
        f3356b = new HashMap();
    }

    public static k a(g r3) {
        if (r3 == null) goto L17;
        Object r0 = f3355a;
        monitor-enter(r0);
        Map<String, q> r1 = f3356b;     // Catch: Throwable -> L13
        if (r1.containsKey(r3.f3340b) == false) goto L10;
        k r4 = (k) ZeusTransformUtils.preCheckCast(r1.get(r3.f3340b), k.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    L10:
        q r2 = new q(r3);     // Catch: Throwable -> L13
        r1.put(r3.f3340b, r2);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalArgumentException("options is null");
    }
}
