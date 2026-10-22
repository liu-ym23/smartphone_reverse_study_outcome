package o5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.sensor.SensorInfoManager;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import com.bytedance.bdlocation.trace.StackTraceRecorder;
import com.bytedance.bdlocation.utils.background.ActivityLifecycleUtil;
import com.bytedance.bdlocation.utils.background.BackgroundProvider;
import com.bytedance.bdlocation.utils.background.DefaultBackgroundProvider;

/* JADX INFO: loaded from: classes.dex */
public final class w {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static w f9723h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f9724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f9725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9726c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9727d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f9728e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f9730g;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f9731a;

        /* JADX INFO: renamed from: o5.w$a$a, reason: collision with other inner class name */
        public class RunnableC0129a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f9732a;

            public RunnableC0129a(a r8) {
                this.f9732a = r8;
            }

            @Override // java.lang.Runnable
            public final void run() {
                boolean r8 = LocationUtil.isLocationEnabled();
                Logger.i("LocationServiceObserver");
                a r10 = this.f9732a;
                w r11 = r10.f9731a;
                if (r11.f9728e == false) goto L6;
                LocationUtil.uploadDeviceStatus("bdlocation_provider_status_change", 0);
                r10.f9731a.f9728e = false;
            L8:
                r10.f9731a.f9727d = r8;
                return;
            L6:
                if (r8 == r11.f9727d) goto L8;
                LocationUtil.uploadDeviceStatus("bdlocation_provider_status_change", 0);
                goto L8
            }
        }

        public a(w r8) {
            this.f9731a = r8;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r10) {
            this.f9731a.f9724a.post(new RunnableC0129a(this));
        }
    }

    public w() {
        this.f9726c = false;
        this.f9728e = true;
        this.f9729f = true;
        this.f9730g = new a(this);
        Handler r8 = new Handler(ThreadLooperManager.getSchedulerWorker());
        this.f9724a = r8;
        Context r10 = BDLocationConfig.getContext();
        this.f9725b = r10;
        if (r10 != null) goto L5;
        StackTraceRecorder.setColdBootStackTrace(LocationUtil.getStackTrace());
    L5:
        b();
        Logger.d("ColdBootManagersetLegitimate");
        r8.postDelayed(new s(), BDLocationConfig.getBootLegitimateTime());
        if (BDLocationConfig.isColdBootABTest() == false) goto L11;
        Logger.d("ColdBootManagerregisterBackgroundCallbackABTest");
        BackgroundProvider r11 = BDLocationConfig.getAppBackgroundProvider();
        BackgroundProvider r12 = r11;
        if (r11 != null) goto L10;
        DefaultBackgroundProvider r13 = new DefaultBackgroundProvider();
        ActivityLifecycleUtil.register(r13);
        ActivityLifecycleUtil.init();
        Logger.i("set default AppBackgroundProvider");
        BDLocationConfig.setAppBackgroundProvider(r13);
        r12 = r13;
    L10:
        r12.addCallback(new v(this));
    L15:
        c();
        Logger.d("ColdBootManagerinit`");
        return;
    L11:
        Logger.d("ColdBootManagerregisterBackgroundCallback");
        BackgroundProvider r14 = BDLocationConfig.getAppBackgroundProvider();
        BackgroundProvider r15 = r14;
        if (r14 != null) goto L14;
        DefaultBackgroundProvider r16 = new DefaultBackgroundProvider();
        ActivityLifecycleUtil.register(r16);
        ActivityLifecycleUtil.init();
        Logger.i("set default AppBackgroundProvider");
        BDLocationConfig.setAppBackgroundProvider(r16);
        r15 = r16;
    L14:
        r15.addCallback(new t(this));
        goto L15
    }

    public static void a(w r8, boolean r10) {
        Context r11 = r8.f9725b;
        if (r10 == false) goto L7;
        Logger.i("outerBackgroundTaskTest enter background");
        BDLocationConfig.setRequestLocation(false);
        NetworkManager.getInstance().unregisterNetworkCallback(r11);
        if (BDLocationConfig.enableBackgroundLocation() == true) goto L12;
        m5.a.a().e();
        r8.e();
        NetworkManager.getInstance().unRegisterObserver(r8.f9725b);
        g r12 = g.j();
        r12.getClass();
        Logger.i("BDLocationService.stopLocationBecauseEnterBackground.");
        Handler r13 = g.f9675m;
        r13.post(new i(r12));
        g r14 = g.j();
        r14.getClass();
        r13.post(new h(r14));
        SensorInfoManager.getInstance().unregisterListener(5);
        return;
    L12:
        return;
    L7:
        Logger.i("outerBackgroundTaskTest enter foreground");
        NetworkManager.getInstance().registerNetworkCallback(r11);
        if (r8.f9729f == false) goto L10;
        r8.f9729f = false;
        Logger.i("cold boot upload info");
        r8.d(r11);
        return;
    L10:
        BDLocationConfig.setFirstRequestLocation(true);
        r8.b();
        r8.f9724a.postDelayed(new r(1), BDLocationConfig.getBootLegitimateTime());
        r8.c();
        Logger.i("outerBackgroundTaskTest upload info");
        LocationUtil.uploadDeviceStatus("bdlocation_background_switch", 0);
    }

    public final void b() {
        Context r8 = this.f9725b;
        if (r8 != null) goto L5;
        return;
    L5:
        if (PermissionManager.hasLocationPermissions(r8) == false) goto L8;
        return;
    L8:
        if (LocationUtil.isMainThread() == false) goto L10;
        q r10 = new q(0);
        this.f9724a.post(r10);
        return;
    L10:
        LocationCache.getInstance().clearLocalLocationCache();
    }

    public final synchronized void c() {
        monitor-enter(this);
        Logger.d("ColdBootManagerregisterLocationServiceObserver");     // Catch: Throwable -> L19
        if (this.f9725b != null) goto L7;
    L17:
        monitor-exit(this);
        return;
    L7:
        if (this.f9730g == null) goto L17;
        if (this.f9726c == true) goto L17;
        this.f9725b.registerReceiver(this.f9730g, new IntentFilter("android.location.MODE_CHANGED"));     // Catch: Throwable -> L13
        this.f9726c = true;     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        Logger.i("registerLocationServiceObserver error" + th.toString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final void d(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Logger.d("ColdBootManagerstartUploadTask");
        if (l7.e.b(r8) == true) goto L7;
        return;
    L7:
        if (BDLocationConfig.isReportAtStart() == false) goto L11;
        this.f9724a.postDelayed(new androidx.room.k(8, this, r8), 3000);
        return;
    }

    public final synchronized void e() {
        monitor-enter(this);
        Logger.d("ColdBootManagerunRegisterLocationServiceObserver");     // Catch: Throwable -> L18
    L14:
        th = move-exception;
        Logger.i("unRegisterLocationServiceObserver error" + th.toString());     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return;
    L6:
        if (this.f9726c == false) goto L16;
        Context r8 = this.f9725b;     // Catch: Throwable -> L14
        if (r8 == null) goto L12;
        a r10 = this.f9730g;     // Catch: Throwable -> L14
        if (r10 == null) goto L12;
        r8.unregisterReceiver(r10);     // Catch: Throwable -> L14
    L12:
        this.f9726c = false;     // Catch: Throwable -> L14
    L18:
        th = move-exception;
        throw th;
    }
}
