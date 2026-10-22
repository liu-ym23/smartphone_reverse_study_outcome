package com.bytedance.common.utility.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b extends ThreadPoolExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final RejectedExecutionHandler f1971a = null;

    static {
        f1971a = new ThreadPoolExecutor.AbortPolicy();
    }

    public b(int r12, int r13, long r14, TimeUnit r16, BlockingQueue<Runnable> r17, ThreadFactory r18) {
        super(r12, r13, r14, r16, (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r17, BlockingQueue.class, "com.obric.memorydata.plugin"), (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r18, ThreadFactory.class, "com.obric.memorydata.plugin"), f1971a);
    }

    public b(int r12, int r13, long r14, TimeUnit r16, BlockingQueue<Runnable> r17, ThreadFactory r18, RejectedExecutionHandler r19) {
        super(r12, r13, r14, r16, (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r17, BlockingQueue.class, "com.obric.memorydata.plugin"), (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r18, ThreadFactory.class, "com.obric.memorydata.plugin"), (RejectedExecutionHandler) ZeusTransformUtils.wrapperContextForParams(r19, RejectedExecutionHandler.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return new ArrayList();
    }
}
