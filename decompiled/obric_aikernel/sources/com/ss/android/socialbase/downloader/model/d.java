package com.ss.android.socialbase.downloader.model;

import androidx.annotation.NonNull;
import androidx.core.view.PointerIconCompat;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.exception.BaseException;
import ib.a0;
import ib.b0;
import ib.d0;
import ib.k;
import ib.k0;
import ib.m;
import ib.o;
import ib.s;
import ib.u;
import ib.y;
import ib.z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jb.q;
import org.json.JSONObject;
import qb.l;
import qb.t;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DownloadInfo f8149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<ListenerType, a0> f8150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Integer, ListenerType> f8151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Integer, a0> f8152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Integer, a0> f8153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Integer, a0> f8154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d0 f8155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private z f8156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private o f8157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private b0 f8158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private DownloadInfo.b f8159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private y f8160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private s f8161m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private k0 f8162n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private k f8163o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f8164p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private u f8165q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final List<m> f8166r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f8167s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private f f8168t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private e f8169u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8170v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f8171w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f8172x;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ q f8173c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f8174g;

        a(d r10, q r11) {
            this.f8174g = r10;
            this.f8173c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r10 = this.f8174g.n();
            q r11 = this.f8173c;
            if (r11 == null) goto L6;
            r11.a(r10);
            return;
        }
    }

    public d() {
        this.f8150b = new ConcurrentHashMap();
        this.f8151c = new ConcurrentHashMap();
        this.f8164p = false;
        this.f8166r = new CopyOnWriteArrayList();
        this.f8167s = false;
        this.f8168t = new f();
        this.f8169u = new e();
        this.f8171w = true;
        this.f8172x = 0;
        this.f8159k = new DownloadInfo.b();
        this.f8152d = new ConcurrentHashMap();
        this.f8153e = new ConcurrentHashMap();
        this.f8154f = new ConcurrentHashMap();
    }

    public d(DownloadInfo r10) {
        this();
        this.f8149a = r10;
    }

    private void Z(Map<Integer, a0> r10, Map<Integer, a0> r11) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L11;
        Iterator<Map.Entry<Integer, a0>> r12 = r11.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        r10.remove(r12.next().getKey());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private void a(Map<Integer, a0> r10, Map<Integer, a0> r11) {
        if (r10 == null) goto L9;
        if (r11 == null) goto L11;
        Iterator<Map.Entry<Integer, a0>> r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L12;
        Map.Entry<Integer, a0> r13 = r12.next();
        r11.put(r13.getKey(), r13.getValue());
        goto L7
    L12:
        return;
    L11:
        return;
    }

    private void e(ListenerType r10) {
        Map<Integer, a0> r11 = B(r10);
        if (r11 != null) goto L6;
        lb.a.h("DownloadTask", x(), "addListenerToDownloadingSameTask", "ListenerType is null");
        return;
    L6:
        Iterator<a0> r12 = r11.values().iterator();
    L8:
        if (r12.hasNext() == false) goto L12;
        a0 r13 = r12.next();
        if (r13 == null) goto L8;
        ((t) qb.k.a(t.class)).c(x(), r13, r10, false);
        goto L8
    }

    private int[] h0(Set<Integer> r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.isEmpty() == true) goto L14;
        Object[] r11 = r10.toArray();
        int[] r12 = new int[r11.length];
        int r13 = 0;
    L8:
        if (r13 >= r11.length) goto L10;
        r12[r13] = ((Integer) r11[r13]).intValue();
        r13 = r13 + 1;
        goto L8
    L10:
        return r12;
    L14:
        return null;
    }

    private void k(Map<Integer, a0> r10, Map<Integer, a0> r11) {
        r10.clear();
        Iterator<Map.Entry<Integer, a0>> r12 = r11.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Map.Entry<Integer, a0> r13 = r12.next();
        if (r13.getValue() == null) goto L4;
        r10.put(r13.getKey(), r13.getValue());
        goto L4
    }

    private int o() {
        long r10 = System.currentTimeMillis();
        this.f8149a = this.f8159k.N();
        f r11 = this.f8168t;
        r11.f8181a = r10;
        r11.f8182b = System.currentTimeMillis();
        t r12 = (t) qb.k.a(t.class);
        if (r12.a(this.f8149a.getId()) != null) goto L5;
        ((qb.o) qb.k.a(qb.o.class)).b(this, null, 0);
    L5:
        r12.y(this);
        DownloadInfo r13 = this.f8149a;
        if (r13 != null) goto L9;
        return 0;
    L9:
        return r13.getId();
    }

    public int[] A(ListenerType r10) {
        if (r10 != ListenerType.MAIN) goto L8;
        Map<Integer, a0> r11 = this.f8152d;
    L6:
        return h0(r11.keySet());
    L8:
        if (r10 != ListenerType.SUB) goto L11;
        r11 = this.f8153e;
        goto L6
    L11:
        if (r10 != ListenerType.NOTIFICATION) goto L13;
        r11 = this.f8154f;
        goto L6
    L13:
        return null;
    }

    public Map<Integer, a0> B(ListenerType r10) {
        if (r10 != ListenerType.MAIN) goto L7;
        return this.f8152d;
    L7:
        if (r10 != ListenerType.SUB) goto L11;
        return this.f8153e;
    L11:
        if (r10 == ListenerType.NOTIFICATION) goto L13;
        return null;
    L13:
        return this.f8154f;
    }

    public u C() {
        return this.f8165q;
    }

    public y D() {
        return this.f8160l;
    }

    public int E() {
        return this.f8170v;
    }

    public z F() {
        return this.f8156h;
    }

    public b0 G() {
        return this.f8158j;
    }

    public k0 H() {
        return this.f8162n;
    }

    public d0 I() {
        return this.f8155g;
    }

    public a0 J(ListenerType r10) {
        return this.f8150b.get(r10);
    }

    public int K() {
        return this.f8172x;
    }

    public e L() {
        return this.f8169u;
    }

    public f M() {
        return this.f8168t;
    }

    public d N(z r10) {
        this.f8156h = r10;
        return this;
    }

    public boolean O() {
        return this.f8171w;
    }

    public boolean P() {
        return this.f8164p;
    }

    public d Q(int r10, a0 r11) {
        if (r11 == null) goto L18;
        Map<Integer, a0> r12 = this.f8152d;
        monitor-enter(r12);
        this.f8152d.put(Integer.valueOf(r10), r11);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        Map<ListenerType, a0> r13 = this.f8150b;
        ListenerType r14 = ListenerType.MAIN;
        r13.put(r14, r11);
        Map<Integer, ListenerType> r15 = this.f8151c;
        monitor-enter(r15);
        this.f8151c.put(Integer.valueOf(r10), r14);     // Catch: Throwable -> L12
        monitor-exit(r15);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public d R(String r10) {
        this.f8159k.T(r10);
        return this;
    }

    public d S(b0 r10) {
        this.f8158j = r10;
        return this;
    }

    public d T(String r10) {
        this.f8159k.V(r10);
        return this;
    }

    public d U(boolean r10) {
        this.f8159k.W(r10);
        return this;
    }

    public d V(k0 r10) {
        this.f8162n = r10;
        return this;
    }

    public d W(d0 r10) {
        this.f8155g = r10;
        return this;
    }

    public d X(int r10, a0 r11) {
        if (r11 == null) goto L18;
        Map<Integer, a0> r12 = this.f8154f;
        monitor-enter(r12);
        this.f8154f.put(Integer.valueOf(r10), r11);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        Map<ListenerType, a0> r13 = this.f8150b;
        ListenerType r14 = ListenerType.NOTIFICATION;
        r13.put(r14, r11);
        Map<Integer, ListenerType> r15 = this.f8151c;
        monitor-enter(r15);
        this.f8151c.put(Integer.valueOf(r10), r14);     // Catch: Throwable -> L12
        monitor-exit(r15);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public d Y(boolean r10) {
        this.f8159k.a0(r10);
        return this;
    }

    public void a0(ListenerType r10, a0 r11) {
        if (this.f8167s == true) goto L5;
        return;
    L5:
        if (r10 != ListenerType.NONE) goto L8;
        return;
    L8:
        if (lb.a.a() == false) goto L11;
        lb.a.g("DownloadTask", this.f8149a.getId(), "removeCallback", "ListenerType:" + r10 + " listener:" + r11);
    L11:
        if (r11 != null) goto L13;
        int r12 = 0;
    L14:
        b0(r12, r11, r10, false);
        return;
    L13:
        r12 = r11.hashCode();
        goto L14
    }

    public d b(m r10) {
        List<m> r11 = this.f8166r;
        monitor-enter(r11);
        if (r10 != null) goto L16;
    L11:
        monitor-exit(r11);     // Catch: Throwable -> L13
        return this;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.f8166r.contains(r10) == true) goto L11;
        this.f8166r.add(r10);     // Catch: Throwable -> L13
        monitor-exit(r11);     // Catch: Throwable -> L13
        return this;
    }

    public void b0(int r10, a0 r11, ListenerType r12, boolean r13) {
        Map<Integer, a0> r14 = B(r12);
        if (r14 != null) goto L9;
        if (r13 == true) goto L6;
        return;
    L6:
        if (this.f8150b.containsKey(r12) == false) goto L44;
        this.f8150b.remove(r12);
        return;
    L44:
        return;
    L9:
        monitor-enter(r14);
        if (r13 == true) goto L12;
        r14.remove(Integer.valueOf(r10));     // Catch: Throwable -> L34
        Map<Integer, ListenerType> r15 = this.f8151c;     // Catch: Throwable -> L34
        monitor-enter(r15);     // Catch: Throwable -> L34
        ListenerType r16 = this.f8151c.get(Integer.valueOf(r10));     // Catch: Throwable -> L31
        if (r16 != null) goto L26;
    L28:
        monitor-exit(r15);     // Catch: Throwable -> L31
    L29:
        monitor-exit(r14);     // Catch: Throwable -> L34
        return;
    L26:
        if (this.f8150b.containsKey(r16) == false) goto L28;
        this.f8150b.remove(r16);     // Catch: Throwable -> L31
        this.f8151c.remove(Integer.valueOf(r10));     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L12:
        if (this.f8150b.containsKey(r12) == false) goto L14;
        r11 = this.f8150b.get(r12);     // Catch: Throwable -> L34
        this.f8150b.remove(r12);     // Catch: Throwable -> L34
    L14:
        if (r11 == null) goto L29;
        Iterator<Map.Entry<Integer, a0>> r17 = r14.entrySet().iterator();     // Catch: Throwable -> L34
    L17:
        if (r17.hasNext() == false) goto L29;
        if (r17.next().getValue() != r11) goto L17;
        r17.remove();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public void c(int r10, a0 r11, ListenerType r12, boolean r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r13 == false) goto L15;
        Map<ListenerType, a0> r14 = this.f8150b;
        if (r14 == null) goto L15;
        r14.put(r12, r11);
        Map<Integer, ListenerType> r15 = this.f8151c;
        monitor-enter(r15);
        this.f8151c.put(Integer.valueOf(r10), r12);     // Catch: Throwable -> L12
        monitor-exit(r15);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        Map<Integer, a0> r16 = B(r12);
        if (r16 != null) goto L18;
        return;
    L18:
        monitor-enter(r16);
        r16.put(Integer.valueOf(r10), r11);     // Catch: Throwable -> L22
        monitor-exit(r16);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }

    public d c0(int r10) {
        this.f8159k.c0(r10);
        return this;
    }

    public void d() {
        if (this.f8149a != null) goto L5;
    L10:
        e(ListenerType.MAIN);
        e(ListenerType.SUB);
        ((qb.o) qb.k.a(qb.o.class)).a(this.f8158j, this.f8149a, new BaseException(PointerIconCompat.TYPE_HELP, "has another same task, add Listener to old task"), 0);
        return;
    L5:
        if (lb.a.a() == false) goto L8;
        lb.a.g("DownloadTask", this.f8149a.getId(), "addListenerToDownloadingSameTask", "Same task just tryDownloading, so add listener in last task instead of tryDownload");
    L8:
        if (this.f8149a.isAddListenerToSameTask() == true) goto L10;
        this.f8149a.setAddListenerToSameTask(true);
        goto L10
    }

    public d d0(String r10) {
        this.f8159k.d0(r10);
        return this;
    }

    public void e0(Map<Integer, a0> r10, ListenerType r11) {
        if (r10 != null) goto L43;
        return;
    L43:
    L34:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        if (r11 != ListenerType.MAIN) goto L15;
        Map<Integer, a0> r12 = this.f8152d;     // Catch: Throwable -> L34
        monitor-enter(r12);     // Catch: Throwable -> L34
        k(this.f8152d, r10);     // Catch: Throwable -> L11
        monitor-exit(r12);     // Catch: Throwable -> L11
    L44:
        return;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L15:
        if (r11 != ListenerType.SUB) goto L25;
        Map<Integer, a0> r13 = this.f8153e;     // Catch: Throwable -> L34
        monitor-enter(r13);     // Catch: Throwable -> L34
        k(this.f8153e, r10);     // Catch: Throwable -> L21
        monitor-exit(r13);     // Catch: Throwable -> L21
    L45:
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L25:
        if (r11 != ListenerType.NOTIFICATION) goto L46;
        Map<Integer, a0> r14 = this.f8154f;     // Catch: Throwable -> L34
        monitor-enter(r14);     // Catch: Throwable -> L34
        k(this.f8154f, r10);     // Catch: Throwable -> L31
        monitor-exit(r14);     // Catch: Throwable -> L31
    L47:
        return;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    }

    public void f(q r10) {
        ((l) qb.k.a(l.class)).b(new a(this, r10));
    }

    public void f0(boolean r10) {
        this.f8164p = r10;
    }

    public synchronized int g() {
        monitor-enter(this);
        a0 r10 = J(ListenerType.MAIN);     // Catch: Throwable -> L11
        if (r10 != null) goto L6;
        r10 = J(ListenerType.SUB);     // Catch: Throwable -> L11
    L6:
        if (r10 == null) goto L8;
        this.f8170v = r10.hashCode();     // Catch: Throwable -> L11
    L8:
        int r11 = this.f8170v;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r11;
    L11:
        th = move-exception;
        throw th;
    }

    public void g0(d0 r10) {
        this.f8155g = r10;
    }

    public d h(boolean r10) {
        this.f8159k.L(r10);
        return this;
    }

    public boolean i() {
        DownloadInfo r10 = this.f8149a;
        if (r10 != null) goto L5;
        return false;
    L5:
        return r10.canShowNotification();
    }

    public d i0(a0 r10) {
        if (r10 != null) goto L5;
        return this;
    L5:
        return j0(r10.hashCode(), r10);
    }

    public void j(d r10) {
        Iterator<Map.Entry<ListenerType, a0>> r11 = r10.f8150b.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L48;
        Map.Entry<ListenerType, a0> r12 = r11.next();
        if (r12 == null) goto L4;
        if (this.f8150b.containsKey(r12.getKey()) == true) goto L4;
        this.f8150b.put(r12.getKey(), r12.getValue());
        goto L4
    L48:
    L41:
        th = move-exception;
        th.printStackTrace();
        return;
    L12:
        if (r10.f8152d.size() == 0) goto L22;
        Map<Integer, a0> r13 = this.f8152d;     // Catch: Throwable -> L41
        monitor-enter(r13);     // Catch: Throwable -> L41
        Z(this.f8152d, r10.f8152d);     // Catch: Throwable -> L18
        a(r10.f8152d, this.f8152d);     // Catch: Throwable -> L18
        monitor-exit(r13);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L22:
        if (r10.f8153e.size() == 0) goto L32;
        Map<Integer, a0> r14 = this.f8153e;     // Catch: Throwable -> L41
        monitor-enter(r14);     // Catch: Throwable -> L41
        Z(this.f8153e, r10.f8153e);     // Catch: Throwable -> L28
        a(r10.f8153e, this.f8153e);     // Catch: Throwable -> L28
        monitor-exit(r14);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L32:
        if (r10.f8154f.size() == 0) goto L57;
        Map<Integer, a0> r15 = this.f8154f;     // Catch: Throwable -> L41
        monitor-enter(r15);     // Catch: Throwable -> L41
        Z(this.f8154f, r10.f8154f);     // Catch: Throwable -> L38
        a(r10.f8154f, this.f8154f);     // Catch: Throwable -> L38
        monitor-exit(r15);     // Catch: Throwable -> L38
    L58:
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    }

    public d j0(int r10, a0 r11) {
        if (r11 == null) goto L18;
        Map<Integer, a0> r12 = this.f8153e;
        monitor-enter(r12);
        this.f8153e.put(Integer.valueOf(r10), r11);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        Map<ListenerType, a0> r13 = this.f8150b;
        ListenerType r14 = ListenerType.SUB;
        r13.put(r14, r11);
        Map<Integer, ListenerType> r15 = this.f8151c;
        monitor-enter(r15);
        this.f8151c.put(Integer.valueOf(r10), r14);     // Catch: Throwable -> L12
        monitor-exit(r15);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L15:
        th = move-exception;
        throw th;
    L18:
        return this;
    }

    public d k0(String r10) {
        this.f8159k.f0(r10);
        return this;
    }

    public d l(o r10) {
        this.f8157i = r10;
        return this;
    }

    public d l0(String r10) {
        this.f8159k.h0(r10);
        return this;
    }

    public d m(s r10) {
        this.f8161m = r10;
        return this;
    }

    public int n() {
        if (rb.a.j().n("fix_anr_remove_report_idle_status") <= 0) goto L5;
        long r10 = System.currentTimeMillis();
        this.f8149a = this.f8159k.N();
        f r11 = this.f8168t;
        r11.f8181a = r10;
        r11.f8182b = System.currentTimeMillis();
        int r12 = this.f8149a.getId();
        ((t) qb.k.a(t.class)).y(this);
        return r12;
    L5:
        return o();
    }

    public d p(JSONObject r10) {
        this.f8159k.P(r10);
        return this;
    }

    public d q(u r10) {
        this.f8165q = r10;
        return this;
    }

    public d r(y r10) {
        this.f8160l = r10;
        return this;
    }

    public k s() {
        return this.f8163o;
    }

    public o t() {
        return this.f8157i;
    }

    public s u() {
        return this.f8161m;
    }

    public m v(int r10) {
        List<m> r11 = this.f8166r;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r10 >= this.f8166r.size()) goto L9;
        m r12 = this.f8166r.get(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return r12;
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return null;
    }

    @NonNull
    public List<m> w() {
        return this.f8166r;
    }

    public int x() {
        DownloadInfo r10 = this.f8149a;
        if (r10 != null) goto L7;
        return 0;
    L7:
        return r10.getId();
    }

    public DownloadInfo y() {
        return this.f8149a;
    }

    public a0 z(ListenerType r10, int r11) {
        if (r10 != ListenerType.MAIN) goto L8;
        Map<Integer, a0> r12 = this.f8152d;
    L6:
        return r12.get(Integer.valueOf(r11));
    L8:
        if (r10 != ListenerType.SUB) goto L11;
        r12 = this.f8153e;
        goto L6
    L11:
        if (r10 != ListenerType.NOTIFICATION) goto L13;
        r12 = this.f8154f;
        goto L6
    L13:
        return null;
    }
}
