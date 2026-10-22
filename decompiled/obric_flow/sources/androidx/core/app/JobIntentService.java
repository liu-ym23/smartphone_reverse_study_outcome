package androidx.core.app;

import ai.j0;
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
import android.os.IBinder;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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

    public final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ JobIntentService this$0;

        public CommandProcessor(JobIntentService r5) {
            this.this$0 = r5;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(Void[] r5) {
            return doInBackground2(r5);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onCancelled(Void r5) {
            onCancelled2(r5);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Void r5) {
            onPostExecute2(r5);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        public Void doInBackground2(Void... r5) {
        L2:
            GenericWorkItem r10 = this.this$0.dequeueWork();
            if (r10 == null) goto L5;
            this.this$0.onHandleWork(r10.getIntent());
            r10.complete();
            goto L2
        L5:
            return null;
        }

        /* JADX INFO: renamed from: onCancelled, reason: avoid collision after fix types in other method */
        public void onCancelled2(Void r5) {
            this.this$0.processorFinished();
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        public void onPostExecute2(Void r5) {
            this.this$0.processorFinished();
        }
    }

    public interface CompatJobEngine {
        IBinder compatGetBinder();

        GenericWorkItem dequeueWork();
    }

    public static final class CompatWorkEnqueuer extends WorkEnqueuer {
        private final Context mContext;
        private final PowerManager.WakeLock mLaunchWakeLock;
        boolean mLaunchingService;
        private final PowerManager.WakeLock mRunWakeLock;
        boolean mServiceProcessing;

        public CompatWorkEnqueuer(Context r5, ComponentName r10) {
            super(r10);
            this.mContext = r5.getApplicationContext();
            PowerManager r11 = (PowerManager) r5.getSystemService("power");
            PowerManager.WakeLock r12 = r11.newWakeLock(1, r10.getClassName() + ":launch");
            this.mLaunchWakeLock = r12;
            r12.setReferenceCounted(false);
            PowerManager.WakeLock r13 = r11.newWakeLock(1, r10.getClassName() + ":run");
            this.mRunWakeLock = r13;
            r13.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(Intent r5) {
            Intent r10 = new Intent(r5);
            r10.setComponent(this.mComponentName);
            if (this.mContext.startService(r10) == null) goto L16;
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L6:
            if (this.mLaunchingService == true) goto L12;
            this.mLaunchingService = true;     // Catch: Throwable -> L10
            if (this.mServiceProcessing == true) goto L12;
            this.mLaunchWakeLock.acquire(60000);     // Catch: Throwable -> L10
        L12:
            monitor-exit(this);     // Catch: Throwable -> L10
            return;
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingFinished() {
            monitor-enter(this);
        L8:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L6;
        L11:
            monitor-exit(this);     // Catch: Throwable -> L8
            return;
        L6:
            if (this.mLaunchingService == false) goto L10;
            this.mLaunchWakeLock.acquire(60000);     // Catch: Throwable -> L8
        L10:
            this.mServiceProcessing = false;     // Catch: Throwable -> L8
            this.mRunWakeLock.release();     // Catch: Throwable -> L8
            goto L11
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void serviceProcessingStarted() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mServiceProcessing == true) goto L8;
            this.mServiceProcessing = true;     // Catch: Throwable -> L6
            this.mRunWakeLock.acquire(600000);     // Catch: Throwable -> L6
            this.mLaunchWakeLock.release();     // Catch: Throwable -> L6
        L8:
            monitor-exit(this);     // Catch: Throwable -> L6
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

    public final class CompatWorkItem implements GenericWorkItem {
        final Intent mIntent;
        final int mStartId;
        final /* synthetic */ JobIntentService this$0;

        public CompatWorkItem(JobIntentService r5, Intent r10, int r11) {
            this.this$0 = r5;
            this.mIntent = r10;
            this.mStartId = r11;
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

    public interface GenericWorkItem {
        void complete();

        Intent getIntent();
    }

    @RequiresApi(26)
    public static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        static final boolean DEBUG = false;
        static final String TAG = "JobServiceEngineImpl";
        final Object mLock;
        JobParameters mParams;
        final JobIntentService mService;

        public final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem mJobWork;
            final /* synthetic */ JobServiceEngineImpl this$0;

            public WrapperWorkItem(JobServiceEngineImpl r5, JobWorkItem r10) {
                this.this$0 = r5;
                this.mJobWork = r10;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public void complete() {
                Object r5 = this.this$0.mLock;
                monitor-enter(r5);
                JobParameters r10 = this.this$0.mParams;     // Catch: Throwable -> L7
                if (r10 == null) goto L9;
                r10.completeWork(this.mJobWork);     // Catch: Throwable -> L7
            L9:
                monitor-exit(r5);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // androidx.core.app.JobIntentService.GenericWorkItem
            public Intent getIntent() {
                return this.mJobWork.getIntent();
            }
        }

        public JobServiceEngineImpl(JobIntentService r5) {
            super(r5);
            this.mLock = new Object();
            this.mService = r5;
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public IBinder compatGetBinder() {
            return getBinder();
        }

        @Override // androidx.core.app.JobIntentService.CompatJobEngine
        public GenericWorkItem dequeueWork() {
            Object r5 = this.mLock;
            monitor-enter(r5);
            JobParameters r10 = this.mParams;     // Catch: Throwable -> L8
            if (r10 != null) goto L10;
            monitor-exit(r5);     // Catch: Throwable -> L8
            return null;
        L10:
            JobWorkItem r11 = r10.dequeueWork();     // Catch: Throwable -> L8
            monitor-exit(r5);     // Catch: Throwable -> L8
            if (r11 == null) goto L15;
            r11.getIntent().setExtrasClassLoader(this.mService.getClassLoader());
            return new WrapperWorkItem(this, r11);
        L15:
            return null;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters r5) {
            this.mParams = r5;
            this.mService.ensureProcessorRunningLocked(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters r5) {
            boolean r10 = this.mService.doStopCurrentWork();
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mParams = null;     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            return r10;
        L8:
            th = move-exception;
            throw th;
        }
    }

    @RequiresApi(26)
    public static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo mJobInfo;
        private final JobScheduler mJobScheduler;

        public JobWorkEnqueuer(Context r5, ComponentName r10, int r11) {
            super(r10);
            ensureJobId(r11);
            this.mJobInfo = new JobInfo.Builder(r11, this.mComponentName).setOverrideDeadline(0).build();
            this.mJobScheduler = (JobScheduler) r5.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // androidx.core.app.JobIntentService.WorkEnqueuer
        public void enqueueWork(Intent r5) {
            this.mJobScheduler.enqueue(this.mJobInfo, new JobWorkItem(r5));
        }
    }

    public static abstract class WorkEnqueuer {
        final ComponentName mComponentName;
        boolean mHasJobId;
        int mJobId;

        public WorkEnqueuer(ComponentName r5) {
            this.mComponentName = r5;
        }

        public abstract void enqueueWork(Intent r5);

        public void ensureJobId(int r5) {
            if (this.mHasJobId == true) goto L6;
            this.mHasJobId = true;
            this.mJobId = r5;
            return;
        L6:
            if (this.mJobId == r5) goto L10;
            StringBuilder r10 = j0.s(r5, "Given job ID ", " is different than previous ");
            r10.append(this.mJobId);
            throw new IllegalArgumentException(r10.toString());
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
        this.mCompatQueue = null;
    }

    public static void enqueueWork(@NonNull Context r5, @NonNull Class<?> r10, int r11, @NonNull Intent r12) {
        enqueueWork(r5, new ComponentName(r5, r10), r11, r12);
    }

    public static WorkEnqueuer getWorkEnqueuer(Context r5, ComponentName r10, boolean r11, int r12) {
        HashMap<ComponentName, WorkEnqueuer> r13 = sClassWorkEnqueuer;
        WorkEnqueuer r14 = r13.get(r10);
        if (r14 != null) goto L8;
        if (r11 == false) goto L7;
        JobWorkEnqueuer r15 = new JobWorkEnqueuer(r5, r10, r12);
        r13.put(r10, r15);
        return r15;
    L7:
        throw new IllegalArgumentException("Can't be here without a job id");
    L8:
        return r14;
    }

    public GenericWorkItem dequeueWork() {
        CompatJobEngine r5 = this.mJobImpl;
        if (r5 != null) goto L5;
        ArrayList<CompatWorkItem> r10 = this.mCompatQueue;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mCompatQueue.size() <= 0) goto L15;
        CompatWorkItem r11 = this.mCompatQueue.remove(0);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r11;
    L15:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return null;
    L5:
        return r5.dequeueWork();
    }

    public boolean doStopCurrentWork() {
        CommandProcessor r5 = this.mCurProcessor;
        if (r5 == null) goto L5;
        r5.cancel(this.mInterruptIfStopped);
    L5:
        this.mStopped = true;
        return onStopCurrentWork();
    }

    public void ensureProcessorRunningLocked(boolean r5) {
        if (this.mCurProcessor != null) goto L10;
        this.mCurProcessor = new CommandProcessor(this);
        WorkEnqueuer r10 = this.mCompatWorkEnqueuer;
        if (r10 == null) goto L8;
        if (r5 == false) goto L8;
        r10.serviceProcessingStarted();
    L8:
        this.mCurProcessor.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return;
    }

    public boolean isStopped() {
        return this.mStopped;
    }

    @Override // android.app.Service
    public IBinder onBind(@NonNull Intent r5) {
        CompatJobEngine r10 = this.mJobImpl;
        if (r10 != null) goto L5;
        return null;
    L5:
        return r10.compatGetBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mJobImpl = new JobServiceEngineImpl(this);
        this.mCompatWorkEnqueuer = null;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<CompatWorkItem> r5 = this.mCompatQueue;
        if (r5 == null) goto L12;
        monitor-enter(r5);
        this.mDestroyed = true;     // Catch: Throwable -> L9
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L9
        monitor-exit(r5);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public abstract void onHandleWork(@NonNull Intent r5);

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent r5, int r10, int r11) {
        if (this.mCompatQueue == null) goto L17;
        this.mCompatWorkEnqueuer.serviceStartReceived();
        ArrayList<CompatWorkItem> r12 = this.mCompatQueue;
        monitor-enter(r12);
        ArrayList<CompatWorkItem> r13 = this.mCompatQueue;     // Catch: Throwable -> L14
        if (r5 != null) goto L10;
        r5 = new Intent();     // Catch: Throwable -> L14
    L10:
        r13.add(new CompatWorkItem(this, r5, r11));     // Catch: Throwable -> L14
        ensureProcessorRunningLocked(true);     // Catch: Throwable -> L14
        monitor-exit(r12);     // Catch: Throwable -> L14
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

    public void processorFinished() {
        ArrayList<CompatWorkItem> r5 = this.mCompatQueue;
        if (r5 == null) goto L20;
        monitor-enter(r5);
        this.mCurProcessor = null;     // Catch: Throwable -> L11
        ArrayList<CompatWorkItem> r10 = this.mCompatQueue;     // Catch: Throwable -> L11
        if (r10 == null) goto L14;
        if (r10.size() <= 0) goto L14;
        ensureProcessorRunningLocked(false);     // Catch: Throwable -> L11
    L16:
        monitor-exit(r5);     // Catch: Throwable -> L11
        return;
    L14:
        if (this.mDestroyed == true) goto L16;
        this.mCompatWorkEnqueuer.serviceProcessingFinished();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void setInterruptIfStopped(boolean r5) {
        this.mInterruptIfStopped = r5;
    }

    public static void enqueueWork(@NonNull Context r5, @NonNull ComponentName r10, int r11, @NonNull Intent r12) {
        if (r12 == null) goto L13;
        Object r13 = sLock;
        monitor-enter(r13);
        WorkEnqueuer r14 = getWorkEnqueuer(r5, r10, true, r11);     // Catch: Throwable -> L9
        r14.ensureJobId(r11);     // Catch: Throwable -> L9
        r14.enqueueWork(r12);     // Catch: Throwable -> L9
        monitor-exit(r13);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("work must not be null");
    }
}
