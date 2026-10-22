package e8;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements ThreadFactory {
    public static final AtomicInteger d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadGroup f16779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f16780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f16781c;

    static {
        d = new AtomicInteger(1);
    }

    public b() {
        this.f16780b = new AtomicInteger(1);
        SecurityManager r5 = System.getSecurityManager();
        if (r5 == null) goto L5;
        ThreadGroup r10 = r5.getThreadGroup();
    L6:
        this.f16779a = r10;
        this.f16781c = "TTBackgroundExecutors-" + d.getAndIncrement() + "-Thread-";
        return;
    L5:
        r10 = Thread.currentThread().getThreadGroup();
        goto L6
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r10) {
        am.a r11 = new am.a(this.f16779a, r10, this.f16781c + this.f16780b.getAndIncrement(), 0);
        if (r11.isDaemon() == false) goto L5;
        r11.setDaemon(false);
    L5:
        return r11;
    }
}
