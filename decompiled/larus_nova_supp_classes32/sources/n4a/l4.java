package n4a;

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
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.loc.es;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l4 {
    public static long q;
    public static boolean r;
    public static boolean s;
    public static boolean t;
    public static boolean u;
    public static volatile AMapLocation v;
    public long a;
    public boolean b;
    public int c;
    public final f3 d;
    public int e;
    public int f;
    public final Handler g;
    public final Context h;
    public long i;
    public int j;
    public LocationManager k;
    public AMapLocationClientOption l;
    public final Object m;
    public boolean n;
    public AMapLocationClientOption.GeoLanguage o;
    public a p;

    public static class a implements LocationListener {
        public l4 a;

        public a(l4 r1) {
            this.a = r1;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r2) {
            "gps".equalsIgnoreCase(r2);
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
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
            f06.d r5 = r7.preInvoke(100038, "com/loc/g$a", "onLocationChanged", this, r2, "void", r12);     // Catch: Exception -> L25
            if (r5.a == true) goto L17;
            r1.add(r7);     // Catch: Exception -> L25
        L17:
            if (r5.a == false) goto L26;
            return;
        L26:
            l4 r6 = this.a;     // Catch: Throwable -> L24
            if (r6 == null) goto L33;
            l4.d(r6, r20);     // Catch: Throwable -> L24
            return;
        L33:
            return;
        L34:
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

    public l4(Context r6, x1.e r7) {
        this.a = 0;
        this.b = false;
        this.c = 0;
        this.d = null;
        this.e = 240;
        this.f = 80;
        this.i = 0;
        this.j = 0;
        this.m = new Object();
        this.n = true;
        this.o = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.p = null;
        this.h = r6;
        this.g = r7;
        this.k = (LocationManager) r6.getSystemService("location");     // Catch: Throwable -> L5
    L7:
        this.d = new f3();
        return;
    L5:
        th = move-exception;
        c4.g(th, "CoarseLocation", "<init>");
        goto L7
    }

    public static boolean e(LocationManager r2) {
    L14:
        th = move-exception;
        new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
        return s;
    L3:
        if (r == true) goto L5;
        List<String> r3 = r2.getAllProviders();     // Catch: Throwable -> L14
        if (r3 != null) goto L9;
    L11:
        s = false;     // Catch: Throwable -> L14
    L12:
        r = true;     // Catch: Throwable -> L14
        return s;
    L9:
        if (r3.size() <= 0) goto L11;
        s = r3.contains("gps");     // Catch: Throwable -> L14
        goto L12
    L5:
        return s;
    }

    public static boolean i(LocationManager r2) {
    L8:
        th = move-exception;
        new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
        return u;
    L3:
        if (t == true) goto L5;
        boolean r3 = r2.isProviderEnabled(CloudControlInf.NETWORK);     // Catch: Throwable -> L8
        u = r3;     // Catch: Throwable -> L8
        t = true;     // Catch: Throwable -> L8
        return r3;
    L5:
        return u;
    }

    public final void a(int r4, String r5, long r6) {
        if (this.g == null) goto L9;
        Message r0 = Message.obtain();     // Catch: Throwable -> L6
        AMapLocation r1 = new AMapLocation(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L6
        r1.setErrorCode(20);     // Catch: Throwable -> L6
        r1.setLocationDetail(r5);     // Catch: Throwable -> L6
        r1.setLocationType(11);     // Catch: Throwable -> L6
        r0.obj = r1;     // Catch: Throwable -> L6
        r0.what = r4;     // Catch: Throwable -> L6
        this.g.sendMessageDelayed(r0, r6);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public final void b(Bundle r3) {
        if (r3 == null) goto L20;
        r3.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.e = r3.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.f = r3.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r4 = r3.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r4.getAdCode()) == true) goto L21;
        Object r0 = this.m;     // Catch: Throwable -> L13
        monitor-enter(r0);     // Catch: Throwable -> L13
        v = r4;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        c4.g(th, "CoarseLocation", "setLastGeoLocation");
        return;
    }

    public final void h(AMapLocationClientOption r2) {
        if (r2 != null) goto L4;
        r2 = new AMapLocationClientOption();
    L4:
        this.l = r2;
        new StringBuilder("option: ").append(this.l.toString());
        this.g.removeMessages(100);
        if (this.o == this.l.getGeoLanguage()) goto L15;
        Object r3 = this.m;
        monitor-enter(r3);
        v = null;     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        this.o = this.l.getGeoLanguage();
    }

    public final void l(AMapLocation r9) {
    L11:
        th = move-exception;
        r9.setOffset(false);
        r9.setCoordType("WGS84");
        th.getMessage();
        return;
    L4:
        if (c4.h(r9.getLatitude(), r9.getLongitude()) == true) goto L6;
    L9:
        r9.setOffset(false);     // Catch: Throwable -> L11
        r9.setCoordType("WGS84");     // Catch: Throwable -> L11
        return;
    L6:
        if (this.l.isOffset() == false) goto L9;
        DPoint r2 = e4.b(this.h, new DPoint(r9.getLatitude(), r9.getLongitude()));     // Catch: Throwable -> L11
        r9.setLatitude(r2.getLatitude());     // Catch: Throwable -> L11
        r9.setLongitude(r2.getLongitude());     // Catch: Throwable -> L11
        r9.setOffset(this.l.isOffset());     // Catch: Throwable -> L11
        r9.setCoordType("GCJ02");     // Catch: Throwable -> L11
    }

    public final void f() {
        LocationManager r0 = this.k;
        if (r0 != null) goto L23;
        return;
    L23:
        a r1 = this.p;     // Catch: Throwable -> L13
        if (r1 != null) goto L8;
    L21:
        Handler r2 = this.g;     // Catch: Throwable -> L20
        if (r2 == null) goto L18;
        r2.removeMessages(100);     // Catch: Throwable -> L20
    L18:
        this.a = 0;
        this.i = 0;
        this.c = 0;
        this.j = 0;
        this.d.b();
        return;
    L8:
        if (fna.g.d() == true) goto L10;
        r0.removeUpdates(r1);     // Catch: Throwable -> L13
    L11:
        this.p.a = null;     // Catch: Throwable -> L13
        this.p = null;     // Catch: Throwable -> L13
        goto L21
    L10:
        r0.removeUpdates(r1);     // Catch: Throwable -> L13
        nna.a.a(r1.hashCode());     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.getMessage();
        goto L21
    }

    public final void c(AMapLocationClientOption r15) {
        this.l = r15;
        if (r15 != null) goto L5;
        this.l = new AMapLocationClientOption();
    L5:
        this.l.toString();
        if (this.l.isOnceLocation() == true) goto L88;
        es r16 = new es();
        r16.setErrorCode(20);
        r16.setLocationDetail("模糊权限下不支持连续定位#2006");
        j(r16);
        return;
    L88:
    L26:
        boolean r3 = true;
    L27:
        if (r3 == true) goto L90;
        es r17 = new es();
        r17.setErrorCode(12);
        r17.setLocationDetail("定位服务没有开启，请在设置中打开定位服务开关#1206");
        j(r17);
        return;
    L90:
        q = i4.b(this.h, "pref", "lagt", q);     // Catch: Throwable -> L32
    L34:
        if (this.k != null) goto L92;
        return;
    L92:
        this.n = true;     // Catch: Throwable -> L78 SecurityException -> L80
        Looper r2 = Looper.myLooper();     // Catch: Throwable -> L78 SecurityException -> L80
        if (r2 != null) goto L40;
        r2 = this.h.getMainLooper();     // Catch: Throwable -> L78 SecurityException -> L80
    L40:
        this.a = SystemClock.elapsedRealtime();     // Catch: Throwable -> L78 SecurityException -> L80
        if (i(this.k) == false) goto L50;
        if (this.p != null) goto L45;
        this.p = new a(this);     // Catch: Throwable -> L78 SecurityException -> L80
    L45:
        LocationManager r6 = this.k;     // Catch: Throwable -> L78 SecurityException -> L80
        long r8 = this.l.getInterval();     // Catch: Throwable -> L78 SecurityException -> L80
        float r10 = this.l.getDeviceModeDistanceFilter();     // Catch: Throwable -> L78 SecurityException -> L80
        a r13 = this.p;     // Catch: Throwable -> L78 SecurityException -> L80
        if (fna.g.d() == true) goto L48;
        k(r6, CloudControlInf.NETWORK, r8, r10, r13, r2);     // Catch: Throwable -> L78 SecurityException -> L80
        goto L50
    L48:
        k(r6, CloudControlInf.NETWORK, r8, r10, r13, r2);     // Catch: Throwable -> L78 SecurityException -> L80
        nna.a.c(r13.hashCode());     // Catch: Throwable -> L78 SecurityException -> L80
    L50:
        if (e(this.k) == false) goto L68;
    L58:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L78 SecurityException -> L80
    L61:
        if (this.p != null) goto L63;
        this.p = new a(this);     // Catch: Throwable -> L78 SecurityException -> L80
    L63:
        LocationManager r7 = this.k;     // Catch: Throwable -> L78 SecurityException -> L80
        long r9 = this.l.getInterval();     // Catch: Throwable -> L78 SecurityException -> L80
        float r11 = this.l.getDeviceModeDistanceFilter();     // Catch: Throwable -> L78 SecurityException -> L80
        a r0 = this.p;     // Catch: Throwable -> L78 SecurityException -> L80
        if (fna.g.d() == true) goto L66;
        k(r7, "gps", r9, r11, r0, r2);     // Catch: Throwable -> L78 SecurityException -> L80
        goto L68
    L66:
        k(r7, "gps", r9, r11, r0, r2);     // Catch: Throwable -> L78 SecurityException -> L80
        nna.a.c(r0.hashCode());     // Catch: Throwable -> L78 SecurityException -> L80
        goto L68
    L52:
        if ((System.currentTimeMillis() - q) >= 259200000) goto L54;
    L83:
    L54:
        if (j4.A(this.h, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L56;
        this.k.sendExtraCommand("gps", "force_xtra_injection", null);     // Catch: Throwable -> L58
        q = System.currentTimeMillis();     // Catch: Throwable -> L58
        SharedPreferences.Editor r1 = i4.c(this.h, "pref");     // Catch: Throwable -> L58
        i4.g(r1, "lagt", q);     // Catch: Throwable -> L58
        i4.e(r1);     // Catch: Throwable -> L58
        goto L83
    L56:
        c4.g(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");     // Catch: Throwable -> L58
    L68:
        if (s == false) goto L70;
    L71:
        a(100, "系统返回定位结果超时#2002", this.l.getHttpTimeOut());     // Catch: Throwable -> L78 SecurityException -> L80
    L73:
        if (s == false) goto L75;
        return;
    L75:
        if (u == true) goto L95;
        a(100, "系统定位当前不可用#2003", 0);     // Catch: Throwable -> L78 SecurityException -> L80
    L98:
        return;
    L95:
        return;
    L70:
        if (u == false) goto L73;
    L80:
        e = move-exception;
        this.n = false;
        h4.k(null, 2121);
        a(101, e.getMessage() + "#2004", 0);
        return;
    L78:
        th = move-exception;
        th.getMessage();
        c4.g(th, "CoarseLocation", "requestLocationUpdates part2");
        return;
    L11:
        if (j4.y() >= 28) goto L13;
        r3 = true;
    L86:
        if (j4.y() < 24) goto L27;
        if (j4.y() >= 28) goto L27;
        if (Settings.Secure.getInt(this.h.getContentResolver(), "location_mode", 0) != 0) goto L27;
        r3 = false;
        goto L27
    L13:
        if (this.k != null) goto L15;
        this.k = (LocationManager) this.h.getApplicationContext().getSystemService("location");     // Catch: Throwable -> L26
    L15:
        r3 = ((Boolean) f4.c(this.k, "isLocationEnabled", new Object[0])).booleanValue();     // Catch: Throwable -> L26
        goto L86
    }

    public final void g(AMapLocation r8) {
        if (j4.l(r8) == true) goto L6;
        return;
    L6:
        if (this.g == null) goto L25;
        long r0 = SystemClock.elapsedRealtime();
        if (this.l.getInterval() > 8000) goto L10;
    L11:
        Bundle r1 = new Bundle();
        r1.putDouble("lat", r8.getLatitude());
        r1.putDouble("lon", r8.getLongitude());
        r1.putFloat("radius", r8.getAccuracy());
        r1.putLong("time", r8.getTime());
        Message r2 = Message.obtain();
        r2.setData(r1);
        r2.what = 102;
        Object r3 = this.m;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (v != null) goto L18;
        Handler r9 = this.g;     // Catch: Throwable -> L22
    L16:
        r9.sendMessage(r2);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L18:
        if (j4.a(r8, v) <= this.f) goto L20;
        r9 = this.g;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r0 - this.i) > (this.l.getInterval() - 8000)) goto L11;
        return;
    }

    public final void j(AMapLocation r9) {
        if (this.l.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) == false) goto L11;
        if (this.l.getDeviceModeDistanceFilter() <= 0.0f) goto L11;
        if (this.g == null) goto L16;
        Message r0 = Message.obtain();
        r0.obj = r9;
        r0.what = 101;
        this.g.sendMessage(r0);
        return;
    L16:
        return;
    L11:
        if ((SystemClock.elapsedRealtime() - this.i) < (this.l.getInterval() - 200)) goto L17;
        this.i = SystemClock.elapsedRealtime();
        if (this.g == null) goto L18;
        Message r1 = Message.obtain();
        r1.obj = r9;
        r1.what = 101;
        this.g.sendMessage(r1);
        return;
    L18:
        return;
    }

    public static void d(l4 r12, Location r13) {
        Handler r0 = r12.g;
        if (r0 == null) goto L5;
        r0.removeMessages(100);
    L5:
        if (r13 == null) goto L111;
        AMapLocation r1 = new AMapLocation(r13);     // Catch: Throwable -> L96
        if (j4.l(r1) == true) goto L11;
        return;
    L11:
        if ("gps".equals(r13.getProvider()) == false) goto L13;
        String r2 = "gps_coarse";
    L14:
        r1.setProvider(r2);     // Catch: Throwable -> L96
        r1.setLocationType(11);     // Catch: Throwable -> L96
        if (r12.b == false) goto L17;
    L28:
        Boolean r3 = Boolean.FALSE;     // Catch: Throwable -> L96
        boolean r4 = false;
        Boolean r5 = (Boolean) f4.c(r13, "isFromMockProvider", new Object[0]);     // Catch: Throwable -> L99
        "CoarseLocation | isFromMock=".concat(String.valueOf(r5));     // Catch: Throwable -> L33
    L36:
        if (r5.booleanValue() == false) goto L43;
        r1.setMock(true);     // Catch: Throwable -> L96
        r1.setTrustedLevel(4);     // Catch: Throwable -> L96
        if (r12.l.isMockEnable() == true) goto L44;
        int r14 = r12.j;     // Catch: Throwable -> L96
        if (r14 <= 3) goto L42;
        h4.k(null, 2152);     // Catch: Throwable -> L96
        r1.setErrorCode(15);     // Catch: Throwable -> L96
        r1.setLocationDetail("CoarseLocation has been mocked!#2007");     // Catch: Throwable -> L96
        r1.setLatitude(0.0d);     // Catch: Throwable -> L96
        r1.setLongitude(0.0d);     // Catch: Throwable -> L96
        r1.setAltitude(0.0d);     // Catch: Throwable -> L96
        r1.setSpeed(0.0f);     // Catch: Throwable -> L96
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L96
        r1.setBearing(0.0f);     // Catch: Throwable -> L96
        r1.setExtras(null);     // Catch: Throwable -> L96
    L91:
        r12.j(r1);     // Catch: Throwable -> L96
        return;
    L42:
        r12.j = r14 + 1;     // Catch: Throwable -> L96
        return;
    L44:
        Bundle r15 = r13.getExtras();     // Catch: Throwable -> L96
        if (r15 == null) goto L47;
        int r16 = r15.getInt("satellites");     // Catch: Throwable -> L96
    L48:
        r1.setSatellites(r16);     // Catch: Throwable -> L96
        r12.l(r1);     // Catch: Throwable -> L96
        if (j4.l(r1) == true) goto L52;
    L61:
        if (j4.l(r1) == true) goto L64;
    L78:
        if (j4.l(r1) == false) goto L81;
        r12.c++;     // Catch: Throwable -> L96
    L81:
        r12.g(r1);     // Catch: Throwable -> L96
        Object r17 = r12.m;     // Catch: Throwable -> L96
        monitor-enter(r17);     // Catch: Throwable -> L96
        AMapLocation r6 = v;     // Catch: Throwable -> L93
        if (r6 != null) goto L86;
    L90:
        monitor-exit(r17);     // Catch: Throwable -> L93
    L86:
        if (r12.l.isNeedAddress() == false) goto L90;
        if (j4.a(r1, r6) >= r12.e) goto L90;
        c4.d(r1, r6);     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        throw th;     // Catch: Throwable -> L96
    L64:
        if (r12.c < 3) goto L78;
        if (r1.getAccuracy() >= 0.0f) goto L69;
    L70:
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L96
    L72:
        if (r1.getSpeed() >= 0.0f) goto L74;
    L75:
        r1.setSpeed(0.0f);     // Catch: Throwable -> L96
    L76:
        r1 = r12.d.a(r1);     // Catch: Throwable -> L96
        goto L78
    L74:
        if (r1.getSpeed() != Float.MAX_VALUE) goto L76;
    L69:
        if (r1.getAccuracy() != Float.MAX_VALUE) goto L72;
    L52:
        if (com.loc.h.w == true) goto L54;
    L56:
        if (r4 == false) goto L61;
        long r7 = r1.getTime();     // Catch: Throwable -> L96
        long r8 = System.currentTimeMillis();     // Catch: Throwable -> L96
        long r10 = d4.a(r7, r8, com.loc.h.x);     // Catch: Throwable -> L96
        if (r10 == r7) goto L61;
        r1.setTime(r10);     // Catch: Throwable -> L96
        h4.a(r7, r8);     // Catch: Throwable -> L96
        goto L61
    L54:
        if (com.loc.h.x <= 0) goto L56;
        r4 = true;
        goto L56
    L47:
        r16 = 0;
        goto L48
    L43:
        r12.j = 0;     // Catch: Throwable -> L96
    L33:
        r3 = r5;
    L34:
        r5 = r3;
        goto L36
    L17:
        if (j4.l(r1) == false) goto L28;
        Context r9 = r12.h;     // Catch: Throwable -> L96
        long r11 = SystemClock.elapsedRealtime() - r12.a;     // Catch: Throwable -> L96
        boolean r18 = c4.h(r1.getLatitude(), r1.getLongitude());     // Catch: Throwable -> L96
        List<r0> r19 = h4.g;     // Catch: Throwable -> L96
        if (r9 != null) goto L100;
    L27:
        r12.b = true;     // Catch: Throwable -> L96
        goto L28
    L100:
    L25:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportCoarseLocUseTime");     // Catch: Throwable -> L96
        goto L27
    L21:
        if (com.loc.h.b == false) goto L27;
        h4.e(r9, r11, r18, "O024");     // Catch: Throwable -> L25
    L13:
        r2 = "network_coarse";
    L96:
        th = move-exception;
        c4.g(th, "CoarseLocation", "onLocationChanged");
        return;
    }

    public static void k(LocationManager r18, String r19, long r20, float r22, LocationListener r23, Looper r24) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19, Long.valueOf(r20), Float.valueOf(r22), r23, r24};
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100001);
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
        f06.d r4 = r7.preInvoke(100001, "android/location/LocationManager", "requestLocationUpdates", r18, r1, "void", r11);     // Catch: Exception -> L21
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L21
    L17:
        if (r4.a == false) goto L19;
        return;
    L19:
        r18.requestLocationUpdates(r19, r20, r22, r23, r24);
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
}
