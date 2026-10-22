package com.bytedance.bdlocation.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.entity.CacheConditionEntity;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class LocationCache {
    private static final String SHARED_KEY_LOCATE_TIME = "LocateTime";
    private static final String SHARED_KEY_LOCATION_CACHE = "location_cache";
    private static final String SHARED_KEY_LOCATION_DENY_TIME = "LocationDenyTime";
    private static final String SHARED_KEY_LOCATION_SETTINGS = "bd_location_settings";
    private static final String SHARED_KEY_MOCK_WIFI_NAME = "MockWifiName";
    private static final String SHARED_KEY_PRECISE_LATLNG = "PreciseLatLng";
    private static final String SHARED_NAME = "BDLocationCache";
    private static final String TAG = "BDLocationCache";
    private static LocationCache sInstance;
    private Context mContext;
    private volatile LocationCacheInfo mLocationCacheInfo;
    private SharedPreferences mSharedPreferences;
    private StationarySceneCacheInfo mStationarySceneCacheInfo;

    private LocationCache() {
        if (this.mContext != null) goto L5;
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    L5:
        Context r0 = this.mContext;
        if (r0 == null) goto L9;
        this.mSharedPreferences = r0.getSharedPreferences("BDLocationCache", 0);
        return;
    }

    private boolean checkCache() {
        if (this.mSharedPreferences != null) goto L8;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L8;
        Logger.i("checkCache: BDLocationConfig.getContext() is null");
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mContext = r0;
        this.mSharedPreferences = r0.getSharedPreferences("BDLocationCache", 0);
    L8:
        if (this.mSharedPreferences == null) goto L11;
        return true;
    L11:
        Logger.i("checkCache: mSharedPreferences is null");
        return false;
    }

    private LocationCacheInfo fromCacheInfoJson(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return null;
    L10:
        return (LocationCacheInfo) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(r3, LocationCacheInfo.class), LocationCacheInfo.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Logger.e("BDLocation", th);
        return null;
    }

    public static LocationCache getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(LocationCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LocationCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LocationCache.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void setLocationCache(LocationCacheInfo r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        String r0 = toCacheInfoJson(r3);
        if (TextUtils.isEmpty(r0) == true) goto L7;
        setStringValue("location_cache", r0);
        setLocateTime(System.currentTimeMillis());
    L7:
        this.mLocationCacheInfo = r3;
    }

    private String toCacheInfoJson(LocationCacheInfo r2) {
        if (r2 != null) goto L9;
    L8:
        return null;
    L9:
        return JsonUtil.sGson.toJson(r2);
    L6:
        th = move-exception;
        Logger.e("BDLocation", th);
        goto L8
    }

    public void clearLocalLocationCache() {
        removeKey("location_cache");
        this.mLocationCacheInfo = null;
    }

    public void executeLocationCache(BDLocation r3, CacheConditionEntity r4, boolean r5, boolean r6) {
        if (this.mLocationCacheInfo != null) goto L5;
        this.mLocationCacheInfo = getLocationCache();
    L5:
        if (r6 == false) goto L8;
        performLocationChangeNotificationIfNeed(r3);
    L8:
        if (this.mLocationCacheInfo != null) goto L10;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L10:
        this.mLocationCacheInfo.setLatestLocation(r3);
        if (BDLocationConfig.isUseCacheCondition() == false) goto L14;
        if (r4 == null) goto L14;
        this.mLocationCacheInfo.setLatestLocationCacheCondition(r4.getConditionCode());
        this.mLocationCacheInfo.setLatestLocationCacheTime(r3.getLocationMs());
    L14:
        if (r5 == false) goto L17;
        this.mLocationCacheInfo.setNextGpsScanInterval(BDLocationConfig.getGpsScanInterval());
        Logger.i("executeLocationCache: nextGpsScanInterval = " + BDLocationConfig.getGpsScanInterval());
    L17:
        if (BDLocationConfig.enableTailLocateOptimize() == false) goto L19;
        this.mLocationCacheInfo.setRecommendLocation(isRecommendLocation(r3));
    L19:
        Logger.d("ConnectManager:setLatestLocation is executed and location ");
        setLocationCache(this.mLocationCacheInfo);
    }

    public void executeLocationCache(BDLocation r2, boolean r3, boolean r4) {
        executeLocationCache(r2, null, r3, r4);
    }

    public void executeWithoutLocationCache(long r2, CacheConditionEntity r4, boolean r5) {
        if (BDLocationConfig.isUseCacheCondition() == true) goto L5;
        return;
    L5:
        LocationCacheInfo r0 = this.mLocationCacheInfo;
        if (r0 != null) goto L8;
        r0 = getLocationCache();
    L8:
        r0.setLatestLocationCacheCondition(r4.getConditionCode());
        r0.setLatestLocationCacheTime(r2);
        if (r5 == false) goto L11;
        r0.setNextGpsScanInterval(BDLocationConfig.getGpsScanInterval());
        Logger.i("executeWithoutLocationCache: nextGpsScanInterval = " + BDLocationConfig.getGpsScanInterval());
    L11:
        Logger.d("BDLocationCache", "executeWithoutLocationCache");
        setLocationCache(r0);
    }

    public LocationCacheInfo fastGetLocationCacheUnsafe() {
        Logger.i("fastGetLocationCacheUnsafe executed.");
        LocationCacheInfo r0 = this.mLocationCacheInfo;
        if (r0 == null) goto L12;
        return r0;
    L12:
        LocationCacheInfo r2 = fromCacheInfoJson(getStringValue("location_cache"));     // Catch: Throwable -> L9
        if (r2 != null) goto L14;
        return new LocationCacheInfo();
    L14:
        return r2;
    L9:
        th = move-exception;
        Logger.e("fastGetLocationCacheUnsafe error: " + th, th);
        return new LocationCacheInfo();
    }

    public boolean getBooleanValue(String r3) {
        if (checkCache() == true) goto L6;
        return false;
    L6:
        return this.mSharedPreferences.getBoolean(r3, false);
    }

    public int getIntValue(String r3) {
        if (checkCache() == true) goto L6;
        return 0;
    L6:
        return this.mSharedPreferences.getInt(r3, 0);
    }

    public LocationCacheInfo getLocationCache() {
        Logger.i("getLocationCache start");
        if (this.mLocationCacheInfo != null) goto L6;
        this.mLocationCacheInfo = fromCacheInfoJson(getStringValue("location_cache"));
        Logger.i("getLocationCache fromCacheInfoJson");
    L6:
        if (this.mLocationCacheInfo != null) goto L9;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L9:
        return this.mLocationCacheInfo;
    }

    public long getLocationDenyTime() {
        return getLongValue(SHARED_KEY_LOCATION_DENY_TIME);
    }

    public String getLocationSettings() {
        return getStringValue(SHARED_KEY_LOCATION_SETTINGS);
    }

    public long getLongValue(String r4) {
        if (checkCache() == true) goto L6;
        return 0;
    L6:
        return this.mSharedPreferences.getLong(r4, 0);
    }

    public String getMockWifiName() {
        return getStringValue(SHARED_KEY_MOCK_WIFI_NAME);
    }

    public String getPreciseLatLng() {
        return getStringValue(SHARED_KEY_PRECISE_LATLNG);
    }

    public StationarySceneCacheInfo getStationarySceneCacheInfo() {
        return this.mStationarySceneCacheInfo;
    }

    public String getStringValue(String r3) {
        if (checkCache() == true) goto L6;
        return "";
    L6:
        return this.mSharedPreferences.getString(r3, "");
    }

    public boolean isRecommendLocation(BDLocation r4) {
        if (r4 != null) goto L8;
        String r5 = "isRecommendLocation location is null";
    L5:
        Logger.i(r5);
        return false;
    L8:
        if (PermissionManager.isApproximateLocation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L12;
        Logger.i("isRecommendLocation is approximate location");
        return true;
    L12:
        if (r4.getLocationType() != 3) goto L14;
        r5 = "isRecommendLocation location type is BASE_STATION";
        goto L5
    L14:
        Logger.i("isRecommendLocation location.getAccuracy = " + r4.getAccuracy());
        if (r4.getAccuracy() <= BDLocationConfig.getTailAccuracyThreshold()) goto L18;
        r5 = "isRecommendLocation accuracy exceeds threshold";
        goto L5
    L18:
        if (r4.isRecommendWifiResults() == true) goto L20;
        r5 = "isRecommendLocation wifi cache time exceeds threshold";
        goto L5
    L20:
        return true;
    }

    public void performLocationChangeNotificationIfNeed(BDLocation r4) {
        LocationCacheInfo r0 = this.mLocationCacheInfo;
        if (r0 != null) goto L6;
        r0 = fromCacheInfoJson(getStringValue("location_cache"));
    L6:
        if (r0 == null) goto L10;
        int r1 = LocationUtil.compareLocation(r0.getLatestLocation(), r4);
        Logger.d("BDLocationCache", "location-trace-core executeLocationCache:compareLocation range:" + r1);
        if (r1 == (-1)) goto L12;
        BDLocationConfig.notificationLocationChange(r1, r4);
        return;
    L12:
        return;
    L10:
        Logger.d("BDLocationCache", "location-trace-core executeLocationCache:mLocationCacheInfo==null");
        BDLocationConfig.notificationLocationChange(0, r4);
    }

    public void removeKey(String r2) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.remove(r2);
        r1.commit();
    }

    public void setBooleanValue(String r2, boolean r3) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.putBoolean(r2, r3);
        r1.apply();
    }

    public void setIntValue(String r2, int r3) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.putInt(r2, r3);
        r1.apply();
    }

    public void setLocateTime(long r2) {
        setLongValue(SHARED_KEY_LOCATE_TIME, r2);
    }

    public void setLocationDenyTime(long r2) {
        setLongValue(SHARED_KEY_LOCATION_DENY_TIME, r2);
    }

    public void setLocationSettings(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.mSharedPreferences != null) goto L8;
        this.mSharedPreferences = r5.getSharedPreferences("BDLocationCache", 0);
    L8:
        setStringValue(SHARED_KEY_LOCATION_SETTINGS, r4);
    }

    public void setLongValue(String r2, long r3) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.putLong(r2, r3);
        r1.apply();
    }

    public void setMockLocation(BDLocation r2) {
        if (this.mLocationCacheInfo != null) goto L6;
        this.mLocationCacheInfo = getLocationCache();
    L6:
        if (this.mLocationCacheInfo != null) goto L8;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L8:
        this.mLocationCacheInfo.setMockLocation(r2);
        setLocationCache(this.mLocationCacheInfo);
    }

    public void setMockWifiName(String r2) {
        setStringValue(SHARED_KEY_MOCK_WIFI_NAME, r2);
    }

    public void setPreciseLatLng(String r2) {
        setStringValue(SHARED_KEY_PRECISE_LATLNG, r2);
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r1) {
        this.mStationarySceneCacheInfo = r1;
    }

    public void setStringValue(String r2, String r3) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r1 = this.mSharedPreferences.edit();
        r1.putString(r2, r3);
        r1.apply();
    }
}
