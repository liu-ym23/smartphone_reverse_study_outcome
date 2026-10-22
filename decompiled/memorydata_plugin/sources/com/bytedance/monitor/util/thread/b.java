package com.bytedance.monitor.util.thread;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static c a() {
        return a.a();
    }

    public static d a(final AsyncTaskType r2, final String r3, Runnable r4) {
        final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r3, r2, r5);
    }

    public static d a(String r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return a(AsyncTaskType.LIGHT_WEIGHT, r2, r4);
    }

    public static String a(d r2) {
        d r3 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return "null";
    L7:
        return r3.a() + ", " + r3.b();
    }

    public static void a(e r4, String r5, String r6) {
        e r7 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.a() == false) goto L9;
        String r0 = Thread.currentThread().getName();
        r7.a(r5, String.format(Locale.CHINA, "[callerThread: %s] \n %s", new Object[]{r0, r6}));
        return;
    }
}
