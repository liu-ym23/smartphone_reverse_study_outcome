package com.bytedance.bdlocation.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.wifi.WifiInfoModule;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDLightLocationCache {
    private static final String KEY_LAST_LOCATION_TIME = "last_location_time";
    private static final String SHARED_NAME = "BDLightLocationCache";
    private static final Object lightCacheLock = null;
    private static SharedPreferences mSharedPreferences = null;
    private static volatile BaseStation sColdBootBaseStation = null;
    private static volatile String sCurrentStation = null;
    private static volatile boolean sGetCellCache = false;
    private static volatile JSONObject sGetLightLocationMonitorData = null;
    private static volatile boolean sGetWifiCacheList = false;
    private static volatile int sHasLocationPermission = 0;
    private static volatile boolean sIsCellDowngrade = false;
    private static volatile boolean sIsEndRequestCellInfo = false;
    private static volatile boolean sIsEndRequestWifiInfo = false;
    private static volatile boolean sIsStartRequestCellInfo = false;
    private static volatile boolean sIsStartRequestWifiInfo = false;
    private static volatile boolean sIsWifiDowngrade = false;
    private static volatile long sLastLocationTime;
    private static volatile long sLightLocationCacheInterval;
    private static volatile JSONObject sRequestCellUpdateMonitorData;
    private static volatile JSONObject sRequestWifiUpdateMonitorData;
    private static volatile String sWifiCacheList;
    private static volatile WifiInfoModule sWifiInfoModule;

    static {
        sHasLocationPermission = PermissionManager.LOCATION_PERMISSION_UNKNOWN;
        sLightLocationCacheInterval = 0;
        lightCacheLock = new Object();
        sLastLocationTime = -1;
    }

    public BDLightLocationCache() {
    }

    public static JSONObject getAndClearLightLocationMonitorData() {
        if (sGetLightLocationMonitorData != null) goto L5;
        return null;
    L5:
        JSONObject r0 = sGetLightLocationMonitorData;
        sGetLightLocationMonitorData = null;
        return r0;
    }

    public static JSONObject getAndClearRequestCellUpdateMonitorData() {
        if (sRequestCellUpdateMonitorData != null) goto L5;
        return null;
    L5:
        JSONObject r0 = sRequestCellUpdateMonitorData;
        sRequestCellUpdateMonitorData = null;
        return r0;
    }

    public static JSONObject getAndClearRequestWifiCacheUpdateMonitorData() {
        if (sRequestWifiUpdateMonitorData != null) goto L5;
        return null;
    L5:
        JSONObject r0 = sRequestWifiUpdateMonitorData;
        sRequestWifiUpdateMonitorData = null;
        return r0;
    }

    public static BaseStation getColdBootBaseStation() {
        return sColdBootBaseStation;
    }

    public static String getCurrentStation() {
        return sCurrentStation;
    }

    public static long getLastLocationTime(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (sLastLocationTime != (-1)) goto L5;
        Object r0 = lightCacheLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L9:
        if (mSharedPreferences != null) goto L12;
        if (r5 == null) goto L12;
        mSharedPreferences = r5.getSharedPreferences(SHARED_NAME, 0);     // Catch: Throwable -> L19
    L12:
        SharedPreferences r6 = mSharedPreferences;     // Catch: Throwable -> L19
        if (r6 == null) goto L17;
        sLastLocationTime = r6.getLong(KEY_LAST_LOCATION_TIME, 0);     // Catch: Throwable -> L19
        long r1 = sLastLocationTime;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return r1;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return 0;
    L5:
        return sLastLocationTime;
    }

    public static long getLightLocationCacheInterval() {
        return sLightLocationCacheInterval;
    }

    public static String getWifiCacheList() {
        return sWifiCacheList;
    }

    public static WifiInfoModule getWifiCacheModule() {
        return sWifiInfoModule;
    }

    public static int hasLocationPermission() {
        return sHasLocationPermission;
    }

    public static boolean isCellDowngrade() {
        return sIsCellDowngrade;
    }

    public static boolean isEndRequestCellInfo() {
        return sIsEndRequestCellInfo;
    }

    public static boolean isEndRequestWifiInfo() {
        return sIsEndRequestWifiInfo;
    }

    public static boolean isGetCellCache() {
        return sGetCellCache;
    }

    public static boolean isGetWifiCacheList() {
        return sGetWifiCacheList;
    }

    public static boolean isStartRequestCellInfo() {
        return sIsStartRequestCellInfo;
    }

    public static boolean isStartRequestWifiInfo() {
        return sIsStartRequestWifiInfo;
    }

    public static boolean isWifiDowngrade() {
        return sIsWifiDowngrade;
    }

    public static boolean lightLocationNeedCheckCache() {
        if (sLightLocationCacheInterval <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setColdBootBaseStation(BaseStation r0) {
        sColdBootBaseStation = r0;
    }

    public static void setCurrentStation(String r0) {
        sCurrentStation = r0;
    }

    public static void setEndRequestCellInfo(boolean r0) {
        sIsEndRequestCellInfo = r0;
    }

    public static void setEndRequestWifiInfo(boolean r0) {
        sIsEndRequestWifiInfo = r0;
    }

    public static void setHasLocationPermission(int r0) {
        sHasLocationPermission = r0;
    }

    public static void setIsCellDowngrade(boolean r0) {
        sIsCellDowngrade = r0;
    }

    public static void setIsGetCellCache(boolean r0) {
        sGetCellCache = r0;
    }

    public static void setIsGetWifiCacheList(boolean r0) {
        sGetWifiCacheList = r0;
    }

    public static void setIsWifiDowngrade(boolean r0) {
        sIsWifiDowngrade = r0;
    }

    public static void setLastLocationTime(Context r5, long r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        Object r0 = lightCacheLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mSharedPreferences != null) goto L9;
        if (r7 == null) goto L9;
        mSharedPreferences = r7.getSharedPreferences(SHARED_NAME, 0);     // Catch: Throwable -> L16
    L9:
        if (mSharedPreferences != null) goto L11;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        if (sLastLocationTime != (-1)) goto L13;
        sLastLocationTime = mSharedPreferences.getLong(KEY_LAST_LOCATION_TIME, 0);     // Catch: Throwable -> L16
    L13:
        mSharedPreferences.edit().putLong(KEY_LAST_LOCATION_TIME, r6).apply();     // Catch: Throwable -> L16
        Logger.i("setLastLocationTime for light location: " + r6);     // Catch: Throwable -> L16
        goto L14
    }

    public static void setLightLocationCacheInterval(long r0) {
        sLightLocationCacheInterval = r0;
    }

    public static void setLightLocationMonitorData(JSONObject r0) {
        sGetLightLocationMonitorData = r0;
    }

    public static void setRequestCellUpdateMonitorData(JSONObject r0) {
        sRequestCellUpdateMonitorData = r0;
    }

    public static void setRequestWifiCacheUpdateMonitorData(JSONObject r0) {
        sRequestWifiUpdateMonitorData = r0;
    }

    public static void setStartRequestCellInfo(boolean r0) {
        sIsStartRequestCellInfo = r0;
    }

    public static void setStartRequestWifiInfo(boolean r0) {
        sIsStartRequestWifiInfo = r0;
    }

    public static void setWifiCacheList(String r0) {
        sWifiCacheList = r0;
    }

    public static void setWifiCacheModule(WifiInfoModule r0) {
        sWifiInfoModule = r0;
    }
}
