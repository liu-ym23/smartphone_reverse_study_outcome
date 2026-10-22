package com.bytedance.frameworks.baselib.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class d implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static d f2327a;
    private static AtomicInteger h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakHandler f2328b;
    private ThreadPoolExecutor c;
    private ThreadPoolExecutor d;
    private ThreadPoolExecutor e;
    private ThreadPoolExecutor f;
    private ThreadPoolExecutor g;

    abstract class a implements Comparable<a>, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.bytedance.frameworks.baselib.network.dispatcher.b f2331a;
        final /* synthetic */ d c;

        public a(d r1, com.bytedance.frameworks.baselib.network.dispatcher.b r2) {
            this.c = r1;
            this.f2331a = r2;
        }

        static /* synthetic */ com.bytedance.frameworks.baselib.network.dispatcher.b b(a r0) {
            return r0.f2331a;
        }
    }

    static class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f2332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f2333b;

        b(String r3) {
            this.f2332a = new AtomicInteger(1);
            this.f2333b = "ApiExecutor";
            if (TextUtils.isEmpty(r3) == true) goto L6;
            this.f2333b = r3;
            return;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
            final String r0 = this.f2333b + "#" + this.f2332a.getAndIncrement();
            Thread r1 = new AnonymousClass1(this, r4, r0);
            r1.setDaemon(false);
            return r1;
        }
    }

    static {
        h = new AtomicInteger();
        f2327a = new d();
    }

    private d() {
        this.f2328b = new WeakHandler(Looper.getMainLooper(), this);
    }

    private static int a() {
        return h.incrementAndGet();
    }

    static /* synthetic */ ExecutorService a(d r0) {
        return r0.c();
    }

    private static void a(ThreadPoolExecutor r2, com.bytedance.frameworks.baselib.network.dispatcher.b r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r3, com.bytedance.frameworks.baselib.network.dispatcher.a.class) == false) goto L8;
        ((com.bytedance.frameworks.baselib.network.dispatcher.a) ZeusTransformUtils.preCheckCast(r3, com.bytedance.frameworks.baselib.network.dispatcher.a.class, "com.obric.memorydata.plugin")).b(r2.getQueue().size());
        return;
    }

    private f b() {
        return e.a();
    }

    static /* synthetic */ ExecutorService b(d r0) {
        return r0.d();
    }

    private a c(final com.bytedance.frameworks.baselib.network.dispatcher.b r2) {
        return new AnonymousClass1(this, r2, r2);
    }

    private synchronized ExecutorService c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.c != null) goto L8;
        ThreadPoolExecutor r0 = b().a();     // Catch: Throwable -> L11
        this.c = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        this.c = new ThreadPoolExecutor(b().o(), Integer.MAX_VALUE, b().n(), TimeUnit.SECONDS, new SynchronousQueue(), new b("NetImmediate"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r1 = this.c;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    private synchronized ExecutorService d() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.d != null) goto L8;
        ThreadPoolExecutor r0 = b().c();     // Catch: Throwable -> L11
        this.d = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(b().j(), b().f(), b().l(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("NetNormal"));     // Catch: Throwable -> L11
        this.d = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(e.a().p());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.d;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService e() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.e != null) goto L8;
        ThreadPoolExecutor r0 = b().d();     // Catch: Throwable -> L11
        this.e = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(b().k(), b().g(), b().m(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("NetDownload"));     // Catch: Throwable -> L11
        this.e = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(e.a().p());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.e;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService f() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f != null) goto L8;
        ThreadPoolExecutor r0 = b().e();     // Catch: Throwable -> L11
        this.f = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        ThreadPoolExecutor r1 = new ThreadPoolExecutor(b().h(), b().h(), b().i(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("NetLowest"));     // Catch: Throwable -> L11
        this.f = r1;     // Catch: Throwable -> L11
        r1.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r2 = this.f;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    private synchronized ExecutorService g() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.g != null) goto L8;
        ThreadPoolExecutor r0 = b().b();     // Catch: Throwable -> L11
        this.g = r0;     // Catch: Throwable -> L11
        if (r0 != null) goto L8;
        this.g = new ThreadPoolExecutor(1, 1, b().n(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("NetLocal"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r1 = this.g;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    void a(com.bytedance.frameworks.baselib.network.dispatcher.b r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e() == true) goto L20;
        r5.c(a());
        if (r5.a() != IRequest.Priority.IMMEDIATE) goto L11;
        ExecutorService r4 = c();
    L9:
        r4.execute(r5);
        return;
    L11:
        if (r5.a() != IRequest.Priority.LOWEST) goto L13;
        r4 = f();
        goto L9
    L13:
        long r0 = r5.f();
        if (r0 <= 0) goto L16;
        Message r2 = Message.obtain();
        r2.what = 1;
        r2.obj = r5;
        this.f2328b.sendMessageDelayed(r2, r0);
        return;
    L16:
        a(this.e, r5);
        r4 = e();
        goto L9
    }

    void b(com.bytedance.frameworks.baselib.network.dispatcher.b r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.e() == true) goto L24;
        r5.c(a());
        if (r5.d() == false) goto L10;
        g().execute(c(r5));
        return;
    L10:
        if (r5.a() != IRequest.Priority.IMMEDIATE) goto L14;
        ExecutorService r4 = c();
    L12:
        r4.execute(r5);
        return;
    L14:
        if (r5.a() != IRequest.Priority.LOWEST) goto L16;
        r4 = f();
        goto L12
    L16:
        long r0 = r5.f();
        if (r0 <= 0) goto L19;
        Message r2 = Message.obtain();
        r2.what = 0;
        r2.obj = r5;
        this.f2328b.sendMessageDelayed(r2, r0);
        return;
    L19:
        a(this.d, r5);
        r4 = d();
        goto L12
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (ZeusTransformUtils.instanceOf(r5.obj, Runnable.class) == false) goto L23;
        int r0 = r5.what;     // Catch: Throwable -> L16
        if (r0 != 0) goto L10;
        a(this.d, (com.bytedance.frameworks.baselib.network.dispatcher.b) ZeusTransformUtils.preCheckCast(r5.obj, com.bytedance.frameworks.baselib.network.dispatcher.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        ExecutorService r4 = d();     // Catch: Throwable -> L16
        Runnable r6 = (Runnable) ZeusTransformUtils.preCheckCast(r5.obj, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
    L13:
        r4.execute(r6);     // Catch: Throwable -> L16
        return;
    L10:
        if (r0 != 1) goto L24;
        a(this.e, (com.bytedance.frameworks.baselib.network.dispatcher.b) ZeusTransformUtils.preCheckCast(r5.obj, com.bytedance.frameworks.baselib.network.dispatcher.b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16
        r4 = c();     // Catch: Throwable -> L16
        r6 = (Runnable) ZeusTransformUtils.preCheckCast(r5.obj, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        goto L13
    L24:
        return;
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
