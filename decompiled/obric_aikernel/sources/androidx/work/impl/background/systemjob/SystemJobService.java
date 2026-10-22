package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.net.Network;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobService extends JobService implements ExecutionListener {
    private static final String TAG = null;
    private final Map<WorkGenerationalId, JobParameters> mJobParameters;
    private final StartStopTokens mStartStopTokens;
    private WorkManagerImpl mWorkManagerImpl;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static String[] getTriggeredContentAuthorities(JobParameters r10) {
            return r10.getTriggeredContentAuthorities();
        }

        @DoNotInline
        static Uri[] getTriggeredContentUris(JobParameters r10) {
            return r10.getTriggeredContentUris();
        }
    }

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static Network getNetwork(JobParameters r10) {
            return r10.getNetwork();
        }
    }

    static {
        TAG = Logger.tagWithPrefix("SystemJobService");
    }

    public SystemJobService() {
        this.mJobParameters = new HashMap();
        this.mStartStopTokens = new StartStopTokens();
    }

    @Nullable
    private static WorkGenerationalId workGenerationalIdFromJobParameters(@NonNull JobParameters r10) {
        PersistableBundle r11 = r10.getExtras();     // Catch: NullPointerException -> L11
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L14;
        return new WorkGenerationalId(r11.getString("EXTRA_WORK_SPEC_ID"), r11.getInt("EXTRA_WORK_SPEC_GENERATION"));
    L14:
        return null;
    L15:
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        WorkManagerImpl r10 = WorkManagerImpl.getInstance(getApplicationContext());     // Catch: IllegalStateException -> L5
        this.mWorkManagerImpl = r10;     // Catch: IllegalStateException -> L5
        r10.getProcessor().addExecutionListener(this);     // Catch: IllegalStateException -> L5
        return;
    L6:
        if (Application.class.equals(getApplication().getClass()) == false) goto L10;
        Logger.get().warning(TAG, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.");
        return;
    L10:
        throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        WorkManagerImpl r10 = this.mWorkManagerImpl;
        if (r10 == null) goto L6;
        r10.getProcessor().removeExecutionListener(this);
        return;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull WorkGenerationalId r10, boolean r11) {
        Logger.get().debug(TAG, r10.getWorkSpecId() + " executed on JobScheduler");
        Map<WorkGenerationalId, JobParameters> r12 = this.mJobParameters;
        monitor-enter(r12);
        JobParameters r13 = this.mJobParameters.remove(r10);     // Catch: Throwable -> L10
        monitor-exit(r12);     // Catch: Throwable -> L10
        this.mStartStopTokens.remove(r10);
        if (r13 == null) goto L15;
        jobFinished(r13, r11);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@NonNull JobParameters r10) {
        if (this.mWorkManagerImpl != null) goto L6;
        Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.");
        jobFinished(r10, true);
        return false;
    L6:
        WorkGenerationalId r11 = workGenerationalIdFromJobParameters(r10);
        if (r11 != null) goto L10;
        Logger.get().error(TAG, "WorkSpec id not found!");
        return false;
    L10:
        Map<WorkGenerationalId, JobParameters> r12 = this.mJobParameters;
        monitor-enter(r12);
    L32:
        th = move-exception;
        throw th;
    L13:
        if (this.mJobParameters.containsKey(r11) == false) goto L17;
        Logger.get().debug(TAG, "Job is already being executed by SystemJobService: " + r11);     // Catch: Throwable -> L32
        monitor-exit(r12);     // Catch: Throwable -> L32
        return false;
    L17:
        Logger.get().debug(TAG, "onStartJob for " + r11);     // Catch: Throwable -> L32
        this.mJobParameters.put(r11, r10);     // Catch: Throwable -> L32
        monitor-exit(r12);     // Catch: Throwable -> L32
        WorkerParameters.RuntimeExtras r13 = null;
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 24) goto L30;
        r13 = new WorkerParameters.RuntimeExtras();
        if (Api24Impl.getTriggeredContentUris(r10) == null) goto L25;
        r13.triggeredContentUris = Arrays.asList(Api24Impl.getTriggeredContentUris(r10));
    L25:
        if (Api24Impl.getTriggeredContentAuthorities(r10) == null) goto L28;
        r13.triggeredContentAuthorities = Arrays.asList(Api24Impl.getTriggeredContentAuthorities(r10));
    L28:
        if (r14 < 28) goto L30;
        r13.network = Api28Impl.getNetwork(r10);
    L30:
        this.mWorkManagerImpl.startWork(this.mStartStopTokens.tokenFor(r11), r13);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@NonNull JobParameters r10) {
        if (this.mWorkManagerImpl != null) goto L6;
        Logger.get().debug(TAG, "WorkManager is not initialized; requesting retry.");
        return true;
    L6:
        WorkGenerationalId r11 = workGenerationalIdFromJobParameters(r10);
        if (r11 != null) goto L10;
        Logger.get().error(TAG, "WorkSpec id not found!");
        return false;
    L10:
        Logger.get().debug(TAG, "onStopJob for " + r11);
        Map<WorkGenerationalId, JobParameters> r12 = this.mJobParameters;
        monitor-enter(r12);
        this.mJobParameters.remove(r11);     // Catch: Throwable -> L19
        monitor-exit(r12);     // Catch: Throwable -> L19
        StartStopToken r13 = this.mStartStopTokens.remove(r11);
        if (r13 == null) goto L18;
        this.mWorkManagerImpl.stopWork(r13);
    L18:
        return !this.mWorkManagerImpl.getProcessor().isCancelled(r11.getWorkSpecId());
    L19:
        th = move-exception;
        throw th;
    }
}
