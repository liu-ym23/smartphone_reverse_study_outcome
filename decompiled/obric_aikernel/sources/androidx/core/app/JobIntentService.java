package androidx.core.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class JobIntentService extends Service {
    static final boolean DEBUG = false;
    static final String TAG = "JobIntentService";
    static final HashMap<ComponentName, WorkEnqueuer> sClassWorkEnqueuer = null;
    static final Object sLock = null;
    final ArrayList<CompatWorkItem> mCompatQueue;
    WorkEnqueuer mCompatWorkEnqueuer;
    CommandProcessor mCurProcessor;
    boolean mDestroyed;
    boolean mInterruptIfStopped;
    CompatJobEngine mJobImpl;
    boolean mStopped;

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ JobIntentService this$0;

        CommandProcessor(JobIntentService r10) {
            this.this$0 = r10;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Void doInBackground(Void[] r10) {
            return doInBackground2(r10);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(Void... r10) {
        L2:
            GenericWorkItem r11 = this.this$0.dequeueWork();
            if (r11 == null) goto L5;
            this.this$0.onHandleWork(r11.getIntent());
            r11.complete();
            goto L2
        L5:
            return null;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onCancelled(Void r10) {
            onCancelled2(r10);
        }

        /* JADX INFO: renamed from: onCancelled, reason: avoid collision after fix types in other method */
        protected void onCancelled2(Void r10) {
            this.this$0.processorFinished();
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Void r10) {
            onPostExecute2(r10);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r10) {
            this.this$0.processorFinished();
        }
    }

    interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        CompatWorkEnqueuer(Context r10, ComponentName r11) {
            super(r11);
            this.mContext = r10.getApplicationContext();
            PowerManager r12 = (PowerManager) r10.getSystemService("power");
            PowerManager.WakeLock r13 = r12.newWakeLock(1, r11.getClassName() + ":launch");
            this.mLaunchWakeLock = r13;
            r13.setReferenceCounted(false);
            PowerManager.WakeLock r14 = r12.newWakeLock(1, r11.getClassName() + ":run");
            this.mRunWakeLock = r14;
            r14.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void enqueueWork(Intent r10) {
            Intent r11 = new Intent(r10);
            r11.setComponent(this.mComponentName);
            if (this.mContext.startService(r11) == null) goto L15;
            monitor-enter(this);
        L12:
            th = move-exception;
            throw th;
        L6:
            if (this.mLaunchingService == true) goto L10;
            this.mLaunchingService = true;     // Catch: Throwable -> L12
            if (this.mServiceProcessing == true) goto L10;
            this.mLaunchWakeLock.acquire(VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);     // Catch: Throwable -> L12
        L10:
            monitor-exit(this);     // Catch: Throwable -> L12
            return;
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L6;
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return;
        L6:
            if (this.mLaunchingService == false) goto L8;
            this.mLaunchWakeLock.acquire(VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);     // Catch: Throwable -> L11
        L8:
            this.mServiceProcessing = false;     // Catch: Throwable -> L11
            this.mRunWakeLock.release();     // Catch: Throwable -> L11
            goto L9
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L6;
            this.mServiceProcessing = true;     // Catch: Throwable -> L8
            this.mRunWakeLock.acquire(600000);     // Catch: Throwable -> L8
            this.mLaunchWakeLock.release();     // Catch: Throwable -> L8
        L6:
            monitor-exit(this);     // Catch: Throwable -> L8
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceStartReceived() {
            monitor-enter(this);
            this.mLaunchingService = false;     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;
        final /* synthetic */ JobIntentService this$0;

        CompatWorkItem(JobIntentService r10, Intent r11, int r12) {
            this.this$0 = r10;
            this.mIntent = r11;
            this.mStartId = r12;
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public void complete() {
            this.this$0.stopSelf(this.mStartId);
        }

        @Override // androidx.core.app.JobIntentService.GenericWorkItem
        public Intent getIntent() {
            return this.mIntent;
        }
    }

    interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi(26)
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;
            final /* synthetic */ JobServiceEngineImpl this$0;

            WrapperWorkItem(JobServiceEngineImpl r10, JobWorkItem r11) {
                this.this$0 = r10;
                this.mJobWork = r11;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                Object r10 = this.this$0.mLock;
                monitor-enter(r10);
                JobParameters r11 = this.this$0.mParams;     // Catch: Throwable -> L9
                if (r11 == null) goto L7;
                r11.completeWork(this.mJobWork);     // Catch: Throwable -> L9
            L7:
                monitor-exit(r10);     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                throw th;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        JobServiceEngineImpl(JobIntentService r10) {
            super(r10);
            this.mLock = new Object();
            this.mService = r10;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            Object r10 = this.mLock;
            monitor-enter(r10);
            JobParameters r11 = this.mParams;     // Catch: Throwable -> L14
            if (r11 != null) goto L8;
            monitor-exit(r10);     // Catch: Throwable -> L14
            return null;
        L8:
            JobWorkItem r12 = r11.dequeueWork();     // Catch: Throwable -> L14
            monitor-exit(r10);     // Catch: Throwable -> L14
            if (r12 == null) goto L13;
            r12.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
            return new WrapperWorkItem(this, r12);
        L13:
            return null;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters r10) {
            this.mParams = r10;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters r10) {
            boolean r11 = this.mService.doStopCurrentWork();
            Object r12 = this.mLock;
            monitor-enter(r12);
            this.mParams = null;     // Catch: Throwable -> L8
            monitor-exit(r12);     // Catch: Throwable -> L8
            return r11;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @RequiresApi(26)
    static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        JobWorkEnqueuer(Context r10, ComponentName r11, int r12) {
            super(r11);
            ensureJobId(r12);
            this.mJobInfo = new JobInfo.Builder(r12, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) r10.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        void enqueueWork(Intent r10) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(r10));
        }
    }

    static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        WorkEnqueuer(ComponentName r10) {
            this.mComponentName = r10;
        }

        abstract void enqueueWork(Intent r10);

        void ensureJobId(int r10) {
            if (this.mHasJobId == true) goto L6;
            this.mHasJobId = true;
            this.mJobId = r10;
            return;
        L6:
            if (this.mJobId != r10) goto L9;
            return;
        L9:
            throw new IllegalArgumentException("Given job ID " + r10 + " is different than previous " + this.mJobId);
        }

        public void serviceProcessingFinished() {
        }

        public void serviceProcessingStarted() {
        }

        public void serviceStartReceived() {
        }
    }

    static {
        sLock = new Object();
        sClassWorkEnqueuer = new HashMap();
    }

    public JobIntentService() {
        this.mInterruptIfStopped = false;
        this.mStopped = false;
        this.mDestroyed = false;
        if (Build.VERSION.SDK_INT < 26) goto L5;
        ArrayList<CompatWorkItem> r10 = null;
    L6:
        this.mCompatQueue = r10;
        return;
    L5:
        r10 = new ArrayList();
        goto L6
    }

    public static void enqueueWork(@NonNull Context r10, @NonNull ComponentName r11, int r12, @NonNull Intent r13) {
        if (r13 == null) goto L13;
        Object r14 = sLock;
        monitor-enter(r14);
        WorkEnqueuer r15 = getWorkEnqueuer(r10, r11, true, r12);     // Catch: Throwable -> L9
        r15.ensureJobId(r12);     // Catch: Throwable -> L9
        r15.enqueueWork(r13);     // Catch: Throwable -> L9
        monitor-exit(r14);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("work must not be null");
    }

    public static void enqueueWork(@NonNull Context r10, @NonNull Class<?> r11, int r12, @NonNull Intent r13) {
        enqueueWork(r10, new ComponentName(r10, r11), r12, r13);
    }

    static WorkEnqueuer getWorkEnqueuer(Context r10, ComponentName r11, boolean r12, int r13) {
        HashMap<ComponentName, WorkEnqueuer> r14 = sClassWorkEnqueuer;
        WorkEnqueuer r15 = r14.get(r11);
        if (r15 == null) goto L5;
        return r15;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        if (r12 == false) goto L9;
        WorkEnqueuer r16 = new JobWorkEnqueuer(r10, r11, r13);
    L11:
        WorkEnqueuer r17 = r16;
        r14.put(r11, r17);
        return r17;
    L9:
        throw new IllegalArgumentException("Can't be here without a job id");
    L10:
        r16 = new CompatWorkEnqueuer(r10, r11);
        goto L11
    }

    GenericWorkItem dequeueWork() {
        CompatJobEngine r10 = this.mJobImpl;
        if (r10 != null) goto L5;
        ArrayList<CompatWorkItem> r11 = this.mCompatQueue;
        monitor-enter(r11);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.mCompatQueue.size() <= 0) goto L14;
        CompatWorkItem r12 = this.mCompatQueue.remove(0);     // Catch: Throwable -> L16
        monitor-exit(r11);     // Catch: Throwable -> L16
        return r12;
    L14:
        monitor-exit(r11);     // Catch: Throwable -> L16
        return null;
    L5:
        return r10.dequeueWork();
    }

    boolean doStopCurrentWork() {
        CommandProcessor r10 = this.mCurProcessor;
        if (r10 == null) goto L5;
        r10.cancel(this.mInterruptIfStopped);
    L5:
        this.mStopped = true;
        return onStopCurrentWork();
    }

    void ensureProcessorRunningLocked(boolean r10) {
        if (this.mCurProcessor != null) goto L10;
        this.mCurProcessor = new CommandProcessor(this);
        WorkEnqueuer r11 = this.mCompatWorkEnqueuer;
        if (r11 == null) goto L8;
        if (r10 == false) goto L8;
        r11.serviceProcessingStarted();
    L8:
        this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent r10) {
        CompatJobEngine r11 = this.mJobImpl;
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.compatGetBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        this.mJobImpl = new JobServiceEngineImpl(this);
        this.mCompatWorkEnqueuer = null;
        return;
    L5:
        this.mJobImpl = null;
        this.mCompatWorkEnqueuer = getWorkEnqueuer(this, new ComponentName(this, getClass()), false, 0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> r10 = this.mCompatQueue;
        if (r10 == null) goto L12;
        monitor-enter(r10);
        this.mDestroyed = true;     // Catch: Throwable -> L9
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    protected abstract void onHandleWork(@NonNull Intent r10);

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent r10, int r11, int r12) {
        if (this.mCompatQueue == null) goto L17;
        this.mCompatWorkEnqueuer.serviceStartReceived();
        ArrayList<CompatWorkItem> r13 = this.mCompatQueue;
        monitor-enter(r13);
        ArrayList<CompatWorkItem> r14 = this.mCompatQueue;     // Catch: Throwable -> L14
        if (r10 != null) goto L10;
        r10 = new Intent();     // Catch: Throwable -> L14
    L10:
        r14.add(new CompatWorkItem(this, r10, r12));     // Catch: Throwable -> L14
        ensureProcessorRunningLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r13);     // Catch: Throwable -> L14
        return 3;
    L14:
        th = move-exception;
        throw th;
    L17:
        return 2;
    }

    public boolean onStopCurrentWork() {
        return true;
    }

    void processorFinished() {
        ArrayList<CompatWorkItem> r10 = this.mCompatQueue;
        if (r10 == null) goto L19;
        monitor-enter(r10);
        this.mCurProcessor = null;     // Catch: Throwable -> L16
        ArrayList<CompatWorkItem> r11 = this.mCompatQueue;     // Catch: Throwable -> L16
        if (r11 == null) goto L12;
        if (r11.size() <= 0) goto L12;
        ensureProcessorRunningLocked(false);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L12:
        if (this.mDestroyed == true) goto L14;
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void setInterruptIfStopped(boolean r10) {
        this.mInterruptIfStopped = r10;
    }
}
