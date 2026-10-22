package com.obric.cae.userAware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class LocationAwareInfoManager {
    private static final String TAG = "LocationAwareInfoManager";
    private static LocationAwareInfoManager sInstance;
    private final AtomicBoolean isSingleShot;
    private String mAllGeofenceEventsFileKey;
    private final AtomicBoolean mIsLocationRecording;
    private GnssSvAwareInfo mLastGnssSvInfo;
    private LocationAwareInfo mLastLocationInfo;
    private final LocationListener mLocationListener;
    private final LocationManager mLocationManager;
    private String mLocationScanFileKey;

    private LocationAwareInfoManager(Context r8) {
        this.isSingleShot = new AtomicBoolean(false);
        this.mIsLocationRecording = new AtomicBoolean(false);
        this.mLocationScanFileKey = "";
        this.mAllGeofenceEventsFileKey = "";
        this.mLocationListener = new h(this);
        this.mLocationManager = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);
    }

    public static /* synthetic */ void a(LocationAwareInfoManager r8, Location r10) {
        r8.lambda$new$0(r10);
    }

    public static synchronized LocationAwareInfoManager getInstance(Context r8) {
        monitor-enter(LocationAwareInfoManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new LocationAwareInfoManager(r8);     // Catch: Throwable -> L10
    L7:
        LocationAwareInfoManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(LocationAwareInfoManager.class);
        return r10;
    }

    private /* synthetic */ void lambda$new$0(Location r8) {
        if (this.isSingleShot.get() == false) goto L6;
        stopLocationScan();
        this.isSingleShot.set(false);
        return;
    }

    public GnssSvAwareInfo getLastGnssSvInfo() {
        return this.mLastGnssSvInfo;
    }

    public LocationAwareInfo getLastLocationInfo() {
        return this.mLastLocationInfo;
    }

    public void handleGnssSvUpdate(GnssStatus r14) {
        int r8 = r14.getSatelliteCount();
        if (r8 > 0) goto L5;
        return;
    L5:
        int[] r10 = new int[r8];
        float[] r11 = new float[r8];
        float[] r12 = new float[r8];
        float[] r13 = new float[r8];
        float[] r15 = new float[r8];
        int[] r16 = new int[r8];
        int[] r17 = new int[r8];
        boolean[] r18 = new boolean[r8];
        int r19 = 0;
    L6:
        if (r19 >= r8) goto L12;
        r10[r19] = r14.getSvid(r19);
        r11[r19] = r14.getCn0DbHz(r19);
        r12[r19] = r14.getElevationDegrees(r19);
        r13[r19] = r14.getAzimuthDegrees(r19);
        r15[r19] = r14.getCarrierFrequencyHz(r19);
        r16[r19] = r14.getConstellationType(r19);
        boolean r110 = r14.hasEphemerisData(r19);
        if (r14.hasAlmanacData(r19) == false) goto L10;
        int r111 = 2;
    L11:
        r17[r19] = (r110 ? 1 : 0) | r111;
        r18[r19] = r14.usedInFix(r19);
        r19 = r19 + 1;
        goto L6
    L10:
        r111 = 0;
        goto L11
    L12:
        GnssSvAwareInfo r112 = new GnssSvAwareInfo(r8, r10, r11, r12, r13, r15, r16, r17, r18);
        this.mLastGnssSvInfo = r112;
        UserAwareManager r20 = UserAwareManager.getInstance();
        if (r20 != null) goto L17;
        CommSenseLog.e(TAG, "handleGnssSvUpdate: userAwareManager is null");
        return;
    L17:
        if (r20.isRecording() == false) goto L19;
    L24:
        CommSenseLog.addTimeLog(r112.toString(), CommSenseLog.getRecordFile(this.mLocationScanFileKey));
    L25:
        r20.postHarLevel2Data(r112);
        r20.notifyInnerCallbacks(new o5.o(6), r112);
        return;
    L19:
        if (r20.isRecordingByCallback() == true) goto L24;
        if (r20.isHarLevel2DataRecording() == false) goto L25;
        if (AwareStateListener.isHarCollectLocal() == false) goto L25;
        goto L24
    }

    public synchronized void handleLocationUpdate(Location r8) {
        monitor-enter(this);
        LocationAwareInfo.Builder r10 = new LocationAwareInfo.Builder().setTimestamp(System.currentTimeMillis()).setProvider(r8.getProvider()).setLatitudeDegrees(r8.getLatitude()).setLongitudeDegrees(r8.getLongitude()).setHorizontalAccuracyMeters(r8.getAccuracy());     // Catch: Throwable -> L23
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r8.getProvider()) == false) goto L6;
        r10 = r10.setAltitudeMeters(r8.getAltitude()).setAltitudeAccuracyMeters(r8.getVerticalAccuracyMeters()).setSpeedMetersPerSecond(r8.getSpeed()).setSpeedAccuracyMetersPerSecond(r8.getSpeedAccuracyMetersPerSecond()).setBearingDegrees(r8.getBearing()).setBearingAccuracyDegrees(r8.getBearingAccuracyDegrees());     // Catch: Throwable -> L23
    L6:
        LocationAwareInfo r11 = r10.build();     // Catch: Throwable -> L23
        this.mLastLocationInfo = new LocationAwareInfo(r11);     // Catch: Throwable -> L23
        UserAwareManager r12 = UserAwareManager.getInstance();     // Catch: Throwable -> L23
        if (r12 != null) goto L12;
        CommSenseLog.e(TAG, "handleLocationUpdate: userAwareManager is null");     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L12:
        if (r12.isRecording() == false) goto L14;
    L19:
        CommSenseLog.addTimeLog(r11.toString(), CommSenseLog.getRecordFile(this.mLocationScanFileKey));     // Catch: Throwable -> L23
    L20:
        r12.postHarLevel2Data(r11);     // Catch: Throwable -> L23
        r12.notifyInnerCallbacks(new com.obric.cae.location.geofence.a(3), r11);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L14:
        if (r12.isRecordingByCallback() == true) goto L19;
        if (r12.isHarLevel2DataRecording() == false) goto L20;
        if (AwareStateListener.isHarCollectLocal() == false) goto L20;
    L23:
        th = move-exception;
        throw th;
    }

    public void recordGeofenceEventsFile(String r8, File r10) {
        this.mAllGeofenceEventsFileKey = r8;
        CommSenseLog.recordFileWithKey(r8, r10);
    }

    public void recordLocationFile(String r8, File r10) {
        this.mLocationScanFileKey = r8;
        CommSenseLog.recordFileWithKey(r8, r10);
    }

    public void resetLastLocationInfo() {
        this.mLastLocationInfo = null;
    }

    @SuppressLint({"NewApi"})
    public void startLocationScan(boolean r8) {
        String r10 = TAG;
        CommSenseLog.d(r10, "startLocationScan");
        this.isSingleShot.set(r8);
        if (this.mLocationManager != null) goto L7;
        CommSenseLog.e(r10, "fail to get mLocationManager");
        return;
    L7:
        if (this.mIsLocationRecording.get() == false) goto L10;
        CommSenseLog.e(r10, "already recording");
        return;
    L10:
        this.mIsLocationRecording.set(true);
        this.mLastLocationInfo = null;
        LocationUtil.getInstance().startLocationRequest("fused", this.mLocationListener);
    }

    public void stopLocationScan() {
        String r8 = TAG;
        CommSenseLog.d(r8, "stopLocationScan");
        if (this.mIsLocationRecording.get() == true) goto L6;
        CommSenseLog.e(r8, "not recording");
        return;
    L6:
        this.mIsLocationRecording.set(false);
        LocationUtil.getInstance().stopLocationRequest(this.mLocationListener);
    }
}
