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

    private static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        private static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            ProcessPriorityThread(Runnable r10, String r11, int r12) {
                super(r10, r11);
                this.mPriority = r12;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        DefaultThreadFactory(@NonNull String r10, int r11) {
            this.mThreadName = r10;
            this.mPriority = r11;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            return new ProcessPriorityThread(r10, this.mThreadName, this.mPriority);
        }
    }

    private static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        HandlerExecutor(@NonNull Handler r10) {
            this.mHandler = (Handler) Preconditions.checkNotNull(r10);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable r10) {
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(r10)) == false) goto L6;
            return;
        L6:
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    private static class ReplyRunnable<T> implements Runnable {

        @NonNull
        private Callable<T> mCallable;

        @NonNull
        private Consumer<T> mConsumer;

        @NonNull
        private Handler mHandler;

        ReplyRunnable(@NonNull Handler r10, @NonNull Callable<T> r11, @NonNull Consumer<T> r12) {
            this.mCallable = r11;
            this.mConsumer = r12;
            this.mHandler = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T r10 = this.mCallable.call();     // Catch: Exception -> L4
        L5:
            final Consumer<T> r11 = this.mConsumer;
            this.mHandler.post(new AnonymousClass1(this, r11, r10));
            return;
        L4:
            r10 = null;
            goto L5
        }
    }

    private RequestExecutor() {
    }

    static ThreadPoolExecutor createDefaultExecutor(@NonNull String r10, int r11, @IntRange(from = 0) int r12) {
        ThreadPoolExecutor r13 = new ThreadPoolExecutor(0, 1, r12, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(r10, r11));
        r13.allowCoreThreadTimeOut(true);
        return r13;
    }

    static Executor createHandlerExecutor(@NonNull Handler r10) {
        return new HandlerExecutor(r10);
    }

    static <T> void execute(@NonNull Executor r10, @NonNull Callable<T> r11, @NonNull Consumer<T> r12) {
        r10.execute(new ReplyRunnable(CalleeHandler.create(), r11, r12));
    }

    static <T> T submit(@NonNull ExecutorService r10, @NonNull Callable<T> r11, @IntRange(from = 0) int r12) {
        return r10.submit(r11).get(r12, TimeUnit.MILLISECONDS);
    L7:
        e = move-exception;
        throw e;
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L6:
        throw new InterruptedException("timeout");
    }
}
