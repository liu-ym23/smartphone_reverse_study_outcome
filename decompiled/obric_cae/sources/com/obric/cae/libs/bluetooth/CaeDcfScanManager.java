package com.obric.cae.libs.bluetooth;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter;
import com.obric.cae.libs.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CaeDcfScanManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile CaeDcfScanManager f5379g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICaeDcfScanExporter f5381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f5384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f5385f;

    public interface CaeDcfScanServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeDcfScanManager f5386a;

        public a(CaeDcfScanManager r8) {
            this.f5386a = r8;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeDcfScanManager", "binderDied: CAE service crashed. Attempting to reconnect...");
            if (CaeDcfScanManager.a(this.f5386a) == null) goto L5;
            CaeDcfScanManager.a(this.f5386a).asBinder().unlinkToDeath(CaeDcfScanManager.c(this.f5386a), 0);
            CaeDcfScanManager.b(this.f5386a);
        L5:
            ArrayList r8 = CaeDcfScanManager.d(this.f5386a);
            monitor-enter(r8);
            Iterator r10 = CaeDcfScanManager.d(this.f5386a).iterator();     // Catch: Throwable -> L14
        L9:
            if (r10.hasNext() == false) goto L11;
            ((CaeDcfScanServiceListener) r10.next()).onServiceDisconnected();     // Catch: Throwable -> L14
            goto L9
        L11:
            monitor-exit(r8);     // Catch: Throwable -> L14
            this.f5386a.bindService();
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    public class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeDcfScanManager f5387a;

        public b(CaeDcfScanManager r8) {
            this.f5387a = r8;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            LogUtil.d("CaeDcfScanManager", "onServiceConnected: " + r8);
            this.f5387a.f5381b = ICaeDcfScanExporter.Stub.asInterface(r10);
            r10.linkToDeath(this.f5387a.f5384e, 0);     // Catch: RemoteException -> L5
        L7:
            ArrayList r11 = this.f5387a.f5383d;
            monitor-enter(r11);
            Iterator r12 = this.f5387a.f5383d.iterator();     // Catch: Throwable -> L29
        L11:
            if (r12.hasNext() == false) goto L17;
            this.f5387a.f5381b.registerDcfScanCallback((ICaeDcfScanCallbackExporter) r12.next());     // Catch: RemoteException -> L15 Throwable -> L29
        L15:
            e = move-exception;
            LogUtil.e("CaeDcfScanManager", "re-register callback failed: " + e);     // Catch: Throwable -> L29
            goto L11
        L17:
            monitor-exit(r11);     // Catch: Throwable -> L29
            ArrayList r13 = this.f5387a.f5382c;
            monitor-enter(r13);
            Iterator r14 = this.f5387a.f5382c.iterator();     // Catch: Throwable -> L26
        L22:
            if (r14.hasNext() == false) goto L24;
            ((CaeDcfScanServiceListener) r14.next()).onServiceConnected();     // Catch: Throwable -> L26
            goto L22
        L24:
            monitor-exit(r13);     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            throw th;
        L29:
            th = move-exception;
            throw th;
        L5:
            e = move-exception;
            com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "CaeDcfScanManager");
            goto L7
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            LogUtil.d("CaeDcfScanManager", "onServiceDisconnected: " + r8);
            if (CaeDcfScanManager.a(this.f5387a) == null) goto L5;
            CaeDcfScanManager.a(this.f5387a).asBinder().unlinkToDeath(CaeDcfScanManager.c(this.f5387a), 0);
        L5:
            CaeDcfScanManager.b(this.f5387a);
            ArrayList r10 = CaeDcfScanManager.d(this.f5387a);
            monitor-enter(r10);
            Iterator r11 = CaeDcfScanManager.d(this.f5387a).iterator();     // Catch: Throwable -> L13
        L9:
            if (r11.hasNext() == false) goto L11;
            ((CaeDcfScanServiceListener) r11.next()).onServiceDisconnected();     // Catch: Throwable -> L13
            goto L9
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }
    }

    public CaeDcfScanManager(Context r8) {
        this.f5382c = new ArrayList();
        this.f5383d = new ArrayList();
        this.f5384e = new a(this);
        this.f5385f = new b(this);
        this.f5380a = r8.getApplicationContext();
    }

    public static /* synthetic */ ICaeDcfScanExporter a(CaeDcfScanManager r8) {
        return r8.f5381b;
    }

    public static /* synthetic */ void b(CaeDcfScanManager r8) {
        r8.f5381b = null;
    }

    public static /* synthetic */ a c(CaeDcfScanManager r8) {
        return r8.f5384e;
    }

    public static /* synthetic */ ArrayList d(CaeDcfScanManager r8) {
        return r8.f5382c;
    }

    public static CaeDcfScanManager getInstance(Context r8) {
        if (f5379g != null) goto L15;
        monitor-enter(CaeDcfScanManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5379g != null) goto L9;
        f5379g = new CaeDcfScanManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeDcfScanManager.class);     // Catch: Throwable -> L11
    L15:
        return f5379g;
    }

    public void addServiceListener(CaeDcfScanServiceListener r8) {
        if (r8 == null) goto L15;
        ArrayList r10 = this.f5382c;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.f5382c.contains(r8) == true) goto L8;
        this.f5382c.add(r8);     // Catch: Throwable -> L12
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (this.f5381b == null) goto L18;
        r8.onServiceConnected();
        return;
    L18:
        return;
    }

    public boolean bindService() {
        b r8 = this.f5385f;
        monitor-enter(r8);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.f5381b == null) goto L9;
        LogUtil.d("CaeDcfScanManager", "Service is already connected.");     // Catch: Throwable -> L26
        monitor-exit(r8);     // Catch: Throwable -> L26
        return true;
    L9:
        LogUtil.d("CaeDcfScanManager", "Binding cae dcf scan service...");     // Catch: Throwable -> L26
        Intent r10 = new Intent();     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r10.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartBluetooth.dcf.CaeDcfScanService"));     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r10.setAction("com.obric.cae.libs.bluetooth.exporter.ICaeDcfScanExporter");     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        if (this.f5380a.bindService(r10, this.f5385f, 1) == true) goto L16;
        LogUtil.e("CaeDcfScanManager", "Fail to bind to: " + r10);     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        monitor-exit(r8);     // Catch: Throwable -> L26
        return false;
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L26
        return true;
    L22:
        e = move-exception;
        LogUtil.e("CaeDcfScanManager", "Fail to bind to: " + e);     // Catch: Throwable -> L26
        return false;
    L18:
        e = move-exception;
        LogUtil.e("CaeDcfScanManager", "Exception: " + e);     // Catch: Throwable -> L26
        return false;
    }

    public boolean isDcfScanSupported() {
        ICaeDcfScanExporter r8 = this.f5381b;
        if (r8 != null) goto L11;
        LogUtil.w("CaeDcfScanManager", "isDcfScanSupported: Service is not connected");
        return false;
    L11:
        return r8.isDcfScanSupported();
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeDcfScanManager");
        return false;
    }

    public void registerDcfScanCallback(ICaeDcfScanCallbackExporter r8) {
        if (r8 == null) goto L21;
        ArrayList r10 = this.f5383d;
        monitor-enter(r10);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.f5383d.contains(r8) == true) goto L15;
        this.f5383d.add(r8);     // Catch: Throwable -> L18
        ICaeDcfScanExporter r11 = this.f5381b;     // Catch: Throwable -> L18
        if (r11 != null) goto L24;
        LogUtil.w("CaeDcfScanManager", "registerDcfScanCallback: Service is not connected");     // Catch: Throwable -> L18
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L24:
        r11.registerDcfScanCallback(r8);     // Catch: RemoteException -> L12 Throwable -> L18
    L12:
        e = move-exception;
        LogUtil.e("CaeDcfScanManager", "RemoteException: " + e);     // Catch: Throwable -> L18
        goto L16
    L15:
        LogUtil.d("CaeDcfScanManager", "registerDcfScanCallback: Callback already registered, ignoring.");     // Catch: Throwable -> L18
        goto L16
    }

    public void removeServiceListener(CaeDcfScanServiceListener r8) {
        if (r8 == null) goto L11;
        ArrayList r10 = this.f5382c;
        monitor-enter(r10);
        this.f5382c.remove(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unbindService() {
        b r8 = this.f5385f;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f5381b == null) goto L12;
        LogUtil.d("CaeDcfScanManager", "Unbinding cae dcf scan service...");     // Catch: Throwable -> L14
        this.f5380a.unbindService(this.f5385f);     // Catch: Exception -> L9 Throwable -> L14
    L11:
        this.f5381b = null;     // Catch: Throwable -> L14
        goto L12
    L9:
        e = move-exception;
        LogUtil.e("CaeDcfScanManager", "Exception during unbind: " + e);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
    }

    public void unregisterDcfScanCallback(ICaeDcfScanCallbackExporter r8) {
        if (r8 == null) goto L11;
        ArrayList r10 = this.f5383d;
        monitor-enter(r10);
        this.f5383d.remove(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        ICaeDcfScanExporter r11 = this.f5381b;
        if (r11 != null) goto L21;
        LogUtil.w("CaeDcfScanManager", "unregisterDcfScanCallback: Service is not connected");
        return;
    L21:
        r11.unregisterDcfScanCallback(r8);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeDcfScanManager");
    }
}
