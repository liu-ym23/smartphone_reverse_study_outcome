package h;

import ai.y;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final c d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f17256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f17257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f17258c;

    static {
        d = new c();
    }

    public c() {
        String r5 = System.getProperty("java.runtime.name");
        if (r5 != null) goto L5;
        boolean r10 = false;
    L6:
        if (r10 == true) goto L8;
        ExecutorService r11 = Executors.newCachedThreadPool();
    L9:
        this.f17256a = r11;
        this.f17257b = Executors.newSingleThreadScheduledExecutor();
        this.f17258c = new y(2);
        return;
    L8:
        b r12 = b.f17253b;
        TimeUnit r13 = TimeUnit.SECONDS;
        LinkedBlockingQueue r14 = new LinkedBlockingQueue();
        ThreadPoolExecutor r15 = new ThreadPoolExecutor(b.f17254c, b.d, 1, r13, r14);
        r15.allowCoreThreadTimeOut(true);
        r11 = r15;
        goto L9
    L5:
        r10 = r5.toLowerCase(Locale.US).contains("android");
        goto L6
    }
}
