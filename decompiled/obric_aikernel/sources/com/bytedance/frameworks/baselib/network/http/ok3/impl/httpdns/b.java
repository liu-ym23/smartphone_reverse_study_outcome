package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.frameworks.baselib.network.http.util.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
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
public class b implements WeakHandler.IHandler {
    private static HandlerThread A = null;
    private static WeakHandler B = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static String f1712w = "b";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static ExecutorService f1713x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static volatile b f1714y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static String f1715z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f1716c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AtomicBoolean f1717g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f1718h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ConcurrentSkipListSet<String> f1719i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ConcurrentMap<String, CopyOnWriteArrayList<String>> f1720j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ConcurrentSkipListSet<String> f1721k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AtomicInteger f1722l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private AtomicInteger f1723m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private AtomicInteger f1724n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AtomicInteger f1725o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private AtomicInteger f1726p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AtomicInteger f1727q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a f1728r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final com.bytedance.frameworks.baselib.network.http.ok3.impl.c f1729s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile v2.b f1730t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f1731u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Handler f1732v;

    class a extends Handler {
        a(b r10, Looper r11) {
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            super.handleMessage(r10);
            if (r10 != null) goto L5;
            return;
        L5:
            if ((r10.obj instanceof b) == false) goto L23;
            Bundle r11 = r10.getData();
            DnsResult r12 = (DnsResult) r11.getSerializable("callback_dnsresult_key");
            HostResolveJob r13 = (HostResolveJob) r11.getSerializable("callback_dnsresult_job_key");
            if (r13 != null) goto L14;
            if (Logger.debug() == false) goto L21;
            Logger.d(b.a(), "callback job is null");
            return;
        L21:
            return;
        L14:
            if (r10.what == 1) goto L17;
            return;
        L17:
            if (Logger.debug() == false) goto L19;
            Logger.d(b.a(), "callback dns result for host " + r13.getHost() + " in thread " + Thread.currentThread().getName());
        L19:
            r13.mHttpDnsCallback.a(r12);
            return;
        }
    }

    static {
        f1713x = Executors.newFixedThreadPool(6);
    }

    private b() {
        this.f1716c = new AtomicBoolean(true);
        this.f1717g = new AtomicBoolean(false);
        this.f1719i = new ConcurrentSkipListSet();
        this.f1720j = new ConcurrentHashMap();
        this.f1721k = new ConcurrentSkipListSet();
        this.f1722l = new AtomicInteger(30);
        this.f1723m = new AtomicInteger(2000);
        this.f1724n = new AtomicInteger(60);
        this.f1725o = new AtomicInteger(0);
        this.f1726p = new AtomicInteger(5);
        this.f1727q = new AtomicInteger(5);
        this.f1729s = new com.bytedance.frameworks.baselib.network.http.ok3.impl.c();
        this.f1731u = false;
        this.f1732v = new a(this, Looper.getMainLooper());
        if (Logger.debug() == false) goto L5;
        Logger.d(f1712w, "HttpDns constructor");
    L5:
        HandlerThread r10 = new HandlerThread("TTOK-HTTPDNS");
        A = r10;
        r10.start();
        B = new WeakHandler(A.getLooper(), this);
        f1715z = "4.2.228.21-doubao";
        this.f1728r = new com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a(B);
    }

    private Future<Void> D(String r10, List<Boolean> r11, boolean r12) {
        DnsRecord r13 = this.f1728r.m(r10);
        if (r13 != null) goto L5;
    L6:
        r11.set(0, Boolean.TRUE);
        if (this.f1728r.q(r10) == true) goto L10;
        H(r10);
    L10:
        if (this.f1728r.p(r10) == true) goto L12;
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L17:
        if (this.f1728r.p(r10) == false) goto L19;
        Future<Void> r14 = this.f1728r.l(r10);     // Catch: Throwable -> L23
    L20:
        monitor-exit(this);     // Catch: Throwable -> L23
        return r14;
    L19:
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L23
        r15.add(r10);     // Catch: Throwable -> L23
        r14 = E(r15, DnsRecord.CacheStaleReason.CACHE_UNSET, r12);     // Catch: Throwable -> L23
        goto L20
    L12:
        if (Logger.debug() == false) goto L28;
        Logger.d(f1712w, "httpdns is resolving for host " + r10);
    L28:
        return this.f1728r.l(r10);
    L5:
        if ((r13.d() + (r13.g() * 1000)) > (System.currentTimeMillis() + ((long) this.f1723m.get()))) goto L10;
        goto L6
    }

