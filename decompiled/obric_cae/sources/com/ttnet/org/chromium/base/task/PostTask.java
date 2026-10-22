package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base")
public class PostTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object sLock = null;
    private static Set<TaskRunner> sPreNativeTaskRunners;
    private static final Executor sPrenativeThreadPoolExecutor = null;
    private static Executor sPrenativeThreadPoolExecutorOverride;
    private static final TaskExecutor[] sTaskExecutors = null;

    static {
        sLock = new Object();
        sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());
        sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
        sTaskExecutors = getInitialTaskExecutors();
    }

    public PostTask() {
    }

    public static SequencedTaskRunner createSequencedTaskRunner(TaskTraits r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        SequencedTaskRunner r11 = getTaskExecutorForTraits(r8).createSequencedTaskRunner(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        SingleThreadTaskRunner r11 = getTaskExecutorForTraits(r8).createSingleThreadTaskRunner(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static TaskRunner createTaskRunner(TaskTraits r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        TaskRunner r11 = getTaskExecutorForTraits(r8).createTaskRunner(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    private static TaskExecutor[] getInitialTaskExecutors() {
        TaskExecutor[] r8 = new TaskExecutor[5];
        r8[0] = new DefaultTaskExecutor();
        return r8;
    }

    public static Executor getPrenativeThreadPoolExecutor() {
        Object r8 = sLock;
        monitor-enter(r8);
        Executor r10 = sPrenativeThreadPoolExecutorOverride;     // Catch: Throwable -> L11
        if (r10 == null) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L11
        return r10;
    L8:
        Executor r11 = sPrenativeThreadPoolExecutor;     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        return r11;
    L11:
        th = move-exception;
        throw th;
    }

    private static TaskExecutor getTaskExecutorForTraits(TaskTraits r8) {
        return sTaskExecutors[r8.mExtensionId];
    }

    private static native void nativePostDelayedTask(boolean r8, int r10, boolean r11, boolean r12, byte r13, byte[] r14, Runnable r15, long r16);

    @CalledByNative
    private static void onNativeSchedulerReady() {
        Object r8 = sLock;
        monitor-enter(r8);
        Set<TaskRunner> r10 = sPreNativeTaskRunners;     // Catch: Throwable -> L10
        sPreNativeTaskRunners = null;     // Catch: Throwable -> L10
        Iterator<TaskRunner> r11 = r10.iterator();     // Catch: Throwable -> L10
    L6:
        if (r11.hasNext() == false) goto L8;
        r11.next().initNativeTaskRunner();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r8);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private static void onNativeSchedulerShutdown() {
        Object r8 = sLock;
        monitor-enter(r8);
        sPreNativeTaskRunners = Collections.newSetFromMap(new WeakHashMap());     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void postDelayedTask(TaskTraits r11, Runnable r12, long r13) {
        Object r8 = sLock;
        monitor-enter(r8);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sPreNativeTaskRunners == null) goto L7;
    L10:
        getTaskExecutorForTraits(r11).postDelayedTask(r11, r12, r13);     // Catch: Throwable -> L13
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return;
    L7:
        if (r11.mIsChoreographerFrame == true) goto L10;
        nativePostDelayedTask(r11.mPrioritySetExplicitly, r11.mPriority, r11.mMayBlock, r11.mUseThreadPool, r11.mExtensionId, r11.mExtensionData, r12, r13);     // Catch: Throwable -> L13
        goto L11
    }

    public static void postTask(TaskTraits r8, Runnable r10) {
        postDelayedTask(r8, r10, 0);
    }

    public static boolean registerPreNativeTaskRunnerLocked(TaskRunner r8) {
        Set<TaskRunner> r10 = sPreNativeTaskRunners;
        if (r10 == null) goto L6;
        r10.add(r8);
        return true;
    L6:
        return false;
    }

    public static void registerTaskExecutor(int r8, TaskExecutor r10) {
        Object r11 = sLock;
        monitor-enter(r11);
        sTaskExecutors[r8] = r10;     // Catch: Throwable -> L9
        monitor-exit(r11);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void resetPrenativeThreadPoolExecutorForTesting() {
        Object r8 = sLock;
        monitor-enter(r8);
        sPrenativeThreadPoolExecutorOverride = null;     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void runOrPostTask(TaskTraits r8, Runnable r10) {
        if (getTaskExecutorForTraits(r8).canRunTaskImmediately(r8) == false) goto L5;
        r10.run();
        return;
    L5:
        postTask(r8, r10);
    }

    @Deprecated
    public static <T> T runSynchronously(TaskTraits r8, Callable<T> r10) {
        return (T) runSynchronouslyInternal(r8, new FutureTask(r10));
    }

    private static <T> T runSynchronouslyInternal(TaskTraits r8, FutureTask<T> r10) {
        runOrPostTask(r8, r10);
        return r10.get();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setPrenativeThreadPoolExecutorForTesting(Executor r8) {
        Object r10 = sLock;
        monitor-enter(r10);
        sPrenativeThreadPoolExecutorOverride = r8;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public static void runSynchronously(TaskTraits r8, Runnable r10) {
        runSynchronouslyInternal(r8, new FutureTask(r10, null));
    }
}
