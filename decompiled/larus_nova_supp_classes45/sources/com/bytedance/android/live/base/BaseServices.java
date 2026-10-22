package com.bytedance.android.live.base;

import com.bytedance.android.live.base.service.IServiceCast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BaseServices {
    private static IServiceCast sServiceCast;

    public BaseServices() {
    }

    public static <T> T as(Class<T> r1) {
        IServiceCast r0 = sServiceCast;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.as(r1);
    }

    public static synchronized void install(IServiceCast r1) {
        monitor-enter(BaseServices.class);
        sServiceCast = r1;     // Catch: Throwable -> L7
        monitor-exit(BaseServices.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
