package com.bytedance.apm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<f> f1315a;

    static {
        f1315a = new ArrayList(2);
    }

    public static synchronized void a(com.bytedance.apm.config.e r5) {
        monitor-enter(g.class);
        Iterator<f> r1 = f1315a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r1.next(), f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        r2.a(r5);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(g.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(f r3) {
        monitor-enter(g.class);
        f r4 = (f) ZeusTransformUtils.wrapperContextForParams(r3, f.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        f1315a.add(r4);     // Catch: Throwable -> L7
        monitor-exit(g.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
