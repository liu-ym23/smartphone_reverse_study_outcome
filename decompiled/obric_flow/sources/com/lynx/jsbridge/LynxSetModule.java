package com.lynx.jsbridge;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxLogService;

/* JADX INFO: loaded from: classes2.dex */
public class LynxSetModule extends LynxContextModule {
    public static final String NAME = "LynxSetModule";

    public LynxSetModule(LynxContext r5) {
        super(r5);
    }

    @n
    public boolean getEnableLayoutOnly() {
        return LynxEnv.inst().isLayoutOnlyEnabled();
    }

    @n
    public boolean getEnableVsyncAlignedFlush() {
        return LynxEnv.inst().getVsyncAlignedFlushGlobalSwitch();
    }

    @n
    public boolean getIsCreateViewAsync() {
        return LynxEnv.inst().getCreateViewAsync();
    }

    @n
    public boolean getLogToSystemStatus() {
        ILynxLogService r5 = (ILynxLogService) ko.r.g().e(ILynxLogService.class);
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.getLogToSystemStatus();
    }

    @n
    public void switchEnableLayoutOnly(Boolean r5) {
        LynxEnv.inst().enableLayoutOnly(r5.booleanValue());
    }

    @n
    public void switchEnableVsyncAlignedFlush(Boolean r5) {
        LynxEnv.inst().setVsyncAlignedFlushGlobalSwitch(r5.booleanValue());
    }

    @n
    public void switchIsCreateViewAsync(Boolean r5) {
        LynxEnv.inst().setCreateViewAsync(r5.booleanValue());
    }

    @n
    public void switchKeyBoardDetect(boolean r5) {
        if (r5 == false) goto L5;
        this.mLynxContext.k().getKeyboardEvent().c();
        return;
    }

    @n
    public void switchLogToSystem(boolean r5) {
        ILynxLogService r10 = (ILynxLogService) ko.r.g().e(ILynxLogService.class);
        if (r10 == null) goto L6;
        r10.switchLogToSystem(r5);
        return;
    }
}
