package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ff {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile AMapLocation f5529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f5530b = "CoarseLocation";
    private static long q = 0;
    private static boolean r = false;
    private static boolean s = false;
    private static boolean t = false;
    private static boolean u = false;
    private long c;
    private boolean d;
    private int e;
    private dp f;
    private int g;
    private int h;
    private int i;
    private Handler j;
    private Context k;
    private long l;
    private int m;
    private LocationManager n;
    private AMapLocationClientOption o;
    private Object p;
    private boolean v;
    private AMapLocationClientOption.GeoLanguage w;
    private LocationListener x;

    static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ff f5531a;

        a(ff r1) {
            this.f5531a = r1;
        }

        final void a() {
            this.f5531a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r1) {
            ff r0 = this.f5531a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            ff.a(r0, r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r1) {
            ff r0 = this.f5531a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            ff.a(r0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r1) {
            if ("gps".equalsIgnoreCase(r1) == false) goto L6;
            Object[] r0 = new Object[1];
            ex.a();
            return;
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
            ff r0 = this.f5531a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            ff.a(r0, r2);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    static {
    }

    public ff(Context r7, Handler r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.c = 0;
        this.d = false;
        this.e = 0;
        this.f = null;
        this.g = 240;
        this.h = 80;
        this.i = 0;
        this.l = 0;
        this.m = 0;
        this.p = new Object();
        this.v = true;
        this.w = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.x = null;
        Context r10 = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.k = r10;
        this.j = r8;
        this.n = (LocationManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
    L7:
        this.f = new dp();
        return;
    L5:
        th = move-exception;
        ev.a(th, f5530b, "<init>");
        goto L7
    }

    private static es a(int r2, String r3) {
        es r0 = new es("");
        r0.setErrorCode(r2);
        r0.setLocationDetail(r3);
        return r0;
    }

    private void a(int r1) {
        if (r1 == 0) goto L7;
        return;
    L7:
        Object[] r2 = new Object[1];     // Catch: Throwable -> L6
        ex.a();     // Catch: Throwable -> L6
        this.i = 0;     // Catch: Throwable -> L6
        return;
    }

    private void a(int r4, String r5, long r6) {
    L6:
        ex.b();
        return;
    L3:
        if (this.j == null) goto L10;
        Message r0 = Message.obtain();     // Catch: Throwable -> L6
        AMapLocation r1 = new AMapLocation("");     // Catch: Throwable -> L6
        r1.setErrorCode(20);     // Catch: Throwable -> L6
        r1.setLocationDetail(r5);     // Catch: Throwable -> L6
        r1.setLocationType(11);     // Catch: Throwable -> L6
        r0.obj = r1;     // Catch: Throwable -> L6
        r0.what = r4;     // Catch: Throwable -> L6
        this.j.sendMessageDelayed(r0, r6);     // Catch: Throwable -> L6
        return;
    }

    private void a(Location r10) {
        Handler r0 = this.j;
        if (r0 == null) goto L5;
        r0.removeMessages(100);
    L5:
        if (r10 != null) goto L57;
        return;
    L57:
        AMapLocation r1 = new AMapLocation(r10);     // Catch: Throwable -> L46
        if (fd.a(r1) == true) goto L11;
        return;
    L11:
        if ("gps".equals(r10.getProvider()) == false) goto L14;
        String r2 = "gps_coarse";
    L13:
        r1.setProvider(r2);     // Catch: Throwable -> L46
        r1.setLocationType(11);     // Catch: Throwable -> L46
        if (this.d == false) goto L18;
    L20:
        Boolean r3 = Boolean.FALSE;     // Catch: Throwable -> L46
        if (Build.VERSION.SDK_INT < 18) goto L27;
        Boolean r4 = (Boolean) ZeusTransformUtils.preCheckCast(ez.a(r10, "isFromMockProvider", new Object[0]), Boolean.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
        Object[] r5 = new Object[1];     // Catch: Throwable -> L49
        "CoarseLocation | isFromMock=".concat(String.valueOf(r4));     // Catch: Throwable -> L49
        ex.a();     // Catch: Throwable -> L49
    L25:
        r3 = r4;
    L27:
        if (r3.booleanValue() == false) goto L36;
        r1.setMock(true);     // Catch: Throwable -> L46
        r1.setTrustedLevel(4);     // Catch: Throwable -> L46
        if (this.o.isMockEnable() == true) goto L37;
        int r11 = this.m;     // Catch: Throwable -> L46
        if (r11 <= 3) goto L34;
        fb.a(null, 2152);     // Catch: Throwable -> L46
        r1.setErrorCode(15);     // Catch: Throwable -> L46
        r1.setLocationDetail("CoarseLocation has been mocked!#2007");     // Catch: Throwable -> L46
        r1.setLatitude(0.0d);     // Catch: Throwable -> L46
        r1.setLongitude(0.0d);     // Catch: Throwable -> L46
        r1.setAltitude(0.0d);     // Catch: Throwable -> L46
        r1.setSpeed(0.0f);     // Catch: Throwable -> L46
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L46
        r1.setBearing(0.0f);     // Catch: Throwable -> L46
        r1.setExtras(null);     // Catch: Throwable -> L46
        c(r1);     // Catch: Throwable -> L46
        return;
    L34:
        this.m = r11 + 1;     // Catch: Throwable -> L46
        return;
    L37:
        int r12 = b(r10);     // Catch: Throwable -> L46
        this.i = r12;     // Catch: Throwable -> L46
        r1.setSatellites(r12);     // Catch: Throwable -> L46
        e(r1);     // Catch: Throwable -> L46
        g(r1);     // Catch: Throwable -> L46
        AMapLocation r13 = f(r1);     // Catch: Throwable -> L46
        a(r13);     // Catch: Throwable -> L46
        b(r13);     // Catch: Throwable -> L46
        Object r6 = this.p;     // Catch: Throwable -> L46
        monitor-enter(r6);     // Catch: Throwable -> L46
        a(r13, f5529a);     // Catch: Throwable -> L43
        monitor-exit(r6);     // Catch: Throwable -> L43
        c(r13);     // Catch: Throwable -> L46
        return;
    L43:
        th = move-exception;
        throw th;     // Catch: Throwable -> L46
    L36:
        this.m = 0;     // Catch: Throwable -> L46
        goto L37
    L18:
        if (fd.a(r1) == false) goto L20;
        fb.b(this.k, fd.b() - this.c, ev.a(r1.getLatitude(), r1.getLongitude()));     // Catch: Throwable -> L46
        this.d = true;     // Catch: Throwable -> L46
        goto L20
    L14:
        r2 = "network_coarse";
    L46:
        th = move-exception;
        ev.a(th, "CoarseLocation", "onLocationChanged");
    }

    private void a(AMapLocation r1) {
        if (fd.a(r1) == true) goto L5;
        return;
    L5:
        this.e++;
    }

    private void a(AMapLocation r2, AMapLocation r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.o.isNeedAddress() == true) goto L6;
        return;
    L6:
        if (fd.a(r2, r3) >= this.g) goto L11;
        ev.a(r2, r3);
        return;
    }

    static /* synthetic */ void a(ff r0) {
        r0.g();
    }

    static /* synthetic */ void a(ff r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(ff r0, Location r1) {
        r0.a(r1);
    }

    private static boolean a(LocationManager r2) {
    L15:
        th = move-exception;
        Object[] r0 = new Object[1];
        String r1 = "CoarseLocation | hasProvider error: " + th.getMessage();
        ex.a();
        return s;
    L4:
        if (r == true) goto L6;
        List<String> r3 = r2.getAllProviders();     // Catch: Throwable -> L15
        if (r3 != null) goto L10;
    L12:
        s = false;     // Catch: Throwable -> L15
    L13:
        r = true;     // Catch: Throwable -> L15
        return s;
    L10:
        if (r3.size() <= 0) goto L12;
        s = r3.contains("gps");     // Catch: Throwable -> L15
        goto L13
    L6:
        return s;
    }

    private static int b(Location r1) {
        Bundle r2 = r1.getExtras();
        if (r2 == null) goto L5;
        int r3 = r2.getInt("satellites");
    L6:
        ex.b();
        return r3;
    L5:
        r3 = 0;
        goto L6
    }

    private void b(AMapLocation r7) {
        if (fd.a(r7) == true) goto L6;
        return;
    L6:
        if (this.j == null) goto L25;
        long r0 = fd.b();
        if (this.o.getInterval() > 8000) goto L10;
    L11:
        Bundle r1 = new Bundle();
        r1.putDouble("lat", r7.getLatitude());
        r1.putDouble("lon", r7.getLongitude());
        r1.putFloat("radius", r7.getAccuracy());
        r1.putLong(OaidModel.KEY_TIME, r7.getTime());
        Message r2 = Message.obtain();
        r2.setData(r1);
        r2.what = 102;
        Object r3 = this.p;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (f5529a != null) goto L18;
        Handler r6 = this.j;     // Catch: Throwable -> L22
    L16:
        r6.sendMessage(r2);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L18:
        if (fd.a(r7, f5529a) <= this.h) goto L20;
        r6 = this.j;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r0 - this.l) > (this.o.getInterval() - 8000)) goto L11;
        return;
    }

    private static boolean b(LocationManager r2) {
    L9:
        th = move-exception;
        Object[] r0 = new Object[1];
        String r1 = "CoarseLocation | hasProvider error: " + th.getMessage();
        ex.a();
        return u;
    L4:
        if (t == true) goto L6;
        boolean r3 = r2.isProviderEnabled("network");     // Catch: Throwable -> L9
        u = r3;     // Catch: Throwable -> L9
        t = true;     // Catch: Throwable -> L9
        return r3;
    L6:
        return u;
    }

    private void c(AMapLocation r7) {
        if (this.o.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) == false) goto L9;
        if (this.o.getDeviceModeDistanceFilter() <= 0.0f) goto L9;
        d(r7);
        return;
    L9:
        if ((fd.b() - this.l) < (this.o.getInterval() - 200)) goto L12;
        this.l = fd.b();
        d(r7);
        return;
    }

    private boolean c() {
    L19:
        boolean r1 = true;
    L20:
        Object[] r7 = new Object[1];
        ex.a();
    L22:
        return r1;
    L4:
        if (fd.c() >= 28) goto L7;
        r1 = true;
    L26:
        if (fd.c() < 24) goto L22;
        if (fd.c() >= 28) goto L22;
        if (Settings.Secure.getInt(this.k.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) != 0) goto L22;
        return false;
    L7:
        if (this.n != null) goto L9;
        this.n = (LocationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.k.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
    L9:
        r1 = ((Boolean) ZeusTransformUtils.preCheckCast(ez.a(this.n, "isLocationEnabled", new Object[0]), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();     // Catch: Throwable -> L19
        goto L26
    }

    private void d() {
        c(a(12, "定位服务没有开启，请在设置中打开定位服务开关#1206"));
    }

    private void d(AMapLocation r2) {
        if (this.j == null) goto L6;
        Object[] r0 = new Object[1];
        ex.a();
        Message r1 = Message.obtain();
        r1.obj = r2;
        r1.what = 101;
        this.j.sendMessage(r1);
        return;
    }

    private void e() {
        c(a(20, "模糊权限下不支持连续定位#2006"));
    }

    private void e(AMapLocation r9) {
    L11:
        th = move-exception;
        r9.setOffset(false);
        r9.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        Object[] r10 = new Object[1];
        String r0 = "CoarseLocation | offset error: " + th.getMessage();
        ex.a();
        return;
    L4:
        if (ev.a(r9.getLatitude(), r9.getLongitude()) == true) goto L6;
    L9:
        r9.setOffset(false);     // Catch: Throwable -> L11
        r9.setCoordType(AMapLocation.COORD_TYPE_WGS84);     // Catch: Throwable -> L11
        return;
    L6:
        if (this.o.isOffset() == false) goto L9;
        DPoint r2 = ey.a(this.k, new DPoint(r9.getLatitude(), r9.getLongitude()));     // Catch: Throwable -> L11
        r9.setLatitude(r2.getLatitude());     // Catch: Throwable -> L11
        r9.setLongitude(r2.getLongitude());     // Catch: Throwable -> L11
        r9.setOffset(this.o.isOffset());     // Catch: Throwable -> L11
        r9.setCoordType(AMapLocation.COORD_TYPE_GCJ02);     // Catch: Throwable -> L11
    }

    private AMapLocation f(AMapLocation r4) {
        if (fd.a(r4) == true) goto L6;
        return r4;
    L6:
        if (this.e >= 3) goto L9;
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

    private void f() {
        if (this.n != null) goto L50;
        return;
    L50:
        this.v = true;     // Catch: Throwable -> L41 SecurityException -> L44
        Looper r4 = Looper.myLooper();     // Catch: Throwable -> L41 SecurityException -> L44
        if (r4 != null) goto L9;
        r4 = this.k.getMainLooper();     // Catch: Throwable -> L41 SecurityException -> L44
    L9:
        this.c = fd.b();     // Catch: Throwable -> L41 SecurityException -> L44
        if (b(this.n) == false) goto L16;
        if (this.x != null) goto L14;
        this.x = new a(this);     // Catch: Throwable -> L41 SecurityException -> L44
    L14:
        this.n.requestLocationUpdates("network", this.o.getInterval(), this.o.getDeviceModeDistanceFilter(), this.x, r4);     // Catch: Throwable -> L41 SecurityException -> L44
    L16:
        if (a(this.n) == false) goto L31;
    L24:
        th = move-exception;
        Object[] r6 = new Object[1];     // Catch: Throwable -> L41 SecurityException -> L44
        String r0 = "CoarseLocation | sendExtraCommand error: " + th.getMessage();     // Catch: Throwable -> L41 SecurityException -> L44
        ex.a();     // Catch: Throwable -> L41 SecurityException -> L44
    L27:
        if (this.x != null) goto L29;
        this.x = new a(this);     // Catch: Throwable -> L41 SecurityException -> L44
    L29:
        this.n.requestLocationUpdates("gps", this.o.getInterval(), this.o.getDeviceModeDistanceFilter(), this.x, r4);     // Catch: Throwable -> L41 SecurityException -> L44
        Object[] r5 = new Object[1];     // Catch: Throwable -> L41 SecurityException -> L44
        ex.a();     // Catch: Throwable -> L41 SecurityException -> L44
        goto L31
    L18:
        if ((fd.a() - q) >= 259200000) goto L20;
    L47:
        goto L27
    L20:
        if (fd.c(this.k, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L22;
        this.n.sendExtraCommand("gps", "force_xtra_injection", null);     // Catch: Throwable -> L24
        q = fd.a();     // Catch: Throwable -> L24
        SharedPreferences.Editor r7 = fc.a(this.k, "pref");     // Catch: Throwable -> L24
        fc.a(r7, "lagt", q);     // Catch: Throwable -> L24
        fc.a(r7);     // Catch: Throwable -> L24
        Object[] r8 = new Object[1];     // Catch: Throwable -> L24
        ex.a();     // Catch: Throwable -> L24
        goto L47
    L22:
        ev.a(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");     // Catch: Throwable -> L24
    L31:
        if (s == false) goto L33;
    L34:
        a(100, "系统返回定位结果超时#2002", this.o.getHttpTimeOut());     // Catch: Throwable -> L41 SecurityException -> L44
    L36:
        if (s == false) goto L38;
        return;
    L38:
        if (u == true) goto L53;
        Object[] r9 = new Object[1];     // Catch: Throwable -> L41 SecurityException -> L44
        ex.a();     // Catch: Throwable -> L41 SecurityException -> L44
        a(100, "系统定位当前不可用#2003", 0);     // Catch: Throwable -> L41 SecurityException -> L44
        return;
    L53:
        return;
    L33:
        if (u == false) goto L36;
    L44:
        e = move-exception;
        Object[] r3 = new Object[1];
        ex.a();
        this.v = false;
        fb.a(null, 2121);
        a(101, e.getMessage() + "#2004", 0);
        return;
    L41:
        th = move-exception;
        Object[] r1 = new Object[1];
        String r2 = "CoarseLocation | requestLocationUpdates error: " + th.getMessage();
        ex.a();
        ev.a(th, "CoarseLocation", "requestLocationUpdates part2");
    }

    private void g() {
        Object[] r0 = new Object[1];     // Catch: Throwable -> L5
        ex.a();     // Catch: Throwable -> L5
        this.i = 0;     // Catch: Throwable -> L5
        return;
    }

    private static void g(AMapLocation r7) {
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

    public final void a() {
        Object[] r1 = new Object[1];
        ex.a();
        LocationManager r2 = this.n;
        if (r2 != null) goto L17;
        return;
    L17:
        LocationListener r3 = this.x;     // Catch: Throwable -> L9
        if (r3 == null) goto L19;
        r2.removeUpdates(r3);     // Catch: Throwable -> L9
        ((a) ZeusTransformUtils.preCheckCast(this.x, a.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L9
        this.x = null;     // Catch: Throwable -> L9
        Object[] r4 = new Object[1];     // Catch: Throwable -> L9
        ex.a();     // Catch: Throwable -> L9
    L19:
        Handler r0 = this.j;     // Catch: Throwable -> L16
        if (r0 == null) goto L14;
        r0.removeMessages(100);     // Catch: Throwable -> L16
    L14:
        this.i = 0;
        this.c = 0;
        this.l = 0;
        this.e = 0;
        this.m = 0;
        this.f.a();
        return;
    L9:
        th = move-exception;
        Object[] r5 = new Object[1];
        String r6 = "CoarseLocation | removeUpdates error " + th.getMessage();
        ex.a();
        goto L19
    }

    public final void a(Bundle r3) {
        if (r3 == null) goto L20;
        r3.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.g = r3.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.h = r3.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r4 = (AMapLocation) ZeusTransformUtils.preCheckCast(r3.getParcelable("loc"), AMapLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r4.getAdCode()) == true) goto L21;
        Object r2 = this.p;     // Catch: Throwable -> L13
        monitor-enter(r2);     // Catch: Throwable -> L13
        f5529a = r4;     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        ev.a(th, "CoarseLocation", "setLastGeoLocation");
        return;
    }

    public final void a(AMapLocationClientOption r5) {
        this.o = r5;
        if (r5 != null) goto L5;
        this.o = new AMapLocationClientOption();
    L5:
        Object[] r6 = new Object[2];
        String r0 = "option: " + this.o.toString();
        ex.a();
        if (this.o.isOnceLocation() == true) goto L10;
        e();
        return;
    L10:
        if (c() == true) goto L17;
        d();
        return;
    L17:
        q = fc.a(this.k, "pref", "lagt", q);     // Catch: Throwable -> L16
    L14:
        f();
    }

    public final int b() {
        LocationManager r0 = this.n;
        if (r0 != null) goto L6;
        return 1;
    L6:
        if (a(r0) == true) goto L9;
        return 1;
    L9:
        if (Build.VERSION.SDK_INT < 19) goto L11;
        int r1 = Settings.Secure.getInt(this.k.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0);
        if (r1 != 0) goto L16;
        return 2;
    L16:
        if (r1 != 2) goto L20;
        return 3;
    L20:
        if (this.v == true) goto L23;
        return 4;
    L23:
        return 0;
    L11:
        if (this.n.isProviderEnabled("gps") == true) goto L20;
        return 2;
    }

    public final void b(AMapLocationClientOption r2) {
        if (r2 != null) goto L4;
        r2 = new AMapLocationClientOption();
    L4:
        this.o = r2;
        Object[] r3 = new Object[2];
        String r0 = "option: " + this.o.toString();
        ex.a();
        this.j.removeMessages(100);
        if (this.w == this.o.getGeoLanguage()) goto L15;
        Object r4 = this.p;
        monitor-enter(r4);
        f5529a = null;     // Catch: Throwable -> L12
        monitor-exit(r4);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        this.w = this.o.getGeoLanguage();
    }
}
