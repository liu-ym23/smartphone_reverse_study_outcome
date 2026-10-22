package com.bytedance.apm6.cpu.exception;

import android.content.Context;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.watson.assist.a.b;
import com.bytedance.watson.assist.a.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class CpuExceptionStateMachine {
    private c assistStat;
    private CpuExceptionConfig config;
    private ICpuExceptionState coolDownState;
    private ICpuExceptionState currentState;
    private ICpuExceptionState idleState;
    private boolean isBackground;
    private boolean isInit;
    private boolean isStart;
    private ActivityLifecycleService lifecycleService;
    private ICpuExceptionState processDetectState;
    private ICpuExceptionState processDoubleDetectState;
    private ICpuExceptionState threadDetectState;

    public CpuExceptionStateMachine(ActivityLifecycleService r3) {
        ActivityLifecycleService r4 = (ActivityLifecycleService) ZeusTransformUtils.wrapperContextForParams(r3, ActivityLifecycleService.class, "com.obric.memorydata.plugin");
        this.isStart = false;
        this.isInit = false;
        this.lifecycleService = r4;
    }

    private void changeState(ICpuExceptionState r3) {
        ICpuExceptionState r4 = (ICpuExceptionState) ZeusTransformUtils.wrapperContextForParams(r3, ICpuExceptionState.class, "com.obric.memorydata.plugin");
        if (this.isStart == true) goto L5;
        return;
    L5:
        if (this.isInit == false) goto L17;
        this.currentState = r4;
        CpuExceptionConfig r0 = this.config;
        ActivityLifecycleService r1 = this.lifecycleService;
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        r4.onEnterThisState(r0, r2);
        logState();
        return;
    L10:
        if (r1.isForeground() == false) goto L13;
        r2 = false;
        goto L14
    }

    private void logState() {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.i(Constants.TAG, "change cpu exception detect state: " + this.currentState);
        return;
    }

    public c getAssistStat() {
        return this.assistStat;
    }

    public void init(ICpuExceptionState r3, ICpuExceptionState r4, ICpuExceptionState r5, ICpuExceptionState r6, ICpuExceptionState r7) {
        ICpuExceptionState r8 = (ICpuExceptionState) ZeusTransformUtils.wrapperContextForParams(r3, ICpuExceptionState.class, "com.obric.memorydata.plugin");
        ICpuExceptionState r9 = (ICpuExceptionState) ZeusTransformUtils.wrapperContextForParams(r4, ICpuExceptionState.class, "com.obric.memorydata.plugin");
        ICpuExceptionState r10 = (ICpuExceptionState) ZeusTransformUtils.wrapperContextForParams(r5, ICpuExceptionState.class, "com.obric.memorydata.plugin");
        ICpuExceptionState r11 = (ICpuExceptionState) ZeusTransformUtils.wrapperContextForParams(r6, ICpuExceptionState.class, "com.obric.memorydata.plugin");
        ICpuExceptionState r12 = (ICpuExceptionState) ZeusTransformUtils.wrapperContextForParams(r7, ICpuExceptionState.class, "com.obric.memorydata.plugin");
        if (this.isInit == false) goto L5;
        return;
    L5:
        this.processDetectState = r8;
        this.processDoubleDetectState = r9;
        this.threadDetectState = r10;
        this.coolDownState = r11;
        this.idleState = r12;
        this.assistStat = b.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L9
    L7:
        this.isInit = true;
    }

    public synchronized void onCoolDown() {
        monitor-enter(this);
        changeState(this.coolDownState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onIdle() {
        monitor-enter(this);
        changeState(this.idleState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onLifeCycleChange(boolean r3) {
        monitor-enter(this);
        ICpuExceptionState r0 = this.currentState;     // Catch: Throwable -> L17
        if (r0 != null) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L15;
        if (this.isBackground != r3) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.isBackground = r3;     // Catch: Throwable -> L17
        r0.onLifeCycleChange(r3);     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    public synchronized void onProcessDetect() {
        monitor-enter(this);
        changeState(this.processDetectState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onProcessDoubleDetect() {
        monitor-enter(this);
        changeState(this.processDoubleDetectState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onThreadDetect() {
        monitor-enter(this);
        changeState(this.threadDetectState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void start(CpuExceptionConfig r2) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.isInit == false) goto L15;
        this.config = r2;     // Catch: Throwable -> L17
        boolean r3 = true;
        this.isStart = true;     // Catch: Throwable -> L17
        CpuExceptionJudgeHelper.initScene(ApmCpuManager.getInstance().getCpuSceneString());     // Catch: Throwable -> L17
        if (this.lifecycleService.isForeground() == false) goto L12;
        r3 = false;
    L12:
        this.isBackground = r3;     // Catch: Throwable -> L17
        onProcessDetect();     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public synchronized void stop() {
        monitor-enter(this);
        ICpuExceptionState r0 = this.currentState;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L11;
        r0.onStopDetect();     // Catch: Throwable -> L13
        this.isStart = false;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
