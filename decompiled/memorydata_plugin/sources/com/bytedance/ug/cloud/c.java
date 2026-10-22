package com.bytedance.ug.cloud;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f3336a;

    static {
    }

    c() {
    }

    static j a() {
        if (f3336a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3336a != null) goto L9;
        f3336a = b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f3336a;
    }

    private static j b() {
        return new e();
    L4:
        ZeusTransformUtils.forName("", "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        return new f();
    L6:
        th = move-exception;
        th.printStackTrace();
        return new o();
    }
}
