package com.bytedance.bdlocation_impl.c;

import android.content.Context;
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
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.scan.wifi.WifiUtil;
import com.bytedance.bdlocation.store.BDLightLocationCache;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.google.gson.JsonArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d implements BDLocationCallback, WifiUtil.WifiInfoJsonCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BDLocationCallback f1944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a.C0108a f1945b;
    private final LocationOption c;
    private Handler d;
    private final Handler e;
    private long f;
    private Object g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile BDLocation j;
    private volatile JsonArray k;
    private volatile boolean l;
    private volatile boolean m;
    private WifiInfo n;

    public d(BDLocationCallback r3, LocationOption r4, a.C0108a r5, Handler r6, Handler r7) {
        BDLocationCallback r8 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
        this.g = new Object();
        this.l = true;
        this.m = true;
        this.f1944a = r8;
        this.f1945b = r5;
        this.c = r4;
        this.d = r6;
        this.f = SystemClock.elapsedRealtime();
        if (r7 == null) goto L5;
        this.e = r7;
        return;
    L5:
        this.e = new Handler(ThreadLooperManager.getLocationWorker());
    }

    static /* synthetic */ LocationOption a(d r0) {
        return r0.c;
    }

    private void a() {
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocationType:" + this.c.getLocateType());
        this.c.setLocateType(0);
        this.c.setDownGradeLocation(true);
        String r0 = LocationUtil.allowUseLocation(true);
        if ("1".equals(r0) == true) goto L7;
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocation error:" + r0);
        onError(new BDLocationException(BDLocationExceptionMessage.NON_ALLOWED_MESSAGE, LocationInfoConst.BDLOCATION, r0));
        return;
    L7:
        if (LocationUtil.isUseByteLocationPolicyV2(this.c.getUploadSource()) == false) goto L10;
        b();
        return;
    L10:
        this.f1945b.c();
        Logger.i("location-trace-core LocationCallbackServer decideDownGradeLocation");
        a.a().a(this.f1944a, new LocationOption(this.c));
    }

    private void a(long r3) {
        if (BDLightLocationCache.lightLocationNeedCheckCache() == false) goto L6;
        BDLightLocationCache.setLastLocationTime((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r3);
        return;
    }

    private void a(BDLocation r4, LocationOption r5, LocationUploadCallback r6) {
        LocationUploadCallback r7 = (LocationUploadCallback) ZeusTransformUtils.wrapperContextForParams(r6, LocationUploadCallback.class, "com.obric.memorydata.plugin");
        LocationUploadExtra r0 = new LocationUploadExtra();
        r0.locationOption = r5;
        r0.setUploadInterval(r5.getUploadInterval());
        r0.setLocateId(r5.getLocateId());
        if (BDLocationConfig.isMockEnable() == false) goto L5;
        String r1 = "mock";
    L6:
        r0.setUploadSource(r1);
        r0.setTriggerType(r5.getTriggerType());
        r0.setLatestAdminVersion(r5.isLatestAdminVersion());
        r0.setBpeaCert(r5.getBpeaCert());
        r0.setStartLocationTime(r5.getStartLocationTime());
        if (r5.getLocationExtraBean() == null) goto L9;
        r0.setLogIdCache(r5.getLocationExtraBean().getLogIdCacheEntity());
        r0.setBleList(r5.getLocationExtraBean().getBleInfoList());
    L9:
        r0.setExtra(r5.getExtra());
        r0.setWifiDate(this.k);
        r0.setRecommendWifiResults(this.m);
        r0.setWifiCache(this.l);
        r0.setOnceLocation(r5.isOnceLocation());
        r0.setLocationTraceLogger(r5.getLocationTraceLogger());
        r0.setLocationExtraDataServer(r5.getLocationExtraDataServer());
        r0.setConnectedWifiInfo(this.n);
        r0.setStationarySceneCacheInfo(r5.getStationarySceneCacheInfo());
        LocationUtil.startLocateUpload(r4, r0, r7);
        return;
    L5:
        r1 = r5.getUploadSource();
        goto L6
    }

    private void a(BDLocation r3, boolean r4) {
        Logger.i("callbackContinueLocationInfo isSynchronizeUpload:" + this.c.isSynchronizeUpload() + "--needCallback:" + r4);
        if (this.c.isSynchronizeUpload() == true) goto L5;
        if (r4 == false) goto L5;
    L7:
        if (this.c.isSynchronizeUpload() == true) goto L9;
        if (r4 == true) goto L9;
        return;
    L9:
        final BDLocation r5 = LocationUtil.transformLocationForLevel(r3, this.c.getAccuracyLevel());
        if (this.d != null) goto L12;
        this.d = new Handler(Looper.getMainLooper());
    L12:
        this.d.post(new AnonymousClass3(this, r5));
        return;
    L5:
        e(r3);
        c(r3, true);
        goto L7
    }

    private void a(final BDLocation r5, boolean r6, boolean r7) {
        if (this.d != null) goto L5;
        this.d = new Handler(Looper.getMainLooper());
    L5:
        List<BDLocationCallback> r0 = null;
        a.C0108a r1 = this.f1945b;
        monitor-enter(r1);
    L29:
        th = move-exception;
        throw th;
    L8:
        if (this.c.isCallbackThroughLocateTrace == false) goto L10;
        Logger.i("LocationCallbackServer callbackLocationInfoInner callback merge location.");     // Catch: Throwable -> L29
        r0 = this.f1945b.b();     // Catch: Throwable -> L29
    L10:
        if (r6 == false) goto L12;
        this.f1945b.c();     // Catch: Throwable -> L29
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L29
        if (r0 != null) goto L15;
    L25:
        this.d.post(new $$Lambda$d$Rs_Kj3Ph6C7xG5h07opwJpiUg(this, r5));
        if (r7 == false) goto L38;
    L27:
        d(r5);
        return;
    L38:
        return;
    L15:
        if (r0.isEmpty() == true) goto L25;
        int r8 = 0;
    L18:
        if (r8 >= r0.size()) goto L23;
        final BDLocationCallback r2 = (BDLocationCallback) ZeusTransformUtils.preCheckCast(r0.get(r8), BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L22;
        this.d.post(new $$Lambda$d$33bqgmVauxyQe7K53BSI1pk4Zvs(r2, r5));
    L22:
        r8 = r8 + 1;
        goto L18
    L23:
        if (r7 == true) goto L27;
    }

    private static /* synthetic */ void a(BDLocationCallback r2, BDLocation r3) {
        ((BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r2, BDLocationCallback.class, "com.obric.memorydata.plugin")).onLocationChanged(r3);
    }

    private static /* synthetic */ void a(BDLocationCallback r2, BDLocationException r3) {
        ((BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r2, BDLocationCallback.class, "com.obric.memorydata.plugin")).onError(r3);
    }

    private void a(BDLocationException r5) {
        if (r5 == null) goto L5;
        Logger.i("doMonitorLocationFail: errCode:" + r5.getCode() + "--DetailMessage:" + r5.getDetailMessage());
    L5:
        if (this.c.isOnceLocation() == false) goto L8;
        LocationMonitor.locationTraceLogErrorReport(this.c, r5);
        LocationMonitor.doDesiredLocationFail(SystemClock.elapsedRealtime() - this.f, r5, this.c);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - this.f) + "ms");
        return;
    }

    static /* synthetic */ void a(d r0, BDLocation r1) {
        r0.d(r1);
    }

    static /* synthetic */ void a(d r0, BDLocation r1, boolean r2) {
        r0.b(r1, r2);
    }

    private void a(boolean r5) {
        if (BDLocationConfig.isFirstLocation() == true) goto L5;
        return;
    L5:
        LocationMonitor.doFirstLocationDuration(SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime(), r5);
        Logger.i("locationmonitor first location duration is: " + (SystemClock.elapsedRealtime() - BDLocationConfig.getInitStartTime()) + "ms");
        BDLocationConfig.setFirstLocation(false);
    }

    static /* synthetic */ BDLocationCallback b(d r0) {
        return r0.f1944a;
    }

    private void b() {
        if (this.c.getSysLocation() == null) goto L5;
    L7:
        long r0 = 0;
    L8:
        Logger.i("location-trace-core LocationCallbackServer decideByteLocationDownGradeLocation delayedTime:" + r0);
        new Handler(ThreadLooperManager.getLocationWorker()).postDelayed(new $$Lambda$d$nJhOfFCbqyZTOnfDyItUuXZnpA(this), r0);
        return;
    L5:
        if (this.c.getGpsLocation() != null) goto L7;
        r0 = BDLocationConfig.getGpsScanInterval();
        goto L8
    }

    private void b(final BDLocation r5) {
        final long r0 = System.currentTimeMillis();
        if (this.c.isOnceLocation() == false) goto L5;
    L7:
        a(r5, this.c, new AnonymousClass1(this, r0, r5));
        return;
    L5:
        if (this.c.isSynchronizeUpload() == true) goto L7;
        a(r5, true);
        goto L7
    }

    private void b(BDLocation r3, boolean r4) {
        a.C0108a r5 = this.f1945b;
        monitor-enter(r5);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.c.alreadyCallback == true) goto L7;
    L10:
        this.c.alreadyCallback = true;     // Catch: Throwable -> L17
        boolean r0 = true;
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L17
        e(r3);
        c(r3, r0);
        BDLocation r6 = LocationUtil.transformLocationForLevel(r3, this.c.getAccuracyLevel());
        if (r0 == false) goto L15;
        a(r6, true, true);
        Logger.i("location-trace-core callback at full location completion time.");
        return;
    L15:
        Logger.i("location-trace-core not callback at full location completion time.");
        Logger.i("location-trace-core LocationCallbackServer callbackLocationInfo LocateTrace.onLocateStop");
        this.f1945b.c();
        d(r6);
        return;
    L7:
        if (this.c.isOnceLocation() == false) goto L10;
        r0 = false;
        goto L11
    }

    private /* synthetic */ void b(BDLocationException r1) {
        this.f1944a.onError(r1);
    }

    static /* synthetic */ void b(d r0, BDLocation r1, boolean r2) {
        r0.a(r1, r2);
    }

    private /* synthetic */ void c() {
        if (this.c.getSysLocation() != null) goto L5;
        BDLocation r0 = this.c.getGpsLocation();
    L6:
        if (r0 == null) goto L9;
        b(r0);
        return;
    L9:
        onError(new BDLocationException("ByteLocationDownGradeLocationError", LocationInfoConst.SYSTEM, BDLocationException.ERROR_DOWNGRADE_LOCATION));
        return;
    L5:
        r0 = this.c.getSysLocation();
        goto L6
    }

    private void c(final BDLocation r5) {
        LocationUploadExtra r0 = new LocationUploadExtra();
        r0.setUploadInterval(this.c.getUploadInterval());
        r0.setLocateId(this.c.getLocateId());
        if (BDLocationConfig.isMockEnable() == false) goto L5;
        String r1 = "mock";
    L6:
        r0.setUploadSource(r1);
        r0.setTriggerType(this.c.getTriggerType());
        r0.setBpeaCert(this.c.getBpeaCert());
        r0.setStartLocationTime(this.c.getStartLocationTime());
        r0.setExtra(this.c.getExtra());
        r0.setOnceLocation(this.c.isOnceLocation());
        r0.setLocationTraceLogger(this.c.getLocationTraceLogger());
        r0.setStartLocationTimestampInMillis(this.c.startLocationTimestampInMillis);
        final long r2 = System.currentTimeMillis();
        LocationUtil.startCacheLocateInfoUpload(r0, new AnonymousClass2(this, r2, r5));
        return;
    L5:
        r1 = this.c.getUploadSource();
        goto L6
    }

    private void c(BDLocation r6, boolean r7) {
        CacheConditionEntity r0 = new CacheConditionEntity();
        if (r6 != null) goto L7;
        r0.setConditionCode(1);
        LocationCache.getInstance().executeWithoutLocationCache(System.currentTimeMillis(), r0, false);
        return;
    L7:
        if (r6.getLocationType() != 6) goto L11;
        Logger.i("IP location");
        r0.setConditionCode(2);
        LocationCache.getInstance().executeWithoutLocationCache(r6.getLocationMs(), r0, !r6.isCache());
        return;
    L11:
        if (r6.isMock() == false) goto L14;
        Logger.i("mock location");
        r0.setConditionCode(3);
        LocationCache.getInstance().executeWithoutLocationCache(r6.getLocationMs(), r0, !r6.isCache());
        return;
    L14:
        Logger.i("CheckNewLocation new location time:" + r6.getLocationMs());
        BDLocation r2 = LocationCache.getInstance().getLocationCache().getLatestLocation();
        Logger.i("LocationCallbackServer executeLocationCache isUseNewCacheStrategy: " + BDLocationConfig.isUseNewCacheStrategy());
        if (BDLocationConfig.isUseCacheCondition() == false) goto L27;
        if (r6.isCache() == false) goto L19;
        return;
    L19:
        if (BDLocationConfig.isRestrictedModeOn() == false) goto L22;
        r0.setConditionCode(4);
        LocationCache.getInstance().executeWithoutLocationCache(r6.getLocationMs(), r0, !r6.isCache());
        return;
    L22:
        if (LocationUtil.isBetterLocation(r6, r2, r0) == false) goto L24;
    L25:
        Logger.i("UseCacheCondition checkNewLocation executeLocationCache");
        a(r6.getLocationMs());
        LocationCache.getInstance().executeLocationCache(r6, r0, true ^ r6.isCache(), r7);
        return;
    L24:
        if (LocationUtil.isGoodLocation(r6, r0) == true) goto L25;
        return;
    L27:
        if (LocationUtil.isBetterLocation(r6, r2) == true) goto L31;
        if (LocationUtil.isGoodLocation(r6) == true) goto L31;
        return;
    L31:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L39;
        Logger.i("CheckNewLocation executeLocationCache");
        a(r6.getLocationMs());
        LocationCache.getInstance().executeLocationCache(r6, !r6.isCache(), r7);
        return;
    }

    private void d(BDLocation r5) {
        if (this.c.isOnceLocation() == false) goto L6;
        LocationMonitor.locationTraceLogEnd(this.c.getLocationTraceLogger(), "total_duration");
        LocationMonitor.locationTraceLogSuccessReport(r5, this.c);
        LocationMonitor.doDesiredLocationSuccess(SystemClock.elapsedRealtime() - this.f, r5, this.c);
        Logger.i("locationmonitor location total duration is: " + (SystemClock.elapsedRealtime() - this.f) + "ms");
        return;
    }

    private synchronized void e(BDLocation r7) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (com.bytedance.bdlocation_impl.a.a.a().f() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        if (r7 != null) goto L9;
    L21:
        monitor-exit(this);
        return;
    L9:
        if (BDLocationConfig.isUpload() == false) goto L21;
        if (BDLocationConfig.isPollingUpload() == false) goto L21;
        if (LocationUtil.checkBackground() == true) goto L21;
        Logger.i("register UploadScheduleController isCache：" + r7.isCache());     // Catch: Throwable -> L23
        NetworkManager.getInstance().registerObserver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L23
        long r0 = BDLocationConfig.getUploadInterval();     // Catch: Throwable -> L23
        if (r7.isCache() == false) goto L20;
        r0 = BDLocationConfig.getUploadInterval() - (System.currentTimeMillis() - r7.getLocationMs());     // Catch: Throwable -> L23
        if (r0 > 0) goto L19;
        r0 = 5000;
    L19:
        Logger.d("register UploadScheduleController interval:" + r0 + "--cacheTime:" + r7.getLocationMs());     // Catch: Throwable -> L23
    L20:
        com.bytedance.bdlocation_impl.a.a.a().a(r0);     // Catch: Throwable -> L23
        goto L21
    }

    private /* synthetic */ void f(BDLocation r1) {
        this.f1944a.onLocationChanged(r1);
    }

    private static /* synthetic */ void g(BDLocation r1) {
        LocationCache.getInstance().performLocationChangeNotificationIfNeed(r1);
    }

    public static /* synthetic */ void lambda$33bqgmVauxyQe7K53BSI1pk4Zvs(BDLocationCallback r0, BDLocation r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$JL3yJ-Lh4b00n4GPeUpadfHmoFU, reason: not valid java name */
    public static /* synthetic */ void m85lambda$JL3yJLh4b00n4GPeUpadfHmoFU(BDLocationCallback r0, BDLocationException r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$Rs-_Kj3Ph6C7xG5h07opwJpiU-g, reason: not valid java name */
    public static /* synthetic */ void m86lambda$Rs_Kj3Ph6C7xG5h07opwJpiUg(d r0, BDLocation r1) {
        r0.f(r1);
    }

    /* JADX INFO: renamed from: lambda$jP9UpDsPEjA2Kmnmg--MZhIdQls, reason: not valid java name */
    public static /* synthetic */ void m87lambda$jP9UpDsPEjA2KmnmgMZhIdQls(BDLocation r0) {
        g(r0);
    }

    /* JADX INFO: renamed from: lambda$nJhOfFCbqyZTO-nfDyItUuXZnpA, reason: not valid java name */
    public static /* synthetic */ void m88lambda$nJhOfFCbqyZTOnfDyItUuXZnpA(d r0) {
        r0.c();
    }

    public static /* synthetic */ void lambda$orXmkNP55P5RWpNh9PFz1eOaH5U(d r0, BDLocationException r1) {
        r0.b(r1);
    }

    public void a(BDLocation r6) {
        a.C0108a r0 = this.f1945b;
        monitor-enter(r0);
        boolean r1 = true;
        if (r6 != null) goto L19;
    L9:
        r1 = false;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L16
        if (r1 == false) goto L13;
        final BDLocation r7 = LocationUtil.transformLocationForLevel(r6, this.c.getAccuracyLevel());
        this.e.post(new $$Lambda$d$jP9UpDsPEjA2KmnmgMZhIdQls(r7));
        a(r7, false, false);
        String r5 = "location-trace-core callback at light location completion time.";
    L14:
        Logger.i(r5);
        return;
    L13:
        r5 = "location-trace-core not callback at light location completion time.";
    L16:
        th = move-exception;
        throw th;
    L19:
        this.f1945b.a(r6, this.c);     // Catch: Throwable -> L16
        if (this.c.alreadyCallback == true) goto L9;
        this.c.alreadyCallback = true;     // Catch: Throwable -> L16
        goto L10
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public void onError(final BDLocationException r6) {
        Logger.i("LocationCallbackServer onError");
        int r0 = 0;
        BDLocationConfig.setOpenStationaryScene(false);
        if (this.c.isOnceLocation() == true) goto L5;
    L10:
        boolean r2 = true;
        if (this.c.isChineseRegion() == false) goto L13;
    L18:
        a.C0108a r1 = this.f1945b;
        monitor-enter(r1);
    L60:
        th = move-exception;
        throw th;
    L21:
        if (LocationUtil.isUseByteLocationPolicy(this.c.getUploadSource()) == true) goto L23;
    L27:
        this.c.alreadyCallback = true;     // Catch: Throwable -> L60
        r2 = false;
    L28:
        monitor-exit(r1);     // Catch: Throwable -> L60
        if (r2 == false) goto L33;
        Logger.i("location-trace-core full location failed, try use light location callback.");
        b(this.c.getLightLocation(), false);
        return;
    L33:
        if (this.d != null) goto L36;
        this.d = new Handler(Looper.getMainLooper());
    L36:
        if (BDLocationConfig.isUseCacheCondition() == false) goto L38;
        CacheConditionEntity r3 = new CacheConditionEntity();
        r3.setConditionCode(0);
        LocationCache.getInstance().executeWithoutLocationCache(System.currentTimeMillis(), r3, false);
    L38:
        List<BDLocationCallback> r4 = null;
        a.C0108a r5 = this.f1945b;
        monitor-enter(r5);
    L57:
        th = move-exception;
        throw th;
    L41:
        if (this.c.isCallbackThroughLocateTrace == false) goto L43;
        Logger.i("location-trace-core LocationCallbackServer mergeLocation onError");     // Catch: Throwable -> L57
        r4 = this.f1945b.b();     // Catch: Throwable -> L57
    L43:
        this.f1945b.c();     // Catch: Throwable -> L57
        monitor-exit(r5);     // Catch: Throwable -> L57
        if (r4 != null) goto L47;
    L54:
        this.d.post(new $$Lambda$d$orXmkNP55P5RWpNh9PFz1eOaH5U(this, r6));
    L55:
        a(r6);
        return;
    L47:
        if (r4.isEmpty() == true) goto L54;
    L49:
        if (r0 >= r4.size()) goto L55;
        final BDLocationCallback r7 = (BDLocationCallback) ZeusTransformUtils.preCheckCast(r4.get(r0), BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L53;
        this.d.post(new $$Lambda$d$JL3yJLh4b00n4GPeUpadfHmoFU(r7, r6));
    L53:
        r0 = r0 + 1;
        goto L49
    L23:
        if (this.c.isOnceLocation() == false) goto L27;
        if (this.c.getLightLocation() == null) goto L27;
    L13:
        if (this.c.getLocateType() != 0) goto L18;
        Logger.i("overseas getLocation error and use cache");
        BDLocation r8 = a.a().b(this.c);
        boolean r9 = a.a().b(r8, this.c);
        LocationMonitor.overseasLocationFailedGetCache(r9);
        if (r9 == false) goto L18;
        b(r8, true);
        return;
    L5:
        if (this.c.getLocateType() == 0) goto L10;
        if (this.c.isDownGradeLocation() == true) goto L10;
        a();
    }

    @Override // com.bytedance.bdlocation.scan.wifi.WifiUtil.WifiInfoJsonCallback
    public void onFailed(BDLocationException r2) {
        Object r3 = this.g;
        monitor-enter(r3);
        this.h = true;     // Catch: Throwable -> L10
        if (this.i == false) goto L8;
        Logger.i("upLoadLocation from scan Wifi onFailed");     // Catch: Throwable -> L10
        b(this.j);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r3);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdlocation.callback.BDLocationCallback
    public void onLocationChanged(BDLocation r5) {
        if (this.c.isHitStationaryScene() == false) goto L7;
        c(r5);
        return;
    L7:
        if (this.c.isOnceLocation() == true) goto L10;
        BDLocationConfig.setOpenStationaryScene(false);
    L10:
        if (LocationUtil.isEmpty(r5) == true) goto L12;
        a(r5.isCache());
        if (r5.isCache() == false) goto L25;
        b(r5, true);
        return;
    L25:
        BDLocation r6 = LocationUtil.convertLocation(r5);
        if (this.c.isUpload() == true) goto L28;
    L45:
        LocInfoRspData r0 = r6.getLocInfoRsp();
        if (r0 != null) goto L48;
    L50:
        com.bytedance.bdlocation_impl.b.a.a(r0);
        if (r0 == null) goto L53;
        LocInfoRspData r3 = new LocInfoRspData(r0);
    L54:
        if (r3 == null) goto L57;
        r6.setSubmitLogId(r3.submitLogId);
    L57:
        if (this.c.isOnceLocation() == false) goto L59;
        com.bytedance.bdlocation_impl.b.a.b(r3, r6, this.c);
    L59:
        b(r6, false);
        com.bytedance.bdlocation_impl.b.a.a(r3, r6, this.c);
        r6.setLocInfoRsp(null);
        return;
    L53:
        r3 = null;
        goto L54
    L48:
        if (r0.disablePollingUpload != 1) goto L50;
        Logger.i("disablePollingUpload == 1, disable polling upload.");
        com.bytedance.bdlocation_impl.a.a.b();
        goto L50
    L28:
        if (LocationUtil.needUpload(r6) == false) goto L45;
        if (this.c.isOnceLocation() == true) goto L32;
    L44:
        b(r6);
        return;
    L32:
        if (BDLocationConfig.isAsyncScanWifi() == false) goto L44;
        Object r1 = this.g;
        monitor-enter(r1);
    L41:
        th = move-exception;
        throw th;
    L36:
        if (this.h == false) goto L38;
        Logger.i("upLoadLocation from onLocationChanged");     // Catch: Throwable -> L41
        b(r6);     // Catch: Throwable -> L41
    L38:
        this.j = r6;     // Catch: Throwable -> L41
        this.i = true;     // Catch: Throwable -> L41
        monitor-exit(r1);     // Catch: Throwable -> L41
        return;
    L12:
        if (this.c.isOnceLocation() == true) goto L14;
    L19:
        onError(new BDLocationException("location callback null!", "UNKnown", BDLocationException.ERROR_LOCATION_IS_NULL));
        return;
    L14:
        if (this.c.getLocateType() == 0) goto L19;
        if (this.c.isDownGradeLocation() == true) goto L19;
        a();
    }

    @Override // com.bytedance.bdlocation.scan.wifi.WifiUtil.WifiInfoJsonCallback
    public void onWifiInfoJson(JsonArray r1, boolean r2, boolean r3, WifiInfo r4) {
        this.n = r4;
        this.k = r1;
        this.l = r2;
        this.m = r3;
        Object r5 = this.g;
        monitor-enter(r5);
        this.h = true;     // Catch: Throwable -> L10
        if (this.i == false) goto L8;
        Logger.i("upLoadLocation from onWifiInfoJson");     // Catch: Throwable -> L10
        b(this.j);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r5);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }
}
