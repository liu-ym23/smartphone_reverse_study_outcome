package com.lynx.debugrouter.base.report;

import com.lynx.debugrouter.base.service.DebugRouterServiceCenter;
import com.lynx.debugrouter.log.LLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class DebugRouterReportServiceUtil {
    private static final String TAG = "DebugRouterReportServiceUtil";

    public static class InnerClass {
        private static final IDebugRouterReportService service = null;

        private InnerClass() {
        }

        static {
            service = (IDebugRouterReportService) DebugRouterServiceCenter.instance().getService(IDebugRouterReportService.class);
        }

        public static /* synthetic */ IDebugRouterReportService access$000() {
            return service;
        }
    }

    public DebugRouterReportServiceUtil() {
    }

    public static void init(DebugRouterMetaInfo r1) {
        if (InnerClass.access$000() != null) goto L6;
        LLog.i(TAG, "init: DebugRouterReportService == null");
        return;
    L6:
        InnerClass.access$000().init(r1);
    }

    public static void report(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        if (InnerClass.access$000() != null) goto L6;
        LLog.i(TAG, "report: DebugRouterReportService == null");
        return;
    L6:
        if (r3 != null) goto L8;
        r3 = new JSONObject();
    L8:
        if (r4 != null) goto L10;
        r4 = new JSONObject();
    L10:
        if (r5 != null) goto L12;
        r5 = new JSONObject();
    L12:
        InnerClass.access$000().report("New" + r2, r3, r4, r5);
    }
}
