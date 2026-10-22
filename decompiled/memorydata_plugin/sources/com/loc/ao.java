package com.loc;

import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;
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
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes3.dex */
public final class ao {
    private static SoftReference<SSLContext> k;
    private static SoftReference<ap> t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SSLContext f5307b;
    private Proxy c;
    private volatile boolean d;
    private long e;
    private long f;
    private String g;
    private ak.a h;
    private d i;
    private String j;
    private boolean l;
    private String m;
    private String n;
    private boolean o;
    private boolean p;
    private String q;
    private String r;
    private String s;
    private f u;

    public static class a implements Cloneable, Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5309b;
        public String c;
        public String d;
        public String e;
        public int f;
        public int g;
        public int h;
        public long i;
        public volatile AtomicInteger j;

        public a(c r3) {
            this.f5309b = r3.c;
            this.c = r3.e;
            this.e = r3.d;
            this.f = r3.m;
            this.g = r3.n;
            this.h = r3.f5313b.a();
            this.d = r3.f5312a;
            this.i = r3.f;
            this.j = new AtomicInteger(1);
            if (this.f != 10) goto L6;
            this.f5308a = 0;
            return;
        }

        public final a a() {
            return (a) ZeusTransformUtils.preCheckCast(super.clone(), a.class, "com.obric.memorydata.plugin");
        L4:
            return null;
        }

        public final String b() {
            String r1 = this.f + "#";     // Catch: Exception -> L26
            if (TextUtils.isEmpty(this.e) == true) goto L8;
            StringBuilder r2 = new StringBuilder().append(r1).append(this.e).append("#");     // Catch: Exception -> L26
        L9:
            String r3 = (r2.toString() + this.h + "#") + this.j + "#";     // Catch: Exception -> L26
            if (TextUtils.isEmpty(this.f5309b) == true) goto L13;
            StringBuilder r4 = new StringBuilder().append(r3).append(this.f5309b).append("#");     // Catch: Exception -> L26
        L12:
            String r5 = r4.toString();     // Catch: Exception -> L26
            if (this.f != 1) goto L18;
            StringBuilder r6 = new StringBuilder().append(r5).append(this.d).append("#");     // Catch: Exception -> L26
        L17:
            String r7 = r6.toString();     // Catch: Exception -> L26
            if (this.f != 1) goto L23;
            StringBuilder r8 = new StringBuilder().append(r7).append(this.i).append("#");     // Catch: Exception -> L26
        L24:
            String r9 = (r8.toString() + this.c + "#") + this.g;     // Catch: Exception -> L26
            String r0 = fq.b(ag.a(r9.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));     // Catch: Exception -> L26
            new StringBuilder("上报异常数据").append(r9).append("加密后：").append(r0);     // Catch: Exception -> L26
            ao.a();     // Catch: Exception -> L26
            return r0;
        L23:
            r8 = new StringBuilder().append(r7).append("-#");     // Catch: Exception -> L26
            goto L24
        L18:
            r6 = new StringBuilder().append(r5).append("-#");     // Catch: Exception -> L26
            goto L17
        L13:
            r4 = new StringBuilder().append(r3).append("-#");     // Catch: Exception -> L26
            goto L12
        L8:
            r2 = new StringBuilder().append(r1).append("-#");     // Catch: Exception -> L26
        L26:
            return null;
        }

        public final /* synthetic */ Object clone() {
            return a();
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object r3) {
            return this.f5308a - ((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).f5308a;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HttpURLConnection f5310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5311b;

        public b(HttpURLConnection r1) {
            this.f5310a = r1;
            this.f5311b = this.f5311b;
        }
    }

    public static class c implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public bo.b f5313b;
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
            this.f5312a = "";
            this.f5313b = bo.b.f5371a;
            this.c = "";
            this.d = "";
            this.e = "";
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
            return (c) ZeusTransformUtils.preCheckCast(super.clone(), c.class, "com.obric.memorydata.plugin");
        L4:
            return null;
        }

        public final String b() {
            if (TextUtils.isEmpty(this.c) == true) goto L5;
            String r0 = this.c + "#";
        L7:
            if (TextUtils.isEmpty(this.d) == true) goto L9;
            StringBuilder r1 = new StringBuilder().append(r0).append(this.d).append("#");
        L10:
            String r5 = (((r1.toString() + this.f5313b.a() + "#") + this.h + "#") + this.j + "#") + this.f;
            String r2 = fq.b(ag.a(r5.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));
            new StringBuilder("上报耗时数据").append(r5).append("加密后：").append(r2);
            ao.a();
            return r2;
        L9:
            r1 = new StringBuilder().append(r0).append("-#");
            goto L10
        L5:
            r0 = "-#";
            goto L7
        }

        public final /* synthetic */ Object clone() {
            return a();
        }

