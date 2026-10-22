package com.alibaba.excel.j.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends com.alibaba.excel.metadata.b implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.alibaba.excel.j.a.a.d f233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alibaba.excel.j.a.a.c f234b;
    public com.alibaba.excel.j.a.a.d c;
    public com.alibaba.excel.j.a.a.c d;
    public com.alibaba.excel.j.a.a.b e;
    public com.alibaba.excel.j.a.a.a f;
    private Boolean g;
    private Integer h;
    private com.alibaba.excel.j.c.a i;
    private Boolean j;
    private Boolean k;
    private Collection<Integer> l;
    private Collection<String> m;
    private Collection<Integer> n;
    private Collection<String> o;
    private Boolean p;
    private List<Object> q;

    public a() {
    }

    public com.alibaba.excel.j.a.a.d A() {
        return this.c;
    }

    public com.alibaba.excel.j.a.a.c B() {
        return this.d;
    }

    public com.alibaba.excel.j.a.a.b C() {
        return this.e;
    }

    public com.alibaba.excel.j.a.a.a D() {
        return this.f;
    }

    @Override // com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    @Override // com.alibaba.excel.j.b.a.b
    public boolean a(String r3, Integer r4) {
        if (r3 == null) goto L14;
        Collection<String> r1 = this.o;
        if (r1 != null) goto L7;
    L9:
        Collection<String> r2 = this.m;
        if (r2 == null) goto L14;
        if (r2.contains(r3) == false) goto L14;
        return true;
    L7:
        if (r1.contains(r3) == true) goto L9;
        return true;
    L14:
        if (r4 == null) goto L25;
        Collection<Integer> r5 = this.n;
        if (r5 != null) goto L18;
    L20:
        Collection<Integer> r6 = this.l;
        if (r6 != null) goto L23;
        return false;
    L23:
        if (r6.contains(r4) == false) goto L28;
        return true;
    L28:
        return false;
    L18:
        if (r5.contains(r4) == true) goto L20;
        return true;
    L25:
        return false;
    }

    @Override // com.alibaba.excel.metadata.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r0 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Boolean r6 = n();
        Boolean r2 = r0.n();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Integer r7 = o();
        Integer r3 = r0.o();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Boolean r8 = q();
        Boolean r4 = r0.q();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Boolean r9 = r();
        Boolean r10 = r0.r();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        Boolean r11 = w();
        Boolean r12 = r0.w();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        com.alibaba.excel.j.c.a r13 = p();
        com.alibaba.excel.j.c.a r14 = r0.p();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        Collection<Integer> r15 = s();
        Collection<Integer> r16 = r0.s();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        Collection<String> r17 = t();
        Collection<String> r18 = r0.t();
        if (r17 != null) goto L68;
        if (r18 != null) goto L69;
    L70:
        Collection<Integer> r19 = u();
        Collection<Integer> r20 = r0.u();
        if (r19 != null) goto L75;
        if (r20 != null) goto L76;
    L77:
        Collection<String> r21 = v();
        Collection<String> r22 = r0.v();
        if (r21 != null) goto L82;
        if (r22 != null) goto L83;
    L84:
        List<Object> r23 = x();
        List<Object> r24 = r0.x();
        if (r23 != null) goto L89;
        if (r24 != null) goto L90;
    L91:
        com.alibaba.excel.j.a.a.d r25 = y();
        com.alibaba.excel.j.a.a.d r26 = r0.y();
        if (r25 != null) goto L96;
        if (r26 != null) goto L97;
    L98:
        com.alibaba.excel.j.a.a.c r27 = z();
        com.alibaba.excel.j.a.a.c r28 = r0.z();
        if (r27 != null) goto L103;
        if (r28 != null) goto L104;
    L105:
        com.alibaba.excel.j.a.a.d r29 = A();
        com.alibaba.excel.j.a.a.d r30 = r0.A();
        if (r29 != null) goto L110;
        if (r30 != null) goto L111;
    L112:
        com.alibaba.excel.j.a.a.c r31 = B();
        com.alibaba.excel.j.a.a.c r32 = r0.B();
        if (r31 != null) goto L117;
        if (r32 != null) goto L118;
    L119:
        com.alibaba.excel.j.a.a.b r33 = C();
        com.alibaba.excel.j.a.a.b r34 = r0.C();
        if (r33 != null) goto L124;
        if (r34 != null) goto L125;
    L126:
        com.alibaba.excel.j.a.a.a r35 = D();
        com.alibaba.excel.j.a.a.a r36 = r0.D();
        if (r35 != null) goto L131;
        if (r36 != null) goto L132;
    L133:
        return true;
    L132:
        return false;
    L131:
        if (r35.equals(r36) == true) goto L133;
    L125:
        return false;
    L124:
        if (r33.equals(r34) == true) goto L126;
    L118:
        return false;
    L117:
        if (r31.equals(r32) == true) goto L119;
    L111:
        return false;
    L110:
        if (r29.equals(r30) == true) goto L112;
    L104:
        return false;
    L103:
        if (r27.equals(r28) == true) goto L105;
    L97:
        return false;
    L96:
        if (r25.equals(r26) == true) goto L98;
    L90:
        return false;
    L89:
        if (r23.equals(r24) == true) goto L91;
    L83:
        return false;
    L82:
        if (r21.equals(r22) == true) goto L84;
    L76:
        return false;
    L75:
        if (r19.equals(r20) == true) goto L77;
    L69:
        return false;
    L68:
        if (r17.equals(r18) == true) goto L70;
    L62:
        return false;
    L61:
        if (r15.equals(r16) == true) goto L63;
    L55:
        return false;
    L54:
        if (r13.equals(r14) == true) goto L56;
    L48:
        return false;
    L47:
        if (r11.equals(r12) == true) goto L49;
    L41:
        return false;
    L40:
        if (r9.equals(r10) == true) goto L42;
    L34:
        return false;
    L33:
        if (r8.equals(r4) == true) goto L35;
    L27:
        return false;
    L26:
        if (r7.equals(r3) == true) goto L28;
    L20:
        return false;
    L19:
        if (r6.equals(r2) == true) goto L21;
        goto L20
    }

    @Override // com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        Boolean r1 = n();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Integer r6 = o();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        Boolean r10 = q();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Boolean r14 = r();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        Boolean r18 = w();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        com.alibaba.excel.j.c.a r22 = p();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        int r25 = r23 + r24;
        Collection<Integer> r26 = s();
        int r27 = r25 * 59;
        if (r26 != null) goto L29;
        int r28 = 43;
    L30:
        int r29 = r27 + r28;
        Collection<String> r30 = t();
        int r31 = r29 * 59;
        if (r30 != null) goto L33;
        int r32 = 43;
    L34:
        int r33 = r31 + r32;
        Collection<Integer> r34 = u();
        int r35 = r33 * 59;
        if (r34 != null) goto L37;
        int r36 = 43;
    L38:
        int r37 = r35 + r36;
        Collection<String> r38 = v();
        int r39 = r37 * 59;
        if (r38 != null) goto L41;
        int r40 = 43;
    L42:
        int r41 = r39 + r40;
        List<Object> r42 = x();
        int r43 = r41 * 59;
        if (r42 != null) goto L45;
        int r44 = 43;
    L46:
        int r45 = r43 + r44;
        com.alibaba.excel.j.a.a.d r46 = y();
        int r47 = r45 * 59;
        if (r46 != null) goto L49;
        int r48 = 43;
    L50:
        int r49 = r47 + r48;
        com.alibaba.excel.j.a.a.c r50 = z();
        int r51 = r49 * 59;
        if (r50 != null) goto L53;
        int r52 = 43;
    L54:
        int r53 = r51 + r52;
        com.alibaba.excel.j.a.a.d r54 = A();
        int r55 = r53 * 59;
        if (r54 != null) goto L57;
        int r56 = 43;
    L58:
        int r57 = r55 + r56;
        com.alibaba.excel.j.a.a.c r58 = B();
        int r59 = r57 * 59;
        if (r58 != null) goto L61;
        int r60 = 43;
    L62:
        int r61 = r59 + r60;
        com.alibaba.excel.j.a.a.b r62 = C();
        int r63 = r61 * 59;
        if (r62 != null) goto L65;
        int r64 = 43;
    L66:
        com.alibaba.excel.j.a.a.a r65 = D();
        int r66 = (r63 + r64) * 59;
        if (r65 == null) goto L71;
        r3 = r65.hashCode();
    L71:
        return r66 + r3;
    L65:
        r64 = r62.hashCode();
        goto L66
    L61:
        r60 = r58.hashCode();
        goto L62
    L57:
        r56 = r54.hashCode();
        goto L58
    L53:
        r52 = r50.hashCode();
        goto L54
    L49:
        r48 = r46.hashCode();
        goto L50
    L45:
        r44 = r42.hashCode();
        goto L46
    L41:
        r40 = r38.hashCode();
        goto L42
    L37:
        r36 = r34.hashCode();
        goto L38
    L33:
        r32 = r30.hashCode();
        goto L34
    L29:
        r28 = r26.hashCode();
        goto L30
    L25:
        r24 = r22.hashCode();
        goto L26
    L21:
        r20 = r18.hashCode();
        goto L22
    L17:
        r16 = r14.hashCode();
        goto L18
    L13:
        r12 = r10.hashCode();
        goto L14
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = r1.hashCode();
        goto L6
    }

    @Override // com.alibaba.excel.j.b.a.b
    public boolean i() {
        return w().booleanValue();
    }

    @Override // com.alibaba.excel.j.b.a.b
    public Collection<Integer> j() {
        return u();
    }

    @Override // com.alibaba.excel.j.b.a.b
    public Collection<String> k() {
        return v();
    }

    @Override // com.alibaba.excel.j.b.a.b
    public Collection<Integer> l() {
        return s();
    }

    @Override // com.alibaba.excel.j.b.a.b
    public Collection<String> m() {
        return t();
    }

    public Boolean n() {
        return this.g;
    }

    public Integer o() {
        return this.h;
    }

    public com.alibaba.excel.j.c.a p() {
        return this.i;
    }

    public Boolean q() {
        return this.j;
    }

    public Boolean r() {
        return this.k;
    }

    public Collection<Integer> s() {
        return this.l;
    }

    public Collection<String> t() {
        return this.m;
    }

    public Collection<Integer> u() {
        return this.n;
    }

    public Collection<String> v() {
        return this.o;
    }

    public Boolean w() {
        return this.p;
    }

    public List<Object> x() {
        return this.q;
    }

    public com.alibaba.excel.j.a.a.d y() {
        return this.f233a;
    }

    public com.alibaba.excel.j.a.a.c z() {
        return this.f234b;
    }
}
