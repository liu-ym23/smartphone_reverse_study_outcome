package androidx.work.impl;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.work.Configuration;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.foreground.ForegroundProcessor;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class Processor implements ExecutionListener, ForegroundProcessor {
    private static final String FOREGROUND_WAKELOCK_TAG = "ProcessorForegroundLck";
    private static final String TAG = null;
    private Context mAppContext;
    private Set<String> mCancelledIds;
    private Configuration mConfiguration;
    private Map<String, WorkerWrapper> mEnqueuedWorkMap;

    @Nullable
    private PowerManager.WakeLock mForegroundLock;
    private Map<String, WorkerWrapper> mForegroundWorkMap;
    private final Object mLock;
    private final List<ExecutionListener> mOuterListeners;
    private List<Scheduler> mSchedulers;
    private WorkDatabase mWorkDatabase;
    private Map<String, Set<StartStopToken>> mWorkRuns;
    private TaskExecutor mWorkTaskExecutor;

    private static class FutureListener implements Runnable {

        @NonNull
        private ExecutionListener mExecutionListener;

        @NonNull
        private c6.a<Boolean> mFuture;

        @NonNull
        private final WorkGenerationalId mWorkGenerationalId;

        FutureListener(@NonNull ExecutionListener r10, @NonNull WorkGenerationalId r11, @NonNull c6.a<Boolean> r12) {
            this.mExecutionListener = r10;
            this.mWorkGenerationalId = r11;
            this.mFuture = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r10 = this.mFuture.get().booleanValue();     // Catch: Throwable -> L4
        L5:
            this.mExecutionListener.onExecuted(this.mWorkGenerationalId, r10);
            return;
        L4:
            r10 = true;
            goto L5
        }
    }

    static {
        TAG = Logger.tagWithPrefix("Processor");
    }

    public Processor(@NonNull Context r10, @NonNull Configuration r11, @NonNull TaskExecutor r12, @NonNull WorkDatabase r13, @NonNull List<Scheduler> r14) {
        this.mAppContext = r10;
        this.mConfiguration = r11;
        this.mWorkTaskExecutor = r12;
        this.mWorkDatabase = r13;
        this.mEnqueuedWorkMap = new HashMap();
        this.mForegroundWorkMap = new HashMap();
        this.mSchedulers = r14;
        this.mCancelledIds = new HashSet();
        this.mOuterListeners = new ArrayList();
        this.mForegroundLock = null;
        this.mLock = new Object();
        this.mWorkRuns = new HashMap();
    }

    public static /* synthetic */ void a(Processor r10, WorkGenerationalId r11, boolean r12) {
        r10.lambda$runOnExecuted$1(r11, r12);
    }

    public static /* synthetic */ WorkSpec b(Processor r10, ArrayList r11, String r12) {
        return r10.lambda$startWork$0(r11, r12);
    }

    private static boolean interrupt(@NonNull String r10, @Nullable WorkerWrapper r11) {
        if (r11 == null) goto L5;
        r11.interrupt();
        Logger.get().debug(TAG, "WorkerWrapper interrupted for " + r10);
        return true;
    L5:
        Logger.get().debug(TAG, "WorkerWrapper could not be found for " + r10);
        return false;
    }

    private /* synthetic */ void lambda$runOnExecuted$1(WorkGenerationalId r10, boolean r11) {
        onExecuted(r10, r11);
    }

    private /* synthetic */ WorkSpec lambda$startWork$0(ArrayList r10, String r11) {
        r10.addAll(this.mWorkDatabase.workTagDao().getTagsForWorkSpecId(r11));
        return this.mWorkDatabase.workSpecDao().getWorkSpec(r11);
    }

    private void runOnExecuted(@NonNull final WorkGenerationalId r10, final boolean r11) {
        this.mWorkTaskExecutor.getMainThreadExecutor().execute(new a(this, r10, r11));
    }

    private void stopForegroundService() {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L16:
        th = move-exception;
        throw th;
    L5:
        if ((!this.mForegroundWorkMap.isEmpty()) == false) goto L21;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L21:
        this.mAppContext.startService(SystemForegroundDispatcher.createStopForegroundIntent(this.mAppContext));     // Catch: Throwable -> L9
    L11:
        PowerManager.WakeLock r11 = this.mForegroundLock;     // Catch: Throwable -> L16
        if (r11 == null) goto L14;
        r11.release();     // Catch: Throwable -> L16
        this.mForegroundLock = null;     // Catch: Throwable -> L16
        goto L14
    L9:
        th = move-exception;
        Logger.get().error(TAG, "Unable to stop foreground service", th);     // Catch: Throwable -> L16
        goto L11
    }

    public void addExecutionListener(@NonNull ExecutionListener r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mOuterListeners.add(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Nullable
    public WorkSpec getRunningWorkSpec(@NonNull String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        WorkerWrapper r12 = this.mForegroundWorkMap.get(r10);     // Catch: Throwable -> L14
        if (r12 != null) goto L7;
        r12 = this.mEnqueuedWorkMap.get(r10);     // Catch: Throwable -> L14
    L7:
        if (r12 == null) goto L12;
        WorkSpec r13 = r12.getWorkSpec();     // Catch: Throwable -> L14
        monitor-exit(r11);     // Catch: Throwable -> L14
        return r13;
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean hasWork() {
        Object r10 = this.mLock;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnqueuedWorkMap.isEmpty() == true) goto L7;
    L10:
        boolean r11 = true;
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r11;
    L7:
        if (this.mForegroundWorkMap.isEmpty() == false) goto L10;
        r11 = false;
        goto L11
    }

    public boolean isCancelled(@NonNull String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        boolean r12 = this.mCancelledIds.contains(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isEnqueued(@NonNull String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mEnqueuedWorkMap.containsKey(r10) == false) goto L7;
    L10:
        boolean r12 = true;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return r12;
    L7:
        if (this.mForegroundWorkMap.containsKey(r10) == true) goto L10;
        r12 = false;
        goto L11
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public boolean isEnqueuedInForeground(@NonNull String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        boolean r12 = this.mForegroundWorkMap.containsKey(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.ExecutionListener
    public void onExecuted(@NonNull WorkGenerationalId r10, boolean r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        WorkerWrapper r13 = this.mEnqueuedWorkMap.get(r10.getWorkSpecId());     // Catch: Throwable -> L15
        if (r13 != null) goto L7;
    L9:
        Logger.get().debug(TAG, getClass().getSimpleName() + " " + r10.getWorkSpecId() + " executed; reschedule = " + r11);     // Catch: Throwable -> L15
        Iterator<ExecutionListener> r14 = this.mOuterListeners.iterator();     // Catch: Throwable -> L15
    L11:
        if (r14.hasNext() == false) goto L13;
        r14.next().onExecuted(r10, r11);     // Catch: Throwable -> L15
        goto L11
    L13:
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L7:
        if (r10.equals(r13.getWorkGenerationalId()) == false) goto L9;
        this.mEnqueuedWorkMap.remove(r10.getWorkSpecId());     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void removeExecutionListener(@NonNull ExecutionListener r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mOuterListeners.remove(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void startForeground(@NonNull String r10, @NonNull ForegroundInfo r11) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        Logger.get().info(TAG, "Moving WorkSpec (" + r10 + ") to the foreground");     // Catch: Throwable -> L12
        WorkerWrapper r13 = this.mEnqueuedWorkMap.remove(r10);     // Catch: Throwable -> L12
        if (r13 != null) goto L7;
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L7:
        if (this.mForegroundLock != null) goto L9;
        PowerManager.WakeLock r14 = WakeLocks.newWakeLock(this.mAppContext, FOREGROUND_WAKELOCK_TAG);     // Catch: Throwable -> L12
        this.mForegroundLock = r14;     // Catch: Throwable -> L12
        r14.acquire();     // Catch: Throwable -> L12
    L9:
        this.mForegroundWorkMap.put(r10, r13);     // Catch: Throwable -> L12
        ContextCompat.startForegroundService(this.mAppContext, SystemForegroundDispatcher.createStartForegroundIntent(this.mAppContext, r13.getWorkGenerationalId(), r11));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public boolean startWork(@NonNull StartStopToken r10) {
        return startWork(r10, null);
    }

    public boolean startWork(@NonNull StartStopToken r13, @Nullable WorkerParameters.RuntimeExtras r14) {
        WorkGenerationalId r10 = r13.getId();
        final String r11 = r10.getWorkSpecId();
        final ArrayList r12 = new ArrayList();
        WorkSpec r15 = (WorkSpec) this.mWorkDatabase.runInTransaction(new b(this, r12, r11));
        if (r15 != null) goto L6;
        Logger.get().warning(TAG, "Didn't find WorkSpec for id " + r10);
        runOnExecuted(r10, false);
        return false;
    L6:
        Object r16 = this.mLock;
        monitor-enter(r16);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (isEnqueued(r11) == false) goto L17;
        Set<StartStopToken> r17 = this.mWorkRuns.get(r11);     // Catch: Throwable -> L25
        if (r17.iterator().next().getId().getGeneration() != r10.getGeneration()) goto L13;
        r17.add(r13);     // Catch: Throwable -> L25
        Logger.get().debug(TAG, "Work " + r10 + " is already enqueued for processing");     // Catch: Throwable -> L25
    L14:
        monitor-exit(r16);     // Catch: Throwable -> L25
        return false;
    L13:
        runOnExecuted(r10, false);     // Catch: Throwable -> L25
        goto L14
    L17:
        if (r15.getGeneration() == r10.getGeneration()) goto L21;
        runOnExecuted(r10, false);     // Catch: Throwable -> L25
        monitor-exit(r16);     // Catch: Throwable -> L25
        return false;
    L21:
        WorkerWrapper r18 = new WorkerWrapper.Builder(this.mAppContext, this.mConfiguration, this.mWorkTaskExecutor, this, this.mWorkDatabase, r15, r12).withSchedulers(this.mSchedulers).withRuntimeExtras(r14).build();     // Catch: Throwable -> L25
        c6.a<Boolean> r19 = r18.getFuture();     // Catch: Throwable -> L25
        r19.addListener(new FutureListener(this, r13.getId(), r19), this.mWorkTaskExecutor.getMainThreadExecutor());     // Catch: Throwable -> L25
        this.mEnqueuedWorkMap.put(r11, r18);     // Catch: Throwable -> L25
        HashSet r20 = new HashSet();     // Catch: Throwable -> L25
        r20.add(r13);     // Catch: Throwable -> L25
        this.mWorkRuns.put(r11, r20);     // Catch: Throwable -> L25
        monitor-exit(r16);     // Catch: Throwable -> L25
        this.mWorkTaskExecutor.getSerialTaskExecutor().execute(r18);
        Logger.get().debug(TAG, getClass().getSimpleName() + ": processing " + r10);
        return true;
    }

    public boolean stopAndCancelWork(@NonNull String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        Logger.get().debug(TAG, "Processor cancelling " + r10);     // Catch: Throwable -> L17
        this.mCancelledIds.add(r10);     // Catch: Throwable -> L17
        WorkerWrapper r12 = this.mForegroundWorkMap.remove(r10);     // Catch: Throwable -> L17
        if (r12 == null) goto L7;
        boolean r13 = true;
    L8:
        if (r12 != null) goto L10;
        r12 = this.mEnqueuedWorkMap.remove(r10);     // Catch: Throwable -> L17
    L10:
        if (r12 == null) goto L12;
        this.mWorkRuns.remove(r10);     // Catch: Throwable -> L17
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L17
        boolean r14 = interrupt(r10, r12);
        if (r13 == false) goto L16;
        stopForegroundService();
    L16:
        return r14;
    L7:
        r13 = false;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // androidx.work.impl.foreground.ForegroundProcessor
    public void stopForeground(@NonNull String r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mForegroundWorkMap.remove(r10);     // Catch: Throwable -> L7
        stopForegroundService();     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean stopForegroundWork(@NonNull StartStopToken r10) {
        String r11 = r10.getId().getWorkSpecId();
        Object r12 = this.mLock;
        monitor-enter(r12);
        Logger.get().debug(TAG, "Processor stopping foreground work " + r11);     // Catch: Throwable -> L10
        WorkerWrapper r13 = this.mForegroundWorkMap.remove(r11);     // Catch: Throwable -> L10
        if (r13 == null) goto L7;
        this.mWorkRuns.remove(r11);     // Catch: Throwable -> L10
    L7:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return interrupt(r11, r13);
    L10:
        th = move-exception;
        throw th;
    }

    public boolean stopWork(@NonNull StartStopToken r10) {
        String r11 = r10.getId().getWorkSpecId();
        Object r12 = this.mLock;
        monitor-enter(r12);
        WorkerWrapper r13 = this.mEnqueuedWorkMap.remove(r11);     // Catch: Throwable -> L20
        if (r13 != null) goto L9;
        Logger.get().debug(TAG, "WorkerWrapper could not be found for " + r11);     // Catch: Throwable -> L20
        monitor-exit(r12);     // Catch: Throwable -> L20
        return false;
    L9:
        Set<StartStopToken> r14 = this.mWorkRuns.get(r11);     // Catch: Throwable -> L20
        if (r14 != null) goto L12;
    L18:
        monitor-exit(r12);     // Catch: Throwable -> L20
        return false;
    L12:
        if (r14.contains(r10) == false) goto L18;
        Logger.get().debug(TAG, "Processor stopping background work " + r11);     // Catch: Throwable -> L20
        this.mWorkRuns.remove(r11);     // Catch: Throwable -> L20
        monitor-exit(r12);     // Catch: Throwable -> L20
        return interrupt(r11, r13);
    L20:
        th = move-exception;
        throw th;
    }
}
