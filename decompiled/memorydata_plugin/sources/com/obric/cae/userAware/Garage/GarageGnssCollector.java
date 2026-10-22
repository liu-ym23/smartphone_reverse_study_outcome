package com.obric.cae.userAware.Garage;

import android.content.Context;
import android.location.GnssStatus;
import android.location.LocationListener;
import android.location.LocationManager;
import com.obric.cae.log.a;
import com.obric.cae.userAware.Garage.proto.GarageApScanStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
final class GarageGnssCollector {
    private static final long LOCATION_UPDATE_INTERVAL_MS = 1000;
    private static final float LOCATION_UPDATE_MIN_DISTANCE_M = 0.0f;
    private static final String TAG = "GarageGnssCollector";
    private int mActiveScanId;
    private Callback mCallback;
    private final Context mContext;
    private final ScheduledExecutorService mExecutor;
    private long mGeneration;
    private final GnssStatus.Callback mGnssCallback;
    private Result mLatestResult;
    private final LocationListener mLocationListener;
    private final LocationManager mLocationManager;
    private final Object mLock;
    private ScheduledFuture<?> mTimeoutFuture;

    public interface Callback {
        void onComplete(Result r1);
    }

    public static final class Result {
        final float meanCn0;
        final int scanId;
        final GarageApScanStatus status;
        final float svCount;
        final float top4Cn0;
        final float usedFraction;
        final float usedSvCount;

        public Result(int r1, GarageApScanStatus r2, float r3, float r4, float r5, float r6, float r7) {
            this.scanId = r1;
            this.status = r2;
            this.svCount = r3;
            this.meanCn0 = r4;
            this.top4Cn0 = r5;
            this.usedSvCount = r6;
            this.usedFraction = r7;
        }

        public boolean hasUsableSignal() {
            if (this.svCount > 0.0f) goto L5;
        L7:
            return false;
        L5:
            if (this.meanCn0 <= 0.0f) goto L7;
            return true;
        }
    }

