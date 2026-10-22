package com.ttnet.org.chromium.base.task;

import androidx.room.k;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.DoNotInline;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AsyncTask<Result> {
    public static final Executor SERIAL_EXECUTOR = null;
    private static final StealRunnableHandler STEAL_RUNNABLE_HANDLER = null;
    private static final String TAG = "AsyncTask";
    public static final Executor THREAD_POOL_EXECUTOR = null;
    private final AtomicBoolean mCancelled;
    private final FutureTask<Result> mFuture;
    private volatile int mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final Callable<Result> mWorker;

    public class NamedFutureTask extends FutureTask<Result> {
        final /* synthetic */ AsyncTask this$0;

        public NamedFutureTask(AsyncTask r8, Callable<Result> r10) {
            this.this$0 = r8;
            super(r10);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            AsyncTask.access$400(this.this$0, get());     // Catch: CancellationException -> L4 ExecutionException -> L5 InterruptedException -> L8
        L14:
            return;
        L8:
            e = move-exception;
            Log.w(AsyncTask.TAG, e.toString(), new Object[0]);
            return;
        L4:
            AsyncTask.access$400(this.this$0, null);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException("An error occurred while executing doInBackground()", e.getCause());
        }

        public Class getBlamedClass() {
            return this.this$0.getClass();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int FINISHED = 2;
        public static final int PENDING = 0;
        public static final int RUNNING = 1;
    }

    public static class StealRunnableHandler implements RejectedExecutionHandler {
        private StealRunnableHandler() {
        }

        public /* synthetic */ StealRunnableHandler(AnonymousClass1 r8) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r8, ThreadPoolExecutor r10) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(r8);
        }
    }

    static {
        THREAD_POOL_EXECUTOR = new i.b(2);
        SERIAL_EXECUTOR = new SerialExecutor();
        STEAL_RUNNABLE_HANDLER = new StealRunnableHandler(null);
    }

    public AsyncTask() {
        this.mStatus = 0;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        Callable<Result> r8 = new AnonymousClass1(this);
        this.mWorker = r8;
        this.mFuture = new NamedFutureTask(this, r8);
    }

    public static /* synthetic */ void a(Runnable r8) {
        lambda$static$0(r8);
    }

    public static /* synthetic */ AtomicBoolean access$100(AsyncTask r8) {
        return r8.mTaskInvoked;
    }

    public static /* synthetic */ AtomicBoolean access$200(AsyncTask r8) {
        return r8.mCancelled;
    }

    public static /* synthetic */ void access$300(AsyncTask r8, Object r10) {
        r8.postResult(r10);
    }

    public static /* synthetic */ void access$400(AsyncTask r8, Object r10) {
        r8.postResultIfNotInvoked(r10);
    }

    public static /* synthetic */ void b(AsyncTask r8, Object r10) {
        r8.lambda$postResult$1(r10);
    }

    private void executionPreamble() {
        if (this.mStatus == 0) goto L13;
        int r8 = this.mStatus;
        if (r8 == 1) goto L12;
        if (r8 != 2) goto L13;
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    L12:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    L13:
        this.mStatus = 1;
        onPreExecute();
    }

    private void finish(Result r8) {
        if (isCancelled() == false) goto L5;
        onCancelled(r8);
    L6:
        this.mStatus = 2;
        return;
    L5:
        onPostExecute(r8);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$postResult$1(Object r8) {
        finish(r8);
    }

    private static /* synthetic */ void lambda$static$0(Runnable r8) {
        PostTask.postTask(TaskTraits.BEST_EFFORT_MAY_BLOCK, r8);
    }

    private void postResult(Result r8) {
        if ((this instanceof BackgroundOnlyAsyncTask) == false) goto L5;
        this.mStatus = 2;
        return;
    L5:
        ThreadUtils.postOnUiThread(new k(18, this, r8));
    }

    private void postResultIfNotInvoked(Result r8) {
        if (this.mTaskInvoked.get() == true) goto L6;
        postResult(r8);
        return;
    }

    public static void takeOverAndroidThreadPool() {
        ThreadPoolExecutor r8 = (ThreadPoolExecutor) android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        r8.setRejectedExecutionHandler(STEAL_RUNNABLE_HANDLER);
        r8.shutdown();
    }

    public final boolean cancel(boolean r8) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(r8);
    }

    public abstract Result doInBackground();

    public final AsyncTask<Result> executeOnExecutor(Executor r8) {
        executionPreamble();
        r8.execute(this.mFuture);
        return this;
    }

    public final AsyncTask<Result> executeOnTaskRunner(TaskRunner r8) {
        executionPreamble();
        r8.postTask(this.mFuture);
        return this;
    }

    public final AsyncTask<Result> executeWithTaskTraits(TaskTraits r8) {
        executionPreamble();
        PostTask.postTask(r8, this.mFuture);
        return this;
    }

    @DoNotInline
    public final Result get() {
        if (getStatus() == 2) goto L24;
        if (ThreadUtils.runningOnUiThread() == false) goto L24;
        StackTraceElement[] r8 = new Exception().getStackTrace();
        if (r8.length <= 1) goto L9;
        String r10 = r8[1].getClassName() + '.' + r8[1].getMethodName() + '.';
    L10:
        TraceEvent r11 = TraceEvent.scoped(r10 + "AsyncTask.get");
        Result r12 = this.mFuture.get();     // Catch: Throwable -> L14
        if (r11 == null) goto L31;
        r11.close();
        return r12;
    L31:
        return r12;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (r11 != null) goto L29;
    L22:
        throw th;
    L29:
        r11.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    L9:
        r10 = "";
    L24:
        return this.mFuture.get();
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public void onCancelled() {
    }

    public abstract void onPostExecute(Result r8);

    public void onPreExecute() {
    }

    public void onCancelled(Result r8) {
        onCancelled();
    }
}
