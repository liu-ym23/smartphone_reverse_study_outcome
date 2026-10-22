package com.bytedance.bdlocation.bytelocation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import b2.a;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import he.e;
import he.i;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import xd.j;

/* JADX INFO: loaded from: classes.dex */
public final class ByteContinuousLocationImpl extends BaseLocate {
    public static final Companion Companion = null;
    private static final String DEFAULT_BUSINESS_ID = "default_continuous_location";
    private BDLocationCallback mCallback;
    private final ConcurrentHashMap<String, ContinuousLocationContext> mContinuousClients;
    private volatile boolean mIsFirstLocation;
    private volatile BDLocation mLastLocation;
    private volatile long mLastLocationStartTime;
    private volatile long mLastSetUploadNetSignalTime;
    private Looper mLocationLooper;
    private a mLocationManager;
    private volatile boolean mLocationRunning;
    private final Object mLock;
    private LocationOption mOption;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(e r8) {
            this();
        }
    }

    public static final class ContinuousLocationContext {
        private BDLocationCallback callback;
        private boolean isFirstLocation;
        private BDLocation lastLocation;
        private long lastSetUploadNetSignalTime;
        private Looper looper;
        private a manager;
        private LocationOption option;
        private boolean running;
        private long startTime;

        public ContinuousLocationContext() {
            this(null, null, null, null, null, 0, false, 0, false, 511, null);
        }

        public static /* synthetic */ ContinuousLocationContext copy$default(ContinuousLocationContext r12, a r13, Looper r14, LocationOption r15, BDLocationCallback r16, BDLocation r17, long r18, boolean r20, long r21, boolean r23, int r24, Object r25) {
            if ((r24 & 1) == 0) goto L5;
            a r8 = r12.manager;
        L7:
            if ((r24 & 2) == 0) goto L9;
            Looper r10 = r12.looper;
        L11:
            if ((r24 & 4) == 0) goto L13;
            LocationOption r11 = r12.option;
        L15:
            if ((r24 & 8) == 0) goto L17;
            BDLocationCallback r19 = r12.callback;
        L19:
            if ((r24 & 16) == 0) goto L21;
            BDLocation r22 = r12.lastLocation;
        L23:
            if ((r24 & 32) == 0) goto L25;
            long r26 = r12.startTime;
        L27:
            if ((r24 & 64) == 0) goto L29;
            boolean r27 = r12.isFirstLocation;
        L31:
            if ((r24 & 128) == 0) goto L33;
            long r110 = r12.lastSetUploadNetSignalTime;
        L35:
            if ((r24 & 256) == 0) goto L37;
            boolean r28 = r12.running;
        L39:
            return r12.copy(r8, r10, r11, r19, r22, r26, r27, r110, r28);
        L37:
            r28 = r23;
            goto L39
        L33:
            r110 = r21;
            goto L35
        L29:
            r27 = r20;
            goto L31
        L25:
            r26 = r18;
            goto L27
        L21:
            r22 = r17;
            goto L23
        L17:
            r19 = r16;
            goto L19
        L13:
            r11 = r15;
            goto L15
        L9:
            r10 = r14;
            goto L11
        L5:
            r8 = r13;
            goto L7
        }

        public final a component1() {
            return this.manager;
        }

        public final Looper component2() {
            return this.looper;
        }

        public final LocationOption component3() {
            return this.option;
        }

        public final BDLocationCallback component4() {
            return this.callback;
        }

        public final BDLocation component5() {
            return this.lastLocation;
        }

        public final long component6() {
            return this.startTime;
        }

        public final boolean component7() {
            return this.isFirstLocation;
        }

        public final long component8() {
            return this.lastSetUploadNetSignalTime;
        }

        public final boolean component9() {
            return this.running;
        }

        public final ContinuousLocationContext copy(a r14, Looper r15, LocationOption r16, BDLocationCallback r17, BDLocation r18, long r19, boolean r21, long r22, boolean r24) {
            return new ContinuousLocationContext(r14, r15, r16, r17, r18, r19, r21, r22, r24);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L4;
            return true;
        L4:
            if ((r8 instanceof ContinuousLocationContext) == false) goto L24;
            ContinuousLocationContext r10 = (ContinuousLocationContext) r8;
            if (i.a(this.manager, r10.manager) == true) goto L8;
            return false;
        L8:
            if (i.a(this.looper, r10.looper) == true) goto L10;
            return false;
        L10:
            if (i.a(this.option, r10.option) == true) goto L12;
            return false;
        L12:
            if (i.a(this.callback, r10.callback) == true) goto L14;
            return false;
        L14:
            if (i.a(this.lastLocation, r10.lastLocation) == true) goto L16;
            return false;
        L16:
            if (this.startTime == r10.startTime) goto L18;
            return false;
        L18:
            if (this.isFirstLocation == r10.isFirstLocation) goto L20;
            return false;
        L20:
            if (this.lastSetUploadNetSignalTime == r10.lastSetUploadNetSignalTime) goto L22;
            return false;
        L22:
            if (this.running == r10.running) goto L37;
            return false;
        L37:
            return true;
        L24:
            return false;
        }

        public final BDLocationCallback getCallback() {
            return this.callback;
        }

        public final BDLocation getLastLocation() {
            return this.lastLocation;
        }

        public final long getLastSetUploadNetSignalTime() {
            return this.lastSetUploadNetSignalTime;
        }

        public final Looper getLooper() {
            return this.looper;
        }

        public final a getManager() {
            return this.manager;
        }

        public final LocationOption getOption() {
            return this.option;
        }

        public final boolean getRunning() {
            return this.running;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        public int hashCode() {
            a r8 = this.manager;
            int r10 = 0;
            if (r8 == null) goto L5;
            int r11 = r8.hashCode();
        L6:
            int r12 = r11 * 31;
            Looper r13 = this.looper;
            if (r13 == null) goto L9;
            int r14 = r13.hashCode();
        L10:
            int r15 = (r12 + r14) * 31;
            LocationOption r16 = this.option;
            if (r16 == null) goto L13;
            int r17 = r16.hashCode();
        L14:
            int r18 = (r15 + r17) * 31;
            BDLocationCallback r19 = this.callback;
            if (r19 == null) goto L17;
            int r20 = r19.hashCode();
        L18:
            int r21 = (r18 + r20) * 31;
            BDLocation r22 = this.lastLocation;
            if (r22 == null) goto L21;
            r10 = r22.hashCode();
        L21:
            int r23 = (r21 + r10) * 31;
            long r24 = this.startTime;
            int r25 = (r23 + ((int) (r24 ^ (r24 >>> 32)))) * 31;
            boolean r26 = this.isFirstLocation;
            ?? r27 = 1;
            ?? r28 = r26;
            if (r26 == false) goto L24;
            r28 = 1;
        L24:
            long r29 = this.lastSetUploadNetSignalTime;
            int r30 = (((r25 + r28) * 31) + ((int) (r29 ^ (r29 >>> 32)))) * 31;
            boolean r31 = this.running;
            if (r31 == true) goto L29;
            r27 = r31;
        L29:
            return r30 + r27;
        L17:
            r20 = 0;
            goto L18
        L13:
            r17 = 0;
            goto L14
        L9:
            r14 = 0;
            goto L10
        L5:
            r11 = 0;
            goto L6
        }

        public final boolean isFirstLocation() {
            return this.isFirstLocation;
        }

        public final void setCallback(BDLocationCallback r8) {
            this.callback = r8;
        }

        public final void setFirstLocation(boolean r8) {
            this.isFirstLocation = r8;
        }

        public final void setLastLocation(BDLocation r8) {
            this.lastLocation = r8;
        }

        public final void setLastSetUploadNetSignalTime(long r8) {
            this.lastSetUploadNetSignalTime = r8;
        }

        public final void setLooper(Looper r8) {
            this.looper = r8;
        }

        public final void setManager(a r8) {
            this.manager = r8;
        }

        public final void setOption(LocationOption r8) {
            this.option = r8;
        }

        public final void setRunning(boolean r8) {
            this.running = r8;
        }

        public final void setStartTime(long r8) {
            this.startTime = r8;
        }

        public String toString() {
            return "ContinuousLocationContext(manager=" + this.manager + ", looper=" + this.looper + ", option=" + this.option + ", callback=" + this.callback + ", lastLocation=" + this.lastLocation + ", startTime=" + this.startTime + ", isFirstLocation=" + this.isFirstLocation + ", lastSetUploadNetSignalTime=" + this.lastSetUploadNetSignalTime + ", running=" + this.running + ")";
        }

        public ContinuousLocationContext(a r8, Looper r10, LocationOption r11, BDLocationCallback r12, BDLocation r13, long r14, boolean r15, long r16, boolean r17) {
            this.manager = r8;
            this.looper = r10;
            this.option = r11;
            this.callback = r12;
            this.lastLocation = r13;
            this.startTime = r14;
            this.isFirstLocation = r15;
            this.lastSetUploadNetSignalTime = r16;
            this.running = r17;
        }

        public /* synthetic */ ContinuousLocationContext(a r8, Looper r10, LocationOption r11, BDLocationCallback r12, BDLocation r13, long r14, boolean r15, long r16, boolean r17, int r18, e r19) {
            if ((r18 & 1) == 0) goto L6;
            r8 = null;
        L6:
            if ((r18 & 2) == 0) goto L9;
            r10 = null;
        L9:
            if ((r18 & 4) == 0) goto L12;
            r11 = null;
        L12:
            if ((r18 & 8) == 0) goto L15;
            r12 = null;
        L15:
            if ((r18 & 16) == 0) goto L18;
            r13 = null;
        L18:
            if ((r18 & 32) == 0) goto L21;
            r14 = 0;
        L21:
            if ((r18 & 64) == 0) goto L24;
            r15 = true;
        L24:
            if ((r18 & 128) == 0) goto L27;
            r16 = 0;
        L27:
            if ((r18 & 256) == 0) goto L29;
            r17 = false;
        L29:
            this(r8, r10, r11, r12, r13, r14, r15, r16, r17);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ByteContinuousLocationImpl(Context r8) {
        super(r8);
        this.mLock = new Object();
        this.mIsFirstLocation = true;
        this.mContinuousClients = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMContinuousClients$p(ByteContinuousLocationImpl r8) {
        return r8.mContinuousClients;
    }

    public static final /* synthetic */ long access$getMLastSetUploadNetSignalTime$p(ByteContinuousLocationImpl r8) {
        return r8.mLastSetUploadNetSignalTime;
    }

    public static final /* synthetic */ void access$onErrorLegacy(ByteContinuousLocationImpl r8, String r10, LocationOption r11, String r12, BDLocationCallback r13) {
        r8.onErrorLegacy(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void access$onErrorMulti(ByteContinuousLocationImpl r8, String r10, String r11, LocationOption r12, String r13, BDLocationCallback r14) {
        r8.onErrorMulti(r10, r11, r12, r13, r14);
    }

    public static final /* synthetic */ void access$onSuccessLegacy(ByteContinuousLocationImpl r8, a.AbstractC0030a.b r10, LocationOption r11, BDLocationCallback r12) {
        r8.onSuccessLegacy(r10, r11, r12);
    }

    public static final /* synthetic */ void access$onSuccessMulti(ByteContinuousLocationImpl r8, String r10, a.AbstractC0030a.b r11, LocationOption r12, BDLocationCallback r13) {
        r8.onSuccessMulti(r10, r11, r12, r13);
    }

    public static final /* synthetic */ void access$setMLastSetUploadNetSignalTime$p(ByteContinuousLocationImpl r8, long r10) {
        r8.mLastSetUploadNetSignalTime = r10;
    }

    private final void onError(String r8, LocationOption r10, String r11, BDLocationCallback r12) {
        BDLocationException r13 = new BDLocationException(r8, getLocateName(), r11);
        uploadMonitorLegacy(null, r10, r11, r8);
        if (r12 == null) goto L6;
        r12.onError(r13);
        return;
    }

    private final void onErrorLegacy(String r8, LocationOption r10, String r11, BDLocationCallback r12) {
        BDLocationException r13 = new BDLocationException(r8, getLocateName(), r11);
        uploadMonitorLegacy(null, r10, r11, r8);
        if (r12 == null) goto L6;
        r12.onError(r13);
        return;
    }

    private final void onErrorMulti(String r10, String r11, LocationOption r12, String r13, BDLocationCallback r14) {
        BDLocationException r8 = new BDLocationException(r11, getLocateName(), r13);
        uploadMonitorMulti(r10, null, r12, r13, r11);
        if (r14 == null) goto L6;
        r14.onError(r8);
        return;
    }

    private final void onSuccessLegacy(a.AbstractC0030a.b r8, LocationOption r10, BDLocationCallback r11) {
        Location r12 = r8.f3024a;     // Catch: Exception -> L6
        int r13 = r8.f3025b;     // Catch: Exception -> L6
        if (r12 == null) goto L8;
        String r14 = r12.getProvider();     // Catch: Exception -> L6
    L9:
        Logger.i("location locationType: " + r13 + " - provider: " + r14);     // Catch: Exception -> L6
        BDLocation r15 = transform(r12, r13);     // Catch: Exception -> L6
        if (r15 != null) goto L13;
        onError("location is null", r10, BDLocationException.ERROR_UNKNOWN, r11);     // Catch: Exception -> L6
        return;
    L13:
        this.mLastLocation = r15;     // Catch: Exception -> L6
        uploadMonitorLegacy(r15, r10, BDLocationException.SUCCESS, "success");     // Catch: Exception -> L6
        if (r11 == null) goto L20;
        r11.onLocationChanged(r15);     // Catch: Exception -> L6
        return;
    L20:
        return;
    L8:
        r14 = null;
    L6:
        e = move-exception;
        Logger.e("onSuccessLegacy error:", e);
        onError("onSuccessLegacy error", r10, BDLocationException.ERROR_UNKNOWN, r11);
    }

    private final void onSuccessMulti(String r10, a.AbstractC0030a.b r11, LocationOption r12, BDLocationCallback r13) {
        Location r8 = r11.f3024a;     // Catch: Exception -> L6
        int r14 = r11.f3025b;     // Catch: Exception -> L6
        if (r8 == null) goto L8;
        String r15 = r8.getProvider();     // Catch: Exception -> L6
    L9:
        Logger.i("location locationType: " + r14 + " - provider: " + r15 + ", businessId: " + r10);     // Catch: Exception -> L6
        BDLocation r16 = transform(r8, r14);     // Catch: Exception -> L6
        if (r16 != null) goto L13;
        onError("location is null", r12, BDLocationException.ERROR_UNKNOWN, r13);     // Catch: Exception -> L6
        return;
    L13:
        ContinuousLocationContext r17 = this.mContinuousClients.get(r10);     // Catch: Exception -> L6
        if (r17 == null) goto L16;
        r17.setLastLocation(r16);     // Catch: Exception -> L6
        uploadMonitorMulti(r10, r16, r12, BDLocationException.SUCCESS, "success");     // Catch: Exception -> L6
    L16:
        if (r13 == null) goto L22;
        r13.onLocationChanged(r16);     // Catch: Exception -> L6
        return;
    L22:
        return;
    L8:
        r15 = null;
    L6:
        e = move-exception;
        Logger.e("onSuccessMulti error:", e);
        onError("onSuccessMulti error", r12, BDLocationException.ERROR_UNKNOWN, r13);
    }

    private final void startLocationLegacy(BDLocationCallback r8, LocationOption r10, Looper r11) {
        Object r12 = this.mLock;     // Catch: Exception -> L28
        monitor-enter(r12);     // Catch: Exception -> L28
        this.mLocationLooper = r11;     // Catch: Throwable -> L25
        this.mOption = r10;     // Catch: Throwable -> L25
        this.mCallback = r8;     // Catch: Throwable -> L25
        this.mIsFirstLocation = true;     // Catch: Throwable -> L25
        this.mLastLocationStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L25
        super.startLocation(r8, r10, r11);     // Catch: Throwable -> L25
        if (LocationUtil.isLocationEnabled() == true) goto L10;
        BDLocationException r13 = new BDLocationException("location service is disabled, please enable it in settings", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);     // Catch: Throwable -> L25
        if (r8 == null) goto L22;
    L8:
        r8.onError(r13);     // Catch: Throwable -> L25
    L22:
        j r14 = j.f13877a;     // Catch: Throwable -> L25
        monitor-exit(r12);     // Catch: Exception -> L28
        return;
    L10:
        if (LocationUtil.checkBackground() == false) goto L14;
        if (r8 == null) goto L22;
        r13 = new BDLocationException("application is in background, not allow to locate", getLocateName(), BDLocationException.ERROR_BACKGROUND_LOCATE);     // Catch: Throwable -> L25
        goto L8
    L14:
        if (this.mContext != null) goto L18;
        r13 = new BDLocationException("mContext is null", getLocateName(), BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT);     // Catch: Throwable -> L25
        if (r8 == null) goto L22;
    L18:
        a r15 = this.mLocationManager;     // Catch: Throwable -> L25
        if (r15 == null) goto L21;
        r15.c();     // Catch: Throwable -> L25
    L21:
        Context r16 = this.mContext;     // Catch: Throwable -> L25
        i.b(r16, "mContext");     // Catch: Throwable -> L25
        a r17 = new a(r16, r10, r11, new ByteContinuousLocationImpl$startLocationLegacy$$inlined$synchronized$lambda$1(this, r11, r10, r8));     // Catch: Throwable -> L25
        this.mLocationManager = r17;     // Catch: Throwable -> L25
        r17.b();     // Catch: Throwable -> L25
        this.mLocationRunning = true;     // Catch: Throwable -> L25
        Logger.i("ByteContinuousLocationImpl startLocationLegacy completed");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;     // Catch: Exception -> L28
    L28:
        e = move-exception;
        Logger.e("startLocation error:", e);
        onError("startLocation error", r10, BDLocationException.ERROR_UNKNOWN, r8);
    }

    private final void startLocationMulti(String r23, BDLocationCallback r24, LocationOption r25, Looper r26) {
        Object r8 = this.mLock;     // Catch: Exception -> L38
        monitor-enter(r8);     // Catch: Exception -> L38
        stopLocationForBusiness(r23);     // Catch: Throwable -> L32
        super.startLocation(r24, r25, r26);     // Catch: Throwable -> L32
        if (LocationUtil.isLocationEnabled() == true) goto L11;
        BDLocationException r10 = new BDLocationException("location service is disabled, please enable it in settings", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);     // Catch: Throwable -> L32
        if (r24 != null) goto L14;
    L15:
        Object r12 = r8;
    L27:
        j r11 = j.f13877a;     // Catch: Throwable -> L30
        monitor-exit(r12);     // Catch: Exception -> L36
        return;
    L30:
        th = th;
    L34:
        monitor-exit(r12);     // Catch: Exception -> L36
        throw th;     // Catch: Exception -> L36
    L14:
        r24.onError(r10);     // Catch: Throwable -> L32
        goto L15
    L11:
        if (LocationUtil.checkBackground() == false) goto L17;
        if (r24 == null) goto L15;
        r10 = new BDLocationException("application is in background, not allow to locate", getLocateName(), BDLocationException.ERROR_BACKGROUND_LOCATE);     // Catch: Throwable -> L32
        goto L14
    L17:
        if (this.mContext != null) goto L21;
        r10 = new BDLocationException("mContext is null", getLocateName(), BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT);     // Catch: Throwable -> L32
        if (r24 == null) goto L15;
    L21:
        ContinuousLocationContext r13 = new ContinuousLocationContext(null, r26, r25, r24, null, SystemClock.elapsedRealtime(), true, 0, false, 17, null);     // Catch: Throwable -> L32
        Context r14 = this.mContext;     // Catch: Throwable -> L32
        i.b(r14, "mContext");     // Catch: Throwable -> L32
        r12 = r8;
        r13.setManager(new a(r14, r25, r26, new ByteContinuousLocationImpl$startLocationMulti$$inlined$synchronized$lambda$1(this, r23, r24, r25, r26)));     // Catch: Throwable -> L30
        a r15 = r13.getManager();     // Catch: Throwable -> L30
        if (r15 == null) goto L26;
        r15.b();     // Catch: Throwable -> L30
    L26:
        r13.setRunning(true);     // Catch: Throwable -> L30
        this.mContinuousClients.put(r23, r13);     // Catch: Throwable -> L30
        Logger.i("ByteContinuousLocationImpl startLocationMulti completed, businessId: " + r23 + ", total clients: " + this.mContinuousClients.size());     // Catch: Throwable -> L30
    L32:
        th = th;
        r12 = r8;
    L36:
        e = e;
    L40:
        Logger.e("startLocationMulti error:", e);
        onError("startLocationMulti error", r25, BDLocationException.ERROR_UNKNOWN, r24);
        return;
    L38:
        e = e;
        goto L40
    }

    private final void stopAllBusinessLocations() {
        Iterator<Map.Entry<String, ContinuousLocationContext>> r8 = this.mContinuousClients.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry<String, ContinuousLocationContext> r10 = r8.next();
        String r11 = r10.getKey();
        stopContextSafely(r10.getValue(), r11);
        goto L4
    L6:
        this.mContinuousClients.clear();
        Logger.i("ByteContinuousLocationImpl stopAllBusinessLocations completed");
    }

    private final void stopContextSafely(ContinuousLocationContext r8, String r10) {
        a r11 = r8.getManager();     // Catch: Exception -> L13
        if (r11 != null) goto L18;
    L9:
        r8.setRunning(false);     // Catch: Exception -> L13
        r8.setManager(null);     // Catch: Exception -> L13
        r8.setLastSetUploadNetSignalTime(0);     // Catch: Exception -> L13
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L20;
        uploadLastLocationForBusiness(r8);     // Catch: Exception -> L13
        return;
    L20:
        return;
    L18:
        r11.c();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Logger.e("stopContextSafely error: " + e.getMessage() + ", businessId: " + r10);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Logger.e("ByteContinuousLocationImpl stopContextSafely error", e);
    }

    @SuppressLint({"WrongConstant"})
    private final BDLocation transform(Location r8, int r10) {
        if (r8 == null) goto L8;
        BDLocation r11 = new BDLocation(r8, getLocateName());
        r11.setLocationType(r10);
        r11.setLocationMs(System.currentTimeMillis());
        r11.setTrustedLevel(1);
        Bundle r12 = r8.getExtras();
        int r13 = 0;
        if (r12 == null) goto L6;
        r13 = r12.getInt("satellites", 0);
    L6:
        r11.setSatellites(r13);
        return r11;
    L8:
        return null;
    }

    private final void uploadLastLocation() {
        if (this.mLastLocation == null) goto L12;
        BDLocationCallback r8 = this.mCallback;
        if (r8 == null) goto L10;
        LocationOption r10 = this.mOption;
        if (r10 == null) goto L9;
        r10.setEnableUploadNetSignal(true);
    L9:
        Logger.i("uploadLastLocation");
        r8.onLocationChanged(this.mLastLocation);
    L10:
        this.mCallback = null;
        return;
    }

    private final void uploadLastLocationForBusiness(ContinuousLocationContext r8) {
        if (r8.getLastLocation() == null) goto L11;
        BDLocationCallback r10 = r8.getCallback();
        if (r10 == null) goto L12;
        LocationOption r11 = r8.getOption();
        if (r11 == null) goto L9;
        r11.setEnableUploadNetSignal(true);
    L9:
        Logger.i("uploadLastLocationForBusiness");
        r10.onLocationChanged(r8.getLastLocation());
        return;
    L12:
        return;
    }

    private final void uploadMonitor(BDLocation r8, LocationOption r10, String r11, String r12) {
        uploadMonitorLegacy(r8, r10, r11, r12);
    }

    private final void uploadMonitorLegacy(BDLocation r17, LocationOption r18, String r19, String r20) {
        long r11 = SystemClock.elapsedRealtime() - this.mLastLocationStartTime;
        StringBuilder r8 = new StringBuilder("uploadMonitorLegacy: ");
        r8.append(r11);
        r8.append("ms, provider: ");
        Integer r10 = null;
        if (r17 == null) goto L5;
        String r12 = r17.getProvider();
    L6:
        r8.append(r12);
        r8.append(", locationType: ");
        if (r17 == null) goto L9;
        r10 = Integer.valueOf(r17.getLocationType());
    L9:
        r8.append(r10);
        r8.append(", mIsFirstLocation: ");
        r8.append(this.mIsFirstLocation);
        Logger.i(r8.toString());
        String r13 = getLocateName();
        if (r18 == null) goto L12;
        boolean r14 = r18.isChineseRegion();
    L13:
        boolean r15 = r14;
        if (r17 == null) goto L16;
        int r16 = r17.getLocationType();
    L17:
        boolean r110 = this.mIsFirstLocation;
        if (r18 == null) goto L22;
        String r21 = r18.getUploadSource();
        if (r21 == null) goto L22;
    L23:
        LocationMonitor.doContinueLocation(r13, r19, r20, r15, r16, BuildConfig.BDLOCATION_VERSION, r11, r110, r21, null);
        this.mLastLocationStartTime = SystemClock.elapsedRealtime();
        this.mIsFirstLocation = false;
        return;
    L22:
        r21 = "unknown";
        goto L23
    L16:
        r16 = 0;
        goto L17
    L12:
        r14 = true;
        goto L13
    L5:
        r12 = null;
        goto L6
    }

    private final void uploadMonitorMulti(String r21, BDLocation r22, LocationOption r23, String r24, String r25) {
        Object r8 = this.mLock;
        monitor-enter(r8);
        ContinuousLocationContext r10 = this.mContinuousClients.get(r21);     // Catch: Throwable -> L31
        if (r10 == null) goto L28;
        long r11 = SystemClock.elapsedRealtime() - r10.getStartTime();     // Catch: Throwable -> L31
        StringBuilder r12 = new StringBuilder("uploadMonitorMulti: ");     // Catch: Throwable -> L31
        r12.append(r11);     // Catch: Throwable -> L31
        r12.append("ms, provider: ");     // Catch: Throwable -> L31
        Integer r13 = null;
        if (r22 == null) goto L9;
        String r14 = r22.getProvider();     // Catch: Throwable -> L31
    L10:
        r12.append(r14);     // Catch: Throwable -> L31
        r12.append(", locationType: ");     // Catch: Throwable -> L31
        if (r22 == null) goto L13;
        r13 = Integer.valueOf(r22.getLocationType());     // Catch: Throwable -> L31
    L13:
        r12.append(r13);     // Catch: Throwable -> L31
        r12.append(", isFirstLocation: ");     // Catch: Throwable -> L31
        r12.append(r10.isFirstLocation());     // Catch: Throwable -> L31
        r12.append(", businessId: ");     // Catch: Throwable -> L31
        r12.append(r21);     // Catch: Throwable -> L31
        Logger.i(r12.toString());     // Catch: Throwable -> L31
        String r15 = getLocateName();     // Catch: Throwable -> L31
        if (r23 == null) goto L16;
        boolean r16 = r23.isChineseRegion();     // Catch: Throwable -> L31
    L17:
        boolean r17 = r16;
        if (r22 == null) goto L20;
        int r18 = r22.getLocationType();     // Catch: Throwable -> L31
    L21:
        boolean r19 = r10.isFirstLocation();     // Catch: Throwable -> L31
        if (r23 == null) goto L26;
        String r20 = r23.getUploadSource();     // Catch: Throwable -> L31
        if (r20 == null) goto L26;
    L27:
        LocationMonitor.doContinueLocation(r15, r24, r25, r17, r18, BuildConfig.BDLOCATION_VERSION, r11, r19, r20, null);     // Catch: Throwable -> L31
        r10.setStartTime(SystemClock.elapsedRealtime());     // Catch: Throwable -> L31
        r10.setFirstLocation(false);     // Catch: Throwable -> L31
    L26:
        r20 = "unknown";
        goto L27
    L20:
        r18 = 0;
        goto L21
    L16:
        r16 = true;
        goto L17
    L9:
        r14 = null;
    L28:
        j r26 = j.f13877a;     // Catch: Throwable -> L31
        monitor-exit(r8);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r8, BDPoint r10) {
        return -1.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r8) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return LocationInfoConst.BYTE_CONTINUOUS;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r8, double r10) {
        return false;
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r8, LocationOption r10, Looper r11) {
        if (r10 == null) goto L4;
        String r12 = r10.getBusinessId();
    L5:
        if (r12 != null) goto L7;
    L10:
        boolean r13 = true;
    L11:
        if (r13 == false) goto L14;
        startLocationLegacy(r8, r10, r11);
        return;
    L14:
        startLocationMulti(r12, r8, r10, r11);
        return;
    L7:
        if (r12.length() == 0) goto L10;
        r13 = false;
        goto L11
    L4:
        r12 = null;
        goto L5
    }

    public final void stopAllLocations() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationRunning == false) goto L16;
        a r10 = this.mLocationManager;     // Catch: Throwable -> L19
        if (r10 != null) goto L24;
    L12:
        this.mLocationRunning = false;     // Catch: Throwable -> L19
        this.mLocationManager = null;     // Catch: Throwable -> L19
        this.mLastSetUploadNetSignalTime = 0;     // Catch: Throwable -> L19
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L15;
        uploadLastLocation();     // Catch: Throwable -> L19
    L15:
        this.mLastLocationStartTime = 0;     // Catch: Throwable -> L19
        goto L16
    L24:
        r10.c();     // Catch: Exception -> L10 Throwable -> L19
    L10:
        e = move-exception;
        Logger.e("stopLocation error: " + e.getMessage());     // Catch: Throwable -> L19
    L16:
        stopAllBusinessLocations();     // Catch: Throwable -> L19
        Logger.i("ByteContinuousLocationImpl stopAllLocations (legacy + all multi business)");     // Catch: Throwable -> L19
        j r11 = j.f13877a;     // Catch: Throwable -> L19
        monitor-exit(r8);
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
        Object r8 = this.mLock;
        monitor-enter(r8);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationRunning == true) goto L8;
        String r10 = "location is not running, stopLocation is ignored (legacy mode only)";
    L7:
        Logger.i(r10);     // Catch: Throwable -> L21
        j r11 = j.f13877a;     // Catch: Throwable -> L21
        monitor-exit(r8);
        return;
    L8:
        a r12 = this.mLocationManager;     // Catch: Throwable -> L21
        if (r12 != null) goto L26;
    L14:
        this.mLocationRunning = false;     // Catch: Throwable -> L21
        this.mLocationManager = null;     // Catch: Throwable -> L21
        this.mLastSetUploadNetSignalTime = 0;     // Catch: Throwable -> L21
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L17;
        uploadLastLocation();     // Catch: Throwable -> L21
    L17:
        this.mLastLocationStartTime = 0;     // Catch: Throwable -> L21
        r10 = "ByteContinuousLocationImpl stopLocation (legacy mode only)";
        goto L7
    L26:
        r12.c();     // Catch: Exception -> L12 Throwable -> L21
    L12:
        e = move-exception;
        Logger.e("stopLocation error: " + e.getMessage());     // Catch: Throwable -> L21
        goto L14
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void stopLocationForBusiness(String r8) {
        if (r8 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        Logger.w("ByteContinuousLocationImpl stopLocationForBusiness: businessId is null or empty");
        return;
    L12:
        Object r11 = this.mLock;
        monitor-enter(r11);
        ContinuousLocationContext r12 = this.mContinuousClients.remove(r8);     // Catch: Throwable -> L22
        if (r12 == null) goto L18;
        stopContextSafely(r12, r8);     // Catch: Throwable -> L22
        String r13 = "ByteContinuousLocationImpl stopLocationForBusiness: " + r8 + ", remaining clients: " + this.mContinuousClients.size();     // Catch: Throwable -> L22
    L17:
        Logger.i(r13);     // Catch: Throwable -> L22
        j r14 = j.f13877a;     // Catch: Throwable -> L22
        monitor-exit(r11);
        return;
    L18:
        r13 = "ByteContinuousLocationImpl stopLocationForBusiness: businessId not found: " + r8;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L5:
        if (r8.length() == 0) goto L8;
        r10 = false;
        goto L9
    }
}
