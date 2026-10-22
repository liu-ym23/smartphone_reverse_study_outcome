package com.bytedance.crash.event;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.Global;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.util.App;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EventReportData {
    private static final String DEFAULT_EVENT_LOG_TYPE = "service_monitor";
    private JSONObject category;
    private long eventTime;
    private JSONObject metric;
    private String serviceName;
    private int status;
    private String threadName;

    public EventReportData(String r10, long r11, String r12, int r13, JSONObject r14, JSONObject r15) {
        this.threadName = r10;
        this.eventTime = r11;
        this.serviceName = r12;
        this.status = r13;
        this.category = r14;
        this.metric = r15;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public JSONObject toJsonObject() {
        JSONObject r10 = new JSONObject();
        r10.put("log_type", "service_monitor");     // Catch: Exception -> L5
        r10.put(Constants.EVENT_TYPE, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);     // Catch: Exception -> L5
        r10.put("service", this.serviceName);     // Catch: Exception -> L5
        r10.put("status", this.status);     // Catch: Exception -> L5
        r10.put(EventBody.KEY_CATEGORY, this.category);     // Catch: Exception -> L5
        r10.put(EventBody.KEY_METRIC, this.metric);     // Catch: Exception -> L5
        r10.put("sid", Global.getAppStartTime());     // Catch: Exception -> L5
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L5
        r10.put("crash_time", this.eventTime);     // Catch: Exception -> L5
        r10.put("process_name", App.getProcessName());     // Catch: Exception -> L5
        r10.put(CrashBody.CRASH_THREAD_NAME, this.threadName);     // Catch: Exception -> L5
    L4:
        return r10;
    }
}
