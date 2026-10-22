package com.bytedance.apm6.perf.base.model;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class PerfBaseEvent implements Monitorable {
    protected static final String KEY_IS_FRONT = "is_front";
    protected static final String KEY_IS_MAIN_PROCESS = "is_main_process";
    protected static final String KEY_PROCESS_NAME = "process_name";
    protected final String KEY_EXTRA_STATUS;
    protected final String KEY_EXTRA_VALUES;
    protected final String KEY_FILTERS;
    protected final String KEY_LOG_TYPE;
    protected final String KEY_SCENE;
    protected final String KEY_SERVICE;
    private JSONObject logExtr;

    public PerfBaseEvent() {
        this.KEY_LOG_TYPE = "log_type";
        this.KEY_EXTRA_STATUS = "extra_status";
        this.KEY_EXTRA_VALUES = "extra_values";
        this.KEY_FILTERS = "filters";
        this.KEY_SERVICE = "service";
        this.KEY_SCENE = "scene";
    }

    protected JSONObject createRootJSONObject() {
        return new JSONObject();
    }

    protected JSONObject getExtraStatus() {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L4
        r10.put("scene", PerfFilterManager.getInstance().getSceneString());     // Catch: Throwable -> L4
        r10.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Throwable -> L4
        r10.put(KEY_IS_MAIN_PROCESS, ApmContext.isMainProcess());     // Catch: Throwable -> L4
        return r10;
    L4:
        return null;
    }

    protected abstract JSONObject getExtraValues();

    protected abstract JSONObject getFilters();

    @Override // com.bytedance.apm6.monitor.Monitorable
    public String getLogType() {
        return LogTypeName.MONITOR_LOG_TYPE_PERFORMANCE;
    }

    protected abstract String getServiceName();

    @Override // com.bytedance.apm6.monitor.Monitorable
    public JSONObject toJsonObject() {
    L16:
        return null;
    L3:
        if (this.logExtr != null) goto L5;
        this.logExtr = createRootJSONObject();     // Catch: JSONException -> L16
    L5:
        this.logExtr.put("log_type", LogTypeName.MONITOR_LOG_TYPE_PERFORMANCE);     // Catch: JSONException -> L16
        this.logExtr.put("service", getServiceName());     // Catch: JSONException -> L16
        JSONObject r10 = getExtraValues();     // Catch: JSONException -> L16
        if (JsonUtils.isEmpty(r10) == true) goto L8;
        this.logExtr.put("extra_values", r10);     // Catch: JSONException -> L16
    L8:
        JSONObject r11 = getExtraStatus();     // Catch: JSONException -> L16
        if (JsonUtils.isEmpty(r11) == true) goto L11;
        this.logExtr.put("extra_status", r11);     // Catch: JSONException -> L16
    L11:
        JSONObject r12 = getFilters();     // Catch: JSONException -> L16
        if (JsonUtils.isEmpty(r12) == true) goto L14;
        this.logExtr.put("filters", r12);     // Catch: JSONException -> L16
    L14:
        return this.logExtr;
    }
}
