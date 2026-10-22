package com.bytedance.apm6.cpu.exception.normal;

import androidx.work.WorkRequest;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes.dex */
class NormalProcessDetectState extends BaseProcessDetectState {
    private static final long DETECTED_BACKGROUND_INTERVAL = 600000;
    private static final long DETECTED_INTERVAL = 1000;

    public NormalProcessDetectState(CpuExceptionStateMachine r10) {
        super(r10);
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected long provideDetectInterval() {
        CpuExceptionConfig r10 = this.config;
        boolean r11 = this.isBackground;
        if (r10 != null) goto L8;
        if (r11 == true) goto L12;
        return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    L12:
        return DETECTED_BACKGROUND_INTERVAL;
    L8:
        if (r11 == false) goto L11;
        return DETECTED_BACKGROUND_INTERVAL;
    L11:
        return ((long) r10.getProcessDetectInterval()) * 1000;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.PROCESS_DETECT;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactAfterJudge(boolean r10) {
        if (r10 == false) goto L10;
        ApmCpuManager.ICpuExceptionFilter r11 = CpuExceptionManager.getInstance().getExceptionFilter();
        if (r11 != null) goto L6;
    L9:
        this.machine.onProcessDoubleDetect();
        goto L10
    L6:
        if (r11.needFilter() == false) goto L9;
        return false;
    L10:
        return r10;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactOnSkip() {
        return false;
    }
}
