package com.obric.cae.location;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.location.report.c;
import com.obric.cae.location.util.d;
import com.obric.cae.utils.AIKernelPythonBridge;
import com.volcengine.zeus.service.PluginService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class StarLocationService extends PluginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile StarLocationService f7019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f7020b;
    public String c;
    public volatile boolean d;
    public final AtomicBoolean e;
    public final AtomicBoolean f;
    public final com.obric.cae.libs.location.b.a g;

    public StarLocationService() {
        this.c = null;
        this.d = false;
        this.e = new AtomicBoolean(false);
        this.f = new AtomicBoolean(false);
        this.g = new AnonymousClass1(this);
    }

    private /* synthetic */ void a(d r2) {
        if (r2.d(this.f7020b) == true) goto L6;
        com.obric.cae.log.a.i("StarLocation", "core init skipped, Star directory is unavailable");
        return;
    L6:
        b();
    }

    private void a(PrintWriter r6, String[] r7) {
        com.obric.cae.log.a.f("StarLocation", CommonConsts.APM_INNER_EVENT_COST_START);
        LinkedHashSet r0 = new LinkedHashSet();
        r0.addAll(StarGeofenceManager.getAllInstances().keySet());
        r0.addAll(com.obric.cae.location.geosdk.poi.a.b().keySet());
        r6.println("build info: " + (SystemProperties.get("ro.os.ota.version", "") + " " + SystemProperties.get("ro.build.tags", "")));
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(r1.next(), Integer.class, "com.obric.memorydata.plugin");
        r6.println("---- Dump for user " + r2 + " ----");
        StarGeofenceManager r3 = (StarGeofenceManager) ZeusTransformUtils.preCheckCast(StarGeofenceManager.getAllInstances().get(r2), StarGeofenceManager.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        r3.dump(r6, r7);
    L8:
        com.obric.cae.location.geosdk.poi.a r4 = (com.obric.cae.location.geosdk.poi.a) ZeusTransformUtils.preCheckCast(com.obric.cae.location.geosdk.poi.a.b().get(r2), com.obric.cae.location.geosdk.poi.a.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        r4.a(r6, r7);
        goto L4
    L11:
        com.obric.cae.log.a.f("StarLocation", "end");
    }

    public static /* synthetic */ void a(Runnable r2, String r3) {
        ((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin")).run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.obric.cae.log.a.a("StarLocation", r3 + " init failed", th);
    }

    public static void b(Runnable r2, final String r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin");
        d.a().r().execute(new $$Lambda$tEbHkHAstz0I1EetkycCRScILOU(r4, r3));
    }

    private /* synthetic */ void e() {
    L9:
        th = move-exception;
        this.f.set(false);
        com.obric.cae.log.a.a("StarLocation", "sub service init failed", th);
        return;
    L4:
        if (d.a().d(this.f7020b) == true) goto L7;
        this.f.set(false);     // Catch: Throwable -> L9
        com.obric.cae.log.a.i("StarLocation", "sub service init skipped, Star directory is unavailable");     // Catch: Throwable -> L9
        return;
    L7:
        b();     // Catch: Throwable -> L9
        d();     // Catch: Throwable -> L9
        com.obric.cae.location.report.d.a(this.f7020b);     // Catch: Throwable -> L9
        com.obric.cae.location.report.b.a(c.a(this.f7020b));     // Catch: Throwable -> L9
        this.d = true;     // Catch: Throwable -> L9
        com.obric.cae.log.a.c("StarLocation", "sub service init done");     // Catch: Throwable -> L9
        com.obric.cae.runtime.a.a(this.f7020b, StarLocationService.class, this);     // Catch: Throwable -> L9
    }

    private /* synthetic */ void f() {
        com.obric.cae.location.city.c.a(this.f7020b).a();
    }

    private /* synthetic */ void g() {
        com.obric.cae.location.cell.c.a(this.f7020b).b();
    }

    private /* synthetic */ void h() {
        com.obric.cae.location.report.d.a(this.f7020b);
        com.obric.cae.location.report.b.a(c.a(this.f7020b));
    }

    private /* synthetic */ void i() {
        StarPoiManager.a().b(this.f7020b);
    }

    private /* synthetic */ void j() {
        AIKernelPythonBridge.init(this.f7020b, "default");
    }

    private /* synthetic */ void k() {
        d.a().a(this.f7020b);
    }

    private /* synthetic */ void l() {
        a.a().a(this.f7020b);
    }

    public static /* synthetic */ void lambda$7W_fU6l0OZF_7gw2Icyqm9WmDbU(StarLocationService r0) {
        r0.j();
    }

    public static /* synthetic */ void lambda$AwsSdNBwzr_NSNE06pMJhgcr5Tc(StarLocationService r0) {
        r0.e();
    }

    public static /* synthetic */ void lambda$BY9rqJy7wZTH1zxfl3zp8aeUXVc(StarLocationService r0) {
        r0.i();
    }

    /* JADX INFO: renamed from: lambda$FjwqLFATS-R55J62pgdtvXarAZ8, reason: not valid java name */
    public static /* synthetic */ void m371lambda$FjwqLFATSR55J62pgdtvXarAZ8(StarLocationService r0) {
        r0.k();
    }

    /* JADX INFO: renamed from: lambda$c0UYjQ0FG6Li-zu0NoSLBCcTY00, reason: not valid java name */
    public static /* synthetic */ void m372lambda$c0UYjQ0FG6Lizu0NoSLBCcTY00(StarLocationService r0) {
        r0.l();
    }

    public static /* synthetic */ void lambda$hPOQgVP5TusjJBII4F8vwg4IdZ4(StarLocationService r0) {
        r0.g();
    }

    public static /* synthetic */ void lambda$mkqed7TPTzdD9F0eUPmpp43OR3k(StarLocationService r0, PrintWriter r1, String[] r2) {
        r0.a(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$q17hjFJ5LPL2aAUFWYy-9KVP1lE, reason: not valid java name */
    public static /* synthetic */ void m373lambda$q17hjFJ5LPL2aAUFWYy9KVP1lE(StarLocationService r0) {
        r0.f();
    }

    public static /* synthetic */ void lambda$xdHFqZ3tjI5p7aTojeEvlBYkiQA(StarLocationService r0, d r1) {
        r0.a(r1);
    }

    public static /* synthetic */ void lambda$zKgcDfITi3LtGHNL0_lQq2n5dCQ(StarLocationService r0) {
        r0.h();
    }

    public com.obric.cae.libs.location.b.a a() {
        return this.g;
    }

    public final void b() {
        if (this.e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        b(new $$Lambda$StarLocationService$c0UYjQ0FG6Lizu0NoSLBCcTY00(this), "StarLocationManager");
        b(new $$Lambda$StarLocationService$FjwqLFATSR55J62pgdtvXarAZ8(this), "LocationUtil");
        b(new $$Lambda$StarLocationService$7W_fU6l0OZF_7gw2Icyqm9WmDbU(this), "AIKernelPythonBridge");
        b(new $$Lambda$StarLocationService$BY9rqJy7wZTH1zxfl3zp8aeUXVc(this), "StarPoiManager");
        b(new $$Lambda$StarLocationService$zKgcDfITi3LtGHNL0_lQq2n5dCQ(this), "StarLocationReporter");
        b(new $$Lambda$StarLocationService$hPOQgVP5TusjJBII4F8vwg4IdZ4(this), "StarCellManager");
        b(new $$Lambda$StarLocationService$q17hjFJ5LPL2aAUFWYy9KVP1lE(this), "StarCityManager");
    }

    public final void c() {
        if (this.f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        d.a().r().execute(new $$Lambda$StarLocationService$AwsSdNBwzr_NSNE06pMJhgcr5Tc(this));
    }

    public final void d() {
        UserManager r0 = (UserManager) ZeusTransformUtils.preCheckCast(this.f7020b.getSystemService("user"), UserManager.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        Iterator<UserHandle> r1 = r0.getUserProfiles().iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        UserHandle r2 = (UserHandle) ZeusTransformUtils.preCheckCast(r1.next(), UserHandle.class, "com.obric.memorydata.plugin");
        com.obric.cae.location.geosdk.poi.a.a(this.f7020b, r2.getIdentifier());
        StarGeofenceManager.getInstance(this.f7020b, r2.getIdentifier());
    L9:
        com.obric.cae.log.a.c("StarLocation", "boot sub service done.");
        return;
    L8:
        com.obric.cae.location.geosdk.poi.a.a(this.f7020b, 0);
        StarGeofenceManager.getInstance(this.f7020b, 0);
        goto L9
    }

    public final void dump(FileDescriptor r4, final PrintWriter r5, final String[] r6) {
        Future<?> r3 = d.a().r().submit(new $$Lambda$StarLocationService$mkqed7TPTzdD9F0eUPmpp43OR3k(this, r5, r6));
        r3.get(5, TimeUnit.SECONDS);     // Catch: ExecutionException -> L5 InterruptedException -> L7 TimeoutException -> L9
    L16:
        return;
    L7:
        e = e;
        r3.cancel(true);
        Thread.currentThread().interrupt();
        String r7 = "dump interrupted";
    L11:
        r5.println(r7);
        com.obric.cae.log.a.a("StarLocation", r7, e);
        return;
    L5:
        e = move-exception;
        r5.println("dump failed: " + e.getMessage());
        com.obric.cae.log.a.a("StarLocation", "dump failed", e);
        return;
    L9:
        e = e;
        r3.cancel(true);
        r7 = "dump timeout after 5s";
        goto L11
    }

    public IBinder onBind(Intent r2) {
        com.obric.cae.log.a.c("StarLocation", "onBind");
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        super/*android.app.Service*/.onCreate();
        com.obric.cae.log.a.c("StarLocation", "onCreate");
        f7019a = this;
        this.f7020b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        final d r0 = d.a();
        r0.r().execute(new $$Lambda$StarLocationService$xdHFqZ3tjI5p7aTojeEvlBYkiQA(this, r0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDestroy() {
        com.obric.cae.log.a.c("StarLocation", "onDestroy");
        com.obric.cae.location.indoor.a.a().e();
        com.obric.cae.location.city.c.a(this.f7020b).b();     // Catch: Throwable -> L7
    L11:
        StarPoiManager.a().v();     // Catch: Throwable -> L8
    L5:
        com.obric.cae.runtime.a.a(StarLocationService.class, this);
        super/*android.app.Service*/.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int onStartCommand(Intent r4, int r5, int r6) {
        com.obric.cae.log.a.c("StarLocation", b.a("onStartCommand, flags: ", r5, ", startId: ", r6, ", intent: ").append(r4).toString());
        if (this.d == true) goto L6;
        c();
    L6:
        return super/*android.app.Service*/.onStartCommand(r4, r5, r6);
    }
}
