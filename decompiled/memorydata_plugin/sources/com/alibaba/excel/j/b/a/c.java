package com.alibaba.excel.j.b.a;

import com.alibaba.excel.enums.HolderEnum;
import com.alibaba.excel.enums.WriteLastRowTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.apache.poi.ss.usermodel.Sheet;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    private com.alibaba.excel.j.b.b g;
    private Sheet h;
    private Sheet i;
    private Integer j;
    private String k;
    private e l;
    private Map<Integer, d> m;
    private WriteLastRowTypeEnum n;
    private Integer o;

    public c() {
    }

    public com.alibaba.excel.j.b.b E() {
        return this.g;
    }

    public Sheet F() {
        return this.h;
    }

    public Sheet G() {
        return this.i;
    }

    public Integer H() {
        return this.j;
    }

    public String I() {
        return this.k;
    }

    public e J() {
        return this.l;
    }

    public Map<Integer, d> K() {
        return this.m;
    }

    public WriteLastRowTypeEnum L() {
        return this.n;
    }

    public Integer M() {
        return this.o;
    }

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, c.class);
    }

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
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
        Integer r6 = H();
        Integer r2 = r0.H();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Integer r7 = M();
        Integer r3 = r0.M();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        com.alibaba.excel.j.b.b r8 = E();
        com.alibaba.excel.j.b.b r4 = r0.E();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Sheet r9 = F();
        Sheet r10 = r0.F();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        Sheet r11 = G();
        Sheet r12 = r0.G();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        String r13 = I();
        String r14 = r0.I();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        e r15 = J();
        e r16 = r0.J();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        Map<Integer, d> r17 = K();
        Map<Integer, d> r18 = r0.K();
        if (r17 != null) goto L68;
        if (r18 != null) goto L69;
    L70:
        WriteLastRowTypeEnum r19 = L();
        WriteLastRowTypeEnum r20 = r0.L();
        if (r19 != null) goto L75;
        if (r20 != null) goto L76;
    L77:
        return true;
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
        return HolderEnum.SHEET;
    }

    @Override // com.alibaba.excel.j.b.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = H();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Integer r6 = M();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        com.alibaba.excel.j.b.b r10 = E();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Sheet r14 = F();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        Sheet r18 = G();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        String r22 = I();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        int r25 = r23 + r24;
        e r26 = J();
        int r27 = r25 * 59;
        if (r26 != null) goto L29;
        int r28 = 43;
    L30:
        int r29 = r27 + r28;
        Map<Integer, d> r30 = K();
        int r31 = r29 * 59;
        if (r30 != null) goto L33;
        int r32 = 43;
    L34:
        WriteLastRowTypeEnum r33 = L();
        int r34 = (r31 + r32) * 59;
        if (r33 == null) goto L39;
        r3 = r33.hashCode();
    L39:
        return r34 + r3;
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
