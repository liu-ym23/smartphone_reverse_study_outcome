package com.bytedance.sdk.account.network.dispatcher;

import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class a extends Thread implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static e f3125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final AtomicInteger f3126b = null;
    protected WeakHandler c;
    private final BlockingQueue<IRequest> d;
    private volatile boolean e;
    private volatile boolean f;
    private String g;

    static {
        f3125a = e.a();
        f3126b = new AtomicInteger();
    }

    public a(BlockingQueue<IRequest> r3, String r4, String r5) {
        BlockingQueue<IRequest> r6 = (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r3, BlockingQueue.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        r4 = "ApiDispatcher-Thread";
    L5:
        super(r4);
        this.c = new WeakHandler(Looper.getMainLooper(), this);
        this.e = false;
        this.f = false;
        this.g = "ApiDispatcher";
        this.d = r6;
        this.g = r5;
    }

    private void b(c r8) {
        String r2 = null;
        this.f = true;     // Catch: Throwable -> L17
        a(r8);     // Catch: Throwable -> L17
        if (r8.a() == false) goto L7;
        this.f = false;     // Catch: Throwable -> L17
        return;
    L7:
        String r0 = Thread.currentThread().getName();     // Catch: Throwable -> L17
        r2 = r8.b();     // Catch: Throwable -> L15
        if (h.a(r2) == false) goto L11;
    L13:
        Logger.d(this.g, "thread (inc) count: " + f3126b.incrementAndGet());     // Catch: Throwable -> L15
        r8.run();     // Catch: Throwable -> L15
        c();     // Catch: Throwable -> L15
    L20:
        this.f = false;
        if (h.a(r2) == false) goto L23;
    L25:
        Logger.d(this.g, "thread (dec) count: " + f3126b.decrementAndGet());
        return;
    L23:
        if (h.a(r0) == true) goto L25;
        Thread.currentThread().setName(r0);
        goto L25
    L11:
        if (h.a(r0) == true) goto L13;
        Thread.currentThread().setName(r2);     // Catch: Throwable -> L15
    L15:
        th = th;
        String r6 = r2;
        r2 = r0;
        String r1 = r6;
    L19:
        Logger.e(this.g, "Unhandled exception: " + th);
        String r7 = r2;
        r2 = r1;
        r0 = r7;
    L17:
        th = th;
        r1 = null;
        goto L19
    }

    public void a() {
        this.e = true;
        interrupt();
    }

    public void a(c r1) {
        if (r1 == null) goto L5;
        r1.j();
        return;
    }

    public boolean b() {
        return this.f;
    }

    public void c() {
        d();
        this.c.sendEmptyMessageDelayed(0, 2000);
    }

    public void d() {
        this.c.removeMessages(0);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
        if (r1 != null) goto L12;
        return;
    L12:
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r1.what != 0) goto L14;
        f3125a.g();     // Catch: Throwable -> L9
        return;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
    L12:
        IRequest r1 = (IRequest) ZeusTransformUtils.preCheckCast(this.d.take(), IRequest.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L9
        d();     // Catch: InterruptedException -> L9
        if (r1 == null) goto L12;
        if (ZeusTransformUtils.instanceOf(r1, c.class) == false) goto L12;
        b((c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.memorydata.plugin"));
    L10:
        if (this.e == false) goto L12;
    }
}
