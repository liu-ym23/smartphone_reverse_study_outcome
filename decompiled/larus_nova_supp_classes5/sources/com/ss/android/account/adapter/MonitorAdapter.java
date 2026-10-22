package com.ss.android.account.adapter;

import com.bytedance.sdk.account.utils.g;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.lib.AppLogNewUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class MonitorAdapter implements g {
    public MonitorAdapter() {
    }

    public final String getDeviceId() {
        return jta.g.d();
    }

    public final void a(long r2, String r4) {
        AppLog.g0.setUserId(r2);
        AppLog.g0.setSessionKey(r4);
    }

    public final void onEvent(String r1, JSONObject r2) {
        AppLogNewUtils.onEventV3(r1, r2);
    }
}
