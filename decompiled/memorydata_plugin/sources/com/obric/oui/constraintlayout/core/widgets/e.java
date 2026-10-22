package com.obric.oui.constraintlayout.core.widgets;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public class e extends k {
    private int aC;
    private int aD;
    private int aE;
    private int aF;
    private int aG;
    private int aH;
    private float aI;
    private float aJ;
    private float aK;
    private float aL;
    private float aM;
    private float aN;
    private int aO;
    private int aP;
    private int aQ;
    private int aR;
    private int aS;
    private int aT;
    private int aU;
    private ArrayList<a> aV;
    private ConstraintWidget[] aW;
    private ConstraintWidget[] aX;
    private int[] aY;
    private ConstraintWidget[] aZ;
    private int ba;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13639a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f13640b;
        private int c;
        private ConstraintWidget d;
        private ConstraintAnchor e;
        private ConstraintAnchor f;
        private ConstraintAnchor g;
        private ConstraintAnchor h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;

        a(e r3, int r4, ConstraintAnchor r5, ConstraintAnchor r6, ConstraintAnchor r7, ConstraintAnchor r8, int r9) {
            this.f13640b = r3;
            this.c = 0;
            this.d = null;
            this.f13639a = 0;
            this.i = 0;
            this.j = 0;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
            this.r = 0;
            this.c = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r3.f();
            this.j = r3.b();
            this.k = r3.g();
            this.l = r3.c();
            this.r = r9;
        }

        static /* synthetic */ ConstraintWidget a(a r0) {
            return r0.d;
        }

        private void d() {
            this.m = 0;
            this.n = 0;
            this.d = null;
            this.f13639a = 0;
            int r1 = this.p;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L26;
            if ((this.o + r2) >= e.c(this.f13640b)) goto L33;
            ConstraintWidget r3 = e.d(this.f13640b)[this.o + r2];
            if (this.c != 0) goto L17;
            int r4 = r3.F();
            int r6 = e.a(this.f13640b);
            if (r3.B() != 8) goto L12;
            r6 = 0;
        L12:
            this.m += r4 + r6;
            int r5 = e.b(this.f13640b, r3, this.r);
            if (this.d != null) goto L15;
        L16:
            this.d = r3;
            this.f13639a = r5;
            this.n = r5;
        L25:
            r2 = r2 + 1;
            goto L3
        L15:
            if (this.f13639a >= r5) goto L25;
        L17:
            int r7 = e.a(this.f13640b, r3, this.r);
            int r8 = e.b(this.f13640b, r3, this.r);
            int r9 = e.b(this.f13640b);
            if (r3.B() != 8) goto L20;
            r9 = 0;
        L20:
            this.n += r8 + r9;
            if (this.d != null) goto L23;
        L24:
            this.d = r3;
            this.f13639a = r7;
            this.m = r7;
            goto L25
        L23:
            if (this.f13639a >= r7) goto L25;
        L33:
            return;
        }

        public void a() {
            this.f13639a = 0;
            this.d = null;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            this.p = 0;
            this.q = 0;
        }

        public void a(int r1) {
            this.o = r1;
        }

        public void a(int r1, ConstraintAnchor r2, ConstraintAnchor r3, ConstraintAnchor r4, ConstraintAnchor r5, int r6, int r7, int r8, int r9, int r10) {
            this.c = r1;
            this.e = r2;
            this.f = r3;
            this.g = r4;
            this.h = r5;
            this.i = r6;
            this.j = r7;
            this.k = r8;
            this.l = r9;
            this.r = r10;
        }

        public void a(ConstraintWidget r7) {
            int r2 = 0;
            if (this.c != 0) goto L16;
            int r0 = e.a(this.f13640b, r7, this.r);
            if (r7.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
            this.q++;
            r0 = 0;
        L7:
            int r3 = e.a(this.f13640b);
            if (r7.B() == 8) goto L11;
            r2 = r3;
        L11:
            this.m += r0 + r2;
            int r1 = e.b(this.f13640b, r7, this.r);
            if (this.d != null) goto L14;
        L15:
            this.d = r7;
            this.f13639a = r1;
            this.n = r1;
        L28:
            this.p++;
            return;
        L14:
            if (this.f13639a >= r1) goto L28;
        L16:
            int r4 = e.a(this.f13640b, r7, this.r);
            int r5 = e.b(this.f13640b, r7, this.r);
            if (r7.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
            this.q++;
            r5 = 0;
        L19:
            int r6 = e.b(this.f13640b);
            if (r7.B() == 8) goto L23;
            r2 = r6;
        L23:
            this.n += r5 + r2;
            if (this.d != null) goto L26;
        L27:
            this.d = r7;
            this.f13639a = r4;
            this.m = r4;
            goto L28
        L26:
            if (this.f13639a >= r4) goto L28;
            goto L27
        }

        public void a(boolean r17, int r18, boolean r19) {
            int r1 = this.p;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            if ((this.o + r3) >= e.c(this.f13640b)) goto L11;
            ConstraintWidget r4 = e.d(this.f13640b)[this.o + r3];
            if (r4 == null) goto L10;
            r4.Z();
        L10:
            r3 = r3 + 1;
        L11:
            if (r1 != 0) goto L13;
            return;
        L13:
            if (this.d == null) goto L223;
            if (r19 == false) goto L18;
            if (r18 != 0) goto L18;
            boolean r5 = true;
        L19:
            int r6 = 0;
            int r7 = -1;
            int r8 = -1;
        L20:
            if (r6 >= r1) goto L35;
            if (r17 == false) goto L23;
            int r9 = (r1 - 1) - r6;
        L25:
            if ((this.o + r9) >= e.c(this.f13640b)) goto L35;
            ConstraintWidget r10 = e.d(this.f13640b)[this.o + r9];
            if (r10 == null) goto L34;
            if (r10.B() != 0) goto L34;
            if (r7 != (-1)) goto L33;
            r7 = r6;
        L33:
            r8 = r6;
        L34:
            r6 = r6 + 1;
            goto L20
        L23:
            r9 = r6;
        L35:
            ConstraintWidget r11 = null;
            if (this.c != 0) goto L129;
            ConstraintWidget r12 = this.d;
            r12.w(e.e(this.f13640b));
            int r13 = this.j;
            if (r18 <= 0) goto L40;
            r13 = r13 + e.b(this.f13640b);
        L40:
            r12.C.a(this.f, r13);
            if (r19 == false) goto L43;
            r12.E.a(this.h, this.l);
        L43:
            if (r18 <= 0) goto L45;
            this.f.f13603a.E.a(r12.C, 0);
        L45:
            char r14 = 3;
            if (e.f(this.f13640b) == 3) goto L48;
        L61:
            ConstraintWidget r15 = r12;
        L62:
            int r16 = 0;
        L63:
            if (r16 >= r1) goto L224;
            if (r17 == false) goto L66;
            int r110 = (r1 - 1) - r16;
        L68:
            if ((this.o + r110) >= e.c(this.f13640b)) goto L225;
            ConstraintWidget r111 = e.d(this.f13640b)[this.o + r110];
            if (r111 != null) goto L73;
            r111 = r11;
            char r20 = r14;
        L128:
            r16 = r16 + 1;
            r14 = r20;
            r11 = r111;
            goto L63
        L73:
            if (r16 != 0) goto L75;
            r111.a(r111.B, this.e, this.i);
        L75:
            if (r110 != 0) goto L98;
            int r21 = e.g(this.f13640b);
            float r112 = e.h(this.f13640b);
            if (r17 == false) goto L80;
            r112 = 1.0f - r112;
        L80:
            if (this.o == 0) goto L82;
        L89:
            if (r19 == true) goto L91;
        L96:
            r111.v(r21);
            r111.a(r112);
            goto L98
        L91:
            if (e.k(this.f13640b) == (-1)) goto L96;
            r21 = e.k(this.f13640b);
            if (r17 == false) goto L95;
            float r113 = e.l(this.f13640b);
        L86:
            float r114 = 1.0f - r113;
        L88:
            r112 = r114;
            goto L96
        L95:
            r114 = e.l(this.f13640b);
            goto L88
        L82:
            if (e.i(this.f13640b) == (-1)) goto L89;
            r21 = e.i(this.f13640b);
            if (r17 == false) goto L87;
            r113 = e.j(this.f13640b);
            goto L86
        L87:
            r114 = e.j(this.f13640b);
        L98:
            if (r16 != (r1 - 1)) goto L100;
            r111.a(r111.D, this.g, this.k);
        L100:
            if (r11 == null) goto L107;
            r111.B.a(r11.D, e.a(this.f13640b));
            if (r16 != r7) goto L104;
            r111.B.b(this.i);
        L104:
            r11.D.a(r111.B, 0);
            if (r16 != (r8 + 1)) goto L107;
            r11.D.b(this.k);
        L107:
            if (r111 == r12) goto L127;
            r20 = 3;
            if (e.f(this.f13640b) == 3) goto L111;
        L116:
            int r22 = e.f(this.f13640b);
            if (r22 != 0) goto L119;
            ConstraintAnchor r23 = r111.C;
            ConstraintAnchor r115 = r12.C;
        L126:
            r23.a(r115, 0);
            goto L128
        L119:
            if (r22 == 1) goto L124;
            ConstraintAnchor r24 = r111.C;
            if (r5 == false) goto L123;
            r24.a(this.f, this.j);
            r111.E.a(this.h, this.l);
            goto L128
        L123:
            r24.a(r12.C, 0);
        L124:
            r23 = r111.E;
            r115 = r12.E;
            goto L126
        L111:
            if (r15.R() == false) goto L116;
            if (r111 == r15) goto L116;
            if (r111.R() == false) goto L116;
            r23 = r111.F;
            r115 = r15.F;
            goto L126
        L127:
            r20 = 3;
            goto L128
        L225:
            return;
        L66:
            r110 = r16;
            goto L68
        L224:
            return;
        L48:
            if (r12.R() == true) goto L61;
            int r116 = 0;
        L50:
            if (r116 >= r1) goto L61;
            if (r17 == false) goto L53;
            int r117 = (r1 - 1) - r116;
        L55:
            if ((this.o + r117) >= e.c(this.f13640b)) goto L61;
            r15 = e.d(this.f13640b)[this.o + r117];
            if (r15.R() == true) goto L62;
            r116 = r116 + 1;
            goto L50
        L53:
            r117 = r116;
            goto L55
        L129:
            ConstraintWidget r25 = this.d;
            r25.v(e.g(this.f13640b));
            int r26 = this.i;
            if (r18 <= 0) goto L132;
            r26 = r26 + e.a(this.f13640b);
        L132:
            if (r17 == false) goto L138;
            r25.D.a(this.g, r26);
            if (r19 == false) goto L136;
            r25.B.a(this.e, this.k);
        L136:
            if (r18 <= 0) goto L144;
            ConstraintAnchor r27 = this.g.f13603a.B;
            ConstraintAnchor r118 = r25.D;
        L143:
            r27.a(r118, 0);
        L144:
            int r28 = 0;
        L145:
            if (r28 >= r1) goto L226;
            if ((this.o + r28) >= e.c(this.f13640b)) goto L227;
            ConstraintWidget r119 = e.d(this.f13640b)[this.o + r28];
            if (r119 == null) goto L199;
            if (r28 != 0) goto L164;
            r119.a(r119.C, this.f, this.j);
            int r120 = e.e(this.f13640b);
            float r121 = e.m(this.f13640b);
            if (this.o == 0) goto L156;
        L158:
            if (r19 == true) goto L160;
        L162:
            r119.w(r120);
            r119.b(r121);
            goto L164
        L160:
            if (e.p(this.f13640b) == (-1)) goto L162;
            r120 = e.p(this.f13640b);
            r121 = e.q(this.f13640b);
            goto L162
        L156:
            if (e.n(this.f13640b) == (-1)) goto L158;
            r120 = e.n(this.f13640b);
            r121 = e.o(this.f13640b);
        L164:
            if (r28 != (r1 - 1)) goto L166;
            r119.a(r119.E, this.h, this.l);
        L166:
            if (r11 == null) goto L173;
            r119.C.a(r11.E, e.b(this.f13640b));
            if (r28 != r7) goto L170;
            r119.C.b(this.j);
        L170:
            r11.E.a(r119.C, 0);
            if (r28 != (r8 + 1)) goto L173;
            r11.E.b(this.l);
        L173:
            if (r119 == r25) goto L198;
            int r122 = e.r(this.f13640b);
            if (r17 == false) goto L186;
            if (r122 != 0) goto L178;
        L183:
            ConstraintAnchor r29 = r119.D;
            ConstraintAnchor r123 = r25.D;
        L184:
            r29.a(r123, 0);
            goto L198
        L178:
            if (r122 == 1) goto L182;
            if (r122 != 2) goto L198;
            r119.B.a(r25.B, 0);
            goto L183
        L182:
            r29 = r119.B;
            r123 = r25.B;
            goto L184
        L186:
            if (r122 == 0) goto L195;
            if (r122 == 1) goto L194;
            if (r122 != 2) goto L198;
            ConstraintAnchor r30 = r119.B;
            if (r5 == false) goto L193;
            r30.a(this.e, this.i);
            r119.D.a(this.g, this.k);
            goto L198
        L193:
            r30.a(r25.B, 0);
        L194:
            ConstraintAnchor r31 = r119.D;
            ConstraintAnchor r124 = r25.D;
        L196:
            r31.a(r124, 0);
            goto L198
        L195:
            r31 = r119.B;
            r124 = r25.B;
        L198:
            r11 = r119;
        L199:
            r28 = r28 + 1;
            goto L145
        L227:
            return;
        L226:
            return;
        L138:
            r25.B.a(this.e, r26);
            if (r19 == false) goto L141;
            r25.D.a(this.g, this.k);
        L141:
            if (r18 <= 0) goto L144;
            r27 = this.e.f13603a.D;
            r118 = r25.B;
        L18:
            r5 = false;
            goto L19
        }

        public int b() {
            if (this.c != 0) goto L7;
            return this.m - e.a(this.f13640b);
        L7:
            return this.m;
        }

        public void b(int r9) {
            int r0 = this.q;
            if (r0 != 0) goto L5;
            return;
        L5:
            int r1 = this.p;
            int r10 = r9 / r0;
            int r2 = 0;
        L6:
            if (r2 >= r1) goto L26;
            if ((this.o + r2) >= e.c(this.f13640b)) goto L26;
            ConstraintWidget r3 = e.d(this.f13640b)[this.o + r2];
            if (this.c != 0) goto L18;
            if (r3 == null) goto L25;
            if (r3.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
            if (r3.n != 0) goto L25;
            e r4 = this.f13640b;
            ConstraintWidget.DimensionBehaviour r5 = ConstraintWidget.DimensionBehaviour.FIXED;
            ConstraintWidget.DimensionBehaviour r6 = r3.ab();
            int r7 = r3.G();
            int r8 = r10;
        L24:
            r4.a(r3, r5, r8, r6, r7);
        L25:
            r2 = r2 + 1;
            goto L6
        L18:
            if (r3 == null) goto L25;
            if (r3.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
            if (r3.o != 0) goto L25;
            r4 = this.f13640b;
            r5 = r3.aa();
            r8 = r3.F();
            r6 = ConstraintWidget.DimensionBehaviour.FIXED;
            r7 = r10;
        L26:
            d();
        }

        public int c() {
            if (this.c != 1) goto L7;
            return this.n - e.b(this.f13640b);
        L7:
            return this.n;
        }
    }

    public e() {
        this.aC = -1;
        this.aD = -1;
        this.aE = -1;
        this.aF = -1;
        this.aG = -1;
        this.aH = -1;
        this.aI = 0.5f;
        this.aJ = 0.5f;
        this.aK = 0.5f;
        this.aL = 0.5f;
        this.aM = 0.5f;
        this.aN = 0.5f;
        this.aO = 0;
        this.aP = 0;
        this.aQ = 2;
        this.aR = 2;
        this.aS = 0;
        this.aT = -1;
        this.aU = 0;
        this.aV = new ArrayList();
        this.aW = null;
        this.aX = null;
        this.aY = null;
        this.ba = 0;
    }

    private int a(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
        if (r10.n != 0) goto L11;
        return 0;
    L11:
        if (r10.n != 2) goto L17;
        int r12 = (int) (r10.s * r11);
        if (r12 == r10.F()) goto L15;
        r10.e(true);
        a(r10, ConstraintWidget.DimensionBehaviour.FIXED, r12, r10.ab(), r10.G());
    L15:
        return r12;
    L17:
        if (r10.n != 1) goto L21;
        return r10.F();
    L21:
        if (r10.n != 3) goto L25;
        return (int) ((r10.G() * r10.P) + 0.5f);
    L25:
        return r10.F();
    }

    static /* synthetic */ int a(e r0) {
        return r0.aO;
    }

    static /* synthetic */ int a(e r0, ConstraintWidget r1, int r2) {
        return r0.a(r1, r2);
    }

    private void a(ConstraintWidget[] r30, int r31, int r32, int r33, int[] r34) {
        if (r31 != 0) goto L5;
        return;
    L5:
        this.aV.clear();
        a r10 = new a(this, r32, this.B, this.C, this.D, this.E, r33);
        this.aV.add(r10);
        int r0 = 0;
        int r1 = 0;
        int r11 = 0;
        if (r32 != 0) goto L32;
    L7:
        if (r11 >= r31) goto L57;
        ConstraintWidget r12 = r30[r11];
        int r13 = a(r12, r33);
        if (r12.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        r0 = r0 + 1;
    L11:
        int r14 = r0;
        if (r1 == r33) goto L16;
        if (((this.aO + r1) + r13) > r33) goto L16;
    L18:
        boolean r2 = false;
    L19:
        if (r2 == true) goto L26;
        if (r11 <= 0) goto L26;
        int r3 = this.aT;
        if (r3 <= 0) goto L26;
        if ((r11 % r3) != 0) goto L26;
        r2 = true;
    L26:
        if (r2 == false) goto L29;
        r10 = new a(this, r32, this.B, this.C, this.D, this.E, r33);
        r10.a(r11);
        this.aV.add(r10);
    L28:
        r1 = r13;
    L31:
        r10.a(r12);
        r11 = r11 + 1;
        r0 = r14;
        goto L7
    L29:
        if (r11 <= 0) goto L28;
        r1 = r1 + (this.aO + r13);
    L16:
        if (a.a(r10) == null) goto L18;
        r2 = true;
    L57:
        int r4 = this.aV.size();
        ConstraintAnchor r5 = this.B;
        ConstraintAnchor r6 = this.C;
        ConstraintAnchor r7 = this.D;
        ConstraintAnchor r8 = this.E;
        int r9 = f();
        int r15 = b();
        int r16 = g();
        int r17 = c();
        if (aa() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L60;
    L63:
        boolean r18 = true;
    L64:
        String r19 = "com.obric.memorydata.plugin";
        if (r0 <= 0) goto L74;
        if (r18 == false) goto L74;
        int r20 = 0;
    L68:
        if (r20 >= r4) goto L74;
        a r110 = (a) ZeusTransformUtils.preCheckCast(this.aV.get(r20), a.class, "com.obric.memorydata.plugin");
        if (r32 != 0) goto L72;
        int r111 = r110.b();
    L73:
        r110.b(r33 - r111);
        r20 = r20 + 1;
        goto L68
    L72:
        r111 = r110.c();
    L74:
        int r22 = r15;
        int r21 = r16;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r23 = r9;
        ConstraintAnchor r24 = r6;
        ConstraintAnchor r25 = r5;
        int r26 = r17;
    L75:
        if (r114 >= r4) goto L95;
        a r27 = (a) ZeusTransformUtils.preCheckCast(this.aV.get(r114), a.class, r19);
        if (r32 == 0) goto L79;
        int r35 = r4;
        ConstraintAnchor r36 = r25;
        int r28 = r112;
        int r29 = r113;
        int r37 = r114;
        String r38 = r19;
        if (r37 >= (r35 - 1)) goto L89;
        ConstraintAnchor r210 = a.a((a) ZeusTransformUtils.preCheckCast(this.aV.get(r37 + 1), a.class, r38)).B;
        int r211 = 0;
    L90:
        ConstraintAnchor r115 = a.a(r27).D;
        r27.a(r32, r36, r24, r210, r8, r23, r22, r211, r26, r33);
        r113 = r29 + r27.b();
        int r39 = Math.max(r28, r27.c());
        if (r37 <= 0) goto L93;
        r113 = r113 + this.aO;
    L93:
        r112 = r39;
        r23 = 0;
        r25 = r115;
    L94:
        r114 = r37 + 1;
        r4 = r35;
        r19 = r38;
        r7 = r210;
        r21 = r211;
        goto L75
    L89:
        r210 = this.D;
        r211 = g();
        goto L90
    L79:
        if (r114 >= (r4 - 1)) goto L81;
        ConstraintAnchor r40 = a.a((a) ZeusTransformUtils.preCheckCast(this.aV.get(r114 + 1), a.class, r19)).C;
        int r41 = 0;
    L82:
        ConstraintAnchor r116 = a.a(r27).E;
        r35 = r4;
        int r42 = r112;
        ConstraintAnchor r117 = r25;
        ConstraintAnchor r310 = r25;
        int r43 = r113;
        ConstraintAnchor r118 = r24;
        int r44 = r114;
        ConstraintAnchor r119 = r7;
        ConstraintAnchor r212 = r7;
        r38 = r19;
        r27.a(r32, r117, r118, r119, r40, r23, r22, r21, r41, r33);
        int r45 = Math.max(r43, r27.b());
        r112 = r42 + r27.c();
        if (r44 <= 0) goto L85;
        r112 = r112 + this.aP;
    L85:
        r113 = r45;
        r22 = 0;
        r25 = r310;
        r211 = r21;
        r37 = r44;
        r24 = r116;
        r210 = r212;
        int r213 = r41;
        r8 = r40;
        r26 = r213;
        goto L94
    L81:
        r40 = this.E;
        r41 = c();
        goto L82
    L95:
        r34[0] = r113;
        r34[1] = r112;
        return;
    L60:
        if (ab() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L63;
        r18 = false;
    L32:
        if (r11 >= r31) goto L57;
        ConstraintWidget r120 = r30[r11];
        int r121 = b(r120, r33);
        if (r120.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r0 = r0 + 1;
    L36:
        int r122 = r0;
        if (r1 == r33) goto L41;
        if (((this.aP + r1) + r121) > r33) goto L41;
    L43:
        boolean r46 = false;
    L44:
        if (r46 == true) goto L51;
        if (r11 <= 0) goto L51;
        int r47 = this.aT;
        if (r47 <= 0) goto L51;
        if ((r11 % r47) != 0) goto L51;
        r46 = true;
    L51:
        if (r46 == false) goto L54;
        r10 = new a(this, r32, this.B, this.C, this.D, this.E, r33);
        r10.a(r11);
        this.aV.add(r10);
    L53:
        r1 = r121;
    L56:
        r10.a(r120);
        r11 = r11 + 1;
        r0 = r122;
        goto L32
    L54:
        if (r11 <= 0) goto L53;
        r1 = r1 + (this.aP + r121);
    L41:
        if (a.a(r10) == null) goto L43;
        r46 = true;
        goto L44
    }

    private int b(ConstraintWidget r10, int r11) {
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L25;
        if (r10.o != 0) goto L11;
        return 0;
    L11:
        if (r10.o != 2) goto L17;
        int r12 = (int) (r10.v * r11);
        if (r12 == r10.G()) goto L15;
        r10.e(true);
        a(r10, r10.aa(), r10.F(), ConstraintWidget.DimensionBehaviour.FIXED, r12);
    L15:
        return r12;
    L17:
        if (r10.o != 1) goto L21;
        return r10.G();
    L21:
        if (r10.o != 3) goto L25;
        return (int) ((r10.F() * r10.P) + 0.5f);
    L25:
        return r10.G();
    }

    static /* synthetic */ int b(e r0) {
        return r0.aP;
    }

    static /* synthetic */ int b(e r0, ConstraintWidget r1, int r2) {
        return r0.b(r1, r2);
    }

    private void b(ConstraintWidget[] r30, int r31, int r32, int r33, int[] r34) {
        if (r31 != 0) goto L5;
        return;
    L5:
        this.aV.clear();
        a r10 = new a(this, r32, this.B, this.C, this.D, this.E, r33);
        this.aV.add(r10);
        int r0 = 0;
        int r1 = 0;
        int r2 = 0;
        int r11 = 0;
        if (r32 != 0) goto L31;
    L7:
        if (r11 >= r31) goto L55;
        r0 = r0 + 1;
        ConstraintWidget r12 = r30[r11];
        int r13 = a(r12, r33);
        if (r12.aa() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L11;
        r1 = r1 + 1;
    L11:
        int r14 = r1;
        if (r2 == r33) goto L16;
        if (((this.aO + r2) + r13) > r33) goto L16;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == true) goto L25;
        if (r11 <= 0) goto L25;
        int r4 = this.aT;
        if (r4 <= 0) goto L25;
        if (r0 <= r4) goto L25;
        r3 = true;
    L25:
        if (r3 == false) goto L27;
        r10 = new a(this, r32, this.B, this.C, this.D, this.E, r33);
        r10.a(r11);
        this.aV.add(r10);
        r2 = r13;
        r0 = 1;
    L30:
        r10.a(r12);
        r11 = r11 + 1;
        r1 = r14;
        goto L7
    L27:
        if (r11 <= 0) goto L29;
        r2 = r2 + (this.aO + r13);
        goto L30
    L29:
        r2 = r13;
    L16:
        if (a.a(r10) == null) goto L18;
        r3 = true;
    L55:
        int r5 = this.aV.size();
        ConstraintAnchor r6 = this.B;
        ConstraintAnchor r7 = this.C;
        ConstraintAnchor r8 = this.D;
        ConstraintAnchor r9 = this.E;
        int r15 = f();
        int r16 = b();
        int r17 = g();
        int r18 = c();
        if (aa() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L58;
    L61:
        boolean r19 = true;
    L62:
        String r110 = "com.obric.memorydata.plugin";
        if (r1 <= 0) goto L72;
        if (r19 == false) goto L72;
        int r20 = 0;
    L66:
        if (r20 >= r5) goto L72;
        a r111 = (a) ZeusTransformUtils.preCheckCast(this.aV.get(r20), a.class, "com.obric.memorydata.plugin");
        if (r32 != 0) goto L70;
        int r112 = r111.b();
    L71:
        r111.b(r33 - r112);
        r20 = r20 + 1;
        goto L66
    L70:
        r112 = r111.c();
    L72:
        int r22 = r16;
        int r21 = r17;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        int r23 = r15;
        ConstraintAnchor r24 = r7;
        ConstraintAnchor r25 = r6;
        int r26 = r18;
    L73:
        if (r115 >= r5) goto L93;
        a r27 = (a) ZeusTransformUtils.preCheckCast(this.aV.get(r115), a.class, r110);
        if (r32 == 0) goto L77;
        int r35 = r5;
        ConstraintAnchor r36 = r25;
        int r28 = r113;
        int r29 = r114;
        int r37 = r115;
        String r38 = r110;
        if (r37 >= (r35 - 1)) goto L87;
        ConstraintAnchor r210 = a.a((a) ZeusTransformUtils.preCheckCast(this.aV.get(r37 + 1), a.class, r38)).B;
        int r211 = 0;
    L88:
        ConstraintAnchor r116 = a.a(r27).D;
        r27.a(r32, r36, r24, r210, r9, r23, r22, r211, r26, r33);
        r114 = r29 + r27.b();
        int r39 = Math.max(r28, r27.c());
        if (r37 <= 0) goto L91;
        r114 = r114 + this.aO;
    L91:
        r113 = r39;
        r23 = 0;
        r25 = r116;
    L92:
        r115 = r37 + 1;
        r5 = r35;
        r110 = r38;
        r8 = r210;
        r21 = r211;
        goto L73
    L87:
        r210 = this.D;
        r211 = g();
        goto L88
    L77:
        if (r115 >= (r5 - 1)) goto L79;
        ConstraintAnchor r40 = a.a((a) ZeusTransformUtils.preCheckCast(this.aV.get(r115 + 1), a.class, r110)).C;
        int r41 = 0;
    L80:
        ConstraintAnchor r117 = a.a(r27).E;
        r35 = r5;
        int r42 = r113;
        ConstraintAnchor r118 = r25;
        ConstraintAnchor r310 = r25;
        int r43 = r114;
        ConstraintAnchor r119 = r24;
        int r44 = r115;
        ConstraintAnchor r120 = r8;
        ConstraintAnchor r212 = r8;
        r38 = r110;
        r27.a(r32, r118, r119, r120, r40, r23, r22, r21, r41, r33);
        int r45 = Math.max(r43, r27.b());
        r113 = r42 + r27.c();
        if (r44 <= 0) goto L83;
        r113 = r113 + this.aP;
    L83:
        r114 = r45;
        r22 = 0;
        r25 = r310;
        r211 = r21;
        r37 = r44;
        r24 = r117;
        r210 = r212;
        int r213 = r41;
        r9 = r40;
        r26 = r213;
        goto L92
    L79:
        r40 = this.E;
        r41 = c();
        goto L80
    L93:
        r34[0] = r114;
        r34[1] = r113;
        return;
    L58:
        if (ab() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L61;
        r19 = false;
    L31:
        if (r11 >= r31) goto L55;
        r0 = r0 + 1;
        ConstraintWidget r121 = r30[r11];
        int r122 = b(r121, r33);
        if (r121.ab() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L35;
        r1 = r1 + 1;
    L35:
        int r123 = r1;
        if (r2 == r33) goto L40;
        if (((this.aP + r2) + r122) > r33) goto L40;
    L42:
        boolean r46 = false;
    L43:
        if (r46 == true) goto L49;
        if (r11 <= 0) goto L49;
        int r47 = this.aT;
        if (r47 <= 0) goto L49;
        if (r0 <= r47) goto L49;
        r46 = true;
    L49:
        if (r46 == false) goto L51;
        r10 = new a(this, r32, this.B, this.C, this.D, this.E, r33);
        r10.a(r11);
        this.aV.add(r10);
        r2 = r122;
        r0 = 1;
    L54:
        r10.a(r121);
        r11 = r11 + 1;
        r1 = r123;
        goto L31
    L51:
        if (r11 <= 0) goto L53;
        r2 = r2 + (this.aP + r122);
        goto L54
    L53:
        r2 = r122;
    L40:
        if (a.a(r10) == null) goto L42;
        r46 = true;
        goto L43
    }

    static /* synthetic */ int c(e r0) {
        return r0.ba;
    }

    private void c(ConstraintWidget[] r23, int r24, int r25, int r26, int[] r27) {
        if (r24 != 0) goto L6;
        return;
    L6:
        if (this.aV.size() != 0) goto L8;
        a r11 = new a(this, r25, this.B, this.C, this.D, this.E, r26);
        this.aV.add(r11);
    L9:
        int r0 = 0;
    L10:
        if (r0 >= r24) goto L12;
        r11.a(r23[r0]);
        r0 = r0 + 1;
        goto L10
    L12:
        r27[0] = r11.b();
        r27[1] = r11.c();
        return;
    L8:
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.aV.get(0), a.class, "com.obric.memorydata.plugin");
        r1.a();
        r11 = r1;
        r11.a(r25, this.B, this.C, this.D, this.E, f(), b(), g(), c(), r26);
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x0119 -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x011b -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x0121 -> B:40:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x0123 -> B:40:0x0061). Please report as a decompilation issue!!! */
    private void d(ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        int r6 = this.aT;
        if (r19 != 0) goto L18;
        if (r6 > 0) goto L17;
        r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L6:
        if (r7 >= r18) goto L17;
        if (r7 <= 0) goto L9;
        r8 = r8 + this.aO;
    L9:
        ConstraintWidget r9 = r17[r7];
        if (r9 == null) goto L16;
        r8 = r8 + a(r9, r20);
        if (r8 > r20) goto L17;
        r6 = r6 + 1;
    L16:
        r7 = r7 + 1;
    L17:
        int r10 = r6;
        r6 = 0;
    L33:
        if (this.aY != null) goto L36;
        this.aY = new int[2];
    L36:
        if (r6 != 0) goto L38;
        if (r19 != 1) goto L38;
    L40:
        boolean r11 = true;
    L42:
        if (r11 == true) goto L109;
        if (r19 != 0) goto L45;
        r6 = (int) Math.ceil(r18 / r10);
    L46:
        ConstraintWidget[] r12 = this.aX;
        if (r12 != null) goto L49;
    L52:
        this.aX = new ConstraintWidget[r10];
    L53:
        ConstraintWidget[] r13 = this.aW;
        if (r13 != null) goto L56;
    L59:
        this.aW = new ConstraintWidget[r6];
    L60:
        int r14 = 0;
    L61:
        if (r14 >= r10) goto L85;
        int r15 = 0;
    L63:
        if (r15 >= r6) goto L84;
        int r16 = (r15 * r10) + r14;
        if (r19 != 1) goto L68;
        r16 = (r14 * r6) + r15;
    L68:
        if (r16 >= r17.length) goto L83;
        ConstraintWidget r110 = r17[r16];
        if (r110 == null) goto L83;
        int r111 = a(r110, r20);
        ConstraintWidget[] r112 = this.aX;
        if (r112[r14] != null) goto L76;
    L77:
        this.aX[r14] = r110;
    L78:
        int r113 = b(r110, r20);
        ConstraintWidget[] r114 = this.aW;
        if (r114[r15] != null) goto L81;
    L82:
        this.aW[r15] = r110;
        goto L83
    L81:
        if (r114[r15].G() >= r113) goto L83;
    L76:
        if (r112[r14].F() >= r111) goto L78;
    L83:
        r15 = r15 + 1;
        goto L63
    L84:
        r14 = r14 + 1;
        goto L61
    L85:
        int r115 = 0;
        int r116 = 0;
    L86:
        if (r115 >= r10) goto L93;
        ConstraintWidget r117 = this.aX[r115];
        if (r117 == null) goto L92;
        if (r115 <= 0) goto L91;
        r116 = r116 + this.aO;
    L91:
        r116 = r116 + a(r117, r20);
    L92:
        r115 = r115 + 1;
        goto L86
    L93:
        int r118 = 0;
        int r119 = 0;
    L94:
        if (r118 >= r6) goto L101;
        ConstraintWidget r120 = this.aW[r118];
        if (r120 == null) goto L100;
        if (r118 <= 0) goto L99;
        r119 = r119 + this.aP;
    L99:
        r119 = r119 + b(r120, r20);
    L100:
        r118 = r118 + 1;
        goto L94
    L101:
        r21[0] = r116;
        r21[1] = r119;
        if (r19 == 0) goto L103;
        if (r119 <= r20) goto L40;
        if (r6 <= 1) goto L40;
        r6 = r6 - 1;
        goto L42
    L103:
        if (r116 <= r20) goto L40;
        if (r10 <= 1) goto L40;
        r10 = r10 - 1;
        goto L42
    L56:
        if (r13.length < r6) goto L59;
        Arrays.fill(r13, null);
        goto L60
    L49:
        if (r12.length < r10) goto L52;
        Arrays.fill(r12, null);
        goto L53
    L45:
        r10 = (int) Math.ceil(r18 / r6);
        goto L46
    L109:
        int[] r0 = this.aY;
        r0[0] = r10;
        r0[1] = r6;
        return;
    L38:
        if (r10 != 0) goto L41;
        if (r19 == 0) goto L40;
    L41:
        r11 = false;
        goto L42
    L18:
        if (r6 > 0) goto L31;
        r6 = 0;
        int r22 = 0;
        int r23 = 0;
    L20:
        if (r22 >= r18) goto L31;
        if (r22 <= 0) goto L23;
        r23 = r23 + this.aP;
    L23:
        ConstraintWidget r24 = r17[r22];
        if (r24 == null) goto L30;
        r23 = r23 + b(r24, r20);
        if (r23 > r20) goto L31;
        r6 = r6 + 1;
    L30:
        r22 = r22 + 1;
    L31:
        r10 = 0;
        goto L33
    }

    static /* synthetic */ ConstraintWidget[] d(e r0) {
        return r0.aZ;
    }

    static /* synthetic */ int e(e r0) {
        return r0.aD;
    }

    static /* synthetic */ int f(e r0) {
        return r0.aR;
    }

    static /* synthetic */ int g(e r0) {
        return r0.aC;
    }

    static /* synthetic */ float h(e r0) {
        return r0.aI;
    }

    private void h(boolean r12) {
        if (this.aY != null) goto L5;
        return;
    L5:
        if (this.aX != null) goto L7;
        return;
    L7:
        if (this.aW == null) goto L91;
        int r1 = 0;
    L11:
        if (r1 >= this.ba) goto L13;
        this.aZ[r1].Z();
        r1 = r1 + 1;
        goto L11
    L13:
        int[] r2 = this.aY;
        int r3 = r2[0];
        int r4 = r2[1];
        ConstraintWidget r5 = null;
        float r6 = this.aI;
        int r7 = 0;
    L15:
        if (r7 >= r3) goto L34;
        if (r12 == false) goto L18;
        int r8 = (r3 - r7) - 1;
        float r9 = 1.0f - this.aI;
    L19:
        ConstraintWidget r10 = this.aX[r8];
        if (r10 == null) goto L33;
        if (r10.B() == 8) goto L33;
        if (r7 != 0) goto L27;
        r10.a(r10.B, this.B, f());
        r10.v(this.aC);
        r10.a(r9);
    L27:
        if (r7 != (r3 - 1)) goto L29;
        r10.a(r10.D, this.D, g());
    L29:
        if (r7 <= 0) goto L32;
        if (r5 == null) goto L32;
        r10.a(r10.B, r5.D, this.aO);
        r5.a(r5.D, r10.B, 0);
    L32:
        r5 = r10;
    L33:
        r7 = r7 + 1;
        r6 = r9;
        goto L15
    L18:
        r9 = r6;
        r8 = r7;
        goto L19
    L34:
        int r13 = 0;
    L35:
        if (r13 >= r4) goto L51;
        ConstraintWidget r11 = this.aW[r13];
        if (r11 == null) goto L50;
        if (r11.B() == 8) goto L50;
        if (r13 != 0) goto L44;
        r11.a(r11.C, this.C, b());
        r11.w(this.aD);
        r11.b(this.aJ);
    L44:
        if (r13 != (r4 - 1)) goto L46;
        r11.a(r11.E, this.E, c());
    L46:
        if (r13 <= 0) goto L49;
        if (r5 == null) goto L49;
        r11.a(r11.C, r5.E, this.aP);
        r5.a(r5.E, r11.C, 0);
    L49:
        r5 = r11;
    L50:
        r13 = r13 + 1;
        goto L35
    L51:
        int r14 = 0;
    L52:
        if (r14 >= r3) goto L92;
        int r15 = 0;
    L54:
        if (r15 >= r4) goto L72;
        int r16 = (r15 * r3) + r14;
        if (this.aU != 1) goto L58;
        r16 = (r14 * r4) + r15;
    L58:
        ConstraintWidget[] r17 = this.aZ;
        if (r16 >= r17.length) goto L71;
        ConstraintWidget r18 = r17[r16];
        if (r18 == null) goto L71;
        if (r18.B() == 8) goto L71;
        ConstraintWidget r19 = this.aX[r14];
        ConstraintWidget r20 = this.aW[r15];
        if (r18 == r19) goto L69;
        r18.a(r18.B, r19.B, 0);
        r18.a(r18.D, r19.D, 0);
    L69:
        if (r18 == r20) goto L71;
        r18.a(r18.C, r20.C, 0);
        r18.a(r18.E, r20.E, 0);
    L71:
        r15 = r15 + 1;
        goto L54
    L72:
        r14 = r14 + 1;
        goto L52
    L92:
        return;
    }

    static /* synthetic */ int i(e r0) {
        return r0.aE;
    }

    static /* synthetic */ float j(e r0) {
        return r0.aK;
    }

    static /* synthetic */ int k(e r0) {
        return r0.aG;
    }

    static /* synthetic */ float l(e r0) {
        return r0.aM;
    }

    static /* synthetic */ float m(e r0) {
        return r0.aJ;
    }

    static /* synthetic */ int n(e r0) {
        return r0.aF;
    }

    static /* synthetic */ float o(e r0) {
        return r0.aL;
    }

    static /* synthetic */ int p(e r0) {
        return r0.aH;
    }

    static /* synthetic */ float q(e r0) {
        return r0.aN;
    }

    static /* synthetic */ int r(e r0) {
        return r0.aQ;
    }

    public void A(int r1) {
        this.aF = r1;
    }

    public void B(int r1) {
        this.aG = r1;
    }

    public void C(int r1) {
        this.aH = r1;
    }

    public void D(int r1) {
        this.aC = r1;
    }

    public void E(int r1) {
        this.aD = r1;
    }

    public void F(int r1) {
        this.aQ = r1;
    }

    public void G(int r1) {
        this.aR = r1;
    }

    public void H(int r1) {
        this.aS = r1;
    }

    public void I(int r1) {
        this.aO = r1;
    }

    public void J(int r1) {
        this.aP = r1;
    }

    public void K(int r1) {
        this.aT = r1;
    }

    public void a(int r1) {
        this.aU = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(com.obric.oui.constraintlayout.core.d r7, boolean r8) {
        super.a(r7, r8);
        if (A() != null) goto L5;
    L7:
        boolean r9 = false;
    L8:
        int r2 = this.aS;
        if (r2 == 0) goto L32;
        if (r2 != 1) goto L12;
        int r3 = this.aV.size();
        int r4 = 0;
    L25:
        if (r4 >= r3) goto L34;
        a r5 = (a) ZeusTransformUtils.preCheckCast(this.aV.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r4 != (r3 - 1)) goto L29;
        boolean r6 = true;
    L30:
        r5.a(r9, r4, r6);
        r4 = r4 + 1;
        goto L25
    L29:
        r6 = false;
    L34:
        g(false);
        return;
    L12:
        if (r2 != 2) goto L14;
        h(r9);
        goto L34
    L14:
        if (r2 != 3) goto L34;
        int r10 = this.aV.size();
        int r11 = 0;
    L17:
        if (r11 >= r10) goto L34;
        a r12 = (a) ZeusTransformUtils.preCheckCast(this.aV.get(r11), a.class, "com.obric.memorydata.plugin");
        if (r11 != (r10 - 1)) goto L21;
        boolean r13 = true;
    L22:
        r12.a(r9, r11, r13);
        r11 = r11 + 1;
        goto L17
    L21:
        r13 = false;
        goto L22
    L32:
        if (this.aV.size() <= 0) goto L34;
        ((a) ZeusTransformUtils.preCheckCast(this.aV.get(0), a.class, "com.obric.memorydata.plugin")).a(r9, 0, true);
        goto L34
    L5:
        if (((d) ZeusTransformUtils.preCheckCast(A(), d.class, "com.obric.memorydata.plugin")).ag() == false) goto L7;
        r9 = true;
        goto L8
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.h, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public void a(ConstraintWidget r2, HashMap<ConstraintWidget, ConstraintWidget> r3) {
        super.a(r2, r3);
        e r4 = (e) ZeusTransformUtils.preCheckCast(r2, e.class, "com.obric.memorydata.plugin");
        this.aC = r4.aC;
        this.aD = r4.aD;
        this.aE = r4.aE;
        this.aF = r4.aF;
        this.aG = r4.aG;
        this.aH = r4.aH;
        this.aI = r4.aI;
        this.aJ = r4.aJ;
        this.aK = r4.aK;
        this.aL = r4.aL;
        this.aM = r4.aM;
        this.aN = r4.aN;
        this.aO = r4.aO;
        this.aP = r4.aP;
        this.aQ = r4.aQ;
        this.aR = r4.aR;
        this.aS = r4.aS;
        this.aT = r4.aT;
        this.aU = r4.aU;
    }

    public void b(int r1) {
        this.aE = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.k
    public void b(int r19, int r20, int r21, int r22) {
        if (this.aA > 0) goto L5;
    L8:
        int r12 = f();
        int r13 = g();
        int r14 = b();
        int r15 = c();
        int[] r5 = new int[2];
        int r1 = (r20 - r12) - r13;
        int r2 = this.aU;
        if (r2 != 1) goto L11;
        r1 = (r22 - r14) - r15;
    L11:
        int r16 = r1;
        if (r2 != 0) goto L20;
        if (this.aC != (-1)) goto L17;
        this.aC = 0;
    L17:
        if (this.aD == (-1)) goto L24;
    L25:
        ConstraintWidget[] r3 = this.az;
        int r4 = 0;
        int r6 = 0;
    L27:
        if (r4 >= this.aA) goto L32;
        if (this.az[r4].B() != 8) goto L31;
        r6 = r6 + 1;
    L31:
        r4 = r4 + 1;
        goto L27
    L32:
        int r7 = this.aA;
        if (r6 <= 0) goto L42;
        r3 = new ConstraintWidget[this.aA - r6];
        int r8 = 0;
        int r9 = 0;
    L36:
        if (r8 >= this.aA) goto L41;
        ConstraintWidget r11 = this.az[r8];
        if (r11.B() == 8) goto L40;
        r3[r9] = r11;
        r9 = r9 + 1;
    L40:
        r8 = r8 + 1;
        goto L36
    L41:
        r7 = r9;
    L42:
        this.aZ = r3;
        this.ba = r7;
        int r0 = this.aS;
        if (r0 != 0) goto L45;
        boolean r17 = true;
        c(r3, r7, this.aU, r16, r5);
    L56:
        int r10 = (r5[0] + r12) + r13;
        int r18 = (r5[r17 ? 1 : 0] + r14) + r15;
        if (r19 != 1073741824) goto L59;
        r10 = r20;
    L64:
        if (r21 != 1073741824) goto L66;
        r18 = r22;
    L71:
        h(r10, r18);
        q(r10);
        r(r18);
        if (this.aA > 0) goto L75;
        r17 = false;
    L75:
        g(r17);
        return;
    L66:
        if (r21 != Integer.MIN_VALUE) goto L68;
        r18 = Math.min(r18, r22);
        goto L71
    L68:
        if (r21 == 0) goto L71;
        r18 = 0;
        goto L71
    L59:
        if (r19 != Integer.MIN_VALUE) goto L61;
        r10 = Math.min(r10, r20);
        goto L64
    L61:
        if (r19 == 0) goto L64;
        r10 = 0;
        goto L64
    L45:
        if (r0 != 1) goto L47;
        r17 = true;
        a(r3, r7, this.aU, r16, r5);
        goto L56
    L47:
        if (r0 != 2) goto L49;
        r17 = true;
        d(r3, r7, this.aU, r16, r5);
        goto L56
    L49:
        if (r0 == 3) goto L52;
        r17 = true;
        goto L56
    L52:
        r17 = true;
        b(r3, r7, this.aU, r16, r5);
    L24:
        this.aD = 0;
        goto L25
    L20:
        if (this.aC != (-1)) goto L23;
        this.aC = 0;
    L23:
        if (this.aD != (-1)) goto L25;
    L5:
        if (ah() == true) goto L8;
        h(0, 0);
        g(false);
    }

    public void e(float r1) {
        this.aI = r1;
    }

    public void f(float r1) {
        this.aJ = r1;
    }

    public void g(float r1) {
        this.aK = r1;
    }

    public void h(float r1) {
        this.aL = r1;
    }

    public void i(float r1) {
        this.aM = r1;
    }

    public void j(float r1) {
        this.aN = r1;
    }
}
