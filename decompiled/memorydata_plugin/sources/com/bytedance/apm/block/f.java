package com.bytedance.apm.block;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<e> f1228a;

    static {
        f1228a = new ArrayList(2);
    }

    public static synchronized void a(e r3) {
        monitor-enter(f.class);
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        f1228a.add(r4);     // Catch: Throwable -> L7
        monitor-exit(f.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(boolean r5, long r6) {
        monitor-enter(f.class);
        Iterator<e> r1 = f1228a.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r1.next(), e.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r2 == null) goto L6;
        r2.a(r5, r6);     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(f.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
