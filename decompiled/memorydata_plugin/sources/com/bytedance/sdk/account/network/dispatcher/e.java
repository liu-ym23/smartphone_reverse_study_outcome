package com.bytedance.sdk.account.network.dispatcher;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f3131a;
    private static volatile e c;
    private static volatile boolean d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f3132b;
    private int e;
    private int f;
    private final PriorityBlockingQueue<IRequest> g;
    private final PriorityBlockingQueue<IRequest> h;
    private final PriorityBlockingQueue<IRequest> i;
    private a[] j;
    private d[] k;
    private b l;
    private volatile long m;
    private volatile long n;
    private volatile long o;
    private volatile long p;

    static {
        f3131a = new AtomicInteger();
        d = true;
    }

    public e() {
        this(4, 4, true);
    }

    public e(int r3, int r4, boolean r5) {
        this.f3132b = false;
        this.g = new PriorityBlockingQueue();
        this.h = new PriorityBlockingQueue();
        this.i = new PriorityBlockingQueue();
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.e = r3;
        this.j = new a[r3 * 4];
        if (r5 == false) goto L6;
        this.f = r4;
        this.k = new d[r4 * 4];
        return;
    }

    public e(boolean r3) {
        this(4, 0, r3);
    }

    public static e a() {
        if (c != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new e(false);     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public static int b() {
        return f3131a.incrementAndGet();
    }

    public synchronized void a(c r3) {
        monitor-enter(this);
        if (r3 != null) goto L18;
        monitor-exit(this);
        return;
    L18:
        r3.a(b());     // Catch: Throwable -> L15
        if (this.f3132b == true) goto L10;
        c();     // Catch: Throwable -> L15
    L10:
        if (r3.g() != IRequest.Priority.IMMEDIATE) goto L12;
        com.bytedance.common.utility.a.c.a(r3);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L12:
        r3.k();     // Catch: Throwable -> L15
        this.i.add(r3);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void b(c r3) {
        monitor-enter(this);
        if (r3 != null) goto L23;
        monitor-exit(this);
        return;
    L23:
        r3.a(b());     // Catch: Throwable -> L20
        if (this.f3132b == true) goto L10;
        c();     // Catch: Throwable -> L20
    L10:
        if (r3.d() == false) goto L14;
        PriorityBlockingQueue<IRequest> r0 = this.g;     // Catch: Throwable -> L20
    L12:
        r0.add(r3);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L14:
        if (r3.g() != IRequest.Priority.IMMEDIATE) goto L16;
        com.bytedance.common.utility.a.c.a(r3);     // Catch: Throwable -> L20
        goto L18
    L16:
        r3.i();     // Catch: Throwable -> L20
        r0 = this.h;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized void c() {
        monitor-enter(this);
        d();     // Catch: Throwable -> L15
        b r0 = new b(this.g, this.h);     // Catch: Throwable -> L15
        this.l = r0;     // Catch: Throwable -> L15
        r0.start();     // Catch: Throwable -> L15
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r2 >= this.e) goto L8;
        a r3 = new a(this.h, "Account-ApiDispatcher-Thread", "ApiDispatcher");     // Catch: Throwable -> L15
        this.j[r2] = r3;     // Catch: Throwable -> L15
        r3.start();     // Catch: Throwable -> L15
        r2 = r2 + 1;     // Catch: Throwable -> L15
        goto L5
    L8:
        if (this.k != null) goto L10;
    L12:
        this.f3132b = true;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L10:
        if (r1 >= this.f) goto L12;
        d r4 = new d(this.i, "Account-DownloadDispatcher-Thread", "DownloadDispatcher");     // Catch: Throwable -> L15
        this.k[r1] = r4;     // Catch: Throwable -> L15
        r4.start();     // Catch: Throwable -> L15
        r1 = r1 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void d() {
        monitor-enter(this);
        int r0 = 0;
        this.f3132b = false;     // Catch: Throwable -> L24
        b r1 = this.l;     // Catch: Throwable -> L24
        if (r1 == null) goto L7;
        r1.a();     // Catch: Throwable -> L24
    L7:
        int r2 = 0;
    L8:
        a[] r3 = this.j;     // Catch: Throwable -> L24
        if (r2 >= r3.length) goto L15;
        if (r3[r2] == null) goto L13;
        r3[r2].a();     // Catch: Throwable -> L24
        this.j[r2] = null;     // Catch: Throwable -> L24
    L13:
        r2 = r2 + 1;     // Catch: Throwable -> L24
        goto L8
    L15:
        if (this.k == null) goto L22;
    L16:
        d[] r4 = this.k;     // Catch: Throwable -> L24
        if (r0 >= r4.length) goto L22;
        if (r4[r0] == null) goto L21;
        r4[r0].a();     // Catch: Throwable -> L24
        this.k[r0] = null;     // Catch: Throwable -> L24
    L21:
        r0 = r0 + 1;
    L22:
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized void e() {
        monitor-enter(this);
    L26:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L30:
        th = move-exception;
        throw th;
    L4:
        if (d == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger.d("RequestQueue", "handleExpandRequestQueueSize");     // Catch: Throwable -> L26
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L26
        if (this.m <= r0) goto L11;
        this.m = r0;     // Catch: Throwable -> L26
    L11:
        if ((r0 - this.m) > 1000) goto L15;
        Logger.d("RequestQueue", "handleExpandRequestQueueSize (now - mLastExpandRequestQueueTime) <= ApiThread.ENQUEUE_EXPIRE");     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L15:
        this.m = r0;     // Catch: Throwable -> L26
        int r1 = 0;
        int r2 = 0;
    L16:
        a[] r3 = this.j;     // Catch: Throwable -> L26
        if (r1 >= r3.length) goto L28;
        if (r3[r1] != null) goto L25;
        r2 = r2 + 1;     // Catch: Throwable -> L26
        if (r2 > this.e) goto L28;
        a r4 = new a(this.h, "Account-ApiDispatcher-Thread", "ApiDispatcher");     // Catch: Throwable -> L26
        Logger.d("RequestQueue", "apiDispatcher : " + r4.toString() + " create");     // Catch: Throwable -> L26
        this.j[r1] = r4;     // Catch: Throwable -> L26
        r4.start();     // Catch: Throwable -> L26
    L25:
        r1 = r1 + 1;
        goto L16
    }

    public synchronized void f() {
        monitor-enter(this);
    L30:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L34
    L32:
        monitor-exit(this);
        return;
    L34:
        th = move-exception;
        throw th;
    L4:
        if (d == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger.d("RequestQueue", "handleExpandDownloadRequestQueueSize");     // Catch: Throwable -> L30
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L30
        if (this.n <= r0) goto L11;
        this.n = r0;     // Catch: Throwable -> L30
    L11:
        if ((r0 - this.n) > 1000) goto L15;
        Logger.d("RequestQueue", "handleExpandDownloadRequestQueueSize (now - mLastExpandDownloadRequestQueueTime) <= ApiThread.ENQUEUE_EXPIRE");     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L15:
        this.n = r0;     // Catch: Throwable -> L30
        if (this.k != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        int r1 = 0;
        int r2 = 0;
    L20:
        d[] r3 = this.k;     // Catch: Throwable -> L30
        if (r1 >= r3.length) goto L32;
        if (r3[r1] != null) goto L29;
        r2 = r2 + 1;     // Catch: Throwable -> L30
        if (r2 > this.f) goto L32;
        d r4 = new d(this.i, "Account-DownloadDispatcher-Thread", "DownloadDispatcher");     // Catch: Throwable -> L30
        Logger.d("RequestQueue", "downloadDispatcher : " + r4.toString() + " create");     // Catch: Throwable -> L30
        this.k[r1] = r4;     // Catch: Throwable -> L30
        r4.start();     // Catch: Throwable -> L30
    L29:
        r1 = r1 + 1;
        goto L20
    }

    public synchronized void g() {
        monitor-enter(this);
    L47:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L51
    L49:
        monitor-exit(this);
        return;
    L51:
        th = move-exception;
        throw th;
    L4:
        if (d == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger.d("RequestQueue", "handleShrinkRequestQueueSize");     // Catch: Throwable -> L47
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L47
        if (this.o <= r0) goto L11;
        this.o = r0;     // Catch: Throwable -> L47
    L11:
        if ((r0 - this.o) > 2000) goto L15;
        Logger.d("RequestQueue", "handleShrinkRequestQueueSize (now - mLastShrinkRequestQueueTime) <= ApiDispatcher.SHRINK_EXPIRE");     // Catch: Throwable -> L47
        monitor-exit(this);
        return;
    L15:
        int r2 = this.j.length - 1;     // Catch: Throwable -> L47
        boolean r4 = true;
        boolean r5 = true;
    L17:
        if (r2 < this.e) goto L26;
        a r6 = this.j[r2];     // Catch: Throwable -> L47
        if (r6 != null) goto L21;
    L23:
        if (r6 == null) goto L25;
        r5 = false;
    L25:
        r2 = r2 - 1;     // Catch: Throwable -> L47
        goto L17
    L21:
        if (r6.b() == false) goto L23;
        r4 = false;
        goto L23
    L26:
        this.o = r0;     // Catch: Throwable -> L47
        if (r4 == false) goto L44;
        if (r5 == true) goto L44;
        int r1 = this.j.length - 1;     // Catch: Throwable -> L47
    L32:
        if (r1 < this.e) goto L49;
        a r3 = this.j[r1];     // Catch: Throwable -> L41
        if (r3 == null) goto L43;
        if (r3.getState() == Thread.State.RUNNABLE) goto L43;
        if (r3.b() == true) goto L43;
        Logger.d("RequestQueue", "apiDispatcher : " + r3.toString() + " quit");     // Catch: Throwable -> L41
        r3.a();     // Catch: Throwable -> L41
        this.j[r1] = null;     // Catch: Throwable -> L41
    L43:
        r1 = r1 - 1;     // Catch: Throwable -> L47
    L41:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L47
    L44:
        Logger.d("RequestQueue", "handleShrinkRequestQueueSize shouldShrink = " + r4 + " allNull = " + r5);     // Catch: Throwable -> L47
        monitor-exit(this);
    }

    public synchronized void h() {
        monitor-enter(this);
    L51:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L55
    L53:
        monitor-exit(this);
        return;
    L55:
        th = move-exception;
        throw th;
    L4:
        if (d == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        Logger.d("RequestQueue", "handleShrinkDownloadRequestQueueSize");     // Catch: Throwable -> L51
        long r0 = System.currentTimeMillis();     // Catch: Throwable -> L51
        if (this.p <= r0) goto L11;
        this.p = r0;     // Catch: Throwable -> L51
    L11:
        if ((r0 - this.p) > 2000) goto L15;
        Logger.d("RequestQueue", "handleShrinkDownloadRequestQueueSize (now - mLastShrinkDownloadRequestQueueTime) <= ApiDispatcher.SHRINK_EXPIRE");     // Catch: Throwable -> L51
        monitor-exit(this);
        return;
    L15:
        d[] r2 = this.k;     // Catch: Throwable -> L51
        if (r2 != null) goto L19;
        monitor-exit(this);
        return;
    L19:
        int r3 = r2.length - 1;     // Catch: Throwable -> L51
        boolean r4 = true;
        boolean r5 = true;
    L21:
        if (r3 < this.f) goto L30;
        d r6 = this.k[r3];     // Catch: Throwable -> L51
        if (r6 != null) goto L25;
    L27:
        if (r6 == null) goto L29;
        r5 = false;
    L29:
        r3 = r3 - 1;     // Catch: Throwable -> L51
        goto L21
    L25:
        if (r6.b() == false) goto L27;
        r4 = false;
        goto L27
    L30:
        this.p = r0;     // Catch: Throwable -> L51
        if (r4 == false) goto L48;
        if (r5 == true) goto L48;
        int r1 = this.k.length - 1;     // Catch: Throwable -> L51
    L36:
        if (r1 < this.f) goto L53;
        d r7 = this.k[r1];     // Catch: Throwable -> L45
        if (r7 == null) goto L47;
        if (r7.getState() == Thread.State.RUNNABLE) goto L47;
        if (r7.b() == true) goto L47;
        Logger.d("RequestQueue", "apiDispatcher : " + r7.toString() + " quit");     // Catch: Throwable -> L45
        r7.a();     // Catch: Throwable -> L45
        this.k[r1] = null;     // Catch: Throwable -> L45
    L47:
        r1 = r1 - 1;     // Catch: Throwable -> L51
    L45:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L51
    L48:
        Logger.d("RequestQueue", "handleShrinkDownloadRequestQueueSize shouldShrink " + r4 + " allNull = " + r5);     // Catch: Throwable -> L51
        monitor-exit(this);
    }
}
