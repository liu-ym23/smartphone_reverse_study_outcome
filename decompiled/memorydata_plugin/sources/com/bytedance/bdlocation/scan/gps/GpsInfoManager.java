package com.bytedance.bdlocation.scan.gps;

import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
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
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.trace.StackTraceRecorder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.message.ParameterizedMessage;

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
    static /* synthetic */ class AnonymousClass1 {
    }

    private class ContinuousGPSLocationInfoListener implements LocationListener {
        private final AtomicBoolean hasReportStealLocation;
        final /* synthetic */ GpsInfoManager this$0;

        private ContinuousGPSLocationInfoListener(GpsInfoManager r2) {
            this.this$0 = r2;
            this.hasReportStealLocation = new AtomicBoolean(false);
        }

        /* synthetic */ ContinuousGPSLocationInfoListener(GpsInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void reportLocateFinish() {
            if (GpsInfoManager.access$1100(this.this$0).getGpsInfo().isEmpty() == false) goto L5;
            Logger.i("ContinuousGPSLocationInfoListener: onLocationChanged location is null");
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.GPS_OR_NETWORK_LOCATION_IS_NULL, true);
        L6:
            GpsInfoManager.access$500(this.this$0);
            return;
        L5:
            GpsInfoManager.access$1200(this.this$0);
            goto L6
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r7) {
            if (r7 != null) goto L4;
            return;
        L4:
            Logger.i("ContinuousGPSLocationInfoListener: receive new location input, provider:" + r7.getProvider());
            GpsInfoManager.access$1000(this.this$0, r7, 2);
            List<Long> r8 = GpsInfoManager.access$1100(this.this$0).getGpsInfoReportClocks();
            if (r8.size() >= 2) goto L7;
        L9:
            Logger.i("ContinuousGPSLocationInfoListener: still need wait, but can steal.");
            if (this.hasReportStealLocation.compareAndSet(false, true) == false) goto L14;
            GpsInfoManager.access$600(this.this$0);
            return;
        L14:
            return;
        L7:
            if ((((Long) ZeusTransformUtils.preCheckCast(r8.get(r8.size() - 1), Long.class, "com.obric.memorydata.plugin")).longValue() - ((Long) ZeusTransformUtils.preCheckCast(r8.get(0), Long.class, "com.obric.memorydata.plugin")).longValue()) < BDLocationConfig.getCollectContinuousGPSDuration()) goto L9;
            Logger.i("ContinuousGPSLocationInfoListener: collect enough gps, report finish.");
            reportLocateFinish();
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r2) {
            Logger.i("ContinuousGPSLocationInfoListener: onProviderDisabled, provider:" + r2);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r2) {
            Logger.i("ContinuousGPSLocationInfoListener: onProviderEnabled, provider:" + r2);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
            Logger.i("ContinuousGPSLocationInfoListener: onStatusChanged, provider:" + r1);
        }
    }

    private class GnssStatusCallback extends GnssStatus.Callback {
        final /* synthetic */ GpsInfoManager this$0;

        private GnssStatusCallback(GpsInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ GnssStatusCallback(GpsInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r7) {
            if (GpsInfoManager.access$1100(this.this$0) == null) goto L18;
            if (r7 == null) goto L18;
            int r0 = r7.getSatelliteCount();
            ArrayList r1 = new ArrayList();
            int r2 = 0;
        L7:
            if (r2 >= r0) goto L15;
            BDSatelliteInfo r3 = new BDSatelliteInfo();     // Catch: ArrayIndexOutOfBoundsException -> L13
            r3.sVid = r7.getSvid(r2);     // Catch: ArrayIndexOutOfBoundsException -> L13
            r3.snr = r7.getCn0DbHz(r2);     // Catch: ArrayIndexOutOfBoundsException -> L13
            r3.azimuthDegrees = r7.getAzimuthDegrees(r2);     // Catch: ArrayIndexOutOfBoundsException -> L13
            r3.elevationDegrees = r7.getElevationDegrees(r2);     // Catch: ArrayIndexOutOfBoundsException -> L13
            r3.constellationType = r7.getConstellationType(r2);     // Catch: ArrayIndexOutOfBoundsException -> L13
            if (Build.VERSION.SDK_INT < 26) goto L11;
            r3.hasCarrierFrequencyHz = r7.hasCarrierFrequencyHz(r2);     // Catch: ArrayIndexOutOfBoundsException -> L13
            r3.carrierFrequencyHz = r7.getCarrierFrequencyHz(r2);     // Catch: ArrayIndexOutOfBoundsException -> L13
        L11:
            r3.usedInFix = r7.usedInFix(r2);     // Catch: ArrayIndexOutOfBoundsException -> L13
            r1.add(r3);     // Catch: ArrayIndexOutOfBoundsException -> L13
            r2 = r2 + 1;
        L13:
            e = move-exception;
            Logger.e("GnssStatusCallback: getSvid out of bounds at index " + r2 + ", count=" + r0, e);
        L15:
            BDGnssInfo r8 = new BDGnssInfo();
            r8.satelliteNum = r1.size();
            r8.satelliteInfos = r1;
            r8.timestamp = System.currentTimeMillis();
            r8.callbackClock = SystemClock.elapsedRealtime();
            GpsInfoManager.access$1100(this.this$0).addGnssInfo(r8);
            String r6 = "GnssStatusCallback: onSatelliteStatusChanged, maxSatelliteCount:" + r0;
        L16:
            Logger.i(r6);
            return;
        L18:
            r6 = "GpsStatusListener: mScanLocationInfo | gnssStatus is null";
            goto L16
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
    }

    private class GpsStatusListener implements GpsStatus.Listener {
        final /* synthetic */ GpsInfoManager this$0;

        private GpsStatusListener(GpsInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ GpsStatusListener(GpsInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int r7) {
            Logger.i("GpsStatusListener: onGpsStatusChanged");
            if (r7 != 1) goto L5;
            String r6 = "GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_STARTED";
        L31:
            Logger.i(r6);
            return;
        L5:
            if (r7 != 2) goto L7;
            Logger.i("GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_STOPPED");
            GpsInfoManager.access$1400(this.this$0);
            GpsInfoManager.access$1502(this.this$0, true);
            GpsInfoManager.access$1600(this.this$0);
            return;
        L7:
            if (r7 != 3) goto L9;
            Logger.i("GpsStatusListener: onGpsStatusChanged receive GPS_EVENT_FIRST_FIX");
            GpsInfoManager.access$1100(this.this$0).cleanGnssInfo();
            return;
        L9:
            if (r7 == 4) goto L12;
            return;
        L12:
            if (GpsInfoManager.access$1300(this.this$0) != null) goto L17;
            String r8 = "GpsStatusListener: location manager is null";
        L14:
            Logger.i(r8);
            return;
        L17:
            if (GpsInfoManager.access$1100(this.this$0) != null) goto L19;
            r8 = "GpsStatusListener: mScanLocationInfo is null";
            goto L14
        L19:
            GpsStatus r9 = GpsInfoManager.access$1300(this.this$0).getGpsStatus(null);
            if (r9 != null) goto L22;
            r8 = "GpsStatusListener: gpsStatus is null";
            goto L14
        L22:
            int r0 = r9.getMaxSatellites();
            int r1 = 0;
            ArrayList r2 = new ArrayList();
            Iterator<GpsSatellite> r10 = r9.getSatellites().iterator();
        L24:
            if (r10.hasNext() == false) goto L27;
            if (r1 >= r0) goto L27;
            GpsSatellite r3 = (GpsSatellite) ZeusTransformUtils.preCheckCast(r10.next(), GpsSatellite.class, "com.obric.memorydata.plugin");
            BDSatelliteInfo r4 = new BDSatelliteInfo();
            r4.snr = r3.getSnr();
            r4.azimuthDegrees = r3.getAzimuth();
            r4.elevationDegrees = r3.getElevation();
            r4.usedInFix = r3.usedInFix();
            r4.sVid = r3.getPrn();
            r2.add(r4);
            r1 = r1 + 1;
        L27:
            BDGnssInfo r11 = new BDGnssInfo();
            r11.satelliteNum = r0;
            r11.satelliteInfos = r2;
            r11.timestamp = System.currentTimeMillis();
            r11.callbackClock = SystemClock.elapsedRealtime();
            GpsInfoManager.access$1100(this.this$0).addGnssInfo(r11);
            r6 = "GpsStatusListener: onGpsStatusChanged GPS_EVENT_SATELLITE_STATUS, satellite count:" + r1;
            goto L31
        }
    }

    private class LocationInfoListener implements LocationListener, BDLocationCallback {
        private final String intentProvider;
        final /* synthetic */ GpsInfoManager this$0;

        public LocationInfoListener(GpsInfoManager r1, String r2) {
            this.this$0 = r1;
            this.intentProvider = r2;
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onError(BDLocationException r3) {
            Logger.i("LocationInfoListener: amap onError:" + r3.getDetailMessage());
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.AMAP_LOCATION_ERROR, true);
            GpsInfoManager.access$500(this.this$0);
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r6) {
            if (r6 != null) goto L8;
            Logger.i("GpsInfoManager: onLocationChanged location is null");
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.GPS_OR_NETWORK_LOCATION_IS_NULL, true);
            GpsInfoManager.access$500(this.this$0);
            if ("gps".equals(this.intentProvider) == false) goto L16;
            GpsInfoManager.access$600(this.this$0);
            return;
        L16:
            return;
        L8:
            String r2 = r6.getProvider();
            Logger.i("LocationInfoListener: onLocationChanged provider:" + r2);
            if ("gps".equals(r2) == false) goto L11;
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.GPS_LOCATION_CHANGED, true);
            GpsInfoManager.access$700(this.this$0, r6);
        L12:
            GpsInfoManager.access$500(this.this$0);
            if ("gps".equals(this.intentProvider) == false) goto L17;
            GpsInfoManager.access$600(this.this$0);
            return;
        L17:
            return;
        L11:
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.NETWORK_LOCATION_CHANGED, true);
            GpsInfoManager.access$800(this.this$0, r6);
            goto L12
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public void onLocationChanged(BDLocation r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            Logger.i("LocationInfoListener: amap onLocationChanged provider:" + r4.getProvider());
            LocationMonitor.locationExtraDataTracePutCategoryData(GpsInfoManager.access$400(this.this$0), LocationExtraDataTraceLogger.AMAP_LOCATION_CHANGED, true);
            GpsInfoManager.access$900(this.this$0, r4);
            GpsInfoManager.access$500(this.this$0);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r2) {
            Logger.i("LocationInfoListener: onProviderDisabled, provider:" + r2);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r2) {
            Logger.i("LocationInfoListener: onProviderEnabled, provider:" + r2);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String r1, int r2, Bundle r3) {
            Logger.i("LocationInfoListener: onStatusChanged, provider:" + r1);
        }
    }

    private class TimeOutTask implements Runnable {
        final /* synthetic */ GpsInfoManager this$0;

        private TimeOutTask(GpsInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ TimeOutTask(GpsInfoManager r1, AnonymousClass1 r2) {
            this(r1);
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
    }

    public GpsInfoManager() {
        this.mIsLocationInfoReady = false;
        this.mIsGpsStatusReady = false;
        this.mIsCollectGpsFinishedForSteal = false;
        this.mStartCollectClock = -1;
        this.collectLocateNum = 0;
        this.enableGPSContinuousOverSingleLocate = false;
        this.hasMonitorGpsCollect = new AtomicBoolean(false);
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.mContext = r0;
        if (r0 != null) goto L6;
        Logger.i("mContext is null" + Log.getStackTraceString(new Throwable()));
        LocationMonitor.uploadAllStackTraces("GpsInfoManager", LocationUtil.getStackTrace());
        LocationMonitor.uploadAllStackTraces("ColdBootManager", StackTraceRecorder.getColdBootStackTrace());
        return;
    L6:
        this.mLocationManager = (LocationManager) ZeusTransformUtils.preCheckCast(r0.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
        this.mHandler = new Handler(ThreadLooperManager.getLocationWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    static /* synthetic */ BDGpsInfo access$1000(GpsInfoManager r0, Location r1, int r2) {
        return r0.recordGpsInfo(r1, r2);
    }

    static /* synthetic */ BDScanLocationInfo access$1100(GpsInfoManager r0) {
        return r0.mScanLocationInfo;
    }

    static /* synthetic */ void access$1200(GpsInfoManager r0) {
        r0.gpsCollectMonitor();
    }

    static /* synthetic */ LocationManager access$1300(GpsInfoManager r0) {
        return r0.mLocationManager;
    }

    static /* synthetic */ void access$1400(GpsInfoManager r0) {
        r0.unregisterGnssCallback();
    }

    static /* synthetic */ boolean access$1502(GpsInfoManager r0, boolean r1) {
        r0.mIsGpsStatusReady = r1;
        return r1;
    }

    static /* synthetic */ void access$1600(GpsInfoManager r0) {
        r0.callbackAndRemoveTimeOutTask();
    }

    static /* synthetic */ boolean access$1700(GpsInfoManager r0) {
        return r0.enableGPSContinuousOverSingleLocate;
    }

    static /* synthetic */ void access$1800(GpsInfoManager r0) {
        r0.callbackGpsInfo();
    }

    static /* synthetic */ LocationExtraDataTraceLogger access$400(GpsInfoManager r0) {
        return r0.mExtraDataTraceLogger;
    }

    static /* synthetic */ void access$500(GpsInfoManager r0) {
        r0.executeLocationChangedFinish();
    }

    static /* synthetic */ void access$600(GpsInfoManager r0) {
        r0.markGpsFinishForSteal();
    }

    static /* synthetic */ void access$700(GpsInfoManager r0, Location r1) {
        r0.updateSingleGpsLocation(r1);
    }

    static /* synthetic */ void access$800(GpsInfoManager r0, Location r1) {
        r0.updateNetworkLocation(r1);
    }

    static /* synthetic */ void access$900(GpsInfoManager r0, BDLocation r1) {
        r0.updateAMapLocation(r1);
    }

    private void addLocationListener(Object r6, LocationOption r7) {
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
        Logger.i("GpsInfoManager: addLocationListener mStartCollectClock:" + this.mStartCollectClock + "-CollectGpsType:" + BDLocationConfig.getCollectGpsType() + "-DisableCollectAMapLocationSource:" + BDLocationConfig.getDisableCollectAMapLocationSource() + "-UploadSource:" + r7.getUploadSource());     // Catch: Exception -> L12
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "byte_location_libra_param", BDLocationConfig.getByteLocationLibraParam());     // Catch: Exception -> L12
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "collect_gps_type", Integer.valueOf(BDLocationConfig.getCollectGpsType()));     // Catch: Exception -> L12
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "disable_collect_amap_location_source", BDLocationConfig.getDisableCollectAMapLocationSource());     // Catch: Exception -> L12
        setLocationCollectConditions(r7);     // Catch: Exception -> L12
        collectGPSLocation(r7, r6);     // Catch: Exception -> L12
        if (LocationInfoConst.LIBRA_PARAM_V2.equals(BDLocationConfig.getByteLocationLibraParam()) == false) goto L18;
        collectNetworkLocation(r7, r6);     // Catch: Exception -> L12
        collectAMapLocation();     // Catch: Exception -> L12
        return;
    }

    private synchronized void callbackAndRemoveTimeOutTask() {
        monitor-enter(this);
        Logger.i("GpsInfoManager: mIsLocationInfoReady:" + this.mIsLocationInfoReady + ", mIsGpsStatusReady:" + this.mIsGpsStatusReady);     // Catch: Throwable -> L15
        if (this.mIsLocationInfoReady == true) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.mIsGpsStatusReady == false) goto L13;
        Logger.i("GpsInfoManager: callbackAndRemoveTimeOutTask");     // Catch: Throwable -> L15
        Handler r0 = this.mHandler;     // Catch: Throwable -> L15
        if (r0 == null) goto L12;
        TimeOutTask r1 = this.mTimeOutTask;     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        r0.removeCallbacks(r1);     // Catch: Throwable -> L15
    L12:
        callbackGpsInfo();     // Catch: Throwable -> L15
    L15:
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

    private boolean checkEnableContinuousGps(LocationOption r3) {
        if (BDLocationConfig.enableCollectContinuousGPSLocation() == true) goto L5;
        return false;
    L5:
        String r2 = BDLocationConfig.getCollectContinuousTokenBlacklist();
        if (r2 == null) goto L11;
        if (r2.contains(r3.getUploadSource()) == false) goto L11;
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
        ILocate r0 = BDLocationExtrasService.getNewAMapLocate();
    L9:
        if (r0 == null) goto L12;
        LocationOption r2 = new LocationOption();
        r2.setMode(2);
        r2.setMaxCacheTime(0);
        r2.setOnceLocation(true);
        r2.setLocationTimeOutMs(30000);
        r0.startLocation(new LocationInfoListener(this, "AMap"), r2, this.mHandler.getLooper());
        Logger.i("GpsInfoManager: startLocation aMap");
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_AMAP_LOCATION, true);
        return;
    L12:
        return;
    L8:
        r0 = BDLocationExtrasService.getLocate(this.mContext, 1);
        goto L9
    }

    private void collectGPSLocation(LocationOption r22, Object r23) {
        if (this.enableCollectGPSLocation == true) goto L6;
        markGpsFinishForSteal();
        return;
    L6:
        AnonymousClass1 r2 = null;
        if (BDLocationConfig.getByteLocationWhiteList().contains(r22.getUploadSource()) == false) goto L21;
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 1) goto L16;
        if (this.enableGPSContinuousOverSingleLocate == false) goto L13;
        this.mContinuousGpsLocationListener = new ContinuousGPSLocationInfoListener(this, r2);
        this.mBPEAManager.requestLocationUpdates(this.mLocationManager, "gps", BDLocationConfig.getCollectContinuousGPSInterval(), 0.0f, this.mContinuousGpsLocationListener, this.mHandler.getLooper(), r23);
    L14:
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_GPS_LOCATION, true);
        Logger.i("addLocationListener: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " requestSingleUpdate GPS");
        goto L16
    L13:
        LocationInfoListener r1 = new LocationInfoListener(this, "gps");
        this.mGpsLocationListener = r1;
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, "gps", r1, this.mHandler.getLooper(), r23);
    L16:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 2) goto L18;
    L19:
        this.mGpsLocationListener = new LocationInfoListener(this, "gps");
        this.mGpsLocationListener.onLocationChanged(this.mBPEAManager.getLastKnownLocation(this.mLocationManager, "gps", r23));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_GPS_LOCATION, true);
        Logger.i("addLocationListener: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " getLastKnownLocation GPS");
        return;
    L18:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() == 3) goto L19;
        return;
    L21:
        if (this.enableGPSContinuousOverSingleLocate == false) goto L23;
        this.mContinuousGpsLocationListener = new ContinuousGPSLocationInfoListener(this, r2);
        this.mBPEAManager.requestLocationUpdates(this.mLocationManager, "gps", BDLocationConfig.getCollectContinuousGPSInterval(), 0.0f, this.mContinuousGpsLocationListener, this.mHandler.getLooper(), r23);
    L24:
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_GPS_LOCATION, true);
        return;
    L23:
        LocationInfoListener r10 = new LocationInfoListener(this, "gps");
        this.mGpsLocationListener = r10;
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, "gps", r10, this.mHandler.getLooper(), r23);
        goto L24
    }

    private void collectNetworkLocation(LocationOption r13, Object r14) {
        if (this.enableCollectNetworkLocation == true) goto L6;
        return;
    L6:
        if (BDLocationConfig.getByteLocationWhiteList().contains(r13.getUploadSource()) == true) goto L8;
        this.mNetworkLocationListener = new LocationInfoListener(this, "network");
        Logger.i("GpsInfoManager: requestSingleUpdate NETWORK_PROVIDER");
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, "network", this.mNetworkLocationListener, this.mHandler.getLooper(), r14);
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_NETWORK_LOCATION, true);
        return;
    L8:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 2) goto L11;
        this.mNetworkLocationListener = new LocationInfoListener(this, "network");
        this.mNetworkLocationListener.onLocationChanged(this.mBPEAManager.getLastKnownLocation(this.mLocationManager, "network", r14));
        Logger.i("addLocationListener: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " getLastKnownLocation NETWORK");
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_NETWORK_LOCATION, true);
    L11:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 1) goto L13;
    L16:
        this.mNetworkLocationListener = new LocationInfoListener(this, "network");
        Logger.i("GpsInfoManager: requestSingleUpdate NETWORK_PROVIDER");
        this.mBPEAManager.requestSingleUpdate(this.mLocationManager, "network", this.mNetworkLocationListener, this.mHandler.getLooper(), r14);
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REQUEST_NETWORK_LOCATION, true);
        Logger.i("addLocationListener: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " requestSingleUpdate NETWORK");
        return;
    L13:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() == 3) goto L16;
        if (BDLocationConfig.getColdBootCollectGpsStrategy() == 4) goto L16;
    }

    private void executeLocationChangedFinish() {
        int r0 = this.mLocateNum.incrementAndGet();
        Logger.i("executeLocationChangedFinish num:" + r0);
        if (r0 != this.collectLocateNum) goto L6;
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
        long r12 = SystemClock.elapsedRealtime() - this.mStartCollectClock;
        List<Long> r1 = this.mScanLocationInfo.getGpsInfoReportClocks();
        List<BDGpsInfo> r3 = this.mScanLocationInfo.getGpsInfo();
        if (r3.isEmpty() == false) goto L12;
        return;
    L12:
        if (r1.isEmpty() == true) goto L14;
        long r7 = ((Long) ZeusTransformUtils.preCheckCast(r1.get(0), Long.class, "com.obric.memorydata.plugin")).longValue() - this.mStartCollectClock;
    L15:
        ArrayList r4 = new ArrayList();
        ArrayList r6 = new ArrayList();
        Iterator<BDGpsInfo> r9 = r3.iterator();
    L17:
        if (r9.hasNext() == false) goto L19;
        r4.add(Double.valueOf(((BDGpsInfo) ZeusTransformUtils.preCheckCast(r9.next(), BDGpsInfo.class, "com.obric.memorydata.plugin")).accuracy));
        goto L17
    L19:
        Iterator<Long> r2 = r1.iterator();
    L21:
        if (r2.hasNext() == false) goto L23;
        r6.add(Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")).longValue() - this.mStartCollectClock));
        goto L21
    L23:
        LocationMonitor.gpsCollectMonitor(r7, ((BDGpsInfo) ZeusTransformUtils.preCheckCast(r3.get(0), BDGpsInfo.class, "com.obric.memorydata.plugin")).provider, this.mScanLocationInfo.isContinuousGps(), getContinuousGpsConfigCategory(), r12, this.mScanLocationInfo.getGpsInfo().size(), r4, r6);
        return;
    L14:
        r7 = r12;
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

    private BDGpsInfo recordGpsInfo(Location r7, int r8) {
        if (r7 != null) goto L6;
        Logger.i("GpsInfoManager: updateGPSInfo location is null");
        return null;
    L6:
        double r1 = r7.getLatitude();
        double r3 = r7.getLongitude();
        if (transformGCJ_02(r7) == true) goto L9;
        return null;
    L9:
        BDGpsInfo r9 = transformGpsInfo(r7, r8);
        r9.latitudeWgs84 = r1;
        r9.longitudeWgs84 = r3;
        this.mScanLocationInfo.addGpsInfo(r9);
        this.mScanLocationInfo.addGpsLocation(new BDLocation(r7, LocationInfoConst.SYSTEM));
        return r9;
    }

    private void registerGnssCallback(Object r5) {
    L22:
        e = move-exception;
        Logger.e("GpsInfoManager: registerGnssCallback error:" + e);
        return;
    L3:
        if (BDLocationConfig.enableScanGnss() == true) goto L7;
        this.mIsGpsStatusReady = true;     // Catch: Exception -> L22
        Logger.i("GpsInfoManager: registerGnssCallback unable to ScanGnss");     // Catch: Exception -> L22
        return;
    L7:
        if (PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L9;
        return;
    L9:
        if (this.mLocationManager == null) goto L27;
        Logger.i("GpsInfoManager: registerGnssCallback");     // Catch: Exception -> L22
        AnonymousClass1 r3 = null;
        if (Build.VERSION.SDK_INT < 24) goto L17;
        if (this.mGnssStatusCallback != null) goto L15;
        this.mGnssStatusCallback = new GnssStatusCallback(this, r3);     // Catch: Exception -> L22
    L15:
        this.mBPEAManager.registerGnssStatusCallback(this.mLocationManager, this.mGnssStatusCallback, r5);     // Catch: Exception -> L22
    L20:
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.REGISTER_GNSS, true);     // Catch: Exception -> L22
        return;
    L17:
        if (this.mGpsStatusListener != null) goto L19;
        this.mGpsStatusListener = new GpsStatusListener(this, r3);     // Catch: Exception -> L22
    L19:
        this.mBPEAManager.addGpsStatusListener(this.mLocationManager, this.mGpsStatusListener, r5);     // Catch: Exception -> L22
        goto L20
    }

    private void removeLocationListener() {
        this.mStartCollectClock = -1;     // Catch: Exception -> L16
        LocationManager r0 = this.mLocationManager;     // Catch: Exception -> L16
        if (r0 == null) goto L21;
        LocationInfoListener r1 = this.mGpsLocationListener;     // Catch: Exception -> L16
        if (r1 == null) goto L8;
        r0.removeUpdates(r1);     // Catch: Exception -> L16
        this.mGpsLocationListener = null;     // Catch: Exception -> L16
    L8:
        ContinuousGPSLocationInfoListener r2 = this.mContinuousGpsLocationListener;     // Catch: Exception -> L16
        if (r2 == null) goto L11;
        this.mLocationManager.removeUpdates(r2);     // Catch: Exception -> L16
        this.mContinuousGpsLocationListener = null;     // Catch: Exception -> L16
    L11:
        LocationInfoListener r3 = this.mNetworkLocationListener;     // Catch: Exception -> L16
        if (r3 == null) goto L14;
        this.mLocationManager.removeUpdates(r3);     // Catch: Exception -> L16
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

    private void setLocationCollectConditions(LocationOption r6) {
        Logger.i("GpsInfoManager: setLocationCollectConditions enableCollectAMapLocationInBatterySavingMode:" + BDLocationConfig.enableCollectAMapLocationInBatterySavingMode() + "--locateMode:" + this.mOption.getMode());
        boolean r0 = PermissionManager.hasAnyPermission(new String[]{"android.permission.ACCESS_FINE_LOCATION"});
        if (BDLocationConfig.enableUseCoarseLocation() == false) goto L5;
        boolean r1 = PermissionManager.hasLocationPermissions(this.mContext);
    L7:
        if (BDLocationConfig.getCollectGpsType() == 2) goto L11;
        if (BDLocationConfig.getCollectGpsType() == 0) goto L11;
    L19:
        if (BDLocationConfig.getCollectGpsType() == 1) goto L23;
        if (BDLocationConfig.getCollectGpsType() == 0) goto L23;
    L31:
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r6) == false) goto L34;
        Logger.i("GpsInfoManager.setLocationCollectConditions: skip system network location collect.");
    L34:
        if (BDLocationConfig.enableCollectGPSLocationInBatterySavingMode() == false) goto L36;
    L37:
        if (r0 == false) goto L41;
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
        if (r1 == false) goto L31;
        if (BDLocationConfig.needRevertWifiOrStationInfoUpload(r6) == true) goto L31;
        Logger.i("enable collect network location");
        this.enableCollectNetworkLocation = true;
        this.collectLocateNum++;
        goto L34
    L25:
        if (this.mOption.getMode() == 0) goto L31;
    L11:
        if (BDLocationConfig.getDisableCollectAMapLocationSource().contains(r6.getUploadSource()) == true) goto L19;
        if (BDLocationConfig.enableCollectAMapLocationInBatterySavingMode() == false) goto L15;
    L16:
        if (r1 == false) goto L19;
        Logger.i("enable collect amap location");
        this.enableCollectAMapLocation = true;
        this.collectLocateNum++;
        goto L19
    L15:
        if (this.mOption.getMode() == 0) goto L19;
    L5:
        r1 = r0;
        goto L7
    }

    private boolean transformGCJ_02(Location r3) {
        boolean r4 = LocationUtil.convertLocationToGCJ_O2(r3, LocationInfoConst.WGS_84);
        if (r4 == true) goto L5;
        Logger.i("GpsInfoManager: convertLocationToGCJ_O2 error");
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.CONVERT_LOCATION_TO_GCJ_O2_SUCCESS, false);
    L5:
        return r4;
    }

    private BDGpsInfo transformGpsInfo(Location r4, int r5) {
        BDGpsInfo r0 = new BDGpsInfo();
        r0.gpsMode = r5;
        r0.altitude = r4.getAltitude();
        r0.accuracy = r4.getAccuracy();
        r0.latitude = r4.getLatitude();
        r0.longitude = r4.getLongitude();
        r0.coordinateSystem = LocationInfoConst.GCJ_O2;
        r0.provider = r4.getProvider();
        Bundle r6 = r4.getExtras();
        if (r6 != null) goto L5;
    L7:
        r0.speed = r4.getSpeed();
        r0.orientation = r4.getBearing();
        r0.timestamp = System.currentTimeMillis();
        r0.callbackClock = SystemClock.elapsedRealtime();
        r0.realTimestamp = r4.getTime();
        if (Build.VERSION.SDK_INT < 17) goto L11;
        r0.elapsedRealtimeNanos = r4.getElapsedRealtimeNanos();
    L11:
        if (Build.VERSION.SDK_INT < 29) goto L14;
        r0.elapsedRealtimeUncertaintyNanos = r4.getElapsedRealtimeUncertaintyNanos();
        r0.verticalAccuracyMeters = r4.getVerticalAccuracyMeters();
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        r0.speedAccuracyMetersPerSecond = r4.getSpeedAccuracyMetersPerSecond();
        r0.bearingAccuracyDegrees = r4.getBearingAccuracyDegrees();
    L17:
        if (r4.getExtras() != null) goto L19;
    L21:
        return r0;
    L19:
        if (r4.getExtras().isEmpty() == true) goto L21;
        r0.sysExtras = r4.getExtras().toString();
        goto L21
    L5:
        if (r6.getBoolean("QUICKGPS", false) == false) goto L7;
        Logger.i("GpsInfoManager: updateGPSInfo and provider is network");
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.QUICK_GPS, true);
        r0.provider = "network";
        goto L7
    }

    private void unregisterGnssCallback() {
    L13:
        e = move-exception;
        Logger.e("GpsInfoManager: unregisterGnssCallback error:" + e);
        return;
    L3:
        if (this.mLocationManager == null) goto L16;
        Logger.i("GpsInfoManager: unregisterGnssCallback");     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT < 24) goto L9;
        GnssStatusCallback r0 = this.mGnssStatusCallback;     // Catch: Exception -> L13
        if (r0 == null) goto L16;
        this.mLocationManager.unregisterGnssStatusCallback(r0);     // Catch: Exception -> L13
        this.mGnssStatusCallback = null;     // Catch: Exception -> L13
        goto L16
    L9:
        GpsStatusListener r1 = this.mGpsStatusListener;     // Catch: Exception -> L13
        if (r1 == null) goto L16;
        this.mLocationManager.removeGpsStatusListener(r1);     // Catch: Exception -> L13
        this.mGpsStatusListener = null;     // Catch: Exception -> L13
    L16:
    }

    private void updateAMapLocation(BDLocation r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mScanLocationInfo == null) goto L8;
        this.mScanLocationInfo.setAMapLocation(r2);
        return;
    }

    private void updateNetworkLocation(Location r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (this.mScanLocationInfo == null) goto L8;
        BDLocation r0 = new BDLocation(r4, LocationInfoConst.SYSTEM);
        r0.setLocationType(4);
        r0.setLocationMs(System.currentTimeMillis());
        BDLocation r5 = LocationUtil.convertLocation(r0);
        this.mScanLocationInfo.setSysLocation(r5);
        return;
    }

    private void updateSingleGpsLocation(Location r2) {
        this.mScanLocationInfo.cleanGpsInfo();
        this.mScanLocationInfo.cleanGpsLocation();
        if (recordGpsInfo(r2, 1) == null) goto L6;
        gpsCollectMonitor();
        return;
    }

    public String getContinuousGpsConfigCategory() {
        return BDLocationConfig.getCollectContinuousGPSInterval() + ParameterizedMessage.ERROR_MSG_SEPARATOR + BDLocationConfig.getCollectContinuousGPSDuration();
    }

    public BDScanLocationInfo getScanLocationInfo() {
        return this.mScanLocationInfo;
    }

    public boolean isCollectGpsFinishedForSteal() {
        return this.mIsCollectGpsFinishedForSteal;
    }

    public void startGpsCollect(GpsCollectCallback r8, LocationOption r9) {
        GpsCollectCallback r10 = (GpsCollectCallback) ZeusTransformUtils.wrapperContextForParams(r8, GpsCollectCallback.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L6;
        Logger.i("GpsInfoManager: startGpsCollect and callback is null");
        return;
    L6:
        boolean r0 = true;
        if (r9 != null) goto L10;
        Logger.i("GpsInfoManager: startGpsCollect and option is null");
        r10.onFail(1);
        return;
    L10:
        this.mOption = r9;
        LocationExtraDataTraceLogger r1 = r9.getLocationExtraDataTraceLogger();
        this.mExtraDataTraceLogger = r1;
        LocationMonitor.locationExtraDataTracePutCategoryData(r1, LocationExtraDataTraceLogger.IS_ENABLE_GPS_SCAN, Boolean.valueOf(BDLocationConfig.isEnableGpsScan()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.GPS_SCAN_INTERVAL, Long.valueOf(BDLocationConfig.getGpsScanInterval()));
        LocationExtraDataTraceLogger r2 = this.mExtraDataTraceLogger;
        if (BDLocationConfig.getGpsScanInterval() <= 0) goto L13;
        boolean r3 = true;
    L14:
        LocationMonitor.locationExtraDataTracePutCategoryData(r2, LocationExtraDataTraceLogger.HAS_GPS_SCAN_INTERVAL, Boolean.valueOf(r3));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.IS_DOWNGRADE_LOCATION, Boolean.valueOf(this.mOption.isDownGradeLocation()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.IS_MOCK_ENABLE, Boolean.valueOf(BDLocationConfig.isMockEnable()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "enable_collect_gps_location_in_battery_saving_mode", Boolean.valueOf(BDLocationConfig.enableCollectGPSLocationInBatterySavingMode()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.ENABLE_COLLECT_NETWORK_LOCATION_IN_BATTERY_SAVING_MODE, Boolean.valueOf(BDLocationConfig.enableCollectNetworkLocationInBatterySavingMode()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.ENABLE_COLLECT_AMAP_LOCATION_IN_BATTERY_SAVING_MODE, Boolean.valueOf(BDLocationConfig.enableCollectAMapLocationInBatterySavingMode()));
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.LOCATE_MODE, Integer.valueOf(r9.getMode()));
        if (BDLocationConfig.isEnableGpsScan() == true) goto L17;
    L51:
        Logger.i("location-trace-core GpsInfoManager: startGpsCollect and gps scan is not enabled, enable: " + BDLocationConfig.isEnableGpsScan() + ", scan interval: " + BDLocationConfig.getGpsScanInterval());
        r10.onFail(1);
        return;
    L17:
        if (BDLocationConfig.getGpsScanInterval() <= 0) goto L51;
        if (this.mOption.isDownGradeLocation() == false) goto L24;
        Logger.i("location-trace-core GpsInfoManager: location is DownGrade Location");
        r10.onFail(1);
        return;
    L24:
        if (BDLocationConfig.isMockEnable() == false) goto L27;
        Logger.i("location-trace-core GpsInfoManager: mock location");
        r10.onFail(1);
        return;
    L27:
        String r4 = LocationUtil.allowUseLocation(true);
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.ALLOW_USE_LOCATION_CODE, r4);
        if ("1".equals(r4) == true) goto L32;
        Logger.i("location-trace-core GpsInfoManager: startGpsCollect and location is not allowed");
        r10.onFail(1);
        return;
    L32:
        if (BDLocationConfig.getByteLocationWhiteList().contains(r9.getUploadSource()) == true) goto L34;
    L37:
        this.mLocateNum = new AtomicInteger(0);
        this.mCallback = r10;
        this.mIsLocationInfoReady = false;
        this.mIsGpsStatusReady = false;
        this.enableGPSContinuousOverSingleLocate = checkEnableContinuousGps(r9);
        Logger.i("GpsInfoManager: startGpsCollect and enableGPSContinuousOverSingleLocate: " + this.enableGPSContinuousOverSingleLocate);
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, LocationExtraDataTraceLogger.USE_CONTINUOUS_GPS, Boolean.valueOf(this.enableGPSContinuousOverSingleLocate));
        if (this.enableGPSContinuousOverSingleLocate == false) goto L40;
        LocationMonitor.locationExtraDataTracePutCategoryData(this.mExtraDataTraceLogger, "gps_continuous_conf", getContinuousGpsConfigCategory());
    L40:
        this.mScanLocationInfo = new BDScanLocationInfo(r9.getLocateId(), this.enableGPSContinuousOverSingleLocate);
        Object r11 = r9.getBpeaCert();
        registerGnssCallback(r11);
        addLocationListener(r11, r9);
        if (this.mTimeOutTask != null) goto L43;
        this.mTimeOutTask = new TimeOutTask(this, null);
    L43:
        StringBuilder r12 = new StringBuilder().append("location-trace-core GpsInfoManager: startGpsCollect and handler: ");
        if (this.mHandler != null) goto L47;
        r0 = false;
    L47:
        Logger.i(r12.append(r0).toString());
        Handler r13 = this.mHandler;
        if (r13 == null) goto L53;
        r13.postDelayed(this.mTimeOutTask, BDLocationConfig.getGpsScanInterval());
        return;
    L53:
        return;
    L34:
        if (BDLocationConfig.getColdBootCollectGpsStrategy() != 0) goto L37;
        Logger.i("location-trace-core startGpsCollect: ColdBootCollectGpsStrategy == " + BDLocationConfig.getColdBootCollectGpsStrategy() + " COLD_BOOT_NOT_COLLECT");
        r10.onFail(1);
        return;
    L13:
        r3 = false;
        goto L14
    }

    public void stopGpsCollect() {
        Logger.i("GpsInfoManager: stopGpsCollect");
        removeLocationListener();
        unregisterGnssCallback();
    }
}
