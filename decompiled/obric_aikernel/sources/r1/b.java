package r1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final RejectedExecutionHandler f12584c = null;

    static {
        f12584c = new ThreadPoolExecutor.AbortPolicy();
    }

    public b(int r10, int r11, long r12, TimeUnit r14, BlockingQueue<Runnable> r15, ThreadFactory r16) {
        super(r10, r11, r12, r14, r15, r16, f12584c);
    }

    public b(int r10, int r11, long r12, TimeUnit r13, BlockingQueue<Runnable> r14, ThreadFactory r15, RejectedExecutionHandler r16) {
        super(r10, r11, r12, r13, r14, r15, r16);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return new ArrayList();
    }
}
