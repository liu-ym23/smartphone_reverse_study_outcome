package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class ConstraintsCommandHandler {
    private static final String TAG = null;
    private final Context mContext;
    private final SystemAlarmDispatcher mDispatcher;
    private final int mStartId;
    private final WorkConstraintsTrackerImpl mWorkConstraintsTracker;

    static {
        TAG = Logger.tagWithPrefix("ConstraintsCmdHandler");
    }

    ConstraintsCommandHandler(@NonNull Context r10, int r11, @NonNull SystemAlarmDispatcher r12) {
        this.mContext = r10;
        this.mStartId = r11;
        this.mDispatcher = r12;
        this.mWorkConstraintsTracker = new WorkConstraintsTrackerImpl(r12.getWorkManager().getTrackers(), null);
    }

    @WorkerThread
    void handleConstraintsChanged() {
        List<WorkSpec> r10 = this.mDispatcher.getWorkManager().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.updateAll(this.mContext, r10);
        this.mWorkConstraintsTracker.replace(r10);
        ArrayList r11 = new ArrayList(r10.size());
        long r12 = System.currentTimeMillis();
        Iterator<WorkSpec> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L12;
        WorkSpec r14 = r13.next();
        String r15 = r14.id;
        if (r12 < r14.calculateNextRunTime()) goto L4;
        if (r14.hasConstraints() == false) goto L11;
        if (this.mWorkConstraintsTracker.areAllConstraintsMet(r15) == false) goto L4;
    L11:
        r11.add(r14);
        goto L4
    L12:
        Iterator r16 = r11.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        WorkSpec r17 = (WorkSpec) r16.next();
        String r18 = r17.id;
        Intent r19 = CommandHandler.createDelayMetIntent(this.mContext, WorkSpecKt.generationalId(r17));
        Logger.get().debug(TAG, "Creating a delay_met command for workSpec with id (" + r18 + ")");
        this.mDispatcher.getTaskExecutor().getMainThreadExecutor().execute(new SystemAlarmDispatcher.AddRunnable(this.mDispatcher, r19, this.mStartId));
        goto L14
    L16:
        this.mWorkConstraintsTracker.reset();
    }
}
