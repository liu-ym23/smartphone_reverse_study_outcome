package s;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import t.o;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashSet<d> f11830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f11833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f11834e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f11835f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11836g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11837h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public p.h f11838i;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11839a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f11840b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f11841m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f11842n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f11843o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f11844p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f11845q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f11846r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final /* synthetic */ a[] f11847s = null;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_NONE, 0);
            a r10 = new a("LEFT", 1);
            f11839a = r10;
            a r11 = new a("TOP", 2);
            f11840b = r11;
            a r12 = new a("RIGHT", 3);
            f11841m = r12;
            a r13 = new a("BOTTOM", 4);
            f11842n = r13;
            a r14 = new a("BASELINE", 5);
            f11843o = r14;
            a r15 = new a("CENTER", 6);
            f11844p = r15;
            a r16 = new a("CENTER_X", 7);
            f11845q = r16;
            a r17 = new a("CENTER_Y", 8);
            f11846r = r17;
            f11847s = new a[]{r8, r10, r11, r12, r13, r14, r15, r16, r17};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f11847s.clone();
        }
    }

    public d(e r8, a r10) {
        this.f11830a = null;
        this.f11836g = 0;
        this.f11837h = Integer.MIN_VALUE;
        this.f11833d = r8;
        this.f11834e = r10;
    }

    public final void a(d r8, int r10) {
        b(r8, r10, Integer.MIN_VALUE, false);
    }

    public final boolean b(d r8, int r10, int r11, boolean r12) {
        if (r8 != null) goto L6;
        j();
        return true;
    L6:
        if (r12 == false) goto L8;
    L11:
        this.f11835f = r8;
        if (r8.f11830a != null) goto L14;
        r8.f11830a = new HashSet();
    L14:
        HashSet<d> r13 = this.f11835f.f11830a;
        if (r13 == null) goto L17;
        r13.add(this);
    L17:
        this.f11836g = r10;
        this.f11837h = r11;
        return true;
    L8:
        if (i(r8) == true) goto L11;
        return false;
    }

    public final void c(int r8, o r10, ArrayList r11) {
        HashSet<d> r12 = this.f11830a;
        if (r12 == null) goto L8;
        Iterator<d> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L10;
        t.i.a(r13.next().f11833d, r8, r11, r10);
        goto L6
    L10:
        return;
    }

    public final int d() {
        if (this.f11832c == true) goto L7;
        return 0;
    L7:
        return this.f11831b;
    }

    public final int e() {
        if (this.f11833d.f11866j0 != 8) goto L6;
        return 0;
    L6:
        int r8 = this.f11837h;
        if (r8 == Integer.MIN_VALUE) goto L14;
        d r10 = this.f11835f;
        if (r10 == null) goto L14;
        if (r10.f11833d.f11866j0 != 8) goto L14;
        return r8;
    L14:
        return this.f11836g;
    }

    public final d f() {
        a r8 = this.f11834e;
        int r10 = r8.ordinal();
        e r11 = this.f11833d;
        switch(r10) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L14;
            case 8: goto L14;
            default: goto L5;
        };
    L14:
        return null;
    L5:
        throw new AssertionError(r8.name());
    L7:
        return r11.L;
    L9:
        return r11.K;
    L11:
        return r11.N;
    L13:
        return r11.M;
    }

    public final boolean g() {
        HashSet<d> r8 = this.f11830a;
        if (r8 != null) goto L5;
        return false;
    L5:
        Iterator<d> r10 = r8.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        if (r10.next().f().h() == false) goto L7;
        return true;
    L12:
        return false;
    }

    public final boolean h() {
        if (this.f11835f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i(d r8) {
        boolean r10 = false;
        if (r8 != null) goto L5;
        return false;
    L5:
        a r11 = this.f11834e;
        e r12 = r8.f11833d;
        a r13 = r8.f11834e;
        if (r13 != r11) goto L16;
        if (r11 == a.f11843o) goto L10;
    L14:
        return true;
    L10:
        if (r12.F == true) goto L12;
    L13:
        return false;
    L12:
        if (this.f11833d.F == true) goto L14;
    L16:
        switch(r11.ordinal()) {
            case 0: goto L64;
            case 1: goto L50;
            case 2: goto L35;
            case 3: goto L50;
            case 4: goto L35;
            case 5: goto L28;
            case 6: goto L20;
            case 7: goto L64;
            case 8: goto L64;
            default: goto L18;
        };
    L64:
        return false;
    L18:
        throw new AssertionError(r11.name());
    L20:
        if (r13 != a.f11843o) goto L22;
        return false;
    L22:
        if (r13 != a.f11845q) goto L24;
        return false;
    L24:
        if (r13 != a.f11846r) goto L26;
        return false;
    L26:
        return true;
    L28:
        if (r13 != a.f11839a) goto L30;
    L33:
        return false;
    L30:
        if (r13 == a.f11841m) goto L33;
        return true;
    L35:
        if (r13 != a.f11840b) goto L37;
    L40:
        boolean r14 = true;
    L42:
        if ((r12 instanceof h) == false) goto L68;
        if (r14 == false) goto L45;
    L46:
        r10 = true;
    L48:
        return r10;
    L45:
        if (r13 != a.f11846r) goto L48;
    L68:
        return r14;
    L37:
        if (r13 == a.f11842n) goto L40;
        r14 = false;
        goto L42
    L50:
        if (r13 != a.f11839a) goto L52;
    L55:
        boolean r15 = true;
    L57:
        if ((r12 instanceof h) == false) goto L69;
        if (r15 == false) goto L60;
    L61:
        r10 = true;
    L63:
        return r10;
    L60:
        if (r13 != a.f11845q) goto L63;
    L69:
        return r15;
    L52:
        if (r13 == a.f11841m) goto L55;
        r15 = false;
        goto L57
    }

    public final void j() {
        d r8 = this.f11835f;
        if (r8 == null) goto L9;
        HashSet<d> r10 = r8.f11830a;
        if (r10 == null) goto L9;
        r10.remove(this);
        if (this.f11835f.f11830a.size() != 0) goto L9;
        this.f11835f.f11830a = null;
    L9:
        this.f11830a = null;
        this.f11835f = null;
        this.f11836g = 0;
        this.f11837h = Integer.MIN_VALUE;
        this.f11832c = false;
        this.f11831b = 0;
    }

    public final void k() {
        p.h r8 = this.f11838i;
        if (r8 != null) goto L5;
        this.f11838i = new p.h(p.h.a.f9907a);
        return;
    L5:
        r8.c();
    }

    public final void l(int r8) {
        this.f11831b = r8;
        this.f11832c = true;
    }

    public final String toString() {
        return this.f11833d.f11868k0 + BdimCategoryConstants.SEPARATOR_COLON + this.f11834e.toString();
    }
}
