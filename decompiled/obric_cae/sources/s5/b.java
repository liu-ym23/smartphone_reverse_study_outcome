package s5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor.AbortPolicy f12033a = null;

    static {
        f12033a = new ThreadPoolExecutor.AbortPolicy();
    }

    public b(int r10, int r11, TimeUnit r12, LinkedBlockingQueue r13, ThreadFactory r14) {
        super(r10, r11, 30, r12, r13, r14, f12033a);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return new ArrayList();
    }

    public b(int r10, int r11, TimeUnit r12, LinkedBlockingQueue r13, a.c r14, a.RejectedExecutionHandlerC0152a r15) {
        super(r10, r11, 30, r12, r13, r14, r15);
    }
}
