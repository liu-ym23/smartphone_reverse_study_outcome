package com.ttnet.org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base")
public class TaskRunnerImpl implements TaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Set<TaskRunnerCleaner> sCleaners = null;
    private static final ReferenceQueue<Object> sQueue = null;
    private boolean mDidOneTimeInitialization;
    private volatile long mNativeTaskRunnerAndroid;
    private List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    private final Object mPreNativeTaskLock;
    private LinkedList<Runnable> mPreNativeTasks;
    protected final Runnable mRunPreNativeTaskClosure;
    private final int mTaskRunnerType;
    private final TaskTraits mTaskTraits;
    private final String mTraceEvent;

    interface Natives {
        boolean belongsToCurrentThread(long r1);

        void destroy(long r1);

        long init(int r1, int r2, boolean r3, boolean r4, byte r5, byte[] r6);

        void postDelayedTask(long r1, Runnable r3, long r4, String r6);
    }

    private static class TaskRunnerCleaner extends WeakReference<TaskRunnerImpl> {
        final long mNativePtr;

        TaskRunnerCleaner(TaskRunnerImpl r3) {
            super(r3, TaskRunnerImpl.access$000());
            this.mNativePtr = TaskRunnerImpl.access$100(r3);
        }

        void destroy() {
            TaskRunnerImplJni.get().destroy(this.mNativePtr);
        }
    }

    static {
        sQueue = new ReferenceQueue();
        sCleaners = new HashSet();
    }

    TaskRunnerImpl(TaskTraits r3) {
        this(r3, "TaskRunnerImpl", 0);
        destroyGarbageCollectedTaskRunners();
    }

    public TaskRunnerImpl(TaskTraits r2, String r3, int r4) {
        this.mRunPreNativeTaskClosure = new $$Lambda$T5uz9GV8LcCnvHnFtZG5isvEdEk(this);
        this.mPreNativeTaskLock = new Object();
        this.mTaskTraits = r2.withExplicitDestination();
        this.mTraceEvent = r3 + ".PreNativeTask.run";
        this.mTaskRunnerType = r4;
    }

    static /* synthetic */ ReferenceQueue access$000() {
        return sQueue;
    }

    static /* synthetic */ long access$100(TaskRunnerImpl r2) {
        return r2.mNativeTaskRunnerAndroid;
    }

    private static void destroyGarbageCollectedTaskRunners() {
    L2:
        TaskRunnerCleaner r0 = (TaskRunnerCleaner) ZeusTransformUtils.preCheckCast(sQueue.poll(), TaskRunnerCleaner.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        r0.destroy();
        Set<TaskRunnerCleaner> r1 = sCleaners;
        monitor-enter(r1);
        r1.remove(r0);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
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

    public Boolean belongsToCurrentThreadInternal() {
        Object r0 = this.mPreNativeTaskLock;
        monitor-enter(r0);
        oneTimeInitialization();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (this.mNativeTaskRunnerAndroid != 0) goto L11;
        return null;
    L11:
        return Boolean.valueOf(TaskRunnerImplJni.get().belongsToCurrentThread(this.mNativeTaskRunnerAndroid));
    L12:
        th = move-exception;
        throw th;
    }

    void initNativeTaskRunner() {
        long r0 = TaskRunnerImplJni.get().init(this.mTaskRunnerType, this.mTaskTraits.mPriority, this.mTaskTraits.mMayBlock, this.mTaskTraits.mUseThreadPool, this.mTaskTraits.mExtensionId, this.mTaskTraits.mExtensionData);
        Object r2 = this.mPreNativeTaskLock;
        monitor-enter(r2);
        LinkedList<Runnable> r3 = this.mPreNativeTasks;     // Catch: Throwable -> L29
        if (r3 == null) goto L11;
        Iterator<Runnable> r4 = r3.iterator();     // Catch: Throwable -> L29
    L8:
        if (r4.hasNext() == false) goto L10;
        Runnable r10 = (Runnable) ZeusTransformUtils.preCheckCast(r4.next(), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        TaskRunnerImplJni.get().postDelayedTask(r0, r10, 0, r10.getClass().getName());     // Catch: Throwable -> L29
        goto L8
    L10:
        this.mPreNativeTasks = null;     // Catch: Throwable -> L29
    L11:
        List<Pair<Runnable, Long>> r5 = this.mPreNativeDelayedTasks;     // Catch: Throwable -> L29
        if (r5 == null) goto L18;
        Iterator<Pair<Runnable, Long>> r6 = r5.iterator();     // Catch: Throwable -> L29
    L15:
        if (r6.hasNext() == false) goto L17;
        Pair r7 = (Pair) ZeusTransformUtils.preCheckCast(r6.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        TaskRunnerImplJni.get().postDelayedTask(r0, (Runnable) ZeusTransformUtils.preCheckCast(r7.first, Runnable.class, "com.obric.memorydata.plugin"), ((Long) ZeusTransformUtils.preCheckCast(r7.second, Long.class, "com.obric.memorydata.plugin")).longValue(), r7.getClass().getName());     // Catch: Throwable -> L29
        goto L15
    L17:
        this.mPreNativeDelayedTasks = null;     // Catch: Throwable -> L29
    L18:
        this.mNativeTaskRunnerAndroid = r0;     // Catch: Throwable -> L29
        monitor-exit(r2);     // Catch: Throwable -> L29
        Set<TaskRunnerCleaner> r1 = sCleaners;
        monitor-enter(r1);
        r1.add(new TaskRunnerCleaner(this));     // Catch: Throwable -> L26
        monitor-exit(r1);     // Catch: Throwable -> L26
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
    public void postDelayedTask(Runnable r8, long r9) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r8, Runnable.class, "com.obric.memorydata.plugin");
        if (this.mNativeTaskRunnerAndroid == 0) goto L6;
        TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, r3, r9, r3.getClass().getName());
        return;
    L6:
        Object r10 = this.mPreNativeTaskLock;
        monitor-enter(r10);
        oneTimeInitialization();     // Catch: Throwable -> L19
        if (this.mNativeTaskRunnerAndroid == 0) goto L14;
        TaskRunnerImplJni.get().postDelayedTask(this.mNativeTaskRunnerAndroid, r3, r9, r3.getClass().getName());     // Catch: Throwable -> L19
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L14:
        if (r9 != 0) goto L16;
        this.mPreNativeTasks.add(r3);     // Catch: Throwable -> L19
        schedulePreNativeTask();     // Catch: Throwable -> L19
    L17:
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L16:
        Pair<Runnable, Long> r0 = new Pair(r3, Long.valueOf(r9));     // Catch: Throwable -> L19
        this.mPreNativeDelayedTasks.add(r0);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(Runnable r3) {
        postDelayedTask((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), 0);
    }

    public void runPreNativeTask() {
        TraceEvent r0 = TraceEvent.scoped(this.mTraceEvent);
        Object r1 = this.mPreNativeTaskLock;     // Catch: Throwable -> L27
        monitor-enter(r1);     // Catch: Throwable -> L27
        LinkedList<Runnable> r2 = this.mPreNativeTasks;     // Catch: Throwable -> L24
        if (r2 != null) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L24
        if (r0 == null) goto L38;
        r0.close();
        return;
    L38:
        return;
    L11:
        Runnable r3 = (Runnable) ZeusTransformUtils.preCheckCast(r2.poll(), Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        int r5 = this.mTaskTraits.mPriority;     // Catch: Throwable -> L27
        if (r5 != 1) goto L16;
        Process.setThreadPriority(0);     // Catch: Throwable -> L27
    L20:
        r3.run();     // Catch: Throwable -> L27
        if (r0 == null) goto L39;
        r0.close();
        return;
    L39:
        return;
    L16:
        if (r5 == 2) goto L18;
        Process.setThreadPriority(10);     // Catch: Throwable -> L27
        goto L20
    L18:
        Process.setThreadPriority(-1);     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        if (r0 != null) goto L36;
    L33:
        throw th;
    L36:
        r0.close();     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        th.addSuppressed(th);
        goto L33
    }

    public void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }
}
