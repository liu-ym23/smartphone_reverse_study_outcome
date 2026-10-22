package com.ss.android.bytedcert.adapter.monitor;

import com.ss.android.cert.manager.ablity.ICertMonitorConfig;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.lib.AppLogNewUtils;
import jta.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class CertMonitorAdapter implements ICertMonitorConfig {
    public CertMonitorAdapter() {
    }

    @Override // com.ss.android.cert.manager.ablity.ICertMonitorConfig
    public int getAppId() {
        boolean r0 = AppLog.L;
        return g.c();
    }

    @Override // com.ss.android.cert.manager.ablity.ICertMonitorConfig
    public void onEvent(String r1, JSONObject r2) {
        AppLogNewUtils.onEventV3(r1, r2);
    }
}
