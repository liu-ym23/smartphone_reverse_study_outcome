package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c {
    public static final Method a = null;

    static {
        Method r0 = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L4
    L5:
        a = r0;
        return;
    L4:
        r0 = null;
        goto L5
    }
}
