package bolts;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f92a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f93b = 0;
    private static final a c = null;
    private static final int e = 0;
    private final Executor d;

    /* JADX INFO: renamed from: bolts.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: bolts.a$a, reason: collision with other inner class name */
    private static class ExecutorC0046a implements Executor {
        private ExecutorC0046a() {
        }

        /* synthetic */ ExecutorC0046a(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r2) {
            Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
            new Handler(Looper.getMainLooper()).post(r1);
        }
    }

    static {
        c = new a();
        int r0 = Runtime.getRuntime().availableProcessors();
        e = r0;
        f92a = r0 + 1;
        f93b = (r0 * 2) + 1;
    }

    private a() {
        this.d = new ExecutorC0046a(null);
    }

    public static ExecutorService a() {
        ThreadPoolExecutor r7 = new ThreadPoolExecutor(f92a, f93b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(r7, true);
        return r7;
    }

    public static void a(ThreadPoolExecutor r2, boolean r3) {
        if (Build.VERSION.SDK_INT < 9) goto L6;
        r2.allowCoreThreadTimeOut(r3);
        return;
    }

    public static Executor b() {
        return c.d;
    }
}
