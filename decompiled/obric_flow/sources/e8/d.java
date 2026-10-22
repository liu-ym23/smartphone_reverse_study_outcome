package e8;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f16786b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f16787c = null;
    public static final ScheduledExecutorService d = null;
    public static final e e = null;
    public static final e f = null;

    static {
        int r5 = Runtime.getRuntime().availableProcessors();
        if (r5 > 0) goto L6;
        r5 = 1;
    L6:
        int r10 = r5 - 1;
        int r11 = Math.max(2, Math.min(r10, 6));
        c r12 = new c("TTDefaultExecutors");
        c r15 = new c("TTCpuExecutors");
        c r13 = new c("TTScheduledExecutors");
        c r14 = new c("TTDownLoadExecutors");
        c r16 = new c("TTSerialExecutors");
        b r25 = new b();
        LinkedBlockingQueue r17 = new LinkedBlockingQueue();
        LinkedBlockingQueue r18 = new LinkedBlockingQueue();
        LinkedBlockingQueue r22 = new LinkedBlockingQueue();
        a r19 = new a(0);
        TimeUnit r26 = TimeUnit.SECONDS;
        e r20 = new e(r11 * 2, (r11 * 4) + 1, 30, r26, r17, r12, r19);
        f16785a = r20;
        r20.allowCoreThreadTimeOut(true);
        e r21 = new e(Math.max(2, Math.min(r10, 3)), (r5 * 2) + 1, 30, r26, r18, r15, r19);
        f16786b = r21;
        r21.allowCoreThreadTimeOut(true);
        d = Executors.newScheduledThreadPool(3, r13);
        e r23 = new e(2, 2, 30, r26, r22, r14, r19);
        f16787c = r23;
        r23.allowCoreThreadTimeOut(true);
        e r24 = new e(1, 1, 30, r26, new LinkedBlockingQueue(), r16);
        e = r24;
        r24.allowCoreThreadTimeOut(true);
        e r27 = new e(0, 3, 30, r26, new LinkedBlockingQueue(), r25);
        f = r27;
        r27.allowCoreThreadTimeOut(true);
    }
}
