package com.bytedance.crash.event;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.Global;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.util.App;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class EventReportData {
    private static final String DEFAULT_EVENT_LOG_TYPE = "service_monitor";
    private JSONObject category;
    private long eventTime;
    private JSONObject metric;
    private String serviceName;
    private int status;
    private String threadName;

    public EventReportData(String r1, long r2, String r4, int r5, JSONObject r6, JSONObject r7) {
        this.threadName = r1;
        this.eventTime = r2;
        this.serviceName = r4;
        this.status = r5;
        this.category = r6;
        this.metric = r7;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public JSONObject toJsonObject() {
        JSONObject r0 = new JSONObject();
        r0.put("log_type", "service_monitor");     // Catch: Exception -> L5
        r0.put(Constants.EVENT_TYPE, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);     // Catch: Exception -> L5
        r0.put("service", this.serviceName);     // Catch: Exception -> L5
        r0.put("status", this.status);     // Catch: Exception -> L5
        r0.put(EventBody.KEY_CATEGORY, this.category);     // Catch: Exception -> L5
        r0.put(EventBody.KEY_METRIC, this.metric);     // Catch: Exception -> L5
        r0.put("sid", Global.getAppStartTime());     // Catch: Exception -> L5
        r0.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L5
        r0.put("crash_time", this.eventTime);     // Catch: Exception -> L5
        r0.put("process_name", App.getProcessName());     // Catch: Exception -> L5
        r0.put(CrashBody.CRASH_THREAD_NAME, this.threadName);     // Catch: Exception -> L5
    L4:
        return r0;
    }
}
