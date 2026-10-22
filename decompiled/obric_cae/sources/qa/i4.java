package qa;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i4 {
    public static final LinkedList A = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10541a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10542b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f10543c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f10544d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Vector<f> f10545e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap f10546f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f10547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f10548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f10549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, h> f10550j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, Long> f10551k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, e> f10552l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f10553m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f10554n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static int f10555o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f10556p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f10557q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static int f10558r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static boolean f10559s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static boolean f10560t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static int f10561u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static boolean f10562v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f10563w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f10564x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ArrayList<k0.a> f10565y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static volatile boolean f10566z;

    public class a extends m1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f10567b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ String f10568m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ String f10569n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final /* synthetic */ String f10570o;

        public a(String r8, String r10, String r11, String r12) {
            this.f10567b = r8;
            this.f10568m = r10;
            this.f10569n = r11;
            this.f10570o = r12;
        }

        @Override // qa.m1
        public final void a() {
            e r8 = i4.f10552l.get(this.f10567b);
            if (r8 != null) goto L5;
            return;
        L5:
            b r10 = r8.f10582c;
            s4 r11 = r8.f10580a;
            String r12 = r8.f10581b;
            Context r13 = i4.f10543c;
            String r14 = this.f10568m;
            String r15 = this.f10569n;
            String r16 = this.f10570o;
            String r17 = "infocode";
            c r18 = new c();
            r18.f10572b = new JSONObject();
            if (r13 == null) goto L8;
            i4.f10543c = r13.getApplicationContext();
        L8:
            i4.w();
            SharedPreferences.Editor r19 = null;
            i4.k(r11);     // Catch: Throwable -> L89 IllegalBlockSizeException -> L93 g4 -> L97
            new h0();     // Catch: Throwable -> L89 IllegalBlockSizeException -> L93 g4 -> L97
            boolean r20 = TextUtils.isEmpty(r12);     // Catch: Throwable -> L89 IllegalBlockSizeException -> L93 g4 -> L97
        L218:
            if (r20 == true) goto L184;
        L22:
            e = e;
            String r21 = r12;
        L219:
            throw e;     // Catch: Throwable -> L83 IllegalBlockSizeException -> L85 g4 -> L87
        L20:
            r21 = r12;
        L79:
            throw new g4("未知的错误");     // Catch: Throwable -> L83 IllegalBlockSizeException -> L85 g4 -> L87
        L12:
            if (TextUtils.isEmpty(r12) == true) goto L184;
            StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L20 g4 -> L22
            r110.append(r12);     // Catch: Throwable -> L20 g4 -> L22
            r21 = r12;
            r110.append(";15K;16H;17I;1A4;17S;183");     // Catch: g4 -> L17 Throwable -> L180
            r12 = r110.toString();     // Catch: g4 -> L17 Throwable -> L180
        L17:
            e = e;
            goto L219
        L184:
            if (i4.f10553m == true) goto L32;
            String r22 = "lc";
            qa.b.f10221b = z.i(r13, "a4", true);     // Catch: Throwable -> L171
            qa.b.f10222c = z.i(r13, "a5", true);     // Catch: Throwable -> L171
            i4.f10553m = true;     // Catch: Throwable -> L171
        L214:
            i4.x(r13);     // Catch: Throwable -> L77 g4 -> L80
            String r23 = "infocode";
            r17 = r22;
            String r24 = LocationMonitorConst.INFO;
            String r25 = "status";
            String r26 = "ver";
            n0 r27 = h0.a(new d(r13, r11, r12, r14, r15, r16));     // Catch: g4 -> L75 Throwable -> L178
            if (r20 == false) goto L206;
        L151:
            if (r10 == null) goto L221;
            Context r28 = ((s3.a) r10).f11090a;
            SharedPreferences.Editor r29 = r28.getSharedPreferences("pref", 0).edit();     // Catch: Throwable -> L176
            s3.d(r18, r29);     // Catch: Throwable -> L166
            s4 r30 = t3.j();     // Catch: Throwable -> L174
            r30.f11093c = s3.f11065b ? 1 : 0;     // Catch: Throwable -> L174
            q.c(r28, r30);     // Catch: Throwable -> L174
        L156:
            JSONObject r31 = r18.f10572b;     // Catch: Throwable -> L166
            if (r31 != null) goto L160;
            if (r29 != null) goto L200;
            return;
        L200:
            x3.e(r29);     // Catch: Throwable -> L177
            return;
        L225:
            return;
        L160:
            s3.b(r28, r31, r29);     // Catch: Throwable -> L166
            s3.c(r29, r31);     // Catch: Throwable -> L166
            s3.i(r29, r31);     // Catch: Throwable -> L166
            s3.j(r29, r31);     // Catch: Throwable -> L166
            s3.l(r29, r31);     // Catch: Throwable -> L166
            s3.k(r29, r31);     // Catch: Throwable -> L166
            s3.m(r29, r31);     // Catch: Throwable -> L166
            s3.h(r29, r31);     // Catch: Throwable -> L166
            JSONObject r32 = r31.getJSONObject("1A6");     // Catch: Throwable -> L175
            if (r32 == null) goto L164;
            boolean r33 = i4.o(r32.optString("ic"), false);     // Catch: Throwable -> L175
            x3.i(r29, "1A6", r33);     // Catch: Throwable -> L175
            s3.G = r33;     // Catch: Throwable -> L175
        L164:
            if (r29 != null) goto L200;
            return;
        L166:
            r19 = r29;
        L167:
            if (r19 == null) goto L224;
            r29 = r19;
            goto L200
        L224:
            return;
        L221:
            return;
        L206:
            byte[] r34 = r27.f10842a;     // Catch: Throwable -> L68 IllegalBlockSizeException -> L70 g4 -> L72
            Map<String, List<String>> r35 = r27.f10843b;     // Catch: Throwable -> L58
            if (r35 != null) goto L42;
        L60:
            byte[] r36 = new byte[16];     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            byte[] r37 = new byte[r34.length - 16];     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            System.arraycopy(r34, 0, r36, 0, 16);     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            System.arraycopy(r34, 16, r37, 0, r34.length - 16);     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            SecretKeySpec r38 = new SecretKeySpec(r36, t4.n("EQUVT"));     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            Cipher r39 = Cipher.getInstance(t4.n("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            r39.init(2, r38, new IvParameterSpec(t4.o()));     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            String r40 = t4.c(r39.doFinal(r37));     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
        L102:
            if (r34 == null) goto L151;
            if (TextUtils.isEmpty(r40) == false) goto L108;
            r40 = t4.c(r34);
        L108:
            if (TextUtils.isEmpty(r40) == false) goto L202;
            i4.e(r13, r11, "result is null");
        L202:
            JSONObject r41 = new JSONObject(r40);     // Catch: Throwable -> L149
            String r42 = r25;
            if (r41.has(r42) == false) goto L151;
            int r43 = r41.getInt(r42);     // Catch: Throwable -> L149
            if (r43 != 1) goto L115;
            i4.f10541a = 1;     // Catch: Throwable -> L149
        L130:
            String r44 = r26;
        L135:
            th = move-exception;
            l.a("at", r17, th);     // Catch: Throwable -> L149
        L138:
            if (t4.g("result", r41) == false) goto L151;
            JSONObject r45 = r41.getJSONObject("result");     // Catch: Throwable -> L149
            i4.f(r13, r11, r12, r18, r45);     // Catch: Throwable -> L149
            JSONObject r46 = r45.getJSONObject("15K");     // Catch: Throwable -> L173
            boolean r47 = i4.o(r46.optString("isTargetAble"), false);     // Catch: Throwable -> L173
            if (i4.o(r46.optString("able"), false) == true) goto L144;
            m4 r48 = m4.a.f10837a;     // Catch: Throwable -> L173
            SharedPreferences.Editor r49 = z.b(r13, "open_common");     // Catch: Throwable -> L173
            z.h(r49, "a3", true);     // Catch: Throwable -> L173
            z.e(r49);     // Catch: Throwable -> L173
            goto L151
        L144:
            m4 r50 = m4.a.f10837a;     // Catch: Throwable -> L173
            if (r50.f10836a != null) goto L147;
            r50.f10836a = new m4.b();     // Catch: Throwable -> L173
        L147:
            SharedPreferences.Editor r51 = z.b(r13, "open_common");     // Catch: Throwable -> L173
            z.h(r51, "a3", r47);     // Catch: Throwable -> L173
            z.e(r51);     // Catch: Throwable -> L173
            r50.f10836a.f10839b = r47;     // Catch: Throwable -> L173
            goto L151
        L132:
            if (r41.has(r44) == false) goto L138;
            r41.getInt(r44);     // Catch: Throwable -> L135
        L115:
            if (r43 != 0) goto L130;
            if (r27 == null) goto L119;
            String r52 = r27.f10844c;     // Catch: Throwable -> L149
            String r53 = r27.f10845d;     // Catch: Throwable -> L149
        L120:
            t4.d(r13, r52, r53, r41);     // Catch: Throwable -> L149
            i4.f10541a = 0;     // Catch: Throwable -> L149
            String r54 = r24;
            if (r41.has(r54) == false) goto L123;
            i4.f10542b = r41.getString(r54);     // Catch: Throwable -> L149
        L123:
            String r55 = r23;
            if (r41.has(r55) == false) goto L126;
            String r56 = r41.getString(r55);     // Catch: Throwable -> L149
        L127:
            q.d(r11, "/v3/iasdkauth", i4.f10542b, r53, r52, r56);     // Catch: Throwable -> L149
            if (i4.f10541a != 0) goto L130;
        L126:
            r56 = "";
            goto L127
        L119:
            r52 = "authcsid";
            r53 = "authgsid";
        L149:
            th = move-exception;
            l.a("at", r17, th);
            goto L151
        L64:
            e = e;
        L96:
            i4.e(r13, r11, e.getMessage());
        L101:
            r40 = null;
        L66:
            e = e;
        L74:
            n0 r57 = r27;
            byte[] r111 = r34;
        L100:
            i4.e(r13, r11, e.f10477a);
            Set<Integer> r58 = q.f10946e;
            q.d(r11, "/v3/iasdkauth", e.f10481o, e.f10478b, e.f10479m, e.f10480n);
            r27 = r57;
            r34 = r111;
        L62:
            e = th;
        L92:
            q.f("at", r17, e);
            goto L96
        L42:
            if (r35.containsKey("lct") == false) goto L60;
            List<String> r59 = r35.get("lct");     // Catch: Throwable -> L58
            List<String> r60 = r35.get("lct-info");     // Catch: Throwable -> L58
            r18.f10571a = i4.a(r59);     // Catch: Throwable -> L58
            if (r60 != null) goto L198;
        L50:
            String r61 = "";
        L52:
            if (r18.f10571a == 0) goto L60;
            if (r11 == null) goto L60;
            String r62 = r11.a();     // Catch: Throwable -> L58
            if (TextUtils.isEmpty(r62) == true) goto L60;
            i4.c(r18.f10571a, r62, r61);     // Catch: Throwable -> L58
            goto L60
        L198:
            if (r60.size() <= 0) goto L50;
            r61 = r60.get(0);     // Catch: Exception -> L172 Throwable -> L58
            if (TextUtils.isEmpty(r61) == true) goto L50;
        L58:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            q.f("at", "lct", th);     // Catch: Throwable -> L62 IllegalBlockSizeException -> L64 g4 -> L66
            goto L60
        L70:
            e = e;
            r34 = null;
        L72:
            e = e;
            r34 = null;
        L68:
            e = th;
            r34 = null;
            goto L92
        L75:
            e = move-exception;
            throw e;     // Catch: Throwable -> L83 IllegalBlockSizeException -> L85 g4 -> L87
        L80:
            e = move-exception;
            throw e;     // Catch: Throwable -> L83 IllegalBlockSizeException -> L85 g4 -> L87
        L32:
            r22 = "lc";
        L85:
            e = e;
        L95:
            r27 = null;
            r34 = null;
        L87:
            e = e;
        L99:
            r57 = null;
            r111 = null;
        L83:
            e = th;
        L91:
            r27 = null;
            r34 = null;
        L93:
            e = e;
            r25 = "status";
            r26 = "ver";
            r23 = "infocode";
            r24 = LocationMonitorConst.INFO;
            r17 = "lc";
            r12 = r12;
        L97:
            e = e;
            r25 = "status";
            r26 = "ver";
            r23 = "infocode";
            r24 = LocationMonitorConst.INFO;
            r17 = "lc";
            r12 = r12;
        L89:
            e = th;
            r25 = "status";
            r26 = "ver";
            r23 = "infocode";
            r24 = LocationMonitorConst.INFO;
            r17 = "lc";
            r12 = r12;
            goto L91
        }
    }

    public interface b {
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public JSONObject f10572b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a f10573c;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f10574a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public JSONObject f10575b;
        }

        public c() {
            this.f10571a = 0;
        }
    }

    public static class d extends i0 {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f10576n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f10577o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final String f10578p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final String f10579q;

        public d(Context r8, s4 r10, String r11, String r12, String r13, String r14) {
            super(r8, r10);
            this.f10576n = r11;
            this.f10577o = r12;
            this.f10578p = r13;
            this.f10579q = r14;
            b(m0.c.f10822b);
            this.f10805i = m0.a.f10809m;
        }

        @Override // qa.m0
        public final Map<String, String> a() {
            String r8 = this.f10579q;
            if (TextUtils.isEmpty(r8) == true) goto L6;
            HashMap r10 = new HashMap();
            r10.put("host", r8);
            return r10;
        L6:
            return null;
        }

        @Override // qa.m0
        public final String c() {
            String r8 = this.f10577o;
            if (TextUtils.isEmpty(r8) == true) goto L10;
            return Uri.parse("https://restsdk.amap.com/v3/iasdkauth").buildUpon().encodedAuthority(r8).build().toString();
        L10:
            return "https://restsdk.amap.com/v3/iasdkauth";
        L11:
            return "https://restsdk.amap.com/v3/iasdkauth";
        }

        @Override // qa.n4, qa.m0
        public final String e() {
            String r8 = this.f10578p;
            if (TextUtils.isEmpty(r8) == true) goto L10;
            return Uri.parse("https://dualstack-arestapi.amap.com/v3/iasdkauth").buildUpon().encodedAuthority(r8).build().toString();
        L10:
            return "https://dualstack-arestapi.amap.com/v3/iasdkauth";
        L11:
            return "https://dualstack-arestapi.amap.com/v3/iasdkauth";
        }

        @Override // qa.m0
        public final String j() {
            String r8 = this.f10579q;
            if (TextUtils.isEmpty(r8) == true) goto L5;
            return r8;
        L5:
            return "";
        }

        @Override // qa.i0
        public final byte[] p() {
            return null;
        }

        @Override // qa.i0
        public final byte[] q() {
            Context r8 = this.f10516k;
            String r10 = k4.q(r8);
            if (TextUtils.isEmpty(r10) == true) goto L5;
            r10 = l6.a.j(new StringBuilder(r10).reverse().toString());
        L5:
            HashMap r11 = new HashMap();
            String r12 = this.f10576n;
            if (TextUtils.isEmpty(r12) == false) goto L8;
            r12 = "";
        L8:
            r11.put("authkey", r12);
            r11.put("plattype", "android");
            r11.put("ccver", "1");
            s4 r13 = this.f10517l;
            r11.put("product", r13.a());
            r11.put("version", r13.f11096f);
            r11.put(QesdkUtils.TAGS.TAG_OUTPUT, "json");
            StringBuilder r14 = new StringBuilder();
            r14.append(Build.VERSION.SDK_INT);
            r11.put("androidversion", r14.toString());
            r11.put("deviceId", r10);
            r11.put("manufacture", Build.MANUFACTURER);
            r11.put("abitype", t4.b(r8));
            r11.put("ext", r13.c());
            if (r11.size() != 0) goto L11;
            String r15 = null;
        L25:
            return t4.i(r15);
        L11:
            StringBuffer r16 = new StringBuffer();
            Iterator r17 = r11.entrySet().iterator();     // Catch: Throwable -> L21
            boolean r18 = true;
        L13:
            if (r17.hasNext() == false) goto L23;
            Map.Entry r19 = (Map.Entry) r17.next();     // Catch: Throwable -> L21
            if (r18 == true) goto L18;
            r16.append("&");     // Catch: Throwable -> L21
            r16.append((String) r19.getKey());     // Catch: Throwable -> L21
            r16.append("=");     // Catch: Throwable -> L21
            r16.append((String) r19.getValue());     // Catch: Throwable -> L21
            goto L13
        L18:
            r16.append((String) r19.getKey());     // Catch: Throwable -> L21
            r16.append("=");     // Catch: Throwable -> L21
            r16.append((String) r19.getValue());     // Catch: Throwable -> L21
            r18 = false;
        L23:
            r15 = r16.toString();
        L21:
            th = move-exception;
            l.a("ut", "abP", th);
            goto L23
        }

        @Override // qa.i0
        public final String r() {
            return "3.0";
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public s4 f10580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f10582c;

        public e() {
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f10585c;

        public f(String r8, String r10, int r11) {
            this.f10583a = r8;
            this.f10584b = r10;
            this.f10585c = new AtomicInteger(r11);
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static boolean f10586a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f10587b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static boolean f10588c = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f10589d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static boolean f10590e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f10591f;
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f10592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10593b;

        public h(Long r8, String r10) {
            this.f10592a = 0;
            this.f10593b = "";
            this.f10592a = r8.longValue();
            this.f10593b = r10;
        }
    }

    static {
        f10545e = new Vector();
        f10546f = new HashMap();
        f10547g = null;
        f10548h = 0;
        f10549i = false;
        f10550j = new ConcurrentHashMap(8);
        f10551k = new ConcurrentHashMap(8);
        f10552l = new ConcurrentHashMap(8);
        f10553m = false;
        f10554n = false;
        f10555o = 5000;
        f10556p = true;
        f10557q = false;
        f10558r = 3;
        f10559s = true;
        f10560t = false;
        f10561u = 3;
        f10562v = false;
        f10563w = new ConcurrentHashMap();
        f10564x = new ConcurrentHashMap();
        f10565y = new ArrayList();
        A = new LinkedList();
    }

    public static boolean A(String r8) {
    L29:
        return true;
    L4:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return true;
    L7:
        if (f10556p == true) goto L10;
        return false;
    L10:
        if (f10563w.get(r8) != null) goto L12;
        boolean r10 = true;
    L13:
        if (r10 == true) goto L15;
        return false;
    L15:
        Context r11 = f10543c;     // Catch: Throwable -> L29
        if (r11 != null) goto L18;
        return true;
    L18:
        f r12 = b(r11, p(r8, "a14"));     // Catch: Throwable -> L29
        if (r12 != null) goto L21;
        return true;
    L21:
        AtomicInteger r13 = r12.f10585c;     // Catch: Throwable -> L29
        if (r13 != null) goto L24;
        int r14 = 0;
    L25:
        if (r14 >= f10558r) goto L28;
        return true;
    L28:
        return false;
    L24:
        r14 = r13.get();     // Catch: Throwable -> L29
        goto L25
    L12:
        r10 = false;
        goto L13
    }

    public static long a(List<String> r8) {
        if (r8 == null) goto L15;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (r8.size() <= 0) goto L16;
        String r10 = r8.get(0);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r10) == true) goto L17;
        return Long.valueOf(r10).longValue();
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    }

    public static synchronized f b(Context r8, String r10) {
        monitor-enter(i4.class);
        f r11 = null;
        if (TextUtils.isEmpty(r10) == true) goto L15;
        int r12 = 0;
    L7:
        Vector<f> r13 = f10545e;     // Catch: Throwable -> L36
        if (r12 >= r13.size()) goto L15;
        f r14 = r13.get(r12);     // Catch: Throwable -> L36
        if (r14 == null) goto L14;
        if (r10.equals(r14.f10583a) == false) goto L14;
    L16:
        if (r14 == null) goto L19;
        monitor-exit(i4.class);
        return r14;
    L19:
        if (r8 != null) goto L22;
        monitor-exit(i4.class);
        return null;
    L22:
        String r15 = z.k(r8, "open_common", r10);     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r15) == false) goto L42;
    L27:
        String r16 = t4.a(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L36
        if (r11 != null) goto L31;
        r11 = new f(r10, r16, 0);     // Catch: Throwable -> L36
    L31:
        if (r16.equals(r11.f10584b) == true) goto L33;
        r11.f10584b = r16;     // Catch: Throwable -> L36
        r11.f10585c.set(0);     // Catch: Throwable -> L36
    L33:
        f10545e.add(r11);     // Catch: Throwable -> L36
        monitor-exit(i4.class);
        return r11;
    L42:
        JSONObject r17 = new JSONObject(r15);     // Catch: Throwable -> L39
        r11 = new f(r17.optString("a"), r17.optString("f"), r17.optInt("h"));     // Catch: Throwable -> L39
    L14:
        r12 = r12 + 1;
    L15:
        r14 = null;
    L36:
        th = move-exception;
        throw th;
    }

    public static synchronized void c(long r8, String r10, String r11) {
        monitor-enter(i4.class);
    L23:
        th = move-exception;
        l.a("at", "ucut", th);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (f10552l != null) goto L7;
    L28:
        monitor-exit(i4.class);
        return;
    L7:
        if (f10552l.containsKey(r10) == false) goto L28;
        if (f10550j != null) goto L12;
        f10550j = new ConcurrentHashMap(8);     // Catch: Throwable -> L23
    L12:
        f10550j.put(r10, new h(Long.valueOf(r8), r11));     // Catch: Throwable -> L23
        Context r12 = f10543c;     // Catch: Throwable -> L23
        if (r12 == null) goto L26;
        SharedPreferences.Editor r13 = z.b(r12, "open_common");     // Catch: Throwable -> L23
        if (r13 != null) goto L17;
    L25:
        z.g(r13, r10 + "lct-info", r11);     // Catch: Throwable -> L23
        z.e(r13);     // Catch: Throwable -> L23
        goto L26
    L17:
        if (TextUtils.isEmpty(r10) == true) goto L25;
        r13.putLong(r10, r8);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        q.f("csp", "plv", th);     // Catch: Throwable -> L23
    L26:
        monitor-exit(i4.class);
    }

    public static void d(Context r8, String r10, f r11) {
        String r12 = r11.f10583a;
        if (TextUtils.isEmpty(r12) == true) goto L17;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L7
        r13.put("a", r12);     // Catch: Throwable -> L7
        r13.put("f", r11.f10584b);     // Catch: Throwable -> L7
        r13.put("h", r11.f10585c.get());     // Catch: Throwable -> L7
        String r14 = r13.toString();     // Catch: Throwable -> L7
    L9:
        if (TextUtils.isEmpty(r14) == false) goto L11;
        return;
    L11:
        if (r8 != null) goto L13;
        return;
    L13:
        SharedPreferences.Editor r15 = z.b(r8, "open_common");
        r15.putString(r10, r14);
        z.e(r15);
        return;
    L7:
        r14 = "";
        goto L9
    }

    public static void e(Context r8, s4 r10, String r11) {
        HashMap r12 = new HashMap();
        r12.put("amap_sdk_auth_fail", "1");
        r12.put("amap_sdk_auth_fail_type", r11);
        r12.put("amap_sdk_name", r10.a());
        r12.put("amap_sdk_version", r10.b());
        String r13 = new JSONObject(r12).toString();
        if (TextUtils.isEmpty(r13) == false) goto L8;
        return;
    L8:
        t0 r14 = new t0(r8, "core", "2.0", "O001");     // Catch: g4 -> L7
        r14.a(r13);     // Catch: g4 -> L7
        u0.c(r14, r8);     // Catch: g4 -> L7
        return;
    }

    public static void f(Context r20, s4 r21, String r22, c r23, JSONObject r24) {
        c r8 = r23;
        c.a r10 = new c.a();
        r10.f10574a = false;
        r8.f10573c = r10;
        String[] r12 = r22.split(";");     // Catch: Throwable -> L13
        if (r12 == null) goto L16;
        if (r12.length <= 0) goto L16;
        int r13 = r12.length;     // Catch: Throwable -> L13
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L16;
        String r15 = r12[r14];     // Catch: Throwable -> L13
        if (r24.has(r15) == false) goto L12;
        r8.f10572b.putOpt(r15, r24.get(r15));     // Catch: Throwable -> L13
    L12:
        r14 = r14 + 1;
        r8 = r23;
    L16:
        if (t4.g("16H", r24) == false) goto L22;
        o(r24.getJSONObject("16H").optString("able"), false);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        l.a("AuthConfigManager", "load 16H", th);
    L22:
        if (t4.g("11K", r24) == false) goto L30;
        JSONObject r11 = r24.getJSONObject("11K");     // Catch: Throwable -> L27
        r10.f10574a = o(r11.getString("able"), false);     // Catch: Throwable -> L27
        if (r11.has("off") == false) goto L30;
        r10.f10575b = r11.getJSONObject("off");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        l.a("AuthConfigManager", "load 11K", th);
    L30:
        if (t4.g("145", r24) == false) goto L36;
        r24.getJSONObject("145");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        l.a("AuthConfigManager", "load 145", th);
    L36:
        if (t4.g("14D", r24) == false) goto L42;
        r24.getJSONObject("14D");     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        l.a("AuthConfigManager", "load 14D", th);
    L42:
        if (t4.g("151", r24) == false) goto L50;
        JSONObject r16 = r24.getJSONObject("151");     // Catch: Throwable -> L47
        if (r16 == null) goto L50;
        o(r16.optString("able"), false);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        l.a("AuthConfigManager", "load 151", th);
    L50:
        if (t4.g("17S", r24) == true) goto L167;
    L96:
        String r17 = "ustv";
        String r18 = "ust";
        String r19 = "umv";
    L98:
        if (t4.g("15K", r24) == true) goto L175;
    L118:
        Context r25 = r20;
    L120:
        if (t4.g("183", r24) == false) goto L126;
        j0.h(r21, r24.getJSONObject("183"));     // Catch: Throwable -> L123
    L123:
        th = move-exception;
        l.a("AuthConfigManager", "load 183", th);
    L126:
        if (t4.g("17I", r24) == false) goto L132;
        JSONObject r26 = r24.getJSONObject("17I");     // Catch: Throwable -> L129
        boolean r27 = o(r26.optString("na"), false);     // Catch: Throwable -> L129
        boolean r28 = o(r26.optString("aa"), false);     // Catch: Throwable -> L129
        qa.b.f10221b = r27;     // Catch: Throwable -> L129
        qa.b.f10222c = r28;     // Catch: Throwable -> L129
        SharedPreferences.Editor r29 = z.b(r25, "open_common");     // Catch: Throwable -> L129
        z.h(r29, "a4", r27);     // Catch: Throwable -> L129
        z.h(r29, "a5", r28);     // Catch: Throwable -> L129
        z.e(r29);     // Catch: Throwable -> L129
    L129:
        th = move-exception;
        l.a("AuthConfigManager", "load 17I", th);
    L132:
        if (t4.g("1A4", r24) == false) goto L184;
        JSONObject r30 = r24.getJSONObject("1A4");     // Catch: Throwable -> L145
        String r31 = r30.optString("ada");     // Catch: Throwable -> L145
        o(r31, true);     // Catch: Throwable -> L145
        long r32 = r30.optLong("iv", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);     // Catch: Throwable -> L145
        SharedPreferences.Editor r33 = z.b(r25, "open_common");     // Catch: Throwable -> L145
        z.g(r33, "a16", r31);     // Catch: Throwable -> L145
        if (r33 != null) goto L136;
    L143:
        z.e(r33);     // Catch: Throwable -> L145
        return;
    L136:
        if (TextUtils.isEmpty("a17") == true) goto L143;
        r33.putLong("a17", r32);     // Catch: Throwable -> L140
    L140:
        th = move-exception;
        q.f("csp", "plv", th);     // Catch: Throwable -> L145
    L145:
        th = move-exception;
        l.a("AuthConfigManager", "load 1A4", th);
        return;
    L184:
        return;
    L175:
        JSONObject r34 = r24.getJSONObject("15K");     // Catch: Throwable -> L116
        if (r34 == null) goto L118;
        boolean r35 = o(r34.optString("ucf"), g.f10586a);     // Catch: Throwable -> L116
        boolean r36 = o(r34.optString("fsv2"), g.f10587b);     // Catch: Throwable -> L116
        boolean r37 = o(r34.optString("usc"), g.f10588c);     // Catch: Throwable -> L116
        String r38 = r19;
        int r39 = r34.optInt(r38, g.f10589d);     // Catch: Throwable -> L116
        String r110 = r18;
        boolean r111 = o(r34.optString(r110), g.f10590e);     // Catch: Throwable -> L116
        String r112 = r17;
        int r40 = r34.optInt(r112, g.f10591f);     // Catch: Throwable -> L116
        if (r35 == g.f10586a) goto L104;
    L112:
        g.f10586a = r35;     // Catch: Throwable -> L116
        g.f10587b = r36;     // Catch: Throwable -> L116
        g.f10588c = r37;     // Catch: Throwable -> L116
        g.f10589d = r39;     // Catch: Throwable -> L116
        g.f10590e = r111;     // Catch: Throwable -> L116
        g.f10591f = r40;     // Catch: Throwable -> L116
        r25 = r20;
        SharedPreferences.Editor r41 = z.b(r25, "open_common");     // Catch: Throwable -> L148
        z.h(r41, "ucf", g.f10586a);     // Catch: Throwable -> L148
        z.h(r41, "fsv2", g.f10587b);     // Catch: Throwable -> L148
        z.h(r41, "usc", g.f10588c);     // Catch: Throwable -> L148
        z.f(r41, r38, g.f10589d);     // Catch: Throwable -> L148
        z.h(r41, r110, g.f10590e);     // Catch: Throwable -> L148
        z.f(r41, r112, g.f10591f);     // Catch: Throwable -> L148
        z.e(r41);     // Catch: Throwable -> L148
        goto L120
    L104:
        if (r36 != g.f10587b) goto L112;
        if (r37 != g.f10588c) goto L112;
        int r113 = g.f10589d;     // Catch: Throwable -> L116
        if (r39 != r113) goto L112;
        if (r111 != g.f10590e) goto L112;
        if (r40 == r113) goto L118;
    L116:
        th = move-exception;
        r25 = r20;
        l.a("AuthConfigManager", "load 15K", th);
        goto L120
    L167:
        JSONObject r42 = r24.getJSONObject("17S");     // Catch: Throwable -> L92
        if (r42 == null) goto L58;
        boolean r43 = o(r42.optString("able"), false);     // Catch: Throwable -> L92
        if (r43 == f10544d) goto L58;
        f10544d = r43;     // Catch: Throwable -> L92
        if (r20 == null) goto L58;
        SharedPreferences.Editor r114 = z.b(r20, "open_common");     // Catch: Throwable -> L92
        z.h(r114, "a2", r43);     // Catch: Throwable -> L92
        z.e(r114);     // Catch: Throwable -> L92
    L58:
        if (r42 == null) goto L96;
        boolean r44 = o(r42.optString("static_enable"), true);     // Catch: Throwable -> L92
        boolean r115 = o(r42.optString("static_ip_direct_enable"), false);     // Catch: Throwable -> L92
        int r116 = r42.optInt("static_timeout", 5) * 1000;     // Catch: Throwable -> L92
        int r117 = r42.optInt("static_retry", 3);     // Catch: Throwable -> L92
        r17 = "ustv";
        boolean r118 = o(r42.optString("bgp_enable"), true);     // Catch: Throwable -> L90
        r18 = "ust";
        boolean r45 = o(r42.optString("bgp_ip_direct_enable"), false);     // Catch: Throwable -> L88
        r19 = "umv";
        int r46 = r42.optInt("bgp_retry", 3);     // Catch: Throwable -> L86
        boolean r47 = o(r42.optString("perf_data_upload_enable"), false);     // Catch: Throwable -> L86
        if (r44 == f10556p) goto L68;
    L81:
        f10556p = r44;     // Catch: Throwable -> L86
        f10557q = r115;     // Catch: Throwable -> L86
        f10555o = r116;     // Catch: Throwable -> L86
        f10558r = r117;     // Catch: Throwable -> L86
        f10559s = r118;     // Catch: Throwable -> L86
        f10560t = r45;     // Catch: Throwable -> L86
        f10561u = r46;     // Catch: Throwable -> L86
        f10562v = r47;     // Catch: Throwable -> L86
        if (r20 == null) goto L84;
        SharedPreferences.Editor r48 = z.b(r20, "open_common");     // Catch: Throwable -> L86
        z.h(r48, "a13", r44);     // Catch: Throwable -> L86
        z.h(r48, "a6", r118);     // Catch: Throwable -> L86
        z.h(r48, "a7", r115);     // Catch: Throwable -> L86
        z.f(r48, "a8", r116);     // Catch: Throwable -> L86
        z.f(r48, "a9", r117);     // Catch: Throwable -> L86
        z.h(r48, "a10", r45);     // Catch: Throwable -> L86
        z.f(r48, "a11", r46);     // Catch: Throwable -> L86
        z.h(r48, "a12", r47);     // Catch: Throwable -> L86
        z.e(r48);     // Catch: Throwable -> L86
    L84:
        goto L98
    L68:
        if (r115 != f10557q) goto L81;
        if (r116 != f10555o) goto L81;
        if (r117 != f10558r) goto L81;
        if (r118 != f10559s) goto L81;
        if (r45 != f10560t) goto L81;
        if (r46 != f10561u) goto L81;
        if (r47 == f10562v) goto L84;
    L86:
        th = th;
    L95:
        l.a("AuthConfigManager", "load 17S", th);
    L88:
        th = th;
    L89:
        r19 = "umv";
    L90:
        th = th;
    L94:
        r18 = "ust";
    L92:
        th = th;
        r17 = "ustv";
    L13:
        th = move-exception;
        l.a("at", "co", th);
        goto L16
    }

    public static void g(String r8) {
        f r10 = b(f10543c, r8);
        String r11 = t4.a(System.currentTimeMillis(), "yyyyMMdd");
        boolean r12 = r11.equals(r10.f10584b);
        AtomicInteger r13 = r10.f10585c;
        if (r12 == true) goto L5;
        r10.f10584b = r11;
        r13.set(0);
    L5:
        r13.incrementAndGet();
        d(f10543c, r8, r10);
    }

    public static void h(String r8, boolean r10) {
        "--markHostNameFailed---hostname=".concat(String.valueOf(r8));     // Catch: Throwable -> L24
        if (f10556p == true) goto L7;
        if (r10 == true) goto L7;
        return;
    L7:
        if (f10560t == true) goto L11;
        if (r10 == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r8) == false) goto L13;
        return;
    L13:
        if (r10 == true) goto L19;
        ConcurrentHashMap<String, Boolean> r11 = f10563w;     // Catch: Throwable -> L24
        if (r11.get(r8) == null) goto L17;
        return;
    L17:
        r11.put(r8, Boolean.TRUE);     // Catch: Throwable -> L24
        g(p(r8, "a14"));     // Catch: Throwable -> L24
        return;
    L19:
        ConcurrentHashMap<String, Boolean> r12 = f10564x;     // Catch: Throwable -> L24
        if (r12.get(r8) == null) goto L22;
        return;
    L22:
        r12.put(r8, Boolean.TRUE);     // Catch: Throwable -> L24
        g(p(r8, "a15"));     // Catch: Throwable -> L24
        return;
    }

    public static synchronized void i(String r8, boolean r10, String r11, String r12, String r13) {
        monitor-enter(i4.class);
    L29:
        th = move-exception;
        l.a("at", "lca", th);     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L9;
        monitor-exit(i4.class);
        return;
    L9:
        if (f10551k != null) goto L11;
        f10551k = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L11:
        f10551k.put(r8, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L29
        if (f10552l != null) goto L16;
        monitor-exit(i4.class);
        return;
    L16:
        if (f10552l.containsKey(r8) == true) goto L20;
        monitor-exit(i4.class);
        return;
    L20:
        if (TextUtils.isEmpty(r8) == false) goto L23;
        monitor-exit(i4.class);
        return;
    L23:
        if (r10 == true) goto L25;
    L26:
        l1.f10784d.a(new a(r8, r11, r12, r13));     // Catch: Throwable -> L29
        monitor-exit(i4.class);
        return;
    L25:
        j0.e(r8, true);     // Catch: Throwable -> L29
        goto L26
    }

    public static void j(String r8, boolean r10, boolean r11, boolean r12) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (f10543c == null) goto L32;
        HashMap r13 = new HashMap();
        r13.put(WsConstants.KEY_CONNECTION_URL, r8);
        r13.put("downLevel", String.valueOf(r10));
        String r14 = "0";
        if (k4.n(f10543c) != 0) goto L10;
        Object r15 = "0";
    L11:
        r13.put("ant", r15);
        if (r12 == false) goto L16;
        if (r10 == false) goto L15;
        String r16 = "9";
    L19:
        r13.put("type", r16);
        if (r11 == true) goto L23;
        r14 = "1";
    L23:
        r13.put("status", r14);
        String r17 = new JSONObject(r13).toString();
        if (TextUtils.isEmpty(r17) == false) goto L29;
        return;
    L29:
        t0 r18 = new t0(f10543c, "core", "2.0", "O002");     // Catch: g4 -> L28
        r18.a(r17);     // Catch: g4 -> L28
        u0.c(r18, f10543c);     // Catch: g4 -> L28
        return;
    L33:
        return;
    L15:
        r16 = "8";
        goto L19
    L16:
        if (r10 == false) goto L18;
        r16 = "6";
        goto L19
    L18:
        r16 = "4";
        goto L19
    L10:
        r15 = "1";
        goto L11
    }

    public static void k(s4 r8) {
        if (r8 == null) goto L17;
        if (TextUtils.isEmpty(r8.a()) == false) goto L6;
        return;
    L6:
        String r10 = r8.b();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r10) == false) goto L10;
        r10 = r8.f11096f;     // Catch: Throwable -> L14
    L10:
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return;
    L12:
        qa.b.b(r8.a(), r10);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    public static void l(boolean r8, k0.a r10) {
        if (f10566z == false) goto L31;
        if (r10 == null) goto L47;
        ArrayList<k0.a> r11 = f10565y;
        monitor-enter(r11);
        if (r8 == true) goto L32;
    L22:
        f10566z = false;     // Catch: Throwable -> L28
        Iterator<k0.a> r12 = f10565y.iterator();     // Catch: Throwable -> L28
    L24:
        if (r12.hasNext() == false) goto L26;
        k0.a r13 = r12.next();     // Catch: Throwable -> L28
        String r14 = r13.f10676n;     // Catch: Throwable -> L28
        Objects.toString(r13.f10681s);     // Catch: Throwable -> L28
        goto L24
    L26:
        monitor-exit(r11);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    L32:
        Iterator<k0.a> r15 = r11.iterator();     // Catch: Throwable -> L28
    L11:
        if (r15.hasNext() == false) goto L22;
        k0.a r16 = r15.next();     // Catch: Throwable -> L28
        if (r16.f10673a.equals(r10.f10673a) == false) goto L11;
        if (r16.f10676n.equals(r10.f10676n) == false) goto L11;
        if (r16.f10677o != r10.f10677o) goto L11;
        if (r16.f10681s == r10.f10681s) goto L20;
        r16.f10681s.set(r16.f10681s.get() - r10.f10681s.get());     // Catch: Throwable -> L28
        goto L11
    L20:
        r15.remove();     // Catch: Throwable -> L28
        goto L11
    L47:
        return;
    }

    public static boolean m() {
        Context r8 = f10543c;
        if (r8 == null) goto L75;
        String r10 = k4.p(r8);     // Catch: Throwable -> L66
        if (TextUtils.isEmpty(f10547g) == true) goto L14;
        if (TextUtils.isEmpty(r10) == true) goto L14;
        if (f10547g.equals(r10) == false) goto L14;
        if ((System.currentTimeMillis() - f10548h) >= 60000) goto L14;
    L69:
        if (t() == true) goto L72;
        return false;
    L72:
        if (r() == false) goto L75;
        return true;
    L14:
        if (TextUtils.isEmpty(r10) == true) goto L16;
        f10547g = r10;     // Catch: Throwable -> L66
    L16:
        f10548h = System.currentTimeMillis();     // Catch: Throwable -> L66
        HashMap r11 = f10546f;
        r11.clear();     // Catch: Throwable -> L66
        Iterator r12 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Throwable -> L66
    L19:
        if (r12.hasNext() == false) goto L69;
        NetworkInterface r13 = (NetworkInterface) r12.next();     // Catch: Throwable -> L66
        if (r13.getInterfaceAddresses().isEmpty() == true) goto L19;
        String r14 = r13.getDisplayName();     // Catch: Throwable -> L66
        Iterator<InterfaceAddress> r15 = r13.getInterfaceAddresses().iterator();     // Catch: Throwable -> L66
        int r16 = 0;
    L25:
        if (r15.hasNext() == false) goto L54;
        InetAddress r17 = r15.next().getAddress();     // Catch: Throwable -> L66
        if ((r17 instanceof Inet6Address) == true) goto L28;
        if ((r17 instanceof Inet4Address) == false) goto L25;
        Inet4Address r18 = (Inet4Address) r17;     // Catch: Throwable -> L66
        if (r18.isLoopbackAddress() == false) goto L44;
    L49:
        boolean r19 = true;
    L50:
        if (r19 == true) goto L25;
        if (r18.getHostAddress().startsWith(t4.n("FMTkyLjE2OC40My4")) == true) goto L25;
        r16 = r16 | 1;     // Catch: Throwable -> L66
        goto L25
    L44:
        if (r18.isLinkLocalAddress() == true) goto L49;
        if (r18.isAnyLocalAddress() == true) goto L49;
        r19 = false;
        goto L50
    L28:
        Inet6Address r20 = (Inet6Address) r17;     // Catch: Throwable -> L66
        if (r20.isLoopbackAddress() == false) goto L31;
    L36:
        boolean r21 = true;
    L37:
        if (r21 == true) goto L25;
        r16 = r16 | 2;     // Catch: Throwable -> L66
        goto L25
    L31:
        if (r20.isLinkLocalAddress() == true) goto L36;
        if (r20.isAnyLocalAddress() == true) goto L36;
        r21 = false;
        goto L37
    L54:
        if (r16 == 0) goto L19;
        if (r14 != null) goto L57;
    L60:
        if (r14 == null) goto L19;
        if (r14.startsWith("rmnet") == false) goto L19;
        String r22 = "MOBILE";
    L64:
        r11.put(r22, Integer.valueOf(r16));     // Catch: Throwable -> L66
        goto L19
    L57:
        if (r14.startsWith("wlan") == false) goto L60;
        r22 = "WIFI";
    L66:
        th = move-exception;
        l.a("at", "ipstack", th);
    L75:
        if (f10544d == true) goto L77;
        return false;
    L77:
        f r23 = b(f10543c, "IPV6_CONFIG_NAME");
        if (r23 != null) goto L80;
        return false;
    L80:
        AtomicInteger r24 = r23.f10585c;
        if (r24 != null) goto L83;
        int r25 = 0;
    L85:
        if (r25 >= 5) goto L87;
        return true;
    L87:
        return false;
    L83:
        r25 = r24.get();
        goto L85
    }

    public static synchronized boolean n(long r8, String r10) {
        monitor-enter(i4.class);
        boolean r11 = false;
        if (TextUtils.isEmpty(r10) == false) goto L9;
        monitor-exit(i4.class);
        return false;
    L9:
        h r12 = z(r10);     // Catch: Throwable -> L26
        long r13 = 0;
        if (r12 == null) goto L12;
        long r14 = r12.f10592a;     // Catch: Throwable -> L26
    L14:
        if (r8 == r14) goto L24;
        if (f10551k != null) goto L18;
    L20:
        if ((SystemClock.elapsedRealtime() - r13) <= 30000) goto L24;
        r11 = true;
        goto L24
    L18:
        if (f10551k.containsKey(r10) == false) goto L20;
        r13 = f10551k.get(r10).longValue();     // Catch: Throwable -> L26
        goto L20
    L12:
        r14 = 0;
    L24:
        monitor-exit(i4.class);
        return r11;
    }

    public static boolean o(String r8, boolean r10) {
    L10:
        return r10;
    L3:
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return r10;
    L5:
        String[] r11 = URLDecoder.decode(r8).split("/");     // Catch: Throwable -> L10
        if ((r11[r11.length - 1].charAt(4) % 2) != 1) goto L8;
        return true;
    L8:
        return false;
    }

    public static String p(String r8, String r10) {
        byte[] r11 = r8.getBytes();
        String r12 = null;
        MessageDigest r13 = MessageDigest.getInstance(t4.n("ETUQ1"));     // Catch: Throwable -> L5
        r13.update(r11);     // Catch: Throwable -> L5
        byte[] r14 = r13.digest();     // Catch: Throwable -> L5
    L13:
        r12 = t4.r(r14);     // Catch: Throwable -> L9
    L12:
        return defpackage.a.f(r10, "_", r12);
    L9:
        th = move-exception;
        l.a("ut", "h2s", th);
    L5:
        th = move-exception;
        l.a("MD5", "gmb", th);
        r14 = null;
        goto L13
    }

    public static void q(k0.c r8) {
        ArrayList<k0.a> r10 = f10565y;
        monitor-enter(r10);
        int r11 = 0;
        boolean r12 = false;
    L25:
        ArrayList<k0.a> r13 = f10565y;     // Catch: Throwable -> L22
        if (r11 >= r13.size()) goto L18;
        k0.a r14 = r13.get(r11);     // Catch: Throwable -> L22
        if (r8.f10685m.equals(r14.f10673a) == false) goto L17;
        if (r8.f10686n.equals(r14.f10676n) == false) goto L17;
        int r15 = r8.f10695w;     // Catch: Throwable -> L22
        int r16 = r14.f10677o;     // Catch: Throwable -> L22
        if (r15 != r16) goto L17;
        r12 = true;
        if (r16 != 1) goto L16;
        r14.f10680r = ((((long) r14.f10681s.get()) * r14.f10680r) + r8.f10688p) / ((long) (r14.f10681s.get() + 1));     // Catch: Throwable -> L22
    L16:
        r14.f10681s.getAndIncrement();     // Catch: Throwable -> L22
    L17:
        r11 = r11 + 1;     // Catch: Throwable -> L22
        goto L25
    L18:
        if (r12 == true) goto L20;
        r13.add(new k0.a(r8));     // Catch: Throwable -> L22
    L20:
        monitor-exit(r10);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public static boolean r() {
        Context r8 = f10543c;
        if (r8 != null) goto L5;
        return false;
    L5:
        String r10 = k4.p(r8);
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        Integer r11 = (Integer) f10546f.get(r10.toUpperCase());
        if (r11 != null) goto L12;
        return false;
    L12:
        if (r11.intValue() != 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static void s(Context r8) {
        f10556p = z.i(r8, "a13", true);
        f10559s = z.i(r8, "a6", true);
        f10557q = z.i(r8, "a7", false);
        f10555o = z.a(r8, 5000, "a8");
        f10558r = z.a(r8, 3, "a9");
        f10560t = z.i(r8, "a10", false);
        f10561u = z.a(r8, 3, "a11");
        f10562v = z.i(r8, "a12", false);
    }

    public static boolean t() {
        Context r8 = f10543c;
        if (r8 != null) goto L5;
        return false;
    L5:
        String r10 = k4.p(r8);
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return false;
    L8:
        Integer r11 = (Integer) f10546f.get(r10.toUpperCase());
        if (r11 != null) goto L12;
        return false;
    L12:
        if (r11.intValue() < 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static void u() {
        f r8 = b(f10543c, "IPV6_CONFIG_NAME");     // Catch: Throwable -> L8
        String r10 = t4.a(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L8
        boolean r11 = r10.equals(r8.f10584b);     // Catch: Throwable -> L8
        AtomicInteger r12 = r8.f10585c;
        if (r11 == true) goto L6;
        r8.f10584b = r10;     // Catch: Throwable -> L8
        r12.set(0);     // Catch: Throwable -> L8
    L6:
        r12.incrementAndGet();     // Catch: Throwable -> L8
        d(f10543c, "IPV6_CONFIG_NAME", r8);     // Catch: Throwable -> L8
        return;
    }

    public static synchronized boolean v(String r8) {
        monitor-enter(i4.class);
    L24:
        th = move-exception;
        l.a("at", "cslct", th);     // Catch: Throwable -> L28
    L26:
        monitor-exit(i4.class);
        return false;
    L28:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r8) == false) goto L10;
        monitor-exit(i4.class);
        return false;
    L10:
        if (f10552l != null) goto L14;
        monitor-exit(i4.class);
        return false;
    L14:
        if (f10551k != null) goto L17;
        f10551k = new ConcurrentHashMap(8);     // Catch: Throwable -> L24
    L17:
        if (f10552l.containsKey(r8) == false) goto L26;
        if (f10551k.containsKey(r8) == true) goto L26;
        f10551k.put(r8, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L24
        monitor-exit(i4.class);
        return true;
    }

    public static void w() {
        if (f10549i == false) goto L11;
        return;
    L11:
        Context r8 = f10543c;     // Catch: Throwable -> L10
        if (r8 != null) goto L8;
        return;
    L8:
        f10549i = true;     // Catch: Throwable -> L10
        m4.a.f10837a.a(r8);     // Catch: Throwable -> L10
        f10544d = z.i(r8, "a2", true);     // Catch: Throwable -> L10
        s(r8);     // Catch: Throwable -> L10
        g.f10586a = z.i(r8, "ucf", g.f10586a);     // Catch: Throwable -> L10
        g.f10587b = z.i(r8, "fsv2", g.f10587b);     // Catch: Throwable -> L10
        g.f10588c = z.i(r8, "usc", g.f10588c);     // Catch: Throwable -> L10
        g.f10589d = z.a(r8, g.f10589d, "umv");     // Catch: Throwable -> L10
        g.f10590e = z.i(r8, "ust", g.f10590e);     // Catch: Throwable -> L10
        g.f10591f = z.a(r8, g.f10591f, "ustv");     // Catch: Throwable -> L10
        return;
    }

    public static void x(Context r8) {
        if (f10554n == false) goto L6;
        return;
    L6:
        o(z.k(r8, "open_common", "a16"), true);     // Catch: Throwable -> L14
        r8.getSharedPreferences("open_common", 0).getLong("a17", WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS);     // Catch: Throwable -> L10
    L12:
        f10554n = true;     // Catch: Throwable -> L14
        return;
    L10:
        th = move-exception;
        q.f("csp", "glv", th);     // Catch: Throwable -> L14
    }

    public static k0.a y() {
        if (f10566z == false) goto L5;
        return null;
    L5:
        ArrayList<k0.a> r8 = f10565y;
        monitor-enter(r8);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (f10566z == false) goto L11;
        monitor-exit(r8);     // Catch: Throwable -> L18
        return null;
    L11:
        Collections.sort(r8);     // Catch: Throwable -> L18
        if (r8.size() <= 0) goto L16;
        k0.a r10 = r8.get(0).a();     // Catch: Throwable -> L18
        f10566z = true;     // Catch: Throwable -> L18
        monitor-exit(r8);     // Catch: Throwable -> L18
        return r10;
    L16:
        monitor-exit(r8);     // Catch: Throwable -> L18
        return null;
    }

    public static synchronized h z(String r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<qa.i4> r0 = qa.i4.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, qa.i4$h> r1 = qa.i4.f10550j     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L10
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L22
            r2 = 8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L22
            qa.i4.f10550j = r1     // Catch: java.lang.Throwable -> L22
        L10:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, qa.i4$h> r1 = qa.i4.f10550j     // Catch: java.lang.Throwable -> L22
            boolean r1 = r1.containsKey(r3)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L2a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, qa.i4$h> r1 = qa.i4.f10550j     // Catch: java.lang.Throwable -> L22
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Throwable -> L22
            qa.i4$h r3 = (qa.i4.h) r3     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            return r3
        L22:
            r3 = move-exception
            java.lang.String r1 = "at"
            java.lang.String r2 = "glcut"
            qa.l.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L39
        L2a:
            qa.i4$h r3 = new qa.i4$h     // Catch: java.lang.Throwable -> L39
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch: java.lang.Throwable -> L39
            java.lang.String r2 = ""
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L39
            monitor-exit(r0)
            return r3
        L39:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: qa.i4.z(java.lang.String):qa.i4$h");
    }
}
