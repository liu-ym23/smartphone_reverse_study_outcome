package e7;

import android.content.Context;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l7.d<String, a> f7157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f7159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f7160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f7161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap f7162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentSkipListSet<String> f7163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f7164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f7165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r5.e.a f7166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f7167k;

    public d(WeakHandler r8) {
        this.f7157a = new l7.d(100);
        this.f7158b = new ConcurrentHashMap();
        this.f7159c = new ConcurrentHashMap();
        this.f7160d = new ConcurrentHashMap();
        this.f7161e = new ConcurrentHashMap();
        this.f7162f = new ConcurrentHashMap();
        this.f7163g = new ConcurrentSkipListSet();
        this.f7164h = new AtomicInteger(0);
        this.f7165i = new AtomicInteger(0);
        this.f7166j = r5.e.a.f11507m;
        this.f7167k = r8;
    }

    public final synchronized void a(c r8) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f7161e.containsKey(null) == false) goto L6;
        ((ConcurrentSkipListSet) this.f7161e.get(null)).add(r8);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        ConcurrentSkipListSet r10 = new ConcurrentSkipListSet();     // Catch: Throwable -> L9
        r10.add(r8);     // Catch: Throwable -> L9
        this.f7161e.put(null, r10);     // Catch: Throwable -> L9
        goto L7
    }

    public final void b(String r8, Future<Void> r10) {
        this.f7159c.put(r8, r10);
    }

    public final void c(String r8, a r10) {
        a r11 = h(r8);
        if (r11 == null) goto L5;
        r11.d();
    L5:
        r10.a();
        this.f7158b.put(r8, r10);
    }

    public final void d(String r8, Future<Void> r10) {
        this.f7160d.put(r8, r10);
    }

    public final a e(String r8) {
        Map<String, a> r10 = this.f7157a.c();
        monitor-enter(r10);
        a r11 = this.f7157a.b(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public final ConcurrentSkipListSet<c> f(String r8) {
        return (ConcurrentSkipListSet) this.f7161e.get(r8);
    }

    public final Future<Void> g(String r8) {
        ConcurrentHashMap r10 = this.f7159c;
        if (r10.containsKey(r8) == true) goto L5;
        return null;
    L5:
        return (Future) r10.get(r8);
    }

    public final a h(String r8) {
        ConcurrentHashMap r10 = this.f7158b;
        if (r10.containsKey(r8) == true) goto L5;
        return null;
    L5:
        return (a) r10.get(r8);
    }

    public final ConcurrentSkipListSet<c> i(String r8) {
        return (ConcurrentSkipListSet) this.f7162f.get(r8);
    }

    public final Future<Void> j(String r8) {
        ConcurrentHashMap r10 = this.f7160d;
        if (r10.containsKey(r8) == true) goto L5;
        return null;
    L5:
        return (Future) r10.get(r8);
    }

    public final boolean k(String r8) {
        return this.f7159c.containsKey(r8);
    }

    public final boolean l(String r8) {
        return this.f7160d.containsKey(r8);
    }

    public final void m(Context r8) {
        r5.e.a r10 = r5.e.c(r8);
        if (r10 == this.f7166j) goto L29;
        Logger.d("d", "network changed, clear cache and re-batch-preload preload hosts, current net type is " + r10);
        Map<String, a> r11 = this.f7157a.c();
        monitor-enter(r11);
        Iterator<Map.Entry<String, a>> r12 = this.f7157a.c().entrySet().iterator();     // Catch: Throwable -> L26
    L8:
        if (r12.hasNext() == false) goto L15;
        Map.Entry<String, a> r13 = r12.next();     // Catch: Throwable -> L26
        if (r13 == null) goto L8;
        if (e.g().h().get() == true) goto L13;
        r13.getValue().c();     // Catch: Throwable -> L26
        goto L8
    L13:
        r13.getValue().b();     // Catch: Throwable -> L26
        goto L8
    L15:
        this.f7157a.a();     // Catch: Throwable -> L26
        monitor-exit(r11);     // Catch: Throwable -> L26
        Iterator r14 = this.f7158b.entrySet().iterator();
    L19:
        if (r14.hasNext() == false) goto L23;
        Map.Entry r15 = (Map.Entry) r14.next();
        if (r15 == null) goto L19;
        ((a) r15.getValue()).d();
        goto L19
    L23:
        this.f7158b.clear();
        if (r10 == r5.e.a.f11507m) goto L29;
        e.g().c(a.EnumC0065a.f7141b);
        e.g().getClass();
        e.o();
    L26:
        th = move-exception;
        throw th;
    L29:
        this.f7166j = r10;
    }

    public final void n(String r8) {
        a r10 = e(r8);
        if (r10 != null) goto L5;
        return;
    L5:
        if (e.g().f7169b.get() == false) goto L7;
        r10.b();
    L8:
        Map<String, a> r11 = this.f7157a.c();
        monitor-enter(r11);
        l7.d<String, a> r12 = this.f7157a;     // Catch: Throwable -> L24
        monitor-enter(r12);     // Catch: Throwable -> L24
        if (r8 == null) goto L20;
        if (r12.f9166a.remove(r8) == null) goto L16;
        r12.f9167b--;     // Catch: Throwable -> L21
    L16:
        monitor-exit(r12);     // Catch: Throwable -> L24
        monitor-exit(r11);     // Catch: Throwable -> L24
        return;
    L20:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L7:
        r10.c();
        goto L8
    }

    public final void o(c r8) {
        ConcurrentHashMap r10 = this.f7161e;
        if (r10.containsKey(null) == false) goto L8;
        ((ConcurrentSkipListSet) r10.get(null)).remove(r8);
        if (((ConcurrentSkipListSet) r10.get(null)).isEmpty() == false) goto L9;
        r10.remove(null);
        return;
    L9:
        return;
    }

    public final void p(String r8) {
        this.f7159c.remove(r8);
    }

    public final void q(String r8) {
        a r10 = h(r8);
        if (r10 == null) goto L6;
        r10.d();
        this.f7158b.remove(r8);
        return;
    }

    public final void r(c r8) {
        r8.getClass();
        ConcurrentHashMap r10 = this.f7162f;
        if (r10.containsKey(null) == false) goto L8;
        ((ConcurrentSkipListSet) r10.get(null)).remove(r8);
        if (((ConcurrentSkipListSet) r10.get(null)).isEmpty() == false) goto L9;
        r10.remove(null);
        return;
    L9:
        return;
    }

    public final void s(String r8) {
        this.f7160d.remove(r8);
    }

    public final boolean t(String r8) {
        return this.f7161e.containsKey(r8);
    }

    public final boolean u(c r8) {
        ConcurrentHashMap r10 = this.f7161e;
        if (r10.containsKey(null) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentSkipListSet) r10.get(null)).contains(r8) == false) goto L7;
        return true;
    }

    public final boolean v(String r8) {
        return this.f7162f.containsKey(r8);
    }

    public final boolean w(c r8) {
        ConcurrentHashMap r10 = this.f7162f;
        if (r10.containsKey(null) == true) goto L5;
    L7:
        return false;
    L5:
        if (((ConcurrentSkipListSet) r10.get(null)).contains(r8) == false) goto L7;
        return true;
    }
}
