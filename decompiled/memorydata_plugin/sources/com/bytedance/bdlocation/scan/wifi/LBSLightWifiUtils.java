package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class LBSLightWifiUtils {
    public LBSLightWifiUtils() {
    }

    public static List<ScanResult> getWifiScanResultsForLBSLightLocation(LBSLightLocationTraceLogger r17, LocationOption r18) {
        LocationMonitor.lbsLightLocationTraceMetricBegin(r17, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L53;
        final WifiManager r3 = (WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r17, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r17, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r17, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r17, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (BDLocationConfig.isIndependentThreadGetScanResults() == false) goto L11;
        LocationMonitor.lbsLightLocationTracePutCategoryData(r17, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, true);
        ThreadPoolExecutor r0 = AppExecutors.getInstance().lbsLightLocationExecutor();     // Catch: Throwable -> L9
        r3.getClass();     // Catch: Throwable -> L9
        List<ScanResult> r1 = (List) ZeusTransformUtils.preCheckCast(r0.submit(new $$Lambda$LBSLightWifiUtils$scHYhZA5ZaPAnp6rtnjuytP21XY(r3)).get(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L12:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r17, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (r1 == null) goto L51;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r17, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        List<ScanResult> r6 = new ArrayList(r1.size());
        long r8 = -1;
        Iterator<ScanResult> r4 = r1.iterator();
    L16:
        if (r4.hasNext() == false) goto L36;
        ScanResult r10 = (ScanResult) ZeusTransformUtils.preCheckCast(r4.next(), ScanResult.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L16;
        if (TextUtils.isEmpty(r10.SSID) == true) goto L16;
        if (TextUtils.isEmpty(r10.BSSID) == true) goto L16;
        if (r10.capabilities == null) goto L29;
        if (r10.capabilities.contains("[IBSS]") == true) goto L16;
    L29:
        if (Build.VERSION.SDK_INT <= 17) goto L34;
        long r11 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r10.timestamp / 1000);
        if (r11 <= r8) goto L33;
        r8 = r11;
    L33:
        r10.timestamp = r11 / 1000;
    L34:
        r6.add(r10);
        goto L16
    L36:
        if (r8 <= 0) goto L38;
        long r12 = System.currentTimeMillis() - r8;
        r18.setLightLocationWifiGap(r12);
        LocationMonitor.lbsLightLocationTracePutMetricData(r17, LBSLightLocationTraceLogger.WIFI_TIMELINESS, r12);
    L38:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r17, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        if (r6.isEmpty() == true) goto L49;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r17, LBSLightLocationTraceLogger.SORT);
        Collections.sort(r6, $$Lambda$LBSLightWifiUtils$lWhvKVjCXAMM5i9ldtIYczm6Ag.INSTANCE);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r17, LBSLightLocationTraceLogger.SORT);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r17, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        int r5 = BDLocationConfig.getWifiNum();
        if (r5 > 0) goto L44;
        r5 = 30;
    L44:
        if (r6.size() <= r5) goto L46;
        r6 = r6.subList(0, r5);
    L46:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r17, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        return r6;
    L49:
        throw new BDLocationException("wifi get scan results is empty(not null)", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L51:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: scanResults == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L9:
        th = move-exception;
        th.printStackTrace();
        r1 = null;
        goto L12
    L11:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r17, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, false);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r17, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        List<ScanResult> r7 = r3.getScanResults();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r17, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        r1 = r7;
        goto L12
    L53:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: context == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    }

    static /* synthetic */ int lambda$getWifiScanResultsForLBSLightLocation$0(ScanResult r0, ScanResult r1) {
        if (r0 != null) goto L6;
        if (r1 != null) goto L6;
        return 0;
    L6:
        if (r0 != null) goto L9;
        return 1;
    L9:
        if (r1 != null) goto L13;
        return -1;
    L13:
        return r1.level - r0.level;
    }

    public static /* synthetic */ List lambda$scHYhZA5ZaPAnp6rtnjuytP21XY(WifiManager r0) {
        return r0.getScanResults();
    }
}
