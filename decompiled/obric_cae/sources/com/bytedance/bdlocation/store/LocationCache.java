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
        this.mContext = BDLocationConfig.getContext();
    L5:
        Context r8 = this.mContext;
        if (r8 == null) goto L9;
        this.mSharedPreferences = r8.getSharedPreferences("BDLocationCache", 0);
        return;
    }

    private boolean checkCache() {
        if (this.mSharedPreferences != null) goto L8;
        if (BDLocationConfig.getContext() == null) goto L8;
        Logger.i("checkCache: BDLocationConfig.getContext() is null");
        Context r8 = BDLocationConfig.getContext();
        this.mContext = r8;
        this.mSharedPreferences = r8.getSharedPreferences("BDLocationCache", 0);
    L8:
        if (this.mSharedPreferences == null) goto L11;
        return true;
    L11:
        Logger.i("checkCache: mSharedPreferences is null");
        return false;
    }

    private LocationCacheInfo fromCacheInfoJson(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L10;
        return null;
    L10:
        return (LocationCacheInfo) JsonUtil.sGson.c(LocationCacheInfo.class, r8);
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

    private void setLocationCache(LocationCacheInfo r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        String r10 = toCacheInfoJson(r8);
        if (TextUtils.isEmpty(r10) == true) goto L7;
        setStringValue("location_cache", r10);
        setLocateTime(System.currentTimeMillis());
    L7:
        this.mLocationCacheInfo = r8;
    }

    private String toCacheInfoJson(LocationCacheInfo r8) {
        if (r8 != null) goto L9;
    L8:
        return null;
    L9:
        return JsonUtil.sGson.j(r8);
    L6:
        th = move-exception;
        Logger.e("BDLocation", th);
        goto L8
    }

    public void clearLocalLocationCache() {
        removeKey("location_cache");
        this.mLocationCacheInfo = null;
    }

    public void executeLocationCache(BDLocation r8, CacheConditionEntity r10, boolean r11, boolean r12) {
        if (this.mLocationCacheInfo != null) goto L5;
        this.mLocationCacheInfo = getLocationCache();
    L5:
        if (r12 == false) goto L8;
        performLocationChangeNotificationIfNeed(r8);
    L8:
        if (this.mLocationCacheInfo != null) goto L10;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L10:
        this.mLocationCacheInfo.setLatestLocation(r8);
        if (BDLocationConfig.isUseCacheCondition() == false) goto L14;
        if (r10 == null) goto L14;
        this.mLocationCacheInfo.setLatestLocationCacheCondition(r10.getConditionCode());
        this.mLocationCacheInfo.setLatestLocationCacheTime(r8.getLocationMs());
    L14:
        if (r11 == false) goto L17;
        this.mLocationCacheInfo.setNextGpsScanInterval(BDLocationConfig.getGpsScanInterval());
        Logger.i("executeLocationCache: nextGpsScanInterval = " + BDLocationConfig.getGpsScanInterval());
    L17:
        if (BDLocationConfig.enableTailLocateOptimize() == false) goto L19;
        this.mLocationCacheInfo.setRecommendLocation(isRecommendLocation(r8));
    L19:
        Logger.d("ConnectManager:setLatestLocation is executed and location ");
        setLocationCache(this.mLocationCacheInfo);
    }

    public void executeWithoutLocationCache(long r8, CacheConditionEntity r10, boolean r11) {
        if (BDLocationConfig.isUseCacheCondition() == true) goto L5;
        return;
    L5:
        LocationCacheInfo r12 = this.mLocationCacheInfo;
        if (r12 != null) goto L8;
        r12 = getLocationCache();
    L8:
        r12.setLatestLocationCacheCondition(r10.getConditionCode());
        r12.setLatestLocationCacheTime(r8);
        if (r11 == false) goto L11;
        r12.setNextGpsScanInterval(BDLocationConfig.getGpsScanInterval());
        Logger.i("executeWithoutLocationCache: nextGpsScanInterval = " + BDLocationConfig.getGpsScanInterval());
    L11:
        Logger.d("BDLocationCache", "executeWithoutLocationCache");
        setLocationCache(r12);
    }

    public LocationCacheInfo fastGetLocationCacheUnsafe() {
        Logger.i("fastGetLocationCacheUnsafe executed.");
        LocationCacheInfo r8 = this.mLocationCacheInfo;
        if (r8 == null) goto L12;
        return r8;
    L12:
        LocationCacheInfo r10 = fromCacheInfoJson(getStringValue("location_cache"));     // Catch: Throwable -> L9
        if (r10 != null) goto L14;
        return new LocationCacheInfo();
    L14:
        return r10;
    L9:
        th = move-exception;
        Logger.e("fastGetLocationCacheUnsafe error: " + th, th);
        return new LocationCacheInfo();
    }

    public boolean getBooleanValue(String r8) {
        if (checkCache() == true) goto L6;
        return false;
    L6:
        return this.mSharedPreferences.getBoolean(r8, false);
    }

    public int getIntValue(String r8) {
        if (checkCache() == true) goto L6;
        return 0;
    L6:
        return this.mSharedPreferences.getInt(r8, 0);
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

    public long getLongValue(String r8) {
        if (checkCache() == true) goto L6;
        return 0;
    L6:
        return this.mSharedPreferences.getLong(r8, 0);
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

    public String getStringValue(String r8) {
        if (checkCache() == true) goto L6;
        return "";
    L6:
        return this.mSharedPreferences.getString(r8, "");
    }

    public boolean isRecommendLocation(BDLocation r8) {
        if (r8 != null) goto L8;
        String r10 = "isRecommendLocation location is null";
    L5:
        Logger.i(r10);
        return false;
    L8:
        if (PermissionManager.isApproximateLocation(BDLocationConfig.getContext()) == false) goto L12;
        Logger.i("isRecommendLocation is approximate location");
        return true;
    L12:
        if (r8.getLocationType() != 3) goto L14;
        r10 = "isRecommendLocation location type is BASE_STATION";
        goto L5
    L14:
        Logger.i("isRecommendLocation location.getAccuracy = " + r8.getAccuracy());
        if (r8.getAccuracy() <= BDLocationConfig.getTailAccuracyThreshold()) goto L18;
        r10 = "isRecommendLocation accuracy exceeds threshold";
        goto L5
    L18:
        if (r8.isRecommendWifiResults() == true) goto L20;
        r10 = "isRecommendLocation wifi cache time exceeds threshold";
        goto L5
    L20:
        return true;
    }

    public void performLocationChangeNotificationIfNeed(BDLocation r8) {
        LocationCacheInfo r10 = this.mLocationCacheInfo;
        if (r10 != null) goto L6;
        r10 = fromCacheInfoJson(getStringValue("location_cache"));
    L6:
        if (r10 == null) goto L10;
        int r11 = LocationUtil.compareLocation(r10.getLatestLocation(), r8);
        Logger.d("BDLocationCache", "location-trace-core executeLocationCache:compareLocation range:" + r11);
        if (r11 == (-1)) goto L12;
        BDLocationConfig.notificationLocationChange(r11, r8);
        return;
    L12:
        return;
    L10:
        Logger.d("BDLocationCache", "location-trace-core executeLocationCache:mLocationCacheInfo==null");
        BDLocationConfig.notificationLocationChange(0, r8);
    }

    public void removeKey(String r8) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r10 = this.mSharedPreferences.edit();
        r10.remove(r8);
        r10.commit();
    }

    public void setBooleanValue(String r8, boolean r10) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r11 = this.mSharedPreferences.edit();
        r11.putBoolean(r8, r10);
        r11.apply();
    }

    public void setIntValue(String r8, int r10) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r11 = this.mSharedPreferences.edit();
        r11.putInt(r8, r10);
        r11.apply();
    }

    public void setLocateTime(long r8) {
        setLongValue(SHARED_KEY_LOCATE_TIME, r8);
    }

    public void setLocationDenyTime(long r8) {
        setLongValue(SHARED_KEY_LOCATION_DENY_TIME, r8);
    }

    public void setLocationSettings(Context r8, String r10) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mSharedPreferences != null) goto L7;
        this.mSharedPreferences = r8.getSharedPreferences("BDLocationCache", 0);
    L7:
        setStringValue(SHARED_KEY_LOCATION_SETTINGS, r10);
    }

    public void setLongValue(String r8, long r10) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r11 = this.mSharedPreferences.edit();
        r11.putLong(r8, r10);
        r11.apply();
    }

    public void setMockLocation(BDLocation r8) {
        if (this.mLocationCacheInfo != null) goto L6;
        this.mLocationCacheInfo = getLocationCache();
    L6:
        if (this.mLocationCacheInfo != null) goto L8;
        this.mLocationCacheInfo = new LocationCacheInfo();
    L8:
        this.mLocationCacheInfo.setMockLocation(r8);
        setLocationCache(this.mLocationCacheInfo);
    }

    public void setMockWifiName(String r8) {
        setStringValue(SHARED_KEY_MOCK_WIFI_NAME, r8);
    }

    public void setPreciseLatLng(String r8) {
        setStringValue(SHARED_KEY_PRECISE_LATLNG, r8);
    }

    public void setStationarySceneCacheInfo(StationarySceneCacheInfo r8) {
        this.mStationarySceneCacheInfo = r8;
    }

    public void setStringValue(String r8, String r10) {
        if (checkCache() == true) goto L5;
        return;
    L5:
        SharedPreferences.Editor r11 = this.mSharedPreferences.edit();
        r11.putString(r8, r10);
        r11.apply();
    }

    public void executeLocationCache(BDLocation r8, boolean r10, boolean r11) {
        executeLocationCache(r8, null, r10, r11);
    }
}
