package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SmartBindService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServiceConnection f5570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5572d;

    public SmartBindService(Context r8, ServiceConnection r10, String r11, String r12) {
        this.f5569a = r8;
        this.f5570b = r10;
        this.f5571c = r11;
        this.f5572d = r12;
    }

    public void smartBindToService() {
        Context r8 = this.f5569a;
        List<ResolveInfo> r10 = r8.getPackageManager().queryIntentServices(new Intent(this.f5571c), 0);
        if (r10 == null) goto L10;
        Iterator<ResolveInfo> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        String r12 = r11.next().serviceInfo.packageName;
        if (r12.equals(r8.getPackageName()) == true) goto L6;
    L11:
        Log.i("SmartBindService", "findExternalHostPackage: " + r12);
        if (r12 == null) goto L21;
        Intent r13 = new Intent(this.f5571c);
        r13.setPackage(r12);
        Log.i("SmartBindService", "bindToRemoteService: pkg=" + r12 + ", bound=" + this.f5569a.bindService(r13, this.f5570b, 1));     // Catch: Exception -> L16 SecurityException -> L18
    L42:
        return;
    L18:
        e = e;
        String r14 = "bindToRemoteService: Permission denied";
    L20:
        Log.e("SmartBindService", r14, e);
        return;
    L16:
        e = e;
        r14 = "bindToRemoteService: Failed to bind";
        goto L20
    L21:
        String r15 = this.f5572d;
        if (r15 != null) goto L24;
    L31:
        Log.e("SmartBindService", "Local Service Class Name is null or empty, cannot start.");
        return;
    L24:
        if (r15.isEmpty() == true) goto L31;
        ComponentName r16 = new ComponentName(this.f5569a.getPackageName(), this.f5572d);
        Intent r17 = new Intent();
        r17.setComponent(r16);
        r17.setAction(this.f5571c);
        Log.i("SmartBindService", "startAndBindLocalService: bindService called, bound=" + this.f5569a.bindService(r17, this.f5570b, 1));     // Catch: Exception -> L29
        return;
    L29:
        e = move-exception;
        Log.e("SmartBindService", "Failed to start/bind local service: " + this.f5572d, e);
        return;
    L10:
        r12 = null;
        goto L11
    }
}
