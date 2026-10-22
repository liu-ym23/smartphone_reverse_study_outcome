package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
        void onFailed(BDLocationException r1);

        void onWifiInfoJson(JsonArray r1, boolean r2, boolean r3, WifiInfo r4);
    }

    static {
        Field r0 = null;
        Field r1 = ScanResult.class.getDeclaredField("SSID");     // Catch: Throwable -> L5
        Field r2 = ScanResult.class.getDeclaredField("BSSID");     // Catch: Throwable -> L5
        r0 = r1;
    L7:
        SCAN_RESULT_SSID_FIELD = r0;
        SCAN_RESULT_BSSID_FIELD = r2;
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        r2 = null;
        goto L7
    }

    public WifiUtil() {
    }

    public static long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static JsonArray getMockWifiJson() {
        ArrayList r0 = new ArrayList();
        WifiInfo r1 = new WifiInfo();
        r1.wifiMac = LocationInfoConst.MOCK_WIFI_MAC;
        r1.rssi = 0;
        r1.isCurrent = 1;
        r1.wifiName = BDLocationConfig.getMockWifiName();
        r1.timeStamp = getCurrentTimeSeconds();
        r0.add(r1);
        JsonElement r2 = JsonUtil.toJsonTreeSafely(r0, new AnonymousClass3().getType());
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r2.isJsonArray() == true) goto L8;
        return null;
    L8:
        return r2.getAsJsonArray();
    }

    public static String getScanResultBSSIDByReflect(ScanResult r5) {
        if (r5 == null) goto L12;
        Field r2 = SCAN_RESULT_BSSID_FIELD;
        if (r2 == null) goto L12;
        return (String) ZeusTransformUtils.preCheckCast(r2.get(r5), String.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.e("getScanResultBSSIDByReflect failed: " + th, th);
        LocationMonitor.monitorReflectScanResultFailed(-2, 1, th.getMessage());
        return null;
    L12:
        StringBuilder r3 = new StringBuilder().append("getScanResultBSSIDByReflect failed: scanResult == null: ");
        boolean r4 = false;
        if (r5 != null) goto L15;
        boolean r6 = true;
    L16:
        StringBuilder r7 = r3.append(r6).append(", SCAN_RESULT_BSSID_FIELD == null: ");
        if (SCAN_RESULT_BSSID_FIELD != null) goto L19;
        r4 = true;
    L19:
        Logger.e(r7.append(r4).toString());
        if (r5 == null) goto L22;
        LocationMonitor.monitorReflectScanResultFailed(-1, 1, "SCAN_RESULT_BSSID_FIELD == null");
    L22:
        return null;
    L15:
        r6 = false;
        goto L16
    }

    public static String getScanResultSSIDByReflect(ScanResult r5) {
        if (r5 == null) goto L12;
        Field r2 = SCAN_RESULT_SSID_FIELD;
        if (r2 == null) goto L12;
        return (String) ZeusTransformUtils.preCheckCast(r2.get(r5), String.class, "com.obric.memorydata.plugin");
    L9:
        th = move-exception;
        th.printStackTrace();
        Logger.e("getScanResultSSIDByReflect failed: " + th, th);
        LocationMonitor.monitorReflectScanResultFailed(-2, 0, th.getMessage());
        return null;
    L12:
        StringBuilder r3 = new StringBuilder().append("getScanResultSSIDByReflect failed: scanResult == null: ");
        boolean r4 = true;
        if (r5 != null) goto L15;
        boolean r6 = true;
    L16:
        StringBuilder r7 = r3.append(r6).append(", SCAN_RESULT_SSID_FIELD == null: ");
        if (SCAN_RESULT_SSID_FIELD == null) goto L20;
        r4 = false;
    L20:
        Logger.e(r7.append(r4).toString());
        if (r5 == null) goto L23;
        LocationMonitor.monitorReflectScanResultFailed(-1, 0, "SCAN_RESULT_SSID_FIELD == null");
    L23:
        return null;
    L15:
        r6 = false;
        goto L16
    }

    public static JsonArray getWifiInfoJson(Context r2, Object r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L21;
        return null;
    L21:
    L18:
        e = move-exception;
        Logger.e("", e);
        return null;
    L6:
        if (BDLocationConfig.isUploadWIFI() == false) goto L23;
        List<WifiInfo> r5 = WifiInfoManager.getWifiInfos(r4, r3, true);     // Catch: Exception -> L18
        if (getWifiListByNum(r5, false) != null) goto L10;
        return null;
    L10:
        JsonElement r6 = JsonUtil.toJsonTreeSafely(r5, new AnonymousClass2().getType());     // Catch: Exception -> L18
        if (r6 != null) goto L13;
    L17:
        return null;
    L13:
        if (r6.isJsonArray() == false) goto L17;
        return r6.getAsJsonArray();
    L23:
        return null;
    }

    public static void getWifiInfoJsonAsync(Context r7, WifiInfoJsonCallback r8, Object r9, final LocationTraceLogger r10, LocationOption r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        final WifiInfoJsonCallback r13 = (WifiInfoJsonCallback) ZeusTransformUtils.wrapperContextForParams(r8, WifiInfoJsonCallback.class, "com.obric.memorydata.plugin");
    L12:
        e = move-exception;
        Logger.e("", e);
        LocationMonitor.locationTracePutCategoryData(r10, LocationMonitorConst.WIFI_SCAN_SUCCESS, false);
        r13.onFailed(new BDLocationException(e.getMessage(), null, BDLocationException.ERROR_WIFI_UPLOAD));
        return;
    L4:
        if (BDLocationConfig.isUploadWIFI() == true) goto L6;
    L10:
        Logger.i("WifiUtil.getWifiInfoJsonAsync: skip wifi collect.");     // Catch: Exception -> L12
        LocationMonitor.locationTracePutCategoryData(r10, LocationMonitorConst.WIFI_SCAN_SUCCESS, false);     // Catch: Exception -> L12
        r13.onFailed(new BDLocationException("没有开启wifi上报", null, BDLocationException.ERROR_WIFI_UPLOAD));     // Catch: Exception -> L12
    L15:
        return;
    L6:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r11) == true) goto L10;
        if (LocationUtil.enableContinueLocateUploadSensitiveSignal(r11, BDLocationConfig.isContinueLocateUploadWifi()) == false) goto L10;
        LocationMonitor.locationTraceLogBegin(r10, LocationMonitorConst.SCAN_WIFI_DURATION);     // Catch: Exception -> L12
        WifiInfoManager r14 = new WifiInfoManager();     // Catch: Exception -> L12
        final long r4 = SystemClock.elapsedRealtime();     // Catch: Exception -> L12
        r14.getWifiScanInfos(r12, new $$Lambda$WifiUtil$3S9xE2_lEH_gVfwt50tmndoi2Mw(r10, r4, r13), r9, r10);     // Catch: Exception -> L12
        goto L15
    }

    private static List<WifiInfo> getWifiListByNum(List<WifiInfo> r2, boolean r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        if (r4.isEmpty() == true) goto L18;
        Collections.sort(r4);
        int r0 = r4.size();
        if (r3 == false) goto L12;
        if (r0 <= 30) goto L15;
        r0 = 30;
    L15:
        return r4.subList(0, r0);
    L12:
        if (r0 <= BDLocationConfig.getWifiNum()) goto L15;
        r0 = BDLocationConfig.getWifiNum();
        goto L15
    L18:
        return null;
    }

    public static WifiInfoModule getWifiModule(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L14;
        return null;
    L14:
        WifiInfoModule r8 = WifiInfoManager.getWifiModule(r7, null, true, r6, null);     // Catch: Exception -> L11
        if (r8 != null) goto L9;
        return null;
    L9:
        return new WifiInfoModule(getWifiListByNum(r8.wifiInfoList, r6), r8.connectWifi, r8.cacheWifiTime);
    L11:
        e = move-exception;
        Logger.e("", e);
        return null;
    }

    public static List<ScanResult> getWifiScanResultsForLBSLightLocation(final Object r17, LBSLightLocationTraceLogger r18) {
        LocationMonitor.lbsLightLocationTraceMetricBegin(r18, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L53;
        final WifiManager r4 = (WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r18, LBSLightLocationTraceLogger.PRE_SCAN_RESULTS);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r18, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        final IBPEALocal r7 = BDLocationExtrasService.getBPEAManager();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r18, LBSLightLocationTraceLogger.GET_BPEA_MANAGER);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r18, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (BDLocationConfig.isIndependentThreadGetScanResults() == false) goto L11;
        LocationMonitor.lbsLightLocationTracePutCategoryData(r18, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, true);
        List<ScanResult> r0 = (List) ZeusTransformUtils.preCheckCast(AppExecutors.getInstance().lbsLightLocationExecutor().submit(new $$Lambda$WifiUtil$2e9w03Wo583nIkgiyHLrVnE8VY(r7, r4, r17)).get(), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L12:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r18, LBSLightLocationTraceLogger.GET_SCAN_RESULTS);
        if (r0 == null) goto L51;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r18, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        List<ScanResult> r5 = new ArrayList(r0.size());
        long r8 = -1;
        Iterator<ScanResult> r1 = r0.iterator();
    L16:
        if (r1.hasNext() == false) goto L36;
        ScanResult r10 = (ScanResult) ZeusTransformUtils.preCheckCast(r1.next(), ScanResult.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L16;
        if (TextUtils.isEmpty(getScanResultSSIDByReflect(r10)) == true) goto L16;
        if (TextUtils.isEmpty(getScanResultBSSIDByReflect(r10)) == true) goto L16;
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
        r5.add(r10);
        goto L16
    L36:
        if (r8 <= 0) goto L38;
        LocationMonitor.lbsLightLocationTracePutMetricData(r18, LBSLightLocationTraceLogger.WIFI_TIMELINESS, System.currentTimeMillis() - r8);
    L38:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r18, LBSLightLocationTraceLogger.TRIM_SCAN_RESULTS);
        if (r5.isEmpty() == true) goto L49;
        LocationMonitor.lbsLightLocationTraceMetricBegin(r18, LBSLightLocationTraceLogger.SORT);
        Collections.sort(r5, $$Lambda$WifiUtil$NT2Y3bAge7zcYEsXPgJGPjaPIk.INSTANCE);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r18, LBSLightLocationTraceLogger.SORT);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r18, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        int r2 = BDLocationConfig.getWifiNum();
        if (r2 > 0) goto L44;
        r2 = 30;
    L44:
        if (r5.size() <= r2) goto L46;
        r5 = r5.subList(0, r2);
    L46:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r18, LBSLightLocationTraceLogger.SUB_SCAN_LIST);
        return r5;
    L49:
        throw new BDLocationException("wifi get scan results is empty(not null)", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L51:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: scanResults == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    L9:
        th = move-exception;
        th.printStackTrace();
        r0 = null;
        goto L12
    L11:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r18, LBSLightLocationTraceLogger.INDEPENDENT_THREAD_GET_SCAN_RESULTS, false);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r18, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        r0 = r7.getScanResults(r4, r17);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r18, LBSLightLocationTraceLogger.GET_SCAN_RESULTS_INNER);
        goto L12
    L53:
        throw new BDLocationException("getWifiScanResultsForLBSLightLocation failed: context == null", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED);
    }

    static /* synthetic */ void lambda$getWifiInfoJsonAsync$0(LocationTraceLogger r4, long r5, WifiInfoJsonCallback r7, List r8, boolean r9, boolean r10, WifiInfo r11) {
        WifiInfoJsonCallback r12 = (WifiInfoJsonCallback) ZeusTransformUtils.wrapperContextForParams(r7, WifiInfoJsonCallback.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        LocationMonitor.locationTracePutCategoryData(r4, LocationMonitorConst.IS_WIFI_CACHE, Boolean.valueOf(r9));
        boolean r0 = true;
        LocationMonitor.locationTracePutCategoryData(r4, LocationMonitorConst.WIFI_SCAN_SUCCESS, true);
        LocationMonitor.locationTraceLogEnd(r4, LocationMonitorConst.SCAN_WIFI_DURATION);
        LocationMonitor.fetchWifiDuration(SystemClock.elapsedRealtime() - r5, r9);
        Logger.i("LocationMonitor fetch wifi duration is: " + (SystemClock.elapsedRealtime() - r5) + "ms");
        List<WifiInfo> r6 = getWifiListByNum(r13, false);
        if (r6 != null) goto L5;
    L9:
        JsonArray r14 = null;
    L10:
        if (r14 == null) goto L13;
        r0 = false;
    L13:
        LocationMonitor.locationTracePutCategoryData(r4, LocationMonitorConst.IS_WIFI_NULL, Boolean.valueOf(r0));
        r12.onWifiInfoJson(r14, r9, r10, r11);
        return;
    L5:
        if (r6.size() <= 0) goto L9;
        JsonElement r15 = JsonUtil.toJsonTreeSafely(r6, new AnonymousClass1().getType());
        if (r15 == null) goto L9;
        r14 = r15.getAsJsonArray();
        goto L10
    }

    static /* synthetic */ List lambda$getWifiScanResultsForLBSLightLocation$1(IBPEALocal r2, WifiManager r3, Object r4) {
        return ((IBPEALocal) ZeusTransformUtils.wrapperContextForParams(r2, IBPEALocal.class, "com.obric.memorydata.plugin")).getScanResults(r3, r4);
    }

    static /* synthetic */ int lambda$getWifiScanResultsForLBSLightLocation$2(ScanResult r0, ScanResult r1) {
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
}
