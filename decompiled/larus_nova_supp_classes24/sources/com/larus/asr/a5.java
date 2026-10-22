package com.larus.asr;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a5 {
    public static final HashMap<String, Function0<Unit>> a = null;
    public static final Handler b = null;

    static {
        a = new HashMap();
        b = new Handler(Looper.getMainLooper(), new z4());
    }

    public static void b() {
        FLogger.a.d("StreamAsrLoadingTaskManager", "clearTask");
        b.removeCallbacksAndMessages(null);
        a.clear();
    }

    public static void c(String r3) {
        FLogger.a.d("StreamAsrLoadingTaskManager", "removeTask, taskId = " + r3);
        b.removeMessages(0, r3);
    }

    public static void a(String r3, Function0 r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        FLogger.a.d("StreamAsrLoadingTaskManager", "addTask, taskId = " + r3);
        a.put(r3, r4);
        Handler r5 = b;
        r5.sendMessageDelayed(Message.obtain(r5, 0, r3), com.larus.platform.service.z2.a.getStreamAsrConfig().e());
    }
}
