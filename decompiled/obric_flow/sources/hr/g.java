package hr;

import com.google.common.reflect.w;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor$Type;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import com.obric.oui.constraintlayout.core.widgets.analyzer.q;
import com.obric.oui.constraintlayout.core.widgets.analyzer.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends f {
    public final fr.c A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public b[] F0;
    public b[] G0;
    public int H0;
    public boolean I0;
    public boolean J0;
    public WeakReference K0;
    public WeakReference L0;
    public WeakReference M0;
    public WeakReference N0;
    public final HashSet O0;
    public final com.obric.oui.constraintlayout.core.widgets.analyzer.b P0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public ArrayList f17432u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final w f17433v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final com.obric.oui.constraintlayout.core.widgets.analyzer.f f17434w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f17435x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.c f17436y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f17437z0;

    public g() {
        this.f17432u0 = new ArrayList();
        this.f17433v0 = new w(this);
        com.obric.oui.constraintlayout.core.widgets.analyzer.f r5 = new com.obric.oui.constraintlayout.core.widgets.analyzer.f();
        r5.f12567a = true;
        r5.f12568b = true;
        r5.e = new ArrayList();
        new ArrayList();
        r5.g = null;
        r5.f12570h = new com.obric.oui.constraintlayout.core.widgets.analyzer.b();
        r5.f = new ArrayList();
        r5.f12569c = this;
        r5.d = this;
        this.f17434w0 = r5;
        this.f17436y0 = null;
        this.f17437z0 = false;
        this.A0 = new fr.c();
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = new b[4];
        this.G0 = new b[4];
        this.H0 = 257;
        this.I0 = false;
        this.J0 = false;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = new HashSet();
        this.P0 = new com.obric.oui.constraintlayout.core.widgets.analyzer.b();
    }

    public static void W(f r10, com.obric.oui.constraintlayout.core.widgets.analyzer.c r11, com.obric.oui.constraintlayout.core.widgets.analyzer.b r12) {
        if (r11 != null) goto L5;
        return;
    L5:
        if (r10.i0 != 8) goto L7;
    L86:
        r12.e = 0;
        r12.f = 0;
        return;
    L7:
        if ((r10 instanceof k) == true) goto L86;
        if ((r10 instanceof a) == true) goto L86;
        ConstraintWidget$DimensionBehaviour[] r5 = r10.U;
        r12.f12559a = r5[0];
        r12.f12560b = r5[1];
        r12.f12561c = r10.r();
        r12.d = r10.l();
        r12.f12563i = false;
        r12.f12564j = 0;
        ConstraintWidget$DimensionBehaviour r13 = r12.f12559a;
        ConstraintWidget$DimensionBehaviour r14 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 != r14) goto L14;
        boolean r15 = true;
    L16:
        if (r12.f12560b != r14) goto L18;
        boolean r16 = true;
    L20:
        if (r15 == true) goto L22;
    L24:
        boolean r17 = false;
    L25:
        if (r16 == true) goto L27;
    L29:
        boolean r18 = false;
    L30:
        if (r15 == true) goto L32;
    L42:
        if (r16 == false) goto L55;
        if (r10.u(1) == false) goto L55;
        if (r10.s != 0) goto L55;
        if (r18 == true) goto L55;
        r12.f12560b = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r15 == true) goto L51;
    L53:
        r16 = false;
        goto L55
    L51:
        if (r10.f17421r != 0) goto L53;
        r12.f12560b = ConstraintWidget$DimensionBehaviour.FIXED;
    L55:
        if (r10.B() == false) goto L58;
        r12.f12559a = ConstraintWidget$DimensionBehaviour.FIXED;
        r15 = false;
    L58:
        if (r10.C() == false) goto L60;
        r12.f12560b = ConstraintWidget$DimensionBehaviour.FIXED;
        r16 = false;
    L60:
        int[] r19 = r10.f17424t;
        if (r17 == true) goto L63;
    L71:
        if (r18 == true) goto L73;
    L84:
        ((com.obric.oui.constraintlayout.widget.b) r11).b(r10, r12);
        r10.P(r12.e);
        r10.M(r12.f);
        r10.E = r12.f12562h;
        r10.J(r12.g);
        r12.f12564j = 0;
        return;
    L73:
        if (r19[1] != 4) goto L75;
        r12.f12560b = ConstraintWidget$DimensionBehaviour.FIXED;
        goto L84
    L75:
        if (r15 == true) goto L84;
        ConstraintWidget$DimensionBehaviour r20 = r12.f12559a;
        ConstraintWidget$DimensionBehaviour r21 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r20 != r21) goto L79;
        int r22 = r12.f12561c;
    L80:
        r12.f12560b = r21;
        if (r10.Z != (-1)) goto L83;
        r12.d = (int) (r22 / r10.Y);
        goto L84
    L83:
        r12.d = (int) (r10.Y * r22);
        goto L84
    L79:
        r12.f12560b = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        ((com.obric.oui.constraintlayout.widget.b) r11).b(r10, r12);
        r22 = r12.e;
        goto L80
    L63:
        if (r19[0] != 4) goto L65;
        r12.f12559a = ConstraintWidget$DimensionBehaviour.FIXED;
        goto L71
    L65:
        if (r16 == true) goto L71;
        ConstraintWidget$DimensionBehaviour r23 = r12.f12560b;
        ConstraintWidget$DimensionBehaviour r24 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (r23 != r24) goto L69;
        int r25 = r12.d;
    L70:
        r12.f12559a = r24;
        r12.f12561c = (int) (r10.Y * r25);
        goto L71
    L69:
        r12.f12559a = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        ((com.obric.oui.constraintlayout.widget.b) r11).b(r10, r12);
        r25 = r12.f;
        goto L70
    L32:
        if (r10.u(0) == false) goto L42;
        if (r10.f17421r != 0) goto L42;
        if (r17 == true) goto L42;
        r12.f12559a = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r16 == true) goto L39;
    L41:
        r15 = false;
        goto L42
    L39:
        if (r10.s != 0) goto L41;
        r12.f12559a = ConstraintWidget$DimensionBehaviour.FIXED;
        goto L41
    L27:
        if (r10.Y <= 0.0f) goto L29;
        r18 = true;
        goto L30
    L22:
        if (r10.Y <= 0.0f) goto L24;
        r17 = true;
        goto L25
    L18:
        r16 = false;
        goto L20
    L14:
        r15 = false;
        goto L16
    }

    @Override // hr.f
    public final void D() {
        this.A0.t();
        this.B0 = 0;
        this.C0 = 0;
        this.f17432u0.clear();
        super.D();
    }

    @Override // hr.f
    public final void G(w r5) {
        super.G(r5);
        int r10 = this.f17432u0.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ((f) this.f17432u0.get(r11)).G(r5);
        r11 = r11 + 1;
        goto L3
    }

    @Override // hr.f
    public final void Q(boolean r5, boolean r10) {
        super.Q(r5, r10);
        int r11 = this.f17432u0.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ((f) this.f17432u0.get(r12)).Q(r5, r10);
        r12 = r12 + 1;
        goto L3
    }

    public final void S(f r10, int r11) {
        if (r11 != 0) goto L8;
        int r12 = this.D0 + 1;
        b[] r5 = this.G0;
        if (r12 < r5.length) goto L7;
        this.G0 = (b[]) Arrays.copyOf(r5, r5.length * 2);
    L7:
        b[] r13 = this.G0;
        int r14 = this.D0;
        r13[r14] = new b(r10, 0, this.f17437z0);
        this.D0 = r14 + 1;
        return;
    L8:
        if (r11 != 1) goto L15;
        int r15 = this.E0 + 1;
        b[] r16 = this.F0;
        if (r15 < r16.length) goto L12;
        this.F0 = (b[]) Arrays.copyOf(r16, r16.length * 2);
    L12:
        b[] r17 = this.F0;
        int r18 = this.E0;
        r17[r18] = new b(r10, 1, this.f17437z0);
        this.E0 = r18 + 1;
        return;
    }

    public final void T(fr.c r13) {
        boolean r5 = X(64);
        b(r13, r5);
        int r10 = this.f17432u0.size();
        int r11 = 0;
        boolean r12 = false;
    L4:
        if (r11 >= r10) goto L9;
        f r14 = (f) this.f17432u0.get(r11);
        boolean[] r15 = r14.T;
        r15[0] = false;
        r15[1] = false;
        if ((r14 instanceof a) == false) goto L8;
        r12 = true;
    L8:
        r11 = r11 + 1;
        goto L4
    L9:
        if (r12 == false) goto L34;
        int r16 = 0;
    L11:
        if (r16 >= r10) goto L34;
        f r17 = (f) this.f17432u0.get(r16);
        if ((r17 instanceof a) == false) goto L33;
        a r18 = (a) r17;
        int r19 = 0;
    L16:
        if (r19 >= r18.f17463v0) goto L33;
        f r20 = r18.f17462u0[r19];
        if (r18.f17370x0 == false) goto L20;
    L22:
        int r21 = r18.f17369w0;
        if (r21 == 0) goto L31;
        if (r21 == 1) goto L31;
        if (r21 != 2) goto L29;
    L30:
        r20.T[1] = true;
    L32:
        r19 = r19 + 1;
        goto L16
    L29:
        if (r21 != 3) goto L32;
    L31:
        r20.T[0] = true;
        goto L32
    L20:
        if (r20.c() == true) goto L22;
    L33:
        r16 = r16 + 1;
    L34:
        HashSet r22 = this.O0;
        r22.clear();
        int r23 = 0;
    L35:
        if (r23 >= r10) goto L45;
        f r24 = (f) this.f17432u0.get(r23);
        r24.getClass();
        boolean r25 = r24 instanceof o;
        if (r25 == false) goto L39;
    L40:
        if (r25 == false) goto L42;
        r22.add(r24);
    L43:
        r23 = r23 + 1;
        goto L35
    L42:
        r24.b(r13, r5);
        goto L43
    L39:
        if ((r24 instanceof k) == false) goto L43;
    L45:
        if (r22.size() <= 0) goto L64;
        int r26 = r22.size();
        Iterator r27 = r22.iterator();
    L48:
        if (r27.hasNext() == false) goto L57;
        o r28 = (o) ((f) r27.next());
        int r29 = 0;
    L51:
        if (r29 >= r28.f17463v0) goto L48;
        if (r22.contains(r28.f17462u0[r29]) == true) goto L54;
        r29 = r29 + 1;
        goto L51
    L54:
        r28.b(r13, r5);
        r22.remove(r28);
    L57:
        if (r26 != r22.size()) goto L45;
        Iterator r30 = r22.iterator();
    L60:
        if (r30.hasNext() == false) goto L62;
        ((f) r30.next()).b(r13, r5);
        goto L60
    L62:
        r22.clear();
        goto L45
    L64:
        if (fr.c.f16984q == false) goto L82;
        HashSet r31 = new HashSet();
        int r32 = 0;
    L66:
        if (r32 >= r10) goto L75;
        f r33 = (f) this.f17432u0.get(r32);
        r33.getClass();
        if ((r33 instanceof o) == true) goto L73;
        if ((r33 instanceof k) == true) goto L73;
        r31.add(r33);
    L73:
        r32 = r32 + 1;
        goto L66
    L75:
        if (this.U[0] != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L77;
        int r110 = 0;
    L78:
        a(this, r13, r31, r110, false);
        Iterator r34 = r31.iterator();
    L80:
        if (r34.hasNext() == false) goto L104;
        f r35 = (f) r34.next();
        m.b(this, r13, r35);
        r35.b(r13, r5);
    L104:
        if (this.D0 <= 0) goto L107;
        m.a(this, r13, null, 0);
    L107:
        if (this.E0 <= 0) goto L144;
        m.a(this, r13, null, 1);
        return;
    L144:
        return;
    L77:
        r110 = 1;
        goto L78
    L82:
        int r36 = 0;
    L83:
        if (r36 >= r10) goto L104;
        f r37 = (f) this.f17432u0.get(r36);
        if ((r37 instanceof g) == false) goto L96;
        ConstraintWidget$DimensionBehaviour[] r38 = r37.U;
        ConstraintWidget$DimensionBehaviour r39 = r38[0];
        ConstraintWidget$DimensionBehaviour r40 = r38[1];
        ConstraintWidget$DimensionBehaviour r41 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r39 != r41) goto L89;
        r37.N(ConstraintWidget$DimensionBehaviour.FIXED);
    L89:
        if (r40 != r41) goto L91;
        r37.O(ConstraintWidget$DimensionBehaviour.FIXED);
    L91:
        r37.b(r13, r5);
        if (r39 != r41) goto L94;
        r37.N(r39);
    L94:
        if (r40 != r41) goto L102;
        r37.O(r40);
    L102:
        r36 = r36 + 1;
        goto L83
    L96:
        m.b(this, r13, r37);
        if ((r37 instanceof o) == true) goto L102;
        if ((r37 instanceof k) == true) goto L102;
        r37.b(r13, r5);
        goto L102
    }

    public final boolean U(boolean r12, int r13) {
        com.obric.oui.constraintlayout.core.widgets.analyzer.f r11 = this.f17434w0;
        g r5 = (g) r11.f12569c;
        boolean r10 = false;
        ConstraintWidget$DimensionBehaviour r14 = r5.k(0);
        ConstraintWidget$DimensionBehaviour r15 = r5.k(1);
        int r16 = r5.s();
        int r17 = r5.t();
        ArrayList r18 = (ArrayList) r11.e;
        if (r12 == false) goto L24;
        ConstraintWidget$DimensionBehaviour r19 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r14 == r19) goto L7;
        if (r15 != r19) goto L24;
    L7:
        Iterator r20 = r18.iterator();
    L9:
        if (r20.hasNext() == false) goto L15;
        s r21 = (s) r20.next();
        if (r21.f != r13) goto L9;
        if (r21.k() == true) goto L9;
        r12 = false;
    L15:
        if (r13 != 0) goto L20;
        if (r12 == false) goto L24;
        if (r14 != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L24;
        r5.N(ConstraintWidget$DimensionBehaviour.FIXED);
        r5.P(r11.d(r5, 0));
        r5.d.e.d(r5.r());
        goto L24
    L20:
        if (r12 == false) goto L24;
        if (r15 != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L24;
        r5.O(ConstraintWidget$DimensionBehaviour.FIXED);
        r5.M(r11.d(r5, 1));
        r5.e.e.d(r5.l());
    L24:
        if (r13 != 0) goto L31;
        ConstraintWidget$DimensionBehaviour r110 = r5.U[0];
        if (r110 != ConstraintWidget$DimensionBehaviour.FIXED) goto L28;
    L29:
        int r111 = r5.r() + r16;
        r5.d.f12596i.d(r111);
        r5.d.e.d(r111 - r16);
    L30:
        boolean r112 = true;
    L38:
        r11.g();
        Iterator r113 = r18.iterator();
    L40:
        if (r113.hasNext() == false) goto L50;
        s r22 = (s) r113.next();
        if (r22.f != r13) goto L40;
        if (r22.f12593b != r5) goto L49;
        if (r22.g == false) goto L40;
    L49:
        r22.e();
        goto L40
    L50:
        Iterator r114 = r18.iterator();
    L52:
        if (r114.hasNext() == false) goto L71;
        s r23 = (s) r114.next();
        if (r23.f != r13) goto L52;
        if (r112 == true) goto L61;
        if (r23.f12593b == r5) goto L52;
    L61:
        if (r23.f12595h.f12576j == false) goto L72;
        if (r23.f12596i.f12576j == false) goto L72;
        if ((r23 instanceof com.obric.oui.constraintlayout.core.widgets.analyzer.d) == true) goto L52;
        if (r23.e.f12576j == true) goto L52;
    L72:
        r5.N(r14);
        r5.O(r15);
        return r10;
    L71:
        r10 = true;
        goto L72
    L28:
        if (r110 == ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L29;
    L36:
        r112 = false;
        goto L38
    L31:
        ConstraintWidget$DimensionBehaviour r115 = r5.U[1];
        if (r115 != ConstraintWidget$DimensionBehaviour.FIXED) goto L34;
    L37:
        int r116 = r5.l() + r17;
        r5.e.f12596i.d(r116);
        r5.e.e.d(r116 - r17);
        goto L30
    L34:
        if (r115 != ConstraintWidget$DimensionBehaviour.MATCH_PARENT) goto L36;
        goto L36
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v53 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r24v10 */
    /* JADX WARN: Type inference failed for: r24v11 */
    /* JADX WARN: Type inference failed for: r24v12 */
    /* JADX WARN: Type inference failed for: r24v13 */
    /* JADX WARN: Type inference failed for: r24v14 */
    /* JADX WARN: Type inference failed for: r24v15 */
    /* JADX WARN: Type inference failed for: r24v16 */
    /* JADX WARN: Type inference failed for: r24v17 */
    /* JADX WARN: Type inference failed for: r24v18 */
    /* JADX WARN: Type inference failed for: r24v19 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v20 */
    /* JADX WARN: Type inference failed for: r24v21 */
    /* JADX WARN: Type inference failed for: r24v22 */
    /* JADX WARN: Type inference failed for: r24v23 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v30 */
    /* JADX WARN: Type inference failed for: r24v31 */
    /* JADX WARN: Type inference failed for: r24v32 */
    /* JADX WARN: Type inference failed for: r24v33 */
    /* JADX WARN: Type inference failed for: r24v34 */
    /* JADX WARN: Type inference failed for: r24v35 */
    /* JADX WARN: Type inference failed for: r24v36 */
    /* JADX WARN: Type inference failed for: r24v37 */
    /* JADX WARN: Type inference failed for: r24v38 */
    /* JADX WARN: Type inference failed for: r24v39 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARN: Type inference failed for: r24v40 */
    /* JADX WARN: Type inference failed for: r24v41 */
    /* JADX WARN: Type inference failed for: r24v42 */
    /* JADX WARN: Type inference failed for: r24v43 */
    /* JADX WARN: Type inference failed for: r24v5 */
    /* JADX WARN: Type inference failed for: r24v6 */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r29v0, types: [hr.f, hr.g] */
    public final void V() {
        this.f17395a0 = 0;
        this.f17397b0 = 0;
        this.I0 = false;
        this.J0 = false;
        int r5 = this.f17432u0.size();
        int r10 = Math.max(0, r());
        int r11 = Math.max(0, l());
        ConstraintWidget$DimensionBehaviour[] r12 = this.U;
        ConstraintWidget$DimensionBehaviour r13 = r12[1];
        ConstraintWidget$DimensionBehaviour r14 = r12[0];
        int r15 = this.f17435x0;
        d r16 = this.K;
        d r17 = this.J;
        if (r15 == 0) goto L5;
    L146:
        int r21 = r11;
        d r19 = r17;
    L147:
        fr.c r18 = this.A0;
        if (r5 <= 2) goto L153;
        ConstraintWidget$DimensionBehaviour r20 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r14 == r20) goto L155;
        if (r13 != r20) goto L153;
    L155:
        if (m.c(this.H0, 1024) == false) goto L153;
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r22 = this.f17436y0;
        ArrayList r110 = this.f17432u0;
        int r111 = r110.size();
        int r112 = 0;
    L157:
        if (r112 >= r111) goto L165;
        f r113 = (f) r110.get(r112);
        ConstraintWidget$DimensionBehaviour[] r114 = this.U;
        ConstraintWidget$DimensionBehaviour r23 = r114[0];
        ConstraintWidget$DimensionBehaviour r115 = r114[1];
        ConstraintWidget$DimensionBehaviour[] r24 = r113.U;
        d r25 = r16;
        if (com.obric.oui.constraintlayout.core.widgets.analyzer.i.h(r23, r115, r24[0], r24[1]) == false) goto L160;
        if ((r113 instanceof i) == true) goto L160;
        r112 = r112 + 1;
        r16 = r25;
    L160:
        int r26 = r10;
        int r27 = r5;
        ConstraintWidget$DimensionBehaviour r28 = r14;
        ConstraintWidget$DimensionBehaviour r29 = r13;
        fr.c r30 = r18;
    L364:
        ConstraintWidget$DimensionBehaviour r31 = r29;
        int r32 = r26;
        ConstraintWidget$DimensionBehaviour r33 = r28;
    L384:
        int r34 = r32;
        int r35 = r21;
        boolean r36 = false;
    L386:
        if (X(64) == false) goto L388;
    L391:
        boolean r37 = true;
    L392:
        r30.getClass();
        r30.f16988h = false;
        if (this.H0 == 0) goto L396;
        if (r37 == false) goto L396;
        char r38 = 1;
        r30.f16988h = true;
    L397:
        ArrayList r116 = this.f17432u0;
        ConstraintWidget$DimensionBehaviour[] r117 = this.U;
        ConstraintWidget$DimensionBehaviour r118 = r117[0];
        ConstraintWidget$DimensionBehaviour r119 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        if (r118 != r119) goto L400;
    L403:
        boolean r39 = true;
    L404:
        this.D0 = 0;
        this.E0 = 0;
        int r120 = r27;
        int r40 = 0;
    L405:
        if (r40 >= r120) goto L410;
        f r121 = (f) this.f17432u0.get(r40);
        if ((r121 instanceof g) == false) goto L409;
        ((g) r121).V();
    L409:
        r40 = r40 + 1;
        goto L405
    L410:
        boolean r41 = X(64);
        ?? r122 = r36;
        int r42 = 0;
        boolean r123 = true;
    L411:
        if (r123 == false) goto L525;
        int r124 = r42 + 1;
        r30.t();     // Catch: Exception -> L416
        this.D0 = 0;     // Catch: Exception -> L416
        this.E0 = 0;     // Catch: Exception -> L416
        h(r30);     // Catch: Exception -> L416
        int r43 = 0;
    L414:
        if (r43 >= r120) goto L418;
        ((f) this.f17432u0.get(r43)).h(r30);     // Catch: Exception -> L416
        r43 = r43 + 1;     // Catch: Exception -> L416
        goto L414
    L418:
        T(r30);     // Catch: Exception -> L416
        WeakReference r44 = this.K0;     // Catch: Exception -> L433
        if (r44 != null) goto L422;
    L435:
        ?? r210 = r122;
        d r211 = r25;
    L436:
        WeakReference r45 = this.M0;     // Catch: Exception -> L428
        if (r45 != null) goto L439;
    L441:
        WeakReference r46 = this.L0;     // Catch: Exception -> L428
        if (r46 != null) goto L444;
    L452:
        WeakReference r47 = this.N0;     // Catch: Exception -> L428
        if (r47 == null) goto L465;
        if (r47.get() == null) goto L465;
        d r48 = (d) this.N0.get();     // Catch: Exception -> L428
        fr.e r49 = r30.k(this.L);     // Catch: Exception -> L428
        fr.c r125 = this.A0;     // Catch: Exception -> L462
        r125.f(r49, r125.k(r48), 0, 5);     // Catch: Exception -> L462
        this.N0 = null;     // Catch: Exception -> L460
    L460:
        e = e;
        ?? r212 = r210;
    L430:
        r123 = true;
        ?? r213 = r212;
    L467:
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
        ?? r214 = r213;
    L468:
        boolean[] r50 = m.f17464a;
        if (r123 == false) goto L479;
        r50[2] = false;
        boolean r126 = X(64);
        R(r30, r126);
        int r127 = this.f17432u0.size();
        int r51 = 0;
        boolean r128 = false;
    L471:
        if (r51 >= r127) goto L478;
        int r215 = r127;
        f r129 = (f) this.f17432u0.get(r51);
        r129.R(r30, r126);
        boolean r216 = r126;
        boolean r217 = r128;
        if (r129.f17403h == (-1)) goto L475;
    L476:
        r217 = true;
    L477:
        r51 = r51 + 1;
        r127 = r215;
        r126 = r216;
        r128 = r217;
        goto L471
    L475:
        if (r129.f17405i == (-1)) goto L477;
    L478:
        boolean r218 = r128;
    L484:
        if (r39 == false) goto L500;
        if (r124 >= 8) goto L500;
        if (r50[2] == false) goto L500;
        int r52 = 0;
        int r130 = 0;
        int r131 = 0;
    L489:
        if (r52 >= r120) goto L491;
        f r132 = (f) this.f17432u0.get(r52);
        r131 = Math.max(r131, r132.r() + r132.f17395a0);
        r130 = Math.max(r130, r132.l() + r132.f17397b0);
        r52 = r52 + 1;
        goto L489
    L491:
        int r53 = Math.max(this.f17400d0, r131);
        int r54 = Math.max(this.f17401e0, r130);
        ConstraintWidget$DimensionBehaviour r133 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        r214 = r214;
        if (r33 != r133) goto L496;
        r214 = r214;
        if (r() >= r53) goto L496;
        P(r53);
        this.U[0] = r133;
        r214 = 1;
        r218 = true;
    L496:
        if (r31 != r133) goto L500;
        if (l() >= r54) goto L500;
        M(r54);
        this.U[1] = r133;
        r214 = 1;
        r218 = true;
    L500:
        int r55 = Math.max(this.f17400d0, r());
        ?? r219 = r214;
        if (r55 <= r()) goto L503;
        P(r55);
        this.U[0] = ConstraintWidget$DimensionBehaviour.FIXED;
        r219 = 1;
        r218 = true;
    L503:
        int r56 = Math.max(this.f17401e0, l());
        if (r56 <= l()) goto L506;
        M(r56);
        ?? r134 = 1;
        this.U[1] = ConstraintWidget$DimensionBehaviour.FIXED;
        ?? r220 = 1;
        r218 = true;
    L507:
        if (r220 != 0) goto L520;
        ConstraintWidget$DimensionBehaviour r57 = this.U[0];
        ConstraintWidget$DimensionBehaviour r135 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        r220 = r220;
        r220 = r220;
        if (r57 != r135) goto L515;
        if (r34 <= 0) goto L515;
        r220 = r220;
        if (r() <= r34) goto L515;
        this.I0 = r134;
        this.U[0] = ConstraintWidget$DimensionBehaviour.FIXED;
        P(r34);
        ?? r221 = r134;
        r218 = r221 == true ? 1 : 0;
        r220 = r221;
    L515:
        if (this.U[r134] != r135) goto L520;
        if (r35 <= 0) goto L520;
        if (l() <= r35) goto L520;
        this.J0 = r134;
        this.U[r134] = ConstraintWidget$DimensionBehaviour.FIXED;
        M(r35);
        int r58 = 8;
        ?? r136 = 1;
        r218 = true;
    L521:
        if (r124 <= r58) goto L523;
        r123 = false;
    L524:
        r42 = r124;
        r25 = r211;
        r122 = r136;
        goto L411
    L523:
        r123 = r218;
    L520:
        r136 = r220;
        r58 = 8;
        goto L521
    L506:
        r134 = 1;
        r220 = r219;
        goto L507
    L479:
        R(r30, r41);
        int r59 = 0;
    L480:
        if (r59 >= r120) goto L482;
        ((f) this.f17432u0.get(r59)).R(r30, r41);
        r59 = r59 + 1;
        goto L480
    L482:
        r218 = false;
    L462:
        e = e;
    L429:
        r212 = r210;
    L465:
        r30.p();     // Catch: Exception -> L460
        r123 = true;
        r214 = r210;
        goto L468
    L444:
        if (r46.get() == null) goto L452;
        d r60 = (d) this.L0.get();     // Catch: Exception -> L428
        d r61 = r19;
        fr.e r137 = r30.k(r61);     // Catch: Exception -> L450
        fr.c r138 = this.A0;     // Catch: Exception -> L450
        r19 = r61;
        r138.f(r138.k(r60), r137, 0, 5);     // Catch: Exception -> L428
        this.L0 = null;     // Catch: Exception -> L428
    L450:
        e = e;
        r19 = r61;
        goto L429
    L439:
        if (r45.get() == null) goto L441;
        d r62 = (d) this.M0.get();     // Catch: Exception -> L428
        fr.e r63 = r30.k(this.M);     // Catch: Exception -> L428
        fr.c r139 = this.A0;     // Catch: Exception -> L428
        r139.f(r63, r139.k(r62), 0, 5);     // Catch: Exception -> L428
        this.M0 = null;     // Catch: Exception -> L428
        goto L441
    L422:
        if (r44.get() == null) goto L435;
        d r64 = (d) this.K0.get();     // Catch: Exception -> L433
        d r140 = r25;
        fr.e r65 = r30.k(r140);     // Catch: Exception -> L431
        fr.c r141 = this.A0;     // Catch: Exception -> L431
        r210 = r122;
        r211 = r140;
        r141.f(r141.k(r64), r65, 0, 5);     // Catch: Exception -> L428
        this.K0 = null;     // Catch: Exception -> L428
        r210 = r210;
    L428:
        e = e;
    L431:
        e = e;
        r210 = r122;
        r211 = r140;
    L433:
        e = e;
        r210 = r122;
        r211 = r25;
    L416:
        e = e;
        r213 = r122;
        r211 = r25;
        goto L467
    L525:
        ?? r222 = r122;
        this.f17432u0 = r116;
        if (r222 == 0) goto L528;
        ConstraintWidget$DimensionBehaviour[] r66 = this.U;
        r66[0] = r33;
        r66[1] = r31;
    L528:
        G(r30.f16993m);
        return;
    L400:
        if (r117[r38] == r119) goto L403;
        r39 = false;
    L396:
        r38 = 1;
        goto L397
    L388:
        if (X(128) == true) goto L391;
        r37 = false;
        goto L392
    L165:
        r25 = r16;
        ArrayList r67 = null;
        ArrayList r68 = null;
        ArrayList r69 = null;
        ArrayList r142 = null;
        ArrayList r143 = null;
        ArrayList r144 = null;
        int r145 = 0;
    L166:
        if (r145 >= r111) goto L226;
        int r223 = r5;
        f r70 = (f) r110.get(r145);
        ConstraintWidget$DimensionBehaviour r224 = r13;
        ConstraintWidget$DimensionBehaviour[] r71 = this.U;
        int r225 = r10;
        ConstraintWidget$DimensionBehaviour r72 = r71[0];
        ConstraintWidget$DimensionBehaviour r73 = r71[1];
        ConstraintWidget$DimensionBehaviour r226 = r14;
        ConstraintWidget$DimensionBehaviour[] r74 = r70.U;
        fr.c r227 = r18;
        if (com.obric.oui.constraintlayout.core.widgets.analyzer.i.h(r72, r73, r74[0], r74[1]) == true) goto L170;
        W(r70, r22, this.P0);
    L170:
        boolean r75 = r70 instanceof k;
        if (r75 == false) goto L183;
        k r76 = (k) r70;
        if (r76.f17460y0 != 0) goto L178;
        if (r69 != null) goto L176;
        r69 = new ArrayList();
    L176:
        r69.add(r76);
    L178:
        if (r76.f17460y0 != 1) goto L183;
        if (r67 != null) goto L181;
        r67 = new ArrayList();
    L181:
        r67.add(r76);
    L183:
        if ((r70 instanceof l) == false) goto L204;
        if ((r70 instanceof a) == false) goto L196;
        a r77 = (a) r70;
        if (r77.W() != 0) goto L192;
        if (r68 != null) goto L190;
        r68 = new ArrayList();
    L190:
        r68.add(r77);
    L192:
        if (r77.W() != 1) goto L204;
        if (r142 != null) goto L195;
        r142 = new ArrayList();
    L195:
        r142.add(r77);
        goto L204
    L196:
        l r78 = (l) r70;
        if (r68 != null) goto L199;
        r68 = new ArrayList();
    L199:
        r68.add(r78);
        if (r142 != null) goto L202;
        r142 = new ArrayList();
    L202:
        r142.add(r78);
    L204:
        if (r70.J.f != null) goto L214;
        if (r70.L.f != null) goto L214;
        if (r75 == true) goto L214;
        if ((r70 instanceof a) == true) goto L214;
        if (r143 != null) goto L212;
        r143 = new ArrayList();
    L212:
        r143.add(r70);
    L214:
        if (r70.K.f != null) goto L225;
        if (r70.M.f != null) goto L225;
        if (r70.N.f != null) goto L225;
        if (r75 == true) goto L225;
        if ((r70 instanceof a) == true) goto L225;
        if (r144 != null) goto L224;
        r144 = new ArrayList();
    L224:
        r144.add(r70);
    L225:
        r145 = r145 + 1;
        r13 = r224;
        r5 = r223;
        r10 = r225;
        r14 = r226;
        r18 = r227;
        goto L166
    L226:
        r26 = r10;
        fr.c r228 = r18;
        r27 = r5;
        r28 = r14;
        r29 = r13;
        ArrayList r79 = new ArrayList();
        if (r67 == null) goto L232;
        Iterator r80 = r67.iterator();
    L230:
        if (r80.hasNext() == false) goto L232;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b((k) r80.next(), 0, r79, null);
    L232:
        int r81 = 0;
        q r82 = null;
        if (r68 == null) goto L238;
        Iterator r83 = r68.iterator();
    L236:
        if (r83.hasNext() == false) goto L238;
        l r84 = (l) r83.next();
        q r85 = com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(r84, r81, r79, r82);
        r84.T(r81, r85, r79);
        r85.a(r79);
        r81 = 0;
        r82 = null;
    L238:
        HashSet r86 = j(ConstraintAnchor$Type.LEFT).f17387a;
        if (r86 == null) goto L244;
        Iterator r87 = r86.iterator();
    L242:
        if (r87.hasNext() == false) goto L244;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(((d) r87.next()).d, 0, r79, null);
    L244:
        HashSet r88 = j(ConstraintAnchor$Type.RIGHT).f17387a;
        if (r88 == null) goto L250;
        Iterator r89 = r88.iterator();
    L248:
        if (r89.hasNext() == false) goto L250;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(((d) r89.next()).d, 0, r79, null);
    L250:
        HashSet r90 = j(ConstraintAnchor$Type.CENTER).f17387a;
        if (r90 == null) goto L256;
        Iterator r91 = r90.iterator();
    L254:
        if (r91.hasNext() == false) goto L256;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(((d) r91.next()).d, 0, r79, null);
    L256:
        q r92 = null;
        if (r143 == null) goto L262;
        Iterator r93 = r143.iterator();
    L260:
        if (r93.hasNext() == false) goto L262;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b((f) r93.next(), 0, r79, null);
    L262:
        if (r69 == null) goto L267;
        Iterator r94 = r69.iterator();
    L265:
        if (r94.hasNext() == false) goto L267;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b((k) r94.next(), 1, r79, null);
    L267:
        int r95 = 1;
        if (r142 == null) goto L273;
        Iterator r96 = r142.iterator();
    L271:
        if (r96.hasNext() == false) goto L273;
        l r97 = (l) r96.next();
        q r98 = com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(r97, r95, r79, r92);
        r97.T(r95, r98, r79);
        r98.a(r79);
        r95 = 1;
        r92 = null;
    L273:
        HashSet r99 = j(ConstraintAnchor$Type.TOP).f17387a;
        if (r99 == null) goto L279;
        Iterator r100 = r99.iterator();
    L277:
        if (r100.hasNext() == false) goto L279;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(((d) r100.next()).d, 1, r79, null);
    L279:
        HashSet r101 = j(ConstraintAnchor$Type.BASELINE).f17387a;
        if (r101 == null) goto L285;
        Iterator r102 = r101.iterator();
    L283:
        if (r102.hasNext() == false) goto L285;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(((d) r102.next()).d, 1, r79, null);
    L285:
        HashSet r103 = j(ConstraintAnchor$Type.BOTTOM).f17387a;
        if (r103 == null) goto L291;
        Iterator r104 = r103.iterator();
    L289:
        if (r104.hasNext() == false) goto L291;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(((d) r104.next()).d, 1, r79, null);
    L291:
        HashSet r105 = j(ConstraintAnchor$Type.CENTER).f17387a;
        if (r105 == null) goto L298;
        Iterator r106 = r105.iterator();
    L295:
        if (r106.hasNext() == false) goto L298;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b(((d) r106.next()).d, 1, r79, null);
    L298:
        if (r144 == null) goto L303;
        Iterator r107 = r144.iterator();
    L301:
        if (r107.hasNext() == false) goto L303;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.b((f) r107.next(), 1, r79, null);
    L303:
        int r108 = 0;
    L304:
        if (r108 >= r111) goto L328;
        f r109 = (f) r110.get(r108);
        ConstraintWidget$DimensionBehaviour[] r146 = r109.U;
        ConstraintWidget$DimensionBehaviour r147 = r146[0];
        ConstraintWidget$DimensionBehaviour r148 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r147 != r148) goto L326;
        if (r146[1] != r148) goto L326;
        int r149 = r109.f17423s0;
        int r150 = r79.size();
        int r151 = 0;
    L310:
        if (r151 >= r150) goto L315;
        q r152 = (q) r79.get(r151);
        if (r149 == r152.f12589b) goto L316;
        r151 = r151 + 1;
    L316:
        int r153 = r109.f17425t0;
        int r154 = r79.size();
        int r155 = 0;
    L317:
        if (r155 >= r154) goto L322;
        q r156 = (q) r79.get(r155);
        if (r153 == r156.f12589b) goto L323;
        r155 = r155 + 1;
    L323:
        if (r152 == null) goto L326;
        if (r156 == null) goto L326;
        r152.c(0, r156);
        r156.f12590c = 2;
        r79.remove(r152);
        goto L326
    L322:
        r156 = null;
        goto L323
    L315:
        r152 = null;
    L326:
        r108 = r108 + 1;
        goto L304
    L328:
        if (r79.size() > 1) goto L331;
        r30 = r228;
        goto L364
    L331:
        if (this.U[0] != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L345;
        Iterator r157 = r79.iterator();
        q r158 = null;
        int r159 = 0;
    L334:
        if (r157.hasNext() == false) goto L342;
        q r160 = (q) r157.next();
        if (r160.f12590c == 1) goto L334;
        fr.c r161 = r228;
        int r162 = r160.b(r161, 0);
        if (r162 <= r159) goto L341;
        r158 = r160;
        r159 = r162;
    L341:
        r228 = r161;
        goto L334
    L342:
        r30 = r228;
        if (r158 == null) goto L346;
        N(ConstraintWidget$DimensionBehaviour.FIXED);
        P(r159);
    L348:
        if (this.U[1] != ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) goto L360;
        Iterator r163 = r79.iterator();
        q r164 = null;
        int r165 = 0;
    L351:
        if (r163.hasNext() == false) goto L358;
        q r166 = (q) r163.next();
        if (r166.f12590c == 0) goto L351;
        int r167 = r166.b(r30, 1);
        if (r167 <= r165) goto L351;
        r164 = r166;
        r165 = r167;
        goto L351
    L358:
        if (r164 == null) goto L360;
        O(ConstraintWidget$DimensionBehaviour.FIXED);
        M(r165);
    L361:
        if (r158 != null) goto L365;
        if (r164 == null) goto L364;
    L365:
        ConstraintWidget$DimensionBehaviour r168 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
        r33 = r28;
        if (r33 != r168) goto L373;
        int r169 = r26;
        if (r169 >= r()) goto L371;
        if (r169 <= 0) goto L371;
        P(r169);
        this.I0 = true;
    L374:
        r34 = r169;
    L372:
        r31 = r29;
        if (r31 != r168) goto L381;
        int r170 = r21;
        if (r170 >= l()) goto L380;
        if (r170 <= 0) goto L380;
        M(r170);
        this.J0 = true;
    L382:
        r35 = r170;
    L383:
        r36 = true;
    L380:
        r35 = l();
        goto L383
    L381:
        r170 = r21;
    L371:
        r34 = r();
        goto L372
    L373:
        r169 = r26;
    L360:
        r164 = null;
    L346:
        r158 = null;
        goto L348
    L345:
        r30 = r228;
    L153:
        r32 = r10;
        r27 = r5;
        r25 = r16;
        r30 = r18;
        r33 = r14;
        r31 = r13;
        goto L384
    L5:
        if (m.c(this.H0, 1) == false) goto L146;
        com.obric.oui.constraintlayout.core.widgets.analyzer.c r171 = this.f17436y0;
        ConstraintWidget$DimensionBehaviour[] r172 = this.U;
        ConstraintWidget$DimensionBehaviour r173 = r172[0];
        ConstraintWidget$DimensionBehaviour r174 = r172[1];
        F();
        ArrayList r175 = this.f17432u0;
        int r176 = r175.size();
        int r177 = 0;
    L7:
        if (r177 >= r176) goto L9;
        ((f) r175.get(r177)).F();
        r177 = r177 + 1;
        goto L7
    L9:
        boolean r178 = this.f17437z0;
        if (r173 != ConstraintWidget$DimensionBehaviour.FIXED) goto L12;
        K(0, r());
    L13:
        boolean r179 = false;
        int r180 = 0;
        boolean r181 = false;
    L15:
        if (r180 >= r176) goto L38;
        f r182 = (f) r175.get(r180);
        d r183 = r17;
        if ((r182 instanceof k) == false) goto L32;
        k r184 = (k) r182;
        int r229 = r11;
        if (r184.f17460y0 != 1) goto L37;
        int r185 = r184.f17457v0;
        if (r185 == (-1)) goto L24;
        r184.S(r185);
    L31:
        r179 = true;
        goto L37
    L24:
        if (r184.f17458w0 == (-1)) goto L29;
        if (B() == false) goto L29;
        r184.S(r() - r184.f17458w0);
    L29:
        if (B() == false) goto L31;
        r184.S((int) ((r184.f17456u0 * r()) + 0.5f));
    L37:
        r180 = r180 + 1;
        r17 = r183;
        r11 = r229;
        goto L15
    L32:
        r229 = r11;
        if ((r182 instanceof a) == false) goto L37;
        if (((a) r182).W() != 0) goto L37;
        r181 = true;
        goto L37
    L38:
        r21 = r11;
        r19 = r17;
        if (r179 == false) goto L49;
        int r186 = 0;
    L41:
        if (r186 >= r176) goto L49;
        f r187 = (f) r175.get(r186);
        if ((r187 instanceof k) == false) goto L48;
        k r188 = (k) r187;
        if (r188.f17460y0 != 1) goto L48;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.c(0, r171, r188, r178);
    L48:
        r186 = r186 + 1;
    L49:
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.c(0, r171, this, r178);
        if (r181 == false) goto L62;
        int r189 = 0;
    L52:
        if (r189 >= r176) goto L62;
        f r190 = (f) r175.get(r189);
        if ((r190 instanceof a) == false) goto L60;
        a r191 = (a) r190;
        if (r191.W() != 0) goto L60;
        if (r191.V() == false) goto L60;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.c(1, r171, r191, r178);
    L60:
        r189 = r189 + 1;
    L62:
        if (r174 != ConstraintWidget$DimensionBehaviour.FIXED) goto L64;
        L(0, l());
    L65:
        int r192 = 0;
        boolean r193 = false;
        boolean r194 = false;
    L66:
        if (r192 >= r176) goto L89;
        f r195 = (f) r175.get(r192);
        if ((r195 instanceof k) == false) goto L84;
        k r196 = (k) r195;
        if (r196.f17460y0 != 0) goto L88;
        int r197 = r196.f17457v0;
        if (r197 == (-1)) goto L75;
        r196.S(r197);
    L82:
        r193 = true;
        goto L88
    L75:
        if (r196.f17458w0 == (-1)) goto L80;
        if (C() == false) goto L80;
        r196.S(l() - r196.f17458w0);
    L80:
        if (C() == false) goto L82;
        r196.S((int) ((r196.f17456u0 * l()) + 0.5f));
    L88:
        r192 = r192 + 1;
        goto L66
    L84:
        if ((r195 instanceof a) == false) goto L88;
        if (((a) r195).W() != 1) goto L88;
        r194 = true;
        goto L88
    L89:
        if (r193 == false) goto L98;
        int r198 = 0;
    L91:
        if (r198 >= r176) goto L98;
        f r199 = (f) r175.get(r198);
        if ((r199 instanceof k) == false) goto L97;
        k r200 = (k) r199;
        if (r200.f17460y0 != 0) goto L97;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.i(1, r171, r200);
    L97:
        r198 = r198 + 1;
    L98:
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.i(0, r171, this);
        if (r194 == false) goto L110;
        int r201 = 0;
    L101:
        if (r201 >= r176) goto L110;
        f r202 = (f) r175.get(r201);
        if ((r202 instanceof a) == false) goto L109;
        a r203 = (a) r202;
        if (r203.W() != 1) goto L109;
        if (r203.V() == false) goto L109;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.i(1, r171, r203);
    L109:
        r201 = r201 + 1;
    L110:
        int r204 = 0;
    L111:
        if (r204 >= r176) goto L124;
        f r205 = (f) r175.get(r204);
        if (r205.A() == false) goto L123;
        if (com.obric.oui.constraintlayout.core.widgets.analyzer.i.a(r205) == false) goto L123;
        W(r205, r171, com.obric.oui.constraintlayout.core.widgets.analyzer.i.f12580a);
        if ((r205 instanceof k) == true) goto L119;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.c(0, r171, r205, r178);
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.i(0, r171, r205);
        goto L123
    L119:
        if (((k) r205).f17460y0 != 0) goto L121;
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.i(0, r171, r205);
        goto L123
    L121:
        com.obric.oui.constraintlayout.core.widgets.analyzer.i.c(0, r171, r205, r178);
    L123:
        r204 = r204 + 1;
        goto L111
    L124:
        int r206 = 0;
    L125:
        if (r206 >= r5) goto L147;
        f r207 = (f) this.f17432u0.get(r206);
        if (r207.A() == false) goto L145;
        if ((r207 instanceof k) == true) goto L145;
        if ((r207 instanceof a) == true) goto L145;
        if ((r207 instanceof o) == true) goto L145;
        if (r207.G == true) goto L145;
        ConstraintWidget$DimensionBehaviour r208 = r207.k(0);
        ConstraintWidget$DimensionBehaviour r1100 = r207.k(1);
        ConstraintWidget$DimensionBehaviour r1101 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (r208 == r1101) goto L139;
    L144:
        W(r207, this.f17436y0, new com.obric.oui.constraintlayout.core.widgets.analyzer.b());
        goto L145
    L139:
        if (r207.f17421r == 1) goto L144;
        if (r1100 != r1101) goto L144;
        if (r207.s == 1) goto L144;
    L145:
        r206 = r206 + 1;
        goto L125
    L64:
        r16.l(0);
        this.f17397b0 = 0;
        goto L65
    L12:
        r17.l(0);
        this.f17395a0 = 0;
        goto L13
    }

    public final boolean X(int r5) {
        if ((this.H0 & r5) != r5) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // hr.f
    public final void o(StringBuilder r5) {
        r5.append(this.f17406j + ":{\n");
        StringBuilder r10 = new StringBuilder("  actualWidth:");
        r10.append(this.W);
        r5.append(r10.toString());
        r5.append("\n");
        r5.append("  actualHeight:" + this.X);
        r5.append("\n");
        Iterator r11 = this.f17432u0.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        ((f) r11.next()).o(r5);
        r5.append(",\n");
        goto L4
    L6:
        r5.append("}");
    }
}
