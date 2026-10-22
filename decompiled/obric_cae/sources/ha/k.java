package ha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ja.p f7986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x.a f7987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c.a f7988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f7989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f7990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f7991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f7993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f7995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f7996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f7997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final z.a f7998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z.b f7999n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedList<y> f8000o;

    public k() {
        this.f7986a = ja.p.f8770p;
        this.f7987b = x.f8005a;
        this.f7988c = c.f7964a;
        this.f7989d = new HashMap();
        this.f7990e = new ArrayList();
        this.f7991f = new ArrayList();
        c.a r8 = j.f7968o;
        this.f7992g = 2;
        this.f7993h = 2;
        this.f7994i = true;
        this.f7995j = false;
        this.f7996k = false;
        this.f7997l = true;
        this.f7998m = j.f7969p;
        this.f7999n = j.f7970q;
        this.f8000o = new LinkedList();
    }

    public final j a() {
        ArrayList r8 = this.f7990e;
        int r10 = r8.size();
        ArrayList r11 = this.f7991f;
        ArrayList r12 = new ArrayList((r11.size() + r10) + 3);
        r12.addAll(r8);
        Collections.reverse(r12);
        ArrayList r13 = new ArrayList(r11);
        Collections.reverse(r13);
        r12.addAll(r13);
        boolean r14 = na.d.f9481a;
        ka.d.a.C0108a r15 = ka.d.a.f8993b;
        int r16 = this.f7992g;
        if (r16 == 2) goto L14;
        int r17 = this.f7993h;
        if (r17 == 2) goto L14;
        ka.d r18 = new ka.d(r15, r16, r17);
        ka.s r19 = ka.r.f9054a;
        ka.s r20 = new ka.s(Date.class, r18);
        if (r14 == false) goto L9;
        na.d.b r21 = na.d.f9483c;
        r21.getClass();
        ka.s r22 = new ka.s(r21.f8994a, new ka.d(r21, r16, r17));
        na.d.a r23 = na.d.f9482b;
        r23.getClass();
        ka.s r24 = new ka.s(r23.f8994a, new ka.d(r23, r16, r17));
    L10:
        r12.add(r20);
        if (r14 == false) goto L14;
        r12.add(r22);
        r12.add(r24);
        goto L14
    L9:
        r22 = null;
        r24 = null;
    L14:
        return new j(this.f7986a, this.f7988c, new HashMap(this.f7989d), this.f7994i, this.f7995j, this.f7996k, this.f7997l, this.f7987b, new ArrayList(r8), new ArrayList(r11), r12, this.f7998m, this.f7999n, new ArrayList(this.f8000o));
    }

    public final void b(Class r8, Object r10) {
        boolean r11 = r10 instanceof w;
        if (r11 == false) goto L5;
    L10:
        boolean r12 = true;
    L11:
        l6.a.t(r12);
        if ((r10 instanceof o) == true) goto L14;
        if (r11 == true) goto L14;
    L16:
        if ((r10 instanceof c0) == false) goto L19;
        ka.s r13 = ka.r.f9054a;
        ka.v r14 = new ka.v(r8, (c0) r10);
        this.f7990e.add(r14);
        return;
    L19:
        return;
    L14:
        this.f7991f.add(new ka.p.b(r10, r8));
        goto L16
    L5:
        if ((r10 instanceof o) == true) goto L10;
        if ((r10 instanceof c0) == true) goto L10;
        r12 = false;
        goto L11
    }
}
