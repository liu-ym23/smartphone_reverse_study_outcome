package com.bytedance.bdlocation;

import android.annotation.SuppressLint;
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
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.r;
import androidx.room.k;
import androidx.room.l;
import com.bytedance.bdlocation.callback.LightLocationCallback;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.CacheConditionEntity;
import com.bytedance.bdlocation.entity.GeoPoiEntity;
import com.bytedance.bdlocation.entity.PoiInfoEntity;
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
import com.obric.cae.cloud.CloudServiceConstants;
import defpackage.a;
import ha.m;
import ha.p;
import ha.s;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import r5.f;

/* JADX INFO: loaded from: classes.dex */
public final class LocationUtil {
    public static final String MOCK_AGENT_CLASS_NAME = "com.bytedance.bdlocation.locationmock.MockAgent";
    public static final String MOCK_AGENT_METHOD_NAME = "isMockEnable";

    private LocationUtil() {
    }

    public static /* synthetic */ void a(LocationUploadExtra r8, LocationUploadCallback r10) {
        lambda$startCacheLocateInfoUpload$1(r8, r10);
    }

    public static /* synthetic */ boolean access$000(Object r8, DeviceLocation r10, LocationTraceLogger r11, RefreshBaseStationInfo r12, LocationOption r13) {
        return getFreshBaseStation(r8, r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$100(DeviceLocation r8, DeviceStatus r10, LocationUploadExtra r11, LocationUploadCallback r12, boolean r13, WifiInfo r14) {
        startUploadLocationMustInNetworkIOThreadPool(r8, r10, r11, r12, r13, r14);
    }

    public static BDLocation addressesToBDLocation(List<Address> r8, BDLocation r10, String r11) {
        if (CollectionUtil.isEmpty(r8) == false) goto L6;
        return null;
    L6:
        BDLocation r12 = new BDLocation(r10);
        r12.setGeocodeSDKName(r11);
        Iterator<Address> r13 = r8.iterator();
    L8:
        if (r13.hasNext() == false) goto L14;
        Address r14 = r13.next();
        if (r14.hasLatitude() == false) goto L8;
        if (r14.hasLongitude() == false) goto L8;
        r12.setCountry(r14.getCountryName());
        r12.setAdministrativeArea(r14.getAdminArea());
        r12.setSubAdministrativeArea(r14.getSubAdminArea());
        r12.setCity(r14.getLocality());
        r12.setDistrict(r14.getSubLocality());
        r12.setStreet(r14.getThoroughfare());
        r12.setStreetNum(r14.getSubThoroughfare());
        r12.setAddress(r14.getAddressLine(0));
        r12.setPoi(r14.getFeatureName());
    L14:
        return r12;
    }

    private static boolean allowUploadLocationInfo() {
        if (BDLocationConfig.isUploadLocation() == true) goto L8;
        String r8 = "The collection of data is unable upload location!";
    L5:
        Logger.i(r8);
        return false;
    L8:
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L10;
        r8 = "The collection of data is allowed after user confirmed the privacy!";
        goto L5
    L10:
        return true;
    }

    public static String allowUseLocation(boolean r8) {
        return allowUseLocation(true, true, r8);
    }

    public static /* synthetic */ void b(BDLocation r8, LocationUploadExtra r10, LocationUploadCallback r11) {
        lambda$startLocateUpload$0(r8, r10, r11);
    }

    public static LocationInfo bdLocationToLocationInfo(BDLocation r8, boolean r10) {
        if (r8 != null) goto L5;
        return null;
    L5:
        LocationInfo r11 = new LocationInfo();
        r11.country = r8.getCountry();     // Catch: Throwable -> L16
        r11.district = r8.getDistrict();     // Catch: Throwable -> L16
        r11.province = r8.getAdministrativeArea();     // Catch: Throwable -> L16
        r11.city = r8.getCity();     // Catch: Throwable -> L16
        r11.address = r8.getAddress();     // Catch: Throwable -> L16
        r11.street = r8.getStreet();     // Catch: Throwable -> L16
        r11.streetNum = r8.getStreetNum();     // Catch: Throwable -> L16
        r11.buildingId = r8.getBuildingId();     // Catch: Throwable -> L16
        r11.floor = r8.getFloor();     // Catch: Throwable -> L16
        if (r10 == false) goto L9;
        r11.latitude = r8.getLatitude();     // Catch: Throwable -> L16
        r11.longitude = r8.getLongitude();     // Catch: Throwable -> L16
    L9:
        r11.timestamp = r8.getTime() / 1000;     // Catch: Throwable -> L16
        r11.locateType = r8.getLocationType();     // Catch: Throwable -> L16
        r11.provider = r8.getLocationSDKName();     // Catch: Throwable -> L16
        r11.altitude = r8.getAltitude();     // Catch: Throwable -> L16
        r11.accuracy = r8.getAccuracy();     // Catch: Throwable -> L16
        r11.coordinateSystem = r8.getCoordinateSystem();     // Catch: Throwable -> L16
        r11.isMock = r8.isMock();     // Catch: Throwable -> L16
        r11.altitudeAccuracy = r8.getVerticalAccuracyMeters();     // Catch: Throwable -> L16
        r11.speedAccuracyMetersPerSecond = r8.getSpeedAccuracyMetersPerSecond();     // Catch: Throwable -> L16
        r11.bearingAccuracyDegrees = r8.getBearingAccuracyDegrees();     // Catch: Throwable -> L16
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L16
        r12.put("bearing", r8.getBearing());     // Catch: Throwable -> L16
        r12.put("speed", r8.getSpeed());     // Catch: Throwable -> L16
        r12.put("trusted_level", r8.getTrustedLevel());     // Catch: Throwable -> L16
        r12.put("location_detail", r8.getLocationDetail());     // Catch: Throwable -> L16
        r12.put("satellites", r8.getSatellites());     // Catch: Throwable -> L16
        r12.put("provider", r8.getProvider());     // Catch: Throwable -> L16
        r12.put("locate_callback_ms", r8.getLocationMs());     // Catch: Throwable -> L16
        r11.extra = r12.toString();     // Catch: Throwable -> L16
        r11.elapsedRealtimeNanos = r8.getElapsedRealtimeNanos();     // Catch: Throwable -> L16
        r11.elapsedRealtimeUncertaintyNanos = r8.getElapsedRealtimeUncertaintyNanos();     // Catch: Throwable -> L16
        if (r8.getExtras() != null) goto L12;
    L14:
        r11.latitudeWgs84 = r8.latitudeWgs84;     // Catch: Throwable -> L16
        r11.longitudeWgs84 = r8.longitudeWgs84;     // Catch: Throwable -> L16
    L18:
        return r11;
    L12:
        if (r8.getExtras().isEmpty() == true) goto L14;
        r11.sysExtras = r8.getExtras().toString();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    public static /* synthetic */ void c(LocationUploadExtra r8, LocationUploadCallback r10) {
        lambda$startGetLocate$2(r8, r10);
    }

    public static float calculateLineDistance(BDLocation r8, BDLocation r10) {
        if (r8 == null) goto L7;
        if (r10 != null) goto L6;
        return -1.0f;
    L6:
        return calculateLineDistance(new BDPoint(r8.getLatitude(), r8.getLongitude()), new BDPoint(r10.getLatitude(), r10.getLongitude()));
    L7:
        return -1.0f;
    }

    public static boolean checkBackground() {
        if (BDLocationConfig.enableBackgroundLocation() == false) goto L5;
    L7:
        return false;
    L5:
        if (isBackground() == false) goto L7;
        return true;
    }

    public static void checkBpeaCertNull(String r8, Object r10) {
        LocationMonitor.certNullCheck(r8, r10);
        if (BDLocationConfig.isCheckLocationBpea() == false) goto L8;
        if (r10 != null) goto L9;
        Logger.i(r8 + "check bpea is null");
        throw new BDLocationException(BDLocationExceptionMessage.BPEA_CERT_CHECK_EXCEPTION, "unknown", BDLocationException.ERROR_BPEA_CERT_NULL);
    L9:
        return;
    }

    public static boolean checkCacheTime(long r8, long r10) {
        return checkCacheTime(r8, r10, true);
    }

    public static boolean checkGeocode(BDLocation r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r8.getCountry()) == false) goto L9;
        return false;
    L9:
        if (TextUtils.isEmpty(r8.getAdministrativeArea()) == true) goto L11;
        return true;
    L11:
        if (TextUtils.isEmpty(r8.getSubAdministrativeArea()) == true) goto L13;
        return true;
    L13:
        if (TextUtils.isEmpty(r8.getCity()) == false) goto L18;
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
        boolean r8 = false;
        Method r10 = Class.forName(MOCK_AGENT_CLASS_NAME).getDeclaredMethod(MOCK_AGENT_METHOD_NAME, new Class[0]);     // Catch: Exception -> L14
        r10.setAccessible(true);     // Catch: Exception -> L14
        Object r11 = r10.invoke(null, new Object[0]);     // Catch: Exception -> L14
        if (r11 == null) goto L11;
        r8 = ((Boolean) r11).booleanValue();     // Catch: Exception -> L14
    L11:
        BDLocationConfig.setMockEnable(r8);     // Catch: Exception -> L14
        return;
    }

    public static boolean checkMockCacheTime(BDLocation r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        long r10 = System.currentTimeMillis();
        if (r8.getMockDuration() != 0) goto L8;
        return true;
    L8:
        if ((r10 - r8.getLocationMs()) <= r8.getMockDuration()) goto L12;
        return false;
    L12:
        return true;
    }

    public static int checkStationaryScenePolicyAfterLocation(BDLocation r8, BDLocation r10, int r11, LocationTraceLogger r12) {
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L6;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: enableStationaryScenePolicy is false");
        return 0;
    L6:
        if (r8 == null) goto L34;
        if (r10 == null) goto L34;
        if (r11 != 1) goto L13;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: stationarySceneWithAoiStatus is disable");
        BDLocationConfig.setOpenStationaryScene(false);
        return 3;
    L13:
        long r13 = r8.getLocationMs() - r10.getLocationMs();
        Logger.i("StationaryScene StationaryScenePolicy AfterLocation: location interval is: " + r13);
        if (r13 <= BDLocationConfig.getStationarySceneMaxInterval()) goto L18;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: location interval is large");
        BDLocationConfig.setOpenStationaryScene(false);
        return 4;
    L18:
        if (connectedValidWiFi(r8, r10, r12) == true) goto L22;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: connectedValidWiFi is false");
        BDLocationConfig.setOpenStationaryScene(false);
        return 5;
    L22:
        if (isHightAccuracyLocation(r8, r10) == true) goto L25;
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: isHightAccuracyLocation is false");
        BDLocationConfig.setOpenStationaryScene(false);
        return 6;
    L25:
        float r14 = calculateLineDistance(r8, r10);
        Logger.i("StationaryScene StationaryScenePolicy AfterLocation: location distance is: " + r14);
        if (r14 != (-1.0f)) goto L28;
    L32:
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: location distance is large");
        BDLocationConfig.setOpenStationaryScene(false);
        return 7;
    L28:
        if (r14 > BDLocationConfig.getStationarySceneMaxDistance()) goto L32;
        Logger.i("StationaryScene enable StationaryScenePolicy AfterLocation");
        BDLocationConfig.setOpenStationaryScene(true);
        return 1;
    L34:
        Logger.i("StationaryScene unable StationaryScenePolicy AfterLocation: location is null");
        BDLocationConfig.setOpenStationaryScene(false);
        return 2;
    }

    public static boolean checkStationaryScenePolicyBeforeLocation(String r8, BDLocation r10, LocationTraceLogger r11) {
        if (BDLocationConfig.enableStationaryScenePolicy() == true) goto L8;
        Logger.i("StationaryScene unable StationaryScenePolicy BeforeLocation");
        int r12 = 0;
    L5:
        LocationMonitor.locationTracePutCategoryData(r11, LocationMonitorConst.CHECK_STATIONARY_SCENE_POLICY_BEFORE_LOCATION, r12);
        return false;
    L8:
        if (BDLocationConfig.isOpenStationaryScene() == true) goto L12;
        Logger.i("StationaryScene unable not OpenStationaryScene BeforeLocation");
        int r13 = 8;
    L10:
        r12 = Integer.valueOf(r13);
        goto L5
    L12:
        if (BDLocationConfig.isInStationarySceneTokenWhiteList(r8) == true) goto L14;
        Logger.i("StationaryScene unable StationarySceneTokenWhiteList BeforeLocation");
        r13 = 9;
        goto L10
    L14:
        long r14 = System.currentTimeMillis() - r10.getLocationMs();
        Logger.i("StationaryScene StationarySceneMaxInterval BeforeLocation:" + r14);
        if (r14 <= BDLocationConfig.getStationarySceneMaxInterval()) goto L17;
        Logger.i("StationaryScene unable StationarySceneMaxInterval BeforeLocation");
        r13 = 4;
        goto L10
    L17:
        Logger.i("StationaryScene enable StationaryScenePolicy BeforeLocation");
        return true;
    }

    public static boolean checkVPN() {
        if (BDLocationConfig.getContext() != null) goto L7;
        return false;
    L7:
        return NetworkUtil.checkVPN(BDLocationConfig.getContext());
    }

    public static int compareLocation(BDLocation r8, BDLocation r10) {
        if (r10 != null) goto L4;
        return -1;
    L4:
        if (r10.isEmpty() == true) goto L17;
        if (r8 != null) goto L8;
        return 0;
    L8:
        if (r8.isEmpty() == false) goto L11;
        return 0;
    L11:
        return locationEqual(r8, r10);
    L17:
        return -1;
    }

    public static BDLocation composeGeocodeLocation(BDLocation r8, BDLocation r10) {
        BDLocation r11 = new BDLocation(r8);
        r11.setAddress(r10.getAddress());
        r11.setCity(r10.getCity());
        r11.setAdministrativeArea(r10.getAdministrativeArea());
        r11.setSubAdministrativeArea(r10.getSubAdministrativeArea());
        r11.setProvider(r10.getProvider());
        r11.setDistrict(r10.getDistrict());
        r11.setCountry(r10.getCountry());
        r11.setCityCode(r10.getCityCode());
        r11.setTown(r10.getTown());
        r11.setStreet(r10.getStreet());
        r11.setStreetNum(r10.getStreetNum());
        r11.setFloor(r10.getFloor());
        r11.setThirdPartLocation(r10.getThirdPartLocation());
        r11.setLocationSDKName(r10.getLocationSDKName());
        r11.setPoi(r10.getPoi());
        r11.setGCJ02(r10.getGCJ02());
        r11.setCountryCode(r10.getCountryCode());
        r11.setCountryLocalID(r10.getCountryLocalID());
        r11.setLocalID(r10.getLocalID());
        r11.setDistrictLocalID(r10.getDistrictLocalID());
        r11.setGeoNameID(r10.getGeoNameID());
        r11.setBdLBSResult(r10.getBdLBSResult());
        r11.setLocationResult(r10.getLocationResult());
        r11.setGeocodeSDKName(r10.getGeocodeSDKName());
        r11.setAoi(r10.getAoi());
        r11.setIsDisputed(r10.getIsDisputed());
        r11.setIsCompliance(r10.getIsCompliance());
        r11.setCountryId(r10.getCountryId());
        r11.setSubdivisionId(r10.getSubdivisionId());
        r11.setCityId(r10.getCityId());
        r11.setDistrictId(r10.getDistrictId());
        r11.setTownId(r10.getTownId());
        r11.setCountryAsciName(r10.getCountryAsciName());
        r11.setSubdivisionAsciName(r10.getSubdivisionAsciName());
        r11.setCityAsciName(r10.getCityAsciName());
        r11.setDistrictAsciName(r10.getDistrictAsciName());
        r11.setTownAsciName(r10.getTownAsciName());
        return r11;
    }

    private static boolean connectedValidWiFi(BDLocation r8, BDLocation r10, LocationTraceLogger r11) {
        if (r8 == null) goto L31;
        if (r10 == null) goto L31;
        WifiInfo r12 = r8.getConnectedWifiInfo();
        WifiInfo r13 = r10.getConnectedWifiInfo();
        if (r12 == null) goto L30;
        if (r13 == null) goto L30;
        if (BDLocationConfig.isInStationarySceneWifiWhiteList(r12.wifiName) == false) goto L16;
        Logger.i("StationaryScene unable connectedValidWiFi: wifiName is in white list");
        int r14 = 1;
    L13:
        LocationMonitor.locationTracePutCategoryData(r11, LocationMonitorConst.STATIONARY_SCENE_CONNECTED_WIFI_TYPE, Integer.valueOf(r14));
        return false;
    L16:
        if (r12.wifiMac != null) goto L18;
    L29:
        Logger.i("StationaryScene unable connectedValidWiFi: wifiMac is null");
        r14 = 2;
        goto L13
    L18:
        if (r13.wifiMac == null) goto L29;
        if (NetworkUtil.isMeteredNetworkCapability(BDLocationConfig.getContext()) == false) goto L23;
        Logger.i("StationaryScene unable connectedValidWiFi: isMeteredNetworkCapability is true");
        r14 = 3;
        goto L13
    L23:
        Logger.i("StationaryScene New WifiMac: " + r12.wifiMac + "-Old WifiMac: " + r13.wifiMac);
        boolean r15 = TextUtils.equals(r12.wifiMac, r13.wifiMac);
        if (r15 == false) goto L26;
        int r16 = 4;
    L27:
        LocationMonitor.locationTracePutCategoryData(r11, LocationMonitorConst.STATIONARY_SCENE_CONNECTED_WIFI_TYPE, Integer.valueOf(r16));
        return r15;
    L26:
        r16 = 5;
    L30:
        Logger.i("StationaryScene unable connectedValidWiFi: connectedWifiInfo is null");
        r14 = 7;
    L31:
        Logger.i("StationaryScene unable connectedValidWiFi: location is null");
        r14 = 6;
        goto L13
    }

    public static BDPoint convertGCJ02(BDPoint r8) {
        BaseLocate r10 = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 1);
        if (r10 != null) goto L5;
        BaseLocate r11 = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 5);
        if (r11 != null) goto L9;
        return null;
    L9:
        return r11.convertGCJ02(r8);
    L5:
        return r10.convertGCJ02(r8);
    }

    public static BDLocation convertLocation(BDLocation r8) {
        if (r8 != null) goto L5;
        return r8;
    L5:
        if (LocationInfoConst.WGS_84.equals(r8.getCoordinateSystem()) == false) goto L8;
        r8.latitudeWgs84 = r8.getLatitude();
        r8.longitudeWgs84 = r8.getLongitude();
    L8:
        if (convertLocationToGCJ_O2(r8, r8.getCoordinateSystem()) == false) goto L10;
        r8.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L10:
        return r8;
    }

    public static boolean convertLocationToGCJ_O2(Location r8, String r10) {
        if (r8 != null) goto L5;
    L20:
        return false;
    L5:
        if (LocationInfoConst.GCJ_O2.equals(r10) == true) goto L20;
        BDPoint r11 = convertGCJ02(new BDPoint(r8.getLatitude(), r8.getLongitude(), r8.getProvider()));
        if (r11 == null) goto L10;
    L12:
        if (r11 == null) goto L20;
        if ((r8 instanceof BDLocation) == false) goto L16;
        ((BDLocation) r8).setGCJ02(r11);
    L16:
        double r12 = r11.getLatitude();
        double r13 = r11.getLongitude();
        if (isChineseChannel(r12, r13) == false) goto L20;
        r8.setLatitude(r12);
        r8.setLongitude(r13);
        return true;
    L10:
        if (isChineseRegion(null) == false) goto L12;
        r8.setLatitude(0.0d);
        r8.setLongitude(0.0d);
        goto L20
    }

    public static boolean disableLightLocationIfMockEnabled() {
        if (TextUtils.isEmpty(BDLocationConfig.getChannel()) == false) goto L5;
        return false;
    L5:
        if (LocationInfoConst.TEST_CHANNEL.contains(BDLocationConfig.getChannel()) == false) goto L12;
        Logger.i("disableLightLocationIfMockEnabled test channel:" + BDLocationConfig.getChannel());
        if (getLocationMockEnable(BDLocationConfig.getContext()) == false) goto L13;
        Logger.i("disableLightLocationIfMockEnabled mock enable");
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    public static boolean enableContinueLocateUploadSensitiveSignal(LocationOption r8, boolean r10) {
        if (r8 != null) goto L6;
        Logger.i("enableContinueLocateUploadSensitiveSignal locationOption is null");
        return true;
    L6:
        Logger.i("enableContinueLocateUploadSensitiveSignal locationOption isOnceLocation is " + r8.isOnceLocation() + ", enableUploadSignal is " + r10 + ", locateType is " + r8.getLocateType() + ", enableUploadNetSignal is " + r8.enableUploadNetSignal());
        if (r8.isOnceLocation() == true) goto L12;
        if (r8.enableUploadNetSignal() == true) goto L12;
        return false;
    L12:
        if (r8.getLocateType() == 1) goto L15;
        return true;
    L15:
        if (r8.isOnceLocation() == true) goto L20;
        if (r10 == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return true;
    }

    public static boolean enableUseLocation(boolean r8) {
        return "1".equals(allowUseLocation(r8));
    }

    @SuppressLint({"WrongConstant"})
    public static BDLocation geoLocationResultToBDLocation(BDLocation r13, BdGisResult r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        LocationResult r8 = r14.location;
        if (r8 != null) goto L8;
        return null;
    L8:
        if (r13 != null) goto L10;
        BDLocation r15 = new BDLocation("bd_geocode", "unKnown");
        r15.setGeocodeSDKName(SystemBaseLocationImpl.LBS_GEOCODE_NAME);
    L11:
        PlaceInfo r10 = r8.country;
        if (r10 == null) goto L14;
        r15.setCountry(r10.name);
        r15.setCountryCode(r10.code);
        r15.setCountryId(r10.geoNameID);
        r15.setCountryAsciName(r10.asciName);
    L14:
        PlaceInfo[] r11 = r8.subdivisions;
        if (r11 != null) goto L17;
    L19:
        PlaceInfo r12 = r8.city;
        if (r12 == null) goto L22;
        r15.setCity(r12.name);
        r15.setLocalID(r12.localID);
        r15.setGeoNameID(String.valueOf(r12.geoNameID));
        r15.setCityId(r12.geoNameID);
        r15.setCityAsciName(r12.asciName);
    L22:
        PlaceInfo r16 = r8.district;
        if (r16 == null) goto L25;
        r15.setDistrict(r16.name);
        r15.setDistrictId(r16.geoNameID);
        r15.setDistrictAsciName(r16.asciName);
        r15.setDistrictLocalID(r16.localID);
    L25:
        RuralInfo r17 = r8.town;
        if (r17 == null) goto L28;
        r15.setTown(r17.name);
        r15.setTownId(r17.geoNameID);
        r15.setTownAsciName(r17.asciName);
    L28:
        RuralInfo r18 = r8.village;
        if (r18 == null) goto L31;
        r15.setVillage(r18.name);
        r15.setVillageId(r18.geoNameID);
        r15.setVillageAsciName(r18.asciName);
    L31:
        GPSResult r19 = r8.gps;
        if (r19 == null) goto L38;
        double r20 = r19.latitude;
        if (r20 == 0.0d) goto L38;
        if (r20 == 0.0d) goto L38;
        r15.setLatitude(r20);
        r15.setLongitude(r19.longitude);
        r15.setTime(r19.timestamp * 1000);
        r15.setHasServerLatLng(true);
    L38:
        Place r21 = r8.place;
        if (r21 == null) goto L51;
        if (CollectionUtil.isEmpty(r21.addressLines) == true) goto L43;
        r15.setAddress(r21.addressLines.get(0));
    L43:
        List<GeoPoiEntity> r22 = r21.geoAoiList;
        if (r22 == null) goto L46;
        r15.setGeoAoiList(r22);
    L46:
        List<GeoPoiEntity> r23 = r21.geoPoiList;
        if (r23 == null) goto L49;
        r15.setGeoPoiList(r23);
    L49:
        r15.setGeoFormattedAddress(r21.geoFormattedAddress);
    L51:
        if (r14.isDisputed == false) goto L58;
        if (r10 != null) goto L58;
        if (r11 != null) goto L58;
        if (r12 != null) goto L58;
        if (r16 != null) goto L58;
        if (r21 != null) goto L58;
        r15 = new BDLocation("", "");
    L58:
        r15.setIsDisputed(r14.isDisputed);
        r15.setIsCompliance(true);
        r15.setLocationResult(r8);
        r15.setServerLocateSuccess(true);
        return r15;
    L17:
        if (r11.length <= 0) goto L19;
        r15.setAdministrativeArea(r11[0].name);
        r15.setSubdivisionId(r11[0].geoNameID);
        r15.setSubdivisionAsciName(r11[0].asciName);
        goto L19
    L10:
        r15 = new BDLocation(r13);
        goto L11
    }

    public static BDLocation geocode(Context r8, BDLocation r10) {
        if (Geocoder.isPresent() == false) goto L8;
        Locale r11 = BDLocationConfig.getLocale();
        if (r11 != null) goto L10;
        r11 = Locale.getDefault();
    L10:
        return addressesToBDLocation(new Geocoder(r8, r11).getFromLocation(r10.getLatitude(), r10.getLongitude(), 10), r10, LocationInfoConst.SYSTEM);
    L8:
        return null;
    }

    public static int getBackgroundLocationPermissionStatus() {
        return PermissionManager.getBackgroundLocationPermissionStatus(BDLocationConfig.getContext());
    }

    public static BaseStation getBaseStation(Context r8, Object r10, LocationTraceLogger r11, boolean r12, RefreshBaseStationInfo r13) {
        BaseStation r14 = null;
    L7:
        e = move-exception;
        Logger.e("", e);
        return r14;
    L4:
        if (BDLocationConfig.isUploadBaseSite() == false) goto L12;
        long r15 = SystemClock.elapsedRealtime();     // Catch: Exception -> L7
        LocationMonitor.locationTraceLogBegin(r11, LocationMonitorConst.GET_CELL_DURATION);     // Catch: Exception -> L7
        r14 = new BaseStationHelper(r8).getBaseStation(r10, r12, r13);     // Catch: Exception -> L7
        LocationMonitor.locationTraceLogEnd(r11, LocationMonitorConst.GET_CELL_DURATION);     // Catch: Exception -> L7
        LocationMonitor.fetchStationDuration(SystemClock.elapsedRealtime() - r15);     // Catch: Exception -> L7
        Logger.i("locationmonitor basestation duration is: " + (SystemClock.elapsedRealtime() - r15) + "ms");     // Catch: Exception -> L7
        return r14;
    L12:
        return null;
    }

    public static String getCityCodeForChina(BdLBSResult r8) {
        if (r8 == null) goto L9;
        LocationResult r10 = r8.location;
        if (r10 == null) goto L11;
        PlaceInfo r11 = r10.city;
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.localID;
    L11:
        return null;
    L9:
        return null;
    }

    public static String getCityCodeForOverSea(BdLBSResult r8) {
        if (r8 == null) goto L9;
        LocationResult r10 = r8.location;
        if (r10 == null) goto L11;
        PlaceInfo r11 = r10.city;
        if (r11 != null) goto L8;
        return null;
    L8:
        return String.valueOf(r11.geoNameID);
    L11:
        return null;
    L9:
        return null;
    }

    public static Context getContext(Context r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if ((r8 instanceof Application) == false) goto L9;
        return r8;
    L9:
        return r8.getApplicationContext();
    }

    public static String getCountryCode(BdLBSResult r8) {
        if (r8 == null) goto L9;
        LocationResult r10 = r8.location;
        if (r10 == null) goto L11;
        PlaceInfo r11 = r10.country;
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.code;
    L11:
        return null;
    L9:
        return null;
    }

    public static DeviceLocation getDeviceLocation(BDLocation r8, Object r10, LocationTraceLogger r11, RefreshBaseStationInfo r12, LocationOption r13) {
        if (BDLocationConfig.isUploadLocation() == false) goto L18;
        DeviceLocation r14 = new DeviceLocation();
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r13) == false) goto L7;
    L9:
        Logger.i("LocationUtil.getDeviceLocation: skip collect station info.");
    L10:
        if (r8 == null) goto L12;
        r14.sysLocation = bdLocationToLocationInfo(r8, BDLocationConfig.isUploadGPS());
    L12:
        if (r13 != null) goto L14;
    L16:
        String r15 = LocationInfoConst.SINGLE;
    L17:
        r14.locationMode = r15;
        return r14;
    L14:
        if (r13.isOnceLocation() == true) goto L16;
        r15 = LocationInfoConst.CONTINUE;
        goto L17
    L7:
        if (enableContinueLocateUploadSensitiveSignal(r13, BDLocationConfig.isContinueLocateUploadCell()) == false) goto L9;
        r14.baseLocation = getBaseStation(BDLocationConfig.getContext(), r10, r11, true, r12);
        goto L10
    L18:
        return null;
    }

    public static DeviceStatus getDeviceStatus(Context r8, LocationTraceLogger r10) {
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L8;
        LocationMonitor.locationTraceLogBegin(r10, LocationMonitorConst.GET_DEVICE_STATUS_DURATION);
        DeviceStatus r11 = new DeviceStatus();
        r11.deviceType = 2;
        r11.mccmnc = getSimOperator(r8);
        Locale r12 = BDLocationConfig.getLocale();
        if (r12 != null) goto L7;
        r12 = Locale.getDefault();
    L7:
        r11.language = r12.getLanguage();
        r11.region = r12.getCountry();
        r11.locale = r12.toString();
        r11.permission = PermissionManager.checkLocationPermissions(r8, true);
        r11.restrictedMode = BDLocationConfig.getRestrictedMode();
        r11.isStrictRestrictedMode = BDLocationConfig.isStrictRestrictedMode();
        r11.locationMode = getLocationMode(r8);
        r11.bluetoothSwitch = getbluetoothSwitch();
        r11.bluetoothPermission = PermissionManager.checkBluetoothScanPermission(r8);
        r11.isWifiOpen = isWifiOpen();
    L9:
        LocationMonitor.locationTraceLogEnd(r10, LocationMonitorConst.GET_DEVICE_STATUS_DURATION);
        return r11;
    L8:
        r11 = null;
        goto L9
    }

    private static boolean getFreshBaseStation(Object r11, DeviceLocation r12, LocationTraceLogger r13, RefreshBaseStationInfo r14, LocationOption r15) {
        if (enableContinueLocateUploadSensitiveSignal(r15, BDLocationConfig.isContinueLocateUploadCell()) == true) goto L5;
        return false;
    L5:
        if (r14 != null) goto L8;
        Logger.i("getFreshBaseStation refreshBaseStationInfo is null");
        return false;
    L8:
        long r8 = BDLocationConfig.getFreshBaseStationTimeout();
        if (r8 >= 0) goto L36;
        Logger.i("getFreshBaseStation reset freshBaseStationTimeout");
        r8 = 0;
    L36:
        long r10 = System.currentTimeMillis();     // Catch: InterruptedException -> L33
        if (r14.downLatch.await(r8, TimeUnit.MILLISECONDS) == true) goto L15;
        boolean r16 = true;
    L16:
        LocationMonitor.locationTracePutCategoryData(r13, LocationMonitorConst.REFRESH_BASE_STATION_INFO_TIMEOUT, Boolean.valueOf(r16));     // Catch: InterruptedException -> L33
        LocationMonitor.locationTracePutMetricData(r13, LocationMonitorConst.REFRESH_BASE_STATION_INFO_AWAIT_DURATION, System.currentTimeMillis() - r10);     // Catch: InterruptedException -> L33
        LocationMonitor.locationTracePutMetricData(r13, LocationMonitorConst.FRESH_BASE_STATION_TIMEOUT, r8);     // Catch: InterruptedException -> L33
        Logger.i("getFreshBaseStation freshBaseStationTimeout: " + r8 + ", isTimeout: " + r16 + ", await interval: " + (System.currentTimeMillis() - r10));     // Catch: InterruptedException -> L33
        BaseStation r17 = r14.getBaseStation();     // Catch: InterruptedException -> L33
        if (r17 != null) goto L19;
        String r18 = "null";
    L20:
        Logger.i("getFreshBaseStation refreshBaseStationInfo.getBaseStation is ".concat(r18));     // Catch: InterruptedException -> L33
        if (r16 == false) goto L26;
        Logger.i("getFreshBaseStation refreshBaseStationInfo.downLatch.await is timeout");     // Catch: InterruptedException -> L33
        return true;
    L26:
        if (BDLocationConfig.getBaseStationInfoType() != 1) goto L30;
        if (r17 == null) goto L30;
        Logger.i("getFreshBaseStation get refreshBaseStationInfo");     // Catch: InterruptedException -> L33
        r12.baseLocation = r17;     // Catch: InterruptedException -> L33
        Boolean r19 = Boolean.TRUE;     // Catch: InterruptedException -> L33
    L29:
        LocationMonitor.locationTracePutCategoryData(r13, LocationMonitorConst.ONLY_USE_REFRESH_BASE_STATION_INFO, r19);     // Catch: InterruptedException -> L33
        return false;
    L30:
        Logger.i("getFreshBaseStation get allBaseStationInfo");     // Catch: InterruptedException -> L33
        r12.baseLocation = getBaseStation(BDLocationConfig.getContext(), r11, null, false, null);     // Catch: InterruptedException -> L33
        r19 = Boolean.FALSE;     // Catch: InterruptedException -> L33
        goto L29
    L19:
        r18 = "not null";
        goto L20
    L15:
        r16 = false;
    L33:
        e = move-exception;
        Logger.e("getFreshBaseStation downLatch.await error:" + e);
        return true;
    }

    public static BdGisResult getGeocodeResult(double r8, double r10, int r11, int r12) {
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L15;
        return null;
    L15:
    L12:
        e = move-exception;
        Logger.i("getGeocodeResult exception:" + e.toString());
        throw new BDLocationException(BDLocationExceptionMessage.GET_GEOCODE_RESULT_ERROR, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_GET_GEOCODE);
    L7:
        if (BDLocationConfig.useNewReverseGeoLocationApi() == false) goto L9;
        BdGisResult r13 = ServerApi.getGisResult(r8, r10, r11, r12);     // Catch: Exception -> L12
    L10:
        Logger.d("GisResult:" + r13);     // Catch: Exception -> L12
        return r13;
    L9:
        r13 = ServerApi.getGisResultOld(r8, r10, r11, r12);     // Catch: Exception -> L12
        goto L10
    }

    public static List<HARStatus> getHARStatusList() {
        return HARServiceUtil.getHARStatusList();
    }

    public static BDLocation getIPResult(int r8) {
        LocationResult r10 = ServerApi.getIPResult(r8);
        if (r10 != null) goto L5;
        return null;
    L5:
        return locationResultToBDLocation(null, r10);
    }

    public static int getInOutDoorStatusInTenMinutes() {
        LocationCacheInfo r8 = LocationCache.getInstance().getLocationCache();
        if (r8 != null) goto L5;
        return 0;
    L5:
        BDLocation r10 = r8.getLatestLocation();
        if (r10 != null) goto L8;
        return 0;
    L8:
        long r11 = r10.getLocationMs();
        if ((System.currentTimeMillis() - r11) <= BDLocationConfig.getInOutDoorStatusCacheTime()) goto L13;
        return 2;
    L13:
        return r10.getInOutDoorStatus();
    }

    public static String getLanguage() {
        Locale r8 = BDLocationConfig.getLocale();
        if (r8 != null) goto L6;
        r8 = Locale.getDefault();
    L6:
        return languageTag(r8);
    }

    public static BaseStation getLightBaseStation(Context r8, Object r10, boolean r11, boolean r12) {
        BaseStation r13 = null;
        if (r11 == false) goto L11;
    L6:
        long r14 = SystemClock.elapsedRealtime();     // Catch: Exception -> L8
        r13 = new BaseStationHelper(r8).getLightBaseStation(r10, r11, r12);     // Catch: Exception -> L8
        Logger.i("locationmonitor basestation duration is: " + (SystemClock.elapsedRealtime() - r14) + "ms");     // Catch: Exception -> L8
        return r13;
    L8:
        e = move-exception;
        Logger.e("", e);
        return r13;
    L11:
        if (BDLocationConfig.isUploadBaseSite() == true) goto L6;
        return null;
    }

    public static DeviceStatus getLightDeviceStatus(Context r8) {
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L8;
        DeviceStatus r10 = new DeviceStatus();
        r10.deviceType = 2;
        Locale r11 = BDLocationConfig.getLocale();
        if (r11 != null) goto L7;
        r11 = Locale.getDefault();
    L7:
        r10.language = r11.getLanguage();
        r10.region = r11.getCountry();
        r10.locale = r11.toString();
        r10.permission = 1;
        r10.restrictedMode = BDLocationConfig.getRestrictedMode();
        r10.locationMode = getLocationMode(r8);
        r10.bluetoothSwitch = getbluetoothSwitch();
        r10.bluetoothPermission = PermissionManager.checkBluetoothScanPermission(r8);
        r10.isWifiOpen = isWifiOpen();
        return r10;
    L8:
        return null;
    }

    private static RegionInfo getLocaleRegion() {
        RegionInfo r8 = new RegionInfo();
        Locale r10 = Locale.getDefault();     // Catch: Exception -> L12
        String r11 = r10.getCountry();     // Catch: Exception -> L12
        String r12 = r10.getLanguage();     // Catch: Exception -> L12
        String r13 = r10.toString();     // Catch: Exception -> L12
        if (TextUtils.isEmpty(r11) == false) goto L6;
    L7:
        Locale r14 = Resources.getSystem().getConfiguration().getLocales().get(0);     // Catch: Exception -> L12
        if (r14 == null) goto L10;
        r11 = r14.getCountry();     // Catch: Exception -> L12
        r12 = r14.getLanguage();     // Catch: Exception -> L12
        r13 = r12 + "_" + r11;     // Catch: Exception -> L12
    L10:
        r8.locale = r13;     // Catch: Exception -> L12
        r8.systemRegion = r11;     // Catch: Exception -> L12
        r8.systemLanguage = r12;     // Catch: Exception -> L12
    L14:
        return r8;
    L6:
        if (TextUtils.isEmpty(r12) == false) goto L10;
    L12:
        e = move-exception;
        Logger.i("getLocal error" + e.toString());
        goto L14
    }

    public static void getLocationInfoMustInNetworkIOThreadPool(BDLocation r16, final LocationUploadExtra r17, final LocationUploadCallback r18) {
        if (r17 == null) goto L5;
        Object r8 = r17.getBpeaCert();
        m r10 = r17.getWifiData();
        boolean r11 = r17.isWifiCache();
        boolean r12 = r17.isOnceLocation();
        LocationTraceLogger r13 = r17.getLocationTraceLogger();
        boolean r14 = r17.isRecommendWifiResults();
        WifiInfo r15 = r17.getConnectedWifiInfo();
        final LocationOption r19 = r17.locationOption;
        Object r110 = r8;
        LocationTraceLogger r111 = r13;
        WifiInfo r20 = r15;
    L6:
        final DeviceStatus r21 = getDeviceStatus(BDLocationConfig.getContext(), r111);
        Logger.i("getLocationInfo isUploadFreshBaseStation: " + BDLocationConfig.isUploadFreshBaseStation());
        LocationMonitor.locationTracePutCategoryData(r111, LocationMonitorConst.IS_UPLOAD_FRESH_BASE_STATION, Boolean.valueOf(BDLocationConfig.isUploadFreshBaseStation()));
        if (r17 != null) goto L9;
        LocationOption r22 = null;
    L11:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r22) == false) goto L13;
    L15:
        Logger.i("LocationUtil.getLocationInfoMustInNetworkIOThreadPool: skip refresh base station info.");
        RefreshBaseStationInfo r23 = null;
    L16:
        if (r17 != null) goto L18;
        LocationOption r24 = null;
    L19:
        final DeviceLocation r112 = getDeviceLocation(r16, r110, r111, r23, r24);
        if (BDLocationConfig.isMockEnable() == false) goto L27;
        if (TextUtils.isEmpty(BDLocationConfig.getMockWifiName()) == true) goto L24;
        r112.wifiInfo = WifiUtil.getMockWifiJson();
    L24:
        r112.baseLocation = null;
        startUploadLocationMustInNetworkIOThreadPool(r112, r21, r17, r18, false, null);
        return;
    L27:
        if (BDLocationConfig.isAsyncScanWifi() == false) goto L38;
        if (r12 == false) goto L38;
        if (r16 == null) goto L38;
        Logger.i("getLocationInfo asyncScanWifi");
        r112.wifiInfo = r10;
        if (BDLocationConfig.isCollectLightInfo() == false) goto L33;
        SensorInfoManager.getInstance().unregisterListener(5);
        r112.lightInfoList = SensorInfoManager.getInstance().getLightInfoList();
    L34:
        if (r11 == false) goto L36;
        String r25 = "true";
    L37:
        r21.isWifiCache = r25;
        startUploadLocationMustInNetworkIOThreadPool(r112, r21, r17, r18, r14, r20);
        return;
    L36:
        r25 = "false";
        goto L37
    L33:
        Logger.i("LocationUtil.getLocationInfoMustInNetworkIOThreadPool: skip light info.");
    L38:
        final long r26 = System.currentTimeMillis();
        Context r113 = BDLocationConfig.getContext();
        final Object r27 = r110;
        final LocationTraceLogger r28 = r111;
        final RefreshBaseStationInfo r29 = r23;
        WifiUtil.WifiInfoJsonCallback r30 = new AnonymousClass1(r26, r112, r21, r27, r28, r29, r19, r17, r18);
        if (r17 != null) goto L41;
        LocationOption r31 = null;
    L42:
        WifiUtil.getWifiInfoJsonAsync(r113, r30, r110, r111, r31);
        return;
    L41:
        r31 = r17.locationOption;
        goto L42
    L18:
        r24 = r17.locationOption;
        goto L19
    L13:
        if (BDLocationConfig.isUploadFreshBaseStation() == false) goto L15;
        r23 = new RefreshBaseStationInfo();
        goto L16
    L9:
        r22 = r17.locationOption;
        goto L11
    L5:
        r11 = false;
        r12 = true;
        r14 = true;
        r10 = null;
        r20 = null;
        r19 = null;
        r110 = null;
        r111 = null;
        goto L6
    }

    public static boolean getLocationMockEnable(Context r8) {
        if (r8 != null) goto L13;
        Logger.i("getLocationMockEnable: context is null");
        return false;
    L13:
        Method r10 = Class.forName(MOCK_AGENT_CLASS_NAME).getDeclaredMethod(MOCK_AGENT_METHOD_NAME, new Class[]{Context.class});     // Catch: Exception -> L10
        r10.setAccessible(true);     // Catch: Exception -> L10
        Object r11 = r10.invoke(null, new Object[]{r8});     // Catch: Exception -> L10
        if (r11 == null) goto L15;
        return ((Boolean) r11).booleanValue();
    L15:
        return false;
    L10:
        e = move-exception;
        Logger.e("getLocationMockEnable: error", e);
        return false;
    }

    public static int getLocationMode(Context r8) {
    L27:
        th = move-exception;
        Logger.i("LocationUtil getLocationMode exception:" + th.getMessage());
    L29:
        return 0;
    L4:
        if (isLocationEnabled() == true) goto L6;
        return 1;
    L6:
        LocationManager r10 = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L27
        if (r10 == null) goto L29;
        List<String> r11 = r10.getProviders(true);     // Catch: Throwable -> L27
        if (r11 == null) goto L29;
        if (r11.isEmpty() == true) goto L29;
        if (r10.isProviderEnabled(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == false) goto L15;
        int r12 = 2;
    L17:
        if (r10.isProviderEnabled("network") == false) goto L20;
        r12 = r12 | 4;     // Catch: Throwable -> L27
    L20:
        if (r10.isProviderEnabled("passive") == false) goto L23;
        r12 = r12 | 8;     // Catch: Throwable -> L27
    L23:
        if (PermissionManager.isApproximateLocation(r8) == false) goto L25;
        r12 = r12 | 32;     // Catch: Throwable -> L27
    L25:
        Logger.i("PermissionManager getLocationMode result:" + r12);     // Catch: Throwable -> L27
        return r12;
    L15:
        r12 = 0;
        goto L17
    }

    public static int getMaxHARStatus() {
        return HARServiceUtil.getMaxHARStatus();
    }

    public static String getNetworkOperator(Context r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        TelephonyManager r10 = (TelephonyManager) r8.getSystemService("phone");
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.getNetworkOperator();
    }

    public static RegionInfo getRegionInfo(Context r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == false) goto L9;
        RegionInfo r10 = getLocaleRegion();
        String r11 = getSimOperator(r8);
        r10.carrierRegion = r11;
        r10.networkSimRegion = r11;
        r10.mccmnc = getNetworkOperator(r8);
        return r10;
    L9:
        return null;
    }

    public static String getSimOperator(Context r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        TelephonyManager r10 = (TelephonyManager) r8.getSystemService("phone");
        if (r10 != null) goto L14;
        return null;
    L14:
        if (r10.getSimState() != 5) goto L16;
        return r10.getSimOperator();
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
        if (BDLocationConfig.getContext() != null) goto L5;
        return Integer.MAX_VALUE;
    L5:
        if (BDLocationConfig.getContext().getApplicationInfo() != null) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return BDLocationConfig.getContext().getApplicationInfo().targetSdkVersion;
    }

    private static m getWifiInfoJson() {
        WifiInfoModule r8 = BDLightLocationCache.getWifiCacheModule();
        if (r8 != null) goto L5;
        return null;
    L5:
        List<WifiInfo> r10 = r8.wifiInfoList;
        if (r10 != null) goto L8;
        return null;
    L8:
        if (r10.size() <= 0) goto L18;
        p r11 = JsonUtil.toJsonTreeSafely(r8.wifiInfoList, new AnonymousClass2().getType());     // Catch: Exception -> L14
        if (r11 == null) goto L19;
        return r11.e();
    L19:
        return null;
    L20:
        return null;
    L18:
        return null;
    }

    public static boolean getbluetoothSwitch() {
        BluetoothAdapter r8 = BluetoothAdapter.getDefaultAdapter();     // Catch: Exception -> L6
        if (r8 == null) goto L12;
        return r8.isEnabled();
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

    public static boolean isBetterLocation(Location r8, Location r10) {
        return isBetterLocation(r8, r10, null);
    }

    public static boolean isChineseChannel(double r8, double r10) {
        BaseLocate r11 = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 1);
        if (r11 != null) goto L5;
        return true;
    L5:
        return r11.isAMapDataAvailable(r8, r10);
    }

    public static boolean isChineseRegion(BDLocation r8) {
        if (BDLocationConfig.needDownGradeLocationInOverseas() == true) goto L6;
        Logger.i("needDownGradeLocationInOverseas:" + BDLocationConfig.needDownGradeLocationInOverseas());
        return true;
    L6:
        if (r8 != null) goto L8;
        r8 = LocationCache.getInstance().getLocationCache().getLatestLocation();
    L8:
        boolean r10 = BDLocationConfig.isRegionInChineseChannel();
        if (BDLocationConfig.useGpsCheckRegion() == false) goto L16;
        if (r8 == null) goto L16;
        boolean r11 = isChineseChannel(r8.getLatitude(), r8.getLongitude());
        Logger.i("region check isGpsChineseChannel:" + r11);
        LocationMonitor.gpsCheckRegion(r11, r10);
        if (r11 == true) goto L15;
        return false;
    L15:
        return true;
    L16:
        Logger.i("region check isRegionInChineseChannel:" + r10);
        return r10;
    }

    public static boolean isEmpty(Location r8) {
        if (r8 != null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isEnableLocationService(Context r8) {
        if (isGpsProviderEnabled(r8) == false) goto L5;
    L8:
        return true;
    L5:
        if (isNetworkProviderEnabled(r8) == true) goto L8;
        return false;
    }

    public static boolean isGoodLocation(BDLocation r8) {
        return isGoodLocation(r8, null);
    }

    public static boolean isGpsProviderEnabled(Context r8) {
        LocationManager r10 = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);
        if (r10 == null) goto L12;
        return r10.isProviderEnabled(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);
    L6:
        e = move-exception;
        Logger.i("isProviderEnabled error:" + e.toString());
        LocationMonitor.checkLocationProviderEnabledError(e, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);
        return false;
    L12:
        return false;
    }

    private static boolean isHightAccuracyLocation(BDLocation r8, BDLocation r10) {
        if (r8 == null) goto L18;
        if (r10 == null) goto L18;
        int r11 = r8.getLocationType();
        int r12 = r10.getLocationType();
        StringBuilder r13 = a.g("StationaryScene New LocationType: ", r11, "-Old LocationType: ", r12, "-New Location Accuracy: ");
        r13.append(r8.getAccuracy());
        r13.append("-Old Location Accuracy: ");
        r13.append(r10.getAccuracy());
        Logger.i(r13.toString());
        if (r11 == 2) goto L11;
        if (r11 == 1) goto L10;
    L16:
        return false;
    L10:
        if (r8.getAccuracy() >= BDLocationConfig.getStationarySceneMaxGpsAccuracy()) goto L16;
    L11:
        if (r12 == 2) goto L17;
        if (r12 != 1) goto L16;
        if (r10.getAccuracy() >= BDLocationConfig.getStationarySceneMaxGpsAccuracy()) goto L16;
    L17:
        return true;
    L18:
        return false;
    }

    public static boolean isLocationEnabled() {
        return ((LocationManager) BDLocationConfig.getContext().getSystemService(LocationMonitorConst.LOCATION)).isLocationEnabled();
    L4:
        e = move-exception;
        Logger.e("location enable status error", e.getMessage());
        return false;
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNeedAddress(LocationOption r8) {
        if (r8 != null) goto L4;
        return true;
    L4:
        if (r8.getGeocodeMode() != 0) goto L9;
        return false;
    L9:
        return true;
    }

    public static boolean isNetworkProviderEnabled(Context r8) {
        LocationManager r10 = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);
        if (r10 == null) goto L12;
        return r10.isProviderEnabled("network");
    L6:
        e = move-exception;
        Logger.e("isNetworkProviderEnabled error:" + e);
        LocationMonitor.checkLocationProviderEnabledError(e, "network");
        return false;
    L12:
        return false;
    }

    public static boolean isProxy() {
        if (BDLocationConfig.getContext() != null) goto L7;
        return false;
    L7:
        return NetworkUtil.isWifiProxy(BDLocationConfig.getContext());
    }

    private static boolean isRegionInChineseChannel(String r8) {
        if (BDLocationConfig.getRedGeoNameIds().contains(r8) == false) goto L6;
        return true;
    L6:
        return false;
    }

    private static boolean isSameProvider(String r8, String r10) {
        if (r8 != null) goto L8;
        if (r10 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r8.equals(r10);
    }

    public static boolean isTargetBrand(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L5;
        String r10 = Build.MANUFACTURER;
        String r11 = Build.BRAND;
        Logger.i("isTargetDevice Build.MANUFACTURER: " + r10 + " Build.BRAND: " + r11);
        if (r8.equalsIgnoreCase(r10) == false) goto L13;
    L14:
        return true;
    L13:
        if (r8.equalsIgnoreCase(r11) == true) goto L14;
        return false;
    L5:
        if (r8 != null) goto L7;
        String r12 = "targetBrand = null";
    L8:
        Logger.i("isTargetDevice ".concat(r12));
        return false;
    L7:
        r12 = "targetBrand is empty";
        goto L8
    }

    public static boolean isUseByteLocationPolicy(String r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (LocationInfoConst.LIBRA_PARAM_V1.equals(BDLocationConfig.getByteLocationLibraParam()) == true) goto L10;
        if (LocationInfoConst.LIBRA_PARAM_V2.equals(BDLocationConfig.getByteLocationLibraParam()) == true) goto L10;
        return false;
    L10:
        if (BDLocationConfig.getByteLocationWhiteList().contains(r8) == true) goto L14;
        return true;
    L14:
        return false;
    }

    public static boolean isUseByteLocationPolicyV2(String r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if (LocationInfoConst.LIBRA_PARAM_V2.equals(BDLocationConfig.getByteLocationLibraParam()) == true) goto L8;
        return false;
    L8:
        if (BDLocationConfig.getByteLocationWhiteList().contains(r8) == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isWifiOpen() {
        WifiManager r8 = (WifiManager) BDLocationConfig.getContext().getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L6
        if (r8 == null) goto L12;
        return r8.isWifiEnabled();
    L12:
        return false;
    L6:
        e = move-exception;
        Logger.i("isWifiOpen exception:" + e.toString());
        return false;
    }

    private static /* synthetic */ void lambda$startCacheLocateInfoUpload$1(LocationUploadExtra r8, LocationUploadCallback r10) {
    L6:
        e = move-exception;
        Logger.e("startCacheLocateInfoUpload", e);
        if (r10 == null) goto L14;
        r10.onError(e.getMessage());
        return;
    L14:
        return;
    L3:
        if (allowUploadLocationInfo() == false) goto L13;
        uploadCacheLocationInfo(r8, r10);     // Catch: Exception -> L6
        return;
    }

    private static /* synthetic */ void lambda$startGetLocate$2(LocationUploadExtra r8, LocationUploadCallback r10) {
        getLocationInfoMustInNetworkIOThreadPool(null, r8, r10);
    }

    private static /* synthetic */ void lambda$startLocateUpload$0(BDLocation r8, LocationUploadExtra r10, LocationUploadCallback r11) {
    L6:
        e = move-exception;
        Logger.e("startLocateUpload", e);
        if (r11 == null) goto L14;
        r11.onError(e.getMessage());
        return;
    L14:
        return;
    L3:
        if (allowUploadLocationInfo() == false) goto L13;
        getLocationInfoMustInNetworkIOThreadPool(r8, r10, r11);     // Catch: Exception -> L6
        return;
    }

    public static String languageTag(Locale r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        String r10 = r8.getLanguage();
        String r11 = r8.getCountry();
        if (TextUtils.isEmpty(r11) == false) goto L8;
        return r10;
    L8:
        return a.f(r10, "-", r11);
    }

    private static int locationEqual(BDLocation r10, BDLocation r11) {
        LocationResult r8 = r10.getLocationResult();
        LocationResult r12 = r11.getLocationResult();
        if (r8 == null) goto L45;
        if (r12 == null) goto L47;
        PlaceInfo r13 = r8.country;
        if (r13 == null) goto L13;
        PlaceInfo r14 = r12.country;
        if (r14 == null) goto L13;
        if (r13.geoNameID == r14.geoNameID) goto L13;
        return 0;
    L13:
        PlaceInfo[] r15 = r8.subdivisions;
        PlaceInfo[] r16 = r12.subdivisions;
        if (r15 == null) goto L27;
        if (r16 == null) goto L27;
        if (r15.length <= 0) goto L27;
        if (r16.length <= 0) goto L27;
        PlaceInfo r17 = r15[0];
        PlaceInfo r18 = r16[0];
        if (r17 == null) goto L27;
        if (r18 == null) goto L27;
        if (r17.geoNameID == r18.geoNameID) goto L27;
        return 1;
    L27:
        PlaceInfo r19 = r8.city;
        if (r19 == null) goto L35;
        PlaceInfo r20 = r12.city;
        if (r20 == null) goto L35;
        if (r19.geoNameID == r20.geoNameID) goto L35;
        return 2;
    L35:
        PlaceInfo r21 = r8.district;
        if (r21 == null) goto L44;
        PlaceInfo r22 = r12.district;
        if (r22 == null) goto L44;
        if (r21.geoNameID == r22.geoNameID) goto L44;
        return 3;
    L44:
        return locationNameEqual(r10, r11);
    L47:
        return -1;
    L45:
        return -1;
    }

    private static int locationNameEqual(BDLocation r8, BDLocation r10) {
        if (f.a(r8.getCountry(), r10.getCountry()) == true) goto L11;
        if (TextUtils.isEmpty(r8.getCountry()) == true) goto L11;
        if (TextUtils.isEmpty(r10.getCountry()) == true) goto L11;
        return 0;
    L11:
        if (f.a(r8.getAdministrativeArea(), r10.getAdministrativeArea()) == true) goto L19;
        if (TextUtils.isEmpty(r8.getAdministrativeArea()) == true) goto L19;
        if (TextUtils.isEmpty(r10.getAdministrativeArea()) == true) goto L19;
        return 1;
    L19:
        if (f.a(r8.getCity(), r10.getCity()) == true) goto L27;
        if (TextUtils.isEmpty(r8.getCity()) == true) goto L27;
        if (TextUtils.isEmpty(r10.getCity()) == true) goto L27;
        return 2;
    L27:
        if (f.a(r8.getDistrict(), r10.getDistrict()) == true) goto L35;
        if (TextUtils.isEmpty(r8.getDistrict()) == true) goto L35;
        if (TextUtils.isEmpty(r10.getDistrict()) == true) goto L35;
        return 3;
    L35:
        if (f.a(r8.getSubAdministrativeArea(), r10.getSubAdministrativeArea()) == false) goto L37;
        return -1;
    L37:
        if (TextUtils.isEmpty(r8.getSubAdministrativeArea()) == false) goto L39;
        return -1;
    L39:
        if (TextUtils.isEmpty(r10.getSubAdministrativeArea()) == true) goto L45;
        return 4;
    L45:
        return -1;
    }

    public static BDLocation locationResultToBDLocation(BDLocation r8, LocationResult r10) {
        return locationResultToBDLocation(r8, r10, 0, -1.0f);
    }

    public static BDAddress locationToAddress2(BDLocation r8) {
        if (r8 != null) goto L5;
        return null;
    L5:
        BDAddress r10 = new BDAddress(Locale.getDefault());
        r10.setSpeed(r8.getSpeed());
        r10.setAccuracy(r8.getAccuracy());
        r10.setAltitude(r8.getAltitude());
        r10.setLatitude(r8.getLatitude());
        r10.setLongitude(r8.getLongitude());
        r10.setAdminArea(r8.getAdministrativeArea());
        r10.setSubAdminArea(r8.getSubAdministrativeArea());
        r10.setCountryName(r8.getCountry());
        r10.setLocality(r8.getCity());
        r10.setSubLocality(r8.getDistrict());
        r10.setAddressLine(0, r8.getAddress());
        return r10;
    }

    public static boolean needLocate() {
        return PermissionManager.hasLocationPermissions(BDLocationConfig.getContext());
    }

    public static boolean needUpload(BDLocation r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if (LocationInfoConst.BYTE.equals(r8.getLocationSDKName()) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean newIsBetterLocation(Location r8, Location r10, CacheConditionEntity r11) {
        long r12 = r8.getTime() - r10.getTime();     // Catch: Exception -> L45
        if (r12 <= 120000) goto L6;
        boolean r13 = true;
    L8:
        if (r12 <= 0) goto L10;
        boolean r14 = true;
    L11:
        if (r12 >= 0) goto L13;
        boolean r15 = true;
    L14:
        if (r13 == false) goto L18;
        if (r11 == null) goto L17;
        r11.setConditionCode(6);     // Catch: Exception -> L45
    L17:
        return true;
    L18:
        int r16 = (int) (r8.getAccuracy() - r10.getAccuracy());     // Catch: Exception -> L45
        if (r16 <= 0) goto L21;
        boolean r17 = true;
    L22:
        if (r16 >= 0) goto L24;
        boolean r18 = true;
    L26:
        if (r16 <= 200) goto L28;
        boolean r19 = true;
    L29:
        boolean r20 = isSameProvider(r8.getProvider(), r10.getProvider());     // Catch: Exception -> L45
        if (r18 == false) goto L34;
        if (r11 == null) goto L33;
        r11.setConditionCode(7);     // Catch: Exception -> L45
    L33:
        return true;
    L34:
        if (r15 == true) goto L39;
        if (r17 == true) goto L39;
        if (r11 == null) goto L38;
        r11.setConditionCode(8);     // Catch: Exception -> L45
    L38:
        return true;
    L39:
        if (r14 == false) goto L47;
        if (r19 == true) goto L47;
        if (r20 == false) goto L47;
        if (r11 == null) goto L44;
        r11.setConditionCode(9);     // Catch: Exception -> L45
    L44:
        return true;
    L47:
        return false;
    L28:
        r19 = false;
        goto L29
    L24:
        r18 = false;
        goto L26
    L21:
        r17 = false;
        goto L22
    L13:
        r15 = false;
        goto L14
    L10:
        r14 = false;
        goto L11
    L6:
        r13 = false;
    L45:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L47
    }

    public static LocInfoRspData parseInfoRsp(LocationResp r8) {
        if (r8 != null) goto L5;
    L14:
        StringBuilder r10 = new StringBuilder("LocationUtil parseInfoRsp error:");
        if (r8 != null) goto L17;
        String r11 = "";
    L12:
        r10.append(r11);
        Logger.i(r10.toString());
        return null;
    L17:
        r11 = r8.toString();
        goto L12
    L5:
        if (r8.resultCode != 0) goto L14;
        String r12 = r8.data;
        return (LocInfoRspData) JsonUtil.sGson.c(LocInfoRspData.class, ServerApi.unpackFingerprint(r12));
    L10:
        e = move-exception;
        r10 = new StringBuilder("parseLocInfoRsp exception:");
        r11 = e.toString();
        goto L12
    }

    public static LocInfoRspData parseLocInfoRsp(LocationResp r8) {
        if (r8 != null) goto L5;
    L18:
        StringBuilder r10 = new StringBuilder("LocationUtil parseLocInfoRsp error:");
        if (r8 != null) goto L21;
        String r11 = "";
    L16:
        r10.append(r11);
        Logger.i(r10.toString());
        return null;
    L21:
        r11 = r8.toString();
        goto L16
    L5:
        if (r8.resultCode != 0) goto L18;
        String r12 = r8.data;
        LocInfoRspData r13 = (LocInfoRspData) JsonUtil.sGson.c(LocInfoRspData.class, ServerApi.unpackFingerprint(r12));     // Catch: Exception -> L14
        if (r13 != null) goto L11;
    L13:
        return r13;
    L11:
        if (TextUtils.isEmpty(r8.submitLogId) == true) goto L13;
        r13.submitLogId = r8.submitLogId;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        r10 = new StringBuilder("parseLocInfoRsp exception:");
        r11 = e.toString();
        goto L16
    }

    public static void startCacheLocateInfoUpload(LocationUploadExtra r8, LocationUploadCallback r10) {
        if (BDLocationConfig.isUpload() == true) goto L5;
    L7:
        r10.onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_UPLOAD, "", BDLocationException.ERROR_LOCATION_UPLOAD).getMessage());
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L7;
        AppExecutors.getInstance().networkIO().execute(new r(5, r8, r10));
    }

    public static void startGetDimLocation(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (BDLocationConfig.enableDimLocationCheck() == true) goto L7;
        return;
    L7:
        if (PermissionManager.isApproximateLocation(r8, true) == false) goto L9;
        return;
    L9:
        if (isTargetBrand(DimLocationCheckUtil.XIAOMI) == false) goto L12;
        DimLocationCheckUtil.startGetXiaomiDimLocation(r8);
        return;
    L12:
        if (isTargetBrand(DimLocationCheckUtil.VIVO) == false) goto L18;
        DimLocationCheckUtil.startGetVivoDimLocation(r8);
        return;
    }

    public static void startGetLocate(LocationUploadExtra r8, LocationUploadCallback r10) {
        if (BDLocationConfig.isUpload() == true) goto L5;
    L7:
        r10.onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_UPLOAD, LocationInfoConst.BYTE, BDLocationException.ERROR_LOCATION_UPLOAD).getMessage());
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L7;
        AppExecutors.getInstance().networkIO().execute(new k(6, r8, r10));
    }

    public static void startLightLocationUpload(boolean r8, LocationUploadExtra r10, Object r11, LightLocationCallback r12) {
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
        long r13 = System.currentTimeMillis();     // Catch: Exception -> L35
        DeviceStatus r14 = getLightDeviceStatus(BDLocationConfig.getContext());     // Catch: Exception -> L35
        Logger.i("getLightDeviceStatusTime:" + (System.currentTimeMillis() - r13));     // Catch: Exception -> L35
        long r15 = System.currentTimeMillis();     // Catch: Exception -> L35
        DeviceLocation r16 = new DeviceLocation();     // Catch: Exception -> L35
        if (BDLocationConfig.enableLightLocationNewPolicy() == true) goto L9;
        if (r8 == false) goto L23;
        r16.baseLocation = BDLightLocationCache.getColdBootBaseStation();     // Catch: Exception -> L35
        r16.wifiInfo = getWifiInfoJson();     // Catch: Exception -> L35
    L23:
        if (r16.baseLocation != null) goto L25;
        r16.baseLocation = getLightBaseStation(BDLocationConfig.getContext(), r11, false, BDLocationConfig.enableGetNeighboringCell());     // Catch: Exception -> L35
    L25:
        r10.setCurrentStationDuration(System.currentTimeMillis() - r15);     // Catch: Exception -> L35
        if (r16.baseLocation == null) goto L28;
    L32:
        r12.onSuccess(ServerApi.uploadLightLocation(r16, r14, r10), r10);     // Catch: Exception -> L35
        return;
    L28:
        if (r16.wifiInfo != null) goto L32;
        if (r12 == null) goto L42;
        r12.onError(BDLocationException.ERROR_LIGHT_LOCATION_GET_CURRENT_STATION, "get current cell info error");     // Catch: Exception -> L35
        return;
    L42:
        return;
    L9:
        if (BDLightLocationCache.isGetWifiCacheList() == true) goto L14;
        r16.wifiInfo = getWifiInfoJson();     // Catch: Exception -> L35
        if (BDLightLocationCache.isGetCellCache() == true) goto L14;
        r16.baseLocation = BDLightLocationCache.getColdBootBaseStation();     // Catch: Exception -> L35
    L14:
        if (r16.baseLocation != null) goto L25;
        if (r16.wifiInfo != null) goto L25;
        if (r12 == null) goto L41;
        r12.onError(BDLocationException.ERROR_LIGHT_LOCATION_WIFI_LIST_ALREADY_UPLOAD, "wifi list already upload in v2");     // Catch: Exception -> L35
        return;
    L41:
        return;
    L33:
        r12.onError(BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO, "get current cell info error");     // Catch: Exception -> L35
    }

    public static void startLocateUpload(BDLocation r8, LocationUploadExtra r10, LocationUploadCallback r11) {
        if (BDLocationConfig.isUpload() == true) goto L5;
    L7:
        r11.onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_UPLOAD, r8.getLocationSDKName(), BDLocationException.ERROR_LOCATION_UPLOAD).getMessage());
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L7;
        AppExecutors.getInstance().networkIO().execute(new l(r8, r10, r11, 1));
    }

    private static void startUploadLocationMustInNetworkIOThreadPool(DeviceLocation r8, DeviceStatus r10, LocationUploadExtra r11, LocationUploadCallback r12, boolean r13, WifiInfo r14) {
        LocationResp r15 = ServerApi.uploadLocationInfoMustInNetworkIOThreadPool(r8, r10, r11);
        StringBuilder r16 = new StringBuilder("LocationUtil startLocation locationResp:");
        if (r15 != null) goto L5;
        boolean r17 = true;
    L6:
        r16.append(r17);
        Logger.i(r16.toString());
        if (r12 == null) goto L10;
        r12.onSuccess(r15, r13, r14);
        return;
    L10:
        return;
    L5:
        r17 = false;
        goto L6
    }

    public static int transformLocateMethod(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return 0;
    L5:
        if (r8.equals("GPSLocation") == false) goto L9;
        return 1;
    L9:
        if (r8.equals("WiFi") == false) goto L13;
        return 2;
    L13:
        if (r8.equals("bss") == false) goto L17;
        return 3;
    L17:
        if (r8.equals("IPLocation") == false) goto L21;
        return 6;
    L21:
        if (r8.equals("MCC") == false) goto L26;
        return 7;
    L26:
        return 0;
    }

    public static BDLocation transformLocationForLevel(BDLocation r8, int r10) {
        if (r10 != 4) goto L5;
        return r8;
    L5:
        BDLocation r11 = new BDLocation(r8);
        r11.setAccuracyLevel(r10);
        return r11;
    }

    public static void uploadCacheLocationInfo(LocationUploadExtra r8, LocationUploadCallback r10) {
        if (r8 == null) goto L5;
        LocationTraceLogger r11 = r8.getLocationTraceLogger();
    L6:
        DeviceStatus r12 = getDeviceStatus(BDLocationConfig.getContext(), r11);
        DeviceLocation r13 = new DeviceLocation();
        if (BDLocationConfig.isCollectLightInfo() == false) goto L9;
        SensorInfoManager.getInstance().unregisterListener(5);
        r13.lightInfoList = SensorInfoManager.getInstance().getLightInfoList();
    L10:
        LocationResp r14 = ServerApi.uploadCacheLocationInfo(r13, r12, r8);
        StringBuilder r15 = new StringBuilder("LocationUtil uploadCacheLocationInfo locationResp:");
        if (r14 != null) goto L13;
        boolean r16 = true;
    L14:
        r15.append(r16);
        Logger.i(r15.toString());
        if (r10 == null) goto L18;
        r10.onSuccess(r14, false, null);
        return;
    L18:
        return;
    L13:
        r16 = false;
        goto L14
    L9:
        Logger.i("LocationUtil.uploadCacheLocationInfo: skip light info.");
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static LocInfoRspData uploadDeviceStatus(String r8, int r10) {
        if (BDLocationConfig.isUploadMccAndSystemRegionInfo() == true) goto L5;
        return null;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L18;
        LocInfoRspData r11 = parseInfoRsp(ServerApi.uploadMccAndSystemRegionInfo(BDLocationConfig.getContext(), r8, r10));     // Catch: Exception -> L12
        if (r11 == null) goto L11;
        RegionCountry r12 = r11.regionCountry;     // Catch: Exception -> L12
        if (r12 == null) goto L11;
        Logger.i("uploadDeviceStatus RegionCountry:" + r12.toString());     // Catch: Exception -> L12
        BDLocationConfig.setRegionInChineseChannel(isRegionInChineseChannel(r12.geoNameID));     // Catch: Exception -> L12
    L11:
        return r11;
    L12:
        Logger.d("upload device status error");
        return null;
    L18:
        return null;
    }

    public static void withoutBpeaCertCheck(String r8) {
        LocationMonitor.withoutCert(r8);
        if (BDLocationConfig.isCheckLocationBpea() == true) goto L6;
        return;
    L6:
        throw new BDLocationException(BDLocationExceptionMessage.BPEA_CERT_CHECK_EXCEPTION, "unknown", BDLocationException.ERROR_BPEA_WITHOUT_CERT);
    }

    public static String allowUseLocation(boolean r8, boolean r10, boolean r11) {
        if (r11 == false) goto L8;
        if (checkBackground() == false) goto L8;
        Logger.i("check allowUseLocation isBackground");
        return BDLocationException.ERROR_BACKGROUND_LOCATE;
    L8:
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L11;
        Logger.i("check allowUseLocation isRestrictedModeOn");
        return BDLocationException.ERROR_RESTRICTED_MODE_ON;
    L11:
        if (r8 == true) goto L13;
    L16:
        if (r10 == true) goto L18;
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

    public static float calculateLineDistance(BDPoint r8, BDPoint r10) {
        BaseLocate r11 = BDLocationExtrasService.getLocate(BDLocationConfig.getContext(), 1);
        if (r11 != null) goto L5;
        return -1.0f;
    L5:
        return r11.calculateLineDistance(r8, r10);
    }

    public static boolean checkCacheTime(long r8, long r10, boolean r11) {
        if (r8 != 0) goto L5;
        return false;
    L5:
        long r12 = System.currentTimeMillis();
        Logger.i("LocationCache currentTimeMillis:" + r12 + "-locationTime:" + r8 + "-cacheTimeMS:" + r10 + "-needDefaultCache:" + r11);
        if (r11 == false) goto L9;
        r10 = r10 + 5000;
    L9:
        if (Math.abs(r12 - r8) < r10) goto L11;
        return false;
    L11:
        return true;
    }

    public static boolean disableLightLocationIfMockEnabled(Context r8, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return false;
    L5:
        if (LocationInfoConst.TEST_CHANNEL.contains(r10) == false) goto L12;
        Logger.i("disableLightLocationIfMockEnabled channel:" + r10);
        if (getLocationMockEnable(r8) == false) goto L13;
        Logger.i("disableLightLocationIfMockEnabled mock enable");
        return true;
    L13:
        return false;
    L12:
        return false;
    }

    public static boolean isBetterLocation(Location r8, Location r10, CacheConditionEntity r11) {
        if (r8 != null) goto L7;
        if (r11 == null) goto L6;
        r11.setConditionCode(1);
    L6:
        return false;
    L7:
        if (r10 != null) goto L12;
        if (r11 == null) goto L10;
        r11.setConditionCode(5);
    L10:
        return true;
    L12:
        if (BDLocationConfig.isUseNewCacheStrategy() == true) goto L14;
        long r12 = r8.getTime() - r10.getTime();     // Catch: Exception -> L61
        if (r12 <= 120000) goto L18;
        boolean r13 = true;
    L20:
        if (r12 >= (-120000)) goto L22;
        boolean r14 = true;
    L24:
        if (r12 <= 0) goto L26;
        boolean r15 = true;
    L27:
        if (r13 == false) goto L31;
        if (r11 == null) goto L30;
        r11.setConditionCode(6);     // Catch: Exception -> L61
    L30:
        return true;
    L31:
        if (r14 == false) goto L34;
        Logger.i("CheckNewLocation isSignificantlyOlder");     // Catch: Exception -> L61
        return false;
    L34:
        int r16 = (int) (r8.getAccuracy() - r10.getAccuracy());     // Catch: Exception -> L61
        if (r16 <= 0) goto L37;
        boolean r17 = true;
    L38:
        if (r16 >= 0) goto L40;
        boolean r18 = true;
    L42:
        if (r16 <= 200) goto L44;
        boolean r19 = true;
    L45:
        boolean r20 = isSameProvider(r8.getProvider(), r10.getProvider());     // Catch: Exception -> L61
        if (r18 == false) goto L50;
        if (r11 == null) goto L49;
        r11.setConditionCode(7);     // Catch: Exception -> L61
    L49:
        return true;
    L50:
        if (r15 == false) goto L55;
        if (r17 == true) goto L55;
        if (r11 == null) goto L54;
        r11.setConditionCode(8);     // Catch: Exception -> L61
    L54:
        return true;
    L55:
        if (r15 == false) goto L63;
        if (r19 == true) goto L63;
        if (r20 == false) goto L63;
        if (r11 == null) goto L60;
        r11.setConditionCode(9);     // Catch: Exception -> L61
    L60:
        return true;
    L63:
        return false;
    L44:
        r19 = false;
        goto L45
    L40:
        r18 = false;
        goto L42
    L37:
        r17 = false;
        goto L38
    L26:
        r15 = false;
        goto L27
    L22:
        r14 = false;
        goto L24
    L18:
        r13 = false;
    L61:
        e = move-exception;
        Logger.i(e.getMessage());
        goto L63
    L14:
        return newIsBetterLocation(r8, r10, r11);
    }

    public static boolean isGoodLocation(BDLocation r8, CacheConditionEntity r10) {
        if (r8 != null) goto L33;
        if (r10 == null) goto L6;
        r10.setConditionCode(1);
    L6:
        return false;
    L33:
        long r11 = Calendar.getInstance().getTimeInMillis();     // Catch: Exception -> L28
        if (BDLocationConfig.isUseNewCacheStrategy() == true) goto L16;
        if ((r11 - r8.getTime()) < 30000) goto L16;
        Logger.i("CheckNewLocation not goodLocation");     // Catch: Exception -> L28
        if (r10 == null) goto L14;
        r10.setConditionCode(10);     // Catch: Exception -> L28
    L14:
        return false;
    L16:
        if (r8.getAccuracy() <= 500.0f) goto L21;
        if (r10 == null) goto L19;
        r10.setConditionCode(11);     // Catch: Exception -> L28
    L19:
        return false;
    L21:
        if (r8.getLocationType() != 3) goto L25;
        if (r10 == null) goto L24;
        r10.setConditionCode(12);     // Catch: Exception -> L28
    L24:
        return false;
    L25:
        if (r10 == null) goto L27;
        r10.setConditionCode(14);
    L27:
        return true;
    L28:
        e = move-exception;
        Logger.i(e.getMessage());
        if (r10 == null) goto L32;
        r10.setConditionCode(13);
    L32:
        return false;
    }

    @SuppressLint({"WrongConstant"})
    public static BDLocation locationResultToBDLocation(BDLocation r12, LocationResult r13, int r14, float r15) {
        if (r13 != null) goto L5;
        return null;
    L5:
        if (r12 != null) goto L7;
        BDLocation r16 = new BDLocation("bd_geocode", "unKnown");
        r16.setGeocodeSDKName(SystemBaseLocationImpl.LBS_GEOCODE_NAME);
    L8:
        PlaceInfo r8 = r13.country;
        if (r8 == null) goto L11;
        r16.setCountry(r8.name);
        r16.setCountryCode(r8.code);
        r16.setCountryId(r8.geoNameID);
        r16.setCountryAsciName(r8.asciName);
        r16.setCountryLocalID(r8.localID);
    L11:
        Place r10 = r13.place;
        if (r10 != null) goto L14;
    L16:
        PlaceInfo[] r11 = r13.subdivisions;
        if (r11 == null) goto L22;
        if (r11.length <= 0) goto L22;
        r16.setAdministrativeArea(r11[0].name);
        r16.setSubdivisionId(r11[0].geoNameID);
        r16.setSubdivisionAsciName(r11[0].asciName);
    L22:
        if (r11 != null) goto L24;
    L26:
        PlaceInfo r17 = r13.city;
        if (r17 == null) goto L29;
        r16.setCity(r17.name);
        r16.setLocalID(r17.localID);
        r16.setGeoNameID(String.valueOf(r17.geoNameID));
        r16.setCityId(r17.geoNameID);
        r16.setCityAsciName(r17.asciName);
    L29:
        PlaceInfo r18 = r13.district;
        if (r18 == null) goto L32;
        r16.setDistrict(r18.name);
        r16.setDistrictId(r18.geoNameID);
        r16.setDistrictAsciName(r18.asciName);
        r16.setDistrictLocalID(r18.localID);
    L32:
        RuralInfo r19 = r13.town;
        if (r19 == null) goto L35;
        r16.setTown(r19.name);
        r16.setTownId(r19.geoNameID);
        r16.setTownAsciName(r19.asciName);
    L35:
        RuralInfo r20 = r13.village;
        if (r20 == null) goto L38;
        r16.setVillage(r20.name);
        r16.setVillageId(r20.geoNameID);
        r16.setVillageAsciName(r20.asciName);
    L38:
        GPSResult r21 = r13.gps;
        if (r21 == null) goto L46;
        r16.setAccuracy((float) r21.accuracy);
        double r22 = r21.latitude;
        if (r22 != 0.0d) goto L43;
    L45:
        r16.setLocationType(r21.locateType);
        goto L46
    L43:
        if (r22 == 0.0d) goto L45;
        r16.setLatitude(r22);
        r16.setLongitude(r21.longitude);
        r16.setCoordinateSystem(r21.coordinateSystem);
        r16.setHasServerLatLng(true);
    L46:
        List<PoiInfoEntity> r23 = r13.poiList;
        if (r23 == null) goto L49;
        Collections.sort(r23);
        r16.setPoiEntities(r13.poiList);
    L49:
        List<PoiInfoEntity> r24 = r13.aoiList;
        if (r24 == null) goto L53;
        Collections.sort(r24);
        r16.setAoiEntities(r13.aoiList);
    L53:
        if (r13.isDisputed == false) goto L60;
        if (r8 != null) goto L60;
        if (r11 != null) goto L60;
        if (r17 != null) goto L60;
        if (r18 != null) goto L60;
        if (r10 != null) goto L60;
        r16 = new BDLocation("", "");
    L60:
        r16.setIsDisputed(r13.isDisputed);
        r16.setIsCompliance(true);
        r16.setLocationResult(r13);
        r16.setTime(r13.timestamp * 1000);
        s r25 = r13.extra;
        if (r25 == null) goto L63;
        r16.setExtra(r25.toString());
    L63:
        String r110 = r13.locateMethod;
        if (r110 == null) goto L66;
        r16.setServerLocateMethod(r110);
    L66:
        r16.setServerLocateSuccess(true);
        r16.setInOutDoorStatus(r14);
        r16.setInOutDoorConfidence(r15);
        r16.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());
        return r16;
    L24:
        if (r11.length <= 1) goto L26;
        r16.setSubAdministrativeArea(r11[1].name);
        goto L26
    L14:
        if (CollectionUtil.isEmpty(r10.addressLines) == true) goto L16;
        r16.setAddress(r10.addressLines.get(0));
        goto L16
    L7:
        r16 = new BDLocation(r12);
        goto L8
    }
}
