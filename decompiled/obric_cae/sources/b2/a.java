package b2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.obric.cae.cloud.CloudServiceConstants;
import ge.l;
import he.i;
import java.util.List;
import xd.h;
import xd.j;
import yd.k;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f3002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f3005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LocationManager f3007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l<? super AbstractC0030a, j> f3008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f3009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Location f3010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile Location f3011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f3012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f3013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f3014m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f3015n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile IBPEALocal f3016o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LocationOption f3017p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Looper f3018q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f3019r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final c f3020s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Object f3021t;

    /* JADX INFO: renamed from: b2.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0030a {

        /* JADX INFO: renamed from: b2.a$a$a, reason: collision with other inner class name */
        public static final class C0031a extends AbstractC0030a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f3022a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f3023b;

            public C0031a(String r8, String r10) {
                this.f3022a = r8;
                this.f3023b = r10;
            }

            public final boolean equals(Object r8) {
                if (this != r8) goto L4;
                return true;
            L4:
                if ((r8 instanceof C0031a) == false) goto L10;
                C0031a r10 = (C0031a) r8;
                String r11 = r10.f3022a;
                if (i.a(this.f3022a, r11) == true) goto L8;
                return false;
            L8:
                if (i.a(this.f3023b, r10.f3023b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                int r8 = 0;
                String r10 = this.f3022a;
                if (r10 == null) goto L5;
                int r11 = r10.hashCode();
            L6:
                int r12 = r11 * 31;
                String r13 = this.f3023b;
                if (r13 == null) goto L10;
                r8 = r13.hashCode();
            L10:
                return r12 + r8;
            L5:
                r11 = 0;
                goto L6
            }

            public final String toString() {
                StringBuilder r8 = new StringBuilder("Failure(reason=");
                r8.append(this.f3022a);
                r8.append(", errorCode=");
                return android.aimedia.a.i(r8, this.f3023b, ")");
            }
        }

        /* JADX INFO: renamed from: b2.a$a$b */
        public static final class b extends AbstractC0030a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Location f3024a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f3025b;

            public b(Location r8, int r10) {
                i.g(r8, LocationMonitorConst.LOCATION);
                this.f3024a = r8;
                this.f3025b = r10;
            }

            public final boolean equals(Object r8) {
                if (this != r8) goto L4;
                return true;
            L4:
                if ((r8 instanceof b) == false) goto L10;
                b r10 = (b) r8;
                Location r11 = r10.f3024a;
                if (i.a(this.f3024a, r11) == true) goto L8;
                return false;
            L8:
                if (this.f3025b == r10.f3025b) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public final int hashCode() {
                Location r8 = this.f3024a;
                if (r8 == null) goto L5;
                int r10 = r8.hashCode();
            L7:
                return (r10 * 31) + this.f3025b;
            L5:
                r10 = 0;
                goto L7
            }

            public final String toString() {
                StringBuilder r8 = new StringBuilder("Success(location=");
                r8.append(this.f3024a);
                r8.append(", locationType=");
                return android.aimedia.a.h(r8, this.f3025b, ")");
            }
        }

        public AbstractC0030a() {
        }
    }

    public static final class b implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f3026a;

        public b(a r8) {
            this.f3026a = r8;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r10) {
            i.g(r10, LocationMonitorConst.LOCATION);
            String r8 = r10.getProvider();
            Logger.i("ContinuousLocationManager onLocationChanged provider: " + r8);
            boolean r11 = false;
            if (i.a(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r8) == false) goto L11;
            Bundle r12 = r10.getExtras();
            if (r12 == null) goto L11;
            if (r12.getBoolean("QUICKGPS", false) == false) goto L11;
            if (BDLocationConfig.isUseQuickGPS() == true) goto L11;
            Logger.i("ContinuousLocationManager onLocationChanged quickGPS");
            r10.setProvider("network");
            r8 = r10.getProvider();
        L11:
            int r13 = 1;
            if (i.a(r8, "network") == false) goto L22;
            Logger.i("ContinuousLocationManager onLocationChanged NETWORK");
            this.f3026a.f3011j = r10;
            long r14 = System.currentTimeMillis();
            this.f3026a.f3013l = r14;
            a r15 = this.f3026a;
            r15.getClass();
            long r16 = System.currentTimeMillis();
            if (r15.f3010i != null) goto L16;
        L18:
            if (r11 == true) goto L25;
            a r17 = this.f3026a;
            if ((r14 - r17.f3014m) < r17.f3004c) goto L26;
            r13 = 4;
        L23:
            a.a(r17, r10, r13);
            return;
        L26:
            return;
        L25:
            return;
        L16:
            if ((r16 - r15.f3012k) >= r15.f3006e) goto L18;
            r11 = true;
            goto L18
        L22:
            Logger.i("ContinuousLocationManager onLocationChanged GPS");
            this.f3026a.f3010i = r10;
            this.f3026a.f3012k = System.currentTimeMillis();
            r17 = this.f3026a;
            goto L23
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r8) {
            i.g(r8, "provider");
            Logger.i("ContinuousLocationManager onProviderDisabled provider: ".concat(r8));
            if (i.a(r8, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == false) goto L6;
            this.f3026a.f3010i = null;
            return;
        L6:
            if (i.a(r8, "network") == false) goto L10;
            this.f3026a.f3011j = null;
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r8) {
            i.g(r8, "provider");
            Logger.i("ContinuousLocationManager onProviderEnabled provider: ".concat(r8));
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r8, int r10, Bundle r11) {
            Logger.i("ContinuousLocationManager onStatusChanged provider: " + r8 + " status: " + r10);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f3027a;

        public c(a r8) {
            this.f3027a = r8;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            if (this.f3027a.f3015n == true) goto L5;
            return;
        L5:
            long r8 = System.currentTimeMillis();
            Logger.i("ContinuousLocationManager periodicRunnable now: " + r8 + ", mLastCallbackTime: " + this.f3027a.f3014m + ", mBackupIntervalMs: " + this.f3027a.f3003b);
            a r10 = this.f3027a;
            if ((r8 - r10.f3014m) < r10.f3003b) goto L38;
            long r11 = System.currentTimeMillis();
            long r12 = System.currentTimeMillis();
            if (r10.f3010i != null) goto L10;
        L12:
            boolean r13 = false;
        L13:
            if (r13 == false) goto L22;
            if (r10.f3010i == null) goto L22;
            if ((r11 - r10.f3012k) >= (BDLocationConfig.getLocationExpiredInterval() + r10.f3004c)) goto L22;
            Location r14 = r10.f3010i;
            if (r14 == null) goto L28;
            xd.d r15 = new xd.d(r14, 1);
        L29:
            r10.f3014m = System.currentTimeMillis();
            if (r15 == null) goto L34;
            l<? super AbstractC0030a, j> r16 = r10.f3008g;
            if (r16 == null) goto L38;
            AbstractC0030a r17 = new AbstractC0030a.b((Location) r15.f13867a, ((Number) r15.f13868b).intValue());
        L37:
            j r18 = r16.invoke(r17);
            goto L38
        L34:
            Logger.i("ContinuousLocationManager deliverBestAvailableResult No location available");
            r16 = r10.f3008g;
            if (r16 == null) goto L38;
            r17 = new AbstractC0030a.C0031a("No location available", BDLocationException.ERROR_NO_LOCATION);
        L28:
            r15 = null;
        L22:
            if (r10.f3011j == null) goto L28;
            if ((r11 - r10.f3013l) >= (BDLocationConfig.getLocationExpiredInterval() + r10.f3004c)) goto L28;
            Location r19 = r10.f3011j;
            if (r19 == null) goto L28;
            r15 = new xd.d(r19, 4);
            goto L29
        L10:
            if ((r12 - r10.f3012k) >= r10.f3006e) goto L12;
            r13 = true;
        L38:
            a r20 = this.f3027a;
            Handler r21 = r20.f3002a;
            if (r21 == null) goto L42;
            r21.postDelayed(this, r20.f3003b);
            return;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f3028a;

        public d(a r8) {
            this.f3028a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l<? super AbstractC0030a, j> r8 = this.f3028a.f3008g;
            if (r8 == null) goto L6;
            j r10 = r8.invoke(new AbstractC0030a.C0031a("GPS and NETWORK Provider unavailable", BDLocationException.ERROR_LOCATION_NO_PROVIDER));
            return;
        }
    }

    public a(Context r10, LocationOption r11, Looper r12, l<? super AbstractC0030a, j> r13) {
        long r8 = 2000;
        this.f3003b = 2000;
        this.f3004c = 1000;
        this.f3006e = 2000;
        this.f3008g = r13;
        int r14 = 2;
        this.f3009h = 2;
        this.f3017p = r11;
        this.f3018q = r12;
        Object r15 = r10.getSystemService(LocationMonitorConst.LOCATION);
        if (r15 == null) goto L37;
        this.f3007f = (LocationManager) r15;
        this.f3016o = BDLocationExtrasService.getBPEAManager();
        if (r12 == null) goto L7;
        Handler r16 = new Handler(r12);
    L8:
        this.f3002a = r16;
        if (r11 == null) goto L11;
        long r17 = r11.getInterval();
    L12:
        this.f3004c = r17;
        if (r17 > 0) goto L15;
        this.f3004c = 1000;
    L15:
        if (r11 == null) goto L17;
        float r18 = r11.getMinUpdateDistance();
    L18:
        this.f3005d = r18;
        if (r18 >= 0) goto L21;
        this.f3005d = 0.0f;
    L21:
        if (r11 == null) goto L23;
        long r19 = r11.getBackupIntervalMs();
    L24:
        this.f3003b = r19;
        long r20 = this.f3004c;
        if (r19 > r20) goto L27;
        this.f3003b = r20 + 1000;
    L27:
        if (r11 == null) goto L29;
        r8 = r11.getGpsTimeoutMs();
    L29:
        this.f3006e = r8;
        long r21 = this.f3004c;
        if (r8 > r21) goto L32;
        this.f3006e = r21 + 1000;
    L32:
        if (r11 == null) goto L34;
        r14 = r11.getMode();
    L34:
        this.f3009h = r14;
        Logger.i("ContinuousLocationManager constructor mMinUpdateIntervalMs: " + this.f3004c + ", mMinUpdateDistance: " + this.f3005d + ", mBackupIntervalMs: " + this.f3003b + ", mGpsTimeoutMs: " + this.f3006e);
        this.f3019r = new b(this);
        this.f3020s = new c(this);
        this.f3021t = new Object();
        return;
    L23:
        r19 = 2000;
        goto L24
    L17:
        r18 = this.f3005d;
        goto L18
    L11:
        r17 = 1000;
        goto L12
    L7:
        r16 = null;
        goto L8
    L37:
        throw new h("null cannot be cast to non-null type android.location.LocationManager");
    }

    public static final void a(a r8, Location r10, int r11) {
        r8.getClass();
    L16:
        e = move-exception;
        Logger.e("ContinuousLocationManager scheduleImmediateCallback", e);
        return;
    L4:
        if (r8.f3015n == false) goto L21;
        Handler r12 = r8.f3002a;     // Catch: Exception -> L16
        if (r12 == null) goto L9;
        r12.removeCallbacksAndMessages(r8.f3021t);     // Catch: Exception -> L16
    L9:
        Handler r13 = r8.f3002a;     // Catch: Exception -> L16
        if (r13 == null) goto L12;
        r13.removeCallbacks(r8.f3020s);     // Catch: Exception -> L16
    L12:
        Handler r14 = r8.f3002a;     // Catch: Exception -> L16
        if (r14 == null) goto L22;
        r14.postAtTime(new b2.b(r8, r10, r11), r8.f3021t, SystemClock.uptimeMillis());     // Catch: Exception -> L16
        return;
    L22:
        return;
    }

    @SuppressLint({"MissingPermission"})
    public final void b() {
        Logger.i("ContinuousLocationManager startLocation isRunning: " + this.f3015n);
    L42:
        e = e;
        boolean r8 = false;
    L44:
        Logger.e("ContinuousLocationManager startLocation exception: " + e);
    L45:
        boolean r10 = r8;
    L46:
        if (r10 == true) goto L51;
        this.f3015n = false;
        Logger.e("ContinuousLocationManager startLocation GPS and NETWORK Provider unavailable");
        Handler r11 = this.f3002a;
        if (r11 == null) goto L59;
        r11.post(new d(this));
        return;
    L59:
        return;
    L51:
        Handler r12 = this.f3002a;
        if (r12 == null) goto L60;
        r12.postDelayed(this.f3020s, BDLocationConfig.getFirstLocationTimeoutMs());
        return;
    L60:
        return;
    L4:
        if (this.f3015n == false) goto L6;
        return;
    L6:
        r10 = true;
        this.f3015n = true;     // Catch: Exception -> L42
        LocationManager r13 = this.f3007f;     // Catch: Exception -> L42
        if (r13 == null) goto L11;
        List<String> r14 = r13.getProviders(true);     // Catch: Exception -> L42
        if (r14 == null) goto L11;
    L12:
        Object r15 = null;
        if (r14.contains(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS) == false) goto L26;
        int r16 = this.f3009h;     // Catch: Exception -> L42
        if (r16 == 2) goto L17;
        if (r16 != 1) goto L26;
    L17:
        IBPEALocal r17 = this.f3016o;     // Catch: Exception -> L42
        if (r17 == null) goto L24;
        LocationManager r18 = this.f3007f;     // Catch: Exception -> L42
        long r19 = this.f3004c;     // Catch: Exception -> L42
        float r110 = this.f3005d;     // Catch: Exception -> L42
        b r111 = this.f3019r;     // Catch: Exception -> L42
        Looper r112 = this.f3018q;     // Catch: Exception -> L42
        LocationOption r20 = this.f3017p;     // Catch: Exception -> L42
        if (r20 == null) goto L22;
        Object r113 = r20.getBpeaCert();     // Catch: Exception -> L42
    L23:
        r17.requestLocationUpdates(r18, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r19, r110, r111, r112, r113);     // Catch: Exception -> L42
        goto L24
    L22:
        r113 = null;
    L24:
        Logger.i("ContinuousLocationManager startLocation GPS Provider started");     // Catch: Exception -> L42
        r8 = true;
    L55:
    L40:
        e = e;
        goto L44
    L28:
        if (r14.contains("network") == false) goto L45;
        int r21 = this.f3009h;     // Catch: Exception -> L40
        if (r21 == 2) goto L32;
        if (r21 != 0) goto L45;
    L32:
        IBPEALocal r22 = this.f3016o;     // Catch: Exception -> L40
        if (r22 == null) goto L38;
        LocationManager r23 = this.f3007f;     // Catch: Exception -> L40
        long r24 = this.f3004c;     // Catch: Exception -> L40
        float r114 = this.f3005d;     // Catch: Exception -> L40
        b r115 = this.f3019r;     // Catch: Exception -> L40
        Looper r116 = this.f3018q;     // Catch: Exception -> L40
        LocationOption r25 = this.f3017p;     // Catch: Exception -> L40
        if (r25 == null) goto L37;
        r15 = r25.getBpeaCert();     // Catch: Exception -> L40
    L37:
        r22.requestLocationUpdates(r23, "network", r24, r114, r115, r116, r15);     // Catch: Exception -> L40
    L38:
        Logger.i("ContinuousLocationManager startLocation NETWORK Provider started");     // Catch: Exception -> L40
    L26:
        r8 = false;
    L11:
        r14 = k.f14119a;     // Catch: Exception -> L42
        goto L12
    }

    @SuppressLint({"MissingPermission"})
    public final void c() {
        this.f3015n = false;     // Catch: Exception -> L14
        Handler r8 = this.f3002a;     // Catch: Exception -> L14
        if (r8 == null) goto L6;
        r8.removeCallbacks(this.f3020s);     // Catch: Exception -> L14
    L6:
        Handler r10 = this.f3002a;     // Catch: Exception -> L14
        if (r10 == null) goto L9;
        r10.removeCallbacksAndMessages(this.f3021t);     // Catch: Exception -> L14
    L9:
        LocationManager r11 = this.f3007f;     // Catch: Exception -> L14
        if (r11 == null) goto L12;
        r11.removeUpdates(this.f3019r);     // Catch: Exception -> L14
    L12:
        this.f3010i = null;     // Catch: Exception -> L14
        this.f3011j = null;     // Catch: Exception -> L14
        this.f3012k = 0;     // Catch: Exception -> L14
        this.f3014m = 0;     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Logger.e("ContinuousLocationManager stopLocation error:", e);
    }
}
