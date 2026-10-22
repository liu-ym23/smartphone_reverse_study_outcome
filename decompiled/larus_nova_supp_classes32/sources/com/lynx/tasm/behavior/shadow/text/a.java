package com.lynx.tasm.behavior.shadow.text;

import android.text.Layout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import z6a.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public List<C0051a> A;
    public boolean B;
    public boolean C;
    public String D;
    public String E;
    public boolean F;
    public int G;
    public int H;
    public com.lynx.tasm.behavior.ui.g I;
    public int J;
    public int K;
    public int L;
    public int M;
    public float N;
    public a7a.b O;
    public int a;
    public int b;
    public Integer c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public t o;
    public float p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public String u;
    public boolean v;
    public float w;
    public float x;
    public float y;
    public float[] z;

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.shadow.text.a$a, reason: collision with other inner class name */
    public static class C0051a {
        public final int a;
        public final int b;
        public final float c;
        public final float d;

        public final int hashCode() {
            return (((((this.a * 31) + this.b) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
        }

        public final boolean equals(Object r4) {
            if ((r4 instanceof C0051a) == true) goto L5;
            return false;
        L5:
            C0051a r5 = (C0051a) r4;
            if (this.a == r5.a) goto L8;
            return false;
        L8:
            if (this.b == r5.b) goto L10;
            return false;
        L10:
            if (com.lynx.tasm.utils.b.a(this.c, r5.c) == true) goto L12;
            return false;
        L12:
            if (com.lynx.tasm.utils.b.a(this.d, r5.d) == false) goto L18;
            return true;
        L18:
            return false;
        }

        public C0051a(int r1, int r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public final a a() {
        a r0 = new a();
        r0.a = this.a;
        r0.b = this.b;
        r0.c = this.c;
        r0.d = this.d;
        r0.f = this.f;
        r0.g = this.g;
        r0.h = this.h;
        r0.i = this.i;
        r0.j = this.j;
        r0.k = this.k;
        r0.l = this.l;
        r0.m = this.m;
        r0.n = this.n;
        r0.o = this.o;
        r0.p = this.p;
        r0.q = this.q;
        r0.r = this.r;
        r0.s = this.s;
        r0.t = this.t;
        r0.u = this.u;
        r0.I = this.I;
        r0.J = this.J;
        r0.K = this.K;
        r0.L = this.L;
        r0.N = this.N;
        r0.M = this.M;
        r0.e = this.e;
        r0.H = this.H;
        r0.v = this.v;
        r0.x = this.x;
        r0.w = this.w;
        r0.y = this.y;
        r0.z = this.z;
        if (this.A != null) goto L5;
        ArrayList r1 = null;
    L6:
        r0.A = r1;
        r0.G = this.G;
        r0.B = this.B;
        r0.C = this.C;
        r0.D = this.D;
        r0.E = this.E;
        r0.F = this.F;
        return r0;
    L5:
        r1 = new ArrayList(this.A);
        goto L6
    }

    public final TextDirectionHeuristic b() {
        int r0 = this.e;
        if (r0 != 0) goto L7;
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L7:
        if (r0 != 3) goto L11;
        return TextDirectionHeuristics.LTR;
    L11:
        return TextDirectionHeuristics.RTL;
    }

    public final String c() {
        if (this.F == false) goto L5;
        StringBuilder r0 = new StringBuilder();
        if (TextUtils.isEmpty(this.D) == true) goto L9;
        r0.append(this.D);
        r0.append(",");
    L9:
        r0.append("'opsz' ");
        r0.append(this.n);
        return r0.toString();
    L5:
        return this.D;
    }

    public final int e() {
        int r0 = this.g;
        if (r0 == 1) goto L8;
        if (r0 < 6) goto L7;
        if (r0 <= 10) goto L8;
    L7:
        boolean r5 = false;
    L10:
        if (r5 == true) goto L12;
    L14:
        if (r0 == 1) goto L19;
        if (r0 < 6) goto L18;
        if (r0 <= 10) goto L19;
    L18:
        boolean r1 = false;
    L20:
        if (r1 == false) goto L22;
        return 1;
    L22:
        int r2 = this.h;
        if (r2 == 2) goto L25;
        return 0;
    L25:
        return r2;
    L19:
        r1 = true;
        goto L20
    L12:
        if (this.h != 2) goto L14;
        return 3;
    L8:
        r5 = true;
        goto L10
    }

    public final int hashCode() {
        int r0 = ((this.a * 31) + this.b) * 31;
        Integer r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.intValue();
    L6:
        int r3 = (((((((((((((((((((r0 + r2) * 31) + this.d) * 31) + this.f) * 31) + this.g) * 31) + this.i) * 31) + this.j) * 31) + Float.floatToIntBits(this.k)) * 31) + Float.floatToIntBits(this.l)) * 31) + Float.floatToIntBits(this.m)) * 31) + Float.floatToIntBits(this.n)) * 31;
        t r4 = this.o;
        int r5 = 0;
        if (r4 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((((((r3 + r6) * 31) + Float.floatToIntBits(this.p)) * 31) + (this.q ? 1 : 0)) * 31) + (this.s ? 1 : 0)) * 31) + (this.r ? 1 : 0)) * 31) + (this.t ? 1 : 0)) * 31;
        String r8 = this.u;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        com.lynx.tasm.behavior.ui.g r11 = this.I;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (((((((((((((r10 + r12) * 31) + this.J) * 31) + this.K) * 31) + this.L) * 31) + Float.floatToIntBits(this.N)) * 31) + this.M) * 31) + this.e) * 31;
        a7a.b r14 = this.O;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((((((((r13 + r15) * 31) + this.H) * 31) + (this.v ? 1 : 0)) * 31) + Float.floatToIntBits(this.x)) * 31) + Float.floatToIntBits(this.w)) * 31) + Float.floatToIntBits(this.y)) * 31;
        float[] r17 = this.z;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        List<C0051a> r20 = this.A;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (((((((r19 + r21) * 31) + this.G) * 31) + (this.B ? 1 : 0)) * 31) + (this.C ? 1 : 0)) * 31;
        String r23 = this.D;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.E;
        if (r26 == null) goto L39;
        r5 = r26.hashCode();
    L39:
        return ((r25 + r5) * 31) + (this.F ? 1 : 0);
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
        goto L30
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r4.hashCode();
        goto L10
    L5:
        r2 = -16777216;
        goto L6
    }

    public a() {
        this.a = -1;
        this.b = -1;
        this.c = null;
        this.d = 3;
        this.e = 0;
        this.f = -1;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 1.0E21f;
        this.l = 1.0E21f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = null;
        this.p = 0.0f;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = null;
        this.v = false;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 1.0f;
        this.B = false;
        this.C = false;
        this.D = null;
        this.E = null;
        this.F = false;
        this.G = 0;
        this.H = 0;
        this.K = 4;
        this.L = 0;
        this.M = 0;
        this.N = 0.0f;
        this.O = null;
    }

    public final Layout.Alignment d(boolean r4) {
        int r0 = this.d;
        if (r0 != 0) goto L16;
        int r1 = this.e;
        if (r1 != 0) goto L10;
        if (r4 == false) goto L9;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L9:
        return Layout.Alignment.ALIGN_NORMAL;
    L10:
        if (r1 != 3) goto L14;
        return Layout.Alignment.ALIGN_NORMAL;
    L14:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L16:
        if (r0 != 2) goto L29;
        int r2 = this.e;
        if (r2 != 0) goto L23;
        if (r4 == false) goto L22;
        return Layout.Alignment.ALIGN_NORMAL;
    L22:
        return Layout.Alignment.ALIGN_OPPOSITE;
    L23:
        if (r2 != 3) goto L27;
        return Layout.Alignment.ALIGN_OPPOSITE;
    L27:
        return Layout.Alignment.ALIGN_NORMAL;
    L29:
        if (r0 != 1) goto L33;
        return Layout.Alignment.ALIGN_CENTER;
    L33:
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof a) == true) goto L5;
        return false;
    L5:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L8;
        return false;
    L8:
        if (this.b != r6.b) goto L95;
        Integer r0 = r6.c;
        Integer r2 = this.c;
        if (r2 == null) goto L13;
        if (r0 == null) goto L13;
        boolean r1 = r2.equals(r0);
    L17:
        if (r1 == true) goto L19;
        return false;
    L19:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.f == r6.f) goto L23;
        return false;
    L23:
        if (this.g == r6.g) goto L25;
        return false;
    L25:
        if (this.h == r6.h) goto L27;
        return false;
    L27:
        if (this.i == r6.i) goto L29;
        return false;
    L29:
        if (this.j == r6.j) goto L31;
        return false;
    L31:
        if (com.lynx.tasm.utils.b.a(this.k, r6.k) == true) goto L33;
        return false;
    L33:
        if (com.lynx.tasm.utils.b.a(this.l, r6.l) == true) goto L35;
        return false;
    L35:
        if (com.lynx.tasm.utils.b.a(this.m, r6.m) == true) goto L37;
        return false;
    L37:
        if (com.lynx.tasm.utils.b.a(this.n, r6.n) == true) goto L39;
        return false;
    L39:
        if (Objects.equals(this.o, r6.o) == true) goto L41;
        return false;
    L41:
        if (this.p == r6.p) goto L43;
        return false;
    L43:
        if (this.q == r6.q) goto L45;
        return false;
    L45:
        if (this.s == r6.s) goto L47;
        return false;
    L47:
        if (this.r == r6.r) goto L49;
        return false;
    L49:
        if (this.t == r6.t) goto L51;
        return false;
    L51:
        if (TextUtils.equals(this.u, r6.u) == true) goto L53;
        return false;
    L53:
        if (Objects.equals(this.I, r6.I) == true) goto L55;
        return false;
    L55:
        if (this.J == r6.J) goto L57;
        return false;
    L57:
        if (this.e == r6.e) goto L59;
        return false;
    L59:
        if (this.L == r6.L) goto L61;
        return false;
    L61:
        if (this.K == r6.K) goto L63;
        return false;
    L63:
        if (this.M == r6.M) goto L65;
        return false;
    L65:
        if (com.lynx.tasm.utils.b.a(this.N, r6.N) == true) goto L67;
        return false;
    L67:
        if (this.H == r6.H) goto L69;
        return false;
    L69:
        if (this.v == r6.v) goto L71;
        return false;
    L71:
        if (com.lynx.tasm.utils.b.a(this.x, r6.x) == true) goto L73;
        return false;
    L73:
        if (com.lynx.tasm.utils.b.a(this.w, r6.w) == true) goto L75;
        return false;
    L75:
        if (com.lynx.tasm.utils.b.a(this.y, r6.y) == true) goto L77;
        return false;
    L77:
        if (Arrays.equals(this.z, r6.z) == true) goto L79;
        return false;
    L79:
        if (Objects.equals(this.A, r6.A) == true) goto L81;
        return false;
    L81:
        if (this.G == r6.G) goto L83;
        return false;
    L83:
        if (this.B == r6.B) goto L85;
        return false;
    L85:
        if (this.C == r6.C) goto L87;
        return false;
    L87:
        if (this.F == r6.F) goto L89;
        return false;
    L89:
        if (TextUtils.equals(this.D, r6.D) == true) goto L91;
        return false;
    L91:
        if (TextUtils.equals(this.E, r6.E) == false) goto L133;
        return true;
    L133:
        return false;
    L13:
        if (r2 != null) goto L16;
        if (r0 != null) goto L16;
        r1 = true;
    L16:
        r1 = false;
        goto L17
    L95:
        return false;
    }
}
