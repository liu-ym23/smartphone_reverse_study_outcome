package com.bytedance.bdlocation.init;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.ISceneStatusCallback;
import com.bytedance.bdlocation.callback.LightLocationSubmitNotification;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.callback.RegionUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.entity.region.RegionBean;
import com.bytedance.bdlocation.event.LocationEvent;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationMonitorUtil;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.notification.SubmitNotification;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import com.bytedance.bdlocation.scan.wifi.WifiInfoModule;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import com.bytedance.bdlocation.store.BDLightLocationCache;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.utils.BDLocationReflectUtils;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import o5.a;
import o5.b;
import o5.c;
import o5.d;
import o5.e;
import o5.f;
import o5.g;
import o5.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationHelper {
    private static BDLocationHelper sInstance;
    private volatile boolean sIsRegister;
    private AtomicBoolean sIsRequestCellInfo;
    private AtomicBoolean sIsRequestWifiInfo;

    public BDLocationHelper() {
        this.sIsRequestCellInfo = new AtomicBoolean();
        this.sIsRequestWifiInfo = new AtomicBoolean();
    }

    private void addErrorMonitorData(JSONObject r8, String r10, String r11) {
        JsonUtil.safePutBoolean(r8, LocationMonitorConst.IS_SUCCESS, false);
        JsonUtil.safePutString(r8, LocationMonitorConst.ERR_CODE, r10);
        JsonUtil.safePutString(r8, LocationMonitorConst.ERR_MSG, r11);
    }

    public static void addLightLocationSubmitNotification(LightLocationSubmitNotification r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SubmitNotification.getInstance().addLightLocationSubmitNotification(r8);
    }

    public static void addNotification(LocationNotification r8, int r10) {
        Handler r11 = g.f9675m;
        if (r11 == null) goto L7;
        r11.post(new a(r8, r10));
        return;
    }

    public static void addSubmitNotification(Object r8, LocationSubmitNotification r10) {
        if (r10 != null) goto L12;
        return;
    L12:
        LocationUtil.checkBpeaCertNull("addSubmitNotification", r8);     // Catch: BDLocationException -> L10
        Handler r11 = g.f9675m;
        if (r11 == null) goto L14;
        r11.post(new d(r8, r10));
        return;
    L14:
        return;
    L10:
        Logger.i("addSubmitNotification checkBpeaCertNull error");
    }

    private static void checkConfiguration(LocationInitConfig r8) {
        if (r8.getContext() != null) goto L5;
        Logger.i("context is null!");
        throw new IllegalStateException("The context must be configured before initialization of SDK");
    L5:
        if (TextUtils.isEmpty(r8.getBaseUrl()) == false) goto L7;
        Logger.i("base url is empty");
        throw new IllegalStateException("The base url must be configured before initialization of SDK");
    L7:
        if (r8.isPrivacyConfirmed() == false) goto L9;
        return;
    L9:
        Logger.i("Privacy not Confirmed");
        throw new IllegalStateException("The Privacy must be Confirmed before initialization of SDK");
    }

    private boolean executeInit(LocationInitConfig r11) {
        long r8 = System.currentTimeMillis();
        Logger.i("init start time:" + r8);
        Logger.addPrinter(r11.getALogPrinter());
        BDLocationConfig.setDebug(r11.getDebug());
        BDLocationConfig.setDeviceId(r11.getDid());
        BDLocationConfig.setAppId(r11.getAppId());
        BDLocationConfig.setChannel(r11.getChannel());
        BDLocationConfig.setAppVersion(r11.getAppVersion());
        BDLocationConfig.setUpdateVersionCode(r11.getUpdateVersionCode());
        BDLocationConfig.setPackageName(r11.getPackageName());
        BDLocationConfig.setPollingUpload(r11.isPollingUpload());
        BDLocationConfig.setAppBootTime(r11.getAppBootTime());
        BDLocationConfig.setLocateType(r11.getLocateType());
        BDLocationConfig.setLocale(r11.getLocale());
        BDLocationConfig.setWorldView(r11.getWorldView());
        BDLocationConfig.setBaseUrl(r11.getBaseUrl());
        BDLocationConfig.setAppBackgroundProvider(r11.getBackgroundProvider());
        BDLocationConfig.setPrivacyConfirmed(r11.isPrivacyConfirmed());
        BDLocationConfig.setNetworkApi(r11.getCustomNetworkApi());
        BDLocationConfig.setRestrictedMode(r11.getRestrictedMode());
        BDLocationConfig.setEventManager(r11.getEventManager());
        BDLocationConfig.setEnableHARCollect(r11.isEnableHARCollect());
        BDLocationConfig.setBpeaCerts(r11.getBpeaCerts());
        BDLocationConfig.setILocationInfoExtra(r11.getILocationInfoExtra());
        BDLocationConfig.setPermissionChecker(r11.getPermissionChecker());
        BDLocationConfig.setDYHostInfoProvider(r11.getDYHostInfoProvider());
        BDLocationConfig.setEnableBackgroundLocation(r11.enableBackgroundLocation());
        BDLocationConfig.setEnableSelfStartService(r11.enableSelfStartService());
        LocationMonitorUtil.init(r11.getContext());
        BDLocationConfig.init(r11.getContext());
        g.j();
        long r10 = System.currentTimeMillis();
        long r12 = r11.getAppBootTime();
        long r13 = 0;
        if (r12 <= 0) goto L5;
        r13 = r10 - r12;
    L5:
        Logger.i("init end time:" + r10 + "--AppBootTime:" + r12);
        LocationMonitor.uploadInitInfo(r13, r12, r10 - r8);
        return true;
    }

    public static BDLocationHelper getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(BDLocationHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new BDLocationHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDLocationHelper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void removeLightLocationSubmitNotification(LightLocationSubmitNotification r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        SubmitNotification.getInstance().removeLightLocationSubmitNotification(r8);
    }

    public static void removeNotification(LocationNotification r8, int r10) {
        Handler r11 = g.f9675m;
        if (r11 == null) goto L7;
        r11.post(new c(r8, r10));
        return;
    }

    public static void removeSubmitNotification(LocationSubmitNotification r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Handler r10 = g.f9675m;
        if (r10 == null) goto L9;
        r10.post(new e(r8));
        return;
    }

    public BDPoint convertGCJ02(BDPoint r8) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        g.j().getClass();
        return LocationUtil.convertGCJ02(r8);
    }

    public BdGisResult geocode(double r10, double r11, int r13, Object r14) {
        return geocode(r10, r11, r13, r14, 0);
    }

    public BDLocation getIPLocation(Object r8, int r10) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getIPLocation", r8);
        if (g.j().d(r8) == false) goto L10;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r8, "getIPLocation");
    L10:
        return LocationUtil.getIPResult(r10);
    }

    public BDLocation getLastKnowLocation(int r8, boolean r10) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.withoutBpeaCertCheck("getLastKnowLocation");
        g.j().getClass();
        return g.k(r8, r10, true);
    }

    public void getLightLocation(Object r11, String r12, boolean r13) {
        g r8 = g.j();
        r8.getClass();
        long r10 = System.currentTimeMillis();
        long r14 = r10 - BDLocationConfig.getAppBootTime();
        Logger.i("start getLightLocation:" + r10 + "-isColdBoot:" + r13);
        if (BDLocationConfig.enableLightLocation() == true) goto L6;
        Logger.i("getLightLocation unable");
        return;
    L6:
        if (g.o(null) == true) goto L9;
        Logger.i("getLightLocation checkInit error");
        String r15 = BDLocationException.ERROR_INIT_LOCATION;
        String r16 = "location checkInit error";
    L14:
        LocationMonitor.doLightLocationError(r15, r16, r13, false);
        return;
    L9:
        if (LocationUtil.disableLightLocationIfMockEnabled() == false) goto L11;
        Logger.i("getLightLocation test channel:" + BDLocationConfig.getChannel());
        r15 = BDLocationException.ERROR_LIGHT_LOCATION_WHEN_MOCK_ENABLED;
        r16 = "mock enabled";
        goto L14
    L11:
        r15 = LocationUtil.allowUseLocation(true);
        if ("1".equals(r15) == true) goto L15;
        Logger.i("getLightLocation unable use location allowLocation:" + r15);
        r16 = "unable use location";
        goto L14
    L15:
        AppExecutors.getInstance().networkIO().execute(new f(r8, r11, r12, r10, r13, r14));
    }

    public String getLightLocationInfoBeforeInit(Context r17, String r18, boolean r19, long r20, String r22, boolean r23, int r24, int r25) {
        if (LocationUtil.disableLightLocationIfMockEnabled(r17, r18) == false) goto L6;
        Logger.i("getLightLocationInfoBeforeInit test channel:" + r18);
        return null;
    L6:
        long r8 = System.currentTimeMillis();
        JSONObject r10 = new JSONObject();
        String r11 = BDLightLocationCache.getCurrentStation();
        JsonUtil.safePutString(r10, LocationInfoConst.LIGHT_LOCATION_UPLOAD_CELL_KEY, r11);
        String r12 = BDLightLocationCache.getWifiCacheList();
        JsonUtil.safePutString(r10, LocationInfoConst.LIGHT_LOCATION_UPLOAD_WIFI_KEY, r12);
        boolean r13 = false;
        if (BDLightLocationCache.isCellDowngrade() == false) goto L9;
    L12:
        boolean r14 = true;
    L13:
        JsonUtil.safePutBoolean(r10, "is_downgrade", r14);
        JSONObject r15 = new JSONObject();
        Logger.i("getLightLocationInfoBeforeInit coldBootTime:" + r20);
        if (r20 <= 0) goto L16;
        JsonUtil.safePutLong(r15, LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION, r8 - r20);
    L16:
        JsonUtil.safePutLong(r15, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE, r23);
        JsonUtil.safePutInt(r15, LocationMonitorConst.HAS_LOCATION_PERMISSION, BDLightLocationCache.hasLocationPermission());
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST, BDLightLocationCache.isStartRequestCellInfo());
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST, BDLightLocationCache.isEndRequestCellInfo());
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST, BDLightLocationCache.isStartRequestWifiInfo());
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST, BDLightLocationCache.isEndRequestWifiInfo());
        JsonUtil.safePutString(r15, LocationMonitorConst.LIGHT_LOCATION_TYPE, r22);
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.IS_COLD_BOOT, r19);
        JsonUtil.safePutBoolean(r15, "is_downgrade", r14);
        JsonUtil.safePutLong(r15, LocationMonitorConst.APP_BOOT_TIME, r20);
        JsonUtil.safePutInt(r15, LocationMonitorConst.FEED_HAS_AVAILABLE_DATA, r24);
        JsonUtil.safePutInt(r15, LocationMonitorConst.FEED_CALL_TYPE, r25);
        boolean r16 = !TextUtils.isEmpty(r11);
        boolean r21 = !TextUtils.isEmpty(r12);
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.HAS_CELL_LOCATION_INFO, r16);
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.HAS_WIFI_LOCATION_INFO, r21);
        if (r21 == true) goto L19;
        if (r16 == true) goto L19;
    L20:
        JsonUtil.safePutBoolean(r15, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, r13);
        JsonUtil.safePutLong(r15, "total_duration", System.currentTimeMillis() - r8);
        BDLightLocationCache.setLightLocationMonitorData(r15);
        BDLightLocationCache.setIsGetWifiCacheList(r21);
        BDLightLocationCache.setIsGetCellCache(r16);
        Logger.i("getLightLocationInfoBeforeInit totalDuration:" + (System.currentTimeMillis() - r8));
        if (r16 == true) goto L26;
        if (r21 == true) goto L26;
        return null;
    L26:
        return r10.toString();
    L19:
        r13 = true;
        goto L20
    L9:
        if (BDLightLocationCache.isWifiDowngrade() == true) goto L12;
        r14 = false;
        goto L13
    }

    public RegionBean getRegion(boolean r8) {
        if (initIfNeed() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return BDLocationExtrasService.getRegionDataCore().getRegion(r8);
    }

    public ISceneStatusCallback getSceneStatusCallback() {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        g.j().getClass();
        return g.d.f9703a;
    }

    public synchronized void init(LocationInitConfig r8) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.sIsRegister == false) goto L19;
        Logger.i("location already init");     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L19:
        checkConfiguration(r8);     // Catch: Exception -> L11 Throwable -> L15
        executeInit(r8);     // Catch: Exception -> L11 Throwable -> L15
        this.sIsRegister = true;     // Catch: Exception -> L11 Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        Logger.i("init error:" + e.toString());     // Catch: Throwable -> L15
        this.sIsRegister = false;     // Catch: Throwable -> L15
        goto L13
    }

    public boolean initIfNeed() {
        if (this.sIsRegister == false) goto L6;
        return true;
    L6:
        BDLocationReflectUtils.weakEnsureAwemeLocationInit();
        return this.sIsRegister;
    }

    public boolean isInit() {
        return this.sIsRegister;
    }

    public void requestCellUpdateBeforeInit(Context r20, boolean r21, long r22, boolean r24, long r25, boolean r27, long r28) {
        BDLocationConfig.setEnableGetNeighboringCell(r27);
        BDLightLocationCache.setStartRequestCellInfo(true);
        BDLightLocationCache.setLightLocationCacheInterval(r28);
        long r10 = System.currentTimeMillis();
        JSONObject r12 = new JSONObject();
        if (r20 != null) goto L7;
        Logger.i("requestCellUpdate context must not be null");     // Catch: Exception -> L36
        return;
    L7:
        if (this.sIsRequestCellInfo.getAndSet(true) == false) goto L9;
        return;
    L9:
        Logger.i("requestCellUpdate coldBootTime:" + r22);     // Catch: Exception -> L36
        if (r22 <= 0) goto L14;
        JsonUtil.safePutLong(r12, LocationMonitorConst.COLD_BOOT_TO_START_REQUEST, r10 - r22);     // Catch: Exception -> L36
    L14:
        if (PermissionManager.hasAnyPermission(r20, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L34;
        JsonUtil.safePutLong(r12, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, r28);     // Catch: Exception -> L36
        if (r28 > 0) goto L18;
    L21:
        BDLightLocationCache.setHasLocationPermission(PermissionManager.LOCATION_PERMISSION_OK);     // Catch: Exception -> L36
        JsonUtil.safePutInt(r12, LocationMonitorConst.HAS_LOCATION_PERMISSION, PermissionManager.LOCATION_PERMISSION_OK);     // Catch: Exception -> L36
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.ENABLE_GET_NEIGHBORING_CELL, r27);     // Catch: Exception -> L36
        BaseStation r8 = LocationUtil.getLightBaseStation(r20, null, true, r27);     // Catch: Exception -> L36
        if (r8 != null) goto L24;
    L33:
        String r11 = BDLocationException.ERROR_NO_DATA;
        String r13 = "no cell info";
    L20:
        addErrorMonitorData(r12, r11, r13);     // Catch: Exception -> L36
    L38:
        BDLightLocationCache.setEndRequestCellInfo(true);
        long r14 = System.currentTimeMillis() - r10;
        Logger.i("requestCellUpdate totalDuration:" + r14);
        JsonUtil.safePutLong(r12, "total_duration", r14);
        JsonUtil.safePutBoolean(r12, "is_downgrade", r24);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_COLD_BOOT, r21);
        JsonUtil.safePutLong(r12, LocationMonitorConst.EXECUTE_CALLBACK_DURATION, r25);
        BDLightLocationCache.setIsCellDowngrade(r24);
        BDLightLocationCache.setRequestCellUpdateMonitorData(r12);
        return;
    L24:
        if (r8.current == null) goto L26;
    L27:
        BDLightLocationCache.setColdBootBaseStation(r8);     // Catch: Exception -> L36
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, true);     // Catch: Exception -> L36
        JSONObject r15 = new JSONObject();     // Catch: Exception -> L36
        JsonUtil.convertBssInfoToJSON(r15, r8, r27);     // Catch: Exception -> L36
        String r16 = ServerApi.packFingerprint(r15.toString());     // Catch: Exception -> L36
        Logger.i("requestCellUpdate currentStation:" + r16);     // Catch: Exception -> L36
        BDLightLocationCache.setCurrentStation(r16);     // Catch: Exception -> L36
        if (r22 <= 0) goto L30;
        JsonUtil.safePutLong(r12, LocationMonitorConst.COLD_BOOT_TO_END_REQUEST, System.currentTimeMillis() - r22);     // Catch: Exception -> L36
    L30:
        JsonUtil.safePutLong(r12, LocationMonitorConst.CACHE_DATA_INTERVAL, System.currentTimeMillis() - (r8.current.timestamp * 1000));     // Catch: Exception -> L36
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_SUCCESS, true);     // Catch: Exception -> L36
        JsonUtil.safePutString(r12, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);     // Catch: Exception -> L36
        if (r28 <= 0) goto L38;
        BDLightLocationCache.setLastLocationTime(r20, System.currentTimeMillis());     // Catch: Exception -> L36
        goto L38
    L26:
        if (r8.neighboring == null) goto L33;
    L18:
        if (Math.abs(System.currentTimeMillis() - BDLightLocationCache.getLastLocationTime(r20)) >= r28) goto L21;
        Logger.i("requestCellUpdate cache time is too short");     // Catch: Exception -> L36
        r11 = BDLocationException.ERROR_LIGHT_LOCATION_IN_CACHE;
        r13 = "location in cache interval";
        goto L20
    L34:
        BDLightLocationCache.setHasLocationPermission(PermissionManager.LOCATION_PERMISSION_NO);     // Catch: Exception -> L36
        JsonUtil.safePutInt(r12, LocationMonitorConst.HAS_LOCATION_PERMISSION, PermissionManager.LOCATION_PERMISSION_NO);     // Catch: Exception -> L36
        r11 = BDLocationException.ERROR_SDK_NO_PERMISSION;
        r13 = "no location permission";
    L36:
        e = move-exception;
        addErrorMonitorData(r12, BDLocationException.ERROR_CODE_EXCEPTION, Log.getStackTraceString(e));
        goto L38
    }

    public void requestLocationPermission(Activity r8, Object r10, int r11, RequestPermissionUtils.OnPermissionListener r12) {
        if (initIfNeed() == true) goto L31;
        r12.onPermissionDenied();
        String r13 = "must be init";
    L26:
        Logger.i(r13);
        return;
    L31:
        LocationUtil.checkBpeaCertNull("requestLocationPermission", r10);     // Catch: BDLocationException -> L25
        g r14 = g.j();
        r14.getClass();
        if (PermissionManager.canRequestLocationPermission() == true) goto L10;
        r12.onPermissionDenied();
        return;
    L10:
        if (PermissionManager.hasLocationPermissions(BDLocationConfig.getContext()) == false) goto L29;
    L23:
        r12.onPermissionGranted();
        return;
    L29:
        if (r14.d(r10) == false) goto L14;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r10, "requestLocationPermissionWithCert");     // Catch: Exception -> L28
    L14:
        LocationEvent.onRequestPermission();     // Catch: Exception -> L28
        if (r11 != 0) goto L18;
        String[] r15 = {"android.permission.ACCESS_FINE_LOCATION"};     // Catch: Exception -> L28
    L21:
        RequestPermissionUtils.requestPermissionsLimited(r8, r15, new n(r12));     // Catch: Exception -> L28
        return;
    L18:
        if (r11 != 1) goto L20;
        r15 = new String[]{"android.permission.ACCESS_COARSE_LOCATION"};     // Catch: Exception -> L28
        goto L21
    L20:
        r15 = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};     // Catch: Exception -> L28
    L25:
        r12.onPermissionDenied();
        r13 = "checkBpeaCertNull error";
        goto L26
    }

    public void requestWifiUpdateBeforeInit(Context r22, boolean r23, long r24, boolean r26, long r27, long r29) {
        BDLightLocationCache.setStartRequestWifiInfo(true);
        BDLightLocationCache.setLightLocationCacheInterval(r29);
        long r10 = System.currentTimeMillis();
        JSONObject r12 = new JSONObject();
        if (r22 != null) goto L7;
        Logger.i("requestWifiUpdate context must not be null");     // Catch: Exception -> L38
        return;
    L7:
        if (this.sIsRequestWifiInfo.getAndSet(true) == false) goto L9;
        return;
    L9:
        Logger.i("requestWifiUpdate coldBootTime:" + r24);     // Catch: Exception -> L38
        if (r24 <= 0) goto L44;
        JsonUtil.safePutLong(r12, LocationMonitorConst.COLD_BOOT_TO_START_REQUEST, r10 - r24);     // Catch: Exception -> L38
    L44:
        if (PermissionManager.hasAnyPermission(r22, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L34;
        JsonUtil.safePutLong(r12, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, r29);     // Catch: Exception -> L38
        if (r29 > 0) goto L18;
    L20:
        BDLightLocationCache.setHasLocationPermission(PermissionManager.LOCATION_PERMISSION_OK);     // Catch: Exception -> L38
        JsonUtil.safePutInt(r12, LocationMonitorConst.HAS_LOCATION_PERMISSION, PermissionManager.LOCATION_PERMISSION_OK);     // Catch: Exception -> L38
        WifiInfoModule r8 = WifiUtil.getWifiModule(r22, true);     // Catch: Exception -> L38
        BDLightLocationCache.setWifiCacheModule(r8);     // Catch: Exception -> L38
        if (r8 == null) goto L32;
        List<WifiInfo> r11 = r8.wifiInfoList;     // Catch: Exception -> L38
        if (r11 == null) goto L32;
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, true);     // Catch: Exception -> L38
        JSONObject r14 = new JSONObject();     // Catch: Exception -> L38
        JsonUtil.convertWifiInfoToJSON(r14, r11);     // Catch: Exception -> L38
        long r15 = System.currentTimeMillis();     // Catch: Exception -> L38
        String r13 = ServerApi.packFingerprint(r14.toString());     // Catch: Exception -> L38
        StringBuilder r16 = new StringBuilder("packFingerprintDuration:");     // Catch: Exception -> L38
        r10 = r10;
        r16.append(System.currentTimeMillis() - r15);     // Catch: Exception -> L36
        Logger.i(r16.toString());     // Catch: Exception -> L36
        Logger.i("requestWifiUpdate wifiList:" + r13);     // Catch: Exception -> L36
        BDLightLocationCache.setWifiCacheList(r13);     // Catch: Exception -> L36
        if (r24 <= 0) goto L29;
        JsonUtil.safePutLong(r12, LocationMonitorConst.COLD_BOOT_TO_END_REQUEST, System.currentTimeMillis() - r24);     // Catch: Exception -> L36
    L29:
        JsonUtil.safePutLong(r12, LocationMonitorConst.CACHE_DATA_INTERVAL, System.currentTimeMillis() - r8.cacheWifiTime);     // Catch: Exception -> L36
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_SUCCESS, true);     // Catch: Exception -> L36
        if (r29 <= 0) goto L41;
        BDLightLocationCache.setLastLocationTime(r22, System.currentTimeMillis());     // Catch: Exception -> L36
    L41:
        BDLightLocationCache.setEndRequestWifiInfo(true);
        long r17 = System.currentTimeMillis() - r10;
        Logger.i("requestWifiUpdate totalDuration:" + r17);
        JsonUtil.safePutLong(r12, "total_duration", r17);
        JsonUtil.safePutBoolean(r12, "is_downgrade", r26);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_COLD_BOOT, r23);
        JsonUtil.safePutLong(r12, LocationMonitorConst.EXECUTE_CALLBACK_DURATION, r27);
        BDLightLocationCache.setIsWifiDowngrade(r26);
        BDLightLocationCache.setRequestWifiCacheUpdateMonitorData(r12);
        return;
    L32:
        String r18 = BDLocationException.ERROR_NO_DATA;
        String r19 = "no wifi info";
    L33:
        addErrorMonitorData(r12, r18, r19);     // Catch: Exception -> L36
        goto L41
    L18:
        if (Math.abs(System.currentTimeMillis() - BDLightLocationCache.getLastLocationTime(r22)) >= r29) goto L20;
        Logger.i("requestWifiUpdate cache time is too short");     // Catch: Exception -> L38
        addErrorMonitorData(r12, BDLocationException.ERROR_LIGHT_LOCATION_IN_CACHE, "location in cache interval");     // Catch: Exception -> L38
        r10 = r10;
        goto L41
    L34:
        BDLightLocationCache.setHasLocationPermission(PermissionManager.LOCATION_PERMISSION_NO);     // Catch: Exception -> L36
        JsonUtil.safePutInt(r12, LocationMonitorConst.HAS_LOCATION_PERMISSION, PermissionManager.LOCATION_PERMISSION_NO);     // Catch: Exception -> L36
        r18 = BDLocationException.ERROR_SDK_NO_PERMISSION;
        r19 = "no location permission";
    L36:
        e = e;
    L40:
        addErrorMonitorData(r12, BDLocationException.ERROR_CODE_EXCEPTION, Log.getStackTraceString(e));
    L38:
        e = e;
        r10 = r10;
        goto L40
    }

    public void setBaseUrl(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        BDLocationConfig.setBaseUrl(r8);
    }

    public void updateSettings(Context r8, JSONObject r10) {
        LocationSettingUtil.updateSettings(r8, r10);
    }

    public boolean uploadRegionInfo() {
        if (initIfNeed() == true) goto L7;
        Logger.i("must be init");
        return false;
    L7:
        return BDLocationExtrasService.getRegionDataCore().uploadRegionInfo();
    }

    public void uploadRegionInfoAsync(RegionUploadCallback r8) {
        if (initIfNeed() == true) goto L6;
        r8.onUpLoadResult(false, null);
        Logger.i("must be init");
        return;
    L6:
        BDLocationExtrasService.getRegionDataCore().uploadRegionInfoAsync(r8);
    }

    public static void addNotification(LocationNotification r8, Object r10) {
        Handler r11 = g.f9675m;
        if (r11 == null) goto L7;
        r11.post(new b(r8, r10));
        return;
    }

    public BdGisResult geocode(double r10, double r11, int r13, Object r14, int r15) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("geocode", r14);
        return g.j().i(r10, r11, r13, r14, r15);
    }

    public BDLocation getLastKnowLocation(Object r8) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getLastKnowLocation", r8);
        Logger.i("BDLocationHelper getLastKnowLocation start");
        BDLocation r10 = g.j().l(r8, true);
        Logger.i("BDLocationHelper getLastKnowLocation end");
        return r10;
    }

    public RegionBean getRegion(boolean r8, boolean r10) {
        if (initIfNeed() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return BDLocationExtrasService.getRegionDataCore().getRegion(r8, r10);
    }

    public BdGisResult geocode(double r10, double r11, int r13, boolean r14) {
        return geocode(r10, r11, r13, r14, 0);
    }

    public BDLocation getLastKnowLocation(Object r8, int r10, boolean r11) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getLastKnowLocation", r8);
        g r12 = g.j();
        if (r12.d(r8) == false) goto L10;
        return r12.l(r8, r11);
    L10:
        return g.k(r10, true, r11);
    }

    public BdGisResult geocode(double r10, double r11, int r13, boolean r14, int r15) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.withoutBpeaCertCheck("geocode");
        g r8 = g.j();
        r8.getClass();
        g.f(r14);
        return r8.i(r10, r11, r13, null, r15);
    }
}
