package com.ss.android.lark.passportc.internal;

import com.larksuite.framework.thread.CoreThreadPool;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DefaultPassportExecutorsKt {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Executor c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    static {
        a = LazyKt.lazy(DefaultPassportExecutorsKt$PASSPORT_WORKER_EXECUTOR$2.INSTANCE);
        b = LazyKt.lazy(DefaultPassportExecutorsKt$BACKGROUND_WORKER_EXECUTOR$2.INSTANCE);
        c = CoreThreadPool.getDefault().getUIExecutor();
        d = LazyKt.lazy(DefaultPassportExecutorsKt$PASSPORT_PARALLEL_EXECUTOR$2.INSTANCE);
        e = LazyKt.lazy(DefaultPassportExecutorsKt$PASSPORT_PARALLEL_SCHEDULER$2.INSTANCE);
    }
}
