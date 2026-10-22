package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class k extends x {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f2467s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<RecyclerView.c0> f2468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<RecyclerView.c0> f2469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<b> f2470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<a> f2471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList<ArrayList<RecyclerView.c0>> f2472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ArrayList<ArrayList<b>> f2473m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ArrayList<ArrayList<a>> f2474n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<RecyclerView.c0> f2475o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<RecyclerView.c0> f2476p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<RecyclerView.c0> f2477q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ArrayList<RecyclerView.c0> f2478r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView.c0 f2479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public RecyclerView.c0 f2480b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2481c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2482d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2483e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f2484f;

        public a(RecyclerView.c0 r8, RecyclerView.c0 r10, int r11, int r12, int r13, int r14) {
            this.f2479a = r8;
            this.f2480b = r10;
            this.f2481c = r11;
            this.f2482d = r12;
            this.f2483e = r13;
            this.f2484f = r14;
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder("ChangeInfo{oldHolder=");
            r8.append(this.f2479a);
            r8.append(", newHolder=");
            r8.append(this.f2480b);
            r8.append(", fromX=");
            r8.append(this.f2481c);
            r8.append(", fromY=");
            r8.append(this.f2482d);
            r8.append(", toX=");
            r8.append(this.f2483e);
            r8.append(", toY=");
            return android.aimedia.a.f(r8, this.f2484f, '}');
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecyclerView.c0 f2485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2489e;

        public b(RecyclerView.c0 r8, int r10, int r11, int r12, int r13) {
            this.f2485a = r8;
            this.f2486b = r10;
            this.f2487c = r11;
            this.f2488d = r12;
            this.f2489e = r13;
        }
    }

    public k() {
        this.f2468h = new ArrayList();
        this.f2469i = new ArrayList();
        this.f2470j = new ArrayList();
        this.f2471k = new ArrayList();
        this.f2472l = new ArrayList();
        this.f2473m = new ArrayList();
        this.f2474n = new ArrayList();
        this.f2475o = new ArrayList();
        this.f2476p = new ArrayList();
        this.f2477q = new ArrayList();
        this.f2478r = new ArrayList();
    }

    public static void h(ArrayList r8) {
        int r10 = r8.size();
    L3:
        r10 = r10 - 1;
        if (r10 < 0) goto L6;
        ((RecyclerView.c0) r8.get(r10)).f2281a.animate().cancel();
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void d(RecyclerView.c0 r10) {
        View r8 = r10.f2281a;
        r8.animate().cancel();
        ArrayList<b> r11 = this.f2470j;
        int r12 = r11.size();
    L3:
        r12 = r12 - 1;
        if (r12 < 0) goto L8;
        if (r11.get(r12).f2485a != r10) goto L3;
        r8.setTranslationY(0.0f);
        r8.setTranslationX(0.0f);
        c(r10);
        r11.remove(r12);
        goto L3
    L8:
        j(r10, this.f2471k);
        if (this.f2468h.remove(r10) == false) goto L12;
        r8.setAlpha(1.0f);
        c(r10);
    L12:
        if (this.f2469i.remove(r10) == false) goto L14;
        r8.setAlpha(1.0f);
        c(r10);
    L14:
        ArrayList<ArrayList<a>> r13 = this.f2474n;
        int r14 = r13.size();
    L15:
        r14 = r14 - 1;
        if (r14 < 0) goto L21;
        ArrayList<a> r15 = r13.get(r14);
        j(r10, r15);
        if (r15.isEmpty() == false) goto L15;
        r13.remove(r14);
        goto L15
    L21:
        ArrayList<ArrayList<b>> r16 = this.f2473m;
        int r17 = r16.size();
    L22:
        r17 = r17 - 1;
        if (r17 < 0) goto L34;
        ArrayList<b> r18 = r16.get(r17);
        int r19 = r18.size();
    L25:
        r19 = r19 - 1;
        if (r19 < 0) goto L22;
        if (r18.get(r19).f2485a != r10) goto L25;
        r8.setTranslationY(0.0f);
        r8.setTranslationX(0.0f);
        c(r10);
        r18.remove(r19);
        if (r18.isEmpty() == false) goto L22;
        r16.remove(r17);
        goto L22
    L34:
        ArrayList<ArrayList<RecyclerView.c0>> r20 = this.f2472l;
        int r21 = r20.size();
    L35:
        r21 = r21 - 1;
        if (r21 < 0) goto L43;
        ArrayList<RecyclerView.c0> r22 = r20.get(r21);
        if (r22.remove(r10) == false) goto L35;
        r8.setAlpha(1.0f);
        c(r10);
        if (r22.isEmpty() == false) goto L35;
        r20.remove(r21);
        goto L35
    L43:
        this.f2477q.remove(r10);
        this.f2475o.remove(r10);
        this.f2478r.remove(r10);
        this.f2476p.remove(r10);
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final void e() {
        ArrayList<b> r8 = this.f2470j;
        int r10 = r8.size();
    L3:
        r10 = r10 - 1;
        if (r10 < 0) goto L6;
        b r11 = r8.get(r10);
        View r12 = r11.f2485a.f2281a;
        r12.setTranslationY(0.0f);
        r12.setTranslationX(0.0f);
        c(r11.f2485a);
        r8.remove(r10);
        goto L3
    L6:
        ArrayList<RecyclerView.c0> r13 = this.f2468h;
        int r14 = r13.size();
    L7:
        r14 = r14 - 1;
        if (r14 < 0) goto L10;
        c(r13.get(r14));
        r13.remove(r14);
        goto L7
    L10:
        ArrayList<RecyclerView.c0> r15 = this.f2469i;
        int r16 = r15.size();
    L11:
        r16 = r16 - 1;
        if (r16 < 0) goto L14;
        RecyclerView.c0 r17 = r15.get(r16);
        r17.f2281a.setAlpha(1.0f);
        c(r17);
        r15.remove(r16);
        goto L11
    L14:
        ArrayList<a> r18 = this.f2471k;
        int r19 = r18.size();
    L15:
        r19 = r19 - 1;
        if (r19 < 0) goto L24;
        a r20 = r18.get(r19);
        RecyclerView.c0 r21 = r20.f2479a;
        if (r21 == null) goto L20;
        k(r20, r21);
    L20:
        RecyclerView.c0 r22 = r20.f2480b;
        if (r22 == null) goto L15;
        k(r20, r22);
        goto L15
    L24:
        r18.clear();
        if (f() == true) goto L27;
        return;
    L27:
        ArrayList<ArrayList<b>> r23 = this.f2473m;
        int r24 = r23.size();
    L28:
        r24 = r24 - 1;
        if (r24 < 0) goto L38;
        ArrayList<b> r25 = r23.get(r24);
        int r26 = r25.size();
    L31:
        r26 = r26 - 1;
        if (r26 < 0) goto L28;
        b r27 = r25.get(r26);
        View r28 = r27.f2485a.f2281a;
        r28.setTranslationY(0.0f);
        r28.setTranslationX(0.0f);
        c(r27.f2485a);
        r25.remove(r26);
        if (r25.isEmpty() == false) goto L31;
        r23.remove(r25);
        goto L31
    L38:
        ArrayList<ArrayList<RecyclerView.c0>> r29 = this.f2472l;
        int r30 = r29.size();
    L39:
        r30 = r30 - 1;
        if (r30 < 0) goto L49;
        ArrayList<RecyclerView.c0> r31 = r29.get(r30);
        int r32 = r31.size();
    L42:
        r32 = r32 - 1;
        if (r32 < 0) goto L39;
        RecyclerView.c0 r33 = r31.get(r32);
        r33.f2281a.setAlpha(1.0f);
        c(r33);
        r31.remove(r32);
        if (r31.isEmpty() == false) goto L42;
        r29.remove(r31);
        goto L42
    L49:
        ArrayList<ArrayList<a>> r34 = this.f2474n;
        int r35 = r34.size();
    L50:
        r35 = r35 - 1;
        if (r35 < 0) goto L66;
        ArrayList<a> r36 = r34.get(r35);
        int r37 = r36.size();
    L53:
        r37 = r37 - 1;
        if (r37 < 0) goto L50;
        a r38 = r36.get(r37);
        RecyclerView.c0 r39 = r38.f2479a;
        if (r39 == null) goto L58;
        k(r38, r39);
    L58:
        RecyclerView.c0 r40 = r38.f2480b;
        if (r40 == null) goto L62;
        k(r38, r40);
    L62:
        if (r36.isEmpty() == false) goto L53;
        r34.remove(r36);
        goto L53
    L66:
        h(this.f2477q);
        h(this.f2476p);
        h(this.f2475o);
        h(this.f2478r);
        ArrayList<RecyclerView.l.a> r41 = this.f2305b;
        int r42 = r41.size();
        int r43 = 0;
    L67:
        if (r43 >= r42) goto L69;
        r41.get(r43).a();
        r43 = r43 + 1;
        goto L67
    L69:
        r41.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public final boolean f() {
        if (this.f2469i.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.f2471k.isEmpty() == false) goto L26;
        if (this.f2470j.isEmpty() == false) goto L26;
        if (this.f2468h.isEmpty() == false) goto L26;
        if (this.f2476p.isEmpty() == false) goto L26;
        if (this.f2477q.isEmpty() == false) goto L26;
        if (this.f2475o.isEmpty() == false) goto L26;
        if (this.f2478r.isEmpty() == false) goto L26;
        if (this.f2473m.isEmpty() == false) goto L26;
        if (this.f2472l.isEmpty() == false) goto L26;
        if (this.f2474n.isEmpty() == false) goto L26;
        return false;
    }

    @Override // androidx.recyclerview.widget.x
    public final boolean g(RecyclerView.c0 r10, int r11, int r12, int r13, int r14) {
        View r8 = r10.f2281a;
        int r15 = r11 + ((int) r8.getTranslationX());
        int r16 = r12 + ((int) r10.f2281a.getTranslationY());
        l(r10);
        int r17 = r13 - r15;
        int r18 = r14 - r16;
        if (r17 != 0) goto L7;
        if (r18 != 0) goto L7;
        c(r10);
        return false;
    L7:
        if (r17 == 0) goto L9;
        r8.setTranslationX(-r17);
    L9:
        if (r18 == 0) goto L11;
        r8.setTranslationY(-r18);
    L11:
        this.f2470j.add(new b(r10, r15, r16, r13, r14));
        return true;
    }

    public final void i() {
        if (f() == true) goto L10;
        ArrayList<RecyclerView.l.a> r8 = this.f2305b;
        int r10 = r8.size();
        int r11 = 0;
    L5:
        if (r11 >= r10) goto L7;
        r8.get(r11).a();
        r11 = r11 + 1;
        goto L5
    L7:
        r8.clear();
        return;
    }

    public final void j(RecyclerView.c0 r8, ArrayList r10) {
        int r11 = r10.size();
    L3:
        r11 = r11 - 1;
        if (r11 < 0) goto L12;
        a r12 = (a) r10.get(r11);
        if (k(r12, r8) == false) goto L3;
        if (r12.f2479a != null) goto L3;
        if (r12.f2480b != null) goto L3;
        r10.remove(r12);
        goto L3
    }

    public final boolean k(a r8, RecyclerView.c0 r10) {
        if (r8.f2480b != r10) goto L6;
        r8.f2480b = null;
    L8:
        r10.f2281a.setAlpha(1.0f);
        View r11 = r10.f2281a;
        r11.setTranslationX(0.0f);
        r11.setTranslationY(0.0f);
        c(r10);
        return true;
    L6:
        if (r8.f2479a != r10) goto L10;
        r8.f2479a = null;
        goto L8
    L10:
        return false;
    }

    public final void l(RecyclerView.c0 r8) {
        if (f2467s != null) goto L5;
        f2467s = new ValueAnimator().getInterpolator();
    L5:
        r8.f2281a.animate().setInterpolator(f2467s);
        d(r8);
    }
}
