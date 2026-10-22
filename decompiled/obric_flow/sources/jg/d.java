package jg;

import com.bytedance.monitor.collector.LockMonitorManager;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Thread f18326b;

    public /* synthetic */ d(Thread r5, int r10) {
        this.f18325a = r10;
        this.f18326b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f18325a) {
            case 0: goto L32;
            default: goto L33;
        };
    L32:
        String r5 = com.lynx.tasm.utils.g.o(this.f18326b.getStackTrace());     // Catch: Throwable -> L31
        BlockingQueue r10 = LockMonitorManager.access$600();     // Catch: Throwable -> L31
        monitor-enter(r10);     // Catch: Throwable -> L31
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L20:
        if (LockMonitorManager.access$600().size() == 0) goto L24;
        LockMonitorManager.access$600().clear();     // Catch: Throwable -> L22
    L24:
        LockMonitorManager.access$600().put(r5);     // Catch: Throwable -> L22
        monitor-exit(r10);     // Catch: Throwable -> L22
        goto L39
    L29:
        return;
    L39:
        return;
    L33:
        String r11 = com.lynx.tasm.utils.g.o(this.f18326b.getStackTrace());     // Catch: Throwable -> L30
        BlockingQueue r12 = LockMonitorManager.access$400();     // Catch: Throwable -> L30
        monitor-enter(r12);     // Catch: Throwable -> L30
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L7:
        if (LockMonitorManager.access$400().size() == 0) goto L11;
        LockMonitorManager.access$400().clear();     // Catch: Throwable -> L9
    L11:
        LockMonitorManager.access$400().put(r11);     // Catch: Throwable -> L9
        monitor-exit(r12);     // Catch: Throwable -> L9
        goto L38
    L16:
        return;
    }
}
