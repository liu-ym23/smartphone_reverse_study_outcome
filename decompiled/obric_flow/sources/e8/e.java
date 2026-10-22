package e8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor.AbortPolicy f16788a = null;

    static {
        f16788a = new ThreadPoolExecutor.AbortPolicy();
    }

    public e(int r10, int r11, long r12, TimeUnit r14, LinkedBlockingQueue r15, ThreadFactory r16) {
        super(r10, r11, r12, r14, r15, r16, f16788a);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public final List shutdownNow() {
        return new ArrayList();
    }
}
