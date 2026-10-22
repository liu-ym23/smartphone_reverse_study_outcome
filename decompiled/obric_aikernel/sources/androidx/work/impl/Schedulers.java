package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmScheduler;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.PackageManagerHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Schedulers {
    public static final String GCM_SCHEDULER = "androidx.work.impl.background.gcm.GcmScheduler";
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("Schedulers");
    }

    private Schedulers() {
    }

    @NonNull
    static Scheduler createBestAvailableBackgroundScheduler(@NonNull Context r10, @NonNull WorkManagerImpl r11) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        Scheduler r12 = new SystemJobScheduler(r10, r11);
        PackageManagerHelper.setComponentEnabled(r10, SystemJobService.class, true);
        Logger r13 = Logger.get();
        String r14 = TAG;
        String r15 = "Created SystemJobScheduler and enabled SystemJobService";
    L5:
        r13.debug(r14, r15);
    L9:
        return r12;
    L6:
        r12 = tryCreateGcmBasedScheduler(r10);
        if (r12 != null) goto L9;
        r12 = new SystemAlarmScheduler(r10);
        PackageManagerHelper.setComponentEnabled(r10, SystemAlarmService.class, true);
        r13 = Logger.get();
        r14 = TAG;
        r15 = "Created SystemAlarmScheduler";
        goto L5
    }

    public static void schedule(@NonNull Configuration r10, @NonNull WorkDatabase r11, @Nullable List<Scheduler> r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.size() == 0) goto L55;
        WorkSpecDao r13 = r11.workSpecDao();
        r11.beginTransaction();
        List<WorkSpec> r14 = r13.getEligibleWorkForScheduling(r10.getMaxSchedulerLimit());     // Catch: Throwable -> L36
        List<WorkSpec> r15 = r13.getAllEligibleWorkSpecsForScheduling(200);     // Catch: Throwable -> L36
        if (r14 != null) goto L10;
    L15:
        r11.setTransactionSuccessful();     // Catch: Throwable -> L36
        r11.endTransaction();
        if (r14 != null) goto L19;
    L26:
        if (r15 != null) goto L28;
        return;
    L28:
        if (r15.size() <= 0) goto L53;
        WorkSpec[] r16 = (WorkSpec[]) r15.toArray(new WorkSpec[r15.size()]);
        Iterator<Scheduler> r17 = r12.iterator();
    L31:
        if (r17.hasNext() == false) goto L54;
        Scheduler r18 = r17.next();
        if (r18.hasLimitedSchedulingSlots() == true) goto L31;
        r18.schedule(r16);
        goto L31
    L54:
        return;
    L53:
        return;
    L19:
        if (r14.size() <= 0) goto L26;
        WorkSpec[] r19 = (WorkSpec[]) r14.toArray(new WorkSpec[r14.size()]);
        Iterator<Scheduler> r20 = r12.iterator();
    L22:
        if (r20.hasNext() == false) goto L26;
        Scheduler r21 = r20.next();
        if (r21.hasLimitedSchedulingSlots() == false) goto L22;
        r21.schedule(r19);
        goto L22
    L10:
        if (r14.size() <= 0) goto L15;
        long r22 = System.currentTimeMillis();     // Catch: Throwable -> L36
        Iterator<WorkSpec> r23 = r14.iterator();     // Catch: Throwable -> L36
    L13:
        if (r23.hasNext() == false) goto L15;
        r13.markWorkSpecScheduled(r23.next().id, r22);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r11.endTransaction();
        throw th;
    }

    @Nullable
    private static Scheduler tryCreateGcmBasedScheduler(@NonNull Context r10) {
        Scheduler r11 = (Scheduler) Class.forName(GCM_SCHEDULER).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r10});     // Catch: Throwable -> L4
        Logger.get().debug(TAG, "Created androidx.work.impl.background.gcm.GcmScheduler");     // Catch: Throwable -> L4
        return r11;
    L4:
        th = move-exception;
        Logger.get().debug(TAG, "Unable to create GCM Scheduler", th);
        return null;
    }
}
