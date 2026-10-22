package n4a;

import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j1 implements ThreadFactory {
    public static final int i = 0;
    public static final int j = 0;
    public final AtomicLong a;
    public final ThreadFactory b;
    public final Thread.UncaughtExceptionHandler c;
    public final String d;
    public final int e;
    public final int f;
    public final BlockingQueue<Runnable> g;
    public final int h;

    public static class a {
        public Thread.UncaughtExceptionHandler a;
        public String b;
        public final int c;
        public final int d;

        public a() {
            this.c = j1.i;
            this.d = 30;
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        i = Math.max(2, Math.min(r0 - 1, 4));
        j = (r0 * 2) + 1;
    }

    public j1(a r3) {
        this.b = Executors.defaultThreadFactory();
        int r0 = r3.c;
        this.e = r0;
        int r1 = j;
        this.f = r1;
        if (r1 < r0) goto L11;
        this.h = r3.d;
        this.g = new LinkedBlockingQueue(256);
        if (TextUtils.isEmpty(r3.b) == false) goto L7;
        String r2 = "amap-threadpool";
    L8:
        this.d = r2;
        this.c = r3.a;
        this.a = new AtomicLong();
        return;
    L7:
        r2 = r3.b;
        goto L8
    L11:
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Thread r6 = this.b.newThread(r5);
        if (this.d == null) goto L5;
        ThreadMethodProxy.setName(r6, String.format(this.d + "-%d", new Object[]{Long.valueOf(this.a.incrementAndGet())}));
    L5:
        Thread.UncaughtExceptionHandler r0 = this.c;
        if (r0 == null) goto L8;
        r6.setUncaughtExceptionHandler(r0);
    L8:
        return r6;
    }
}
