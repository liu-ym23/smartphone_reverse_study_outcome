package kotlinx.coroutines.internal;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f10544a = null;

    static {
        Method r10 = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", new Class[]{Boolean.TYPE});     // Catch: Throwable -> L4
    L5:
        f10544a = r10;
        return;
    L4:
        r10 = null;
        goto L5
    }

    public static final boolean a(Executor r10) {
    L14:
        return false;
    L4:
        if ((r10 instanceof ScheduledThreadPoolExecutor) == false) goto L6;
        ScheduledThreadPoolExecutor r11 = (ScheduledThreadPoolExecutor) r10;     // Catch: Throwable -> L14
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        Method r12 = f10544a;     // Catch: Throwable -> L14
        if (r12 != null) goto L12;
        return false;
    L12:
        r12.invoke(r11, new Object[]{Boolean.TRUE});     // Catch: Throwable -> L14
        return true;
    L6:
        r11 = null;
        goto L7
    }
}
