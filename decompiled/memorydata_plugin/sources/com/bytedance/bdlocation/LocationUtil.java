package com.bytedance.bdlocation;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.callback.LightLocationCallback;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.CacheConditionEntity;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BdLBSResult;
import com.bytedance.bdlocation.network.model.DeviceLocation;
import com.bytedance.bdlocation.network.model.DeviceStatus;
import com.bytedance.bdlocation.network.model.GPSResult;
import com.bytedance.bdlocation.network.model.HARStatus;
import com.bytedance.bdlocation.network.model.LocationInfo;
import com.bytedance.bdlocation.network.model.LocationResult;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.Place;
import com.bytedance.bdlocation.network.model.PlaceInfo;
import com.bytedance.bdlocation.network.model.RefreshBaseStationInfo;
import com.bytedance.bdlocation.network.model.RegionCountry;
import com.bytedance.bdlocation.network.model.RegionInfo;
import com.bytedance.bdlocation.network.model.RuralInfo;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.wifi.WifiInfoModule;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.service.SystemBaseLocationImpl;
import com.bytedance.bdlocation.store.BDLightLocationCache;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.store.LocationCacheInfo;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.CollectionUtil;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.bdlocation.utils.HARServiceUtil;
import com.bytedance.bdlocation.utils.NetworkUtil;
import com.bytedance.bdlocation.utils.cell.BaseStationHelper;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.common.utility.h;
import com.bytedance.rpc.model.locationConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class LocationUtil {
    public static final String MOCK_AGENT_CLASS_NAME = "com.bytedance.bdlocation.locationmock.MockAgent";
    public static final String MOCK_AGENT_METHOD_NAME = "isMockEnable";

    private LocationUtil() {
    }

    static /* synthetic */ boolean access$000(Object r0, DeviceLocation r1, LocationTraceLogger r2, RefreshBaseStationInfo r3, LocationOption r4) {
        return getFreshBaseStation(r0, r1, r2, r3, r4);
    }

    static /* synthetic */ void access$100(DeviceLocation r6, DeviceStatus r7, LocationUploadExtra r8, LocationUploadCallback r9, boolean r10, WifiInfo r11) {
        startUploadLocationMustInNetworkIOThreadPool(r6, r7, r8, (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r9, LocationUploadCallback.class, "com.obric.memorydata.plugin"), r10, r11);
    }

    public static BDLocation addressesToBDLocation(List<Address> r2, BDLocation r3, String r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (CollectionUtil.isEmpty(r5) == false) goto L6;
        return null;
    L6:
        BDLocation r0 = new BDLocation(r3);
        r0.setGeocodeSDKName(r4);
        Iterator r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        Address r7 = (Address) ZeusTransformUtils.preCheckCast(r6.next(), Address.class, "com.obric.memorydata.plugin");
        if (r7.hasLatitude() == false) goto L8;
        if (r7.hasLongitude() == false) goto L8;
        r0.setCountry(r7.getCountryName());
        r0.setAdministrativeArea(r7.getAdminArea());
        r0.setSubAdministrativeArea(r7.getSubAdminArea());
        r0.setCity(r7.getLocality());
        r0.setDistrict(r7.getSubLocality());
        r0.setStreet(r7.getThoroughfare());
        r0.setStreetNum(r7.getSubThoroughfare());
        r0.setAddress(r7.getAddressLine(0));
        r0.setPoi(r7.getFeatureName());
    L14:
        return r0;
    }

    private static boolean allowUploadLocationInfo() {
        if (BDLocationConfig.isUploadLocation() == true) goto L8;
        String r0 = "The collection of data is unable upload location!";
    L5:
        Logger.i(r0);
        return false;
    L8:
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L10;
        r0 = "The collection of data is allowed after user confirmed the privacy!";
        goto L5
    L10:
        return true;
    }

    public static String allowUseLocation(boolean r1) {
        return allowUseLocation(true, true, r1);
    }

    public static String allowUseLocation(boolean r0, boolean r1, boolean r2) {
        if (r2 == false) goto L8;
        if (checkBackground() == false) goto L8;
        Logger.i("check allowUseLocation isBackground");
        return BDLocationException.ERROR_BACKGROUND_LOCATE;
    L8:
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L11;
        Logger.i("check allowUseLocation isRestrictedModeOn");
        return BDLocationException.ERROR_RESTRICTED_MODE_ON;
    L11:
        if (r0 == true) goto L13;
    L16:
        if (r1 == true) goto L18;
        return "1";
    L18:
        if (isLocationEnabled() == true) goto L23;
        Logger.i("check allowUseLocation ERROR_DEVICE_LOCATION_DISABLE");
        return BDLocationException.ERROR_DEVICE_LOCATION_DISABLE;
    L23:
        return "1";
    L13:
        if (needLocate() == true) goto L16;
        Logger.i("check allowUseLocation NO_PERMISSION");
        return BDLocationException.ERROR_SDK_NO_PERMISSION;
    }

    public static LocationInfo bdLocationToLocationInfo(BDLocation r5, boolean r6) {
        if (r5 != null) goto L5;
        return null;
    L5:
        LocationInfo r0 = new LocationInfo();
        r0.country = r5.getCountry();     // Catch: Throwable -> L25
        r0.district = r5.getDistrict();     // Catch: Throwable -> L25
        r0.province = r5.getAdministrativeArea();     // Catch: Throwable -> L25
        r0.city = r5.getCity();     // Catch: Throwable -> L25
        r0.address = r5.getAddress();     // Catch: Throwable -> L25
        r0.street = r5.getStreet();     // Catch: Throwable -> L25
        r0.streetNum = r5.getStreetNum();     // Catch: Throwable -> L25
        r0.buildingId = r5.getBuildingId();     // Catch: Throwable -> L25
        r0.floor = r5.getFloor();     // Catch: Throwable -> L25
        if (r6 == false) goto L9;
        r0.latitude = r5.getLatitude();     // Catch: Throwable -> L25
        r0.longitude = r5.getLongitude();     // Catch: Throwable -> L25
    L9:
        r0.timestamp = r5.getTime() / 1000;     // Catch: Throwable -> L25
        r0.locateType = r5.getLocationType();     // Catch: Throwable -> L25
        r0.provider = r5.getLocationSDKName();     // Catch: Throwable -> L25
        r0.altitude = r5.getAltitude();     // Catch: Throwable -> L25
        r0.accuracy = r5.getAccuracy();     // Catch: Throwable -> L25
        r0.coordinateSystem = r5.getCoordinateSystem();     // Catch: Throwable -> L25
        r0.isMock = r5.isMock();     // Catch: Throwable -> L25
        if (Build.VERSION.SDK_INT < 26) goto L12;
        r0.altitudeAccuracy = r5.getVerticalAccuracyMeters();     // Catch: Throwable -> L25
        r0.speedAccuracyMetersPerSecond = r5.getSpeedAccuracyMetersPerSecond();     // Catch: Throwable -> L25
        r0.bearingAccuracyDegrees = r5.getBearingAccuracyDegrees();     // Catch: Throwable -> L25
    L12:
        JSONObject r7 = new JSONObject();     // Catch: Throwable -> L25
        r7.put("bearing", r5.getBearing());     // Catch: Throwable -> L25
        r7.put("speed", r5.getSpeed());     // Catch: Throwable -> L25
        r7.put("trusted_level", r5.getTrustedLevel());     // Catch: Throwable -> L25
        r7.put("location_detail", r5.getLocationDetail());     // Catch: Throwable -> L25
        r7.put("satellites", r5.getSatellites());     // Catch: Throwable -> L25
        r7.put("provider", r5.getProvider());     // Catch: Throwable -> L25
        r7.put("locate_callback_ms", r5.getLocationMs());     // Catch: Throwable -> L25
        r0.extra = r7.toString();     // Catch: Throwable -> L25
        if (Build.VERSION.SDK_INT < 17) goto L16;
        r0.elapsedRealtimeNanos = r5.getElapsedRealtimeNanos();     // Catch: Throwable -> L25
    L16:
        if (Build.VERSION.SDK_INT < 29) goto L19;
        r0.elapsedRealtimeUncertaintyNanos = r5.getElapsedRealtimeUncertaintyNanos();     // Catch: Throwable -> L25
    L19:
        if (r5.getExtras() != null) goto L21;
    L23:
        r0.latitudeWgs84 = r5.latitudeWgs84;     // Catch: Throwable -> L25
        r0.longitudeWgs84 = r5.longitudeWgs84;     // Catch: Throwable -> L25
    L27:
        return r0;
    L21:
        if (r5.getExtras().isEmpty() == true) goto L23;
        r0.sysExtras = r5.getExtras().toString();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();
        goto L27
    }

    public static float calculateLineDistance(BDLocation r5, BDLocation r6) {
        if (r5 == null) goto L7;
        if (r6 != null) goto L6;
        return -1.0f;
    L6:
        return calculateLineDistance(new BDPoint(r5.getLatitude(), r5.getLongitude()), new BDPoint(r6.getLatitude(), r6.getLongitude()));
    L7:
        return -1.0f;
    }

    public static float calculateLineDistance(BDPoint r3, BDPoint r4) {
        BaseLocate r0 = BDLocationExtrasService.getLocate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1);
        if (r0 != null) goto L5;
        return -1.0f;
    L5:
        return r0.calculateLineDistance(r3, r4);
    }

    public static boolean checkBackground() {
        if (BDLocationConfig.enableBackgroundLocation() == false) goto L5;
    L7:
        return false;
    L5:
        if (isBackground() == false) goto L7;
        return true;
    }

    public static void checkBpeaCertNull(String r2, Object r3) {
        LocationMonitor.certNullCheck(r2, r3);
        if (BDLocationConfig.isCheckLocationBpea() == false) goto L8;
        if (r3 != null) goto L9;
        Logger.i(r2 + "check bpea is null");
        throw new BDLocationException(BDLocationExceptionMessage.BPEA_CERT_CHECK_EXCEPTION, "unknown", BDLocationException.ERROR_BPEA_CERT_NULL);
    L9:
        return;
    }

    public static boolean checkCacheTime(long r1, long r3) {
        return checkCacheTime(r1, r3, true);
    }

    public static boolean checkCacheTime(long r6, long r8, boolean r10) {
        if (r6 != 0) goto L5;
        return false;
    L5:
        long r2 = System.currentTimeMillis();
        Logger.i("LocationCache currentTimeMillis:" + r2 + "-locationTime:" + r6 + "-cacheTimeMS:" + r8 + "-needDefaultCache:" + r10);
        if (r10 == false) goto L9;
        r8 = r8 + 5000;
    L9:
        if (Math.abs(r2 - r6) < r8) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean checkGeocode(BDLocation r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r2.getCountry()) == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r2.getAdministrativeArea()) == true) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(r2.getSubAdministrativeArea()) == true) goto L13;
        return true;
    L13:
        if (TextUtils.isEmpty(r2.getCity()) == false) goto L18;
        return false;
    L18:
        return true;
    }

    public static void checkLocationMockEnable() {
    L14:
        e = move-exception;
        Logger.e("checkLocationMockEnable: error", e);
        return;
    L4:
        if (TextUtils.isEmpty(BDLocationConfig.getChannel()) == false) goto L6;
        return;
    L6:
        if (LocationInfoConst.TEST_CHANNEL.contains(BDLocationConfig.getChannel()) == false) goto L19;
        Logger.i("checkLocationMockEnable: channel is test channel:" + BDLocationConfig.getChannel());     // Catch: Exception -> L14
        boolean r3 = false;
        Method r1 = ZeusTransformUtils.forName(MOCK_AGENT_CLASS_NAME, "com.obric.memorydata.plugin").getDeclaredMethod(MOCK_AGENT_METHOD_NAME, new Class[0]);     // Catch: Exception -> L14
        r1.setAccessible(true);     // Catch: Exception -> L14
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Exception -> L14
        if (r2 == null) goto L11;
        r3 = ((Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Exception -> L14
    L11:
        BDLocationConfig.setMockEnable(r3);     // Catch: Exception -> L14
        return;
    }

    public static boolean checkMockCacheTime(BDLocation r7) {
        if (r7 != null) goto L5;
        return false;
    L5:
        long r1 = System.currentTimeMillis();
        if (r7.getMockDuration() != 0) goto L8;
        return true;
    L8:
        if ((r1 - r7.getLocationMs()) <= r7.getMockDuration()) goto L12;
        return false;
    L12:
        return true;
    }

    public static int checkStationaryScenePolicyAfterLocation(BDLocation r6, BDLocation r7, int r8, LocationTraceLogger r9) {
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L6;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: enableStationaryScenePolicy is false");
        return 0;
    L6:
        if (r6 == null) goto L34;
        if (r7 == null) goto L34;
        if (r8 != 1) goto L13;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: stationarySceneWithAoiStatus is disable");
        BDLocationConfig.setOpenStationaryScene(false);
        return 3;
    L13:
        long r2 = r6.getLocationMs() - r7.getLocationMs();
        Logger.i("StationaryScene StationaryScenePolicy AfterLocation: location interval is: " + r2);
        if (r2 <= BDLocationConfig.getStationarySceneMaxInterval()) goto L18;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: location interval is large");
        BDLocationConfig.setOpenStationaryScene(false);
        return 4;
    L18:
        if (connectedValidWiFi(r6, r7, r9) == true) goto L22;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: connectedValidWiFi is false");
        BDLocationConfig.setOpenStationaryScene(false);
        return 5;
    L22:
        if (isHightAccuracyLocation(r6, r7) == true) goto L25;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: isHightAccuracyLocation is false");
        BDLocationConfig.setOpenStationaryScene(false);
        return 6;
    L25:
        float r10 = calculateLineDistance(r6, r7);
        Logger.i("StationaryScene StationaryScenePolicy AfterLocation: location distance is: " + r10);
        if (r10 != (-1.0f)) goto L28;
    L32:
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: location distance is large");
        BDLocationConfig.setOpenStationaryScene(false);
        return 7;
    L28:
        if (r10 > BDLocationConfig.getStationarySceneMaxDistance()) goto L32;
        Logger.i("StationaryScene enable StationaryScenePolicy AfterLocation");
        BDLocationConfig.setOpenStationaryScene(true);
        return 1;
    L34:
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: location is null");
        BDLocationConfig.setOpenStationaryScene(false);
        return 2;
    }

    public static boolean checkStationaryScenePolicyBeforeLocation(String r5, BDLocation r6, LocationTraceLogger r7) {
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L8;
        Logger.i("StationaryScene unable StationaryScenePolicy BeforeLocation");
        int r8 = 0;
    L5:
        LocationMonitor.locationTracePutCategoryData(r7, LocationMonitorConst.CHECK_STATIONARY_SCENE_POLICY_BEFORE_LOCATION, r8);
        return false;
    L8:
        if (BDLocationConfig.isOpenStationaryScene() == true) goto L12;
        Logger.i("StationaryScene unable not OpenStationaryScene BeforeLocation");
        int r9 = 8;
    L10:
        r8 = Integer.valueOf(r9);
        goto L5
    L12:
        if (BDLocationConfig.isInStationarySceneTokenWhiteList(r5) == true) goto L14;
        Logger.i("StationaryScene unable StationarySceneTokenWhiteList BeforeLocation");
        r9 = 9;
        goto L10
    L14:
        long r3 = System.currentTimeMillis() - r6.getLocationMs();
        Logger.i("StationaryScene StationarySceneMaxInterval BeforeLocation:" + r3);
        if (r3 <= BDLocationConfig.getStationarySceneMaxInterval()) goto L17;
        Logger.i("StationaryScene unable StationarySceneMaxInterval BeforeLocation");
        r9 = 4;
        goto L10
    L17:
        Logger.i("StationaryScene enable StationaryScenePolicy BeforeLocation");
        return true;
    }

    public static boolean checkVPN() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L7;
        return false;
    L7:
        return NetworkUtil.checkVPN((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static int compareLocation(BDLocation r1, BDLocation r2) {
        if (r2 != null) goto L4;
        return -1;
    L4:
        if (r2.isEmpty() == true) goto L17;
        if (r1 != null) goto L8;
        return 0;
    L8:
        if (r1.isEmpty() == false) goto L11;
        return 0;
    L11:
        return locationEqual(r1, r2);
    L17:
        return -1;
    }

    public static BDLocation composeGeocodeLocation(BDLocation r3, BDLocation r4) {
        BDLocation r0 = new BDLocation(r3);
        r0.setAddress(r4.getAddress());
        r0.setCity(r4.getCity());
        r0.setAdministrativeArea(r4.getAdministrativeArea());
        r0.setSubAdministrativeArea(r4.getSubAdministrativeArea());
        r0.setProvider(r4.getProvider());
        r0.setDistrict(r4.getDistrict());
        r0.setCountry(r4.getCountry());
        r0.setCityCode(r4.getCityCode());
        r0.setTown(r4.getTown());
        r0.setStreet(r4.getStreet());
        r0.setStreetNum(r4.getStreetNum());
        r0.setFloor(r4.getFloor());
        r0.setThirdPartLocation(r4.getThirdPartLocation());
        r0.setLocationSDKName(r4.getLocationSDKName());
        r0.setPoi(r4.getPoi());
        r0.setGCJ02(r4.getGCJ02());
        r0.setCountryCode(r4.getCountryCode());
        r0.setCountryLocalID(r4.getCountryLocalID());
        r0.setLocalID(r4.getLocalID());
        r0.setDistrictLocalID(r4.getDistrictLocalID());
        r0.setGeoNameID(r4.getGeoNameID());
        r0.setBdLBSResult(r4.getBdLBSResult());
        r0.setLocationResult(r4.getLocationResult());
        r0.setGeocodeSDKName(r4.getGeocodeSDKName());
        r0.setAoi(r4.getAoi());
        r0.setIsDisputed(r4.getIsDisputed());
        r0.setIsCompliance(r4.getIsCompliance());
        r0.setCountryId(r4.getCountryId());
        r0.setSubdivisionId(r4.getSubdivisionId());
        r0.setCityId(r4.getCityId());
        r0.setDistrictId(r4.getDistrictId());
        r0.setTownId(r4.getTownId());
        r0.setCountryAsciName(r4.getCountryAsciName());
        r0.setSubdivisionAsciName(r4.getSubdivisionAsciName());
        r0.setCityAsciName(r4.getCityAsciName());
        r0.setDistrictAsciName(r4.getDistrictAsciName());
        r0.setTownAsciName(r4.getTownAsciName());
        return r0;
    }

    private static boolean connectedValidWiFi(BDLocation r5, BDLocation r6, LocationTraceLogger r7) {
        if (r5 == null) goto L31;
        if (r6 == null) goto L31;
        WifiInfo r8 = r5.getConnectedWifiInfo();
        WifiInfo r9 = r6.getConnectedWifiInfo();
        if (r8 == null) goto L30;
        if (r9 == null) goto L30;
        if (BDLocationConfig.isInStationarySceneWifiWhiteList(r8.wifiName) == false) goto L16;
        Logger.i("StationaryScene unable connectedValidWiFi: wifiName is in white list");
        int r10 = 1;
    L13:
        LocationMonitor.locationTracePutCategoryData(r7, LocationMonitorConst.STATIONARY_SCENE_CONNECTED_WIFI_TYPE, Integer.valueOf(r10));
        return false;
    L16:
        if (r8.wifiMac != null) goto L18;
    L29:
        Logger.i("StationaryScene unable connectedValidWiFi: wifiMac is null");
        r10 = 2;
        goto L13
    L18:
        if (r9.wifiMac == null) goto L29;
        if (NetworkUtil.isMeteredNetworkCapability((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L23;
        Logger.i("StationaryScene unable connectedValidWiFi: isMeteredNetworkCapability is true");
        r10 = 3;
        goto L13
    L23:
        Logger.i("StationaryScene New WifiMac: " + r8.wifiMac + "-Old WifiMac: " + r9.wifiMac);
        boolean r11 = TextUtils.equals(r8.wifiMac, r9.wifiMac);
        if (r11 == false) goto L26;
        int r12 = 4;
    L27:
        LocationMonitor.locationTracePutCategoryData(r7, LocationMonitorConst.STATIONARY_SCENE_CONNECTED_WIFI_TYPE, Integer.valueOf(r12));
        return r11;
    L26:
        r12 = 5;
    L30:
        Logger.i("StationaryScene unable connectedValidWiFi: connectedWifiInfo is null");
        r10 = 7;
    L31:
        Logger.i("StationaryScene unable connectedValidWiFi: location is null");
        r10 = 6;
        goto L13
    }

    public static BDPoint convertGCJ02(BDPoint r3) {
        BaseLocate r0 = BDLocationExtrasService.getLocate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1);
        if (r0 != null) goto L5;
        BaseLocate r1 = BDLocationExtrasService.getLocate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 5);
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.convertGCJ02(r3);
    L5:
        return r0.convertGCJ02(r3);
    }

    public static BDLocation convertLocation(BDLocation r2) {
        if (r2 != null) goto L5;
        return r2;
    L5:
        if (LocationInfoConst.WGS_84.equals(r2.getCoordinateSystem()) == false) goto L8;
        r2.latitudeWgs84 = r2.getLatitude();
        r2.longitudeWgs84 = r2.getLongitude();
    L8:
        if (convertLocationToGCJ_O2(r2, r2.getCoordinateSystem()) == false) goto L10;
        r2.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L10:
        return r2;
    }

    public static boolean convertLocationToGCJ_O2(Location r7, String r8) {
        if (r7 != null) goto L5;
    L20:
        return false;
    L5:
        if (LocationInfoConst.GCJ_O2.equals(r8) == true) goto L20;
        BDPoint r9 = convertGCJ02(new BDPoint(r7.getLatitude(), r7.getLongitude(), r7.getProvider()));
        if (r9 == null) goto L10;
    L12:
        if (r9 == null) goto L20;
        if (ZeusTransformUtils.instanceOf(r7, BDLocation.class) == false) goto L16;
        ((BDLocation) ZeusTransformUtils.preCheckCast(r7, BDLocation.class, "com.obric.memorydata.plugin")).setGCJ02(r9);
    L16:
        double r1 = r9.getLatitude();
        double r3 = r9.getLongitude();
        if (isChineseChannel(r1, r3) == false) goto L20;
        r7.setLatitude(r1);
        r7.setLongitude(r3);
        return true;
    L10:
        if (isChineseRegion(null) == false) goto L12;
        r7.setLatitude(0.0d);
        r7.setLongitude(0.0d);
        goto L20
    }

    public static boolean disableLightLocationIfMockEnabled() {
        if (TextUtils.isEmpty(BDLocationConfig.getChannel()) == false) goto L5;
        return false;
    L5:
        if (LocationInfoConst.TEST_CHANNEL.contains(BDLocationConfig.getChannel()) == false) goto L12;
        Logger.i("disableLightLocationIfMockEnabled test channel:" + BDLocationConfig.getChannel());
        if (getLocationMockEnable((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L13;
        Logger.i("disableLightLocationIfMockEnabled mock enable");
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    public static boolean disableLightLocationIfMockEnabled(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return false;
    L5:
        if (LocationInfoConst.TEST_CHANNEL.contains(r3) == false) goto L12;
        Logger.i("disableLightLocationIfMockEnabled channel:" + r3);
        if (getLocationMockEnable(r4) == false) goto L13;
        Logger.i("disableLightLocationIfMockEnabled mock enable");
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    public static boolean enableContinueLocateUploadSensitiveSignal(LocationOption r3, boolean r4) {
        if (r3 != null) goto L6;
        Logger.i("enableContinueLocateUploadSensitiveSignal locationOption is null");
        return true;
    L6:
        Logger.i("enableContinueLocateUploadSensitiveSignal locationOption isOnceLocation is " + r3.isOnceLocation() + ", enableUploadSignal is " + r4 + ", locateType is " + r3.getLocateType() + ", enableUploadNetSignal is " + r3.enableUploadNetSignal());
        if (r3.isOnceLocation() == true) goto L12;
        if (r3.enableUploadNetSignal() == true) goto L12;
        return false;
    L12:
        if (r3.getLocateType() == 1) goto L15;
        return true;
    L15:
        if (r3.isOnceLocation() == true) goto L20;
        if (r4 == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return true;
    }

    public static boolean enableUseLocation(boolean r1) {
        return "1".equals(allowUseLocation(r1));
    }

    public static BDLocation geoLocationResultToBDLocation(BDLocation r12, BdGisResult r13) {
        if (r13 != null) goto L5;
        return null;
    L5:
        LocationResult r1 = r13.location;
        if (r1 != null) goto L8;
        return null;
    L8:
        if (r12 != null) goto L10;
        BDLocation r14 = new BDLocation("bd_geocode", "unKnown");
        r14.setGeocodeSDKName(SystemBaseLocationImpl.LBS_GEOCODE_NAME);
    L11:
        PlaceInfo r0 = r1.country;
        if (r0 == null) goto L14;
        r14.setCountry(r0.name);
        r14.setCountryCode(r0.code);
        r14.setCountryId(r0.geoNameID);
        r14.setCountryAsciName(r0.asciName);
    L14:
        PlaceInfo[] r2 = r1.subdivisions;
        if (r2 != null) goto L17;
    L19:
        PlaceInfo r4 = r1.city;
        if (r4 == null) goto L22;
        r14.setCity(r4.name);
        r14.setLocalID(r4.localID);
        r14.setGeoNameID(String.valueOf(r4.geoNameID));
        r14.setCityId(r4.geoNameID);
        r14.setCityAsciName(r4.asciName);
    L22:
        PlaceInfo r5 = r1.district;
        if (r5 == null) goto L25;
        r14.setDistrict(r5.name);
        r14.setDistrictId(r5.geoNameID);
        r14.setDistrictAsciName(r5.asciName);
        r14.setDistrictLocalID(r5.localID);
    L25:
        RuralInfo r6 = r1.town;
        if (r6 == null) goto L28;
        r14.setTown(r6.name);
        r14.setTownId(r6.geoNameID);
        r14.setTownAsciName(r6.asciName);
    L28:
        RuralInfo r7 = r1.village;
        if (r7 == null) goto L31;
        r14.setVillage(r7.name);
        r14.setVillageId(r7.geoNameID);
        r14.setVillageAsciName(r7.asciName);
    L31:
        GPSResult r8 = r1.gps;
        if (r8 != null) goto L34;
    L38:
        Place r9 = r1.place;
        if (r9 == null) goto L51;
        if (CollectionUtil.isEmpty(r9.addressLines) == true) goto L44;
        r14.setAddress((String) ZeusTransformUtils.preCheckCast(r9.addressLines.get(0), String.class, "com.obric.memorydata.plugin"));
    L44:
        if (r9.geoAoiList == null) goto L47;
        r14.setGeoAoiList(r9.geoAoiList);
    L47:
        if (r9.geoPoiList == null) goto L49;
        r14.setGeoPoiList(r9.geoPoiList);
    L49:
        r14.setGeoFormattedAddress(r9.geoFormattedAddress);
    L51:
        if (r13.isDisputed == false) goto L58;
        if (r0 != null) goto L58;
        if (r2 != null) goto L58;
        if (r4 != null) goto L58;
        if (r5 != null) goto L58;
        if (r9 != null) goto L58;
        r14 = new BDLocation("", "");
    L58:
        r14.setIsDisputed(r13.isDisputed);
        r14.setIsCompliance(true);
        r14.setLocationResult(r1);
        r14.setServerLocateSuccess(true);
        return r14;
    L34:
        if (r8.latitude == 0.0d) goto L38;
        if (r8.latitude == 0.0d) goto L38;
        r14.setLatitude(r8.latitude);
        r14.setLongitude(r8.longitude);
        r14.setTime(r8.timestamp * 1000);
        r14.setHasServerLatLng(true);
        goto L38
    L17:
        if (r2.length <= 0) goto L19;
        r14.setAdministrativeArea(r2[0].name);
        r14.setSubdivisionId(r2[0].geoNameID);
        r14.setSubdivisionAsciName(r2[0].asciName);
        goto L19
    L10:
        r14 = new BDLocation(r12);
        goto L11
    }

    public static BDLocation geocode(Context r7, BDLocation r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (Geocoder.isPresent() == false) goto L8;
        Locale r0 = BDLocationConfig.getLocale();
        if (r0 != null) goto L10;
        r0 = Locale.getDefault();
    L10:
        return addressesToBDLocation(new Geocoder(r9, r0).getFromLocation(r8.getLatitude(), r8.getLongitude(), 10), r8, LocationInfoConst.SYSTEM);
    L8:
        return null;
    }

    public static int getBackgroundLocationPermissionStatus() {
        return PermissionManager.getBackgroundLocationPermissionStatus((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static BaseStation getBaseStation(Context r5, Object r6, LocationTraceLogger r7, boolean r8, RefreshBaseStationInfo r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        BaseStation r1 = null;
    L7:
        e = move-exception;
        Logger.e("", e);
        return r1;
    L4:
        if (BDLocationConfig.isUploadBaseSite() == false) goto L12;
        long r2 = SystemClock.elapsedRealtime();     // Catch: Exception -> L7
        LocationMonitor.locationTraceLogBegin(r7, LocationMonitorConst.GET_CELL_DURATION);     // Catch: Exception -> L7
        r1 = new BaseStationHelper(r10).getBaseStation(r6, r8, r9);     // Catch: Exception -> L7
        LocationMonitor.locationTraceLogEnd(r7, LocationMonitorConst.GET_CELL_DURATION);     // Catch: Exception -> L7
        LocationMonitor.fetchStationDuration(SystemClock.elapsedRealtime() - r2);     // Catch: Exception -> L7
        Logger.i("locationmonitor basestation duration is: " + (SystemClock.elapsedRealtime() - r2) + "ms");     // Catch: Exception -> L7
        return r1;
    L12:
        return null;
    }

    public static String getCityCodeForChina(BdLBSResult r0) {
        if (r0 == null) goto L9;
        LocationResult r1 = r0.location;
        if (r1 == null) goto L11;
        PlaceInfo r2 = r1.city;
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.localID;
    L11:
        return null;
    L9:
        return null;
    }

    public static String getCityCodeForOverSea(BdLBSResult r2) {
        if (r2 == null) goto L9;
        LocationResult r3 = r2.location;
        if (r3 == null) goto L11;
        PlaceInfo r4 = r3.city;
        if (r4 != null) goto L8;
        return null;
    L8:
        return String.valueOf(r4.geoNameID);
    L11:
        return null;
    L9:
        return null;
    }

    public static Context getContext(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, Application.class) == false) goto L10;
        return r3;
    L10:
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
    }

    public static String getCountryCode(BdLBSResult r0) {
        if (r0 == null) goto L9;
        LocationResult r1 = r0.location;
        if (r1 == null) goto L11;
        PlaceInfo r2 = r1.country;
        if (r2 != null) goto L8;
        return null;
    L8:
        return r2.code;
    L11:
        return null;
    L9:
        return null;
    }

    public static DeviceLocation getDeviceLocation(BDLocation r4, Object r5, LocationTraceLogger r6, RefreshBaseStationInfo r7, LocationOption r8) {
        if (BDLocationConfig.isUploadLocation() == false) goto L18;
        DeviceLocation r0 = new DeviceLocation();
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r8) == false) goto L7;
    L9:
        Logger.i("LocationUtil.getDeviceLocation: skip collect station info.");
    L10:
        if (r4 == null) goto L12;
        r0.sysLocation = bdLocationToLocationInfo(r4, BDLocationConfig.isUploadGPS());
    L12:
        if (r8 != null) goto L14;
    L16:
        String r9 = LocationInfoConst.SINGLE;
    L17:
        r0.locationMode = r9;
        return r0;
    L14:
        if (r8.isOnceLocation() == true) goto L16;
        r9 = LocationInfoConst.CONTINUE;
        goto L17
    L7:
        if (enableContinueLocateUploadSensitiveSignal(r8, BDLocationConfig.isContinueLocateUploadCell()) == false) goto L9;
        r0.baseLocation = getBaseStation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r5, r6, true, r7);
        goto L10
    L18:
        return null;
    }

    public static DeviceStatus getDeviceStatus(Context r4, LocationTraceLogger r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L8;
        LocationMonitor.locationTraceLogBegin(r5, LocationMonitorConst.GET_DEVICE_STATUS_DURATION);
        DeviceStatus r0 = new DeviceStatus();
        r0.deviceType = 2;
        r0.mccmnc = getSimOperator(r6);
        Locale r2 = BDLocationConfig.getLocale();
        if (r2 != null) goto L7;
        r2 = Locale.getDefault();
    L7:
        r0.language = r2.getLanguage();
        r0.region = r2.getCountry();
        r0.locale = r2.toString();
        r0.permission = PermissionManager.checkLocationPermissions(r6, true);
        r0.restrictedMode = BDLocationConfig.getRestrictedMode();
        r0.isStrictRestrictedMode = BDLocationConfig.isStrictRestrictedMode();
        r0.locationMode = getLocationMode(r6);
        r0.bluetoothSwitch = getbluetoothSwitch();
        r0.bluetoothPermission = PermissionManager.checkBluetoothScanPermission(r6);
        r0.isWifiOpen = isWifiOpen();
    L9:
        LocationMonitor.locationTraceLogEnd(r5, LocationMonitorConst.GET_DEVICE_STATUS_DURATION);
        return r0;
    L8:
        r0 = null;
        goto L9
    }

    private static boolean getFreshBaseStation(Object r10, DeviceLocation r11, LocationTraceLogger r12, RefreshBaseStationInfo r13, LocationOption r14) {
        if (enableContinueLocateUploadSensitiveSignal(r14, BDLocationConfig.isContinueLocateUploadCell()) == true) goto L5;
        return false;
    L5:
        if (r13 != null) goto L8;
        Logger.i("getFreshBaseStation refreshBaseStationInfo is null");
        return false;
    L8:
        long r2 = BDLocationConfig.getFreshBaseStationTimeout();
        if (r2 >= 0) goto L36;
        Logger.i("getFreshBaseStation reset freshBaseStationTimeout");
        r2 = 0;
    L36:
        long r4 = System.currentTimeMillis();     // Catch: InterruptedException -> L33
        if (r13.downLatch.await(r2, TimeUnit.MILLISECONDS) == true) goto L15;
        boolean r6 = true;
    L16:
        LocationMonitor.locationTracePutCategoryData(r12, LocationMonitorConst.REFRESH_BASE_STATION_INFO_TIMEOUT, Boolean.valueOf(r6));     // Catch: InterruptedException -> L33
        LocationMonitor.locationTracePutMetricData(r12, LocationMonitorConst.REFRESH_BASE_STATION_INFO_AWAIT_DURATION, System.currentTimeMillis() - r4);     // Catch: InterruptedException -> L33
        LocationMonitor.locationTracePutMetricData(r12, LocationMonitorConst.FRESH_BASE_STATION_TIMEOUT, r2);     // Catch: InterruptedException -> L33
        Logger.i("getFreshBaseStation freshBaseStationTimeout: " + r2 + ", isTimeout: " + r6 + ", await interval: " + (System.currentTimeMillis() - r4));     // Catch: InterruptedException -> L33
        BaseStation r15 = r13.getBaseStation();     // Catch: InterruptedException -> L33
        StringBuilder r3 = new StringBuilder().append("getFreshBaseStation refreshBaseStationInfo.getBaseStation is ");     // Catch: InterruptedException -> L33
        if (r15 != null) goto L19;
        String r5 = "null";
    L20:
        Logger.i(r3.append(r5).toString());     // Catch: InterruptedException -> L33
        if (r6 == false) goto L26;
        Logger.i("getFreshBaseStation refreshBaseStationInfo.downLatch.await is timeout");     // Catch: InterruptedException -> L33
        return true;
    L26:
        if (BDLocationConfig.getBaseStationInfoType() != 1) goto L30;
        if (r15 == null) goto L30;
        Logger.i("getFreshBaseStation get refreshBaseStationInfo");     // Catch: InterruptedException -> L33
        r11.baseLocation = r15;     // Catch: InterruptedException -> L33
        boolean r16 = true;     // Catch: InterruptedException -> L33
    L29:
        LocationMonitor.locationTracePutCategoryData(r12, LocationMonitorConst.ONLY_USE_REFRESH_BASE_STATION_INFO, r16);     // Catch: InterruptedException -> L33
        return false;
    L30:
        Logger.i("getFreshBaseStation get allBaseStationInfo");     // Catch: InterruptedException -> L33
        r11.baseLocation = getBaseStation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10, null, false, null);     // Catch: InterruptedException -> L33
        r16 = false;     // Catch: InterruptedException -> L33
        goto L29
    L19:
        r5 = "not null";
        goto L20
    L15:
        r6 = false;
    L33:
        e = move-exception;
        Logger.e("getFreshBaseStation downLatch.await error:" + e);
        return true;
    }

    public static BdGisResult getGeocodeResult(double r1, double r3, int r5, int r6) {
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L15;
        return null;
    L15:
    L12:
        e = move-exception;
        Logger.i("getGeocodeResult exception:" + e.toString());
        throw new BDLocationException(BDLocationExceptionMessage.GET_GEOCODE_RESULT_ERROR, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_GET_GEOCODE);
    L7:
        if (BDLocationConfig.useNewReverseGeoLocationApi() == false) goto L9;
        BdGisResult r2 = ServerApi.getGisResult(r1, r3, r5, r6);     // Catch: Exception -> L12
    L10:
        Logger.d("GisResult:" + r2);     // Catch: Exception -> L12
        return r2;
    L9:
        r2 = ServerApi.getGisResultOld(r1, r3, r5, r6);     // Catch: Exception -> L12
        goto L10
    }

    public static List<HARStatus> getHARStatusList() {
        return HARServiceUtil.getHARStatusList();
    }

    public static BDLocation getIPResult(int r1) {
        LocationResult r2 = ServerApi.getIPResult(r1);
        if (r2 != null) goto L5;
        return null;
    L5:
        return locationResultToBDLocation(null, r2);
    }

    public static int getInOutDoorStatusInTenMinutes() {
        LocationCacheInfo r0 = LocationCache.getInstance().getLocationCache();
        if (r0 != null) goto L5;
        return 0;
    L5:
        BDLocation r1 = r0.getLatestLocation();
        if (r1 != null) goto L8;
        return 0;
    L8:
        long r2 = r1.getLocationMs();
        if ((System.currentTimeMillis() - r2) <= BDLocationConfig.getInOutDoorStatusCacheTime()) goto L13;
        return 2;
    L13:
        return r1.getInOutDoorStatus();
    }

    public static String getLanguage() {
        Locale r0 = BDLocationConfig.getLocale();
        if (r0 != null) goto L6;
        r0 = Locale.getDefault();
    L6:
        return languageTag(r0);
    }

    public static BaseStation getLightBaseStation(Context r4, Object r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        BaseStation r0 = null;
        if (r6 == false) goto L11;
    L6:
        long r1 = SystemClock.elapsedRealtime();     // Catch: Exception -> L8
        r0 = new BaseStationHelper(r8).getLightBaseStation(r5, r6, r7);     // Catch: Exception -> L8
        Logger.i("locationmonitor basestation duration is: " + (SystemClock.elapsedRealtime() - r1) + "ms");     // Catch: Exception -> L8
        return r0;
    L8:
        e = move-exception;
        Logger.e("", e);
        return r0;
    L11:
        if (BDLocationConfig.isUploadBaseSite() == true) goto L6;
        return null;
    }

    public static DeviceStatus getLightDeviceStatus(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L8;
        DeviceStatus r0 = new DeviceStatus();
        r0.deviceType = 2;
        Locale r1 = BDLocationConfig.getLocale();
        if (r1 != null) goto L7;
        r1 = Locale.getDefault();
    L7:
        r0.language = r1.getLanguage();
        r0.region = r1.getCountry();
        r0.locale = r1.toString();
        r0.permission = 1;
        r0.restrictedMode = BDLocationConfig.getRestrictedMode();
        r0.locationMode = getLocationMode(r4);
        r0.bluetoothSwitch = getbluetoothSwitch();
        r0.bluetoothPermission = PermissionManager.checkBluetoothScanPermission(r4);
        r0.isWifiOpen = isWifiOpen();
        return r0;
    L8:
        return null;
    }

    private static RegionInfo getLocaleRegion() {
        RegionInfo r0 = new RegionInfo();
        Locale r1 = Locale.getDefault();     // Catch: Exception -> L15
        String r2 = r1.getCountry();     // Catch: Exception -> L15
        String r3 = r1.getLanguage();     // Catch: Exception -> L15
        String r4 = r1.toString();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r2) == true) goto L8;
        if (TextUtils.isEmpty(r3) == true) goto L8;
    L13:
        r0.locale = r4;     // Catch: Exception -> L15
        r0.systemRegion = r2;     // Catch: Exception -> L15
        r0.systemLanguage = r3;     // Catch: Exception -> L15
    L17:
        return r0;
    L8:
        if (Build.VERSION.SDK_INT < 24) goto L10;
        Locale r5 = Resources.getSystem().getConfiguration().getLocales().get(0);     // Catch: Exception -> L15
    L11:
        if (r5 == null) goto L13;
        r2 = r5.getCountry();     // Catch: Exception -> L15
        r3 = r5.getLanguage();     // Catch: Exception -> L15
        r4 = r3 + "_" + r2;     // Catch: Exception -> L15
        goto L13
    L10:
        r5 = Resources.getSystem().getConfiguration().locale;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Logger.i("getLocal error" + e.toString());
        goto L17
    }

    public static void getLocationInfoMustInNetworkIOThreadPool(BDLocation r17, final LocationUploadExtra r18, LocationUploadCallback r19) {
        final LocationUploadCallback r10 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r19, LocationUploadCallback.class, "com.obric.memorydata.plugin");
        boolean r1 = true;
        if (r18 == null) goto L5;
        Object r2 = r18.getBpeaCert();
        JsonArray r3 = r18.getWifiData();
        boolean r4 = r18.isWifiCache();
        boolean r5 = r18.isOnceLocation();
        LocationTraceLogger r6 = r18.getLocationTraceLogger();
        boolean r7 = r18.isRecommendWifiResults();
        Object r13 = r2;
        r1 = r5;
        LocationTraceLogger r14 = r6;
        WifiInfo r8 = r18.getConnectedWifiInfo();
        final LocationOption r9 = r18.locationOption;
    L6:
        final DeviceStatus r11 = getDeviceStatus((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r14);
        Logger.i("getLocationInfo isUploadFreshBaseStation: " + BDLocationConfig.isUploadFreshBaseStation());
        LocationMonitor.locationTracePutCategoryData(r14, LocationMonitorConst.IS_UPLOAD_FRESH_BASE_STATION, Boolean.valueOf(BDLocationConfig.isUploadFreshBaseStation()));
        if (r18 != null) goto L9;
        LocationOption r12 = null;
    L11:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r12) == false) goto L13;
    L15:
        Logger.i("LocationUtil.getLocationInfoMustInNetworkIOThreadPool: skip refresh base station info.");
        RefreshBaseStationInfo r15 = null;
    L16:
        if (r18 != null) goto L18;
        LocationOption r16 = null;
    L19:
        final DeviceLocation r110 = getDeviceLocation(r17, r13, r14, r15, r16);
        if (BDLocationConfig.isMockEnable() == false) goto L27;
        if (TextUtils.isEmpty(BDLocationConfig.getMockWifiName()) == true) goto L24;
        r110.wifiInfo = WifiUtil.getMockWifiJson();
    L24:
        r110.baseLocation = null;
        startUploadLocationMustInNetworkIOThreadPool(r110, r11, r18, r10, false, null);
        return;
    L27:
        if (BDLocationConfig.isAsyncScanWifi() == false) goto L38;
        if (r1 == false) goto L38;
        if (r17 == null) goto L38;
        Logger.i("getLocationInfo asyncScanWifi");
        r110.wifiInfo = r3;
        if (BDLocationConfig.isCollectLightInfo() == false) goto L33;
        SensorInfoManager.getInstance().unregisterListener(5);
        r110.lightInfoList = SensorInfoManager.getInstance().getLightInfoList();
    L34:
        if (r4 == false) goto L36;
        String r0 = "true";
    L37:
        r11.isWifiCache = r0;
        startUploadLocationMustInNetworkIOThreadPool(r110, r11, r18, r10, r7, r8);
        return;
    L36:
        r0 = "false";
        goto L37
    L33:
        Logger.i("LocationUtil.getLocationInfoMustInNetworkIOThreadPool: skip light info.");
    L38:
        final long r20 = System.currentTimeMillis();
        Context r21 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        final Object r22 = r13;
        final LocationTraceLogger r23 = r14;
        final RefreshBaseStationInfo r24 = r15;
        WifiUtil.WifiInfoJsonCallback r25 = new AnonymousClass1(r20, r110, r11, r22, r23, r24, r9, r18, r10);
        if (r18 != null) goto L41;
        LocationOption r26 = null;
    L42:
        WifiUtil.getWifiInfoJsonAsync(r21, r25, r13, r14, r26);
        return;
    L41:
        r26 = r18.locationOption;
        goto L42
    L18:
        r16 = r18.locationOption;
        goto L19
    L13:
        if (BDLocationConfig.isUploadFreshBaseStation() == false) goto L15;
        r15 = new RefreshBaseStationInfo();
        goto L16
    L9:
        r12 = r18.locationOption;
        goto L11
    L5:
        r4 = false;
        r7 = true;
        r3 = null;
        r8 = null;
        r9 = null;
        r13 = null;
        r14 = null;
        goto L6
    }

    public static boolean getLocationMockEnable(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L13;
        Logger.i("getLocationMockEnable: context is null");
        return false;
    L13:
        Method r2 = ZeusTransformUtils.forName(MOCK_AGENT_CLASS_NAME, "com.obric.memorydata.plugin").getDeclaredMethod(MOCK_AGENT_METHOD_NAME, new Class[]{Context.class});     // Catch: Exception -> L10
        r2.setAccessible(true);     // Catch: Exception -> L10
        Object r9 = r2.invoke(null, new Object[]{r8});     // Catch: Exception -> L10
        if (r9 == null) goto L15;
        return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L15:
        return false;
    L10:
        e = move-exception;
        Logger.e("getLocationMockEnable: error", e);
        return false;
    }

    public static int getLocationMode(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
    L27:
        th = move-exception;
        Logger.i("LocationUtil getLocationMode exception:" + th.getMessage());
    L29:
        return 0;
    L4:
        if (isLocationEnabled() == true) goto L6;
        return 1;
    L6:
        LocationManager r1 = (LocationManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r1 == null) goto L29;
        List<String> r2 = r1.getProviders(true);     // Catch: Throwable -> L27
        if (r2 == null) goto L29;
        if (r2.isEmpty() == true) goto L29;
        if (r1.isProviderEnabled("gps") == false) goto L15;
        int r3 = 2;
    L17:
        if (r1.isProviderEnabled("network") == false) goto L20;
        r3 = r3 | 4;     // Catch: Throwable -> L27
    L20:
        if (r1.isProviderEnabled("passive") == false) goto L23;
        r3 = r3 | 8;     // Catch: Throwable -> L27
    L23:
        if (PermissionManager.isApproximateLocation(r6) == false) goto L25;
        r3 = r3 | 32;     // Catch: Throwable -> L27
    L25:
        Logger.i("PermissionManager getLocationMode result:" + r3);     // Catch: Throwable -> L27
        return r3;
    L15:
        r3 = 0;
        goto L17
    }

    public static int getMaxHARStatus() {
        return HARServiceUtil.getMaxHARStatus();
    }

    public static String getNetworkOperator(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        TelephonyManager r5 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L9;
        return null;
    L9:
        return r5.getNetworkOperator();
    }

    public static RegionInfo getRegionInfo(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L6;
        return null;
    L6:
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L9;
        RegionInfo r0 = getLocaleRegion();
        String r1 = getSimOperator(r3);
        r0.carrierRegion = r1;
        r0.networkSimRegion = r1;
        r0.mccmnc = getNetworkOperator(r3);
        return r0;
    L9:
        return null;
    }

    public static String getSimOperator(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return null;
    L5:
        TelephonyManager r5 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r4.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L14;
        return null;
    L14:
        if (r5.getSimState() != 5) goto L16;
        return r5.getSimOperator();
    L16:
        return null;
    L17:
        return null;
    }

    public static String getStackTrace() {
        return Log.getStackTraceString(new Exception());
    L4:
        e = move-exception;
        Logger.e("LocationUtil getStackTrace: " + e);
        return "";
    }

    public static int getTargetSdkVersion() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L5;
        return Integer.MAX_VALUE;
    L5:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo() != null) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().targetSdkVersion;
    }

    private static JsonArray getWifiInfoJson() {
        WifiInfoModule r0 = BDLightLocationCache.getWifiCacheModule();
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.wifiInfoList != null) goto L8;
        return null;
    L8:
        if (r0.wifiInfoList.size() <= 0) goto L18;
        JsonElement r1 = JsonUtil.toJsonTreeSafely(r0.wifiInfoList, new AnonymousClass2().getType());     // Catch: Exception -> L14
        if (r1 == null) goto L19;
        return r1.getAsJsonArray();
    L19:
        return null;
    L20:
        return null;
    L18:
        return null;
    }

    public static boolean getbluetoothSwitch() {
        BluetoothAdapter r0 = BluetoothAdapter.getDefaultAdapter();     // Catch: Exception -> L6
        if (r0 == null) goto L12;
        return r0.isEnabled();
    L12:
        return false;
    L6:
        e = move-exception;
        Logger.i("getbluetoothSwitch exception:" + e.toString());
        return false;
    }

    public static boolean isBackground() {
        if (BDLocationConfig.getAppBackgroundProvider() != null) goto L7;
        return true;
    L7:
        return BDLocationConfig.getAppBackgroundProvider().isBackground();
    }

    public static boolean isBetterLocation(Location r1, Location r2) {
        return isBetterLocation(r1, r2, null);
    }

    public static boolean isBetterLocation(Location r8, Location r9, CacheConditionEntity r10) {
        if (r8 != null) goto L7;
        if (r10 == null) goto L6;
        r10.setConditionCode(1);
    L6:
        return false;
    L7:
        if (r9 != null) goto L12;
        if (r10 == null) goto L10;
        r10.setConditionCode(5);
    L10:
        return true;
    L12:
        if (BDLocationConfig.isUseNewCacheStrategy() == true) goto L14;
        long r2 = r8.getTime() - r9.getTime();     // Catch: Exception -> L61
        if (r2 <= 120000) goto L18;
        boolean r4 = true;
    L20:
        if (r2 >= (-120000)) goto L22;
        boolean r5 = true;
    L24:
        if (r2 <= 0) goto L26;
        boolean r3 = true;
    L27:
        if (r4 == false) goto L31;
        if (r10 == null) goto L30;
        r10.setConditionCode(6);     // Catch: Exception -> L61
    L30:
        return true;
    L31:
        if (r5 == false) goto L34;
        Logger.i("CheckNewLocation isSignificantlyOlder");     // Catch: Exception -> L61
        return false;
    L34:
        int r6 = (int) (r8.getAccuracy() - r9.getAccuracy());     // Catch: Exception -> L61
        if (r6 <= 0) goto L37;
        boolean r7 = true;
    L38:
        if (r6 >= 0) goto L40;
        boolean r11 = true;
    L42:
        if (r6 <= 200) goto L44;
        boolean r12 = true;
    L45:
        boolean r13 = isSameProvider(r8.getProvider(), r9.getProvider());     // Catch: Exception -> L61
        if (r11 == false) goto L50;
        if (r10 == null) goto L49;
        r10.setConditionCode(7);     // Catch: Exception -> L61
    L49:
        return true;
    L50:
        if (r3 == false) goto L55;
        if (r7 == true) goto L55;
        if (r10 == null) goto L54;
        r10.setConditionCode(8);     // Catch: Exception -> L61
    L54:
        return true;
    L55:
        if (r3 == false) goto L63;
        if (r12 == true) goto L63;
        if (r13 == false) goto L63;
        if (r10 == null) goto L60;
        r10.setConditionCode(9);     // Catch: Exception -> L61
    L60:
        return true;
    L63:
        return false;
    L44:
        r12 = false;
        goto L45
    L40:
        r11 = false;
        goto L42
    L37:
        r7 = false;
        goto L38
    L26:
        r3 = false;
        goto L27
    L22:
        r5 = false;
        goto L24
    L18:
        r4 = false;
    L61:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L63
    L14:
        return newIsBetterLocation(r8, r9, r10);
    }

    public static boolean isChineseChannel(double r3, double r5) {
        BaseLocate r0 = BDLocationExtrasService.getLocate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), 1);
        if (r0 != null) goto L5;
        return true;
    L5:
        return r0.isAMapDataAvailable(r3, r5);
    }

    public static boolean isChineseRegion(BDLocation r6) {
        if (BDLocationConfig.needDownGradeLocationInOverseas() == true) goto L6;
        Logger.i("needDownGradeLocationInOverseas:" + BDLocationConfig.needDownGradeLocationInOverseas());
        return true;
    L6:
        if (r6 != null) goto L8;
        r6 = LocationCache.getInstance().getLocationCache().getLatestLocation();
    L8:
        boolean r0 = BDLocationConfig.isRegionInChineseChannel();
        if (BDLocationConfig.useGpsCheckRegion() == false) goto L16;
        if (r6 == null) goto L16;
        boolean r7 = isChineseChannel(r6.getLatitude(), r6.getLongitude());
        Logger.i("region check isGpsChineseChannel:" + r7);
        LocationMonitor.gpsCheckRegion(r7, r0);
        if (r7 == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        Logger.i("region check isRegionInChineseChannel:" + r0);
        return r0;
    }

    public static boolean isEmpty(Location r0) {
        if (r0 != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isEnableLocationService(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (isGpsProviderEnabled(r3) == false) goto L5;
    L8:
        return true;
    L5:
        if (isNetworkProviderEnabled(r3) == true) goto L8;
        return false;
    }

    public static boolean isGoodLocation(BDLocation r1) {
        return isGoodLocation(r1, null);
    }

    public static boolean isGoodLocation(BDLocation r6, CacheConditionEntity r7) {
        if (r6 != null) goto L33;
        if (r7 == null) goto L6;
        r7.setConditionCode(1);
    L6:
        return false;
    L33:
        long r2 = Calendar.getInstance().getTimeInMillis();     // Catch: Exception -> L28
        if (BDLocationConfig.isUseNewCacheStrategy() == true) goto L16;
        if ((r2 - r6.getTime()) < 30000) goto L16;
        Logger.i("CheckNewLocation not goodLocation");     // Catch: Exception -> L28
        if (r7 == null) goto L14;
        r7.setConditionCode(10);     // Catch: Exception -> L28
    L14:
        return false;
    L16:
        if (r6.getAccuracy() <= 500.0f) goto L21;
        if (r7 == null) goto L19;
        r7.setConditionCode(11);     // Catch: Exception -> L28
    L19:
        return false;
    L21:
        if (r6.getLocationType() != 3) goto L25;
        if (r7 == null) goto L24;
        r7.setConditionCode(12);     // Catch: Exception -> L28
    L24:
        return false;
    L25:
        if (r7 == null) goto L27;
        r7.setConditionCode(14);
    L27:
        return true;
    L28:
        e = move-exception;
        Logger.i(e.getMessage());
        if (r7 == null) goto L32;
        r7.setConditionCode(13);
    L32:
        return false;
    }

    public static boolean isGpsProviderEnabled(Context r3) {
        LocationManager r4 = (LocationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        return r4.isProviderEnabled("gps");
    L6:
        e = move-exception;
        Logger.i("isProviderEnabled error:" + e.toString());
        LocationMonitor.checkLocationProviderEnabledError(e, "gps");
        return false;
    L12:
        return false;
    }

    private static boolean isHightAccuracyLocation(BDLocation r5, BDLocation r6) {
        if (r5 == null) goto L18;
        if (r6 == null) goto L18;
        int r1 = r5.getLocationType();
        int r2 = r6.getLocationType();
        Logger.i("StationaryScene New LocationType: " + r1 + "-Old LocationType: " + r2 + "-New Location Accuracy: " + r5.getAccuracy() + "-Old Location Accuracy: " + r6.getAccuracy());
        if (r1 == 2) goto L11;
        if (r1 == 1) goto L10;
    L16:
        return false;
    L10:
        if (r5.getAccuracy() >= BDLocationConfig.getStationarySceneMaxGpsAccuracy()) goto L16;
    L11:
        if (r2 == 2) goto L17;
        if (r2 != 1) goto L16;
        if (r6.getAccuracy() >= BDLocationConfig.getStationarySceneMaxGpsAccuracy()) goto L16;
    L17:
        return true;
    L18:
        return false;
    }

    public static boolean isLocationEnabled() {
        if (Build.VERSION.SDK_INT < 28) goto L10;
        return ((LocationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin")).isLocationEnabled();
    L6:
        e = move-exception;
        Logger.e("location enable status error", e.getMessage());
        return false;
    L10:
        if (Build.VERSION.SDK_INT < 19) goto L19;
        if (Settings.Secure.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), LocationMonitorConst.LOCATION_MODE) != 0) goto L14;
        return false;
    L14:
        return true;
    L15:
        e = move-exception;
        e.printStackTrace();
        return false;
    L19:
        return !TextUtils.isEmpty(Settings.Secure.getString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "location_providers_allowed"));
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNeedAddress(LocationOption r0) {
        if (r0 != null) goto L4;
        return true;
    L4:
        if (r0.getGeocodeMode() != 0) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean isNetworkProviderEnabled(Context r3) {
        LocationManager r4 = (LocationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L12;
        return r4.isProviderEnabled("network");
    L6:
        e = move-exception;
        Logger.e("isNetworkProviderEnabled error:" + e);
        LocationMonitor.checkLocationProviderEnabledError(e, "network");
        return false;
    L12:
        return false;
    }

    public static boolean isProxy() {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L7;
        return false;
    L7:
        return NetworkUtil.isWifiProxy((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    private static boolean isRegionInChineseChannel(String r1) {
        if (BDLocationConfig.getRedGeoNameIds().contains(r1) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean isSameProvider(String r0, String r1) {
        if (r0 != null) goto L8;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r0.equals(r1);
    }

    public static boolean isTargetBrand(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L10;
        StringBuilder r0 = new StringBuilder().append("isTargetDevice ");
        if (r5 != null) goto L7;
        String r6 = "targetBrand = null";
    L8:
        Logger.i(r0.append(r6).toString());
        return false;
    L7:
        r6 = "targetBrand is empty";
        goto L8
    L10:
        String r1 = Build.MANUFACTURER;
        String r2 = Build.BRAND;
        Logger.i("isTargetDevice Build.MANUFACTURER: " + r1 + " Build.BRAND: " + r2);
        if (r5.equalsIgnoreCase(r1) == false) goto L13;
    L14:
        return true;
    L13:
        if (r5.equalsIgnoreCase(r2) == true) goto L14;
        return false;
    }

    public static boolean isUseByteLocationPolicy(String r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (LocationInfoConst.LIBRA_PARAM_V1.equals(BDLocationConfig.getByteLocationLibraParam()) == true) goto L10;
        if (LocationInfoConst.LIBRA_PARAM_V2.equals(BDLocationConfig.getByteLocationLibraParam()) == true) goto L10;
        return false;
    L10:
        if (BDLocationConfig.getByteLocationWhiteList().contains(r3) == true) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean isUseByteLocationPolicyV2(String r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (LocationInfoConst.LIBRA_PARAM_V2.equals(BDLocationConfig.getByteLocationLibraParam()) == true) goto L8;
        return false;
    L8:
        if (BDLocationConfig.getByteLocationWhiteList().contains(r3) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isWifiOpen() {
        WifiManager r0 = (WifiManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI), WifiManager.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L7
        if (r0 == null) goto L13;
        return r0.isWifiEnabled();
    L13:
        return false;
    L7:
        e = move-exception;
        Logger.i("isWifiOpen exception:" + e.toString());
        return false;
    }

    static /* synthetic */ void lambda$startCacheLocateInfoUpload$1(LocationUploadExtra r2, LocationUploadCallback r3) {
        LocationUploadCallback r4 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r3, LocationUploadCallback.class, "com.obric.memorydata.plugin");
    L7:
        e = move-exception;
        Logger.e("startCacheLocateInfoUpload", e);
        if (r4 == null) goto L15;
        r4.onError(e.getMessage());
        return;
    L15:
        return;
    L4:
        if (allowUploadLocationInfo() == false) goto L14;
        uploadCacheLocationInfo(r2, r4);     // Catch: Exception -> L7
        return;
    }

    static /* synthetic */ void lambda$startGetLocate$2(LocationUploadExtra r2, LocationUploadCallback r3) {
        getLocationInfoMustInNetworkIOThreadPool(null, r2, (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r3, LocationUploadCallback.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void lambda$startLocateUpload$0(BDLocation r2, LocationUploadExtra r3, LocationUploadCallback r4) {
        LocationUploadCallback r5 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r4, LocationUploadCallback.class, "com.obric.memorydata.plugin");
    L7:
        e = move-exception;
        Logger.e("startLocateUpload", e);
        if (r5 == null) goto L15;
        r5.onError(e.getMessage());
        return;
    L15:
        return;
    L4:
        if (allowUploadLocationInfo() == false) goto L14;
        getLocationInfoMustInNetworkIOThreadPool(r2, r3, r5);     // Catch: Exception -> L7
        return;
    }

    public static String languageTag(Locale r2) {
        if (r2 != null) goto L5;
        return "";
    L5:
        String r0 = r2.getLanguage();
        String r3 = r2.getCountry();
        if (TextUtils.isEmpty(r3) == false) goto L8;
        return r0;
    L8:
        return r0 + "-" + r3;
    }

    private static int locationEqual(BDLocation r8, BDLocation r9) {
        LocationResult r0 = r8.getLocationResult();
        LocationResult r1 = r9.getLocationResult();
        if (r0 == null) goto L45;
        if (r1 != null) goto L7;
        return -1;
    L7:
        if (r0.country != null) goto L9;
    L13:
        PlaceInfo[] r2 = r0.subdivisions;
        PlaceInfo[] r4 = r1.subdivisions;
        if (r2 == null) goto L28;
        if (r4 == null) goto L28;
        if (r2.length <= 0) goto L28;
        if (r4.length <= 0) goto L28;
        PlaceInfo r3 = r0.subdivisions[0];
        PlaceInfo r5 = r1.subdivisions[0];
        if (r3 == null) goto L28;
        if (r5 == null) goto L28;
        if (r3.geoNameID == r5.geoNameID) goto L28;
        return 1;
    L28:
        if (r0.city == null) goto L36;
        if (r1.city == null) goto L36;
        if (r0.city.geoNameID == r1.city.geoNameID) goto L36;
        return 2;
    L36:
        if (r0.district == null) goto L44;
        if (r1.district == null) goto L44;
        if (r0.district.geoNameID == r1.district.geoNameID) goto L44;
        return 3;
    L44:
        return locationNameEqual(r8, r9);
    L9:
        if (r1.country == null) goto L13;
        if (r0.country.geoNameID == r1.country.geoNameID) goto L13;
        return 0;
    L45:
        return -1;
    }

    private static int locationNameEqual(BDLocation r2, BDLocation r3) {
        if (h.a(r2.getCountry(), r3.getCountry()) == true) goto L11;
        if (TextUtils.isEmpty(r2.getCountry()) == true) goto L11;
        if (TextUtils.isEmpty(r3.getCountry()) == true) goto L11;
        return 0;
    L11:
        if (h.a(r2.getAdministrativeArea(), r3.getAdministrativeArea()) == true) goto L19;
        if (TextUtils.isEmpty(r2.getAdministrativeArea()) == true) goto L19;
        if (TextUtils.isEmpty(r3.getAdministrativeArea()) == true) goto L19;
        return 1;
    L19:
        if (h.a(r2.getCity(), r3.getCity()) == true) goto L27;
        if (TextUtils.isEmpty(r2.getCity()) == true) goto L27;
        if (TextUtils.isEmpty(r3.getCity()) == true) goto L27;
        return 2;
    L27:
        if (h.a(r2.getDistrict(), r3.getDistrict()) == true) goto L35;
        if (TextUtils.isEmpty(r2.getDistrict()) == true) goto L35;
        if (TextUtils.isEmpty(r3.getDistrict()) == true) goto L35;
        return 3;
    L35:
        if (h.a(r2.getSubAdministrativeArea(), r3.getSubAdministrativeArea()) == false) goto L37;
        return -1;
    L37:
        if (TextUtils.isEmpty(r2.getSubAdministrativeArea()) == false) goto L39;
        return -1;
    L39:
        if (TextUtils.isEmpty(r3.getSubAdministrativeArea()) == true) goto L45;
        return 4;
    L45:
        return -1;
    }

    public static BDLocation locationResultToBDLocation(BDLocation r2, LocationResult r3) {
        return locationResultToBDLocation(r2, r3, 0, -1.0f);
    }

    public static BDLocation locationResultToBDLocation(BDLocation r11, LocationResult r12, int r13, float r14) {
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
        BDLocation r15 = new BDLocation("bd_geocode", "unKnown");
        r15.setGeocodeSDKName(SystemBaseLocationImpl.LBS_GEOCODE_NAME);
    L8:
        PlaceInfo r0 = r12.country;
        if (r0 == null) goto L11;
        r15.setCountry(r0.name);
        r15.setCountryCode(r0.code);
        r15.setCountryId(r0.geoNameID);
        r15.setCountryAsciName(r0.asciName);
        r15.setCountryLocalID(r0.localID);
    L11:
        Place r1 = r12.place;
        if (r1 != null) goto L14;
    L16:
        PlaceInfo[] r3 = r12.subdivisions;
        if (r3 == null) goto L22;
        if (r3.length <= 0) goto L22;
        r15.setAdministrativeArea(r3[0].name);
        r15.setSubdivisionId(r3[0].geoNameID);
        r15.setSubdivisionAsciName(r3[0].asciName);
    L22:
        if (r3 != null) goto L24;
    L26:
        PlaceInfo r4 = r12.city;
        if (r4 == null) goto L29;
        r15.setCity(r4.name);
        r15.setLocalID(r4.localID);
        r15.setGeoNameID(String.valueOf(r4.geoNameID));
        r15.setCityId(r4.geoNameID);
        r15.setCityAsciName(r4.asciName);
    L29:
        PlaceInfo r5 = r12.district;
        if (r5 == null) goto L32;
        r15.setDistrict(r5.name);
        r15.setDistrictId(r5.geoNameID);
        r15.setDistrictAsciName(r5.asciName);
        r15.setDistrictLocalID(r5.localID);
    L32:
        RuralInfo r6 = r12.town;
        if (r6 == null) goto L35;
        r15.setTown(r6.name);
        r15.setTownId(r6.geoNameID);
        r15.setTownAsciName(r6.asciName);
    L35:
        RuralInfo r7 = r12.village;
        if (r7 == null) goto L38;
        r15.setVillage(r7.name);
        r15.setVillageId(r7.geoNameID);
        r15.setVillageAsciName(r7.asciName);
    L38:
        GPSResult r8 = r12.gps;
        if (r8 == null) goto L47;
        r15.setAccuracy((float) r8.accuracy);
        if (r8.latitude != 0.0d) goto L43;
    L45:
        r15.setLocationType(r8.locateType);
        goto L47
    L43:
        if (r8.latitude == 0.0d) goto L45;
        r15.setLatitude(r8.latitude);
        r15.setLongitude(r8.longitude);
        r15.setCoordinateSystem(r8.coordinateSystem);
        r15.setHasServerLatLng(true);
    L47:
        if (r12.poiList == null) goto L50;
        Collections.sort(r12.poiList);
        r15.setPoiEntities(r12.poiList);
    L50:
        if (r12.aoiList == null) goto L53;
        Collections.sort(r12.aoiList);
        r15.setAoiEntities(r12.aoiList);
    L53:
        if (r12.isDisputed == false) goto L60;
        if (r0 != null) goto L60;
        if (r3 != null) goto L60;
        if (r4 != null) goto L60;
        if (r5 != null) goto L60;
        if (r1 != null) goto L60;
        r15 = new BDLocation("", "");
    L60:
        r15.setIsDisputed(r12.isDisputed);
        r15.setIsCompliance(true);
        r15.setLocationResult(r12);
        r15.setTime(r12.timestamp * 1000);
        if (r12.extra == null) goto L64;
        r15.setExtra(r12.extra.toString());
    L64:
        if (r12.locateMethod == null) goto L66;
        r15.setServerLocateMethod(r12.locateMethod);
    L66:
        r15.setServerLocateSuccess(true);
        r15.setInOutDoorStatus(r13);
        r15.setInOutDoorConfidence(r14);
        if (Build.VERSION.SDK_INT < 17) goto L69;
        r15.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
    L69:
        return r15;
    L24:
        if (r3.length <= 1) goto L26;
        r15.setSubAdministrativeArea(r3[1].name);
        goto L26
    L14:
        if (CollectionUtil.isEmpty(r1.addressLines) == true) goto L16;
        r15.setAddress((String) ZeusTransformUtils.preCheckCast(r1.addressLines.get(0), String.class, "com.obric.memorydata.plugin"));
        goto L16
    L7:
        r15 = new BDLocation(r11);
        goto L8
    }

    public static BDAddress locationToAddress2(BDLocation r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        BDAddress r0 = new BDAddress(Locale.getDefault());
        r0.setSpeed(r3.getSpeed());
        r0.setAccuracy(r3.getAccuracy());
        r0.setAltitude(r3.getAltitude());
        r0.setLatitude(r3.getLatitude());
        r0.setLongitude(r3.getLongitude());
        r0.setAdminArea(r3.getAdministrativeArea());
        r0.setSubAdminArea(r3.getSubAdministrativeArea());
        r0.setCountryName(r3.getCountry());
        r0.setLocality(r3.getCity());
        r0.setSubLocality(r3.getDistrict());
        r0.setAddressLine(0, r3.getAddress());
        return r0;
    }

    public static boolean needLocate() {
        return PermissionManager.hasLocationPermissions((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    }

    public static boolean needUpload(BDLocation r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (LocationInfoConst.BYTE.equals(r1.getLocationSDKName()) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean newIsBetterLocation(Location r8, Location r9, CacheConditionEntity r10) {
        long r1 = r8.getTime() - r9.getTime();     // Catch: Exception -> L45
        if (r1 <= 120000) goto L6;
        boolean r3 = true;
    L8:
        if (r1 <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r1 >= 0) goto L13;
        boolean r4 = true;
    L14:
        if (r3 == false) goto L18;
        if (r10 == null) goto L17;
        r10.setConditionCode(6);     // Catch: Exception -> L45
    L17:
        return true;
    L18:
        int r5 = (int) (r8.getAccuracy() - r9.getAccuracy());     // Catch: Exception -> L45
        if (r5 <= 0) goto L21;
        boolean r6 = true;
    L22:
        if (r5 >= 0) goto L24;
        boolean r7 = true;
    L26:
        if (r5 <= 200) goto L28;
        boolean r11 = true;
    L29:
        boolean r12 = isSameProvider(r8.getProvider(), r9.getProvider());     // Catch: Exception -> L45
        if (r7 == false) goto L34;
        if (r10 == null) goto L33;
        r10.setConditionCode(7);     // Catch: Exception -> L45
    L33:
        return true;
    L34:
        if (r4 == true) goto L39;
        if (r6 == true) goto L39;
        if (r10 == null) goto L38;
        r10.setConditionCode(8);     // Catch: Exception -> L45
    L38:
        return true;
    L39:
        if (r2 == false) goto L47;
        if (r11 == true) goto L47;
        if (r12 == false) goto L47;
        if (r10 == null) goto L44;
        r10.setConditionCode(9);     // Catch: Exception -> L45
    L44:
        return true;
    L47:
        return false;
    L28:
        r11 = false;
        goto L29
    L24:
        r7 = false;
        goto L26
    L21:
        r6 = false;
        goto L22
    L13:
        r4 = false;
        goto L14
    L10:
        r2 = false;
        goto L11
    L6:
        r3 = false;
    L45:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L47
    }

    public static LocInfoRspData parseInfoRsp(LocationResp r3) {
        if (r3 != null) goto L5;
    L14:
        StringBuilder r1 = new StringBuilder().append("LocationUtil parseInfoRsp error:");
        if (r3 != null) goto L17;
        String r4 = "";
    L12:
        Logger.i(r1.append(r4).toString());
        return null;
    L17:
        r4 = r3.toString();
        goto L12
    L5:
        if (r3.resultCode != 0) goto L14;
        String r5 = r3.data;
        return (LocInfoRspData) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(ServerApi.unpackFingerprint(r5), LocInfoRspData.class), LocInfoRspData.class, "com.obric.memorydata.plugin");
    L10:
        e = move-exception;
        r1 = new StringBuilder().append("parseLocInfoRsp exception:");
        r4 = e.toString();
        goto L12
    }

    public static LocInfoRspData parseLocInfoRsp(LocationResp r4) {
        if (r4 != null) goto L5;
    L18:
        StringBuilder r1 = new StringBuilder().append("LocationUtil parseLocInfoRsp error:");
        if (r4 != null) goto L21;
        String r5 = "";
    L16:
        Logger.i(r1.append(r5).toString());
        return null;
    L21:
        r5 = r4.toString();
        goto L16
    L5:
        if (r4.resultCode != 0) goto L18;
        String r2 = r4.data;
        LocInfoRspData r3 = (LocInfoRspData) ZeusTransformUtils.preCheckCast(JsonUtil.sGson.fromJson(ServerApi.unpackFingerprint(r2), LocInfoRspData.class), LocInfoRspData.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        if (r3 != null) goto L11;
    L13:
        return r3;
    L11:
        if (TextUtils.isEmpty(r4.submitLogId) == true) goto L13;
        r3.submitLogId = r4.submitLogId;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        r1 = new StringBuilder().append("parseLocInfoRsp exception:");
        r5 = e.toString();
        goto L16
    }

    public static void startCacheLocateInfoUpload(final LocationUploadExtra r3, LocationUploadCallback r4) {
        final LocationUploadCallback r5 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r4, LocationUploadCallback.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.isUpload() == true) goto L5;
    L7:
        r5.onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_UPLOAD, "", BDLocationException.ERROR_LOCATION_UPLOAD).getMessage());
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L7;
        AppExecutors.getInstance().networkIO().execute(new $$Lambda$LocationUtil$6r67CVEqou3cm1TZg_XTe_QLj4U(r3, r5));
    }

    public static void startGetDimLocation(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (BDLocationConfig.enableDimLocationCheck() == true) goto L8;
        return;
    L8:
        if (PermissionManager.isApproximateLocation(r3, true) == false) goto L10;
        return;
    L10:
        if (isTargetBrand(DimLocationCheckUtil.XIAOMI) == false) goto L13;
        DimLocationCheckUtil.startGetXiaomiDimLocation(r3);
        return;
    L13:
        if (isTargetBrand(DimLocationCheckUtil.VIVO) == false) goto L19;
        DimLocationCheckUtil.startGetVivoDimLocation(r3);
        return;
    }

    public static void startGetLocate(final LocationUploadExtra r3, LocationUploadCallback r4) {
        final LocationUploadCallback r5 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r4, LocationUploadCallback.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.isUpload() == true) goto L5;
    L7:
        r5.onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_UPLOAD, LocationInfoConst.BYTE, BDLocationException.ERROR_LOCATION_UPLOAD).getMessage());
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L7;
        AppExecutors.getInstance().networkIO().execute(new $$Lambda$LocationUtil$foJncPDNJJdPwDOt4MBGP8lIMYw(r3, r5));
    }

    public static void startLightLocationUpload(boolean r8, LocationUploadExtra r9, Object r10, LightLocationCallback r11) {
        LightLocationCallback r12 = (LightLocationCallback) ZeusTransformUtils.wrapperContextForParams(r11, LightLocationCallback.class, "com.obric.memorydata.plugin");
    L35:
        e = move-exception;
        Logger.e("startLocateUpload", e);
        if (r12 == null) goto L44;
        r12.onError(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_EXCEPTION, e.getMessage());
        return;
    L44:
        return;
    L5:
        if (allowUploadLocationInfo() == false) goto L33;
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L35
        DeviceStatus r0 = getLightDeviceStatus((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L35
        Logger.i("getLightDeviceStatusTime:" + (System.currentTimeMillis() - r3));     // Catch: Exception -> L35
        long r4 = System.currentTimeMillis();     // Catch: Exception -> L35
        DeviceLocation r5 = new DeviceLocation();     // Catch: Exception -> L35
        if (BDLocationConfig.enableLightLocationNewPolicy() == true) goto L9;
        if (r8 == false) goto L23;
        r5.baseLocation = BDLightLocationCache.getColdBootBaseStation();     // Catch: Exception -> L35
        r5.wifiInfo = getWifiInfoJson();     // Catch: Exception -> L35
    L23:
        if (r5.baseLocation != null) goto L25;
        r5.baseLocation = getLightBaseStation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r10, false, BDLocationConfig.enableGetNeighboringCell());     // Catch: Exception -> L35
    L25:
        r9.setCurrentStationDuration(System.currentTimeMillis() - r4);     // Catch: Exception -> L35
        if (r5.baseLocation == null) goto L28;
    L32:
        r12.onSuccess(ServerApi.uploadLightLocation(r5, r0, r9), r9);     // Catch: Exception -> L35
        return;
    L28:
        if (r5.wifiInfo != null) goto L32;
        if (r12 == null) goto L42;
        r12.onError(BDLocationException.ERROR_LIGHT_LOCATION_GET_CURRENT_STATION, "get current cell info error");     // Catch: Exception -> L35
        return;
    L42:
        return;
    L9:
        if (BDLightLocationCache.isGetWifiCacheList() == true) goto L14;
        r5.wifiInfo = getWifiInfoJson();     // Catch: Exception -> L35
        if (BDLightLocationCache.isGetCellCache() == true) goto L14;
        r5.baseLocation = BDLightLocationCache.getColdBootBaseStation();     // Catch: Exception -> L35
    L14:
        if (r5.baseLocation != null) goto L25;
        if (r5.wifiInfo != null) goto L25;
        if (r12 == null) goto L41;
        r12.onError(BDLocationException.ERROR_LIGHT_LOCATION_WIFI_LIST_ALREADY_UPLOAD, "wifi list already upload in v2");     // Catch: Exception -> L35
        return;
    L41:
        return;
    L33:
        r12.onError(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO, "get current cell info error");     // Catch: Exception -> L35
    }

    public static void startLocateUpload(final BDLocation r2, final LocationUploadExtra r3, LocationUploadCallback r4) {
        final LocationUploadCallback r5 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r4, LocationUploadCallback.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.isUpload() == true) goto L5;
    L7:
        r5.onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_UPLOAD, r2.getLocationSDKName(), BDLocationException.ERROR_LOCATION_UPLOAD).getMessage());
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L7;
        AppExecutors.getInstance().networkIO().execute(new $$Lambda$LocationUtil$Knw_5vAonPRUXYsyKdv3RCvaEw8(r2, r3, r5));
    }

    private static void startUploadLocationMustInNetworkIOThreadPool(DeviceLocation r2, DeviceStatus r3, LocationUploadExtra r4, LocationUploadCallback r5, boolean r6, WifiInfo r7) {
        LocationUploadCallback r8 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r5, LocationUploadCallback.class, "com.obric.memorydata.plugin");
        LocationResp r9 = ServerApi.uploadLocationInfoMustInNetworkIOThreadPool(r2, r3, r4);
        StringBuilder r10 = new StringBuilder().append("LocationUtil startLocation locationResp:");
        if (r9 != null) goto L5;
        boolean r11 = true;
    L6:
        Logger.i(r10.append(r11).toString());
        if (r8 == null) goto L10;
        r8.onSuccess(r9, r6, r7);
        return;
    L10:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public static int transformLocateMethod(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return 0;
    L5:
        if (r1.equals(locationConstants.LocateMethod_GPS) == false) goto L9;
        return 1;
    L9:
        if (r1.equals(locationConstants.LocateMethod_WIFI) == false) goto L13;
        return 2;
    L13:
        if (r1.equals(locationConstants.LocateMethod_BSS) == false) goto L17;
        return 3;
    L17:
        if (r1.equals(locationConstants.LocateMethod_IP) == false) goto L21;
        return 6;
    L21:
        if (r1.equals(locationConstants.LocateMethod_MCC) == false) goto L26;
        return 7;
    L26:
        return 0;
    }

    public static BDLocation transformLocationForLevel(BDLocation r1, int r2) {
        if (r2 != 4) goto L5;
        return r1;
    L5:
        BDLocation r0 = new BDLocation(r1);
        r0.setAccuracyLevel(r2);
        return r0;
    }

    public static void uploadCacheLocationInfo(LocationUploadExtra r5, LocationUploadCallback r6) {
        LocationUploadCallback r7 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r6, LocationUploadCallback.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        LocationTraceLogger r2 = r5.getLocationTraceLogger();
    L6:
        DeviceStatus r1 = getDeviceStatus((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2);
        DeviceLocation r3 = new DeviceLocation();
        if (BDLocationConfig.isCollectLightInfo() == false) goto L9;
        SensorInfoManager.getInstance().unregisterListener(5);
        r3.lightInfoList = SensorInfoManager.getInstance().getLightInfoList();
    L10:
        LocationResp r8 = ServerApi.uploadCacheLocationInfo(r3, r1, r5);
        StringBuilder r4 = new StringBuilder().append("LocationUtil uploadCacheLocationInfo locationResp:");
        if (r8 != null) goto L13;
        boolean r9 = true;
    L14:
        Logger.i(r4.append(r9).toString());
        if (r7 == null) goto L18;
        r7.onSuccess(r8, false, null);
        return;
    L18:
        return;
    L13:
        r9 = false;
        goto L14
    L9:
        Logger.i("LocationUtil.uploadCacheLocationInfo: skip light info.");
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public static LocInfoRspData uploadDeviceStatus(String r3, int r4) {
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == true) goto L5;
        return null;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L18;
        LocInfoRspData r5 = parseInfoRsp(ServerApi.uploadMccAndSystemRegionInfo((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3, r4));     // Catch: Exception -> L12
        if (r5 == null) goto L11;
        RegionCountry r6 = r5.regionCountry;     // Catch: Exception -> L12
        if (r6 == null) goto L11;
        Logger.i("uploadDeviceStatus RegionCountry:" + r6.toString());     // Catch: Exception -> L12
        BDLocationConfig.setRegionInChineseChannel(isRegionInChineseChannel(r6.geoNameID));     // Catch: Exception -> L12
    L11:
        return r5;
    L12:
        Logger.d("upload device status error");
        return null;
    L18:
        return null;
    }

    public static void withoutBpeaCertCheck(String r3) {
        LocationMonitor.withoutCert(r3);
        if (BDLocationConfig.isCheckLocationBpea() == true) goto L6;
        return;
    L6:
        throw new BDLocationException(BDLocationExceptionMessage.BPEA_CERT_CHECK_EXCEPTION, "unknown", "90");
    }
}
