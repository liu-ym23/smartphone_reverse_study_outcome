package com.a.a.a;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f117b;
    private android.a.a.a.a c;

    private a(Context r3) {
        this.f117b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        c();
    }

    public static synchronized a a(Context r3) {
        monitor-enter(a.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (f116a != null) goto L7;
        f116a = new a(r4);     // Catch: Throwable -> L10
    L7:
        a r5 = f116a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private void c() {
        IBinder r1 = ServiceManager.getService("datacenter.media.location_report");     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        this.c = android.a.a.a.a.AbstractBinderC0001a.a(r1);     // Catch: Exception -> L8
        Log.i("LocationReportManager", "Successfully connected to location report service");     // Catch: Exception -> L8
    L11:
        return;
    L6:
        Log.w("LocationReportManager", "Location report service not available");     // Catch: Exception -> L8
    L8:
        e = move-exception;
        Log.e("LocationReportManager", "Failed to connect to location report service", e);
    }

    public void a(double r9, double r11) {
        Context r0 = this.f117b;
        if (r0 != null) goto L7;
        String r8 = "Context is null";
    L5:
        Log.w("LocationReportManager", r8);
        return;
    L7:
        android.a.a.a.a r2 = this.c;
        if (r2 != null) goto L15;
        r8 = "Location report service not connected";
        goto L5
    L15:
        r2.a(r9, r11, r0.getPackageName());     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        Log.e("LocationReportManager", "Failed to report home GPS location", e);
    }

    public void a(boolean r3) {
        Context r0 = this.f117b;
        if (r0 != null) goto L7;
        String r2 = "Context is null";
    L5:
        Log.w("LocationReportManager", r2);
        return;
    L7:
        android.a.a.a.a r4 = this.c;
        if (r4 != null) goto L15;
        r2 = "Location report service not connected";
        goto L5
    L15:
        r4.a(r3, r0.getPackageName());     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        Log.e("LocationReportManager", "Failed to report home state", e);
    }

    public boolean a() {
        if (this.c == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void b() {
        c();
    }

    public void b(double r9, double r11) {
        Context r0 = this.f117b;
        if (r0 != null) goto L7;
        String r8 = "Context is null";
    L5:
        Log.w("LocationReportManager", r8);
        return;
    L7:
        android.a.a.a.a r2 = this.c;
        if (r2 != null) goto L15;
        r8 = "Location report service not connected";
        goto L5
    L15:
        r2.b(r9, r11, r0.getPackageName());     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        Log.e("LocationReportManager", "Failed to report company GPS location", e);
    }

    public void b(boolean r3) {
        Context r0 = this.f117b;
        if (r0 != null) goto L7;
        String r2 = "Context is null";
    L5:
        Log.w("LocationReportManager", r2);
        return;
    L7:
        android.a.a.a.a r4 = this.c;
        if (r4 != null) goto L15;
        r2 = "Location report service not connected";
        goto L5
    L15:
        r4.b(r3, r0.getPackageName());     // Catch: RemoteException -> L12
        return;
    L12:
        e = move-exception;
        Log.e("LocationReportManager", "Failed to report company state", e);
    }
}
