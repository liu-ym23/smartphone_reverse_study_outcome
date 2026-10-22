package com.bytedance.bdlocation_impl.c;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.trace.StackTraceRecorder;
import com.bytedance.bdlocation.utils.background.ActivityLifecycleUtil;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.bytedance.bdlocation.utils.background.DefaultBackgroundProvider;
import com.bytedance.frameworks.baselib.network.http.util.g;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static b g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1936b;
    private Handler c;
    private Looper d;
    private Context e;
    private boolean f;
    private boolean h;
    private boolean i;
    private boolean j;
    private PluginBroadcastReceiver k;

    /* JADX INFO: renamed from: com.bytedance.bdlocation_impl.c.b$2, reason: invalid class name */
    class AnonymousClass2 implements BackgroundProvider.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1938a;

        AnonymousClass2(b r1) {
            this.f1938a = r1;
        }

        private /* synthetic */ void a() {
            LocationUtil.startGetDimLocation((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.b(this.f1938a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        }

        public static /* synthetic */ void lambda$tMCz_DTpvv2BWJaVGh8UNH91D0k(AnonymousClass2 r0) {
            r0.a();
        }

        @Override // com.bytedance.bdlocation.utils.background.BackgroundProvider.Callback
        public void onAppBackgroundSwitch(boolean r4) {
            Logger.i("onAppBackgroundSwitch isEnterBackground:" + r4 + "--coldBootBackground：" + b.a(this.f1938a));
            if (b.a(this.f1938a) == false) goto L6;
            b.a(this.f1938a, false);
            b r5 = this.f1938a;
            b.a(r5, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.b(r5), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            NetworkManager.getInstance().registerNetworkCallback((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.b(this.f1938a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
            return;
        L6:
            if (r4 == false) goto L8;
            b.c(this.f1938a);
            return;
        L8:
            b.d(this.f1938a).post(new $$Lambda$b$2$tMCz_DTpvv2BWJaVGh8UNH91D0k(this));
            b.e(this.f1938a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation_impl.c.b$3, reason: invalid class name */
    class AnonymousClass3 implements BackgroundProvider.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f1939a;

        AnonymousClass3(b r1) {
            this.f1939a = r1;
        }

        private /* synthetic */ void a(boolean r1) {
            b.b(this.f1939a, r1);
        }

        /* JADX INFO: renamed from: lambda$sv_-NbidSSSYJTH_EpXrPIXoe40, reason: not valid java name */
        public static /* synthetic */ void m84lambda$sv_NbidSSSYJTH_EpXrPIXoe40(AnonymousClass3 r0, boolean r1) {
            r0.a(r1);
        }

        @Override // com.bytedance.bdlocation.utils.background.BackgroundProvider.Callback
        public void onAppBackgroundSwitch(final boolean r3) {
            Logger.i("onAppBackgroundSwitchTest isEnterBackground:" + r3);
            if (LocationUtil.isMainThread() == false) goto L5;
            b.d(this.f1939a).post(new $$Lambda$b$3$sv_NbidSSSYJTH_EpXrPIXoe40(this, r3));
            return;
        L5:
            b.b(this.f1939a, r3);
        }
    }

    public b() {
        this.f1935a = "bdlocation_background_switch";
        this.f1936b = "bdlocation_provider_status_change";
        this.f = false;
        this.i = true;
        this.j = true;
        this.k = new AnonymousClass4(this);
        this.d = ThreadLooperManager.getSchedulerWorker();
        this.c = new Handler(this.d);
        Context r0 = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.e = r0;
        if (r0 != null) goto L5;
        StackTraceRecorder.setColdBootStackTrace(LocationUtil.getStackTrace());
    L5:
        b();
        c();
        if (BDLocationConfig.isColdBootABTest() == false) goto L8;
        h();
    L9:
        m();
        Logger.d("ColdBootManagerinit`");
        return;
    L8:
        d();
        goto L9
    }

    public static b a() {
        if (g != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    private void a(Context r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        Logger.d("ColdBootManagerstartUploadTask");
        if (g.c(r4) == true) goto L8;
        return;
    L8:
        if (BDLocationConfig.isReportAtStart() == false) goto L12;
        this.c.postDelayed(new $$Lambda$b$otJN3XEx8YFsK16khWf781IpeSM(this, r4), 3000);
        return;
    }

    static /* synthetic */ void a(b r2, Context r3) {
        r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    private void a(boolean r1) {
        if (r1 == false) goto L4;
        j();
        return;
    L4:
        i();
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.j;
    }

    static /* synthetic */ boolean a(b r0, boolean r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ Context b(b r0) {
        return r0.e;
    }

    private /* synthetic */ void b(Context r6) {
        LocationUtil.startGetDimLocation((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"));
        Logger.d("boot upload Location:" + BDLocationConfig.isReportLocationAtStart());
        if ("1".equals(LocationUtil.allowUseLocation(true)) == false) goto L11;
        LocInfoRspData r0 = LocationUtil.uploadDeviceStatus("bdlocation_boot_upload_device_info", 0);
        if (r0 != null) goto L7;
    L12:
        o();
        return;
    L7:
        if (r0.isLocate == false) goto L12;
        LocationOption r1 = new LocationOption();
        r1.setUploadSource("bdlocation_boot_upload_location_info");
        r1.setMaxCacheTime(BDLocationConfig.getUploadInterval());
        r1.setTriggerType(0);
        r1.setUpload(true);
        r1.setLocationTimeOutMs(30000);
        r1.setLocateType(BDLocationConfig.getLocateType());
        r1.setBpeaCert(BDLocationConfig.getBpeaCert(LocationInfoConst.COLDSTART_CERT));
        r1.setBpeaAction("getLocation");
        r1.setMode(BDLocationConfig.getLocationMode());
        if (a.a().a(a.a().b(r1), r1) == true) goto L12;
        com.bytedance.bdlocation_impl.d.a.a(r1, null);
        goto L12
    L11:
        LocationUtil.uploadDeviceStatus("bdlocation_boot_upload_device_info", 0);
        goto L12
    }

    static /* synthetic */ void b(b r0, boolean r1) {
        r0.a(r1);
    }

    private void c() {
        Logger.d("ColdBootManagersetLegitimate");
        this.c.postDelayed(new AnonymousClass1(this), BDLocationConfig.getBootLegitimateTime());
    }

    static /* synthetic */ void c(b r0) {
        r0.g();
    }

    static /* synthetic */ boolean c(b r0, boolean r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ Handler d(b r0) {
        return r0.c;
    }

    private void d() {
        Logger.d("ColdBootManagerregisterBackgroundCallback");
        BackgroundProvider r0 = BDLocationConfig.getAppBackgroundProvider();
        if (r0 != null) goto L5;
        r0 = e();
    L5:
        r0.addCallback(new AnonymousClass2(this));
    }

    static /* synthetic */ boolean d(b r0, boolean r1) {
        r0.h = r1;
        return r1;
    }

    private BackgroundProvider e() {
        DefaultBackgroundProvider r2 = new DefaultBackgroundProvider();
        ActivityLifecycleUtil.register((ActivityLifecycleUtil.ActivityNotification) ZeusTransformUtils.preCheckCast(r2, ActivityLifecycleUtil.ActivityNotification.class, "com.obric.memorydata.plugin"));
        ActivityLifecycleUtil.init();
        Logger.i("set default AppBackgroundProvider");
        BDLocationConfig.setAppBackgroundProvider(r2);
        return r2;
    }

    static /* synthetic */ void e(b r0) {
        r0.f();
    }

    private void f() {
        Logger.i("enter foreground");
        BDLocationConfig.setFirstRequestLocation(true);
        BDLocationConfig.setRequestLocation(false);
        this.c.postDelayed($$Lambda$b$2Jxv2TKq_fvYlAAym9ooqdqkDQ.INSTANCE, BDLocationConfig.getBootLegitimateTime());
        m();
        this.c.post(new $$Lambda$b$N5N4SMfmBYXp0jpD5Fynzqqwzrc(this));
        NetworkManager.getInstance().registerNetworkCallback(this.e);
    }

    static /* synthetic */ boolean f(b r0) {
        return r0.i;
    }

    private void g() {
        Logger.i("enter background");
        BDLocationConfig.setRequestLocation(false);
        if (BDLocationConfig.enableBackgroundLocation() == true) goto L5;
        k();
        n();
        l();
        a.a().c();
        a.a().b();
        SensorInfoManager.getInstance().unregisterListener(5);
    L5:
        NetworkManager.getInstance().unregisterNetworkCallback(this.e);
    }

    static /* synthetic */ boolean g(b r0) {
        return r0.h;
    }

    private void h() {
        Logger.d("ColdBootManagerregisterBackgroundCallbackABTest");
        BackgroundProvider r0 = BDLocationConfig.getAppBackgroundProvider();
        if (r0 != null) goto L5;
        r0 = e();
    L5:
        r0.addCallback(new AnonymousClass3(this));
    }

    private void i() {
        Logger.i("outerBackgroundTaskTest enter foreground");
        NetworkManager.getInstance().registerNetworkCallback(this.e);
        if (this.j == false) goto L6;
        this.j = false;
        Logger.i("cold boot upload info");
        a(this.e);
        return;
    L6:
        BDLocationConfig.setFirstRequestLocation(true);
        b();
        this.c.postDelayed($$Lambda$b$e_pKgsL4fzeycrWu1XIcok1qZaA.INSTANCE, BDLocationConfig.getBootLegitimateTime());
        m();
        Logger.i("outerBackgroundTaskTest upload info");
        LocationUtil.uploadDeviceStatus("bdlocation_background_switch", 0);
    }

    private void j() {
        Logger.i("outerBackgroundTaskTest enter background");
        BDLocationConfig.setRequestLocation(false);
        NetworkManager.getInstance().unregisterNetworkCallback(this.e);
        if (BDLocationConfig.enableBackgroundLocation() == true) goto L6;
        k();
        n();
        l();
        a.a().c();
        a.a().b();
        SensorInfoManager.getInstance().unregisterListener(5);
        return;
    }

    private void k() {
        com.bytedance.bdlocation_impl.a.a.a().e();
    }

    private void l() {
        NetworkManager.getInstance().unRegisterObserver(this.e);
    }

    /* JADX INFO: renamed from: lambda$2Jxv2TKq_f-vYlAAym9ooqdqkDQ, reason: not valid java name */
    public static /* synthetic */ void m82lambda$2Jxv2TKq_fvYlAAym9ooqdqkDQ() {
        r();
    }

    public static /* synthetic */ void lambda$N5N4SMfmBYXp0jpD5Fynzqqwzrc(b r0) {
        r0.q();
    }

    /* JADX INFO: renamed from: lambda$ddJJVG2niqqL4d-wkiCWVHdl6ek, reason: not valid java name */
    public static /* synthetic */ void m83lambda$ddJJVG2niqqL4dwkiCWVHdl6ek() {
        s();
    }

    public static /* synthetic */ void lambda$e_pKgsL4fzeycrWu1XIcok1qZaA() {
        p();
    }

    public static /* synthetic */ void lambda$otJN3XEx8YFsK16khWf781IpeSM(b r0, Context r1) {
        r0.b(r1);
    }

    private synchronized void m() {
        monitor-enter(this);
        Logger.d("ColdBootManagerregisterLocationServiceObserver");     // Catch: Throwable -> L18
        if (this.e != null) goto L6;
    L16:
        monitor-exit(this);
        return;
    L6:
        if (this.k == null) goto L16;
        if (this.f == true) goto L16;
        ZeusTransformUtils.registerReceiver(this.e, this.k, new IntentFilter("android.location.MODE_CHANGED"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        this.f = true;     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        Logger.i("registerLocationServiceObserver error" + th.toString());     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private synchronized void n() {
        monitor-enter(this);
        Logger.d("ColdBootManagerunRegisterLocationServiceObserver");     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        Logger.i("unRegisterLocationServiceObserver error" + th.toString());     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return;
    L5:
        if (this.f == false) goto L15;
        Context r0 = this.e;     // Catch: Throwable -> L13
        if (r0 == null) goto L11;
        PluginBroadcastReceiver r1 = this.k;     // Catch: Throwable -> L13
        if (r1 == null) goto L11;
        ZeusTransformUtils.unregisterReceiver(r0, r1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L11:
        this.f = false;     // Catch: Throwable -> L13
    L17:
        th = move-exception;
        throw th;
    }

    private void o() {
        Logger.i("init extra service enable traceroute:" + BDLocationConfig.enableTraceroute());
        if (BDLocationConfig.enableTraceroute() == true) goto L5;
        return;
    L5:
        if (BDLocationConfig.isRestrictedModeOn() == true) goto L9;
        BDLocationExtrasService.getTraceRouteManager().init();
        return;
    }

    private static /* synthetic */ void p() {
        BDLocationConfig.setRequestLocation(true);
    }

    private /* synthetic */ void q() {
        b();
        Logger.i("outerBackgroundTask upload info");
        LocationUtil.uploadDeviceStatus("bdlocation_background_switch", 0);
    }

    private static /* synthetic */ void r() {
        BDLocationConfig.setRequestLocation(true);
    }

    private static /* synthetic */ void s() {
        LocationCache.getInstance().clearLocalLocationCache();
    }

    public void b() {
        Context r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (PermissionManager.hasLocationPermissions(r0) == false) goto L8;
        return;
    L8:
        if (LocationUtil.isMainThread() == false) goto L10;
        this.c.post($$Lambda$b$ddJJVG2niqqL4dwkiCWVHdl6ek.INSTANCE);
        return;
    L10:
        LocationCache.getInstance().clearLocalLocationCache();
    }
}
