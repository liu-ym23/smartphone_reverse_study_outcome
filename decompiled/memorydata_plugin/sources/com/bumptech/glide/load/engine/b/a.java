package com.bumptech.glide.load.engine.b;

import android.text.TextUtils;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f740a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f741b;
    private final ExecutorService c;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.b.a$a, reason: collision with other inner class name */
    public static final class C0066a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f743b;
        private int c;
        private ThreadFactory d;
        private d e;
        private String f;
        private long g;

        C0066a(boolean r3) {
            this.d = new b(null);
            this.e = d.d;
            this.f742a = r3;
        }

        public C0066a a(int r1) {
            this.f743b = r1;
            this.c = r1;
            return this;
        }

        public C0066a a(String r1) {
            this.f = r1;
            return this;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f) == true) goto L10;
            ThreadPoolExecutor r0 = new ThreadPoolExecutor(this.f743b, this.c, this.g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new c(this.d, this.f, this.e, this.f742a));
            if (this.g == 0) goto L8;
            r0.allowCoreThreadTimeOut(true);
        L8:
            return new a(r0);
        L10:
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f);
        }
    }

    private static final class b implements ThreadFactory {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            return new AnonymousClass1(this, r4);
        }
    }

    private static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f746b;
        private final ThreadFactory c;
        private final String d;
        private final AtomicInteger e;

        c(ThreadFactory r3, String r4, d r5, boolean r6) {
            ThreadFactory r7 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.memorydata.plugin");
            this.e = new AtomicInteger();
            this.c = r7;
            this.d = r4;
            this.f745a = r8;
            this.f746b = r6;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            Thread r5 = this.c.newThread(new AnonymousClass1(this, r4));
            r5.setName("glide-" + this.d + "-thread-" + this.e.getAndIncrement());
            return r5;
        }
    }

    public interface d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f749a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f750b = null;
        public static final d c = null;
        public static final d d = null;

        static {
            f749a = new AnonymousClass1();
            d r0 = new AnonymousClass2();
            f750b = r0;
            c = new AnonymousClass3();
            d = r0;
        }

        void a(Throwable r1);
    }

    static {
        f740a = TimeUnit.SECONDS.toMillis(10);
    }

    a(ExecutorService r3) {
        this.c = (ExecutorService) ZeusTransformUtils.wrapperContextForParams(r3, ExecutorService.class, "com.obric.memorydata.plugin");
    }

    public static C0066a a() {
        return new C0066a(true).a(1).a("disk-cache");
    }

    public static a b() {
        return a().a();
    }

    public static C0066a c() {
        return new C0066a(false).a(i()).a(AILabCheckPermissionTask.KEY_SOURCE);
    }

    public static a d() {
        return c().a();
    }

    public static a e() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f740a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new c(new b(null), "source-unlimited", d.d, false)));
    }

    public static C0066a f() {
        int r0 = g();
        return new C0066a(true).a(r0).a("animation");
    }

    static int g() {
        if (i() < 4) goto L5;
        return 2;
    L5:
        return 1;
    }

    public static a h() {
        return f().a();
    }

    public static int i() {
        if (f741b != 0) goto L6;
        f741b = Math.min(4, com.bumptech.glide.load.engine.b.b.a());
    L6:
        return f741b;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long r1, TimeUnit r3) {
        return this.c.awaitTermination(r1, r3);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.c.execute(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r3) {
        Collection<? extends Callable<T>> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.c.invokeAll(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> r3, long r4, TimeUnit r6) {
        Collection<? extends Callable<T>> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return this.c.invokeAll(r5, r4, r6);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r3) {
        Collection<? extends Callable<T>> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return (T) this.c.invokeAny(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> r3, long r4, TimeUnit r6) {
        Collection<? extends Callable<T>> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        return (T) this.c.invokeAny(r5, r4, r6);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return this.c.submit(r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r3, T r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return this.c.submit(r5, r4);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r3) {
        Callable<T> r4 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin");
        return this.c.submit(r4);
    }

    public String toString() {
        return this.c.toString();
    }
}
