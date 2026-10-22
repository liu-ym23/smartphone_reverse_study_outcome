package com.obric.memorydata.middleware.impl.network;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0012\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\b\u001a\u0002H\t\"\u0004\b\u0000\u0010\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\t0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\u0010\u000fJ)\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u00052\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0002\b\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor;", "", "<init>", "()V", "DEFAULT_IDLE_TIMEOUT_MS", "", "workerIdGenerator", "Ljava/util/concurrent/atomic/AtomicInteger;", NotificationCompat.CATEGORY_CALL, ExifInterface.GPS_DIRECTION_TRUE, "idleTimeoutMs", "block", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor$SameThreadScope;", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", Constants.LAUNCH_TAG, "", "SameThreadScope", "InternalSameThreadScope", "SingleThreadWorker", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f11767a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f11768b = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor$InternalSameThreadScope;", "Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor$SameThreadScope;", "worker", "Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor$SingleThreadWorker;", "<init>", "(Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor$SingleThreadWorker;)V", "threadId", "", "getThreadId", "()J", "postAsync", "", "block", "Lkotlin/Function0;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f11769a;

        public a(c r2) {
            Intrinsics.checkNotNullParameter(r2, "worker");
            this.f11769a = r2;
        }

        @Override // com.obric.memorydata.middleware.impl.network.e.b
        public void a(Function0<Unit> r3) {
            Function0<Unit> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "block");
            this.f11769a.a(r4);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor$SameThreadScope;", "", "threadId", "", "getThreadId", "()J", "postAsync", "", "block", "Lkotlin/Function0;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface b {
        void a(Function0<Unit> r1);
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\tJ\b\u0010\u0013\u001a\u00020\tH\u0016J\u0014\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000eJ\b\u0010\u0016\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor$SingleThreadWorker;", "Ljava/lang/Runnable;", ActivityLifecycle.NAME, "", "idleTimeoutMs", "", "firstTask", "Lkotlin/Function1;", "Lcom/obric/memorydata/middleware/impl/network/SameThreadExecutor$SameThreadScope;", "", "<init>", "(Ljava/lang/String;JLkotlin/jvm/functions/Function1;)V", "taskQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "Lkotlin/Function0;", "threadRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/lang/Thread;", CommonConsts.APM_INNER_EVENT_COST_START, "run", "postAsyncOnSameThread", "block", "loop", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f11770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11771b;
        private final Function1<b, Unit> c;
        private final LinkedBlockingQueue<Function0<Unit>> d;
        private final AtomicReference<Thread> e;

        public c(String r3, long r4, Function1<? super b, Unit> r6) {
            Function1<b, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r7, "firstTask");
            this.f11770a = r3;
            this.f11771b = r4;
            this.c = r7;
            this.d = new LinkedBlockingQueue();
            this.e = new AtomicReference(null);
        }

        private final void b() {
        L2:
            Function0 r0 = (Function0) ZeusTransformUtils.preCheckCast(this.d.poll(this.f11771b, TimeUnit.MILLISECONDS), Function0.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L4;
            r0.invoke();
            goto L2
        L4:
            System.out.println("Worker[" + this.f11770a + "] idle for " + this.f11771b + " ms, exiting.");
        }

        public final void a() {
            Thread r0 = new Thread((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), this.f11770a);
            this.e.set(r0);
            r0.start();
        }

        public final void a(Function0<Unit> r5) {
            Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r5, Function0.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "block");
            Thread r0 = Thread.currentThread();
            Thread r1 = (Thread) ZeusTransformUtils.preCheckCast(this.e.get(), Thread.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(r0, r1) == false) goto L7;
            this.d.offer(r6);
            return;
        L7:
            throw new IllegalArgumentException(("postAsyncOnSameThread must be called on worker thread. current=" + r0 + ", owner=" + r1).toString());
        }

        @Override // java.lang.Runnable
        public void run() {
            a r0 = new a(this);
            this.c.invoke(r0);
            b();
            this.e.set(null);
        }
    }

    static {
        f11767a = new e();
        f11768b = new AtomicInteger(0);
    }

    private e() {
    }

    public static /* synthetic */ Object a(e r1, long r2, Function1 r4, int r5, Object r6) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        if ((r5 & 1) == 0) goto L6;
        r2 = 30000;
    L6:
        return r1.call(r2, r7);
    }

    private static final Unit a(Function1 r2, AtomicReference r3, CountDownLatch r4, b r5) {
        Function1 r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "scope");
        r3.set(r6.invoke(r7));     // Catch: Throwable -> L6
        r4.countDown();
        return Unit.INSTANCE;
    L6:
        th = move-exception;
        r4.countDown();
        throw th;
    }

    /* JADX INFO: renamed from: lambda$zox-30ioDW6GdpSei8nsVwqfnJk, reason: not valid java name */
    public static /* synthetic */ Unit m1025lambda$zox30ioDW6GdpSei8nsVwqfnJk(Function1 r0, AtomicReference r1, CountDownLatch r2, b r3) {
        return a(r0, r1, r2, r3);
    }

    public final <T> T call(long r5, Function1<? super b, ? extends T> r7) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "block");
        String r8 = "SameThreadWorker-" + f11768b.incrementAndGet();
        final AtomicReference r0 = new AtomicReference(null);
        final CountDownLatch r1 = new CountDownLatch(1);
        new c(r8, r5, new $$Lambda$e$zox30ioDW6GdpSei8nsVwqfnJk(r4, r0, r1)).a();
        r1.await();
        return (T) r0.get();
    }
}
