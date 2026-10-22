package com.lynx.jsbridge;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxLogService;
import i8a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxSetModule extends LynxContextModule {
    public static final String NAME = "LynxSetModule";

    @LynxMethod
    public boolean getEnableLayoutOnly() {
        return LynxEnv.inst().isLayoutOnlyEnabled();
    }

    @LynxMethod
    public boolean getEnableVsyncAlignedFlush() {
        return LynxEnv.inst().getVsyncAlignedFlushGlobalSwitch();
    }

    @LynxMethod
    public boolean getIsCreateViewAsync() {
        return LynxEnv.inst().getCreateViewAsync();
    }

    @LynxMethod
    public boolean getLogToSystemStatus() {
        ILynxLogService r0 = (ILynxLogService) n.c().a(ILynxLogService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.getLogToSystemStatus();
    }

    public LynxSetModule(LynxContext r1) {
        super(r1);
    }

    @LynxMethod
    public void switchEnableLayoutOnly(Boolean r2) {
        LynxEnv.inst().enableLayoutOnly(r2.booleanValue());
    }

    @LynxMethod
    public void switchEnableVsyncAlignedFlush(Boolean r2) {
        LynxEnv.inst().setVsyncAlignedFlushGlobalSwitch(r2.booleanValue());
    }

    @LynxMethod
    public void switchIsCreateViewAsync(Boolean r2) {
        LynxEnv.inst().setCreateViewAsync(r2.booleanValue());
    }

    @LynxMethod
    public void switchKeyBoardDetect(boolean r1) {
        if (r1 == false) goto L5;
        this.mLynxContext.getLynxView().getKeyboardEvent().d();
        return;
    }

    @LynxMethod
    public void switchLogToSystem(boolean r3) {
        ILynxLogService r0 = (ILynxLogService) n.c().a(ILynxLogService.class);
        if (r0 == null) goto L6;
        r0.switchLogToSystem(r3);
        return;
    }
}
