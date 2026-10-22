package com.tencent.wcdb.utils.leak;

import android.os.Handler;
import android.util.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import tpc.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class HandleLeakUtil implements IHandleLeak {
    public static final long DELAY_INTERVAL = 0;
    public static final String TAG = "WCDB2_Handler_Leak";
    public static boolean enableCheckHandleLeak;
    private static IHandleLeak inst;
    private final ConcurrentHashMap<String, Runnable> handleLeakHashMap;
    private final Handler handler;

    public static /* synthetic */ void a(String r0) {
        lambda$startTimer$0(r0);
    }

    private static /* synthetic */ void lambda$startTimer$0(String r0) {
    }

    static {
        DELAY_INTERVAL = TimeUnit.SECONDS.toMillis(10);
    }

    public static IHandleLeak inst() {
        IHandleLeak r0 = inst;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (enableCheckHandleLeak == false) goto L8;
        inst = new HandleLeakUtil();
    L10:
        return inst;
    L8:
        inst = new HandleLeakNoop();
        goto L10
    }

    public HandleLeakUtil() {
        this.handleLeakHashMap = new ConcurrentHashMap();
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("handlerCheck");
        ThreadMethodProxy.start(r0);
        this.handler = new Handler(r0.getLooper());
    }

    @Override // com.tencent.wcdb.utils.leak.IHandleLeak
    public void cancelTimer(String r3) {
        Runnable r0 = this.handleLeakHashMap.get(r3);
        if (r0 == null) goto L6;
        this.handler.removeCallbacks(r0);
        this.handleLeakHashMap.remove(r3);
        return;
    }

    @Override // com.tencent.wcdb.utils.leak.IHandleLeak
    public void startTimer(String r5) {
        if (this.handleLeakHashMap.containsKey(r5) == false) goto L5;
        return;
    L5:
        final String r0 = Log.getStackTraceString(new RuntimeException("handleLeak=" + r5 + "_tid=" + ThreadMethodProxy.currentThread().getId() + "_tName=" + ThreadMethodProxy.currentThread().getName()));
        Runnable r1 = new a(r0);
        this.handleLeakHashMap.put(r5, r1);
        this.handler.postDelayed(r1, DELAY_INTERVAL);
    }
}
