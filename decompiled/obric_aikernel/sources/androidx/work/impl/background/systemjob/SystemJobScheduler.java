package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.Scheduler;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoKt;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.IdGenerator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemJobScheduler implements Scheduler {
    private static final String TAG = null;
    private final Context mContext;
    private final JobScheduler mJobScheduler;
    private final SystemJobInfoConverter mSystemJobInfoConverter;
    private final WorkManagerImpl mWorkManager;

    static {
        TAG = Logger.tagWithPrefix("SystemJobScheduler");
    }

    public SystemJobScheduler(@NonNull Context r10, @NonNull WorkManagerImpl r11) {
        this(r10, r11, (JobScheduler) r10.getSystemService("jobscheduler"), new SystemJobInfoConverter(r10));
    }

    @VisibleForTesting
    public SystemJobScheduler(@NonNull Context r10, @NonNull WorkManagerImpl r11, @NonNull JobScheduler r12, @NonNull SystemJobInfoConverter r13) {
        this.mContext = r10;
        this.mWorkManager = r11;
        this.mJobScheduler = r12;
        this.mSystemJobInfoConverter = r13;
    }

    public static void cancelAll(@NonNull Context r10) {
        JobScheduler r11 = (JobScheduler) r10.getSystemService("jobscheduler");
        if (r11 == null) goto L12;
        List<JobInfo> r12 = getPendingJobs(r10, r11);
        if (r12 != null) goto L7;
        return;
    L7:
        if (r12.isEmpty() == true) goto L15;
        Iterator<JobInfo> r13 = r12.iterator();
    L10:
        if (r13.hasNext() == false) goto L16;
        cancelJobById(r11, r13.next().getId());
        goto L10
    L16:
        return;
    L15:
        return;
    }

    private static void cancelJobById(@NonNull JobScheduler r10, int r11) {
        r10.cancel(r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Logger.get().error(TAG, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", new Object[]{Integer.valueOf(r11)}), th);
    }

    @Nullable
    private static List<Integer> getPendingJobIds(@NonNull Context r10, @NonNull JobScheduler r11, @NonNull String r12) {
        List<JobInfo> r13 = getPendingJobs(r10, r11);
        if (r13 != null) goto L6;
        return null;
    L6:
        ArrayList r14 = new ArrayList(2);
        Iterator<JobInfo> r15 = r13.iterator();
    L8:
        if (r15.hasNext() == false) goto L14;
        JobInfo r16 = r15.next();
        WorkGenerationalId r17 = getWorkGenerationalIdFromJobInfo(r16);
        if (r17 == null) goto L8;
        if (r12.equals(r17.getWorkSpecId()) == false) goto L8;
        r14.add(Integer.valueOf(r16.getId()));
        goto L8
    L14:
        return r14;
    }

    @Nullable
    private static List<JobInfo> getPendingJobs(@NonNull Context r10, @NonNull JobScheduler r11) {
        List<JobInfo> r12 = r11.getAllPendingJobs();     // Catch: Throwable -> L5
    L7:
        if (r12 != null) goto L9;
        return null;
    L9:
        ArrayList r13 = new ArrayList(r12.size());
        ComponentName r14 = new ComponentName(r10, SystemJobService.class);
        Iterator<JobInfo> r15 = r12.iterator();
    L11:
        if (r15.hasNext() == false) goto L15;
        JobInfo r16 = r15.next();
        if (r14.equals(r16.getService()) == false) goto L11;
        r13.add(r16);
        goto L11
    L15:
        return r13;
    L5:
        th = move-exception;
        Logger.get().error(TAG, "getAllPendingJobs() is not reliable on this device.", th);
        r12 = null;
        goto L7
    }

    @Nullable
    private static WorkGenerationalId getWorkGenerationalIdFromJobInfo(@NonNull JobInfo r10) {
        PersistableBundle r11 = r10.getExtras();
        if (r11 != null) goto L11;
        return null;
    L11:
        if (r11.containsKey("EXTRA_WORK_SPEC_ID") == false) goto L13;
        int r12 = r11.getInt("EXTRA_WORK_SPEC_GENERATION", 0);     // Catch: NullPointerException -> L10
        return new WorkGenerationalId(r11.getString("EXTRA_WORK_SPEC_ID"), r12);
    L13:
        return null;
    L14:
        return null;
    }

    public static boolean reconcileJobs(@NonNull Context r10, @NonNull WorkManagerImpl r11) {
        JobScheduler r12 = (JobScheduler) r10.getSystemService("jobscheduler");
        List<JobInfo> r13 = getPendingJobs(r10, r12);
        List<String> r14 = r11.getWorkDatabase().systemIdInfoDao().getWorkSpecIds();
        boolean r15 = false;
        if (r13 == null) goto L5;
        int r16 = r13.size();
    L6:
        HashSet r17 = new HashSet(r16);
        if (r13 != null) goto L9;
    L17:
        Iterator<String> r18 = r14.iterator();
    L19:
        if (r18.hasNext() == false) goto L23;
        if (r17.contains(r18.next()) == true) goto L19;
        Logger.get().debug(TAG, "Reconciling jobs");
        r15 = true;
    L23:
        if (r15 == false) goto L34;
        WorkDatabase r19 = r11.getWorkDatabase();
        r19.beginTransaction();
        WorkSpecDao r20 = r19.workSpecDao();     // Catch: Throwable -> L31
        Iterator<String> r21 = r14.iterator();     // Catch: Throwable -> L31
    L27:
        if (r21.hasNext() == false) goto L29;
        r20.markWorkSpecScheduled(r21.next(), -1);     // Catch: Throwable -> L31
        goto L27
    L29:
        r19.setTransactionSuccessful();     // Catch: Throwable -> L31
        r19.endTransaction();
    L31:
        th = move-exception;
        r19.endTransaction();
        throw th;
    L34:
        return r15;
    L9:
        if (r13.isEmpty() == true) goto L17;
        Iterator<JobInfo> r22 = r13.iterator();
    L12:
        if (r22.hasNext() == false) goto L17;
        JobInfo r23 = r22.next();
        WorkGenerationalId r24 = getWorkGenerationalIdFromJobInfo(r23);
        if (r24 != null) goto L15;
        cancelJobById(r12, r23.getId());
        goto L12
    L15:
        r17.add(r24.getWorkSpecId());
        goto L12
    L5:
        r16 = 0;
        goto L6
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String r10) {
        List<Integer> r11 = getPendingJobIds(this.mContext, this.mJobScheduler, r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L14;
        Iterator<Integer> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        int r13 = r12.next().intValue();
        cancelJobById(this.mJobScheduler, r13);
        goto L8
    L10:
        this.mWorkManager.getWorkDatabase().systemIdInfoDao().removeSystemIdInfo(r10);
        return;
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(@NonNull WorkSpec... r11) {
        WorkDatabase r10 = this.mWorkManager.getWorkDatabase();
        IdGenerator r12 = new IdGenerator(r10);
        int r13 = r11.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L37;
        WorkSpec r15 = r11[r14];
        r10.beginTransaction();
        WorkSpec r16 = r10.workSpecDao().getWorkSpec(r15.id);     // Catch: Throwable -> L34
        if (r16 != null) goto L12;
        Logger.get().warning(TAG, "Skipping scheduling " + r15.id + " because it's no longer in the DB");     // Catch: Throwable -> L34
    L9:
        r10.setTransactionSuccessful();     // Catch: Throwable -> L34
        r10.endTransaction();
        r14 = r14 + 1;
        goto L3
    L12:
        if (r16.state == WorkInfo.State.ENQUEUED) goto L14;
        Logger.get().warning(TAG, "Skipping scheduling " + r15.id + " because it is no longer enqueued");     // Catch: Throwable -> L34
        goto L9
    L14:
        WorkGenerationalId r17 = WorkSpecKt.generationalId(r15);     // Catch: Throwable -> L34
        SystemIdInfo r18 = r10.systemIdInfoDao().getSystemIdInfo(r17);     // Catch: Throwable -> L34
        if (r18 == null) goto L17;
        int r19 = r18.systemId;     // Catch: Throwable -> L34
    L18:
        if (r18 != null) goto L20;
        this.mWorkManager.getWorkDatabase().systemIdInfoDao().insertSystemIdInfo(SystemIdInfoKt.systemIdInfo(r17, r19));     // Catch: Throwable -> L34
    L20:
        scheduleInternal(r15, r19);     // Catch: Throwable -> L34
        if (Build.VERSION.SDK_INT != 23) goto L9;
        List<Integer> r20 = getPendingJobIds(this.mContext, this.mJobScheduler, r15.id);     // Catch: Throwable -> L34
        if (r20 == null) goto L9;
        int r21 = r20.indexOf(Integer.valueOf(r19));     // Catch: Throwable -> L34
        if (r21 < 0) goto L28;
        r20.remove(r21);     // Catch: Throwable -> L34
    L28:
        if (r20.isEmpty() == true) goto L30;
        int r22 = r20.get(0).intValue();     // Catch: Throwable -> L34
    L31:
        scheduleInternal(r15, r22);     // Catch: Throwable -> L34
        goto L9
    L30:
        r22 = r12.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());     // Catch: Throwable -> L34
        goto L31
    L17:
        r19 = r12.nextJobSchedulerIdWithRange(this.mWorkManager.getConfiguration().getMinJobSchedulerId(), this.mWorkManager.getConfiguration().getMaxJobSchedulerId());     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    @VisibleForTesting
    public void scheduleInternal(@NonNull WorkSpec r10, int r11) {
        JobInfo r12 = this.mSystemJobInfoConverter.convert(r10, r11);
        Logger r13 = Logger.get();
        String r14 = TAG;
        r13.debug(r14, "Scheduling work ID " + r10.id + "Job ID " + r11);
    L13:
        e = move-exception;
        List<JobInfo> r15 = getPendingJobs(this.mContext, this.mJobScheduler);
        if (r15 == null) goto L17;
        int r16 = r15.size();
    L18:
        String r17 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", new Object[]{Integer.valueOf(r16), Integer.valueOf(this.mWorkManager.getWorkDatabase().workSpecDao().getScheduledWork().size()), Integer.valueOf(this.mWorkManager.getConfiguration().getMaxSchedulerLimit())});
        Logger.get().error(TAG, r17);
        IllegalStateException r18 = new IllegalStateException(r17, e);
        Consumer<Throwable> r19 = this.mWorkManager.getConfiguration().getSchedulingExceptionHandler();
        if (r19 == null) goto L22;
        r19.accept(r18);
        return;
    L22:
        throw r18;
    L17:
        r16 = 0;
    L11:
        th = move-exception;
        Logger.get().error(TAG, "Unable to schedule " + r10, th);
        return;
    L4:
        if (this.mJobScheduler.schedule(r12) != 0) goto L25;
        Logger.get().warning(r14, "Unable to schedule work ID " + r10.id);     // Catch: Throwable -> L11 IllegalStateException -> L13
        if (r10.expedited == true) goto L8;
        return;
    L8:
        if (r10.outOfQuotaPolicy != OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) goto L27;
        r10.expedited = false;     // Catch: Throwable -> L11 IllegalStateException -> L13
        Logger.get().debug(r14, String.format("Scheduling a non-expedited job (work ID %s)", new Object[]{r10.id}));     // Catch: Throwable -> L11 IllegalStateException -> L13
        scheduleInternal(r10, r11);     // Catch: Throwable -> L11 IllegalStateException -> L13
    L29:
        return;
    L27:
        return;
    }
}
