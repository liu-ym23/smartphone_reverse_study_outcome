package com.alibaba.excel.h.c.a;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.enums.HolderEnum;
import com.alibaba.excel.enums.ReadDefaultReturnEnum;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.excel.h.c.c f195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f196b;
    private File c;
    private Charset d;
    private Boolean e;
    private Boolean f;
    private ReadDefaultReturnEnum g;
    private ExcelTypeEnum h;
    private Object i;
    private Boolean j;
    private com.alibaba.excel.c.c k;
    private com.alibaba.excel.c.a.b l;
    private File m;
    private String n;
    private Set<CellExtraTypeEnum> o;
    private List<com.alibaba.excel.h.c.b> p;
    private List<com.alibaba.excel.h.c.b> q;
    private Boolean r;
    private Set<Integer> s;

    public e() {
    }

    public e(com.alibaba.excel.h.c.c r3) {
        super(r3, null);
        this.f195a = r3;
        if (r3.l() == null) goto L5;
        this.f196b = r3.l();
    L5:
        this.c = r3.m();
        if (r3.n() != null) goto L8;
        Charset r0 = Charset.defaultCharset();
    L9:
        this.d = r0;
        if (r3.o() != null) goto L12;
        Boolean r1 = Boolean.FALSE;
    L13:
        this.e = r1;
        if (r3.p() != null) goto L16;
        Boolean r2 = Boolean.TRUE;
    L17:
        this.f = r2;
        if (r3.x() != null) goto L20;
        ReadDefaultReturnEnum r4 = ReadDefaultReturnEnum.STRING;
    L21:
        this.g = r4;
        this.i = r3.q();
        if (r3.s() != null) goto L24;
        Boolean r5 = Boolean.TRUE;
    L25:
        this.j = r5;
        if (r3.r() == null) goto L33;
        if (r3.t() != null) goto L31;
        com.alibaba.excel.c.a.b r6 = new com.alibaba.excel.c.a.a(r3.r());
    L36:
        this.l = r6;
        if (r3.y() != null) goto L39;
        Set<CellExtraTypeEnum> r7 = new HashSet();
    L40:
        this.o = r7;
        this.s = new HashSet();
        this.n = r3.u();
        return;
    L39:
        r7 = r3.y();
        goto L40
    L31:
        throw new ExcelAnalysisException("'readCache' and 'readCacheSelector' only one choice.");
    L33:
        if (r3.t() != null) goto L35;
        r6 = new com.alibaba.excel.c.a.c();
        goto L36
    L35:
        r6 = r3.t();
        goto L36
    L24:
        r5 = r3.s();
        goto L25
    L20:
        r4 = r3.x();
        goto L21
    L16:
        r2 = r3.p();
        goto L17
    L12:
        r1 = r3.o();
        goto L13
    L8:
        r0 = r3.n();
        goto L9
    }

    public String A() {
        return this.n;
    }

    public Set<CellExtraTypeEnum> B() {
        return this.o;
    }

    public List<com.alibaba.excel.h.c.b> C() {
        return this.p;
    }

    public List<com.alibaba.excel.h.c.b> D() {
        return this.q;
    }

    public Boolean E() {
        return this.r;
    }

    public Set<Integer> F() {
        return this.s;
    }

    public void a(com.alibaba.excel.c.c r3) {
        this.k = (com.alibaba.excel.c.c) ZeusTransformUtils.wrapperContextForParams(r3, com.alibaba.excel.c.c.class, "com.obric.memorydata.plugin");
    }

    public void a(ExcelTypeEnum r1) {
        this.h = r1;
    }

    public void a(File r1) {
        this.m = r1;
    }

    public void a(Boolean r1) {
        this.r = r1;
    }

    public void a(List<com.alibaba.excel.h.c.b> r3) {
        this.p = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, e.class);
    }

    public void b(List<com.alibaba.excel.h.c.b> r3) {
        this.q = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r0 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Boolean r6 = r();
        Boolean r2 = r0.r();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Boolean r7 = s();
        Boolean r3 = r0.s();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Boolean r8 = w();
        Boolean r4 = r0.w();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Boolean r9 = E();
        Boolean r10 = r0.E();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        com.alibaba.excel.h.c.c r11 = n();
        com.alibaba.excel.h.c.c r12 = r0.n();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        InputStream r13 = o();
        InputStream r14 = r0.o();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        File r15 = p();
        File r16 = r0.p();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        Charset r17 = q();
        Charset r18 = r0.q();
        if (r17 != null) goto L68;
        if (r18 != null) goto L69;
    L70:
        ReadDefaultReturnEnum r19 = t();
        ReadDefaultReturnEnum r20 = r0.t();
        if (r19 != null) goto L75;
        if (r20 != null) goto L76;
    L77:
        ExcelTypeEnum r21 = u();
        ExcelTypeEnum r22 = r0.u();
        if (r21 != null) goto L82;
        if (r22 != null) goto L83;
    L84:
        Object r23 = v();
        Object r24 = r0.v();
        if (r23 != null) goto L89;
        if (r24 != null) goto L90;
    L91:
        com.alibaba.excel.c.c r25 = x();
        com.alibaba.excel.c.c r26 = r0.x();
        if (r25 != null) goto L96;
        if (r26 != null) goto L97;
    L98:
        com.alibaba.excel.c.a.b r27 = y();
        com.alibaba.excel.c.a.b r28 = r0.y();
        if (r27 != null) goto L103;
        if (r28 != null) goto L104;
    L105:
        File r29 = z();
        File r30 = r0.z();
        if (r29 != null) goto L110;
        if (r30 != null) goto L111;
    L112:
        String r31 = A();
        String r32 = r0.A();
        if (r31 != null) goto L117;
        if (r32 != null) goto L118;
    L119:
        Set<CellExtraTypeEnum> r33 = B();
        Set<CellExtraTypeEnum> r34 = r0.B();
        if (r33 != null) goto L124;
        if (r34 != null) goto L125;
    L126:
        List<com.alibaba.excel.h.c.b> r35 = C();
        List<com.alibaba.excel.h.c.b> r36 = r0.C();
        if (r35 != null) goto L131;
        if (r36 != null) goto L132;
    L133:
        List<com.alibaba.excel.h.c.b> r37 = D();
        List<com.alibaba.excel.h.c.b> r38 = r0.D();
        if (r37 != null) goto L138;
        if (r38 != null) goto L139;
    L140:
        Set<Integer> r39 = F();
        Set<Integer> r40 = r0.F();
        if (r39 != null) goto L145;
        if (r40 != null) goto L146;
    L147:
        return true;
    L146:
        return false;
    L145:
        if (r39.equals(r40) == true) goto L147;
    L139:
        return false;
    L138:
        if (r37.equals(r38) == true) goto L140;
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

    @Override // com.alibaba.excel.metadata.l
    public HolderEnum h() {
        return HolderEnum.WORKBOOK;
    }

    @Override // com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        Boolean r1 = r();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Boolean r6 = s();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        Boolean r10 = w();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Boolean r14 = E();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        com.alibaba.excel.h.c.c r18 = n();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        InputStream r22 = o();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        int r25 = r23 + r24;
        File r26 = p();
        int r27 = r25 * 59;
        if (r26 != null) goto L29;
        int r28 = 43;
    L30:
        int r29 = r27 + r28;
        Charset r30 = q();
        int r31 = r29 * 59;
        if (r30 != null) goto L33;
        int r32 = 43;
    L34:
        int r33 = r31 + r32;
        ReadDefaultReturnEnum r34 = t();
        int r35 = r33 * 59;
        if (r34 != null) goto L37;
        int r36 = 43;
    L38:
        int r37 = r35 + r36;
        ExcelTypeEnum r38 = u();
        int r39 = r37 * 59;
        if (r38 != null) goto L41;
        int r40 = 43;
    L42:
        int r41 = r39 + r40;
        Object r42 = v();
        int r43 = r41 * 59;
        if (r42 != null) goto L45;
        int r44 = 43;
    L46:
        int r45 = r43 + r44;
        com.alibaba.excel.c.c r46 = x();
        int r47 = r45 * 59;
        if (r46 != null) goto L49;
        int r48 = 43;
    L50:
        int r49 = r47 + r48;
        com.alibaba.excel.c.a.b r50 = y();
        int r51 = r49 * 59;
        if (r50 != null) goto L53;
        int r52 = 43;
    L54:
        int r53 = r51 + r52;
        File r54 = z();
        int r55 = r53 * 59;
        if (r54 != null) goto L57;
        int r56 = 43;
    L58:
        int r57 = r55 + r56;
        String r58 = A();
        int r59 = r57 * 59;
        if (r58 != null) goto L61;
        int r60 = 43;
    L62:
        int r61 = r59 + r60;
        Set<CellExtraTypeEnum> r62 = B();
        int r63 = r61 * 59;
        if (r62 != null) goto L65;
        int r64 = 43;
    L66:
        int r65 = r63 + r64;
        List<com.alibaba.excel.h.c.b> r66 = C();
        int r67 = r65 * 59;
        if (r66 != null) goto L69;
        int r68 = 43;
    L70:
        int r69 = r67 + r68;
        List<com.alibaba.excel.h.c.b> r70 = D();
        int r71 = r69 * 59;
        if (r70 != null) goto L73;
        int r72 = 43;
    L74:
        Set<Integer> r73 = F();
        int r74 = (r71 + r72) * 59;
        if (r73 == null) goto L79;
        r3 = r73.hashCode();
    L79:
        return r74 + r3;
    L73:
        r72 = r70.hashCode();
        goto L74
    L69:
        r68 = r66.hashCode();
        goto L70
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

    public com.alibaba.excel.h.c.c n() {
        return this.f195a;
    }

    public InputStream o() {
        return this.f196b;
    }

    public File p() {
        return this.c;
    }

    public Charset q() {
        return this.d;
    }

    public Boolean r() {
        return this.e;
    }

    public Boolean s() {
        return this.f;
    }

    public ReadDefaultReturnEnum t() {
        return this.g;
    }

    public ExcelTypeEnum u() {
        return this.h;
    }

    public Object v() {
        return this.i;
    }

    public Boolean w() {
        return this.j;
    }

    public com.alibaba.excel.c.c x() {
        return this.k;
    }

    public com.alibaba.excel.c.a.b y() {
        return this.l;
    }

    public File z() {
        return this.m;
    }
}
