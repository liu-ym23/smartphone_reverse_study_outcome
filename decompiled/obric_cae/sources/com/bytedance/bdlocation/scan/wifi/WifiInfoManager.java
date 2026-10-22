package com.bytedance.bdlocation.scan.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.appcompat.app.r;
import androidx.room.k;
import com.bytedance.bdlocation.LocationUtil;
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
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
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
    private BroadcastReceiver mWifiScanReceiver;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.wifi.WifiInfoManager$1, reason: invalid class name */
    public class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ WifiInfoManager this$0;

        public AnonymousClass1(WifiInfoManager r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass1 r8, Intent r10, Context r11) {
            r8.lambda$onReceive$0(r10, r11);
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r11, Context r12) {
            long r8 = System.currentTimeMillis() / 1000;
            boolean r13 = r11.getBooleanExtra("resultsUpdated", false);
            if (r13 == false) goto L5;
            String r10 = "WifiInfoManager scan wifi from broadcast result is success.";
        L6:
            Logger.i(r10);
            WifiInfoManager r14 = this.this$0;
            monitor-enter(r14);
        L22:
            th = move-exception;
            throw th;
        L9:
            if (WifiInfoManager.access$100(this.this$0) == true) goto L19;
            Logger.i("WifiInfoManager scan wifi from broadcast");     // Catch: Throwable -> L22
            Object r15 = WifiInfoManager.access$200(this.this$0);     // Catch: Throwable -> L22
            boolean r16 = true;
            if (r13 == true) goto L13;
            boolean r17 = true;
        L14:
            WifiInfoModule r18 = WifiInfoManager.getWifiModule(r12, r15, r17, false, WifiInfoManager.access$300(this.this$0));     // Catch: Throwable -> L22
            WifiInfoManager r19 = this.this$0;     // Catch: Throwable -> L22
            if (r13 == false) goto L18;
            r16 = false;
        L18:
            WifiInfoManager.access$400(r19, r18, r16, false);     // Catch: Throwable -> L22
            goto L19
        L13:
            r17 = false;
        L19:
            monitor-exit(r14);     // Catch: Throwable -> L22
            WifiInfoManager.access$500(this.this$0, r12);
            Logger.i("WifiInfoManager Receiver excutTime:" + ((System.currentTimeMillis() / 1000) - r8) + "--success " + r13);
            return;
        L5:
            r10 = "WifiInfoManager scan wifi from broadcast result is failed.";
            goto L6
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context r8, final Intent r10) {
            Logger.i("WifiInfoManager wifi scan receive broadcast result");
            WifiInfoManager.access$000(this.this$0).diskIO().execute(new c(this, r10, r8));
        }
    }

    public interface WifiInfoCallback {
        default void onFailed(int r8, String r10) {
            Logger.i(WifiInfoManager.TAG, "get wifiInfos failed, code:" + r8 + "--message:" + r10);
        }

        void onWifiInfo(List<WifiInfo> r8, boolean r10, boolean r11, WifiInfo r12);
    }

    static {
        SparseIntArray r8 = new SparseIntArray();
        sChannelFrequency = r8;
        r8.put(1, 2412);
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
        sChannelFrequency.put(BWDLInnerConstant.LINK_RECOVERY, 5560);
        sChannelFrequency.put(116, 5580);
        sChannelFrequency.put(120, 5600);
        sChannelFrequency.put(124, 5620);
        sChannelFrequency.put(128, 5640);
        sChannelFrequency.put(132, 5660);
        sChannelFrequency.put(136, 5680);
        sChannelFrequency.put(ApWakeEvent.OTHER_START, 5700);
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

    public static /* synthetic */ void a(WifiInfoCallback r8, List r10, boolean r11, boolean r12, WifiInfo r13) {
        lambda$notifyWifiInfos$2(r8, r10, r11, r12, r13);
    }

    public static /* synthetic */ AppExecutors access$000(WifiInfoManager r8) {
        return r8.mAppExecutors;
    }

    public static /* synthetic */ boolean access$100(WifiInfoManager r8) {
        return r8.mIsNotified;
    }

    public static /* synthetic */ Object access$200(WifiInfoManager r8) {
        return r8.mBpeaCert;
    }

    public static /* synthetic */ LocationTraceLogger access$300(WifiInfoManager r8) {
        return r8.mTraceLogger;
    }

    public static /* synthetic */ void access$400(WifiInfoManager r8, WifiInfoModule r10, boolean r11, boolean r12) {
        r8.notifyWifi(r10, r11, r12);
    }

    public static /* synthetic */ void access$500(WifiInfoManager r8, Context r10) {
        r8.unRegisterReceiver(r10);
    }

    private static void addScanWifiInfoMonitor(boolean r8, String r10, boolean r11) {
        if (r11 == false) goto L4;
        return;
    L4:
        if (BDLocationConfig.isOpenWifiListMonitor() == false) goto L8;
        Logger.i(LocationMonitorConst.EVENT_CONNECT_WIFI_INFO, "isCache:" + r8 + "--connectWifi:" + r10);
        LocationMonitor.doConnectWifiInfo(r8, r10);
        return;
    }

    private static void addScanWifiListMonitor(boolean r8, List<ScanResult> r10, boolean r11) {
        if (r11 == false) goto L4;
        return;
    L4:
        if (BDLocationConfig.isOpenWifiListMonitor() == false) goto L29;
        ArrayList r12 = new ArrayList(r10);
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "addScanWifiListMonitor start");
        if (r12.isEmpty() == true) goto L19;
        JSONArray r13 = new JSONArray();
        int r14 = 0;
    L10:
        if (r14 >= r12.size()) goto L18;
        ScanResult r15 = (ScanResult) r12.get(r14);
        if (r15 == null) goto L17;
        JSONObject r16 = new JSONObject();     // Catch: JSONException -> L15
        r16.put("w_ssid", r15.SSID);     // Catch: JSONException -> L15
        r16.put("w_bssid", r15.BSSID);     // Catch: JSONException -> L15
        r16.put("w_rssi", r15.level);     // Catch: JSONException -> L15
        r13.put(r16);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "addScanWifiListMonitor JSONException:" + e.toString() + "--scanResult" + r15.toString());
    L17:
        r14 = r14 + 1;
        goto L10
    L18:
        String r17 = r13.toString();
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "isCache:" + r8 + "--scanResults:" + r17 + "--end");
    L20:
        LocationMonitor.doScanWiFiList(r8, r17);
        return;
    L19:
        r17 = "";
        goto L20
    }

    public static /* synthetic */ void b(WifiInfoCallback r8, int r10, String r11) {
        lambda$notifyFailed$5(r8, r10, r11);
    }

    public static /* synthetic */ void c(WifiInfoCallback r8, int r10, String r11) {
        lambda$notifyFailed$4(r8, r10, r11);
    }

    private static boolean checkWifiPolicy(Context r8, WifiInfoModule r10, Object r11, LocationTraceLogger r12) {
        if (BDLocationConfig.enableScanWifi() == true) goto L7;
        Logger.i("checkWifiPolicy unable scan WiFi");
        return true;
    L7:
        if (r10 != null) goto L10;
        return false;
    L10:
        if (BDLocationConfig.enableCheckConnectWifi() == false) goto L23;
        WifiInfo r13 = r10.connectWifi;
        if (r13 != null) goto L14;
        String r14 = "";
    L21:
        setCacheConnectWifiBSSID(r14);
        goto L23
    L14:
        if (r13.wifiMac.equals(getCacheConnectWifiBSSID()) == true) goto L16;
    L19:
        r14 = r13.wifiMac;
        goto L21
    L16:
        if (r13.rssi <= BDLocationConfig.checkConnectWifiRssi()) goto L19;
        Logger.i("checkWifiPolicy same_connect_wifi");
        LocationMonitor.locationTracePutCategoryData(r12, LocationMonitorConst.SAME_CONNECT_WIFI, Boolean.TRUE);
        return true;
    L23:
        if (BDLocationConfig.enableCheckRefreshWifiTime() == false) goto L28;
        long r15 = System.currentTimeMillis() - r10.cacheWifiTime;
        Logger.i("checkWifiPolicy wifi_cache_valid cacheWifiInterval:" + r15);
        if (r15 >= BDLocationConfig.checkRefreshWifiTimeInterval()) goto L28;
        Logger.i("checkWifiPolicy wifi_cache_valid");
        LocationMonitor.locationTracePutCategoryData(r12, LocationMonitorConst.WIFI_CACHE_VALID, Boolean.TRUE);
        return true;
    L28:
        return false;
    }

    public static /* synthetic */ void d(WifiInfoCallback r8, List r10, boolean r11, boolean r12, WifiInfo r13) {
        lambda$notifyWifiInfos$3(r8, r10, r11, r12, r13);
    }

    public static /* synthetic */ void e(WifiInfoManager r8, Context r10) {
        r8.lambda$getWifiScanInfos$1(r10);
    }

    public static /* synthetic */ void f(WifiInfoManager r8, Context r10) {
        r8.lambda$null$0(r10);
    }

    private static String getCacheConnectWifiBSSID() {
        return LocationCache.getInstance().getStringValue(CACHE_CONNECT_WIFI_BSSID_KEY);
    }

    private static android.net.wifi.WifiInfo getConnectWifiInfo(Context r8, WifiManager r10, Object r11, boolean r12) {
        if (r8 == null) goto L18;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (isWifi(r8) == false) goto L20;
        android.net.wifi.WifiInfo r13 = getConnectionInfo(r8, r10, r11, r12);     // Catch: Throwable -> L12
        if (((ConnectivityManager) r8.getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L21;
        if (r13 == null) goto L22;
        if (BDLocationExtrasService.getBPEAManagerWithTag(r12).getSSID(r13, r11) == null) goto L23;
        return r13;
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    L12:
        th = move-exception;
        Logger.e("", th);
        return null;
    L20:
        return null;
    L18:
        return null;
    }

    private static android.net.wifi.WifiInfo getConnectionInfo(Context r8, WifiManager r10, Object r11, boolean r12) {
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r12 == true) goto L9;
        if (PermissionManager.hasAnyPermission(r8, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L9;
        return null;
    L9:
        return BDLocationExtrasService.getBPEAManagerWithTag(r12).getConnectionInfo(r10, r11);
    }

    public static List<WifiInfo> getWifiInfos(Context r8, Object r10, boolean r11) {
        WifiInfoModule r12 = getWifiModule(r8, r10, r11, false, null);
        if (r12 != null) goto L5;
        return null;
    L5:
        return r12.wifiInfoList;
    }

    public static WifiInfoModule getWifiModule(Context r25, Object r26, boolean r27, boolean r28, LocationTraceLogger r29) {
        Context r10 = LocationUtil.getContext(r25);
        if (r10 != null) goto L73;
        return null;
    L73:
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_WIFI_CACHE_DURATION);     // Catch: Exception -> L70
        WifiManager r11 = (WifiManager) r10.getSystemService("wifi");     // Catch: Exception -> L70
        if (r11 != null) goto L8;
        return null;
    L8:
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L70
        if (r28 == false) goto L11;
    L14:
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_DURATION);     // Catch: Exception -> L70
        List<ScanResult> r15 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getScanResults(r11, r26);     // Catch: Exception -> L70
        LocationMonitor.locationTraceLogEnd(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_DURATION);     // Catch: Exception -> L70
        if (r15 != null) goto L17;
    L19:
        boolean r16 = false;
    L20:
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.HAS_WIFI_SCAN_RESULTS, Boolean.valueOf(r16));     // Catch: Exception -> L70
        addScanWifiListMonitor(r27, r15, r28);     // Catch: Exception -> L70
    L21:
        StringBuilder r8 = new StringBuilder("wifi scan result is null: ");     // Catch: Exception -> L70
        if (r15 != null) goto L24;
        boolean r13 = true;
    L25:
        r8.append(r13);     // Catch: Exception -> L70
        Logger.i(r8.toString());     // Catch: Exception -> L70
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_CONNECT_WIFI_DURATION);     // Catch: Exception -> L70
        android.net.wifi.WifiInfo r14 = getConnectWifiInfo(r10, r11, r26, r28);     // Catch: Exception -> L70
        LocationMonitor.locationTraceLogEnd(r29, LocationMonitorConst.GET_CONNECT_WIFI_DURATION);     // Catch: Exception -> L70
        if (r14 == null) goto L28;
        boolean r17 = true;
    L29:
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.HAS_CONNECT_WIFI, Boolean.valueOf(r17));     // Catch: Exception -> L70
        if (r14 == null) goto L32;
        addScanWifiInfoMonitor(r27, r14.toString(), r28);     // Catch: Exception -> L70
        String r18 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getBSSID(r14, r26);     // Catch: Exception -> L70
    L34:
        if (isValidWifiInfo(r18) == false) goto L41;
        WifiInfo r19 = new WifiInfo();     // Catch: Exception -> L70
        String r20 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getSSID(r14, r26);     // Catch: Exception -> L70
        if (TextUtils.isEmpty(r20) == false) goto L38;
    L40:
        r19.wifiName = r20;     // Catch: Exception -> L70
        r19.wifiMac = r18;     // Catch: Exception -> L70
        r19.rssi = r14.getRssi();     // Catch: Exception -> L70
        r19.isCurrent = 1;     // Catch: Exception -> L70
        r19.timeStamp = WifiUtil.getCurrentTimeSeconds();     // Catch: Exception -> L70
        r19.frequency = r14.getFrequency();     // Catch: Exception -> L70
        r12.add(r19);     // Catch: Exception -> L70
    L42:
        if (r15 != null) goto L44;
    L67:
        long r21 = 0;
        long r22 = 0;
    L68:
        long r110 = r22 - r21;     // Catch: Exception -> L70
        WifiInfoModule r23 = new WifiInfoModule(r12, r19, r22);     // Catch: Exception -> L70
        long r24 = System.currentTimeMillis() - r23.cacheWifiTime;     // Catch: Exception -> L70
        long r111 = System.currentTimeMillis() - r21;     // Catch: Exception -> L70
        Logger.i("WifiInfoManager currentTimeMillis" + System.currentTimeMillis() + "--minCacheWifiTime:" + r21 + "--minCacheWifiInterval:" + r111);     // Catch: Exception -> L70
        StringBuilder r30 = new StringBuilder();     // Catch: Exception -> L70
        r30.append("WifiInfoManager maxCacheWifiTime:");     // Catch: Exception -> L70
        r30.append(r22);     // Catch: Exception -> L70
        r30.append("--maxCacheWifiInterval:");     // Catch: Exception -> L70
        r30.append(r24);     // Catch: Exception -> L70
        Logger.i(r30.toString());     // Catch: Exception -> L70
        LocationMonitor.locationTracePutMetricData(r29, LocationMonitorConst.CACHE_WIFI_INTERVAL, r24);     // Catch: Exception -> L70
        LocationMonitor.locationTracePutMetricData(r29, LocationMonitorConst.MIN_CACHE_WIFI_INTERVAL, r111);     // Catch: Exception -> L70
        LocationMonitor.locationTraceLogEnd(r29, LocationMonitorConst.GET_WIFI_CACHE_DURATION);     // Catch: Exception -> L70
        LocationMonitor.locationTracePutMetricData(r29, LocationMonitorConst.WIFI_CACHE_TIME_DIFFERENCE, r110);     // Catch: Exception -> L70
        LocationMonitor.locationTracePutMetricData(r29, LocationMonitorConst.WIFI_SCAN_RESULTS_NUM, r12.size());     // Catch: Exception -> L70
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_SUCCESS, Boolean.TRUE);     // Catch: Exception -> L70
        return r23;
    L44:
        if (r15.isEmpty() == true) goto L67;
        int r31 = r15.size();     // Catch: Exception -> L70
        int r32 = 0;
        long r112 = 0;
        long r113 = 0;
    L46:
        if (r32 >= r31) goto L66;
        ScanResult r33 = r15.get(r32);     // Catch: Exception -> L70
        if (r33 != null) goto L50;
    L64:
        r31 = r31;
        r18 = r18;
        long r34 = r112;
        long r35 = r113;
    L65:
        r112 = r34;
        r32 = r32 + 1;     // Catch: Exception -> L70
        r113 = r35;
        r31 = r31;
        r18 = r18;
        goto L46
    L50:
        if (TextUtils.isEmpty(r33.SSID) == true) goto L64;
        if (TextUtils.isEmpty(r33.BSSID) == true) goto L64;
        if (r33.capabilities.contains("[IBSS]") == true) goto L64;
        if (r33.BSSID.equalsIgnoreCase(r18) == true) goto L64;
        WifiInfo r36 = new WifiInfo();     // Catch: Exception -> L70
        r36.wifiName = r33.SSID;     // Catch: Exception -> L70
        r36.wifiMac = r33.BSSID;     // Catch: Exception -> L70
        r36.rssi = r33.level;     // Catch: Exception -> L70
        r36.frequency = r33.frequency;     // Catch: Exception -> L70
        r36.isCurrent = 0;     // Catch: Exception -> L70
        long r114 = r112;
        long r115 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r33.timestamp / 1000);     // Catch: Exception -> L70
        long r37 = r113;
        if (r37 != 0) goto L62;
        r35 = r115;
    L63:
        r34 = Math.max(r114, r115);     // Catch: Exception -> L70
        r36.timeStamp = r115 / 1000;     // Catch: Exception -> L70
        r12.add(r36);     // Catch: Exception -> L70
        goto L65
    L62:
        r35 = Math.min(r37, r115);     // Catch: Exception -> L70
        goto L63
    L66:
        r21 = r113;
        r22 = r112;
        goto L68
    L38:
        if (r20.matches("\".*\"") == false) goto L40;
        r20 = r20.substring(1, r20.length() - 1);     // Catch: Exception -> L70
        goto L40
    L41:
        r19 = null;
        goto L42
    L32:
        addScanWifiInfoMonitor(r27, "", r28);     // Catch: Exception -> L70
        r18 = null;
        goto L34
    L28:
        r17 = false;
        goto L29
    L24:
        r13 = false;
        goto L25
    L17:
        if (r15.isEmpty() == true) goto L19;
        r16 = true;
        goto L20
    L11:
        if (PermissionManager.hasAnyPermission(r10, r29, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L14;
        r15 = null;
    L70:
        e = move-exception;
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_SUCCESS, Boolean.FALSE);
        LocationMonitor.locationTracePutLogExtra(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_ERROR_MESSAGE, e.getMessage());
        Logger.v(TAG, "WifiInfo: scan exception", e);
        return null;
    }

    private static boolean isValidWifiInfo(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return false;
    L6:
        if (r8.matches("^[0-9|A-Z|a-z]{2}(:[0-9|A-Z|a-z]{2}){5}$") == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(r8, "02:00:00:00:00:00") == true) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isWifi(Context r8) {
        NetworkInfo r10 = ((ConnectivityManager) r8.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.isAvailable() == false) goto L17;
        if (1 == r10.getType()) goto L12;
        return false;
    L12:
        return true;
    L17:
        return false;
    L19:
        return false;
    }

    private /* synthetic */ void lambda$getWifiScanInfos$1(Context r8) {
        this.mAppExecutors.diskIO().execute(new k(7, this, r8));
    }

    private static /* synthetic */ void lambda$notifyFailed$4(WifiInfoCallback r8, int r10, String r11) {
        r8.onFailed(r10, r11);
    }

    private static /* synthetic */ void lambda$notifyFailed$5(WifiInfoCallback r8, int r10, String r11) {
        r8.onFailed(r10, r11);
    }

    private static /* synthetic */ void lambda$notifyWifiInfos$2(WifiInfoCallback r8, List r10, boolean r11, boolean r12, WifiInfo r13) {
        r8.onWifiInfo(r10, r11, r12, r13);
    }

    private static /* synthetic */ void lambda$notifyWifiInfos$3(WifiInfoCallback r8, List r10, boolean r11, boolean r12, WifiInfo r13) {
        r8.onWifiInfo(r10, r11, r12, r13);
    }

    private /* synthetic */ void lambda$null$0(Context r8) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsNotified == true) goto L6;
        Logger.i("WifiInfoManager start scan timeout.");     // Catch: Throwable -> L8
        notifyWifi(getWifiModule(r8, this.mBpeaCert, false, false, this.mTraceLogger), false, true);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    private void notifyFailed(int r8, String r10) {
        WifiInfoCallback r11 = this.mWifiInfoCallback;
        if (r11 != null) goto L5;
        return;
    L5:
        this.mWifiInfoCallback = null;
        if (this.mEnableCallbackOnMainThread == false) goto L10;
        Executor r12 = this.mAppExecutors.mainThread();
        Runnable r13 = new n4.d(r11, r8, 1, r10);
    L8:
        r12.execute(r13);
    L13:
        this.mEnableCallbackOnMainThread = false;
        return;
    L10:
        if (this.mAppExecutors.isMainThread() == false) goto L12;
        r12 = this.mAppExecutors.diskIO();
        r13 = new v0.a(r11, r8, 2, r10);
        goto L8
    L12:
        r11.onFailed(r8, r10);
        goto L13
    }

    private void notifyWifi(WifiInfoModule r10, boolean r11, boolean r12) {
        if (r10 == null) goto L11;
        List<WifiInfo> r8 = r10.wifiInfoList;
        WifiInfo r13 = r10.connectWifi;
        LocationMonitor.locationTracePutCategoryData(this.mTraceLogger, LocationMonitorConst.SCAN_WIFI_TIMEOUT, Boolean.valueOf(r12));
        LocationMonitor.locationTraceLogEnd(this.mTraceLogger, LocationMonitorConst.WIFI_CORE_SCAN_DURATION);
        long r14 = System.currentTimeMillis();
        long r15 = r10.cacheWifiTime;
        long r16 = r14 - r15;
        if (r15 != 0) goto L7;
    L9:
        boolean r17 = true;
    L10:
        Logger.i("notifyWifi isRecommendLocation cacheWifiInterval" + r16);
    L12:
        StringBuilder r18 = new StringBuilder("wifiInfoModule is ");
        if (r10 != null) goto L15;
        String r19 = "null";
    L16:
        r18.append(r19);
        r18.append(", notifyWifi isRecommendWifiResults：");
        r18.append(r17);
        Logger.i(r18.toString());
        notifyWifiInfos(r8, r11, r17, r13);
        this.mIsNotified = true;
        return;
    L15:
        r19 = "not null";
        goto L16
    L7:
        if (r16 <= BDLocationConfig.getTailWifiTimeThreshold()) goto L9;
        r17 = false;
        goto L10
    L11:
        r8 = null;
        r17 = true;
        r13 = null;
        goto L12
    }

    private void notifyWifiInfos(final List<WifiInfo> r10, final boolean r11, final boolean r12, final WifiInfo r13) {
        final WifiInfoCallback r8 = this.mWifiInfoCallback;
        if (r8 != null) goto L5;
        return;
    L5:
        this.mWifiInfoCallback = null;
        if (this.mEnableCallbackOnMainThread == false) goto L10;
        Executor r14 = this.mAppExecutors.mainThread();
        Runnable r15 = new a(r8, r10, r11, r12, r13);
    L8:
        r14.execute(r15);
    L13:
        this.mEnableCallbackOnMainThread = false;
        return;
    L10:
        if (this.mAppExecutors.isMainThread() == false) goto L12;
        r14 = this.mAppExecutors.diskIO();
        r15 = new b(r8, r10, r11, r12, r13);
        goto L8
    L12:
        r8.onWifiInfo(r10, r11, r12, r13);
        goto L13
    }

    private void registerReceiver(Context r8) {
        if (r8 != null) goto L4;
    L13:
        Logger.i("WifiInfoManager has register receiver.");
        return;
    L4:
        if (this.mWifiScanReceiver == null) goto L13;
        if (this.mIsRegisterReceiver == true) goto L13;
        IntentFilter r10 = new IntentFilter();     // Catch: Throwable -> L10
        r10.addAction("android.net.wifi.SCAN_RESULTS");     // Catch: Throwable -> L10
        r8.registerReceiver(this.mWifiScanReceiver, r10);     // Catch: Throwable -> L10
        this.mIsRegisterReceiver = true;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Logger.i("registerReceiver error:" + th.toString());
    }

    private static void setCacheConnectWifiBSSID(String r8) {
        LocationCache.getInstance().setStringValue(CACHE_CONNECT_WIFI_BSSID_KEY, r8);
    }

    private void unRegisterReceiver(Context r8) {
        if (this.mIsRegisterReceiver == false) goto L15;
        if (r8 == null) goto L16;
        BroadcastReceiver r10 = this.mWifiScanReceiver;
        if (r10 == null) goto L17;
        r8.unregisterReceiver(r10);     // Catch: Throwable -> L9
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

    public int getChannel(int r8) {
        int r10 = sChannelFrequency.indexOfValue(r8);
        if (r10 >= 0) goto L5;
        return -1;
    L5:
        return sChannelFrequency.keyAt(r10);
    }

    public void getWifiScanInfos(Context r10, WifiInfoCallback r11, Object r12, LocationTraceLogger r13) {
        if (r10 != null) goto L5;
        Logger.d("The method getAllWifiInfos of WifiInfoManager is executed and context is null");
        notifyFailed(-1, "context is null.");
        return;
    L5:
        this.mBpeaCert = r12;
        this.mTraceLogger = r13;
        WifiManager r8 = (WifiManager) r10.getSystemService("wifi");
        registerReceiver(r10);
        this.mWifiInfoCallback = r11;
        this.mIsNotified = false;
        WifiInfoModule r14 = getWifiModule(r10, this.mBpeaCert, true, false, this.mTraceLogger);
        boolean r15 = checkWifiPolicy(r10, r14, r12, r13);
        if (BDLocationConfig.getWifiScanInterval() <= 0) goto L8;
        this.mHandler.postDelayed(new r(6, this, r10), BDLocationConfig.getWifiScanInterval());
    L8:
        LocationMonitor.locationTracePutCategoryData(this.mTraceLogger, LocationMonitorConst.LIBRA_PARAM_WIFI_SCAN_INTERVAL, Long.valueOf(BDLocationConfig.getWifiScanInterval()));
        LocationMonitor.locationTraceLogBegin(this.mTraceLogger, LocationMonitorConst.WIFI_CORE_SCAN_DURATION);
        if (r15 == false) goto L11;
    L12:
        Logger.i("WifiInfoManager start scan failed.");
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.mIsNotified == true) goto L17;
        notifyWifi(r14, true, false);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L11:
        if (BDLocationExtrasService.getBPEAManager().wifiStartScan(r8, r12) == false) goto L12;
    }
}
