package com.alibaba.excel.j.b.a;

import com.alibaba.excel.enums.HolderEnum;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Map;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    private static final org.slf4j.c g = null;
    private Map<com.alibaba.excel.j.b.b.b, Font> A;
    private Map<com.alibaba.excel.metadata.data.d, Short> B;
    private com.alibaba.excel.j.a.b.b C;
    private Workbook h;
    private Workbook i;
    private com.alibaba.excel.j.b.d j;
    private File k;
    private OutputStream l;
    private Charset m;
    private Boolean n;
    private InputStream o;
    private File p;
    private InputStream q;
    private Boolean r;
    private ExcelTypeEnum s;
    private Boolean t;
    private Map<Integer, c> u;
    private Map<String, c> v;
    private String w;
    private Boolean x;
    private Boolean y;
    private Map<Short, Map<com.alibaba.excel.j.b.b.a, CellStyle>> z;

    static {
        g = org.slf4j.d.a(e.class);
    }

    public Workbook E() {
        return this.h;
    }

    public Workbook F() {
        return this.i;
    }

    public com.alibaba.excel.j.b.d G() {
        return this.j;
    }

    public File H() {
        return this.k;
    }

    public OutputStream I() {
        return this.l;
    }

    public Charset J() {
        return this.m;
    }

    public Boolean K() {
        return this.n;
    }

    public InputStream L() {
        return this.o;
    }

    public File M() {
        return this.p;
    }

    public InputStream N() {
        return this.q;
    }

    public Boolean O() {
        return this.r;
    }

    public ExcelTypeEnum P() {
        return this.s;
    }

    public Boolean Q() {
        return this.t;
    }

    public Map<Integer, c> R() {
        return this.u;
    }

    public Map<String, c> S() {
        return this.v;
    }

    public String T() {
        return this.w;
    }

    public Boolean U() {
        return this.x;
    }

    public Boolean V() {
        return this.y;
    }

    public Map<Short, Map<com.alibaba.excel.j.b.b.a, CellStyle>> W() {
        return this.z;
    }

    public Map<com.alibaba.excel.j.b.b.b, Font> X() {
        return this.A;
    }

    public Map<com.alibaba.excel.metadata.data.d, Short> Y() {
        return this.B;
    }

    public com.alibaba.excel.j.a.b.b Z() {
        return this.C;
    }

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, e.class);
    }

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
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
        Boolean r6 = K();
        Boolean r2 = r0.K();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Boolean r7 = O();
        Boolean r3 = r0.O();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Boolean r8 = Q();
        Boolean r4 = r0.Q();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Boolean r9 = U();
        Boolean r10 = r0.U();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        Boolean r11 = V();
        Boolean r12 = r0.V();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        Workbook r13 = E();
        Workbook r14 = r0.E();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        Workbook r15 = F();
        Workbook r16 = r0.F();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        com.alibaba.excel.j.b.d r17 = G();
        com.alibaba.excel.j.b.d r18 = r0.G();
        if (r17 != null) goto L68;
        if (r18 != null) goto L69;
    L70:
        File r19 = H();
        File r20 = r0.H();
        if (r19 != null) goto L75;
        if (r20 != null) goto L76;
    L77:
        OutputStream r21 = I();
        OutputStream r22 = r0.I();
        if (r21 != null) goto L82;
        if (r22 != null) goto L83;
    L84:
        Charset r23 = J();
        Charset r24 = r0.J();
        if (r23 != null) goto L89;
        if (r24 != null) goto L90;
    L91:
        InputStream r25 = L();
        InputStream r26 = r0.L();
        if (r25 != null) goto L96;
        if (r26 != null) goto L97;
    L98:
        File r27 = M();
        File r28 = r0.M();
        if (r27 != null) goto L103;
        if (r28 != null) goto L104;
    L105:
        InputStream r29 = N();
        InputStream r30 = r0.N();
        if (r29 != null) goto L110;
        if (r30 != null) goto L111;
    L112:
        ExcelTypeEnum r31 = P();
        ExcelTypeEnum r32 = r0.P();
        if (r31 != null) goto L117;
        if (r32 != null) goto L118;
    L119:
        Map<Integer, c> r33 = R();
        Map<Integer, c> r34 = r0.R();
        if (r33 != null) goto L124;
        if (r34 != null) goto L125;
    L126:
        Map<String, c> r35 = S();
        Map<String, c> r36 = r0.S();
        if (r35 != null) goto L131;
        if (r36 != null) goto L132;
    L133:
        String r37 = T();
        String r38 = r0.T();
        if (r37 != null) goto L138;
        if (r38 != null) goto L139;
    L140:
        Map<Short, Map<com.alibaba.excel.j.b.b.a, CellStyle>> r39 = W();
        Map<Short, Map<com.alibaba.excel.j.b.b.a, CellStyle>> r40 = r0.W();
        if (r39 != null) goto L145;
        if (r40 != null) goto L146;
    L147:
        Map<com.alibaba.excel.j.b.b.b, Font> r41 = X();
        Map<com.alibaba.excel.j.b.b.b, Font> r42 = r0.X();
        if (r41 != null) goto L152;
        if (r42 != null) goto L153;
    L154:
        Map<com.alibaba.excel.metadata.data.d, Short> r43 = Y();
        Map<com.alibaba.excel.metadata.data.d, Short> r44 = r0.Y();
        if (r43 != null) goto L159;
        if (r44 != null) goto L160;
    L161:
        com.alibaba.excel.j.a.b.b r45 = Z();
        com.alibaba.excel.j.a.b.b r46 = r0.Z();
        if (r45 != null) goto L166;
        if (r46 != null) goto L167;
    L168:
        return true;
    L167:
        return false;
    L166:
        if (r45.equals(r46) == true) goto L168;
    L160:
        return false;
    L159:
        if (r43.equals(r44) == true) goto L161;
    L153:
        return false;
    L152:
        if (r41.equals(r42) == true) goto L154;
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

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        Boolean r1 = K();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Boolean r6 = O();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        Boolean r10 = Q();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Boolean r14 = U();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        Boolean r18 = V();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        Workbook r22 = E();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        int r25 = r23 + r24;
        Workbook r26 = F();
        int r27 = r25 * 59;
        if (r26 != null) goto L29;
        int r28 = 43;
    L30:
        int r29 = r27 + r28;
        com.alibaba.excel.j.b.d r30 = G();
        int r31 = r29 * 59;
        if (r30 != null) goto L33;
        int r32 = 43;
    L34:
        int r33 = r31 + r32;
        File r34 = H();
        int r35 = r33 * 59;
        if (r34 != null) goto L37;
        int r36 = 43;
    L38:
        int r37 = r35 + r36;
        OutputStream r38 = I();
        int r39 = r37 * 59;
        if (r38 != null) goto L41;
        int r40 = 43;
    L42:
        int r41 = r39 + r40;
        Charset r42 = J();
        int r43 = r41 * 59;
        if (r42 != null) goto L45;
        int r44 = 43;
    L46:
        int r45 = r43 + r44;
        InputStream r46 = L();
        int r47 = r45 * 59;
        if (r46 != null) goto L49;
        int r48 = 43;
    L50:
        int r49 = r47 + r48;
        File r50 = M();
        int r51 = r49 * 59;
        if (r50 != null) goto L53;
        int r52 = 43;
    L54:
        int r53 = r51 + r52;
        InputStream r54 = N();
        int r55 = r53 * 59;
        if (r54 != null) goto L57;
        int r56 = 43;
    L58:
        int r57 = r55 + r56;
        ExcelTypeEnum r58 = P();
        int r59 = r57 * 59;
        if (r58 != null) goto L61;
        int r60 = 43;
    L62:
        int r61 = r59 + r60;
        Map<Integer, c> r62 = R();
        int r63 = r61 * 59;
        if (r62 != null) goto L65;
        int r64 = 43;
    L66:
        int r65 = r63 + r64;
        Map<String, c> r66 = S();
        int r67 = r65 * 59;
        if (r66 != null) goto L69;
        int r68 = 43;
    L70:
        int r69 = r67 + r68;
        String r70 = T();
        int r71 = r69 * 59;
        if (r70 != null) goto L73;
        int r72 = 43;
    L74:
        int r73 = r71 + r72;
        Map<Short, Map<com.alibaba.excel.j.b.b.a, CellStyle>> r74 = W();
        int r75 = r73 * 59;
        if (r74 != null) goto L77;
        int r76 = 43;
    L78:
        int r77 = r75 + r76;
        Map<com.alibaba.excel.j.b.b.b, Font> r78 = X();
        int r79 = r77 * 59;
        if (r78 != null) goto L81;
        int r80 = 43;
    L82:
        int r81 = r79 + r80;
        Map<com.alibaba.excel.metadata.data.d, Short> r82 = Y();
        int r83 = r81 * 59;
        if (r82 != null) goto L85;
        int r84 = 43;
    L86:
        com.alibaba.excel.j.a.b.b r85 = Z();
        int r86 = (r83 + r84) * 59;
        if (r85 == null) goto L91;
        r3 = r85.hashCode();
    L91:
        return r86 + r3;
    L85:
        r84 = r82.hashCode();
        goto L86
    L81:
        r80 = r78.hashCode();
        goto L82
    L77:
        r76 = r74.hashCode();
        goto L78
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
}
