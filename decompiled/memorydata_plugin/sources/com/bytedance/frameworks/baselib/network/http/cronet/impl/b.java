package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.net.Uri;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.j;
import com.bytedance.retrofit2.PriorityLevel;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.mime.TypedInput;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes2.dex */
class b extends com.bytedance.frameworks.baselib.network.http.cronet.impl.a implements WeakHandler.IHandler {
    private static HandlerThread E = null;
    private static boolean H = false;
    private static Class M = null;
    private static String N = null;
    static final /* synthetic */ boolean e = true;
    private volatile com.bytedance.frameworks.baselib.network.http.b A;
    private List<a> B;
    private volatile int C;
    private CountDownLatch D;
    private WeakHandler F;
    private long G;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private boolean f2410J;
    private long K;
    private long L;
    private String k;
    private Set<String> l;
    private String m;
    private a n;
    private String o;
    private String p;
    private String q;
    private List<String> r;
    private final Object s;
    private volatile AtomicInteger t;
    private List<HttpURLConnection> u;
    private volatile boolean v;
    private volatile HttpURLConnection w;
    private volatile int x;
    private volatile com.bytedance.frameworks.baselib.network.http.b y;
    private volatile HttpURLConnection z;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f2412b;
        long c;
        long d;
        int e;
        int f;
        IOException g;
        String h;
        long i;
        Boolean j;
        long k;
        com.bytedance.frameworks.baselib.network.http.b l;

        a(String r4) {
            this.f2411a = -1;
            this.f2412b = r4;
            this.c = System.currentTimeMillis();
            this.e = 0;
            this.f = -1;
            this.h = "";
            this.i = -1;
            this.j = false;
            this.k = -1;
        }

