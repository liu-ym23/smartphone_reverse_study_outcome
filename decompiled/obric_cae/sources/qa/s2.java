package qa;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.loc.em;
import com.loc.es;
import com.obric.cae.cloud.CloudServiceConstants;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public final class s2 {
    public static final String[] M = null;
    public static volatile boolean N;
    public boolean A;
    public z2 B;
    public boolean C;
    public w2 D;
    public String E;
    public Handler F;
    public e3 G;
    public final boolean H;
    public IntentFilter I;
    public LocationManager J;
    public String K;
    public u2 L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f11036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConnectivityManager f11037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g3 f11038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c3 f11039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i3 f11040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public q3 f11041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ArrayList<n2> f11042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f11043h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AMapLocationClientOption f11044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public es f11045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public r3 f11048m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f11049n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f11050o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public o3 f11051p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final StringBuilder f11052q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f11053r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f11054s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public AMapLocationClientOption.e f11055t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11056u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f11057v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f11058w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public StringBuilder f11059x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11060y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11061z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11062a = null;

        static {
            int[] r8 = new int[AMapLocationClientOption.e.values().length];
            f11062a = r8;
            AMapLocationClientOption.e r10 = AMapLocationClientOption.e.f3674a;     // Catch: NoSuchFieldError -> L8
            r8[0] = 1;     // Catch: NoSuchFieldError -> L8
        L15:
            int[] r11 = f11062a;     // Catch: NoSuchFieldError -> L9
            AMapLocationClientOption.e r12 = AMapLocationClientOption.e.f3674a;     // Catch: NoSuchFieldError -> L9
            r11[1] = 2;     // Catch: NoSuchFieldError -> L9
        L11:
            int[] r13 = f11062a;     // Catch: NoSuchFieldError -> L10
            AMapLocationClientOption.e r14 = AMapLocationClientOption.e.f3674a;     // Catch: NoSuchFieldError -> L10
            r13[2] = 3;     // Catch: NoSuchFieldError -> L10
            return;
        }
    }

    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s2 f11063a;

        public b(s2 r8) {
            this.f11063a = r8;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r10) {
            if (r8 == null) goto L67;
            if (r10 == null) goto L68;
            String r11 = r10.getAction();     // Catch: Throwable -> L48
            if (TextUtils.isEmpty(r11) == false) goto L9;
            return;
        L9:
            if (r11.equals("android.net.wifi.SCAN_RESULTS") == false) goto L34;
            g3 r12 = this.f11063a.f11038c;     // Catch: Throwable -> L48
            if (r12 != null) goto L13;
        L52:
            if (r10.getExtras() != null) goto L21;
            return;
        L21:
            if (r10.getExtras().getBoolean("resultsUpdated", true) == false) goto L57;
            g3 r13 = this.f11063a.f11038c;     // Catch: Throwable -> L51
            if (r13 == null) goto L58;
            r13.getClass();     // Catch: Throwable -> L51
            g3.E = System.currentTimeMillis();     // Catch: Throwable -> L51
            u2 r14 = r13.f10475u;     // Catch: Throwable -> L51
            if (r14 == null) goto L59;
            Handler r15 = r14.f11139c;     // Catch: Throwable -> L30
            if (r15 == null) goto L60;
            r15.post(new t2(r14));     // Catch: Throwable -> L30
            goto L62
        L61:
            return;
        L60:
            return;
        L30:
            th = move-exception;
            t3.g("cl", "upw", th);     // Catch: Throwable -> L51
            return;
        L59:
            return;
        L58:
            return;
        L57:
            return;
        L62:
            return;
        L13:
            if (r12.f10455a == null) goto L52;
            if ((SystemClock.elapsedRealtime() - g3.f10454z) <= 4900) goto L52;
            g3.f10454z = SystemClock.elapsedRealtime();     // Catch: Throwable -> L48
            goto L52
        L34:
            if (r11.equals("android.net.wifi.WIFI_STATE_CHANGED") == false) goto L43;
            g3 r16 = this.f11063a.f11038c;     // Catch: Throwable -> L48
            if (r16 != null) goto L38;
            return;
        L38:
            if (r16.f10455a == null) goto L63;
            r16.f10476v = true;     // Catch: Throwable -> L48
            return;
        L63:
            return;
        L43:
            if (r11.equals("android.net.wifi.STATE_CHANGE") == false) goto L65;
            g3 r17 = this.f11063a.f11038c;     // Catch: Throwable -> L48
            if (r17 == null) goto L66;
            r17.f10464j = null;     // Catch: Throwable -> L48
            return;
        L66:
            return;
        L65:
            return;
        L48:
            th = move-exception;
            t3.g("Aps", "onReceive", th);
            return;
        L68:
            return;
        }
    }

    static {
        M = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        N = false;
    }

    public s2(boolean r8) {
        this.f11036a = null;
        this.f11037b = null;
        this.f11038c = null;
        this.f11039d = null;
        this.f11040e = null;
        this.f11041f = null;
        this.f11042g = new ArrayList();
        this.f11043h = null;
        this.f11044i = new AMapLocationClientOption();
        this.f11045j = null;
        this.f11046k = 0;
        this.f11047l = 0;
        this.f11048m = null;
        this.f11049n = false;
        this.f11050o = null;
        this.f11051p = null;
        this.f11052q = new StringBuilder();
        this.f11053r = true;
        this.f11054s = true;
        this.f11055t = AMapLocationClientOption.e.f3674a;
        this.f11056u = true;
        this.f11057v = false;
        this.f11058w = null;
        this.f11059x = null;
        this.f11060y = false;
        this.f11061z = 12;
        this.A = true;
        this.B = null;
        this.C = false;
        this.D = null;
        this.E = null;
        this.H = false;
        this.I = null;
        this.J = null;
        this.H = r8;
    }

    public static es a(int r8, String r10) {
        es r11 = new es();
        r11.v(r8);
        r11.f3648y = r10;
        if (r8 != 15) goto L5;
        w3.a(2151, null);
    L5:
        return r11;
    }

    public final es b(em r19) {
        r();
        r19.f5203q = "conitue";
        Context r8 = this.f11036a;
        StringBuilder r10 = this.f11052q;
        if (r8 != null) goto L6;
        r19.f5204r = "#0101";
        r10.append("context is null#0101");
        return a(1, r10.toString());
    L6:
        int r11 = this.f11047l + 1;
        this.f11047l = r11;
        if (r11 != 1) goto L32;
        g3 r12 = this.f11038c;
        if (r12 == null) goto L32;
        boolean r13 = this.f11049n;
        if (s3.f11084u == false) goto L32;
        if (r12.f10463i == false) goto L32;
        if (r12.f10455a == null) goto L32;
        Context r14 = r12.f10458d;
        if (r14 == null) goto L32;
        if (r13 == false) goto L32;
        if (y3.w() <= 17) goto L32;
        ContentResolver r15 = r14.getContentResolver();
    L30:
        th = move-exception;
        t3.g("WifiManagerWrapper", "enableWifiAlwaysScan", th);
        goto L32
    L27:
        if (((Integer) l6.a.i("android.provider.Settings$Global", "getInt", new Object[]{r15, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() != 0) goto L32;
        l6.a.i("android.provider.Settings$Global", "putInt", new Object[]{r15, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});     // Catch: Throwable -> L30
    L32:
        long r16 = this.f11046k;
        if (this.A == true) goto L36;
        this.A = true;
    L44:
        boolean r17 = false;
    L45:
        if (r17 == true) goto L47;
    L55:
        z2 r18 = this.B;
        if (r18 != null) goto L58;
    L166:
        AMapLocationClientOption r20 = this.f11044i;     // Catch: Throwable -> L94
        if (r20.f3662w == false) goto L86;
    L89:
        boolean r21 = true;
    L90:
        g3 r22 = this.f11038c;     // Catch: Throwable -> L94
        if (r22 == null) goto L168;
        r22.d(r21);     // Catch: Throwable -> L94
        this.f11042g = this.f11038c.g();     // Catch: Throwable -> L94
    L168:
        c3 r23 = this.f11039d;     // Catch: Throwable -> L100
        if (r23 == null) goto L102;
        r23.j(false, x());     // Catch: Throwable -> L100
    L102:
        String r24 = p(r19);
        this.f11058w = r24;
        if (TextUtils.isEmpty(r24) == true) goto L105;
        this.f11059x = e(this.f11059x);
        g3 r25 = this.f11038c;
        if (r25 == null) goto L113;
        if (r25.f10459e == false) goto L113;
        es r26 = a(15, "networkLocation has been mocked!#1502");
        r19.f5204r = "#1502";
        r26.K = true;
        r26.R = 4;
        return r26;
    L113:
        if (this.f11046k != 0) goto L116;
    L117:
        boolean r110 = true;
    L119:
        c3 r111 = this.f11039d;
        es r27 = null;
        if (r111 == null) goto L124;
        g3 r112 = this.f11038c;
        if (r112 == null) goto L124;
        es r28 = this.f11040e.c(r111, r110, this.f11045j, r112, this.f11059x, this.f11058w, this.f11036a, false);
    L126:
        if (y3.l(r28) == false) goto L128;
        r28.R = 2;
    L133:
        this.f11045j = r28;
    L165:
        if (this.f11038c == null) goto L154;
        HashMap<String, Long> r29 = g3.B;     // Catch: Throwable -> L162
        long r30 = ((SystemClock.elapsedRealtime() - g3.C) / 1000) + 1;     // Catch: Throwable -> L162
        if (r30 > 15) goto L148;
        r28.R = 1;     // Catch: Throwable -> L162
        goto L154
    L148:
        if (r30 > 120) goto L151;
        r28.R = 2;     // Catch: Throwable -> L162
        goto L154
    L151:
        if (r30 > 600) goto L153;
        r28.R = 3;     // Catch: Throwable -> L162
        goto L154
    L153:
        r28.R = 4;     // Catch: Throwable -> L162
    L154:
        this.f11040e.h(this.f11058w, this.f11059x, r28, this.f11036a, true);
        y3.l(r28);
        StringBuilder r31 = this.f11059x;
        r31.delete(0, r31.length());
        if (this.C == false) goto L159;
        z2 r32 = this.B;
        if (r32 == null) goto L159;
        r28.setAltitude(r32.f11255f);
        r28.setBearing(this.B.f11256g);
        float r33 = (float) this.B.f11261l;
    L160:
        r28.setSpeed(r33);
        this.f11045j = r28;
        return r28;
    L159:
        r28.setAltitude(0.0d);
        r33 = 0.0f;
        r28.setBearing(0.0f);
        goto L160
    L128:
        r28 = m(true, r19);
        if (y3.l(r28) == false) goto L134;
        r28.Z = "new";
        this.f11040e.f10532h = this.f11059x.toString();
        c3 r34 = this.f11039d;
        if (r34 == null) goto L133;
        this.f11040e.f10533i = r34.l();
        goto L133
    L134:
        c3 r113 = this.f11039d;
        if (r113 == null) goto L140;
        g3 r114 = this.f11038c;
        if (r114 == null) goto L140;
        r27 = this.f11040e.c(r113, false, this.f11045j, r114, this.f11059x, this.f11058w, this.f11036a, true);
    L140:
        if (y3.l(r27) == false) goto L165;
        r19.f5204r = "#0001";
        r27.R = 2;
        this.f11045j = r27;
        r28 = r27;
    L124:
        r28 = null;
        goto L126
    L116:
        if ((SystemClock.elapsedRealtime() - this.f11046k) > 20000) goto L117;
        r110 = false;
        goto L119
    L105:
        return a(this.f11061z, r10.toString());
    L100:
        th = move-exception;
        t3.g("Aps", "getLocation getCgiListParam", th);
        goto L102
    L86:
        if (r20.f3652m == false) goto L89;
        r21 = false;
    L94:
        th = move-exception;
        t3.g("Aps", "getLocation getScanResultsParam", th);
        goto L168
    L58:
        if (this.C == false) goto L82;
        Handler r115 = r18.f11257h;
        SensorManager r35 = r18.f11250a;
        if (r35 == null) goto L166;
        if (r18.f11254e == true) goto L166;
        r18.f11254e = true;
        Sensor r116 = r18.f11251b;     // Catch: Throwable -> L68
        if (r116 == null) goto L172;
        r35.registerListener(r18, r116, 3, r115);     // Catch: Throwable -> L68
    L172:
        Sensor r36 = r18.f11252c;     // Catch: Throwable -> L74
        if (r36 == null) goto L170;
        r18.f11250a.registerListener(r18, r36, 3, r115);     // Catch: Throwable -> L74
    L170:
        Sensor r37 = r18.f11253d;     // Catch: Throwable -> L80
        if (r37 == null) goto L166;
        r18.f11250a.registerListener(r18, r37, 3, r115);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        t3.g("AMapSensorManager", "registerListener mAcceleroMeterVector", th);
    L74:
        th = move-exception;
        t3.g("AMapSensorManager", "registerListener mRotationVector", th);
    L68:
        th = move-exception;
        t3.g("AMapSensorManager", "registerListener mPressure", th);
        goto L172
    L82:
        r18.b();
        goto L166
    L47:
        if (y3.l(this.f11045j) == false) goto L55;
        if (this.f11056u == false) goto L54;
        if (s3.e(this.f11045j.getTime()) == false) goto L54;
        this.f11045j.x(2);
    L54:
        return this.f11045j;
    L36:
        if ((SystemClock.elapsedRealtime() - r16) >= 800) goto L44;
        if (y3.l(this.f11045j) == false) goto L40;
        long r38 = System.currentTimeMillis() - this.f11045j.getTime();
    L42:
        if (r38 > 10000) goto L44;
        r17 = true;
        goto L45
    L40:
        r38 = 0;
        goto L42
    }

    public final es c(es r21) {
        w2 r8 = this.D;
        r8.f11177d = this.f11056u;
        if ((SystemClock.elapsedRealtime() - r8.f11179f) <= 30000) goto L5;
        r8.f11174a = r21;
        r8.f11179f = SystemClock.elapsedRealtime();
        return r8.f11174a;
    L5:
        r8.f11179f = SystemClock.elapsedRealtime();
        if (y3.l(r8.f11174a) == true) goto L8;
    L75:
        r8.f11175b = SystemClock.elapsedRealtime();
    L76:
        r8.f11174a = r21;
    L78:
        return r21;
    L8:
        if (y3.l(r21) == false) goto L75;
        if (r21.getTime() != r8.f11174a.getTime()) goto L16;
        if (r21.getAccuracy() < 300.0f) goto L78;
    L16:
        if (CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS.equals(r21.G) == true) goto L75;
        int r10 = r21.W;
        es r11 = r8.f11174a;
        if (r10 != r11.W) goto L75;
        String r12 = r21.N;
        if (r12 != null) goto L24;
    L28:
        r8.f11178e = r21.f3649z;
        float r13 = y3.a(r21, r8.f11174a);
        float r14 = r8.f11174a.getAccuracy();
        float r15 = r21.getAccuracy();
        float r16 = r15 - r14;
        long r17 = SystemClock.elapsedRealtime();
        long r18 = r17 - r8.f11175b;
        boolean r19 = true;
        if (r14 <= 100.0f) goto L31;
    L33:
        boolean r110 = false;
    L35:
        if (r14 > 299.0f) goto L37;
    L39:
        r19 = false;
    L41:
        if (r110 == true) goto L68;
        if (r19 == true) goto L68;
        if (r15 >= 100.0f) goto L49;
        if (r14 <= 299.0f) goto L49;
    L73:
        r8.f11175b = r17;
        r8.f11174a = r21;
        r8.f11176c = 0;
    L49:
        if (r15 > 299.0f) goto L52;
        r8.f11176c = 0;
    L52:
        if (r13 >= 10.0f) goto L64;
        if (r13 <= 0.1d) goto L64;
        if (r15 <= 5.0f) goto L64;
        if (r16 < (-300.0f)) goto L61;
    L74:
        es r20 = r8.f11174a;
        r8.c(r20);
        r8.f11174a = r20;
        return r20;
    L61:
        if ((r14 / r15) < 2.0f) goto L74;
        r8.f11175b = r17;
    L64:
        if (r16 < 300.0f) goto L75;
        if (r18 < 30000) goto L74;
    L68:
        long r22 = r8.f11176c;
        if (r22 != 0) goto L72;
        r8.f11176c = r17;
        goto L74
    L72:
        if ((r17 - r22) <= 30000) goto L74;
    L37:
        if (r15 <= 299.0f) goto L39;
    L31:
        if (r15 <= 299.0f) goto L33;
        r110 = true;
        goto L35
    L24:
        if (r12.equals(r11.N) == true) goto L28;
        if (TextUtils.isEmpty(r21.N) == true) goto L28;
        goto L28
    }

    public final es d(boolean r8, em r10) {
        if (r8 == false) goto L4;
        String r11 = "statics";
    L5:
        r10.f5203q = r11;
        if (this.f11036a != null) goto L9;
        r10.f5204r = "#0101";
        this.f11052q.append("context is null#0101");
        w3.a(2011, null);
        return a(1, this.f11052q.toString());
    L9:
        g3 r12 = this.f11038c;
        if (r12 != null) goto L12;
    L15:
        o();
        if (TextUtils.isEmpty(this.f11058w) == true) goto L18;
        es r13 = m(r8, r10);
        if (y3.l(r13) == true) goto L22;
    L27:
        N = true;
        return r13;
    L22:
        if (N == true) goto L27;
        i3 r14 = this.f11040e;
        r14.f10532h = this.f11059x.toString();
        c3 r15 = this.f11039d;
        if (r15 == null) goto L26;
        i3 r16 = this.f11040e;
        r16.f10533i = r15.l();
    L26:
        this.f11045j = r13;
        goto L27
    L18:
        return a(this.f11061z, this.f11052q.toString());
    L12:
        if (r12.f10459e == false) goto L15;
        r10.f5204r = "#1502";
        return a(15, "networkLocation has been mocked!#1502");
    L4:
        r11 = "first";
        goto L5
    }

    public final StringBuilder e(StringBuilder r12) {
        int r8 = 0;
        if (r12 != null) goto L5;
        r12 = new StringBuilder(700);
    L6:
        c3 r10 = this.f11039d;
        if (r10 != null) goto L9;
    L86:
        return r12;
    L9:
        if (this.f11038c == null) goto L86;
        monitor-enter(r10);
    L83:
        th = move-exception;
        throw th;
    L12:
        if (r10.f10279o == false) goto L14;
        r10.m();     // Catch: Throwable -> L83
    L14:
        StringBuilder r11 = r10.f10280p;     // Catch: Throwable -> L83
        if (r11 != null) goto L17;
        r10.f10280p = new StringBuilder();     // Catch: Throwable -> L83
    L18:
        b3 r13 = r10.l();     // Catch: Throwable -> L83
        if (r13 == null) goto L21;
        int r14 = r13.f10241l;     // Catch: Throwable -> L83
    L23:
        if ((r14 & 3) != 1) goto L29;
        int r15 = 1;
    L27:
        if (r15 >= r10.f10268d.size()) goto L29;
        StringBuilder r16 = r10.f10280p;     // Catch: Throwable -> L83
        r16.append("#");     // Catch: Throwable -> L83
        r16.append(r10.f10268d.get(r15).f10231b);     // Catch: Throwable -> L83
        StringBuilder r17 = r10.f10280p;     // Catch: Throwable -> L83
        r17.append("|");     // Catch: Throwable -> L83
        r17.append(r10.f10268d.get(r15).f10232c);     // Catch: Throwable -> L83
        StringBuilder r18 = r10.f10280p;     // Catch: Throwable -> L83
        r18.append("|");     // Catch: Throwable -> L83
        r18.append(r10.f10268d.get(r15).f10233d);     // Catch: Throwable -> L83
        r15 = r15 + 1;     // Catch: Throwable -> L83
    L29:
        int r19 = 1;
    L31:
        if (r19 >= r10.f10270f.size()) goto L49;
        b3 r20 = r10.f10270f.get(r19);     // Catch: Throwable -> L83
        int r21 = r20.f10241l;     // Catch: Throwable -> L83
        if (r21 == 1) goto L42;
        if (r21 == 3) goto L42;
        if (r21 == 4) goto L42;
        if (r21 == 5) goto L42;
        if (r21 != 2) goto L47;
        StringBuilder r22 = r10.f10280p;     // Catch: Throwable -> L83
        r22.append("#");     // Catch: Throwable -> L83
        r22.append(r20.f10241l);     // Catch: Throwable -> L83
        StringBuilder r23 = r10.f10280p;     // Catch: Throwable -> L83
        r23.append("|");     // Catch: Throwable -> L83
        r23.append(r20.f10230a);     // Catch: Throwable -> L83
        StringBuilder r24 = r10.f10280p;     // Catch: Throwable -> L83
        r24.append("|");     // Catch: Throwable -> L83
        r24.append(r20.f10237h);     // Catch: Throwable -> L83
        StringBuilder r25 = r10.f10280p;     // Catch: Throwable -> L83
        r25.append("|");     // Catch: Throwable -> L83
        r25.append(r20.f10238i);     // Catch: Throwable -> L83
        StringBuilder r26 = r10.f10280p;     // Catch: Throwable -> L83
        r26.append("|");     // Catch: Throwable -> L83
        r26.append(r20.f10239j);     // Catch: Throwable -> L83
    L47:
        r19 = r19 + 1;     // Catch: Throwable -> L83
    L42:
        StringBuilder r27 = r10.f10280p;     // Catch: Throwable -> L83
        r27.append("#");     // Catch: Throwable -> L83
        r27.append(r20.f10241l);     // Catch: Throwable -> L83
        StringBuilder r28 = r10.f10280p;     // Catch: Throwable -> L83
        r28.append("|");     // Catch: Throwable -> L83
        r28.append(r20.f10230a);     // Catch: Throwable -> L83
        StringBuilder r29 = r10.f10280p;     // Catch: Throwable -> L83
        r29.append("|");     // Catch: Throwable -> L83
        r29.append(r20.f10231b);     // Catch: Throwable -> L83
        StringBuilder r30 = r10.f10280p;     // Catch: Throwable -> L83
        r30.append("|");     // Catch: Throwable -> L83
        r30.append(r20.f10232c);     // Catch: Throwable -> L83
        StringBuilder r31 = r10.f10280p;     // Catch: Throwable -> L83
        r31.append("|");     // Catch: Throwable -> L83
        if (r20.f10241l != 5) goto L45;
        long r32 = r20.f10234e;     // Catch: Throwable -> L83
    L46:
        r31.append(r32);     // Catch: Throwable -> L83
        goto L47
    L45:
        r32 = r20.f10233d;     // Catch: Throwable -> L83
        goto L46
    L49:
        if (r10.f10280p.length() <= 0) goto L51;
        r10.f10280p.deleteCharAt(0);     // Catch: Throwable -> L83
    L51:
        String r33 = r10.f10280p.toString();     // Catch: Throwable -> L83
        monitor-exit(r10);
        r12.append(r33);
        g3 r110 = this.f11038c;
        StringBuilder r34 = r110.f10460f;
        if (r34 != null) goto L56;
        r110.f10460f = new StringBuilder(700);
    L57:
        r110.f10459e = false;
        int r35 = r110.f10456b.size();
        boolean r36 = false;
        boolean r37 = false;
    L58:
        if (r8 >= r35) goto L72;
        String r38 = n2.b(r110.f10456b.get(r8).f10851a);
        if (r110.f10462h == true) goto L65;
        if ("<unknown ssid>".equals(r110.f10456b.get(r8).f10852b) == true) goto L65;
        r36 = true;
    L65:
        if (TextUtils.isEmpty(r110.f10471q) == false) goto L67;
    L69:
        boolean r39 = r37;
        String r40 = "nb";
    L70:
        r110.f10460f.append(String.format(Locale.US, "#%s,%s", new Object[]{r38, r40}));
        r8 = r8 + 1;
        r37 = r39;
        goto L58
    L67:
        if (r110.f10471q.equals(r38) == false) goto L69;
        r40 = "access";
        r39 = true;
        goto L70
    L72:
        if (r110.f10456b.size() != 0) goto L75;
        r36 = true;
    L75:
        if (r110.f10462h == true) goto L78;
        if (r36 == true) goto L78;
        r110.f10459e = true;
    L78:
        if (r37 == false) goto L80;
    L82:
        r12.append(r110.f10460f.toString());
        goto L86
    L80:
        if (TextUtils.isEmpty(r110.f10471q) == true) goto L82;
        StringBuilder r41 = r110.f10460f;
        r41.append("#");
        r41.append(r110.f10471q);
        r110.f10460f.append(",access");
        goto L82
    L56:
        r34.delete(0, r34.length());
        goto L57
    L21:
        r14 = 0;
        goto L23
    L17:
        r11.delete(0, r11.length());     // Catch: Throwable -> L83
        goto L18
    L5:
        r12.delete(0, r12.length());
        goto L6
    }

    public final void f(Context r8) {
    L18:
        th = move-exception;
        th.printStackTrace();
        t3.g("Aps", "initBase", th);
        return;
    L3:
        if (this.f11036a == null) goto L5;
        return;
    L5:
        this.D = new w2();     // Catch: Throwable -> L18
        Context r10 = r8.getApplicationContext();     // Catch: Throwable -> L18
        this.f11036a = r10;     // Catch: Throwable -> L18
        y3.s(r10);     // Catch: Throwable -> L18
        if (this.f11038c != null) goto L9;
        WifiManager r11 = (WifiManager) y3.d(this.f11036a, "wifi");     // Catch: Throwable -> L18
        this.f11038c = new g3(this.f11036a, r11, this.F);     // Catch: Throwable -> L18
    L9:
        if (this.f11039d != null) goto L11;
        this.f11039d = new c3(this.f11036a, this.F);     // Catch: Throwable -> L18
    L11:
        this.G = new e3(r8, this.F);     // Catch: Throwable -> L18
        if (this.f11040e != null) goto L15;
        this.f11040e = new i3();     // Catch: Throwable -> L18
    L15:
        if (this.f11041f != null) goto L23;
        this.f11041f = new q3();     // Catch: Throwable -> L18
        return;
    }

    public final void g(AMapLocation r8) {
        if (r8.f3646w == 0) goto L5;
        return;
    L5:
        d3 r10 = new d3();
        r10.f10300a = r8.f3649z;
        r10.f10303d = r8.getTime();
        r10.f10304e = (int) r8.getAccuracy();
        r10.f10301b = r8.getLatitude();
        r10.f10302c = r8.getLongitude();
        if (r8.f3649z != 1) goto L9;
        this.G.b(r10, 1);
    L9:
        if (r8.f3649z != 12) goto L12;
        this.G.b(r10, 12);
        return;
    }

    public final void h(AMapLocationClientOption r8) {
        this.f11044i = r8;
        if (r8 != null) goto L5;
        this.f11044i = new AMapLocationClientOption();
    L5:
        g3 r10 = this.f11038c;
        if (r10 == null) goto L11;
        this.f11044i.getClass();
        AMapLocationClientOption r11 = this.f11044i;
        boolean r12 = r11.f3664y;
        boolean r13 = r11.f3653n;
        boolean r14 = AMapLocationClientOption.N;
        r8.getClass();
        long r15 = AMapLocationClientOption.O;
        r10.f10461g = r12;
        r10.f10462h = r13;
        r10.f10463i = r14;
        if (r15 >= 10000) goto L10;
        r10.f10474t = 10000;
        goto L11
    L10:
        r10.f10474t = r15;
    L11:
        u();
        i3 r16 = this.f11040e;
        if (r16 == null) goto L14;
        AMapLocationClientOption r17 = this.f11044i;
        r16.getClass();
        r16.f10537m = r17.f3654o;
        r16.f10536l = r17.f3660u;
        r16.f10530f = r17.f3661v;
        r16.f10538n = String.valueOf(r17.B);
    L14:
        q3 r18 = this.f11041f;
        if (r18 == null) goto L20;
        AMapLocationClientOption r19 = this.f11044i;
        if (r19 != null) goto L19;
        r18.getClass();
        r18.f10953b = new AMapLocationClientOption();
        goto L20
    L19:
        r18.f10953b = r19;
    L20:
        c3 r20 = this.f11039d;
        if (r20 == null) goto L23;
        r20.f10285u = this.f11044i.H;
    L23:
        AMapLocationClientOption.e r21 = AMapLocationClientOption.e.f3674a;
        boolean r22 = true;
        AMapLocationClientOption r23 = this.f11044i;     // Catch: Throwable -> L46
        r21 = r23.B;     // Catch: Throwable -> L46
        boolean r24 = r23.f3654o;     // Catch: Throwable -> L46
        boolean r25 = r23.f3660u;     // Catch: Throwable -> L45
        r22 = r23.f3661v;     // Catch: Throwable -> L44
        this.f11057v = r23.f3662w;     // Catch: Throwable -> L44
        this.C = r23.f3663x;     // Catch: Throwable -> L44
        if (r25 == this.f11054s) goto L29;
    L55:
        i3 r26 = this.f11040e;     // Catch: Throwable -> L41
        if (r26 == null) goto L37;
        r26.f10531g = 0;     // Catch: Throwable -> L41
        r26.f10532h = null;     // Catch: Throwable -> L41
    L37:
        this.A = false;     // Catch: Throwable -> L41
        w2 r27 = this.D;     // Catch: Throwable -> L41
        if (r27 == null) goto L48;
        r27.b();     // Catch: Throwable -> L41
    L48:
        this.f11054s = r25;
        this.f11053r = r24;
        this.f11056u = r22;
        this.f11055t = r21;
        return;
    L41:
        th = move-exception;
        t3.g("Aps", "cleanCache", th);     // Catch: Throwable -> L44
        goto L48
    L29:
        if (r24 != this.f11053r) goto L55;
        if (r22 != this.f11056u) goto L55;
        if (r21 == this.f11055t) goto L48;
    L44:
        boolean r28 = r22;
        r22 = r25;
    L47:
        r25 = r22;
        r22 = r28;
    L45:
        r28 = true;
    L46:
        r28 = true;
        r24 = true;
        goto L47
    }

    public final void i(es r10, int r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.f3646w == 0) goto L7;
        return;
    L7:
        d3 r8 = new d3();
        r8.f10303d = r10.getTime();
        r8.f10304e = (int) r10.getAccuracy();
        r8.f10301b = r10.A;
        r8.f10302c = r10.B;
        r8.f10300a = r11;
        r8.f10305f = Integer.parseInt(r10.X);
        r8.f10306g = r10.Y;
        e3 r12 = this.G;
        LinkedList<d3> r13 = r12.f10369a;
        if (r13.size() <= 0) goto L30;
        int r14 = r8.f10300a;
        if (r14 != 6) goto L12;
    L19:
        d3 r15 = r13.getLast();
        if (r15.f10302c != r8.f10302c) goto L26;
        if (r15.f10301b != r8.f10301b) goto L26;
        if (r15.f10304e != r8.f10304e) goto L26;
        return;
    L26:
        if (r13.size() < 10) goto L28;
    L27:
        r13.removeFirst();
    L28:
        r13.add(r8);
        r12.f10374f = true;
        return;
    L12:
        if (r14 == 5) goto L19;
        if (r13.contains(r8) == false) goto L17;
        return;
    L17:
        if (r13.size() < 10) goto L28;
    }

    public final void j(boolean r8) {
        c3 r10 = this.f11039d;
        if (r10 == null) goto L26;
        r10.f10284t = r8;
        if (r10.f10285u == true) goto L27;
        if (r8 == true) goto L8;
    L10:
        if (r8 == false) goto L12;
        return;
    L12:
        if (r10.f10286v == false) goto L30;
        TelephonyManager r11 = r10.f10271g;
        if (r11 == null) goto L22;
        c3.b r12 = r10.f10274j;
        if (r12 == null) goto L22;
        r11.listen(r12, 0);     // Catch: Throwable -> L20
        r10.f10286v = false;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        t3.g("CgiManager", "destroy", th);
    L22:
        r10.f10274j = null;
        return;
    L30:
        return;
    L8:
        if (r10.f10286v == true) goto L10;
        r10.n();
        return;
    L27:
        return;
    }

    public final void k() {
        c3 r8 = this.f11039d;
        if (r8 == null) goto L31;
        Context r10 = r8.f10265a;
        if (r10.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L8;
        String r11 = "hasFineLocPerm";
    L10:
        if (r10.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L12;
        String r12 = "hasReadPhoneStatePerm";
    L13:
        boolean r13 = true;
        if (TextUtils.isEmpty(r8.f10282r) == false) goto L16;
    L18:
        boolean r14 = false;
    L20:
        if (TextUtils.isEmpty(r8.f10281q) == false) goto L22;
    L24:
        r13 = r14;
    L25:
        if (r13 == false) goto L32;
        r8.n();     // Catch: Throwable -> L28
        return;
    L32:
        return;
    L22:
        if (r8.f10281q.equals(r12) == true) goto L24;
    L16:
        if (r8.f10282r.equals(r11) == true) goto L18;
        r14 = true;
        goto L20
    L12:
        r12 = "hasNoReadPhoneStatePerm";
        goto L13
    L8:
        r11 = "hasNoFineLocPerm";
    L33:
        return;
    }

    public final es l(boolean r8) {
        g3 r10 = this.f11038c;
        if (r10 == null) goto L9;
        if (r10.f10459e == false) goto L9;
        return a(15, "networkLocation has been mocked!#1502");
    L9:
        if (TextUtils.isEmpty(this.f11058w) == true) goto L11;
        es r11 = this.f11040e.a(this.f11036a, this.f11058w, this.f11059x, true, r8);
        if (y3.l(r11) == false) goto L16;
        if (r11 == null) goto L16;
        this.f11045j = r11;
    L16:
        return r11;
    L11:
        return a(this.f11061z, this.f11052q.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v26, types: [java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [byte[]] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @SuppressLint({"NewApi"})
    public final es m(boolean r28, em r29) {
        String r8 = "FAIL";
        StringBuilder r10 = this.f11052q;
        if (TextUtils.isEmpty(this.K) == false) goto L6;
        this.K = t4.j(k4.h(this.f11036a) + "," + k4.m(this.f11036a));     // Catch: Throwable -> L333
    L6:
        r10.append("#id:");     // Catch: Throwable -> L333
        r10.append(this.K);     // Catch: Throwable -> L333
    L7:
        es r15 = new es();
        byte[] r21 = w();     // Catch: Throwable -> L331
        long r11 = SystemClock.elapsedRealtime();
        this.f11046k = r11;
        r29.f5199m = r11;
        ?? r13 = 1;
        r13 = 1;
        r13 = 1;
    L293:
        th = th;
        int r12 = 1;
    L50:
        NetworkInfo r14 = null;
        g4 r16 = th;
    L296:
        SystemClock.elapsedRealtime();
        r29.f5202p = r8;
        m3.b(this.f11036a).c(r12, false);
        t3.g("Aps", "getApsLoc req", r16);
        ArrayList r17 = w3.f11182g;
        if ((r16 instanceof g4) == false) goto L363;
        s4 r18 = t3.j();     // Catch: Throwable -> L334
        g4 r19 = r16;     // Catch: Throwable -> L334
        Set<Integer> r20 = q.f10946e;     // Catch: Throwable -> L334
        q.d(r18, "/mobile/binary", r19.f10481o, r19.f10478b, r19.f10479m, r19.f10480n);     // Catch: Throwable -> L334
    L363:
        NetworkInfo r110 = k4.o(this.f11036a);     // Catch: Throwable -> L303
    L306:
        if (r110 == null) goto L310;
        if (r110.isConnectedOrConnecting() == false) goto L310;
        int r111 = r12;
    L311:
        if (r111 != 0) goto L314;
        r29.f5204r = "#0401";
        String r22 = "网络异常，未连接到网络，请连接网络#0401";
    L325:
        r10.append(r22);
    L328:
        es r23 = a(4, r10.toString());
    L329:
        r23.f5211f0 = this.f11059x.toString();
        return r23;
    L314:
        if ((r16 instanceof g4) == false) goto L326;
        g4 r24 = r16;
        boolean r25 = r24.f10477a.contains("网络异常状态码");
        int r26 = r24.f10482p;
        if (r25 == false) goto L319;
        r29.f5204r = "#0404";
        r10.append("网络异常，状态码错误#0404");
        r10.append(r26);
        goto L328
    L319:
        if (r26 != 23) goto L321;
    L324:
        r29.f5204r = "#0402";
        r22 = "网络异常，连接超时#0402";
        goto L325
    L321:
        if (Math.abs((SystemClock.elapsedRealtime() - this.f11046k) - this.f11044i.f3651b) < 500) goto L324;
        StringBuilder r27 = new StringBuilder("#0403,");
    L327:
        r27.append(r16.getMessage());
        r29.f5204r = r27.toString();
        r10.append("网络异常,请求异常#0403");
        goto L328
    L326:
        r27 = new StringBuilder("#0403,");
        goto L327
    L303:
        th = move-exception;
        t3.g("Utils", "getNetWorkInfo", th);     // Catch: Throwable -> L335
        r110 = r14;
    L310:
        r111 = 0;
        goto L311
    L379:
    L16:
        th = move-exception;
        t3.g("CoreUtil", "changeUrl", th);     // Catch: Throwable -> L293
    L18:
        p3 r30 = this.f11051p.b(this.f11036a, r21, t3.f11116c, t3.f11117d, r28);     // Catch: Throwable -> L293
        r30.getClass();     // Catch: Throwable -> L293
        String r112 = r30.f10896q;     // Catch: Throwable -> L293
        Context r113 = this.f11036a;     // Catch: Throwable -> L293
        int r114 = i4.f10541a;     // Catch: Throwable -> L293
        if (r113 == null) goto L22;
        i4.f10543c = r113.getApplicationContext();     // Catch: Throwable -> L293
    L22:
        if (TextUtils.isEmpty(r112) == false) goto L24;
    L26:
        boolean r115 = false;
    L28:
        if (i4.m() == true) goto L30;
    L33:
        int r116 = 1;
    L35:
        if (i4.r() == true) goto L37;
        String r117 = m3.b(this.f11036a).a(r30, r116);     // Catch: Throwable -> L293
    L38:
        if (r116 != 2) goto L40;
        String r118 = "v6";
    L41:
        r29.f5205s = r118;     // Catch: Throwable -> L293
        if (this.f11051p.f10878c == false) goto L44;
        r30.b(m0.c.f10822b);     // Catch: Throwable -> L293
    L44:
        n0 r31 = h0.a(r30);     // Catch: Throwable -> L293
        long r119 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L293
        if (TextUtils.isEmpty(r117) == true) goto L67;
        if (r31.f10846e == true) goto L402;
        m3.b(this.f11036a).c(r116, true);     // Catch: Throwable -> L293
        goto L67
    L402:
        m3.b(this.f11036a).c(r116, false);     // Catch: Throwable -> L63
        m3 r32 = m3.b(this.f11036a);     // Catch: Throwable -> L293
        if (r32.f(r116).f11162e == true) goto L62;
        ArrayList<String> r120 = r32.f10829b;     // Catch: Throwable -> L293
        r13 = r32.f(r116).f11159b;     // Catch: Throwable -> L291
        r120.add((String) r13);     // Catch: Throwable -> L291
        r32.i(r116);     // Catch: Throwable -> L291
        r32.g(r116, true);     // Catch: Throwable -> L60
    L60:
        th = th;
        r12 = 1;
        goto L50
    L62:
        r32.i(r116);     // Catch: Throwable -> L291
    L63:
        th = move-exception;
        r16 = th;
        r8 = "FAIL";
        r12 = 1;
        r14 = null;
    L67:
        if (TextUtils.isEmpty(r117) == false) goto L69;
    L72:
        r29.f5202p = "SUCCESS";     // Catch: Throwable -> L291
    L73:
        u2 r33 = this.L;     // Catch: Throwable -> L291
        if (r33 == null) goto L76;
        r33.e();     // Catch: Throwable -> L291
    L76:
        r29.f5200n = r119;
        if (TextUtils.isEmpty(r31.f10844c) == true) goto L79;
        r10.append("#csid:" + r31.f10844c);
    L79:
        String r34 = r31.f10845d;
        es r121 = r15;
        r121.f5211f0 = this.f11059x.toString();
        byte[] r35 = r31.f10842a;     // Catch: Throwable -> L116
        if (r35 != null) goto L83;
        boolean r122 = false;
        int r123 = 4;
    L112:
        r121.v(r123);     // Catch: Throwable -> L114
        r10.append("网络异常,请求异常#0403");     // Catch: Throwable -> L114
        r29.f5204r = "#0403";     // Catch: Throwable -> L114
        r121.f5211f0 = this.f11059x.toString();     // Catch: Throwable -> L114
        r121.f3648y = r10.toString();     // Catch: Throwable -> L114
        w3.a(2041, r31.f10845d);     // Catch: Throwable -> L114
        boolean r124 = r122;
    L113:
        es r36 = r121;
        ?? r125 = r124;
    L120:
        if (r36 == null) goto L122;
        return r36;
    L122:
        byte[] r37 = r31.f10842a;
        char[] r38 = h3.f10504a;
        byte[] r39 = new byte[16];     // Catch: Throwable -> L129
        byte[] r40 = new byte[r37.length - 16];     // Catch: Throwable -> L129
        int r126 = 0;
        System.arraycopy(r37, 0, r39, 0, 16);     // Catch: Throwable -> L127
        System.arraycopy(r37, 16, r40, 0, r37.length - 16);     // Catch: Throwable -> L127
        SecretKeySpec r41 = new SecretKeySpec(r39, "AES");     // Catch: Throwable -> L127
        Cipher r42 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L127
        r42.init(2, r41, new IvParameterSpec(t4.o()));     // Catch: Throwable -> L127
        ?? r43 = r42.doFinal(r40);     // Catch: Throwable -> L127
    L135:
        if (r43 != 0) goto L138;
        r121.v(5);
        r29.f5204r = "#0503";
        r10.append("解密数据失败#0503");
        r121.f3648y = r10.toString();
        w3.a(2053, r34);
        return r121;
    L138:
        q3 r44 = this.f11041f;
        StringBuilder r127 = r44.f10952a;
        ByteBuffer r45 = ByteBuffer.wrap(r43);     // Catch: Throwable -> L245
    L242:
        th = th;
        String r210 = r34;
        StringBuilder r211 = r10;
        StringBuilder r46 = r127;
    L244:
        ByteBuffer r128 = r45;
    L349:
        es r47 = new es();     // Catch: Throwable -> L287
        int r48 = 5;
        r47.v(5);     // Catch: Throwable -> L287
        r29.f5204r = "#0505";     // Catch: Throwable -> L287
        r46.append("parser data error:" + th.getMessage() + "#0505");     // Catch: Throwable -> L287
        w3.a(2054, null);     // Catch: Throwable -> L287
        r47.f3648y = r46.toString();     // Catch: Throwable -> L287
        if (r128 == null) goto L250;
        r128.clear();
    L250:
        r121 = r47;
    L252:
        if (r46.length() <= 0) goto L255;
        r46.delete(0, r46.length());
    L255:
        if (y3.l(r121) == true) goto L266;
        String r49 = r121.V;
        this.f11050o = r49;
        if (TextUtils.isEmpty(r49) == true) goto L259;
        int r50 = 2062;
    L260:
        w3.a(r50, r210);
        r121.v(6);
        r29.f5204r = "#0601";
        StringBuilder r51 = new StringBuilder("location faile retype:");
        r51.append(r121.X);
        r51.append(" rdesc:");
        if (TextUtils.isEmpty(this.f11050o) == false) goto L263;
        String r52 = "";
    L264:
        r51.append(r52);
        r51.append("#0601");
        StringBuilder r53 = r211;
        r53.append(r51.toString());
        r121.f5211f0 = this.f11059x.toString();
        r121.f3648y = r53.toString();
        return r121;
    L263:
        r52 = this.f11050o;
        goto L264
    L259:
        r50 = 2061;
        goto L260
    L266:
        StringBuilder r54 = r211;
        if (r121.f3646w == 0) goto L269;
    L285:
        r121.f3645v = this.f11054s;
        r121.f5209c0 = this.f11053r;
        r121.d0 = String.valueOf(this.f11055t);
        r121.Z = "new";
        r121.f3648y = r54.toString();
        this.E = r121.U;
        return r121;
    L269:
        if (r121.f3649z != 0) goto L285;
        if ("-5".equals(r121.X) == false) goto L273;
    L284:
        r121.x(r48);
        goto L285
    L273:
        if ("1".equals(r121.X) == true) goto L284;
        if (AwareStateListener.USER_INFO_FILE_REMOTE_MODE.equals(r121.X) == true) goto L284;
        if ("14".equals(r121.X) == true) goto L284;
        if (BDLocationException.ERROR_UNKNOWN.equals(r121.X) == true) goto L284;
        if ("-1".equals(r121.X) == true) goto L284;
        r121.x(6);
    L287:
        th = move-exception;
        if (r128 == null) goto L290;
        r128.clear();
    L290:
        throw th;
    L141:
        if (r45.get() == 0) goto L369;
        r121.B = ((long) ((((double) r45.getInt()) / 1000000.0d) * 1000000.0d)) / 1000000.0d;     // Catch: Throwable -> L242
        r121.A = ((long) ((((double) r45.getInt()) / 1000000.0d) * 1000000.0d)) / 1000000.0d;     // Catch: Throwable -> L242
        r121.setAccuracy(r45.getShort());     // Catch: Throwable -> L242
        r121.C(String.valueOf(r45.get()));     // Catch: Throwable -> L242
        r121.X = String.valueOf(r45.get());     // Catch: Throwable -> L242
        if (r45.get() != 1) goto L194;
        byte[] r55 = new byte[r45.get() & 255];     // Catch: Throwable -> L242
        r45.get(r55);     // Catch: Throwable -> L242
        r121.f3641r = new String(r55, "UTF-8");     // Catch: Throwable -> L336
    L150:
        byte[] r56 = new byte[r45.get() & 255];     // Catch: Throwable -> L242
        r45.get(r56);     // Catch: Throwable -> L242
        String r129 = new String(r56, "UTF-8");     // Catch: Throwable -> L154
        r121.f3634a = r129;     // Catch: Throwable -> L337
    L153:
        String r57 = r129;
    L155:
        byte[] r130 = new byte[r45.get() & 255];     // Catch: Throwable -> L242
        r45.get(r130);     // Catch: Throwable -> L242
        String r131 = new String(r130, "UTF-8");     // Catch: Throwable -> L159
        r121.f3635b = r131;     // Catch: Throwable -> L338
    L160:
        byte[] r132 = new byte[r45.get() & 255];     // Catch: Throwable -> L242
        r45.get(r132);     // Catch: Throwable -> L242
        String r133 = new String(r132, "UTF-8");     // Catch: Throwable -> L164
        r121.f3636m = r133;     // Catch: Throwable -> L339
    L165:
        byte[] r134 = new byte[r45.get() & 255];     // Catch: Throwable -> L242
        r45.get(r134);     // Catch: Throwable -> L242
        String r135 = new String(r134, "UTF-8");     // Catch: Throwable -> L169
        r121.f3643t = r135;     // Catch: Throwable -> L340
        r121.f3642s = r135;     // Catch: Throwable -> L340
    L170:
        byte[] r136 = new byte[r45.get() & 255];     // Catch: Throwable -> L242
        r45.get(r136);     // Catch: Throwable -> L242
        String r137 = new String(r136, "UTF-8");     // Catch: Throwable -> L175
        r121.f3644u = r137;     // Catch: Throwable -> L341
    L174:
        String r138 = r137;
    L367:
        byte[] r139 = new byte[r45.get() & 255];     // Catch: Throwable -> L192
        r45.get(r139);     // Catch: Throwable -> L192
        String r140 = new String(r139, "UTF-8");     // Catch: Throwable -> L180
        r121.f3640q = r140;     // Catch: Throwable -> L342
    L179:
        String r212 = r140;
    L181:
        byte[] r141 = new byte[r45.get() & 255];     // Catch: Throwable -> L192
        r45.get(r141);     // Catch: Throwable -> L192
        r121.I = new String(r141, "UTF-8");     // Catch: Throwable -> L343
    L183:
        byte[] r142 = new byte[r45.get() & 255];     // Catch: Throwable -> L192
        r45.get(r142);     // Catch: Throwable -> L192
        String r143 = new String(r142, "UTF-8");     // Catch: Throwable -> L187
        r121.f3638o = r143;     // Catch: Throwable -> L344
    L186:
        String r213 = r143;
    L188:
        byte[] r144 = new byte[r45.get() & 255];     // Catch: Throwable -> L192
        r45.get(r144);     // Catch: Throwable -> L192
        r121.f3637n = new String(r144, "UTF-8");     // Catch: Throwable -> L345
    L190:
        r211 = r10;
        r46 = r127;
        r210 = r34;
        byte r58 = 1;
        r44.c(r121, r57, r131, r133, r135, r138, r212, r213);     // Catch: Throwable -> L223
    L195:
        r45.get(new byte[r45.get() & 255]);     // Catch: Throwable -> L223
        if (r45.get() != r58) goto L199;
        r45.getInt();     // Catch: Throwable -> L223
        r45.getInt();     // Catch: Throwable -> L223
        r45.getShort();     // Catch: Throwable -> L223
    L199:
        if (r45.get() != r58) goto L209;
        byte[] r59 = new byte[r45.get() & 255];     // Catch: Throwable -> L223
        r45.get(r59);     // Catch: Throwable -> L223
        es r145 = r121;
        r145.N = new String(r59, "UTF-8");     // Catch: Throwable -> L346
    L206:
        byte[] r60 = new byte[r45.get() & 255];     // Catch: Throwable -> L223
        r45.get(r60);     // Catch: Throwable -> L223
        r145.w(new String(r60, "UTF-8"));     // Catch: Throwable -> L347
    L211:
        if (r45.get() != r58) goto L214;
        r45.get();     // Catch: Throwable -> L223
        r45.getInt();     // Catch: Throwable -> L223
        r45.get();     // Catch: Throwable -> L223
    L214:
        if (r45.get() != r58) goto L216;
        r145.setTime(r45.getLong());     // Catch: Throwable -> L223
    L216:
        int r61 = r45.getShort();     // Catch: Throwable -> L223
        if (r61 <= 0) goto L225;
        byte[] r62 = new byte[r61];     // Catch: Throwable -> L223
        r45.get(r62);     // Catch: Throwable -> L223
        if (r61 <= 0) goto L225;
        r145.U = new String(Base64.decode(r62, 0), "UTF-8");     // Catch: Throwable -> L348
    L225:
        int r63 = r45.getShort();     // Catch: Throwable -> L223
        if (r63 <= 0) goto L229;
        r45.get(new byte[r63]);     // Catch: Throwable -> L223
    L229:
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.1d) goto L241;
        short r146 = r45.getShort();     // Catch: Throwable -> L223
        if ("-1".equals(r145.X) == true) goto L238;
        if (r146 != (-1)) goto L235;
        r146 = 0;
    L240:
        r145.S = r146;     // Catch: Throwable -> L223
        r145.Y = r45.get();     // Catch: Throwable -> L223
        goto L241
    L235:
        if (r146 != 0) goto L240;
        r146 = -1;
        goto L240
    L238:
        if (r146 != 101) goto L240;
        r146 = 100;
    L241:
        r45.clear();
        r121 = r145;
        r48 = 5;
    L205:
        r145 = r121;
        goto L206
    L209:
        r145 = r121;
    L223:
        th = th;
    L187:
        r213 = "";
    L180:
        r212 = "";
    L192:
        th = th;
        r210 = r34;
        r211 = r10;
        r46 = r127;
    L175:
        r138 = "";
    L169:
        r135 = "";
    L164:
        r133 = "";
    L159:
        r131 = "";
    L154:
        r57 = "";
        goto L155
    L194:
        r210 = r34;
        r211 = r10;
        r46 = r127;
        r58 = 1;
        goto L195
    L369:
        r121.V = String.valueOf(r45.getShort());     // Catch: Throwable -> L144
        r45.clear();     // Catch: Throwable -> L144
        r45.clear();
        r210 = r34;
        r211 = r10;
        r48 = 5;
    L144:
        th = th;
        r210 = r34;
        r128 = r45;
        r211 = r10;
        r46 = r127;
    L245:
        th = th;
        r210 = r34;
        r211 = r10;
        r46 = r127;
        r128 = null;
    L127:
        th = th;
    L131:
        if (r37 == null) goto L133;
        int r64 = r37.length;
    L134:
        t3.g("Encrypt", "decryptRsponse length = ".concat(String.valueOf(r64)), th);
        r43 = r125;
        goto L135
    L133:
        r64 = r126;
    L129:
        th = th;
        r126 = 0;
        goto L131
    L83:
        if (r35.length != 0) goto L85;
        r123 = 4;
        r122 = false;
        goto L112
    L85:
        q3 r65 = new q3();     // Catch: Throwable -> L116
        String r66 = new String(r31.f10842a, "UTF-8");     // Catch: Throwable -> L116
        if (r66.contains("\"status\":\"0\"") == false) goto L95;
        r36 = r65.b(r66, this.f11036a, r31, r29);     // Catch: Throwable -> L92
        r36.f5211f0 = this.f11059x.toString();     // Catch: Throwable -> L90
        r125 = 0;
    L90:
        th = th;
    L105:
        int r147 = 4;
        ?? r148 = 0;
    L119:
        r36.v(r147);
        t3.g("Aps", "checkResponseEntity", th);
        r29.f5204r = "#0403";
        r10.append("check response exception ex is" + th.getMessage() + "#0403");
        r36.f3648y = r10.toString();
        r125 = r148;
        goto L120
    L95:
        if (r66.contains("</body></html>") == false) goto L110;
        r121.v(5);     // Catch: Throwable -> L116
        g3 r67 = this.f11038c;     // Catch: Throwable -> L116
        if (r67 != null) goto L99;
    L106:
        r29.f5204r = "#0502";     // Catch: Throwable -> L116
        r10.append("请求可能被劫持了#0502");     // Catch: Throwable -> L116
        boolean r149 = false;
        w3.a(2052, null);     // Catch: Throwable -> L114
    L109:
        r121.f3648y = r10.toString();     // Catch: Throwable -> L114
        r124 = r149;
        goto L113
    L99:
        if (r67.b(this.f11037b) == false) goto L106;
        r29.f5204r = "#0501";     // Catch: Throwable -> L92
        r10.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");     // Catch: Throwable -> L92
        w3.a(2051, null);     // Catch: Throwable -> L116
        r149 = false;
        goto L109
    L110:
        r125 = 0;
        r36 = null;
    L92:
        th = th;
        r36 = r121;
    L114:
        th = th;
    L118:
        r36 = r121;
        r147 = 4;
        r148 = r13;
    L116:
        th = th;
        r13 = 0;
        goto L118
    L69:
        if (r31.f10846e == true) goto L71;
        r29.f5206t = r117;     // Catch: Throwable -> L291
        r29.f5201o = "SUCCESS";     // Catch: Throwable -> L291
        goto L73
    L71:
        r29.f5206t = r117;     // Catch: Throwable -> L291
        r29.f5201o = "FAIL";     // Catch: Throwable -> L291
    L291:
        th = th;
        r12 = 1;
        goto L50
    L40:
        r118 = "v4";
        goto L41
    L37:
        r117 = null;
        goto L38
    L30:
        if (i4.t() == false) goto L33;
        if (r115 == false) goto L33;
        r116 = 2;
        goto L35
    L24:
        if (r112.contains("dualstack") == false) goto L26;
        r115 = true;
        goto L28
    L12:
        if (t4.l(this.f11036a) == false) goto L14;
        t3.f11116c = "http://abroad.apilocate.amap.com/mobile/binary";     // Catch: Throwable -> L16
        t3.f11117d = "http://abroad.apilocate.amap.com/mobile/binary";     // Catch: Throwable -> L16
    L378:
    L14:
        t3.f11116c = "http://apilocate.amap.com/mobile/binary";     // Catch: Throwable -> L16
        t3.f11117d = "http://dualstack-a.apilocate.amap.com/mobile/binary";     // Catch: Throwable -> L16
    L331:
        th = move-exception;
        r29.f5204r = "#0301";
        r10.append("get parames error:" + th.getMessage() + "#0301");
        w3.a(2031, null);
        r23 = a(3, r10.toString());
        goto L329
    }

    public final void n(em r8) {
    L25:
        th = move-exception;
        t3.g("Aps", "initFirstLocateParam", th);
    L27:
        this.f11060y = true;
        return;
    L4:
        if (this.f11060y == false) goto L7;
        return;
    L7:
        if (this.f11058w == null) goto L9;
        this.f11058w = null;     // Catch: Throwable -> L25
    L9:
        StringBuilder r10 = this.f11059x;     // Catch: Throwable -> L25
        if (r10 == null) goto L13;
        r10.delete(0, r10.length());     // Catch: Throwable -> L25
    L13:
        if (this.f11057v == false) goto L15;
        v();     // Catch: Throwable -> L25
    L15:
        g3 r11 = this.f11038c;     // Catch: Throwable -> L25
        if (r11 == null) goto L18;
        r11.d(this.f11057v);     // Catch: Throwable -> L25
        this.f11042g = this.f11038c.g();     // Catch: Throwable -> L25
    L18:
        c3 r12 = this.f11039d;     // Catch: Throwable -> L25
        if (r12 == null) goto L21;
        r12.j(true, x());     // Catch: Throwable -> L25
    L21:
        String r13 = p(r8);     // Catch: Throwable -> L25
        this.f11058w = r13;     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r13) == true) goto L27;
        this.f11059x = e(this.f11059x);     // Catch: Throwable -> L25
        goto L27
    }

    public final void o() {
        Context r8 = this.f11036a;
        if (o3.f10875e != null) goto L5;
        o3.f10875e = new o3(r8);
    L5:
        this.f11051p = o3.f10875e;
        u();
        if (this.f11037b != null) goto L9;
        this.f11037b = (ConnectivityManager) y3.d(this.f11036a, "connectivity");
    L9:
        if (this.f11048m != null) goto L12;
        this.f11048m = new r3();
        return;
    }

    public final String p(em r15) {
        String r8 = "";
        c3 r10 = this.f11039d;
        if (r10 != null) goto L5;
    L225:
        return "";
    L5:
        if (this.f11038c == null) goto L225;
        b3 r11 = r10.l();
        boolean r12 = false;
        if (r11 == null) goto L10;
        int r13 = r11.f10241l;
    L11:
        int r14 = r13 & 3;
        b3 r16 = this.f11039d.l();
        c3 r17 = this.f11039d;
        monitor-enter(r17);
    L222:
        th = move-exception;
        throw th;
    L14:
        if (r17.f10279o == true) goto L27;
        ArrayList<b3> r18 = r17.f10270f;     // Catch: Throwable -> L222
        if (r18.size() <= 0) goto L27;
        Iterator<b3> r19 = r18.iterator();     // Catch: Throwable -> L222
    L20:
        if (r19.hasNext() == false) goto L24;
        b3 r110 = r19.next();     // Catch: Throwable -> L222
        if (r110.f10242m == false) goto L20;
        b3 r20 = r110.c();     // Catch: Throwable -> L222
    L25:
        monitor-exit(r17);
    L29:
        ArrayList<n2> r21 = this.f11042g;
        if (r21 != null) goto L32;
    L35:
        boolean r22 = true;
    L37:
        if (r16 != null) goto L149;
        if (r20 != null) goto L149;
        if (r22 == false) goto L149;
        if (this.f11037b != null) goto L44;
        this.f11037b = (ConnectivityManager) y3.d(this.f11036a, "connectivity");
    L44:
        if (y3.w() < 31) goto L52;
        if (y3.h(this.f11036a) == false) goto L58;
        if (this.f11038c.f10468n == true) goto L58;
        this.f11061z = 18;
        this.f11052q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
        w3.a(2132, null);
        r15.f5204r = "#1802";
        return "";
    L58:
        if (y3.w() >= 28) goto L60;
    L66:
        Context r23 = this.f11036a;
        int r24 = r23.getApplicationInfo().targetSdkVersion;
        String[] r111 = M;
        if (r24 < 23) goto L77;
        Application r25 = (Application) r23;
        int r26 = 0;
    L69:
        if (r26 >= 2) goto L83;
        int r112 = ((Integer) l6.a.g(r25.getBaseContext(), "checkSelfPermission", new Object[]{r111[r26]})).intValue();     // Catch: Throwable -> L73
    L74:
        if (r112 != 0) goto L81;
        r26 = r26 + 1;
    L81:
        boolean r27 = false;
    L84:
        if (r27 == true) goto L88;
        this.f11061z = 12;
        this.f11052q.append("定位权限被禁用,请授予应用定位权限#1201");
        r15.f5204r = "#1201";
        w3.a(2121, null);
        return "";
    L88:
        if (y3.w() >= 24) goto L90;
    L95:
        String r28 = this.f11039d.f10283s;
        g3 r29 = this.f11038c;
        String r30 = r29.f10465k;
        if (r29.b(this.f11037b) == false) goto L100;
        if (r30 == null) goto L100;
        this.f11061z = 12;
        r15.f5204r = "#1202";
        this.f11052q.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
        w3.a(2121, null);
        return "";
    L100:
        if (r28 == null) goto L108;
        this.f11061z = 12;
        if (this.f11038c.f10467m == true) goto L104;
        r15.f5204r = "#1204";
        StringBuilder r113 = this.f11052q;
        String r114 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
    L105:
        r113.append(r114);
        w3.a(2121, null);
        return "";
    L104:
        r15.f5204r = "#1205";
        r113 = this.f11052q;
        r114 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
        goto L105
    L108:
        if (this.f11038c.f10467m == true) goto L135;
        c3 r31 = this.f11039d;
        r31.getClass();
        TelephonyManager r32 = r31.f10271g;     // Catch: Throwable -> L227
        if (r32 == null) goto L236;
        if (TextUtils.isEmpty(r32.getSimOperator()) == false) goto L131;
        if (TextUtils.isEmpty(r31.f10271g.getSimCountryIso()) == true) goto L236;
    L131:
        r12 = true;
    L132:
        if (r12 == true) goto L135;
        this.f11061z = 19;
        r15.f5204r = "#1901";
        this.f11052q.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
        w3.a(2133, null);
        return "";
    L236:
        NetworkInfo r33 = k4.o(r31.f10265a);     // Catch: Throwable -> L121
    L123:
        int r34 = y3.c(r33);     // Catch: Throwable -> L226
        if (r34 == 0) goto L131;
        if (r34 == 4) goto L131;
        if (r34 == 2) goto L131;
        if (r34 == 5) goto L131;
        if (r34 != 3) goto L132;
    L121:
        th = move-exception;
        t3.g("Utils", "getNetWorkInfo", th);     // Catch: Throwable -> L226
        r33 = null;
    L135:
        g3 r35 = this.f11038c;
        if (r35.f10467m == true) goto L138;
        r15.f5204r = "#1301";
        StringBuilder r115 = this.f11052q;
        String r36 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
    L147:
        r115.append(r36);
        this.f11061z = 13;
        w3.a(2131, null);
        return "";
    L138:
        r15.f5204r = "#1302";
        if (r35.e() == null) goto L143;
        this.f11052q.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
        if (y3.A(this.f11036a) == false) goto L145;
    L146:
        r115 = this.f11052q;
        r36 = "#1302";
    L145:
        this.f11052q.append("或后台运行没有后台定位权限");
        goto L146
    L143:
        this.f11052q.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
        if (y3.A(this.f11036a) == true) goto L146;
    L90:
        if (y3.w() >= 28) goto L95;
        if (Settings.Secure.getInt(this.f11036a.getContentResolver(), LocationMonitorConst.LOCATION_MODE, 0) != 0) goto L95;
        this.f11061z = 12;
        r15.f5204r = "#1206";
        this.f11052q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        w3.a(2121, null);
        return "";
    L73:
        r112 = 0;
    L83:
        r27 = true;
        goto L84
    L77:
        int r37 = 0;
    L78:
        if (r37 >= 2) goto L83;
        if (r23.checkCallingOrSelfPermission(r111[r37]) != 0) goto L81;
        r37 = r37 + 1;
        goto L78
    L60:
        if (this.J != null) goto L63;
        this.J = (LocationManager) this.f11036a.getApplicationContext().getSystemService(LocationMonitorConst.LOCATION);
    L63:
        if (((Boolean) l6.a.g(this.J, "isLocationEnabled", new Object[0])).booleanValue() == true) goto L66;
        this.f11061z = 12;
        this.f11052q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        r15.f5204r = "#1206";
        w3.a(2121, null);
        return "";
    L52:
        if (y3.h(this.f11036a) == false) goto L58;
        if (this.f11038c.f10467m == true) goto L58;
        this.f11061z = 18;
        this.f11052q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
        w3.a(2132, null);
        r15.f5204r = "#1801";
        return "";
    L149:
        boolean r38 = g3.c(this.f11038c.h());
        if (r14 == 0) goto L168;
        if (r14 == 1) goto L160;
        if (r14 == 2) goto L155;
        this.f11061z = 11;
        w3.a(2111, null);
        r15.f5204r = "#1101";
        this.f11052q.append("get cgi failure#1101");
    L212:
        if (TextUtils.isEmpty(r8) == false) goto L214;
        return r8;
    L214:
        if (r8.startsWith("#") == true) goto L216;
        r8 = "#".concat(r8);
    L216:
        StringBuilder r116 = new StringBuilder();
        String r117 = l4.d("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);     // Catch: Throwable -> L219
    L221:
        return android.aimedia.a.i(r116, r117, r8);
    L219:
        r117 = "";
        goto L221
    L155:
        if (r16 == null) goto L212;
        StringBuilder r118 = new StringBuilder();
        r118.append(r16.f10230a);
        r118.append("#");
        r118.append(r16.f10231b);
        r118.append("#");
        r118.append(r16.f10237h);
        r118.append("#");
        r118.append(r16.f10238i);
        r118.append("#");
        r118.append(r16.f10239j);
        r118.append("#network#");
        if (this.f11042g.isEmpty() == false) goto L166;
        if (r38 == true) goto L166;
    L165:
        String r119 = "cgi";
    L203:
        r118.append(r119);
        r8 = r118.toString();
    L166:
        r119 = "cgiwifi";
        goto L203
    L160:
        if (r16 == null) goto L212;
        r118 = new StringBuilder();
        r118.append(r16.f10230a);
        r118.append("#");
        r118.append(r16.f10231b);
        r118.append("#");
        r118.append(r16.f10232c);
        r118.append("#");
        r118.append(r16.f10233d);
        r118.append("#network#");
        if (this.f11042g.isEmpty() == false) goto L166;
        if (r38 == false) goto L165;
    L168:
        if (this.f11042g.isEmpty() == false) goto L172;
        if (r38 == true) goto L172;
        boolean r39 = false;
    L173:
        if (r20 == null) goto L175;
        boolean r40 = true;
    L177:
        if (r40 == false) goto L179;
    L194:
        String r41 = String.format(Locale.US, "#%s#", new Object[]{"network"});
        if (r40 == false) goto L204;
        r118 = new StringBuilder();
        r118.append(r20.a());
        if (this.f11042g.isEmpty() == false) goto L201;
        if (r38 == true) goto L201;
        r119 = "cgi";
    L202:
        r118.append("network#");
    L201:
        r119 = "cgiwifi";
        goto L202
    L204:
        if (r39 == false) goto L206;
        r8 = defpackage.a.e(r41, "wifi");
        goto L212
    L206:
        r8 = "";
        this.f11061z = 2;
        if (this.f11038c.f10467m == true) goto L209;
        r15.f5204r = "#0203";
        StringBuilder r120 = this.f11052q;
        String r121 = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
    L210:
        r120.append(r121);
        w3.a(2022, null);
        goto L212
    L209:
        r15.f5204r = "#0204";
        r120 = this.f11052q;
        r121 = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
        goto L210
    L179:
        if (r38 == false) goto L185;
        if (this.f11042g.isEmpty() == false) goto L185;
        this.f11061z = 2;
        r15.f5204r = "#0201";
        this.f11052q.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
        w3.a(2021, null);
        return "";
    L185:
        if (this.f11042g.size() != 1) goto L194;
        this.f11061z = 2;
        if (r38 == true) goto L191;
        r15.f5204r = "#0202";
        this.f11052q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
        w3.a(2022, null);
        return "";
    L191:
        if (this.f11042g.get(0).f10858h == false) goto L194;
        r15.f5204r = "#0202";
        this.f11052q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
        w3.a(2021, null);
        return "";
    L175:
        r40 = false;
    L172:
        r39 = true;
        goto L173
    L32:
        if (r21.isEmpty() == true) goto L35;
        r22 = false;
        goto L37
    L24:
        r20 = r18.get(0).c();     // Catch: Throwable -> L222
    L27:
        monitor-exit(r17);
        r20 = null;
        goto L29
    L10:
        r13 = 0;
        goto L11
    }

    public final void q() {
        if (this.B != null) goto L5;
        this.B = new z2(this.f11036a);
    L5:
        v();
        g3 r8 = this.f11038c;
        if (r8 == null) goto L8;
        r8.d(false);
        this.f11042g = this.f11038c.g();
    L8:
        c3 r10 = this.f11039d;
        if (r10 == null) goto L11;
        r10.j(false, x());
    L11:
        i3 r11 = this.f11040e;
        Context r12 = this.f11036a;
        if (r11.f10527c == false) goto L27;
    L19:
        Context r13 = this.f11036a;
        if (r13.checkCallingOrSelfPermission(t4.n("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) != 0) goto L29;
        this.f11049n = true;     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L30:
        return;
    L27:
        r11.k();     // Catch: Throwable -> L16
        r11.f(r12, null, false);     // Catch: Throwable -> L16
    L18:
        r11.f10527c = true;
    L16:
        th = move-exception;
        t3.g("Cache", "loadDB", th);
        goto L18
    }

    public final void r() {
        StringBuilder r8 = this.f11052q;
        if (r8.length() <= 0) goto L6;
        r8.delete(0, r8.length());
        return;
    }

    @SuppressLint({"NewApi"})
    public final void s() {
        this.E = null;
        this.f11060y = false;
        i3 r8 = this.f11040e;
        if (r8 == null) goto L9;
        Context r10 = this.f11036a;
        r8.k();     // Catch: Throwable -> L7
        r8.l(r10);     // Catch: Throwable -> L7
        r8.f10527c = false;     // Catch: Throwable -> L7
        r8.f10532h = null;     // Catch: Throwable -> L7
        r8.f10535k = 0;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        t3.g("Cache", "destroy part", th);
    L9:
        w2 r11 = this.D;
        if (r11 == null) goto L13;
        r11.b();
    L13:
        if (this.f11041f == null) goto L15;
        this.f11041f = null;
    L15:
        e3 r12 = this.G;
        if (r12 == null) goto L76;
        boolean r13 = this.H;
        e3.a r14 = r12.f10375g;
        if (r13 == true) goto L20;
        r14.run();
    L20:
        Handler r15 = r12.f10372d;
        if (r15 == null) goto L23;
        r15.removeCallbacks(r14);
    L23:
        r12.f10371c = true;
    L76:
        Context r16 = this.f11036a;     // Catch: Throwable -> L30
        if (r16 == null) goto L32;
        b r17 = this.f11043h;     // Catch: Throwable -> L30
        if (r17 == null) goto L32;
        r16.unregisterReceiver(r17);     // Catch: Throwable -> L30
    L32:
        this.f11043h = null;
        c3 r18 = this.f11039d;
        if (r18 == null) goto L54;
        boolean r19 = this.H;
        a3 r20 = r18.f10272h;
        y2.a r21 = r20.f11237g;
        Handler r22 = r20.f11234d;
        if (r22 == null) goto L37;
        r22.removeCallbacks(r21);
    L37:
        if (r19 == true) goto L39;
        r21.run();
    L39:
        r20.f11232b = false;
        r18.f10273i = 0;
        Object r23 = r18.f10276l;
        monitor-enter(r23);
        monitor-exit(r23);     // Catch: Throwable -> L51
        TelephonyManager r24 = r18.f10271g;
        if (r24 == null) goto L50;
        c3.b r25 = r18.f10274j;
        if (r25 == null) goto L50;
        r24.listen(r25, 0);     // Catch: Throwable -> L48
        r18.f10286v = false;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        t3.g("CgiManager", "destroy", th);
    L50:
        r18.f10274j = null;
        r18.f10275k = null;
        r18.f10271g = null;
    L51:
        th = move-exception;
        throw th;
    L54:
        g3 r26 = this.f11038c;
        if (r26 == null) goto L62;
        boolean r27 = this.H;
        r26.f10464j = null;
        r26.f10456b.clear();
        r26.f10456b.clear();
        a3 r28 = r26.f10470p;
        y2.a r29 = r28.f11237g;
        Handler r30 = r28.f11234d;
        if (r30 == null) goto L59;
        r30.removeCallbacks(r29);
    L59:
        if (r27 == true) goto L61;
        r29.run();
    L61:
        r28.f11232b = false;
    L62:
        ArrayList<n2> r31 = this.f11042g;
        if (r31 == null) goto L65;
        r31.clear();
    L65:
        z2 r32 = this.B;
        if (r32 != null) goto L78;
    L71:
        this.f11045j = null;
        this.f11036a = null;
        this.f11059x = null;
        this.J = null;
        return;
    L78:
        r32.b();     // Catch: Throwable -> L69
        r32.f11251b = null;     // Catch: Throwable -> L69
        r32.f11252c = null;     // Catch: Throwable -> L69
        r32.f11250a = null;     // Catch: Throwable -> L69
        r32.f11253d = null;     // Catch: Throwable -> L69
        r32.f11254e = false;     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        t3.g("AMapSensorManager", "destroy", th);
    L30:
        th = move-exception;
        t3.g("Aps", "destroy", th);     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        this.f11043h = null;
        throw th;
    }

    public final void t() {
        u2 r8 = this.L;
        if (r8 != null) goto L5;
        return;
    L5:
        if (y3.F(r8.f11137a) == true) goto L26;
        u2.a r10 = r8.f11144h;     // Catch: Throwable -> L19
        if (r10 == null) goto L12;
        LocationManager r11 = r8.f11143g;     // Catch: Throwable -> L19
        if (r11 == null) goto L12;
        r11.removeUpdates(r10);     // Catch: Throwable -> L19
    L12:
        u2.a r12 = r8.f11144h;     // Catch: Throwable -> L19
        if (r12 == null) goto L16;
        r12.f11147a = null;     // Catch: Throwable -> L19
    L16:
        if (r8.f11146j == false) goto L25;
        r8.f();     // Catch: Throwable -> L19
        r8.f11140d.f10475u = null;     // Catch: Throwable -> L19
        r8.f11141e.f10287w = null;     // Catch: Throwable -> L19
        r8.f11141e = null;     // Catch: Throwable -> L19
        r8.f11140d = null;     // Catch: Throwable -> L19
        r8.f11139c = null;     // Catch: Throwable -> L19
        r8.f11146j = false;     // Catch: Throwable -> L19
        return;
    L25:
        return;
    L19:
        th = move-exception;
        t3.g("clm", "stc", th);
        return;
    }

    public final void u() {
        if (this.f11051p == null) goto L33;
        if (this.f11044i != null) goto L7;
        this.f11044i = new AMapLocationClientOption();     // Catch: Throwable -> L28
    L7:
        AMapLocationClientOption.e r8 = this.f11044i.B;     // Catch: Throwable -> L28
        boolean r10 = true;
        if (r8 == null) goto L17;
        int r11 = a.f11062a[r8.ordinal()];     // Catch: Throwable -> L28
        if (r11 == 1) goto L17;
        int r12 = 2;
        if (r11 != 2) goto L14;
        r12 = 1;
    L18:
        o3 r13 = this.f11051p;     // Catch: Throwable -> L28
        AMapLocationClientOption r14 = this.f11044i;     // Catch: Throwable -> L28
        long r15 = r14.f3651b;     // Catch: Throwable -> L28
        r14.getClass();     // Catch: Throwable -> L28
        if (AMapLocationClientOption.L.equals(AMapLocationClientOption.c.f3671b) == true) goto L22;
        r10 = false;
    L22:
        r13.getClass();     // Catch: Throwable -> L28
        r13.f10878c = r10;     // Catch: Throwable -> L25
        r13.f10877b = Long.valueOf(r15).intValue();     // Catch: Throwable -> L25
        r13.f10879d = r12;     // Catch: Throwable -> L25
        goto L35
    L34:
        return;
    L25:
        th = move-exception;
        t3.g("LocNetManager", "setOption", th);     // Catch: Throwable -> L28
        return;
    L14:
        if (r11 == 3) goto L18;
    L17:
        r12 = 0;
    L35:
        return;
    }

    public final void v() {
    L10:
        th = move-exception;
        t3.g("Aps", "initBroadcastListener", th);
        return;
    L3:
        if (this.f11043h != null) goto L6;
        this.f11043h = new b(this);     // Catch: Throwable -> L10
    L6:
        if (this.I != null) goto L8;
        IntentFilter r8 = new IntentFilter();     // Catch: Throwable -> L10
        this.I = r8;     // Catch: Throwable -> L10
        r8.addAction("android.net.wifi.WIFI_STATE_CHANGED");     // Catch: Throwable -> L10
        this.I.addAction("android.net.wifi.SCAN_RESULTS");     // Catch: Throwable -> L10
        this.I.addAction("android.net.wifi.STATE_CHANGE");     // Catch: Throwable -> L10
    L8:
        this.f11036a.registerReceiver(this.f11043h, this.I);     // Catch: Throwable -> L10
    }

    public final byte[] w() {
        if (this.f11048m != null) goto L6;
        this.f11048m = new r3();
    L6:
        if (this.f11044i != null) goto L8;
        this.f11044i = new AMapLocationClientOption();
    L8:
        c3 r8 = this.f11039d;
        if (r8 == null) goto L13;
        g3 r10 = this.f11038c;
        if (r10 == null) goto L13;
        r3 r11 = this.f11048m;
        Context r12 = this.f11036a;
        AMapLocationClientOption r13 = this.f11044i;
        r11.b(r12, r13.f3654o, r13.f3660u, r8, r10, this.f11037b, this.E, this.G);
    L13:
        r3 r14 = this.f11048m;
        r14.e();
        int r15 = 2;
        byte[] r16 = new byte[2];
        byte[] r17 = new byte[4];
        byte[] r18 = r14.C;
        int r19 = 1;
        int r20 = 4096;
        if (r18 == null) goto L16;
        r20 = 4096 + (r18.length + 1);
    L16:
        byte[] r21 = r14.D;
        if (r21 != null) goto L19;
    L20:
        r21 = new byte[r20];
        r14.D = r21;
        r14.E = r20;
    L21:
        byte[] r22 = r21;
        int r23 = 0;
        r22[0] = y3.B();
        byte[] r110 = null;
        byte[] r24 = y3.o(r14.f10977a, null);
        System.arraycopy(r24, 0, r22, 1, r24.length);
        int r111 = r3.a(r14.f10991o, r22, r3.a(r14.f10990n, r22, r3.a(r14.f10982f, r22, r3.a(r14.f10994r, r22, r3.a(r14.f10981e, r22, r3.a(r14.f10980d, r22, r3.a(null, r22, r3.a(r14.f10989m, r22, r3.a(r14.f10979c, r22, r3.a(r14.f10978b, r22, r24.length + 1))))))))));
    L27:
        th = move-exception;
        t3.g("Req", "buildV4Dot219", th);
        r22[r111] = 0;
    L29:
        int r112 = r111 + 1;
    L30:
        int r25 = r3.a(r14.f10996t, r22, r3.a(r3.M, r22, r3.a(r3.L, r22, r3.a(null, r22, r3.a(r14.f10995s, r22, r112)))));
        r22[r25] = Byte.parseByte(r14.f10997u);
        int r26 = r25 + 1;
        r22[r26] = Byte.parseByte(r14.f10984h);
        int r27 = r26 + 1;
        int r113 = r14.f10998v;
        int r114 = r113 & 3;
        r22[r27] = (byte) r113;
        int r28 = r27 + 1;
        long r115 = 0;
        if (r114 == 1) goto L36;
        if (r114 == 2) goto L36;
        r17 = r17;
    L35:
        byte[] r116 = r22;
    L139:
        String r29 = r14.f11001y;
        if (r29 != null) goto L142;
    L145:
        r116[r28] = 0;
        int r30 = r28 + 1;
    L146:
        ArrayList<b3> r31 = r14.f11000x;
        int r32 = r31.size();
        if ((r14.f10998v & 4) != 4) goto L211;
        if (r32 <= 0) goto L211;
        r31.get(0);
        r116[r30] = (byte) r32;
        int r117 = 1;
        int r33 = r30 + 1;
        int r118 = 0;
    L150:
        if (r118 >= r32) goto L210;
        b3 r119 = r31.get(r118);
        int r34 = r119.f10241l;
        boolean r120 = r119.f10242m;
        if (r34 == r117) goto L169;
        if (r34 == 3) goto L169;
        if (r34 == 4) goto L169;
        if (r34 != r15) goto L162;
        byte r35 = (byte) r34;
        if (r120 == false) goto L161;
        r35 = (byte) (r35 | 8);
    L161:
        r116[r33] = r35;
        int r36 = r33 + 1;
        byte[] r37 = y3.o(r119.f10230a, r16);
        System.arraycopy(r37, r23, r116, r36, r37.length);
        int r38 = r36 + r37.length;
        byte[] r39 = y3.o(r119.f10237h, r16);
        System.arraycopy(r39, r23, r116, r38, r39.length);
        int r40 = r38 + r39.length;
        byte[] r41 = y3.o(r119.f10238i, r16);
        System.arraycopy(r41, r23, r116, r40, r41.length);
        int r42 = r40 + r41.length;
        byte[] r43 = y3.o(r119.f10239j, r16);
        System.arraycopy(r43, r23, r116, r42, r43.length);
        int r44 = r42 + r43.length;
        byte[] r121 = r17;
        byte[] r45 = y3.v(r119.f10236g, r121);
        System.arraycopy(r45, r23, r116, r44, r45.length);
        int r46 = r44 + r45.length;
        byte[] r47 = y3.v(r119.f10235f, r121);
        System.arraycopy(r47, r23, r116, r46, r47.length);
        r33 = r46 + r47.length;
    L173:
        int r48 = r119.f10240k;
        if (r48 <= 127) goto L177;
    L178:
        r48 = 99;
    L179:
        r116[r33] = (byte) r48;
        int r49 = r33 + 1;
        byte[] r210 = r116;
        byte[] r50 = y3.o((short) ((SystemClock.elapsedRealtime() - r119.f10248s) / 1000), r16);
        System.arraycopy(r50, 0, r210, r49, r50.length);
        r33 = r49 + r50.length;
        int r51 = QesdkUtils.LIMITS.INT_16_UPPER;
        int r52 = r119.f10241l;
        if (r52 == 3) goto L198;
        if (r52 == 4) goto L198;
        if (r52 == 5) goto L198;
        if (r52 != 1) goto L209;
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.3d) goto L209;
        int r53 = r119.f10243n;
        if (r53 <= 32767) goto L193;
        r53 = 32767;
    L193:
        if (r53 < 0) goto L196;
        r51 = r53;
    L196:
        byte[] r54 = y3.o(r51, r16);
        System.arraycopy(r54, 0, r210, r33, r54.length);
        int r55 = r33 + r54.length;
        byte[] r56 = y3.v(r119.f10244o, r121);
        System.arraycopy(r56, 0, r210, r55, r56.length);
        int r57 = r55 + r56.length;
        byte[] r58 = y3.v(r119.f10245p, r121);
        System.arraycopy(r58, 0, r210, r57, r58.length);
        int r59 = r58.length;
    L208:
        r33 = r57 + r59;
    L209:
        r118 = r118 + 1;
        r31 = r31;
        r116 = r210;
        r17 = r121;
        r15 = 2;
        r23 = 0;
        r117 = 1;
    L198:
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.0d) goto L209;
        int r60 = r119.f10243n;
        if (r60 <= 32767) goto L202;
        r60 = 32767;
    L202:
        if (r60 < 0) goto L205;
        r51 = r60;
    L205:
        byte[] r61 = y3.o(r51, r16);
        System.arraycopy(r61, 0, r210, r33, r61.length);
        r33 = r33 + r61.length;
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.3d) goto L209;
        byte[] r62 = y3.v(r119.f10244o, r121);
        System.arraycopy(r62, 0, r210, r33, r62.length);
        r57 = r33 + r62.length;
        byte[] r63 = y3.v(r119.f10245p, r121);
        System.arraycopy(r63, 0, r210, r57, r63.length);
        r59 = r63.length;
        goto L208
    L177:
        if (r48 >= (-128)) goto L179;
    L162:
        r121 = r17;
        if (r34 != 5) goto L173;
        byte r64 = (byte) r34;
        if (r120 == false) goto L167;
        r64 = (byte) (r64 | 8);
    L167:
        r116[r33] = r64;
        int r65 = r33 + 1;
        byte[] r66 = y3.o(r119.f10230a, r16);
        System.arraycopy(r66, r23, r116, r65, r66.length);
        int r67 = r65 + r66.length;
        byte[] r68 = y3.o(r119.f10231b, r16);
        System.arraycopy(r68, r23, r116, r67, r68.length);
        int r69 = r67 + r68.length;
        byte[] r70 = y3.o(r119.f10232c, r16);
        System.arraycopy(r70, r23, r116, r69, r70.length);
        int r71 = r69 + r70.length;
        System.arraycopy(y3.p(r119.f10234e), r23, r116, r71, 8);
        r33 = r71 + 8;
    L169:
        r121 = r17;
        byte r72 = (byte) r34;
        if (r120 == false) goto L172;
        r72 = (byte) (r72 | 8);
    L172:
        r116[r33] = r72;
        int r73 = r33 + 1;
        byte[] r74 = y3.o(r119.f10230a, r16);
        System.arraycopy(r74, r23, r116, r73, r74.length);
        int r75 = r73 + r74.length;
        byte[] r76 = y3.o(r119.f10231b, r16);
        System.arraycopy(r76, r23, r116, r75, r76.length);
        int r77 = r75 + r76.length;
        byte[] r78 = y3.o(r119.f10232c, r16);
        System.arraycopy(r78, r23, r116, r77, r78.length);
        int r79 = r77 + r78.length;
        byte[] r80 = y3.v(r119.f10233d, r121);
        System.arraycopy(r80, r23, r116, r79, r80.length);
        r33 = r79 + r80.length;
        goto L173
    L210:
        byte[] r81 = r116;
        byte[] r122 = r17;
        byte r82 = 1;
    L213:
        if (TextUtils.isEmpty(r14.f11002z) == false) goto L215;
    L240:
        byte r83 = r82;
        byte r84 = 0;
        r81[r33] = 0;
        int r85 = r33 + 1;
    L241:
        ArrayList<n2> r86 = r14.A;
        int r87 = Math.min(r86.size(), 25);
        if (r87 != 0) goto L244;
        r81[r85] = r84;
        int r88 = r85 + r83;
        byte r123 = 0;
    L270:
        r81[r88] = r123;
        int r89 = r88 + 1;
        r81[r89] = r123;     // Catch: Throwable -> L273
    L274:
        int r90 = r89 + 1;
        byte[] r91 = {0, 0};
        boolean r92 = TextUtils.isEmpty(r14.F);     // Catch: Throwable -> L286
        if (r92 == true) goto L401;
        r91 = y3.o(r14.F.length(), r16);     // Catch: Throwable -> L286
    L401:
        System.arraycopy(r91, 0, r81, r90, 2);     // Catch: Throwable -> L285
        int r93 = r90 + 2;
        if (r92 == false) goto L397;
    L284:
        int r94 = 2;
    L411:
        System.arraycopy(y3.o(0, r16), 0, r81, r93, r94);     // Catch: Throwable -> L385
    L290:
        int r95 = r93 + r94;
        byte[] r96 = new byte[r94];
        r96 = {x08da: FILL_ARRAY_DATA , data: [0, 0} // fill-array;
        System.arraycopy(r96, 0, r81, r95, r94);     // Catch: Throwable -> L386
    L292:
        int r97 = r95 + r94;
        byte[] r98 = r14.C;
        if (r98 == null) goto L295;
        int r99 = r98.length;
    L296:
        byte[] r100 = y3.o(r99, null);
        System.arraycopy(r100, 0, r81, r97, r100.length);
        int r101 = r97 + r100.length;
        if (r99 <= 0) goto L300;
        byte[] r102 = r14.C;
        System.arraycopy(r102, 0, r81, r101, r102.length);
        r101 = r101 + r14.C.length;
    L300:
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.0d) goto L362;
        List<b3> r103 = r14.K;
        if (r103 == null) goto L304;
        int r104 = r103.size();
    L305:
        r81[r101] = (byte) r104;
        int r105 = r101 + 1;
        byte[] r106 = new byte[r105];
        System.arraycopy(r81, 0, r106, 0, r105);
        if (r104 > 0) goto L399;
    L360:
        r101 = r3.a(r14.G, r81, r105);
        goto L362
    L399:
        Iterator<b3> r107 = r103.iterator();     // Catch: Throwable -> L358
        int r108 = r105;
    L308:
        if (r107.hasNext() == false) goto L357;
        b3 r109 = r107.next();     // Catch: Throwable -> L358
        int r124 = r109.f10241l;     // Catch: Throwable -> L358
        boolean r125 = r109.f10242m;
        if (r124 != 1) goto L314;
    L340:
        byte r126 = (byte) r124;     // Catch: Throwable -> L358
        if (r125 == false) goto L343;
        r126 = (byte) (r126 | 8);     // Catch: Throwable -> L358
    L343:
        r81[r108] = r126;     // Catch: Throwable -> L358
        int r127 = r108 + 1;     // Catch: Throwable -> L358
        byte[] r128 = y3.o(r109.f10232c, r16);     // Catch: Throwable -> L358
        byte r129 = 0;
        System.arraycopy(r128, 0, r81, r127, r128.length);     // Catch: Throwable -> L356
        int r130 = r127 + r128.length;     // Catch: Throwable -> L358
        byte[] r131 = y3.v(r109.f10233d, r122);     // Catch: Throwable -> L358
        r129 = 0;
        System.arraycopy(r131, 0, r81, r130, r131.length);     // Catch: Throwable -> L356
        r108 = r130 + r131.length;     // Catch: Throwable -> L358
    L350:
        byte[] r132 = y3.o((short) ((SystemClock.elapsedRealtime() - r109.f10248s) / 1000), r16);     // Catch: Throwable -> L358
        System.arraycopy(r132, 0, r81, r108, r132.length);     // Catch: Throwable -> L355
        r108 = r108 + r132.length;
    L355:
        byte r133 = 0;
    L359:
        System.arraycopy(r106, r133, r81, r133, r105);
        r81[r105 - 1] = r133;
    L356:
        r133 = r129;
        goto L359
    L314:
        if (r124 == 3) goto L340;
        if (r124 == 4) goto L340;
        if (r124 != 2) goto L335;
        byte r134 = (byte) r124;
        if (r125 == false) goto L323;
        r134 = (byte) (r134 | 8);
    L323:
        r81[r108] = r134;     // Catch: Throwable -> L358
        int r135 = r108 + 1;     // Catch: Throwable -> L358
        byte[] r136 = y3.o(r109.f10237h, r16);     // Catch: Throwable -> L358
        byte r137 = 0;
        System.arraycopy(r136, 0, r81, r135, r136.length);     // Catch: Throwable -> L333
        int r138 = r135 + r136.length;     // Catch: Throwable -> L358
        byte[] r139 = y3.o(r109.f10238i, r16);     // Catch: Throwable -> L358
        System.arraycopy(r139, 0, r81, r138, r139.length);     // Catch: Throwable -> L333
        int r140 = r138 + r139.length;     // Catch: Throwable -> L358
        byte[] r141 = y3.o(r109.f10239j, r16);     // Catch: Throwable -> L358
        r137 = 0;
        System.arraycopy(r141, 0, r81, r140, r141.length);     // Catch: Throwable -> L333
        r108 = r140 + r141.length;     // Catch: Throwable -> L358
    L333:
        r133 = r137;
        goto L359
    L335:
        if (r124 != 5) goto L350;
        byte r142 = (byte) r124;     // Catch: Throwable -> L358
        if (r125 == false) goto L339;
        r142 = (byte) (r142 | 8);     // Catch: Throwable -> L358
    L339:
        r81[r108] = r142;     // Catch: Throwable -> L358
        int r143 = r108 + 1;     // Catch: Throwable -> L358
        byte[] r144 = y3.o(r109.f10232c, r16);     // Catch: Throwable -> L358
        System.arraycopy(r144, 0, r81, r143, r144.length);     // Catch: Throwable -> L358
        int r145 = r143 + r144.length;     // Catch: Throwable -> L358
        System.arraycopy(y3.p(r109.f10234e), 0, r81, r145, 8);     // Catch: Throwable -> L358
        r108 = r145 + 8;     // Catch: Throwable -> L358
        goto L350
    L357:
        r105 = r108;
    L358:
        r133 = 0;
        goto L359
    L304:
        r104 = 0;
    L362:
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.2d) goto L380;
        ArrayList r146 = r14.J;
        if (r146 != null) goto L366;
        int r147 = 0;
    L367:
        r81[r101] = (byte) r147;
        r101 = r101 + 1;
        if (r147 <= 0) goto L380;
        Iterator r148 = r14.J.iterator();
    L371:
        if (r148.hasNext() == false) goto L380;
        d3 r149 = (d3) r148.next();
        int r150 = ((int) (System.currentTimeMillis() - r149.f10303d)) / 1000;
        if (r150 <= 65535) goto L375;
        r150 = 65535;
    L375:
        System.arraycopy(y3.o(r150, r16), 0, r81, r101, 2);
        int r151 = r101 + 2;
        System.arraycopy(y3.v((int) Math.round(r149.f10302c * 1.0E7d), r122), 0, r81, r151, 4);
        int r152 = r151 + 4;
        System.arraycopy(y3.v((int) Math.round(r149.f10301b * 1.0E7d), r122), 0, r81, r152, 4);
        int r153 = r152 + 4;
        float r154 = r149.f10304e;
        if (r154 <= 65535.0f) goto L378;
        r154 = 65535.0f;
    L378:
        System.arraycopy(y3.o((int) r154, r16), 0, r81, r153, 2);
        int r155 = r153 + 2;
        System.arraycopy(y3.o((short) ((r149.f10306g | ((r149.f10300a << 13) | (r149.f10305f << 6))) & 65535), r16), 0, r81, r155, 2);
        r101 = r155 + 2;
        goto L371
    L366:
        r147 = r146.size();
    L380:
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.3d) goto L382;
        r101 = r3.a(r14.H, r81, r101);
    L382:
        byte[] r156 = new byte[r101];
        System.arraycopy(r81, 0, r156, 0, r101);
        CRC32 r157 = new CRC32();
        r157.update(r156);
        byte[] r158 = y3.p(r157.getValue());
        byte[] r159 = new byte[r101 + 8];
        System.arraycopy(r156, 0, r159, 0, r101);
        System.arraycopy(r158, 0, r159, r101, 8);
        return r159;
    L295:
        r99 = 0;
        goto L296
    L397:
        byte[] r160 = r14.F.getBytes("GBK");     // Catch: Throwable -> L384
        System.arraycopy(r160, 0, r81, r93, r160.length);     // Catch: Throwable -> L384
        r93 = r93 + r160.length;
    L285:
        r94 = 2;
    L287:
        r93 = r90 + r94;
    L286:
        r94 = 2;
    L273:
        r81[r89] = r123;
        goto L274
    L244:
        r81[r85] = (byte) r87;
        int r161 = r85 + r83;
        if (y3.w() < 17) goto L247;
        boolean r162 = true;
    L248:
        if (r162 == false) goto L250;
        r115 = SystemClock.elapsedRealtime() / 1000;
    L250:
        int r163 = 0;
    L251:
        if (r163 >= r87) goto L269;
        n2 r164 = r86.get(r163);
        byte[] r165 = r3.d(n2.b(r164.f10851a));
        System.arraycopy(r165, 0, r81, r161, r165.length);
        int r166 = r161 + r165.length;
        byte[] r167 = r164.f10852b.getBytes("GBK");     // Catch: Exception -> L255
        r81[r166] = (byte) r167.length;     // Catch: Exception -> L255
        r166 = r166 + 1;     // Catch: Exception -> L255
        System.arraycopy(r167, 0, r81, r166, r167.length);     // Catch: Exception -> L255
        int r168 = r166 + r167.length;
    L256:
        int r169 = r164.f10853c;
        if (r169 > 127) goto L260;
        if (r169 < (-128)) goto L260;
    L261:
        r81[r168] = Byte.parseByte(String.valueOf(r169));
        int r170 = r168 + 1;
        if (r162 == false) goto L265;
        int r171 = (int) (r115 - (r164.f10856f / 1000));
        if (r171 < 0) goto L265;
    L266:
        if (r171 <= 65535) goto L268;
        r171 = 65535;
    L268:
        byte[] r172 = y3.o(r171, r16);
        System.arraycopy(r172, 0, r81, r170, r172.length);
        int r173 = r170 + r172.length;
        byte[] r174 = y3.o(r164.f10854d, r16);
        System.arraycopy(r174, 0, r81, r173, r174.length);
        r161 = r173 + r174.length;
        r163 = r163 + 1;
    L265:
        r171 = 0;
    L260:
        r169 = 0;
    L255:
        r81[r166] = 0;
        r168 = r166 + 1;
        goto L256
    L269:
        r123 = 0;
        byte[] r175 = y3.o(Integer.parseInt(r14.B), r16);
        System.arraycopy(r175, 0, r81, r161, r175.length);
        r88 = r161 + r175.length;
        goto L270
    L247:
        r162 = false;
        goto L248
    L215:
        if (r14.f11002z.length() == 0) goto L240;
        r81[r33] = r82;
        r85 = r33 + 1;
        String[] r176 = r14.f11002z.split(",");     // Catch: Throwable -> L238
        byte[] r177 = r3.d(r176[0]);     // Catch: Throwable -> L238
        System.arraycopy(r177, 0, r81, r85, r177.length);     // Catch: Throwable -> L238
        r85 = r85 + r177.length;
        byte[] r178 = r176[2].getBytes("GBK");     // Catch: Throwable -> L225
        int r179 = r178.length;     // Catch: Throwable -> L225
        if (r179 <= 127) goto L223;
        r179 = QesdkUtils.LIMITS.INT_8_UPPER;
    L223:
        r81[r85] = (byte) r179;     // Catch: Throwable -> L225
        r85 = r85 + 1;     // Catch: Throwable -> L225
        System.arraycopy(r178, 0, r81, r85, r179);     // Catch: Throwable -> L225
        int r180 = r85 + r179;
    L227:
        int r181 = Integer.parseInt(r176[1]);     // Catch: Throwable -> L238
        if (r181 <= 127) goto L231;
    L232:
        r181 = 0;
    L233:
        r81[r180] = Byte.parseByte(String.valueOf(r181));     // Catch: Throwable -> L238
        r85 = r180 + 1;     // Catch: Throwable -> L238
        if (Double.valueOf(t3.f11114a).doubleValue() < 5.2d) goto L237;
        byte[] r182 = y3.o(r14.I, r16);     // Catch: Throwable -> L238
        System.arraycopy(r182, 0, r81, r85, r182.length);     // Catch: Throwable -> L238
        r85 = r85 + r182.length;
    L237:
        r83 = 1;
        r84 = 0;
        goto L241
    L231:
        if (r181 >= (-128)) goto L233;
    L225:
        th = move-exception;
        t3.g("Req", "buildV4Dot214", th);     // Catch: Throwable -> L238
        r81[r85] = 0;     // Catch: Throwable -> L238
        r180 = r85 + 1;     // Catch: Throwable -> L238
    L238:
        th = move-exception;
        t3.g("Req", "buildV4Dot216", th);
        byte[] r183 = r3.d("00:00:00:00:00:00");
        r84 = 0;
        System.arraycopy(r183, 0, r81, r85, r183.length);
        int r184 = r85 + r183.length;
        r81[r184] = 0;
        r83 = 1;
        int r185 = r184 + 1;
        r81[r185] = Byte.parseByte("0");
        r85 = r185 + 1;
    L211:
        r81 = r116;
        r122 = r17;
        r81[r30] = 0;
        r82 = 1;
        r33 = r30 + 1;
        goto L213
    L142:
        if ((r14.f10998v & 8) != 8) goto L145;
        byte[] r186 = r29.getBytes("GBK");     // Catch: Exception -> L387
        int r187 = Math.min(r186.length, 60);     // Catch: Exception -> L387
        r116[r28] = (byte) r187;     // Catch: Exception -> L387
        r28 = r28 + 1;     // Catch: Exception -> L387
        System.arraycopy(r186, 0, r116, r28, r187);     // Catch: Exception -> L387
        r30 = r28 + r187;
    L36:
        ArrayList<b3> r188 = r14.f10999w;
        if (r188.size() <= 0) goto L39;
        int r189 = r188.get(0).f10230a;
    L40:
        byte[] r190 = y3.o(r189, null);
        System.arraycopy(r190, 0, r22, r28, r190.length);
        int r191 = r28 + r190.length;
        if (r114 == 1) goto L43;
        if (r114 == 2) goto L57;
    L79:
        if (r188.size() <= 0) goto L81;
        int r192 = r188.get(0).f10240k;
    L82:
        if (r192 > 127) goto L85;
        if (r192 < (-128)) goto L85;
    L86:
        r22[r191] = (byte) r192;
        int r193 = r191 + 1;
        if (r188.size() <= 0) goto L89;
        long r194 = (SystemClock.elapsedRealtime() - r188.get(0).f10248s) / 1000;
    L91:
        if (r194 <= 65535) goto L94;
        r194 = 65535;
    L94:
        if (r194 >= 0) goto L96;
        r194 = 0;
    L96:
        byte[] r195 = y3.o((int) r194, r16);
        System.arraycopy(r195, 0, r22, r193, r195.length);
        r28 = r193 + 2;
        if (r114 == 1) goto L99;
        r116 = r22;
        if (r114 != 2) goto L139;
        r116[r28] = 0;
        r28 = r28 + 1;
        goto L139
    L99:
        if (r188.size() != 0) goto L101;
        r22[r28] = 0;
        r28 = r28 + 1;
        goto L35
    L101:
        int r196 = r188.size();
        r22[r28] = (byte) r196;
        r28 = r28 + 1;
        int r197 = 0;
    L102:
        if (r197 >= r196) goto L35;
        if (r188.size() <= 0) goto L106;
        int r198 = r188.get(r197).f10232c;
    L107:
        byte[] r199 = y3.o(r198, r110);
        System.arraycopy(r199, 0, r22, r28, r199.length);
        int r200 = r28 + r199.length;
        if (r188.size() <= 0) goto L110;
        int r1100 = r188.get(r197).f10233d;
    L111:
        byte[] r1101 = y3.v(r1100, r110);
        System.arraycopy(r1101, 0, r22, r200, r1101.length);
        int r201 = r200 + r1101.length;
        if (r188.size() <= 0) goto L114;
        int r1102 = r188.get(r197).f10240k;
    L116:
        if (r1102 <= 127) goto L119;
    L120:
        r1102 = 0;
    L121:
        r22[r201] = (byte) r1102;
        r28 = r201 + r19;
        if (Double.valueOf(t3.f11114a).doubleValue() >= 5.2d) goto L124;
        byte[] r1103 = r22;
    L135:
        r197 = r197 + 1;
        r22 = r1103;
        r19 = 1;
        r110 = null;
        goto L102
    L124:
        if (r188.size() <= 0) goto L126;
        long r1104 = (SystemClock.elapsedRealtime() - r188.get(0).f10248s) / 1000;
    L128:
        if (r1104 <= 65535) goto L131;
        r1104 = 65535;
    L131:
        if (r1104 >= 0) goto L133;
        r1104 = 0;
    L133:
        byte[] r202 = y3.o((int) r1104, r16);
        r1103 = r22;
        System.arraycopy(r202, 0, r1103, r28, r202.length);
        r28 = r28 + r202.length;
        goto L135
    L126:
        r1104 = 0;
        goto L128
    L119:
        if (r1102 >= (-128)) goto L121;
    L114:
        r1102 = 0;
        goto L116
    L110:
        r1100 = 0;
        goto L111
    L106:
        r198 = 0;
        goto L107
    L89:
        r194 = 0;
    L85:
        r192 = 0;
        goto L86
    L81:
        r192 = 0;
        goto L82
    L57:
        if (r188.size() <= 0) goto L59;
        int r1105 = r188.get(0).f10237h;
    L60:
        byte[] r1106 = y3.o(r1105, null);
        System.arraycopy(r1106, 0, r22, r191, r1106.length);
        int r203 = r191 + r1106.length;
        if (r188.size() <= 0) goto L63;
        int r1107 = r188.get(0).f10238i;
    L64:
        byte[] r1108 = y3.o(r1107, null);
        System.arraycopy(r1108, 0, r22, r203, r1108.length);
        int r204 = r203 + r1108.length;
        if (r188.size() <= 0) goto L67;
        int r1109 = r188.get(0).f10239j;
    L68:
        byte[] r1110 = y3.o(r1109, null);
        System.arraycopy(r1110, 0, r22, r204, r1110.length);
        int r205 = r204 + r1110.length;
        if (r188.size() <= 0) goto L71;
        int r1111 = r188.get(0).f10236g;
    L72:
        byte[] r1112 = y3.v(r1111, null);
        System.arraycopy(r1112, 0, r22, r205, r1112.length);
        int r206 = r205 + r1112.length;
        if (r188.size() <= 0) goto L75;
        int r1113 = r188.get(0).f10235f;
    L76:
        byte[] r1114 = y3.v(r1113, null);
        System.arraycopy(r1114, 0, r22, r206, r1114.length);
        int r1115 = r1114.length;
    L77:
        r191 = r206 + r1115;
        goto L79
    L75:
        r1113 = 0;
        goto L76
    L71:
        r1111 = 0;
        goto L72
    L67:
        r1109 = 0;
        goto L68
    L63:
        r1107 = 0;
        goto L64
    L59:
        r1105 = 0;
        goto L60
    L43:
        if (r188.size() <= 0) goto L45;
        int r1116 = r188.get(0).f10231b;
    L46:
        byte[] r1117 = y3.o(r1116, null);
        System.arraycopy(r1117, 0, r22, r191, r1117.length);
        int r207 = r191 + r1117.length;
        if (r188.size() <= 0) goto L49;
        int r1118 = r188.get(0).f10232c;
    L50:
        byte[] r1119 = y3.o(r1118, null);
        System.arraycopy(r1119, 0, r22, r207, r1119.length);
        r206 = r207 + r1119.length;
        if (r188.size() <= 0) goto L53;
        int r1120 = r188.get(0).f10233d;
    L54:
        byte[] r1121 = y3.v(r1120, null);
        System.arraycopy(r1121, 0, r22, r206, r1121.length);
        r1115 = r1121.length;
        goto L77
    L53:
        r1120 = 0;
        goto L54
    L49:
        r1118 = 0;
        goto L50
    L45:
        r1116 = 0;
        goto L46
    L39:
        r189 = 0;
        goto L40
    L23:
        if (TextUtils.isEmpty(r14.f10993q) == false) goto L25;
        r22[r111] = 0;     // Catch: Throwable -> L27
        goto L29
    L25:
        byte[] r208 = r3.d(r14.f10993q);     // Catch: Throwable -> L27
        r22[r111] = (byte) r208.length;     // Catch: Throwable -> L27
        int r1122 = r111 + 1;     // Catch: Throwable -> L27
        System.arraycopy(r208, 0, r22, r1122, r208.length);     // Catch: Throwable -> L27
        r112 = r1122 + r208.length;
        goto L30
    L19:
        if (r20 <= r14.E) goto L21;
        goto L20
    }

    public final boolean x() {
        g3 r8 = this.f11038c;
        if (r8 == null) goto L5;
        this.f11042g = r8.g();
    L5:
        ArrayList<n2> r10 = this.f11042g;
        if (r10 != null) goto L8;
    L10:
        return true;
    L8:
        if (r10.size() <= 0) goto L10;
        return false;
    }
}
