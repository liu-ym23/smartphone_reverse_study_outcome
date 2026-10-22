package bolts;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f94a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f95b;
    private final ScheduledExecutorService c;
    private final Executor d;

    /* JADX INFO: renamed from: bolts.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadLocal<Integer> f96a;

        private a() {
            this.f96a = new ThreadLocal();
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        private int a() {
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f96a.get(), Integer.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            r0 = 0;
        L5:
            int r1 = r0.intValue() + 1;
            this.f96a.set(Integer.valueOf(r1));
            return r1;
        }

        private int b() {
            Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f96a.get(), Integer.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
            r0 = 0;
        L5:
            int r1 = r0.intValue() - 1;
            ThreadLocal<Integer> r3 = this.f96a;
            if (r1 != 0) goto L8;
            r3.remove();
        L9:
            return r1;
        L8:
            r3.set(Integer.valueOf(r1));
            goto L9
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            if (a() > 15) goto L5;
            r4.run();     // Catch: Throwable -> L8
        L6:
            b();
            return;
        L5:
            b.a().execute(r4);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            b();
            throw th;
        }
    }

    static {
        f94a = new b();
    }

    private b() {
        if (d() == true) goto L5;
        ExecutorService r0 = Executors.newCachedThreadPool();
    L6:
        this.f95b = r0;
        this.c = Executors.newSingleThreadScheduledExecutor();
        this.d = new a(null);
        return;
    L5:
        r0 = bolts.a.a();
        goto L6
    }

    public static ExecutorService a() {
        return f94a.f95b;
    }

    static ScheduledExecutorService b() {
        return f94a.c;
    }

    static Executor c() {
        return f94a.d;
    }

    private static boolean d() {
        String r0 = System.getProperty("java.runtime.name");
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.toLowerCase(Locale.US).contains("android");
    }
}
