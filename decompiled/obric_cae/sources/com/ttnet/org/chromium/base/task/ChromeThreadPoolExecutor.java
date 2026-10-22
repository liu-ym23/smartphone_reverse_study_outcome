package com.ttnet.org.chromium.base.task;

import android.os.Process;
import com.ttnet.org.chromium.base.BuildConfig;
import com.ttnet.org.chromium.base.VisibleForTesting;
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

/* JADX INFO: loaded from: classes2.dex */
class ChromeThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int CORE_POOL_SIZE = 0;
    private static final int CPU_COUNT = 0;
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final int MAXIMUM_POOL_SIZE = 0;
    private static final int RUNNABLE_WARNING_COUNT = 32;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = null;
    private static final ThreadFactory sThreadFactory = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.task.ChromeThreadPoolExecutor$1, reason: invalid class name */
    public class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger mCount;

        public AnonymousClass1() {
            this.mCount = new AtomicInteger(1);
        }

        public static /* synthetic */ void a(Runnable r8) {
            lambda$newThread$0(r8);
        }

        private static /* synthetic */ void lambda$newThread$0(Runnable r8) {
            Process.setThreadPriority(10);
            r8.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r8) {
            return new Thread(new a(r8, 0), "CrAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    static {
        int r8 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r8;
        CORE_POOL_SIZE = Math.max(2, Math.min(r8 - 1, 4));
        MAXIMUM_POOL_SIZE = (r8 * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    public ChromeThreadPoolExecutor() {
        this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }

    private String findClassNamesWithTooManyRunnables(Map<String, Integer> r8) {
        StringBuilder r10 = new StringBuilder();
        Iterator<Map.Entry<String, Integer>> r11 = r8.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r12 = r11.next();
        if (r12.getValue().intValue() <= 32) goto L4;
        r10.append(r12.getKey());
        r10.append(' ');
        goto L4
    L9:
        if (r10.length() != 0) goto L13;
        return "NO CLASSES FOUND";
    L13:
        return r10.toString();
    }

    private static String getClassName(Runnable r8) {
        Class r10 = r8.getClass();
        if (r10 != AsyncTask.NamedFutureTask.class) goto L8;
        Class r11 = ((AsyncTask.NamedFutureTask) r8).getBlamedClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L6:
        r10 = r11;
    L21:
        return r10.getName();
    L8:
        if (r10.getEnclosingClass() != android.os.AsyncTask.class) goto L21;
        Field r12 = r10.getDeclaredField("this$0");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r12.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r11 = r12.get(r8).getClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L11:
        e = move-exception;
        if (BuildConfig.DCHECK_IS_ON == false) goto L21;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        if (BuildConfig.DCHECK_IS_ON == false) goto L21;
        throw new RuntimeException(e);
    }

    private Map<String, Integer> getNumberOfClassNameOccurrencesInQueue() {
        HashMap r8 = new HashMap();
        Runnable[] r10 = (Runnable[]) getQueue().toArray(new Runnable[0]);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        String r13 = getClassName(r10[r12]);
        if (r8.containsKey(r13) == false) goto L7;
        int r14 = ((Integer) r8.get(r13)).intValue();
    L8:
        r8.put(r13, Integer.valueOf(r14 + 1));
        r12 = r12 + 1;
        goto L3
    L7:
        r14 = 0;
        goto L8
    L9:
        return r8;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r8) {
        super.execute(r8);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        throw new RejectedExecutionException("Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(getNumberOfClassNameOccurrencesInQueue()), e);
    }

    @VisibleForTesting
    public ChromeThreadPoolExecutor(int r8, int r10, long r11, TimeUnit r12, BlockingQueue<Runnable> r13, ThreadFactory r14) {
        super(r8, r10, r11, r12, r13, r14);
        allowCoreThreadTimeOut(true);
    }
}
