package com.bytedance.sdk.account.network.dispatcher;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BlockingQueue<IRequest> f3127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<IRequest> f3128b;
    private volatile boolean c;

    public b(BlockingQueue<IRequest> r3, BlockingQueue<IRequest> r4) {
        BlockingQueue<IRequest> r5 = (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r3, BlockingQueue.class, "com.obric.memorydata.plugin");
        BlockingQueue<IRequest> r6 = (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r4, BlockingQueue.class, "com.obric.memorydata.plugin");
        super("ApiLocalDispatcher-Thread");
        this.c = false;
        this.f3127a = r5;
        this.f3128b = r6;
    }

    public void a() {
        this.c = true;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
    L40:
        IRequest r2 = (IRequest) ZeusTransformUtils.preCheckCast(this.f3127a.take(), IRequest.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L35
        c r3 = null;
        if (ZeusTransformUtils.instanceOf(r2, c.class) == false) goto L7;
        r3 = (c) ZeusTransformUtils.preCheckCast(r2, c.class, "com.obric.memorydata.plugin");
    L7:
        if (r3 == null) goto L40;
        String r4 = Thread.currentThread().getName();
        String r5 = r3.b();
        if (r3.a() == true) goto L40;
        if (h.a(r5) == true) goto L19;
        if (h.a(r4) == true) goto L19;
        Thread.currentThread().setName("ApiLocalDispatcher-" + r5);     // Catch: Throwable -> L28
    L19:
        if (Logger.debug() == false) goto L22;
        Logger.d("ApiLocalDispatcher", "run4Local " + r5 + ", queue size: " + this.f3127a.size() + " " + this.f3128b.size());     // Catch: Throwable -> L28
    L22:
        if (r3.e() == true) goto L31;
        if (r3.g() != IRequest.Priority.IMMEDIATE) goto L26;
        com.bytedance.common.utility.a.c.a(r3);     // Catch: Throwable -> L28
        goto L31
    L26:
        r3.i();     // Catch: Throwable -> L28
        this.f3128b.add(r3);     // Catch: Throwable -> L28
    L31:
        if (h.a(r5) == true) goto L40;
        if (h.a(r4) == true) goto L40;
        Thread.currentThread().setName(r4);
    L28:
        th = move-exception;
        Logger.e("ApiLocalDispatcher", "Unhandled exception: " + th);
    L36:
        if (this.c == false) goto L40;
    }
}
