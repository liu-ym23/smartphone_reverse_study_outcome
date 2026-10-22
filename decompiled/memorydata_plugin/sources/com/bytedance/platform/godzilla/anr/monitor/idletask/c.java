package com.bytedance.platform.godzilla.anr.monitor.idletask;

import android.os.MessageQueue;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MessageQueue.IdleHandler f2984a;

    public c(MessageQueue.IdleHandler r3) {
        this.f2984a = (MessageQueue.IdleHandler) ZeusTransformUtils.wrapperContextForParams(r3, MessageQueue.IdleHandler.class, "com.obric.memorydata.plugin");
    }

    public MessageQueue.IdleHandler a() {
        return this.f2984a;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public boolean queueIdle() {
        String r0 = this.f2984a.getClass().getName();
        a.a(">>>>> Dispatching to IdleTask " + r0);
        long r1 = System.currentTimeMillis();
        boolean r6 = this.f2984a.queueIdle();
        a.a("<<<<< Finished to IdleTask " + r0);
        b.a().b().a(r0, System.currentTimeMillis() - r1);
        return r6;
    }
}
