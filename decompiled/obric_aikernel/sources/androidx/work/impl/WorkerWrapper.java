package androidx.work.impl;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.InputMerger;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.PackageManagerHelper;
import androidx.work.impl.utils.SynchronousExecutor;
import androidx.work.impl.utils.WorkForegroundRunnable;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkerWrapper implements Runnable {
    static final String TAG = null;
    Context mAppContext;
    private Configuration mConfiguration;
    private DependencyDao mDependencyDao;
    private ForegroundProcessor mForegroundProcessor;

    @NonNull
    SettableFuture<Boolean> mFuture;
    private volatile boolean mInterrupted;

    @NonNull
    ListenableWorker.Result mResult;
    private WorkerParameters.RuntimeExtras mRuntimeExtras;
    private List<Scheduler> mSchedulers;
    private List<String> mTags;
    private WorkDatabase mWorkDatabase;
    private String mWorkDescription;
    WorkSpec mWorkSpec;
    private WorkSpecDao mWorkSpecDao;
    private final String mWorkSpecId;
    TaskExecutor mWorkTaskExecutor;
    ListenableWorker mWorker;

    @NonNull
    final SettableFuture<ListenableWorker.Result> mWorkerResultFuture;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class Builder {

        @NonNull
        Context mAppContext;

        @NonNull
        Configuration mConfiguration;

        @NonNull
        ForegroundProcessor mForegroundProcessor;

        @NonNull
        WorkerParameters.RuntimeExtras mRuntimeExtras;
        List<Scheduler> mSchedulers;
        private final List<String> mTags;

        @NonNull
        WorkDatabase mWorkDatabase;

        @NonNull
        WorkSpec mWorkSpec;

        @NonNull
        TaskExecutor mWorkTaskExecutor;

        @Nullable
        ListenableWorker mWorker;

        public Builder(@NonNull Context r10, @NonNull Configuration r11, @NonNull TaskExecutor r12, @NonNull ForegroundProcessor r13, @NonNull WorkDatabase r14, @NonNull WorkSpec r15, @NonNull List<String> r16) {
            this.mRuntimeExtras = new WorkerParameters.RuntimeExtras();
            this.mAppContext = r10.getApplicationContext();
            this.mWorkTaskExecutor = r12;
            this.mForegroundProcessor = r13;
            this.mConfiguration = r11;
            this.mWorkDatabase = r14;
            this.mWorkSpec = r15;
            this.mTags = r16;
        }

        static /* synthetic */ List access$000(Builder r10) {
            return r10.mTags;
        }

        @NonNull
        public WorkerWrapper build() {
            return new WorkerWrapper(this);
        }

        @NonNull
        public Builder withRuntimeExtras(@Nullable WorkerParameters.RuntimeExtras r10) {
            if (r10 == null) goto L4;
            this.mRuntimeExtras = r10;
        L4:
            return this;
        }

        @NonNull
        public Builder withSchedulers(@NonNull List<Scheduler> r10) {
            this.mSchedulers = r10;
            return this;
        }

        @NonNull
        @VisibleForTesting
        public Builder withWorker(@NonNull ListenableWorker r10) {
            this.mWorker = r10;
            return this;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("WorkerWrapper");
    }

    WorkerWrapper(@NonNull Builder r10) {
        this.mResult = ListenableWorker.Result.failure();
        this.mFuture = SettableFuture.create();
        this.mWorkerResultFuture = SettableFuture.create();
        this.mAppContext = r10.mAppContext;
        this.mWorkTaskExecutor = r10.mWorkTaskExecutor;
        this.mForegroundProcessor = r10.mForegroundProcessor;
        WorkSpec r11 = r10.mWorkSpec;
        this.mWorkSpec = r11;
        this.mWorkSpecId = r11.id;
        this.mSchedulers = r10.mSchedulers;
        this.mRuntimeExtras = r10.mRuntimeExtras;
        this.mWorker = r10.mWorker;
        this.mConfiguration = r10.mConfiguration;
        WorkDatabase r12 = r10.mWorkDatabase;
        this.mWorkDatabase = r12;
        this.mWorkSpecDao = r12.workSpecDao();
        this.mDependencyDao = this.mWorkDatabase.dependencyDao();
        this.mTags = Builder.access$000(r10);
    }

    public static /* synthetic */ void a(WorkerWrapper r10, c6.a r11) {
        r10.lambda$runWorker$0(r11);
    }

    private String createWorkDescription(List<String> r10) {
        StringBuilder r11 = new StringBuilder("Work [ id=");
        r11.append(this.mWorkSpecId);
        r11.append(", tags={ ");
        Iterator<String> r12 = r10.iterator();
        boolean r13 = true;
    L4:
        if (r12.hasNext() == false) goto L10;
        String r14 = r12.next();
        if (r13 == false) goto L8;
        r13 = false;
    L9:
        r11.append(r14);
        goto L4
    L8:
        r11.append(", ");
        goto L9
    L10:
        r11.append(" } ]");
        return r11.toString();
    }

    private void handleResult(ListenableWorker.Result r10) {
        if ((r10 instanceof ListenableWorker.Result.Success) == false) goto L9;
        Logger.get().info(TAG, "Worker result SUCCESS for " + this.mWorkDescription);
        if (this.mWorkSpec.isPeriodic() == false) goto L7;
    L6:
        resetPeriodicAndResolve();
        return;
    L7:
        setSucceededAndResolve();
        return;
    L9:
        if ((r10 instanceof ListenableWorker.Result.Retry) == false) goto L11;
        Logger.get().info(TAG, "Worker result RETRY for " + this.mWorkDescription);
        rescheduleAndResolve();
        return;
    L11:
        Logger.get().info(TAG, "Worker result FAILURE for " + this.mWorkDescription);
        if (this.mWorkSpec.isPeriodic() == true) goto L6;
        setFailedAndResolve();
    }

    private void iterativelyFailWorkAndDependents(String r10) {
        LinkedList r11 = new LinkedList();
        r11.add(r10);
    L4:
        if (r11.isEmpty() == true) goto L9;
        String r12 = (String) r11.remove();
        if (this.mWorkSpecDao.getState(r12) == WorkInfo.State.CANCELLED) goto L8;
        this.mWorkSpecDao.setState(WorkInfo.State.FAILED, r12);
    L8:
        r11.addAll(this.mDependencyDao.getDependentWorkIds(r12));
        goto L4
    }

    private /* synthetic */ void lambda$runWorker$0(c6.a r10) {
        if (this.mWorkerResultFuture.isCancelled() == false) goto L6;
        r10.cancel(true);
        return;
    }

    private void rescheduleAndResolve() {
        this.mWorkDatabase.beginTransaction();
        this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);     // Catch: Throwable -> L6
        this.mWorkSpecDao.setLastEnqueuedTime(this.mWorkSpecId, System.currentTimeMillis());     // Catch: Throwable -> L6
        this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);     // Catch: Throwable -> L6
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.mWorkDatabase.endTransaction();
        resolve(true);
        return;
    L6:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        resolve(true);
        throw th;
    }

    private void resetPeriodicAndResolve() {
        this.mWorkDatabase.beginTransaction();
        this.mWorkSpecDao.setLastEnqueuedTime(this.mWorkSpecId, System.currentTimeMillis());     // Catch: Throwable -> L6
        this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);     // Catch: Throwable -> L6
        this.mWorkSpecDao.resetWorkSpecRunAttemptCount(this.mWorkSpecId);     // Catch: Throwable -> L6
        this.mWorkSpecDao.incrementPeriodCount(this.mWorkSpecId);     // Catch: Throwable -> L6
        this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);     // Catch: Throwable -> L6
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.mWorkDatabase.endTransaction();
        resolve(false);
        return;
    L6:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        resolve(false);
        throw th;
    }

    private void resolve(boolean r10) {
        this.mWorkDatabase.beginTransaction();
    L18:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    L4:
        if (this.mWorkDatabase.workSpecDao().hasUnfinishedWork() == true) goto L6;
        PackageManagerHelper.setComponentEnabled(this.mAppContext, RescheduleReceiver.class, false);     // Catch: Throwable -> L18
    L6:
        if (r10 == false) goto L9;
        this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);     // Catch: Throwable -> L18
        this.mWorkSpecDao.markWorkSpecScheduled(this.mWorkSpecId, -1);     // Catch: Throwable -> L18
    L9:
        if (this.mWorkSpec != null) goto L11;
    L15:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.mWorkDatabase.endTransaction();
        this.mFuture.set(Boolean.valueOf(r10));
        return;
    L11:
        if (this.mWorker == null) goto L15;
        if (this.mForegroundProcessor.isEnqueuedInForeground(this.mWorkSpecId) == false) goto L15;
        this.mForegroundProcessor.stopForeground(this.mWorkSpecId);     // Catch: Throwable -> L18
        goto L15
    }

    private void resolveIncorrectStatus() {
        WorkInfo.State r10 = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (r10 != WorkInfo.State.RUNNING) goto L5;
        Logger.get().debug(TAG, "Status for " + this.mWorkSpecId + " is RUNNING; not doing any work and rescheduling for later execution");
        boolean r11 = true;
    L6:
        resolve(r11);
        return;
    L5:
        Logger.get().debug(TAG, "Status for " + this.mWorkSpecId + " is " + r10 + " ; not doing any work");
        r11 = false;
        goto L6
    }

    private void runWorker() {
        if (tryCheckForInterruptionAndResolve() == false) goto L5;
        return;
    L5:
        this.mWorkDatabase.beginTransaction();
        WorkSpec r10 = this.mWorkSpec;     // Catch: Throwable -> L49
        if (r10.state == WorkInfo.State.ENQUEUED) goto L12;
        resolveIncorrectStatus();     // Catch: Throwable -> L49
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L49
        Logger.get().debug(TAG, this.mWorkSpec.workerClassName + " is not in ENQUEUED state. Nothing more to do");     // Catch: Throwable -> L49
        this.mWorkDatabase.endTransaction();
        return;
    L12:
        if (r10.isPeriodic() == true) goto L16;
        if (this.mWorkSpec.isBackedOff() == true) goto L16;
    L20:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L49
        this.mWorkDatabase.endTransaction();
        if (this.mWorkSpec.isPeriodic() == false) goto L25;
        Data r11 = this.mWorkSpec.input;
    L24:
        Data r12 = r11;
        UUID r13 = UUID.fromString(this.mWorkSpecId);
        List<String> r14 = this.mTags;
        WorkerParameters.RuntimeExtras r15 = this.mRuntimeExtras;
        WorkSpec r16 = this.mWorkSpec;
        WorkerParameters r17 = new WorkerParameters(r13, r12, r14, r15, r16.runAttemptCount, r16.getGeneration(), this.mConfiguration.getExecutor(), this.mWorkTaskExecutor, this.mConfiguration.getWorkerFactory(), new WorkProgressUpdater(this.mWorkDatabase, this.mWorkTaskExecutor), new WorkForegroundUpdater(this.mWorkDatabase, this.mForegroundProcessor, this.mWorkTaskExecutor));
        if (this.mWorker != null) goto L33;
        this.mWorker = this.mConfiguration.getWorkerFactory().createWorkerWithDefaultFallback(this.mAppContext, this.mWorkSpec.workerClassName, r17);
    L33:
        ListenableWorker r18 = this.mWorker;
        if (r18 != null) goto L38;
        Logger.get().error(TAG, "Could not create Worker " + this.mWorkSpec.workerClassName);
        setFailedAndResolve();
        return;
    L38:
        if (r18.isUsed() == false) goto L41;
        Logger.get().error(TAG, "Received an already-used Worker " + this.mWorkSpec.workerClassName + "; Worker Factory should return new instances");
        setFailedAndResolve();
        return;
    L41:
        this.mWorker.setUsed();
        if (trySetRunning() == true) goto L44;
        resolveIncorrectStatus();
        return;
    L44:
        if (tryCheckForInterruptionAndResolve() == false) goto L46;
        return;
    L46:
        WorkForegroundRunnable r19 = new WorkForegroundRunnable(this.mAppContext, this.mWorkSpec, this.mWorker, r17.getForegroundUpdater(), this.mWorkTaskExecutor);
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(r19);
        final c6.a<Void> r20 = r19.getFuture();
        this.mWorkerResultFuture.addListener(new g(this, r20), new SynchronousExecutor());
        r20.addListener(new AnonymousClass1(this, r20), this.mWorkTaskExecutor.getMainThreadExecutor());
        final String r21 = this.mWorkDescription;
        this.mWorkerResultFuture.addListener(new AnonymousClass2(this, r21), this.mWorkTaskExecutor.getSerialTaskExecutor());
        return;
    L25:
        InputMerger r22 = this.mConfiguration.getInputMergerFactory().createInputMergerWithDefaultFallback(this.mWorkSpec.inputMergerClassName);
        if (r22 != null) goto L29;
        Logger.get().error(TAG, "Could not create Input Merger " + this.mWorkSpec.inputMergerClassName);
        setFailedAndResolve();
        return;
    L29:
        ArrayList r23 = new ArrayList();
        r23.add(this.mWorkSpec.input);
        r23.addAll(this.mWorkSpecDao.getInputsFromPrerequisites(this.mWorkSpecId));
        r11 = r22.merge(r23);
    L16:
        if (System.currentTimeMillis() >= this.mWorkSpec.calculateNextRunTime()) goto L20;
        Logger.get().debug(TAG, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.mWorkSpec.workerClassName}));     // Catch: Throwable -> L49
        resolve(true);     // Catch: Throwable -> L49
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L49
        this.mWorkDatabase.endTransaction();
        return;
    L49:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    }

    private void setSucceededAndResolve() {
        this.mWorkDatabase.beginTransaction();
        this.mWorkSpecDao.setState(WorkInfo.State.SUCCEEDED, this.mWorkSpecId);     // Catch: Throwable -> L14
        this.mWorkSpecDao.setOutput(this.mWorkSpecId, ((ListenableWorker.Result.Success) this.mResult).getOutputData());     // Catch: Throwable -> L14
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L14
        Iterator<String> r11 = this.mDependencyDao.getDependentWorkIds(this.mWorkSpecId).iterator();     // Catch: Throwable -> L14
    L5:
        if (r11.hasNext() == false) goto L11;
        String r12 = r11.next();     // Catch: Throwable -> L14
        if (this.mWorkSpecDao.getState(r12) != WorkInfo.State.BLOCKED) goto L5;
        if (this.mDependencyDao.hasCompletedAllPrerequisites(r12) == false) goto L5;
        Logger.get().info(TAG, "Setting status to enqueued for " + r12);     // Catch: Throwable -> L14
        this.mWorkSpecDao.setState(WorkInfo.State.ENQUEUED, r12);     // Catch: Throwable -> L14
        this.mWorkSpecDao.setLastEnqueuedTime(r12, r10);     // Catch: Throwable -> L14
        goto L5
    L11:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.mWorkDatabase.endTransaction();
        resolve(false);
        return;
    L14:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        resolve(false);
        throw th;
    }

    private boolean tryCheckForInterruptionAndResolve() {
        if (this.mInterrupted == false) goto L9;
        Logger.get().debug(TAG, "Work interrupted for " + this.mWorkDescription);
        WorkInfo.State r10 = this.mWorkSpecDao.getState(this.mWorkSpecId);
        if (r10 != null) goto L7;
        resolve(false);
    L8:
        return true;
    L7:
        resolve(!r10.isFinished());
        goto L8
    L9:
        return false;
    }

    private boolean trySetRunning() {
        this.mWorkDatabase.beginTransaction();
    L10:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    L4:
        if (this.mWorkSpecDao.getState(this.mWorkSpecId) != WorkInfo.State.ENQUEUED) goto L6;
        this.mWorkSpecDao.setState(WorkInfo.State.RUNNING, this.mWorkSpecId);     // Catch: Throwable -> L10
        this.mWorkSpecDao.incrementWorkSpecRunAttemptCount(this.mWorkSpecId);     // Catch: Throwable -> L10
        boolean r10 = true;
    L7:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.mWorkDatabase.endTransaction();
        return r10;
    L6:
        r10 = false;
        goto L7
    }

    @NonNull
    public c6.a<Boolean> getFuture() {
        return this.mFuture;
    }

    @NonNull
    public WorkGenerationalId getWorkGenerationalId() {
        return WorkSpecKt.generationalId(this.mWorkSpec);
    }

    @NonNull
    public WorkSpec getWorkSpec() {
        return this.mWorkSpec;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void interrupt() {
        this.mInterrupted = true;
        tryCheckForInterruptionAndResolve();
        this.mWorkerResultFuture.cancel(true);
        if (this.mWorker != null) goto L5;
    L7:
        Logger.get().debug(TAG, "WorkSpec " + this.mWorkSpec + " is already done. Not interrupting.");
        return;
    L5:
        if (this.mWorkerResultFuture.isCancelled() == false) goto L7;
        this.mWorker.stop();
    }

    void onWorkFinished() {
        if (tryCheckForInterruptionAndResolve() == true) goto L19;
        this.mWorkDatabase.beginTransaction();
        WorkInfo.State r10 = this.mWorkSpecDao.getState(this.mWorkSpecId);     // Catch: Throwable -> L16
        this.mWorkDatabase.workProgressDao().delete(this.mWorkSpecId);     // Catch: Throwable -> L16
        if (r10 != null) goto L9;
        resolve(false);     // Catch: Throwable -> L16
    L14:
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L16
        this.mWorkDatabase.endTransaction();
        goto L19
    L9:
        if (r10 != WorkInfo.State.RUNNING) goto L12;
        handleResult(this.mResult);     // Catch: Throwable -> L16
        goto L14
    L12:
        if (r10.isFinished() == true) goto L14;
        rescheduleAndResolve();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        throw th;
    L19:
        List<Scheduler> r11 = this.mSchedulers;
        if (r11 == null) goto L30;
        Iterator<Scheduler> r12 = r11.iterator();
    L23:
        if (r12.hasNext() == false) goto L25;
        r12.next().cancel(this.mWorkSpecId);
        goto L23
    L25:
        Schedulers.schedule(this.mConfiguration, this.mWorkDatabase, this.mSchedulers);
        return;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public void run() {
        this.mWorkDescription = createWorkDescription(this.mTags);
        runWorker();
    }

    @VisibleForTesting
    void setFailedAndResolve() {
        this.mWorkDatabase.beginTransaction();
        iterativelyFailWorkAndDependents(this.mWorkSpecId);     // Catch: Throwable -> L6
        Data r10 = ((ListenableWorker.Result.Failure) this.mResult).getOutputData();     // Catch: Throwable -> L6
        this.mWorkSpecDao.setOutput(this.mWorkSpecId, r10);     // Catch: Throwable -> L6
        this.mWorkDatabase.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.mWorkDatabase.endTransaction();
        resolve(false);
        return;
    L6:
        th = move-exception;
        this.mWorkDatabase.endTransaction();
        resolve(false);
        throw th;
    }
}
