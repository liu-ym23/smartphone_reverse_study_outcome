package com.ttnet.org.chromium.base.task;

import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes6.dex */
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
        void postDelayedTask(int r1, boolean r2, boolean r3, byte r4, byte[] r5, Runnable r6, long r7, String r9);
    }

    static {
        sPreNativeTaskRunnerLock = new Object();
        sPreNativeTaskRunners = new ArrayList();
        sPrenativeThreadPoolExecutor = new ChromeThreadPoolExecutor();
        sTaskExecutors = getInitialTaskExecutors();
    }

    public PostTask() {
    }

    public static boolean canRunTaskImmediately(TaskTraits r1) {
        return getTaskExecutorForTraits(r1).canRunTaskImmediately(r1);
    }

    public static SequencedTaskRunner createSequencedTaskRunner(TaskTraits r1) {
        return getTaskExecutorForTraits(r1).createSequencedTaskRunner(r1);
    }

    public static SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits r1) {
        return getTaskExecutorForTraits(r1).createSingleThreadTaskRunner(r1);
    }

    public static TaskRunner createTaskRunner(TaskTraits r1) {
        return getTaskExecutorForTraits(r1).createTaskRunner(r1);
    }

    private static AtomicReferenceArray<TaskExecutor> getInitialTaskExecutors() {
        AtomicReferenceArray<TaskExecutor> r0 = new AtomicReferenceArray(5);
        r0.set(0, new DefaultTaskExecutor());
        return r0;
    }

    static Executor getPrenativeThreadPoolExecutor() {
        if (sPrenativeThreadPoolExecutorOverride == null) goto L7;
        return sPrenativeThreadPoolExecutorOverride;
    L7:
        return sPrenativeThreadPoolExecutor;
    }

    private static TaskExecutor getTaskExecutorForTraits(TaskTraits r2) {
        return (TaskExecutor) ZeusTransformUtils.preCheckCast(sTaskExecutors.get(r2.mExtensionId), TaskExecutor.class, "com.obric.memorydata.plugin");
    }

    private static void onNativeSchedulerReady() {
        sNativeInitialized = true;
        Object r0 = sPreNativeTaskRunnerLock;
        monitor-enter(r0);
        List<TaskRunnerImpl> r1 = sPreNativeTaskRunners;     // Catch: Throwable -> L11
        sPreNativeTaskRunners = null;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator<TaskRunnerImpl> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((TaskRunnerImpl) ZeusTransformUtils.preCheckCast(r2.next(), TaskRunnerImpl.class, "com.obric.memorydata.plugin")).initNativeTaskRunner();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static void onNativeSchedulerShutdownForTesting() {
        Object r0 = sPreNativeTaskRunnerLock;
        monitor-enter(r0);
        sPreNativeTaskRunners = new ArrayList();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        sNativeInitialized = false;
        sTaskExecutors.set(0, new DefaultTaskExecutor());
        int r1 = 1;
    L8:
        if (r1 >= sTaskExecutors.length()) goto L10;
        sTaskExecutors.set(r1, null);
        r1 = r1 + 1;
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static void postDelayedTask(TaskTraits r10, Runnable r11, long r12) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.memorydata.plugin");
        if (sNativeInitialized == true) goto L5;
    L8:
        getTaskExecutorForTraits(r10).postDelayedTask(r10, r6, r12);
        return;
    L5:
        if (r10.mIsChoreographerFrame == true) goto L8;
        TaskTraits r13 = r10.withExplicitDestination();
        PostTaskJni.get().postDelayedTask(r13.mPriority, r13.mMayBlock, r13.mUseThreadPool, r13.mExtensionId, r13.mExtensionData, r6, r12, r6.getClass().getName());
    }

    public static void postTask(TaskTraits r2, Runnable r3) {
        postDelayedTask(r2, (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), 0);
    }

    static boolean registerPreNativeTaskRunner(TaskRunnerImpl r2) {
        Object r0 = sPreNativeTaskRunnerLock;
        monitor-enter(r0);
        List<TaskRunnerImpl> r1 = sPreNativeTaskRunners;     // Catch: Throwable -> L12
        if (r1 == null) goto L7;
        r1.add(r2);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public static void registerTaskExecutor(int r2, TaskExecutor r3) {
        TaskExecutor r4 = (TaskExecutor) ZeusTransformUtils.wrapperContextForParams(r3, TaskExecutor.class, "com.obric.memorydata.plugin");
        sTaskExecutors.set(r2, r4);
    }

    public static void resetPrenativeThreadPoolExecutorForTesting() {
        sPrenativeThreadPoolExecutorOverride = null;
    }

    public static void runOrPostTask(TaskTraits r2, Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (getTaskExecutorForTraits(r2).canRunTaskImmediately(r2) == false) goto L5;
        r4.run();
        return;
    L5:
        postTask(r2, r4);
    }

    @Deprecated
    public static <T> T runSynchronously(TaskTraits r2, Callable<T> r3) {
        return (T) runSynchronouslyInternal(r2, new FutureTask((Callable) ZeusTransformUtils.wrapperContextForParams(r3, Callable.class, "com.obric.memorydata.plugin")));
    }

    @Deprecated
    public static void runSynchronously(TaskTraits r2, Runnable r3) {
        runSynchronouslyInternal(r2, new FutureTask((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), null));
    }

    private static <T> T runSynchronouslyInternal(TaskTraits r0, FutureTask<T> r1) {
        runOrPostTask(r0, r1);
        return r1.get();
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static void setPrenativeThreadPoolExecutorForTesting(Executor r2) {
        sPrenativeThreadPoolExecutorOverride = (Executor) ZeusTransformUtils.wrapperContextForParams(r2, Executor.class, "com.obric.memorydata.plugin");
    }
}
