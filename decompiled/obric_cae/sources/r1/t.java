package r1;

import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f11337u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final s f11338v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f11339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.work.u.a f11340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f11342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.work.e f11343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.work.e f11344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public androidx.work.d f11348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f11349k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final androidx.work.a f11350l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f11351m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f11352n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f11353o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f11354p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11355q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.work.q f11356r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f11357s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f11358t;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.work.u.a f11360b;

        public a(androidx.work.u.a r8, String r10) {
            he.i.f(r10, "id");
            this.f11359a = r10;
            this.f11360b = r8;
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof a) == true) goto L8;
            return false;
        L8:
            a r10 = (a) r8;
            String r11 = r10.f11359a;
            if (he.i.a(this.f11359a, r11) == true) goto L12;
            return false;
        L12:
            if (this.f11360b == r10.f11360b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r8 = this.f11359a.hashCode() * 31;
            return this.f11360b.hashCode() + r8;
        }

        public final String toString() {
            return "IdAndState(id=" + this.f11359a + ", state=" + this.f11360b + ')';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f11361a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.work.u.a f11362b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.work.e f11363c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f11364d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f11365e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<String> f11366f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final List<androidx.work.e> f11367g;

        public b(String r8, androidx.work.u.a r10, androidx.work.e r11, int r12, int r13, ArrayList r14, ArrayList r15) {
            he.i.f(r8, "id");
            this.f11361a = r8;
            this.f11362b = r10;
            this.f11363c = r11;
            this.f11364d = r12;
            this.f11365e = r13;
            this.f11366f = r14;
            this.f11367g = r15;
        }

        public final androidx.work.u a() {
            List<androidx.work.e> r8 = this.f11367g;
            if ((!r8.isEmpty()) == false) goto L5;
            androidx.work.e r10 = r8.get(0);
        L7:
            return new androidx.work.u(UUID.fromString(this.f11361a), this.f11362b, this.f11363c, this.f11366f, r10, this.f11364d, this.f11365e);
        L5:
            r10 = androidx.work.e.f2823c;
            goto L7
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L8;
            return false;
        L8:
            b r10 = (b) r8;
            String r11 = r10.f11361a;
            if (he.i.a(this.f11361a, r11) == true) goto L12;
            return false;
        L12:
            if (this.f11362b == r10.f11362b) goto L15;
            return false;
        L15:
            if (he.i.a(this.f11363c, r10.f11363c) == true) goto L18;
            return false;
        L18:
            if (this.f11364d == r10.f11364d) goto L21;
            return false;
        L21:
            if (this.f11365e == r10.f11365e) goto L24;
            return false;
        L24:
            if (he.i.a(this.f11366f, r10.f11366f) == true) goto L27;
            return false;
        L27:
            if (he.i.a(this.f11367g, r10.f11367g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r8 = this.f11361a.hashCode() * 31;
            int r10 = (this.f11362b.hashCode() + r8) * 31;
            int r11 = (this.f11363c.hashCode() + r10) * 31;
            int r12 = (Integer.hashCode(this.f11364d) + r11) * 31;
            int r13 = (Integer.hashCode(this.f11365e) + r12) * 31;
            int r14 = (this.f11366f.hashCode() + r13) * 31;
            return this.f11367g.hashCode() + r14;
        }

        public final String toString() {
            return "WorkInfoPojo(id=" + this.f11361a + ", state=" + this.f11362b + ", output=" + this.f11363c + ", runAttemptCount=" + this.f11364d + ", generation=" + this.f11365e + ", tags=" + this.f11366f + ", progress=" + this.f11367g + ')';
        }
    }

    static {
        String r8 = androidx.work.m.f("WorkSpec");
        he.i.e(r8, "tagWithPrefix(\"WorkSpec\")");
        f11337u = r8;
        f11338v = new s(0);
    }

    public t(String r11, androidx.work.u.a r12, String r13, String r14, androidx.work.e r15, androidx.work.e r16, long r17, long r19, long r21, androidx.work.d r23, int r24, androidx.work.a r25, long r26, long r28, long r30, long r32, boolean r34, androidx.work.q r35, int r36, int r37) {
        he.i.f(r11, "id");
        he.i.f(r12, "state");
        he.i.f(r13, "workerClassName");
        he.i.f(r15, QesdkUtils.TAGS.TAG_INPUT);
        he.i.f(r16, QesdkUtils.TAGS.TAG_OUTPUT);
        he.i.f(r23, "constraints");
        he.i.f(r25, "backoffPolicy");
        he.i.f(r35, "outOfQuotaPolicy");
        this.f11339a = r11;
        this.f11340b = r12;
        this.f11341c = r13;
        this.f11342d = r14;
        this.f11343e = r15;
        this.f11344f = r16;
        this.f11345g = r17;
        this.f11346h = r19;
        this.f11347i = r21;
        this.f11348j = r23;
        this.f11349k = r24;
        this.f11350l = r25;
        this.f11351m = r26;
        this.f11352n = r28;
        this.f11353o = r30;
        this.f11354p = r32;
        this.f11355q = r34;
        this.f11356r = r35;
        this.f11357s = r36;
        this.f11358t = r37;
    }

    public static t b(t r31, String r32, androidx.work.u.a r33, String r34, androidx.work.e r35, int r36, long r37, int r39, int r40) {
        if ((r40 & 1) == 0) goto L5;
        String r8 = r31.f11339a;
    L7:
        if ((r40 & 2) == 0) goto L9;
        androidx.work.u.a r10 = r31.f11340b;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r11 = r31.f11341c;
    L15:
        if ((r40 & 8) == 0) goto L17;
        String r12 = r31.f11342d;
    L19:
        if ((r40 & 16) == 0) goto L21;
        androidx.work.e r13 = r31.f11343e;
    L23:
        if ((r40 & 32) == 0) goto L25;
        androidx.work.e r14 = r31.f11344f;
    L27:
        if ((r40 & 64) == 0) goto L29;
        long r15 = r31.f11345g;
    L31:
        if ((r40 & 128) == 0) goto L33;
        long r16 = r31.f11346h;
    L35:
        if ((r40 & 256) == 0) goto L37;
        long r17 = r31.f11347i;
    L39:
        if ((r40 & 512) == 0) goto L41;
        androidx.work.d r18 = r31.f11348j;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        int r19 = r31.f11349k;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        androidx.work.a r110 = r31.f11350l;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        long r111 = r31.f11351m;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        long r21 = r31.f11352n;
    L59:
        if ((r40 & 16384) == 0) goto L61;
        long r23 = r31.f11353o;
    L63:
        if ((32768 & r40) == 0) goto L65;
        long r25 = r31.f11354p;
    L66:
        int r20 = 0;
        if ((65536 & r40) == 0) goto L69;
        boolean r27 = r31.f11355q;
    L71:
        if ((131072 & r40) == 0) goto L73;
        androidx.work.q r22 = r31.f11356r;
    L75:
        if ((r40 & 262144) == 0) goto L77;
        r20 = r31.f11357s;
    L77:
        int r29 = r20;
        if ((r40 & 524288) == 0) goto L80;
        int r30 = r31.f11358t;
    L81:
        r31.getClass();
        String r24 = r8;
        he.i.f(r24, "id");
        he.i.f(r10, "state");
        he.i.f(r11, "workerClassName");
        he.i.f(r13, QesdkUtils.TAGS.TAG_INPUT);
        he.i.f(r14, QesdkUtils.TAGS.TAG_OUTPUT);
        he.i.f(r18, "constraints");
        he.i.f(r110, "backoffPolicy");
        he.i.f(r22, "outOfQuotaPolicy");
        androidx.work.a r26 = r110;
        return new t(r24, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r26, r111, r21, r23, r25, r27, r22, r29, r30);
    L80:
        r30 = r39;
        goto L81
    L73:
        r22 = null;
        goto L75
    L69:
        r27 = false;
        goto L71
    L65:
        r25 = 0;
        goto L66
    L61:
        r23 = 0;
        goto L63
    L57:
        r21 = r37;
        goto L59
    L53:
        r111 = 0;
        goto L55
    L49:
        r110 = null;
        goto L51
    L45:
        r19 = r36;
        goto L47
    L41:
        r18 = null;
        goto L43
    L37:
        r17 = 0;
        goto L39
    L33:
        r16 = 0;
        goto L35
    L29:
        r15 = 0;
        goto L31
    L25:
        r14 = null;
        goto L27
    L21:
        r13 = r35;
        goto L23
    L17:
        r12 = null;
        goto L19
    L13:
        r11 = r34;
        goto L15
    L9:
        r10 = r33;
        goto L11
    L5:
        r8 = r32;
        goto L7
    }

    public final long a() {
        androidx.work.u.a r8 = this.f11340b;
        androidx.work.u.a r10 = androidx.work.u.a.f2952a;
        boolean r11 = true;
        int r12 = this.f11349k;
        boolean r13 = false;
        if (r8 != r10) goto L6;
        if (r12 <= 0) goto L6;
        boolean r14 = true;
    L7:
        if (r14 == true) goto L9;
        long r15 = 0;
        if (f() == false) goto L36;
        long r16 = this.f11352n;
        int r17 = this.f11357s;
        if (r17 != 0) goto L24;
        r16 = r16 + this.f11345g;
    L24:
        long r18 = this.f11347i;
        long r19 = this.f11346h;
        if (r18 != r19) goto L28;
        r11 = false;
    L28:
        if (r11 == false) goto L32;
        if (r17 != 0) goto L31;
        r15 = ((long) (-1)) * r18;
    L31:
        r16 = r16 + r19;
    L42:
        return r16 + r15;
    L32:
        if (r17 == 0) goto L42;
        r15 = r19;
        goto L42
    L36:
        long r20 = this.f11352n;
        if (r20 != 0) goto L40;
        r20 = System.currentTimeMillis();
    L40:
        return this.f11345g + r20;
    L9:
        if (this.f11350l != androidx.work.a.f2792b) goto L11;
        r13 = true;
    L11:
        long r21 = this.f11351m;
        if (r13 == false) goto L14;
        long r22 = r21 * ((long) r12);
    L15:
        long r23 = this.f11352n;
        if (r22 <= 18000000) goto L41;
        r22 = 18000000;
    L41:
        return r23 + r22;
    L14:
        r22 = (long) Math.scalb(r21, r12 - 1);
    L6:
        r14 = false;
        goto L7
    }

    public final int c() {
        return this.f11358t;
    }

    public final int d() {
        return this.f11357s;
    }

    public final boolean e() {
        return !he.i.a(androidx.work.d.f2807i, this.f11348j);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof t) == true) goto L8;
        return false;
    L8:
        t r10 = (t) r8;
        String r11 = r10.f11339a;
        if (he.i.a(this.f11339a, r11) == true) goto L12;
        return false;
    L12:
        if (this.f11340b == r10.f11340b) goto L15;
        return false;
    L15:
        if (he.i.a(this.f11341c, r10.f11341c) == true) goto L18;
        return false;
    L18:
        if (he.i.a(this.f11342d, r10.f11342d) == true) goto L21;
        return false;
    L21:
        if (he.i.a(this.f11343e, r10.f11343e) == true) goto L24;
        return false;
    L24:
        if (he.i.a(this.f11344f, r10.f11344f) == true) goto L27;
        return false;
    L27:
        if (this.f11345g == r10.f11345g) goto L30;
        return false;
    L30:
        if (this.f11346h == r10.f11346h) goto L33;
        return false;
    L33:
        if (this.f11347i == r10.f11347i) goto L36;
        return false;
    L36:
        if (he.i.a(this.f11348j, r10.f11348j) == true) goto L39;
        return false;
    L39:
        if (this.f11349k == r10.f11349k) goto L42;
        return false;
    L42:
        if (this.f11350l == r10.f11350l) goto L45;
        return false;
    L45:
        if (this.f11351m == r10.f11351m) goto L48;
        return false;
    L48:
        if (this.f11352n == r10.f11352n) goto L51;
        return false;
    L51:
        if (this.f11353o == r10.f11353o) goto L54;
        return false;
    L54:
        if (this.f11354p == r10.f11354p) goto L57;
        return false;
    L57:
        if (this.f11355q == r10.f11355q) goto L60;
        return false;
    L60:
        if (this.f11356r == r10.f11356r) goto L63;
        return false;
    L63:
        if (this.f11357s == r10.f11357s) goto L66;
        return false;
    L66:
        if (this.f11358t == r10.f11358t) goto L68;
        return false;
    L68:
        return true;
    }

    public final boolean f() {
        if (this.f11346h == 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28, types: [int] */
    /* JADX WARN: Type inference failed for: r1v32, types: [int] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v39 */
    public final int hashCode() {
        int r8 = this.f11339a.hashCode() * 31;
        int r10 = (this.f11340b.hashCode() + r8) * 31;
        int r11 = defpackage.a.b(this.f11341c, r10, 31);
        String r12 = this.f11342d;
        if (r12 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (r11 + r13) * 31;
        int r15 = (this.f11343e.hashCode() + r14) * 31;
        int r16 = (this.f11344f.hashCode() + r15) * 31;
        int r17 = (Long.hashCode(this.f11345g) + r16) * 31;
        int r18 = (Long.hashCode(this.f11346h) + r17) * 31;
        int r19 = (Long.hashCode(this.f11347i) + r18) * 31;
        int r20 = (this.f11348j.hashCode() + r19) * 31;
        int r21 = (Integer.hashCode(this.f11349k) + r20) * 31;
        int r22 = (this.f11350l.hashCode() + r21) * 31;
        int r23 = (Long.hashCode(this.f11351m) + r22) * 31;
        int r24 = (Long.hashCode(this.f11352n) + r23) * 31;
        int r25 = (Long.hashCode(this.f11353o) + r24) * 31;
        int r26 = (Long.hashCode(this.f11354p) + r25) * 31;
        boolean r27 = this.f11355q;
        ?? r28 = r27;
        if (r27 == false) goto L9;
        r28 = 1;
    L9:
        int r29 = (r26 + r28) * 31;
        int r30 = (this.f11356r.hashCode() + r29) * 31;
        int r31 = (Integer.hashCode(this.f11357s) + r30) * 31;
        return Integer.hashCode(this.f11358t) + r31;
    L5:
        r13 = r12.hashCode();
        goto L6
    }

    public final String toString() {
        return "{WorkSpec: " + this.f11339a + '}';
    }

    public /* synthetic */ t(String r31, androidx.work.u.a r32, String r33, String r34, androidx.work.e r35, androidx.work.e r36, long r37, long r39, long r41, androidx.work.d r43, int r44, androidx.work.a r45, long r46, long r48, long r50, long r52, boolean r54, androidx.work.q r55, int r56, int r57, int r58) {
        if ((r57 & 2) == 0) goto L5;
        androidx.work.u.a r8 = androidx.work.u.a.f2952a;
    L7:
        if ((r57 & 8) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r57 & 16) == 0) goto L13;
        androidx.work.e r11 = androidx.work.e.f2823c;
        he.i.e(r11, "EMPTY");
        androidx.work.e r12 = r11;
    L15:
        if ((r57 & 32) == 0) goto L17;
        androidx.work.e r13 = androidx.work.e.f2823c;
        he.i.e(r13, "EMPTY");
        androidx.work.e r14 = r13;
    L19:
        if ((r57 & 64) == 0) goto L21;
        long r15 = 0;
    L23:
        if ((r57 & 128) == 0) goto L25;
        long r16 = 0;
    L27:
        if ((r57 & 256) == 0) goto L29;
        long r17 = 0;
    L31:
        if ((r57 & 512) == 0) goto L33;
        androidx.work.d r18 = androidx.work.d.f2807i;
    L35:
        if ((r57 & 1024) == 0) goto L37;
        int r19 = 0;
    L39:
        if ((r57 & 2048) == 0) goto L41;
        androidx.work.a r110 = androidx.work.a.f2791a;
    L43:
        if ((r57 & 4096) == 0) goto L45;
        long r111 = 30000;
    L47:
        if ((r57 & 8192) == 0) goto L49;
        long r20 = 0;
    L51:
        if ((r57 & 16384) == 0) goto L53;
        long r22 = 0;
    L55:
        if ((32768 & r57) == 0) goto L57;
        long r24 = -1;
    L59:
        if ((65536 & r57) == 0) goto L61;
        boolean r26 = false;
    L63:
        if ((131072 & r57) == 0) goto L65;
        androidx.work.q r27 = androidx.work.q.f2942a;
    L67:
        if ((r57 & 262144) == 0) goto L69;
        int r28 = 0;
    L70:
        this(r31, r8, r33, r10, r12, r14, r15, r16, r17, r18, r19, r110, r111, r20, r22, r24, r26, r27, r28, 0);
        return;
    L69:
        r28 = r56;
        goto L70
    L65:
        r27 = r55;
        goto L67
    L61:
        r26 = r54;
        goto L63
    L57:
        r24 = r52;
        goto L59
    L53:
        r22 = r50;
        goto L55
    L49:
        r20 = r48;
        goto L51
    L45:
        r111 = r46;
        goto L47
    L41:
        r110 = r45;
        goto L43
    L37:
        r19 = r44;
        goto L39
    L33:
        r18 = r43;
        goto L35
    L29:
        r17 = r41;
        goto L31
    L25:
        r16 = r39;
        goto L27
    L21:
        r15 = r37;
        goto L23
    L17:
        r14 = r36;
        goto L19
    L13:
        r12 = r35;
        goto L15
    L9:
        r10 = r34;
        goto L11
    L5:
        r8 = r32;
        goto L7
    }
}
