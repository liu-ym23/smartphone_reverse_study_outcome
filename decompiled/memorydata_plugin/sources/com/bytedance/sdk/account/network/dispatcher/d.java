package com.bytedance.sdk.account.network.dispatcher;

import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {
    public d(BlockingQueue<IRequest> r3, String r4, String r5) {
        super((BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r3, BlockingQueue.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.a
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.a
    public void a(c r1) {
        if (r1 == null) goto L5;
        r1.l();
        return;
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.a
    public /* bridge */ /* synthetic */ boolean b() {
        return super.b();
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.a
    public void c() {
        d();
        this.c.sendEmptyMessageDelayed(1, 2000);
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.a
    public void d() {
        this.c.removeMessages(1);
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.a, com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
        if (r1 != null) goto L12;
        return;
    L12:
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r1.what != 1) goto L14;
        f3125a.h();     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.sdk.account.network.dispatcher.a, java.lang.Thread, java.lang.Runnable
    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
