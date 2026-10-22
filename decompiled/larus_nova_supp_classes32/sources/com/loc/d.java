package com.loc;

import android.content.Context;
import android.net.SSLSessionCache;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.lang.ref.SoftReference;
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
import java.util.Queue;
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
import n4a.e5;
import n4a.f5;
import n4a.g0;
import n4a.j0;
import n4a.k0;
import n4a.l0;
import n4a.m0;
import n4a.n;
import n4a.r;
import n4a.r0;
import n4a.s0;
import n4a.y;
import n4a.y4;
import n4a.z4;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public static SoftReference<SSLContext> n;
    public static SoftReference<com.loc.e> o;
    public boolean a;
    public SSLContext b;
    public Proxy c;
    public final String d;
    public C0030d e;
    public String f;
    public boolean g;
    public String h;
    public String i;
    public boolean j;
    public boolean k;
    public String l;
    public final f m;

    public static class a implements Cloneable, Comparable {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final int f;
        public final int g;
        public long h;
        public volatile AtomicInteger i;

        public a(c r3) {
            this.a = r3.c;
            this.b = r3.e;
            this.d = r3.d;
            this.e = r3.m;
            this.f = r3.n;
            this.g = r3.b.a();
            this.c = r3.a;
            this.h = r3.f;
            this.i = new AtomicInteger(1);
        }

        public final a a() {
            return (a) super.clone();
        L4:
            return null;
        }

        public final String b() {
            String r1 = this.e + "#";     // Catch: Exception -> L26
            if (TextUtils.isEmpty(this.d) == true) goto L8;
            StringBuilder r2 = new StringBuilder();     // Catch: Exception -> L26
            r2.append(r1);     // Catch: Exception -> L26
            r2.append(this.d);     // Catch: Exception -> L26
            r2.append("#");     // Catch: Exception -> L26
        L9:
            String r3 = (r2.toString() + this.g + "#") + this.i + "#";     // Catch: Exception -> L26
            if (TextUtils.isEmpty(this.a) == true) goto L13;
            StringBuilder r4 = new StringBuilder();     // Catch: Exception -> L26
            r4.append(r3);     // Catch: Exception -> L26
            r4.append(this.a);     // Catch: Exception -> L26
            r4.append("#");     // Catch: Exception -> L26
        L12:
            String r5 = r4.toString();     // Catch: Exception -> L26
            if (this.e != 1) goto L18;
            StringBuilder r6 = new StringBuilder();     // Catch: Exception -> L26
            r6.append(r5);     // Catch: Exception -> L26
            r6.append(this.c);     // Catch: Exception -> L26
            r6.append("#");     // Catch: Exception -> L26
        L17:
            String r7 = r6.toString();     // Catch: Exception -> L26
            if (this.e != 1) goto L23;
            StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L26
            r8.append(r7);     // Catch: Exception -> L26
            r8.append(this.h);     // Catch: Exception -> L26
            r8.append("#");     // Catch: Exception -> L26
        L24:
            return y4.d(g0.a(((r8.toString() + this.b + "#") + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
        L23:
            r8 = new StringBuilder();     // Catch: Exception -> L26
            r8.append(r7);     // Catch: Exception -> L26
            r8.append("-#");     // Catch: Exception -> L26
            goto L24
        L18:
            r6 = new StringBuilder();     // Catch: Exception -> L26
            r6.append(r5);     // Catch: Exception -> L26
            r6.append("-#");     // Catch: Exception -> L26
            goto L17
        L13:
            r4 = new StringBuilder();     // Catch: Exception -> L26
            r4.append(r3);     // Catch: Exception -> L26
            r4.append("-#");     // Catch: Exception -> L26
            goto L12
        L8:
            r2 = new StringBuilder();     // Catch: Exception -> L26
            r2.append(r1);     // Catch: Exception -> L26
            r2.append("-#");     // Catch: Exception -> L26
        L26:
            return null;
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return a();
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object r1) {
            ((a) r1).getClass();
            return 0;
        }
    }

    public static class b {
        public final HttpURLConnection a;

        public b(HttpURLConnection r1) {
            this.a = r1;
        }
    }

    public static class c implements Cloneable {
        public String a;
        public bo.b b;
        public String c;
        public String d;
        public String e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j;
        public String k;
        public String l;
        public int m;
        public int n;

        public c() {
            this.a = NameKeys.UnloadStrategy_No_Strategy;
            this.b = bo.b.a;
            this.c = NameKeys.UnloadStrategy_No_Strategy;
            this.d = NameKeys.UnloadStrategy_No_Strategy;
            this.e = NameKeys.UnloadStrategy_No_Strategy;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 0;
            this.k = "-";
            this.l = "-";
            this.m = 0;
            this.n = 0;
        }

        public final c a() {
            return (c) super.clone();
        L4:
            return null;
        }

        public final String b() {
            if (TextUtils.isEmpty(this.c) == true) goto L5;
            String r0 = this.c + "#";
        L7:
            if (TextUtils.isEmpty(this.d) == true) goto L9;
            String r1 = r0 + this.d + "#";
        L11:
            return y4.d(g0.a(((((r1 + this.b.a() + "#") + this.h + "#") + this.j + "#") + this.f).getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
        L9:
            r1 = r0 + "-#";
            goto L11
        L5:
            r0 = "-#";
            goto L7
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            return a();
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.a + "', degradeType=" + this.b + ", serverIp='" + this.c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    /* JADX INFO: renamed from: com.loc.d$d, reason: collision with other inner class name */
    public static class C0030d {
        public final Vector<e> a;
        public volatile e b;

        public C0030d() {
            this.a = new Vector();
            this.b = new e();
        }
    }

    public static class e implements HostnameVerifier {
        public String a;
        public String b;

        public e() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String r3, SSLSession r4) {
            HostnameVerifier r0 = HttpsURLConnection.getDefaultHostnameVerifier();
            if (TextUtils.isEmpty(this.a) == true) goto L7;
            return this.a.equals(r3);
        L7:
            if (TextUtils.isEmpty(this.b) == true) goto L11;
            return r0.verify(this.b, r4);
        L11:
            return r0.verify(r3, r4);
        }
    }

    public class f {
        public long a;
        public long b;
        public final c c;
        public a d;
        public c e;
        public String f;
        public URL g;
        public final /* synthetic */ d h;

        public f(d r3) {
            this.h = r3;
            this.a = 0;
            this.b = 0;
            this.c = new c();
        }

        public final void b(long r3) {
            DecimalFormat r0 = new DecimalFormat("0.00");
            this.c.l = r0.format(r3 / 1024.0f);
        }

        public final void d() {
            c r0 = this.c;
            r0.h = SystemClock.elapsedRealtime() - this.b;
        }

        public final void e() {
            c r0 = this.c;
            r0.j = SystemClock.elapsedRealtime() - this.b;
        }

        public final void f() {
            c r0 = this.c.a();
            if (this.c.f <= i.o) goto L5;
            r0.m = 1;
        L5:
            if (r0 != null) goto L7;
            return;
        L7:
            if (i.c == null) goto L18;
            HashMap r1 = new HashMap();
            r1.put("serverip", r0.c);
            r1.put("hostname", r0.e);
            r1.put(SVGRenderEngine.PATH, r0.d);
            r1.put("csid", r0.a);
            r1.put("degrade", String.valueOf(r0.b.a()));
            r1.put("errorcode", String.valueOf(r0.m));
            r1.put("errorsubcode", String.valueOf(r0.n));
            r1.put("connecttime", String.valueOf(r0.h));
            r1.put("writetime", String.valueOf(r0.i));
            r1.put("readtime", String.valueOf(r0.j));
            r1.put("datasize", String.valueOf(r0.l));
            r1.put("totaltime", String.valueOf(r0.f));
            String r2 = new JSONObject(r1).toString();
            "--埋点--".concat(String.valueOf(r2));
            if (TextUtils.isEmpty(r2) == true) goto L19;
            r0 r3 = new r0(i.c, "core", "2.0", "O008");     // Catch: l -> L14
            r3.a(r2);     // Catch: l -> L14
            s0.c(r3, i.c);     // Catch: l -> L14
            return;
        L20:
            return;
        L19:
            return;
        }

        public final void a(int r6) {
            "----errorcode-----".concat(String.valueOf(r6));
            c r0 = this.c;     // Catch: Throwable -> L35
            r0.f = SystemClock.elapsedRealtime() - this.a;     // Catch: Throwable -> L35
            c r1 = this.c;     // Catch: Throwable -> L35
            r1.m = r6;     // Catch: Throwable -> L35
            if (r1.b.e() == false) goto L6;
            i.l(false, this.c.e);     // Catch: Throwable -> L35
        L6:
            boolean r7 = this.h.h(this.c.e);     // Catch: Throwable -> L35
            if (r7 == false) goto L33;
            d r2 = this.h;     // Catch: Throwable -> L35
            if (r2.k == false) goto L16;
            if (TextUtils.isEmpty(r2.i) == true) goto L16;
            if (this.c.b.b() == false) goto L16;
            i.v();     // Catch: Throwable -> L35
        L16:
            if (this.c.b.c() == false) goto L18;
            i.l(this.c.b.c(), this.c.e);     // Catch: Throwable -> L35
        L18:
            c r3 = this.e;     // Catch: Throwable -> L35
            if (r3 != null) goto L22;
            int r4 = i.a;     // Catch: Throwable -> L35
        L28:
            i.k(false, this.d);     // Catch: Throwable -> L35
            i.q(this.c);     // Catch: Throwable -> L35
            goto L33
        L22:
            if (i.v == false) goto L28;
            Queue<c> r5 = i.A;     // Catch: Throwable -> L35
            monitor-enter(r5);     // Catch: Throwable -> L35
            ((LinkedList) r5).offer(r3);     // Catch: Throwable -> L30
            monitor-exit(r5);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;     // Catch: Throwable -> L35
        L33:
            i.i(this.g.toString(), this.c.b.c(), true, r7);     // Catch: Throwable -> L35
            this.c.toString();     // Catch: Throwable -> L35
            return;
        }

        public final void c(l0 r9) {
            this.c.f = SystemClock.elapsedRealtime() - this.a;     // Catch: Throwable -> L33
            r9.e = this.c.b.c();     // Catch: Throwable -> L33
            if (this.c.b.b() == false) goto L8;
            c r10 = this.c;     // Catch: Throwable -> L33
            if (r10.f <= AutoEndConversationTime.AFTER_10_SECONDS) goto L8;
            i.l(false, r10.e);     // Catch: Throwable -> L33
        L8:
            if (this.c.b.d() == false) goto L10;
            i.l(false, this.f);     // Catch: Throwable -> L33
        L10:
            boolean r11 = this.h.h(this.c.e);     // Catch: Throwable -> L33
            if (r11 == false) goto L31;
            c r1 = this.c;     // Catch: Throwable -> L33
            if (r1 != null) goto L16;
            int r2 = i.a;     // Catch: Throwable -> L33
        L22:
            i.k(true, this.d);     // Catch: Throwable -> L33
            c r3 = this.c;     // Catch: Throwable -> L33
            if (r3.f <= i.o) goto L31;
            c r4 = r3.a();     // Catch: Throwable -> L33
            if (r4 == null) goto L31;
            r4.m = 1;     // Catch: Throwable -> L33
            i.q(r4);     // Catch: Throwable -> L33
            r4.toString();     // Catch: Throwable -> L33
            goto L31
        L16:
            if (i.v == false) goto L22;
            Queue<c> r5 = i.A;     // Catch: Throwable -> L33
            monitor-enter(r5);     // Catch: Throwable -> L33
            ((LinkedList) r5).offer(r1);     // Catch: Throwable -> L28
            monitor-exit(r5);     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L33
        L31:
            i.i(this.g.toString(), this.c.b.c(), false, r11);     // Catch: Throwable -> L33
            this.c.toString();     // Catch: Throwable -> L33
            return;
        }
    }

    public d() {
        this.f = NameKeys.UnloadStrategy_No_Strategy;
        this.j = false;
        this.k = false;
        this.l = NameKeys.UnloadStrategy_No_Strategy;
        this.m = new f(this);
        i.x();
        this.d = UUID.randomUUID().toString().replaceAll("-", NameKeys.UnloadStrategy_No_Strategy).toLowerCase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        n.a(th, "ht", "ic");
    }

    public static int a(Exception r1) {
        if ((r1 instanceof SSLHandshakeException) == false) goto L7;
        return 4101;
    L7:
        if ((r1 instanceof SSLKeyException) == false) goto L11;
        return 4102;
    L11:
        if ((r1 instanceof SSLProtocolException) == false) goto L15;
        return 4103;
    L15:
        if ((r1 instanceof SSLPeerUnverifiedException) == false) goto L19;
        return 4104;
    L19:
        if ((r1 instanceof ConnectException) == false) goto L23;
        return 6101;
    L23:
        if ((r1 instanceof SocketException) == false) goto L27;
        return 6102;
    L27:
        if ((r1 instanceof ConnectTimeoutException) == false) goto L31;
        return 2101;
    L31:
        if ((r1 instanceof SocketTimeoutException) == false) goto L34;
        return 2102;
    L34:
        return 0;
    }

    public static String b(Map<String, String> r4) {
        if (r4 == null) goto L15;
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L5:
        if (r5.hasNext() == false) goto L14;
        Map.Entry<String, String> r1 = r5.next();
        String r2 = r1.getKey();
        String r3 = r1.getValue();
        if (r3 != null) goto L10;
        r3 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        if (r0.length() <= 0) goto L12;
        r0.append("&");
    L12:
        r0.append(URLEncoder.encode(r2));
        r0.append("=");
        r0.append(URLEncoder.encode(r3));
        goto L5
    L14:
        return r0.toString();
    L15:
        return null;
    }

    public static String f(Map<String, List<String>> r3) {
        List<String> r4 = r3.get("sc");     // Catch: Throwable -> L18
        if (r4 == null) goto L16;
        if (r4.size() <= 0) goto L16;
        String r5 = (String) ListProtector.get(r4, 0);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r5) == true) goto L16;
        if (r5.contains("#") == false) goto L21;
        String[] r6 = r5.split("#");     // Catch: Throwable -> L18
        if (r6.length <= 1) goto L16;
        return r6[0];
    L21:
        return r5;
    L16:
        return NameKeys.UnloadStrategy_No_Strategy;
    }

    public final boolean e(Map<String, List<String>> r7, boolean r8) {
        List<String> r3 = r7.get("sc");     // Catch: Throwable -> L31
        if (r3 != null) goto L6;
    L17:
        boolean r0 = false;
    L18:
        if (r0 == true) goto L20;
        return false;
    L20:
        if (r8 == true) goto L22;
        return true;
    L22:
        if (r7.containsKey("lct") == false) goto L34;
        List<String> r9 = r7.get("lct");     // Catch: Throwable -> L31
        if (r9 != null) goto L26;
        return false;
    L26:
        if (r9.size() <= 0) goto L36;
        long r10 = i.a(r9);     // Catch: Throwable -> L31
        return i.n(this.f, r10);
    L36:
        return false;
    L34:
        return false;
    L6:
        if (r3.size() <= 0) goto L17;
        String r4 = (String) ListProtector.get(r3, 0);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r4) == true) goto L17;
        if (r4.contains("#") == false) goto L16;
        String[] r1 = r4.split("#");     // Catch: Throwable -> L31
        if (r1.length <= 1) goto L17;
        if ("1".equals(r1[1]) == false) goto L17;
    L16:
        r0 = true;
    L38:
        return false;
    }

    public final l0 c(b r12) throws l, IOException {
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        ByteArrayOutputStream r1 = null;
        InputStream r2 = null;
        r2 = null;
        InputStream r3 = null;
        r2 = null;
        r3 = null;
        r3 = null;
        r1 = null;
        ConcurrentHashMap<String, k0.c> r4 = k0.a;     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        Context r5 = i.c;     // Catch: Throwable -> L175
        if (r5 == null) goto L8;
        s0.b(k0.l(), r5);     // Catch: Throwable -> L175
    L8:
        HttpURLConnection r13 = r12.a;     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        Map<String, List<String>> r6 = r13.getHeaderFields();     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        int r7 = r13.getResponseCode();     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        if (r6 == null) goto L58;
        List<String> r8 = r6.get("gsid");     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        if (r8 != null) goto L13;
    L15:
        this.m.c.k = f(r6);     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        if (TextUtils.isEmpty(this.f) == true) goto L58;
        if (this.j == true) goto L21;
        boolean r9 = e(r6, true);     // Catch: Throwable -> L56
        char r10 = 2;
    L37:
        if (r9 == true) goto L39;
        if (r10 != 1) goto L58;
        k0.g(false, this.f);     // Catch: Throwable -> L56
        goto L58
    L39:
        if (this.f.equals("loc") == false) goto L48;
        String r11 = this.l;     // Catch: Throwable -> L56
        if (TextUtils.isEmpty(r11) == false) goto L43;
        r11 = r13.getURL().getHost();     // Catch: Throwable -> L56
    L43:
        String r14 = this.f;     // Catch: Throwable -> L56
        if (r10 != 2) goto L46;
        boolean r15 = true;
    L47:
        i.h(r14, r15, r11, r11, this.i);     // Catch: Throwable -> L56
        goto L58
    L46:
        r15 = false;
        goto L47
    L48:
        String r16 = this.f;     // Catch: Throwable -> L56
        if (r10 != 2) goto L51;
        boolean r17 = true;
    L52:
        i.r(r16, r17);     // Catch: Throwable -> L56
        goto L58
    L51:
        r17 = false;
        goto L52
    L21:
        if (r6.containsKey("sc") == false) goto L23;
        r9 = e(r6, false);     // Catch: Throwable -> L56
        r10 = 1;
        goto L37
    L23:
        String r18 = this.f;     // Catch: Throwable -> L56
        int r19 = i.a;     // Catch: Throwable -> L56
        monitor-enter(i.class);     // Catch: Throwable -> L56
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L56
    L26:
        if (i.k != null) goto L29;
    L31:
        monitor-exit(i.class);     // Catch: Throwable -> L56
        r9 = false;
        r10 = 0;
        goto L37
    L29:
        if (i.k.containsKey(r18) == false) goto L31;
        i.k.remove(r18);     // Catch: Throwable -> L33
        goto L58
    L13:
        if (r8.size() <= 0) goto L15;
        r0 = r8.get(0);     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
    L58:
        if (r7 != 200) goto L124;
        ByteArrayOutputStream r20 = new ByteArrayOutputStream();     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        this.m.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L115 IOException -> L117 SocketTimeoutException -> L120 ConnectTimeoutException -> L122
        InputStream r21 = r13.getInputStream();     // Catch: Throwable -> L115 IOException -> L117 SocketTimeoutException -> L120 ConnectTimeoutException -> L122
        PushbackInputStream r22 = new PushbackInputStream(r21, 2);     // Catch: Throwable -> L107 IOException -> L109 SocketTimeoutException -> L111 ConnectTimeoutException -> L113
        byte[] r23 = new byte[2];     // Catch: IOException -> L101 SocketTimeoutException -> L103 ConnectTimeoutException -> L105 Throwable -> L152
        r22.read(r23);     // Catch: IOException -> L101 SocketTimeoutException -> L103 ConnectTimeoutException -> L105 Throwable -> L152
        r22.unread(r23);     // Catch: IOException -> L101 SocketTimeoutException -> L103 ConnectTimeoutException -> L105 Throwable -> L152
        if (r23[0] == 31) goto L65;
    L68:
        InputStream r24 = r22;
    L201:
        byte[] r25 = new byte[1024];     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
    L71:
        int r26 = r24.read(r25);     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        if (r26 == (-1)) goto L74;
        r20.write(r25, 0, r26);     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        goto L71
    L74:
        this.m.e();     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        r.g();     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        l0 r27 = new l0();     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        r27.a = r20.toByteArray();     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        r27.b = r6;     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        r27.c = this.d;     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        r27.d = r0;     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        k0.d(r13.getURL(), r27);     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        this.m.b(r27.a.length);     // Catch: Throwable -> L93 IOException -> L95 SocketTimeoutException -> L97 ConnectTimeoutException -> L99
        r20.close();     // Catch: Throwable -> L77
    L79:
        if (r21 == null) goto L188;
        r21.close();     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        n.a(th, "ht", "par");
    L188:
        r22.close();     // Catch: Throwable -> L86
    L194:
        r24.close();     // Catch: Throwable -> L90
    L92:
        return r27;
    L90:
        th = move-exception;
        n.a(th, "ht", "par");
    L86:
        th = move-exception;
        n.a(th, "ht", "par");
    L77:
        th = move-exception;
        n.a(th, "ht", "par");
        goto L79
    L97:
        e = move-exception;
        throw e;     // Catch: Throwable -> L152
    L99:
        e = move-exception;
        throw e;     // Catch: Throwable -> L152
    L95:
        e = e;
        r2 = r24;
    L119:
        InputStream r28 = r2;
        r1 = r20;
    L198:
    L143:
        th = th;
    L154:
        if (r1 != null) goto L177;
    L159:
        if (r21 != null) goto L184;
    L164:
        if (r22 != null) goto L190;
    L169:
        if (r28 == null) goto L216;
        r28.close();     // Catch: Throwable -> L172
        throw th;
    L172:
        th = move-exception;
        n.a(th, "ht", "par");
        throw th;
    L216:
        throw th;
    L190:
        r22.close();     // Catch: Throwable -> L167
    L167:
        th = move-exception;
        n.a(th, "ht", "par");
        goto L169
    L184:
        r21.close();     // Catch: Throwable -> L162
    L162:
        th = move-exception;
        n.a(th, "ht", "par");
        goto L164
    L177:
        r1.close();     // Catch: Throwable -> L157
    L157:
        th = move-exception;
        n.a(th, "ht", "par");
        goto L159
    L135:
        if ((e instanceof InterruptedIOException) == false) goto L142;
        l r29 = new l("IO 操作异常 - IOException", r0, this.d);     // Catch: Throwable -> L143
        if (TextUtils.isEmpty(e.getMessage()) == false) goto L139;
        throw r29;     // Catch: Throwable -> L143
    L139:
        if (e.getMessage().equals("thread interrupted") == false) goto L209;
        r29.j();     // Catch: Throwable -> L143
        throw r29;     // Catch: Throwable -> L143
    L209:
        throw r29;     // Catch: Throwable -> L143
    L142:
        throw e;     // Catch: Throwable -> L143
    L93:
        th = th;
        r3 = r24;
    L153:
        r28 = r3;
        r1 = r20;
        goto L154
    L65:
        if (r23[1] != (-117)) goto L68;
        r24 = new GZIPInputStream(r22);     // Catch: IOException -> L101 SocketTimeoutException -> L103 ConnectTimeoutException -> L105 Throwable -> L152
    L103:
        e = move-exception;
        throw e;     // Catch: Throwable -> L152
    L105:
        e = move-exception;
        throw e;     // Catch: Throwable -> L152
    L101:
        e = e;
        goto L119
    L111:
        e = move-exception;
        throw e;     // Catch: Throwable -> L152
    L113:
        e = move-exception;
        throw e;     // Catch: Throwable -> L152
    L109:
        e = e;
        r22 = null;
    L107:
        th = th;
        r22 = null;
        goto L153
    L120:
        e = e;
        Object[] r30 = null;
    L147:
        throw e;     // Catch: Throwable -> L152
    L122:
        e = e;
        Object[] r31 = null;
    L151:
        throw e;     // Catch: Throwable -> L152
    L117:
        e = e;
        r21 = null;
        r22 = null;
    L115:
        th = th;
        r21 = null;
        r22 = null;
        goto L153
    L124:
        l r32 = new l("网络异常原因：" + r13.getResponseMessage() + " 网络异常状态码：" + r7 + "  " + r0 + " " + this.d, r0, this.d);     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        r32.a(r13.getResponseMessage());     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        r32.a(r6);     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        f r110 = this.m;     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        r110.c.n = r7;     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        r110.a(10);     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        r32.h();     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
        throw r32;     // Catch: Throwable -> L126 IOException -> L128 SocketTimeoutException -> L130 ConnectTimeoutException -> L148
    L152:
        th = th;
    L130:
        e = e;
        r30 = null;
    L148:
        e = e;
        r31 = null;
    L128:
        e = e;
        r28 = null;
        r21 = null;
        r22 = null;
    L126:
        th = th;
        r28 = null;
        r21 = null;
        r22 = null;
        goto L154
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18 */
    public final l0 d(bo r15) throws l {
        ?? r7 = 0;
        r7 = 0;
        g(r15);     // Catch: Throwable -> L65 l -> L68 IOException -> L76 InterruptedIOException -> L111 SocketTimeoutException -> L83 SocketException -> L86 UnknownHostException -> L89 MalformedURLException -> L92 ConnectTimeoutException -> L95 ConnectException -> L98 SSLException -> L101
        l0 r8 = k0.m(this.h, this.f);     // Catch: Throwable -> L65 l -> L68 IOException -> L76 InterruptedIOException -> L111 SocketTimeoutException -> L83 SocketException -> L86 UnknownHostException -> L89 MalformedURLException -> L92 ConnectTimeoutException -> L95 ConnectException -> L98 SSLException -> L101
        if (r8 == null) goto L7;
        this.m.f();
        return r8;
    L7:
        b r9 = i(r15);     // Catch: Throwable -> L65 l -> L68 IOException -> L76 InterruptedIOException -> L111 SocketTimeoutException -> L83 SocketException -> L86 UnknownHostException -> L89 MalformedURLException -> L92 ConnectTimeoutException -> L95 ConnectException -> L98 SSLException -> L101
        HttpURLConnection r10 = r9.a;     // Catch: Throwable -> L65 l -> L68 IOException -> L76 InterruptedIOException -> L111 SocketTimeoutException -> L83 SocketException -> L86 UnknownHostException -> L89 MalformedURLException -> L92 ConnectTimeoutException -> L95 ConnectException -> L98 SSLException -> L101
        this.m.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r10.connect();     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        this.m.d();     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        byte[] r11 = r15.i();     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        if (r11 != null) goto L11;
    L12:
        String r16 = b(r15.h());     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        if (TextUtils.isEmpty(r16) == true) goto L15;
        r11 = f5.j(r16);     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L15:
        if (r11 != null) goto L17;
    L37:
        l0 r17 = c(r9);     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        this.m.c(r17);     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r10.disconnect();     // Catch: Throwable -> L40
    L42:
        this.m.f();
        return r17;
    L40:
        th = move-exception;
        n.a(th, "ht", "mPt");
        goto L42
    L17:
        if (r11.length <= 0) goto L37;
        this.m.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L29
        OutputStream r18 = r10.getOutputStream();     // Catch: Throwable -> L29
        DataOutputStream r12 = new DataOutputStream(r18);     // Catch: Throwable -> L27
        r12.write(r11);     // Catch: Throwable -> L25
        r12.close();     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        if (r18 == null) goto L24;
        r18.close();     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L24:
        f r19 = this.m;     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r19.c.i = SystemClock.elapsedRealtime() - r19.b;     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L25:
        th = move-exception;
        Throwable th = th;
        r7 = r12;
    L31:
        if (r7 == 0) goto L33;
        r7.close();     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L33:
        if (r18 == null) goto L35;
        r18.close();     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L35:
        f r110 = this.m;     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        r110.c.i = SystemClock.elapsedRealtime() - r110.b;     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
        throw th;     // Catch: Throwable -> L44 l -> L46 IOException -> L48 InterruptedIOException -> L50 SocketTimeoutException -> L51 SocketException -> L53 UnknownHostException -> L55 MalformedURLException -> L57 ConnectTimeoutException -> L59 ConnectException -> L61 SSLException -> L63
    L27:
        th = th;
    L29:
        th = move-exception;
        th = th;
        r18 = null;
        goto L31
    L11:
        if (r11.length != 0) goto L15;
    L46:
        e = e;
    L70:
        if (e.i() == false) goto L72;
    L74:
        n.a(e, "ht", "mPt");     // Catch: Throwable -> L81
        throw e;     // Catch: Throwable -> L81
    L72:
        if (e.g() == 10) goto L74;
        this.m.a(e.g());     // Catch: Throwable -> L81
    L59:
        e = e;
    L96:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.m.c.n = a(e);     // Catch: Throwable -> L81
        this.m.a(2);     // Catch: Throwable -> L81
        throw new l("IO 操作异常 - IOException");     // Catch: Throwable -> L81
    L61:
        e = e;
    L99:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.m.c.n = a(e);     // Catch: Throwable -> L81
        this.m.a(6);     // Catch: Throwable -> L81
        throw new l("http连接失败 - ConnectionException");     // Catch: Throwable -> L81
    L57:
        e = e;
    L93:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.m.a(8);     // Catch: Throwable -> L81
        throw new l("url异常 - MalformedURLException");     // Catch: Throwable -> L81
    L53:
        e = e;
    L87:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.m.c.n = a(e);     // Catch: Throwable -> L81
        this.m.a(6);     // Catch: Throwable -> L81
        throw new l("socket 连接异常 - SocketException");     // Catch: Throwable -> L81
    L51:
        e = e;
    L84:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.m.c.n = a(e);     // Catch: Throwable -> L81
        this.m.a(2);     // Catch: Throwable -> L81
        throw new l("socket 连接超时 - SocketTimeoutException");     // Catch: Throwable -> L81
    L55:
        e = e;
    L90:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.m.a(5);     // Catch: Throwable -> L81
        throw new l("未知主机 - UnKnowHostException");     // Catch: Throwable -> L81
    L63:
        e = e;
    L102:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.m.c.n = a(e);     // Catch: Throwable -> L81
        this.m.a(4);     // Catch: Throwable -> L81
        throw new l("IO 操作异常 - IOException");     // Catch: Throwable -> L81
    L48:
        e = e;
    L77:
        e.printStackTrace();     // Catch: Throwable -> L81
        this.m.a(7);     // Catch: Throwable -> L81
        throw new l("IO 操作异常 - IOException");     // Catch: Throwable -> L81
    L44:
        th = th;
    L66:
        n.a(th, "ht", "mPt");     // Catch: Throwable -> L81
        this.m.a(9);     // Catch: Throwable -> L81
        throw new l("未知的错误");     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        if (0 != 0) goto L112;
    L109:
        this.m.f();
        throw th;
    L112:
        r7.disconnect();     // Catch: Throwable -> L107
    L107:
        th = move-exception;
        n.a(th, "ht", "mPt");
    L68:
        e = e;
    L92:
        e = e;
    L83:
        e = e;
    L98:
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
    L65:
        th = th;
    L79:
        f r111 = this.m;     // Catch: Throwable -> L81
        r111.c.n = 7101;     // Catch: Throwable -> L81
        r111.a(7);     // Catch: Throwable -> L81
        throw new l("未知的错误");     // Catch: Throwable -> L81
    }

    public final void g(bo r7) throws l {
        this.e = new C0030d();
        this.k = r7.g;
        this.c = r7.b;
        this.g = r7.c;
        String r0 = "ht";
        String r1 = r7.k();     // Catch: Throwable -> L22
    L20:
        th = th;
    L24:
        n.a(th, r0, "pnfr");
    L25:
        String r2 = r1;
    L26:
        this.f = r2;
        z4 r3 = z4.a.a;
        if (r7.h == false) goto L29;
        r3.getClass();
    L33:
        boolean r4 = true;
    L34:
        this.a = r4;
        if (r7.j.b() == false) goto L37;
        String r5 = r7.d(r7.e());
    L38:
        this.h = r5;
        String r6 = this.f;
        ConcurrentHashMap<String, k0.c> r8 = k0.a;
        monitor-enter(k0.class);
        System.currentTimeMillis();     // Catch: Throwable -> L77 l -> L98
        if (TextUtils.isEmpty(r6) == false) goto L43;
    L79:
        monitor-exit(k0.class);
        this.h = r5;
        "restrictionURLTest: ".concat(String.valueOf(r5));
        if (m0.a().b(r5) == true) goto L96;
        this.i = r7.j();
        if ("loc".equals(this.f) == false) goto L120;
        String r9 = r7.d(r7.c());
        String r10 = r7.d(r7.e());
        if (TextUtils.isEmpty(r9) == true) goto L90;
        new URL(r9).getHost();     // Catch: Exception -> L88
    L90:
        if (TextUtils.isEmpty(r10) == true) goto L121;
        if (TextUtils.isEmpty(this.i) == true) goto L94;
        return;
    L94:
        new URL(r10).getHost();     // Catch: Exception -> L105
        return;
    L122:
        return;
    L121:
        return;
    L120:
        return;
    L96:
        "restriction hit: ".concat(String.valueOf(r5));
        throw new l("限制访问的接口");
    L43:
        if (TextUtils.isEmpty(r5) == true) goto L79;
        Context r11 = i.c;     // Catch: Throwable -> L77 l -> L98
    L59:
        th = move-exception;
        n.a(th, "hlUtil", "llhl");     // Catch: Throwable -> L77 l -> L98
    L62:
        if (k0.a == null) goto L79;
        if (k0.a.size() <= 0) goto L79;
        if (k0.a.containsKey(r6) == false) goto L79;
        k0.c r12 = k0.a.get(r6);     // Catch: Throwable -> L77 l -> L98
        if (r12 == null) goto L79;
        if (k0.i(r5, r12, r6) == true) goto L76;
        r5 = k0.k(r5, r12, r6);     // Catch: Throwable -> L77 l -> L98
        goto L79
    L76:
        throw new l("服务QPS超限");     // Catch: Throwable -> L77 l -> L98
    L47:
        if (k0.b != null) goto L49;
        k0.b = Collections.synchronizedList(new ArrayList(8));     // Catch: Throwable -> L59
    L49:
        if (r11 == null) goto L62;
        if (k0.b.contains(r6) == true) goto L62;
        k0.b.add(r6);     // Catch: Throwable -> L59
        String r13 = y.c(r11, "Yb3Blbl9odHRwX2NvbnRyb2w", r6);     // Catch: Throwable -> L59
        if (TextUtils.isEmpty(r13) == true) goto L62;
        k0.c(r6, new JSONObject(r13));     // Catch: Throwable -> L59
    L100:
        th = move-exception;
        throw th;     // Catch: Throwable -> L102
    L102:
        th = move-exception;
        throw th;
    L98:
        e = move-exception;
        throw e;     // Catch: Throwable -> L100
    L77:
        th = move-exception;
        n.a(th, "hlUtil", "pcr");     // Catch: Throwable -> L100
        goto L79
    L37:
        r5 = r7.d(r7.c());
        goto L38
    L29:
        if (r3.b() == true) goto L33;
        r4 = false;
        goto L34
    L5:
        if (TextUtils.isEmpty(r1) == false) goto L25;
        if (r7.c == false) goto L9;
        r2 = bo.f(((j0) r7).t());     // Catch: Throwable -> L20
        goto L26
    L9:
        Map<String, String> r14 = r7.a();     // Catch: Throwable -> L20
        if (r14 != null) goto L114;
    L18:
        r0 = null;
    L19:
        r1 = r0;
        goto L25
    L114:
    L16:
        th = move-exception;
        n.a(th, "ht", "pnfh");     // Catch: Throwable -> L20
        goto L18
    L13:
        if (r14.containsKey("platinfo") == false) goto L18;
        r0 = bo.f(r14.get("platinfo"));     // Catch: Throwable -> L16
    L22:
        th = th;
        r1 = NameKeys.UnloadStrategy_No_Strategy;
        goto L24
    }

    public final boolean h(String r5) {
        if (this.g == false) goto L5;
    L20:
        return true;
    L5:
        if (TextUtils.isEmpty(this.i) == true) goto L11;
        if (this.i.contains("rest") == true) goto L20;
        if (this.i.contains("apilocate") == true) goto L20;
    L11:
        if (r5.contains("rest") == false) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L20;
        return false;
    L13:
        if (r5.contains("apilocate") == true) goto L16;
        r6 = false;
        goto L17
    }

    public final b i(bo r15) throws IOException, l {
        f r0 = this.m;
        bo.b r1 = r15.j;
        c r2 = r0.c;
        r2.a = r0.h.d;
        r2.b = r1;
        r0.a = SystemClock.elapsedRealtime();
        Map<String, String> r3 = r15.a();
        if (r3 != null) goto L5;
        r3 = new HashMap();
    L5:
        C0030d r4 = this.e;
        String r5 = this.i;
        r4.getClass();
        if (TextUtils.isEmpty(r5) == false) goto L8;
        e r6 = r4.b;
    L18:
        int r7 = com.loc.c.a;
        String r8 = this.h;
        String r9 = NameKeys.UnloadStrategy_No_Strategy;
        Uri r10 = UriProtector.parse(r8);
        String r11 = r10.getHost();
        if (r7 == 1) goto L23;
        if (r7 != 2) goto L24;
        boolean r12 = false;
    L26:
        if (TextUtils.isEmpty(r9) == true) goto L43;
        r15.e = false;
        r8 = r10.buildUpon().encodedAuthority(r9).build().toString();
        if (r12 == false) goto L30;
        r3.put("targetHost", r11);
        this.l = r11;
    L30:
        if (r12 == false) goto L43;
        if (this.a == false) goto L43;
        if (TextUtils.isEmpty(r6.a) == false) goto L36;
    L42:
        r6.a = r9;
        goto L43
    L36:
        if (r9.contains(":") == false) goto L42;
        String[] r13 = r9.split(":");
        if (r13 == null) goto L42;
        if (r13.length <= 0) goto L42;
        r6.a = r13[0];
    L43:
        this.h = r8;
        URL r14 = new URL(this.h);
        f r16 = this.m;
        r16.g = r14;
        r16.c.d = r14.getPath();
        r16.c.e = r14.getHost();
        if (TextUtils.isEmpty(r16.h.i) == true) goto L49;
        if (r15.j.b() == false) goto L49;
        c r17 = r16.c;
        r17.c = r17.e.replace("[", NameKeys.UnloadStrategy_No_Strategy).replace("]", NameKeys.UnloadStrategy_No_Strategy);
        r16.c.e = r16.h.i;
    L49:
        if (r15.j.b() == false) goto L52;
        r15.f = r16.c.e;
    L52:
        if (r15.j.d() == false) goto L54;
        r16.f = r15.f;
    L54:
        String r18 = r14.getHost();
        if (r18.contains("rest") == false) goto L57;
    L60:
        boolean r19 = true;
    L61:
        if (r19 == false) goto L148;
        if (r15.g() == false) goto L148;
        bo.b r20 = r15.j;
        String r21 = this.m.c.e;
        if (h(r21) == true) goto L67;
    L103:
        boolean r22 = false;
    L104:
        if (r22 == false) goto L148;
        this.m.b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L146
        String r23 = NameKeys.UnloadStrategy_No_Strategy;
        InetAddress[] r24 = InetAddress.getAllByName(this.m.c.e);     // Catch: Throwable -> L146
        if (r24 != null) goto L108;
    L139:
        f r25 = this.m;     // Catch: Throwable -> L146
        "---onDNSEnd---ip=".concat(String.valueOf(r23));     // Catch: Throwable -> L146
        r25.c.c = r23.replace("[", NameKeys.UnloadStrategy_No_Strategy).replace("]", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L146
        r25.c.g = SystemClock.elapsedRealtime() - r25.b;     // Catch: Throwable -> L146
        if (TextUtils.isEmpty(r23) == true) goto L148;
        Uri r26 = UriProtector.parse(this.h);     // Catch: Throwable -> L146
        String r27 = r26.getHost();     // Catch: Throwable -> L146
        Uri r28 = r26.buildUpon().encodedAuthority(r23).build();     // Catch: Throwable -> L146
        this.i = r27;     // Catch: Throwable -> L146
        r3.put("host", r27);     // Catch: Throwable -> L146
        if (this.a == false) goto L144;
        r6.b = r27;     // Catch: Throwable -> L146
    L144:
        this.h = r28.toString();     // Catch: Throwable -> L146
        goto L148
    L108:
        if (r24.length <= 0) goto L139;
        if (r24[0] == null) goto L139;
        if (i.m() == true) goto L114;
    L116:
        boolean r29 = false;
    L117:
        "---canUseIpv6---".concat(String.valueOf(r29));     // Catch: Throwable -> L146
        if (r29 == false) goto L126;
        int r30 = 0;
    L121:
        if (r30 >= r24.length) goto L134;
        if ((r24[r30] instanceof Inet6Address) == true) goto L124;
        r30 = r30 + 1;     // Catch: Throwable -> L146
        goto L121
    L124:
        r23 = "[" + r24[r30].getHostAddress() + "]";     // Catch: Throwable -> L146
    L134:
        if (TextUtils.isEmpty(r23) == false) goto L139;
        InetAddress r31 = r24[0];     // Catch: Throwable -> L146
        String r32 = r31.getHostAddress();     // Catch: Throwable -> L146
        if ((r31 instanceof Inet6Address) == false) goto L138;
        r23 = "[" + r32 + "]";     // Catch: Throwable -> L146
        goto L139
    L138:
        r23 = r32;
        goto L139
    L126:
        int r33 = 0;
    L128:
        if (r33 >= r24.length) goto L134;
        InetAddress r34 = r24[r33];     // Catch: Throwable -> L146
        if ((r34 instanceof Inet4Address) == true) goto L131;
        r33 = r33 + 1;     // Catch: Throwable -> L146
        goto L128
    L131:
        r23 = r34.getHostAddress();     // Catch: Throwable -> L146
        goto L134
    L114:
        if (i.u() == false) goto L116;
        r29 = true;
        goto L117
    L67:
        if (r20.b() == false) goto L72;
        if (i.q == false) goto L72;
    L102:
        r22 = true;
    L72:
        if (r20.c() == false) goto L103;
        int r35 = i.a;
        if (TextUtils.isEmpty(r21) == true) goto L100;
        if (i.t == false) goto L100;
        if (i.x.get(r21) != null) goto L83;
        boolean r36 = true;
    L84:
        if (r36 == false) goto L100;
        Context r37 = i.c;     // Catch: Throwable -> L99
        if (r37 == null) goto L98;
        i.f r38 = i.b(r37, i.p(r21, "a15"));     // Catch: Throwable -> L99
        if (r38 == null) goto L98;
        AtomicInteger r39 = r38.c;     // Catch: Throwable -> L99
        if (r39 != null) goto L95;
        int r40 = 0;
    L96:
        if (r40 >= i.u) goto L100;
    L95:
        r40 = r39.get();     // Catch: Throwable -> L99
    L98:
        boolean r41 = true;
    L101:
        if (r41 == false) goto L103;
    L83:
        r36 = false;
    L100:
        r41 = false;
    L148:
        if (this.a == false) goto L156;
        String r42 = this.h;
        if (TextUtils.isEmpty(r42) == false) goto L152;
    L155:
        this.h = r42;
        goto L156
    L152:
        if (r42.startsWith("https") == true) goto L155;
        Uri.Builder r43 = UriProtector.parse(r42).buildUpon();     // Catch: Throwable -> L298
        r43.scheme("https");     // Catch: Throwable -> L298
        r42 = r43.build().toString();     // Catch: Throwable -> L298
    L156:
        Objects.toString(r15.j);
        URL r44 = new URL(this.h);
        Proxy r45 = this.c;
        if (r45 == null) goto L315;
        URLConnection r46 = r44.openConnection(r45);
    L168:
        c r47 = null;
        if (this.a == true) goto L306;
        HttpURLConnection r48 = (HttpURLConnection) r46;
    L227:
        if (Build.VERSION.SDK == null) goto L229;
        r48.setRequestProperty("Connection", "close");
    L229:
        int r110 = (int) (((long) r15.d) - (this.m.c.g / 1000));
        Iterator<String> r49 = r3.keySet().iterator();     // Catch: Throwable -> L292
    L232:
        if (r49.hasNext() == false) goto L235;
        String r50 = r49.next();     // Catch: Throwable -> L292
        r48.addRequestProperty(r50, r3.get(r50));     // Catch: Throwable -> L292
        goto L232
    L235:
        if (this.h.contains("/v3/iasdkauth") == false) goto L237;
    L264:
        r48.addRequestProperty("csid", this.d);     // Catch: Throwable -> L292
        if (h(this.m.c.e) == false) goto L294;
        f r51 = this.m;     // Catch: Throwable -> L292
        if (TextUtils.isEmpty(r51.c.c) == false) goto L269;
        String r52 = NameKeys.UnloadStrategy_No_Strategy;
    L271:
        if (TextUtils.isEmpty(r52) == true) goto L274;
        r48.addRequestProperty("sip", r52);     // Catch: Throwable -> L292
    L274:
        if (i.v == false) goto L288;
        Queue<c> r53 = i.A;     // Catch: Throwable -> L292
        monitor-enter(r53);     // Catch: Throwable -> L292
        c r54 = (c) ((LinkedList) r53).poll();     // Catch: Throwable -> L285
        if (r54 == null) goto L281;
        monitor-exit(r53);     // Catch: Throwable -> L285
        r47 = r54;
    L282:
        if (r47 == null) goto L288;
        r48.addRequestProperty("nls", r47.b());     // Catch: Throwable -> L292
        this.m.e = r47;     // Catch: Throwable -> L292
        goto L288
    L281:
        monitor-exit(r53);     // Catch: Throwable -> L285
    L285:
        th = move-exception;
        throw th;     // Catch: Throwable -> L292
    L288:
        a r55 = i.z();     // Catch: Throwable -> L292
        if (r55 == null) goto L294;
        r48.addRequestProperty("nlf", r55.b());     // Catch: Throwable -> L292
        this.m.d = r55;     // Catch: Throwable -> L292
        goto L294
    L269:
        String r56 = y4.d(g0.a(r51.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));     // Catch: Throwable -> L292
        String r57 = r51.c.c;     // Catch: Throwable -> L292
        r52 = r56;
    L294:
        r48.setConnectTimeout(r110);
        r48.setReadTimeout(r110);
        r48.setRequestMethod("POST");
        r48.setUseCaches(false);
        r48.setDoInput(true);
        r48.setDoOutput(true);
        return new b(r48);
    L237:
        if (TextUtils.isEmpty(this.f) == true) goto L264;
        if (i.w(this.f) == false) goto L264;
        this.j = true;     // Catch: Throwable -> L292
        i.h r58 = i.A(this.f);     // Catch: Throwable -> L292
        r48.addRequestProperty("lct", String.valueOf(r58.a));     // Catch: Throwable -> L292
        r48.addRequestProperty("lct-info", r58.b);     // Catch: Throwable -> L292
        String r59 = this.f;     // Catch: Throwable -> L292
        if (i.l.containsKey(r59) == false) goto L245;
        i.e r60 = i.l.get(r59);     // Catch: Throwable -> L292
        if (r60 == null) goto L245;
        String r61 = r60.b;     // Catch: Throwable -> L292
    L247:
        if (TextUtils.isEmpty(r61) == true) goto L249;
        r61 = r61 + ";15K;16H;17I;1A4;17S;183";     // Catch: Throwable -> L292
    L249:
        r48.addRequestProperty("aks", r61);     // Catch: Throwable -> L292
        String r62 = NameKeys.UnloadStrategy_No_Strategy;
        i.e r63 = i.l.get(this.f);     // Catch: Throwable -> L292
        if (r63 == null) goto L252;
        e5 r64 = r63.a;     // Catch: Throwable -> L292
    L253:
        if (r64 == null) goto L259;
        i.e r65 = i.l.get(this.f);     // Catch: Throwable -> L292
        if (r65 == null) goto L257;
        e5 r66 = r65.a;     // Catch: Throwable -> L292
    L258:
        r62 = r66.f;     // Catch: Throwable -> L292
        goto L259
    L257:
        r66 = null;
    L259:
        String r67 = this.f;     // Catch: Throwable -> L292
        String r68 = Build.MANUFACTURER;     // Catch: Throwable -> L292
        Context r69 = i.c;     // Catch: Throwable -> L292
        if (r69 == null) goto L262;
        String r70 = f5.c(r69);     // Catch: Throwable -> L292
    L263:
        r48.addRequestProperty("lct-args", String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", new Object[]{r62, r67, r68, r70}));     // Catch: Throwable -> L292
        goto L264
    L262:
        r70 = NameKeys.UnloadStrategy_No_Strategy;
        goto L263
    L252:
        r64 = null;
    L245:
        r61 = null;
    L292:
        th = move-exception;
        n.a(th, "ht", "adh");
        goto L294
    L306:
        SoftReference<SSLContext> r71 = n;     // Catch: Throwable -> L179
        if (r71 != null) goto L173;
    L174:
        n = new SoftReference(SSLContext.getInstance("TLS"));     // Catch: Throwable -> L179
    L175:
        SoftReference<SSLContext> r72 = n;     // Catch: Throwable -> L179
        if (r72 == null) goto L180;
        SSLContext r73 = r72.get();     // Catch: Throwable -> L179
    L181:
        if (r73 == null) goto L304;
    L183:
        r73.init(null, null, null);     // Catch: Throwable -> L185
        this.b = r73;     // Catch: Throwable -> L185
    L187:
        HttpsURLConnection r74 = (HttpsURLConnection) r46;
        if (i.g.a == true) goto L308;
    L223:
        r74.setSSLSocketFactory(this.b.getSocketFactory());
    L224:
        r74.setHostnameVerifier(r6);
        r48 = r74;
        goto L227
    L308:
        SoftReference<com.loc.e> r75 = o;     // Catch: Throwable -> L201
        if (r75 != null) goto L192;
    L193:
        o = new SoftReference(new com.loc.e(i.c, this.b));     // Catch: Throwable -> L201
    L195:
        if (n == null) goto L197;
        com.loc.e r76 = o.get();     // Catch: Throwable -> L201
    L198:
        if (r76 != null) goto L203;
        r76 = new com.loc.e(i.c, this.b);     // Catch: Throwable -> L201
    L203:
        if (r76 == null) goto L223;
        r74.setSSLSocketFactory(r76);
        int r77 = Build.VERSION.SDK_INT;
        if (i.g.c == false) goto L224;
        if (r76.b == null) goto L224;
        if (r76.c == null) goto L224;
        int r78 = i.g.d;
        if (r78 <= 17) goto L216;
        if (r77 > r78) goto L224;
    L216:
        SSLSessionCache r79 = new SSLSessionCache(r76.b);
        if (r77 < 28) goto L313;
    L222:
        r76.a(r79);
        goto L224
    L313:
        r79.getClass().getMethod(f5.o("MaW5zdGFsbA"), new Class[]{SSLSessionCache.class, SSLContext.class}).invoke(r79, new Object[]{r79, r76.c});     // Catch: Throwable -> L220
    L220:
        th = move-exception;
        r.f(th, "myssl", "isc1");
        goto L222
    L197:
        r76 = null;
        goto L198
    L192:
        if (r75.get() != null) goto L195;
    L201:
        th = move-exception;
        r.f(th, "ht", "gsf");
        r76 = null;
    L185:
        th = move-exception;
        n.a(th, "ht", "ne");
        goto L187
    L304:
        r73 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L185
        goto L183
    L173:
        if (r71.get() != null) goto L175;
    L180:
        r73 = null;
        goto L181
    L315:
        String r80 = r44.getHost();     // Catch: Throwable -> L165 IOException -> L296
        String r111 = r44.getPath();     // Catch: Throwable -> L165 IOException -> L296
        if (com.obric.assistant.network.okhttp.a.c(r80, r111) == false) goto L167;
        FLogger.a.i("UrlConnLancet", "openConnection drop host=" + r80 + " path=" + r111);     // Catch: Throwable -> L165 IOException -> L296
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r80, r111), r80, r111);     // Catch: Throwable -> L165 IOException -> L296
        throw new IOException("[NetGuard] dropped " + r44);     // Catch: Throwable -> L165 IOException -> L296
    L167:
        r46 = r44.openConnection();
    L296:
        e = move-exception;
        throw e;
    L165:
        th = move-exception;
        FLogger.a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L167
    L57:
        if (r18.contains("apilocate") == true) goto L60;
        r19 = false;
    L24:
        r12 = true;
        goto L26
    L23:
        r9 = com.loc.c.b;
        goto L24
    L8:
        int r81 = 0;
    L10:
        if (r81 >= r4.a.size()) goto L17;
        e r82 = r4.a.get(r81);
        if (r82 == null) goto L16;
        if (r82.b.equals(r5) == false) goto L16;
        r6 = r82;
    L16:
        r81 = r81 + 1;
        goto L10
    L17:
        e r83 = new e();
        r83.b = r5;
        r4.a.add(r83);
        r6 = r83;
        goto L18
    }
}
