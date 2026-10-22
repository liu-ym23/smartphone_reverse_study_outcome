package com.obric.cae.libs.useraware;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import com.obric.cae.libs.utils.SmartBindService;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class UserAwareAdapter {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile UserAwareAdapter f5548f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ICaeUserAware f5549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f5550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList f5551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SmartBindService f5552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f5553e;

    public interface ServiceConnectionListener {
        void onServiceConnected(UserAwareAdapter r8);

        void onServiceDisconnected();
    }

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UserAwareAdapter f5554a;

        public a(UserAwareAdapter r8) {
            this.f5554a = r8;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            Log.i("UserAwareAdapter", "service connected: " + r8.getPackageName());
            monitor-enter(UserAwareAdapter.class);
            this.f5554a.f5549a = ICaeUserAware.Stub.asInterface(r10);     // Catch: Throwable -> L16
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L16
            Iterator r11 = this.f5554a.f5551c.iterator();
        L8:
            if (r11.hasNext() == false) goto L15;
            ServiceConnectionListener r12 = (ServiceConnectionListener) r11.next();
            if (r12 == null) goto L8;
            r12.onServiceConnected(this.f5554a);     // Catch: Exception -> L13
        L13:
            e = move-exception;
            Log.e("UserAwareAdapter", "Error in onServiceConnected callback", e);
            goto L8
        L15:
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            Log.i("UserAwareAdapter", "service disconnected: " + r8.getPackageName());
            monitor-enter(UserAwareAdapter.class);
            UserAwareAdapter r10 = this.f5554a;     // Catch: Throwable -> L16
            r10.f5549a = null;     // Catch: Throwable -> L16
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L16
            Iterator r11 = r10.f5551c.iterator();
        L8:
            if (r11.hasNext() == false) goto L15;
            ServiceConnectionListener r12 = (ServiceConnectionListener) r11.next();
            if (r12 == null) goto L8;
            r12.onServiceDisconnected();     // Catch: Exception -> L13
        L13:
            e = move-exception;
            Log.e("UserAwareAdapter", "Error in onServiceDisconnected callback", e);
            goto L8
        L15:
            return;
        L16:
            th = move-exception;
            throw th;
        }
    }

    public UserAwareAdapter(Context r8) {
        this.f5551c = new CopyOnWriteArrayList();
        a r10 = new a(this);
        this.f5553e = r10;
        Context r11 = r8.getApplicationContext();
        this.f5550b = r11;
        SmartBindService r12 = new SmartBindService(r11, r10, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.f5552d = r12;
        r12.smartBindToService();
    }

    public static UserAwareAdapter getInstance(Context r8) {
        if (f5548f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5548f != null) goto L9;
        f5548f = new UserAwareAdapter(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f5548f;
    }

    public void addBssidsToAvoidRomingScan(List<String> r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.addBssidsToAvoidRomingScan(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "addBssidsToAvoidRomingScan failed", e);
    }

    public void addHomeWifiBssids(List<String> r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.addHomeWifiBssids(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "addHomeWifiBssids failed", e);
    }

    public boolean checkLocationPermission(Context r8) {
        if (r8.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L6;
        Log.i("UserAwareAdapter", "checkLocationPermission passed.");
        return true;
    L6:
        Log.e("UserAwareAdapter", "Critical error: Host application lacks ACCESS_FINE_LOCATION permission! WiFi scanning will not work.");
        throw new SecurityException("Your app must grant ACCESS_FINE_LOCATION permission to use this SDK");
    }

    public void clearHomeWifiBssids() {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.clearHomeWifiBssids();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "clearHomeWifiBssids failed", e);
    }

    public boolean isServiceConnected() {
        if (this.f5549a != null) goto L6;
        Log.w("UserAwareAdapter", "UserAwareService is not connected.");
        this.f5552d.smartBindToService();
    L6:
        if (this.f5549a == null) goto L8;
        return true;
    L8:
        return false;
    }

    public void notifyGeofenceChanged(int r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.notifyGeofenceChanged(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "notifyGeofenceChanged failed", e);
    }

    public void notifyHarEvent(HarEventData r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.notifyHarEvent(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "notifyHarEvent failed", e);
    }

    public void notifyLearningSuccess(boolean r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.notifyLearningSuccess(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "notifyLearningSuccess failed", e);
    }

    public void notifyRoomChangedPredicted(int r8) {
        ICaeUserAware r10 = this.f5549a;
        if (r10 == null) goto L11;
        r10.notifyRoomChangedPredicted(r8);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Log.e("UserAwareAdapter", "Failed to notify room changed predicted", e);
        return;
    }

    public void registerCallback(ICaeUserAwareCallback r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.registerCallback(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "registerCallback failed", e);
    }

    public void registerConnectionListener(ServiceConnectionListener r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.f5551c.contains(r8) == true) goto L10;
        this.f5551c.add(r8);
        if (this.f5549a == null) goto L11;
        r8.onServiceConnected(this);
        return;
    L11:
        return;
    }

    public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.registerSmartBluetoothEvent(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "registerSmartBluetoothEvent failed", e);
    }

    public void release() {
        if (this.f5549a == null) goto L5;
        this.f5550b.unbindService(this.f5553e);
        this.f5549a = null;
        Log.i("UserAwareAdapter", "UserAwareAdapter released and service unbound.");
    L5:
        f5548f = null;
    }

    public void setHarMonitorParams(HarMonitorParams r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.setHarMonitorParams(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setHarMonitorParams failed", e);
    }

    public void setHarState(int r8, long r10, int r11) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.setHarState(r8, r10, r11);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setHarState failed", e);
    }

    public void setLevel2DataCollection(List<HarLevel2DataReq> r8, int r10, HarLevel2DataResp r11) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.setLevel2DataCollection(r8, r10, r11);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setLevel2DataCollection failed", e);
    }

    public void unregisterCallback(ICaeUserAwareCallback r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.unregisterCallback(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "unregisterCallback failed", e);
    }

    public void unregisterConnectionListener(ServiceConnectionListener r8) {
        this.f5551c.remove(r8);
    }

    public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r8) {
        if (isServiceConnected() == true) goto L10;
        return;
    L10:
        this.f5549a.unregisterSmartBluetoothEvent(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "unregisterSmartBluetoothEvent failed", e);
    }

    public UserAwareAdapter(Context r8, ServiceConnectionListener r10) {
        CopyOnWriteArrayList r11 = new CopyOnWriteArrayList();
        this.f5551c = r11;
        this.f5553e = new a(this);
        this.f5550b = r8.getApplicationContext();
        if (r10 != null) goto L5;
    L13:
        SmartBindService r12 = new SmartBindService(this.f5550b, this.f5553e, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.f5552d = r12;
        r12.smartBindToService();
        return;
    L5:
        if (r11.contains(r10) == true) goto L8;
        r11.add(r10);
    L8:
        if (this.f5549a == null) goto L13;
        r10.onServiceConnected(this);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e("UserAwareAdapter", "Error notifying onServiceConnected immediately", e);
        goto L13
    }

    public static UserAwareAdapter getInstance(Context r8, ServiceConnectionListener r10) {
        if (f5548f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5548f != null) goto L9;
        f5548f = new UserAwareAdapter(r8, r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f5548f;
    }
}
