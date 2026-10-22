package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* JADX INFO: loaded from: classes.dex */
class NormalCoolDownState extends BaseCpuExceptionState {
    private static final long COOL_DOWN_INTERVAL = 120000;
    private static final long COOL_DOWN_INTERVAL_BACKGROUND = 1200000;
    private AsyncTask finishCoolDownTask;
    private volatile boolean isBackground;

    public NormalCoolDownState(final CpuExceptionStateMachine r10) {
        super(r10);
        this.isBackground = false;
        final long r11 = getInterval();
        final long r12 = 0;
        this.finishCoolDownTask = new AnonymousClass1(this, r11, r12, r10);
    }

    static /* synthetic */ boolean access$000(NormalCoolDownState r10) {
        return r10.isBackground;
    }

    static /* synthetic */ void access$100(NormalCoolDownState r10, String r11) {
        r10.cpuExceptionLog(r11);
    }

    private long getInterval() {
        if (this.isBackground == false) goto L5;
        return COOL_DOWN_INTERVAL_BACKGROUND;
    L5:
        return 120000;
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r10, boolean r11) {
        super.onEnterThisState(r10, r11);
        AsyncTask r12 = this.finishCoolDownTask;
        if (r12 == null) goto L5;
        r12.refresh(getInterval(), 0);
    L5:
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.finishCoolDownTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        super.onLifeCycleChange(r10);
        this.isBackground = r10;
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.finishCoolDownTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.COOL_DOWN;
    }
}
