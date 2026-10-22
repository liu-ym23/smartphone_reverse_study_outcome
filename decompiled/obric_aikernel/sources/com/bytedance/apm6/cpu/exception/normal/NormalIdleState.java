package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes.dex */
public class NormalIdleState extends BaseCpuExceptionState {
    public NormalIdleState(CpuExceptionStateMachine r10) {
        super(r10);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r10, boolean r11) {
        super.onEnterThisState(r10, r11);
        this.machine.onProcessDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        super.onLifeCycleChange(r10);
        cpuExceptionLog("life cycle change when state is idle, lifecycle change to back?: " + r10);
        this.machine.onProcessDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.IDLE;
    }
}
