package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fi {
    static AMapLocation j = null;
    static long k = 0;
    static Object l = null;
    static long q = 0;
    static boolean t = false;
    static boolean u = false;
    public static volatile AMapLocation y;
    private long A;
    private int B;
    private int C;
    private GpsStatus D;
    private GpsStatus.Listener E;
    private GnssStatus.Callback F;
    private String G;
    private boolean H;
    private int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f5536J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f5537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LocationManager f5538b;
    AMapLocationClientOption c;
    long d;
    boolean e;
    dp f;
    int g;
    int h;
    AMapLocation i;
    long m;
    float n;
    Object o;
    Object p;
    AMapLocationClientOption.GeoLanguage r;
    boolean s;
    long v;
    int w;
    LocationListener x;
    private Context z;

    static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private fi f5541a;

        a(fi r1) {
            this.f5541a = r1;
        }

        final void a() {
            this.f5541a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r4) {
            Object[] r0 = new Object[2];     // Catch: Throwable -> L7
            String r1 = "tid=" + Thread.currentThread().getId();     // Catch: Throwable -> L7
            ex.a();     // Catch: Throwable -> L7
            fi r3 = this.f5541a;     // Catch: Throwable -> L7
            if (r3 == null) goto L10;
            fi.a(r3, r4);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r1) {
            fi r0 = this.f5541a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            fi.a(r0, r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
            fi r0 = this.f5541a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            fi.a(r0, r2);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    static {
        l = new Object();
    }

    public fi(Context r7, Handler r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.A = 0;
        this.d = 0;
        this.e = false;
        this.B = 0;
        this.f = null;
        this.g = 240;
        this.h = 80;
        this.i = null;
        this.m = 0;
        this.n = 0.0f;
        this.o = new Object();
        this.p = new Object();
        this.C = 0;
        this.D = null;
        this.E = null;
        this.r = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.s = true;
        this.v = 0;
        this.w = 0;
        this.x = null;
        this.G = null;
        this.H = false;
        this.I = 0;
        this.f5536J = false;
        Context r10 = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.z = r10;
        this.f5537a = r8;
        this.f5538b = (LocationManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
    L7:
        this.f = new dp();
        return;
    L5:
        th = move-exception;
        ev.a(th, "GpsLocation", "<init>");
        goto L7
    }

    static /* synthetic */ GpsStatus a(fi r0, GpsStatus r1) {
        r0.D = r1;
        return r1;
    }

    private void a(int r3) {
        if (r3 == 0) goto L7;
        return;
    L7:
        this.d = 0;     // Catch: Throwable -> L6
        this.C = 0;     // Catch: Throwable -> L6
        return;
    }

    private void a(int r4, int r5, String r6, long r7) {
        if (this.f5537a != null) goto L5;
        return;
    L5:
        if (this.c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L12;
        Message r0 = Message.obtain();     // Catch: Throwable -> L8
        AMapLocation r1 = new AMapLocation("");     // Catch: Throwable -> L8
        r1.setProvider("gps");     // Catch: Throwable -> L8
        r1.setErrorCode(r5);     // Catch: Throwable -> L8
        r1.setLocationDetail(r6);     // Catch: Throwable -> L8
        r1.setLocationType(1);     // Catch: Throwable -> L8
        r0.obj = r1;     // Catch: Throwable -> L8
        r0.what = r4;     // Catch: Throwable -> L8
        this.f5537a.sendMessageDelayed(r0, r7);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }

    private void a(GnssStatus r5) {
        int r0 = 0;
        if (r5 != null) goto L20;
    L18:
        this.C = r0;
        return;
    L20:
    L16:
        th = th;
    L17:
        ev.a(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
        goto L18
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L18;
        int r1 = r5.getSatelliteCount();     // Catch: Throwable -> L16
        int r2 = 0;
    L8:
        if (r0 >= r1) goto L15;
        if (r5.usedInFix(r0) == false) goto L12;
        r2 = r2 + 1;
    L12:
        r0 = r0 + 1;
    L13:
        th = th;
        r0 = r2;
        goto L17
    L15:
        r0 = r2;
        goto L18
    }

    private void a(Location r10) {
        Handler r0 = this.f5537a;
        if (r0 == null) goto L5;
        r0.removeMessages(8);
    L5:
        if (r10 != null) goto L58;
        return;
    L58:
        AMapLocation r1 = new AMapLocation(r10);     // Catch: Throwable -> L51
        if (fd.a(r1) == true) goto L10;
        return;
    L10:
        r1.setProvider("gps");     // Catch: Throwable -> L51
        r1.setLocationType(1);     // Catch: Throwable -> L51
        if (this.e == true) goto L16;
        if (fd.a(r1) == false) goto L16;
        fb.a(this.z, fd.b() - this.A, ev.a(r1.getLatitude(), r1.getLongitude()));     // Catch: Throwable -> L51
        this.e = true;     // Catch: Throwable -> L51
    L16:
        if (fd.a(r1, this.C) == false) goto L25;
        r1.setMock(true);     // Catch: Throwable -> L51
        r1.setTrustedLevel(4);     // Catch: Throwable -> L51
        if (this.c.isMockEnable() == true) goto L26;
        int r11 = this.w;     // Catch: Throwable -> L51
        if (r11 <= 3) goto L23;
        fb.a(null, 2152);     // Catch: Throwable -> L51
        r1.setErrorCode(15);     // Catch: Throwable -> L51
        r1.setLocationDetail("GpsLocation has been mocked!#1501");     // Catch: Throwable -> L51
        r1.setLatitude(0.0d);     // Catch: Throwable -> L51
        r1.setLongitude(0.0d);     // Catch: Throwable -> L51
        r1.setAltitude(0.0d);     // Catch: Throwable -> L51
        r1.setSpeed(0.0f);     // Catch: Throwable -> L51
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L51
        r1.setBearing(0.0f);     // Catch: Throwable -> L51
        r1.setExtras(null);     // Catch: Throwable -> L51
        c(r1);     // Catch: Throwable -> L51
        return;
    L23:
        this.w = r11 + 1;     // Catch: Throwable -> L51
        return;
    L26:
        r1.setSatellites(this.C);     // Catch: Throwable -> L51
        e(r1);     // Catch: Throwable -> L51
        f(r1);     // Catch: Throwable -> L51
        h(r1);     // Catch: Throwable -> L51
        AMapLocation r2 = g(r1);     // Catch: Throwable -> L51
        a(r2);     // Catch: Throwable -> L51
        b(r2);     // Catch: Throwable -> L51
        Object r3 = this.o;     // Catch: Throwable -> L51
        monitor-enter(r3);     // Catch: Throwable -> L51
        a(r2, y);     // Catch: Throwable -> L48
        monitor-exit(r3);     // Catch: Throwable -> L48
    L59:
    L44:
        th = move-exception;
        ev.a(th, "GpsLocation", "onLocationChangedLast");     // Catch: Throwable -> L51
    L46:
        c(r2);     // Catch: Throwable -> L51
        return;
    L31:
        if (fd.a(r2) == false) goto L46;
        if (this.i == null) goto L35;
        this.m = r10.getTime() - this.i.getTime();     // Catch: Throwable -> L44
        this.n = fd.a(this.i, r2);     // Catch: Throwable -> L44
    L35:
        Object r12 = this.p;     // Catch: Throwable -> L44
        monitor-enter(r12);     // Catch: Throwable -> L44
        this.i = r2.clone();     // Catch: Throwable -> L41
        monitor-exit(r12);     // Catch: Throwable -> L41
        this.G = null;     // Catch: Throwable -> L44
        this.H = false;     // Catch: Throwable -> L44
        this.I = 0;     // Catch: Throwable -> L44
        goto L46
    L41:
        th = move-exception;
        throw th;     // Catch: Throwable -> L44
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L25:
        this.w = 0;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        ev.a(th, "GpsLocation", "onLocationChanged");
    }

    private void a(AMapLocation r4) {
        if (fd.a(r4) == true) goto L5;
        return;
    L5:
        this.d = fd.b();
        Object r0 = l;
        monitor-enter(r0);
        k = fd.b();     // Catch: Throwable -> L11
        j = r4.clone();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.B++;
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void a(AMapLocation r2, AMapLocation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.c.isNeedAddress() == true) goto L6;
        return;
    L6:
        if (fd.a(r2, r3) >= this.g) goto L11;
        ev.a(r2, r3);
        return;
    }

    static /* synthetic */ void a(fi r0) {
        r0.k();
    }

    static /* synthetic */ void a(fi r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(fi r0, GnssStatus r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(fi r0, Location r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(fi r0, String r1) {
        r0.a(r1);
    }

    private void a(String r3) {
        if ("gps".equalsIgnoreCase(r3) == false) goto L9;
        this.d = 0;     // Catch: Throwable -> L6
        this.C = 0;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private static boolean a(LocationManager r2) {
    L15:
        th = move-exception;
        Object[] r0 = new Object[1];
        String r1 = "GpsLocation | hasProvider error: " + th.getMessage();
        ex.a();
        return u;
    L4:
        if (t == true) goto L6;
        List<String> r3 = r2.getAllProviders();     // Catch: Throwable -> L15
        if (r3 != null) goto L10;
    L12:
        u = false;     // Catch: Throwable -> L15
    L13:
        t = true;     // Catch: Throwable -> L15
        return u;
    L10:
        if (r3.size() <= 0) goto L12;
        u = r3.contains("gps");     // Catch: Throwable -> L15
        goto L13
    L6:
        return u;
    }

    static /* synthetic */ GpsStatus b(fi r0) {
        return r0.D;
    }

    private void b(AMapLocation r7) {
        if (fd.a(r7) == true) goto L6;
        return;
    L6:
        if (this.f5537a == null) goto L25;
        long r0 = fd.b();
        if (this.c.getInterval() > 8000) goto L10;
    L11:
        Bundle r1 = new Bundle();
        r1.putDouble("lat", r7.getLatitude());
        r1.putDouble("lon", r7.getLongitude());
        r1.putFloat("radius", r7.getAccuracy());
        r1.putLong(OaidModel.KEY_TIME, r7.getTime());
        Message r2 = Message.obtain();
        r2.setData(r1);
        r2.what = 5;
        Object r3 = this.o;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (y != null) goto L18;
        Handler r6 = this.f5537a;     // Catch: Throwable -> L22
    L16:
        r6.sendMessage(r2);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L18:
        if (fd.a(r7, y) <= this.h) goto L20;
        r6 = this.f5537a;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r0 - this.v) > (this.c.getInterval() - 8000)) goto L11;
        return;
    }

    private boolean b(String r5) {
        ArrayList<String> r1 = fd.b(r5);     // Catch: Throwable -> L10
        ArrayList<String> r2 = fd.b(this.G);     // Catch: Throwable -> L10
        if (r1.size() >= 8) goto L6;
        return false;
    L6:
        if (r2.size() < 8) goto L14;
        return fd.a(this.G, r5);
    L14:
        return false;
    L15:
        return false;
    }

    private void c(AMapLocation r7) {
        if (r7.getErrorCode() != 15) goto L8;
        if (AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.c.getLocationMode()) == true) goto L8;
        return;
    L8:
        if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) == false) goto L14;
        if (this.c.getDeviceModeDistanceFilter() <= 0.0f) goto L14;
        d(r7);
        return;
    L14:
        if ((fd.b() - this.v) < (this.c.getInterval() - 200)) goto L17;
        this.v = fd.b();
        d(r7);
        return;
    }

    static /* synthetic */ void c(fi r0) {
        r0.m();
    }

    private void d(AMapLocation r2) {
        if (this.f5537a == null) goto L6;
        Message r0 = Message.obtain();
        r0.obj = r2;
        r0.what = 2;
        this.f5537a.sendMessage(r0);
        return;
    }

    private void e(AMapLocation r9) {
    L11:
        r9.setOffset(false);
        r9.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        return;
    L4:
        if (ev.a(r9.getLatitude(), r9.getLongitude()) == true) goto L6;
    L9:
        r9.setOffset(false);     // Catch: Throwable -> L11
        r9.setCoordType(AMapLocation.COORD_TYPE_WGS84);     // Catch: Throwable -> L11
        return;
    L6:
        if (this.c.isOffset() == false) goto L9;
        DPoint r2 = ey.a(this.z, new DPoint(r9.getLatitude(), r9.getLongitude()));     // Catch: Throwable -> L11
        r9.setLatitude(r2.getLatitude());     // Catch: Throwable -> L11
        r9.setLongitude(r2.getLongitude());     // Catch: Throwable -> L11
        r9.setOffset(this.c.isOffset());     // Catch: Throwable -> L11
        r9.setCoordType(AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L11
    }

    private void f(AMapLocation r2) {
        int r1 = this.C;     // Catch: Throwable -> L11
        if (r1 < 4) goto L6;
        r2.setGpsAccuracyStatus(1);     // Catch: Throwable -> L11
        return;
    L6:
        if (r1 != 0) goto L9;
        r2.setGpsAccuracyStatus(-1);     // Catch: Throwable -> L11
        return;
    L9:
        r2.setGpsAccuracyStatus(0);     // Catch: Throwable -> L11
        return;
    }

    private AMapLocation g(AMapLocation r4) {
        if (fd.a(r4) == true) goto L6;
        return r4;
    L6:
        if (this.B >= 3) goto L9;
        return r4;
    L9:
        if (r4.getAccuracy() >= 0.0f) goto L11;
    L12:
        r4.setAccuracy(0.0f);
    L14:
        if (r4.getSpeed() >= 0.0f) goto L16;
    L17:
        r4.setSpeed(0.0f);
    L19:
        return this.f.a(r4);
    L16:
        if (r4.getSpeed() != Float.MAX_VALUE) goto L19;
    L11:
        if (r4.getAccuracy() != Float.MAX_VALUE) goto L14;
        goto L12
    }

    static /* synthetic */ void g() {
        j();
    }

    static /* synthetic */ void h() {
        l();
    }

    private static void h(AMapLocation r7) {
        if (fd.a(r7) == true) goto L6;
        return;
    L6:
        if (eu.s() == false) goto L11;
        long r0 = r7.getTime();
        long r2 = System.currentTimeMillis();
        long r4 = ew.a(r0, r2, eu.t());
        if (r4 == r0) goto L12;
        r7.setTime(r4);
        fb.a(r0, r2);
        return;
    L12:
        return;
    }

    private void i() {
        if (this.f5538b != null) goto L47;
        return;
    L47:
        n();     // Catch: Throwable -> L38 SecurityException -> L41
        this.s = true;     // Catch: Throwable -> L38 SecurityException -> L41
        Looper r2 = Looper.myLooper();     // Catch: Throwable -> L38 SecurityException -> L41
        if (r2 != null) goto L9;
        r2 = this.z.getMainLooper();     // Catch: Throwable -> L38 SecurityException -> L41
    L9:
        Looper r9 = r2;
        this.A = fd.b();     // Catch: Throwable -> L38 SecurityException -> L41
        if (a(this.f5538b) == true) goto L45;
        Object[] r3 = new Object[1];     // Catch: Throwable -> L38 SecurityException -> L41
        ex.a();     // Catch: Throwable -> L38 SecurityException -> L41
        a(8, 14, "no gps provider#1402", 0);     // Catch: Throwable -> L38 SecurityException -> L41
        return;
    L45:
    L18:
        th = move-exception;
        Object[] r4 = new Object[1];     // Catch: Throwable -> L38 SecurityException -> L41
        String r0 = "GpsLocation | sendExtraCommand error: " + th.getMessage();     // Catch: Throwable -> L38 SecurityException -> L41
        ex.a();     // Catch: Throwable -> L38 SecurityException -> L41
    L21:
        if (this.x != null) goto L24;
        this.x = new a(this);     // Catch: Throwable -> L38 SecurityException -> L41
    L24:
        if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) == true) goto L26;
    L29:
        LocationManager r5 = this.f5538b;     // Catch: Throwable -> L38 SecurityException -> L41
        String r6 = "gps";
        long r7 = 900;
        float r8 = 0.0f;
        LocationListener r10 = this.x;     // Catch: Throwable -> L38 SecurityException -> L41
    L28:
        r5.requestLocationUpdates(r6, r7, r8, r10, r9);     // Catch: Throwable -> L38 SecurityException -> L41
        if (Build.VERSION.SDK_INT < 24) goto L33;
        GnssStatus.Callback r11 = new AnonymousClass1(this);     // Catch: Throwable -> L38 SecurityException -> L41
        this.F = r11;     // Catch: Throwable -> L38 SecurityException -> L41
        this.f5538b.registerGnssStatusCallback(r11);     // Catch: Throwable -> L38 SecurityException -> L41
    L34:
        a(8, 14, "no enough satellites#1401", this.c.getHttpTimeOut());     // Catch: Throwable -> L38 SecurityException -> L41
        return;
    L33:
        GpsStatus.Listener r12 = new AnonymousClass2(this);     // Catch: Throwable -> L38 SecurityException -> L41
        this.E = r12;     // Catch: Throwable -> L38 SecurityException -> L41
        this.f5538b.addGpsStatusListener(r12);     // Catch: Throwable -> L38 SecurityException -> L41
        Object[] r13 = new Object[1];     // Catch: Throwable -> L38 SecurityException -> L41
        ex.a();     // Catch: Throwable -> L38 SecurityException -> L41
        goto L34
    L26:
        if (this.c.getDeviceModeDistanceFilter() <= 0.0f) goto L29;
        r5 = this.f5538b;     // Catch: Throwable -> L38 SecurityException -> L41
        r6 = "gps";
        r7 = this.c.getInterval();     // Catch: Throwable -> L38 SecurityException -> L41
        r8 = this.c.getDeviceModeDistanceFilter();     // Catch: Throwable -> L38 SecurityException -> L41
        r10 = this.x;     // Catch: Throwable -> L38 SecurityException -> L41
        goto L28
    L12:
        if ((fd.a() - q) >= 259200000) goto L14;
    L44:
        goto L21
    L14:
        if (fd.c(this.z, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L16;
        this.f5538b.sendExtraCommand("gps", "force_xtra_injection", null);     // Catch: Throwable -> L18
        q = fd.a();     // Catch: Throwable -> L18
        SharedPreferences.Editor r14 = fc.a(this.z, "pref");     // Catch: Throwable -> L18
        fc.a(r14, "lagt", q);     // Catch: Throwable -> L18
        fc.a(r14);     // Catch: Throwable -> L18
        Object[] r15 = new Object[1];     // Catch: Throwable -> L18
        ex.a();     // Catch: Throwable -> L18
        goto L44
    L16:
        ev.a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");     // Catch: Throwable -> L18
    L41:
        e = move-exception;
        Object[] r1 = new Object[1];
        ex.a();
        this.s = false;
        fb.a(null, 2121);
        a(2, 12, e.getMessage() + "#1201", 0);
        return;
    L38:
        th = move-exception;
        Object[] r16 = new Object[1];
        String r17 = "GpsLocation | requestLocationUpdates error: " + th.getMessage();
        ex.a();
        ev.a(th, "GpsLocation", "requestLocationUpdates part2");
    }

    private static void j() {
        Object[] r0 = new Object[1];
        ex.a();
    }

    private void k() {
        Object[] r0 = new Object[1];
        ex.a();
        this.C = 0;
    }

    private static void l() {
        Object[] r0 = new Object[1];
        ex.a();
    }

    private void m() {
        int r0 = 0;
        GpsStatus r1 = this.D;     // Catch: Throwable -> L14
        if (r1 == null) goto L16;
        Iterable<GpsSatellite> r2 = r1.getSatellites();     // Catch: Throwable -> L14
        if (r2 == null) goto L16;
        Iterator<GpsSatellite> r3 = r2.iterator();     // Catch: Throwable -> L14
        int r4 = this.D.getMaxSatellites();     // Catch: Throwable -> L14
    L9:
        if (r3.hasNext() == false) goto L16;
        if (r0 >= r4) goto L16;
        if (((GpsSatellite) ZeusTransformUtils.preCheckCast(r3.next(), GpsSatellite.class, "com.obric.memorydata.plugin")).usedInFix() == false) goto L9;
        r0 = r0 + 1;
    L16:
        this.C = r0;
        return;
    L14:
        th = move-exception;
        ev.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        goto L16
    }

    private void n() {
        if ((fd.b() - k) <= 5000) goto L5;
        return;
    L5:
        if (fd.a(j) == true) goto L7;
        return;
    L7:
        if (this.c.isMockEnable() == false) goto L9;
    L11:
        this.d = fd.b();
        c(j);
        return;
    L9:
        if (j.isMock() == false) goto L11;
    }

    private static boolean o() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(ez.a(fx.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), fx.c("UaXNOYXZpU3RhcnRlZA=="), null, null), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L4:
        return false;
    }

    private AMapLocation p() {
        if (fd.a(this.i) == true) goto L7;
        return null;
    L7:
        if (eu.k() == true) goto L10;
        return null;
    L10:
        if (o() == false) goto L37;
        JSONObject r2 = new JSONObject((String) ZeusTransformUtils.preCheckCast(ez.a(fx.c("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), fx.c("UZ2V0TmF2aUxvY2F0aW9u"), null, null), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L39
        long r3 = r2.optLong(OaidModel.KEY_TIME);     // Catch: Throwable -> L39
        if (this.f5536J == true) goto L15;
        this.f5536J = true;     // Catch: Throwable -> L39
        fb.a("useNaviLoc", "use NaviLoc");     // Catch: Throwable -> L39
    L15:
        if ((fd.a() - r3) > 5500) goto L37;
        double r7 = r2.optDouble("lat", 0.0d);     // Catch: Throwable -> L39
        double r9 = r2.optDouble("lng", 0.0d);     // Catch: Throwable -> L39
        float r1 = 0.0f;
        float r11 = Float.parseFloat(r2.optString(LocationMonitorConst.ACCURACY, "0"));     // Catch: NumberFormatException -> L20 Throwable -> L39
    L21:
        double r5 = r2.optDouble("altitude", 0.0d);     // Catch: Throwable -> L39
        float r12 = Float.parseFloat(r2.optString("bearing", "0"));     // Catch: NumberFormatException -> L24 Throwable -> L39
    L48:
        r1 = (Float.parseFloat(r2.optString("speed", "0")) * 10.0f) / 36.0f;
    L27:
        AMapLocation r4 = new AMapLocation("lbs");     // Catch: Throwable -> L39
        r4.setLocationType(9);     // Catch: Throwable -> L39
        r4.setLatitude(r7);     // Catch: Throwable -> L39
        r4.setLongitude(r9);     // Catch: Throwable -> L39
        r4.setAccuracy(r11);     // Catch: Throwable -> L39
        r4.setAltitude(r5);     // Catch: Throwable -> L39
        r4.setBearing(r12);     // Catch: Throwable -> L39
        r4.setSpeed(r1);     // Catch: Throwable -> L39
        r4.setTime(r3);     // Catch: Throwable -> L39
        r4.setCoordType(AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L39
        if (fd.a(r4, this.i) > 300.0f) goto L37;
        Object r6 = this.p;     // Catch: Throwable -> L39
        monitor-enter(r6);     // Catch: Throwable -> L39
        this.i.setLongitude(r9);     // Catch: Throwable -> L34
        this.i.setLatitude(r7);     // Catch: Throwable -> L34
        this.i.setAccuracy(r11);     // Catch: Throwable -> L34
        this.i.setBearing(r12);     // Catch: Throwable -> L34
        this.i.setSpeed(r1);     // Catch: Throwable -> L34
        this.i.setTime(r3);     // Catch: Throwable -> L34
        this.i.setCoordType(AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L34
        monitor-exit(r6);     // Catch: Throwable -> L34
        return r4;
    L34:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L24:
        r12 = 0.0f;
    L20:
        r11 = 0.0f;
    L37:
        return null;
    }

    public final AMapLocation a(AMapLocation r17, String r18) {
        if (this.i != null) goto L6;
        return r17;
    L6:
        if (this.c.isMockEnable() == true) goto L11;
        if (this.i.isMock() == false) goto L11;
        return r17;
    L11:
        if (fd.a(this.i) == true) goto L13;
        return r17;
    L13:
        AMapLocation r2 = p();
        if (r2 != null) goto L16;
    L19:
        float r3 = this.i.getSpeed();
        if (r3 != 0.0f) goto L29;
        long r8 = this.m;
        if (r8 <= 0) goto L29;
        if (r8 >= 8) goto L29;
        float r5 = this.n;
        if (r5 <= 0.0f) goto L29;
        r3 = r5 / r8;
    L29:
        if (r17 != null) goto L31;
    L48:
        long r10 = 30000;
    L49:
        long r12 = fd.b() - this.d;
        if (r12 <= 30000) goto L53;
        return r17;
    L53:
        if (r12 < r10) goto L70;
        if (this.H == true) goto L57;
    L60:
        this.G = null;
        this.I = 0;
        Object r4 = this.p;
        monitor-enter(r4);
        this.i = null;     // Catch: Throwable -> L66
        monitor-exit(r4);     // Catch: Throwable -> L66
        this.m = 0;
        this.n = 0.0f;
        return r17;
    L66:
        th = move-exception;
        throw th;
    L57:
        if (b(r18) == false) goto L60;
        AMapLocation r0 = this.i.clone();
        r0.setTrustedLevel(3);
        return r0;
    L70:
        if (this.G == null) goto L72;
    L74:
        AMapLocation r1 = this.i.clone();
        r1.setTrustedLevel(2);
        return r1;
    L72:
        if (this.I < 2) goto L74;
        this.G = r18;
        goto L74
    L31:
        if (fd.a(r17) == false) goto L48;
        if (r17.getAccuracy() >= 200.0f) goto L43;
        int r11 = this.I + 1;
        this.I = r11;
        if (this.G != null) goto L39;
        if (r11 < 2) goto L39;
        this.H = true;
    L39:
        if (r3 <= 5.0f) goto L41;
        r10 = 10000;
        goto L49
    L41:
        r10 = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        goto L49
    L43:
        if (TextUtils.isEmpty(this.G) == true) goto L46;
        this.H = false;
        this.I = 0;
    L46:
        if (r3 <= 5.0f) goto L48;
        r10 = 20000;
        goto L49
    L16:
        if (fd.a(r2) == false) goto L19;
        r2.setTrustedLevel(2);
        return r2;
    }

    public final void a() {
        LocationManager r0 = this.f5538b;
        if (r0 != null) goto L30;
        return;
    L30:
        LocationListener r2 = this.x;     // Catch: Throwable -> L20
        if (r2 == null) goto L26;
        r0.removeUpdates(r2);     // Catch: Throwable -> L20
        ((a) ZeusTransformUtils.preCheckCast(this.x, a.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L20
        this.x = null;     // Catch: Throwable -> L20
    L26:
        GpsStatus.Listener r1 = this.E;     // Catch: Throwable -> L21
        if (r1 == null) goto L24;
        this.f5538b.removeGpsStatusListener(r1);     // Catch: Throwable -> L21
    L24:
        GnssStatus.Callback r3 = this.F;     // Catch: Throwable -> L22
        if (r3 == null) goto L28;
        this.f5538b.unregisterGnssStatusCallback(r3);     // Catch: Throwable -> L22
    L28:
        Handler r4 = this.f5537a;     // Catch: Throwable -> L23
        if (r4 == null) goto L18;
        r4.removeMessages(8);     // Catch: Throwable -> L23
    L18:
        this.C = 0;
        this.A = 0;
        this.v = 0;
        this.d = 0;
        this.B = 0;
        this.w = 0;
        this.f.a();
        this.i = null;
        this.m = 0;
        this.n = 0.0f;
        this.G = null;
        this.f5536J = false;
    }

    public final void a(Bundle r3) {
        if (r3 == null) goto L20;
        r3.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.g = r3.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.h = r3.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r4 = (AMapLocation) ZeusTransformUtils.preCheckCast(r3.getParcelable("loc"), AMapLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r4.getAdCode()) == true) goto L21;
        Object r2 = this.o;     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        y = r4;     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        ev.a(th, "GpsLocation", "setLastGeoLocation");
        return;
    }

    public final void a(AMapLocationClientOption r5) {
        this.c = r5;
        if (r5 != null) goto L9;
        this.c = new AMapLocationClientOption();
    L9:
        q = fc.a(this.z, "pref", "lagt", q);     // Catch: Throwable -> L8
    L6:
        i();
    }

    public final void b(AMapLocationClientOption r2) {
        if (r2 != null) goto L4;
        r2 = new AMapLocationClientOption();
    L4:
        this.c = r2;
        if (r2.getLocationMode() == AMapLocationClientOption.AMapLocationMode.Device_Sensors) goto L10;
        Handler r3 = this.f5537a;
        if (r3 == null) goto L10;
        r3.removeMessages(8);
    L10:
        if (this.r == this.c.getGeoLanguage()) goto L20;
        Object r4 = this.o;
        monitor-enter(r4);
        y = null;     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L20:
        this.r = this.c.getGeoLanguage();
    }

    public final boolean b() {
        if ((fd.b() - this.d) <= 2800) goto L6;
        return false;
    L6:
        return true;
    }

    public final void c() {
        this.w = 0;
    }

    public final int d() {
        LocationManager r0 = this.f5538b;
        if (r0 != null) goto L6;
        return 1;
    L6:
        if (a(r0) == true) goto L9;
        return 1;
    L9:
        if (Build.VERSION.SDK_INT < 19) goto L11;
        int r1 = Settings.Secure.getInt(this.z.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0);
        if (r1 != 0) goto L16;
        return 2;
    L16:
        if (r1 != 2) goto L20;
        return 3;
    L20:
        if (this.s == true) goto L23;
        return 4;
    L23:
        return 0;
    L11:
        if (this.f5538b.isProviderEnabled("gps") == true) goto L20;
        return 2;
    }

    public final int e() {
        return this.C;
    }

    public final boolean f() {
        AMapLocationClientOption r0 = this.c;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isOnceLocation() == true) goto L11;
        if ((fd.b() - this.d) <= 300000) goto L11;
        return true;
    }
}
