package com.obric.cae.connectivity;

import android.content.Context;
import android.location.GnssMeasurement;
import android.location.GnssMeasurementsEvent;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.log.CaeLog;
import com.obric.cae.utils.CaeUtil;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class CaeGnssInfoReport implements IAoiDataCollector {
    private static final int CONNECTIVITY_EVENT_FEATURE_ID = 143;
    private static final long GNSS_COLLECT_WINDOW_MS = 8000;
    private static final float LOCATION_MIN_DISTANCE_M = 0.0f;
    private static final long LOCATION_MIN_TIME_MS = 1000;
    private static final int MAX_MEASUREMENT_COUNT = 200;
    private static final String TAG = "CaeGnssInfoReport";
    private static CaeGnssInfoReport sInstance;
    private ExecutorService mCallbackExecutor;
    private Context mContext;
    private String mCurrentPoiName;
    private final GnssMeasurementsEvent.Callback mGnssMeasurementsCallback;
    private final GnssStatus.Callback mGnssStatusCallback;
    private final Handler mHandler;
    private boolean mIsCollecting;
    private GnssStatus mLatestGnssStatus;
    private float mLatestHdop;
    private Location mLatestLocation;
    private final List<GnssMeasurement> mLatestMeasurements;
    private float mLatestPdop;
    private float mLatestVdop;
    private final LocationListener mLocationListener;
    private LocationManager mLocationManager;
    private final OnNmeaMessageListener mNmeaListener;
    private final Runnable mReportRunnable;
    private long mTriggerTime;

    public CaeGnssInfoReport() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mIsCollecting = false;
        this.mCurrentPoiName = "";
        this.mTriggerTime = 0;
        this.mLatestMeasurements = new ArrayList();
        this.mLatestPdop = -1.0f;
        this.mLatestHdop = -1.0f;
        this.mLatestVdop = -1.0f;
        this.mReportRunnable = new AnonymousClass1(this);
        this.mLocationListener = new AnonymousClass2(this);
        this.mGnssStatusCallback = new AnonymousClass3(this);
        this.mGnssMeasurementsCallback = new AnonymousClass4(this);
        this.mNmeaListener = new AnonymousClass5(this);
    }

    public static /* synthetic */ void access$000(CaeGnssInfoReport r8) {
        r8.finishAndReport();
    }

    public static /* synthetic */ boolean access$100(CaeGnssInfoReport r8) {
        return r8.mIsCollecting;
    }

    public static /* synthetic */ Location access$202(CaeGnssInfoReport r8, Location r10) {
        r8.mLatestLocation = r10;
        return r10;
    }

    public static /* synthetic */ GnssStatus access$302(CaeGnssInfoReport r8, GnssStatus r10) {
        r8.mLatestGnssStatus = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(CaeGnssInfoReport r8) {
        return r8.mLatestMeasurements;
    }

    public static /* synthetic */ void access$500(CaeGnssInfoReport r8, String r10) {
        r8.parseGsaForDop(r10);
    }

    private GpsLocationSummaryReport buildLocationSummary(Location r11, GnssStatus r12, float r13, float r14, float r15) {
        if (r11 != null) goto L8;
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.getSatelliteCount() != 0) goto L8;
        return null;
    L8:
        GpsLocationSummaryReport.Builder r10 = GpsLocationSummaryReport.newBuilder();
        if (r11 == null) goto L23;
        r10.setLatitude(r11.getLatitude()).setLongitude(r11.getLongitude()).setAltitude(r11.getAltitude()).setAccuracy(r11.getAccuracy()).setSpeed(r11.getSpeed()).setBearing(r11.getBearing()).setLocationTime(r11.getTime());
        if (TextUtils.isEmpty(r11.getProvider()) == true) goto L14;
        r10.setProvider(r11.getProvider());
    L14:
        if (r11.hasVerticalAccuracy() == false) goto L17;
        r10.setVerticalAccuracy(r11.getVerticalAccuracyMeters());
    L17:
        if (r11.hasSpeedAccuracy() == false) goto L20;
        r10.setSpeedAccuracy(r11.getSpeedAccuracyMetersPerSecond());
    L20:
        if (r11.hasBearingAccuracy() == false) goto L23;
        r10.setBearingAccuracy(r11.getBearingAccuracyDegrees());
    L23:
        if (r12 == null) goto L49;
        if (r12.getSatelliteCount() <= 0) goto L49;
        int r8 = r12.getSatelliteCount();
        int r16 = 0;
        float r17 = 0.0f;
        float r18 = 0.0f;
        int r19 = 0;
        int r20 = 0;
        boolean r21 = false;
        boolean r22 = false;
    L27:
        if (r16 >= r8) goto L43;
        if (r12.usedInFix(r16) == false) goto L32;
        r19 = r19 + 1;
    L32:
        if (r12.hasEphemerisData(r16) == false) goto L35;
        r21 = true;
    L35:
        if (r12.hasAlmanacData(r16) == false) goto L37;
        r22 = true;
    L37:
        float r23 = r12.getCn0DbHz(r16);
        if (r23 <= LOCATION_MIN_DISTANCE_M) goto L42;
        r18 = r18 + r23;
        r20 = r20 + 1;
        if (r23 <= r17) goto L42;
        r17 = r23;
    L42:
        r16 = r16 + 1;
        goto L27
    L43:
        GpsLocationSummaryReport.Builder r110 = r10.setSatelliteCount(r8).setUsedInFixCount(r19).setMaxCn0Dbhz(r17);
        if (r20 <= 0) goto L46;
        float r24 = r18 / r20;
    L47:
        r110.setAvgCn0Dbhz(r24).setHasEphemeris(r21).setHasAlmanac(r22);
        goto L49
    L46:
        r24 = 0.0f;
    L49:
        if (r13 < LOCATION_MIN_DISTANCE_M) goto L52;
        r10.setPdop(r13);
    L52:
        if (r14 < LOCATION_MIN_DISTANCE_M) goto L55;
        r10.setHdop(r14);
    L55:
        if (r15 < LOCATION_MIN_DISTANCE_M) goto L58;
        r10.setVdop(r15);
    L58:
        return r10.build();
    }

    private GpsMeasurementReport buildMeasurementReport(GnssMeasurement r8, GnssStatus r10, Map<Long, int[]> r11) {
        if (r8 != null) goto L5;
        return null;
    L5:
        GpsMeasurementReport.Builder r12 = GpsMeasurementReport.newBuilder().setSvid(r8.getSvid()).setConstellationType(r8.getConstellationType()).setCn0Dbhz(r8.getCn0DbHz()).setAccumulatedDeltaRangeMeters(r8.getAccumulatedDeltaRangeMeters()).setAccumulatedDeltaRangeUncertaintyMeters(r8.getAccumulatedDeltaRangeUncertaintyMeters()).setAccumulatedDeltaRangeState(r8.getAccumulatedDeltaRangeState()).setReceivedSvTimeNanos(r8.getReceivedSvTimeNanos()).setReceivedSvTimeUncertaintyNanos(r8.getReceivedSvTimeUncertaintyNanos()).setTimeOffsetNanos(r8.getTimeOffsetNanos()).setState(r8.getState()).setMultipathIndicator(r8.getMultipathIndicator());
        if (r8.hasCarrierFrequencyHz() == false) goto L9;
        r12.setCarrierFrequencyHz(r8.getCarrierFrequencyHz());
    L9:
        if (r8.hasBasebandCn0DbHz() == false) goto L11;
        r12.setBasebandCn0Dbhz(r8.getBasebandCn0DbHz());
    L11:
        int[] r13 = findStatusEntry(r8, r10, r11);
        if (r13 == null) goto L16;
        if (r10 == null) goto L16;
        int r14 = r13[0];
        r12.setElevationDegrees(r10.getElevationDegrees(r14)).setAzimuthDegrees(r10.getAzimuthDegrees(r14)).setUsedInFix(r10.usedInFix(r14));
    L16:
        return r12.build();
    }

    private Map<Long, int[]> buildStatusIndexMap(GnssStatus r8) {
        HashMap r10 = new HashMap();
        if (r8 != null) goto L5;
        return r10;
    L5:
        int r11 = 0;
    L7:
        if (r11 >= r8.getSatelliteCount()) goto L9;
        r10.put(Long.valueOf(statusKey(r8.getConstellationType(r11), r8.getSvid(r11))), new int[]{r11});
        r11 = r11 + 1;
        goto L7
    L9:
        return r10;
    }

    private Executor ensureExecutor() {
        ExecutorService r8 = this.mCallbackExecutor;
        if (r8 != null) goto L5;
    L6:
        this.mCallbackExecutor = Executors.newSingleThreadExecutor();
    L8:
        return this.mCallbackExecutor;
    L5:
        if (r8.isShutdown() == false) goto L8;
        goto L6
    }

    private int[] findStatusEntry(GnssMeasurement r8, GnssStatus r10, Map<Long, int[]> r11) {
        if (r8 == null) goto L8;
        if (r10 == null) goto L10;
        if (r11 != null) goto L7;
        return null;
    L7:
        return r11.get(Long.valueOf(statusKey(r8.getConstellationType(), r8.getSvid())));
    L10:
        return null;
    L8:
        return null;
    }

    private void finishAndReport() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsCollecting == false) goto L6;
    L13:
        unregisterLocked();     // Catch: Throwable -> L17
        Location r8 = this.mLatestLocation;     // Catch: Throwable -> L17
        GnssStatus r10 = this.mLatestGnssStatus;     // Catch: Throwable -> L17
        ArrayList r11 = new ArrayList(this.mLatestMeasurements);     // Catch: Throwable -> L17
        float r12 = this.mLatestPdop;     // Catch: Throwable -> L17
        float r13 = this.mLatestHdop;     // Catch: Throwable -> L17
        float r14 = this.mLatestVdop;     // Catch: Throwable -> L17
        this.mLatestLocation = null;     // Catch: Throwable -> L17
        this.mLatestGnssStatus = null;     // Catch: Throwable -> L17
        this.mLatestMeasurements.clear();     // Catch: Throwable -> L17
        this.mLatestPdop = -1.0f;     // Catch: Throwable -> L17
        this.mLatestHdop = -1.0f;     // Catch: Throwable -> L17
        this.mLatestVdop = -1.0f;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        reportGnssData(r8, r10, r11, r12, r13, r14);
        return;
    L6:
        if (this.mLatestLocation != null) goto L13;
        if (this.mLatestGnssStatus != null) goto L13;
        if (this.mLatestMeasurements.isEmpty() == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L17
    }

    public static synchronized CaeGnssInfoReport getInstance() {
        monitor-enter(CaeGnssInfoReport.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new CaeGnssInfoReport();     // Catch: Throwable -> L10
    L7:
        CaeGnssInfoReport r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(CaeGnssInfoReport.class);
        return r8;
    }

    private boolean hasLocationPermission() {
        if (hasPermission("android.permission.ACCESS_FINE_LOCATION") == false) goto L5;
    L8:
        return true;
    L5:
        if (hasPermission("android.permission.ACCESS_COARSE_LOCATION") == true) goto L8;
        return false;
    }

    private boolean hasPermission(String r8) {
        Context r10 = this.mContext;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.checkSelfPermission(r8) != 0) goto L7;
        return true;
    }

    private float parseFloatSafely(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L8;
        return -1.0f;
    L8:
        return Float.parseFloat(r8.trim());
    L7:
        return -1.0f;
    }

    private void parseGsaForDop(String r8) {
        if (r8.indexOf("GSA") >= 0) goto L5;
        return;
    L5:
        int r10 = r8.indexOf(42);
        if (r10 < 0) goto L8;
        r8 = r8.substring(0, r10);
    L8:
        String[] r11 = r8.split(",", -1);
        if (r11.length >= 3) goto L11;
        return;
    L11:
        float r12 = parseFloatSafely(r11[r11.length - 3]);
        float r13 = parseFloatSafely(r11[r11.length - 2]);
        float r14 = parseFloatSafely(r11[r11.length - 1]);
        if (r12 < LOCATION_MIN_DISTANCE_M) goto L15;
        this.mLatestPdop = r12;
    L15:
        if (r13 < LOCATION_MIN_DISTANCE_M) goto L18;
        this.mLatestHdop = r13;
    L18:
        if (r14 < LOCATION_MIN_DISTANCE_M) goto L21;
        this.mLatestVdop = r14;
        return;
    }

    private void reportGnssData(Location r17, GnssStatus r18, List<GnssMeasurement> r19, float r20, float r21, float r22) {
        if (r17 == null) goto L5;
        boolean r10 = true;
    L6:
        if (r18 != null) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r19 != null) goto L13;
    L15:
        boolean r12 = false;
    L17:
        if (r10 == true) goto L23;
        if (r11 == true) goto L23;
        if (r12 == true) goto L23;
        CaeLog.i(TAG, "No GNSS data to report.");
        return;
    L23:
        if (this.mContext != null) goto L50;
        CaeLog.e(TAG, "Cannot report GNSS data: context is null.");
        return;
    L50:
        long r13 = System.currentTimeMillis();     // Catch: Exception -> L47
        CaeConnectivityDataProto.Builder r15 = CaeConnectivityDataProto.newBuilder();     // Catch: Exception -> L47
        CaeConnectivityProtoData.Builder r8 = CaeConnectivityProtoData.newBuilder();     // Catch: Exception -> L47
        long r14 = this.mTriggerTime;     // Catch: Exception -> L47
        if (r14 > 0) goto L30;
        r14 = r13;
    L30:
        CaeConnectivityProtoData.Builder r16 = r8.setDeviceTime(r14).setName(this.mCurrentPoiName);     // Catch: Exception -> L47
        GpsLocationSummaryReport r23 = buildLocationSummary(r17, r18, r20, r21, r22);     // Catch: Exception -> L47
        if (r23 == null) goto L33;
        r16.setGpsLocationSummaryReport(r23);     // Catch: Exception -> L47
    L33:
        if (r12 == false) goto L40;
        Map<Long, int[]> r24 = buildStatusIndexMap(r18);     // Catch: Exception -> L47
        Iterator<GnssMeasurement> r25 = r19.iterator();     // Catch: Exception -> L47
        int r26 = 0;
    L36:
        if (r25.hasNext() == false) goto L41;
        GpsMeasurementReport r27 = buildMeasurementReport(r25.next(), r18, r24);     // Catch: Exception -> L47
        if (r27 == null) goto L36;
        r16.addGpsMeasurementReport(r27);     // Catch: Exception -> L47
        r26 = r26 + 1;     // Catch: Exception -> L47
    L41:
        r15.addCaeConnectivityProto(r16);     // Catch: Exception -> L47
        CaeUtil.writePbEventSafely(r13, CONNECTIVITY_EVENT_FEATURE_ID, r15.build().toByteArray());     // Catch: Exception -> L47
        StringBuilder r28 = new StringBuilder();     // Catch: Exception -> L47
        r28.append("Reported GNSS data to CaeConnectivityDataProto: hasLocation=");     // Catch: Exception -> L47
        r28.append(r10);     // Catch: Exception -> L47
        r28.append(", satellites=");     // Catch: Exception -> L47
        if (r11 == false) goto L44;
        int r29 = r18.getSatelliteCount();     // Catch: Exception -> L47
    L45:
        r28.append(r29);     // Catch: Exception -> L47
        r28.append(", measurements=");     // Catch: Exception -> L47
        r28.append(r26);     // Catch: Exception -> L47
        r28.append(", pdop=");     // Catch: Exception -> L47
        r28.append(r20);     // Catch: Exception -> L47
        r28.append(", hdop=");     // Catch: Exception -> L47
        r28.append(r21);     // Catch: Exception -> L47
        r28.append(", vdop=");     // Catch: Exception -> L47
        r28.append(r22);     // Catch: Exception -> L47
        CaeLog.i(TAG, r28.toString());     // Catch: Exception -> L47
        return;
    L44:
        r29 = 0;
        goto L45
    L40:
        r26 = 0;
    L47:
        e = move-exception;
        CaeLog.e(TAG, "Failed to handle and report GNSS data", e);
        return;
    L13:
        if (r19.isEmpty() == true) goto L15;
        r12 = true;
        goto L17
    L8:
        if (r18.getSatelliteCount() <= 0) goto L10;
        r11 = true;
        goto L11
    L5:
        r10 = false;
        goto L6
    }

    private long statusKey(int r8, int r10) {
        return (((long) r8) << 32) | (((long) r10) & QesdkUtils.LIMITS.UINT_32_UPPER);
    }

    private void unregisterLocked() {
        this.mHandler.removeCallbacks(this.mReportRunnable);
        if (this.mIsCollecting == true) goto L23;
        return;
    L23:
        LocationManager r8 = this.mLocationManager;     // Catch: Throwable -> L11 Exception -> L13 SecurityException -> L16
        if (r8 == null) goto L9;
        r8.removeUpdates(this.mLocationListener);     // Catch: Throwable -> L11 Exception -> L13 SecurityException -> L16
        this.mLocationManager.unregisterGnssStatusCallback(this.mGnssStatusCallback);     // Catch: Throwable -> L11 Exception -> L13 SecurityException -> L16
        this.mLocationManager.unregisterGnssMeasurementsCallback(this.mGnssMeasurementsCallback);     // Catch: Throwable -> L11 Exception -> L13 SecurityException -> L16
        this.mLocationManager.removeNmeaListener(this.mNmeaListener);     // Catch: Throwable -> L11 Exception -> L13 SecurityException -> L16
    L9:
        CaeLog.i(TAG, "Stopped collecting: GNSS listeners unregistered.");     // Catch: Throwable -> L11 Exception -> L13 SecurityException -> L16
    L19:
        this.mIsCollecting = false;
        return;
    L11:
        th = move-exception;
        this.mIsCollecting = false;
        throw th;
    L16:
        e = e;
        String r10 = "Missing location permission for unregister";
    L15:
        CaeLog.e(TAG, r10, e);     // Catch: Throwable -> L11
    L13:
        e = e;
        r10 = "Failed to unregister GNSS listeners";
        goto L15
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public synchronized void destroy() {
        monitor-enter(this);
        stopCollect();     // Catch: Throwable -> L9
        ExecutorService r8 = this.mCallbackExecutor;     // Catch: Throwable -> L9
        if (r8 == null) goto L6;
        r8.shutdown();     // Catch: Throwable -> L9
        this.mCallbackExecutor = null;     // Catch: Throwable -> L9
    L6:
        this.mContext = null;     // Catch: Throwable -> L9
        this.mLocationManager = null;     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public int getCollectorType() {
        return 4;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public void init(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mLocationManager = (LocationManager) r10.getSystemService(LocationMonitorConst.LOCATION);
        CaeLog.i(TAG, "CaeGnssInfoReport initialized.");
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public synchronized void startCollect(String r8, long r10) {
        monitor-enter(this);
        if (r8 != null) goto L44;
        r8 = "";
    L44:
        this.mCurrentPoiName = r8;     // Catch: Throwable -> L5
        this.mTriggerTime = r10;     // Catch: Throwable -> L5
        if (this.mContext != null) goto L10;
    L39:
        CaeLog.e(TAG, "Cannot start collect: Not initialized.");     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L10:
        if (this.mLocationManager == null) goto L39;
        if (hasLocationPermission() == true) goto L18;
        CaeLog.e(TAG, "Cannot start collect: missing location permission.");     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L18:
        if (this.mIsCollecting == false) goto L45;
        CaeLog.d(TAG, "GNSS collect is already running, ignore duplicate collect request.");     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L45:
    L34:
        e = e;
        this.mIsCollecting = false;     // Catch: Throwable -> L5
        String r11 = TAG;
        String r12 = "Missing location permission for GNSS collection";
    L33:
        CaeLog.e(r11, r12, e);     // Catch: Throwable -> L5
    L37:
        monitor-exit(this);
        return;
    L31:
        e = e;
        this.mIsCollecting = false;     // Catch: Throwable -> L5
        r11 = TAG;
        r12 = "Failed to start GNSS collection";
        goto L33
    L24:
        if (this.mLocationManager.isProviderEnabled(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == true) goto L29;
        CaeLog.w(TAG, "Cannot start collect: GPS provider is disabled.");     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        monitor-exit(this);
        return;
    L29:
        this.mLatestLocation = null;     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLatestGnssStatus = null;     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLatestMeasurements.clear();     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLatestPdop = -1.0f;     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLatestHdop = -1.0f;     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLatestVdop = -1.0f;     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        Executor r13 = ensureExecutor();     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLocationManager.requestLocationUpdates(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, 1000, LOCATION_MIN_DISTANCE_M, r13, this.mLocationListener);     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLocationManager.registerGnssStatusCallback(r13, this.mGnssStatusCallback);     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLocationManager.registerGnssMeasurementsCallback(r13, this.mGnssMeasurementsCallback);     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mLocationManager.addNmeaListener(r13, this.mNmeaListener);     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mIsCollecting = true;     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mHandler.removeCallbacks(this.mReportRunnable);     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        this.mHandler.postDelayed(this.mReportRunnable, GNSS_COLLECT_WINDOW_MS);     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
        CaeLog.i(TAG, "Started collecting: GNSS listeners registered.");     // Catch: Throwable -> L5 Exception -> L31 SecurityException -> L34
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public void stopCollect() {
        finishAndReport();
    }
}
