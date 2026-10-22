package com.obric.cae.libs.useraware;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile f f7013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f7014b;
    public final Context c;
    public final CopyOnWriteArrayList d;
    public final com.obric.cae.libs.utils.e e;
    public final b f;

    public interface a {
        void a();

        void a(f r1);
    }

    public class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f7015a;

        public b(f r1) {
            this.f7015a = r1;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r3, IBinder r4) {
            IBinder r5 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.class, "com.obric.memorydata.plugin");
            Log.i("UserAwareAdapter", "service connected: " + r3.getPackageName());
            monitor-enter(f.class);
            this.f7015a.f7014b = c.a.asInterface(r5);     // Catch: Throwable -> L16
            monitor-exit(f.class);     // Catch: Throwable -> L16
            Iterator r6 = this.f7015a.d.iterator();
        L8:
            if (r6.hasNext() == false) goto L15;
            a r7 = (a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin");
            if (r7 == null) goto L8;
            r7.a(this.f7015a);     // Catch: Exception -> L13
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
        public final void onServiceDisconnected(ComponentName r3) {
            Log.i("UserAwareAdapter", "service disconnected: " + r3.getPackageName());
            monitor-enter(f.class);
            f r2 = this.f7015a;     // Catch: Throwable -> L16
            r2.f7014b = null;     // Catch: Throwable -> L16
            monitor-exit(f.class);     // Catch: Throwable -> L16
            Iterator r4 = r2.d.iterator();
        L8:
            if (r4.hasNext() == false) goto L15;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4.next(), a.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L8;
            r5.a();     // Catch: Exception -> L13
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

    public f(Context r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.d = new CopyOnWriteArrayList();
        b r0 = new b(this);
        this.f = r0;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.c = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        com.obric.cae.libs.utils.e r1 = new com.obric.cae.libs.utils.e(r7, r0, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.e = r1;
        r1.a();
    }

    public f(Context r4, a r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        CopyOnWriteArrayList r0 = new CopyOnWriteArrayList();
        this.d = r0;
        this.f = new b(this);
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
    L13:
        com.obric.cae.libs.utils.e r8 = new com.obric.cae.libs.utils.e(this.c, this.f, "com.obric.cae.libs.useraware.ICaeUserAware", "com.obric.cae.userAware.UserAwareService");
        this.e = r8;
        r8.a();
        return;
    L5:
        if (r0.contains(r7) == true) goto L8;
        r0.add(r7);
    L8:
        if (this.f7014b == null) goto L13;
        r7.a(this);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Log.e("UserAwareAdapter", "Error notifying onServiceConnected immediately", e);
        goto L13
    }

    public static f a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (f7013a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7013a != null) goto L9;
        f7013a = new f(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f7013a;
    }

    public static f a(Context r2, a r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        if (f7013a != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7013a != null) goto L9;
        f7013a = new f(r4, r5);     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f7013a;
    }

    public void a() {
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.clearHomeWifiBssids();     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "clearHomeWifiBssids failed", e);
    }

    public void a(int r2) {
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.notifyGeofenceChanged(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "notifyGeofenceChanged failed", e);
    }

    public void a(int r2, long r3, int r5) {
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.setHarState(r2, r3, r5);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setHarState failed", e);
    }

    public void a(com.obric.cae.libs.bluetooth.a r3) {
        com.obric.cae.libs.bluetooth.a r4 = (com.obric.cae.libs.bluetooth.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.bluetooth.a.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.registerSmartBluetoothEvent(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "registerSmartBluetoothEvent failed", e);
    }

    public void a(HarEventData r2) {
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.notifyHarEvent(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "notifyHarEvent failed", e);
    }

    public void a(HarMonitorParams r2) {
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.setHarMonitorParams(r2);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setHarMonitorParams failed", e);
    }

    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.registerCallback(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "registerCallback failed", e);
    }

    public void a(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.addHomeWifiBssids(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "addHomeWifiBssids failed", e);
    }

    public void a(List<HarLevel2DataReq> r3, int r4, com.obric.cae.libs.useraware.a r5) {
        List<HarLevel2DataReq> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.obric.cae.libs.useraware.a r7 = (com.obric.cae.libs.useraware.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.cae.libs.useraware.a.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.setLevel2DataCollection(r6, r4, r7);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "setLevel2DataCollection failed", e);
    }

    public void b(int r2) {
        c r1 = this.f7014b;
        if (r1 == null) goto L11;
        r1.notifyRoomChangedPredicted(r2);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Log.e("UserAwareAdapter", "Failed to notify room changed predicted", e);
        return;
    }

    public void b(com.obric.cae.libs.bluetooth.a r3) {
        com.obric.cae.libs.bluetooth.a r4 = (com.obric.cae.libs.bluetooth.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.bluetooth.a.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.unregisterSmartBluetoothEvent(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "unregisterSmartBluetoothEvent failed", e);
    }

    public void b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.unregisterCallback(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "unregisterCallback failed", e);
    }

    public void b(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if (b() == true) goto L10;
        return;
    L10:
        this.f7014b.addBssidsToAvoidRomingScan(r4);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("UserAwareAdapter", "addBssidsToAvoidRomingScan failed", e);
    }

    public boolean b() {
        if (this.f7014b != null) goto L6;
        Log.w("UserAwareAdapter", "UserAwareService is not connected.");
        this.e.a();
    L6:
        if (this.f7014b == null) goto L8;
        return true;
    L8:
        return false;
    }
}
