package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionJudgeHelper;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.CpuLoadCollector;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import g5.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProcessDetectState extends BaseCpuExceptionState {
    public CpuExceptionConfig config;
    private AsyncTask detectTask;
    protected boolean isBackground;

    public BaseProcessDetectState(CpuExceptionStateMachine r10) {
        super(r10);
    }

    static /* synthetic */ void access$000(BaseProcessDetectState r10) {
        r10.judgeCpuLoad();
    }

    private void judgeCpuLoad() {
        if (CpuExceptionJudgeHelper.isNeedSkipJudge() == true) goto L5;
        double r10 = CpuLoadCollector.collectSpeed();
        c r11 = this.machine.getAssistStat();
        if (r11 == null) goto L12;
        boolean r12 = r11.g((float) r10);
        if (r12 == true) goto L12;
    L13:
        cpuExceptionLog("run judge process cpu usage task, is over max threshold?: " + r12 + " speed: " + r10 + ", back max speed: " + this.config.getMaxProcessBackCpuSpeed() + ", fore max speed: " + this.config.getMaxProcessForeCpuSpeed());
        if (reactAfterJudge(r12) == false) goto L18;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
        return;
    L18:
        return;
    L12:
        r12 = CpuExceptionJudgeHelper.judge(this.config, r10, this.isBackground);
        goto L13
    L5:
        if (reactOnSkip() == false) goto L17;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
        return;
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r10, boolean r11) {
        super.onEnterThisState(r10, r11);
        this.config = r10;
        this.isBackground = r11;
        Logger.i(Constants.TAG, "enter : " + provideType() + " provideDetectInterval : " + provideDetectInterval() + " isBack : " + r11);
        AsyncTask r12 = this.detectTask;
        if (r12 != null) goto L5;
        final long r13 = provideDetectInterval();
        final long r14 = provideDetectInterval();
        this.detectTask = new AnonymousClass1(this, r13, r14);
    L6:
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.detectTask);
        return;
    L5:
        r12.refresh(provideDetectInterval(), provideDetectInterval());
        goto L6
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        super.onLifeCycleChange(r10);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
        this.machine.onIdle();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
    }

    protected abstract long provideDetectInterval();

    protected abstract boolean reactAfterJudge(boolean r10);

    protected abstract boolean reactOnSkip();
}
