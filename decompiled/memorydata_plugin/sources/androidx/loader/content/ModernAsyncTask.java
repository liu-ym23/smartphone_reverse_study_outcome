package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
            int[] r0 = new int[Status.values().length];
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status = r0;
            r0[Status.RUNNING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$androidx$loader$content$ModernAsyncTask$Status[Status.FINISHED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    private static class AsyncTaskResult<Data> {
        final Data[] mData;
        final ModernAsyncTask mTask;

        AsyncTaskResult(ModernAsyncTask r1, Data... r2) {
            this.mTask = r1;
            this.mData = r2;
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
        public void handleMessage(Message r3) {
            AsyncTaskResult r2 = (AsyncTaskResult) ZeusTransformUtils.preCheckCast(r3.obj, AsyncTaskResult.class, "com.obric.memorydata.plugin");
            int r4 = r3.what;
            if (r4 != 1) goto L5;
            r2.mTask.finish(r2.mData[0]);
            return;
        L5:
            if (r4 != 2) goto L11;
            r2.mTask.onProgressUpdate(r2.mData);
            return;
        }
    }

    public static final enum Status extends Enum<Status> {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final Status FINISHED = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;

        static {
            Status r0 = new Status("PENDING", 0);
            PENDING = r0;
            Status r1 = new Status("RUNNING", 1);
            RUNNING = r1;
            Status r3 = new Status("FINISHED", 2);
            FINISHED = r3;
            $VALUES = new Status[]{r0, r1, r3};
        }

        private Status(String r1, int r2) {
            super(r1, r2);
        }

        public static Status valueOf(String r2) {
            return (Status) ZeusTransformUtils.preCheckCast(Enum.valueOf(Status.class, r2), Status.class, "com.obric.memorydata.plugin");
        }

        public static Status[] values() {
            return (Status[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Status[].class, "com.obric.memorydata.plugin");
        }
    }

    private static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {
        Params[] mParams;

        WorkerRunnable() {
        }
    }

    static {
        ThreadFactory r7 = new AnonymousClass1();
        sThreadFactory = r7;
        LinkedBlockingQueue r6 = new LinkedBlockingQueue(10);
        sPoolWorkQueue = r6;
        ThreadPoolExecutor r8 = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, r6, r7);
        THREAD_POOL_EXECUTOR = r8;
        sDefaultExecutor = r8;
    }

    ModernAsyncTask() {
        this.mStatus = Status.PENDING;
        this.mCancelled = new AtomicBoolean();
        this.mTaskInvoked = new AtomicBoolean();
        final WorkerRunnable<Params, Result> r0 = new AnonymousClass2(this);
        this.mWorker = r0;
        this.mFuture = new AnonymousClass3(this, r0);
    }

    public static void execute(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        sDefaultExecutor.execute(r3);
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
        InternalHandler r1 = sHandler;     // Catch: Throwable -> L10
        monitor-exit(ModernAsyncTask.class);     // Catch: Throwable -> L10
        return r1;
    }

    public static void setDefaultExecutor(Executor r2) {
        sDefaultExecutor = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
    }

    public final boolean cancel(boolean r3) {
        this.mCancelled.set(true);
        return this.mFuture.cancel(r3);
    }

    public abstract Result doInBackground(Params... r1);

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... r2) {
        return executeOnExecutor(sDefaultExecutor, r2);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor r3, Params... r4) {
        Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        if (this.mStatus == Status.PENDING) goto L14;
        int r2 = AnonymousClass4.$SwitchMap$androidx$loader$content$ModernAsyncTask$Status[this.mStatus.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L11;
        throw new IllegalStateException("We should never reach this state");
    L11:
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    L13:
        throw new IllegalStateException("Cannot execute task: the task is already running.");
    L14:
        this.mStatus = Status.RUNNING;
        onPreExecute();
        this.mWorker.mParams = r4;
        r5.execute(this.mFuture);
        return this;
    }

    void finish(Result r2) {
        if (isCancelled() == false) goto L5;
        onCancelled(r2);
    L6:
        this.mStatus = Status.FINISHED;
        return;
    L5:
        onPostExecute(r2);
        goto L6
    }

    public final Result get() {
        return this.mFuture.get();
    }

    public final Result get(long r1, TimeUnit r3) {
        return this.mFuture.get(r1, r3);
    }

    public final Status getStatus() {
        return this.mStatus;
    }

    public final boolean isCancelled() {
        return this.mCancelled.get();
    }

    public void onCancelled() {
    }

    public void onCancelled(Result r1) {
        onCancelled();
    }

    public void onPostExecute(Result r1) {
    }

    public void onPreExecute() {
    }

    public void onProgressUpdate(Progress... r1) {
    }

    Result postResult(Result r6) {
        getHandler().obtainMessage(1, new AsyncTaskResult(this, new Object[]{r6})).sendToTarget();
        return r6;
    }

    void postResultIfNotInvoked(Result r2) {
        if (this.mTaskInvoked.get() == true) goto L6;
        postResult(r2);
        return;
    }

    public final void publishProgress(Progress... r4) {
        if (isCancelled() == true) goto L6;
        getHandler().obtainMessage(2, new AsyncTaskResult(this, r4)).sendToTarget();
        return;
    }
}
