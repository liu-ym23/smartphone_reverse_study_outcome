package com.bytedance.map.api.monitor;

import com.bytedance.map.api.utils.JsonUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MapMonitor {
    public static void a(Throwable r5) {
        JSONObject r10 = new JSONObject();
        JsonUtil.a(r10, "exception_msg", r5.getMessage());
        MapMonitorUtil.a("event_amap_exception", r10, null);
    }
}