        JSONObject a() {
            JSONObject r0 = new JSONObject();
            r0.put("host", this.f2412b);     // Catch: JSONException -> L18
            r0.put(CommonConsts.APM_INNER_EVENT_COST_START, this.c);     // Catch: JSONException -> L18
            r0.put("end", this.d);     // Catch: JSONException -> L18
            r0.put("net_error", this.e);     // Catch: JSONException -> L18
            r0.put("code", this.f);     // Catch: JSONException -> L18
            IOException r1 = this.g;     // Catch: JSONException -> L18
            if (r1 == null) goto L11;
            String r2 = r1.getMessage();     // Catch: JSONException -> L18
            if (TextUtils.isEmpty(r2) == false) goto L8;
        L10:
            r0.put(CommonConsts.LOG_REPORT_TYPE_EXCEPTION, r2);     // Catch: JSONException -> L18
            goto L11
        L8:
            if (r2.length() <= 64) goto L10;
            r2 = r2.substring(0, 64);     // Catch: JSONException -> L18
        L11:
            r0.put("dispatch", this.i);     // Catch: JSONException -> L18
            r0.put("dpHost", this.h);     // Catch: JSONException -> L18
            if (this.j.booleanValue() == false) goto L14;
            r0.put("sentAlready", true);     // Catch: JSONException -> L18
        L14:
            long r3 = this.k;     // Catch: JSONException -> L18
            if (r3 <= 0) goto L17;
            r0.put("cleanUpTime", r3);     // Catch: JSONException -> L18
        L17:
            return r0;
        }
    }

    static {
        E = new HandlerThread("Concurrent-Handler");
        N = null;
        M = ZeusTransformUtils.forName("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl", "com.obric.memorydata.plugin");     // Catch: ClassNotFoundException -> L5
    L7:
        E.start();
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public b(Request r11, e.a r12) {
        super(r11);
        this.l = new CopyOnWriteArraySet();
        this.m = "";
        this.n = null;
        this.r = new ArrayList();
        this.s = new Object();
        int r2 = 0;
        this.t = new AtomicInteger(0);
        this.u = new CopyOnWriteArrayList();
        this.v = false;
        this.w = null;
        this.x = -1;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = new CopyOnWriteArrayList();
        this.C = 0;
        this.D = new CountDownLatch(1);
        this.F = new WeakHandler(E.getLooper(), this);
        this.f2410J = false;
        this.K = 0;
        String r0 = r11.getUrl();
        this.k = r0;
        Uri r1 = Uri.parse(r0);
        String r3 = r1.getScheme();
        String r4 = r3 + "://" + r1.getHost();
        String r5 = r1.getQuery();
        Iterator<String> r6 = r12.a().iterator();
    L4:
        if (r6.hasNext() == false) goto L15;
        String r7 = this.k.replaceFirst(r4, r3 + "://" + ((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin")));
        if (TextUtils.isEmpty(r5) == true) goto L14;
        if (r5.contains("concurrent=") == true) goto L10;
        r7 = r7 + "&concurrent=" + r2;
    L10:
        if (r2 <= 0) goto L14;
        if (r5.contains("is_retry=") == true) goto L14;
        r7 = r7 + "&is_retry=1";
    L14:
        r2 = r2 + 1;
        this.r.add(r7);
        goto L4
    L15:
        boolean r8 = e;
        if (r8 == false) goto L18;
    L22:
        this.o = UUID.randomUUID().toString();
        this.p = r12.i;
        this.q = r12.p;
        this.G = r12.m;
        H = r12.n;
        this.I = r12.o;
        this.K = r12.r;
        this.f2410J = r12.q;
        a(r11);
        if (Logger.debug() == false) goto L25;
        Logger.d("ConcurrentCronetSsCall", "Request max wait time milliseconds: " + this.L + ", user max wait time: " + this.K + ", connect interval milliseconds: " + this.G);
    L25:
        if (r8 == false) goto L27;
    L31:
        this.g.d.transactionId = this.o;
        this.g.d.isConcurrent = true;
        return;
    L27:
        if (this.g.d != null) goto L31;
        throw new AssertionError();
    L18:
        if (this.r.size() >= 2) goto L22;
        throw new AssertionError();
    }

    private com.bytedance.frameworks.baselib.network.http.b a(com.bytedance.frameworks.baselib.network.http.b r2) {
        com.bytedance.frameworks.baselib.network.http.b r1 = com.bytedance.frameworks.baselib.network.http.b.a();
        if (r2.d == null) goto L5;
        r1.a(r2.d.deepCopy());
    L5:
        r1.L = r2.L;
        r1.c = r2.c;
        if (r2.Z == null) goto L8;
        r1.Z = r2.Z.d();
    L8:
        r1.G = r2.G;
        if (r1.K == null) goto L12;
        r1.K = new JSONObject(r1.K.toString());     // Catch: Exception -> L13
    L12:
        return r1;
    }

    private IOException a(Exception r8, String r9, HttpURLConnection r10, boolean r11) {
        if (this.f2410J == false) goto L5;
    L12:
        int r0 = 0;
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r8.getClass().getName()) == false) goto L15;
    L16:
        r0 = h.a(r10);
    L18:
        if (TextUtils.isEmpty(r9) == false) goto L20;
        r9 = this.k;
    L20:
        String r4 = r9;
        if (r11 == true) goto L29;
        if (r10 == null) goto L29;
        r10.disconnect();
    L29:
        a(this.f, r8);     // Catch: NetworkNotAvailabeException -> L27
        CronetIOException r12 = new CronetIOException(r8, this.g, r0);
        r12.setInfo(false, r11, r4, this.g.P, this.g);
        return r12;
    L27:
        e = move-exception;
        return e;
    L15:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r8.getClass().getName()) == false) goto L18;
    L5:
        if (ZeusTransformUtils.instanceOf(r8, IOException.class) == false) goto L12;
        if (r8.getMessage() == null) goto L12;
        if (r8.getMessage().startsWith("request canceled") == false) goto L12;
        return (IOException) ZeusTransformUtils.preCheckCast(r8, IOException.class, "com.obric.memorydata.plugin");
    }

    private void a(long r3, com.bytedance.frameworks.baselib.network.http.b r5) {
        Message r0 = Message.obtain();
        r0.what = 0;
        r0.obj = new Pair(this, r5);
        this.F.sendMessageDelayed(r0, r3);
    }

    private /* synthetic */ void a(com.bytedance.frameworks.baselib.network.http.b r18, com.bytedance.frameworks.baselib.network.http.b r19) {
        long r10 = SystemClock.uptimeMillis();
        HttpURLConnection r12 = null;
        String r13 = null;
        r12 = null;
        r12 = null;
        r12 = null;
        Object r2 = this.s;     // Catch: IOException -> L107
        monitor-enter(r2);     // Catch: IOException -> L107
    L99:
        th = th;
        String r14 = null;
        a r15 = null;
    L101:
        monitor-exit(r2);     // Catch: Throwable -> L105
        throw th;     // Catch: IOException -> L103
    L103:
        e = e;
    L109:
        Object r3 = this.s;
        monitor-enter(r3);
        int r4 = -1;
        Class r5 = M;     // Catch: Throwable -> L167
        if (r5 == null) goto L177;
        if (ZeusTransformUtils.instanceOf(r5, e) == false) goto L177;
        r4 = ((Integer) ZeusTransformUtils.preCheckCast(com.bytedance.frameworks.baselib.network.utils.a.a(e).call("getCronetInternalErrorCode").a(), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L167
        if (Logger.debug() == false) goto L177;
        Logger.d("ConcurrentCronetSsCall", "cronet error code: " + r4);     // Catch: Throwable -> L167
    L177:
    L164:
        th = move-exception;
        throw th;
    L120:
        if (this.z != null) goto L126;
        if (Logger.debug() == false) goto L124;
        Logger.d("ConcurrentCronetSsCall", "Get first failed connection " + r12.getURL().toString());     // Catch: Throwable -> L164
    L124:
        this.z = r12;     // Catch: Throwable -> L164
        this.A = r18;     // Catch: Throwable -> L164
    L128:
        if (r12 == null) goto L133;
        r12.disconnect();     // Catch: Throwable -> L164
        if (r15 == null) goto L132;
        r15.g = a(e, r14, r12, false);     // Catch: Throwable -> L164
        r15.e = r4;     // Catch: Throwable -> L164
        r15.d = System.currentTimeMillis();     // Catch: Throwable -> L164
    L132:
        this.u.remove(r12);     // Catch: Throwable -> L164
    L133:
        int r0 = this.C + 1;     // Catch: Throwable -> L164
        this.C = r0;     // Catch: Throwable -> L164
        if (r0 < this.r.size()) goto L142;
        if (Logger.debug() == false) goto L138;
        Logger.d("ConcurrentCronetSsCall", "Try all urls failed countdown.");     // Catch: Throwable -> L164
    L138:
        this.D.countDown();     // Catch: Throwable -> L164
        monitor-exit(r3);     // Catch: Throwable -> L164
        return;
    L142:
        if (this.f2410J == false) goto L152;
        if (this.i == false) goto L152;
        if (Logger.debug() == false) goto L148;
        Logger.d("ConcurrentCronetSsCall", "User canceled.");     // Catch: Throwable -> L164
    L148:
        this.D.countDown();     // Catch: Throwable -> L164
        monitor-exit(r3);     // Catch: Throwable -> L164
        return;
    L152:
        if (e.a().a(r4, this.p) == false) goto L160;
        if (Logger.debug() == false) goto L156;
        Logger.d("ConcurrentCronetSsCall", "inBlockErrorCode countdown.");     // Catch: Throwable -> L164
    L156:
        this.D.countDown();     // Catch: Throwable -> L164
        monitor-exit(r3);     // Catch: Throwable -> L164
        return;
    L160:
        if ((SystemClock.uptimeMillis() - r10) >= this.G) goto L162;
        d(r19);     // Catch: Throwable -> L164
    L162:
        monitor-exit(r3);     // Catch: Throwable -> L164
        return;
    L126:
        if (Logger.debug() == false) goto L128;
        Logger.d("ConcurrentCronetSsCall", "Get non first failed connection " + r12.getURL().toString());     // Catch: Throwable -> L164
        goto L128
    L6:
        if (this.t.get() < this.r.size()) goto L8;
    L96:
        this.F.removeCallbacksAndMessages(null);     // Catch: Throwable -> L99
        monitor-exit(r2);     // Catch: Throwable -> L99
        return;
    L8:
        if (this.w != null) goto L96;
        if (this.D.getCount() == 0) goto L96;
        if (this.i == true) goto L96;
        int r1 = this.t.get();     // Catch: Throwable -> L99
        String r6 = (String) ZeusTransformUtils.preCheckCast(this.r.get(r1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L99
    L93:
        th = th;
        r14 = r6;
    L95:
        r15 = null;
        goto L101
    L16:
        if (this.q == null) goto L19;
        if (r1 <= 0) goto L19;
        j r7 = new j(r6);     // Catch: Throwable -> L93
        r7.a("bypass_rs", "1");     // Catch: Throwable -> L93
        r6 = r7.a();     // Catch: Throwable -> L93
    L19:
        r14 = r6;
        r15 = new a(new URL(r14).getHost());     // Catch: Throwable -> L91
        r15.l = r18;     // Catch: Throwable -> L105
        this.B.add(r15);     // Catch: Throwable -> L105
        if (this.q == null) goto L38;
        if (a(r14, r15).booleanValue() == false) goto L38;
        if (r1 <= 0) goto L38;
        this.C++;     // Catch: Throwable -> L105
        if (this.C >= this.r.size()) goto L29;
        this.t.incrementAndGet();     // Catch: Throwable -> L105
        d(r19);     // Catch: Throwable -> L105
        monitor-exit(r2);     // Catch: Throwable -> L105
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d("ConcurrentCronetSsCall", "Try all urls failed countdown.");     // Catch: Throwable -> L105
    L31:
        this.D.countDown();     // Catch: Throwable -> L105
        monitor-exit(r2);     // Catch: Throwable -> L105
        return;
    L38:
        if (Logger.debug() == false) goto L40;
        Logger.d("ConcurrentCronetSsCall", "ConstructURLConnection and execute index: " + this.t.get() + " url: " + r14);     // Catch: Throwable -> L105
    L40:
        r18.d.prepareConnectionStart();     // Catch: Throwable -> L105
        HttpURLConnection r16 = a(r14, r18);     // Catch: Throwable -> L105
        a(this.f, r18, r16, null);     // Catch: Throwable -> L89
        r18.d.prepareConnectionEnd();     // Catch: Throwable -> L89
        if (this.I == true) goto L44;
    L46:
        r16.setRequestProperty("transaction-id", this.o);     // Catch: Throwable -> L89
        this.t.incrementAndGet();     // Catch: Throwable -> L89
        this.u.add(r16);     // Catch: Throwable -> L89
        r15.f2411a = r16.hashCode();     // Catch: Throwable -> L89
        monitor-exit(r2);     // Catch: Throwable -> L89
        long r8 = r18.d.executeConnectionStart();     // Catch: IOException -> L87
        this.f2409a = b(r16);     // Catch: Throwable -> L84
        r18.d.executeConnectionEnd(r8);     // Catch: IOException -> L87
        r15.f = this.f2409a;     // Catch: IOException -> L87
        r15.d = System.currentTimeMillis();     // Catch: IOException -> L87
        if (a(this.f2409a, r16.getHeaderField("tt-api-source-5xx"), this.p) == true) goto L67;
        Object r9 = this.s;     // Catch: IOException -> L87
        monitor-enter(r9);     // Catch: IOException -> L87
    L64:
        th = move-exception;
        throw th;     // Catch: IOException -> L87
    L55:
        if (this.w != null) goto L60;
        this.w = r16;     // Catch: Throwable -> L64
        this.x = r1;     // Catch: Throwable -> L64
        this.y = r18;     // Catch: Throwable -> L64
        this.k = r14;     // Catch: Throwable -> L64
        if (Logger.debug() == false) goto L59;
        Logger.d("ConcurrentCronetSsCall", "winnerindex is " + this.x);     // Catch: Throwable -> L64
    L59:
        this.D.countDown();     // Catch: Throwable -> L64
    L62:
        monitor-exit(r9);     // Catch: Throwable -> L64
    L192:
        return;
    L60:
        if (r16 == null) goto L62;
        r16.disconnect();     // Catch: Throwable -> L64
        this.u.remove(r16);     // Catch: Throwable -> L64
        goto L62
    L67:
        String r17 = r16.getResponseMessage();     // Catch: IOException -> L87
        int r11 = this.f.getMaxLength();     // Catch: Throwable -> L77
        InputStream r20 = r16.getInputStream();     // Catch: Exception -> L71 Throwable -> L77
    L70:
        InputStream r21 = r20;
        String r22 = r16.getHeaderField(NetConst.KEY_CONTENT_TYPE);     // Catch: Throwable -> L77
        if (TextUtils.isEmpty(r22) == false) goto L75;
        r22 = r16.getHeaderField(NetConst.KEY_CONTENT_TYPE.toLowerCase());     // Catch: Throwable -> L77
    L75:
        r13 = a(r18, r16.getHeaderFields(), r11, r21, r22, false);     // Catch: Throwable -> L77
    L83:
        throw new HttpResponseException(this.f2409a, r17, this.f.getPath(), r13);     // Catch: IOException -> L87
    L71:
        r20 = r16.getErrorStream();     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        th.printStackTrace();     // Catch: IOException -> L87
        StringBuilder r23 = new StringBuilder().append("reason = ");     // Catch: IOException -> L87
        if (r17 != null) goto L81;
        r17 = "";
    L81:
        r17 = r23.append(r17).append("  exception = ").append(th.getMessage()).toString();     // Catch: IOException -> L87
        goto L83
    L84:
        th = move-exception;
        r18.d.executeConnectionEnd(r8);     // Catch: IOException -> L87
        throw th;     // Catch: IOException -> L87
    L87:
        e = e;
        r12 = r16;
        goto L109
    L44:
        if (this.q != null) goto L46;
        r16.setRequestProperty("x-tt-bp-rs", "1");     // Catch: Throwable -> L89
    L89:
        th = th;
        r12 = r16;
    L91:
        th = th;
    L105:
        th = th;
    L107:
        e = e;
        r14 = null;
        r15 = null;
        goto L109
    }

    private void a(Request r5) {
        this.L = com.bytedance.frameworks.baselib.network.http.f.a() + com.bytedance.frameworks.baselib.network.http.f.b();
        if (ZeusTransformUtils.instanceOf(r5.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L13;
        com.bytedance.frameworks.baselib.network.http.c r6 = (com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r5.getExtraInfo(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.memorydata.plugin");
        if (r6.i <= 0) goto L9;
        long r0 = r6.i;
    L7:
        this.L = r0;
        goto L13
    L9:
        if (r6.c <= 0) goto L13;
        if (r6.d <= 0) goto L13;
        r0 = r6.c + r6.d;
    L13:
        this.L += 1000;
    }

    private void a(String r1, String r2) {
        h.a(r1, r2);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private static boolean a(int r3, String r4, String r5) {
        if (r3 < 200) goto L6;
        if (r3 >= 300) goto L6;
        return false;
    L6:
        if (r4 != null) goto L8;
    L10:
        if (r3 < 300) goto L17;
        if (r3 >= 600) goto L17;
        if (H == true) goto L17;
        return false;
    L17:
        if (e.a().a(r3, r5) == false) goto L19;
        return false;
    L19:
        return true;
    L8:
        if (r4.equals("1") == false) goto L10;
        return false;
    }

    private String b(String r5, a r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        long r0 = System.currentTimeMillis();
        String r4 = h.a(r5, -1, true).a();     // Catch: Exception -> L17
        r6.i = System.currentTimeMillis() - r0;
        r6.h = new URI(r4).getHost();     // Catch: URISyntaxException -> L14
        if (Logger.debug() == false) goto L13;
        Logger.e("ConcurrentCronetSsCall", "url is " + r5 + " dispatchedUrl is " + r4);
    L13:
        return r6.h;
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L17:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void b(com.bytedance.frameworks.baselib.network.http.b r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        r3.d.copyTo(this.g.d);
        r3.d = this.g.d;
        this.g = r3;
    }

    private void c(final com.bytedance.frameworks.baselib.network.http.b r10) {
        final com.bytedance.frameworks.baselib.network.http.b r0 = a(r10);
        com.bytedance.frameworks.baselib.network.http.b r1 = a(r10);
        com.bytedance.frameworks.baselib.network.dispatcher.a r8 = new com.bytedance.frameworks.baselib.network.dispatcher.a("Concurrent-Call", IRequest.Priority.IMMEDIATE, 0, new $$Lambda$b$DlmSMEejICGj4bEiEUAjoGgVV6Y(this, r10, r0), this.g.L);
        com.bytedance.frameworks.baselib.network.dispatcher.e.b().b(r8);
        a(this.G, r1);
    }

    private void d(com.bytedance.frameworks.baselib.network.http.b r3) {
        Message r0 = Message.obtain();
        r0.what = 1;
        r0.obj = new Pair(this, r3);
        this.F.sendMessage(r0);
    }

    private void e(com.bytedance.frameworks.baselib.network.http.b r3) {
        if (this.F.obtainMessage(0) == null) goto L6;
        this.F.removeMessages(0);
        c(r3);
        return;
    }

    public static /* synthetic */ void lambda$DlmSMEejICGj4bEiEUAjoGgVV6Y(b r0, com.bytedance.frameworks.baselib.network.http.b r1, com.bytedance.frameworks.baselib.network.http.b r2) {
        r0.a(r1, r2);
    }

    private void p() {
        this.F.removeCallbacksAndMessages(null);
        Object r0 = this.s;
        monitor-enter(r0);
    L33:
        th = move-exception;
        throw th;
    L5:
        if (this.v == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L33
        return;
    L8:
        Iterator<HttpURLConnection> r1 = this.u.iterator();     // Catch: Throwable -> L33
    L10:
        if (r1.hasNext() == false) goto L24;
        HttpURLConnection r2 = (HttpURLConnection) ZeusTransformUtils.preCheckCast(r1.next(), HttpURLConnection.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        if (r2 == null) goto L10;
        Iterator<a> r3 = this.B.iterator();     // Catch: Throwable -> L33
    L15:
        if (r3.hasNext() == false) goto L22;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L33
        if (r4.f2411a != r2.hashCode()) goto L15;
        r4.d = System.currentTimeMillis();     // Catch: Throwable -> L33
        if (this.f2410J == false) goto L21;
        r4.k = System.currentTimeMillis();     // Catch: Throwable -> L33
        goto L22
    L21:
        r4.e = PriorityLevel.INVALID;     // Catch: Throwable -> L33
        r4.g = new IOException("cleanupMessagesAndPendingConnections");     // Catch: Throwable -> L33
    L22:
        r2.disconnect();     // Catch: Throwable -> L33
        this.u.remove(r2);     // Catch: Throwable -> L33
        goto L10
    L24:
        if (e == false) goto L26;
    L30:
        RetrofitMetrics r5 = this.g.d;     // Catch: Throwable -> L33
        r5.concurrentRequest = q();     // Catch: Throwable -> L33
        this.v = true;     // Catch: Throwable -> L33
        monitor-exit(r0);     // Catch: Throwable -> L33
        return;
    L26:
        if (this.g.d != null) goto L30;
        throw new AssertionError();     // Catch: Throwable -> L33
    }

    private JSONObject q() {
        JSONObject r0 = new JSONObject();
        r0.put("concurrent", this.B.size() - 1);     // Catch: JSONException -> L14
        r0.put("duration", System.currentTimeMillis() - this.g.g);     // Catch: JSONException -> L14
        if (this.f2410J == true) goto L6;
    L8:
        JSONArray r1 = new JSONArray();     // Catch: JSONException -> L14
        Iterator<a> r6 = this.B.iterator();     // Catch: JSONException -> L14
    L10:
        if (r6.hasNext() == false) goto L12;
        r1.put(((a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.memorydata.plugin")).a());     // Catch: JSONException -> L14
        goto L10
    L12:
        r0.put("tasks", r1);     // Catch: JSONException -> L14
    L16:
        return r0;
    L6:
        if (TextUtils.isEmpty(N) == true) goto L8;
        r0.put("call_msg", N);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public Boolean a(String r6, a r7) {
        if (TTNetInitMetrics.a() == false) goto L23;
        if (r7 == null) goto L23;
        new URL(r6).toURI();     // Catch: Exception -> L19
        if (this.t.get() != 0) goto L11;
        this.m = r6;     // Catch: Exception -> L19
        this.n = r7;     // Catch: Exception -> L19
        return false;
    L11:
        if (this.t.get() != 1) goto L13;
        this.l.add(b(this.m, this.n));     // Catch: Exception -> L19
    L13:
        b(r6, r7);     // Catch: Exception -> L19
        if (this.l.contains(r7.h) == false) goto L17;
        r7.j = true;     // Catch: Exception -> L19
        return true;
    L17:
        this.l.add(r7.h);     // Catch: Exception -> L19
        return false;
    L19:
        e = move-exception;
        e.printStackTrace();
        return true;
    L23:
        if (Logger.debug() == false) goto L25;
        Logger.e("ConcurrentCronetSsCall", "cronet did not init, dispatch fail");
    L25:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.a
    public HttpURLConnection b() {
        if (this.w == null) goto L6;
        return this.w;
    L6:
        return this.z;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        if (Logger.debug() == false) goto L5;
        Logger.d("ConcurrentCronetSsCall", "cancel countdown.");
    L5:
        Object r0 = this.s;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f2410J == true) goto L10;
        this.D.countDown();     // Catch: Throwable -> L13
    L10:
        p();     // Catch: Throwable -> L13
        c(this.w);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.a, com.bytedance.retrofit2.client.SsCall
    public Response execute() {
        if (this.i == true) goto L78;
        a(this.f, this.g);
        o();
        c(a(this.g));
        long r2 = this.L;     // Catch: Throwable -> L63 Exception -> L65
        if (this.f2410J == false) goto L8;
        r2 = Math.max(r2, this.K);     // Catch: Throwable -> L63 Exception -> L65
    L8:
        this.D.await(r2, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L63 Exception -> L65
        this.D.countDown();     // Catch: Throwable -> L63 Exception -> L65
        Object r3 = this.s;     // Catch: Throwable -> L63 Exception -> L65
        monitor-enter(r3);     // Catch: Throwable -> L63 Exception -> L65
    L60:
        th = move-exception;
        throw th;     // Catch: Throwable -> L63 Exception -> L65
    L11:
        if (this.f2410J == true) goto L18;
        if (this.i == false) goto L18;
        throw new IOException("request canceled");     // Catch: Throwable -> L60
    L18:
        if (this.w != null) goto L31;
        b(this.A);     // Catch: Throwable -> L60
        e.a().a(this.p, false);     // Catch: Throwable -> L60
        if (this.B.size() <= 0) goto L27;
        if (((a) ZeusTransformUtils.preCheckCast(this.B.get(0), a.class, "com.obric.memorydata.plugin")).g == null) goto L27;
        b(((a) ZeusTransformUtils.preCheckCast(this.B.get(0), a.class, "com.obric.memorydata.plugin")).l);     // Catch: Throwable -> L60
        throw ((a) ZeusTransformUtils.preCheckCast(this.B.get(0), a.class, "com.obric.memorydata.plugin")).g;     // Catch: Throwable -> L60
    L27:
        if (this.f2410J == false) goto L30;
        N = "All urls have been tried and timed out by max wait time.";     // Catch: Throwable -> L60
    L32:
        monitor-exit(r3);     // Catch: Throwable -> L60
        p();
    L48:
        th = move-exception;
        if (0 == 0) goto L56;
        a(this.g, this, null);
    L56:
        if (this.f.isResponseStreaming() == false) goto L58;
        if (0 != 0) goto L58;
    L59:
        throw th;
    L58:
        k();
    L50:
        e = move-exception;
        throw a(e, this.k, this.w, true);     // Catch: Throwable -> L48
    L35:
        if (this.x > 0) goto L37;
    L42:
        e.a().a(this.p, true);     // Catch: Throwable -> L48 Exception -> L50
        List<String> r4 = a(this.f, this.g, this, true, true);     // Catch: Throwable -> L48 Exception -> L50
        a(this.g, this);     // Catch: Throwable -> L48 Exception -> L50
        TypedInput r11 = a(this.k, this.f, this.g, this, this);     // Catch: Throwable -> L48 Exception -> L50
        a(r11);     // Catch: Throwable -> L48 Exception -> L50
        Response r5 = new Response(this.k, this.f2409a, this.w.getResponseMessage(), a(this, r4), r11);     // Catch: Throwable -> L48 Exception -> L50
        r5.setExtraInfo(this.g);     // Catch: Throwable -> L48 Exception -> L50
    L44:
        if (this.f.isResponseStreaming() == true) goto L47;
        k();
    L47:
        return r5;
    L37:
        if (TextUtils.isEmpty(this.q) == true) goto L42;
        if (Logger.debug() == false) goto L41;
        Logger.e("ConcurrentCronetSsCall", "winner is " + this.x + " url is " + this.w.getURL().getHost());     // Catch: Throwable -> L48 Exception -> L50
    L41:
        a(new URL((String) ZeusTransformUtils.preCheckCast(this.r.get(this.x), String.class, "com.obric.memorydata.plugin")).getHost(), this.q);     // Catch: Throwable -> L48 Exception -> L50
        goto L42
    L30:
        throw a(new IOException("All urls have been tried and timed out by max wait time."), this.k, this.w, false);     // Catch: Throwable -> L60
    L31:
        b(this.y);     // Catch: Throwable -> L60
        this.u.remove(this.w);     // Catch: Throwable -> L60
    L65:
        e = move-exception;
        p();     // Catch: Throwable -> L63
        if (this.w != null) goto L73;
        if (this.z == null) goto L73;
        throw a(e, this.k, this.z, true);     // Catch: Throwable -> L63
    L73:
        throw a(e, this.k, this.w, true);     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        if (0 == 0) goto L76;
        a(this.g, this, null);
    L76:
        throw th;
    L78:
        throw new IOException("request canceled");
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r4) {
        if (r4 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4.obj, Pair.class) == false) goto L23;
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(r4.obj, Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.first, b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        com.bytedance.frameworks.baselib.network.http.b r3 = (com.bytedance.frameworks.baselib.network.http.b) ZeusTransformUtils.preCheckCast(r0.second, com.bytedance.frameworks.baselib.network.http.b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        int r5 = r4.what;     // Catch: Throwable -> L15
        if (r5 != 0) goto L10;
        r1.c(r3);     // Catch: Throwable -> L15
    L18:
        return;
    L10:
        if (r5 != 1) goto L18;
        r1.e(r3);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.a, com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r8) {
        super.setThrottleNetSpeed(r8);
        if (this.w != null) goto L16;
    L14:
        return true;
    L16:
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    L7:
        if (com.bytedance.frameworks.baselib.network.http.f.d() == false) goto L9;
        com.bytedance.frameworks.baselib.network.utils.a.a(this.w).call("configureConnection", new Class[]{String.class, Object[].class}, new Object[]{"setThrottleNetSpeed", new Object[]{Long.valueOf(r8)}});     // Catch: Throwable -> L11
    L15:
        goto L14
    L9:
        com.bytedance.frameworks.baselib.network.utils.a.a(this.w).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r8)});     // Catch: Throwable -> L11
        goto L15
    }
}
