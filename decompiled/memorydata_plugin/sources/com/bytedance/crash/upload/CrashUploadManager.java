package com.bytedance.crash.upload;

import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.NpthLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class CrashUploadManager {
    private static volatile CrashUploadManager sInstance;

    public CrashUploadManager() {
    }

    public static CrashUploadManager getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new CrashUploadManager();
    L6:
        return sInstance;
    }

    public boolean uploadAlogFile(String r10, String r11, String r12, List<String> r13) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        AppMonitor r14 = MonitorManager.getAppMonitor();
        if (r14 != null) goto L5;
        return false;
    L5:
        NpthLog.i("npth", "real upload alog " + r12 + ": " + r9);
        return CrashUploader.uploadAlogFiles(UploaderUrl.appendAlogUrlParams(NetConfig.getAlogUploadUrl(), Integer.parseInt(r10), r11, r14.getVersionName(), r14.getUpdateVersionCode()), Integer.parseInt(r10), r11, r12, r9);
    L8:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
