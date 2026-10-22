package com.bytedance.crash.resource.heaptrack;

import com.bytedance.crash.config.RuntimeConfig;
import com.bytedance.crash.resource.ResourceMonitorConfig;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class NativeHeapTrackerConfig extends ResourceMonitorConfig {
    protected int mBtFlag;
    protected int mBtSize;
    protected int mCollectSizeMB;
    boolean mDebug;
    protected int mMonitorSize;
    protected int mMonitorType;
    protected boolean mNeedDumpMemInfo;
    protected int mPollSeconds;
    protected int mWaterLineMB;

    public NativeHeapTrackerConfig(JSONArray r7) {
        super(21, 33, 1);
        this.mBtFlag = 3;
        this.mBtSize = 500;
        this.mDebug = false;
        if (RuntimeConfig.isLocalTest() == false) goto L5;
        this.mMonitorType = 0;
        this.mWaterLineMB = 30;
        this.mCollectSizeMB = 300;
        this.mPollSeconds = 1;
        this.mNeedDumpMemInfo = false;
        this.mMonitorSize = 2;
        this.mDebug = true;
        this.mBtSize = 4;
        this.mBtFlag = 3;
        return;
    L5:
        this.mPollSeconds = r7.optInt(0);
        this.mWaterLineMB = r7.optInt(1);
        this.mCollectSizeMB = r7.optInt(2);
        this.mNeedDumpMemInfo = r7.optBoolean(3);
        this.mMonitorSize = r7.optInt(5);
        this.mMonitorType = r7.optInt(6);
        if (r7.length() < 9) goto L8;
        this.mBtFlag = r7.optInt(7);
        this.mBtSize = r7.optInt(8);
    L8:
        this.mPollSeconds = Math.max(4, this.mPollSeconds);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorConfig
    public String toString() {
        return "pollSecond=" + this.mPollSeconds + "\nwaterLineMB=" + this.mWaterLineMB + "\ncollectSizeMB=" + this.mCollectSizeMB + "\nneedDumpMemInfo=" + this.mNeedDumpMemInfo + "\ndebug=" + this.mDebug + "\nmonitorSize=" + this.mMonitorSize + "\nmonitorType=" + this.mMonitorType + "\nbtFlag=" + this.mBtFlag + "\nbtSize=" + this.mBtSize + "\n";
    }
}
