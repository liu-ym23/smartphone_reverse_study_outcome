package x3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class b extends ThreadPoolExecutor {
    static {
        new ThreadPoolExecutor.AbortPolicy();
    }

    public b(int r8, int r10, long r11, TimeUnit r12, LinkedBlockingQueue r13, a.c r14, a.RejectedExecutionHandlerC0191a r15) {
        super(r8, r10, r11, r12, r13, r14, r15);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return new ArrayList();
    }
}
