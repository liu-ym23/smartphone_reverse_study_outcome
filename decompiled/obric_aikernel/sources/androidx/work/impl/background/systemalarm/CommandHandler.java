package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CommandHandler implements ExecutionListener {
    static final String ACTION_CONSTRAINTS_CHANGED = "ACTION_CONSTRAINTS_CHANGED";
    static final String ACTION_DELAY_MET = "ACTION_DELAY_MET";
    static final String ACTION_EXECUTION_COMPLETED = "ACTION_EXECUTION_COMPLETED";
    static final String ACTION_RESCHEDULE = "ACTION_RESCHEDULE";
    static final String ACTION_SCHEDULE_WORK = "ACTION_SCHEDULE_WORK";
    static final String ACTION_STOP_WORK = "ACTION_STOP_WORK";
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_GENERATION = "KEY_WORKSPEC_GENERATION";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = null;
    static final long WORK_PROCESSING_TIME_IN_MS = 600000;
    private final Context mContext;
    private final Object mLock;
    private final Map<WorkGenerationalId, DelayMetCommandHandler> mPendingDelayMet;
    private final StartStopTokens mStartStopTokens;

    static {
        TAG = Logger.tagWithPrefix("CommandHandler");
    }

    CommandHandler(@NonNull Context r10, @NonNull StartStopTokens r11) {
        this.mContext = r10;
        this.mStartStopTokens = r11;
        this.mPendingDelayMet = new HashMap();
        this.mLock = new Object();
    }

    static Intent createConstraintsChangedIntent(@NonNull Context r10) {
        Intent r11 = new Intent(r10, SystemAlarmService.class);
        r11.setAction(ACTION_CONSTRAINTS_CHANGED);
        return r11;
    }

    static Intent createDelayMetIntent(@NonNull Context r10, @NonNull WorkGenerationalId r11) {
        Intent r12 = new Intent(r10, SystemAlarmService.class);
        r12.setAction(ACTION_DELAY_MET);
        return writeWorkGenerationalId(r12, r11);
    }

    static Intent createExecutionCompletedIntent(@NonNull Context r10, @NonNull WorkGenerationalId r11, boolean r12) {
        Intent r13 = new Intent(r10, SystemAlarmService.class);
        r13.setAction(ACTION_EXECUTION_COMPLETED);
        r13.putExtra(KEY_NEEDS_RESCHEDULE, r12);
        return writeWorkGenerationalId(r13, r11);
    }

    static Intent createRescheduleIntent(@NonNull Context r10) {
        Intent r11 = new Intent(r10, SystemAlarmService.class);
        r11.setAction(ACTION_RESCHEDULE);
        return r11;
    }

    static Intent createScheduleWorkIntent(@NonNull Context r10, @NonNull WorkGenerationalId r11) {
        Intent r12 = new Intent(r10, SystemAlarmService.class);
        r12.setAction(ACTION_SCHEDULE_WORK);
        return writeWorkGenerationalId(r12, r11);
    }

    static Intent createStopWorkIntent(@NonNull Context r10, @NonNull WorkGenerationalId r11) {
        Intent r12 = new Intent(r10, SystemAlarmService.class);
        r12.setAction(ACTION_STOP_WORK);
        return writeWorkGenerationalId(r12, r11);
    }

    static Intent createStopWorkIntent(@NonNull Context r10, @NonNull String r11) {
        Intent r12 = new Intent(r10, SystemAlarmService.class);
        r12.setAction(ACTION_STOP_WORK);
        r12.putExtra(KEY_WORKSPEC_ID, r11);
        return r12;
    }

    private void handleConstraintsChanged(@NonNull Intent r10, int r11, @NonNull SystemAlarmDispatcher r12) {
        Logger.get().debug(TAG, "Handling constraints changed " + r10);
        new ConstraintsCommandHandler(this.mContext, r11, r12).handleConstraintsChanged();
    }

    private void handleDelayMet(@NonNull Intent r10, int r11, @NonNull SystemAlarmDispatcher r12) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        WorkGenerationalId r14 = readWorkGenerationalId(r10);     // Catch: Throwable -> L10
        Logger r15 = Logger.get();     // Catch: Throwable -> L10
        String r16 = TAG;     // Catch: Throwable -> L10
        r15.debug(r16, "Handing delay met for " + r14);     // Catch: Throwable -> L10
        if (this.mPendingDelayMet.containsKey(r14) == true) goto L7;
        DelayMetCommandHandler r17 = new DelayMetCommandHandler(this.mContext, r11, r12, this.mStartStopTokens.tokenFor(r14));     // Catch: Throwable -> L10
        this.mPendingDelayMet.put(r14, r17);     // Catch: Throwable -> L10
        r17.handleProcessWork();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r13);     // Catch: Throwable -> L10
        return;
    L7:
        Logger.get().debug(r16, "WorkSpec " + r14 + " is is already being handled for ACTION_DELAY_MET");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void handleExecutionCompleted(@NonNull Intent r10, int r11) {
        WorkGenerationalId r12 = readWorkGenerationalId(r10);
        boolean r13 = r10.getExtras().getBoolean(KEY_NEEDS_RESCHEDULE);
        Logger.get().debug(TAG, "Handling onExecutionCompleted " + r10 + ", " + r11);
        onExecuted(r12, r13);
    }

    private void handleReschedule(@NonNull Intent r10, int r11, @NonNull SystemAlarmDispatcher r12) {
        Logger.get().debug(TAG, "Handling reschedule " + r10 + ", " + r11);
        r12.getWorkManager().rescheduleEligibleWork();
    }

    private void handleScheduleWorkIntent(@NonNull Intent r10, int r11, @NonNull SystemAlarmDispatcher r12) {
        WorkGenerationalId r13 = readWorkGenerationalId(r10);
        Logger r14 = Logger.get();
        String r15 = TAG;
        r14.debug(r15, "Handling schedule work for " + r13);
        WorkDatabase r16 = r12.getWorkManager().getWorkDatabase();
        r16.beginTransaction();
        WorkSpec r17 = r16.workSpecDao().getWorkSpec(r13.getWorkSpecId());     // Catch: Throwable -> L22
        if (r17 != null) goto L10;
        Logger.get().warning(r15, "Skipping scheduling " + r13 + " because it's no longer in the DB");     // Catch: Throwable -> L22
        r16.endTransaction();
        return;
    L10:
        if (r17.state.isFinished() == false) goto L14;
        Logger.get().warning(r15, "Skipping scheduling " + r13 + "because it is finished.");     // Catch: Throwable -> L22
        r16.endTransaction();
        return;
    L14:
        long r18 = r17.calculateNextRunTime();     // Catch: Throwable -> L22
        if (r17.hasConstraints() == true) goto L18;
        Logger.get().debug(r15, "Setting up Alarms for " + r13 + "at " + r18);     // Catch: Throwable -> L22
        Alarms.setAlarm(this.mContext, r16, r13, r18);     // Catch: Throwable -> L22
    L19:
        r16.setTransactionSuccessful();     // Catch: Throwable -> L22
        r16.endTransaction();
        return;
    L18:
        Logger.get().debug(r15, "Opportunistically setting an alarm for " + r13 + "at " + r18);     // Catch: Throwable -> L22
        Alarms.setAlarm(this.mContext, r16, r13, r18);     // Catch: Throwable -> L22
        r12.getTaskExecutor().getMainThreadExecutor().execute(new SystemAlarmDispatcher.AddRunnable(r12, createConstraintsChangedIntent(this.mContext), r11));     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        r16.endTransaction();
        throw th;
    }

    private void handleStopWork(@NonNull Intent r10, @NonNull SystemAlarmDispatcher r11) {
        Bundle r12 = r10.getExtras();
        String r13 = r12.getString(KEY_WORKSPEC_ID);
        if (r12.containsKey(KEY_WORKSPEC_GENERATION) == false) goto L7;
        int r14 = r12.getInt(KEY_WORKSPEC_GENERATION);
        List<StartStopToken> r15 = new ArrayList(1);
        StartStopToken r16 = this.mStartStopTokens.remove(new WorkGenerationalId(r13, r14));
        if (r16 == null) goto L8;
        r15.add(r16);
    L8:
        Iterator<StartStopToken> r17 = r15.iterator();
    L10:
        if (r17.hasNext() == false) goto L12;
        StartStopToken r18 = r17.next();
        Logger.get().debug(TAG, "Handing stopWork work for " + r13);
        r11.getWorkManager().stopWork(r18);
        Alarms.cancelAlarm(this.mContext, r11.getWorkManager().getWorkDatabase(), r18.getId());
        r11.onExecuted(r18.getId(), false);
        goto L10
    L12:
        return;
    L7:
        r15 = this.mStartStopTokens.remove(r13);
        goto L8
    }

    private static boolean hasKeys(@Nullable Bundle r10, @NonNull String... r11) {
        if (r10 != null) goto L5;
    L15:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L15;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        if (r10.get(r11[r13]) == null) goto L11;
        r13 = r13 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }

    static WorkGenerationalId readWorkGenerationalId(@NonNull Intent r10) {
        return new WorkGenerationalId(r10.getStringExtra(KEY_WORKSPEC_ID), r10.getIntExtra(KEY_WORKSPEC_GENERATION, 0));
    }

    private static Intent writeWorkGenerationalId(@NonNull Intent r10, @NonNull WorkGenerationalId r11) {
        r10.putExtra(KEY_WORKSPEC_ID, r11.getWorkSpecId());
        r10.putExtra(KEY_WORKSPEC_GENERATION, r11.getGeneration());
        return r10;
    }

    boolean hasPendingCommands() {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingDelayMet.isEmpty() == true) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return r11;
    L7:
        r11 = false;
        goto L8
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull WorkGenerationalId r10, boolean r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        DelayMetCommandHandler r13 = this.mPendingDelayMet.remove(r10);     // Catch: Throwable -> L9
        this.mStartStopTokens.remove(r10);     // Catch: Throwable -> L9
        if (r13 == null) goto L7;
        r13.onExecuted(r11);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r12);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @WorkerThread
    void onHandleIntent(@NonNull Intent r10, int r11, @NonNull SystemAlarmDispatcher r12) {
        String r13 = r10.getAction();
        if (ACTION_CONSTRAINTS_CHANGED.equals(r13) == false) goto L6;
        handleConstraintsChanged(r10, r11, r12);
        return;
    L6:
        if (ACTION_RESCHEDULE.equals(r13) == false) goto L9;
        handleReschedule(r10, r11, r12);
        return;
    L9:
        if (hasKeys(r10.getExtras(), new String[]{KEY_WORKSPEC_ID}) == true) goto L12;
        Logger.get().error(TAG, "Invalid request for " + r13 + " , requires " + KEY_WORKSPEC_ID + " .");
        return;
    L12:
        if (ACTION_SCHEDULE_WORK.equals(r13) == false) goto L15;
        handleScheduleWorkIntent(r10, r11, r12);
        return;
    L15:
        if (ACTION_DELAY_MET.equals(r13) == false) goto L18;
        handleDelayMet(r10, r11, r12);
        return;
    L18:
        if (ACTION_STOP_WORK.equals(r13) == false) goto L21;
        handleStopWork(r10, r12);
        return;
    L21:
        if (ACTION_EXECUTION_COMPLETED.equals(r13) == false) goto L23;
        handleExecutionCompleted(r10, r11);
        return;
    L23:
        Logger.get().warning(TAG, "Ignoring intent " + r10);
    }
}
