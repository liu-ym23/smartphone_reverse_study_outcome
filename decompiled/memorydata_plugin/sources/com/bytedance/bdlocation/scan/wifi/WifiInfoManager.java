package com.bytedance.bdlocation.scan.wifi;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WifiInfoManager {
    public static final String CACHE_CONNECT_WIFI_BSSID_KEY = "cache_connect_wifi_bssid";
    private static final String TAG = "WifiInfoManager";
    private static SparseIntArray sChannelFrequency;
    private AppExecutors mAppExecutors;
    private Object mBpeaCert;
    private volatile boolean mEnableCallbackOnMainThread;
    private Handler mHandler;
    private volatile boolean mIsNotified;
    private volatile boolean mIsRegisterReceiver;
    private LocationTraceLogger mTraceLogger;
    private WifiInfoCallback mWifiInfoCallback;
    private PluginBroadcastReceiver mWifiScanReceiver;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.wifi.WifiInfoManager$1, reason: invalid class name */
    class AnonymousClass1 extends PluginBroadcastReceiver {
        final /* synthetic */ WifiInfoManager this$0;

        AnonymousClass1(WifiInfoManager r1) {
            this.this$0 = r1;
        }

        public /* synthetic */ void lambda$onReceive$0$WifiInfoManager$1(Intent r11, Context r12) {
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
            long r0 = System.currentTimeMillis() / 1000;
            boolean r14 = r11.getBooleanExtra("resultsUpdated", false);
            if (r14 == false) goto L5;
            String r4 = "WifiInfoManager scan wifi from broadcast result is success.";
        L6:
            Logger.i(r4);
            WifiInfoManager r5 = this.this$0;
            monitor-enter(r5);
        L22:
            th = move-exception;
            throw th;
        L9:
            if (WifiInfoManager.access$100(this.this$0) == true) goto L19;
            Logger.i("WifiInfoManager scan wifi from broadcast");     // Catch: Throwable -> L22
            Object r6 = WifiInfoManager.access$200(this.this$0);     // Catch: Throwable -> L22
            boolean r7 = true;
            if (r14 == true) goto L13;
            boolean r8 = true;
        L14:
            WifiInfoModule r9 = WifiInfoManager.getWifiModule(r13, r6, r8, false, WifiInfoManager.access$300(this.this$0));     // Catch: Throwable -> L22
            WifiInfoManager r10 = this.this$0;     // Catch: Throwable -> L22
            if (r14 == false) goto L18;
            r7 = false;
        L18:
            WifiInfoManager.access$400(r10, r9, r7, false);     // Catch: Throwable -> L22
            goto L19
        L13:
            r8 = false;
        L19:
            monitor-exit(r5);     // Catch: Throwable -> L22
            WifiInfoManager.access$500(this.this$0, r13);
            Logger.i("WifiInfoManager Receiver excutTime:" + ((System.currentTimeMillis() / 1000) - r0) + "--success " + r14);
            return;
        L5:
            r4 = "WifiInfoManager scan wifi from broadcast result is failed.";
            goto L6
        }

        public void onReceive(Context r3, final Intent r4) {
            final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Logger.i("WifiInfoManager wifi scan receive broadcast result");
            WifiInfoManager.access$000(this.this$0).diskIO().execute(new $$Lambda$WifiInfoManager$1$j6o0tEEtLpfmqDWztFxze_4A(this, r4, r5));
        }
    }

    public interface WifiInfoCallback {
        default void onFailed(int r2, String r3) {
            Logger.i(WifiInfoManager.TAG, "get wifiInfos failed, code:" + r2 + "--message:" + r3);
        }

        void onWifiInfo(List<WifiInfo> r1, boolean r2, boolean r3, WifiInfo r4);
    }

    static {
        SparseIntArray r0 = new SparseIntArray();
        sChannelFrequency = r0;
        r0.put(1, 2412);
        sChannelFrequency.put(2, 2417);
        sChannelFrequency.put(3, 2422);
        sChannelFrequency.put(4, 2427);
        sChannelFrequency.put(5, 2432);
        sChannelFrequency.put(6, 2437);
        sChannelFrequency.put(7, 2442);
        sChannelFrequency.put(8, 2447);
        sChannelFrequency.put(9, 2452);
        sChannelFrequency.put(10, 2457);
        sChannelFrequency.put(11, 2462);
        sChannelFrequency.put(12, 2467);
        sChannelFrequency.put(13, 2472);
        sChannelFrequency.put(14, 2484);
        sChannelFrequency.put(36, 5180);
        sChannelFrequency.put(40, 5200);
        sChannelFrequency.put(44, 5220);
        sChannelFrequency.put(48, 5240);
        sChannelFrequency.put(52, 5260);
        sChannelFrequency.put(56, 5280);
        sChannelFrequency.put(60, 5300);
        sChannelFrequency.put(64, 5320);
        sChannelFrequency.put(100, 5500);
        sChannelFrequency.put(104, 5520);
        sChannelFrequency.put(108, 5540);
        sChannelFrequency.put(112, 5560);
        sChannelFrequency.put(116, 5580);
        sChannelFrequency.put(120, 5600);
        sChannelFrequency.put(124, 5620);
        sChannelFrequency.put(128, 5640);
        sChannelFrequency.put(132, 5660);
        sChannelFrequency.put(136, 5680);
        sChannelFrequency.put(140, 5700);
        sChannelFrequency.put(149, 5745);
        sChannelFrequency.put(153, 5765);
        sChannelFrequency.put(157, 5785);
        sChannelFrequency.put(161, 5805);
    }

    public WifiInfoManager() {
        this.mIsNotified = false;
        this.mAppExecutors = AppExecutors.getInstance();
        this.mIsRegisterReceiver = false;
        this.mBpeaCert = null;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mWifiScanReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ AppExecutors access$000(WifiInfoManager r0) {
        return r0.mAppExecutors;
    }

    static /* synthetic */ boolean access$100(WifiInfoManager r0) {
        return r0.mIsNotified;
    }

    static /* synthetic */ Object access$200(WifiInfoManager r0) {
        return r0.mBpeaCert;
    }

    static /* synthetic */ LocationTraceLogger access$300(WifiInfoManager r0) {
        return r0.mTraceLogger;
    }

    static /* synthetic */ void access$400(WifiInfoManager r0, WifiInfoModule r1, boolean r2, boolean r3) {
        r0.notifyWifi(r1, r2, r3);
    }

    static /* synthetic */ void access$500(WifiInfoManager r2, Context r3) {
        r2.unRegisterReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    private static void addScanWifiInfoMonitor(boolean r1, String r2, boolean r3) {
        if (r3 == false) goto L4;
        return;
    L4:
        if (BDLocationConfig.isOpenWifiListMonitor() == false) goto L8;
        Logger.i(LocationMonitorConst.EVENT_CONNECT_WIFI_INFO, "isCache:" + r1 + "--connectWifi:" + r2);
        LocationMonitor.doConnectWifiInfo(r1, r2);
        return;
    }

    private static void addScanWifiListMonitor(boolean r7, List<ScanResult> r8, boolean r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r9 == false) goto L5;
        return;
    L5:
        if (BDLocationConfig.isOpenWifiListMonitor() == false) goto L30;
        ArrayList r11 = new ArrayList(r10);
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "addScanWifiListMonitor start");
        if (r11.isEmpty() == true) goto L20;
        JSONArray r0 = new JSONArray();
        int r2 = 0;
    L11:
        if (r2 >= r11.size()) goto L19;
        ScanResult r3 = (ScanResult) ZeusTransformUtils.preCheckCast(r11.get(r2), ScanResult.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L18;
        JSONObject r4 = new JSONObject();     // Catch: JSONException -> L16
        r4.put("w_ssid", r3.SSID);     // Catch: JSONException -> L16
        r4.put("w_bssid", r3.BSSID);     // Catch: JSONException -> L16
        r4.put("w_rssi", r3.level);     // Catch: JSONException -> L16
        r0.put(r4);     // Catch: JSONException -> L16
    L16:
        e = move-exception;
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "addScanWifiListMonitor JSONException:" + e.toString() + "--scanResult" + r3.toString());
    L18:
        r2 = r2 + 1;
        goto L11
    L19:
        String r12 = r0.toString();
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "isCache:" + r7 + "--scanResults:" + r12 + "--end");
        LocationMonitor.doScanWiFiList(r7, r12);
        return;
    L20:
        LocationMonitor.doScanWiFiList(r7, "");
        return;
    }

    private static boolean checkWifiPolicy(Context r6, WifiInfoModule r7, Object r8, LocationTraceLogger r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.enableScanWifi() == true) goto L7;
        Logger.i("checkWifiPolicy unable scan WiFi");
        return true;
    L7:
        if (r7 != null) goto L10;
        return false;
    L10:
        if (BDLocationConfig.enableCheckConnectWifi() == false) goto L23;
        WifiInfo r1 = r7.connectWifi;
        if (r1 != null) goto L14;
        String r2 = "";
    L21:
        setCacheConnectWifiBSSID(r2);
        goto L23
    L14:
        if (r1.wifiMac.equals(getCacheConnectWifiBSSID()) == true) goto L16;
    L19:
        r2 = r1.wifiMac;
        goto L21
    L16:
        if (r1.rssi <= BDLocationConfig.checkConnectWifiRssi()) goto L19;
        Logger.i("checkWifiPolicy same_connect_wifi");
        LocationMonitor.locationTracePutCategoryData(r9, LocationMonitorConst.SAME_CONNECT_WIFI, true);
        return true;
    L23:
        if (BDLocationConfig.enableCheckRefreshWifiTime() == false) goto L28;
        long r3 = System.currentTimeMillis() - r7.cacheWifiTime;
        Logger.i("checkWifiPolicy wifi_cache_valid cacheWifiInterval:" + r3);
        if (r3 >= BDLocationConfig.checkRefreshWifiTimeInterval()) goto L28;
        Logger.i("checkWifiPolicy wifi_cache_valid");
        LocationMonitor.locationTracePutCategoryData(r9, LocationMonitorConst.WIFI_CACHE_VALID, true);
        return true;
    L28:
        return false;
    }

    private static String getCacheConnectWifiBSSID() {
        return LocationCache.getInstance().getStringValue(CACHE_CONNECT_WIFI_BSSID_KEY);
    }

    private static android.net.wifi.WifiInfo getConnectWifiInfo(Context r2, WifiManager r3, Object r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L19;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (isWifi(r6) == false) goto L21;
        android.net.wifi.WifiInfo r7 = getConnectionInfo(r6, r3, r4, r5);     // Catch: Throwable -> L13
        if (((ConnectivityManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L22;
        if (r7 == null) goto L23;
        if (BDLocationExtrasService.getBPEAManagerWithTag(r5).getSSID(r7, r4) == null) goto L24;
        return r7;
    L24:
        return null;
    L23:
        return null;
    L22:
        return null;
    L13:
        th = move-exception;
        Logger.e("", th);
        return null;
    L21:
        return null;
    L19:
        return null;
    }

    private static android.net.wifi.WifiInfo getConnectionInfo(Context r2, WifiManager r3, Object r4, boolean r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r5 == true) goto L9;
        if (PermissionManager.hasAnyPermission(r6, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L9;
        return null;
    L9:
        return BDLocationExtrasService.getBPEAManagerWithTag(r5).getConnectionInfo(r3, r4);
    }

    public static List<WifiInfo> getWifiInfos(Context r2, Object r3, boolean r4) {
        WifiInfoModule r5 = getWifiModule((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, false, null);
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.wifiInfoList;
    }

    public static WifiInfoModule getWifiModule(Context r25, Object r26, boolean r27, boolean r28, LocationTraceLogger r29) {
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(LocationUtil.getContext((Context) ZeusTransformUtils.wrapperContextForParams(r25, Context.class, "com.obric.memorydata.plugin")), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L107;
        return null;
    L107:
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_WIFI_CACHE_DURATION);     // Catch: Exception -> L97
        WifiManager r12 = (WifiManager) ZeusTransformUtils.preCheckCast(r8.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L97
        if (r12 != null) goto L8;
        return null;
    L8:
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L97
        if (r28 == false) goto L11;
    L14:
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_DURATION);     // Catch: Exception -> L97
        List<ScanResult> r15 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getScanResults(r12, r26);     // Catch: Exception -> L97
        LocationMonitor.locationTraceLogEnd(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_DURATION);     // Catch: Exception -> L97
        if (r15 != null) goto L17;
    L19:
        boolean r16 = false;
    L20:
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.HAS_WIFI_SCAN_RESULTS, Boolean.valueOf(r16));     // Catch: Exception -> L97
        addScanWifiListMonitor(r27, r15, r28);     // Catch: Exception -> L97
    L21:
        StringBuilder r5 = new StringBuilder().append("wifi scan result is null: ");     // Catch: Exception -> L97
        if (r15 != null) goto L24;
        boolean r10 = true;
    L25:
        Logger.i(r5.append(r10).toString());     // Catch: Exception -> L97
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_CONNECT_WIFI_DURATION);     // Catch: Exception -> L97
        android.net.wifi.WifiInfo r6 = getConnectWifiInfo(r8, r12, r26, r28);     // Catch: Exception -> L97
        LocationMonitor.locationTraceLogEnd(r29, LocationMonitorConst.GET_CONNECT_WIFI_DURATION);     // Catch: Exception -> L97
        if (r6 == null) goto L28;
        boolean r9 = true;
    L29:
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.HAS_CONNECT_WIFI, Boolean.valueOf(r9));     // Catch: Exception -> L97
        if (r6 == null) goto L32;
        addScanWifiInfoMonitor(r27, r6.toString(), r28);     // Catch: Exception -> L97
        String r1 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getBSSID(r6, r26);     // Catch: Exception -> L97
    L34:
        if (isValidWifiInfo(r1) == false) goto L45;
        WifiInfo r4 = new WifiInfo();     // Catch: Exception -> L97
        String r0 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getSSID(r6, r26);     // Catch: Exception -> L97
        if (TextUtils.isEmpty(r0) == false) goto L38;
    L40:
        r4.wifiName = r0;     // Catch: Exception -> L97
        r4.wifiMac = r1;     // Catch: Exception -> L97
        r4.rssi = r6.getRssi();     // Catch: Exception -> L97
        r4.isCurrent = 1;     // Catch: Exception -> L97
        r4.timeStamp = WifiUtil.getCurrentTimeSeconds();     // Catch: Exception -> L97
        if (Build.VERSION.SDK_INT < 21) goto L43;
        r4.frequency = r6.getFrequency();     // Catch: Exception -> L97
    L43:
        r13.add(r4);     // Catch: Exception -> L97
    L46:
        if (r15 != null) goto L109;
    L79:
        long r2 = 0;
        long r11 = 0;
    L80:
        long r3 = r11 - r2;     // Catch: Exception -> L95
        WifiInfoModule r7 = new WifiInfoModule(r13, r4, r11);     // Catch: Exception -> L95
        long r14 = System.currentTimeMillis() - r7.cacheWifiTime;     // Catch: Exception -> L95
        long r17 = System.currentTimeMillis() - r2;     // Catch: Exception -> L95
        Logger.i(new StringBuilder().append("WifiInfoManager currentTimeMillis").append(System.currentTimeMillis()).append("--minCacheWifiTime:").append(r2).append("--minCacheWifiInterval:").append(r17).toString());     // Catch: Exception -> L92
        Logger.i("WifiInfoManager maxCacheWifiTime:" + r11 + "--maxCacheWifiInterval:" + r14);     // Catch: Exception -> L92
        LocationTraceLogger r18 = r29;
        LocationMonitor.locationTracePutMetricData(r18, LocationMonitorConst.CACHE_WIFI_INTERVAL, r14);     // Catch: Exception -> L90
        LocationMonitor.locationTracePutMetricData(r18, LocationMonitorConst.MIN_CACHE_WIFI_INTERVAL, r17);     // Catch: Exception -> L90
        LocationMonitor.locationTraceLogEnd(r18, LocationMonitorConst.GET_WIFI_CACHE_DURATION);     // Catch: Exception -> L90
        LocationMonitor.locationTracePutMetricData(r18, LocationMonitorConst.WIFI_CACHE_TIME_DIFFERENCE, r3);     // Catch: Exception -> L90
        LocationMonitor.locationTracePutMetricData(r18, LocationMonitorConst.WIFI_SCAN_RESULTS_NUM, r13.size());     // Catch: Exception -> L90
        String r19 = LocationMonitorConst.GET_WIFI_SCAN_RESULTS_SUCCESS;
        LocationMonitor.locationTracePutCategoryData(r18, r19, true);     // Catch: Exception -> L88
        return r7;
    L88:
        e = e;
    L100:
        boolean r20 = false;
    L101:
        LocationMonitor.locationTracePutCategoryData(r18, r19, Boolean.valueOf(r20));
        LocationMonitor.locationTracePutLogExtra(r18, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_ERROR_MESSAGE, e.getMessage());
        Logger.v(TAG, "WifiInfo: scan exception", e);
        return null;
    L90:
        e = e;
    L94:
        r19 = LocationMonitorConst.GET_WIFI_SCAN_RESULTS_SUCCESS;
    L92:
        e = e;
        r18 = r29;
    L95:
        e = e;
        r18 = r29;
    L99:
        r19 = LocationMonitorConst.GET_WIFI_SCAN_RESULTS_SUCCESS;
        goto L100
    L109:
        if (r15.isEmpty() == true) goto L79;
        int r21 = r15.size();     // Catch: Exception -> L95
        long r22 = 0;
        int r23 = 0;
        long r110 = 0;
    L50:
        if (r23 >= r21) goto L78;
        ScanResult r24 = (ScanResult) ZeusTransformUtils.preCheckCast(r15.get(r23), ScanResult.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L95
        if (r24 == null) goto L77;
        if (TextUtils.isEmpty(r24.SSID) == true) goto L77;
        if (TextUtils.isEmpty(r24.BSSID) == true) goto L77;
        if (r24.capabilities.contains("[IBSS]") == true) goto L77;
        if (r24.BSSID.equalsIgnoreCase(r1) == true) goto L77;
        WifiInfo r111 = new WifiInfo();     // Catch: Exception -> L95
        r111.wifiName = r24.SSID;     // Catch: Exception -> L95
        r111.wifiMac = r24.BSSID;     // Catch: Exception -> L95
        r111.rssi = r24.level;     // Catch: Exception -> L95
        r111.frequency = r24.frequency;     // Catch: Exception -> L95
        r111.isCurrent = 0;     // Catch: Exception -> L74
        if (Build.VERSION.SDK_INT <= 17) goto L73;
        long r210 = r22;
        long r30 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r24.timestamp / 1000);     // Catch: Exception -> L95
        if (r110 != 0) goto L71;
        r110 = r30;
    L72:
        r22 = Math.max(r210, r30);     // Catch: Exception -> L95
        r111.timeStamp = r30 / 1000;     // Catch: Exception -> L95
        goto L73
    L71:
        r110 = Math.min(r110, r30);     // Catch: Exception -> L95
    L73:
        r13.add(r111);     // Catch: Exception -> L95
    L74:
        e = e;
        r20 = false;
        r19 = LocationMonitorConst.GET_WIFI_SCAN_RESULTS_SUCCESS;
        r18 = r29;
    L77:
        r23 = r23 + 1;     // Catch: Exception -> L95
        r1 = r1;
        r21 = r21;
        goto L50
    L78:
        r2 = r110;
        r11 = r22;
        goto L80
    L38:
        if (r0.matches("\".*\"") == false) goto L40;
        r0 = r0.substring(1, r0.length() - 1);     // Catch: Exception -> L97
        goto L40
    L45:
        r4 = null;
        goto L46
    L32:
        addScanWifiInfoMonitor(r27, "", r28);     // Catch: Exception -> L97
        r1 = null;
        goto L34
    L28:
        r9 = false;
        goto L29
    L24:
        r10 = false;
        goto L25
    L17:
        if (r15.isEmpty() == true) goto L19;
        r16 = true;
        goto L20
    L11:
        if (PermissionManager.hasAnyPermission(r8, r29, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L14;
        r15 = null;
    L97:
        e = e;
        r18 = r29;
        goto L99
    }

    private static boolean isValidWifiInfo(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.matches("^[0-9|A-Z|a-z]{2}(:[0-9|A-Z|a-z]{2}){5}$") == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(r2, "02:00:00:00:00:00") == true) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isWifi(Context r3) {
        NetworkInfo r4 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.isAvailable() == false) goto L17;
        if (1 == r4.getType()) goto L12;
        return false;
    L12:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    static /* synthetic */ void lambda$notifyFailed$4(WifiInfoCallback r2, int r3, String r4) {
        ((WifiInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, WifiInfoCallback.class, "com.obric.memorydata.plugin")).onFailed(r3, r4);
    }

    static /* synthetic */ void lambda$notifyFailed$5(WifiInfoCallback r2, int r3, String r4) {
        ((WifiInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, WifiInfoCallback.class, "com.obric.memorydata.plugin")).onFailed(r3, r4);
    }

    static /* synthetic */ void lambda$notifyWifiInfos$2(WifiInfoCallback r2, List r3, boolean r4, boolean r5, WifiInfo r6) {
        ((WifiInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, WifiInfoCallback.class, "com.obric.memorydata.plugin")).onWifiInfo((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    static /* synthetic */ void lambda$notifyWifiInfos$3(WifiInfoCallback r2, List r3, boolean r4, boolean r5, WifiInfo r6) {
        ((WifiInfoCallback) ZeusTransformUtils.wrapperContextForParams(r2, WifiInfoCallback.class, "com.obric.memorydata.plugin")).onWifiInfo((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    private void notifyFailed(final int r4, final String r5) {
        final WifiInfoCallback r0 = this.mWifiInfoCallback;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mWifiInfoCallback = null;
        if (this.mEnableCallbackOnMainThread == false) goto L10;
        Executor r1 = this.mAppExecutors.mainThread();
        Runnable r2 = new $$Lambda$WifiInfoManager$_6DXfQaqf7VQr0PCrdVZMdzHUY(r0, r4, r5);
    L8:
        r1.execute(r2);
    L13:
        this.mEnableCallbackOnMainThread = false;
        return;
    L10:
        if (this.mAppExecutors.isMainThread() == false) goto L12;
        r1 = this.mAppExecutors.diskIO();
        r2 = new $$Lambda$WifiInfoManager$OW0yw4tIU_KeOo6qRDv7nBsxcsM(r0, r4, r5);
        goto L8
    L12:
        r0.onFailed(r4, r5);
        goto L13
    }

    private void notifyWifi(WifiInfoModule r10, boolean r11, boolean r12) {
        List<WifiInfo> r1 = null;
        if (r10 == null) goto L11;
        r1 = r10.wifiInfoList;
        WifiInfo r2 = r10.connectWifi;
        LocationMonitor.locationTracePutCategoryData(this.mTraceLogger, LocationMonitorConst.SCAN_WIFI_TIMEOUT, Boolean.valueOf(r12));
        LocationMonitor.locationTraceLogEnd(this.mTraceLogger, LocationMonitorConst.WIFI_CORE_SCAN_DURATION);
        long r3 = System.currentTimeMillis() - r10.cacheWifiTime;
        if (r10.cacheWifiTime != 0) goto L7;
    L9:
        boolean r13 = true;
    L10:
        Logger.i("notifyWifi isRecommendLocation cacheWifiInterval" + r3);
    L12:
        StringBuilder r4 = new StringBuilder().append("wifiInfoModule is ");
        if (r10 != null) goto L15;
        String r14 = "null";
    L16:
        Logger.i(r4.append(r14).append(", notifyWifi isRecommendWifiResults：").append(r13).toString());
        notifyWifiInfos(r1, r11, r13, r2);
        this.mIsNotified = true;
        return;
    L15:
        r14 = "not null";
        goto L16
    L7:
        if (r3 <= BDLocationConfig.getTailWifiTimeThreshold()) goto L9;
        r13 = false;
        goto L10
    L11:
        r13 = true;
        r2 = null;
        goto L12
    }

    private void notifyWifiInfos(List<WifiInfo> r8, final boolean r9, final boolean r10, final WifiInfo r11) {
        final List<WifiInfo> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        final WifiInfoCallback r1 = this.mWifiInfoCallback;
        if (r1 != null) goto L5;
        return;
    L5:
        this.mWifiInfoCallback = null;
        if (this.mEnableCallbackOnMainThread == false) goto L10;
        Executor r12 = this.mAppExecutors.mainThread();
        Runnable r6 = new $$Lambda$WifiInfoManager$3q54OiBq3NXPnf8cuDBLJK_QEZM(r1, r2, r9, r10, r11);
    L8:
        r12.execute(r6);
    L13:
        this.mEnableCallbackOnMainThread = false;
        return;
    L10:
        if (this.mAppExecutors.isMainThread() == false) goto L12;
        r12 = this.mAppExecutors.diskIO();
        r6 = new $$Lambda$WifiInfoManager$c_RT4sS0cpgr7dHuuh0cNzEpsg(r1, r2, r9, r10, r11);
        goto L8
    L12:
        r1.onWifiInfo(r2, r9, r10, r11);
        goto L13
    }

    private void registerReceiver(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L14:
        Logger.i("WifiInfoManager has register receiver.");
        return;
    L5:
        if (this.mWifiScanReceiver == null) goto L14;
        if (this.mIsRegisterReceiver == true) goto L14;
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L11
        r0.addAction("android.net.wifi.SCAN_RESULTS");     // Catch: Throwable -> L11
        ZeusTransformUtils.registerReceiver(r5, this.mWifiScanReceiver, r0, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        this.mIsRegisterReceiver = true;     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Logger.i("registerReceiver error:" + th.toString());
    }

    private static void setCacheConnectWifiBSSID(String r2) {
        LocationCache.getInstance().setStringValue(CACHE_CONNECT_WIFI_BSSID_KEY, r2);
    }

    private void unRegisterReceiver(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (this.mIsRegisterReceiver == false) goto L15;
        if (r4 == null) goto L16;
        PluginBroadcastReceiver r0 = this.mWifiScanReceiver;
        if (r0 == null) goto L17;
        ZeusTransformUtils.unregisterReceiver(r4, r0, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L11:
        this.mIsRegisterReceiver = false;
        return;
    L9:
        th = move-exception;
        Logger.i("unRegisterReceiver error:" + th.toString());
        goto L11
    L17:
        return;
    L16:
        return;
    }

    public int getChannel(int r1) {
        int r0 = sChannelFrequency.indexOfValue(r1);
        if (r0 >= 0) goto L5;
        return -1;
    L5:
        return sChannelFrequency.keyAt(r0);
    }

    public void getWifiScanInfos(Context r9, WifiInfoCallback r10, Object r11, LocationTraceLogger r12) {
        final Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        WifiInfoCallback r14 = (WifiInfoCallback) ZeusTransformUtils.wrapperContextForParams(r10, WifiInfoCallback.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L6;
        Logger.d("The method getAllWifiInfos of WifiInfoManager is executed and context is null");
        notifyFailed(-1, "context is null.");
        return;
    L6:
        this.mBpeaCert = r11;
        this.mTraceLogger = r12;
        WifiManager r0 = (WifiManager) ZeusTransformUtils.preCheckCast(r13.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");
        registerReceiver(r13);
        this.mWifiInfoCallback = r14;
        this.mIsNotified = false;
        WifiInfoModule r1 = getWifiModule(r13, this.mBpeaCert, true, false, this.mTraceLogger);
        boolean r15 = checkWifiPolicy(r13, r1, r11, r12);
        if (BDLocationConfig.getWifiScanInterval() <= 0) goto L9;
        this.mHandler.postDelayed(new $$Lambda$WifiInfoManager$cnNeQTazOzfg5ekzIeohWvxARPk(this, r13), BDLocationConfig.getWifiScanInterval());
    L9:
        LocationMonitor.locationTracePutCategoryData(this.mTraceLogger, LocationMonitorConst.LIBRA_PARAM_WIFI_SCAN_INTERVAL, Long.valueOf(BDLocationConfig.getWifiScanInterval()));
        LocationMonitor.locationTraceLogBegin(this.mTraceLogger, LocationMonitorConst.WIFI_CORE_SCAN_DURATION);
        if (r15 == false) goto L12;
    L13:
        Logger.i("WifiInfoManager start scan failed.");
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (this.mIsNotified == true) goto L18;
        notifyWifi(r1, true, false);     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L12:
        if (BDLocationExtrasService.getBPEAManager().wifiStartScan(r0, r11) == false) goto L13;
    }

    public /* synthetic */ void lambda$getWifiScanInfos$1$WifiInfoManager(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        this.mAppExecutors.diskIO().execute(new $$Lambda$WifiInfoManager$jpYHaRCWQiUqADF6DiavvljDNec(this, r4));
    }

    public /* synthetic */ void lambda$null$0$WifiInfoManager(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsNotified == true) goto L7;
        Logger.i("WifiInfoManager start scan timeout.");     // Catch: Throwable -> L9
        notifyWifi(getWifiModule(r5, this.mBpeaCert, false, false, this.mTraceLogger), false, true);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);     // Catch: Throwable -> L9
    }
}
