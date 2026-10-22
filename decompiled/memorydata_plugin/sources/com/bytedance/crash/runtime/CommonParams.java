package com.bytedance.crash.runtime;

import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.InnerAppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class CommonParams {
    private static CommonParams sCommonParams;

    public CommonParams() {
    }

    public static CommonParams getInstance() {
        if (sCommonParams != null) goto L6;
        sCommonParams = new CommonParams();
    L6:
        return sCommonParams;
    }

    public static void setMPParams(Map<String, Object> r2) {
        Map<String, Object> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        AppMonitor r0 = MonitorManager.getAppMonitor();
        if (r0 == null) goto L6;
        r0.setMPParams(r3);
        return;
    }

    public ICommonParams getCommonParams() {
        AppMonitor r2 = MonitorManager.getAppMonitor();
        if (ZeusTransformUtils.instanceOf(r2, InnerAppMonitor.class) == true) goto L5;
        return null;
    L5:
        return ((InnerAppMonitor) ZeusTransformUtils.preCheckCast(r2, InnerAppMonitor.class, "com.obric.memorydata.plugin")).getICommonParams();
    }

    public Map<String, Object> getParamsMap() {
        HashMap r4 = new HashMap();
        AppMonitor r0 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        r4.put("aid", Integer.decode(r0.getAppId()));     // Catch: Throwable -> L7
        r4.put("channel", r0.getChannel());     // Catch: Throwable -> L7
        r4.put("app_version", r0.getVersion().getVersionName());     // Catch: Throwable -> L7
        r4.put("update_version_code", Long.valueOf(r0.getVersion().getVersionCode()));     // Catch: Throwable -> L7
    L6:
        return r4;
    }

    public long getUserId() {
        AppMonitor r2 = MonitorManager.getAppMonitor();     // Catch: Throwable -> L8
        if (r2 == null) goto L6;
        return r2.getUserId();
    L6:
        return 0;
    L11:
        return 0;
    }
}
