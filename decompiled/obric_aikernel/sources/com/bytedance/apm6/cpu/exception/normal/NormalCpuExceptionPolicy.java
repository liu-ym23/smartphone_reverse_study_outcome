package com.bytedance.apm6.cpu.exception.normal;

import android.app.Activity;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy;
import com.bytedance.apm6.cpu.exception.ICpuExceptionState;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;

/* JADX INFO: loaded from: classes.dex */
public class NormalCpuExceptionPolicy extends DummyLifecycleListener implements ICpuExceptionPolicy {
    private ICpuExceptionState coolDownState;
    private ICpuExceptionState idleState;
    private ActivityLifecycleService lifecycleService;
    private ICpuExceptionState processDetectState;
    private ICpuExceptionState processDoubleDetectState;
    private volatile CpuExceptionStateMachine stateMachine;
    private ICpuExceptionState threadDetectState;

    public NormalCpuExceptionPolicy() {
        ActivityLifecycleService r10 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);
        this.lifecycleService = r10;
        this.stateMachine = new CpuExceptionStateMachine(r10);
        this.processDetectState = new NormalProcessDetectState(this.stateMachine);
        this.processDoubleDetectState = new NormalProcessDoubleDetectState(this.stateMachine);
        this.threadDetectState = new NormalThreadDetectState(this.stateMachine);
        this.coolDownState = new NormalCoolDownState(this.stateMachine);
        this.idleState = new NormalIdleState(this.stateMachine);
        this.stateMachine.init(this.processDetectState, this.processDoubleDetectState, this.threadDetectState, this.coolDownState, this.idleState);
        this.lifecycleService.register(this);
    }

    @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onBackground(Activity r10) {
        this.stateMachine.onLifeCycleChange(true);
    }

    @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
    public void onFront(Activity r10) {
        this.stateMachine.onLifeCycleChange(false);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy
    public void startDetect(CpuExceptionConfig r10) {
        this.stateMachine.start(r10);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionPolicy
    public void stopDetect() {
        this.stateMachine.stop();
    }
}
