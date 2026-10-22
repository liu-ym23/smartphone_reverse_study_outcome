package androidx.work.impl;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.work.Configuration;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.R;
import androidx.work.WorkContinuation;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkQuery;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import androidx.work.impl.background.greedy.GreedyScheduler;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.CancelWorkRunnable;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.impl.utils.LiveDataUtils;
import androidx.work.impl.utils.PreferenceUtils;
import androidx.work.impl.utils.PruneWorkRunnable;
import androidx.work.impl.utils.RawQueries;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StatusRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import androidx.work.multiprocess.RemoteWorkManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class WorkManagerImpl extends WorkManager {
    public static final int MAX_PRE_JOB_SCHEDULER_API_LEVEL = 22;
    public static final int MIN_JOB_SCHEDULER_API_LEVEL = 23;
    public static final String REMOTE_WORK_MANAGER_CLIENT = "androidx.work.multiprocess.RemoteWorkManagerClient";
    private static final String TAG = null;
    private static WorkManagerImpl sDefaultInstance;
    private static WorkManagerImpl sDelegatedInstance;
    private static final Object sLock = null;
    private Configuration mConfiguration;
    private Context mContext;
    private boolean mForceStopRunnableCompleted;
    private PreferenceUtils mPreferenceUtils;
    private Processor mProcessor;
    private volatile RemoteWorkManager mRemoteWorkManager;
    private BroadcastReceiver.PendingResult mRescheduleReceiverResult;
    private List<Scheduler> mSchedulers;
    private final Trackers mTrackers;
    private WorkDatabase mWorkDatabase;
    private TaskExecutor mWorkTaskExecutor;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static boolean isDeviceProtectedStorage(Context r10) {
            return r10.isDeviceProtectedStorage();
        }
    }

    static {
        TAG = Logger.tagWithPrefix("WorkManagerImpl");
        sDelegatedInstance = null;
        sDefaultInstance = null;
        sLock = new Object();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context r10, @NonNull Configuration r11, @NonNull TaskExecutor r12) {
        this(r10, r11, r12, r10.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context r10, @NonNull Configuration r11, @NonNull TaskExecutor r12, @NonNull WorkDatabase r13) {
        Context r14 = r10.getApplicationContext();
        Logger.setLogger(new Logger.LogcatLogger(r11.getMinimumLoggingLevel()));
        Trackers r15 = new Trackers(r14, r12);
        this.mTrackers = r15;
        List<Scheduler> r16 = createSchedulers(r14, r11, r15);
        internalInit(r10, r11, r12, r13, r16, new Processor(r10, r11, r12, r13, r16));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context r10, @NonNull Configuration r11, @NonNull TaskExecutor r12, @NonNull WorkDatabase r13, @NonNull List<Scheduler> r14, @NonNull Processor r15) {
        this(r10, r11, r12, r13, r14, r15, new Trackers(r10.getApplicationContext(), r12));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context r10, @NonNull Configuration r11, @NonNull TaskExecutor r12, @NonNull WorkDatabase r13, @NonNull List<Scheduler> r14, @NonNull Processor r15, @NonNull Trackers r16) {
        this.mTrackers = r16;
        internalInit(r10, r11, r12, r13, r14, r15);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkManagerImpl(@NonNull Context r10, @NonNull Configuration r11, @NonNull TaskExecutor r12, boolean r13) {
        this(r10, r11, r12, WorkDatabase.create(r10.getApplicationContext(), r12.getSerialTaskExecutor(), r13));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public static WorkManagerImpl getInstance() {
        Object r10 = sLock;
        monitor-enter(r10);
        WorkManagerImpl r11 = sDelegatedInstance;     // Catch: Throwable -> L11
        if (r11 == null) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r11;
    L8:
        WorkManagerImpl r12 = sDefaultInstance;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        return r12;
    L11:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static WorkManagerImpl getInstance(@NonNull Context r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        WorkManagerImpl r12 = getInstance();     // Catch: Throwable -> L13
        if (r12 != null) goto L11;
        Context r13 = r10.getApplicationContext();     // Catch: Throwable -> L13
        if ((r13 instanceof Configuration.Provider) == false) goto L10;
        initialize(r13, ((Configuration.Provider) r13).getWorkManagerConfiguration());     // Catch: Throwable -> L13
        r12 = getInstance(r13);     // Catch: Throwable -> L13
        goto L11
    L10:
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");     // Catch: Throwable -> L13
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r12;
    L13:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void initialize(@NonNull Context r10, @NonNull Configuration r11) {
        Object r12 = sLock;
        monitor-enter(r12);
        WorkManagerImpl r13 = sDelegatedInstance;     // Catch: Throwable -> L18
        if (r13 != null) goto L7;
    L11:
        if (r13 != null) goto L16;
        Context r14 = r10.getApplicationContext();     // Catch: Throwable -> L18
        if (sDefaultInstance != null) goto L15;
        sDefaultInstance = new WorkManagerImpl(r14, r11, new WorkManagerTaskExecutor(r11.getTaskExecutor()));     // Catch: Throwable -> L18
    L15:
        sDelegatedInstance = sDefaultInstance;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L18
        return;
    L7:
        if (sDefaultInstance == null) goto L11;
        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private void internalInit(@NonNull Context r10, @NonNull Configuration r11, @NonNull TaskExecutor r12, @NonNull WorkDatabase r13, @NonNull List<Scheduler> r14, @NonNull Processor r15) {
        Context r16 = r10.getApplicationContext();
        this.mContext = r16;
        this.mConfiguration = r11;
        this.mWorkTaskExecutor = r12;
        this.mWorkDatabase = r13;
        this.mSchedulers = r14;
        this.mProcessor = r15;
        this.mPreferenceUtils = new PreferenceUtils(r13);
        this.mForceStopRunnableCompleted = false;
        if (Build.VERSION.SDK_INT >= 24) goto L5;
    L9:
        this.mWorkTaskExecutor.executeOnTaskThread(new ForceStopRunnable(r16, this));
        return;
    L5:
        if (Api24Impl.isDeviceProtectedStorage(r16) == false) goto L9;
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean isInitialized() {
        if (getInstance() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void setDelegate(@Nullable WorkManagerImpl r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        sDelegatedInstance = r10;     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void tryInitializeMultiProcessSupport() {
        this.mRemoteWorkManager = (RemoteWorkManager) Class.forName(REMOTE_WORK_MANAGER_CLIENT).getConstructor(new Class[]{Context.class, WorkManagerImpl.class}).newInstance(new Object[]{this.mContext, this});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.get().debug(TAG, "Unable to initialize multi-process support", th);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public WorkContinuation beginUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull List<OneTimeWorkRequest> r12) {
        if (r12.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, r10, r11, r12);
    L7:
        throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public WorkContinuation beginWith(@NonNull List<OneTimeWorkRequest> r10) {
        if (r10.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, r10);
    L7:
        throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation cancelAllWork() {
        CancelWorkRunnable r10 = CancelWorkRunnable.forAll(this);
        this.mWorkTaskExecutor.executeOnTaskThread(r10);
        return r10.getOperation();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation cancelAllWorkByTag(@NonNull String r10) {
        CancelWorkRunnable r11 = CancelWorkRunnable.forTag(r10, this);
        this.mWorkTaskExecutor.executeOnTaskThread(r11);
        return r11.getOperation();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation cancelUniqueWork(@NonNull String r10) {
        CancelWorkRunnable r11 = CancelWorkRunnable.forName(r10, this, true);
        this.mWorkTaskExecutor.executeOnTaskThread(r11);
        return r11.getOperation();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation cancelWorkById(@NonNull UUID r10) {
        CancelWorkRunnable r11 = CancelWorkRunnable.forId(r10, this);
        this.mWorkTaskExecutor.executeOnTaskThread(r11);
        return r11.getOperation();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public PendingIntent createCancelPendingIntent(@NonNull UUID r10) {
        Intent r11 = SystemForegroundDispatcher.createCancelWorkIntent(this.mContext, r10.toString());
        if (Build.VERSION.SDK_INT < 31) goto L5;
        int r12 = 167772160;
    L7:
        return PendingIntent.getService(this.mContext, 0, r11, r12);
    L5:
        r12 = 134217728;
        goto L7
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> createSchedulers(@NonNull Context r10, @NonNull Configuration r11, @NonNull Trackers r12) {
        return Arrays.asList(new Scheduler[]{Schedulers.createBestAvailableBackgroundScheduler(r10, this), new GreedyScheduler(r10, r11, r12, this)});
    }

    @NonNull
    public WorkContinuationImpl createWorkContinuationForUniquePeriodicWork(@NonNull String r10, @NonNull ExistingPeriodicWorkPolicy r11, @NonNull PeriodicWorkRequest r12) {
        if (r11 != ExistingPeriodicWorkPolicy.KEEP) goto L5;
        ExistingWorkPolicy r13 = ExistingWorkPolicy.KEEP;
    L7:
        return new WorkContinuationImpl(this, r10, r13, Collections.singletonList(r12));
    L5:
        r13 = ExistingWorkPolicy.REPLACE;
        goto L7
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation enqueue(@NonNull List<? extends WorkRequest> r10) {
        if (r10.isEmpty() == true) goto L7;
        return new WorkContinuationImpl(this, r10).enqueue();
    L7:
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation enqueueUniquePeriodicWork(@NonNull String r10, @NonNull ExistingPeriodicWorkPolicy r11, @NonNull PeriodicWorkRequest r12) {
        if (r11 != ExistingPeriodicWorkPolicy.UPDATE) goto L7;
        return WorkerUpdater.enqueueUniquelyNamedPeriodic(this, r10, r12);
    L7:
        return createWorkContinuationForUniquePeriodicWork(r10, r11, r12).enqueue();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation enqueueUniqueWork(@NonNull String r10, @NonNull ExistingWorkPolicy r11, @NonNull List<OneTimeWorkRequest> r12) {
        return new WorkContinuationImpl(this, r10, r11, r12).enqueue();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Context getApplicationContext() {
        return this.mContext;
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public c6.a<Long> getLastCancelAllTimeMillis() {
        final SettableFuture r10 = SettableFuture.create();
        final PreferenceUtils r11 = this.mPreferenceUtils;
        this.mWorkTaskExecutor.executeOnTaskThread(new AnonymousClass1(this, r10, r11));
        return r10;
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<Long> getLastCancelAllTimeMillisLiveData() {
        return this.mPreferenceUtils.getLastCancelAllTimeMillisLiveData();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public PreferenceUtils getPreferenceUtils() {
        return this.mPreferenceUtils;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Processor getProcessor() {
        return this.mProcessor;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public RemoteWorkManager getRemoteWorkManager() {
        if (this.mRemoteWorkManager != null) goto L21;
        Object r10 = sLock;
        monitor-enter(r10);
    L17:
        th = move-exception;
        throw th;
    L7:
        if (this.mRemoteWorkManager != null) goto L15;
        tryInitializeMultiProcessSupport();     // Catch: Throwable -> L17
        if (this.mRemoteWorkManager != null) goto L15;
        if (TextUtils.isEmpty(this.mConfiguration.getDefaultProcessName()) == true) goto L15;
        throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");     // Catch: Throwable -> L17
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L17
    L21:
        return this.mRemoteWorkManager;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Scheduler> getSchedulers() {
        return this.mSchedulers;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Trackers getTrackers() {
        return this.mTrackers;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public WorkDatabase getWorkDatabase() {
        return this.mWorkDatabase;
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public c6.a<WorkInfo> getWorkInfoById(@NonNull UUID r10) {
        StatusRunnable<WorkInfo> r11 = StatusRunnable.forUUID(this, r10);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r11);
        return r11.getFuture();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<WorkInfo> getWorkInfoByIdLiveData(@NonNull UUID r10) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(Collections.singletonList(r10.toString())), new AnonymousClass2(this), this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public c6.a<List<WorkInfo>> getWorkInfos(@NonNull WorkQuery r10) {
        StatusRunnable<List<WorkInfo>> r11 = StatusRunnable.forWorkQuerySpec(this, r10);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r11);
        return r11.getFuture();
    }

    LiveData<List<WorkInfo>> getWorkInfosById(@NonNull List<String> r10) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForIds(r10), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public c6.a<List<WorkInfo>> getWorkInfosByTag(@NonNull String r10) {
        StatusRunnable<List<WorkInfo>> r11 = StatusRunnable.forTag(this, r10);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r11);
        return r11.getFuture();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosByTagLiveData(@NonNull String r10) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForTag(r10), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public c6.a<List<WorkInfo>> getWorkInfosForUniqueWork(@NonNull String r10) {
        StatusRunnable<List<WorkInfo>> r11 = StatusRunnable.forUniqueWork(this, r10);
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r11);
        return r11.getFuture();
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosForUniqueWorkLiveData(@NonNull String r10) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.workSpecDao().getWorkStatusPojoLiveDataForName(r10), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public LiveData<List<WorkInfo>> getWorkInfosLiveData(@NonNull WorkQuery r10) {
        return LiveDataUtils.dedupedMappedLiveDataFor(this.mWorkDatabase.rawWorkInfoDao().getWorkInfoPojosLiveData(RawQueries.toRawQuery(r10)), WorkSpec.WORK_INFO_MAPPER, this.mWorkTaskExecutor);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public TaskExecutor getWorkTaskExecutor() {
        return this.mWorkTaskExecutor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onForceStopRunnableCompleted() {
        Object r10 = sLock;
        monitor-enter(r10);
        this.mForceStopRunnableCompleted = true;     // Catch: Throwable -> L10
        BroadcastReceiver.PendingResult r11 = this.mRescheduleReceiverResult;     // Catch: Throwable -> L10
        if (r11 == null) goto L8;
        r11.finish();     // Catch: Throwable -> L10
        this.mRescheduleReceiverResult = null;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public Operation pruneWork() {
        PruneWorkRunnable r10 = new PruneWorkRunnable(this);
        this.mWorkTaskExecutor.executeOnTaskThread(r10);
        return r10.getOperation();
    }

    public void rescheduleEligibleWork() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        SystemJobScheduler.cancelAll(getApplicationContext());
    L5:
        getWorkDatabase().workSpecDao().resetScheduledState();
        Schedulers.schedule(getConfiguration(), getWorkDatabase(), getSchedulers());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setReschedulePendingResult(@NonNull BroadcastReceiver.PendingResult r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        BroadcastReceiver.PendingResult r12 = this.mRescheduleReceiverResult;     // Catch: Throwable -> L12
        if (r12 == null) goto L7;
        r12.finish();     // Catch: Throwable -> L12
    L7:
        this.mRescheduleReceiverResult = r10;     // Catch: Throwable -> L12
        if (this.mForceStopRunnableCompleted == false) goto L10;
        r10.finish();     // Catch: Throwable -> L12
        this.mRescheduleReceiverResult = null;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void startWork(@NonNull StartStopToken r10) {
        startWork(r10, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void startWork(@NonNull StartStopToken r10, @Nullable WorkerParameters.RuntimeExtras r11) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StartWorkRunnable(this, r10, r11));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopForegroundWork(@NonNull WorkGenerationalId r10) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this, new StartStopToken(r10), true));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void stopWork(@NonNull StartStopToken r10) {
        this.mWorkTaskExecutor.executeOnTaskThread(new StopWorkRunnable(this, r10, false));
    }

    @Override // androidx.work.WorkManager
    @NonNull
    public c6.a<WorkManager.UpdateResult> updateWork(@NonNull WorkRequest r10) {
        return WorkerUpdater.updateWorkImpl(this, r10);
    }
}
