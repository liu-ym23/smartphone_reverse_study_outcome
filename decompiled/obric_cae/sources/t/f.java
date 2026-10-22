package t;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f12159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f12161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p f12162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f12163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12166h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f12167i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f12168j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList f12169k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f12170l;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12171a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12172b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f12173m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f12174n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f12175o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f12176p = null;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f12177q = null;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f12178r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final /* synthetic */ a[] f12179s = null;

        static {
            a r8 = new a(BdimCategoryConstants.VALUE_UNKNOWN, 0);
            f12171a = r8;
            a r10 = new a("HORIZONTAL_DIMENSION", 1);
            f12172b = r10;
            a r11 = new a("VERTICAL_DIMENSION", 2);
            f12173m = r11;
            a r12 = new a("LEFT", 3);
            f12174n = r12;
            a r13 = new a("RIGHT", 4);
            f12175o = r13;
            a r14 = new a("TOP", 5);
            f12176p = r14;
            a r15 = new a("BOTTOM", 6);
            f12177q = r15;
            a r16 = new a("BASELINE", 7);
            f12178r = r16;
            f12179s = new a[]{r8, r10, r11, r12, r13, r14, r15, r16};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f12179s.clone();
        }
    }

    public f(p r8) {
        this.f12159a = null;
        this.f12160b = false;
        this.f12161c = false;
        this.f12163e = a.f12171a;
        this.f12166h = 1;
        this.f12167i = null;
        this.f12168j = false;
        this.f12169k = new ArrayList();
        this.f12170l = new ArrayList();
        this.f12162d = r8;
    }

    @Override // t.d
    public final void a(d r8) {
        ArrayList r10 = this.f12170l;
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        if (((f) r11.next()).f12168j == true) goto L4;
        return;
    L8:
        this.f12161c = true;
        p r12 = this.f12159a;
        if (r12 == null) goto L12;
        r12.a(this);
    L12:
        if (this.f12160b == false) goto L15;
        this.f12162d.a(this);
        return;
    L15:
        Iterator r13 = r10.iterator();
        f r14 = null;
        int r15 = 0;
    L17:
        if (r13.hasNext() == false) goto L22;
        f r16 = (f) r13.next();
        if ((r16 instanceof g) == true) goto L17;
        r15 = r15 + 1;
        r14 = r16;
        goto L17
    L22:
        if (r14 == null) goto L33;
        if (r15 != 1) goto L33;
        if (r14.f12168j == false) goto L33;
        g r17 = this.f12167i;
        if (r17 != null) goto L29;
    L32:
        d(r14.f12165g + this.f12164f);
        goto L33
    L29:
        if (r17.f12168j == false) goto L31;
        this.f12164f = this.f12166h * r17.f12165g;
        goto L32
    L31:
        return;
    L33:
        p r18 = this.f12159a;
        if (r18 == null) goto L45;
        r18.a(this);
        return;
    }

    public final void b(d r8) {
        this.f12169k.add(r8);
        if (this.f12168j == false) goto L6;
        r8.a(r8);
        return;
    }

    public final void c() {
        this.f12170l.clear();
        this.f12169k.clear();
        this.f12168j = false;
        this.f12165g = 0;
        this.f12161c = false;
        this.f12160b = false;
    }

    public void d(int r8) {
        if (this.f12168j == false) goto L5;
        return;
    L5:
        this.f12168j = true;
        this.f12165g = r8;
        Iterator r10 = this.f12169k.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        d r11 = (d) r10.next();
        r11.a(r11);
        goto L7
    }

    public final String toString() {
        StringBuilder r8 = new StringBuilder();
        r8.append(this.f12162d.f12194b.f11868k0);
        r8.append(BdimCategoryConstants.SEPARATOR_COLON);
        r8.append(this.f12163e);
        r8.append("(");
        if (this.f12168j == false) goto L5;
        Object r10 = Integer.valueOf(this.f12165g);
    L6:
        r8.append(r10);
        r8.append(") <t=");
        r8.append(this.f12170l.size());
        r8.append(":d=");
        r8.append(this.f12169k.size());
        r8.append(">");
        return r8.toString();
    L5:
        r10 = "unresolved";
        goto L6
    }
}
