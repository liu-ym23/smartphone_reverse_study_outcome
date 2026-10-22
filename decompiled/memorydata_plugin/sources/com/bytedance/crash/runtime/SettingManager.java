package com.bytedance.crash.runtime;

import android.text.TextUtils;
import com.bytedance.crash.monitor.MonitorManager;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingManager {
    public static final int AID_DEFAULT = 4444;
    private final int mAid;
    private String mDid;

    public SettingManager() {
        this.mAid = -1;
    }

    public int getAid() {
        return Integer.parseInt(MonitorManager.getAppMonitorAid());
    L4:
        return AID_DEFAULT;
    }

    public String getDeviceId() {
        if (TextUtils.isEmpty(this.mDid) == false) goto L6;
        this.mDid = "0";
    L6:
        return this.mDid;
    }

    public boolean isDidSet() {
        if (TextUtils.isEmpty(this.mDid) == false) goto L5;
    L7:
        return false;
    L5:
        if ("0".equals(this.mDid) == true) goto L7;
        return true;
    }

    public void setDeviceId(String r1) {
        this.mDid = r1;
    }
}
