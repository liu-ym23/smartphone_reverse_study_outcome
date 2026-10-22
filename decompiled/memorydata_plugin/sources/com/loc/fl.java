package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class fl {
    static AMapLocation j = null;
    static long k = 0;
    static Object l = null;
    static long q = 0;
    static boolean t = false;
    static boolean u = false;
    public static volatile AMapLocation y;
    private String A;
    private int B;
    private boolean C;
    private long D;
    private int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f5550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    LocationManager f5551b;
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
        private fl f5552a;

        a(fl r1) {
            this.f5552a = r1;
        }

        final void a() {
            this.f5552a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location r4) {
            Object[] r0 = new Object[2];     // Catch: Throwable -> L7
            String r1 = "tid=" + Thread.currentThread().getId();     // Catch: Throwable -> L7
            ex.a();     // Catch: Throwable -> L7
            fl r3 = this.f5552a;     // Catch: Throwable -> L7
            if (r3 == null) goto L10;
            fl.a(r3, r4);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String r1) {
            fl r0 = this.f5552a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            fl.a(r0, r1);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String r1) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
            fl r0 = this.f5552a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            fl.a(r0, r2);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    static {
        l = new Object();
    }

    public fl(Context r7, Handler r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.A = null;
        this.B = 0;
        this.C = false;
        this.D = 0;
        this.d = 0;
        this.e = false;
        this.E = 0;
        this.f = null;
        this.g = 240;
        this.h = 80;
        this.i = null;
        this.m = 0;
        this.n = 0.0f;
        this.o = new Object();
        this.p = new Object();
        this.r = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.s = true;
        this.v = 0;
        this.w = 0;
        this.x = null;
        Context r10 = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.z = r10;
        this.f5550a = r8;
        this.f5551b = (LocationManager) ZeusTransformUtils.preCheckCast(r10.getSystemService("location"), LocationManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
    L7:
        this.f = new dp();
        return;
    L5:
        th = move-exception;
        ev.a(th, "NetworkLocation", "<init>");
        goto L7
    }

    private void a(int r3) {
        if (r3 == 0) goto L7;
        return;
    L7:
        this.d = 0;     // Catch: Throwable -> L6
        return;
    }

    private void a(int r4, int r5, String r6, long r7) {
        if (this.f5550a != null) goto L5;
        return;
    L5:
        if (this.c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Battery_Saving) goto L12;
        Message r0 = Message.obtain();     // Catch: Throwable -> L8
        AMapLocation r1 = new AMapLocation("");     // Catch: Throwable -> L8
        r1.setProvider("network");     // Catch: Throwable -> L8
        r1.setErrorCode(r5);     // Catch: Throwable -> L8
        r1.setLocationDetail(r6);     // Catch: Throwable -> L8
        r1.setLocationType(12);     // Catch: Throwable -> L8
        r0.obj = r1;     // Catch: Throwable -> L8
        r0.what = r4;     // Catch: Throwable -> L8
        this.f5550a.sendMessageDelayed(r0, r7);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }

    private void a(Location r9) {
        Handler r0 = this.f5550a;
        if (r0 == null) goto L5;
        r0.removeMessages(17);
    L5:
        if (r9 != null) goto L44;
        return;
    L44:
        AMapLocation r1 = new AMapLocation(r9);     // Catch: Throwable -> L41
        if (fd.a(r1) == true) goto L10;
        return;
    L10:
        r1.setProvider("network");     // Catch: Throwable -> L41
        r1.setLocationType(12);     // Catch: Throwable -> L41
        if (this.e == false) goto L13;
    L15:
        e(r1);     // Catch: Throwable -> L41
        AMapLocation r2 = f(r1);     // Catch: Throwable -> L41
        a(r2);     // Catch: Throwable -> L41
        b(r2);     // Catch: Throwable -> L41
        Object r3 = this.o;     // Catch: Throwable -> L41
        monitor-enter(r3);     // Catch: Throwable -> L41
        a(r2, y);     // Catch: Throwable -> L38
        monitor-exit(r3);     // Catch: Throwable -> L38
    L34:
        th = move-exception;
        ev.a(th, "NetworkLocation", "onLocationChangedLast");     // Catch: Throwable -> L41
    L36:
        c(r2);     // Catch: Throwable -> L41
        return;
    L20:
        if (fd.a(r2) == false) goto L36;
        if (this.i == null) goto L24;
        this.m = r9.getTime() - this.i.getTime();     // Catch: Throwable -> L34
        this.n = fd.a(this.i, r2);     // Catch: Throwable -> L34
    L24:
        Object r10 = this.p;     // Catch: Throwable -> L34
        monitor-enter(r10);     // Catch: Throwable -> L34
        this.i = r2.clone();     // Catch: Throwable -> L31
        monitor-exit(r10);     // Catch: Throwable -> L31
    L29:
        this.A = null;     // Catch: Throwable -> L34
        this.C = false;     // Catch: Throwable -> L34
        this.B = 0;     // Catch: Throwable -> L34
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L13:
        if (fd.a(r1) == false) goto L15;
        fb.a(this.z, fd.b() - this.D, ev.a(r1.getLatitude(), r1.getLongitude()));     // Catch: Throwable -> L41
        this.e = true;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        ev.a(th, "NetworkLocation", "onLocationChanged");
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
        this.E++;
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

    static /* synthetic */ void a(fl r0, int r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(fl r0, Location r1) {
        r0.a(r1);
    }

    static /* synthetic */ void a(fl r0, String r1) {
        r0.a(r1);
    }

    private void a(String r3) {
        if ("network".equalsIgnoreCase(r3) == false) goto L9;
        this.d = 0;     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    private static boolean a(LocationManager r2) {
    L15:
        th = move-exception;
        Object[] r0 = new Object[1];
        String r1 = "NetworkLocation | hasProvider error: " + th.getMessage();
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
        u = r3.contains("network");     // Catch: Throwable -> L15
        goto L13
    L6:
        return u;
    }

    private void b(AMapLocation r7) {
        if (fd.a(r7) == true) goto L6;
        return;
    L6:
        if (this.f5550a == null) goto L25;
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
        r2.what = 14;
        Object r3 = this.o;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (y != null) goto L18;
        Handler r6 = this.f5550a;     // Catch: Throwable -> L22
    L16:
        r6.sendMessage(r2);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L18:
        if (fd.a(r7, y) <= this.h) goto L20;
        r6 = this.f5550a;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r0 - this.v) > (this.c.getInterval() - 8000)) goto L11;
        return;
    }

    private boolean b(String r5) {
        ArrayList<String> r1 = fd.b(r5);     // Catch: Throwable -> L10
        ArrayList<String> r2 = fd.b(this.A);     // Catch: Throwable -> L10
        if (r1.size() >= 8) goto L6;
        return false;
    L6:
        if (r2.size() < 8) goto L14;
        return fd.a(this.A, r5);
    L14:
        return false;
    L15:
        return false;
    }

    private void c(AMapLocation r7) {
        if (r7.getErrorCode() != 15) goto L8;
        if (AMapLocationClientOption.AMapLocationMode.Battery_Saving.equals(this.c.getLocationMode()) == true) goto L8;
        return;
    L8:
        if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving) == false) goto L14;
        if (this.c.getDeviceModeDistanceFilter() <= 0.0f) goto L14;
        d(r7);
        return;
    L14:
        if ((fd.b() - this.v) < (this.c.getInterval() - 200)) goto L17;
        this.v = fd.b();
        d(r7);
        return;
    }

    private void d() {
        if (this.f5551b != null) goto L43;
        return;
    L43:
        e();     // Catch: Throwable -> L34 SecurityException -> L37
        this.s = true;     // Catch: Throwable -> L34 SecurityException -> L37
        Looper r0 = Looper.myLooper();     // Catch: Throwable -> L34 SecurityException -> L37
        if (r0 != null) goto L9;
        r0 = this.z.getMainLooper();     // Catch: Throwable -> L34 SecurityException -> L37
    L9:
        Looper r16 = r0;
        this.D = fd.b();     // Catch: Throwable -> L34 SecurityException -> L37
        if (a(this.f5551b) == true) goto L41;
        Object[] r1 = new Object[1];     // Catch: Throwable -> L34 SecurityException -> L37
        ex.a();     // Catch: Throwable -> L34 SecurityException -> L37
        a(17, 13, "no network provider#1402", 0);     // Catch: Throwable -> L34 SecurityException -> L37
        return;
    L41:
    L18:
        th = move-exception;
        Object[] r2 = new Object[1];     // Catch: Throwable -> L34 SecurityException -> L37
        String r3 = "GpsLocation | sendExtraCommand error: " + th.getMessage();     // Catch: Throwable -> L34 SecurityException -> L37
        ex.a();     // Catch: Throwable -> L34 SecurityException -> L37
    L21:
        if (this.x != null) goto L24;
        this.x = new a(this);     // Catch: Throwable -> L34 SecurityException -> L37
    L24:
        if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving) == true) goto L26;
    L29:
        LocationManager r10 = this.f5551b;     // Catch: Throwable -> L34 SecurityException -> L37
        String r11 = "network";
        long r12 = 900;
        float r14 = 0.0f;
        LocationListener r15 = this.x;     // Catch: Throwable -> L34 SecurityException -> L37
    L28:
        r10.requestLocationUpdates(r11, r12, r14, r15, r16);     // Catch: Throwable -> L34 SecurityException -> L37
        a(17, 13, "no enough satellites#1401", this.c.getHttpTimeOut());     // Catch: Throwable -> L34 SecurityException -> L37
        return;
    L26:
        if (this.c.getDeviceModeDistanceFilter() <= 0.0f) goto L29;
        r10 = this.f5551b;     // Catch: Throwable -> L34 SecurityException -> L37
        r11 = "network";
        r12 = this.c.getInterval();     // Catch: Throwable -> L34 SecurityException -> L37
        r14 = this.c.getDeviceModeDistanceFilter();     // Catch: Throwable -> L34 SecurityException -> L37
        r15 = this.x;     // Catch: Throwable -> L34 SecurityException -> L37
        goto L28
    L12:
        if ((fd.a() - q) >= 259200000) goto L14;
    L40:
        goto L21
    L14:
        if (fd.c(this.z, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L16;
        this.f5551b.sendExtraCommand("gps", "force_xtra_injection", null);     // Catch: Throwable -> L18
        q = fd.a();     // Catch: Throwable -> L18
        SharedPreferences.Editor r4 = fc.a(this.z, "pref");     // Catch: Throwable -> L18
        fc.a(r4, "lagt", q);     // Catch: Throwable -> L18
        fc.a(r4);     // Catch: Throwable -> L18
        Object[] r5 = new Object[1];     // Catch: Throwable -> L18
        ex.a();     // Catch: Throwable -> L18
        goto L40
    L16:
        ev.a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");     // Catch: Throwable -> L18
    L37:
        e = move-exception;
        Object[] r6 = new Object[1];
        ex.a();
        this.s = false;
        fb.a(null, 2121);
        a(15, 12, e.getMessage() + "#1201", 0);
        return;
    L34:
        th = move-exception;
        Object[] r7 = new Object[1];
        String r8 = "NetworkLocation | requestLocationUpdates error: " + th.getMessage();
        ex.a();
        ev.a(th, "NetworkLocation", "requestLocationUpdates part2");
    }

    private void d(AMapLocation r2) {
        if (this.f5550a == null) goto L6;
        Message r0 = Message.obtain();
        r0.obj = r2;
        r0.what = 15;
        this.f5550a.sendMessage(r0);
        return;
    }

    private void e() {
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

    private AMapLocation f(AMapLocation r4) {
        if (fd.a(r4) == true) goto L6;
        return r4;
    L6:
        if (this.E >= 3) goto L9;
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
        float r2 = this.i.getSpeed();
        if (r2 != 0.0f) goto L23;
        long r7 = this.m;
        if (r7 <= 0) goto L23;
        if (r7 >= 8) goto L23;
        float r4 = this.n;
        if (r4 <= 0.0f) goto L23;
        r2 = r4 / r7;
    L23:
        if (r17 != null) goto L25;
    L42:
        long r10 = 30000;
    L43:
        long r12 = fd.b() - this.d;
        if (r12 <= 30000) goto L47;
        return r17;
    L47:
        if (r12 < r10) goto L64;
        if (this.C == true) goto L51;
    L54:
        this.A = null;
        this.B = 0;
        Object r3 = this.p;
        monitor-enter(r3);
        this.i = null;     // Catch: Throwable -> L60
        monitor-exit(r3);     // Catch: Throwable -> L60
        this.m = 0;
        this.n = 0.0f;
        return r17;
    L60:
        th = move-exception;
        throw th;
    L51:
        if (b(r18) == false) goto L54;
        AMapLocation r0 = this.i.clone();
        r0.setTrustedLevel(3);
        return r0;
    L64:
        if (this.A == null) goto L66;
    L68:
        AMapLocation r1 = this.i.clone();
        r1.setTrustedLevel(2);
        return r1;
    L66:
        if (this.B < 2) goto L68;
        this.A = r18;
        goto L68
    L25:
        if (fd.a(r17) == false) goto L42;
        if (r17.getAccuracy() >= 200.0f) goto L37;
        int r11 = this.B + 1;
        this.B = r11;
        if (this.A != null) goto L33;
        if (r11 < 2) goto L33;
        this.C = true;
    L33:
        if (r2 <= 5.0f) goto L35;
        r10 = 10000;
        goto L43
    L35:
        r10 = SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME;
        goto L43
    L37:
        if (TextUtils.isEmpty(this.A) == true) goto L40;
        this.C = false;
        this.B = 0;
    L40:
        if (r2 <= 5.0f) goto L42;
        r10 = 20000;
        goto L43
    }

    public final void a() {
        LocationManager r0 = this.f5551b;
        if (r0 != null) goto L18;
        return;
    L18:
        LocationListener r2 = this.x;     // Catch: Throwable -> L14
        if (r2 == null) goto L16;
        r0.removeUpdates(r2);     // Catch: Throwable -> L14
        ((a) ZeusTransformUtils.preCheckCast(this.x, a.class, "com.obric.memorydata.plugin")).a();     // Catch: Throwable -> L14
        this.x = null;     // Catch: Throwable -> L14
    L16:
        Handler r1 = this.f5550a;     // Catch: Throwable -> L15
        if (r1 == null) goto L12;
        r1.removeMessages(17);     // Catch: Throwable -> L15
    L12:
        this.D = 0;
        this.v = 0;
        this.d = 0;
        this.E = 0;
        this.w = 0;
        this.f.a();
        this.i = null;
        this.m = 0;
        this.n = 0.0f;
        this.A = null;
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
        ev.a(th, "NetworkLocation", "setLastGeoLocation");
        return;
    }

    public final void a(AMapLocationClientOption r5) {
        this.c = r5;
        if (r5 != null) goto L9;
        this.c = new AMapLocationClientOption();
    L9:
        q = fc.a(this.z, "pref", "lagt", q);     // Catch: Throwable -> L8
    L6:
        d();
    }

    public final boolean b() {
        AMapLocationClientOption r0 = this.c;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.isOnceLocation() == true) goto L11;
        if ((fd.b() - this.d) <= 300000) goto L11;
        return true;
    }

    public final boolean c() {
        if ((fd.b() - this.d) <= 2800) goto L6;
        return false;
    L6:
        return true;
    }
}
