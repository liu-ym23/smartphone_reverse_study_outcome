package com.bytedance.bdlocation_impl.c;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.IDYHostInfoProvider;
import com.bytedance.bdlocation.callback.ISceneStatusCallback;
import com.bytedance.bdlocation.callback.LocationNotification;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LastLocationEntity;
import com.bytedance.bdlocation.entity.LocateReasonEntity;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.event.LocationEvent;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.ServerApi;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.permission.request.RequestPermissionUtils;
import com.bytedance.bdlocation.scan.wifi.LBSLightWifiUtils;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.store.LocationCacheInfo;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.utils.BDLocationReflectUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Looper f1903b = null;
    private static final Handler c = null;
    private static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<BDLocationExtraDataServer> f1904a;
    private LocationCache e;
    private c f;
    private Context g;
    private final Handler h;
    private final Handler i;
    private final Looper j;
    private BaseLocate k;
    private IBPEALocal l;
    private AtomicInteger m;
    private final C0108a n;
    private long o;

    /* JADX INFO: renamed from: com.bytedance.bdlocation_impl.c.a$a, reason: collision with other inner class name */
    public static class C0108a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LocationOption f1933b;
        private BDLocation c;
        private List<BDLocationCallback> d;

        public C0108a() {
            this.f1932a = false;
            this.f1933b = null;
            this.c = null;
            this.d = new ArrayList();
        }

        public void a(BDLocation r1, LocationOption r2) {
            this.c = r1;
        }

        public void a(BDLocationCallback r3) {
            BDLocationCallback r4 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
            this.d.add(r4);
        }

        public boolean a() {
            return this.f1932a;
        }

        public boolean a(LocationOption r1) {
            if (r1 == null) goto L9;
            LocationOption r0 = this.f1933b;
            if (r0 != null) goto L6;
            return true;
        L6:
            if (r0.isLatestAdminVersion() == r1.isLatestAdminVersion()) goto L12;
            Logger.i("canMergeLocation: diff AdminVersion, return false.");
            return false;
        L12:
            return true;
        L9:
            return true;
        }

        public List<BDLocationCallback> b() {
            ArrayList r0 = new ArrayList(this.d);
            this.d.clear();
            return r0;
        }

        public void b(LocationOption r2) {
            this.f1933b = r2;
            this.f1932a = true;
            this.c = null;
            Logger.i("location-trace-core LocateTrace.onLocateStart: " + r2.getLocateId());
        }

        public synchronized void c() {
            monitor-enter(this);
            StringBuilder r0 = new StringBuilder().append("LocateTrace.onLocateStop, locate id:");     // Catch: Throwable -> L10
            LocationOption r1 = this.f1933b;     // Catch: Throwable -> L10
            if (r1 != null) goto L6;
            String r2 = "null";
        L7:
            Logger.i(r0.append(r2).toString());     // Catch: Throwable -> L10
            this.f1933b = null;     // Catch: Throwable -> L10
            this.f1932a = false;     // Catch: Throwable -> L10
            this.c = null;     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L6:
            r2 = r1.getLocateId();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        public BDLocation d() {
            return this.c;
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ISceneStatusCallback f1934a = null;

        static {
            f1934a = $$Lambda$a$b$h2w2DlHb9q4VN8yX32IelKZ9RXE.INSTANCE;
        }

        static /* synthetic */ ISceneStatusCallback a() {
            return f1934a;
        }

        private static /* synthetic */ void b() {
            AppExecutors.getInstance().networkIO().execute($$Lambda$a$b$JrDt06c_ditTriJb9SSYJw7Jiek.INSTANCE);
        }

        private static /* synthetic */ void c() {
            LocationUtil.uploadDeviceStatus("scenes_status_changed", 1);
        }

        public static /* synthetic */ void lambda$JrDt06c_ditTriJb9SSYJw7Jiek() {
            c();
        }

        public static /* synthetic */ void lambda$h2w2DlHb9q4VN8yX32IelKZ9RXE() {
            b();
        }
    }

    static {
        Looper r0 = ThreadLooperManager.getLocationWorker();
        f1903b = r0;
        c = new Handler(r0);
        d = null;
    }

    private a(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.m = new AtomicInteger(1);
        this.n = new C0108a();
        this.o = -1;
        this.g = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        Looper r0 = ThreadLooperManager.getLBSLightLocationWorker();
        this.j = r0;
        this.h = new Handler(r0);
        this.i = new Handler(Looper.getMainLooper());
        LocationCache r1 = LocationCache.getInstance();
        this.e = r1;
        r1.getLocationCache();
        this.f = c.a();
        this.l = BDLocationExtrasService.getBPEAManager();
        com.bytedance.bdlocation_impl.c.b.a();
        ThreadLooperManager.getPollUploadWorker();
        this.f1904a = new ArrayList();
        Logger.i(BDLocationReflectUtils.TAG, "BDLocationService: trigger new BDLocationService instance, context: " + r6);
    }

    static /* synthetic */ long a(a r0, long r1) {
        r0.o = r1;
        return r1;
    }

    private BDLocation a(int r2) {
        Logger.i("getLastKnowLocation start");
        LocationCache r1 = a().e();
        if (r1 != null) goto L6;
        return null;
    L6:
        BDLocation r3 = r1.getLocationCache().getLatestLocation();
        if (r3 == null) goto L9;
        r3.setCache(true);
    L9:
        BDLocation r4 = LocationUtil.transformLocationForLevel(r3, r2);
        Logger.i("getLastKnowLocation end");
        return r4;
    }

    static /* synthetic */ BaseLocate a(a r0, BaseLocate r1) {
        r0.k = r1;
        return r1;
    }

    private LocationOption a(LocationOption r6, BDLocationCallback r7) {
        BDLocationCallback r8 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r7, BDLocationCallback.class, "com.obric.memorydata.plugin");
    L19:
        e = move-exception;
        e.printStackTrace();
        a(e, r8);
        return null;
    L4:
        if (a(r6.getBpeaCert()) == false) goto L17;
        BPEACertCheckResult r0 = this.l.checkAndTranslateCert(r6.getBpeaCert(), r6.getBpeaAction());     // Catch: BDLocationException -> L19
        if (r0 == null) goto L8;
        r6 = a(r0.getParams(), r6);     // Catch: BDLocationException -> L19
    L8:
        String r1 = this.l.getBpeaToken(r6.getBpeaCert());     // Catch: BDLocationException -> L19
        if (b(r1) == false) goto L12;
        r6.setMaxCacheTime(0);     // Catch: BDLocationException -> L19
    L12:
        if (BDLocationConfig.getHotBootLocToken().equals(r1) == false) goto L16;
        long r2 = BDLocationConfig.getHotBootCacheTime();     // Catch: BDLocationException -> L19
        if (r2 == (-1)) goto L16;
        r6.setMaxCacheTime(r2 * 1000);     // Catch: BDLocationException -> L19
    L16:
        r6.setUploadSource(r1);     // Catch: BDLocationException -> L19
        Logger.i("startLocation checkCert:" + r1);     // Catch: BDLocationException -> L19
    L18:
        return r6;
    L17:
        a(r6.isCert());     // Catch: BDLocationException -> L19
        goto L18
    }

    private LocationOption a(JSONObject r7, LocationOption r8) {
        Logger.i("BDLocationService.setCheckParams: " + r7);
        if (r7 == null) goto L14;
        if (r8 != null) goto L6;
        r8 = new LocationOption();
    L6:
        r8.setUpload(r7.optBoolean("single_is_upload", true));
        long r2 = r7.optInt("cache_time", 300000);
        boolean r0 = r7.optBoolean("use_cache_time", false);
        if (r2 <= 0) goto L10;
        if (r0 == true) goto L10;
        r2 = j();
    L10:
        r8.setMaxCacheTime(r2);
        r8.setLocationTimeOutMs(r7.optLong("time_out", 30000));
        if (r7.has("trigger_type") == false) goto L13;
        r8.setTriggerType(r7.optInt("trigger_type", 1));
    L13:
        r8.setInterval(r7.optInt(LocationMonitorConst.LOCATION_INTERVAL, 1000));
        r8.setGeocodeMode(r7.optInt("geocode_mode", 1));
        r8.setAccuracyLevel(r7.optInt("accuracy_level", 4));
        r8.setLocateType(r7.optInt(LocationMonitorConst.LOCATE_TYPE, 3));
    L14:
        return r8;
    }

    private BDLocationException a(String r2, String r3, String r4, BDLocationCallback r5) {
        BDLocationCallback r1 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin");
        BDLocationException r6 = new BDLocationException(r2, r3, r4);
        if (r1 == null) goto L5;
        r1.onError(r6);
    L5:
        return r6;
    }

    public static a a() {
        if (d != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L9;
        d = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return d;
    }

    static /* synthetic */ c a(a r0) {
        return r0.f;
    }

    private List<ScanResult> a(boolean r4, LocationOption r5, String r6, LBSLightLocationTraceLogger r7) {
        if (BDLocationConfig.isMockEnable() == false) goto L7;
        String r3 = "needn't perform lbs light location: mock location.";
    L5:
        Logger.i(r3);
        return null;
    L7:
        if (r4 == false) goto L10;
        r3 = "needn't perform lbs light location: cache location is valid.";
        goto L5
    L10:
        if (r5.isOnceLocation() == true) goto L13;
        r3 = "lbs light location is disabled in continuous location.";
        goto L5
    L13:
        if (r5.isDownGradeLocation() == false) goto L16;
        r3 = "lbs light location is disabled in downgrade location.";
        goto L5
    L16:
        if (LocationUtil.isUseByteLocationPolicy(r6) == false) goto L18;
    L20:
        Logger.i("lbs light location is enable, bpea: " + r6);
        LocationMonitor.lbsLightLocationTracePutCategoryData(r7, LBSLightLocationTraceLogger.BPEA, r6);
        if (a(false, r5, null) == true) goto L23;
        r3 = "RestrictedMode|background|LocationServer|permission unable";
        goto L5
    L23:
        LocationMonitor.lbsLightLocationTraceMetricBegin(r7, LBSLightLocationTraceLogger.GET_WIFI_MODULE);
        Logger.i("performLBSLightLocationFirstPart: before getWifiScanResultsForLBSLightLocation.");
    L30:
        th = move-exception;
        th.printStackTrace();
        if (r7 == null) goto L34;
        Logger.e("lbs light location failed: get wifi scan results failed: " + th, th);
        r7.putCategoryData(LBSLightLocationTraceLogger.IS_GET_WIFI_SUCCESS, false);
        r7.reportLBSLightLocationFailed(BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED, "lbs light location failed: get wifi scan results failed: " + th);
    L34:
        return null;
    L25:
        if (BDLocationConfig.enableUploadLastLocationInfo() == false) goto L27;
        a(r5.getBpeaCert(), r5);     // Catch: Throwable -> L30
    L27:
        List<ScanResult> r8 = LBSLightWifiUtils.getWifiScanResultsForLBSLightLocation(r7, r5);     // Catch: Throwable -> L30
        Logger.i("performLBSLightLocationFirstPart: after getWifiScanResultsForLBSLightLocation.");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r7, LBSLightLocationTraceLogger.GET_WIFI_MODULE);
        LocationMonitor.lbsLightLocationTracePutCategoryData(r7, LBSLightLocationTraceLogger.IS_GET_WIFI_SUCCESS, true);
        return r8;
    L18:
        if (BDLocationConfig.isEnableLocationOpt(r6) == true) goto L20;
        r3 = "not enable lbs light location with bpea: " + r6;
        goto L5
    }

    private void a(int r2, LocationOption r3, BDLocationCallback r4) {
        BDLocationCallback r1 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r4, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r2 != 3) goto L5;
        return;
    L5:
        if (r3.isOnceLocation() == true) goto L7;
        return;
    L7:
        if (BDLocationConfig.isAsyncScanWifi() == true) goto L9;
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r1, WifiUtil.WifiInfoJsonCallback.class) == false) goto L15;
        Logger.i("start scan wifi");
        WifiUtil.getWifiInfoJsonAsync((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (WifiUtil.WifiInfoJsonCallback) ZeusTransformUtils.preCheckCast(r1, WifiUtil.WifiInfoJsonCallback.class, "com.obric.memorydata.plugin"), r3.getBpeaCert(), r3.getLocationTraceLogger(), r3);
        return;
    }

    private void a(final BDLocation r3, BDLocationCallback r4) {
        final BDLocationCallback r5 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r4, BDLocationCallback.class, "com.obric.memorydata.plugin");
        AppExecutors.getInstance().mainThread().execute(new AnonymousClass13(this, r5, r3));
    }

    private static /* synthetic */ void a(BDLocationCallback r2, BDLocation r3) {
        ((BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r2, BDLocationCallback.class, "com.obric.memorydata.plugin")).onLocationChanged(r3);
    }

    private void a(BDLocationCallback r3, final BDLocationException r4) {
        final BDLocationCallback r5 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        AppExecutors.getInstance().mainThread().execute(new AnonymousClass14(this, r5, r4));
    }

    public static void a(LocationNotification r2, final int r3) {
        final LocationNotification r4 = (LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin");
        Handler r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new AnonymousClass2(r4, r3));
    }

    public static void a(LocationNotification r2, final Object r3) {
        final LocationNotification r4 = (LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin");
        Handler r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new AnonymousClass3(r4, r3));
    }

    public static void a(LocationSubmitNotification r2) {
        final LocationSubmitNotification r3 = (LocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationSubmitNotification.class, "com.obric.memorydata.plugin");
        Handler r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new AnonymousClass6(r3));
    }

    private void a(LocationOption r3, BDLocation r4) {
        LocationMonitor.locationTraceLogBegin(r3.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RESET_LOCATE_TYPE_DURATION);
        boolean r2 = LocationUtil.isChineseRegion(r4);
        Logger.i("getLocateType check region isChineseRegion:" + r2);
        r3.setChineseRegion(r2);
        if (r2 == true) goto L5;
        r3.setLocateType(0);
    L5:
        LocationMonitor.locationTraceLogEnd(r3.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RESET_LOCATE_TYPE_DURATION);
    }

    private void a(LocationOption r9, List<ScanResult> r10, d r11) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Logger.i("performLBSLightSubmitV2 executed.");
        LBSLightLocationTraceLogger r8 = r9.getLBSLightLocationTraceLogger();
        LocInfoRspData r12 = ServerApi.doLightLocationSubmitV2(r9.startLocationTimestampInMillis, r9.getUploadSource(), r9.getTriggerType(), BDLocationConfig.isEnableLocationOptEncrypt(), r8, r6, r9.getLocateId());     // Catch: Throwable -> L13
        if (r12 == null) goto L24;
        BDLocation r0 = LocationUtil.locationResultToBDLocation(new BDLocation("network", LocationInfoConst.LIGHT), r12.location);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r12.submitLogId) == true) goto L9;
        if (r0 == null) goto L9;
        r0.setSubmitLogId(r12.submitLogId);     // Catch: Throwable -> L13
    L9:
        r9.setLightLocation(r0);     // Catch: Throwable -> L13
        Logger.i("location-trace-core enablePreLocationCallback: " + BDLocationConfig.enablePreLocationCallback());     // Catch: Throwable -> L13
        if (BDLocationConfig.enablePreLocationCallback() == false) goto L25;
        r11.a(r0);     // Catch: Throwable -> L13
        return;
    L25:
        return;
    L24:
        return;
    L13:
        th = move-exception;
        Logger.i("doLightLocationSubmitV2 failed: " + th);
        if (r8 != null) goto L17;
        return;
    L17:
        if (th.getMessage() != null) goto L19;
        String r13 = "empty";
    L20:
        r8.reportLBSLightLocationFailed(BDLocationException.ERROR_CODE_LBS_LIGHT_SUBMITV2_FAILED, r13);
        return;
    L19:
        r13 = th.getMessage();
        goto L20
    }

    private void a(BDLocationException r2, BDLocationCallback r3) {
        BDLocationCallback r1 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.onError(r2);
        return;
    }

    private void a(final LBSLightLocationTraceLogger r8, final LocationOption r9, List<ScanResult> r10, final d r11) {
        final List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (Looper.myLooper() == Looper.getMainLooper()) goto L5;
        boolean r12 = true;
    L6:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r8, LBSLightLocationTraceLogger.SWITCH_THREAD, Boolean.valueOf(!r12));
        LocationMonitor.lbsLightLocationTracePutCategoryData(r8, LBSLightLocationTraceLogger.THREAD_NAME, Thread.currentThread().getName());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r8, LBSLightLocationTraceLogger.SWITCH_THREAD_SECOND_TIME);
        Runnable r6 = new $$Lambda$a$Xm7plFcloaa59HJeEEHw4xPrjGM(this, r8, r9, r4, r11);
        if (r12 == false) goto L9;
        r6.run();
        return;
    L9:
        this.h.post(r6);
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void a(BDLocationExtraDataServer r4) {
        if (this.f1904a.size() <= 20) goto L7;
        BDLocationExtraDataServer r0 = (BDLocationExtraDataServer) ZeusTransformUtils.preCheckCast(this.f1904a.remove(0), BDLocationExtraDataServer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        r0.stopCollectExtraData();
    L7:
        this.f1904a.add(r4);
    }

    static /* synthetic */ void a(a r2, int r3, LocationOption r4, BDLocationCallback r5) {
        r2.a(r3, r4, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(a r2, BDLocation r3, BDLocationCallback r4) {
        r2.a(r3, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r4, BDLocationCallback.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ void a(a r2, BDLocationCallback r3, BDLocationException r4) {
        r2.a((BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin"), r4);
    }

    static /* synthetic */ void a(a r0, LocationOption r1, BDLocation r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(a r0, BDLocationExtraDataServer r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(a r2, String r3, BDLocationCallback r4) {
        r2.a(r3, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r4, BDLocationCallback.class, "com.obric.memorydata.plugin"));
    }

    public static void a(final Object r2, LocationSubmitNotification r3) {
        final LocationSubmitNotification r4 = (LocationSubmitNotification) ZeusTransformUtils.wrapperContextForParams(r3, LocationSubmitNotification.class, "com.obric.memorydata.plugin");
        Handler r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new AnonymousClass5(r2, r4));
    }

    private void a(Object r21, LocationOption r22) {
        long r1 = System.currentTimeMillis();
        LocationManager r3 = (LocationManager) ZeusTransformUtils.preCheckCast(this.g.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");
        Location r8 = BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r3, "gps", r21);
        if (r8 != null) goto L5;
    L7:
        boolean r6 = true;
    L9:
        if (r8 == null) goto L11;
        long r17 = System.currentTimeMillis() - r8.getTime();
    L12:
        long r11 = System.currentTimeMillis() - r1;
        long r13 = System.currentTimeMillis();
        Location r7 = BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r3, "network", r21);
        if (r7 != null) goto L15;
    L17:
        boolean r19 = r6;
    L18:
        if (r7 == null) goto L20;
        long r15 = System.currentTimeMillis() - r7.getTime();
    L21:
        r22.setLastLocationEntity(new LastLocationEntity(r7, r8, System.currentTimeMillis() - r13, r11, System.currentTimeMillis() - r1, r15, r17, r19));
        return;
    L20:
        r15 = -1;
        goto L21
    L15:
        if (LocationUtil.convertLocationToGCJ_O2(r7, LocationInfoConst.WGS_84) == true) goto L17;
        Logger.i("collectLastKnownLocation: lastNetworkLocation convertLocationToGCJ_O2 error");
        r19 = false;
        goto L18
    L11:
        r17 = -1;
        goto L12
    L5:
        if (LocationUtil.convertLocationToGCJ_O2(r8, LocationInfoConst.WGS_84) == true) goto L7;
        Logger.i("collectLastKnownLocation: lastGpsLocation convertLocationToGCJ_O2 error");
        r6 = false;
        goto L9
    }

    private void a(String r4, BDLocationCallback r5) {
        BDLocationCallback r6 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Logger.i("checkAbleLocation is not allowed, error code is:" + r4);
        a(r6, new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r4));
    }

    private void a(String r2, LocationOption r3) {
        if ("bpea-light_navigation".equals(r2) == true) goto L7;
        Logger.i("needn't refresh maxCacheTime for: " + r2);
        return;
    L7:
        if (r3.isOnceLocation() == false) goto L10;
        Logger.i("needn't refresh maxCacheTime for onceLocation.");
        return;
    L10:
        Logger.i("change maxCacheTime to 0L for: " + r2);
        r3.setMaxCacheTime(0);
    }

    private void a(boolean r4) {
        if (BDLocationConfig.shouldRequestLocation() == true) goto L8;
        if (r4 == false) goto L7;
        return;
    L7:
        throw a(BDLocationExceptionMessage.NON_COMPLIANCE_MESSAGE, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_BOOT_NO_CERT_LOCATE, null);
    }

    private boolean a(LocationOption r2, boolean r3) {
        if (r3 == false) goto L8;
        String r1 = "canMergeLocation: cacheLocationValidity is true, return false.";
    L5:
        Logger.i(r1);
        return false;
    L8:
        if (r2.isDownGradeLocation() == false) goto L11;
        r1 = "canMergeLocation: isDownGradeLocation is true, return false.";
        goto L5
    L11:
        if (r2.isOnceLocation() == true) goto L13;
    L16:
        r1 = "canMergeLocation: not merge, continuous location or not support, return false.";
        goto L5
    L13:
        if (this.n.a(r2) == false) goto L16;
        return true;
    }

    static /* synthetic */ boolean a(a r0, Object r1) {
        return r0.a(r1);
    }

    private boolean a(Object r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (this.l == null) goto L9;
        return true;
    L9:
        return false;
    }

    private int b(LocationOption r1, BDLocation r2) {
        int r0 = r1.getLocateType();
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        return BDLocationConfig.getLocateType();
    }

    static /* synthetic */ int b(a r0, LocationOption r1, BDLocation r2) {
        return r0.b(r1, r2);
    }

    static /* synthetic */ long b(a r2) {
        return r2.o;
    }

    public static void b(LocationNotification r2, final int r3) {
        final LocationNotification r4 = (LocationNotification) ZeusTransformUtils.wrapperContextForParams(r2, LocationNotification.class, "com.obric.memorydata.plugin");
        Handler r0 = c;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.post(new AnonymousClass4(r4, r3));
    }

    private /* synthetic */ void b(LBSLightLocationTraceLogger r3, LocationOption r4, List r5, d r6) {
        List<ScanResult> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r3, LBSLightLocationTraceLogger.SWITCH_THREAD_SECOND_TIME);
        a(r4, r7, r6);
    }

    private void b(String r5, LocationOption r6) {
        IDYHostInfoProvider r4 = BDLocationConfig.getDYHostInfoProvider();
        if (r4 != null) goto L18;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
    L11:
        StringBuilder r8 = new StringBuilder().append("refreshSearchLocationCacheTimeIfNeed returned: dyHostInfoProvider == null, context == null: ");
        if (r7 != null) goto L14;
        boolean r9 = true;
    L15:
        Logger.i(r8.append(r9).toString());
        return;
    L14:
        r9 = false;
        goto L15
    L7:
        if ("com.ss.android.ugc.aweme".equals(r7.getPackageName()) == false) goto L11;
        Logger.e("refreshSearchLocationCacheTimeIfNeed returned: unexpected dyHostInfoProvider == null in DY.");
        return;
    L18:
        if (r4.isPersonalizedRecommendationEnable() == true) goto L22;
        Logger.i("refreshSearchLocationCacheTimeIfNeed returned: personalized recommendation not enabled.");
        return;
    L22:
        if ("bpea-search_requset_net_trytolocate_cache_first".equals(r5) == true) goto L26;
        Logger.i("needn't refresh location cache time, bpea is " + r5);
        return;
    L26:
        if (r6.isOnceLocation() == true) goto L29;
        Logger.i("needn't refresh location cache time: continuous location");
        return;
    L29:
        long r0 = BDLocationConfig.getSearchLocationCacheTime();
        if (r0 <= 0) goto L32;
        r6.setMaxCacheTime(r0);
        String r10 = "refresh search location cache time: " + r0 + ", bpea: " + r5;
    L33:
        Logger.i(r10);
        return;
    L32:
        r10 = "needn't refresh location cache time: searchLocationMaxCacheTime <= 0";
        goto L33
    }

    private boolean b(String r5) {
        String r4 = BDLocationConfig.getLocationCacheTokenWhiteList();
        if (BDLocationConfig.isEnableLocationCacheTokenWhiteList() == true) goto L5;
    L17:
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L17;
        if (TextUtils.isEmpty(r5) == true) goto L17;
        String[] r6 = r4.split(",");
        int r0 = r6.length;
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        if (r5.equals(r6[r2].trim()) == true) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return false;
    L15:
        return true;
    }

    private static String[] b(int r3) {
        if (r3 != 0) goto L7;
        return new String[]{"android.permission.ACCESS_FINE_LOCATION"};
    L7:
        if (r3 != 1) goto L11;
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION"};
    L11:
        return new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
    }

    static /* synthetic */ BaseLocate c(a r0) {
        return r0.k;
    }

    static /* synthetic */ IBPEALocal d(a r0) {
        return r0.l;
    }

    static /* synthetic */ a g() {
        return d;
    }

    static /* synthetic */ Handler h() {
        return c;
    }

    static /* synthetic */ Looper i() {
        return f1903b;
    }

    private long j() {
        return com.bytedance.bdlocation_impl.a.a.a().d() + 1000;
    }

    public static /* synthetic */ void lambda$Xm7plFcloaa59HJeEEHw4xPrjGM(a r0, LBSLightLocationTraceLogger r1, LocationOption r2, List r3, d r4) {
        r0.b(r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$b8ZfA_LZToBENLAH95Zka7bpvLA(BDLocationCallback r0, BDLocation r1) {
        a(r0, r1);
    }

    public BDLocation a(int r2, boolean r3, boolean r4) {
        a(r3);
        String r5 = LocationUtil.allowUseLocation(r4);
        if ("1".equals(r5) == false) goto L7;
        return a(r2);
    L7:
        throw a(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r5, null);
    }

    public BDLocation a(LocationOption r5) {
        final CountDownLatch r0 = new CountDownLatch(1);
        final BDLocation[] r2 = new BDLocation[1];
        final BDLocationException[] r1 = new BDLocationException[1];
        b(new AnonymousClass1(this, r2, r0, r1), r5);
        r0.await(r5.getLocationTimeOutMs(), TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L10
        if (r1[0] != null) goto L9;
        return r2[0];
    L9:
        throw r1[0];
    L10:
        e = move-exception;
        throw new BDLocationException(e, LocationInfoConst.SYSTEM, "0");
    }

    public BDLocation a(LocationOption r3, LocationCacheInfo r4) {
        if (r3.isOnceLocation() == true) goto L7;
        String r2 = "LocationCache MaxCacheTime： " + r3.getMaxCacheTime();
    L5:
        Logger.i(r2);
        return null;
    L7:
        if (r4 != null) goto L9;
        r4 = this.e.fastGetLocationCacheUnsafe();
    L9:
        if (r4 != null) goto L11;
        r2 = "LocationCache cacheInfo is null";
        goto L5
    L11:
        BDLocation r5 = r4.getLatestLocation();
        if (r5 != null) goto L14;
    L18:
        r2 = "LocationCache cache is null";
        goto L5
    L14:
        if (LocationUtil.isEmpty(r5) == true) goto L18;
        r5.setCache(true);
        Logger.i("LocationCache: cache");
        return r5;
    }

    public BDLocation a(Object r2, int r3) {
        if (a(r2) == false) goto L6;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r2, "getIPLocation");
    L6:
        return LocationUtil.getIPResult(r3);
    }

    public BDLocation a(Object r2, int r3, boolean r4) {
        if (a(r2) == false) goto L7;
        return a(r2, r4);
    L7:
        return a(r3, true, r4);
    }

    public BDLocation a(Object r3, boolean r4) {
        Logger.i("getLastKnowLocation start");
        String r5 = LocationUtil.allowUseLocation(r4);
        Logger.i("getLastKnowLocation allowLocation");
        BDLocation r1 = null;
        if ("1".equals(r5) == false) goto L17;
        int r6 = -1;
        if (a(r3) == false) goto L15;
        BPEACertCheckResult r7 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r3, "getLastKnowLocation");
        Logger.i("getLastKnowLocation checkAndTranslateCert");
        if (r7 == null) goto L11;
        JSONObject r8 = r7.getParams();
        if (r8 == null) goto L11;
        r6 = r8.optInt("accuracyLevel", 0);
    L11:
        r1 = a(r6);
        if (r1 == null) goto L14;
        r1.setCache(true);
    L14:
        Logger.i("getLastKnowLocation end");
    L15:
        return r1;
    L17:
        throw a(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r5, null);
    }

    public BDPoint a(BDPoint r1) {
        return LocationUtil.convertGCJ02(r1);
    }

    public synchronized BdGisResult a(double r7, double r9, int r11, Object r12, int r13) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (a(r12) == false) goto L6;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r12, "geocode");     // Catch: Throwable -> L9
    L6:
        new LocationOption().setTriggerType(r11);     // Catch: Throwable -> L9
        BdGisResult r8 = LocationUtil.getGeocodeResult(r7, r9, r11, r13);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r8;
    }

    public BdGisResult a(double r9, double r11, int r13, boolean r14, int r15) {
        a(r14);
        return a(r9, r11, r13, null, r15);
    }

    public void a(Activity r4, Object r5, int r6, RequestPermissionUtils.OnPermissionListener r7) {
        Activity r8 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.memorydata.plugin");
        final RequestPermissionUtils.OnPermissionListener r9 = (RequestPermissionUtils.OnPermissionListener) ZeusTransformUtils.wrapperContextForParams(r7, RequestPermissionUtils.OnPermissionListener.class, "com.obric.memorydata.plugin");
        if (PermissionManager.canRequestLocationPermission() == true) goto L7;
        r9.onPermissionDenied();
        return;
    L7:
        if (PermissionManager.hasLocationPermissions((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L16;
    L13:
        r9.onPermissionGranted();
        return;
    L16:
        if (a(r5) == false) goto L11;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r5, "requestLocationPermissionWithCert");     // Catch: Exception -> L15
    L11:
        LocationEvent.onRequestPermission();     // Catch: Exception -> L15
        RequestPermissionUtils.requestPermissionsLimited(r8, b(r6), new AnonymousClass15(this, r9));     // Catch: Exception -> L15
    }

    public void a(BDLocationCallback r3, LocationOption r4) {
        b((BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin"), r4);
    }

    public void a(final Object r12, final String r13, final boolean r14) {
        final long r4 = System.currentTimeMillis();
        final long r7 = r4 - BDLocationConfig.getAppBootTime();
        Logger.i("start getLightLocation:" + r4 + "-isColdBoot:" + r14);
        if (BDLocationConfig.enableLightLocation() == true) goto L7;
        Logger.i("getLightLocation unable");
        return;
    L7:
        if (a(null) == true) goto L11;
        Logger.i("getLightLocation checkInit error");
        LocationMonitor.doLightLocationError(BDLocationException.ERROR_INIT_LOCATION, "location checkInit error", r14, false);
        return;
    L11:
        if (LocationUtil.disableLightLocationIfMockEnabled() == false) goto L14;
        Logger.i("getLightLocation test channel:" + BDLocationConfig.getChannel());
        LocationMonitor.doLightLocationError(BDLocationException.ERROR_LIGHT_LOCATION_WHEN_MOCK_ENABLED, "mock enabled", r14, false);
        return;
    L14:
        String r0 = LocationUtil.allowUseLocation(true);
        if ("1".equals(r0) == true) goto L18;
        Logger.i("getLightLocation unable use location allowLocation:" + r0);
        LocationMonitor.doLightLocationError(r0, "unable use location", r14, false);
        return;
    L18:
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass7(this, r12, r13, r4, r14, r7));
    }

    public void a(final String r3) {
        Logger.i("BDLocationService.stopLocationForBusiness: " + r3);
        c.post(new AnonymousClass12(this, r3));
    }

    public boolean a(BDLocation r3, LocationOption r4) {
        return a(r3, r4, null, true);
    }

    public boolean a(BDLocation r7, LocationOption r8, LocateReasonEntity r9, boolean r10) {
        if (r7 != null) goto L9;
        Logger.i("LocationCache IS NULL");
        if (r9 == null) goto L7;
        r9.setReasonCode(0);
    L7:
        return false;
    L9:
        if (r8.getGeocodeMode() == 0) goto L17;
        if (r7.hasAddress() == true) goto L17;
        Logger.i("LocationCache NO_GEOCODE");
        if (r9 == null) goto L15;
        r9.setReasonCode(1);
    L15:
        return false;
    L17:
        if (LocationUtil.checkCacheTime(r7.getLocationMs(), r8.getMaxCacheTime(), TextUtils.isEmpty(r8.getExtra())) == true) goto L23;
        Logger.i("LocationCache checkCacheTime is false");
        if (r9 == null) goto L21;
        r9.setReasonCode(2);
    L21:
        return false;
    L23:
        if (BDLocationConfig.getDisableTailLocateOptimizeSource().contains(r8.getUploadSource()) == false) goto L25;
    L31:
        if (r9 == null) goto L33;
        r9.setReasonCode(3);
    L33:
        return true;
    L25:
        if (BDLocationConfig.enableTailLocateOptimize() == false) goto L31;
        if (r10 == true) goto L31;
        Logger.i("LocationCache cache is not recommend, bpea:" + r8.getUploadSource());
        if (r9 == null) goto L30;
        r9.setReasonCode(4);
    L30:
        return false;
    }

    public boolean a(BDLocationCallback r5) {
        BDLocationCallback r6 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (BDLocationConfig.initIfNeed() == false) goto L6;
        return true;
    L6:
        Logger.i("Must be called after BDLocation initialization!");
        if (r6 == null) goto L11;
        a(r6, new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));
        return false;
    L11:
        return false;
    }

    public boolean a(boolean r6, LocationOption r7, BDLocationCallback r8) {
        BDLocationCallback r9 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r8, BDLocationCallback.class, "com.obric.memorydata.plugin");
        LBSLightLocationTraceLogger r0 = null;
        if (r7 != null) goto L5;
        LBSLightLocationTraceLogger r1 = null;
    L6:
        LocationMonitor.lbsLightLocationTraceMetricBegin(r1, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
    L29:
        th = move-exception;
        if (r7 == null) goto L33;
        r0 = r7.getLBSLightLocationTraceLogger();
    L33:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r0, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        throw th;
    L8:
        if (a(r9) == true) goto L16;
        Logger.i("Must be called after BDLocation initialization!");     // Catch: Throwable -> L29
        if (r7 == null) goto L13;
        r0 = r7.getLBSLightLocationTraceLogger();
    L13:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r0, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return false;
    L16:
        String r10 = LocationUtil.allowUseLocation(r6, false, true);     // Catch: Throwable -> L29
        if ("1".equals(r10) == true) goto L24;
        a(r10, r9);     // Catch: Throwable -> L29
        if (r7 == null) goto L22;
        r0 = r7.getLBSLightLocationTraceLogger();
    L22:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r0, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return false;
    L24:
        if (r7 == null) goto L27;
        r0 = r7.getLBSLightLocationTraceLogger();
    L27:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r0, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return true;
    L5:
        r1 = r7.getLBSLightLocationTraceLogger();
        goto L6
    }

    public BDLocation b(LocationOption r2) {
        return a(r2, null);
    }

    public void b() {
        c.post(new AnonymousClass9(this));
    }

    public void b(BDLocationCallback r17, final LocationOption r18) {
        final BDLocationCallback r1 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r17, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L6;
        Logger.e("BDLocationService.startLocation failed: mOption == null.");
        return;
    L6:
        r18.startLocationElapsedRealtimeMillis = SystemClock.elapsedRealtime();
        r18.startLocationTimestampInMillis = System.currentTimeMillis();
        Logger.i("location-trace-core set startLocationTimestampInMillis: " + r18.startLocationTimestampInMillis);
        r18.setLocateId(System.currentTimeMillis() + "" + this.m.incrementAndGet());
        if (r18.getLBSLightLocationTraceLogger() != null) goto L9;
        LBSLightLocationTraceLogger r2 = new LBSLightLocationTraceLogger();
        r2.begin(LBSLightLocationTraceLogger.TOTAL);
        r2.begin(LBSLightLocationTraceLogger.PREPARE);
        r2.begin(LBSLightLocationTraceLogger.SUB_PREPARE);
        r18.setLBSLightLocationTraceLogger(r2);
    L9:
        LBSLightLocationTraceLogger r10 = r18.getLBSLightLocationTraceLogger();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.SUB_PREPARE);
        Logger.i("BDLocationService.startLocation is DownGradeLocation:" + r18.isDownGradeLocation());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r10, LBSLightLocationTraceLogger.WRAP_LOCATION_OPTION);
        if (r18.isDownGradeLocation() == false) goto L12;
        LocationOption r11 = new LocationOption(r18);
    L17:
        Logger.i("after check cert, locateType: " + r11.getLocateType());
        String r8 = r11.getUploadSource();
        b(r8, r11);
        a(r8, r11);
        long r3 = r11.getHostSwitchThreadDuration();
        if (r3 <= 0) goto L20;
        LocationMonitor.lbsLightLocationTracePutMetricData(r10, LocationMonitorConst.HOST_SWITCH_THREAD_DURATION, r3);
        LocationMonitor.locationTracePutMetricData(r11.getLocationTraceLogger(), LocationMonitorConst.HOST_SWITCH_THREAD_DURATION, r3);
    L20:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.WRAP_LOCATION_OPTION);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r10, LBSLightLocationTraceLogger.LOCATION_CACHE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r10, LBSLightLocationTraceLogger.GET_SUITABLE_CACHE);
        final LocationCacheInfo r12 = this.e.fastGetLocationCacheUnsafe();
        final BDLocation r13 = a(r11, r12);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.GET_SUITABLE_CACHE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r10, LBSLightLocationTraceLogger.CHECK_CACHE_VALIDITY);
        final LocateReasonEntity r14 = new LocateReasonEntity();
        boolean r4 = r12.isRecommendLocation();
        final boolean r15 = a(r13, r11, r14, r4);
        Logger.i("BDLocationService.startLocation cacheLocationValidity:" + r15);
        Logger.i("enableTailLocateOptimize:" + BDLocationConfig.enableTailLocateOptimize() + " isRecommendLocation:" + r4);
        LocationMonitor.locationTracePutCategoryData(r11.getLocationTraceLogger(), LocationMonitorConst.ENABLE_TAIL_LOCATE_OPTIMIZE, Boolean.valueOf(BDLocationConfig.enableTailLocateOptimize()));
        LocationMonitor.locationTracePutCategoryData(r11.getLocationTraceLogger(), LocationMonitorConst.IS_RECOMMEND_LOCATION, Boolean.valueOf(r4));
        LocationMonitor.locationTracePutCategoryData(r11.getLocationTraceLogger(), LocationMonitorConst.MAX_WAIT_GPS_TIME_MILLIS, Long.valueOf(BDLocationConfig.maxWaitGPSTimeMillis()));
        LocationMonitor.locationTracePutCategoryData(r11.getLocationTraceLogger(), LocationMonitorConst.PRE_LOCATION_CALLBACK, Boolean.valueOf(BDLocationConfig.enablePreLocationCallback()));
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.CHECK_CACHE_VALIDITY);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.LOCATION_CACHE);
        C0108a r5 = this.n;
        Handler r6 = this.i;
        Handler r7 = c;
        final d r9 = new d(r1, r11, r5, r6, r7);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r10, LBSLightLocationTraceLogger.LOCATION_MERGE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r10, LBSLightLocationTraceLogger.LOCATION_MERGE_SYNC);
        StationarySceneCacheInfo r16 = new StationarySceneCacheInfo();
        r16.setLocateId(r11.getLocateId());
        r11.setStationarySceneCacheInfo(r16);
        if (r11.isDownGradeLocation() == false) goto L23;
    L28:
        C0108a r19 = this.n;
        monitor-enter(r19);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.LOCATION_MERGE_SYNC);     // Catch: Throwable -> L50
        if (a(r11, r15) == true) goto L33;
    L42:
        monitor-exit(r19);     // Catch: Throwable -> L50
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.LOCATION_MERGE);
        List<ScanResult> r20 = a(r15, r11, r8, r10);
        LocationMonitor.locationTraceLogBegin(r11.getLocationTraceLogger(), LocationMonitorConst.LOCATION_THREAD_SWITCH_DURATION);
        final LocationOption r21 = r11;
        r7.post(new AnonymousClass8(this, r21, r13, r9, r15, r12, r14, r18));
        if (r20 != null) goto L46;
    L48:
        Logger.i("location-trace-core needn't perform lbs light location: lbsLightLocationScanResults is (null || empty).");
        return;
    L46:
        if (r20.isEmpty() == true) goto L48;
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.PREPARE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r10, LBSLightLocationTraceLogger.NETWORK_TOTAL);
        a(r10, r11, r20, r9);
        return;
    L33:
        if (this.n.a() == false) goto L41;
        Logger.i("location-trace-core location trace is start");     // Catch: Throwable -> L50
        final BDLocation r22 = this.n.d();     // Catch: Throwable -> L50
        if (r22 == null) goto L38;
        this.i.post(new $$Lambda$a$b8ZfA_LZToBENLAH95Zka7bpvLA(r1, r22));     // Catch: Throwable -> L50
        String r0 = "location-trace-core location trace is start and already has light location result, callback immediately.";
    L37:
        Logger.i(r0);     // Catch: Throwable -> L50
        monitor-exit(r19);     // Catch: Throwable -> L50
        return;
    L38:
        r11.isCallbackThroughLocateTrace = true;     // Catch: Throwable -> L50
        this.n.a(r1);     // Catch: Throwable -> L50
        r0 = "location-trace-core location trace is start but not have light location result, merge.";
        goto L37
    L41:
        this.n.b(r11);     // Catch: Throwable -> L50
        r11.isCallbackThroughLocateTrace = true;     // Catch: Throwable -> L50
        this.n.a(r1);     // Catch: Throwable -> L50
        Logger.i("no locating task, set locate start: true.");     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    L23:
        if (r11.isOnceLocation() == false) goto L28;
        boolean r23 = LocationUtil.checkStationaryScenePolicyBeforeLocation(r11.getUploadSource(), r13, r11.getLocationTraceLogger());
        Logger.i("checkStationaryScenePolicyBeforeLocation hitStationaryScene:" + r23);
        LocationMonitor.locationTracePutCategoryData(r11.getLocationTraceLogger(), LocationMonitorConst.HIT_STATIONARY_SCENE, Boolean.valueOf(r23));
        r11.setHitStationaryScene(r23);
        if (r23 == false) goto L28;
        LocationMonitor.locationTraceLogBegin(r11.getLocationTraceLogger(), "total_duration");
        SensorInfoManager.getInstance().registerListener(5);
        Logger.i("location-trace-core location-trace-core isHitStationaryScene");
        a(r13, r9);
        return;
    L12:
        Logger.i("BDLocationService.startLocation, before checkCert, locateType: " + r18.getLocateType());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r10, LBSLightLocationTraceLogger.CHECK_CERT);
        LocationOption r24 = a(r18, r1);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r10, LBSLightLocationTraceLogger.CHECK_CERT);
        if (r24 != null) goto L16;
        Logger.i("cert check error");
        return;
    L16:
        r11 = new LocationOption(r24);
        goto L17
    }

    public boolean b(BDLocation r3, LocationOption r4) {
        if (r3 != null) goto L8;
        String r5 = "LocationCache IS NULL";
    L5:
        Logger.i(r5);
        return false;
    L8:
        if (r4.getGeocodeMode() == 0) goto L13;
        if (r3.hasAddress() == true) goto L13;
        r5 = "LocationCache NO_GEOCODE";
    L13:
        if (LocationUtil.checkCacheTime(r3.getLocationMs(), BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity()) == true) goto L15;
        r5 = "LocationCache checkCacheTime is false";
        goto L5
    L15:
        return true;
    }

    public void c() {
        Logger.i("BDLocationService.stopLocationBecauseEnterBackground.");
        c.post(new AnonymousClass10(this));
    }

    public void d() {
        Logger.i("BDLocationService.stopLocation.");
        c.post(new AnonymousClass11(this));
    }

    public LocationCache e() {
        return this.e;
    }

    public ISceneStatusCallback f() {
        return b.a();
    }
}
