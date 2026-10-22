package d7;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.obric.cae.userAware.SubwayFusionAware.SubwayUtils;
import com.obric.cae.userAware.datacollection.NetworkClient;
import com.sdk.bwdl.Utils.BWDLInnerConstant;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import we.a0;
import we.c0;
import we.v;
import we.x;
import we.y;
import we.z;

/* JADX INFO: loaded from: classes.dex */
public final class p implements w6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile p f6904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f6905b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f6906c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f6907d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f6908e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile String f6909f = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile int f6910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile String f6911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile String[] f6912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile String[] f6913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Context f6914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static h f6915l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static e f6916m;

    public class a implements e7.g {
    }

    public static class b implements SsCall, IRequestInfo {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static boolean f6917v = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f6918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w6.a f6919b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final long f6920m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f6921n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Request f6922o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public y f6923p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public a0 f6924q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public x f6925r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final RetrofitMetrics f6926s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public volatile l f6927t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f6928u;

        public b(Request r19) {
            this.f6918a = null;
            w6.a r8 = w6.a.E.a();
            this.f6919b = r8;
            this.f6920m = 0;
            this.f6921n = null;
            this.f6926s = null;
            this.f6927t = null;
            this.f6928u = false;
            h r10 = p.f6915l;
            r10.getClass();
            monitor-enter(w6.e.class);
            v r11 = r10.f6862a;     // Catch: Throwable -> L74
            if (r11 == null) goto L13;
            int r12 = h.f6861b;     // Catch: Throwable -> L74
            if (r12 <= 0) goto L10;
            if (r12 >= 4) goto L10;
            v.b r13 = new v.b(r11);     // Catch: Throwable -> L74
            h.a(r13);     // Catch: Throwable -> L74
            new v(r13);     // Catch: Throwable -> L74
        L10:
            v r14 = r10.f6862a;     // Catch: Throwable -> L74
            monitor-exit(w6.e.class);     // Catch: Throwable -> L74
        L22:
            this.f6918a = r14;
            Object r15 = r19.getExtraInfo();
            w6.e.a r16 = w6.e.f13022c;
            if (r16 == null) goto L25;
            r16.onTryInit();
        L25:
            if (r15 != null) goto L27;
        L29:
            w6.e.f();
            this.f6922o = r19;
            String r17 = r19.getUrl();
            RetrofitMetrics r18 = r19.getMetrics();
            this.f6926s = r18;
            if (r18 == null) goto L32;
            r8.f12992c = r18.appLevelRequestStart;
            r8.f12993d = r18.beforeAllInterceptors;
        L32:
            this.f6927t = new l();
            this.f6927t.N = r17;
            long r20 = System.currentTimeMillis();
            this.f6920m = r20;
            r8.f12994e = r20;
            r8.f13009t = 1;
            if (r19.isResponseStreaming() == false) goto L35;
            r8.f13014y = true;
        L81:
            r14.getClass();     // Catch: Exception -> L67
            v.b r21 = new v.b(r14);     // Catch: Exception -> L67
            long r22 = BWDLInnerConstant.DATA_LINK_TOUT;
            TimeUnit r110 = TimeUnit.MILLISECONDS;     // Catch: Exception -> L67
            r21.f13315w = xe.c.d(r22, r110);     // Catch: Exception -> L67
            r21.f13316x = xe.c.d(r22, r110);     // Catch: Exception -> L67
            r21.f13317y = xe.c.d(r22, r110);     // Catch: Exception -> L67
            if ((r19.getExtraInfo() instanceof w6.b) == false) goto L41;
            T r23 = (T) r19.getExtraInfo();     // Catch: Exception -> L67
            r8.f12991b = r23;     // Catch: Exception -> L67
            r23.getClass();     // Catch: Exception -> L67
            if (r23.f13016a == true) goto L41;
            r21.f13312t = false;     // Catch: Exception -> L67
        L41:
            we.o.c r24 = r14.f13283q;     // Catch: Exception -> L67
            if (r24 == null) goto L44;
            we.o r25 = ((we.o.b) r24).f13233a;     // Catch: Exception -> L67
        L45:
            r21.f13299g = we.o.factory(new k(r25, this.f6927t));     // Catch: Exception -> L67
            v r26 = new v(r21);     // Catch: Exception -> L67
            this.f6918a = r26;     // Catch: Exception -> L67
            r17 = l7.a.c(p.f6914k, b(r17, r19.getMethod()), r19.getHeaders());     // Catch: Exception -> L67
            URI r27 = t2.b.T(r17);     // Catch: Exception -> L67
            if (r27 != null) goto L48;
        L50:
            y.a r28 = new y.a();     // Catch: Exception -> L67
            r28.e(r17);     // Catch: Exception -> L67
            if (defpackage.c.b0(r19.getMethod()) == true) goto L53;
            r28.c(null, r19.getMethod());     // Catch: Exception -> L67
        L60:
            List<Header> r29 = r19.getHeaders();     // Catch: Exception -> L67
            if (r19.getBody() == null) goto L65;
            String r30 = r19.getBody().md5Stub();     // Catch: Exception -> L67
            if (r30 == null) goto L65;
            r28.f13347d.a("X-SS-STUB", r30);     // Catch: Exception -> L67
        L65:
            y r31 = p.c(r28, r29);     // Catch: Exception -> L67
            this.f6923p = r31;     // Catch: Exception -> L67
            this.f6925r = x.f(r26, r31, false);     // Catch: Exception -> L67
            r8.f13013x = p.e(this.f6923p, r8);     // Catch: Exception -> L67
            return;
        L53:
            String r32 = r19.getMethod();     // Catch: Exception -> L67
            TypedOutput r33 = r19.getBody();     // Catch: Exception -> L67
            z r111 = r19.getRequestBody();     // Catch: Exception -> L67
            if (r111 != null) goto L59;
            if (r33 != null) goto L58;
            r111 = z.create(null, "body=null");     // Catch: Exception -> L67
            goto L59
        L58:
            r111 = new q(we.t.b(r33.mimeType()), r33);     // Catch: Exception -> L67
        L59:
            r28.c(r111, r32);     // Catch: Exception -> L67
            goto L60
        L48:
            if (TextUtils.isEmpty(r27.getHost()) == true) goto L50;
            this.f6927t.U = r27.getHost();     // Catch: Exception -> L67
            j.b().a(r27.getHost(), this.f6927t);     // Catch: Exception -> L67
            goto L50
        L44:
            r25 = null;
        L67:
            e = move-exception;
            p.d(this.f6923p, r17, this.f6920m, this.f6919b, this.f6921n, e, this.f6925r, this.f6924q, this.f6926s, this.f6927t);
            if ((e instanceof IOException) == false) goto L73;
            throw ((IOException) e);
        L73:
            throw new IOException(e.getMessage(), e.getCause());
        L35:
            r8.f13014y = false;
            goto L81
        L27:
            if ((r15 instanceof w6.b) == false) goto L29;
            w6.b r34 = (w6.b) r15;
            goto L29
        L13:
            v.b r35 = new v.b();     // Catch: Throwable -> L74
            int r36 = h.f6861b;     // Catch: Throwable -> L74
            if (r36 <= 0) goto L17;
            if (r36 >= 4) goto L17;
            h.a(r35);     // Catch: Throwable -> L74
        L17:
            TimeUnit r37 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L74
            r35.f13309q = new we.i(15, 180000, r37);     // Catch: Throwable -> L74
            r35.f13315w = xe.c.d(SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME, r37);     // Catch: Throwable -> L74
            r35.f13316x = xe.c.d(SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME, r37);     // Catch: Throwable -> L74
            r35.f13317y = xe.c.d(SubwayUtils.OUTDOOR_PUNISH_DELAY_TIME, r37);     // Catch: Throwable -> L74
            r35.f13298f.add(new g());     // Catch: Throwable -> L74
            j r38 = j.b();     // Catch: Throwable -> L74
            if (r38 == null) goto L77;
            r35.f13310r = r38;     // Catch: Throwable -> L74
            r35.f13301i = we.l.f13225a;     // Catch: Throwable -> L74
            r35.f13297e.add(new i());     // Catch: Throwable -> L74
            r35.f13297e.add(new m());     // Catch: Throwable -> L74
            r35.f13312t = true;     // Catch: Throwable -> L74
            v r39 = new v(r35);     // Catch: Throwable -> L74
            r10.f6862a = r39;     // Catch: Throwable -> L74
            monitor-exit(w6.e.class);     // Catch: Throwable -> L74
            r14 = r39;
            goto L22
        L77:
            throw new NullPointerException("dns == null");     // Catch: Throwable -> L74
        L74:
            th = move-exception;
            throw th;
        }

        public static ArrayList a(we.q r8) {
            int r10 = r8.f13238a.length / 2;
            ArrayList r11 = new ArrayList(r10);
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L13;
            String r13 = r8.e(r12);
            if (r13 != null) goto L7;
        L11:
            r11.add(new Header(r8.e(r12), r8.j(r12)));
        L12:
            r12 = r12 + 1;
            goto L3
        L7:
            if (r13.equalsIgnoreCase("bdturing-verify") == false) goto L11;
            if (f6917v == false) goto L11;
        L13:
            return r11;
        }

        public static void c(l r8, String r10, String r11, long r12) {
            n r13 = new n();
            r13.f6894a = 307;
            r13.f6897d = true;
            r13.f6895b = r10;
            r13.f6896c = r11;
            r8.I.add(r13);
            r8.H++;
            r8.f6884q = r12;
            r8.O = true;
        }

        public final String b(String r8, String r10) {
            if (g7.j.e().f() == true) goto L18;
            long r11 = System.currentTimeMillis();
            g7.k r12 = new g7.k(r8, r10);
            n4.b r13 = g7.j.e().b(r12);
            long r14 = System.currentTimeMillis();
            if (r13 == null) goto L24;
            c(this.f6927t, this.f6922o.getMethod(), (String) r13.f9430a, r14 - r11);
            l r15 = this.f6927t;
            r15.Q = (List) r13.f9432c;
            this.f6927t.P = false;
            if (r8.equals((String) r13.f9430a) == false) goto L9;
            return r8;
        L9:
            if (((String) r13.f9430a).isEmpty() == false) goto L16;
            if (((List) r13.f9431b).isEmpty() == true) goto L16;
            throw new Exception("ERR_TTNET_TRAFFIC_CONTROL_DROP, -555");
        L16:
            if (l7.g.a((String) r13.f9430a) == true) goto L27;
            return r8;
        L27:
            return (String) r13.f9430a;
        L24:
            return r8;
        L18:
            Logger.d("SsOkHttp3Client", "fallback to host replace map");
            long r16 = System.currentTimeMillis();
            String r17 = g7.j.e().d(r8);
            long r18 = System.currentTimeMillis();
            if (r8.equals(r17) == false) goto L21;
            return r8;
        L21:
            if (l7.g.a(r17) == false) goto L29;
            c(this.f6927t, this.f6922o.getMethod(), r17, r18 - r16);
            this.f6927t.P = true;
            l r19 = this.f6927t;
            r19.R = g7.j.e().c().size();
            return r17;
        L29:
            return r8;
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final void cancel() {
            x r8 = this.f6925r;
            if (r8 == null) goto L15;
            r8.b(-1);
            Request r10 = this.f6922o;
            if (r10.isResponseStreaming() == true) goto L7;
        L13:
            this.f6928u = true;
            return;
        L7:
            if (this.f6928u == true) goto L13;
            long r11 = System.currentTimeMillis();
            w6.a r12 = this.f6919b;
            r12.f12997h = r11;
            T r13 = r12.f12991b;
            if (r13 != 0) goto L11;
        L12:
            long r14 = this.f6920m;
            w6.e.d(r11 - r14, r14, r10.getUrl(), this.f6921n, this.f6919b);
            goto L13
        L11:
            if (r13.f13017b == false) goto L13;
        }

        public final void d() {
            TreeMap r8 = this.f6924q.f13119p.i();
            if (r8.containsKey("bdturing-verify") == true) goto L5;
            return;
        L5:
            long r10 = SystemClock.uptimeMillis();
            int r11 = this.f6924q.f13116m;
            w6.e.d r12 = w6.e.f13020a;
            if (r11 != 200) goto L8;
            Looper.getMainLooper();
            Looper.myLooper();
        L8:
            long r13 = SystemClock.uptimeMillis() - r10;
            w6.a r14 = this.f6919b;
            r14.A = r13;
            if (r8.containsKey("bdturing-verify") == true) goto L11;
            r14.f13015z = true;
            f6917v = true;
        L11:
            r14.f13013x = p.e(this.f6923p, r14);
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final Response execute() {
            String r8 = this.f6922o.getUrl();
            p r10 = p.f6904a;
            x r11 = this.f6925r;
            if (r11 != null) goto L5;
        L9:
            Context r12 = p.f6914k;
            if (r12 != null) goto L12;
        L16:
            boolean r13 = true;
            boolean r14 = false;
        L77:
            e = move-exception;
            Exception r15 = e;
            boolean r16 = false;
        L111:
            e r17 = p.f6916m;     // Catch: Throwable -> L100
            if (r17 == null) goto L83;
            ((d9.d) r17).f(this.f6923p, r15);     // Catch: Throwable -> L100
        L83:
            if ((r15 instanceof b7.b) == false) goto L89;
            b7.b r18 = (b7.b) r15;     // Catch: Throwable -> L100
            if (r18.f3131a != 304) goto L89;
            throw r18;     // Catch: Throwable -> L100
        L89:
            if ((r15 instanceof IOException) == true) goto L91;
        L94:
            p.d(this.f6923p, r8, this.f6920m, this.f6919b, this.f6921n, r15, this.f6925r, this.f6924q, this.f6926s, this.f6927t);     // Catch: Throwable -> L100
            if ((r15 instanceof IOException) == false) goto L99;
            throw ((IOException) r15);     // Catch: Throwable -> L100
        L99:
            throw new IOException(r15.getMessage(), r15.getCause());     // Catch: Throwable -> L100
        L91:
            if ("Canceled".equals(r15.getMessage()) == false) goto L94;
            throw r15;     // Catch: Throwable -> L100
        L100:
            th = th;
            r14 = r16;
        L103:
            if (this.f6922o.isResponseStreaming() == false) goto L105;
            if (r13 == true) goto L105;
        L107:
            if (this.f6922o.isResponseStreaming() == true) goto L110;
            if (r14 == false) goto L110;
            u6.c.a.f12494a.c();
        L110:
            throw th;
        L105:
            p r19 = p.f6904a;
        L75:
            th = th;
            r13 = false;
            goto L103
        L18:
            if (this.f6922o.isResponseStreaming() == true) goto L25;
            w6.e.d r20 = w6.e.f13020a;     // Catch: Throwable -> L75 Exception -> L77
            if (r20 == null) goto L25;
            if (((x8.c) r20).p(r8) == false) goto L25;
            u6.c.a.f12494a.b();     // Catch: Throwable -> L75 Exception -> L77
            boolean r110 = true;
        L112:
            w6.a r21 = this.f6919b;     // Catch: Throwable -> L71 Exception -> L73
            p.a(this.f6925r.f13331o.f13340d);     // Catch: Throwable -> L71 Exception -> L73
            r21.getClass();     // Catch: Throwable -> L71 Exception -> L73
            v r22 = this.f6918a;     // Catch: Throwable -> L71 Exception -> L73
            x r23 = this.f6925r;     // Catch: Throwable -> L71 Exception -> L73
            r r24 = null;
            if (r22 == null) goto L31;
            if (r23 == null) goto L31;
            a0 r25 = r23.d();     // Catch: Throwable -> L71 Exception -> L73
        L32:
            this.f6924q = r25;     // Catch: Throwable -> L71 Exception -> L73
            d();     // Catch: Throwable -> L71 Exception -> L73
            l r26 = this.f6927t;     // Catch: Throwable -> L71 Exception -> L73
            if (this.f6924q.f13122s == null) goto L35;
            boolean r27 = true;
        L36:
            r26.B = r27;     // Catch: Throwable -> L71 Exception -> L73
            l r28 = this.f6927t;     // Catch: Throwable -> L71 Exception -> L73
            if (this.f6924q.f13121r == null) goto L39;
            boolean r29 = true;
        L40:
            r28.C = r29;     // Catch: Throwable -> L71 Exception -> L73
            this.f6919b.f12995f = System.currentTimeMillis();     // Catch: Throwable -> L71 Exception -> L73
            w6.a r30 = this.f6919b;     // Catch: Throwable -> L71 Exception -> L73
            p.a(this.f6924q.f13119p);     // Catch: Throwable -> L71 Exception -> L73
            r30.getClass();     // Catch: Throwable -> L71 Exception -> L73
            a0 r31 = this.f6924q;     // Catch: Throwable -> L71 Exception -> L73
            w6.a r32 = this.f6919b;     // Catch: Throwable -> L71 Exception -> L73
            if (r31 != null) goto L43;
            String r33 = null;
        L44:
            this.f6921n = r33;     // Catch: Throwable -> L71 Exception -> L73
            e r34 = p.f6916m;     // Catch: Throwable -> L71 Exception -> L73
            if (r34 == null) goto L47;
            ((d9.d) r34).e(this.f6923p, this.f6924q);     // Catch: Throwable -> L71 Exception -> L73
        L47:
            a0 r35 = this.f6924q;     // Catch: Throwable -> L71 Exception -> L73
            int r111 = r35.f13116m;     // Catch: Throwable -> L71 Exception -> L73
            String r112 = r35.n("Content-Type");     // Catch: Throwable -> L71 Exception -> L73
            if (this.f6922o.isResponseStreaming() == false) goto L64;
            boolean r36 = "gzip".equalsIgnoreCase(this.f6924q.n("Content-Encoding"));     // Catch: Throwable -> L71 Exception -> L73
            TreeMap r37 = this.f6924q.f13119p.i();     // Catch: Throwable -> L71 Exception -> L73
            if (r111 >= 200) goto L52;
        L59:
            String r38 = this.f6924q.f13117n;     // Catch: Throwable -> L71 Exception -> L73
            int r39 = this.f6922o.getMaxLength();     // Catch: Throwable -> L71 Exception -> L73
            c0 r40 = this.f6924q.f13120q;     // Catch: Throwable -> L71 Exception -> L73
            if (r40 == null) goto L63;
            p.i(r36, r39, r40.k().p0(), r112, r8, this.f6926s);     // Catch: Throwable -> L71 Exception -> L73
            h7.c.c(r40);     // Catch: Throwable -> L71 Exception -> L73
        L63:
            throw new b7.b(r111, r38);     // Catch: Throwable -> L71 Exception -> L73
        L52:
            if (r111 >= 300) goto L59;
            c0 r41 = this.f6924q.f13120q;     // Catch: Throwable -> L71 Exception -> L73
            if (r41.a() == 0) goto L58;
            r24 = new r(this, r41, r37, r36);     // Catch: Throwable -> L71 Exception -> L73
        L58:
            TypedInput r42 = r24;
        L65:
            a0 r43 = this.f6924q;     // Catch: Throwable -> L71 Exception -> L73
            Response r44 = new Response(r8, r111, r43.f13117n, a(r43.f13119p), r42);     // Catch: Throwable -> L71 Exception -> L73
            r44.setExtraInfo(this.f6919b);     // Catch: Throwable -> L71 Exception -> L73
            this.f6922o.isResponseStreaming();
            if (this.f6922o.isResponseStreaming() == true) goto L70;
            if (r110 == false) goto L70;
            u6.c.a.f12494a.c();
        L70:
            return r44;
        L64:
            r42 = new TypedByteArray(r112, p.b(r8, this.f6922o.getMaxLength(), this.f6924q, this.f6920m, this.f6919b, this.f6921n, this.f6926s, this.f6927t), new String[0]);     // Catch: Throwable -> L71 Exception -> L73
            goto L65
        L43:
            p.g(r31.n("x-net-info.remoteaddr"), r32);     // Catch: Throwable -> L71 Exception -> L73
            r33 = r31.n("X-TT-LOGID");     // Catch: Throwable -> L71 Exception -> L73
            goto L44
        L39:
            r29 = false;
            goto L40
        L35:
            r27 = false;
        L31:
            r25 = null;
        L73:
            e = move-exception;
            r15 = e;
            r16 = r110;
        L71:
            th = th;
            r13 = false;
            r14 = r110;
            goto L103
        L25:
            r110 = false;
            goto L112
        L12:
            if (r5.e.e(r12) == true) goto L16;
            throw new b7.c();
        L5:
            if (r11.f13328b.f378d == false) goto L9;
            throw new IOException("request canceled");
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final Request getRequest() {
            return this.f6922o;
        }

        @Override // com.bytedance.retrofit2.IRequestInfo
        public final Object getRequestInfo() {
            return this.f6919b;
        }

        @Override // com.bytedance.retrofit2.client.SsCall
        public final boolean setThrottleNetSpeed(long r8) {
            return false;
        }
    }

    static {
        f6907d = new Object();
    }

    public p(Context r12) {
        f6914k = r12.getApplicationContext();
        f6915l = new h();
        g7.j r11 = g7.j.e();
        Context r13 = f6914k;
        r11.getClass();
        if (l7.e.c(r13) == false) goto L14;
        AtomicBoolean r14 = g7.j.f7741n;
        if (r14.get() == true) goto L14;
        SharedPreferences r15 = r13.getSharedPreferences("ttnet_tnc_config", 0);
        String r8 = r15.getString("tnc_config_str", null);
        String r10 = r15.getString("ttnet_tnc_etag", null);
        String r16 = r15.getString("ttnet_tnc_abtest", null);
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        r14.set(true);
        goto L14
    L8:
        if (TextUtils.isEmpty(r8) == true) goto L13;
        JSONObject r17 = new JSONObject(r8);     // Catch: JSONException -> L11
        g7.j.e().g(r17, 0, r10, r16, System.currentTimeMillis());     // Catch: JSONException -> L11
    L14:
        e7.e r18 = e7.e.g();
        a r19 = new a();
        if (r18.f7183z == false) goto L18;
        Logger.d("e", "you have set httpdns depend before.");
        return;
    L18:
        if (f6914k != null) goto L20;
    L47:
        r18.f7182y = null;
        throw new IllegalArgumentException("you must set correct httpdns depend");
    L20:
        if (TextUtils.isEmpty(f6911h) == true) goto L47;
        if (String.valueOf(f6910g) == null) goto L47;
        r18.f7182y = r19;
        if (TextUtils.isEmpty(r18.f7170m) == false) goto L26;
        r18.f7170m = f6911h;
    L26:
        r18.f7183z = true;
        e7.e.o();
        f r110 = r18.f7181x;
        Context r20 = f6914k;
        r110.getClass();
        if (r20 == null) goto L29;
        IntentFilter r21 = new IntentFilter();
        r21.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r20.registerReceiver(r110.f6860b, r21);
        Logger.d("f", "register network state changed completed");
    L29:
        Logger.d("f", "register activity forground and background switch Callback");
        if ((r20 instanceof Application) == false) goto L35;
        Application r22 = (Application) r20;
        if (r22 == null) goto L35;
        f7.d r23 = r110.f6859a;
        r23.f7344a = r110;
        r22.registerActivityLifecycleCallbacks(r23);
    L35:
        if (r18.f7173p.size() >= 1) goto L44;
        ((a) r18.f7182y).getClass();
        if (f6912i == null) goto L43;
        ((a) r18.f7182y).getClass();
        if (f6912i.length <= 0) goto L43;
        ((a) r18.f7182y).getClass();
        if (f6912i.length > 10) goto L43;
        ConcurrentSkipListSet<String> r111 = r18.f7173p;
        ((a) r18.f7182y).getClass();
        r111.addAll(Arrays.asList(f6912i));
    L43:
        Logger.d("e", "httpdns preload domains's number must less than 10, httpdns preload is skipped.");
    L45:
        Message r112 = Message.obtain();
        r112.what = 5;
        r112.obj = r18;
        e7.e.F.sendMessage(r112);
        return;
    L44:
        r18.c(e7.a.EnumC0065a.f7143n);
        goto L45
    }

    public static void a(we.q r8) {
        JSONObject r10 = new JSONObject();     // Catch: Exception -> L17
        Iterator r11 = r8.i().entrySet().iterator();     // Catch: Exception -> L17
    L4:
        if (r11.hasNext() == false) goto L15;
        Map.Entry r12 = (Map.Entry) r11.next();     // Catch: Exception -> L17
        String r13 = (String) r12.getKey();     // Catch: Exception -> L17
        List r14 = (List) r12.getValue();     // Catch: Exception -> L17
        if (TextUtils.isEmpty(r13) == true) goto L4;
        if (r14 == null) goto L4;
        if (r14.size() <= 0) goto L4;
        Iterator r15 = r14.iterator();     // Catch: Exception -> L17
    L13:
        if (r15.hasNext() == false) goto L4;
        r10.put(r13, (String) r15.next());     // Catch: Exception -> L17
        goto L13
    L15:
        r10.toString();     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public static byte[] b(String r13, int r14, a0 r15, long r16, w6.a r18, String r19, RetrofitMetrics r20, l r21) {
        if (r15 == null) goto L36;
        int r10 = r15.f13116m;
        c0 r11 = r15.f13120q;
        r15.f13119p.i();
        boolean r12 = "gzip".equals(r15.n("Content-Encoding"));
        String r17 = r15.n("Content-Type");
        r18.f13010u = f6905b;
        r18.f13011v = f6906c;
        if (r10 != 200) goto L8;
        if (r11 == null) goto L36;
        r18.f12996g = System.currentTimeMillis();
        InputStream r8 = r11.k().p0();
        int[] r22 = {0};
        byte[] r23 = h7.c.b(r12, r14, r8, r22, r20);     // Catch: Throwable -> L32
        h7.c.c(r8);
        int r24 = r22[0];
        byte[] r25 = new byte[r24];
        if (r23 == null) goto L23;
        if (r24 <= 0) goto L23;
        System.arraycopy(r23, 0, r25, 0, r24);
    L23:
        if (h7.c.d(r17) == false) goto L25;
        h7.c.a(r24, r25);
    L25:
        long r26 = System.currentTimeMillis() - r16;
        r18.f12997h = System.currentTimeMillis();
        h(r18, r20, r21);
        k7.b.e().h(r15, r13, r25);     // Catch: Throwable -> L37
    L31:
        w6.e.d(r26, r16, r13, r19, r18);
        return r25;
    L32:
        th = move-exception;
        h7.c.c(r8);
        throw th;
    L8:
        if (r10 != 304) goto L10;
        r18.f12996g = System.currentTimeMillis();
        long r27 = System.currentTimeMillis() - r16;
        r18.f12997h = System.currentTimeMillis();
        h(r18, r20, r21);
        w6.e.d(r27, r16, r13, r19, r18);
    L10:
        String r28 = r15.f13117n;
        if (r11 == null) goto L14;
        i(r12, r14, r11.k().p0(), r17, r13, r20);
        h7.c.c(r11);
    L14:
        throw new b7.b(r10, r28);
    L36:
        return new byte[0];
    }

    public static y c(y.a r8, List r10) {
        r8.f13347d.a("Accept-Encoding", "gzip");
        boolean r11 = true;
        if (r10 == null) goto L16;
        Iterator r12 = r10.iterator();
        boolean r13 = false;
    L6:
        if (r12.hasNext() == false) goto L17;
        Header r14 = (Header) r12.next();
        if (r5.f.b(r14.getName()) == true) goto L6;
        if (r5.f.b(r14.getValue()) == true) goto L6;
        if ("User-Agent".equals(r14.getName()) == false) goto L15;
        r13 = true;
    L15:
        r8.b(r14.getName(), r14.getValue());
    L17:
        if (r13 == true) goto L21;
        String r15 = w6.e.f13021b;
        if (r5.f.b(r15) == true) goto L21;
        r8.b("User-Agent", r15 + " tt-ok/3.10.0.2");
    L22:
        if (r11 == true) goto L47;
        if (TextUtils.isEmpty(f6909f) == false) goto L43;
        StringBuilder r16 = new StringBuilder();
        r16.append(f6914k.getPackageName());
        r16.append('/');
        Context r17 = f6914k;
        Object r18 = f6907d;
        monitor-enter(r18);
    L40:
        th = move-exception;
        throw th;
    L28:
        if (f6908e == 0) goto L51;
    L31:
        int r19 = f6908e;     // Catch: Throwable -> L40
        monitor-exit(r18);     // Catch: Throwable -> L40
        r16.append(r19);
        r16.append(" (Linux; U; Android ");
        r16.append(Build.VERSION.RELEASE);
        r16.append("; ");
        r16.append(Locale.getDefault().toString());
        String r20 = Build.MODEL;
        if (r20.length() <= 0) goto L36;
        r16.append("; ");
        r16.append(r20);
    L36:
        String r21 = Build.ID;
        if (r21.length() <= 0) goto L39;
        r16.append("; Build/");
        r16.append(r21);
    L39:
        r16.append(";tt-ok/3.10.0.2)");
        f6909f = r16.toString();
        goto L43
    L51:
        f6908e = r17.getPackageManager().getPackageInfo(r17.getPackageName(), 0).versionCode;     // Catch: PackageManager.NameNotFoundException -> L48 Throwable -> L40
    L43:
        String r22 = f6909f;
        if (TextUtils.isEmpty(r22) == true) goto L47;
        r8.b("User-Agent", r22);
    L47:
        return r8.a();
    L21:
        r11 = r13;
        goto L22
    L16:
        r13 = false;
        goto L17
    }

    public static void d(y r10, String r11, long r12, w6.a r13, String r14, Exception r15, we.d r16, a0 r17, RetrofitMetrics r18, l r19) {
        if (r11 == null) goto L39;
        if (r13 != null) goto L37;
    L8:
        r13.f13013x.put("ex", r15.getMessage());     // Catch: Throwable -> L12
        String r8 = f(r17);     // Catch: Throwable -> L12
        if (r5.f.b(r8) == true) goto L14;
        r13.f13013x.put("response-headers", r8);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
    L14:
        if (r13 != null) goto L16;
    L31:
        long r20 = System.currentTimeMillis() - r12;
        r13.f12997h = System.currentTimeMillis();
        r13.f13010u = f6905b;
        r13.f13011v = f6906c;
        h(r13, r18, r19);
        w6.e.b(r20, r12, r11, r14, r13, r15);
        if (r16 == null) goto L40;
        r16.cancel();
        return;
    L40:
        return;
    L16:
        if (r5.f.b(r13.f12990a) == false) goto L31;
        String[] r21 = r15.getMessage().split("\\|");     // Catch: Throwable -> L27
        if (r21 != null) goto L21;
    L29:
        String r22 = "";
    L30:
        g(r22, r13);
        goto L31
    L21:
        if (r21.length < 2) goto L29;
        if (Logger.debug() == false) goto L25;
        Logger.d("SsOkHttp3Client", "getHostAddress remoteIp = " + r21[0]);     // Catch: Throwable -> L27
    L25:
        r22 = r21[0];     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L29
    L37:
        if (r13.f13013x != null) goto L8;
        r13.f13013x = e(r10, r13);     // Catch: Throwable -> L12
        goto L8
    }

    public static JSONObject e(y r8, w6.a r10) {
        JSONObject r11 = new JSONObject();
        if (r8 != null) goto L15;
        return r11;
    L15:
        r11.put("hc", "SsOkHttp3Client");     // Catch: Exception -> L12
        r11.put("hcv", "tt-ok/3.10.0.2");     // Catch: Exception -> L12
        r11.put("ua", r8.b("User-Agent"));     // Catch: Exception -> L12
        if (r10.f13015z == false) goto L9;
        r11.put("turing_callback", r10.A);     // Catch: Exception -> L12
    L9:
        if (r10.B == false) goto L14;
        r11.put("turing_retry", "1");     // Catch: Exception -> L12
    L14:
        return r11;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static String f(a0 r10) {
        if (r10 != null) goto L35;
        return "";
    L35:
        we.q r11 = r10.f13119p;     // Catch: Throwable -> L32
        if (r11 != null) goto L8;
        return "";
    L8:
        JSONObject r8 = new JSONObject();     // Catch: Throwable -> L32
        Iterator<String> r12 = r11.f().iterator();     // Catch: Throwable -> L32
    L10:
        if (r12.hasNext() == false) goto L30;
        String r13 = r12.next();     // Catch: Throwable -> L32
        if (r5.f.b(r13) == true) goto L10;
        List<String> r14 = r11.k(r13);     // Catch: Throwable -> L32
        if (r14 == null) goto L10;
        if (r14.isEmpty() == true) goto L10;
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L32
        Iterator<String> r16 = r14.iterator();     // Catch: Throwable -> L32
        int r17 = 0;
    L21:
        if (r16.hasNext() == false) goto L29;
        String r18 = r16.next();     // Catch: Throwable -> L32
        if (r5.f.b(r18) == true) goto L21;
        if (r17 != 0) goto L27;
    L26:
        r15.append(r18);     // Catch: Throwable -> L32
        r17 = r17 + 1;     // Catch: Throwable -> L32
        goto L21
    L27:
        r15.append("; ");     // Catch: Throwable -> L32
        goto L26
    L29:
        r8.put(r13, r15.toString());     // Catch: Throwable -> L32
        goto L10
    L30:
        return r8.toString();
    L32:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static void g(String r8, w6.a r10) {
        if (r5.f.b(r8) == true) goto L16;
        if (r10 == null) goto L18;
        if (Logger.debug() == false) goto L9;
        Logger.d("SsOkHttp3Client", "getRequestInfo remoteIp = " + r8);     // Catch: Throwable -> L13
    L9:
        r10.f12990a = r8;     // Catch: Throwable -> L13
        T r11 = r10.f12991b;     // Catch: Throwable -> L13
        if (r11 == 0) goto L17;
        r11.getClass();     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void h(w6.a r8, RetrofitMetrics r10, l r11) {
        if (r8 == null) goto L16;
        if (r10 == null) goto L17;
        r10.fallbackReason = r8.f13010u;
        r10.fallbackMessage = r8.f13011v;
        r10.executeCallEndTime = SystemClock.uptimeMillis();
        r10.retrofitLogReportTime = System.currentTimeMillis();
        r10.ttnetVersion = "4.0.76.2";
        r8.f13013x.put("retrofit", r10.getRetrofitLog());     // Catch: JSONException -> L8
    L10:
        if (r11 != null) goto L12;
        return;
    L12:
        r11.b(r8, f6914k);
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L10
    L17:
        return;
    }

    public static void i(boolean r8, int r10, InputStream r11, String r12, String r13, RetrofitMetrics r14) {
        if (r11 != null) goto L5;
        return;
    L5:
        int[] r15 = {0};
        byte[] r16 = h7.c.b(r8, r10, r11, r15, r14);     // Catch: Throwable -> L28
        h7.c.c(r11);
        int r17 = r15[0];
        byte[] r18 = new byte[r17];
        if (r16 == null) goto L11;
        if (r17 <= 0) goto L11;
        System.arraycopy(r16, 0, r18, 0, r17);
    L11:
        if (r17 > 0) goto L13;
        return;
    L13:
        if (r5.f.b(r12) == false) goto L15;
        return;
    L15:
        if (Logger.debug() == false) goto L37;
        h7.a r19 = new h7.a(r12);     // Catch: Throwable -> L25
        if ("text".equalsIgnoreCase(r19.f7917a) == false) goto L19;
    L20:
        String r20 = r19.b();     // Catch: Throwable -> L25
        if (r5.f.b(r20) == false) goto L23;
        r20 = "utf-8";
    L23:
        Logger.d("SsOkHttp3Client", " response body = " + new String(r18, r20) + " for url = " + r13);     // Catch: Throwable -> L25
        return;
    L19:
        if (NetworkClient.UPLOAD_FILE_TYPE_JSON.equalsIgnoreCase(r19.a()) == true) goto L20;
        return;
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L37:
        return;
    L28:
        th = move-exception;
        h7.c.c(r11);
        throw th;
    }

    @Override // com.bytedance.retrofit2.client.Client
    public final SsCall newSsCall(Request r8) {
        Request r10 = k7.b.e().b(r8);     // Catch: Throwable -> L12
        if (r10 == null) goto L5;
        r8 = r10;
    L5:
        long r11 = SystemClock.uptimeMillis();
        Request r12 = m7.c.c().b(r8);
        if (r8.getMetrics() == null) goto L8;
        RetrofitMetrics r13 = r8.getMetrics();
        r13.queryFilterDuration = SystemClock.uptimeMillis() - r11;
    L8:
        if (r12 == null) goto L11;
        r8 = r12;
    L11:
        return new b(r8);
    }
}
