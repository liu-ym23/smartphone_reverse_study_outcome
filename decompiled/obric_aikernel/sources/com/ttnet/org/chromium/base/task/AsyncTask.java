package com.ttnet.org.chromium.base.task;

import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ThreadUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.DoNotInline;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AsyncTask<Result> {
    private static final String GET_STATUS_UMA_HISTOGRAM = "Android.Jank.AsyncTaskGetOnUiThreadStatus";
    public static final Executor SERIAL_EXECUTOR = null;
    private static final StealRunnableHandler STEAL_RUNNABLE_HANDLER = null;
    private static final String TAG = "AsyncTask";
    public static final Executor THREAD_POOL_EXECUTOR = null;
    private final AtomicBoolean mCancelled;
    private final AsyncTask<Result>.NamedFutureTask mFuture;
    private volatile int mStatus;
    private final AtomicBoolean mTaskInvoked;
    private final Callable<Result> mWorker;

    class NamedFutureTask extends FutureTask<Result> {
        final /* synthetic */ AsyncTask this$0;

        NamedFutureTask(AsyncTask r10, Callable<Result> r11) {
            this.this$0 = r10;
            super(r11);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            AsyncTask.access$500(this.this$0, get());     // Catch: CancellationException -> L4 ExecutionException -> L5 InterruptedException -> L8
        L14:
            return;
        L8:
            e = move-exception;
            Log.w(AsyncTask.TAG, e.toString(), new Object[0]);
            return;
        L4:
            AsyncTask.access$500(this.this$0, null);
            return;
        L5:
            e = move-exception;
            throw new RuntimeException("An error occurred while executing doInBackground()", e.getCause());
        }

        Class getBlamedClass() {
            return this.this$0.getClass();
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            TraceEvent r10 = TraceEvent.scoped("AsyncTask.run: " + AsyncTask.access$400(this.this$0).getBlamedClass().getName());
            super.run();     // Catch: Throwable -> L7
            if (r10 == null) goto L18;
            r10.close();
            return;
        L18:
            return;
        L7:
            th = move-exception;
            if (r10 != null) goto L14;
        L13:
            throw th;
        L14:
            r10.close();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            th.addSuppressed(th);
            goto L13
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
        public static final int FINISHED = 2;
        public static final int NUM_ENTRIES = 3;
        public static final int PENDING = 0;
        public static final int RUNNING = 1;
    }

    private static class StealRunnableHandler implements RejectedExecutionHandler {
        private StealRunnableHandler() {
        }

        /* synthetic */ StealRunnableHandler(AnonymousClass1 r10) {
            this();
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable r10, ThreadPoolExecutor r11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(r10);
        }
    }

    static {
        THREAD_POOL_EXECUTOR = b.f8427c;
        SERIAL_EXECUTOR = new SerialExecutor();
        STEAL_RUNNABLE_HANDLER = new StealRunnableHandler(null);
    }

    public AsyncTask() {
        this.mStatus = 0;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        Callable<Result> r10 = new AnonymousClass1(this);
        this.mWorker = r10;
        this.mFuture = new NamedFutureTask(this, r10);
    }

    public static /* synthetic */ void a(Runnable r10) {
        lambda$static$0(r10);
    }

    static /* synthetic */ AtomicBoolean access$100(AsyncTask r10) {
        return r10.mTaskInvoked;
    }

    static /* synthetic */ AtomicBoolean access$200(AsyncTask r10) {
        return r10.mCancelled;
    }

    static /* synthetic */ void access$300(AsyncTask r10, Object r11) {
        r10.postResult(r11);
    }

    static /* synthetic */ NamedFutureTask access$400(AsyncTask r10) {
        return r10.mFuture;
    }

    static /* synthetic */ void access$500(AsyncTask r10, Object r11) {
        r10.postResultIfNotInvoked(r11);
    }

    public static /* synthetic */ void b(AsyncTask r10, Object r11) {
        r10.lambda$postResult$1(r11);
    }

    private void executionPreamble() {
        if (this.mStatus == 0) goto L13;
        int r10 = this.mStatus;
        if (r10 == 1) goto L12;
        if (r10 != 2) goto L13;
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    L12:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    L13:
        this.mStatus = 1;
        onPreExecute();
    }

    private void finish(Result r10) {
        if (isCancelled() == false) goto L5;
        onCancelled(r10);
    L6:
        this.mStatus = 2;
        return;
    L5:
        onPostExecute(r10);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ void lambda$postResult$1(Object r10) {
        finish(r10);
    }

    private static /* synthetic */ void lambda$static$0(Runnable r10) {
        PostTask.postTask(TaskTraits.BEST_EFFORT_MAY_BLOCK, r10);
    }

    private void postResult(final Result r10) {
        if ((this instanceof BackgroundOnlyAsyncTask) == false) goto L5;
        this.mStatus = 2;
        return;
    L5:
        ThreadUtils.postOnUiThread(new a(this, r10));
    }

    private void postResultIfNotInvoked(Result r10) {
        if (this.mTaskInvoked.get() == true) goto L6;
        postResult(r10);
        return;
    }

    public static void takeOverAndroidThreadPool() {
        ThreadPoolExecutor r10 = (ThreadPoolExecutor) android.os.AsyncTask.THREAD_POOL_EXECUTOR;
        r10.setRejectedExecutionHandler(STEAL_RUNNABLE_HANDLER);
        r10.shutdown();
    }

    public final boolean cancel(boolean r10) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(r10);
    }

    @WorkerThread
    protected abstract Result doInBackground();

    @MainThread
    public final AsyncTask<Result> executeOnExecutor(Executor r10) {
        executionPreamble();
        r10.execute(this.mFuture);
        return this;
    }

    @MainThread
    public final AsyncTask<Result> executeOnTaskRunner(TaskRunner r10) {
        executionPreamble();
        r10.postTask(this.mFuture);
        return this;
    }

    @MainThread
    public final AsyncTask<Result> executeWithTaskTraits(TaskTraits r10) {
        executionPreamble();
        PostTask.postTask(r10, this.mFuture);
        return this;
    }

    @DoNotInline
    public final Result get() {
        int r10 = getUmaStatus();
        if (r10 == 2) goto L22;
        if (ThreadUtils.runningOnUiThread() == false) goto L22;
        RecordHistogram.recordEnumeratedHistogram(GET_STATUS_UMA_HISTOGRAM, r10, 3);
        StackTraceElement[] r11 = new Exception().getStackTrace();
        if (r11.length <= 1) goto L9;
        String r12 = r11[1].getClassName() + '.' + r11[1].getMethodName() + '.';
    L10:
        TraceEvent r13 = TraceEvent.scoped(r12 + "AsyncTask.get");
        Result r14 = this.mFuture.get();     // Catch: Throwable -> L14
        if (r13 == null) goto L27;
        r13.close();
        return r14;
    L27:
        return r14;
    L14:
        th = move-exception;
        if (r13 != null) goto L25;
    L20:
        throw th;
    L25:
        r13.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    L9:
        r12 = "";
    L22:
        return this.mFuture.get();
    }

    @DoNotInline
    public final Result get(long r10, TimeUnit r11) {
        int r12 = getUmaStatus();
        if (r12 == 2) goto L22;
        if (ThreadUtils.runningOnUiThread() == false) goto L22;
        RecordHistogram.recordEnumeratedHistogram(GET_STATUS_UMA_HISTOGRAM, r12, 3);
        StackTraceElement[] r13 = new Exception().getStackTrace();
        if (r13.length <= 1) goto L9;
        String r14 = r13[1].getClassName() + '.' + r13[1].getMethodName() + '.';
    L10:
        TraceEvent r15 = TraceEvent.scoped(r14 + "AsyncTask.get");
        Result r16 = this.mFuture.get(r10, r11);     // Catch: Throwable -> L14
        if (r15 == null) goto L27;
        r15.close();
        return r16;
    L27:
        return r16;
    L14:
        th = move-exception;
        if (r15 != null) goto L25;
    L20:
        throw th;
    L25:
        r15.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    L9:
        r14 = "";
    L22:
        return this.mFuture.get(r10, r11);
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public final int getUmaStatus() {
        if (this.mStatus != 1) goto L9;
        if (this.mTaskInvoked.get() == true) goto L9;
        return 0;
    L9:
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    @MainThread
    protected void onCancelled() {
    }

    @MainThread
    protected void onCancelled(Result r10) {
        onCancelled();
    }

    @MainThread
    protected abstract void onPostExecute(Result r10);

    @MainThread
    protected void onPreExecute() {
    }
}
