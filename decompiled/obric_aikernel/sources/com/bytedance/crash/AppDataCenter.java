package com.bytedance.crash;

import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.ListMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class AppDataCenter extends ListMap<CrashType, AttachUserData> {
    public AppDataCenter() {
    }

    public List<AttachUserData> getAttachUserData(CrashType r10) {
        if (MonitorManager.getAppMonitor() != null) goto L7;
        return null;
    L7:
        return MonitorManager.getAppMonitor().getUserDataCenter().getAttachUserData(r10);
    }
}
