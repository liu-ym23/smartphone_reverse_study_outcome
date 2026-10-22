package com.obric.datatransfer.client;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements ThreadFactory {
    public final AtomicInteger a;

    public d() {
        this.a = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "r");
        return new PthreadThreadV2(r5, "transfer-file-" + this.a.getAndIncrement());
    }
}
