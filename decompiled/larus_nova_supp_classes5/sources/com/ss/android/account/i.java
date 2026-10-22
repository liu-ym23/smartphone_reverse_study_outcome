package com.ss.android.account;

import com.bytedance.sdk.account.platform.api.IAuthorizeMonitorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i implements IAuthorizeMonitorService {
    public i() {
    }

    public final void onEvent(String r1, JSONObject r2) {
        com.bytedance.sdk.account.monitor.a.a(r1, r2);
    }
}
