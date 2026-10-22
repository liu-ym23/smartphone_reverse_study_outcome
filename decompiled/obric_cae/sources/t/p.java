package t;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public s.e f12194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f12195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s.e.a f12196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f12197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f12200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f12201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f12202j;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12203a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12204b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ a[] f12205m = null;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_NONE, 0);
            f12203a = r8;
            a r10 = new a("START", 1);
            a r11 = new a("END", 2);
            a r12 = new a("CENTER", 3);
            f12204b = r12;
            f12205m = new a[]{r8, r10, r11, r12};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f12205m.clone();
        }
    }

    public p(s.e r8) {
        this.f12197e = new g(this);
        this.f12198f = 0;
        this.f12199g = false;
        this.f12200h = new f(this);
        this.f12201i = new f(this);
        this.f12202j = a.f12203a;
        this.f12194b = r8;
    }

    public static void b(f r8, f r10, int r11) {
        r8.f12170l.add(r10);
        r8.f12164f = r11;
        r10.f12169k.add(r8);
    }

    public static f h(s.d r8) {
        s.d r10 = r8.f11835f;
        if (r10 != null) goto L5;
        return null;
    L5:
        int r11 = r10.f11834e.ordinal();
        s.e r12 = r10.f11833d;
        if (r11 != 1) goto L8;
        p r13 = r12.f11854d;
    L23:
        return r13.f12200h;
    L8:
        if (r11 != 2) goto L10;
        r13 = r12.f11855e;
        goto L23
    L10:
        if (r11 != 3) goto L12;
        p r14 = r12.f11854d;
    L25:
        return r14.f12201i;
    L12:
        if (r11 != 4) goto L14;
        r14 = r12.f11855e;
        goto L25
    L14:
        if (r11 == 5) goto L24;
        return null;
    L24:
        return r12.f11855e.f12185k;
    }

    public static f i(s.d r8, int r10) {
        s.d r11 = r8.f11835f;
        if (r11 != null) goto L5;
        return null;
    L5:
        s.e r12 = r11.f11833d;
        if (r10 != 0) goto L8;
        p r13 = r12.f11854d;
    L9:
        int r14 = r11.f11834e.ordinal();
        if (r14 == 1) goto L20;
        if (r14 == 2) goto L20;
        if (r14 == 3) goto L21;
        if (r14 == 4) goto L21;
        return null;
    L21:
        return r13.f12201i;
    L20:
        return r13.f12200h;
    L8:
        r13 = r12.f11855e;
        goto L9
    }

    @Override // t.d
    public void a(d r8) {
    }

    public final void c(f r8, f r10, int r11, g r12) {
        r8.f12170l.add(r10);
        r8.f12170l.add(this.f12197e);
        r8.f12166h = r11;
        r8.f12167i = r12;
        r10.f12169k.add(r8);
        r12.f12169k.add(r8);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int r8, int r10) {
        s.e r11 = this.f12194b;
        if (r10 != 0) goto L9;
        int r12 = r11.f11887w;
        int r13 = Math.max(r11.f11886v, r8);
        if (r12 <= 0) goto L7;
        r13 = Math.min(r12, r8);
    L7:
        if (r13 != r8) goto L14;
        return r8;
    L14:
        return r13;
    L9:
        int r14 = r11.f11890z;
        r13 = Math.max(r11.f11889y, r8);
        if (r14 <= 0) goto L12;
        r13 = Math.min(r14, r8);
    L12:
        if (r13 != r8) goto L14;
        return r8;
    }

    public long j() {
        g r8 = this.f12197e;
        if (r8.f12168j == true) goto L5;
        return 0;
    L5:
        return r8.f12165g;
    }

    public abstract boolean k();

    public final void l(s.d r13, s.d r14, int r15) {
        f r8 = h(r13);
        f r10 = h(r14);
        if (r8.f12168j == true) goto L5;
        return;
    L5:
        if (r10.f12168j == false) goto L68;
        int r16 = r13.e() + r8.f12165g;
        int r11 = r10.f12165g - r14.e();
        int r17 = r11 - r16;
        g r12 = this.f12197e;
        if (r12.f12168j == true) goto L53;
        s.e.a r18 = this.f12196d;
        s.e.a r19 = s.e.a.f11893m;
        if (r18 != r19) goto L53;
        int r20 = this.f12193a;
        if (r20 != 0) goto L14;
        int r21 = r17;
    L50:
        int r22 = g(r21, r15);
    L51:
        r12.d(r22);
        goto L53
    L14:
        if (r20 != 1) goto L16;
        r22 = Math.min(g(r12.f12180m, r15), r17);
        goto L51
    L16:
        if (r20 != 2) goto L18;
        s.e r23 = this.f12194b;
        s.e r24 = r23.W;
        if (r24 == null) goto L53;
        if (r15 != 0) goto L41;
        p r25 = r24.f11854d;
    L42:
        g r26 = r25.f12197e;
        if (r26.f12168j == false) goto L53;
        if (r15 != 0) goto L46;
        float r27 = r23.f11888x;
    L47:
        r21 = (int) ((r26.f12165g * r27) + 0.5f);
        goto L50
    L46:
        r27 = r23.A;
        goto L47
    L41:
        r25 = r24.f11855e;
        goto L42
    L18:
        if (r20 != 3) goto L53;
        s.e r28 = this.f12194b;
        p r29 = r28.f11854d;
        if (r29.f12196d == r19) goto L23;
    L29:
        if (r15 != 0) goto L31;
        r29 = r28.f11855e;
    L31:
        g r30 = r29.f12197e;
        if (r30.f12168j == false) goto L53;
        float r31 = r28.Z;
        if (r15 != 1) goto L36;
        r22 = (int) ((r30.f12165g / r31) + 0.5f);
        goto L51
    L36:
        r22 = (int) ((r31 * r30.f12165g) + 0.5f);
        goto L51
    L23:
        if (r29.f12193a != 3) goto L29;
        n r110 = r28.f11855e;
        if (r110.f12196d != r19) goto L29;
        if (r110.f12193a != 3) goto L29;
    L53:
        if (r12.f12168j == true) goto L55;
        return;
    L55:
        int r32 = r12.f12165g;
        f r33 = this.f12201i;
        f r34 = this.f12200h;
        if (r32 != r17) goto L59;
        r34.d(r16);
        r33.d(r11);
        return;
    L59:
        s.e r111 = this.f12194b;
        if (r15 != 0) goto L62;
        float r112 = r111.f11860g0;
    L63:
        if (r8 != r10) goto L65;
        r16 = r8.f12165g;
        r11 = r10.f12165g;
        r112 = 0.5f;
    L65:
        r34.d((int) ((((r11 - r16) - r32) * r112) + (r16 + 0.5f)));
        r33.d(r34.f12165g + r12.f12165g);
        return;
    L62:
        r112 = r111.f11862h0;
        goto L63
    }
}
