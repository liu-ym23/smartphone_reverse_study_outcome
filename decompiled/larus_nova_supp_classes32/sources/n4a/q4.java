package n4a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q4 {
    public static AMapLocation D;
    public static long E;
    public static final Object F = null;
    public static long G;
    public static boolean H;
    public static boolean I;
    public static volatile AMapLocation J;
    public boolean A;
    public int B;
    public boolean C;
    public final Handler a;
    public final Context b;
    public final LocationManager c;
    public AMapLocationClientOption d;
    public long e;
    public long f;
    public boolean g;
    public int h;
    public final f3 i;
    public int j;
    public int k;
    public AMapLocation l;
    public long m;
    public float n;
    public final Object o;
    public final Object p;
    public int q;
    public GpsStatus r;
    public p4 s;
    public o4 t;
    public AMapLocationClientOption.GeoLanguage u;
    public boolean v;
    public long w;
    public int x;
    public a y;
    public String z;

    public static class a implements LocationListener {
        public q4 a;

        public a(q4 r1) {
            this.a = r1;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r20) {
            ArrayList r1 = new ArrayList();
            Object[] r2 = {r20};
            f06.b r12 = new f06.b();
            g06.a r3 = (g06.a) ApiHookConfig.b.get(100038);
            if (r3 == null) goto L5;
            f06.a[] r4 = r3.i;
        L6:
            f06.a[] r10 = r4;
            int r9 = r10.length;
            int r8 = 0;
        L8:
            if (r8 >= r9) goto L15;
            f06.a r7 = r10[r8];
            int r16 = r8;
            int r17 = r9;
            f06.a[] r18 = r10;
            f06.d r5 = r7.preInvoke(100038, "com/loc/h$a", "onLocationChanged", this, r2, "void", r12);     // Catch: Exception -> L28
            if (r5.a == true) goto L17;
            r1.add(r7);     // Catch: Exception -> L28
        L17:
            if (r5.a == false) goto L29;
            return;
        L29:
            ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L25
            q4 r6 = this.a;     // Catch: Throwable -> L27
            if (r6 == null) goto L38;
            q4.f(r6, r20);     // Catch: Throwable -> L27
            return;
        L38:
            return;
        L39:
            return;
        L26:
            return;
        L14:
            r8 = r16 + 1;
            r9 = r17;
            r10 = r18;
            goto L8
        L15:
            r5 = new f06.d(false, null);
            goto L17
        L5:
            r4 = ApiHookConfig.d;
            goto L6
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r4) {
            q4 r0 = this.a;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            AMapLocation r1 = q4.D;     // Catch: Throwable -> L8
            r0.getClass();     // Catch: Throwable -> L8
            if ("gps".equalsIgnoreCase(r4) == false) goto L12;
            r0.f = 0;     // Catch: Throwable -> L8
            r0.q = 0;     // Catch: Throwable -> L8
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
            q4 r4 = this.a;     // Catch: Throwable -> L9
            if (r4 == null) goto L12;
            AMapLocation r5 = q4.D;     // Catch: Throwable -> L9
            r4.getClass();     // Catch: Throwable -> L9
            if (r2 == 0) goto L7;
            return;
        L7:
            r4.f = 0;     // Catch: Throwable -> L9
            r4.q = 0;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        }
    }

    static {
        F = new Object();
        G = 0;
        H = false;
        I = false;
        J = null;
    }

    public q4(Context r6, x1.e r7) {
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = 0;
        this.i = null;
        this.j = 240;
        this.k = 80;
        this.l = null;
        this.m = 0;
        this.n = 0.0f;
        this.o = new Object();
        this.p = new Object();
        this.q = 0;
        this.r = null;
        this.s = null;
        this.u = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.v = true;
        this.w = 0;
        this.x = 0;
        this.y = null;
        this.z = null;
        this.A = false;
        this.B = 0;
        this.C = false;
        this.b = r6;
        this.a = r7;
        this.c = (LocationManager) r6.getSystemService("location");     // Catch: Throwable -> L5
    L7:
        this.i = new f3();
        return;
    L5:
        th = move-exception;
        c4.g(th, "GpsLocation", "<init>");
        goto L7
    }

    public static boolean g(LocationManager r2) {
    L14:
        th = move-exception;
        new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
        return I;
    L3:
        if (H == true) goto L5;
        List<String> r3 = r2.getAllProviders();     // Catch: Throwable -> L14
        if (r3 != null) goto L9;
    L11:
        I = false;     // Catch: Throwable -> L14
    L12:
        H = true;     // Catch: Throwable -> L14
        return I;
    L9:
        if (r3.size() <= 0) goto L11;
        I = r3.contains("gps");     // Catch: Throwable -> L14
        goto L12
    L5:
        return I;
    }

    public final void b(int r4, int r5, String r6, long r7) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.d.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L12;
        Message r0 = Message.obtain();     // Catch: Throwable -> L8
        AMapLocation r1 = new AMapLocation(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L8
        r1.setProvider("gps");     // Catch: Throwable -> L8
        r1.setErrorCode(r5);     // Catch: Throwable -> L8
        r1.setLocationDetail(r6);     // Catch: Throwable -> L8
        r1.setLocationType(1);     // Catch: Throwable -> L8
        r0.obj = r1;     // Catch: Throwable -> L8
        r0.what = r4;     // Catch: Throwable -> L8
        this.a.sendMessageDelayed(r0, r7);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }

    public final void c(Bundle r3) {
        if (r3 == null) goto L20;
        r3.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.j = r3.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.k = r3.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r4 = r3.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r4.getAdCode()) == true) goto L21;
        Object r0 = this.o;     // Catch: Throwable -> L13
        monitor-enter(r0);     // Catch: Throwable -> L13
        J = r4;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        c4.g(th, "GpsLocation", "setLastGeoLocation");
        return;
    }

    public final void o(AMapLocation r9) {
    L11:
        r9.setOffset(false);
        r9.setCoordType("WGS84");
        return;
    L4:
        if (c4.h(r9.getLatitude(), r9.getLongitude()) == true) goto L6;
    L9:
        r9.setOffset(false);     // Catch: Throwable -> L11
        r9.setCoordType("WGS84");     // Catch: Throwable -> L11
        return;
    L6:
        if (this.d.isOffset() == false) goto L9;
        DPoint r2 = e4.b(this.b, new DPoint(r9.getLatitude(), r9.getLongitude()));     // Catch: Throwable -> L11
        r9.setLatitude(r2.getLatitude());     // Catch: Throwable -> L11
        r9.setLongitude(r2.getLongitude());     // Catch: Throwable -> L11
        r9.setOffset(this.d.isOffset());     // Catch: Throwable -> L11
        r9.setCoordType("GCJ02");     // Catch: Throwable -> L11
    }

    public final AMapLocation q() {
        if (j4.l(this.l) == true) goto L7;
        return null;
    L7:
        if (com.loc.h.r == true) goto L50;
        return null;
    L50:
        boolean r1 = ((Boolean) f4.e(f5.o("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), f5.o("UaXNOYXZpU3RhcnRlZA=="), null, null)).booleanValue();     // Catch: Throwable -> L11
    L12:
        if (r1 == false) goto L39;
        JSONObject r2 = new JSONObject((String) f4.e(f5.o("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), f5.o("UZ2V0TmF2aUxvY2F0aW9u"), null, null));     // Catch: Throwable -> L41
        long r3 = r2.optLong("time");     // Catch: Throwable -> L41
        if (this.C == true) goto L17;
        this.C = true;     // Catch: Throwable -> L41
        h4.l("useNaviLoc", "use NaviLoc");     // Catch: Throwable -> L41
    L17:
        if ((System.currentTimeMillis() - r3) > 5500) goto L39;
        double r7 = r2.optDouble("lat", 0.0d);     // Catch: Throwable -> L41
        double r9 = r2.optDouble("lng", 0.0d);     // Catch: Throwable -> L41
        float r4 = 0.0f;
        float r11 = CastFloatProtector.parseFloat(r2.optString("accuracy", "0"));     // Catch: NumberFormatException -> L22 Throwable -> L41
    L23:
        double r5 = r2.optDouble("altitude", 0.0d);     // Catch: Throwable -> L41
        float r12 = CastFloatProtector.parseFloat(r2.optString("bearing", "0"));     // Catch: NumberFormatException -> L26 Throwable -> L41
    L42:
        r4 = (CastFloatProtector.parseFloat(r2.optString("speed", "0")) * 10.0f) / 36.0f;
    L29:
        AMapLocation r6 = new AMapLocation("lbs");     // Catch: Throwable -> L41
        r6.setLocationType(9);     // Catch: Throwable -> L41
        r6.setLatitude(r7);     // Catch: Throwable -> L41
        r6.setLongitude(r9);     // Catch: Throwable -> L41
        r6.setAccuracy(r11);     // Catch: Throwable -> L41
        r6.setAltitude(r5);     // Catch: Throwable -> L41
        r6.setBearing(r12);     // Catch: Throwable -> L41
        r6.setSpeed(r4);     // Catch: Throwable -> L41
        r6.setTime(r3);     // Catch: Throwable -> L41
        r6.setCoordType("GCJ02");     // Catch: Throwable -> L41
        if (j4.a(r6, this.l) > 300.0f) goto L39;
        Object r8 = this.p;     // Catch: Throwable -> L41
        monitor-enter(r8);     // Catch: Throwable -> L41
        this.l.setLongitude(r9);     // Catch: Throwable -> L36
        this.l.setLatitude(r7);     // Catch: Throwable -> L36
        this.l.setAccuracy(r11);     // Catch: Throwable -> L36
        this.l.setBearing(r12);     // Catch: Throwable -> L36
        this.l.setSpeed(r4);     // Catch: Throwable -> L36
        this.l.setTime(r3);     // Catch: Throwable -> L36
        this.l.setCoordType("GCJ02");     // Catch: Throwable -> L36
        monitor-exit(r8);     // Catch: Throwable -> L36
        return r6;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L26:
        r12 = 0.0f;
    L22:
        r11 = 0.0f;
    L11:
        r1 = false;
    L39:
        return null;
    }

    public final void h() {
        LocationManager r0 = this.c;
        if (r0 != null) goto L28;
        return;
    L28:
        a r2 = this.y;     // Catch: Throwable -> L24
        if (r2 == null) goto L32;
        if (fna.g.d() == true) goto L11;
        r0.removeUpdates(r2);     // Catch: Throwable -> L24
    L12:
        this.y.a = null;     // Catch: Throwable -> L24
        this.y = null;     // Catch: Throwable -> L24
        goto L32
    L11:
        r0.removeUpdates(r2);     // Catch: Throwable -> L24
        nna.a.a(r2.hashCode());     // Catch: Throwable -> L24
    L32:
        p4 r1 = this.s;     // Catch: Throwable -> L25
        if (r1 == null) goto L30;
        this.c.removeGpsStatusListener(r1);     // Catch: Throwable -> L25
    L30:
        o4 r3 = this.t;     // Catch: Throwable -> L26
        if (r3 == null) goto L34;
        this.c.unregisterGnssStatusCallback(r3);     // Catch: Throwable -> L26
    L34:
        Handler r4 = this.a;     // Catch: Throwable -> L27
        if (r4 == null) goto L22;
        r4.removeMessages(8);     // Catch: Throwable -> L27
    L22:
        this.q = 0;
        this.e = 0;
        this.w = 0;
        this.f = 0;
        this.h = 0;
        this.x = 0;
        this.i.b();
        this.l = null;
        this.m = 0;
        this.n = 0.0f;
        this.z = null;
        this.C = false;
    }

    public final boolean j() {
        if ((SystemClock.elapsedRealtime() - this.f) <= 2800) goto L6;
        return false;
    L6:
        return true;
    }

    public final void p() {
        if ((SystemClock.elapsedRealtime() - E) <= 5000) goto L5;
        return;
    L5:
        if (j4.l(D) == true) goto L7;
        return;
    L7:
        if (this.d.isMockEnable() == false) goto L9;
    L11:
        this.f = SystemClock.elapsedRealtime();
        k(D);
        return;
    L9:
        if (D.isMock() == false) goto L11;
    }

    public final void d(AMapLocation r4) {
        if (j4.l(r4) == true) goto L5;
        return;
    L5:
        this.f = SystemClock.elapsedRealtime();
        Object r0 = F;
        monitor-enter(r0);
        E = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        D = r4.clone();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.h++;
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void e(AMapLocationClientOption r12) {
        this.d = r12;
        if (r12 != null) goto L54;
        this.d = new AMapLocationClientOption();
    L54:
        G = i4.b(this.b, "pref", "lagt", G);     // Catch: Throwable -> L7
    L9:
        if (this.c != null) goto L56;
        return;
    L56:
        p();     // Catch: Throwable -> L46 SecurityException -> L48
        this.v = true;     // Catch: Throwable -> L46 SecurityException -> L48
        Looper r3 = Looper.myLooper();     // Catch: Throwable -> L46 SecurityException -> L48
        if (r3 != null) goto L15;
        r3 = this.b.getMainLooper();     // Catch: Throwable -> L46 SecurityException -> L48
    L15:
        Looper r6 = r3;
        this.e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L46 SecurityException -> L48
        if (g(this.c) == true) goto L52;
        b(8, 14, "no gps provider#1402", 0);     // Catch: Throwable -> L46 SecurityException -> L48
        return;
    L52:
    L24:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L46 SecurityException -> L48
    L27:
        if (this.y != null) goto L30;
        this.y = new a(this);     // Catch: Throwable -> L46 SecurityException -> L48
    L30:
        if (this.d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) == true) goto L32;
    L34:
        LocationManager r1 = this.c;     // Catch: Throwable -> L46 SecurityException -> L48
        a r0 = this.y;     // Catch: Throwable -> L46 SecurityException -> L48
        long r2 = 900;
        float r4 = 0.0f;
    L36:
        if (fna.g.d() == true) goto L38;
        n(r1, r2, r4, r0, r6);     // Catch: Throwable -> L46 SecurityException -> L48
    L40:
        if (Build.VERSION.SDK_INT < 24) goto L42;
        o4 r5 = new o4(this);     // Catch: Throwable -> L46 SecurityException -> L48
        this.t = r5;     // Catch: Throwable -> L46 SecurityException -> L48
        m(this.c, r5);     // Catch: Throwable -> L46 SecurityException -> L48
    L43:
        b(8, 14, "no enough satellites#1401", this.d.getHttpTimeOut());     // Catch: Throwable -> L46 SecurityException -> L48
        return;
    L42:
        p4 r7 = new p4(this);     // Catch: Throwable -> L46 SecurityException -> L48
        this.s = r7;     // Catch: Throwable -> L46 SecurityException -> L48
        l(this.c, r7);     // Catch: Throwable -> L46 SecurityException -> L48
        goto L43
    L38:
        n(r1, r2, r4, r0, r6);     // Catch: Throwable -> L46 SecurityException -> L48
        nna.a.c(r0.hashCode());     // Catch: Throwable -> L46 SecurityException -> L48
        goto L40
    L32:
        if (this.d.getDeviceModeDistanceFilter() <= 0.0f) goto L34;
        LocationManager r8 = this.c;     // Catch: Throwable -> L46 SecurityException -> L48
        long r9 = this.d.getInterval();     // Catch: Throwable -> L46 SecurityException -> L48
        float r10 = this.d.getDeviceModeDistanceFilter();     // Catch: Throwable -> L46 SecurityException -> L48
        r1 = r8;
        r0 = this.y;     // Catch: Throwable -> L46 SecurityException -> L48
        r4 = r10;
        r2 = r9;
        goto L36
    L18:
        if ((System.currentTimeMillis() - G) >= 259200000) goto L20;
    L51:
        goto L27
    L20:
        if (j4.A(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L22;
        this.c.sendExtraCommand("gps", "force_xtra_injection", null);     // Catch: Throwable -> L24
        G = System.currentTimeMillis();     // Catch: Throwable -> L24
        SharedPreferences.Editor r11 = i4.c(this.b, "pref");     // Catch: Throwable -> L24
        i4.g(r11, "lagt", G);     // Catch: Throwable -> L24
        i4.e(r11);     // Catch: Throwable -> L24
        goto L51
    L22:
        c4.g(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");     // Catch: Throwable -> L24
    L48:
        e = move-exception;
        this.v = false;
        h4.k(null, 2121);
        b(2, 12, e.getMessage() + "#1201", 0);
        return;
    L46:
        th = move-exception;
        th.getMessage();
        c4.g(th, "GpsLocation", "requestLocationUpdates part2");
    }

    public final void i(AMapLocation r8) {
        if (j4.l(r8) == true) goto L6;
        return;
    L6:
        if (this.a == null) goto L25;
        long r0 = SystemClock.elapsedRealtime();
        if (this.d.getInterval() > 8000) goto L10;
    L11:
        Bundle r1 = new Bundle();
        r1.putDouble("lat", r8.getLatitude());
        r1.putDouble("lon", r8.getLongitude());
        r1.putFloat("radius", r8.getAccuracy());
        r1.putLong("time", r8.getTime());
        Message r2 = Message.obtain();
        r2.setData(r1);
        r2.what = 5;
        Object r3 = this.o;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (J != null) goto L18;
        Handler r9 = this.a;     // Catch: Throwable -> L22
    L16:
        r9.sendMessage(r2);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L18:
        if (j4.a(r8, J) <= this.k) goto L20;
        r9 = this.a;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r0 - this.w) > (this.d.getInterval() - 8000)) goto L11;
        return;
    }

    public final void k(AMapLocation r9) {
        if (r9.getErrorCode() != 15) goto L8;
        if (AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.d.getLocationMode()) == true) goto L8;
        return;
    L8:
        if (this.d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) == false) goto L16;
        if (this.d.getDeviceModeDistanceFilter() <= 0.0f) goto L16;
        if (this.a == null) goto L21;
        Message r0 = Message.obtain();
        r0.obj = r9;
        r0.what = 2;
        this.a.sendMessage(r0);
        return;
    L21:
        return;
    L16:
        if ((SystemClock.elapsedRealtime() - this.w) < (this.d.getInterval() - 200)) goto L22;
        this.w = SystemClock.elapsedRealtime();
        if (this.a == null) goto L23;
        Message r1 = Message.obtain();
        r1.obj = r9;
        r1.what = 2;
        this.a.sendMessage(r1);
        return;
    L23:
        return;
    }

    public static void f(q4 r12, Location r13) {
        Handler r0 = r12.a;
        if (r0 == null) goto L5;
        r0.removeMessages(8);
    L5:
        if (r13 == null) goto L119;
        AMapLocation r1 = new AMapLocation(r13);     // Catch: Throwable -> L102
        if (j4.l(r1) == false) goto L117;
        r1.setProvider("gps");     // Catch: Throwable -> L102
        boolean r2 = true;
        r1.setLocationType(1);     // Catch: Throwable -> L102
        if (r12.g == true) goto L25;
        if (j4.l(r1) == false) goto L25;
        Context r3 = r12.b;     // Catch: Throwable -> L102
        long r4 = SystemClock.elapsedRealtime() - r12.e;     // Catch: Throwable -> L102
        boolean r5 = c4.h(r1.getLatitude(), r1.getLongitude());     // Catch: Throwable -> L102
        List<r0> r6 = h4.g;     // Catch: Throwable -> L102
        if (r3 != null) goto L109;
    L23:
        r12.g = true;     // Catch: Throwable -> L102
        goto L25
    L109:
    L21:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportGPSLocUseTime");     // Catch: Throwable -> L102
        goto L23
    L17:
        if (com.loc.h.b == false) goto L23;
        h4.e(r3, r4, r5, "O015");     // Catch: Throwable -> L21
    L25:
        if (j4.k(r1, r12.q) == false) goto L32;
        r1.setMock(true);     // Catch: Throwable -> L102
        r1.setTrustedLevel(4);     // Catch: Throwable -> L102
        if (r12.d.isMockEnable() == true) goto L33;
        int r14 = r12.x;     // Catch: Throwable -> L102
        if (r14 <= 3) goto L31;
        h4.k(null, 2152);     // Catch: Throwable -> L102
        r1.setErrorCode(15);     // Catch: Throwable -> L102
        r1.setLocationDetail("GpsLocation has been mocked!#1501");     // Catch: Throwable -> L102
        r1.setLatitude(0.0d);     // Catch: Throwable -> L102
        r1.setLongitude(0.0d);     // Catch: Throwable -> L102
        r1.setAltitude(0.0d);     // Catch: Throwable -> L102
        r1.setSpeed(0.0f);     // Catch: Throwable -> L102
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L102
        r1.setBearing(0.0f);     // Catch: Throwable -> L102
        r1.setExtras(null);     // Catch: Throwable -> L102
    L97:
        r12.k(r1);     // Catch: Throwable -> L102
        return;
    L31:
        r12.x = r14 + 1;     // Catch: Throwable -> L102
        return;
    L33:
        r1.setSatellites(r12.q);     // Catch: Throwable -> L102
        r12.o(r1);     // Catch: Throwable -> L102
        int r7 = r12.q;     // Catch: Throwable -> L105
        if (r7 < 4) goto L37;
        int r8 = 1;
    L39:
        r1.setGpsAccuracyStatus(r8);     // Catch: Throwable -> L105
    L106:
        goto L42
    L37:
        if (r7 != 0) goto L40;
        r8 = -1;
        goto L39
    L40:
        r1.setGpsAccuracyStatus(0);     // Catch: Throwable -> L105
    L42:
        if (j4.l(r1) == true) goto L45;
    L55:
        if (j4.l(r1) == true) goto L58;
    L71:
        r12.d(r1);     // Catch: Throwable -> L102
        r12.i(r1);     // Catch: Throwable -> L102
        Object r9 = r12.o;     // Catch: Throwable -> L102
        monitor-enter(r9);     // Catch: Throwable -> L102
        AMapLocation r10 = J;     // Catch: Throwable -> L99
        if (r10 != null) goto L76;
    L80:
        monitor-exit(r9);     // Catch: Throwable -> L99
    L116:
    L95:
        th = move-exception;
        c4.g(th, "GpsLocation", "onLocationChangedLast");     // Catch: Throwable -> L102
        goto L97
    L82:
        if (j4.l(r1) == false) goto L97;
        if (r12.l == null) goto L86;
        r12.m = r13.getTime() - r12.l.getTime();     // Catch: Throwable -> L95
        r12.n = j4.a(r12.l, r1);     // Catch: Throwable -> L95
    L86:
        Object r15 = r12.p;     // Catch: Throwable -> L95
        monitor-enter(r15);     // Catch: Throwable -> L95
        r12.l = r1.clone();     // Catch: Throwable -> L92
        monitor-exit(r15);     // Catch: Throwable -> L92
        r12.z = null;     // Catch: Throwable -> L95
        r12.A = false;     // Catch: Throwable -> L95
        r12.B = 0;     // Catch: Throwable -> L95
        goto L97
    L92:
        th = move-exception;
        throw th;     // Catch: Throwable -> L95
    L76:
        if (r12.d.isNeedAddress() == false) goto L80;
        if (j4.a(r1, r10) >= r12.j) goto L80;
        c4.d(r1, r10);     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        throw th;     // Catch: Throwable -> L102
    L58:
        if (r12.h < 3) goto L71;
        if (r1.getAccuracy() >= 0.0f) goto L63;
    L64:
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L102
    L66:
        if (r1.getSpeed() >= 0.0f) goto L68;
    L69:
        r1.setSpeed(0.0f);     // Catch: Throwable -> L102
    L70:
        r1 = r12.i.a(r1);     // Catch: Throwable -> L102
        goto L71
    L68:
        if (r1.getSpeed() != Float.MAX_VALUE) goto L70;
    L63:
        if (r1.getAccuracy() != Float.MAX_VALUE) goto L66;
    L45:
        if (com.loc.h.w == true) goto L47;
    L49:
        r2 = false;
    L50:
        if (r2 == false) goto L55;
        long r11 = r1.getTime();     // Catch: Throwable -> L102
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L102
        long r17 = d4.a(r11, r16, com.loc.h.x);     // Catch: Throwable -> L102
        if (r17 == r11) goto L55;
        r1.setTime(r17);     // Catch: Throwable -> L102
        h4.a(r11, r16);     // Catch: Throwable -> L102
        goto L55
    L47:
        if (com.loc.h.x <= 0) goto L49;
    L32:
        r12.x = 0;     // Catch: Throwable -> L102
        goto L33
    L117:
        return;
    L102:
        th = move-exception;
        c4.g(th, "GpsLocation", "onLocationChanged");
        return;
    }

    public static void l(LocationManager r18, p4 r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100005);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100005, "android/location/LocationManager", "addGpsStatusListener", r18, r1, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L20;
        ((Boolean) r4.b).booleanValue();
        return;
    L20:
        r18.addGpsStatusListener(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static void m(LocationManager r18, o4 r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100011);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(100011, "android/location/LocationManager", "registerGnssStatusCallback", r18, r1, "boolean", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L20;
        ((Boolean) r4.b).booleanValue();
        return;
    L20:
        r18.registerGnssStatusCallback(r19);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final AMapLocation a(AMapLocation r17, String r18) {
        if (this.l != null) goto L6;
        return r17;
    L6:
        if (this.d.isMockEnable() == true) goto L11;
        if (this.l.isMock() == false) goto L11;
        return r17;
    L11:
        if (j4.l(this.l) == true) goto L13;
        return r17;
    L13:
        AMapLocation r2 = q();
        if (r2 != null) goto L16;
    L19:
        float r3 = this.l.getSpeed();
        if (r3 != 0.0f) goto L29;
        long r7 = this.m;
        if (r7 <= 0) goto L29;
        if (r7 >= 8) goto L29;
        float r9 = this.n;
        if (r9 <= 0.0f) goto L29;
        r3 = r9 / r7;
    L29:
        if (r17 != null) goto L31;
    L48:
        long r10 = 30000;
    L49:
        long r12 = SystemClock.elapsedRealtime() - this.f;
        if (r12 <= AutoEndConversationTime.AFTER_30_SECONDS) goto L53;
        return r17;
    L53:
        if (r12 < r10) goto L77;
        if (this.A == true) goto L85;
    L67:
        this.z = null;
        this.B = 0;
        Object r4 = this.p;
        monitor-enter(r4);
        this.l = null;     // Catch: Throwable -> L73
        monitor-exit(r4);     // Catch: Throwable -> L73
        this.m = 0;
        this.n = 0.0f;
        return r17;
    L73:
        th = move-exception;
        throw th;
    L85:
        ArrayList<String> r5 = j4.v(r18);     // Catch: Throwable -> L62
        ArrayList<String> r6 = j4.v(this.z);     // Catch: Throwable -> L62
        if (r5.size() < 8) goto L63;
        if (r6.size() < 8) goto L63;
        boolean r0 = j4.o(this.z, r18);     // Catch: Throwable -> L62
    L64:
        if (r0 == false) goto L67;
        AMapLocation r1 = this.l.clone();
        r1.setTrustedLevel(3);
        return r1;
    L63:
        r0 = false;
        goto L64
    L77:
        if (this.z == null) goto L79;
    L81:
        AMapLocation r8 = this.l.clone();
        r8.setTrustedLevel(2);
        return r8;
    L79:
        if (this.B < 2) goto L81;
        this.z = r18;
        goto L81
    L31:
        if (j4.l(r17) == false) goto L48;
        if (r17.getAccuracy() >= 200.0f) goto L43;
        int r11 = this.B + 1;
        this.B = r11;
        if (this.z != null) goto L39;
        if (r11 < 2) goto L39;
        this.A = true;
    L39:
        if (r3 <= 5.0f) goto L41;
        r10 = AutoEndConversationTime.AFTER_10_SECONDS;
        goto L49
    L41:
        r10 = 15000;
        goto L49
    L43:
        if (TextUtils.isEmpty(this.z) == true) goto L46;
        this.A = false;
        this.B = 0;
    L46:
        if (r3 <= 5.0f) goto L48;
        r10 = AutoEndConversationTime.AFTER_20_SECONDS;
        goto L49
    L16:
        if (j4.l(r2) == false) goto L19;
        r2.setTrustedLevel(2);
        return r2;
    }

    public static void n(LocationManager r19, long r20, float r22, LocationListener r23, Looper r24) {
        ArrayList r0 = new ArrayList();
        Object[] r2 = {"gps", Long.valueOf(r20), Float.valueOf(r22), r23, r24};
        f06.b r12 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(100001);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r16 = r8;
        int r17 = r9;
        f06.a[] r18 = r10;
        f06.d r5 = r7.preInvoke(100001, "android/location/LocationManager", "requestLocationUpdates", r19, r2, "void", r12);     // Catch: Exception -> L21
        if (r5.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r5.a == false) goto L19;
        return;
    L19:
        r19.requestLocationUpdates("gps", r20, r22, r23, r24);
        return;
    L14:
        r8 = r16 + 1;
        r9 = r17;
        r10 = r18;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }
}
