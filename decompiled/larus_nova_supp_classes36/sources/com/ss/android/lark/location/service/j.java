package com.ss.android.lark.location.service;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements LocationListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ List<LocationListener> b;
    public final /* synthetic */ Job c;
    public final /* synthetic */ WeakReference<c> d;

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location r22) {
        ArrayList r10 = new ArrayList();
        boolean r13 = false;
        Object[] r12 = {r22};
        f06.b r14 = new f06.b();
        g06.a r0 = (g06.a) ApiHookConfig.b.get(100038);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r7 = r1;
        int r6 = r7.length;
        int r5 = 0;
    L8:
        if (r5 >= r6) goto L15;
        f06.a r3 = r7[r5];
        int r18 = r5;
        int r19 = r6;
        f06.a[] r20 = r7;
        f06.d r2 = r3.preInvoke(100038, "com/ss/android/lark/location/service/LocationManagerWithTimeout$getLocationListener$1", "onLocationChanged", this, r12, "void", r14);     // Catch: Exception -> L35
        if (r2.a == true) goto L12;
        r10.add(r3);     // Catch: Exception -> L35
        goto L14
    L12:
        CancellationException r4 = null;
    L17:
        if (r2.a == false) goto L19;
        return;
    L19:
        Intrinsics.checkNotNullParameter(r22, "location");
        Log.i("LocationManager.WithTimeout", "LocationManager onLocationChanged called, isContinuous = " + this.a);
        if (this.a == true) goto L28;
        LocationManagerWithTimeout r8 = LocationManagerWithTimeout.a;
        LocationManagerWithTimeout.b(this.b);
        Job r9 = this.c;
        if (r9 != null) goto L24;
    L26:
        if (r13 == false) goto L28;
        return;
    L24:
        if (r9.isActive() == true) goto L26;
        r13 = true;
    L28:
        Job r11 = this.c;
        if (r11 == null) goto L31;
        Job.DefaultImpls.cancel$default(r11, r4, 1, r4);
    L31:
        c r15 = this.d.get();
        if (r15 == null) goto L41;
        r15.a();
        return;
    L41:
        return;
    L14:
        r5 = r18 + 1;
        r6 = r19;
        r7 = r20;
        goto L8
    L15:
        r4 = null;
        r2 = new f06.d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p");
        Log.i("LocationManager.WithTimeout", "onProviderDisabled called. provider:" + r3);
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p");
        Log.i("LocationManager.WithTimeout", "onProviderEnabled called. provider:" + r3);
    }

    public j(List r2, Job r3, WeakReference r4) {
        this.a = false;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.location.LocationListener
    public final void onStatusChanged(String r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "p");
        Intrinsics.checkNotNullParameter(r5, "extras");
        Log.i("LocationManager.WithTimeout", "onStatusChanged called. provider:" + r3 + ", status:" + r4 + ", extras:" + r5);
    }
}
