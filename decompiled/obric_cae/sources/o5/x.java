package o5;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.CacheConditionEntity;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.exception.BDLocationExceptionMessage;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.store.BDLightLocationCache;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class x implements BDLocationCallback, WifiUtil.WifiInfoJsonCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BDLocationCallback f9733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.c f9734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocationOption f9735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f9736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f9737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f9738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f9739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f9740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f9741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile BDLocation f9742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile ha.m f9743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile boolean f9744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile boolean f9745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public WifiInfo f9746n;

    public class a implements LocationUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f9747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BDLocation f9748b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x f9749c;

        public a(x r8, long r10, BDLocation r11) {
            this.f9749c = r8;
            this.f9747a = r10;
            this.f9748b = r11;
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onError(String r8) {
            Logger.i("LocationCallbackServer upload interval:" + (System.currentTimeMillis() - this.f9747a));
            x r10 = this.f9749c;
            boolean r11 = r10.f9735c.isOnceLocation();
            BDLocation r12 = this.f9748b;
            if (r11 == false) goto L5;
            BDLocationConfig.setOpenStationaryScene(false);
            r10.c(r12);
            return;
        L5:
            r10.b(r12, false);
        }

        @Override // com.bytedance.bdlocation.callback.LocationUploadCallback
        public final void onSuccess(LocationResp r8, boolean r10, WifiInfo r11) {
            Logger.i("LocationCallbackServer upload intervalTime:" + (System.currentTimeMillis() - this.f9747a));
            LocInfoRspData r12 = LocationUtil.parseLocInfoRsp(r8);
            BDLocation r13 = this.f9748b;
            if (r12 != null) goto L5;
            BDLocation r14 = null;
        L11:
            if (r13 == null) goto L15;
            if (r12 == null) goto L14;
            r13.setSubmitLogId(r12.submitLogId);
        L14:
            r13.setRecommendWifiResults(r10);
            r13.setConnectedWifiInfo(r11);
        L15:
            n5.a.d(r12);
            if (r14 == null) goto L19;
            r13 = r14;
        L19:
            x r15 = this.f9749c;
            boolean r16 = r15.f9735c.isOnceLocation();
            LocationOption r17 = r15.f9735c;
            if (r16 == false) goto L22;
            n5.a.c(r12, r13, r17);
            r15.c(r13);
        L23:
            n5.a.b(r12, r14, r17);
            return;
        L22:
            r15.b(r13, false);
            goto L23
        L5:
            if (r12.disablePollingUpload != 1) goto L7;
            Logger.i("disablePollingUpload == 1, disable polling upload.");
            BDLocationConfig.setPollingUpload(false);
            m5.a.a().e();
        L7:
            Logger.i("LocationCallbackServer inOutDoorStatus:" + r12.inOutDoorStatus);
            r14 = LocationUtil.locationResultToBDLocation(r13, r12.location, r12.inOutDoorStatus, r12.inOutDoorConfidence);
            if (r14 == null) goto L11;
            r14.setSubmitLogId(r12.submitLogId);
            r14.setRecommendWifiResults(r10);
            r14.setConnectedWifiInfo(r11);
            goto L11
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BDLocation f9750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ x f9751b;

        public b(x r8, BDLocation r10) {
            this.f9751b = r8;
            this.f9750a = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Logger.i("callbackContinueLocationInfo onLocationChanged");
            x r8 = this.f9751b;
            BDLocationCallback r10 = r8.f9733a;
            BDLocation r11 = this.f9750a;
            r10.onLocationChanged(r11);
            r8.g(r11);
        }
    }

    public x(BDLocationCallback r8, LocationOption r10, g.c r11, Handler r12, Handler r13) {
        this.f9739g = new Object();
        this.f9744l = true;
        this.f9745m = true;
        this.f9733a = r8;
        this.f9734b = r11;
        this.f9735c = r10;
        this.f9736d = r12;
        this.f9738f = SystemClock.elapsedRealtime();
        if (r13 == null) goto L5;
        this.f9737e = r13;
        return;
    L5:
        this.f9737e = new Handler(ThreadLooperManager.getLocationWorker());
    }

    public static void h(BDLocation r8, boolean r10) {
        CacheConditionEntity r11 = new CacheConditionEntity();
        if (r8 != null) goto L7;
        r11.setConditionCode(1);
        LocationCache.getInstance().executeWithoutLocationCache(System.currentTimeMillis(), r11, false);
        return;
    L7:
        if (r8.getLocationType() != 6) goto L11;
        Logger.i("IP location");
        r11.setConditionCode(2);
        LocationCache.getInstance().executeWithoutLocationCache(r8.getLocationMs(), r11, !r8.isCache());
        return;
    L11:
        if (r8.isMock() == false) goto L14;
        Logger.i("mock location");
        r11.setConditionCode(3);
        LocationCache.getInstance().executeWithoutLocationCache(r8.getLocationMs(), r11, !r8.isCache());
        return;
    L14:
        Logger.i("CheckNewLocation new location time:" + r8.getLocationMs());
        BDLocation r12 = LocationCache.getInstance().getLocationCache().getLatestLocation();
        Logger.i("LocationCallbackServer executeLocationCache isUseNewCacheStrategy: " + BDLocationConfig.isUseNewCacheStrategy());
        if (BDLocationConfig.isUseCacheCondition() == false) goto L30;
        if (r8.isCache() == false) goto L19;
        return;
    L19:
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L22;
        r11.setConditionCode(4);
        LocationCache.getInstance().executeWithoutLocationCache(r8.getLocationMs(), r11, !r8.isCache());
        return;
    L22:
        if (LocationUtil.isBetterLocation(r8, r12, r11) == false) goto L24;
    L25:
        Logger.i("UseCacheCondition checkNewLocation executeLocationCache");
        long r13 = r8.getLocationMs();
        if (BDLightLocationCache.lightLocationNeedCheckCache() == false) goto L28;
        BDLightLocationCache.setLastLocationTime(BDLocationConfig.getContext(), r13);
    L28:
        LocationCache.getInstance().executeLocationCache(r8, r11, true ^ r8.isCache(), r10);
        return;
    L24:
        if (LocationUtil.isGoodLocation(r8, r11) == true) goto L25;
        return;
    L30:
        if (LocationUtil.isBetterLocation(r8, r12) == true) goto L34;
        if (LocationUtil.isGoodLocation(r8) == true) goto L34;
        return;
    L34:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L45;
        Logger.i("CheckNewLocation executeLocationCache");
        long r14 = r8.getLocationMs();
        if (BDLightLocationCache.lightLocationNeedCheckCache() == false) goto L38;
        BDLightLocationCache.setLastLocationTime(BDLocationConfig.getContext(), r14);
    L38:
        LocationCache.getInstance().executeLocationCache(r8, true ^ r8.isCache(), r10);
        return;
    }

    public final void a(BDLocation r8) {
        g.c r10 = this.f9734b;
        monitor-enter(r10);
        if (r8 != null) goto L20;
    L11:
        boolean r11 = false;
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L9
        if (r11 == false) goto L15;
        BDLocation r12 = LocationUtil.transformLocationForLevel(r8, this.f9735c.getAccuracyLevel());
        this.f9737e.post(new androidx.activity.d(r12, 10));
        d(r12, false, false);
        String r13 = "location-trace-core callback at light location completion time.";
    L16:
        Logger.i(r13);
        return;
    L15:
        r13 = "location-trace-core not callback at light location completion time.";
    L9:
        th = move-exception;
        throw th;
    L20:
        g.c r14 = this.f9734b;     // Catch: Throwable -> L9
        LocationOption r15 = this.f9735c;     // Catch: Throwable -> L9
        r14.f9701c = r8;     // Catch: Throwable -> L9
        if (r15.alreadyCallback == true) goto L11;
        r11 = true;
        r15.alreadyCallback = true;     // Catch: Throwable -> L9
        goto L12
    }

    public final void b(BDLocation r8, boolean r10) {
        StringBuilder r11 = new StringBuilder("callbackContinueLocationInfo isSynchronizeUpload:");
        LocationOption r12 = this.f9735c;
        r11.append(r12.isSynchronizeUpload());
        r11.append("--needCallback:");
        r11.append(r10);
        Logger.i(r11.toString());
        if (r12.isSynchronizeUpload() == true) goto L5;
        if (r10 == false) goto L5;
    L7:
        if (r12.isSynchronizeUpload() == true) goto L9;
        if (r10 == true) goto L9;
        return;
    L9:
        BDLocation r13 = LocationUtil.transformLocationForLevel(r8, r12.getAccuracyLevel());
        if (this.f9736d != null) goto L12;
        this.f9736d = new Handler(Looper.getMainLooper());
    L12:
        this.f9736d.post(new b(this, r13));
        return;
    L5:
        i(r8);
        h(r8, true);
        goto L7
    }

    public final void c(BDLocation r8) {
        g.c r10 = this.f9734b;
        monitor-enter(r10);
        LocationOption r11 = this.f9735c;     // Catch: Throwable -> L17
        if (r11.alreadyCallback == true) goto L7;
    L10:
        this.f9735c.alreadyCallback = true;     // Catch: Throwable -> L17
        boolean r12 = true;
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L17
        i(r8);
        h(r8, r12);
        BDLocation r13 = LocationUtil.transformLocationForLevel(r8, this.f9735c.getAccuracyLevel());
        if (r12 == false) goto L15;
        d(r13, true, true);
        Logger.i("location-trace-core callback at full location completion time.");
        return;
    L15:
        Logger.i("location-trace-core not callback at full location completion time.");
        Logger.i("location-trace-core LocationCallbackServer callbackLocationInfo LocateTrace.onLocateStop");
        this.f9734b.a();
        g(r13);
        return;
    L7:
        if (r11.isOnceLocation() == false) goto L10;
        r12 = false;
    L17:
        th = move-exception;
        throw th;
    }

    public final void d(BDLocation r8, boolean r10, boolean r11) {
        if (this.f9736d != null) goto L5;
        this.f9736d = new Handler(Looper.getMainLooper());
    L5:
        g.c r12 = this.f9734b;
        monitor-enter(r12);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.f9735c.isCallbackThroughLocateTrace == false) goto L12;
        Logger.i("LocationCallbackServer callbackLocationInfoInner callback merge location.");     // Catch: Throwable -> L10
        g.c r13 = this.f9734b;     // Catch: Throwable -> L10
        r13.getClass();     // Catch: Throwable -> L10
        ArrayList r14 = r13.f9702d;     // Catch: Throwable -> L10
        ArrayList r15 = new ArrayList(r14);     // Catch: Throwable -> L10
        r14.clear();     // Catch: Throwable -> L10
    L13:
        if (r10 == false) goto L15;
        this.f9734b.a();     // Catch: Throwable -> L10
    L15:
        monitor-exit(r12);     // Catch: Throwable -> L10
        if (r15 != null) goto L18;
    L28:
        this.f9736d.post(new s1.x(1, this, r8));
        if (r11 == false) goto L40;
    L30:
        g(r8);
        return;
    L40:
        return;
    L18:
        if (r15.isEmpty() == true) goto L28;
        int r16 = 0;
    L21:
        if (r16 >= r15.size()) goto L26;
        BDLocationCallback r17 = (BDLocationCallback) r15.get(r16);
        if (r17 == null) goto L25;
        this.f9736d.post(new androidx.room.k(9, r17, r8));
    L25:
        r16 = r16 + 1;
        goto L21
    L26:
        if (r11 == true) goto L30;
        return;
    L12:
        r15 = null;
        goto L13
    }

    public final void e() {
        StringBuilder r8 = new StringBuilder("location-trace-core LocationCallbackServer decideDownGradeLocationType:");
        LocationOption r10 = this.f9735c;
        r8.append(r10.getLocateType());
        Logger.i(r8.toString());
        r10.setLocateType(0);
        r10.setDownGradeLocation(true);
        String r11 = LocationUtil.allowUseLocation(true);
        if ("1".equals(r11) == true) goto L7;
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocation error:" + r11);
        onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r11));
        return;
    L7:
        if (LocationUtil.isUseByteLocationPolicyV2(r10.getUploadSource()) == true) goto L9;
        this.f9734b.a();
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocation");
        g.j().s(this.f9733a, new LocationOption(r10));
        return;
    L9:
        if (r10.getSysLocation() == null) goto L11;
    L13:
        long r12 = 0;
    L14:
        Logger.i("location-trace-core LocationCallbackServer decideByteLocationDownGradeLocation delayedTime:" + r12);
        new Handler(ThreadLooperManager.getLocationWorker()).postDelayed(new androidx.activity.j(this, 14), r12);
        return;
    L11:
        if (r10.getGpsLocation() != null) goto L13;
        r12 = BDLocationConfig.getGpsScanInterval();
        goto L14
    }

    public final void f(BDLocationException r8) {
        if (r8 == null) goto L4;
        Logger.i("doMonitorLocationFail: errCode:" + r8.getCode() + "--DetailMessage:" + r8.getDetailMessage());
    L4:
        LocationOption r10 = this.f9735c;
        if (r10.isOnceLocation() == false) goto L8;
        LocationMonitor.locationTraceLogErrorReport(r10, r8);
        long r11 = SystemClock.elapsedRealtime();
        long r12 = this.f9738f;
        LocationMonitor.doDesiredLocationFail(r11 - r12, r8, r10);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - r12) + "ms");
        return;
    }

    public final void g(BDLocation r8) {
        LocationOption r10 = this.f9735c;
        if (r10.isOnceLocation() == false) goto L6;
        LocationMonitor.locationTraceLogEnd(r10.getLocationTraceLogger(), "total_duration");
        LocationMonitor.locationTraceLogSuccessReport(r8, r10);
        long r11 = SystemClock.elapsedRealtime();
        long r12 = this.f9738f;
        LocationMonitor.doDesiredLocationSuccess(r11 - r12, r8, r10);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - r12) + "ms");
        return;
    }

    public final synchronized void i(BDLocation r11) {
        monitor-enter(this);
        m5.a r8 = m5.a.a();     // Catch: Throwable -> L46
        monitor-enter(r8);     // Catch: Throwable -> L46
        boolean r10 = r8.f9272a;     // Catch: Throwable -> L43
        monitor-exit(r8);     // Catch: Throwable -> L46
        if (r10 == false) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (r11 != null) goto L13;
    L41:
        monitor-exit(this);
        return;
    L13:
        if (BDLocationConfig.isUpload() == false) goto L41;
        if (BDLocationConfig.isPollingUpload() == false) goto L41;
        if (LocationUtil.checkBackground() == true) goto L41;
        Logger.i("register UploadScheduleController isCache：" + r11.isCache());     // Catch: Throwable -> L46
        NetworkManager.getInstance().registerObserver(BDLocationConfig.getContext());     // Catch: Throwable -> L46
        long r12 = BDLocationConfig.getUploadInterval();     // Catch: Throwable -> L46
        if (r11.isCache() == false) goto L24;
        r12 = BDLocationConfig.getUploadInterval() - (System.currentTimeMillis() - r11.getLocationMs());     // Catch: Throwable -> L46
        if (r12 > 0) goto L23;
        r12 = 5000;
    L23:
        Logger.d("register UploadScheduleController interval:" + r12 + "--cacheTime:" + r11.getLocationMs());     // Catch: Throwable -> L46
    L24:
        m5.a r13 = m5.a.a();     // Catch: Throwable -> L46
        monitor-enter(r13);     // Catch: Throwable -> L46
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L27:
        if (r13.f9272a == false) goto L29;
    L36:
        monitor-exit(r13);     // Catch: Throwable -> L46
        goto L41
    L29:
        if (r12 < 0) goto L33;
        r13.f9275d = r12;     // Catch: Throwable -> L38
    L33:
        if (r13.f9273b != null) goto L35;
        r13.f9273b = new m5.a.RunnableC0114a(r13);     // Catch: Throwable -> L38
    L35:
        r13.f9274c.post(r13.f9273b);     // Catch: Throwable -> L38
        r13.f9272a = true;     // Catch: Throwable -> L38
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public final void j(BDLocation r8) {
        long r10 = System.currentTimeMillis();
        if (this.f9735c.isOnceLocation() == false) goto L5;
    L7:
        LocationOption r11 = this.f9735c;
        a r12 = new a(this, r10, r8);
        LocationUploadExtra r13 = new LocationUploadExtra();
        r13.locationOption = r11;
        r13.setUploadInterval(r11.getUploadInterval());
        r13.setLocateId(r11.getLocateId());
        if (BDLocationConfig.isMockEnable() == false) goto L10;
        String r14 = "mock";
    L11:
        r13.setUploadSource(r14);
        r13.setTriggerType(r11.getTriggerType());
        r13.setLatestAdminVersion(r11.isLatestAdminVersion());
        r13.setBpeaCert(r11.getBpeaCert());
        r13.setStartLocationTime(r11.getStartLocationTime());
        if (r11.getLocationExtraBean() == null) goto L14;
        r13.setLogIdCache(r11.getLocationExtraBean().getLogIdCacheEntity());
        r13.setBleList(r11.getLocationExtraBean().getBleInfoList());
    L14:
        r13.setExtra(r11.getExtra());
        r13.setWifiDate(this.f9743k);
        r13.setRecommendWifiResults(this.f9745m);
        r13.setWifiCache(this.f9744l);
        r13.setOnceLocation(r11.isOnceLocation());
        r13.setLocationTraceLogger(r11.getLocationTraceLogger());
        r13.setLocationExtraDataServer(r11.getLocationExtraDataServer());
        r13.setConnectedWifiInfo(this.f9746n);
        r13.setStationarySceneCacheInfo(r11.getStationarySceneCacheInfo());
        LocationUtil.startLocateUpload(r8, r13, r12);
        return;
    L10:
        r14 = r11.getUploadSource();
        goto L11
    L5:
        if (this.f9735c.isSynchronizeUpload() == true) goto L7;
        b(r8, true);
        goto L7
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onError(BDLocationException r10) {
        Logger.i("LocationCallbackServer onError");
        int r8 = 0;
        BDLocationConfig.setOpenStationaryScene(false);
        if (this.f9735c.isOnceLocation() == true) goto L5;
    L10:
        boolean r11 = true;
        ArrayList r12 = null;
        if (this.f9735c.isChineseRegion() == false) goto L13;
    L31:
        g.c r13 = this.f9734b;
        monitor-enter(r13);
    L74:
        th = move-exception;
        throw th;
    L34:
        if (LocationUtil.isUseByteLocationPolicy(this.f9735c.getUploadSource()) == true) goto L36;
    L40:
        this.f9735c.alreadyCallback = true;     // Catch: Throwable -> L74
        r11 = false;
    L41:
        monitor-exit(r13);     // Catch: Throwable -> L74
        if (r11 == false) goto L46;
        Logger.i("location-trace-core full location failed, try use light location callback.");
        c(this.f9735c.getLightLocation());
        return;
    L46:
        if (this.f9736d != null) goto L49;
        this.f9736d = new Handler(Looper.getMainLooper());
    L49:
        if (BDLocationConfig.isUseCacheCondition() == false) goto L51;
        CacheConditionEntity r14 = new CacheConditionEntity();
        r14.setConditionCode(0);
        LocationCache.getInstance().executeWithoutLocationCache(System.currentTimeMillis(), r14, false);
    L51:
        g.c r15 = this.f9734b;
        monitor-enter(r15);
    L56:
        th = move-exception;
        throw th;
    L54:
        if (this.f9735c.isCallbackThroughLocateTrace == false) goto L58;
        Logger.i("location-trace-core LocationCallbackServer mergeLocation onError");     // Catch: Throwable -> L56
        g.c r16 = this.f9734b;     // Catch: Throwable -> L56
        r16.getClass();     // Catch: Throwable -> L56
        ArrayList r17 = r16.f9702d;     // Catch: Throwable -> L56
        r12 = new ArrayList(r17);     // Catch: Throwable -> L56
        r17.clear();     // Catch: Throwable -> L56
    L58:
        this.f9734b.a();     // Catch: Throwable -> L56
        monitor-exit(r15);     // Catch: Throwable -> L56
        if (r12 != null) goto L62;
    L69:
        this.f9736d.post(new androidx.room.k(10, this, r10));
    L70:
        f(r10);
        return;
    L62:
        if (r12.isEmpty() == true) goto L69;
    L64:
        if (r8 >= r12.size()) goto L70;
        BDLocationCallback r18 = (BDLocationCallback) r12.get(r8);
        if (r18 == null) goto L68;
        this.f9736d.post(new androidx.appcompat.app.r(8, r18, r10));
    L68:
        r8 = r8 + 1;
        goto L64
    L36:
        if (this.f9735c.isOnceLocation() == false) goto L40;
        if (this.f9735c.getLightLocation() == null) goto L40;
    L13:
        if (this.f9735c.getLocateType() != 0) goto L31;
        Logger.i("overseas getLocation error and use cache");
        BDLocation r19 = g.j().n(this.f9735c, null);
        g r20 = g.j();
        LocationOption r21 = this.f9735c;
        r20.getClass();
        if (r19 != null) goto L18;
        String r22 = "LocationCache IS NULL";
    L25:
        Logger.i(r22);
        boolean r23 = false;
    L27:
        LocationMonitor.overseasLocationFailedGetCache(r23);
        if (r23 == false) goto L31;
        c(r19);
        return;
    L18:
        if (r21.getGeocodeMode() == 0) goto L23;
        if (r19.hasAddress() == true) goto L23;
        r22 = "LocationCache NO_GEOCODE";
    L23:
        if (LocationUtil.checkCacheTime(r19.getLocationMs(), BDLocationConfig.getOverseasGetLocationFailedUseCacheValidity()) == true) goto L26;
        r22 = "LocationCache checkCacheTime is false";
        goto L25
    L26:
        r23 = true;
        goto L27
    L5:
        if (this.f9735c.getLocateType() == 0) goto L10;
        if (this.f9735c.isDownGradeLocation() == true) goto L10;
        e();
    }

    @Override // com.bytedance.bdlocation.scan.wifi.WifiUtil.WifiInfoJsonCallback
    public final void onFailed(BDLocationException r8) {
        Object r10 = this.f9739g;
        monitor-enter(r10);
        this.f9740h = true;     // Catch: Throwable -> L10
        if (this.f9741i == false) goto L8;
        Logger.i("upLoadLocation from scan Wifi onFailed");     // Catch: Throwable -> L10
        j(this.f9742j);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public final void onLocationChanged(BDLocation r8) {
        if (this.f9735c.isHitStationaryScene() == false) goto L11;
        LocationUploadExtra r10 = new LocationUploadExtra();
        LocationOption r11 = this.f9735c;
        r10.setUploadInterval(r11.getUploadInterval());
        r10.setLocateId(r11.getLocateId());
        if (BDLocationConfig.isMockEnable() == false) goto L7;
        String r12 = "mock";
    L8:
        r10.setUploadSource(r12);
        r10.setTriggerType(r11.getTriggerType());
        r10.setBpeaCert(r11.getBpeaCert());
        r10.setStartLocationTime(r11.getStartLocationTime());
        r10.setExtra(r11.getExtra());
        r10.setOnceLocation(r11.isOnceLocation());
        r10.setLocationTraceLogger(r11.getLocationTraceLogger());
        r10.setStartLocationTimestampInMillis(r11.startLocationTimestampInMillis);
        LocationUtil.startCacheLocateInfoUpload(r10, new y(this, System.currentTimeMillis(), r8));
        return;
    L7:
        r12 = r11.getUploadSource();
        goto L8
    L11:
        if (this.f9735c.isOnceLocation() == true) goto L14;
        BDLocationConfig.setOpenStationaryScene(false);
    L14:
        if (LocationUtil.isEmpty(r8) == true) goto L16;
        boolean r13 = r8.isCache();
        if (BDLocationConfig.isFirstLocation() == false) goto L30;
        LocationMonitor.doFirstLocationDuration(SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime(), r13);
        Logger.i("locationmonitor first location duration is: " + (SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime()) + "ms");
        BDLocationConfig.setFirstLocation(false);
    L30:
        if (r8.isCache() == false) goto L33;
        c(r8);
        return;
    L33:
        BDLocation r14 = LocationUtil.convertLocation(r8);
        if (this.f9735c.isUpload() == true) goto L36;
    L53:
        LocInfoRspData r15 = r14.getLocInfoRsp();
        if (r15 != null) goto L56;
    L58:
        n5.a.d(r15);
        if (r15 == null) goto L61;
        LocInfoRspData r16 = new LocInfoRspData(r15);
    L62:
        if (r16 == null) goto L65;
        r14.setSubmitLogId(r16.submitLogId);
    L65:
        if (this.f9735c.isOnceLocation() == false) goto L67;
        n5.a.c(r16, r14, this.f9735c);
    L67:
        c(r14);
        n5.a.b(r16, r14, this.f9735c);
        r14.setLocInfoRsp(null);
        return;
    L61:
        r16 = null;
        goto L62
    L56:
        if (r15.disablePollingUpload != 1) goto L58;
        Logger.i("disablePollingUpload == 1, disable polling upload.");
        BDLocationConfig.setPollingUpload(false);
        m5.a.a().e();
        goto L58
    L36:
        if (LocationUtil.needUpload(r14) == false) goto L53;
        if (this.f9735c.isOnceLocation() == true) goto L40;
    L52:
        j(r14);
        return;
    L40:
        if (BDLocationConfig.isAsyncScanWifi() == false) goto L52;
        Object r17 = this.f9739g;
        monitor-enter(r17);
    L49:
        th = move-exception;
        throw th;
    L44:
        if (this.f9740h == false) goto L46;
        Logger.i("upLoadLocation from onLocationChanged");     // Catch: Throwable -> L49
        j(r14);     // Catch: Throwable -> L49
    L46:
        this.f9742j = r14;     // Catch: Throwable -> L49
        this.f9741i = true;     // Catch: Throwable -> L49
        monitor-exit(r17);     // Catch: Throwable -> L49
        return;
    L16:
        if (this.f9735c.isOnceLocation() == true) goto L18;
    L23:
        onError(new BDLocationException("location callback null!", "UNKnown", BDLocationException.ERROR_LOCATION_IS_NULL));
        return;
    L18:
        if (this.f9735c.getLocateType() == 0) goto L23;
        if (this.f9735c.isDownGradeLocation() == true) goto L23;
        e();
    }

    @Override // com.bytedance.bdlocation.scan.wifi.WifiUtil.WifiInfoJsonCallback
    public final void onWifiInfoJson(ha.m r8, boolean r10, boolean r11, WifiInfo r12) {
        this.f9746n = r12;
        this.f9743k = r8;
        this.f9744l = r10;
        this.f9745m = r11;
        Object r13 = this.f9739g;
        monitor-enter(r13);
        this.f9740h = true;     // Catch: Throwable -> L10
        if (this.f9741i == false) goto L8;
        Logger.i("upLoadLocation from onWifiInfoJson");     // Catch: Throwable -> L10
        j(this.f9742j);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r13);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
