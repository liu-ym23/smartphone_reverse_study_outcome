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
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d4 {
    public static AMapLocation A = null;
    public static long B = 0;
    public static final Object C = null;
    public static long D = 0;
    public static boolean E = false;
    public static boolean F = false;
    public static volatile AMapLocation G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f10307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f10308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocationManager f10309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AMapLocationClientOption f10310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f10312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10313g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10314h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w2 f10315i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10316j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10317k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AMapLocation f10318l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f10319m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f10320n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Object f10321o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Object f10322p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f10323q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c4 f10324r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AMapLocationClientOption.e f10325s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f10326t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10327u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public a f10328v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f10329w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f10330x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10331y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f10332z;

    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d4 f10333a;

        public a(d4 r8) {
            this.f10333a = r8;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r8) {
            new StringBuilder("tid=").append(Thread.currentThread().getId());     // Catch: Throwable -> L6
            d4 r10 = this.f10333a;     // Catch: Throwable -> L6
            if (r10 == null) goto L9;
            d4.e(r10, r8);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r8) {
            d4 r10 = this.f10333a;     // Catch: Throwable -> L9
            if (r10 == null) goto L12;
            AMapLocation r11 = d4.A;     // Catch: Throwable -> L9
            r10.getClass();     // Catch: Throwable -> L9
            if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equalsIgnoreCase(r8) == false) goto L13;
            r10.f10312f = 0;     // Catch: Throwable -> L9
            r10.f10323q = 0;     // Catch: Throwable -> L9
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
            d4 r12 = this.f10333a;     // Catch: Throwable -> L9
            if (r12 == null) goto L12;
            AMapLocation r13 = d4.A;     // Catch: Throwable -> L9
            r12.getClass();     // Catch: Throwable -> L9
            if (r10 == 0) goto L7;
            return;
        L7:
            r12.f10312f = 0;     // Catch: Throwable -> L9
            r12.f10323q = 0;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        }
    }

    static {
        C = new Object();
    }

    public d4(Context r8, x1.e r10) {
        this.f10311e = 0;
        this.f10312f = 0;
        this.f10313g = false;
        this.f10314h = 0;
        this.f10315i = null;
        this.f10316j = 240;
        this.f10317k = 80;
        this.f10318l = null;
        this.f10319m = 0;
        this.f10320n = 0.0f;
        this.f10321o = new Object();
        this.f10322p = new Object();
        this.f10323q = 0;
        this.f10325s = AMapLocationClientOption.e.f3674a;
        this.f10326t = 0;
        this.f10327u = 0;
        this.f10328v = null;
        this.f10329w = null;
        this.f10330x = false;
        this.f10331y = 0;
        this.f10332z = false;
        this.f10308b = r8;
        this.f10307a = r10;
        this.f10309c = (LocationManager) r8.getSystemService(LocationMonitorConst.LOCATION);     // Catch: Throwable -> L5
    L7:
        this.f10315i = new w2();
        return;
    L5:
        th = move-exception;
        t3.g("GpsLocation", "<init>", th);
        goto L7
    }

    public static void e(d4 r14, Location r15) {
        Handler r8 = r14.f10307a;
        if (r8 == null) goto L5;
        r8.removeMessages(8);
    L5:
        if (r15 == null) goto L131;
        AMapLocation r10 = new AMapLocation(r15);     // Catch: Throwable -> L112
        if (y3.k(r10) == false) goto L129;
        r10.setProvider(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);     // Catch: Throwable -> L112
        r10.f3649z = 1;     // Catch: Throwable -> L112
        if (r14.f10313g == true) goto L25;
        if (y3.k(r10) == false) goto L25;
        Context r11 = r14.f10308b;     // Catch: Throwable -> L112
        long r12 = SystemClock.elapsedRealtime() - r14.f10311e;     // Catch: Throwable -> L112
        boolean r13 = t3.h(r10.A, r10.B);     // Catch: Throwable -> L112
        ArrayList r16 = w3.f11182g;     // Catch: Throwable -> L112
        if (r11 != null) goto L127;
    L23:
        r14.f10313g = true;     // Catch: Throwable -> L112
        goto L25
    L127:
    L21:
        th = move-exception;
        t3.g("ReportUtil", "reportGPSLocUseTime", th);     // Catch: Throwable -> L112
        goto L23
    L17:
        if (s3.f11065b == false) goto L23;
        w3.f(r11, r12, r13, "O015");     // Catch: Throwable -> L21
    L25:
        if (y3.j(r10, r14.f10323q) == false) goto L32;
        r10.K = true;     // Catch: Throwable -> L112
        r10.R = 4;     // Catch: Throwable -> L112
        if (r14.f10310d.f3653n == true) goto L33;
        int r17 = r14.f10327u;     // Catch: Throwable -> L112
        if (r17 <= 3) goto L31;
        w3.a(2152, null);     // Catch: Throwable -> L112
        r10.v(15);     // Catch: Throwable -> L112
        r10.f3648y = "GpsLocation has been mocked!#1501";     // Catch: Throwable -> L112
        r10.A = 0.0d;     // Catch: Throwable -> L112
        r10.B = 0.0d;     // Catch: Throwable -> L112
        r10.setAltitude(0.0d);     // Catch: Throwable -> L112
        r10.setSpeed(0.0f);     // Catch: Throwable -> L112
        r10.setAccuracy(0.0f);     // Catch: Throwable -> L112
        r10.setBearing(0.0f);     // Catch: Throwable -> L112
        r10.setExtras(null);     // Catch: Throwable -> L112
    L104:
        r14.j(r10);     // Catch: Throwable -> L112
        return;
    L31:
        r14.f10327u = r17 + 1;     // Catch: Throwable -> L112
        return;
    L33:
        r10.H = r14.f10323q;     // Catch: Throwable -> L112
        r14.k(r10);     // Catch: Throwable -> L112
        int r18 = r14.f10323q;     // Catch: Throwable -> L115
        if (r18 < 4) goto L37;
        r10.J = 1;     // Catch: Throwable -> L115
    L116:
        goto L41
    L37:
        if (r18 != 0) goto L39;
        r10.J = -1;     // Catch: Throwable -> L115
        goto L116
    L39:
        r10.J = 0;     // Catch: Throwable -> L115
    L41:
        if (y3.k(r10) == true) goto L44;
    L54:
        if (y3.k(r10) == true) goto L57;
    L71:
        if (y3.k(r10) == false) goto L78;
        r14.f10312f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L112
        Object r19 = C;     // Catch: Throwable -> L112
        monitor-enter(r19);     // Catch: Throwable -> L112
        B = SystemClock.elapsedRealtime();     // Catch: Throwable -> L109
        A = r10.t();     // Catch: Throwable -> L109
        monitor-exit(r19);     // Catch: Throwable -> L109
        r14.f10314h++;     // Catch: Throwable -> L112
        goto L78
    L109:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112
    L78:
        r14.h(r10);     // Catch: Throwable -> L112
        Object r20 = r14.f10321o;     // Catch: Throwable -> L112
        monitor-enter(r20);     // Catch: Throwable -> L112
        AMapLocation r21 = G;     // Catch: Throwable -> L106
        if (r21 != null) goto L83;
    L87:
        monitor-exit(r20);     // Catch: Throwable -> L106
    L125:
    L102:
        th = move-exception;
        t3.g("GpsLocation", "onLocationChangedLast", th);     // Catch: Throwable -> L112
        goto L104
    L89:
        if (y3.k(r10) == false) goto L104;
        if (r14.f10318l == null) goto L93;
        r14.f10319m = r15.getTime() - r14.f10318l.getTime();     // Catch: Throwable -> L102
        r14.f10320n = y3.a(r14.f10318l, r10);     // Catch: Throwable -> L102
    L93:
        Object r110 = r14.f10322p;     // Catch: Throwable -> L102
        monitor-enter(r110);     // Catch: Throwable -> L102
        r14.f10318l = r10.t();     // Catch: Throwable -> L99
        monitor-exit(r110);     // Catch: Throwable -> L99
        r14.f10329w = null;     // Catch: Throwable -> L102
        r14.f10330x = false;     // Catch: Throwable -> L102
        r14.f10331y = 0;     // Catch: Throwable -> L102
        goto L104
    L99:
        th = move-exception;
        throw th;     // Catch: Throwable -> L102
    L83:
        if (r14.f10310d.f3654o == false) goto L87;
        if (y3.a(r10, r21) >= r14.f10316j) goto L87;
        t3.d(r10, r21);     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        throw th;     // Catch: Throwable -> L112
    L57:
        if (r14.f10314h < 3) goto L71;
        if (r10.getAccuracy() >= 0.0f) goto L62;
    L63:
        r10.setAccuracy(0.0f);     // Catch: Throwable -> L112
    L64:
        float r22 = r10.D;     // Catch: Throwable -> L112
        if (r22 >= 0.0f) goto L67;
    L68:
        r10.setSpeed(0.0f);     // Catch: Throwable -> L112
    L69:
        r10 = r14.f10315i.a(r10);     // Catch: Throwable -> L112
        goto L71
    L67:
        if (r22 != Float.MAX_VALUE) goto L69;
    L62:
        if (r10.getAccuracy() != Float.MAX_VALUE) goto L64;
    L44:
        if (s3.f11086w == true) goto L46;
    L48:
        boolean r23 = false;
    L49:
        if (r23 == false) goto L54;
        long r24 = r10.getTime();     // Catch: Throwable -> L112
        long r111 = System.currentTimeMillis();     // Catch: Throwable -> L112
        long r112 = defpackage.c.g(s3.f11087x, r24, r111);     // Catch: Throwable -> L112
        if (r112 == r24) goto L54;
        r10.setTime(r112);     // Catch: Throwable -> L112
        w3.b(r24, r111);     // Catch: Throwable -> L112
        goto L54
    L46:
        if (s3.f11087x <= 0) goto L48;
        r23 = true;
        goto L49
    L32:
        r14.f10327u = 0;     // Catch: Throwable -> L112
        goto L33
    L129:
        return;
    L112:
        th = move-exception;
        t3.g("GpsLocation", "onLocationChanged", th);
        return;
    }

    public static boolean f(LocationManager r8) {
    L14:
        th = move-exception;
        new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
        return F;
    L3:
        if (E == true) goto L5;
        List<String> r10 = r8.getAllProviders();     // Catch: Throwable -> L14
        if (r10 != null) goto L9;
    L11:
        F = false;     // Catch: Throwable -> L14
    L12:
        E = true;     // Catch: Throwable -> L14
        return F;
    L9:
        if (r10.size() <= 0) goto L11;
        F = r10.contains(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);     // Catch: Throwable -> L14
        goto L12
    L5:
        return F;
    }

    public final AMapLocation a(AMapLocation r17, String r18) {
        AMapLocation r8 = this.f10318l;
        if (r8 != null) goto L6;
        return r17;
    L6:
        if (this.f10310d.f3653n == true) goto L11;
        if (r8.isMock() == false) goto L11;
        return r17;
    L11:
        if (y3.k(this.f10318l) == true) goto L136;
        return r17;
    L136:
        if (y3.k(this.f10318l) == true) goto L18;
    L16:
        AMapLocation r10 = null;
    L52:
        if (r10 != null) goto L54;
    L57:
        float r11 = this.f10318l.getSpeed();
        if (r11 != 0.0f) goto L67;
        long r12 = this.f10319m;
        if (r12 <= 0) goto L67;
        if (r12 >= 8) goto L67;
        float r13 = this.f10320n;
        if (r13 <= 0.0f) goto L67;
        r11 = r13 / r12;
    L67:
        if (r17 != null) goto L69;
    L86:
        long r14 = 30000;
    L87:
        long r15 = SystemClock.elapsedRealtime() - this.f10312f;
        if (r15 <= 30000) goto L91;
        return r17;
    L91:
        if (r15 < r14) goto L114;
        if (this.f10330x == true) goto L124;
    L104:
        this.f10329w = null;
        this.f10331y = 0;
        Object r16 = this.f10322p;
        monitor-enter(r16);
        this.f10318l = null;     // Catch: Throwable -> L110
        monitor-exit(r16);     // Catch: Throwable -> L110
        this.f10319m = 0;
        this.f10320n = 0.0f;
        return r17;
    L110:
        th = move-exception;
        throw th;
    L124:
        ArrayList<String> r19 = y3.t(r18);     // Catch: Throwable -> L120
        ArrayList<String> r20 = y3.t(this.f10329w);     // Catch: Throwable -> L120
        if (r19.size() < 8) goto L100;
        if (r20.size() < 8) goto L100;
        boolean r21 = y3.n(this.f10329w, r18);     // Catch: Throwable -> L120
    L101:
        if (r21 == false) goto L104;
        AMapLocation r22 = this.f10318l.t();
        r22.R = 3;
        return r22;
    L100:
        r21 = false;
        goto L101
    L114:
        if (this.f10329w == null) goto L116;
    L118:
        AMapLocation r23 = this.f10318l.t();
        r23.R = 2;
        return r23;
    L116:
        if (this.f10331y < 2) goto L118;
        this.f10329w = r18;
        goto L118
    L69:
        if (y3.k(r17) == false) goto L86;
        if (r17.getAccuracy() >= 200.0f) goto L81;
        int r24 = this.f10331y + 1;
        this.f10331y = r24;
        if (this.f10329w != null) goto L77;
        if (r24 < 2) goto L77;
        this.f10330x = true;
    L77:
        if (r11 <= 5.0f) goto L79;
        r14 = 10000;
        goto L87
    L79:
        r14 = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        goto L87
    L81:
        if (TextUtils.isEmpty(this.f10329w) == true) goto L84;
        this.f10330x = false;
        this.f10331y = 0;
    L84:
        if (r11 <= 5.0f) goto L86;
        r14 = 20000;
        goto L87
    L54:
        if (y3.k(r10) == false) goto L57;
        r10.R = 2;
        return r10;
    L18:
        if (s3.f11081r == false) goto L16;
        boolean r25 = ((Boolean) l6.a.i(t4.n("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), t4.n("UaXNOYXZpU3RhcnRlZA=="), null, null)).booleanValue();     // Catch: Throwable -> L22
    L23:
        if (r25 == false) goto L50;
        JSONObject r26 = new JSONObject((String) l6.a.i(t4.n("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), t4.n("UZ2V0TmF2aUxvY2F0aW9u"), null, null));     // Catch: Throwable -> L121
        long r27 = r26.optLong("time");     // Catch: Throwable -> L121
        if (this.f10332z == true) goto L28;
        this.f10332z = true;     // Catch: Throwable -> L121
        w3.l("useNaviLoc", "use NaviLoc");     // Catch: Throwable -> L121
    L28:
        if ((System.currentTimeMillis() - r27) > 5500) goto L50;
        double r110 = r26.optDouble("lat", 0.0d);     // Catch: Throwable -> L121
        double r111 = r26.optDouble("lng", 0.0d);     // Catch: Throwable -> L121
        float r28 = Float.parseFloat(r26.optString(LocationMonitorConst.ACCURACY, "0"));     // Catch: NumberFormatException -> L32 Throwable -> L121
    L33:
        double r112 = r26.optDouble("altitude", 0.0d);     // Catch: Throwable -> L121
        float r29 = Float.parseFloat(r26.optString("bearing", "0"));     // Catch: NumberFormatException -> L36 Throwable -> L121
    L126:
        float r30 = (Float.parseFloat(r26.optString("speed", "0")) * 10.0f) / 36.0f;
    L40:
        r10 = new AMapLocation("lbs");     // Catch: Throwable -> L121
        r10.f3649z = 9;     // Catch: Throwable -> L121
        r10.A = r110;     // Catch: Throwable -> L121
        r10.B = r111;     // Catch: Throwable -> L121
        r10.setAccuracy(r28);     // Catch: Throwable -> L121
        r10.setAltitude(r112);     // Catch: Throwable -> L121
        r10.setBearing(r29);     // Catch: Throwable -> L121
        r10.setSpeed(r30);     // Catch: Throwable -> L121
        r10.setTime(r27);     // Catch: Throwable -> L121
        r10.Q = "GCJ02";     // Catch: Throwable -> L121
        if (y3.a(r10, this.f10318l) > 300.0f) goto L50;
        Object r31 = this.f10322p;     // Catch: Throwable -> L121
        monitor-enter(r31);     // Catch: Throwable -> L121
        this.f10318l.setLongitude(r111);     // Catch: Throwable -> L47
        this.f10318l.setLatitude(r110);     // Catch: Throwable -> L47
        this.f10318l.setAccuracy(r28);     // Catch: Throwable -> L47
        this.f10318l.setBearing(r29);     // Catch: Throwable -> L47
        this.f10318l.setSpeed(r30);     // Catch: Throwable -> L47
        this.f10318l.setTime(r27);     // Catch: Throwable -> L47
        this.f10318l.Q = "GCJ02";     // Catch: Throwable -> L47
        monitor-exit(r31);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L121
    L39:
        r30 = 0.0f;
    L36:
        r29 = 0.0f;
    L32:
        r28 = 0.0f;
    L22:
        r25 = false;
    L50:
        r10 = null;
        goto L52
    }

    public final void b(long r8, int r10, int r11, String r12) {
        Handler r13 = this.f10307a;
        if (r13 == null) goto L11;
        if (this.f10310d.f3657r != AMapLocationClientOption.b.f3667b) goto L12;
        Message r14 = Message.obtain();     // Catch: Throwable -> L8
        AMapLocation r15 = new AMapLocation("");     // Catch: Throwable -> L8
        r15.setProvider(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS);     // Catch: Throwable -> L8
        r15.v(r11);     // Catch: Throwable -> L8
        r15.f3648y = r12;     // Catch: Throwable -> L8
        r15.f3649z = 1;     // Catch: Throwable -> L8
        r14.obj = r15;     // Catch: Throwable -> L8
        r14.what = r10;     // Catch: Throwable -> L8
        r13.sendMessageDelayed(r14, r8);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public final void c(Bundle r8) {
        if (r8 == null) goto L20;
        r8.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.f10316j = r8.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.f10317k = r8.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r10 = (AMapLocation) r8.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r10.f3638o) == true) goto L21;
        Object r11 = this.f10321o;     // Catch: Throwable -> L13
        monitor-enter(r11);     // Catch: Throwable -> L13
        G = r10;     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        t3.g("GpsLocation", "setLastGeoLocation", th);
        return;
    }

    public final void d(AMapLocationClientOption r13) {
        LocationManager r8 = this.f10309c;
        Context r10 = this.f10308b;
        this.f10310d = r13;
        if (r13 != null) goto L44;
        this.f10310d = new AMapLocationClientOption();
    L44:
        D = x3.b(r10, "pref", "lagt", D);     // Catch: Throwable -> L40
    L6:
        if (r8 != null) goto L46;
        return;
    L46:
        l();     // Catch: Throwable -> L35 SecurityException -> L37
        Looper r11 = Looper.myLooper();     // Catch: Throwable -> L35 SecurityException -> L37
        if (r11 != null) goto L12;
        r11 = r10.getMainLooper();     // Catch: Throwable -> L35 SecurityException -> L37
    L12:
        Looper r12 = r11;
        this.f10311e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L35 SecurityException -> L37
        if (f(r8) == true) goto L42;
        b(0, 8, 14, "no gps provider#1402");     // Catch: Throwable -> L35 SecurityException -> L37
        return;
    L42:
    L21:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L35 SecurityException -> L37
    L24:
        if (this.f10328v != null) goto L27;
        this.f10328v = new a(this);     // Catch: Throwable -> L35 SecurityException -> L37
    L27:
        if (this.f10310d.f3657r.equals(AMapLocationClientOption.b.f3667b) == false) goto L31;
        AMapLocationClientOption r14 = this.f10310d;     // Catch: Throwable -> L35 SecurityException -> L37
        float r15 = r14.J;     // Catch: Throwable -> L35 SecurityException -> L37
        if (r15 <= 0.0f) goto L31;
        long r16 = r14.f3650a;     // Catch: Throwable -> L35 SecurityException -> L37
        a r17 = this.f10328v;     // Catch: Throwable -> L35 SecurityException -> L37
        float r18 = r15;
    L32:
        r8.requestLocationUpdates(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r16, r18, r17, r12);     // Catch: Throwable -> L35 SecurityException -> L37
        c4 r19 = new c4(this);     // Catch: Throwable -> L35 SecurityException -> L37
        this.f10324r = r19;     // Catch: Throwable -> L35 SecurityException -> L37
        r8.registerGnssStatusCallback(r19);     // Catch: Throwable -> L35 SecurityException -> L37
        b(this.f10310d.f3651b, 8, 14, "no enough satellites#1401");     // Catch: Throwable -> L35 SecurityException -> L37
        return;
    L31:
        r17 = this.f10328v;     // Catch: Throwable -> L35 SecurityException -> L37
        r16 = 900;
        r18 = 0.0f;
        goto L32
    L15:
        if ((System.currentTimeMillis() - D) >= 259200000) goto L17;
    L41:
        goto L24
    L17:
        if (y3.y(r10, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L19;
        r8.sendExtraCommand(CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, "force_xtra_injection", null);     // Catch: Throwable -> L21
        D = System.currentTimeMillis();     // Catch: Throwable -> L21
        SharedPreferences.Editor r20 = x3.c(r10, "pref");     // Catch: Throwable -> L21
        x3.g(r20, "lagt", D);     // Catch: Throwable -> L21
        x3.e(r20);     // Catch: Throwable -> L21
        goto L41
    L19:
        t3.g("OPENSDK_GL", "rlu_n_alec", new Exception("n_alec"));     // Catch: Throwable -> L21
    L37:
        e = move-exception;
        w3.a(2121, null);
        b(0, 2, 12, e.getMessage() + "#1201");
        return;
    L35:
        th = move-exception;
        th.getMessage();
        t3.g("GpsLocation", "requestLocationUpdates part2", th);
    }

    public final void g() {
        LocationManager r8 = this.f10309c;
        if (r8 != null) goto L22;
        return;
    L22:
        a r10 = this.f10328v;     // Catch: Throwable -> L17
        if (r10 == null) goto L24;
        r8.removeUpdates(r10);     // Catch: Throwable -> L17
        this.f10328v.f10333a = null;     // Catch: Throwable -> L17
        this.f10328v = null;     // Catch: Throwable -> L17
    L24:
        c4 r11 = this.f10324r;     // Catch: Throwable -> L18
        if (r11 == null) goto L20;
        r8.unregisterGnssStatusCallback(r11);     // Catch: Throwable -> L18
    L20:
        Handler r12 = this.f10307a;     // Catch: Throwable -> L19
        if (r12 == null) goto L15;
        r12.removeMessages(8);     // Catch: Throwable -> L19
    L15:
        this.f10323q = 0;
        this.f10311e = 0;
        this.f10326t = 0;
        this.f10312f = 0;
        this.f10314h = 0;
        this.f10327u = 0;
        this.f10315i.b();
        this.f10318l = null;
        this.f10319m = 0;
        this.f10320n = 0.0f;
        this.f10329w = null;
        this.f10332z = false;
    }

    public final void h(AMapLocation r10) {
        if (y3.k(r10) == true) goto L6;
        return;
    L6:
        if (this.f10307a == null) goto L25;
        long r8 = SystemClock.elapsedRealtime();
        long r11 = this.f10310d.f3650a;
        if (r11 > 8000) goto L10;
    L11:
        Bundle r12 = new Bundle();
        r12.putDouble("lat", r10.getLatitude());
        r12.putDouble("lon", r10.getLongitude());
        r12.putFloat("radius", r10.getAccuracy());
        r12.putLong("time", r10.getTime());
        Message r13 = Message.obtain();
        r13.setData(r12);
        r13.what = 5;
        Object r14 = this.f10321o;
        monitor-enter(r14);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (G != null) goto L18;
        Handler r15 = this.f10307a;     // Catch: Throwable -> L22
    L16:
        r15.sendMessage(r13);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r14);     // Catch: Throwable -> L22
        return;
    L18:
        if (y3.a(r10, G) <= this.f10317k) goto L20;
        r15 = this.f10307a;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r8 - this.f10326t) > (r11 - 8000)) goto L11;
        return;
    }

    public final boolean i() {
        if ((SystemClock.elapsedRealtime() - this.f10312f) <= 2800) goto L6;
        return false;
    L6:
        return true;
    }

    public final void j(AMapLocation r10) {
        if (r10.f3646w == 15) goto L5;
    L7:
        boolean r8 = this.f10310d.f3657r.equals(AMapLocationClientOption.b.f3667b);
        Handler r11 = this.f10307a;
        if (r8 == false) goto L15;
        if (this.f10310d.J <= 0.0f) goto L15;
        if (r11 == null) goto L20;
        Message r12 = Message.obtain();
        r12.obj = r10;
        r12.what = 2;
        r11.sendMessage(r12);
        return;
    L20:
        return;
    L15:
        if ((SystemClock.elapsedRealtime() - this.f10326t) < (this.f10310d.f3650a - 200)) goto L21;
        this.f10326t = SystemClock.elapsedRealtime();
        if (r11 == null) goto L22;
        Message r13 = Message.obtain();
        r13.obj = r10;
        r13.what = 2;
        r11.sendMessage(r13);
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (AMapLocationClientOption.b.f3667b.equals(this.f10310d.f3657r) == true) goto L7;
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
        if (this.f10310d.f3660u == false) goto L9;
        DPoint r8 = u3.b(this.f10308b, new DPoint(r10.A, r10.B));     // Catch: Throwable -> L11
        r10.A = r8.f3678b;     // Catch: Throwable -> L11
        r10.B = r8.f3677a;     // Catch: Throwable -> L11
        r10.f3645v = this.f10310d.f3660u;     // Catch: Throwable -> L11
        r10.Q = "GCJ02";     // Catch: Throwable -> L11
    }

    public final void l() {
        if ((SystemClock.elapsedRealtime() - B) <= 5000) goto L5;
        return;
    L5:
        if (y3.k(A) == true) goto L7;
        return;
    L7:
        if (this.f10310d.f3653n == false) goto L9;
    L11:
        this.f10312f = SystemClock.elapsedRealtime();
        j(A);
        return;
    L9:
        if (A.K == false) goto L11;
    }
}
