package com.bytedance.crash.resource.fdtrack;

import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;

/* JADX INFO: loaded from: classes2.dex */
public class FdTrackConfig extends ResourceMonitorConfig {
    protected int mBacktraceLimit;
    protected boolean mDebug;
    protected int mDumpLine;
    protected boolean mFdTrackEnable;
    protected boolean mLoopMonitorEnable;
    protected long mSleepTime;
    protected int mWaterLine;

    public FdTrackConfig(boolean r5, boolean r6, int r7, int r8, long r9, int r11) {
        super(21, 35, 2);
        this.mFdTrackEnable = false;
        this.mLoopMonitorEnable = false;
        this.mDebug = false;
        this.mWaterLine = 500;
        this.mDumpLine = 1000;
        this.mBacktraceLimit = 10;
        this.mSleepTime = 60000;
        if (RuntimeConfig.isLocalTest() == false) goto L5;
        this.mFdTrackEnable = true;
        this.mLoopMonitorEnable = true;
        this.mWaterLine = 200;
        this.mDumpLine = 400;
        this.mSleepTime = 1000;
        this.mBacktraceLimit = 10;
        this.mDebug = true;
        return;
    L5:
        this.mFdTrackEnable = r5;
        this.mLoopMonitorEnable = r6;
        this.mWaterLine = r7;
        this.mDumpLine = r8;
        this.mSleepTime = Math.max(1000, r9);
        this.mBacktraceLimit = r11;
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return "fdTrackEnable=" + this.mFdTrackEnable + "\nwaterLine=" + this.mWaterLine + "\ndumpLine=" + this.mDumpLine + "\nloopMonitorEnable=" + this.mLoopMonitorEnable + "\nmSleepTime=" + this.mSleepTime + "\nmBacktraceLimit=" + this.mBacktraceLimit + "\ndebug=" + this.mDebug + "\n";
    }
}
