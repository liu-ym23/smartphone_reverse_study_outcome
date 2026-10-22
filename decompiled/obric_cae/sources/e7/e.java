package e7;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.obric.cae.statusReport.network.NetworkReportUtil;
import d7.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements WeakHandler.IHandler {
    public static final ExecutorService B = null;
    public static volatile e C;
    public static String D;
    public static HandlerThread E;
    public static WeakHandler F;
    public final a A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f7168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f7169b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile String f7170m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ConcurrentSkipListSet<String> f7171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap f7172o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentSkipListSet<String> f7173p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f7174q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f7175r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final AtomicInteger f7176s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AtomicInteger f7177t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final AtomicInteger f7178u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AtomicInteger f7179v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d f7180w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d7.f f7181x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile g f7182y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7183z;

    public class a extends Handler {
        @Override // android.os.Handler
        public final void handleMessage(Message r8) {
            super.handleMessage(r8);
            if (r8 != null) goto L5;
            return;
        L5:
            if ((r8.obj instanceof e) == false) goto L17;
            Bundle r10 = r8.getData();
            b r11 = (b) r10.getSerializable("callback_dnsresult_key");
            if (((c) r10.getSerializable("callback_dnsresult_job_key")) != null) goto L12;
            ExecutorService r12 = e.B;
            Logger.d("e", "callback job is null");
            return;
        L12:
            if (r8.what == 1) goto L14;
            return;
        L14:
            ExecutorService r13 = e.B;
            Logger.d("e", "callback dns result for host null in thread " + Thread.currentThread().getName());
            throw null;
        }
    }

    static {
        B = Executors.newFixedThreadPool(6);
    }

    public e() {
        this.f7168a = new AtomicBoolean(true);
        this.f7169b = new AtomicBoolean(false);
        this.f7171n = new ConcurrentSkipListSet();
        this.f7172o = new ConcurrentHashMap();
        this.f7173p = new ConcurrentSkipListSet();
        this.f7174q = new AtomicInteger(30);
        this.f7175r = new AtomicInteger(NetworkReportUtil.INTERVENTION_REPORT_EVENT_DELAY);
        this.f7176s = new AtomicInteger(60);
        this.f7177t = new AtomicInteger(0);
        this.f7178u = new AtomicInteger(5);
        this.f7179v = new AtomicInteger(5);
        this.f7181x = new d7.f();
        this.f7183z = false;
        this.A = new a(Looper.getMainLooper());
        Logger.d("e", "HttpDns constructor");
        HandlerThread r8 = new HandlerThread("TTOK-HTTPDNS");
        E = r8;
        r8.start();
        F = new WeakHandler(E.getLooper(), this);
        D = "4.0.76.2";
        this.f7180w = new d(F);
    }

    public static e g() {
        if (C != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (C != null) goto L9;
        C = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return C;
    }

    public static void o() {
        B.submit(new h());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public final void a(String r8) {
        ConcurrentSkipListSet<String> r10 = this.f7180w.f7163g;
        r10.add(r8);
        if (r10.size() < 10) goto L7;
        ArrayList r11 = new ArrayList();
        r11.addAll(r10);
        e r12 = g();
        r12.getClass();
        Logger.d("e", "batchRefreshHttpDnsStaleCache for host " + r11);
        r12.m(r11, e7.a.EnumC0065a.f7144o, false);
        return;
    }

    public final void b(c r8, b r10) {
        r8.getClass();
        Logger.d("e", "doDnsResultCallback for host null");
        Message r11 = Message.obtain();
        r11.obj = this;
        r11.what = 1;
        Bundle r12 = new Bundle();
        r12.putSerializable("callback_dnsresult_job_key", r8);
        r12.putSerializable("callback_dnsresult_key", r10);
        r11.setData(r12);
        this.A.sendMessage(r11);
    }

    public final synchronized void c(e7.a.EnumC0065a r8) {
        monitor-enter(this);
        ConcurrentSkipListSet<String> r10 = this.f7173p;     // Catch: Throwable -> L26
        if (r10 != null) goto L6;
    L24:
        monitor-exit(this);
        return;
    L6:
        if (r10.size() == 0) goto L24;
        if (this.f7173p.size() > 10) goto L24;
        Logger.d("e", "do httpdns preload");     // Catch: Throwable -> L26
        Iterator<String> r11 = this.f7173p.iterator();     // Catch: Throwable -> L26
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L26
    L12:
        if (r11.hasNext() == false) goto L18;
        String r13 = r11.next();     // Catch: Throwable -> L26
        if (this.f7180w.k(r13) == true) goto L12;
        r12.add(r13);     // Catch: Throwable -> L26
        goto L12
    L18:
        if (r12.size() != 0) goto L21;
        monitor-exit(this);
        return;
    L21:
        Logger.d("e", "httpdns batch preload for : " + r12);     // Catch: Throwable -> L26
        m(r12, r8, false);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public final b d(String r8) {
        Logger.d("e", "try to look up hardcode ips");
        ConcurrentHashMap r10 = this.f7172o;
        if (r10.containsKey(r8) == false) goto L17;
        b r11 = new b();
        Iterator r12 = ((CopyOnWriteArrayList) r10.get(r8)).iterator();
    L6:
        if (r12.hasNext() == false) goto L15;
        String r13 = (String) r12.next();
        if (f7.b.b(r13) == true) goto L9;
        if (f7.b.a(r13) == true) goto L12;
        Logger.d("e", "find a invalid hardcode ip: " + r13);
        goto L6
    L12:
        List<String> r14 = r11.f7146a;
    L13:
        r14.add(r13);
        goto L6
    L9:
        r14 = r11.f7147b;
        goto L13
    L15:
        r11.f7148m = b.a.f7155q;
        return r11;
    L17:
        return null;
    }

    public final b e(String r11) {
        Logger.d("e", "getHttpDnsResultForHostSyncBlock for host : " + r11);
        if (this.f7183z == true) goto L6;
        String r8 = "you have not set httpdns depend";
    L18:
        Logger.d("e", r8);
        boolean r10 = true;
    L19:
        if (r10 == false) goto L22;
        return null;
    L22:
        boolean r12 = r11.equals(this.f7170m);
        if (this.f7169b.get() == false) goto L63;
        if (r12 == true) goto L63;
        b r13 = i(r11, false);
        if (r13 == null) goto L28;
        return r13;
    L28:
        ArrayList r14 = new ArrayList();
        r14.add(0, Boolean.FALSE);
        e7.a r15 = this.f7180w.h(r11);
        if (r15 != null) goto L31;
    L32:
        r14.set(0, Boolean.TRUE);
        if (this.f7180w.l(r11) == true) goto L36;
        p(r11);
    L36:
        if (this.f7180w.k(r11) == false) goto L38;
        Logger.d("e", "httpdns is resolving for host ".concat(r11));
        Future<Void> r16 = this.f7180w.g(r11);
    L44:
        boolean r17 = ((Boolean) r14.get(0)).booleanValue();
        Logger.d("e", "getDnsResultInHttpDnsPreferTime");
        if (r16 != null) goto L48;
        Logger.d("e", "httpdns future is null");     // Catch: TimeoutException -> L56 ExecutionException -> L57 InterruptedException -> L58
    L54:
        b r18 = j(r11, r17);     // Catch: TimeoutException -> L56 ExecutionException -> L57 InterruptedException -> L58
    L86:
        if (r18 == null) goto L88;
        return r18;
    L88:
        return d(r11);
    L48:
        if (r16.isDone() == false) goto L52;
        Logger.d("e", "httpdns future is done");     // Catch: TimeoutException -> L56 ExecutionException -> L57 InterruptedException -> L58
        b r19 = i(r11, true);     // Catch: TimeoutException -> L56 ExecutionException -> L57 InterruptedException -> L58
        if (r19 == null) goto L54;
    L84:
        r18 = r19;
        goto L86
    L52:
        r16.get(g().f7175r.get(), TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L56 ExecutionException -> L57 InterruptedException -> L58
        r19 = i(r11, true);     // Catch: TimeoutException -> L56 ExecutionException -> L57 InterruptedException -> L58
        if (r19 != null) goto L84;
    L58:
        String r20 = "httpdns InterruptedException, look up localdns";
    L59:
        Logger.d("e", r20);
        r18 = j(r11, r17);
    L57:
        r20 = "httpdns ExecutionException, look up localdns";
    L56:
        r20 = "httpdns timeout in httpdns prefer time, look up localdns";
        goto L59
    L38:
        monitor-enter(this);
    L60:
        th = move-exception;
        throw th;
    L40:
        if (this.f7180w.k(r11) == false) goto L42;
        r16 = this.f7180w.g(r11);     // Catch: Throwable -> L60
    L43:
        monitor-exit(this);     // Catch: Throwable -> L60
        goto L44
    L42:
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L60
        r21.add(r11);     // Catch: Throwable -> L60
        r16 = m(r21, e7.a.EnumC0065a.f7140a, true);     // Catch: Throwable -> L60
        goto L43
    L31:
        if (((r15.f7137d * 1000) + r15.f7138e) > (System.currentTimeMillis() + ((long) this.f7175r.get()))) goto L36;
    L63:
        b r22 = j(r11, false);
        if (r22 == null) goto L67;
        return r22;
    L67:
        if (this.f7180w.l(r11) == false) goto L69;
        Future<Void> r23 = this.f7180w.j(r11);
    L70:
        if (r23 != null) goto L76;
        b r24 = f(r11, r12);
        if (r24 == null) goto L74;
        return r24;
    L74:
        return d(r11);
    L76:
        if (r23.isDone() == false) goto L90;
        r19 = j(r11, true);
        if (r19 != null) goto L84;
    L85:
        r18 = f(r11, r12);
        goto L86
    L90:
        r23.get(((long) this.f7179v.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L89
        r19 = j(r11, true);     // Catch: Exception -> L89
        if (r19 != null) goto L84;
        r18 = f(r11, r12);     // Catch: Exception -> L89
    L69:
        r23 = p(r11);
        goto L70
    L6:
        if (this.f7168a.get() == true) goto L9;
        r8 = "httpdns was unabled by tnc";
        goto L18
    L9:
        if (l6.a.h0(r11) == true) goto L12;
        r8 = "illegal host";
        goto L18
    L12:
        if (f7.b.a(r11) == false) goto L14;
    L17:
        r8 = "host is ipaddress";
        goto L18
    L14:
        if (f7.b.b(r11) == true) goto L17;
        r10 = false;
        goto L19
    }

    public final b f(String r8, boolean r10) {
        if (r10 == false) goto L5;
        return null;
    L5:
        d r11 = this.f7180w;
        if (r11.k(r8) == false) goto L8;
        Future<Void> r12 = r11.g(r8);
    L9:
        if (r12 != null) goto L12;
        return null;
    L12:
        if (r12.isDone() == true) goto L19;
        r12.get(((long) this.f7178u.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
        return i(r8, true);
    L20:
        return null;
    L19:
        return i(r8, true);
    L8:
        ArrayList r13 = new ArrayList();
        r13.add(r8);
        r12 = m(r13, e7.a.EnumC0065a.f7140a, true);
        goto L9
    }

    public final AtomicBoolean h() {
        return this.f7169b;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public final void handleMsg(Message r15) {
        Logger.d("e", "httpdns handler handle msg in " + Thread.currentThread().getName());
        if (r15 == null) goto L186;
        Object r8 = r15.obj;
        if ((r8 instanceof e) == false) goto L7;
    L170:
    L165:
        th = move-exception;
        th.printStackTrace();
        return;
    L16:
        int r10 = 0;
        if ((r8 instanceof e) == false) goto L29;
        if (r15.what != 2) goto L29;
        Logger.d("e", "MSG_HTTPDNS_PREFER_TIMEOUT");     // Catch: Throwable -> L165
        c r16 = (c) r15.getData().getSerializable("httpdns_timeout_job_key");     // Catch: Throwable -> L165
        if (r16 != null) goto L25;
        Logger.d("e", "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L165
        return;
    L25:
        if (this.f7180w.u(r16) == false) goto L187;
        Logger.d("e", "httpdns request not return in httpdns prefer time for host : null");     // Catch: Throwable -> L165
        b(r16, j(null, false));     // Catch: Throwable -> L165
    L101:
        this.f7180w.o(r16);     // Catch: Throwable -> L165
        return;
    L187:
        return;
    L29:
        if ((r8 instanceof f) == false) goto L51;
        if (r15.what != 3) goto L51;
        Logger.d("e", "MSG_HTTPDNS_COMPLETED");     // Catch: Throwable -> L165
        ArrayList<String> r17 = r15.getData().getStringArrayList("httpdns_completed_hosts");     // Catch: Throwable -> L165
        if (r17 != null) goto L36;
        Logger.d("e", "MSG_HTTPDNS_COMPLETED hostlist is null");     // Catch: Throwable -> L165
        return;
    L36:
        Iterator<String> r11 = r17.iterator();     // Catch: Throwable -> L165
    L38:
        if (r11.hasNext() == false) goto L212;
        String r12 = r11.next();     // Catch: Throwable -> L165
        if (this.f7180w.t(r12) == false) goto L38;
        Logger.d("e", "httpdns returned in httpdns prefer time for host : " + r17);     // Catch: Throwable -> L165
        Iterator<c> r13 = this.f7180w.f(r12).iterator();     // Catch: Throwable -> L165
    L44:
        if (r13.hasNext() == false) goto L38;
        c r14 = r13.next();     // Catch: Throwable -> L165
        b r18 = i(r12, true);     // Catch: Throwable -> L165
        if (g().f7169b.get() == false) goto L49;
        if (r18 != null) goto L49;
        r14.getClass();     // Catch: Throwable -> L165
        r18 = j(r12, false);     // Catch: Throwable -> L165
    L49:
        Logger.d("e", "httpdns request is returned in prefer time for " + r12);     // Catch: Throwable -> L165
        b(r14, r18);     // Catch: Throwable -> L165
        this.f7180w.o(r14);     // Catch: Throwable -> L165
        goto L44
    L212:
        return;
    L51:
        if ((r8 instanceof i) == false) goto L73;
        if (r15.what != 1) goto L73;
        Logger.d("e", "MSG_LOCALDNS_COMPLETED");     // Catch: Throwable -> L165
        String r19 = r15.getData().getString("localdns_completed_host");     // Catch: Throwable -> L165
        if (r19 != null) goto L59;
        Logger.d("e", "MSG_HTTPDNS_COMPLETED host is null");     // Catch: Throwable -> L165
        return;
    L59:
        if (this.f7180w.v(r19) == false) goto L188;
        Logger.d("e", "localdns returned in localdns timeout for host : ".concat(r19));     // Catch: Throwable -> L165
        Iterator<c> r20 = this.f7180w.i(r19).iterator();     // Catch: Throwable -> L165
    L62:
        if (r20.hasNext() == false) goto L213;
        c r21 = r20.next();     // Catch: Throwable -> L165
        b r22 = j(r19, true);     // Catch: Throwable -> L165
        if (r22 != null) goto L68;
        r22 = i(r19, false);     // Catch: Throwable -> L165
        if (r22 != null) goto L69;
        n(r21);     // Catch: Throwable -> L165
        this.f7180w.a(r21);     // Catch: Throwable -> L165
    L70:
        this.f7180w.r(r21);     // Catch: Throwable -> L165
    L69:
        b(r21, r22);     // Catch: Throwable -> L165
        goto L70
    L68:
        Logger.d("e", "localdns request is returned in timeout for " + r19);     // Catch: Throwable -> L165
        goto L69
    L213:
        return;
    L188:
        return;
    L73:
        if ((r8 instanceof e) == false) goto L91;
        if (r15.what != 3) goto L91;
        Logger.d("e", "MSG_LOCALDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L165
        c r110 = (c) r15.getData().getSerializable("dns_timeout_job_key");     // Catch: Throwable -> L165
        if (r110 != null) goto L81;
        Logger.d("e", "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L165
        return;
    L81:
        if (this.f7180w.w(r110) == false) goto L189;
        Logger.d("e", "local request not return in localdns timeout for host : null");     // Catch: Throwable -> L165
        b r23 = i(null, false);     // Catch: Throwable -> L165
        if (r23 == null) goto L86;
        b(r110, r23);     // Catch: Throwable -> L165
    L89:
        this.f7180w.r(r110);     // Catch: Throwable -> L165
        return;
    L86:
        if (this.f7180w.k(null) == true) goto L88;
        n(r110);     // Catch: Throwable -> L165
    L88:
        this.f7180w.a(r110);     // Catch: Throwable -> L165
        goto L89
    L189:
        return;
    L91:
        if ((r8 instanceof e) == false) goto L103;
        if (r15.what != 4) goto L103;
        Logger.d("e", "MSG_HTTPDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L165
        r16 = (c) r15.getData().getSerializable("dns_timeout_job_key");     // Catch: Throwable -> L165
        if (r16 != null) goto L99;
        Logger.d("e", "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L165
        return;
    L99:
        if (this.f7180w.u(r16) == false) goto L191;
        b(r16, null);     // Catch: Throwable -> L165
        goto L101
    L191:
        return;
    L103:
        if ((r8 instanceof e) == false) goto L123;
        if (r15.what != 5) goto L123;
        Logger.d("e", "MSG_LOAD_LOCAL_HARDCODEIPS");     // Catch: Throwable -> L165
        ((p.a) this.f7182y).getClass();     // Catch: Throwable -> L165
        String r111 = p.f6914k.getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).getString("httpdns_hardcodeips", "");     // Catch: Throwable -> L165
        if (TextUtils.isEmpty(r111) == true) goto L117;
        this.f7171n.clear();     // Catch: Throwable -> L165
        JSONArray r24 = new JSONArray(r111);     // Catch: JSONException -> L116 Throwable -> L165
    L111:
        if (r10 >= r24.length()) goto L214;
        String r112 = r24.optString(r10);     // Catch: JSONException -> L116 Throwable -> L165
        if (TextUtils.isEmpty(r112) == true) goto L115;
        this.f7171n.add(r112);     // Catch: JSONException -> L116 Throwable -> L165
    L115:
        r10 = r10 + 1;
        goto L111
    L214:
        return;
    L116:
        String r113 = "local httpdns hardcode ips not exists, use default";
    L163:
        Logger.d("e", r113);     // Catch: Throwable -> L165
        return;
    L117:
        ((p.a) this.f7182y).getClass();     // Catch: Throwable -> L165
        if (p.f6913j != null) goto L120;
        return;
    L120:
        if (this.f7171n.size() != 0) goto L194;
        ConcurrentSkipListSet<String> r114 = this.f7171n;     // Catch: Throwable -> L165
        ((p.a) this.f7182y).getClass();     // Catch: Throwable -> L165
        r114.addAll(Arrays.asList(p.f6913j));     // Catch: Throwable -> L165
        return;
    L194:
        return;
    L123:
        if ((r8 instanceof e) == false) goto L128;
        if (r15.what != 6) goto L128;
        Logger.d("e", "network changed");     // Catch: Throwable -> L165
        d r115 = this.f7180w;     // Catch: Throwable -> L165
        ((p.a) g().f7182y).getClass();     // Catch: Throwable -> L165
        r115.m(p.f6914k);     // Catch: Throwable -> L165
        return;
    L128:
        if ((r8 instanceof e) == false) goto L133;
        if (r15.what != 7) goto L133;
        Logger.d("e", "activity resume, detect ipv6 reachable");     // Catch: Throwable -> L165
        o();     // Catch: Throwable -> L165
        return;
    L133:
        if ((r8 instanceof e7.a) == false) goto L158;
        String r116 = r15.getData().getString("dnsrecord_host");     // Catch: Throwable -> L165
        if (TextUtils.isEmpty(r116) == false) goto L139;
        Logger.d("e", "DnsRecord refresh host is null");     // Catch: Throwable -> L165
        return;
    L139:
        switch(r15.what) {
            case 10: goto L150;
            case 11: goto L147;
            case 12: goto L146;
            case 13: goto L141;
            default: goto L198;
        };     // Catch: Throwable -> L165
    L141:
        Logger.d("e", "remove httpdns cache for host : " + r116);     // Catch: Throwable -> L165
        e r117 = g();     // Catch: Throwable -> L165
        r117.getClass();     // Catch: Throwable -> L165
        if (l6.a.h0(r116) == false) goto L199;
        d r118 = r117.f7180w;     // Catch: Throwable -> L165
        if (r118.k(r116) == true) goto L200;
        r118.n(r116);     // Catch: Throwable -> L165
        return;
    L200:
        return;
    L199:
        return;
    L146:
        Logger.d("e", "add host : " + r116 + " to stale cache host list");     // Catch: Throwable -> L165
        g().a(r116);     // Catch: Throwable -> L165
        return;
    L147:
        Logger.d("e", "remove localdns cache for host : " + r116);     // Catch: Throwable -> L165
        e r119 = g();     // Catch: Throwable -> L165
        r119.getClass();     // Catch: Throwable -> L165
        Logger.d("e", "removeLocalDnsStaleCache");     // Catch: Throwable -> L165
        if (l6.a.h0(r116) == false) goto L203;
        r119.f7180w.q(r116);     // Catch: Throwable -> L165
        return;
    L203:
        return;
    L150:
        Logger.d("e", "refresh httpdns cache for host : " + r116);     // Catch: Throwable -> L165
        e r120 = g();     // Catch: Throwable -> L165
        r120.getClass();     // Catch: Throwable -> L165
        if (l6.a.h0(r116) == true) goto L153;
        return;
    L153:
        if (r120.f7180w.k(r116) == false) goto L155;
        return;
    L155:
        if (r120.f7169b.get() == false) goto L207;
        ArrayList r25 = new ArrayList();     // Catch: Throwable -> L165
        r25.add(r116);     // Catch: Throwable -> L165
        r120.m(r25, e7.a.EnumC0065a.f7142m, false);     // Catch: Throwable -> L165
        return;
    L207:
        return;
    L198:
        return;
    L158:
        if ((r8 instanceof d) == true) goto L160;
    L162:
        r113 = "HTTPDNS-CollectResult handler thread receive a unknown message : " + r15;     // Catch: Throwable -> L165
        goto L163
    L160:
        if (r15.what != 20) goto L162;
        Logger.d("e", "reset httpdns domain failed count");     // Catch: Throwable -> L165
        this.f7180w.f7165i.set(0);     // Catch: Throwable -> L165
        return;
    L7:
        if ((r8 instanceof f) == true) goto L170;
        if ((r8 instanceof i) == true) goto L170;
        if ((r8 instanceof e7.a) == true) goto L170;
        if ((r8 instanceof d) == true) goto L170;
        return;
    }

    public final b i(String r8, boolean r10) {
        Logger.d("e", "look up httpdns cache for host " + r8);
        e7.a r11 = this.f7180w.e(r8);
        if (r11 != null) goto L5;
        return null;
    L5:
        b r12 = new b();
        r12.f7146a = r11.f7135b;
        r12.f7147b = r11.f7136c;
        long r13 = (r11.f7137d * 1000) + r11.f7138e;
        if (r10 == false) goto L13;
        if (r13 <= System.currentTimeMillis()) goto L11;
        r12.f7148m = b.a.f7152n;
        return r12;
    L11:
        return null;
    L13:
        if (r13 <= System.currentTimeMillis()) goto L15;
        b.a r14 = b.a.f7150b;
    L16:
        r12.f7148m = r14;
        return r12;
    L15:
        r14 = b.a.f7151m;
        goto L16
    }

    public final b j(String r8, boolean r10) {
        Logger.d("e", "lookup localdns cache for host " + r8);
        b r11 = new b();
        e7.a r12 = this.f7180w.h(r8);
        if (r12 != null) goto L6;
        return null;
    L6:
        r11.f7146a = r12.f7135b;
        r11.f7147b = r12.f7136c;
        if (r10 == false) goto L9;
        b.a r13 = b.a.f7153o;
    L10:
        r11.f7148m = r13;
        return r11;
    L9:
        r13 = b.a.f7154p;
        goto L10
    }

    public final void k(JSONObject r8) {
        Logger.d("e", "onServerConfigChanged");
        int r10 = r8.optInt("ttnet_http_dns_enabled", -1);
        boolean r11 = true;
        if (r10 < 0) goto L9;
        AtomicBoolean r12 = this.f7168a;
        if (r10 != 1) goto L7;
        boolean r13 = true;
    L8:
        r12.set(r13);
        goto L9
    L7:
        r13 = false;
    L9:
        String r14 = r8.optString("ttnet_tt_http_dns_domain");
        if (TextUtils.isEmpty(r14) == true) goto L12;
        this.f7170m = r14;
    L12:
        JSONArray r15 = r8.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (r15 == null) goto L21;
        this.f7173p.clear();
        int r16 = 0;
    L16:
        if (r16 >= r15.length()) goto L21;
        String r17 = r15.optString(r16);
        if (TextUtils.isEmpty(r17) == true) goto L20;
        this.f7173p.add(r17);
    L20:
        r16 = r16 + 1;
    L21:
        int r18 = r8.optInt("localdns_cache_ttl", -1);
        if (r18 < 0) goto L24;
        this.f7174q.set(r18);
    L24:
        int r19 = r8.optInt("httpdns_prefer_time_ms", -1);
        if (r19 < 0) goto L27;
        this.f7175r.set(r19);
    L27:
        int r20 = r8.optInt("httpdns_stale_cache_interval", -1);
        if (r20 < 0) goto L30;
        this.f7176s.set(r20);
    L30:
        int r21 = r8.optInt("enable_compare_localdns_httpdns", -1);
        if (r21 < 0) goto L33;
        this.f7177t.set(r21);
    L33:
        int r22 = r8.optInt("ttnet_http_dns_prefer", -1);
        if (r22 < 0) goto L40;
        AtomicBoolean r23 = this.f7169b;
        if (r22 == 1) goto L39;
        r11 = false;
    L39:
        r23.set(r11);
    L40:
        int r24 = r8.optInt("ttnet_http_dns_timeout", -1);
        if (r24 < 0) goto L43;
        this.f7178u.set(r24);
    L43:
        int r25 = r8.optInt("ttnet_local_dns_time_out", -1);
        if (r25 < 0) goto L46;
        this.f7179v.set(r25);
    L46:
        JSONObject r26 = r8.optJSONObject("ttnet_http_dns_addr");
        if (r26 == null) goto L59;
        this.f7172o.clear();
        Iterator<String> r27 = r26.keys();
    L50:
        if (r27.hasNext() == false) goto L73;
        String r28 = r27.next();
        String r29 = r26.optString(r28);
        if (TextUtils.isEmpty(r28) == true) goto L50;
        if (TextUtils.isEmpty(r29) == true) goto L50;
        String[] r30 = r29.split(",");
        if (r28.equals(this.f7170m) == true) goto L57;
        this.f7172o.put(r28, new CopyOnWriteArrayList(Arrays.asList(r30)));
        goto L50
    L57:
        this.f7171n.clear();
        this.f7171n.addAll(Arrays.asList(r30));
        goto L50
    L73:
        return;
    }

    public final void l(JSONArray r8) {
        if (r8.length() <= 0) goto L16;
        this.f7171n.clear();
        int r10 = 0;
    L6:
        if (r10 >= r8.length()) goto L11;
        String r11 = r8.optString(r10);
        if (TextUtils.isEmpty(r11) == true) goto L10;
        this.f7171n.add(r11);
    L10:
        r10 = r10 + 1;
        goto L6
    L11:
        ((p.a) this.f7182y).getClass();
        SharedPreferences.Editor r12 = p.f6914k.getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).edit();
        r12.putString("httpdns_hardcodeips", String.valueOf(r8));
        r12.apply();
        return;
    }

    public final synchronized Future m(ArrayList r10, e7.a.EnumC0065a r11, boolean r12) {
        monitor-enter(this);
        Future<Void> r8 = null;
        if (r10.size() != 0) goto L8;
        Logger.d("e", "httpdns resolve hostlist is null.");     // Catch: Throwable -> L34
        monitor-exit(this);
        return null;
    L8:
        int r13 = 0;
    L10:
        if (r13 >= r10.size()) goto L21;
        if (this.f7180w.k((String) r10.get(r13)) == false) goto L19;
        if (r12 == true) goto L15;
    L18:
        r10.remove(r10.get(r13));     // Catch: Throwable -> L34
        goto L19
    L15:
        if (r10.size() != 1) goto L18;
        if (r13 != 0) goto L18;
        r8 = this.f7180w.g((String) r10.get(r13));     // Catch: Throwable -> L34
        Logger.d("e", "sync block request for " + ((String) r10.get(r13)) + " is resolving");     // Catch: Throwable -> L34
    L19:
        r13 = r13 + 1;     // Catch: Throwable -> L34
        goto L10
    L21:
        if (r10.size() != 0) goto L24;
        monitor-exit(this);
        return r8;
    L24:
        Logger.d("e", "submit httpdns resolve for host : " + r10);     // Catch: Throwable -> L34
        r8 = B.submit(new f(l6.a.a1(r10), D, this.f7180w, r11, F));     // Catch: Throwable -> L34 RejectedExecutionException -> L36
        Iterator r14 = r10.iterator();     // Catch: Throwable -> L34 RejectedExecutionException -> L36
    L27:
        if (r14.hasNext() == false) goto L38;
        String r15 = (String) r14.next();     // Catch: Throwable -> L34 RejectedExecutionException -> L36
        this.f7180w.b(r15, r8);     // Catch: Throwable -> L34 RejectedExecutionException -> L36
        if (this.f7169b.get() == false) goto L27;
        ConcurrentSkipListSet<String> r16 = this.f7180w.f7163g;     // Catch: Throwable -> L34 RejectedExecutionException -> L36
        if (r16.contains(r15) == false) goto L27;
        r16.remove(r15);     // Catch: Throwable -> L34 RejectedExecutionException -> L36
    L38:
        monitor-exit(this);
        return r8;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
        Logger.d("e", "submit httpdns resolve for host : " + r10 + " was rejected");     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final void n(c r8) {
        ArrayList r10 = new ArrayList();
        r8.getClass();
        r10.add(null);
        m(r10, e7.a.EnumC0065a.f7140a, false);
        Message r11 = Message.obtain();
        r11.what = 4;
        r11.obj = this;
        Bundle r12 = new Bundle();
        r12.putSerializable("dns_timeout_job_key", r8);
        r11.setData(r12);
        F.sendMessageDelayed(r11, ((long) this.f7178u.get()) * 1000);
    }

    public final synchronized Future<Void> p(String r8) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.f7180w.l(r8) == false) goto L9;
        Logger.d("e", "localdns is resolving for host : " + r8);     // Catch: Throwable -> L17
        Future<Void> r10 = this.f7180w.j(r8);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r10;
    L9:
        Logger.d("e", "submit localdns resolve host : " + r8);     // Catch: Throwable -> L17
        Future<Void> r11 = null;
        r11 = B.submit(new i(r8, this.f7180w, F));     // Catch: RejectedExecutionException -> L13 Throwable -> L17
        this.f7180w.d(r8, r11);     // Catch: RejectedExecutionException -> L13 Throwable -> L17
    L15:
        monitor-exit(this);
        return r11;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
        goto L15
    }
}
