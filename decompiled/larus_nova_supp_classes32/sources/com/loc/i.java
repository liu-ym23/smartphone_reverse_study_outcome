package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
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
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import n4a.b5;
import n4a.c4;
import n4a.e5;
import n4a.f5;
import n4a.i4;
import n4a.j0;
import n4a.k0;
import n4a.k1;
import n4a.l0;
import n4a.l1;
import n4a.n;
import n4a.r;
import n4a.r0;
import n4a.s0;
import n4a.x4;
import n4a.y;
import n4a.z4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class i {
    public static final Queue<com.loc.d.c> A = null;
    public static int a = -1;
    public static String b = "";
    public static Context c = null;
    public static volatile boolean d = true;
    public static final Vector<f> e = null;
    public static final Map<String, Integer> f = null;
    public static String g;
    public static long h;
    public static volatile boolean i;
    public static volatile ConcurrentHashMap<String, h> j;
    public static volatile ConcurrentHashMap<String, Long> k;
    public static volatile ConcurrentHashMap<String, e> l;
    public static boolean m;
    public static boolean n;
    public static int o;
    public static boolean p;
    public static boolean q;
    public static int r;
    public static boolean s;
    public static boolean t;
    public static int u;
    public static boolean v;
    public static final ConcurrentHashMap<String, Boolean> w = null;
    public static final ConcurrentHashMap<String, Boolean> x = null;
    public static final ArrayList<com.loc.d.a> y = null;
    public static volatile boolean z;

    public class a extends l1 {
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a(String r1, String r2, String r3, String r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }

        @Override // n4a.l1
        public final void a() {
            e r0 = i.l.get(this.b);
            if (r0 != null) goto L5;
            return;
        L5:
            b r2 = r0.c;
            e5 r10 = r0.a;
            String r3 = r0.b;
            Context r11 = i.c;
            String r7 = this.c;
            String r8 = this.d;
            String r9 = this.e;
            String r14 = "info";
            c r4 = new c();
            r4.b = new JSONObject();
            if (r11 == null) goto L8;
            i.c = r11.getApplicationContext();
        L8:
            i.x();
            SharedPreferences.Editor r19 = null;
            i.j(r10);     // Catch: Throwable -> L87 IllegalBlockSizeException -> L91 l -> L95
            i.x();     // Catch: Throwable -> L87 IllegalBlockSizeException -> L91 l -> L95
            boolean r1 = TextUtils.isEmpty(r3);     // Catch: Throwable -> L87 IllegalBlockSizeException -> L91 l -> L95
        L205:
            if (r1 == false) goto L206;
        L25:
            String r21 = r3;
            if (i.m == true) goto L201;
            n4a.c.b = y.i(r11, "a4", true);     // Catch: Throwable -> L178
            n4a.c.c = y.i(r11, "a5", true);     // Catch: Throwable -> L178
            i.m = true;     // Catch: Throwable -> L178
        L201:
            i.y(r11);     // Catch: Throwable -> L73 l -> L77
            String r22 = "infocode";
            String r23 = "info";
            r14 = "status";
            String r24 = "ver";
            l0 r5 = com.loc.c.a(new d(r11, r10, r21, r7, r8, r9));     // Catch: l -> L71 Throwable -> L175
            if (r1 == false) goto L212;
        L151:
            if (r2 == null) goto L217;
            Context r6 = ((com.loc.h.a) r2).a;
            SharedPreferences.Editor r12 = r6.getSharedPreferences("pref", 0).edit();     // Catch: Throwable -> L169
            com.loc.h.c(r4, r12);     // Catch: Throwable -> L168
            e5 r13 = c4.k();     // Catch: Throwable -> L176
            r13.c = com.loc.h.b ? 1 : 0;     // Catch: Throwable -> L176
            r.b(r6, r13);     // Catch: Throwable -> L176
        L156:
            JSONObject r15 = r4.b;     // Catch: Throwable -> L168
            if (r15 != null) goto L160;
            if (r12 != null) goto L197;
            return;
        L197:
            i4.e(r12);     // Catch: Throwable -> L177
            return;
        L221:
            return;
        L160:
            com.loc.h.b(r6, r15, r12);     // Catch: Throwable -> L168
            com.loc.h.d(r15, r12);     // Catch: Throwable -> L168
            com.loc.h.i(r15, r12);     // Catch: Throwable -> L168
            com.loc.h.j(r15, r12);     // Catch: Throwable -> L168
            com.loc.h.l(r15, r12);     // Catch: Throwable -> L168
            com.loc.h.k(r15, r12);     // Catch: Throwable -> L168
            com.loc.h.m(r15, r12);     // Catch: Throwable -> L168
            com.loc.h.h(r15, r12);     // Catch: Throwable -> L168
            JSONObject r16 = JSONObjectProtectorUtils.getJSONObject(r15, "1A6");     // Catch: Throwable -> L165
            if (r16 == null) goto L166;
            boolean r17 = i.o(r16.optString("ic"), false);     // Catch: Throwable -> L165
            i4.i(r12, "1A6", r17);     // Catch: Throwable -> L165
            com.loc.h.G = r17;     // Catch: Throwable -> L165
        L166:
            if (r12 != null) goto L197;
            return;
        L168:
            r19 = r12;
        L170:
            if (r19 == null) goto L220;
            r12 = r19;
            goto L197
        L220:
            return;
        L217:
            return;
        L212:
            byte[] r18 = r5.a;     // Catch: Throwable -> L65 IllegalBlockSizeException -> L67 l -> L69
            Map<String, List<String>> r20 = r5.b;     // Catch: Throwable -> L55
            if (r20 != null) goto L39;
        L57:
            byte[] r25 = new byte[16];     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            byte[] r26 = new byte[r18.length - 16];     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            System.arraycopy(r18, 0, r25, 0, 16);     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            System.arraycopy(r18, 16, r26, 0, r18.length - 16);     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            SecretKeySpec r27 = new SecretKeySpec(r25, f5.o("EQUVT"));     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            Cipher r28 = Cipher.getInstance(f5.o("CQUVTL0NCQy9QS0NTNVBhZGRpbmc"));     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            r28.init(2, r27, new IvParameterSpec(f5.p()));     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            String r29 = f5.d(r28.doFinal(r26));     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
        L100:
            String r30 = r21;
            if (r18 == null) goto L151;
            if (TextUtils.isEmpty(r29) == false) goto L107;
            r29 = f5.d(r18);
        L107:
            if (TextUtils.isEmpty(r29) == false) goto L183;
            i.d(r11, r10, "result is null");
        L183:
            JSONObject r110 = new JSONObject(r29);     // Catch: Throwable -> L149
            if (r110.has(r14) == false) goto L151;
            int r31 = JSONObjectProtectorUtils.getInt(r110, r14);     // Catch: Throwable -> L149
            if (r31 != 1) goto L114;
            i.a = 1;     // Catch: Throwable -> L149
        L129:
            String r32 = r24;
        L134:
            th = move-exception;
            n.a(th, "at", "lc");     // Catch: Throwable -> L149
        L137:
            if (f5.h(r110, "result") == false) goto L151;
            JSONObject r33 = JSONObjectProtectorUtils.getJSONObject(r110, "result");     // Catch: Throwable -> L149
            i.e(r11, r10, r30, r4, r33);     // Catch: Throwable -> L149
            JSONObject r34 = JSONObjectProtectorUtils.getJSONObject(r33, "15K");     // Catch: Throwable -> L148
            boolean r35 = i.o(r34.optString("isTargetAble"), false);     // Catch: Throwable -> L148
            if (i.o(r34.optString("able"), false) == true) goto L143;
            z4 r36 = z4.a.a;     // Catch: Throwable -> L148
            SharedPreferences.Editor r37 = y.b(r11, "open_common");     // Catch: Throwable -> L148
            y.h(r37, "a3", true);     // Catch: Throwable -> L148
            y.e(r37);     // Catch: Throwable -> L148
            goto L151
        L143:
            z4 r38 = z4.a.a;     // Catch: Throwable -> L148
            if (r38.a != null) goto L146;
            r38.a = new z4.b();     // Catch: Throwable -> L148
        L146:
            SharedPreferences.Editor r39 = y.b(r11, "open_common");     // Catch: Throwable -> L148
            y.h(r39, "a3", r35);     // Catch: Throwable -> L148
            y.e(r39);     // Catch: Throwable -> L148
            r38.a.b = r35;     // Catch: Throwable -> L148
            goto L151
        L131:
            if (r110.has(r32) == false) goto L137;
            JSONObjectProtectorUtils.getInt(r110, r32);     // Catch: Throwable -> L134
        L114:
            if (r31 != 0) goto L129;
            if (r5 == null) goto L118;
            String r40 = r5.c;     // Catch: Throwable -> L149
            String r41 = r5.d;     // Catch: Throwable -> L149
        L119:
            f5.e(r11, r40, r41, r110);     // Catch: Throwable -> L149
            i.a = 0;     // Catch: Throwable -> L149
            String r42 = r23;
            if (r110.has(r42) == false) goto L122;
            i.b = JSONObjectProtectorUtils.getString(r110, r42);     // Catch: Throwable -> L149
        L122:
            String r43 = r22;
            if (r110.has(r43) == false) goto L125;
            String r44 = JSONObjectProtectorUtils.getString(r110, r43);     // Catch: Throwable -> L149
        L126:
            r.d(r10, "/v3/iasdkauth", i.b, r41, r40, r44);     // Catch: Throwable -> L149
            if (i.a != 0) goto L129;
        L125:
            r44 = NameKeys.UnloadStrategy_No_Strategy;
            goto L126
        L118:
            r40 = "authcsid";
            r41 = "authgsid";
        L149:
            th = move-exception;
            n.a(th, "at", "lc");
            goto L151
        L63:
            e = e;
            l0 r45 = r5;
            byte[] r111 = r18;
        L98:
            e.a();
            i.d(r11, r10, e.a());
            Set<Integer> r46 = r.e;
            r.d(r10, "/v3/iasdkauth", e.c(), e.d(), e.e(), e.b());
            r5 = r45;
            r18 = r111;
        L99:
            r29 = null;
        L61:
            e = e;
        L94:
            i.d(r11, r10, e.getMessage());
        L59:
            e = th;
        L90:
            r.f(e, "at", "lc");
            goto L94
        L39:
            if (r20.containsKey("lct") == false) goto L57;
            List<String> r47 = r20.get("lct");     // Catch: Throwable -> L55
            List<String> r48 = r20.get("lct-info");     // Catch: Throwable -> L55
            r4.a = i.a(r47);     // Catch: Throwable -> L55
            if (r48 != null) goto L199;
        L47:
            String r49 = NameKeys.UnloadStrategy_No_Strategy;
        L49:
            if (r4.a == 0) goto L57;
            if (r10 == null) goto L57;
            String r50 = r10.a();     // Catch: Throwable -> L55
            if (TextUtils.isEmpty(r50) == true) goto L57;
            i.g(r50, r4.a, r49);     // Catch: Throwable -> L55
            goto L57
        L199:
            if (r48.size() <= 0) goto L47;
            r49 = (String) ListProtector.get(r48, 0);     // Catch: Exception -> L179 Throwable -> L55
            if (TextUtils.isEmpty(r49) == true) goto L47;
        L55:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            r.f(th, "at", "lct");     // Catch: Throwable -> L59 IllegalBlockSizeException -> L61 l -> L63
            goto L57
        L69:
            e = e;
            r45 = r5;
            r111 = null;
        L67:
            e = e;
            r18 = null;
        L65:
            e = th;
            r18 = null;
            goto L90
        L71:
            e = move-exception;
            throw e;     // Catch: Throwable -> L81 IllegalBlockSizeException -> L83 l -> L85
        L76:
            throw new l("未知的错误");     // Catch: Throwable -> L81 IllegalBlockSizeException -> L83 l -> L85
        L77:
            e = e;
            String r51 = r21;
        L80:
            throw e;     // Catch: Throwable -> L81 IllegalBlockSizeException -> L83 l -> L85
        L73:
            String r52 = r21;
            goto L76
        L206:
        L20:
            e = e;
            String r210 = r3;
        L24:
            r51 = r210;
        L19:
            r210 = r3;
        L23:
            r52 = r210;
            goto L76
        L12:
            if (TextUtils.isEmpty(r3) == true) goto L25;
            StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L19 l -> L20
            r112.append(r3);     // Catch: Throwable -> L19 l -> L20
            r210 = r3;
            r112.append(";15K;16H;17I;1A4;17S;183");     // Catch: l -> L17 Throwable -> L174
            r3 = r112.toString();     // Catch: l -> L17 Throwable -> L174
        L17:
            e = e;
            goto L24
        L85:
            e = e;
        L97:
            r21 = r3;
            r45 = null;
            r111 = null;
        L83:
            e = e;
        L93:
            r21 = r3;
            r5 = null;
            r18 = null;
        L81:
            e = th;
        L89:
            r21 = r3;
            r5 = null;
            r18 = null;
        L95:
            e = e;
            r24 = "ver";
            r22 = "infocode";
            r23 = "info";
            r14 = "status";
        L91:
            e = e;
            r24 = "ver";
            r22 = "infocode";
            r23 = "info";
            r14 = "status";
        L87:
            e = th;
            r24 = "ver";
            r22 = "infocode";
            r23 = "info";
            r14 = "status";
            goto L89
        }
    }

    public interface b {
    }

    public static class c {
        public long a;
        public JSONObject b;
        public a c;

        public static class a {
            public boolean a;
            public JSONObject b;

            public a() {
            }
        }

        public c() {
            this.a = 0;
        }
    }

    public static class d extends j0 {
        public final String n;
        public final String o;
        public final String p;
        public final String q;

        @Override // com.loc.bo
        public final Map<String, String> a() {
            if (TextUtils.isEmpty(this.q) == true) goto L6;
            HashMap r0 = new HashMap();
            r0.put("host", this.q);
            return r0;
        L6:
            return null;
        }

        @Override // com.loc.bo
        public final String j() {
            if (TextUtils.isEmpty(this.q) == false) goto L5;
            return NameKeys.UnloadStrategy_No_Strategy;
        L5:
            return this.q;
        }

        @Override // n4a.j0
        public final byte[] p() {
            return null;
        }

        @Override // n4a.j0
        public final String r() {
            return "3.0";
        }

        @Override // com.loc.bo
        public final String c() {
            String r1 = this.o;
            if (TextUtils.isEmpty(r1) == true) goto L10;
            return UriProtector.parse("https://restsdk.amap.com/v3/iasdkauth").buildUpon().encodedAuthority(r1).build().toString();
        L10:
            return "https://restsdk.amap.com/v3/iasdkauth";
        L11:
            return "https://restsdk.amap.com/v3/iasdkauth";
        }

        @Override // n4a.a5, com.loc.bo
        public final String e() {
            String r1 = this.p;
            if (TextUtils.isEmpty(r1) == true) goto L10;
            return UriProtector.parse("https://dualstack-arestapi.amap.com/v3/iasdkauth").buildUpon().encodedAuthority(r1).build().toString();
        L10:
            return "https://dualstack-arestapi.amap.com/v3/iasdkauth";
        L11:
            return "https://dualstack-arestapi.amap.com/v3/iasdkauth";
        }

        @Override // n4a.j0
        public final byte[] q() {
            String r0 = x4.u(this.k);
            if (TextUtils.isEmpty(r0) == true) goto L5;
            r0 = b5.a(new StringBuilder(r0).reverse().toString());
        L5:
            HashMap r1 = new HashMap();
            if (TextUtils.isEmpty(this.n) == false) goto L8;
            String r2 = NameKeys.UnloadStrategy_No_Strategy;
        L9:
            r1.put("authkey", r2);
            r1.put("plattype", "android");
            r1.put("ccver", "1");
            r1.put("product", this.l.a());
            r1.put("version", this.l.f);
            r1.put("output", "json");
            StringBuilder r3 = new StringBuilder();
            r3.append(Build.VERSION.SDK_INT);
            r1.put("androidversion", r3.toString());
            r1.put("deviceId", r0);
            r1.put("manufacture", Build.MANUFACTURER);
            r1.put("abitype", f5.c(this.k));
            r1.put("ext", this.l.c());
            if (r1.size() != 0) goto L12;
            String r4 = null;
        L26:
            return f5.j(r4);
        L12:
            StringBuffer r5 = new StringBuffer();
            Iterator r6 = r1.entrySet().iterator();     // Catch: Throwable -> L22
            boolean r7 = true;
        L14:
            if (r6.hasNext() == false) goto L24;
            Map.Entry r8 = (Map.Entry) r6.next();     // Catch: Throwable -> L22
            if (r7 == true) goto L19;
            r5.append("&");     // Catch: Throwable -> L22
            r5.append((String) r8.getKey());     // Catch: Throwable -> L22
            r5.append("=");     // Catch: Throwable -> L22
            r5.append((String) r8.getValue());     // Catch: Throwable -> L22
            goto L14
        L19:
            r5.append((String) r8.getKey());     // Catch: Throwable -> L22
            r5.append("=");     // Catch: Throwable -> L22
            r5.append((String) r8.getValue());     // Catch: Throwable -> L22
            r7 = false;
        L24:
            r4 = r5.toString();
        L22:
            th = move-exception;
            n.a(th, "ut", "abP");
            goto L24
        L8:
            r2 = this.n;
            goto L9
        }

        public d(Context r1, e5 r2, String r3, String r4, String r5, String r6) {
            super(r1, r2);
            this.n = r3;
            this.o = r4;
            this.p = r5;
            this.q = r6;
            b(bo.c.b);
            this.i = bo.a.d;
        }
    }

    public static class e {
        public e5 a;
        public String b;
        public b c;

        public e() {
        }
    }

    public static class f {
        public final String a;
        public String b;
        public final AtomicInteger c;

        public f(String r1, String r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = new AtomicInteger(r3);
        }
    }

    public static class g {
        public static boolean a = true;
        public static boolean b = false;
        public static boolean c = true;
        public static int d;
        public static boolean e;
        public static int f;
    }

    public static class h {
        public final long a;
        public final String b;

        public h(Long r3, String r4) {
            this.a = 0;
            this.b = NameKeys.UnloadStrategy_No_Strategy;
            this.a = r3.longValue();
            this.b = r4;
        }
    }

    static {
        e = new Vector();
        f = new HashMap();
        g = null;
        h = 0;
        i = false;
        j = new ConcurrentHashMap(8);
        k = new ConcurrentHashMap(8);
        l = new ConcurrentHashMap(8);
        m = false;
        n = false;
        o = 5000;
        p = true;
        q = false;
        r = 3;
        s = true;
        t = false;
        u = 3;
        v = false;
        w = new ConcurrentHashMap();
        x = new ConcurrentHashMap();
        y = new ArrayList();
        A = new LinkedList();
    }

    public static synchronized h A(String r3) {
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
            java.lang.Class<com.loc.i> r0 = com.loc.i.class
            monitor-enter(r0)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.i$h> r1 = com.loc.i.j     // Catch: java.lang.Throwable -> L22
            if (r1 != 0) goto L10
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L22
            r2 = 8
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L22
            com.loc.i.j = r1     // Catch: java.lang.Throwable -> L22
        L10:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.i$h> r1 = com.loc.i.j     // Catch: java.lang.Throwable -> L22
            boolean r1 = r1.containsKey(r3)     // Catch: java.lang.Throwable -> L22
            if (r1 == 0) goto L2a
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.loc.i$h> r1 = com.loc.i.j     // Catch: java.lang.Throwable -> L22
            java.lang.Object r3 = r1.get(r3)     // Catch: java.lang.Throwable -> L22
            com.loc.i$h r3 = (com.loc.i.h) r3     // Catch: java.lang.Throwable -> L22
            monitor-exit(r0)
            return r3
        L22:
            r3 = move-exception
            java.lang.String r1 = "at"
            java.lang.String r2 = "glcut"
            n4a.n.a(r3, r1, r2)     // Catch: java.lang.Throwable -> L39
        L2a:
            com.loc.i$h r3 = new com.loc.i$h     // Catch: java.lang.Throwable -> L39
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.i.A(java.lang.String):com.loc.i$h");
    }

    public static long a(List<String> r2) {
        if (r2 == null) goto L15;
    L9:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L4:
        if (r2.size() <= 0) goto L16;
        String r3 = (String) ListProtector.get(r2, 0);     // Catch: Exception -> L9
        if (TextUtils.isEmpty(r3) == true) goto L17;
        return CastLongProtector.valueOf(r3).longValue();
    L17:
        return 0;
    L16:
        return 0;
    L15:
        return 0;
    }

    public static void d(Context r3, e5 r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("amap_sdk_auth_fail", "1");
        r0.put("amap_sdk_auth_fail_type", r5);
        r0.put("amap_sdk_name", r4.a());
        r0.put("amap_sdk_version", r4.b());
        String r6 = new JSONObject(r0).toString();
        if (TextUtils.isEmpty(r6) == false) goto L8;
        return;
    L8:
        r0 r7 = new r0(r3, "core", "2.0", "O001");     // Catch: l -> L7
        r7.a(r6);     // Catch: l -> L7
        s0.c(r7, r3);     // Catch: l -> L7
        return;
    }

    public static void i(String r4, boolean r5, boolean r6, boolean r7) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return;
    L5:
        if (c == null) goto L32;
        HashMap r0 = new HashMap();
        r0.put(LynxEventReporter.PROP_NAME_URL, r4);
        r0.put("downLevel", String.valueOf(r5));
        String r1 = "0";
        if (x4.r(c) != 0) goto L10;
        Object r8 = "0";
    L11:
        r0.put("ant", r8);
        if (r7 == false) goto L16;
        if (r5 == false) goto L15;
        String r9 = "9";
    L19:
        r0.put("type", r9);
        if (r6 == true) goto L23;
        r1 = "1";
    L23:
        r0.put("status", r1);
        String r10 = new JSONObject(r0).toString();
        if (TextUtils.isEmpty(r10) == false) goto L29;
        return;
    L29:
        r0 r11 = new r0(c, "core", "2.0", "O002");     // Catch: l -> L28
        r11.a(r10);     // Catch: l -> L28
        s0.c(r11, c);     // Catch: l -> L28
        return;
    L33:
        return;
    L15:
        r9 = "8";
        goto L19
    L16:
        if (r5 == false) goto L18;
        r9 = "6";
        goto L19
    L18:
        r9 = "4";
        goto L19
    L10:
        r8 = "1";
        goto L11
    }

    public static void k(boolean r4, com.loc.d.a r5) {
        if (z == false) goto L31;
        if (r5 == null) goto L47;
        ArrayList<com.loc.d.a> r0 = y;
        monitor-enter(r0);
        if (r4 == true) goto L32;
    L22:
        z = false;     // Catch: Throwable -> L28
        Iterator<com.loc.d.a> r6 = y.iterator();     // Catch: Throwable -> L28
    L24:
        if (r6.hasNext() == false) goto L26;
        com.loc.d.a r7 = r6.next();     // Catch: Throwable -> L28
        String r1 = r7.d;     // Catch: Throwable -> L28
        Objects.toString(r7.i);     // Catch: Throwable -> L28
        goto L24
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L28
        return;
    L28:
        th = move-exception;
        throw th;
    L32:
        Iterator<com.loc.d.a> r8 = r0.iterator();     // Catch: Throwable -> L28
    L11:
        if (r8.hasNext() == false) goto L22;
        com.loc.d.a r2 = r8.next();     // Catch: Throwable -> L28
        if (r2.a.equals(r5.a) == false) goto L11;
        if (r2.d.equals(r5.d) == false) goto L11;
        if (r2.e != r5.e) goto L11;
        if (r2.i == r5.i) goto L20;
        r2.i.set(r2.i.get() - r5.i.get());     // Catch: Throwable -> L28
        goto L11
    L20:
        r8.remove();     // Catch: Throwable -> L28
        goto L11
    L47:
        return;
    }

    public static void l(boolean r2, String r3) {
        "--markHostNameFailed---hostname=".concat(String.valueOf(r3));     // Catch: Throwable -> L24
        if (p == true) goto L7;
        if (r2 == true) goto L7;
        return;
    L7:
        if (t == true) goto L11;
        if (r2 == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r3) == false) goto L13;
        return;
    L13:
        if (r2 == true) goto L19;
        ConcurrentHashMap<String, Boolean> r4 = w;     // Catch: Throwable -> L24
        if (r4.get(r3) == null) goto L17;
        return;
    L17:
        r4.put(r3, Boolean.TRUE);     // Catch: Throwable -> L24
        f(p(r3, "a14"));     // Catch: Throwable -> L24
        return;
    L19:
        ConcurrentHashMap<String, Boolean> r5 = x;     // Catch: Throwable -> L24
        if (r5.get(r3) == null) goto L22;
        return;
    L22:
        r5.put(r3, Boolean.TRUE);     // Catch: Throwable -> L24
        f(p(r3, "a15"));     // Catch: Throwable -> L24
        return;
    }

    public static synchronized boolean n(String r7, long r8) {
        monitor-enter(i.class);
        boolean r1 = false;
        if (TextUtils.isEmpty(r7) == false) goto L9;
        monitor-exit(i.class);
        return false;
    L9:
        h r2 = A(r7);     // Catch: Throwable -> L26
        long r3 = 0;
        if (r2 == null) goto L12;
        long r5 = r2.a;     // Catch: Throwable -> L26
    L14:
        if (r8 == r5) goto L24;
        if (k != null) goto L18;
    L20:
        if ((SystemClock.elapsedRealtime() - r3) <= AutoEndConversationTime.AFTER_30_SECONDS) goto L24;
        r1 = true;
        goto L24
    L18:
        if (k.containsKey(r7) == false) goto L20;
        r3 = k.get(r7).longValue();     // Catch: Throwable -> L26
        goto L20
    L12:
        r5 = 0;
    L24:
        monitor-exit(i.class);
        return r1;
    }

    public static boolean o(String r2, boolean r3) {
    L10:
        return r3;
    L3:
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return r3;
    L5:
        String[] r4 = URLDecoder.decode(r2).split("/");     // Catch: Throwable -> L10
        if ((r4[r4.length - 1].charAt(4) % 2) != 1) goto L8;
        return true;
    L8:
        return false;
    }

    public static void q(com.loc.d.c r8) {
        ArrayList<com.loc.d.a> r0 = y;
        monitor-enter(r0);
        int r1 = 0;
        boolean r2 = false;
    L25:
        ArrayList<com.loc.d.a> r3 = y;     // Catch: Throwable -> L22
        if (r1 >= r3.size()) goto L18;
        com.loc.d.a r4 = r3.get(r1);     // Catch: Throwable -> L22
        if (r8.c.equals(r4.a) == false) goto L17;
        if (r8.d.equals(r4.d) == false) goto L17;
        int r5 = r8.m;     // Catch: Throwable -> L22
        int r6 = r4.e;     // Catch: Throwable -> L22
        if (r5 != r6) goto L17;
        r2 = true;
        if (r6 != 1) goto L16;
        r4.h = ((((long) r4.i.get()) * r4.h) + r8.f) / ((long) (r4.i.get() + 1));     // Catch: Throwable -> L22
    L16:
        r4.i.getAndIncrement();     // Catch: Throwable -> L22
    L17:
        r1 = r1 + 1;     // Catch: Throwable -> L22
        goto L25
    L18:
        if (r2 == true) goto L20;
        r3.add(new com.loc.d.a(r8));     // Catch: Throwable -> L22
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public static synchronized void r(String r2, boolean r3) {
        monitor-enter(i.class);
        h(r2, r3, null, null, null);     // Catch: Throwable -> L8
        monitor-exit(i.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static boolean s() {
        Context r0 = c;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = x4.t(r0);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return false;
    L8:
        Map<String, Integer> r2 = f;
        HashMap r3 = (HashMap) r2;
        Integer r4 = (Integer) r3.get(r1.toUpperCase());
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.intValue() != 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static void t(Context r3) {
        p = y.i(r3, "a13", true);
        s = y.i(r3, "a6", true);
        q = y.i(r3, "a7", false);
        o = y.a(r3, "a8", 5000);
        r = y.a(r3, "a9", 3);
        t = y.i(r3, "a10", false);
        u = y.a(r3, "a11", 3);
        v = y.i(r3, "a12", false);
    }

    public static boolean u() {
        Context r0 = c;
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = x4.t(r0);
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return false;
    L8:
        Map<String, Integer> r2 = f;
        HashMap r3 = (HashMap) r2;
        Integer r4 = (Integer) r3.get(r1.toUpperCase());
        if (r4 != null) goto L12;
        return false;
    L12:
        if (r4.intValue() < 2) goto L15;
        return true;
    L15:
        return false;
    }

    public static synchronized boolean w(String r5) {
        monitor-enter(i.class);
    L24:
        th = move-exception;
        n.a(th, "at", "cslct");     // Catch: Throwable -> L28
    L26:
        monitor-exit(i.class);
        return false;
    L28:
        th = move-exception;
        throw th;
    L6:
        if (TextUtils.isEmpty(r5) == false) goto L10;
        monitor-exit(i.class);
        return false;
    L10:
        if (l != null) goto L14;
        monitor-exit(i.class);
        return false;
    L14:
        if (k != null) goto L17;
        k = new ConcurrentHashMap(8);     // Catch: Throwable -> L24
    L17:
        if (l.containsKey(r5) == false) goto L26;
        if (k.containsKey(r5) == true) goto L26;
        k.put(r5, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L24
        monitor-exit(i.class);
        return true;
    }

    public static com.loc.d.a z() {
        if (z == false) goto L5;
        return null;
    L5:
        ArrayList<com.loc.d.a> r0 = y;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (z == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    L11:
        Collections.sort(r0);     // Catch: Throwable -> L18
        if (r0.size() <= 0) goto L16;
        com.loc.d.a r1 = r0.get(0).a();     // Catch: Throwable -> L18
        z = true;     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return r1;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return null;
    }

    public static boolean m() {
        Context r0 = c;
        if (r0 == null) goto L73;
        String r1 = x4.t(r0);     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(g) == true) goto L14;
        if (TextUtils.isEmpty(r1) == true) goto L14;
        if (g.equals(r1) == false) goto L14;
        if ((System.currentTimeMillis() - h) >= AutoEndConversationTime.AFTER_60_SECONDS) goto L14;
    L67:
        if (u() == true) goto L70;
        return false;
    L70:
        if (s() == false) goto L73;
        return true;
    L14:
        if (TextUtils.isEmpty(r1) == true) goto L16;
        g = r1;     // Catch: Throwable -> L64
    L16:
        h = System.currentTimeMillis();     // Catch: Throwable -> L64
        ((HashMap) f).clear();     // Catch: Throwable -> L64
        Iterator r2 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Throwable -> L64
    L17:
        if (r2.hasNext() == false) goto L67;
        NetworkInterface r3 = (NetworkInterface) r2.next();     // Catch: Throwable -> L64
        if (r3.getInterfaceAddresses().isEmpty() == true) goto L17;
        String r4 = r3.getDisplayName();     // Catch: Throwable -> L64
        Iterator<InterfaceAddress> r5 = r3.getInterfaceAddresses().iterator();     // Catch: Throwable -> L64
        int r6 = 0;
    L23:
        if (r5.hasNext() == false) goto L52;
        InetAddress r7 = r5.next().getAddress();     // Catch: Throwable -> L64
        if ((r7 instanceof Inet6Address) == true) goto L26;
        if ((r7 instanceof Inet4Address) == false) goto L23;
        Inet4Address r8 = (Inet4Address) r7;     // Catch: Throwable -> L64
        if (r8.isLoopbackAddress() == false) goto L42;
    L47:
        boolean r9 = true;
    L48:
        if (r9 == true) goto L23;
        if (r8.getHostAddress().startsWith(f5.o("FMTkyLjE2OC40My4")) == true) goto L23;
        r6 = r6 | 1;     // Catch: Throwable -> L64
        goto L23
    L42:
        if (r8.isLinkLocalAddress() == true) goto L47;
        if (r8.isAnyLocalAddress() == true) goto L47;
        r9 = false;
        goto L48
    L26:
        Inet6Address r10 = (Inet6Address) r7;     // Catch: Throwable -> L64
        if (r10.isLoopbackAddress() == false) goto L29;
    L34:
        boolean r11 = true;
    L35:
        if (r11 == true) goto L23;
        r6 = r6 | 2;     // Catch: Throwable -> L64
        goto L23
    L29:
        if (r10.isLinkLocalAddress() == true) goto L34;
        if (r10.isAnyLocalAddress() == true) goto L34;
        r11 = false;
        goto L35
    L52:
        if (r6 == 0) goto L17;
        if (r4 != null) goto L55;
    L58:
        if (r4 == null) goto L17;
        if (r4.startsWith("rmnet") == false) goto L17;
        Map<String, Integer> r12 = f;     // Catch: Throwable -> L64
        String r13 = "MOBILE";
    L62:
        ((HashMap) r12).put(r13, Integer.valueOf(r6));     // Catch: Throwable -> L64
        goto L17
    L55:
        if (r4.startsWith("wlan") == false) goto L58;
        r12 = f;     // Catch: Throwable -> L64
        r13 = "WIFI";
    L64:
        th = move-exception;
        n.a(th, "at", "ipstack");
    L73:
        if (d == true) goto L75;
        return false;
    L75:
        f r14 = b(c, "IPV6_CONFIG_NAME");
        if (r14 != null) goto L78;
        return false;
    L78:
        AtomicInteger r15 = r14.c;
        if (r15 != null) goto L81;
        int r16 = 0;
    L83:
        if (r16 >= 5) goto L85;
        return true;
    L85:
        return false;
    L81:
        r16 = r15.get();
        goto L83
    }

    public static void v() {
        f r1 = b(c, "IPV6_CONFIG_NAME");     // Catch: Throwable -> L7
        String r2 = f5.b(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L7
        if (r2.equals(r1.b) == true) goto L5;
        r1.b = r2;     // Catch: Throwable -> L7
        r1.c.set(0);     // Catch: Throwable -> L7
    L5:
        r1.c.incrementAndGet();     // Catch: Throwable -> L7
        c(c, "IPV6_CONFIG_NAME", r1);     // Catch: Throwable -> L7
        return;
    }

    public static void x() {
        if (i == false) goto L11;
        return;
    L11:
        Context r0 = c;     // Catch: Throwable -> L10
        if (r0 != null) goto L8;
        return;
    L8:
        i = true;     // Catch: Throwable -> L10
        z4.a.a.a(r0);     // Catch: Throwable -> L10
        d = y.i(r0, "a2", true);     // Catch: Throwable -> L10
        t(r0);     // Catch: Throwable -> L10
        g.a = y.i(r0, "ucf", g.a);     // Catch: Throwable -> L10
        g.b = y.i(r0, "fsv2", g.b);     // Catch: Throwable -> L10
        g.c = y.i(r0, "usc", g.c);     // Catch: Throwable -> L10
        g.d = y.a(r0, "umv", g.d);     // Catch: Throwable -> L10
        g.e = y.i(r0, "ust", g.e);     // Catch: Throwable -> L10
        g.f = y.a(r0, "ustv", g.f);     // Catch: Throwable -> L10
        return;
    }

    public static boolean B(String r4) {
    L29:
        return true;
    L4:
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return true;
    L7:
        if (p == true) goto L10;
        return false;
    L10:
        if (w.get(r4) != null) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == true) goto L15;
        return false;
    L15:
        Context r2 = c;     // Catch: Throwable -> L29
        if (r2 != null) goto L18;
        return true;
    L18:
        f r5 = b(r2, p(r4, "a14"));     // Catch: Throwable -> L29
        if (r5 != null) goto L21;
        return true;
    L21:
        AtomicInteger r6 = r5.c;     // Catch: Throwable -> L29
        if (r6 != null) goto L24;
        int r7 = 0;
    L25:
        if (r7 >= r) goto L28;
        return true;
    L28:
        return false;
    L24:
        r7 = r6.get();     // Catch: Throwable -> L29
        goto L25
    L12:
        r1 = false;
        goto L13
    }

    public static void f(String r4) {
        f r0 = b(c, r4);
        String r1 = f5.b(System.currentTimeMillis(), "yyyyMMdd");
        if (r1.equals(r0.b) == true) goto L5;
        r0.b = r1;
        r0.c.set(0);
    L5:
        r0.c.incrementAndGet();
        c(c, r4, r0);
    }

    public static void j(e5 r2) {
        if (r2 == null) goto L17;
        if (TextUtils.isEmpty(r2.a()) == false) goto L6;
        return;
    L6:
        String r0 = r2.b();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = r2.f;     // Catch: Throwable -> L14
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L12;
        return;
    L12:
        n4a.c.b(r2.a(), r0);     // Catch: Throwable -> L14
        return;
    L18:
        return;
    }

    public static void y(Context r5) {
        if (n == false) goto L6;
        return;
    L6:
        o(y.k(r5, "open_common", "a16"), true);     // Catch: Throwable -> L14
        r5.getSharedPreferences("open_common", 0).getLong("a17", 86400000);     // Catch: Throwable -> L10
    L12:
        n = true;     // Catch: Throwable -> L14
        return;
    L10:
        th = move-exception;
        r.f(th, "csp", "glv");     // Catch: Throwable -> L14
    }

    public static synchronized f b(Context r7, String r8) {
        monitor-enter(i.class);
        f r4 = null;
        if (TextUtils.isEmpty(r8) == true) goto L15;
        int r2 = 0;
    L7:
        Vector<f> r5 = e;     // Catch: Throwable -> L36
        if (r2 >= r5.size()) goto L15;
        f r6 = r5.get(r2);     // Catch: Throwable -> L36
        if (r6 == null) goto L14;
        if (r8.equals(r6.a) == false) goto L14;
    L16:
        if (r6 == null) goto L19;
        monitor-exit(i.class);
        return r6;
    L19:
        if (r7 != null) goto L22;
        monitor-exit(i.class);
        return null;
    L22:
        String r9 = y.k(r7, "open_common", r8);     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r9) == false) goto L42;
    L27:
        String r10 = f5.b(System.currentTimeMillis(), "yyyyMMdd");     // Catch: Throwable -> L36
        if (r4 != null) goto L31;
        r4 = new f(r8, r10, 0);     // Catch: Throwable -> L36
    L31:
        if (r10.equals(r4.b) == true) goto L33;
        r4.b = r10;     // Catch: Throwable -> L36
        r4.c.set(0);     // Catch: Throwable -> L36
    L33:
        e.add(r4);     // Catch: Throwable -> L36
        monitor-exit(i.class);
        return r4;
    L42:
        JSONObject r0 = new JSONObject(r9);     // Catch: Throwable -> L39
        r4 = new f(r0.optString("a"), r0.optString("f"), r0.optInt("h"));     // Catch: Throwable -> L39
    L14:
        r2 = r2 + 1;
    L15:
        r6 = null;
    L36:
        th = move-exception;
        throw th;
    }

    public static String p(String r3, String r4) {
        byte[] r5 = r3.getBytes();
        String r1 = null;
        MessageDigest r0 = MessageDigest.getInstance(f5.o("ETUQ1"));     // Catch: Throwable -> L5
        r0.update(r5);     // Catch: Throwable -> L5
        byte[] r6 = r0.digest();     // Catch: Throwable -> L5
    L13:
        r1 = f5.s(r6);     // Catch: Throwable -> L9
    L12:
        return r4 + "_" + r1;
    L9:
        th = move-exception;
        n.a(th, "ut", "h2s");
    L5:
        th = move-exception;
        n.a(th, "MD5", "gmb");
        r6 = null;
        goto L13
    }

    public static void c(Context r3, String r4, f r5) {
        if (TextUtils.isEmpty(r5.a) == true) goto L17;
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L7
        r0.put("a", r5.a);     // Catch: Throwable -> L7
        r0.put("f", r5.b);     // Catch: Throwable -> L7
        r0.put("h", r5.c.get());     // Catch: Throwable -> L7
        String r6 = r0.toString();     // Catch: Throwable -> L7
    L9:
        if (TextUtils.isEmpty(r6) == false) goto L11;
        return;
    L11:
        if (r3 != null) goto L13;
        return;
    L13:
        SharedPreferences.Editor r7 = y.b(r3, "open_common");
        r7.putString(r4, r6);
        y.e(r7);
        return;
    L7:
        r6 = NameKeys.UnloadStrategy_No_Strategy;
        goto L9
    }

    public static synchronized void g(String r4, long r5, String r7) {
        monitor-enter(i.class);
    L23:
        th = move-exception;
        n.a(th, "at", "ucut");     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (l != null) goto L7;
    L28:
        monitor-exit(i.class);
        return;
    L7:
        if (l.containsKey(r4) == false) goto L28;
        if (j != null) goto L12;
        j = new ConcurrentHashMap(8);     // Catch: Throwable -> L23
    L12:
        j.put(r4, new h(Long.valueOf(r5), r7));     // Catch: Throwable -> L23
        Context r1 = c;     // Catch: Throwable -> L23
        if (r1 == null) goto L26;
        SharedPreferences.Editor r2 = y.b(r1, "open_common");     // Catch: Throwable -> L23
        if (r2 != null) goto L17;
    L25:
        y.g(r2, r4 + "lct-info", r7);     // Catch: Throwable -> L23
        y.e(r2);     // Catch: Throwable -> L23
        goto L26
    L17:
        if (TextUtils.isEmpty(r4) == true) goto L25;
        r2.putLong(r4, r5);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r.f(th, "csp", "plv");     // Catch: Throwable -> L23
    L26:
        monitor-exit(i.class);
    }

    public static void e(Context r20, e5 r21, String r22, c r23, JSONObject r24) throws JSONException {
        c r0 = r23;
        c.a r10 = new c.a();
        r10.a = false;
        r0.c = r10;
        String[] r12 = r22.split(";");     // Catch: Throwable -> L13
        if (r12 == null) goto L16;
        if (r12.length <= 0) goto L16;
        int r13 = r12.length;     // Catch: Throwable -> L13
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L16;
        String r15 = r12[r14];     // Catch: Throwable -> L13
        if (r24.has(r15) == false) goto L12;
        r0.b.putOpt(r15, r24.get(r15));     // Catch: Throwable -> L13
    L12:
        r14 = r14 + 1;
        r0 = r23;
    L16:
        if (f5.h(r24, "16H") == false) goto L22;
        o(JSONObjectProtectorUtils.getJSONObject(r24, "16H").optString("able"), false);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 16H");
    L22:
        if (f5.h(r24, "11K") == false) goto L30;
        JSONObject r1 = JSONObjectProtectorUtils.getJSONObject(r24, "11K");     // Catch: Throwable -> L27
        r10.a = o(JSONObjectProtectorUtils.getString(r1, "able"), false);     // Catch: Throwable -> L27
        if (r1.has("off") == false) goto L30;
        r10.b = JSONObjectProtectorUtils.getJSONObject(r1, "off");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 11K");
    L30:
        if (f5.h(r24, "145") == false) goto L36;
        JSONObjectProtectorUtils.getJSONObject(r24, "145");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 145");
    L36:
        if (f5.h(r24, "14D") == false) goto L42;
        JSONObjectProtectorUtils.getJSONObject(r24, "14D");     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 14D");
    L42:
        if (f5.h(r24, "151") == false) goto L50;
        JSONObject r2 = JSONObjectProtectorUtils.getJSONObject(r24, "151");     // Catch: Throwable -> L47
        if (r2 == null) goto L50;
        o(r2.optString("able"), false);     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 151");
    L50:
        if (f5.h(r24, "17S") == true) goto L171;
    L96:
        String r17 = "ustv";
        String r18 = "ust";
        String r19 = "umv";
    L98:
        if (f5.h(r24, "15K") == true) goto L149;
    L119:
        Context r3 = r20;
    L121:
        if (f5.h(r24, "183") == false) goto L127;
        k0.f(r21, JSONObjectProtectorUtils.getJSONObject(r24, "183"));     // Catch: Throwable -> L124
    L124:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 183");
    L127:
        if (f5.h(r24, "17I") == false) goto L133;
        JSONObject r4 = JSONObjectProtectorUtils.getJSONObject(r24, "17I");     // Catch: Throwable -> L130
        boolean r5 = o(r4.optString("na"), false);     // Catch: Throwable -> L130
        boolean r6 = o(r4.optString("aa"), false);     // Catch: Throwable -> L130
        n4a.c.b = r5;     // Catch: Throwable -> L130
        n4a.c.c = r6;     // Catch: Throwable -> L130
        SharedPreferences.Editor r7 = y.b(r3, "open_common");     // Catch: Throwable -> L130
        y.h(r7, "a4", r5);     // Catch: Throwable -> L130
        y.h(r7, "a5", r6);     // Catch: Throwable -> L130
        y.e(r7);     // Catch: Throwable -> L130
    L130:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 17I");
    L133:
        if (f5.h(r24, "1A4") == false) goto L184;
        JSONObject r8 = JSONObjectProtectorUtils.getJSONObject(r24, "1A4");     // Catch: Throwable -> L146
        String r9 = r8.optString("ada");     // Catch: Throwable -> L146
        o(r9, true);     // Catch: Throwable -> L146
        long r11 = r8.optLong("iv", 86400000);     // Catch: Throwable -> L146
        SharedPreferences.Editor r16 = y.b(r3, "open_common");     // Catch: Throwable -> L146
        y.g(r16, "a16", r9);     // Catch: Throwable -> L146
        if (r16 != null) goto L137;
    L144:
        y.e(r16);     // Catch: Throwable -> L146
        return;
    L137:
        if (TextUtils.isEmpty("a17") == true) goto L144;
        r16.putLong("a17", r11);     // Catch: Throwable -> L141
    L141:
        th = move-exception;
        r.f(th, "csp", "plv");     // Catch: Throwable -> L146
    L146:
        th = move-exception;
        n.a(th, "AuthConfigManager", "load 1A4");
        return;
    L184:
        return;
    L149:
        JSONObject r25 = JSONObjectProtectorUtils.getJSONObject(r24, "15K");     // Catch: Throwable -> L117
        if (r25 == null) goto L119;
        boolean r26 = o(r25.optString("ucf"), g.a);     // Catch: Throwable -> L117
        boolean r27 = o(r25.optString("fsv2"), g.b);     // Catch: Throwable -> L117
        boolean r28 = o(r25.optString("usc"), g.c);     // Catch: Throwable -> L117
        String r29 = r19;
        int r30 = r25.optInt(r29, g.d);     // Catch: Throwable -> L117
        String r110 = r18;
        boolean r111 = o(r25.optString(r110), g.e);     // Catch: Throwable -> L117
        String r112 = r17;
        int r31 = r25.optInt(r112, g.f);     // Catch: Throwable -> L117
        if (r26 == g.a) goto L104;
    L112:
        g.a = r26;     // Catch: Throwable -> L117
        g.b = r27;     // Catch: Throwable -> L117
        g.c = r28;     // Catch: Throwable -> L117
        g.d = r30;     // Catch: Throwable -> L117
        g.e = r111;     // Catch: Throwable -> L117
        g.f = r31;     // Catch: Throwable -> L117
        r3 = r20;
        SharedPreferences.Editor r32 = y.b(r3, "open_common");     // Catch: Throwable -> L116
        y.h(r32, "ucf", g.a);     // Catch: Throwable -> L116
        y.h(r32, "fsv2", g.b);     // Catch: Throwable -> L116
        y.h(r32, "usc", g.c);     // Catch: Throwable -> L116
        y.f(r32, r29, g.d);     // Catch: Throwable -> L116
        y.h(r32, r110, g.e);     // Catch: Throwable -> L116
        y.f(r32, r112, g.f);     // Catch: Throwable -> L116
        y.e(r32);     // Catch: Throwable -> L116
        goto L121
    L104:
        if (r27 != g.b) goto L112;
        if (r28 != g.c) goto L112;
        int r113 = g.d;     // Catch: Throwable -> L117
        if (r30 != r113) goto L112;
        if (r111 != g.e) goto L112;
        if (r31 == r113) goto L119;
    L117:
        th = move-exception;
        r3 = r20;
        n.a(th, "AuthConfigManager", "load 15K");
        goto L121
    L171:
        JSONObject r33 = JSONObjectProtectorUtils.getJSONObject(r24, "17S");     // Catch: Throwable -> L92
        if (r33 == null) goto L58;
        boolean r34 = o(r33.optString("able"), false);     // Catch: Throwable -> L92
        if (r34 == d) goto L58;
        d = r34;     // Catch: Throwable -> L92
        if (r20 == null) goto L58;
        SharedPreferences.Editor r114 = y.b(r20, "open_common");     // Catch: Throwable -> L92
        y.h(r114, "a2", r34);     // Catch: Throwable -> L92
        y.e(r114);     // Catch: Throwable -> L92
    L58:
        if (r33 == null) goto L96;
        boolean r35 = o(r33.optString("static_enable"), true);     // Catch: Throwable -> L92
        boolean r115 = o(r33.optString("static_ip_direct_enable"), false);     // Catch: Throwable -> L92
        int r116 = r33.optInt("static_timeout", 5) * 1000;     // Catch: Throwable -> L92
        int r117 = r33.optInt("static_retry", 3);     // Catch: Throwable -> L92
        r17 = "ustv";
        boolean r118 = o(r33.optString("bgp_enable"), true);     // Catch: Throwable -> L90
        r18 = "ust";
        boolean r36 = o(r33.optString("bgp_ip_direct_enable"), false);     // Catch: Throwable -> L88
        r19 = "umv";
        int r37 = r33.optInt("bgp_retry", 3);     // Catch: Throwable -> L86
        boolean r38 = o(r33.optString("perf_data_upload_enable"), false);     // Catch: Throwable -> L86
        if (r35 == p) goto L68;
    L81:
        p = r35;     // Catch: Throwable -> L86
        q = r115;     // Catch: Throwable -> L86
        o = r116;     // Catch: Throwable -> L86
        r = r117;     // Catch: Throwable -> L86
        s = r118;     // Catch: Throwable -> L86
        t = r36;     // Catch: Throwable -> L86
        u = r37;     // Catch: Throwable -> L86
        v = r38;     // Catch: Throwable -> L86
        if (r20 == null) goto L84;
        SharedPreferences.Editor r39 = y.b(r20, "open_common");     // Catch: Throwable -> L86
        y.h(r39, "a13", r35);     // Catch: Throwable -> L86
        y.h(r39, "a6", r118);     // Catch: Throwable -> L86
        y.h(r39, "a7", r115);     // Catch: Throwable -> L86
        y.f(r39, "a8", r116);     // Catch: Throwable -> L86
        y.f(r39, "a9", r117);     // Catch: Throwable -> L86
        y.h(r39, "a10", r36);     // Catch: Throwable -> L86
        y.f(r39, "a11", r37);     // Catch: Throwable -> L86
        y.h(r39, "a12", r38);     // Catch: Throwable -> L86
        y.e(r39);     // Catch: Throwable -> L86
    L84:
        goto L98
    L68:
        if (r115 != q) goto L81;
        if (r116 != o) goto L81;
        if (r117 != r) goto L81;
        if (r118 != s) goto L81;
        if (r36 != t) goto L81;
        if (r37 != u) goto L81;
        if (r38 == v) goto L84;
    L86:
        th = th;
    L95:
        n.a(th, "AuthConfigManager", "load 17S");
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
        n.a(th, "at", "co");
        goto L16
    }

    public static synchronized void h(String r4, boolean r5, String r6, String r7, String r8) {
        monitor-enter(i.class);
    L29:
        th = move-exception;
        n.a(th, "at", "lca");     // Catch: Throwable -> L33
        return;
    L33:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L9;
        monitor-exit(i.class);
        return;
    L9:
        if (k != null) goto L11;
        k = new ConcurrentHashMap(8);     // Catch: Throwable -> L29
    L11:
        k.put(r4, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L29
        if (l != null) goto L16;
        monitor-exit(i.class);
        return;
    L16:
        if (l.containsKey(r4) == true) goto L20;
        monitor-exit(i.class);
        return;
    L20:
        if (TextUtils.isEmpty(r4) == false) goto L23;
        monitor-exit(i.class);
        return;
    L23:
        if (r5 == true) goto L25;
    L26:
        k1.d.b(new a(r4, r6, r7, r8));     // Catch: Throwable -> L29
        monitor-exit(i.class);
        return;
    L25:
        k0.g(true, r4);     // Catch: Throwable -> L29
        goto L26
    }
}
