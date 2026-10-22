package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_GENERATION = "KEY_GENERATION";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    static final String TAG = null;

    @Nullable
    private Callback mCallback;
    final WorkConstraintsTracker mConstraintsTracker;
    private Context mContext;
    WorkGenerationalId mCurrentForegroundId;
    final Map<WorkGenerationalId, ForegroundInfo> mForegroundInfoById;
    final Object mLock;
    private final TaskExecutor mTaskExecutor;
    final Set<WorkSpec> mTrackedWorkSpecs;
    private WorkManagerImpl mWorkManagerImpl;
    final Map<WorkGenerationalId, WorkSpec> mWorkSpecById;

    interface Callback {
        void cancelNotification(int r10);

        void notify(int r10, @NonNull Notification r11);

        void startForeground(int r10, int r11, @NonNull Notification r12);

        void stop();
    }

    static {
        TAG = Logger.tagWithPrefix("SystemFgDispatcher");
    }

    SystemForegroundDispatcher(@NonNull Context r10) {
        this.mContext = r10;
        this.mLock = new Object();
        WorkManagerImpl r11 = WorkManagerImpl.getInstance(r10);
        this.mWorkManagerImpl = r11;
        this.mTaskExecutor = r11.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = new WorkConstraintsTrackerImpl(this.mWorkManagerImpl.getTrackers(), this);
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    @VisibleForTesting
    SystemForegroundDispatcher(@NonNull Context r10, @NonNull WorkManagerImpl r11, @NonNull WorkConstraintsTracker r12) {
        this.mContext = r10;
        this.mLock = new Object();
        this.mWorkManagerImpl = r11;
        this.mTaskExecutor = r11.getWorkTaskExecutor();
        this.mCurrentForegroundId = null;
        this.mForegroundInfoById = new LinkedHashMap();
        this.mTrackedWorkSpecs = new HashSet();
        this.mWorkSpecById = new HashMap();
        this.mConstraintsTracker = r12;
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    static /* synthetic */ WorkManagerImpl access$000(SystemForegroundDispatcher r10) {
        return r10.mWorkManagerImpl;
    }

    @NonNull
    public static Intent createCancelWorkIntent(@NonNull Context r10, @NonNull String r11) {
        Intent r12 = new Intent(r10, SystemForegroundService.class);
        r12.setAction(ACTION_CANCEL_WORK);
        r12.setData(Uri.parse("workspec://" + r11));
        r12.putExtra(KEY_WORKSPEC_ID, r11);
        return r12;
    }

    @NonNull
    public static Intent createNotifyIntent(@NonNull Context r10, @NonNull WorkGenerationalId r11, @NonNull ForegroundInfo r12) {
        Intent r13 = new Intent(r10, SystemForegroundService.class);
        r13.setAction(ACTION_NOTIFY);
        r13.putExtra(KEY_NOTIFICATION_ID, r12.getNotificationId());
        r13.putExtra(KEY_FOREGROUND_SERVICE_TYPE, r12.getForegroundServiceType());
        r13.putExtra(KEY_NOTIFICATION, r12.getNotification());
        r13.putExtra(KEY_WORKSPEC_ID, r11.getWorkSpecId());
        r13.putExtra(KEY_GENERATION, r11.getGeneration());
        return r13;
    }

    @NonNull
    public static Intent createStartForegroundIntent(@NonNull Context r10, @NonNull WorkGenerationalId r11, @NonNull ForegroundInfo r12) {
        Intent r13 = new Intent(r10, SystemForegroundService.class);
        r13.setAction(ACTION_START_FOREGROUND);
        r13.putExtra(KEY_WORKSPEC_ID, r11.getWorkSpecId());
        r13.putExtra(KEY_GENERATION, r11.getGeneration());
        r13.putExtra(KEY_NOTIFICATION_ID, r12.getNotificationId());
        r13.putExtra(KEY_FOREGROUND_SERVICE_TYPE, r12.getForegroundServiceType());
        r13.putExtra(KEY_NOTIFICATION, r12.getNotification());
        return r13;
    }

    @NonNull
    public static Intent createStopForegroundIntent(@NonNull Context r10) {
        Intent r11 = new Intent(r10, SystemForegroundService.class);
        r11.setAction(ACTION_STOP_FOREGROUND);
        return r11;
    }

    @MainThread
    private void handleCancelWork(@NonNull Intent r10) {
        Logger.get().info(TAG, "Stopping foreground work for " + r10);
        String r11 = r10.getStringExtra(KEY_WORKSPEC_ID);
        if (r11 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L9;
        this.mWorkManagerImpl.cancelWorkById(UUID.fromString(r11));
        return;
    }

    @MainThread
    private void handleNotify(@NonNull Intent r10) {
        int r11 = 0;
        int r12 = r10.getIntExtra(KEY_NOTIFICATION_ID, 0);
        int r13 = r10.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
        String r14 = r10.getStringExtra(KEY_WORKSPEC_ID);
        WorkGenerationalId r15 = new WorkGenerationalId(r14, r10.getIntExtra(KEY_GENERATION, 0));
        Notification r16 = (Notification) r10.getParcelableExtra(KEY_NOTIFICATION);
        Logger.get().debug(TAG, "Notifying with (id:" + r12 + ", workSpecId: " + r14 + ", notificationType :" + r13 + ")");
        if (r16 != null) goto L5;
        return;
    L5:
        if (this.mCallback == null) goto L23;
        this.mForegroundInfoById.put(r15, new ForegroundInfo(r12, r16, r13));
        if (this.mCurrentForegroundId != null) goto L9;
        this.mCurrentForegroundId = r15;
        this.mCallback.startForeground(r12, r13, r16);
        return;
    L9:
        this.mCallback.notify(r12, r16);
        if (r13 != 0) goto L12;
        return;
    L12:
        if (Build.VERSION.SDK_INT < 29) goto L26;
        Iterator<Map.Entry<WorkGenerationalId, ForegroundInfo>> r17 = this.mForegroundInfoById.entrySet().iterator();
    L15:
        if (r17.hasNext() == false) goto L17;
        r11 = r11 | r17.next().getValue().getForegroundServiceType();
        goto L15
    L17:
        ForegroundInfo r18 = this.mForegroundInfoById.get(this.mCurrentForegroundId);
        if (r18 == null) goto L27;
        this.mCallback.startForeground(r18.getNotificationId(), r11, r18.getNotification());
        return;
    L27:
        return;
    L26:
        return;
    }

    @MainThread
    private void handleStartForeground(@NonNull Intent r10) {
        Logger.get().info(TAG, "Started foreground service " + r10);
        final String r11 = r10.getStringExtra(KEY_WORKSPEC_ID);
        this.mTaskExecutor.executeOnTaskThread(new AnonymousClass1(this, r11));
    }

    @MainThread
    void handleStop(@NonNull Intent r10) {
        Logger.get().info(TAG, "Stopping foreground service");
        Callback r11 = this.mCallback;
        if (r11 == null) goto L6;
        r11.stop();
        return;
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsMet(@NonNull List<WorkSpec> r10) {
    }

    @Override // androidx.work.impl.constraints.WorkConstraintsCallback
    public void onAllConstraintsNotMet(@NonNull List<WorkSpec> r10) {
        if (r10.isEmpty() == true) goto L8;
        Iterator<WorkSpec> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        WorkSpec r12 = r11.next();
        String r13 = r12.id;
        Logger.get().debug(TAG, "Constraints unmet for WorkSpec " + r13);
        this.mWorkManagerImpl.stopForegroundWork(WorkSpecKt.generationalId(r12));
        goto L6
    L10:
        return;
    }

    @MainThread
    void onDestroy() {
        this.mCallback = null;
        Object r10 = this.mLock;
        monitor-enter(r10);
        this.mConstraintsTracker.reset();     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.ExecutionListener
    @MainThread
    public void onExecuted(@NonNull WorkGenerationalId r10, boolean r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        WorkSpec r13 = this.mWorkSpecById.remove(r10);     // Catch: Throwable -> L27
        if (r13 == null) goto L7;
        boolean r14 = this.mTrackedWorkSpecs.remove(r13);     // Catch: Throwable -> L27
    L8:
        if (r14 == false) goto L10;
        this.mConstraintsTracker.replace(this.mTrackedWorkSpecs);     // Catch: Throwable -> L27
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L27
        ForegroundInfo r15 = this.mForegroundInfoById.remove(r10);
        if (r10.equals(this.mCurrentForegroundId) == true) goto L14;
    L22:
        Callback r16 = this.mCallback;
        if (r15 == null) goto L34;
        if (r16 == null) goto L35;
        Logger.get().debug(TAG, "Removing Notification (id: " + r15.getNotificationId() + ", workSpecId: " + r10 + ", notificationType: " + r15.getForegroundServiceType());
        r16.cancelNotification(r15.getNotificationId());
        return;
    L35:
        return;
    L34:
        return;
    L14:
        if (this.mForegroundInfoById.size() <= 0) goto L22;
        Iterator<Map.Entry<WorkGenerationalId, ForegroundInfo>> r17 = this.mForegroundInfoById.entrySet().iterator();
    L16:
        Map.Entry<WorkGenerationalId, ForegroundInfo> r18 = r17.next();
        if (r17.hasNext() == true) goto L16;
        this.mCurrentForegroundId = r18.getKey();
        if (this.mCallback == null) goto L22;
        ForegroundInfo r19 = r18.getValue();
        this.mCallback.startForeground(r19.getNotificationId(), r19.getForegroundServiceType(), r19.getNotification());
        this.mCallback.cancelNotification(r19.getNotificationId());
        goto L22
    L7:
        r14 = false;
    L27:
        th = move-exception;
        throw th;
    }

    void onStartCommand(@NonNull Intent r10) {
        String r11 = r10.getAction();
        if (ACTION_START_FOREGROUND.equals(r11) == false) goto L7;
        handleStartForeground(r10);
    L5:
        handleNotify(r10);
        return;
    L7:
        if (ACTION_NOTIFY.equals(r11) == true) goto L5;
        if (ACTION_CANCEL_WORK.equals(r11) == false) goto L13;
        handleCancelWork(r10);
        return;
    L13:
        if (ACTION_STOP_FOREGROUND.equals(r11) == false) goto L18;
        handleStop(r10);
        return;
    }

    @MainThread
    void setCallback(@NonNull Callback r10) {
        if (this.mCallback == null) goto L6;
        Logger.get().error(TAG, "A callback already exists.");
        return;
    L6:
        this.mCallback = r10;
    }
}
