package p;

import com.obric.cae.smartBluetooth.deviceIdentification.bdim.BdimCategoryConstants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h implements Comparable<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9896b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9897m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9898n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f9899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f9900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final float[] f9901q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float[] f9902r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f9903s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public b[] f9904t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f9905u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f9906v;

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f9907a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f9908b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f9909m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f9910n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ a[] f9911o = null;

        static {
            a r8 = new a("UNRESTRICTED", 0);
            f9907a = r8;
            a r10 = new a("CONSTANT", 1);
            a r11 = new a("SLACK", 2);
            f9908b = r11;
            a r12 = new a("ERROR", 3);
            f9909m = r12;
            a r13 = new a(BdimCategoryConstants.VALUE_UNKNOWN, 4);
            f9910n = r13;
            f9911o = new a[]{r8, r10, r11, r12, r13};
        }

        public a(String r8, int r10) {
            super(r8, r10);
        }

        public static a valueOf(String r8) {
            return (a) Enum.valueOf(a.class, r8);
        }

        public static a[] values() {
            return (a[]) f9911o.clone();
        }
    }

    public h(a r8) {
        this.f9896b = -1;
        this.f9897m = -1;
        this.f9898n = 0;
        this.f9900p = false;
        this.f9901q = new float[9];
        this.f9902r = new float[9];
        this.f9904t = new b[16];
        this.f9905u = 0;
        this.f9906v = 0;
        this.f9903s = r8;
    }

    public final void a(b r8) {
        int r10 = 0;
    L3:
        int r11 = this.f9905u;
        if (r10 >= r11) goto L9;
        if (this.f9904t[r10] == r8) goto L7;
        r10 = r10 + 1;
        goto L3
    L7:
        return;
    L9:
        b[] r12 = this.f9904t;
        if (r11 < r12.length) goto L12;
        this.f9904t = (b[]) Arrays.copyOf(r12, r12.length * 2);
    L12:
        b[] r13 = this.f9904t;
        int r14 = this.f9905u;
        r13[r14] = r8;
        this.f9905u = r14 + 1;
    }

    public final void b(b r8) {
        int r10 = this.f9905u;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        if (this.f9904t[r11] == r8) goto L7;
        r11 = r11 + 1;
    L7:
        if (r11 >= (r10 - 1)) goto L9;
        b[] r12 = this.f9904t;
        int r13 = r11 + 1;
        r12[r11] = r12[r13];
        r11 = r13;
        goto L7
    L9:
        this.f9905u--;
        return;
    }

    public final void c() {
        this.f9903s = a.f9910n;
        this.f9898n = 0;
        this.f9896b = -1;
        this.f9897m = -1;
        this.f9899o = 0.0f;
        this.f9900p = false;
        int r8 = this.f9905u;
        int r10 = 0;
    L3:
        if (r10 >= r8) goto L5;
        this.f9904t[r10] = null;
        r10 = r10 + 1;
        goto L3
    L5:
        this.f9905u = 0;
        this.f9906v = 0;
        this.f9895a = false;
        Arrays.fill(this.f9902r, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(h r8) {
        return this.f9896b - r8.f9896b;
    }

    public final void d(d r8, float r10) {
        this.f9899o = r10;
        this.f9900p = true;
        int r11 = this.f9905u;
        this.f9897m = -1;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f9904t[r12].h(r8, this, false);
        r12 = r12 + 1;
        goto L3
    L5:
        this.f9905u = 0;
    }

    public final void e(d r8, b r10) {
        int r11 = this.f9905u;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.f9904t[r12].i(r8, r10, false);
        r12 = r12 + 1;
        goto L3
    L5:
        this.f9905u = 0;
    }

    public final String toString() {
        return "" + this.f9896b;
    }
}
