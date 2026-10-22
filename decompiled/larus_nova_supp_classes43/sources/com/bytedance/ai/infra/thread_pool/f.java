package com.bytedance.ai.infra.thread_pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f {
    public static final e a = null;
    public static final e b = null;
    public static final e c = null;
    public static final e d = null;
    public static final c e = null;
    public static final e f = null;

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        c5.b r10 = new c5.b("APPLET-IO");
        TimeUnit r17 = TimeUnit.SECONDS;
        SynchronousQueue r11 = new SynchronousQueue();
        ThreadPriority r15 = ThreadPriority.NORMAL;
        a = new e(0, 128, r17, r11, new d("APPLET-IO", r15), r10);
        int r12 = (r0 * 2) + 1;
        int r13 = Math.max(Math.min(r12, 4), Math.min(r0 + 1, 9));
        c5.b r1 = new c5.b("APPLET-CALC");
        e r14 = new e(r13, r12, r17, new LinkedBlockingQueue(256), new d("APPLET-CALC", r15), r1);
        r14.allowCoreThreadTimeOut(true);
        b = r14;
        e r16 = new e(4, 4, 15, r17, new LinkedBlockingQueue(256), new d("APPLET-BACKGROUND", ThreadPriority.LOW));
        r16.allowCoreThreadTimeOut(true);
        c = r16;
        e r18 = new e(1, 1, 30, r17, new LinkedBlockingQueue(), new d("APPLET-SERIAL", r15));
        r18.allowCoreThreadTimeOut(true);
        d = r18;
        e = new c(new d("APPLET-SCHEDULE", r15));
        e r19 = new e(4, 4, 30, r17, new LinkedBlockingQueue(), new d("APPLET-SAFEGUARD", r15));
        r19.allowCoreThreadTimeOut(true);
        f = r19;
    }
}
