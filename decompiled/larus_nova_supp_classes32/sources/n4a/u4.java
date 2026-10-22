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
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u4 {
    public static boolean A;
    public static volatile AMapLocation B;
    public static AMapLocation v;
    public static long w;
    public static final Object x = null;
    public static long y;
    public static boolean z;
    public final Handler a;
    public final Context b;
    public final LocationManager c;
    public AMapLocationClientOption d;
    public String e;
    public int f;
    public boolean g;
    public long h;
    public long i;
    public boolean j;
    public int k;
    public final f3 l;
    public int m;
    public int n;
    public AMapLocation o;
    public long p;
    public float q;
    public final Object r;
    public final Object s;
    public long t;
    public a u;

    public static class a implements LocationListener {
        public u4 a;

        public a(u4 r1) {
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
            f06.d r5 = r7.preInvoke(100038, "com/loc/k$a", "onLocationChanged", this, r2, "void", r12);     // Catch: Exception -> L28
            if (r5.a == true) goto L17;
            r1.add(r7);     // Catch: Exception -> L28
        L17:
            if (r5.a == false) goto L29;
            return;
        L29:
            ThreadMethodProxy.currentThread().getId();     // Catch: Throwable -> L25
            u4 r6 = this.a;     // Catch: Throwable -> L27
            if (r6 == null) goto L38;
            u4.g(r6, r20);     // Catch: Throwable -> L27
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
            u4 r0 = this.a;     // Catch: Throwable -> L8
            if (r0 == null) goto L11;
            AMapLocation r1 = u4.v;     // Catch: Throwable -> L8
            r0.getClass();     // Catch: Throwable -> L8
            if (CloudControlInf.NETWORK.equalsIgnoreCase(r4) == false) goto L12;
            r0.i = 0;     // Catch: Throwable -> L8
            return;
        L12:
            return;
        L11:
            return;
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String r1, int r2, Bundle r3) {
            u4 r4 = this.a;     // Catch: Throwable -> L9
            if (r4 == null) goto L12;
            AMapLocation r5 = u4.v;     // Catch: Throwable -> L9
            r4.getClass();     // Catch: Throwable -> L9
            if (r2 == 0) goto L7;
            return;
        L7:
            r4.i = 0;     // Catch: Throwable -> L9
            return;
        L12:
            return;
        }
    }

    static {
        x = new Object();
        y = 0;
        z = false;
        A = false;
        B = null;
    }

    public u4(Context r5, x1.e r6) {
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = 0;
        this.l = null;
        this.m = 240;
        this.n = 80;
        this.o = null;
        this.p = 0;
        this.q = 0.0f;
        this.r = new Object();
        this.s = new Object();
        AMapLocationClientOption.GeoLanguage r1 = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.t = 0;
        this.u = null;
        this.b = r5;
        this.a = r6;
        this.c = (LocationManager) r5.getSystemService("location");     // Catch: Throwable -> L5
    L7:
        this.l = new f3();
        return;
    L5:
        th = move-exception;
        c4.g(th, "NetworkLocation", "<init>");
        goto L7
    }

    public static boolean h(LocationManager r2) {
    L14:
        th = move-exception;
        new StringBuilder("NetworkLocation | hasProvider error: ").append(th.getMessage());
        return A;
    L3:
        if (z == true) goto L5;
        List<String> r3 = r2.getAllProviders();     // Catch: Throwable -> L14
        if (r3 != null) goto L9;
    L11:
        A = false;     // Catch: Throwable -> L14
    L12:
        z = true;     // Catch: Throwable -> L14
        return A;
    L9:
        if (r3.size() <= 0) goto L11;
        A = r3.contains(CloudControlInf.NETWORK);     // Catch: Throwable -> L14
        goto L12
    L5:
        return A;
    }

    public final void c(int r4, int r5, String r6, long r7) {
        if (this.a != null) goto L5;
        return;
    L5:
        if (this.d.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Battery_Saving) goto L12;
        Message r0 = Message.obtain();     // Catch: Throwable -> L8
        AMapLocation r1 = new AMapLocation(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L8
        r1.setProvider(CloudControlInf.NETWORK);     // Catch: Throwable -> L8
        r1.setErrorCode(r5);     // Catch: Throwable -> L8
        r1.setLocationDetail(r6);     // Catch: Throwable -> L8
        r1.setLocationType(12);     // Catch: Throwable -> L8
        r0.obj = r1;     // Catch: Throwable -> L8
        r0.what = r4;     // Catch: Throwable -> L8
        this.a.sendMessageDelayed(r0, r7);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    }

    public final void d(Bundle r3) {
        if (r3 == null) goto L20;
        r3.setClassLoader(AMapLocation.class.getClassLoader());     // Catch: Throwable -> L13
        this.m = r3.getInt("I_MAX_GEO_DIS");     // Catch: Throwable -> L13
        this.n = r3.getInt("I_MIN_GEO_DIS");     // Catch: Throwable -> L13
        AMapLocation r4 = r3.getParcelable("loc");     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r4.getAdCode()) == true) goto L21;
        Object r0 = this.r;     // Catch: Throwable -> L13
        monitor-enter(r0);     // Catch: Throwable -> L13
        B = r4;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L21:
        return;
    L13:
        th = move-exception;
        c4.g(th, "NetworkLocation", "setLastGeoLocation");
        return;
    }

    public final void m(AMapLocation r9) {
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

    public final void b() {
        LocationManager r0 = this.c;
        if (r0 != null) goto L20;
        return;
    L20:
        a r2 = this.u;     // Catch: Throwable -> L18
        if (r2 == null) goto L22;
        if (fna.g.d() == true) goto L11;
        r0.removeUpdates(r2);     // Catch: Throwable -> L18
    L12:
        this.u.a = null;     // Catch: Throwable -> L18
        this.u = null;     // Catch: Throwable -> L18
        goto L22
    L11:
        r0.removeUpdates(r2);     // Catch: Throwable -> L18
        nna.a.a(r2.hashCode());     // Catch: Throwable -> L18
    L22:
        Handler r1 = this.a;     // Catch: Throwable -> L19
        if (r1 == null) goto L16;
        r1.removeMessages(17);     // Catch: Throwable -> L19
    L16:
        this.h = 0;
        this.t = 0;
        this.i = 0;
        this.k = 0;
        this.l.b();
        this.o = null;
        this.p = 0;
        this.q = 0.0f;
        this.e = null;
    }

    public final void l() {
        if ((SystemClock.elapsedRealtime() - w) <= 5000) goto L5;
        return;
    L5:
        if (j4.l(v) == true) goto L7;
        return;
    L7:
        if (this.d.isMockEnable() == false) goto L9;
    L11:
        this.i = SystemClock.elapsedRealtime();
        j(v);
        return;
    L9:
        if (v.isMock() == false) goto L11;
    }

    public final void e(AMapLocation r4) {
        if (j4.l(r4) == true) goto L5;
        return;
    L5:
        this.i = SystemClock.elapsedRealtime();
        Object r0 = x;
        monitor-enter(r0);
        w = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        v = r4.clone();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        this.k++;
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void f(AMapLocationClientOption r11) {
        this.d = r11;
        if (r11 != null) goto L50;
        this.d = new AMapLocationClientOption();
    L50:
        y = i4.b(this.b, "pref", "lagt", y);     // Catch: Throwable -> L7
    L9:
        if (this.c != null) goto L52;
        return;
    L52:
        l();     // Catch: Throwable -> L42 SecurityException -> L44
        Looper r2 = Looper.myLooper();     // Catch: Throwable -> L42 SecurityException -> L44
        if (r2 != null) goto L15;
        r2 = this.b.getMainLooper();     // Catch: Throwable -> L42 SecurityException -> L44
    L15:
        Looper r6 = r2;
        this.h = SystemClock.elapsedRealtime();     // Catch: Throwable -> L42 SecurityException -> L44
        if (h(this.c) == true) goto L48;
        c(17, 13, "no network provider#1402", 0);     // Catch: Throwable -> L42 SecurityException -> L44
        return;
    L48:
    L24:
        th = move-exception;
        th.getMessage();     // Catch: Throwable -> L42 SecurityException -> L44
    L27:
        if (this.u != null) goto L30;
        this.u = new a(this);     // Catch: Throwable -> L42 SecurityException -> L44
    L30:
        if (this.d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving) == true) goto L32;
    L34:
        LocationManager r1 = this.c;     // Catch: Throwable -> L42 SecurityException -> L44
        a r0 = this.u;     // Catch: Throwable -> L42 SecurityException -> L44
        long r3 = 900;
        float r4 = 0.0f;
    L36:
        if (fna.g.d() == true) goto L38;
        k(r1, r3, r4, r0, r6);     // Catch: Throwable -> L42 SecurityException -> L44
    L39:
        c(17, 13, "no enough satellites#1401", this.d.getHttpTimeOut());     // Catch: Throwable -> L42 SecurityException -> L44
        return;
    L38:
        k(r1, r3, r4, r0, r6);     // Catch: Throwable -> L42 SecurityException -> L44
        nna.a.c(r0.hashCode());     // Catch: Throwable -> L42 SecurityException -> L44
        goto L39
    L32:
        if (this.d.getDeviceModeDistanceFilter() <= 0.0f) goto L34;
        LocationManager r5 = this.c;     // Catch: Throwable -> L42 SecurityException -> L44
        long r7 = this.d.getInterval();     // Catch: Throwable -> L42 SecurityException -> L44
        float r8 = this.d.getDeviceModeDistanceFilter();     // Catch: Throwable -> L42 SecurityException -> L44
        r1 = r5;
        r0 = this.u;     // Catch: Throwable -> L42 SecurityException -> L44
        r4 = r8;
        r3 = r7;
        goto L36
    L18:
        if ((System.currentTimeMillis() - y) >= 259200000) goto L20;
    L47:
        goto L27
    L20:
        if (j4.A(this.b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==") == false) goto L22;
        this.c.sendExtraCommand("gps", "force_xtra_injection", null);     // Catch: Throwable -> L24
        y = System.currentTimeMillis();     // Catch: Throwable -> L24
        SharedPreferences.Editor r9 = i4.c(this.b, "pref");     // Catch: Throwable -> L24
        i4.g(r9, "lagt", y);     // Catch: Throwable -> L24
        i4.e(r9);     // Catch: Throwable -> L24
        goto L47
    L22:
        c4.g(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");     // Catch: Throwable -> L24
    L44:
        e = move-exception;
        h4.k(null, 2121);
        c(15, 12, e.getMessage() + "#1201", 0);
        return;
    L42:
        th = move-exception;
        th.getMessage();
        c4.g(th, "NetworkLocation", "requestLocationUpdates part2");
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
        r2.what = 14;
        Object r3 = this.r;
        monitor-enter(r3);
    L22:
        th = move-exception;
        throw th;
    L14:
        if (B != null) goto L18;
        Handler r9 = this.a;     // Catch: Throwable -> L22
    L16:
        r9.sendMessage(r2);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r3);     // Catch: Throwable -> L22
        return;
    L18:
        if (j4.a(r8, B) <= this.n) goto L20;
        r9 = this.a;     // Catch: Throwable -> L22
        goto L16
    L10:
        if ((r0 - this.t) > (this.d.getInterval() - 8000)) goto L11;
        return;
    }

    public final void j(AMapLocation r9) {
        if (r9.getErrorCode() != 15) goto L8;
        if (AMapLocationClientOption.AMapLocationMode.Battery_Saving.equals(this.d.getLocationMode()) == true) goto L8;
        return;
    L8:
        if (this.d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving) == false) goto L16;
        if (this.d.getDeviceModeDistanceFilter() <= 0.0f) goto L16;
        if (this.a == null) goto L21;
        Message r0 = Message.obtain();
        r0.obj = r9;
        r0.what = 15;
        this.a.sendMessage(r0);
        return;
    L21:
        return;
    L16:
        if ((SystemClock.elapsedRealtime() - this.t) < (this.d.getInterval() - 200)) goto L22;
        this.t = SystemClock.elapsedRealtime();
        if (this.a == null) goto L23;
        Message r1 = Message.obtain();
        r1.obj = r9;
        r1.what = 15;
        this.a.sendMessage(r1);
        return;
    L23:
        return;
    }

    public static void g(u4 r8, Location r9) {
        Handler r0 = r8.a;
        if (r0 == null) goto L5;
        r0.removeMessages(17);
    L5:
        if (r9 == null) goto L85;
        AMapLocation r1 = new AMapLocation(r9);     // Catch: Throwable -> L73
        if (j4.l(r1) == false) goto L84;
        r1.setProvider(CloudControlInf.NETWORK);     // Catch: Throwable -> L73
        r1.setLocationType(12);     // Catch: Throwable -> L73
        if (r8.j == false) goto L13;
    L24:
        r8.m(r1);     // Catch: Throwable -> L73
        if (j4.l(r1) == true) goto L28;
    L41:
        r8.e(r1);     // Catch: Throwable -> L73
        r8.i(r1);     // Catch: Throwable -> L73
        Object r2 = r8.r;     // Catch: Throwable -> L73
        monitor-enter(r2);     // Catch: Throwable -> L73
        AMapLocation r3 = B;     // Catch: Throwable -> L70
        if (r3 != null) goto L46;
    L50:
        monitor-exit(r2);     // Catch: Throwable -> L70
    L83:
    L66:
        th = move-exception;
        c4.g(th, "NetworkLocation", "onLocationChangedLast");     // Catch: Throwable -> L73
    L68:
        r8.j(r1);     // Catch: Throwable -> L73
        return;
    L52:
        if (j4.l(r1) == false) goto L68;
        if (r8.o == null) goto L56;
        r8.p = r9.getTime() - r8.o.getTime();     // Catch: Throwable -> L66
        r8.q = j4.a(r8.o, r1);     // Catch: Throwable -> L66
    L56:
        Object r10 = r8.s;     // Catch: Throwable -> L66
        monitor-enter(r10);     // Catch: Throwable -> L66
        r8.o = r1.clone();     // Catch: Throwable -> L63
        monitor-exit(r10);     // Catch: Throwable -> L63
    L61:
        r8.e = null;     // Catch: Throwable -> L66
        r8.g = false;     // Catch: Throwable -> L66
        r8.f = 0;     // Catch: Throwable -> L66
    L63:
        th = move-exception;
        throw th;     // Catch: Throwable -> L66
    L46:
        if (r8.d.isNeedAddress() == false) goto L50;
        if (j4.a(r1, r3) >= r8.m) goto L50;
        c4.d(r1, r3);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;     // Catch: Throwable -> L73
    L28:
        if (r8.k < 3) goto L41;
        if (r1.getAccuracy() >= 0.0f) goto L33;
    L34:
        r1.setAccuracy(0.0f);     // Catch: Throwable -> L73
    L36:
        if (r1.getSpeed() >= 0.0f) goto L38;
    L39:
        r1.setSpeed(0.0f);     // Catch: Throwable -> L73
    L40:
        r1 = r8.l.a(r1);     // Catch: Throwable -> L73
        goto L41
    L38:
        if (r1.getSpeed() != Float.MAX_VALUE) goto L40;
    L33:
        if (r1.getAccuracy() != Float.MAX_VALUE) goto L36;
    L13:
        if (j4.l(r1) == false) goto L24;
        Context r4 = r8.b;     // Catch: Throwable -> L73
        long r5 = SystemClock.elapsedRealtime() - r8.h;     // Catch: Throwable -> L73
        boolean r6 = c4.h(r1.getLatitude(), r1.getLongitude());     // Catch: Throwable -> L73
        List<r0> r7 = h4.g;     // Catch: Throwable -> L73
        if (r4 != null) goto L78;
    L23:
        r8.j = true;     // Catch: Throwable -> L73
        goto L24
    L78:
    L21:
        th = move-exception;
        c4.g(th, "ReportUtil", "reportGPSLocUseTime");     // Catch: Throwable -> L73
        goto L23
    L17:
        if (com.loc.h.b == false) goto L23;
        h4.e(r4, r5, r6, "O015");     // Catch: Throwable -> L21
    L84:
        return;
    L73:
        th = move-exception;
        c4.g(th, "NetworkLocation", "onLocationChanged");
        return;
    }

    public final AMapLocation a(AMapLocation r17, String r18) {
        if (this.o != null) goto L6;
        return r17;
    L6:
        if (this.d.isMockEnable() == true) goto L11;
        if (this.o.isMock() == false) goto L11;
        return r17;
    L11:
        if (j4.l(this.o) == true) goto L13;
        return r17;
    L13:
        float r2 = this.o.getSpeed();
        if (r2 != 0.0f) goto L23;
        long r6 = this.p;
        if (r6 <= 0) goto L23;
        if (r6 >= 8) goto L23;
        float r8 = this.q;
        if (r8 <= 0.0f) goto L23;
        r2 = r8 / r6;
    L23:
        if (r17 != null) goto L25;
    L42:
        long r10 = 30000;
    L43:
        long r12 = SystemClock.elapsedRealtime() - this.i;
        if (r12 <= AutoEndConversationTime.AFTER_30_SECONDS) goto L47;
        return r17;
    L47:
        if (r12 < r10) goto L70;
        if (this.g == true) goto L79;
    L60:
        this.e = null;
        this.f = 0;
        Object r3 = this.s;
        monitor-enter(r3);
        this.o = null;     // Catch: Throwable -> L66
        monitor-exit(r3);     // Catch: Throwable -> L66
        this.p = 0;
        this.q = 0.0f;
        return r17;
    L66:
        th = move-exception;
        throw th;
    L79:
        ArrayList<String> r4 = j4.v(r18);     // Catch: Throwable -> L76
        ArrayList<String> r7 = j4.v(this.e);     // Catch: Throwable -> L76
        if (r4.size() < 8) goto L56;
        if (r7.size() < 8) goto L56;
        boolean r0 = j4.o(this.e, r18);     // Catch: Throwable -> L76
    L57:
        if (r0 == false) goto L60;
        AMapLocation r1 = this.o.clone();
        r1.setTrustedLevel(3);
        return r1;
    L56:
        r0 = false;
        goto L57
    L70:
        if (this.e == null) goto L72;
    L74:
        AMapLocation r5 = this.o.clone();
        r5.setTrustedLevel(2);
        return r5;
    L72:
        if (this.f < 2) goto L74;
        this.e = r18;
        goto L74
    L25:
        if (j4.l(r17) == false) goto L42;
        if (r17.getAccuracy() >= 200.0f) goto L37;
        int r11 = this.f + 1;
        this.f = r11;
        if (this.e != null) goto L33;
        if (r11 < 2) goto L33;
        this.g = true;
    L33:
        if (r2 <= 5.0f) goto L35;
        r10 = AutoEndConversationTime.AFTER_10_SECONDS;
        goto L43
    L35:
        r10 = 15000;
        goto L43
    L37:
        if (TextUtils.isEmpty(this.e) == true) goto L40;
        this.g = false;
        this.f = 0;
    L40:
        if (r2 <= 5.0f) goto L42;
        r10 = AutoEndConversationTime.AFTER_20_SECONDS;
        goto L43
    }

    public static void k(LocationManager r19, long r20, float r22, LocationListener r23, Looper r24) {
        ArrayList r0 = new ArrayList();
        Object[] r2 = {CloudControlInf.NETWORK, Long.valueOf(r20), Float.valueOf(r22), r23, r24};
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
        r19.requestLocationUpdates(CloudControlInf.NETWORK, r20, r22, r23, r24);
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
