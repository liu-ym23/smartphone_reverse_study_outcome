package r2;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.RetrofitMetrics;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class d extends b implements WeakHandler.IHandler {
    private static HandlerThread N;
    private static boolean O;
    private static Class P;
    private static String Q;
    private volatile boolean A;
    private volatile HttpURLConnection B;
    private volatile int C;
    private volatile HttpURLConnection D;
    private List<a> E;
    private volatile int F;
    private CountDownLatch G;
    private WeakHandler H;
    private long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f12596J;
    private boolean K;
    private long L;
    private long M;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f12597p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Set<String> f12598q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f12599r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private a f12600s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f12601t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f12602u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private String f12603v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private List<String> f12604w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Object f12605x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private volatile AtomicInteger f12606y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private List<HttpURLConnection> f12607z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f12608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f12609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f12610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f12611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f12612e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f12613f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        IOException f12614g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        String f12615h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        long f12616i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Boolean f12617j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        long f12618k;

        a(String r10) {
            this.f12608a = -1;
            this.f12609b = r10;
            this.f12610c = System.currentTimeMillis();
            this.f12612e = 0;
            this.f12613f = -1;
            this.f12615h = "";
            this.f12616i = -1;
            this.f12617j = Boolean.FALSE;
            this.f12618k = -1;
        }

        JSONObject a() {
            JSONObject r10 = new JSONObject();
            r10.put("host", this.f12609b);     // Catch: JSONException -> L18
            r10.put(CommonConsts.APM_INNER_EVENT_COST_START, this.f12610c);     // Catch: JSONException -> L18
            r10.put("end", this.f12611d);     // Catch: JSONException -> L18
            r10.put("net_error", this.f12612e);     // Catch: JSONException -> L18
            r10.put("code", this.f12613f);     // Catch: JSONException -> L18
            IOException r11 = this.f12614g;     // Catch: JSONException -> L18
            if (r11 == null) goto L11;
            String r12 = r11.getMessage();     // Catch: JSONException -> L18
            if (TextUtils.isEmpty(r12) == false) goto L8;
        L10:
            r10.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r12);     // Catch: JSONException -> L18
            goto L11
        L8:
            if (r12.length() <= 64) goto L10;
            r12 = r12.substring(0, 64);     // Catch: JSONException -> L18
        L11:
            r10.put("dispatch", this.f12616i);     // Catch: JSONException -> L18
            r10.put("dpHost", this.f12615h);     // Catch: JSONException -> L18
            if (this.f12617j.booleanValue() == false) goto L14;
            r10.put("sentAlready", true);     // Catch: JSONException -> L18
        L14:
            long r13 = this.f12618k;     // Catch: JSONException -> L18
            if (r13 <= 0) goto L17;
            r10.put("cleanUpTime", r13);     // Catch: JSONException -> L18
        L17:
            return r10;
        }
    }

    static {
        N = new HandlerThread("Concurrent-Handler");
        Q = null;
        P = Class.forName("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl");     // Catch: ClassNotFoundException -> L5
    L7:
        N.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public d(n4.c r10, f.a r11) {
        super(r10);
        this.f12598q = new CopyOnWriteArraySet();
        this.f12599r = "";
        this.f12600s = null;
        this.f12604w = new ArrayList();
        this.f12605x = new Object();
        int r12 = 0;
        this.f12606y = new AtomicInteger(0);
        this.f12607z = new CopyOnWriteArrayList();
        this.A = false;
        this.B = null;
        this.C = -1;
        this.D = null;
        this.E = new CopyOnWriteArrayList();
        this.F = 0;
        this.G = new CountDownLatch(1);
        this.H = new WeakHandler(N.getLooper(), this);
        this.K = false;
        this.L = 0;
        String r13 = r10.G();
        this.f12597p = r13;
        Uri r14 = Uri.parse(r13);
        String r15 = r14.getScheme();
        String r16 = r15 + "://" + r14.getHost();
        String r17 = r14.getQuery();
        Iterator<String> r18 = r11.a().iterator();
    L4:
        if (r18.hasNext() == false) goto L15;
        String r19 = this.f12597p.replaceFirst(r16, r15 + "://" + r18.next());
        if (TextUtils.isEmpty(r17) == true) goto L14;
        if (r17.contains("concurrent=") == true) goto L10;
        r19 = r19 + "&concurrent=" + r12;
    L10:
        if (r12 <= 0) goto L14;
        if (r17.contains("is_retry=") == true) goto L14;
        r19 = r19 + "&is_retry=1";
    L14:
        r12 = r12 + 1;
        this.f12604w.add(r19);
        goto L4
    L15:
        this.f12601t = UUID.randomUUID().toString();
        this.f12602u = r11.f12632i;
        this.f12603v = r11.f12639p;
        this.I = r11.f12636m;
        O = r11.f12637n;
        this.f12596J = r11.f12638o;
        this.L = r11.f12641r;
        this.K = r11.f12640q;
        r0(r10);
        if (Logger.debug() == false) goto L18;
        Logger.d("ConcurrentCronetSsCall", "Request max wait time milliseconds: " + this.M + ", user max wait time: " + this.L + ", connect interval milliseconds: " + this.I);
    L18:
        RetrofitMetrics r110 = this.f1631g.O;
        if (r110 == null) goto L27;
        r110.f2445k = this.f12601t;
        r110.f2447l = true;
        return;
    }

    private void A0(String r10, String r11) {
        i.K(r10, r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static boolean B0(int r10, String r11, String r12) {
        if (r10 < 200) goto L6;
        if (r10 >= 300) goto L6;
        return false;
    L6:
        if (r11 != null) goto L8;
    L10:
        if (r10 < 300) goto L17;
        if (r10 >= 600) goto L17;
        if (O == true) goto L17;
        return false;
    L17:
        if (f.d().c(r10, r12) == false) goto L19;
        return false;
    L19:
        return true;
    L8:
        if (r11.equals(NetConst.ENCRYPT_VERISON_CODE) == false) goto L10;
        return false;
    }

    public static /* synthetic */ void o0(d r10) {
        r10.x0();
    }

    private void p0() {
        Message r10 = Message.obtain();
        r10.what = 1;
        r10.obj = this;
        this.H.sendMessage(r10);
    }

    private void q0() {
        this.H.removeCallbacksAndMessages(null);
        Object r10 = this.f12605x;
        monitor-enter(r10);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.A == false) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L29
        return;
    L8:
        Iterator<HttpURLConnection> r11 = this.f12607z.iterator();     // Catch: Throwable -> L29
    L10:
        if (r11.hasNext() == false) goto L23;
        HttpURLConnection r12 = r11.next();     // Catch: Throwable -> L29
        if (r12 == null) goto L10;
        Iterator<a> r13 = this.E.iterator();     // Catch: Throwable -> L29
    L15:
        if (r13.hasNext() == false) goto L22;
        a r14 = r13.next();     // Catch: Throwable -> L29
        if (r14.f12608a != r12.hashCode()) goto L15;
        r14.f12611d = System.currentTimeMillis();     // Catch: Throwable -> L29
        if (this.K == false) goto L21;
        r14.f12618k = System.currentTimeMillis();     // Catch: Throwable -> L29
        goto L22
    L21:
        r14.f12612e = -999;     // Catch: Throwable -> L29
        r14.f12614g = new IOException("cleanupMessagesAndPendingConnections");     // Catch: Throwable -> L29
    L22:
        r12.disconnect();     // Catch: Throwable -> L29
        this.f12607z.remove(r12);     // Catch: Throwable -> L29
        goto L10
    L23:
        RetrofitMetrics r15 = this.f1631g.O;     // Catch: Throwable -> L29
        if (r15 == null) goto L26;
        r15.f2443j = y0();     // Catch: Throwable -> L29
    L26:
        this.A = true;     // Catch: Throwable -> L29
        monitor-exit(r10);     // Catch: Throwable -> L29
    }

    private void r0(n4.c r10) {
        this.M = o2.f.j() + o2.f.p();
        if ((r10.t() instanceof o2.c) == false) goto L12;
        o2.c r11 = (o2.c) r10.t();
        long r12 = r11.f11428i;
        if (r12 <= 0) goto L7;
    L6:
        this.M = r12;
        goto L12
    L7:
        long r13 = r11.f11422c;
        if (r13 <= 0) goto L12;
        long r14 = r11.f11423d;
        if (r14 <= 0) goto L12;
        r12 = r13 + r14;
    L12:
        this.M += 1000;
    }

    private String s0(String r10, a r11) {
        if (r11 != null) goto L5;
        return "";
    L5:
        long r12 = System.currentTimeMillis();
        String r13 = i.e0(r10, -1, true).a();     // Catch: Exception -> L17
        r11.f12616i = System.currentTimeMillis() - r12;
        r11.f12615h = new URI(r13).getHost();     // Catch: URISyntaxException -> L14
        if (Logger.debug() == false) goto L13;
        Logger.e("ConcurrentCronetSsCall", "url is " + r10 + " dispatchedUrl is " + r13);
    L13:
        return r11.f12615h;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void t0() {
        com.bytedance.frameworks.baselib.network.dispatcher.a r10 = new com.bytedance.frameworks.baselib.network.dispatcher.a("Concurrent-Call", IRequest.Priority.IMMEDIATE, 0, new c(this), this.f1631g.C);
        com.bytedance.frameworks.baselib.network.dispatcher.c.c().a(r10);
        z0(this.I);
    }

    private void u0() {
        if (this.H.obtainMessage(0) == null) goto L6;
        this.H.removeMessages(0);
        t0();
        return;
    }

    private IOException w0(Exception r10, String r11, HttpURLConnection r12, boolean r13) {
        if (this.K == false) goto L5;
    L12:
        int r14 = 0;
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r10.getClass().getName()) == false) goto L15;
    L16:
        r14 = i.l(r12);
    L18:
        if (TextUtils.isEmpty(r11) == false) goto L20;
        r11 = this.f12597p;
    L20:
        String r15 = r11;
        if (r13 == false) goto L23;
        com.bytedance.frameworks.baselib.network.http.impl.a.T(r15, this.f1631g, this, this, r10);
    L37:
        q(this.f1630c, r10);     // Catch: NetworkNotAvailabeException -> L35
        CronetIOException r16 = new CronetIOException(r10, this.f1631g, r14);
        if (r13 == true) goto L29;
        boolean r17 = false;
        boolean r18 = false;
        boolean r19 = false;
    L33:
        o2.b r20 = this.f1631g;
        r16.setInfo(r17, r18, r19, r15, r20.P, r20);
        return r16;
    L29:
        if (this.f1630c.N() == false) goto L31;
        this.f1631g.M.set(true);
    L31:
        r17 = true;
        r18 = false;
        r19 = true;
    L35:
        e = move-exception;
        return e;
    L23:
        if (r12 == null) goto L37;
        r12.disconnect();
        goto L37
    L15:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r10.getClass().getName()) == false) goto L18;
    L5:
        if ((r10 instanceof IOException) == false) goto L12;
        if (r10.getMessage() == null) goto L12;
        if (r10.getMessage().startsWith("request canceled") == false) goto L12;
        return (IOException) r10;
    }

    private /* synthetic */ void x0() {
        long r10 = SystemClock.uptimeMillis();
        HttpURLConnection r11 = null;
        String r12 = null;
        r11 = null;
        r11 = null;
        Object r13 = this.f12605x;     // Catch: IOException -> L97
        monitor-enter(r13);     // Catch: IOException -> L97
    L89:
        th = th;
        String r14 = null;
        a r15 = null;
    L91:
        monitor-exit(r13);     // Catch: Throwable -> L95
        throw th;     // Catch: IOException -> L93
    L93:
        e = e;
        HttpURLConnection r16 = r11;
    L99:
        IOException e10 = e;
    L100:
        Object r17 = this.f12605x;
        monitor-enter(r17);
        int r18 = -1;
        Class r19 = P;     // Catch: Throwable -> L158
        if (r19 == null) goto L176;
        if (r19.isInstance(e10) == false) goto L176;
        r18 = ((Integer) Reflect.on(e10).call("getCronetInternalErrorCode").get()).intValue();     // Catch: Throwable -> L158
        if (Logger.debug() == false) goto L176;
        Logger.d("ConcurrentCronetSsCall", "cronet error code: " + r18);     // Catch: Throwable -> L158
    L176:
    L155:
        th = move-exception;
        throw th;
    L111:
        if (this.D != null) goto L117;
        if (Logger.debug() == false) goto L115;
        Logger.d("ConcurrentCronetSsCall", "Get first failed connection " + r16.getURL().toString());     // Catch: Throwable -> L155
    L115:
        this.D = r16;     // Catch: Throwable -> L155
    L119:
        if (r16 == null) goto L124;
        r16.disconnect();     // Catch: Throwable -> L155
        if (r15 == null) goto L123;
        r15.f12614g = w0(e10, r14, r16, false);     // Catch: Throwable -> L155
        r15.f12612e = r18;     // Catch: Throwable -> L155
        r15.f12611d = System.currentTimeMillis();     // Catch: Throwable -> L155
    L123:
        this.f12607z.remove(r16);     // Catch: Throwable -> L155
    L124:
        int r20 = this.F + 1;     // Catch: Throwable -> L155
        this.F = r20;     // Catch: Throwable -> L155
        if (r20 < this.f12604w.size()) goto L133;
        if (Logger.debug() == false) goto L129;
        Logger.d("ConcurrentCronetSsCall", "Try all urls failed countdown.");     // Catch: Throwable -> L155
    L129:
        this.G.countDown();     // Catch: Throwable -> L155
        monitor-exit(r17);     // Catch: Throwable -> L155
        return;
    L133:
        if (this.K == false) goto L143;
        if (this.f1633i == false) goto L143;
        if (Logger.debug() == false) goto L139;
        Logger.d("ConcurrentCronetSsCall", "User canceled.");     // Catch: Throwable -> L155
    L139:
        this.G.countDown();     // Catch: Throwable -> L155
        monitor-exit(r17);     // Catch: Throwable -> L155
        return;
    L143:
        if (f.d().c(r18, this.f12602u) == false) goto L151;
        if (Logger.debug() == false) goto L147;
        Logger.d("ConcurrentCronetSsCall", "inBlockErrorCode countdown.");     // Catch: Throwable -> L155
    L147:
        this.G.countDown();     // Catch: Throwable -> L155
        monitor-exit(r17);     // Catch: Throwable -> L155
        return;
    L151:
        if ((SystemClock.uptimeMillis() - r10) >= this.I) goto L153;
        p0();     // Catch: Throwable -> L155
    L153:
        monitor-exit(r17);     // Catch: Throwable -> L155
        return;
    L117:
        if (Logger.debug() == false) goto L119;
        Logger.d("ConcurrentCronetSsCall", "Get non first failed connection " + r16.getURL().toString());     // Catch: Throwable -> L155
        goto L119
    L6:
        if (this.f12606y.get() < this.f12604w.size()) goto L8;
    L86:
        this.H.removeCallbacksAndMessages(null);     // Catch: Throwable -> L89
        monitor-exit(r13);     // Catch: Throwable -> L89
        return;
    L8:
        if (this.B != null) goto L86;
        if (this.G.getCount() == 0) goto L86;
        if (this.f1633i == true) goto L86;
        int r21 = this.f12606y.get();     // Catch: Throwable -> L89
        r14 = this.f12604w.get(r21);     // Catch: Throwable -> L89
    L84:
        th = th;
        r15 = null;
        goto L91
    L16:
        if (this.f12603v == null) goto L19;
        if (r21 <= 0) goto L19;
        com.bytedance.frameworks.baselib.network.http.util.j r22 = new com.bytedance.frameworks.baselib.network.http.util.j(r14);     // Catch: Throwable -> L84
        r22.b("bypass_rs", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L84
        r14 = r22.c();     // Catch: Throwable -> L84
    L19:
        r15 = new a(new URL(r14).getHost());     // Catch: Throwable -> L84
        this.E.add(r15);     // Catch: Throwable -> L95
        if (this.f12603v == null) goto L37;
        if (v0(r14, r15).booleanValue() == false) goto L37;
        if (r21 <= 0) goto L37;
        this.F++;     // Catch: Throwable -> L95
        if (this.F >= this.f12604w.size()) goto L28;
        this.f12606y.incrementAndGet();     // Catch: Throwable -> L95
        p0();     // Catch: Throwable -> L95
        monitor-exit(r13);     // Catch: Throwable -> L95
        return;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d("ConcurrentCronetSsCall", "Try all urls failed countdown.");     // Catch: Throwable -> L95
    L30:
        this.G.countDown();     // Catch: Throwable -> L95
        monitor-exit(r13);     // Catch: Throwable -> L95
        return;
    L37:
        if (Logger.debug() == false) goto L39;
        Logger.d("ConcurrentCronetSsCall", "ConstructURLConnection and execute index: " + this.f12606y.get() + " url: " + r14);     // Catch: Throwable -> L95
    L39:
        r16 = b0(r14, this.f1631g);     // Catch: Throwable -> L95
        Z(this.f1630c, this.f1631g, r16, null);     // Catch: Throwable -> L82
        if (this.f12596J == true) goto L43;
    L45:
        r16.setRequestProperty("transaction-id", this.f12601t);     // Catch: Throwable -> L82
        this.f12606y.incrementAndGet();     // Catch: Throwable -> L82
        this.f12607z.add(r16);     // Catch: Throwable -> L82
        r15.f12608a = r16.hashCode();     // Catch: Throwable -> L82
        monitor-exit(r13);     // Catch: Throwable -> L82
        this.f12593l = c0(r16);     // Catch: IOException -> L80
        r15.f12613f = this.f12593l;     // Catch: IOException -> L80
        r15.f12611d = System.currentTimeMillis();     // Catch: IOException -> L80
        if (B0(this.f12593l, r16.getHeaderField("tt-api-source-5xx"), this.f12602u) == true) goto L63;
        Object r23 = this.f12605x;     // Catch: IOException -> L80
        monitor-enter(r23);     // Catch: IOException -> L80
    L60:
        th = move-exception;
        throw th;     // Catch: IOException -> L80
    L52:
        if (this.B != null) goto L57;
        this.B = r16;     // Catch: Throwable -> L60
        this.C = r21;     // Catch: Throwable -> L60
        this.f12597p = r14;     // Catch: Throwable -> L60
        if (Logger.debug() == false) goto L56;
        Logger.d("ConcurrentCronetSsCall", "winnerindex is " + this.C);     // Catch: Throwable -> L60
    L56:
        this.G.countDown();     // Catch: Throwable -> L60
    L58:
        monitor-exit(r23);     // Catch: Throwable -> L60
    L179:
        return;
    L57:
        r16.disconnect();     // Catch: Throwable -> L60
        this.f12607z.remove(r16);     // Catch: Throwable -> L60
        goto L58
    L63:
        String r24 = r16.getResponseMessage();     // Catch: IOException -> L80
        int r110 = this.f1630c.x();     // Catch: Throwable -> L73
        InputStream r25 = r16.getInputStream();     // Catch: Exception -> L67 Throwable -> L73
    L66:
        InputStream r111 = r25;
        String r26 = r16.getHeaderField(NetConst.KEY_CONTENT_TYPE);     // Catch: Throwable -> L73
        if (TextUtils.isEmpty(r26) == false) goto L71;
        r26 = r16.getHeaderField(NetConst.KEY_CONTENT_TYPE.toLowerCase());     // Catch: Throwable -> L73
    L71:
        r12 = com.bytedance.frameworks.baselib.network.http.impl.a.J(this.f1631g, r16.getHeaderFields(), r110, r111, r26, false);     // Catch: Throwable -> L73
    L79:
        throw new HttpResponseException(this.f12593l, r24, this.f1630c.A(), r12);     // Catch: IOException -> L80
    L67:
        r25 = r16.getErrorStream();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        th.printStackTrace();     // Catch: IOException -> L80
        StringBuilder r27 = new StringBuilder();     // Catch: IOException -> L80
        r27.append("reason = ");     // Catch: IOException -> L80
        if (r24 != null) goto L77;
        r24 = "";
    L77:
        r27.append(r24);     // Catch: IOException -> L80
        r27.append("  exception = ");     // Catch: IOException -> L80
        r27.append(th.getMessage());     // Catch: IOException -> L80
        r24 = r27.toString();     // Catch: IOException -> L80
    L80:
        e10 = e;
        goto L100
    L43:
        if (this.f12603v != null) goto L45;
        r16.setRequestProperty("x-tt-bp-rs", NetConst.ENCRYPT_VERISON_CODE);     // Catch: Throwable -> L82
    L82:
        th = th;
        r11 = r16;
    L95:
        th = th;
    L97:
        e = e;
        r14 = null;
        r15 = null;
        r16 = null;
        goto L99
    }

    private JSONObject y0() {
        JSONObject r10 = new JSONObject();
        r10.put("concurrent", this.E.size() - 1);     // Catch: JSONException -> L14
        r10.put("duration", System.currentTimeMillis() - this.f1631g.f11401h);     // Catch: JSONException -> L14
        if (this.K == true) goto L6;
    L8:
        JSONArray r11 = new JSONArray();     // Catch: JSONException -> L14
        Iterator<a> r12 = this.E.iterator();     // Catch: JSONException -> L14
    L10:
        if (r12.hasNext() == false) goto L12;
        r11.put(r12.next().a());     // Catch: JSONException -> L14
        goto L10
    L12:
        r10.put("tasks", r11);     // Catch: JSONException -> L14
    L16:
        return r10;
    L6:
        if (TextUtils.isEmpty(Q) == true) goto L8;
        r10.put("call_msg", Q);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private void z0(long r10) {
        Message r11 = Message.obtain();
        r11.what = 0;
        r11.obj = this;
        this.H.sendMessageDelayed(r11, r10);
    }

    @Override // s4.c
    public void a(Throwable r10, boolean r11) {
        Object r12 = this.f12605x;
        monitor-enter(r12);
        this.G.countDown();     // Catch: Throwable -> L7
        q0();     // Catch: Throwable -> L7
        X(this.B, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // r2.b
    public HttpURLConnection a0() {
        if (this.B == null) goto L6;
        return this.B;
    L6:
        return this.D;
    }

    @Override // com.bytedance.retrofit2.m
    public void b() {
        com.bytedance.frameworks.baselib.network.http.impl.a.A(this.f1631g, this);
    }

    @Override // r2.b, n4.e
    public boolean c(long r10) {
        super.c(r10);
        if (this.B != null) goto L11;
    L10:
        return true;
    L11:
        Reflect.on(this.B).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r10)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    @Override // n4.e
    public void cancel() {
        if (Logger.debug() == false) goto L5;
        Logger.d("ConcurrentCronetSsCall", "cancel countdown.");
    L5:
        Object r10 = this.f12605x;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.K == true) goto L10;
        this.G.countDown();     // Catch: Throwable -> L13
    L10:
        q0();     // Catch: Throwable -> L13
        W(this.B);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a, n4.e
    public n4.d execute() {
        RetrofitMetrics r10 = this.f1631g.O;
        if (r10 == null) goto L6;
        r10.f2461s = System.currentTimeMillis();
    L6:
        if (this.f1633i == true) goto L75;
        com.bytedance.frameworks.baselib.network.http.impl.a.R(this.f1630c, this.f1631g);
        com.bytedance.frameworks.baselib.network.http.impl.a.r(p(), x(), this.f1630c.A());
        t0();
        boolean r11 = true;
        long r12 = this.M;     // Catch: Exception -> L65
        if (this.K == false) goto L11;
        r12 = Math.max(r12, this.L);     // Catch: Exception -> L65
    L11:
        this.G.await(r12, TimeUnit.MILLISECONDS);     // Catch: Exception -> L65
        this.G.countDown();     // Catch: Exception -> L65
        Object r13 = this.f12605x;     // Catch: Exception -> L65
        monitor-enter(r13);     // Catch: Exception -> L65
    L62:
        th = move-exception;
        throw th;     // Catch: Exception -> L65
    L14:
        if (this.K == true) goto L21;
        if (this.f1633i == false) goto L21;
        throw new IOException("request canceled");     // Catch: Throwable -> L62
    L21:
        if (this.B != null) goto L34;
        f.d().h(this.f12602u, false);     // Catch: Throwable -> L62
        if (this.E.size() <= 0) goto L30;
        if (this.E.get(0).f12614g == null) goto L30;
        throw this.E.get(0).f12614g;     // Catch: Throwable -> L62
    L30:
        if (this.K == false) goto L33;
        Q = "All urls have been tried and timed out by max wait time.";     // Catch: Throwable -> L62
    L35:
        monitor-exit(r13);     // Catch: Throwable -> L62
        q0();
    L53:
        e = move-exception;
    L56:
        th = th;
    L58:
        if (this.f1630c.N() == false) goto L60;
        if (r11 == true) goto L60;
    L61:
        throw th;
    L60:
        n();
        goto L61
    L55:
        throw w0(e, this.f12597p, this.B, true);     // Catch: Throwable -> L56
    L51:
        th = th;
        r11 = false;
        goto L58
    L38:
        if (this.C > 0) goto L40;
    L45:
        f.d().h(this.f12602u, true);     // Catch: Throwable -> L51 Exception -> L53
        List<String> r14 = N(this.f1630c, this.f1631g, this, true, true);     // Catch: Throwable -> L51 Exception -> L53
        F(this.f1631g, this);     // Catch: Throwable -> L51 Exception -> L53
        r4.e r15 = com.bytedance.frameworks.baselib.network.http.impl.a.L(this.f12597p, this.f1630c, this.f1631g, this, this, this, false);     // Catch: Throwable -> L51 Exception -> L53
        H(r15);     // Catch: Throwable -> L51 Exception -> L53
        n4.d r16 = new n4.d(this.f12597p, this.f12593l, this.B.getResponseMessage(), com.bytedance.frameworks.baselib.network.http.impl.a.t(this, r14), r15);     // Catch: Throwable -> L51 Exception -> L53
        r16.k(this.f1631g);     // Catch: Throwable -> L51 Exception -> L53
    L47:
        if (this.f1630c.N() == true) goto L50;
        n();
    L50:
        return r16;
    L40:
        if (TextUtils.isEmpty(this.f12603v) == true) goto L45;
        if (Logger.debug() == false) goto L44;
        Logger.e("ConcurrentCronetSsCall", "winner is " + this.C + " url is " + this.B.getURL().getHost());     // Catch: Throwable -> L51 Exception -> L53
    L44:
        A0(new URL(this.f12604w.get(this.C)).getHost(), this.f12603v);     // Catch: Throwable -> L51 Exception -> L53
        goto L45
    L33:
        throw w0(new IOException("All urls have been tried and timed out by max wait time."), this.f12597p, this.B, false);     // Catch: Throwable -> L62
    L34:
        this.f12607z.remove(this.B);     // Catch: Throwable -> L62
    L65:
        e = move-exception;
        q0();
        if (this.B != null) goto L73;
        if (this.D == null) goto L73;
        throw w0(e, this.f12597p, this.D, true);
    L73:
        throw w0(e, this.f12597p, this.B, true);
    L75:
        throw new IOException("request canceled");
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (r10 == null) goto L21;
        Object r11 = r10.obj;
        if ((r11 instanceof d) == false) goto L22;
        int r12 = r10.what;     // Catch: Throwable -> L14
        if (r12 != 0) goto L9;
        ((d) r11).t0();     // Catch: Throwable -> L14
    L17:
        return;
    L9:
        if (r12 != 1) goto L17;
        ((d) r11).u0();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L22:
        return;
    }

    public Boolean v0(String r10, a r11) {
        if (TTNetInitMetrics.l() == false) goto L23;
        if (r11 == null) goto L23;
        new URL(r10).toURI();     // Catch: Exception -> L19
        if (this.f12606y.get() != 0) goto L11;
        this.f12599r = r10;     // Catch: Exception -> L19
        this.f12600s = r11;     // Catch: Exception -> L19
        return Boolean.FALSE;
    L11:
        if (this.f12606y.get() != 1) goto L13;
        this.f12598q.add(s0(this.f12599r, this.f12600s));     // Catch: Exception -> L19
    L13:
        s0(r10, r11);     // Catch: Exception -> L19
        if (this.f12598q.contains(r11.f12615h) == false) goto L17;
        Boolean r12 = Boolean.TRUE;     // Catch: Exception -> L19
        r11.f12617j = r12;     // Catch: Exception -> L19
        return r12;
    L17:
        this.f12598q.add(r11.f12615h);     // Catch: Exception -> L19
        return Boolean.FALSE;
    L19:
        e = move-exception;
        e.printStackTrace();
        return Boolean.TRUE;
    L23:
        if (Logger.debug() == false) goto L26;
        Logger.e("ConcurrentCronetSsCall", "cronet did not init, dispatch fail");
    L26:
        return Boolean.TRUE;
    }
}
