package com.bytedance.crash.resource.refmonitor;

import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class RefMonitorConfig extends ResourceMonitorConfig {
    private final int GLOBAL_LIMIT_MIN;
    private final int LOCAL_LIMIT_MIN;
    protected int mBtFlag;
    protected int mDebugType;
    protected int mGlobalLimit;
    protected int mLocalLimit;
    protected int mMonitorType;
    protected int mWeakGlobalLimit;

    public RefMonitorConfig(int r10, JSONArray r11, int r12) {
        super(23, 33, 5);
        this.mMonitorType = 0;
        this.mBtFlag = 0;
        this.mDebugType = 0;
        this.mGlobalLimit = 50000;
        this.mWeakGlobalLimit = 50000;
        this.mLocalLimit = 500;
        this.GLOBAL_LIMIT_MIN = 1000;
        this.LOCAL_LIMIT_MIN = 500;
        if (RuntimeConfig.isLocalTest() == false) goto L5;
        this.mMonitorType = 7;
        this.mBtFlag = 3;
        this.mGlobalLimit = 1000;
        this.mWeakGlobalLimit = 1000;
        this.mLocalLimit = 350;
        this.mDebugType = 4;
        return;
    L5:
        this.mMonitorType = r10;
        this.mBtFlag = r12;
        int r13 = r11.length();
        if (r13 < 2) goto L10;
        this.mGlobalLimit = r11.optInt(0);
        this.mWeakGlobalLimit = r11.optInt(1);
        if (r13 != 3) goto L10;
        this.mLocalLimit = r11.optInt(2);
    L10:
        this.mGlobalLimit = Math.max(1000, this.mGlobalLimit);
        this.mWeakGlobalLimit = Math.max(1000, this.mWeakGlobalLimit);
        this.mLocalLimit = Math.max(500, this.mLocalLimit);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return "monitorType=" + this.mMonitorType + "\nlimitGlobal=" + this.mGlobalLimit + "\nlimitWeak=" + this.mWeakGlobalLimit + "\nlimitLocal=" + this.mLocalLimit + "\nbtFlag=" + this.mBtFlag + "\ndebugType=" + this.mDebugType + "\n";
    }
}
