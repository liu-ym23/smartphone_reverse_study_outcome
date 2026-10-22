package com.bytedance.bdlocation.thread;

import android.os.Build;
import com.bytedance.bdlocation.log.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class LocationFixedThreadPool extends ThreadPoolExecutor {
    private static final String STACK_CLASS = "android.telephony.TelephonyManager$1";
    private static final String STACK_METHOD = "lambda$onError$2";
    private static final RejectedExecutionHandler defaultHandler = null;

    private class LocationFixedThreadPoolRunnable implements Runnable {
        private Runnable mRunnable;
        final /* synthetic */ LocationFixedThreadPool this$0;

        public LocationFixedThreadPoolRunnable(LocationFixedThreadPool r3, Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mRunnable = r5;
        }

        private boolean doInterceptThrowable(Throwable r6) {
            if (r6 != null) goto L6;
            return false;
        L6:
            if (Build.VERSION.SDK_INT == 29) goto L9;
            Logger.i("LocationFixedThreadPool versioncode:" + Build.VERSION.SDK_INT);
            return false;
        L9:
            Logger.i("LocationFixedThreadPool throwable instanceof NullPointerException:" + ZeusTransformUtils.instanceOf(r6, NullPointerException.class));
            if (ZeusTransformUtils.instanceOf(r6, NullPointerException.class) == false) goto L30;
            StackTraceElement[] r7 = r6.getStackTrace();
            StringBuilder r0 = new StringBuilder().append("LocationFixedThreadPool elements:");
            if (r7 != null) goto L14;
            int r1 = 0;
        L15:
            Logger.i(r0.append(r1).toString());
            if (r7 == null) goto L30;
            if (r7.length <= 0) goto L30;
            int r2 = r7.length;
            int r3 = 0;
        L20:
            if (r3 >= r2) goto L30;
            StackTraceElement r4 = r7[r3];
            if (r4 == null) goto L29;
            Logger.i("LocationFixedThreadPool element ClassName:" + r4.getClassName() + "--MethodName:" + r4.getMethodName());
            if (LocationFixedThreadPool.STACK_CLASS.equals(r4.getClassName()) == false) goto L29;
            if (LocationFixedThreadPool.STACK_METHOD.equals(r4.getMethodName()) == false) goto L29;
            Logger.i("LocationFixedThreadPool doInterceptThrowable return true");
            return true;
        L29:
            r3 = r3 + 1;
            goto L20
        L14:
            r1 = r7.length;
        L30:
            Logger.i("LocationFixedThreadPool doInterceptThrowable return false");
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRunnable.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (doInterceptThrowable(th) == false) goto L8;
            return;
        L8:
            Logger.i("LocationFixedThreadPool doInterceptThrowable throw throwable");
            throw th;
        }
    }

    static {
        defaultHandler = new ThreadPoolExecutor.AbortPolicy();
    }

    public LocationFixedThreadPool(int r10, int r11, long r12, TimeUnit r14, BlockingQueue<Runnable> r15) {
        super(r10, r11, r12, r14, (BlockingQueue) ZeusTransformUtils.wrapperContextForParams(r15, BlockingQueue.class, "com.obric.memorydata.plugin"), Executors.defaultThreadFactory(), defaultHandler);
    }

    public static ThreadPoolExecutor newFixedThreadPool(int r8) {
        return new LocationFixedThreadPool(r8, r8, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r3) {
        super.execute(new LocationFixedThreadPoolRunnable(this, (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")));
    }
}
