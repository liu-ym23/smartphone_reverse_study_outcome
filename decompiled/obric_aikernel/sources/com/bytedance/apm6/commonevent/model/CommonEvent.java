package com.bytedance.apm6.commonevent.model;

import android.text.TextUtils;
import com.bytedance.apm6.commonevent.Constants;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.crash.entity.EventBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class CommonEvent implements Monitorable {
    public static final String LOG_TYPE = "service_monitor";
    private JSONObject category;
    private JSONObject extraJson;
    private JSONObject metric;
    private String serviceName;
    private int status;
    private JSONObject value;

    public CommonEvent(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        this.serviceName = r10;
        this.status = r11;
        this.value = r12;
        this.category = r13;
        this.metric = r14;
        this.extraJson = r15;
    }

    public void deepCopyJson() {
        this.value = JsonUtils.safeCopyJson(this.value);
        this.category = JsonUtils.safeCopyJson(this.category);
        this.metric = JsonUtils.safeCopyJson(this.metric);
        this.extraJson = JsonUtils.safeCopyJson(this.extraJson);
    }

    public JSONObject getCategory() {
        return this.category;
    }

    public JSONObject getExtraJson() {
        return this.extraJson;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return "service_monitor";
    }

    public JSONObject getMetric() {
        return this.metric;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getStatus() {
        return this.status;
    }

    public JSONObject getValue() {
        return this.value;
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return !TextUtils.isEmpty(this.serviceName);
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
        JSONObject r10 = getExtraJson();     // Catch: Exception -> L15
        if (r10 != null) goto L5;
        r10 = new JSONObject();     // Catch: Exception -> L15
    L5:
        r10.put("log_type", "service_monitor");     // Catch: Exception -> L15
        r10.put("service", getServiceName());     // Catch: Exception -> L15
        r10.put("status", getStatus());     // Catch: Exception -> L15
        if (getValue() == null) goto L9;
        r10.put(EventBody.KEY_VALUE, getValue());     // Catch: Exception -> L15
    L9:
        if (getCategory() == null) goto L12;
        r10.put(EventBody.KEY_CATEGORY, getCategory());     // Catch: Exception -> L15
    L12:
        if (getMetric() == null) goto L14;
        r10.put(EventBody.KEY_METRIC, getMetric());     // Catch: Exception -> L15
    L14:
        return r10;
    L15:
        e = move-exception;
        if (ApmBaseContext.isDebugMode() == false) goto L23;
        Logger.w(Constants.TAG, "toJsonObject Error.", e);
        return null;
    L23:
        return null;
    }

    public String toString() {
        return "CommonEvent{serviceName='" + this.serviceName + "'}";
    }
}
