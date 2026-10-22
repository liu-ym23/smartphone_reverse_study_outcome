package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ServiceConnection f7018b;
    public final String c;
    public final String d;

    public e(Context r3, ServiceConnection r4, String r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ServiceConnection r8 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.memorydata.plugin");
        this.f7017a = ZeusTransformUtils.wrapperContext(r7, "com.obric.memorydata.plugin");
        this.f7018b = r8;
        this.c = r5;
        this.d = r6;
    }

    public void a() {
        Context r0 = this.f7017a;
        List<ResolveInfo> r1 = r0.getPackageManager().queryIntentServices(new Intent(this.c), 0);
        if (r1 == null) goto L10;
        Iterator<ResolveInfo> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = ((ResolveInfo) ZeusTransformUtils.preCheckCast(r2.next(), ResolveInfo.class, "com.obric.memorydata.plugin")).serviceInfo.packageName;
        if (r3.equals(r0.getPackageName()) == true) goto L6;
    L11:
        Log.i("SmartBindService", "findExternalHostPackage: " + r3);
        if (r3 == null) goto L21;
        Intent r5 = new Intent(this.c);
        r5.setPackage(r3);
        Log.i("SmartBindService", "bindToRemoteService: pkg=" + r3 + ", bound=" + ZeusTransformUtils.bindService(this.f7017a, r5, this.f7018b, 1, "com.obric.memorydata.plugin"));     // Catch: Exception -> L16 SecurityException -> L18
    L42:
        return;
    L18:
        e = e;
        String r4 = "bindToRemoteService: Permission denied";
    L20:
        Log.e("SmartBindService", r4, e);
        return;
    L16:
        e = e;
        r4 = "bindToRemoteService: Failed to bind";
        goto L20
    L21:
        String r6 = this.d;
        if (r6 != null) goto L24;
    L31:
        Log.e("SmartBindService", "Local Service Class Name is null or empty, cannot start.");
        return;
    L24:
        if (r6.isEmpty() == true) goto L31;
        ComponentName r7 = new ComponentName(this.f7017a.getPackageName(), this.d);
        Intent r8 = new Intent();
        r8.setComponent(r7);
        r8.setAction(this.c);
        Log.i("SmartBindService", "startAndBindLocalService: bindService called, bound=" + ZeusTransformUtils.bindService(this.f7017a, r8, this.f7018b, 1, "com.obric.memorydata.plugin"));     // Catch: Exception -> L29
        return;
    L29:
        e = move-exception;
        Log.e("SmartBindService", "Failed to start/bind local service: " + this.d, e);
        return;
    L10:
        r3 = null;
        goto L11
    }
}
