package com.obric.cae.libs.multipath;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class CaeMultipathClient {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile CaeMultipathClient f5421e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeMultipathManager f5422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f5423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f5424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5425d;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeMultipathClient f5426a;

        public a(CaeMultipathClient r8, Looper r10) {
            this.f5426a = r8;
            super(r10);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            int r10 = r8.what;
            boolean r11 = true;
            if (r10 != 1) goto L5;
            CaeMultipathClient r12 = this.f5426a;
        L14:
            CaeMultipathClient.a(r12);
            return;
        L5:
            if (r10 != 2) goto L17;
            r12 = this.f5426a;
            if (r12.f5422a != null) goto L11;
            r11 = false;
        L11:
            if (r11 == false) goto L14;
            return;
        }
    }

    public CaeMultipathClient() {
        this.f5425d = false;
        a();
        this.f5424c.sendEmptyMessage(1);
    }

    public static CaeMultipathClient getInstance() {
        if (f5421e != null) goto L15;
        monitor-enter(CaeMultipathClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5421e != null) goto L9;
        f5421e = new CaeMultipathClient();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeMultipathClient.class);     // Catch: Throwable -> L11
    L15:
        return f5421e;
    }

    public final void a() {
        HandlerThread r8 = new HandlerThread("CaeMultipathConnectThread");
        this.f5423b = r8;
        r8.start();
        this.f5424c = new a(this, this.f5423b.getLooper());
    }

    public String getLatestNetworkTruth() {
        ICaeMultipathManager r8 = this.f5422a;
        if (r8 == null) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return null;
    L15:
        return r8.getLatestNetworkTruth();
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to get latest network truth", e);
        return null;
    L5:
        r10 = false;
        goto L7
    }

    public boolean reportAssistantFailure() {
        ICaeMultipathManager r8 = this.f5422a;
        if (r8 == null) goto L5;
        boolean r10 = true;
    L7:
        if (r10 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return false;
    L15:
        r8.reportAssistantFailure();     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to report assistant failure", e);
        return false;
    L5:
        r10 = false;
        goto L7
    }

    public boolean reportAssistantOperateApps(int[] r8) {
        ICaeMultipathManager r10 = this.f5422a;
        if (r10 == null) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == true) goto L15;
        Log.e("CaeMultipathClient", "Service not connected");
        return false;
    L15:
        r10.reportAssistantOperateApps(r8);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to report assistant operate apps", e);
        return false;
    L5:
        r11 = false;
        goto L7
    }

    public static void a(CaeMultipathClient r10) {
        if (r10.f5425d == false) goto L5;
        Log.d("CaeMultipathClient", "Already connecting, skipping");
        return;
    L5:
        r10.f5425d = true;
        IBinder r8 = ServiceManager.getService("cae_multipath");     // Catch: Throwable -> L23 Exception -> L25
        if (r8 != null) goto L31;
        Log.e("CaeMultipathClient", "Failed to get cae_multipath service binder");     // Catch: Throwable -> L23 Exception -> L25
        r10.f5424c.removeMessages(2);     // Catch: Throwable -> L23 Exception -> L25
        a r11 = r10.f5424c;     // Catch: Throwable -> L23 Exception -> L25
    L9:
        r11.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L23 Exception -> L25
    L27:
        r10.f5425d = false;
        return;
    L31:
        int r12 = ICaeMultipathManager.Stub.TRANSACTION_startMultipath;     // Catch: Exception -> L20 Throwable -> L23
        ICaeMultipathManager r13 = (ICaeMultipathManager) ICaeMultipathManager.Stub.class.getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r8});     // Catch: Exception -> L20 Throwable -> L23
        r10.f5422a = r13;     // Catch: Exception -> L20 Throwable -> L23
        if (r13 != null) goto L34;
        Log.e("CaeMultipathClient", "Failed to create service interface");     // Catch: Exception -> L20 Throwable -> L23
        r10.f5424c.removeMessages(2);     // Catch: Exception -> L20 Throwable -> L23
        r10.f5424c.sendEmptyMessageDelayed(2, 5000);     // Catch: Exception -> L20 Throwable -> L23
        goto L27
    L34:
        r8.linkToDeath(new com.obric.cae.libs.multipath.a(r10), 0);     // Catch: RemoteException -> L17 Throwable -> L23 Exception -> L25
    L19:
        Log.d("CaeMultipathClient", "Connected to cae_multipath service");     // Catch: Throwable -> L23 Exception -> L25
    L17:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to link to death", e);     // Catch: Throwable -> L23 Exception -> L25
    L20:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to get Stub class or asInterface method", e);     // Catch: Throwable -> L23 Exception -> L25
        r10.f5424c.removeMessages(2);     // Catch: Throwable -> L23 Exception -> L25
        r11 = r10.f5424c;     // Catch: Throwable -> L23 Exception -> L25
    L25:
        e = move-exception;
        Log.e("CaeMultipathClient", "Failed to connect to cae_multipath service", e);     // Catch: Throwable -> L23
        r10.f5424c.removeMessages(2);     // Catch: Throwable -> L23
        r10.f5424c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        r10.f5425d = false;
        throw th;
    }
}
