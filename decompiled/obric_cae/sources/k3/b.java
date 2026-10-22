package k3;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f8926a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedTransferQueue f8927b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f8928c;

    static {
        f8926a = new CopyOnWriteArrayList();
        f8927b = new LinkedTransferQueue();
        f8928c = false;
    }

    public static void a(c r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        f8927b.offer(r8);
        if (f8928c == false) goto L7;
        return;
    L7:
        monitor-enter(b.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (f8928c == true) goto L12;
        f8928c = true;     // Catch: Throwable -> L14
        new Thread(new a(), "APM-Monitor").start();     // Catch: Throwable -> L14
    L12:
        monitor-exit(b.class);
    }
}
