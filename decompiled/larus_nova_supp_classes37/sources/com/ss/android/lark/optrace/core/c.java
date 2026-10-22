package com.ss.android.lark.optrace.core;

import kotlin.Deprecated;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Deprecated(message = "This Container is deprecated,Use TracingServiceImpl Instead!")
public final class c {
    public static volatile jyb.a a;

    static {
        if (jyb.a.a == null) goto L5;
    L14:
        a = jyb.a.a;
        return;
    L5:
        monitor-enter(jyb.a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (jyb.a.a != null) goto L9;
        jyb.a.a = new jyb.a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(jyb.a.class);     // Catch: Throwable -> L11
        goto L14
    }
}
