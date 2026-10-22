package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base")
public class PostTask {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static volatile boolean sNativeInitialized;
    private static final Object sPreNativeTaskRunnerLock = null;
    private static List<TaskRunnerImpl> sPreNativeTaskRunners;
    private static final Executor sPrenativeThreadPoolExecutor = null;
    private static volatile Executor sPrenativeThreadPoolExecutorOverride;
    private static AtomicReferenceArray<TaskExecutor> sTaskExecutors;

    interface Natives {
        void postDelayedTask(int r10, boolean r11, boolean r12, byte r13, byte[] r14, Runnable r15, long r16, String r17);
    }

    static {
        sPreNativeTaskRunnerLock = new Object();
        sPreNativeTaskRunners = new ArrayList();
        sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
        sTaskExecutors = getInitialTaskExecutors();
    }

    public PostTask() {
    }

    public static boolean canRunTaskImmediately(TaskTraits r10) {
        return getTaskExecutorForTraits(r10).canRunTaskImmediately(r10);
    }

    public static SequencedTaskRunner createSequencedTaskRunner(TaskTraits r10) {
        return getTaskExecutorForTraits(r10).createSequencedTaskRunner(r10);
    }

    public static SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r10) {
        return getTaskExecutorForTraits(r10).createSingleThreadTaskRunner(r10);
    }

    public static TaskRunner createTaskRunner(TaskTraits r10) {
        return getTaskExecutorForTraits(r10).createTaskRunner(r10);
    }

    private static AtomicReferenceArray<TaskExecutor> getInitialTaskExecutors() {
        AtomicReferenceArray<TaskExecutor> r10 = new AtomicReferenceArray(5);
        r10.set(0, new DefaultTaskExecutor());
        return r10;
    }

    static Executor getPrenativeThreadPoolExecutor() {
        if (sPrenativeThreadPoolExecutorOverride == null) goto L7;
        return sPrenativeThreadPoolExecutorOverride;
    L7:
        return sPrenativeThreadPoolExecutor;
    }

    private static TaskExecutor getTaskExecutorForTraits(TaskTraits r10) {
        return sTaskExecutors.get(r10.mExtensionId);
    }

    @CalledByNative
    private static void onNativeSchedulerReady() {
        sNativeInitialized = true;
        Object r10 = sPreNativeTaskRunnerLock;
        monitor-enter(r10);
        List<TaskRunnerImpl> r11 = sPreNativeTaskRunners;     // Catch: Throwable -> L11
        sPreNativeTaskRunners = null;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        Iterator<TaskRunnerImpl> r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r12.next().initNativeTaskRunner();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @CalledByNative
    private static void onNativeSchedulerShutdownForTesting() {
        Object r10 = sPreNativeTaskRunnerLock;
        monitor-enter(r10);
        sPreNativeTaskRunners = new ArrayList();     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
        sNativeInitialized = false;
        sTaskExecutors.set(0, new DefaultTaskExecutor());
        int r11 = 1;
    L8:
        if (r11 >= sTaskExecutors.length()) goto L10;
        sTaskExecutors.set(r11, null);
        r11 = r11 + 1;
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void postDelayedTask(TaskTraits r10, Runnable r11, long r12) {
        if (sNativeInitialized == true) goto L5;
    L8:
        getTaskExecutorForTraits(r10).postDelayedTask(r10, r11, r12);
        return;
    L5:
        if (r10.mIsChoreographerFrame == true) goto L8;
        TaskTraits r13 = r10.withExplicitDestination();
        PostTaskJni.get().postDelayedTask(r13.mPriority, r13.mMayBlock, r13.mUseThreadPool, r13.mExtensionId, r13.mExtensionData, r11, r12, r11.getClass().getName());
    }

    public static void postTask(TaskTraits r10, Runnable r11) {
        postDelayedTask(r10, r11, 0);
    }

    static boolean registerPreNativeTaskRunner(TaskRunnerImpl r10) {
        Object r11 = sPreNativeTaskRunnerLock;
        monitor-enter(r11);
        List<TaskRunnerImpl> r12 = sPreNativeTaskRunners;     // Catch: Throwable -> L12
        if (r12 == null) goto L7;
        r12.add(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return true;
    L7:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public static void registerTaskExecutor(int r10, TaskExecutor r11) {
        sTaskExecutors.set(r10, r11);
    }

    public static void resetPrenativeThreadPoolExecutorForTesting() {
        sPrenativeThreadPoolExecutorOverride = null;
    }

    public static void runOrPostTask(TaskTraits r10, Runnable r11) {
        if (getTaskExecutorForTraits(r10).canRunTaskImmediately(r10) == false) goto L5;
        r11.run();
        return;
    L5:
        postTask(r10, r11);
    }

    @Deprecated
    public static <T> T runSynchronously(TaskTraits r10, Callable<T> r11) {
        return (T) runSynchronouslyInternal(r10, new FutureTask(r11));
    }

    @Deprecated
    public static void runSynchronously(TaskTraits r10, Runnable r11) {
        runSynchronouslyInternal(r10, new FutureTask(r11, null));
    }

    private static <T> T runSynchronouslyInternal(TaskTraits r10, FutureTask<T> r11) {
        runOrPostTask(r10, r11);
        return r11.get();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setPrenativeThreadPoolExecutorForTesting(Executor r10) {
        sPrenativeThreadPoolExecutorOverride = r10;
    }
}
