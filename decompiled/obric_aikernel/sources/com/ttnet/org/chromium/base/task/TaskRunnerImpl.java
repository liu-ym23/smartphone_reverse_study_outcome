package com.ttnet.org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base")
public class TaskRunnerImpl implements TaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Set<TaskRunnerCleaner> sCleaners = null;
    private static final ReferenceQueue<Object> sQueue = null;
    private boolean mDidOneTimeInitialization;
    private volatile long mNativeTaskRunnerAndroid;

    @Nullable
    private List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    private final Object mPreNativeTaskLock;

    @Nullable
    private LinkedList<Runnable> mPreNativeTasks;
    protected final Runnable mRunPreNativeTaskClosure;
    private final int mTaskRunnerType;
    private final TaskTraits mTaskTraits;
    private final String mTraceEvent;

    interface Natives {
        boolean belongsToCurrentThread(long r10);

        void destroy(long r10);

        long init(int r10, int r11, boolean r12, boolean r13, byte r14, byte[] r15);

        void postDelayedTask(long r10, Runnable r11, long r12, String r13);
    }

    private static class TaskRunnerCleaner extends WeakReference<TaskRunnerImpl> {
        final long mNativePtr;

        TaskRunnerCleaner(TaskRunnerImpl r10) {
            super(r10, TaskRunnerImpl.access$000());
            this.mNativePtr = TaskRunnerImpl.access$100(r10);
        }

        void destroy() {
            TaskRunnerImplJni.get().destroy(this.mNativePtr);
        }
    }

    static {
        sQueue = new ReferenceQueue();
        sCleaners = new HashSet();
    }

    TaskRunnerImpl(TaskTraits r10) {
        this(r10, "TaskRunnerImpl", 0);
        destroyGarbageCollectedTaskRunners();
    }

    protected TaskRunnerImpl(TaskTraits r10, String r11, int r12) {
        this.mRunPreNativeTaskClosure = new f(this);
        this.mPreNativeTaskLock = new Object();
        this.mTaskTraits = r10.withExplicitDestination();
        this.mTraceEvent = r11 + ".PreNativeTask.run";
        this.mTaskRunnerType = r12;
    }

    static /* synthetic */ ReferenceQueue access$000() {
        return sQueue;
    }

    static /* synthetic */ long access$100(TaskRunnerImpl r10) {
        return r10.mNativeTaskRunnerAndroid;
    }

    private static void destroyGarbageCollectedTaskRunners() {
    L2:
        TaskRunnerCleaner r10 = (TaskRunnerCleaner) sQueue.poll();
        if (r10 == null) goto L4;
        r10.destroy();
        Set<TaskRunnerCleaner> r11 = sCleaners;
        monitor-enter(r11);
        r11.remove(r10);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private void oneTimeInitialization() {
        if (this.mDidOneTimeInitialization == false) goto L5;
        return;
    L5:
        this.mDidOneTimeInitialization = true;
        if (PostTask.registerPreNativeTaskRunner(this) == true) goto L8;
        initNativeTaskRunner();
        return;
    L8:
        this.mPreNativeTasks = new LinkedList();
        this.mPreNativeDelayedTasks = new ArrayList();
    }

    protected Boolean belongsToCurrentThreadInternal() {
        Object r10 = this.mPreNativeTaskLock;
        monitor-enter(r10);
        oneTimeInitialization();     // Catch: Throwable -> L12
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (this.mNativeTaskRunnerAndroid != 0) goto L11;
        return null;
    L11:
        return Boolean.valueOf(TaskRunnerImplJni.get().belongsToCurrentThread(this.mNativeTaskRunnerAndroid));
    L12:
        th = move-exception;
        throw th;
    }

    void initNativeTaskRunner() {
        Natives r10 = TaskRunnerImplJni.get();
        int r11 = this.mTaskRunnerType;
        TaskTraits r12 = this.mTaskTraits;
        long r13 = r10.init(r11, r12.mPriority, r12.mMayBlock, r12.mUseThreadPool, r12.mExtensionId, r12.mExtensionData);
        Object r14 = this.mPreNativeTaskLock;
        monitor-enter(r14);
        LinkedList<Runnable> r15 = this.mPreNativeTasks;     // Catch: Throwable -> L29
        if (r15 == null) goto L11;
        Iterator<Runnable> r16 = r15.iterator();     // Catch: Throwable -> L29
    L8:
        if (r16.hasNext() == false) goto L10;
        Runnable r17 = r16.next();     // Catch: Throwable -> L29
        TaskRunnerImplJni.get().postDelayedTask(r13, r17, 0, r17.getClass().getName());     // Catch: Throwable -> L29
        goto L8
    L10:
        this.mPreNativeTasks = null;     // Catch: Throwable -> L29
    L11:
        List<Pair<Runnable, Long>> r18 = this.mPreNativeDelayedTasks;     // Catch: Throwable -> L29
        if (r18 == null) goto L18;
        Iterator<Pair<Runnable, Long>> r19 = r18.iterator();     // Catch: Throwable -> L29
    L15:
        if (r19.hasNext() == false) goto L17;
        Pair<Runnable, Long> r20 = r19.next();     // Catch: Throwable -> L29
        TaskRunnerImplJni.get().postDelayedTask(r13, (Runnable) r20.first, ((Long) r20.second).longValue(), r20.getClass().getName());     // Catch: Throwable -> L29
        goto L15
    L17:
        this.mPreNativeDelayedTasks = null;     // Catch: Throwable -> L29
    L18:
        this.mNativeTaskRunnerAndroid = r13;     // Catch: Throwable -> L29
        monitor-exit(r14);     // Catch: Throwable -> L29
        Set<TaskRunnerCleaner> r21 = sCleaners;
        monitor-enter(r21);
        r21.add(new TaskRunnerCleaner(this));     // Catch: Throwable -> L26
        monitor-exit(r21);     // Catch: Throwable -> L26
        destroyGarbageCollectedTaskRunners();
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postDelayedTask(Runnable r12, long r13) {
        if (this.mNativeTaskRunnerAndroid == 0) goto L6;
        TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, r12, r13, r12.getClass().getName());
        return;
    L6:
        Object r10 = this.mPreNativeTaskLock;
        monitor-enter(r10);
        oneTimeInitialization();     // Catch: Throwable -> L19
        if (this.mNativeTaskRunnerAndroid == 0) goto L14;
        TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, r12, r13, r12.getClass().getName());     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L14:
        if (r13 != 0) goto L16;
        this.mPreNativeTasks.add(r12);     // Catch: Throwable -> L19
        schedulePreNativeTask();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L16:
        Pair<Runnable, Long> r11 = new Pair(r12, Long.valueOf(r13));     // Catch: Throwable -> L19
        this.mPreNativeDelayedTasks.add(r11);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(Runnable r10) {
        postDelayedTask(r10, 0);
    }

    protected void runPreNativeTask() {
        TraceEvent r10 = TraceEvent.scoped(this.mTraceEvent);
        Object r11 = this.mPreNativeTaskLock;     // Catch: Throwable -> L27
        monitor-enter(r11);     // Catch: Throwable -> L27
        LinkedList<Runnable> r12 = this.mPreNativeTasks;     // Catch: Throwable -> L24
        if (r12 != null) goto L11;
        monitor-exit(r11);     // Catch: Throwable -> L24
        if (r10 == null) goto L38;
        r10.close();
        return;
    L38:
        return;
    L11:
        Runnable r13 = r12.poll();     // Catch: Throwable -> L24
        monitor-exit(r11);     // Catch: Throwable -> L24
        int r14 = this.mTaskTraits.mPriority;     // Catch: Throwable -> L27
        if (r14 != 1) goto L16;
        Process.setThreadPriority(0);     // Catch: Throwable -> L27
    L20:
        r13.run();     // Catch: Throwable -> L27
        if (r10 == null) goto L39;
        r10.close();
        return;
    L39:
        return;
    L16:
        if (r14 == 2) goto L18;
        Process.setThreadPriority(10);     // Catch: Throwable -> L27
        goto L20
    L18:
        Process.setThreadPriority(-1);     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        if (r10 != null) goto L35;
    L33:
        throw th;
    L35:
        r10.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);
        goto L33
    }

    protected void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }
}
