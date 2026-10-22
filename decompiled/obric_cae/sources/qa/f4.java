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
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f4 {
    public static boolean A = false;
    public static volatile AMapLocation B = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static AMapLocation f10415v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static long f10416w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object f10417x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static long f10418y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static boolean f10419z = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f10420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocationManager f10422c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AMapLocationClientOption f10423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10425f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10426g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f10427h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10428i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10429j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10430k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final w2 f10431l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10432m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10433n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AMapLocation f10434o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f10435p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f10436q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Object f10437r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Object f10438s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f10439t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a f10440u;

    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f4 f10441a;

        public a(f4 r8) {
            this.f10441a = r8;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r8) {
            new StringBuilder("tid=").append(Thread.currentThread().getId());     // Catch: Throwable -> L6
            f4 r10 = this.f10441a;     // Catch: Throwable -> L6
            if (r10 == null) goto L9;
            f4.f(r10, r8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r8) {
            f4 r10 = this.f10441a;     // Catch: Throwable -> L9
            if (r10 == null) goto L12;
            AMapLocation r11 = f4.f10415v;     // Catch: Throwable -> L9
            r10.getClass();     // Catch: Throwable -> L9
            if ("network".equalsIgnoreCase(r8) == false) goto L13;
            r10.f10428i = 0;     // Catch: Throwable -> L9
            return;
        L13:
            return;
        L12:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r8) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r8, int r10, Bundle r11) {
            f4 r12 = this.f10441a;     // Catch: Throwable -> L9
            if (r12 == null) goto L12;
            AMapLocation r13 = f4.f10415v;     // Catch: Throwable -> L9
            r12.getClass();     // Catch: Throwable -> L9
            if (r10 == 0) goto L7;
            return;
        L7:
            r12.f10428i = 0;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        }
    }

    static {
        f10417x = new Object();
    }

    public f4(Context r8, x1.e r10) {
        this.f10424e = null;
        this.f10425f = 0;
        this.f10426g = false;
        this.f10427h = 0;
        this.f10428i = 0;
        this.f10429j = false;
        this.f10430k = 0;
        this.f10431l = null;
        this.f10432m = 240;
        this.f10433n = 80;
        this.f10434o = null;
        this.f10435p = 0;
        this.f10436q = 0.0f;
        this.f10437r = new Object();
        this.f10438s = new Object();
        AMapLocationClientOption.e r11 = AMapLocationClientOption.e.f3674a;
        this.f10439t = 0;
        this.f10440u = null;
        this.f10421b = r8;
        this.f10420a = r10;
        this.f10422c = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L5
    L7:
        this.f10431l = new w2();
        return;
    L5:
        th = move-exception;
        t3.g("NetworkLocation", "<init>", th);
        goto L7
    }

    public static void f(f4 r10, Location r11) {
        Handler r8 = r10.f10420a;
        if (r8 == null) goto L5;
        r8.removeMessages(17);
    L5:
        if (r11 == null) goto L98;
        AMapLocation r12 = new AMapLocation(r11);     // Catch: Throwable -> L84
        if (y3.k(r12) == false) goto L97;
        r12.setProvider("network");     // Catch: Throwable -> L84
        r12.f3649z = 12;     // Catch: Throwable -> L84
        if (r10.f10429j == false) goto L13;
    L24:
        r10.k(r12);     // Catch: Throwable -> L84
        if (y3.k(r12) == true) goto L28;
    L42:
        if (y3.k(r12) == false) goto L49;
        r10.f10428i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L84
        Object r13 = f10417x;     // Catch: Throwable -> L84
        monitor-enter(r13);     // Catch: Throwable -> L84
        f10416w = SystemClock.elapsedRealtime();     // Catch: Throwable -> L81
        f10415v = r12.t();     // Catch: Throwable -> L81
        monitor-exit(r13);     // Catch: Throwable -> L81
        r10.f10430k++;     // Catch: Throwable -> L84
        goto L49
    L81:
        th = move-exception;
        throw th;     // Catch: Throwable -> L84
    L49:
        r10.h(r12);     // Catch: Throwable -> L84
        Object r14 = r10.f10437r;     // Catch: Throwable -> L84
        monitor-enter(r14);     // Catch: Throwable -> L84
        AMapLocation r15 = B;     // Catch: Throwable -> L78
        if (r15 != null) goto L54;
    L58:
        monitor-exit(r14);     // Catch: Throwable -> L78
    L93:
    L74:
        th = move-exception;
        t3.g("NetworkLocation", "onLocationChangedLast", th);     // Catch: Throwable -> L84
    L76:
        r10.i(r12);     // Catch: Throwable -> L84
        return;
    L60:
        if (y3.k(r12) == false) goto L76;
        if (r10.f10434o == null) goto L64;
        r10.f10435p = r11.getTime() - r10.f10434o.getTime();     // Catch: Throwable -> L74
        r10.f10436q = y3.a(r10.f10434o, r12);     // Catch: Throwable -> L74
    L64:
        Object r16 = r10.f10438s;     // Catch: Throwable -> L74
        monitor-enter(r16);     // Catch: Throwable -> L74
        r10.f10434o = r12.t();     // Catch: Throwable -> L71
        monitor-exit(r16);     // Catch: Throwable -> L71
    L69:
        r10.f10424e = null;     // Catch: Throwable -> L74
        r10.f10426g = false;     // Catch: Throwable -> L74
        r10.f10425f = 0;     // Catch: Throwable -> L74
    L71:
        th = move-exception;
        throw th;     // Catch: Throwable -> L74
    L54:
        if (r10.f10423d.f3654o == false) goto L58;
        if (y3.a(r12, r15) >= r10.f10432m) goto L58;
        t3.d(r12, r15);     // Catch: Throwable -> L78
    L78:
        th = move-exception;
        throw th;     // Catch: Throwable -> L84
    L28:
        if (r10.f10430k < 3) goto L42;
        if (r12.getAccuracy() >= 0.0f) goto L33;
    L34:
        r12.setAccuracy(0.0f);     // Catch: Throwable -> L84
    L35:
        float r17 = r12.D;     // Catch: Throwable -> L84
        if (r17 >= 0.0f) goto L38;
    L39:
        r12.setSpeed(0.0f);     // Catch: Throwable -> L84
    L40:
        r12 = r10.f10431l.a(r12);     // Catch: Throwable -> L84
        goto L42
    L38:
        if (r17 != Float.MAX_VALUE) goto L40;
    L33:
        if (r12.getAccuracy() != Float.MAX_VALUE) goto L35;
    L13:
        if (y3.k(r12) == false) goto L24;
        Context r18 = r10.f10421b;     // Catch: Throwable -> L84
        long r19 = SystemClock.elapsedRealtime() - r10.f10427h;     // Catch: Throwable -> L84
        boolean r20 = t3.h(r12.A, r12.B);     // Catch: Throwable -> L84
        ArrayList r21 = w3.f11182g;     // Catch: Throwable -> L84
        if (r18 != null) goto L95;
    L23:
        r10.f10429j = true;     // Catch: Throwable -> L84
        goto L24
    L95:
    L21:
        th = move-exception;
        t3.g("ReportUtil", "reportGPSLocUseTime", th);     // Catch: Throwable -> L84
        goto L23
    L17:
        if (s3.f11065b == false) goto L23;
        w3.f(r18, r19, r20, "O015");     // Catch: Throwable -> L21
    L97:
        return;
    L84:
        th = move-exception;
        t3.g("NetworkLocation", "onLocationChanged", th);
        return;
    }

    public static boolean g(LocationManager r8) {
    L14:
        th = move-exception;
        new StringBuilder("NetworkLocation | hasProvider error: ").append(th.getMessage());
        return A;
    L3:
        if (f10419z == true) goto L5;
        List<String> r10 = r8.getAllProviders();     // Catch: Throwable -> L14
        if (r10 != null) goto L9;
    L11:
        A = false;     // Catch: Throwable -> L14
    L12:
        f10419z = true;     // Catch: Throwable -> L14
        return A;
    L9:
        if (r10.size() <= 0) goto L11;
        A = r10.contains("network");     // Catch: Throwable -> L14
        goto L12
    L5:
        return A;
    }

    public final AMapLocation a(AMapLocation r17, String r18) {
        AMapLocation r8 = this.f10434o;
        if (r8 != null) goto L6;
        return r17;
    L6:
        if (this.f10423d.f3653n == true) goto L11;
        if (r8.isMock() == false) goto L11;
        return r17;
    L11:
        if (y3.k(this.f10434o) == true) goto L13;
        return r17;
    L13:
        float r10 = this.f10434o.getSpeed();
        if (r10 != 0.0f) goto L23;
        long r11 = this.f10435p;
        if (r11 <= 0) goto L23;
        if (r11 >= 8) goto L23;
        float r12 = this.f10436q;
        if (r12 <= 0.0f) goto L23;
        r10 = r12 / r11;
    L23:
        if (r17 != null) goto L25;
    L42:
        long r13 = 30000;
    L43:
        long r14 = SystemClock.elapsedRealtime() - this.f10428i;
        if (r14 <= 30000) goto L47;
        return r17;
    L47:
        if (r14 < r13) goto L70;
        if (this.f10426g == true) goto L79;
    L60:
        this.f10424e = null;
        this.f10425f = 0;
        Object r15 = this.f10438s;
        monitor-enter(r15);
        this.f10434o = null;     // Catch: Throwable -> L66
        monitor-exit(r15);     // Catch: Throwable -> L66
        this.f10435p = 0;
        this.f10436q = 0.0f;
        return r17;
    L66:
        th = move-exception;
        throw th;
    L79:
        ArrayList<String> r16 = y3.t(r18);     // Catch: Throwable -> L76
        ArrayList<String> r19 = y3.t(this.f10424e);     // Catch: Throwable -> L76
        if (r16.size() < 8) goto L56;
        if (r19.size() < 8) goto L56;
        boolean r20 = y3.n(this.f10424e, r18);     // Catch: Throwable -> L76
    L57:
        if (r20 == false) goto L60;
        AMapLocation r21 = this.f10434o.t();
        r21.R = 3;
        return r21;
    L56:
        r20 = false;
        goto L57
    L70:
        if (this.f10424e == null) goto L72;
    L74:
        AMapLocation r22 = this.f10434o.t();
        r22.R = 2;
        return r22;
    L72:
        if (this.f10425f < 2) goto L74;
        this.f10424e = r18;
        goto L74
    L25:
        if (y3.k(r17) == false) goto L42;
        if (r17.getAccuracy() >= 200.0f) goto L37;
        int r110 = this.f10425f + 1;
        this.f10425f = r110;
        if (this.f10424e != null) goto L33;
        if (r110 < 2) goto L33;
        this.f10426g = true;
    L33:
        if (r10 <= 5.0f) goto L35;
        r13 = 10000;
        goto L43
    L35:
        r13 = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        goto L43
    L37:
        if (TextUtils.isEmpty(this.f10424e) == true) goto L40;
        this.f10426g = false;
        this.f10425f = 0;
    L40:
        if (r10 <= 5.0f) goto L42;
        r13 = 20000;
        goto L43
    }

    public final void b() {
        LocationManager r8 = this.f10422c;
        if (r8 != null) goto L16;
        return;
    L16:
        a r10 = this.f10440u;     // Catch: Throwable -> L14
        if (r10 == null) goto L18;
        r8.removeUpdates(r10);     // Catch: Throwable -> L14
        this.f10440u.f10441a = null;     // Catch: Throwable -> L14
        this.f10440u = null;     // Catch: Throwable -> L14
    L18:
        Handler r11 = this.f10420a;     // Catch: Throwable -> L15
        if (r11 == null) goto L12;
        r11.removeMessages(17);     // Catch: Throwable -> L15
    L12:
        this.f10427h = 0;
        this.f10439t = 0;
        this.f10428i = 0;
        this.f10430k = 0;
        this.f10431l.b();
        this.f10434o = null;
        this.f10435p = 0;
        this.f10436q = 0.0f;
        this.f10424e = null;
    }

    public final void c(long r8, int r10, int r11, String r12) {
        Handler r13 = this.f10420a;
        if (r13 == null) goto L11;
        if (this.f10423d.f3657r != AMapLocationClientOption.b.f3666a) goto L12;
        Message r14 = Message.obtain();     // Catch: Throwable -> L8
        AMapLocation r15 = new AMapLocation("");     // Catch: Throwable -> L8
        r15.setProvider("network");     // Catch: Throwable -> L8
        r15.v(r11);     // Catch: Throwable -> L8
        r15.f3648y = r12;     // Catch: Throwable -> L8
        r15.f3649z = 12;     // Catch: Throwable -> L8
        r14.obj = r15;     // Catch: Throwable -> L8
        r14.what = r10;     // Catch: Throwable -> L8
        r13.sendMessageDelayed(r14, r8);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public final void d(Bundle r8) {
        if (r8 == null) goto L20;
        r8.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.f10432m = r8.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.f10433n = r8.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r10 = (AMapLocation) r8.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r10.f3638o) == true) goto L21;
        Object r11 = this.f10437r;     // Catch: Throwable -> L13
        monitor-enter(r11);     // Catch: Throwable -> L13
        B = r10;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        t3.g("NetworkLocation", "setLastGeoLocation", th);
        return;
    }

    public final void e(AMapLocationClientOption r16) {
        Context r8 = this.f10421b;
        this.f10423d = r16;
        if (r16 != null) goto L45;
        this.f10423d = new AMapLocationClientOption();
    L45:
        f10418y = x3.b(r8, "pref", "lagt", f10418y);     // Catch: Throwable -> L41
    L6:
        LocationManager r10 = this.f10422c;
        if (r10 != null) goto L47;
        return;
    L47:
        j();     // Catch: Throwable -> L36 SecurityException -> L38
        Looper r11 = Looper.myLooper();     // Catch: Throwable -> L36 SecurityException -> L38
        if (r11 != null) goto L13;
        r11 = r8.getMainLooper();     // Catch: Throwable -> L36 SecurityException -> L38
    L13:
        Looper r12 = r11;
        this.f10427h = SystemClock.elapsedRealtime();     // Catch: Throwable -> L36 SecurityException -> L38
        if (g(r10) == true) goto L43;
        c(0, 17, 13, "no network provider#1402");     // Catch: Throwable -> L36 SecurityException -> L38
        return;
    L43:
    L22:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L36 SecurityException -> L38
    L25:
        if (this.f10440u != null) goto L28;
        this.f10440u = new a(this);     // Catch: Throwable -> L36 SecurityException -> L38
    L28:
        if (this.f10423d.f3657r.equals(AMapLocationClientOption.b.f3666a) == false) goto L32;
        AMapLocationClientOption r13 = this.f10423d;     // Catch: Throwable -> L36 SecurityException -> L38
        float r14 = r13.J;     // Catch: Throwable -> L36 SecurityException -> L38
        if (r14 <= 0.0f) goto L32;
        float r15 = r14;
        long r17 = r13.f3650a;     // Catch: Throwable -> L36 SecurityException -> L38
        a r18 = this.f10440u;     // Catch: Throwable -> L36 SecurityException -> L38
    L33:
        r10.requestLocationUpdates("network", r17, r15, r18, r12);     // Catch: Throwable -> L36 SecurityException -> L38
        c(this.f10423d.f3651b, 17, 13, "no enough satellites#1401");     // Catch: Throwable -> L36 SecurityException -> L38
        return;
    L32:
        r18 = this.f10440u;     // Catch: Throwable -> L36 SecurityException -> L38
        r15 = 0.0f;
        r17 = 900;
        goto L33
    L16:
        if ((System.currentTimeMillis() - f10418y) >= 259200000) goto L18;
    L42:
        goto L25
    L18:
        if (y3.y(r8, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L20;
        r10.sendExtraCommand(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, "force_xtra_injection", null);     // Catch: Throwable -> L22
        f10418y = System.currentTimeMillis();     // Catch: Throwable -> L22
        SharedPreferences.Editor r19 = x3.c(r8, "pref");     // Catch: Throwable -> L22
        x3.g(r19, "lagt", f10418y);     // Catch: Throwable -> L22
        x3.e(r19);     // Catch: Throwable -> L22
        goto L42
    L20:
        t3.g("OPENSDK_GL", "rlu_n_alec", new Exception("n_alec"));     // Catch: Throwable -> L22
    L38:
        e = move-exception;
        w3.a(2121, null);
        c(0, 15, 12, e.getMessage() + "#1201");
        return;
    L36:
        th = move-exception;
        th.getMessage();
        t3.g("NetworkLocation", "requestLocationUpdates part2", th);
    }

    public final void h(AMapLocation r10) {
        if (y3.k(r10) == true) goto L6;
        return;
    L6:
        if (this.f10420a == null) goto L25;
        long r8 = SystemClock.elapsedRealtime();
        long r11 = this.f10423d.f3650a;
        if (r11 > 8000) goto L10;
    L11:
        Bundle r12 = new Bundle();
        r12.putDouble("lat", r10.getLatitude());
        r12.putDouble("lon", r10.getLongitude());
        r12.putFloat("radius", r10.getAccuracy());
        r12.putLong("time", r10.getTime());
        Message r13 = Message.obtain();
        r13.setData(r12);
        r13.what = 14;
        Object r14 = this.f10437r;
        monitor-enter(r14);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (B != null) goto L18;
        Handler r15 = this.f10420a;     // Catch: Throwable -> L22
    L16:
        r15.sendMessage(r13);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r14);     // Catch: Throwable -> L22
        return;
    L18:
        if (y3.a(r10, B) <= this.f10433n) goto L20;
        r15 = this.f10420a;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r8 - this.f10439t) > (r11 - 8000)) goto L11;
        return;
    }

    public final void i(AMapLocation r10) {
        if (r10.f3646w == 15) goto L5;
    L7:
        boolean r8 = this.f10423d.f3657r.equals(AMapLocationClientOption.b.f3666a);
        Handler r11 = this.f10420a;
        if (r8 == false) goto L15;
        if (this.f10423d.J <= 0.0f) goto L15;
        if (r11 == null) goto L20;
        Message r12 = Message.obtain();
        r12.obj = r10;
        r12.what = 15;
        r11.sendMessage(r12);
        return;
    L20:
        return;
    L15:
        if ((SystemClock.elapsedRealtime() - this.f10439t) < (this.f10423d.f3650a - 200)) goto L21;
        this.f10439t = SystemClock.elapsedRealtime();
        if (r11 == null) goto L22;
        Message r13 = Message.obtain();
        r13.obj = r10;
        r13.what = 15;
        r11.sendMessage(r13);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (AMapLocationClientOption.b.f3666a.equals(this.f10423d.f3657r) == true) goto L7;
    }

    public final void j() {
        if ((SystemClock.elapsedRealtime() - f10416w) <= 5000) goto L5;
        return;
    L5:
        if (y3.k(f10415v) == true) goto L7;
        return;
    L7:
        if (this.f10423d.f3653n == false) goto L9;
    L11:
        this.f10428i = SystemClock.elapsedRealtime();
        i(f10415v);
        return;
    L9:
        if (f10415v.K == false) goto L11;
    }

    public final void k(AMapLocation r10) {
    L11:
        r10.f3645v = false;
        r10.Q = "WGS84";
        return;
    L4:
        if (t3.h(r10.A, r10.B) == true) goto L6;
    L9:
        r10.f3645v = false;     // Catch: Throwable -> L11
        r10.Q = "WGS84";     // Catch: Throwable -> L11
        return;
    L6:
        if (this.f10423d.f3660u == false) goto L9;
        DPoint r8 = u3.b(this.f10421b, new DPoint(r10.A, r10.B));     // Catch: Throwable -> L11
        r10.A = r8.f3678b;     // Catch: Throwable -> L11
        r10.B = r8.f3677a;     // Catch: Throwable -> L11
        r10.f3645v = this.f10423d.f3660u;     // Catch: Throwable -> L11
        r10.Q = "GCJ02";     // Catch: Throwable -> L11
    }
}
