package com.bytedance.lego.init.config;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.lego.init.util.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0001.Bo\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010+\u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020\u000bH\u0002J\b\u0010-\u001a\u00020\u000bH\u0002R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00010\t8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig;", "", "isDebug", "", "base", "Landroid/content/Context;", "mode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "coreThreadNum", "", "isMainProcess", "processName", "", LocationMonitorConst.TIMEOUT, "catchException", "applicationStartTime", "", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "(ZLandroid/content/Context;Lcom/bytedance/lego/init/config/ProcessMatchMode;Ljava/util/concurrent/ThreadPoolExecutor;Ljava/util/concurrent/ThreadFactory;IZLjava/lang/String;IZJLcom/bytedance/lego/init/IdleTaskConfig;)V", "getApplicationStartTime", "()J", "getBase", "()Landroid/content/Context;", "getCatchException", "()Z", "getIdleTaskConfig", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "getMode", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getProcessName", "()Ljava/lang/String;", "taskExecutor", "getTaskExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "setTaskExecutor", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "getTimeout", "()I", "getDefaultExecutor", "getDefaultThreadFactory", "getThreadFactory", "Builder", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
public final class TaskConfig {
    private final long applicationStartTime;
    private final Context base;
    private final boolean catchException;
    private final int coreThreadNum;
    private final ThreadPoolExecutor executor;
    private final IdleTaskConfig idleTaskConfig;
    private final boolean isDebug;
    private final boolean isMainProcess;
    private final ProcessMatchMode mode;
    private final String processName;
    private ThreadPoolExecutor taskExecutor;
    private final ThreadFactory threadFactory;
    private final int timeout;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0014J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\rR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "", "base", "Landroid/content/Context;", "isMainProcess", "", "processName", "", "(Landroid/content/Context;ZLjava/lang/String;)V", "applicationStartTime", "", "catchException", "coreThreadNum", "", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "isDebug", "processMatchMode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", LocationMonitorConst.TIMEOUT, "build", "Lcom/bytedance/lego/init/config/TaskConfig;", "enableCatchException", "enable", "setApplicationStartTime", "setCoreThreadNum", "setExecutorService", "setIdleTaskConfig", "setProcessMatchMode", "mode", "setThreadFactory", "setTimeOut", "millis", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
    public static final class Builder {
        private long applicationStartTime;
        private final Context base;
        private boolean catchException;
        private int coreThreadNum;
        private ThreadPoolExecutor executor;
        private IdleTaskConfig idleTaskConfig;
        private boolean isDebug;
        private final boolean isMainProcess;
        private ProcessMatchMode processMatchMode;
        private final String processName;
        private ThreadFactory threadFactory;
        private int timeout;

        public Builder(Context r3, boolean r4, String r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r6, "base");
            Intrinsics.checkParameterIsNotNull(r5, "processName");
            this.base = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
            this.isMainProcess = r4;
            this.processName = r5;
            this.processMatchMode = ProcessMatchMode.CONTAIN;
            this.coreThreadNum = Runtime.getRuntime().availableProcessors();
            this.timeout = 8000;
            this.idleTaskConfig = IdleTaskConfig.Companion.a();
            this.applicationStartTime = System.currentTimeMillis();
        }

        public final TaskConfig build() {
            boolean r1 = this.isDebug;
            Context r2 = this.base;
            ThreadPoolExecutor r4 = this.executor;
            ProcessMatchMode r3 = this.processMatchMode;
            int r6 = this.coreThreadNum;
            return new TaskConfig(r1, r2, r3, r4, this.threadFactory, r6, this.isMainProcess, this.processName, this.timeout, this.catchException, this.applicationStartTime, this.idleTaskConfig, null);
        }

        public final Builder enableCatchException(boolean r1) {
            this.catchException = r1;
            return this;
        }

        public final Builder isDebug(boolean r1) {
            this.isDebug = r1;
            return this;
        }

        public final Builder setApplicationStartTime(long r1) {
            this.applicationStartTime = r1;
            return this;
        }

        public final Builder setCoreThreadNum(int r1) {
            this.coreThreadNum = r1;
            return this;
        }

        public final Builder setExecutorService(ThreadPoolExecutor r2) {
            Intrinsics.checkParameterIsNotNull(r2, "executor");
            this.executor = r2;
            return this;
        }

        public final Builder setIdleTaskConfig(IdleTaskConfig r2) {
            Intrinsics.checkParameterIsNotNull(r2, "idleTaskConfig");
            this.idleTaskConfig = r2;
            return this;
        }

        public final Builder setProcessMatchMode(ProcessMatchMode r2) {
            Intrinsics.checkParameterIsNotNull(r2, "mode");
            this.processMatchMode = r2;
            return this;
        }

