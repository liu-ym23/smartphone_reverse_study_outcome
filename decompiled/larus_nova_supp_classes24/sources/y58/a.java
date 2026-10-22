package y58;

import kotlin.jvm.internal.Intrinsics;
import m58.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends w58.a {
    public final long A;
    public final String B;
    public x58.a C;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public Long j;
    public final Long k;
    public int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final Boolean q;
    public final int r;
    public final int s;
    public final boolean t;
    public final int u;
    public final int v;
    public final String w;
    public final String x;
    public final String y;
    public final d z;

    /* JADX INFO: renamed from: y58.a$a, reason: collision with other inner class name */
    public static final class C0138a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, false, false, null, null, 0, 0, null, 0, 0, false, 0, 0, null, null, null, null, 0, null, 268435455);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (this.h == r9.h) goto L33;
        return false;
    L33:
        if (this.i == r9.i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L42;
        return false;
    L42:
        if (this.l == r9.l) goto L45;
        return false;
    L45:
        if (this.m == r9.m) goto L48;
        return false;
    L48:
        if (this.n == r9.n) goto L51;
        return false;
    L51:
        if (this.o == r9.o) goto L54;
        return false;
    L54:
        if (this.p == r9.p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.q, r9.q) == true) goto L60;
        return false;
    L60:
        if (this.r == r9.r) goto L63;
        return false;
    L63:
        if (this.s == r9.s) goto L66;
        return false;
    L66:
        if (this.t == r9.t) goto L69;
        return false;
    L69:
        if (this.u == r9.u) goto L72;
        return false;
    L72:
        if (this.v == r9.v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.w, r9.w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.x, r9.x) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.y, r9.y) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.z, r9.z) == true) goto L87;
        return false;
    L87:
        if (this.A == r9.A) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r9.B) == true) goto L92;
        return false;
    L92:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        int r2 = 1231;
        if (this.f == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.g == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.h == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.i == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        Long r10 = this.j;
        int r11 = 0;
        if (r10 != null) goto L21;
        int r12 = 0;
    L22:
        int r13 = (r9 + r12) * 31;
        Long r14 = this.k;
        if (r14 != null) goto L25;
        int r15 = 0;
    L26:
        int r16 = (((((((((((r13 + r15) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31;
        Boolean r17 = this.q;
        if (r17 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (((((r16 + r19) * 31) + this.r) * 31) + this.s) * 31;
        if (this.t == true) goto L34;
        r2 = 1237;
    L34:
        int r21 = (((((((((r20 + r2) * 31) + this.u) * 31) + this.v) * 31) + this.w.hashCode()) * 31) + this.x.hashCode()) * 31;
        String r22 = this.y;
        if (r22 == null) goto L38;
        r11 = r22.hashCode();
    L38:
        int r23 = (((r21 + r11) * 31) + this.z.hashCode()) * 31;
        long r24 = this.A;
        return ((r23 + ((int) (r24 ^ (r24 >>> 32)))) * 31) + this.B.hashCode();
    L29:
        r19 = r17.hashCode();
        goto L30
    L25:
        r15 = r14.hashCode();
        goto L26
    L21:
        r12 = r10.hashCode();
        goto L22
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "AsrConfig(taskId=" + this.b + ", conversationId=" + this.c + ", language=" + this.d + ", saveAudioFile=" + this.i + ')';
    }

    public final String a() {
        return this.y;
    }

    public final int b() {
        return this.r;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.b;
    }

    public final d f() {
        return this.z;
    }

    public a(String r32, String r33, String r34, String r35, String r36, boolean r37, boolean r38, Long r39, Long r40, int r41, int r42, Boolean r43, int r44, int r45, boolean r46, int r47, int r48, String r49, String r50, String r51, d r52, long r53, String r55, int r56) {
        String r3 = "";
        if ((r56 & 1) == 0) goto L5;
        String r2 = "";
    L7:
        if ((r56 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r56 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r56 & 8) == 0) goto L17;
        String r6 = "";
    L19:
        if ((r56 & 16) != 0) goto L23;
        r3 = r36;
    L23:
        if ((r56 & 32) == 0) goto L25;
        boolean r7 = true;
    L27:
        if ((r56 & 64) == 0) goto L29;
        boolean r10 = false;
    L31:
        if ((r56 & 128) == 0) goto L33;
        boolean r11 = true;
    L35:
        if ((r56 & 256) == 0) goto L37;
        boolean r12 = false;
    L39:
        if ((r56 & 512) == 0) goto L41;
        Long r13 = null;
    L43:
        if ((r56 & 1024) == 0) goto L45;
        Long r15 = null;
    L47:
        if ((r56 & 2048) == 0) goto L49;
        int r9 = 1;
    L51:
        if ((r56 & 4096) == 0) goto L53;
        int r14 = 1;
    L55:
        if ((r56 & 8192) == 0) goto L57;
        int r8 = 1;
    L58:
        int r310 = r8;
        if ((r56 & 16384) == 0) goto L61;
        int r16 = 1920000;
    L63:
        if ((r56 & 65536) == 0) goto L65;
        Boolean r17 = null;
    L67:
        if ((r56 & 131072) == 0) goto L69;
        int r19 = 0;
    L71:
        if ((r56 & 262144) == 0) goto L73;
        int r110 = 0;
    L75:
        if ((r56 & 524288) == 0) goto L77;
        boolean r20 = false;
    L79:
        if ((r56 & 1048576) == 0) goto L81;
        int r21 = 16000;
    L83:
        if ((r56 & 2097152) == 0) goto L85;
        int r22 = 1;
    L87:
        if ((r56 & 4194304) == 0) goto L89;
        String r23 = "pcm";
    L91:
        if ((r56 & 8388608) == 0) goto L93;
        String r111 = "{}";
    L95:
        if ((r56 & 16777216) == 0) goto L97;
        String r25 = null;
    L99:
        if ((r56 & 33554432) == 0) goto L101;
        d r24 = new d(0);
    L103:
        if ((67108864 & r56) == 0) goto L105;
        long r29 = 500;
    L107:
        if ((r56 & 134217728) == 0) goto L109;
        String r1 = "IM_SAMI";
    L110:
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Intrinsics.checkNotNullParameter(r5, "conversationId");
        Intrinsics.checkNotNullParameter(r6, "language");
        Intrinsics.checkNotNullParameter(r3, "filePath");
        Intrinsics.checkNotNullParameter(r23, "format");
        Intrinsics.checkNotNullParameter(r111, "extraJsonConfig");
        Intrinsics.checkNotNullParameter(r24, "traceInfo");
        Intrinsics.checkNotNullParameter(r1, "scene");
        super(r23, r111);
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r3;
        this.f = r7;
        this.g = r10;
        this.h = r11;
        this.i = r12;
        this.j = r13;
        this.k = r15;
        this.l = r9;
        this.m = r14;
        this.n = r310;
        this.o = r16;
        this.p = 0;
        this.q = r17;
        this.r = r19;
        this.s = r110;
        this.t = r20;
        this.u = r21;
        this.v = r22;
        this.w = r23;
        this.x = r111;
        this.y = r25;
        this.z = r24;
        this.A = r29;
        this.B = r1;
        this.C = h.a;
        return;
    L109:
        r1 = r55;
        goto L110
    L105:
        r29 = r53;
        goto L107
    L101:
        r24 = r52;
        goto L103
    L97:
        r25 = r51;
        goto L99
    L93:
        r111 = r50;
        goto L95
    L89:
        r23 = r49;
        goto L91
    L85:
        r22 = r48;
        goto L87
    L81:
        r21 = r47;
        goto L83
    L77:
        r20 = r46;
        goto L79
    L73:
        r110 = r45;
        goto L75
    L69:
        r19 = r44;
        goto L71
    L65:
        r17 = r43;
        goto L67
    L61:
        r16 = 0;
        goto L63
    L57:
        r8 = 0;
        goto L58
    L53:
        r14 = r42;
        goto L55
    L49:
        r9 = r41;
        goto L51
    L45:
        r15 = r40;
        goto L47
    L41:
        r13 = r39;
        goto L43
    L37:
        r12 = r38;
        goto L39
    L33:
        r11 = false;
        goto L35
    L29:
        r10 = r37;
        goto L31
    L25:
        r7 = false;
        goto L27
    L17:
        r6 = r35;
        goto L19
    L13:
        r5 = r34;
        goto L15
    L9:
        r4 = r33;
        goto L11
    L5:
        r2 = r32;
        goto L7
    }
}
