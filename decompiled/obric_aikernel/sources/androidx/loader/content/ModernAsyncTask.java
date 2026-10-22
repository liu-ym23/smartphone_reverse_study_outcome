package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.RestrictTo;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
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
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = null;

        static {
            int[] r10 = new int[Status.values().length];
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = r10;
            r10[Status.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static class AsyncTaskResult<Data> {
        final Data[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask r10, Data... r11) {
            this.mTask = r10;
            this.mData = r11;
        }
    }

    private static class InternalHandler extends Handler {
        InternalHandler() {
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
        public void handleMessage(Message r10) {
            AsyncTaskResult r11 = (AsyncTaskResult) r10.obj;
            int r12 = r10.what;
            if (r12 != 1) goto L5;
            r11.mTask.finish(r11.mData[0]);
            return;
        L5:
            if (r12 != 2) goto L11;
            r11.mTask.onProgressUpdate(r11.mData);
            return;
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status FINISHED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;

        static {
            Status r10 = new Status("PENDING", 0);
            PENDING = r10;
            Status r11 = new Status("RUNNING", 1);
            RUNNING = r11;
            Status r12 = new Status("FINISHED", 2);
            FINISHED = r12;
            $VALUES = new Status[]{r10, r11, r12};
        }

        private Status(String r10, int r11) {
            super(r10, r11);
        }

        public static Status valueOf(String r10) {
            return (Status) Enum.valueOf(Status.class, r10);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        WorkerRunnable() {
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

    ModernAsyncTask() {
        this.mStatus = Status.PENDING;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        final WorkerRunnable<Params, Result> r10 = new AnonymousClass2(this);
        this.mWorker = r10;
        this.mFuture = new AnonymousClass3(this, r10);
    }

    public static void execute(Runnable r10) {
        sDefaultExecutor.execute(r10);
    }

    private static Handler getHandler() {
        monitor-enter(ModernAsyncTask.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sHandler != null) goto L7;
        sHandler = new InternalHandler();     // Catch: Throwable -> L10
    L7:
        InternalHandler r10 = sHandler;     // Catch: Throwable -> L10
        monitor-exit(ModernAsyncTask.class);     // Catch: Throwable -> L10
        return r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDefaultExecutor(Executor r10) {
        sDefaultExecutor = r10;
    }

    public final boolean cancel(boolean r10) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(r10);
    }

    protected abstract Result doInBackground(Params... r10);

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... r10) {
        return executeOnExecutor(sDefaultExecutor, r10);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor r10, Params... r11) {
        if (this.mStatus == Status.PENDING) goto L14;
        int r12 = AnonymousClass4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
        if (r12 == 1) goto L13;
        if (r12 == 2) goto L11;
        throw new IllegalStateException("We should never reach this state");
    L11:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    L13:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    L14:
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = r11;
        r10.execute(this.mFuture);
        return this;
    }

    void finish(Result r10) {
        if (isCancelled() == false) goto L5;
        onCancelled(r10);
    L6:
        this.mStatus = Status.FINISHED;
        return;
    L5:
        onPostExecute(r10);
        goto L6
    }

    public final Result get() {
        return this.mFuture.get();
    }

    public final Result get(long r10, TimeUnit r11) {
        return this.mFuture.get(r10, r11);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    protected void onCancelled() {
    }

    protected void onCancelled(Result r10) {
        onCancelled();
    }

    protected void onPostExecute(Result r10) {
    }

    protected void onPreExecute() {
    }

    protected void onProgressUpdate(Progress... r10) {
    }

    Result postResult(Result r10) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, new Object[]{r10})).sendToTarget();
        return r10;
    }

    void postResultIfNotInvoked(Result r10) {
        if (this.mTaskInvoked.get() == true) goto L6;
        postResult(r10);
        return;
    }

    protected final void publishProgress(Progress... r10) {
        if (isCancelled() == true) goto L6;
        getHandler().obtainMessage(2, new AsyncTaskResult(this, r10)).sendToTarget();
        return;
    }
}
