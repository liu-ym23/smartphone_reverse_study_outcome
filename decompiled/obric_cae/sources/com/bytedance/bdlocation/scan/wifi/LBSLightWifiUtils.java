package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.thread.AppExecutors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import s1.g;

/* JADX INFO: loaded from: classes.dex */
public class LBSLightWifiUtils {
    public LBSLightWifiUtils() {
    }

    public static /* synthetic */ int a(ScanResult r8, ScanResult r10) {
        return lambda$getWifiScanResultsForLBSLightLocation$0(r8, r10);
    }

    public static List<ScanResult> getWifiScanResultsForLBSLightLocation(LBSLightLocationTraceLogger r16, LocationOption r17) {
        LocationMonitor.lbsLightLocationTraceMetricBegin(r16, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        Context r8 = BDLocationConfig.getContext();
        if (r8 == null) goto L50;
        WifiManager r10 = (WifiManager) r8.getApplicationContext().getSystemService("wifi");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r16, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r16, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r16, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r16, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        int r11 = 1;
        if (BDLocationConfig.isIndependentThreadGetScanResults() == false) goto L11;
        LocationMonitor.lbsLightLocationTracePutCategoryData(r16, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.TRUE);
        ThreadPoolExecutor r12 = AppExecutors.getInstance().lbsLightLocationExecutor();     // Catch: Throwable -> L9
        r10.getClass();     // Catch: Throwable -> L9
        List<ScanResult> r13 = (List) r12.submit(new g(r10, r11)).get();     // Catch: Throwable -> L9
    L12:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r16, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (r13 == null) goto L48;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r16, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        ArrayList r14 = new ArrayList(r13.size());
        Iterator<ScanResult> r15 = r13.iterator();
        long r18 = -1;
    L16:
        if (r15.hasNext() == false) goto L33;
        ScanResult r19 = r15.next();
        if (r19 == null) goto L16;
        if (TextUtils.isEmpty(r19.SSID) == true) goto L16;
        if (TextUtils.isEmpty(r19.BSSID) == true) goto L16;
        String r110 = r19.capabilities;
        if (r110 == null) goto L28;
        if (r110.contains("[IBSS]") == true) goto L16;
    L28:
        long r111 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        long r112 = (r19.timestamp / 1000) + r111;
        if (r112 <= r18) goto L31;
        r18 = r112;
    L31:
        r19.timestamp = r112 / 1000;
        r14.add(r19);
        goto L16
    L33:
        if (r18 <= 0) goto L35;
        long r20 = System.currentTimeMillis() - r18;
        r17.setLightLocationWifiGap(r20);
        LocationMonitor.lbsLightLocationTracePutMetricData(r16, LBSLightLocationTraceLogger.WIFI_TIMELINESS, r20);
    L35:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r16, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        if (r14.isEmpty() == true) goto L46;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r16, LBSLightLocationTraceLogger.SORT);
        Collections.sort(r14, new g0.d(r11));
        LocationMonitor.lbsLightLocationTraceMetricEnd(r16, LBSLightLocationTraceLogger.SORT);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r16, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        int r21 = BDLocationConfig.getWifiNum();
        if (r21 > 0) goto L40;
        r21 = 30;
    L40:
        int r22 = r14.size();
        List<ScanResult> r23 = r14;
        if (r22 <= r21) goto L43;
        r23 = r14.subList(0, r21);
    L43:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r16, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        return r23;
    L46:
        throw new BDLocationException("wifi get scan results is empty(not null)", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L48:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: scanResults == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L9:
        th = move-exception;
        th.printStackTrace();
        r13 = null;
        goto L12
    L11:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r16, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.FALSE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r16, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        List<ScanResult> r24 = r10.getScanResults();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r16, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        r13 = r24;
        goto L12
    L50:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: context == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    }

    private static /* synthetic */ int lambda$getWifiScanResultsForLBSLightLocation$0(ScanResult r8, ScanResult r10) {
        if (r8 != null) goto L6;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r8 != null) goto L9;
        return 1;
    L9:
        if (r10 != null) goto L13;
        return -1;
    L13:
        return r10.level - r8.level;
    }
}
