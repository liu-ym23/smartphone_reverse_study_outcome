package com.bytedance.dataplatform;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ScheduledExecutorService f2266a;

    static {
        f2266a = Executors.newSingleThreadScheduledExecutor();
    }

    public static Future a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        return f2266a.submit(r3);
    }

    public static Future a(Runnable r2, long r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        return f2266a.schedule(r4, r3, TimeUnit.MILLISECONDS);
    }

    public static Future a(Runnable r7, long r8, long r10) {
        Runnable r1 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        return f2266a.scheduleWithFixedDelay(r1, r8, r10, TimeUnit.MILLISECONDS);
    }
}