    private void F(HostResolveJob r10) {
        ArrayList r11 = new ArrayList();
        r11.add(r10.getHost());
        E(r11, DnsRecord.CacheStaleReason.CACHE_UNSET, false);
        Message r12 = Message.obtain();
        r12.what = 4;
        r12.obj = this;
        Bundle r13 = new Bundle();
        r13.putSerializable("dns_timeout_job_key", r10);
        r12.setData(r13);
        B.sendMessageDelayed(r12, ((long) this.f1726p.get()) * 1000);
    }

    private synchronized Future<Void> H(String r10) {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f1728r.q(r10) == false) goto L12;
        if (Logger.debug() == false) goto L8;
        Logger.d(f1712w, "localdns is resolving for host : " + r10);     // Catch: Throwable -> L21
    L8:
        Future<Void> r11 = this.f1728r.o(r10);     // Catch: Throwable -> L21
        monitor-exit(this);
        return r11;
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(f1712w, "submit localdns resolve host : " + r10);     // Catch: Throwable -> L21
    L14:
        Future<Void> r12 = null;
        r12 = f1713x.submit(new d(r10, this.f1728r, B));     // Catch: RejectedExecutionException -> L17 Throwable -> L21
        this.f1728r.g(r10, r12);     // Catch: RejectedExecutionException -> L17 Throwable -> L21
    L19:
        monitor-exit(this);
        return r12;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L21
        goto L19
    }

    static /* synthetic */ String a() {
        return f1712w;
    }

    private void d(HostResolveJob r10, DnsResult r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1712w, "doDnsResultCallback for host " + r10.getHost());
    L5:
        Message r12 = Message.obtain();
        r12.obj = this;
        r12.what = 1;
        Bundle r13 = new Bundle();
        r13.putSerializable("callback_dnsresult_job_key", r10);
        r13.putSerializable("callback_dnsresult_key", r11);
        r12.setData(r13);
        this.f1732v.sendMessage(r12);
    }

    private DnsResult f(Future<Void> r10, String r11, boolean r12) {
        if (Logger.debug() == false) goto L34;
        Logger.d(f1712w, "getDnsResultInHttpDnsPreferTime");
    L34:
        if (r10 != null) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(f1712w, "httpdns future is null");     // Catch: TimeoutException -> L22 ExecutionException -> L25 InterruptedException -> L28
    L10:
        return u(r11, r12);
    L12:
        if (r10.isDone() == true) goto L14;
        r10.get(q().l().get(), TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L22 ExecutionException -> L25 InterruptedException -> L28
        DnsResult r13 = t(r11, true);     // Catch: TimeoutException -> L22 ExecutionException -> L25 InterruptedException -> L28
        if (r13 == null) goto L36;
        return r13;
    L36:
        return u(r11, r12);
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.d(f1712w, "httpdns future is done");     // Catch: TimeoutException -> L22 ExecutionException -> L25 InterruptedException -> L28
    L16:
        DnsResult r14 = t(r11, true);     // Catch: TimeoutException -> L22 ExecutionException -> L25 InterruptedException -> L28
        if (r14 == null) goto L36;
        return r14;
    L29:
        if (Logger.debug() == false) goto L33;
        String r15 = f1712w;
        String r16 = "httpdns InterruptedException, look up localdns";
    L31:
        Logger.d(r15, r16);
    L33:
        return u(r11, r12);
    L26:
        if (Logger.debug() == false) goto L33;
        r15 = f1712w;
        r16 = "httpdns ExecutionException, look up localdns";
        goto L31
    L23:
        if (Logger.debug() == false) goto L33;
        r15 = f1712w;
        r16 = "httpdns timeout in httpdns prefer time, look up localdns";
        goto L31
    }

    private DnsResult g(String r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1712w, "try to look up hardcode ips");
    L6:
        if (this.f1720j.containsKey(r10) == false) goto L22;
        DnsResult r11 = new DnsResult();
        Iterator<String> r12 = this.f1720j.get(r10).iterator();
    L9:
        if (r12.hasNext() == false) goto L20;
        String r13 = r12.next();
        if (w2.c.d(r13) == true) goto L12;
        if (w2.c.c(r13) == true) goto L16;
        if (Logger.debug() == false) goto L9;
        Logger.d(f1712w, "find a invalid hardcode ip: " + r13);
        goto L9
    L16:
        List<String> r14 = r11.ipv4List;
    L13:
        r14.add(r13);
        goto L9
    L12:
        r14 = r11.ipv6List;
        goto L13
    L20:
        r11.source = DnsResult.Source.HARDCODE_IPS;
        return r11;
    L22:
        return null;
    }

    private DnsResult o(String r10, boolean r11) {
        if (r11 == false) goto L6;
        return null;
    L6:
        if (this.f1728r.p(r10) == false) goto L8;
        Future<Void> r12 = this.f1728r.l(r10);
    L9:
        if (r12 != null) goto L12;
        return null;
    L12:
        if (r12.isDone() == true) goto L19;
        r12.get(((long) this.f1726p.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
        return t(r10, true);
    L20:
        return null;
    L19:
        return t(r10, true);
    L8:
        ArrayList r13 = new ArrayList();
        r13.add(r10);
        r12 = E(r13, DnsRecord.CacheStaleReason.CACHE_UNSET, true);
        goto L9
    }

    public static b q() {
        if (f1714y != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1714y != null) goto L9;
        f1714y = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f1714y;
    }

    private boolean r(String r10) {
        if (this.f1731u == true) goto L9;
        if (Logger.debug() == false) goto L7;
        Logger.d(f1712w, "you have not set httpdns depend");
    L7:
        return true;
    L9:
        if (this.f1716c.get() == true) goto L15;
        if (Logger.debug() == false) goto L13;
        Logger.d(f1712w, "httpdns was unabled by tnc");
    L13:
        return true;
    L15:
        if (w2.a.a(r10) == true) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(f1712w, "illegal host");
    L19:
        return true;
    L21:
        if (w2.c.c(r10) == true) goto L28;
        if (w2.c.d(r10) == true) goto L28;
        return false;
    L28:
        if (Logger.debug() == false) goto L30;
        Logger.d(f1712w, "host is ipaddress");
    L30:
        return true;
    }

    private DnsResult t(String r10, boolean r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1712w, "look up httpdns cache for host " + r10);
    L5:
        DnsRecord r12 = this.f1728r.i(r10);
        if (r12 != null) goto L8;
        return null;
    L8:
        DnsResult r13 = new DnsResult();
        r13.ipv4List = r12.e();
        r13.ipv6List = r12.f();
        if (r11 == false) goto L16;
        if (((r12.g() * 1000) + r12.d()) <= System.currentTimeMillis()) goto L14;
        r13.source = DnsResult.Source.HTTPDNS_REQUEST;
        return r13;
    L14:
        return null;
    L16:
        if (((r12.g() * 1000) + r12.d()) <= System.currentTimeMillis()) goto L18;
        DnsResult.Source r14 = DnsResult.Source.HTTPDNS_CACHE;
    L19:
        r13.source = r14;
        return r13;
    L18:
        r14 = DnsResult.Source.HTTPDNS_STALE_CACHE;
        goto L19
    }

    private DnsResult u(String r10, boolean r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1712w, "lookup localdns cache for host " + r10);
    L5:
        DnsResult r12 = new DnsResult();
        DnsRecord r13 = this.f1728r.m(r10);
        if (r13 != null) goto L9;
        return null;
    L9:
        r12.ipv4List = r13.e();
        r12.ipv6List = r13.f();
        if (r11 == false) goto L12;
        DnsResult.Source r14 = DnsResult.Source.LOCALDNS_REQUEST;
    L13:
        r12.source = r14;
        return r12;
    L12:
        r14 = DnsResult.Source.LOCALDNS_CACHE;
        goto L13
    }

    void A(String r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1712w, "removeLocalDnsStaleCache");
    L6:
        if (w2.a.a(r10) == false) goto L9;
        this.f1728r.w(r10);
        return;
    }

    public void B(v2.b r10) {
        if (this.f1731u == true) goto L5;
        if (r10 != null) goto L10;
    L33:
        this.f1730t = null;
        throw new IllegalArgumentException("you must set correct httpdns depend");
    L10:
        if (r10.getContext() == null) goto L33;
        if (TextUtils.isEmpty(r10.a()) == true) goto L33;
        if (r10.getAppId() == null) goto L33;
        this.f1730t = r10;
        if (TextUtils.isEmpty(this.f1718h) == false) goto L18;
        this.f1718h = r10.a();
    L18:
        this.f1731u = true;
        G();
        this.f1729s.a(r10.getContext());
        if (this.f1721k.size() < 1) goto L21;
    L30:
        e(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
    L31:
        Message r11 = Message.obtain();
        r11.what = 5;
        r11.obj = this;
        B.sendMessage(r11);
        return;
    L21:
        if (this.f1730t.c() == null) goto L28;
        if (this.f1730t.c().length <= 0) goto L28;
        if (this.f1730t.c().length > 10) goto L28;
        this.f1721k.addAll(Arrays.asList(this.f1730t.c()));
    L28:
        if (Logger.debug() == false) goto L31;
        Logger.d(f1712w, "httpdns preload domains's number must less than 10, httpdns preload is skipped.");
        goto L31
    L5:
        if (Logger.debug() == false) goto L35;
        Logger.d(f1712w, "you have set httpdns depend before.");
        return;
    }

    void C(JSONArray r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.length() <= 0) goto L18;
        this.f1719i.clear();
        int r11 = 0;
    L7:
        if (r11 >= r10.length()) goto L12;
        String r12 = r10.optString(r11);
        if (TextUtils.isEmpty(r12) == true) goto L11;
        this.f1719i.add(r12);
    L11:
        r11 = r11 + 1;
        goto L7
    L12:
        SharedPreferences.Editor r13 = this.f1730t.getContext().getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).edit();
        r13.putString("httpdns_hardcodeips", String.valueOf(r10));
        r13.apply();
        return;
    }

    synchronized Future<Void> E(List<String> r10, DnsRecord.CacheStaleReason r11, boolean r12) {
        monitor-enter(this);
        Future<Void> r13 = null;
        if (r10 == null) goto L43;
    L47:
        th = move-exception;
        throw th;
    L6:
        if (r10.size() == 0) goto L43;
        int r14 = 0;
    L10:
        if (r14 >= r10.size()) goto L23;
        if (this.f1728r.p(r10.get(r14)) == false) goto L21;
        if (r12 == true) goto L15;
    L20:
        r10.remove(r10.get(r14));     // Catch: Throwable -> L47
        goto L21
    L15:
        if (r10.size() != 1) goto L20;
        if (r14 != 0) goto L20;
        r13 = this.f1728r.l(r10.get(r14));     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L20;
        Logger.d(f1712w, "sync block request for " + r10.get(r14) + " is resolving");     // Catch: Throwable -> L47
    L21:
        r14 = r14 + 1;     // Catch: Throwable -> L47
        goto L10
    L23:
        if (r10.size() != 0) goto L27;
        monitor-exit(this);
        return r13;
    L27:
        if (Logger.debug() == false) goto L50;
        Logger.d(f1712w, "submit httpdns resolve for host : " + r10);     // Catch: Throwable -> L47
    L50:
        r13 = f1713x.submit(new c(w2.a.b(r10), f1715z, this.f1728r, r11, B));     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        Iterator<String> r15 = r10.iterator();     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L31:
        if (r15.hasNext() == false) goto L40;
        String r16 = r15.next();     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        this.f1728r.d(r16, r13);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        if (this.f1717g.get() == false) goto L31;
        this.f1728r.v(r16);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L40:
        monitor-exit(this);
        return r13;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L40;
        Logger.d(f1712w, "submit httpdns resolve for host : " + r10 + " was rejected");     // Catch: Throwable -> L47
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d(f1712w, "httpdns resolve hostlist is null.");     // Catch: Throwable -> L47
    L45:
        monitor-exit(this);
        return null;
    }

    void G() {
        f1713x.submit(new v2.c());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    void b(String r10) {
        this.f1728r.e(r10);
    }

    void c(List<String> r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1712w, "batchRefreshHttpDnsStaleCache for host " + r10);
    L5:
        E(r10, DnsRecord.CacheStaleReason.REFRESH_BATCH, false);
    }

    synchronized void e(DnsRecord.CacheStaleReason r10) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.f1730t != null) goto L6;
    L34:
        monitor-exit(this);
        return;
    L6:
        if (g.h(this.f1730t.getContext()) == false) goto L34;
        ConcurrentSkipListSet<String> r11 = this.f1721k;     // Catch: Throwable -> L36
        if (r11 == null) goto L34;
        if (r11.size() == 0) goto L34;
        if (this.f1721k.size() > 10) goto L34;
        if (Logger.debug() == false) goto L17;
        Logger.d(f1712w, "do httpdns preload");     // Catch: Throwable -> L36
    L17:
        Iterator<String> r12 = this.f1721k.iterator();     // Catch: Throwable -> L36
        ArrayList r13 = new ArrayList();     // Catch: Throwable -> L36
    L19:
        if (r12.hasNext() == false) goto L25;
        String r14 = r12.next();     // Catch: Throwable -> L36
        if (this.f1728r.p(r14) == true) goto L19;
        r13.add(r14);     // Catch: Throwable -> L36
        goto L19
    L25:
        if (r13.size() != 0) goto L29;
        monitor-exit(this);
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d(f1712w, "httpdns batch preload for : " + r13);     // Catch: Throwable -> L36
    L31:
        E(r13, r10, false);     // Catch: Throwable -> L36
        monitor-exit(this);
    }

    public v2.b h() {
        return this.f1730t;
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r10) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f1712w, "httpdns handler handle msg in " + Thread.currentThread().getName());
    L5:
        if (r10 == null) goto L252;
        Object r11 = r10.obj;
        if ((r11 instanceof b) == false) goto L9;
    L229:
    L226:
        th = move-exception;
        th.printStackTrace();
        return;
    L19:
        if ((r11 instanceof b) == false) goto L39;
        if (r10.what != 2) goto L39;
        if (Logger.debug() == false) goto L25;
        Logger.d(f1712w, "MSG_HTTPDNS_PREFER_TIMEOUT");     // Catch: Throwable -> L226
    L25:
        HostResolveJob r12 = (HostResolveJob) r10.getData().getSerializable("httpdns_timeout_job_key");     // Catch: Throwable -> L226
        if (r12 != null) goto L32;
        if (Logger.debug() == false) goto L246;
        Logger.d(f1712w, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L226
        return;
    L246:
        return;
    L32:
        if (this.f1728r.C(r12) == true) goto L34;
        return;
    L34:
        if (Logger.debug() == false) goto L36;
        Logger.d(f1712w, "httpdns request not return in httpdns prefer time for host : " + r12.getHost());     // Catch: Throwable -> L226
    L36:
        d(r12, u(r12.getHost(), r12.isLocalDnsExpired()));     // Catch: Throwable -> L226
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a r13 = this.f1728r;     // Catch: Throwable -> L226
    L37:
        r13.t(r12);     // Catch: Throwable -> L226
        return;
    L39:
        if ((r11 instanceof c) == true) goto L41;
    L71:
        int r14 = 0;
        if ((r11 instanceof d) == false) goto L104;
        if (r10.what != 1) goto L104;
        if (Logger.debug() == false) goto L78;
        Logger.d(f1712w, "MSG_LOCALDNS_COMPLETED");     // Catch: Throwable -> L226
    L78:
        String r15 = r10.getData().getString("localdns_completed_host");     // Catch: Throwable -> L226
        if (r15 != null) goto L85;
        if (Logger.debug() == false) goto L248;
        Logger.d(f1712w, "MSG_HTTPDNS_COMPLETED host is null");     // Catch: Throwable -> L226
        return;
    L248:
        return;
    L85:
        if (this.f1728r.D(r15) == true) goto L87;
        return;
    L87:
        if (Logger.debug() == false) goto L89;
        Logger.d(f1712w, "localdns returned in localdns timeout for host : " + r15);     // Catch: Throwable -> L226
    L89:
        Iterator<HostResolveJob> r16 = this.f1728r.n(r15).iterator();     // Catch: Throwable -> L226
    L91:
        if (r16.hasNext() == false) goto L275;
        HostResolveJob r17 = r16.next();     // Catch: Throwable -> L226
        DnsResult r18 = u(r15, true);     // Catch: Throwable -> L226
        if (r18 != null) goto L99;
        r18 = t(r15, false);     // Catch: Throwable -> L226
        if (r18 != null) goto L97;
        F(r17);     // Catch: Throwable -> L226
        this.f1728r.c(r17.getHost(), r17);     // Catch: Throwable -> L226
    L101:
        this.f1728r.x(r17);     // Catch: Throwable -> L226
    L97:
        d(r17, r18);     // Catch: Throwable -> L226
        goto L101
    L99:
        if (Logger.debug() == false) goto L97;
        Logger.d(f1712w, "localdns request is returned in timeout for " + r15);     // Catch: Throwable -> L226
        goto L97
    L275:
        return;
    L104:
        if ((r11 instanceof b) == false) goto L130;
        if (r10.what != 3) goto L130;
        if (Logger.debug() == false) goto L110;
        Logger.d(f1712w, "MSG_LOCALDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L226
    L110:
        HostResolveJob r19 = (HostResolveJob) r10.getData().getSerializable("dns_timeout_job_key");     // Catch: Throwable -> L226
        if (r19 != null) goto L117;
        if (Logger.debug() == false) goto L249;
        Logger.d(f1712w, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L226
        return;
    L249:
        return;
    L117:
        if (this.f1728r.E(r19) == true) goto L119;
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d(f1712w, "local request not return in localdns timeout for host : " + r19.getHost());     // Catch: Throwable -> L226
    L121:
        DnsResult r20 = t(r19.getHost(), false);     // Catch: Throwable -> L226
        if (r20 == null) goto L125;
        d(r19, r20);     // Catch: Throwable -> L226
    L128:
        this.f1728r.x(r19);     // Catch: Throwable -> L226
        return;
    L125:
        if (this.f1728r.p(r19.getHost()) == true) goto L127;
        F(r19);     // Catch: Throwable -> L226
    L127:
        this.f1728r.c(r19.getHost(), r19);     // Catch: Throwable -> L226
    L130:
        if ((r11 instanceof b) == false) goto L146;
        if (r10.what != 4) goto L146;
        if (Logger.debug() == false) goto L136;
        Logger.d(f1712w, "MSG_HTTPDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L226
    L136:
        r12 = (HostResolveJob) r10.getData().getSerializable("dns_timeout_job_key");     // Catch: Throwable -> L226
        if (r12 != null) goto L143;
        if (Logger.debug() == false) goto L250;
        Logger.d(f1712w, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L226
        return;
    L250:
        return;
    L143:
        if (this.f1728r.C(r12) == false) goto L258;
        d(r12, null);     // Catch: Throwable -> L226
        r13 = this.f1728r;     // Catch: Throwable -> L226
        goto L37
    L258:
        return;
    L146:
        if ((r11 instanceof b) == false) goto L172;
        if (r10.what != 5) goto L172;
        if (Logger.debug() == false) goto L152;
        Logger.d(f1712w, "MSG_LOAD_LOCAL_HARDCODEIPS");     // Catch: Throwable -> L226
    L152:
        String r110 = this.f1730t.getContext().getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).getString("httpdns_hardcodeips", "");     // Catch: Throwable -> L226
        if (TextUtils.isEmpty(r110) == true) goto L167;
        this.f1719i.clear();     // Catch: Throwable -> L226
        JSONArray r21 = new JSONArray(r110);     // Catch: JSONException -> L162 Throwable -> L226
    L157:
        if (r14 >= r21.length()) goto L276;
        String r111 = r21.optString(r14);     // Catch: JSONException -> L162 Throwable -> L226
        if (TextUtils.isEmpty(r111) == true) goto L161;
        this.f1719i.add(r111);     // Catch: JSONException -> L162 Throwable -> L226
    L161:
        r14 = r14 + 1;
        goto L157
    L276:
        return;
    L163:
        if (Logger.debug() == false) goto L259;
        String r22 = f1712w;     // Catch: Throwable -> L226
        String r112 = "local httpdns hardcode ips not exists, use default";
    L165:
        Logger.d(r22, r112);     // Catch: Throwable -> L226
        return;
    L259:
        return;
    L167:
        if (this.f1730t.b() != null) goto L169;
        return;
    L169:
        if (this.f1719i.size() != 0) goto L262;
        this.f1719i.addAll(Arrays.asList(this.f1730t.b()));     // Catch: Throwable -> L226
        return;
    L262:
        return;
    L172:
        if ((r11 instanceof b) == false) goto L180;
        if (r10.what != 6) goto L180;
        if (Logger.debug() == false) goto L178;
        Logger.d(f1712w, "network changed");     // Catch: Throwable -> L226
    L178:
        this.f1728r.r(q().h().getContext());     // Catch: Throwable -> L226
        return;
    L180:
        if ((r11 instanceof b) == false) goto L188;
        if (r10.what != 7) goto L188;
        if (Logger.debug() == false) goto L186;
        Logger.d(f1712w, "activity resume, detect ipv6 reachable");     // Catch: Throwable -> L226
    L186:
        G();     // Catch: Throwable -> L226
        return;
    L188:
        if ((r11 instanceof DnsRecord) == false) goto L215;
        String r23 = r10.getData().getString("dnsrecord_host");     // Catch: Throwable -> L226
        if (TextUtils.isEmpty(r23) == false) goto L196;
        if (Logger.debug() == false) goto L251;
        Logger.d(f1712w, "DnsRecord refresh host is null");     // Catch: Throwable -> L226
        return;
    L251:
        return;
    L196:
        switch(r10.what) {
            case 10: goto L211;
            case 11: goto L207;
            case 12: goto L203;
            case 13: goto L199;
            default: goto L266;
        };     // Catch: Throwable -> L226
    L266:
        return;
    L199:
        if (Logger.debug() == false) goto L201;
        Logger.d(f1712w, "remove httpdns cache for host : " + r23);     // Catch: Throwable -> L226
    L201:
        q().z(r23);     // Catch: Throwable -> L226
        return;
    L203:
        if (Logger.debug() == false) goto L205;
        Logger.d(f1712w, "add host : " + r23 + " to stale cache host list");     // Catch: Throwable -> L226
    L205:
        q().b(r23);     // Catch: Throwable -> L226
        return;
    L207:
        if (Logger.debug() == false) goto L209;
        Logger.d(f1712w, "remove localdns cache for host : " + r23);     // Catch: Throwable -> L226
    L209:
        q().A(r23);     // Catch: Throwable -> L226
        return;
    L211:
        if (Logger.debug() == false) goto L213;
        Logger.d(f1712w, "refresh httpdns cache for host : " + r23);     // Catch: Throwable -> L226
    L213:
        q().y(r23);     // Catch: Throwable -> L226
        return;
    L215:
        if ((r11 instanceof com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a) == false) goto L223;
        if (r10.what != 20) goto L223;
        if (Logger.debug() == false) goto L221;
        Logger.d(f1712w, "reset httpdns domain failed count");     // Catch: Throwable -> L226
    L221:
        this.f1728r.z();     // Catch: Throwable -> L226
        return;
    L223:
        if (Logger.debug() == false) goto L272;
        r22 = f1712w;     // Catch: Throwable -> L226
        r112 = "HTTPDNS-CollectResult handler thread receive a unknown message : " + r10;     // Catch: Throwable -> L226
        goto L165
    L272:
        return;
    L41:
        if (r10.what != 3) goto L71;
        if (Logger.debug() == false) goto L45;
        Logger.d(f1712w, "MSG_HTTPDNS_COMPLETED");     // Catch: Throwable -> L226
    L45:
        ArrayList<String> r113 = r10.getData().getStringArrayList("httpdns_completed_hosts");     // Catch: Throwable -> L226
        if (r113 == null) goto L48;
        Iterator<String> r24 = r113.iterator();     // Catch: Throwable -> L226
    L53:
        if (r24.hasNext() == false) goto L274;
        String r25 = r24.next();     // Catch: Throwable -> L226
        if (this.f1728r.B(r25) == false) goto L53;
        if (Logger.debug() == false) goto L60;
        Logger.d(f1712w, "httpdns returned in httpdns prefer time for host : " + r113);     // Catch: Throwable -> L226
    L60:
        Iterator<HostResolveJob> r26 = this.f1728r.k(r25).iterator();     // Catch: Throwable -> L226
    L62:
        if (r26.hasNext() == false) goto L53;
        HostResolveJob r27 = r26.next();     // Catch: Throwable -> L226
        DnsResult r28 = t(r25, true);     // Catch: Throwable -> L226
        if (q().s().get() == false) goto L68;
        if (r28 != null) goto L68;
        r28 = u(r25, r27.isLocalDnsExpired());     // Catch: Throwable -> L226
    L68:
        if (Logger.debug() == false) goto L70;
        Logger.d(f1712w, "httpdns request is returned in prefer time for " + r25);     // Catch: Throwable -> L226
    L70:
        d(r27, r28);     // Catch: Throwable -> L226
        this.f1728r.t(r27);     // Catch: Throwable -> L226
        goto L62
    L274:
        return;
    L48:
        if (Logger.debug() == false) goto L247;
        Logger.d(f1712w, "MSG_HTTPDNS_COMPLETED hostlist is null");     // Catch: Throwable -> L226
        return;
    L247:
        return;
    L9:
        if ((r11 instanceof c) == true) goto L229;
        if ((r11 instanceof d) == true) goto L229;
        if ((r11 instanceof DnsRecord) == true) goto L229;
        if ((r11 instanceof com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a) == true) goto L229;
        return;
    }

    String i() {
        return this.f1718h;
    }

    ConcurrentSkipListSet<String> j() {
        return this.f1719i;
    }

    public HandlerThread k() {
        return A;
    }

    AtomicInteger l() {
        return this.f1723m;
    }

    AtomicInteger m() {
        return this.f1724n;
    }

    public DnsResult n(String r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1712w, "getHttpDnsResultForHostSyncBlock for host : " + r10);
    L6:
        if (r(r10) == false) goto L9;
        return null;
    L9:
        boolean r11 = r10.equals(this.f1718h);
        if (this.f1717g.get() == false) goto L16;
        if (r11 == true) goto L16;
        DnsResult r12 = t(r10, false);
        if (r12 == null) goto L15;
        return r12;
    L15:
        ArrayList r13 = new ArrayList();
        r13.add(0, Boolean.FALSE);
        DnsResult r14 = f(D(r10, r13, true), r10, r13.get(0).booleanValue());
    L37:
        if (r14 == null) goto L39;
        return r14;
    L39:
        return g(r10);
    L16:
        DnsResult r15 = u(r10, false);
        if (r15 == null) goto L20;
        return r15;
    L20:
        if (this.f1728r.q(r10) == false) goto L22;
        Future<Void> r16 = this.f1728r.o(r10);
    L23:
        if (r16 != null) goto L29;
        DnsResult r17 = o(r10, r11);
        if (r17 == null) goto L27;
        return r17;
    L27:
        return g(r10);
    L29:
        if (r16.isDone() == false) goto L41;
        DnsResult r18 = u(r10, true);
        if (r18 != null) goto L33;
    L32:
        r14 = o(r10, r11);
    L33:
        r14 = r18;
        goto L37
    L41:
        r16.get(((long) this.f1727q.get()) * 1000, TimeUnit.MILLISECONDS);     // Catch: Exception -> L40
        r18 = u(r10, true);     // Catch: Exception -> L40
        if (r18 != null) goto L33;
        r14 = o(r10, r11);     // Catch: Exception -> L40
    L22:
        r16 = H(r10);
        goto L23
    }

    AtomicInteger p() {
        return this.f1722l;
    }

    public AtomicBoolean s() {
        return this.f1717g;
    }

    public void v() {
        Message r10 = Message.obtain();
        r10.obj = this;
        r10.what = 6;
        B.sendMessage(r10);
    }

    public void w() {
        Message r10 = Message.obtain();
        r10.obj = this;
        r10.what = 7;
        B.sendMessage(r10);
    }

    public void x(JSONObject r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1712w, "onServerConfigChanged");
    L6:
        if (this.f1730t == null) goto L65;
        if (r10 == null) goto L80;
        int r11 = r10.optInt("ttnet_http_dns_enabled", -1);
        boolean r12 = false;
        if (r11 < 0) goto L16;
        AtomicBoolean r13 = this.f1716c;
        if (r11 != 1) goto L14;
        boolean r14 = true;
    L15:
        r13.set(r14);
        goto L16
    L14:
        r14 = false;
    L16:
        String r15 = r10.optString("ttnet_tt_http_dns_domain");
        if (TextUtils.isEmpty(r15) == true) goto L19;
        this.f1718h = r15;
    L19:
        JSONArray r16 = r10.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (r16 == null) goto L28;
        this.f1721k.clear();
        int r17 = 0;
    L23:
        if (r17 >= r16.length()) goto L28;
        String r18 = r16.optString(r17);
        if (TextUtils.isEmpty(r18) == true) goto L27;
        this.f1721k.add(r18);
    L27:
        r17 = r17 + 1;
    L28:
        int r19 = r10.optInt("localdns_cache_ttl", -1);
        if (r19 < 0) goto L31;
        this.f1722l.set(r19);
    L31:
        int r20 = r10.optInt("httpdns_prefer_time_ms", -1);
        if (r20 < 0) goto L34;
        this.f1723m.set(r20);
    L34:
        int r21 = r10.optInt("httpdns_stale_cache_interval", -1);
        if (r21 < 0) goto L37;
        this.f1724n.set(r21);
    L37:
        int r22 = r10.optInt("enable_compare_localdns_httpdns", -1);
        if (r22 < 0) goto L40;
        this.f1725o.set(r22);
    L40:
        int r23 = r10.optInt("ttnet_http_dns_prefer", -1);
        if (r23 < 0) goto L46;
        AtomicBoolean r24 = this.f1717g;
        if (r23 != 1) goto L45;
        r12 = true;
    L45:
        r24.set(r12);
    L46:
        int r25 = r10.optInt("ttnet_http_dns_timeout", -1);
        if (r25 < 0) goto L49;
        this.f1726p.set(r25);
    L49:
        int r26 = r10.optInt("ttnet_local_dns_time_out", -1);
        if (r26 < 0) goto L52;
        this.f1727q.set(r26);
    L52:
        JSONObject r27 = r10.optJSONObject("ttnet_http_dns_addr");
        if (r27 == null) goto L79;
        this.f1720j.clear();
        Iterator<String> r28 = r27.keys();
    L56:
        if (r28.hasNext() == false) goto L81;
        String r29 = r28.next();
        String r30 = r27.optString(r29);
        if (TextUtils.isEmpty(r29) == true) goto L56;
        if (TextUtils.isEmpty(r30) == true) goto L56;
        String[] r31 = r30.split(",");
        if (r29.equals(this.f1718h) == true) goto L63;
        this.f1720j.put(r29, new CopyOnWriteArrayList(Arrays.asList(r31)));
        goto L56
    L63:
        this.f1719i.clear();
        this.f1719i.addAll(Arrays.asList(r31));
        goto L56
    L81:
        return;
    L79:
        return;
    L80:
        return;
    }

    void y(String r10) {
        if (w2.a.a(r10) == true) goto L5;
        return;
    L5:
        if (this.f1728r.p(r10) == false) goto L7;
        return;
    L7:
        if (this.f1717g.get() == false) goto L12;
        ArrayList r11 = new ArrayList();
        r11.add(r10);
        E(r11, DnsRecord.CacheStaleReason.CACHE_STALE_EXPIRED, false);
        return;
    }

    void z(String r10) {
        if (w2.a.a(r10) == true) goto L5;
        return;
    L5:
        if (this.f1728r.p(r10) == true) goto L9;
        this.f1728r.s(r10);
        return;
    }
}
