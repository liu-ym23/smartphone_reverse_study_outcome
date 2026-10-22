package com.bytedance.android.live.initialize;

import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\nR\u001b\u0010\u0010\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0011\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/initialize/WTOThreadPoolHelper;", "", "()V", "higPriorityThreadPoolSize", "", "getHigPriorityThreadPoolSize", "()I", "mCpuMixedCommonThreadPool", "Ljava/util/concurrent/ExecutorService;", "getMCpuMixedCommonThreadPool", "()Ljava/util/concurrent/ExecutorService;", "mCpuMixedCommonThreadPool$delegate", "Lkotlin/Lazy;", "mCpuMixedHighPriorityThreadPool", "getMCpuMixedHighPriorityThreadPool", "mCpuMixedHighPriorityThreadPool$delegate", "mIOThreadPool", "getMIOThreadPool", "mIOThreadPool$delegate", "live-initialize-scheduler_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WTOThreadPoolHelper {
    public static final WTOThreadPoolHelper INSTANCE = null;
    private static final int higPriorityThreadPoolSize = 0;
    private static final Lazy mCpuMixedCommonThreadPool$delegate = null;
    private static final Lazy mCpuMixedHighPriorityThreadPool$delegate = null;
    private static final Lazy mIOThreadPool$delegate = null;

    private WTOThreadPoolHelper() {
    }

    public final ExecutorService getMCpuMixedCommonThreadPool() {
        return (ExecutorService) mCpuMixedCommonThreadPool$delegate.getValue();
    }

    public final ExecutorService getMCpuMixedHighPriorityThreadPool() {
        return (ExecutorService) mCpuMixedHighPriorityThreadPool$delegate.getValue();
    }

    public final ExecutorService getMIOThreadPool() {
        return (ExecutorService) mIOThreadPool$delegate.getValue();
    }

    static {
        INSTANCE = new WTOThreadPoolHelper();
        higPriorityThreadPoolSize = 5;
        mCpuMixedCommonThreadPool$delegate = LazyKt.lazy(WTOThreadPoolHelper$mCpuMixedCommonThreadPool$2.INSTANCE);
        mIOThreadPool$delegate = LazyKt.lazy(WTOThreadPoolHelper$mIOThreadPool$2.INSTANCE);
        mCpuMixedHighPriorityThreadPool$delegate = LazyKt.lazy(WTOThreadPoolHelper$mCpuMixedHighPriorityThreadPool$2.INSTANCE);
    }

    public final int getHigPriorityThreadPoolSize() {
        return higPriorityThreadPoolSize;
    }
}
