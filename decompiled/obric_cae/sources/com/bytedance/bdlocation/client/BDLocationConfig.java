package com.bytedance.bdlocation.client;

import android.aimedia.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDRestrictedMode;
import com.bytedance.bdlocation.callback.IDYHostInfoProvider;
import com.bytedance.bdlocation.callback.ILocationInfoExtra;
import com.bytedance.bdlocation.callback.IPermissionChecker;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.entity.LogIdCacheEntity;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.event.IEventManager;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.ICustomNetworkApi;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.bluetooth.BLECacheEntity;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.settings.LocationSettingUtil;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.utils.BDLocationReflectUtils;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import z.g;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationConfig {
    private static final String DEFAULT_SLARDAR_AID = "306184";
    public static final String ENABLE_BPEA_CACHE_KEY = "enable_bpea_cache";
    private static final String OPEN_STATIONARY_SCENE_LOCK = "open_stationary_scene_lock";
    private static String RESTRICTED_LOCK = null;
    public static final String TAG = "BDLocation";
    private static boolean isDebug = false;
    private static volatile boolean isInit = false;
    private static boolean isPrivacyConfirmed = false;
    private static BLECacheEntity mBleCacheEntity = null;
    private static boolean mEnableTraceroute = false;
    private static LogIdCacheEntity mLogIdCacheEntity = null;
    private static JSONObject mShakeConfig = null;
    private static boolean sAllowFetchConfigAtStart = false;
    private static boolean sAllowLocateFallback = true;
    private static long sAppBootTime = 0;
    private static String sAppId = null;
    private static String sAppVersion = null;
    private static boolean sAsyncScanWifi = false;
    private static int sBaseStationInfoType = 0;
    private static String sBaseUrl = null;
    private static JSONObject sBeaconConfig = null;
    private static long sBootLegitimateTime = 3000;
    private static Map<String, Object> sBpeaCerts = null;
    private static int sBssNum = 10;
    private static String sByteLocationLibraParam = null;
    private static String sByteLocationWhiteList = null;
    private static String sChannel = null;
    private static boolean sCheckLocationBpea = false;
    private static long sCheckRefreshWifiTimeInterval = 0;
    private static boolean sColdBootABTest = false;
    private static boolean sColdBootCollectGps = false;
    private static int sColdBootCollectGpsStrategy = 0;
    private static long sCollectContinuousGPSDuration = 0;
    private static long sCollectContinuousGPSInterval = 0;
    private static String sCollectContinuousGPSTokenBlacklist = null;
    private static boolean sCollectContinuousGpsDisableGnssUpload = false;
    private static boolean sCollectContinuousGpsOnlyLast = false;
    private static int sCollectGpsType = 0;
    private static boolean sCollectLightInfo = false;
    private static Map<String, String> sCommonParams = null;
    private static int sConnectWifiRssi = 0;

    @SuppressLint({"StaticFieldLeak", "CI_StaticFieldLeak"})
    private static volatile Context sContext = null;
    private static IDYHostInfoProvider sDYHostInfoProvider = null;
    private static long sDefaultGpsScanInterval = 0;
    private static String sDeviceId = null;
    private static String sDisableCollectAMapLocationSource = null;
    private static String sDisableTailLocateOptimizeSource = null;
    private static List<String> sDisableUuidList = null;
    private static boolean sEenableBackgroundUploadLocation = false;
    private static boolean sEnableBackgroundLocation = false;
    private static boolean sEnableBlePassiveName = false;
    private static boolean sEnableBleTruncateOnTimeout = false;
    private static boolean sEnableBpea = false;
    private static boolean sEnableByteContinuousLocation = false;
    private static boolean sEnableCheckConnectWifi = false;
    private static boolean sEnableCheckLastLogId = false;
    private static boolean sEnableCheckRefreshWifiTime = false;
    private static boolean sEnableCheckUploadCompliance = false;
    private static boolean sEnableCollectAMapLocationInBatterySavingMode = false;
    private static boolean sEnableCollectBleInBatterySavingMode = false;
    private static boolean sEnableCollectContinuousGPSLocation = false;
    private static boolean sEnableCollectContinuousGpsForTest = false;
    private static boolean sEnableCollectGPSLocationInBatterySavingMode = false;
    private static boolean sEnableCollectNetworkLocationInBatterySavingMode = false;
    private static boolean sEnableContinueLocateUploadCell = false;
    private static boolean sEnableContinueLocateUploadWifi = false;
    private static boolean sEnableDestroyAMapContinuousClient = false;
    private static boolean sEnableDestroyAMapSingleClient = false;
    private static boolean sEnableDimLocationCheck = false;
    private static volatile boolean sEnableGetNeighboringCell = false;
    private static boolean sEnableGpsScan = false;
    private static boolean sEnableHARCollect = false;
    private static boolean sEnableInfoRequestOpt = false;
    private static boolean sEnableLightLocation = false;
    private static boolean sEnableLightLocationNewPolicy = false;
    private static boolean sEnableLocationCacheTokenWhiteList = false;
    private static String sEnableLocationOptBpeaList = "";
    private static boolean sEnableLocationOptEncrypt = false;
    private static boolean sEnableMonitor = false;
    private static boolean sEnablePreLocationCallback = false;
    private static boolean sEnableRescanWifi = false;
    private static boolean sEnableScanGnss = false;
    private static boolean sEnableScanWifi = false;
    private static boolean sEnableSelfStartService = false;
    private static boolean sEnableStationaryScenePolicy = false;
    private static boolean sEnableTailLocateOptimize = false;
    private static boolean sEnableUploadLastLocationInfo = false;
    private static boolean sEnableUploadLastLogId = false;
    private static boolean sEnableUseCoarseLocation = false;
    private static Pair<String, String> sEnv = null;
    private static IEventManager sEventManager = null;
    private static long sFirstLocationTimeoutMs = 0;
    private static boolean sFirstRequestLocation = false;
    private static long sFreshBaseStationTimeout = 0;
    private static long sGpsScanInterval = 0;
    private static int sHARStatusRange = 0;
    private static int sHotBootCacheTime = 0;
    private static String sHotBootLocToken = null;
    private static long sInOutDoorStatusCacheTime = 0;
    private static long sInfoRequestKeyParamsMaxCacheTime = 0;
    private static long sInitStartTime = 0;
    private static volatile int sInvokerApiInitStatus = 0;
    private static boolean sIsAMapGPSCollectAlwaysUseNewAMapClient = true;
    private static boolean sIsChineseChannel = false;
    private static boolean sIsFirstLocation = false;
    private static boolean sIsIndepentThreadGetScanResults = false;
    private static boolean sIsMockEnable = false;
    private static boolean sIsMockUpload = false;
    private static boolean sIsNoLocReqCgiEnable = false;
    private static boolean sIsPollingUpload = false;
    private static boolean sIsStrictRestrictedMode = false;
    private static boolean sIsSysNetworkLocEnable = false;
    private static boolean sIsUpload = true;
    private static boolean sIsUploadBaseSite = true;
    private static boolean sIsUploadFreshBaseStation = false;
    private static boolean sIsUploadGPS = true;
    private static boolean sIsUploadLocation = true;
    private static boolean sIsUploadWIFI = true;
    private static boolean sIsUseQuickGPS = false;
    private static int sLightInfoInterval = 0;
    private static long sLocalDefaultGpsScanInterval = 0;
    private static Locale sLocale = null;
    private static int sLocateType = 0;
    private static String sLocationCacheTokenWhiteList = null;
    private static long sLocationExpiredInterval = 0;
    private static ILocationInfoExtra sLocationInfoExtra = null;
    private static int sLocationMode = 0;
    private static int sMaxLightCount = 0;
    private static long sMaxLightDuration = 0;
    private static long sMaxLocationTimeMs = 300000;
    private static long sMaxWaitGpsTimeMillis = 0;
    private static String sMockWifiName = null;
    private static List<String> sMonitorBusinessStartLocationClassMemberList = null;
    private static List<String> sMonitorBusinessStopLocationClassMemberList = null;
    private static int sMonitorStrategy = 0;
    private static List<String> sMonitorStrategyClassMemberList = null;
    private static long sMonitorStrategyInterval = 0;
    private static boolean sNeedDownGradeLocationInOverseas = false;
    private static boolean sNeedUploadLastContinuousLocation = false;
    private static ICustomNetworkApi sNetworkApi = null;
    private static String sNetworkSignatureMode = null;
    private static long sNetworkStatusChangeUploadInterval = 60000;
    private static SparseArray<List<LocationNotification>> sNotifications = null;
    private static boolean sOnline = false;
    private static boolean sOpenStationaryScene = false;
    private static boolean sOpenWifiListMonitor = false;
    private static long sOverseasGetLocationFailedUseCacheValidity = 0;
    private static String sPackageName = null;
    private static IPermissionChecker sPermissionChecker = null;
    private static BackgroundProvider sProvider = null;
    private static String sRedGeoNameIds = null;
    private static boolean sRegionInChineseChannel = false;
    private static boolean sReportAtStart = true;
    private static boolean sReportLocationAtStart = false;
    private static int sRescanWifiCount = 0;
    private static BDRestrictedMode sRestrictedMode = null;
    private static boolean sRevertToSystemLocation = false;
    private static boolean sScanBle = false;
    private static long sScanBleInterval = 0;
    public static final long sScanBleMaxInterval = 10000;
    private static String sSdkVersion = null;
    private static long sSearchLocationCacheTime = 0;
    private static String sSessionId = null;
    private static boolean sShouldRequestLocation = false;
    private static String sSlardarAid = null;
    private static int sStationarySceneMaxDistance = 0;
    private static int sStationarySceneMaxGpsAccuracy = 0;
    private static long sStationarySceneMaxInterval = 0;
    private static String sStationarySceneTokenWhiteList = null;
    private static String sStationarySceneWifiWhiteList = null;
    private static List<LocationSubmitNotification> sSubmitNotifications = null;
    private static float sTailAccuracyThreshold = 0.0f;
    private static long sTailWifiTimeThreshold = 0;
    private static String sUpdateVersionCode = null;
    private static boolean sUploadBleImmediately = false;
    private static int sUploadBleNum = 0;
    private static long sUploadInterval = 300000;
    private static boolean sUploadMccAndSystemRegionInfo = true;
    private static long sUploadNetSignalInterval = 0;
    private static boolean sUseCacheCondition = false;
    private static boolean sUseGpsCheckRegion = false;
    private static boolean sUseNewCacheStrategy = false;
    private static boolean sUseNewReverseGeoLocationApi = false;
    private static int sWifiNum = 30;
    private static long sWifiScanInterval;
    private static String sWorldView;

    static {
        sLocale = Locale.getDefault();
        sIsChineseChannel = true;
        sLocateType = 3;
        RESTRICTED_LOCK = "RESTRICTED_LOCK";
        sIsStrictRestrictedMode = false;
        sBaseUrl = "";
        sNotifications = new SparseArray();
        isPrivacyConfirmed = false;
        sOnline = true;
        sIsMockEnable = false;
        sIsMockUpload = true;
        isInit = false;
        sSlardarAid = DEFAULT_SLARDAR_AID;
        sDeviceId = "";
        sAppId = "";
        sSdkVersion = BuildConfig.BDLOCATION_VERSION;
        sChannel = "";
        sAppVersion = "";
        sUpdateVersionCode = "";
        sPackageName = "";
        sEnableHARCollect = false;
        sHARStatusRange = 64;
        sEnableBpea = true;
        sUploadBleNum = 30;
        sScanBleInterval = 1000;
        sScanBle = false;
        sEnableBlePassiveName = true;
        sEnableBleTruncateOnTimeout = true;
        sCheckLocationBpea = false;
        sLocationMode = 2;
        sSubmitNotifications = null;
        sFirstRequestLocation = true;
        sOverseasGetLocationFailedUseCacheValidity = LocationInfoConst.defaultsOverseasCacheValidity;
        sRegionInChineseChannel = true;
        sRedGeoNameIds = LocationInfoConst.defaultRedGeoNameIds;
        sIsFirstLocation = true;
        sUseNewCacheStrategy = false;
        sCollectLightInfo = false;
        sRevertToSystemLocation = false;
        sLightInfoInterval = 3;
        sMaxLightCount = 30;
        sMaxLightDuration = 5000;
        sGpsScanInterval = 0;
        sEnableGpsScan = false;
        sAsyncScanWifi = true;
        sConnectWifiRssi = -60;
        sCheckRefreshWifiTimeInterval = 10000;
        sEnableScanWifi = true;
        sUseNewReverseGeoLocationApi = false;
        sIsNoLocReqCgiEnable = false;
        sIsSysNetworkLocEnable = true;
        sEnableMonitor = false;
        sMonitorStrategy = 0;
        sMonitorStrategyInterval = 3000;
        sMonitorStrategyClassMemberList = new ArrayList();
        sMonitorBusinessStartLocationClassMemberList = new ArrayList();
        sMonitorBusinessStopLocationClassMemberList = new ArrayList();
        sEnableBackgroundLocation = false;
        sInfoRequestKeyParamsMaxCacheTime = WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        sEnableInfoRequestOpt = false;
        sMaxWaitGpsTimeMillis = 0;
        sEnablePreLocationCallback = false;
        sEnableSelfStartService = true;
        sByteLocationLibraParam = LocationInfoConst.LIBRA_PARAM_V2;
        sSearchLocationCacheTime = -1;
        sByteLocationWhiteList = "";
        sCollectGpsType = 0;
        sEnableRescanWifi = false;
        sRescanWifiCount = 60;
        sUseCacheCondition = false;
        sDisableCollectAMapLocationSource = LocationInfoConst.UNKNOWN_SOURCE;
        sEnableLocationCacheTokenWhiteList = false;
        sLocationCacheTokenWhiteList = "";
        sHotBootLocToken = "";
        sHotBootCacheTime = -1;
        sColdBootCollectGpsStrategy = 0;
        sColdBootCollectGps = false;
        sEnableCollectGPSLocationInBatterySavingMode = false;
        sEnableCollectNetworkLocationInBatterySavingMode = false;
        sEnableCollectAMapLocationInBatterySavingMode = false;
        sEnableCollectBleInBatterySavingMode = false;
        sEnableUploadLastLogId = true;
        sNetworkSignatureMode = "";
        sDefaultGpsScanInterval = 0;
        sLocalDefaultGpsScanInterval = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        sEnableCheckUploadCompliance = true;
        sEenableBackgroundUploadLocation = false;
        sEnableCheckLastLogId = true;
        sEnableUseCoarseLocation = false;
        sEnableDimLocationCheck = false;
        sEnableTailLocateOptimize = false;
        sTailAccuracyThreshold = 100.0f;
        sTailWifiTimeThreshold = 300000;
        sDisableTailLocateOptimizeSource = LocationInfoConst.UNKNOWN_SOURCE;
        sIsUploadFreshBaseStation = false;
        sFreshBaseStationTimeout = 0;
        sEnableUploadLastLocationInfo = false;
        sEnableCollectContinuousGPSLocation = false;
        sCollectContinuousGPSInterval = 1000;
        sCollectContinuousGPSDuration = 5000;
        sCollectContinuousGPSTokenBlacklist = "";
        sCollectContinuousGpsDisableGnssUpload = false;
        sCollectContinuousGpsOnlyLast = true;
        sInOutDoorStatusCacheTime = 600000;
        sEnableScanGnss = true;
        sEnableStationaryScenePolicy = false;
        sOpenStationaryScene = false;
        sStationarySceneMaxInterval = 1800000;
        sStationarySceneMaxDistance = 50;
        sStationarySceneMaxGpsAccuracy = 50;
        sStationarySceneWifiWhiteList = "";
        sStationarySceneTokenWhiteList = "";
        sEnableCollectContinuousGpsForTest = false;
        sEnableGetNeighboringCell = false;
        sEnableContinueLocateUploadWifi = true;
        sEnableContinueLocateUploadCell = true;
        sInvokerApiInitStatus = -1;
        sEnableByteContinuousLocation = true;
        sUploadNetSignalInterval = 30000;
        sLocationExpiredInterval = 100000;
        sFirstLocationTimeoutMs = 10000;
        sNeedUploadLastContinuousLocation = true;
        sIsUseQuickGPS = false;
        sColdBootABTest = false;
    }

    public BDLocationConfig() {
    }

    public static /* synthetic */ void a(int r8, BDLocation r10) {
        lambda$notificationLocationChange$0(r8, r10);
    }

    public static void addNotification(LocationNotification r8, int r10) {
        long r11 = System.currentTimeMillis();
        String r12 = RESTRICTED_LOCK;
        monitor-enter(r12);
        LocationUtil.withoutBpeaCertCheck("addNotification");     // Catch: Throwable -> L6 Exception -> L8
        switchNotification(r10).add(r8);     // Catch: Throwable -> L6 Exception -> L8
        Logger.i("addNotification interval:" + (System.currentTimeMillis() - r11));     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r12);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Logger.d("addNotification change withoutBpeaCertCheck error:" + e.getMessage());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static void addSubmitNotification(Object r8, LocationSubmitNotification r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r8 == null) goto L14;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r8, "addSubmitNotification");     // Catch: BDLocationException -> L11
        if (sSubmitNotifications != null) goto L9;
        sSubmitNotifications = new CopyOnWriteArrayList();     // Catch: BDLocationException -> L11
    L9:
        sSubmitNotifications.add(r10);     // Catch: BDLocationException -> L11
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L14:
        if (sSubmitNotifications != null) goto L16;
        sSubmitNotifications = new CopyOnWriteArrayList();
    L16:
        sSubmitNotifications.add(r10);
    }

    public static int checkConnectWifiRssi() {
        return sConnectWifiRssi;
    }

    public static long checkRefreshWifiTimeInterval() {
        return sCheckRefreshWifiTimeInterval;
    }

    public static boolean enableBackgroundLocation() {
        return sEnableBackgroundLocation;
    }

    public static boolean enableBackgroundUploadLocation() {
        return sEenableBackgroundUploadLocation;
    }

    public static boolean enableBlePassiveName() {
        return sEnableBlePassiveName;
    }

    public static boolean enableBleTruncateOnTimeout() {
        return sEnableBleTruncateOnTimeout;
    }

    public static boolean enableBpea() {
        return sEnableBpea;
    }

    public static boolean enableByteContinuousLocation() {
        return sEnableByteContinuousLocation;
    }

    public static boolean enableCheckConnectWifi() {
        return sEnableCheckConnectWifi;
    }

    public static boolean enableCheckLastLogId() {
        return sEnableCheckLastLogId;
    }

    public static boolean enableCheckRefreshWifiTime() {
        return sEnableCheckRefreshWifiTime;
    }

    public static boolean enableCheckUploadCompliance() {
        return sEnableCheckUploadCompliance;
    }

    public static boolean enableCollectAMapLocationInBatterySavingMode() {
        return sEnableCollectAMapLocationInBatterySavingMode;
    }

    public static boolean enableCollectBleInBatterySavingMode() {
        return sEnableCollectBleInBatterySavingMode;
    }

    public static boolean enableCollectContinuousGPSLocation() {
        return sEnableCollectContinuousGPSLocation;
    }

    public static boolean enableCollectContinuousGpsForTest() {
        return sEnableCollectContinuousGpsForTest;
    }

    public static boolean enableCollectGPSLocationInBatterySavingMode() {
        return sEnableCollectGPSLocationInBatterySavingMode;
    }

    public static boolean enableCollectNetworkLocationInBatterySavingMode() {
        return sEnableCollectNetworkLocationInBatterySavingMode;
    }

    public static boolean enableDestroyAMapContinuousClient() {
        return sEnableDestroyAMapContinuousClient;
    }

    public static boolean enableDestroyAMapSingleClient() {
        return sEnableDestroyAMapSingleClient;
    }

    public static boolean enableDimLocationCheck() {
        return sEnableDimLocationCheck;
    }

    public static boolean enableGetNeighboringCell() {
        return sEnableGetNeighboringCell;
    }

    public static boolean enableInfoRequestOpt() {
        return sEnableInfoRequestOpt;
    }

    public static boolean enableInvokerApiInit() {
        if (sInvokerApiInitStatus == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean enableLightLocation() {
        return sEnableLightLocation;
    }

    public static boolean enableLightLocationNewPolicy() {
        return sEnableLightLocationNewPolicy;
    }

    public static boolean enableMonitor() {
        return sEnableMonitor;
    }

    public static boolean enablePreLocationCallback() {
        return sEnablePreLocationCallback;
    }

    public static boolean enableRescanWifi() {
        return sEnableRescanWifi;
    }

    public static boolean enableScanBle() {
        return sScanBle;
    }

    public static boolean enableScanGnss() {
        return sEnableScanGnss;
    }

    public static boolean enableScanWifi() {
        return sEnableScanWifi;
    }

    public static boolean enableSelfStartService() {
        return sEnableSelfStartService;
    }

    public static boolean enableStationaryScenePolicy() {
        return sEnableStationaryScenePolicy;
    }

    public static boolean enableTailLocateOptimize() {
        return sEnableTailLocateOptimize;
    }

    public static boolean enableTraceroute() {
        return mEnableTraceroute;
    }

    public static boolean enableUploadLastLocationInfo() {
        return sEnableUploadLastLocationInfo;
    }

    public static boolean enableUploadLastLogId() {
        return sEnableUploadLastLogId;
    }

    public static boolean enableUseCoarseLocation() {
        return sEnableUseCoarseLocation;
    }

    public static boolean firstRequestLocation() {
        return sFirstRequestLocation;
    }

    public static BackgroundProvider getAppBackgroundProvider() {
        return sProvider;
    }

    public static long getAppBootTime() {
        return sAppBootTime;
    }

    public static String getAppId() {
        return sAppId;
    }

    public static String getAppVersion() {
        return sAppVersion;
    }

    public static int getBaseStationInfoType() {
        return sBaseStationInfoType;
    }

    public static String getBaseUrl() {
        return sBaseUrl;
    }

    public static JSONObject getBeaconConfig() {
        return sBeaconConfig;
    }

    public static BLECacheEntity getBleCacheEntity() {
        return mBleCacheEntity;
    }

    public static long getBootLegitimateTime() {
        return sBootLegitimateTime;
    }

    public static Object getBpeaCert(String r8) {
        if (sBpeaCerts != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L8;
        return null;
    L8:
        return sBpeaCerts.get(r8);
    }

    public static int getBssNum() {
        return sBssNum;
    }

    public static String getByteLocationLibraParam() {
        return sByteLocationLibraParam;
    }

    public static String getByteLocationWhiteList() {
        return sByteLocationWhiteList;
    }

    public static String getChannel() {
        return sChannel;
    }

    public static boolean getColdBootCollectGps() {
        return sColdBootCollectGps;
    }

    public static int getColdBootCollectGpsStrategy() {
        return sColdBootCollectGpsStrategy;
    }

    public static long getCollectContinuousGPSDuration() {
        return sCollectContinuousGPSDuration;
    }

    public static long getCollectContinuousGPSInterval() {
        return sCollectContinuousGPSInterval;
    }

    public static String getCollectContinuousTokenBlacklist() {
        return sCollectContinuousGPSTokenBlacklist;
    }

    public static int getCollectGpsType() {
        return sCollectGpsType;
    }

    public static Map<String, String> getCommonParams() {
        return sCommonParams;
    }

    public static Context getContext() {
        return sContext;
    }

    public static IDYHostInfoProvider getDYHostInfoProvider() {
        return sDYHostInfoProvider;
    }

    public static long getDefaultGpsScanInterval() {
        if (sDefaultGpsScanInterval != 0) goto L15;
        if (isInit == false) goto L15;
        if (enableUseCoarseLocation() == false) goto L15;
        if (sContext == null) goto L15;
        if (PermissionManager.isApproximateLocation(sContext, false) == false) goto L15;
        Logger.i("BDLocationConfig getDefaultGpsScanInterval sLocalDefaultGpsScanInterval:" + sLocalDefaultGpsScanInterval);
        return sLocalDefaultGpsScanInterval;
    L15:
        return sDefaultGpsScanInterval;
    }

    public static String getDeviceId() {
        return sDeviceId;
    }

    public static String getDeviceInfoExtra() {
        ILocationInfoExtra r8 = sLocationInfoExtra;
        if (r8 != null) goto L5;
        return null;
    L5:
        JSONObject r10 = r8.getDeviceInfoExtra();
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.toString();
    }

    public static String getDisableCollectAMapLocationSource() {
        return sDisableCollectAMapLocationSource;
    }

    public static String getDisableTailLocateOptimizeSource() {
        return sDisableTailLocateOptimizeSource;
    }

    public static List<String> getDisableUuidList() {
        return sDisableUuidList;
    }

    public static String getEnableLocationOptBpeaList() {
        return sEnableLocationOptBpeaList;
    }

    public static Pair getEnv() {
        return sEnv;
    }

    public static IEventManager getEventManager() {
        return sEventManager;
    }

    public static long getFirstLocationTimeoutMs() {
        return sFirstLocationTimeoutMs;
    }

    public static long getFreshBaseStationTimeout() {
        return sFreshBaseStationTimeout;
    }

    public static long getGpsScanInterval() {
        return sGpsScanInterval;
    }

    public static int getHARStatusRange() {
        return sHARStatusRange;
    }

    public static int getHotBootCacheTime() {
        return sHotBootCacheTime;
    }

    public static String getHotBootLocToken() {
        return sHotBootLocToken;
    }

    public static long getInOutDoorStatusCacheTime() {
        return sInOutDoorStatusCacheTime;
    }

    public static long getInfoRequestKeyParamsMaxCacheTime() {
        return sInfoRequestKeyParamsMaxCacheTime;
    }

    public static long getInitStartTime() {
        return sInitStartTime;
    }

    public static int getInvokerApiInitStatus() {
        return sInvokerApiInitStatus;
    }

    public static int getLightInfoInterval() {
        return sLightInfoInterval;
    }

    public static Locale getLocale() {
        return sLocale;
    }

    public static int getLocateType() {
        return sLocateType;
    }

    public static String getLocationCacheTokenWhiteList() {
        return sLocationCacheTokenWhiteList;
    }

    public static long getLocationExpiredInterval() {
        return sLocationExpiredInterval;
    }

    public static int getLocationMode() {
        return sLocationMode;
    }

    public static LogIdCacheEntity getLogIdCacheEntity() {
        return mLogIdCacheEntity;
    }

    public static int getMaxLightCount() {
        return sMaxLightCount;
    }

    public static long getMaxLightDuration() {
        return sMaxLightDuration;
    }

    public static long getMaxLocationTimeMs() {
        return sMaxLocationTimeMs;
    }

    public static String getMockWifiName() {
        if (sMockWifiName != null) goto L6;
        sMockWifiName = LocationCache.getInstance().getMockWifiName();
    L6:
        return sMockWifiName;
    }

    public static ICustomNetworkApi getNetworkApi() {
        return sNetworkApi;
    }

    public static String getNetworkSignatureMode() {
        return sNetworkSignatureMode;
    }

    public static long getNetworkStatusChangeUploadInterval() {
        return sNetworkStatusChangeUploadInterval;
    }

    public static long getOverseasGetLocationFailedUseCacheValidity() {
        return sOverseasGetLocationFailedUseCacheValidity;
    }

    public static String getPackageName() {
        return sPackageName;
    }

    public static IPermissionChecker getPermissionChecker() {
        return sPermissionChecker;
    }

    public static String getRedGeoNameIds() {
        return sRedGeoNameIds;
    }

    public static BDRestrictedMode getRestricted() {
        BDRestrictedMode r8 = sRestrictedMode;
        if (r8 != null) goto L6;
        return null;
    L6:
        return r8;
    }

    public static int getRestrictedMode() {
        BDRestrictedMode r8 = sRestrictedMode;
        if (r8 != null) goto L7;
        return 0;
    L7:
        return r8.getRestrictedMode();
    }

    public static long getScanBleInterval() {
        return sScanBleInterval;
    }

    public static String getSdkVersion() {
        return sSdkVersion;
    }

    public static long getSearchLocationCacheTime() {
        return sSearchLocationCacheTime;
    }

    public static String getSessionId() {
        return sSessionId;
    }

    public static JSONObject getShakeConfig() {
        return mShakeConfig;
    }

    public static String getSlardarAid() {
        return sSlardarAid;
    }

    public static int getStationarySceneMaxDistance() {
        return sStationarySceneMaxDistance;
    }

    public static int getStationarySceneMaxGpsAccuracy() {
        return sStationarySceneMaxGpsAccuracy;
    }

    public static long getStationarySceneMaxInterval() {
        return sStationarySceneMaxInterval;
    }

    public static JSONObject getSubmitExtra() {
        ILocationInfoExtra r8 = sLocationInfoExtra;
        if (r8 != null) goto L7;
        return null;
    L7:
        return r8.getSubmitExtra();
    }

    public static List<LocationSubmitNotification> getSubmitNotification() {
        return sSubmitNotifications;
    }

    public static float getTailAccuracyThreshold() {
        return sTailAccuracyThreshold;
    }

    public static long getTailWifiTimeThreshold() {
        return sTailWifiTimeThreshold;
    }

    public static String getUpdateVersionCode() {
        return sUpdateVersionCode;
    }

    public static int getUploadBleNum() {
        return sUploadBleNum;
    }

    public static long getUploadInterval() {
        return sUploadInterval;
    }

    public static long getUploadNetSignalInterval() {
        return sUploadNetSignalInterval;
    }

    public static int getWifiNum() {
        return sWifiNum;
    }

    public static long getWifiScanInterval() {
        return sWifiScanInterval;
    }

    public static String getWorldView() {
        return sWorldView;
    }

    public static boolean init(Context r8) {
        if (legacyCheckInit() == false) goto L5;
        return true;
    L5:
        sInitStartTime = SystemClock.elapsedRealtime();
        sContext = r8;
        LocationSettingUtil.setLocationConfig();
        Object r10 = getBpeaCert(LocationInfoConst.INIT_CERT);
        LocationUtil.checkBpeaCertNull("locationInit", r10);
        if (r10 != null) goto L19;
    L17:
        long r11 = getDefaultGpsScanInterval();
        setGpsScanInterval(r11);
        Logger.i("init defaultGpsScanInterval:" + r11);
        LocationUtil.checkLocationMockEnable();
        isInit = true;
        Logger.i("config init finish");
        return true;
    L19:
        BPEACertCheckResult r12 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r10, "init");     // Catch: BDLocationException -> L14
        if (r12 == null) goto L17;
        if (r12.getParams() == null) goto L17;
        setConfigParam(r12.getParams());     // Catch: BDLocationException -> L14
    L14:
        e = move-exception;
        Logger.i("location init bpea check error");
        throw e;
    }

    public static boolean initIfNeed() {
        if (sContext != null) goto L5;
    L9:
        Logger.i(BDLocationReflectUtils.TAG, "initIfNeed: invoked, not initialized yet, start weakEnsureAwemeLocationInit.");
        BDLocationReflectUtils.weakEnsureAwemeLocationInit();
        if (sContext != null) goto L12;
    L14:
        Logger.i(BDLocationReflectUtils.TAG, "initIfNeed: invoked, after weakEnsureAwemeLocationInit, not inited, return false.");
        return false;
    L12:
        if (isInit == false) goto L14;
        String r8 = "initIfNeed: invoked, after weakEnsureAwemeLocationInit, already inited, return true.";
    L7:
        Logger.i(BDLocationReflectUtils.TAG, r8);
        return true;
    L5:
        if (isInit == false) goto L9;
        r8 = "initIfNeed: invoked, already inited, return true.";
        goto L7
    }

    public static boolean isAMapGPSCollectAlwaysUseNewAMapClient() {
        return sIsAMapGPSCollectAlwaysUseNewAMapClient;
    }

    public static boolean isAllowFetchConfigAtStart() {
        return sAllowFetchConfigAtStart;
    }

    public static boolean isAllowLocateFallback() {
        return sAllowLocateFallback;
    }

    public static boolean isAsyncScanWifi() {
        return sAsyncScanWifi;
    }

    public static boolean isCheckLocationBpea() {
        return sCheckLocationBpea;
    }

    public static boolean isChineseChannel() {
        return sIsChineseChannel;
    }

    public static boolean isColdBootABTest() {
        return sColdBootABTest;
    }

    public static boolean isCollectContinuousGpsDisableGnssUpload() {
        return sCollectContinuousGpsDisableGnssUpload;
    }

    public static boolean isCollectContinuousGpsOnlyLast() {
        return sCollectContinuousGpsOnlyLast;
    }

    public static boolean isCollectLightInfo() {
        return sCollectLightInfo;
    }

    public static boolean isContinueLocateUploadCell() {
        return sEnableContinueLocateUploadCell;
    }

    public static boolean isContinueLocateUploadWifi() {
        return sEnableContinueLocateUploadWifi;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static boolean isEnableGpsScan() {
        return sEnableGpsScan;
    }

    public static boolean isEnableHARCollect() {
        return sEnableHARCollect;
    }

    public static boolean isEnableLocationCacheTokenWhiteList() {
        return sEnableLocationCacheTokenWhiteList;
    }

    public static boolean isEnableLocationOpt(String r8) {
        String r10 = sEnableLocationOptBpeaList;
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        if (r10.contains(r8) == false) goto L9;
        return true;
    }

    public static boolean isEnableLocationOptEncrypt() {
        return sEnableLocationOptEncrypt;
    }

    public static boolean isFirstLocation() {
        return sIsFirstLocation;
    }

    public static boolean isInStationarySceneTokenWhiteList(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(sStationarySceneTokenWhiteList) == false) goto L8;
        return false;
    L8:
        return sStationarySceneTokenWhiteList.contains(r8);
    }

    public static boolean isInStationarySceneWifiWhiteList(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(sStationarySceneWifiWhiteList) == true) goto L19;
        if (sStationarySceneWifiWhiteList.contains(",") == false) goto L18;
        String[] r10 = sStationarySceneWifiWhiteList.split(",");
        int r11 = r10.length;
        int r12 = 0;
    L10:
        if (r12 >= r11) goto L16;
        if (r8.contains(r10[r12]) == true) goto L13;
        r12 = r12 + 1;
        goto L10
    L13:
        return true;
    L16:
        return false;
    L18:
        return r8.contains(sStationarySceneWifiWhiteList);
    }

    public static boolean isIndependentThreadGetScanResults() {
        return sIsIndepentThreadGetScanResults;
    }

    public static boolean isMockEnable() {
        return sIsMockEnable;
    }

    public static boolean isMockUpload() {
        return sIsMockUpload;
    }

    public static boolean isNoLocReqCgiEnable() {
        return sIsNoLocReqCgiEnable;
    }

    public static boolean isOnline() {
        return sOnline;
    }

    public static boolean isOpenStationaryScene() {
        monitor-enter(OPEN_STATIONARY_SCENE_LOCK);
        boolean r8 = sOpenStationaryScene;     // Catch: Throwable -> L7
        monitor-exit(OPEN_STATIONARY_SCENE_LOCK);     // Catch: Throwable -> L7
        return r8;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isOpenWifiListMonitor() {
        return sOpenWifiListMonitor;
    }

    public static boolean isPollingUpload() {
        return sIsPollingUpload;
    }

    public static boolean isPrivacyConfirmed() {
        return isPrivacyConfirmed;
    }

    public static boolean isRegionInChineseChannel() {
        return sRegionInChineseChannel;
    }

    public static boolean isReportAtStart() {
        return sReportAtStart;
    }

    public static boolean isReportLocationAtStart() {
        return sReportLocationAtStart;
    }

    public static boolean isRestrictedModeOn() {
        BDRestrictedMode r8 = sRestrictedMode;
        if (r8 != null) goto L5;
        return false;
    L5:
        int r10 = r8.getRestrictedMode();
        Logger.i("BDLocationConfig restrictedMode:" + r10);
        if (r10 == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean isRevertToSystemLocation() {
        return sRevertToSystemLocation;
    }

    public static boolean isStrictRestrictedMode() {
        return sIsStrictRestrictedMode;
    }

    public static boolean isSysNetworkLocEnable() {
        return sIsSysNetworkLocEnable;
    }

    public static boolean isUpload() {
        return sIsUpload;
    }

    public static boolean isUploadBaseSite() {
        return sIsUploadBaseSite;
    }

    public static boolean isUploadBleImmediately() {
        return sUploadBleImmediately;
    }

    public static boolean isUploadFreshBaseStation() {
        return sIsUploadFreshBaseStation;
    }

    public static boolean isUploadGPS() {
        return sIsUploadGPS;
    }

    public static boolean isUploadLocation() {
        return sIsUploadLocation;
    }

    public static boolean isUploadMccAndSystemRegionInfo() {
        return sUploadMccAndSystemRegionInfo;
    }

    public static boolean isUploadWIFI() {
        return sIsUploadWIFI;
    }

    public static boolean isUseCacheCondition() {
        return sUseCacheCondition;
    }

    public static boolean isUseNewCacheStrategy() {
        return sUseNewCacheStrategy;
    }

    public static boolean isUseQuickGPS() {
        return sIsUseQuickGPS;
    }

    private static /* synthetic */ void lambda$notificationLocationChange$0(int r8, BDLocation r10) {
        String r11 = RESTRICTED_LOCK;
        monitor-enter(r11);
    L5:
        if (r8 >= 5) goto L13;
        List<LocationNotification> r12 = sNotifications.get(r8);     // Catch: Throwable -> L15
        if (r12 == null) goto L12;
        Iterator<LocationNotification> r13 = r12.iterator();     // Catch: Throwable -> L15
    L10:
        if (r13.hasNext() == false) goto L12;
        r13.next().onLocationChanged(r10);     // Catch: Throwable -> L15
    L12:
        r8 = r8 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r11);     // Catch: Throwable -> L15
    }

    public static boolean legacyCheckInit() {
        if (sContext != null) goto L5;
    L8:
        Logger.i(BDLocationReflectUtils.TAG, "legacyCheckInit: invoked, already inited: false.");
        return false;
    L5:
        if (isInit == false) goto L8;
        Logger.i(BDLocationReflectUtils.TAG, "legacyCheckInit: invoked, already inited: true.");
        return true;
    }

    public static long maxWaitGPSTimeMillis() {
        return sMaxWaitGpsTimeMillis;
    }

    public static List<String> monitorBusinessStartLocationClassMemberList() {
        return sMonitorBusinessStartLocationClassMemberList;
    }

    public static List<String> monitorBusinessStopLocationClassMemberList() {
        return sMonitorBusinessStopLocationClassMemberList;
    }

    public static int monitorStrategy() {
        return sMonitorStrategy;
    }

    public static List<String> monitorStrategyClassMemberList() {
        return sMonitorStrategyClassMemberList;
    }

    public static long monitorStrategyInterval() {
        return sMonitorStrategyInterval;
    }

    public static boolean needDownGradeLocationInOverseas() {
        return sNeedDownGradeLocationInOverseas;
    }

    public static boolean needRevertWifiOrStationInfoUpload(LocationOption r8) {
        if (r8 != null) goto L4;
    L8:
        StringBuilder r10 = new StringBuilder("BDLocationConfig.needRevertWifiOrStationInfoUpload: false, cert: ");
        if (r8 == null) goto L11;
        String r11 = r8.getUploadSource();
    L12:
        r10.append(r11);
        Logger.i(r10.toString());
        return false;
    L11:
        r11 = "null";
        goto L12
    L4:
        if (r8.isOnceLocation() == false) goto L8;
        boolean r12 = isRevertToSystemLocation();
        StringBuilder r13 = a.l("BDLocationConfig.needRevertWifiOrStationInfoUpload: ", r12, ", cert: ");
        r13.append(r8.getUploadSource());
        Logger.i(r13.toString());
        return r12;
    }

    public static boolean needUploadLastContinuousLocation() {
        return sNeedUploadLastContinuousLocation;
    }

    public static void notificationLocationChange(int r8, BDLocation r10) {
        BDLocation r11 = new BDLocation(r10);
        r11.setLongitude(0.0d);
        r11.setLatitude(0.0d);
        r11.setAltitude(0.0d);
        if (r11.getLocationResult() == null) goto L5;
        r11.getLocationResult().gps = null;
    L5:
        new Handler(Looper.getMainLooper()).post(new g(r8, r11));
    }

    public static void removeNotification(LocationNotification r8, int r10) {
        String r11 = RESTRICTED_LOCK;
        monitor-enter(r11);
        switchNotification(r10).remove(r8);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void removeSubmitNotification(LocationSubmitNotification r8) {
        List<LocationSubmitNotification> r10 = sSubmitNotifications;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.size() < 1) goto L11;
        if (r8 == null) goto L12;
        sSubmitNotifications.remove(r8);
        return;
    L12:
        return;
    }

    public static int rescanWifiCount() {
        return sRescanWifiCount;
    }

    public static void setAMapGPSCollectAlwaysUseNewAMapClient(boolean r8) {
        sIsAMapGPSCollectAlwaysUseNewAMapClient = r8;
    }

    public static void setAllowFetchConfigAtStart(boolean r8) {
        sAllowFetchConfigAtStart = r8;
    }

    public static void setAllowLocateFallback(boolean r8) {
        sAllowLocateFallback = r8;
    }

    public static void setAppBackgroundProvider(BackgroundProvider r8) {
        StringBuilder r10 = new StringBuilder("setAppBackgroundProvider provider:");
        if (r8 != null) goto L5;
        boolean r11 = true;
    L6:
        r10.append(r11);
        Logger.i(r10.toString());
        BackgroundProvider r12 = sProvider;
        List<BackgroundProvider.Callback> r13 = null;
        if (r12 == null) goto L9;
        List<BackgroundProvider.Callback> r14 = r12.getCallback();
        sProvider.setCallback(null);
        r13 = r14;
    L9:
        sProvider = r8;
        if (r13 == null) goto L14;
        if (r8 == null) goto L15;
        r8.setCallback(r13);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public static void setAppBootTime(long r8) {
        sAppBootTime = r8;
    }

    public static void setAppId(String r8) {
        sAppId = r8;
    }

    public static void setAppVersion(String r8) {
        sAppVersion = r8;
    }

    public static void setAsyncScanWifi(boolean r8) {
        sAsyncScanWifi = r8;
    }

    public static void setBaseStationInfoType(int r8) {
        sBaseStationInfoType = r8;
    }

    public static void setBaseUrl(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L14:
        sBaseUrl = r8;
        return;
    L5:
        if (r8.contains(LocationInfoConst.HTTPS) == true) goto L14;
        if (isDebug() == false) goto L9;
    L13:
        Logger.e("当前定位接口非https加密，使用明文信息违反合规要求，请修改为https");
        goto L14
    L9:
        if (isOnline() == false) goto L13;
        throw new IllegalArgumentException("当前定位接口非https加密，使用明文信息违反合规要求，请修改为https");
    }

    public static void setBeaconConfig(JSONObject r8) {
        sBeaconConfig = r8;
    }

    public static void setBleCacheEntity(BLECacheEntity r8) {
        mBleCacheEntity = r8;
    }

    public static void setBootLegitimateTime(long r8) {
        sBootLegitimateTime = r8;
    }

    public static void setBpeaCerts(Map<String, Object> r8) {
        sBpeaCerts = r8;
    }

    public static void setBssNum(int r8) {
        sBssNum = r8;
    }

    public static void setByteLocationLibraParam(String r8) {
        sByteLocationLibraParam = r8;
    }

    public static void setByteLocationWhiteList(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        sByteLocationWhiteList = r8;
    }

    public static void setChannel(String r8) {
        sChannel = r8;
    }

    public static void setCheckConnectWifiRssi(int r8) {
        sConnectWifiRssi = r8;
    }

    public static void setCheckLocationBpea(boolean r8) {
        sCheckLocationBpea = r8;
    }

    public static void setCheckRefreshWifiTimeInterval(long r8) {
        sCheckRefreshWifiTimeInterval = r8;
    }

    public static void setChineseChannel(boolean r8) {
        sIsChineseChannel = r8;
    }

    public static void setColdBootABTest(boolean r8) {
        sColdBootABTest = r8;
    }

    public static void setColdBootCollectGps(boolean r8) {
        sColdBootCollectGps = r8;
    }

    public static void setColdBootCollectGpsStrategy(int r8) {
        sColdBootCollectGpsStrategy = r8;
    }

    public static void setCollectContinuousGPSDuration(long r8) {
        sCollectContinuousGPSDuration = r8;
    }

    public static void setCollectContinuousGPSInterval(long r8) {
        sCollectContinuousGPSInterval = r8;
    }

    public static void setCollectContinuousGpsDisableGnssUpload(boolean r8) {
        sCollectContinuousGpsDisableGnssUpload = r8;
    }

    public static void setCollectContinuousGpsOnlyLast(boolean r8) {
        sCollectContinuousGpsOnlyLast = r8;
    }

    public static void setCollectContinuousTokenBlacklist(String r8) {
        sCollectContinuousGPSTokenBlacklist = r8;
    }

    public static void setCollectGpsType(int r8) {
        sCollectGpsType = r8;
    }

    public static void setCollectLightInfo(boolean r8) {
        sCollectLightInfo = r8;
    }

    public static void setCommonParams(Map<String, String> r8) {
        sCommonParams = r8;
    }

    public static void setConfigParam(JSONObject r8) {
        Logger.d("BDLocation", "init config params are " + r8.toString());
        setIsUploadGPS(r8.optBoolean("report_gps", true));
        int r10 = r8.optInt("report_bss_max", 10);
        if (r10 <= 0) goto L5;
        setUploadBaseSite(true);
        setBssNum(r10);
    L6:
        setReportAtStart(r8.optBoolean("report_at_start", false));
        setReportLocationAtStart(r8.optBoolean("report_location_at_start", false));
        setUpload(r8.optBoolean("is_upload", true));
        setUploadLocation(r8.optBoolean("is_upload_location", true));
        setChineseChannel(r8.optBoolean("chinese_channel", true));
        int r11 = r8.optInt("location_update_interval", 300);
        int r12 = r8.optInt("report_interval_seconds", 300);
        if (r12 <= 0) goto L9;
        long r13 = r12 * 1000;
    L10:
        setUploadInterval(r13);
        setDebug(r8.optBoolean("debug_able", false));
        setAllowLocateFallback(r8.optBoolean("allow_locate_fallback", true));
        JSONArray r14 = r8.optJSONArray("error_code_list_for_fallback");
        ArrayList r15 = new ArrayList();
        if (r14 == null) goto L16;
        int r16 = 0;
    L14:
        if (r16 >= r14.length()) goto L16;
        r15.add(Integer.valueOf(r14.optInt(r16, 0)));
        r16 = r16 + 1;
    L16:
        setAllowFetchConfigAtStart(r8.optBoolean("allow_fetch_config_at_start", true));
        setPollingUpload(r8.optBoolean("polling_upload", isPollingUpload()));
        setMaxLocationTimeMs(r8.optLong("max_location_time_ms", 300000));
        setLocateType(r8.optInt(LocationMonitorConst.LOCATE_TYPE, 3));
        return;
    L9:
        r13 = r11 * 1000;
        goto L10
    L5:
        setUploadBaseSite(false);
        goto L6
    }

    public static void setContext(Context r8) {
        sContext = r8;
    }

    public static void setDYHostInfoProvider(IDYHostInfoProvider r8) {
        sDYHostInfoProvider = r8;
    }

    public static void setDebug(boolean r8) {
        isDebug = r8;
    }

    public static void setDefaultGpsScanInterval(long r8) {
        sDefaultGpsScanInterval = r8;
    }

    public static void setDeviceId(String r8) {
        sDeviceId = r8;
    }

    public static void setDisableCollectAMapLocationSource(String r8) {
        sDisableCollectAMapLocationSource = r8;
    }

    public static void setDisableTailLocateOptimizeSource(String r8) {
        sDisableTailLocateOptimizeSource = r8;
    }

    public static void setDisableUuidList(List<String> r8) {
        sDisableUuidList = r8;
    }

    public static void setEnableBackgroundLocation(boolean r8) {
        sEnableBackgroundLocation = r8;
    }

    public static void setEnableBackgroundUploadLocationn(boolean r8) {
        sEenableBackgroundUploadLocation = r8;
    }

    public static void setEnableBlePassiveName(boolean r8) {
        sEnableBlePassiveName = r8;
    }

    public static void setEnableBleTruncateOnTimeout(boolean r8) {
        sEnableBleTruncateOnTimeout = r8;
    }

    public static void setEnableBpea(boolean r8) {
        sEnableBpea = r8;
        if (getContext() == null) goto L6;
        LocationCache.getInstance().setBooleanValue(ENABLE_BPEA_CACHE_KEY, r8);
        return;
    }

    public static void setEnableByteContinuousLocation(boolean r8) {
        sEnableByteContinuousLocation = r8;
    }

    public static void setEnableCheckConnectWifi(boolean r8) {
        sEnableCheckConnectWifi = r8;
    }

    public static void setEnableCheckLastLogId(boolean r8) {
        sEnableCheckLastLogId = r8;
    }

    public static void setEnableCheckRefreshWifiTime(boolean r8) {
        sEnableCheckRefreshWifiTime = r8;
    }

    public static void setEnableCheckUploadCompliance(boolean r8) {
        sEnableCheckUploadCompliance = r8;
    }

    public static void setEnableCollectAMapLocationInBatterySavingMode(boolean r8) {
        sEnableCollectAMapLocationInBatterySavingMode = r8;
    }

    public static void setEnableCollectBleInBatterySavingMode(boolean r8) {
        sEnableCollectBleInBatterySavingMode = r8;
    }

    public static void setEnableCollectContinuousGPSLocation(boolean r8) {
        sEnableCollectContinuousGPSLocation = r8;
    }

    public static void setEnableCollectContinuousGpsForTest(boolean r8) {
        sEnableCollectContinuousGpsForTest = r8;
    }

    public static void setEnableCollectGPSLocationInBatterySavingMode(boolean r8) {
        sEnableCollectGPSLocationInBatterySavingMode = r8;
    }

    public static void setEnableCollectNetworkLocationInBatterySavingMode(boolean r8) {
        sEnableCollectNetworkLocationInBatterySavingMode = r8;
    }

    public static void setEnableContinueLocateUploadCell(boolean r8) {
        sEnableContinueLocateUploadCell = r8;
    }

    public static void setEnableContinueLocateUploadWifi(boolean r8) {
        sEnableContinueLocateUploadWifi = r8;
    }

    public static void setEnableDestroyAMapContinuousClient(boolean r8) {
        sEnableDestroyAMapContinuousClient = r8;
    }

    public static void setEnableDestroyAMapSingleClient(boolean r8) {
        sEnableDestroyAMapSingleClient = r8;
    }

    public static void setEnableDimLocationCheck(boolean r8) {
        sEnableDimLocationCheck = r8;
    }

    public static void setEnableGetNeighboringCell(boolean r8) {
        sEnableGetNeighboringCell = r8;
    }

    public static void setEnableGpsScan(boolean r8) {
        sEnableGpsScan = r8;
    }

    public static void setEnableHARCollect(boolean r8) {
        sEnableHARCollect = r8;
    }

    public static void setEnableInfoRequestOpt(boolean r8) {
        sEnableInfoRequestOpt = r8;
    }

    public static void setEnableLightLocation(boolean r8) {
        sEnableLightLocation = r8;
    }

    public static void setEnableLightLocationNewPolicy(boolean r8) {
        sEnableLightLocationNewPolicy = r8;
    }

    public static void setEnableLocationCacheTokenWhiteList(boolean r8) {
        sEnableLocationCacheTokenWhiteList = r8;
    }

    public static void setEnableLocationOptBpeaList(String r8) {
        if (r8 != null) goto L4;
        r8 = "";
    L4:
        Logger.i("setEnableLocationOptBpeaList: \"" + r8 + '\"');
        sEnableLocationOptBpeaList = r8;
    }

    public static void setEnableLocationOptEncrypt(boolean r8) {
        Logger.i("setEnableLocationOptEncrypt: " + r8);
        sEnableLocationOptEncrypt = r8;
    }

    public static void setEnableMonitor(boolean r8) {
        sEnableMonitor = r8;
    }

    public static void setEnableRescanWifi(boolean r8) {
        sEnableRescanWifi = r8;
    }

    public static void setEnableScanBle(boolean r8) {
        sScanBle = r8;
    }

    public static void setEnableScanGnss(boolean r8) {
        sEnableScanGnss = r8;
    }

    public static void setEnableScanWifi(boolean r8) {
        sEnableScanWifi = r8;
    }

    public static void setEnableSelfStartService(boolean r8) {
        sEnableSelfStartService = r8;
    }

    public static void setEnableStationaryScenePolicy(boolean r8) {
        sEnableStationaryScenePolicy = r8;
    }

    public static void setEnableTailLocateOptimize(boolean r8) {
        sEnableTailLocateOptimize = r8;
    }

    public static void setEnableTraceroute(boolean r8) {
        mEnableTraceroute = r8;
    }

    public static void setEnableUploadLastLocationInfo(boolean r8) {
        sEnableUploadLastLocationInfo = r8;
    }

    public static void setEnableUploadLastLogId(boolean r8) {
        sEnableUploadLastLogId = r8;
    }

    public static void setEnableUseCoarseLocation(boolean r8) {
        sEnableUseCoarseLocation = r8;
    }

    public static void setEnv(Pair<String, String> r8) {
        sEnv = r8;
    }

    public static void setEventManager(IEventManager r8) {
        sEventManager = r8;
    }

    public static void setFirstLocation(boolean r8) {
        sIsFirstLocation = r8;
    }

    public static void setFirstLocationTimeoutMs(long r8) {
        sFirstLocationTimeoutMs = r8;
    }

    public static void setFirstRequestLocation(boolean r8) {
        sFirstRequestLocation = r8;
    }

    public static void setFreshBaseStationTimeout(long r8) {
        sFreshBaseStationTimeout = r8;
    }

    public static void setGpsScanInterval(long r8) {
        sGpsScanInterval = r8;
    }

    public static void setHARStatusRange(int r8) {
        sHARStatusRange = r8;
    }

    public static void setHotBootCacheTime(int r8) {
        sHotBootCacheTime = r8;
    }

    public static void setHotBootLocToken(String r8) {
        sHotBootLocToken = r8;
    }

    public static void setILocationInfoExtra(ILocationInfoExtra r8) {
        sLocationInfoExtra = r8;
    }

    public static void setInOutDoorStatusCacheTime(long r8) {
        sInOutDoorStatusCacheTime = r8;
    }

    public static void setIndependentThreadGetScanResults(boolean r8) {
        Logger.i("setIndependentThreadGetScanResults: " + r8);
        sIsIndepentThreadGetScanResults = r8;
    }

    public static void setInfoRequestKeyParamsMaxCacheTime(long r8) {
        sInfoRequestKeyParamsMaxCacheTime = r8;
    }

    public static void setInvokerApiInitStatus(int r8) {
        sInvokerApiInitStatus = r8;
    }

    public static void setIsUploadGPS(boolean r8) {
        sIsUploadGPS = r8;
    }

    public static void setIsUseQuickGPS(boolean r8) {
        sIsUseQuickGPS = r8;
    }

    public static void setLightInfoInterval(int r8) {
        sLightInfoInterval = r8;
    }

    public static void setLocale(Locale r8) {
        sLocale = r8;
    }

    public static void setLocateType(int r8) {
        sLocateType = r8;
    }

    public static void setLocationCacheTokenWhiteList(String r8) {
        sLocationCacheTokenWhiteList = r8;
    }

    public static void setLocationExpiredInterval(long r8) {
        sLocationExpiredInterval = r8;
    }

    public static void setLocationMode(int r8) {
        sLocationMode = r8;
    }

    public static void setLogIdCacheEntity(LogIdCacheEntity r8) {
        mLogIdCacheEntity = r8;
    }

    public static void setMaxLightCount(int r8) {
        sMaxLightCount = r8;
    }

    public static void setMaxLightDuration(long r8) {
        sMaxLightDuration = r8;
    }

    public static void setMaxLocationTimeMs(long r8) {
        sMaxLocationTimeMs = r8;
    }

    public static void setMaxWaitGpsTimeMillis(long r8) {
        sMaxWaitGpsTimeMillis = r8;
    }

    public static void setMockEnable(boolean r8) {
        sIsMockEnable = r8;
    }

    public static void setMockUpload(boolean r8) {
        sIsMockUpload = r8;
    }

    public static void setMockWifiName(String r8) {
        sMockWifiName = r8;
        LocationCache.getInstance().setMockWifiName(r8);
    }

    public static void setMonitorBusinessStartLocationClassMemberList(List<String> r8) {
        sMonitorBusinessStartLocationClassMemberList = r8;
    }

    public static void setMonitorBusinessStopLocationClassMemberList(List<String> r8) {
        sMonitorBusinessStopLocationClassMemberList = r8;
    }

    public static void setMonitorStrategy(int r8) {
        sMonitorStrategy = r8;
    }

    public static void setMonitorStrategyClassMemberList(List<String> r8) {
        sMonitorStrategyClassMemberList = r8;
    }

    public static void setMonitorStrategyInterval(long r8) {
        sMonitorStrategyInterval = r8;
    }

    public static void setNeedDownGradeLocationInOverseas(boolean r8) {
        sNeedDownGradeLocationInOverseas = r8;
    }

    public static void setNeedUploadLastContinuousLocation(boolean r8) {
        sNeedUploadLastContinuousLocation = r8;
    }

    public static void setNetworkApi(ICustomNetworkApi r8) {
        sNetworkApi = r8;
    }

    public static void setNetworkSignatureMode(String r8) {
        sNetworkSignatureMode = r8;
    }

    public static void setNetworkStatusChangeUploadInterval(long r8) {
        sNetworkStatusChangeUploadInterval = sNetworkStatusChangeUploadInterval;
    }

    public static void setNoLocReqCgiEnable(boolean r8) {
        sIsNoLocReqCgiEnable = r8;
    }

    public static void setOnline(boolean r8) {
        sOnline = r8;
    }

    public static void setOpenStationaryScene(boolean r8) {
        monitor-enter(OPEN_STATIONARY_SCENE_LOCK);
        sOpenStationaryScene = r8;     // Catch: Throwable -> L7
        monitor-exit(OPEN_STATIONARY_SCENE_LOCK);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setOpenWifiListMonitor(boolean r8) {
        sOpenWifiListMonitor = r8;
    }

    public static void setOverseasGetLocationFailedUseCacheValidity(long r8) {
        sOverseasGetLocationFailedUseCacheValidity = r8;
    }

    public static void setPackageName(String r8) {
        sPackageName = r8;
    }

    public static void setPermissionChecker(IPermissionChecker r8) {
        sPermissionChecker = r8;
    }

    public static void setPollingUpload(boolean r8) {
        Logger.i("setPollingUpload", BdimCategoryConstants.SEPARATOR_COLON + r8);
        sIsPollingUpload = r8;
    }

    public static void setPreLocationCallback(boolean r8) {
        sEnablePreLocationCallback = r8;
    }

    public static void setPrivacyConfirmed(boolean r8) {
        isPrivacyConfirmed = r8;
    }

    public static void setRedGeoNameIds(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        sRedGeoNameIds = r8;
    }

    public static void setRegionInChineseChannel(boolean r8) {
        sRegionInChineseChannel = r8;
    }

    public static void setReportAtStart(boolean r8) {
        sReportAtStart = r8;
    }

    public static void setReportLocationAtStart(boolean r8) {
        sReportLocationAtStart = r8;
    }

    public static void setRequestLocation(boolean r8) {
        sShouldRequestLocation = r8;
    }

    public static void setRescanWifiCount(int r8) {
        sRescanWifiCount = r8;
    }

    public static void setRestrictedMode(BDRestrictedMode r8) {
        sRestrictedMode = r8;
    }

    public static void setRevertToSystemLocation(boolean r8) {
        sRevertToSystemLocation = r8;
    }

    public static void setScanBleInterval(long r8) {
        if (r8 <= 10000) goto L5;
        r8 = 10000;
    L5:
        sScanBleInterval = r8;
    }

    public static void setSdkVersion(String r8) {
        sSdkVersion = r8;
    }

    public static void setSearchLocationCacheTime(long r8) {
        sSearchLocationCacheTime = r8;
    }

    public static void setSessionId(String r8) {
        sSessionId = r8;
    }

    public static void setShakeConfig(JSONObject r8) {
        mShakeConfig = r8;
    }

    public static void setSlardarAid(String r8) {
        sSlardarAid = r8;
    }

    public static void setStationarySceneMaxDistance(int r8) {
        sStationarySceneMaxDistance = r8;
    }

    public static void setStationarySceneMaxGpsAccuracy(int r8) {
        sStationarySceneMaxGpsAccuracy = r8;
    }

    public static void setStationarySceneMaxInterval(long r8) {
        sStationarySceneMaxInterval = r8;
    }

    public static void setStationarySceneTokenWhiteList(String r8) {
        sStationarySceneTokenWhiteList = r8;
    }

    public static void setStationarySceneWifiWhiteList(String r8) {
        sStationarySceneWifiWhiteList = r8;
    }

    public static void setStrictRestrictedMode(boolean r8) {
        sIsStrictRestrictedMode = r8;
    }

    public static void setSysNetworkLocEnable(boolean r8) {
        sIsSysNetworkLocEnable = r8;
    }

    public static void setTailAccuracyThreshold(float r8) {
        sTailAccuracyThreshold = r8;
    }

    public static void setTailWifiTimeThreshold(long r8) {
        sTailWifiTimeThreshold = r8;
    }

    public static void setUpdateVersionCode(String r8) {
        sUpdateVersionCode = r8;
    }

    public static void setUpload(boolean r8) {
        sIsUpload = r8;
    }

    public static void setUploadBaseSite(boolean r8) {
        sIsUploadBaseSite = r8;
    }

    public static void setUploadBleImmediately(boolean r8) {
        sUploadBleImmediately = r8;
    }

    public static void setUploadBleNum(int r8) {
        sUploadBleNum = r8;
    }

    public static void setUploadFreshBaseStation(boolean r8) {
        sIsUploadFreshBaseStation = r8;
    }

    public static void setUploadInterval(long r8) {
        sUploadInterval = r8;
    }

    public static void setUploadLocation(boolean r8) {
        sIsUploadLocation = r8;
    }

    public static void setUploadMccAndSystemRegionInfo(boolean r8) {
        sUploadMccAndSystemRegionInfo = r8;
    }

    public static void setUploadNetSignalInterval(long r8) {
        sUploadNetSignalInterval = r8;
    }

    @Deprecated
    public static void setUploadWIFI(boolean r8) {
        if (isDebug() == false) goto L6;
        sIsUploadWIFI = r8;
        return;
    }

    public static void setUseCacheCondition(boolean r8) {
        sUseCacheCondition = r8;
    }

    public static void setUseGpsCheckRegion(boolean r8) {
        sUseGpsCheckRegion = r8;
    }

    public static void setUseNewCacheStrategy(boolean r8) {
        sUseNewCacheStrategy = r8;
    }

    public static void setUseNewReverseGeoLocationApi(boolean r8) {
        sUseNewReverseGeoLocationApi = r8;
    }

    public static void setWifiNum(int r8) {
        sWifiNum = r8;
    }

    public static void setWifiScanInterval(long r8) {
        sWifiScanInterval = r8;
    }

    public static void setWorldView(String r8) {
        sWorldView = r8;
    }

    public static boolean shouldRequestLocation() {
        return sShouldRequestLocation;
    }

    private static List<LocationNotification> switchNotification(int r8) {
        List<LocationNotification> r10 = sNotifications.get(r8);
        if (r10 != null) goto L6;
        ArrayList r11 = new ArrayList();
        sNotifications.put(r8, r11);
        return r11;
    L6:
        return r10;
    }

    public static boolean useGpsCheckRegion() {
        return sUseGpsCheckRegion;
    }

    public static boolean useNewReverseGeoLocationApi() {
        return sUseNewReverseGeoLocationApi;
    }

    public static void addNotification(LocationNotification r8, Object r10) {
        long r11 = System.currentTimeMillis();
        String r12 = RESTRICTED_LOCK;     // Catch: Exception -> L19
        monitor-enter(r12);     // Catch: Exception -> L19
        LocationUtil.checkBpeaCertNull("addNotification", r10);     // Catch: Throwable -> L16
        int r13 = 0;
        if (r10 == null) goto L12;
        BPEACertCheckResult r14 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r10, "addNotification");     // Catch: Throwable -> L16
        if (r14 == null) goto L12;
        if (r14.getParams() == null) goto L12;
        r13 = r14.getParams().optInt("range", 0);     // Catch: Throwable -> L16
    L12:
        switchNotification(r13).add(r8);     // Catch: Throwable -> L16
        monitor-exit(r12);     // Catch: Throwable -> L16
        Logger.i("addNotification interval:" + (System.currentTimeMillis() - r11));     // Catch: Exception -> L19
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Logger.d("addNotification change error:" + e.getMessage());
    }
}
