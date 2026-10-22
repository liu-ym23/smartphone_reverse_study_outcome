package com.alibaba.excel.h.c;

import com.alibaba.excel.enums.CellExtraTypeEnum;
import com.alibaba.excel.enums.ReadDefaultReturnEnum;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExcelTypeEnum f199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InputStream f200b;
    private File c;
    private Charset d;
    private Boolean e;
    private Boolean f;
    private Object g;
    private com.alibaba.excel.c.c h;
    private Boolean i;
    private com.alibaba.excel.c.a.b j;
    private String k;
    private String l;
    private Boolean m;
    private ReadDefaultReturnEnum n;
    private Set<CellExtraTypeEnum> o;

    public c() {
    }

    public void a(ExcelTypeEnum r1) {
        this.f199a = r1;
    }

    public void a(InputStream r1) {
        this.f200b = r1;
    }

    @Override // com.alibaba.excel.h.c.a, com.alibaba.excel.metadata.d
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, c.class);
    }

    @Override // com.alibaba.excel.h.c.a, com.alibaba.excel.metadata.d
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r0 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Boolean r6 = o();
        Boolean r2 = r0.o();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Boolean r7 = p();
        Boolean r3 = r0.p();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Boolean r8 = s();
        Boolean r4 = r0.s();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Boolean r9 = w();
        Boolean r10 = r0.w();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        ExcelTypeEnum r11 = k();
        ExcelTypeEnum r12 = r0.k();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        InputStream r13 = l();
        InputStream r14 = r0.l();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        File r15 = m();
        File r16 = r0.m();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        Charset r17 = n();
        Charset r18 = r0.n();
        if (r17 != null) goto L68;
        if (r18 != null) goto L69;
    L70:
        Object r19 = q();
        Object r20 = r0.q();
        if (r19 != null) goto L75;
        if (r20 != null) goto L76;
    L77:
        com.alibaba.excel.c.c r21 = r();
        com.alibaba.excel.c.c r22 = r0.r();
        if (r21 != null) goto L82;
        if (r22 != null) goto L83;
    L84:
        com.alibaba.excel.c.a.b r23 = t();
        com.alibaba.excel.c.a.b r24 = r0.t();
        if (r23 != null) goto L89;
        if (r24 != null) goto L90;
    L91:
        String r25 = u();
        String r26 = r0.u();
        if (r25 != null) goto L96;
        if (r26 != null) goto L97;
    L98:
        String r27 = v();
        String r28 = r0.v();
        if (r27 != null) goto L103;
        if (r28 != null) goto L104;
    L105:
        ReadDefaultReturnEnum r29 = x();
        ReadDefaultReturnEnum r30 = r0.x();
        if (r29 != null) goto L110;
        if (r30 != null) goto L111;
    L112:
        Set<CellExtraTypeEnum> r31 = y();
        Set<CellExtraTypeEnum> r32 = r0.y();
        if (r31 != null) goto L117;
        if (r32 != null) goto L118;
    L119:
        return true;
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

    @Override // com.alibaba.excel.h.c.a, com.alibaba.excel.metadata.d
    public int hashCode() {
        int r0 = super.hashCode();
        Boolean r1 = o();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Boolean r6 = p();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        Boolean r10 = s();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Boolean r14 = w();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        ExcelTypeEnum r18 = k();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        InputStream r22 = l();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        int r25 = r23 + r24;
        File r26 = m();
        int r27 = r25 * 59;
        if (r26 != null) goto L29;
        int r28 = 43;
    L30:
        int r29 = r27 + r28;
        Charset r30 = n();
        int r31 = r29 * 59;
        if (r30 != null) goto L33;
        int r32 = 43;
    L34:
        int r33 = r31 + r32;
        Object r34 = q();
        int r35 = r33 * 59;
        if (r34 != null) goto L37;
        int r36 = 43;
    L38:
        int r37 = r35 + r36;
        com.alibaba.excel.c.c r38 = r();
        int r39 = r37 * 59;
        if (r38 != null) goto L41;
        int r40 = 43;
    L42:
        int r41 = r39 + r40;
        com.alibaba.excel.c.a.b r42 = t();
        int r43 = r41 * 59;
        if (r42 != null) goto L45;
        int r44 = 43;
    L46:
        int r45 = r43 + r44;
        String r46 = u();
        int r47 = r45 * 59;
        if (r46 != null) goto L49;
        int r48 = 43;
    L50:
        int r49 = r47 + r48;
        String r50 = v();
        int r51 = r49 * 59;
        if (r50 != null) goto L53;
        int r52 = 43;
    L54:
        int r53 = r51 + r52;
        ReadDefaultReturnEnum r54 = x();
        int r55 = r53 * 59;
        if (r54 != null) goto L57;
        int r56 = 43;
    L58:
        Set<CellExtraTypeEnum> r57 = y();
        int r58 = (r55 + r56) * 59;
        if (r57 == null) goto L63;
        r3 = r57.hashCode();
    L63:
        return r58 + r3;
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

    public ExcelTypeEnum k() {
        return this.f199a;
    }

    public InputStream l() {
        return this.f200b;
    }

    public File m() {
        return this.c;
    }

    public Charset n() {
        return this.d;
    }

    public Boolean o() {
        return this.e;
    }

    public Boolean p() {
        return this.f;
    }

    public Object q() {
        return this.g;
    }

    public com.alibaba.excel.c.c r() {
        return this.h;
    }

    public Boolean s() {
        return this.i;
    }

    public com.alibaba.excel.c.a.b t() {
        return this.j;
    }

    public String u() {
        return this.k;
    }

    public String v() {
        return this.l;
    }

    public Boolean w() {
        return this.m;
    }

    public ReadDefaultReturnEnum x() {
        return this.n;
    }

    public Set<CellExtraTypeEnum> y() {
        return this.o;
    }
}
