package f1;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import j0.h0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class h implements Cloneable {
    public static final int[] E = null;
    public static final a F = null;
    public static final ThreadLocal<n.b<Animator, b>> G = null;
    public ArrayList<d> A;
    public ArrayList<Animator> B;
    public c C;
    public android.support.v4.media.a D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7263b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f7264m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TimeInterpolator f7265n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<Integer> f7266o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ArrayList<View> f7267p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public p.c f7268q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public p.c f7269r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public m f7270s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int[] f7271t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ArrayList<n> f7272u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList<n> f7273v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ArrayList<Animator> f7274w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f7275x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f7276y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f7277z;

    public static class a extends android.support.v4.media.a {
        @Override // android.support.v4.media.a
        public final Path j(float r8, float r10, float r11, float r12) {
            Path r13 = new Path();
            r13.moveTo(r8, r10);
            r13.lineTo(r11, r12);
            return r13;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f7278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n f7280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final x f7281d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final h f7282e;

        public b(View r8, String r10, h r11, w r12, n r13) {
            this.f7278a = r8;
            this.f7279b = r10;
            this.f7280c = r13;
            this.f7281d = r12;
            this.f7282e = r11;
        }
    }

    public static abstract class c {
    }

    public interface d {
        void a();

        void b();

        void c();

        void d(h r8);

        void e();
    }

    static {
        E = new int[]{2, 1, 3, 4};
        F = new a();
        G = new ThreadLocal();
    }

    public h() {
        this.f7262a = getClass().getName();
        this.f7263b = -1;
        this.f7264m = -1;
        this.f7265n = null;
        this.f7266o = new ArrayList();
        this.f7267p = new ArrayList();
        this.f7268q = new p.c(1);
        this.f7269r = new p.c(1);
        this.f7270s = null;
        this.f7271t = E;
        this.f7274w = new ArrayList();
        this.f7275x = 0;
        this.f7276y = false;
        this.f7277z = false;
        this.A = null;
        this.B = new ArrayList();
        this.D = F;
    }

    public static void c(p.c r8, View r10, n r11) {
        ((n.b) r8.f9866a).put(r10, r11);
        int r12 = r10.getId();
        if (r12 < 0) goto L8;
        SparseArray r13 = (SparseArray) r8.f9867b;
        if (r13.indexOfKey(r12) < 0) goto L7;
        r13.put(r12, null);
        goto L8
    L7:
        r13.put(r12, r10);
    L8:
        String r14 = j0.w.h(r10);
        if (r14 == null) goto L15;
        if (((n.b) r8.f9869d).containsKey(r14) == false) goto L13;
        ((n.b) r8.f9869d).put(r14, null);
        goto L15
    L13:
        ((n.b) r8.f9869d).put(r14, r10);
    L15:
        if ((r10.getParent() instanceof ListView) == false) goto L25;
        ListView r15 = (ListView) r10.getParent();
        if (r15.getAdapter().hasStableIds() == false) goto L26;
        long r16 = r15.getItemIdAtPosition(r15.getPositionForView(r10));
        n.e r17 = (n.e) r8.f9868c;
        if (r17.f(r16) < 0) goto L23;
        View r18 = (View) r17.d(r16);
        if (r18 == null) goto L27;
        j0.w.o(r18, false);
        r17.g(r16, null);
        return;
    L27:
        return;
    L23:
        j0.w.o(r10, true);
        r17.g(r16, r10);
        return;
    L26:
        return;
    }

    public static n.b<Animator, b> o() {
        ThreadLocal<n.b<Animator, b>> r8 = G;
        n.b<Animator, b> r10 = r8.get();
        if (r10 != null) goto L6;
        n.b<Animator, b> r11 = new n.b();
        r8.set(r11);
        return r11;
    L6:
        return r10;
    }

    public static boolean t(n r8, n r10, String r11) {
        Object r12 = r8.f7295a.get(r11);
        Object r13 = r10.f7295a.get(r11);
        if (r12 != null) goto L7;
        if (r13 != null) goto L7;
        return false;
    L7:
        if (r12 == null) goto L12;
        if (r13 == null) goto L12;
        return !r12.equals(r13);
    L12:
        return true;
    }

    public void A(c r8) {
        this.C = r8;
    }

    public void B(TimeInterpolator r8) {
        this.f7265n = r8;
    }

    public void C(android.support.v4.media.a r8) {
        if (r8 != null) goto L4;
        r8 = F;
    L4:
        this.D = r8;
    }

    public void D() {
    }

    public void E(long r8) {
        this.f7263b = r8;
    }

    public final void F() {
        if (this.f7275x != 0) goto L12;
        ArrayList<d> r8 = this.A;
        if (r8 != null) goto L7;
    L11:
        this.f7277z = false;
        goto L12
    L7:
        if (r8.size() <= 0) goto L11;
        ArrayList r10 = (ArrayList) this.A.clone();
        int r11 = r10.size();
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L11;
        ((d) r10.get(r12)).e();
        r12 = r12 + 1;
    L12:
        this.f7275x++;
    }

    public String G(String r8) {
        StringBuilder r10 = android.aimedia.a.j(r8);
        r10.append(getClass().getSimpleName());
        r10.append("@");
        r10.append(Integer.toHexString(hashCode()));
        r10.append(": ");
        String r11 = r10.toString();
        if (this.f7264m == (-1)) goto L6;
        StringBuilder r12 = android.aimedia.a.k(r11, "dur(");
        r12.append(this.f7264m);
        r12.append(") ");
        r11 = r12.toString();
    L6:
        if (this.f7263b == (-1)) goto L9;
        StringBuilder r13 = android.aimedia.a.k(r11, "dly(");
        r13.append(this.f7263b);
        r13.append(") ");
        r11 = r13.toString();
    L9:
        if (this.f7265n == null) goto L11;
        StringBuilder r14 = android.aimedia.a.k(r11, "interp(");
        r14.append(this.f7265n);
        r14.append(") ");
        r11 = r14.toString();
    L11:
        ArrayList<Integer> r15 = this.f7266o;
        int r16 = r15.size();
        ArrayList<View> r17 = this.f7267p;
        if (r16 <= 0) goto L14;
    L15:
        String r18 = defpackage.a.e(r11, "tgts(");
        int r19 = 0;
        if (r15.size() <= 0) goto L24;
        int r20 = 0;
    L19:
        if (r20 >= r15.size()) goto L24;
        if (r20 <= 0) goto L22;
        r18 = defpackage.a.e(r18, ", ");
    L22:
        StringBuilder r21 = android.aimedia.a.j(r18);
        r21.append(r15.get(r20));
        r18 = r21.toString();
        r20 = r20 + 1;
    L24:
        if (r17.size() <= 0) goto L31;
    L26:
        if (r19 >= r17.size()) goto L31;
        if (r19 <= 0) goto L29;
        r18 = defpackage.a.e(r18, ", ");
    L29:
        StringBuilder r22 = android.aimedia.a.j(r18);
        r22.append(r17.get(r19));
        r18 = r22.toString();
        r19 = r19 + 1;
    L31:
        return defpackage.a.e(r18, ")");
    L14:
        if (r17.size() > 0) goto L15;
        return r11;
    }

    public void a(d r8) {
        if (this.A != null) goto L5;
        this.A = new ArrayList();
    L5:
        this.A.add(r8);
    }

    public void b(View r8) {
        this.f7267p.add(r8);
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return j();
    }

    public abstract void d(n r8);

    public final void e(View r8, boolean r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        r8.getId();
        if ((r8.getParent() instanceof ViewGroup) == false) goto L16;
        n r11 = new n(r8);
        if (r10 == false) goto L9;
        g(r11);
    L10:
        r11.f7297c.add(this);
        f(r11);
        if (r10 == false) goto L13;
        p.c r12 = this.f7268q;
    L14:
        c(r12, r8, r11);
        goto L16
    L13:
        r12 = this.f7269r;
        goto L14
    L9:
        d(r11);
    L16:
        if ((r8 instanceof ViewGroup) == false) goto L21;
        ViewGroup r13 = (ViewGroup) r8;
        int r14 = 0;
    L19:
        if (r14 >= r13.getChildCount()) goto L23;
        e(r13.getChildAt(r14), r10);
        r14 = r14 + 1;
        goto L19
    L23:
        return;
    }

    public void f(n r8) {
    }

    public abstract void g(n r8);

    public final void h(ViewGroup r8, boolean r10) {
        i(r10);
        ArrayList<Integer> r11 = this.f7266o;
        int r12 = r11.size();
        ArrayList<View> r13 = this.f7267p;
        if (r12 <= 0) goto L5;
    L8:
        int r14 = 0;
        int r15 = 0;
    L10:
        if (r15 >= r11.size()) goto L24;
        View r16 = r8.findViewById(r11.get(r15).intValue());
        if (r16 == null) goto L22;
        n r17 = new n(r16);
        if (r10 == false) goto L16;
        g(r17);
    L17:
        r17.f7297c.add(this);
        f(r17);
        if (r10 == false) goto L20;
        p.c r18 = this.f7268q;
    L21:
        c(r18, r16, r17);
        goto L22
    L20:
        r18 = this.f7269r;
        goto L21
    L16:
        d(r17);
    L22:
        r15 = r15 + 1;
    L24:
        if (r14 >= r13.size()) goto L41;
        View r19 = r13.get(r14);
        n r20 = new n(r19);
        if (r10 == false) goto L28;
        g(r20);
    L29:
        r20.f7297c.add(this);
        f(r20);
        if (r10 == false) goto L32;
        p.c r21 = this.f7268q;
    L33:
        c(r21, r19, r20);
        r14 = r14 + 1;
        goto L24
    L32:
        r21 = this.f7269r;
        goto L33
    L28:
        d(r20);
        goto L29
    L41:
        return;
    L5:
        if (r13.size() > 0) goto L8;
        e(r8, r10);
    }

    public final void i(boolean r8) {
        if (r8 == false) goto L4;
        ((n.b) this.f7268q.f9866a).clear();
        ((SparseArray) this.f7268q.f9867b).clear();
        p.c r10 = this.f7268q;
    L5:
        ((n.e) r10.f9868c).a();
        return;
    L4:
        ((n.b) this.f7269r.f9866a).clear();
        ((SparseArray) this.f7269r.f9867b).clear();
        r10 = this.f7269r;
        goto L5
    }

    public h j() {
        h r8 = (h) super.clone();     // Catch: CloneNotSupportedException -> L5
        r8.B = new ArrayList();     // Catch: CloneNotSupportedException -> L5
        r8.f7268q = new p.c(1);     // Catch: CloneNotSupportedException -> L5
        r8.f7269r = new p.c(1);     // Catch: CloneNotSupportedException -> L5
        r8.f7272u = null;     // Catch: CloneNotSupportedException -> L5
        r8.f7273v = null;     // Catch: CloneNotSupportedException -> L5
        return r8;
    L5:
        return null;
    }

    public Animator k(ViewGroup r8, n r10, n r11) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void l(ViewGroup r20, p.c r21, p.c r22, ArrayList<n> r23, ArrayList<n> r24) {
        n.b<Animator, b> r8 = o();
        SparseIntArray r10 = new SparseIntArray();
        int r11 = r23.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L57;
        n r13 = r23.get(r12);
        n r14 = r24.get(r12);
        if (r13 != null) goto L7;
    L9:
        if (r14 != null) goto L11;
    L13:
        if (r13 != null) goto L16;
        if (r14 != null) goto L16;
    L55:
        r12 = r12 + 1;
    L16:
        if (r13 == null) goto L22;
        if (r14 == null) goto L22;
        if (r(r13, r14) == true) goto L22;
        boolean r15 = false;
    L23:
        if (r15 == false) goto L55;
        Animator r16 = k(r20, r13, r14);
        if (r16 == null) goto L55;
        if (r14 == null) goto L52;
        String[] r17 = p();
        View r18 = r14.f7296b;
        if (r17 != null) goto L30;
    L50:
        Animator r19 = r16;
        n r25 = null;
    L51:
        Animator r110 = r19;
        n r26 = r25;
    L53:
        if (r110 == null) goto L55;
        String r27 = this.f7262a;
        o.a r28 = o.f7298a;
        r8.put(r110, new b(r18, r27, this, new w(r20), r26));
        this.B.add(r110);
        goto L55
    L30:
        if (r17.length <= 0) goto L50;
        r25 = new n(r18);
        n r29 = (n) ((n.b) r22.f9866a).getOrDefault(r18, null);
        if (r29 == null) goto L37;
        int r111 = 0;
    L35:
        if (r111 >= r17.length) goto L37;
        HashMap r30 = r25.f7295a;
        Animator r112 = r16;
        String r31 = r17[r111];
        r30.put(r31, r29.f7295a.get(r31));
        r111 = r111 + 1;
        r16 = r112;
        r17 = r17;
    L37:
        Animator r113 = r16;
        int r32 = r8.f9401m;
        int r33 = 0;
    L38:
        if (r33 >= r32) goto L49;
        b r34 = r8.getOrDefault(r8.i(r33), null);
        if (r34.f7280c == null) goto L48;
        if (r34.f7278a != r18) goto L48;
        if (r34.f7279b.equals(this.f7262a) == false) goto L48;
        if (r34.f7280c.equals(r25) == false) goto L48;
        r19 = null;
    L48:
        r33 = r33 + 1;
        goto L38
    L49:
        r19 = r113;
        goto L51
    L52:
        r18 = r13.f7296b;
        r110 = r16;
        r26 = null;
    L22:
        r15 = true;
        goto L23
    L11:
        if (r14.f7297c.contains(this) == true) goto L13;
        r14 = null;
        goto L13
    L7:
        if (r13.f7297c.contains(this) == true) goto L9;
        r13 = null;
        goto L9
    L57:
        if (r10.size() == 0) goto L62;
        int r114 = 0;
    L60:
        if (r114 >= r10.size()) goto L75;
        Animator r35 = this.B.get(r10.keyAt(r114));
        r35.setStartDelay(r35.getStartDelay() + (((long) r10.valueAt(r114)) - Long.MAX_VALUE));
        r114 = r114 + 1;
        goto L60
    L75:
        return;
    }

    public final void m() {
        int r8 = this.f7275x - 1;
        this.f7275x = r8;
        if (r8 != 0) goto L40;
        ArrayList<d> r10 = this.A;
        if (r10 != null) goto L7;
    L11:
        int r11 = 0;
    L12:
        n.e r12 = (n.e) this.f7268q.f9868c;
        if (r12.f9371a == false) goto L16;
        r12.c();
    L16:
        if (r11 >= r12.f9374n) goto L21;
        View r13 = (View) ((n.e) this.f7268q.f9868c).h(r11);
        if (r13 == null) goto L20;
        WeakHashMap<View, h0> r14 = j0.w.f8437a;
        j0.w.d.r(r13, false);
    L20:
        r11 = r11 + 1;
        goto L12
    L21:
        int r15 = 0;
    L22:
        n.e r16 = (n.e) this.f7269r.f9868c;
        if (r16.f9371a == false) goto L26;
        r16.c();
    L26:
        if (r15 >= r16.f9374n) goto L31;
        View r17 = (View) ((n.e) this.f7269r.f9868c).h(r15);
        if (r17 == null) goto L30;
        WeakHashMap<View, h0> r18 = j0.w.f8437a;
        j0.w.d.r(r17, false);
    L30:
        r15 = r15 + 1;
        goto L22
    L31:
        this.f7277z = true;
        return;
    L7:
        if (r10.size() <= 0) goto L11;
        ArrayList r19 = (ArrayList) this.A.clone();
        int r20 = r19.size();
        int r21 = 0;
    L9:
        if (r21 >= r20) goto L11;
        ((d) r19.get(r21)).d(this);
        r21 = r21 + 1;
        goto L9
    }

    public final n n(View r8, boolean r10) {
        m r11 = this.f7270s;
        if (r11 != null) goto L5;
        if (r10 == false) goto L8;
        ArrayList<n> r12 = this.f7272u;
    L10:
        if (r12 != null) goto L12;
        return null;
    L12:
        int r13 = r12.size();
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L21;
        n r15 = r12.get(r14);
        if (r15 == null) goto L16;
        if (r15.f7296b == r8) goto L22;
        r14 = r14 + 1;
    L22:
        if (r14 < 0) goto L31;
        if (r10 == false) goto L25;
        ArrayList<n> r16 = this.f7273v;
    L27:
        return r16.get(r14);
    L25:
        r16 = this.f7272u;
        goto L27
    L31:
        return null;
    L16:
        return null;
    L21:
        r14 = -1;
        goto L22
    L8:
        r12 = this.f7273v;
        goto L10
    L5:
        return r11.n(r8, r10);
    }

    public String[] p() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final n q(View r8, boolean r10) {
        m r11 = this.f7270s;
        if (r11 != null) goto L5;
        if (r10 == false) goto L8;
        p.c r12 = this.f7268q;
    L10:
        return (n) ((n.b) r12.f9866a).getOrDefault(r8, null);
    L8:
        r12 = this.f7269r;
        goto L10
    L5:
        return r11.q(r8, r10);
    }

    public boolean r(n r8, n r10) {
        if (r8 == null) goto L25;
        if (r10 == null) goto L26;
        String[] r11 = p();
        if (r11 == null) goto L13;
        int r12 = r11.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L27;
        if (t(r8, r10, r11[r13]) == true) goto L18;
        r13 = r13 + 1;
    L18:
        return true;
    L27:
        return false;
    L13:
        Iterator r14 = r8.f7295a.keySet().iterator();
    L15:
        if (r14.hasNext() == false) goto L28;
        if (t(r8, r10, (String) r14.next()) == false) goto L15;
    L28:
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    public final boolean s(View r8) {
        int r10 = r8.getId();
        ArrayList<Integer> r11 = this.f7266o;
        int r12 = r11.size();
        ArrayList<View> r13 = this.f7267p;
        if (r12 != 0) goto L8;
        if (r13.size() != 0) goto L8;
        return true;
    L8:
        if (r11.contains(Integer.valueOf(r10)) == false) goto L10;
    L14:
        return true;
    L10:
        if (r13.contains(r8) == true) goto L14;
        return false;
    }

    public final String toString() {
        return G("");
    }

    public void u(View r8) {
        if (this.f7277z == true) goto L26;
        n.b<Animator, b> r10 = o();
        int r11 = r10.f9401m;
        o.a r12 = o.f7298a;
        w r13 = new w(r8);
        int r14 = r11 - 1;
    L5:
        if (r14 < 0) goto L12;
        b r15 = r10.k(r14);
        if (r15.f7278a == null) goto L11;
        if (r13.equals(r15.f7281d) == false) goto L11;
        r10.i(r14).pause();
    L11:
        r14 = r14 - 1;
        goto L5
    L12:
        ArrayList<d> r16 = this.A;
        if (r16 != null) goto L15;
    L19:
        this.f7276y = true;
        return;
    L15:
        if (r16.size() <= 0) goto L19;
        ArrayList r17 = (ArrayList) this.A.clone();
        int r18 = r17.size();
        int r19 = 0;
    L17:
        if (r19 >= r18) goto L19;
        ((d) r17.get(r19)).a();
        r19 = r19 + 1;
        goto L17
    }

    public void v(d r8) {
        ArrayList<d> r10 = this.A;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.remove(r8);
        if (this.A.size() != 0) goto L9;
        this.A = null;
        return;
    }

    public void w(View r8) {
        this.f7267p.remove(r8);
    }

    public void x(ViewGroup r8) {
        if (this.f7276y == true) goto L5;
        return;
    L5:
        if (this.f7277z == true) goto L21;
        n.b<Animator, b> r10 = o();
        int r11 = r10.f9401m;
        o.a r12 = o.f7298a;
        w r13 = new w(r8);
    L7:
        r11 = r11 - 1;
        if (r11 < 0) goto L14;
        b r14 = r10.k(r11);
        if (r14.f7278a == null) goto L7;
        if (r13.equals(r14.f7281d) == false) goto L7;
        r10.i(r11).resume();
        goto L7
    L14:
        ArrayList<d> r15 = this.A;
        if (r15 == null) goto L21;
        if (r15.size() <= 0) goto L21;
        ArrayList r16 = (ArrayList) this.A.clone();
        int r17 = r16.size();
        int r18 = 0;
    L19:
        if (r18 >= r17) goto L21;
        ((d) r16.get(r18)).c();
        r18 = r18 + 1;
    L21:
        this.f7276y = false;
    }

    public void y() {
        F();
        n.b<Animator, b> r8 = o();
        Iterator<Animator> r10 = this.B.iterator();
    L4:
        if (r10.hasNext() == false) goto L19;
        Animator r11 = r10.next();
        if (r8.containsKey(r11) == false) goto L4;
        F();
        if (r11 == null) goto L4;
        r11.addListener(new i(this, r8));
        long r12 = this.f7264m;
        if (r12 < 0) goto L12;
        r11.setDuration(r12);
    L12:
        long r13 = this.f7263b;
        if (r13 < 0) goto L15;
        r11.setStartDelay(r11.getStartDelay() + r13);
    L15:
        TimeInterpolator r14 = this.f7265n;
        if (r14 == null) goto L18;
        r11.setInterpolator(r14);
    L18:
        r11.addListener(new j(this));
        r11.start();
        goto L4
    L19:
        this.B.clear();
        m();
    }

    public void z(long r8) {
        this.f7264m = r8;
    }
}
