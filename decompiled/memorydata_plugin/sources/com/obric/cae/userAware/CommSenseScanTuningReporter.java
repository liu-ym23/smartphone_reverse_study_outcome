package com.obric.cae.userAware;

import android.net.wifi.ScanResult;
import android.os.Build;
import com.obric.cae.cloud.applog.b;
import com.obric.cae.commonsense.BuildConfig;
import com.obric.cae.libs.utils.a;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class CommSenseScanTuningReporter {
    static final String EVENT_SCAN_TUNING_RESULT = "wifi_scan_tune";
    private static final int EVENT_VERSION = 1;
    private static final String TAG = "CommSenseScanTuningReporter";

    private CommSenseScanTuningReporter() {
    }

    public static JSONObject buildResultPayload(long r5, List<ScanResult> r7, boolean r8, CommSenseScanTuningConfig r9, int r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L6;
        r11 = Collections.emptyList();
    L6:
        JSONObject r0 = new JSONObject();
        int r2 = 1;
        r0.put("version", 1);
        r0.put("device_id", safeString(MatrixDidUtils.getDid()));
        r0.put("product_name", safeString(Build.PRODUCT));
        r0.put("commsense_aar_version", safeString(BuildConfig.LIB_VERSION));
        r0.put("scan_duration_ms", Math.max(0, r5));
        r0.put("hotspot_count", r11.size());
        r0.put("hotspot_2g_count", count2gHotspots(r11));
        r0.put("hotspot_5g_count", count5gHotspots(r11));
        r0.put("wifi_connected", r8 ? 1 : 0);
        if (r9 != null) goto L10;
        r2 = 0;
    L10:
        r0.put("marker_enabled", r2);
        r0.put("rescan_channel_count", Math.max(0, r10));
        return r0;
    }

    private static int count2gHotspots(List<ScanResult> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L10;
        ScanResult r2 = (ScanResult) ZeusTransformUtils.preCheckCast(r5.next(), ScanResult.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (a.a(r2.frequency) == false) goto L4;
        r0 = r0 + 1;
        goto L4
    L10:
        return r0;
    }

    private static int count5gHotspots(List<ScanResult> r4) {
        Iterator r5 = ((List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L10;
        ScanResult r2 = (ScanResult) ZeusTransformUtils.preCheckCast(r5.next(), ScanResult.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (a.b(r2.frequency) == false) goto L4;
        r0 = r0 + 1;
        goto L4
    L10:
        return r0;
    }

    public static void reportScanTuningResult(long r6, List<ScanResult> r8, boolean r9, CommSenseScanTuningConfig r10, int r11) {
        JSONObject r7 = buildResultPayload(r6, (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin"), r9, r10, r11);     // Catch: Throwable -> L8
        CaeUserAwareReportBase r12 = CaeUserAwareReportFactory.getReportInstance();     // Catch: Throwable -> L8
        if (r12 == null) goto L6;
        r12.reportScanTuningResult(r7);     // Catch: Throwable -> L8
    L11:
        return;
    L6:
        b.a("wifi_scan_tune", r7);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        com.obric.cae.log.a.a(TAG, "Failed to report scan tuning result", th);
    }

    private static String safeString(String r0) {
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }
}
