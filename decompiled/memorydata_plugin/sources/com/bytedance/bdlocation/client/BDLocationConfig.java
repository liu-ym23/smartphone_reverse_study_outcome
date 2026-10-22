package com.bytedance.bdlocation.client;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.apm6.util.constant.CommonConsts;
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
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.text.Typography;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONArray;
import org.json.JSONObject;

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

    public static void addNotification(LocationNotification r5, int r6) {
        LocationNotification r7 = (LocationNotification) ZeusTransformUtils.wrapperContextForParams(r5, LocationNotification.class, "com.obric.memorydata.plugin");
        long r0 = System.currentTimeMillis();
        String r2 = RESTRICTED_LOCK;
        monitor-enter(r2);
        LocationUtil.withoutBpeaCertCheck("addNotification");     // Catch: Throwable -> L6 Exception -> L8
        switchNotification(r6).add(r7);     // Catch: Throwable -> L6 Exception -> L8
        Logger.i("addNotification interval:" + (System.currentTimeMillis() - r0));     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        Logger.d("addNotification change withoutBpeaCertCheck error:" + e.getMessage());     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static void addNotification(LocationNotification r6, Object r7) {
        LocationNotification r8 = (LocationNotification) ZeusTransformUtils.wrapperContextForParams(r6, LocationNotification.class, "com.obric.memorydata.plugin");
        long r0 = System.currentTimeMillis();
        String r2 = RESTRICTED_LOCK;     // Catch: Exception -> L19
        monitor-enter(r2);     // Catch: Exception -> L19
        LocationUtil.checkBpeaCertNull("addNotification", r7);     // Catch: Throwable -> L16
        int r3 = 0;
        if (r7 == null) goto L12;
        BPEACertCheckResult r9 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r7, "addNotification");     // Catch: Throwable -> L16
        if (r9 == null) goto L12;
        if (r9.getParams() == null) goto L12;
        r3 = r9.getParams().optInt("range", 0);     // Catch: Throwable -> L16
    L12:
        switchNotification(r3).add(r8);     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        Logger.i("addNotification interval:" + (System.currentTimeMillis() - r0));     // Catch: Exception -> L19
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        Logger.d("addNotification change error:" + e.getMessage());
    }

    public static void addSubmitNotification(Object r2, LocationSubmitNotification r3) {
        LocationSubmitNotification r4 = (LocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r3, LocationSubmitNotification.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r2 == null) goto L15;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r2, "addSubmitNotification");     // Catch: BDLocationException -> L12
        if (sSubmitNotifications != null) goto L10;
        sSubmitNotifications = new CopyOnWriteArrayList();     // Catch: BDLocationException -> L12
    L10:
        sSubmitNotifications.add(r4);     // Catch: BDLocationException -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        if (sSubmitNotifications != null) goto L17;
        sSubmitNotifications = new CopyOnWriteArrayList();
    L17:
        sSubmitNotifications.add(r4);
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

    public static Object getBpeaCert(String r1) {
        if (sBpeaCerts != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return null;
    L8:
        return sBpeaCerts.get(r1);
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
        ILocationInfoExtra r0 = sLocationInfoExtra;
        if (r0 != null) goto L5;
        return null;
    L5:
        JSONObject r1 = r0.getDeviceInfoExtra();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.toString();
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
        BDRestrictedMode r0 = sRestrictedMode;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public static int getRestrictedMode() {
        BDRestrictedMode r0 = sRestrictedMode;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getRestrictedMode();
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
        ILocationInfoExtra r0 = sLocationInfoExtra;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSubmitExtra();
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

    public static boolean init(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (legacyCheckInit() == false) goto L5;
        return true;
    L5:
        sInitStartTime = SystemClock.elapsedRealtime();
        sContext = r5;
        LocationSettingUtil.setLocationConfig();
        Object r6 = getBpeaCert(LocationInfoConst.INIT_CERT);
        LocationUtil.checkBpeaCertNull("locationInit", r6);
        if (r6 != null) goto L19;
    L17:
        long r2 = getDefaultGpsScanInterval();
        setGpsScanInterval(r2);
        Logger.i("init defaultGpsScanInterval:" + r2);
        LocationUtil.checkLocationMockEnable();
        isInit = true;
        Logger.i("config init finish");
        return true;
    L19:
        BPEACertCheckResult r7 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r6, CommonConsts.APM_INNER_EVENT_COST_INIT);     // Catch: BDLocationException -> L14
        if (r7 == null) goto L17;
        if (r7.getParams() == null) goto L17;
        setConfigParam(r7.getParams());     // Catch: BDLocationException -> L14
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
        String r0 = "initIfNeed: invoked, after weakEnsureAwemeLocationInit, already inited, return true.";
    L7:
        Logger.i(BDLocationReflectUtils.TAG, r0);
        return true;
    L5:
        if (isInit == false) goto L9;
        r0 = "initIfNeed: invoked, already inited, return true.";
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

    public static boolean isEnableLocationOpt(String r2) {
        String r0 = sEnableLocationOptBpeaList;
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(r0) == true) goto L9;
        if (r0.contains(r2) == false) goto L9;
        return true;
    }

    public static boolean isEnableLocationOptEncrypt() {
        return sEnableLocationOptEncrypt;
    }

    public static boolean isFirstLocation() {
        return sIsFirstLocation;
    }

    public static boolean isInStationarySceneTokenWhiteList(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(sStationarySceneTokenWhiteList) == false) goto L8;
        return false;
    L8:
        return sStationarySceneTokenWhiteList.contains(r1);
    }

    public static boolean isInStationarySceneWifiWhiteList(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(sStationarySceneWifiWhiteList) == true) goto L19;
        if (sStationarySceneWifiWhiteList.contains(",") == false) goto L18;
        String[] r0 = sStationarySceneWifiWhiteList.split(",");
        int r2 = r0.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L16;
        if (r5.contains(r0[r3]) == true) goto L13;
        r3 = r3 + 1;
        goto L10
    L13:
        return true;
    L16:
        return false;
    L18:
        return r5.contains(sStationarySceneWifiWhiteList);
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
        boolean r1 = sOpenStationaryScene;     // Catch: Throwable -> L7
        monitor-exit(OPEN_STATIONARY_SCENE_LOCK);     // Catch: Throwable -> L7
        return r1;
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
        BDRestrictedMode r0 = sRestrictedMode;
        if (r0 != null) goto L5;
        return false;
    L5:
        int r1 = r0.getRestrictedMode();
        Logger.i("BDLocationConfig restrictedMode:" + r1);
        if (r1 == 1) goto L8;
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

    static /* synthetic */ void lambda$notificationLocationChange$0(int r5, BDLocation r6) {
        String r0 = RESTRICTED_LOCK;
        monitor-enter(r0);
    L5:
        if (r5 >= 5) goto L13;
        List r1 = (List) ZeusTransformUtils.preCheckCast(sNotifications.get(r5), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L15
    L10:
        if (r2.hasNext() == false) goto L12;
        ((LocationNotification) ZeusTransformUtils.preCheckCast(r2.next(), LocationNotification.class, "com.obric.memorydata.plugin")).onLocationChanged(r6);     // Catch: Throwable -> L15
    L12:
        r5 = r5 + 1;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
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

    public static boolean needRevertWifiOrStationInfoUpload(LocationOption r3) {
        if (r3 != null) goto L4;
    L8:
        StringBuilder r0 = new StringBuilder().append("BDLocationConfig.needRevertWifiOrStationInfoUpload: false, cert: ");
        if (r3 == null) goto L11;
        String r4 = r3.getUploadSource();
    L12:
        Logger.i(r0.append(r4).toString());
        return false;
    L11:
        r4 = "null";
        goto L12
    L4:
        if (r3.isOnceLocation() == false) goto L8;
        boolean r1 = isRevertToSystemLocation();
        Logger.i("BDLocationConfig.needRevertWifiOrStationInfoUpload: " + r1 + ", cert: " + r3.getUploadSource());
        return r1;
    }

    public static boolean needUploadLastContinuousLocation() {
        return sNeedUploadLastContinuousLocation;
    }

    public static void notificationLocationChange(final int r3, BDLocation r4) {
        final BDLocation r0 = new BDLocation(r4);
        r0.setLongitude(0.0d);
        r0.setLatitude(0.0d);
        r0.setAltitude(0.0d);
        if (r0.getLocationResult() == null) goto L5;
        r0.getLocationResult().gps = null;
    L5:
        new Handler(Looper.getMainLooper()).post(new $$Lambda$BDLocationConfig$9tXOdkvnRmPY6TCPQ8l5HLve_U(r3, r0));
    }

    public static void removeNotification(LocationNotification r2, int r3) {
        LocationNotification r4 = (LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin");
        String r0 = RESTRICTED_LOCK;
        monitor-enter(r0);
        switchNotification(r3).remove(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void removeSubmitNotification(LocationSubmitNotification r2) {
        LocationSubmitNotification r3 = (LocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationSubmitNotification.class, "com.obric.memorydata.plugin");
        List<LocationSubmitNotification> r0 = sSubmitNotifications;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.size() < 1) goto L11;
        if (r3 == null) goto L12;
        sSubmitNotifications.remove(r3);
        return;
    L12:
        return;
    }

    public static int rescanWifiCount() {
        return sRescanWifiCount;
    }

    public static void setAMapGPSCollectAlwaysUseNewAMapClient(boolean r0) {
        sIsAMapGPSCollectAlwaysUseNewAMapClient = r0;
    }

    public static void setAllowFetchConfigAtStart(boolean r0) {
        sAllowFetchConfigAtStart = r0;
    }

    public static void setAllowLocateFallback(boolean r0) {
        sAllowLocateFallback = r0;
    }

    public static void setAppBackgroundProvider(BackgroundProvider r3) {
        StringBuilder r0 = new StringBuilder().append("setAppBackgroundProvider provider:");
        if (r3 != null) goto L5;
        boolean r1 = true;
    L6:
        Logger.i(r0.append(r1).toString());
        BackgroundProvider r2 = sProvider;
        List<BackgroundProvider.Callback> r4 = null;
        if (r2 == null) goto L9;
        List<BackgroundProvider.Callback> r5 = r2.getCallback();
        sProvider.setCallback(null);
        r4 = r5;
    L9:
        sProvider = r3;
        if (r4 == null) goto L14;
        if (r3 == null) goto L15;
        r3.setCallback(r4);
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static void setAppBootTime(long r0) {
        sAppBootTime = r0;
    }

    public static void setAppId(String r0) {
        sAppId = r0;
    }

    public static void setAppVersion(String r0) {
        sAppVersion = r0;
    }

    public static void setAsyncScanWifi(boolean r0) {
        sAsyncScanWifi = r0;
    }

    public static void setBaseStationInfoType(int r0) {
        sBaseStationInfoType = r0;
    }

    public static void setBaseUrl(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L14:
        sBaseUrl = r2;
        return;
    L5:
        if (r2.contains(LocationInfoConst.HTTPS) == true) goto L14;
        if (isDebug() == false) goto L9;
    L13:
        Logger.e("当前定位接口非https加密，使用明文信息违反合规要求，请修改为https");
        goto L14
    L9:
        if (isOnline() == false) goto L13;
        throw new IllegalArgumentException("当前定位接口非https加密，使用明文信息违反合规要求，请修改为https");
    }

    public static void setBeaconConfig(JSONObject r0) {
        sBeaconConfig = r0;
    }

    public static void setBleCacheEntity(BLECacheEntity r0) {
        mBleCacheEntity = r0;
    }

    public static void setBootLegitimateTime(long r0) {
        sBootLegitimateTime = r0;
    }

    public static void setBpeaCerts(Map<String, Object> r2) {
        sBpeaCerts = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
    }

    public static void setBssNum(int r0) {
        sBssNum = r0;
    }

    public static void setByteLocationLibraParam(String r0) {
        sByteLocationLibraParam = r0;
    }

    public static void setByteLocationWhiteList(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        sByteLocationWhiteList = r1;
    }

    public static void setChannel(String r0) {
        sChannel = r0;
    }

    public static void setCheckConnectWifiRssi(int r0) {
        sConnectWifiRssi = r0;
    }

    public static void setCheckLocationBpea(boolean r0) {
        sCheckLocationBpea = r0;
    }

    public static void setCheckRefreshWifiTimeInterval(long r0) {
        sCheckRefreshWifiTimeInterval = r0;
    }

    public static void setChineseChannel(boolean r0) {
        sIsChineseChannel = r0;
    }

    public static void setColdBootABTest(boolean r0) {
        sColdBootABTest = r0;
    }

    public static void setColdBootCollectGps(boolean r0) {
        sColdBootCollectGps = r0;
    }

    public static void setColdBootCollectGpsStrategy(int r0) {
        sColdBootCollectGpsStrategy = r0;
    }

    public static void setCollectContinuousGPSDuration(long r0) {
        sCollectContinuousGPSDuration = r0;
    }

    public static void setCollectContinuousGPSInterval(long r0) {
        sCollectContinuousGPSInterval = r0;
    }

    public static void setCollectContinuousGpsDisableGnssUpload(boolean r0) {
        sCollectContinuousGpsDisableGnssUpload = r0;
    }

    public static void setCollectContinuousGpsOnlyLast(boolean r0) {
        sCollectContinuousGpsOnlyLast = r0;
    }

    public static void setCollectContinuousTokenBlacklist(String r0) {
        sCollectContinuousGPSTokenBlacklist = r0;
    }

    public static void setCollectGpsType(int r0) {
        sCollectGpsType = r0;
    }

    public static void setCollectLightInfo(boolean r0) {
        sCollectLightInfo = r0;
    }

    public static void setCommonParams(Map<String, String> r2) {
        sCommonParams = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
    }

    public static void setConfigParam(JSONObject r6) {
        Logger.d("BDLocation", "init config params are " + r6.toString());
        setIsUploadGPS(r6.optBoolean("report_gps", true));
        int r0 = r6.optInt("report_bss_max", 10);
        if (r0 <= 0) goto L5;
        setUploadBaseSite(true);
        setBssNum(r0);
    L6:
        setReportAtStart(r6.optBoolean("report_at_start", false));
        setReportLocationAtStart(r6.optBoolean("report_location_at_start", false));
        setUpload(r6.optBoolean("is_upload", true));
        setUploadLocation(r6.optBoolean("is_upload_location", true));
        setChineseChannel(r6.optBoolean("chinese_channel", true));
        int r1 = r6.optInt("location_update_interval", 300);
        int r3 = r6.optInt("report_interval_seconds", 300);
        if (r3 <= 0) goto L9;
        long r4 = r3 * 1000;
    L10:
        setUploadInterval(r4);
        setDebug(r6.optBoolean("debug_able", false));
        setAllowLocateFallback(r6.optBoolean("allow_locate_fallback", true));
        JSONArray r2 = r6.optJSONArray("error_code_list_for_fallback");
        ArrayList r5 = new ArrayList();
        if (r2 == null) goto L16;
        int r7 = 0;
    L14:
        if (r7 >= r2.length()) goto L16;
        r5.add(Integer.valueOf(r2.optInt(r7, 0)));
        r7 = r7 + 1;
    L16:
        setAllowFetchConfigAtStart(r6.optBoolean("allow_fetch_config_at_start", true));
        setPollingUpload(r6.optBoolean("polling_upload", isPollingUpload()));
        setMaxLocationTimeMs(r6.optLong("max_location_time_ms", 300000));
        setLocateType(r6.optInt(LocationMonitorConst.LOCATE_TYPE, 3));
        return;
    L9:
        r4 = r1 * 1000;
        goto L10
    L5:
        setUploadBaseSite(false);
        goto L6
    }

    public static void setContext(Context r2) {
        sContext = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
    }

    public static void setDYHostInfoProvider(IDYHostInfoProvider r2) {
        sDYHostInfoProvider = (IDYHostInfoProvider) ZeusTransformUtils.wrapperContextForParams(r2, IDYHostInfoProvider.class, "com.obric.memorydata.plugin");
    }

    public static void setDebug(boolean r0) {
        isDebug = r0;
    }

    public static void setDefaultGpsScanInterval(long r0) {
        sDefaultGpsScanInterval = r0;
    }

    public static void setDeviceId(String r0) {
        sDeviceId = r0;
    }

    public static void setDisableCollectAMapLocationSource(String r0) {
        sDisableCollectAMapLocationSource = r0;
    }

    public static void setDisableTailLocateOptimizeSource(String r0) {
        sDisableTailLocateOptimizeSource = r0;
    }

    public static void setDisableUuidList(List<String> r2) {
        sDisableUuidList = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public static void setEnableBackgroundLocation(boolean r0) {
        sEnableBackgroundLocation = r0;
    }

    public static void setEnableBackgroundUploadLocationn(boolean r0) {
        sEenableBackgroundUploadLocation = r0;
    }

    public static void setEnableBlePassiveName(boolean r0) {
        sEnableBlePassiveName = r0;
    }

    public static void setEnableBleTruncateOnTimeout(boolean r0) {
        sEnableBleTruncateOnTimeout = r0;
    }

    public static void setEnableBpea(boolean r3) {
        sEnableBpea = r3;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L6;
        LocationCache.getInstance().setBooleanValue(ENABLE_BPEA_CACHE_KEY, r3);
        return;
    }

    public static void setEnableByteContinuousLocation(boolean r0) {
        sEnableByteContinuousLocation = r0;
    }

    public static void setEnableCheckConnectWifi(boolean r0) {
        sEnableCheckConnectWifi = r0;
    }

    public static void setEnableCheckLastLogId(boolean r0) {
        sEnableCheckLastLogId = r0;
    }

    public static void setEnableCheckRefreshWifiTime(boolean r0) {
        sEnableCheckRefreshWifiTime = r0;
    }

    public static void setEnableCheckUploadCompliance(boolean r0) {
        sEnableCheckUploadCompliance = r0;
    }

    public static void setEnableCollectAMapLocationInBatterySavingMode(boolean r0) {
        sEnableCollectAMapLocationInBatterySavingMode = r0;
    }

    public static void setEnableCollectBleInBatterySavingMode(boolean r0) {
        sEnableCollectBleInBatterySavingMode = r0;
    }

    public static void setEnableCollectContinuousGPSLocation(boolean r0) {
        sEnableCollectContinuousGPSLocation = r0;
    }

    public static void setEnableCollectContinuousGpsForTest(boolean r0) {
        sEnableCollectContinuousGpsForTest = r0;
    }

    public static void setEnableCollectGPSLocationInBatterySavingMode(boolean r0) {
        sEnableCollectGPSLocationInBatterySavingMode = r0;
    }

    public static void setEnableCollectNetworkLocationInBatterySavingMode(boolean r0) {
        sEnableCollectNetworkLocationInBatterySavingMode = r0;
    }

    public static void setEnableContinueLocateUploadCell(boolean r0) {
        sEnableContinueLocateUploadCell = r0;
    }

    public static void setEnableContinueLocateUploadWifi(boolean r0) {
        sEnableContinueLocateUploadWifi = r0;
    }

    public static void setEnableDestroyAMapContinuousClient(boolean r0) {
        sEnableDestroyAMapContinuousClient = r0;
    }

    public static void setEnableDestroyAMapSingleClient(boolean r0) {
        sEnableDestroyAMapSingleClient = r0;
    }

    public static void setEnableDimLocationCheck(boolean r0) {
        sEnableDimLocationCheck = r0;
    }

    public static void setEnableGetNeighboringCell(boolean r0) {
        sEnableGetNeighboringCell = r0;
    }

    public static void setEnableGpsScan(boolean r0) {
        sEnableGpsScan = r0;
    }

    public static void setEnableHARCollect(boolean r0) {
        sEnableHARCollect = r0;
    }

    public static void setEnableInfoRequestOpt(boolean r0) {
        sEnableInfoRequestOpt = r0;
    }

    public static void setEnableLightLocation(boolean r0) {
        sEnableLightLocation = r0;
    }

    public static void setEnableLightLocationNewPolicy(boolean r0) {
        sEnableLightLocationNewPolicy = r0;
    }

    public static void setEnableLocationCacheTokenWhiteList(boolean r0) {
        sEnableLocationCacheTokenWhiteList = r0;
    }

    public static void setEnableLocationOptBpeaList(String r2) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        Logger.i("setEnableLocationOptBpeaList: \"" + r2 + Typography.quote);
        sEnableLocationOptBpeaList = r2;
    }

    public static void setEnableLocationOptEncrypt(boolean r2) {
        Logger.i("setEnableLocationOptEncrypt: " + r2);
        sEnableLocationOptEncrypt = r2;
    }

    public static void setEnableMonitor(boolean r0) {
        sEnableMonitor = r0;
    }

    public static void setEnableRescanWifi(boolean r0) {
        sEnableRescanWifi = r0;
    }

    public static void setEnableScanBle(boolean r0) {
        sScanBle = r0;
    }

    public static void setEnableScanGnss(boolean r0) {
        sEnableScanGnss = r0;
    }

    public static void setEnableScanWifi(boolean r0) {
        sEnableScanWifi = r0;
    }

    public static void setEnableSelfStartService(boolean r0) {
        sEnableSelfStartService = r0;
    }

    public static void setEnableStationaryScenePolicy(boolean r0) {
        sEnableStationaryScenePolicy = r0;
    }

    public static void setEnableTailLocateOptimize(boolean r0) {
        sEnableTailLocateOptimize = r0;
    }

    public static void setEnableTraceroute(boolean r0) {
        mEnableTraceroute = r0;
    }

    public static void setEnableUploadLastLocationInfo(boolean r0) {
        sEnableUploadLastLocationInfo = r0;
    }

    public static void setEnableUploadLastLogId(boolean r0) {
        sEnableUploadLastLogId = r0;
    }

    public static void setEnableUseCoarseLocation(boolean r0) {
        sEnableUseCoarseLocation = r0;
    }

    public static void setEnv(Pair<String, String> r0) {
        sEnv = r0;
    }

    public static void setEventManager(IEventManager r2) {
        sEventManager = (IEventManager) ZeusTransformUtils.wrapperContextForParams(r2, IEventManager.class, "com.obric.memorydata.plugin");
    }

    public static void setFirstLocation(boolean r0) {
        sIsFirstLocation = r0;
    }

    public static void setFirstLocationTimeoutMs(long r0) {
        sFirstLocationTimeoutMs = r0;
    }

    public static void setFirstRequestLocation(boolean r0) {
        sFirstRequestLocation = r0;
    }

    public static void setFreshBaseStationTimeout(long r0) {
        sFreshBaseStationTimeout = r0;
    }

    public static void setGpsScanInterval(long r0) {
        sGpsScanInterval = r0;
    }

    public static void setHARStatusRange(int r0) {
        sHARStatusRange = r0;
    }

    public static void setHotBootCacheTime(int r0) {
        sHotBootCacheTime = r0;
    }

    public static void setHotBootLocToken(String r0) {
        sHotBootLocToken = r0;
    }

    public static void setILocationInfoExtra(ILocationInfoExtra r2) {
        sLocationInfoExtra = (ILocationInfoExtra) ZeusTransformUtils.wrapperContextForParams(r2, ILocationInfoExtra.class, "com.obric.memorydata.plugin");
    }

    public static void setInOutDoorStatusCacheTime(long r0) {
        sInOutDoorStatusCacheTime = r0;
    }

    public static void setIndependentThreadGetScanResults(boolean r2) {
        Logger.i("setIndependentThreadGetScanResults: " + r2);
        sIsIndepentThreadGetScanResults = r2;
    }

    public static void setInfoRequestKeyParamsMaxCacheTime(long r0) {
        sInfoRequestKeyParamsMaxCacheTime = r0;
    }

    public static void setInvokerApiInitStatus(int r0) {
        sInvokerApiInitStatus = r0;
    }

    public static void setIsUploadGPS(boolean r0) {
        sIsUploadGPS = r0;
    }

    public static void setIsUseQuickGPS(boolean r0) {
        sIsUseQuickGPS = r0;
    }

    public static void setLightInfoInterval(int r0) {
        sLightInfoInterval = r0;
    }

    public static void setLocale(Locale r0) {
        sLocale = r0;
    }

    public static void setLocateType(int r0) {
        sLocateType = r0;
    }

    public static void setLocationCacheTokenWhiteList(String r0) {
        sLocationCacheTokenWhiteList = r0;
    }

    public static void setLocationExpiredInterval(long r0) {
        sLocationExpiredInterval = r0;
    }

    public static void setLocationMode(int r0) {
        sLocationMode = r0;
    }

    public static void setLogIdCacheEntity(LogIdCacheEntity r0) {
        mLogIdCacheEntity = r0;
    }

    public static void setMaxLightCount(int r0) {
        sMaxLightCount = r0;
    }

    public static void setMaxLightDuration(long r0) {
        sMaxLightDuration = r0;
    }

    public static void setMaxLocationTimeMs(long r0) {
        sMaxLocationTimeMs = r0;
    }

    public static void setMaxWaitGpsTimeMillis(long r0) {
        sMaxWaitGpsTimeMillis = r0;
    }

    public static void setMockEnable(boolean r0) {
        sIsMockEnable = r0;
    }

    public static void setMockUpload(boolean r0) {
        sIsMockUpload = r0;
    }

    public static void setMockWifiName(String r1) {
        sMockWifiName = r1;
        LocationCache.getInstance().setMockWifiName(r1);
    }

    public static void setMonitorBusinessStartLocationClassMemberList(List<String> r2) {
        sMonitorBusinessStartLocationClassMemberList = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public static void setMonitorBusinessStopLocationClassMemberList(List<String> r2) {
        sMonitorBusinessStopLocationClassMemberList = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public static void setMonitorStrategy(int r0) {
        sMonitorStrategy = r0;
    }

    public static void setMonitorStrategyClassMemberList(List<String> r2) {
        sMonitorStrategyClassMemberList = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
    }

    public static void setMonitorStrategyInterval(long r0) {
        sMonitorStrategyInterval = r0;
    }

    public static void setNeedDownGradeLocationInOverseas(boolean r0) {
        sNeedDownGradeLocationInOverseas = r0;
    }

    public static void setNeedUploadLastContinuousLocation(boolean r0) {
        sNeedUploadLastContinuousLocation = r0;
    }

    public static void setNetworkApi(ICustomNetworkApi r2) {
        sNetworkApi = (ICustomNetworkApi) ZeusTransformUtils.wrapperContextForParams(r2, ICustomNetworkApi.class, "com.obric.memorydata.plugin");
    }

    public static void setNetworkSignatureMode(String r0) {
        sNetworkSignatureMode = r0;
    }

    public static void setNetworkStatusChangeUploadInterval(long r0) {
        sNetworkStatusChangeUploadInterval = sNetworkStatusChangeUploadInterval;
    }

    public static void setNoLocReqCgiEnable(boolean r0) {
        sIsNoLocReqCgiEnable = r0;
    }

    public static void setOnline(boolean r0) {
        sOnline = r0;
    }

    public static void setOpenStationaryScene(boolean r1) {
        monitor-enter(OPEN_STATIONARY_SCENE_LOCK);
        sOpenStationaryScene = r1;     // Catch: Throwable -> L7
        monitor-exit(OPEN_STATIONARY_SCENE_LOCK);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setOpenWifiListMonitor(boolean r0) {
        sOpenWifiListMonitor = r0;
    }

    public static void setOverseasGetLocationFailedUseCacheValidity(long r0) {
        sOverseasGetLocationFailedUseCacheValidity = r0;
    }

    public static void setPackageName(String r0) {
        sPackageName = r0;
    }

    public static void setPermissionChecker(IPermissionChecker r2) {
        sPermissionChecker = (IPermissionChecker) ZeusTransformUtils.wrapperContextForParams(r2, IPermissionChecker.class, "com.obric.memorydata.plugin");
    }

    public static void setPollingUpload(boolean r2) {
        Logger.i("setPollingUpload", ParameterizedMessage.ERROR_MSG_SEPARATOR + r2);
        sIsPollingUpload = r2;
    }

    public static void setPreLocationCallback(boolean r0) {
        sEnablePreLocationCallback = r0;
    }

    public static void setPrivacyConfirmed(boolean r0) {
        isPrivacyConfirmed = r0;
    }

    public static void setRedGeoNameIds(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        sRedGeoNameIds = r1;
    }

    public static void setRegionInChineseChannel(boolean r0) {
        sRegionInChineseChannel = r0;
    }

    public static void setReportAtStart(boolean r0) {
        sReportAtStart = r0;
    }

    public static void setReportLocationAtStart(boolean r0) {
        sReportLocationAtStart = r0;
    }

    public static void setRequestLocation(boolean r0) {
        sShouldRequestLocation = r0;
    }

    public static void setRescanWifiCount(int r0) {
        sRescanWifiCount = r0;
    }

    public static void setRestrictedMode(BDRestrictedMode r2) {
        sRestrictedMode = (BDRestrictedMode) ZeusTransformUtils.wrapperContextForParams(r2, BDRestrictedMode.class, "com.obric.memorydata.plugin");
    }

    public static void setRevertToSystemLocation(boolean r0) {
        sRevertToSystemLocation = r0;
    }

    public static void setScanBleInterval(long r3) {
        if (r3 <= 10000) goto L5;
        r3 = 10000;
    L5:
        sScanBleInterval = r3;
    }

    public static void setSdkVersion(String r0) {
        sSdkVersion = r0;
    }

    public static void setSearchLocationCacheTime(long r0) {
        sSearchLocationCacheTime = r0;
    }

    public static void setSessionId(String r0) {
        sSessionId = r0;
    }

    public static void setShakeConfig(JSONObject r0) {
        mShakeConfig = r0;
    }

    public static void setSlardarAid(String r0) {
        sSlardarAid = r0;
    }

    public static void setStationarySceneMaxDistance(int r0) {
        sStationarySceneMaxDistance = r0;
    }

    public static void setStationarySceneMaxGpsAccuracy(int r0) {
        sStationarySceneMaxGpsAccuracy = r0;
    }

    public static void setStationarySceneMaxInterval(long r0) {
        sStationarySceneMaxInterval = r0;
    }

    public static void setStationarySceneTokenWhiteList(String r0) {
        sStationarySceneTokenWhiteList = r0;
    }

    public static void setStationarySceneWifiWhiteList(String r0) {
        sStationarySceneWifiWhiteList = r0;
    }

    public static void setStrictRestrictedMode(boolean r0) {
        sIsStrictRestrictedMode = r0;
    }

    public static void setSysNetworkLocEnable(boolean r0) {
        sIsSysNetworkLocEnable = r0;
    }

    public static void setTailAccuracyThreshold(float r0) {
        sTailAccuracyThreshold = r0;
    }

    public static void setTailWifiTimeThreshold(long r0) {
        sTailWifiTimeThreshold = r0;
    }

    public static void setUpdateVersionCode(String r0) {
        sUpdateVersionCode = r0;
    }

    public static void setUpload(boolean r0) {
        sIsUpload = r0;
    }

    public static void setUploadBaseSite(boolean r0) {
        sIsUploadBaseSite = r0;
    }

    public static void setUploadBleImmediately(boolean r0) {
        sUploadBleImmediately = r0;
    }

    public static void setUploadBleNum(int r0) {
        sUploadBleNum = r0;
    }

    public static void setUploadFreshBaseStation(boolean r0) {
        sIsUploadFreshBaseStation = r0;
    }

    public static void setUploadInterval(long r0) {
        sUploadInterval = r0;
    }

    public static void setUploadLocation(boolean r0) {
        sIsUploadLocation = r0;
    }

    public static void setUploadMccAndSystemRegionInfo(boolean r0) {
        sUploadMccAndSystemRegionInfo = r0;
    }

    public static void setUploadNetSignalInterval(long r0) {
        sUploadNetSignalInterval = r0;
    }

    @Deprecated
    public static void setUploadWIFI(boolean r1) {
        if (isDebug() == false) goto L6;
        sIsUploadWIFI = r1;
        return;
    }

    public static void setUseCacheCondition(boolean r0) {
        sUseCacheCondition = r0;
    }

    public static void setUseGpsCheckRegion(boolean r0) {
        sUseGpsCheckRegion = r0;
    }

    public static void setUseNewCacheStrategy(boolean r0) {
        sUseNewCacheStrategy = r0;
    }

    public static void setUseNewReverseGeoLocationApi(boolean r0) {
        sUseNewReverseGeoLocationApi = r0;
    }

    public static void setWifiNum(int r0) {
        sWifiNum = r0;
    }

    public static void setWifiScanInterval(long r0) {
        sWifiScanInterval = r0;
    }

    public static void setWorldView(String r0) {
        sWorldView = r0;
    }

    public static boolean shouldRequestLocation() {
        return sShouldRequestLocation;
    }

    private static List<LocationNotification> switchNotification(int r3) {
        List<LocationNotification> r0 = (List) ZeusTransformUtils.preCheckCast(sNotifications.get(r3), List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        ArrayList r1 = new ArrayList();
        sNotifications.put(r3, r1);
        return r1;
    L6:
        return r0;
    }

    public static boolean useGpsCheckRegion() {
        return sUseGpsCheckRegion;
    }

    public static boolean useNewReverseGeoLocationApi() {
        return sUseNewReverseGeoLocationApi;
    }
}
