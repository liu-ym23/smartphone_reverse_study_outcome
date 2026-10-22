package com.bytedance.bdlocation_impl.a;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.scan.networklistener.WifiChangeListener;
import com.bytedance.bdlocation.thread.ThreadLooperManager;

/* JADX INFO: loaded from: classes.dex */
public class a implements WifiChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f1899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f1900b;
    private volatile boolean c;
    private RunnableC0107a d;
    private Handler e;
    private volatile long f;

    /* JADX INFO: renamed from: com.bytedance.bdlocation_impl.a.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.bytedance.bdlocation_impl.a.a$a, reason: collision with other inner class name */
    private class RunnableC0107a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f1902b;
        private volatile boolean c;
        private long d;
        private String e;

        private RunnableC0107a(a r3) {
            this.f1901a = r3;
            this.f1902b = 0;
            this.c = true;
            this.d = r3.c();
        }

        /* synthetic */ RunnableC0107a(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        private void a(int r1) {
            LocationUtil.uploadDeviceStatus("bdlocation_upload_internal_polling", r1);
        }

        void a() {
            Logger.i("BDLocation_LocationScheduler_pollupload:onCancel");
            this.c = true;
            a.a(this.f1901a).removeCallbacksAndMessages(null);
        }

        void a(long r2, String r4) {
            this.e = r4;
            this.d = r2;
            Logger.i("BDLocation_LocationScheduler_pollupload resetIntervalMs intervalMs：" + r2);
            a.a(this.f1901a).removeCallbacksAndMessages(null);
            a.a(this.f1901a).postDelayed(this, r2);
        }

        public synchronized void a(String r11) {
            monitor-enter(this);
        L37:
            th = move-exception;
            throw th;
        L4:
            if ((System.currentTimeMillis() - a.f1899a) >= 55000) goto L8;
            Logger.i("BDLocation_UploadScheduleController_pollupload lastUploadTime:" + a.f1899a);     // Catch: Throwable -> L37
            monitor-exit(this);
            return;
        L8:
            a.f1899a = System.currentTimeMillis();     // Catch: Throwable -> L37
            if (BDLocationConfig.isUpload() == true) goto L11;
        L34:
            Logger.i(":---isPollingUpload:" + BDLocationConfig.isPollingUpload());     // Catch: Throwable -> L37
            monitor-exit(this);
            return;
        L11:
            if (BDLocationConfig.isPollingUpload() == false) goto L34;
            if (BDLocationConfig.isRestrictedModeOn() == true) goto L34;
        L30:
            e = move-exception;
            Logger.e("BDLocation_UploadScheduleController_pollupload:" + e.getMessage());     // Catch: Throwable -> L37
        L32:
            monitor-exit(this);
            return;
        L16:
            if (BDLocationConfig.isUploadLocation() == true) goto L20;
            Logger.i("BDLocation_UploadScheduleController_pollupload:uploadDeviceStatus1");     // Catch: Exception -> L30 Throwable -> L37
        L18:
            a(0);     // Catch: Exception -> L30 Throwable -> L37
            goto L32
        L20:
            if (LocationUtil.isLocationEnabled() == true) goto L22;
        L28:
            Logger.i("BDLocation_UploadScheduleController_pollupload:uploadDeviceStatus2 no Permission");     // Catch: Exception -> L30 Throwable -> L37
            goto L18
        L22:
            if (LocationUtil.needLocate() == false) goto L28;
            Logger.i("BDLocation_UploadScheduleController_pollupload:getLocationAsync");     // Catch: Exception -> L30 Throwable -> L37
            if (LocationInfoConst.NETWORK_CHANGE_CERT.equals(r11) == false) goto L26;
            Object r12 = BDLocationConfig.getBpeaCert(LocationInfoConst.NETWORK_CHANGE_CERT);     // Catch: Exception -> L30 Throwable -> L37
            String r0 = "bdlocation_upload_network_change";
        L27:
            com.bytedance.bdlocation_impl.d.a.a(r0, 1, true, 0, 0, null, r12);     // Catch: Exception -> L30 Throwable -> L37
            goto L32
        L26:
            r12 = BDLocationConfig.getBpeaCert(LocationInfoConst.POLL_CERT);     // Catch: Exception -> L30 Throwable -> L37
            r0 = "bdlocation_upload_internal_polling";
            goto L27
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BDLocationConfig.isRestrictedModeOn() == false) goto L5;
        L15:
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask is return");
            a();
            return;
        L5:
            if (LocationUtil.checkBackground() == true) goto L15;
            long r0 = System.currentTimeMillis();
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask intervalMs:" + this.d + "---currentTimeMs:" + r0 + "---lastScheduleTimeMs:" + this.f1902b);
            if ((r0 - this.f1902b) >= this.d) goto L11;
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask is exception");
            a.a(this.f1901a).removeCallbacksAndMessages(null);
        L11:
            if (this.c == true) goto L13;
            a(this.e);
            this.e = "";
            this.f1902b = r0;
        L13:
            this.c = false;
            this.d = this.f1901a.c();
            a.a(this.f1901a).postDelayed(this, this.d);
        }
    }

    static {
    }

    public a() {
        this.c = false;
        this.f = 0;
        this.e = new Handler(ThreadLooperManager.getPollUploadWorker());
        NetworkManager.getInstance().setListener(this);
    }

    static /* synthetic */ Handler a(a r0) {
        return r0.e;
    }

    public static a a() {
        if (f1900b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1900b != null) goto L9;
        f1900b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f1900b;
    }

    private void a(long r1, String r3) {
        RunnableC0107a r0 = this.d;
        if (r0 == null) goto L6;
        r0.a(r1, r3);
        return;
    }

    public static void b() {
        BDLocationConfig.setPollingUpload(false);
        a().e();
    }

    private void c(long r3) {
        if (r3 >= 0) goto L5;
        return;
    L5:
        this.f = r3;
    }

    public synchronized void a(long r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.c == true) goto L9;
        c(r2);     // Catch: Throwable -> L11
        if (this.d != null) goto L8;
        this.d = new RunnableC0107a(this, null);     // Catch: Throwable -> L11
    L8:
        this.e.post(this.d);     // Catch: Throwable -> L11
        this.c = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    public void b(long r4) {
        if (this.c == true) goto L5;
        return;
    L5:
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadSchedule:" + c());
        a(r4, LocationInfoConst.POLL_CERT);
        c(r4);
    }

    public long c() {
        if (this.f != 0) goto L6;
        this.f = BDLocationConfig.getUploadInterval();
    L6:
        return this.f;
    }

    public long d() {
        if (this.f == 0) goto L7;
        return this.f;
    L7:
        return BDLocationConfig.getUploadInterval();
    }

    public synchronized void e() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.d != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.c == false) goto L11;
        c(BDLocationConfig.getUploadInterval());     // Catch: Throwable -> L13
        this.d.a();     // Catch: Throwable -> L13
        this.c = false;     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    public synchronized boolean f() {
        monitor-enter(this);
        boolean r0 = this.c;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void g() {
        if (c() != BDLocationConfig.getNetworkStatusChangeUploadInterval()) goto L5;
        return;
    L5:
        if (this.c == false) goto L14;
        c(BDLocationConfig.getUploadInterval());
        long r0 = System.currentTimeMillis() - f1899a;
        if (r0 < BDLocationConfig.getNetworkStatusChangeUploadInterval()) goto L10;
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadScheduleNetWorkChange:onStart" + c());
        a(100, LocationInfoConst.NETWORK_CHANGE_CERT);
        return;
    L10:
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadScheduleNetWorkChange:resetControllerIntervalMs" + c());
        a(BDLocationConfig.getNetworkStatusChangeUploadInterval() - r0, LocationInfoConst.NETWORK_CHANGE_CERT);
        return;
    }

    @Override // com.bytedance.bdlocation.scan.networklistener.WifiChangeListener
    public void notifyWifiChanged(Network r2, NetworkCapabilities r3) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        if (r3.hasCapability(16) == false) goto L9;
        Logger.i("UploadScheduleController notifyWifiChanged");
        g();
        return;
    }

    @Override // com.bytedance.bdlocation.scan.networklistener.WifiChangeListener
    public void notifyWifiChangedTwo(NetworkInfo r1) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isAvailable() == false) goto L8;
        Logger.i("UploadScheduleController notifyWifiChanged two");
        g();
        return;
    }
}
