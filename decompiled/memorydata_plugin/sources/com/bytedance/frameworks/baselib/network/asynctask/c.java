package com.bytedance.frameworks.baselib.network.asynctask;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2286b = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2287a;

    static {
    }

    public c(String r3) {
        this.f2287a = "ttnet-" + r3;
    }

    private /* synthetic */ void a(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        Process.setThreadPriority(10);
        r5.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e(f2286b, "NetworkThreadFactory error when running in thread " + this.f2287a, th);
    }

    public static /* synthetic */ void lambda$6aKn1xzccCZhZ2N4TfmTyJJzNj8(c r0, Runnable r1) {
        r0.a(r1);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return new Thread(new $$Lambda$c$6aKn1xzccCZhZ2N4TfmTyJJzNj8(this, r4), this.f2287a);
    }
}
