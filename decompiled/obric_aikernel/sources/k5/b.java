package k5;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m5.g;

/* JADX INFO: loaded from: classes.dex */
public class b extends h5.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private m5.e f10069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f10070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<Long, m5.e> f10071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<Long, e> f10072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private g f10073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private c f10074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private m5.c f10075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d f10076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Map<Long, m5.d> f10077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Map<Long, f> f10078n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private m5.f f10079o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private a f10080p;

    public b(Context r10, g5.c r11) {
        super(r10, r11);
        this.f10067c = false;
        this.f10068d = 0;
        this.f10069e = new m5.e();
        this.f10070f = new e();
        this.f10071g = new HashMap();
        this.f10072h = new HashMap();
        this.f10073i = new g();
        this.f10074j = new c();
        this.f10075k = new m5.c();
        this.f10076l = new d();
        this.f10077m = new HashMap();
        this.f10078n = new HashMap();
        this.f10079o = new m5.f();
        this.f10080p = new a();
    }

    private void c() {
        this.f10070f.k();
        this.f10071g.clear();
        this.f10072h.clear();
        this.f10074j.g();
        this.f10076l.d();
        this.f10077m.clear();
        this.f10078n.clear();
        this.f10080p.g();
    }

    private List<List<Integer>> d(List<LinkedHashMap<Long, Long>> r21, long r22) {
        if (r21 == null) goto L27;
        long r10 = 0;
        if (r22 <= 0) goto L37;
        ArrayList r11 = new ArrayList();
        Iterator<LinkedHashMap<Long, Long>> r12 = r21.iterator();
    L9:
        if (r12.hasNext() == false) goto L26;
        LinkedHashMap<Long, Long> r13 = r12.next();
        ArrayList r14 = new ArrayList();
        int r15 = r13.size() / 4;
        Iterator<Map.Entry<Long, Long>> r16 = r13.entrySet().iterator();
        int r17 = 0;
        long r18 = r10;
        long r19 = r18;
        int r110 = 0;
    L12:
        if (r16.hasNext() == false) goto L25;
        Map.Entry<Long, Long> r111 = r16.next();
        Long r112 = r111.getKey();
        Long r113 = r111.getValue();
        if (r112 == null) goto L12;
        if (r113 == null) goto L12;
        r19 = r19 + r113.longValue();
        if (r17 >= 3) goto L22;
        if (r110 >= r15) goto L21;
        r18 = r18 + r113.longValue();
        r110 = r110 + 1;
        goto L12
    L21:
        r14.add(Integer.valueOf((int) ((r18 / r22) * 100.0d)));
        r18 = r113.longValue();
        r17 = r17 + 1;
        r110 = 1;
        goto L12
    L22:
        if (r17 != 3) goto L12;
        r18 = r18 + r113.longValue();
        goto L12
    L25:
        double r20 = r22;
        r14.add(Integer.valueOf((int) ((r18 / r20) * 100.0d)));
        r14.add(Integer.valueOf((int) ((r19 / r20) * 100.0d)));
        r11.add(r14);
        r10 = 0;
        goto L9
    L26:
        return r11;
    L37:
        return null;
    L27:
        return null;
    }

    private g5.c.b e(List<List<Integer>> r11) {
        if (r11 != null) goto L5;
        return null;
    L5:
        boolean r10 = h(r11.size());
        boolean r12 = i(r11.size());
        g5.c.b r13 = new g5.c.b();
        Iterator<List<Integer>> r14 = r11.iterator();
        int r15 = 0;
    L7:
        if (r14.hasNext() == false) goto L26;
        List<Integer> r16 = r14.next();
        if (r16 == null) goto L7;
        if (r16.size() < 5) goto L7;
        if (r15 != 0) goto L16;
        r13.f8983a = r16.get(0).intValue();
        r13.f8984b = r16.get(1).intValue();
        r13.f8985c = r16.get(2).intValue();
        r13.f8986d = r16.get(3).intValue();
        float r17 = r16.get(4).intValue();
        r13.f8983a = r17;
        r13.f8987e = r17;
    L16:
        if (r15 != 1) goto L19;
        if (r12 == false) goto L19;
        r13.f8988f = r16.get(0).intValue();
        r13.f8989g = r16.get(1).intValue();
        r13.f8990h = r16.get(2).intValue();
        r13.f8991i = r16.get(3).intValue();
        r13.f8992j = r16.get(4).intValue();
    L19:
        if (r15 != 1) goto L22;
        if (r10 == false) goto L22;
        r13.f8988f = 0.0f;
        r13.f8989g = 0.0f;
        r13.f8990h = 0.0f;
        r13.f8991i = 0.0f;
        r13.f8992j = 0.0f;
        r13.f8993k = r16.get(0).intValue();
        r13.f8994l = r16.get(1).intValue();
        r13.f8995m = r16.get(2).intValue();
        r13.f8996n = r16.get(3).intValue();
        r13.f8997o = r16.get(4).intValue();
    L22:
        if (r15 != 2) goto L25;
        if (r12 == false) goto L25;
        r13.f8993k = r16.get(0).intValue();
        r13.f8994l = r16.get(1).intValue();
        r13.f8995m = r16.get(2).intValue();
        r13.f8996n = r16.get(3).intValue();
        r13.f8997o = r16.get(4).intValue();
    L25:
        r15 = r15 + 1;
        goto L7
    L26:
        return r13;
    }

    private boolean h(int r10) {
        if (r10 != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean i(int r10) {
        if (r10 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // h5.b
    public void a() {
        if (this.f10067c == false) goto L6;
        this.f10067c = false;
        c();
        return;
    }

    @Override // h5.b
    public void b() {
        if (this.f10067c == true) goto L6;
        this.f10067c = true;
        j();
        return;
    }

    public List<List<Integer>> f() {
        if (this.f9183b.getConfig().e() == true) goto L5;
        return null;
    L5:
        return d(this.f10070f.d(), this.f10070f.h());
    }

    public g5.c.b g() {
        if (this.f9183b.getConfig().e() == true) goto L5;
        return null;
    L5:
        return e(f());
    }

    public void j() {
        if (this.f10067c == false) goto L12;
        long r10 = System.currentTimeMillis();
        if (this.f9183b.getConfig().d() == false) goto L8;
        l(r10);
    L8:
        if (this.f9183b.getConfig().e() == false) goto L10;
        k();
    L10:
        this.f10068d = r10;
        return;
    }

    public void k() {
        e r10 = (e) this.f10069e.b();
        if (r10 != null) goto L5;
        return;
    L5:
        r10.b(this.f10070f);
        this.f10070f = r10;
        ArrayList<Long> r11 = n5.d.c();
        HashSet r12 = new HashSet();
        Iterator<Long> r13 = r11.iterator();
    L7:
        if (r13.hasNext() == false) goto L20;
        long r14 = r13.next().longValue();
        m5.e r15 = this.f10071g.get(Long.valueOf(r14));
        if (r15 != null) goto L11;
        r15 = new m5.e((int) r14);
        this.f10071g.put(Long.valueOf(r14), r15);
    L11:
        e r16 = (e) r15.b();
        if (r16 != null) goto L15;
        r12.add(Long.valueOf(r14));
        String r17 = "dead tid found from refresh cpu freq stat: " + r14;
    L14:
        n5.b.a(r17);
        goto L7
    L15:
        r16.b(this.f10072h.get(Long.valueOf(r14)));
        this.f10072h.put(Long.valueOf(r14), r16);
        if (n5.d.a() != r14) goto L18;
        n5.b.a("not merge main thread, id:" + r14);
    L19:
        n5.b.a("current tid " + r14 + " stat : " + r16);
        r17 = "current tid " + r14 + " delta : " + r16.g();
        goto L14
    L18:
        this.f10070f.j(r16);
        goto L19
    L20:
        Set<Long> r18 = this.f10071g.keySet();
        if (r18 != null) goto L23;
    L30:
        Iterator r19 = r12.iterator();
    L32:
        if (r19.hasNext() == false) goto L34;
        long r20 = ((Long) r19.next()).longValue();
        this.f10071g.remove(Long.valueOf(r20));
        this.f10072h.remove(Long.valueOf(r20));
        goto L32
    L34:
        return;
    L23:
        if (r18.isEmpty() == true) goto L30;
        Iterator<Long> r21 = r18.iterator();
    L26:
        if (r21.hasNext() == false) goto L30;
        Long r22 = r21.next();
        if (r11.contains(r22) == true) goto L26;
        r12.add(r22);
        n5.b.a("dead tid found from compare last cpu freq stat: " + r22);
        goto L26
    }

    public void l(long r13) {
        c r10 = (c) this.f10073i.b();
        d r11 = (d) this.f10075k.b();
        if (r10 == null) goto L50;
        if (r11 == null) goto L51;
        r10.a(this.f10074j);
        if (this.f9183b.getConfig().f() == false) goto L10;
        r10.b(this.f10074j);
    L10:
        if (this.f9183b.getConfig().g() == false) goto L12;
        a r12 = (a) this.f10079o.b();
        r12.a(this.f10080p);
        r12.b(this.f10080p);
        n5.b.a("current cpu idle stat : " + r12);
        this.f10080p = r12;
        r10.h(r12.d());
        n5.b.a("current cpu usage stat : " + r10);
    L12:
        long r14 = r10.c();
        long r15 = r13 - this.f10068d;
        r11.a(this.f10076l);
        r11.g(r14);
        r11.e(r15);
        if (this.f9183b.getConfig().h() == false) goto L39;
        ArrayList<Long> r16 = n5.d.c();
        HashSet r17 = new HashSet();
        Iterator<Long> r18 = r16.iterator();
    L16:
        if (r18.hasNext() == false) goto L25;
        long r19 = r18.next().longValue();
        m5.d r20 = this.f10077m.get(Long.valueOf(r19));
        if (r20 != null) goto L20;
        r20 = new m5.d(r19);
        this.f10077m.put(Long.valueOf(r19), r20);
    L20:
        f r21 = (f) r20.b();
        if (r21 != null) goto L23;
        r17.add(Long.valueOf(r19));
        String r22 = "dead tid found from refresh thread usage: " + r19;
    L24:
        n5.b.a(r22);
        goto L16
    L23:
        r21.a(this.f10078n.get(Long.valueOf(r19)));
        r21.g(r14);
        r21.e(r15);
        this.f10078n.put(Long.valueOf(r19), r21);
        r22 = "current tid stat : " + r21;
        goto L24
    L25:
        Set<Long> r110 = this.f10077m.keySet();
        if (r110 != null) goto L28;
    L35:
        Iterator r111 = r17.iterator();
    L37:
        if (r111.hasNext() == false) goto L39;
        long r23 = ((Long) r111.next()).longValue();
        this.f10077m.remove(Long.valueOf(r23));
        this.f10078n.remove(Long.valueOf(r23));
        goto L37
    L28:
        if (r110.isEmpty() == true) goto L35;
        Iterator<Long> r112 = r110.iterator();
    L31:
        if (r112.hasNext() == false) goto L35;
        Long r113 = r112.next();
        if (r16.contains(r113) == true) goto L31;
        r17.add(r113);
        n5.b.a("dead tid found from compare last thread usage: " + r113);
    L39:
        this.f10074j = r10;
        this.f10076l = r11;
        return;
    L51:
        return;
    }
}
