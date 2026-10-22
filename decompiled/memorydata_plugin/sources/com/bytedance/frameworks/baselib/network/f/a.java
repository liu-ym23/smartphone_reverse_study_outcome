package com.bytedance.frameworks.baselib.network.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Handler f2348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static HashMap<String, HandlerThread> f2349b;
    private static List<String> c;
    private static List<String> d;
    private static Map<String, String> e;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.f.a$a, reason: collision with other inner class name */
    public static class HandlerThreadC0123a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f2350a;

        public HandlerThreadC0123a(String r1, int r2) {
            super(r1, r2);
            this.f2350a = false;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f2350a == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f2350a = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    static {
        f2348a = new Handler(Looper.getMainLooper());
        f2349b = new HashMap();
        c = Arrays.asList(new String[]{"NpthHandlerThread", "NewVideo-HandlerThread", "trace_time_update_thread"});
        d = Arrays.asList(new String[]{"DBHelper-AsyncOp-New"});
        e = new HashMap();
    }

    public static HandlerThread a(String r2) {
        return a(r2, 0, "");
    }

    public static HandlerThread a(String r3, int r4, String r5) {
        Iterator<Map.Entry<String, HandlerThread>> r6 = f2349b.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        if (((HandlerThread) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), HandlerThread.class, "com.obric.memorydata.plugin")).isAlive() == true) goto L4;
        r6.remove();
        goto L4
    L8:
        HandlerThread r7 = (HandlerThread) ZeusTransformUtils.preCheckCast(f2349b.get(r3), HandlerThread.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L17;
        HandlerThreadC0123a r8 = new HandlerThreadC0123a(r3, r4);
        r8.start();
        f2349b.put(r3, r8);
        return r8;
    L17:
        return r7;
    }
}
