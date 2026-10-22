package com.obric.cae.libs.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothCallbackExporter;
import com.obric.cae.libs.bluetooth.exporter.ICaeBluetoothExporter;
import com.obric.cae.libs.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public class CaeBluetoothDeviceManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile CaeBluetoothDeviceManager f5370g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ICaeBluetoothExporter f5372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f5374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f5375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f5376f;

    public interface CaeBluetoothServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeBluetoothDeviceManager f5377a;

        public a(CaeBluetoothDeviceManager r8) {
            this.f5377a = r8;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeBluetoothDeviceManager", "binderDied: CAE service crashed. Attempting to reconnect...");
            CaeBluetoothDeviceManager r8 = this.f5377a;
            if (r8.f5372b == null) goto L5;
            r8.f5372b = null;
        L5:
            ArrayList r10 = r8.f5373c;
            monitor-enter(r10);
            Iterator r11 = this.f5377a.f5373c.iterator();     // Catch: Throwable -> L14
        L9:
            if (r11.hasNext() == false) goto L11;
            ((CaeBluetoothServiceListener) r11.next()).onServiceDisconnected();     // Catch: Throwable -> L14
            goto L9
        L11:
            monitor-exit(r10);     // Catch: Throwable -> L14
            this.f5377a.bindService();
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    public class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeBluetoothDeviceManager f5378a;

        public b(CaeBluetoothDeviceManager r8) {
            this.f5378a = r8;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceConnected: " + r8);
            this.f5378a.f5372b = ICaeBluetoothExporter.Stub.asInterface(r10);
            r10.linkToDeath(this.f5378a.f5375e, 0);     // Catch: RemoteException -> L5
        L7:
            ArrayList r11 = this.f5378a.f5373c;
            monitor-enter(r11);
            Iterator r12 = this.f5378a.f5373c.iterator();     // Catch: Throwable -> L15
        L11:
            if (r12.hasNext() == false) goto L13;
            ((CaeBluetoothServiceListener) r12.next()).onServiceConnected();     // Catch: Throwable -> L15
            goto L11
        L13:
            monitor-exit(r11);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            throw th;
        L5:
            e = move-exception;
            com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "CaeBluetoothDeviceManager");
            goto L7
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceDisconnected: " + r8);
            ICaeBluetoothExporter r10 = CaeBluetoothDeviceManager.a(this.f5378a);
            if (r10 != null) goto L5;
        L10:
            CaeBluetoothDeviceManager.b(this.f5378a);
            ArrayList r11 = CaeBluetoothDeviceManager.e(this.f5378a);
            monitor-enter(r11);
            CaeBluetoothDeviceManager.e(this.f5378a).clear();     // Catch: Throwable -> L25
            monitor-exit(r11);     // Catch: Throwable -> L25
            ArrayList r12 = CaeBluetoothDeviceManager.c(this.f5378a);
            monitor-enter(r12);
            Iterator r13 = CaeBluetoothDeviceManager.c(this.f5378a).iterator();     // Catch: Throwable -> L22
        L18:
            if (r13.hasNext() == false) goto L20;
            ((CaeBluetoothServiceListener) r13.next()).onServiceDisconnected();     // Catch: Throwable -> L22
            goto L18
        L20:
            monitor-exit(r12);     // Catch: Throwable -> L22
            return;
        L22:
            th = move-exception;
            throw th;
        L25:
            th = move-exception;
            throw th;
        L5:
            if (r10.asBinder().isBinderAlive() == false) goto L10;
            r10.asBinder().unlinkToDeath(CaeBluetoothDeviceManager.d(this.f5378a), 0);     // Catch: NoSuchElementException -> L8
        L8:
            e = move-exception;
            LogUtil.w("CaeBluetoothDeviceManager", "Death link does not exist: " + e);
            goto L10
        }
    }

    public CaeBluetoothDeviceManager(Context r8) {
        this.f5373c = new ArrayList();
        this.f5374d = new ArrayList();
        this.f5375e = new a(this);
        this.f5376f = new b(this);
        this.f5371a = r8.getApplicationContext();
    }

    public static /* synthetic */ ICaeBluetoothExporter a(CaeBluetoothDeviceManager r8) {
        return r8.f5372b;
    }

    public static /* synthetic */ void b(CaeBluetoothDeviceManager r8) {
        r8.f5372b = null;
    }

    public static /* synthetic */ ArrayList c(CaeBluetoothDeviceManager r8) {
        return r8.f5373c;
    }

    public static /* synthetic */ a d(CaeBluetoothDeviceManager r8) {
        return r8.f5375e;
    }

    public static /* synthetic */ ArrayList e(CaeBluetoothDeviceManager r8) {
        return r8.f5374d;
    }

    public static CaeBluetoothDeviceManager getInstance(Context r8) {
        if (f5370g != null) goto L15;
        monitor-enter(CaeBluetoothDeviceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5370g != null) goto L9;
        f5370g = new CaeBluetoothDeviceManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeBluetoothDeviceManager.class);     // Catch: Throwable -> L11
    L15:
        return f5370g;
    }

    public void addServiceListener(CaeBluetoothServiceListener r8) {
        if (r8 == null) goto L15;
        ArrayList r10 = this.f5373c;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.f5373c.contains(r8) == true) goto L8;
        this.f5373c.add(r8);     // Catch: Throwable -> L12
    L8:
        monitor-exit(r10);     // Catch: Throwable -> L12
        if (this.f5372b == null) goto L18;
        r8.onServiceConnected();
        return;
    L18:
        return;
    }

    public boolean bindService() {
        b r8 = this.f5376f;
        monitor-enter(r8);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.f5372b == null) goto L9;
        LogUtil.d("CaeBluetoothDeviceManager", "Service is already connected.");     // Catch: Throwable -> L26
        monitor-exit(r8);     // Catch: Throwable -> L26
        return true;
    L9:
        LogUtil.d("CaeBluetoothDeviceManager", "Binding cae bluetooth service...");     // Catch: Throwable -> L26
        Intent r10 = new Intent();     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r10.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartBluetooth.SmartBluetoothService"));     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r10.setAction("com.obric.cae.libs.bluetooth.ICaeBluetoothExporter");     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        if (this.f5371a.bindService(r10, this.f5376f, 1) == true) goto L16;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + r10);     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        monitor-exit(r8);     // Catch: Throwable -> L26
        return false;
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L26
        return true;
    L22:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + e);     // Catch: Throwable -> L26
        return false;
    L18:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception: " + e);     // Catch: Throwable -> L26
        return false;
    }

    public boolean disableBle() {
        if (this.f5372b != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "disableBle: Service is not connected");
        return false;
    L11:
        LogUtil.d("CaeBluetoothDeviceManager", "disableBle: Requesting BLE-only mode off");     // Catch: RemoteException -> L6
        return this.f5372b.disableBle();
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return false;
    }

    public boolean enableBle() {
        if (this.f5372b != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "enableBle: Service is not connected");
        return false;
    L11:
        LogUtil.d("CaeBluetoothDeviceManager", "enableBle: Requesting BLE-only mode");     // Catch: RemoteException -> L6
        return this.f5372b.enableBle();
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return false;
    }

    public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r8) {
        ICaeBluetoothExporter r10 = this.f5372b;
        if (r10 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getDeviceType: Service is not connected");
    L10:
        return new BtDeviceInfoExtEvent(r8, 0);
    L11:
        return r10.getDeviceType(r8);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        goto L10
    }

    public int getProductId(BluetoothDevice r8) {
        ICaeBluetoothExporter r10 = this.f5372b;
        if (r10 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getProductId: Service is not connected");
        return 0;
    L11:
        return r10.getProductId(r8);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return 0;
    }

    public boolean isAbsoluteVolumeSupported(BluetoothDevice r8) {
        ICaeBluetoothExporter r10 = this.f5372b;
        if (r10 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "isAbsoluteVolumeSupported: Service is not connected");
        return false;
    L11:
        return r10.isAbsoluteVolumeSupported(r8);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return false;
    }

    public void registerEventCallback(ICaeBluetoothCallbackExporter r8) {
        if (r8 == null) goto L21;
        ArrayList r10 = this.f5374d;
        monitor-enter(r10);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.f5374d.contains(r8) == true) goto L15;
        this.f5374d.add(r8);     // Catch: Throwable -> L18
        ICaeBluetoothExporter r11 = this.f5372b;     // Catch: Throwable -> L18
        if (r11 != null) goto L24;
        LogUtil.w("CaeBluetoothDeviceManager", "registerEventCallback: Service is not connected");     // Catch: Throwable -> L18
    L16:
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L24:
        r11.registerEventCallback(r8);     // Catch: RemoteException -> L12 Throwable -> L18
    L12:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "RemoteException: " + e);     // Catch: Throwable -> L18
        goto L16
    L15:
        LogUtil.d("CaeBluetoothDeviceManager", "registerEventCallback: Callback already registered, ignoring.");     // Catch: Throwable -> L18
        goto L16
    }

    public void removeServiceListener(CaeBluetoothServiceListener r8) {
        if (r8 == null) goto L11;
        ArrayList r10 = this.f5373c;
        monitor-enter(r10);
        this.f5373c.remove(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unbindService() {
        b r8 = this.f5376f;
        monitor-enter(r8);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.f5372b == null) goto L12;
        LogUtil.d("CaeBluetoothDeviceManager", "Unbinding cae bluetooth service...");     // Catch: Throwable -> L14
        this.f5371a.unbindService(this.f5376f);     // Catch: Exception -> L9 Throwable -> L14
    L11:
        this.f5372b = null;     // Catch: Throwable -> L14
        goto L12
    L9:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception during unbind: " + e);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r8);     // Catch: Throwable -> L14
    }

    public void unregisterEventCallback(ICaeBluetoothCallbackExporter r8) {
        if (r8 == null) goto L11;
        ArrayList r10 = this.f5374d;
        monitor-enter(r10);
        this.f5374d.remove(r8);     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    L11:
        ICaeBluetoothExporter r11 = this.f5372b;
        if (r11 != null) goto L21;
        LogUtil.w("CaeBluetoothDeviceManager", "unregisterEventCallback: Service is not connected");
        return;
    L21:
        r11.unregisterEventCallback(r8);     // Catch: RemoteException -> L15
        return;
    L15:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
    }
}
