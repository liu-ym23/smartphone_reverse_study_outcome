package com.obric.cae.location.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.location.Address;
import android.location.Geocoder;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.activity.j;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.libs.utils.CaelibUtils;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.location.StarLocationService;
import com.obric.cae.location.city.StarCityManager;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geofence.StarGeoCallback;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import com.obric.cae.location.warm.StarWarmModeManager;
import com.obric.cae.location.zpp.StarZppManager;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.LocationAwareInfoManager;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.report.SubwayEvaluationEvent;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import o5.o;
import r1.s;

/* JADX INFO: loaded from: classes.dex */
public class LocationUtil {
    private static final long ASYNC_REQ_WINDOW_MS = 0;
    private static final float BD_LOCATION_DEFAULT_ACCURACY = 50.0f;
    public static final byte COORD_TYPE_BD09 = 2;
    public static final byte COORD_TYPE_GCJ02 = 1;
    public static final byte COORD_TYPE_WGS84 = 0;
    private static final long CRYPTO_INIT_WAIT_TIMEOUT_MS = 0;
    private static final int DEFAULT_FORBID_MOCK_LOCATION = 1;
    private static final String DISABLE_NLP_WIFI_CACHE = "disable_nlp_wifi_cache";
    public static final String DISABLE_NLP_WIFI_CACHE_ALWAYS = "disable_nlp_wifi_cache_always";
    private static final int DISABLE_NLP_WIFI_CACHE_ALWAYS_DISABLED = 0;
    private static final int DISABLE_NLP_WIFI_CACHE_ALWAYS_ENABLED = 1;
    private static final int DISABLE_NLP_WIFI_CACHE_DISABLED = 0;
    private static final int DISABLE_NLP_WIFI_CACHE_ENABLED = 1;
    private static final String FORBID_MOCK_LOCATION = "forbid_mock_location";
    private static final float INDOOR_CONFIDENCE_THRESHOLD = 0.5f;
    private static final int INDOOR_OUTDOOR_DIFF_THRESHOLD = 5;
    private static final int INDOOR_OUTDOOR_STATUS_INDOOR = 1;
    private static final int INDOOR_OUTDOOR_STATUS_OUTDOOR = 2;
    private static final int INDOOR_OUTDOOR_STATUS_UNKNOWN = 0;
    private static final int LARGE_MOVEMENT_STEP_THRESHOLD = 80;
    private static final int MASK_TRANSPORT_CELLULAR = 1;
    private static final int MASK_TRANSPORT_WIFI = 2;
    private static final String PRIVACY_ATTESTATION_APP_ID = "ocean_location";
    private static final long PRIVACY_ATTESTATION_CERT_CACHE_TTL_MS = 0;
    private static final String PRIVACY_ATTESTATION_KEY_ALIAS = "ocean_location_attestation";
    private static final long REQUEST_SINGLE_GPS_LOCATION_TIMEOUT_MS = 0;
    private static final long REQUEST_SINGLE_LOCATION_TIMEOUT_MS = 0;
    private static final String STAR_DIR = "star";
    private static final String TAG = "StarLocation-util";
    public static final int USER_ID_SYSTEM = 0;
    private static final AtomicReference<CountDownLatch> sCryptoInitLatch = null;
    private static final String sEncryptedKey = "CommSenseLog";
    private static final String sEncryptedModule = "CommSenseLog";

    @SuppressLint({"StaticFieldLeak"})
    private static volatile LocationUtil sInstance = null;
    private static final Object sInstanceLock = null;
    private static volatile boolean sIsCryptoInit = false;
    private static volatile boolean sIsPrivacySdkInit = false;
    private static final Object sPrivacySdkInitLock = null;
    public static String sProductDevice = "";
    private final AtomicInteger mActiveLocationUserId;
    private volatile boolean mBdGeoInited;
    private final AtomicBoolean mBdIndoorCheckFinished;
    private final AtomicInteger mBdIndoorCheckStatus;
    private volatile float mBdIndoorConfidence;
    private final AtomicReference<Location> mCacheNlpLocation;
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private final AtomicInteger mCurNetworkTransport;
    private final AtomicInteger mCurrentUserId;
    private final AtomicBoolean mDisableNlpWifiCache;
    private final AtomicBoolean mDisableNlpWifiCacheAlways;
    private final AtomicBoolean mDisableNlpWifiCacheByMovement;
    private final ContentObserver mDisableNlpWifiCacheObserver;
    private final ExecutorService mExecutor;
    private final AtomicBoolean mForbidMockLocation;
    private final AtomicInteger mGnssCheckIndoorCount;
    private final AtomicInteger mGnssCheckOutdoorCount;
    private final AtomicBoolean mGnssEngineOn;
    private final AtomicBoolean mGnssIndoorCheckFinished;
    private final AtomicInteger mGnssIndoorCheckStatus;
    private final GnssStatus.Callback mGnssStatusCallback;
    private final AtomicReference<Future<?>> mGnssTimeoutFuture;
    private final AtomicBoolean mHasReceivedSatelliteStatus;
    private final AtomicBoolean mHasUserMovedByHar;
    private LocationListener mIndoorCheckListener;
    private final AtomicReference<Location> mIndoorCheckLocation;
    private volatile Location mIndoorCheckReportLocation;
    private final AtomicBoolean mIndoorCheckReported;
    private final AtomicBoolean mIndoorCheckRunning;
    private final AtomicReference<CountDownLatch> mInflightResolveLatch;
    private final AtomicReference<Location> mInflightResolvedLocation;
    private final AtomicBoolean mIsNetworkValid;
    private final AtomicBoolean mIsScreenOn;
    private final AtomicBoolean mIsWifiConnected;
    private final AtomicLong mLastAsyncGetCurLocationMs;
    private final AtomicLong mLastAsyncRequestSingleLocationMs;
    private volatile long mLastCityResolveTimeMs;
    private final AtomicReference<Location> mLastDeliveredLocation;
    private final AtomicInteger mLastNetworkTransport;
    private final AtomicReference<List<Address>> mLastResolvedAddress;
    private final AtomicReference<Location> mLastResolvedLocation;
    private final AtomicInteger mLatestHarStatus;
    private final AtomicInteger mLatestStepsCounter;
    private final ConcurrentMap<String, LocationListener> mListenerMap;
    private LocationManager mLocationManager;
    private final Object mLocationRegistrationLock;
    private final AtomicBoolean mLocationUiEnabled;
    private final InnerAwareInfoCallback mMovementAwareCallback;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private final LocationListener mPassiveLocationListener;
    private volatile String mPrivacyIdAttestationCert;
    private volatile long mPrivacyIdAttestationCertElapsedRealtimeMs;
    private final Object mPrivacyIdAttestationCertLock;
    private HandlerThread mSingleLocationHandlerThread;
    private final Object mSingleLocationLooperLock;
    private final AtomicReference<Location> mSingleRequestLocation;
    private final AtomicBoolean mSingleRequestPending;
    private final AtomicInteger mStepsCounterBaseline;
    private TelephonyManager mTelephonyManager;
    private final BroadcastReceiver mUserLifecycleReceiver;
    private final AtomicBoolean mUserLifecycleReceiverRegistered;
    private StarWarmModeManager mWarmModeManager;
    private WifiManager mWifiManager;
    private final BroadcastReceiver mWifiScanReceiver;

    /* JADX INFO: renamed from: com.obric.cae.location.util.LocationUtil$2, reason: invalid class name */
    public class AnonymousClass2 extends GnssStatus.Callback {
        final /* synthetic */ LocationUtil this$0;

        public AnonymousClass2(LocationUtil r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass2 r8) {
            r8.lambda$onStarted$0();
        }

        private /* synthetic */ void lambda$onStarted$0() {
            CommSenseLog.v(LocationUtil.TAG, "Waiting for satellite status " + Thread.currentThread().getName());     // Catch: InterruptedException -> L11
            Thread.sleep(10000);     // Catch: InterruptedException -> L11
            CommSenseLog.i(LocationUtil.TAG, "Time arrival." + Thread.currentThread().getName());     // Catch: InterruptedException -> L11
            if (LocationUtil.access$400(this.this$0).get() == true) goto L15;
            CommSenseLog.e(LocationUtil.TAG, "Timeout: No satellite status received within 10s after GNSS started " + Thread.currentThread().getName());     // Catch: InterruptedException -> L11
            if (LocationUtil.access$800(this.this$0).get() == true) goto L8;
            return;
        L8:
            if (LocationUtil.access$1100(this.this$0).compareAndSet(false, true) == false) goto L17;
            LocationUtil.access$1300(this.this$0, "GNSS_Satellite_Timeout", 1, null);     // Catch: InterruptedException -> L11
            return;
        L17:
            return;
        L15:
            return;
        L11:
            CommSenseLog.v(LocationUtil.TAG, "Interrupted while sleeping " + Thread.currentThread().getName());
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus r8) {
            CommSenseLog.vWithMethodName(LocationUtil.TAG, "");
            int r10 = 1;
            LocationUtil.access$400(this.this$0).compareAndSet(false, true);
            LocationAwareInfoManager.getInstance(LocationUtil.access$700(this.this$0)).handleGnssSvUpdate(r8);
            if (LocationUtil.access$800(this.this$0).get() == false) goto L31;
            int r11 = 0;
            int r12 = 0;
        L6:
            if (r11 >= r8.getSatelliteCount()) goto L12;
            if (r8.getCn0DbHz(r11) < 20.0f) goto L10;
            r12 = r12 + 1;
        L10:
            r11 = r11 + 1;
            goto L6
        L12:
            if (r12 > 6) goto L16;
            AtomicInteger r13 = LocationUtil.access$900(this.this$0);
        L14:
            r13.incrementAndGet();
        L18:
            int r14 = LocationUtil.access$900(this.this$0).get();
            int r15 = LocationUtil.access$1000(this.this$0).get();
            if (LocationUtil.access$1100(this.this$0).get() == false) goto L21;
            return;
        L21:
            if (Math.abs(r14 - r15) < 5) goto L33;
            Location r16 = (Location) LocationUtil.access$1200(this.this$0).get();
            if (LocationUtil.access$1100(this.this$0).compareAndSet(false, true) == false) goto L34;
            if (r15 <= r14) goto L26;
            r10 = 2;
        L26:
            LocationUtil.access$1300(this.this$0, "GNSS_Satellite", r10, r16);
            return;
        L34:
            return;
        L33:
            return;
        L16:
            if (r12 < 10) goto L18;
            r13 = LocationUtil.access$1000(this.this$0);
            goto L14
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
            CommSenseLog.d(LocationUtil.TAG, "Gnss Engine onStarted");
            LocationUtil.access$300(this.this$0).set(true);
            StarLocationManager.getInstance().setGnssEngineOn(true);
            LocationUtil.access$400(this.this$0).set(false);
            Future<?> r8 = LocationUtil.access$500(this.this$0).submit(new d(this));
            Future r10 = (Future) LocationUtil.access$600(this.this$0).getAndSet(r8);
            if (r10 == null) goto L6;
            r10.cancel(true);
            return;
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            CommSenseLog.d(LocationUtil.TAG, "Gnss Engine onStopped");
            LocationUtil.access$300(this.this$0).set(false);
            StarLocationManager.getInstance().setGnssEngineOn(false);
            Future r8 = (Future) LocationUtil.access$600(this.this$0).getAndSet(null);
            int r10 = 1;
            if (r8 == null) goto L6;
            r8.cancel(true);
        L6:
            if (LocationUtil.access$800(this.this$0).get() == true) goto L8;
            return;
        L8:
            if (LocationUtil.access$1100(this.this$0).get() == true) goto L20;
            int r11 = LocationUtil.access$900(this.this$0).get();
            int r12 = LocationUtil.access$1000(this.this$0).get();
            Location r13 = (Location) LocationUtil.access$1200(this.this$0).get();
            if (LocationUtil.access$1100(this.this$0).compareAndSet(false, true) == false) goto L19;
            LocationUtil r14 = this.this$0;
            if (r12 < r11) goto L16;
            if (r12 <= 0) goto L16;
            r10 = 2;
        L16:
            LocationUtil.access$1300(r14, "GNSS_Satellite_Stop", r10, r13);
            return;
        L19:
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.util.LocationUtil$4, reason: invalid class name */
    public class AnonymousClass4 extends BroadcastReceiver {
        final /* synthetic */ LocationUtil this$0;

        public AnonymousClass4(LocationUtil r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass4 r8, Intent r10) {
            r8.lambda$onReceive$0(r10);
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r8) {
            String r10 = r8.getAction();
            if ("android.intent.action.SCREEN_ON".equals(r10) == false) goto L6;
            LocationUtil.access$1900(this.this$0).set(true);
            String r11 = "screen on";
        L8:
            CommSenseLog.dumpI(LocationUtil.TAG, r11, CommSenseLog.getRecordFile("geofence"));
            return;
        L6:
            if ("android.intent.action.SCREEN_OFF".equals(r10) == false) goto L10;
            LocationUtil.access$1900(this.this$0).set(false);
            r11 = "screen off";
            goto L8
        L10:
            int r12 = r8.getIntExtra("android.intent.extra.user_handle", 0);
            if ("android.intent.action.USER_SWITCHED".equals(r10) == false) goto L14;
            CommSenseLog.dumpI(LocationUtil.TAG, defpackage.a.d("user switched: ", r12), CommSenseLog.getRecordFile("geofence"));
            LocationUtil.access$2000(this.this$0, "user_switched", r12, true);
            return;
        L14:
            if ("android.intent.action.USER_UNLOCKED".equals(r10) == false) goto L18;
            LocationUtil.access$2000(this.this$0, "user_unlocked", r12, false);
            return;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, final Intent r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.getAction() == null) goto L9;
            this.this$0.getExecutor().execute(new e(this, r10));
            return;
        }
    }

