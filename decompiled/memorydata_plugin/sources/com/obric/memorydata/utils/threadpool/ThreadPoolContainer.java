package com.obric.memorydata.utils.threadpool;

import com.bytedance.crash.Ensure;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0004\u0010\u0011\u0012\u0013B\t\b\u0012¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer;", "", "<init>", "()V", "threadPoolExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getThreadPoolExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "setThreadPoolExecutor", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "preLogTimestamp", "", "execute", "", "runnable", "Ljava/lang/Runnable;", "Companion", "CustomRejectedExecutionHandler", "CustomThreadFactory", "CustomUncaughtExceptionHandler", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThreadPoolContainer {
    public static final Companion Companion = null;
    private static final String TAG = "ThreadPoolContainer";
    private static final Lazy<ThreadPoolContainer> instance$delegate = null;
    private long preLogTimestamp;
    private ThreadPoolExecutor threadPoolExecutor;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer$Companion;", "", "<init>", "()V", "TAG", "", "instance", "Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer;", "getInstance", "()Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer;", "instance$delegate", "Lkotlin/Lazy;", "execute", "", "runnable", "Ljava/lang/Runnable;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final void execute(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "runnable");
            getInstance().execute(r4);
        }

        public final ThreadPoolContainer getInstance() {
            return (ThreadPoolContainer) ZeusTransformUtils.preCheckCast(ThreadPoolContainer.access$getInstance$delegate$cp().getValue(), ThreadPoolContainer.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer$CustomRejectedExecutionHandler;", "Ljava/util/concurrent/RejectedExecutionHandler;", "<init>", "(Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer;)V", "rejectedExecution", "", "r", "Ljava/lang/Runnable;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "logAllThreads", "triggerAnr", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class a implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ThreadPoolContainer f13261a;

        public a(ThreadPoolContainer r1) {
            this.f13261a = r1;
        }

        private final void a() {
            if ((System.currentTimeMillis() - ThreadPoolContainer.access$getPreLogTimestamp$p(this.f13261a)) >= 600000) goto L5;
            return;
        L5:
            ThreadPoolContainer.access$setPreLogTimestamp$p(this.f13261a, System.currentTimeMillis());
            Map<Thread, StackTraceElement[]> r10 = Thread.getAllStackTraces();
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ThreadPoolContainer.TAG, "FULL THREAD DUMP, size: " + r10.size(), null, 4, null);
            Intrinsics.checkNotNull(r10);
            Iterator<Map.Entry<Thread, StackTraceElement[]>> r11 = r10.entrySet().iterator();
        L7:
            if (r11.hasNext() == false) goto L16;
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Thread r1 = (Thread) ZeusTransformUtils.preCheckCast(r0.getKey(), Thread.class, "com.obric.memorydata.plugin");
            StackTraceElement[] r2 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r0.getValue(), StackTraceElement[].class, "com.obric.memorydata.plugin");
            StringBuilder r4 = new StringBuilder().append(r1.getName()).append(' ').append(r1.isDaemon()).append(" prio=").append(r1.getPriority()).append(' ').append(r1.getId()).append(' ');
            ThreadGroup r6 = r1.getThreadGroup();
            if (r6 == null) goto L11;
            String r7 = r6.getName();
        L12:
            StringBuffer r3 = new StringBuffer(r4.append(r7).append(' ').append(r1.getState()).toString());
            Intrinsics.checkNotNull(r2);
            int r5 = 0;
            int r8 = r2.length;
        L13:
            if (r5 >= r8) goto L15;
            r3.append("\n " + r2[r5]);
            r5 = r5 + 1;
            goto L13
        L15:
            IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
            String r12 = r3.toString();
            Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
            IRunLog.a.b(r9, ThreadPoolContainer.TAG, r12, null, 4, null);
            goto L7
        L11:
            r7 = null;
            goto L12
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r7, ThreadPoolExecutor r8) {
            Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), ThreadPoolContainer.TAG, "rejectedExecution", null, 4, null);
            Tracker.INSTANCE.reportDevEvent("memory_threadpool_blocked", new JSONObject());
            a();
            Ensure.ensureNotReachHere("ThreadPoolContainer_Blocked");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer$CustomThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "prefix", "", "<init>", "(Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer;Ljava/lang/String;)V", "group", "Ljava/lang/ThreadGroup;", "threadNamePrefix", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ThreadPoolContainer f13262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ThreadGroup f13263b;
        private String c;
        private AtomicInteger d;

        public b(ThreadPoolContainer r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "prefix");
            this.f13262a = r2;
            this.d = new AtomicInteger(1);
            this.c = r3;
            SecurityManager r4 = System.getSecurityManager();
            if (r4 == null) goto L5;
            ThreadGroup r5 = r4.getThreadGroup();
        L6:
            this.f13263b = r5;
            return;
        L5:
            r5 = Thread.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r9) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r9, Runnable.class, "com.obric.memorydata.plugin");
            StringBuilder r10 = new StringBuilder().append(this.c).append('-');
            AtomicInteger r0 = this.d;
            Intrinsics.checkNotNull(r0);
            String r5 = r10.append(r0.getAndIncrement()).toString();
            Thread r11 = new Thread(this.f13263b, r4, r5, 0);
            if (AppContext.INSTANCE.isDebug() == true) goto L6;
            r11.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler) ZeusTransformUtils.preCheckCast(new c(this.f13262a), Thread.UncaughtExceptionHandler.class, "com.obric.memorydata.plugin"));
        L6:
            if (r11.isDaemon() == false) goto L8;
            r11.setDaemon(false);
        L8:
            return r11;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer$CustomUncaughtExceptionHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "<init>", "(Lcom/obric/memorydata/utils/threadpool/ThreadPoolContainer;)V", "uncaughtException", "", "t", "Ljava/lang/Thread;", "e", "", "utils_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class c implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ThreadPoolContainer f13264a;

        public c(ThreadPoolContainer r1) {
            this.f13264a = r1;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "t");
            Intrinsics.checkNotNullParameter(r3, "e");
            RunLog.INSTANCE.error(ThreadPoolContainer.TAG, "uncaughtException:", r3);
            Ensure.ensureNotReachHere(r3, ThreadPoolContainer.TAG);
        }
    }

    static {
        Companion = new Companion(null);
        instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, $$Lambda$ThreadPoolContainer$u2OgA1jKbcpqJ3Be3Hq6gWPgR4.INSTANCE);
    }

    private ThreadPoolContainer() {
        this.threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1, 50, 30, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(300), BlockingQueue.class, "com.obric.memorydata.plugin"), (ThreadFactory) ZeusTransformUtils.preCheckCast(new b(this, "memoryData"), ThreadFactory.class, "com.obric.memorydata.plugin"), (RejectedExecutionHandler) ZeusTransformUtils.preCheckCast(new a(this), RejectedExecutionHandler.class, "com.obric.memorydata.plugin"));
        ThreadPoolExecutor r11 = getThreadPoolExecutor();
        Intrinsics.checkNotNull(r11);
        r11.allowCoreThreadTimeOut(true);
    }

    public static final /* synthetic */ Lazy access$getInstance$delegate$cp() {
        return instance$delegate;
    }

    public static final /* synthetic */ long access$getPreLogTimestamp$p(ThreadPoolContainer r2) {
        return r2.preLogTimestamp;
    }

    public static final /* synthetic */ void access$setPreLogTimestamp$p(ThreadPoolContainer r0, long r1) {
        r0.preLogTimestamp = r1;
    }

    private static final ThreadPoolContainer instance_delegate$lambda$0() {
        return new ThreadPoolContainer();
    }

    /* JADX INFO: renamed from: lambda$u2OgA1jKbcpqJ3Be3Hq6gWP-gR4, reason: not valid java name */
    public static /* synthetic */ ThreadPoolContainer m1251lambda$u2OgA1jKbcpqJ3Be3Hq6gWPgR4() {
        return instance_delegate$lambda$0();
    }

    public final void execute(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "runnable");
        ThreadPoolExecutor r2 = getThreadPoolExecutor();
        Intrinsics.checkNotNull(r2);
        r2.execute(r4);
    }

    public final ThreadPoolExecutor getThreadPoolExecutor() {
        return this.threadPoolExecutor;
    }

    public final void setThreadPoolExecutor(ThreadPoolExecutor r1) {
        this.threadPoolExecutor = r1;
    }
}
