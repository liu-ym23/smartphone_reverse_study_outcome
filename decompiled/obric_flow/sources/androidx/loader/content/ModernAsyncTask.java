package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.RestrictTo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE = 1;
    private static final String LOG_TAG = "AsyncTask";
    private static final int MAXIMUM_POOL_SIZE = 128;
    private static final int MESSAGE_POST_PROGRESS = 2;
    private static final int MESSAGE_POST_RESULT = 1;
    public static final Executor THREAD_POOL_EXECUTOR = null;
    private static volatile Executor sDefaultExecutor;
    private static InternalHandler sHandler;
    private static final BlockingQueue<Runnable> sPoolWorkQueue = null;
    private static final ThreadFactory sThreadFactory = null;
    final AtomicBoolean mCancelled;
    private final FutureTask<Result> mFuture;
    private volatile Status mStatus;
    final AtomicBoolean mTaskInvoked;
    private final WorkerRunnable<Params, Result> mWorker;

    /* JADX INFO: renamed from: androidx.loader.content.ModernAsyncTask$4, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = null;

        static {
            int[] r5 = new int[Status.values().length];
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = r5;
            r5[Status.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static class AsyncTaskResult<Data> {
        final Data[] mData;
        final ModernAsyncTask mTask;

        public AsyncTaskResult(ModernAsyncTask r5, Data... r10) {
            this.mTask = r5;
            this.mData = r10;
        }
    }

    public static class InternalHandler extends Handler {
        public InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message r5) {
            AsyncTaskResult r10 = (AsyncTaskResult) r5.obj;
            int r11 = r5.what;
            if (r11 != 1) goto L5;
            r10.mTask.finish(r10.mData[0]);
            return;
        L5:
            if (r11 != 2) goto L11;
            r10.mTask.onProgressUpdate(r10.mData);
            return;
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status FINISHED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;

        static {
            Status r5 = new Status("PENDING", 0);
            PENDING = r5;
            Status r10 = new Status("RUNNING", 1);
            RUNNING = r10;
            Status r11 = new Status("FINISHED", 2);
            FINISHED = r11;
            $VALUES = new Status[]{r5, r10, r11};
        }

        private Status(String r5, int r10) {
            super(r5, r10);
        }

        public static Status valueOf(String r5) {
            return (Status) Enum.valueOf(Status.class, r5);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        public WorkerRunnable() {
        }
    }

    static {
        ThreadFactory r10 = new AnonymousClass1();
        sThreadFactory = r10;
        LinkedBlockingQueue r11 = new LinkedBlockingQueue(10);
        sPoolWorkQueue = r11;
        ThreadPoolExecutor r12 = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, r11, r10);
        THREAD_POOL_EXECUTOR = r12;
        sDefaultExecutor = r12;
    }

    public ModernAsyncTask() {
        this.mStatus = Status.PENDING;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        final WorkerRunnable<Params, Result> r5 = new AnonymousClass2(this);
        this.mWorker = r5;
        this.mFuture = new AnonymousClass3(this, r5);
    }

    private static Handler getHandler() {
        monitor-enter(ModernAsyncTask.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sHandler != null) goto L9;
        sHandler = new InternalHandler();     // Catch: Throwable -> L7
    L9:
        InternalHandler r5 = sHandler;     // Catch: Throwable -> L7
        monitor-exit(ModernAsyncTask.class);     // Catch: Throwable -> L7
        return r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDefaultExecutor(Executor r5) {
        sDefaultExecutor = r5;
    }

    public final boolean cancel(boolean r5) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(r5);
    }

    public abstract Result doInBackground(Params... r5);

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... r5) {
        return executeOnExecutor(sDefaultExecutor, r5);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor r5, Params... r10) {
        if (this.mStatus == Status.PENDING) goto L14;
        int r11 = AnonymousClass4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L11;
        throw new IllegalStateException("We should never reach this state");
    L11:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    L13:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    L14:
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = r10;
        r5.execute(this.mFuture);
        return this;
    }

    public void finish(Result r5) {
        if (isCancelled() == false) goto L5;
        onCancelled(r5);
    L6:
        this.mStatus = Status.FINISHED;
        return;
    L5:
        onPostExecute(r5);
        goto L6
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.mFuture.get();
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public void onCancelled() {
    }

    public void onPostExecute(Result r5) {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Progress... r5) {
    }

    public Result postResult(Result r5) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, new Object[]{r5})).sendToTarget();
        return r5;
    }

    public void postResultIfNotInvoked(Result r5) {
        if (this.mTaskInvoked.get() == true) goto L6;
        postResult(r5);
        return;
    }

    public final void publishProgress(Progress... r5) {
        if (isCancelled() == true) goto L6;
        getHandler().obtainMessage(2, new AsyncTaskResult(this, r5)).sendToTarget();
        return;
    }

    public static void execute(Runnable r5) {
        sDefaultExecutor.execute(r5);
    }

    public final Result get(long r5, TimeUnit r10) throws InterruptedException, ExecutionException, TimeoutException {
        return this.mFuture.get(r5, r10);
    }

    public void onCancelled(Result r5) {
        onCancelled();
    }
}
