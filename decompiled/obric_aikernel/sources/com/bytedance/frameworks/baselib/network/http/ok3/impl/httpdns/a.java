package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.util.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f1700l = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e<String, DnsRecord> f1701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, DnsRecord> f1702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentMap<String, Future<Void>> f1703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentMap<String, Future<Void>> f1704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> f1705e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentMap<String, ConcurrentSkipListSet<HostResolveJob>> f1706f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentSkipListSet<String> f1707g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicInteger f1708h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private AtomicInteger f1709i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private NetworkUtils.NetworkType f1710j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Handler f1711k;

    static {
    }

    public a(Handler r10) {
        this.f1701a = new e(100);
        this.f1702b = new ConcurrentHashMap();
        this.f1703c = new ConcurrentHashMap();
        this.f1704d = new ConcurrentHashMap();
        this.f1705e = new ConcurrentHashMap();
        this.f1706f = new ConcurrentHashMap();
        this.f1707g = new ConcurrentSkipListSet();
        this.f1708h = new AtomicInteger(0);
        this.f1709i = new AtomicInteger(0);
        this.f1710j = NetworkUtils.NetworkType.NONE;
        this.f1711k = r10;
    }

    void A() {
        this.f1708h.getAndIncrement();
    }

    public boolean B(String r10) {
        return this.f1705e.containsKey(r10);
    }

    public boolean C(HostResolveJob r10) {
        if (this.f1705e.containsKey(r10.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1705e.get(r10.getHost()).contains(r10) == false) goto L7;
        return true;
    }

    public boolean D(String r10) {
        return this.f1706f.containsKey(r10);
    }

    public boolean E(HostResolveJob r10) {
        if (this.f1706f.containsKey(r10.getHost()) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1706f.get(r10.getHost()).contains(r10) == false) goto L7;
        return true;
    }

    public void a(String r10, DnsRecord r11) {
        DnsRecord r12 = i(r10);
        if (r12 == null) goto L9;
        if (b.q().s().get() == false) goto L7;
        r12.h();
        goto L9
    L7:
        r12.i();
    L9:
        if (b.q().s().get() == false) goto L11;
        r11.a();
    L12:
        Map<String, DnsRecord> r13 = this.f1701a.e();
        monitor-enter(r13);
        this.f1701a.f(r10, r11);     // Catch: Throwable -> L17
        monitor-exit(r13);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L11:
        r11.b();
        goto L12
    }

    void b() {
        this.f1709i.getAndIncrement();
        if (this.f1709i.get() < 2) goto L6;
        Message r10 = Message.obtain();
        r10.what = 20;
        r10.obj = this;
        this.f1711k.sendMessageDelayed(r10, 180000);
        return;
    }

    public synchronized void c(String r10, HostResolveJob r11) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f1705e.containsKey(r10) == false) goto L6;
        this.f1705e.get(r10).add(r11);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet<HostResolveJob> r12 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r12.add(r11);     // Catch: Throwable -> L9
        this.f1705e.put(r10, r12);     // Catch: Throwable -> L9
        goto L7
    }

    public void d(String r10, Future<Void> r11) {
        this.f1703c.put(r10, r11);
    }

    public void e(String r10) {
        this.f1707g.add(r10);
        if (this.f1707g.size() >= 10) goto L5;
        return;
    L5:
        ArrayList r11 = new ArrayList();
        r11.addAll(this.f1707g);
        b.q().c(r11);
    }

    public void f(String r10, DnsRecord r11) {
        DnsRecord r12 = m(r10);
        if (r12 == null) goto L5;
        r12.j();
    L5:
        r11.c();
        this.f1702b.put(r10, r11);
    }

    public void g(String r10, Future<Void> r11) {
        this.f1704d.put(r10, r11);
    }

    AtomicInteger h() {
        return this.f1708h;
    }

    public DnsRecord i(String r10) {
        Map<String, DnsRecord> r11 = this.f1701a.e();
        monitor-enter(r11);
        DnsRecord r12 = this.f1701a.d(r10);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    AtomicInteger j() {
        return this.f1709i;
    }

    public ConcurrentSkipListSet<HostResolveJob> k(String r10) {
        return this.f1705e.get(r10);
    }

    public Future<Void> l(String r10) {
        if (this.f1703c.containsKey(r10) == true) goto L5;
        return null;
    L5:
        return this.f1703c.get(r10);
    }

    public DnsRecord m(String r10) {
        if (this.f1702b.containsKey(r10) == true) goto L5;
        return null;
    L5:
        return this.f1702b.get(r10);
    }

    public ConcurrentSkipListSet<HostResolveJob> n(String r10) {
        return this.f1706f.get(r10);
    }

    public Future<Void> o(String r10) {
        if (this.f1704d.containsKey(r10) == true) goto L5;
        return null;
    L5:
        return this.f1704d.get(r10);
    }

    public boolean p(String r10) {
        return this.f1703c.containsKey(r10);
    }

    public boolean q(String r10) {
        return this.f1704d.containsKey(r10);
    }

    public void r(Context r10) {
        NetworkUtils.NetworkType r11 = NetworkUtils.e(r10);
        if (r11 != this.f1710j) goto L5;
    L32:
        this.f1710j = r11;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d(f1700l, "network changed, clear cache and re-batch-preload preload hosts, current net type is " + r11);
    L7:
        Map<String, DnsRecord> r12 = this.f1701a.e();
        monitor-enter(r12);
        Iterator<Map.Entry<String, DnsRecord>> r13 = this.f1701a.e().entrySet().iterator();     // Catch: Throwable -> L29
    L11:
        if (r13.hasNext() == false) goto L18;
        Map.Entry<String, DnsRecord> r14 = r13.next();     // Catch: Throwable -> L29
        if (r14 == null) goto L11;
        if (b.q().s().get() == true) goto L16;
        r14.getValue().i();     // Catch: Throwable -> L29
        goto L11
    L16:
        r14.getValue().h();     // Catch: Throwable -> L29
        goto L11
    L18:
        this.f1701a.c();     // Catch: Throwable -> L29
        monitor-exit(r12);     // Catch: Throwable -> L29
        Iterator<Map.Entry<String, DnsRecord>> r15 = this.f1702b.entrySet().iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        Map.Entry<String, DnsRecord> r16 = r15.next();
        if (r16 == null) goto L22;
        r16.getValue().j();
        goto L22
    L26:
        this.f1702b.clear();
        if (r11 == NetworkUtils.NetworkType.NONE) goto L32;
        b.q().e(DnsRecord.CacheStaleReason.CACHE_STALE_NETCHANGED);
        b.q().G();
    L29:
        th = move-exception;
        throw th;
    }

    public void s(String r10) {
        DnsRecord r11 = i(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (b.q().s().get() == false) goto L7;
        r11.h();
    L8:
        Map<String, DnsRecord> r12 = this.f1701a.e();
        monitor-enter(r12);
        this.f1701a.g(r10);     // Catch: Throwable -> L13
        monitor-exit(r12);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L7:
        r11.i();
        goto L8
    }

    public void t(HostResolveJob r10) {
        String r11 = r10.getHost();
        if (this.f1705e.containsKey(r11) == false) goto L8;
        this.f1705e.get(r11).remove(r10);
        if (this.f1705e.get(r11).isEmpty() == false) goto L9;
        this.f1705e.remove(r11);
        return;
    L9:
        return;
    }

    public void u(String r10) {
        this.f1703c.remove(r10);
    }

    public void v(String r10) {
        if (this.f1707g.contains(r10) == false) goto L6;
        this.f1707g.remove(r10);
        return;
    }

    public void w(String r10) {
        DnsRecord r11 = m(r10);
        if (r11 == null) goto L6;
        r11.j();
        this.f1702b.remove(r10);
        return;
    }

    public void x(HostResolveJob r10) {
        String r11 = r10.getHost();
        if (this.f1706f.containsKey(r11) == false) goto L8;
        this.f1706f.get(r11).remove(r10);
        if (this.f1706f.get(r11).isEmpty() == false) goto L9;
        this.f1706f.remove(r11);
        return;
    L9:
        return;
    }

    public void y(String r10) {
        this.f1704d.remove(r10);
    }

    void z() {
        this.f1709i.set(0);
    }
}
