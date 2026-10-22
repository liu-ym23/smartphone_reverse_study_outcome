package com.alibaba.excel.h.c.a;

import com.alibaba.excel.enums.HolderEnum;
import com.alibaba.excel.metadata.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.alibaba.excel.h.c.b f193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f194b;
    private Integer c;
    private String d;
    private Integer e;
    private Map<Integer, com.alibaba.excel.metadata.e> f;
    private f g;
    private Integer h;
    private com.alibaba.excel.metadata.data.f<?> i;
    private Integer j;

    public d() {
    }

    public d(com.alibaba.excel.h.c.b r1, e r2) {
        super(r1, r2);
        this.f193a = r1;
        this.f194b = r2;
        this.c = r1.k();
        this.d = r1.l();
        this.f = new LinkedHashMap();
        this.h = -1;
    }

    public void a(com.alibaba.excel.metadata.data.f<?> r1) {
        this.i = r1;
    }

    public void a(f r1) {
        this.g = r1;
    }

    public void a(Integer r1) {
        this.e = r1;
    }

    @Override // com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, d.class);
    }

    public void b(Integer r1) {
        this.h = r1;
    }

    public void b(Map<Integer, com.alibaba.excel.metadata.e> r3) {
        this.f = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public void c(Integer r1) {
        this.j = r1;
    }

    @Override // com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r0 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (r0.a(this) == true) goto L12;
        return false;
    L12:
        if (super.equals(r5) == true) goto L14;
        return false;
    L14:
        Integer r6 = p();
        Integer r2 = r0.p();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Integer r7 = r();
        Integer r3 = r0.r();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Integer r8 = u();
        Integer r4 = r0.u();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Integer r9 = w();
        Integer r10 = r0.w();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        com.alibaba.excel.h.c.b r11 = n();
        com.alibaba.excel.h.c.b r12 = r0.n();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        e r13 = o();
        e r14 = r0.o();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        String r15 = q();
        String r16 = r0.q();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        Map<Integer, com.alibaba.excel.metadata.e> r17 = s();
        Map<Integer, com.alibaba.excel.metadata.e> r18 = r0.s();
        if (r17 != null) goto L68;
        if (r18 != null) goto L69;
    L70:
        f r19 = t();
        f r20 = r0.t();
        if (r19 != null) goto L75;
        if (r20 != null) goto L76;
    L77:
        com.alibaba.excel.metadata.data.f<?> r21 = v();
        com.alibaba.excel.metadata.data.f<?> r22 = r0.v();
        if (r21 != null) goto L82;
        if (r22 != null) goto L83;
    L84:
        return true;
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
        return HolderEnum.SHEET;
    }

    @Override // com.alibaba.excel.h.c.a.a, com.alibaba.excel.metadata.b
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = p();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Integer r6 = r();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        Integer r10 = u();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Integer r14 = w();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        com.alibaba.excel.h.c.b r18 = n();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        e r22 = o();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        int r25 = r23 + r24;
        String r26 = q();
        int r27 = r25 * 59;
        if (r26 != null) goto L29;
        int r28 = 43;
    L30:
        int r29 = r27 + r28;
        Map<Integer, com.alibaba.excel.metadata.e> r30 = s();
        int r31 = r29 * 59;
        if (r30 != null) goto L33;
        int r32 = 43;
    L34:
        int r33 = r31 + r32;
        f r34 = t();
        int r35 = r33 * 59;
        if (r34 != null) goto L37;
        int r36 = 43;
    L38:
        com.alibaba.excel.metadata.data.f<?> r37 = v();
        int r38 = (r35 + r36) * 59;
        if (r37 == null) goto L43;
        r3 = r37.hashCode();
    L43:
        return r38 + r3;
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

    public com.alibaba.excel.h.c.b n() {
        return this.f193a;
    }

    public e o() {
        return this.f194b;
    }

    public Integer p() {
        return this.c;
    }

    public String q() {
        return this.d;
    }

    public Integer r() {
        return this.e;
    }

    public Map<Integer, com.alibaba.excel.metadata.e> s() {
        return this.f;
    }

    public f t() {
        return this.g;
    }

    public Integer u() {
        return this.h;
    }

    public com.alibaba.excel.metadata.data.f<?> v() {
        return this.i;
    }

    public Integer w() {
        return this.j;
    }
}
