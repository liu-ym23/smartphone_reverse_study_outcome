package com.bytedance.common.wschannel;

import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;

/* JADX INFO: loaded from: classes.dex */
public class g implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile g f1307c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static WeakHandler f1308g;

    private g() {
        if (f1308g != null) goto L10;
        f1308g = PushThreadHandlerManager.inst().getHandler();     // Catch: Throwable -> L6
        return;
    L6:
        HandlerThread r10 = new HandlerThread("WsHT");
        r10.start();
        f1308g = new WeakHandler(r10.getLooper(), this);
        return;
    }

    public static g b() {
        if (f1307c != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1307c != null) goto L9;
        f1307c = new g();     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f1307c;
    }

    public WeakHandler a() {
        return f1308g;
    }

    public void c(Runnable r10) {
        d(r10, 0);
    }

    public void d(Runnable r10, long r11) {
        if (r11 > 0) goto L5;
        f1308g.post(r10);
        return;
    L5:
        f1308g.postDelayed(r10, r11);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
    }
}