        public final Builder setThreadFactory(ThreadFactory r3) {
            ThreadFactory r4 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r3, ThreadFactory.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r4, "threadFactory");
            this.threadFactory = r4;
            return this;
        }

        public final Builder setTimeOut(int r5) {
            if (r5 >= 3000) goto L5;
            d.c(d.f2800a, null, "TaskConfig.timeout must not be less than 3*1000", 1, null);
            this.timeout = 3000;
        L6:
            return this;
        L5:
            this.timeout = r5;
            goto L6
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"com/bytedance/lego/init/config/TaskConfig$getDefaultThreadFactory$1", "Ljava/util/concurrent/ThreadFactory;", "mCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "r", "Ljava/lang/Runnable;", "initscheduler_release"}, k = 1, mv = {1, 1, 13})
    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f2762a;

        a() {
            this.f2762a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r4) {
            Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            Intrinsics.checkParameterIsNotNull(r5, "r");
            return new Thread(r5, "AA InitThread#" + this.f2762a.getAndIncrement());
        }
    }

    private TaskConfig(boolean r3, Context r4, ProcessMatchMode r5, ThreadPoolExecutor r6, ThreadFactory r7, int r8, boolean r9, String r10, int r11, boolean r12, long r13, IdleTaskConfig r15) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        ThreadFactory r16 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r7, ThreadFactory.class, "com.obric.memorydata.plugin");
        this.isDebug = r3;
        this.base = ZeusTransformUtils.wrapperContext(r14, "com.obric.memorydata.plugin");
        this.mode = r5;
        this.executor = r6;
        this.threadFactory = r16;
        this.coreThreadNum = r8;
        this.isMainProcess = r9;
        this.processName = r10;
        this.timeout = r11;
        this.catchException = r12;
        this.applicationStartTime = r13;
        this.idleTaskConfig = r15;
    }

    /* synthetic */ TaskConfig(boolean r17, Context r18, ProcessMatchMode r19, ThreadPoolExecutor r20, ThreadFactory r21, int r22, boolean r23, String r24, int r25, boolean r26, long r27, IdleTaskConfig r29, int r30, DefaultConstructorMarker r31) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        ThreadFactory r0 = (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r21, ThreadFactory.class, "com.obric.memorydata.plugin");
        if ((r30 & 8) == 0) goto L5;
        ThreadPoolExecutor r6 = (ThreadPoolExecutor) ZeusTransformUtils.preCheckCast(null, ThreadPoolExecutor.class, "com.obric.memorydata.plugin");
    L7:
        if ((r30 & 16) == 0) goto L9;
        r0 = (ThreadFactory) ZeusTransformUtils.preCheckCast(null, ThreadFactory.class, "com.obric.memorydata.plugin");
    L9:
        this(r17, r4, r19, r6, r0, r22, r23, r24, r25, r26, r27, r29);
        return;
    L5:
        r6 = r20;
        goto L7
    }

    public /* synthetic */ TaskConfig(boolean r17, Context r18, ProcessMatchMode r19, ThreadPoolExecutor r20, ThreadFactory r21, int r22, boolean r23, String r24, int r25, boolean r26, long r27, IdleTaskConfig r29, DefaultConstructorMarker r30) {
        this(r17, (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin"), r19, r20, (ThreadFactory) ZeusTransformUtils.wrapperContextForParams(r21, ThreadFactory.class, "com.obric.memorydata.plugin"), r22, r23, r24, r25, r26, r27, r29);
    }

    private final ThreadPoolExecutor getDefaultExecutor() {
        int r2 = this.coreThreadNum;
        return new ThreadPoolExecutor(r2, r2, 0, TimeUnit.MILLISECONDS, (BlockingQueue) ZeusTransformUtils.preCheckCast(new LinkedBlockingQueue(), BlockingQueue.class, "com.obric.memorydata.plugin"), getThreadFactory());
    }

    private final ThreadFactory getDefaultThreadFactory() {
        return (ThreadFactory) ZeusTransformUtils.preCheckCast(new a(), ThreadFactory.class, "com.obric.memorydata.plugin");
    }

    private final ThreadFactory getThreadFactory() {
        ThreadFactory r0 = this.threadFactory;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return getDefaultThreadFactory();
    }

    public final long getApplicationStartTime() {
        return this.applicationStartTime;
    }

    public final Context getBase() {
        return this.base;
    }

    public final boolean getCatchException() {
        return this.catchException;
    }

    public final IdleTaskConfig getIdleTaskConfig() {
        return this.idleTaskConfig;
    }

    public final ProcessMatchMode getMode() {
        return this.mode;
    }

    public final String getProcessName() {
        return this.processName;
    }

    public final ThreadPoolExecutor getTaskExecutor() {
        ThreadPoolExecutor r0 = this.taskExecutor;
        if (r0 != null) goto L6;
        r0 = this.executor;
    L6:
        if (r0 == null) goto L9;
        return r0;
    L9:
        return getDefaultExecutor();
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public final boolean isMainProcess() {
        return this.isMainProcess;
    }

    public final void setTaskExecutor(ThreadPoolExecutor r1) {
        this.taskExecutor = r1;
    }
}
