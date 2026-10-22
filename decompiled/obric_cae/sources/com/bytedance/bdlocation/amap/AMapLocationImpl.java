package com.bytedance.bdlocation.amap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Keep;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.LocateState;
import com.bytedance.bdlocation.trace.TraceCons;
import java.util.concurrent.ConcurrentHashMap;
import qa.p4;
import qa.s4;
import qa.t3;
import qa.y3;
import w1.a;
import w1.b;
import w1.d;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AMapLocationImpl extends BaseLocate {
    private static final String DEFAULT_BUSINESS_ID = "default_continuous_location";
    public static final String GEOCODE_TYPE = "AMap";
    public static final String LOCATION_NAME = "AMap";
    private volatile a mClient;
    private Context mContext;
    private final ConcurrentHashMap<String, ContinuousLocationContext> mContinuousClients;
    private Object mContinuousLock;
    private Handler mHandler;
    private volatile boolean mIsFirstLocation;
    private volatile long mLastContinuousLocationStartTime;
    private AMapListener mListener;
    private a mSingleClient;
    private String sdkVersion;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.amap.AMapLocationImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class AMapListener implements b {
        private String mBusinessId;
        private BDLocationCallback mCallback;
        private long mLocationStartTime;
        private Looper mLooper;
        private LocationOption mOption;
        final /* synthetic */ AMapLocationImpl this$0;

        public AMapListener(AMapLocationImpl r8, BDLocationCallback r10, LocationOption r11, Looper r12) {
            this(r8, r10, r11, r12, null);
        }

        public static /* synthetic */ BDLocationCallback access$1200(AMapListener r8) {
            return r8.mCallback;
        }

        public static /* synthetic */ void access$1500(AMapListener r8) {
            r8.setAMapLocateStateStop();
        }

        public static /* synthetic */ LocationOption access$200(AMapListener r8) {
            return r8.mOption;
        }

        public static /* synthetic */ String access$400(AMapListener r8) {
            return r8.mBusinessId;
        }

        public static /* synthetic */ long access$600(AMapListener r8) {
            return r8.mLocationStartTime;
        }

        private void setAMapLocateStateStop() {
            if (this.mOption.isOnceLocation() == false) goto L6;
            LocateState.aMapLocationStop(this);
            return;
        }

        @Override // w1.b
        public void onLocationChanged(final AMapLocation r8) {
            if (r8 != null) goto L6;
            setAMapLocateStateStop();
            return;
        L6:
            if (AMapLocationImpl.access$100(this.this$0) != null) goto L8;
            AMapLocationImpl.access$102(this.this$0, new Handler(this.mLooper));
        L8:
            AMapLocationImpl.access$100(this.this$0).post(new AnonymousClass1(this, r8));
        }

        public AMapListener(AMapLocationImpl r8, BDLocationCallback r10, LocationOption r11, Looper r12, String r13) {
            this.this$0 = r8;
            this.mCallback = r10;
            this.mOption = r11;
            this.mLooper = r12;
            this.mBusinessId = r13;
            this.mLocationStartTime = SystemClock.elapsedRealtime();
            LocationMonitor.locationTraceLogBegin(r11.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        }
    }

    public static class ContinuousLocationContext {
        a client;
        boolean isFirstLocation;
        AMapListener listener;
        LocationOption option;
        long startTime;

        private ContinuousLocationContext() {
        }

        public /* synthetic */ ContinuousLocationContext(AnonymousClass1 r8) {
            this();
        }
    }

    @Keep
    public AMapLocationImpl(Context r8) {
        super(r8);
        this.sdkVersion = "";
        this.mContinuousLock = new Object();
        this.mIsFirstLocation = true;
        this.mContinuousClients = new ConcurrentHashMap();
        this.mContext = r8;
        boolean r10 = BDLocationConfig.isPrivacyConfirmed();
        boolean r11 = BDLocationConfig.isPrivacyConfirmed();
        s4 r12 = t3.j();
        p4.c r13 = p4.f10903a;
        if (r11 == false) goto L5;
        p4.e r14 = p4.e.f10943n;
    L6:
        if (r10 == false) goto L8;
        p4.c r15 = p4.c.f10927n;
    L10:
        monitor-enter(p4.class);
        if (r8 == null) goto L30;
        if (r12 == null) goto L30;
    L27:
        th = move-exception;
        throw th;
    L15:
        if (p4.f10914l == true) goto L17;
        p4.g(r8);     // Catch: Throwable -> L27
        p4.f10914l = true;     // Catch: Throwable -> L27
    L17:
        Boolean r16 = Boolean.FALSE;     // Catch: Throwable -> L27
        if (r14 == p4.f10904b) goto L21;
        r16 = Boolean.TRUE;     // Catch: Throwable -> L27
        p4.f10904b = r14;     // Catch: Throwable -> L27
    L21:
        if (r15 == p4.f10903a) goto L24;
        r16 = Boolean.TRUE;     // Catch: Throwable -> L27
        p4.f10903a = r15;     // Catch: Throwable -> L27
    L24:
        if (r16.booleanValue() == false) goto L30;
        p4.f10905c = r12.a();     // Catch: Throwable -> L27
        p4.f10906d = r12.f11096f;     // Catch: Throwable -> L27
        long r17 = System.currentTimeMillis();     // Catch: Throwable -> L27
        p4.f10907e = r17;     // Catch: Throwable -> L27
        p4.f10912j = r17;     // Catch: Throwable -> L27
        p4.f(r8);     // Catch: Throwable -> L27
    L30:
        monitor-exit(p4.class);
        boolean r18 = BDLocationConfig.isPrivacyConfirmed();
        s4 r19 = t3.j();
        if (r18 == false) goto L34;
        p4.b r20 = p4.b.f10922n;
    L36:
        monitor-enter(p4.class);
        if (r8 == null) goto L50;
        if (r19 == null) goto L50;
    L47:
        th = move-exception;
        throw th;
    L41:
        if (p4.f10914l == true) goto L43;
        p4.g(r8);     // Catch: Throwable -> L47
        p4.f10914l = true;     // Catch: Throwable -> L47
    L43:
        Boolean r21 = Boolean.FALSE;     // Catch: Throwable -> L47
        if (r20 == p4.f10908f) goto L50;
        Boolean r22 = Boolean.TRUE;     // Catch: Throwable -> L47
        p4.f10908f = r20;     // Catch: Throwable -> L47
        p4.f10910h = r19.a();     // Catch: Throwable -> L47
        p4.f10911i = r19.f11096f;     // Catch: Throwable -> L47
        long r23 = System.currentTimeMillis();     // Catch: Throwable -> L47
        p4.f10909g = r23;     // Catch: Throwable -> L47
        p4.f10912j = r23;     // Catch: Throwable -> L47
        p4.f(r8);     // Catch: Throwable -> L47
    L50:
        monitor-exit(p4.class);
        this.mSingleClient = new a(r8.getApplicationContext());     // Catch: Exception -> L53
        this.sdkVersion = "6.4.8";     // Catch: Exception -> L53
        return;
    L53:
        e = move-exception;
        e.printStackTrace();
        return;
    L34:
        r20 = p4.b.f10921m;
        goto L36
    L8:
        r15 = p4.c.f10926m;
        goto L10
    L5:
        r14 = p4.e.f10942m;
        goto L6
    }

    public static /* synthetic */ Handler access$100(AMapLocationImpl r8) {
        return r8.mHandler;
    }

    public static /* synthetic */ long access$1000(AMapLocationImpl r8) {
        return r8.mLastContinuousLocationStartTime;
    }

    public static /* synthetic */ long access$1002(AMapLocationImpl r8, long r10) {
        r8.mLastContinuousLocationStartTime = r10;
        return r10;
    }

    public static /* synthetic */ Handler access$102(AMapLocationImpl r8, Handler r10) {
        r8.mHandler = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1100(AMapLocationImpl r8) {
        return r8.mIsFirstLocation;
    }

    public static /* synthetic */ boolean access$1102(AMapLocationImpl r8, boolean r10) {
        r8.mIsFirstLocation = r10;
        return r10;
    }

    public static /* synthetic */ BDLocationException access$1300(AMapLocationImpl r8, int r10, String r11) {
        return r8.mapBDException(r10, r11);
    }

    public static /* synthetic */ void access$1400(AMapLocationImpl r8, BDLocationCallback r10, BDLocationException r11) {
        r8.onError(r10, r11);
    }

    public static /* synthetic */ Context access$300(AMapLocationImpl r8) {
        return r8.mContext;
    }

    public static /* synthetic */ BDLocation access$500(AMapLocationImpl r8, AMapLocation r10, LocationOption r11) {
        return r8.transform(r10, r11);
    }

    public static /* synthetic */ String access$700(AMapLocationImpl r8) {
        return r8.sdkVersion;
    }

    public static /* synthetic */ Object access$800(AMapLocationImpl r8) {
        return r8.mContinuousLock;
    }

    public static /* synthetic */ ConcurrentHashMap access$900(AMapLocationImpl r8) {
        return r8.mContinuousClients;
    }

    private BDLocationException mapBDException(int r8, String r10) {
        if (r8 != 12) goto L10;
        if (r10.contains("1206") == false) goto L14;
        BDLocationException r11 = new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "AMap", BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);
    L7:
        r11.addExtra(TraceCons.EXTRA_FAIL_AMAP_CODE, String.valueOf(r8));
        return r11;
    L14:
        r11 = new BDLocationException(r10, "AMap", BDLocationException.ERROR_AMAP_FAIL);
        goto L7
    L10:
        if (r8 != 4) goto L14;
        if (r10.contains("0401") == false) goto L14;
        r11 = new BDLocationException("网络异常，未连接到网络，请连接网络", "AMap", BDLocationException.ERROR_ABNORMAL_NETWORK);
        goto L7
    }

    private void onError(BDLocationCallback r8, BDLocationException r10) {
        if (r8 == null) goto L4;
        r8.onError(r10);
    L4:
        onLocateError("AMap", r10);
    }

    private void startContinuousLocation(BDLocationCallback r8, LocationOption r10, Looper r11, AMapLocationClientOption r12) {
        if (this.mContext != null) goto L6;
        r8.onError(new BDLocationException("mContext is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));
        return;
    L6:
        String r13 = r10.getBusinessId();
        Logger.i("AMapLocationImpl startContinuousLocation businessId: " + r13);
        if (r13 != null) goto L9;
    L13:
        startContinuousLocationLegacy(r8, r10, r11, r12);
        return;
    L9:
        if (r13.isEmpty() == true) goto L13;
        startContinuousLocationMulti(r13, r8, r10, r11, r12);
    }

    private void startContinuousLocationLegacy(BDLocationCallback r8, LocationOption r10, Looper r11, AMapLocationClientOption r12) {
        Object r13 = this.mContinuousLock;     // Catch: Exception -> L15
        monitor-enter(r13);     // Catch: Exception -> L15
        stopLocation();     // Catch: Throwable -> L12
        this.mLastContinuousLocationStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        this.mIsFirstLocation = true;     // Catch: Throwable -> L12
        this.mClient = new a(this.mContext.getApplicationContext());     // Catch: Throwable -> L12
        this.mListener = new AMapListener(this, r8, r10, r11);     // Catch: Throwable -> L12
        this.mClient.d(r12);     // Catch: Throwable -> L12
        Logger.i("amapOption.enableAMapBackgroundContiLocation: " + r10.enableAMapBackgroundContiLocation);     // Catch: Throwable -> L12
        if (r10.enableAMapBackgroundContiLocation == true) goto L8;
        this.mClient.a();     // Catch: Throwable -> L12
    L8:
        this.mClient.c(this.mListener);     // Catch: Throwable -> L12
        LocateState.aMapLocationStart(this.mClient);     // Catch: Throwable -> L12
        this.mClient.e();     // Catch: Throwable -> L12
        monitor-exit(r13);     // Catch: Throwable -> L12
        Logger.i("AMapLocationImpl startContinuousLocation (legacy mode)");     // Catch: Exception -> L15
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L15
    L15:
        r8.onError(new BDLocationException("amap client is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));
    }

    private void startContinuousLocationMulti(String r15, BDLocationCallback r16, LocationOption r17, Looper r18, AMapLocationClientOption r19) {
        Object r11 = this.mContinuousLock;     // Catch: Exception -> L14
        monitor-enter(r11);     // Catch: Exception -> L14
        stopLocationForBusiness(r15);     // Catch: Throwable -> L11
        ContinuousLocationContext r12 = new ContinuousLocationContext(null);     // Catch: Throwable -> L11
        r12.client = new a(this.mContext.getApplicationContext());     // Catch: Throwable -> L11
        r12.listener = new AMapListener(this, r16, r17, r18, r15);     // Catch: Throwable -> L11
        r12.startTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        r12.isFirstLocation = true;     // Catch: Throwable -> L11
        r12.option = r17;     // Catch: Throwable -> L11
        r12.client.d(r19);     // Catch: Throwable -> L11
        Logger.i("amapOption.enableAMapBackgroundContiLocation: " + r17.enableAMapBackgroundContiLocation);     // Catch: Throwable -> L11
        if (r17.enableAMapBackgroundContiLocation == true) goto L8;
        r12.client.a();     // Catch: Throwable -> L11
    L8:
        r12.client.c(r12.listener);     // Catch: Throwable -> L11
        LocateState.aMapLocationStart(r12.client);     // Catch: Throwable -> L11
        r12.client.e();     // Catch: Throwable -> L11
        this.mContinuousClients.put(r15, r12);     // Catch: Throwable -> L11
        Logger.i("AMapLocationImpl startContinuousLocation (multi mode) businessId: " + r15 + ", total clients: " + this.mContinuousClients.size());     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    L21:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Logger.e("AMapLocationImpl startContinuousLocationMulti error", e);
        r16.onError(new BDLocationException("amap client start failed: " + e.getMessage(), "AMap", BDLocationException.ERROR_AMAP_CLIENT));
    }

    private void startSingleLocation(BDLocationCallback r8, LocationOption r10, Looper r11, AMapLocationClientOption r12) {
    L14:
        e = move-exception;
        r8.onError(new BDLocationException(e.getMessage(), "AMap", BDLocationException.ERROR_AMAP_CLIENT));
        return;
    L4:
        if (this.mSingleClient == null) goto L6;
    L12:
        AMapListener r13 = new AMapListener(this, r8, r10, r11);     // Catch: Exception -> L14
        this.mSingleClient.d(r12);     // Catch: Exception -> L14
        this.mSingleClient.a();     // Catch: Exception -> L14
        this.mSingleClient.c(r13);     // Catch: Exception -> L14
        LocateState.aMapLocationStart(r13);     // Catch: Exception -> L14
        this.mSingleClient.e();     // Catch: Exception -> L14
        return;
    L6:
        if (BDLocationConfig.enableDestroyAMapSingleClient() == false) goto L10;
        Context r14 = this.mContext;     // Catch: Exception -> L14
        if (r14 == null) goto L10;
        this.mSingleClient = new a(r14.getApplicationContext());     // Catch: Exception -> L14
    L10:
        r8.onError(new BDLocationException("amap client is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));     // Catch: Exception -> L14
    }

    private void stopClientSafely(ContinuousLocationContext r8) {
        a r10 = r8.client;     // Catch: Exception -> L8
        if (r10 == null) goto L13;
        r10.f();     // Catch: Exception -> L8
        LocateState.aMapLocationStop(r8.client);     // Catch: Exception -> L8
        r8.client.g(r8.listener);     // Catch: Exception -> L8
        if (BDLocationConfig.enableDestroyAMapContinuousClient() == false) goto L14;
        Logger.i("AMapLocationImpl continuous client onDestroy");     // Catch: Exception -> L8
        r8.client.b();     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        Logger.e("AMapLocationImpl stopClientSafely error", e);
    }

    private int transAMapTypeToBDType(int r8) {
        if (r8 != 1) goto L6;
        return 1;
    L6:
        if (r8 != 2) goto L9;
        return 8;
    L9:
        if (r8 != 4) goto L11;
        return 5;
    L11:
        if (r8 != 5) goto L14;
        return 2;
    L14:
        if (r8 != 6) goto L18;
        return 3;
    L18:
        if (r8 != 8) goto L20;
        return 9;
    L20:
        if (r8 != 9) goto L24;
        return 10;
    L24:
        if (r8 != 11) goto L26;
        return 11;
    L26:
        return 0;
    }

    private BDLocation transform(AMapLocation r12, LocationOption r13) {
        BDLocation r8 = new BDLocation(r12, "AMap");
        String r10 = r12.Q;
        Logger.i("AMap", "The CoordType of AMapLocation is " + r10);
        if ("GCJ02".equals(r10) == false) goto L6;
        r8.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L6:
        if ("WGS84".equals(r10) == false) goto L8;
        r8.setCoordinateSystem(LocationInfoConst.WGS_84);
    L8:
        if (r13 != null) goto L10;
    L12:
        r8.setMock(r12.isMock());
        r8.setAddress(r12.f3639p);
        r8.setCountry(r12.f3641r);
        r8.setAdministrativeArea(r12.f3634a);
        r8.setCity(r12.f3635b);
        r8.setDistrict(r12.f3636m);
        r8.setCityCode(r12.f3637n);
        r8.setStreet(r12.f3643t);
        r8.setStreetNum(r12.f3644u);
        r8.setFloor(r12.O);
        r8.setBuildingId(r12.N);
        r8.setLocationMs(System.currentTimeMillis());
        r8.setPoi(r12.f3640q);
        r8.setAoi(r12.I);
        r8.setBearing(r12.getBearing());
        r8.setSpeed(r12.getSpeed());
        r8.setTrustedLevel(r12.R);
        r8.setLocationDetail(r12.f3648y);
        r8.setSatellites(r12.H);
        int r14 = r12.f3649z;
        Logger.i("AMapLocationImpl amapType:" + r14);
        r8.setLocationType(transAMapTypeToBDType(r14));
        boolean r11 = t3.h(r12.getLatitude(), r12.getLongitude());
        Logger.i("AMap", "The result of the method isAMapDataAvailable is " + r11);
        if (r11 == false) goto L15;
        r8.setGCJ02(new BDPoint(r12.getLatitude(), r12.getLongitude(), r12.getProvider()));
        r8.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L15:
        return r8;
    L10:
        if (r13.getGeocodeMode() != 1) goto L12;
        r8.setGeocodeSDKName("AMap");
        goto L12
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r8, BDPoint r10) {
        if (r8 == null) goto L12;
        if (r10 == null) goto L13;
        DPoint r11 = new DPoint();
        r11.t(r8.getLatitude());
        r11.u(r8.getLongitude());
        DPoint r12 = new DPoint();
        r12.t(r10.getLatitude());
        r12.u(r10.getLongitude());
        return y3.b(new double[]{r11.f3678b, r11.f3677a, r12.f3678b, r12.f3677a});
    L14:
        return 0.0f;
    L13:
        return 0.0f;
    L12:
        return 0.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r8) {
        DPoint r10 = new DPoint(r8.getLatitude(), r8.getLongitude());     // Catch: Exception -> L11
        d r11 = new d(this.mContext);     // Catch: Exception -> L11
        d.b r12 = d.b.f12962a;     // Catch: Exception -> L11
        monitor-enter(r11);     // Catch: Exception -> L11
        r11.f12958b = r12;     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Exception -> L11
        r11.b(r10);     // Catch: Exception -> L11
        DPoint r13 = r11.a();     // Catch: Exception -> L11
        return new BDPoint(r13.f3678b, r13.f3677a, r8.getProvider());
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Logger.e("", e);
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return "AMap";
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r8, double r10) {
        return t3.h(r8, r10);
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r11, LocationOption r12, Looper r13) {
        super.startLocation(r11, r12, r13);
        if (LocationUtil.isLocationEnabled() == true) goto L7;
        Logger.i("AMapLocationImpl startLocation location is disabled");
        r11.onError(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "AMap", BDLocationException.ERROR_DEVICE_LOCATION_DISABLE));
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L10;
        Logger.i("AMapLocationImpl startLocation location is background");
        return;
    L10:
        AMapLocationClientOption r8 = new AMapLocationClientOption();
        AMapLocationClientOption.L = AMapLocationClientOption.c.f3671b;
        if (r12.getMode() != 0) goto L14;
        AMapLocationClientOption.b r10 = AMapLocationClientOption.b.f3666a;
    L17:
        r8.f3657r = r10;
        r8.G = BDLocationConfig.enableSelfStartService();
        boolean r14 = false;
        r8.f3654o = false;
        if (r12.getMaxCacheTime() == 0) goto L20;
        boolean r15 = true;
    L21:
        r8.f3661v = r15;
        StringBuilder r16 = new StringBuilder("amapOption.setLocationCacheEnable: ");
        if (r12.getMaxCacheTime() == 0) goto L24;
        r14 = true;
    L24:
        r16.append(r14);
        r16.append(", uploadSource: ");
        r16.append(r12.getUploadSource());
        Logger.i(r16.toString());
        r8.H = BDLocationConfig.isNoLocReqCgiEnable();
        r8.I = BDLocationConfig.isSysNetworkLocEnable();
        Logger.i("amapOption.setGpsFirst: " + r12.isAMapGpsFirst());
        r8.f3659t = r12.isAMapGpsFirst();
        if (r12.isAMapGpsFirst() == false) goto L36;
        if (r12.getAMapGpsFirstTimeoutMillis() <= 0) goto L36;
        Logger.i("amapOption.setGpsFirstTimeout: " + r12.getAMapGpsFirstTimeoutMillis());
        long r17 = r12.getAMapGpsFirstTimeoutMillis();
        if (r17 >= 5000) goto L32;
        r17 = 5000;
    L32:
        if (r17 <= 30000) goto L34;
        r17 = 30000;
    L34:
        r8.A = r17;
    L36:
        if (r12.isOnceLocation() == false) goto L38;
        Logger.i("AMapLocationImpl startSingleLocation amap version:" + this.sdkVersion);
        r8.f3650a = 1000;
        r8.f3652m = true;
        r8.f3651b = r12.getLocationTimeOutMs();
        startSingleLocation(r11, r12, r13, r8);
    L42:
        onLocateStart("AMap");
        return;
    L38:
        Logger.i("AMapLocationImpl startLocation");
        long r18 = r12.getInterval();
        if (r18 > 800) goto L41;
        r18 = 800;
    L41:
        r8.f3650a = r18;
        startContinuousLocation(r11, r12, r13, r8);
        goto L42
    L20:
        r15 = false;
        goto L21
    L14:
        if (r12.getMode() != 1) goto L16;
        r10 = AMapLocationClientOption.b.f3667b;
        goto L17
    L16:
        r10 = AMapLocationClientOption.b.f3668m;
        goto L17
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
        Object r8 = this.mContinuousLock;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient == null) goto L10;
        this.mClient.f();     // Catch: Throwable -> L14
        LocateState.aMapLocationStop(this.mClient);     // Catch: Throwable -> L14
        this.mClient.g(this.mListener);     // Catch: Throwable -> L14
        if (BDLocationConfig.enableDestroyAMapContinuousClient() == false) goto L9;
        Logger.i("AMapLocationImpl mClient onDestroy");     // Catch: Throwable -> L14
        this.mClient.b();     // Catch: Throwable -> L14
    L9:
        this.mClient = null;     // Catch: Throwable -> L14
    L10:
        this.mListener = null;     // Catch: Throwable -> L14
        this.mLastContinuousLocationStartTime = 0;     // Catch: Throwable -> L14
        monitor-exit(r8);     // Catch: Throwable -> L14
        onLocateStop("AMap");
        Logger.i("AMapLocationImpl stopLocation (legacy mode only)");
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void stopLocationForBusiness(String r8) {
        if (r8 != null) goto L5;
    L19:
        Logger.w("AMapLocationImpl stopLocationForBusiness: businessId is null or empty");
        return;
    L5:
        if (r8.isEmpty() == true) goto L19;
        Object r10 = this.mContinuousLock;
        monitor-enter(r10);
        ContinuousLocationContext r11 = this.mContinuousClients.remove(r8);     // Catch: Throwable -> L16
        if (r11 == null) goto L13;
        stopClientSafely(r11);     // Catch: Throwable -> L16
        String r12 = "AMapLocationImpl stopLocationForBusiness: " + r8 + ", remaining clients: " + this.mContinuousClients.size();     // Catch: Throwable -> L16
    L12:
        Logger.i(r12);     // Catch: Throwable -> L16
        monitor-exit(r10);     // Catch: Throwable -> L16
        return;
    L13:
        r12 = "AMapLocationImpl stopLocationForBusiness: businessId not found: ".concat(r8);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    public void stopSingleLocation(AMapListener r8) {
        if (this.mSingleClient == null) goto L8;
        Logger.i("AMapLocationImpl stopSingleLocation");
        this.mSingleClient.f();
        this.mSingleClient.g(r8);
        if (BDLocationConfig.enableDestroyAMapSingleClient() == false) goto L9;
        Logger.i("AMapLocationImpl mSingleClient onDestroy ");
        this.mSingleClient.b();
        this.mSingleClient = null;
        return;
    L9:
        return;
    }
}
