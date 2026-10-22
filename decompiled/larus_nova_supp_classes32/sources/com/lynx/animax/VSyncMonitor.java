package com.lynx.animax;

import android.os.Build;
import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class VSyncMonitor {
    public VSyncMonitor() {
    }

    private static native void nativeInvokeCallback(long r0);

    public static void requestVSync() {
        Runnable r0 = new b0();
        Handler r1 = y4a.d.a();
        Message r2 = Message.obtain(r1, r0);
        if (Build.VERSION.SDK_INT < 22) goto L5;
        r2.setAsynchronous(true);
    L5:
        r1.sendMessageAtFrontOfQueue(r2);
    }

    public static void a(long r0) {
        nativeInvokeCallback(r0);
    }
}
