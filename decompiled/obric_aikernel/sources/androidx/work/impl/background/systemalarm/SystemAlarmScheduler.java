package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.Scheduler;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmScheduler implements Scheduler {
    private static final String TAG = null;
    private final Context mContext;

    static {
        TAG = Logger.tagWithPrefix("SystemAlarmScheduler");
    }

    public SystemAlarmScheduler(@NonNull Context r10) {
        this.mContext = r10.getApplicationContext();
    }

    private void scheduleWorkSpec(@NonNull WorkSpec r10) {
        Logger.get().debug(TAG, "Scheduling work with workSpecId " + r10.id);
        this.mContext.startService(CommandHandler.createScheduleWorkIntent(this.mContext, WorkSpecKt.generationalId(r10)));
    }

    @Override // androidx.work.impl.Scheduler
    public void cancel(@NonNull String r10) {
        Intent r11 = CommandHandler.createStopWorkIntent(this.mContext, r10);
        this.mContext.startService(r11);
    }

    @Override // androidx.work.impl.Scheduler
    public boolean hasLimitedSchedulingSlots() {
        return true;
    }

    @Override // androidx.work.impl.Scheduler
    public void schedule(@NonNull WorkSpec... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        scheduleWorkSpec(r10[r12]);
        r12 = r12 + 1;
        goto L3
    }
}
