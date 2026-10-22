package com.obric.cae.userAware;

import android.content.Context;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.location.util.d;
import com.obric.cae.log.a;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
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

    private LocationAwareInfoManager(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.isSingleShot = new AtomicBoolean(false);
        this.mIsLocationRecording = new AtomicBoolean(false);
        this.mLocationScanFileKey = "";
        this.mAllGeofenceEventsFileKey = "";
        this.mLocationListener = new $$Lambda$LocationAwareInfoManager$9fFWvv7hN6wDi9QBpNBdyDY4sa4(this);
        this.mLocationManager = (LocationManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
    }

    public static synchronized LocationAwareInfoManager getInstance(Context r3) {
        monitor-enter(LocationAwareInfoManager.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (sInstance != null) goto L7;
        sInstance = new LocationAwareInfoManager(r4);     // Catch: Throwable -> L10
    L7:
        LocationAwareInfoManager r5 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(LocationAwareInfoManager.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public GnssSvAwareInfo getLastGnssSvInfo() {
        return this.mLastGnssSvInfo;
    }

    public LocationAwareInfo getLastLocationInfo() {
        return this.mLastLocationInfo;
    }

    public void handleGnssSvUpdate(GnssStatus r14) {
        int r1 = r14.getSatelliteCount();
        if (r1 > 0) goto L5;
        return;
    L5:
        int[] r2 = new int[r1];
        float[] r3 = new float[r1];
        float[] r4 = new float[r1];
        float[] r5 = new float[r1];
        float[] r6 = new float[r1];
        int[] r7 = new int[r1];
        int[] r8 = new int[r1];
        boolean[] r9 = new boolean[r1];
        int r10 = 0;
    L6:
        if (r10 >= r1) goto L12;
        r2[r10] = r14.getSvid(r10);
        r3[r10] = r14.getCn0DbHz(r10);
        r4[r10] = r14.getElevationDegrees(r10);
        r5[r10] = r14.getAzimuthDegrees(r10);
        r6[r10] = r14.getCarrierFrequencyHz(r10);
        r7[r10] = r14.getConstellationType(r10);
        boolean r11 = r14.hasEphemerisData(r10);
        if (r14.hasAlmanacData(r10) == false) goto L10;
        int r12 = 2;
    L11:
        r8[r10] = (r11 ? 1 : 0) | r12;
        r9[r10] = r14.usedInFix(r10);
        r10 = r10 + 1;
        goto L6
    L10:
        r12 = 0;
        goto L11
    L12:
        GnssSvAwareInfo r15 = new GnssSvAwareInfo(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        this.mLastGnssSvInfo = r15;
        UserAwareManager r0 = UserAwareManager.getInstance();
        if (r0 != null) goto L17;
        a.i(TAG, "handleGnssSvUpdate: userAwareManager is null");
        return;
    L17:
        if (r0.isRecording() == false) goto L19;
    L24:
        a.b(r15.toString(), a.b(this.mLocationScanFileKey));
    L25:
        r0.postHarLevel2Data(r15);
        r0.notifyInnerCallbacks($$Lambda$8rV82p7tbZvCsWDdxDuDAs6AqTs.INSTANCE, r15);
        return;
    L19:
        if (r0.isRecordingByCallback() == true) goto L24;
        if (r0.isHarLevel2DataRecording() == false) goto L25;
        if (AwareStateListener.isHarCollectLocal() == false) goto L25;
        goto L24
    }

    public synchronized void handleLocationUpdate(Location r6) {
        monitor-enter(this);
        if (r6 != null) goto L8;
        a.i(TAG, "handleLocationUpdate: location is null");     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L8:
        if (d.a().a(r6.getLatitude(), r6.getLongitude()) == true) goto L12;
        a.i(TAG, "handleLocationUpdate: invalid coordinate");     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L12:
        LocationAwareInfo.a r0 = new LocationAwareInfo.a().a(System.currentTimeMillis()).a(r6.getProvider()).a(r6.getLatitude()).b(r6.getLongitude()).a(r6.getAccuracy());     // Catch: Throwable -> L32
        if ("gps".equals(r6.getProvider()) == false) goto L15;
        r0 = r0.c(r6.getAltitude()).b(r6.getVerticalAccuracyMeters()).c(r6.getSpeed()).d(r6.getSpeedAccuracyMetersPerSecond()).e(r6.getBearing()).f(r6.getBearingAccuracyDegrees());     // Catch: Throwable -> L32
    L15:
        LocationAwareInfo r7 = r0.a();     // Catch: Throwable -> L32
        this.mLastLocationInfo = new LocationAwareInfo(r7);     // Catch: Throwable -> L32
        UserAwareManager r1 = UserAwareManager.getInstance();     // Catch: Throwable -> L32
        if (r1 != null) goto L21;
        a.i(TAG, "handleLocationUpdate: userAwareManager is null");     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L21:
        if (r1.isRecording() == false) goto L23;
    L28:
        a.b(r7.toString(), a.b(this.mLocationScanFileKey));     // Catch: Throwable -> L32
    L29:
        r1.postHarLevel2Data(r7);     // Catch: Throwable -> L32
        r1.notifyInnerCallbacks($$Lambda$5dIgjisyVfxXEwSZe7pCGCBuv6I.INSTANCE, r7);     // Catch: Throwable -> L32
        monitor-exit(this);
        return;
    L23:
        if (r1.isRecordingByCallback() == true) goto L28;
        if (r1.isHarLevel2DataRecording() == false) goto L29;
        if (AwareStateListener.isHarCollectLocal() == false) goto L29;
    L32:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ void lambda$new$0$LocationAwareInfoManager(Location r1) {
        if (this.isSingleShot.get() == false) goto L6;
        stopLocationScan();
        this.isSingleShot.set(false);
        return;
    }

    public void recordGeofenceEventsFile(String r1, File r2) {
        this.mAllGeofenceEventsFileKey = r1;
        a.a(r1, r2);
    }

    public void recordLocationFile(String r1, File r2) {
        this.mLocationScanFileKey = r1;
        a.a(r1, r2);
    }

    public void resetLastLocationInfo() {
        this.mLastLocationInfo = null;
    }

    public void startLocationScan(boolean r3) {
        String r0 = TAG;
        a.c(r0, "startLocationScan");
        this.isSingleShot.set(r3);
        if (this.mLocationManager != null) goto L7;
        a.i(r0, "fail to get mLocationManager");
        return;
    L7:
        if (this.mIsLocationRecording.get() == false) goto L10;
        a.i(r0, "already recording");
        return;
    L10:
        this.mIsLocationRecording.set(true);
        this.mLastLocationInfo = null;
        d.a().a("fused", this.mLocationListener);
    }

    public void stopLocationScan() {
        String r0 = TAG;
        a.c(r0, "stopLocationScan");
        if (this.mIsLocationRecording.get() == true) goto L6;
        a.i(r0, "not recording");
        return;
    L6:
        this.mIsLocationRecording.set(false);
        d.a().a(this.mLocationListener);
    }
}
