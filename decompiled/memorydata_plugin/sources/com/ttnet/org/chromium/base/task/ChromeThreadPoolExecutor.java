package com.ttnet.org.chromium.base.task;

import android.os.Process;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes6.dex */
class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE = 0;
    private static final int RUNNABLE_WARNING_COUNT = 32;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = null;
    private static final ThreadFactory sThreadFactory = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.task.ChromeThreadPoolExecutor$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger mCount;

        AnonymousClass1() {
            this.mCount = new AtomicInteger(1);
        }

        static /* synthetic */ void lambda$newThread$0(Runnable r2) {
            Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
            Process.setThreadPriority(10);
            r3.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r4) {
            final Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            return new Thread(new $$Lambda$ChromeThreadPoolExecutor$1$A4vkadjqQHzMu9Shf3jtyUOIoXw(r5), "CrAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r0;
        CORE_POOL_SIZE = Math.max(2, Math.min(r0 - 1, 4));
        MAXIMUM_POOL_SIZE = (r0 * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    ChromeThreadPoolExecutor() {
        this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }

    ChromeThreadPoolExecutor(int r11, int r12, long r13, TimeUnit r15, BlockingQueue<Runnable> r16, ThreadFactory r17) {
        super(r11, r12, r13, r15, (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r16, BlockingQueue.class, "com.obric.memorydata.plugin"), (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r17, ThreadFactory.class, "com.obric.memorydata.plugin"));
        allowCoreThreadTimeOut(true);
    }

    private String findClassNamesWithTooManyRunnables(Map<String, Integer> r5) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = new StringBuilder();
        Iterator r7 = r4.entrySet().iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((Integer) ZeusTransformUtils.preCheckCast(r1.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue() <= 32) goto L4;
        r6.append((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin")).append(' ');
        goto L4
    L9:
        if (r6.length() != 0) goto L13;
        return "NO CLASSES FOUND";
    L13:
        return r6.toString();
    }

    private static String getClassName(Runnable r3) {
        Object r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        Class r0 = r4.getClass();
        if (r0 != AsyncTask.NamedFutureTask.class) goto L8;
        Class r5 = ((AsyncTask.NamedFutureTask) ZeusTransformUtils.preCheckCast(r4, AsyncTask.NamedFutureTask.class, "com.obric.memorydata.plugin")).getBlamedClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L6:
        r0 = r5;
    L21:
        return r0.getName();
    L8:
        if (r0.getEnclosingClass() != android.os.AsyncTask.class) goto L21;
        Field r1 = r0.getDeclaredField("this$0");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r1.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r5 = r1.get(r4).getClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L11:
        e = move-exception;
        if (BuildConfig.ENABLE_ASSERTS == false) goto L21;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        if (BuildConfig.ENABLE_ASSERTS == false) goto L21;
        throw new RuntimeException(e);
    }

    private Map<String, Integer> getNumberOfClassNameOccurrencesInQueue() {
        HashMap r0 = new HashMap();
        Runnable[] r8 = (Runnable[]) ZeusTransformUtils.preCheckCast(getQueue().toArray(new Runnable[0]), Runnable[].class, "com.obric.memorydata.plugin");
        int r2 = r8.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L9;
        String r5 = getClassName(r8[r4]);
        if (r0.containsKey(r5) == false) goto L7;
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r0.get(r5), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L8:
        r0.put(r5, Integer.valueOf(r6 + 1));
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = 0;
        goto L8
    L9:
        return r0;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r5) {
        super.execute((Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin"));     // Catch: RejectedExecutionException -> L5
        return;
    L5:
        e = move-exception;
        throw new RejectedExecutionException("Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(getNumberOfClassNameOccurrencesInQueue()), e);
    }
}
