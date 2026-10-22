package m5;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Handler;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.scan.networklistener.NetworkManager;
import com.bytedance.bdlocation.scan.networklistener.WifiChangeListener;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import defpackage.c;

/* JADX INFO: loaded from: classes.dex */
public final class a implements WifiChangeListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f9270e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f9271f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f9272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RunnableC0114a f9273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f9274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile long f9275d;

    /* JADX INFO: renamed from: m5.a$a, reason: collision with other inner class name */
    public class RunnableC0114a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f9277b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f9278m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f9279n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ a f9280o;

        public RunnableC0114a(a r8) {
            this.f9280o = r8;
            this.f9276a = 0;
            this.f9277b = true;
            this.f9278m = r8.b();
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (BDLocationConfig.isRestrictedModeOn() == false) goto L5;
        L51:
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask is return");
            Logger.i("BDLocation_LocationScheduler_pollupload:onCancel");
            this.f9277b = true;
            this.f9280o.f9274c.removeCallbacksAndMessages(null);
            return;
        L5:
            if (LocationUtil.checkBackground() == true) goto L51;
            long r8 = System.currentTimeMillis();
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask intervalMs:" + this.f9278m + "---currentTimeMs:" + r8 + "---lastScheduleTimeMs:" + this.f9276a);
            if ((r8 - this.f9276a) >= this.f9278m) goto L11;
            Logger.i("BDLocation_LocationScheduler_pollupload:ControllerTask is exception");
            this.f9280o.f9274c.removeCallbacksAndMessages(null);
        L11:
            if (this.f9277b == true) goto L49;
            String r10 = this.f9279n;
            monitor-enter(this);
        L46:
            th = move-exception;
            throw th;
        L15:
            if ((System.currentTimeMillis() - a.f9271f) >= 55000) goto L18;
            StringBuilder r11 = new StringBuilder("BDLocation_UploadScheduleController_pollupload lastUploadTime:");     // Catch: Throwable -> L46
            r11.append(a.f9271f);     // Catch: Throwable -> L46
        L43:
            Logger.i(r11.toString());     // Catch: Throwable -> L46
        L44:
            monitor-exit(this);
            this.f9279n = "";
            this.f9276a = r8;
            goto L49
        L18:
            a.f9271f = System.currentTimeMillis();     // Catch: Throwable -> L46
            if (BDLocationConfig.isUpload() == true) goto L21;
        L42:
            r11 = new StringBuilder(":---isPollingUpload:");     // Catch: Throwable -> L46
            r11.append(BDLocationConfig.isPollingUpload());     // Catch: Throwable -> L46
            goto L43
        L21:
            if (BDLocationConfig.isPollingUpload() == false) goto L42;
            if (BDLocationConfig.isRestrictedModeOn() == true) goto L42;
        L40:
            e = move-exception;
            Logger.e("BDLocation_UploadScheduleController_pollupload:" + e.getMessage());     // Catch: Throwable -> L46
            goto L44
        L26:
            if (BDLocationConfig.isUploadLocation() == true) goto L29;
            String r12 = "BDLocation_UploadScheduleController_pollupload:uploadDeviceStatus1";
        L38:
            Logger.i(r12);     // Catch: Exception -> L40 Throwable -> L46
            LocationUtil.uploadDeviceStatus("bdlocation_upload_internal_polling", 0);     // Catch: Exception -> L40 Throwable -> L46
            goto L44
        L29:
            if (LocationUtil.isLocationEnabled() == true) goto L31;
        L37:
            r12 = "BDLocation_UploadScheduleController_pollupload:uploadDeviceStatus2 no Permission";
            goto L38
        L31:
            if (LocationUtil.needLocate() == false) goto L37;
            Logger.i("BDLocation_UploadScheduleController_pollupload:getLocationAsync");     // Catch: Exception -> L40 Throwable -> L46
            if (LocationInfoConst.NETWORK_CHANGE_CERT.equals(r10) == false) goto L35;
            Object r13 = BDLocationConfig.getBpeaCert(LocationInfoConst.NETWORK_CHANGE_CERT);     // Catch: Exception -> L40 Throwable -> L46
            String r14 = "bdlocation_upload_network_change";
        L36:
            c.L(r14, r13);     // Catch: Exception -> L40 Throwable -> L46
            goto L44
        L35:
            r13 = BDLocationConfig.getBpeaCert(LocationInfoConst.POLL_CERT);     // Catch: Exception -> L40 Throwable -> L46
            r14 = "bdlocation_upload_internal_polling";
        L49:
            this.f9277b = false;
            long r15 = this.f9280o.b();
            this.f9278m = r15;
            this.f9280o.f9274c.postDelayed(this, r15);
        }
    }

    public a() {
        this.f9272a = false;
        this.f9275d = 0;
        this.f9274c = new Handler(ThreadLooperManager.getPollUploadWorker());
        NetworkManager.getInstance().setListener(this);
    }

    public static a a() {
        if (f9270e != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9270e != null) goto L9;
        f9270e = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f9270e;
    }

    public final long b() {
        if (this.f9275d != 0) goto L6;
        this.f9275d = BDLocationConfig.getUploadInterval();
    L6:
        return this.f9275d;
    }

    public final void c(long r8, String r10) {
        RunnableC0114a r11 = this.f9273b;
        if (r11 == null) goto L6;
        r11.f9279n = r10;
        r11.f9278m = r8;
        Logger.i("BDLocation_LocationScheduler_pollupload resetIntervalMs intervalMs：" + r8);
        a r12 = r11.f9280o;
        r12.f9274c.removeCallbacksAndMessages(null);
        r12.f9274c.postDelayed(r11, r8);
        return;
    }

    public final void d() {
        if (b() != BDLocationConfig.getNetworkStatusChangeUploadInterval()) goto L5;
        return;
    L5:
        if (this.f9272a == false) goto L18;
        long r8 = BDLocationConfig.getUploadInterval();
        if (r8 < 0) goto L11;
        this.f9275d = r8;
    L11:
        long r10 = System.currentTimeMillis() - f9271f;
        if (r10 < BDLocationConfig.getNetworkStatusChangeUploadInterval()) goto L14;
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadScheduleNetWorkChange:onStart" + b());
        c(100, LocationInfoConst.NETWORK_CHANGE_CERT);
        return;
    L14:
        Logger.i("BDLocation_UploadScheduleController_pollupload resetPollUploadScheduleNetWorkChange:resetControllerIntervalMs" + b());
        c(BDLocationConfig.getNetworkStatusChangeUploadInterval() - r10, LocationInfoConst.NETWORK_CHANGE_CERT);
        return;
    }

    public final synchronized void e() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f9273b != null) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.f9272a == false) goto L15;
        long r8 = BDLocationConfig.getUploadInterval();     // Catch: Throwable -> L17
        if (r8 < 0) goto L12;
        this.f9275d = r8;     // Catch: Throwable -> L17
    L12:
        RunnableC0114a r10 = this.f9273b;     // Catch: Throwable -> L17
        r10.getClass();     // Catch: Throwable -> L17
        Logger.i("BDLocation_LocationScheduler_pollupload:onCancel");     // Catch: Throwable -> L17
        r10.f9277b = true;     // Catch: Throwable -> L17
        r10.f9280o.f9274c.removeCallbacksAndMessages(null);     // Catch: Throwable -> L17
        this.f9272a = false;     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    @Override // com.bytedance.bdlocation.scan.networklistener.WifiChangeListener
    public final void notifyWifiChanged(Network r8, NetworkCapabilities r10) {
        if (r10.hasCapability(16) == false) goto L6;
        Logger.i("UploadScheduleController notifyWifiChanged");
        d();
        return;
    }

    @Override // com.bytedance.bdlocation.scan.networklistener.WifiChangeListener
    public final void notifyWifiChangedTwo(NetworkInfo r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isAvailable() == false) goto L8;
        Logger.i("UploadScheduleController notifyWifiChanged two");
        d();
        return;
    }
}
