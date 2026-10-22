package com.bytedance.crash.runtime;

import android.annotation.SuppressLint;
import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.InnerAppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class CommonParams {

    @SuppressLint({"StaticFieldLeak"})
    private static CommonParams sCommonParams;

    public CommonParams() {
    }

    public static CommonParams getInstance() {
        if (sCommonParams != null) goto L6;
        sCommonParams = new CommonParams();
    L6:
        return sCommonParams;
    }

    public static void setMPParams(Map<String, Object> r10) {
        AppMonitor r11 = MonitorManager.getAppMonitor();
        if (r11 == null) goto L6;
        r11.setMPParams(r10);
        return;
    }

    public ICommonParams getCommonParams() {
        AppMonitor r10 = MonitorManager.getAppMonitor();
        if ((r10 instanceof InnerAppMonitor) == true) goto L5;
        return null;
    L5:
        return ((InnerAppMonitor) r10).getICommonParams();
    }

    public Map<String, Object> getParamsMap() {
        HashMap r10 = new HashMap();
        AppMonitor r11 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L7
        if (r11 == null) goto L6;
        r10.put("aid", Integer.decode(r11.getAppId()));     // Catch: Throwable -> L7
        r10.put("channel", r11.getChannel());     // Catch: Throwable -> L7
        r10.put("app_version", r11.getVersion().getVersionName());     // Catch: Throwable -> L7
        r10.put("update_version_code", Long.valueOf(r11.getVersion().getVersionCode()));     // Catch: Throwable -> L7
    L6:
        return r10;
    }

    public long getUserId() {
        AppMonitor r10 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L8
        if (r10 == null) goto L6;
        return r10.getUserId();
    L6:
        return 0;
    L11:
        return 0;
    }
}
