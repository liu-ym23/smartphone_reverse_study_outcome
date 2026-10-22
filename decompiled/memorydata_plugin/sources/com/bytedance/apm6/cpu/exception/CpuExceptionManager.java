package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.normal.NormalCpuExceptionPolicy;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class CpuExceptionManager {
    private CpuExceptionConfig cpuConfig;
    private ApmCpuManager.ICpuExceptionListener exceptionListener;
    private ICpuExceptionPolicy exceptionPolicy;
    private ApmCpuManager.ICpuExceptionFilter filter;

    @Deprecated
    private boolean isForceOpen;
    private boolean isOpen;
    private long lastExceptionTimestamp;
    private boolean needFetchStack;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.exception.CpuExceptionManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class SingletonHolder {
        private static final CpuExceptionManager instance = null;

        static {
            instance = new CpuExceptionManager(null);
        }

        private SingletonHolder() {
        }

        static /* synthetic */ CpuExceptionManager access$100() {
            return instance;
        }
    }

    private CpuExceptionManager() {
        this.exceptionPolicy = new NormalCpuExceptionPolicy();
    }

    /* synthetic */ CpuExceptionManager(AnonymousClass1 r1) {
        this();
    }

    public static CpuExceptionManager getInstance() {
        return SingletonHolder.access$100();
    }

    @Deprecated
    public synchronized void forceOpen() {
        monitor-enter(this);
        this.isForceOpen = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void forceOpenNoStack() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.isOpen == true) goto L11;
        CpuExceptionConfig r0 = this.cpuConfig;     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        this.isOpen = true;     // Catch: Throwable -> L13
        this.needFetchStack = false;     // Catch: Throwable -> L13
        this.exceptionPolicy.startDetect(r0);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
    }

    public ApmCpuManager.ICpuExceptionFilter getExceptionFilter() {
        return this.filter;
    }

    public ApmCpuManager.ICpuExceptionListener getExceptionListener() {
        return this.exceptionListener;
    }

    public long getLastExceptionTimestamp() {
        return this.lastExceptionTimestamp;
    }

    public synchronized boolean needFetchStack() {
        monitor-enter(this);
        boolean r0 = this.needFetchStack;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void setCpuFilterListener(ApmCpuManager.ICpuExceptionFilter r3) {
        this.filter = (ApmCpuManager.ICpuExceptionFilter) ZeusTransformUtils.wrapperContextForParams(r3, ApmCpuManager.ICpuExceptionFilter.class, "com.obric.memorydata.plugin");
    }

    public void setExceptionListener(ApmCpuManager.ICpuExceptionListener r3) {
        this.exceptionListener = (ApmCpuManager.ICpuExceptionListener) ZeusTransformUtils.wrapperContextForParams(r3, ApmCpuManager.ICpuExceptionListener.class, "com.obric.memorydata.plugin");
    }

    public void setLastExceptionTimestamp(long r1) {
        this.lastExceptionTimestamp = r1;
    }

    public synchronized void stopForceOpenNoStack() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.isOpen == true) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.needFetchStack == true) goto L11;
        this.isOpen = false;     // Catch: Throwable -> L13
        this.exceptionPolicy.stopDetect();     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public synchronized void updateConfig(CpuExceptionConfig r3) {
        monitor-enter(this);
        if (r3 != null) goto L28;
        monitor-exit(this);
        return;
    L28:
    L25:
        th = move-exception;
        throw th;
    L7:
        if (ApmContext.isMainProcess() == false) goto L9;
    L12:
        this.cpuConfig = r3;     // Catch: Throwable -> L25
        if (this.isForceOpen == false) goto L20;
        if (this.isOpen == true) goto L17;
        this.isOpen = true;     // Catch: Throwable -> L25
        this.needFetchStack = r3.isCollectThreadStack();     // Catch: Throwable -> L25
        this.exceptionPolicy.startDetect(r3);     // Catch: Throwable -> L25
    L17:
        monitor-exit(this);
        return;
    L20:
        if (r3.isOpen() == false) goto L22;
        this.isOpen = true;     // Catch: Throwable -> L25
        this.needFetchStack = r3.isCollectThreadStack();     // Catch: Throwable -> L25
        this.exceptionPolicy.startDetect(r3);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L22:
        this.isOpen = false;     // Catch: Throwable -> L25
        this.exceptionPolicy.stopDetect();     // Catch: Throwable -> L25
        goto L23
    L9:
        if (r3.isCollectAllProcess() == true) goto L12;
        monitor-exit(this);
    }
}
