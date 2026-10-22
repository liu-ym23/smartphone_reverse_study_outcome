package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmDispatcher implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";
    static final String TAG = null;
    final CommandHandler mCommandHandler;

    @Nullable
    private CommandsCompletedListener mCompletedListener;
    final Context mContext;
    Intent mCurrentIntent;
    final List<Intent> mIntents;
    private final Processor mProcessor;
    private StartStopTokens mStartStopTokens;
    final TaskExecutor mTaskExecutor;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    static class AddRunnable implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;
        private final Intent mIntent;
        private final int mStartId;

        AddRunnable(@NonNull SystemAlarmDispatcher r10, @NonNull Intent r11, int r12) {
            this.mDispatcher = r10;
            this.mIntent = r11;
            this.mStartId = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }
    }

    interface CommandsCompletedListener {
        void onAllCommandsCompleted();
    }

    static class DequeueAndCheckForCompletion implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;

        DequeueAndCheckForCompletion(@NonNull SystemAlarmDispatcher r10) {
            this.mDispatcher = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mDispatcher.dequeueAndCheckForCompletion();
        }
    }

    static {
        TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    }

    SystemAlarmDispatcher(@NonNull Context r10) {
        this(r10, null, null);
    }

    @VisibleForTesting
    SystemAlarmDispatcher(@NonNull Context r10, @Nullable Processor r11, @Nullable WorkManagerImpl r12) {
        Context r13 = r10.getApplicationContext();
        this.mContext = r13;
        this.mStartStopTokens = new StartStopTokens();
        this.mCommandHandler = new CommandHandler(r13, this.mStartStopTokens);
        if (r12 != null) goto L6;
        r12 = WorkManagerImpl.getInstance(r10);
    L6:
        this.mWorkManager = r12;
        this.mWorkTimer = new WorkTimer(r12.getConfiguration().getRunnableScheduler());
        if (r11 != null) goto L10;
        r11 = r12.getProcessor();
    L10:
        this.mProcessor = r11;
        this.mTaskExecutor = r12.getWorkTaskExecutor();
        r11.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
    }

    private void assertMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L6;
        return;
    L6:
        throw new IllegalStateException("Needs to be invoked on the main thread.");
    }

    @MainThread
    private boolean hasIntentWithAction(@NonNull String r10) {
        assertMainThread();
        List<Intent> r11 = this.mIntents;
        monitor-enter(r11);
        Iterator<Intent> r12 = this.mIntents.iterator();     // Catch: Throwable -> L15
    L6:
        if (r12.hasNext() == false) goto L13;
        if (r10.equals(r12.next().getAction()) == false) goto L6;
        monitor-exit(r11);     // Catch: Throwable -> L15
        return true;
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L15
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    @MainThread
    private void processCommand() {
        assertMainThread();
        PowerManager.WakeLock r10 = WakeLocks.newWakeLock(this.mContext, PROCESS_COMMAND_TAG);
        r10.acquire();     // Catch: Throwable -> L6
        this.mWorkManager.getWorkTaskExecutor().executeOnTaskThread(new AnonymousClass1(this));     // Catch: Throwable -> L6
        r10.release();
        return;
    L6:
        th = move-exception;
        r10.release();
        throw th;
    }

    @MainThread
    public boolean add(@NonNull Intent r10, int r11) {
        Logger r12 = Logger.get();
        String r13 = TAG;
        r12.debug(r13, "Adding command " + r10 + " (" + r11 + ")");
        assertMainThread();
        String r14 = r10.getAction();
        boolean r15 = false;
        if (TextUtils.isEmpty(r14) == false) goto L7;
        Logger.get().warning(r13, "Unknown command. Ignoring");
        return false;
    L7:
        if ("ACTION_CONSTRAINTS_CHANGED".equals(r14) == true) goto L9;
    L11:
        r10.putExtra(KEY_START_ID, r11);
        List<Intent> r16 = this.mIntents;
        monitor-enter(r16);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (this.mIntents.isEmpty() == true) goto L16;
        r15 = true;
    L16:
        this.mIntents.add(r10);     // Catch: Throwable -> L21
        if (r15 == true) goto L19;
        processCommand();     // Catch: Throwable -> L21
    L19:
        monitor-exit(r16);     // Catch: Throwable -> L21
        return true;
    L9:
        if (hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED") == false) goto L11;
        return false;
    }

    @MainThread
    void dequeueAndCheckForCompletion() {
        Logger r10 = Logger.get();
        String r11 = TAG;
        r10.debug(r11, "Checking if commands are complete.");
        assertMainThread();
        List<Intent> r12 = this.mIntents;
        monitor-enter(r12);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentIntent == null) goto L11;
        Logger.get().debug(r11, "Removing command " + this.mCurrentIntent);     // Catch: Throwable -> L25
        if (this.mIntents.remove(0).equals(this.mCurrentIntent) == false) goto L10;
        this.mCurrentIntent = null;     // Catch: Throwable -> L25
        goto L11
    L10:
        throw new IllegalStateException("Dequeue-d command is not the first.");     // Catch: Throwable -> L25
    L11:
        SerialExecutor r13 = this.mTaskExecutor.getSerialTaskExecutor();     // Catch: Throwable -> L25
        if (this.mCommandHandler.hasPendingCommands() == true) goto L21;
        if (this.mIntents.isEmpty() == false) goto L21;
        if (r13.hasPendingTasks() == true) goto L21;
        Logger.get().debug(r11, "No more commands & intents.");     // Catch: Throwable -> L25
        CommandsCompletedListener r14 = this.mCompletedListener;     // Catch: Throwable -> L25
        if (r14 == null) goto L23;
        r14.onAllCommandsCompleted();     // Catch: Throwable -> L25
    L23:
        monitor-exit(r12);     // Catch: Throwable -> L25
        return;
    L21:
        if (this.mIntents.isEmpty() == true) goto L23;
        processCommand();     // Catch: Throwable -> L25
        goto L23
    }

    Processor getProcessor() {
        return this.mProcessor;
    }

    TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    WorkManagerImpl getWorkManager() {
        return this.mWorkManager;
    }

    WorkTimer getWorkTimer() {
        return this.mWorkTimer;
    }

    void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher");
        this.mProcessor.removeExecutionListener(this);
        this.mCompletedListener = null;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull WorkGenerationalId r10, boolean r11) {
        this.mTaskExecutor.getMainThreadExecutor().execute(new AddRunnable(this, CommandHandler.createExecutionCompletedIntent(this.mContext, r10, r11), 0));
    }

    void setCompletedListener(@NonNull CommandsCompletedListener r10) {
        if (this.mCompletedListener == null) goto L6;
        Logger.get().error(TAG, "A completion listener for SystemAlarmDispatcher already exists.");
        return;
    L6:
        this.mCompletedListener = r10;
    }
}
