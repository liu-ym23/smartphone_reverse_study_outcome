package com.alibaba.excel.j.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.alibaba.excel.metadata.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f232b;
    private List<Object> c;
    private Boolean d;
    private Boolean e;
    private Collection<Integer> f;
    private Collection<String> g;
    private Collection<Integer> h;
    private Collection<String> i;
    private Boolean j;

    public a() {
        this.c = new ArrayList();
    }

    @Override // com.alibaba.excel.metadata.d
    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, a.class);
    }

    @Override // com.alibaba.excel.metadata.d
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
        Integer r6 = i();
        Integer r2 = r0.i();
        if (r6 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        Boolean r7 = j();
        Boolean r3 = r0.j();
        if (r7 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Boolean r8 = l();
        Boolean r4 = r0.l();
        if (r8 != null) goto L33;
        if (r4 != null) goto L34;
    L35:
        Boolean r9 = m();
        Boolean r10 = r0.m();
        if (r9 != null) goto L40;
        if (r10 != null) goto L41;
    L42:
        Boolean r11 = r();
        Boolean r12 = r0.r();
        if (r11 != null) goto L47;
        if (r12 != null) goto L48;
    L49:
        List<Object> r13 = k();
        List<Object> r14 = r0.k();
        if (r13 != null) goto L54;
        if (r14 != null) goto L55;
    L56:
        Collection<Integer> r15 = n();
        Collection<Integer> r16 = r0.n();
        if (r15 != null) goto L61;
        if (r16 != null) goto L62;
    L63:
        Collection<String> r17 = o();
        Collection<String> r18 = r0.o();
        if (r17 != null) goto L68;
        if (r18 != null) goto L69;
    L70:
        Collection<Integer> r19 = p();
        Collection<Integer> r20 = r0.p();
        if (r19 != null) goto L75;
        if (r20 != null) goto L76;
    L77:
        Collection<String> r21 = q();
        Collection<String> r22 = r0.q();
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

    @Override // com.alibaba.excel.metadata.d
    public int hashCode() {
        int r0 = super.hashCode();
        Integer r1 = i();
        int r2 = r0 * 59;
        int r3 = 43;
        if (r1 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r2 + r4;
        Boolean r6 = j();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        int r9 = r7 + r8;
        Boolean r10 = l();
        int r11 = r9 * 59;
        if (r10 != null) goto L13;
        int r12 = 43;
    L14:
        int r13 = r11 + r12;
        Boolean r14 = m();
        int r15 = r13 * 59;
        if (r14 != null) goto L17;
        int r16 = 43;
    L18:
        int r17 = r15 + r16;
        Boolean r18 = r();
        int r19 = r17 * 59;
        if (r18 != null) goto L21;
        int r20 = 43;
    L22:
        int r21 = r19 + r20;
        List<Object> r22 = k();
        int r23 = r21 * 59;
        if (r22 != null) goto L25;
        int r24 = 43;
    L26:
        int r25 = r23 + r24;
        Collection<Integer> r26 = n();
        int r27 = r25 * 59;
        if (r26 != null) goto L29;
        int r28 = 43;
    L30:
        int r29 = r27 + r28;
        Collection<String> r30 = o();
        int r31 = r29 * 59;
        if (r30 != null) goto L33;
        int r32 = 43;
    L34:
        int r33 = r31 + r32;
        Collection<Integer> r34 = p();
        int r35 = r33 * 59;
        if (r34 != null) goto L37;
        int r36 = 43;
    L38:
        Collection<String> r37 = q();
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

    public Integer i() {
        return this.f231a;
    }

    public Boolean j() {
        return this.f232b;
    }

    public List<Object> k() {
        return this.c;
    }

    public Boolean l() {
        return this.d;
    }

    public Boolean m() {
        return this.e;
    }

    public Collection<Integer> n() {
        return this.f;
    }

    public Collection<String> o() {
        return this.g;
    }

    public Collection<Integer> p() {
        return this.h;
    }

    public Collection<String> q() {
        return this.i;
    }

    public Boolean r() {
        return this.j;
    }
}