        public final String toString() {
            return "RequestInfo{csid='" + this.f5312a + "', degradeType=" + this.f5313b + ", serverIp='" + this.c + "', path='" + this.d + "', hostname='" + this.e + "', totalTime=" + this.f + ", DNSTime=" + this.g + ", connectionTime=" + this.h + ", writeTime=" + this.i + ", readTime=" + this.j + ", serverTime='" + this.k + "', datasize='" + this.l + "', errorcode=" + this.m + ", errorcodeSub=" + this.n + '}';
        }
    }

    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Vector<e> f5314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile e f5315b;

        private d() {
            this.f5314a = new Vector();
            this.f5315b = new e(0);
        }

        /* synthetic */ d(byte r1) {
            this();
        }

        public final e a(String r6) {
            if (TextUtils.isEmpty(r6) == true) goto L5;
            byte r0 = 0;
            int r1 = 0;
        L8:
            if (r1 >= this.f5314a.size()) goto L15;
            e r2 = (e) ZeusTransformUtils.preCheckCast(this.f5314a.get(r1), e.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L14;
            if (r2.a().equals(r6) == false) goto L14;
            return r2;
        L14:
            r1 = r1 + 1;
            goto L8
        L15:
            e r3 = new e(r0);
            r3.b(r6);
            this.f5314a.add(r3);
            return r3;
        L5:
            return this.f5315b;
        }
    }

    private static class e implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f5317b;

        private e() {
        }

        /* synthetic */ e(byte r1) {
            this();
        }

        public final String a() {
            return this.f5317b;
        }

        public final void a(String r3) {
            if (TextUtils.isEmpty(this.f5316a) == false) goto L5;
        L12:
            this.f5316a = r3;
            return;
        L5:
            if (r3.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L12;
            String[] r0 = r3.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            if (r0 == null) goto L12;
            if (r0.length <= 0) goto L12;
            this.f5316a = r0[0];
        }

        public final void b(String r1) {
            this.f5317b = r1;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public final boolean verify(String r3, SSLSession r4) {
            SSLSession r5 = (SSLSession) ZeusTransformUtils.wrapperContextForParams(r4, SSLSession.class, "com.obric.memorydata.plugin");
            HostnameVerifier r0 = HttpsURLConnection.getDefaultHostnameVerifier();
            if (TextUtils.isEmpty(this.f5316a) == true) goto L7;
            return this.f5316a.equals(r3);
        L7:
            if (TextUtils.isEmpty(this.f5317b) == true) goto L11;
            return r0.verify(this.f5317b, r5);
        L11:
            return r0.verify(r3, r5);
        }
    }

    class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f5318a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f5319b;
        c c;
        a d;
        c e;
        String f;
        URL g;
        final /* synthetic */ ao h;

        f(ao r3) {
            this.h = r3;
            this.f5318a = 0;
            this.f5319b = 0;
            this.c = new c();
        }

        public final void a() {
            c r0 = this.c;
            r0.h = SystemClock.elapsedRealtime() - this.f5319b;
        }

        public final void a(int r6) {
            "----errorcode-----".concat(String.valueOf(r6));
            ao.a();
            c r0 = this.c;     // Catch: Throwable -> L21
            r0.f = SystemClock.elapsedRealtime() - this.f5318a;     // Catch: Throwable -> L21
            this.c.m = r6;     // Catch: Throwable -> L21
            if (this.c.f5313b.e() == false) goto L6;
            fn.a(false, this.c.e);     // Catch: Throwable -> L21
        L6:
            boolean r7 = ao.a(this.h, this.c.e);     // Catch: Throwable -> L21
            if (r7 == true) goto L9;
        L19:
            fn.a(this.g.toString(), this.c.f5313b.c(), true, r7);     // Catch: Throwable -> L21
            new StringBuilder("!!!error-").append(this.c.toString());     // Catch: Throwable -> L21
            ao.a();     // Catch: Throwable -> L21
            return;
        L9:
            if (ao.b(this.h) == false) goto L16;
            if (TextUtils.isEmpty(ao.a(this.h)) == true) goto L16;
            if (this.c.f5313b.b() == false) goto L16;
            fn.d();     // Catch: Throwable -> L21
        L16:
            if (this.c.f5313b.c() == false) goto L18;
            fn.a(this.c.f5313b.c(), this.c.e);     // Catch: Throwable -> L21
        L18:
            fn.c(this.e);     // Catch: Throwable -> L21
            fn.a(false, this.d);     // Catch: Throwable -> L21
            fn.b(this.c);     // Catch: Throwable -> L21
        }

        public final void a(long r3) {
            DecimalFormat r0 = new DecimalFormat("0.00");
            this.c.l = r0.format(r3 / 1024.0f);
        }

        public final void a(aq r8) {
            this.c.f = SystemClock.elapsedRealtime() - this.f5318a;     // Catch: Throwable -> L22
            if (r8 == null) goto L6;
            r8.f = this.c.f5313b.c();     // Catch: Throwable -> L22
        L6:
            if (this.c.f5313b.b() == false) goto L11;
            if (this.c.f <= 10000) goto L11;
            fn.a(false, this.c.e);     // Catch: Throwable -> L22
        L11:
            if (this.c.f5313b.d() == false) goto L13;
            fn.a(false, this.f);     // Catch: Throwable -> L22
        L13:
            boolean r9 = ao.a(this.h, this.c.e);     // Catch: Throwable -> L22
            if (r9 == false) goto L20;
            fn.c(this.c);     // Catch: Throwable -> L22
            fn.a(true, this.d);     // Catch: Throwable -> L22
            if (this.c.f <= fn.e) goto L20;
            c r1 = this.c.a();     // Catch: Throwable -> L22
            if (r1 == null) goto L20;
            r1.m = 1;     // Catch: Throwable -> L22
            fn.b(r1);     // Catch: Throwable -> L22
            new StringBuilder("!!!finish&error-").append(r1.toString());     // Catch: Throwable -> L22
            ao.a();     // Catch: Throwable -> L22
        L20:
            fn.a(this.g.toString(), this.c.f5313b.c(), false, r9);     // Catch: Throwable -> L22
            new StringBuilder("!!!finish-").append(this.c.toString());     // Catch: Throwable -> L22
            ao.a();     // Catch: Throwable -> L22
            return;
        }

        public final void a(bo r4, URL r5) {
            this.g = r5;
            c r0 = this.c;
            r0.d = r5.getPath();
            c r1 = this.c;
            r1.e = r5.getHost();
            if (TextUtils.isEmpty(ao.a(this.h)) == true) goto L8;
            if (r4.x().b() == false) goto L8;
            c r6 = this.c;
            r6.c = r6.e.replace("[", "").replace("]", "");
            c r7 = this.c;
            r7.e = ao.a(this.h);
        L8:
            if (r4.x().b() == false) goto L11;
            r4.a(this.c.e);
        L11:
            if (r4.x().d() == false) goto L14;
            this.f = r4.A();
            return;
        }

        public final void b() {
            c r0 = this.c;
            r0.i = SystemClock.elapsedRealtime() - this.f5319b;
        }

        public final void b(int r1) {
            this.c.n = r1;
        }

        public final void c() {
            c r0 = this.c;
            r0.j = SystemClock.elapsedRealtime() - this.f5319b;
        }

        public final void d() {
            c r0 = this.c.a();
            if (this.c.f <= fn.e) goto L5;
            r0.m = 1;
        L5:
            fn.a(r0);
        }
    }

    static {
    }

    ao() {
        this.d = false;
        this.e = -1;
        this.f = 0;
        this.j = "";
        this.o = false;
        this.p = false;
        this.q = "";
        this.r = "";
        this.s = "";
        this.u = new f(this);
        fn.e();
        this.g = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        n.a(th, "ht", "ic");
    }

    private static int a(Exception r1) {
        if (ZeusTransformUtils.instanceOf(r1, SSLHandshakeException.class) == false) goto L7;
        return 4101;
    L7:
        if (ZeusTransformUtils.instanceOf(r1, SSLKeyException.class) == false) goto L11;
        return 4102;
    L11:
        if (ZeusTransformUtils.instanceOf(r1, SSLProtocolException.class) == false) goto L15;
        return 4103;
    L15:
        if (ZeusTransformUtils.instanceOf(r1, SSLPeerUnverifiedException.class) == false) goto L19;
        return 4104;
    L19:
        if (ZeusTransformUtils.instanceOf(r1, ConnectException.class) == false) goto L23;
        return 6101;
    L23:
        if (ZeusTransformUtils.instanceOf(r1, SocketException.class) == false) goto L27;
        return 6102;
    L27:
        if (ZeusTransformUtils.instanceOf(r1, ConnectTimeoutException.class) == false) goto L31;
        return 2101;
    L31:
        if (ZeusTransformUtils.instanceOf(r1, SocketTimeoutException.class) == false) goto L34;
        return 2102;
    L34:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9 */
    private aq a(b r15) {
        String r3 = "";
        ByteArrayOutputStream r4 = null;
        InputStream r5 = null;
        r5 = null;
        r5 = null;
        r5 = null;
        r4 = null;
        r4 = null;
        an.a();     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        HttpURLConnection r16 = r15.f5310a;     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        Map<String, List<String>> r6 = r16.getHeaderFields();     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        int r7 = r16.getResponseCode();     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        if (r6 == null) goto L40;
        List r10 = (List) ZeusTransformUtils.preCheckCast(r6.get("gsid"), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        if (r10 != null) goto L8;
    L10:
        this.u.c.k = b(r6);     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        if (TextUtils.isEmpty(this.j) == true) goto L40;
        if (this.o == true) goto L16;
        boolean r0 = a(r6, true);     // Catch: Throwable -> L150
        char r11 = 2;
    L160:
        if (r0 == true) goto L23;
        if (r11 != 1) goto L42;
        an.a(false, this.j);     // Catch: Throwable -> L149
        goto L42
    L23:
        if (this.j.equals("loc") == false) goto L32;
        String r12 = this.s;     // Catch: Throwable -> L149
        if (TextUtils.isEmpty(r12) == false) goto L27;
        r12 = r16.getURL().getHost();     // Catch: Throwable -> L149
    L27:
        String r13 = this.j;     // Catch: Throwable -> L149
        if (r11 != 2) goto L30;
        boolean r14 = true;
    L31:
        fn.a(r13, r14, r12, r12, this.n);     // Catch: Throwable -> L149
        goto L42
    L30:
        r14 = false;
        goto L31
    L32:
        String r17 = this.j;     // Catch: Throwable -> L149
        if (r11 != 2) goto L35;
        boolean r18 = true;
    L36:
        fn.b(r17, r18);     // Catch: Throwable -> L149
        goto L42
    L35:
        r18 = false;
    L42:
        if (r7 != 200) goto L103;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        this.u.f5319b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L91 IOException -> L94 SocketTimeoutException -> L97 ConnectTimeoutException -> L100
        InputStream r19 = r16.getInputStream();     // Catch: Throwable -> L91 IOException -> L94 SocketTimeoutException -> L97 ConnectTimeoutException -> L100
    L175:
        PushbackInputStream r110 = new PushbackInputStream(r19, 2);     // Catch: Throwable -> L83 IOException -> L85 SocketTimeoutException -> L87 ConnectTimeoutException -> L89
        byte[] r9 = new byte[2];     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        r110.read(r9);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        r110.unread(r9);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        if (r9[0] == 31) goto L49;
    L51:
        r5 = r110;
    L52:
        byte[] r20 = new byte[1024];     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
    L53:
        int r21 = r5.read(r20);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        if (r21 == (-1)) goto L56;
        r8.write(r20, 0, r21);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        goto L53
    L56:
        this.u.c();     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        q.c();     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        aq r22 = new aq();     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        r22.f5322a = r8.toByteArray();     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        r22.f5323b = r6;     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        r22.c = this.g;     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        r22.d = r3;     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        r22.e = r0;     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        an.a(r16.getURL(), r22);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        this.u.a(r22.f5322a.length);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
        r8.close();     // Catch: Throwable -> L59
    L61:
        if (r19 == null) goto L161;
        r19.close();     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        n.a(th, "ht", "par");
    L161:
        r110.close();     // Catch: Throwable -> L68
    L165:
        r5.close();     // Catch: Throwable -> L72
    L74:
        return r22;
    L72:
        th = move-exception;
        n.a(th, "ht", "par");
    L68:
        th = move-exception;
        n.a(th, "ht", "par");
    L59:
        th = move-exception;
        n.a(th, "ht", "par");
        goto L61
    L49:
        if (r9[1] != (-117)) goto L51;
        r5 = new GZIPInputStream(r110);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L79 ConnectTimeoutException -> L81
    L79:
        e = e;
    L183:
        throw e;     // Catch: Throwable -> L126
    L81:
        e = e;
    L180:
        throw e;     // Catch: Throwable -> L126
    L77:
        e = e;
        InputStream r1 = r5;
    L96:
        r4 = r8;
        ?? r2 = r1;
    L167:
    L118:
        th = th;
    L128:
        if (r4 != null) goto L169;
    L133:
        if (r19 != null) goto L151;
    L138:
        if (r110 != null) goto L156;
    L143:
        if (r2 == 0) goto L181;
        r2.close();     // Catch: Throwable -> L146
        throw th;
    L146:
        th = move-exception;
        n.a(th, "ht", "par");
        throw th;
    L181:
        throw th;
    L156:
        r110.close();     // Catch: Throwable -> L141
    L141:
        th = move-exception;
        n.a(th, "ht", "par");
        goto L143
    L151:
        r19.close();     // Catch: Throwable -> L136
    L136:
        th = move-exception;
        n.a(th, "ht", "par");
        goto L138
    L169:
        r4.close();     // Catch: Throwable -> L131
    L131:
        th = move-exception;
        n.a(th, "ht", "par");
        goto L133
    L110:
        if (ZeusTransformUtils.instanceOf(e, InterruptedIOException.class) == false) goto L117;
        l r23 = new l("IO 操作异常 - IOException", r3, this.g);     // Catch: Throwable -> L118
        if (TextUtils.isEmpty(e.getMessage()) == false) goto L114;
        throw r23;     // Catch: Throwable -> L118
    L114:
        if (e.getMessage().equals("thread interrupted") == false) goto L179;
        r23.j();     // Catch: Throwable -> L118
        throw r23;     // Catch: Throwable -> L118
    L179:
        throw r23;     // Catch: Throwable -> L118
    L117:
        throw e;     // Catch: Throwable -> L118
    L75:
        th = th;
        r2 = r5;
    L93:
        r4 = r8;
        goto L128
    L87:
        e = e;
    L89:
        e = e;
    L85:
        e = e;
        r1 = null;
        r110 = null;
    L83:
        th = th;
        r2 = 0;
        r110 = null;
    L97:
        e = e;
    L100:
        e = e;
    L94:
        e = e;
        r1 = null;
        r19 = null;
        r110 = null;
    L91:
        th = th;
        r2 = 0;
        r19 = null;
        r110 = null;
        goto L93
    L103:
        l r24 = new l("网络异常原因：" + r16.getResponseMessage() + " 网络异常状态码：" + r7 + "  " + r3 + " " + this.g, r3, this.g);     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        r24.a(r16.getResponseMessage());     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        r24.a(r6);     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        this.u.b(r7);     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        this.u.a(10);     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        r24.h();     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
        throw r24;     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
    L16:
        if (r6.containsKey("sc") == false) goto L18;
        r0 = a(r6, false);     // Catch: Throwable -> L150
        r11 = 1;
        goto L160
    L18:
        fn.e(this.j);     // Catch: Throwable -> L150
        r0 = false;
        r11 = 0;
        goto L160
    L8:
        if (r10.size() <= 0) goto L10;
        r3 = (String) ZeusTransformUtils.preCheckCast(r10.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L105 IOException -> L107 SocketTimeoutException -> L120 ConnectTimeoutException -> L123
    L40:
        r0 = false;
    L126:
        th = th;
        r2 = r15;
    L120:
        e = move-exception;
        throw e;     // Catch: Throwable -> L126
    L123:
        e = move-exception;
        throw e;     // Catch: Throwable -> L126
    L107:
        e = e;
        r2 = 0;
        r19 = null;
        r110 = null;
    L105:
        th = th;
        r2 = 0;
        r19 = null;
        r110 = null;
        goto L128
    }

    static /* synthetic */ String a(ao r0) {
        return r0.n;
    }

    private static String a(String r7) {
        com.amap.a.a.a.a.b r0 = com.amap.a.a.a.a.a.a();
        if (r0 != null) goto L5;
        return r7;
    L5:
        URL r1 = null;
        URL r2 = new URL(r7);     // Catch: Exception -> L8
    L10:
        if (r2 != null) goto L12;
        return r7;
    L12:
        String r3 = r0.a(r2.getHost(), r2.getPath());
        if (TextUtils.isEmpty(r3) == false) goto L15;
        return r7;
    L15:
        String[] r4 = r3.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        int r6 = 0;
        if (r4.length == 2) goto L39;
    L35:
        String r5 = r2.getProtocol();     // Catch: Exception -> L29
        if (r6 != 0) goto L27;
        r6 = r2.getPort();     // Catch: Exception -> L29
    L27:
        r1 = new URL(r5, r3, r6, r2.getFile().toString());     // Catch: Exception -> L29
    L31:
        if (r1 != null) goto L34;
        return r7;
    L34:
        return r1.toString();
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L39:
        int r8 = Integer.parseInt(r4[1]);     // Catch: Exception -> L20
    L22:
        r6 = r8;
        r3 = r4[0];
    L20:
        e = move-exception;
        e.printStackTrace();
        r8 = 0;
    L8:
        e = move-exception;
        e.printStackTrace();
        r2 = null;
        goto L10
    }

    private static String a(String r4, String r5) {
        String r0 = Build.MANUFACTURER;
        if (fn.c == null) goto L5;
        String r1 = fx.a(fn.c);
    L7:
        return String.format("platform=Android&sdkversion=%s&product=%s&manufacture=%s&abitype=%s", new Object[]{r4, r5, r0, r1});
    L5:
        r1 = "";
        goto L7
    }

    static String a(Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L16;
        StringBuilder r0 = new StringBuilder();
        Iterator r7 = r6.entrySet().iterator();
    L6:
        if (r7.hasNext() == false) goto L15;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r7.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.getValue(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        if (r0.length() <= 0) goto L13;
        r0.append("&");
    L13:
        r0.append(URLEncoder.encode(r3));
        r0.append("=");
        r0.append(URLEncoder.encode(r4));
        goto L6
    L15:
        return r0.toString();
    L16:
        return null;
    }

    public static void a() {
    }

    private void a(Map<String, String> r6, HttpURLConnection r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L9;
        Iterator r0 = r8.keySet().iterator();     // Catch: Throwable -> L44
    L6:
        if (r0.hasNext() == false) goto L9;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        r7.addRequestProperty(r2, (String) ZeusTransformUtils.preCheckCast(r8.get(r2), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        n.a(th, "ht", "adh");
        return;
    L9:
        if (ak.d == null) goto L15;
        Iterator<String> r9 = ak.d.keySet().iterator();     // Catch: Throwable -> L44
    L12:
        if (r9.hasNext() == false) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        r7.addRequestProperty(r1, (String) ZeusTransformUtils.preCheckCast(ak.d.get(r1), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L44
    L15:
        String r3 = "";
        if (this.m.contains("/v3/iasdkauth") == false) goto L18;
    L26:
        r7.addRequestProperty("csid", this.g);     // Catch: Throwable -> L44
        if (b(this.u.c.e) == false) goto L51;
        f r10 = this.u;     // Catch: Throwable -> L44
        if (TextUtils.isEmpty(r10.c.c) == true) goto L33;
        r3 = fq.b(ag.a(r10.c.c.getBytes(), "YXBtX25ldHdvcmtf".getBytes()));     // Catch: Throwable -> L44
        new StringBuilder("上报本次请求serverIp:").append(r10.c.c).append("加密后：").append(r3);     // Catch: Throwable -> L44
    L33:
        if (TextUtils.isEmpty(r3) == true) goto L36;
        r7.addRequestProperty("sip", r3);     // Catch: Throwable -> L44
    L36:
        if (fn.j == false) goto L40;
        c r11 = fn.g();     // Catch: Throwable -> L44
        if (r11 == null) goto L40;
        r7.addRequestProperty("nls", r11.b());     // Catch: Throwable -> L44
        this.u.e = r11;     // Catch: Throwable -> L44
    L40:
        a r12 = fn.f();     // Catch: Throwable -> L44
        if (r12 == null) goto L52;
        r7.addRequestProperty("nlf", r12.b());     // Catch: Throwable -> L44
        this.u.d = r12;     // Catch: Throwable -> L44
        return;
    L52:
        return;
    L51:
        return;
    L18:
        if (TextUtils.isEmpty(this.j) == true) goto L26;
        if (fn.d(this.j) == false) goto L26;
        this.o = true;     // Catch: Throwable -> L44
        fn.g r13 = fn.f(this.j);     // Catch: Throwable -> L44
        r7.addRequestProperty("lct", String.valueOf(r13.f5572a));     // Catch: Throwable -> L44
        r7.addRequestProperty("lct-info", r13.f5573b);     // Catch: Throwable -> L44
        r7.addRequestProperty("aks", fn.c(fn.a(this.j)));     // Catch: Throwable -> L44
        if (fn.b(this.j) == null) goto L24;
        String r14 = fn.b(this.j).b();     // Catch: Throwable -> L44
    L25:
        r7.addRequestProperty("lct-args", a(r14, this.j));     // Catch: Throwable -> L44
        goto L26
    L24:
        r14 = "";
        goto L25
    }

    static /* synthetic */ boolean a(ao r0, String r1) {
        return r0.b(r1);
    }

    private boolean a(Map<String, List<String>> r8, boolean r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.preCheckCast(r10.get("sc"), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r5 != null) goto L6;
    L17:
        boolean r0 = false;
    L18:
        if (r0 == true) goto L20;
        return false;
    L20:
        if (r9 == true) goto L22;
        return true;
    L22:
        if (r10.containsKey("lct") == false) goto L30;
        List r11 = (List) ZeusTransformUtils.preCheckCast(r10.get("lct"), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r11 == null) goto L30;
        if (r11.size() <= 0) goto L30;
        return fn.a(this.j, fn.a(r11));
    L6:
        if (r5.size() <= 0) goto L17;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r6) == true) goto L17;
        if (r6.contains("#") == true) goto L12;
    L11:
        r0 = true;
        goto L18
    L12:
        String[] r1 = r6.split("#");     // Catch: Throwable -> L31
        if (r1.length <= 1) goto L17;
        if ("1".equals(r1[1]) == false) goto L17;
    L30:
        return false;
    }

    private ap b() {
        SoftReference<ap> r1 = t;     // Catch: Throwable -> L15
        if (r1 != null) goto L6;
    L7:
        t = new SoftReference(new ap(fn.c, this.f5307b));     // Catch: Throwable -> L15
    L9:
        if (k == null) goto L11;
        ap r2 = (ap) ZeusTransformUtils.preCheckCast(t.get(), ap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
    L12:
        if (r2 != null) goto L20;
        return new ap(fn.c, this.f5307b);
    L20:
        return r2;
    L11:
        r2 = null;
        goto L12
    L6:
        if (r1.get() != null) goto L9;
    L15:
        th = move-exception;
        q.b(th, "ht", "gsf");
        return null;
    }

    private static String b(Map<String, List<String>> r5) {
        List r6 = (List) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin")).get("sc"), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r6 != null) goto L6;
        return "";
    L6:
        if (r6.size() <= 0) goto L20;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.get(0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r7) == false) goto L10;
        return "";
    L10:
        if (r7.contains("#") == false) goto L22;
        String[] r8 = r7.split("#");     // Catch: Throwable -> L17
        if (r8.length <= 1) goto L23;
        r7 = r8[0];     // Catch: Throwable -> L17
    L23:
        return "";
    L22:
        return r7;
    L20:
        return "";
    L24:
        return "";
    }

    private void b(bo r4) {
        this.i = new d(0);
        this.p = r4.B();
        this.c = r4.r();
        this.h = r4.w();
        this.l = r4.t();
        this.j = r4.C();
        this.f5306a = fr.a().a(r4.v());
        if (r4.x().b() == false) goto L5;
        String r0 = r4.n();
    L6:
        this.m = r0;
        String r1 = a(r0);
        this.m = r1;
        String r2 = an.a(r1, this.j);
        this.m = r2;
        "restrictionURLTest: ".concat(String.valueOf(r2));
        if (ar.a().a(r2) == true) goto L21;
        this.n = r4.o();
        if ("loc".equals(this.j) == false) goto L28;
        String r3 = r4.m();
        String r5 = r4.n();
        if (TextUtils.isEmpty(r3) == true) goto L14;
        this.r = new URL(r3).getHost();     // Catch: Exception -> L23
    L14:
        if (TextUtils.isEmpty(r5) == true) goto L29;
        if (TextUtils.isEmpty(this.n) == true) goto L19;
        this.q = this.n;     // Catch: Exception -> L24
        return;
    L19:
        this.q = new URL(r5).getHost();     // Catch: Exception -> L24
        return;
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L21:
        "restriction hit: ".concat(String.valueOf(r2));
        throw new l("限制访问的接口");
    L5:
        r0 = r4.m();
        goto L6
    }

    static /* synthetic */ boolean b(ao r0) {
        return r0.p;
    }

    private boolean b(String r3) {
        if (this.l == false) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(this.n) == true) goto L11;
        if (this.n.contains("rest") == false) goto L9;
        return true;
    L9:
        if (this.n.contains("apilocate") == false) goto L11;
        return true;
    L11:
        if (c(r3) == true) goto L19;
        return false;
    L19:
        return true;
    }

    private b c(bo r16) {
        f r2 = this.u;
        bo.b r3 = r16.x();
        r2.c.f5312a = r2.h.g;
        r2.c.f5313b = r3;
        r2.f5318a = SystemClock.elapsedRealtime();
        Map<String, String> r4 = r16.a();
        if (r4 != null) goto L5;
        r4 = new HashMap();
    L5:
        e r5 = this.i.a(this.n);
        int r6 = ak.f5292a;
        String r7 = this.m;
        Uri r8 = Uri.parse(r7);
        String r9 = r8.getHost();
        if (r6 != 1) goto L8;
        String r10 = ak.f5293b;
    L10:
        boolean r12 = true;
    L18:
        if (TextUtils.isEmpty(r10) == true) goto L27;
        r16.z();
        r7 = r8.buildUpon().encodedAuthority(r10).build().toString();
        if (r12 == false) goto L23;
        if (r4 == null) goto L23;
        r4.put("targetHost", r9);
        this.s = r9;
    L23:
        if (r12 == false) goto L27;
        if (this.f5306a == false) goto L27;
        r5.a(r10);
    L27:
        this.m = r7;
        URL r11 = new URL(this.m);
        this.u.a(r16, r11);
        if (c(r11.getHost()) == false) goto L88;
        if (r16.e() == false) goto L88;
        bo.b r13 = r16.x();
        String r14 = this.u.c.e;
        if (b(r14) == true) goto L34;
    L43:
        boolean r15 = false;
    L44:
        if (r15 == false) goto L88;
        this.u.f5319b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L132
        InetAddress[] r17 = InetAddress.getAllByName(this.u.c.e);     // Catch: Throwable -> L132
        if (r17 != null) goto L49;
    L80:
        String r18 = "";
    L81:
        f r19 = this.u;     // Catch: Throwable -> L132
        "---onDNSEnd---ip=".concat(String.valueOf(r18));     // Catch: Throwable -> L132
        r19.c.c = r18.replace("[", "").replace("]", "");     // Catch: Throwable -> L132
        r19.c.g = SystemClock.elapsedRealtime() - r19.f5319b;     // Catch: Throwable -> L132
        if (TextUtils.isEmpty(r18) == true) goto L88;
        Uri r20 = Uri.parse(this.m);     // Catch: Throwable -> L132
        String r21 = r20.getHost();     // Catch: Throwable -> L132
        Uri r22 = r20.buildUpon().encodedAuthority(r18).build();     // Catch: Throwable -> L132
        this.n = r21;     // Catch: Throwable -> L132
        r4.put("host", r21);     // Catch: Throwable -> L132
        if (this.f5306a == false) goto L86;
        r5.b(r21);     // Catch: Throwable -> L132
    L86:
        this.m = r22.toString();     // Catch: Throwable -> L132
        goto L88
    L49:
        if (r17.length <= 0) goto L80;
        if (r17[0] == null) goto L80;
        if (fn.a() == true) goto L55;
    L57:
        boolean r110 = false;
    L58:
        "---canUseIpv6---".concat(String.valueOf(r110));     // Catch: Throwable -> L132
        if (r110 == false) goto L67;
        int r111 = 0;
    L62:
        if (r111 >= r17.length) goto L74;
        if (ZeusTransformUtils.instanceOf(r17[r111], Inet6Address.class) == true) goto L65;
        r111 = r111 + 1;     // Catch: Throwable -> L132
        goto L62
    L65:
        r18 = "[" + r17[r111].getHostAddress() + "]";     // Catch: Throwable -> L132
    L76:
        if (TextUtils.isEmpty(r18) == false) goto L81;
        InetAddress r23 = r17[0];     // Catch: Throwable -> L132
        r18 = r23.getHostAddress();     // Catch: Throwable -> L132
        if (ZeusTransformUtils.instanceOf(r23, Inet6Address.class) == false) goto L81;
        r18 = "[" + r18 + "]";     // Catch: Throwable -> L132
    L74:
        r18 = "";
        goto L76
    L67:
        int r112 = 0;
    L69:
        if (r112 >= r17.length) goto L74;
        if (ZeusTransformUtils.instanceOf(r17[r112], Inet4Address.class) == true) goto L72;
        r112 = r112 + 1;     // Catch: Throwable -> L132
        goto L69
    L72:
        r18 = r17[r112].getHostAddress();     // Catch: Throwable -> L132
        goto L76
    L55:
        if (fn.c() == false) goto L57;
        r110 = true;
        goto L58
    L34:
        if (r13.b() == false) goto L39;
        if (fn.g == false) goto L39;
    L37:
        r15 = true;
    L39:
        if (r13.c() == false) goto L43;
        if (fn.h(r14) == false) goto L43;
    L88:
        if (this.f5306a == false) goto L90;
        this.m = fr.a(this.m);
    L90:
        new StringBuilder("是否降级=").append(r16.x()).append("-最终url=").append(this.m);
        URL r24 = new URL(this.m);
        ak.a r25 = this.h;
        if (r25 == null) goto L93;
        URLConnection r26 = r25.a();
    L94:
        if (r26 != null) goto L100;
        Proxy r27 = this.c;
        if (r27 == null) goto L98;
        r26 = r24.openConnection(r27);
        goto L100
    L98:
        r26 = r24.openConnection();
    L100:
        if (this.f5306a == true) goto L134;
        HttpURLConnection r0 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r26, HttpURLConnection.class, "com.obric.memorydata.plugin");
    L126:
        if (Build.VERSION.SDK != null) goto L128;
    L130:
        int r28 = (int) (((long) r16.y()) - (this.u.c.g / 1000));
        a(r4, r0);
        r0.setConnectTimeout(r28);
        r0.setReadTimeout(r28);
        r0.setRequestMethod("POST");
        r0.setUseCaches(false);
        r0.setDoInput(true);
        r0.setDoOutput(true);
        return new b(r0);
    L128:
        if (Build.VERSION.SDK_INT <= 13) goto L130;
        r0.setRequestProperty("Connection", IslandSession.REOPEN_VALUE_CLOSE);
        goto L130
    L134:
        SoftReference<SSLContext> r29 = k;     // Catch: Throwable -> L133
        if (r29 != null) goto L104;
    L105:
        k = new SoftReference(SSLContext.getInstance("TLS"));     // Catch: Throwable -> L133
    L106:
        SoftReference<SSLContext> r30 = k;     // Catch: Throwable -> L133
        if (r30 == null) goto L110;
        SSLContext r31 = (SSLContext) ZeusTransformUtils.preCheckCast(r30.get(), SSLContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L133
    L111:
        if (r31 == null) goto L136;
    L113:
        r31.init(null, null, null);     // Catch: Throwable -> L115
        this.f5307b = r31;     // Catch: Throwable -> L115
    L117:
        r0 = (HttpsURLConnection) ZeusTransformUtils.preCheckCast(r26, HttpsURLConnection.class, "com.obric.memorydata.plugin");
        if (fn.f.f5570a == false) goto L122;
        ap r32 = b();
        if (r32 == null) goto L122;
        ((HttpsURLConnection) ZeusTransformUtils.preCheckCast(r0, HttpsURLConnection.class, "com.obric.memorydata.plugin")).setSSLSocketFactory(r32);
        r32.a();
    L123:
        ((HttpsURLConnection) ZeusTransformUtils.preCheckCast(r0, HttpsURLConnection.class, "com.obric.memorydata.plugin")).setHostnameVerifier(r5);
    L122:
        ((HttpsURLConnection) ZeusTransformUtils.preCheckCast(r0, HttpsURLConnection.class, "com.obric.memorydata.plugin")).setSSLSocketFactory(this.f5307b.getSocketFactory());
    L115:
        th = move-exception;
        n.a(th, "ht", "ne");
        goto L117
    L136:
        r31 = SSLContext.getInstance("TLS");     // Catch: Throwable -> L115
        goto L113
    L104:
        if (r29.get() != null) goto L106;
    L110:
        r31 = null;
        goto L111
    L93:
        r26 = null;
        goto L94
    L8:
        if (r6 == 2) goto L12;
        r10 = "";
        goto L10
    L12:
        if (ak.c == null) goto L14;
        r10 = (String) ZeusTransformUtils.preCheckCast(ak.c.get(r9), String.class, "com.obric.memorydata.plugin");
    L15:
        r12 = false;
        goto L18
    L14:
        r10 = "";
        goto L15
    }

    private static boolean c(String r1) {
        if (r1.contains("rest") == false) goto L5;
        return true;
    L5:
        if (r1.contains("apilocate") == true) goto L11;
        return false;
    L11:
        return true;
    }

    final aq a(bo r14) {
        HttpURLConnection r7 = null;
        b(r14);     // Catch: Throwable -> L71 l -> L74 IOException -> L82 InterruptedIOException -> L116 SocketTimeoutException -> L87 SocketException -> L90 UnknownHostException -> L93 MalformedURLException -> L96 ConnectTimeoutException -> L99 ConnectException -> L102 SSLException -> L105
        aq r8 = an.b(this.m, this.j);     // Catch: Throwable -> L71 l -> L74 IOException -> L82 InterruptedIOException -> L116 SocketTimeoutException -> L87 SocketException -> L90 UnknownHostException -> L93 MalformedURLException -> L96 ConnectTimeoutException -> L99 ConnectException -> L102 SSLException -> L105
        if (r8 == null) goto L7;
        this.u.d();
        return r8;
    L7:
        b r9 = c(r14);     // Catch: Throwable -> L71 l -> L74 IOException -> L82 InterruptedIOException -> L116 SocketTimeoutException -> L87 SocketException -> L90 UnknownHostException -> L93 MalformedURLException -> L96 ConnectTimeoutException -> L99 ConnectException -> L102 SSLException -> L105
        HttpURLConnection r10 = r9.f5310a;     // Catch: Throwable -> L71 l -> L74 IOException -> L82 InterruptedIOException -> L116 SocketTimeoutException -> L87 SocketException -> L90 UnknownHostException -> L93 MalformedURLException -> L96 ConnectTimeoutException -> L99 ConnectException -> L102 SSLException -> L105
        this.u.f5319b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        r10.connect();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        this.u.a();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        byte[] r11 = r14.d();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (r11 != null) goto L11;
    L12:
        Map<String, String> r15 = r14.b();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (ak.e == null) goto L17;
        if (r15 == null) goto L16;
        r15.putAll(ak.e);     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        goto L17
    L16:
        r15 = ak.e;     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L17:
        String r16 = a(r15);     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (TextUtils.isEmpty(r16) == true) goto L20;
        r11 = fx.a(r16);     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L20:
        if (r11 != null) goto L22;
    L42:
        aq r17 = a(r9);     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        this.u.a(r17);     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (r10 != null) goto L117;
    L48:
        this.u.d();
        return r17;
    L117:
        r10.disconnect();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        n.a(th, "ht", "mPt");
        goto L48
    L22:
        if (r11.length <= 0) goto L42;
        this.u.f5319b = SystemClock.elapsedRealtime();     // Catch: Throwable -> L34
        OutputStream r18 = r10.getOutputStream();     // Catch: Throwable -> L34
        DataOutputStream r12 = new DataOutputStream(r18);     // Catch: Throwable -> L32
        r12.write(r11);     // Catch: Throwable -> L30
        r12.close();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        if (r18 == null) goto L29;
        r18.close();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L29:
        this.u.b();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L30:
        Throwable th = th;
    L36:
        if (r12 == null) goto L38;
        r12.close();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L38:
        if (r18 == null) goto L40;
        r18.close();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L40:
        this.u.b();     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
        throw th;     // Catch: Throwable -> L50 l -> L52 IOException -> L54 InterruptedIOException -> L56 SocketTimeoutException -> L57 SocketException -> L59 UnknownHostException -> L61 MalformedURLException -> L63 ConnectTimeoutException -> L65 ConnectException -> L67 SSLException -> L69
    L32:
        th = move-exception;
        r12 = null;
        th = th;
    L34:
        th = move-exception;
        r12 = null;
        th = th;
        r18 = null;
        goto L36
    L11:
        if (r11.length != 0) goto L20;
    L52:
        e = e;
    L76:
        if (e.i() == false) goto L78;
    L80:
        n.a(e, "ht", "mPt");     // Catch: Throwable -> L108
        throw e;     // Catch: Throwable -> L108
    L78:
        if (e.g() == 10) goto L80;
        this.u.a(e.g());     // Catch: Throwable -> L108
    L67:
        e = e;
    L103:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.u.b(a(e));     // Catch: Throwable -> L108
        this.u.a(6);     // Catch: Throwable -> L108
        throw new l("http连接失败 - ConnectionException");     // Catch: Throwable -> L108
    L57:
        e = e;
    L88:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.u.b(a(e));     // Catch: Throwable -> L108
        this.u.a(2);     // Catch: Throwable -> L108
        throw new l("socket 连接超时 - SocketTimeoutException");     // Catch: Throwable -> L108
    L61:
        e = e;
    L94:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.u.a(5);     // Catch: Throwable -> L108
        throw new l("未知主机 - UnKnowHostException");     // Catch: Throwable -> L108
    L65:
        e = e;
    L100:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.u.b(a(e));     // Catch: Throwable -> L108
        this.u.a(2);     // Catch: Throwable -> L108
        throw new l("IO 操作异常 - IOException");     // Catch: Throwable -> L108
    L63:
        e = e;
    L97:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.u.a(8);     // Catch: Throwable -> L108
        throw new l("url异常 - MalformedURLException");     // Catch: Throwable -> L108
    L59:
        e = e;
    L91:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.u.b(a(e));     // Catch: Throwable -> L108
        this.u.a(6);     // Catch: Throwable -> L108
        throw new l("socket 连接异常 - SocketException");     // Catch: Throwable -> L108
    L69:
        e = e;
    L106:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.u.b(a(e));     // Catch: Throwable -> L108
        this.u.a(4);     // Catch: Throwable -> L108
        throw new l("IO 操作异常 - IOException");     // Catch: Throwable -> L108
    L54:
        e = e;
    L83:
        e.printStackTrace();     // Catch: Throwable -> L108
        this.u.a(7);     // Catch: Throwable -> L108
        throw new l("IO 操作异常 - IOException");     // Catch: Throwable -> L108
    L50:
        th = th;
    L72:
        n.a(th, "ht", "mPt");     // Catch: Throwable -> L108
        this.u.a(9);     // Catch: Throwable -> L108
        throw new l("未知的错误");     // Catch: Throwable -> L108
    L108:
        th = move-exception;
        if (0 != 0) goto L126;
    L114:
        this.u.d();
        throw th;
    L126:
        r7.disconnect();     // Catch: Throwable -> L112
    L112:
        th = move-exception;
        n.a(th, "ht", "mPt");
    L74:
        e = e;
    L96:
        e = e;
    L87:
        e = e;
    L102:
        e = e;
    L90:
        e = e;
    L93:
        e = e;
    L105:
        e = e;
    L99:
        e = e;
    L82:
        e = e;
    L71:
        th = th;
    L85:
        this.u.b(7101);     // Catch: Throwable -> L108
        this.u.a(7);     // Catch: Throwable -> L108
        throw new l("未知的错误");     // Catch: Throwable -> L108
    }
}
