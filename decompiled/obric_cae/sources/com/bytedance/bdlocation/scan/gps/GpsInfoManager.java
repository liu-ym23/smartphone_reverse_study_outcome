package com.bytedance.bdlocation.scan.gps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.trace.StackTraceRecorder;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class GpsInfoManager {
    private int collectLocateNum;
    private boolean enableCollectAMapLocation;
    private boolean enableCollectGPSLocation;
    private boolean enableCollectNetworkLocation;
    private volatile boolean enableGPSContinuousOverSingleLocate;
    private final AtomicBoolean hasMonitorGpsCollect;
    private IBPEALocal mBPEAManager;
    private GpsCollectCallback mCallback;
    private Context mContext;
    private ContinuousGPSLocationInfoListener mContinuousGpsLocationListener;
    private LocationExtraDataTraceLogger mExtraDataTraceLogger;
    private GnssStatusCallback mGnssStatusCallback;
    private LocationInfoListener mGpsLocationListener;
    private GpsStatusListener mGpsStatusListener;
    private Handler mHandler;
    private volatile boolean mIsCollectGpsFinishedForSteal;
    private volatile boolean mIsGpsStatusReady;
    private volatile boolean mIsLocationInfoReady;
    private AtomicInteger mLocateNum;
    private LocationManager mLocationManager;
    private LocationInfoListener mNetworkLocationListener;
    private LocationOption mOption;
    private volatile BDScanLocationInfo mScanLocationInfo;
    private volatile long mStartCollectClock;
    private TimeOutTask mTimeOutTask;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.gps.GpsInfoManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class ContinuousGPSLocationInfoListener implements LocationListener {
        private final AtomicBoolean hasReportStealLocation;
        final /* synthetic */ GpsInfoManager this$0;

        private ContinuousGPSLocationInfoListener(GpsInfoManager r8) {
            this.this$0 = r8;
            this.hasReportStealLocation = new AtomicBoolean(false);
        }

        private void reportLocateFinish() {
            if (GpsInfoManager.access$1100(this.this$0).getGpsInfo().isEmpty() == false) goto L5;
            Logger.i("ContinuousGPSLocationInfoListener: onLocationChanged location is null");
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.GPS_OR_NETWORK_LOCATION_IS_NULL, Boolean.TRUE);
        L6:
            GpsInfoManager.access$500(this.this$0);
            return;
        L5:
            GpsInfoManager.access$1200(this.this$0);
            goto L6
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            Logger.i("ContinuousGPSLocationInfoListener: receive new location input, provider:" + r8.getProvider());
            GpsInfoManager.access$1000(this.this$0, r8, 2);
            List<Long> r10 = GpsInfoManager.access$1100(this.this$0).getGpsInfoReportClocks();
            if (r10.size() >= 2) goto L7;
        L9:
            Logger.i("ContinuousGPSLocationInfoListener: still need wait, but can steal.");
            if (this.hasReportStealLocation.compareAndSet(false, true) == false) goto L14;
            GpsInfoManager.access$600(this.this$0);
            return;
        L14:
            return;
        L7:
            if ((r10.get(r10.size() - 1).longValue() - r10.get(0).longValue()) < BDLocationConfig.getCollectContinuousGPSDuration()) goto L9;
            Logger.i("ContinuousGPSLocationInfoListener: collect enough gps, report finish.");
            reportLocateFinish();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r8) {
            Logger.i("ContinuousGPSLocationInfoListener: onProviderDisabled, provider:" + r8);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r8) {
            Logger.i("ContinuousGPSLocationInfoListener: onProviderEnabled, provider:" + r8);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r8, int r10, Bundle r11) {
            Logger.i("ContinuousGPSLocationInfoListener: onStatusChanged, provider:" + r8);
        }

        public /* synthetic */ ContinuousGPSLocationInfoListener(GpsInfoManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class GnssStatusCallback extends GnssStatus.Callback {
        final /* synthetic */ GpsInfoManager this$0;

        private GnssStatusCallback(GpsInfoManager r8) {
            this.this$0 = r8;
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r8) {
            if (GpsInfoManager.access$1100(this.this$0) == null) goto L15;
            if (r8 == null) goto L15;
            int r10 = r8.getSatelliteCount();
            ArrayList r11 = new ArrayList();
            int r12 = 0;
        L7:
            if (r12 >= r10) goto L12;
            BDSatelliteInfo r13 = new BDSatelliteInfo();     // Catch: ArrayIndexOutOfBoundsException -> L10
            r13.sVid = r8.getSvid(r12);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r13.snr = r8.getCn0DbHz(r12);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r13.azimuthDegrees = r8.getAzimuthDegrees(r12);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r13.elevationDegrees = r8.getElevationDegrees(r12);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r13.constellationType = r8.getConstellationType(r12);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r13.hasCarrierFrequencyHz = r8.hasCarrierFrequencyHz(r12);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r13.carrierFrequencyHz = r8.getCarrierFrequencyHz(r12);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r13.usedInFix = r8.usedInFix(r12);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r11.add(r13);     // Catch: ArrayIndexOutOfBoundsException -> L10
            r12 = r12 + 1;
        L10:
            e = move-exception;
            Logger.e("GnssStatusCallback: getSvid out of bounds at index " + r12 + ", count=" + r10, e);
        L12:
            BDGnssInfo r14 = new BDGnssInfo();
            r14.satelliteNum = r11.size();
            r14.satelliteInfos = r11;
            r14.timestamp = System.currentTimeMillis();
            r14.callbackClock = SystemClock.elapsedRealtime();
            GpsInfoManager.access$1100(this.this$0).addGnssInfo(r14);
            String r15 = "GnssStatusCallback: onSatelliteStatusChanged, maxSatelliteCount:" + r10;
        L13:
            Logger.i(r15);
            return;
        L15:
            r15 = "GpsStatusListener: mScanLocationInfo | gnssStatus is null";
            goto L13
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            super.onStarted();
            Logger.i("GnssStatusCallback: onStarted");
            GpsInfoManager.access$1100(this.this$0).cleanGnssInfo();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            super.onStopped();
            Logger.i("GnssStatusCallback: onStopped");
            GpsInfoManager.access$1400(this.this$0);
            GpsInfoManager.access$1502(this.this$0, true);
            GpsInfoManager.access$1600(this.this$0);
        }

        public /* synthetic */ GnssStatusCallback(GpsInfoManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class GpsStatusListener implements GpsStatus.Listener {
        final /* synthetic */ GpsInfoManager this$0;

        private GpsStatusListener(GpsInfoManager r8) {
            this.this$0 = r8;
        }

        @Override // android.location.GpsStatus.Listener
        @SuppressLint({"MissingPermission"})
        public void onGpsStatusChanged(int r8) {
            Logger.i("GpsStatusListener: onGpsStatusChanged");
            if (r8 != 1) goto L5;
            String r10 = "GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_STARTED";
        L31:
            Logger.i(r10);
            return;
        L5:
            if (r8 != 2) goto L7;
            Logger.i("GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_STOPPED");
            GpsInfoManager.access$1400(this.this$0);
            GpsInfoManager.access$1502(this.this$0, true);
            GpsInfoManager.access$1600(this.this$0);
            return;
        L7:
            if (r8 != 3) goto L9;
            Logger.i("GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_FIRST_FIX");
            GpsInfoManager.access$1100(this.this$0).cleanGnssInfo();
            return;
        L9:
            if (r8 == 4) goto L12;
            return;
        L12:
            if (GpsInfoManager.access$1300(this.this$0) != null) goto L17;
            String r11 = "GpsStatusListener: location manager is null";
        L14:
            Logger.i(r11);
            return;
        L17:
            if (GpsInfoManager.access$1100(this.this$0) != null) goto L19;
            r11 = "GpsStatusListener: mScanLocationInfo is null";
            goto L14
        L19:
            GpsStatus r12 = GpsInfoManager.access$1300(this.this$0).getGpsStatus(null);
            if (r12 != null) goto L22;
            r11 = "GpsStatusListener: gpsStatus is null";
            goto L14
        L22:
            int r13 = r12.getMaxSatellites();
            ArrayList r14 = new ArrayList();
            Iterator<GpsSatellite> r15 = r12.getSatellites().iterator();
            int r16 = 0;
        L24:
            if (r15.hasNext() == false) goto L27;
            if (r16 >= r13) goto L27;
            GpsSatellite r17 = r15.next();
            BDSatelliteInfo r18 = new BDSatelliteInfo();
            r18.snr = r17.getSnr();
            r18.azimuthDegrees = r17.getAzimuth();
            r18.elevationDegrees = r17.getElevation();
            r18.usedInFix = r17.usedInFix();
            r18.sVid = r17.getPrn();
            r14.add(r18);
            r16 = r16 + 1;
        L27:
            BDGnssInfo r19 = new BDGnssInfo();
            r19.satelliteNum = r13;
            r19.satelliteInfos = r14;
            r19.timestamp = System.currentTimeMillis();
            r19.callbackClock = SystemClock.elapsedRealtime();
            GpsInfoManager.access$1100(this.this$0).addGnssInfo(r19);
            r10 = "GpsStatusListener: onGpsStatusChanged GPS_EVENT_SATELLITE_STATUS, satellite count:" + r16;
            goto L31
        }

        public /* synthetic */ GpsStatusListener(GpsInfoManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public class LocationInfoListener implements LocationListener, BDLocationCallback {
        private final String intentProvider;
        final /* synthetic */ GpsInfoManager this$0;

        public LocationInfoListener(GpsInfoManager r8, String r10) {
            this.this$0 = r8;
            this.intentProvider = r10;
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onError(BDLocationException r8) {
            Logger.i("LocationInfoListener: amap onError:" + r8.getDetailMessage());
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.AMAP_LOCATION_ERROR, Boolean.TRUE);
            GpsInfoManager.access$500(this.this$0);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r8) {
            if (r8 != null) goto L8;
            Logger.i("GpsInfoManager: onLocationChanged location is null");
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.GPS_OR_NETWORK_LOCATION_IS_NULL, Boolean.TRUE);
            GpsInfoManager.access$500(this.this$0);
            if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(this.intentProvider) == false) goto L16;
            GpsInfoManager.access$600(this.this$0);
            return;
        L16:
            return;
        L8:
            String r10 = r8.getProvider();
            Logger.i("LocationInfoListener: onLocationChanged provider:" + r10);
            if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r10) == false) goto L11;
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.GPS_LOCATION_CHANGED, Boolean.TRUE);
            GpsInfoManager.access$700(this.this$0, r8);
        L12:
            GpsInfoManager.access$500(this.this$0);
            if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(this.intentProvider) == false) goto L17;
            GpsInfoManager.access$600(this.this$0);
            return;
        L17:
            return;
        L11:
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.NETWORK_LOCATION_CHANGED, Boolean.TRUE);
            GpsInfoManager.access$800(this.this$0, r8);
            goto L12
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r8) {
            Logger.i("LocationInfoListener: onProviderDisabled, provider:" + r8);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r8) {
            Logger.i("LocationInfoListener: onProviderEnabled, provider:" + r8);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r8, int r10, Bundle r11) {
            Logger.i("LocationInfoListener: onStatusChanged, provider:" + r8);
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onLocationChanged(BDLocation r8) {
            if (r8 != null) goto L4;
            return;
        L4:
            Logger.i("LocationInfoListener: amap onLocationChanged provider:" + r8.getProvider());
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.AMAP_LOCATION_CHANGED, Boolean.TRUE);
            GpsInfoManager.access$900(this.this$0, r8);
            GpsInfoManager.access$500(this.this$0);
        }
    }

    public class TimeOutTask implements Runnable {
        final /* synthetic */ GpsInfoManager this$0;

        private TimeOutTask(GpsInfoManager r8) {
            this.this$0 = r8;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.i("GpsInfoManager: collect timeout");
            if (GpsInfoManager.access$1700(this.this$0) == true) goto L5;
        L9:
            this.this$0.stopGpsCollect();
            GpsInfoManager.access$1800(this.this$0);
            GpsInfoManager.access$600(this.this$0);
            return;
        L5:
            if (GpsInfoManager.access$1100(this.this$0) == null) goto L9;
            if (GpsInfoManager.access$1100(this.this$0).getGpsInfo().isEmpty() == true) goto L9;
            GpsInfoManager.access$1200(this.this$0);
            goto L9
        }

        public /* synthetic */ TimeOutTask(GpsInfoManager r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public GpsInfoManager() {
        this.mIsLocationInfoReady = false;
        this.mIsGpsStatusReady = false;
        this.mIsCollectGpsFinishedForSteal = false;
        this.mStartCollectClock = -1;
        this.collectLocateNum = 0;
        this.enableGPSContinuousOverSingleLocate = false;
        this.hasMonitorGpsCollect = new AtomicBoolean(false);
        Context r8 = BDLocationConfig.getContext();
        this.mContext = r8;
        if (r8 != null) goto L6;
        Logger.i("mContext is null" + Log.getStackTraceString(new Throwable()));
        LocationMonitor.uploadAllStackTraces("GpsInfoManager", LocationUtil.getStackTrace());
        LocationMonitor.uploadAllStackTraces("ColdBootManager", StackTraceRecorder.getColdBootStackTrace());
        return;
    L6:
        this.mLocationManager = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);
        this.mHandler = new Handler(ThreadLooperManager.getLocationWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    public static /* synthetic */ BDGpsInfo access$1000(GpsInfoManager r8, Location r10, int r11) {
        return r8.recordGpsInfo(r10, r11);
    }

    public static /* synthetic */ BDScanLocationInfo access$1100(GpsInfoManager r8) {
        return r8.mScanLocationInfo;
    }

    public static /* synthetic */ void access$1200(GpsInfoManager r8) {
        r8.gpsCollectMonitor();
    }

    public static /* synthetic */ LocationManager access$1300(GpsInfoManager r8) {
        return r8.mLocationManager;
    }

    public static /* synthetic */ void access$1400(GpsInfoManager r8) {
        r8.unregisterGnssCallback();
    }

    public static /* synthetic */ boolean access$1502(GpsInfoManager r8, boolean r10) {
        r8.mIsGpsStatusReady = r10;
        return r10;
    }

    public static /* synthetic */ void access$1600(GpsInfoManager r8) {
        r8.callbackAndRemoveTimeOutTask();
    }

    public static /* synthetic */ boolean access$1700(GpsInfoManager r8) {
        return r8.enableGPSContinuousOverSingleLocate;
    }

    public static /* synthetic */ void access$1800(GpsInfoManager r8) {
        r8.callbackGpsInfo();
    }

    public static /* synthetic */ LocationExtraDataTraceLogger access$400(GpsInfoManager r8) {
        return r8.mExtraDataTraceLogger;
    }

    public static /* synthetic */ void access$500(GpsInfoManager r8) {
        r8.executeLocationChangedFinish();
    }

    public static /* synthetic */ void access$600(GpsInfoManager r8) {
        r8.markGpsFinishForSteal();
    }

    public static /* synthetic */ void access$700(GpsInfoManager r8, Location r10) {
        r8.updateSingleGpsLocation(r10);
    }

    public static /* synthetic */ void access$800(GpsInfoManager r8, Location r10) {
        r8.updateNetworkLocation(r10);
    }

    public static /* synthetic */ void access$900(GpsInfoManager r8, BDLocation r10) {
        r8.updateAMapLocation(r10);
    }

    private void addLocationListener(Object r8, LocationOption r10) {
    L12:
        e = move-exception;
        Logger.e("GpsInfoManager: addLocationListener error", e);
        this.mStartCollectClock = -1;
    L14:
        markGpsFinishForSteal();
        return;
    L4:
        if (this.mLocationManager == null) goto L14;
        if (this.mStartCollectClock != (-1)) goto L8;
        this.mStartCollectClock = SystemClock.elapsedRealtime();     // Catch: Exception -> L12
    L8:
        Logger.i("GpsInfoManager: addLocationListener mStartCollectClock:" + this.mStartCollectClock + "-CollectGpsType:" + BDLocationConfig.getCollectGpsType() + "-DisableCollectAMapLocationSource:" + BDLocationConfig.getDisableCollectAMapLocationSource() + "-UploadSource:" + r10.getUploadSource());     // Catch: Exception -> L12
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "byte_location_libra_param", BDLocationConfig.getByteLocationLibraParam());     // Catch: Exception -> L12
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "collect_gps_type", Integer.valueOf(BDLocationConfig.getCollectGpsType()));     // Catch: Exception -> L12
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "disable_collect_amap_location_source", BDLocationConfig.getDisableCollectAMapLocationSource());     // Catch: Exception -> L12
        setLocationCollectConditions(r10);     // Catch: Exception -> L12
        collectGPSLocation(r10, r8);     // Catch: Exception -> L12
        if (LocationInfoConst.LIBRA_PARAM_V2.equals(BDLocationConfig.getByteLocationLibraParam()) == false) goto L18;
        collectNetworkLocation(r10, r8);     // Catch: Exception -> L12
        collectAMapLocation();     // Catch: Exception -> L12
        return;
    }

    private synchronized void callbackAndRemoveTimeOutTask() {
        monitor-enter(this);
        Logger.i("GpsInfoManager: mIsLocationInfoReady:" + this.mIsLocationInfoReady + ", mIsGpsStatusReady:" + this.mIsGpsStatusReady);     // Catch: Throwable -> L16
        if (this.mIsLocationInfoReady == true) goto L7;
    L14:
        monitor-exit(this);
        return;
    L7:
        if (this.mIsGpsStatusReady == false) goto L14;
        Logger.i("GpsInfoManager: callbackAndRemoveTimeOutTask");     // Catch: Throwable -> L16
        Handler r8 = this.mHandler;     // Catch: Throwable -> L16
        if (r8 == null) goto L13;
        TimeOutTask r10 = this.mTimeOutTask;     // Catch: Throwable -> L16
        if (r10 == null) goto L13;
        r8.removeCallbacks(r10);     // Catch: Throwable -> L16
    L13:
        callbackGpsInfo();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private synchronized void callbackGpsInfo() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.mCallback != null) goto L6;
    L15:
        this.mIsLocationInfoReady = false;     // Catch: Throwable -> L18
        this.mIsGpsStatusReady = false;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L6:
        if (this.mScanLocationInfo.getAMapLocation() == null) goto L8;
    L14:
        Logger.i("LocationInfoListener: callbackGpsInfo success");     // Catch: Throwable -> L18
        this.mCallback.onSuccess(this.mScanLocationInfo);     // Catch: Throwable -> L18
        goto L15
    L8:
        if (this.mScanLocationInfo.getSysLocation() != null) goto L14;
        if (this.mScanLocationInfo.getGpsInfo().isEmpty() == false) goto L14;
        Logger.i("LocationInfoListener: callbackGpsInfo mScanLocationInfo is null");     // Catch: Throwable -> L18
        this.mCallback.onFail(2);     // Catch: Throwable -> L18
        monitor-exit(this);
    }

    private boolean checkEnableContinuousGps(LocationOption r8) {
        if (BDLocationConfig.enableCollectContinuousGPSLocation() == true) goto L5;
        return false;
    L5:
        String r10 = BDLocationConfig.getCollectContinuousTokenBlacklist();
        if (r10 == null) goto L11;
        if (r10.contains(r8.getUploadSource()) == false) goto L11;
        return false;
    L11:
        if (BDLocationConfig.enableCollectContinuousGpsForTest() == false) goto L14;
        return true;
    L14:
        if (LocationUtil.getInOutDoorStatusInTenMinutes() == 2) goto L16;
        return false;
    L16:
        return true;
    }

    private void collectAMapLocation() {
        if (this.enableCollectAMapLocation == true) goto L5;
        return;
    L5:
        Logger.i("GpsInfoManager: requestSingleUpdate aMap");
        if (BDLocationConfig.isAMapGPSCollectAlwaysUseNewAMapClient() == false) goto L8;
        ILocate r8 = BDLocationExtrasService.getNewAMapLocate();
    L9:
        if (r8 == null) goto L12;
        LocationOption r10 = new LocationOption();
        r10.setMode(2);
        r10.setMaxCacheTime(0);
        r10.setOnceLocation(true);
        r10.setLocationTimeOutMs(30000);
        r8.startLocation(new LocationInfoListener(this, "AMap"), r10, this.mHandler.getLooper());
        Logger.i("GpsInfoManager: startLocation aMap");
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_AMAP_LOCATION, Boolean.TRUE);
        return;
    L12:
        return;
    L8:
        r8 = BDLocationExtrasService.getLocate(this.mContext, 1);
        goto L9
    }

    private void collectGPSLocation(LocationOption r22, Object r23) {
        if (this.enableCollectGPSLocation == true) goto L6;
        markGpsFinishForSteal();
        return;
    L6:
        AnonymousClass1 r8 = null;
        if (BDLocationConfig.getByteLocationWhiteList().contains(r22.getUploadSource()) == false) goto L21;
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 1) goto L16;
        if (this.enableGPSContinuousOverSingleLocate == false) goto L13;
        this.mContinuousGpsLocationListener = new ContinuousGPSLocationInfoListener(this, r8);
        this.mBPEAManager.requestLocationUpdates(this.mLocationManager, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, BDLocationConfig.getCollectContinuousGPSInterval(), 0.0f, this.mContinuousGpsLocationListener, this.mHandler.getLooper(), r23);
    L14:
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_GPS_LOCATION, Boolean.TRUE);
        Logger.i("addLocationListener: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " requestSingleUpdate GPS");
        goto L16
    L13:
        LocationInfoListener r10 = new LocationInfoListener(this, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);
        this.mGpsLocationListener = r10;
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r10, this.mHandler.getLooper(), r23);
    L16:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 2) goto L18;
    L19:
        this.mGpsLocationListener = new LocationInfoListener(this, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);
        this.mGpsLocationListener.onLocationChanged(this.mBPEAManager.getLastKnownLocation(this.mLocationManager, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r23));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_GPS_LOCATION, Boolean.TRUE);
        Logger.i("addLocationListener: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " getLastKnownLocation GPS");
        return;
    L18:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() == 3) goto L19;
        return;
    L21:
        if (this.enableGPSContinuousOverSingleLocate == false) goto L23;
        this.mContinuousGpsLocationListener = new ContinuousGPSLocationInfoListener(this, r8);
        this.mBPEAManager.requestLocationUpdates(this.mLocationManager, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, BDLocationConfig.getCollectContinuousGPSInterval(), 0.0f, this.mContinuousGpsLocationListener, this.mHandler.getLooper(), r23);
    L24:
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_GPS_LOCATION, Boolean.TRUE);
        return;
    L23:
        LocationInfoListener r11 = new LocationInfoListener(this, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);
        this.mGpsLocationListener = r11;
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r11, this.mHandler.getLooper(), r23);
        goto L24
    }

    private void collectNetworkLocation(LocationOption r12, Object r13) {
        if (this.enableCollectNetworkLocation == true) goto L6;
        return;
    L6:
        if (BDLocationConfig.getByteLocationWhiteList().contains(r12.getUploadSource()) == true) goto L8;
        this.mNetworkLocationListener = new LocationInfoListener(this, "network");
        Logger.i("GpsInfoManager: requestSingleUpdate NETWORK_PROVIDER");
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, "network", this.mNetworkLocationListener, this.mHandler.getLooper(), r13);
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_NETWORK_LOCATION, Boolean.TRUE);
        return;
    L8:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 2) goto L11;
        this.mNetworkLocationListener = new LocationInfoListener(this, "network");
        this.mNetworkLocationListener.onLocationChanged(this.mBPEAManager.getLastKnownLocation(this.mLocationManager, "network", r13));
        Logger.i("addLocationListener: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " getLastKnownLocation NETWORK");
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_NETWORK_LOCATION, Boolean.TRUE);
    L11:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 1) goto L13;
    L16:
        this.mNetworkLocationListener = new LocationInfoListener(this, "network");
        Logger.i("GpsInfoManager: requestSingleUpdate NETWORK_PROVIDER");
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, "network", this.mNetworkLocationListener, this.mHandler.getLooper(), r13);
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_NETWORK_LOCATION, Boolean.TRUE);
        Logger.i("addLocationListener: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " requestSingleUpdate NETWORK");
        return;
    L13:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() == 3) goto L16;
        if (BDLocationConfig.getColdBootCollectGpsStrategy() == 4) goto L16;
    }

    private void executeLocationChangedFinish() {
        int r8 = this.mLocateNum.incrementAndGet();
        Logger.i("executeLocationChangedFinish num:" + r8);
        if (r8 != this.collectLocateNum) goto L6;
        removeLocationListener();
        this.mIsLocationInfoReady = true;
        callbackAndRemoveTimeOutTask();
        return;
    }

    private void gpsCollectMonitor() {
        if (this.hasMonitorGpsCollect.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Logger.i("mStartCollectClock:" + this.mStartCollectClock);
        if (this.mScanLocationInfo != null) goto L8;
        return;
    L8:
        long r11 = SystemClock.elapsedRealtime() - this.mStartCollectClock;
        List<Long> r8 = this.mScanLocationInfo.getGpsInfoReportClocks();
        List<BDGpsInfo> r10 = this.mScanLocationInfo.getGpsInfo();
        if (r10.isEmpty() == false) goto L12;
        return;
    L12:
        if (r8.isEmpty() == true) goto L14;
        long r12 = r8.get(0).longValue() - this.mStartCollectClock;
    L15:
        ArrayList r15 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator<BDGpsInfo> r14 = r10.iterator();
    L17:
        if (r14.hasNext() == false) goto L19;
        r15.add(Double.valueOf(r14.next().accuracy));
        goto L17
    L19:
        Iterator<Long> r16 = r8.iterator();
    L21:
        if (r16.hasNext() == false) goto L23;
        r13.add(Long.valueOf(r16.next().longValue() - this.mStartCollectClock));
        goto L21
    L23:
        LocationMonitor.gpsCollectMonitor(r12, r10.get(0).provider, this.mScanLocationInfo.isContinuousGps(), getContinuousGpsConfigCategory(), r11, this.mScanLocationInfo.getGpsInfo().size(), r15, r13);
        return;
    L14:
        r12 = r11;
        goto L15
    }

    private void markGpsFinishForSteal() {
        monitor-enter(this);
        this.mIsCollectGpsFinishedForSteal = true;     // Catch: Throwable -> L7
        notifyAll();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private BDGpsInfo recordGpsInfo(Location r8, int r10) {
        if (r8 != null) goto L6;
        Logger.i("GpsInfoManager: updateGPSInfo location is null");
        return null;
    L6:
        double r11 = r8.getLatitude();
        double r12 = r8.getLongitude();
        if (transformGCJ_02(r8) == true) goto L9;
        return null;
    L9:
        BDGpsInfo r13 = transformGpsInfo(r8, r10);
        r13.latitudeWgs84 = r11;
        r13.longitudeWgs84 = r12;
        this.mScanLocationInfo.addGpsInfo(r13);
        this.mScanLocationInfo.addGpsLocation(new BDLocation(r8, LocationInfoConst.SYSTEM));
        return r13;
    }

    @SuppressLint({"MissingPermission"})
    private void registerGnssCallback(Object r8) {
    L15:
        e = move-exception;
        Logger.e("GpsInfoManager: registerGnssCallback error:" + e);
        return;
    L3:
        if (BDLocationConfig.enableScanGnss() == true) goto L7;
        this.mIsGpsStatusReady = true;     // Catch: Exception -> L15
        Logger.i("GpsInfoManager: registerGnssCallback unable to ScanGnss");     // Catch: Exception -> L15
        return;
    L7:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L9;
        return;
    L9:
        if (this.mLocationManager == null) goto L20;
        Logger.i("GpsInfoManager: registerGnssCallback");     // Catch: Exception -> L15
        if (this.mGnssStatusCallback != null) goto L13;
        this.mGnssStatusCallback = new GnssStatusCallback(this, null);     // Catch: Exception -> L15
    L13:
        this.mBPEAManager.registerGnssStatusCallback(this.mLocationManager, this.mGnssStatusCallback, r8);     // Catch: Exception -> L15
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REGISTER_GNSS, Boolean.TRUE);     // Catch: Exception -> L15
        return;
    }

    @SuppressLint({"MissingPermission"})
    private void removeLocationListener() {
        this.mStartCollectClock = -1;     // Catch: Exception -> L16
        LocationManager r8 = this.mLocationManager;     // Catch: Exception -> L16
        if (r8 == null) goto L21;
        LocationInfoListener r10 = this.mGpsLocationListener;     // Catch: Exception -> L16
        if (r10 == null) goto L8;
        r8.removeUpdates(r10);     // Catch: Exception -> L16
        this.mGpsLocationListener = null;     // Catch: Exception -> L16
    L8:
        ContinuousGPSLocationInfoListener r11 = this.mContinuousGpsLocationListener;     // Catch: Exception -> L16
        if (r11 == null) goto L11;
        this.mLocationManager.removeUpdates(r11);     // Catch: Exception -> L16
        this.mContinuousGpsLocationListener = null;     // Catch: Exception -> L16
    L11:
        LocationInfoListener r12 = this.mNetworkLocationListener;     // Catch: Exception -> L16
        if (r12 == null) goto L14;
        this.mLocationManager.removeUpdates(r12);     // Catch: Exception -> L16
        this.mNetworkLocationListener = null;     // Catch: Exception -> L16
    L14:
        Logger.i("GpsInfoManager: removeLocationListener");     // Catch: Exception -> L16
        return;
    L21:
        return;
    L16:
        e = move-exception;
        Logger.e("GpsInfoManager: removeLocationListener error:" + e);
    }

    private void setLocationCollectConditions(LocationOption r8) {
        Logger.i("GpsInfoManager: setLocationCollectConditions enableCollectAMapLocationInBatterySavingMode:" + BDLocationConfig.enableCollectAMapLocationInBatterySavingMode() + "--locateMode:" + this.mOption.getMode());
        boolean r10 = PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"});
        if (BDLocationConfig.enableUseCoarseLocation() == false) goto L5;
        boolean r11 = PermissionManager.hasLocationPermissions(this.mContext);
    L7:
        if (BDLocationConfig.getCollectGpsType() == 2) goto L11;
        if (BDLocationConfig.getCollectGpsType() == 0) goto L11;
    L19:
        if (BDLocationConfig.getCollectGpsType() == 1) goto L23;
        if (BDLocationConfig.getCollectGpsType() == 0) goto L23;
    L31:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r8) == false) goto L34;
        Logger.i("GpsInfoManager.setLocationCollectConditions: skip system network location collect.");
    L34:
        if (BDLocationConfig.enableCollectGPSLocationInBatterySavingMode() == false) goto L36;
    L37:
        if (r10 == false) goto L41;
        Logger.i("enable collect gps location");
        this.enableCollectGPSLocation = true;
        this.collectLocateNum++;
        return;
    L41:
        return;
    L36:
        if (this.mOption.getMode() != 0) goto L37;
        return;
    L23:
        if (BDLocationConfig.enableCollectNetworkLocationInBatterySavingMode() == false) goto L25;
    L26:
        if (r11 == false) goto L31;
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r8) == true) goto L31;
        Logger.i("enable collect network location");
        this.enableCollectNetworkLocation = true;
        this.collectLocateNum++;
        goto L34
    L25:
        if (this.mOption.getMode() == 0) goto L31;
    L11:
        if (BDLocationConfig.getDisableCollectAMapLocationSource().contains(r8.getUploadSource()) == true) goto L19;
        if (BDLocationConfig.enableCollectAMapLocationInBatterySavingMode() == false) goto L15;
    L16:
        if (r11 == false) goto L19;
        Logger.i("enable collect amap location");
        this.enableCollectAMapLocation = true;
        this.collectLocateNum++;
        goto L19
    L15:
        if (this.mOption.getMode() == 0) goto L19;
    L5:
        r11 = r10;
        goto L7
    }

    private boolean transformGCJ_02(Location r8) {
        boolean r10 = LocationUtil.convertLocationToGCJ_O2(r8, LocationInfoConst.WGS_84);
        if (r10 == true) goto L5;
        Logger.i("GpsInfoManager: convertLocationToGCJ_O2 error");
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.CONVERT_LOCATION_TO_GCJ_O2_SUCCESS, Boolean.FALSE);
    L5:
        return r10;
    }

    private BDGpsInfo transformGpsInfo(Location r8, int r10) {
        BDGpsInfo r11 = new BDGpsInfo();
        r11.gpsMode = r10;
        r11.altitude = r8.getAltitude();
        r11.accuracy = r8.getAccuracy();
        r11.latitude = r8.getLatitude();
        r11.longitude = r8.getLongitude();
        r11.coordinateSystem = LocationInfoConst.GCJ_O2;
        r11.provider = r8.getProvider();
        Bundle r12 = r8.getExtras();
        if (r12 != null) goto L5;
    L7:
        r11.speed = r8.getSpeed();
        r11.orientation = r8.getBearing();
        r11.timestamp = System.currentTimeMillis();
        r11.callbackClock = SystemClock.elapsedRealtime();
        r11.realTimestamp = r8.getTime();
        r11.elapsedRealtimeNanos = r8.getElapsedRealtimeNanos();
        r11.elapsedRealtimeUncertaintyNanos = r8.getElapsedRealtimeUncertaintyNanos();
        r11.verticalAccuracyMeters = r8.getVerticalAccuracyMeters();
        r11.speedAccuracyMetersPerSecond = r8.getSpeedAccuracyMetersPerSecond();
        r11.bearingAccuracyDegrees = r8.getBearingAccuracyDegrees();
        if (r8.getExtras() != null) goto L10;
    L12:
        return r11;
    L10:
        if (r8.getExtras().isEmpty() == true) goto L12;
        r11.sysExtras = r8.getExtras().toString();
        goto L12
    L5:
        if (r12.getBoolean("QUICKGPS", false) == false) goto L7;
        Logger.i("GpsInfoManager: updateGPSInfo and provider is network");
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.QUICK_GPS, Boolean.TRUE);
        r11.provider = "network";
        goto L7
    }

    private void unregisterGnssCallback() {
    L8:
        e = move-exception;
        Logger.e("GpsInfoManager: unregisterGnssCallback error:" + e);
        return;
    L3:
        if (this.mLocationManager == null) goto L13;
        Logger.i("GpsInfoManager: unregisterGnssCallback");     // Catch: Exception -> L8
        GnssStatusCallback r8 = this.mGnssStatusCallback;     // Catch: Exception -> L8
        if (r8 == null) goto L14;
        this.mLocationManager.unregisterGnssStatusCallback(r8);     // Catch: Exception -> L8
        this.mGnssStatusCallback = null;     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    private void updateAMapLocation(BDLocation r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mScanLocationInfo == null) goto L8;
        this.mScanLocationInfo.setAMapLocation(r8);
        return;
    }

    private void updateNetworkLocation(Location r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mScanLocationInfo == null) goto L8;
        BDLocation r10 = new BDLocation(r8, LocationInfoConst.SYSTEM);
        r10.setLocationType(4);
        r10.setLocationMs(System.currentTimeMillis());
        BDLocation r11 = LocationUtil.convertLocation(r10);
        this.mScanLocationInfo.setSysLocation(r11);
        return;
    }

    private void updateSingleGpsLocation(Location r8) {
        this.mScanLocationInfo.cleanGpsInfo();
        this.mScanLocationInfo.cleanGpsLocation();
        if (recordGpsInfo(r8, 1) == null) goto L6;
        gpsCollectMonitor();
        return;
    }

    public String getContinuousGpsConfigCategory() {
        return BDLocationConfig.getCollectContinuousGPSInterval() + BdimCategoryConstants.SEPARATOR_COLON + BDLocationConfig.getCollectContinuousGPSDuration();
    }

    public BDScanLocationInfo getScanLocationInfo() {
        return this.mScanLocationInfo;
    }

    public boolean isCollectGpsFinishedForSteal() {
        return this.mIsCollectGpsFinishedForSteal;
    }

    public void startGpsCollect(GpsCollectCallback r8, LocationOption r10) {
        if (r8 != null) goto L5;
        Logger.i("GpsInfoManager: startGpsCollect and callback is null");
        return;
    L5:
        boolean r11 = true;
        if (r10 != null) goto L9;
        Logger.i("GpsInfoManager: startGpsCollect and option is null");
        r8.onFail(1);
        return;
    L9:
        this.mOption = r10;
        LocationExtraDataTraceLogger r12 = r10.getLocationExtraDataTraceLogger();
        this.mExtraDataTraceLogger = r12;
        LocationMonitor.locationExtraDataTracePutCategoryData(r12, LocationExtraDataTraceLogger.IS_ENABLE_GPS_SCAN, Boolean.valueOf(BDLocationConfig.isEnableGpsScan()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.GPS_SCAN_INTERVAL, Long.valueOf(BDLocationConfig.getGpsScanInterval()));
        LocationExtraDataTraceLogger r13 = this.mExtraDataTraceLogger;
        if (BDLocationConfig.getGpsScanInterval() <= 0) goto L12;
        boolean r14 = true;
    L13:
        LocationMonitor.locationExtraDataTracePutCategoryData(r13, LocationExtraDataTraceLogger.HAS_GPS_SCAN_INTERVAL, Boolean.valueOf(r14));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.IS_DOWNGRADE_LOCATION, Boolean.valueOf(this.mOption.isDownGradeLocation()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.IS_MOCK_ENABLE, Boolean.valueOf(BDLocationConfig.isMockEnable()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "enable_collect_gps_location_in_battery_saving_mode", Boolean.valueOf(BDLocationConfig.enableCollectGPSLocationInBatterySavingMode()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.ENABLE_COLLECT_NETWORK_LOCATION_IN_BATTERY_SAVING_MODE, Boolean.valueOf(BDLocationConfig.enableCollectNetworkLocationInBatterySavingMode()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.ENABLE_COLLECT_AMAP_LOCATION_IN_BATTERY_SAVING_MODE, Boolean.valueOf(BDLocationConfig.enableCollectAMapLocationInBatterySavingMode()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.LOCATE_MODE, Integer.valueOf(r10.getMode()));
        if (BDLocationConfig.isEnableGpsScan() == true) goto L16;
    L50:
        Logger.i("location-trace-core GpsInfoManager: startGpsCollect and gps scan is not enabled, enable: " + BDLocationConfig.isEnableGpsScan() + ", scan interval: " + BDLocationConfig.getGpsScanInterval());
        r8.onFail(1);
        return;
    L16:
        if (BDLocationConfig.getGpsScanInterval() <= 0) goto L50;
        if (this.mOption.isDownGradeLocation() == false) goto L23;
        Logger.i("location-trace-core GpsInfoManager: location is DownGrade Location");
        r8.onFail(1);
        return;
    L23:
        if (BDLocationConfig.isMockEnable() == false) goto L26;
        Logger.i("location-trace-core GpsInfoManager: mock location");
        r8.onFail(1);
        return;
    L26:
        String r15 = LocationUtil.allowUseLocation(true);
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.ALLOW_USE_LOCATION_CODE, r15);
        if ("1".equals(r15) == true) goto L31;
        Logger.i("location-trace-core GpsInfoManager: startGpsCollect and location is not allowed");
        r8.onFail(1);
        return;
    L31:
        if (BDLocationConfig.getByteLocationWhiteList().contains(r10.getUploadSource()) == true) goto L33;
    L36:
        this.mLocateNum = new AtomicInteger(0);
        this.mCallback = r8;
        this.mIsLocationInfoReady = false;
        this.mIsGpsStatusReady = false;
        this.enableGPSContinuousOverSingleLocate = checkEnableContinuousGps(r10);
        Logger.i("GpsInfoManager: startGpsCollect and enableGPSContinuousOverSingleLocate: " + this.enableGPSContinuousOverSingleLocate);
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.USE_CONTINUOUS_GPS, Boolean.valueOf(this.enableGPSContinuousOverSingleLocate));
        if (this.enableGPSContinuousOverSingleLocate == false) goto L39;
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "gps_continuous_conf", getContinuousGpsConfigCategory());
    L39:
        this.mScanLocationInfo = new BDScanLocationInfo(r10.getLocateId(), this.enableGPSContinuousOverSingleLocate);
        Object r16 = r10.getBpeaCert();
        registerGnssCallback(r16);
        addLocationListener(r16, r10);
        if (this.mTimeOutTask != null) goto L42;
        this.mTimeOutTask = new TimeOutTask(this, null);
    L42:
        StringBuilder r17 = new StringBuilder("location-trace-core GpsInfoManager: startGpsCollect and handler: ");
        if (this.mHandler != null) goto L46;
        r11 = false;
    L46:
        r17.append(r11);
        Logger.i(r17.toString());
        Handler r18 = this.mHandler;
        if (r18 == null) goto L52;
        r18.postDelayed(this.mTimeOutTask, BDLocationConfig.getGpsScanInterval());
        return;
    L52:
        return;
    L33:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 0) goto L36;
        Logger.i("location-trace-core startGpsCollect: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " COLD_BOOT_NOT_COLLECT");
        r8.onFail(1);
        return;
    L12:
        r14 = false;
        goto L13
    }

    public void stopGpsCollect() {
        Logger.i("GpsInfoManager: stopGpsCollect");
        removeLocationListener();
        unregisterGnssCallback();
    }
}
