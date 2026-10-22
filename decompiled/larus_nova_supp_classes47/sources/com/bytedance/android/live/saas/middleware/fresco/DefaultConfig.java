package com.bytedance.android.live.saas.middleware.fresco;

import android.app.ActivityManager;
import android.app.Application;
import com.bytedance.common.utility.concurrent.SimpleThreadFactory;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.PriorityThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/fresco/DefaultConfig;", "", "()V", "MAX_CACHE_ENTRIES", "", "MAX_CACHE_ENTRY_SIZE", "MAX_EVICTION_QUEUE_ENTRIES", "MAX_EVICTION_QUEUE_SIZE", "assignExecutorThreadFactory", "", "executor", "Ljava/util/concurrent/Executor;", "priorityThreadFactoryWrapper", "Lcom/facebook/imagepipeline/core/PriorityThreadFactory;", "simpleThreadFactory", "Lcom/bytedance/common/utility/concurrent/SimpleThreadFactory;", "assignFrescoException", "config", "Lcom/facebook/imagepipeline/core/ImagePipelineConfig;", "getDefaultExecutorSupplier", "Lcom/facebook/imagepipeline/core/ExecutorSupplier;", "getMaxCache", "applicationContext", "Landroid/app/Application;", "getMemoryCache", "Lcom/facebook/imagepipeline/cache/MemoryCacheParams;", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class DefaultConfig {
    public static final DefaultConfig INSTANCE = null;
    public static final int MAX_CACHE_ENTRIES = 256;
    public static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;

    private DefaultConfig() {
    }

    static {
        INSTANCE = new DefaultConfig();
    }

    public final ExecutorSupplier getDefaultExecutorSupplier() {
        return new AnonymousClass1();
    }

    @JvmStatic
    public static final void assignFrescoException(ImagePipelineConfig r4) {
        Intrinsics.checkNotNullParameter(r4, "config");
        ExecutorSupplier r5 = r4.getExecutorSupplier();
        final DefaultConfig$assignFrescoException$uncaughtExceptionHandler$1 r0 = DefaultConfig$assignFrescoException$uncaughtExceptionHandler$1.INSTANCE;
        final int r2 = 10;
        PriorityThreadFactory r1 = new DefaultConfig$assignFrescoException$priorityThreadFactoryWrapper$1(r0, r2);
        final String r3 = "Fresco";
        SimpleThreadFactory r6 = new DefaultConfig$assignFrescoException$simpleThreadFactory$1(r0, r3);
        if (r5 == null) goto L6;
        DefaultConfig r7 = INSTANCE;
        r7.assignExecutorThreadFactory(r5.forLocalStorageRead(), r1, r6);
        r7.assignExecutorThreadFactory(r5.forDecode(), r1, r6);
        r7.assignExecutorThreadFactory(r5.forBackgroundTasks(), r1, r6);
        r7.assignExecutorThreadFactory(r5.forLightweightBackgroundTasks(), r1, r6);
        return;
    }

    @JvmStatic
    public static final int getMaxCache(Application r1) {
        Intrinsics.checkNotNullParameter(r1, "applicationContext");
        Object r2 = r1.getSystemService("activity");
        if (r2 == null) goto L13;
        ActivityManager r3 = (ActivityManager) r2;
        Intrinsics.checkNotNull(r3);
        int r4 = RangesKt.coerceAtMost(r3.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (r4 >= 33554432) goto L8;
        return 4194304;
    L8:
        if (r4 >= 67108864) goto L11;
        return 6291456;
    L11:
        return r4 / 8;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @JvmStatic
    public static final MemoryCacheParams getMemoryCache(Application r7) {
        Intrinsics.checkNotNullParameter(r7, "applicationContext");
        return new MemoryCacheParams(getMaxCache(r7), MAX_CACHE_ENTRIES, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.concurrent.ThreadPoolExecutor] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.concurrent.ThreadFactory] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    private final void assignExecutorThreadFactory(Executor r3, PriorityThreadFactory r4, SimpleThreadFactory r5) {
        if (ThreadPoolExecutor.class.isInstance(r3) == true) goto L5;
        return;
    L5:
        if (r3 == null) goto L15;
        ?? r6 = (ThreadPoolExecutor) r3;
        ?? r7 = r4;
        if (PriorityThreadFactory.class.isInstance(r6.getThreadFactory()) == true) goto L10;
        r7 = r5;
    L10:
        if (r7 != 0) goto L12;
        return;
    L12:
        r6.setThreadFactory(r7);
        return;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.util.concurrent.ThreadPoolExecutor");
    }
}
