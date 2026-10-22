package com.bytedance.bdlocation.thread;

import android.os.Build;
import com.bytedance.bdlocation.log.Logger;
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

    public class LocationFixedThreadPoolRunnable implements Runnable {
        private Runnable mRunnable;
        final /* synthetic */ LocationFixedThreadPool this$0;

        public LocationFixedThreadPoolRunnable(LocationFixedThreadPool r8, Runnable r10) {
            this.this$0 = r8;
            this.mRunnable = r10;
        }

        private boolean doInterceptThrowable(Throwable r8) {
            if (r8 != null) goto L5;
            return false;
        L5:
            Logger.i("LocationFixedThreadPool versioncode:" + Build.VERSION.SDK_INT);
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
        super(r10, r11, r12, r14, r15, Executors.defaultThreadFactory(), defaultHandler);
    }

    public static ThreadPoolExecutor newFixedThreadPool(int r8) {
        return new LocationFixedThreadPool(r8, r8, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r8) {
        super.execute(new LocationFixedThreadPoolRunnable(this, r8));
    }
}
