package com.ttnet.org.chromium.base.task;

import android.os.Process;
import android.util.Pair;
import com.ttnet.org.chromium.base.LifetimeAssert;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base")
public class TaskRunnerImpl implements TaskRunner {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @GuardedBy("mLock")
    private boolean mIsDestroying;
    private final LifetimeAssert mLifetimeAssert;
    protected final Object mLock;

    @GuardedBy("mLock")
    protected long mNativeTaskRunnerAndroid;
    protected List<Pair<Runnable, Long>> mPreNativeDelayedTasks;
    protected LinkedList<Runnable> mPreNativeTasks;
    protected final Runnable mRunPreNativeTaskClosure;
    private final int mTaskRunnerType;
    private final TaskTraits mTaskTraits;
    private final String mTraceEvent;

    public TaskRunnerImpl(TaskTraits r8) {
        this(r8, "TaskRunnerImpl", 0);
    }

    private native void nativeDestroy(long r8);

    private native long nativeInit(int r8, boolean r10, int r11, boolean r12, boolean r13, byte r14, byte[] r15);

    private native void nativePostDelayedTask(long r8, Runnable r10, long r11);

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void destroy() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        LifetimeAssert.setSafeToGc(this.mLifetimeAssert, true);     // Catch: Throwable -> L7
        this.mIsDestroying = true;     // Catch: Throwable -> L7
        destroyInternal();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @GuardedBy("mLock")
    public void destroyInternal() {
        long r8 = this.mNativeTaskRunnerAndroid;
        if (r8 == 0) goto L5;
        nativeDestroy(r8);
    L5:
        this.mNativeTaskRunnerAndroid = 0;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void disableLifetimeCheck() {
        LifetimeAssert.setSafeToGc(this.mLifetimeAssert, true);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void initNativeTaskRunner() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        initNativeTaskRunnerInternal();     // Catch: Throwable -> L7
        migratePreNativeTasksToNative();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @GuardedBy("mLock")
    public void initNativeTaskRunnerInternal() {
        if (this.mNativeTaskRunnerAndroid != 0) goto L6;
        int r8 = this.mTaskRunnerType;
        TaskTraits r10 = this.mTaskTraits;
        this.mNativeTaskRunnerAndroid = nativeInit(r8, r10.mPrioritySetExplicitly, r10.mPriority, r10.mMayBlock, r10.mUseThreadPool, r10.mExtensionId, r10.mExtensionData);
        return;
    }

    @GuardedBy("mLock")
    public void migratePreNativeTasksToNative() {
        LinkedList<Runnable> r8 = this.mPreNativeTasks;
        if (r8 == null) goto L16;
        Iterator<Runnable> r10 = r8.iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        postDelayedTaskToNative(r10.next(), 0);
        goto L6
    L8:
        Iterator<Pair<Runnable, Long>> r11 = this.mPreNativeDelayedTasks.iterator();
    L10:
        if (r11.hasNext() == false) goto L12;
        Pair<Runnable, Long> r12 = r11.next();
        postDelayedTaskToNative((Runnable) r12.first, ((Long) r12.second).longValue());
        goto L10
    L12:
        this.mPreNativeTasks = null;
        this.mPreNativeDelayedTasks = null;
        return;
    }

    public native boolean nativeBelongsToCurrentThread(long r8);

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postDelayedTask(Runnable r8, long r10) {
        Object r11 = this.mLock;
        monitor-enter(r11);
        LinkedList<Runnable> r12 = this.mPreNativeTasks;     // Catch: Throwable -> L17
        if (r12 != null) goto L10;
        postDelayedTaskToNative(r8, r10);     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L10:
        if (r10 != 0) goto L12;
        r12.add(r8);     // Catch: Throwable -> L17
        schedulePreNativeTask();     // Catch: Throwable -> L17
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return;
    L12:
        Pair<Runnable, Long> r13 = new Pair(r8, Long.valueOf(r10));     // Catch: Throwable -> L17
        this.mPreNativeDelayedTasks.add(r13);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @GuardedBy("mLock")
    public void postDelayedTaskToNative(Runnable r8, long r10) {
        nativePostDelayedTask(this.mNativeTaskRunnerAndroid, r8, r10);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskRunner
    public void postTask(Runnable r8) {
        postDelayedTask(r8, 0);
    }

    public void runPreNativeTask() {
        TraceEvent r8 = TraceEvent.scoped(this.mTraceEvent);
        Object r10 = this.mLock;     // Catch: Throwable -> L27
        monitor-enter(r10);     // Catch: Throwable -> L27
        LinkedList<Runnable> r11 = this.mPreNativeTasks;     // Catch: Throwable -> L24
        if (r11 != null) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L24
        if (r8 == null) goto L42;
        r8.close();
        return;
    L42:
        return;
    L11:
        Runnable r12 = r11.poll();     // Catch: Throwable -> L24
        monitor-exit(r10);     // Catch: Throwable -> L24
        int r13 = this.mTaskTraits.mPriority;     // Catch: Throwable -> L27
        if (r13 != 1) goto L16;
        Process.setThreadPriority(0);     // Catch: Throwable -> L27
    L20:
        r12.run();     // Catch: Throwable -> L27
        if (r8 == null) goto L43;
        r8.close();
        return;
    L43:
        return;
    L16:
        if (r13 == 2) goto L18;
        Process.setThreadPriority(10);     // Catch: Throwable -> L27
        goto L20
    L18:
        Process.setThreadPriority(-1);     // Catch: Throwable -> L27
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        if (r8 != null) goto L39;
    L35:
        throw th;
    L39:
        r8.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.addSuppressed(th);
        goto L35
    }

    public void schedulePreNativeTask() {
        PostTask.getPrenativeThreadPoolExecutor().execute(this.mRunPreNativeTaskClosure);
    }

    public TaskRunnerImpl(TaskTraits r8, String r10, int r11) {
        this.mLock = new Object();
        this.mRunPreNativeTaskClosure = new a(this, 1);
        this.mLifetimeAssert = LifetimeAssert.create(this);
        this.mPreNativeTasks = new LinkedList();
        this.mPreNativeDelayedTasks = new ArrayList();
        this.mTaskTraits = r8;
        this.mTraceEvent = defpackage.a.e(r10, ".PreNativeTask.run");
        this.mTaskRunnerType = r11;
        if (PostTask.registerPreNativeTaskRunnerLocked(this) == true) goto L6;
        initNativeTaskRunner();
        return;
    }
}