    static {
        sInstanceLock = new Object();
        PRIVACY_ATTESTATION_CERT_CACHE_TTL_MS = TimeUnit.HOURS.toMillis(24);
        TimeUnit r8 = TimeUnit.SECONDS;
        CRYPTO_INIT_WAIT_TIMEOUT_MS = r8.toMillis(5);
        ASYNC_REQ_WINDOW_MS = r8.toMillis(10);
        REQUEST_SINGLE_LOCATION_TIMEOUT_MS = r8.toMillis(5);
        REQUEST_SINGLE_GPS_LOCATION_TIMEOUT_MS = r8.toMillis(15);
        sIsCryptoInit = false;
        sIsPrivacySdkInit = false;
        sCryptoInitLatch = new AtomicReference(null);
        sPrivacySdkInitLock = new Object();
    }

    public LocationUtil() {
        final Handler r8 = null;
        this.mLastResolvedLocation = new AtomicReference(null);
        this.mLastResolvedAddress = new AtomicReference(Collections.emptyList());
        this.mInflightResolvedLocation = new AtomicReference(null);
        this.mInflightResolveLatch = new AtomicReference(null);
        this.mListenerMap = new ConcurrentHashMap();
        this.mExecutor = Executors.newCachedThreadPool();
        this.mLocationUiEnabled = new AtomicBoolean(true);
        this.mIsScreenOn = new AtomicBoolean(false);
        this.mIsNetworkValid = new AtomicBoolean(false);
        this.mLastNetworkTransport = new AtomicInteger(0);
        this.mCurNetworkTransport = new AtomicInteger(0);
        this.mIsWifiConnected = new AtomicBoolean(false);
        this.mHasReceivedSatelliteStatus = new AtomicBoolean(false);
        this.mForbidMockLocation = new AtomicBoolean(true);
        this.mDisableNlpWifiCache = new AtomicBoolean(false);
        this.mDisableNlpWifiCacheAlways = new AtomicBoolean(false);
        this.mDisableNlpWifiCacheByMovement = new AtomicBoolean(false);
        this.mHasUserMovedByHar = new AtomicBoolean(false);
        this.mIndoorCheckRunning = new AtomicBoolean(false);
        this.mIndoorCheckReported = new AtomicBoolean(false);
        this.mBdIndoorCheckStatus = new AtomicInteger(0);
        this.mBdIndoorConfidence = 0.0f;
        this.mIndoorCheckReportLocation = null;
        this.mGnssIndoorCheckStatus = new AtomicInteger(1);
        this.mGnssIndoorCheckFinished = new AtomicBoolean(false);
        this.mBdIndoorCheckFinished = new AtomicBoolean(false);
        this.mIndoorCheckListener = null;
        this.mGnssCheckIndoorCount = new AtomicInteger(0);
        this.mGnssCheckOutdoorCount = new AtomicInteger(0);
        this.mIndoorCheckLocation = new AtomicReference(null);
        this.mGnssTimeoutFuture = new AtomicReference(null);
        this.mLastCityResolveTimeMs = 0;
        this.mBdGeoInited = false;
        this.mPrivacyIdAttestationCertElapsedRealtimeMs = 0;
        this.mPrivacyIdAttestationCertLock = new Object();
        this.mLastDeliveredLocation = new AtomicReference(null);
        this.mCacheNlpLocation = new AtomicReference(null);
        this.mLastAsyncGetCurLocationMs = new AtomicLong(0);
        this.mLastAsyncRequestSingleLocationMs = new AtomicLong(0);
        this.mSingleRequestPending = new AtomicBoolean(false);
        this.mSingleRequestLocation = new AtomicReference(null);
        this.mSingleLocationLooperLock = new Object();
        this.mGnssEngineOn = new AtomicBoolean(false);
        this.mLatestStepsCounter = new AtomicInteger(-1);
        this.mStepsCounterBaseline = new AtomicInteger(-1);
        this.mLatestHarStatus = new AtomicInteger(4);
        this.mLocationRegistrationLock = new Object();
        this.mUserLifecycleReceiverRegistered = new AtomicBoolean(false);
        this.mActiveLocationUserId = new AtomicInteger(0);
        this.mCurrentUserId = new AtomicInteger(0);
        this.mPassiveLocationListener = new AnonymousClass1(this);
        this.mGnssStatusCallback = new AnonymousClass2(this);
        this.mNetworkCallback = new AnonymousClass3(this);
        this.mUserLifecycleReceiver = new AnonymousClass4(this);
        this.mDisableNlpWifiCacheObserver = new AnonymousClass5(this, r8);
        this.mMovementAwareCallback = new AnonymousClass6(this);
        this.mWifiScanReceiver = new AnonymousClass14(this);
    }

    public static /* synthetic */ void a(LocationUtil r8, long r10) {
        r8.lambda$runIndoorCheck$1(r10);
    }

    public static /* synthetic */ AtomicBoolean access$000(LocationUtil r8) {
        return r8.mSingleRequestPending;
    }

    public static /* synthetic */ AtomicReference access$100(LocationUtil r8) {
        return r8.mSingleRequestLocation;
    }

    public static /* synthetic */ AtomicInteger access$1000(LocationUtil r8) {
        return r8.mGnssCheckOutdoorCount;
    }

    public static /* synthetic */ AtomicBoolean access$1100(LocationUtil r8) {
        return r8.mGnssIndoorCheckFinished;
    }

    public static /* synthetic */ AtomicReference access$1200(LocationUtil r8) {
        return r8.mIndoorCheckLocation;
    }

    public static /* synthetic */ void access$1300(LocationUtil r8, String r10, int r11, Location r12) {
        r8.recordGnssResult(r10, r11, r12);
    }

    public static /* synthetic */ boolean access$1400(LocationUtil r8) {
        return r8.checkNetworkValid();
    }

    public static /* synthetic */ void access$1500(LocationUtil r8, boolean r10) {
        r8.setIsNetworkValid(r10);
    }

    public static /* synthetic */ AtomicInteger access$1600(LocationUtil r8) {
        return r8.mLastNetworkTransport;
    }

    public static /* synthetic */ void access$1700(LocationUtil r8, boolean r10) {
        r8.setWifiConnected(r10);
    }

    public static /* synthetic */ AtomicInteger access$1800(LocationUtil r8) {
        return r8.mCurNetworkTransport;
    }

    public static /* synthetic */ AtomicBoolean access$1900(LocationUtil r8) {
        return r8.mIsScreenOn;
    }

    public static /* synthetic */ void access$200(LocationUtil r8, Location r10, int r11) {
        r8.processLocationUpdate(r10, r11);
    }

    public static /* synthetic */ void access$2000(LocationUtil r8, String r10, int r11, boolean r12) {
        r8.syncLocationContext(r10, r11, r12);
    }

    public static /* synthetic */ void access$2100(LocationUtil r8, Uri r10) {
        r8.updateDisableNlpWifiCacheFlag(r10);
    }

    public static /* synthetic */ void access$2200(LocationUtil r8, int r10) {
        r8.handleStepsCounterChanged(r10);
    }

    public static /* synthetic */ void access$2300(LocationUtil r8, int r10, long r11) {
        r8.handleHarStatusChanged(r10, r11);
    }

    public static /* synthetic */ AtomicBoolean access$2400(LocationUtil r8) {
        return r8.mLocationUiEnabled;
    }

    public static /* synthetic */ StarWarmModeManager access$2500(LocationUtil r8) {
        return r8.mWarmModeManager;
    }

    public static /* synthetic */ void access$2600(LocationUtil r8) {
        r8.checkMockLocationFlag();
    }

    public static /* synthetic */ boolean access$2700(LocationUtil r8, Location r10) {
        return r8.checkGpoLocation(r10);
    }

    public static /* synthetic */ void access$2800(LocationUtil r8, LocationListener r10, String r11) {
        r8.removeSingleLocationUpdates(r10, r11);
    }

    public static /* synthetic */ AtomicReference access$2900(LocationUtil r8) {
        return r8.mLastResolvedAddress;
    }

    public static /* synthetic */ AtomicBoolean access$300(LocationUtil r8) {
        return r8.mGnssEngineOn;
    }

    public static /* synthetic */ WifiManager access$3000(LocationUtil r8) {
        return r8.mWifiManager;
    }

    public static /* synthetic */ void access$3100(LocationUtil r8, List r10) {
        r8.notifyWifiScan(r10);
    }

    public static /* synthetic */ AtomicBoolean access$400(LocationUtil r8) {
        return r8.mHasReceivedSatelliteStatus;
    }

    public static /* synthetic */ ExecutorService access$500(LocationUtil r8) {
        return r8.mExecutor;
    }

    public static /* synthetic */ AtomicReference access$600(LocationUtil r8) {
        return r8.mGnssTimeoutFuture;
    }

    public static /* synthetic */ Context access$700(LocationUtil r8) {
        return r8.mContext;
    }

    public static /* synthetic */ AtomicBoolean access$800(LocationUtil r8) {
        return r8.mIndoorCheckRunning;
    }

    public static /* synthetic */ AtomicInteger access$900(LocationUtil r8) {
        return r8.mGnssCheckIndoorCount;
    }

    public static /* synthetic */ void b(LocationUtil r8, String r10, CountDownLatch r11, AtomicReference r12, Location r13) {
        r8.lambda$getCurLocation$2(r10, r11, r12, r13);
    }

    public static /* synthetic */ void c(LocationUtil r8, long r10, AtomicBoolean r11, LocationListener r12, String r13) {
        r8.lambda$scheduleRequestSingleLocationTimeout$3(r10, r11, r12, r13);
    }

    private void checkAllFinished() {
        if (this.mGnssIndoorCheckFinished.get() == true) goto L5;
        return;
    L5:
        if (this.mBdIndoorCheckFinished.get() == false) goto L12;
        CommSenseLog.dWithMethodName(TAG, "Both BD and GNSS finished, evaluate comprehensive result.");
        LocationListener r8 = this.mIndoorCheckListener;
        if (r8 == null) goto L9;
        stopLocationRequest(r8);
        this.mIndoorCheckListener = null;
    L9:
        evaluateAndReportIndoorCheck();
        stopIndoorCheckSession();
        this.mIndoorCheckRunning.set(false);
        return;
    }

