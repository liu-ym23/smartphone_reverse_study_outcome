package com.lynx.debugrouter;

import com.lynx.debugrouter.base.report.DebugRouterReportServiceUtil;
import com.lynx.debugrouter.log.LLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class NativeReportDelegate {
    private static final String TAG = "NativeReportDelegate";

    public NativeReportDelegate() {
    }

    private static JSONObject stringToJSONObject(String r2, String r3) {
        return new JSONObject(r3);
    L4:
        e = move-exception;
        LLog.e(TAG, "Failed to parse " + r2 + " JSON: " + e.getMessage());
        return new JSONObject();
    }

    public void report(String r3, String r4, String r5, String r6) {
        LLog.i(TAG, "report: " + r3 + ", " + r4 + ", " + r5 + ", " + r6);
        DebugRouterReportServiceUtil.report(r3, stringToJSONObject("category", r4), stringToJSONObject("metric", r5), stringToJSONObject("extra", r6));
    }
}
