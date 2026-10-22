package com.bytedance.frameworks.baselib.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class b implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static AtomicInteger f1558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static b f1559m;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakHandler f1560c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ThreadPoolExecutor f1561g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ThreadPoolExecutor f1562h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ThreadPoolExecutor f1563i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ThreadPoolExecutor f1564j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ThreadPoolExecutor f1565k;

    class a extends AbstractRunnableC0054b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n2.a f1566g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ b f1567h;

        a(b r10, n2.a r11, n2.a r12) {
            this.f1567h = r10;
            this.f1566g = r12;
            super(r10, r11);
        }

        public int b(AbstractRunnableC0054b r10) {
            n2.a r11 = this.f1566g;
            if (r11 != null) goto L5;
            return 0;
        L5:
            return r11.compareTo(AbstractRunnableC0054b.a(r10));
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(AbstractRunnableC0054b r10) {
            return b(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1566g.f() == false) goto L5;
            return;
        L5:
            if (this.f1566g.a() != IRequest.Priority.IMMEDIATE) goto L7;
            ExecutorService r10 = b.a(this.f1567h);
        L8:
            r10.execute(this.f1566g);
            return;
        L7:
            r10 = b.b(this.f1567h);
            goto L8
        }
    }

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.dispatcher.b$b, reason: collision with other inner class name */
    abstract class AbstractRunnableC0054b implements Runnable, Comparable<AbstractRunnableC0054b> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private n2.a f1568c;

        public AbstractRunnableC0054b(b r10, n2.a r11) {
            this.f1568c = r11;
        }

        static /* synthetic */ n2.a a(AbstractRunnableC0054b r10) {
            return r10.f1568c;
        }
    }

    static class c implements ThreadFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicInteger f1569c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f1570g;

        class a extends Thread {
            a(c r10, Runnable r11, String r12) {
                super(r11, r12);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        c(String r10) {
            this.f1569c = new AtomicInteger(1);
            this.f1570g = "ApiExecutor";
            if (TextUtils.isEmpty(r10) == true) goto L6;
            this.f1570g = r10;
            return;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            a r11 = new a(this, r10, this.f1570g + "#" + this.f1569c.getAndIncrement());
            r11.setDaemon(false);
            return r11;
        }
    }

    static {
        f1558l = new AtomicInteger();
        f1559m = new b();
    }

    private b() {
        this.f1560c = new WeakHandler(Looper.getMainLooper(), this);
    }

    static /* synthetic */ ExecutorService a(b r10) {
        return r10.g();
    }

    static /* synthetic */ ExecutorService b(b r10) {
        return r10.e();
    }

    private synchronized ExecutorService e() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1562h != null) goto L8;
        ThreadPoolExecutor r10 = l().o();     // Catch: Throwable -> L11
        this.f1562h = r10;     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        ThreadPoolExecutor r11 = new ThreadPoolExecutor(l().b(), l().m(), l().a(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new c("NetNormal"));     // Catch: Throwable -> L11
        this.f1562h = r11;     // Catch: Throwable -> L11
        r11.allowCoreThreadTimeOut(com.bytedance.frameworks.baselib.network.dispatcher.c.d().p());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r12 = this.f1562h;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    }

    private synchronized ExecutorService f() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1563i != null) goto L8;
        ThreadPoolExecutor r10 = l().g();     // Catch: Throwable -> L11
        this.f1563i = r10;     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        ThreadPoolExecutor r11 = new ThreadPoolExecutor(l().c(), l().n(), l().f(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new c("NetDownload"));     // Catch: Throwable -> L11
        this.f1563i = r11;     // Catch: Throwable -> L11
        r11.allowCoreThreadTimeOut(com.bytedance.frameworks.baselib.network.dispatcher.c.d().p());     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r12 = this.f1563i;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    }

    private synchronized ExecutorService g() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1561g != null) goto L8;
        ThreadPoolExecutor r10 = l().i();     // Catch: Throwable -> L11
        this.f1561g = r10;     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        this.f1561g = new ThreadPoolExecutor(l().d(), Integer.MAX_VALUE, l().h(), TimeUnit.SECONDS, new SynchronousQueue(), new c("NetImmediate"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r11 = this.f1561g;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11;
    }

    private synchronized ExecutorService h() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1565k != null) goto L8;
        ThreadPoolExecutor r10 = l().j();     // Catch: Throwable -> L11
        this.f1565k = r10;     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        this.f1565k = new ThreadPoolExecutor(1, 1, l().h(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new c("NetLocal"));     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r11 = this.f1565k;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11;
    }

    private synchronized ExecutorService i() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f1564j != null) goto L8;
        ThreadPoolExecutor r10 = l().l();     // Catch: Throwable -> L11
        this.f1564j = r10;     // Catch: Throwable -> L11
        if (r10 != null) goto L8;
        ThreadPoolExecutor r11 = new ThreadPoolExecutor(l().e(), l().e(), l().k(), TimeUnit.SECONDS, new PriorityBlockingQueue(), new c("NetLowest"));     // Catch: Throwable -> L11
        this.f1564j = r11;     // Catch: Throwable -> L11
        r11.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L8:
        ThreadPoolExecutor r12 = this.f1564j;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    }

    private AbstractRunnableC0054b j(n2.a r10) {
        return new a(this, r10, r10);
    }

    private static int k() {
        return f1558l.incrementAndGet();
    }

    private d l() {
        return com.bytedance.frameworks.baselib.network.dispatcher.c.d();
    }

    private static void m(ThreadPoolExecutor r10, n2.a r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if ((r11 instanceof com.bytedance.frameworks.baselib.network.dispatcher.a) == false) goto L8;
        ((com.bytedance.frameworks.baselib.network.dispatcher.a) r11).i(r10.getQueue().size());
        return;
    }

    void c(n2.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.d() == true) goto L24;
        r10.g(k());
        if (r10.e() == false) goto L10;
        h().execute(j(r10));
        return;
    L10:
        if (r10.a() != IRequest.Priority.IMMEDIATE) goto L14;
        ExecutorService r11 = g();
    L12:
        r11.execute(r10);
        return;
    L14:
        if (r10.a() != IRequest.Priority.LOWEST) goto L16;
        r11 = i();
        goto L12
    L16:
        long r12 = r10.c();
        if (r12 <= 0) goto L19;
        Message r13 = Message.obtain();
        r13.what = 0;
        r13.obj = r10;
        this.f1560c.sendMessageDelayed(r13, r12);
        return;
    L19:
        m(this.f1562h, r10);
        r11 = e();
        goto L12
    }

    void d(n2.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.d() == true) goto L20;
        r10.g(k());
        if (r10.a() != IRequest.Priority.IMMEDIATE) goto L11;
        ExecutorService r11 = g();
    L9:
        r11.execute(r10);
        return;
    L11:
        if (r10.a() != IRequest.Priority.LOWEST) goto L13;
        r11 = i();
        goto L9
    L13:
        long r12 = r10.c();
        if (r12 <= 0) goto L16;
        Message r13 = Message.obtain();
        r13.what = 1;
        r13.obj = r10;
        this.f1560c.sendMessageDelayed(r13, r12);
        return;
    L16:
        m(this.f1563i, r10);
        r11 = f();
        goto L9
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (r10 == null) goto L20;
        Object r11 = r10.obj;
        if ((r11 instanceof Runnable) == false) goto L23;
        int r12 = r10.what;     // Catch: Throwable -> L15
        if (r12 != 0) goto L9;
        m(this.f1562h, (n2.a) r11);     // Catch: Throwable -> L15
        ExecutorService r13 = e();     // Catch: Throwable -> L15
        Runnable r14 = (Runnable) r10.obj;     // Catch: Throwable -> L15
    L12:
        r13.execute(r14);     // Catch: Throwable -> L15
        return;
    L9:
        if (r12 != 1) goto L21;
        m(this.f1563i, (n2.a) r11);     // Catch: Throwable -> L15
        r13 = g();     // Catch: Throwable -> L15
        r14 = (Runnable) r10.obj;     // Catch: Throwable -> L15
        goto L12
    L21:
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    L23:
        return;
    }
}