    private boolean checkGpoLocation(Location r8) {
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r8.getProvider()) == true) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT < 34) goto L15;
        if (r8.hasVerticalAccuracy() == false) goto L10;
    L13:
        return true;
    L10:
        if (r8.hasMslAltitudeAccuracy() == true) goto L13;
        if (r8.hasSpeedAccuracy() == true) goto L13;
        return false;
    L15:
        if (r8.hasVerticalAccuracy() == false) goto L17;
    L21:
        return true;
    L17:
        if (r8.hasSpeedAccuracy() == true) goto L21;
        return false;
    }

    private void checkMockLocationFlag() {
        AtomicBoolean r8 = this.mForbidMockLocation;
        boolean r10 = true;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), FORBID_MOCK_LOCATION, 1) == 1) goto L6;
        r10 = false;
    L6:
        r8.set(r10);
        CommSenseLog.i(TAG, "mForbidMockLocation: " + this.mForbidMockLocation.get());
    }

    private boolean checkNetworkValid() {
        if (this.mConnectivityManager != null) goto L8;
        CommSenseLog.eWithMethodName(TAG, "ConnectivityManager is null, network is invalid.");
        ConnectivityManager r8 = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        this.mConnectivityManager = r8;
        if (r8 != null) goto L8;
        CommSenseLog.eWithMethodName(TAG, "ConnectivityManager is still null after re-initialization.");
        return false;
    L8:
        Network r10 = this.mConnectivityManager.getActiveNetwork();
        if (r10 != null) goto L12;
        CommSenseLog.iWithMethodName(TAG, "No active network found.");
        return false;
    L12:
        NetworkCapabilities r11 = this.mConnectivityManager.getNetworkCapabilities(r10);
        if (r11 != null) goto L16;
        CommSenseLog.iWithMethodName(TAG, "NetworkCapabilities is null.");
        return false;
    L16:
        AtomicInteger r12 = this.mCurNetworkTransport;
        if (r11.hasTransport(1) == false) goto L19;
        int r13 = 2;
    L20:
        r12.set((r11.hasTransport(0) ? 1 : 0) + r13);
        if (r11.hasCapability(12) == true) goto L23;
        return false;
    L23:
        if (r11.hasCapability(16) == true) goto L25;
        return false;
    L25:
        return true;
    L19:
        r13 = 0;
        goto L20
    }

    private double clamp(double r8, double r10, double r11) {
        return Math.max(r10, Math.min(r11, r8));
    }

    private void clearPrivacyIdAttestationCertCache() {
        this.mPrivacyIdAttestationCert = null;
        this.mPrivacyIdAttestationCertElapsedRealtimeMs = 0;
    }

    public static /* synthetic */ void d(LocationUtil r8) {
        r8.lambda$setIsNetworkValid$0();
    }

    private void ensureUserScopedManagers() {
        Context r8 = this.mContext;
        if (r8 != null) goto L5;
        return;
    L5:
        UserManager r10 = (UserManager) r8.getSystemService("user");
        if (r10 == null) goto L11;
        Iterator<UserHandle> r11 = r10.getUserProfiles().iterator();
    L9:
        if (r11.hasNext() == false) goto L14;
        int r12 = r11.next().getIdentifier();
        StarGeofenceManager.getInstance(this.mContext, r12);
        StarZppManager.getInstance(this.mContext, r12);
        goto L9
    L14:
        return;
    L11:
        StarGeofenceManager.getInstance(this.mContext, 0);
        StarZppManager.getInstance(this.mContext, 0);
    }

    private void evaluateAndReportIndoorCheck() {
        int r8 = 1;
        if (this.mIndoorCheckReported.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        int r10 = this.mBdIndoorCheckStatus.get();
        float r11 = this.mBdIndoorConfidence;
        int r12 = this.mGnssIndoorCheckStatus.get();
        Location r13 = this.mIndoorCheckReportLocation;
        if (r10 == 2) goto L12;
        if (r10 == 1) goto L9;
    L11:
        String r14 = "GNSS";
    L15:
        CommSenseLog.dWithMethodName(TAG, "Comprehensive judgment: use " + r14 + " result, status=" + r12);
        StarGeoCallback.notifyEngineStatusReportToAllUsers(this.mContext, r12, r13);
        return;
    L9:
        if (Float.compare(r11, INDOOR_CONFIDENCE_THRESHOLD) > 0) goto L11;
    L12:
        if (r10 != 2) goto L14;
        r8 = 2;
    L14:
        r14 = "BD";
        r12 = r8;
        goto L15
    }

    private void generatePrivacyIdAttestationCertLocked(long r8) {
        if (this.mContext != null) goto L5;
        String r10 = "mContext is null";
    L25:
        CommSenseLog.eWithMethodName(TAG, r10);
        clearPrivacyIdAttestationCertCache();
        return;
    L5:
        String r11 = MatrixDidUtils.getDid();
        if (r11 != null) goto L8;
    L24:
        r10 = "did is null or empty";
        goto L25
    L8:
        if (r11.isEmpty() == true) goto L24;
        initPrivacySdkIfNeeded();     // Catch: Throwable -> L18 n8.a -> L20
        l8.a.C0111a r12 = new l8.a.C0111a();     // Catch: Throwable -> L18 n8.a -> L20
        r12.a("{\"did\":\"" + r11 + "\"}");     // Catch: Throwable -> L18 n8.a -> L20
        l8.a r13 = new l8.a(r12);     // Catch: Throwable -> L18 n8.a -> L20
        l8.b r14 = l8.b.d();     // Catch: Throwable -> L18 n8.a -> L20
        Context r15 = this.mContext;     // Catch: Throwable -> L18 n8.a -> L20
        r14.getClass();     // Catch: Throwable -> L18 n8.a -> L20
        String r16 = l8.b.c(r15, r13);     // Catch: Throwable -> L18 n8.a -> L20
        if (r16 != null) goto L13;
    L16:
        CommSenseLog.eWithMethodName(TAG, "cert is null or empty");     // Catch: Throwable -> L18 n8.a -> L20
        clearPrivacyIdAttestationCertCache();     // Catch: Throwable -> L18 n8.a -> L20
        return;
    L13:
        if (r16.isEmpty() == true) goto L16;
        this.mPrivacyIdAttestationCert = r16;     // Catch: Throwable -> L18 n8.a -> L20
        this.mPrivacyIdAttestationCertElapsedRealtimeMs = r8;     // Catch: Throwable -> L18 n8.a -> L20
        CommSenseLog.iWithMethodName(TAG, "success, certLength=" + r16.length());     // Catch: Throwable -> L18 n8.a -> L20
        return;
    L20:
        e = e;
        clearPrivacyIdAttestationCertCache();
        String r17 = "failed, errorCode=0";
    L22:
        CommSenseLog.eWithMethodName(TAG, r17, e);
        return;
    L18:
        e = th;
        clearPrivacyIdAttestationCertCache();
        r17 = "failed";
        goto L22
    }

    public static String getEncryptedKey() {
        return CommSenseLog.LOG_TAG;
    }

    public static String getEncryptedModule() {
        return CommSenseLog.LOG_TAG;
    }

    public static LocationUtil getInstance() {
        LocationUtil r8 = sInstance;
        if (r8 != null) goto L14;
        Object r10 = sInstanceLock;
        monitor-enter(r10);
        r8 = sInstance;     // Catch: Throwable -> L11
        if (r8 != null) goto L9;
        r8 = new LocationUtil();     // Catch: Throwable -> L11
        sInstance = r8;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r10);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r8;
    }

    private int getRadiusByGeofenceId(String r8) {
        if (r8 != null) goto L4;
        return 250;
    L4:
        if (r8.startsWith("train_station_") == false) goto L8;
        return 700;
    L8:
        if (r8.startsWith("airport_") == false) goto L13;
        return BWDLInnerConstant.EVENT_TIME_TOUT;
    L13:
        return 250;
    }

    private long getRequestSingleLocationTimeoutMs(String r8) {
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r8) == false) goto L7;
        return REQUEST_SINGLE_GPS_LOCATION_TIMEOUT_MS;
    L7:
        return REQUEST_SINGLE_LOCATION_TIMEOUT_MS;
    }

    private Looper getSingleLocationCallbackLooper() {
        Object r8 = this.mSingleLocationLooperLock;
        monitor-enter(r8);
        HandlerThread r10 = this.mSingleLocationHandlerThread;     // Catch: Throwable -> L12
        if (r10 != null) goto L7;
    L8:
        HandlerThread r11 = new HandlerThread("LocationUtil-SingleLocation");     // Catch: Throwable -> L12
        r11.start();     // Catch: Throwable -> L12
        this.mSingleLocationHandlerThread = r11;     // Catch: Throwable -> L12
    L9:
        Looper r12 = this.mSingleLocationHandlerThread.getLooper();     // Catch: Throwable -> L12
        monitor-exit(r8);     // Catch: Throwable -> L12
        return r12;
    L7:
        if (r10.isAlive() == true) goto L9;
    L12:
        th = move-exception;
        throw th;
    }

    private void handleHarStatusChanged(int r8, long r10) {
        this.mLatestHarStatus.set(r8);
        if (isLargeMovementHarStatus(r8) == false) goto L5;
        this.mHasUserMovedByHar.set(true);
    L5:
        maybeDisableNlpWifiCacheForLargeMovement(SubwayEvaluationEvent.VERIFY_EVENT_TYPE_HAR);
    }

    private void handleStepsCounterChanged(int r8) {
        if (r8 >= 0) goto L4;
        return;
    L4:
        int r10 = this.mLatestStepsCounter.getAndSet(r8);
        if (r10 < 0) goto L10;
        if (r8 >= r10) goto L10;
        CommSenseLog.wWithMethodName(TAG, "reset, old=" + r10 + ", new=" + r8);
        this.mStepsCounterBaseline.set(r8);
        return;
    L10:
        if (this.mStepsCounterBaseline.compareAndSet(-1, r8) == false) goto L13;
        CommSenseLog.dWithMethodName(TAG, "init step baseline: " + r8);
        return;
    L13:
        maybeDisableNlpWifiCacheForLargeMovement("steps");
    }

    private boolean hasCachedCityInfo() {
        StarLocationDbManager.CityInfo r8 = StarLocationDbManager.getInstance(this.mContext, 0).getCityInfo();
        if (r8 == null) goto L22;
        String r10 = r8.adminArea;
        if (r10 != null) goto L7;
    L8:
        String r11 = r8.subAdminArea;
        if (r11 != null) goto L11;
    L12:
        String r12 = r8.locality;
        if (r12 != null) goto L15;
    L16:
        String r13 = r8.subLocality;
        if (r13 != null) goto L19;
        return false;
    L19:
        if (r13.isEmpty() == true) goto L24;
    L20:
        return true;
    L24:
        return false;
    L15:
        if (r12.isEmpty() == false) goto L20;
    L11:
        if (r11.isEmpty() == false) goto L20;
    L7:
        if (r10.isEmpty() == false) goto L20;
    L22:
        return false;
    }

    private boolean hasLargeStepMovement() {
        int r8 = this.mStepsCounterBaseline.get();
        int r10 = this.mLatestStepsCounter.get();
        if (r8 < 0) goto L8;
        if (r10 < r8) goto L8;
        if ((r10 - r8) < LARGE_MOVEMENT_STEP_THRESHOLD) goto L8;
        return true;
    L8:
        return false;
    }

    private void initBdGeoLocation() {
        if (this.mBdGeoInited == false) goto L5;
        return;
    L5:
        BdLocationManager.getInstance().init(this.mContext);
        this.mBdGeoInited = true;
    }

    private void initNetworkInfo() {
        ConnectivityManager r8 = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        this.mConnectivityManager = r8;
        r8.registerDefaultNetworkCallback(this.mNetworkCallback);
        setIsNetworkValid(checkNetworkValid());
    }

    private void initPrivacySdkIfNeeded() {
        if (k8.a.f8973a == false) goto L5;
    L24:
        sIsPrivacySdkInit = true;
        return;
    L5:
        if (sIsPrivacySdkInit == true) goto L24;
        Object r8 = sPrivacySdkInitLock;
        monitor-enter(r8);
    L22:
        th = move-exception;
        throw th;
    L10:
        if (k8.a.f8973a == false) goto L12;
    L17:
        sIsPrivacySdkInit = true;     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L12:
        if (sIsPrivacySdkInit == true) goto L17;
        k8.a.b(new AnonymousClass9(this), new AnonymousClass10(this));     // Catch: Throwable -> L22
        sIsPrivacySdkInit = true;     // Catch: Throwable -> L22
        CommSenseLog.iWithMethodName(TAG, "Privacy SDK initialized successfully.");     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
    }

    private boolean isLargeMovementHarStatus(int r8) {
        if (r8 != 5) goto L5;
    L12:
        return true;
    L5:
        if (r8 == 6) goto L12;
        if (r8 == 7) goto L12;
        if (r8 == 8) goto L12;
        return false;
    }

    private boolean isPrivacyIdAttestationCertCacheValid(long r8) {
        String r10 = this.mPrivacyIdAttestationCert;
        long r11 = r8 - this.mPrivacyIdAttestationCertElapsedRealtimeMs;
        if (r10 != null) goto L5;
    L13:
        return false;
    L5:
        if (r10.isEmpty() == true) goto L13;
        if (this.mPrivacyIdAttestationCertElapsedRealtimeMs <= 0) goto L13;
        if (r11 < 0) goto L13;
        if (r11 >= PRIVACY_ATTESTATION_CERT_CACHE_TTL_MS) goto L13;
        return true;
    }

    private /* synthetic */ void lambda$getCurLocation$2(String r8, CountDownLatch r10, AtomicReference r11, Location r12) {
        if (r12 != null) goto L5;
        CommSenseLog.e(TAG, "getCurrentLocation is null: " + r8);
    L6:
        r10.countDown();
        return;
    L5:
        CommSenseLog.i(TAG, "getCurrentLocation success: " + r8);
        processLocationUpdate(r12, 3);
        r11.set(r12);
        goto L6
    }

    private /* synthetic */ void lambda$runIndoorCheck$1(long r8) {
        long r10 = SystemClock.elapsedRealtime();
        startLocationRequest(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, this.mIndoorCheckListener);
        runIndoorCheckWithBdLocation();
        long r11 = r8 - (SystemClock.elapsedRealtime() - r10);
        if (r11 <= 0) goto L18;
        long r12 = SystemClock.elapsedRealtime() + r11;
    L6:
        if (SystemClock.elapsedRealtime() >= r12) goto L18;
        if (this.mGnssIndoorCheckFinished.get() == false) goto L29;
        if (this.mBdIndoorCheckFinished.get() == true) goto L18;
    L29:
        Thread.sleep(100);     // Catch: InterruptedException -> L15
    L15:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "timeout sleep interrupted: " + e.getMessage());
    L18:
        if (this.mGnssIndoorCheckFinished.get() == true) goto L20;
    L22:
        CommSenseLog.dWithMethodName(TAG, "timeout, force stopLocationRequest");
        if (this.mGnssIndoorCheckFinished.compareAndSet(false, true) == false) goto L26;
        recordGnssResult("Timeout", 1, null);
    L26:
        if (this.mBdIndoorCheckFinished.compareAndSet(false, true) == false) goto L34;
        CommSenseLog.dWithMethodName(TAG, "BD timed out");
        this.mBdIndoorCheckStatus.set(0);
        checkAllFinished();
        return;
    L34:
        return;
    L20:
        if (this.mBdIndoorCheckFinished.get() == false) goto L22;
    }

    private /* synthetic */ void lambda$scheduleRequestSingleLocationTimeout$3(long r8, AtomicBoolean r10, LocationListener r11, String r12) {
        Thread.sleep(r8);     // Catch: InterruptedException -> L8
        if (r10.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        this.mSingleRequestLocation.set(null);
        this.mSingleRequestPending.set(false);
        removeSingleLocationUpdates(r11, r12);
        CommSenseLog.e(TAG, "requestSingleUpdate timeout: " + r8 + ", source: " + r12);
        return;
    L8:
        Thread.currentThread().interrupt();
    }

    private /* synthetic */ void lambda$setIsNetworkValid$0() {
        UserManager r8 = (UserManager) this.mContext.getSystemService("user");
        if (r8 == null) goto L8;
        Iterator<UserHandle> r10 = r8.getUserProfiles().iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        UserHandle r11 = r10.next();
        StarGeofenceManager.getInstance(this.mContext, r11.getIdentifier()).retryGeofenceAddress();
    L9:
        initCloudTransCryptoManager();
        initBdGeoLocation();
        getCurLocation("network", true, "Network Available");
        return;
    L8:
        StarGeofenceManager.getInstance(this.mContext, 0).retryGeofenceAddress();
        goto L9
    }

    private void logBundleContents(Bundle r11, String r12) {
        ArrayList r8 = new ArrayList(r11.keySet());
        Collections.sort(r8);
        int r10 = 0;
    L4:
        if (r10 >= r8.size()) goto L27;
        String r13 = (String) r8.get(r10);
        Object r14 = r11.get(r13);
        boolean r15 = true;
        if (r10 == (r8.size() - 1)) goto L9;
        r15 = false;
    L9:
        if (r15 == false) goto L11;
        String r16 = "\\- ";
    L12:
        StringBuilder r17 = android.aimedia.a.j(r12);
        if (r15 == false) goto L15;
        String r18 = "   ";
    L16:
        r17.append(r18);
        String r19 = r17.toString();
        if ((r14 instanceof Bundle) == false) goto L20;
        CommSenseLog.d(TAG, r12 + r16 + r13);
        logBundleContents((Bundle) r14, r19);
    L26:
        r10 = r10 + 1;
        goto L4
    L20:
        if ((r14 instanceof ArrayList) == false) goto L22;
        ArrayList<?> r20 = (ArrayList) r14;
        CommSenseLog.d(TAG, r12 + r16 + r13 + " (size=" + r20.size() + ")");
        logBundleList(r20, r19, r13);
        goto L26
    L22:
        if (r14 != null) goto L24;
        String r21 = r12 + r16 + r13 + " = null";
    L25:
        CommSenseLog.d(TAG, r21);
        goto L26
    L24:
        r21 = r12 + r16 + r13 + " = " + String.valueOf(r14);
        goto L25
    L15:
        r18 = "|  ";
        goto L16
    L11:
        r16 = "|- ";
        goto L12
    }

    private void logBundleList(ArrayList<?> r18, String r19, String r20) {
        int r8 = 0;
    L4:
        if (r8 >= r18.size()) goto L38;
        Object r10 = r18.get(r8);
        boolean r11 = true;
        if (r8 == (r18.size() - 1)) goto L9;
        r11 = false;
    L9:
        if (r11 == false) goto L11;
        String r12 = "\\- ";
    L12:
        StringBuilder r13 = android.aimedia.a.j(r19);
        if (r11 == false) goto L15;
        String r14 = "   ";
    L16:
        r13.append(r14);
        String r15 = r13.toString();
        if ("steps".equals(r20) == false) goto L28;
        if ((r10 instanceof Bundle) == false) goto L28;
        Bundle r16 = (Bundle) r10;
        Object r17 = r16.get("items");
        if (r16.containsKey("index") == false) goto L23;
        int r21 = r16.getInt("index", r8);
    L25:
        if ((r17 instanceof ArrayList) == false) goto L28;
        ArrayList<?> r110 = (ArrayList) r17;
        CommSenseLog.d(TAG, r19 + r12 + "[group " + r21 + "] (size=" + r110.size() + ")");
        logBundleList(r110, r15, "items");
    L37:
        r8 = r8 + 1;
        goto L4
    L23:
        r21 = r8;
    L28:
        if ((r10 instanceof Bundle) == false) goto L31;
        CommSenseLog.d(TAG, r19 + r12 + "[" + r8 + "]");
        logBundleContents((Bundle) r10, r15);
        goto L37
    L31:
        if ((r10 instanceof ArrayList) == false) goto L33;
        StringBuilder r22 = new StringBuilder();
        r22.append(r19);
        r22.append(r12);
        r22.append("[");
        r22.append(r8);
        r22.append("] (size=");
        ArrayList<?> r23 = (ArrayList) r10;
        r22.append(r23.size());
        r22.append(")");
        CommSenseLog.d(TAG, r22.toString());
        logBundleList(r23, r15, null);
        goto L37
    L33:
        if (r10 != null) goto L35;
        String r24 = r19 + r12 + "[" + r8 + "] = null";
    L36:
        CommSenseLog.d(TAG, r24);
        goto L37
    L35:
        r24 = r19 + r12 + "[" + r8 + "] = " + String.valueOf(r10);
        goto L36
    L15:
        r14 = "|  ";
        goto L16
    L11:
        r12 = "|- ";
        goto L12
    }

    private void logDirectionBundle(Bundle r8) {
        if (r8 != null) goto L6;
        CommSenseLog.w(TAG, "searchDirectionFromBmap returned null bundle");
        return;
    L6:
        CommSenseLog.d(TAG, "direction");
        logBundleContents(r8, "");
    }

    private boolean markAsyncRequestSingleLocation(long r8, long r10) {
    L2:
        long r11 = this.mLastAsyncRequestSingleLocationMs.get();
        if ((r8 - r11) < r10) goto L4;
        if (this.mLastAsyncRequestSingleLocationMs.compareAndSet(r11, r8) == false) goto L2;
        return true;
    L4:
        return false;
    }

    private void maybeDisableNlpWifiCacheForLargeMovement(String r8) {
        if (hasLargeMovement() == true) goto L6;
        return;
    L6:
        if (this.mDisableNlpWifiCacheByMovement.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        StringBuilder r10 = defpackage.b.h("detected large movement by ", r8, ", moveSteps=");
        r10.append(this.mLatestStepsCounter.get() - this.mStepsCounterBaseline.get());
        r10.append(", harStatus=");
        r10.append(this.mLatestHarStatus.get());
        CommSenseLog.iWithMethodName(TAG, r10.toString());
        setDisableNlpWifiCache(true);
    }

    private void maybeResolveAndPersistAddress(Location r10) {
        long r8 = System.currentTimeMillis();
        boolean r11 = true;
        if (hasCachedCityInfo() == true) goto L5;
    L14:
        List<Address> r12 = resolveAddressByLocation(r10, false);
        if (r12 != null) goto L17;
        return;
    L17:
        if (r12.isEmpty() == true) goto L39;
        Address r13 = r12.get(0);
        String r14 = r13.getAdminArea();
        String r15 = r13.getSubAdminArea();
        String r16 = r13.getLocality();
        String r17 = r13.getSubLocality();
        if (r14 != null) goto L22;
    L23:
        if (r15 != null) goto L25;
    L26:
        if (r16 != null) goto L28;
    L29:
        if (r17 != null) goto L31;
    L33:
        r11 = false;
    L34:
        if (r11 == true) goto L36;
        return;
    L36:
        StarCityManager.getInstance(this.mContext).notifyCityChanged(r13);
        StarCityManager.getInstance(this.mContext).onAddressResolved(r13, r8);
        this.mLastCityResolveTimeMs = r8;
        return;
    L31:
        if (r17.isEmpty() == true) goto L33;
    L28:
        if (r16.isEmpty() == false) goto L34;
    L25:
        if (r15.isEmpty() == false) goto L34;
    L22:
        if (r14.isEmpty() == false) goto L34;
    L39:
        return;
    L5:
        if ((r8 - this.mLastCityResolveTimeMs) > TimeUnit.HOURS.toMillis(1)) goto L14;
        Location r18 = this.mLastResolvedLocation.get();
        if (r18 != null) goto L9;
    L11:
        boolean r19 = false;
    L12:
        if (r19 == true) goto L14;
        return;
    L9:
        if (r10.distanceTo(r18) <= 100000.0f) goto L11;
        r19 = true;
        goto L12
    }

    @SuppressLint({"NewApi"})
    private void notifyWifiScan(List<ScanResult> r10) {
        CommSenseLog.vWithMethodName(TAG, "" + r10.size());
        ArrayList r11 = new ArrayList();
        ArrayList r8 = new ArrayList();
        Iterator<ScanResult> r12 = r10.iterator();
    L3:
        int r13 = 1;
        if (r12.hasNext() == false) goto L13;
        ScanResult r14 = r12.next();
        if (CaelibUtils.is24GHz(r14.frequency) == true) goto L12;
        if (CaelibUtils.is5GHz(r14.frequency) == false) goto L11;
        r13 = 2;
        goto L12
    L11:
        r13 = 0;
    L12:
        r11.add(new WifiStandardData.Builder().setTimestamp(System.currentTimeMillis()).setSsid(r14.SSID).setBssid(r14.BSSID).setFrequency(r14.frequency).setBand(r13).setRssi(r14.level).setSignalLevel(WifiManager.calculateSignalLevel(r14.level, 5)).setAuthType(CaelibUtils.getWiFiAuthTypeFromScanResult(r14)).setApType(0).setApStandard(r14.getWifiStandard()).build());
        r8.add(new WifiStandardData.Builder().setTimestamp(System.currentTimeMillis()).setSsid(r14.SSID).setBssid(r14.BSSID).setFrequency(r14.frequency).setBand(r13).setRssi(r14.level).setSignalLevel(WifiManager.calculateSignalLevel(r14.level, 5)).setAuthType(CaelibUtils.getWiFiAuthTypeFromScanResult(r14)).setApType(0).setApStandard(-1).build());
        goto L3
    L13:
        UserAwareManager.getInstance().notifyInnerCallbacks(new com.obric.cae.location.geofence.a(r13), r11);
        UserAwareManager.getInstance().notifyCallbacks(new o(4), r8);
    }

    private void onNetworkLocationReceivedAfterMovement() {
        int r8 = this.mLatestStepsCounter.get();
        if (r8 < 0) goto L6;
        this.mStepsCounterBaseline.set(r8);
    L6:
        if (isLargeMovementHarStatus(this.mLatestHarStatus.get()) == false) goto L9;
        CommSenseLog.dWithMethodName(TAG, "skip resume nlp wifi cache, harStatus still indicates large movement: " + this.mLatestHarStatus.get());
        return;
    L9:
        this.mHasUserMovedByHar.set(false);
        if (this.mDisableNlpWifiCacheByMovement.compareAndSet(true, false) == true) goto L12;
        return;
    L12:
        CommSenseLog.dWithMethodName(TAG, "received fresh network location, resume nlp wifi cache");
        setDisableNlpWifiCache(false);
    }

    private void processLocationUpdate(Location r8, int r10) {
        CommSenseLog.vWithMethodName(TAG, "start");
        if (r8 != null) goto L7;
        CommSenseLog.eWithMethodName(TAG, "location is null");
        return;
    L7:
        if (this.mForbidMockLocation.get() == false) goto L13;
        if (r8.isMock() == false) goto L13;
        CommSenseLog.vWithMethodName(TAG, "skip mock location");
        return;
    L13:
        if (checkGpoLocation(r8) == true) goto L16;
        CommSenseLog.vWithMethodName(TAG, "skip gpo location");
        return;
    L16:
        Location r11 = StarLocationManager.getInstance().copyLocationWithConfidence(r8);
        LocationAwareInfoManager.getInstance(this.mContext).handleLocationUpdate(r11);
        if ("network".equals(r11.getProvider()) == false) goto L20;
        onNetworkLocationReceivedAfterMovement();
    L20:
        if (StarLocationManager.getInstance().updateLatest(r10, r11, this.mCurrentUserId.get()) == true) goto L23;
        CommSenseLog.vWithMethodName(TAG, "skip same location");
        return;
    L23:
        maybeResolveAndPersistAddress(r11);
        UserAwareManager.getInstance().notifyInnerCallbacks(new s(4), r11);
    }

    private void recordBdResult(int r8, float r10, Location r11) {
        CommSenseLog.dWithMethodName(TAG, "BD check finished, status=" + r8 + ", confidence=" + r10 + ", location=" + r11);
        this.mBdIndoorCheckStatus.set(r8);
        this.mBdIndoorConfidence = r10;
        if (r11 == null) goto L5;
        this.mIndoorCheckReportLocation = r11;
    L5:
        checkAllFinished();
    }

    private void recordGnssResult(String r8, int r10, Location r11) {
        CommSenseLog.dWithMethodName(TAG, r8 + " check finished, status=" + r10 + ", location=" + r11);
        this.mGnssIndoorCheckStatus.set(r10);
        if (r11 == null) goto L5;
        this.mIndoorCheckReportLocation = r11;
    L5:
        checkAllFinished();
    }

    private void registerUserLifecycleReceiver() {
        if (this.mContext != null) goto L5;
        return;
    L5:
        if (this.mUserLifecycleReceiverRegistered.compareAndSet(false, true) == false) goto L10;
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.USER_SWITCHED");
        r8.addAction("android.intent.action.USER_UNLOCKED");
        r8.addAction("android.intent.action.SCREEN_ON");
        r8.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mUserLifecycleReceiver, r8);
        return;
    }

    private void registerWifiScan() {
        CommSenseLog.dWithMethodName(TAG, "");
        this.mContext.registerReceiver(this.mWifiScanReceiver, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
    }

    private void removeSingleLocationUpdates(LocationListener r8, String r10) {
        LocationManager r11 = this.mLocationManager;
        if (r11 != null) goto L10;
        return;
    L10:
        r11.removeUpdates(r8);     // Catch: RuntimeException -> L7
        return;
    L7:
        e = move-exception;
        StringBuilder r12 = defpackage.b.h("remove requestSingleUpdate listener failed: ", r10, ", ");
        r12.append(e.getMessage());
        CommSenseLog.e(TAG, r12.toString());
    }

    private int resolveInitialCurrentUserId() {
        Object r8 = ActivityManager.class.getMethod("getCurrentUser", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L9
        if ((r8 instanceof Integer) == true) goto L6;
    L10:
        return 0;
    L6:
        if (((Integer) r8).intValue() < 0) goto L10;
        int r10 = ((Integer) r8).intValue();     // Catch: Throwable -> L9
        CommSenseLog.dWithMethodName(TAG, "success, userId: " + r10);     // Catch: Throwable -> L9
        return r10;
    L9:
        CommSenseLog.wWithMethodName(TAG, "fallback to system user");
        goto L10
    }

    private void runIndoorCheckWithBdLocation() {
        BDLocation r8 = BdLocationManager.getInstance().getLocationSync(true, "runIndoorCheck", BdLocationManager.LOCATION_TIMEOUT);     // Catch: Throwable -> L27
        if (r8 != null) goto L7;
        CommSenseLog.dWithMethodName(TAG, " bdLocation is null");     // Catch: Throwable -> L27
        this.mBdIndoorCheckFinished.set(true);     // Catch: Throwable -> L27
        checkAllFinished();     // Catch: Throwable -> L27
        return;
    L7:
        int r10 = r8.getInOutDoorStatus();     // Catch: Throwable -> L27
        float r11 = r8.getInOutDoorConfidence();     // Catch: Throwable -> L27
        CommSenseLog.dWithMethodName(TAG, "bd indoorOutdoorStatus=" + r10 + ", inOutDoorConfidence=" + r11);     // Catch: Throwable -> L27
        if (r10 != 0) goto L11;
        this.mBdIndoorCheckFinished.set(true);     // Catch: Throwable -> L27
        checkAllFinished();     // Catch: Throwable -> L27
        return;
    L11:
        Location r12 = bdToAndroidLocation(r8);     // Catch: Throwable -> L27
        if (r10 == 2) goto L14;
        if (r10 == 1) goto L18;
        this.mBdIndoorCheckFinished.set(true);     // Catch: Throwable -> L27
        checkAllFinished();     // Catch: Throwable -> L27
        return;
    L18:
        if (Float.compare(r11, INDOOR_CONFIDENCE_THRESHOLD) > 0) goto L22;
        CommSenseLog.dWithMethodName(TAG, "BD indoor confidence <= 0.5, use BD result");     // Catch: Throwable -> L27
        if (this.mBdIndoorCheckFinished.compareAndSet(false, true) == true) goto L15;
        return;
    L15:
        recordBdResult(r10, r11, r12);     // Catch: Throwable -> L27
        return;
    L22:
        CommSenseLog.dWithMethodName(TAG, "BD indoor confidence > 0.5, wait for GNSS result");     // Catch: Throwable -> L27
        if (this.mBdIndoorCheckFinished.compareAndSet(false, true) == true) goto L15;
        return;
    L14:
        if (this.mBdIndoorCheckFinished.compareAndSet(false, true) == true) goto L15;
        return;
    L27:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, " failed", th);
        this.mBdIndoorCheckFinished.set(true);
        checkAllFinished();
    }

    private void scheduleRequestSingleLocationTimeout(final LocationListener r10, final AtomicBoolean r11, final String r12, final long r13) {
        this.mExecutor.execute(new a(this, r13, r11, r10, r12));
    }

    private void setIsNetworkValid(boolean r8) {
        AtomicBoolean r10 = this.mIsNetworkValid;
        monitor-enter(r10);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsNetworkValid.get() != r8) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L14
        return;
    L8:
        this.mIsNetworkValid.set(r8);     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        CommSenseLog.dumpI(TAG, "setIsNetworkValid: " + r8, CommSenseLog.getRecordFile("geofence"));
        UserAwareManager.getInstance().notifyInnerCallbacks(new o(3), Boolean.valueOf(r8));
        if (r8 == false) goto L18;
        getExecutor().execute(new j(this, 21));
        return;
    }

    private void setWifiConnected(boolean r8) {
        if (this.mIsWifiConnected.get() != r8) goto L5;
        return;
    L5:
        this.mIsWifiConnected.set(r8);
        if (r8 == false) goto L10;
        WifiManager r10 = this.mWifiManager;
        if (r10 == null) goto L10;
        String r11 = r10.getConnectionInfo().getSSID();
    L11:
        UserManager r12 = (UserManager) this.mContext.getSystemService("user");
        if (r12 == null) goto L17;
        Iterator<UserHandle> r13 = r12.getUserProfiles().iterator();
    L15:
        if (r13.hasNext() == false) goto L18;
        UserHandle r14 = r13.next();
        StarZppManager.getInstance(this.mContext, r14.getIdentifier()).setWifiConnected(r8);
    L18:
        StringBuilder r15 = new StringBuilder("setWifiConnected: ");
        r15.append(r8);
        if (r11 == null) goto L21;
        String r16 = ", ssid: ".concat(r11);
    L22:
        r15.append(r16);
        CommSenseLog.dumpI(TAG, r15.toString(), CommSenseLog.getRecordFile("geofence"));
        return;
    L21:
        r16 = "";
        goto L22
    L17:
        StarZppManager.getInstance(this.mContext, 0).setWifiConnected(r8);
    L10:
        r11 = null;
        goto L11
    }

    private void startIndoorCheckSession() {
        this.mIndoorCheckRunning.set(true);
        this.mIndoorCheckReported.set(false);
        this.mGnssIndoorCheckFinished.set(false);
        this.mBdIndoorCheckFinished.set(false);
        this.mGnssCheckIndoorCount.set(0);
        this.mGnssCheckOutdoorCount.set(0);
        this.mIndoorCheckLocation.set(null);
        this.mBdIndoorCheckStatus.set(0);
        this.mBdIndoorConfidence = 0.0f;
        this.mIndoorCheckReportLocation = null;
        this.mGnssIndoorCheckStatus.set(1);
    }

    private void stopIndoorCheckSession() {
        this.mIndoorCheckRunning.set(false);
        Future<?> r8 = this.mGnssTimeoutFuture.getAndSet(null);
        if (r8 == null) goto L6;
        r8.cancel(true);
        return;
    }

    private void syncLocationContext(String r8, int r10, boolean r11) {
        CommSenseLog.dWithMethodName(TAG, "reason: " + r8 + ", userId: " + r10);
        updateCurrentUserId(r8, r10);
        updateLocationContextForUser(r10, r11);
        ensureUserScopedManagers();
        if (this.mLocationUiEnabled.get() == false) goto L6;
        registerLocationListener();
        return;
    }

    private void testBdLocation() {
        Thread.sleep(2000);     // Catch: InterruptedException -> L5 Throwable -> L8
        testGetLocationSync();     // Catch: InterruptedException -> L5 Throwable -> L8
        goto L12
    L11:
        return;
    L5:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, " sleep failed", e);
        return;
    }

    private void testGetLocationSync() {
        CommSenseLog.d(TAG, "getLocationFromBdGeo start");
        BDLocation r8 = BdLocationManager.getInstance().getLocationSync(true, "getLocationFromBdGeo", BdLocationManager.LOCATION_TIMEOUT);
        CommSenseLog.d(TAG, "getLocationFromBdGeo, bdLocation: " + r8);
        Location r10 = getInstance().bdToAndroidLocation(r8);
        if (r10 == null) goto L5;
        String r11 = "getLocationFromBdGeo success, location: " + r10;
    L6:
        CommSenseLog.d(TAG, r11);
        return;
    L5:
        r11 = "getLocationFromBdGeo failed";
        goto L6
    }

    private void testRunIndoorCheck() {
        StarLocationService r8 = StarLocationService.getService();
        if (r8 == null) goto L11;
        r8.getStarLocationServiceBinder().runIndoorCheck(30000);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        CommSenseLog.e(TAG, "runIndoorCheck failed", e);
        return;
    }

    private void testSearchDirectionByDriving() {
        BdLocationManager.BmapDrivingDirectionRequest r8 = new BdLocationManager.BmapDrivingDirectionRequest("39.963959,116.400551", "39.950022,116.444963");
        r8.coordType = LocationInfoConst.WGS_84;
        r8.alternatives = 1;
        logDirectionBundle(BdLocationManager.getInstance().searchDirectionFromBmap(r8, 2));
    }

    private void testSearchDirectionByRiding() {
        BdLocationManager.BmapRidingDirectionRequest r8 = new BdLocationManager.BmapRidingDirectionRequest("39.963959,116.400551", "39.950022,116.444963");
        logDirectionBundle(BdLocationManager.getInstance().searchDirectionFromBmap(r8, 4));
    }

    private void testSearchDirectionByTransit() {
        BdLocationManager.BmapTransitDirectionRequest r8 = new BdLocationManager.BmapTransitDirectionRequest("39.963959,116.400551", "39.950022,116.444963");
        logDirectionBundle(BdLocationManager.getInstance().searchDirectionFromBmap(r8, 1));
    }

    private void testSearchDirectionByWalking() {
        BdLocationManager.BmapWalkingDirectionRequest r8 = new BdLocationManager.BmapWalkingDirectionRequest("39.963959,116.400551", "39.950022,116.444963");
        logDirectionBundle(BdLocationManager.getInstance().searchDirectionFromBmap(r8, 3));
    }

    private CoordinateTransformUtils.CoordinateSystem toTransformCoordinateSystem(byte r8) {
        if (r8 != 0) goto L6;
        return CoordinateTransformUtils.CoordinateSystem.WGS84;
    L6:
        if (r8 != 1) goto L10;
        return CoordinateTransformUtils.CoordinateSystem.GCJ02;
    L10:
        return CoordinateTransformUtils.CoordinateSystem.BD09;
    }

    private void updateCurrentUserId(String r8, int r10) {
        if (r10 >= 0) goto L5;
        r10 = 0;
    L5:
        int r11 = this.mCurrentUserId.getAndSet(r10);
        if (r11 == r10) goto L9;
        CommSenseLog.dWithMethodName(TAG, "reason: " + r8 + ", from: " + r11 + ", to: " + r10);
        return;
    }

    private void updateDisableNlpWifiCacheFlag() {
        updateDisableNlpWifiCacheFlag(null);
    }

    private void updateLocationContextForUser(int r8, boolean r10) {
        if (this.mContext != null) goto L6;
        return;
    L6:
        if (r8 >= 0) goto L9;
        r8 = 0;
    L9:
        if (r10 == false) goto L11;
    L15:
        Object r11 = this.mLocationRegistrationLock;
        monitor-enter(r11);
        if (r10 == false) goto L40;
    L24:
        LocationManager r12 = this.mLocationManager;     // Catch: Throwable -> L35
        if (r12 == null) goto L28;
        if (r10 == false) goto L28;
        r12.removeUpdates(this.mPassiveLocationListener);     // Catch: Throwable -> L35
        r12.unregisterGnssStatusCallback(this.mGnssStatusCallback);     // Catch: Throwable -> L35
    L28:
        Context r13 = this.mContext;     // Catch: Throwable -> L35
        r13 = r13.createContextAsUser(UserHandle.of(r8), 0);     // Catch: Exception -> L31 Throwable -> L35
    L32:
        this.mLocationManager = (LocationManager) r13.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L35
        this.mActiveLocationUserId.set(r8);     // Catch: Throwable -> L35
        CommSenseLog.dWithMethodName(TAG, "success, userId: " + r8 + ", locationContextUserBound: true");     // Catch: Throwable -> L35
        monitor-exit(r11);     // Catch: Throwable -> L35
        return;
    L31:
        CommSenseLog.wWithMethodName(TAG, "fallback to app context, userId: " + r8);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    L40:
        if (r8 != this.mActiveLocationUserId.get()) goto L24;
        if (this.mLocationManager == null) goto L24;
        monitor-exit(r11);     // Catch: Throwable -> L35
        return;
    L11:
        if (r8 != this.mActiveLocationUserId.get()) goto L15;
        if (this.mLocationManager == null) goto L15;
    }

    public Location bdToAndroidLocation(BDLocation r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (r8.getLocationType() != 1) goto L8;
        String r10 = CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS;
    L9:
        Location r11 = new Location(r10);
        r11.setLatitude(r8.getLatitude());
        r11.setLongitude(r8.getLongitude());
        r11.setTime(r8.getLocationMs());
        r11.setElapsedRealtimeNanos(r8.getElapsedRealtimeNanos());
        r11.setMock(r8.isMock());
        float r12 = r8.getAccuracy();
        if (r12 != 0.0f) goto L12;
        r12 = BD_LOCATION_DEFAULT_ACCURACY;
    L12:
        r11.setAccuracy(r12);
        if (LocationInfoConst.GCJ_O2.equalsIgnoreCase(r8.getCoordinateSystem()) == true) goto L15;
        return r11;
    L15:
        return CoordinateTransformUtils.convertLocation(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r11);
    L8:
        r10 = "network";
        goto L9
    }

    public double calculateCircleIntersectionRatio(double r29, double r31, double r33, double r35, double r37, double r39) {
        if (isValidCoordinate(r29, r31) == true) goto L5;
        return 0.0d;
    L5:
        if (isValidCoordinate(r35, r37) == true) goto L7;
        return 0.0d;
    L7:
        if (r33 > 0.0d) goto L9;
        return 0.0d;
    L9:
        if (r39 <= 0.0d) goto L32;
        double r14 = calculateDistance(r29, r31, r35, r37);
        if (Double.isNaN(r14) == false) goto L14;
        return 0.0d;
    L14:
        if (Double.isInfinite(r14) == false) goto L17;
        return 0.0d;
    L17:
        if (r14 < (r33 + r39)) goto L19;
        return 0.0d;
    L19:
        double r16 = Math.min(r33, r39);
        if (r14 > Math.abs(r33 - r39)) goto L23;
        return 1.0d;
    L23:
        double r18 = r33 * r33;
        double r20 = r39 * r39;
        double r22 = r14 * r14;
        double r24 = r14 * 2.0d;
        double r26 = Math.acos(clamp(((r22 + r18) - r20) / (r24 * r33), -1.0d, 1.0d));
        double r8 = Math.acos(clamp(((r22 + r20) - r18) / (r24 * r39), -1.0d, 1.0d));
        double r11 = r14 + r33;
        double r23 = r11 - r39;
        double r25 = r23 * (((-r14) + r33) + r39);
        double r12 = r11 + r39;
        double r21 = r20 * r8;
        double r27 = r21 + (r18 * r26);
        double r28 = r27 - (Math.sqrt(Math.max(0.0d, r12 * (((r14 - r33) + r39) * r25))) * 0.5d);
        double r10 = (3.141592653589793d * r16) * r16;
        if (r10 > 0.0d) goto L26;
        return 0.0d;
    L26:
        return clamp(r28 / r10, 0.0d, 1.0d);
    L32:
        return 0.0d;
    }

    public double calculateDistance(double r38, double r40, double r42, double r44) {
        double r8 = Math.toRadians(r38);
        double r10 = Math.toRadians(r42);
        double r11 = Math.toRadians(r44 - r40);
        double r12 = Math.atan(Math.tan(r8) * 0.996647189328169d);
        double r13 = Math.atan(Math.tan(r10) * 0.996647189328169d);
        double r14 = Math.sin(r12);
        double r15 = Math.cos(r12);
        double r16 = Math.sin(r13);
        double r17 = Math.cos(r13);
        int r18 = 0;
        double r19 = r11;
        double r110 = 0.0d;
        double r111 = 0.0d;
        double r112 = 0.0d;
        double r21 = 0.0d;
        double r23 = 0.0d;
    L4:
        if (r18 >= 20) goto L17;
        double r113 = Math.sin(r19);
        double r114 = Math.cos(r19);
        int r39 = r18;
        double r41 = r19;
        double r43 = r11;
        double r20 = Math.hypot(r17 * r113, (r15 * r16) - ((r14 * r17) * r114));
        double r115 = r15 * r17;
        double r116 = (r14 * r16) + (r114 * r115);
        r112 = Math.atan2(r20, r116);
        double r117 = r115 * r113;
        if (r20 != 0.0d) goto L8;
        double r118 = 1.0d;
    L9:
        double r119 = r117 / r118;
        r21 = 1.0d - (r119 * r119);
        double r120 = (r14 * 2.0d) * r16;
        if (r21 != 0.0d) goto L12;
        double r24 = 1.0d;
    L13:
        r23 = r116 - (r120 / r24);
        double r33 = (((4.0d - (3.0d * r21)) * 0.0033528106718309896d) + 4.0d) * (2.0955066698943685E-4d * r21);
        double r35 = ((((((((r23 * 2.0d) * r23) - 1.0d) * (r33 * r116)) + r23) * (r33 * r20)) + r112) * (((1.0d - r33) * 0.0033528106718309896d) * r119)) + r43;
        if (Math.abs(r35 - r41) < 1.0E-12d) goto L15;
        r110 = r20;
        r111 = r116;
        r18 = r39 + 1;
        r11 = r43;
        r19 = r35;
        goto L4
    L15:
        r110 = r20;
        r111 = r116;
        goto L17
    L12:
        r24 = r21;
        goto L13
    L8:
        r118 = r20;
    L17:
        double r22 = (r21 * 2.723316066819453E11d) / 4.0408299984087055E13d;
        double r25 = (((((74.0d - (47.0d * r22)) * r22) - 128.0d) * r22) + 256.0d) * (r22 / 1024.0d);
        double r29 = ((4.0d * r23) * r23) - 3.0d;
        return (r112 - ((((((((2.0d * r23) * r23) - 1.0d) * r111) - (r29 * ((((r110 * 4.0d) * r110) - 3.0d) * ((r25 / 6.0d) * r23)))) * (r25 / 4.0d)) + r23) * (r25 * r110))) * ((((((((320.0d - (175.0d * r22)) * r22) - 768.0d) * r22) + 4096.0d) * (r22 / 16384.0d)) + 1.0d) * 6356752.3142d);
    }

    public Location convertInputCoordinateIfNeeded(double r8, double r10, byte r11, byte r12) {
        if (getInstance().isValidCoordinate(r8, r10) == true) goto L6;
        CommSenseLog.eWithMethodName(TAG, "invalid coordinate");
        return null;
    L6:
        Location r13 = new Location("network");
        r13.setLatitude(r8);
        r13.setLongitude(r10);
        if (r11 != r12) goto L9;
        return r13;
    L9:
        Location r14 = CoordinateTransformUtils.convertLocation(toTransformCoordinateSystem(r11), toTransformCoordinateSystem(r12), r13);
        if (r14 != null) goto L12;
        CommSenseLog.eWithMethodName(TAG, "coordinate transform failed");
    L12:
        return r14;
    }

    @SuppressLint({"NewApi"})
    public StarGeofence createStarGeofenceFromAddress(String r10, String r11, StarGeofence.GeoType r12) {
        if (this.mIsNetworkValid.get() == true) goto L7;
        String r13 = "network is invalid";
    L5:
        CommSenseLog.eWithMethodName(TAG, r13);
        return null;
    L7:
        if (r10 != null) goto L9;
    L23:
        r13 = "invalid address or geofenceId";
        goto L5
    L9:
        if (r10.isEmpty() == true) goto L23;
        if (r11 == null) goto L23;
        if (r11.isEmpty() == true) goto L23;
        Address r14 = AddressGeocodeUtils.resolveFirstAddress(this.mContext, r10, TimeUnit.SECONDS.toMillis(1), TAG, "createStarGeofenceFromAddress");
        if (r14 != null) goto L17;
        return null;
    L17:
        Location r8 = new Location("network");
        r8.setLatitude(r14.getLatitude());
        r8.setLongitude(r14.getLongitude());
        Location r15 = CoordinateTransformUtils.convertLocation(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r8);
        StarGeofence r16 = new StarGeofence();
        r16.setPackageName("com.larus.nova");
        r16.setGeofenceId(r11);
        r16.setLatitude(r15.getLatitude());
        r16.setLongitude(r15.getLongitude());
        r16.setRadius(getRadiusByGeofenceId(r11));
        r16.setGeoType(r12);
        r16.setTransitionType(StarGeofence.GeoTransitionType.ENTERED_AND_EXITED);
        String r17 = r14.getAddressLine(0);
        if (r17 != null) goto L20;
    L22:
        return r16;
    L20:
        if (r17.isEmpty() == true) goto L22;
        r16.setAddress(r17);
        goto L22
    }

    public boolean ensureCloudTransCryptoManagerReady() {
        if (sIsCryptoInit == false) goto L6;
        return true;
    L6:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L9;
        CommSenseLog.wWithMethodName(TAG, "skip waiting on main thread");
        getExecutor().execute(new c(this, 1));
        return false;
    L9:
        initCloudTransCryptoManager();
        if (sIsCryptoInit == false) goto L12;
        return true;
    L12:
        CountDownLatch r8 = sCryptoInitLatch.get();
        if (r8 != null) goto L15;
        return false;
    L15:
        long r10 = SystemClock.elapsedRealtime();
    L22:
        e = move-exception;
        Thread.currentThread().interrupt();
        CommSenseLog.eWithMethodName(TAG, "Crypto SDK init wait interrupted", e);
        return false;
    L17:
        if (r8.await(CRYPTO_INIT_WAIT_TIMEOUT_MS, TimeUnit.MILLISECONDS) == true) goto L21;
        CommSenseLog.eWithMethodName(TAG, "Crypto SDK init wait timeout, costMs=" + (SystemClock.elapsedRealtime() - r10));     // Catch: InterruptedException -> L22
        return false;
    L21:
        return sIsCryptoInit;
    }

    public String formatCoordinate6(double r8, double r10) {
        return String.format(Locale.US, "%.6f,%.6f", new Object[]{Double.valueOf(r8), Double.valueOf(r10)});
    }

    public void generatePrivacyIdAttestationCert() {
        if (isPrivacyIdAttestationCertCacheValid(SystemClock.elapsedRealtime()) == false) goto L5;
        return;
    L5:
        Object r8 = this.mPrivacyIdAttestationCertLock;
        monitor-enter(r8);
        long r10 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14
        if (isPrivacyIdAttestationCertCacheValid(r10) == false) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L14
        return;
    L11:
        generatePrivacyIdAttestationCertLocked(r10);     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @SuppressLint({"NewApi"})
    public Location getCurLocation(String r12, boolean r13, String r14) {
        LocationManager r8 = this.mLocationManager;
        if (r8 != null) goto L5;
    L42:
        CommSenseLog.eWithMethodName(TAG, "mLocationManager is null or provider is disabled");
        return null;
    L5:
        if (r8.isProviderEnabled(r12) == false) goto L42;
        if ("network".equalsIgnoreCase(r12) == true) goto L10;
    L13:
        long r10 = System.currentTimeMillis();
        final String r15 = r14 + "_" + r10;
        if (r13 == false) goto L20;
    L15:
        long r11 = this.mLastAsyncGetCurLocationMs.get();
        if ((r10 - r11) < ASYNC_REQ_WINDOW_MS) goto L17;
        if (this.mLastAsyncGetCurLocationMs.compareAndSet(r11, r10) == false) goto L15;
    L17:
        return null;
    L20:
        CommSenseLog.dWithMethodName(TAG, r12 + ", source: " + r15 + ", async=" + r13);
        final AtomicReference r16 = new AtomicReference(null);
        final CountDownLatch r17 = new CountDownLatch(1);
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L23;
    L26:
        this.mLocationManager.getCurrentLocation(r12, null, this.mExecutor, new b(this, r15, r17, r16));
        if (r13 == false) goto L44;
        return null;
    L44:
    L39:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "interrupted exception: " + e.getMessage());
        return null;
    L30:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r12) == false) goto L32;
        int r18 = BWDLInnerConstant.DATA_LINK_TOUT;
    L34:
        if (r17.await(r18, TimeUnit.SECONDS) == true) goto L38;
        CommSenseLog.eWithMethodName(TAG, "timeout: " + r18);     // Catch: InterruptedException -> L39
        return null;
    L38:
        return (Location) r16.get();
    L32:
        r18 = 5000;
        goto L34
    L23:
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L26;
        CommSenseLog.eWithMethodName(TAG, "location permission not granted");
        return null;
    L10:
        if (this.mIsNetworkValid.get() == true) goto L13;
        CommSenseLog.dWithMethodName(TAG, "getNetworkLocation: network is invalid");
        return null;
    }

    public int getCurrentUserId() {
        return this.mCurrentUserId.get();
    }

    public ExecutorService getExecutor() {
        return this.mExecutor;
    }

    public Location getLastDeliveredLocation() {
        Location r8 = this.mLastDeliveredLocation.get();
        if (r8 != null) goto L6;
        return null;
    L6:
        return new Location(r8);
    }

    public String getPrivacyIdAttestationCert() {
        generatePrivacyIdAttestationCert();
        return this.mPrivacyIdAttestationCert;
    }

    public int getSimCardState(Context r8) {
        TelephonyManager r10 = this.mTelephonyManager;
        if (r10 == null) goto L7;
        return r10.getSimState();
    L7:
        if (this.mContext != null) goto L14;
        CommSenseLog.eWithMethodName(TAG, "mContext is null");
        if (r8 != null) goto L11;
        return 0;
    L11:
        Context r11 = r8.getApplicationContext();
        this.mContext = r11;
        if (r11 != null) goto L14;
        return 0;
    L14:
        TelephonyManager r12 = (TelephonyManager) this.mContext.getSystemService("phone");
        this.mTelephonyManager = r12;
        if (r12 != null) goto L19;
        CommSenseLog.eWithMethodName(TAG, "TelephonyManager is null");
        return 0;
    L19:
        return r12.getSimState();
    }

    public File getStarDir(Context r8) {
        File r10 = new File(r8.getFilesDir(), STAR_DIR);
        if (r10.exists() == true) goto L5;
        r10.mkdirs();
    L5:
        return r10;
    }

    public boolean hasLargeMovement() {
        if (hasLargeStepMovement() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mHasUserMovedByHar.get() == true) goto L8;
        return false;
    }

    public void initCloudTransCryptoManager() {
        if (this.mContext != null) goto L6;
        return;
    L6:
        if (sIsCryptoInit == true) goto L62;
        CommSenseLog.dWithMethodName(TAG, "start");
        if (isNetworkValid() == true) goto L10;
        return;
    L10:
        CountDownLatch r8 = new CountDownLatch(1);
        AtomicReference<CountDownLatch> r10 = sCryptoInitLatch;
    L12:
        if (r10.compareAndSet(null, r8) == true) goto L13;
        if (r10.get() == null) goto L12;
        boolean r11 = false;
    L17:
        if (r11 == true) goto L20;
        CommSenseLog.dWithMethodName(TAG, "Crypto SDK init in progress");
        return;
    L20:
        long r12 = SystemClock.elapsedRealtime();
    L29:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "Crypto SDK init failed, costMs=" + (SystemClock.elapsedRealtime() - r12), th);     // Catch: Throwable -> L54
        r8.countDown();
        AtomicReference<CountDownLatch> r13 = sCryptoInitLatch;
    L49:
        if (r13.compareAndSet(r8, null) == true) goto L62;
        if (r13.get() == r8) goto L49;
    L54:
        th = move-exception;
        r8.countDown();
        AtomicReference<CountDownLatch> r14 = sCryptoInitLatch;
    L57:
        if (r14.compareAndSet(r8, null) == true) goto L61;
        if (r14.get() == r8) goto L57;
    L61:
        throw th;
    L22:
        if (sIsCryptoInit == true) goto L39;
        String r15 = MatrixDidUtils.getDid();     // Catch: Throwable -> L29
        if (r15 != null) goto L26;
    L31:
        CommSenseLog.eWithMethodName(TAG, "did is null or empty");     // Catch: Throwable -> L29
        r8.countDown();
        AtomicReference<CountDownLatch> r16 = sCryptoInitLatch;
    L34:
        if (r16.compareAndSet(r8, null) == true) goto L38;
        if (r16.get() == r8) goto L34;
        return;
    L38:
        return;
    L26:
        if (r15.isEmpty() == true) goto L31;
        n6.b.e().f(this.mContext, PRIVACY_ATTESTATION_APP_ID, r15, new AnonymousClass8(this), false);     // Catch: Throwable -> L29
        sIsCryptoInit = true;     // Catch: Throwable -> L29
        CommSenseLog.iWithMethodName(TAG, "Crypto SDK initialized successfully, costMs=" + (SystemClock.elapsedRealtime() - r12));     // Catch: Throwable -> L29
        CommSenseLog.dumpI(TAG, "device_id: " + r15, CommSenseLog.getRecordFile("geofence"));     // Catch: Throwable -> L29
    L39:
        r8.countDown();
        AtomicReference<CountDownLatch> r17 = sCryptoInitLatch;
    L41:
        if (r17.compareAndSet(r8, null) == true) goto L62;
        if (r17.get() == r8) goto L41;
    L13:
        r11 = true;
    L62:
        generatePrivacyIdAttestationCert();
    }

    @SuppressLint({"NewApi"})
    public void initOnce(Context r8) {
        this.mContext = r8;
        sProductDevice = SystemProperties.get("ro.product.product.device", "");
        getExecutor().execute(new c(this, 0));
        int r10 = resolveInitialCurrentUserId();
        updateLocationContextForUser(r10, false);
        this.mWarmModeManager = StarWarmModeManager.getInstance(this.mContext);
        registerUserLifecycleReceiver();
        syncLocationContext("init", r10, false);
        Uri r11 = Settings.Secure.getUriFor(LocationMonitorConst.LOCATION_MODE);
        if (r11 == null) goto L5;
        final Handler r12 = null;
        this.mContext.getContentResolver().registerContentObserver(r11, false, new AnonymousClass7(this, r12));
    L5:
        Uri r13 = Settings.Global.getUriFor(DISABLE_NLP_WIFI_CACHE);
        if (r13 == null) goto L8;
        this.mContext.getContentResolver().registerContentObserver(r13, false, this.mDisableNlpWifiCacheObserver);
    L8:
        Uri r14 = Settings.Global.getUriFor(DISABLE_NLP_WIFI_CACHE_ALWAYS);
        if (r14 == null) goto L11;
        this.mContext.getContentResolver().registerContentObserver(r14, false, this.mDisableNlpWifiCacheObserver);
    L11:
        boolean r15 = this.mLocationManager.isLocationEnabled();
        this.mLocationUiEnabled.set(r15);
        if (r15 == false) goto L14;
        registerLocationListener();
    L14:
        CommSenseLog.v(TAG, "setWarmMode success: " + this.mWarmModeManager.setWarmMode(r15));
        initNetworkInfo();
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
        this.mWifiManager = (WifiManager) r8.getSystemService("wifi");
        registerWifiScan();
        UserAwareManager.getInstance().registerInnerCallback(this.mMovementAwareCallback);
        updateDisableNlpWifiCacheFlag();
        checkMockLocationFlag();
    }

    public void invalidatePrivacyIdAttestationCert() {
        Object r8 = this.mPrivacyIdAttestationCertLock;
        monitor-enter(r8);
        clearPrivacyIdAttestationCertCache();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isDisableNlpWifiCache() {
        return this.mDisableNlpWifiCache.get();
    }

    public boolean isForbidMockLocation() {
        return this.mForbidMockLocation.get();
    }

    public boolean isIndoorCheckRunning() {
        return this.mIndoorCheckRunning.get();
    }

    public boolean isLocationUiEnabled() {
        return this.mLocationUiEnabled.get();
    }

    public boolean isNetworkValid() {
        return this.mIsNetworkValid.get();
    }

    public boolean isSameLocation(Location r8, Location r10) {
        if (r8 == null) goto L18;
        if (r10 != null) goto L7;
        return false;
    L7:
        if (Double.compare(r8.getLatitude(), r10.getLatitude()) == 0) goto L9;
        return false;
    L9:
        if (Double.compare(r8.getLongitude(), r10.getLongitude()) == 0) goto L11;
        return false;
    L11:
        if (r8.hasAccuracy() == r10.hasAccuracy()) goto L13;
        return false;
    L13:
        if (r8.hasAccuracy() == true) goto L15;
    L16:
        return true;
    L15:
        if (Float.compare(r8.getAccuracy(), r10.getAccuracy()) == 0) goto L16;
        return false;
    L18:
        return false;
    }

    public boolean isScreenOn() {
        return this.mIsScreenOn.get();
    }

    public boolean isSimReady() {
        if (getSimCardState(this.mContext) != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidCoordinate(double r8, double r10) {
        if (Double.isNaN(r8) == false) goto L5;
    L15:
        return false;
    L5:
        if (Double.isNaN(r10) == true) goto L15;
        if (r8 < (-90.0d)) goto L15;
        if (r8 > 90.0d) goto L15;
        if (r10 < (-180.0d)) goto L15;
        if (r10 > 180.0d) goto L15;
        return true;
    }

    public boolean isWifiConnected() {
        return this.mIsWifiConnected.get();
    }

    @SuppressLint({"NewApi"})
    public void registerLocationListener() {
        if (this.mLocationUiEnabled.get() == true) goto L7;
        CommSenseLog.dWithMethodName(TAG, "mLocationUiEnabled is false");
        return;
    L7:
        if (this.mLocationManager != null) goto L10;
        CommSenseLog.eWithMethodName(TAG, "locationManager is null");
        return;
    L10:
        Object r8 = this.mLocationRegistrationLock;
        monitor-enter(r8);
    L26:
        th = move-exception;
        throw th;
    L13:
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L15;
    L20:
        this.mLocationManager.requestLocationUpdates("passive", 0, 0.0f, this.mExecutor, this.mPassiveLocationListener);     // Catch: Throwable -> L26
        CommSenseLog.dWithMethodName(TAG, "register passive location listener success, userId: " + this.mActiveLocationUserId.get());     // Catch: Throwable -> L26
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L23;
        this.mLocationManager.registerGnssStatusCallback(this.mExecutor, this.mGnssStatusCallback);     // Catch: Throwable -> L26
        CommSenseLog.dWithMethodName(TAG, "register gnss status callback success, userId: " + this.mActiveLocationUserId.get());     // Catch: Throwable -> L26
    L24:
        monitor-exit(r8);     // Catch: Throwable -> L26
        return;
    L23:
        CommSenseLog.eWithMethodName(TAG, "fine location permission not satisfied");     // Catch: Throwable -> L26
        goto L24
    L15:
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L20;
        CommSenseLog.eWithMethodName(TAG, "coarse location permission not satisfied");     // Catch: Throwable -> L26
        monitor-exit(r8);     // Catch: Throwable -> L26
    }

    @SuppressLint({"MissingPermission"})
    public Location requestSingleLocationUpdates(String r20, boolean r21, String r22) {
        if (r20 != null) goto L5;
    L71:
        CommSenseLog.eWithMethodName(TAG, "provider is null or empty");
        return null;
    L5:
        if (r20.isEmpty() == true) goto L71;
        if (this.mContext == null) goto L69;
        LocationManager r8 = this.mLocationManager;
        if (r8 == null) goto L69;
    L66:
        e = move-exception;
        StringBuilder r10 = defpackage.b.h("invalid provider: ", r20, ", ");
        r10.append(e.getMessage());
        CommSenseLog.eWithMethodName(TAG, r10.toString());
        return null;
    L13:
        if (r8.isProviderEnabled(r20) == true) goto L17;
        CommSenseLog.eWithMethodName(TAG, "provider is disabled: ".concat(r20));     // Catch: IllegalArgumentException -> L66
        return null;
    L17:
        if ("network".equalsIgnoreCase(r20) == true) goto L19;
    L22:
        long r11 = SystemClock.elapsedRealtime();
        final String r12 = r22 + "_" + r11;
        long r13 = getRequestSingleLocationTimeoutMs(r20);
        CommSenseLog.dWithMethodName(TAG, r20 + ", source: " + r12 + ", async=" + r21);
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L25;
    L28:
        if (r21 == true) goto L30;
    L32:
        Looper r15 = getSingleLocationCallbackLooper();
        if (r15 != null) goto L35;
    L64:
        CommSenseLog.eWithMethodName(TAG, "single location callback looper is invalid");
        return null;
    L35:
        if (r15 == Looper.getMainLooper()) goto L64;
        final AtomicReference r14 = new AtomicReference(null);
        final CountDownLatch r16 = new CountDownLatch(1);
        final AtomicBoolean r17 = new AtomicBoolean(false);
        LocationListener r18 = new AnonymousClass12(this, r17, r12, r14, r16);
        this.mSingleRequestLocation.set(null);
        this.mSingleRequestPending.set(true);
        this.mLocationManager.requestSingleUpdate(r20, r18, r15);     // Catch: RuntimeException -> L61
        if (r21 == false) goto L73;
        scheduleRequestSingleLocationTimeout(r18, r17, r12, r13);
        return null;
    L73:
        if (r16.await(r13, TimeUnit.MILLISECONDS) == true) goto L53;
        boolean r19 = false;
        AtomicBoolean r23 = r17;
    L50:
        e = e;
    L57:
        if (r23.compareAndSet(r19, true) == false) goto L59;
        this.mSingleRequestLocation.set(null);
        this.mSingleRequestPending.set(r19);
        removeSingleLocationUpdates(r18, r12);
    L59:
        Thread.currentThread().interrupt();
        CommSenseLog.eWithMethodName(TAG, "interrupted exception: " + e.getMessage());
        return null;
    L46:
        if (r23.compareAndSet(false, true) == false) goto L48;
        this.mSingleRequestLocation.set(null);     // Catch: InterruptedException -> L50
        this.mSingleRequestPending.set(false);     // Catch: InterruptedException -> L50
        removeSingleLocationUpdates(r18, r12);     // Catch: InterruptedException -> L50
    L48:
        CommSenseLog.eWithMethodName(TAG, "timeout: " + r13);     // Catch: InterruptedException -> L50
        return null;
    L53:
        return (Location) r14.get();
    L54:
        e = e;
        r23 = r17;
        r19 = false;
    L61:
        e = move-exception;
        this.mSingleRequestLocation.set(null);
        this.mSingleRequestPending.set(false);
        CommSenseLog.eWithMethodName(TAG, "requestSingleUpdate failed: " + e.getMessage());
        return null;
    L30:
        if (markAsyncRequestSingleLocation(r11, r13) == true) goto L32;
        return null;
    L25:
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L28;
        CommSenseLog.eWithMethodName(TAG, "location permission not granted");
        return null;
    L19:
        if (this.mIsNetworkValid.get() == true) goto L22;
        CommSenseLog.eWithMethodName(TAG, "network is invalid");
        return null;
    L69:
        CommSenseLog.eWithMethodName(TAG, "mContext or mLocationManager is null");
        return null;
    }

    @SuppressLint({"NewApi"})
    public List<Address> resolveAddressByLocation(Location r14, boolean r15) {
        if (r14 != null) goto L5;
    L89:
        CommSenseLog.eWithMethodName(TAG, "invalid Location or invalid network");
        return Collections.emptyList();
    L5:
        if (this.mIsNetworkValid.get() == false) goto L89;
        CountDownLatch r8 = this.mInflightResolveLatch.get();
        Location r10 = this.mInflightResolvedLocation.get();
        if (r8 != null) goto L10;
    L22:
        Location r11 = this.mLastResolvedLocation.getAndSet(new Location(r14));
        List<Address> r12 = this.mLastResolvedAddress.get();
        if (r14.equals(r11) == false) goto L29;
        if (r12 == null) goto L29;
        if (r12.isEmpty() == true) goto L29;
        CommSenseLog.dWithMethodName(TAG, "location is same as last location");
        return r12;
    L29:
        CommSenseLog.encryptedI(TAG, getEncryptedModule(), CommSenseLog.getMethodName() + " " + r14, getEncryptedKey());
        Geocoder r13 = new Geocoder(this.mContext);
        final AtomicReference r16 = new AtomicReference(Collections.emptyList());
        final CountDownLatch r17 = new CountDownLatch(1);
        this.mInflightResolvedLocation.set(new Location(r14));
        this.mInflightResolveLatch.set(r17);
        r13.getFromLocation(r14.getLatitude(), r14.getLongitude(), 1, new AnonymousClass13(this, r16, r17));
    L50:
        th = move-exception;
        CountDownLatch r18 = this.mInflightResolveLatch.get();
        Location r19 = this.mInflightResolvedLocation.get();
        if (r18 == r17) goto L75;
    L88:
        throw th;
    L75:
        if (r14.equals(r19) == false) goto L88;
        AtomicReference<CountDownLatch> r110 = this.mInflightResolveLatch;
    L78:
        if (r110.compareAndSet(r18, null) == true) goto L82;
        if (r110.get() == r18) goto L78;
    L82:
        AtomicReference<Location> r111 = this.mInflightResolvedLocation;
    L84:
        if (r111.compareAndSet(r19, null) == true) goto L88;
        if (r111.get() != r19) goto L88;
    L52:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "interrupted: " + e.getMessage());     // Catch: Throwable -> L50
        CountDownLatch r112 = this.mInflightResolveLatch.get();
        Location r20 = this.mInflightResolvedLocation.get();
        if (r112 == r17) goto L57;
    L71:
        return (List) r16.get();
    L57:
        if (r14.equals(r20) == false) goto L71;
        AtomicReference<CountDownLatch> r113 = this.mInflightResolveLatch;
    L60:
        if (r113.compareAndSet(r112, null) == true) goto L64;
        if (r113.get() == r112) goto L60;
    L64:
        AtomicReference<Location> r21 = this.mInflightResolvedLocation;
    L66:
        if (r21.compareAndSet(r20, null) == true) goto L71;
        if (r21.get() == r20) goto L66;
    L31:
        if (r17.await(1, TimeUnit.SECONDS) == true) goto L33;
        CommSenseLog.eWithMethodName(TAG, "timeout");     // Catch: Throwable -> L50 InterruptedException -> L52
    L33:
        CountDownLatch r114 = this.mInflightResolveLatch.get();
        Location r22 = this.mInflightResolvedLocation.get();
        if (r114 != r17) goto L71;
        if (r14.equals(r22) == false) goto L71;
        AtomicReference<CountDownLatch> r115 = this.mInflightResolveLatch;
    L39:
        if (r115.compareAndSet(r114, null) == true) goto L43;
        if (r115.get() == r114) goto L39;
    L43:
        AtomicReference<Location> r23 = this.mInflightResolvedLocation;
    L45:
        if (r23.compareAndSet(r22, null) == true) goto L71;
        if (r23.get() == r22) goto L45;
    L10:
        if (r14.equals(r10) == false) goto L22;
    L15:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "coalesce interrupted: " + e.getMessage());
    L17:
        List<Address> r116 = this.mLastResolvedAddress.get();
        if (r116 == null) goto L21;
        return r116;
    L21:
        return Collections.emptyList();
    L12:
        if (r8.await(1, TimeUnit.SECONDS) == true) goto L17;
        CommSenseLog.eWithMethodName(TAG, "coalesce await timeout");     // Catch: InterruptedException -> L15
        goto L17
    }

    public void runIndoorCheck(long r8) {
        CommSenseLog.dWithMethodName(TAG, "called");
        this.mContext.enforceCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");     // Catch: SecurityException -> L10
        int r10 = 1;
        if (this.mIndoorCheckRunning.getAndSet(true) == false) goto L8;
        CommSenseLog.dWithMethodName(TAG, "ignored: already running");
        return;
    L8:
        startIndoorCheckSession();
        this.mIndoorCheckListener = new AnonymousClass11(this);
        getExecutor().execute(new com.google.android.material.datepicker.c(r10, this, r8));
        return;
    L10:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "permission error: " + e.getMessage());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v5 */
    public void setDisableNlpWifiCache(boolean r8) {
        if (this.mContext != null) goto L6;
        CommSenseLog.eWithMethodName(TAG, "mContext is null");
        return;
    L6:
        boolean r10 = this.mDisableNlpWifiCacheAlways.get();
        if (r8 == true) goto L11;
        if (r10 == true) goto L11;
        ?? r11 = 0;
    L13:
        if (this.mDisableNlpWifiCache.get() != r11) goto L16;
        CommSenseLog.dWithMethodName(TAG, "value=" + r11 + ", always=" + r10 + ", changed=false");
        return;
    L16:
        boolean r12 = Settings.Global.putInt(this.mContext.getContentResolver(), DISABLE_NLP_WIFI_CACHE, r11);
        if (r12 == false) goto L19;
        this.mDisableNlpWifiCache.set(r11);
    L19:
        CommSenseLog.iWithMethodName(TAG, "value=" + r11 + ", always=" + r10 + ", success=" + r12);
        return;
    L11:
        r11 = 1;
        goto L13
    }

    @SuppressLint({"NewApi"})
    public void startLocationRequest(String r10, LocationListener r11) {
        LocationManager r8 = this.mLocationManager;
        if (r8 != null) goto L5;
    L18:
        String r12 = "mLocationManager is null or provider is disabled";
    L12:
        CommSenseLog.eWithMethodName(TAG, r12);
        return;
    L5:
        if (r8.isProviderEnabled(r10) == false) goto L18;
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L10;
    L14:
        CommSenseLog.dWithMethodName(TAG, "hashCode: " + System.identityHashCode(r11));
        if (this.mListenerMap.putIfAbsent(System.identityHashCode(r11) + "_" + r10, r11) != null) goto L19;
        this.mLocationManager.requestLocationUpdates(r10, 1000, 0.0f, this.mExecutor, r11);
        return;
    L19:
        return;
    L10:
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L14;
        r12 = "location permission not satisfied";
        goto L12
    }

    public void stopLocationRequest(LocationListener r8) {
        CommSenseLog.dWithMethodName(TAG, "hashCode: " + System.identityHashCode(r8));
        Iterator<String> r10 = this.mListenerMap.keySet().iterator();
        boolean r11 = false;
    L4:
        if (r10.hasNext() == false) goto L11;
        String r12 = r10.next();
        if (r12.startsWith(System.identityHashCode(r8) + "_") == false) goto L4;
        this.mListenerMap.remove(r12);
        if (r11 == true) goto L10;
        this.mLocationManager.removeUpdates(r8);
    L10:
        r11 = true;
        goto L4
    }

    public void unregisterLocationListener() {
        Object r8 = this.mLocationRegistrationLock;
        monitor-enter(r8);
        CommSenseLog.dWithMethodName(TAG, "");     // Catch: Throwable -> L9
        LocationManager r10 = this.mLocationManager;     // Catch: Throwable -> L9
        if (r10 == null) goto L7;
        r10.removeUpdates(this.mPassiveLocationListener);     // Catch: Throwable -> L9
        this.mLocationManager.unregisterGnssStatusCallback(this.mGnssStatusCallback);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r8);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void updateDisableNlpWifiCacheFlag(Uri r8) {
        Uri r10 = Settings.Global.getUriFor(DISABLE_NLP_WIFI_CACHE_ALWAYS);
        boolean r11 = false;
        if (r8 == null) goto L7;
        if (r10 != null) goto L6;
    L12:
        boolean r12 = this.mDisableNlpWifiCacheAlways.get();
        int r13 = Settings.Global.getInt(this.mContext.getContentResolver(), DISABLE_NLP_WIFI_CACHE, 0);
        if (r12 == false) goto L16;
        if (r13 == 1) goto L16;
        Settings.Global.putInt(this.mContext.getContentResolver(), DISABLE_NLP_WIFI_CACHE, 1);
        r13 = 1;
    L16:
        if (r13 != 1) goto L18;
        r11 = true;
    L18:
        this.mDisableNlpWifiCache.set(r11);
        CommSenseLog.iWithMethodName(TAG, "mDisableNlpWifiCache: " + this.mDisableNlpWifiCache.get() + ", always=" + r12);
        return;
    L6:
        if (r10.equals(r8) == false) goto L12;
    L7:
        AtomicBoolean r14 = this.mDisableNlpWifiCacheAlways;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), DISABLE_NLP_WIFI_CACHE_ALWAYS, 0) != 1) goto L10;
        boolean r15 = true;
    L11:
        r14.set(r15);
        goto L12
    L10:
        r15 = false;
        goto L11
    }

    public CoordinateTransformUtils.CoordinateSystem toTransformCoordinateSystem(String r8) {
        if (LocationInfoConst.GCJ_O2.equalsIgnoreCase(r8) == false) goto L7;
        return CoordinateTransformUtils.CoordinateSystem.GCJ02;
    L7:
        if (LocationInfoConst.WGS_84.equalsIgnoreCase(r8) == false) goto L11;
        return CoordinateTransformUtils.CoordinateSystem.WGS84;
    L11:
        return CoordinateTransformUtils.CoordinateSystem.BD09;
    }
}
