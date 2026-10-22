package com.bytedance.common.wschannel;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class h implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f2112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakHandler f2113b;

    private h() {
        if (f2113b != null) goto L10;
        f2113b = PushThreadHandlerManager.inst().getHandler();     // Catch: Throwable -> L6
        return;
    L6:
        HandlerThread r0 = new HandlerThread("WsHT");
        r0.start();
        f2113b = new WeakHandler(r0.getLooper(), this);
        return;
    }

    public static h a() {
        if (f2112a != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2112a != null) goto L9;
        f2112a = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f2112a;
    }

    public void a(Runnable r3) {
        a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), 0);
    }

    public void a(Runnable r3, long r4) {
        Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 > 0) goto L5;
        f2113b.post(r2);
        return;
    L5:
        f2113b.postDelayed(r2, r4);
    }

    public WeakHandler b() {
        return f2113b;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r1) {
    }
}
