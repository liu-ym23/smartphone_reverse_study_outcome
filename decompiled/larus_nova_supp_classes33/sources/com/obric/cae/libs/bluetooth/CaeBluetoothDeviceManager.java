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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CaeBluetoothDeviceManager {
    public static volatile CaeBluetoothDeviceManager e;
    public final Context a;
    public ICaeBluetoothExporter b;
    public final ArrayList c;
    public final a d;

    public interface CaeBluetoothServiceListener {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public class a implements ServiceConnection {
        public final /* synthetic */ CaeBluetoothDeviceManager a;

        public a(CaeBluetoothDeviceManager r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceDisconnected: " + r3);
            CaeBluetoothDeviceManager r4 = this.a;
            r4.b = null;
            ArrayList r5 = r4.c;
            monitor-enter(r5);
            Iterator r0 = this.a.c.iterator();     // Catch: Throwable -> L10
        L6:
            if (r0.hasNext() == false) goto L8;
            ((CaeBluetoothServiceListener) r0.next()).onServiceDisconnected();     // Catch: Throwable -> L10
            goto L6
        L8:
            monitor-exit(r5);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            LogUtil.d("CaeBluetoothDeviceManager", "onServiceConnected: " + r3);
            this.a.b = ICaeBluetoothExporter.Stub.asInterface(r4);
            ArrayList r5 = this.a.c;
            monitor-enter(r5);
            Iterator r6 = this.a.c.iterator();     // Catch: Throwable -> L10
        L6:
            if (r6.hasNext() == false) goto L8;
            ((CaeBluetoothServiceListener) r6.next()).onServiceConnected();     // Catch: Throwable -> L10
            goto L6
        L8:
            monitor-exit(r5);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public boolean bindService() {
        a r3 = this.d;
        monitor-enter(r3);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.b == null) goto L9;
        LogUtil.d("CaeBluetoothDeviceManager", "Service is already connected.");     // Catch: Throwable -> L26
        monitor-exit(r3);     // Catch: Throwable -> L26
        return true;
    L9:
        LogUtil.d("CaeBluetoothDeviceManager", "Binding cae bluetooth service...");     // Catch: Throwable -> L26
        Intent r6 = new Intent();     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r6.setComponent(new ComponentName("com.obric.cae", "com.obric.cae.smartBluetooth.SmartBluetoothService"));     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        r6.setAction("com.obric.cae.libs.bluetooth.ICaeBluetoothExporter");     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        if (this.a.bindService(r6, this.d, 1) == true) goto L16;
        LogUtil.e("CaeBluetoothDeviceManager", "Fail to bind to: " + r6);     // Catch: Exception -> L18 SecurityException -> L22 Throwable -> L26
        monitor-exit(r3);     // Catch: Throwable -> L26
        return false;
    L16:
        monitor-exit(r3);     // Catch: Throwable -> L26
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

    public void unbindService() {
        a r1 = this.d;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.b == null) goto L12;
        LogUtil.d("CaeBluetoothDeviceManager", "Unbinding cae bluetooth service...");     // Catch: Throwable -> L14
        this.a.unbindService(this.d);     // Catch: Exception -> L9 Throwable -> L14
    L11:
        this.b = null;     // Catch: Throwable -> L14
        goto L12
    L9:
        e = move-exception;
        LogUtil.e("CaeBluetoothDeviceManager", "Exception during unbind: " + e);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
    }

    public CaeBluetoothDeviceManager(Context r2) {
        this.c = new ArrayList();
        this.d = new a(this);
        this.a = r2.getApplicationContext();
    }

    public static CaeBluetoothDeviceManager getInstance(Context r2) {
        if (e != null) goto L15;
        monitor-enter(CaeBluetoothDeviceManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new CaeBluetoothDeviceManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeBluetoothDeviceManager.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public void addServiceListener(CaeBluetoothServiceListener r3) {
        if (r3 == null) goto L15;
        ArrayList r0 = this.c;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L6:
        if (this.c.contains(r3) == true) goto L8;
        this.c.add(r3);     // Catch: Throwable -> L12
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L12
        if (this.b == null) goto L18;
        r3.onServiceConnected();
        return;
    L18:
        return;
    }

    public BtDeviceInfoExtEvent getDeviceType(BluetoothDevice r4) {
        ICaeBluetoothExporter r0 = this.b;
        if (r0 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getDeviceType: Service is not connected");
    L10:
        return new BtDeviceInfoExtEvent(r4, 0);
    L11:
        return r0.getDeviceType(r4);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        goto L10
    }

    public int getProductId(BluetoothDevice r3) {
        ICaeBluetoothExporter r0 = this.b;
        if (r0 != null) goto L11;
        LogUtil.w("CaeBluetoothDeviceManager", "getProductId: Service is not connected");
        return 0;
    L11:
        return r0.getProductId(r3);
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
        return 0;
    }

    public void registerEventCallback(ICaeBluetoothCallbackExporter r3) {
        ICaeBluetoothExporter r0 = this.b;
        if (r0 != null) goto L10;
        LogUtil.w("CaeBluetoothDeviceManager", "registerEventCallback: Service is not connected");
        return;
    L10:
        r0.registerEventCallback(r3);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
    }

    public void removeServiceListener(CaeBluetoothServiceListener r3) {
        if (r3 == null) goto L11;
        ArrayList r0 = this.c;
        monitor-enter(r0);
        this.c.remove(r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void unregisterEventCallback(ICaeBluetoothCallbackExporter r3) {
        ICaeBluetoothExporter r0 = this.b;
        if (r0 != null) goto L10;
        LogUtil.w("CaeBluetoothDeviceManager", "unregisterEventCallback: Service is not connected");
        return;
    L10:
        r0.unregisterEventCallback(r3);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "CaeBluetoothDeviceManager");
    }
}
