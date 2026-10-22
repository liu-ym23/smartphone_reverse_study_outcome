package com.bytedance.bdlocation.monitor;

import com.bytedance.bdlocation.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class InfoRequestQPSOptTraceLogger extends AbstractTraceLogger {
    public static final String CACHE_DURATION = "cache_duration";
    public static final String CACHE_FAILED_REASON = "cache_failed_reason";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String IS_CACHE_SUCCESS = "is_cache_success";
    public static final String IS_SKIP = "is_skip";
    public static final String REASON = "reason";
    public static final String SKIP_CHECK_DURATION = "skip_check_duration";

    public InfoRequestQPSOptTraceLogger() {
    }

    public void monitorInfoRequestQPSOptEvent() {
        JSONObject r0 = new JSONObject();
        dumpCategoriesTo(r0);
        JSONObject r1 = new JSONObject();
        dumpMetricsTo(r1);
        JSONObject r2 = new JSONObject();
        dumpLogExtrasTo(r2);
        Logger.i("monitorInfoRequestQPSOptEvent categories: " + r0);
        Logger.i("monitorInfoRequestQPSOptEvent metrics: " + r1);
        Logger.i("monitorInfoRequestQPSOptEvent logExtras: " + r2);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_INFO_QPS_OPT, r0, r1, r2);
    }
}
