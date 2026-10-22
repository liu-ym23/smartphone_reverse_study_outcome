package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import ha.m;
import ha.p;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WifiUtil {
    private static final Field SCAN_RESULT_BSSID_FIELD = null;
    private static final Field SCAN_RESULT_SSID_FIELD = null;
    public static final String TAG = "WifiUtil";

    public interface WifiInfoJsonCallback {
        void onFailed(BDLocationException r8);

        void onWifiInfoJson(m r8, boolean r10, boolean r11, WifiInfo r12);
    }

    static {
        Field r8 = ScanResult.class.getDeclaredField("SSID");     // Catch: Throwable -> L5
        Field r10 = ScanResult.class.getDeclaredField("BSSID");     // Catch: Throwable -> L5
    L7:
        SCAN_RESULT_SSID_FIELD = r8;
        SCAN_RESULT_BSSID_FIELD = r10;
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        r8 = null;
        r10 = null;
        goto L7
    }

    public WifiUtil() {
    }

    public static /* synthetic */ List a(IBPEALocal r8, WifiManager r10, Object r11) {
        return lambda$getWifiScanResultsForLBSLightLocation$1(r8, r10, r11);
    }

    public static /* synthetic */ void b(LocationTraceLogger r8, long r10, WifiInfoJsonCallback r11, List r12, boolean r13, boolean r14, WifiInfo r15) {
        lambda$getWifiInfoJsonAsync$0(r8, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ int c(ScanResult r8, ScanResult r10) {
        return lambda$getWifiScanResultsForLBSLightLocation$2(r8, r10);
    }

    public static long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static m getMockWifiJson() {
        ArrayList r8 = new ArrayList();
        WifiInfo r10 = new WifiInfo();
        r10.wifiMac = LocationInfoConst.MOCK_WIFI_MAC;
        r10.rssi = 0;
        r10.isCurrent = 1;
        r10.wifiName = BDLocationConfig.getMockWifiName();
        r10.timeStamp = getCurrentTimeSeconds();
        r8.add(r10);
        p r11 = JsonUtil.toJsonTreeSafely(r8, new AnonymousClass3().getType());
        if (r11 != null) goto L5;
        return null;
    L5:
        if ((r11 instanceof m) == true) goto L8;
        return null;
    L8:
        return r11.e();
    }

    public static String getScanResultBSSIDByReflect(ScanResult r8) {
        if (r8 == null) goto L12;
        Field r10 = SCAN_RESULT_BSSID_FIELD;
        if (r10 == null) goto L12;
        return (String) r10.get(r8);
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.e("getScanResultBSSIDByReflect failed: " + th, th);
        LocationMonitor.monitorReflectScanResultFailed(-2, 1, th.getMessage());
        return null;
    L12:
        StringBuilder r11 = new StringBuilder("getScanResultBSSIDByReflect failed: scanResult == null: ");
        boolean r12 = false;
        if (r8 != null) goto L15;
        boolean r13 = true;
    L16:
        r11.append(r13);
        r11.append(", SCAN_RESULT_BSSID_FIELD == null: ");
        if (SCAN_RESULT_BSSID_FIELD != null) goto L19;
        r12 = true;
    L19:
        r11.append(r12);
        Logger.e(r11.toString());
        if (r8 == null) goto L22;
        LocationMonitor.monitorReflectScanResultFailed(-1, 1, "SCAN_RESULT_BSSID_FIELD == null");
    L22:
        return null;
    L15:
        r13 = false;
        goto L16
    }

    public static String getScanResultSSIDByReflect(ScanResult r8) {
        if (r8 == null) goto L12;
        Field r10 = SCAN_RESULT_SSID_FIELD;
        if (r10 == null) goto L12;
        return (String) r10.get(r8);
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.e("getScanResultSSIDByReflect failed: " + th, th);
        LocationMonitor.monitorReflectScanResultFailed(-2, 0, th.getMessage());
        return null;
    L12:
        StringBuilder r11 = new StringBuilder("getScanResultSSIDByReflect failed: scanResult == null: ");
        boolean r12 = true;
        if (r8 != null) goto L15;
        boolean r13 = true;
    L16:
        r11.append(r13);
        r11.append(", SCAN_RESULT_SSID_FIELD == null: ");
        if (SCAN_RESULT_SSID_FIELD == null) goto L20;
        r12 = false;
    L20:
        r11.append(r12);
        Logger.e(r11.toString());
        if (r8 == null) goto L23;
        LocationMonitor.monitorReflectScanResultFailed(-1, 0, "SCAN_RESULT_SSID_FIELD == null");
    L23:
        return null;
    L15:
        r13 = false;
        goto L16
    }

    public static m getWifiInfoJson(Context r8, Object r10) {
        if (r8 != null) goto L21;
        return null;
    L21:
    L18:
        e = move-exception;
        Logger.e("", e);
        return null;
    L6:
        if (BDLocationConfig.isUploadWIFI() == false) goto L23;
        List<WifiInfo> r11 = WifiInfoManager.getWifiInfos(r8, r10, true);     // Catch: Exception -> L18
        if (getWifiListByNum(r11, false) != null) goto L10;
        return null;
    L10:
        p r12 = JsonUtil.toJsonTreeSafely(r11, new AnonymousClass2().getType());     // Catch: Exception -> L18
        if (r12 != null) goto L13;
    L17:
        return null;
    L13:
        if ((r12 instanceof m) == false) goto L17;
        return r12.e();
    L23:
        return null;
    }

    public static void getWifiInfoJsonAsync(Context r8, final WifiInfoJsonCallback r10, Object r11, final LocationTraceLogger r12, LocationOption r13) {
    L12:
        e = move-exception;
        Logger.e("", e);
        LocationMonitor.locationTracePutCategoryData(r12, LocationMonitorConst.WIFI_SCAN_SUCCESS, Boolean.FALSE);
        r10.onFailed(new BDLocationException(e.getMessage(), null, BDLocationException.ERROR_WIFI_UPLOAD));
        return;
    L4:
        if (BDLocationConfig.isUploadWIFI() == true) goto L6;
    L10:
        Logger.i("WifiUtil.getWifiInfoJsonAsync: skip wifi collect.");     // Catch: Exception -> L12
        LocationMonitor.locationTracePutCategoryData(r12, LocationMonitorConst.WIFI_SCAN_SUCCESS, Boolean.FALSE);     // Catch: Exception -> L12
        r10.onFailed(new BDLocationException("没有开启wifi上报", null, BDLocationException.ERROR_WIFI_UPLOAD));     // Catch: Exception -> L12
    L15:
        return;
    L6:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r13) == true) goto L10;
        if (LocationUtil.enableContinueLocateUploadSensitiveSignal(r13, BDLocationConfig.isContinueLocateUploadWifi()) == false) goto L10;
        LocationMonitor.locationTraceLogBegin(r12, LocationMonitorConst.SCAN_WIFI_DURATION);     // Catch: Exception -> L12
        WifiInfoManager r14 = new WifiInfoManager();     // Catch: Exception -> L12
        final long r15 = SystemClock.elapsedRealtime();     // Catch: Exception -> L12
        r14.getWifiScanInfos(r8, new d(r12, r15, r10), r11, r12);     // Catch: Exception -> L12
        goto L15
    }

    private static List<WifiInfo> getWifiListByNum(List<WifiInfo> r8, boolean r10) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.isEmpty() == true) goto L18;
        Collections.sort(r8);
        int r11 = r8.size();
        if (r10 == false) goto L12;
        if (r11 <= 30) goto L15;
        r11 = 30;
    L15:
        return r8.subList(0, r11);
    L12:
        if (r11 <= BDLocationConfig.getWifiNum()) goto L15;
        r11 = BDLocationConfig.getWifiNum();
        goto L15
    L18:
        return null;
    }

    public static WifiInfoModule getWifiModule(Context r8, boolean r10) {
        if (r8 != null) goto L14;
        return null;
    L14:
        WifiInfoModule r11 = WifiInfoManager.getWifiModule(r8, null, true, r10, null);     // Catch: Exception -> L11
        if (r11 != null) goto L9;
        return null;
    L9:
        return new WifiInfoModule(getWifiListByNum(r11.wifiInfoList, r10), r11.connectWifi, r11.cacheWifiTime);
    L11:
        e = move-exception;
        Logger.e("", e);
        return null;
    }

    public static List<ScanResult> getWifiScanResultsForLBSLightLocation(final Object r13, LBSLightLocationTraceLogger r14) {
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        Context r8 = BDLocationConfig.getContext();
        if (r8 == null) goto L50;
        final WifiManager r10 = (WifiManager) r8.getApplicationContext().getSystemService("wifi");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        final IBPEALocal r11 = BDLocationExtrasService.getBPEAManager();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (BDLocationConfig.isIndependentThreadGetScanResults() == false) goto L11;
        LocationMonitor.lbsLightLocationTracePutCategoryData(r14, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.TRUE);
        List<ScanResult> r15 = (List) AppExecutors.getInstance().lbsLightLocationExecutor().submit(new e(r11, r10, r13)).get();     // Catch: Throwable -> L9
    L12:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (r15 == null) goto L48;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        ArrayList r12 = new ArrayList(r15.size());
        Iterator<ScanResult> r16 = r15.iterator();
        long r17 = -1;
    L16:
        if (r16.hasNext() == false) goto L33;
        ScanResult r18 = r16.next();
        if (r18 == null) goto L16;
        if (TextUtils.isEmpty(getScanResultSSIDByReflect(r18)) == true) goto L16;
        if (TextUtils.isEmpty(getScanResultBSSIDByReflect(r18)) == true) goto L16;
        String r19 = r18.capabilities;
        if (r19 == null) goto L28;
        if (r19.contains("[IBSS]") == true) goto L16;
    L28:
        long r20 = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        long r21 = (r18.timestamp / 1000) + r20;
        if (r21 <= r17) goto L31;
        r17 = r21;
    L31:
        r18.timestamp = r21 / 1000;
        r12.add(r18);
        goto L16
    L33:
        if (r17 <= 0) goto L35;
        LocationMonitor.lbsLightLocationTracePutMetricData(r14, LBSLightLocationTraceLogger.WIFI_TIMELINESS, System.currentTimeMillis() - r17);
    L35:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        if (r12.isEmpty() == true) goto L46;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.SORT);
        Collections.sort(r12, new f(0));
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.SORT);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        int r22 = BDLocationConfig.getWifiNum();
        if (r22 > 0) goto L40;
        r22 = 30;
    L40:
        int r23 = r12.size();
        List<ScanResult> r24 = r12;
        if (r23 <= r22) goto L43;
        r24 = r12.subList(0, r22);
    L43:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        return r24;
    L46:
        throw new BDLocationException("wifi get scan results is empty(not null)", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L48:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: scanResults == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L9:
        th = move-exception;
        th.printStackTrace();
        r15 = null;
        goto L12
    L11:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r14, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, Boolean.FALSE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        r15 = r11.getScanResults(r10, r13);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r14, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        goto L12
    L50:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: context == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    }

    private static /* synthetic */ void lambda$getWifiInfoJsonAsync$0(LocationTraceLogger r8, long r10, WifiInfoJsonCallback r11, List r12, boolean r13, boolean r14, WifiInfo r15) {
        LocationMonitor.locationTracePutCategoryData(r8, LocationMonitorConst.IS_WIFI_CACHE, Boolean.valueOf(r13));
        LocationMonitor.locationTracePutCategoryData(r8, LocationMonitorConst.WIFI_SCAN_SUCCESS, Boolean.TRUE);
        LocationMonitor.locationTraceLogEnd(r8, LocationMonitorConst.SCAN_WIFI_DURATION);
        LocationMonitor.fetchWifiDuration(SystemClock.elapsedRealtime() - r10, r13);
        Logger.i("LocationMonitor fetch wifi duration is: " + (SystemClock.elapsedRealtime() - r10) + "ms");
        boolean r16 = false;
        List<WifiInfo> r17 = getWifiListByNum(r12, false);
        if (r17 != null) goto L5;
    L9:
        m r18 = null;
    L10:
        if (r18 != null) goto L12;
        r16 = true;
    L12:
        LocationMonitor.locationTracePutCategoryData(r8, LocationMonitorConst.IS_WIFI_NULL, Boolean.valueOf(r16));
        r11.onWifiInfoJson(r18, r13, r14, r15);
        return;
    L5:
        if (r17.size() <= 0) goto L9;
        p r19 = JsonUtil.toJsonTreeSafely(r17, new AnonymousClass1().getType());
        if (r19 == null) goto L9;
        r18 = r19.e();
        goto L10
    }

    private static /* synthetic */ List lambda$getWifiScanResultsForLBSLightLocation$1(IBPEALocal r8, WifiManager r10, Object r11) {
        return r8.getScanResults(r10, r11);
    }

    private static /* synthetic */ int lambda$getWifiScanResultsForLBSLightLocation$2(ScanResult r8, ScanResult r10) {
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
