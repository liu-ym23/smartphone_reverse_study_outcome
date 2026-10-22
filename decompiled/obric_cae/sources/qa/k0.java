package qa;

import android.content.Context;
import android.net.SSLSessionCache;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.retrofit2.HttpMethodContrants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static SoftReference<SSLContext> f10658n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static SoftReference<l0> f10659o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SSLContext f10661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Proxy f10662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f10663d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f10664e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10665f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10666g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f10667h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10668i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10669j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10670k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f10671l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f f10672m;

    public static class a implements Cloneable, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f10673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10674b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f10675m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f10676n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f10677o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f10678p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f10679q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f10680r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public volatile AtomicInteger f10681s;

        public a(c r8) {
            this.f10673a = r8.f10685m;
            this.f10674b = r8.f10687o;
            this.f10676n = r8.f10686n;
            this.f10677o = r8.f10695w;
            this.f10678p = r8.f10696x;
            this.f10679q = r8.f10684b.f10820a;
            this.f10675m = r8.f10683a;
            this.f10680r = r8.f10688p;
            this.f10681s = new AtomicInteger(1);
        }

        public final a a() {
            return (a) super.clone();
        L4:
            return null;
        }

        public final String b() {
            String r8 = this.f10677o + "#";     // Catch: Exception -> L26
            if (TextUtils.isEmpty(this.f10676n) == true) goto L8;
            StringBuilder r10 = new StringBuilder();     // Catch: Exception -> L26
            r10.append(r8);     // Catch: Exception -> L26
            r10.append(this.f10676n);     // Catch: Exception -> L26
            r10.append("#");     // Catch: Exception -> L26
        L9:
            String r11 = (r10.toString() + this.f10679q + "#") + this.f10681s + "#";     // Catch: Exception -> L26
            if (TextUtils.isEmpty(this.f10673a) == true) goto L13;
            StringBuilder r12 = new StringBuilder();     // Catch: Exception -> L26
            r12.append(r11);     // Catch: Exception -> L26
            r12.append(this.f10673a);     // Catch: Exception -> L26
            r12.append("#");     // Catch: Exception -> L26
        L12:
            String r13 = r12.toString();     // Catch: Exception -> L26
            if (this.f10677o != 1) goto L18;
            StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L26
            r14.append(r13);     // Catch: Exception -> L26
            r14.append(this.f10675m);     // Catch: Exception -> L26
            r14.append("#");     // Catch: Exception -> L26
        L17:
            String r15 = r14.toString();     // Catch: Exception -> L26
            if (this.f10677o != 1) goto L23;
            StringBuilder r16 = new StringBuilder();     // Catch: Exception -> L26
            r16.append(r15);     // Catch: Exception -> L26
            r16.append(this.f10680r);     // Catch: Exception -> L26
            r16.append("#");     // Catch: Exception -> L26
        L24:
            return l4.d(defpackage.c.l(((r16.toString() + this.f10674b + "#") + this.f10678p).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
        L23:
            r16 = new StringBuilder();     // Catch: Exception -> L26
            r16.append(r15);     // Catch: Exception -> L26
            r16.append("-#");     // Catch: Exception -> L26
            goto L24
        L18:
            r14 = new StringBuilder();     // Catch: Exception -> L26
            r14.append(r13);     // Catch: Exception -> L26
            r14.append("-#");     // Catch: Exception -> L26
            goto L17
        L13:
            r12 = new StringBuilder();     // Catch: Exception -> L26
            r12.append(r11);     // Catch: Exception -> L26
            r12.append("-#");     // Catch: Exception -> L26
            goto L12
        L8:
            r10 = new StringBuilder();     // Catch: Exception -> L26
            r10.append(r8);     // Catch: Exception -> L26
            r10.append("-#");     // Catch: Exception -> L26
        L26:
            return null;
        }

        public final /* synthetic */ Object clone() {
            return a();
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object r8) {
            ((a) r8).getClass();
            return 0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HttpURLConnection f10682a;

        public b(HttpURLConnection r8) {
            this.f10682a = r8;
        }
    }

    public static class c implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m0.b f10684b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f10685m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f10686n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f10687o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public long f10688p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public long f10689q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f10690r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f10691s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public long f10692t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public String f10693u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f10694v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f10695w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f10696x;

        public c() {
            this.f10683a = "";
            this.f10684b = m0.b.f10812b;
            this.f10685m = "";
            this.f10686n = "";
            this.f10687o = "";
            this.f10688p = 0;
            this.f10689q = 0;
            this.f10690r = 0;
            this.f10691s = 0;
            this.f10692t = 0;
            this.f10693u = "-";
            this.f10694v = "-";
            this.f10695w = 0;
            this.f10696x = 0;
        }

        public final c a() {
            return (c) super.clone();
        L4:
            return null;
        }

        public final String b() {
            if (TextUtils.isEmpty(this.f10685m) == true) goto L5;
            String r8 = android.aimedia.a.i(new StringBuilder(), this.f10685m, "#");
        L7:
            if (TextUtils.isEmpty(this.f10686n) == true) goto L9;
            String r10 = android.aimedia.a.i(android.aimedia.a.j(r8), this.f10686n, "#");
        L10:
            StringBuilder r11 = android.aimedia.a.j(android.aimedia.a.h(android.aimedia.a.j(r10), this.f10684b.f10820a, "#"));
            r11.append(this.f10690r);
            r11.append("#");
            StringBuilder r12 = android.aimedia.a.j(r11.toString());
            r12.append(this.f10692t);
            r12.append("#");
            StringBuilder r13 = android.aimedia.a.j(r12.toString());
            r13.append(this.f10688p);
            return l4.d(defpackage.c.l(r13.toString().getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
        L9:
            r10 = defpackage.a.e(r8, "-#");
            goto L10
        L5:
            r8 = "-#";
            goto L7
        }

        public final /* synthetic */ Object clone() {
            return a();
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("RequestInfo{csid='");
            r8.append(this.f10683a);
            r8.append("', degradeType=");
            r8.append(this.f10684b);
            r8.append(", serverIp='");
            r8.append(this.f10685m);
            r8.append("', path='");
            r8.append(this.f10686n);
            r8.append("', hostname='");
            r8.append(this.f10687o);
            r8.append("', totalTime=");
            r8.append(this.f10688p);
            r8.append(", DNSTime=");
            r8.append(this.f10689q);
            r8.append(", connectionTime=");
            r8.append(this.f10690r);
            r8.append(", writeTime=");
            r8.append(this.f10691s);
            r8.append(", readTime=");
            r8.append(this.f10692t);
            r8.append(", serverTime='");
            r8.append(this.f10693u);
            r8.append("', datasize='");
            r8.append(this.f10694v);
            r8.append("', errorcode=");
            r8.append(this.f10695w);
            r8.append(", errorcodeSub=");
            return android.aimedia.a.f(r8, this.f10696x, '}');
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Vector<e> f10697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile e f10698b;

        public d() {
            this.f10697a = new Vector();
            this.f10698b = new e();
        }
    }

    public static class e implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10700b;

        public e() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String r8, SSLSession r10) {
            HostnameVerifier r11 = HttpsURLConnection.getDefaultHostnameVerifier();
            if (TextUtils.isEmpty(this.f10699a) == true) goto L7;
            return this.f10699a.equals(r8);
        L7:
            if (TextUtils.isEmpty(this.f10700b) == true) goto L11;
            return r11.verify(this.f10700b, r10);
        L11:
            return r11.verify(r8, r10);
        }
    }

    public class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f10701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f10702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f10703c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a f10704d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f10705e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public URL f10707g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ k0 f10708h;

        public f(k0 r8) {
            this.f10708h = r8;
            this.f10701a = 0;
            this.f10702b = 0;
            this.f10703c = new c();
        }

        public final void a(int r8) {
            k0 r10 = this.f10708h;
            c r11 = this.f10703c;
            "----errorcode-----".concat(String.valueOf(r8));
            r11.f10688p = SystemClock.elapsedRealtime() - this.f10701a;     // Catch: Throwable -> L38
            r11.f10695w = r8;     // Catch: Throwable -> L38
            if (r11.f10684b.f10820a != 1) goto L6;
            boolean r12 = true;
        L7:
            if (r12 == false) goto L9;
            i4.h(r11.f10687o, false);     // Catch: Throwable -> L38
        L9:
            boolean r13 = r10.h(r11.f10687o);     // Catch: Throwable -> L38
            if (r13 == true) goto L12;
        L36:
            i4.j(this.f10707g.toString(), r11.f10684b.b(), true, r13);     // Catch: Throwable -> L38
            r11.toString();     // Catch: Throwable -> L38
            return;
        L12:
            if (r10.f10670k == false) goto L19;
            if (TextUtils.isEmpty(r10.f10668i) == true) goto L19;
            if (r11.f10684b.a() == false) goto L19;
            i4.u();     // Catch: Throwable -> L38
        L19:
            if (r11.f10684b.b() == false) goto L21;
            i4.h(r11.f10687o, r11.f10684b.b());     // Catch: Throwable -> L38
        L21:
            c r14 = this.f10705e;     // Catch: Throwable -> L38
            if (r14 != null) goto L25;
            int r15 = i4.f10541a;     // Catch: Throwable -> L38
        L31:
            i4.l(false, this.f10704d);     // Catch: Throwable -> L38
            i4.q(r11);     // Catch: Throwable -> L38
            goto L36
        L25:
            if (i4.f10562v == false) goto L31;
            LinkedList r16 = i4.A;     // Catch: Throwable -> L38
            monitor-enter(r16);     // Catch: Throwable -> L38
            r16.offer(r14);     // Catch: Throwable -> L33
            monitor-exit(r16);     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            throw th;     // Catch: Throwable -> L38
        L6:
            r12 = false;
        }

        public final void b(long r8) {
            this.f10703c.f10694v = new DecimalFormat("0.00").format(r8 / 1024.0f);
        }

        public final void c(n0 r8) {
            c r10 = this.f10703c;
            r10.f10688p = SystemClock.elapsedRealtime() - this.f10701a;     // Catch: Throwable -> L37
            r8.f10846e = r10.f10684b.b();     // Catch: Throwable -> L37
            if (r10.f10684b.a() == true) goto L6;
        L8:
            int r11 = r10.f10684b.f10820a;     // Catch: Throwable -> L37
            if (r11 != 2) goto L11;
        L14:
            boolean r12 = true;
        L15:
            if (r12 == false) goto L17;
            i4.h(this.f10706f, false);     // Catch: Throwable -> L37
        L17:
            boolean r13 = this.f10708h.h(r10.f10687o);     // Catch: Throwable -> L37
            if (r13 == true) goto L20;
        L35:
            i4.j(this.f10707g.toString(), r10.f10684b.b(), false, r13);     // Catch: Throwable -> L37
            r10.toString();     // Catch: Throwable -> L37
            return;
        L20:
            if (i4.f10562v == false) goto L26;
            LinkedList r14 = i4.A;     // Catch: Throwable -> L37
            monitor-enter(r14);     // Catch: Throwable -> L37
            r14.offer(r10);     // Catch: Throwable -> L32
            monitor-exit(r14);     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L26:
            i4.l(true, this.f10704d);     // Catch: Throwable -> L37
            if (r10.f10688p <= i4.f10555o) goto L35;
            c r15 = r10.a();     // Catch: Throwable -> L37
            if (r15 == null) goto L35;
            r15.f10695w = 1;     // Catch: Throwable -> L37
            i4.q(r15);     // Catch: Throwable -> L37
            r15.toString();     // Catch: Throwable -> L37
            goto L35
        L11:
            if (r11 == 5) goto L14;
            r12 = false;
            goto L15
        L6:
            if (r10.f10688p <= 10000) goto L8;
            i4.h(r10.f10687o, false);     // Catch: Throwable -> L37
        }

        public final void d() {
            this.f10703c.f10690r = SystemClock.elapsedRealtime() - this.f10702b;
        }

        public final void e() {
            this.f10703c.f10692t = SystemClock.elapsedRealtime() - this.f10702b;
        }

        public final void f() {
            c r8 = this.f10703c;
            c r10 = r8.a();
            if (r8.f10688p <= i4.f10555o) goto L5;
            r10.f10695w = 1;
        L5:
            if (r10 != null) goto L7;
            return;
        L7:
            if (i4.f10543c == null) goto L18;
            HashMap r11 = new HashMap();
            r11.put("serverip", r10.f10685m);
            r11.put("hostname", r10.f10687o);
            r11.put("path", r10.f10686n);
            r11.put("csid", r10.f10683a);
            r11.put("degrade", String.valueOf(r10.f10684b.f10820a));
            r11.put("errorcode", String.valueOf(r10.f10695w));
            r11.put("errorsubcode", String.valueOf(r10.f10696x));
            r11.put("connecttime", String.valueOf(r10.f10690r));
            r11.put("writetime", String.valueOf(r10.f10691s));
            r11.put("readtime", String.valueOf(r10.f10692t));
            r11.put("datasize", String.valueOf(r10.f10694v));
            r11.put("totaltime", String.valueOf(r10.f10688p));
            String r12 = new JSONObject(r11).toString();
            "--埋点--".concat(String.valueOf(r12));
            if (TextUtils.isEmpty(r12) == true) goto L19;
            t0 r13 = new t0(i4.f10543c, "core", "2.0", "O008");     // Catch: g4 -> L14
            r13.a(r12);     // Catch: g4 -> L14
            u0.c(r13, i4.f10543c);     // Catch: g4 -> L14
            return;
        L20:
            return;
        L19:
            return;
        }
    }

    public k0() {
        this.f10665f = "";
        this.f10669j = false;
        this.f10670k = false;
        this.f10671l = "";
        this.f10672m = new f(this);
        i4.w();
        this.f10663d = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        l.a("ht", "ic", th);
    }

    public static int a(IOException r8) {
        if ((r8 instanceof SSLHandshakeException) == false) goto L7;
        return 4101;
    L7:
        if ((r8 instanceof SSLKeyException) == false) goto L11;
        return 4102;
    L11:
        if ((r8 instanceof SSLProtocolException) == false) goto L15;
        return 4103;
    L15:
        if ((r8 instanceof SSLPeerUnverifiedException) == false) goto L19;
        return 4104;
    L19:
        if ((r8 instanceof ConnectException) == false) goto L23;
        return 6101;
    L23:
        if ((r8 instanceof SocketException) == false) goto L27;
        return 6102;
    L27:
        if ((r8 instanceof ConnectTimeoutException) == false) goto L31;
        return 2101;
    L31:
        if ((r8 instanceof SocketTimeoutException) == false) goto L34;
        return 2102;
    L34:
        return 0;
    }

    public static String b(Map<String, String> r8) {
        if (r8 == null) goto L15;
        StringBuilder r10 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r11 = r8.entrySet().iterator();
    L5:
        if (r11.hasNext() == false) goto L14;
        Map.Entry<String, String> r12 = r11.next();
        String r13 = r12.getKey();
        String r14 = r12.getValue();
        if (r14 != null) goto L10;
        r14 = "";
    L10:
        if (r10.length() <= 0) goto L12;
        r10.append("&");
    L12:
        r10.append(URLEncoder.encode(r13));
        r10.append("=");
        r10.append(URLEncoder.encode(r14));
        goto L5
    L14:
        return r10.toString();
    L15:
        return null;
    }

    public static String f(Map<String, List<String>> r8) {
        List<String> r10 = r8.get("sc");     // Catch: Throwable -> L18
        if (r10 == null) goto L16;
        if (r10.size() <= 0) goto L16;
        String r11 = r10.get(0);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r11) == true) goto L16;
        if (r11.contains("#") == false) goto L21;
        String[] r12 = r11.split("#");     // Catch: Throwable -> L18
        if (r12.length <= 1) goto L16;
        return r12[0];
    L21:
        return r11;
    L16:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n0 c(b r12) {
        String r8 = "";
        ByteArrayOutputStream r10 = null;
        InputStream r11 = null;
        r11 = null;
        InputStream r13 = null;
        r11 = null;
        r13 = null;
        r13 = null;
        r10 = null;
        ConcurrentHashMap<String, j0.c> r14 = j0.f10610a;     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        Context r15 = i4.f10543c;     // Catch: Throwable -> L180
        if (r15 == null) goto L8;
        u0.a(r15, j0.l());     // Catch: Throwable -> L180
    L8:
        HttpURLConnection r16 = r12.f10682a;     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        Map<String, List<String>> r17 = r16.getHeaderFields();     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        int r18 = r16.getResponseCode();     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        if (r17 == null) goto L63;
        List<String> r19 = r17.get("gsid");     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        if (r19 != null) goto L13;
    L15:
        this.f10672m.f10703c.f10693u = f(r17);     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        if (TextUtils.isEmpty(this.f10665f) == true) goto L63;
        if (this.f10669j == true) goto L21;
        boolean r20 = e(r17, true);     // Catch: Throwable -> L181
        Object[] r21 = 2;
    L37:
        if (r20 == true) goto L39;
        if (r21 != 1) goto L63;
        j0.e(this.f10665f, false);     // Catch: Throwable -> L181
        goto L63
    L39:
        if (this.f10665f.equals("loc") == false) goto L48;
        String r22 = this.f10671l;     // Catch: Throwable -> L181
        if (TextUtils.isEmpty(r22) == false) goto L43;
        r22 = r16.getURL().getHost();     // Catch: Throwable -> L181
    L43:
        String r23 = this.f10665f;     // Catch: Throwable -> L181
        if (r21 != 2) goto L46;
        boolean r24 = true;
    L47:
        i4.i(r23, r24, r22, r22, this.f10668i);     // Catch: Throwable -> L181
        goto L63
    L46:
        r24 = false;
        goto L47
    L48:
        String r25 = this.f10665f;     // Catch: Throwable -> L181
        if (r21 != 2) goto L51;
        boolean r26 = true;
    L52:
        int r27 = i4.f10541a;     // Catch: Throwable -> L181
        monitor-enter(i4.class);     // Catch: Throwable -> L181
        i4.i(r25, r26, null, null, null);     // Catch: Throwable -> L57
        monitor-exit(i4.class);     // Catch: Throwable -> L181
        goto L63
    L57:
        th = move-exception;
        throw th;     // Catch: Throwable -> L181
    L51:
        r26 = false;
        goto L52
    L21:
        if (r17.containsKey("sc") == false) goto L23;
        r20 = e(r17, false);     // Catch: Throwable -> L181
        r21 = 1;
        goto L37
    L23:
        String r28 = this.f10665f;     // Catch: Throwable -> L181
        int r29 = i4.f10541a;     // Catch: Throwable -> L181
        monitor-enter(i4.class);     // Catch: Throwable -> L181
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L181
    L26:
        if (i4.f10551k != null) goto L29;
    L31:
        monitor-exit(i4.class);     // Catch: Throwable -> L181
        r20 = false;
        r21 = 0;
        goto L37
    L29:
        if (i4.f10551k.containsKey(r28) == false) goto L31;
        i4.f10551k.remove(r28);     // Catch: Throwable -> L33
        goto L63
    L13:
        if (r19.size() <= 0) goto L15;
        r8 = r19.get(0);     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
    L63:
        if (r18 != 200) goto L129;
        ByteArrayOutputStream r30 = new ByteArrayOutputStream();     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        this.f10672m.f10702b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L120 IOException -> L122 SocketTimeoutException -> L125 ConnectTimeoutException -> L127
        InputStream r31 = r16.getInputStream();     // Catch: Throwable -> L120 IOException -> L122 SocketTimeoutException -> L125 ConnectTimeoutException -> L127
        PushbackInputStream r32 = new PushbackInputStream(r31, 2);     // Catch: Throwable -> L112 IOException -> L114 SocketTimeoutException -> L116 ConnectTimeoutException -> L118
        byte[] r33 = new byte[2];     // Catch: IOException -> L106 SocketTimeoutException -> L108 ConnectTimeoutException -> L110 Throwable -> L157
        r32.read(r33);     // Catch: IOException -> L106 SocketTimeoutException -> L108 ConnectTimeoutException -> L110 Throwable -> L157
        r32.unread(r33);     // Catch: IOException -> L106 SocketTimeoutException -> L108 ConnectTimeoutException -> L110 Throwable -> L157
        if (r33[0] == 31) goto L70;
    L73:
        InputStream r34 = r32;
    L209:
        byte[] r35 = new byte[1024];     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
    L76:
        int r36 = r34.read(r35);     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        if (r36 == (-1)) goto L79;
        r30.write(r35, 0, r36);     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        goto L76
    L79:
        this.f10672m.e();     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        q.g();     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        n0 r37 = new n0();     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        r37.f10842a = r30.toByteArray();     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        r37.f10843b = r17;     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        r37.f10844c = this.f10663d;     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        r37.f10845d = r8;     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        j0.f(r16.getURL(), r37);     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        this.f10672m.b(r37.f10842a.length);     // Catch: Throwable -> L98 IOException -> L100 SocketTimeoutException -> L102 ConnectTimeoutException -> L104
        r30.close();     // Catch: Throwable -> L82
    L84:
        if (r31 == null) goto L198;
        r31.close();     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        l.a("ht", "par", th);
    L198:
        r32.close();     // Catch: Throwable -> L91
    L205:
        r34.close();     // Catch: Throwable -> L95
    L97:
        return r37;
    L95:
        th = move-exception;
        l.a("ht", "par", th);
    L91:
        th = move-exception;
        l.a("ht", "par", th);
    L82:
        th = move-exception;
        l.a("ht", "par", th);
        goto L84
    L102:
        e = move-exception;
        throw e;     // Catch: Throwable -> L157
    L104:
        e = move-exception;
        throw e;     // Catch: Throwable -> L157
    L100:
        e = e;
        r11 = r34;
    L124:
        InputStream r38 = r11;
        r10 = r30;
    L204:
    L148:
        th = th;
    L159:
        if (r10 != null) goto L183;
    L164:
        if (r31 != null) goto L191;
    L169:
        if (r32 != null) goto L196;
    L174:
        if (r38 == null) goto L224;
        r38.close();     // Catch: Throwable -> L177
        throw th;
    L177:
        th = move-exception;
        l.a("ht", "par", th);
        throw th;
    L224:
        throw th;
    L196:
        r32.close();     // Catch: Throwable -> L172
    L172:
        th = move-exception;
        l.a("ht", "par", th);
        goto L174
    L191:
        r31.close();     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        l.a("ht", "par", th);
        goto L169
    L183:
        r10.close();     // Catch: Throwable -> L162
    L162:
        th = move-exception;
        l.a("ht", "par", th);
        goto L164
    L140:
        if ((e instanceof InterruptedIOException) == false) goto L147;
        g4 r39 = new g4("IO 操作异常 - IOException", r8, this.f10663d);     // Catch: Throwable -> L148
        if (TextUtils.isEmpty(e.getMessage()) == false) goto L144;
        throw r39;     // Catch: Throwable -> L148
    L144:
        if (e.getMessage().equals("thread interrupted") == false) goto L217;
        r39.f10484r = true;     // Catch: Throwable -> L148
        throw r39;     // Catch: Throwable -> L148
    L217:
        throw r39;     // Catch: Throwable -> L148
    L147:
        throw e;     // Catch: Throwable -> L148
    L98:
        th = th;
        r13 = r34;
    L158:
        r38 = r13;
        r10 = r30;
        goto L159
    L70:
        if (r33[1] != (-117)) goto L73;
        r34 = new GZIPInputStream(r32);     // Catch: IOException -> L106 SocketTimeoutException -> L108 ConnectTimeoutException -> L110 Throwable -> L157
    L108:
        e = move-exception;
        throw e;     // Catch: Throwable -> L157
    L110:
        e = move-exception;
        throw e;     // Catch: Throwable -> L157
    L106:
        e = e;
        goto L124
    L116:
        e = move-exception;
        throw e;     // Catch: Throwable -> L157
    L118:
        e = move-exception;
        throw e;     // Catch: Throwable -> L157
    L114:
        e = e;
        r32 = null;
    L112:
        th = th;
        r32 = null;
        goto L158
    L125:
        e = e;
        Object[] r40 = null;
    L152:
        throw e;     // Catch: Throwable -> L157
    L127:
        e = e;
        Object[] r41 = null;
    L156:
        throw e;     // Catch: Throwable -> L157
    L122:
        e = e;
        r31 = null;
        r32 = null;
    L120:
        th = th;
        r31 = null;
        r32 = null;
        goto L158
    L129:
        g4 r42 = new g4("网络异常原因：" + r16.getResponseMessage() + " 网络异常状态码：" + r18 + "  " + r8 + " " + this.f10663d, r8, this.f10663d);     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        r16.getResponseMessage();     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        r42.f10485s = r17;     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        f r110 = this.f10672m;     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        r110.f10703c.f10696x = r18;     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        r110.a(10);     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        r42.f10483q = 10;     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
        throw r42;     // Catch: Throwable -> L131 IOException -> L133 SocketTimeoutException -> L135 ConnectTimeoutException -> L153
    L157:
        th = th;
    L135:
        e = e;
        r40 = null;
    L153:
        e = e;
        r41 = null;
    L133:
        e = e;
        r38 = null;
        r31 = null;
        r32 = null;
    L131:
        th = th;
        r38 = null;
        r31 = null;
        r32 = null;
        goto L159
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    public final n0 d(m0 r15) {
        DataOutputStream r8 = 0;
        r8 = 0;
        g(r15);     // Catch: Throwable -> L65 g4 -> L68 IOException -> L76 InterruptedIOException -> L111 SocketTimeoutException -> L83 SocketException -> L86 UnknownHostException -> L89 MalformedURLException -> L92 ConnectTimeoutException -> L95 ConnectException -> L98 SSLException -> L101
        n0 r10 = j0.m(this.f10667h, this.f10665f);     // Catch: Throwable -> L65 g4 -> L68 IOException -> L76 InterruptedIOException -> L111 SocketTimeoutException -> L83 SocketException -> L86 UnknownHostException -> L89 MalformedURLException -> L92 ConnectTimeoutException -> L95 ConnectException -> L98 SSLException -> L101
        if (r10 == null) goto L7;
        this.f10672m.f();
        return r10;
    L7:
        b r11 = i(r15);     // Catch: Throwable -> L65 g4 -> L68 IOException -> L76 InterruptedIOException -> L111 SocketTimeoutException -> L83 SocketException -> L86 UnknownHostException -> L89 MalformedURLException -> L92 ConnectTimeoutException -> L95 ConnectException -> L98 SSLException -> L101
        HttpURLConnection r12 = r11.f10682a;     // Catch: Throwable -> L65 g4 -> L68 IOException -> L76 InterruptedIOException -> L111 SocketTimeoutException -> L83 SocketException -> L86 UnknownHostException -> L89 MalformedURLException -> L92 ConnectTimeoutException -> L95 ConnectException -> L98 SSLException -> L101
        this.f10672m.f10702b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r12.connect();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        this.f10672m.d();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        byte[] r13 = r15.i();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        if (r13 != null) goto L11;
    L12:
        String r16 = b(r15.h());     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        if (TextUtils.isEmpty(r16) == true) goto L15;
        r13 = t4.i(r16);     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L15:
        if (r13 != null) goto L17;
    L37:
        n0 r17 = c(r11);     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        this.f10672m.c(r17);     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r12.disconnect();     // Catch: Throwable -> L40
    L42:
        this.f10672m.f();
        return r17;
    L40:
        th = move-exception;
        l.a("ht", "mPt", th);
        goto L42
    L17:
        if (r13.length <= 0) goto L37;
        this.f10672m.f10702b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L29
        OutputStream r18 = r12.getOutputStream();     // Catch: Throwable -> L29
        DataOutputStream r14 = new DataOutputStream(r18);     // Catch: Throwable -> L27
        r14.write(r13);     // Catch: Throwable -> L25
        r14.close();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        if (r18 == null) goto L24;
        r18.close();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L24:
        f r19 = this.f10672m;     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r19.getClass();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r19.f10703c.f10691s = SystemClock.elapsedRealtime() - r19.f10702b;     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L25:
        th = move-exception;
        Throwable th = th;
        r8 = r14;
    L31:
        if (r8 == 0) goto L33;
        r8.close();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L33:
        if (r18 == null) goto L35;
        r18.close();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L35:
        f r110 = this.f10672m;     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r110.getClass();     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r110.f10703c.f10691s = SystemClock.elapsedRealtime() - r110.f10702b;     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        throw th;     // Catch: Throwable -> L44 g4 -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L27:
        th = th;
    L29:
        th = move-exception;
        th = th;
        r18 = null;
        goto L31
    L11:
        if (r13.length != 0) goto L15;
    L61:
        e = e;
    L99:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.f10672m.f10703c.f10696x = a(e);     // Catch: Throwable -> L81
        this.f10672m.a(6);     // Catch: Throwable -> L81
        throw new g4("http连接失败 - ConnectionException");     // Catch: Throwable -> L81
    L57:
        e = e;
    L93:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.f10672m.a(8);     // Catch: Throwable -> L81
        throw new g4("url异常 - MalformedURLException");     // Catch: Throwable -> L81
    L53:
        e = e;
    L87:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.f10672m.f10703c.f10696x = a(e);     // Catch: Throwable -> L81
        this.f10672m.a(6);     // Catch: Throwable -> L81
        throw new g4("socket 连接异常 - SocketException");     // Catch: Throwable -> L81
    L51:
        e = e;
    L84:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.f10672m.f10703c.f10696x = a(e);     // Catch: Throwable -> L81
        this.f10672m.a(2);     // Catch: Throwable -> L81
        throw new g4("socket 连接超时 - SocketTimeoutException");     // Catch: Throwable -> L81
    L55:
        e = e;
    L90:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.f10672m.a(5);     // Catch: Throwable -> L81
        throw new g4("未知主机 - UnKnowHostException");     // Catch: Throwable -> L81
    L63:
        e = e;
    L102:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.f10672m.f10703c.f10696x = a(e);     // Catch: Throwable -> L81
        this.f10672m.a(4);     // Catch: Throwable -> L81
        throw new g4("IO 操作异常 - IOException");     // Catch: Throwable -> L81
    L59:
        e = e;
    L96:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.f10672m.f10703c.f10696x = a(e);     // Catch: Throwable -> L81
        this.f10672m.a(2);     // Catch: Throwable -> L81
        throw new g4("IO 操作异常 - IOException");     // Catch: Throwable -> L81
    L48:
        e = e;
    L77:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.f10672m.a(7);     // Catch: Throwable -> L81
        throw new g4("IO 操作异常 - IOException");     // Catch: Throwable -> L81
    L46:
        e = e;
    L70:
        if (e.f10484r == true) goto L74;
        int r20 = e.f10483q;     // Catch: Throwable -> L81
        if (r20 == 10) goto L74;
        this.f10672m.a(r20);     // Catch: Throwable -> L81
    L74:
        l.a("ht", "mPt", e);     // Catch: Throwable -> L81
        throw e;     // Catch: Throwable -> L81
    L44:
        th = th;
    L66:
        l.a("ht", "mPt", th);     // Catch: Throwable -> L81
        this.f10672m.a(9);     // Catch: Throwable -> L81
        throw new g4("未知的错误");     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        if (0 != 0) goto L121;
    L109:
        this.f10672m.f();
        throw th;
    L121:
        r8.disconnect();     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        l.a("ht", "mPt", th);
    L83:
        e = e;
    L98:
        e = e;
    L92:
        e = e;
    L86:
        e = e;
    L89:
        e = e;
    L101:
        e = e;
    L95:
        e = e;
    L76:
        e = e;
    L68:
        e = e;
    L65:
        th = th;
    L79:
        f r111 = this.f10672m;     // Catch: Throwable -> L81
        r111.f10703c.f10696x = 7101;     // Catch: Throwable -> L81
        r111.a(7);     // Catch: Throwable -> L81
        throw new g4("未知的错误");     // Catch: Throwable -> L81
    }

    public final boolean e(Map<String, List<String>> r8, boolean r10) {
        List<String> r11 = r8.get("sc");     // Catch: Throwable -> L31
        if (r11 != null) goto L6;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == true) goto L20;
        return false;
    L20:
        if (r10 == false) goto L30;
        if (r8.containsKey("lct") == false) goto L34;
        List<String> r13 = r8.get("lct");     // Catch: Throwable -> L31
        if (r13 != null) goto L26;
        return false;
    L26:
        if (r13.size() <= 0) goto L36;
        return i4.n(i4.a(r13), this.f10665f);
    L36:
        return false;
    L34:
        return false;
    L30:
        return true;
    L6:
        if (r11.size() <= 0) goto L17;
        String r14 = r11.get(0);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r14) == true) goto L17;
        if (r14.contains("#") == false) goto L16;
        String[] r15 = r14.split("#");     // Catch: Throwable -> L31
        if (r15.length <= 1) goto L17;
        if ("1".equals(r15[1]) == false) goto L17;
    L16:
        r12 = true;
    L38:
        return false;
    }

    public final void g(m0 r13) {
        this.f10664e = new d();
        this.f10670k = r13.f10803g;
        this.f10662c = r13.f10798b;
        this.f10666g = r13.f10799c;
        o0.a r8 = null;
        String r10 = r13.k();     // Catch: Throwable -> L21
    L19:
        th = th;
    L23:
        l.a("ht", "pnfr", th);
    L24:
        String r11 = r10;
    L25:
        this.f10665f = r11;
        m4 r12 = m4.a.f10837a;
        boolean r14 = true;
        if (r13.f10804h == false) goto L28;
        r12.getClass();
    L32:
        boolean r15 = true;
    L33:
        this.f10660a = r15;
        if (r13.f10806j.a() == false) goto L36;
        String r16 = r13.d(r13.e());
    L37:
        this.f10667h = r16;
        String r17 = this.f10665f;
        ConcurrentHashMap<String, j0.c> r18 = j0.f10610a;
        monitor-enter(j0.class);
        System.currentTimeMillis();     // Catch: Throwable -> L76 g4 -> L192
        if (TextUtils.isEmpty(r17) == false) goto L42;
    L78:
        monitor-exit(j0.class);
        this.f10667h = r16;
        "restrictionURLTest: ".concat(String.valueOf(r16));
        monitor-enter(o0.class);
    L189:
        th = move-exception;
        throw th;
    L82:
        if (o0.f10865d != null) goto L84;
        o0.f10865d = new o0();     // Catch: Throwable -> L189
    L84:
        o0 r19 = o0.f10865d;     // Catch: Throwable -> L189
        monitor-exit(o0.class);
        r19.getClass();
        if (r16 != null) goto L89;
    L173:
        r14 = false;
    L174:
        if (r14 == true) goto L187;
        this.f10668i = r13.j();
        if ("loc".equals(this.f10665f) == false) goto L236;
        String r20 = r13.d(r13.c());
        String r110 = r13.d(r13.e());
        if (TextUtils.isEmpty(r20) == true) goto L181;
        new URL(r20).getHost();     // Catch: Exception -> L199
    L181:
        if (TextUtils.isEmpty(r110) == true) goto L237;
        if (TextUtils.isEmpty(this.f10668i) == true) goto L185;
        return;
    L185:
        new URL(r110).getHost();     // Catch: Exception -> L200
        return;
    L238:
        return;
    L237:
        return;
    L236:
        return;
    L187:
        "restriction hit: ".concat(String.valueOf(r16));
        throw new g4("限制访问的接口");
    L89:
        if (r16.length() == 0) goto L173;
        o0.a r21 = new o0.a(new URL(r16));     // Catch: MalformedURLException -> L94
    L118:
        if (r21 == null) goto L133;
        String r22 = r21.f10871c;
        if (r22 != null) goto L124;
    L132:
        r8 = r21;
        goto L133
    L124:
        if (r22.length() == 0) goto L132;
    L126:
        String r23 = r21.f10871c;
        if (r23.charAt(r23.length() - 1) != '/') goto L130;
        String r24 = r21.f10871c;
        r21.f10871c = r24.substring(0, r24.length() - 1);
    L130:
        if (r21.f10871c.charAt(0) != '/') goto L132;
        r21.f10871c = r21.f10871c.substring(1);
    L133:
        if (r8 == null) goto L173;
        monitor-enter(r19);
    L170:
        th = move-exception;
        throw th;
    L137:
        if (r8.f10871c.length() == 0) goto L168;
        Map r25 = r19.f10867b;     // Catch: Throwable -> L170
        String r26 = r8.f10869a;     // Catch: Throwable -> L170
        if (r26 != null) goto L142;
    L144:
        List r27 = r19.f10868c;     // Catch: Throwable -> L170
        String r28 = r8.f10870b;     // Catch: Throwable -> L170
        if (r28 != null) goto L147;
    L149:
        Iterator r29 = r27.iterator();     // Catch: Throwable -> L170
    L150:
        if (r29.hasNext() == false) goto L168;
        String r30 = (String) r29.next();     // Catch: Throwable -> L170
        String r31 = r8.f10871c;     // Catch: Throwable -> L170
        String[] r32 = r30.split("/");     // Catch: Throwable -> L170
        String[] r33 = r31.split("/");     // Catch: Throwable -> L170
        if (r33.length < r32.length) goto L162;
        int r34 = 0;
    L157:
        if (r34 >= r32.length) goto L164;
        if (r32[r34].equals("*") == true) goto L163;
        if (r32[r34].equals(r33[r34]) == false) goto L162;
    L163:
        r34 = r34 + 1;
        goto L157
    L164:
        boolean r35 = true;
    L165:
        if (r35 == false) goto L150;
        monitor-exit(r19);
    L162:
        r35 = false;
        goto L165
    L147:
        if (r25.containsKey(r28) == false) goto L149;
        r27 = (List) r25.get(r8.f10870b);     // Catch: Throwable -> L170
        goto L149
    L142:
        if (r19.f10866a.containsKey(r26) == false) goto L144;
        r25 = (Map) r19.f10866a.get(r8.f10869a);     // Catch: Throwable -> L170
    L168:
        monitor-exit(r19);
    L95:
        if (r16.contains("://") == false) goto L97;
        r21 = null;
        goto L118
    L97:
        String r36 = r16;
    L99:
        if (r36.startsWith("/") == false) goto L101;
        r36 = r36.substring(1);
        goto L99
    L101:
        String[] r37 = r36.split("/");
        if (r37[0].contains(".") == false) goto L104;
        String r38 = r37[0];
        int r39 = 1;
    L105:
        StringBuilder r111 = new StringBuilder();
    L107:
        if (r39 >= r37.length) goto L113;
        if (r111.length() <= 0) goto L111;
        r111.append("/");
    L111:
        r111.append(r37[r39]);
        r39 = r39 + 1;
        goto L107
    L113:
        if (r111.length() > 0) goto L115;
    L117:
        r21 = new o0.a(r38, r111.toString());
        goto L118
    L115:
        if (r111.charAt(r111.length() - 1) != '/') goto L117;
        r111.deleteCharAt(r111.length() - 1);
        goto L117
    L104:
        r38 = null;
        r39 = 0;
        goto L105
    L42:
        if (TextUtils.isEmpty(r16) == true) goto L78;
        Context r40 = i4.f10543c;     // Catch: Throwable -> L76 g4 -> L192
    L58:
        th = move-exception;
        l.a("hlUtil", "llhl", th);     // Catch: Throwable -> L76 g4 -> L192
    L61:
        if (j0.f10610a == null) goto L78;
        if (j0.f10610a.size() <= 0) goto L78;
        if (j0.f10610a.containsKey(r17) == false) goto L78;
        j0.c r41 = j0.f10610a.get(r17);     // Catch: Throwable -> L76 g4 -> L192
        if (r41 == null) goto L78;
        if (j0.i(r16, r41, r17) == true) goto L75;
        r16 = j0.k(r16, r41, r17);     // Catch: Throwable -> L76 g4 -> L192
        goto L78
    L75:
        throw new g4("服务QPS超限");     // Catch: Throwable -> L76 g4 -> L192
    L46:
        if (j0.f10611b != null) goto L48;
        j0.f10611b = Collections.synchronizedList(new ArrayList(8));     // Catch: Throwable -> L58
    L48:
        if (r40 == null) goto L61;
        if (j0.f10611b.contains(r17) == true) goto L61;
        j0.f10611b.add(r17);     // Catch: Throwable -> L58
        String r42 = z.c(r40, "Yb3Blbl9odHRwX2NvbnRyb2w", r17);     // Catch: Throwable -> L58
        if (TextUtils.isEmpty(r42) == true) goto L61;
        j0.d(r17, new JSONObject(r42));     // Catch: Throwable -> L58
    L194:
        th = move-exception;
        throw th;     // Catch: Throwable -> L196
    L196:
        th = move-exception;
        throw th;
    L192:
        e = move-exception;
        throw e;     // Catch: Throwable -> L194
    L76:
        th = move-exception;
        l.a("hlUtil", "pcr", th);     // Catch: Throwable -> L194
        goto L78
    L36:
        r16 = r13.d(r13.c());
        goto L37
    L28:
        if (r12.b() == true) goto L32;
        r15 = false;
        goto L33
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L24;
        if (r13.f10799c == false) goto L9;
        r11 = m0.f(((i0) r13).t());     // Catch: Throwable -> L19
        goto L25
    L9:
        Map<String, String> r43 = r13.a();     // Catch: Throwable -> L19
        if (r43 != null) goto L214;
    L18:
        r10 = null;
        goto L24
    L214:
    L16:
        th = move-exception;
        l.a("ht", "pnfh", th);     // Catch: Throwable -> L19
        goto L18
    L13:
        if (r43.containsKey("platinfo") == false) goto L18;
        r10 = m0.f(r43.get("platinfo"));     // Catch: Throwable -> L16
    L21:
        th = th;
        r10 = "";
        goto L23
    }

    public final boolean h(String r8) {
        if (this.f10666g == false) goto L5;
    L20:
        return true;
    L5:
        if (TextUtils.isEmpty(this.f10668i) == true) goto L11;
        if (this.f10668i.contains("rest") == true) goto L20;
        if (this.f10668i.contains("apilocate") == true) goto L20;
    L11:
        if (r8.contains("rest") == false) goto L13;
    L16:
        boolean r10 = true;
    L17:
        if (r10 == true) goto L20;
        return false;
    L13:
        if (r8.contains("apilocate") == true) goto L16;
        r10 = false;
        goto L17
    }

    public final b i(m0 r15) {
        f r8 = this.f10672m;
        m0.b r10 = r15.f10806j;
        c r11 = r8.f10703c;
        r11.f10683a = r8.f10708h.f10663d;
        r11.f10684b = r10;
        r8.f10701a = SystemClock.elapsedRealtime();
        Map<String, String> r12 = r15.a();
        if (r12 != null) goto L5;
        r12 = new HashMap();
    L5:
        d r13 = this.f10664e;
        String r14 = this.f10668i;
        r13.getClass();
        if (TextUtils.isEmpty(r14) == false) goto L8;
        e r16 = r13.f10698b;
    L18:
        String r17 = this.f10667h;
        Uri r18 = Uri.parse(r17);
        String r19 = r18.getHost();
        if (TextUtils.isEmpty("") == true) goto L23;
        r15.f10801e = false;
        r17 = r18.buildUpon().encodedAuthority("").build().toString();
        r12.put("targetHost", r19);
        this.f10671l = r19;
        if (this.f10660a == false) goto L23;
        TextUtils.isEmpty(r16.f10699a);
        r16.f10699a = "";
    L23:
        this.f10667h = r17;
        URL r20 = new URL(this.f10667h);
        f r21 = this.f10672m;
        r21.f10707g = r20;
        String r22 = r20.getPath();
        c r23 = r21.f10703c;
        r23.f10686n = r22;
        r23.f10687o = r20.getHost();
        k0 r24 = r21.f10708h;
        if (TextUtils.isEmpty(r24.f10668i) == true) goto L29;
        if (r15.f10806j.a() == false) goto L29;
        r23.f10685m = r23.f10687o.replace("[", "").replace("]", "");
        r23.f10687o = r24.f10668i;
    L29:
        if (r15.f10806j.a() == false) goto L31;
        r15.f10802f = r23.f10687o;
    L31:
        int r25 = r15.f10806j.f10820a;
        if (r25 != 2) goto L34;
    L37:
        boolean r26 = true;
    L38:
        if (r26 == false) goto L40;
        r21.f10706f = r15.f10802f;
    L40:
        String r27 = r20.getHost();
        if (r27.contains("rest") == false) goto L43;
    L46:
        boolean r28 = true;
    L47:
        if (r28 == false) goto L131;
        if (r15.g() == false) goto L131;
        m0.b r29 = r15.f10806j;
        String r30 = this.f10672m.f10703c.f10687o;
        if (h(r30) == true) goto L53;
    L88:
        boolean r31 = false;
    L89:
        if (r31 == false) goto L131;
        this.f10672m.f10702b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L276
        String r32 = "";
        InetAddress[] r33 = InetAddress.getAllByName(this.f10672m.f10703c.f10687o);     // Catch: Throwable -> L276
        if (r33 != null) goto L93;
    L124:
        f r34 = this.f10672m;     // Catch: Throwable -> L276
        "---onDNSEnd---ip=".concat(String.valueOf(r32));     // Catch: Throwable -> L276
        r34.f10703c.f10685m = r32.replace("[", "").replace("]", "");     // Catch: Throwable -> L276
        r34.f10703c.f10689q = SystemClock.elapsedRealtime() - r34.f10702b;     // Catch: Throwable -> L276
        if (TextUtils.isEmpty(r32) == true) goto L131;
        Uri r35 = Uri.parse(this.f10667h);     // Catch: Throwable -> L276
        String r36 = r35.getHost();     // Catch: Throwable -> L276
        Uri r37 = r35.buildUpon().encodedAuthority(r32).build();     // Catch: Throwable -> L276
        this.f10668i = r36;     // Catch: Throwable -> L276
        r12.put("host", r36);     // Catch: Throwable -> L276
        if (this.f10660a == false) goto L129;
        r16.f10700b = r36;     // Catch: Throwable -> L276
    L129:
        this.f10667h = r37.toString();     // Catch: Throwable -> L276
        goto L131
    L93:
        if (r33.length <= 0) goto L124;
        if (r33[0] == null) goto L124;
        if (i4.m() == true) goto L99;
    L101:
        boolean r38 = false;
    L102:
        "---canUseIpv6---".concat(String.valueOf(r38));     // Catch: Throwable -> L276
        if (r38 == false) goto L111;
        int r39 = 0;
    L106:
        if (r39 >= r33.length) goto L119;
        if ((r33[r39] instanceof Inet6Address) == true) goto L109;
        r39 = r39 + 1;     // Catch: Throwable -> L276
        goto L106
    L109:
        r32 = "[" + r33[r39].getHostAddress() + "]";     // Catch: Throwable -> L276
    L119:
        if (TextUtils.isEmpty(r32) == false) goto L124;
        InetAddress r40 = r33[0];     // Catch: Throwable -> L276
        String r41 = r40.getHostAddress();     // Catch: Throwable -> L276
        if ((r40 instanceof Inet6Address) == false) goto L123;
        r32 = "[" + r41 + "]";     // Catch: Throwable -> L276
        goto L124
    L123:
        r32 = r41;
        goto L124
    L111:
        int r42 = 0;
    L113:
        if (r42 >= r33.length) goto L119;
        InetAddress r43 = r33[r42];     // Catch: Throwable -> L276
        if ((r43 instanceof Inet4Address) == true) goto L116;
        r42 = r42 + 1;     // Catch: Throwable -> L276
        goto L113
    L116:
        r32 = r43.getHostAddress();     // Catch: Throwable -> L276
        goto L119
    L99:
        if (i4.t() == false) goto L101;
        r38 = true;
        goto L102
    L53:
        if (r29.a() == false) goto L58;
        if (i4.f10557q == false) goto L58;
    L87:
        r31 = true;
    L58:
        if (r29.b() == false) goto L88;
        int r44 = i4.f10541a;
        if (TextUtils.isEmpty(r30) == true) goto L85;
        if (i4.f10560t == false) goto L85;
        if (i4.f10564x.get(r30) != null) goto L69;
        boolean r45 = true;
    L70:
        if (r45 == false) goto L85;
        Context r46 = i4.f10543c;     // Catch: Throwable -> L275
        if (r46 == null) goto L84;
        i4.f r47 = i4.b(r46, i4.p(r30, "a15"));     // Catch: Throwable -> L275
        if (r47 == null) goto L84;
        AtomicInteger r48 = r47.f10585c;     // Catch: Throwable -> L275
        if (r48 != null) goto L81;
        int r49 = 0;
    L82:
        if (r49 >= i4.f10561u) goto L85;
    L81:
        r49 = r48.get();     // Catch: Throwable -> L275
    L84:
        boolean r50 = true;
    L86:
        if (r50 == false) goto L88;
    L69:
        r45 = false;
    L85:
        r50 = false;
    L131:
        if (this.f10660a == false) goto L139;
        String r51 = this.f10667h;
        if (TextUtils.isEmpty(r51) == false) goto L135;
    L138:
        this.f10667h = r51;
        goto L139
    L135:
        if (r51.startsWith(LocationInfoConst.HTTPS) == true) goto L138;
        Uri.Builder r52 = Uri.parse(r51).buildUpon();     // Catch: Throwable -> L277
        r52.scheme(LocationInfoConst.HTTPS);     // Catch: Throwable -> L277
        r51 = r52.build().toString();     // Catch: Throwable -> L277
    L139:
        Objects.toString(r15.f10806j);
        URL r53 = new URL(this.f10667h);
        Proxy r54 = this.f10662c;
        if (r54 == null) goto L142;
        URLConnection r55 = r53.openConnection(r54);
    L143:
        c r56 = null;
        if (this.f10660a == true) goto L286;
        HttpURLConnection r57 = (HttpURLConnection) r55;
    L206:
        if (Build.VERSION.SDK == null) goto L208;
        r57.setRequestProperty("Connection", "close");
    L208:
        int r110 = (int) (((long) r15.f10800d) - (this.f10672m.f10703c.f10689q / 1000));
        Iterator<String> r58 = r12.keySet().iterator();     // Catch: Throwable -> L271
    L211:
        if (r58.hasNext() == false) goto L214;
        String r59 = r58.next();     // Catch: Throwable -> L271
        r57.addRequestProperty(r59, r12.get(r59));     // Catch: Throwable -> L271
        goto L211
    L214:
        if (this.f10667h.contains("/v3/iasdkauth") == false) goto L216;
    L243:
        r57.addRequestProperty("csid", this.f10663d);     // Catch: Throwable -> L271
        if (h(this.f10672m.f10703c.f10687o) == false) goto L273;
        f r60 = this.f10672m;     // Catch: Throwable -> L271
        if (TextUtils.isEmpty(r60.f10703c.f10685m) == false) goto L248;
        String r61 = "";
    L250:
        if (TextUtils.isEmpty(r61) == true) goto L253;
        r57.addRequestProperty("sip", r61);     // Catch: Throwable -> L271
    L253:
        if (i4.f10562v == false) goto L267;
        LinkedList r62 = i4.A;     // Catch: Throwable -> L271
        monitor-enter(r62);     // Catch: Throwable -> L271
        c r63 = (c) r62.poll();     // Catch: Throwable -> L264
        if (r63 == null) goto L260;
        monitor-exit(r62);     // Catch: Throwable -> L264
        r56 = r63;
    L261:
        if (r56 == null) goto L267;
        r57.addRequestProperty("nls", r56.b());     // Catch: Throwable -> L271
        this.f10672m.f10705e = r56;     // Catch: Throwable -> L271
        goto L267
    L260:
        monitor-exit(r62);     // Catch: Throwable -> L264
    L264:
        th = move-exception;
        throw th;     // Catch: Throwable -> L271
    L267:
        a r64 = i4.y();     // Catch: Throwable -> L271
        if (r64 == null) goto L273;
        r57.addRequestProperty("nlf", r64.b());     // Catch: Throwable -> L271
        this.f10672m.f10704d = r64;     // Catch: Throwable -> L271
        goto L273
    L248:
        String r65 = l4.d(defpackage.c.l(r60.f10703c.f10685m.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));     // Catch: Throwable -> L271
        String r66 = r60.f10703c.f10685m;     // Catch: Throwable -> L271
        r61 = r65;
    L273:
        r57.setConnectTimeout(r110);
        r57.setReadTimeout(r110);
        r57.setRequestMethod(HttpMethodContrants.POST);
        r57.setUseCaches(false);
        r57.setDoInput(true);
        r57.setDoOutput(true);
        return new b(r57);
    L216:
        if (TextUtils.isEmpty(this.f10665f) == true) goto L243;
        if (i4.v(this.f10665f) == false) goto L243;
        this.f10669j = true;     // Catch: Throwable -> L271
        i4.h r67 = i4.z(this.f10665f);     // Catch: Throwable -> L271
        r57.addRequestProperty("lct", String.valueOf(r67.f10592a));     // Catch: Throwable -> L271
        r57.addRequestProperty("lct-info", r67.f10593b);     // Catch: Throwable -> L271
        String r68 = this.f10665f;     // Catch: Throwable -> L271
        if (i4.f10552l.containsKey(r68) == false) goto L224;
        i4.e r69 = i4.f10552l.get(r68);     // Catch: Throwable -> L271
        if (r69 == null) goto L224;
        String r70 = r69.f10581b;     // Catch: Throwable -> L271
    L226:
        if (TextUtils.isEmpty(r70) == true) goto L228;
        r70 = r70 + ";15K;16H;17I;1A4;17S;183";     // Catch: Throwable -> L271
    L228:
        r57.addRequestProperty("aks", r70);     // Catch: Throwable -> L271
        String r71 = "";
        i4.e r72 = i4.f10552l.get(this.f10665f);     // Catch: Throwable -> L271
        if (r72 == null) goto L231;
        s4 r73 = r72.f10580a;     // Catch: Throwable -> L271
    L232:
        if (r73 == null) goto L238;
        i4.e r74 = i4.f10552l.get(this.f10665f);     // Catch: Throwable -> L271
        if (r74 == null) goto L236;
        s4 r75 = r74.f10580a;     // Catch: Throwable -> L271
    L237:
        r71 = r75.f11096f;     // Catch: Throwable -> L271
        goto L238
    L236:
        r75 = null;
    L238:
        String r76 = this.f10665f;     // Catch: Throwable -> L271
        String r77 = Build.MANUFACTURER;     // Catch: Throwable -> L271
        Context r78 = i4.f10543c;     // Catch: Throwable -> L271
        if (r78 == null) goto L241;
        String r79 = t4.b(r78);     // Catch: Throwable -> L271
    L242:
        r57.addRequestProperty("lct-args", String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", new Object[]{r71, r76, r77, r79}));     // Catch: Throwable -> L271
        goto L243
    L241:
        r79 = "";
        goto L242
    L231:
        r73 = null;
    L224:
        r70 = null;
    L271:
        th = move-exception;
        l.a("ht", "adh", th);
        goto L273
    L286:
        SoftReference<SSLContext> r80 = f10658n;     // Catch: Throwable -> L278
        if (r80 != null) goto L148;
    L149:
        f10658n = new SoftReference(SSLContext.getInstance("TLS"));     // Catch: Throwable -> L278
    L150:
        SoftReference<SSLContext> r81 = f10658n;     // Catch: Throwable -> L278
        if (r81 == null) goto L154;
        SSLContext r82 = r81.get();     // Catch: Throwable -> L278
    L155:
        if (r82 == null) goto L284;
    L157:
        r82.init(null, null, null);     // Catch: Throwable -> L159
        this.f10661b = r82;     // Catch: Throwable -> L159
    L161:
        HttpsURLConnection r83 = (HttpsURLConnection) r55;
        if (i4.g.f10586a == true) goto L288;
    L202:
        r83.setSSLSocketFactory(this.f10661b.getSocketFactory());
    L203:
        r83.setHostnameVerifier(r16);
        r57 = r83;
        goto L206
    L288:
        SoftReference<l0> r84 = f10659o;     // Catch: Throwable -> L175
        if (r84 != null) goto L166;
    L167:
        f10659o = new SoftReference(new l0(i4.f10543c, this.f10661b));     // Catch: Throwable -> L175
    L169:
        if (f10658n == null) goto L171;
        l0 r85 = f10659o.get();     // Catch: Throwable -> L175
    L172:
        if (r85 != null) goto L177;
        r85 = new l0(i4.f10543c, this.f10661b);     // Catch: Throwable -> L175
    L177:
        if (r85 == null) goto L202;
        r83.setSSLSocketFactory(r85);
        int r86 = Build.VERSION.SDK_INT;
        if (i4.g.f10588c == false) goto L203;
        Context r87 = r85.f10782b;
        if (r87 == null) goto L203;
        if (r85.f10783c == null) goto L203;
        int r88 = i4.g.f10589d;
        if (r88 <= 17) goto L190;
        if (r86 > r88) goto L203;
    L190:
        SSLSessionCache r89 = new SSLSessionCache(r87);
        SSLContext r90 = r85.f10783c;
        if (r90 == null) goto L203;
        SSLSessionContext r91 = r90.getClientSessionContext();     // Catch: Throwable -> L200
        Field r92 = r89.getClass().getDeclaredField(t4.n("UbVNlc3Npb25DYWNoZQ"));     // Catch: Throwable -> L200
        r92.setAccessible(true);     // Catch: Throwable -> L200
        Object r93 = r92.get(r89);     // Catch: Throwable -> L200
        Method[] r94 = r91.getClass().getMethods();     // Catch: Throwable -> L200
        String r95 = t4.n("Yc2V0UGVyc2lzdGVudENhY2hl");     // Catch: Throwable -> L200
        int r111 = r94.length;     // Catch: Throwable -> L200
        int r112 = 0;
    L194:
        if (r112 >= r111) goto L203;
        Method r113 = r94[r112];     // Catch: Throwable -> L200
        if (r113.getName().equals(r95) == true) goto L197;
        r112 = r112 + 1;
        goto L194
    L197:
        r113.invoke(r91, new Object[]{r93});     // Catch: Throwable -> L200
    L200:
        th = move-exception;
        q.f("myssl", "isc2", th);
        goto L203
    L171:
        r85 = null;
        goto L172
    L166:
        if (r84.get() != null) goto L169;
    L175:
        th = move-exception;
        q.f("ht", "gsf", th);
        r85 = null;
    L159:
        th = move-exception;
        l.a("ht", "ne", th);
        goto L161
    L284:
        r82 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L159
        goto L157
    L148:
        if (r80.get() != null) goto L150;
    L154:
        r82 = null;
        goto L155
    L142:
        r55 = r53.openConnection();
        goto L143
    L43:
        if (r27.contains("apilocate") == true) goto L46;
        r28 = false;
        goto L47
    L34:
        if (r25 == 5) goto L37;
        r26 = false;
        goto L38
    L8:
        int r96 = 0;
    L10:
        if (r96 >= r13.f10697a.size()) goto L17;
        e r97 = r13.f10697a.get(r96);
        if (r97 == null) goto L16;
        if (r97.f10700b.equals(r14) == false) goto L16;
        r16 = r97;
    L16:
        r96 = r96 + 1;
        goto L10
    L17:
        e r98 = new e();
        r98.f10700b = r14;
        r13.f10697a.add(r98);
        r16 = r98;
        goto L18
    }
}
