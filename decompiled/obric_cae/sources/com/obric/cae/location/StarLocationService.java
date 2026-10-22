package com.obric.cae.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import androidx.room.k;
import androidx.room.m;
import com.obric.cae.libs.location.IStarLocationService;
import com.obric.cae.location.cell.StarCellManager;
import com.obric.cae.location.city.StarCityManager;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.location.report.StarLocationReportFactory;
import com.obric.cae.location.report.StarLocationReportJson;
import com.obric.cae.location.report.StarLocationTeaReporter;
import com.obric.cae.location.util.LocationUtil;
import com.obric.cae.location.zpp.StarZppManager;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.runtime.CaeRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class StarLocationService extends Service {
    private static final long DUMP_TIMEOUT_SECONDS = 5;
    private static final String STAR_DEFAULT_VERSION = "Unsupported";
    public static final String TAG = "StarLocation";
    private static volatile StarLocationService sService;
    private Context mContext;
    private final AtomicBoolean mCoreInitStarted;
    private final AtomicBoolean mSubServiceInitStarted;
    private volatile boolean serviceInitFlag;
    private final IStarLocationService.Stub starLocationServiceBinder;
    private String versionName;

    public StarLocationService() {
        this.versionName = null;
        this.serviceInitFlag = false;
        this.mCoreInitStarted = new AtomicBoolean(false);
        this.mSubServiceInitStarted = new AtomicBoolean(false);
        this.starLocationServiceBinder = new AnonymousClass1(this);
    }

    public static /* synthetic */ void a(StarLocationService r8) {
        r8.lambda$startCoreInitAsync$3();
    }

    public static /* synthetic */ String access$000(StarLocationService r8) {
        return r8.versionName;
    }

    public static /* synthetic */ String access$002(StarLocationService r8, String r10) {
        r8.versionName = r10;
        return r10;
    }

    public static /* synthetic */ Context access$100(StarLocationService r8) {
        return r8.mContext;
    }

    public static /* synthetic */ void b(StarLocationService r8) {
        r8.lambda$startCoreInitAsync$0();
    }

    public static /* synthetic */ void c(StarLocationService r8) {
        r8.lambda$startCoreInitAsync$2();
    }

    public static /* synthetic */ void d(Runnable r8, String r10) {
        lambda$executeInitTask$7(r8, r10);
    }

    private void dumpLocationInfo(PrintWriter r8, String[] r10) {
        CommSenseLog.iWithMethodName(TAG, "start");
        LinkedHashSet r11 = new LinkedHashSet();
        r11.addAll(StarGeofenceManager.getAllInstances().keySet());
        r11.addAll(StarAoiBoardManager.getAllInstances().keySet());
        r8.println("build info: " + (SystemProperties.get("ro.os.ota.version", "") + " " + SystemProperties.get("ro.build.tags", "")));
        Iterator r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L11;
        Integer r13 = (Integer) r12.next();
        r8.println("---- Dump for user " + r13 + " ----");
        StarGeofenceManager r14 = StarGeofenceManager.getAllInstances().get(r13);
        if (r14 == null) goto L8;
        r14.dump(r8, r10);
    L8:
        StarAoiBoardManager r15 = StarAoiBoardManager.getAllInstances().get(r13);
        if (r15 == null) goto L4;
        r15.dump(r8, r10);
        goto L4
    L11:
        CommSenseLog.iWithMethodName(TAG, "end");
    }

    public static /* synthetic */ void e(StarLocationService r8, PrintWriter r10, String[] r11) {
        r8.lambda$dump$9(r10, r11);
    }

    private void executeInitTask(String r8, Runnable r10) {
        LocationUtil.getInstance().getExecutor().execute(new k(14, r10, r8));
    }

    public static /* synthetic */ void f(StarLocationService r8) {
        r8.lambda$startCoreInitAsync$6();
    }

    public static /* synthetic */ void g(StarLocationService r8) {
        r8.lambda$startCoreInitAsync$5();
    }

    public static StarLocationService getService() {
        return sService;
    }

    public static /* synthetic */ void h(StarLocationService r8) {
        r8.lambda$startCoreInitAsync$1();
    }

    public static /* synthetic */ void i(StarLocationService r8) {
        r8.lambda$startCoreInitAsync$4();
    }

    private void initSubStarService() {
        UserManager r8 = (UserManager) this.mContext.getSystemService("user");
        if (r8 == null) goto L8;
        Iterator<UserHandle> r10 = r8.getUserProfiles().iterator();
    L6:
        if (r10.hasNext() == false) goto L9;
        UserHandle r11 = r10.next();
        StarAoiBoardManager.getInstance(this.mContext, r11.getIdentifier());
        StarGeofenceManager.getInstance(this.mContext, r11.getIdentifier());
    L9:
        CommSenseLog.d(TAG, "boot sub service done.");
        return;
    L8:
        StarAoiBoardManager.getInstance(this.mContext, 0);
        StarGeofenceManager.getInstance(this.mContext, 0);
        goto L9
    }

    public static /* synthetic */ void j(StarLocationService r8) {
        r8.lambda$startSubServiceInitAsync$8();
    }

    private /* synthetic */ void lambda$dump$9(PrintWriter r8, String[] r10) {
        dumpLocationInfo(r8, r10);
    }

    private static /* synthetic */ void lambda$executeInitTask$7(Runnable r8, String r10) {
        r8.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CommSenseLog.e(TAG, r10 + " init failed", th);
    }

    private /* synthetic */ void lambda$startCoreInitAsync$0() {
        StarLocationManager.getInstance().initOnce(this.mContext);
    }

    private /* synthetic */ void lambda$startCoreInitAsync$1() {
        LocationUtil.getInstance().initOnce(this.mContext);
    }

    private /* synthetic */ void lambda$startCoreInitAsync$2() {
        StarPoiManager.getInstance().initOnce(this.mContext);
    }

    private /* synthetic */ void lambda$startCoreInitAsync$3() {
        StarZppManager.getInstance(this.mContext, 0);
    }

    private /* synthetic */ void lambda$startCoreInitAsync$4() {
        StarLocationTeaReporter.init(this.mContext);
        StarLocationReportFactory.createReportInstance(StarLocationReportJson.getInstance(this.mContext));
    }

    private /* synthetic */ void lambda$startCoreInitAsync$5() {
        StarCellManager.getInstance(this.mContext).startListen();
    }

    private /* synthetic */ void lambda$startCoreInitAsync$6() {
        StarCityManager.getInstance(this.mContext).onServiceStarted();
    }

    private /* synthetic */ void lambda$startSubServiceInitAsync$8() {
        initSubStarService();     // Catch: Throwable -> L5
        this.serviceInitFlag = true;     // Catch: Throwable -> L5
        CommSenseLog.d(TAG, "sub service init done");     // Catch: Throwable -> L5
        CaeRuntime.notifyServiceReady(this.mContext, StarLocationService.class, this);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        this.mSubServiceInitStarted.set(false);
        CommSenseLog.e(TAG, "sub service init failed", th);
    }

    private void startCoreInitAsync() {
        final int r8 = 0;
        final int r10 = 1;
        if (this.mCoreInitStarted.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        executeInitTask("StarLocationManager", new e(this, r8));
        executeInitTask("LocationUtil", new f(this, r8));
        executeInitTask("StarPoiManager", new d(this, r10));
        executeInitTask("StarZppManager", new e(this, r10));
        executeInitTask("StarLocationReporter", new f(this, r10));
        final int r11 = 2;
        executeInitTask("StarCellManager", new d(this, r11));
        executeInitTask("StarCityManager", new e(this, r11));
    }

    private void startSubServiceInitAsync() {
        int r8 = 0;
        if (this.mSubServiceInitStarted.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        LocationUtil.getInstance().getExecutor().execute(new d(this, r8));
    }

    @Override // android.app.Service
    public void dump(FileDescriptor r8, PrintWriter r10, String[] r11) {
        Future<?> r12 = LocationUtil.getInstance().getExecutor().submit(new m(this, r10, r11, 2));
        r12.get(DUMP_TIMEOUT_SECONDS, TimeUnit.SECONDS);     // Catch: ExecutionException -> L5 InterruptedException -> L7 TimeoutException -> L9
    L16:
        return;
    L7:
        e = e;
        r12.cancel(true);
        Thread.currentThread().interrupt();
        String r13 = "dump interrupted";
    L11:
        r10.println(r13);
        CommSenseLog.e(TAG, r13, e);
        return;
    L5:
        e = move-exception;
        r10.println("dump failed: " + e.getMessage());
        CommSenseLog.e(TAG, "dump failed", e);
        return;
    L9:
        e = e;
        r12.cancel(true);
        r13 = "dump timeout after 5s";
        goto L11
    }

    public IStarLocationService.Stub getStarLocationServiceBinder() {
        return this.starLocationServiceBinder;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        CommSenseLog.d(TAG, "onBind");
        return this.starLocationServiceBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CommSenseLog.d(TAG, "onCreate");
        sService = this;
        this.mContext = getApplicationContext();
        startCoreInitAsync();
    }

    @Override // android.app.Service
    public void onDestroy() {
        CommSenseLog.d(TAG, "onDestroy");
        StarCityManager.getInstance(this.mContext).destroy();     // Catch: Throwable -> L7
    L11:
        StarPoiManager.getInstance().destroy();     // Catch: Throwable -> L8
    L5:
        CaeRuntime.unregisterService(StarLocationService.class, this);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        StringBuilder r12 = defpackage.a.g("onStartCommand, flags: ", r10, ", startId: ", r11, ", intent: ");
        r12.append(r8);
        CommSenseLog.d(TAG, r12.toString());
        if (this.serviceInitFlag == true) goto L6;
        startSubServiceInitAsync();
    L6:
        return super.onStartCommand(r8, r10, r11);
    }
}
