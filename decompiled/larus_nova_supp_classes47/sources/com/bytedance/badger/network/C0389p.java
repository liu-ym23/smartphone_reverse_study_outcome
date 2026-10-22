package com.bytedance.badger.network;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
final class C0389p extends Lambda implements Function0 {
    public static final C0389p a = null;

    static {
        a = new C0389p();
    }

    public C0389p() {
        super(0);
    }

    public Object invoke() {
        PThreadScheduledThreadPoolExecutor r0 = new PThreadScheduledThreadPoolExecutor(4, new r0(), new ThreadPoolExecutor.AbortPolicy());
        r0.setRemoveOnCancelPolicy(true);
        r0.setMaximumPoolSize(10);
        r0.setKeepAliveTime(60, TimeUnit.SECONDS);
        r0.allowCoreThreadTimeOut(true);
        return r0;
    }
}
