package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.loc.es;
import com.obric.cae.cloud.CloudServiceConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class z3 {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static long f11266p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f11267q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f11268r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f11269s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f11270t = false;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile AMapLocation f11271u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f11272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w2 f11275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f11278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f11279h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11280i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11281j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LocationManager f11282k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AMapLocationClientOption f11283l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f11284m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AMapLocationClientOption.e f11285n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f11286o;

    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public z3 f11287a;

        public a(z3 r8) {
            this.f11287a = r8;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r8) {
            z3 r10 = this.f11287a;     // Catch: Throwable -> L6
            if (r10 == null) goto L9;
            z3.e(r10, r8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r8) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r8) {
            CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r8);
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r8, int r10, Bundle r11) {
        }
    }

    public z3(Context r8, x1.e r10) {
        this.f11272a = 0;
        this.f11273b = false;
        this.f11274c = 0;
        this.f11275d = null;
        this.f11276e = 240;
        this.f11277f = 80;
        this.f11280i = 0;
        this.f11281j = 0;
        this.f11284m = new Object();
        this.f11285n = AMapLocationClientOption.e.f3674a;
        this.f11286o = null;
        this.f11279h = r8;
        this.f11278g = r10;
        this.f11282k = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L5
    L7:
        this.f11275d = new w2();
        return;
    L5:
        th = move-exception;
        t3.g("CoarseLocation", "<init>", th);
        goto L7
    }

    public static void e(z3 r12, Location r13) {
        Handler r8 = r12.f11278g;
        if (r8 == null) goto L5;
        r8.removeMessages(100);
    L5:
        if (r13 == null) goto L111;
        AMapLocation r10 = new AMapLocation(r13);     // Catch: Throwable -> L96
        if (y3.k(r10) == true) goto L11;
        return;
    L11:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r13.getProvider()) == false) goto L13;
        String r11 = "gps_coarse";
    L14:
        r10.setProvider(r11);     // Catch: Throwable -> L96
        r10.f3649z = 11;     // Catch: Throwable -> L96
        if (r12.f11273b == false) goto L17;
    L28:
        Boolean r14 = Boolean.FALSE;     // Catch: Throwable -> L96
        boolean r15 = false;
        Boolean r16 = (Boolean) l6.a.g(r13, "isFromMockProvider", new Object[0]);     // Catch: Throwable -> L99
        "CoarseLocation | isFromMock=".concat(String.valueOf(r16));     // Catch: Throwable -> L33
    L36:
        if (r16.booleanValue() == false) goto L43;
        r10.K = true;     // Catch: Throwable -> L96
        r10.R = 4;     // Catch: Throwable -> L96
        if (r12.f11283l.f3653n == true) goto L44;
        int r17 = r12.f11281j;     // Catch: Throwable -> L96
        if (r17 <= 3) goto L42;
        w3.a(2152, null);     // Catch: Throwable -> L96
        r10.v(15);     // Catch: Throwable -> L96
        r10.f3648y = "CoarseLocation has been mocked!#2007";     // Catch: Throwable -> L96
        r10.A = 0.0d;     // Catch: Throwable -> L96
        r10.B = 0.0d;     // Catch: Throwable -> L96
        r10.setAltitude(0.0d);     // Catch: Throwable -> L96
        r10.setSpeed(0.0f);     // Catch: Throwable -> L96
        r10.setAccuracy(0.0f);     // Catch: Throwable -> L96
        r10.setBearing(0.0f);     // Catch: Throwable -> L96
        r10.setExtras(null);     // Catch: Throwable -> L96
    L91:
        r12.i(r10);     // Catch: Throwable -> L96
        return;
    L42:
        r12.f11281j = r17 + 1;     // Catch: Throwable -> L96
        return;
    L44:
        Bundle r18 = r13.getExtras();     // Catch: Throwable -> L96
        if (r18 == null) goto L47;
        int r19 = r18.getInt("satellites");     // Catch: Throwable -> L96
    L48:
        r10.H = r19;     // Catch: Throwable -> L96
        r12.j(r10);     // Catch: Throwable -> L96
        if (y3.k(r10) == true) goto L52;
    L61:
        if (y3.k(r10) == true) goto L64;
    L78:
        if (y3.k(r10) == false) goto L81;
        r12.f11274c++;     // Catch: Throwable -> L96
    L81:
        r12.g(r10);     // Catch: Throwable -> L96
        Object r110 = r12.f11284m;     // Catch: Throwable -> L96
        monitor-enter(r110);     // Catch: Throwable -> L96
        AMapLocation r20 = f11271u;     // Catch: Throwable -> L93
        if (r20 != null) goto L86;
    L90:
        monitor-exit(r110);     // Catch: Throwable -> L93
    L86:
        if (r12.f11283l.f3654o == false) goto L90;
        if (y3.a(r10, r20) >= r12.f11276e) goto L90;
        t3.d(r10, r20);     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        throw th;     // Catch: Throwable -> L96
    L64:
        if (r12.f11274c < 3) goto L78;
        if (r10.getAccuracy() >= 0.0f) goto L69;
    L70:
        r10.setAccuracy(0.0f);     // Catch: Throwable -> L96
    L71:
        float r111 = r10.D;     // Catch: Throwable -> L96
        if (r111 >= 0.0f) goto L74;
    L75:
        r10.setSpeed(0.0f);     // Catch: Throwable -> L96
    L76:
        r10 = r12.f11275d.a(r10);     // Catch: Throwable -> L96
        goto L78
    L74:
        if (r111 != Float.MAX_VALUE) goto L76;
    L69:
        if (r10.getAccuracy() != Float.MAX_VALUE) goto L71;
    L52:
        if (s3.f11086w == true) goto L54;
    L56:
        if (r15 == false) goto L61;
        long r21 = r10.getTime();     // Catch: Throwable -> L96
        long r22 = System.currentTimeMillis();     // Catch: Throwable -> L96
        long r112 = defpackage.c.g(s3.f11087x, r21, r22);     // Catch: Throwable -> L96
        if (r112 == r21) goto L61;
        r10.setTime(r112);     // Catch: Throwable -> L96
        w3.b(r21, r22);     // Catch: Throwable -> L96
        goto L61
    L54:
        if (s3.f11087x <= 0) goto L56;
        r15 = true;
        goto L56
    L47:
        r19 = 0;
        goto L48
    L43:
        r12.f11281j = 0;     // Catch: Throwable -> L96
    L33:
        r14 = r16;
    L34:
        r16 = r14;
        goto L36
    L17:
        if (y3.k(r10) == false) goto L28;
        Context r23 = r12.f11279h;     // Catch: Throwable -> L96
        long r24 = SystemClock.elapsedRealtime() - r12.f11272a;     // Catch: Throwable -> L96
        boolean r25 = t3.h(r10.A, r10.B);     // Catch: Throwable -> L96
        ArrayList r26 = w3.f11182g;     // Catch: Throwable -> L96
        if (r23 != null) goto L103;
    L27:
        r12.f11273b = true;     // Catch: Throwable -> L96
        goto L28
    L103:
    L25:
        th = move-exception;
        t3.g("ReportUtil", "reportCoarseLocUseTime", th);     // Catch: Throwable -> L96
        goto L27
    L21:
        if (s3.f11065b == false) goto L27;
        w3.f(r23, r24, r25, "O024");     // Catch: Throwable -> L25
    L13:
        r11 = "network_coarse";
    L96:
        th = move-exception;
        t3.g("CoarseLocation", "onLocationChanged", th);
        return;
    }

    public static boolean f(LocationManager r8) {
    L14:
        th = move-exception;
        new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
        return f11268r;
    L3:
        if (f11267q == true) goto L5;
        List<String> r10 = r8.getAllProviders();     // Catch: Throwable -> L14
        if (r10 != null) goto L9;
    L11:
        f11268r = false;     // Catch: Throwable -> L14
    L12:
        f11267q = true;     // Catch: Throwable -> L14
        return f11268r;
    L9:
        if (r10.size() <= 0) goto L11;
        f11268r = r10.contains(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);     // Catch: Throwable -> L14
        goto L12
    L5:
        return f11268r;
    }

    public static boolean h(LocationManager r8) {
    L8:
        th = move-exception;
        new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
        return f11270t;
    L3:
        if (f11269s == true) goto L5;
        boolean r10 = r8.isProviderEnabled("network");     // Catch: Throwable -> L8
        f11270t = r10;     // Catch: Throwable -> L8
        f11269s = true;     // Catch: Throwable -> L8
        return r10;
    L5:
        return f11270t;
    }

    public final void a() {
        LocationManager r8 = this.f11282k;
        if (r8 != null) goto L19;
        return;
    L19:
        a r10 = this.f11286o;     // Catch: Throwable -> L9
        if (r10 == null) goto L17;
        r8.removeUpdates(r10);     // Catch: Throwable -> L9
        this.f11286o.f11287a = null;     // Catch: Throwable -> L9
        this.f11286o = null;     // Catch: Throwable -> L9
    L17:
        Handler r11 = this.f11278g;     // Catch: Throwable -> L16
        if (r11 == null) goto L14;
        r11.removeMessages(100);     // Catch: Throwable -> L16
    L14:
        this.f11272a = 0;
        this.f11280i = 0;
        this.f11274c = 0;
        this.f11281j = 0;
        this.f11275d.b();
        return;
    L9:
        th = move-exception;
        th.getMessage();
        goto L17
    }

    public final void b(int r8, String r10, long r11) {
        Handler r12 = this.f11278g;
        if (r12 == null) goto L9;
        Message r13 = Message.obtain();     // Catch: Throwable -> L6
        AMapLocation r14 = new AMapLocation("");     // Catch: Throwable -> L6
        r14.v(20);     // Catch: Throwable -> L6
        r14.f3648y = r10;     // Catch: Throwable -> L6
        r14.f3649z = 11;     // Catch: Throwable -> L6
        r13.obj = r14;     // Catch: Throwable -> L6
        r13.what = r8;     // Catch: Throwable -> L6
        r12.sendMessageDelayed(r13, r11);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public final void c(Bundle r8) {
        if (r8 == null) goto L20;
        r8.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.f11276e = r8.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.f11277f = r8.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r10 = (AMapLocation) r8.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r10.f3638o) == true) goto L21;
        Object r11 = this.f11284m;     // Catch: Throwable -> L13
        monitor-enter(r11);     // Catch: Throwable -> L13
        f11271u = r10;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        t3.g("CoarseLocation", "setLastGeoLocation", th);
        return;
    }

    public final void d(AMapLocationClientOption r14) {
        Context r8 = this.f11279h;
        this.f11283l = r14;
        if (r14 != null) goto L5;
        this.f11283l = new AMapLocationClientOption();
    L5:
        this.f11283l.toString();
        if (this.f11283l.f3652m == true) goto L9;
        es r15 = new es();
        r15.v(20);
        r15.f3648y = "模糊权限下不支持连续定位#2006";
        i(r15);
        return;
    L9:
        boolean r16 = false;
        boolean r10 = true;
        if (y3.w() < 28) goto L17;
        if (this.f11282k != null) goto L15;
        this.f11282k = (LocationManager) r8.getApplicationContext().getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L73
    L15:
        r10 = ((Boolean) l6.a.g(this.f11282k, "isLocationEnabled", new Object[0])).booleanValue();     // Catch: Throwable -> L73
    L17:
        if (y3.w() < 24) goto L23;
        if (y3.w() >= 28) goto L23;
        if (Settings.Secure.getInt(r8.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) != 0) goto L23;
    L24:
        if (r16 == true) goto L77;
        es r17 = new es();
        r17.v(12);
        r17.f3648y = "定位服务没有开启，请在设置中打开定位服务开关#1206";
        i(r17);
        return;
    L77:
        f11266p = x3.b(r8, "pref", "lagt", f11266p);     // Catch: Throwable -> L72
    L29:
        if (this.f11282k != null) goto L81;
        return;
    L81:
        Looper r11 = Looper.myLooper();     // Catch: Throwable -> L67 SecurityException -> L69
        if (r11 != null) goto L35;
        r11 = r8.getMainLooper();     // Catch: Throwable -> L67 SecurityException -> L69
    L35:
        Looper r12 = r11;
        this.f11272a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L67 SecurityException -> L69
        if (h(this.f11282k) == false) goto L42;
        if (this.f11286o != null) goto L40;
        this.f11286o = new a(this);     // Catch: Throwable -> L67 SecurityException -> L69
    L40:
        LocationManager r13 = this.f11282k;     // Catch: Throwable -> L67 SecurityException -> L69
        AMapLocationClientOption r18 = this.f11283l;     // Catch: Throwable -> L67 SecurityException -> L69
        r13.requestLocationUpdates("network", r18.f3650a, r18.J, this.f11286o, r12);     // Catch: Throwable -> L67 SecurityException -> L69
    L42:
        if (f(this.f11282k) == false) goto L57;
    L50:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L67 SecurityException -> L69
    L53:
        if (this.f11286o != null) goto L55;
        this.f11286o = new a(this);     // Catch: Throwable -> L67 SecurityException -> L69
    L55:
        LocationManager r19 = this.f11282k;     // Catch: Throwable -> L67 SecurityException -> L69
        AMapLocationClientOption r20 = this.f11283l;     // Catch: Throwable -> L67 SecurityException -> L69
        r19.requestLocationUpdates(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r20.f3650a, r20.J, this.f11286o, r12);     // Catch: Throwable -> L67 SecurityException -> L69
        goto L57
    L44:
        if ((System.currentTimeMillis() - f11266p) >= 259200000) goto L46;
    L74:
        goto L53
    L46:
        if (y3.y(r8, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L48;
        this.f11282k.sendExtraCommand(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, "force_xtra_injection", null);     // Catch: Throwable -> L50
        f11266p = System.currentTimeMillis();     // Catch: Throwable -> L50
        SharedPreferences.Editor r21 = x3.c(r8, "pref");     // Catch: Throwable -> L50
        x3.g(r21, "lagt", f11266p);     // Catch: Throwable -> L50
        x3.e(r21);     // Catch: Throwable -> L50
        goto L74
    L48:
        t3.g("OPENSDK_CL", "rlu_n_alec", new Exception("n_alec"));     // Catch: Throwable -> L50
    L57:
        if (f11268r == false) goto L59;
    L60:
        b(100, "系统返回定位结果超时#2002", this.f11283l.f3651b);     // Catch: Throwable -> L67 SecurityException -> L69
    L62:
        if (f11268r == false) goto L64;
        return;
    L64:
        if (f11270t == true) goto L84;
        b(100, "系统定位当前不可用#2003", 0);     // Catch: Throwable -> L67 SecurityException -> L69
    L87:
        return;
    L84:
        return;
    L59:
        if (f11270t == false) goto L62;
    L69:
        e = move-exception;
        w3.a(2121, null);
        b(101, e.getMessage() + "#2004", 0);
        return;
    L67:
        th = move-exception;
        th.getMessage();
        t3.g("CoarseLocation", "requestLocationUpdates part2", th);
        return;
    L23:
        r16 = r10;
        goto L24
    }

    public final void g(AMapLocation r10) {
        if (y3.k(r10) == true) goto L6;
        return;
    L6:
        if (this.f11278g == null) goto L25;
        long r8 = SystemClock.elapsedRealtime();
        long r11 = this.f11283l.f3650a;
        if (r11 > 8000) goto L10;
    L11:
        Bundle r12 = new Bundle();
        r12.putDouble("lat", r10.getLatitude());
        r12.putDouble("lon", r10.getLongitude());
        r12.putFloat("radius", r10.getAccuracy());
        r12.putLong("time", r10.getTime());
        Message r13 = Message.obtain();
        r13.setData(r12);
        r13.what = 102;
        Object r14 = this.f11284m;
        monitor-enter(r14);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (f11271u != null) goto L18;
        Handler r15 = this.f11278g;     // Catch: Throwable -> L22
    L16:
        r15.sendMessage(r13);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r14);     // Catch: Throwable -> L22
        return;
    L18:
        if (y3.a(r10, f11271u) <= this.f11277f) goto L20;
        r15 = this.f11278g;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r8 - this.f11280i) > (r11 - 8000)) goto L11;
        return;
    }

    public final void i(AMapLocation r10) {
        boolean r8 = this.f11283l.f3657r.equals(AMapLocationClientOption.b.f3667b);
        Handler r11 = this.f11278g;
        if (r8 == false) goto L10;
        if (this.f11283l.J <= 0.0f) goto L10;
        if (r11 == null) goto L15;
        Message r12 = Message.obtain();
        r12.obj = r10;
        r12.what = 101;
        r11.sendMessage(r12);
        return;
    L15:
        return;
    L10:
        if ((SystemClock.elapsedRealtime() - this.f11280i) < (this.f11283l.f3650a - 200)) goto L16;
        this.f11280i = SystemClock.elapsedRealtime();
        if (r11 == null) goto L17;
        Message r13 = Message.obtain();
        r13.obj = r10;
        r13.what = 101;
        r11.sendMessage(r13);
        return;
    L17:
        return;
    }

    public final void j(AMapLocation r10) {
    L9:
        th = move-exception;
        r10.f3645v = false;
        r10.Q = "WGS84";
        th.getMessage();
        return;
    L4:
        if (t3.h(r10.A, r10.B) == true) goto L6;
    L11:
        r10.f3645v = false;     // Catch: Throwable -> L9
        r10.Q = "WGS84";     // Catch: Throwable -> L9
        return;
    L6:
        if (this.f11283l.f3660u == false) goto L11;
        DPoint r8 = u3.b(this.f11279h, new DPoint(r10.A, r10.B));     // Catch: Throwable -> L9
        r10.A = r8.f3678b;     // Catch: Throwable -> L9
        r10.B = r8.f3677a;     // Catch: Throwable -> L9
        r10.f3645v = this.f11283l.f3660u;     // Catch: Throwable -> L9
        r10.Q = "GCJ02";     // Catch: Throwable -> L9
    }
}
