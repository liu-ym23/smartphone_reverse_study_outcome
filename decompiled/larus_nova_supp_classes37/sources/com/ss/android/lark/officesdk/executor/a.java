package com.ss.android.lark.officesdk.executor;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements ThreadFactory {
    public final ThreadFactory a;
    public final /* synthetic */ int b;

    public a(int r1) {
        this.b = r1;
        this.a = Executors.defaultThreadFactory();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r2) {
        Thread r3 = this.a.newThread(r2);
        ThreadMethodProxy.setPriority(r3, this.b);
        ThreadMethodProxy.setName(r3, "OfficeSDK_HighPrioritySingleThread");
        Intrinsics.checkNotNull(r3);
        return r3;
    }
}
