package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.util.Consumer;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {

    @VisibleForTesting
    static final String ACTION_FORCE_STOP_RESCHEDULE = "ACTION_FORCE_STOP_RESCHEDULE";
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300;

    @VisibleForTesting
    static final int MAX_ATTEMPTS = 3;
    private static final String TAG = null;
    private static final long TEN_YEARS = 0;
    private final Context mContext;
    private final PreferenceUtils mPreferenceUtils;
    private int mRetryCount;
    private final WorkManagerImpl mWorkManager;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String TAG = null;

        static {
            TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");
        }

        public BroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context r10, @Nullable Intent r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            if (ForceStopRunnable.ACTION_FORCE_STOP_RESCHEDULE.equals(r11.getAction()) == false) goto L8;
            Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.");
            ForceStopRunnable.setAlarm(r10);
            return;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("ForceStopRunnable");
        TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    }

    public ForceStopRunnable(@NonNull Context r10, @NonNull WorkManagerImpl r11) {
        this.mContext = r10.getApplicationContext();
        this.mWorkManager = r11;
        this.mPreferenceUtils = r11.getPreferenceUtils();
        this.mRetryCount = 0;
    }

    @VisibleForTesting
    static Intent getIntent(Context r10) {
        Intent r11 = new Intent();
        r11.setComponent(new ComponentName(r10, BroadcastReceiver.class));
        r11.setAction(ACTION_FORCE_STOP_RESCHEDULE);
        return r11;
    }

    private static PendingIntent getPendingIntent(Context r10, int r11) {
        return PendingIntent.getBroadcast(r10, -1, getIntent(r10), r11);
    }

    @SuppressLint({"ClassVerificationFailure"})
    static void setAlarm(Context r10) {
        AlarmManager r11 = (AlarmManager) r10.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 31) goto L5;
        int r13 = 167772160;
    L6:
        PendingIntent r14 = getPendingIntent(r10, r13);
        long r15 = System.currentTimeMillis() + TEN_YEARS;
        if (r11 != null) goto L9;
        return;
    L9:
        if (r12 < 19) goto L11;
        r11.setExact(0, r15, r14);
        return;
    L11:
        r11.set(0, r15, r14);
        return;
    L5:
        r13 = 134217728;
        goto L6
    }

    @VisibleForTesting
    public boolean cleanUp() {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        boolean r10 = SystemJobScheduler.reconcileJobs(this.mContext, this.mWorkManager);
    L6:
        WorkDatabase r11 = this.mWorkManager.getWorkDatabase();
        WorkSpecDao r12 = r11.workSpecDao();
        WorkProgressDao r13 = r11.workProgressDao();
        r11.beginTransaction();
        List<WorkSpec> r14 = r12.getRunningWork();     // Catch: Throwable -> L24
        if (r14 != null) goto L10;
    L12:
        boolean r15 = false;
    L13:
        if (r15 == false) goto L18;
        Iterator<WorkSpec> r16 = r14.iterator();     // Catch: Throwable -> L24
    L16:
        if (r16.hasNext() == false) goto L18;
        WorkSpec r17 = r16.next();     // Catch: Throwable -> L24
        r12.setState(WorkInfo.State.ENQUEUED, r17.id);     // Catch: Throwable -> L24
        r12.markWorkSpecScheduled(r17.id, -1);     // Catch: Throwable -> L24
    L18:
        r13.deleteAll();     // Catch: Throwable -> L24
        r11.setTransactionSuccessful();     // Catch: Throwable -> L24
        r11.endTransaction();
        if (r15 == true) goto L23;
        if (r10 == true) goto L23;
        return false;
    L23:
        return true;
    L10:
        if (r14.isEmpty() == true) goto L12;
        r15 = true;
    L24:
        th = move-exception;
        r11.endTransaction();
        throw th;
    L5:
        r10 = false;
        goto L6
    }

    @VisibleForTesting
    public void forceStopRunnable() {
        boolean r10 = cleanUp();
        if (shouldRescheduleWorkers() == false) goto L6;
        Logger.get().debug(TAG, "Rescheduling Workers.");
        this.mWorkManager.rescheduleEligibleWork();
        this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
        return;
    L6:
        if (isForceStopped() == false) goto L8;
        Logger.get().debug(TAG, "Application was force-stopped, rescheduling.");
        this.mWorkManager.rescheduleEligibleWork();
        this.mPreferenceUtils.setLastForceStopEventMillis(System.currentTimeMillis());
        return;
    L8:
        if (r10 == false) goto L13;
        Logger.get().debug(TAG, "Found unfinished work, scheduling it.");
        Schedulers.schedule(this.mWorkManager.getConfiguration(), this.mWorkManager.getWorkDatabase(), this.mWorkManager.getSchedulers());
        return;
    }

    @SuppressLint({"ClassVerificationFailure"})
    @VisibleForTesting
    public boolean isForceStopped() {
        int r10 = 536870912;
        int r11 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L27
        if (r11 < 31) goto L6;
        r10 = 570425344;
    L6:
        PendingIntent r12 = getPendingIntent(this.mContext, r10);     // Catch: Throwable -> L27
        if (r11 < 30) goto L23;
        if (r12 == null) goto L10;
        r12.cancel();     // Catch: Throwable -> L27
    L10:
        List<ApplicationExitInfo> r13 = ((ActivityManager) this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons(null, 0, 0);     // Catch: Throwable -> L27
        if (r13 != null) goto L13;
    L26:
        return false;
    L13:
        if (r13.isEmpty() == true) goto L26;
        long r14 = this.mPreferenceUtils.getLastForceStopEventMillis();     // Catch: Throwable -> L27
        int r15 = 0;
    L16:
        if (r15 >= r13.size()) goto L26;
        ApplicationExitInfo r16 = r13.get(r15);     // Catch: Throwable -> L27
        if (r16.getReason() != 10) goto L22;
        if (r16.getTimestamp() < r14) goto L22;
        return true;
    L22:
        r15 = r15 + 1;     // Catch: Throwable -> L27
        goto L16
    L23:
        if (r12 != null) goto L26;
        setAlarm(this.mContext);     // Catch: Throwable -> L27
        return true;
    L27:
        e = move-exception;
        Logger.get().warning(TAG, "Ignoring exception", e);
        return true;
    }

    @VisibleForTesting
    public boolean multiProcessChecks() {
        Configuration r10 = this.mWorkManager.getConfiguration();
        if (TextUtils.isEmpty(r10.getDefaultProcessName()) == false) goto L6;
        Logger.get().debug(TAG, "The default process name was not specified.");
        return true;
    L6:
        boolean r11 = ProcessUtils.isDefaultProcess(this.mContext, r10);
        Logger.get().debug(TAG, "Is default app process = " + r11);
        return r11;
    }

    @Override // java.lang.Runnable
    public void run() {
    L26:
        th = move-exception;
        this.mWorkManager.onForceStopRunnableCompleted();
        throw th;
    L3:
        if (multiProcessChecks() == true) goto L32;
        this.mWorkManager.onForceStopRunnableCompleted();
        return;
    L32:
        WorkDatabasePathHelper.migrateDatabase(this.mContext);     // Catch: SQLiteException -> L19 Throwable -> L26
        Logger.get().debug(TAG, "Performing cleanup operations.");     // Catch: Throwable -> L26
        forceStopRunnable();     // Catch: Throwable -> L10 Throwable -> L26
    L23:
        this.mWorkManager.onForceStopRunnableCompleted();
        return;
    L10:
        e = move-exception;
        int r10 = this.mRetryCount + 1;     // Catch: Throwable -> L26
        this.mRetryCount = r10;     // Catch: Throwable -> L26
        if (r10 >= 3) goto L13;
        long r11 = ((long) r10) * BACKOFF_DURATION_MS;     // Catch: Throwable -> L26
        Logger.get().debug(TAG, "Retrying after " + r11, e);     // Catch: Throwable -> L26
        sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);     // Catch: Throwable -> L26
        goto L32
    L13:
        Logger r12 = Logger.get();     // Catch: Throwable -> L26
        String r13 = TAG;     // Catch: Throwable -> L26
        r12.error(r13, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);     // Catch: Throwable -> L26
        IllegalStateException r14 = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e);     // Catch: Throwable -> L26
        Consumer<Throwable> r15 = this.mWorkManager.getConfiguration().getInitializationExceptionHandler();     // Catch: Throwable -> L26
        if (r15 == null) goto L17;
        Logger.get().debug(r13, "Routing exception to the specified exception handler", r14);     // Catch: Throwable -> L26
    L16:
        r15.accept(r14);     // Catch: Throwable -> L26
        goto L23
    L17:
        throw r14;     // Catch: Throwable -> L26
    L19:
        e = move-exception;
        Logger.get().error(TAG, "Unexpected SQLite exception during migrations");     // Catch: Throwable -> L26
        r14 = new IllegalStateException("Unexpected SQLite exception during migrations", e);     // Catch: Throwable -> L26
        r15 = this.mWorkManager.getConfiguration().getInitializationExceptionHandler();     // Catch: Throwable -> L26
        if (r15 != null) goto L16;
        throw r14;     // Catch: Throwable -> L26
    }

    @VisibleForTesting
    public boolean shouldRescheduleWorkers() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }

    @VisibleForTesting
    public void sleep(long r10) {
        Thread.sleep(r10);     // Catch: InterruptedException -> L4
        return;
    }
}
