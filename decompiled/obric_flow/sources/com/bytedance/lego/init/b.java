package com.bytedance.lego.init;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6724a = null;

    static {
        f6724a = new b();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r10) {
        switch(r10.what) {
            case 1000: goto L14;
            case 1001: goto L13;
            case 1002: goto L12;
            case 1003: goto L11;
            case 1004: goto L10;
            case 1005: goto L9;
            case 1006: goto L8;
            case 1007: goto L7;
            case 1008: goto L6;
            case 1009: goto L5;
            default: goto L15;
        };
    L5:
        CopyOnWriteArrayList r5 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_15min", System.currentTimeMillis() - c.d, true);
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 15min tasks...");
        mh.e.t(DelayTaskDispatcher$mainHandler$1$10.INSTANCE);
        goto L15
    L6:
        CopyOnWriteArrayList r11 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_10min", System.currentTimeMillis() - c.d, true);
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 10min tasks...");
        mh.e.t(DelayTaskDispatcher$mainHandler$1$9.INSTANCE);
        goto L15
    L7:
        CopyOnWriteArrayList r12 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_5min", System.currentTimeMillis() - c.d, true);
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 5min tasks...");
        mh.e.t(DelayTaskDispatcher$mainHandler$1$8.INSTANCE);
        goto L15
    L8:
        CopyOnWriteArrayList r13 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_2min", System.currentTimeMillis() - c.d, true);
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 2min tasks...");
        mh.e.t(DelayTaskDispatcher$mainHandler$1$7.INSTANCE);
        goto L15
    L9:
        CopyOnWriteArrayList r14 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_60s", System.currentTimeMillis() - c.d, true);
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 60s tasks...");
        mh.e.t(DelayTaskDispatcher$mainHandler$1$6.INSTANCE);
        goto L15
    L10:
        CopyOnWriteArrayList r15 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_30s", System.currentTimeMillis() - c.d, true);
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 30s tasks...");
        mh.e.t(DelayTaskDispatcher$mainHandler$1$5.INSTANCE);
        goto L15
    L11:
        CopyOnWriteArrayList r16 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_15s", System.currentTimeMillis() - c.d, true);
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 15s tasks...");
        mh.e.t(DelayTaskDispatcher$mainHandler$1$4.INSTANCE);
        goto L15
    L12:
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 8s tasks...");
        CopyOnWriteArrayList r17 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_8s", System.currentTimeMillis() - c.d, true);
        mh.e.t(DelayTaskDispatcher$mainHandler$1$3.INSTANCE);
        goto L15
    L13:
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 5s tasks...");
        CopyOnWriteArrayList r18 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_5s", System.currentTimeMillis() - c.d, true);
        mh.e.t(DelayTaskDispatcher$mainHandler$1$2.INSTANCE);
        goto L15
    L14:
        com.bytedance.lego.init.util.b.a("DelayTaskDispatcher", "Start dispatch 3s tasks...");
        CopyOnWriteArrayList r19 = com.bytedance.lego.init.monitor.a.f6757a;
        com.bytedance.lego.init.monitor.a.a("Start_Dispatch_3s", System.currentTimeMillis() - c.d, true);
        mh.e.t(DelayTaskDispatcher$mainHandler$1$1.INSTANCE);
    L15:
        return true;
    }
}
