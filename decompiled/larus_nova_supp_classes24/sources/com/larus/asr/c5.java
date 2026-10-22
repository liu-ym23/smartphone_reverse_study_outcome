package com.larus.asr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c5 {
    public static final HashSet<String> a = null;
    public static final HashMap<String, Function0<Unit>> b = null;
    public static final Handler c = null;

    static {
        a = new HashSet();
        b = new HashMap();
        c = new Handler(Looper.getMainLooper(), new b5());
    }

    public static void c() {
        FLogger.a.d("StreamAsrSendResultTaskManager", "clearTask");
        c.removeCallbacksAndMessages(null);
        a.clear();
        b.clear();
    }

    public static boolean b(String r3) {
        FLogger.a.d("StreamAsrSendResultTaskManager", "checkAndRemoveTask, taskId = " + r3);
        c.removeMessages(0, r3);
        return a.contains(r3);
    }

    public static void a(String r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.d("StreamAsrSendResultTaskManager", "addTask, taskId = " + r3);
        b.put(r3, r4);
        Handler r5 = c;
        r5.sendMessageDelayed(Message.obtain(r5, 0, r3), com.larus.platform.service.z2.a.getStreamAsrConfig().d());
    }
}
