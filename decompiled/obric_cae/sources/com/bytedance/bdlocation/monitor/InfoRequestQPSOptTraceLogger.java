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
        JSONObject r8 = new JSONObject();
        dumpCategoriesTo(r8);
        JSONObject r10 = new JSONObject();
        dumpMetricsTo(r10);
        JSONObject r11 = new JSONObject();
        dumpLogExtrasTo(r11);
        Logger.i("monitorInfoRequestQPSOptEvent categories: " + r8);
        Logger.i("monitorInfoRequestQPSOptEvent metrics: " + r10);
        Logger.i("monitorInfoRequestQPSOptEvent logExtras: " + r11);
        LocationMonitorUtil.monitorEvent(LocationMonitorConst.EVENT_INFO_QPS_OPT, r8, r10, r11);
    }
}
