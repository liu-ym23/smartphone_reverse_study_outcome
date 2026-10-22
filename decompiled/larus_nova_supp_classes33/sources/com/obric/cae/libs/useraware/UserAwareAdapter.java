package com.obric.cae.libs.useraware;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.obric.cae.libs.bluetooth.ISmartBluetoothEventCallback;
import com.obric.cae.libs.utils.SmartBindService;
import f06.b;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class UserAwareAdapter {
    public static final int ENTER_COMPANY_GEOFENCE_EVENT = 3;
    public static final int ENTER_HOME_GEOFENCE_EVENT = 1;
    public static final int EXIT_COMPANY_GEOFENCE_EVENT = 4;
    public static final int EXIT_HOEM_GEOFENCE_EVENT = 2;
    public static final int PREDICTED_ENTER_ROOM_EVENT = 1;
    public static final int PREDICTED_EXIT_ROOM_EVENT = 2;
    public static volatile UserAwareAdapter f;
    public ICaeUserAware a;
    public final Context b;
    public final CopyOnWriteArrayList c;
    public final SmartBindService d;
    public final a e;

    public interface ServiceConnectionListener {
        void onServiceConnected(UserAwareAdapter r1);

        void onServiceDisconnected();
    }

    public class a implements ServiceConnection {
        public final /* synthetic */ UserAwareAdapter a;

        public a(UserAwareAdapter r1) {
            this.a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r3) {
            r3.getPackageName();
            monitor-enter(UserAwareAdapter.class);
            UserAwareAdapter r0 = this.a;     // Catch: Throwable -> L15
            r0.a = null;     // Catch: Throwable -> L15
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L15
            Iterator r4 = r0.c.iterator();
        L8:
            if (r4.hasNext() == false) goto L14;
            ServiceConnectionListener r1 = (ServiceConnectionListener) r4.next();
            if (r1 == null) goto L8;
            r1.onServiceDisconnected();     // Catch: Exception -> L13
            goto L8
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r2, IBinder r3) {
            r2.getPackageName();
            monitor-enter(UserAwareAdapter.class);
            UserAwareAdapter r0 = this.a;     // Catch: Throwable -> L15
            r0.a = ICaeUserAware.Stub.asInterface(r3);     // Catch: Throwable -> L15
            monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L15
            Iterator r4 = this.a.c.iterator();
        L8:
            if (r4.hasNext() == false) goto L14;
            ServiceConnectionListener r5 = (ServiceConnectionListener) r4.next();
            if (r5 == null) goto L8;
            r5.onServiceConnected(this.a);     // Catch: Exception -> L13
            goto L8
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }
    }

    public boolean isServiceConnected() {
        if (this.a != null) goto L6;
        this.d.smartBindToService();
    L6:
        if (this.a == null) goto L8;
        return true;
    L8:
        return false;
    }

    public void release() {
        if (this.a == null) goto L5;
        this.b.unbindService(this.e);
        this.a = null;
    L5:
        f = null;
    }

    public void clearHomeWifiBssids() {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.clearHomeWifiBssids();     // Catch: RemoteException -> L7
        return;
    }

    public UserAwareAdapter(Context r5) {
        this.c = new CopyOnWriteArrayList();
        a r0 = new a(this);
        this.e = r0;
        Context r6 = r5.getApplicationContext();
        this.b = r6;
        SmartBindService r1 = new SmartBindService(r6, r0, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.d = r1;
        r1.smartBindToService();
    }

    public static UserAwareAdapter getInstance(Context r2) {
        if (f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new UserAwareAdapter(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public void addBssidsToAvoidRomingScan(List<String> r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.addBssidsToAvoidRomingScan(r2);     // Catch: RemoteException -> L7
        return;
    }

    public void addHomeWifiBssids(List<String> r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.addHomeWifiBssids(r2);     // Catch: RemoteException -> L7
        return;
    }

    public boolean checkLocationPermission(Context r2) {
        if (com_obric_cae_libs_useraware_UserAwareAdapter_android_content_Context_checkSelfPermission(r2, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L7;
        return true;
    L7:
        throw new SecurityException("Your app must grant ACCESS_FINE_LOCATION permission to use this SDK");
    }

    public void notifyGeofenceChanged(int r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.notifyGeofenceChanged(r2);     // Catch: RemoteException -> L7
        return;
    }

    public void notifyHarEvent(HarEventData r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.notifyHarEvent(r2);     // Catch: RemoteException -> L7
        return;
    }

    public void notifyLearningSuccess(boolean r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.notifyLearningSuccess(r2);     // Catch: RemoteException -> L7
        return;
    }

    public void notifyRoomChangedPredicted(int r2) {
        ICaeUserAware r0 = this.a;
        if (r0 == null) goto L9;
        r0.notifyRoomChangedPredicted(r2);     // Catch: RemoteException -> L6
        return;
    L10:
        return;
    }

    public void registerCallback(ICaeUserAwareCallback r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.registerCallback(r2);     // Catch: RemoteException -> L7
        return;
    }

    public void registerConnectionListener(ServiceConnectionListener r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.c.contains(r2) == true) goto L10;
        this.c.add(r2);
        if (this.a == null) goto L11;
        r2.onServiceConnected(this);
        return;
    L11:
        return;
    }

    public void registerSmartBluetoothEvent(ISmartBluetoothEventCallback r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.registerSmartBluetoothEvent(r2);     // Catch: RemoteException -> L7
        return;
    }

    public void setHarMonitorParams(HarMonitorParams r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.setHarMonitorParams(r2);     // Catch: RemoteException -> L7
        return;
    }

    public void unregisterCallback(ICaeUserAwareCallback r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.unregisterCallback(r2);     // Catch: RemoteException -> L7
        return;
    }

    public void unregisterConnectionListener(ServiceConnectionListener r2) {
        this.c.remove(r2);
    }

    public void unregisterSmartBluetoothEvent(ISmartBluetoothEventCallback r2) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.unregisterSmartBluetoothEvent(r2);     // Catch: RemoteException -> L7
        return;
    }

    public UserAwareAdapter(Context r4, ServiceConnectionListener r5) {
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        this.c = r0;
        this.e = new a(this);
        this.b = r4.getApplicationContext();
        if (r5 != null) goto L5;
    L10:
        SmartBindService r6 = new SmartBindService(this.b, this.e, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.d = r6;
        r6.smartBindToService();
        return;
    L5:
        if (r0.contains(r5) == true) goto L8;
        r0.add(r5);
    L8:
        if (this.a == null) goto L10;
        r5.onServiceConnected(this);     // Catch: Exception -> L12
        goto L10
    }

    private static int com_obric_cae_libs_useraware_UserAwareAdapter_android_content_Context_checkSelfPermission(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b("auto_cert_com_obric_cae_libs_useraware_UserAwareAdapter_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static UserAwareAdapter getInstance(Context r2, ServiceConnectionListener r3) {
        if (f != null) goto L15;
        monitor-enter(UserAwareAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f != null) goto L9;
        f = new UserAwareAdapter(r2, r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(UserAwareAdapter.class);     // Catch: Throwable -> L11
    L15:
        return f;
    }

    public void setHarState(int r2, long r3, int r5) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.setHarState(r2, r3, r5);     // Catch: RemoteException -> L7
        return;
    }

    public void setLevel2DataCollection(List<HarLevel2DataReq> r2, int r3, HarLevel2DataResp r4) {
        if (isServiceConnected() == true) goto L8;
        return;
    L8:
        this.a.setLevel2DataCollection(r2, r3, r4);     // Catch: RemoteException -> L7
        return;
    }
}