    public GarageGnssCollector(Context r4, ScheduledExecutorService r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        ScheduledExecutorService r7 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r5, ScheduledExecutorService.class, "com.obric.memorydata.plugin");
        this.mLock = new Object();
        this.mLocationListener = new AnonymousClass1(this);
        this.mGnssCallback = new AnonymousClass2(this);
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        r6 = r0;
    L5:
        this.mContext = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mExecutor = r7;
        this.mLocationManager = (LocationManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(LocationManager.class), LocationManager.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Object access$000(GarageGnssCollector r0) {
        return r0.mLock;
    }

    public static /* synthetic */ int access$100(GarageGnssCollector r0) {
        return r0.mActiveScanId;
    }

    public static /* synthetic */ long access$200(GarageGnssCollector r2) {
        return r2.mGeneration;
    }

    public static /* synthetic */ Result access$300(int r0, GnssStatus r1) {
        return buildResult(r0, r1);
    }

    public static /* synthetic */ Result access$402(GarageGnssCollector r0, Result r1) {
        r0.mLatestResult = r1;
        return r1;
    }

    public static /* synthetic */ void access$500(GarageGnssCollector r0, int r1, long r2, Result r4, boolean r5) {
        r0.finish(r1, r2, r4, r5);
    }

    public static /* synthetic */ Result access$600(int r0, GarageApScanStatus r1) {
        return empty(r0, r1);
    }

    private static Result buildResult(int r22, GnssStatus r23) {
        int r1 = r23.getSatelliteCount();
        float[] r3 = new float[4];
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r12 = 0;
        double r10 = 0.0d;
    L3:
        float r13 = 0.0f;
        if (r7 >= r1) goto L19;
        float r14 = r23.getCn0DbHz(r7);
        if (Float.isFinite(r14) == false) goto L18;
        if (r14 <= 0.0f) goto L18;
        r8 = r8 + 1;
        r10 = r10 + ((double) r14);
        if (r23.usedInFix(r7) == false) goto L13;
        r12 = r12 + 1;
    L13:
        if (r9 >= 4) goto L16;
        int r4 = r9 + 1;
        r3[r9] = r14;
        Arrays.sort(r3, 0, r4);
        r9 = r4;
        goto L18
    L16:
        if (r14 <= r3[0]) goto L18;
        r3[0] = r14;
        Arrays.sort(r3);
    L18:
        r7 = r7 + 1;
        goto L3
    L19:
        double r5 = 0.0d;
    L20:
        if (r6 >= r9) goto L22;
        r5 = r5 + ((double) r3[r6]);
        r6 = r6 + 1;
        goto L20
    L22:
        GarageApScanStatus r16 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SUCCESS;
        float r2 = r8;
        if (r8 != 0) goto L25;
        float r18 = 0.0f;
    L26:
        if (r9 == 0) goto L29;
        r13 = (float) (r5 / ((double) r9));
    L29:
        float r11 = r12;
        return new Result(r22, r16, r2, r18, r13, r11, r11 / Math.max(1, r8));
    L25:
        r18 = (float) (r10 / ((double) r8));
        goto L26
    }

    private static Result empty(int r9, GarageApScanStatus r10) {
        return new Result(r9, r10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    private void finish(int r4, long r5, Result r7, boolean r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (r4 != 0) goto L31;
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L31:
    L28:
        th = move-exception;
        throw th;
    L6:
        if (r4 != this.mActiveScanId) goto L26;
        if (r5 != this.mGeneration) goto L26;
        ScheduledFuture<?> r6 = this.mTimeoutFuture;     // Catch: Throwable -> L28
        if (r6 == null) goto L13;
        r6.cancel(false);     // Catch: Throwable -> L28
        this.mTimeoutFuture = null;     // Catch: Throwable -> L28
    L13:
        Callback r9 = this.mCallback;     // Catch: Throwable -> L28
        this.mCallback = null;     // Catch: Throwable -> L28
        this.mLatestResult = null;     // Catch: Throwable -> L28
        this.mActiveScanId = 0;     // Catch: Throwable -> L28
        monitor-exit(r0);     // Catch: Throwable -> L28
        LocationManager r10 = this.mLocationManager;     // Catch: RuntimeException -> L19
        if (r10 == null) goto L21;
        r10.unregisterGnssStatusCallback(this.mGnssCallback);     // Catch: RuntimeException -> L19
    L21:
        stopLocationUpdates();
        if (r8 == false) goto L34;
        if (r9 == null) goto L35;
        r9.onComplete(r7);
        return;
    L35:
        return;
    L34:
        return;
    L19:
        e = move-exception;
        a.a(TAG, "GNSS callback unregister failed", e);
        goto L21
    }

    private void finishOnTimeout(int r9, long r10) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (r9 != 0) goto L22;
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L22:
    L19:
        th = move-exception;
        throw th;
    L6:
        if (r9 != this.mActiveScanId) goto L17;
        if (r10 != this.mGeneration) goto L17;
        Result r1 = this.mLatestResult;     // Catch: Throwable -> L19
        if (r1 == null) goto L13;
    L12:
        Result r6 = r1;
        monitor-exit(r0);     // Catch: Throwable -> L19
        finish(r9, r10, r6, true);
        return;
    L13:
        r1 = empty(r9, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_TIMEOUT);     // Catch: Throwable -> L19
        goto L12
    }

    private void stopLocationUpdates() {
        LocationManager r0 = this.mLocationManager;     // Catch: RuntimeException -> L6
        if (r0 == null) goto L11;
        r0.removeUpdates(this.mLocationListener);     // Catch: RuntimeException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        a.a(TAG, "GNSS location updates removal failed", e);
    }

    public void cancel(int r8) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        long r3 = this.mGeneration;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        finish(r8, r3, empty(r8, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_CANCELLED), false);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ void lambda$start$0$GarageGnssCollector(int r1, long r2) {
        finishOnTimeout(r1, r2);
    }

    public boolean start(final int r20, long r21, Callback r23) {
        Callback r2 = (Callback) ZeusTransformUtils.wrapperContextForParams(r23, Callback.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        if (r20 != 0) goto L5;
    L69:
        return false;
    L5:
        if (r21 <= 0) goto L69;
        if (r2 == null) goto L69;
        if (this.mContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L13;
    L10:
        GarageApScanStatus r0 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED;
    L11:
        r2.onComplete(empty(r20, r0));
        return true;
    L13:
        LocationManager r4 = this.mLocationManager;
        if (r4 != null) goto L77;
        r0 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE;
        goto L11
    L77:
    L67:
        e = move-exception;
        a.a(TAG, "GNSS provider query failed", e);
        r0 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCAN_FAILED;
        goto L11
    L17:
        if (r4.isProviderEnabled("gps") == true) goto L20;
        r2.onComplete(empty(r20, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE));     // Catch: SecurityException -> L70 RuntimeException -> L67
        return true;
        goto L10
    L20:
        Object r5 = this.mLock;
        monitor-enter(r5);
    L64:
        th = move-exception;
        throw th;
    L23:
        if (this.mActiveScanId == 0) goto L26;
        monitor-exit(r5);     // Catch: Throwable -> L64
        return false;
    L26:
        this.mActiveScanId = r20;     // Catch: Throwable -> L64
        final long r10 = 1 + this.mGeneration;     // Catch: Throwable -> L64
        this.mGeneration = r10;     // Catch: Throwable -> L64
        this.mCallback = r2;     // Catch: Throwable -> L64
        this.mLatestResult = null;     // Catch: Throwable -> L64
        monitor-exit(r5);     // Catch: Throwable -> L64
    L60:
        e = move-exception;
        a.a(TAG, "GNSS permission denied", e);
        GarageApScanStatus r1 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_PERMISSION_DENIED;
    L62:
        finish(r20, r10, empty(r20, r1), true);
    L63:
        return true;
    L58:
        e = move-exception;
        a.a(TAG, "GNSS collection start failed", e);
        r1 = GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCAN_FAILED;
        goto L62
    L29:
        if (this.mLocationManager.registerGnssStatusCallback(this.mExecutor, this.mGnssCallback) == true) goto L32;
        finish(r20, r10, empty(r20, GarageApScanStatus.GARAGE_AP_SCAN_STATUS_SCANNER_UNAVAILABLE), true);     // Catch: RuntimeException -> L58 SecurityException -> L60
        return true;
    L32:
        this.mLocationManager.requestLocationUpdates("gps", 1000, 0.0f, this.mExecutor, this.mLocationListener);     // Catch: RuntimeException -> L58 SecurityException -> L60
        Object r6 = this.mLock;     // Catch: RuntimeException -> L58 SecurityException -> L60
        monitor-enter(r6);     // Catch: RuntimeException -> L58 SecurityException -> L60
    L55:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L58 SecurityException -> L60
    L35:
        if (this.mActiveScanId == r20) goto L37;
    L39:
        monitor-exit(r6);     // Catch: Throwable -> L55
        if (r3 == true) goto L43;
        stopLocationUpdates();     // Catch: RuntimeException -> L58 SecurityException -> L60
        return true;
    L43:
        Object r7 = this.mLock;     // Catch: RuntimeException -> L58 SecurityException -> L60
        monitor-enter(r7);     // Catch: RuntimeException -> L58 SecurityException -> L60
    L52:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L58 SecurityException -> L60
    L46:
        if (this.mActiveScanId == r20) goto L48;
    L50:
        monitor-exit(r7);     // Catch: Throwable -> L52
        goto L63
    L48:
        if (this.mGeneration != r10) goto L50;
        this.mTimeoutFuture = this.mExecutor.schedule(new $$Lambda$GarageGnssCollector$9Yy5eCHB471lIgM7_BUtecjAWoI(this, r20, r10), r21, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L52
        goto L50
    L37:
        if (this.mGeneration != r10) goto L39;
        r3 = true;
        goto L39
    }
}
