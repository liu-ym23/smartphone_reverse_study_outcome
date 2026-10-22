package com.bytedance.bdlocation.amap;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.CoordinateConverter;
import com.amap.api.location.DPoint;
import com.amap.api.location.a;
import com.amap.api.location.b;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
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
    static /* synthetic */ class AnonymousClass1 {
    }

    private class AMapListener implements b {
        private String mBusinessId;
        private BDLocationCallback mCallback;
        private long mLocationStartTime;
        private Looper mLooper;
        private LocationOption mOption;
        final /* synthetic */ AMapLocationImpl this$0;

        public AMapListener(AMapLocationImpl r7, BDLocationCallback r8, LocationOption r9, Looper r10) {
            this(r7, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r8, BDLocationCallback.class, "com.obric.memorydata.plugin"), r9, r10, null);
        }

        public AMapListener(AMapLocationImpl r3, BDLocationCallback r4, LocationOption r5, Looper r6, String r7) {
            BDLocationCallback r8 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r4, BDLocationCallback.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            this.mCallback = r8;
            this.mOption = r5;
            this.mLooper = r6;
            this.mBusinessId = r7;
            this.mLocationStartTime = SystemClock.elapsedRealtime();
            LocationMonitor.locationTraceLogBegin(r5.getLocationTraceLogger(), LocationMonitorConst.CORE_LOCATE_DURATION);
        }

        static /* synthetic */ BDLocationCallback access$1200(AMapListener r0) {
            return r0.mCallback;
        }

        static /* synthetic */ void access$1500(AMapListener r0) {
            r0.setAMapLocateStateStop();
        }

        static /* synthetic */ LocationOption access$200(AMapListener r0) {
            return r0.mOption;
        }

        static /* synthetic */ String access$400(AMapListener r0) {
            return r0.mBusinessId;
        }

        static /* synthetic */ long access$600(AMapListener r2) {
            return r2.mLocationStartTime;
        }

        private void setAMapLocateStateStop() {
            if (this.mOption.isOnceLocation() == false) goto L6;
            LocateState.aMapLocationStop(this);
            return;
        }

        @Override // com.amap.api.location.b
        public void onLocationChanged(final AMapLocation r4) {
            if (r4 != null) goto L6;
            setAMapLocateStateStop();
            return;
        L6:
            if (AMapLocationImpl.access$100(this.this$0) != null) goto L8;
            AMapLocationImpl.access$102(this.this$0, new Handler(this.mLooper));
        L8:
            AMapLocationImpl.access$100(this.this$0).post(new AnonymousClass1(this, r4));
        }
    }

    private static class ContinuousLocationContext {
        a client;
        boolean isFirstLocation;
        AMapListener listener;
        LocationOption option;
        long startTime;

        private ContinuousLocationContext() {
        }

        /* synthetic */ ContinuousLocationContext(AnonymousClass1 r1) {
            this();
        }
    }

    public AMapLocationImpl(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(r5);
        this.sdkVersion = "";
        this.mContinuousLock = new Object();
        this.mIsFirstLocation = true;
        this.mContinuousClients = new ConcurrentHashMap();
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        a.a(r5, BDLocationConfig.isPrivacyConfirmed(), BDLocationConfig.isPrivacyConfirmed());
        a.a(r5, BDLocationConfig.isPrivacyConfirmed());
        a r0 = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L5
        this.mSingleClient = r0;     // Catch: Exception -> L5
        this.sdkVersion = r0.c();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    static /* synthetic */ Handler access$100(AMapLocationImpl r0) {
        return r0.mHandler;
    }

    static /* synthetic */ long access$1000(AMapLocationImpl r2) {
        return r2.mLastContinuousLocationStartTime;
    }

    static /* synthetic */ long access$1002(AMapLocationImpl r0, long r1) {
        r0.mLastContinuousLocationStartTime = r1;
        return r1;
    }

    static /* synthetic */ Handler access$102(AMapLocationImpl r0, Handler r1) {
        r0.mHandler = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1100(AMapLocationImpl r0) {
        return r0.mIsFirstLocation;
    }

    static /* synthetic */ boolean access$1102(AMapLocationImpl r0, boolean r1) {
        r0.mIsFirstLocation = r1;
        return r1;
    }

    static /* synthetic */ BDLocationException access$1300(AMapLocationImpl r0, int r1, String r2) {
        return r0.mapBDException(r1, r2);
    }

    static /* synthetic */ void access$1400(AMapLocationImpl r2, BDLocationCallback r3, BDLocationException r4) {
        r2.onError((BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ Context access$300(AMapLocationImpl r0) {
        return r0.mContext;
    }

    static /* synthetic */ BDLocation access$500(AMapLocationImpl r0, AMapLocation r1, LocationOption r2) {
        return r0.transform(r1, r2);
    }

    static /* synthetic */ String access$700(AMapLocationImpl r0) {
        return r0.sdkVersion;
    }

    static /* synthetic */ Object access$800(AMapLocationImpl r0) {
        return r0.mContinuousLock;
    }

    static /* synthetic */ ConcurrentHashMap access$900(AMapLocationImpl r0) {
        return r0.mContinuousClients;
    }

    private BDLocationException mapBDException(int r4, String r5) {
        if (r4 != 12) goto L10;
        if (r5.contains("1206") == false) goto L14;
        BDLocationException r6 = new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "AMap", BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);
    L7:
        r6.addExtra(TraceCons.EXTRA_FAIL_AMAP_CODE, String.valueOf(r4));
        return r6;
    L14:
        BDLocationException r1 = new BDLocationException(r5, "AMap", BDLocationException.ERROR_AMAP_FAIL);
        r1.addExtra(TraceCons.EXTRA_FAIL_AMAP_CODE, String.valueOf(r4));
        return r1;
    L10:
        if (r4 != 4) goto L14;
        if (r5.contains("0401") == false) goto L14;
        r6 = new BDLocationException("网络异常，未连接到网络，请连接网络", "AMap", BDLocationException.ERROR_ABNORMAL_NETWORK);
        goto L7
    }

    private void onError(BDLocationCallback r3, BDLocationException r4) {
        BDLocationCallback r5 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        r5.onError(r4);
    L5:
        onLocateError("AMap", r4);
    }

    private void startContinuousLocation(BDLocationCallback r7, LocationOption r8, Looper r9, AMapLocationClientOption r10) {
        BDLocationCallback r2 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r7, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (this.mContext != null) goto L6;
        r2.onError(new BDLocationException("mContext is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));
        return;
    L6:
        String r1 = r8.getBusinessId();
        Logger.i("AMapLocationImpl startContinuousLocation businessId: " + r1);
        if (r1 != null) goto L9;
    L13:
        startContinuousLocationLegacy(r2, r8, r9, r10);
        return;
    L9:
        if (r1.isEmpty() == true) goto L13;
        startContinuousLocationMulti(r1, r2, r8, r9, r10);
    }

    private void startContinuousLocationLegacy(BDLocationCallback r7, LocationOption r8, Looper r9, AMapLocationClientOption r10) {
        BDLocationCallback r11 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r7, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Object r0 = this.mContinuousLock;     // Catch: Exception -> L15
        monitor-enter(r0);     // Catch: Exception -> L15
        stopLocation();     // Catch: Throwable -> L12
        this.mLastContinuousLocationStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
        this.mIsFirstLocation = true;     // Catch: Throwable -> L12
        this.mClient = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L12
        this.mListener = new AMapListener(this, r11, r8, r9);     // Catch: Throwable -> L12
        this.mClient.a(r10);     // Catch: Throwable -> L12
        Logger.i("amapOption.enableAMapBackgroundContiLocation: " + r8.enableAMapBackgroundContiLocation);     // Catch: Throwable -> L12
        if (r8.enableAMapBackgroundContiLocation == true) goto L8;
        this.mClient.a(true);     // Catch: Throwable -> L12
    L8:
        this.mClient.a(this.mListener);     // Catch: Throwable -> L12
        LocateState.aMapLocationStart(this.mClient);     // Catch: Throwable -> L12
        this.mClient.a();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        Logger.i("AMapLocationImpl startContinuousLocation (legacy mode)");     // Catch: Exception -> L15
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L15
    L15:
        r11.onError(new BDLocationException("amap client is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));
    }

    private void startContinuousLocationMulti(String r10, BDLocationCallback r11, LocationOption r12, Looper r13, AMapLocationClientOption r14) {
        BDLocationCallback r15 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r11, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Object r6 = this.mContinuousLock;     // Catch: Exception -> L14
        monitor-enter(r6);     // Catch: Exception -> L14
        stopLocationForBusiness(r10);     // Catch: Throwable -> L11
        ContinuousLocationContext r7 = new ContinuousLocationContext(null);     // Catch: Throwable -> L11
        r7.client = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        r7.listener = new AMapListener(this, r15, r12, r13, r10);     // Catch: Throwable -> L11
        r7.startTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        r7.isFirstLocation = true;     // Catch: Throwable -> L11
        r7.option = r12;     // Catch: Throwable -> L11
        r7.client.a(r14);     // Catch: Throwable -> L11
        Logger.i("amapOption.enableAMapBackgroundContiLocation: " + r12.enableAMapBackgroundContiLocation);     // Catch: Throwable -> L11
        if (r12.enableAMapBackgroundContiLocation == true) goto L8;
        r7.client.a(true);     // Catch: Throwable -> L11
    L8:
        r7.client.a(r7.listener);     // Catch: Throwable -> L11
        LocateState.aMapLocationStart(r7.client);     // Catch: Throwable -> L11
        r7.client.a();     // Catch: Throwable -> L11
        this.mContinuousClients.put(r10, r7);     // Catch: Throwable -> L11
        Logger.i("AMapLocationImpl startContinuousLocation (multi mode) businessId: " + r10 + ", total clients: " + this.mContinuousClients.size());     // Catch: Throwable -> L11
        monitor-exit(r6);     // Catch: Throwable -> L11
    L20:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Logger.e("AMapLocationImpl startContinuousLocationMulti error", e);
        r15.onError(new BDLocationException("amap client start failed: " + e.getMessage(), "AMap", BDLocationException.ERROR_AMAP_CLIENT));
    }

    private void startSingleLocation(BDLocationCallback r7, LocationOption r8, Looper r9, AMapLocationClientOption r10) {
        BDLocationCallback r11 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r7, BDLocationCallback.class, "com.obric.memorydata.plugin");
    L14:
        e = move-exception;
        r11.onError(new BDLocationException(e.getMessage(), "AMap", BDLocationException.ERROR_AMAP_CLIENT));
        return;
    L4:
        if (this.mSingleClient == null) goto L6;
    L12:
        AMapListener r2 = new AMapListener(this, r11, r8, r9);     // Catch: Exception -> L14
        this.mSingleClient.a(r10);     // Catch: Exception -> L14
        this.mSingleClient.a(true);     // Catch: Exception -> L14
        this.mSingleClient.a(r2);     // Catch: Exception -> L14
        LocateState.aMapLocationStart(r2);     // Catch: Exception -> L14
        this.mSingleClient.a();     // Catch: Exception -> L14
        return;
    L6:
        if (BDLocationConfig.enableDestroyAMapSingleClient() == true) goto L8;
    L10:
        r11.onError(new BDLocationException("amap client is null", "AMap", BDLocationException.ERROR_AMAP_CLIENT));     // Catch: Exception -> L14
        return;
    L8:
        if (this.mContext == null) goto L10;
        this.mSingleClient = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mContext.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L14
        goto L12
    }

    private void stopClientSafely(ContinuousLocationContext r2) {
    L8:
        e = move-exception;
        Logger.e("AMapLocationImpl stopClientSafely error", e);
        return;
    L3:
        if (r2.client == null) goto L13;
        r2.client.b();     // Catch: Exception -> L8
        LocateState.aMapLocationStop(r2.client);     // Catch: Exception -> L8
        r2.client.b(r2.listener);     // Catch: Exception -> L8
        if (BDLocationConfig.enableDestroyAMapContinuousClient() == false) goto L14;
        Logger.i("AMapLocationImpl continuous client onDestroy");     // Catch: Exception -> L8
        r2.client.d();     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    private int transAMapTypeToBDType(int r4) {
        if (r4 != 1) goto L6;
        return 1;
    L6:
        if (r4 != 2) goto L9;
        return 8;
    L9:
        if (r4 != 4) goto L11;
        return 5;
    L11:
        if (r4 != 5) goto L14;
        return 2;
    L14:
        if (r4 != 6) goto L18;
        return 3;
    L18:
        if (r4 != 8) goto L20;
        return 9;
    L20:
        if (r4 != 9) goto L24;
        return 10;
    L24:
        if (r4 != 11) goto L26;
        return 11;
    L26:
        return 0;
    }

    private BDLocation transform(AMapLocation r12, LocationOption r13) {
        BDLocation r0 = new BDLocation(r12, "AMap");
        String r2 = r12.getCoordType();
        Logger.i("AMap", "The CoordType of AMapLocation is " + r2);
        if (AMapLocation.COORD_TYPE_GCJ02.equals(r2) == false) goto L6;
        r0.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L6:
        if (AMapLocation.COORD_TYPE_WGS84.equals(r2) == false) goto L8;
        r0.setCoordinateSystem(LocationInfoConst.WGS_84);
    L8:
        if (r13 != null) goto L10;
    L12:
        r0.setMock(r12.isMock());
        r0.setAddress(r12.getAddress());
        r0.setCountry(r12.getCountry());
        r0.setAdministrativeArea(r12.getProvince());
        r0.setCity(r12.getCity());
        r0.setDistrict(r12.getDistrict());
        r0.setCityCode(r12.getCityCode());
        r0.setStreet(r12.getStreet());
        r0.setStreetNum(r12.getStreetNum());
        r0.setFloor(r12.getFloor());
        r0.setBuildingId(r12.getBuildingId());
        r0.setLocationMs(System.currentTimeMillis());
        r0.setPoi(r12.getPoiName());
        r0.setAoi(r12.getAoiName());
        r0.setBearing(r12.getBearing());
        r0.setSpeed(r12.getSpeed());
        r0.setTrustedLevel(r12.getTrustedLevel());
        r0.setLocationDetail(r12.getLocationDetail());
        r0.setSatellites(r12.getSatellites());
        int r14 = r12.getLocationType();
        Logger.i("AMapLocationImpl amapType:" + r14);
        r0.setLocationType(transAMapTypeToBDType(r14));
        boolean r11 = CoordinateConverter.a(r12.getLatitude(), r12.getLongitude());
        Logger.i("AMap", "The result of the method isAMapDataAvailable is " + r11);
        if (r11 == false) goto L15;
        r0.setGCJ02(new BDPoint(r12.getLatitude(), r12.getLongitude(), r12.getProvider()));
        r0.setCoordinateSystem(LocationInfoConst.GCJ_O2);
    L15:
        return r0;
    L10:
        if (r13.getGeocodeMode() != 1) goto L12;
        r0.setGeocodeSDKName("AMap");
        goto L12
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r3, BDPoint r4) {
        if (r3 == null) goto L7;
        if (r4 == null) goto L9;
        DPoint r2 = new DPoint();
        r2.setLatitude(r3.getLatitude());
        r2.setLongitude(r3.getLongitude());
        DPoint r5 = new DPoint();
        r5.setLatitude(r4.getLatitude());
        r5.setLongitude(r4.getLongitude());
        return CoordinateConverter.a(r2, r5);
    L9:
        return 0.0f;
    L7:
        return 0.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r8) {
        DPoint r0 = new DPoint(r8.getLatitude(), r8.getLongitude());     // Catch: Exception -> L4
        CoordinateConverter r1 = new CoordinateConverter(this.mContext);     // Catch: Exception -> L4
        r1.a(CoordinateConverter.CoordType.GPS);     // Catch: Exception -> L4
        r1.a(r0);     // Catch: Exception -> L4
        DPoint r7 = r1.a();     // Catch: Exception -> L4
        return new BDPoint(r7.getLatitude(), r7.getLongitude(), r8.getProvider());
    L4:
        e = move-exception;
        Logger.e("", e);
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return "AMap";
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r2, double r4) {
        new CoordinateConverter(this.mContext);
        return CoordinateConverter.a(r2, r4);
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r11, LocationOption r12, Looper r13) {
        BDLocationCallback r14 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r11, BDLocationCallback.class, "com.obric.memorydata.plugin");
        super.startLocation(r14, r12, r13);
        if (LocationUtil.isLocationEnabled() == true) goto L7;
        Logger.i("AMapLocationImpl startLocation location is disabled");
        r14.onError(new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", "AMap", BDLocationException.ERROR_DEVICE_LOCATION_DISABLE));
        return;
    L7:
        if (LocationUtil.checkBackground() == false) goto L10;
        Logger.i("AMapLocationImpl startLocation location is background");
        return;
    L10:
        AMapLocationClientOption r0 = new AMapLocationClientOption();
        AMapLocationClientOption.setLocationProtocol(AMapLocationClientOption.AMapLocationProtocol.HTTPS);
        if (r12.getMode() != 0) goto L15;
        AMapLocationClientOption.AMapLocationMode r2 = AMapLocationClientOption.AMapLocationMode.Battery_Saving;
    L13:
        r0.setLocationMode(r2);
        r0.setSelfStartServiceEnable(BDLocationConfig.enableSelfStartService());
        boolean r3 = false;
        r0.setNeedAddress(false);
        if (r12.getMaxCacheTime() == 0) goto L21;
        boolean r4 = true;
    L22:
        r0.setLocationCacheEnable(r4);
        StringBuilder r5 = new StringBuilder().append("amapOption.setLocationCacheEnable: ");
        if (r12.getMaxCacheTime() == 0) goto L25;
        r3 = true;
    L25:
        Logger.i(r5.append(r3).append(", uploadSource: ").append(r12.getUploadSource()).toString());
        r0.setNoLocReqCgiEnable(BDLocationConfig.isNoLocReqCgiEnable());
        r0.setSysNetworkLocEnable(BDLocationConfig.isSysNetworkLocEnable());
        Logger.i("amapOption.setGpsFirst: " + r12.isAMapGpsFirst());
        r0.setGpsFirst(r12.isAMapGpsFirst());
        if (r12.isAMapGpsFirst() == false) goto L31;
        if (r12.getAMapGpsFirstTimeoutMillis() <= 0) goto L31;
        Logger.i("amapOption.setGpsFirstTimeout: " + r12.getAMapGpsFirstTimeoutMillis());
        r0.setGpsFirstTimeout(r12.getAMapGpsFirstTimeoutMillis());
    L31:
        if (r12.isOnceLocation() == false) goto L33;
        Logger.i("AMapLocationImpl startSingleLocation amap version:" + this.sdkVersion);
        r0.setInterval(1000);
        r0.setOnceLocation(true);
        r0.setHttpTimeOut(r12.getLocationTimeOutMs());
        startSingleLocation(r14, r12, r13, r0);
    L34:
        onLocateStart("AMap");
        return;
    L33:
        Logger.i("AMapLocationImpl startLocation");
        r0.setInterval(r12.getInterval());
        startContinuousLocation(r14, r12, r13, r0);
        goto L34
    L21:
        r4 = false;
        goto L22
    L15:
        if (r12.getMode() != 1) goto L17;
        r2 = AMapLocationClientOption.AMapLocationMode.Device_Sensors;
        goto L13
    L17:
        r2 = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;
        goto L13
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
        Object r0 = this.mContinuousLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient == null) goto L10;
        this.mClient.b();     // Catch: Throwable -> L14
        LocateState.aMapLocationStop(this.mClient);     // Catch: Throwable -> L14
        this.mClient.b(this.mListener);     // Catch: Throwable -> L14
        if (BDLocationConfig.enableDestroyAMapContinuousClient() == false) goto L9;
        Logger.i("AMapLocationImpl mClient onDestroy");     // Catch: Throwable -> L14
        this.mClient.d();     // Catch: Throwable -> L14
    L9:
        this.mClient = null;     // Catch: Throwable -> L14
    L10:
        this.mListener = null;     // Catch: Throwable -> L14
        this.mLastContinuousLocationStartTime = 0;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        onLocateStop("AMap");
        Logger.i("AMapLocationImpl stopLocation (legacy mode only)");
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void stopLocationForBusiness(String r5) {
        if (r5 != null) goto L4;
    L18:
        Logger.w("AMapLocationImpl stopLocationForBusiness: businessId is null or empty");
        return;
    L4:
        if (r5.isEmpty() == true) goto L18;
        Object r0 = this.mContinuousLock;
        monitor-enter(r0);
        ContinuousLocationContext r1 = (ContinuousLocationContext) ZeusTransformUtils.preCheckCast(this.mContinuousClients.remove(r5), ContinuousLocationContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        stopClientSafely(r1);     // Catch: Throwable -> L15
        String r4 = "AMapLocationImpl stopLocationForBusiness: " + r5 + ", remaining clients: " + this.mContinuousClients.size();     // Catch: Throwable -> L15
    L11:
        Logger.i(r4);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L12:
        r4 = "AMapLocationImpl stopLocationForBusiness: businessId not found: " + r5;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void stopSingleLocation(AMapListener r2) {
        if (this.mSingleClient == null) goto L8;
        Logger.i("AMapLocationImpl stopSingleLocation");
        this.mSingleClient.b();
        this.mSingleClient.b(r2);
        if (BDLocationConfig.enableDestroyAMapSingleClient() == false) goto L9;
        Logger.i("AMapLocationImpl mSingleClient onDestroy ");
        this.mSingleClient.d();
        this.mSingleClient = null;
        return;
    L9:
        return;
    }
}
