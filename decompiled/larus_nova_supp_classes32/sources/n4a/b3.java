package n4a;

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
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.loc.bo;
import com.loc.em;
import com.loc.es;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.assistant.RiskPreferenceSettings;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b3 {
    public static final String[] M = null;
    public static volatile boolean N;
    public boolean A;
    public i3 B;
    public boolean C;
    public f3 D;
    public String E;
    public Handler F;
    public n3 G;
    public final boolean H;
    public IntentFilter I;
    public LocationManager J;
    public String K;
    public d3 L;
    public Context a;
    public ConnectivityManager b;
    public s3 c;
    public l3 d;
    public u3 e;
    public z3 f;
    public ArrayList<v2> g;
    public b h;
    public AMapLocationClientOption i;
    public es j;
    public long k;
    public int l;
    public a4 m;
    public boolean n;
    public String o;
    public com.loc.g p;
    public final StringBuilder q;
    public boolean r;
    public boolean s;
    public AMapLocationClientOption.GeoLanguage t;
    public boolean u;
    public boolean v;
    public String w;
    public StringBuilder x;
    public boolean y;
    public int z;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AMapLocationClientOption.GeoLanguage.values().length];
            a = r0;
            r0[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public class b extends BroadcastReceiver {
        public final /* synthetic */ b3 a;

        public b(b3 r1) {
            this.a = r1;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r7, Intent r8) {
            if (r7 == null) goto L67;
            if (r8 == null) goto L68;
            String r9 = r8.getAction();     // Catch: Throwable -> L48
            if (TextUtils.isEmpty(r9) == false) goto L9;
            return;
        L9:
            if (r9.equals("android.net.wifi.SCAN_RESULTS") == false) goto L34;
            s3 r10 = this.a.c;     // Catch: Throwable -> L48
            if (r10 != null) goto L13;
        L52:
            if (r8.getExtras() != null) goto L21;
            return;
        L21:
            if (r8.getExtras().getBoolean("resultsUpdated", true) == false) goto L57;
            s3 r11 = this.a.c;     // Catch: Throwable -> L51
            if (r11 == null) goto L58;
            r11.getClass();     // Catch: Throwable -> L51
            s3.E = System.currentTimeMillis();     // Catch: Throwable -> L51
            d3 r12 = r11.u;     // Catch: Throwable -> L51
            if (r12 == null) goto L59;
            Handler r13 = r12.c;     // Catch: Throwable -> L30
            if (r13 == null) goto L60;
            r13.post(new c3(r12));     // Catch: Throwable -> L30
            goto L62
        L61:
            return;
        L60:
            return;
        L30:
            th = move-exception;
            c4.g(th, "cl", "upw");     // Catch: Throwable -> L51
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
            if (r10.a == null) goto L52;
            if ((SystemClock.elapsedRealtime() - s3.z) <= 4900) goto L52;
            s3.z = SystemClock.elapsedRealtime();     // Catch: Throwable -> L48
            goto L52
        L34:
            if (r9.equals("android.net.wifi.WIFI_STATE_CHANGED") == false) goto L43;
            s3 r14 = this.a.c;     // Catch: Throwable -> L48
            if (r14 != null) goto L38;
            return;
        L38:
            if (r14.a == null) goto L63;
            r14.v = true;     // Catch: Throwable -> L48
            return;
        L63:
            return;
        L43:
            if (r9.equals("android.net.wifi.STATE_CHANGE") == false) goto L65;
            s3 r15 = this.a.c;     // Catch: Throwable -> L48
            if (r15 == null) goto L66;
            r15.j = null;     // Catch: Throwable -> L48
            return;
        L66:
            return;
        L65:
            return;
        L48:
            th = move-exception;
            c4.g(th, "Aps", "onReceive");
            return;
        L68:
            return;
        }
    }

    static {
        M = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        N = false;
    }

    public b3(boolean r5) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new ArrayList();
        this.h = null;
        this.i = new AMapLocationClientOption();
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.n = false;
        this.o = null;
        this.p = null;
        this.q = new StringBuilder();
        this.r = true;
        this.s = true;
        this.t = AMapLocationClientOption.GeoLanguage.DEFAULT;
        this.u = true;
        this.v = false;
        this.w = null;
        this.x = null;
        this.y = false;
        this.z = 12;
        this.A = true;
        this.B = null;
        this.C = false;
        this.D = null;
        this.E = null;
        this.H = false;
        this.I = null;
        this.J = null;
        this.H = r5;
    }

    public static es b(int r1, String r2) {
        es r0 = new es();
        r0.setErrorCode(r1);
        r0.setLocationDetail(r2);
        if (r1 != 15) goto L5;
        h4.k(null, 2151);
    L5:
        return r0;
    }

    public final void g(Context r5) {
    L18:
        th = move-exception;
        th.printStackTrace();
        c4.g(th, "Aps", "initBase");
        return;
    L3:
        if (this.a == null) goto L5;
        return;
    L5:
        this.D = new f3();     // Catch: Throwable -> L18
        Context r0 = r5.getApplicationContext();     // Catch: Throwable -> L18
        this.a = r0;     // Catch: Throwable -> L18
        j4.u(r0);     // Catch: Throwable -> L18
        if (this.c != null) goto L9;
        WifiManager r1 = (WifiManager) j4.e(this.a, "wifi");     // Catch: Throwable -> L18
        this.c = new s3(this.a, r1, this.F);     // Catch: Throwable -> L18
    L9:
        if (this.d != null) goto L11;
        this.d = new l3(this.a, this.F);     // Catch: Throwable -> L18
    L11:
        this.G = new n3(r5, this.F);     // Catch: Throwable -> L18
        if (this.e != null) goto L15;
        this.e = new u3();     // Catch: Throwable -> L18
    L15:
        if (this.f != null) goto L23;
        this.f = new z3();     // Catch: Throwable -> L18
        return;
    }

    public final void s() {
        if (this.q.length() <= 0) goto L6;
        StringBuilder r0 = this.q;
        r0.delete(0, r0.length());
        return;
    }

    public final void t() {
        this.E = null;
        this.y = false;
        u3 r2 = this.e;
        if (r2 == null) goto L9;
        Context r5 = this.a;
        r2.k();     // Catch: Throwable -> L7
        r2.l(r5);     // Catch: Throwable -> L7
        r2.c = false;     // Catch: Throwable -> L7
        r2.h = null;     // Catch: Throwable -> L7
        r2.k = 0;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        c4.g(th, "Cache", "destroy part");
    L9:
        f3 r3 = this.D;
        if (r3 == null) goto L13;
        r3.b();
    L13:
        if (this.f == null) goto L15;
        this.f = null;
    L15:
        n3 r4 = this.G;
        if (r4 != null) goto L18;
    L88:
        Context r6 = this.a;     // Catch: Throwable -> L38
        if (r6 == null) goto L40;
        b r7 = this.h;     // Catch: Throwable -> L38
        if (r7 == null) goto L40;
        ReceiverRegisterLancet.loge(r7, false);     // Catch: Throwable -> L38
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L91;
        r6.unregisterReceiver(r7);     // Catch: Throwable -> L38
        goto L40
    L91:
    L34:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r7.toString());     // Catch: Throwable -> L38
        e.printStackTrace();     // Catch: Throwable -> L38
        goto L40
    L31:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r7, r6) == false) goto L40;
        r6.unregisterReceiver(r7);     // Catch: Exception -> L34 Throwable -> L38
    L40:
        this.h = null;
        l3 r8 = this.d;
        if (r8 == null) goto L62;
        boolean r9 = this.H;
        j3 r10 = r8.h;
        Handler r11 = r10.d;
        if (r11 == null) goto L45;
        r11.removeCallbacks(r10.g);
    L45:
        if (r9 == true) goto L47;
        r10.g.run();
    L47:
        r10.b = false;
        r8.i = 0;
        Object r12 = r8.l;
        monitor-enter(r12);
        monitor-exit(r12);     // Catch: Throwable -> L59
        TelephonyManager r13 = r8.g;
        if (r13 == null) goto L58;
        l3.b r14 = r8.j;
        if (r14 == null) goto L58;
        r13.listen(r14, 0);     // Catch: Throwable -> L56
        r8.v = false;     // Catch: Throwable -> L56
    L56:
        th = move-exception;
        c4.g(th, "CgiManager", "destroy");
    L58:
        r8.j = null;
        r8.k = null;
        r8.g = null;
    L59:
        th = move-exception;
        throw th;
    L62:
        s3 r15 = this.c;
        if (r15 == null) goto L70;
        boolean r16 = this.H;
        r15.j = null;
        r15.b.clear();
        r15.b.clear();
        q3 r17 = r15.p;
        Handler r18 = r17.d;
        if (r18 == null) goto L67;
        r18.removeCallbacks(r17.g);
    L67:
        if (r16 == true) goto L69;
        r17.g.run();
    L69:
        r17.b = false;
    L70:
        ArrayList<v2> r19 = this.g;
        if (r19 == null) goto L73;
        r19.clear();
    L73:
        i3 r20 = this.B;
        if (r20 != null) goto L84;
    L79:
        this.j = null;
        this.a = null;
        this.x = null;
        this.J = null;
        return;
    L84:
        r20.d();     // Catch: Throwable -> L77
        r20.b = null;     // Catch: Throwable -> L77
        r20.c = null;     // Catch: Throwable -> L77
        r20.a = null;     // Catch: Throwable -> L77
        r20.d = null;     // Catch: Throwable -> L77
        r20.e = false;     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        c4.g(th, "AMapSensorManager", "destroy");
    L38:
        th = move-exception;
        c4.g(th, "Aps", "destroy");     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        this.h = null;
        throw th;
    L18:
        if (this.H == true) goto L20;
        r4.g.run();
    L20:
        Handler r21 = r4.d;
        if (r21 == null) goto L23;
        r21.removeCallbacks(r4.g);
    L23:
        r4.c = true;
        goto L88
    }

    public final void w() {
    L10:
        th = move-exception;
        c4.g(th, "Aps", "initBroadcastListener");
        return;
    L3:
        if (this.h != null) goto L6;
        this.h = new b(this);     // Catch: Throwable -> L10
    L6:
        if (this.I != null) goto L8;
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L10
        this.I = r0;     // Catch: Throwable -> L10
        r0.addAction("android.net.wifi.WIFI_STATE_CHANGED");     // Catch: Throwable -> L10
        this.I.addAction("android.net.wifi.SCAN_RESULTS");     // Catch: Throwable -> L10
        this.I.addAction("android.net.wifi.STATE_CHANGE");     // Catch: Throwable -> L10
    L8:
        a(this.a, this.h, this.I);     // Catch: Throwable -> L10
    }

    public final boolean y() {
        s3 r0 = this.c;
        if (r0 == null) goto L5;
        this.g = r0.i();
    L5:
        ArrayList<v2> r1 = this.g;
        if (r1 != null) goto L8;
    L10:
        return true;
    L8:
        if (r1.size() <= 0) goto L10;
        return false;
    }

    public final void l() {
        l3 r0 = this.d;
        if (r0 == null) goto L33;
        r0.getClass();
        if (Build.VERSION.SDK_INT >= 31) goto L8;
        return;
    L8:
        if (l3.l(r0.a, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L10;
        String r1 = "hasFineLocPerm";
    L12:
        if (l3.l(r0.a, "android.permission.READ_PHONE_STATE") != 0) goto L14;
        String r2 = "hasReadPhoneStatePerm";
    L15:
        boolean r4 = true;
        if (TextUtils.isEmpty(r0.r) == false) goto L18;
    L20:
        boolean r3 = false;
    L22:
        if (TextUtils.isEmpty(r0.q) == false) goto L24;
    L26:
        r4 = r3;
    L27:
        if (r4 == false) goto L35;
        r0.q();     // Catch: Throwable -> L30
        return;
    L35:
        return;
    L24:
        if (r0.q.equals(r2) == true) goto L26;
    L18:
        if (r0.r.equals(r1) == true) goto L20;
        r3 = true;
        goto L22
    L14:
        r2 = "hasNoReadPhoneStatePerm";
        goto L15
    L10:
        r1 = "hasNoFineLocPerm";
    L36:
        return;
    }

    public final void p() {
        Context r0 = this.a;
        if (com.loc.g.e != null) goto L5;
        com.loc.g.e = new com.loc.g(r0);
    L5:
        this.p = com.loc.g.e;
        v();
        if (this.b != null) goto L9;
        this.b = (ConnectivityManager) j4.e(this.a, "connectivity");
    L9:
        if (this.m != null) goto L12;
        this.m = new a4();
        return;
    }

    public final void r() {
        if (this.B != null) goto L5;
        this.B = new i3(this.a);
    L5:
        w();
        s3 r0 = this.c;
        if (r0 == null) goto L8;
        r0.d(false);
        this.g = this.c.i();
    L8:
        l3 r1 = this.d;
        if (r1 == null) goto L11;
        r1.j(false, y());
    L11:
        u3 r2 = this.e;
        Context r3 = this.a;
        if (r2.c == false) goto L27;
    L19:
        Context r4 = this.a;
        if (r4.checkCallingOrSelfPermission(f5.o("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) != 0) goto L29;
        this.n = true;     // Catch: Throwable -> L24
        return;
    L29:
        return;
    L30:
        return;
    L27:
        r2.k();     // Catch: Throwable -> L16
        r2.f(r3, null, false);     // Catch: Throwable -> L16
    L18:
        r2.c = true;
    L16:
        th = move-exception;
        c4.g(th, "Cache", "loadDB");
        goto L18
    }

    public final void u() {
        d3 r0 = this.L;
        if (r0 != null) goto L5;
        return;
    L5:
        if (j4.J(r0.a) == true) goto L29;
        d3.a r1 = r0.h;     // Catch: Throwable -> L22
        if (r1 == null) goto L15;
        LocationManager r2 = r0.g;     // Catch: Throwable -> L22
        if (r2 == null) goto L15;
        if (fna.g.d() == true) goto L14;
        r2.removeUpdates(r1);     // Catch: Throwable -> L22
        goto L15
    L14:
        r2.removeUpdates(r1);     // Catch: Throwable -> L22
        nna.a.a(r1.hashCode());     // Catch: Throwable -> L22
    L15:
        d3.a r3 = r0.h;     // Catch: Throwable -> L22
        if (r3 == null) goto L19;
        r3.a = null;     // Catch: Throwable -> L22
    L19:
        if (r0.j == false) goto L28;
        r0.e();     // Catch: Throwable -> L22
        r0.d.u = null;     // Catch: Throwable -> L22
        r0.e.w = null;     // Catch: Throwable -> L22
        r0.e = null;     // Catch: Throwable -> L22
        r0.d = null;     // Catch: Throwable -> L22
        r0.c = null;     // Catch: Throwable -> L22
        r0.j = false;     // Catch: Throwable -> L22
        return;
    L28:
        return;
    L22:
        th = move-exception;
        c4.g(th, "clm", "stc");
        return;
    }

    public final void v() {
        if (this.p == null) goto L31;
        if (this.i != null) goto L7;
        this.i = new AMapLocationClientOption();     // Catch: Throwable -> L27
    L7:
        boolean r1 = false;
        if (this.i.getGeoLanguage() == null) goto L17;
        int r0 = a.a[this.i.getGeoLanguage().ordinal()];     // Catch: Throwable -> L27
        if (r0 == 1) goto L17;
        int r3 = 2;
        if (r0 != 2) goto L14;
        r3 = 1;
    L18:
        com.loc.g r2 = this.p;     // Catch: Throwable -> L27
        long r4 = this.i.getHttpTimeOut();     // Catch: Throwable -> L27
        if (this.i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS) == false) goto L21;
        r1 = true;
    L21:
        r2.getClass();     // Catch: Throwable -> L27
        r2.c = r1;     // Catch: Throwable -> L24
        r2.b = Long.valueOf(r4).intValue();     // Catch: Throwable -> L24
        r2.d = r3;     // Catch: Throwable -> L24
        goto L33
    L32:
        return;
    L24:
        th = move-exception;
        c4.g(th, "LocNetManager", "setOption");     // Catch: Throwable -> L27
        return;
    L14:
        if (r0 == 3) goto L18;
    L17:
        r3 = 0;
    L33:
        return;
    }

    public final byte[] x() throws Throwable {
        if (this.m != null) goto L6;
        this.m = new a4();
    L6:
        if (this.i != null) goto L9;
        this.i = new AMapLocationClientOption();
    L9:
        if (this.d != null) goto L11;
    L13:
        a4 r2 = this.m;
        r2.e();
        int r4 = 2;
        byte[] r5 = new byte[2];
        byte[] r7 = new byte[4];
        byte[] r0 = r2.C;
        int r8 = 1;
        int r9 = 4096;
        if (r0 == null) goto L16;
        r9 = 4096 + (r0.length + 1);
    L16:
        byte[] r1 = r2.D;
        if (r1 != null) goto L19;
    L20:
        r1 = new byte[r9];
        r2.D = r1;
        r2.E = r9;
    L21:
        byte[] r10 = r1;
        int r11 = 0;
        r10[0] = j4.F();
        byte[] r12 = null;
        byte[] r3 = j4.p(r2.a, null);
        System.arraycopy(r3, 0, r10, 1, r3.length);
        int r13 = a4.a(r2.o, r10, a4.a(r2.n, r10, a4.a(r2.f, r10, a4.a(r2.r, r10, a4.a(r2.e, r10, a4.a(r2.d, r10, a4.a(null, r10, a4.a(r2.m, r10, a4.a(r2.c, r10, a4.a(r2.b, r10, r3.length + 1))))))))));
    L27:
        th = move-exception;
        c4.g(th, "Req", "buildV4Dot219");
        r10[r13] = 0;
    L29:
        int r14 = r13 + 1;
    L30:
        int r6 = a4.a(r2.t, r10, a4.a(a4.M, r10, a4.a(a4.L, r10, a4.a(null, r10, a4.a(r2.s, r10, r14)))));
        r10[r6] = CastByteProtector.parseByte(r2.u);
        int r15 = r6 + 1;
        r10[r15] = CastByteProtector.parseByte(r2.h);
        int r16 = r15 + 1;
        int r17 = r2.v;
        int r18 = r17 & 3;
        r10[r16] = (byte) r17;
        int r19 = r16 + 1;
        long r110 = 0;
        if (r18 == 1) goto L37;
        if (r18 == 2) goto L37;
        r7 = r7;
    L35:
        byte[] r111 = r10;
    L139:
        String r20 = r2.y;
        String r21 = "GBK";
        if (r20 != null) goto L142;
    L145:
        r111[r19] = 0;
        int r22 = r19 + 1;
    L146:
        ArrayList<k3> r23 = r2.x;
        int r24 = r23.size();
        if ((r2.v & 4) != 4) goto L211;
        if (r24 <= 0) goto L211;
        ListProtector.get(r23, 0);
        r111[r22] = (byte) r24;
        int r112 = 1;
        int r25 = r22 + 1;
        int r113 = 0;
    L150:
        if (r113 >= r24) goto L210;
        k3 r26 = (k3) ListProtector.get(r23, r113);
        int r114 = r26.l;
        if (r114 == r112) goto L169;
        if (r114 == 3) goto L169;
        if (r114 == 4) goto L169;
        if (r114 != r4) goto L162;
        byte r115 = (byte) r114;
        if (r26.m == false) goto L161;
        r115 = (byte) (r115 | 8);
    L161:
        r111[r25] = r115;
        int r27 = r25 + 1;
        byte[] r116 = j4.p(r26.a, r5);
        System.arraycopy(r116, r11, r111, r27, r116.length);
        int r28 = r27 + r116.length;
        byte[] r117 = j4.p(r26.h, r5);
        System.arraycopy(r117, r11, r111, r28, r117.length);
        int r29 = r28 + r117.length;
        byte[] r118 = j4.p(r26.i, r5);
        System.arraycopy(r118, r11, r111, r29, r118.length);
        int r30 = r29 + r118.length;
        byte[] r119 = j4.p(r26.j, r5);
        System.arraycopy(r119, r11, r111, r30, r119.length);
        int r31 = r30 + r119.length;
        byte[] r120 = r7;
        byte[] r121 = j4.x(r26.g, r120);
        System.arraycopy(r121, r11, r111, r31, r121.length);
        int r32 = r31 + r121.length;
        byte[] r33 = j4.x(r26.f, r120);
        System.arraycopy(r33, r11, r111, r32, r33.length);
        r25 = r32 + r33.length;
        byte[] r34 = r120;
    L173:
        int r35 = r26.k;
        if (r35 <= 127) goto L177;
    L178:
        r35 = 99;
    L179:
        r111[r25] = (byte) r35;
        int r36 = r25 + 1;
        byte[] r37 = r111;
        byte[] r38 = j4.p((short) ((SystemClock.elapsedRealtime() - r26.s) / 1000), r5);
        System.arraycopy(r38, 0, r37, r36, r38.length);
        r25 = r36 + r38.length;
        int r39 = r26.l;
        int r40 = 32767;
        if (r39 == 3) goto L198;
        if (r39 == 4) goto L198;
        if (r39 == 5) goto L198;
        if (r39 != 1) goto L209;
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() < 5.3d) goto L209;
        int r41 = r26.n;
        if (r41 <= 32767) goto L193;
        r41 = 32767;
    L193:
        if (r41 < 0) goto L196;
        r40 = r41;
    L196:
        byte[] r42 = j4.p(r40, r5);
        System.arraycopy(r42, 0, r37, r25, r42.length);
        int r43 = r25 + r42.length;
        byte[] r44 = j4.x(r26.o, r34);
        System.arraycopy(r44, 0, r37, r43, r44.length);
        int r45 = r43 + r44.length;
        byte[] r46 = j4.x(r26.p, r34);
        System.arraycopy(r46, 0, r37, r45, r46.length);
        int r47 = r46.length;
    L208:
        r25 = r45 + r47;
    L209:
        r113 = r113 + 1;
        r7 = r34;
        r111 = r37;
        r21 = r21;
        r24 = r24;
        r4 = 2;
        r11 = 0;
        r112 = 1;
    L198:
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() < 5.0d) goto L209;
        int r48 = r26.n;
        if (r48 <= 32767) goto L202;
        r48 = 32767;
    L202:
        if (r48 < 0) goto L205;
        r40 = r48;
    L205:
        byte[] r49 = j4.p(r40, r5);
        System.arraycopy(r49, 0, r37, r25, r49.length);
        r25 = r25 + r49.length;
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() < 5.3d) goto L209;
        byte[] r50 = j4.x(r26.o, r34);
        System.arraycopy(r50, 0, r37, r25, r50.length);
        r45 = r25 + r50.length;
        byte[] r51 = j4.x(r26.p, r34);
        System.arraycopy(r51, 0, r37, r45, r51.length);
        r47 = r51.length;
        goto L208
    L177:
        if (r35 >= (-128)) goto L179;
    L162:
        r34 = r7;
        if (r114 != 5) goto L173;
        byte r122 = (byte) r114;
        if (r26.m == false) goto L167;
        r122 = (byte) (r122 | 8);
    L167:
        r111[r25] = r122;
        int r52 = r25 + 1;
        byte[] r123 = j4.p(r26.a, r5);
        System.arraycopy(r123, r11, r111, r52, r123.length);
        int r53 = r52 + r123.length;
        byte[] r124 = j4.p(r26.b, r5);
        System.arraycopy(r124, r11, r111, r53, r124.length);
        int r54 = r53 + r124.length;
        byte[] r125 = j4.p(r26.c, r5);
        System.arraycopy(r125, r11, r111, r54, r125.length);
        int r55 = r54 + r125.length;
        System.arraycopy(j4.q(r26.e), r11, r111, r55, 8);
        r25 = r55 + 8;
    L169:
        r34 = r7;
        byte r56 = (byte) r114;
        if (r26.m == false) goto L172;
        r56 = (byte) (r56 | 8);
    L172:
        r111[r25] = r56;
        int r57 = r25 + 1;
        byte[] r58 = j4.p(r26.a, r5);
        System.arraycopy(r58, r11, r111, r57, r58.length);
        int r59 = r57 + r58.length;
        byte[] r60 = j4.p(r26.b, r5);
        System.arraycopy(r60, r11, r111, r59, r60.length);
        int r61 = r59 + r60.length;
        byte[] r62 = j4.p(r26.c, r5);
        System.arraycopy(r62, r11, r111, r61, r62.length);
        int r63 = r61 + r62.length;
        byte[] r64 = j4.x(r26.d, r34);
        System.arraycopy(r64, r11, r111, r63, r64.length);
        r25 = r63 + r64.length;
        goto L173
    L210:
        String r126 = r21;
        byte[] r127 = r111;
        byte[] r65 = r7;
        byte r66 = 1;
    L213:
        if (TextUtils.isEmpty(r2.z) == false) goto L215;
    L240:
        int r67 = 1;
        byte r68 = 0;
        r127[r25] = 0;
        int r69 = r25 + 1;
    L241:
        ArrayList<v2> r70 = r2.A;
        int r71 = Math.min(r70.size(), 25);
        if (r71 != 0) goto L244;
        r127[r69] = r68;
        int r72 = r69 + r67;
        byte r128 = 0;
    L270:
        r127[r72] = r128;
        int r73 = r72 + 1;
        r127[r73] = r128;     // Catch: Throwable -> L273
    L274:
        int r74 = r73 + 1;
        byte[] r75 = {0, 0};
        boolean r76 = TextUtils.isEmpty(r2.F);     // Catch: Throwable -> L284
        if (r76 == true) goto L278;
        r75 = j4.p(r2.F.length(), r5);     // Catch: Throwable -> L284
    L278:
        System.arraycopy(r75, 0, r127, r74, 2);     // Catch: Throwable -> L284
        int r77 = r74 + 2;
        if (r76 == false) goto L365;
    L283:
        int r78 = 2;
    L379:
        System.arraycopy(j4.p(0, r5), 0, r127, r77, r78);     // Catch: Throwable -> L361
    L287:
        int r79 = r77 + r78;
        byte[] r80 = new byte[r78];
        r80 = {x093a: FILL_ARRAY_DATA  (LINE:2362), data: [0, 0} // fill-array;
        System.arraycopy(r80, 0, r127, r79, r78);     // Catch: Throwable -> L290
    L291:
        int r81 = r79 + r78;
        byte[] r82 = r2.C;
        if (r82 == null) goto L294;
        int r83 = r82.length;
    L295:
        byte[] r84 = j4.p(r83, null);
        System.arraycopy(r84, 0, r127, r81, r84.length);
        int r85 = r81 + r84.length;
        if (r83 <= 0) goto L299;
        byte[] r86 = r2.C;
        System.arraycopy(r86, 0, r127, r85, r86.length);
        r85 = r85 + r2.C.length;
    L299:
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() < 5.0d) goto L338;
        List<k3> r87 = r2.K;
        if (r87 == null) goto L303;
        int r88 = r87.size();
    L304:
        r127[r85] = (byte) r88;
        int r89 = r85 + 1;
        byte[] r90 = new byte[r89];
        System.arraycopy(r127, 0, r90, 0, r89);
        if (r88 > 0) goto L363;
    L336:
        r85 = a4.a(r2.G, r127, r89);
        goto L338
    L363:
        Iterator<k3> r91 = r2.K.iterator();     // Catch: Throwable -> L335
        int r92 = r89;
    L307:
        if (r91.hasNext() == false) goto L334;
        k3 r93 = r91.next();     // Catch: Throwable -> L335
        int r129 = r93.l;     // Catch: Throwable -> L335
        if (r129 == 1) goto L327;
        if (r129 == 3) goto L327;
        if (r129 == 4) goto L327;
        if (r129 != 2) goto L322;
        byte r130 = (byte) r129;     // Catch: Throwable -> L335
        if (r93.m == false) goto L320;
        r130 = (byte) (r130 | 8);     // Catch: Throwable -> L335
    L320:
        r127[r92] = r130;     // Catch: Throwable -> L335
        int r94 = r92 + 1;     // Catch: Throwable -> L335
        byte[] r131 = j4.p(r93.h, r5);     // Catch: Throwable -> L335
        System.arraycopy(r131, 0, r127, r94, r131.length);     // Catch: Throwable -> L335
        int r95 = r94 + r131.length;     // Catch: Throwable -> L335
        byte[] r132 = j4.p(r93.i, r5);     // Catch: Throwable -> L335
        System.arraycopy(r132, 0, r127, r95, r132.length);     // Catch: Throwable -> L335
        int r96 = r95 + r132.length;     // Catch: Throwable -> L335
        byte[] r133 = j4.p(r93.j, r5);     // Catch: Throwable -> L335
        System.arraycopy(r133, 0, r127, r96, r133.length);     // Catch: Throwable -> L335
        int r134 = r133.length;     // Catch: Throwable -> L335
    L331:
        r92 = r96 + r134;     // Catch: Throwable -> L335
    L332:
        byte[] r97 = j4.p((short) ((SystemClock.elapsedRealtime() - r93.s) / 1000), r5);     // Catch: Throwable -> L335
        System.arraycopy(r97, 0, r127, r92, r97.length);     // Catch: Throwable -> L335
        r92 = r92 + r97.length;
        goto L307
    L322:
        if (r129 != 5) goto L332;
        byte r135 = (byte) r129;     // Catch: Throwable -> L335
        if (r93.m == false) goto L326;
        r135 = (byte) (r135 | 8);     // Catch: Throwable -> L335
    L326:
        r127[r92] = r135;     // Catch: Throwable -> L335
        int r98 = r92 + 1;     // Catch: Throwable -> L335
        byte[] r136 = j4.p(r93.c, r5);     // Catch: Throwable -> L335
        System.arraycopy(r136, 0, r127, r98, r136.length);     // Catch: Throwable -> L335
        int r99 = r98 + r136.length;     // Catch: Throwable -> L335
        System.arraycopy(j4.q(r93.e), 0, r127, r99, 8);     // Catch: Throwable -> L335
        r92 = r99 + 8;     // Catch: Throwable -> L335
    L327:
        byte r137 = (byte) r129;     // Catch: Throwable -> L335
        if (r93.m == false) goto L330;
        r137 = (byte) (r137 | 8);     // Catch: Throwable -> L335
    L330:
        r127[r92] = r137;     // Catch: Throwable -> L335
        int r100 = r92 + 1;     // Catch: Throwable -> L335
        byte[] r138 = j4.p(r93.c, r5);     // Catch: Throwable -> L335
        System.arraycopy(r138, 0, r127, r100, r138.length);     // Catch: Throwable -> L335
        r96 = r100 + r138.length;     // Catch: Throwable -> L335
        byte[] r139 = j4.x(r93.d, r65);     // Catch: Throwable -> L335
        System.arraycopy(r139, 0, r127, r96, r139.length);     // Catch: Throwable -> L335
        r134 = r139.length;     // Catch: Throwable -> L335
        goto L331
    L334:
        r89 = r92;
    L335:
        System.arraycopy(r90, 0, r127, 0, r89);
        r127[r89 - 1] = 0;
        goto L336
    L303:
        r88 = 0;
    L338:
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() < 5.2d) goto L356;
        List<m3> r101 = r2.J;
        if (r101 != null) goto L342;
        int r102 = 0;
    L343:
        r127[r85] = (byte) r102;
        r85 = r85 + 1;
        if (r102 <= 0) goto L356;
        Iterator r103 = ((ArrayList) r2.J).iterator();
    L347:
        if (r103.hasNext() == false) goto L356;
        m3 r104 = (m3) r103.next();
        int r105 = ((int) (System.currentTimeMillis() - r104.d)) / 1000;
        if (r105 <= 65535) goto L351;
        r105 = 65535;
    L351:
        System.arraycopy(j4.p(r105, r5), 0, r127, r85, 2);
        int r106 = r85 + 2;
        System.arraycopy(j4.x((int) Math.round(r104.c * 1.0E7d), r65), 0, r127, r106, 4);
        int r107 = r106 + 4;
        System.arraycopy(j4.x((int) Math.round(r104.b * 1.0E7d), r65), 0, r127, r107, 4);
        int r108 = r107 + 4;
        float r109 = r104.e;
        if (r109 <= 65535.0f) goto L354;
        r109 = 65535.0f;
    L354:
        System.arraycopy(j4.p((int) r109, r5), 0, r127, r108, 2);
        int r140 = r108 + 2;
        System.arraycopy(j4.p((short) ((r104.g | ((r104.a << 13) | (r104.f << 6))) & 65535), r5), 0, r127, r140, 2);
        r85 = r140 + 2;
        goto L347
    L342:
        r102 = ((ArrayList) r101).size();
    L356:
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() < 5.3d) goto L358;
        r85 = a4.a(r2.H, r127, r85);
    L358:
        byte[] r141 = new byte[r85];
        System.arraycopy(r127, 0, r141, 0, r85);
        CRC32 r142 = new CRC32();
        r142.update(r141);
        byte[] r143 = j4.q(r142.getValue());
        byte[] r144 = new byte[r85 + 8];
        System.arraycopy(r141, 0, r144, 0, r85);
        System.arraycopy(r143, 0, r144, r85, 8);
        return r144;
    L294:
        r83 = 0;
        goto L295
    L365:
        byte[] r145 = r2.F.getBytes(r126);     // Catch: Throwable -> L360
        System.arraycopy(r145, 0, r127, r77, r145.length);     // Catch: Throwable -> L360
        r77 = r77 + r145.length;
    L284:
        r78 = 2;
        r77 = r74 + 2;
    L273:
        r127[r73] = r128;
        goto L274
    L244:
        r127[r69] = (byte) r71;
        int r146 = r69 + r67;
        if (j4.y() < 17) goto L247;
        boolean r147 = true;
    L248:
        if (r147 == false) goto L250;
        r110 = SystemClock.elapsedRealtime() / 1000;
    L250:
        int r148 = 0;
    L251:
        if (r148 >= r71) goto L269;
        v2 r149 = (v2) ListProtector.get(r70, r148);
        byte[] r150 = a4.d(v2.b(r149.a));
        System.arraycopy(r150, 0, r127, r146, r150.length);
        int r151 = r146 + r150.length;
        byte[] r152 = r149.b.getBytes(r126);     // Catch: Exception -> L255
        r127[r151] = (byte) r152.length;     // Catch: Exception -> L255
        r151 = r151 + 1;     // Catch: Exception -> L255
        System.arraycopy(r152, 0, r127, r151, r152.length);     // Catch: Exception -> L255
        int r153 = r151 + r152.length;
    L256:
        int r154 = r149.c;
        if (r154 > 127) goto L260;
        if (r154 < (-128)) goto L260;
    L261:
        r127[r153] = CastByteProtector.parseByte(String.valueOf(r154));
        int r155 = r153 + 1;
        if (r147 == false) goto L265;
        int r156 = (int) (r110 - (r149.f / 1000));
        if (r156 < 0) goto L265;
    L266:
        if (r156 <= 65535) goto L268;
        r156 = 65535;
    L268:
        byte[] r157 = j4.p(r156, r5);
        System.arraycopy(r157, 0, r127, r155, r157.length);
        int r158 = r155 + r157.length;
        byte[] r159 = j4.p(r149.d, r5);
        System.arraycopy(r159, 0, r127, r158, r159.length);
        r146 = r158 + r159.length;
        r148 = r148 + 1;
    L265:
        r156 = 0;
    L260:
        r154 = 0;
    L255:
        r127[r151] = 0;
        r153 = r151 + 1;
        goto L256
    L269:
        r128 = 0;
        byte[] r160 = j4.p(CastIntegerProtector.parseInt(r2.B), r5);
        System.arraycopy(r160, 0, r127, r146, r160.length);
        r72 = r146 + r160.length;
        goto L270
    L247:
        r147 = false;
        goto L248
    L215:
        if (r2.z.length() == 0) goto L240;
        r127[r25] = r66;
        r69 = r25 + 1;
        String[] r161 = r2.z.split(",");     // Catch: Throwable -> L238
        byte[] r162 = a4.d(r161[0]);     // Catch: Throwable -> L238
        System.arraycopy(r162, 0, r127, r69, r162.length);     // Catch: Throwable -> L238
        r69 = r69 + r162.length;
        byte[] r163 = r161[2].getBytes(r126);     // Catch: Throwable -> L225
        int r164 = r163.length;     // Catch: Throwable -> L225
        if (r164 <= 127) goto L223;
        r164 = 127;
    L223:
        r127[r69] = (byte) r164;     // Catch: Throwable -> L225
        r69 = r69 + 1;     // Catch: Throwable -> L225
        System.arraycopy(r163, 0, r127, r69, r164);     // Catch: Throwable -> L225
        int r165 = r69 + r164;
    L227:
        int r166 = CastIntegerProtector.parseInt(r161[1]);     // Catch: Throwable -> L238
        if (r166 <= 127) goto L231;
    L232:
        r166 = 0;
    L233:
        r127[r165] = CastByteProtector.parseByte(String.valueOf(r166));     // Catch: Throwable -> L238
        r69 = r165 + 1;     // Catch: Throwable -> L238
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() < 5.2d) goto L237;
        byte[] r167 = j4.p(r2.I, r5);     // Catch: Throwable -> L238
        System.arraycopy(r167, 0, r127, r69, r167.length);     // Catch: Throwable -> L238
        r69 = r69 + r167.length;
    L237:
        r67 = 1;
        r68 = 0;
        goto L241
    L231:
        if (r166 >= (-128)) goto L233;
    L225:
        th = move-exception;
        c4.g(th, "Req", "buildV4Dot214");     // Catch: Throwable -> L238
        r127[r69] = 0;     // Catch: Throwable -> L238
        r165 = r69 + 1;     // Catch: Throwable -> L238
    L238:
        th = move-exception;
        c4.g(th, "Req", "buildV4Dot216");
        byte[] r168 = a4.d("00:00:00:00:00:00");
        r68 = 0;
        System.arraycopy(r168, 0, r127, r69, r168.length);
        int r169 = r69 + r168.length;
        r127[r169] = 0;
        r67 = 1;
        int r170 = r169 + 1;
        r127[r170] = CastByteProtector.parseByte("0");
        r69 = r170 + 1;
    L211:
        r126 = "GBK";
        r127 = r111;
        r65 = r7;
        r127[r22] = 0;
        r66 = 1;
        r25 = r22 + 1;
        goto L213
    L142:
        if ((r2.v & 8) != 8) goto L145;
        byte[] r171 = r20.getBytes("GBK");     // Catch: Exception -> L362
        int r172 = Math.min(r171.length, 60);     // Catch: Exception -> L362
        r111[r19] = (byte) r172;     // Catch: Exception -> L362
        r19 = r19 + 1;     // Catch: Exception -> L362
        System.arraycopy(r171, 0, r111, r19, r172);     // Catch: Exception -> L362
        r22 = r19 + r172;
    L37:
        if (r2.w.size() <= 0) goto L39;
        int r173 = ((k3) ListProtector.get(r2.w, 0)).a;
    L40:
        byte[] r174 = j4.p(r173, null);
        System.arraycopy(r174, 0, r10, r19, r174.length);
        int r175 = r19 + r174.length;
        if (r18 == 1) goto L43;
        if (r18 == 2) goto L57;
    L79:
        if (r2.w.size() <= 0) goto L81;
        int r176 = ((k3) ListProtector.get(r2.w, 0)).k;
    L82:
        if (r176 > 127) goto L85;
        if (r176 < (-128)) goto L85;
    L86:
        r10[r175] = (byte) r176;
        int r177 = r175 + 1;
        if (r2.w.size() <= 0) goto L89;
        long r178 = (SystemClock.elapsedRealtime() - ((k3) ListProtector.get(r2.w, 0)).s) / 1000;
    L91:
        if (r178 <= 65535) goto L94;
        r178 = 65535;
    L94:
        if (r178 >= 0) goto L96;
        r178 = 0;
    L96:
        byte[] r179 = j4.p((int) r178, r5);
        System.arraycopy(r179, 0, r10, r177, r179.length);
        r19 = r177 + 2;
        if (r18 == 1) goto L99;
        r111 = r10;
        if (r18 != 2) goto L139;
        r111[r19] = 0;
        r19 = r19 + 1;
        goto L139
    L99:
        if (r2.w.size() != 0) goto L101;
        r10[r19] = 0;
        r19 = r19 + 1;
        goto L35
    L101:
        int r180 = r2.w.size();
        r10[r19] = (byte) r180;
        r19 = r19 + 1;
        int r181 = 0;
    L102:
        if (r181 >= r180) goto L35;
        if (r2.w.size() <= 0) goto L106;
        int r182 = ((k3) ListProtector.get(r2.w, r181)).c;
    L107:
        byte[] r183 = j4.p(r182, r12);
        System.arraycopy(r183, 0, r10, r19, r183.length);
        int r184 = r19 + r183.length;
        if (r2.w.size() <= 0) goto L110;
        int r185 = ((k3) ListProtector.get(r2.w, r181)).d;
    L111:
        byte[] r186 = j4.x(r185, r12);
        System.arraycopy(r186, 0, r10, r184, r186.length);
        int r187 = r184 + r186.length;
        if (r2.w.size() <= 0) goto L114;
        int r188 = ((k3) ListProtector.get(r2.w, r181)).k;
    L116:
        if (r188 <= 127) goto L119;
    L120:
        r188 = 0;
    L121:
        r10[r187] = (byte) r188;
        r19 = r187 + r8;
        if (CastDoubleProtector.valueOf(c4.a).doubleValue() >= 5.2d) goto L124;
        byte[] r189 = r10;
    L135:
        r181 = r181 + 1;
        r10 = r189;
        r8 = 1;
        r12 = null;
        goto L102
    L124:
        if (r2.w.size() <= 0) goto L126;
        long r190 = (SystemClock.elapsedRealtime() - ((k3) ListProtector.get(r2.w, 0)).s) / 1000;
    L128:
        if (r190 <= 65535) goto L131;
        r190 = 65535;
    L131:
        if (r190 >= 0) goto L133;
        r190 = 0;
    L133:
        byte[] r191 = j4.p((int) r190, r5);
        r189 = r10;
        System.arraycopy(r191, 0, r189, r19, r191.length);
        r19 = r19 + r191.length;
        goto L135
    L126:
        r190 = 0;
        goto L128
    L119:
        if (r188 >= (-128)) goto L121;
    L114:
        r188 = 0;
        goto L116
    L110:
        r185 = 0;
        goto L111
    L106:
        r182 = 0;
        goto L107
    L89:
        r178 = 0;
    L85:
        r176 = 0;
        goto L86
    L81:
        r176 = 0;
        goto L82
    L57:
        if (r2.w.size() <= 0) goto L59;
        int r192 = ((k3) ListProtector.get(r2.w, 0)).h;
    L60:
        byte[] r193 = j4.p(r192, null);
        System.arraycopy(r193, 0, r10, r175, r193.length);
        int r194 = r175 + r193.length;
        if (r2.w.size() <= 0) goto L63;
        int r195 = ((k3) ListProtector.get(r2.w, 0)).i;
    L64:
        byte[] r196 = j4.p(r195, null);
        System.arraycopy(r196, 0, r10, r194, r196.length);
        int r197 = r194 + r196.length;
        if (r2.w.size() <= 0) goto L67;
        int r198 = ((k3) ListProtector.get(r2.w, 0)).j;
    L68:
        byte[] r199 = j4.p(r198, null);
        System.arraycopy(r199, 0, r10, r197, r199.length);
        int r200 = r197 + r199.length;
        if (r2.w.size() <= 0) goto L71;
        int r1100 = ((k3) ListProtector.get(r2.w, 0)).g;
    L72:
        byte[] r1101 = j4.x(r1100, null);
        System.arraycopy(r1101, 0, r10, r200, r1101.length);
        int r201 = r200 + r1101.length;
        if (r2.w.size() <= 0) goto L75;
        int r1102 = ((k3) ListProtector.get(r2.w, 0)).f;
    L76:
        byte[] r1103 = j4.x(r1102, null);
        System.arraycopy(r1103, 0, r10, r201, r1103.length);
        int r1104 = r1103.length;
    L77:
        r175 = r201 + r1104;
        goto L79
    L75:
        r1102 = 0;
        goto L76
    L71:
        r1100 = 0;
        goto L72
    L67:
        r198 = 0;
        goto L68
    L63:
        r195 = 0;
        goto L64
    L59:
        r192 = 0;
        goto L60
    L43:
        if (r2.w.size() <= 0) goto L45;
        int r1105 = ((k3) ListProtector.get(r2.w, 0)).b;
    L46:
        byte[] r1106 = j4.p(r1105, null);
        System.arraycopy(r1106, 0, r10, r175, r1106.length);
        int r202 = r175 + r1106.length;
        if (r2.w.size() <= 0) goto L49;
        int r1107 = ((k3) ListProtector.get(r2.w, 0)).c;
    L50:
        byte[] r1108 = j4.p(r1107, null);
        System.arraycopy(r1108, 0, r10, r202, r1108.length);
        r201 = r202 + r1108.length;
        if (r2.w.size() <= 0) goto L53;
        int r1109 = ((k3) ListProtector.get(r2.w, 0)).d;
    L54:
        byte[] r1110 = j4.x(r1109, null);
        System.arraycopy(r1110, 0, r10, r201, r1110.length);
        r1104 = r1110.length;
        goto L77
    L53:
        r1109 = 0;
        goto L54
    L49:
        r1107 = 0;
        goto L50
    L45:
        r1105 = 0;
        goto L46
    L39:
        r173 = 0;
        goto L40
    L23:
        if (TextUtils.isEmpty(r2.q) == false) goto L25;
        r10[r13] = 0;     // Catch: Throwable -> L27
        goto L29
    L25:
        byte[] r203 = a4.d(r2.q);     // Catch: Throwable -> L27
        r10[r13] = (byte) r203.length;     // Catch: Throwable -> L27
        int r1111 = r13 + 1;     // Catch: Throwable -> L27
        System.arraycopy(r203, 0, r10, r1111, r203.length);     // Catch: Throwable -> L27
        r14 = r1111 + r203.length;
        goto L30
    L19:
        if (r9 <= r2.E) goto L21;
    L11:
        if (this.c == null) goto L13;
        this.m.b(this.a, this.i.isNeedAddress(), this.i.isOffset(), this.d, this.c, this.b, this.E, this.G);
        goto L13
    }

    public final es c(em r19) throws Throwable {
        s();
        r19.g = "conitue";
        if (this.a != null) goto L6;
        r19.h = "#0101";
        this.q.append("context is null#0101");
        return b(1, this.q.toString());
    L6:
        int r0 = this.l + 1;
        this.l = r0;
        if (r0 != 1) goto L31;
        s3 r1 = this.c;
        if (r1 == null) goto L31;
        boolean r8 = this.n;
        Context r9 = r1.d;
        if (com.loc.h.u == false) goto L31;
        if (r1.i == false) goto L31;
        if (r1.a == null) goto L31;
        if (r9 == null) goto L31;
        if (r8 == false) goto L31;
        if (j4.y() <= 17) goto L31;
        ContentResolver r2 = r9.getContentResolver();
    L29:
        th = move-exception;
        c4.g(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        goto L31
    L26:
        if (((Integer) f4.e("android.provider.Settings$Global", "getInt", new Object[]{r2, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() != 0) goto L31;
        f4.e("android.provider.Settings$Global", "putInt", new Object[]{r2, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});     // Catch: Throwable -> L29
    L31:
        long r10 = this.k;
        if (this.A == true) goto L35;
        this.A = true;
    L43:
        boolean r3 = false;
    L44:
        if (r3 == true) goto L46;
    L54:
        i3 r11 = this.B;
        if (r11 != null) goto L57;
    L166:
    L93:
        th = move-exception;
        c4.g(th, "Aps", "getLocation getScanResultsParam");
    L170:
        l3 r4 = this.d;     // Catch: Throwable -> L99
        if (r4 == null) goto L101;
        r4.j(false, y());     // Catch: Throwable -> L99
    L101:
        String r5 = q(r19);
        this.w = r5;
        if (TextUtils.isEmpty(r5) == true) goto L104;
        this.x = f(this.x);
        s3 r6 = this.c;
        if (r6 == null) goto L112;
        if (r6.e == false) goto L112;
        es r7 = b(15, "networkLocation has been mocked!#1502");
        r19.h = "#1502";
        r7.setMock(true);
        r7.setTrustedLevel(4);
        return r7;
    L112:
        if (this.k != 0) goto L115;
    L116:
        boolean r12 = true;
    L118:
        l3 r13 = this.d;
        es r14 = null;
        if (r13 == null) goto L123;
        s3 r15 = this.c;
        if (r15 == null) goto L123;
        es r16 = this.e.c(r13, r12, this.j, r15, this.x, this.w, this.a, false);
    L125:
        if (j4.m(r16) == false) goto L127;
        r16.setTrustedLevel(2);
    L132:
        this.j = r16;
    L163:
        if (this.c == null) goto L155;
        HashMap<String, Long> r17 = s3.B;     // Catch: Throwable -> L154
        long r18 = ((SystemClock.elapsedRealtime() - s3.C) / 1000) + 1;     // Catch: Throwable -> L154
        if (r18 > 15) goto L147;
        r16.setTrustedLevel(1);     // Catch: Throwable -> L154
        goto L155
    L147:
        if (r18 > 120) goto L150;
        r16.setTrustedLevel(2);     // Catch: Throwable -> L154
        goto L155
    L150:
        if (r18 > 600) goto L152;
        r16.setTrustedLevel(3);     // Catch: Throwable -> L154
        goto L155
    L152:
        r16.setTrustedLevel(4);     // Catch: Throwable -> L154
    L155:
        this.e.h(this.w, this.x, r16, this.a, true);
        j4.m(r16);
        StringBuilder r20 = this.x;
        r20.delete(0, r20.length());
        if (this.C == false) goto L160;
        i3 r21 = this.B;
        if (r21 == null) goto L160;
        r16.setAltitude(r21.f);
        r16.setBearing(this.B.g);
        float r22 = (float) this.B.l;
    L161:
        r16.setSpeed(r22);
        this.j = r16;
        return r16;
    L160:
        r16.setAltitude(0.0d);
        r22 = 0.0f;
        r16.setBearing(0.0f);
        goto L161
    L127:
        r16 = n(true, r19);
        if (j4.m(r16) == false) goto L133;
        r16.P = "new";
        this.e.h = this.x.toString();
        l3 r23 = this.d;
        if (r23 == null) goto L132;
        this.e.i = r23.o();
        goto L132
    L133:
        l3 r110 = this.d;
        if (r110 == null) goto L139;
        s3 r111 = this.c;
        if (r111 == null) goto L139;
        r14 = this.e.c(r110, false, this.j, r111, this.x, this.w, this.a, true);
    L139:
        if (j4.m(r14) == false) goto L163;
        r19.h = "#0001";
        r14.setTrustedLevel(2);
        this.j = r14;
        r16 = r14;
    L123:
        r16 = null;
        goto L125
    L115:
        if ((SystemClock.elapsedRealtime() - this.k) > AutoEndConversationTime.AFTER_20_SECONDS) goto L116;
        r12 = false;
        goto L118
    L104:
        return b(this.z, this.q.toString());
    L99:
        th = move-exception;
        c4.g(th, "Aps", "getLocation getCgiListParam");
        goto L101
    L83:
        if (this.i.isOnceLocationLatest() == false) goto L85;
    L88:
        boolean r24 = true;
    L89:
        s3 r25 = this.c;     // Catch: Throwable -> L93
        if (r25 == null) goto L170;
        r25.d(r24);     // Catch: Throwable -> L93
        this.g = this.c.i();     // Catch: Throwable -> L93
        goto L170
    L85:
        if (this.i.isOnceLocation() == false) goto L88;
        r24 = false;
        goto L89
    L57:
        if (this.C == false) goto L81;
        SensorManager r26 = r11.a;
        if (r26 == null) goto L166;
        if (r11.e == true) goto L166;
        r11.e = true;
        Sensor r112 = r11.b;     // Catch: Throwable -> L67
        if (r112 == null) goto L168;
        i3.a(r26, r11, r112, r11.h);     // Catch: Throwable -> L67
    L168:
        Sensor r27 = r11.c;     // Catch: Throwable -> L73
        if (r27 == null) goto L172;
        i3.a(r11.a, r11, r27, r11.h);     // Catch: Throwable -> L73
    L172:
        Sensor r28 = r11.d;     // Catch: Throwable -> L79
        if (r28 == null) goto L166;
        i3.a(r11.a, r11, r28, r11.h);     // Catch: Throwable -> L79
    L79:
        th = move-exception;
        c4.g(th, "AMapSensorManager", "registerListener mAcceleroMeterVector");
    L73:
        th = move-exception;
        c4.g(th, "AMapSensorManager", "registerListener mRotationVector");
    L67:
        th = move-exception;
        c4.g(th, "AMapSensorManager", "registerListener mPressure");
        goto L168
    L81:
        r11.d();
        goto L166
    L46:
        if (j4.m(this.j) == false) goto L54;
        if (this.u == false) goto L53;
        if (com.loc.h.e(this.j.getTime()) == false) goto L53;
        this.j.setLocationType(2);
    L53:
        return this.j;
    L35:
        if ((SystemClock.elapsedRealtime() - r10) >= 800) goto L43;
        if (j4.m(this.j) == false) goto L39;
        long r29 = System.currentTimeMillis() - this.j.getTime();
    L41:
        if (r29 > AutoEndConversationTime.AFTER_10_SECONDS) goto L43;
        r3 = true;
        goto L44
    L39:
        r29 = 0;
        goto L41
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final es d(es r22) {
        es r1 = r22;
        f3 r2 = this.D;
        r2.d = this.u;
        if ((SystemClock.elapsedRealtime() - r2.f) <= AutoEndConversationTime.AFTER_30_SECONDS) goto L5;
        r2.a = r1;
        r2.f = SystemClock.elapsedRealtime();
        return r2.a;
    L5:
        r2.f = SystemClock.elapsedRealtime();
        if (j4.m(r2.a) == true) goto L8;
    L75:
        r2.b = SystemClock.elapsedRealtime();
        es r3 = r1;
    L76:
        r2.a = r3;
        return r3;
    L8:
        if (j4.m(r22) == false) goto L75;
        if (r22.getTime() != r2.a.getTime()) goto L16;
        if (r22.getAccuracy() >= 300.0f) goto L16;
        return r1;
    L16:
        if ("gps".equals(r22.getProvider()) == true) goto L75;
        if (r1.M != r2.a.M) goto L75;
        if (r22.getBuildingId() != null) goto L24;
    L28:
        r2.e = r22.getLocationType();
        float r4 = j4.a(r1, r2.a);
        float r5 = r2.a.getAccuracy();
        float r7 = r22.getAccuracy();
        float r8 = r7 - r5;
        long r10 = SystemClock.elapsedRealtime();
        long r12 = r10 - r2.b;
        boolean r14 = true;
        if (r5 <= 100.0f) goto L31;
    L33:
        boolean r18 = false;
    L35:
        if (r5 > 299.0f) goto L37;
    L39:
        r14 = false;
    L41:
        if (r18 == true) goto L68;
        if (r14 == true) goto L68;
        if (r7 >= 100.0f) goto L49;
        if (r5 <= 299.0f) goto L49;
    L73:
        r2.b = r10;
        r2.a = r1;
        r2.c = 0;
        return r1;
    L49:
        if (r7 > 299.0f) goto L52;
        r2.c = 0;
    L52:
        if (r4 >= 10.0f) goto L64;
        if (r4 <= 0.1d) goto L64;
        if (r7 <= 5.0f) goto L64;
        if (r8 < (-300.0f)) goto L61;
    L74:
        es r6 = r2.a;
        r2.c(r6);
        r3 = r6;
        goto L76
    L61:
        if ((r5 / r7) < 2.0f) goto L74;
        r2.b = r10;
        r3 = r1;
    L64:
        if (r8 < 300.0f) goto L75;
        if (r12 < AutoEndConversationTime.AFTER_30_SECONDS) goto L74;
    L68:
        long r9 = r2.c;
        if (r9 != 0) goto L72;
        r2.c = r10;
        goto L74
    L72:
        if ((r10 - r9) <= AutoEndConversationTime.AFTER_30_SECONDS) goto L74;
    L37:
        if (r7 <= 299.0f) goto L39;
    L31:
        if (r7 <= 299.0f) goto L33;
        r18 = true;
        goto L35
    L24:
        if (r22.getBuildingId().equals(r2.a.getBuildingId()) == true) goto L28;
        if (TextUtils.isEmpty(r22.getBuildingId()) == true) goto L28;
        goto L28
    }

    public final StringBuilder f(StringBuilder r15) {
        if (r15 != null) goto L5;
        r15 = new StringBuilder(700);
    L6:
        l3 r2 = this.d;
        if (r2 != null) goto L9;
    L85:
        return r15;
    L9:
        if (this.c == null) goto L85;
        monitor-enter(r2);
    L82:
        th = move-exception;
        throw th;
    L12:
        if (r2.o == false) goto L14;
        r2.p();     // Catch: Throwable -> L82
    L14:
        StringBuilder r3 = r2.p;     // Catch: Throwable -> L82
        if (r3 != null) goto L17;
        r2.p = new StringBuilder();     // Catch: Throwable -> L82
    L18:
        k3 r4 = r2.o();     // Catch: Throwable -> L82
        if (r4 == null) goto L21;
        int r5 = r4.l;     // Catch: Throwable -> L82
    L23:
        if ((r5 & 3) != 1) goto L29;
        int r6 = 1;
    L27:
        if (r6 >= r2.d.size()) goto L29;
        StringBuilder r7 = r2.p;     // Catch: Throwable -> L82
        r7.append("#");     // Catch: Throwable -> L82
        r7.append(((k3) ListProtector.get(r2.d, r6)).b);     // Catch: Throwable -> L82
        StringBuilder r8 = r2.p;     // Catch: Throwable -> L82
        r8.append("|");     // Catch: Throwable -> L82
        r8.append(((k3) ListProtector.get(r2.d, r6)).c);     // Catch: Throwable -> L82
        StringBuilder r9 = r2.p;     // Catch: Throwable -> L82
        r9.append("|");     // Catch: Throwable -> L82
        r9.append(((k3) ListProtector.get(r2.d, r6)).d);     // Catch: Throwable -> L82
        r6 = r6 + 1;     // Catch: Throwable -> L82
    L29:
        int r10 = 1;
    L31:
        if (r10 >= r2.f.size()) goto L48;
        k3 r11 = (k3) ListProtector.get(r2.f, r10);     // Catch: Throwable -> L82
        int r12 = r11.l;     // Catch: Throwable -> L82
        if (r12 == 1) goto L41;
        if (r12 == 3) goto L41;
        if (r12 == 4) goto L41;
        if (r12 == 5) goto L41;
        if (r12 != 2) goto L46;
        StringBuilder r13 = r2.p;     // Catch: Throwable -> L82
        r13.append("#");     // Catch: Throwable -> L82
        r13.append(r11.l);     // Catch: Throwable -> L82
        StringBuilder r14 = r2.p;     // Catch: Throwable -> L82
        r14.append("|");     // Catch: Throwable -> L82
        r14.append(r11.a);     // Catch: Throwable -> L82
        StringBuilder r16 = r2.p;     // Catch: Throwable -> L82
        r16.append("|");     // Catch: Throwable -> L82
        r16.append(r11.h);     // Catch: Throwable -> L82
        StringBuilder r17 = r2.p;     // Catch: Throwable -> L82
        r17.append("|");     // Catch: Throwable -> L82
        r17.append(r11.i);     // Catch: Throwable -> L82
        StringBuilder r18 = r2.p;     // Catch: Throwable -> L82
        r18.append("|");     // Catch: Throwable -> L82
        r18.append(r11.j);     // Catch: Throwable -> L82
    L46:
        r10 = r10 + 1;     // Catch: Throwable -> L82
    L41:
        StringBuilder r19 = r2.p;     // Catch: Throwable -> L82
        r19.append("#");     // Catch: Throwable -> L82
        r19.append(r11.l);     // Catch: Throwable -> L82
        StringBuilder r20 = r2.p;     // Catch: Throwable -> L82
        r20.append("|");     // Catch: Throwable -> L82
        r20.append(r11.a);     // Catch: Throwable -> L82
        StringBuilder r21 = r2.p;     // Catch: Throwable -> L82
        r21.append("|");     // Catch: Throwable -> L82
        r21.append(r11.b);     // Catch: Throwable -> L82
        StringBuilder r22 = r2.p;     // Catch: Throwable -> L82
        r22.append("|");     // Catch: Throwable -> L82
        r22.append(r11.c);     // Catch: Throwable -> L82
        StringBuilder r23 = r2.p;     // Catch: Throwable -> L82
        r23.append("|");     // Catch: Throwable -> L82
        if (r11.l != 5) goto L44;
        long r24 = r11.e;     // Catch: Throwable -> L82
    L45:
        r23.append(r24);     // Catch: Throwable -> L82
        goto L46
    L44:
        r24 = r11.d;     // Catch: Throwable -> L82
        goto L45
    L48:
        if (r2.p.length() <= 0) goto L50;
        r2.p.deleteCharAt(0);     // Catch: Throwable -> L82
    L50:
        String r25 = r2.p.toString();     // Catch: Throwable -> L82
        monitor-exit(r2);
        r15.append(r25);
        s3 r26 = this.c;
        StringBuilder r27 = r26.f;
        if (r27 != null) goto L55;
        r26.f = new StringBuilder(700);
    L56:
        r26.e = false;
        int r0 = r26.b.size();
        int r28 = 0;
        boolean r29 = false;
        boolean r30 = false;
    L57:
        if (r28 >= r0) goto L71;
        String r31 = v2.b(((v2) ListProtector.get(r26.b, r28)).a);
        if (r26.h == true) goto L64;
        if ("<unknown ssid>".equals(((v2) ListProtector.get(r26.b, r28)).b) == true) goto L64;
        r29 = true;
    L64:
        if (TextUtils.isEmpty(r26.q) == false) goto L66;
    L68:
        boolean r32 = r30;
        String r33 = "nb";
    L69:
        r26.f.append(String.format(Locale.US, "#%s,%s", new Object[]{r31, r33}));
        r28 = r28 + 1;
        r30 = r32;
        goto L57
    L66:
        if (r26.q.equals(r31) == false) goto L68;
        r33 = "access";
        r32 = true;
        goto L69
    L71:
        if (r26.b.size() != 0) goto L74;
        r29 = true;
    L74:
        if (r26.h == true) goto L77;
        if (r29 == true) goto L77;
        r26.e = true;
    L77:
        if (r30 == false) goto L79;
    L81:
        r15.append(r26.f.toString());
        goto L85
    L79:
        if (TextUtils.isEmpty(r26.q) == true) goto L81;
        StringBuilder r1 = r26.f;
        r1.append("#");
        r1.append(r26.q);
        r26.f.append(",access");
        goto L81
    L55:
        r27.delete(0, r27.length());
        goto L56
    L21:
        r5 = 0;
        goto L23
    L17:
        r3.delete(0, r3.length());     // Catch: Throwable -> L82
        goto L18
    L5:
        r15.delete(0, r15.length());
        goto L6
    }

    public final void h(AMapLocation r4) {
        if (r4.getErrorCode() == 0) goto L5;
        return;
    L5:
        m3 r0 = new m3();
        r0.a = r4.getLocationType();
        r0.d = r4.getTime();
        r0.e = (int) r4.getAccuracy();
        r0.b = r4.getLatitude();
        r0.c = r4.getLongitude();
        if (r4.getLocationType() != 1) goto L9;
        this.G.b(r0, 1);
    L9:
        if (r4.getLocationType() != 12) goto L12;
        this.G.b(r0, 12);
        return;
    }

    public final void i(AMapLocationClientOption r7) {
        this.i = r7;
        if (r7 != null) goto L5;
        this.i = new AMapLocationClientOption();
    L5:
        s3 r0 = this.c;
        if (r0 == null) goto L11;
        this.i.isWifiActiveScan();
        boolean r1 = this.i.isWifiScan();
        boolean r2 = this.i.isMockEnable();
        boolean r3 = AMapLocationClientOption.isOpenAlwaysScanWifi();
        long r4 = r7.getScanWifiInterval();
        r0.g = r1;
        r0.h = r2;
        r0.i = r3;
        if (r4 >= AutoEndConversationTime.AFTER_10_SECONDS) goto L10;
        r0.t = AutoEndConversationTime.AFTER_10_SECONDS;
        goto L11
    L10:
        r0.t = r4;
    L11:
        v();
        u3 r8 = this.e;
        if (r8 == null) goto L14;
        AMapLocationClientOption r5 = this.i;
        r8.getClass();
        r8.m = r5.isNeedAddress();
        r8.l = r5.isOffset();
        r8.f = r5.isLocationCacheEnable();
        r8.n = String.valueOf(r5.getGeoLanguage());
    L14:
        z3 r9 = this.f;
        if (r9 == null) goto L20;
        AMapLocationClientOption r6 = this.i;
        if (r6 != null) goto L19;
        r9.getClass();
        r9.b = new AMapLocationClientOption();
        goto L20
    L19:
        r9.b = r6;
    L20:
        l3 r10 = this.d;
        if (r10 == null) goto L23;
        r10.u = this.i.isNoLocReqCgiEnable();
    L23:
        AMapLocationClientOption.GeoLanguage r11 = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean r12 = true;
        r11 = this.i.getGeoLanguage();     // Catch: Throwable -> L44
        boolean r13 = this.i.isNeedAddress();     // Catch: Throwable -> L44
        boolean r14 = this.i.isOffset();     // Catch: Throwable -> L49
        r12 = this.i.isLocationCacheEnable();     // Catch: Throwable -> L48
        this.v = this.i.isOnceLocationLatest();     // Catch: Throwable -> L48
        this.C = this.i.isSensorEnable();     // Catch: Throwable -> L48
        if (r14 == this.s) goto L29;
    L50:
        u3 r15 = this.e;     // Catch: Throwable -> L41
        if (r15 == null) goto L37;
        r15.g = 0;     // Catch: Throwable -> L41
        r15.h = null;     // Catch: Throwable -> L41
    L37:
        this.A = false;     // Catch: Throwable -> L41
        f3 r16 = this.D;     // Catch: Throwable -> L41
        if (r16 == null) goto L46;
        r16.b();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        c4.g(th, "Aps", "cleanCache");     // Catch: Throwable -> L48
        goto L46
    L29:
        if (r13 != this.r) goto L50;
        if (r12 != this.u) goto L50;
        if (r11 != this.t) goto L50;
    L46:
        this.s = r14;
        this.r = r13;
        this.u = r12;
        this.t = r11;
        return;
    L45:
        r14 = true;
    L44:
        r13 = true;
        goto L45
    }

    public final void k(boolean r4) {
        l3 r0 = this.d;
        if (r0 == null) goto L26;
        r0.t = r4;
        if (r0.u == true) goto L27;
        if (r4 == true) goto L8;
    L10:
        if (r4 == false) goto L12;
        return;
    L12:
        if (r0.v == false) goto L30;
        TelephonyManager r5 = r0.g;
        if (r5 == null) goto L22;
        l3.b r1 = r0.j;
        if (r1 == null) goto L22;
        r5.listen(r1, 0);     // Catch: Throwable -> L20
        r0.v = false;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        c4.g(th, "CgiManager", "destroy");
    L22:
        r0.j = null;
        return;
    L30:
        return;
    L8:
        if (r0.v == true) goto L10;
        r0.q();
        return;
    L27:
        return;
    }

    public final es m(boolean r7) {
        s3 r0 = this.c;
        if (r0 == null) goto L10;
        if (r0.e == false) goto L10;
        int r8 = 15;
        String r1 = "networkLocation has been mocked!#1502";
    L8:
        return b(r8, r1);
    L10:
        if (TextUtils.isEmpty(this.w) == false) goto L12;
        r8 = this.z;
        r1 = this.q.toString();
        goto L8
    L12:
        es r9 = this.e.a(this.a, this.w, this.x, true, r7);
        if (j4.m(r9) == false) goto L16;
        if (r9 == null) goto L16;
        this.j = r9;
    L16:
        return r9;
    }

    public final void o(em r5) {
    L25:
        th = move-exception;
        c4.g(th, "Aps", "initFirstLocateParam");
    L27:
        this.y = true;
        return;
    L4:
        if (this.y == false) goto L7;
        return;
    L7:
        if (this.w == null) goto L9;
        this.w = null;     // Catch: Throwable -> L25
    L9:
        StringBuilder r1 = this.x;     // Catch: Throwable -> L25
        if (r1 == null) goto L13;
        r1.delete(0, r1.length());     // Catch: Throwable -> L25
    L13:
        if (this.v == false) goto L15;
        w();     // Catch: Throwable -> L25
    L15:
        s3 r2 = this.c;     // Catch: Throwable -> L25
        if (r2 == null) goto L18;
        r2.d(this.v);     // Catch: Throwable -> L25
        this.g = this.c.i();     // Catch: Throwable -> L25
    L18:
        l3 r3 = this.d;     // Catch: Throwable -> L25
        if (r3 == null) goto L21;
        r3.j(true, y());     // Catch: Throwable -> L25
    L21:
        String r6 = q(r5);     // Catch: Throwable -> L25
        this.w = r6;     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r6) == true) goto L27;
        this.x = f(this.x);     // Catch: Throwable -> L25
        goto L27
    }

    public final String q(em r18) {
        String r3 = NameKeys.UnloadStrategy_No_Strategy;
        l3 r4 = this.d;
        if (r4 != null) goto L5;
    L230:
        return NameKeys.UnloadStrategy_No_Strategy;
    L5:
        if (this.c == null) goto L230;
        k3 r5 = r4.o();
        boolean r6 = false;
        if (r5 == null) goto L10;
        int r7 = r5.l;
    L11:
        int r8 = r7 & 3;
        k3 r9 = this.d.o();
        l3 r10 = this.d;
        monitor-enter(r10);
    L227:
        th = move-exception;
        throw th;
    L14:
        if (r10.o == true) goto L27;
        ArrayList<k3> r11 = r10.f;     // Catch: Throwable -> L227
        if (r11.size() <= 0) goto L27;
        Iterator<k3> r12 = r11.iterator();     // Catch: Throwable -> L227
    L20:
        if (r12.hasNext() == false) goto L24;
        k3 r13 = r12.next();     // Catch: Throwable -> L227
        if (r13.m == false) goto L20;
        k3 r14 = r13.c();     // Catch: Throwable -> L227
    L25:
        monitor-exit(r10);
    L29:
        ArrayList<v2> r15 = this.g;
        if (r15 != null) goto L32;
    L35:
        boolean r16 = true;
    L36:
        if (r9 != null) goto L154;
        if (r14 != null) goto L154;
        if (r16 == false) goto L154;
        if (this.b != null) goto L43;
        this.b = (ConnectivityManager) j4.e(this.a, "connectivity");
    L43:
        if (j4.y() < 31) goto L51;
        if (j4.i(this.a) == false) goto L57;
        if (this.c.n == true) goto L57;
        this.z = 18;
        this.q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
        h4.k(null, 2132);
        r18.h = "#1802";
        return NameKeys.UnloadStrategy_No_Strategy;
    L57:
        if (j4.y() >= 28) goto L59;
    L65:
        Context r0 = this.a;
        if (Build.VERSION.SDK_INT >= 23) goto L68;
    L78:
        String[] r17 = M;
        int r19 = r17.length;
        int r20 = 0;
    L79:
        if (r20 >= r19) goto L84;
        if (r0.checkCallingOrSelfPermission(r17[r20]) != 0) goto L82;
        r20 = r20 + 1;
    L82:
        boolean r1 = false;
    L85:
        if (r1 == true) goto L89;
        this.z = 12;
        this.q.append("定位权限被禁用,请授予应用定位权限#1201");
        r18.h = "#1201";
        h4.k(null, 2121);
        return NameKeys.UnloadStrategy_No_Strategy;
    L89:
        if (j4.y() >= 24) goto L91;
    L96:
        String r2 = this.d.s;
        s3 r21 = this.c;
        String r22 = r21.k;
        if (r21.b(this.b) == false) goto L101;
        if (r22 == null) goto L101;
        this.z = 12;
        r18.h = "#1202";
        this.q.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
        h4.k(null, 2121);
        return NameKeys.UnloadStrategy_No_Strategy;
    L101:
        if (r2 == null) goto L109;
        this.z = 12;
        if (this.c.m == true) goto L105;
        r18.h = "#1204";
        StringBuilder r23 = this.q;
        String r24 = "WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204";
    L106:
        r23.append(r24);
        h4.k(null, 2121);
        return NameKeys.UnloadStrategy_No_Strategy;
    L105:
        r18.h = "#1205";
        r23 = this.q;
        r24 = "获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205";
        goto L106
    L109:
        if (this.c.m == true) goto L140;
        l3 r25 = this.d;
        r25.getClass();
        TelephonyManager r26 = r25.g;     // Catch: Throwable -> L231
        if (r26 == null) goto L236;
        if (TextUtils.isEmpty(l3.m(r26)) == false) goto L135;
        if (TextUtils.isEmpty(r25.g.getSimCountryIso()) == true) goto L236;
    L135:
        r6 = true;
    L137:
        if (r6 == true) goto L140;
        this.z = 19;
        r18.h = "#1901";
        this.q.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
        h4.k(null, 2133);
        return NameKeys.UnloadStrategy_No_Strategy;
    L236:
        NetworkInfo r27 = x4.s(r25.a);     // Catch: Throwable -> L122
    L125:
        int r28 = j4.d(r27);     // Catch: Throwable -> L136
        if (r28 == 0) goto L135;
        if (r28 == 4) goto L135;
        if (r28 == 2) goto L135;
        if (r28 == 5) goto L135;
        if (r28 != 3) goto L137;
    L122:
        th = move-exception;
        c4.g(th, "Utils", "getNetWorkInfo");     // Catch: Throwable -> L136
        r27 = null;
    L140:
        s3 r29 = this.c;
        if (r29.m == true) goto L143;
        r18.h = "#1301";
        StringBuilder r30 = this.q;
        String r31 = "获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301";
    L152:
        r30.append(r31);
        this.z = 13;
        h4.k(null, 2131);
        return NameKeys.UnloadStrategy_No_Strategy;
    L143:
        r18.h = "#1302";
        if (r29.e() == null) goto L148;
        this.q.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
        if (j4.E(this.a) == false) goto L150;
    L151:
        r30 = this.q;
        r31 = "#1302";
    L150:
        this.q.append("或后台运行没有后台定位权限");
        goto L151
    L148:
        this.q.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
        if (j4.E(this.a) == true) goto L151;
    L91:
        if (j4.y() >= 28) goto L96;
        if (Settings.Secure.getInt(this.a.getContentResolver(), "location_mode", 0) != 0) goto L96;
        this.z = 12;
        r18.h = "#1206";
        this.q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        h4.k(null, 2121);
        return NameKeys.UnloadStrategy_No_Strategy;
    L84:
        r1 = true;
        goto L85
    L68:
        if (r0.getApplicationInfo().targetSdkVersion < 23) goto L78;
        Application r32 = (Application) r0;
        String[] r33 = M;
        int r110 = r33.length;
        int r111 = 0;
    L70:
        if (r111 >= r110) goto L84;
        int r34 = ((Integer) f4.c(r32.getBaseContext(), "checkSelfPermission", new Object[]{r33[r111]})).intValue();     // Catch: Throwable -> L74
    L75:
        if (r34 != 0) goto L82;
        r111 = r111 + 1;
    L74:
        r34 = 0;
        goto L75
    L59:
        if (this.J != null) goto L62;
        this.J = (LocationManager) this.a.getApplicationContext().getSystemService("location");
    L62:
        if (((Boolean) f4.c(this.J, "isLocationEnabled", new Object[0])).booleanValue() == true) goto L65;
        this.z = 12;
        this.q.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
        r18.h = "#1206";
        h4.k(null, 2121);
        return NameKeys.UnloadStrategy_No_Strategy;
    L51:
        if (j4.i(this.a) == false) goto L57;
        if (this.c.m == true) goto L57;
        this.z = 18;
        this.q.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
        h4.k(null, 2132);
        r18.h = "#1801";
        return NameKeys.UnloadStrategy_No_Strategy;
    L154:
        boolean r35 = s3.c(this.c.j());
        if (r8 == 0) goto L173;
        if (r8 != 1) goto L158;
        if (r9 == null) goto L217;
        StringBuilder r36 = new StringBuilder();
        r36.append(r9.a);
        r36.append("#");
        r36.append(r9.b);
        r36.append("#");
        r36.append(r9.c);
        r36.append("#");
        r36.append(r9.d);
        r36.append("#network#");
        if (this.g.isEmpty() == false) goto L171;
        if (r35 == true) goto L171;
    L170:
        String r37 = "cgi";
    L210:
        r36.append(r37);
        r3 = r36.toString();
    L171:
        r37 = "cgiwifi";
    L217:
        if (TextUtils.isEmpty(r3) == false) goto L219;
        return r3;
    L219:
        if (r3.startsWith("#") == true) goto L221;
        r3 = "#".concat(r3);
    L221:
        StringBuilder r38 = new StringBuilder();
        String r39 = y4.d("S128DF1572465B890OE3F7A13167KLEI".getBytes("UTF-8")).substring(20);     // Catch: Throwable -> L224
    L225:
        r38.append(r39);
        r38.append(r3);
        return r38.toString();
    L224:
        r39 = NameKeys.UnloadStrategy_No_Strategy;
        goto L225
    L158:
        if (r8 == 2) goto L160;
        this.z = 11;
        h4.k(null, 2111);
        r18.h = "#1101";
        this.q.append("get cgi failure#1101");
        goto L217
    L160:
        if (r9 == null) goto L217;
        r36 = new StringBuilder();
        r36.append(r9.a);
        r36.append("#");
        r36.append(r9.b);
        r36.append("#");
        r36.append(r9.h);
        r36.append("#");
        r36.append(r9.i);
        r36.append("#");
        r36.append(r9.j);
        r36.append("#network#");
        if (this.g.isEmpty() == false) goto L171;
        if (r35 == false) goto L170;
    L173:
        if (this.g.isEmpty() == false) goto L177;
        if (r35 == true) goto L177;
        boolean r40 = false;
    L178:
        if (r14 == null) goto L180;
        boolean r41 = true;
    L182:
        if (r41 == false) goto L184;
    L199:
        String r42 = String.format(Locale.US, "#%s#", new Object[]{CloudControlInf.NETWORK});
        if (r41 == false) goto L208;
        r36 = new StringBuilder();
        r36.append(r14.a());
        if (this.g.isEmpty() == false) goto L206;
        if (r35 == true) goto L206;
        r37 = "cgi";
    L207:
        r36.append("network#");
    L206:
        r37 = "cgiwifi";
        goto L207
    L208:
        if (r40 == false) goto L211;
        StringBuilder r43 = new StringBuilder();
        r43.append(r42);
        r37 = "wifi";
        r36 = r43;
        goto L210
    L211:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        this.z = 2;
        if (this.c.m == true) goto L214;
        r18.h = "#0203";
        StringBuilder r44 = this.q;
        String r45 = "当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203";
    L215:
        r44.append(r45);
        h4.k(null, MessageContentType.CONTENT_TYPE_CREATION);
        goto L217
    L214:
        r18.h = "#0204";
        r44 = this.q;
        r45 = "当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204";
        goto L215
    L184:
        if (r35 == false) goto L190;
        if (this.g.isEmpty() == false) goto L190;
        this.z = 2;
        r18.h = "#0201";
        this.q.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
        h4.k(null, MessageContentType.CONTENT_TYPE_VIDEO_GENERATE);
        return NameKeys.UnloadStrategy_No_Strategy;
    L190:
        if (this.g.size() != 1) goto L199;
        this.z = 2;
        if (r35 == true) goto L196;
        r18.h = "#0202";
        this.q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
        h4.k(null, MessageContentType.CONTENT_TYPE_CREATION);
        return NameKeys.UnloadStrategy_No_Strategy;
    L196:
        if (((v2) ListProtector.get(this.g, 0)).h == false) goto L199;
        r18.h = "#0202";
        this.q.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
        h4.k(null, MessageContentType.CONTENT_TYPE_VIDEO_GENERATE);
        return NameKeys.UnloadStrategy_No_Strategy;
    L180:
        r41 = false;
    L177:
        r40 = true;
        goto L178
    L32:
        if (r15.isEmpty() == true) goto L35;
        r16 = false;
        goto L36
    L24:
        r14 = ((k3) ListProtector.get(r11, 0)).c();     // Catch: Throwable -> L227
    L27:
        monitor-exit(r10);
        r14 = null;
        goto L29
    L10:
        r7 = 0;
        goto L11
    }

    public final es e(boolean r3, em r4) {
        if (r3 == false) goto L4;
        String r0 = "statics";
    L5:
        r4.g = r0;
        if (this.a != null) goto L9;
        r4.h = "#0101";
        this.q.append("context is null#0101");
        h4.k(null, 2011);
        return b(1, this.q.toString());
    L9:
        s3 r1 = this.c;
        if (r1 != null) goto L12;
    L15:
        p();
        if (TextUtils.isEmpty(this.w) == true) goto L18;
        es r5 = n(r3, r4);
        if (j4.m(r5) == true) goto L22;
    L27:
        N = true;
        return r5;
    L22:
        if (N == true) goto L27;
        u3 r6 = this.e;
        r6.h = this.x.toString();
        l3 r7 = this.d;
        if (r7 == null) goto L26;
        u3 r2 = this.e;
        r2.i = r7.o();
    L26:
        this.j = r5;
        goto L27
    L18:
        return b(this.z, this.q.toString());
    L12:
        if (r1.e == false) goto L15;
        r4.h = "#1502";
        return b(15, "networkLocation has been mocked!#1502");
    L4:
        r0 = "first";
        goto L5
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(es r10, int r11) {
        if (r10 != 0) goto L5;
        return;
    L5:
        if (r10.getErrorCode() == 0) goto L7;
        return;
    L7:
        m3 r0 = new m3();
        r0.d = r10.getTime();
        r0.e = (int) r10.getAccuracy();
        r0.b = r10.getLatitude();
        r0.c = r10.getLongitude();
        r0.a = r11;
        r0.f = CastIntegerProtector.parseInt(r10.N);
        r0.g = r10.O;
        n3 r12 = this.G;
        if (r12.a.size() <= 0) goto L30;
        int r13 = r0.a;
        if (r13 != 6) goto L12;
    L19:
        m3 r14 = r12.a.getLast();
        if (r14.c != r0.c) goto L26;
        if (r14.b != r0.b) goto L26;
        if (r14.e != r0.e) goto L26;
        return;
    L26:
        if (r12.a.size() < 10) goto L28;
    L27:
        r12.a.removeFirst();
    L28:
        r12.a.add(r0);
        r12.f = true;
        return;
    L12:
        if (r13 == 5) goto L19;
        if (r12.a.contains(r0) == false) goto L17;
        return;
    L17:
        if (r12.a.size() < 10) goto L28;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Object, n4a.z3] */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.amap.api.location.AMapLocation] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v22, types: [com.loc.es] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.loc.es] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.location.Location, com.amap.api.location.AMapLocation, com.loc.es] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.amap.api.location.AMapLocation, com.loc.es] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final es n(boolean r25, em r26) {
        b3 r1 = this;
        if (TextUtils.isEmpty(r1.K) == false) goto L6;
        r1.K = f5.k(x4.j(r1.a) + "," + x4.q(r1.a));     // Catch: Throwable -> L326
    L6:
        StringBuilder r0 = r1.q;     // Catch: Throwable -> L326
        r0.append("#id:");     // Catch: Throwable -> L326
        r0.append(r1.K);     // Catch: Throwable -> L326
    L7:
        ?? r8 = new es();
        byte[] r11 = x();     // Catch: Throwable -> L324
        long r9 = SystemClock.elapsedRealtime();
        r1.k = r9;
        r26.c = r9;
    L286:
        th = th;
    L287:
        int r2 = 1;
        NetworkInfo r3 = null;
        boolean r10 = false;
        int r12 = 4;
        com.loc.l r13 = th;
    L288:
        SystemClock.elapsedRealtime();
        r26.f = "FAIL";
        com.loc.f.a(r1.a).c(r10, r2);
        c4.g(r13, "Aps", "getApsLoc req");
        List<r0> r4 = h4.g;
        if ((r13 instanceof com.loc.l) == false) goto L353;
        e5 r14 = c4.k();     // Catch: Throwable -> L340
        com.loc.l r5 = r13;     // Catch: Throwable -> L340
        Set<Integer> r6 = r.e;     // Catch: Throwable -> L340
        r.d(r14, "/mobile/binary", r5.c(), r5.d(), r5.e(), r5.b());     // Catch: Throwable -> L340
    L353:
        NetworkInfo r15 = x4.s(r1.a);     // Catch: Throwable -> L295
    L298:
        if (r15 == null) goto L303;
        if (r15.isConnectedOrConnecting() == false) goto L303;
        boolean r16 = true;
    L304:
        if (r16 == true) goto L307;
        r26.h = "#0401";
        StringBuilder r7 = r1.q;
        String r17 = "网络异常，未连接到网络，请连接网络#0401";
    L318:
        r7.append(r17);
    L321:
        es r18 = b(r12, r1.q.toString());
    L322:
        r18.V = r1.x.toString();
        return r18;
    L307:
        if ((r13 instanceof com.loc.l) == false) goto L319;
        com.loc.l r19 = r13;
        if (r19.a().contains("网络异常状态码") == false) goto L312;
        r26.h = "#0404";
        StringBuilder r20 = r1.q;
        r20.append("网络异常，状态码错误#0404");
        r20.append(r19.f());
        goto L321
    L312:
        if (r19.f() != 23) goto L314;
    L317:
        r26.h = "#0402";
        r7 = r1.q;
        r17 = "网络异常，连接超时#0402";
        goto L318
    L314:
        if (Math.abs((SystemClock.elapsedRealtime() - r1.k) - r1.i.getHttpTimeOut()) < 500) goto L317;
        StringBuilder r21 = new StringBuilder("#0403,");
    L320:
        r21.append(r13.getMessage());
        r26.h = r21.toString();
        r1.q.append("网络异常,请求异常#0403");
        goto L321
    L319:
        r21 = new StringBuilder("#0403,");
        goto L320
    L295:
        th = move-exception;
        c4.g(th, "Utils", "getNetWorkInfo");     // Catch: Throwable -> L302
        r15 = r3;
    L303:
        r16 = false;
        goto L304
    L366:
    L16:
        th = move-exception;
        c4.g(th, "CoreUtil", "changeUrl");     // Catch: Throwable -> L286
    L18:
        y3 r22 = r1.p.b(r1.a, r11, c4.c, c4.d, r25);     // Catch: Throwable -> L286
        r22.getClass();     // Catch: Throwable -> L286
        String r23 = r22.q;     // Catch: Throwable -> L286
        Context r110 = r1.a;     // Catch: Throwable -> L286
        int r111 = com.loc.i.a;     // Catch: Throwable -> L284
        if (r110 == null) goto L23;
        com.loc.i.c = r110.getApplicationContext();     // Catch: Throwable -> L284
    L23:
        if (TextUtils.isEmpty(r23) == false) goto L357;
    L29:
        boolean r112 = false;
    L32:
        if (com.loc.i.m() == true) goto L34;
    L37:
        int r113 = 1;
    L39:
        if (com.loc.i.s() == true) goto L41;
        String r24 = com.loc.f.a(r1.a).b(r22, r113);     // Catch: Throwable -> L27
    L42:
        if (r113 != 2) goto L45;
        String r114 = "v6";
    L46:
        r26.i = r114;     // Catch: Throwable -> L286
        if (r1.p.c == false) goto L49;
        r22.b(bo.c.b);     // Catch: Throwable -> L27
    L49:
        l0 r115 = com.loc.c.a(r22);     // Catch: Throwable -> L286
        long r116 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L286
        if (TextUtils.isEmpty(r24) == true) goto L60;
        if (r115.e == true) goto L54;
        com.loc.f.a(r1.a).c(true, r113);     // Catch: Throwable -> L27
        goto L60
    L54:
        com.loc.f.a(r1.a).c(false, r113);     // Catch: Throwable -> L27
        com.loc.f r27 = com.loc.f.a(r1.a);     // Catch: Throwable -> L27
        if (r27.f(r113).e == true) goto L57;
        r27.b.add(r27.f(r113).b);     // Catch: Throwable -> L27
        r27.i(r113);     // Catch: Throwable -> L27
        r27.h(true, r113);     // Catch: Throwable -> L27
        goto L60
    L57:
        r27.i(r113);     // Catch: Throwable -> L27
    L60:
        if (TextUtils.isEmpty(r24) == false) goto L62;
    L65:
        r26.f = "SUCCESS";     // Catch: Throwable -> L286
    L66:
        d3 r28 = r1.L;     // Catch: Throwable -> L286
        if (r28 == null) goto L69;
        r28.d();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r13 = th;
        r2 = 1;
        r3 = null;
        r10 = false;
        r12 = 4;
    L69:
        r26.d = r116;
        if (TextUtils.isEmpty(r115.c) == true) goto L72;
        r1.q.append("#csid:" + r115.c);
    L72:
        String r29 = r115.d;
        r8.V = r1.x.toString();
        byte[] r30 = r115.a;     // Catch: Throwable -> L115
        if (r30 != null) goto L407;
        byte[] r117 = null;
        int r118 = 4;
    L372:
        r8.setErrorCode(r118);     // Catch: Throwable -> L113
        r1.q.append("网络异常,请求异常#0403");     // Catch: Throwable -> L113
        r26.h = "#0403";     // Catch: Throwable -> L113
        r8.V = r1.x.toString();     // Catch: Throwable -> L113
        r8.setLocationDetail(r1.q.toString());     // Catch: Throwable -> L113
        h4.k(r115.d, 2041);     // Catch: Throwable -> L113
    L112:
        ?? r31 = r8;
    L119:
        if (r31 == 0) goto L121;
        return r31;
    L121:
        byte[] r32 = r115.a;
        char[] r33 = t3.a;
        byte[] r34 = new byte[16];     // Catch: Throwable -> L128
        byte[] r35 = new byte[r32.length - 16];     // Catch: Throwable -> L128
        System.arraycopy(r32, 0, r34, 0, 16);     // Catch: Throwable -> L126
        System.arraycopy(r32, 16, r35, 0, r32.length - 16);     // Catch: Throwable -> L126
        SecretKeySpec r36 = new SecretKeySpec(r34, "AES");     // Catch: Throwable -> L126
        Cipher r37 = Cipher.getInstance("AES/CBC/PKCS5Padding");     // Catch: Throwable -> L126
        r37.init(2, r36, new IvParameterSpec(f5.p()));     // Catch: Throwable -> L126
        byte[] r38 = r37.doFinal(r35);     // Catch: Throwable -> L126
    L134:
        if (r38 != null) goto L137;
        r8.setErrorCode(5);
        r26.h = "#0503";
        r1.q.append("解密数据失败#0503");
        r8.setLocationDetail(r1.q.toString());
        h4.k(r29, 2053);
        return r8;
    L137:
        ?? r39 = r1.f;
        r39.getClass();
        ByteBuffer r40 = ByteBuffer.wrap(r38);     // Catch: Throwable -> L238
    L235:
        th = th;
        String r210 = r29;
        String r41 = "#0505";
    L234:
        int r42 = 0;
    L237:
        ByteBuffer r119 = r40;
    L385:
        es r43 = new es();     // Catch: Throwable -> L279
        r43.setErrorCode(5);     // Catch: Throwable -> L279
        r26.h = r41;     // Catch: Throwable -> L279
        r39.a.append("parser data error:" + th.getMessage() + r41);     // Catch: Throwable -> L279
        h4.k(null, 2054);     // Catch: Throwable -> L279
        r43.setLocationDetail(r39.a.toString());     // Catch: Throwable -> L279
        if (r119 == null) goto L243;
        r119.clear();
    L243:
        ?? r44 = r43;
    L244:
        ?? r45 = r44;
        if (r39.a.length() <= 0) goto L247;
        StringBuilder r46 = r39.a;
        r46.delete(r42, r46.length());
        r45 = r44;
    L247:
        int r47 = 6;
        if (j4.m(r45) == true) goto L260;
        String r48 = r45.L;
        this.o = r48;
        if (TextUtils.isEmpty(r48) == true) goto L252;
        int r49 = 2062;
    L253:
        h4.k(r210, r49);
        r45.setErrorCode(6);
        r26.h = "#0601";
        StringBuilder r50 = this.q;
        StringBuilder r51 = new StringBuilder("location faile retype:");
        r51.append(r45.N);
        r51.append(" rdesc:");
        if (TextUtils.isEmpty(this.o) == false) goto L256;
        String r52 = NameKeys.UnloadStrategy_No_Strategy;
    L257:
        r51.append(r52);
        r51.append("#0601");
        r50.append(r51.toString());
        r45.V = this.x.toString();
        r45.setLocationDetail(this.q.toString());
        return r45;
    L256:
        r52 = this.o;
        goto L257
    L252:
        r49 = 2061;
        goto L253
    L260:
        if (r45.getErrorCode() == 0) goto L262;
    L277:
        r45.setOffset(this.s);
        r45.S = this.r;
        r45.T = String.valueOf(this.t);
        r45.P = "new";
        r45.setLocationDetail(this.q.toString());
        this.E = r45.K;
        return r45;
    L262:
        if (r45.getLocationType() != 0) goto L277;
        if ("-5".equals(r45.N) == false) goto L266;
    L275:
        r47 = 5;
    L276:
        r45.setLocationType(r47);
        goto L277
    L266:
        if ("1".equals(r45.N) == true) goto L275;
        if (RiskPreferenceSettings.SMART_BALANCE.equals(r45.N) == true) goto L275;
        if ("14".equals(r45.N) == true) goto L275;
        if ("24".equals(r45.N) == true) goto L275;
        if ("-1".equals(r45.N) == false) goto L276;
    L279:
        th = move-exception;
        if (r119 == null) goto L283;
        r119.clear();
    L283:
        throw th;
    L140:
        if (r40.get() == 0) goto L383;
        r8.setLongitude(j4.s(((double) r40.getInt()) / 1000000.0d));     // Catch: Throwable -> L235
        r8.setLatitude(j4.s(((double) r40.getInt()) / 1000000.0d));     // Catch: Throwable -> L235
        r8.setAccuracy(r40.getShort());     // Catch: Throwable -> L235
        r8.r(String.valueOf(r40.get()));     // Catch: Throwable -> L235
        r8.N = String.valueOf(r40.get());     // Catch: Throwable -> L235
        if (r40.get() != 1) goto L190;
        byte[] r53 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r53);     // Catch: Throwable -> L235
        r8.setCountry(new String(r53, "UTF-8"));     // Catch: Throwable -> L327
    L149:
        byte[] r54 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r54);     // Catch: Throwable -> L235
        String r55 = new String(r54, "UTF-8");     // Catch: Throwable -> L153
        r8.setProvince(r55);     // Catch: Throwable -> L328
    L152:
        String r56 = r55;
    L154:
        byte[] r57 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r57);     // Catch: Throwable -> L235
        String r120 = new String(r57, "UTF-8");     // Catch: Throwable -> L158
        r8.setCity(r120);     // Catch: Throwable -> L329
    L157:
        String r121 = r120;
    L159:
        byte[] r58 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r58);     // Catch: Throwable -> L235
        String r122 = new String(r58, "UTF-8");     // Catch: Throwable -> L163
        r8.setDistrict(r122);     // Catch: Throwable -> L330
    L162:
        String r123 = r122;
    L164:
        byte[] r59 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r59);     // Catch: Throwable -> L235
        String r124 = new String(r59, "UTF-8");     // Catch: Throwable -> L168
        r8.setStreet(r124);     // Catch: Throwable -> L331
        r8.setRoad(r124);     // Catch: Throwable -> L331
    L167:
        String r125 = r124;
    L169:
        byte[] r60 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r60);     // Catch: Throwable -> L235
        String r126 = new String(r60, "UTF-8");     // Catch: Throwable -> L173
        r8.setNumber(r126);     // Catch: Throwable -> L332
    L172:
        String r211 = r126;
    L174:
        byte[] r61 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r61);     // Catch: Throwable -> L235
        String r127 = new String(r61, "UTF-8");     // Catch: Throwable -> L178
        r8.setPoiName(r127);     // Catch: Throwable -> L333
    L177:
        String r212 = r127;
    L179:
        byte[] r62 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r62);     // Catch: Throwable -> L235
        r8.setAoiName(new String(r62, "UTF-8"));     // Catch: Throwable -> L334
    L181:
        byte[] r63 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r63);     // Catch: Throwable -> L235
        String r128 = new String(r63, "UTF-8");     // Catch: Throwable -> L185
        r8.setAdCode(r128);     // Catch: Throwable -> L335
    L184:
        String r213 = r128;
    L186:
        byte[] r64 = new byte[r40.get() & 255];     // Catch: Throwable -> L235
        r40.get(r64);     // Catch: Throwable -> L235
        r8.setCityCode(new String(r64, "UTF-8"));     // Catch: Throwable -> L336
    L188:
        r210 = r29;
        r41 = "#0505";
        byte r65 = 1;
        r39.c(r8, r56, r121, r123, r125, r211, r212, r213);     // Catch: Throwable -> L233
    L191:
        r40.get(new byte[r40.get() & 255]);     // Catch: Throwable -> L233
        if (r40.get() != r65) goto L195;
        r40.getInt();     // Catch: Throwable -> L233
        r40.getInt();     // Catch: Throwable -> L233
        r40.getShort();     // Catch: Throwable -> L233
    L195:
        if (r40.get() != r65) goto L201;
        byte[] r66 = new byte[r40.get() & 255];     // Catch: Throwable -> L233
        r40.get(r66);     // Catch: Throwable -> L233
        r8.setBuildingId(new String(r66, "UTF-8"));     // Catch: Throwable -> L337
    L198:
        byte[] r67 = new byte[r40.get() & 255];     // Catch: Throwable -> L233
        r40.get(r67);     // Catch: Throwable -> L233
        r8.setFloor(new String(r67, "UTF-8"));     // Catch: Throwable -> L338
    L201:
        if (r40.get() != r65) goto L204;
        r40.get();     // Catch: Throwable -> L233
        r40.getInt();     // Catch: Throwable -> L233
        r40.get();     // Catch: Throwable -> L233
    L204:
        if (r40.get() != r65) goto L206;
        r8.setTime(r40.getLong());     // Catch: Throwable -> L233
    L206:
        int r68 = r40.getShort();     // Catch: Throwable -> L233
        if (r68 <= 0) goto L213;
        byte[] r69 = new byte[r68];     // Catch: Throwable -> L233
        r40.get(r69);     // Catch: Throwable -> L233
        if (r68 <= 0) goto L213;
        r42 = 0;
        r8.K = new String(Base64.decode(r69, 0), "UTF-8");     // Catch: Throwable -> L339
    L410:
        int r70 = r40.getShort();     // Catch: Throwable -> L231
        if (r70 <= 0) goto L218;
        r40.get(new byte[r70]);     // Catch: Throwable -> L231
    L218:
        if (Double.valueOf(c4.a).doubleValue() < 5.1d) goto L230;
        short r129 = r40.getShort();     // Catch: Throwable -> L231
        if ("-1".equals(r8.N) == true) goto L227;
        if (r129 != (-1)) goto L224;
        r129 = 0;
    L229:
        r8.setConScenario(r129);     // Catch: Throwable -> L231
        r8.O = r40.get();     // Catch: Throwable -> L231
        goto L230
    L224:
        if (r129 != 0) goto L229;
        r129 = -1;
        goto L229
    L227:
        if (r129 != 101) goto L229;
        r129 = 100;
    L230:
        r40.clear();
        r44 = r8;
    L231:
        th = th;
    L213:
        r42 = 0;
    L233:
        th = th;
    L185:
        r213 = NameKeys.UnloadStrategy_No_Strategy;
    L178:
        r212 = NameKeys.UnloadStrategy_No_Strategy;
    L173:
        r211 = NameKeys.UnloadStrategy_No_Strategy;
    L168:
        r125 = NameKeys.UnloadStrategy_No_Strategy;
    L163:
        r123 = NameKeys.UnloadStrategy_No_Strategy;
    L158:
        r121 = NameKeys.UnloadStrategy_No_Strategy;
    L153:
        r56 = NameKeys.UnloadStrategy_No_Strategy;
        goto L154
    L190:
        r210 = r29;
        r41 = "#0505";
        r65 = 1;
        goto L191
    L383:
        r8.L = String.valueOf(r40.getShort());     // Catch: Throwable -> L143
        r40.clear();     // Catch: Throwable -> L143
        r40.clear();
        r210 = r29;
        r45 = r8;
    L143:
        th = th;
        r210 = r29;
        r119 = r40;
        r41 = "#0505";
        r42 = 0;
    L238:
        th = th;
        r210 = r29;
        r41 = "#0505";
        r42 = 0;
        r119 = null;
    L126:
        th = th;
    L130:
        if (r32 == null) goto L132;
        int r130 = r32.length;
    L133:
        c4.g(th, "Encrypt", "decryptRsponse length = ".concat(String.valueOf(r130)));
        r38 = r117;
        goto L134
    L132:
        r130 = 0;
    L128:
        th = th;
    L113:
        th = th;
    L117:
        ?? r71 = r8;
    L118:
        r71.setErrorCode(r118);
        c4.g(th, "Aps", "checkResponseEntity");
        r26.h = "#0403";
        r1.q.append("check response exception ex is" + th.getMessage() + "#0403");
        r71.setLocationDetail(r1.q.toString());
        r31 = r71;
        goto L119
    L407:
    L108:
        th = th;
        r117 = null;
    L106:
        r118 = 4;
        goto L117
    L76:
        if (r30.length != 0) goto L78;
        r118 = 4;
        r117 = null;
        goto L372
    L78:
        z3 r72 = new z3();     // Catch: Throwable -> L108
        String r73 = new String(r115.a, "UTF-8");     // Catch: Throwable -> L108
        if (r73.contains("\"status\":\"0\"") == false) goto L88;
        ?? r74 = r72.b(r73, r1.a, r115, r26);     // Catch: Throwable -> L85
        r74.V = r1.x.toString();     // Catch: Throwable -> L83
        r117 = null;
        r31 = r74;
    L83:
        th = th;
    L99:
        r118 = 4;
        r117 = null;
        r71 = r74;
        goto L118
    L88:
        if (r73.contains("</body></html>") == false) goto L107;
        r8.setErrorCode(5);     // Catch: Throwable -> L108
        s3 r75 = r1.c;     // Catch: Throwable -> L108
        if (r75 != null) goto L92;
    L100:
        r26.h = "#0502";     // Catch: Throwable -> L108
        r1.q.append("请求可能被劫持了#0502");     // Catch: Throwable -> L108
        r117 = null;
        h4.k(null, 2052);     // Catch: Throwable -> L105
    L103:
        r8.setLocationDetail(r1.q.toString());     // Catch: Throwable -> L105
    L105:
        th = th;
        goto L106
    L92:
        if (r75.b(r1.b) == false) goto L100;
        r26.h = "#0501";     // Catch: Throwable -> L85
        r1.q.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");     // Catch: Throwable -> L85
        h4.k(null, 2051);     // Catch: Throwable -> L115
        r117 = null;
        goto L103
    L107:
        r117 = null;
        r31 = 0;
    L85:
        th = th;
        r74 = r8;
    L115:
        th = th;
        r118 = 4;
        r117 = null;
        goto L117
    L62:
        if (r115.e == true) goto L64;
        r26.j = r24;     // Catch: Throwable -> L27
        r26.e = "SUCCESS";     // Catch: Throwable -> L27
        goto L66
    L64:
        r26.j = r24;     // Catch: Throwable -> L27
        r26.e = "FAIL";     // Catch: Throwable -> L27
        goto L65
    L45:
        r114 = "v4";
        goto L46
    L41:
        r24 = null;
        goto L42
    L34:
        if (com.loc.i.u() == false) goto L37;
        if (r112 == false) goto L37;
        r113 = 2;
        goto L39
    L357:
        if (r23.contains("dualstack") == false) goto L29;
        r112 = true;
    L284:
        th = th;
        goto L287
    L12:
        if (f5.m(r1.a) == false) goto L14;
        c4.c = "http://abroad.apilocate.amap.com/mobile/binary";     // Catch: Throwable -> L16
        c4.d = "http://abroad.apilocate.amap.com/mobile/binary";     // Catch: Throwable -> L16
    L365:
    L14:
        c4.c = "http://apilocate.amap.com/mobile/binary";     // Catch: Throwable -> L16
        c4.d = "http://dualstack-a.apilocate.amap.com/mobile/binary";     // Catch: Throwable -> L16
    L324:
        th = move-exception;
        r1 = r1;
        r26.h = "#0301";
        r1.q.append("get parames error:" + th.getMessage() + "#0301");
        h4.k(null, 2031);
        r18 = b(3, r1.q.toString());
        goto L322
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Context r8, b r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
        return;
    L39:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (r10 == null) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L23;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L34
        if (r0 != 1) goto L13;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L34
        return;
    L13:
        if (r0 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r0 == 3) goto L41;
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r8.registerReceiver(r9, r10);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L34
    }
}
