package com.obric.memorydata.ability;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/ability/AbilityQueryCallbackExecutor;", "", "<init>", "()V", "TAG", "", "POOL_SIZE", "", "QUEUE_CAPACITY", "threadNumber", "Ljava/util/concurrent/atomic/AtomicInteger;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "execute", "", "dataId", "receiver", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "callback", "Ljava/lang/Runnable;", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f8359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicInteger f8360b = null;
    private static final ThreadPoolExecutor c = null;

    static {
        f8359a = new g();
        f8360b = new AtomicInteger(1);
        c = new ThreadPoolExecutor(2, 2, 30, TimeUnit.SECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(100), BlockingQueue.class, "com.obric.memorydata.plugin"), $$Lambda$g$7pMoWE3x_8c1wFhBY4C4veSPSL4.INSTANCE, (RejectedExecutionHandler) ZeusTransformUtils.preCheckCast(new ThreadPoolExecutor.AbortPolicy(), RejectedExecutionHandler.class, "com.obric.memorydata.plugin"));
    }

    private g() {
    }

    private static final Thread a(Runnable r3) {
        Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), "ability-query-callback-" + f8360b.getAndIncrement());
        r0.setDaemon(true);
        return r0;
    }

    public static /* synthetic */ Thread lambda$7pMoWE3x_8c1wFhBY4C4veSPSL4(Runnable r0) {
        return a(r0);
    }

    public final boolean a(int r7, k r8, Runnable r9) {
        k r6 = (k) ZeusTransformUtils.wrapperContextForParams(r8, k.class, "com.obric.memorydata.plugin");
        Runnable r10 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r9, Runnable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "receiver");
        Intrinsics.checkNotNullParameter(r10, "callback");
        c.execute(r10);     // Catch: RejectedExecutionException -> L5
        return true;
    L5:
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r11 = new StringBuilder().append("query callback rejected dataId=").append(r7).append(" receiver=").append(r6.getClass().getName()).append(" poolSize=");
        ThreadPoolExecutor r12 = c;
        IRunLog.a.b(r0, "AbilityQueryCallbackExecutor", r11.append(r12.getPoolSize()).append(" activeCount=").append(r12.getActiveCount()).append(" queueSize=").append(r12.getQueue().size()).toString(), null, 4, null);
        return false;
    }
}
