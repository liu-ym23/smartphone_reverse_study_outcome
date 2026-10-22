package p7;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedTransferQueue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArrayList f21319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedTransferQueue f21320b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f21321c;

    static {
        f21319a = new CopyOnWriteArrayList();
        f21320b = new LinkedTransferQueue();
        f21321c = false;
    }

    public static void a(b r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        f21320b.offer(r5);
        if (f21321c == false) goto L7;
        return;
    L7:
        monitor-enter(a.class);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (f21321c == false) goto L13;
        monitor-exit(a.class);
        return;
    L13:
        f21321c = true;     // Catch: Throwable -> L16
        new Thread(new com.bytedance.android.anniex.worker.a(26), "APM-Monitor").start();     // Catch: Throwable -> L16
        monitor-exit(a.class);
    }
}
