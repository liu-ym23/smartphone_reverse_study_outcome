package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2484a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f2485b;
    private static volatile b c;
    private static String f;
    private static HandlerThread u;
    private static WeakHandler v;
    private AtomicBoolean d;
    private AtomicBoolean e;
    private volatile String g;
    private ConcurrentSkipListSet<String> h;
    private ConcurrentMap<String, CopyOnWriteArrayList<String>> i;
    private ConcurrentSkipListSet<String> j;
    private AtomicInteger k;
    private AtomicInteger l;
    private AtomicInteger m;
    private AtomicInteger n;
    private AtomicInteger o;
    private AtomicInteger p;
    private final a q;
    private final com.bytedance.frameworks.baselib.network.http.ok3.impl.d r;
    private volatile e s;
    private boolean t;
    private Handler w;

    static {
        f2485b = Executors.newFixedThreadPool(6);
    }

    private b() {
        this.d = new AtomicBoolean(true);
        this.e = new AtomicBoolean(false);
        this.h = new ConcurrentSkipListSet();
        this.i = new ConcurrentHashMap();
        this.j = new ConcurrentSkipListSet();
        this.k = new AtomicInteger(30);
        this.l = new AtomicInteger(2000);
        this.m = new AtomicInteger(60);
        this.n = new AtomicInteger(0);
        this.o = new AtomicInteger(5);
        this.p = new AtomicInteger(5);
        this.r = new com.bytedance.frameworks.baselib.network.http.ok3.impl.d();
        this.t = false;
        final Looper r1 = Looper.getMainLooper();
        this.w = new AnonymousClass1(this, r1);
        if (Logger.debug() == false) goto L5;
        Logger.d(f2484a, "HttpDns constructor");
    L5:
        HandlerThread r0 = new HandlerThread("TTOK-HTTPDNS");
        u = r0;
        r0.start();
        v = new WeakHandler(u.getLooper(), this);
        f = "4.2.243.22-doubao";
        this.q = new a(v);
    }

    private DnsResult a(String r4, boolean r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f2484a, "lookup localdns cache for host " + r4);
    L5:
        DnsResult r0 = new DnsResult();
        DnsRecord r3 = this.q.d(r4);
        if (r3 != null) goto L9;
        return null;
    L9:
        r0.ipv4List = r3.i();
        r0.ipv6List = r3.j();
        if (r5 == false) goto L12;
        DnsResult.Source r6 = DnsResult.Source.LOCALDNS_REQUEST;
    L13:
        r0.source = r6;
        return r0;
    L12:
        r6 = DnsResult.Source.LOCALDNS_CACHE;
        goto L13
    }

    public static b a() {
        if (c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    private void a(HostResolveJob r6) {
        ArrayList r0 = new ArrayList();
        r0.add(r6.getHost());
        a(r0, DnsRecord.CacheStaleReason.CACHE_UNSET, false);
        Message r1 = Message.obtain();
        r1.what = 4;
        r1.obj = this;
        Bundle r2 = new Bundle();
        r2.putSerializable("dns_timeout_job_key", r6);
        r1.setData(r2);
        v.sendMessageDelayed(r1, ((long) this.o.get()) * 1000);
    }

    private void a(HostResolveJob r4, DnsResult r5) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f2484a, "doDnsResultCallback for host " + r4.getHost());
    L5:
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 1;
        Bundle r1 = new Bundle();
        r1.putSerializable("callback_dnsresult_job_key", r4);
        r1.putSerializable("callback_dnsresult_key", r5);
        r0.setData(r1);
        this.w.sendMessage(r0);
    }

    private DnsResult b(String r6, boolean r7) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f2484a, "look up httpdns cache for host " + r6);
    L5:
        DnsRecord r5 = this.q.b(r6);
        if (r5 != null) goto L8;
        return null;
    L8:
        DnsResult r0 = new DnsResult();
        r0.ipv4List = r5.i();
        r0.ipv6List = r5.j();
        if (r7 == false) goto L16;
        if (((r5.h() * 1000) + r5.g()) <= System.currentTimeMillis()) goto L14;
        r0.source = DnsResult.Source.HTTPDNS_REQUEST;
        return r0;
    L14:
        return null;
    L16:
        if (((r5.h() * 1000) + r5.g()) <= System.currentTimeMillis()) goto L18;
        DnsResult.Source r8 = DnsResult.Source.HTTPDNS_CACHE;
    L19:
        r0.source = r8;
        return r0;
    L18:
        r8 = DnsResult.Source.HTTPDNS_STALE_CACHE;
        goto L19
    }

    static /* synthetic */ String l() {
        return f2484a;
    }

    synchronized Future<Void> a(List<String> r9, DnsRecord.CacheStaleReason r10, boolean r11) {
        monitor-enter(this);
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L47
        Future<Void> r0 = null;
        if (r12 == null) goto L43;
        if (r12.size() == 0) goto L43;
        int r1 = 0;
    L10:
        if (r1 >= r12.size()) goto L23;
        if (this.q.e((String) ZeusTransformUtils.preCheckCast(r12.get(r1), String.class, "com.obric.memorydata.plugin")) == false) goto L21;
        if (r11 == true) goto L15;
    L20:
        r12.remove(r12.get(r1));     // Catch: Throwable -> L47
        goto L21
    L15:
        if (r12.size() != 1) goto L20;
        if (r1 != 0) goto L20;
        r0 = this.q.g((String) ZeusTransformUtils.preCheckCast(r12.get(r1), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L20;
        Logger.d(f2484a, "sync block request for " + ((String) ZeusTransformUtils.preCheckCast(r12.get(r1), String.class, "com.obric.memorydata.plugin")) + " is resolving");     // Catch: Throwable -> L47
    L21:
        r1 = r1 + 1;     // Catch: Throwable -> L47
        goto L10
    L23:
        if (r12.size() != 0) goto L27;
        monitor-exit(this);
        return r0;
    L27:
        if (Logger.debug() == false) goto L50;
        Logger.d(f2484a, "submit httpdns resolve for host : " + r12);     // Catch: Throwable -> L47
    L50:
        r0 = f2485b.submit(new c(com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.a.a(r12), f, this.q, r10, v));     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        Iterator r13 = r12.iterator();     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L31:
        if (r13.hasNext() == false) goto L40;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        this.q.a(r14, r0);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
        if (this.e.get() == false) goto L31;
        this.q.n(r14);     // Catch: RejectedExecutionException -> L36 Throwable -> L47
    L40:
        monitor-exit(this);
        return r0;
    L36:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L47
        if (Logger.debug() == false) goto L40;
        Logger.d(f2484a, "submit httpdns resolve for host : " + r12 + " was rejected");     // Catch: Throwable -> L47
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d(f2484a, "httpdns resolve hostlist is null.");     // Catch: Throwable -> L47
    L45:
        monitor-exit(this);
        return null;
    L47:
        th = move-exception;
        throw th;
    }

    synchronized void a(DnsRecord.CacheStaleReason r6) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L4:
        if (this.s != null) goto L6;
    L34:
        monitor-exit(this);
        return;
    L6:
        if (com.bytedance.frameworks.baselib.network.http.util.g.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L34;
        ConcurrentSkipListSet<String> r0 = this.j;     // Catch: Throwable -> L36
        if (r0 == null) goto L34;
        if (r0.size() == 0) goto L34;
        if (this.j.size() > 10) goto L34;
        if (Logger.debug() == false) goto L17;
        Logger.d(f2484a, "do httpdns preload");     // Catch: Throwable -> L36
    L17:
        Iterator<String> r1 = this.j.iterator();     // Catch: Throwable -> L36
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L36
    L19:
        if (r1.hasNext() == false) goto L25;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (this.q.e(r3) == true) goto L19;
        r2.add(r3);     // Catch: Throwable -> L36
        goto L19
    L25:
        if (r2.size() != 0) goto L29;
        monitor-exit(this);
        return;
    L29:
        if (Logger.debug() == false) goto L31;
        Logger.d(f2484a, "httpdns batch preload for : " + r2);     // Catch: Throwable -> L36
    L31:
        a(r2, r6, false);     // Catch: Throwable -> L36
        monitor-exit(this);
    }

    public void a(e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        if (this.t == true) goto L5;
        if (r6 != null) goto L10;
    L33:
        this.s = null;
        throw new IllegalArgumentException("you must set correct httpdns depend");
    L10:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L33;
        if (TextUtils.isEmpty(r6.c()) == true) goto L33;
        if (r6.b() == null) goto L33;
        this.s = r6;
        if (TextUtils.isEmpty(this.g) == false) goto L18;
        this.g = r6.c();
    L18:
        this.t = true;
        j();
        this.r.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        if (this.j.size() < 1) goto L21;
    L30:
        a(DnsRecord.CacheStaleReason.PRELOAD_BATCH);
    L31:
        Message r7 = Message.obtain();
        r7.what = 5;
        r7.obj = this;
        v.sendMessage(r7);
        return;
    L21:
        if (this.s.a() == null) goto L28;
        if (this.s.a().length <= 0) goto L28;
        if (this.s.a().length > 10) goto L28;
        this.j.addAll(Arrays.asList(this.s.a()));
    L28:
        if (Logger.debug() == false) goto L31;
        Logger.d(f2484a, "httpdns preload domains's number must less than 10, httpdns preload is skipped.");
        goto L31
    L5:
        if (Logger.debug() == false) goto L35;
        Logger.d(f2484a, "you have set httpdns depend before.");
        return;
    }

    void a(String r3) {
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.a.a(r3) == true) goto L5;
        return;
    L5:
        if (this.q.e(r3) == false) goto L7;
        return;
    L7:
        if (this.e.get() == false) goto L12;
        ArrayList r0 = new ArrayList();
        r0.add(r3);
        a(r0, DnsRecord.CacheStaleReason.CACHE_STALE_EXPIRED, false);
        return;
    }

    void a(List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L5;
        Logger.d(f2484a, "batchRefreshHttpDnsStaleCache for host " + r5);
    L5:
        a(r5, DnsRecord.CacheStaleReason.REFRESH_BATCH, false);
    }

    void a(JSONArray r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.length() <= 0) goto L18;
        this.h.clear();
        int r1 = 0;
    L7:
        if (r1 >= r5.length()) goto L12;
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r2) == true) goto L11;
        this.h.add(r2);
    L11:
        r1 = r1 + 1;
        goto L7
    L12:
        SharedPreferences.Editor r4 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).edit();
        r4.putString("httpdns_hardcodeips", String.valueOf(r5));
        r4.apply();
        return;
    }

    public void a(JSONObject r8) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f2484a, "onServerConfigChanged");
    L6:
        if (this.s == null) goto L65;
        if (r8 == null) goto L80;
        int r0 = r8.optInt("ttnet_http_dns_enabled", -1);
        boolean r2 = false;
        if (r0 < 0) goto L16;
        AtomicBoolean r4 = this.d;
        if (r0 != 1) goto L14;
        boolean r1 = true;
    L15:
        r4.set(r1);
        goto L16
    L14:
        r1 = false;
    L16:
        String r3 = r8.optString("ttnet_tt_http_dns_domain");
        if (TextUtils.isEmpty(r3) == true) goto L19;
        this.g = r3;
    L19:
        JSONArray r5 = r8.optJSONArray("ttnet_tt_http_dns_preload_batch_host");
        if (r5 == null) goto L28;
        this.j.clear();
        int r6 = 0;
    L23:
        if (r6 >= r5.length()) goto L28;
        String r7 = r5.optString(r6);
        if (TextUtils.isEmpty(r7) == true) goto L27;
        this.j.add(r7);
    L27:
        r6 = r6 + 1;
    L28:
        int r9 = r8.optInt("localdns_cache_ttl", -1);
        if (r9 < 0) goto L31;
        this.k.set(r9);
    L31:
        int r10 = r8.optInt("httpdns_prefer_time_ms", -1);
        if (r10 < 0) goto L34;
        this.l.set(r10);
    L34:
        int r11 = r8.optInt("httpdns_stale_cache_interval", -1);
        if (r11 < 0) goto L37;
        this.m.set(r11);
    L37:
        int r12 = r8.optInt("enable_compare_localdns_httpdns", -1);
        if (r12 < 0) goto L40;
        this.n.set(r12);
    L40:
        int r13 = r8.optInt("ttnet_http_dns_prefer", -1);
        if (r13 < 0) goto L46;
        AtomicBoolean r14 = this.e;
        if (r13 != 1) goto L45;
        r2 = true;
    L45:
        r14.set(r2);
    L46:
        int r15 = r8.optInt("ttnet_http_dns_timeout", -1);
        if (r15 < 0) goto L49;
        this.o.set(r15);
    L49:
        int r16 = r8.optInt("ttnet_local_dns_time_out", -1);
        if (r16 < 0) goto L52;
        this.p.set(r16);
    L52:
        JSONObject r17 = r8.optJSONObject("ttnet_http_dns_addr");
        if (r17 == null) goto L79;
        this.i.clear();
        Iterator<String> r18 = r17.keys();
    L56:
        if (r18.hasNext() == false) goto L81;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin");
        String r20 = r17.optString(r19);
        if (TextUtils.isEmpty(r19) == true) goto L56;
        if (TextUtils.isEmpty(r20) == true) goto L56;
        String[] r21 = r20.split(",");
        if (r19.equals(this.g) == true) goto L63;
        this.i.put(r19, new CopyOnWriteArrayList(Arrays.asList(r21)));
        goto L56
    L63:
        this.h.clear();
        this.h.addAll(Arrays.asList(r21));
        goto L56
    L81:
        return;
    L79:
        return;
    L80:
        return;
    }

    AtomicInteger b() {
        return this.k;
    }

    void b(String r2) {
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.a.a(r2) == true) goto L5;
        return;
    L5:
        if (this.q.e(r2) == true) goto L9;
        this.q.a(r2);
        return;
    }

    AtomicInteger c() {
        return this.m;
    }

    void c(String r1) {
        this.q.m(r1);
    }

    public e d() {
        return this.s;
    }

    void d(String r3) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f2484a, "removeLocalDnsStaleCache");
    L6:
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.a.a(r3) == false) goto L9;
        this.q.c(r3);
        return;
    }

    String e() {
        return this.g;
    }

    ConcurrentSkipListSet<String> f() {
        return this.h;
    }

    public AtomicBoolean g() {
        return this.e;
    }

    public void h() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 7;
        v.sendMessage(r0);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(f2484a, "httpdns handler handle msg in " + Thread.currentThread().getName());
    L5:
        if (r11 != null) goto L7;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(r11.obj, b.class) == false) goto L9;
    L231:
    L226:
        th = move-exception;
        th.printStackTrace();
        return;
    L19:
        if (ZeusTransformUtils.instanceOf(r11.obj, b.class) == false) goto L39;
        if (r11.what != 2) goto L39;
        if (Logger.debug() == false) goto L25;
        Logger.d(f2484a, "MSG_HTTPDNS_PREFER_TIMEOUT");     // Catch: Throwable -> L226
    L25:
        HostResolveJob r12 = (HostResolveJob) ZeusTransformUtils.preCheckCast(r11.getData().getSerializable("httpdns_timeout_job_key"), HostResolveJob.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L226
        if (r12 != null) goto L32;
        if (Logger.debug() == false) goto L246;
        Logger.d(f2484a, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L226
        return;
    L246:
        return;
    L32:
        if (this.q.a(r12) == true) goto L34;
        return;
    L34:
        if (Logger.debug() == false) goto L36;
        Logger.d(f2484a, "httpdns request not return in httpdns prefer time for host : " + r12.getHost());     // Catch: Throwable -> L226
    L36:
        a(r12, a(r12.getHost(), r12.isLocalDnsExpired()));     // Catch: Throwable -> L226
        a r10 = this.q;     // Catch: Throwable -> L226
    L37:
        r10.b(r12);     // Catch: Throwable -> L226
        return;
    L39:
        if (ZeusTransformUtils.instanceOf(r11.obj, c.class) == true) goto L41;
    L71:
        int r6 = 0;
        if (ZeusTransformUtils.instanceOf(r11.obj, g.class) == false) goto L104;
        if (r11.what != 1) goto L104;
        if (Logger.debug() == false) goto L78;
        Logger.d(f2484a, "MSG_LOCALDNS_COMPLETED");     // Catch: Throwable -> L226
    L78:
        String r13 = r11.getData().getString("localdns_completed_host");     // Catch: Throwable -> L226
        if (r13 != null) goto L85;
        if (Logger.debug() == false) goto L248;
        Logger.d(f2484a, "MSG_HTTPDNS_COMPLETED host is null");     // Catch: Throwable -> L226
        return;
    L248:
        return;
    L85:
        if (this.q.l(r13) == true) goto L87;
        return;
    L87:
        if (Logger.debug() == false) goto L89;
        Logger.d(f2484a, "localdns returned in localdns timeout for host : " + r13);     // Catch: Throwable -> L226
    L89:
        Iterator<HostResolveJob> r0 = this.q.k(r13).iterator();     // Catch: Throwable -> L226
    L91:
        if (r0.hasNext() == false) goto L275;
        HostResolveJob r1 = (HostResolveJob) ZeusTransformUtils.preCheckCast(r0.next(), HostResolveJob.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L226
        DnsResult r2 = a(r13, true);     // Catch: Throwable -> L226
        if (r2 != null) goto L99;
        r2 = b(r13, false);     // Catch: Throwable -> L226
        if (r2 != null) goto L97;
        a(r1);     // Catch: Throwable -> L226
        this.q.a(r1.getHost(), r1);     // Catch: Throwable -> L226
    L101:
        this.q.d(r1);     // Catch: Throwable -> L226
    L97:
        a(r1, r2);     // Catch: Throwable -> L226
        goto L101
    L99:
        if (Logger.debug() == false) goto L97;
        Logger.d(f2484a, "localdns request is returned in timeout for " + r13);     // Catch: Throwable -> L226
        goto L97
    L275:
        return;
    L104:
        if (ZeusTransformUtils.instanceOf(r11.obj, b.class) == false) goto L130;
        if (r11.what != 3) goto L130;
        if (Logger.debug() == false) goto L110;
        Logger.d(f2484a, "MSG_LOCALDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L226
    L110:
        HostResolveJob r14 = (HostResolveJob) ZeusTransformUtils.preCheckCast(r11.getData().getSerializable("dns_timeout_job_key"), HostResolveJob.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L226
        if (r14 != null) goto L117;
        if (Logger.debug() == false) goto L249;
        Logger.d(f2484a, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L226
        return;
    L249:
        return;
    L117:
        if (this.q.c(r14) == true) goto L119;
        return;
    L119:
        if (Logger.debug() == false) goto L121;
        Logger.d(f2484a, "local request not return in localdns timeout for host : " + r14.getHost());     // Catch: Throwable -> L226
    L121:
        DnsResult r3 = b(r14.getHost(), false);     // Catch: Throwable -> L226
        if (r3 == null) goto L125;
        a(r14, r3);     // Catch: Throwable -> L226
    L128:
        this.q.d(r14);     // Catch: Throwable -> L226
        return;
    L125:
        if (this.q.e(r14.getHost()) == true) goto L127;
        a(r14);     // Catch: Throwable -> L226
    L127:
        this.q.a(r14.getHost(), r14);     // Catch: Throwable -> L226
    L130:
        if (ZeusTransformUtils.instanceOf(r11.obj, b.class) == false) goto L146;
        if (r11.what != 4) goto L146;
        if (Logger.debug() == false) goto L136;
        Logger.d(f2484a, "MSG_HTTPDNS_REQUEST_TIMEOUT");     // Catch: Throwable -> L226
    L136:
        r12 = (HostResolveJob) ZeusTransformUtils.preCheckCast(r11.getData().getSerializable("dns_timeout_job_key"), HostResolveJob.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L226
        if (r12 != null) goto L143;
        if (Logger.debug() == false) goto L250;
        Logger.d(f2484a, "MSG_HTTPDNS_PREFER_TIMEOUT job is null");     // Catch: Throwable -> L226
        return;
    L250:
        return;
    L143:
        if (this.q.a(r12) == false) goto L258;
        a(r12, null);     // Catch: Throwable -> L226
        r10 = this.q;     // Catch: Throwable -> L226
        goto L37
    L258:
        return;
    L146:
        if (ZeusTransformUtils.instanceOf(r11.obj, b.class) == false) goto L172;
        if (r11.what != 5) goto L172;
        if (Logger.debug() == false) goto L152;
        Logger.d(f2484a, "MSG_LOAD_LOCAL_HARDCODEIPS");     // Catch: Throwable -> L226
    L152:
        String r15 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.s.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences("dispatchersdk_httpdns_hardcodeips", 0).getString("httpdns_hardcodeips", "");     // Catch: Throwable -> L226
        if (TextUtils.isEmpty(r15) == true) goto L167;
        this.h.clear();     // Catch: Throwable -> L226
        JSONArray r4 = new JSONArray(r15);     // Catch: JSONException -> L162 Throwable -> L226
    L157:
        if (r6 >= r4.length()) goto L276;
        String r16 = r4.optString(r6);     // Catch: JSONException -> L162 Throwable -> L226
        if (TextUtils.isEmpty(r16) == true) goto L161;
        this.h.add(r16);     // Catch: JSONException -> L162 Throwable -> L226
    L161:
        r6 = r6 + 1;
        goto L157
    L276:
        return;
    L163:
        if (Logger.debug() == false) goto L259;
        String r17 = f2484a;     // Catch: Throwable -> L226
        String r18 = "local httpdns hardcode ips not exists, use default";
    L165:
        Logger.d(r17, r18);     // Catch: Throwable -> L226
        return;
    L259:
        return;
    L167:
        if (this.s.d() != null) goto L169;
        return;
    L169:
        if (this.h.size() != 0) goto L262;
        this.h.addAll(Arrays.asList(this.s.d()));     // Catch: Throwable -> L226
        return;
    L262:
        return;
    L172:
        if (ZeusTransformUtils.instanceOf(r11.obj, b.class) == false) goto L180;
        if (r11.what != 6) goto L180;
        if (Logger.debug() == false) goto L178;
        Logger.d(f2484a, "network changed");     // Catch: Throwable -> L226
    L178:
        this.q.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a().d().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L226
        return;
    L180:
        if (ZeusTransformUtils.instanceOf(r11.obj, b.class) == false) goto L188;
        if (r11.what != 7) goto L188;
        if (Logger.debug() == false) goto L186;
        Logger.d(f2484a, "activity resume, detect ipv6 reachable");     // Catch: Throwable -> L226
    L186:
        j();     // Catch: Throwable -> L226
        return;
    L188:
        if (ZeusTransformUtils.instanceOf(r11.obj, DnsRecord.class) == false) goto L215;
        String r19 = r11.getData().getString("dnsrecord_host");     // Catch: Throwable -> L226
        if (TextUtils.isEmpty(r19) == false) goto L196;
        if (Logger.debug() == false) goto L251;
        Logger.d(f2484a, "DnsRecord refresh host is null");     // Catch: Throwable -> L226
        return;
    L251:
        return;
    L196:
        switch(r11.what) {
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
        Logger.d(f2484a, "remove httpdns cache for host : " + r19);     // Catch: Throwable -> L226
    L201:
        a().b(r19);     // Catch: Throwable -> L226
        return;
    L203:
        if (Logger.debug() == false) goto L205;
        Logger.d(f2484a, "add host : " + r19 + " to stale cache host list");     // Catch: Throwable -> L226
    L205:
        a().c(r19);     // Catch: Throwable -> L226
        return;
    L207:
        if (Logger.debug() == false) goto L209;
        Logger.d(f2484a, "remove localdns cache for host : " + r19);     // Catch: Throwable -> L226
    L209:
        a().d(r19);     // Catch: Throwable -> L226
        return;
    L211:
        if (Logger.debug() == false) goto L213;
        Logger.d(f2484a, "refresh httpdns cache for host : " + r19);     // Catch: Throwable -> L226
    L213:
        a().a(r19);     // Catch: Throwable -> L226
        return;
    L215:
        if (ZeusTransformUtils.instanceOf(r11.obj, a.class) == false) goto L223;
        if (r11.what != 20) goto L223;
        if (Logger.debug() == false) goto L221;
        Logger.d(f2484a, "reset httpdns domain failed count");     // Catch: Throwable -> L226
    L221:
        this.q.e();     // Catch: Throwable -> L226
        return;
    L223:
        if (Logger.debug() == false) goto L272;
        r17 = f2484a;     // Catch: Throwable -> L226
        r18 = "HTTPDNS-CollectResult handler thread receive a unknown message : " + r11;     // Catch: Throwable -> L226
        goto L165
    L272:
        return;
    L41:
        if (r11.what != 3) goto L71;
        if (Logger.debug() == false) goto L45;
        Logger.d(f2484a, "MSG_HTTPDNS_COMPLETED");     // Catch: Throwable -> L226
    L45:
        ArrayList<String> r110 = r11.getData().getStringArrayList("httpdns_completed_hosts");     // Catch: Throwable -> L226
        if (r110 == null) goto L48;
        Iterator<String> r5 = r110.iterator();     // Catch: Throwable -> L226
    L53:
        if (r5.hasNext() == false) goto L274;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L226
        if (this.q.j(r7) == false) goto L53;
        if (Logger.debug() == false) goto L60;
        Logger.d(f2484a, "httpdns returned in httpdns prefer time for host : " + r110);     // Catch: Throwable -> L226
    L60:
        Iterator<HostResolveJob> r8 = this.q.i(r7).iterator();     // Catch: Throwable -> L226
    L62:
        if (r8.hasNext() == false) goto L53;
        HostResolveJob r9 = (HostResolveJob) ZeusTransformUtils.preCheckCast(r8.next(), HostResolveJob.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L226
        DnsResult r20 = b(r7, true);     // Catch: Throwable -> L226
        if (a().g().get() == false) goto L68;
        if (r20 != null) goto L68;
        r20 = a(r7, r9.isLocalDnsExpired());     // Catch: Throwable -> L226
    L68:
        if (Logger.debug() == false) goto L70;
        Logger.d(f2484a, "httpdns request is returned in prefer time for " + r7);     // Catch: Throwable -> L226
    L70:
        a(r9, r20);     // Catch: Throwable -> L226
        this.q.b(r9);     // Catch: Throwable -> L226
        goto L62
    L274:
        return;
    L48:
        if (Logger.debug() == false) goto L247;
        Logger.d(f2484a, "MSG_HTTPDNS_COMPLETED hostlist is null");     // Catch: Throwable -> L226
        return;
    L247:
        return;
    L9:
        if (ZeusTransformUtils.instanceOf(r11.obj, c.class) == true) goto L231;
        if (ZeusTransformUtils.instanceOf(r11.obj, g.class) == true) goto L231;
        if (ZeusTransformUtils.instanceOf(r11.obj, DnsRecord.class) == true) goto L231;
        if (ZeusTransformUtils.instanceOf(r11.obj, a.class) == true) goto L231;
    }

    public void i() {
        Message r0 = Message.obtain();
        r0.obj = this;
        r0.what = 6;
        v.sendMessage(r0);
    }

    void j() {
        f2485b.submit(new f());     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public HandlerThread k() {
        return u;
    }
}
