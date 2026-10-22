package com.bytedance.apm6.commonevent.model;

import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.BatchLogWrapUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TracingData implements Monitorable {
    private JSONArray array;

    public TracingData(JSONArray r10) {
        this.array = r10;
    }

    public TracingData(JSONObject r10) {
        JSONArray r11 = new JSONArray();
        r11.put(r10);
        this.array = r11;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "tracing";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return true;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public final JSONObject toJsonObject() {
        return BatchLogWrapUtils.wrapData(getLogType(), this.array);
    }
}
