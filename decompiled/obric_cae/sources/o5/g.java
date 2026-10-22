package o5;

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
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.IDYHostInfoProvider;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LastLocationEntity;
import com.bytedance.bdlocation.entity.LocateReasonEntity;
import com.bytedance.bdlocation.entity.bpea.BPEACertCheckResult;
import com.bytedance.bdlocation.entity.gis.BdGisResult;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationExtraDataTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.StationarySceneCacheInfo;
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
import com.obric.cae.cloud.CloudServiceConstants;
import j1.d0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Looper f9674l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Handler f9675m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile g f9676n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocationCache f9677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.s f9678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f9679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f9680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f9681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BaseLocate f9682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBPEALocal f9683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f9684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f9685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f9686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<BDLocationExtraDataServer> f9687k;

    public class a implements BDLocationCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BDLocation[] f9688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f9689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BDLocationException[] f9690c;

        public a(BDLocation[] r8, CountDownLatch r10, BDLocationException[] r11) {
            this.f9688a = r8;
            this.f9689b = r10;
            this.f9690c = r11;
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public final void onError(BDLocationException r8) {
            this.f9690c[0] = r8;
            this.f9689b.countDown();
        }

        @Override // com.bytedance.bdlocation.callback.BDLocationCallback
        public final void onLocationChanged(BDLocation r8) {
            this.f9688a[0] = r8;
            this.f9689b.countDown();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocationOption f9691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BDLocation f9692b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ x f9693m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f9694n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ LocationCacheInfo f9695o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final /* synthetic */ LocateReasonEntity f9696p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final /* synthetic */ LocationOption f9697q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ g f9698r;

        public b(g r8, LocationOption r10, BDLocation r11, x r12, boolean r13, LocationCacheInfo r14, LocateReasonEntity r15, LocationOption r16) {
            this.f9698r = r8;
            this.f9691a = r10;
            this.f9692b = r11;
            this.f9693m = r12;
            this.f9694n = r13;
            this.f9695o = r14;
            this.f9696p = r15;
            this.f9697q = r16;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g r8 = g.f9676n;
            monitor-enter(r8);
            LocationMonitor.locationTraceLogEnd(this.f9691a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_THREAD_SWITCH_DURATION);     // Catch: Throwable -> L93
            this.f9691a.setBackground(LocationUtil.isBackground());     // Catch: Throwable -> L93
            this.f9691a.setUploadInterval(m5.a.a().b() / 1000);     // Catch: Throwable -> L93
            g.a(this.f9698r, this.f9691a, this.f9692b);     // Catch: Throwable -> L93
            LocationMonitor.locationTraceLogBegin(this.f9691a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_BEFORE_START_DURATION);     // Catch: Throwable -> L93
            g r10 = this.f9698r;     // Catch: Throwable -> L93
            LocationOption r11 = this.f9691a;     // Catch: Throwable -> L93
            x r12 = this.f9693m;     // Catch: Throwable -> L93
            r10.getClass();     // Catch: Throwable -> L93
            int r13 = 1;
            if (g.c(true, r11, r12) == true) goto L10;
            Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L93
            monitor-exit(r8);     // Catch: Throwable -> L93
            return;
        L10:
            if (this.f9694n == false) goto L18;
            if (LocationUtil.isLocationEnabled() == true) goto L16;
            Logger.i("check allowUseLocation ERROR_DEVICE_LOCATION_DISABLE");     // Catch: Throwable -> L93
            g r14 = this.f9698r;     // Catch: Throwable -> L93
            x r15 = this.f9693m;     // Catch: Throwable -> L93
            r14.getClass();     // Catch: Throwable -> L93
            g.q(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE, r15);     // Catch: Throwable -> L93
            Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L93
            monitor-exit(r8);     // Catch: Throwable -> L93
            return;
        L16:
            Logger.i("location cache is validity, return cache location ");     // Catch: Throwable -> L93
            LocationMonitor.locationTraceLogEnd(this.f9691a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L93
            g r16 = this.f9698r;     // Catch: Throwable -> L93
            BDLocation r17 = this.f9692b;     // Catch: Throwable -> L93
            x r18 = this.f9693m;     // Catch: Throwable -> L93
            r16.getClass();     // Catch: Throwable -> L93
            AppExecutors.getInstance().mainThread().execute(new l(r17, r18));     // Catch: Throwable -> L93
        L90:
            Logger.d("startLocation :");     // Catch: Throwable -> L93
            monitor-exit(r8);     // Catch: Throwable -> L93
            return;
        L18:
            if (LocationUtil.isLocationEnabled() == true) goto L22;
            Logger.i("check allowUseLocation ERROR_DEVICE_LOCATION_DISABLE");     // Catch: Throwable -> L93
            g r19 = this.f9698r;     // Catch: Throwable -> L93
            x r20 = this.f9693m;     // Catch: Throwable -> L93
            r19.getClass();     // Catch: Throwable -> L93
            g.q(BDLocationException.ERROR_DEVICE_LOCATION_DISABLE, r20);     // Catch: Throwable -> L93
            Logger.i("RestrictedMode|background|LocationServer|permission unable");     // Catch: Throwable -> L93
            monitor-exit(r8);     // Catch: Throwable -> L93
            return;
        L22:
            g r21 = this.f9698r;     // Catch: Throwable -> L93
            LocationOption r22 = this.f9691a;     // Catch: Throwable -> L93
            r21.getClass();     // Catch: Throwable -> L93
            int r23 = r22.getLocateType();     // Catch: Throwable -> L93
            if (r23 != (-1)) goto L25;
            r23 = BDLocationConfig.getLocateType();     // Catch: Throwable -> L93
        L25:
            Logger.i("startLocation locateType:" + r23);     // Catch: Throwable -> L93
            if (this.f9691a.isOnceLocation() == false) goto L75;
            if (LocationInfoConst.LIBRA_PARAM_V2.equals(BDLocationConfig.getByteLocationLibraParam()) == false) goto L31;
            if (r23 == 0) goto L31;
            Logger.i("location-trace-core change locate type from " + r23 + " to LocationInfoConst.LOCATE_BYTE");     // Catch: Throwable -> L93
            r23 = 3;
        L31:
            BaseLocate r24 = this.f9698r.f9678b.c(r23);     // Catch: Throwable -> L93
            if (r24 != null) goto L34;
            Logger.i("mLocation is null");     // Catch: Throwable -> L93
            BDLocationException r25 = new BDLocationException("未获取到定位内核异常", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_NO_LOCATE);     // Catch: Throwable -> L93
            g r26 = this.f9698r;     // Catch: Throwable -> L93
        L73:
            x r27 = this.f9693m;     // Catch: Throwable -> L93
            r26.getClass();     // Catch: Throwable -> L93
            g.p(r27, r25);     // Catch: Throwable -> L93
        L89:
            LocationMonitor.getLightLocationMonitor();     // Catch: Throwable -> L93
            goto L90
        L34:
            if (BDLocationConfig.isUseCacheCondition() == false) goto L44;
            LocationCacheInfo r28 = this.f9695o;     // Catch: Throwable -> L93
            long r110 = -1;
            if (r28 == null) goto L38;
            long r111 = r28.getLatestLocationCacheTime();     // Catch: Throwable -> L93
            int r29 = this.f9695o.getLatestLocationCacheCondition();     // Catch: Throwable -> L93
            long r210 = r111;
        L39:
            long r112 = System.currentTimeMillis();     // Catch: Throwable -> L93
            g r30 = this.f9698r;     // Catch: Throwable -> L93
            long r113 = r30.f9686j;     // Catch: Throwable -> L93
            if (r113 == (-1)) goto L42;
            r110 = r112 - r113;     // Catch: Throwable -> L93
        L42:
            r30.f9686j = r112;     // Catch: Throwable -> L93
            LocationMonitor.locationFrequencyMonitor(this.f9691a, this.f9696p.getReasonCode(), r112, r110, r29, r210);     // Catch: Throwable -> L93
            goto L44
        L38:
            r29 = -1;
            r210 = -1;
        L44:
            if (this.f9697q.isDownGradeLocation() == false) goto L46;
        L62:
            LocationMonitor.locationTraceLogEnd(this.f9691a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_BEFORE_START_DURATION);     // Catch: Throwable -> L93
            LocationMonitor.locationTraceLogEnd(this.f9691a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L93
            g r31 = this.f9698r;     // Catch: Throwable -> L93
            LocationOption r32 = this.f9691a;     // Catch: Throwable -> L93
            x r33 = this.f9693m;     // Catch: Throwable -> L93
            r31.getClass();     // Catch: Throwable -> L93
            if (r23 != 3) goto L65;
        L71:
            r24.startLocation(this.f9693m, this.f9691a, g.f9674l);     // Catch: Throwable -> L93
            goto L89
        L65:
            if (r32.isOnceLocation() == false) goto L71;
            if (BDLocationConfig.isAsyncScanWifi() == false) goto L71;
            if ((r33 instanceof WifiUtil.WifiInfoJsonCallback) == false) goto L71;
            Logger.i("start scan wifi");     // Catch: Throwable -> L93
            WifiUtil.getWifiInfoJsonAsync(BDLocationConfig.getContext(), r33, r32.getBpeaCert(), r32.getLocationTraceLogger(), r32);     // Catch: Throwable -> L93
            goto L71
        L46:
            if (BDLocationConfig.isMockEnable() == true) goto L62;
            BDLocationExtraDataServer r34 = new BDLocationExtraDataServer();     // Catch: Throwable -> L93
            ArrayList<BDLocationExtraDataServer> r35 = this.f9698r.f9687k;     // Catch: Throwable -> L93
            if (r35.size() <= 20) goto L52;
            BDLocationExtraDataServer r36 = r35.remove(0);     // Catch: Throwable -> L93
            if (r36 == null) goto L52;
            r36.stopCollectExtraData();     // Catch: Throwable -> L93
        L52:
            r35.add(r34);     // Catch: Throwable -> L93
            this.f9691a.setLocationExtraDataServer(r34);     // Catch: Throwable -> L93
            LocationExtraDataTraceLogger r37 = new LocationExtraDataTraceLogger();     // Catch: Throwable -> L93
            this.f9691a.setLocationExtraDataTraceLogger(r37);     // Catch: Throwable -> L93
            LocationMonitor.locationExtraDataTraceLogBegin(r37, LocationExtraDataTraceLogger.COLLECT_EXTRA_DATA_DURATION);     // Catch: Throwable -> L93
            Logger.i("location-trace-core isFirstLocation: " + BDLocationConfig.isFirstLocation() + ", ColdBootCollectGps: " + BDLocationConfig.getColdBootCollectGps());     // Catch: Throwable -> L93
            long r38 = BDLocationConfig.getDefaultGpsScanInterval();     // Catch: Throwable -> L93
            if (BDLocationConfig.isFirstLocation() == true) goto L55;
        L61:
            LocationMonitor.locationExtraDataTracePutCategoryData(r37, LocationExtraDataTraceLogger.DEFAULT_GPS_SCAN_INTERVAL, Long.valueOf(r38));     // Catch: Throwable -> L93
            LocationMonitor.locationExtraDataTracePutCategoryData(r37, LocationExtraDataTraceLogger.ENABLE_BACKGROUND_UPLOAD_LOCATION, Boolean.valueOf(BDLocationConfig.enableBackgroundUploadLocation()));     // Catch: Throwable -> L93
            LocationMonitor.locationExtraDataTracePutCategoryData(r37, "enable_upload_last_location_info", Boolean.valueOf(BDLocationConfig.enableUploadLastLocationInfo()));     // Catch: Throwable -> L93
            Logger.i("location-trace-core locationExtraDataServer.startCollectGpsData.");     // Catch: Throwable -> L93
            r34.startCollectGpsData(this.f9691a, g.f9675m, this.f9698r.f9687k);     // Catch: Throwable -> L93
            SensorInfoManager.getInstance().registerListener(5);     // Catch: Throwable -> L93
            goto L62
        L55:
            if (BDLocationConfig.getColdBootCollectGps() == false) goto L61;
            long r114 = this.f9695o.getNextGpsScanInterval();     // Catch: Throwable -> L93
            if (r114 == 0) goto L59;
            long r115 = r114;
        L60:
            BDLocationConfig.setGpsScanInterval(r115);     // Catch: Throwable -> L93
            Logger.i("location-trace-core startLocation: cache nextGpsScanInterval = " + r114 + ", defaultGpsScanInterval = " + r38);     // Catch: Throwable -> L93
            goto L61
        L59:
            r115 = r38;
            goto L60
        L75:
            if ("bpea-light_navigation".equals(this.f9691a.getUploadSource()) == false) goto L77;
            Logger.i("detect light navigation continuous location, change locateType from " + r23 + " to 1");     // Catch: Throwable -> L93
            this.f9691a.setLocateType(1);     // Catch: Throwable -> L93
        L79:
            if (BDLocationConfig.enableByteContinuousLocation() == false) goto L81;
            r13 = 6;
            this.f9691a.setLocateType(6);     // Catch: Throwable -> L93
        L81:
            g r39 = this.f9698r;     // Catch: Throwable -> L93
            if (r39.f9682f != null) goto L85;
            r39.f9682f = r39.f9678b.c(r13);     // Catch: Throwable -> L93
        L85:
            if (this.f9698r.f9682f == null) goto L87;
            LocationMonitor.locationTraceLogEnd(this.f9691a.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);     // Catch: Throwable -> L93
            this.f9698r.f9682f.startLocation(this.f9693m, this.f9691a, g.f9674l);     // Catch: Throwable -> L93
            goto L89
        L87:
            Logger.i("mContinuousLocation is null");     // Catch: Throwable -> L93
            r25 = new BDLocationException("未获取到定位内核异常", BuildConfig.BDLOCATION_VERSION, BDLocationException.ERROR_NO_LOCATE);     // Catch: Throwable -> L93
            r26 = this.f9698r;     // Catch: Throwable -> L93
            goto L73
        L77:
            r13 = r23;
        L93:
            th = move-exception;
            throw th;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f9699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public LocationOption f9700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BDLocation f9701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ArrayList f9702d;

        public c() {
            this.f9699a = false;
            this.f9700b = null;
            this.f9701c = null;
            this.f9702d = new ArrayList();
        }

        public final synchronized void a() {
            monitor-enter(this);
            StringBuilder r8 = new StringBuilder("LocateTrace.onLocateStop, locate id:");     // Catch: Throwable -> L11
            LocationOption r10 = this.f9700b;     // Catch: Throwable -> L11
            if (r10 != null) goto L7;
            String r11 = "null";
        L8:
            r8.append(r11);     // Catch: Throwable -> L11
            Logger.i(r8.toString());     // Catch: Throwable -> L11
            this.f9700b = null;     // Catch: Throwable -> L11
            this.f9699a = false;     // Catch: Throwable -> L11
            this.f9701c = null;     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L7:
            r11 = r10.getLocateId();     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final o f9703a = null;

        static {
            f9703a = new o(0);
        }
    }

    static {
        Looper r8 = ThreadLooperManager.getLocationWorker();
        f9674l = r8;
        f9675m = new Handler(r8);
        f9676n = null;
    }

    public g(Context r8) {
        this.f9684h = new AtomicInteger(1);
        this.f9685i = new c();
        this.f9686j = -1;
        this.f9679c = r8;
        this.f9680d = new Handler(ThreadLooperManager.getLBSLightLocationWorker());
        this.f9681e = new Handler(Looper.getMainLooper());
        LocationCache r10 = LocationCache.getInstance();
        this.f9677a = r10;
        r10.getLocationCache();
        if (androidx.lifecycle.s.f2193c == null) goto L5;
    L14:
        this.f9678b = androidx.lifecycle.s.f2193c;
        this.f9683g = BDLocationExtrasService.getBPEAManager();
        if (w.f9723h == null) goto L17;
    L26:
        ThreadLooperManager.getPollUploadWorker();
        this.f9687k = new ArrayList();
        Logger.i(BDLocationReflectUtils.TAG, "BDLocationService: trigger new BDLocationService instance, context: " + r8);
        return;
    L17:
        monitor-enter(w.class);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (w.f9723h != null) goto L21;
        w.f9723h = new w();     // Catch: Throwable -> L23
    L21:
        monitor-exit(w.class);     // Catch: Throwable -> L23
        goto L26
    L5:
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (androidx.lifecycle.s.f2193c != null) goto L9;
        androidx.lifecycle.s.f2193c = new androidx.lifecycle.s(9);     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void a(g r8, LocationOption r10, BDLocation r11) {
        r8.getClass();
        LocationMonitor.locationTraceLogBegin(r10.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RESET_LOCATE_TYPE_DURATION);
        boolean r12 = LocationUtil.isChineseRegion(r11);
        Logger.i("getLocateType check region isChineseRegion:" + r12);
        r10.setChineseRegion(r12);
        if (r12 == true) goto L5;
        r10.setLocateType(0);
    L5:
        LocationMonitor.locationTraceLogEnd(r10.getLocationTraceLogger(), LocationMonitorConst.LOCATION_RESET_LOCATE_TYPE_DURATION);
    }

    public static /* synthetic */ BaseLocate b(g r8) {
        return r8.f9682f;
    }

    public static boolean c(boolean r8, LocationOption r10, x r11) {
        LBSLightLocationTraceLogger r12 = null;
        if (r10 != null) goto L5;
        LBSLightLocationTraceLogger r13 = null;
    L6:
        LocationMonitor.lbsLightLocationTraceMetricBegin(r13, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
    L15:
        th = move-exception;
        if (r10 == null) goto L34;
        r12 = r10.getLBSLightLocationTraceLogger();
    L34:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r12, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        throw th;
    L8:
        if (o(r11) == true) goto L18;
        Logger.i("Must be called after BDLocation initialization!");     // Catch: Throwable -> L15
        if (r10 == null) goto L13;
        r12 = r10.getLBSLightLocationTraceLogger();
    L13:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r12, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return false;
    L18:
        String r14 = LocationUtil.allowUseLocation(r8, false, true);     // Catch: Throwable -> L15
        if ("1".equals(r14) == true) goto L26;
        q(r14, r11);     // Catch: Throwable -> L15
        if (r10 == null) goto L24;
        r12 = r10.getLBSLightLocationTraceLogger();
    L24:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r12, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return false;
    L26:
        if (r10 == null) goto L29;
        r12 = r10.getLBSLightLocationTraceLogger();
    L29:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r12, LBSLightLocationTraceLogger.CHECK_ABLE_LOCATION);
        return true;
    L5:
        r13 = r10.getLBSLightLocationTraceLogger();
        goto L6
    }

    public static boolean e(BDLocation r8, LocationOption r10, LocateReasonEntity r11, boolean r12) {
        if (r8 != null) goto L9;
        Logger.i("LocationCache IS NULL");
        if (r11 == null) goto L7;
        r11.setReasonCode(0);
    L7:
        return false;
    L9:
        if (r10.getGeocodeMode() == 0) goto L17;
        if (r8.hasAddress() == true) goto L17;
        Logger.i("LocationCache NO_GEOCODE");
        if (r11 == null) goto L15;
        r11.setReasonCode(1);
    L15:
        return false;
    L17:
        if (LocationUtil.checkCacheTime(r8.getLocationMs(), r10.getMaxCacheTime(), TextUtils.isEmpty(r10.getExtra())) == true) goto L23;
        Logger.i("LocationCache checkCacheTime is false");
        if (r11 == null) goto L21;
        r11.setReasonCode(2);
    L21:
        return false;
    L23:
        if (BDLocationConfig.getDisableTailLocateOptimizeSource().contains(r10.getUploadSource()) == false) goto L25;
    L31:
        if (r11 == null) goto L33;
        r11.setReasonCode(3);
    L33:
        return true;
    L25:
        if (BDLocationConfig.enableTailLocateOptimize() == false) goto L31;
        if (r12 == true) goto L31;
        Logger.i("LocationCache cache is not recommend, bpea:" + r10.getUploadSource());
        if (r11 == null) goto L30;
        r11.setReasonCode(4);
    L30:
        return false;
    }

    public static void f(boolean r8) {
        if (BDLocationConfig.shouldRequestLocation() == true) goto L8;
        if (r8 == false) goto L7;
        return;
    L7:
        throw new BDLocationException(BDLocationExceptionMessage.NON_COMPLIANCE_MESSAGE, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_BOOT_NO_CERT_LOCATE);
    }

    public static g j() {
        if (f9676n != null) goto L15;
        monitor-enter(g.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9676n != null) goto L9;
        f9676n = new g(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(g.class);     // Catch: Throwable -> L11
    L15:
        return f9676n;
    }

    public static BDLocation k(int r8, boolean r10, boolean r11) {
        f(r10);
        String r12 = LocationUtil.allowUseLocation(r11);
        if ("1".equals(r12) == false) goto L7;
        return m(r8);
    L7:
        throw new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r12);
    }

    public static BDLocation m(int r8) {
        Logger.i("getLastKnowLocation start");
        LocationCache r10 = j().f9677a;
        if (r10 != null) goto L6;
        return null;
    L6:
        BDLocation r11 = r10.getLocationCache().getLatestLocation();
        if (r11 == null) goto L9;
        r11.setCache(true);
    L9:
        BDLocation r12 = LocationUtil.transformLocationForLevel(r11, r8);
        Logger.i("getLastKnowLocation end");
        return r12;
    }

    public static boolean o(x r8) {
        if (BDLocationConfig.initIfNeed() == false) goto L6;
        return true;
    L6:
        Logger.i("Must be called after BDLocation initialization!");
        if (r8 == null) goto L11;
        p(r8, new BDLocationException(BDLocationExceptionMessage.NOT_INITIALIZATION, LocationInfoConst.BDLOCATION, BDLocationException.ERROR_INIT_LOCATION));
        return false;
    L11:
        return false;
    }

    public static void p(x r8, BDLocationException r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        AppExecutors.getInstance().mainThread().execute(new m(r8, r10));
    }

    public static void q(String r8, x r10) {
        Logger.i("checkAbleLocation is not allowed, error code is:" + r8);
        p(r10, new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r8));
    }

    public static LocationOption r(JSONObject r8, LocationOption r10) {
        Logger.i("BDLocationService.setCheckParams: " + r8);
        if (r8 == null) goto L18;
        if (r10 != null) goto L6;
        r10 = new LocationOption();
    L6:
        r10.setUpload(r8.optBoolean("single_is_upload", true));
        long r11 = r8.optInt("cache_time", 300000);
        boolean r12 = r8.optBoolean("use_cache_time", false);
        if (r11 <= 0) goto L14;
        if (r12 == true) goto L14;
        m5.a r13 = m5.a.a();
        if (r13.f9275d == 0) goto L12;
        long r14 = r13.f9275d;
    L13:
        r11 = r14 + 1000;
        goto L14
    L12:
        r14 = BDLocationConfig.getUploadInterval();
    L14:
        r10.setMaxCacheTime(r11);
        r10.setLocationTimeOutMs(r8.optLong("time_out", 30000));
        if (r8.has("trigger_type") == false) goto L17;
        r10.setTriggerType(r8.optInt("trigger_type", 1));
    L17:
        r10.setInterval(r8.optInt(LocationMonitorConst.LOCATION_INTERVAL, 1000));
        r10.setGeocodeMode(r8.optInt("geocode_mode", 1));
        r10.setAccuracyLevel(r8.optInt("accuracy_level", 4));
        r10.setLocateType(r8.optInt(LocationMonitorConst.LOCATE_TYPE, 3));
    L18:
        return r10;
    }

    public final boolean d(Object r8) {
        if (r8 != null) goto L4;
        return false;
    L4:
        if (this.f9683g == null) goto L9;
        return true;
    L9:
        return false;
    }

    public final void g(Object r21, LocationOption r22) {
        long r8 = System.currentTimeMillis();
        LocationManager r10 = (LocationManager) this.f9679c.getSystemService(LocationMonitorConst.LOCATION);
        Location r11 = BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r10, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r21);
        if (r11 != null) goto L5;
    L7:
        boolean r12 = true;
    L9:
        if (r11 == null) goto L11;
        long r17 = System.currentTimeMillis() - r11.getTime();
    L12:
        long r13 = System.currentTimeMillis() - r8;
        long r14 = System.currentTimeMillis();
        Location r15 = BDLocationExtrasService.getBPEAManager().getLastKnownLocation(r10, "network", r21);
        if (r15 != null) goto L15;
    L17:
        boolean r19 = r12;
    L18:
        if (r15 == null) goto L20;
        long r16 = System.currentTimeMillis() - r15.getTime();
    L21:
        r22.setLastLocationEntity(new LastLocationEntity(r15, r11, System.currentTimeMillis() - r14, r13, System.currentTimeMillis() - r8, r16, r17, r19));
        return;
    L20:
        r16 = -1;
        goto L21
    L15:
        if (LocationUtil.convertLocationToGCJ_O2(r15, LocationInfoConst.WGS_84) == true) goto L17;
        Logger.i("collectLastKnownLocation: lastNetworkLocation convertLocationToGCJ_O2 error");
        r19 = false;
        goto L18
    L11:
        r17 = -1;
        goto L12
    L5:
        if (LocationUtil.convertLocationToGCJ_O2(r11, LocationInfoConst.WGS_84) == true) goto L7;
        Logger.i("collectLastKnownLocation: lastGpsLocation convertLocationToGCJ_O2 error");
        r12 = false;
        goto L9
    }

    public final BDLocation h(LocationOption r8) {
        CountDownLatch r10 = new CountDownLatch(1);
        BDLocation[] r11 = new BDLocation[1];
        BDLocationException[] r12 = new BDLocationException[1];
        s(new a(r11, r10, r12), r8);
        r10.await(r8.getLocationTimeOutMs(), TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L9
        BDLocationException r13 = r12[0];
        if (r13 == null) goto L7;
        throw r13;
    L7:
        return r11[0];
    L9:
        e = move-exception;
        throw new BDLocationException(e, LocationInfoConst.SYSTEM, "0");
    }

    public final synchronized BdGisResult i(double r8, double r10, int r11, Object r12, int r13) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (d(r12) == false) goto L6;
        BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r12, "geocode");     // Catch: Throwable -> L9
    L6:
        new LocationOption().setTriggerType(r11);     // Catch: Throwable -> L9
        BdGisResult r14 = LocationUtil.getGeocodeResult(r8, r10, r11, r13);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r14;
    }

    public final BDLocation l(Object r8, boolean r10) {
        Logger.i("getLastKnowLocation start");
        String r11 = LocationUtil.allowUseLocation(r10);
        Logger.i("getLastKnowLocation allowLocation");
        if ("1".equals(r11) == false) goto L19;
        if (d(r8) == false) goto L16;
        BPEACertCheckResult r12 = BDLocationExtrasService.getBPEAManager().checkAndTranslateCert(r8, "getLastKnowLocation");
        Logger.i("getLastKnowLocation checkAndTranslateCert");
        if (r12 == null) goto L11;
        JSONObject r13 = r12.getParams();
        if (r13 == null) goto L11;
        int r14 = r13.optInt("accuracyLevel", 0);
    L12:
        BDLocation r15 = m(r14);
        if (r15 == null) goto L15;
        r15.setCache(true);
    L15:
        Logger.i("getLastKnowLocation end");
        return r15;
    L11:
        r14 = -1;
        goto L12
    L16:
        return null;
    L19:
        throw new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r11);
    }

    public final BDLocation n(LocationOption r8, LocationCacheInfo r10) {
        if (r8.isOnceLocation() == true) goto L7;
        String r11 = "LocationCache MaxCacheTime： " + r8.getMaxCacheTime();
    L5:
        Logger.i(r11);
        return null;
    L7:
        if (r10 != null) goto L9;
        r10 = this.f9677a.fastGetLocationCacheUnsafe();
    L9:
        if (r10 != null) goto L11;
        r11 = "LocationCache cacheInfo is null";
        goto L5
    L11:
        BDLocation r12 = r10.getLatestLocation();
        if (r12 != null) goto L14;
    L18:
        r11 = "LocationCache cache is null";
        goto L5
    L14:
        if (LocationUtil.isEmpty(r12) == true) goto L18;
        r12.setCache(true);
        Logger.i("LocationCache: cache");
        return r12;
    }

    public final void s(BDLocationCallback r19, LocationOption r20) {
        if (r20 != null) goto L6;
        Logger.e("BDLocationService.startLocation failed: mOption == null.");
        return;
    L6:
        r20.startLocationElapsedRealtimeMillis = SystemClock.elapsedRealtime();
        r20.startLocationTimestampInMillis = System.currentTimeMillis();
        Logger.i("location-trace-core set startLocationTimestampInMillis: " + r20.startLocationTimestampInMillis);
        r20.setLocateId(System.currentTimeMillis() + "" + this.f9684h.incrementAndGet());
        if (r20.getLBSLightLocationTraceLogger() != null) goto L9;
        LBSLightLocationTraceLogger r8 = new LBSLightLocationTraceLogger();
        r8.begin(LBSLightLocationTraceLogger.TOTAL);
        r8.begin(LBSLightLocationTraceLogger.PREPARE);
        r8.begin(LBSLightLocationTraceLogger.SUB_PREPARE);
        r20.setLBSLightLocationTraceLogger(r8);
    L9:
        LBSLightLocationTraceLogger r11 = r20.getLBSLightLocationTraceLogger();
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.SUB_PREPARE);
        Logger.i("BDLocationService.startLocation is DownGradeLocation:" + r20.isDownGradeLocation());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.WRAP_LOCATION_OPTION);
        if (r20.isDownGradeLocation() == false) goto L13;
        LocationOption r10 = new LocationOption(r20);
    L12:
        LocationOption r12 = r10;
        Logger.i("after check cert, locateType: " + r12.getLocateType());
        String r13 = r12.getUploadSource();
        IDYHostInfoProvider r14 = BDLocationConfig.getDYHostInfoProvider();
        if (r14 != null) goto L69;
        Context r15 = BDLocationConfig.getContext();
        if (r15 != null) goto L60;
    L63:
        StringBuilder r16 = new StringBuilder("refreshSearchLocationCacheTimeIfNeed returned: dyHostInfoProvider == null, context == null: ");
        if (r15 != null) goto L66;
        boolean r17 = true;
    L67:
        r16.append(r17);
        String r18 = r16.toString();
    L81:
        Logger.i(r18);
    L83:
        if ("bpea-light_navigation".equals(r13) == true) goto L86;
        String r21 = defpackage.b.c("needn't refresh maxCacheTime for: ", r13);
    L88:
        Logger.i(r21);
    L90:
        long r22 = r12.getHostSwitchThreadDuration();
        if (r22 <= 0) goto L93;
        LocationMonitor.lbsLightLocationTracePutMetricData(r11, LocationMonitorConst.HOST_SWITCH_THREAD_DURATION, r22);
        LocationMonitor.locationTracePutMetricData(r12.getLocationTraceLogger(), LocationMonitorConst.HOST_SWITCH_THREAD_DURATION, r22);
    L93:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.WRAP_LOCATION_OPTION);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.LOCATION_CACHE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.GET_SUITABLE_CACHE);
        LocationCacheInfo r110 = this.f9677a.fastGetLocationCacheUnsafe();
        BDLocation r111 = n(r12, r110);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.GET_SUITABLE_CACHE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.CHECK_CACHE_VALIDITY);
        LocateReasonEntity r112 = new LocateReasonEntity();
        boolean r23 = r110.isRecommendLocation();
        boolean r24 = e(r111, r12, r112, r23);
        Logger.i("BDLocationService.startLocation cacheLocationValidity:" + r24);
        Logger.i("enableTailLocateOptimize:" + BDLocationConfig.enableTailLocateOptimize() + " isRecommendLocation:" + r23);
        LocationMonitor.locationTracePutCategoryData(r12.getLocationTraceLogger(), LocationMonitorConst.ENABLE_TAIL_LOCATE_OPTIMIZE, Boolean.valueOf(BDLocationConfig.enableTailLocateOptimize()));
        LocationMonitor.locationTracePutCategoryData(r12.getLocationTraceLogger(), LocationMonitorConst.IS_RECOMMEND_LOCATION, Boolean.valueOf(r23));
        LocationMonitor.locationTracePutCategoryData(r12.getLocationTraceLogger(), LocationMonitorConst.MAX_WAIT_GPS_TIME_MILLIS, Long.valueOf(BDLocationConfig.maxWaitGPSTimeMillis()));
        LocationMonitor.locationTracePutCategoryData(r12.getLocationTraceLogger(), LocationMonitorConst.PRE_LOCATION_CALLBACK, Boolean.valueOf(BDLocationConfig.enablePreLocationCallback()));
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.CHECK_CACHE_VALIDITY);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.LOCATION_CACHE);
        x r25 = new x(r19, r12, this.f9685i, this.f9681e, f9675m);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.LOCATION_MERGE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.LOCATION_MERGE_SYNC);
        StationarySceneCacheInfo r26 = new StationarySceneCacheInfo();
        r26.setLocateId(r12.getLocateId());
        r12.setStationarySceneCacheInfo(r26);
        if (r12.isDownGradeLocation() == false) goto L96;
    L101:
        c r27 = this.f9685i;
        monitor-enter(r27);
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.LOCATION_MERGE_SYNC);     // Catch: Throwable -> L179
        if (r24 == false) goto L107;
        String r28 = "canMergeLocation: cacheLocationValidity is true, return false.";
    L120:
        Logger.i(r28);     // Catch: Throwable -> L179
        boolean r29 = false;
    L121:
        if (r29 == false) goto L132;
        c r30 = this.f9685i;     // Catch: Throwable -> L179
        if (r30.f9699a == false) goto L131;
        Logger.i("location-trace-core location trace is start");     // Catch: Throwable -> L179
        BDLocation r31 = this.f9685i.f9701c;     // Catch: Throwable -> L179
        if (r31 == null) goto L127;
        this.f9681e.post(new androidx.appcompat.app.r(7, r19, r31));     // Catch: Throwable -> L179
        String r32 = "location-trace-core location trace is start and already has light location result, callback immediately.";
    L128:
        Logger.i(r32);     // Catch: Throwable -> L179
        monitor-exit(r27);     // Catch: Throwable -> L179
        return;
    L127:
        r12.isCallbackThroughLocateTrace = true;     // Catch: Throwable -> L179
        this.f9685i.f9702d.add(r19);     // Catch: Throwable -> L179
        r32 = "location-trace-core location trace is start but not have light location result, merge.";
        goto L128
    L131:
        r30.f9700b = r12;     // Catch: Throwable -> L179
        r30.f9699a = true;     // Catch: Throwable -> L179
        r30.f9701c = null;     // Catch: Throwable -> L179
        Logger.i("location-trace-core LocateTrace.onLocateStart: " + r12.getLocateId());     // Catch: Throwable -> L179
        r12.isCallbackThroughLocateTrace = true;     // Catch: Throwable -> L179
        this.f9685i.f9702d.add(r19);     // Catch: Throwable -> L179
        Logger.i("no locating task, set locate start: true.");     // Catch: Throwable -> L179
    L132:
        monitor-exit(r27);     // Catch: Throwable -> L179
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.LOCATION_MERGE);
        if (BDLocationConfig.isMockEnable() == false) goto L136;
        String r33 = "needn't perform lbs light location: mock location.";
    L149:
        List<ScanResult> r34 = null;
        boolean r35 = false;
    L153:
        Logger.i(r33);
        List<ScanResult> r113 = r34;
        boolean r36 = r35;
    L165:
        LocationMonitor.locationTraceLogBegin(r12.getLocationTraceLogger(), LocationMonitorConst.LOCATION_THREAD_SWITCH_DURATION);
        boolean r114 = r36;
        f9675m.post(new b(this, r12, r111, r25, r24, r110, r112, r20));
        if (r113 != null) goto L168;
    L177:
        Logger.i("location-trace-core needn't perform lbs light location: lbsLightLocationScanResults is (null || empty).");
        return;
    L168:
        if (r113.isEmpty() == true) goto L177;
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.PREPARE);
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.NETWORK_TOTAL);
        if (Looper.myLooper() == Looper.getMainLooper()) goto L172;
        boolean r37 = true;
    L173:
        LocationMonitor.lbsLightLocationTracePutCategoryData(r11, LBSLightLocationTraceLogger.SWITCH_THREAD, Boolean.valueOf(!r37));
        LocationMonitor.lbsLightLocationTracePutCategoryData(r11, LBSLightLocationTraceLogger.THREAD_NAME, Thread.currentThread().getName());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.SWITCH_THREAD_SECOND_TIME);
        d0 r38 = new d0(this, r11, r12, r113, r25, 1);
        if (r37 == false) goto L176;
        r38.run();
        return;
    L176:
        this.f9680d.post(r38);
        return;
    L172:
        r37 = r114;
        goto L173
    L136:
        if (r24 == false) goto L139;
        r33 = "needn't perform lbs light location: cache location is valid.";
        goto L149
    L139:
        if (r12.isOnceLocation() == true) goto L142;
        r33 = "lbs light location is disabled in continuous location.";
        goto L149
    L142:
        if (r12.isDownGradeLocation() == false) goto L145;
        r33 = "lbs light location is disabled in downgrade location.";
        goto L149
    L145:
        if (LocationUtil.isUseByteLocationPolicy(r13) == false) goto L147;
    L150:
        Logger.i("lbs light location is enable, bpea: " + r13);
        LocationMonitor.lbsLightLocationTracePutCategoryData(r11, LBSLightLocationTraceLogger.BPEA, r13);
        List<ScanResult> r39 = null;
        if (c(false, r12, null) == true) goto L154;
        r33 = "RestrictedMode|background|LocationServer|permission unable";
        r34 = null;
        r35 = false;
        goto L153
    L154:
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.GET_WIFI_MODULE);
        Logger.i("performLBSLightLocationFirstPart: before getWifiScanResultsForLBSLightLocation.");
    L160:
        th = move-exception;
        th.printStackTrace();
        if (r11 == null) goto L164;
        Logger.e("lbs light location failed: get wifi scan results failed: " + th, th);
        r11.putCategoryData(LBSLightLocationTraceLogger.IS_GET_WIFI_SUCCESS, Boolean.FALSE);
        r11.reportLBSLightLocationFailed(BDLocationException.ERROR_CODE_LBS_LIGHT_GET_WIFI_INFO_MODULE_FAILED, "lbs light location failed: get wifi scan results failed: " + th);
    L164:
        r113 = r39;
        r36 = false;
        goto L165
    L156:
        if (BDLocationConfig.enableUploadLastLocationInfo() == false) goto L158;
        g(r12.getBpeaCert(), r12);     // Catch: Throwable -> L160
    L158:
        r39 = LBSLightWifiUtils.getWifiScanResultsForLBSLightLocation(r11, r12);     // Catch: Throwable -> L160
        Logger.i("performLBSLightLocationFirstPart: after getWifiScanResultsForLBSLightLocation.");
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.GET_WIFI_MODULE);
        LocationMonitor.lbsLightLocationTracePutCategoryData(r11, LBSLightLocationTraceLogger.IS_GET_WIFI_SUCCESS, Boolean.TRUE);
        goto L164
    L147:
        if (BDLocationConfig.isEnableLocationOpt(r13) == true) goto L150;
        r33 = defpackage.b.c("not enable lbs light location with bpea: ", r13);
        goto L149
    L107:
        if (r12.isDownGradeLocation() == false) goto L110;
        r28 = "canMergeLocation: isDownGradeLocation is true, return false.";
        goto L120
    L110:
        if (r12.isOnceLocation() == false) goto L119;
        LocationOption r40 = this.f9685i.f9700b;     // Catch: Throwable -> L179
        if (r40 != null) goto L114;
    L116:
        boolean r41 = true;
    L117:
        if (r41 == false) goto L119;
        r29 = true;
        goto L121
    L114:
        if (r40.isLatestAdminVersion() == r12.isLatestAdminVersion()) goto L116;
        Logger.i("canMergeLocation: diff AdminVersion, return false.");     // Catch: Throwable -> L179
        r41 = false;
    L119:
        r28 = "canMergeLocation: not merge, continuous location or not support, return false.";
    L179:
        th = move-exception;
        throw th;
    L96:
        if (r12.isOnceLocation() == false) goto L101;
        boolean r42 = LocationUtil.checkStationaryScenePolicyBeforeLocation(r12.getUploadSource(), r111, r12.getLocationTraceLogger());
        Logger.i("checkStationaryScenePolicyBeforeLocation hitStationaryScene:" + r42);
        LocationMonitor.locationTracePutCategoryData(r12.getLocationTraceLogger(), LocationMonitorConst.HIT_STATIONARY_SCENE, Boolean.valueOf(r42));
        r12.setHitStationaryScene(r42);
        if (r42 == false) goto L101;
        LocationMonitor.locationTraceLogBegin(r12.getLocationTraceLogger(), "total_duration");
        SensorInfoManager.getInstance().registerListener(5);
        Logger.i("location-trace-core location-trace-core isHitStationaryScene");
        AppExecutors.getInstance().mainThread().execute(new l(r111, r25));
        return;
    L86:
        if (r12.isOnceLocation() == false) goto L89;
        r21 = "needn't refresh maxCacheTime for onceLocation.";
        goto L88
    L89:
        Logger.i("change maxCacheTime to 0L for: " + r13);
        r12.setMaxCacheTime(0);
        goto L90
    L66:
        r17 = false;
        goto L67
    L60:
        if ("com.ss.android.ugc.aweme".equals(r15.getPackageName()) == false) goto L63;
        Logger.e("refreshSearchLocationCacheTimeIfNeed returned: unexpected dyHostInfoProvider == null in DY.");
        goto L83
    L69:
        if (r14.isPersonalizedRecommendationEnable() == true) goto L72;
        r18 = "refreshSearchLocationCacheTimeIfNeed returned: personalized recommendation not enabled.";
        goto L81
    L72:
        if ("bpea-search_requset_net_trytolocate_cache_first".equals(r13) == true) goto L75;
        r18 = defpackage.b.c("needn't refresh location cache time, bpea is ", r13);
        goto L81
    L75:
        if (r12.isOnceLocation() == true) goto L77;
        r18 = "needn't refresh location cache time: continuous location";
        goto L81
    L77:
        long r43 = BDLocationConfig.getSearchLocationCacheTime();
        if (r43 <= 0) goto L80;
        r12.setMaxCacheTime(r43);
        r18 = "refresh search location cache time: " + r43 + ", bpea: " + r13;
        goto L81
    L80:
        r18 = "needn't refresh location cache time: searchLocationMaxCacheTime <= 0";
        goto L81
    L13:
        Logger.i("BDLocationService.startLocation, before checkCert, locateType: " + r20.getLocateType());
        LocationMonitor.lbsLightLocationTraceMetricBegin(r11, LBSLightLocationTraceLogger.CHECK_CERT);
        IBPEALocal r44 = this.f9683g;
    L45:
        e = move-exception;
        e.printStackTrace();
        if (r19 == null) goto L49;
        r19.onError(e);
    L49:
        LocationOption r45 = null;
    L50:
        LocationMonitor.lbsLightLocationTraceMetricEnd(r11, LBSLightLocationTraceLogger.CHECK_CERT);
        if (r45 != null) goto L54;
        Logger.i("cert check error");
        return;
    L54:
        r10 = new LocationOption(r45);
        goto L12
    L15:
        if (d(r20.getBpeaCert()) == false) goto L43;
        BPEACertCheckResult r46 = r44.checkAndTranslateCert(r20.getBpeaCert(), r20.getBpeaAction());     // Catch: BDLocationException -> L45
        if (r46 == null) goto L19;
        r45 = r(r46.getParams(), r20);     // Catch: BDLocationException -> L45
    L20:
        String r47 = r44.getBpeaToken(r45.getBpeaCert());     // Catch: BDLocationException -> L45
        String r48 = BDLocationConfig.getLocationCacheTokenWhiteList();     // Catch: BDLocationException -> L45
        if (BDLocationConfig.isEnableLocationCacheTokenWhiteList() == true) goto L23;
    L34:
        boolean r49 = false;
    L35:
        if (r49 == false) goto L38;
        r45.setMaxCacheTime(0);     // Catch: BDLocationException -> L45
    L38:
        if (BDLocationConfig.getHotBootLocToken().equals(r47) == false) goto L42;
        long r50 = BDLocationConfig.getHotBootCacheTime();     // Catch: BDLocationException -> L45
        if (r50 == (-1)) goto L42;
        r45.setMaxCacheTime(r50 * 1000);     // Catch: BDLocationException -> L45
    L42:
        r45.setUploadSource(r47);     // Catch: BDLocationException -> L45
        Logger.i("startLocation checkCert:" + r47);     // Catch: BDLocationException -> L45
        goto L50
    L23:
        if (TextUtils.isEmpty(r48) == true) goto L34;
        if (TextUtils.isEmpty(r47) == true) goto L34;
        String[] r51 = r48.split(",");     // Catch: BDLocationException -> L45
        int r52 = r51.length;     // Catch: BDLocationException -> L45
        int r53 = 0;
    L28:
        if (r53 >= r52) goto L33;
        if (r47.equals(r51[r53].trim()) == true) goto L34;
        r53 = r53 + 1;     // Catch: BDLocationException -> L45
        goto L28
    L33:
        r49 = true;
        goto L35
    L19:
        r45 = r20;
        goto L20
    L43:
        f(r20.isCert());     // Catch: BDLocationException -> L45
        r45 = r20;
        goto L50
    }
}
