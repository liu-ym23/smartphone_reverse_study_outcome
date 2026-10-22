package com.bytedance.lego.init.config;

import android.content.Context;
import com.bytedance.lego.init.IdleTaskConfig;
import com.bytedance.lego.init.util.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001<By\b\u0002\u0012\u0006\u0010'\u001a\u00020\u000f\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010&\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u00103\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u00106\u001a\u00020\u000f¢\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0015\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0019\u0010\"\u001a\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010&\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b&\u0010\u0013R\u0019\u0010'\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010\u0011\u001a\u0004\b'\u0010\u0013R\u0019\u0010)\u001a\u00020(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010.\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010\u001cR\u0019\u00103\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u00105R\"\u00106\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u0011\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig;", "", "Ljava/util/concurrent/ThreadPoolExecutor;", "getDefaultExecutor", "Ljava/util/concurrent/ThreadFactory;", "getThreadFactory", "getDefaultThreadFactory", "", "applicationStartTime", "J", "getApplicationStartTime", "()J", "", "coreThreadNum", "I", "", "catchException", "Z", "getCatchException", "()Z", "", "processName", "Ljava/lang/String;", "getProcessName", "()Ljava/lang/String;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "taskExecutor", "Ljava/util/concurrent/ThreadPoolExecutor;", "getTaskExecutor", "()Ljava/util/concurrent/ThreadPoolExecutor;", "setTaskExecutor", "(Ljava/util/concurrent/ThreadPoolExecutor;)V", "Lcom/bytedance/lego/init/IdleTaskConfig;", "idleTaskConfig", "Lcom/bytedance/lego/init/IdleTaskConfig;", "getIdleTaskConfig", "()Lcom/bytedance/lego/init/IdleTaskConfig;", "isMainProcess", "isDebug", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "mode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "getMode", "()Lcom/bytedance/lego/init/config/ProcessMatchMode;", "Landroid/content/Context;", "base", "Landroid/content/Context;", "getBase", "()Landroid/content/Context;", "executor", "timeout", "getTimeout", "()I", "agreePrivacyPopupWindow", "getAgreePrivacyPopupWindow", "setAgreePrivacyPopupWindow", "(Z)V", "<init>", "(ZLandroid/content/Context;Lcom/bytedance/lego/init/config/ProcessMatchMode;Ljava/util/concurrent/ThreadPoolExecutor;Ljava/util/concurrent/ThreadFactory;IZLjava/lang/String;IZJLcom/bytedance/lego/init/IdleTaskConfig;Z)V", "Builder", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class TaskConfig {
    private boolean agreePrivacyPopupWindow;
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b.\u0010/J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u001bR\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010$R\u0016\u0010%\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010&R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010,R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001d¨\u00060"}, d2 = {"Lcom/bytedance/lego/init/config/TaskConfig$Builder;", "", "", "isDebug", "Ljava/util/concurrent/ThreadPoolExecutor;", "executor", "setExecutorService", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "mode", "setProcessMatchMode", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "setThreadFactory", "", "coreThreadNum", "setCoreThreadNum", "millis", "setTimeOut", "enable", "enableCatchException", "Lcom/bytedance/lego/init/IdleTaskConfig;", "idleTaskConfig", "setIdleTaskConfig", "", "applicationStartTime", "setApplicationStartTime", "agreePrivacyPopupWindow", "Lcom/bytedance/lego/init/config/TaskConfig;", "build", "Z", "Ljava/util/concurrent/ThreadPoolExecutor;", "I", "isMainProcess", "", "processName", "Ljava/lang/String;", "Ljava/util/concurrent/ThreadFactory;", "timeout", "J", "processMatchMode", "Lcom/bytedance/lego/init/config/ProcessMatchMode;", "Landroid/content/Context;", "base", "Landroid/content/Context;", "Lcom/bytedance/lego/init/IdleTaskConfig;", "catchException", "<init>", "(Landroid/content/Context;ZLjava/lang/String;)V", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private boolean agreePrivacyPopupWindow;
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

        public Builder(Context r10, boolean r11, String r12) {
            Intrinsics.checkParameterIsNotNull(r10, "base");
            Intrinsics.checkParameterIsNotNull(r12, "processName");
            this.base = r10;
            this.isMainProcess = r11;
            this.processName = r12;
            this.processMatchMode = ProcessMatchMode.CONTAIN;
            this.coreThreadNum = Runtime.getRuntime().availableProcessors();
            this.timeout = 8000;
            this.idleTaskConfig = IdleTaskConfig.Companion.a();
            this.applicationStartTime = System.currentTimeMillis();
            this.agreePrivacyPopupWindow = true;
        }

        public final Builder agreePrivacyPopupWindow(boolean r10) {
            this.agreePrivacyPopupWindow = r10;
            return this;
        }

        public final TaskConfig build() {
            boolean r10 = this.isDebug;
            Context r11 = this.base;
            ThreadPoolExecutor r12 = this.executor;
            ProcessMatchMode r13 = this.processMatchMode;
            int r14 = this.coreThreadNum;
            return new TaskConfig(r10, r11, r13, r12, this.threadFactory, r14, this.isMainProcess, this.processName, this.timeout, this.catchException, this.applicationStartTime, this.idleTaskConfig, this.agreePrivacyPopupWindow, null);
        }

        public final Builder enableCatchException(boolean r10) {
            this.catchException = r10;
            return this;
        }

        public final Builder isDebug(boolean r10) {
            this.isDebug = r10;
            return this;
        }

        public final Builder setApplicationStartTime(long r10) {
            this.applicationStartTime = r10;
            return this;
        }

        public final Builder setCoreThreadNum(int r10) {
            this.coreThreadNum = r10;
            return this;
        }

        public final Builder setExecutorService(ThreadPoolExecutor r10) {
            Intrinsics.checkParameterIsNotNull(r10, "executor");
            this.executor = r10;
            return this;
        }

        public final Builder setIdleTaskConfig(IdleTaskConfig r10) {
            Intrinsics.checkParameterIsNotNull(r10, "idleTaskConfig");
            this.idleTaskConfig = r10;
            return this;
        }

        public final Builder setProcessMatchMode(ProcessMatchMode r10) {
            Intrinsics.checkParameterIsNotNull(r10, "mode");
            this.processMatchMode = r10;
            return this;
        }

        public final Builder setThreadFactory(ThreadFactory r10) {
            Intrinsics.checkParameterIsNotNull(r10, "threadFactory");
            this.threadFactory = r10;
            return this;
        }

        public final Builder setTimeOut(int r10) {
            if (r10 >= 3000) goto L5;
            c.d(c.f2121a, null, "TaskConfig.timeout must not be less than 3*1000", 1, null);
            this.timeout = 3000;
        L6:
            return this;
        L5:
            this.timeout = r10;
            goto L6
        }
    }

    public static final class a implements ThreadFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AtomicInteger f2083c;

        a() {
            this.f2083c = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r10) {
            Intrinsics.checkParameterIsNotNull(r10, "r");
            return new Thread(r10, "AA InitThread#" + this.f2083c.getAndIncrement());
        }
    }

    private TaskConfig(boolean r10, Context r11, ProcessMatchMode r12, ThreadPoolExecutor r13, ThreadFactory r14, int r15, boolean r16, String r17, int r18, boolean r19, long r110, IdleTaskConfig r111, boolean r112) {
        this.isDebug = r10;
        this.base = r11;
        this.mode = r12;
        this.executor = r13;
        this.threadFactory = r14;
        this.coreThreadNum = r15;
        this.isMainProcess = r16;
        this.processName = r17;
        this.timeout = r18;
        this.catchException = r19;
        this.applicationStartTime = r110;
        this.idleTaskConfig = r111;
        this.agreePrivacyPopupWindow = r112;
    }

    /* synthetic */ TaskConfig(boolean r18, Context r19, ProcessMatchMode r20, ThreadPoolExecutor r21, ThreadFactory r22, int r23, boolean r24, String r25, int r26, boolean r27, long r28, IdleTaskConfig r30, boolean r31, int r32, DefaultConstructorMarker r33) {
        if ((r32 & 8) == 0) goto L5;
        ThreadPoolExecutor r10 = null;
    L7:
        if ((r32 & 16) == 0) goto L9;
        ThreadFactory r11 = null;
    L10:
        this(r18, r19, r20, r10, r11, r23, r24, r25, r26, r27, r28, r30, r31);
        return;
    L9:
        r11 = r22;
        goto L10
    L5:
        r10 = r21;
        goto L7
    }

    public /* synthetic */ TaskConfig(boolean r10, Context r11, ProcessMatchMode r12, ThreadPoolExecutor r13, ThreadFactory r14, int r15, boolean r16, String r17, int r18, boolean r19, long r110, IdleTaskConfig r111, boolean r112, DefaultConstructorMarker r113) {
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112);
    }

    private final ThreadPoolExecutor getDefaultExecutor() {
        int r10 = this.coreThreadNum;
        return new ThreadPoolExecutor(r10, r10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), getThreadFactory());
    }

    private final ThreadFactory getDefaultThreadFactory() {
        return new a();
    }

    private final ThreadFactory getThreadFactory() {
        ThreadFactory r10 = this.threadFactory;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return getDefaultThreadFactory();
    }

    public final boolean getAgreePrivacyPopupWindow() {
        return this.agreePrivacyPopupWindow;
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
        ThreadPoolExecutor r10 = this.taskExecutor;
        if (r10 != null) goto L6;
        r10 = this.executor;
    L6:
        if (r10 == null) goto L9;
        return r10;
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

    public final void setAgreePrivacyPopupWindow(boolean r10) {
        this.agreePrivacyPopupWindow = r10;
    }

    public final void setTaskExecutor(ThreadPoolExecutor r10) {
        this.taskExecutor = r10;
    }
}
