package com.ss.ugc.effectplatform;

import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k implements bytekn.foundation.concurrent.executor.a {
    public final ExecutorService a;

    public k(PThreadPoolExecutor r1) {
        this.a = r1;
    }

    public final void execute(Runnable r3) {
        this.a.execute(new a(r3));
    }
}
