package com.bytedance.bdlocation.init;

import android.app.Activity;
import android.content.Context;
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
import com.bytedance.bdlocation.utils.BDLocationReflectUtils;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.bytedance.bdlocation_impl.c.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
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

    private void addErrorMonitorData(JSONObject r2, String r3, String r4) {
        JsonUtil.safePutBoolean(r2, LocationMonitorConst.IS_SUCCESS, false);
        JsonUtil.safePutString(r2, LocationMonitorConst.ERR_CODE, r3);
        JsonUtil.safePutString(r2, LocationMonitorConst.ERR_MSG, r4);
    }

    public static void addLightLocationSubmitNotification(LightLocationSubmitNotification r2) {
        LightLocationSubmitNotification r3 = (LightLocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r2, LightLocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        SubmitNotification.getInstance().addLightLocationSubmitNotification(r3);
    }

    public static void addNotification(LocationNotification r2, int r3) {
        a.a((LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin"), r3);
    }

    public static void addNotification(LocationNotification r2, Object r3) {
        a.a((LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin"), r3);
    }

    public static void addSubmitNotification(Object r2, LocationSubmitNotification r3) {
        LocationSubmitNotification r4 = (LocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r3, LocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L10;
        return;
    L10:
        LocationUtil.checkBpeaCertNull("addSubmitNotification", r2);     // Catch: BDLocationException -> L8
        a.a(r2, r4);
        return;
    L8:
        Logger.i("addSubmitNotification checkBpeaCertNull error");
    }

    private static void checkConfiguration(LocationInitConfig r3) {
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) != null) goto L5;
        Logger.i("context is null!");
        throw new IllegalStateException("The context must be configured before initialization of SDK");
    L5:
        if (TextUtils.isEmpty(r3.getBaseUrl()) == false) goto L7;
        Logger.i("base url is empty");
        throw new IllegalStateException("The base url must be configured before initialization of SDK");
    L7:
        if (r3.isPrivacyConfirmed() == false) goto L9;
        return;
    L9:
        Logger.i("Privacy not Confirmed");
        throw new IllegalStateException("The Privacy must be Confirmed before initialization of SDK");
    }

    private boolean executeInit(LocationInitConfig r11) {
        long r0 = System.currentTimeMillis();
        Logger.i("init start time:" + r0);
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
        LocationMonitorUtil.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        BDLocationConfig.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        a.a();
        long r2 = System.currentTimeMillis();
        long r6 = r11.getAppBootTime();
        long r10 = 0;
        if (r6 <= 0) goto L5;
        r10 = r2 - r6;
    L5:
        Logger.i("init end time:" + r2 + "--AppBootTime:" + r6);
        LocationMonitor.uploadInitInfo(r10, r6, r2 - r0);
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

    public static void removeLightLocationSubmitNotification(LightLocationSubmitNotification r2) {
        LightLocationSubmitNotification r3 = (LightLocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r2, LightLocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        SubmitNotification.getInstance().removeLightLocationSubmitNotification(r3);
    }

    public static void removeNotification(LocationNotification r2, int r3) {
        a.b((LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin"), r3);
    }

    public static void removeSubmitNotification(LocationSubmitNotification r2) {
        LocationSubmitNotification r3 = (LocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        a.a(r3);
    }

    public BDPoint convertGCJ02(BDPoint r1) {
        if (initIfNeed() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return a.a().a(r1);
    }

    public BdGisResult geocode(double r9, double r11, int r13, Object r14) {
        return geocode(r9, r11, r13, r14, 0);
    }

    public BdGisResult geocode(double r9, double r11, int r13, Object r14, int r15) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("geocode", r14);
        return a.a().a(r9, r11, r13, r14, r15);
    }

    public BdGisResult geocode(double r9, double r11, int r13, boolean r14) {
        return geocode(r9, r11, r13, r14, 0);
    }

    public BdGisResult geocode(double r9, double r11, int r13, boolean r14, int r15) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.withoutBpeaCertCheck("geocode");
        return a.a().a(r9, r11, r13, r14, r15);
    }

    public BDLocation getIPLocation(Object r1, int r2) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getIPLocation", r1);
        return a.a().a(r1, r2);
    }

    public BDLocation getLastKnowLocation(int r2, boolean r3) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.withoutBpeaCertCheck("getLastKnowLocation");
        return a.a().a(r2, r3, true);
    }

    public BDLocation getLastKnowLocation(Object r2) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getLastKnowLocation", r2);
        Logger.i("BDLocationHelper getLastKnowLocation start");
        BDLocation r1 = a.a().a(r2, true);
        Logger.i("BDLocationHelper getLastKnowLocation end");
        return r1;
    }

    public BDLocation getLastKnowLocation(Object r1, int r2, boolean r3) {
        if (initIfNeed() == true) goto L6;
        Logger.i("must be init");
        return null;
    L6:
        LocationUtil.checkBpeaCertNull("getLastKnowLocation", r1);
        return a.a().a(r1, r2, r3);
    }

    public void getLightLocation(Object r1, String r2, boolean r3) {
        a.a().a(r1, r2, r3);
    }

    public String getLightLocationInfoBeforeInit(Context r17, String r18, boolean r19, long r20, String r22, boolean r23, int r24, int r25) {
        if (LocationUtil.disableLightLocationIfMockEnabled((Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.memorydata.plugin"), r18) == false) goto L6;
        Logger.i("getLightLocationInfoBeforeInit test channel:" + r18);
        return null;
    L6:
        long r5 = System.currentTimeMillis();
        JSONObject r0 = new JSONObject();
        String r3 = BDLightLocationCache.getCurrentStation();
        JsonUtil.safePutString(r0, LocationInfoConst.LIGHT_LOCATION_UPLOAD_CELL_KEY, r3);
        String r7 = BDLightLocationCache.getWifiCacheList();
        JsonUtil.safePutString(r0, LocationInfoConst.LIGHT_LOCATION_UPLOAD_WIFI_KEY, r7);
        boolean r9 = false;
        if (BDLightLocationCache.isCellDowngrade() == false) goto L9;
    L12:
        boolean r8 = true;
    L13:
        JsonUtil.safePutBoolean(r0, "is_downgrade", r8);
        JSONObject r12 = new JSONObject();
        Logger.i("getLightLocationInfoBeforeInit coldBootTime:" + r20);
        if (r20 <= 0) goto L16;
        JsonUtil.safePutLong(r12, LocationMonitorConst.COLD_BOOT_TO_GET_LIGHT_LOCATION_INFO_DURATION, r5 - r20);
    L16:
        JsonUtil.safePutLong(r12, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, BDLightLocationCache.getLightLocationCacheInterval());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_ACTIVITY_COMPONENT_TYPE, r23);
        JsonUtil.safePutInt(r12, LocationMonitorConst.HAS_LOCATION_PERMISSION, BDLightLocationCache.hasLocationPermission());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_START_CELL_LIGHT_REQUEST, BDLightLocationCache.isStartRequestCellInfo());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_END_CELL_LIGHT_REQUEST, BDLightLocationCache.isEndRequestCellInfo());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_START_WIFI_LIGHT_REQUEST, BDLightLocationCache.isStartRequestWifiInfo());
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_END_WIFI_LIGHT_REQUEST, BDLightLocationCache.isEndRequestWifiInfo());
        JsonUtil.safePutString(r12, LocationMonitorConst.LIGHT_LOCATION_TYPE, r22);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.IS_COLD_BOOT, r19);
        JsonUtil.safePutBoolean(r12, "is_downgrade", r8);
        JsonUtil.safePutLong(r12, LocationMonitorConst.APP_BOOT_TIME, r20);
        JsonUtil.safePutInt(r12, LocationMonitorConst.FEED_HAS_AVAILABLE_DATA, r24);
        JsonUtil.safePutInt(r12, LocationMonitorConst.FEED_CALL_TYPE, r25);
        boolean r1 = !TextUtils.isEmpty(r3);
        boolean r2 = !TextUtils.isEmpty(r7);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.HAS_CELL_LOCATION_INFO, r1);
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.HAS_WIFI_LOCATION_INFO, r2);
        if (r2 == true) goto L19;
        if (r1 == true) goto L19;
    L20:
        JsonUtil.safePutBoolean(r12, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, r9);
        JsonUtil.safePutLong(r12, "total_duration", System.currentTimeMillis() - r5);
        BDLightLocationCache.setLightLocationMonitorData(r12);
        BDLightLocationCache.setIsGetWifiCacheList(r2);
        BDLightLocationCache.setIsGetCellCache(r1);
        Logger.i("getLightLocationInfoBeforeInit totalDuration:" + (System.currentTimeMillis() - r5));
        if (r1 == true) goto L26;
        if (r2 == true) goto L26;
        return null;
    L26:
        return r0.toString();
    L19:
        r9 = true;
        goto L20
    L9:
        if (BDLightLocationCache.isWifiDowngrade() == true) goto L12;
        r8 = false;
        goto L13
    }

    public RegionBean getRegion(boolean r1) {
        if (initIfNeed() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return BDLocationExtrasService.getRegionDataCore().getRegion(r1);
    }

    public RegionBean getRegion(boolean r1, boolean r2) {
        if (initIfNeed() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return BDLocationExtrasService.getRegionDataCore().getRegion(r1, r2);
    }

    public ISceneStatusCallback getSceneStatusCallback() {
        if (initIfNeed() == true) goto L7;
        Logger.i("must be init");
        return null;
    L7:
        return a.a().f();
    }

    public synchronized void init(LocationInitConfig r3) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.sIsRegister == false) goto L18;
        Logger.i("location already init");     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L18:
        checkConfiguration(r3);     // Catch: Exception -> L10 Throwable -> L14
        executeInit(r3);     // Catch: Exception -> L10 Throwable -> L14
        this.sIsRegister = true;     // Catch: Exception -> L10 Throwable -> L14
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        Logger.i("init error:" + e.toString());     // Catch: Throwable -> L14
        this.sIsRegister = false;     // Catch: Throwable -> L14
        goto L12
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

    public void requestCellUpdateBeforeInit(Context r19, boolean r20, long r21, boolean r23, long r24, boolean r26, long r27) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        BDLocationConfig.setEnableGetNeighboringCell(r26);
        BDLightLocationCache.setStartRequestCellInfo(true);
        BDLightLocationCache.setLightLocationCacheInterval(r27);
        long r8 = System.currentTimeMillis();
        JSONObject r10 = new JSONObject();
        if (r6 != null) goto L7;
        Logger.i("requestCellUpdate context must not be null");     // Catch: Exception -> L36
        return;
    L7:
        if (this.sIsRequestCellInfo.getAndSet(true) == false) goto L9;
        return;
    L9:
        Logger.i("requestCellUpdate coldBootTime:" + r21);     // Catch: Exception -> L36
        if (r21 <= 0) goto L14;
        JsonUtil.safePutLong(r10, LocationMonitorConst.COLD_BOOT_TO_START_REQUEST, r8 - r21);     // Catch: Exception -> L36
    L14:
        if (PermissionManager.hasAnyPermission(r6, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L34;
        JsonUtil.safePutLong(r10, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, r27);     // Catch: Exception -> L36
        if (r27 > 0) goto L18;
    L21:
        BDLightLocationCache.setHasLocationPermission(PermissionManager.LOCATION_PERMISSION_OK);     // Catch: Exception -> L36
        JsonUtil.safePutInt(r10, LocationMonitorConst.HAS_LOCATION_PERMISSION, PermissionManager.LOCATION_PERMISSION_OK);     // Catch: Exception -> L36
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.ENABLE_GET_NEIGHBORING_CELL, r26);     // Catch: Exception -> L36
        BaseStation r4 = LocationUtil.getLightBaseStation(r6, null, true, r26);     // Catch: Exception -> L36
        if (r4 != null) goto L24;
    L33:
        String r0 = BDLocationException.ERROR_NO_DATA;
        String r2 = "no cell info";
    L20:
        addErrorMonitorData(r10, r0, r2);     // Catch: Exception -> L36
    L38:
        BDLightLocationCache.setEndRequestCellInfo(true);
        long r1 = System.currentTimeMillis() - r8;
        Logger.i("requestCellUpdate totalDuration:" + r1);
        JsonUtil.safePutLong(r10, "total_duration", r1);
        JsonUtil.safePutBoolean(r10, "is_downgrade", r23);
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_COLD_BOOT, r20);
        JsonUtil.safePutLong(r10, LocationMonitorConst.EXECUTE_CALLBACK_DURATION, r24);
        BDLightLocationCache.setIsCellDowngrade(r23);
        BDLightLocationCache.setRequestCellUpdateMonitorData(r10);
        return;
    L24:
        if (r4.current == null) goto L26;
    L27:
        BDLightLocationCache.setColdBootBaseStation(r4);     // Catch: Exception -> L36
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, true);     // Catch: Exception -> L36
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L36
        JsonUtil.convertBssInfoToJSON(r5, r4, r26);     // Catch: Exception -> L36
        String r3 = ServerApi.packFingerprint(r5.toString());     // Catch: Exception -> L36
        Logger.i("requestCellUpdate currentStation:" + r3);     // Catch: Exception -> L36
        BDLightLocationCache.setCurrentStation(r3);     // Catch: Exception -> L36
        if (r21 <= 0) goto L30;
        JsonUtil.safePutLong(r10, LocationMonitorConst.COLD_BOOT_TO_END_REQUEST, System.currentTimeMillis() - r21);     // Catch: Exception -> L36
    L30:
        JsonUtil.safePutLong(r10, LocationMonitorConst.CACHE_DATA_INTERVAL, System.currentTimeMillis() - (r4.current.timestamp * 1000));     // Catch: Exception -> L36
        JsonUtil.safePutBoolean(r10, LocationMonitorConst.IS_SUCCESS, true);     // Catch: Exception -> L36
        JsonUtil.safePutString(r10, LocationMonitorConst.ERR_CODE, BDLocationException.SUCCESS);     // Catch: Exception -> L36
        if (r27 <= 0) goto L38;
        BDLightLocationCache.setLastLocationTime(r6, System.currentTimeMillis());     // Catch: Exception -> L36
        goto L38
    L26:
        if (r4.neighboring == null) goto L33;
    L18:
        if (Math.abs(System.currentTimeMillis() - BDLightLocationCache.getLastLocationTime(r6)) >= r27) goto L21;
        Logger.i("requestCellUpdate cache time is too short");     // Catch: Exception -> L36
        r0 = BDLocationException.ERROR_LIGHT_LOCATION_IN_CACHE;
        r2 = "location in cache interval";
        goto L20
    L34:
        BDLightLocationCache.setHasLocationPermission(PermissionManager.LOCATION_PERMISSION_NO);     // Catch: Exception -> L36
        JsonUtil.safePutInt(r10, LocationMonitorConst.HAS_LOCATION_PERMISSION, PermissionManager.LOCATION_PERMISSION_NO);     // Catch: Exception -> L36
        r0 = BDLocationException.ERROR_SDK_NO_PERMISSION;
        r2 = "no location permission";
    L36:
        e = move-exception;
        addErrorMonitorData(r10, BDLocationException.ERROR_CODE_EXCEPTION, Log.getStackTraceString(e));
        goto L38
    }

    public void requestLocationPermission(Activity r3, Object r4, int r5, RequestPermissionUtils.OnPermissionListener r6) {
        Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        RequestPermissionUtils.OnPermissionListener r8 = (RequestPermissionUtils.OnPermissionListener) ZeusTransformUtils.wrapperContextForParams(r6, RequestPermissionUtils.OnPermissionListener.class, "com.obric.memorydata.plugin");
        if (initIfNeed() == true) goto L11;
        r8.onPermissionDenied();
        Logger.i("must be init");
        return;
    L11:
        LocationUtil.checkBpeaCertNull("requestLocationPermission", r4);     // Catch: BDLocationException -> L9
        a.a().a(r7, r4, r5, r8);
        return;
    L9:
        r8.onPermissionDenied();
        Logger.i("checkBpeaCertNull error");
    }

    public void requestWifiUpdateBeforeInit(Context r20, boolean r21, long r22, boolean r24, long r25, long r27) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        BDLightLocationCache.setStartRequestWifiInfo(true);
        BDLightLocationCache.setLightLocationCacheInterval(r27);
        long r7 = System.currentTimeMillis();
        JSONObject r9 = new JSONObject();
        if (r0 != null) goto L7;
        Logger.i("requestWifiUpdate context must not be null");     // Catch: Exception -> L34
        return;
    L7:
        if (this.sIsRequestWifiInfo.getAndSet(true) == false) goto L9;
        return;
    L9:
        Logger.i("requestWifiUpdate coldBootTime:" + r22);     // Catch: Exception -> L34
        if (r22 <= 0) goto L14;
        JsonUtil.safePutLong(r9, LocationMonitorConst.COLD_BOOT_TO_START_REQUEST, r7 - r22);     // Catch: Exception -> L34
    L14:
        if (PermissionManager.hasAnyPermission(r0, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L32;
        JsonUtil.safePutLong(r9, LocationMonitorConst.LIGHT_LOCATION_CACHE_INTERVAL, r27);     // Catch: Exception -> L34
        if (r27 > 0) goto L18;
    L21:
        BDLightLocationCache.setHasLocationPermission(PermissionManager.LOCATION_PERMISSION_OK);     // Catch: Exception -> L34
        JsonUtil.safePutInt(r9, LocationMonitorConst.HAS_LOCATION_PERMISSION, PermissionManager.LOCATION_PERMISSION_OK);     // Catch: Exception -> L34
        WifiInfoModule r4 = WifiUtil.getWifiModule(r0, true);     // Catch: Exception -> L34
        BDLightLocationCache.setWifiCacheModule(r4);     // Catch: Exception -> L34
        if (r4 != null) goto L24;
    L31:
        String r1 = BDLocationException.ERROR_NO_DATA;
        String r2 = "no wifi info";
    L20:
        addErrorMonitorData(r9, r1, r2);     // Catch: Exception -> L34
    L36:
        BDLightLocationCache.setEndRequestWifiInfo(true);
        long r3 = System.currentTimeMillis() - r7;
        Logger.i("requestWifiUpdate totalDuration:" + r3);
        JsonUtil.safePutLong(r9, "total_duration", r3);
        JsonUtil.safePutBoolean(r9, "is_downgrade", r24);
        JsonUtil.safePutBoolean(r9, LocationMonitorConst.IS_COLD_BOOT, r21);
        JsonUtil.safePutLong(r9, LocationMonitorConst.EXECUTE_CALLBACK_DURATION, r25);
        BDLightLocationCache.setIsWifiDowngrade(r24);
        BDLightLocationCache.setRequestWifiCacheUpdateMonitorData(r9);
        return;
    L24:
        if (r4.wifiInfoList == null) goto L31;
        List<WifiInfo> r5 = r4.wifiInfoList;     // Catch: Exception -> L34
        JsonUtil.safePutBoolean(r9, LocationMonitorConst.HAS_LIGHT_LOCATION_INFO, true);     // Catch: Exception -> L34
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L34
        JsonUtil.convertWifiInfoToJSON(r11, r5);     // Catch: Exception -> L34
        long r13 = System.currentTimeMillis();     // Catch: Exception -> L34
        String r6 = ServerApi.packFingerprint(r11.toString());     // Catch: Exception -> L34
        Logger.i("packFingerprintDuration:" + (System.currentTimeMillis() - r13));     // Catch: Exception -> L34
        Logger.i("requestWifiUpdate wifiList:" + r6);     // Catch: Exception -> L34
        BDLightLocationCache.setWifiCacheList(r6);     // Catch: Exception -> L34
        if (r22 <= 0) goto L28;
        JsonUtil.safePutLong(r9, LocationMonitorConst.COLD_BOOT_TO_END_REQUEST, System.currentTimeMillis() - r22);     // Catch: Exception -> L34
    L28:
        JsonUtil.safePutLong(r9, LocationMonitorConst.CACHE_DATA_INTERVAL, System.currentTimeMillis() - r4.cacheWifiTime);     // Catch: Exception -> L34
        JsonUtil.safePutBoolean(r9, LocationMonitorConst.IS_SUCCESS, true);     // Catch: Exception -> L34
        if (r27 <= 0) goto L36;
        BDLightLocationCache.setLastLocationTime(r0, System.currentTimeMillis());     // Catch: Exception -> L34
        goto L36
    L18:
        if (Math.abs(System.currentTimeMillis() - BDLightLocationCache.getLastLocationTime(r0)) >= r27) goto L21;
        Logger.i("requestWifiUpdate cache time is too short");     // Catch: Exception -> L34
        r1 = BDLocationException.ERROR_LIGHT_LOCATION_IN_CACHE;
        r2 = "location in cache interval";
        goto L20
    L32:
        BDLightLocationCache.setHasLocationPermission(PermissionManager.LOCATION_PERMISSION_NO);     // Catch: Exception -> L34
        JsonUtil.safePutInt(r9, LocationMonitorConst.HAS_LOCATION_PERMISSION, PermissionManager.LOCATION_PERMISSION_NO);     // Catch: Exception -> L34
        r1 = BDLocationException.ERROR_SDK_NO_PERMISSION;
        r2 = "no location permission";
    L34:
        e = move-exception;
        addErrorMonitorData(r9, BDLocationException.ERROR_CODE_EXCEPTION, Log.getStackTraceString(e));
        goto L36
    }

    public void setBaseUrl(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        BDLocationConfig.setBaseUrl(r1);
    }

    public void updateSettings(Context r2, JSONObject r3) {
        LocationSettingUtil.updateSettings((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3);
    }

    public boolean uploadRegionInfo() {
        if (initIfNeed() == true) goto L7;
        Logger.i("must be init");
        return false;
    L7:
        return BDLocationExtrasService.getRegionDataCore().uploadRegionInfo();
    }

    public void uploadRegionInfoAsync(RegionUploadCallback r3) {
        RegionUploadCallback r4 = (RegionUploadCallback) ZeusTransformUtils.wrapperContextForParams(r3, RegionUploadCallback.class, "com.obric.memorydata.plugin");
        if (initIfNeed() == true) goto L6;
        r4.onUpLoadResult(false, null);
        Logger.i("must be init");
        return;
    L6:
        BDLocationExtrasService.getRegionDataCore().uploadRegionInfoAsync(r4);
    }
}
