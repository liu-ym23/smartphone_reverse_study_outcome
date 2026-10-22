package com.ttnet.org.chromium.base.task;

import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.build.BuildConfig;
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
    class AnonymousClass1 implements ThreadFactory {
        private final AtomicInteger mCount;

        AnonymousClass1() {
            this.mCount = new AtomicInteger(1);
        }

        public static /* synthetic */ void a(Runnable r10) {
            lambda$newThread$0(r10);
        }

        private static /* synthetic */ void lambda$newThread$0(Runnable r10) {
            Process.setThreadPriority(10);
            r10.run();
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(final Runnable r10) {
            return new Thread(new d(r10), "CrAsyncTask #" + this.mCount.getAndIncrement());
        }
    }

    static {
        int r10 = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = r10;
        CORE_POOL_SIZE = Math.max(2, Math.min(r10 - 1, 4));
        MAXIMUM_POOL_SIZE = (r10 * 2) + 1;
        sThreadFactory = new AnonymousClass1();
        sPoolWorkQueue = new ArrayBlockingQueue(128);
    }

    ChromeThreadPoolExecutor() {
        this(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    }

    @VisibleForTesting
    ChromeThreadPoolExecutor(int r10, int r11, long r12, TimeUnit r13, BlockingQueue<Runnable> r14, ThreadFactory r15) {
        super(r10, r11, r12, r13, r14, r15);
        allowCoreThreadTimeOut(true);
    }

    private String findClassNamesWithTooManyRunnables(Map<String, Integer> r10) {
        StringBuilder r11 = new StringBuilder();
        Iterator<Map.Entry<String, Integer>> r12 = r10.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Map.Entry<String, Integer> r13 = r12.next();
        if (r13.getValue().intValue() <= 32) goto L4;
        r11.append(r13.getKey());
        r11.append(' ');
        goto L4
    L9:
        if (r11.length() != 0) goto L13;
        return "NO CLASSES FOUND";
    L13:
        return r11.toString();
    }

    private static String getClassName(Runnable r10) {
        Class r11 = r10.getClass();
        if (r11 != AsyncTask.NamedFutureTask.class) goto L8;
        Class r12 = ((AsyncTask.NamedFutureTask) r10).getBlamedClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
    L6:
        r11 = r12;
    L21:
        return r11.getName();
    L8:
        if (r11.getEnclosingClass() != android.os.AsyncTask.class) goto L21;
        Field r13 = r11.getDeclaredField("this$0");     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r13.setAccessible(true);     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
        r12 = r13.get(r10).getClass();     // Catch: IllegalAccessException -> L11 NoSuchFieldException -> L17
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
        HashMap r10 = new HashMap();
        Runnable[] r11 = (Runnable[]) getQueue().toArray(new Runnable[0]);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        String r14 = getClassName(r11[r13]);
        if (r10.containsKey(r14) == false) goto L7;
        int r15 = ((Integer) r10.get(r14)).intValue();
    L8:
        r10.put(r14, Integer.valueOf(r15 + 1));
        r13 = r13 + 1;
        goto L3
    L7:
        r15 = 0;
        goto L8
    L9:
        return r10;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r10) {
        super.execute(r10);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        throw new RejectedExecutionException("Prominent classes in AsyncTask: " + findClassNamesWithTooManyRunnables(getNumberOfClassNameOccurrencesInQueue()), e);
    }
}
