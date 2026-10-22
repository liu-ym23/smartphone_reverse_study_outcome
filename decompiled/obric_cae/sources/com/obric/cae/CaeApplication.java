package com.obric.cae;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import androidx.appcompat.app.r;
import com.obric.cae.connectivity.ConnectivityAoiController;
import com.obric.cae.location.CaeLocationManager;
import com.obric.cae.location.StarLocationService;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.runtime.CaeRuntime;
import com.obric.cae.userAware.RecordNearbyManager;
import com.obric.cae.userAware.UserAwareService;
import com.obric.cae.utils.ALogUtil;
import com.obric.cae.utils.CaeUtil;
import v0.f;

/* JADX INFO: loaded from: classes.dex */
public class CaeApplication extends Application {
    private static final String TAG = "CaeApplication";

    /* JADX INFO: renamed from: com.obric.cae.CaeApplication$1, reason: invalid class name */
    public class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ CaeApplication this$0;

        public AnonymousClass1(CaeApplication r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a() {
            lambda$onReceive$0();
        }

        private static /* synthetic */ void lambda$onReceive$0() {
            CommSenseLog.d(CaeApplication.access$000(), "registerLocationListener after 500ms");     // Catch: InterruptedException -> L4
            Thread.sleep(500);     // Catch: InterruptedException -> L4
            LocationUtil.getInstance().registerLocationListener();     // Catch: InterruptedException -> L4
            return;
        L4:
            e = move-exception;
            CommSenseLog.e(CaeApplication.access$000(), "InterruptedException: " + e.getMessage());
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if (r10.getAction() != null) goto L5;
            return;
        L5:
            if ("android.intent.action.PACKAGE_RESTARTED".equals(r10.getAction()) == true) goto L7;
            return;
        L7:
            if (r10.getData() == null) goto L19;
            String r11 = r10.getData().getSchemeSpecificPart();
            if (TextUtils.isEmpty(r11) == false) goto L12;
            return;
        L12:
            if (r11.equals(this.this$0.getPackageName()) == false) goto L18;
            CommSenseLog.d(CaeApplication.access$000(), "onReceive: " + r10.getAction() + ", packageName: " + r11);
            new Thread(new c(), "RegisterLocationListenerThread").start();
            return;
        L18:
            return;
        }
    }

    public CaeApplication() {
    }

    public static /* synthetic */ void a(Context r8) {
        lambda$onCreate$4(r8);
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ void b(Context r8, UserAwareService r10) {
        lambda$onCreate$3(r8, r10);
    }

    public static /* synthetic */ void c(Context r8, UserAwareService r10) {
        lambda$onCreate$2(r8, r10);
    }

    public static /* synthetic */ void d(Context r8, StarLocationService r10) {
        lambda$onCreate$1(r8, r10);
    }

    public static /* synthetic */ void e(Context r8) {
        lambda$onCreate$0(r8);
    }

    private static /* synthetic */ void lambda$onCreate$0(Context r8) {
        CaeLocationManager.getInstance().initOnce(r8);
    }

    private static /* synthetic */ void lambda$onCreate$1(Context r8, StarLocationService r10) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new f(r8, 1));
    }

    private static /* synthetic */ void lambda$onCreate$2(Context r8, UserAwareService r10) {
        CommSenseLog.i(TAG, "UserAwareService ready.");
        Thread.sleep(5000);     // Catch: InterruptedException -> L5
    L7:
        RecordNearbyManager.getInstance().initOnce(r8, r10);
        return;
    L5:
        e = move-exception;
        CommSenseLog.e(TAG, "InterruptedException: " + e.getMessage());
        goto L7
    }

    private static /* synthetic */ void lambda$onCreate$3(Context r8, UserAwareService r10) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new r(11, r8, r10));
    }

    private static /* synthetic */ void lambda$onCreate$4(Context r8) {
        CaeServiceStarter.startCaeServices(r8);
    }

    private void listenPackageRestarted() {
        IntentFilter r8 = new IntentFilter("android.intent.action.PACKAGE_RESTARTED");
        r8.addDataScheme("package");
        registerReceiver(new AnonymousClass1(this), r8);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        CommSenseLog.decryptLog();
        String r8 = TAG;
        CommSenseLog.d(r8, "onCreate");
        Context r10 = getApplicationContext();
        if (CaeUtil.isAppMainProcess(r10) == false) goto L12;
        CommSenseLog.d(r8, "execute main progress operations.");
        ConnectivityAoiController.getInstance().init(this);
        CaeRuntime.registerServiceReadyListener(r10, StarLocationService.class, new a());
        CaeRuntime.registerServiceReadyListener(r10, UserAwareService.class, new b());
        ALogUtil.initAlogAsync(r10);
        int r11 = 2;
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new f(r10, r11));
        if (r10.getResources().getBoolean(R.bool.cae_supported_location_service) == false) goto L7;
        listenPackageRestarted();
    L7:
        boolean r12 = getResources().getBoolean(R.bool.cae_supported_BWDL);
        PackageManager r13 = getPackageManager();
        ComponentName r14 = new ComponentName(this, "com.obric.cae.BWDL.BwdlDrop.activity.BwdlDropLauncherActivity");
        if (r12 == false) goto L10;
        r11 = 1;
    L10:
        r13.setComponentEnabledSetting(r14, r11, 1);
        return;
    }
}
