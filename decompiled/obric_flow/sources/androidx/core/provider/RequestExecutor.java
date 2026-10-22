package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
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

    public static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        public static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            public ProcessPriorityThread(Runnable r5, String r10, int r11) {
                super(r5, r10);
                this.mPriority = r11;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        public DefaultThreadFactory(@NonNull String r5, int r10) {
            this.mThreadName = r5;
            this.mPriority = r10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r5) {
            return new ProcessPriorityThread(r5, this.mThreadName, this.mPriority);
        }
    }

    public static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        public HandlerExecutor(@NonNull Handler r5) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r5);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r5) {
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(r5)) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    public static class ReplyRunnable<T> implements Runnable {

        @NonNull
        private Callable<T> mCallable;

        @NonNull
        private Consumer<T> mConsumer;

        @NonNull
        private Handler mHandler;

        public ReplyRunnable(@NonNull Handler r5, @NonNull Callable<T> r10, @NonNull Consumer<T> r11) {
            this.mCallable = r10;
            this.mConsumer = r11;
            this.mHandler = r5;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T r5 = this.mCallable.call();     // Catch: Exception -> L4
        L5:
            final Consumer<T> r10 = this.mConsumer;
            this.mHandler.post(new AnonymousClass1(this, r10, r5));
            return;
        L4:
            r5 = null;
            goto L5
        }
    }

    private RequestExecutor() {
    }

    public static ThreadPoolExecutor createDefaultExecutor(@NonNull String r10, int r11, @IntRange(from = 0) int r12) {
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(0, 1, r12, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(r10, r11));
        r13.allowCoreThreadTimeOut(true);
        return r13;
    }

    public static Executor createHandlerExecutor(@NonNull Handler r5) {
        return new HandlerExecutor(r5);
    }

    public static <T> void execute(@NonNull Executor r5, @NonNull Callable<T> r10, @NonNull Consumer<T> r11) {
        r5.execute(new ReplyRunnable(CalleeHandler.create(), r10, r11));
    }

    public static <T> T submit(@NonNull ExecutorService r5, @NonNull Callable<T> r10, @IntRange(from = 0) int r11) throws InterruptedException {
        return r5.submit(r10).get(r11, TimeUnit.MILLISECONDS);
    L5:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L10:
        throw new InterruptedException("timeout");
    }
}
