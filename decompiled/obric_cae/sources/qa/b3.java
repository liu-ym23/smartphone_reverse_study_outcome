package qa;

import com.qualcomm.qti.qesdk.QesdkUtils;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes.dex */
public final class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f10233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f10234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f10237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f10238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f10241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f10242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10244o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10245p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f10246q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f10247r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f10248s;

    public b3(int r8, boolean r10) {
        this.f10230a = 0;
        this.f10231b = 0;
        this.f10232c = 0;
        this.f10233d = 0;
        this.f10234e = 0;
        this.f10235f = 0;
        this.f10236g = 0;
        this.f10237h = 0;
        this.f10238i = 0;
        this.f10239j = 0;
        this.f10240k = NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
        this.f10241l = 0;
        this.f10242m = false;
        this.f10243n = QesdkUtils.LIMITS.INT_16_UPPER;
        this.f10244o = Integer.MAX_VALUE;
        this.f10245p = Integer.MAX_VALUE;
        this.f10246q = true;
        this.f10247r = 99;
        this.f10248s = 0;
        this.f10241l = r8;
        this.f10242m = r10;
    }

    public final String a() {
        int r8 = this.f10241l;
        if (r8 != 1) goto L5;
    L15:
        StringBuilder r10 = new StringBuilder();
        r10.append(r8);
        r10.append("#");
        r10.append(this.f10230a);
        r10.append("#");
        r10.append(this.f10231b);
        r10.append("#0#");
        if (r8 != 5) goto L18;
        long r11 = this.f10234e;
    L19:
        r10.append(r11);
        return r10.toString();
    L18:
        r11 = this.f10233d;
        goto L19
    L5:
        if (r8 == 2) goto L14;
        if (r8 == 3) goto L15;
        if (r8 == 4) goto L15;
        if (r8 == 5) goto L15;
        return null;
    L14:
        return r8 + "#" + this.f10237h + "#" + this.f10238i + "#" + this.f10239j;
    }

    public final String b() {
        String r8 = a();
        if (r8 != null) goto L5;
        return "";
    L5:
        if (r8.length() > 0) goto L7;
        return "";
    L7:
        return (this.f10246q ? 1 : 0) + "#" + r8;
    }

    public final b3 c() {
        b3 r8 = new b3(this.f10241l, this.f10242m);
        r8.f10230a = this.f10230a;
        r8.f10231b = this.f10231b;
        r8.f10232c = this.f10232c;
        r8.f10233d = this.f10233d;
        r8.f10234e = this.f10234e;
        r8.f10235f = this.f10235f;
        r8.f10236g = this.f10236g;
        r8.f10237h = this.f10237h;
        r8.f10238i = this.f10238i;
        r8.f10239j = this.f10239j;
        r8.f10240k = this.f10240k;
        r8.f10243n = this.f10243n;
        r8.f10244o = this.f10244o;
        r8.f10245p = this.f10245p;
        r8.f10246q = this.f10246q;
        r8.f10247r = this.f10247r;
        r8.f10248s = this.f10248s;
        return r8;
    }

    public final /* synthetic */ Object clone() {
        return c();
    }

    public final boolean equals(Object r8) {
        if (r8 != null) goto L6;
        return false;
    L6:
        if ((r8 instanceof b3) == false) goto L67;
        b3 r10 = (b3) r8;
        int r11 = this.f10241l;
        int r12 = r10.f10241l;
        if (r12 != 1) goto L10;
        if (r11 == 1) goto L61;
        return false;
    L61:
        if (r10.f10232c != this.f10232c) goto L67;
        if (r10.f10233d != this.f10233d) goto L67;
        if (r10.f10231b != this.f10231b) goto L67;
        return true;
    L10:
        if (r12 != 2) goto L12;
        if (r11 == 2) goto L51;
        return false;
    L51:
        if (r10.f10239j == this.f10239j) goto L53;
    L57:
        return false;
    L53:
        if (r10.f10238i != this.f10238i) goto L57;
        if (r10.f10237h != this.f10237h) goto L57;
        return true;
    L12:
        if (r12 != 3) goto L14;
        if (r11 == 3) goto L41;
        return false;
    L41:
        if (r10.f10232c == this.f10232c) goto L43;
    L47:
        return false;
    L43:
        if (r10.f10233d != this.f10233d) goto L47;
        if (r10.f10231b != this.f10231b) goto L47;
        return true;
    L14:
        if (r12 != 4) goto L16;
        if (r11 == 4) goto L31;
        return false;
    L31:
        if (r10.f10232c == this.f10232c) goto L33;
    L37:
        return false;
    L33:
        if (r10.f10233d != this.f10233d) goto L37;
        if (r10.f10231b != this.f10231b) goto L37;
        return true;
    L16:
        if (r12 == 5) goto L18;
        return false;
    L18:
        if (r11 == 5) goto L21;
        return false;
    L21:
        if (r10.f10232c == this.f10232c) goto L23;
    L27:
        return false;
    L23:
        if (r10.f10234e != this.f10234e) goto L27;
        if (r10.f10245p != this.f10245p) goto L27;
        return true;
    L67:
        return false;
    }

    public final int hashCode() {
        int r8 = this.f10241l;
        int r10 = String.valueOf(r8).hashCode();
        if (r8 != 2) goto L5;
        int r11 = String.valueOf(this.f10239j).hashCode();
        int r12 = String.valueOf(this.f10238i).hashCode() + r11;
        int r13 = this.f10237h;
    L7:
        return (String.valueOf(r13).hashCode() + r12) + r10;
    L5:
        int r14 = String.valueOf(this.f10232c).hashCode();
        r12 = String.valueOf(this.f10233d).hashCode() + r14;
        r13 = this.f10231b;
        goto L7
    }
}
