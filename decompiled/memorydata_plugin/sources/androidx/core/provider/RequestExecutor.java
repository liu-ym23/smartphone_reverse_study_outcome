package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class RequestExecutor {

    private static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        private static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            ProcessPriorityThread(Runnable r3, String r4, int r5) {
                super((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), r4);
                this.mPriority = r5;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        DefaultThreadFactory(String r1, int r2) {
            this.mThreadName = r1;
            this.mPriority = r2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r3) {
            return new ProcessPriorityThread((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), this.mThreadName, this.mPriority);
        }
    }

    private static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        HandlerExecutor(Handler r3) {
            this.mHandler = (Handler) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(r3), Handler.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r4) {
            if (this.mHandler.post((Runnable) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull((Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin")), Runnable.class, "com.obric.memorydata.plugin")) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private static class ReplyRunnable<T> implements Runnable {
        private Callable<T> mCallable;
        private Consumer<T> mConsumer;
        private Handler mHandler;

        ReplyRunnable(Handler r3, Callable<T> r4, Consumer<T> r5) {
            Callable<T> r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r4, Callable.class, "com.obric.memorydata.plugin");
            Consumer<T> r7 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
            this.mCallable = r6;
            this.mConsumer = r7;
            this.mHandler = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T r0 = this.mCallable.call();     // Catch: Exception -> L4
        L5:
            final Consumer<T> r1 = this.mConsumer;
            this.mHandler.post(new AnonymousClass1(this, r1, r0));
            return;
        L4:
            r0 = null;
            goto L5
        }
    }

    private RequestExecutor() {
    }

    static ThreadPoolExecutor createDefaultExecutor(String r8, int r9, int r10) {
        ThreadPoolExecutor r11 = new ThreadPoolExecutor(0, 1, r10, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(r8, r9));
        r11.allowCoreThreadTimeOut(true);
        return r11;
    }

    static Executor createHandlerExecutor(Handler r1) {
        return new HandlerExecutor(r1);
    }

    static <T> void execute(Executor r2, Callable<T> r3, Consumer<T> r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
        Callable r6 = (Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin");
        Consumer r7 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
        r5.execute(new ReplyRunnable(CalleeHandler.create(), r6, r7));
    }

    static <T> T submit(ExecutorService r2, Callable<T> r3, int r4) {
        return ((ExecutorService) ZeusTransformUtils.wrapperContextForParams(r2, ExecutorService.class, "com.obric.memorydata.plugin")).submit((Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin")).get(r4, TimeUnit.MILLISECONDS);
    L7:
        e = move-exception;
        throw e;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L6:
        throw new InterruptedException(LocationMonitorConst.TIMEOUT);
    }
}
