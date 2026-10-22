package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread;

import com.larksuite.framework.thread.CoreThreadPool;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MMCoroutines {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(MMCoroutines$coreThreadPool$2.INSTANCE);
    }

    public static ExecutorCoroutineDispatcher a() {
        return ExecutorsKt.from(a.a.getCachedThreadPool());
    }

    public static ExecutorCoroutineDispatcher b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "threadPoolName");
        CoreThreadPool r1 = a.a;
        Intrinsics.checkNotNullParameter(r2, "threadPoolName");
        return ExecutorsKt.from(a.a.getSingleScheduledThreadPool(r2));
    }
}
