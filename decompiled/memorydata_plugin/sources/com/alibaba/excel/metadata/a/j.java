package com.alibaba.excel.metadata.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.excel.metadata.data.d f258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.alibaba.excel.j.b.b.b f259b;
    private Boolean c;
    private Boolean d;
    private Boolean e;
    private HorizontalAlignment f;
    private Boolean g;
    private VerticalAlignment h;
    private Short i;
    private Short j;
    private BorderStyle k;
    private BorderStyle l;
    private BorderStyle m;
    private BorderStyle n;
    private Short o;
    private Short p;
    private Short q;
    private Short r;
    private FillPatternType s;
    private Short t;
    private Short u;
    private Boolean v;

    public j() {
    }

    public static j a(com.alibaba.excel.b.b.a.b r3) {
        com.alibaba.excel.b.b.a.b r4 = (com.alibaba.excel.b.b.a.b) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.b.b.a.b.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        return null;
    L6:
        j r0 = new j();
        if (r4.a() < 0) goto L9;
        com.alibaba.excel.metadata.data.d r1 = new com.alibaba.excel.metadata.data.d();
        r1.a(Short.valueOf(r4.a()));
        r0.a(r1);
    L9:
        r0.a(r4.b().getBooleanValue());
        r0.b(r4.c().getBooleanValue());
        r0.c(r4.d().getBooleanValue());
        r0.a(r4.e().getPoiHorizontalAlignment());
        r0.d(r4.f().getBooleanValue());
        r0.a(r4.g().getPoiVerticalAlignmentEnum());
        if (r4.h() < 0) goto L13;
        r0.a(Short.valueOf(r4.h()));
    L13:
        if (r4.i() < 0) goto L15;
        r0.b(Short.valueOf(r4.i()));
    L15:
        r0.a(r4.j().getPoiBorderStyle());
        r0.b(r4.k().getPoiBorderStyle());
        r0.c(r4.l().getPoiBorderStyle());
        r0.d(r4.m().getPoiBorderStyle());
        if (r4.n() < 0) goto L19;
        r0.c(Short.valueOf(r4.n()));
    L19:
        if (r4.o() < 0) goto L22;
        r0.d(Short.valueOf(r4.o()));
    L22:
        if (r4.p() < 0) goto L25;
        r0.e(Short.valueOf(r4.p()));
    L25:
        if (r4.q() < 0) goto L27;
        r0.f(Short.valueOf(r4.q()));
    L27:
        r0.a(r4.r().getPoiFillPatternType());
        if (r4.s() < 0) goto L31;
        r0.g(Short.valueOf(r4.s()));
    L31:
        if (r4.t() < 0) goto L33;
        r0.h(Short.valueOf(r4.t()));
    L33:
        r0.e(r4.u().getBooleanValue());
        return r0;
    }

    public com.alibaba.excel.metadata.data.d a() {
        return this.f258a;
    }

    public void a(com.alibaba.excel.metadata.data.d r1) {
        this.f258a = r1;
    }

    public void a(Boolean r1) {
        this.c = r1;
    }

    public void a(Short r1) {
        this.i = r1;
    }

    public void a(BorderStyle r1) {
        this.k = r1;
    }

    public void a(FillPatternType r1) {
        this.s = r1;
    }

    public void a(HorizontalAlignment r1) {
        this.f = r1;
    }

    public void a(VerticalAlignment r1) {
        this.h = r1;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, j.class);
    }

    public com.alibaba.excel.j.b.b.b b() {
        return this.f259b;
    }

    public void b(Boolean r1) {
        this.d = r1;
    }

    public void b(Short r1) {
        this.j = r1;
    }

    public void b(BorderStyle r1) {
        this.l = r1;
    }

    public Boolean c() {
        return this.c;
    }

    public void c(Boolean r1) {
        this.e = r1;
    }

    public void c(Short r1) {
        this.o = r1;
    }

    public void c(BorderStyle r1) {
        this.m = r1;
    }

    public Boolean d() {
        return this.d;
    }

    public void d(Boolean r1) {
        this.g = r1;
    }

    public void d(Short r1) {
        this.p = r1;
    }

    public void d(BorderStyle r1) {
        this.n = r1;
    }

    public Boolean e() {
        return this.e;
    }

    public void e(Boolean r1) {
        this.v = r1;
    }

    public void e(Short r1) {
        this.q = r1;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L11;
        return false;
    L11:
        Boolean r0 = c();
        Boolean r2 = r6.c();
        if (r0 != null) goto L16;
        if (r2 != null) goto L17;
    L18:
        Boolean r1 = d();
        Boolean r3 = r6.d();
        if (r1 != null) goto L23;
        if (r3 != null) goto L24;
    L25:
        Boolean r4 = e();
        Boolean r7 = r6.e();
        if (r4 != null) goto L30;
        if (r7 != null) goto L31;
    L32:
        Boolean r8 = g();
        Boolean r9 = r6.g();
        if (r8 != null) goto L37;
        if (r9 != null) goto L38;
    L39:
        Short r10 = i();
        Short r11 = r6.i();
        if (r10 != null) goto L44;
        if (r11 != null) goto L45;
    L46:
        Short r12 = j();
        Short r13 = r6.j();
        if (r12 != null) goto L51;
        if (r13 != null) goto L52;
    L53:
        Short r14 = o();
        Short r15 = r6.o();
        if (r14 != null) goto L58;
        if (r15 != null) goto L59;
    L60:
        Short r16 = p();
        Short r17 = r6.p();
        if (r16 != null) goto L65;
        if (r17 != null) goto L66;
    L67:
        Short r18 = q();
        Short r19 = r6.q();
        if (r18 != null) goto L72;
        if (r19 != null) goto L73;
    L74:
        Short r20 = r();
        Short r21 = r6.r();
        if (r20 != null) goto L79;
        if (r21 != null) goto L80;
    L81:
        Short r22 = t();
        Short r23 = r6.t();
        if (r22 != null) goto L86;
        if (r23 != null) goto L87;
    L88:
        Short r24 = u();
        Short r25 = r6.u();
        if (r24 != null) goto L93;
        if (r25 != null) goto L94;
    L95:
        Boolean r26 = v();
        Boolean r27 = r6.v();
        if (r26 != null) goto L100;
        if (r27 != null) goto L101;
    L102:
        com.alibaba.excel.metadata.data.d r28 = a();
        com.alibaba.excel.metadata.data.d r29 = r6.a();
        if (r28 != null) goto L107;
        if (r29 != null) goto L108;
    L109:
        com.alibaba.excel.j.b.b.b r30 = b();
        com.alibaba.excel.j.b.b.b r31 = r6.b();
        if (r30 != null) goto L114;
        if (r31 != null) goto L115;
    L116:
        HorizontalAlignment r32 = f();
        HorizontalAlignment r33 = r6.f();
        if (r32 != null) goto L121;
        if (r33 != null) goto L122;
    L123:
        VerticalAlignment r34 = h();
        VerticalAlignment r35 = r6.h();
        if (r34 != null) goto L128;
        if (r35 != null) goto L129;
    L130:
        BorderStyle r36 = k();
        BorderStyle r37 = r6.k();
        if (r36 != null) goto L135;
        if (r37 != null) goto L136;
    L137:
        BorderStyle r38 = l();
        BorderStyle r39 = r6.l();
        if (r38 != null) goto L142;
        if (r39 != null) goto L143;
    L144:
        BorderStyle r40 = m();
        BorderStyle r41 = r6.m();
        if (r40 != null) goto L149;
        if (r41 != null) goto L150;
    L151:
        BorderStyle r42 = n();
        BorderStyle r43 = r6.n();
        if (r42 != null) goto L156;
        if (r43 != null) goto L157;
    L158:
        FillPatternType r44 = s();
        FillPatternType r45 = r6.s();
        if (r44 != null) goto L163;
        if (r45 != null) goto L164;
    L165:
        return true;
    L164:
        return false;
    L163:
        if (r44.equals(r45) == true) goto L165;
    L157:
        return false;
    L156:
        if (r42.equals(r43) == true) goto L158;
    L150:
        return false;
    L149:
        if (r40.equals(r41) == true) goto L151;
    L143:
        return false;
    L142:
        if (r38.equals(r39) == true) goto L144;
    L136:
        return false;
    L135:
        if (r36.equals(r37) == true) goto L137;
    L129:
        return false;
    L128:
        if (r34.equals(r35) == true) goto L130;
    L122:
        return false;
    L121:
        if (r32.equals(r33) == true) goto L123;
    L115:
        return false;
    L114:
        if (r30.equals(r31) == true) goto L116;
    L108:
        return false;
    L107:
        if (r28.equals(r29) == true) goto L109;
    L101:
        return false;
    L100:
        if (r26.equals(r27) == true) goto L102;
    L94:
        return false;
    L93:
        if (r24.equals(r25) == true) goto L95;
    L87:
        return false;
    L86:
        if (r22.equals(r23) == true) goto L88;
    L80:
        return false;
    L79:
        if (r20.equals(r21) == true) goto L81;
    L73:
        return false;
    L72:
        if (r18.equals(r19) == true) goto L74;
    L66:
        return false;
    L65:
        if (r16.equals(r17) == true) goto L67;
    L59:
        return false;
    L58:
        if (r14.equals(r15) == true) goto L60;
    L52:
        return false;
    L51:
        if (r12.equals(r13) == true) goto L53;
    L45:
        return false;
    L44:
        if (r10.equals(r11) == true) goto L46;
    L38:
        return false;
    L37:
        if (r8.equals(r9) == true) goto L39;
    L31:
        return false;
    L30:
        if (r4.equals(r7) == true) goto L32;
    L24:
        return false;
    L23:
        if (r1.equals(r3) == true) goto L25;
    L17:
        return false;
    L16:
        if (r0.equals(r2) == true) goto L18;
        goto L17
    }

    public HorizontalAlignment f() {
        return this.f;
    }

    public void f(Short r1) {
        this.r = r1;
    }

    public Boolean g() {
        return this.g;
    }

    public void g(Short r1) {
        this.t = r1;
    }

    public VerticalAlignment h() {
        return this.h;
    }

    public void h(Short r1) {
        this.u = r1;
    }

    public int hashCode() {
        Boolean r0 = c();
        int r1 = 43;
        if (r0 != null) goto L5;
        int r2 = 43;
    L6:
        Boolean r3 = d();
        int r4 = (r2 + 59) * 59;
        if (r3 != null) goto L9;
        int r5 = 43;
    L10:
        int r6 = r4 + r5;
        Boolean r7 = e();
        int r8 = r6 * 59;
        if (r7 != null) goto L13;
        int r9 = 43;
    L14:
        int r10 = r8 + r9;
        Boolean r11 = g();
        int r12 = r10 * 59;
        if (r11 != null) goto L17;
        int r13 = 43;
    L18:
        int r14 = r12 + r13;
        Short r15 = i();
        int r16 = r14 * 59;
        if (r15 != null) goto L21;
        int r17 = 43;
    L22:
        int r18 = r16 + r17;
        Short r19 = j();
        int r20 = r18 * 59;
        if (r19 != null) goto L25;
        int r21 = 43;
    L26:
        int r22 = r20 + r21;
        Short r23 = o();
        int r24 = r22 * 59;
        if (r23 != null) goto L29;
        int r25 = 43;
    L30:
        int r26 = r24 + r25;
        Short r27 = p();
        int r28 = r26 * 59;
        if (r27 != null) goto L33;
        int r29 = 43;
    L34:
        int r30 = r28 + r29;
        Short r31 = q();
        int r32 = r30 * 59;
        if (r31 != null) goto L37;
        int r33 = 43;
    L38:
        int r34 = r32 + r33;
        Short r35 = r();
        int r36 = r34 * 59;
        if (r35 != null) goto L41;
        int r37 = 43;
    L42:
        int r38 = r36 + r37;
        Short r39 = t();
        int r40 = r38 * 59;
        if (r39 != null) goto L45;
        int r41 = 43;
    L46:
        int r42 = r40 + r41;
        Short r43 = u();
        int r44 = r42 * 59;
        if (r43 != null) goto L49;
        int r45 = 43;
    L50:
        int r46 = r44 + r45;
        Boolean r47 = v();
        int r48 = r46 * 59;
        if (r47 != null) goto L53;
        int r49 = 43;
    L54:
        int r50 = r48 + r49;
        com.alibaba.excel.metadata.data.d r51 = a();
        int r52 = r50 * 59;
        if (r51 != null) goto L57;
        int r53 = 43;
    L58:
        int r54 = r52 + r53;
        com.alibaba.excel.j.b.b.b r55 = b();
        int r56 = r54 * 59;
        if (r55 != null) goto L61;
        int r57 = 43;
    L62:
        int r58 = r56 + r57;
        HorizontalAlignment r59 = f();
        int r60 = r58 * 59;
        if (r59 != null) goto L65;
        int r61 = 43;
    L66:
        int r62 = r60 + r61;
        VerticalAlignment r63 = h();
        int r64 = r62 * 59;
        if (r63 != null) goto L69;
        int r65 = 43;
    L70:
        int r66 = r64 + r65;
        BorderStyle r67 = k();
        int r68 = r66 * 59;
        if (r67 != null) goto L73;
        int r69 = 43;
    L74:
        int r70 = r68 + r69;
        BorderStyle r71 = l();
        int r72 = r70 * 59;
        if (r71 != null) goto L77;
        int r73 = 43;
    L78:
        int r74 = r72 + r73;
        BorderStyle r75 = m();
        int r76 = r74 * 59;
        if (r75 != null) goto L81;
        int r77 = 43;
    L82:
        int r78 = r76 + r77;
        BorderStyle r79 = n();
        int r80 = r78 * 59;
        if (r79 != null) goto L85;
        int r81 = 43;
    L86:
        FillPatternType r82 = s();
        int r83 = (r80 + r81) * 59;
        if (r82 == null) goto L91;
        r1 = r82.hashCode();
    L91:
        return r83 + r1;
    L85:
        r81 = r79.hashCode();
        goto L86
    L81:
        r77 = r75.hashCode();
        goto L82
    L77:
        r73 = r71.hashCode();
        goto L78
    L73:
        r69 = r67.hashCode();
        goto L74
    L69:
        r65 = r63.hashCode();
        goto L70
    L65:
        r61 = r59.hashCode();
        goto L66
    L61:
        r57 = r55.hashCode();
        goto L62
    L57:
        r53 = r51.hashCode();
        goto L58
    L53:
        r49 = r47.hashCode();
        goto L54
    L49:
        r45 = r43.hashCode();
        goto L50
    L45:
        r41 = r39.hashCode();
        goto L46
    L41:
        r37 = r35.hashCode();
        goto L42
    L37:
        r33 = r31.hashCode();
        goto L38
    L33:
        r29 = r27.hashCode();
        goto L34
    L29:
        r25 = r23.hashCode();
        goto L30
    L25:
        r21 = r19.hashCode();
        goto L26
    L21:
        r17 = r15.hashCode();
        goto L22
    L17:
        r13 = r11.hashCode();
        goto L18
    L13:
        r9 = r7.hashCode();
        goto L14
    L9:
        r5 = r3.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public Short i() {
        return this.i;
    }

    public Short j() {
        return this.j;
    }

    public BorderStyle k() {
        return this.k;
    }

    public BorderStyle l() {
        return this.l;
    }

    public BorderStyle m() {
        return this.m;
    }

    public BorderStyle n() {
        return this.n;
    }

    public Short o() {
        return this.o;
    }

    public Short p() {
        return this.p;
    }

    public Short q() {
        return this.q;
    }

    public Short r() {
        return this.r;
    }

    public FillPatternType s() {
        return this.s;
    }

    public Short t() {
        return this.t;
    }

    public Short u() {
        return this.u;
    }

    public Boolean v() {
        return this.v;
    }
}
