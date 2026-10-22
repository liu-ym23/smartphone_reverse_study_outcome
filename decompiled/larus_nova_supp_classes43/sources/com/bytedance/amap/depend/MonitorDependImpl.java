package com.bytedance.amap.depend;

import android.text.TextUtils;
import com.bytedance.map.api.MapGlobalConfig;
import com.bytedance.map.api.monitor.IMonitorDepend;
import com.ss.android.common.applog.AppLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class MonitorDependImpl implements IMonitorDepend {
    private static final String OVERSEA_DEFAULT_APP_ID = "1128";
    private static final String OVERSEA_DEFAULT_CONFIG_URL = "https://mon.snssdk.com/monitor/appmonitor/v2/settings";
    private static final String OVERSEA_DEFAULT_REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private static volatile MonitorDependImpl sInstance;

    public MonitorDependImpl() {
    }

    public Map<String, String> getCommonParams() {
        return null;
    }

    public String getSessionId() {
        return null;
    }

    public static MonitorDependImpl getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(MonitorDependImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new MonitorDependImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MonitorDependImpl.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public List<String> getConfigUrls() {
        ArrayList r0 = new ArrayList();
        r0.add(OVERSEA_DEFAULT_CONFIG_URL);
        return r0;
    }

    public List<String> getReportUrls() {
        ArrayList r0 = new ArrayList();
        r0.add(OVERSEA_DEFAULT_REPORT_URL);
        return r0;
    }

    public String getAppId() {
        if (TextUtils.isEmpty(MapGlobalConfig.getAppId()) == false) goto L5;
        return OVERSEA_DEFAULT_APP_ID;
    L5:
        return MapGlobalConfig.getAppId();
    }

    public String getAppVersion() {
        return MapGlobalConfig.getAppVersion();
    }

    public String getChannel() {
        return MapGlobalConfig.getChannel();
    }

    public String getDeviceId() {
        if (TextUtils.isEmpty(MapGlobalConfig.getDeviceId()) == true) goto L7;
        return MapGlobalConfig.getDeviceId();
    L7:
        return AppLog.v();
    }

    public String getPackageName() {
        return MapGlobalConfig.getPackageName();
    }

    public String getUpdateVersion() {
        return MapGlobalConfig.getUpdateVersion();
    }
}
