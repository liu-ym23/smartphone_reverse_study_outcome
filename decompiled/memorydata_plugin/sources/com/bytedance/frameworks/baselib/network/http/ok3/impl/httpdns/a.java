package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2473a = "a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.frameworks.baselib.network.http.util.e<String, DnsRecord> f2474b;
    private ConcurrentMap<String, DnsRecord> c;
    private ConcurrentMap<String, Future<Void>> d;
    private ConcurrentMap<String, Future<Void>> e;
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> f;
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> g;
    private ConcurrentSkipListSet<String> h;
    private AtomicInteger i;
    private AtomicInteger j;
    private NetworkUtils.NetworkType k;
    private final long l;
    private final int m;
    private final Handler n;

    static {
    }

    public a(Handler r3) {
        this.f2474b = new com.bytedance.frameworks.baselib.network.http.util.e(100);
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.h = new ConcurrentSkipListSet();
        this.i = new AtomicInteger(0);
        this.j = new AtomicInteger(0);
        this.k = NetworkUtils.NetworkType.NONE;
        this.l = 180000;
        this.m = 10;
        this.n = r3;
    }

    AtomicInteger a() {
        return this.i;
    }

    public void a(Context r6) {
        NetworkUtils.NetworkType r7 = NetworkUtils.e((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"));
        if (r7 != this.k) goto L5;
    L32:
        this.k = r7;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d(f2473a, "network changed, clear cache and re-batch-preload preload hosts, current net type is " + r7);
    L7:
        Map<String, DnsRecord> r0 = this.f2474b.b();
        monitor-enter(r0);
        Iterator<Map.Entry<String, DnsRecord>> r1 = this.f2474b.b().entrySet().iterator();     // Catch: Throwable -> L29
    L11:
        if (r1.hasNext() == false) goto L18;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r2 == null) goto L11;
        if (b.a().g().get() == true) goto L16;
        ((DnsRecord) ZeusTransformUtils.preCheckCast(r2.getValue(), DnsRecord.class, "com.obric.memorydata.plugin")).d();     // Catch: Throwable -> L29
        goto L11
    L16:
        ((DnsRecord) ZeusTransformUtils.preCheckCast(r2.getValue(), DnsRecord.class, "com.obric.memorydata.plugin")).c();     // Catch: Throwable -> L29
        goto L11
    L18:
        this.f2474b.a();     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, DnsRecord>> r3 = this.c.entrySet().iterator();
    L22:
        if (r3.hasNext() == false) goto L26;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L22;
        ((DnsRecord) ZeusTransformUtils.preCheckCast(r4.getValue(), DnsRecord.class, "com.obric.memorydata.plugin")).f();
        goto L22
    L26:
        this.c.clear();
        if (r7 == NetworkUtils.NetworkType.NONE) goto L32;
        b.a().a(DnsRecord.CacheStaleReason.CACHE_STALE_NETCHANGED);
        b.a().j();
    L29:
        th = move-exception;
        throw th;
    }

    public void a(String r3) {
        DnsRecord r0 = b(r3);
        if (r0 != null) goto L5;
        return;
    L5:
        if (b.a().g().get() == false) goto L7;
        r0.c();
    L8:
        Map<String, DnsRecord> r1 = this.f2474b.b();
        monitor-enter(r1);
        this.f2474b.b(r3);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L7:
        r0.d();
        goto L8
    }

    public void a(String r3, DnsRecord r4) {
        DnsRecord r0 = b(r3);
        if (r0 == null) goto L9;
        if (b.a().g().get() == false) goto L7;
        r0.c();
        goto L9
    L7:
        r0.d();
    L9:
        if (b.a().g().get() == false) goto L11;
        r4.a();
    L12:
        Map<String, DnsRecord> r1 = this.f2474b.b();
        monitor-enter(r1);
        this.f2474b.a(r3, r4);     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L11:
        r4.b();
        goto L12
    }

    public synchronized void a(String r3, HostResolveJob r4) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f.containsKey(r3) == false) goto L6;
        ((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r3), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin")).add(r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet<HostResolveJob> r0 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r0.add(r4);     // Catch: Throwable -> L9
        this.f.put(r3, r0);     // Catch: Throwable -> L9
        goto L7
    }

    public void a(String r3, Future<Void> r4) {
        Future<Void> r5 = (Future) ZeusTransformUtils.wrapperContextForParams(r4, Future.class, "com.obric.memorydata.plugin");
        this.d.put(r3, r5);
    }

    public boolean a(HostResolveJob r3) {
        if (this.f.containsKey(r3.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r3.getHost()), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin")).contains(r3) == false) goto L7;
        return true;
    }

    public DnsRecord b(String r3) {
        Map<String, DnsRecord> r0 = this.f2474b.b();
        monitor-enter(r0);
        DnsRecord r2 = (DnsRecord) ZeusTransformUtils.preCheckCast(this.f2474b.a(r3), DnsRecord.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    void b() {
        this.i.getAndIncrement();
    }

    public void b(HostResolveJob r5) {
        String r0 = r5.getHost();
        if (this.f.containsKey(r0) == false) goto L8;
        ((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r0), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin")).remove(r5);
        if (((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r0), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
        this.f.remove(r0);
        return;
    L9:
        return;
    }

    public void b(String r2, DnsRecord r3) {
        DnsRecord r0 = d(r2);
        if (r0 == null) goto L5;
        r0.f();
    L5:
        r3.e();
        this.c.put(r2, r3);
    }

    AtomicInteger c() {
        return this.j;
    }

    public void c(String r2) {
        DnsRecord r0 = d(r2);
        if (r0 == null) goto L6;
        r0.f();
        this.c.remove(r2);
        return;
    }

    public boolean c(HostResolveJob r3) {
        if (this.g.containsKey(r3.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.g.get(r3.getHost()), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin")).contains(r3) == false) goto L7;
        return true;
    }

    public DnsRecord d(String r2) {
        if (this.c.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return (DnsRecord) ZeusTransformUtils.preCheckCast(this.c.get(r2), DnsRecord.class, "com.obric.memorydata.plugin");
    }

    void d() {
        this.j.getAndIncrement();
        if (this.j.get() < 2) goto L6;
        Message r0 = Message.obtain();
        r0.what = 20;
        r0.obj = this;
        this.n.sendMessageDelayed(r0, 180000);
        return;
    }

    public void d(HostResolveJob r5) {
        String r0 = r5.getHost();
        if (this.g.containsKey(r0) == false) goto L8;
        ((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.g.get(r0), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin")).remove(r5);
        if (((ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.g.get(r0), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L9;
        this.g.remove(r0);
        return;
    L9:
        return;
    }

    void e() {
        this.j.set(0);
    }

    public boolean e(String r1) {
        return this.d.containsKey(r1);
    }

    public void f(String r1) {
        this.d.remove(r1);
    }

    public Future<Void> g(String r2) {
        if (this.d.containsKey(r2) == true) goto L5;
        return null;
    L5:
        return (Future) ZeusTransformUtils.preCheckCast(this.d.get(r2), Future.class, "com.obric.memorydata.plugin");
    }

    public void h(String r1) {
        this.e.remove(r1);
    }

    public ConcurrentSkipListSet<HostResolveJob> i(String r2) {
        return (ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.f.get(r2), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin");
    }

    public boolean j(String r1) {
        return this.f.containsKey(r1);
    }

    public ConcurrentSkipListSet<HostResolveJob> k(String r2) {
        return (ConcurrentSkipListSet) ZeusTransformUtils.preCheckCast(this.g.get(r2), ConcurrentSkipListSet.class, "com.obric.memorydata.plugin");
    }

    public boolean l(String r1) {
        return this.g.containsKey(r1);
    }

    public void m(String r2) {
        this.h.add(r2);
        if (this.h.size() >= 10) goto L5;
        return;
    L5:
        ArrayList r3 = new ArrayList();
        r3.addAll(this.h);
        b.a().a(r3);
    }

    public void n(String r2) {
        if (this.h.contains(r2) == false) goto L6;
        this.h.remove(r2);
        return;
    }
}
