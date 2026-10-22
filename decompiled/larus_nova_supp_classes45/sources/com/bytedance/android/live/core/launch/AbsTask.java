package com.bytedance.android.live.core.launch;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class AbsTask {
    public static final int ERROR = 3;
    public static final int FINISHED = 2;
    public static final int IDLE = 0;
    public static final int RUNNING = 1;
    private AbsTask mNextTask;
    private volatile int mStatus;

    public @interface TaskStatus {
    }

    public Callable asyncCallable() {
        return null;
    }

    public synchronized boolean isFinished() {
        monitor-enter(this);
        if (this.mStatus != 2) goto L7;
        boolean r0 = true;
    L8:
        monitor-exit(this);
        return r0;
    L7:
        r0 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isIDLE() {
        monitor-enter(this);
        if (this.mStatus != 0) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isRunning() {
        monitor-enter(this);
        boolean r1 = true;
        if (this.mStatus == 1) goto L8;
        r1 = false;
    L8:
        monitor-exit(this);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public List<Integer> preTasks() {
        return Arrays.asList(new Integer[]{0});
    }

    public abstract void run();

    public final List<Integer> getPreTasks() {
        ArrayList r0 = new ArrayList();
        if (preTasks() == null) goto L10;
        r0.add(0);
        Iterator<Integer> r1 = preTasks().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        Integer r2 = r1.next();
        if (r0.contains(r2) == true) goto L6;
        r0.add(r2);
    L10:
        return r0;
    }

    public void start() {
        if (this.mStatus != 2) goto L5;
        return;
    L5:
        if (this.mStatus == 1) goto L17;
        updateStatus(1);
        run();     // Catch: Exception -> L11
        updateStatus(2);
        return;
    L11:
        e = move-exception;
        updateStatus(3);
        throw e;
    }

    public AbsTask() {
        this.mStatus = 0;
    }

    public String getTaskBusinessInfo() {
        Task r0 = (Task) getClass().getAnnotation(Task.class);     // Catch: Exception -> L15
        if (r0 != null) goto L5;
        Annotation[] r1 = getClass().getAnnotations();     // Catch: Exception -> L15
        int r2 = r1.length;     // Catch: Exception -> L15
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        Annotation r4 = r1[r3];     // Catch: Exception -> L15
        if ((r4 instanceof Task) == true) goto L11;
        r3 = r3 + 1;     // Catch: Exception -> L15
        goto L7
    L11:
        return ((Task) r4).businessInfo();
    L13:
        return "";
    L5:
        return r0.businessInfo();
    L15:
        e = move-exception;
        ALogger.e("ttlive_sdk_launch_error", getClass().getCanonicalName() + " task getTaskBusinessInfo exception");
        ALogger.stacktrace(6, "ttlive_sdk_launch_error", e.getStackTrace());
        throw e;
    }

    public int getTaskId() {
        Task r0 = (Task) getClass().getAnnotation(Task.class);     // Catch: Exception -> L15
        if (r0 != null) goto L5;
        Annotation[] r1 = getClass().getAnnotations();     // Catch: Exception -> L15
        int r2 = r1.length;     // Catch: Exception -> L15
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L13;
        Annotation r4 = r1[r3];     // Catch: Exception -> L15
        if ((r4 instanceof Task) == true) goto L11;
        r3 = r3 + 1;
        goto L7
    L11:
        return ((Task) r4).value();
    L13:
        return -1;
    L5:
        return r0.value();
    L15:
        e = move-exception;
        ALogger.e("ttlive_sdk_launch_error", getClass().getCanonicalName() + " task getTaskID exception");
        ALogger.stacktrace(6, "ttlive_sdk_launch_error", e.getStackTrace());
        throw e;
    }

    public final AbsTask next() {
        return this.mNextTask;
    }

    public void append(AbsTask r1) {
        this.mNextTask = r1;
    }

    public void updateStatus(int r1) {
        this.mStatus = r1;
    }
}
